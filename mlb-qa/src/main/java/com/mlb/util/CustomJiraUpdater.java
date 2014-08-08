/*package com.mlb.util;

import java.util.List;

import net.rcarz.jiraclient.JiraClient;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.qaprosoft.carina.core.foundation.jira.IJiraUpdater;
import com.qaprosoft.carina.core.foundation.report.TestResultItem;

public class CustomJiraUpdater implements IJiraUpdater{

	@Override
	public void updateAfterTest(final JiraClient jira, final ITestResult result) throws Exception {
		
	}

	@Override
	public void updateAfterSuite(final JiraClient jira, final ITestContext context, final List<TestResultItem> results) throws Exception {
		
	}
	
}
*/
package com.mlb.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.qaprosoft.carina.core.foundation.jenkins.JenkinsClient;
import com.qaprosoft.carina.core.foundation.jira.IJiraUpdater;
import com.qaprosoft.carina.core.foundation.report.TestResultItem;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;
import com.qaprosoft.carina.core.foundation.utils.SpecialKeywords;

public class CustomJiraUpdater implements IJiraUpdater
{
	
	protected static final Logger LOG = Logger.getLogger(CustomJiraUpdater.class);
	String jiraId="";
	
	protected static String jiraComment ="<TestRun>\n"
			+ "<STATUS>%s</STATUS>\n" //PASS or FAIL
			+ "<JENKINS_JOB>%s</JENKINS_JOB>\n" 
			+ "<TIMEDATE>%s</TIMEDATE>\n" //15:32:52 2014-04-26
			+ "<TESTSUITE>%s</TESTSUITE>\n" //TestNGSuiteName
			+ "<TESTCASE>%s</TESTCASE>\n" //TestCase (TestNG method)
			+ "<browser>%s</browser>\n"
			+ "<browser_version>%s</browser_version>\n"
			+ "<ENV>%s</ENV>\n"
			+ "<selenium_host>%s</selenium_host>\n"
			+ "<app_version>%s</app_version>\n"
			+ "</TestRun>";
	
	
	public void setJiraId(final String id)
	{
		this.jiraId = id;
	}
	
	@Override
	public void updateAfterTest(final JiraClient jira, final ITestResult result) 
	{
		//String description = jiraId.equals("")?result.getMethod().getDescription(): jiraId;
		String id = result.getAttribute(SpecialKeywords.JIRA_TICKET).toString();
		if (id.isEmpty())
			return;
		
		String status = "Fixed";
		//String status = "PASS";
		if(result.getStatus() != 1) {
			//status = "FAIL";
			status = "Incomplete";
		}
			
		String testsuite = result.getMethod().getTestClass().getXmlTest().getSuite().getName();
		String testcase = result.getMethod().getTestClass().getXmlTest().getName();
			
		String comment = generateJiraComment(status, testsuite, testcase);
		commentIssue(jira, id, status, comment);
	}

	@Override
	public void updateAfterSuite(final JiraClient jira, final ITestContext context, final List<TestResultItem> results) throws Exception
	{
		String id = Configuration.get(Parameter.JIRA_SUITE_ID);
		
		if(!StringUtils.isEmpty(id) && !id.equalsIgnoreCase("NULL"))
		{
			String testsuite = context.getSuite().getXmlSuite().getName();			
			String status = "Fixed";
			//String status = "PASS";
			for (TestResultItem result : results)
				if (result.getResult().toString().equalsIgnoreCase("FAIL"))
				{
					status = "Incomplete";
					break;
				}

			String testcase = "";			
			
			String comment = generateJiraComment(status, testsuite, testcase);
			commentIssue(jira, id, status, comment);
		}
	}
	
	private String getCIJobReference()
	{
		String ciTestJob = null;
		if(!Configuration.isNull(Parameter.JENKINS_URL) && !Configuration.isNull(Parameter.JENKINS_JOB))
		{
			JenkinsClient jc = new JenkinsClient(Configuration.get(Parameter.JENKINS_URL));
			ciTestJob = jc.getCurrentJobURL(Configuration.get(Parameter.JENKINS_JOB));
			if(StringUtils.isEmpty(ciTestJob))
				LOG.info("Could not connect to Jenkins!");
		} else
			LOG.info("Specify 'jenkins_url' and 'jenkins_job' in CONFIG to have reference to test job!");
		return ciTestJob;
	}
	private void commentIssue(final JiraClient jira, final String id, final String status, final String comment)
	{
		Issue issue;
		try {
			issue = jira.getIssue(id);

			if("Closed".equals(issue.getStatus().getName())) {
				issue.transition().execute("Reopen Issue");	
			}
			
			issue.transition().field(Field.RESOLUTION, status).execute("Resolve Issue");
			issue.addComment(comment);		
		} catch (JiraException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			//LOG.error("Jira status not updated for '" + id + "': " + e.getMessage() + ". Verify that user '" + Configuration.get(Parameter.JIRA_USER) + "' has enough permission to change item state.");
		}
	}
	private String generateJiraComment(final String status, final String testsuite, final String testcase)
	{
		String date = new SimpleDateFormat(Configuration.get(Parameter.DATE_FORMAT)).format(new Date());
		String jenkinsConsoleLog = getCIJobReference();

		String browser = Configuration.get(Parameter.BROWSER);
		String browserVersion = Configuration.get(Parameter.BROWSER_VERSION);
		String env  = Configuration.get(Parameter.ENV);
		
		String selenium = Configuration.get(Parameter.SELENIUM_HOST);
		String appVersion = Configuration.get(Parameter.APP_VERSION);
		
		return String.format(jiraComment, status, jenkinsConsoleLog, date, testsuite, testcase, browser, browserVersion, env, selenium, appVersion);		
	}
}
