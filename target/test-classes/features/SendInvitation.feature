@smoke
Feature: Send invitation to Docuport application DB verification

  #API &  DB SCENARIO - Assignee: Laura
  @docuportAPIDBSendInvitation @db
  Scenario: Post invitation and verify in database
#    Given the user is logged in as an advisor
    When user sends POST request to "/api/v1/document/invitations/send" with the following info "laurissss@gmail.com"
    Then status code is 200
    And cdataBase should persist same client info