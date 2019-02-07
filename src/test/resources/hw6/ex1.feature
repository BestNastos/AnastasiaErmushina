Feature: Different Elements Page Test

  Scenario: Interface testing
    Given I open EPAM JDI site
    Then Browser title should be 'Home Page'
    When I login as user 'epam' with password '1234'
    Then User name should be 'PITER CHAILOVSKII'
    And Interface should contain all needed elements
    When I click on 'Service' subcategory in the header
    Then Drop down displays options
    When I click on Service subcategory in the left section
    Then Drop down contains options
    When I open header menu Service -> Different Elements Page
    Then Interface on Different elements page contains all needed elements
    And There is a Right section
    And There is a Left section
    When I select checkboxes 'Water' and 'Wind'
    Then For each checkbox there is a log row
    When I select 'Selen' radio button
    Then There is a log raw for the radio button
    When I select 'Yellow' from the color selection dropdown
    Then There is a log raw for the color dropdown
    When I unselect and assert 'Water' and 'Wind' checkboxes
    Then Boxes are unchecked


