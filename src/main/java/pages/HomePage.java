package pages;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
    public HomePage() {
        eleIsDisplayed(getWebElement(Locators.ID.asString(), "tab-t0-0"));
    }

    public HomePage verifyMyInfoTabIsDisplayed() {
        eleIsDisplayed(getWebElement(Locators.ID.asString(), "tab-t0-0"));
        return this;
    }
}
