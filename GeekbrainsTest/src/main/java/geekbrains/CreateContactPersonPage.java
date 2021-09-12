package geekbrains;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CreateContactPersonPage {
    private String xPath_Page_CreateContactPerson = "//div[@class=\"responsive-cell responsive-cell-no-blocks\"][1]//div[@class=\"control-group control-group-text\"][1]//label";

    private final String lastName = "Chudakov";
    private final String name = "Ivan";
    private final String jobPosition = "engineer";

    private String xPath_lastName = "//div[@class=\"control-group control-group-text\"]//input[@name=\"crm_contact[lastName]\"]";
    private String xPath_firstName = "//div[@class = \"controls\"]//input[@name=\"crm_contact[firstName]\"]";
    private String xPath_jobPosition = "//input[@name=\"crm_contact[jobTitle]\"]";
    private String xPathOverDropDown_company = "//div/a/span[@class=\"select2-chosen\"]";
    private String xPathChooseDropeDown_company = "//div[@id=\"select2-drop\"]//li[5]";
    private String button_SaveClose = "//div[@class=\"container-fluid page-title\"]//button[@class=\"btn btn-success action-button\"]";

    protected WebDriver driver;
    private BasePage basePage;
    private ContactPersonPage contactPersonPage;

    public CreateContactPersonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkOpenCreateContactPersonPage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPath_Page_CreateContactPerson,
                "Создать контактное лицо - Контактные лица - Контрагенты");
    }

    public WebElement xPathOverDropDown_company() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathOverDropDown_company);
    }

    public List <WebElement> listFillInputData() {
        basePage = new BasePage(driver);
        return basePage.listWebElement(new String[]{xPath_lastName, xPath_firstName, xPath_jobPosition});
    }

    public void fillRequiredLines() {
        basePage = new BasePage(driver);
        contactPersonPage = new ContactPersonPage(driver);

        basePage.enterData2(lastName, xPath_lastName);
        basePage.enterData2(name, xPath_firstName);
        basePage.enterData2(jobPosition, xPath_jobPosition);

        basePage.choiceFromDropdownMenu(xPathOverDropDown_company, xPathChooseDropeDown_company);
    }

    public void saveNewProject() {
        basePage = new BasePage(driver);
        basePage.clickButton(button_SaveClose);
    }

    public void checkSaveNewProject() {
        basePage = new BasePage(driver);
        basePage.controlPage(contactPersonPage.getxPath_ContactPerson()
                , "Все - Контактные лица - Контактные лица - Контрагенты"
                , "Контактное лицо сохранено");
    }
}