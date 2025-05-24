package testCases;

import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.ProjectSpecificWrappers;

public class TC001 extends ProjectSpecificWrappers {
    @Test
    public void RunCode() {
        new LoginPage(driver)
                .enterUsername("rajkumar@testleaf.com")
                .enterPassword("Leaf@123")
                .clickLoginButton()
                .verifyMyInfoTabIsDisplayed();
    }
}
