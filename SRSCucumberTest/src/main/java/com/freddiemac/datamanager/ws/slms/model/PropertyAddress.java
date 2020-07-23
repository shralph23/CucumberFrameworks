package com.freddiemac.datamanager.ws.slms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "addressLineText", "streetPrimaryNumberText", "StreetName", "CityName", "FIPSStateAlphaCode", "PostalCode", "ZIPPlusFourCode" } )
public class PropertyAddress
{
   // address attributes for matching
   protected String fIPSStateAlphaCode = "";
   protected String postalCode = "";
   protected String addressLineText = "";
   //protected String streetPrimaryNumberText ="";

   // other address attributes
   //protected String streetName="";
   protected String cityName = "";
   //protected String zipPlusFourCode ="";

   @JsonProperty( "FIPSStateAlphaCode" )
   public String getfIPSStateAlphaCode()
   {
      return fIPSStateAlphaCode;
   }

   public void setfIPSStateAlphaCode( String fIPSStateAlphaCode )
   {
      this.fIPSStateAlphaCode = fIPSStateAlphaCode;
   }

   @JsonProperty( "PostalCode" )
   public String getPostalCode()
   {
      return postalCode;
   }

   public void setPostalCode( String postalCode )
   {
      this.postalCode = postalCode;
   }

   @JsonProperty( "AddressLineText" )
   public String getAddressLineText()
   {
      return addressLineText;
   }

   public void setAddressLineText( String addressLineText )
   {
      this.addressLineText = addressLineText;
   }

   /*@JsonProperty("StreetPrimaryNumberText")
   public String getStreetPrimaryNumberText()
   {
      return streetPrimaryNumberText;
   }
   
   public void setStreetPrimaryNumberText( String streetPrimaryNumberText )
   {
      this.streetPrimaryNumberText = streetPrimaryNumberText;
   }
   @JsonProperty("StreetName")
   public String getStreetName()
   {
      return streetName;
   }
   
   public void setStreetName( String streetName )
   {
      this.streetName = streetName.trim().toUpperCase();
   }*/
   @JsonProperty( "CityName" )
   public String getCityName()
   {
      return cityName;
   }

   public void setCityName( String cityName )
   {
      this.cityName = cityName;
   }
   /*@JsonProperty("ZIPPlusFourCode")
   public String getZIPPlusFourCode()
   {
      return zipPlusFourCode;
   }
   
   public void setZIPPlusFourCode( String zipPlusFourCode )
   {
      this.zipPlusFourCode = zipPlusFourCode.trim().toUpperCase();
   }*/

   @Override
   public String toString()
   {
      return "PropertyAddressVO [addressLineText=" + addressLineText + ", cityName=" + cityName + ", fIPSStateAlphaCode=" + fIPSStateAlphaCode + ", postalCode=" + postalCode
            + "]";
   }

}
