package wrappersDay2And3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class GenericWrappersDay2And3 {
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
            dc.setCapability("appium:noReset", true);
            dc.setCapability("appium:forceAppLaunch", true);
            dc.setCapability("appium:shouldTerminateApp", true);
            driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void launchAndroidAppInSauceLabs() {
        try {
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:automationName", "UiAutomator2");

            caps.setCapability("appium:app", "storage:filename=leaforg.apk");  // The filename of the mobile app
            caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
            caps.setCapability("appium:platformVersion", "current_major");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", "oauth-appiummay2025-e7ea4");
            sauceOptions.setCapability("accessKey", "b65d0f76-7f8b-42dd-8356-75fd31bdb148");
            sauceOptions.setCapability("build", "Sample");
            sauceOptions.setCapability("name", "Day 2 learning");
            sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            driver = new AndroidDriver(url, caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeApp() {
        if (driver != null) {
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

    private void swipe(int startX, int startY, int endX, int endY) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq = new Sequence(input, 1);
        seq.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(input.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
        seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));
    }

    public void pinch() {
        int maxHeight = driver.manage().window().getSize().getHeight();
        int maxWidth = driver.manage().window().getSize().getWidth();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq = new Sequence(input, 1);
        seq.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.25), (int) (maxHeight * 0.75)));
        seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(input.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput input2 = new PointerInput(PointerInput.Kind.TOUCH, "finger 2");
        Sequence seq2 = new Sequence(input2, 1);
        seq2.addAction(input2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.75), (int) (maxHeight * 0.25)));
        seq2.addAction(input2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq2.addAction(input2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        seq2.addAction(input2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq, seq2));
    }

    public void zoom() {
        int maxHeight = driver.manage().window().getSize().getHeight();
        int maxWidth = driver.manage().window().getSize().getWidth();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq = new Sequence(input, 1);
        seq.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(input.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxWidth * 0.25), (int) (maxHeight * 0.75)));
        seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput input2 = new PointerInput(PointerInput.Kind.TOUCH, "finger 2");
        Sequence seq2 = new Sequence(input2, 1);
        seq2.addAction(input2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        seq2.addAction(input2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq2.addAction(input2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxWidth * 0.75), (int) (maxHeight * 0.25)));
        seq2.addAction(input2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq, seq2));
    }

    public void sleep(int mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void swipeUp() {
        int maxHeight = driver.manage().window().getSize().getHeight();
        int maxWidth = driver.manage().window().getSize().getWidth();
        int startX = (int) (maxWidth * 0.5);
        int startY = (int) (maxHeight * 0.8);
        int endX = (int) (maxWidth * 0.5);
        int endY = (int) (maxHeight * 0.2);
        swipe(startX, startY, endX, endY);
    }

    public void swipeDown() {
        int maxHeight = driver.manage().window().getSize().getHeight();
        int maxWidth = driver.manage().window().getSize().getWidth();
        int startX = (int) (maxWidth * 0.5);
        int startY = (int) (maxHeight * 0.2);
        int endX = (int) (maxWidth * 0.5);
        int endY = (int) (maxHeight * 0.8);
        swipe(startX, startY, endX, endY);
    }

    public void swipeLeft() {
        int maxHeight = driver.manage().window().getSize().getHeight();
        int maxWidth = driver.manage().window().getSize().getWidth();
        int startX = (int) (maxWidth * 0.9);
        int startY = (int) (maxHeight * 0.5);
        int endX = (int) (maxWidth * 0.1);
        int endY = (int) (maxHeight * 0.5);
        swipe(startX, startY, endX, endY);
    }

    public void swipeRight() {
        int maxHeight = driver.manage().window().getSize().getHeight();
        int maxWidth = driver.manage().window().getSize().getWidth();
        int startX = (int) (maxWidth * 0.1);
        int startY = (int) (maxHeight * 0.5);
        int endX = (int) (maxWidth * 0.9);
        int endY = (int) (maxHeight * 0.5);
        swipe(startX, startY, endX, endY);
    }

    public void swipeUpWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = ((int) (eleWidth * 0.5)) + eleStartX;
        int startY = ((int) (eleHeight * 0.9)) + eleStartY;
        int endX = ((int) (eleWidth * 0.5)) + eleStartX;
        int endY = ((int) (eleHeight * 0.1)) + eleStartY;
        swipe(startX, startY, endX, endY);
    }

    public void swipeDownWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = ((int) (eleWidth * 0.5)) + eleStartX;
        int startY = ((int) (eleHeight * 0.1)) + eleStartY;
        int endX = ((int) (eleWidth * 0.5)) + eleStartX;
        int endY = ((int) (eleHeight * 0.9)) + eleStartY;
        swipe(startX, startY, endX, endY);
    }

    public void swipeLeftWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = ((int) (eleWidth * 0.9)) + eleStartX;
        int startY = ((int) (eleHeight * 0.5)) + eleStartY;
        int endX = ((int) (eleWidth * 0.1)) + eleStartX;
        int endY = ((int) (eleHeight * 0.5)) + eleStartY;
        swipe(startX, startY, endX, endY);
    }

    public void swipeRightWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = ((int) (eleWidth * 0.1)) + eleStartX;
        int startY = ((int) (eleHeight * 0.5)) + eleStartY;
        int endX = ((int) (eleWidth * 0.9)) + eleStartX;
        int endY = ((int) (eleHeight * 0.5)) + eleStartY;
        swipe(startX, startY, endX, endY);
    }
}
