package steam;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class StartPage {
    private String xPath_StartPage = "//div[@id=\"global_header\"]//img";
    private String chooseLeft_TopSellers = "//div[@class=\"home_page_gutter\"]//div[@class=\"gutter_items\"][4]//a[1]";
    private String button_Store_nav_News_StartPage = "//div[@class=\"store_nav\"]/a[2]";
    private String button_Enter_LoginPage = "//a[@class=\"global_action_link\"]";

    ///  !!! !!!!  work only After authorization  !!!!
    private final String EMAIL = "Juliete_07";
    private String xPath_controlAccount = "//*[@id=\"account_pulldown\"]";
    private String xPath_SearchLinkStartPage = "//*[@id=\"store_search_link\"]";
    private String xPath_GoToProfileStartPage = "//*[@id=\"account_dropdown\"]//a[1]";
    private String xPath_droDownProfileStartPage = "//*[@id=\"account_pulldown\"]";


    protected WebDriver driver;
    private BasePage basePage;
    private LoginPage loginPage;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkStartPage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPath_StartPage, "Добро пожаловать в Steam");
    }

    public String getName_TopSaleFromLeftMenu() {
        basePage = new BasePage(driver);
        return basePage.webElement(chooseLeft_TopSellers)
                .getText().toLowerCase(Locale.ROOT);
    }

    public void goToTopSaleFromLeftMenu() {
        basePage = new BasePage(driver);
        basePage.clickElement(chooseLeft_TopSellers);
    }

    public String getName_News_FromStore_nav() {
        basePage = new BasePage(driver);
        return basePage.webElement(button_Store_nav_News_StartPage)
                .getText().toLowerCase(Locale.ROOT);
    }

    public void goToNews_FromStore_nav() {
        basePage = new BasePage(driver);
        basePage.clickElement(button_Store_nav_News_StartPage);
    }

    public void goToLoginPage() {
        loginPage = new LoginPage(driver);
        goTo(button_Enter_LoginPage, loginPage.button_Enter(), loginPage.title());
    }

    public void goTo(String button_Enter_NamePage, String button, String title) {
        basePage = new BasePage(driver);

        String checkNameButton = basePage.webElement(button_Enter_NamePage)
                .getText().toLowerCase(Locale.ROOT);
        basePage.clickElement(button_Enter_NamePage);
        basePage.checkOpenPage(button, "Войти");
        Assert.assertTrue(String.valueOf((basePage.webElement(title)
                .getText().toLowerCase(Locale.ROOT)).contains(checkNameButton)), true);
    }

    // !!!!  work only After authorization  !!!!
    public String EMAIL() {
        return EMAIL;
    }

    public void checkStartPageAuthorization() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPath_SearchLinkStartPage, "Добро пожаловать в Steam");
    }

    public WebElement ElementCheckAuthorization() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPath_controlAccount);
    }

    public String xPath_GoToProfileStartPage() {
        return xPath_GoToProfileStartPage;
    }

    public String checkRightProfile() {
        basePage = new BasePage(driver);

        String nameAttribute = basePage.webElement(xPath_GoToProfileStartPage())
                .getText().toLowerCase(Locale.ROOT);
        return nameAttribute.substring(nameAttribute.lastIndexOf(" ") + 1);
    }

    public void goToProFile() {
        basePage = new BasePage(driver);
        basePage.choiceFromDropdownMenu(xPath_droDownProfileStartPage, xPath_GoToProfileStartPage);
    }
}