@regression
Feature: Upload document to Docuport application DB,API verification

  #UI SCENARIO
  @docuporUploadDocument
  Scenario: Login as and advisor to Docuport and upload a document, verify the document was successfully uploaded



  #UI SCENARIO
  @docuporUploadDocumentNegativeTest
  Scenario: Login as and advisor to Docuport and upload a wrong document format, verify the document was not uploaded



  #API SCENARIO
  @docuportAPIUploadDocumentVerification
  Scenario: Create an API GET request to check if the uploaded Document is in the database
    Given the user logged in to Docuport api as advisor role
    When I send a GET request to "/api/v1/document/documents/my-upload"
    Then the response status should be 200
    And the response should be in "application/json; charset=utf-8" format
    And the response should contain file name is "DocBeta.xlsx"
    And client name is "Aldo Meneao"





  #API &  DB SCENARIO
  @docuportAPIDBUploadDocument
  Scenario: Create an API POST request to upload a document and cross check the database to verify it is in the database