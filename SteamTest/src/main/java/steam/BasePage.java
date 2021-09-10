package steam;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void choiceFromDropdownMenu(String locatorXPathSee, String locatorXPathChoice) {
        new Actions(driver)
                .click(webElement(locatorXPathSee))
                .perform();
        webElement(locatorXPathChoice).click();
    }

    public void checkVisibleElement(String xPathVisible, String xPathInVisible) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath(xPathVisible)));
        Assert.assertTrue(webElement
                (xPathInVisible)
                .isDisplayed());
    }

    public void enterData(String locatorXPath, String data) {
        WebElement element = webElement(locatorXPath);
        try {
            Assert.assertNotNull("Element not found", element);
            element.sendKeys(data);
        } catch (IllegalArgumentException ex) {
            ex.getMessage();
        } finally {
            System.out.println(element.getAttribute("value"));
            Assert.assertEquals(data, webElement(locatorXPath).getAttribute("value"));                     //!!!ADD 08.09
        }
    }

    public void clickButton(String xPathLocator) {                                                                  //ADD 08.09
        if (webElement(xPathLocator).isDisplayed() && webElement(xPathLocator).isEnabled()) {
            webElement(xPathLocator).click();
        } else throw new NullPointerException();
    }

    public WebElement webElement(String str) {
        WebElement searchElement = null;
        try {
            searchElement = driver.findElement(By.xpath(str));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            return searchElement;
        }
    }

    public List<WebElement> webElements(String str) {
        List<WebElement> listElements = null;
        try {
            listElements = driver.findElements(By.xpath(str));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return listElements;
    }

    public void checkOpenPage(String locatorXPath, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorXPath)));
        Assert.assertEquals(driver.getTitle(), title);
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