Feature: Docuport New Client Creation Feature Login as an Advisor

  #UI SCENARIO - Assignee: Anna - I have started this a while ago but haven't finished it
  @docuportCreateNewClientAnna @smoke
  Scenario Outline: Create a new "Personal" client and login as a new client

    Given the user is logged in as an advisor
    When the user creates a new client with the following details:
      | First name   | Last name   | Email address  | Phone number   | Password          | Confirm password  |
      | <First Name> | <Last Name> | <Client Email> | <Phone Number> | <Client Password> | <Client Password> |
    And the user validates that new client was created "<First Name>" and "<Last Name>"
    And the user logs out as an advisor
    Then the user should be able to log in as a new client using:
      | Email address  | Password          |
      | <Client Email> | <Client Password> |
    Then the user name "<First Name>" and "<Last Name>" should be displayed in the top right
    Examples:
      | First Name | Last Name | Client Email  | Phone Number | Client Password |
      | MiMi  | Mas       | mimi@gmail.com | 3453457898   | Password1       |





  #DB SCENARIO - Assignee: Andrew - refer to the examples table above for the clients
  @docuportDatabaseClientVerification @smoke
  Scenario Outline: Verify the client was created in the DOCUPORT database
    Given a connection to the database is established using JDBC
    Then the client details in the database should match: "<First Name>", "<Last Name>", "<Client Email>", "<Phone Number>"

    Examples:
      | First Name | Last Name | Client Email        | Phone Number |
      | MiMi       | Mas       | mimi@gmail.com      | 3453457898   |
      | Adriano    | Celentano | celentano@gmail.com |              |



  #UI SCENARIO - Assignee: Ayaz -refer to the examples table above for the clients
  @docuportClientSearchFunctionality
  Scenario: Verify Client Search functionality, login as an advisor














      #API & DB Scenario - Assignee: Sammy
  @docuportPostNewClientToAPIVerifyDatabase
  Scenario: POST to Docuport Client API and verify the client was created in the database