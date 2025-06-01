package day6;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import wrappersDay2And3.GenericWrappersDay2And3;

public class LearnCloudExecutionInIos extends GenericWrappersDay2And3 {

    @Test
    public void runCode() {
        launchIosAppInSauceLabs();
        click(driver.findElement(AppiumBy.accessibilityId("Action Sheets")));
        click(driver.findElement(AppiumBy.accessibilityId("Okay / Cancel")));
        click(driver.findElement(AppiumBy.accessibilityId("OK")));
        click(driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton")));
        closeApp();
    }
}
