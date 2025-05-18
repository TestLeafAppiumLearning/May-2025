package day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnHybridAppInAndroid extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
//        printContext();
        switchContext("WEBVIEW_com.testleaf.leaforg");
        enterValue(getWebElement(Locators.TAG_NAME.asString(), "input"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//input)[2]"), "Leaf@123");
        click(getWebElement(Locators.XPATH.asString(), "//button[@type='submit']"));
//        switchNativeView();
        sleep(5000);
        closeApp();
    }

}
