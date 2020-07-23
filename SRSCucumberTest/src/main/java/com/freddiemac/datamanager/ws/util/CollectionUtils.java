package com.freddiemac.datamanager.ws.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionUtils
{
   
   private static final Logger LOGGER = LoggerFactory.getLogger( CollectionUtils.class );   
   
   
   public static Set< String > findDuplicates( List< String > listContainingDuplicates )
   {
      Set< String > setToReturn = new HashSet< String >();
      Set< String > set1 = new HashSet< String >();

      for( String yourInt : listContainingDuplicates ) {
         if( !set1.add( yourInt.trim() ) ) {
            setToReturn.add( yourInt.trim() );
         }
      }
      return setToReturn;
   }

   public static Set< String > findDuplicatesAndIgnoreEmptyStrings( List< String > listContainingDuplicates ) {

      Set< String > setToReturn = new HashSet<>();
      Set< String > setUnique = new HashSet< String >();                   
      
      for( String data : listContainingDuplicates ) {
         String dataTrim = data.trim();
         if( dataTrim.length() > 0 ) {
            if( !setUnique.add( dataTrim ) )
               setToReturn.add( dataTrim );
         }
      }
      
      return setToReturn;

   }

   /**
    * 
    * Limit the size of the list based on the limit
    * ( i.e. (list size - limit) to list size)
    * 
    * @param list is an instance of List< ? >    
    * @param limit is used to reduce the size of the list 
    * 
    */
   public static void getLastNItems( List< ? > list, int limit )
   {

      // limit list to maxSize items
      int theSize = list.size();

      if( theSize > limit && limit > 0 ) {
         list.subList( 0, theSize - limit ).clear();
      }
      
   }

   /**
    * 
    * Limit the size of the list based on the limit( i.e. 0 to limit)
    * also it is possible to log the message based on the 
    * logFlag boolean value
    * 
    * @param list is an instance of List< ? >    
    * @param limit is used to reduce the size of the list 
    * @param logFlag is true in case you need to log the status
    * of the sublist operation on the list otherwise false 
    * 
    */
   public static void getFirstNItems( List< ? > list, int limit, boolean logFlag, String listName ) {
            
      int theSize = list.size();
      
      if( theSize > limit && limit > 0 ) {
         List< ? > finalSubList = list.subList( limit, theSize );
         if ( logFlag ) {  
            String theMessage = "Truncated the " + listName + " list to the required size :'" + limit 
                                + "' from actual size :'" + theSize + "' - " + "Removed these items :'" 
                                + finalSubList + "' from the " + listName + " list";
            LOGGER.warn( theMessage );                             
         }
         finalSubList.clear();
      }
            
   }        

   /**
    * 
    * Validate whether a item exists in the collection
    * @param dataCollection is a instance of Collection<?> class
    * @param searchData is a instance of <T> generic type
    * 
    * @return true in case the search String data is available in the collection;
    * otherwise false 
    * 
    */
   public static <T> boolean itemExistsInCollection( Collection<?> dataCollection, T searchData ) {
      
      return dataCollection.contains( searchData );
      
   }
   
   /**
    * 
    * Validate whether a item exists in the collection
    * @param dataCollection is a instance of Collection<String> class
    * @param pattern is a instance of String
    * 
    * @return true in case the search String data is available in the collection;
    * otherwise false 
    * 
    */
   public static boolean itemMatchingPatternExistsInCollection( Collection< String > dataCollection, String value ) {
      
      for( String data : dataCollection ) {

         String dataTrim = data.trim();

         if( value.matches( dataTrim ) ) {
         
            return true;
         }
      }
      
      return false;
   }
   
   
   /**
    * 
    * Validate whether a item exists in the collection
    * @param dataCollection is a instance of Collection<String> class
    * @param validatedName is a instance of String which is name of field
    * @param validatedValue is a instance of String which is value of field
    * 
    * @return true in case the search String data is available in the collection;
    * otherwise false 
    * 
    */
   public static boolean itemMatchingPatternExistsInCollectionAndLog( Collection< String > dataCollection, String validatedName, 
                                                                      String validatedValue, String messagePrefix ) {
      
      for( String exclusionValue : dataCollection ) {

         String exclusionValueTrim = exclusionValue.trim();

         if( validatedValue.matches( exclusionValueTrim ) ) {
         
            LOGGER.info( messagePrefix + " - Due to exclusion - ignoring " + validatedName + " value:'" + validatedValue + "' due to exclusion value:'" + exclusionValueTrim + "'" );
            validatedValue = null;
            
            return Boolean.TRUE;
         }
      }
      
      return Boolean.FALSE;
   }
   
   
   /**
    * 
    * Validate whether the collection not null or empty
    * 
    * @param dataCollection is a instance of Collection<?> class
    * 
    * @return true in case the dataCollection is not null or empty;
    * otherwise false
    * 
    */
   public static boolean doesCollectionContainsValue(Collection<?> dataCollection)
   {
      boolean resultFlag = Boolean.FALSE;
      if( dataCollection != null ) {
         if( !dataCollection.isEmpty() ) {
            resultFlag = Boolean.TRUE;
         }
      }
      return resultFlag;
      
   }
   

   /**
    * 
    * @param data is a instance of String class
    * @param separator is used as a delimiter between strings
    * 
    * @return a List<String> in case data contains value otherwise empty list
    * 
    */
   public static List<String> convertStringtoArrayList( String data, String separator ) {
      
      List<String> resultList = new ArrayList< String >();
      
      if ( StringUtils.doesValueExist( data ) ) {
         resultList = Arrays.asList( data.trim().split( separator ) );
      } 
      
      return resultList;
      
   }
   
}
