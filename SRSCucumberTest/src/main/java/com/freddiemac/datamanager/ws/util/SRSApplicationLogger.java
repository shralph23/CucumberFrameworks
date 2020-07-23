package com.freddiemac.datamanager.ws.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SRSApplicationLogger
{

   public SRSApplicationLogger()
   {
      System.out.println( "In SLRSApplicationLogger - constructor!!!!" );
   }

   public static Logger getLogger( Class< ? > z )
   {
      return LoggerFactory.getLogger( z.getName() );
   }
}
