package steam;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
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

    public void goToProFile() {
        startPage = new StartPage(driver);

        startPage.goToUserFilesFromGlobal_action_menu(startPage.xPath_GoToProfileStartPage()
                , startPage.xPath_droDownProfileStartPage(), XPath_forCheckOpenPage, title
                , XPath_forCheckUserOpenPage);
    }

    public void testChooseTheme() {
        basePage = new BasePage(driver);

        String strCheck = basePage.webElement(button_EditProFile).getText().toLowerCase(Locale.ROOT);
        basePage.clickButton(button_EditProFile);
        Assert.assertTrue(driver.getTitle().toLowerCase(Locale.ROOT)
                .contains(strCheck));

        strCheck = basePage.webElement(button_Theme).getText().toLowerCase(Locale.ROOT);
        basePage.clickButton(button_Theme);
        Assert.assertEquals(strCheck
                , basePage.webElement(xPathForCheckTheme).getText().toLowerCase(Locale.ROOT));

        strCheck = basePage.webElement(xPath_CheckTheme).getAttribute("class");
        basePage.clickButton(xPath_CheckTheme);
        String strCheckBefore = basePage.webElement(xPath_CheckTheme).getAttribute("class");
        Assert.assertNotEquals(strCheck, strCheckBefore);

        basePage.clickButton(button_Save);
        basePage.clickButton(button_CameBackToProFile);

        basePage.checkOpenPage(XPath_forCheckOpenPage,
                "Сообщество Steam :: juliete_07");

        // проверить применилась ли тема можно только так: идем в профиль -> темы и сверяем атрибуты
        basePage.clickButton(xPath_goToProFile);
        basePage.clickButton(button_Theme);

        Assert.assertEquals(strCheckBefore, basePage.webElement(xPath_CheckTheme).getAttribute("class"));

        basePage.clickButton(xPath_ReturnBaseTheme);
        basePage.clickButton(button_Save);
        basePage.clickButton(button_CameBackToProFile);

        basePage.checkOpenPage(XPath_forCheckOpenPage,
                "Сообщество Steam :: juliete_07");
    }
}