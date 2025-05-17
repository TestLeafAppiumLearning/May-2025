package day3;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnPinchAndZoom extends GenericWrappers {

    @Test
    public void runCode() {
        launchApp("Android","UiAutomator2",
                System.getProperty("user.dir")+"/apks/MultiTouch Test_1.4.2.apk","","");
        click(driver.findElement(AppiumBy.id("com.easylabs.multitouch:id/personalizeButtonYes")));
        click(driver.findElement(AppiumBy.id("com.easylabs.multitouch:id/buttonStart")));
        pinch();
        sleep(2000);
        zoom();
        sleep(2000);
        closeApp();
    }
}