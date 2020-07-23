package com.freddiemac.datamanager.ws.dao;

import java.util.Map;
import java.util.Set;

import com.freddiemac.datamanager.ws.util.CollectionUtils;
import com.freddiemac.datamanager.ws.constants.SRSConstants;

/***********************************************************************************************************************
*
* Generate String for Submission Collection Query not very generic, but a start
*
* do NOT include austype or partyid, both add little to the where clause, very
* few variations, and if you add them must be done in concatenation with sister
* parameters otherwise brings back LOTS of matches
*
* ausid/austype partyid/lenderloadnid
*
***********************************************************************************************************************/

/*select a.* from
(select ID_SUBMN,ID_PML_SUBMN_LINK,DTTM_SUBMN_RQST,NAME_SRCE_SYST,NAME_PRTY_ROLE_TYPE_MTCH,ID_PRTY_MTCH,NAME_STDZD_PPTY_CITY_MTCH,CD_STDZD_PPTY_FIPS_ST_ALPHA, 
ID_APPRSL_DOC_FILE_MTCH,ID_LENDR_LOAN_MTCH,ID_LOAN_UW_CASE_MTCH,ID_MERS_MIN_MTCH,NAME_AUS_TYPE_MTCH,CD_STDZD_PPTY_PSTL_MTCH,TEXT_STDZD_PPTY_ADDR_LI_MTCH, 
TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD,DTTM_CREATE,DTTM_LST_UPDT,ID_CREATE,ID_LST_UPDT 
from SUBMN_LINK_SVC_SUBMN b  
where b.ID_PML_SUBMN_LINK is not null and   
( b.ID_APPRSL_DOC_FILE_MTCH in ( :ID_APPRSL_DOC_FILE_MTCH ) )      --Appraisal ID Match

union  

select ID_SUBMN,ID_PML_SUBMN_LINK,DTTM_SUBMN_RQST,NAME_SRCE_SYST,NAME_PRTY_ROLE_TYPE_MTCH,ID_PRTY_MTCH,NAME_STDZD_PPTY_CITY_MTCH,CD_STDZD_PPTY_FIPS_ST_ALPHA, 
ID_APPRSL_DOC_FILE_MTCH,ID_LENDR_LOAN_MTCH,ID_LOAN_UW_CASE_MTCH,ID_MERS_MIN_MTCH,NAME_AUS_TYPE_MTCH,CD_STDZD_PPTY_PSTL_MTCH,TEXT_STDZD_PPTY_ADDR_LI_MTCH, 
TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD,DTTM_CREATE,DTTM_LST_UPDT,ID_CREATE,ID_LST_UPDT 
from SUBMN_LINK_SVC_SUBMN b  
where b.ID_PML_SUBMN_LINK is not null and   
( b.ID_LOAN_UW_CASE_MTCH in ( :ID_LOAN_UW_CASE_MTCH ) )     -- Id Loan Under Writing Case Match

union

select ID_SUBMN,ID_PML_SUBMN_LINK,DTTM_SUBMN_RQST,NAME_SRCE_SYST,NAME_PRTY_ROLE_TYPE_MTCH,ID_PRTY_MTCH,NAME_STDZD_PPTY_CITY_MTCH,CD_STDZD_PPTY_FIPS_ST_ALPHA, 
ID_APPRSL_DOC_FILE_MTCH,ID_LENDR_LOAN_MTCH,ID_LOAN_UW_CASE_MTCH,ID_MERS_MIN_MTCH,NAME_AUS_TYPE_MTCH,CD_STDZD_PPTY_PSTL_MTCH,TEXT_STDZD_PPTY_ADDR_LI_MTCH, 
TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD,DTTM_CREATE,DTTM_LST_UPDT,ID_CREATE,ID_LST_UPDT 
from SUBMN_LINK_SVC_SUBMN b  
where b.ID_PML_SUBMN_LINK is not null and   
( b.ID_MERS_MIN_MTCH in ( :ID_MERS_MIN_MTCH ) )   -- Id MERS MIN Match

union  

select ID_SUBMN,ID_PML_SUBMN_LINK,DTTM_SUBMN_RQST,NAME_SRCE_SYST,NAME_PRTY_ROLE_TYPE_MTCH,ID_PRTY_MTCH,NAME_STDZD_PPTY_CITY_MTCH,CD_STDZD_PPTY_FIPS_ST_ALPHA, 
ID_APPRSL_DOC_FILE_MTCH,ID_LENDR_LOAN_MTCH,ID_LOAN_UW_CASE_MTCH,ID_MERS_MIN_MTCH,NAME_AUS_TYPE_MTCH,CD_STDZD_PPTY_PSTL_MTCH,TEXT_STDZD_PPTY_ADDR_LI_MTCH, 
TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD,DTTM_CREATE,DTTM_LST_UPDT,ID_CREATE,ID_LST_UPDT 
from SUBMN_LINK_SVC_SUBMN b  
where b.ID_PML_SUBMN_LINK is not null and   
( b.ID_LENDR_LOAN_MTCH in ( :ID_LENDR_LOAN_MTCH ) )      -- Id Lender Loan Match

union  

select  ID_SUBMN,ID_PML_SUBMN_LINK,DTTM_SUBMN_RQST,NAME_SRCE_SYST,NAME_PRTY_ROLE_TYPE_MTCH,ID_PRTY_MTCH,NAME_STDZD_PPTY_CITY_MTCH,CD_STDZD_PPTY_FIPS_ST_ALPHA, 
ID_APPRSL_DOC_FILE_MTCH,ID_LENDR_LOAN_MTCH,ID_LOAN_UW_CASE_MTCH,ID_MERS_MIN_MTCH,NAME_AUS_TYPE_MTCH,CD_STDZD_PPTY_PSTL_MTCH,TEXT_STDZD_PPTY_ADDR_LI_MTCH, 
TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD,DTTM_CREATE,DTTM_LST_UPDT,ID_CREATE,ID_LST_UPDT 
from SUBMN_LINK_SVC_SUBMN b  
where b.ID_PML_SUBMN_LINK is not null and  ( b.TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD in ( :TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD ) )  )a    --Address

ORDER BY a.DTTM_CREATE DESC FETCH FIRST 1000 ROWS ONLY WITH UR*/

public class SelectSubmnQueryStringGenerator {

	private String whereClausPre = "where ";
	private String whereClausField = ".ID_PML_SUBMN_LINK";
	private String whereClausPost = " is not null and ";
	private boolean wasFirstItemAdded = Boolean.FALSE;

	private String union = " union ";
	
	private Map< String, Set< String > > keys = null;

	// derived based on constructor
   private String aAlias = "";
   private String bAlias = "";
	private String prefix = "";

	public static final String DEFAULT_A_ALIAS = "a";

	public static final String B_ENTITY_NAME = SRSConstants.SUBMN_LINK_SVC_SUBMN_TABLE_NAME;
	public static final String DEFAULT_B_ALIAS = "b";

	public static final String FIELDS = "ID_SUBMN,ID_PML_SUBMN_LINK,DTTM_SUBMN_RQST,NAME_SRCE_SYST,NAME_PRTY_ROLE_TYPE_MTCH,ID_PRTY_MTCH,"
	                                    + "NAME_STDZD_PPTY_CITY_MTCH,CD_STDZD_PPTY_FIPS_ST_ALPHA,ID_APPRSL_DOC_FILE_MTCH,"	                                       
	                                    + "ID_LENDR_LOAN_MTCH,ID_LOAN_UW_CASE_MTCH,ID_MERS_MIN_MTCH,NAME_AUS_TYPE_MTCH,"	                                    
	                                    + "CD_STDZD_PPTY_PSTL_MTCH,TEXT_STDZD_PPTY_ADDR_LI_MTCH,TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD," 
	                                    + "DTTM_CREATE,DTTM_LST_UPDT,ID_CREATE,ID_LST_UPDT";

	private static final String ORDER_BY = " ORDER BY ";
	private static final String DTTM_CREATE = ".DTTM_CREATE DESC ";
	private static final String FETCH_PREFIX = "FETCH FIRST ";
	private static final String FETCH_POSTFIX = " ROWS ONLY ";

	private boolean enableSlsConcurrencyFlag = Boolean.TRUE;
	private static final String WITH_UR = "WITH UR";
	private int fetchLimit = 1000;
	private String preQuery = "";

	public SelectSubmnQueryStringGenerator() {
	}
	
	public SelectSubmnQueryStringGenerator( Map< String, Set< String > > keys ) {
		
	   this();
		initialize( DEFAULT_A_ALIAS, DEFAULT_B_ALIAS, keys, fetchLimit, enableSlsConcurrencyFlag );
		
	}

	public SelectSubmnQueryStringGenerator( Map< String, Set< String > > keys, 
	                                        int fetchLimit,
	                                        Boolean enableSlsConcurrencyFlag ) {
		this();
		initialize( DEFAULT_A_ALIAS, DEFAULT_B_ALIAS, keys, fetchLimit, enableSlsConcurrencyFlag );
		
	}

	public SelectSubmnQueryStringGenerator( String aAlias, String bAlias, Map< String, Set< String > > keys, 
                                           int fetchLimit, Boolean enableSlsConcurrencyFlag )  {
	   
	   this();
	   initialize( aAlias, bAlias, keys, fetchLimit, enableSlsConcurrencyFlag );
	   
	}
	
   // Query need to be created in fixed order as per these search keys(1 --> "ID_APPRSL_DOC_FILE_MTCH", 2 --> "ID_LOAN_UW_CASE_MTCH",
	//3 --> "ID_MERS_MIN_MTCH", 4 --> "ID_LENDR_LOAN_MTCH", 5 --> "TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD")
	public String generateQuery() {
		StringBuilder bld = new StringBuilder();
		bld.append(prefix);

		keys.entrySet().stream()
		                  .filter( srsCacheKeyEntry -> CollectionUtils.doesCollectionContainsValue( srsCacheKeyEntry.getValue() ) )
		                  .forEach( srsCacheKeyEntry ->  {  if (wasFirstItemAdded()) {
		                                                      bld.append( union );
                                 		                   } else {
                                 		                     setWasFirstItemAdded( Boolean.TRUE );
                                 		                   }
                  
                                    		                bld.append(preQuery);
                                    		                bld.append( whereClausPre + this.bAlias + whereClausField + whereClausPost );
                     
                                    		                bld.append(" ( " + this.bAlias + "." + srsCacheKeyEntry.getKey() + " in ( ");
                                    		                bld.append(":" + srsCacheKeyEntry.getKey() + " ) ) " );
		                                                 } );
		
		if (bld.length() != 0)
		{
			bld.append( ")" + this.aAlias + ORDER_BY + this.aAlias + DTTM_CREATE 			      
			            + FETCH_PREFIX + fetchLimit + FETCH_POSTFIX );
			// if Concurrency Flag is enabled , add the WITH UR for concurrency purposes to
			// remove any specific locks.
			if (enableSlsConcurrencyFlag) {
				bld.append(WITH_UR);
			}
		}
		String theQuery = bld.toString();
		return theQuery;
	}

	private boolean wasFirstItemAdded() {
		return wasFirstItemAdded;
	}

	private void setWasFirstItemAdded(boolean wasFirstItemAdded) {
		this.wasFirstItemAdded = wasFirstItemAdded;
	}

	private void initialize( String aAlias, String bAlias, Map< String, Set< String > > keys, 
	                         int fetchLimit, boolean enableSlsConcurrencyFlag ) {
	   
	   this.aAlias = aAlias;
	   this.bAlias = bAlias;
		this.keys = keys;
		this.wasFirstItemAdded = Boolean.FALSE;
		this.prefix = "select  " + this.aAlias + ".* from " + "( ";
		this.preQuery = "select " + FIELDS + " from " + B_ENTITY_NAME + " " + this.bAlias + " ";
		this.fetchLimit = fetchLimit;
		this.enableSlsConcurrencyFlag = enableSlsConcurrencyFlag;
		
	}

}
