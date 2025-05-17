package day3;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnSwipeWithinWebElement extends GenericWrappers {

    @Test
    public void runCode() {
        launchApp("Android", "UiAutomator2",
                "", "com.android.vending", "com.android.vending.AssetBrowserActivity");
        WebElement eleSwipeUpAndDown = driver.findElement(AppiumBy.xpath("(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View)[1]"));
        swipeUpWithinWebElement(eleSwipeUpAndDown);
        sleep(2000);
        swipeDownWithinWebElement(eleSwipeUpAndDown);
        sleep(5000);
        WebElement eleSwipeLeftOrRight = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"About this ad\"]/../android.view.View)[3]"));
        swipeLeftWithinWebElement(eleSwipeLeftOrRight);
        sleep(2000);
        swipeRightWithinWebElement(eleSwipeLeftOrRight);
        closeApp();
    }
}