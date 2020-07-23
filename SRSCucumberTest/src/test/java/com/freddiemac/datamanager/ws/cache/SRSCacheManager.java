package com.freddiemac.datamanager.ws.cache;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freddiemac.datamanager.ws.dao.DAOUtilis;
import com.freddiemac.datamanager.ws.dao.SelectSubmnQueryStringGenerator;
import com.freddiemac.datamanager.ws.request.setup.SRSScenarioMtch;
import com.freddiemac.datamanager.ws.util.StringUtils;

public class SRSCacheManager
{
   // Collection of Match keys
   private Set< String > appraisalIdentifierMatchs;
   private Set< String > loanUnderwritingCaseIdentifierMatchs;
   private Set< String > mERSMINIdentifierMatchs;
   private Set< String > lenderLoanIdentifierMatchs;
   private Set< String > textStdzdPptyAddrLiCnctntds;
   private Set< String > idPmlSubmnLinks;

   private static final Logger LOGGER = LoggerFactory.getLogger( SRSCacheManager.class );
   
   public SRSCacheManager()
   {
      appraisalIdentifierMatchs = new HashSet< >();
      loanUnderwritingCaseIdentifierMatchs = new HashSet< >();
      mERSMINIdentifierMatchs = new HashSet< >();
      lenderLoanIdentifierMatchs = new HashSet< >();
      textStdzdPptyAddrLiCnctntds = new HashSet< >();
      idPmlSubmnLinks = new HashSet< >();
   }

   public Map< String, Set< String > > loadSubmnQueryKeys( SRSScenarioMtch srsCurrentScenarioMtch)
   {
      
      if( StringUtils.isNotNull( srsCurrentScenarioMtch.getAppraisalIdentifierMtch() ) ) {
         appraisalIdentifierMatchs.add( srsCurrentScenarioMtch.getAppraisalIdentifierMtch() );
      }  
      
      if( StringUtils.isNotNull( srsCurrentScenarioMtch.getLoanUnderwritingCaseIdentifierMtch() ) ) {
         loanUnderwritingCaseIdentifierMatchs.add( srsCurrentScenarioMtch.getLoanUnderwritingCaseIdentifierMtch() );
      } 
      
      if( StringUtils.isNotNull( srsCurrentScenarioMtch.getMersminIdentifierMtch() ) ) {
         mERSMINIdentifierMatchs.add( srsCurrentScenarioMtch.getMersminIdentifierMtch() );
      } 
      
      if( StringUtils.isNotNull( srsCurrentScenarioMtch.getLenderLoanIdentifierMtch() ) ) {
                  
         lenderLoanIdentifierMatchs.add( srsCurrentScenarioMtch.getLenderLoanIdentifierMtch() );
      } 
      
      if( StringUtils.isNotNull( srsCurrentScenarioMtch.getAddressLineTextConcatenate() ) ) {
         textStdzdPptyAddrLiCnctntds.add( srsCurrentScenarioMtch.getAddressLineTextConcatenate() );
      } 
      
      Map< String, Set< String > > keys = DAOUtilis.populateCacheKeys( appraisalIdentifierMatchs, loanUnderwritingCaseIdentifierMatchs, mERSMINIdentifierMatchs, 
            lenderLoanIdentifierMatchs, textStdzdPptyAddrLiCnctntds, idPmlSubmnLinks );

      return keys;

   }
   
   public static String genSubmissionQuery( Map< String, Set< String > > keys, int fetchLimit, boolean enableSlsConcurrencyFlag ) {

      SelectSubmnQueryStringGenerator newGen = new SelectSubmnQueryStringGenerator( keys, fetchLimit,
                                                                                    enableSlsConcurrencyFlag );
      String queryString = newGen.generateQuery();
      
      LOGGER.info( "Candidate Query -> {}", queryString);
      
      return queryString;
      
   }

}
