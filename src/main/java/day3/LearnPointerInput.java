package day3;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import wrappersDay2And3.GenericWrappersDay2And3;

public class LearnPointerInput extends GenericWrappersDay2And3 {

    @Test
    public void runCode() {
        launchApp("Android", "UiAutomator2",
                System.getProperty("user.dir") + "/apks/MultiTouch Test_1.4.2.apk", "", "");
        click(driver.findElement(AppiumBy.id("com.easylabs.multitouch:id/personalizeButtonYes")));
        click(driver.findElement(AppiumBy.id("com.easylabs.multitouch:id/buttonStart")));
        swipeUp();
        sleep(2000);
        swipeDown();
        sleep(2000);
        swipeLeft();
        sleep(2000);
        swipeRight();
        sleep(2000);
        closeApp();

    }
}