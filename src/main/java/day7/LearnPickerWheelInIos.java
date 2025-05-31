package day7;

import org.testng.annotations.Test;
import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnPickerWheelInIos extends GenericWrappers {

    @Test
    public void runCode() {
        launchIosApp("B972173C-B7E4-4193-AE7A-FC2CA70D719C", "", "com.example.apple-samplecode.UICatalog",
                "/apks/UiCatalog.zip");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Picker View"));
        //Recommended
        chooseNextOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        choosePreviousOptionInPickerWheel(Locators.ACCESSIBILITY_ID.asString(),"Green color component value");
        //Not-recommended - Screen size differs (Web Element height and width differs)
        swipeWithinWebElement("up", getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        sleep(2000);
        swipeWithinWebElement("down", getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        // Use if this works (chance of 20% failures)  - Faster solution
        enterValue(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"),"40",false);
        enterValue(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Green color component value"),"140",false);


        sleep(4000);
        closeApp();

    }
}