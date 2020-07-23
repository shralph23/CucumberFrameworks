package com.freddiemac.datamanager.ws.srs.enums;

/**
 * @author f402611 HindSight MODES
 */
public enum HindSightModeEnum
{
   ON,
   OFF,
   LOG;
   
   public String value() {
      return name();
   }
   
   public static HindSightModeEnum fromValue(String v) {
      return valueOf(v);
   }
}
