package com.freddiemac.datamanager.ws.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public final class DateUtils
{

   public static final String HOURS = "HOURS";
   public static final String MINUTES = "MINUTES";
   public static final String SECONDS = "SECONDS";
   public static final String MILLISECONDS = "MILLISECONDS";
   
   private DateUtils()
   {
   }

   /**
    * Method return the current date and time in the format - 2020-02-10 18:53:31.523
    * as the current date and time - 2020-02-10 18:53:31.523
    * 
    * @return currentTimestamp is a instance of java.sql.Timestamp class
    */
   public static java.sql.Timestamp getCurrentTimestamp()
   {

      java.sql.Timestamp currentTimestamp = null;

      // 1) create a java calendar instance
      Calendar calendar = Calendar.getInstance();

      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();

      // 3) a java current time (now) instance
      currentTimestamp = new java.sql.Timestamp( now.getTime() );

      return currentTimestamp;
   }

   /**
    * Method return the current date and time(i.e. 12AM) in the format - 2020-02-10 00:00:00.0
    * even though the current date and time is 2020-02-10 18:53:31.523
    * 
    * @return currentResetTimestamp is a instance of java.sql.Timestamp class
    */
   public static java.sql.Timestamp getCurrentResetTimestamp()
   {

      java.sql.Timestamp currentResetTimestamp = null;

      // 1) create a java calendar instance
      Calendar calendar = Calendar.getInstance();
      calendar.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      
      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();

      // 3) a java current date (now) instance
      currentResetTimestamp = new java.sql.Timestamp( now.getTime() );

      return currentResetTimestamp;
   }
   
   /**
    * Method return the current date and time(i.e. 12:30AM) minus the 
    * duration (i.e Hours/Minute/Seconds/MillSeconds) in the format - 2020-02-10 00:20:00.0
    * in case you wanted to reduce the 3 hours from the current time
    * 
    * @param durationType is a instance of String class
    * @param duration is a integer data type
    * 
    * @return currentResetTimestamp is a instance of java.sql.Timestamp class
    * 
    */
   public static java.sql.Timestamp getCurrentTimestampMinusDuration(String durationType, int duration) {

      java.sql.Timestamp currentResetTimestamp = null;

      // 1) create a java calendar instance and reduce the duration based on the duration type  
      Calendar calendar = Calendar.getInstance();
      switch ( durationType ) {
         case HOURS:
            calendar.add(Calendar.HOUR_OF_DAY, -duration);            
            break;
         case MINUTES:
            calendar.add(Calendar.MINUTE, -duration);
            break;
         case SECONDS:
            calendar.add(Calendar.SECOND, -duration);
            break;
         case MILLISECONDS:
            calendar.add(Calendar.MILLISECOND, -duration);
            break;
      }
      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();
      
      // 3) a java current date (now) instance
      currentResetTimestamp = new java.sql.Timestamp( now.getTime() );

      return currentResetTimestamp;
   }
   
   /**
    * Method return the current date and time(i.e. 12:30AM) minus the 
    * duration (i.e Hours/Minute/Seconds/MillSeconds) in the format - 2020-02-10 00:20:00.0
    * in case you wanted to increase the 3 hours from the current time
    * 
    * @param durationType is a instance of String class
    * @param duration is a integer data type
    * 
    * @return currentResetTimestamp is a instance of java.sql.Timestamp class
    * 
    */
   public static java.sql.Timestamp getCurrentTimestampPlusDuration(String durationType, int duration) {

      java.sql.Timestamp currentResetTimestamp = null;

      // 1) create a java calendar instance and reduce the duration based on the duration type  
      Calendar calendar = Calendar.getInstance();
      switch ( durationType ) {
         case HOURS:
            calendar.add(Calendar.HOUR_OF_DAY, duration);            
            break;
         case MINUTES:
            calendar.add(Calendar.MINUTE, duration);
            break;
         case SECONDS:
            calendar.add(Calendar.SECOND, duration);
            break;
         case MILLISECONDS:
            calendar.add(Calendar.MILLISECOND, duration);
            break;
      }
      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();
      
      // 3) a java current date (now) instance
      currentResetTimestamp = new java.sql.Timestamp( now.getTime() );

      return currentResetTimestamp;
   }
   
   public static java.sql.Timestamp getTimestampFromGregorianCalendar( XMLGregorianCalendar cal )
   {

      return( new java.sql.Timestamp( cal.toGregorianCalendar().getTime().getTime() ) );
   }

   public static XMLGregorianCalendar getCurrentGregorianCalendar()
         throws DatatypeConfigurationException
   {

      return( getGregorianCalendarFromTimestamp( getCurrentTimestamp() ) );
   }

   public static XMLGregorianCalendar getGregorianCalendarFromTimestamp( final java.sql.Timestamp aTimestamp )
         throws DatatypeConfigurationException
   {

      XMLGregorianCalendar returnDate = null;

      final GregorianCalendar cal = new GregorianCalendar();
      cal.setTime( aTimestamp );
      returnDate = DatatypeFactory.newInstance().newXMLGregorianCalendar( cal );

      return returnDate;
   }

   public static XMLGregorianCalendar getGregorianCalendarFromDate( final Date aDate ) throws DatatypeConfigurationException
   {
      XMLGregorianCalendar returnDate = null;

      final GregorianCalendar cal = new GregorianCalendar();
      cal.setTime( aDate );
      returnDate = DatatypeFactory.newInstance().newXMLGregorianCalendar( cal );
      return returnDate;
   }

   public static XMLGregorianCalendar getXMLGregorianCalendar() throws DatatypeConfigurationException
   {
      GregorianCalendar gCal = new GregorianCalendar();
      gCal.getTime();
      return getXMLGregorianCalendar( gCal.getTime() );
   }

   private static XMLGregorianCalendar getXMLGregorianCalendar( Date date ) throws DatatypeConfigurationException
   {
      GregorianCalendar gCal = new GregorianCalendar();
      gCal.setTime( date );
      return DatatypeFactory.newInstance().newXMLGregorianCalendar( gCal );
   }

   public static String getElapseTime( long startTime )
   {
      long endTime = System.currentTimeMillis();
      long diff = endTime - startTime;
      final long hr = TimeUnit.MILLISECONDS.toHours( diff );
      final long min = TimeUnit.MILLISECONDS.toMinutes( diff - TimeUnit.HOURS.toMillis( hr ) );
      final long sec = TimeUnit.MILLISECONDS.toSeconds( diff - TimeUnit.HOURS.toMillis( hr ) - TimeUnit.MINUTES.toMillis( min ) );
      final long ms = TimeUnit.MILLISECONDS.toMillis( diff - TimeUnit.HOURS.toMillis( hr ) - TimeUnit.MINUTES.toMillis( min )
            - TimeUnit.SECONDS.toMillis( sec ) );
      return String.format( "%02d Hours, %02d Minutes, %02d Seconds, and %03d Mesc.", hr, min, sec, ms );

   }

}
