Feature: B-49518 Implementation to validate LCAE for doc file id and multiple docids

  @sitint 
  Scenario Outline: Send request using the PMLAPP Client and then validate the data in the DB
    Given a request for sls webservice for id <scenarioid>
    Then setup the Payload with unique values for <SourceSystem>
    Then modify <AttributeName> to create a payload with <AttributeValue>
    Then modify <AttributeName2> to create a payload with <AttributeValue2>
    When the request is sent to the PMLAPP Client
    Then validate that the DB received the payload correctly with EventProcessStatus as <EVAL_PROCSS_STATS>
    And validate that information has been stored correctly in the DB

    Examples: 
      #keys = "" send null in the tag, "null" deletes tag from XML
      | scenarioid | SourceSystem | AttributeName               | AttributeValue | AttributeName2         | AttributeValue2 | EVAL_PROCSS_STATS |
      | "127"      | "LCAE"       | "APPRAISER_FILE_IDENTIFIER" | "DOCFILE001"   | "APPRAISAL_IDENTIFIER" | "DOCID001"      | "Processed"       |
      | "128"      | "LCAE"       | "APPRAISER_FILE_IDENTIFIER" | "DOCFILE001"   | "APPRAISAL_IDENTIFIER" | "DOCID002"      | "Processed"       |
      | "129"      | "LCAE"       | "APPRAISER_FILE_IDENTIFIER" | "DOCFILE001"   | "APPRAISAL_IDENTIFIER" | "DOCID003"      | "Processed"       |
