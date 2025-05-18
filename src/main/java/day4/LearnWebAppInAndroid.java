package day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWebAppInAndroid extends GenericWrappers {
    @Test
    public void runCode() {
        launchChromeBrowser("https://www.google.com");
//        deleteChromeCookies();
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Appium Learning");
        pressEnter();
        click(getWebElement(Locators.XPATH.asString(), "//*[contains(text(),'Appium Tutorial')]"));
        closeApp();
    }
}
