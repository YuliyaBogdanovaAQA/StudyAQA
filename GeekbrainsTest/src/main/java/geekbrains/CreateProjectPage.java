package geekbrains;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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
    public void checkOpenCreateProject() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(button_SaveProject, "Создать проект - Все проекты - Проекты");
    }

    public List<WebElement> listFillDropDownMenu() {
        basePage = new BasePage(driver);
        return basePage.listWebElement(new String[]{click_Company, click_businessUnit, click_curator
        ,click_projectRP, click_administrator,click_manager, click_controlGroup});
    }

    public WebElement input_EnterNameProject() {
        return basePage.webElement(xPath_EnterNameProject);
    }

    public void fillRequiredLines() {
        basePage = new BasePage(driver);
        basePage.enterData2(INPUT_DATA, xPath_EnterNameProject);
        basePage.choiceFromDropdownMenu(click_Company, choose_Company);
        basePage.choiceFromDropdownMenu(click_businessUnit, choose_businessUnit);
        basePage.choiceFromDropdownMenu(click_curator, choose_curator);
        basePage.choiceFromDropdownMenu(click_projectRP, choose_projectRP);
        basePage.choiceFromDropdownMenu(click_administrator, choose_administrator);
        basePage.choiceFromDropdownMenu(click_manager, choose_manager);
        basePage.choiceFromDropdownMenu(click_controlGroup, choose_controlGroup);
    }

    public void saveNewProject() {
        basePage.clickButton(button_SaveProject);
    }

    public void checkSaveNewProject() {
        basePage.controlPage(projectPage.xPathLocatorProjectPage()
                , "Все - Проекты - Все проекты - Проекты"
                , "Проект сохранен");
    }
}