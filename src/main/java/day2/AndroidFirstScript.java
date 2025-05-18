package day2;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wrappersDay2And3.GenericWrappersDay2And3;

public class AndroidFirstScript extends GenericWrappersDay2And3 {
    @BeforeMethod
    public void bm() {
        launchApp("Android", "UiAutomator2", System.getProperty("user.dir") + "/apks/leaforg.apk", "com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity");
    }

    @Test
    public void runScript() throws InterruptedException {
        WebElement button = null;
        try {
            button = driver.findElement(AppiumBy.id("android:id/button1"));
            if (eleIsDisplayed(button)) {
                click(button);
            }
        } catch (Exception ignored) {
        }

        WebElement email = driver.findElement(AppiumBy.className("android.widget.EditText"));
        enterData(email, "rajkumar@testleaf.com");
        WebElement pwd = driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]"));
        enterData(pwd, "Leaf@123");
        WebElement login = driver.findElement(AppiumBy.className("android.widget.Button"));
        click(login);
        Thread.sleep(10000);
    }

    @AfterMethod
    public void am() {
        closeApp();
    }
}