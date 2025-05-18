package day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnSwitchBetweenApps extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
        sleep(3000);
        activateOrRelaunchApp("com.android.vending");
        sleep(3000);
        terminateOrStopRunningApp("com.android.vending");
        activateOrRelaunchApp("com.testleaf.leaforg");
        sleep(3000);
//        closeApp();
    }
}
