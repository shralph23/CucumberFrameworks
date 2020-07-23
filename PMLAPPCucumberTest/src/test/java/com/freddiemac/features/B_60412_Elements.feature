Feature: B-60412 This validates nullable for elements that becomes optional as part relaxing the PMLDB

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
      | scenarioid | SourceSystem | AttributeName                                  | AttributeValue | EVAL_PROCSS_STATS |
      #Loan Collateral Risk Assessment
      | "275"      | "LCAE"       | "LTV_SOURCE_TYPE"                              | "null"         | "Processed"       |
      | "276"      | "LCAE"       | "LoanIdentifier"                               | "null"         | "Processed"       |
      | "277"      | "LCAE"       | "LOAN_SCOPE_TYPE"                              | "null"         | "Processed"       |
      | "278"      | "LCAE"       | "LTV_CALCULATION_TYPE"                         | "null"         | "Processed"       |
      | "279"      | "LCAE"       | "LTV_EVENT_TYPE"                               | "null"         | "Processed"       |
      | "280"      | "LCAE"       | "LTV_RATIO_PERCENT"                            | "null"         | "Processed"       |
      | "281"      | "LCAE"       | "LOAN_COLLATERAL_RISK_ASSESSEMENT_DESCRIPTION" | "null"         | "Processed"       |
      | "282"      | "LCAE"       | "PROPERTY_IDENTIFIER_FOR_RISK_ASSMT"           | "null"         | "Processed"       |
      | "283"      | "LCAE"       | "PROPERTY_POOL_IDENTIFIER"                     | "null"         | "Processed"       |
      | "284"      | "LCAE"       | "PROPERTY_VALUATION_EFFECTIVE_DATE"            | "null"         | "Processed"       |
      | "285"      | "LCAE"       | "PROPERTY_VALUATION_SEQUENCE_NUMBER"           | "null"         | "Processed"       |
      | "286"      | "LCAE"       | "TOTAL_LOAN_COST_PERCENT"                      | "null"         | "Processed"       |
      #Contract Container
      | "287"      | "LCAE"       | "CONTRACT_LEVEL_TYPE"                          | "null"         | "Processed"       |
      | "288"      | "LCAE"       | "LOAN_PURCHASE_CONTRACT_IDENTIFIER"            | "null"         | "Processed"       |
      #Document Group
      | "289"      | "LCLA"       | "DOCUMENT_GROUP_TYPE"                          | "null"         | "Processed"       |
      | "290"      | "LCLA"       | "DOCUMENT_REQUIREMENT_SATISFIED_TYPE"          | "null"         | "Processed"       |
      | "291"      | "LCLA"       | "PARTY_IDENTIFIER"                             | "null"         | "Processed"       |
      | "292"      | "LCLA"       | "PARTY_ROLE_TYPE"                              | "null"         | "Processed"       |
      #Property Address
      | "293"      | "LCAE"       | "ADDRESS_IDENTIFIER"                           | "null"         | "Processed"       |
      | "294"      | "LCAE"       | "ADDRESS_LINE_TEXT"                            | "null"         | "Processed"       |
      | "295"      | "LCAE"       | "ADDRESS_SOURCE_TYPE"                          | "null"         | "Processed"       |
      | "296"      | "LCAE"       | "CITYNAME"                                     | "null"         | "Processed"       |
      | "297"      | "LCAE"       | "POSTAL_CODE"                                  | "null"         | "Processed"       |
      | "298"      | "LCAE"       | "STATE_CODE"                                   | "null"         | "Processed"       |
      #Property Valuation
      | "299"      | "LCAE"       | "FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER"   | "null"         | "Processed"       |
      | "300"      | "LCAE"       | "PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER"    | "null"         | "Processed"       |
      | "301"      | "LCAE"       | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME"       | "null"         | "Processed"       |
      #Appraisal
      | "302"      | "LCAE"       | "LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME" | "null"         | "Processed"       |
      | "303"      | "LCAE"       | "PROPERTY_APPRAISED_VALUE_AMOUNT"              | "null"         | "Processed"       |
      | "304"      | "LCAE"       | "APPRAISAL_DOCUMENT_TYPE"                      | "null"         | "Processed"       |
      | "305"      | "LCAE"       | "UCDP_STATUS"                                  | "null"         | "Processed"       |
