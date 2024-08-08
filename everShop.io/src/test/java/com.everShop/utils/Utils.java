package com.evershop.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitUntilElementIsVisible(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        int attempts = 0;
        while (attempts < 3) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            } catch (TimeoutException e) {
                attempts++;
                if (attempts == 4) {
                    throw new TimeoutException("The Element " + element + " was not found or is not visible during the period of time.");
                }
            }
        }
        return null;
    }

    public static WebElement waitUntilTextIsVisible(WebDriver driver, By element) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            throw new TimeoutException("The Element " + element + " was not found or is not visible during the period of time.");
        }
    }

}
