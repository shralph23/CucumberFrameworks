package com.freddiemac.datamanager.ws.featuredefinition;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.freddiemac.datamanager.ws.dao.SRSDao;
import com.freddiemac.datamanager.ws.dao.SelectSubmnQueryStringGenerator;
import com.freddiemac.datamanager.ws.dao.dto.SubmnLinkSvcSubmn;
import com.freddiemac.datamanager.ws.request.setup.SLMSRequestSetup;
import com.freddiemac.datamanager.ws.request.setup.SRSRequestSetup;
import com.freddiemac.datamanager.ws.request.setup.SRSScenario;
import com.freddiemac.datamanager.ws.request.setup.SRSScenarioMtch;
import com.freddiemac.datamanager.ws.servicecall.WebserviceCalls;
import com.freddiemac.datamanager.ws.slms.model.SLMSMatchResponse;
import com.freddiemac.datamanager.ws.slms.model.SLMSRequest;
import com.freddiemac.datamanager.ws.srs.enums.FIPSStateAlphaCode;
import com.freddiemac.datamanager.ws.srs.model.RequestType;
import com.freddiemac.datamanager.ws.srs.model.ResponseType;
import com.freddiemac.datamanager.ws.util.StringUtils;
import com.freddiemac.datamanager.ws.validation.SRSRequestScrubbingValidation;
import com.freddiemac.datamanager.ws.validation.SRSServiceValidation;
import com.freddiemac.datamanager.ws.cache.SRSCacheManager;
import com.freddiemac.datamanager.ws.constants.SRSConstants;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import datageneration.generic.DataGeneratorUtils;
import datageneration.sls.SlsScenario;


@ContextConfiguration( classes =
{ TestApplicationContext.class } )
@TestExecutionListeners( listeners =
{ DependencyInjectionTestExecutionListener.class } )
public class SRSDefiniton
{
   @Autowired
   @Qualifier( "SRSDao" )
   SRSDao srsDao;

   int scenarioID;
   SRSScenario srsCurrentScenario;
   SRSScenarioMtch srsCurrentScenarioMtch;
   SRSRequestScrubbingValidation srsRequestValidation;
   SRSCacheManager srsCacheManager = new SRSCacheManager();
   SelectSubmnQueryStringGenerator submnQueryStringGenerator;
   ResponseType srsResponse;
   RequestType requestType;
   SLMSMatchResponse slmsMatchResponse;

   SRSServiceValidation srsServiceValidation;

   List< SubmnLinkSvcSubmn > submnLists = new ArrayList<>();
   Map< String, ArrayList< String > > borrowerSlidMap = new HashMap< >();

   private static final Logger LOGGER = LoggerFactory.getLogger( SRSDefiniton.class );

   @Given( "^a request for srs webservice for scenario ([^\"]*) and testID ([^\"]*)$" )
   public void aRequestForSRSWebservice( int scenarioId, int id )
   {
      this.scenarioID = scenarioId;
      srsCurrentScenarioMtch = new SRSScenarioMtch();

      if( SLSDefiniton.slsRequestMap.containsKey( scenarioId ) ) {
         SlsScenario slsScenario = SLSDefiniton.slsRequestMap.get( scenarioId );
         srsCurrentScenario = new SRSScenario( scenarioId, slsScenario.getRandomKey() );
         LOGGER.info( "SLSRequestMap contains the scenarioId for the SLS Scenario.New SRSScenario object is created with slsScenario Random Key." );
      }
      else {
         String randomKey = DataGeneratorUtils.generateUniqueShortId();
         srsCurrentScenario = new SRSScenario( scenarioId, randomKey );
         LOGGER.info( "SLSRequestMap does not contain the scenarioId for the SLS Scenario. New SRSScenario object is created with new Random Key. " );
      }
   }

   @And( "^AppraisalIdentifier as \"([^\"]*)\" for SRS$" )
   public void appraisalIdentifierAs( String appraisalIdentifier )
   {
      srsCurrentScenario.setAppraisalIdentifier( appraisalIdentifier );
      String appraisalIdentifierMtch = SRSRequestScrubbingValidation.validateIdApprslDocFile( srsCurrentScenario.getAppraisalIdentifier() );
      srsCurrentScenarioMtch.setAppraisalIdentifierMtch( appraisalIdentifierMtch );
      LOGGER.info( "AppraisalIdentifier in the Request -> {} AppraisalIdentifierMtch in the Request -> {}", 
                   appraisalIdentifier,  appraisalIdentifierMtch );
   }

   @And( "^AutomatedUnderwritingSystemType as \"([^\"]*)\" for SRS$" )
   public void automatedUnderwritingSystemTypeAs( String automatedUnderwritingSystemType )
   {
      srsCurrentScenario.setAutomatedUnderwritingSystemType( automatedUnderwritingSystemType );
      String automatedUnderwritingSystemTypeMtch = SRSRequestScrubbingValidation.validateAusType( srsCurrentScenario.getAutomatedUnderwritingSystemType() );
      srsCurrentScenarioMtch.setAutomatedUnderwritingSystemTypeMtch( automatedUnderwritingSystemTypeMtch );
      LOGGER.info( "AutomatedUnderwritingSystemType in the Request -> {} AutomatedUnderwritingSystemTypeMtch in the Request -> {}", 
                   automatedUnderwritingSystemType, automatedUnderwritingSystemTypeMtch );
   }

   @And( "^DocumentIdentifier as \"([^\"]*)\" for SRS$" )
   public void documentIdentifierAs( String documentIdentifier )
   {
      srsCurrentScenario.setDocumentIdentifier( documentIdentifier );
      LOGGER.info( "DocumentIdentifier in the Request -> {}", documentIdentifier );
   }

   @And( "^FreddieMacLoanIdentifier as \"([^\"]*)\" for SRS$" )
   public void freddieMacLoanIdentifierAs( String freddieMacLoanIdentifier )
   {
      srsCurrentScenario.setFreddieMacLoanIdentifier( freddieMacLoanIdentifier );
      LOGGER.info( "FreddieMacLoanIdentifier in the Request -> {}", freddieMacLoanIdentifier );
   }

   @And( "^LenderLoanIdentifier as \"([^\"]*)\" for SRS$" )
   public void lenderLoanIdentifierAs( String lenderLoanIdentifier )
   {
      srsCurrentScenario.setLenderLoanIdentifier( lenderLoanIdentifier );
      String lenderLoanIdentifierMtch = SRSRequestScrubbingValidation.validateIdLendrLoan( srsCurrentScenario.getLenderLoanIdentifier() );
      srsCurrentScenarioMtch.setLenderLoanIdentifierMtch( lenderLoanIdentifierMtch );
      LOGGER.info( "LenderLoanIdentifier in the Request -> {} LenderLoanIdentifierMtch in the Request -> {}", 
                   lenderLoanIdentifier, lenderLoanIdentifierMtch );
   }

   @And( "^LoanUnderwritingCaseIdentifier as \"([^\"]*)\" for SRS$" )
   public void loanUnderwritingCaseIdentifierAs( String loanUnderwritingCaseIdentifier )
   {
      srsCurrentScenario.setLoanUnderwritingCaseIdentifier( loanUnderwritingCaseIdentifier );
      if( StringUtils.doesValueExist( srsCurrentScenarioMtch.getAutomatedUnderwritingSystemTypeMtch() ) ) {
         String loanUnderwritingCaseIdentifierMtch;
         if( StringUtils.containsIgnoreCase( srsCurrentScenarioMtch.getAutomatedUnderwritingSystemTypeMtch(), SRSConstants.LP_FIELD_UPPER ) ||
             StringUtils.containsIgnoreCase( srsCurrentScenarioMtch.getAutomatedUnderwritingSystemTypeMtch(), SRSConstants.LPA_FIELD_UPPER ) ) {
            loanUnderwritingCaseIdentifierMtch = SRSRequestScrubbingValidation.validateAusIDForLP( srsCurrentScenario.getLoanUnderwritingCaseIdentifier() );
            srsCurrentScenarioMtch.setLoanUnderwritingCaseIdentifierMtch( loanUnderwritingCaseIdentifierMtch );
            /*LOGGER.info( "LoanUnderwritingCaseIdentifier in the Request -> {} LoanUnderwritingCaseIdentifierMtch  in the Request -> ",
                         loanUnderwritingCaseIdentifier, loanUnderwritingCaseIdentifierMtch );*/
         }
         else {
            loanUnderwritingCaseIdentifierMtch = SRSRequestScrubbingValidation.validateAusIDForDU( srsCurrentScenario.getLoanUnderwritingCaseIdentifier() );
            srsCurrentScenarioMtch.setLoanUnderwritingCaseIdentifierMtch( loanUnderwritingCaseIdentifierMtch );
            /*LOGGER.info(
                  "LoanUnderwritingCaseIdentifier in the Request - > " + loanUnderwritingCaseIdentifier + " LoanUnderwritingCaseIdentifierMtch  in the Request -> "
                        + loanUnderwritingCaseIdentifierMtch );*/
         }
         LOGGER.info( "LoanUnderwritingCaseIdentifier in the Request -> {} LoanUnderwritingCaseIdentifierMtch in the Request -> {}",
                      loanUnderwritingCaseIdentifier, loanUnderwritingCaseIdentifierMtch );
      }
   }

   @And( "^MersminIdentifier as \"([^\"]*)\" for SRS$" )
   public void mersminIdentifierAs( String mersminIdentifier )
   {
      srsCurrentScenario.setMersminIdentifier( mersminIdentifier );
      String mersminIdentifierMtch = SRSRequestScrubbingValidation.validateIdMersmin( srsCurrentScenario.getMersminIdentifier() );
      srsCurrentScenarioMtch.setMersminIdentifierMtch( mersminIdentifierMtch );
      LOGGER.info( "MersminIdentifier in the Request -> {} MersminIdentifierMtch in the Request -> {}", 
                   mersminIdentifier, mersminIdentifierMtch );
   }

   @And( "^PartyIdentifier as \"([^\"]*)\" for SRS$" )
   public void partyIdentifierAs( String partyIdentifier )
   {
      if( partyIdentifier.contains( SRSConstants.STUBBED_PARTY_ID ) ) {
         srsCurrentScenario.setStubbedPartyIdentifier( partyIdentifier );
         LOGGER.info( "PartyIdentifier in the Request - > " + partyIdentifier );
      }
      else {
         srsCurrentScenario.setPartyIdentifier( partyIdentifier );
         String partyIdentifierMtch = SRSRequestScrubbingValidation.validateIdPrty( srsCurrentScenario.getPartyIdentifier() );
         srsCurrentScenarioMtch.setPartyIdentifierMtch( partyIdentifierMtch );
         LOGGER.info( "PartyIdentifier in the Request -> {} PartyIdentifierMtch in the Request -> {}", partyIdentifier, partyIdentifierMtch );
      }
   }

   @And( "^PartyRoleType as \"([^\"]*)\" for SRS$" )
   public void partyRoleTypeAs( String partyRoleType )
   {
      srsCurrentScenario.setPartyRoleType( partyRoleType );
      String partyRoleTypeMtch = SRSRequestScrubbingValidation.validateNamePrtyRoleType( srsCurrentScenario.getPartyRoleType() );
      srsCurrentScenarioMtch.setPartyRoleTypeMtch( partyRoleTypeMtch );
      LOGGER.info( "PartyRoleType in the Request -> {} PartyRoleTypeMtch in the Request -> {}", partyRoleType, partyRoleTypeMtch );
   }

   @And( "^AddressLineText as \"([^\"]*)\" for SRS$" )
   public void addressLineTextAs( String addressLineText )
   {
      srsCurrentScenario.setAddressLineText( addressLineText );
      String addressLineTextMtch = SRSRequestScrubbingValidation.validateAddressLineText( srsCurrentScenario.getAddressLineText() );
      srsCurrentScenarioMtch.setAddressLineTextMtch( addressLineTextMtch );
      LOGGER.info( "AddressLineText in the Request -> {} AddressLineTextMtch in the Request -> {}", addressLineText, addressLineTextMtch );
   }

   @And( "^CityName as \"([^\"]*)\" for SRS$" )
   public void cityNameAs( String cityName )
   {
      srsCurrentScenario.setCityName( cityName );
      String cityNameMtch = SRSRequestScrubbingValidation.validateNameStdzdPptyCity( srsCurrentScenario.getCityName() );
      srsCurrentScenarioMtch.setCityMtch( cityNameMtch );
      LOGGER.info( "CityName in the Request -> {} CityNameMtch in the Request -> {}", cityName, cityNameMtch );
   }

   @And( "^FipsStateAlphaCode as \"([^\"]*)\" for SRS$" )
   public void fipsStateAlphaCodeAs( String fipsStateAlphaCode )
   {
      srsCurrentScenario.setFipsStateAlphaCode( fipsStateAlphaCode );
      FIPSStateAlphaCode fipsStateAlphaCodeMtch = FIPSStateAlphaCode.fromValue( srsCurrentScenario.getFipsStateAlphaCode() );
      srsCurrentScenarioMtch.setfIPSStateAlphaCode( fipsStateAlphaCodeMtch );
      LOGGER.info( "FipsStateAlphaCode in the Request -> {} FipsStateAlphaCodeMtch in the Request -> {}", fipsStateAlphaCode, fipsStateAlphaCodeMtch.name() );
   }

   @And( "^PostalCode as \"([^\"]*)\" for SRS$" )
   public void postalCodeAs( String postalCode )
   {
      srsCurrentScenario.setPostalCode( postalCode );
      String postalCodeMtch = SRSRequestScrubbingValidation.validatePostalCode( srsCurrentScenario.getPostalCode() );
      srsCurrentScenarioMtch.setPostalCodeMtch( postalCodeMtch );
      LOGGER.info( "PostalCode in the Request -> {} PostalCodeMtch in the Request -> {}", postalCode, postalCodeMtch );
   }

   @And( "^StreetName as \"([^\"]*)\" for SRS$" )
   public void streetNameAs( String streetName )
   {
      srsCurrentScenario.setStreetName( streetName );
      LOGGER.info( "StreetName in the Request -> {}", streetName );
   }

   @And( "^StreetPrimaryNumberText as \"([^\"]*)\" for SRS$" )
   public void streetPrimaryNumberTextAs( String streetPrimaryNumberText )
   {
      srsCurrentScenario.setStreetPrimaryNumberText( streetPrimaryNumberText );
      LOGGER.info( "StreetPrimaryNumberText in the Request -> {}", streetPrimaryNumberText );
   }

   @And( "^ZipPlusFourCode as \"([^\"]*)\" for SRS$" )
   public void zipPlusFourCodeAs( String zipPlusFourCode )
   {
      srsCurrentScenario.setZipPlusFourCode( zipPlusFourCode );
      LOGGER.info( "ZIPPlusFourCode in the Request -> {}", zipPlusFourCode );
   }

   @And( "^SourceSystemTransactionIdentifer as \"([^\"]*)\" for SRS$" )
   public void sourceSystemTransactionIdentiferAs( String sourceSystemTransactionIdentifer )
   {
      srsCurrentScenario.setSourceSystemTransactionIdentifer( sourceSystemTransactionIdentifer );
      LOGGER.info( "SourceSystemTransactionIdentifer in the Request -> {}", sourceSystemTransactionIdentifer );
   }

   @And( "^TaxpayerIdentificationNumbers as \"([^\"]*)\" for SRS$" )
   public void taxpayerIdentificationNumbersAs( String taxpayerIdentificationNumbers )
   {
      /*      List< String > taxpayerIdentificationList;
      if( taxpayerIdentificationNumbers.contains( "," ) ) {
               taxpayerIdentificationList = Arrays.asList( taxpayerIdentificationNumbers.split( "," ) );
      }
            else {
                        taxpayerIdentificationList = Arrays.asList( taxpayerIdentificationNumbers );
      }*/
      List< String > taxpayerIdentificationList = Arrays.asList( taxpayerIdentificationNumbers.split( "," ) );

      taxpayerIdentificationList = SRSRequestSetup.formatTaxpayerIdentifierList( taxpayerIdentificationList );

      srsCurrentScenario.setTaxpayerIdentificationNumbers( taxpayerIdentificationList );

      List< String > taxpayerIdentificationListMtch = new ArrayList<>();
      taxpayerIdentificationListMtch = taxpayerIdentificationList.stream()
                                                                    .filter( StringUtils::isNotNull )
                                                                    .map( SRSRequestScrubbingValidation::validateTaxPayerId )
                                                                    .collect( Collectors.toList() );
      /*      for( String taxpayerIdentification : taxpayerIdentificationList ) {
         taxpayerIdentificationListMtch.add( SRSRequestScrubbingValidation.validateTaxPayerId( taxpayerIdentification ) );
      }*/

      srsCurrentScenarioMtch.setTaxpayerIdentificationMtch( taxpayerIdentificationListMtch );
      LOGGER.info( "TaxpayerIdentificationNumbers in the Request -> {} TaxpayerIdentificationNumbersMtch in the Request -> {}",
                   taxpayerIdentificationList, taxpayerIdentificationListMtch );
   }

   @And( "^CorrelationIdentifier as \"([^\"]*)\" for SRS$" )
   public void correlationIdentifierAs( String correlationIdentifier )
   {
      srsCurrentScenario.setCorrelationIdentifier( correlationIdentifier );
      LOGGER.info( "CorrelationIdentifier in the Request -> {}", correlationIdentifier );
   }

   @And( "^RecordCount as ([^\"]*) for SRS$" )
   public void RecordCountAs( int recordCount )
   {
      srsCurrentScenario.setRecordCount( recordCount );
      LOGGER.info( "RecordCount in the Request -> {}", recordCount );
   }

   @And( "^RequestSourceSystem as \"([^\"]*)\" for SRS$" )
   public void requestSourceSystemAs( String requestSourceSystem )
   {
      srsCurrentScenario.setRequestSourceSystem( requestSourceSystem );
      LOGGER.info( "RequestSourceSystem in the Request -> {}", requestSourceSystem );
   }

   @And( "^SubmittingSourceSystem as \"([^\"]*)\" for SRS$" )
   public void submittingSourceSystemAs( String submittingSourceSystem )
   {
      srsCurrentScenario.setSubmittingSourceSystem( submittingSourceSystem );
      LOGGER.info( "SubmittingSourceSystem in the Request -> {}", submittingSourceSystem );
   }

   @And( "^Error Code as \"([^\"]*)\" for SRS$" )
   public void errorCodeAs( String errorCode )
   {
      srsCurrentScenario.setErrorCode( errorCode );
      LOGGER.info( "ErrorCode in the Request -> {}", errorCode );
   }

   @Then( "^the request is sent and the response is received from SRS webservice$" )
   public void theRequestIsSentToTheSRSWebservice() throws JsonProcessingException, URISyntaxException, DatatypeConfigurationException
   {
      LOGGER.info( "SRS Request has been setup and SRS webservice is called" );

      requestType = SRSRequestSetup.srsRequestSetup( srsCurrentScenario );
      srsResponse = WebserviceCalls.sendRequesttoSRS( requestType );
      WebserviceCalls.receiveResponseFromSRS( srsResponse );

      //Updating the record count in SRSServiceValidation class to perform various validations
      srsServiceValidation = new SRSServiceValidation( requestType.getRequestMetadata().getRequestRecordCount() );
   }

   @Then( "^the request is sent and the error is received from SRS webservice$" )
   public void theRequestIsSentToTheSRSWebserviceAndErrorReceived() throws JsonProcessingException, URISyntaxException, DatatypeConfigurationException
   {
      LOGGER.info( "SRS Request has been setup and SRS webservice is called" );

      try {
         requestType = SRSRequestSetup.srsRequestSetup( srsCurrentScenario );
         srsResponse = WebserviceCalls.sendRequesttoSRS( requestType );
         WebserviceCalls.receiveResponseFromSRS( srsResponse );

         // Updating the record count in SRSServiceValidation class to perform various validations
         srsServiceValidation = new SRSServiceValidation( srsResponse.getResponseMetadata().getRequestRecordCount() );

         if( !srsCurrentScenario.getErrorCode().isEmpty() ) {

            srsServiceValidation.validateNoErrorCodeInSRSResponse( srsCurrentScenario.getErrorCode() );
         }
      }
      catch( HttpClientErrorException e ) {
         srsServiceValidation = new SRSServiceValidation();
         srsServiceValidation.validateErrorCodeInSRSResponse( e.getStatusCode().toString(), srsCurrentScenario.getErrorCode() );
      }
   }

   @Then( "^setup request data for SLMS call$" )
   public void setupRequestDataForSLMS() throws JsonProcessingException
   {

      LOGGER.info( "Querying Database and receive possible matches" );

      srsCurrentScenarioMtch
            .setAddressLineTextConcatenate(
                  SRSRequestScrubbingValidation.deriveAddressLineTextPostalCode( srsCurrentScenarioMtch.getAddressLineTextMtch(), srsCurrentScenarioMtch.getPostalCodeMtch() ) );

      Map< String, Set< String > > queryKeys = srsCacheManager.loadSubmnQueryKeys( srsCurrentScenarioMtch );

      String queryString = SRSCacheManager.genSubmissionQuery( queryKeys, 1000, Boolean.TRUE );

      submnLists = srsDao.getPossibleSvcSubmissionsByCollectionKeys( queryKeys, queryString );

      if( submnLists.size() > 0 ) {
         List< String > slids = submnLists.stream()
                                             .map( SubmnLinkSvcSubmn::getIdPmlSubmnLink )
                                             .collect( Collectors.toList() );

         borrowerSlidMap = srsDao.getPossibleBorrowersBySLID( slids );

         //         if( borrowerSlidMap != null && slids != null ) {
         //            for( String slid : slids ) {
         //               LOGGER.info( "Borrower Data for SLID " + slid + " -> " + borrowerSlidMap.get( slid ).toString() );
         //            }
         //         }
      }
   }

   @Then( "^the request is sent and response is received from SLMS webservice$" )
   public void theRequestIsSentToTheSLMSWebservice() throws JsonProcessingException, URISyntaxException, DatatypeConfigurationException
   {
      LOGGER.info( "SLMS Request has been setup and SLMS webservice is called" );
      SLMSRequest slmsRequest = SLMSRequestSetup.getSLMSRequest( srsCurrentScenarioMtch, requestType, submnLists, borrowerSlidMap );
      slmsMatchResponse = WebserviceCalls.sendRequesttoSLMS( slmsRequest );
      WebserviceCalls.receiveResponseFromSLMS( slmsMatchResponse );
   }

   @Then( "^validate SRS service decision with SLMS$" )
   public void validateSRSDecisionWithSLMS() throws JsonProcessingException
   {
      srsServiceValidation.validateSRSServiceDecisionWithSLMS( srsResponse, slmsMatchResponse );
   }

   @Then( "^validate SRS service decision with SLS$" )
   public void validateSRSDecisionWithSLS() throws JsonProcessingException
   {
      srsServiceValidation.validateSRSServiceDecisionWithSLS( srsResponse.getSubmissions().get( 0 ).getRetrievalServiceResult(), SLSDefiniton.scenarioSLSActionMap.get( scenarioID ) );
   }

   @Then( "^validate SRS is fetching the correct SLID from DB$" )
   public void validateSRSAttributeValues() throws JsonProcessingException
   {
      if( srsResponse.getSubmissions().get( 0 ).getRetrievalServiceResult().equals( SRSConstants.SRS_FOUND ) ) {
         srsServiceValidation.validateSLMSSurrogatekeyAndSRSSLID( srsResponse, slmsMatchResponse, srsDao );
      }
   }

   @Then( "^validate the SRS decision as \"([^\"]*)\"$" )
   public void validateSRSDecision( String srsDecision )
   {
      srsServiceValidation.validateSRSServiceDecision( srsResponse, srsDecision );
   }

   @Then( "^validate the SRS Error Response for attribute \"([^\"]*)\"$" )
   public void validateErrorResponseInSRS( String attributeName ) throws JsonProcessingException
   {
      srsServiceValidation.validateAttributeLengthErrorResponse( attributeName, requestType, srsResponse );
   }

   @Then( "^validate the stubbed slid from SRS response$" )
   public void validateStubbedResponseInSRS() throws JsonProcessingException
   {
      srsServiceValidation.validateStubbedSLIDINSRSResponse( srsResponse );
   }
}
