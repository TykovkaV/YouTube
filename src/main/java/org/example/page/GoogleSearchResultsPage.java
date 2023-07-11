package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchResultsPage extends BasePage{

    @FindBy(css = "div#search a")
    private List<WebElement> resultLinks;


    public void clickResultLinkByIndex(int index) {
        if (index < 0 || index > resultLinks.size()) {
            throw new IndexOutOfBoundsException("Invalid result index: " + index);
        }
        resultLinks.get(index).click();
    }
}

