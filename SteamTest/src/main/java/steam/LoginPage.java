package steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final String USER_NAME = "OrdinarySeal";
    private final String USER_PASS = "k2.d5L#>k'#JRKg";

    private String button_Enter = "//button[@class=\"btn_blue_steamui btn_medium login_btn\"]";
    private String title = "//head//title";
    private String xPath_name = "//*[@id=\"input_username\"]";
    private String xPath_pass = "//*[@id=\"input_password\"]";

    protected WebDriver driver;
    private BasePage basePage;
    private StartPage startPage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String button_Enter() {
        return button_Enter;
    }

    public String title() {
        return title;
    }

    public String USER_NAME() {
        return USER_NAME;
    }

    public String USER_PASS() {
        return USER_PASS;
    }

    public WebElement Input_USER_NAME() {
        basePage = new BasePage(driver);
        return basePage.webElement("//*[@id=\"input_username\"]");
    }

    public WebElement Input_USER_PASS() {
        basePage = new BasePage(driver);
        return basePage.webElement("//*[@id=\"input_password\"]");
    }

    public void EnterData() {
        basePage = new BasePage(driver);
        basePage.enterData(xPath_name, USER_NAME);
        basePage.enterData(xPath_pass, USER_PASS);
    }

    public void Enter() {
        basePage = new BasePage(driver);
        basePage.clickButton(button_Enter);
    }
}