package geekbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
    private String getxPath_Project = "//div[@class=\"filter-box oro-clearfix-width\"]";
    private String xPathLocatorProjectPage = "//div[@class=\"btn-group\"]//a[@title=\"Создать проект\"]";

    private String button_CreateProject = "//div[@class=\"btn-group\"]//a[@title=\"Создать проект\"]";

    protected WebDriver driver;
    private BasePage basePage;


    public ProjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getxPath_Project() {
        return getxPath_Project;
    }

    public String xPathLocatorProjectPage() {
        return xPathLocatorProjectPage;
    }

    public void goToCreateProject() {
        basePage = new BasePage(driver);
        basePage.webElement(button_CreateProject).click();
    }
}