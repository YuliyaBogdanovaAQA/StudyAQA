package steam;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class LoginPage {
    private final String USER_NAME = "OrdinarySeal";
    private final String USER_PASS = "k2.d5L#>k'#JRKg";
    private final String EMAIL = "Juliete_07";


    private String button_Enter = "//button[@class=\"btn_blue_steamui btn_medium login_btn\"]";
    private String title = "//head//title";
    private String xPath_name = "//*[@id=\"input_username\"]";
    private String xPath_pass = "//*[@id=\"input_password\"]";

    private String xPath_SearchLinkStartPage = "//*[@id=\"store_search_link\"]";
    private String xPath_controlAccount = "//*[@id=\"account_pulldown\"]";

    protected WebDriver driver;
    private BasePage basePage;
    private StartPage startPage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToLoginPage() {
        startPage = new StartPage(driver);
        startPage.goTo(startPage.button_Enter_LoginPage(), button_Enter, title);
    }

    public void authorization() {
        basePage = new BasePage(driver);

        basePage.enterData(xPath_name, USER_NAME);
        basePage.enterData(xPath_pass, USER_PASS);
        basePage.clickButton(button_Enter);

        basePage.checkOpenPage(xPath_SearchLinkStartPage, "Добро пожаловать в Steam");
        Assert.assertEquals(basePage.webElement(xPath_controlAccount)
                .getText().toLowerCase(Locale.ROOT), EMAIL.toLowerCase(Locale.ROOT));
    }
}