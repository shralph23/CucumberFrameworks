package com.freddiemac.datamanager.ws.slms.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freddiemac.datamanager.ws.slms.model.SLMSMatchResult;


@JsonPropertyOrder(
{ "slmsRequestMetaData", "slmsResponse", "slmsMatchResults", "slmsProcessingTimeDuration" } )
public class SLMSMatchResponse
{

   private SLMSRequestMetaData slmsRequestMetaData;
   private SLMSResponse slmsResponse;
   private List< SLMSMatchResult > slmsMatchResults;
   private Timestamp slmsProcessingTimeDuration;

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

   @JsonProperty( "SLMSResponse" )
   public SLMSResponse getSLMSResponse()
   {
      return slmsResponse;
   }

   @JsonProperty( "SLMSResponse" )
   public void setSLMSResponse( SLMSResponse slmsResponse )
   {
      this.slmsResponse = slmsResponse;
   }

   @JsonProperty( "SLSSubmissions" )
   public List< SLMSMatchResult > getSLMSMatchResults()
   {
      return slmsMatchResults;
   }

   @JsonProperty( "SLSSubmissions" )
   public void setSLMSMatchResults( List< SLMSMatchResult > slmsMatchResults )
   {
      this.slmsMatchResults = slmsMatchResults;
   }

   public Timestamp getSlmsProcessingTimeDuration()
   {
      return slmsProcessingTimeDuration;
   }

   @JsonIgnore
   public void setSlmsProcessingTimeDuration( Timestamp slmsProcessingTimeDuration )
   {
      this.slmsProcessingTimeDuration = slmsProcessingTimeDuration;
   }

   @Override
   public String toString()
   {
      return "SLMSMatchResponse [slmsRequestMetaData=" + slmsRequestMetaData + ", slmsResponse=" + slmsResponse + ", slmsMatchResults=" + slmsMatchResults + ", slmsProcessingTimeDuration="
            + slmsProcessingTimeDuration + "]";
   }

}
