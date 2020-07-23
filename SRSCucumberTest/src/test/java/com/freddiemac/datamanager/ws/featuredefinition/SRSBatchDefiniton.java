package com.freddiemac.datamanager.ws.featuredefinition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.HttpClientErrorException;

import com.freddiemac.datamanager.ws.request.setup.SRSRequestSetup;
import com.freddiemac.datamanager.ws.request.setup.SRSScenariosForBatch;
import com.freddiemac.datamanager.ws.servicecall.WebserviceCalls;
import com.freddiemac.datamanager.ws.srs.model.RequestType;
import com.freddiemac.datamanager.ws.srs.model.ResponseType;
import com.freddiemac.datamanager.ws.validation.SRSServiceValidation;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import datageneration.generic.DataGeneratorUtils;

public class SRSBatchDefiniton
{
   ResponseType srsResponse;
   RequestType requestType;
   SRSScenariosForBatch currentScenariosForBatch;
   SRSServiceValidation srsServiceValidation;
   
   protected static Map< Integer, String > srsRandomKeysForBatch = new HashMap<>();
   
   @Given( "^a request for srs webservice for scenario \"([^\"]*)\" and testID ([^\"]*)$" )
   public void aRequestForSRSWebservice( String scenarioIds, int id )
   {
      List< String > scenarioIdList = Arrays.asList( scenarioIds.split( "," ) );
      
      srsRandomKeysForBatch = SLSDefiniton.scenariosRandomKeysForBatch;

      /*      for( String scenarioId : scenarioIdList ) {
         if( !srsRandomKeysForBatch.containsKey( Integer.parseInt( scenarioId ) ) ) {
            srsRandomKeysForBatch.put( Integer.parseInt( scenarioId ), DataGeneratorUtils.generateUniqueShortId() );
         }        
      }*/
      scenarioIdList.stream()
                       .filter( scenarioId -> !srsRandomKeysForBatch.containsKey( Integer.valueOf( scenarioId ) ) )
                       .forEach( scenarioId -> srsRandomKeysForBatch.put( Integer.valueOf( scenarioId ), DataGeneratorUtils.generateUniqueShortId() ) );
      
      currentScenariosForBatch = new SRSScenariosForBatch(scenarioIdList, srsRandomKeysForBatch);
   }
   
   @And( "^RecordCount for batch as ([^\"]*) for SRS$" )
   public void RecordCountAs( int recordCount )
   {
      currentScenariosForBatch.setRecordCount( recordCount );
   }
   
   @And( "^Request source system for batch as \"([^\"]*)\" for SRS$" )
   public void slsSourceSystemAs( String sourceSystem )
   {
      currentScenariosForBatch.setRequestSourceSystem( sourceSystem );
   }
   
   @And( "^Submitting source system for batch as \"([^\"]*)\" for SRS$" )
   public void submittingSourceSystemAs( String submittingSourceSystem )
   {
      currentScenariosForBatch.setSubmittingSourceSystem( submittingSourceSystem );
   }

   @And( "^appraisal identifier for batch as \"([^\"]*)\" for SRS$" )
   public void appraisalIdentifierAs( String docFileId )
   {
      currentScenariosForBatch.setAppraisalIdentifier( docFileId );
   }

   @And( "^automated underwriting system type for batch as \"([^\"]*)\" for SRS$" )
   public void automatedUnderwritingsystemTypeAs( String ausType )
   {
      currentScenariosForBatch.setAutomatedUnderwritingSystemType( ausType );
   }

   @And( "^loan underwriting case identifier for batch as \"([^\"]*)\" for SRS$" )
   public void loanUnderwritingCaseIdentifierAs( String ausId )
   {
      currentScenariosForBatch.setLoanUnderwritingCaseIdentifier( ausId );
   }

   @And( "^MERSMIN identifier for batch as \"([^\"]*)\" for SRS$" )
   public void mersminIdentifierAs( String mersminid )
   {
      currentScenariosForBatch.setMersminIdentifier( mersminid );
   }

   @And( "^party identifier for batch as \"([^\"]*)\" for SRS$" )
   public void partyIdentifierAs( String partyId )
   {    
      currentScenariosForBatch.setPartyIdentifier( partyId );
   }

   @And( "^Party Role Type for batch as \"([^\"]*)\" for SRS$" )
   public void partyRoleTypeAs( String partyRoleType )
   {
      currentScenariosForBatch.setPartyRoleType( partyRoleType );
   }

   @And( "^lender loan identifier for batch as \"([^\"]*)\" for SRS$" )
   public void lenderLoanIdentifierAs( String lenderlnid )
   {
      currentScenariosForBatch.setLenderLoanIdentifier( lenderlnid );
   }

   @And( "^tax payer identification numbers for batch as \"([^\"]*)\" for SRS$" )
   public void taxPayerIdentificationNumberAs( String ssnList )
   {
      List< String > taxpayerIdentificationList = Arrays.asList( ssnList.split( "," ) );
      taxpayerIdentificationList = SRSRequestSetup.formatTaxpayerIdentifierList( taxpayerIdentificationList );
      currentScenariosForBatch.setTaxpayerIdentificationNumbers( taxpayerIdentificationList );
   }

   @And( "^address line text for batch as \"([^\"]*)\" for SRS$" )
   public void addresssLineTextAs( String addressLineText )
   {
      currentScenariosForBatch.setAddressLineText( addressLineText );
   }

   @And( "^street name for batch as \"([^\"]*)\" for SRS$" )
   public void streetNameAs( String streetName )
   {
      currentScenariosForBatch.setStreetName( streetName );
   }

   @And( "^city name for batch as \"([^\"]*)\" for SRS$" )
   public void cityNameAs( String cityName )
   {
      currentScenariosForBatch.setCityName( cityName );
   }

   @And( "^fipsStateAlphaCode for batch as \"([^\"]*)\" for SRS$" )
   public void fipsStateAlphaCodeAs( String stateCode )
   {
      currentScenariosForBatch.setFipsStateAlphaCode( stateCode );
   }

   @And( "^postal code for batch as \"([^\"]*)\" for SRS$" )
   public void postalCodeAs( String postalCode )
   {
      currentScenariosForBatch.setPostalCode( postalCode );
   }
   
   @Then( "^the batch request is sent and response is received from SRS$" )
   public void thebatchRequestIsSent() throws Throwable
   {
      try {
      requestType = SRSRequestSetup.srsRequestSetupForBatch( currentScenariosForBatch );
      srsResponse = WebserviceCalls.sendRequesttoSRS( requestType );
      WebserviceCalls.receiveResponseFromSRS( srsResponse );
      
      srsServiceValidation = new SRSServiceValidation(srsResponse.getResponseMetadata().getRequestRecordCount());
      }
      catch( HttpClientErrorException e ) {
         GlobalHooks.getScenario().write( "Exception caught" );
      }
   }
   
   @Then( "^validate the SRS decision as \"([^\"]*)\" from batch requests$" )
   public void validateSRSDecision( String srsDecision )
   {
      List< String > srsDecisionList = Arrays.asList( srsDecision.split( "," ) );
      srsServiceValidation.validateSRSServiceDecisionForBatch( srsResponse, srsDecisionList );
   }
}
