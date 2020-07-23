package com.freddiemac.datamanager.ws.slms.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "slmsRequestMetaData", "slsRequestMetaData", "lstSLSSubmissions", "lstSLSPossibleMatches" } )
public class SLMSRequest
{

   private SLMSRequestMetaData slmsRequestMetaData;
   private SLSRequestMetaData slsRequestMetaData;
   List< SLSSubmissions > lstSLSSubmissions;
   List< SLSPossibleMatches > lstSLSPossibleMatches;

   public SLMSRequest()
   {
      this.slmsRequestMetaData = new SLMSRequestMetaData();
      this.slsRequestMetaData = new SLSRequestMetaData();
      this.lstSLSSubmissions = new ArrayList< SLSSubmissions >();
      this.lstSLSPossibleMatches = new ArrayList< SLSPossibleMatches >();
   }

   @JsonProperty( "SLMSRequestMetaData" )
   public SLMSRequestMetaData getRequestMetaData()
   {
      return slmsRequestMetaData;
   }

   @JsonProperty( "SLMSRequestMetaData" )
   public void setSLMSRequestMetaData( SLMSRequestMetaData slmsRequestMetaData )
   {
      this.slmsRequestMetaData = slmsRequestMetaData;
   }

   @JsonProperty( "SLSRequestMetaData" )
   public SLSRequestMetaData getSLSRequestMetaData()
   {
      return slsRequestMetaData;
   }

   @JsonProperty( "SLSRequestMetaData" )
   public void setSLSRequestMetaData( SLSRequestMetaData slsRequestMetaData )
   {
      this.slsRequestMetaData = slsRequestMetaData;
   }

   @JsonProperty( "SLSSubmissions" )
   public List< SLSSubmissions > getLstSLSSubmissions()
   {
      return lstSLSSubmissions;
   }

   @JsonProperty( "SLSSubmissions" )
   public void setSLSSubmissions( List< SLSSubmissions > lstSLSSubmissions )
   {
      this.lstSLSSubmissions = lstSLSSubmissions;
   }

   @JsonProperty( "SLSPossibleMatches" )
   public List< SLSPossibleMatches > getLstSLSPossibleMatches()
   {
      return lstSLSPossibleMatches;
   }

   @JsonProperty( "SLSPossibleMatches" )
   public void setSLSPossibleMatches( List< SLSPossibleMatches > lstSLSPossibleMatches )
   {
      this.lstSLSPossibleMatches = lstSLSPossibleMatches;
   }

   @Override
   public String toString()
   {
      return "SLMSRequest [slmsRequestMetaData=" + slmsRequestMetaData + ", slsRequestMetaData=" + slsRequestMetaData + ", lstSLSSubmissions=" + lstSLSSubmissions + ", lstSLSPossibleMatches="
            + lstSLSPossibleMatches + "]";
   }
   
}
