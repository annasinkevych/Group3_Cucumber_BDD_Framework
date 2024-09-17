@smoke
Feature: Verify the rows per page match the user count in database

  Background:
    Given go to Docuport beta page

#UI & DB SCENARIO - Assignee: Oleksandr M
@docuportRowsPerPageValidation @ui
Scenario: Login as and advisor to Docuport and verify the rows per page match the user count in database
  When : User Logs in Docuport as an advisor
    | username               | password |
    | b1g3_advisor@gmail.com | Group3   |
  And : User clicks on "Users" button
  And : User get amount of all users on user page
  And : user validates that amount of user on UI same like in DB
