Feature: Delivery Information Navigation
  As a user
  I want to view the Delivery Information page
  So that I can understand the delivery process

  Scenario: Navigate to Delivery Information from Home Page
    Given I am on the OpenCart home page
    When I click on Delivery Information link
    Then I should be redirected to Delivery Information page
    And the page title should contain "Delivery Information"

  Scenario: Verify Delivery Information link is visible
    Given I am on the OpenCart home page
    Then Delivery Information link should be visible

  Scenario: Verify Delivery Information page content
    Given I am on the OpenCart home page
    When I click on Delivery Information link
    Then I should be redirected to Delivery Information page
    And the page heading should be "Delivery Information"