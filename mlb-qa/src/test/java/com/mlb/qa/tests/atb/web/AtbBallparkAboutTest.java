package com.mlb.qa.tests.atb.web;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.mlb.qa.atb.service.http.AtbHttpService;
import com.mlb.qa.atb.web.page.AtbBallparkAboutPage;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class AtbBallparkAboutTest extends AtbBaseWebTest {
	@Test(dataProvider = "excel_ds")
	@Parameters({ "team_abbrev", "team_about_web" })
	public void checkAboutBallpartInformation(String team_abbrev, String team_about_web) throws JAXBException,
			XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
		Thread thread = Thread.currentThread();
		System.out.println("thread id: " + thread.getId() + " ; threadName: " + thread.getName() + "; team_abbrev: "+ team_abbrev + "; team abount: " + team_about_web);

		String xmlUrl = Configuration.getEnvArg("mobile_url") + "/gen/section_mobile/" + team_abbrev.toLowerCase()
				+ "/ballpark.xml";

		String webBallparkTextDescription = AtbBallparkAboutPage.open(getDriver(), team_about_web)
				.getBallparkTextDescription();		
				
		String backEndBallparkTextDescription = new AtbHttpService().getBallparkInformation(xmlUrl)
				.getBallparkTextDescription();
		
		//exclude special
		backEndBallparkTextDescription = backEndBallparkTextDescription.replace("&amp;", "&").replace("&nbsp;", " ").replace("\n\t", "");
		System.out.println(backEndBallparkTextDescription);

		Assert.assertEquals(webBallparkTextDescription, backEndBallparkTextDescription);
	}

}
