package day2;

import org.testng.annotations.Test;
import wrappersDay2And3.GenericWrappersDay2And3;

public class AndroidCodeToLaunchPreInstalledAppWithRightActivity extends GenericWrappersDay2And3 {
    @Test
    public void runScript() {
        launchApp("Android", "UiAutomator2", "",
                "in.amazon.mShop.android.shopping", "com.amazon.mShop.home.HomeActivity");
//        launchApp("Android", "UiAutomator2", System.getProperty("user.dir") + "/apks/Amazon-india.apk", "", "");
        closeApp();
    }
}
