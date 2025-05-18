package day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnScroll extends GenericWrappers {

    @Test
    public void runCode() {
        launchApp("Android", "", "", "",
                "UiAutomator2", "", "",
                "", "", "", "/apks/MultiTouch Test_1.4.2.apk",
                "", false);
        click(getWebElement(Locators.ID.asString(), "com.easylabs.multitouch:id/personalizeButtonYes"));
        click(getWebElement(Locators.ID.asString(), "com.easylabs.multitouch:id/buttonStart"));
        swipe("up");
        swipe("down");
        swipe("left");
        swipe("right");
        pinchInApp();
        zoomInApp();
        closeApp();
    }
}
