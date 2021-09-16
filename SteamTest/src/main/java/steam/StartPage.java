package steam;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class StartPage {
    private String xPathStartPage = "//div[@id=\"global_header\"]//img";
    private String chooseLeftTopSellers = "//div[@class=\"home_page_gutter\"]//div[@class=\"gutter_items\"][4]//a[1]";
    private String buttonStoreNavNewsStartPage = "//div[@class=\"store_nav\"]/a[2]";
    private String buttonEnterLoginPage = "//a[@class=\"global_action_link\"]";

    ///  !!! !!!!  work only After authorization  !!!!
    private final String EMAIL = "Juliete_07";
    private String xPathControlAccount = "//*[@id=\"account_pulldown\"]";
    private String xPathSearchLinkStartPage = "//*[@id=\"store_search_link\"]";
    private String xPathGoToProfileStartPage = "//*[@id=\"account_dropdown\"]//a[1]";
    private String xPathDroDownProfileStartPage = "//*[@id=\"account_pulldown\"]";


    protected WebDriver driver;
    private BasePage basePage;
    private LoginPage loginPage;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkStartPage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPathStartPage, "Добро пожаловать в Steam");
    }

    public String getNameTopSaleFromLeftMenu() {
        basePage = new BasePage(driver);
        return basePage.webElement(chooseLeftTopSellers)
                .getText().toLowerCase(Locale.ROOT);
    }

    public void goToTopSaleFromLeftMenu() {
        basePage = new BasePage(driver);
        basePage.clickElement(chooseLeftTopSellers);
    }

    public String getNameNewsFromStoreNav() {
        basePage = new BasePage(driver);
        return basePage.webElement(buttonStoreNavNewsStartPage)
                .getText().toLowerCase(Locale.ROOT);
    }

    public void goToNewsFromStoreNav() {
        basePage = new BasePage(driver);
        basePage.clickElement(buttonStoreNavNewsStartPage);
    }

    public void goToLoginPage() {
        loginPage = new LoginPage(driver);
        goTo(buttonEnterLoginPage, loginPage.button_Enter(), loginPage.title());
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
        basePage.checkOpenPage(xPathSearchLinkStartPage, "Добро пожаловать в Steam");
    }

    public WebElement ElementCheckAuthorization() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathControlAccount);
    }

    public String xPathGoToProfileStartPage() {
        return xPathGoToProfileStartPage;
    }

    public String checkRightProfile() {
        basePage = new BasePage(driver);

        String nameAttribute = basePage.webElement(xPathGoToProfileStartPage())
                .getText().toLowerCase(Locale.ROOT);
        return nameAttribute.substring(nameAttribute.lastIndexOf(" ") + 1);
    }

    public void goToProFile() {
        basePage = new BasePage(driver);
        basePage.choiceFromDropdownMenu(xPathDroDownProfileStartPage, xPathGoToProfileStartPage);
    }
}