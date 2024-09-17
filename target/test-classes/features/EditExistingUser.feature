@smoke
Feature: Edit existing user in Docuport login as advisor
  Background:
    Given go to Docuport beta page
  #UI SCENARIO - Assignee: Alex S
  @docuportEditExistingUser @ui @smoke
  Scenario: Login as and advisor to Docuport and edit existing client
    When : User Logs in Docuport as an advisor
      | username               | password |
      | b1g3_advisor@gmail.com | Group3   |
    Then : User able to see homepage from Advisor permission
    And : User clicks on "Clients" button
    Then : User able to see "Clients" header
    And : User clicks on three dots in right corner of the first row with client
    And : user changes First name, Last name, and Email address
    And : User clicks Save button
    Then : Validate that data was changed in UI by searching through the Clients by the changed name
    Then : Validate that data was changed in database
    Then : user validates all assertions

    #UI & DB SCENARIO - Assignee: Oleksandr M
  @docuportRowsPerPageValidation @smoke
  Scenario: Login as and advisor to Docuport and verify the rows per page match the user count in database
    When : User Logs in Docuport as an advisor
      | username               | password |
      | b1g3_advisor@gmail.com | Group3   |
    And : User clicks on "Users" button
    And : User get amount of all users on user page
    And : user validates that amount of user on UI same like in DB





