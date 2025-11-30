Feature: Terms and Conditions Navigation
  As a user
  I want to view the Terms and Conditions page
  So that I can understand the terms of using the website

  Scenario: Navigate to Terms and Conditions from Home Page
    Given I am on the OpenCart home page
    When I click on Terms and Conditions link
    Then I should be redirected to Terms and Conditions page
    And the page title should contain "Terms & Conditions"

  Scenario: Verify Terms and Conditions link is visible
    Given I am on the OpenCart home page
    Then Terms and Conditions link should be visible