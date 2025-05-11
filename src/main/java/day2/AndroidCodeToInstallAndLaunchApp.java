package day2;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class AndroidCodeToInstallAndLaunchApp extends GenericWrappers {
    @Test
    public void runScript() {
        launchApp("Android", "UiAutomator2", System.getProperty("user.dir") + "/apks/leaforg.apk", "", "");
        closeApp();
    }
}