Feature: B-48606 Implementation of AA Decsion Type in Evaluation Service Category

  @sitint
  Scenario Outline: Send request using the PMLAPP Client and then validate the data in the DB
    Given a request for sls webservice for id <scenarioid>
    Then setup the Payload with unique values for <SourceSystem>
    Then modify <AttributeName> to create a payload with <AttributeValue>
    Then modify <AttributeName2> to create a payload with <AttributeValue2>
    Then the request is sent to the PMLAPP Client
    Then validate that the DB received the payload correctly with EventProcessStatus as <EVAL_PROCSS_STATS>
    And validate that information has been stored correctly in the DB

    Examples:
      #keys = "" send null in the tag, "null" deletes tag from XML
      | scenarioid | SourceSystem | AttributeName                      | AttributeValue                                          | AttributeName2                              | AttributeValue2        | EVAL_PROCSS_STATS |
      | "40"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyReliefDecisionType" | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "Appraisal"            | "Processed"       |
      | "41"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyReliefDecisionType" | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "AppraisalAlternative" | "Processed"       |
      | "42"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyRelief"             | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "GREEN"                | "Processed"       |
      | "43"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyRelief"             | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INCOMPLETE"           | "Processed"       |
      | "44"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyRelief"             | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INELIGIBLE"           | "Processed"       |
      | "45"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyRelief"             | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "RED"                  | "Processed"       |
      | "46"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyRelief"             | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "YELLOW"               | "Processed"       |
      | "47"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | ""                     | "Processed"       |
      | "48"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "ERROR"                | "Processed"       |
      | "49"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "GREEN"                | "Processed"       |
      | "50"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INCOMPLETE"           | "Processed"       |
      | "51"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INELIGIBLE"           | "Processed"       |
      | "52"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "RED"                  | "Processed"       |
      | "53"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "YELLOW"               | "Processed"       |
      | "54"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "LPDataCompare"                                         | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | ""                     | "Processed"       |
      | "55"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "LPDataCompare"                                         | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "ERROR"                | "Processed"       |
      | "56"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "LPDataCompare"                                         | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "GREEN"                | "Processed"       |
      | "57"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "LPDataCompare"                                         | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INCOMPLETE"           | "Processed"       |
      | "58"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "LPDataCompare"                                         | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INELIGIBLE"           | "Processed"       |
      | "59"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "LPDataCompare"                                         | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "RED"                  | "Processed"       |
      | "60"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "LPDataCompare"                                         | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "YELLOW"               | "Processed"       |
      | "61"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "PurchaseEligibility"                                   | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | ""                     | "Processed"       |
      | "62"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "PurchaseEligibility"                                   | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "ERROR"                | "Processed"       |
      | "63"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "PurchaseEligibility"                                   | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "GREEN"                | "Processed"       |
      | "64"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "PurchaseEligibility"                                   | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INCOMPLETE"           | "Processed"       |
      | "65"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "PurchaseEligibility"                                   | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INELIGIBLE"           | "Processed"       |
      | "66"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "PurchaseEligibility"                                   | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "RED"                  | "Processed"       |
      | "67"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "PurchaseEligibility"                                   | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "YELLOW"               | "Processed"       |
      | "68"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | ""                     | "Processed"       |
      | "69"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "ERROR"                | "Processed"       |
      | "70"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "GREEN"                | "Processed"       |
      | "71"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INCOMPLETE"           | "Processed"       |
      | "72"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "INELIGIBLE"           | "Processed"       |
      | "73"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "RED"                  | "Processed"       |
      | "74"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CreditRiskAssessment"                                  | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "YELLOW"               | "Processed"       |
      | "75"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyReliefDecisionType" | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | ""                     | "Processed"       |
      | "76"       | "LCLA"       | "EVALUATION_SERVICE_CATEGORY_TYPE" | "CollateralRepresentationAndWarrantyReliefDecisionType" | "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION" | "ERROR"                | "Processed"       |
