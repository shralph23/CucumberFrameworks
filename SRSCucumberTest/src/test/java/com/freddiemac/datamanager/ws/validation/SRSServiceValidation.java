package com.freddiemac.datamanager.ws.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.featuredefinition.GlobalHooks;
import com.freddiemac.datamanager.ws.slms.model.SLMSMatchResponse;
import com.freddiemac.datamanager.ws.srs.model.RequestType;
import com.freddiemac.datamanager.ws.srs.model.ResponseType;
import com.freddiemac.sls.SLSResponseType;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.freddiemac.datamanager.ws.dao.SRSDao;


public class SRSServiceValidation
{

   public int recordCount = 0;

   public SRSServiceValidation()
   {

   }

   public SRSServiceValidation( int recordCount )
   {
      this.recordCount = recordCount;
   }

   public void validateSRSServiceDecisionWithSLMS( ResponseType srsResponse, SLMSMatchResponse slmsMatchResponse )
   {
      String errorMessage = "The action between SRS and SLMS doesn't match ";

      for( int index = 0; index < recordCount; index++ ) {
         String srsResponseAction = srsResponse.getSubmissions().get( index ).getRetrievalServiceResult();
         String slmsMatchResponseAction = slmsMatchResponse.getSLMSMatchResults().get( index ).getSLMSDecision();

         GlobalHooks.getScenario().write( "SRSResponseAction in response " + srsResponseAction + " and " + " SLMSMatchResponseAction in response " + slmsMatchResponseAction );

         slmsMatchResponseAction = makeActionFromSLMSDecision( slmsMatchResponseAction );

         Assert.assertEquals( errorMessage, slmsMatchResponseAction, srsResponseAction );
      }
   }

   public void validateSRSServiceDecisionWithSLS( String srsResponseAction, String slsResponseAction )
   {
      String errorMessage = "The action between SRS and SLS doesn't match ";

      /*            if( slsResponseAction.equals( "NEW" ) ) {
         Assert.assertEquals( errorMessage, SRSConstants.SRS_NOT_FOUND, srsResponseAction );
      }
      else {
         Assert.assertEquals( errorMessage, SRSConstants.SRS_FOUND, srsResponseAction );
      }*/
      Assert.assertEquals( errorMessage, slsResponseAction.equals( "NEW" ) ? SRSConstants.SRS_NOT_FOUND : SRSConstants.SRS_FOUND, 
                           srsResponseAction );
      
   }

   public void validateSRSServiceDecision( ResponseType srsResponse, String expectedResponseAction )
   {
      String errorMessage = "The action between SRS and expected action doesn't match ";

      for( int index = 0; index < recordCount; index++ ) {
         String srsResponseAction = srsResponse.getSubmissions().get( index ).getRetrievalServiceResult();

         Assert.assertEquals( errorMessage, expectedResponseAction, srsResponseAction );
      }
   }

   public void validateSRSServiceDecisionForBatch( ResponseType srsResponse, List< String > expectedResponseActionList )
   {
      String errorMessage = "The action between SRS and expected action doesn't match ";

      for( int index = 0; index < recordCount; index++ ) {
         String srsResponseAction = srsResponse.getSubmissions().get( index ).getRetrievalServiceResult();
         String expectedResponseAction = expectedResponseActionList.get( index );

         Assert.assertEquals( errorMessage, expectedResponseAction, srsResponseAction );
      }
   }

   public void validateSLSAction( SLSResponseType response, String slsDecision )
   {

      String errorMessage = "The action between SLS and expected action doesn't match ";

      for( int index = 0; index < recordCount; index++ ) {
         Assert.assertEquals( errorMessage, slsDecision, response.getSLSOutputResponses().getSLSOuputResponse().get( index ).getSubmissionLinkServiceAction().value() );

      }
   }

   public void validateSLSServiceDecisionForBatch( SLSResponseType response, List< String > expectedResponseActionList )
   {
      String errorMessage = "The action between SLS and expected action doesn't match ";

      for( int index = 0; index < recordCount; index++ ) {
         String srsResponseAction = response.getSLSOutputResponses().getSLSOuputResponse().get( index ).getSubmissionLinkServiceIdentifier().toString();
         String expectedResponseAction = expectedResponseActionList.get( index );

         Assert.assertEquals( errorMessage, expectedResponseAction, srsResponseAction );
      }
   }

   public void validateErrorCodeInSRSResponse( String errorCodeInResponse, String expectedErrorCode )
   {

      String errorMessage = "The Error Code between SRS and expected error code doesn't match ";

      GlobalHooks.getScenario().write( "SRS Error Code in response " + errorCodeInResponse + " and " + " Expected Error Code in response " + expectedErrorCode );

      Assert.assertEquals( errorMessage, expectedErrorCode, errorCodeInResponse );
   }

   public void validateNoErrorCodeInSRSResponse( String expectedErrorCode )
   {

      String errorMessage = "Test expected an Error Code but got something else ";

      GlobalHooks.getScenario().write( "SRS Expected Error Code in response " + expectedErrorCode );

      // always fail
      Assert.assertEquals( errorMessage, expectedErrorCode, -1 );
   }

   public void validateAttributeLengthErrorResponse( String errorAttribute, RequestType requestType, ResponseType srsResponse )
   {

      String errorMessageInResponse = srsResponse.getSubmissions().get( 0 ).getErrorDetails();
      String attributeValue = null;
      String errorMessageExpected = null;

      switch( errorAttribute )
      {
         case ( SRSConstants.CORRELATION_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getCorrelationIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.CORRELATION_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_THIRTYSIX );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.MERSMIN_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getMersminIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.MERSMIN_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_FIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.AUTOMATED_UNDERWRITING_SYSTEM_TYPE ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getAutomatedUnderwritingSystemType();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.AUTOMATED_UNDERWRITING_SYSTEM_TYPE, attributeValue, SRSConstants.DB_COLUMN_LENGTH_THIRTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.LOAN_UNDERWRITING_CASE_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getLoanUnderwritingCaseIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.LOAN_UNDERWRITING_CASE_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_ONEHUNDREDFIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.APPRAISAL_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getAppraisalIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.APPRAISAL_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_ONEHUNDREDFIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.PARTY_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPartyIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.PARTY_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_FIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.PARTY_ROLE_TYPE ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPartyRoleType();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.PARTY_ROLE_TYPE, attributeValue, SRSConstants.DB_COLUMN_LENGTH_THIRTYFIVE );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.LENDER_LOAN_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getLenderLoanIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.LENDER_LOAN_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_FIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.DOCUMENT_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getDocumentIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.DOCUMENT_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_FIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.SOURCE_SYSTEM_TRANSACTION_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getSourceSystemTransactionIdentifer();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.SOURCE_SYSTEM_TRANSACTION_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_FIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.FREDDIEMAC_LOAN_IDENTIFIER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getFreddieMacLoanIdentifier();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.FREDDIEMAC_LOAN_IDENTIFIER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_FIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         //Property Address Container 
         case ( SRSConstants.ADDRESS_LINE_TEXT ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPropertyAddress().getAddressLineText();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.ADDRESS_LINE_TEXT, attributeValue, SRSConstants.DB_COLUMN_LENGTH_TWOHUNDREDFIFTYSIX );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.STREET_PRIMARY_NUMBER_TEXT ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPropertyAddress().getStreetPrimaryNumberText();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.STREET_PRIMARY_NUMBER_TEXT, attributeValue, SRSConstants.DB_COLUMN_LENGTH_TWOHUNDREDFIFTYSIX );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.STREET_NAME ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPropertyAddress().getStreetName();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.STREET_NAME, attributeValue, SRSConstants.DB_COLUMN_LENGTH_HUNDRED );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.CITY_NAME ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPropertyAddress().getCityName();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.CITY_NAME, attributeValue, SRSConstants.DB_COLUMN_LENGTH_HUNDRED );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.POSTAL_CODE ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPropertyAddress().getPostalCode();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.POSTAL_CODE, attributeValue, SRSConstants.DB_COLUMN_LENGTH_EIGHTEEN );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.ZIP_PLUS_FOUR_CODE ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getPropertyAddress().getZIPPlusFourCode();
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.ZIP_PLUS_FOUR_CODE, attributeValue, SRSConstants.DB_COLUMN_LENGTH_EIGHTEEN );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;

         case ( SRSConstants.TAXPAYER_IDENTIFICATION_NUMBER ):
            attributeValue = requestType.getSubmissions().get( 0 ).getAttributes().getTaxpayerIdentificationNumbers().get( 0 );
            errorMessageExpected = getErrorMessageForTheAttribute( SRSConstants.TAXPAYER_IDENTIFICATION_NUMBER, attributeValue, SRSConstants.DB_COLUMN_LENGTH_FIFTY );
            assertThat( errorMessageInResponse, equalTo( errorMessageExpected ) );
            break;
            
         case ( SRSConstants.NO_ATTRIBUTE ):
            assertThat( errorMessageInResponse, equalTo( SRSConstants.NO_ATTRIBUTE_ERR_MSG ) );
            break;
      }
   }

   public String getErrorMessageForTheAttribute( String attributeName, String attributeValue, int dbColumnSize )
   {

      String errorMessage = null;

      if( attributeName.equals( SRSConstants.CORRELATION_IDENTIFIER ) ) {
         errorMessage = String.format( "Submission AttributeName:'%s' |AttributeVaue:'%s' must be non-null/non-empty and not greater than characters Length:'%s'",
                                       attributeName, attributeValue, dbColumnSize );
      }
      else {
         errorMessage = String.format( "Submission AttributeName:'%s' |AttributeVaue:'%s' exceeded the specified DBColumnSize:'%s'", 
                                       attributeName, attributeValue, dbColumnSize);
      }

      return errorMessage;
   }

   public String makeActionFromSLMSDecision( String slmsDecision )
   {
      String slmsAction = slmsDecision.equals( "NO_MATCH" ) ? "NOT_FOUND" : "FOUND";
      return slmsAction;
   }

   public void validateStubbedSLIDINSRSResponse( ResponseType srsResponse )
   {
      for( int index = 0; index < recordCount; index++ ) {
         assertThat( SRSConstants.STUBBED_SLID, equalTo( srsResponse.getSubmissions().get( index ).getSubmissionLinkServiceIdentifier() ) );
      }
   }

   public void validateSLMSSurrogatekeyAndSRSSLID( ResponseType srsResponse, SLMSMatchResponse slmsMatchResponse, SRSDao srsDao )
   {
      List< String > slidFromSRSList = new ArrayList<>();
      List< String > surrogatekeyFromSLMSList = new ArrayList<>();

      for( int index = 0; index < recordCount; index++ ) {
         String slidFromSRS = srsResponse.getSubmissions().get( index ).getSubmissionLinkServiceIdentifier();
         String surrogatekeyFromSLMS = slmsMatchResponse.getSLMSMatchResults().get( index ).getSurrogateKey();

         slidFromSRSList.add( slidFromSRS );
         surrogatekeyFromSLMSList.add( surrogatekeyFromSLMS );

      }
            
      Map< String, String > idSubmnSLIDMap = srsDao.getSLIDByID_SUBMN(surrogatekeyFromSLMSList);
      
      for( int index = 0; index < recordCount; index++ ) {
         
         assertThat(slidFromSRSList.get( index ),equalTo(idSubmnSLIDMap.get( surrogatekeyFromSLMSList.get( index ) )));
         GlobalHooks.getScenario().write( "SLID by SRS " + slidFromSRSList.get( index ) + "\nSLID by SLMS as per Surrogate Key " + idSubmnSLIDMap.get( surrogatekeyFromSLMSList.get( index ) ) );
      }
   }
}
