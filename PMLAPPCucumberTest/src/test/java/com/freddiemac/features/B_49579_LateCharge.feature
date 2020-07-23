Feature: B-49579 Implementation of LateChargeRule - LOAN_LATE_CHARGE_AMOUNT,LOAN_LATE_CHARGE_RATE,LOAN_CHARGE_GRACE_PERIOD_COUNT

  @sitint 
  Scenario Outline: Send request using the PMLAPP Client and then validate the data in the DB
    Given a request for sls webservice for id <scenarioid>
    Then setup the Payload with unique values for <SourceSystem>
    Then modify <AttributeName> to create a payload with <AttributeValue>
    Then modify <AttributeName2> to create a payload with <AttributeValue2>
    Then modify <AttributeName3> to create a payload with <AttributeValue3>
    When the request is sent to the PMLAPP Client
    Then validate that the DB received the payload correctly with EventProcessStatus as <EVAL_PROCSS_STATS>
    And validate that information has been stored correctly in the DB

    Examples: 
      #keys = "" send null in the tag, "null" deletes tag from XML
      | scenarioid | SourceSystem | AttributeName             | AttributeValue       | AttributeName2          | AttributeValue2           | AttributeName3                   | AttributeValue3 | EVAL_PROCSS_STATS |
      | "158"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1234567890123.12"   | "LOAN_LATE_CHARGE_RATE" | "1"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "159"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "1"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "160"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000"               | "LOAN_LATE_CHARGE_RATE" | "1"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "161"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "0"                  | "LOAN_LATE_CHARGE_RATE" | "1"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "162"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "null"               | "LOAN_LATE_CHARGE_RATE" | "1"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "163"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "123456789012345.12" | "LOAN_LATE_CHARGE_RATE" | "1"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Persist_Error"   |
      | "164"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | ""                   | "LOAN_LATE_CHARGE_RATE" | "1"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "165"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "1234.12345678"           | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "166"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "100.12"                  | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "167"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "1235.89"                 | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "168"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000"               | "LOAN_LATE_CHARGE_RATE" | "1234567890123.123456789" | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Persist_Error"   |
      | "169"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "0"                       | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "170"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "null"                    | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "171"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | ""                        | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "172"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "173"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "100.12"        | "Processed"       |
      | "174"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "32768"         | "Processed"       |
      | "175"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "0"             | "Processed"       |
      | "176"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "null"          | "Processed"       |
      | "177"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | ""              | "Processed"       |
      | "178"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "179"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "180"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
      | "181"      | "LCLA"       | "LOAN_LATE_CHARGE_AMOUNT" | "1000.12"            | "LOAN_LATE_CHARGE_RATE" | "11"                      | "LOAN_CHARGE_GRACE_PERIOD_COUNT" | "11"            | "Processed"       |
