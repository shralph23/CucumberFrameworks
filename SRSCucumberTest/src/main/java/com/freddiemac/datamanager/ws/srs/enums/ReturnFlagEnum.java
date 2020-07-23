package com.freddiemac.datamanager.ws.srs.enums;

public enum ReturnFlagEnum {
   SUCCESS,
   ERROR,
   NOOP;

   public String value() {
      return name();
  }

  public static ReturnFlagEnum fromValue(String v) {
      return valueOf(v);
  }
  
}
