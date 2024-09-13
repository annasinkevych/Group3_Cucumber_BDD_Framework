@regression
Feature: Upload document to Docuport application DB,API verification

  #UI SCENARIO - Assignee:  Sergio
  @docuporUploadDocument
  Scenario: Login as and advisor to Docuport and upload a document, verify the document was successfully uploaded



  #UI SCENARIO
  @docuporUploadDocumentNegativeTest
  Scenario: Login as and advisor to Docuport and upload a wrong document format, verify the document was not uploaded



  #API SCENARIO - Assignee: Daria
  @docuportAPIUploadDocumentVerification
  Scenario: Create an API GET request to check if the uploaded Document is in the database



































