package pages;

import io.cucumber.java.en.Given;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
    public HomePage() {
        eleIsDisplayed(getWebElement(Locators.ID.asString(), "tab-t0-0"));
    }

    @Given("Verify Home page is displayed")
    public HomePage verifyMyInfoTabIsDisplayed() {
        eleIsDisplayed(getWebElement(Locators.ID.asString(), "tab-t0-0"));
        return this;
    }
}
