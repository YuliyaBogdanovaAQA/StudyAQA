package geekbrains;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    private String xPath_StartPage = "//h1[@class=\"logo logo-text\"]";
    private String xPath_checkAuthorization = "//*[@id=\"user-menu\"]//a[@class=\"dropdown-toggle\"]";

    private String chooseMyProject = "//li[@data-route=\"crm_project_my\"]";
    private String overDropDown_Project = "//ul[@class=\"nav nav-multilevel main-menu\"]//li[@class=\"dropdown\"]//a[@href=\"#\"]//span[text()=\"Проекты\"]";

    private String overDropDown_ContAgents = "//ul[@class=\"nav nav-multilevel main-menu\"]//a[@href=\"#\"]//span[text()=\"Контрагенты\"]";
    private String chooseContactPerson = "//ul[@class=\"nav nav-multilevel main-menu\"]//li[@data-route=\"crm_contact_index\"]";


    protected WebDriver driver;
    private BasePage basePage;
    private ProjectPage projectPage;
    private LoginPage loginPage;
    private ContactPersonPage contactPersonPage;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String xPath_StartPage() {
        return xPath_StartPage;
    }

    public void checkAuthorization() {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        Assert.assertTrue(basePage.webElement(xPath_checkAuthorization).getText()
                .contains(loginPage.USER_NAME()));
    }

    public void goToProject() {
        projectPage = new ProjectPage(driver);
        goToSomewhere(xPath_StartPage, chooseMyProject, overDropDown_Project
                , projectPage.getxPath_Project(), "Все - Мои проекты - Все проекты - Проекты");
    }

    public void goToContactPerson() {
        contactPersonPage = new ContactPersonPage(driver);

        goToSomewhere(xPath_StartPage, chooseContactPerson, overDropDown_ContAgents
                , contactPersonPage.getxPath_ContactPerson(), "Контактные лица - Контактные лица - Контрагенты");
    }

    public void goToSomewhere(String xPath_StartPage, String choose,
                              String overDropDown, String getxPath_NeedPage, String title) {
        basePage = new BasePage(driver);

        basePage.checkOpenPage(xPath_StartPage, "Панель инструментов");

        String nameAttribute = basePage.webElement(choose)                                                       //!!ADD 08.09
                .getAttribute("class");
        basePage.choiceFromDropdownMenu(overDropDown, choose);
        basePage.checkOpenPage(getxPath_NeedPage, title);                                                //Go to.....
        Assert.assertNotEquals(nameAttribute
                , basePage.webElement(choose).getAttribute("class"));
    }
}