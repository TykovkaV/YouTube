package org.example.page;

import org.example.driver.WebDriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage() {
        this(WebDriverContext.getDriver());
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}
