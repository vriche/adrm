package com.vriche.adrm.util;


import com.vriche.adrm.util.StringUtil;

import junit.framework.TestCase;


public class StringUtilTest extends TestCase {
    public StringUtilTest(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testEncodePassword() throws Exception {
        String password = "tomcat";
        String encrypted = "536c0b339345616c1b33caf454454d8b8a190d6c";
        assertEquals(StringUtil.encodePassword(password, "SHA"), encrypted);
    }
    
//    public void testCalendar()throws Exception {
//       String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
//   	   SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);
//   	   pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
//   	   pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
//   	   
//   	   
//   	   
//   	   
//   	   Integer day= new  Integer("20061211");
//   	   Date date = convertStringToDate("yyyyMMdd",String.valueOf(day));
//   	   
////	   String y = String.valueOf(day).substring(0,4);
////	   
////	   System.out.println("trialTime: " +  y);
////	   
////	   String m = String.valueOf(date.getMonth());
////	   if (date.getMonth() < 10) m = "0" + m;
////	   String d = String.valueOf(date.getDay());
////	   if (date.getDay() < 10) d = "0" + d;
////	   Integer newDay  = new Integer(y + m + d);
////	   System.out.println("d: " + d);
////	   System.out.println("m: " +  m);
////	   System.out.println("trialTime: " +  new  Integer(y + m + d).toString());  	   
//   	   
//   	   
//   	   
//   	   
//   	   
//   	   Calendar calendar = new GregorianCalendar();
////   	   Date trialTime = new Date();
////   	   calendar.setTime(date);
//   	   int d = 32;
//   	calendar.set(date.getYear(),date.getMonth(),d);
//   	   
//
//   	   
////   	 print out a bunch of interesting things
//         System.out.println("trialTime: " + date.toLocaleString());
//	   	 System.out.println("ERA: " + calendar.get(Calendar.ERA));
//	   	 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
//	   	 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
//	   	 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
//	   	 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
//	   	 System.out.println("DATE: " + calendar.get(Calendar.DATE));
//	   	 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
//	   	 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
//	   	 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
//	   	 System.out.println("DAY_OF_WEEK_IN_MONTH: "
//	   	                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//	   	 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
//	   	 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
//	   	 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
//	   	 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
//	   	 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
//	   	 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
//	   	 System.out.println("ZONE_OFFSET: "
//	   	                    + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
//	   	 System.out.println("DST_OFFSET: "
//	   	                    + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));
//	
//	   	 System.out.println("Current Time, with hour reset to 3");
//	   	 calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
//	   	 calendar.set(Calendar.HOUR, 3);
//	   	 System.out.println("ERA: " + calendar.get(Calendar.ERA));
//	   	 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
//	   	 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
//	   	 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
//	   	 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
//	   	 System.out.println("DATE: " + calendar.get(Calendar.DATE));
//	   	 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
//	   	 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
//	   	 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
//	   	 System.out.println("DAY_OF_WEEK_IN_MONTH: "
//	   	                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//	   	 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
//	   	 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
//	   	 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
//	   	 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
//	   	 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
//	   	 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
//	   	 System.out.println("ZONE_OFFSET: "
//	   	        + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // in hours
//	   	 System.out.println("DST_OFFSET: "
//	   	        + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000))); // in hours
//   	 
//   	 
//    }
//    
//    public void testDateConvert()throws Exception {
//    	String dateStr1 = "20061231";
//    	String dateStr2 = "20070102";
//    	long u = 3600*24*1000;
//    	
//    	Date trialTime1 = convertStringToDate("yyyyMMdd",dateStr1);
//    	Date trialTime2 = convertStringToDate("yyyyMMdd",dateStr2);
//    	
////        System.out.println("trialTime: " + trialTime.toLocaleString());
////        System.out.println("trialTime: " + trialTime.toString());
////   	calendar.setTime(trialTime1);
////   	calendar.setTime(trialTime1);
//    	
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(trialTime1);
//       	long a = calendar.getTimeInMillis();
//       	calendar.setTime(trialTime2);
//       	long b = calendar.getTimeInMillis();  
//       	int days = new Integer(String.valueOf((b-a)/u)).intValue();
//
//       	System.out.println("days: " + days);
//       	
//       	for (int i=0;i<days+1;i++){
//       		long s = a + u*i;
//       		calendar.setTimeInMillis(s);
//       		Date date = calendar.getTime();
//       		Integer d = new Integer(getDateTime("yyyyMMdd",date));
//       		System.out.println("ddddd: " +d.toString());
//       	}
//       	
////        	System.out.println("trialTime: " + calendar2.get(Calendar.YEAR));
////        	System.out.println("trialTime: " + calendar2.get(Calendar.MONTH));
////        	System.out.println("trialTime: " + calendar2.get(Calendar.DATE));
////        	System.out.println("trialTime: " + calendar2.getTime().toLocaleString());      	
//       	
//       	
////       	calendar.setTime(trialTime2);
////    	long b = calendar.getTimeInMillis();
////    	long k =b-a;
////    	for(long j =a;j<b;j++)
////    	calendar.setTimeInMillis()
//    	
//    	
//    	System.out.println("DAY_OF_WEEK: " + a/3600);
//    	calendar.setTimeInMillis(a);
//       	
////	   	System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
//    	System.out.println("trialTime: " + calendar.get(Calendar.YEAR));
//    	System.out.println("trialTime: " + calendar.get(Calendar.MONTH));
//    	System.out.println("trialTime: " + calendar.get(Calendar.DATE));
//    
//       	   
//    }
//    
//    
//    
//    
//    public static final Date convertStringToDate(String aMask, String strDate)
//    throws ParseException {
//      SimpleDateFormat df = null;
//      Date date = null;
//      df = new SimpleDateFormat(aMask);
//
//      try {
//          date = df.parse(strDate);
//      } catch (ParseException pe) {
//          //log.error("ParseException: " + pe);
//          throw new ParseException(pe.getMessage(), pe.getErrorOffset());
//      }
//
//      return (date);
//  }
//    
//    
//    public static final String getDateTime(String aMask, Date aDate) {
//        SimpleDateFormat df = null;
//        String returnValue = "";
//
//        if (aDate == null) {
////            log.error("aDate is null!");
//        } else {
//            df = new SimpleDateFormat(aMask);
//            returnValue = df.format(aDate);
//        }
//
//        return (returnValue);
//    }
    
    

    public static void main(String[] args) {
        junit.textui.TestRunner.run(StringUtilTest.class);
    }
}
