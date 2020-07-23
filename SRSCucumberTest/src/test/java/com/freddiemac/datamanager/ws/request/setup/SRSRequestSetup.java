package com.freddiemac.datamanager.ws.request.setup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;

import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.srs.model.*;
import com.freddiemac.datamanager.ws.util.CollectionUtils;
import com.freddiemac.datamanager.ws.util.StringUtils;

import datageneration.generic.DataGeneratorUtils;


public class SRSRequestSetup
{

   public static RequestType srsRequestSetup( SRSScenario srsScenario ) throws DatatypeConfigurationException
   {

      RequestMetadataType requestMetadata = new RequestMetadataType();
      requestMetadata.setRequestIdentifier( DataGeneratorUtils.generateUniqueId() );
      requestMetadata.setRequestRecordCount( srsScenario.getRecordCount() );
      requestMetadata.setRequestSourceSystem( srsScenario.getRequestSourceSystem() );

      if( StringUtils.doesValueExist( srsScenario.getSubmittingSourceSystem() ) ) {
         requestMetadata.setSubmittingSourceSystem( srsScenario.getSubmittingSourceSystem() );
      }
      requestMetadata.setRequestTimeStamp( DataGeneratorUtils.getXMLGregorianCalendarNow().toString() );

      AttributesType attributesType = new AttributesType();
      if( StringUtils.doesValueExist( srsScenario.getAppraisalIdentifier() ) ) {
         attributesType.setAppraisalIdentifier( srsScenario.getAppraisalIdentifier() );
      }
      if( StringUtils.doesValueExist( srsScenario.getAutomatedUnderwritingSystemType() ) ) {
         attributesType.setAutomatedUnderwritingSystemType( srsScenario.getAutomatedUnderwritingSystemType() );
      }
      if( StringUtils.doesValueExist( srsScenario.getDocumentIdentifier() ) ) {
         attributesType.setDocumentIdentifier( srsScenario.getDocumentIdentifier() );
      }
      if( StringUtils.doesValueExist( srsScenario.getFreddieMacLoanIdentifier() ) ) {
         attributesType.setFreddieMacLoanIdentifier( srsScenario.getFreddieMacLoanIdentifier() );
      }
      if( StringUtils.doesValueExist( srsScenario.getLenderLoanIdentifier() ) ) {
         attributesType.setLenderLoanIdentifier( srsScenario.getLenderLoanIdentifier() );
      }
      if( StringUtils.doesValueExist( srsScenario.getLoanUnderwritingCaseIdentifier() ) ) {
         attributesType.setLoanUnderwritingCaseIdentifier( srsScenario.getLoanUnderwritingCaseIdentifier() );
      }
      if( StringUtils.doesValueExist( srsScenario.getMersminIdentifier() ) ) {
         attributesType.setMersminIdentifier( srsScenario.getMersminIdentifier() );
      }
      if( StringUtils.doesValueExist( srsScenario.getPartyIdentifier() ) ) {
         attributesType.setPartyIdentifier( srsScenario.getPartyIdentifier() );
      }
      if( StringUtils.doesValueExist( srsScenario.getPartyRoleType() ) ) {
         attributesType.setPartyRoleType( srsScenario.getPartyRoleType() );
      }
      if( StringUtils.doesValueExist( srsScenario.getSourceSystemTransactionIdentifer() ) ) {
         attributesType.setSourceSystemTransactionIdentifer( srsScenario.getSourceSystemTransactionIdentifer() );
      }

      AddressType propertyAddress = new AddressType();
      if( StringUtils.doesValueExist( srsScenario.getAddressLineText() ) ) {
         propertyAddress.setAddressLineText( srsScenario.getAddressLineText() );
      }
      if( StringUtils.doesValueExist( srsScenario.getCityName() ) ) {
         propertyAddress.setCityName( srsScenario.getCityName() );
      }
      if( StringUtils.doesValueExist( srsScenario.getFipsStateAlphaCode() ) ) {
         propertyAddress.setFIPSStateAlphaCode( srsScenario.getFipsStateAlphaCode() );
      }
      if( StringUtils.doesValueExist( srsScenario.getPostalCode() ) ) {
         propertyAddress.setPostalCode( srsScenario.getPostalCode() );
      }
      if( StringUtils.doesValueExist( srsScenario.getStreetName() ) ) {
         propertyAddress.setStreetName( srsScenario.getStreetName() );
      }
      if( StringUtils.doesValueExist( srsScenario.getStreetPrimaryNumberText() ) ) {
         propertyAddress.setStreetPrimaryNumberText( srsScenario.getStreetPrimaryNumberText() );
      }
      if( StringUtils.doesValueExist( srsScenario.getZipPlusFourCode() ) ) {
         propertyAddress.setZIPPlusFourCode( srsScenario.getZipPlusFourCode() );
      }

      attributesType.setPropertyAddress( propertyAddress );   
      attributesType.setTaxpayerIdentificationNumbers( srsScenario.getTaxpayerIdentificationNumbers() );

      SubmissionRequestType submissionRequestType = new SubmissionRequestType();
      submissionRequestType.setCorrelationIdentifier( srsScenario.getCorrelationIdentifier() );
      submissionRequestType.setAttributes( attributesType );

      List< SubmissionRequestType > submissionRequests = new ArrayList<>();
      submissionRequests.add( submissionRequestType );

      RequestType requestType = new RequestType();
      requestType.setRequestMetadata( requestMetadata );
      requestType.setSubmissions( submissionRequests );

      return requestType;

   }

   public static RequestType srsRequestSetupForBatch( SRSScenariosForBatch srsScenariosForBatch ) throws DatatypeConfigurationException
   {

      RequestMetadataType requestMetadata = new RequestMetadataType();
      requestMetadata.setRequestIdentifier( DataGeneratorUtils.generateUniqueId() );
      requestMetadata.setRequestRecordCount( srsScenariosForBatch.getRecordCount() );
      requestMetadata.setRequestSourceSystem( srsScenariosForBatch.getRequestSourceSystem() );

      if( StringUtils.doesValueExist( srsScenariosForBatch.getSubmittingSourceSystem() ) ) {
         requestMetadata.setSubmittingSourceSystem( srsScenariosForBatch.getSubmittingSourceSystem() );
      }
      requestMetadata.setRequestTimeStamp( DataGeneratorUtils.getXMLGregorianCalendarNow().toString() );

      List< SubmissionRequestType > submissionRequests = new ArrayList<>();

      for( int i = 0; i < srsScenariosForBatch.getScenarioIDs().size(); i++ ) {
         AttributesType attributesType = new AttributesType();
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getAppraisalIdentifier() ) ) {
            attributesType.setAppraisalIdentifier( srsScenariosForBatch.getAppraisalIdentifier().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getAutomatedUnderwritingSystemType() ) ) {
            attributesType.setAutomatedUnderwritingSystemType( srsScenariosForBatch.getAutomatedUnderwritingSystemType().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getDocumentIdentifier() ) ) {
            attributesType.setDocumentIdentifier( srsScenariosForBatch.getDocumentIdentifier().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getFreddieMacLoanIdentifier() ) ) {
            attributesType.setFreddieMacLoanIdentifier( srsScenariosForBatch.getFreddieMacLoanIdentifier().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getLenderLoanIdentifier() ) ) {
            attributesType.setLenderLoanIdentifier( srsScenariosForBatch.getLenderLoanIdentifier().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getLoanUnderwritingCaseIdentifier() ) ) {
            attributesType.setLoanUnderwritingCaseIdentifier( srsScenariosForBatch.getLoanUnderwritingCaseIdentifier().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getMersminIdentifier() ) ) {
            attributesType.setMersminIdentifier( srsScenariosForBatch.getMersminIdentifier().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getPartyIdentifier() ) ) {
            attributesType.setPartyIdentifier( srsScenariosForBatch.getPartyIdentifier().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getPartyRoleType() ) ) {
            attributesType.setPartyRoleType( srsScenariosForBatch.getPartyRoleType().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getSourceSystemTransactionIdentifer() ) ) {
            attributesType.setSourceSystemTransactionIdentifer( srsScenariosForBatch.getSourceSystemTransactionIdentifer().get( i ) );
         }

         AddressType propertyAddress = new AddressType();
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getAddressLineText() ) ) {
            propertyAddress.setAddressLineText( srsScenariosForBatch.getAddressLineText().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getCityName() ) ) {
            propertyAddress.setCityName( srsScenariosForBatch.getCityName().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getFipsStateAlphaCode() ) ) {
            propertyAddress.setFIPSStateAlphaCode( srsScenariosForBatch.getFipsStateAlphaCode().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getPostalCode() ) ) {
            propertyAddress.setPostalCode( srsScenariosForBatch.getPostalCode().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getStreetName() ) ) {
            propertyAddress.setStreetName( srsScenariosForBatch.getStreetName().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getStreetPrimaryNumberText() ) ) {
            propertyAddress.setStreetPrimaryNumberText( srsScenariosForBatch.getStreetPrimaryNumberText().get( i ) );
         }
         if( CollectionUtils.doesCollectionContainsValue( srsScenariosForBatch.getZipPlusFourCode() ) ) {
            propertyAddress.setZIPPlusFourCode( srsScenariosForBatch.getZipPlusFourCode().get( i ) );
         }

         attributesType.setPropertyAddress( propertyAddress );
         List<String> ssnList = new ArrayList<>();         
         ssnList.add( srsScenariosForBatch.getTaxpayerIdentificationNumbers().get( i ) );
         
         attributesType.setTaxpayerIdentificationNumbers(ssnList);

         SubmissionRequestType submissionRequestType = new SubmissionRequestType();
         submissionRequestType.setCorrelationIdentifier( DataGeneratorUtils.generateUniqueId() );
         submissionRequestType.setAttributes( attributesType );

         submissionRequests.add( submissionRequestType );
      }

      RequestType requestType = new RequestType();
      requestType.setRequestMetadata( requestMetadata );
      requestType.setSubmissions( submissionRequests );

      return requestType;
   }

   public static List< String > formatTaxpayerIdentifierList( List< String > taxpayerIdentifierList )
   {

//      List< String > formattedTaxpayerIdentifierList = new ArrayList<>();

      return taxpayerIdentifierList.stream()
                                      .map( ssn -> StringUtils.containsIgnoreCase( ssn, "-" ) ? SRSConstants.EMPTY_STRING : ssn )
                                      .collect( Collectors.toList() );
            
      /*for( String taxpayerIdentifier : taxpayerIdentifierList ) {
         if( StringUtils.containsIgnoreCase( taxpayerIdentifier, "-" ) ) {
            formattedTaxpayerIdentifierList.add( "" );
         }else{
            formattedTaxpayerIdentifierList.add( taxpayerIdentifier );
         }
      }
      return formattedTaxpayerIdentifierList;*/
   }

}
