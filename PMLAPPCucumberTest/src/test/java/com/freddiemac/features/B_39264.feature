Feature: B-39264 Regression tests for different source systems

  @sitint @dev
  Scenario Outline: Send request using the PMLAPP Client and then validate the data in the DB
    Given a request for sls webservice for id <Scenarioid>
    Then setup the Payload with unique values for <SourceSystem>
    When the request is sent to the PMLAPP Client
    Then validate that the DB received the payload correctly with EventProcessStatus as <EVAL_PROCSS_STATS>
    And validate that information has been stored correctly in the DB

    Examples:
      | Scenarioid | SourceSystem | EVAL_PROCSS_STATS |
      | "1"        | "LCAE"       | "Processed"       |
      | "2"        | "LCLA"       | "Processed"       |
      | "3"        | "LQA"        | "Processed"       |
      | "4"        | "LPA"        | "Processed"       |
