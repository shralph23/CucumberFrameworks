Feature: DDL - To validate PML_SUBMN_TRANS

  @sitint 
  Scenario Outline: To validate DDL for PML_SUBMN_TRANS table
    Given DDL is deployed for scenario with id <scenarioid> for table <TableName> is deployed for schema <CurrentSchema>
    Then validate that DataType is <DataType> and Nullable is <Nullable> for column <ColName> with constraints <constraints>

    Examples: 
      | scenarioid | TableName         | CurrentSchema | ColName                              | Nullable | DataType        | constraints |
      |          1 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_EVNT"                            | "N"      | "BIGINT"        | "PK,FK"     |
      |          2 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_CASH_FROM_BORR_AT_CLSG"         | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          3 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_CASH_TO_BORR_AT_CLSG"           | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          4 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_NOTE"                           | "Y"      | "DECIMAL(15,2)" | "No"        |
      |          5 | "PML_SUBMN_TRANS" | "UDBADM3"     | "CNT_LOAN_MTY_PER"                   | "Y"      | "SMALLINT"      | "No"        |
      |          6 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DT_INTGRTD_DSCLR_ISUD"              | "Y"      | "DATE"          | "No"        |
      |          7 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DT_LOAN_CLSG"                       | "Y"      | "DATE"          | "No"        |
      |          8 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_APPRSL_DOC_FILE"                 | "Y"      | "VARCHAR(150)"  | "No"        |
      |          9 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_LOAN_UW_CASE"                    | "Y"      | "VARCHAR(150)"  | "No"        |
      |         10 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_MERS_MIN"                        | "Y"      | "VARCHAR(50)"   | "No"        |
      |         11 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_PML_SRCE_SUBMN_TRANS"            | "N"      | "VARCHAR(50)"   | "No"        |
      |         12 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_PML_SUBMN_LINK"                  | "N"      | "VARCHAR(50)"   | "No"        |
      |         13 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_SLR_LOAN"                        | "Y"      | "VARCHAR(50)"   | "No"        |
      |         14 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_ASMBLTY"                        | "Y"      | "VARCHAR(10)"   | "No"        |
      |         15 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_BD_TEMP_SUBDY"                  | "Y"      | "VARCHAR(10)"   | "No"        |
      |         16 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_LOAN_DMND_FTR"                  | "Y"      | "VARCHAR(10)"   | "No"        |
      |         17 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_LOAN_IO"                        | "Y"      | "VARCHAR(10)"   | "No"        |
      |         18 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_LOAN_PPMT_PNLTY"                | "Y"      | "VARCHAR(10)"   | "No"        |
      |         19 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_LOAN_PRTL_PAYMT_ALWD"           | "Y"      | "VARCHAR(10)"   | "No"        |
      |         20 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_MI_REQD"                        | "Y"      | "VARCHAR(10)"   | "No"        |
      |         21 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_NEGAM"                          | "Y"      | "VARCHAR(10)"   | "No"        |
      |         22 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_AUS_TYPE"                      | "Y"      | "VARCHAR(30)"   | "No"        |
      |         23 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_LOAN_AMTN_TYPE"                | "Y"      | "VARCHAR(30)"   | "No"        |
      |         24 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_LOAN_MTY_PER_TYPE"             | "Y"      | "VARCHAR(15)"   | "No"        |
      |         25 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_LOAN_PURP_TYPE"                | "Y"      | "VARCHAR(35)"   | "No"        |
      |         26 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_MRTG_TYPE"                     | "Y"      | "VARCHAR(30)"   | "No"        |
      |         27 | "PML_SUBMN_TRANS" | "UDBADM3"     | "RATE_LOAN_APR"                      | "Y"      | "DECIMAL(12,8)" | "No"        |
      |         28 | "PML_SUBMN_TRANS" | "UDBADM3"     | "RATE_LOAN_CLNG"                     | "Y"      | "DECIMAL(12,8)" | "No"        |
      |         29 | "PML_SUBMN_TRANS" | "UDBADM3"     | "RATE_LOAN_FLR"                      | "Y"      | "DECIMAL(12,8)" | "No"        |
      |         30 | "PML_SUBMN_TRANS" | "UDBADM3"     | "RATE_NT"                            | "Y"      | "DECIMAL(12,8)" | "No"        |
      |         31 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DTTM_CREATE"                        | "N"      | "TIMESTMP"      | "No"        |
      |         32 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_LOAN_ORIGR_TYPE"               | "Y"      | "VARCHAR(30)"   | "No"        |
      |         33 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_PRODT"                         | "Y"      | "VARCHAR(100)"  | "No"        |
      |         34 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_LOAN_PPTY_USG_TYPE"            | "Y"      | "VARCHAR(25)"   | "No"        |
      |         35 | "PML_SUBMN_TRANS" | "UDBADM3"     | "PCT_TOT_DBT_EXPNS_RATIO"            | "Y"      | "DECIMAL(7,4)"  | "No"        |
      |         36 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_STRUC_ATTCH_TYPE"              | "Y"      | "VARCHAR(15)"   | "No"        |
      |         37 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DESC_ATOMTD_UW_RCMDTN"              | "Y"      | "VARCHAR(256)"  | "No"        |
      |         38 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_LOAN_BLLN"                      | "Y"      | "VARCHAR(10)"   | "No"        |
      |         39 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_CNSTTN_METH_TYPE"              | "Y"      | "VARCHAR(20)"   | "No"        |
      |         40 | "PML_SUBMN_TRANS" | "UDBADM3"     | "CNT_FIND_UNIT"                      | "Y"      | "SMALLINT"      | "No"        |
      |         41 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_HELOC"                          | "Y"      | "VARCHAR(10)"   | "No"        |
      |         42 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_INIT_PI_PAYMT"                  | "Y"      | "DECIMAL(15,2)" | "No"        |
      |         43 | "PML_SUBMN_TRANS" | "UDBADM3"     | "CNT_LOAN_AMTN_PER"                  | "Y"      | "SMALLINT"      | "No"        |
      |         44 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_LOAN_AMTN_PER_TYPE"            | "Y"      | "VARCHAR(15)"   | "No"        |
      |         45 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_LOAN_MAN_UW"                    | "Y"      | "VARCHAR(10)"   | "No"        |
      |         46 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DT_LOAN_MTY"                        | "Y"      | "DATE"          | "No"        |
      |         47 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DT_LOAN_MODTN_EFF"                  | "Y"      | "DATE"          | "No"        |
      |         48 | "PML_SUBMN_TRANS" | "UDBADM3"     | "PCT_MI_CVRG"                        | "Y"      | "DECIMAL(7,4)"  | "No"        |
      |         49 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_PML_STS_TYPE"                  | "Y"      | "VARCHAR(10)"   | "No"        |
      |         50 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_PROJ_LEGL_STRUC_TYPE"          | "Y"      | "VARCHAR(30)"   | "No"        |
      |         51 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_PPTY_VALUTN"                    | "Y"      | "DECIMAL(15,2)" | "No"        |
      |         52 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DTTM_PPTY_VALUTN_EFF"               | "Y"      | "TIMESTMP"      | "No"        |
      |         53 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_BORR_PPTY_PCH_PRCE"             | "Y"      | "DECIMAL(15,2)" | "No"        |
      |         54 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_LOAN_REFIN_CSHOUT_DTMNTN_TYPE" | "Y"      | "VARCHAR(20)"   | "No"        |
      |         55 | "PML_SUBMN_TRANS" | "UDBADM3"     | "NAME_REFIN_PGM_TYPE"                | "Y"      | "VARCHAR(35)"   | "No"        |
      |         56 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_TOT_LIABS_MOL_PAYMT"            | "Y"      | "DECIMAL(15,2)" | "No"        |
      |         57 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_TMI"                            | "Y"      | "DECIMAL(15,2)" | "No"        |
      |         58 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_TOT_MOL_PRPSD_HSNG_EXPNS"       | "Y"      | "DECIMAL(15,2)" | "No"        |
      |         59 | "PML_SUBMN_TRANS" | "UDBADM3"     | "AMT_ENCMBRNC"                       | "Y"      | "DECIMAL(15,2)" | "No"        |
      |         60 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_MRGD_CR_SBMTD"                  | "Y"      | "VARCHAR(10)"   | "No"        |
      |         61 | "PML_SUBMN_TRANS" | "UDBADM3"     | "IND_MRGD_CR_ASESD"                  | "Y"      | "VARCHAR(10)"   | "No"        |
      |         62 | "PML_SUBMN_TRANS" | "UDBADM3"     | "CD_SRCE_SYST"                       | "N"      | "VARCHAR(50)"   | "No"        |
      |         63 | "PML_SUBMN_TRANS" | "UDBADM3"     | "CD_PRCSG_METH"                      | "Y"      | "VARCHAR(20)"   | "No"        |
      |         64 | "PML_SUBMN_TRANS" | "UDBADM3"     | "CD_LOAN_CNFRMTY"                    | "Y"      | "VARCHAR(50)"   | "No"        |
      |         65 | "PML_SUBMN_TRANS" | "UDBADM3"     | "DTTM_LST_UPDT"                      | "N"      | "TIMESTMP"      | "No"        |
      |         66 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_CREATE"                          | "N"      | "VARCHAR(128)"  | "No"        |
      |         67 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_LST_UPDT"                        | "N"      | "VARCHAR(128)"  | "No"        |
      |         68 | "PML_SUBMN_TRANS" | "UDBADM3"     | "ID_APPRSL"                          | "Y"      | "VARCHAR(32)"   | "No"        |
