package steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsPage {

    private String xPathPageTitle = "//head//title";

    private String xPathForCheckPageNews = "//div[@class=\"eventcalendar_Rows_r3Dia\"]";
    private String xPathKeyForSearch = "//div[@class=\"eventcalendar_PastSection_3FpvG\"]//div[@class=\"eventcalendar_CalendarRow_398u2\"][1]//*[@class=\"eventcalendartile_TileTextAppName_71phF\"]";
    private String xPathElementChoose = "//div[@class=\"eventcalendar_PastSection_3FpvG\"]//div[@class=\"eventcalendar_CalendarRow_398u2\"][1]";
    private String XPathCheckPageChooseNews = "//div[@class=\"partnereventdisplay_EventDetailTitleContainer_3z2NY\"]//a";
    private String xPathForCheckRightChoose = "//div[@class=\"apppartnereventspage_AppBannerTitle_1iqjH\"]";
    private String buttonDown = "//div[@class=\"apppartnereventspage_ScrollButton_1t_97 apppartnereventspage_Down_3VePR apppartnereventspage_AnimIn_240i5\"]//*[@class=\"SVGIcon_Button SVGIcon_FlatArrow\"]";
    private String buttonUp = "//div[@class=\"apppartnereventspage_ScrollButton_1t_97 apppartnereventspage_Up_3vBD2 apppartnereventspage_AnimIn_240i5\"]" +
            "//*[@class=\"SVGIcon_Button SVGIcon_FlatArrow\"]";
    private String buttonClose = "//div[@class=\"apppartnereventspage_CloseButton_1_vCR apppartnereventspage_AnimIn_240i5\"]//*";
    private String xPathVisibleFirst = "//div[@class=\"apppartnereventspage_PartnerEvent_1KsYS partnereventdisplay_InLibraryView_3_SEi\"][1]";
    private String xPathVisibleSecond = "//div[@class=\"apppartnereventspage_PartnerEvent_1KsYS partnereventdisplay_InLibraryView_3_SEi\"][2]";
    private String xPathCheckList = "//div[@class=\"apppartnereventspage_AppPartnerEventsContainer_3GCEy apppartnereventspage_NoGameLink_2GfPe\"]";

    protected WebDriver driver;
    private BasePage basePage;

    public NewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkOpenNewsPage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPathForCheckPageNews
                , "Подобранные для вас новости об играх — Новостной центр Steam");
    }

    public String headerForCheck() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathPageTitle).getText();
    }

    public String keyForSearchNews() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathKeyForSearch).getText();
    }

    public String keyForCheckRightNews() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathForCheckRightChoose).getText();
    }

    public void OpenNews() {
        basePage = new BasePage(driver);
        basePage.webElement(xPathElementChoose).click();
    }

    public void checkOpenNews() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(XPathCheckPageChooseNews, "Подобранные для вас новости об играх — Новостной центр Steam");
    }

    public void checkUP_DOWN() {
        List<WebElement> listElements = basePage.webElements
                (xPathCheckList);
        if (listElements.size() > 1) {
            //Down
            basePage.clickElement(buttonDown);
            basePage.checkVisibleElement(xPathVisibleSecond, xPathVisibleFirst);

            //Up
            basePage.clickElement(buttonUp);
            basePage.checkVisibleElement(xPathVisibleFirst, xPathVisibleSecond);
        } else {
            System.out.println("Was found only one element");
        }
    }

    public void checkCLOSE() {
        basePage = new BasePage(driver);
        basePage.clickElement(buttonClose);
    }
}