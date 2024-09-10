@regression
Feature: Edit existing user in Docuport login as advisor

  #UI SCENARIO -  Assignee: Oleksandr M
  @docuportEditExistingUser
  Scenario: Login as and advisor to Docuport and edit existing client




  #UI & DB SCENARIO - Assignee: Alex S
  @docuportRowsPerPageValidation
  Scenario: Login as and advisor to Docuport and verify the rows per page match the user count in database


  #API & DB Scenario - Assignee: Sammy
  @docuportPostNewClientToAPIVerifyDatabase
  Scenario: POST to Docuport Client API and verify the client was created in the database