package geekbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactPersonPage {
    private String getxPath_ContactPerson = "//a[@title=\"Создать контактное лицо\"]";
    private String button_createContactPerson = "//div[@class=\"row\"]//div[@class=\"btn-group\"]//a";

    protected WebDriver driver;
    private BasePage basePage;

    public ContactPersonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getxPath_ContactPerson() {
        return getxPath_ContactPerson;
    }

    public void goToCreateContactPerson() {
        basePage = new BasePage(driver);
        basePage.clickButton(button_createContactPerson);                               //Go to Create to Contact person
    }
}
