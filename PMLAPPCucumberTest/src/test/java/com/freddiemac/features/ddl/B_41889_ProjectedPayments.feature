Feature: DDL - Enhance LCLA Integration - Projected Payment Integration

  @sitint
  Scenario Outline: To validate DDL for Projected Payment Integration
    Given DDL is deployed for scenario with id <scenarioid> for table <TableName> is deployed for schema <CurrentSchema>
    Then validate that DataType is <DataType> and Nullable is <Nullable> for column <ColName> with constraints <constraints>

    Examples: 
      | scenarioid | TableName       | CurrentSchema | ColName                            | Nullable | DataType        | constraints |
      |          1 | "LOAN_PRJTD_CF" | "UDBADM3"     | "ID_EVNT"                          | "N"      | "BIGINT"        | "PK,FK"     |
      |          2 | "LOAN_PRJTD_CF" | "UDBADM3"     | "NBR_LOAN_PRJTD_CF_SEQ"            | "Y"      | "BIGINT"        | "No"        |
      |          3 | "LOAN_PRJTD_CF" | "UDBADM3"     | "AMT_LOAN_PRJTD_ESCRW_PAYMT"       | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          4 | "LOAN_PRJTD_CF" | "UDBADM3"     | "AMT_LOAN_PRJTD_MAX_PI_PAYMT"      | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          5 | "LOAN_PRJTD_CF" | "UDBADM3"     | "AMT_LOAN_PRJTD_MI_PAYMT"          | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          6 | "LOAN_PRJTD_CF" | "UDBADM3"     | "AMT_LOAN_PRJTD_MINM_PI_PAYMT"     | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          7 | "LOAN_PRJTD_CF" | "UDBADM3"     | "AMT_LOAN_PRJTD_MINM_TOT_PAYMT"    | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          8 | "LOAN_PRJTD_CF" | "UDBADM3"     | "CD_PRJTD_PAYMT_CALCTN_PER_TERM"   | "Y"      | "VARCHAR"       | "No"        |
      |          9 | "LOAN_PRJTD_CF" | "UDBADM3"     | "CD_PRJTD_PAYMT_FREQ"              | "Y"      | "VARCHAR"       | "No"        |
      |         10 | "LOAN_PRJTD_CF" | "UDBADM3"     | "NBR_PRJTD_PAYMT_CALCTN_PER_END"   | "Y"      | "INTEGER"       | "No"        |
      |         11 | "LOAN_PRJTD_CF" | "UDBADM3"     | "NBR_PRJTD_PAYMT_CALCTN_PER_START" | "Y"      | "INTEGER"       | "No"        |
      |         12 | "LOAN_PRJTD_CF" | "UDBADM3"     | "DTTM_CREATE"                      | "N"      | "TIMESTMP"      | "No"        |
      |         13 | "LOAN_PRJTD_CF" | "UDBADM3"     | "DTTM_LST_UPDT"                    | "N"      | "TIMESTMP"      | "No"        |
      |         14 | "LOAN_PRJTD_CF" | "UDBADM3"     | "ID_CREATE"                        | "N"      | "VARCHAR"       | "No"        |
      |         15 | "LOAN_PRJTD_CF" | "UDBADM3"     | "ID_LST_UPDT"                      | "N"      | "VARCHAR"       | "No"        |
