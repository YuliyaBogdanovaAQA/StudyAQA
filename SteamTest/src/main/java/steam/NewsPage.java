package steam;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsPage {

    private String xPath_PageTitle = "//head//title";
    private String titleNews = "Подобранные для вас новости об играх — Новостной центр Steam";
    private String xPath_ForCheckPageNews = "//div[@class=\"eventcalendar_Rows_r3Dia\"]";
    private String xPath_keyForSearch = "//div[@class=\"eventcalendar_PastSection_3FpvG\"]//div[@class=\"eventcalendar_CalendarRow_398u2\"][1]//*[@class=\"eventcalendartile_TileTextAppName_71phF\"]";
    private String xPath_ElementChoose = "//div[@class=\"eventcalendar_PastSection_3FpvG\"]//div[@class=\"eventcalendar_CalendarRow_398u2\"][1]";
    private String XPath_CheckPageChooseNews = "//div[@class=\"partnereventdisplay_EventDetailTitleContainer_3z2NY\"]//a";
    private String xPath_ForCheckRightChoose = "//div[@class=\"apppartnereventspage_AppBannerTitle_1iqjH\"]";
    private String button_Down = "//div[@class=\"apppartnereventspage_ScrollButton_1t_97 apppartnereventspage_Down_3VePR apppartnereventspage_AnimIn_240i5\"]//*[@class=\"SVGIcon_Button SVGIcon_FlatArrow\"]";
    private String button_Up = "//div[@class=\"apppartnereventspage_ScrollButton_1t_97 apppartnereventspage_Up_3vBD2 apppartnereventspage_AnimIn_240i5\"]" +
            "//*[@class=\"SVGIcon_Button SVGIcon_FlatArrow\"]";
    private String button_Close = "//div[@class=\"apppartnereventspage_CloseButton_1_vCR apppartnereventspage_AnimIn_240i5\"]//*";
    private String xPath_VisibleFirst = "//div[@class=\"apppartnereventspage_PartnerEvent_1KsYS partnereventdisplay_InLibraryView_3_SEi\"][1]";
    private String xPath_VisibleSecond = "//div[@class=\"apppartnereventspage_PartnerEvent_1KsYS partnereventdisplay_InLibraryView_3_SEi\"][2]";
    private String xPath_checkList = "//div[@class=\"apppartnereventspage_AppPartnerEventsContainer_3GCEy apppartnereventspage_NoGameLink_2GfPe\"]";

    protected WebDriver driver;
    private BasePage basePage;
    private StartPage startPage;

    public NewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void gotoNewsPage() {
        startPage = new StartPage(driver);
        startPage.clickButtonFromStore_nav(startPage.button_Store_nav_News_StartPage(), xPath_ForCheckPageNews
                , titleNews, xPath_PageTitle);
    }

    public void testOpenNews() {
        basePage = new BasePage(driver);

        String keyForSearch = basePage.webElement(xPath_keyForSearch)
                .getText();
        basePage.webElement(xPath_ElementChoose).click();
        basePage.checkOpenPage(XPath_CheckPageChooseNews
                , "Подобранные для вас новости об играх — Новостной центр Steam");
        Assert.assertEquals(basePage.webElement(xPath_ForCheckRightChoose)
                .getText(), keyForSearch);

        List<WebElement> listElements = basePage.webElements
                (xPath_checkList);
        if (listElements.size() > 1) {
            //Down
            basePage.clickElement(button_Down);
            basePage.checkVisibleElement(xPath_VisibleSecond, xPath_VisibleFirst);

            //Up
            basePage.clickElement(button_Up);
            basePage.checkVisibleElement(xPath_VisibleFirst, xPath_VisibleSecond);
        } else {
            System.out.println("Was found only one element");
        }

        //close
        basePage.clickElement(button_Close); //close
        basePage.checkOpenPage(xPath_ForCheckPageNews
                , "Подобранные для вас новости об играх — Новостной центр Steam");
    }
}