package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import wrappers.GenericWrappers;

import java.time.Duration;

public class LoginPage extends GenericWrappers {
    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(id="ios locator")
    WebElement userName;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    @iOSXCUITFindBy(id="ios locator")
    WebElement password;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(id="ios locator")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), Duration.ofSeconds(30)),this);
        eleIsDisplayed(userName);
    }

    @Given("I enter the username as {string}")
    public LoginPage enterUsername(String un) {
        enterValue(userName, un);
        return this;
    }

    @Given("I enter the password as {string}")
    public LoginPage enterPassword(String pwd) {
        enterValue(password, pwd);
        return this;
    }

    @Given("I click the login button for negative case")
    public LoginPage clickLoginButtonForFailureScenarios() {
        click(loginButton);
        return new LoginPage();
    }

    @Given("I click the login button")
    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage();
    }

    @Given("Error message is thrown in login page")
    public LoginPage error_message_is_thrown_in_login_page() {
        eleIsDisplayed(getWebElement(Locators.XPATH.asString(),"//android.widget.TextView[@text=\"User does not exist\"]" ));
        return this;
    }

}
