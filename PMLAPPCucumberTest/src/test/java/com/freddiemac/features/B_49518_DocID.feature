Feature: B-49518 Enhance Source Systems integration with new data elements

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
      | scenarioid | SourceSystem | AttributeName          | AttributeValue                      | AttributeName2              | AttributeValue2                                                                                                                                           | EVAL_PROCSS_STATS |
      | "120"      | "LCAE"       | "APPRAISAL_IDENTIFIER" | "DOCID001"                          | "APPRAISER_FILE_IDENTIFIER" | "DOCFILEID001"                                                                                                                                            | "Processed"       |
      | "121"      | "LCAE"       | "APPRAISAL_IDENTIFIER" | "DOCID002"                          | "APPRAISER_FILE_IDENTIFIER" | "DOCFILEID001"                                                                                                                                            | "Processed"       |
      | "122"      | "LCAE"       | "APPRAISAL_IDENTIFIER" | "DOCID003"                          | "APPRAISER_FILE_IDENTIFIER" | "DOCFILEID001"                                                                                                                                            | "Processed"       |
      | "123"      | "LCLA"       | "APPRAISAL_IDENTIFIER" | "DOCID001"                          | "APPRAISER_FILE_IDENTIFIER" | "DOCFILEID001"                                                                                                                                            | "Processed"       |
      | "124"      | "LQA"        | "APPRAISAL_IDENTIFIER" | "DOCID001"                          | "APPRAISER_FILE_IDENTIFIER" | "DOCFILEID001"                                                                                                                                            | "Processed"       |
      | "125"      | "LCAE"       | "APPRAISAL_IDENTIFIER" | "DOCID00110DOCID00110DOCID00110123" | "APPRAISER_FILE_IDENTIFIER" | "DOCFILEID001"                                                                                                                                            | "Processed"       |
      | "126"      | "LCAE"       | "APPRAISAL_IDENTIFIER" | "DOCID001"                          | "APPRAISER_FILE_IDENTIFIER" | "DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID1DOCFILEID11" | "Persist_Error"   |
