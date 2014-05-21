package com.mlb.qa.tests.atb.web;

import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * Created by Administrator on 5/21/2014.
 */
public class AtbBaseWebTest extends UITest {

    @DataProvider(name = "excel_ds", parallel = true)
    public Object[][] readDataFromXLS(ITestContext context) {
        return createTestArgSets(context, "Execute", "Y");
    }
}
