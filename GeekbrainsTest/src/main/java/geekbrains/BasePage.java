package geekbrains;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
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

    public void checkOpenPage(String locatorXPath, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorXPath)));
        Assert.assertEquals(driver.getTitle(), title);
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

    public void enterData2(String data, String locatorXPath) {
        StringBuilder sb = new StringBuilder();
        data = sb.append(data + " " + (int) (Math.random() * 100)).toString();
        enterData(locatorXPath, data);
        Assert.assertNotEquals(null, webElement(locatorXPath).getAttribute("value"));
    }

    public void choiceFromDropdownMenu(String locatorXPathSee, String locatorXPathChoice) {
        new Actions(driver)
                .click(webElement(locatorXPathSee))
                .perform();
        webElement(locatorXPathChoice).click();
    }

    public void controlPage(String locator, String title, String exspectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        Assert.assertEquals(driver.getTitle(), title);

        Assert.assertEquals(exspectedMessage, driver.findElement(By.cssSelector(".message")).getText());
    }
}