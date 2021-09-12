package geekbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String USER_NAME() {
        return USER_NAME;
    }
    public String USER_PASS() {
        return USER_PASS;
    }


    public void checkOpenLoginPage (){
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPath_LoginPage, "Логин");
    }

    public WebElement input_UserName() {
        basePage = new BasePage(driver);
        return basePage.webElement(user);
    }
    public WebElement input_UserPass() {
        basePage = new BasePage(driver);
        return basePage.webElement(pass);
    }

    public void fillDataLoginPage() {
        basePage = new BasePage(driver);
        basePage.enterData(user, USER_NAME);
        basePage.enterData(pass, USER_PASS);
    }

    public void acceptData(){
        basePage = new BasePage(driver);
        basePage.clickButton(button_enter);
    }
}