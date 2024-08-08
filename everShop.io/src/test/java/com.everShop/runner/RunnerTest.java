package com.evershop.runner;

import  io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/cucumber.json"},
        stepNotifications = true,
        features = "everShop.io/src/test/resources/features",
        glue = "com.evershop.stepsDefinitions",
        tags = "@checkoutProcess"
)
public class RunnerTest {
}
