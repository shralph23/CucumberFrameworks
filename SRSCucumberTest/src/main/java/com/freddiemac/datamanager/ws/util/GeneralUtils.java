package com.freddiemac.datamanager.ws.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

public class GeneralUtils
{
   
   private static final Logger LOGGER = LoggerFactory.getLogger( GeneralUtils.class );
        
   /**
    * 
    * private constructor in order to hide the public constructor
    * 
    */
   private GeneralUtils() {         
   }
      
   /**
    * 
    * Validate whether a object is not null
    * 
    * @param object is a instance of Object class.
    * 
    * @return resultFlag is true in case of valid object otherwise false
    * 
    */
   public static boolean doesObjectExist( Object object ) {
      
      boolean resultFlag = Boolean.FALSE;
      
      if( object != null )
         resultFlag = Boolean.TRUE;
      
      return resultFlag;
      
   }
   
   /**
    * 
    * Validate whether a object is null
    * 
    * @param object is a instance of Object class.
    * 
    * @return resultFlag is true in case of null object otherwise false
    * 
    */
   public static boolean isNullObject( Object object ) {
      
      boolean resultFlag = Boolean.FALSE;
      
      if( object == null )
         resultFlag = Boolean.TRUE;
      
      return resultFlag;
      
   }

   
   /**
    * 
    * Removed the object from heap by setting the value to null 
    * 
    * @param object is a instance of Object class
    * 
    */
   public static void closeObject( Object object ) {
            
      if( GeneralUtils.doesObjectExist( object ) ) 
      {
         try {
            
            object = null;
            
         } catch(Exception e) {
            
            LOGGER.error( "Error Message :" + e.getMessage(), e );         
            
         }
      }   
      
   }
   
   /**
    * 
    * Removed the object from heap by calling the close method 
    * on the InputStream object
    * 
    * @param inputStream  is a instance of InputStream class
    * 
    */
   public static void closeInputStream( InputStream inputStream ) {
            
      if( GeneralUtils.doesObjectExist( inputStream ) ) 
      {
         try {
            
            inputStream.close();
            
         } catch(Exception e) {
            
            LOGGER.error( "Error Message :" + e.getMessage(), e );         
            
         }
      }   
      
   }
   
   /**
    * 
    * Removed the object from heap by calling the close method 
    * on the OutputStream object
    * 
    * @param outputStream  is a instance of OutputStream class
    * 
    */
   public static void closeOutputStream( OutputStream outputStream ) {
            
      if( GeneralUtils.doesObjectExist( outputStream ) ) 
      {
         try {
            
            outputStream.close();
            
         } catch(Exception e) {
            
            LOGGER.error( "Error Message :" + e.getMessage(), e );         
            
         }
      }   
      
   }
   
   /**
    * 
    * Removed the object from heap by calling the close method 
    * on the Reader object
    * 
    * @param reader  is a instance of Reader class
    * 
    */
   public static void closeReader( Reader reader ) {
            
      if( doesObjectExist( reader ) ) 
      {
         try {
            
            reader.close();
            
         } catch(Exception e) {
            
            LOGGER.error( "Error Message :" + e.getMessage(), e );         
            
         }
      }   
      
   }
   
   /**
    * 
    * Removed the object from heap by calling the close method 
    * on the Writer object
    * 
    * @param writer  is a instance of Writer class
    * 
    */
   public static void closeWriter( Writer writer ) {
            
      if( GeneralUtils.doesObjectExist( writer ) ) 
      {
         try {
            
            writer.close();
            
         } catch(Exception e) {
            
            LOGGER.error( "Error Message :" + e.getMessage(), e );         
            
         }
      }   
      
   }
   
  /**
   * 
   * Creates a new document object with the help of
   * DocumentBuilderFactory object
   *  
   * @return document is a instance of Document class
   * 
   */
   public static Document createXMLDocument() {
      
      Document  document = null;
            
      try {          
         
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         document = db.newDocument();
         
      }
      catch( ParserConfigurationException e ) {  
         LOGGER.error( "Error Message :" + e.getMessage(), e );         
      }
      
      return document;      
      
   }
   
   /**
    * 
    * calculate the query fetch limit based on the number of submissions multiply 
    * by queryFetchLimit and also set the fetch limit to queryFetchCeilingLimit
    * in case the number of submissions multiply by queryFetchLimit 
    * 
    * @param totalSubmissions is a integer 
    * @param queryFetchLimit is a integer
    * @param queryFetchCeilingLimit is a integer
    * 
    * @return fetchLimit is a integer
    * 
    */
   public static int calculateQueryFetchLimit( int totalSubmissions, int queryFetchLimit, int queryFetchCeilingLimit )
   {
      int fetchLimit = totalSubmissions * queryFetchLimit;

      if( fetchLimit > queryFetchCeilingLimit ) {
         fetchLimit = queryFetchCeilingLimit;
      }     
      
      return fetchLimit;
      
   }
   
   /**
    * 
    * calculate the retry limit result based on retryFlag and  
    * also the retryCount is less than retryMaxLimit
    * 
    * @param retryFlag is a boolean
    * @param retryCount is a integer
    * @param retryMaxLimit is a integer
    * 
    * @return resultFlag is a boolean
    * 
    */
   public static boolean calculateRetryLimit ( boolean retryFlag, int retryCount, int retryMaxLimit ) {
      
      boolean resultFlag = Boolean.FALSE;
      
      if( retryFlag && ( retryCount < retryMaxLimit ) ) {
         resultFlag = Boolean.TRUE;
      }
      
      return resultFlag;
      
   }
           
   
}
