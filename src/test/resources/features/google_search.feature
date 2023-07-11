Feature: Google Search
  Scenario: Search and open the first link
    Given I am on the Google homepage
    When I enter "youtube" in the search bar
    And I press the search button
    And I open the search results page
    And I click on the first link
    Then the page title should be YouTube