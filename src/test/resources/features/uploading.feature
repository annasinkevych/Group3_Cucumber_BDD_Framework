@regression
Feature: Upload document to Docuport application DB,API verification

  #UI SCENARIO - Assignee:  Sergio
  @docuporUploadDocument
  Scenario: Login as and advisor to Docuport and upload a document, verify the document was successfully uploaded
    Given user is on Docuport Login Page
    When user enters credentials as "b1g3_advisor@gmail.com" and "Group3"
    Then user clicks on "My uploads" and update a file
    And user verify file was uploaded

  #UI SCENARIO
  @docuporUploadDocumentNegativeTest
  Scenario: Login as and advisor to Docuport and upload a wrong document format, verify the document was not uploaded
    Given user is on Docuport Login Page
    When user enters credentials as "b1g3_advisor@gmail.com" and "Group3"
    Then user clicks on "My uploads" and update a file
    And user verify file was not uploaded