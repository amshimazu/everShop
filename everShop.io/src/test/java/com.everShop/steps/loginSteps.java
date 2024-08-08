package com.evershop.steps;

import com.evershop.glue.loginPage;
import com.evershop.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 10;

    public loginSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement clickOnSignButton = wait.until(ExpectedConditions.elementToBeClickable(loginPage.clickOnSignButton));
            clickOnSignButton.click();

            Utils.waitUntilTextIsVisible(driver, loginPage.loginTitle);
            System.out.println("The user clicked on the sign button.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public String loginTitle() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginTitle));
            String loginTitle = titleElement.getText();
            System.out.println("The Login title was validated.");
            return loginTitle;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public void clickCreateAnAccount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement clickCreateAnAccountButton = wait.until(ExpectedConditions.elementToBeClickable(loginPage.clickCreateAnAccountButton));
            clickCreateAnAccountButton.click();

            Utils.waitUntilTextIsVisible(driver, loginPage.createNewAccountTitle);
            System.out.println("The user clicked create a new account.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public String createNewAccountTitle() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.createNewAccountTitle));
            String createNewAccountTitle = titleElement.getText();
            System.out.println("The Create A New Account title was validated.");
            return createNewAccountTitle;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public static void completeAccountRegistration(String fullName, String email, String password, WebDriver driver) {
        if (driver == null){
            System.out.println("The driver object is null. Make sure to initialize it correctly.");
            return;
        }
        enterFullName(fullName, driver);
        enterEmail(email, driver);
        enterPassword(password, driver);
    }
    public static void enterFullName(String fullName, WebDriver driver){
           WebElement userFullName = driver.findElement(loginPage.typeFullName);
           userFullName.sendKeys(fullName);

           System.out.println("The full name enter was: " +fullName);
    }
    public static void  enterEmail(String email, WebDriver driver){
           WebElement userEmail = driver.findElement(loginPage.typeEmail);
           userEmail.sendKeys(email);

           System.out.println("The email entered was: " +email);
    }
    public static void  enterPassword(String password, WebDriver driver){
           WebElement userPassword = driver.findElement(loginPage.typePassword);
           userPassword.sendKeys(password);

           System.out.println("The password entered was: " +password);
    }

    public void clickSignUpButton() {
        WebElement clickSignUpButton = driver.findElement(loginPage.clickOnSignUpButton);
        clickSignUpButton.click();

        System.out.println("The user clicks on the sign up button");

        Utils.waitUntilElementIsVisible(driver, loginPage.shopKidsButton);
    }

    public void typeEmail(String email) {
        WebElement typeEmail = driver.findElement(loginPage.typeEmail);
        typeEmail.sendKeys(email);

        System.out.println("The email entered was: " +email);
    }

    public void typePassword(String password) {
        WebElement typePassword = driver.findElement(loginPage.typePassword);
        typePassword.sendKeys(password);

        System.out.println("The password entered was: " +password);
    }

    public void clickSignButton() {
        WebElement clickSignButton = driver.findElement(loginPage.clickSignButton);
        clickSignButton.click();

        System.out.println("The user clicks on the sign button");

        Utils.waitUntilElementIsVisible(driver, loginPage.shopKidsButton);
    }
}
