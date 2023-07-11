package org.example.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage {


    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchInput;

    public void enterSearchQuery(String query) {
        searchInput.sendKeys(query);
    }

    public void performSearch() {
        searchInput.sendKeys(Keys.ENTER);
    }


}
