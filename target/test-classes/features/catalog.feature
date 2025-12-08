Feature: Catalog Page
  Scenario: User interacts with the Catalog page
    Given user is on the Desktops page
    When user clicks on the sort dropdown and selects "Name (A - Z)"
    And user clicks on the show limit dropdown and selects "25"
    Then user should see the products displayed according to the sort and show options


