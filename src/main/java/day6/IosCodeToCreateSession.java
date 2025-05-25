package day6;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class IosCodeToCreateSession extends GenericWrappers {

    @Test
    public void runCode() {
        launchIosApp("B972173C-B7E4-4193-AE7A-FC2CA70D719C", "", "",
                "");
        closeApp();

    }
}