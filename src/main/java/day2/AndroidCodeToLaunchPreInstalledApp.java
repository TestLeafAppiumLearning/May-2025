package day2;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class AndroidCodeToLaunchPreInstalledApp extends GenericWrappers {
    @Test
    public void runScript() {
        launchApp("Android","UiAutomator2","","com.testleaf.leaforg","com.testleaf.leaforg.MainActivity");
        closeApp();
    }
}