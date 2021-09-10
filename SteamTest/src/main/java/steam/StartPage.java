package steam;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.security.SecureRandom;
import java.util.Locale;

public class StartPage {
    private String xPath_StartPage = "//div[@id=\"global_header\"]//img";
    private String chooseLeft_TopSellers = "//div[@class=\"home_page_gutter\"]//div[@class=\"gutter_items\"][4]//a[1]";
    private String button_Store_nav_News_StartPage = "//div[@class=\"store_nav\"]/a[2]";
    private String button_Enter_LoginPage = "//a[@class=\"global_action_link\"]";

    ///  !!! !!!!  work only After authorization  !!!!
    private String xPath_GoToProfileStartPage = "//*[@id=\"account_dropdown\"]//a[1]";
    private String xPath_droDownProfileStartPage = "//*[@id=\"account_pulldown\"]";


    protected WebDriver driver;
    private BasePage basePage;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkStartPage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPath_StartPage, "Добро пожаловать в Steam");
    }

    public String chooseLeft_TopSellers() {
        return chooseLeft_TopSellers;
    }

    public void chooseFromLeftMenu(String chooseLeft_nameAction, String xPath_nameActionPage, String xPath_nameActionPageForCheck) {
        basePage = new BasePage(driver);

        String checkNameButton = basePage.webElement(chooseLeft_nameAction)
                .getText().toLowerCase(Locale.ROOT);                                                                                     //ADD 08/09

        basePage.clickElement(chooseLeft_nameAction);

        basePage.checkOpenPage(xPath_nameActionPage, "Поиск Steam");

        Assert.assertEquals(checkNameButton                                                                     //ADD 08/09
                , (basePage.webElement(xPath_nameActionPageForCheck)
                        .getText().toLowerCase(Locale.ROOT)));
    }

    public String button_Store_nav_News_StartPage() {
        return button_Store_nav_News_StartPage;
    }

    public void clickButtonFromStore_nav(String button_Store_nav, String xPath_ForCheckPage
            , String title, String xPath_PageTitle) {
        basePage = new BasePage(driver);

        String checkNameButton = basePage.webElement(button_Store_nav)
                .getText().toLowerCase(Locale.ROOT);
        basePage.clickElement(button_Store_nav);
        basePage.checkOpenPage(xPath_ForCheckPage, title);

        Assert.assertTrue(String.valueOf((basePage.webElement(xPath_PageTitle)
                .getText().toLowerCase(Locale.ROOT)).contains(checkNameButton)), true);
    }

    public String button_Enter_LoginPage() {
        return button_Enter_LoginPage;
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

    public String xPath_GoToProfileStartPage(){
        return xPath_GoToProfileStartPage;
    }

    public String xPath_droDownProfileStartPage(){
        return xPath_droDownProfileStartPage;
    }

    public void goToUserFilesFromGlobal_action_menu(String xPath_GoToNameCheckStartPage
            , String xPath_droDownNameCheckStartPage, String XPath_forCheckOpenPage, String title
            , String XPath_forCheckUserOpenPage) {   // где лучше размещать такие методы??? Там откуда они начинаются или там, где завершаются???
        basePage = new BasePage(driver);

        String nameAttribute = basePage.webElement(xPath_GoToNameCheckStartPage)
                .getText().toLowerCase(Locale.ROOT);
        String lastWord = nameAttribute.substring(nameAttribute.lastIndexOf(" ") + 1);
        basePage.choiceFromDropdownMenu(xPath_droDownNameCheckStartPage, xPath_GoToNameCheckStartPage);

        basePage.checkOpenPage(XPath_forCheckOpenPage, title);
        Assert.assertTrue(basePage.webElement(XPath_forCheckUserOpenPage).getText().contains(lastWord));
    }
}