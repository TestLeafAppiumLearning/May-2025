package day7;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWebAppInIos extends GenericWrappers {
    @Test
    public void runCode() {
        launchSafariBrowser("https://www.google.com","B972173C-B7E4-4193-AE7A-FC2CA70D719C");
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Appium Learning",false);
        click(getWebElement(Locators.NAME.asString(), "q"));
        switchNativeView();
//        System.out.println(driver.getPageSource());
        click(getWebElement(Locators.XPATH.asString(), "//XCUIElementTypeButton[@name=\"Search\"]"));
        switchWebView();
        click(getWebElement(Locators.XPATH.asString(), "//*[contains(text(),'Appium')]"));
        closeApp();
    }
}