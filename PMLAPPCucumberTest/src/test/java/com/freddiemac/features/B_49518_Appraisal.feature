Feature: B-49518 Enhance LCAE integration with new data elements

  @sitint 
  Scenario Outline: Send request using the PMLAPP Client and then validate the data in the DB
    Given a request for sls webservice for id <scenarioid>
    Then setup the Payload with unique values for <SourceSystem>
    Then modify <AttributeName> to create a payload with <AttributeValue>
    When the request is sent to the PMLAPP Client
    Then validate that the DB received the payload correctly with EventProcessStatus as <EVAL_PROCSS_STATS>
    And validate that information has been stored correctly in the DB

    Examples: 
      #keys = "" send null in the tag, "null" deletes tag from XML
      | scenarioid | SourceSystem | AttributeName                                  | AttributeValue                                                                                          | EVAL_PROCSS_STATS | noOfAdditionalEvents |
      | "77"       | "LCAE"       | "ADDRESS_SOURCE_TYPE"                          | "Home Address Description 35 charars"                                                                   | "Processed"       |                    0 |
      | "78"       | "LCAE"       | "ADDRESS_SOURCE_TYPE"                          | "Home Address Description 35 chararsv"                                                                  | "Persist_Error"   |                    0 |
      | "79"       | "LCAE"       | "ADDRESS_SOURCE_TYPE"                          | "null"                                                                                                  | "Processed"       |                    0 |
      | "80"       | "LCAE"       | "ADDRESS_SOURCE_TYPE"                          | ""                                                                                                      | "Processed"       |                    0 |
      | "81"       | "LCAE"       | "PROPERTY_APPRAISED_VALUE_AMOUNT"              | "123.12"                                                                                                | "Processed"       |                    0 |
      | "82"       | "LCAE"       | "PROPERTY_APPRAISED_VALUE_AMOUNT"              | "12345678901234.12"                                                                                     | "Persist_Error"   |                    0 |
      | "83"       | "LCAE"       | "PROPERTY_APPRAISED_VALUE_AMOUNT"              | "null"                                                                                                  | "Processed"       |                    0 |
      | "84"       | "LCAE"       | "PROPERTY_APPRAISED_VALUE_AMOUNT"              | ""                                                                                                      | "Processed"       |                    0 |
      | "85"       | "LCAE"       | "PROPERTY_VALUATION_FORM_TYPE"                 | "valuation form 100 chars"                                                                              | "Processed"       |                    0 |
      | "86"       | "LCAE"       | "PROPERTY_VALUATION_FORM_TYPE"                 | "valuation form 100 chars valuation form 100 chars valuation form 100 chars valuation form 100 chars m" | "Persist_Error"   |                    0 |
      | "87"       | "LCAE"       | "PROPERTY_VALUATION_FORM_TYPE"                 | "null"                                                                                                  | "Processed"       |                    0 |
      | "88"       | "LCAE"       | "PROPERTY_VALUATION_FORM_TYPE"                 | ""                                                                                                      | "Processed"       |                    0 |
      | "89"       | "LCAE"       | "LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME" | "Thu Mar 13 20:56:02 EDT 2009"                                                                          | "Processed"       |                    0 |
      | "90"       | "LCAE"       | "LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME" | "Thu Mar 23 20:56:02 EDT 2009"                                                                          | "Processed"       |                    0 |
      | "91"       | "LCAE"       | "LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME" | "null"                                                                                                  | "Processed"       |                    0 |
      | "92"       | "LCAE"       | "LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME" | ""                                                                                                      | "Processed"       |                    0 |
      | "93"       | "LCAE"       | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME"       | "Thu Jun 22 20:56:02 EDT 2015"                                                                          | "Processed"       |                    0 |
      | "94"       | "LCAE"       | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME"       | "Thu Jun 22 20:56:02 EDT 2015"                                                                          | "Processed"       |                    0 |
      | "95"       | "LCAE"       | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME"       | "null"                                                                                                  | "Processed"       |                    0 |
      | "96"       | "LCAE"       | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME"       | ""                                                                                                      | "Processed"       |                    0 |
      | "97"       | "LCAE"       | "APPRAISAL_DOCUMENT_TYPE"                      | "document type status12345"                                                                             | "Processed"       |                    0 |
      | "98"       | "LCAE"       | "APPRAISAL_DOCUMENT_TYPE"                      | "document type status12345m"                                                                            | "Persist_Error"   |                    0 |
      | "99"       | "LCAE"       | "APPRAISAL_DOCUMENT_TYPE"                      | "null"                                                                                                  | "Processed"       |                    0 |
      | "100"      | "LCAE"       | "APPRAISAL_DOCUMENT_TYPE"                      | ""                                                                                                      | "Processed"       |                    0 |
      | "101"      | "LCAE"       | "FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER"   | "1234567890.1234567809"                                                                                 | "Processed"       |                    0 |
      | "102"      | "LCAE"       | "FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER"   | "12345678901.1234567809"                                                                                | "Persist_Error"   |                    0 |
      | "103"      | "LCAE"       | "FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER"   | "null"                                                                                                  | "Processed"       |                    0 |
      | "104"      | "LCAE"       | "FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER"   | ""                                                                                                      | "Processed"       |                    0 |
      | "105"      | "LCAE"       | "PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER"    | "1234567890.1234567809"                                                                                 | "Processed"       |                    0 |
      | "106"      | "LCAE"       | "PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER"    | "12345678901.1234567809"                                                                                | "Persist_Error"   |                    0 |
      | "107"      | "LCAE"       | "PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER"    | "null"                                                                                                  | "Processed"       |                    0 |
      | "108"      | "LCAE"       | "PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER"    | ""                                                                                                      | "Processed"       |                    0 |
      | "109"      | "LCAE"       | "UCDP_STATUS"                                  | "document status testing max lenghth 09876543210123"                                                    | "Processed"       |                    0 |
      | "110"      | "LCAE"       | "UCDP_STATUS"                                  | "document status testing max lenghth 09876543210123m"                                                   | "Persist_Error"   |                    0 |
      | "111"      | "LCAE"       | "UCDP_STATUS"                                  | "null"                                                                                                  | "Processed"       |                    0 |
      | "112"      | "LCAE"       | "UCDP_STATUS"                                  | ""                                                                                                      | "Processed"       |                    0 |
      | "113"      | "LCAE"       | "ADDRESS_UNIT_IDENTIFIER"                      | "Home Address Description 35 charars123456789012345"                                                    | "Processed"       |                    0 |
      | "114"      | "LCAE"       | "ADDRESS_UNIT_IDENTIFIER"                      | "Home Address Description 35 charars123456789012345v"                                                   | "Persist_Error"   |                    0 |
      | "115"      | "LCAE"       | "ADDRESS_UNIT_IDENTIFIER"                      | "null"                                                                                                  | "Processed"       |                    0 |
      | "116"      | "LCAE"       | "ADDRESS_UNIT_IDENTIFIER"                      | ""                                                                                                      | "Processed"       |                    0 |
      | "117"      | "LCAE"       | "PROPERTY_APPRAISED_VALUE_AMOUNT"              | "-100.01"                                                                                               | "Processed"       |                    0 |
      | "118"      | "LCAE"       | "FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER"   | "-100"                                                                                                  | "Processed"       |                    0 |
      | "119"      | "LCAE"       | "PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER"    | "-100"                                                                                                  | "Processed"       |                    0 |
