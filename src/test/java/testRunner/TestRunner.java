package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import wrappers.GenericWrappers;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = "pages")

public class TestRunner extends GenericWrappers {
    @Parameters({"platformName","udid","appPackage","appActivity","chromeDriverPort",
            "systemPort","xcodeOrgId","xcodeSigningId","bundleId","app","wdaLocalPort"})
    @BeforeMethod
    public void bm(String platformName, @Optional("") String udid, @Optional("") String appPackage, @Optional("") String appActivity,
                   @Optional("") String chromeDriverPort, @Optional("") String systemPort,
                   @Optional("") String xcodeOrgId, @Optional("") String xcodeSigningId, @Optional("") String bundleId,
                   @Optional("") String app, @Optional("") String wdaLocalPort) {
        String automationName;
        if(platformName.equalsIgnoreCase("android")) {
            automationName = "UiAutomator2";
        } else {
            automationName = "XCUITest";
        }
        launchApp(platformName,udid,appPackage,appActivity,automationName,chromeDriverPort,
                systemPort,xcodeOrgId,xcodeSigningId,bundleId,app,wdaLocalPort,true);
    }

    @AfterMethod
    public void am() {
        closeApp();
    }

}
