package geekbrains;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestGeekbrains {

    private LoginPage loginPage;
    private StartPage startPage;
    private ProjectPage projectPage;
    private CreateProjectPage createProjectPage;
    private ContactPersonPage contactPersonPage;
    private CreateContactPersonPage createContactPersonPage;
    private WebDriver driver;

    @Before
    public void setup() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        startPage = new StartPage(driver);
        projectPage = new ProjectPage(driver);
        createProjectPage = new CreateProjectPage(driver);
        contactPersonPage = new ContactPersonPage(driver);
        createContactPersonPage = new CreateContactPersonPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://crm.geekbrains.space/user/login");
    }

    @After
    public void close() {
        driver.quit();
    }

    @Test
    public void testCaseOne() {
        loginPage.checkOpenLoginPage();
        loginPage.fillDataLoginPage();
        Assert.assertEquals(loginPage.USER_NAME(), loginPage.input_UserName().getAttribute("value"));
        Assert.assertEquals(loginPage.USER_PASS(), loginPage.input_UserPass().getAttribute("value"));
        loginPage.acceptData();
        startPage.checkOpenStartPage();
        Assert.assertTrue(startPage.xPath_checkAuthorization().getText()
                .contains(loginPage.USER_NAME()));
        startPage.goToProject();                                      //см.README
        projectPage.goToCreateProject();
        createProjectPage.checkOpenCreateProject();
        createProjectPage.fillRequiredLines();
        //checking the filling from the keyboard
        Assert.assertNotNull(createProjectPage.input_EnterNameProject().getAttribute("value"));
        //checking the filling from the DropDownMenu
        for (int i = 0; i < createProjectPage.listFillDropDownMenu().size(); i++) {
            Assert.assertNotNull(createProjectPage.listFillDropDownMenu().get(i));
        }
        createProjectPage.saveNewProject();
        createProjectPage.checkSaveNewProject();
    }

    @Test
    public void testCaseTwo() {
        loginPage.checkOpenLoginPage();
        loginPage.fillDataLoginPage();
        Assert.assertEquals(loginPage.USER_NAME(), loginPage.input_UserName().getAttribute("value"));
        Assert.assertEquals(loginPage.USER_PASS(), loginPage.input_UserPass().getAttribute("value"));
        loginPage.acceptData();
        startPage.checkOpenStartPage();
        Assert.assertTrue(startPage.xPath_checkAuthorization().getText().contains(loginPage.USER_NAME()));
        startPage.goToContactPerson();
        contactPersonPage.goToCreateContactPerson();                 //см. README
        createContactPersonPage.checkOpenCreateContactPersonPage();
        createContactPersonPage.fillRequiredLines();
        //checking the filling from the keyboard
        for (int i = 0; i < createContactPersonPage.listFillInputData().size(); i++) {
            Assert.assertNotNull(createContactPersonPage.listFillInputData().get(i).getAttribute("value"));
        }
        //checking the filling from the DropDownMenu
        Assert.assertNotNull(createContactPersonPage.xPathOverDropDown_company());
        createContactPersonPage.saveNewProject();
        createContactPersonPage.checkSaveNewProject();
    }
}