package com.freddiemac.datamanager.ws.request.setup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import com.freddiemac.datamanager.ws.dao.dto.SubmnLinkSvcSubmn;
import com.freddiemac.datamanager.ws.slms.model.*;
import com.freddiemac.datamanager.ws.srs.model.RequestMetadataType;
import com.freddiemac.datamanager.ws.srs.model.RequestType;
import com.freddiemac.datamanager.ws.util.CollectionUtils;
import com.freddiemac.datamanager.ws.util.StringUtils;
import com.freddiemac.datamanager.ws.validation.SRSRequestScrubbingValidation;

import datageneration.generic.DataGeneratorUtils;


public class SLMSRequestSetup
{
   public static SLMSRequest getSLMSRequest( SRSScenarioMtch srsScenarioMtch, RequestType requestType, List< SubmnLinkSvcSubmn > submnLists, Map< String, ArrayList< String > > borrowerSlidMap )
         throws DatatypeConfigurationException
   {

      SLMSRequest slmsRequest = new SLMSRequest();
      slmsRequest.setSLMSRequestMetaData( getSLMSRequestMetaData( requestType ) );
      slmsRequest.setSLSRequestMetaData( getSLSRequestMetaData( requestType.getRequestMetadata() ) );
      slmsRequest.setSLSSubmissions( getListofSubmissions( srsScenarioMtch, requestType, submnLists ) );
      slmsRequest.setSLSPossibleMatches( getListofSLSPossibleMatches( submnLists, borrowerSlidMap ) );
      return slmsRequest;

   }

   public static SLMSRequestMetaData getSLMSRequestMetaData( RequestType requestType ) throws DatatypeConfigurationException
   {
      SLMSRequestMetaData slmsRequestMetaData = new SLMSRequestMetaData();
      slmsRequestMetaData.setSLMSRequstIdentifier( DataGeneratorUtils.generateUniqueId() );
      slmsRequestMetaData.setSLMSRequstRecordCount( requestType.getRequestMetadata().getRequestRecordCount() );
      slmsRequestMetaData.setSLMSRequstSourceSystem( "SLS" );
      slmsRequestMetaData.setSLMSRequstTimeStamp( DataGeneratorUtils.getXMLGregorianCalendarNow().toString() );

      return slmsRequestMetaData;

   }

   public static SLSRequestMetaData getSLSRequestMetaData( RequestMetadataType requestMetadata )
   {
      SLSRequestMetaData slsRequestMetadata = new SLSRequestMetaData();
      slsRequestMetadata.setRequstIdentifier( requestMetadata.getRequestIdentifier() );
      slsRequestMetadata.setRequstRecordCount( requestMetadata.getRequestRecordCount() );
      slsRequestMetadata.setRequstSourceSystem( requestMetadata.getRequestSourceSystem() );
      slsRequestMetadata.setRequstTimeStamp( requestMetadata.getRequestTimeStamp().toString() );

      return slsRequestMetadata;

   }

   public static List< SLSSubmissions > getListofSubmissions( SRSScenarioMtch srsScenarioMtch, RequestType requestType, List< SubmnLinkSvcSubmn > submnLists )
   {
      List< SLSSubmissions > slsSubmissionList = new ArrayList<>();

      for( int index = 0; index < requestType.getRequestMetadata().getRequestRecordCount(); index++ ) {

         SLSSubmissions slsSubmissions = new SLSSubmissions();

         slsSubmissions.setCorrelationIdentifier( requestType.getSubmissions().get( index ).getCorrelationIdentifier() );
         if( StringUtils.doesValueExist( srsScenarioMtch.getAppraisalIdentifierMtch() ) ) {
            slsSubmissions.setAppraisalIdentifier( srsScenarioMtch.getAppraisalIdentifierMtch() );
         }

         LoanUnderwritingCase loanUnderwritingCase = new LoanUnderwritingCase();
         if( StringUtils.doesValueExist( srsScenarioMtch.getAutomatedUnderwritingSystemTypeMtch() ) ) {
            loanUnderwritingCase.setAutomatedUnderwritingSystemType( srsScenarioMtch.getAutomatedUnderwritingSystemTypeMtch() );
         }
         if( StringUtils.doesValueExist( srsScenarioMtch.getLoanUnderwritingCaseIdentifierMtch() ) ) {
            loanUnderwritingCase.setLoanUnderwritingCaseIdentifier( srsScenarioMtch.getLoanUnderwritingCaseIdentifierMtch() );
         }
         slsSubmissions.setLoanUnderwritingCase( loanUnderwritingCase );

         if( StringUtils.doesValueExist( srsScenarioMtch.getMersminIdentifierMtch() ) ) {
            slsSubmissions.setMERSMINIdentifier( srsScenarioMtch.getMersminIdentifierMtch() );
         }
         if( StringUtils.doesValueExist( srsScenarioMtch.getLenderLoanIdentifierMtch() ) ) {
            slsSubmissions.setLenderLoanIdentifier( StringUtils.getMaskedString( srsScenarioMtch.getLenderLoanIdentifierMtch() ) );
         }

         PartyRole partyRole = new PartyRole();
         if( StringUtils.doesValueExist( srsScenarioMtch.getPartyIdentifierMtch() ) ) {
            partyRole.setPartyIdentifier( srsScenarioMtch.getPartyIdentifierMtch() );
         }
         if( StringUtils.doesValueExist( srsScenarioMtch.getPartyRoleTypeMtch() ) ) {
            partyRole.setPartyRoleType( srsScenarioMtch.getPartyRoleTypeMtch() );
         }
         slsSubmissions.setPartyRole( partyRole );

         if( CollectionUtils.doesCollectionContainsValue( srsScenarioMtch.getTaxpayerIdentificationMtch() ) ) {
            slsSubmissions.setSSNs( SRSRequestScrubbingValidation.getMaskedSSNs(srsScenarioMtch.getTaxpayerIdentificationMtch()) );
         }

         PropertyAddress propertyAddress = new PropertyAddress();
         if( StringUtils.doesValueExist( srsScenarioMtch.getAddressLineTextMtch() ) ) {
            propertyAddress.setAddressLineText( srsScenarioMtch.getAddressLineTextMtch() );
         }
         if( StringUtils.doesValueExist( srsScenarioMtch.getCityMtch() ) ) {
            propertyAddress.setCityName( srsScenarioMtch.getCityMtch() );
         }
         if( StringUtils.doesValueExist( srsScenarioMtch.getfIPSStateAlphaCode().toString() ) ) {
            propertyAddress.setfIPSStateAlphaCode( srsScenarioMtch.getfIPSStateAlphaCode().toString() );
         }
         if( StringUtils.doesValueExist( srsScenarioMtch.getPostalCodeMtch() ) ) {
            propertyAddress.setPostalCode( srsScenarioMtch.getPostalCodeMtch() );
         }
         slsSubmissions.setPropertyAddress( propertyAddress );

         slsSubmissions.setSurrogateKeys( getSurrogateKeys( submnLists ) );

         slsSubmissionList.add( slsSubmissions );
      }

      return slsSubmissionList;
   }

   public static List< SLSPossibleMatches > getListofSLSPossibleMatches( List< SubmnLinkSvcSubmn > submnLists, Map< String, ArrayList< String > > borrowerSlidMap )
   {

      List< SLSPossibleMatches > slsPossibleMatchesList = new ArrayList<>();

      for( SubmnLinkSvcSubmn submn : submnLists ) {

         SLSPossibleMatches slsPossibleMatches = new SLSPossibleMatches();

         slsPossibleMatches.setSurrogateKey( Long.toString( submn.getIdSubmn() ) );
         slsPossibleMatches.setSubmissionLinkIdentifier( submn.getIdPmlSubmnLink() );
         slsPossibleMatches.setSlsRequestSourceSystem( submn.getNameSrceSyst() );
       
         if( StringUtils.doesValueExist( submn.getIdApprslDocFileMtch() ) ){
         slsPossibleMatches.setAppraisalIdentifier( submn.getIdApprslDocFileMtch() );
         }

         LoanUnderwritingCase loanUnderwritingCase = new LoanUnderwritingCase();
         if( StringUtils.doesValueExist( submn.getNameAusTypeMtch() ) ){
         loanUnderwritingCase.setAutomatedUnderwritingSystemType( submn.getNameAusTypeMtch() );
         }
         if( StringUtils.doesValueExist( submn.getIdLoanUwCaseMtch() ) ){
         loanUnderwritingCase.setLoanUnderwritingCaseIdentifier( submn.getIdLoanUwCaseMtch() );
         }
         slsPossibleMatches.setLoanUnderwritingCase( loanUnderwritingCase );

         if( StringUtils.doesValueExist( submn.getIdMersMinMtch() ) ){
         slsPossibleMatches.setMERSMINIdentifier( submn.getIdMersMinMtch() );
         }

         PartyRole partyRole = new PartyRole();
         if( StringUtils.doesValueExist( submn.getIdPrtyMtch() ) ){
         partyRole.setPartyIdentifier( submn.getIdPrtyMtch() );
         }
         if( StringUtils.doesValueExist( submn.getNamePrtyRoleTypeMtch() ) ){
         partyRole.setPartyRoleType( submn.getNamePrtyRoleTypeMtch() );
         }
         slsPossibleMatches.setPartyRole( partyRole );

         if( StringUtils.doesValueExist( submn.getIdLendrLoanMtch() ) ){
         slsPossibleMatches.setLenderLoanIdentifier( StringUtils.getMaskedString( submn.getIdLendrLoanMtch() ) );
         }

         PropertyAddress propertyAddress = new PropertyAddress();
         if( StringUtils.doesValueExist( submn.getCdStdzdPptyPstlMtch() ) ){
         propertyAddress.setPostalCode( submn.getCdStdzdPptyPstlMtch() );
         }
         if( StringUtils.doesValueExist( submn.getTextStdzdPptyAddrLiMtch() ) ){
         propertyAddress.setAddressLineText( submn.getTextStdzdPptyAddrLiMtch() );
         }
         if( StringUtils.doesValueExist( submn.getNameStdzdPptyCityMtch() ) ){
         propertyAddress.setCityName( submn.getNameStdzdPptyCityMtch() );
         }
         if( StringUtils.doesValueExist( submn.getAddressRqst().getFipsStateAlphaCodeString().toString() ) ){
         propertyAddress.setfIPSStateAlphaCode( submn.getAddressRqst().getFipsStateAlphaCodeString() );
         }
         slsPossibleMatches.setPropertyAddress( propertyAddress );
         
         List<String> ssns = SRSRequestScrubbingValidation.getMaskedSSNs(borrowerSlidMap.get( submn.getIdPmlSubmnLink() ));
         slsPossibleMatches.setSSNs( ssns );      

         slsPossibleMatches.setCreateDateTime( new SimpleDateFormat( "MM-dd-yyyy HH:mm:ss:SSS" ).format( submn.getDttmCreate() ) );
         slsPossibleMatches.setLastUpdateDateTime( new SimpleDateFormat( "MM-dd-yyyy HH:mm:ss:SSS" ).format( submn.getDttmLstUpdt() ) );
         slsPossibleMatches.setSubmissionRequestDateTime( new SimpleDateFormat( "MM-dd-yyyy HH:mm:ss:SSS" ).format( submn.getDttmSubmnRqst() ) );

         slsPossibleMatchesList.add( slsPossibleMatches );
      }

      return slsPossibleMatchesList;
   }

   public static ArrayList< Long > getSurrogateKeys( List< SubmnLinkSvcSubmn > submnLists )
   {
      ArrayList< Long > surrogateList = new ArrayList<>();
      for( SubmnLinkSvcSubmn submn : submnLists ) {
         surrogateList.add( submn.getIdSubmn() );
      }
      return surrogateList;
   }

}
