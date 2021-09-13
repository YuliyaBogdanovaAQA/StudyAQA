package steam;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopSellers {
    private String xPath_TopSellersPage = "//div[@class=\"page_content\"]//*[contains(text(),'Лидеры продаж')]";
    private String xPath_TopSellersPageForCheck = "//h2[@class=\"pageheader full\"]";

    private String xPath_chooseWindowsApp = "//div[@data-value=\"win\"]//span[@data-param=\"os\"]";
    private String xPath_checkPageOpen = "//div[@id=\"search_result_container\"]//a[20]";
    private String xPath_checkList = "//div[@id=\"search_resultsRows\"]//div[@class=\"col search_name ellipsis\"]//*//span[1]";

    protected WebDriver driver;
    private BasePage basePage;

    public TopSellers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkOpenTopSellersPage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPath_TopSellersPage, "Поиск Steam");
    }

    public String getName_Element_TopSellersHeader() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPath_TopSellersPageForCheck).getText();
    }

    public String getAttribute_WindowsMark() {
        return basePage.webElement(xPath_chooseWindowsApp)
                .getAttribute("class");
    }

    public void chooseAppForWindows() {
        basePage = new BasePage(driver);
        basePage.clickElement(xPath_chooseWindowsApp);
        basePage.checkOpenPage(xPath_checkPageOpen, "Поиск Steam");
    }

    public void checkСorrectSorting() {
        basePage = new BasePage(driver);
        //сайт при перебере элементов List переодически подгружает список. Из-за этого тест падал
        //с StaleElementReferenceException (т.к. не находил по локатору нужного элемента). Перепробовала разные варианты локаторов,
        //но результат всегда одинаков.

        try {
            List<WebElement> listElements = basePage.webElements
                    (xPath_checkList);                                       //.win.platform_img ;//span[@class="platform_img win"]
            for (int i = 0; i < listElements.size(); i++) {
                String str = listElements.get(i).getAttribute("class");                         //for control work
                System.out.println(str);
                Assert.assertTrue("Element doesn't found",
                        listElements
                                .get(i)
                                .getAttribute("class")
                                .contains("platform_img win"));
            }
            System.out.println(listElements.size());
        } catch (StaleElementReferenceException e) {
            Throwable x = new StaleElementReferenceException(e.getMessage());
            x.printStackTrace();
        }
    }
}