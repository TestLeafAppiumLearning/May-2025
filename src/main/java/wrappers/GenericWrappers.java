package wrappers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class GenericWrappers {
    public AppiumDriver driver;
    public void launchApp(String platformName, String automationName, String app,
                          String appPackage, String appActivity) {
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
            dc.setCapability("appium:noReset",true);
            driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(),dc);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeApp() {
        if(driver!=null) {
            driver.quit();
        }
    }

    public boolean eleIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void click(WebElement element) {
        element.click();
    }

    public void enterData(WebElement element, String data) {
        element.sendKeys(data);
    }
}
