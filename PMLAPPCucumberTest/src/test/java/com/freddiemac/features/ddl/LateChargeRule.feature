Feature: DDL - Enhance LCLA Integration - Late Charge Rule

  @sitint 
  Scenario Outline: To validate DDL for LATE_CHRG_RULE table
    Given DDL is deployed for scenario with id <scenarioid> for table <TableName> is deployed for schema <CurrentSchema>
    Then validate that DataType is <DataType> and Nullable is <Nullable> for column <ColName> with constraints <constraints>

    Examples: 
      | scenarioid | TableName        | CurrentSchema | ColName                      | DataType        | Nullable | constraints |
      |          1 | "LATE_CHRG_RULE" | "UDBADM3"     | "ID_PML_LATE_CHRG_RULE"      | "BIGINT"        | "N"      | "PK"        |
      |          2 | "LATE_CHRG_RULE" | "UDBADM3"     | "ID_EVNT"                    | "BIGINT"        | "N"      | "FK"        |
      |          3 | "LATE_CHRG_RULE" | "UDBADM3"     | "AMT_LOAN_LATE_CHRG"         | "DECIMAL(15,2)" | "Y"      | "No"        |
      |          4 | "LATE_CHRG_RULE" | "UDBADM3"     | "CD_LATE_CHRG"               | "VARCHAR(35)"   | "Y"      | "No"        |
      |          5 | "LATE_CHRG_RULE" | "UDBADM3"     | "CNT_LOAN_LATE_CHRG_GRC_PER" | "SMALLINT"      | "Y"      | "No"        |
      |          6 | "LATE_CHRG_RULE" | "UDBADM3"     | "DESC_LATE_CHRG"             | "VARCHAR(250)"  | "Y"      | "No"        |
      |          7 | "LATE_CHRG_RULE" | "UDBADM3"     | "RATE_LOAN_LATE_CHRG"        | "DECIMAL(12,8)" | "Y"      | "No"        |
      |          8 | "LATE_CHRG_RULE" | "UDBADM3"     | "DTTM_CREATE"                | "TIMESTMP"      | "N"      | "No"        |
      |          9 | "LATE_CHRG_RULE" | "UDBADM3"     | "DTTM_LST_UPDT"              | "TIMESTMP"      | "N"      | "No"        |
      |         10 | "LATE_CHRG_RULE" | "UDBADM3"     | "ID_CREATE"                  | "VARCHAR(128)"  | "N"      | "No"        |
      |         11 | "LATE_CHRG_RULE" | "UDBADM3"     | "ID_LST_UPDT"                | "VARCHAR(128)"  | "N"      | "No"        |
