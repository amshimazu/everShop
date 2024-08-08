package com.evershop.glue;

import org.openqa.selenium.By;

public class loginPage {
    public static By clickOnSignButton = By.xpath("//a[contains(@href, '/account/login')]");
    public static By loginTitle = By.xpath("//h1[text()='Login']");
    public static By clickCreateAnAccountButton = By.xpath("//a[text()='Create an account']");
    public static By createNewAccountTitle = By.xpath("//h1[text()='Create A New Account']");
    public static By typeFullName = By.xpath("//input[@name='full_name']");
    public static By typeEmail = By.xpath("//input[@name='email']");
    public static By typePassword = By.xpath("//input[@name='password']");
    public static By shopKidsButton = By.xpath("//a[@href='/kids']");
    public static By clickOnSignUpButton = By.xpath("//button[span[text()='SIGN UP']]");
    public static By clickSignButton = By.xpath("//button[span[text()='SIGN IN']]");
}
