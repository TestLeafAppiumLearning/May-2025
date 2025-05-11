package day2;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class AndroidCodeToLaunchPreInstalledAppWithRightActivity extends GenericWrappers {
    @Test
    public void runScript() {
                launchApp("Android", "UiAutomator2", "",
                        "in.amazon.mShop.android.shopping", "com.amazon.mShop.home.HomeActivity");
//        launchApp("Android", "UiAutomator2", System.getProperty("user.dir") + "/apks/Amazon-india.apk", "", "");
        closeApp();
    }
}
