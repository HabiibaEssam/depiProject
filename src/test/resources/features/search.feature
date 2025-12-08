Feature: Product Search
@Search
  Scenario: Search for an existing product
    Given I am on the homepage
    When I search for "iMac"
    Then I should see search results containing "iMac"
    And I click on the searched product "iMac"
    And I should be on the product page of "iMac"
@InvalidSearch
  Scenario: Search for a non-existing product
    Given I am on the homepage
    When I search for "XYZ123"
    Then I should see a message that no products were found
