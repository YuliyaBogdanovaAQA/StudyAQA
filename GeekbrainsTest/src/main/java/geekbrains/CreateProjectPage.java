package geekbrains;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectPage {
    private final String INPUT_DATA = "My Project One";
    private String button_SaveProject = "//div[@class=\"btn-group\"]//button[@class=\"btn btn-success action-button\"]";
    private String xPath_EnterNameProject = "//div/div/div[2]/input";
    private String click_Company = "//div[@class=\"company-container\"]//span[@class=\"select2-chosen\"]";
    private String choose_Company = "//div[@id=\"select2-drop\"]//ul[@class=\"select2-results\"]//li[2]";
    private String click_businessUnit = "//select[@name=\"crm_project[businessUnit]\"]";
    private String choose_businessUnit = "//select[@name=\"crm_project[businessUnit]\"]//option[2]";
    private String click_curator = "//select[@name=\"crm_project[curator]\"]";
    private String choose_curator = "//select[@name=\"crm_project[curator]\"]//option[7]";
    private String click_projectRP = "//select[@name=\"crm_project[rp]\"]";
    private String choose_projectRP = "//select[@name=\"crm_project[rp]\"]//option[7]";
    private String click_administrator = "//select[@name=\"crm_project[administrator]\"]";
    private String choose_administrator = "//select[@name=\"crm_project[administrator]\"]//option[7]";
    private String click_manager = "//select[@name=\"crm_project[manager]\"]";
    private String choose_manager = "//select[@name=\"crm_project[manager]\"]//option[7]";
    private String click_controlGroup = "//div[@class=\"control-group control-group-choice\"]//a";
    private String choose_controlGroup = "//div[@id=\"select2-drop\"]//ul[@class=\"select2-results\"]//li[7]";

    protected WebDriver driver;
    private BasePage basePage;
    private ProjectPage projectPage;

    public CreateProjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillRequiredLines() {
        basePage = new BasePage(driver);
        projectPage = new ProjectPage(driver);

        basePage.enterData2(INPUT_DATA, xPath_EnterNameProject);
        basePage.choiceFromDropdownMenu(click_Company, choose_Company);
        Assert.assertNotNull(click_Company);                                                                      //!!ADD 08.09

        basePage.choiceFromDropdownMenu(click_businessUnit, choose_businessUnit);
        Assert.assertNotNull(click_businessUnit);                                                                 //!!ADD 08.09

        basePage.choiceFromDropdownMenu(click_curator, choose_curator);
        Assert.assertNotNull(click_curator);                                                                      //!!ADD 08.09

        basePage.choiceFromDropdownMenu(click_projectRP, choose_projectRP);
        Assert.assertNotNull(click_projectRP);                                                                    //!!ADD 08.09

        basePage.choiceFromDropdownMenu(click_administrator, choose_administrator);
        Assert.assertNotNull(click_administrator);                                                                //!!ADD 08.09

        basePage.choiceFromDropdownMenu(click_manager, choose_manager);
        Assert.assertNotNull(click_manager);                                                                      //!!ADD 08.09

        basePage.choiceFromDropdownMenu(click_controlGroup, choose_controlGroup);
        Assert.assertNotNull(click_controlGroup);                                                                 //!!ADD 08.09

        basePage.clickButton(button_SaveProject);

        basePage.controlPage(projectPage.xPathLocatorProjectPage()
                , "Все - Проекты - Все проекты - Проекты"
                , "Проект сохранен");
    }
}