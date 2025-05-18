package day4;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWrappers extends GenericWrappers {

    @Test
    public void runCode() {
        launchApp("Android", "", "", "",
                "UiAutomator2", "", "",
                "", "", "", "/apks/leaforg.apk",
                "", false);
        WebElement button = null;
        try {
            button = getWebElement(Locators.ID.asString(), "android:id/button1");
            if (eleIsDisplayed(button)) {
                click(button);
            }
        } catch (Exception ignored) {
        }
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), "Leaf@123");
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        takeScreenShot();
        setLandscapeOrientation();
        sleep(2000);
        setPortraitOrientation();
        sleep(2000);
        closeApp();
    }
}
