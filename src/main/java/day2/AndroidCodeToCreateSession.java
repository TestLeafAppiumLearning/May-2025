package day2;

import org.testng.annotations.Test;
import wrappersDay2And3.GenericWrappersDay2And3;

public class AndroidCodeToCreateSession extends GenericWrappersDay2And3 {
    @Test
    public void runScript() {
        launchApp("Android", "UiAutomator2", "", "", "");
        closeApp();
    }
}
