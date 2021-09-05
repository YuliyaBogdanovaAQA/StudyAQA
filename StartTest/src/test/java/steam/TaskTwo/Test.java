package steam.TaskTwo;

import org.junit.After;
import org.junit.Before;
import steamTest.SteamTest;

public class Test {
    SteamTest steamTest = new SteamTest();

    @Before
    public void openBrowser() {
        steamTest.openChrome();
    }

    @After
    public void closeBrowser() {
        steamTest.closeChrome();
    }

    @org.junit.Test
    public void test() {

        steamTest.startPage();
        steamTest.testCaseOne();
    }

    @org.junit.Test
    public void test2() {

        steamTest.startPage();
        steamTest.testCaseTwo();
    }
}