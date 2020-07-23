Feature: B-41889 Enhance LCLA integration with Project Payments Cashflow data

  @sitint 
  Scenario Outline: Send request using the PMLAPP Client and then validate the data in the DB
    Given a request for sls webservice for id <scenarioid>
    Then setup the Payload with unique values for <SourceSystem>
    Then modify <AttributeName> to create a payload with <AttributeValue>
    Then modify <AttributeName2> to create a payload with <AttributeValue2>
    Then modify <AttributeName3> to create a payload with <AttributeValue3>
    Then modify <AttributeName4> to create a payload with <AttributeValue4>
    Then modify <AttributeName5> to create a payload with <AttributeValue5>
    Then modify <AttributeName6> to create a payload with <AttributeValue6>
    Then modify <AttributeName7> to create a payload with <AttributeValue7>
    Then modify <AttributeName8> to create a payload with <AttributeValue8>
    Then modify <AttributeName9> to create a payload with <AttributeValue9>
    Then modify <AttributeName10> to create a payload with <AttributeValue10>
    Then modify <AttributeName11> to create a payload with <AttributeValue11>
    When the request is sent to the PMLAPP Client
    Then validate that the DB received the payload correctly with EventProcessStatus as <EVAL_PROCSS_STATS>
    And validate that information has been stored correctly in the DB

    Examples: 
      #keys = "" send null in the tag, "null" deletes tag from XML
      | scenarioid | SourceSystem | AttributeName                              | AttributeValue | AttributeName2                         | AttributeValue2 | AttributeName3                                                 | AttributeValue3 | AttributeName4                                | AttributeValue4 | AttributeName5                   | AttributeValue5 | AttributeName6                                            | AttributeValue6 | AttributeName7                           | AttributeValue7 | AttributeName8                                  | AttributeValue8 | AttributeName9                     | AttributeValue9       | AttributeName10                                   | AttributeValue10 | AttributeName11                                    | AttributeValue11 | EVAL_PROCSS_STATS |
      | "39"       | "LCLA"       | "LOAN_PROJECTED_CASH_FLOW_SEQUENCE_NUMBER" | "9999"         | "LOAN_PROJECTED_ESCROW_PAYMENT_AMOUNT" | "99.99"         | "LOAN_PROJECTED_MAXIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT" | "99.99"         | "LOAN_PROJECTED_MAXIMUM_TOTAL_PAYMENT_AMOUNT" | "99.99"         | "LOAN_PROJECT_MI_PAYMENT_AMOUNT" | "99.99"         | "PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT" | "99.99"         | "PROJECTED_MINIMUM_TOTAL_PAYMENT_AMOUNT" | "99.99"         | "PROJECTED_PAYMENT_CALCULATION_PERIOD_TERMTYPE" | "FinalPayment"  | "PROJECTED_PAYMENT_FREQUENCY_TYPE" | "AcademicPerSemester" | "PROJECTED_PAYMENT_CALCULATION_PERIOD_END_NUMBER" | "99"             | "PROJECTED_PAYMENT_CALCULATION_PERIOD_STARTNUMBER" | "99"             | "Processed"       |
