package day6;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class IosFirstScript extends GenericWrappers {

    @Test
    public void runCode() {
        launchIosApp("B972173C-B7E4-4193-AE7A-FC2CA70D719C", "", "com.example.apple-samplecode.UICatalog",
                "/apks/UiCatalog.zip");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Action Sheets"));
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Okay / Cancel"));
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "OK"));
        click(getWebElement(Locators.XPATH.asString(), "//XCUIElementTypeButton"));
        closeApp();

    }

}