@smoke
Feature: Upload document to Docuport application DB,API verification

  #API SCENARIO - Assignee: Daria
  @docuportAPIUploadDocumentVerification
  Scenario: Create an API GET request to check if the uploaded Document is in the database
    Given the user logged in to Docuport api as advisor role
    When I send a GET request to "/api/v1/document/documents/my-upload"
    Then the response status should be 200
    And the response should be in "application/json; charset=utf-8" format
    And the response should contain file name is "note.txt"
    And client name is "Wilmer Frami"





































