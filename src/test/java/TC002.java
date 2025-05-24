import pages.LoginPage;
import wrappers.GenericWrappers;

public class TC002 {
    public static void main(String[] args) {
        new GenericWrappers()
                .launchAndroidApp("com.testleaf.leaforg",
                "com.testleaf.leaforg.MainActivity","UiAutomator2","/apks/leaforg.apk");
        new LoginPage()
                .enterUsername("lokesh@testleaf.com")
                .enterPassword("Leaf@123")
                .clickLoginButtonForFailureScenarios();
        new GenericWrappers()
                .closeApp();
    }
}
