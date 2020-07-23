package com.freddiemac.datamanager.ws.util;

import com.freddiemac.datamanager.ws.util.StringUtils;

public class NumberUtils {

   /**
    * 
    * Checks whether the data is valid numeric value 
    * 
    * @param data is a instance of String class
    * 
    * @return true incase of number otherwise false
    * 
    */
	public static boolean validateNumericData( String data ) {
		
		boolean resultFlag = Boolean.TRUE;
		
      if ( StringUtils.isValueEmpty( data ) ) {
         resultFlag = Boolean.FALSE;
      }
      else {
         data = data.trim();
   		for ( char chr : data.toCharArray() ) {
   	        if ( !Character.isDigit( chr ) ) {	        	
   	        	resultFlag = Boolean.FALSE;
   	        	break;
   	        }
   	    }			
      }
      
		return resultFlag;		
		
	}	
		
	/**
    * 
    * Checks whether the data is valid non zero long numeric value 
    * 
    * @param data is a instance of String class
    * 
    * @return true incase of number otherwise false
    * 
    */
	public static boolean validateNonZeroLongData( String data ) {
      
      boolean resultFlag = NumberUtils.validateNumericData( data );           
      
      if ( resultFlag )  {
         data = data.trim();
         if ( Long.parseLong( data ) == 0 ) {
            resultFlag = Boolean.FALSE;
         }
      }    
    
      return resultFlag;      
      
   }
	
}
