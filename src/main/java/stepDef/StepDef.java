package stepDef;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class StepDef {
    AppiumDriver driver;

    @Given("the application is launched")
    public void the_application_is_launched() {
        String platformName = "Android";
        String automationName = "UiAutomator2";
        String app = System.getProperty("user.dir") + "/apks/leaforg.apk";
        String appPackage = "com.testleaf.leaforg";
        String appActivity = "com.testleaf.leaforg.MainActivity";
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("platformName", platformName);
            dc.setCapability("appium:automationName", automationName);
            if (!app.isEmpty()) {
                dc.setCapability("appium:app", app);
            }
            if (!appPackage.isEmpty()) {
                dc.setCapability("appium:appPackage", appPackage);
            }
            if (!appActivity.isEmpty()) {
                dc.setCapability("appium:appActivity", appActivity);
            }
            dc.setCapability("appium:noReset", true);
            dc.setCapability("appium:forceAppLaunch", true);
            dc.setCapability("appium:shouldTerminateApp", true);
            driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    @Given("I enter the username as {string}")
    public void i_enter_the_username_as(String string) {
        WebElement email = driver.findElement(AppiumBy.className("android.widget.EditText"));
        email.sendKeys(string);
    }

    @Given("I enter the password as {string}")
    public void i_enter_the_password_as(String string) {
        WebElement pwd = driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]"));
        pwd.sendKeys(string);
    }

    @Given("I click the login button")
    public void i_click_the_login_button() {
        WebElement login = driver.findElement(AppiumBy.className("android.widget.Button"));
        login.click();
    }

    @Given("Verify Home page is displayed")
    public void verify_home_page_is_displayed() {
        WebElement text = driver.findElement(AppiumBy.xpath("//android.widget.TextView"));
        text.isDisplayed();
    }

    @Given("Error message is thrown in login page")
    public void error_message_is_thrown_in_login_page() {
        WebElement error = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"User does not exist\"]"));
        error.isDisplayed();
    }

}
