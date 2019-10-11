package utils;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.List;

public class SeleniumHelper {

    DateTimeUtils dateTimeUtils = new DateTimeUtils();

    public void waitForElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 15);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e) {
            SeleniumDriver.log.info(e.getMessage());
        }
    }

    public void waitForAllElement(List<WebElement> elements) {
        try {
            WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 15);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e) {
            SeleniumDriver.log.info(e.getMessage());
        }
    }

    public void isClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Select select(WebElement element) {
        waitForElement(element);
        Select dropdown = new Select(element);
        return dropdown;
    }

    public void radio(List<WebElement> elements, String option) {
        waitForAllElement(elements);
        int size = elements.size();

        for (int index = 0; index < size; index++) {
            String value = elements.get(index).getText();
            if (value.equalsIgnoreCase(option)) {
                elements.get(index).click();
                break;
            }
        }
    }

    public void autoSearch(List<WebElement> elements, String option) {
        waitForAllElement(elements);
        int size = elements.size();

        for (int index = 0; index < size; index++) {
            String value = elements.get(index).getAttribute("innerText");
            if (value.equalsIgnoreCase(option)) {
                elements.get(index).click();
                break;
            }
        }
    }

    public void mouseHover(WebElement element) {
        waitForElement(element);
        Actions action = new Actions(SeleniumDriver.getDriver());
        action.moveToElement(element).build().perform();
    }

    public void clickElement(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public void waitForAjax() {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) SeleniumDriver.getDriver())
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if (isJqueryUsed) {
            while (true) {
                // JavaScript test to verify jQuery is active or not
                Boolean ajaxIsComplete = (Boolean) (((JavascriptExecutor) SeleniumDriver.getDriver())
                        .executeScript("return jQuery.active == 0"));
                if (ajaxIsComplete)
                    break;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void waitFor(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            SeleniumDriver.log.info(e.getMessage());
        }
    }

    public void verifyTableColumn(WebElement tableElement, int columnIndex, String valueToBeVerified) {
        List<WebElement> rows = null;
        rows = tableElement.findElements(By.xpath("//tbody//tr//td[" + columnIndex + "]"));
        for (WebElement row : rows) {
            Assert.assertEquals(valueToBeVerified, row.getText(), "Value is not matched!");
        }
    }

    public void verifyTableColumn(WebElement tableElement, int columnIndex, LocalDate expectedDate) {
        List<WebElement> cells = tableElement.findElements(By.xpath("//tbody//tr//td[" + columnIndex + "]"));
        for (WebElement cell : cells) {
            LocalDate actualDate = dateTimeUtils.stringToDate(cell.getText().replaceAll(" ", "-"), "dd-MMM-yy", "dd MMM yy");
            dateTimeUtils.verifySameMonth(expectedDate, actualDate);
        }
    }
}
