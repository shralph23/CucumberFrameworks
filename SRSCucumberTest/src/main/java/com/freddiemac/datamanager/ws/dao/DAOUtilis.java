package com.freddiemac.datamanager.ws.dao;

import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class DAOUtilis
{

   private DAOUtilis() {
   }
   
   /**
    * Create a LinkedHashMap with key as database table column name and the corresponding column values as search keys based in order to maintain the insert ordering iteration of these search keys.
    * 
    * @param appraisalIdentifierMatchs is a instance of Set< String > class
    * @param loanUnderwritingCaseIdentifierMatchs is a instance of Set< String > class
    * @param mERSMINIdentifierMatchs is a instance of Set< String > class
    * @param lenderLoanIdentifierMatchs is a instance of Set< String > class
    * @param textStdzdPptyAddrLiCnctntds is a instance of Set< String > class
    * @param idPmlSubmnLinks is a instance of Set< String > class
    * @return keys is a instance of Map< String, Set< String > > class.
    */
   public static Map< String, Set< String > > populateCacheKeys( Set< String > appraisalIdentifierMatchs,
         Set< String > loanUnderwritingCaseIdentifierMatchs,
         Set< String > mERSMINIdentifierMatchs,
         Set< String > lenderLoanIdentifierMatchs,
         Set< String > textStdzdPptyAddrLiCnctntds,
         Set< String > idPmlSubmnLinks )
   {

      Map< String, Set< String > > keys = new LinkedHashMap< >();

      SRSConstants.SQL_SEARCH_KEYS.stream().forEach( searchKey -> {
         switch( searchKey )
         {
            case SRSConstants.SQL_SEARCH_KEY_DOCFILEID_MTCH:
               keys.put( searchKey, appraisalIdentifierMatchs );
               break;
            case SRSConstants.SQL_SEARCH_KEY_AUSID_MTCH:
               keys.put( searchKey, loanUnderwritingCaseIdentifierMatchs );
               break;
            case SRSConstants.SQL_SEARCH_KEY_MERSMINID_MTCH:
               keys.put( searchKey, mERSMINIdentifierMatchs );
               break;
            case SRSConstants.SQL_SEARCH_KEY_LENDERLOANID_MTCH:
               keys.put( searchKey, lenderLoanIdentifierMatchs );
               break;
            case SRSConstants.SQL_SEARCH_KEY_ADDRESSTEXT_POSTALCODE_MTCH:
               keys.put( searchKey, textStdzdPptyAddrLiCnctntds );
               break;
            case SRSConstants.SQL_SEARCH_KEY_IDPMLSUBMNLINK:
               keys.put( searchKey, idPmlSubmnLinks );
               break;
            default:
               break;
         }
      } );
      return keys;

   }

   public static MapSqlParameterSource generateQueriesParameters( Map< String, Set< String > > keys )
   {

      MapSqlParameterSource submissionParams = new MapSqlParameterSource();

      keys.entrySet().stream()
                     .filter( srsCacheKeyEntry -> !srsCacheKeyEntry.getKey().equals( SRSConstants.SQL_SEARCH_KEYS.get( 5 ) ) &&
                                                  CollectionUtils.doesCollectionContainsValue( srsCacheKeyEntry.getValue() ) )
                     .forEach( srsCacheKeyEntry -> submissionParams.addValue( srsCacheKeyEntry.getKey(), srsCacheKeyEntry.getValue() ) );
            
      return submissionParams;

   }

}
