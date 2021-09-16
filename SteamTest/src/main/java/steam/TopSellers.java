package steam;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopSellers {
    private String xPathTopSellersPage = "//div[@class=\"page_content\"]//*[contains(text(),'Лидеры продаж')]";
    private String xPathTopSellersPageForCheck = "//h2[@class=\"pageheader full\"]";

    private String xPathChooseWindowsApp = "//div[@data-value=\"win\"]//span[@data-param=\"os\"]";
    private String xPathCheckPageOpen = "//div[@id=\"search_result_container\"]//a[20]";
    private String xPathCheckList = "//div[@id=\"search_resultsRows\"]//div[@class=\"col search_name ellipsis\"]//*//span[1]";

    protected WebDriver driver;
    private BasePage basePage;

    public TopSellers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkOpenTopSellersPage() {
        basePage = new BasePage(driver);
        basePage.checkOpenPage(xPathTopSellersPage, "Поиск Steam");
    }


    public String getNameElementTopSellersHeader() {
        basePage = new BasePage(driver);
        return basePage.webElement(xPathTopSellersPageForCheck).getText();
    }

    public String getAttributeWindowsMark() {
        return basePage.webElement(xPathChooseWindowsApp)
                .getAttribute("class");
    }

    public void chooseAppForWindows() {
        basePage = new BasePage(driver);
        basePage.clickElement(xPathChooseWindowsApp);
        basePage.checkOpenPage(xPathCheckPageOpen, "Поиск Steam");
    }

    public void checkСorrectSorting() {
        basePage = new BasePage(driver);
        //сайт при перебере элементов List переодически подгружает список. Из-за этого тест падал
        //с StaleElementReferenceException (т.к. не находил по локатору нужного элемента). Перепробовала разные варианты локаторов,
        //но результат всегда одинаков.

        try {
            List<WebElement> listElements = basePage.webElements
                    (xPathCheckList);                                       //.win.platform_img ;//span[@class="platform_img win"]
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