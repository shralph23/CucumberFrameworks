package com.freddiemac.datamanager.ws.srs.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({"AddressLineText", "StreetPrimaryNumberText", "StreetName", "CityName", "FipsStateAlphaCode", "PostalCode", "ZipPlusFourCode"})
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressType
{

   private String addressLineText;
   private String streetPrimaryNumberText;
   private String streetName;
   private String cityName;
   private String fipsStateAlphaCode;
   private String postalCode;
   private String zipPlusFourCode;
   
   @JsonGetter( "AddressLineText" )
   public String getAddressLineText()
   {
      return addressLineText;
   }

   @JsonSetter( "AddressLineText" )
   public void setAddressLineText( String addressLineText )
   {
      this.addressLineText = addressLineText;
   }

   @JsonGetter( "StreetPrimaryNumberText" )
   public String getStreetPrimaryNumberText()
   {
      return streetPrimaryNumberText;
   }

   @JsonSetter( "StreetPrimaryNumberText" )
   public void setStreetPrimaryNumberText( String streetPrimaryNumberText )
   {
      this.streetPrimaryNumberText = streetPrimaryNumberText;
   }

   @JsonGetter( "StreetName" )
   public String getStreetName()
   {
      return streetName;
   }

   @JsonSetter( "StreetName" )
   public void setStreetName( String streetName )
   {
      this.streetName = streetName;
   }

   @JsonGetter( "CityName" )
   public String getCityName()
   {
      return cityName;
   }

   @JsonSetter( "CityName" )
   public void setCityName( String cityName )
   {
      this.cityName = cityName;
   }

   @JsonGetter( "FipsStateAlphaCode" )
   public String getFIPSStateAlphaCode()
   {
      return fipsStateAlphaCode;
   }

   @JsonSetter( "FipsStateAlphaCode" )
   public void setFIPSStateAlphaCode( String fIPSStateAlphaCode )
   {
      this.fipsStateAlphaCode = fIPSStateAlphaCode;
   }

   @JsonGetter( "PostalCode" )
   public String getPostalCode()
   {
      return postalCode;
   }

   @JsonSetter( "PostalCode" )
   public void setPostalCode( String postalCode )
   {
      this.postalCode = postalCode;
   }

   @JsonGetter( "ZipPlusFourCode" )
   public String getZIPPlusFourCode()
   {
      return zipPlusFourCode;
   }

   @JsonSetter( "ZipPlusFourCode" )
   public void setZIPPlusFourCode( String zIPPlusFourCode )
   {
      this.zipPlusFourCode = zIPPlusFourCode;
   }

}
