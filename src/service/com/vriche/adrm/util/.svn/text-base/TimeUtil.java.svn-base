package com.vriche.adrm.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {
	private static final int MINS_PER_DAY = 60 * 24;
	  private static final long MS_PER_DAY = 1000 * 60 * MINS_PER_DAY;

	  private static final int SEC = 1000;
	  private static final int MIN = SEC * 60;
	  private static final int HOUR = MIN * 60;
	  private static final int DAY = HOUR * 24;
	  private static final long WEEK = DAY * 7;
	  private static final long YEAR = WEEK * 52;

	  private static final long[] buckets = { YEAR, WEEK, DAY, HOUR, MIN, SEC };
	  private static final String[] bucketNames = { "year", "week", "day",
	      "hour", "minute", "second" };

	  private static GregorianCalendar statFmtCal = new GregorianCalendar();

	  private static final String ts24Pat = "H:mm:ss yy-MM-dd";
	  public static String stringSecsFormat(long msecs) {
	    GregorianCalendar cal = new GregorianCalendar();
	    StringBuffer sBuf = new StringBuffer(11);

	    cal.setTime(new Date(msecs));

	    int hour = cal.get(Calendar.HOUR);

	    if (hour == 0)
	      hour = 12;

	    if (hour < 10)
	      sBuf.append(" ");

	    sBuf.append(Integer.toString(hour));
	    sBuf.append(":");

	    int minute = cal.get(Calendar.MINUTE);

	    if (minute < 10)
	      sBuf.append("0");

	    sBuf.append(Integer.toString(minute));
	    sBuf.append(":");

	    int secs = cal.get(Calendar.SECOND);

	    if (secs < 10) {
	      sBuf.append("0");
	    }
	    sBuf.append(Integer.toString(secs));

	    sBuf.append(" ");
	    sBuf.append(cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM");

	    return (sBuf.toString());
	  }
	  
	  
	  public static String format(long ms) {//将毫秒数换算成x天x时x分x秒x毫秒
		   int ss = 1000;
		   int mi = ss * 60;
		   int hh = mi * 60;
		   int dd = hh * 24;

		   long day = ms / dd;
		   long hour = (ms - day * dd) / hh;
		   long minute = (ms - day * dd - hour * hh) / mi;
		   long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		   long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		   String strDay = day < 10 ? "0" + day : "" + day;
		   String strHour = hour < 10 ? "0" + hour : "" + hour;
		   String strMinute = minute < 10 ? "0" + minute : "" + minute;
		   String strSecond = second < 10 ? "0" + second : "" + second;
		   String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		   strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
		   return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
		} 
	  
	  public static String format2HourMiSe(long ms) {//将毫秒数换算成x天x时x分x秒x毫秒
		   int ss = 1000;
		   int mi = ss * 60;
		   int hh = mi * 60;
		   int dd = hh * 24;

		   long day = ms / dd;
		   long hour =  (ms - day * dd) / hh;
		   long hour2 = day*24 + (ms - day * dd) / hh;
		   long minute = (ms - day * dd - hour * hh) / mi;
		   long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		   long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		   String strDay = day < 10 ? "0" + day : "" + day;
		   String strHour = hour < 10 ? "0" + hour : "" + hour;
		   String strHour2 = hour2 < 10 ? "0" + hour2 : "" + hour2;
		   String strMinute = minute < 10 ? "0" + minute : "" + minute;
		   String strSecond = second < 10 ? "0" + second : "" + second;
		   String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		   strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
//		   return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
		   return  strHour2 + ":" + strMinute + ":" + strSecond;
		} 
	  
	  public static String format2HourMiSe2(long ms) {//将毫秒数换算成x天x时x分x秒x毫秒
		   int ss = 1000;
		   int mi = ss * 60;
		   int hh = mi * 60;
		   int dd = hh * 24;

		   long day = ms / dd;
		   long hour =  (ms - day * dd) / hh;
		   long hour2 = day*24 + (ms - day * dd) / hh;
		   long minute = (ms - day * dd - hour * hh) / mi;
		   long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		   long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		   String strDay = day < 10 ? "0" + day : "" + day;
		   String strHour = hour < 10 ? "0" + hour : "" + hour;
		   String strHour2 = hour2 < 10 ? "0" + hour2 : "" + hour2;
		   String strMinute = minute < 10 ? "0" + minute : "" + minute;
		   String strSecond = second < 10 ? "0" + second : "" + second;
		   String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		   strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
//		   return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
		   return  strHour2 + "'" + strMinute + "'" + strSecond+"\"";
		}   

}
