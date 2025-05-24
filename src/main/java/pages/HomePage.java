package pages;

import io.appium.java_client.AppiumDriver;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        eleIsDisplayed(getWebElement(Locators.ID.asString(), "tab-t0-0"));
    }

    public HomePage verifyMyInfoTabIsDisplayed() {
        eleIsDisplayed(getWebElement(Locators.ID.asString(), "tab-t0-0"));
        return this;
    }
}
