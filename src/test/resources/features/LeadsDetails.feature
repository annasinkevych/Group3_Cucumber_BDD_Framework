@regression
Feature: Verify the Leads Details on Leads Page is displayed correctly

  #UI SCENARIO - Assignee: Diliara
  @docuportLeadsVerify
  Scenario: Login as and advisor to Docuport and navigate to Leads page and click on "Leads Details"
    Given user is on Docuport login page
    When user enters credentials
      |username|b1g3_advisor@gmail.com|
      |password|Group3|
    When user navigate to "Leads" page
    Then user should see "Leads" page
    When user clicks on Leads details button
    Then user should see "Leads details" page

