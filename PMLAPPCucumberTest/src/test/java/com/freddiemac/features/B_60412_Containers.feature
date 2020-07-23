Feature: B-60412 This validates nullable for container that becomes optional as part relaxing the PMLDB

  @sitint 
  Scenario Outline: Send request using the PMLAPP Client and then validate the data in the DB
    Given a request for sls webservice for id <scenarioid>
    Then setup the Payload with unique values for <SourceSystem>
    Then remove the <Container>
    When the request is sent to the PMLAPP Client
    Then validate that the DB received the payload correctly with EventProcessStatus as <EVAL_PROCSS_STATS>
    And validate that information has been stored correctly in the DB

    Examples: 
      #keys = "" send null in the tag, "null" deletes tag from XML
      # TODO : reactivate all scenarios
      | scenarioid | SourceSystem | Container                                                    | EVAL_PROCSS_STATS |
      | "264"      | "LCAE"       | "LOAN_COLLATERAL_RISK_ASSESSMENT"                            | "Processed"       |
      | "265"      | "LCAE"       | "PRIMARY_MARKET_LOAN_SUBMISSION_CONTRACT_CONTAINER"          | "Processed"       |
      | "266"      | "LCAE"       | "LOAN_PURCHASE_CONTRACT"                                     | "Processed"       |
      | "267"      | "LCAE"       | "PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_CONTAINERS" | "Processed"       |
      | "268"      | "LCAE"       | "APPRAISAL_CONTAINERS"                                       | "Processed"       |
      | "269"      | "LCAE"       | "APPRAISAL"                                                  | "Processed"       |
      | "270"      | "LCAE"       | "PROPERTY_VALUATION_ASSESSMENT"                              | "Processed"       |
      | "271"      | "LCLA"       | "DOCUMENT_GROUP"                                             | "Processed"       |
      | "272"      | "LCLA"       | "PRIMARY_MARKET_LOAN_SUBMISSION_DOCUMENT_GROUP_CONTAINER"    | "Processed"       |
      | "273"      | "LCAE"       | "PRIMARY_MARKET_LOAN_SUBMISSION_PARTY_ROLE_CONTAINERS"       | "Processed"       |
      | "274"      | "LCAE"       | "PARTY_ROLE"                                                 | "Processed"       |
