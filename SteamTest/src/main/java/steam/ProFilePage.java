package steam;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class ProFilePage {

    private String XPathForCheckOpenPage = "//div[@class=\"persona_name\"]";
    private String title = "Сообщество Steam :: juliete_07";
    private String XPathForCheckUserOpenPage = "//*[@class=\"btn_profile_action btn_medium\"]";
    private String xPathForCheckTheme = "//div[@class=\"DialogHeader\"]";

    private String buttonEditProFile = "//*[@class=\"btn_profile_action btn_medium\"]";
    private String buttonTheme = "//*[@class=\"profileeditshell_NavLink_3rtIp\"][4]";
    private String buttonSave = "//button[@class=\"DialogButton _DialogLayout Primary \"]";
    private String buttonCameBackToProFile = "//div[@class=\"profileeditshell_BackToProfileCtn_1YOt2\"]//a";
    private String xPathCheckTheme = "//div[@class=\"profileedit_ItemPickerList_SMUuC\"]/div[5]";
    private String xPathReturnBaseTheme = "//div[@class=\"profileedit_ItemPickerList_SMUuC\"]/div[2]";

    protected WebDriver driver;
    private BasePage basePage;

    public ProFilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkOpenProfilePage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(XPathForCheckOpenPage, title);
    }

    public WebElement checkRightProfilePage() {
        basePage = new BasePage(driver);
        return basePage.webElement(XPathForCheckUserOpenPage);
    }

    public void goToEditProFile() {
        basePage = new BasePage(driver);
        basePage.clickButton(buttonEditProFile);
    }

    public String nameButtonEditProFile() {
        basePage = new BasePage(driver);
        return basePage.webElement(buttonEditProFile).getText().toLowerCase(Locale.ROOT);
    }

    public String getTitle() {
        return driver.getTitle().toLowerCase(Locale.ROOT);
    }

    public String nameButtonTheme() {
        basePage = new BasePage(driver);
        return basePage.webElement(buttonTheme).getText().toLowerCase(Locale.ROOT);
    }

    public void goToTheme() {
        basePage = new BasePage(driver);
        basePage.clickButton(buttonTheme);
    }

    public String nameXPathForCheckTheme() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathForCheckTheme).getText().toLowerCase(Locale.ROOT);
    }

    public String attributeTheme() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathCheckTheme).getAttribute("class");
    }

    public void chooseTheme() {
        basePage = new BasePage(driver);
        basePage.clickButton(xPathCheckTheme);
    }

    public void saveANDbackToProFile() {
        basePage = new BasePage(driver);
        basePage.clickButton(buttonSave);
        basePage.clickButton(buttonCameBackToProFile);
    }

    public void returnFirstTheme() {
        basePage = new BasePage(driver);
        String checkProFile = basePage.webElement(xPathReturnBaseTheme).getAttribute("class");
        basePage.clickButton(xPathReturnBaseTheme);
        Assert.assertNotEquals(checkProFile, basePage.webElement(xPathReturnBaseTheme).getAttribute("class"));

        saveANDbackToProFile();
        basePage.checkOpenPage(XPathForCheckOpenPage,
                "Сообщество Steam :: juliete_07");
    }
}