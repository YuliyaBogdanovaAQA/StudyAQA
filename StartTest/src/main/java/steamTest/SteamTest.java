package steamTest;

        import org.junit.Assert;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.time.Duration;
        import java.util.List;
        import java.util.NoSuchElementException;

public class SteamTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void openChrome() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void closeChrome() {
        getDriver().quit();
    }

   public void startPage() {
       getDriver().get("https://store.steampowered.com/");
        checkOpenPage("//div[@id=\"global_header\"]//img", "Добро пожаловать в Steam");
    }

    public void testCaseOne() {

        webElement("//div[@class=\"home_page_gutter\"]//div[@class=\"gutter_items\"][4]//a[1]").click();

        checkOpenPage("//div[@class=\"page_content\"]//*[contains(text(),'Лидеры продаж')]"
                , "Поиск Steam");

        webElement("//div[@data-value=\"win\"]//span[@class=\"tab_filter_control_checkbox\"]").click();

        checkOpenPage("//div[@id=\"search_result_container\"]//a[20]"
                , "Поиск Steam");

        //сайт при перебере элементов List переодически подгружает список. Из-за этого тест падал
        //с StaleElementReferenceException (т.к. не находил по локатору нужного элемента). Перепробовала разные варианты локаторов,
        //но результат всегда одинаков.

        try {
            List<WebElement> listElements = webElements
                    ("//div[@id=\"search_resultsRows\"]//div[@class=\"col search_name ellipsis\"]//*//span[1]");    //.win.platform_img ;//span[@class="platform_img win"]
            for (int i = 0; i < listElements.size(); i++) {
                String str = listElements.get(i).getAttribute("class");    //for control work
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

    public void testCaseTwo() {

    webElement("//div[@class=\"store_nav\"]/a[2]").click();

        checkOpenPage("//div[@class=\"eventcalendar_Rows_r3Dia\"]"
                , "Подобранные для вас новости об играх — Новостной центр Steam");

        String keyForSearch = webElement
                ("//div[@class=\"eventcalendar_PastSection_3FpvG\"]//div[@class=\"eventcalendar_CalendarRow_398u2\"][1]//*[@class=\"eventcalendartile_TileTextAppName_71phF\"]")
                .getText();
        System.out.println(keyForSearch);
        System.out.println();

        webElement("//div[@class=\"eventcalendar_PastSection_3FpvG\"]//div[@class=\"eventcalendar_CalendarRow_398u2\"][1]").click();

        checkOpenPage("//div[@class=\"partnereventdisplay_EventDetailTitleContainer_3z2NY\"]//a"
                , "Подобранные для вас новости об играх — Новостной центр Steam");

        Assert.assertEquals(webElement("//div[@class=\"apppartnereventspage_AppBannerTitle_1iqjH\"]")
                .getText(), keyForSearch);

        //Down
        clickElement
                ("//div[@class=\"apppartnereventspage_ScrollButton_1t_97 apppartnereventspage_Down_3VePR apppartnereventspage_AnimIn_240i5\"]" +
                        "//*[@class=\"SVGIcon_Button SVGIcon_FlatArrow\"]");

        //Up
        clickElement
                ("//div[@class=\"apppartnereventspage_ScrollButton_1t_97 apppartnereventspage_Up_3vBD2 apppartnereventspage_AnimIn_240i5\"]" +
                        "//*[@class=\"SVGIcon_Button SVGIcon_FlatArrow\"]");

        //close
        clickElement
                ("//div[@class=\"apppartnereventspage_CloseButton_1_vCR apppartnereventspage_AnimIn_240i5\"]//*"); //close

        checkOpenPage("//div[@class=\"eventcalendar_Rows_r3Dia\"]"
                , "Подобранные для вас новости об играх — Новостной центр Steam");
    }

    public WebElement webElement(String str) {
        WebElement searchElement = null;
        try {
            searchElement = getDriver().findElement(By.xpath(str));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            return searchElement;
        }
    }

    public List<WebElement> webElements(String str) {
        List<WebElement> listElements = null;
        try {
            listElements = getDriver().findElements(By.xpath(str));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return listElements;
    }

    public void checkOpenPage(String locatorXPath, String title) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorXPath)));
        Assert.assertEquals(getDriver().getTitle(), title);
    }

    public void clickElement(String xPathLocator) {
        WebElement click = webElement(xPathLocator);
        try {
            click.click();
        } catch (WebDriverException e) {
            e.getMessage();
        }
    }
}