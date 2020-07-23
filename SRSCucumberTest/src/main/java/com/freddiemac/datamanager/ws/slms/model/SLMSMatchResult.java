package com.freddiemac.datamanager.ws.slms.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "correlationIdentifier", "surrogateKey", "hindsightSurrogateKeys", "matchingCorrelationIdentifier", "slmsDecision" } )
public class SLMSMatchResult
{
   private String correlationIdentifier;
   private String surrogateKey;
   private List< String > hindsightSurrogateKeys = new ArrayList< String >();
   private String matchingCorrelationIdentifier;
   private String slmsDecision;

   public SLMSMatchResult()
   {
      correlationIdentifier = null;
      surrogateKey = null;
      matchingCorrelationIdentifier = null;
      hindsightSurrogateKeys = new ArrayList< String >();
      slmsDecision = "UNKNOWN";

   }

   @JsonProperty( "CorrelationIdentifier" )
   public String getCorrelationIdentifier()
   {
      return correlationIdentifier;
   }

   @JsonProperty( "CorrelationIdentifier" )
   public void setCorrelationIdentifier( String correlationIdentifier )
   {
      this.correlationIdentifier = correlationIdentifier;
   }

   @JsonProperty( "SurrogateKey" )
   public String getSurrogateKey()
   {
      return surrogateKey;
   }

   @JsonProperty( "SurrogateKey" )
   public void setSurrogateKey( String surrogateKey )
   {
      this.surrogateKey = surrogateKey;
   }

   @JsonProperty( "HindsightSurrogateKeys" )
   public List< String > getHindsightSurrogateKeys()
   {
      return hindsightSurrogateKeys;
   }

   @JsonProperty( "HindsightSurrogateKeys" )
   public void setHindsightSurrogateKeys( List< String > hindsightSurrogateKeys )
   {
      this.hindsightSurrogateKeys = hindsightSurrogateKeys;
   }

   @JsonProperty( "MatchingCorrelationIdentifier" )
   public String getMatchingCorrelationIdentifier()
   {
      return matchingCorrelationIdentifier;
   }

   @JsonProperty( "MatchingCorrelationIdentifier" )
   public void setMatchingCorrelationIdentifier( String matchingCorrelationIdentifier )
   {
      this.matchingCorrelationIdentifier = matchingCorrelationIdentifier;
   }

   @JsonProperty( "SLMSDecision" )
   public String getSLMSDecision()
   {
      return slmsDecision;
   }

   @JsonProperty( "SLMSDecision" )
   public void setSLMSDecision( String slmsDecision )
   {
      this.slmsDecision = slmsDecision;
   }
}
