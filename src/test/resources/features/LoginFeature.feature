Feature: Docuport Login Logout and Negative Testing Feature

   #UI SCENARIO - Assignee: ELINA & Luidmyla - you can implement it this way or create your own way
  @docuportLoginForALlUsers
  Scenario Outline: Login Functionality for multiple users
    When user enters credentials as "<username>" "<password>"
    Then user should see the "Batch1 Group3" displayed

    Examples:
      | username                  | password |
      | b1g3_client@gmail.com     | Group3   |
      | b1g3_advisor@gmail.com    | Group3   |
      | b1g3_supervisor@gmail.com | Group3   |
      | b1g3_employee@gmail.com   | Group3   |





  #UI SCENARIO -  Assignee: Igor
  @docuportLogoutFunctionality
  Scenario: Verify that the users can logout successfully