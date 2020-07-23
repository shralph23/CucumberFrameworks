package com.freddiemac.datamanager.ws.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SRSConstants
{
   //string 
   public static final String EMPTY_STRING = "";
   
   public static final String SRS_WEBSERVICE_URL = "SRS.webservice.url";
   public static final String SRS_WEBSERVICE_USER = "SRS.webservice.user";
   public static final String SRS_WEBSERVICE_PWD = "SRS.webservice.pwd";

   public static final String SLMS_WEBSERVICE_URL = "slsnextgen.webservice.url";
   public static final String SLMS_WEBSERVICE_USER = "slsnextgen.webservice.user";
   public static final String SLMS_WEBSERVICE_PWD = "slsnextgen.webservice.pwd";

   public static final String HIBERNATE_PERSISTENCE_UNIT = "slsjpacucumber";

   //QueryConstants
   public static final String ID_PML_SUBMN_LINK = "ID_PML_SUBMN_LINK";
   public static final String NBR_TXPYR_IDTN = "NBR_TXPYR_IDTN";
   public static final String SUBMN_LINK_SVC_SUBMN_TABLE_NAME = "SUBMN_LINK_SVC_SUBMN";
   //SubmnLinkSvcSubmn
   public static final String ID_SUBMN = "ID_SUBMN";
   public static final String ID_APPRSL_DOC_FILE = "ID_APPRSL_DOC_FILE";
   public static final String ID_APPRSL_DOC_FILE_MTCH = "ID_APPRSL_DOC_FILE_MTCH";
   public static final String ID_LOAN_UW_CASE = "ID_LOAN_UW_CASE";
   public static final String ID_LOAN_UW_CASE_MTCH = "ID_LOAN_UW_CASE_MTCH";
   public static final String ID_MERS_MIN = "ID_MERS_MIN";
   public static final String ID_MERS_MIN_MTCH = "ID_MERS_MIN_MTCH";
   public static final String ID_LENDR_LOAN = "ID_LENDR_LOAN";
   public static final String ID_LENDR_LOAN_MTCH = "ID_LENDR_LOAN_MTCH";
   public static final String NAME_AUS_TYPE = "NAME_AUS_TYPE";
   public static final String NAME_AUS_TYPE_MTCH = "NAME_AUS_TYPE_MTCH";
   public static final String ID_PRTY = "ID_PRTY";
   public static final String ID_PRTY_MTCH = "ID_PRTY_MTCH";
   public static final String NAME_PRTY_ROLE_TYPE = "NAME_PRTY_ROLE_TYPE";
   public static final String NAME_PRTY_ROLE_TYPE_MTCH = "NAME_PRTY_ROLE_TYPE_MTCH";
   public static final String ID_DOC = "ID_DOC";
   public static final String ID_PML_SRCE_SUBMN_TRANS = "ID_PML_SRCE_SUBMN_TRANS";
   public static final String ID_FM_LOAN = "ID_FM_LOAN";
   public static final String TEXT_STDZD_PPTY_ADDR_LI = "TEXT_STDZD_PPTY_ADDR_LI";
   public static final String TEXT_STDZD_PPTY_ADDR_LI_MTCH = "TEXT_STDZD_PPTY_ADDR_LI_MTCH";
   public static final String NAME_STDZD_PPTY_CITY = "NAME_STDZD_PPTY_CITY";
   public static final String NAME_STDZD_PPTY_CITY_MTCH = "NAME_STDZD_PPTY_CITY_MTCH";
   public static final String NBR_TEXT_STRT_PRIM = "NBR_TEXT_STRT_PRIM";
   public static final String CD_STDZD_PPTY_FIPS_ST_ALPHA = "CD_STDZD_PPTY_FIPS_ST_ALPHA";
   public static final String CD_STDZD_PPTY_PSTL = "CD_STDZD_PPTY_PSTL";
   public static final String CD_STDZD_PPTY_PSTL_MTCH = "CD_STDZD_PPTY_PSTL_MTCH";

   public static final String STUBBED_PARTY_ID = "000601";

   //Queries
   public static final String PML_SUBMN_LINK_QUERY = "Select * from PML_SUBMN_LINK l where l.id_pml_submn_link in (:" + ID_PML_SUBMN_LINK + ")";
   public static final String SUBMN_LINK_BORR_QUERY = "Select distinct ID_PML_SUBMN_LINK,NBR_TXPYR_IDTN from SUBMN_LINK_BORR b where b.ID_PML_SUBMN_LINK in (:" + ID_PML_SUBMN_LINK
         + ") ORDER BY b.ID_PML_SUBMN_LINK, b.NBR_TXPYR_IDTN ASC";
   public static final String ID_SUBMN_FROM_SUBMN_LINK_SVC_SUBMN_QUERY = "SELECT c.ID_PML_SUBMN_LINK,c.ID_SUBMN FROM UDBADM.SUBMN_LINK_SVC_SUBMN c where c.ID_SUBMN in (:" + ID_SUBMN + ")";

   // SQL query search keys constants
   public static final String SQL_SEARCH_KEY_IDPMLSUBMNLINK = "ID_PML_SUBMN_LINK";
   public static final String SQL_SEARCH_KEY_DOCFILEID_MTCH = "ID_APPRSL_DOC_FILE_MTCH";
   public static final String SQL_SEARCH_KEY_LENDERLOANID_MTCH = "ID_LENDR_LOAN_MTCH";
   public static final String SQL_SEARCH_KEY_AUSID_MTCH = "ID_LOAN_UW_CASE_MTCH";
   public static final String SQL_SEARCH_KEY_MERSMINID_MTCH = "ID_MERS_MIN_MTCH";
   public static final String SQL_SEARCH_KEY_ADDRESSTEXT_POSTALCODE_MTCH = "TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD";
   public static final String SQL_SUBMISSION_QUERY = "SUBMISSION";
   
   private static final List< String > SQL_SEARCH_KEYS_MUTABLE  = Arrays.asList( SQL_SEARCH_KEY_DOCFILEID_MTCH, SQL_SEARCH_KEY_AUSID_MTCH,
                                                                                 SQL_SEARCH_KEY_MERSMINID_MTCH, SQL_SEARCH_KEY_LENDERLOANID_MTCH,
                                                                                 SQL_SEARCH_KEY_ADDRESSTEXT_POSTALCODE_MTCH, SQL_SEARCH_KEY_IDPMLSUBMNLINK );
   public static final List< String > SQL_SEARCH_KEYS = Collections.unmodifiableList( SQL_SEARCH_KEYS_MUTABLE );

   // Validate SRS Input Request Validation Attributes
   public static final String ADDRESS_KEY_SPACE = " ";
   public static final int ADDRESS_NUMERIC_TWO_HUNDRED_FIFTY = 250;
   public static final int ADDRESS_NUMERIC_ZERO = 0;
   public static final String NUMERIC_ONE = "1";
   public static final String NUMERIC_TWO = "2";
   public static final String LOAN_UW_CASE = "5";
   public static final int POSTAL_KEY_LENGTH = 5;
   public static final int AUSID_LPA_KEY_LENGTH = 8;
   public static final int AUSID_DU_KEY_LENGTH = 10;
   public static final int DOC_FILE_ID_KEY_LENGTH = 10;
   public static final int MERSMIN_KEY_LENGTH = 18;
   public static final int LENDER_LOAN_ID_KEY_LENGTH = 50;

   // LP Field
   public static final String LP_FIELD = "LoanProspector";
   public static final String LP_FIELD_UPPER = "LOANPROSPECTOR";
   public static final String LPA_FIELD = "LoanProductAdvisor";
   public static final String LPA_FIELD_UPPER = "LOANPRODUCTADVISOR";

   // DU Field
   public static final String DU_FIELD = "DesktopUnderwriter";
   public static final String DU_FIELD_UPPER = "DESKTOPUNDERWRITER";

   public static final String SRS_NOT_FOUND = "NOT_FOUND";
   public static final String SRS_FOUND = "FOUND";

   //FaultType
   public static final String FAULT_TYPE_ERROR_CODE = "ErrorCode";
   public static final String FAULT_TYPE_MESSAGE = "Message";
   public static final String FAULT_TYPE_KB_ARTICLE_ID = "KbArticleId";
   public static final String FAULT_TYPE_TIMESTAMP = "TimeStamp";
   public static final String FAULT_TYPE_URI = "Uri";

   //DB Column Length
   public static final int DB_COLUMN_LENGTH_TWO = 2;
   public static final int DB_COLUMN_LENGTH_EIGHTEEN = 18;
   public static final int DB_COLUMN_LENGTH_THIRTY = 30;
   public static final int DB_COLUMN_LENGTH_THIRTYFIVE = 35;
   public static final int DB_COLUMN_LENGTH_THIRTYSIX = 36;
   public static final int DB_COLUMN_LENGTH_FIFTY = 50;
   public static final int DB_COLUMN_LENGTH_HUNDRED = 100;
   public static final int DB_COLUMN_LENGTH_ONEHUNDREDFIFTY = 150;
   public static final int DB_COLUMN_LENGTH_TWOHUNDREDFIFTYSIX = 256;

   //Submision attribute names
   public static final String CORRELATION_IDENTIFIER = "CorrelationIdentifier";
   public static final String MERSMIN_IDENTIFIER = "MersminIdentifier";
   public static final String AUTOMATED_UNDERWRITING_SYSTEM_TYPE = "AutomatedUnderwritingSystemType";
   public static final String LOAN_UNDERWRITING_CASE_IDENTIFIER = "LoanUnderwritingCaseIdentifier";
   public static final String APPRAISAL_IDENTIFIER = "AppraisalIdentifier";
   public static final String PARTY_IDENTIFIER = "PartyIdentifier";
   public static final String PARTY_ROLE_TYPE = "PartyRoleType";
   public static final String LENDER_LOAN_IDENTIFIER = "LenderLoanIdentifier";
   public static final String SOURCE_SYSTEM_TRANSACTION_IDENTIFIER = "SourceSystemTransactionIdentifer";
   public static final String FREDDIEMAC_LOAN_IDENTIFIER = "FreddieMacLoanIdentifier";
   public static final String DOCUMENT_IDENTIFIER = "DocumentIdentifier";
   public static final String ADDRESS_LINE_TEXT = "AddressLineText";
   public static final String STREET_PRIMARY_NUMBER_TEXT = "StreetPrimaryNumberText";
   public static final String STREET_NAME = "StreetName";
   public static final String CITY_NAME = "CityName";
   public static final String POSTAL_CODE = "PostalCode";
   public static final String ZIP_PLUS_FOUR_CODE = "ZipPlusFourCode";
   public static final String TAXPAYER_IDENTIFICATION_NUMBER = "TaxpayerIdentificationNumbers";
   public static final String NO_ATTRIBUTE = "NoAttribute";

   //Exclude Patterns
   public static final String APPRAISAL_IDENTIFIER_EXCLUDE_PATTERN = "1111111111";
   public static final String MERSMIN_IDENTIFIER_EXCLUDE_PATTERN = "112233445566778899";
   public static final String LENDER_LOAN_IDENTIFIER_EXCLUDE_PATTERN = "^0+$,^1+$,^[a-zA-Z ]+$,^1234$,^12345$,^123456$,^1234567$,^12345678$,^123456789$,^[a-zA-Z0-9]{3}$,^[a-zA-Z0-9]{2}$,^[a-zA-Z0-9]{1}$";
   public static final String SLS_ADDRESS_LINE_TEXT_MATCH_EXCLUDE_PATTERN = "0000 PREAPPROVAL ST,0000 PREAPPROVAL STREET,1 TBD,1 TO BE DETERMINED,123 MAIN ST,123 E MAIN ST,123 MAIN,123 MAIN STREET,123 N MAIN ST,123 PRE-APPROVAL,123 S MAIN ST,123 STREET,123 TBD,123 TBD ST,123 TBD STREET,123 UNKNOWN,123 W MAIN ST,1234 MAIN ST,1234 TBD,555 TBD,456 SOMEWHERE AVE,N PROPERTY,N PROPERTY ADDRESS,N/A,NO PROPERTY,NO PROPERTY ADDRESS,PRE APPROVAL,PREAPPROVAL,PRE-APPROVAL,PREQUAL,PRE-QUAL,PREQUAL ONLY,PREQUALIFICATION,SEE ATTACHED EXHIBIT A,TBA,TBD,TBD STREET,TBD TBD,TO BE DETERMINED,UNKNOWN";

   public static final String STUBBED_SLID = "00000000-0000-0000-0000-000000000000";
   
   public static final String NO_ATTRIBUTE_ERR_MSG = "Submission must contain a non-null/non-empty value in anyone of these attributes - [MersminIdentifier|LoanUnderwritingCaseIdentifier|AppraisalIdentifier|LenderLoanIdentifier|AddressLineText & PostalCode]";

   private SRSConstants() {
   }
   
}
