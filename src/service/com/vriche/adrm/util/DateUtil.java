
package com.vriche.adrm.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.User;



//import org.springframework.context.i18n.LocaleContextHolder;


/**
 * Date Utility Class
 * This is used to convert Strings to Dates and Timestamps
 *
 * <p>
 * <a href="DateUtil.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a> 
 *   to correct time pattern. Minutes should be mm not MM
 * 	(MM is month). 
 * @version $Revision: 1.1 $ $Date: 2007/04/05 01:39:46 $
 */

public class DateUtil {
    //~ Static fields/initializers ============================================= 
	private static final Log log = LogFactory.getLog(DateUtil.class);


    private static String defaultDatePattern = null;
    private static String timePattern = "HH:mm";
    private  String curServerDate ="";
 
    public DateUtil(){}
    //~ Methods ================================================================

   
    /**
     * Return default datePattern (MM/dd/yyyy)
     * @return a string representing the date pattern on the UI
     */
    public static synchronized String getDatePattern() {
//        Locale locale = LocaleContextHolder.getLocale();
        try {
//            defaultDatePattern = ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale).getString("date.format");
            defaultDatePattern = "yyyy/MM/dd";
        } catch (MissingResourceException mse) {
//            defaultDatePattern = "MM/dd/yyyy";
            defaultDatePattern = "yyyy/MM/dd";
        }
        
        return defaultDatePattern;
    }
    
    public static String getDateTimePattern() {
        return DateUtil.getDatePattern() + " HH:mm:ss.S";
    }

    /**
     * This method attempts to convert an Oracle-formatted date
     * in the form dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }
    
    public static String getDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String sDate = sdf.format(new Date());
        return sDate;
    }
    
    public  String getGlobalParams(String loginName){
    	
        loginName = StringUtil.getNullValue(loginName,"");
        
        if("".equals("")){
       	 	loginName = UserUtil.getCurrentPrincipalUser();
        }
     	String s = String.valueOf(Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAMS));
     	
//     	 log.info(">>>>>>>>>>>>>getGlobalParams>>>>>>>>>>>>>>>>" +s);
     	
     	s = StringUtil.oldReplace(s,"adrm_logined_user",loginName);

    	 return s; 
    }
    
    
    
    public  String getServiceDateMain(String loginName)
    {
    	
//    	System.out.println("loginName>>>>>>>>>>>>>>>>>>>"+ loginName);
    	
    	 WebContext ctx = WebContextFactory.get();
         HttpServletRequest req = ctx.getHttpServletRequest();
         HttpSession session = req.getSession();
         
         log.info("getServiceDateMain value>>>>>>>>>>info>>before >>loginName>>>>>"+ loginName);
         
 
         
         
         loginName = StringUtil.getNullValue(loginName,"");
         if("".equals("")){
        	 loginName = UserUtil.getCurrentPrincipalUser();
         }
         
    	 String value = (String) session.getAttribute(loginName);

    	 
         if (log.isDebugEnabled()) {
//             log.debug("getServiceDateMain value>>>>>>>>>debug>>>>>>>>>>"+ value);
             log.info("getServiceDateMain value>>>>>>>>>>info>>>>>>>>>"+ value);
             
         }

    	if(value == null||loginName.equals("anonymous")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String sDate = sdf.format(new Date());
            
            System.out.println("loginName>>>>>>>>>>>>>>>>>>>"+ loginName);
            
            User u = UserUtil.getCurUser(loginName);
            String fullName = u.getFullName();
            System.out.println("fullName>>>>>>>>>>>>>>>>>>>"+ fullName);
            System.out.println("u>>>>>>>>>>>>>>>>>>>"+ u.getId());
            
            String sOrgs = UserUtil.getUserOrgs(loginName);
            sOrgs = StringUtil.oldReplace(sOrgs,",","|");
            
            String userId = u.getId().toString();
            
            String s = StringUtil.null2String(u.getAddress().getProvince());
            String logined = "1";
//            System.out.println("s>>>>>"+s);
            String isInc = s.indexOf("1")>-1?"true":"false";
            String isCuik = s.indexOf("2")>-1?"true":"false";
            value = sDate+","+logined+","+isInc+","+isCuik+","+userId+","+fullName+","+sOrgs+","+loginName;
//            setAttribute(loginName,value,session);
//            session.setAttribute(loginName,value);
    	}else{
    		 String[] s = value.split(",");
    		 int i = Integer.valueOf(s[1]).intValue()+1;
    		 value = s[0]+","+ i +","+ s[2]+","+ s[3]+","+ s[4]+","+ s[5]+","+ s[6]+","+ s[7];
//    		 setAttribute(loginName,value,session);
//    		 session.setAttribute(loginName,value);
    	}
    	
    	session.setAttribute(loginName,value);

        return value;
    }
//    public void setAttribute(String name,String value,HttpSession session){
//        session.setAttribute(name,value);
//      }
//      public String getAttribute(String name,HttpSession session){
//        return (String) session.getAttribute(name);
//      }
//    
    public  String getServiceDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }
    
    public static String SetDateFormat(String myDate,String strFormat) 
    {
    	if(myDate == null || myDate ==""||"0".equals(myDate)) return "";
    	
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        String sDate ="";
		try {
			Date d = convertStringToDate("yyyyMMdd",myDate);
			sDate = sdf.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return sDate;
    }
    public static String SetDateFormat2(String myDate,String strFormat) 
    {
    	if(myDate == null || myDate ==""||"0".equals(myDate)) return "";
    	
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        String sDate ="";
		try {
			Date d = convertStringToDate("yyyyMM",myDate);
			sDate = sdf.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return sDate;
    }
    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate)
      throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '"
                      + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }
    
    
    public static long getlongValueFromDateStr(String sd){
    	
    	if(!"0".equals(sd)){
			try {
				Date d = convertStringToDate("yyyy-MM-dd HH:mm:ss",sd);
				sd = String.valueOf(d.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	return Long.parseLong(sd);
    }

    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the current date
     * @throws ParseException
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }
    
    public static int getYear(){//获得年份
        GregorianCalendar g=new GregorianCalendar();
        return(int)g.get(Calendar.YEAR);
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }
    
    public static final boolean isDate(int dt) {
    	Date aDate = new Date();
    	boolean isDate = false;
		try {
			aDate = convertStringToDate("yyyyMMdd",String.valueOf(dt));
	    	String  date = getDateTime("yyyyMMdd",aDate);
	    	if (Integer.parseInt(date) == dt) isDate = true; 
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return isDate;
    }  
    
    public static final boolean isNotDate(int dt) {
    	boolean is = isDate(dt);
    	return !is;
    }
    
  
    public static final boolean isWeek(int dt) {
    	Calendar calendar = new GregorianCalendar();   
		Date date = new Date();
		try {
			date = convertStringToDate("yyyyMMdd",String.valueOf(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.setTime(date);  
	
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		if(week == 6 || week == 7) return true;
    	return false;
    } 
    
    
    
    public static final int getDaysOfYear(int dt) {
    	Calendar calendar = new GregorianCalendar();   
		Date date = new Date();
		try {
			date = convertStringToDate("yyyyMMdd",String.valueOf(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.setTime(date);  

    	return  calendar.get(Calendar.DAY_OF_YEAR);
    }   
      
    public static final int getDaysOfWeek(int dt) {
    	Calendar calendar = new GregorianCalendar();   
		Date date = new Date();
		try {
			date = convertStringToDate("yyyyMMdd",String.valueOf(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.setTime(date);  

    	return  calendar.get(Calendar.DAY_OF_WEEK);
    }      
    

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     * 
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }
    
    public static final String convertDateToString(String aMask,Date aDate) {
        return getDateTime("yyyyMMdd", aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * 
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate)
      throws ParseException {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate
                      + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(),
                                     pe.getErrorOffset());
                    
        }

        return aDate;
    }
    
    public static final String convertDateToString(String aMask,String strDate,int days) {
    	Date date = new Date();
    	try {
			date = convertStringToDate(aMask,strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Calendar calendar = new GregorianCalendar();   
    	calendar.setTime(date);
    	long timeinMill = calendar.getTimeInMillis()+days*3600*24*1000;
    	calendar.setTimeInMillis(timeinMill);
    	Date dt = calendar.getTime();
		return convertDateToString(aMask,dt);
//        return getDateTime(getDatePattern(), aDate);
    }

    
    public static String setNewDay(int year,int month,int day){
		String m = String.valueOf(month);
		String d =  String.valueOf(day + 1);
		if(m.length() == 1) m = "0" + m;
		if(d.length() == 1) d = "0" + d;
		return String.valueOf(year).concat(String.valueOf(m)).concat(String.valueOf(d));
	}
    
    
    public static String converTime(Integer s,int fmt){

	    String t ="00";
		if(s != null){
			if(!"0".equals(s.toString())){
	            if(fmt == 1){
	            	 t = String.valueOf(s.intValue()/3600);
	            }
	            if(fmt ==2){
	    	        int second = s.intValue()%3600;
	    	        int minute = second / 60;
	            	t = String.valueOf(minute);
	            }
	            if(fmt ==3){
	                int second = s.intValue()%3600;
	    	        second %= 60;
	            	t = String.valueOf(second);
	            }
	            if(t.length() == 1) t = "0"+t;
			}
		}
		
	    return t;
	}
    
    
    

    public static String getWeekByStrDate(String beginDate,String frm){
    	  Calendar c_begin = new GregorianCalendar();
	    	Date trialTime1 = new Date();
				try {
					trialTime1 = convertStringToDate(frm,beginDate.toString());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			
			 c_begin.setTime(trialTime1); //Calendar的月从0-11，所以4月是3.
			 int week = c_begin.get(Calendar.DAY_OF_WEEK);
			 return getWeekConvert(week);
    }
  
    public static String getWeekByStrDate2(String beginDate,String frm){
  	  Calendar c_begin = new GregorianCalendar();
	    	Date trialTime1 = new Date();
				try {
					trialTime1 = convertStringToDate(frm,beginDate.toString());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			
			 c_begin.setTime(trialTime1); //Calendar的月从0-11，所以4月是3.
			 int week = c_begin.get(Calendar.DAY_OF_WEEK);
			 return getWeekConvert2(week);
  }
    
    public static void getWeekDates(String beginDate,String endDate,String weekStr,List ls){
//    	      List ls = new ArrayList();
    	      
    	     Calendar c_begin = new GregorianCalendar();
    	     Calendar c_end = new GregorianCalendar();
//    	     DateFormatSymbols dfs = new DateFormatSymbols(); 
//    	     SimpleDateFormat dfs = new SimpleDateFormat("yyyyMMdd");
//    	     String[] weeks = dfs.getWeekdays();
//    	     String[] weeks2 = dfs.getShortWeekdays();
    	     
    	    	Date trialTime1 = new Date();
    	    	Date trialTime2 = new Date();
    			try {
    				trialTime1 = convertStringToDate("yyyyMMdd",beginDate.toString());
    		    	trialTime2 = convertStringToDate("yyyyMMdd",endDate.toString());
    			} catch (ParseException e1) {
    				e1.printStackTrace();
    			}
    	     
//       	     c_begin.set(2010, 3, 2); //Calendar的月从0-11，所以4月是3.
//    	     c_end.set(2010, 4, 20); //Calendar的月从0-11，所以5月是4. 
    	     c_begin.setTime(trialTime1); //Calendar的月从0-11，所以4月是3.
    	     c_end.setTime(trialTime2); //Calendar的月从0-11，所以5月是4.

    	     int count = 1;
    	     
    	     c_end.add(Calendar.DAY_OF_YEAR, 1);  //结束日期下滚一天是为了包含最后一天
    	     
    	     while(c_begin.before(c_end)){
    	    	  
    	    	 int week = c_begin.get(Calendar.DAY_OF_WEEK);
    	          
    	    	 Date date = c_begin.getTime();
    	    	 
//    	    	 System.out.println("第"+count+"周  日期："+new java.sql.Date(date.getTime())+", 星期：["+ week +"]"+weeks[c_begin.get(Calendar.DAY_OF_WEEK)]+", "+weeks2[c_begin.get(Calendar.DAY_OF_WEEK)]);

    	    	 if(weekStr.indexOf(""+week)>-1){
    	    		 Integer publishDate = new Integer(getDateTime("yyyyMMdd",date)); 
    	    		 ls.add(publishDate);
//    	    		 System.out.println("日期 2：" + publishDate);
    	    	 }

	    	      if(c_begin.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
	    	       count++;
	    	      }
	    	      c_begin.add(Calendar.DAY_OF_YEAR, 1);
    	     }
}
    
    public static List getDatesByStartEndDate(String beginDate,String endDate){
	      List ls = new ArrayList();
	      
	     Calendar c_begin = new GregorianCalendar();
	     Calendar c_end = new GregorianCalendar();
//	     DateFormatSymbols dfs = new DateFormatSymbols();  
//	     SimpleDateFormat dfs = new SimpleDateFormat("yyyyMMdd");
//	     String[] weeks = dfs.getWeekdays();
//	     String[] weeks2 = dfs.getShortWeekdays();
	     
	     
	    	Date trialTime1 = new Date();
	    	Date trialTime2 = new Date();
			try {
				trialTime1 = convertStringToDate("yyyyMMdd",beginDate.toString());
		    	trialTime2 = convertStringToDate("yyyyMMdd",endDate.toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	     
// 	     c_begin.set(2010, 3, 2); //Calendar的月从0-11，所以4月是3.
//	     c_end.set(2010, 4, 20); //Calendar的月从0-11，所以5月是4. 
	     c_begin.setTime(trialTime1); //Calendar的月从0-11，所以4月是3.
	     c_end.setTime(trialTime2); //Calendar的月从0-11，所以5月是4.

	     c_end.add(Calendar.DAY_OF_YEAR, 1);  //结束日期下滚一天是为了包含最后一天
	     
	     while(c_begin.before(c_end)){
	    	  
	    	 Date date = c_begin.getTime();

	    	 Integer publishDate = new Integer(getDateTime("yyyyMMdd",date)); 
	    		ls.add(publishDate);
  	    c_begin.add(Calendar.DAY_OF_YEAR, 1);

	     }
	     
	  	    
	  	    return ls;
}
    
    public static long dateDiff(String time1, String time2, String format){
    	  long quot = 0;
    	  SimpleDateFormat ft = new SimpleDateFormat(format);
    	  try {
    	   Date date1 = ft.parse(time1);
    	   Date date2 = ft.parse(time2);
    	   quot = date2.getTime() - date1.getTime();
    	   quot = quot / 1000 / 60 / 60 / 24;
    	  } catch (ParseException e) {
    	   e.printStackTrace();
    	  }
    	  return quot;
    	 } 
    
    
    
    
    
    
    
    
    
    public static String getWeekConvert(int week){
    	String weekStr = null;
		   switch(week){
				    case 1:
		 				weekStr = "星期日";
		 				break;
		   			case 2:
		   				weekStr = "星期一";
		   				break;
		   			case 3:
		   				weekStr = "星期二";
		   				break;
		   			case 4:
		   				weekStr = "星期三";
		   				break;
		   			case 5:
		   				weekStr = "星期四";
		   				break;
		   			case 6:
		   				weekStr = "星期五";
		   				break;
		   			case 7:
		   				weekStr = "星期六";
		   				break;
		   			}
		   return weekStr;
    }
    public static String getWeekConvert2(int week){
    	String weekStr = null;
		   switch(week){
				    case 1:
		 				weekStr = "日";
		 				break;
		   			case 2:
		   				weekStr = "一";
		   				break;
		   			case 3:
		   				weekStr = "二";
		   				break;
		   			case 4:
		   				weekStr = "三";
		   				break;
		   			case 5:
		   				weekStr = "四";
		   				break;
		   			case 6:
		   				weekStr = "五";
		   				break;
		   			case 7:
		   				weekStr = "六";
		   				break;
		   			}
		   return weekStr;
    }
	/**
	 * @return Returns the curServerDate.
	 */
	public String getCurServerDate() {
		return curServerDate;
	}
	/**
	 * @param curServerDate The curServerDate to set.
	 */
	public void setCurServerDate(String curServerDate) {
		this.curServerDate = curServerDate;
	}
	
	
	public static String formatTime(long ms) {//将毫秒数换算成x天x时x分x秒x毫秒
		return formatTime(ms,null);
	}
	
	public static String format2HourMiSe(long ms) {//将毫秒数换算成x天x时x分x秒x毫秒
		   int ss = 1000;
		   int mi = ss * 60;
		   int hh = mi * 60;

		   long hour = ms / hh;
		   long minute = (ms  - hour * hh) / mi;
		   long second = (ms - hour * hh - minute * mi) / ss;
		   long milliSecond = ms - hour * hh - minute * mi - second * ss;


		   String strHour = hour < 10 ? "0" + hour : "" + hour;
		   String strMinute = minute < 10 ? "0" + minute : "" + minute;
		   String strSecond = second < 10 ? "0" + second : "" + second;
		   String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		   
		   if(milliSecond >0){
			   return strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
		   }else{
			   return strHour + ":" + strMinute + ":" + strSecond;
		      }

		   
	} 
	
	public static String formatTime(long ms,String strFormat) {//将毫秒数换算成x天x时x分x秒x毫秒
		   int ss = 1000;
		   int mi = ss * 60;
		   int hh = mi * 60;
		   int dd = hh * 24;
		   
		   if(strFormat == null) strFormat ="d h:m:s S";

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
		   
		   StringBuffer sb  = new StringBuffer();
		   
		   if(strFormat.indexOf("d")>-1) sb.append(strDay);
		   
		   if(strFormat.indexOf("h")>-1){
			   sb.append(" ");
			   sb.append(strHour);
		        }
		   
		   if(strFormat.indexOf("m")>-1){
			   if(strFormat.indexOf("h")>-1){
					   sb.append(":");
			        }

			   sb.append(strMinute);
		   }
		   if(strFormat.indexOf("s")>-1){
			   if(strFormat.indexOf("m")>-1){
					   if(strFormat.indexOf("\'")>-1){
						   sb.append("\'");
					   }else{
						   sb.append(":");
					   	    }		
			   		}

			   sb.append(strSecond);
			   
			   if(strFormat.indexOf("\"")>-1){
				   sb.append("\"");
			   		}		   
			   
		   }
		   

		 
		   
		   if(strFormat.indexOf("S")>-1){
			   
			   sb.append(" ");
			   
			   sb.append(strMilliSecond);
		   }
		   
		   return sb.toString();
//		   return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
		}
	
	
	 public static String formatLongToTimeStr(Long l) {
	        String str = "";
	        long day = 0;
	        long hour = 0;
	        long minute = 0;
	        long second = 0;

	        second = l.longValue() / 1000;

	        if (second >= 60) {
	            minute = second / 60;
	            second = second % 60;
	        }
	        if (minute >= 60) {
	            hour = minute / 60;
	            minute = minute % 60;
	        }
//	        if (hour > 24) {
//	        	day = hour / 24;
//	        	hour = hour % 24;
//	        }	    
	        
	        
	        String shour = hour < 10 ? "0" + hour : "" + hour;
	        String sminute = minute < 10 ? "0" + minute : "" + minute;
	        String ssecond = second < 10 ? "0" + second : "" + second;
	        
//	        str=  hour + ":" + minute  + ":" + second ;
	        str=  shour + ":" + sminute  + ":" + ssecond ;
	        
//	        if(day>0){
//	        	str =  day + "天" +hour + "小时" + minute  + "分" + second + "秒";
//	        }else if(hour >0){
//	        	str=  hour + "小时" + minute  + "分" + second + "秒";
//	        }else if(minute >0){
//	        	str =  minute  + "分" + second + "秒";
//	        }else{
//	        	str =  second + "秒";
//	        }
             
	        return str;
	    }
	 
	 public static String formatLongToTimeStr2(Long l) {
	        String str = "";
	        long day = 0;
	        long hour = 0;
	        long minute = 0;
	        long second = 0;

	        second = l.longValue() / 1000;

	        if (second > 60) {
	            minute = second / 60;
	            second = second % 60;
	        }
	        if (minute > 60) {
	            hour = minute / 60;
	            minute = minute % 60;
	        }

	        str=  hour + "小时" + minute  + "分" + second + "秒";
	        

	        return str;
	    }

    public String getSelectedDate(int days) {
    	Calendar calendar = new GregorianCalendar();
    	double ss=(double)3600*24*1000*days;
    	double timeinMill = (calendar.getTimeInMillis()+ss);
    	calendar.setTimeInMillis(new Double(timeinMill).longValue());
    	Date dt = calendar.getTime();
		return convertDateToString("",dt);
    }
    
    
    public static Map getServiceDateMap() {

       Map serviceDateMap = new HashMap(); 
       
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       String serviceDate = sdf.format(new Date());
       SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
       String serviceDate2 = sdf2.format(new Date());
       SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
       String serviceDate3 = sdf3.format(new Date());
       
//       SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-01-01");
//       String serviceDate4 = sdf3.format(new Date());
//       
//       SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-12-31");
//       String serviceDate5 = sdf3.format(new Date());
//       
       String cur_year = serviceDate.substring(0,4);
       String cur_month = serviceDate.substring(4,6);
       String cur_day = serviceDate.substring(6,8);
	
       serviceDateMap.put("def",serviceDate);
       serviceDateMap.put("format1",serviceDate2);
       serviceDateMap.put("format2",serviceDate3);
       serviceDateMap.put("year",cur_year);
       serviceDateMap.put("month",cur_month);
       serviceDateMap.put("date",cur_day); 
       
       serviceDateMap.put("yearFirstDate",cur_year+"-01-01");
       serviceDateMap.put("yearLastDate",cur_year+"-12-31");
       
       String[] ss = getDefaultSingDate(cur_year, cur_month, cur_day);
       serviceDateMap.put("defStartDate",ss[0]);
       serviceDateMap.put("defEndDate",ss[1]);
       
       String adrmSysYearProgramList = SysParamUtil.getAdrmSysYearProgramList();
       System.out.println("adrmSysYearProgramList ****************8 999999999999  777777777777      >>>>>>>>>>>>>>>>>>" +adrmSysYearProgramList);
       serviceDateMap.put("adrmSysYear",adrmSysYearProgramList);
       
       
 
	   return serviceDateMap;
    }
    
    
   
    
    public static String[] getDefaultSingDate(String cur_year,String cur_month,String cur_day){
    	
    	String tvNameParam = SysParamUtil.getTvNameParam();

    	String[] ss = new String[2];
    	
    	int nextYear = Integer.parseInt(cur_year);
		int nextMonth = Integer.parseInt(cur_month);
		if("hbtv".equals(tvNameParam)){
			if(Integer.parseInt(cur_day) >24){
				nextMonth = nextMonth + 1;
			}
		}else{
			nextMonth = nextMonth + 2;
		}
		if(nextMonth >12){
			nextYear = nextYear+1;
			nextMonth = nextMonth-12;
		}
        

//    	System.out.println("tvNameParam 444444444>>>>ttttttttttttttttttttttttt>>>>   "+nextMonth);
    	
    	
		ss[0] = getFirstDate(cur_year,cur_month);
		ss[1] = getEndDate(String.valueOf(nextYear),String.valueOf(nextMonth));
		
//		System.out.println("tvNameParam 444444444>>>>ttttttttttttttttttttttttt>>>>   "+ss[0]);
//		System.out.println("tvNameParam 444444444>>>>ttttttttttttttttttttttttt>>>>   "+ss[1]);
		
    	return ss;
    }

    public static String getFirstDate(String year,String month){
    	month = month.length() > 1 ? month:"0"+month;
    	return year + month +"01";
    }
    public static String getEndDate(String year,String month){
//    	String mon = month;
    	int d = getActualMaximum(year, month);
    	month = month.length() > 1 ? month:"0"+month;
    	String day = String.valueOf(d);
    	day = day.length() > 1 ? day:"0"+day;
    	return year + month + day;
    }
    
    public static int getActualMinimum(String year,String month){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.MONTH, Integer.parseInt(month)-1);
        int begin=calendar.getActualMinimum(calendar.DAY_OF_MONTH);
        return begin;
    }
    public static int getActualMaximum(String year,String month){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.MONTH, Integer.parseInt(month)-1);
        int end=calendar.getActualMaximum(calendar.DAY_OF_MONTH);
        return end;
    }

    /**
     * 获取现在时间
     * 
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
  public static Date getNowDate() {
     Date currentTime = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     String dateString = formatter.format(currentTime);
     ParsePosition pos = new ParsePosition(8);
     Date currentTime_2 = formatter.parse(dateString, pos);
     return currentTime_2;
  }
  
  /**
   * 获取现在时间
   * 
   * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
   */
public static String getStringDate(Date dd) {

   Date currentTime = new Date();
   if(dd != null){currentTime = dd;}
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   String dateString = formatter.format(currentTime);
   return dateString;
}
	//
	//清空浏览器客户端的缓存
	//
//	public static void clearClientPageCache()
//	{
//		 WebContext context = WebContextFactory.get();  
//		 try {
//			context.getHttpServletResponse().flushBuffer();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 context.getHttpServletResponse().setHeader("Pragma","No-Cache");
//		 context.getHttpServletResponse().setHeader("Cache-Control","No-Cache");
//		 context.getHttpServletResponse().setDateHeader("Expires",0);     
//	}
}
