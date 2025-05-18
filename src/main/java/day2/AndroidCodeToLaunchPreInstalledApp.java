package day2;

import org.testng.annotations.Test;
import wrappersDay2And3.GenericWrappersDay2And3;

public class AndroidCodeToLaunchPreInstalledApp extends GenericWrappersDay2And3 {
    @Test
    public void runScript() {
        launchApp("Android", "UiAutomator2", "", "com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity");
        closeApp();
    }
}