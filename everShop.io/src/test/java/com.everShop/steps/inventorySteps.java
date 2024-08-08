package com.evershop.steps;

import com.evershop.glue.inventoryPage;
import com.evershop.utils.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class inventorySteps {

    private WebDriver driver;
    private static final int TIMEOUT = 10;

    public inventorySteps(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnMenSection() {
        WebElement clickOnMenSection = driver.findElement(inventoryPage.clickOnMenSection);
        clickOnMenSection.click();
    }

    public void selectFirstProduct() {
        WebElement selectFirstProduct = driver.findElement(inventoryPage.selectFirstProduct);
        selectFirstProduct.click();
        System.out.println("The user selected the first product");

        Utils.waitUntilElementIsVisible(driver,inventoryPage.addCardButton);
    }

    public static void firstProductCharacteristics(String quantity, String size, String color, WebDriver driver) {
        if (driver == null){
            System.out.println("The driver object is null. Make sure to initialize it correctly.");
            return;
        }
        enterQuantity(quantity, driver);
        enterSize(size, driver);
        enterColor(color, driver);
    }

    private static void enterColor(String color, WebDriver driver) {
        if (color == null || color.trim().isEmpty()){
            System.out.println("Color is empty or null. Exiting method.");
            return;
        }
        WebElement colorElement = null;
        switch (color){
            case "White":
                colorElement = driver.findElement(inventoryPage.colorWhite);
                break;
            case "Black":
                colorElement = driver.findElement(inventoryPage.colorBlack);
                break;
            case "Grey":
                colorElement = driver.findElement(inventoryPage.colorGrey);
                break;
            case "Blue":
                colorElement = driver.findElement(inventoryPage.colorBlue);
                break;
            case "Brown":
                colorElement = driver.findElement(inventoryPage.colorBrown);
                break;
            case "Green":
                colorElement = driver.findElement(inventoryPage.colorGreen);
                break;
            case "Pink":
                colorElement = driver.findElement(inventoryPage.colorPink);
                break;
            case "Red":
                colorElement = driver.findElement(inventoryPage.colorRed);
                break;
        }
        if (colorElement != null && colorElement.isDisplayed() && colorElement.isEnabled()) {
            colorElement.click();
            System.out.println("The user selected the color: " + color);
            Utils.waitInSeconds(2);
        } else {
            System.out.println("The selected color is not available: " + color);
        }
    }

    private static void enterSize(String size, WebDriver driver) {
        if (size == null || size.trim().isEmpty()) {
            System.out.println("Size is empty or null. Exiting method.");
            return;
        }
        WebElement sizeElement = null;
        switch (size) {
            case "L":
                sizeElement = driver.findElement(inventoryPage.sizeL);
                break;
            case "XL":
                sizeElement = driver.findElement(inventoryPage.sizeXL);
                break;
            case "M":
                sizeElement = driver.findElement(inventoryPage.sizeM);
                break;
            case "S":
                sizeElement = driver.findElement(inventoryPage.sizeS);
                break;
            case "X":
                sizeElement = driver.findElement(inventoryPage.sizeX);
                break;
            default:
                System.out.println("Size not recognized: " + size);
                return;
        }
        if (sizeElement != null && sizeElement.isDisplayed() && sizeElement.isEnabled()) {
            sizeElement.click();
            System.out.println("The user selected the size: " + size);
            Utils.waitInSeconds(2);
        } else {
            System.out.println("The selected size is not available: " + size);
        }
    }

    private static void enterQuantity(String quantity, WebDriver driver) {
        if (quantity != null){
            WebElement typeQuantity = driver.findElement(inventoryPage.typeQuantity);
            typeQuantity.sendKeys(quantity);
            System.out.println("The user adds the quantity: " + quantity);
        }else{
            System.out.println("The quantity was not specified by the user.");
        }
    }

    public void clickOnAddToCardButton() {
        WebElement clickOnAddToCardButton = driver.findElement(inventoryPage.addCardButton);
        clickOnAddToCardButton.click();
        System.out.println("The user clicks on ADD TO CARD BUTTON");

        Utils.waitUntilElementIsVisible(driver, inventoryPage.continueShoppingButton);
    }
}
