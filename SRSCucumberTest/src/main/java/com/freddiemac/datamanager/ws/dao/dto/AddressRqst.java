package com.freddiemac.datamanager.ws.dao.dto;

import com.freddiemac.datamanager.ws.srs.enums.FIPSStateAlphaCode;
import com.freddiemac.datamanager.ws.util.GeneralUtils;
import com.freddiemac.datamanager.ws.util.StringUtils;

public class AddressRqst
{
   // address attributes for matching
   protected FIPSStateAlphaCode fipsStateAlphaCode;
   protected String postalCode;
   protected String addressLineText;
   protected String streetPrimaryNumberText;
   
   // other address attributes
   protected String streetName;
   protected String cityName;
   protected String zipPlusFourCode;

   public String getFipsStateAlphaCodeString()
   {
      if( fipsStateAlphaCode != null ) {
         return fipsStateAlphaCode.toString();
      }
      else {
         return null;
      }
   }

   public FIPSStateAlphaCode getFipsStateAlphaCode()
   {
      return fipsStateAlphaCode;
   }

   public void setFipsStateAlphaCode( FIPSStateAlphaCode fipsStateAlphaCode )
   {
      this.fipsStateAlphaCode = fipsStateAlphaCode;
   }

   public String getPostalCode()
   {
      return postalCode;
   }

   public void setPostalCode( String postalCode )
   {
      this.postalCode = postalCode;
   }

   public String getAddressLineText()
   {
      return addressLineText;
   }

   public void setAddressLineText( String addressLineText )
   {
      this.addressLineText = addressLineText;
   }

   public String getStreetPrimaryNumberText()
   {
      return streetPrimaryNumberText;
   }

   public void setStreetPrimaryNumberText( String streetPrimaryNumberText )
   {
      this.streetPrimaryNumberText = streetPrimaryNumberText;
   }

   public String getStreetName()
   {
      return streetName;
   }

   public void setStreetName( String streetName )
   {
      this.streetName = streetName;
   }

   public String getCityName()
   {
      return cityName;
   }

   public void setCityName( String cityName )
   {
      this.cityName = cityName;
   }

   public String getZIPPlusFourCode()
   {
      return zipPlusFourCode;
   }

   public void setZIPPlusFourCode( String zipPlusFourCode )
   {
      this.zipPlusFourCode = zipPlusFourCode;
   }

   public void updateAddressUsedInMatch( FIPSStateAlphaCode fipsStateAlphaCode, String postalCode, String addressLineText,
                                         String streetPrimaryNumberText, String streetName, String cityName, String zipPlusFourCode ) {

      if( GeneralUtils.doesObjectExist( fipsStateAlphaCode ) ) {
         setFipsStateAlphaCode( fipsStateAlphaCode );
      }

      if( StringUtils.doesValueExist( addressLineText ) ) {
         setAddressLineText( addressLineText );
      }

      if( StringUtils.doesValueExist( postalCode ) ) {
         setPostalCode( postalCode );
      }

      if( StringUtils.doesValueExist( streetPrimaryNumberText ) ) {
         setStreetPrimaryNumberText( streetPrimaryNumberText );
      }

      if( StringUtils.doesValueExist( streetName ) ) {
         setStreetName( streetName );
      }
      if( StringUtils.doesValueExist( cityName ) ) {
         setCityName( cityName );
      }

      if( StringUtils.doesValueExist( zipPlusFourCode ) ) {
         setZIPPlusFourCode( zipPlusFourCode );
      }
   }

   @Override
   public String toString()
   {
      return "Address [addressLineText=" + addressLineText + ", streetPrimaryNumberText=" + streetPrimaryNumberText + ", streetName="
            + streetName + ",  cityName=" + cityName + ", fipsStateAlphaCode=" + fipsStateAlphaCode + ", postalCode=" + postalCode
            + ", zipPlusFourCode=" + zipPlusFourCode + "]";
   }

}
