package day7;

import org.testng.annotations.Test;
import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class IosFirstScriptInRealDevice extends GenericWrappers {

    @Test
    public void runCode() {
        launchIosApp("<UDID of real device>", "<Team ID>", "com.example.apple-samplecode.UICatalog",
                "");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Action Sheets"));
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Okay / Cancel"));
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "OK"));
        click(getWebElement(Locators.XPATH.asString(), "//XCUIElementTypeButton"));
        closeApp();

    }

}