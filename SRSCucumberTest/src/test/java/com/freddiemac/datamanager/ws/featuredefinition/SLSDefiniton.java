package com.freddiemac.datamanager.ws.featuredefinition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.request.setup.SLSRequestSetup;
import com.freddiemac.datamanager.ws.request.setup.SRSRequestSetup;
import com.freddiemac.datamanager.ws.servicecall.WebserviceCalls;
import com.freddiemac.datamanager.ws.validation.SRSServiceValidation;
import com.freddiemac.sls.SLSRequestType;
import com.freddiemac.sls.SLSResponseType;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import datageneration.generic.DataGeneratorUtils;
import datageneration.sls.EScenarioType;
import datageneration.sls.SlsScenario;
import generic.GeneralUtils;

import com.freddiemac.datamanager.ws.request.setup.SLSScenariosForBatch;;


public class SLSDefiniton
{
   int scenarioID;
   SlsScenario currentScenario;
   static SLSResponseType response;
   static SLSScenariosForBatch slsScenariosForBatch;
   SRSServiceValidation srsServiceValidation = new SRSServiceValidation();

   protected static Map< Integer, SlsScenario > slsRequestMap = new HashMap<>();
   protected static Map< Integer, String > scenariosRandomKeysForBatch = new HashMap<>();

   protected static Map< Integer, String > scenariosRandomKeys = new HashMap<>();
   protected static Map< Integer, String > scenarioSLSActionMap = new HashMap<>();
   
   @Given( "^a request for sls webservice for scenarioID ([^\"]*) and testID ([^\"]*)$" )
   public void aRequestForSlsWebserviceForScenario( int scenarioID, int testID )
   {
      String randomKey;
      
      this.scenarioID = scenarioID;
      if( !scenariosRandomKeys.containsKey( scenarioID ) ) {
         randomKey = DataGeneratorUtils.generateUniqueShortId();
//      currentScenario = new SlsScenario( testID, scenarioID, randomKey, false );
      scenariosRandomKeys.put( scenarioID, randomKey );
      }else{
         randomKey = scenariosRandomKeys.get( scenarioID );
//         currentScenario = new SlsScenario( testID, scenarioID, randomKey, false );
      }
      currentScenario = new SlsScenario( testID, scenarioID, randomKey, false );
   }

   @And( "^set correlation identifier for SLS$" )
   public void correlationIdentifierAs()
   {
      currentScenario.setCorrelationId( DataGeneratorUtils.generateUniqueId() );    
   }

   @And( "^sls source system as \"([^\"]*)\" for SLS$" )
   public void slsSourceSystemAs( String sourceSystem )
   {
      currentScenario.setSourceSystem( sourceSystem );
   }

   @And( "^appraisal identifier as \"([^\"]*)\" for SLS$" )
   public void appraisalIdentifierAs( String docFileId )
   {
      currentScenario.setDocFileId( docFileId );
   }

   @And( "^automated underwriting system type as \"([^\"]*)\" for SLS$" )
   public void automatedUnderwritingsystemTypeAs( String ausType )
   {
      currentScenario.setAusType( ausType );
   }

   @And( "^loan underwriting case identifier as \"([^\"]*)\" for SLS$" )
   public void loanUnderwritingCaseIdentifierAs( String ausId )
   {
      currentScenario.setAusId( ausId );
   }

   @And( "^MERSMIN identifier as \"([^\"]*)\" for SLS$" )
   public void mersminIdentifierAs( String mersminid )
   {
      currentScenario.setMersminid( mersminid );
   }

   @And( "^party identifier as \"([^\"]*)\" for SLS$" )
   public void partyIdentifierAs( String partyId )
   {
      if( partyId.contains( SRSConstants.STUBBED_PARTY_ID ) ) {
         currentScenario.setStubbedPartyid( partyId );
      }
      currentScenario.setPartyid( partyId );
   }

   @And( "^Party Role Type as \"([^\"]*)\" for SLS$" )
   public void partyRoleTypeAs( String partyRoleType )
   {
      currentScenario.setPartyRoleType( partyRoleType );
   }

   @And( "^lender loan identifier as \"([^\"]*)\" for SLS$" )
   public void lenderLoanIdentifierAs( String lenderlnid )
   {
      currentScenario.setLenderlnid( lenderlnid );
   }

   @And( "^tax payer identification numbers as \"([^\"]*)\" for SLS$" )
   public void taxPayerIdentificationNumberAs( String ssnList )
   {
      List< String > taxpayerIdentificationList = Arrays.asList( ssnList.split( "," ) );
      taxpayerIdentificationList = SRSRequestSetup.formatTaxpayerIdentifierList( taxpayerIdentificationList );
      currentScenario.setSsnList( taxpayerIdentificationList );
   }

   @And( "^address line text as \"([^\"]*)\" for SLS$" )
   public void addresssLineTextAs( String addressLineText )
   {
      currentScenario.setAddressLineText( addressLineText );
   }

   @And( "^street name as \"([^\"]*)\" for SLS$" )
   public void streetNameAs( String streetName )
   {
      currentScenario.setStreetName( streetName );
   }

   @And( "^city name as \"([^\"]*)\" for SLS$" )
   public void cityNameAs( String cityName )
   {
      currentScenario.setCityName( cityName );
   }

   @And( "^state code as \"([^\"]*)\" for SLS$" )
   public void stateCodeAs( String stateCode )
   {
      currentScenario.setStateCode( stateCode );
   }

   @And( "^postal code as \"([^\"]*)\" for SLS$" )
   public void postalCodeAs( String postalCode )
   {
      currentScenario.setPostalCode( postalCode );
   }

   @And( "^Submitting source system as \"([^\"]*)\" for SLS$" )
   public void submittingSourceSystemAs( String submittingSourceSystem )
   {
      currentScenario.setSubmittingSourceSystem( submittingSourceSystem );
   }

   @And( "^source system as \"([^\"]*)\" for SLS$" )
   public void sourceSystemAs( String sourceSystem )
   {
      currentScenario.setSourceSystem( sourceSystem );
   }

   @Then( "^the request is sent and response is received from SLS$" )
   public void theRequestIsSent() throws Throwable
   {
      SLSRequestType slsRequest = SLSRequestSetup.slsRequestSetup( currentScenario );
      slsRequestMap.put( currentScenario.getScenarioSetId(), currentScenario );
      response = WebserviceCalls.sendRequestToSLSService( slsRequest );
      
      scenarioSLSActionMap.put( scenarioID, response.getSLSOutputResponses().getSLSOuputResponse().get( 0 ).getSubmissionLinkServiceAction().toString() );

      srsServiceValidation = new SRSServiceValidation( response.getRequestMetadata().getRequestRecordCount() );
   }

   @Then( "^validate the SLS decision as \"([^\"]*)\"$" )
   public void validateSLSDecision( String slsDecision )
   {
      srsServiceValidation.validateSLSAction( response, slsDecision );
   }

   /*
    * Code to send Batch SLS Request
    */

   private void setUpRequestforBatchSlsWebservice( boolean orphan, String scenarioIds, String id )
   {
      List< String > scenarioIdList = Arrays.asList( scenarioIds.split( "," ) );

      /*      for( String scenarioId : scenarioIdList ) {
         if( !scenariosRandomKeysForBatch.containsKey( Integer.parseInt( scenarioId ) ) ) {
            scenariosRandomKeysForBatch.put( Integer.parseInt( scenarioId ), DataGeneratorUtils.generateUniqueShortId() );
         }
      }*/
      scenarioIdList.stream()
                       .filter( scenarioId -> !scenariosRandomKeysForBatch.containsKey( Integer.valueOf( scenarioId ) ) )
                       .forEach( scenarioId -> scenariosRandomKeysForBatch.put( Integer.valueOf( scenarioId ), DataGeneratorUtils.generateUniqueShortId() ) );
      
      slsScenariosForBatch = new SLSScenariosForBatch( Integer.parseInt( id ), scenarioIdList, scenariosRandomKeysForBatch,
            EScenarioType.fromValue( "VARIABLE" ), orphan );
      slsScenariosForBatch.setRequestId( DataGeneratorUtils.generateUniqueId() );
      GeneralUtils.sleep( 100 );
   }

   @Given( "^a request for batch sls webservice for scenario \"([^\"]*)\" ([^\"]*)$" )
   public void aRequestForBatchSlsWebservice( String scenario, String id )
   {
      setUpRequestforBatchSlsWebservice( false, scenario, id );
   }

   @And( "^source system for batch as \"([^\"]*)\"$" )
   public void srceSystemForBatchAs( String srcSystems )
   {
      slsScenariosForBatch.setSourceSystems( srcSystems );
   }

   @And( "^Submitting source system for batch as \"([^\"]*)\"$" )
   public void submittingSourceSystemForBatchAs( String submittingSourceSystem )
   {
      slsScenariosForBatch.setSubmittingSourceSystem( submittingSourceSystem );
   }

   @And( "^SLSInputRequests exists for batch as (false|true)$" )
   public void slsInputRequestsExistsForbatchAs( boolean slsInputRequestsExists )
   {
      slsScenariosForBatch.setSlsInputRequestsExists( slsInputRequestsExists );
   }

   @And( "^empty SLSInputRequests for batch as (false|true)$" )
   public void emptySLSInputRequestsForbatchAs( boolean emptySLSInputRequests )
   {
      slsScenariosForBatch.setEmptySLSInputRequests( emptySLSInputRequests );
   }

   @And( "^SLSInputRequests count for batch as (\\d+)$" )
   public void slsInputRequestsCountForbatchAs( int slsInputRequestsCount )
   {
      slsScenariosForBatch.setSlsInputRequestsCount( slsInputRequestsCount );
   }

   @And( "^appraisal identifier for batch as \"([^\"]*)\"$" )
   public void appraisalIdentifierForbatchAs( String docFileIds )
   {
      slsScenariosForBatch.setDocFileIds( docFileIds );
   }

   @And( "^automated underwriting system type for batch as \"([^\"]*)\"$" )
   public void automatedUnderwritingsystemTypeForBatchAs( String ausType )
   {
      slsScenariosForBatch.setAusTypes( ausType );
   }

   @And( "^loan underwriting case identifier for batch as \"([^\"]*)\"$" )
   public void loanUnderwritingCaseIdentifierForBatchAs( String ausId )
   {
      slsScenariosForBatch.setAusIds( ausId );
   }

   @And( "^MERSMIN identifier for batch as \"([^\"]*)\"$" )
   public void mersminIdentifierForBatchAs( String mersminid )
   {
      slsScenariosForBatch.setMersminids( mersminid );
   }

   @And( "^party identifier for batch as \"([^\"]*)\"$" )
   public void partyIdentifierForBatchAs( String partyId )
   {
      slsScenariosForBatch.setPartyids( partyId );
   }

   @And( "^Party Role Type for batch as \"([^\"]*)\"$" )
   public void partyRoleTypForBatcheAs( String partyRoleType )
   {
      slsScenariosForBatch.setPartyRoleTypes( partyRoleType );
   }

   @And( "^lender loan identifier for batch as \"([^\"]*)\"$" )
   public void lenderLoanIdentifierForBatchAs( String lenderlnid )
   {
      slsScenariosForBatch.setLenderlnids( lenderlnid );
   }

   @And( "^address line text for batch as \"([^\"]*)\"$" )
   public void addresssLineTextForBatchAs( String addressLineText )
   {
      slsScenariosForBatch.setAddressLineTexts( addressLineText );
   }

   @And( "^street name for batch as \"([^\"]*)\"$" )
   public void streetNameForBatchAs( String streetName )
   {
      slsScenariosForBatch.setStreetNames( streetName );
   }

   @And( "^city name for batch as \"([^\"]*)\"$" )
   public void cityNameForBatchAs( String cityName )
   {
      slsScenariosForBatch.setCityNames( cityName );
   }

   @And( "^state code for batch as \"([^\"]*)\"$" )
   public void stateCodeForBatchAs( String stateCode )
   {
      slsScenariosForBatch.setStateCodes( stateCode );
   }

   @And( "^postal code for batch as \"([^\"]*)\"$" )
   public void postalCodeForBatchAs( String postalCode )
   {
      slsScenariosForBatch.setPostalCodes( postalCode );
   }

   @And( "^tax payer identification numbers for batch as \"([^\"]*)\"$" )
   public void taxPayerIdentificationNumberForBatchAs( String ssnList )
   {
      slsScenariosForBatch.setSsnList( ssnList );
   }

   @Then( "^the batch request is sent and response is received from SLS$" )
   public void thebatchRequestIsSent() throws Throwable
   {
      SLSRequestType slsRequest = SLSRequestSetup.slsRequestSetupForBatch( slsScenariosForBatch );
      response = WebserviceCalls.sendRequestToSLSService( slsRequest );
   }

   @Then( "^validate the SLS decision as \"([^\"]*)\" from batch requests$" )
   public void validateSRSDecision( String slsDecision )
   {
      List< String > slsDecisionList = Arrays.asList( slsDecision.split( "," ) );
      srsServiceValidation.validateSLSServiceDecisionForBatch( response, slsDecisionList );
   }
}
