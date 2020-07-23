Feature: B-50995 Implementation of LATE_CHARGE_TYPE and property valuation effective date

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
      #keys = "null value" send null in the tag, "without tag" deletes tag from XML
      | scenarioid | SourceSystem | AttributeName      | AttributeValue                           | AttributeName2                           | AttributeValue2                | EVAL_PROCSS_STATS |
      | "250"      | "LCLA"       | "LATE_CHARGE_TYPE" | "PercentOfPrincipalAndInterest"          | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 22 20:56:02 EDT 2009" | "Processed"       |
      | "251"      | "LCLA"       | "LATE_CHARGE_TYPE" | "NoLateCharges"                          | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 10 20:56:02 EDT 2009" | "Processed"       |
      | "252"      | "LCLA"       | "LATE_CHARGE_TYPE" | "PercentOfPrincipalAndInterest"          | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 15 20:56:02 EDT 2009" | "Processed"       |
      | "253"      | "LCLA"       | "LATE_CHARGE_TYPE" | "PercentageOfDelinquentInterest"         | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu May 17 20:56:02 EDT 2009" | "Processed"       |
      | "254"      | "LCLA"       | "LATE_CHARGE_TYPE" | "PercentageOfNetPayment"                 | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 27 20:56:02 EDT 2009" | "Processed"       |
      | "255"      | "LCLA"       | "LATE_CHARGE_TYPE" | "PercentageOfPrincipalBalance"           | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Mar 13 20:56:02 EDT 2009" | "Processed"       |
      | "256"      | "LCLA"       | "LATE_CHARGE_TYPE" | "PercentageOfTotalPayment"               | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 22 20:56:02 EDT 2010" | "Processed"       |
      | "257"      | "LCLA"       | "LATE_CHARGE_TYPE" | ""                                       | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 22 20:56:02 EDT 2015" | "Processed"       |
      | "258"      | "LCLA"       | "LATE_CHARGE_TYPE" | "null"                                   | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Feb 22 20:56:02 EDT 2009" | "Processed"       |
      | "259"      | "LCLA"       | "LATE_CHARGE_TYPE" | "Invalid Value"                          | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 22 20:56:02 EDT 2013" | "Processed"       |
      | "260"      | "LCLA"       | "LATE_CHARGE_TYPE" | "Character Length --Validation fails123" | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jun 10 20:56:02 EDT 2016" | "Persist_Error"   |
      | "261"      | "LCLA"       | "LATE_CHARGE_TYPE" | "NoLateCharges"                          | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Jan 22 20:56:02 EDT 2009" | "Processed"       |
      | "262"      | "LCLA"       | "LATE_CHARGE_TYPE" | "NoLateCharges"                          | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "Thu Feb 22 20:56:02 EDT 2009" | "Processed"       |
      | "263"      | "LCLA"       | "LATE_CHARGE_TYPE" | "NoLateCharges"                          | "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME" | "null"                         | "Processed"       |
