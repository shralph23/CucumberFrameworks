package com.freddiemac.datamanager.ws.validation;

import com.freddiemac.datamanager.ws.util.CollectionUtils;
import com.freddiemac.datamanager.ws.util.NumberUtils;
import com.freddiemac.datamanager.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.freddiemac.datamanager.ws.constants.SRSConstants;


public class SRSRequestScrubbingValidation
{
   /**
    * Validate whether the nameSrceSyst Field is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param nameSrceSyst is a instance of String class.
    * @return nameSrceSystMtch is a instance of String class.
    */
   public static String validateNameSrceSyst( String nameSrceSyst )
   {

      String nameSrceSystMtch = null;

      if( StringUtils.doesValueExist( nameSrceSyst ) )
         nameSrceSystMtch = StringUtils.doTrimPlusUpperCase( nameSrceSyst );

      return nameSrceSystMtch;

   }

   /**
    * Validate whether the namePrtyRoleType Field is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param namePrtyRoleType is a instance of String class.
    * @return namePrtyRoleTypeMtch is a instance of String class.
    */
   public static String validateNamePrtyRoleType( String namePrtyRoleType )
   {

      String namePrtyRoleTypeMtch = null;

      if( StringUtils.doesValueExist( namePrtyRoleType ) )
         namePrtyRoleTypeMtch = StringUtils.doTrimPlusUpperCase( namePrtyRoleType );

      return namePrtyRoleTypeMtch;

   }

   /**
    * Validate whether the idPrty Field is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param idPrty is a instance of String class.
    * @return idPrtyMtch is a instance of String class.
    */
   public static String validateIdPrty( String idPrty )
   {

      String idPrtyMtch = null;

      if( StringUtils.doesValueExist( idPrty ) )
         idPrtyMtch = StringUtils.doTrimPlusUpperCase( idPrty );

      return idPrtyMtch;

   }

   /**
    * Validate whether the nameStdzdPptyCity Field is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param nameStdzdPptyCity is a instance of String class.
    * @return nameStdzdPptyCityMtch is a instance of String class.
    */
   public static String validateNameStdzdPptyCity( String nameStdzdPptyCity )
   {

      String nameStdzdPptyCityMtch = null;

      if( StringUtils.doesValueExist( nameStdzdPptyCity ) )
         nameStdzdPptyCityMtch = StringUtils.doTrimPlusUpperCase( nameStdzdPptyCity );

      return nameStdzdPptyCityMtch;

   }

   /**
    * Validate whether the taxPayerId Field is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param taxPayerId is a instance of String class.
    * @return taxPayerId is a instance of String class.
    */
   public static String validateTaxPayerId( String taxPayerId )
   {
      String taxPayerIdMtch = null;

      if( StringUtils.doesValueExist( taxPayerId ) )
         taxPayerIdMtch = StringUtils.doTrimPlusUpperCase( taxPayerId );

      return taxPayerIdMtch;
   }

   /**
    * Validate whether the postalCode Field is not null/empty and also it checks the postalCode is a valid number plus the length is equal to 5
    * 
    * @param postalCode is a instance of String class.
    * @return postalCodeMtch is a instance of String class.
    */
   public static String validatePostalCode( String inputValue )
   {
      String validatedValue = null;

      if( StringUtils.doesValueExist( inputValue ) ) {

         inputValue = inputValue.trim();

         if( NumberUtils.validateNumericData( inputValue ) ) {

            if( inputValue.length() == SRSConstants.POSTAL_KEY_LENGTH ) {

               validatedValue = inputValue;
            }
         }
      }

      return validatedValue;
   }

   /**
    * After validating addressLineText and postalCode based on the rules we need to concatenate the addressLineText and postalCode string and also remove the string which exceeds the 250 characters
    * ceiling limit assumes passing in validated address and postal code
    * 
    * @param validatedAddressLineText is a instance of String
    * @param validatedPostalCode is a instance of String
    * @return restultAddressLineTextPostalCode instance of String based on the validation rules otherwise return null
    */
   public static String deriveAddressLineTextPostalCode( String validatedAddressLineText, String validatedPostalCode )
   {

      String restultAddressLineTextPostalCode = null;

      if( StringUtils.doesValueExist( validatedAddressLineText ) && StringUtils.doesValueExist( validatedPostalCode ) ) {

         int addressLineTextMtchLenght = validatedAddressLineText.length() > SRSConstants.ADDRESS_NUMERIC_TWO_HUNDRED_FIFTY ? SRSConstants.ADDRESS_NUMERIC_TWO_HUNDRED_FIFTY
               : validatedAddressLineText.length();

         restultAddressLineTextPostalCode = ( validatedAddressLineText.substring( SRSConstants.ADDRESS_NUMERIC_ZERO, addressLineTextMtchLenght ) )
               .concat( SRSConstants.ADDRESS_KEY_SPACE ).concat( validatedPostalCode );

      }

      return restultAddressLineTextPostalCode;
   }

   /**
    * Validate whether the idMersMin Field is not null/empty and also we trim to check it is a valid number plus the length is equal to 18 plus the idMersMin starts with digit one
    * 
    * @param inputValue is a instance of String class.
    * @return validatedValue is a instance of String class.
    */
   public static String validateIdMersmin( String inputValue )
   {
      String validatedValue = null;

      if( StringUtils.doesValueExist( inputValue ) ) {

         inputValue = inputValue.trim();

         if( NumberUtils.validateNumericData( inputValue ) ) {

            if( inputValue.length() == SRSConstants.MERSMIN_KEY_LENGTH && inputValue.startsWith( SRSConstants.NUMERIC_ONE ) ) {

               validatedValue = inputValue;
            }
         }
      }

      List< String > mersminIdExcludeList = Arrays.asList( SRSConstants.MERSMIN_IDENTIFIER_EXCLUDE_PATTERN );

      validatedValue = validateExcludeList( validatedValue, mersminIdExcludeList );

      return validatedValue;
   }

   /**
    * Validate whether the idApprslDocFile Field is not null/empty and also we trim and convert to uppercase plus the length is equal to 10 plus the idApprslDocFile starts with digit one or two Check
    * whether the idApprslDocFile field value is not present in exclude list
    * 
    * @param inputValue is a instance of String class.
    * @return validatedValue is a instance of String class.
    */
   public static String validateIdApprslDocFile( String inputValue )
   {
      String validatedValue = null;

      if( StringUtils.doesValueExist( inputValue ) ) {

         inputValue = StringUtils.doTrimPlusUpperCase( inputValue );

         if( ( inputValue.length() == SRSConstants.DOC_FILE_ID_KEY_LENGTH ) &&
               ( inputValue.startsWith( SRSConstants.NUMERIC_ONE ) || inputValue.startsWith( SRSConstants.NUMERIC_TWO ) ) ) {

            validatedValue = inputValue;
         }
      }

      List< String > appraisalIdExcludeList = Arrays.asList( SRSConstants.APPRAISAL_IDENTIFIER_EXCLUDE_PATTERN );

      validatedValue = validateExcludeList( validatedValue, appraisalIdExcludeList );

      return validatedValue;
   }

   /**
    * Validate whether the idLendrLoan Field is not null/empty and also we trim and convert into uppercase in case of not null/empty Check whether the idLendrLoan field value is not present in exclude
    * list
    * 
    * @param inputValue is a instance of String class.
    * @return validatedValue is a instance of String class.
    */
   public static String validateIdLendrLoan( String inputValue )
   {
      String validatedValue = null;

      if( StringUtils.doesValueExist( inputValue ) && inputValue.length() <= SRSConstants.LENDER_LOAN_ID_KEY_LENGTH ) {
         validatedValue = StringUtils.doTrimPlusUpperCase( inputValue );
      }

      String lenderLoanExclude = SRSConstants.LENDER_LOAN_IDENTIFIER_EXCLUDE_PATTERN;
      String lenderLoanExcludeFormatted = StringUtils.doValuesFindReplace( ",", lenderLoanExclude, "|" );

      if( StringUtils.doesValueExist(validatedValue) ) {
         validatedValue = StringUtils.validateValuesAgainstPattern( lenderLoanExcludeFormatted, validatedValue );
      }

      return validatedValue;
   }

   /**
    * Validate whether the AusID for LP Field is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param inputValue is a instance of String class.
    * @return validatedValue is a instance of String class.
    */
   public static String validateAusIDForLP( String inputValue )
   {

      String validatedValue = null;
      
      inputValue = StringUtils.doTrimPlusUpperCase( inputValue );

      if( StringUtils.doesValueExist( inputValue ) && inputValue.length() == SRSConstants.AUSID_LPA_KEY_LENGTH ) {
         validatedValue = inputValue;
      }
      
      return validatedValue;
   }

   /**
    * Validate whether the AusID for DU Field is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param inputValue is a instance of String class.
    * @return validatedValue is a instance of String class.
    */
   public static String validateAusIDForDU( String inputValue )
   {
      
      String validatedValue = null;
      
      inputValue = StringUtils.doTrimPlusUpperCase( inputValue );

      if( StringUtils.doesValueExist( inputValue ) && inputValue.length() == SRSConstants.AUSID_DU_KEY_LENGTH ) {
         validatedValue = inputValue;
      }
      
      return validatedValue;
   }

   /**
    * Validate whether the AusType is not null/empty and also we trim and convert into uppercase in case of not null/empty
    * 
    * @param inputValue is a instance of String class.
    * @return validatedValue is a instance of String class.
    */
   public static String validateAusType( String inputValue )
   {

      String validatedValue = null;

      if( StringUtils.doesValueExist( inputValue ) ) {
         validatedValue = StringUtils.doTrimPlusUpperCase( inputValue );
         if( !( StringUtils.containsIgnoreCase( validatedValue, SRSConstants.LP_FIELD_UPPER ) || StringUtils.containsIgnoreCase( validatedValue, SRSConstants.LPA_FIELD_UPPER )
               || StringUtils.containsIgnoreCase( validatedValue, SRSConstants.DU_FIELD_UPPER ) ) ) {
            validatedValue = null;
         }
      }

      return validatedValue;
   }

   /**
    * Validate whether the addressLineText field is not null/empty and also it remove the extra space in addressLineText and converts into uppercase in case of not null/empty Validate the resulted
    * addressLineTextMtch is present in the addressLineTextMtchExcludeList Check whether the addressLineText field value is not present in exclude list
    * 
    * @param inputValue is a instance of String class.
    * @return validatedValue is a instance of String class which passes the validation rules otherwise null.
    */
   public static String validateAddressLineText( String inputValue )
   {
      String validatedValue = null;

      if( StringUtils.doesValueExist( inputValue ) ) {

         String addressLineTextSingleSpace = StringUtils.doValuesFindReplace( "\\s+", inputValue, SRSConstants.ADDRESS_KEY_SPACE );

         validatedValue = StringUtils.doTrimPlusUpperCase( addressLineTextSingleSpace );

      }

      List< String > addressLineTextExcludeList = Arrays.asList( SRSConstants.SLS_ADDRESS_LINE_TEXT_MATCH_EXCLUDE_PATTERN );

      validatedValue = validateExcludeList( validatedValue, addressLineTextExcludeList );

      return validatedValue;
   }

   /**
    * Validate attribute present in exclude lists
    * 
    * @param attributeValue is a instance of String class
    * 
    * @return excludeLists is a instance of List< String > class
    * 
    */
   public static String validateExcludeList( String attributeValue, List< String > excludeLists )
   {

      if( excludeLists.contains( attributeValue ) ) {
         return null;
      }
      return attributeValue;
   }
   
   /**
    * Masks all the SSN's in the list
    * 
    * @param ssns is a instance of List< String > class
    * 
    * @return ssnsMasked is a instance of List< String > class
    * 
    */
   public static List< String > getMaskedSSNs( List< String > ssns ) {

      List< String > ssnsMasked = new ArrayList< >();

      if( CollectionUtils.doesCollectionContainsValue( ssns ) ) {
         ssns.stream()             
                .map( StringUtils::getMaskedString )
                .forEach( ssnsMasked::add );
      }

      return ssnsMasked;
      
   }
}
