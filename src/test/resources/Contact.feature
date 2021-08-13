@Mobile
Feature: Contact test

  @Contact @ContactSearch_S01 @Web
  Scenario: search contact
    Given I search "Sara"
    Then I verify first contact is "Sara Alston"
    When I navigate to search result details
    Then I verify contact name "Sara Alston"