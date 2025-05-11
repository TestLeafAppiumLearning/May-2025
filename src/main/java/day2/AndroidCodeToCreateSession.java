package day2;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class AndroidCodeToCreateSession extends GenericWrappers {
    @Test
    public void runScript() {
        launchApp("Android", "UiAutomator2", "", "", "");
        closeApp();
    }
}
