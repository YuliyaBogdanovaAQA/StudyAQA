package steam;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class TestSteam {

    private StartPage startPage;
    private TopSellers topSellers;
    private LoginPage loginPage;
    private NewsPage newsPage;
    private ProFilePage proFilePage;
    private WebDriver driver;

    @Before
    public void setup() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        startPage = new StartPage(driver);
        topSellers = new TopSellers(driver);
        loginPage = new LoginPage(driver);
        newsPage = new NewsPage(driver);
        proFilePage = new ProFilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://store.steampowered.com/");
    }

    @After
    public void close() {
        driver.quit();
    }

    @org.junit.Test
    public void testCaseOne() {
        //Проверка работы сортировки по заданному параметру.
        //Шаги: 1. открыть стартову страницы Steam;
        //      2. в левом меню выбрать "Лидеры продаж"
        //      3. в открывшейся странице поиска выбрать "Windows"
        //Ожидаемый результат: на странице отображаютя приложения для Windows с высокими продажами.
        //! реальный результат работы сортировки по уровню продаж проверить не могу, т.к. не могу найти атрибут, отвечающий
        //за такой вид сортировки
        startPage.checkStartPage();
        String nameClickElement = startPage.getName_TopSaleFromLeftMenu();
        startPage.goToTopSaleFromLeftMenu();
        topSellers.checkOpenTopSellersPage();
        Assert.assertEquals(nameClickElement.toLowerCase(Locale.ROOT)
                , topSellers.getName_Element_TopSellersHeader().toLowerCase(Locale.ROOT));
        String markBefore = topSellers.getAttribute_WindowsMark();
        topSellers.chooseAppForWindows();
        Assert.assertNotEquals(markBefore, topSellers.getAttribute_WindowsMark());
        topSellers.checkСorrectSorting();
    }

    @Test
    public void testCaseTwo() {
        //Проверка работы поиска новостных статей.
        //Шаги: 1. открыть стартову страницы Steam;
        //      2. центральном верхнем меню выбрать "Новости"
        //      3. в открывшейся странице кликнуть по названию названию первого раздела.
        //Ожидаемый результат: на странице отображаютя статьи из выбранного раздела.
        //      4. проверить работу кнопок "Up""Down""Close"
        //Ожидаемый результат: переключение на следующую статью вверх или вниз, закрытие подборки новостей.
        //!! Если статья одна тест упадет!!!
        startPage.checkStartPage();
        String nameClickElement = startPage.getName_News_FromStore_nav();
        startPage.goToNews_FromStore_nav();
        newsPage.checkOpenNewsPage();
        Assert.assertTrue(String.valueOf((newsPage.headerForCheck().toLowerCase(Locale.ROOT))
                .contains(nameClickElement)), true);
        String checkedNews = newsPage.keyForSearchNews();
        newsPage.OpenNews();
        newsPage.checkOpenNews();
        Assert.assertEquals(checkedNews, newsPage.keyForCheckRightNews());
        newsPage.checkUP_DOWN();
        newsPage.checkCLOSE();
        newsPage.checkOpenNewsPage();
    }

    @Test
    public void testCaseTree() {
        //Проверить работу страницы авторизации.
        startPage.checkStartPage();
        startPage.goToLoginPage();
        loginPage.EnterData();
        Assert.assertEquals(loginPage.USER_NAME(), loginPage.Input_USER_NAME().getAttribute("value"));
        Assert.assertEquals(loginPage.USER_PASS(), loginPage.Input_USER_PASS().getAttribute("value"));
        loginPage.Enter();
        startPage.checkStartPageAuthorization();
        Assert.assertEquals(startPage.ElementCheckAuthorization().getText().toLowerCase(Locale.ROOT),
                startPage.EMAIL().toLowerCase(Locale.ROOT));
    }

    @Test
    public void testCaseFour() {
        //Проверка работы действия "смена цветового оформления аккаунта" (элемент "Тема")
        //Шаги (очень кратко!): 1. авторизироваться
        //                      2. зайти в профиль пользователя.
        //                      3. поменять тему.
        // Ожидаемый результат: тема изменена
        testCaseTree();
        String checkProFile = startPage.checkRightProfile();
        startPage.goToProFile();
        proFilePage.checkOpenProfilePage();
        Assert.assertTrue(proFilePage.checkRightProfilePage().getText().contains(checkProFile));

        checkProFile = proFilePage.nameButton_EditProFile();
        proFilePage.goTo_EditProFile();
        Assert.assertTrue(proFilePage.getTitle().contains(checkProFile));

        checkProFile = proFilePage.nameButton_Theme();
        proFilePage.goToTheme();
        Assert.assertEquals(checkProFile, proFilePage.name_xPathForCheckTheme());

        checkProFile = proFilePage.attributeTheme();
        proFilePage.chooseTheme();
        Assert.assertNotEquals(checkProFile, proFilePage.attributeTheme());
        String attributeThemeAfterChoose = proFilePage.attributeTheme();
        proFilePage.save_AND_backToProFile();
        proFilePage.checkOpenProfilePage();

        //проверка применения темы.
        checkProFile = proFilePage.nameButton_EditProFile();
        proFilePage.goTo_EditProFile();
        Assert.assertTrue(proFilePage.getTitle().contains(checkProFile));

        checkProFile = proFilePage.nameButton_Theme();
        proFilePage.goToTheme();
        Assert.assertEquals(checkProFile, proFilePage.name_xPathForCheckTheme());

        Assert.assertEquals(proFilePage.attributeTheme(), attributeThemeAfterChoose);

        //возврат первоначальной темы
        proFilePage.returnFirstTheme();
    }
}