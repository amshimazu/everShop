package com.evershop.glue;

import org.openqa.selenium.By;

public class inventoryPage {
    public static By clickOnMenSection = By.xpath("//a[text()='Men']");
    public static By addCardButton = By.xpath("//button[span[text()='ADD TO CART']]");
    public static By selectFirstProduct = By.xpath("(//img[@alt])[1]");
    public static By typeQuantity = By.xpath("//input[@name='qty' and @placeholder='Qty']");

    //Size
    public static By sizeL = By.xpath("//a[@href='#' and text()='L']");
    public static By sizeXL = By.xpath("//a[@href='#' and text()='XL']");
    public static By sizeM = By.xpath("//a[@href='#' and text()='M']");
    public static By sizeS = By.xpath("//a[@href='#' and text()='S']");
    public static By sizeX = By.xpath("//a[@href='#' and text()='X']");

    //Color
    public static By colorWhite = By.xpath("//a[@href='#' and text()='White']");
    public static By colorBlack = By.xpath("//a[@href='#' and text()='Black']");
    public static By colorGrey = By.xpath("//a[@href='#' and text()='Grey']");
    public static By colorBlue = By.xpath("//a[@href='#' and text()='Blue']");
    public static By colorBrown = By.xpath("//a[@href='#' and text()='Brown']");
    public static By colorGreen = By.xpath("//a[@href='#' and text()='Green']");
    public static By colorPink = By.xpath("//a[@href='#' and text()='Pink']");
    public static By colorRed = By.xpath("//a[@href='#' and text()='Red']");

    public static By continueShoppingButton = By.xpath("//a[text()='Continue Shopping']");
}
