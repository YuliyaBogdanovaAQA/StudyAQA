package geekbrains;

import org.junit.After;
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
        loginPage.loginPage();
        startPage.checkAuthorization();
        startPage.goToProject();
        projectPage.goToCreateProject();
        createProjectPage.fillRequiredLines();
    }

    @Test
    public void testCaseTwo() {
        loginPage.loginPage();
        startPage.checkAuthorization();
        startPage.goToContactPerson();
        contactPersonPage.goToCreateContactPerson();
        createContactPersonPage.fillRequiredLines();
    }
}