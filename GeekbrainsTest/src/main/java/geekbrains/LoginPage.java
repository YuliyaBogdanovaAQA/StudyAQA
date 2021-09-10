package geekbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final String USER_NAME = "Applanatest1";
    private final String USER_PASS = "Student2020!";
    private String button_enter = "//*[@id=\"_submit\"]";
    private String user = "//form[@id='login-form']//input[@name='_username']";
    private String pass = "//form[@id='login-form']//input[@name='_password']";
    private String xPath_LoginPage = "//h2[@class=\"title\"]";

    protected WebDriver driver;
    private BasePage basePage;
    private StartPage startPage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String USER_NAME() {
        return USER_NAME;
    }

    public void loginPage() {
        basePage = new BasePage(driver);
        startPage = new StartPage(driver);

        basePage.checkOpenPage(xPath_LoginPage, "Логин");
        basePage.enterData(user, USER_NAME);
        basePage.enterData(pass, USER_PASS);
        basePage.clickButton(button_enter);
        basePage.checkOpenPage(startPage.xPath_StartPage(), "Панель инструментов");                    // check of authorization
    }
}