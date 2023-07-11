package org.example.cucumber.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.driver.DriverType;
import org.example.driver.WebDriverContext;
import org.example.driver.WebDriverFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CucumberRunner {

    @Before
    public static void setUpClass() {
        // todo - should be replaced with Pico container
        final var driverType = getDriverType();
        final var webDriver = WebDriverFactory.createWebDriver(driverType);
        WebDriverContext.setDriver(webDriver);
    }

    public static DriverType getDriverType() {

        final var driverType = System.getenv("driverType");
        if (driverType == null) {
            return DriverType.CHROME;
        }
        return DriverType.valueOf(driverType.toUpperCase());
    }

    @After
    public static void tearDownClass() {
        WebDriverContext.quitDriver();
    }
}

