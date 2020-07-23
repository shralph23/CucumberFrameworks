package com.freddiemac.datamanager.ws.slms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "partyIdentifier", "partyRoleType" } )
public class PartyRole
{

   private String partyIdentifier = "";
   private String partyRoleType = "";

   public PartyRole()
   {
      this.partyIdentifier = "";
      this.partyRoleType = "";
   }

   @JsonProperty( "PartyIdentifier" )
   public String getPartyIdentifier()
   {
      return partyIdentifier;
   }

   public void setPartyIdentifier( String partyIdentifier )
   {
      this.partyIdentifier = partyIdentifier;
   }

   @JsonProperty( "PartyRoleType" )
   public String getPartyRoleType()
   {
      return partyRoleType;
   }

   public void setPartyRoleType( String partyRoleType )
   {
      this.partyRoleType = partyRoleType;
   }

   @Override
   public String toString()
   {
      return "PartyRoleVO [partyIdentifier=" + partyIdentifier + ", partyRoleType=" + partyRoleType + "]";
   }

}
