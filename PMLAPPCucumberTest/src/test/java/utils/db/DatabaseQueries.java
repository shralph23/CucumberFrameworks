package utils.db;

public class DatabaseQueries {

    public static final String QUERY_TO_APPEND =  "0 from evnt where id_ety in (:idety ))";

    public static final String PROPERTY_VALUATION_QUERY = "select ID_Evnt,DTTM_PPTY_VALUTN_EFF from pml_submn_trans where id_evnt = (select MAX(id_evnt) -";
    public static final String PROPERTY_VALUATION_ASSESSMENT_APPRAISAL_QUERY = "select ID_Evnt,NBR_FM_APPRSL_QUAL_SCR,NBR_PPTY_VALUTN_ALGNMT_SCR from apprsl where id_evnt = (select MAX(id_evnt) -";
    public static final String PROPERTY_VALUATION_APPRAISAL_QUERY = "select ID_Evnt,CD_PPTY_VALUTN_FORM from apprsl where id_evnt = (select MAX(id_evnt) -";
    public static final String lATE_CHARGE_RULE_QUERY = "select ID_Evnt,AMT_LOAN_LATE_CHRG,RATE_LOAN_LATE_CHRG,CNT_LOAN_LATE_CHRG_GRC_PER,"
            + "CD_LATE_CHRG from late_chrg_rule where id_evnt = (select MAX(id_evnt) -";
    public static final String LOAN_UNDERWRITING_DECISION_QUERY = "select ID_Evnt,DESC_ATOMTD_UW_RCMDTN from late_chrg_rule where id_evnt = (select MAX(id_evnt) -";
    public static final String SELLER_ACCOUNT_QUERY = "select ID_Evnt,ID_SLR_ACCT,NAME_SLR from slr where id_evnt = (select MAX(id_evnt) -";
    public static final String SELLER_USER_QUERY = "select ID_Evnt,ID_SLR_USER from slr_user where id_evnt = (select MAX(id_evnt) -";
    public static final String DOCUMENT_GROUP_QUERY = "select ID_Evnt,NAME_DOC_GRP_TYPE,NAME_DOC_REQ_STSFD_TYPE from pml_submn_doc_grp where id_evnt = (select MAX(id_evnt) -";
    public static final String LOAN_SUBMISSION_BATCH_QUERY = "select ID_Evnt,ID_SRCE_BCH,CD_SRCE_SYST from pml_submn_bch where id_evnt = (select MAX(id_evnt) -";
    public static final String LOAN_PROJECTED_CASH_FLOW_QUERY = "select ID_Evnt,NBR_LOAN_PRJTD_CF_SEQ,AMT_LOAN_PRJTD_ESCRW_PAYMT,AMT_LOAN_PRJTD_MAX_PI_PAYMT,AMT_LOAN_PRJTD_MAX_TOT_PAYMT,AMT_LOAN_PRJTD_MI_PAYMT,AMT_LOAN_PRJTD_MINM_PI_PAYMT,"
            + "AMT_LOAN_PRJTD_MINM_TOT_PAYMT,NBR_PRJTD_PAYMT_CALCTN_PER_END,NBR_PRJTD_PAYMT_CALCTN_PER_START,CD_PRJTD_PAYMT_CALCTN_PER_TERM,CD_PRJTD_PAYMT_FREQ from loan_prjtd_cf where id_evnt = (select MAX(id_evnt) -";
    public static final String EVALUATION_SERVICE_QUERY = "select ID_Evnt,NAME_EVAL_RSLT_MSG_SRCE_TYPE,NAME_EVAL_SVC_CAT,DESC_EVAL_SVC_CNCLSN,ID_EVAL_SVC from eval_svc where id_evnt = (select MAX(id_evnt) -";
    public static final String PARTY_ROLE_QUERY = "select ID_Evnt,ID_PRTY,NAME_PRTY_ROLE_TYPE from pml_submn_prty_role where id_evnt = (select MAX(id_evnt) -";
    public static final String PARTY_LICENSE_QUERY = "select ID_Evnt,ID_LICNS from pml_submn_prty_licns where id_evnt = (select MAX(id_evnt) -";
    public static final String EVALUATION_SERVICE_RESULT_DETAIL_QUERY = "select ID_Evnt,NBR_EVAL_RSLT_SEQ,CD_EVAL_RSLT_CAT from eval_rslt_det where id_evnt = (select MAX(id_evnt) -";
    public static final String EVALUATION_SERVICE_RESULT_MESSAGE_QUERY = "select ID_Evnt,ID_EVAL_RSLT_MSG,DESC_EVAL_RSLT_MSG_DCSN,NAME_EVAL_RSLT_MSG_SECT,CD_EVAL_RSLT_MSG_SECT,"
            + "TEXT_EVAL_RSLT_MSG,CD_EVAL_RSLT_MSG,NAME_EVAL_RSLT_MSG_CAT_TYPE from eval_rslt_msg where id_evnt = (select MAX(id_evnt) -";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_QUERY = "select ID_Evnt,NAME_ADDR_SRCE_TYPE,CD_FIPS_ST_ALPHA,CD_PSTL,CD_ZIP_PLUS_4,NAME_CITY,TEXT_ADDR_LI,ID_ADDR_UNIT from pml_submn_ppty_addr where id_evnt = (select MAX(id_evnt) -";
    public static final String APPRSL_QUERY = "select ID_Evnt,DTTM_LCA_SUBMN,DTTM_PPTY_VALUTN_EFF,AMT_PPTY_APPRSD_VAL,ID_APPRSL_DOC,TEXT_UCDP_DOC_SCS_STS from apprsl where id_evnt = (select MAX(id_evnt) -";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_BORROWER_QUERY = "select ID_Evnt,NAME_BORR_CLSFN_TYPE,NAME_CR_RPSTRY_SRCE_TYPE,ID_CR_RPT,NAME_INDVL_FRST,NAME_INDVL_LST,NAME_INDVL_FULL,IND_BKRPTY from pml_submn_borr where id_evnt = (select MAX(id_evnt) -";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY = "select ID_Evnt,ID_PML_SRCE_SUBMN_TRANS,ID_PML_SUBMN_LINK,NAME_AUS_TYPE,ID_LOAN_UW_CASE,IND_MI_REQD,IND_ASMBLTY,NAME_LOAN_AMTN_TYPE,IND_LOAN_DMND_FTR,IND_LOAN_IO,CNT_LOAN_MTY_PER,NAME_LOAN_MTY_PER_TYPE,IND_LOAN_PRTL_PAYMT_ALWD,"
            + "IND_LOAN_PPMT_PNLTY,NAME_LOAN_PURP_TYPE,ID_MERS_MIN,NAME_MRTG_TYPE,IND_BD_TEMP_SUBDY,CD_PRCSG_METH,RATE_LOAN_APR,AMT_NOTE,RATE_NT,DT_INTGRTD_DSCLR_ISUD,ID_SLR_LOAN,ID_APPRSL_DOC_FILE,DTTM_CREATE,DTTM_LST_UPDT,ID_CREATE,"
            + "ID_LST_UPDT,DESC_ATOMTD_UW_RCMDTN from pml_submn_trans where id_evnt = (select MAX(id_evnt) -";
    public static final String CASH_TO_CLOSE_ITEM_QUERY = "select ID_Evnt,CD_CASH_TO_CLOS_ITEM,AMT_ESTD,AMT_FNL,CD_PAYMT from cash_to_clos_item where id_evnt = (select MAX(id_evnt) -";
    public static final String DOCUMENT_DETAIL_QUERY = "select ID_Evnt,NAME_DOC_TYPE,NAME_DOC_STS_TYPE from pml_submn_doc_det where id_evnt = (select MAX(id_evnt) -";
    public static final String COLLATERAL_RISK_ASSESSMENT_CONTAINER_QUERY = "select ID_Evnt,NAME_LOAN_SCP_TYPE,PCT_LTV_RATIO,NAME_LTV_SRCE_TYPE from pml_submn_cra where id_evnt = (select MAX(id_evnt) -";
    public static final String CONTRACT_CONTAINER_QUERY = "select ID_Evnt,NAME_CONT_LVL_TYPE,ID_PML_SUBMN_CONT from PML_SUBMN_CONT where id_evnt = (select MAX(id_evnt) -";

    public static final String EVENT_PROCESS_STATUS_QUERY = "select NAME_EVNT_PROCSS_STS_TYPE from evnt_procss_sts where id_evnt in(select id_evnt from evnt where id_evnt_msg_unvrsl_uniq in (:messageID ))";
}
