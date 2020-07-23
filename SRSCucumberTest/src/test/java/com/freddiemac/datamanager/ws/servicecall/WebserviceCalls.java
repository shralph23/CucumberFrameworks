package com.freddiemac.datamanager.ws.servicecall;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.featuredefinition.GlobalHooks;
import com.freddiemac.datamanager.ws.slms.model.SLMSMatchResponse;
import com.freddiemac.datamanager.ws.slms.model.SLMSRequest;
import com.freddiemac.datamanager.ws.srs.model.RequestType;
import com.freddiemac.datamanager.ws.srs.model.ResponseType;
import com.freddiemac.sls.SLSRequestType;
import com.freddiemac.sls.SLSResponseType;

import generic.GeneralTestConstants;
import reports.MessageFormatter;
import webservice.RequestData;
import webservice.WebServiceFunctions;


public class WebserviceCalls
{
   
   private static final Logger LOGGER = LoggerFactory.getLogger( WebserviceCalls.class );


   /**
    * Send request to SRS webservice
    */
   public static ResponseType sendRequesttoSRS( RequestType requestType ) throws JsonProcessingException, URISyntaxException
   {
      WebServiceFunctions serviceMethods = new WebServiceFunctions();
      ObjectMapper mapper = new ObjectMapper();
      String jsonContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( requestType );
      GlobalHooks.getScenario().write( jsonContent );
      
      LOGGER.info("SRS Request \n" + jsonContent );

      return (ResponseType) serviceMethods.sendPostRequest( setUpRequestData( requestType ) );
   }

   private static RequestData setUpRequestData( RequestType requestType )
   {

      String url = GlobalHooks.getProperties().getProperty( SRSConstants.SRS_WEBSERVICE_URL );
      String username = GlobalHooks.getProperties().getProperty( SRSConstants.SRS_WEBSERVICE_USER );
      String password = GlobalHooks.getProperties().getProperty( SRSConstants.SRS_WEBSERVICE_PWD );

      return new RequestData( url, username, password, requestType, requestType.getClass(),
            ResponseType.class );
   }

   public static void receiveResponseFromSRS( ResponseType response ) throws JsonProcessingException
   {
      ObjectMapper mapper = new ObjectMapper();
      String jsonContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( response );
      GlobalHooks.getScenario().write( jsonContent );
     
      LOGGER.info("SRS Response \n" + jsonContent );
   }
   
   /**
    * Send request to SLMS webservice
    */
   public static SLMSMatchResponse sendRequesttoSLMS( SLMSRequest slmsRequest ) throws JsonProcessingException, URISyntaxException
   {
      WebServiceFunctions serviceMethods = new WebServiceFunctions();
      ObjectMapper mapper = new ObjectMapper();
      String jsonContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( slmsRequest );
      GlobalHooks.getScenario().write( jsonContent );
      
      LOGGER.info("SLMS Request \n" + jsonContent );

      return (SLMSMatchResponse) serviceMethods.sendPostRequestSLMS( setUpSLMSRequestData( slmsRequest ) );
   }

   private static RequestData setUpSLMSRequestData( SLMSRequest slmsRequest )
   {

      String url = GlobalHooks.getProperties().getProperty( SRSConstants.SLMS_WEBSERVICE_URL );
      String username = GlobalHooks.getProperties().getProperty( SRSConstants.SLMS_WEBSERVICE_USER );
      String password = GlobalHooks.getProperties().getProperty( SRSConstants.SLMS_WEBSERVICE_PWD );

      return new RequestData( url, username, password, slmsRequest, slmsRequest.getClass(),
            SLMSMatchResponse.class );
   }

   public static void receiveResponseFromSLMS( SLMSMatchResponse slmsMatchResponse ) throws JsonProcessingException
   {
      ObjectMapper mapper = new ObjectMapper();
      String jsonContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( slmsMatchResponse );
      GlobalHooks.getScenario().write( jsonContent );
      
      LOGGER.info("SLMS Request \n" + jsonContent );
   }

   /**
    * Send request to SLS webservice
    */
   public static SLSResponseType sendRequestToSLSService( SLSRequestType slsRequest ) throws SOAPException, JAXBException,
         ParserConfigurationException, DatatypeConfigurationException, IOException, ClassNotFoundException,
         InstantiationException, IllegalAccessException, ClassCastException, SAXException, URISyntaxException
   {

      WebServiceFunctions serviceMethods = new WebServiceFunctions();
      String url = GlobalHooks.getProperties().getProperty( GeneralTestConstants.SLS_WEBSERVICE_URL );
      SOAPMessage soapMessage = serviceMethods.createSOAPRequest( setUpRequestData( slsRequest ) );
      GlobalHooks.getScenario().write( MessageFormatter.formatSoapMessage( soapMessage ) );
      LOGGER.info("SLS Request \n" + MessageFormatter.formatSoapMessage( soapMessage ) );
      soapMessage = serviceMethods.sendSOAPRequest( soapMessage, url );
      GlobalHooks.getScenario().write( MessageFormatter.formatSoapMessage( soapMessage ) );
      LOGGER.info("SLS Response \n" + MessageFormatter.formatSoapMessage( soapMessage ) );
      SLSResponseType response = serviceMethods.getSLSResponseType(soapMessage);
      return response;
   }

   private static RequestData setUpRequestData( SLSRequestType slsRequest )
   {
      String url = GlobalHooks.getProperties().getProperty( GeneralTestConstants.SLS_WEBSERVICE_URL );
      String username = GlobalHooks.getProperties().getProperty( GeneralTestConstants.SLS_WEBSERVICE_USER );
      String password = GlobalHooks.getProperties().getProperty( GeneralTestConstants.SLS_WEBSERVICE_PWD );
      return new RequestData( url, username, password, slsRequest, slsRequest.getClass(), SLSResponseType.class );
   }
}
