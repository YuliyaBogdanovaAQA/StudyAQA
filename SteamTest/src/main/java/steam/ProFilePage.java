package steam;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class ProFilePage {

    private String XPath_forCheckOpenPage = "//div[@class=\"persona_name\"]";
    private String title = "Сообщество Steam :: juliete_07";
    private String XPath_forCheckUserOpenPage = "//*[@class=\"btn_profile_action btn_medium\"]";
    private String xPathForCheckTheme = "//div[@class=\"DialogHeader\"]";

    private String button_EditProFile = "//*[@class=\"btn_profile_action btn_medium\"]";
    private String button_Theme = "//*[@class=\"profileeditshell_NavLink_3rtIp\"][4]";
    private String button_Save = "//button[@class=\"DialogButton _DialogLayout Primary \"]";
    private String button_CameBackToProFile = "//div[@class=\"profileeditshell_BackToProfileCtn_1YOt2\"]//a";
    private String xPath_CheckTheme = "//div[@class=\"profileedit_ItemPickerList_SMUuC\"]/div[5]";
    private String xPath_ReturnBaseTheme = "//div[@class=\"profileedit_ItemPickerList_SMUuC\"]/div[2]";

    private String xPath_goToProFile = "//*[@class=\"btn_profile_action btn_medium\"]";

    protected WebDriver driver;
    private BasePage basePage;
    private StartPage startPage;

    public ProFilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkOpenProfilePage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(XPath_forCheckOpenPage, title);
    }

    public WebElement checkRightProfilePage() {
        basePage = new BasePage(driver);
        return basePage.webElement(XPath_forCheckUserOpenPage);
    }

    public void goTo_EditProFile() {
        basePage = new BasePage(driver);
        basePage.clickButton(button_EditProFile);
    }

    public String nameButton_EditProFile() {
        basePage = new BasePage(driver);
        return basePage.webElement(button_EditProFile).getText().toLowerCase(Locale.ROOT);
    }

    public String getTitle() {
        return driver.getTitle().toLowerCase(Locale.ROOT);
    }

    public String nameButton_Theme() {
        basePage = new BasePage(driver);
        return basePage.webElement(button_Theme).getText().toLowerCase(Locale.ROOT);
    }

    public void goToTheme() {
        basePage = new BasePage(driver);
        basePage.clickButton(button_Theme);
    }

    public String name_xPathForCheckTheme() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathForCheckTheme).getText().toLowerCase(Locale.ROOT);
    }

    public String attributeTheme() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPath_CheckTheme).getAttribute("class");
    }

    public void chooseTheme() {
        basePage = new BasePage(driver);
        basePage.clickButton(xPath_CheckTheme);
    }

    public void save_AND_backToProFile() {
        basePage = new BasePage(driver);
        basePage.clickButton(button_Save);
        basePage.clickButton(button_CameBackToProFile);
    }

    public void returnFirstTheme() {
        basePage = new BasePage(driver);
        String checkProFile = basePage.webElement(xPath_ReturnBaseTheme).getAttribute("class");
        basePage.clickButton(xPath_ReturnBaseTheme);
        Assert.assertNotEquals(checkProFile, basePage.webElement(xPath_ReturnBaseTheme).getAttribute("class"));

        save_AND_backToProFile();
        basePage.checkOpenPage(XPath_forCheckOpenPage,
                "Сообщество Steam :: juliete_07");
    }
}