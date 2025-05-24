package pages;

import io.appium.java_client.AppiumDriver;
import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        eleIsDisplayed(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"));
    }

    public LoginPage enterUsername(String un) {
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), un);
        return this;
    }

    public LoginPage enterPassword(String pwd) {
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), pwd);
        return this;
    }

    public LoginPage clickLoginButtonForFailureScenarios() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return new LoginPage(driver);
    }

    public HomePage clickLoginButton() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return new HomePage(driver);
    }

}
