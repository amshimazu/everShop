package com.evershop.stepsDefinitions;

import com.evershop.steps.inventorySteps;
import com.evershop.steps.loginSteps;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;
import java.util.Map;

public class stepsDefinitions {

    private WebDriver driver;
    private Scenario scenario;
    private com.evershop.steps.loginSteps loginSteps;
    private com.evershop.steps.inventorySteps inventorySteps;

    @Before(order = 1)
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/automation/intellij/everShop.io/everShop.io/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginSteps = new loginSteps(driver);
        inventorySteps = new inventorySteps(driver);
    }

    @Before(order = 2)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void screenShot() {
        byte[] evidence = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidence, "image/png", "evidence");
    }

    @Given("the user opens the home page of everShop")
    public void the_user_opens_the_home_page_of_everShop() {
        driver.get("https://demo.evershop.io/");
        screenShot();
    }

    @And("the user clicks on the sign button")
    public void theUserClicksOnTheSignButton() {
        loginSteps.clickOnSignButton();
        screenShot();
    }

    @And("the user validates that the title {string} should be displayed")
    public void theUserValidatesThatTheTitleShouldBeDisplayed(String expectedTitle) {
        String loginTitle = loginSteps.loginTitle();
        Assertions.assertEquals(expectedTitle, loginTitle);
    }

    @Then("the user clicks on create an account")
    public void theUserClicksOnCreateAnAccount() {
        loginSteps.clickCreateAnAccount();
        screenShot();
    }

    @And("the user validates the title {string}")
    public void theUserValidatesTheTitle(String expectedTitle) {
        String createNewAccountTitle = loginSteps.createNewAccountTitle();
        Assertions.assertEquals(expectedTitle, createNewAccountTitle);
    }

    @Then("the user completes the account registration form using the details")
    public void theUserCompletesTheAccountRegistrationFormUsingTheDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        String fullName = data.get(0).get("fullName");
        String email = data.get(0).get("email");
        String password = data.get(0).get("password");

        com.evershop.steps.loginSteps.completeAccountRegistration(fullName,email,password,driver);
    }

    @And("the user clicks on sign up button")
    public void theUserClicksOnSignUpButton() {
        loginSteps.clickSignUpButton();
        screenShot();
    }

    @Then("the user authenticates with the provided email {string} and password {string}")
    public void theUserAuthenticatesWithTheProvidedEmailAndPassword(String email, String password) {
        loginSteps.typeEmail(email);
        loginSteps.typePassword(password);
        loginSteps.clickSignButton();
        screenShot();
    }

    @And("the user clicks on Men section")
    public void theUserClicksOnMenSection() {
        inventorySteps.clickOnMenSection();
        screenShot();
    }

    @And("the user selects the first product")
    public void theUserSelectsTheFirstProduct() {
        inventorySteps.selectFirstProduct();
        screenShot();
    }

    @And("the user specifies the following characteristics for the first product selected:")
    public void theUserSpecifiesTheFollowingCharacteristicsForFirstProducSelected(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        String quantity = data.get(0).get("quantity");
        String size = data.get(0).get("size");
        String color = data.get(0).get("color");

        com.evershop.steps.inventorySteps.firstProductCharacteristics(quantity,size,color,driver);
    }

    @Then("the user clicks on ADD TO CARD button")
    public void theUserClicksOnADDTOCARDButton() {
        screenShot();
        inventorySteps.clickOnAddToCardButton();
    }
}
