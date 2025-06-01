package day7;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnHybridAppInIos extends GenericWrappers {

    @Test
    public void runCode() {
        launchIosApp("B972173C-B7E4-4193-AE7A-FC2CA70D719C", "", "com.example.apple-samplecode.UICatalog",
                "/apks/UiCatalog.zip");
        swipe("up");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Web View"));
        sleep(5000);
        printContext();
        switchWebView();
//        click(getWebElement(Locators.ID.asString(), "globalnav-menutrigger-button"));
//        sleep(2000);
//        click(getWebElement(Locators.ID.asString(), "globalnav-menutrigger-button"));
        click(getWebElement(Locators.LINK_TEXT.asString(), "Shop iPhone"));
        click(getWebElement(Locators.LINK_TEXT.asString(), "All Models"));
        String a=getText(getWebElement(Locators.XPATH.asString(), "//h3[@class='rf-hcard-content-title']"));
        System.out.println(a);
        sleep(5000);
        closeApp();

    }


}