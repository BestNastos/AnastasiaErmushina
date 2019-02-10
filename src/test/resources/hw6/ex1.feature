Feature: Different Elements Page Test

  Scenario: Interface testing
    Given I open site
    Then The browser title should be 'TITLE'
    When I login as 'PITER'
    Then User's name should be 'PITER'
    And Interface should have all the necessary elements
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
    When I open header menu Service -> Different Elements Page
    Then Interface on Different elements page contains all needed elements
    And There is a Right section
    And There is a Left section
    When I select checkboxes:
      | WATER |
      | WIND  |
    Then For each checkbox there is a log row
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