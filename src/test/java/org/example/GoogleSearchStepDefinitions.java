package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.GoogleHomePage;
import org.example.page.GoogleSearchResultsPage;


import static org.junit.Assert.assertEquals;

public class GoogleSearchStepDefinitions {

    private GoogleHomePage homePage;

    private GoogleSearchResultsPage resultsPage;

    @Given("I am on the Google homepage")
    public void iAmOnGoogleHomepage() {
        homePage = new GoogleHomePage();
        homePage.open("https://www.google.com");
    }

    @When("I enter {string} in the search bar")
    public void iEnterSearchQuery(String query) {
        homePage.enterSearchQuery(query);
    }

    @And("I press the search button")
    public void iPressSearchButton() {
        homePage.performSearch();
    }

    @And("I open the search results page")
    public void iOpenSearchResultsPage() {
        resultsPage = new GoogleSearchResultsPage();
    }

    @And("I click on the first link")
    public void iClickOnFirstLink() {
        resultsPage.clickResultLinkByIndex(0);
    }

    @Then("^the page title should be (.*)$")
    public void iShouldBeOnYouTubePage(String expectedTitle) {
        final var actualTitle = resultsPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle);
    }

}
