package com.freddiemac.datamanager.ws.request.setup;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import com.freddiemac.cdm.FIPSStateAlphaCode;
import com.freddiemac.sls.RequestMetadataType;
import com.freddiemac.sls.SLSAddressType;
import com.freddiemac.sls.SLSAttributesType;
import com.freddiemac.sls.SLSInputRequestType;
import com.freddiemac.sls.SLSInputRequestsType;
import com.freddiemac.sls.SLSRequestType;
import com.freddiemac.sls.TaxpayerIdentificationNumbersType;

import datageneration.generic.DataGeneratorUtils;
import datageneration.sls.SlsScenario;


public class SLSRequestSetup
{
   public static SLSRequestType slsRequestSetup( SlsScenario slsScenario ) throws DatatypeConfigurationException
   {

      SLSRequestType slsRequestType = new SLSRequestType();

      SLSInputRequestsType slsInputRequests = new SLSInputRequestsType();

      RequestMetadataType requestMetadata = new RequestMetadataType();
      requestMetadata.setRequestIdentifier( DataGeneratorUtils.generateUniqueId() );
      //Need to change it to Dynamic value
      requestMetadata.setRequestRecordCount( 1 );
      requestMetadata.setRequestSourceSystem( slsScenario.getSourceSystem() );
      requestMetadata.setSubmittingSourceSystem( slsScenario.getSubmittingSourceSystem() );
      requestMetadata.setRequestTimestamp( DataGeneratorUtils.getXMLGregorianCalendarNow() );
      slsRequestType.setRequestMetadata( requestMetadata );

      for( int index = 0; index < requestMetadata.getRequestRecordCount(); index++ ) {

         SLSAttributesType slsAttributes = new SLSAttributesType();

         slsAttributes.setMERSMINIdentifier( slsScenario.getMersminid() );
         slsAttributes.setAppraisalIdentifier( slsScenario.getDocFileId() );
         slsAttributes.setLoanUnderwritingCaseIdentifier( slsScenario.getAusId() );
         slsAttributes.setAutomatedUnderwritingSystemType( slsScenario.getAusType() );
         slsAttributes.setPartyIdentifier( slsScenario.getPartyid() );
         slsAttributes.setPartyRoleType( slsScenario.getPartyRoleType() );
         slsAttributes.setLenderLoanIdentifier( slsScenario.getLenderlnid() );

         SLSAddressType slsAddressType = new SLSAddressType();
         slsAddressType.setAddressLineText( slsScenario.getAddressLineText() );
         if( slsScenario.getStateCode() != null ) {
            slsAddressType.setFIPSStateAlphaCode( FIPSStateAlphaCode.fromValue( slsScenario.getStateCode() ) );
         }
         slsAddressType.setPostalCode( slsScenario.getPostalCode() );
         slsAddressType.setStreetName( slsScenario.getStreetName() );
         slsAddressType.setCityName( slsScenario.getCityName() );
         slsAttributes.setPropertyAddress( slsAddressType );

         TaxpayerIdentificationNumbersType ssns = new TaxpayerIdentificationNumbersType();

         ssns.getTaxpayerIdentificationNumber().addAll( slsScenario.getSsnList() );
         slsAttributes.setTaxpayerIdentificationNumbers( ssns );

         SLSInputRequestType slsInputRequestType = new SLSInputRequestType();
         slsInputRequestType.setCorrelationIdentifier( slsScenario.getCorrelationId() );
         slsInputRequestType.setSLSAttributes( slsAttributes );

         slsInputRequests.getSLSInputRequest().add( slsInputRequestType );

      }

      slsRequestType.setSLSInputRequests( slsInputRequests );

      return slsRequestType;

   }

   public static SLSRequestType slsRequestSetupForBatch( SLSScenariosForBatch slsScenariosForBatch ) throws DatatypeConfigurationException
   {

      SLSInputRequestsType slsInputRequests = new SLSInputRequestsType();

      List< SLSInputRequestType > slsInputRequestTypeList = new ArrayList<>();

      SLSRequestType slsRequest = new SLSRequestType();

      RequestMetadataType requestMetadata = new RequestMetadataType();
      requestMetadata.setRequestIdentifier( slsScenariosForBatch.getRequestId() );
      requestMetadata.setRequestRecordCount( slsScenariosForBatch.getRecordCount() );
      requestMetadata.setRequestSourceSystem( slsScenariosForBatch.getSourceSystems() );
      requestMetadata.setSubmittingSourceSystem( slsScenariosForBatch.getSubmittingSourceSystem() );
      requestMetadata.setRequestTimestamp( DataGeneratorUtils.getXMLGregorianCalendarNow() );
      slsRequest.setRequestMetadata( requestMetadata );

      for( int i = 0; i < requestMetadata.getRequestRecordCount(); i++ ) {
         SLSInputRequestType slsInputRequest = new SLSInputRequestType();
         SLSAttributesType slsAttributes = new SLSAttributesType();

         slsAttributes.setMERSMINIdentifier( slsScenariosForBatch.getMersminids().get( i ) );
         slsAttributes.setAppraisalIdentifier( slsScenariosForBatch.getDocFileIds().get( i ) );
         slsAttributes.setLoanUnderwritingCaseIdentifier( slsScenariosForBatch.getAusIds().get( i ) );
         slsAttributes.setAutomatedUnderwritingSystemType( slsScenariosForBatch.getAusTypes().get( i ) );
         slsAttributes.setPartyIdentifier( slsScenariosForBatch.getPartyids().get( i ) );
         slsAttributes.setPartyRoleType( slsScenariosForBatch.getPartyRoleTypes().get( i ) );
         slsAttributes.setLenderLoanIdentifier( slsScenariosForBatch.getLenderlnids().get( i ) );

         SLSAddressType anAddress = new SLSAddressType();
         anAddress.setAddressLineText( slsScenariosForBatch.getAddressLineTexts().get( i ) );
         if( slsScenariosForBatch.getStateCodes().get( i ) != null ) {
            FIPSStateAlphaCode stateCode = FIPSStateAlphaCode.fromValue( slsScenariosForBatch.getStateCodes().get( i ) );
            anAddress.setFIPSStateAlphaCode( stateCode );
         }
         anAddress.setPostalCode( slsScenariosForBatch.getPostalCodes().get( i ) );
         anAddress.setStreetName( slsScenariosForBatch.getStreetNames().get( i ) );
         anAddress.setCityName( slsScenariosForBatch.getCityNames().get( i ) );
         slsAttributes.setPropertyAddress( anAddress );

         TaxpayerIdentificationNumbersType ssns = new TaxpayerIdentificationNumbersType();
         ssns.getTaxpayerIdentificationNumber().add( slsScenariosForBatch.getSsnList().get( i ) );
         slsAttributes.setTaxpayerIdentificationNumbers( ssns );

         String correlationIdentifier = DataGeneratorUtils.generateUniqueId();

         slsInputRequest.setCorrelationIdentifier( correlationIdentifier );
         slsInputRequest.setSLSAttributes( slsAttributes );

         slsInputRequestTypeList.add( slsInputRequest );
      }
      slsInputRequests.getSLSInputRequest().addAll( slsInputRequestTypeList );

      slsRequest.setSLSInputRequests( slsInputRequests );
     
      return slsRequest;
   }

}
