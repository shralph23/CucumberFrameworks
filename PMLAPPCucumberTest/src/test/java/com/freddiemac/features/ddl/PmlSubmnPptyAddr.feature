Feature: DDL - PML_SUBMN_PPTY_ADDR

  @sitint 
  Scenario Outline: To validate DDL for PML_SUBMN_PPTY_ADDR table
    Given DDL is deployed for scenario with id <scenarioid> for table <TableName> is deployed for schema <CurrentSchema>
    Then validate that DataType is <DataType> and Nullable is <Nullable> for column <ColName> with constraints <constraints>

    Examples: 
      | scenarioid | TableName             | CurrentSchema | ColName               | Nullable | DataType       | constraints |
      |          1 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "ID_EVNT"             | "N"      | "BIGINT"       | "PK,FK"     |
      |          2 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "NAME_ADDR_SRCE_TYPE" | "Y"      | "VARCHAR(35)"  | "No"        |
      |          3 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "CD_FIPS_ST_ALPHA"    | "Y"      | "CHAR(2)"      | "No"        |
      |          4 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "ID_ADDR_UNIT"        | "Y"      | "VARCHAR(50)"  | "No"        |
      |          5 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "CD_PSTL"             | "Y"      | "VARCHAR(18)"  | "No"        |
      |          6 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "CD_ZIP_PLUS_4"       | "Y"      | "VARCHAR(18)"  | "No"        |
      |          7 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "NAME_CITY"           | "Y"      | "VARCHAR(100)" | "No"        |
      |          8 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "TEXT_ADDR_LI"        | "Y"      | "VARCHAR(256)" | "No"        |
      |          9 | "PML_SUBMN_PPTY_ADDR" | "UDBADM3"     | "DTTM_CREATE"         | "N"      | "TIMESTMP"     | "No"        |
