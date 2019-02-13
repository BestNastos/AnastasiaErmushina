@DifferentElementsInterface
Feature: Different Elements Page Test

  Scenario: Interface testing
    Given I open 'URL'
    Then Browser title should be 'HOME_PAGE'
    When I login as 'PITER_CHAILOVSKII'
    Then Username should be 'PITER_CHAILOVSKII'
    And Home Page should have '4' benefit icons
    And Home Page should have '4' texts under icons
    And Home Page should have headline and description
    When I click on Service subcategory in the header
    Then Service dropdown menu in header displays following options
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I click on Service subcategory in the left section
    Then Service dropdown in left section displays following options
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I open header menu Service -> 'DIFFERENT_ELEMENTS' Page
    Then Interface on Different elements page contains '4' checkboxes with forces of nature
    And Interface on Different elements page contains '4' radio buttons with metals
    And Interface on Different elements page contains color choice dropdown
    And Interface on Different elements page contains '2' buttons
    And Different elements page has a Right section
    And Different elements page has a Left section
    When I select following checkboxes with forces of nature on Different elements page:
      | WATER |
      | WIND  |
    Then For each checkbox there is a log row with corresponding status
      | WATER | true |
      | WIND  | true |
    When I select 'SELEN' radio button
    Then There is a log raw for 'SELEN' radio button
    When I select 'YELLOW' from the color selection dropdown
    Then There is a log raw for 'YELLOW' color dropdown
    When I unselect checkboxes:
      | WATER |
      | WIND  |
    Then Following boxes are unchecked:
      | WATER |
      | WIND  |