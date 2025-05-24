package testCases;

import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.ProjectSpecificWrappers;

public class TC002 extends ProjectSpecificWrappers {
    @Test
    public void RunCode() {
        new LoginPage(driver)
                .enterUsername("lokesh@testleaf.com")
                .enterPassword("Leaf@123")
                .clickLoginButtonForFailureScenarios();
    }
}
