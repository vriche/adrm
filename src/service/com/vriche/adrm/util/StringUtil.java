package com.vriche.adrm.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.helpers.Transform;


/** 
 * String Utility Class This is used to encode passwords programmatically
 *
 * <p>
 * <a h
 * ref="StringUtil.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class StringUtil {
    //~ Static fields/initializers =============================================
 
    private final static Log log = LogFactory.getLog(StringUtil.class);
    //~ Methods ================================================================

    /**
     * Encode a string using algorithm specified in web.xml and return the
     * resulting encrypted password. If exception, the plain credentials
     * string is returned
     *
     * @param password Password or other credentials to use in authenticating
     *        this username
     * @param algorithm Algorithm used to do the digest
     *
     * @return encypted password based on the algorithm.
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();

        MessageDigest md = null;

        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            log.error("Exception: " + e);

            return password;
        }

        md.reset();

        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);

        // now calculate the hash
        byte[] encodedPassword = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }

        return buf.toString();
    }
    
    public static void printArray(Object[] objs) {
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<objs.length;i++){
    		String out = String.valueOf(objs[i]) +",";
    		sb.append(out);
    	}
    	
    	System.out.println("数组[" + sb.toString().substring(0,sb.toString().length()-1)  +"]");
    }
    

    /**
     * Encode a string using Base64 encoding. Used when storing passwords
     * as cookies.
     *
     * This is weak encoding in that anyone can use the decodeString
     * routine to reverse the encoding.
     *
     * @param str
     * @return String
     */
    public static String encodeString(String str)  {
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        return encoder.encodeBuffer(str.getBytes()).trim();
    }

    /**
     * Decode a string using Base64 encoding.
     *
     * @param str
     * @return String
     */
    public static String decodeString(String str) {
        sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
        try {
            return new String(dec.decodeBuffer(str));
        } catch (IOException io) {
        	throw new RuntimeException(io.getMessage(), io.getCause());
        }
    }
    
	/**
	 * 把NULL 类型转换成空字符串。
	 */
	public static String null2String(String s) {
		return s != null ? s : "";
	}
	
	public static String null2String(Long s) {
		return s != null ? s.toString() : "0";
	}
	
	public static String null2String(Integer s) {
		return s != null ? s.toString() : "0";
	}
	
	public static String null2String(Double s) {
		return s != null ? s.toString() : "0";
	}
	public static String null2String(Object obj) {
		return obj != null ? (String)obj : "";
	}
	
	
	public static String getNullValue(Object obj,String def) {
		try {
			String i = String.valueOf (obj);
//			i = i.equals("null")||i.equals("undefined")||i.equals("")?def:i;
			i = "null".equals(i)||"undefined".equals(i)||"".equals(i)?def:i;
			return i;
		} catch (Exception ex) {
			String j = def;
			return j;
		}
	}
	
	
	  public static String trim(String str) {
	        return str == null ? null : str.trim();
	    }
		/**
		 * 转换为Double类型
		 */
		public static Double toDouble(Object val){
			if (val == null){
				return 0D;
			}
			try {
				return Double.valueOf(trim(val.toString()));
			} catch (Exception e) {
				return 0D;
			}
		}
	
	public static double round1(double v, int scale) {
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
			}
	
			BigDecimal b = new BigDecimal(Double.toString(v));
			BigDecimal one = new BigDecimal("1");
			return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
		}


	
	public static String doubleFormat(Double s) {
//		Boolean.valueOf()java.lang.Boolean.valueOf()
		String u =(s == null)?"":String.valueOf(s.doubleValue());
	    if(u.indexOf(".")>-1){
	    	if(Double.parseDouble(u.substring(u.indexOf(".")+1,u.length()))==0){
	    		u = u.substring(0,u.indexOf("."));
	    	}	
	    }
	    return u;
	}
	
	public static String doubleFormat2(Double s) {
//		DecimalFormat formatter = new DecimalFormat("#,##0.###");
		DecimalFormat formatter = new DecimalFormat("##########0.##");
		s = (s == null)?new Double(0):s;
		String u = formatter.format(s.doubleValue());
		
//		Boolean.valueOf(($V{Variable_sumtimes}).intValue() ==Integer.valueOf($P{OrderSumTimes}).intValue() )

//		&& (Boolean.valueOf(($V{Variable_sumtimes}).intValue() == Integer.valueOf($P{OrderSumTimes}).intValue())).booleanValue()
		
		
		
//		System.out.println(">>>>>>>>>>"+ u); 24 31
//	    if(u.indexOf(".")>-1){
//	    	if(Double.parseDouble(u.substring(u.indexOf(".")+1,u.length()))==0){
//	    		u = u.substring(0,u.indexOf("."));
//	    	}
//	    	
//	    }
	    return u;
	}	
	
	

	public static String doubleFormat3(Double s) {
//		DecimalFormat formatter = new DecimalFormat("#,##0.###");
		DecimalFormat formatter = new DecimalFormat("###,###,###,##0.00");
		s = (s == null)?new Double(0):s;
		String u = formatter.format(s.doubleValue());
	    return u;
	}
	
	public static String doubleFormat4(Double s) {
//		DecimalFormat formatter = new DecimalFormat("#,##0.###");
		DecimalFormat formatter = new DecimalFormat("###,###,###,##0.##");
		s = (s == null)?new Double(0):s;
		String u = formatter.format(s.doubleValue());
	    return u;
	}
	
	
	public static String doubleFormat4(double s) {
	    return ""+Math.round(s);
	}
	
	
	
	
	public static String persentFormat(double s,double sum) {
//		DecimalFormat formatter = new DecimalFormat("#,##0.###");
		DecimalFormat formatter = new DecimalFormat("##0.##");
		
		double value=0;
		if(s==0 || sum==0){ 
			value=0.0;}
		else{
			value=(s/sum)*100;}
		String u = formatter.format(value);
		String usum = u + "%";
	    return usum;
	}
	
	public static String persentFormat2(double s,double sum) {
//		DecimalFormat formatter = new DecimalFormat("#,##0.###");
		DecimalFormat formatter = new DecimalFormat("##0");
		
		double value=0;
		if(s==0 || sum==0){ 
			value=0.0;}
		else{
			value=(s/sum)*100;}
		String u = formatter.format(value);
		String usum = u + "%";
	    return usum;
	}	
	
	
	
//	NumberFormat nf = NumberFormat.getPercentInstance();
	
	
	public static String doubleFormat33(String s) {
		s = (s == null||s.equals(""))?"0":s;
		DecimalFormat formatter = new DecimalFormat("##0.00");
	    return formatter.format(new Double(s).doubleValue());
	}
	
	public static String doubleFormat3(String s) {
		s = (s == null||s.equals(""))?"0":s;
		DecimalFormat formatter = new DecimalFormat("##0.###");
	    return formatter.format(new Double(s).doubleValue());
	}	
	
	public static String doubleFormat4(String s) {
		s = (s == null||s.equals(""))?"0":s;
		DecimalFormat formatter = new DecimalFormat("##0.###");
	    return formatter.format(new Double(s).doubleValue());
	}
	
	public static String doubleFormat(String s) {
		DecimalFormat formatter = new DecimalFormat("##0.###");
		String u =(s == null||s.equals("")||s=="")?"0":s;
		u = formatter.format(new Double(u).doubleValue());
	    if(u.equals("0")) u ="";
	    return u;
	}
	
	public static String doubleFormat5(String s,String format) {
		 DecimalFormat formatter = new DecimalFormat(format);
		String u =(s == null||s.equals("")||s=="")?"0":s;
		u = formatter.format(new Double(u).doubleValue());
	    if(u.equals("0")||".00".equals(u)) u ="";
	    return u;
	}
	
	
	
	public static String converNum2cnQuerter(String ms) {
		int m = Integer.parseInt(ms);
		String Querter = "";
		switch(m){
			case 1:
				Querter= "一季度";break;
			case 2:
				Querter= "二季度";break;
			case 3:
				Querter= "三季度";break;
			case 4:
				Querter= "四季度";break;
			default :
				Querter = "";
		}
	   
		return Querter;
	}	
	public static String converNum2cnMonth(String ms) {
		int m = Integer.parseInt(ms);
		String month = "";
		switch(m){
			case 1:
				month= "一月";break;
			case 2:
				month= "二月";break;
			case 3:
				month= "三月";break;
			case 4:
				month= "四月";break;
			case 5:
				month= "五月";break;
			case 6:
				month= "六月";break;
			case 7:
				month= "七月";break;
			case 8:
				month= "八月";break;
			case 9:
				month= "九月";break;
			case 10:
				month= "十月";break;
			case 11:
				month= "十一月";break;
			case 12:
				month= "十二月";break;
			default :
				month = "";
		}
	   
		return month;
	}	
	
	public static int convercnQuerter2Num(String ms) {
		ms = ms == null?"":ms;
		int month = 0;
		if(ms.equals("一季度")){
			month= 1;
		}else if(ms.equals("二季度")){
			month= 2;
		}else if(ms.equals("三季度")){
			month= 3;
		}else if(ms.equals("四季度")){
			month= 4;
		}else if(ms.equals("")){
			month= 0;
		}
		return month;
	}	
	
	public static int convercnMonth2Num(String ms) {
		ms = ms == null?"":ms;
		int month = 0;
		if(ms.equals("一月")){
			month= 1;
		}else if(ms.equals("二月")){
			month= 2;
		}else if(ms.equals("三月")){
			month= 2;
		}else if(ms.equals("四月")){
			month= 2;
		}else if(ms.equals("五月")){
			month= 2;
		}else if(ms.equals("六月")){
			month= 2;
		}else if(ms.equals("七月")){
			month= 2;
		}else if(ms.equals("八月")){
			month= 2;
		}else if(ms.equals("九月")){
			month= 2;
		}else if(ms.equals("十月")){
			month= 2;
		}else if(ms.equals("十一月")){
			month= 2;
		}else if(ms.equals("十二月")){
			month= 2;
		}else if(ms.equals("")){
			month= 0;
		}
		return month;
	}	
	
	public static String getFileName(String s) {
		  if(s == null) s = "";
		  String rep ="\n\r\t" +"/.*|/?\"\\";
		  String rt = String2kenizer(s,rep);
	      rt = oldReplace(rt, ":", "：");
	      rt = oldReplace(rt, "<", "〈");
	      rt = oldReplace(rt, ">", "〉");
		  return rt;
	}
	
	public static String getResourceName(String s) {
		  if(s == null) s = "";
		  String rep ="\n\r\t";
		  String rt = String2kenizer(s,rep);
	      rt = oldReplace(rt, ":", "：");
	      rt = oldReplace(rt, "<", "〈");
	      rt = oldReplace(rt, ">", "〉");
		  return rt;
	}
	
	public static String String2kenizer(String s,String rep) {
//		  String rep ="\n\r\t" +"/.*|/?\"\\";
		  StringBuffer   temp = new   StringBuffer();  ;
		  StringTokenizer   token = new   StringTokenizer(s,rep);
		  for(;token.hasMoreTokens();)   temp.append(token.nextToken());  
		  return temp.toString();
	}
	
	public static String String2kenizer(String s) {
		  String rep ="\n\r\t" +"/.*|/?\"\\";
		  StringBuffer   temp = new   StringBuffer();  ;
		  StringTokenizer   token = new   StringTokenizer(s,rep);
		  for(;token.hasMoreTokens();)   temp.append(token.nextToken());  
		  return temp.toString();
	}
	
	  /**
	  * If Java 1.4 is unavailable, the following technique may be used.
	  *
	  * @param aInput is the original String which may contain substring aOldPattern
	  * @param aOldPattern is the non-empty substring which is to be replaced
	  * @param aNewPattern is the replacement for aOldPattern
	  */
	  public static String oldReplace(
	    final String aInput,
	    final String aOldPattern,
	    final String aNewPattern
	  ){
	     if ( aOldPattern.equals("") ) {
	        throw new IllegalArgumentException("Old pattern must have content.");
	     }

	     final StringBuffer result = new StringBuffer();
	     //startIdx and idxOld delimit various chunks of aInput; these
	     //chunks always end where aOldPattern begins
	     int startIdx = 0;
	     int idxOld = 0;
	     while ((idxOld = aInput.indexOf(aOldPattern, startIdx)) >= 0) {
	       //grab a part of aInput which does not include aOldPattern
	       result.append( aInput.substring(startIdx, idxOld) );
	       //add aNewPattern to take place of aOldPattern
	       result.append( aNewPattern );

	       //reset the startIdx to just after the current match, to see
	       //if there are any further matches
	       startIdx = idxOld + aOldPattern.length();
	     }
	     //the final chunk will go to the end of aInput
	     result.append( aInput.substring(startIdx) );
	     return result.toString();
	  }
	  
	  
	  /**
	     * 判断输入的字符串是否包含GBK编码格式的字符。
	     * 在此方法中，首先将字符串以ISO-8859-1编码格式提取并转化为byte[]数组；
	     * 然后判断该数组中是否包含'?'（ASCII码值为63），如果有，则该字符串中包含GBK编码格式的字符。
	     * 当然，为了排除原字符串中的'?'的干扰，应首先将'?'替换掉。
	     * @param string String 字符串。
	     * @throws UnsupportedEncodingException 如果系统不支持ISO-8859-1编码格式，将抛出此异常。
	     * @return boolean 如果输入的字符串包含GBK编码格式的字符，则返回true；否则返回false。
	     * @see Transform#toGBK
	     * @see Transform#toISO_8859_1
	     */
	    public static boolean isGBK(String string)
	        throws java.io.UnsupportedEncodingException
	    {
	        byte[] bytes = string.replace('?','a').getBytes("ISO-8859-1");
	        for(int i=0;i<bytes.length;i++)
	        {
	            if(bytes[i]==63)
	            {
	                return true;
	            }
	        }

	        return false;
	    }
	    
	    /**
	     * 实现将字符串转换为GBK编码格式的字符串，并返回转换结果。
	     * 如果原始字符串为ISO-8859-1编码格式的字符串，则返回转化为GBK编码格式的字符串；
	     * 如果原始字符串本身即为GBK编码格式的字符串，则返回原字符串，即不进行编码格式的转换。
	     * 判断字符串是否为GBK编码格式的标准是判断该字符串中是否包含GBK编码格式的字符。
	     * @param string String 欲转换的字符串。
	     * @throws UnsupportedEncodingException 如果系统不支持ISO-8859-1或GBK编码格式，将抛出此异常。
	     * @return String 转换后的字符串。
	     * @see Transform#isGBK
	     * @see Transform#toISO_8859_1
	     */
	    public static String toGBK(String string)
	        throws java.io.UnsupportedEncodingException
	    {
	        if(string==null) return "";

	        if(!isGBK(string))
	        {
	            return new String(string.getBytes("ISO-8859-1"),"GBK");
	        }

	        return string;
	    }
	    
	 public static String toUTF_8(String string)
        throws java.io.UnsupportedEncodingException
    {
        if(string==null) return "";

        if(!isGBK(string))
        {
            return new String(string.getBytes("gbk"),"utf-8");
        }

        return string;
    }
	    
	    public static String second2HMS(int totallength)
	    {
	        String hms = "";
	        int hour = totallength / 3600;
	        int second = totallength % 3600;
	        int minute = second / 60;
	        second %= 60;
	        if(hour != 0)
	            if(hour > 0 && hour < 10)
	                hms = String.valueOf(String.valueOf((new StringBuffer("0")).append(String.valueOf(hour)).append("时")));
	            else
	                hms = String.valueOf(String.valueOf(String.valueOf(hour))).concat("时");
	        if(minute == 0)
	        {
	            if(hour > 0)
	                hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("00").append("分")));
	        } else
	        if(minute > 0 && minute < 10)
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("0").append(String.valueOf(minute)).append("分")));
	        else
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append(String.valueOf(minute)).append("分")));
	        if(second == 0)
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("00").append("秒")));
	        else
	        if(second > 0 && second < 10)
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("0").append(String.valueOf(second)).append("秒")));
	        else
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append(String.valueOf(second)).append("秒")));
	        if(hms.equals(""))
	            hms = "0";
	        return hms;
	    }	      
	    
	    
	    public static String second2HMS2(long ms,boolean sign) {//将毫秒数换算成x天x时x分x秒x毫秒
	           int ss = 1000;
	           int mi = ss * 60;
	           int hh = mi * 60;
	           int dd = hh * 24;
	 
	           long day = ms / dd;
	           long hour = (ms - day * dd) / hh;
	           long minute = (ms - day * dd - hour * hh) / mi;
	           long second = (ms - day * dd - hour * hh - minute * mi) / ss;
	           long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
	 
	           String strDay = day  < 10 ? "0"  +day : "" + day;
	           String strHour = hour  < 10 ? "0" + hour : ""  +hour;
	           String strMinute = minute  < 10 ? "0" + minute : ""  +minute;
	           String strSecond = second  < 10 ? "0" + second : ""  +second;
	           String strMilliSecond = milliSecond  < 10 ? "0"  +milliSecond : ""  +milliSecond;
	           strMilliSecond = milliSecond  < 100 ? "0"  +strMilliSecond : ""  +strMilliSecond;
	           if(strDay.equals("00")){
	        	   if(strMilliSecond.equals("000")){
	        		   strDay = strHour + ":"  +strMinute  +":"  +strSecond;
	        	   }else{
	        		   strDay = strHour + ":"  +strMinute  +":"  +strSecond  +" "  +strMilliSecond;
	        	   }
	        	  
	           }else{
	        	   if(strMilliSecond.equals("000")){
	        		   strDay = strDay + " "  +strHour + ":"  +strMinute  +":"  +strSecond;
	        	   }else{
	        		   strDay = strDay + " "  +strHour + ":"  +strMinute  +":"  +strSecond  +" "  +strMilliSecond;
	        	   }
	        	  
	           }
	           return strDay;
	        } 
	    
	    
	    public static String second2HMS3(long ms,boolean sign) {//将毫秒数换算成x时x分x秒x毫秒
	           int ss = 1000;
	           int mi = ss * 60;
	           int hh = mi * 60;
	           int dd = hh * 24;
	           
//	           取余数
//	           System.out.println("<<<<<<<ms1   <<<<<<<" +ms);
	           ms = ms%86400000;
//	           System.out.println("<<<<<<<ms2   <<<<<<<" +ms);
	 
	 
	           long day = ms / dd;
	           long hour = (ms - day * dd) / hh;
	           long minute = (ms - day * dd - hour * hh) / mi;
	           long second = (ms - day * dd - hour * hh - minute * mi) / ss;
	           long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
	 
	           String strDay = day  < 10 ? "0"  +day : "" + day;
	           String strHour = hour  < 10 ? "0" + hour : ""  +hour;
	           String strMinute = minute  < 10 ? "0" + minute : ""  +minute;
	           String strSecond = second  < 10 ? "0" + second : ""  +second;
	           String strMilliSecond = milliSecond  < 10 ? "0"  +milliSecond : ""  +milliSecond;
	           strMilliSecond = milliSecond  < 100 ? "0"  +strMilliSecond : ""  +strMilliSecond;
	           if(strDay.equals("00")){
	        	   if(strMilliSecond.equals("000")){
	        		   strDay = strHour + ":"  +strMinute  +":"  +strSecond;
	        	   }else{
	        		   strDay = strHour + ":"  +strMinute  +":"  +strSecond  +" "  +strMilliSecond;
	        	   }
	        	  
	           }else{
	        	   if(strMilliSecond.equals("000")){
	        		   strDay = strDay + " "  +strHour + ":"  +strMinute  +":"  +strSecond;
	        	   }else{
	        		   strDay = strDay + " "  +strHour + ":"  +strMinute  +":"  +strSecond  +" "  +strMilliSecond;
	        	   }
	        	  
	           }
	           return strDay;
	        }  
	    public static String second2HMS(int totallength, boolean sign)
	    {
	        String hms = "";
	        String sh = "";
	        String sm = "";
	        String ss = "";
	        if(sign)
	        {
	            sm = "'";
	            ss = "\"";
	            sh = ":";
	        } else
	        {
	            sh = "时";
	            sm = "分";
	            ss = "秒";
	        }
	        int hour = totallength / 3600;
	        int second = totallength % 3600;
	        int minute = second / 60;
	        second %= 60;
	        if(hour == 0)
	            hms = "00".concat(String.valueOf(String.valueOf(sh)));
	        else
	        if(hour > 0 && hour < 10)
	            hms = String.valueOf(String.valueOf((new StringBuffer("0")).append(String.valueOf(hour)).append(sh)));
	        else
	            hms = String.valueOf(String.valueOf(hour)) + String.valueOf(sh);
	        if(minute == 0)
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("00").append(sm)));
	        else
	        if(minute > 0 && minute < 10)
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("0").append(String.valueOf(minute)).append(sm)));
	        else
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append(String.valueOf(minute)).append(sm)));
	        if(second == 0)
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("00").append(ss)));
	        else
	        if(second > 0 && second < 10)
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append("0").append(String.valueOf(second)).append(ss)));
	        else
	            hms = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(hms)))).append(String.valueOf(second)).append(ss)));
	        if(hms.equals(""))
	            hms = "0";
	        return hms;
	    }
	    
	    
	    public static String getdeCoding(String str,String encode) {
	    	try {
				return new String(str.getBytes(getEncoding(str)), encode);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				return "";
			}
	    }
	    
	    
	    
	    /**
	     * 判断字符串的编码
	     *
	     * @param str
	     * @return
	     */
	    public static String getEncoding(String str) {
	        String encode = "GB2312";
	        try {
	            if (str.equals((new String(str.getBytes(encode), encode)).toUpperCase())) {
	                String s = encode;
	                return s;
	            }
	        } catch (Exception exception) {
	        }
	        encode = "ISO-8859-1";
	        try {
	        	if (str.equals((new String(str.getBytes(encode), encode)).toUpperCase())) {
	                String s1 = encode;
	                return s1;
	            }
	        } catch (Exception exception1) {
	        }
	        encode = "UTF-8";
	        try {
	        	if (str.equals((new String(str.getBytes(encode), encode)).toUpperCase())) {
	                String s2 = encode;
	                return s2;
	            }
	        } catch (Exception exception2) {
	        }
	        encode = "GBK";
	        try {
	        	if (str.equals((new String(str.getBytes(encode), encode)).toUpperCase())) {
	                String s3 = encode;
	                return s3;
	            }
	        } catch (Exception exception3) {
	        }
	        return "";
	    }
	    
	    
	    /**
	     * 判断字符串的编码
	     *
	     * @param str
	     * @return
	     */
	    public static String getURLDecoderStr(String parameter) {
	    	parameter = (parameter == null)?"":parameter;
	    	try {
				return URLDecoder.decode(parameter, "utf-8");
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			return "";
	    }
	    
	    
	
	    
	    
		 
//		获取参数
	public static String getParamFromUrl(String srcStr, String paramName) {
		String parameValue = "";
		String tempStr = "";

		int pos = srcStr.indexOf("?");
		String paramStr = srcStr.substring(pos + 1);
		String[] paramArr = paramStr.split("&");

		for (int i = 0; i < paramArr.length; i++) {
			tempStr = paramArr[i];
			pos = tempStr.indexOf("=");
			if (paramName.equals(tempStr.substring(0, pos))) {
				parameValue = tempStr.substring(pos + 1);
				break;
			}
		}

		return parameValue;
	}
		 
	 /* 
	   * 判断是否为整数  
	   * @param str 传入的字符串  
	   * @return 是整数返回true,否则返回false  
	 */   
	public static boolean isInteger(String str) {    
		     Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
		     return pattern.matcher(str).matches();    
		   }  	
	    /*  
	      * 判断是否为浮点数，包括double和float  
	      * @param str 传入的字符串  
	      * @return 是浮点数返回true,否则返回false  
	    */    
	      public static boolean isDouble(String str) {    
	        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");    
	        return pattern.matcher(str).matches();    
	      }  
	      
	  	public static void getCollectionFromList(List ls,Collection collection) { 
	  		Map mp = new HashMap();
	  		for(Iterator it = ls.iterator();it.hasNext();){
	  			String s = (String) it.next();
	  			mp.put(s,s);
	  		}
	  		CollectionUtils.addAll(collection,mp.keySet().iterator());
	  	}
	  	
//	  	public static void getCollectionFromList(List ls1,List ls2,Collection collection) { 
//	  		Map mp = new HashMap();
//	  		for(Iterator it = ls1.iterator();it.hasNext();){
//	  			String s = (String) it.next();
//	  			mp.put(s,s);
//	  		}
//	  		CollectionUtils.addAll(collection,mp.keySet().iterator());
//	  	}
	  	
	    public static Map convertQueryStringtoMap(String str) {
	        if (str == null) return null;
	        String keyvalues = getURLDecoderStr(str);
	        if (keyvalues == null || keyvalues.length() == 0) return null;
	        String[] keyvalueArray = keyvalues.split("&");
	        Map map = new HashMap();
	        
	        for(int i = 0 ;i<keyvalueArray.length;i++){
	        	String keyvalue = keyvalueArray[i];
	        	 String[] s = keyvalue.split("=");
		            if (s != null && s.length == 2){
			            map.put(s[0], s[1]);
		            }
	        }
	        
	        return map;
	} 	
	    
	    public static Map convertQueryStringtoMap(String str,String[] without) {
	        if (str == null) return null;
	        Map withoutMap = new HashMap();
	        for(int i = 0 ;i<without.length;i++){
	        	withoutMap.put(without[i],"");
	        }
	        
	        String keyvalues = getURLDecoderStr(str);
	        if (keyvalues == null || keyvalues.length() == 0) return null;
	        String[] keyvalueArray = keyvalues.split("&");
	        Map map = new HashMap();
	        
	        for(int i = 0 ;i<keyvalueArray.length;i++){
	        	String keyvalue = keyvalueArray[i];
	        	 String[] s = keyvalue.split("=");
		            if (s != null && s.length == 2 && !withoutMap.containsKey(s[0])){
			            map.put(s[0], s[1]);
		            }
	        }
	        
	        return map;
	} 		    
	    
    public static int randoms()    
	     {  
	             long seed=new Date().getTime();  
	             Random rnd = new Random();  
	             rnd.setSeed(seed);  
	             return rnd.nextInt();
//	             System.out.println(rnd.nextInt());  

	   }  
	    
	public static Map getQueryString2Map(String search) {
		   Map searchparms = new Hashtable();
		   StringTokenizer st1 = new StringTokenizer(search, "&");
		   while(st1.hasMoreTokens()){
		     StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "=");
		     searchparms.put(st2.nextToken(), st2.nextToken());
		     }
		   return searchparms;
	}		    
	    
	public  static String urlEncodeUTF8(String s) {
	
	            try {
					return URLEncoder.encode(s, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return s;

	    }
	  
	  public    static String map2QueryString(Map  map) {
	    	StringBuffer sb = new StringBuffer();
	        Iterator it =  map.entrySet().iterator();
	        int i =0;
	        while(it.hasNext()){
//	        	 System.out.println("6 0********************* entry.getKey() ******************  "+it.next());
	        	Map.Entry entry = (Map.Entry)it.next();
//	        	String value = (String)map.get(key);
//	        	 System.out.println("6 0********************* entry ******************  "+ entry);
	        	 if (sb.length() > 0) {
	        		  sb.append("&");
	        	 }
	        	
	        	 
		        	 sb.append(urlEncodeUTF8(entry.getKey().toString()));
		        	 sb.append("=");
		        	 if(entry.getValue() != null){
		        		 sb.append(urlEncodeUTF8(entry.getValue().toString()));  
	        	     }

	        	 
//	        	 System.out.println("6 0*********************entry.getKey() end******************  "+(i++)+"_"+entry.getValue());
	        	 
//	        	 System.out.println("6 0*********************entry.getKey()******************  "+ entry.getKey());
	        	 
	        }
	        
//	        System.out.println("6 0*********************entry.getKey() end******************  ");

	        return sb.toString();       
	    }	   
	  
	  
	  public    static String map3QueryString(Map  map) {
	    	StringBuffer sb = new StringBuffer();
	        Iterator it =  map.entrySet().iterator();
	        while(it.hasNext()){
	        	Map.Entry entry = (Map.Entry)it.next();
//	        	String value = (String)map.get(key);
	        	 if (sb.length() > 0) {
	        		  sb.append("&");
	        	 }
	        	 sb.append(entry.getKey().toString());
	        	 sb.append("=");
	        	 sb.append(entry.getValue().toString());
	        }

	        return sb.toString();       
	    }	   
	  	  
	  /**   
	     * 将Java-String对象转化为JSON对象   
	     * @param string 字符串对象   
	     * @return javascript string对象   
	     */    
	  public static String string2Json(String string) {     
		  StringBuffer  sbr = new StringBuffer();     
	        sbr.append("'");     
	        for (int i = 0, sz = string.length(); i < sz; i++) {     
	            char ch = string.charAt(i);     
	            // handle unicode     
	            if (ch > 0xfff) {     
	                sbr.append("\\u");     
	                sbr.append(hex(ch));     
	            } else if (ch > 0xff) {     
	                sbr.append("\\u0");     
	                sbr.append(hex(ch));     
	            } else if (ch > 0x7f) {     
	                sbr.append("\\u00");     
	                sbr.append(hex(ch));     
	            } else if (ch < 32) {     
	                switch (ch) {     
	                case '\b':     
	                    sbr.append('\\');     
	                    sbr.append('b');     
	                    break;     
	                case '\n':     
	                    sbr.append('\\');     
	                    sbr.append('n');     
	                    break;     
	                case '\t':     
	                    sbr.append('\\');     
	                    sbr.append('t');     
	                    break;     
	                case '\f':     
	                    sbr.append('\\');     
	                    sbr.append('f');     
	                    break;     
	                case '\r':     
	                    sbr.append('\\');     
	                    sbr.append('r');     
	                    break;     
	                default:     
	                    if (ch > 0xf) {     
	                        sbr.append("\\u00");     
	                        sbr.append(hex(ch));     
	                    } else {     
	                        sbr.append("\\u000");     
	                        sbr.append(hex(ch));     
	                    }     
	                    break;     
	                }     
	            } else {     
	                // line.     
	                switch (ch) {     
	                case '\'':     
	                    sbr.append('\\');     
	                    sbr.append('\'');     
	                    break;     
	                case '"':     
	                    sbr.append('\\');     
	                    sbr.append('"');     
	                    break;     
	                case '\\':     
	                    sbr.append('\\');     
	                    sbr.append('\\');     
	                    break;     
	                default:     
	                    sbr.append(ch);     
	                    break;     
	                }     
	            }     
	        }     
	        sbr.append("'");     
	        return sbr.toString();     
	    }     
	    
	  public static String hex(char ch) {     
	        return Integer.toHexString(ch).toUpperCase(Locale.ENGLISH);     
	    }     
	  
	  
	  
		public static String replace(String s, char oldSub, char newSub) {
			if (s == null) {
				return null;
			}

			return s.replace(oldSub, newSub);
		}

		public static String replace(String s, char oldSub, String newSub) {
			if ((s == null) || (newSub == null)) {
				return null;
			}

			// The number 5 is arbitrary and is used as extra padding to reduce
			// buffer expansion

			StringBuffer sb = new StringBuffer(s.length() + 5 * newSub.length());

			char[] charArray = s.toCharArray();
			
			for(int i = 0;i<charArray.length;i++){
				
				char c = charArray[i];
				if (c == oldSub) {
					sb.append(newSub);
				}
				else {
					sb.append(c);
				}
			}
			
			return sb.toString();
		}

		public static String replace(String s, String oldSub, String newSub) {
			if ((s == null) || (oldSub == null) || (newSub == null)) {
				return null;
			}

			int y = s.indexOf(oldSub);

			if (y >= 0) {

				// The number 5 is arbitrary and is used as extra padding to reduce
				// buffer expansion

				StringBuffer sb = new StringBuffer(
					s.length() + 5 * newSub.length());

				int length = oldSub.length();
				int x = 0;

				while (x <= y) {
					sb.append(s.substring(x, y));
					sb.append(newSub);

					x = y + length;
					y = s.indexOf(oldSub, x);
				}

				sb.append(s.substring(x));

				return sb.toString();
			}
			else {
				return s;
			}
		}

		public static String replace(String s, String[] oldSubs, String[] newSubs) {
			if ((s == null) || (oldSubs == null) || (newSubs == null)) {
				return null;
			}

			if (oldSubs.length != newSubs.length) {
				return s;
			}

			for (int i = 0; i < oldSubs.length; i++) {
				s = replace(s, oldSubs[i], newSubs[i]);
			}

			return s;
		}

		public static String replace(String s, String[] oldSubs, String[] newSubs, boolean exactMatch) {

			if ((s == null) || (oldSubs == null) || (newSubs == null)) {
				return null;
			}

			if (oldSubs.length != newSubs.length) {
				return s;
			}

			if (!exactMatch) {
				replace(s, oldSubs, newSubs);
			}
			else {
				for (int i = 0; i < oldSubs.length; i++) {
					s = s.replaceAll("\\b" + oldSubs[i] + "\\b" , newSubs[i]);
				}
			}

			return s;
		}	  
	  
		public static String reverse(String s) {
			if (s == null) {
				return null;
			}

			char[] c = s.toCharArray();
			char[] reverse = new char[c.length];

			for (int i = 0; i < c.length; i++) {
				reverse[i] = c[c.length - i - 1];
			}

			return new String(reverse);
		}	  
		
		
		public static int byteLength(String string){
			int count = 0;
			for(int i=0;i<string.length();i++){
				if(Integer.toHexString(string.charAt(i)).length()==4){
					count += 2;
				}else{
					count++;
				}
			}
			return count;
		}

		
//		public static String FormatString(String targetStr,int strLength){
//			   targetStr =  null2String(targetStr);
//			   int curLength = byteLength(targetStr);
//			   if(targetStr!=null && curLength>strLength){
//			     targetStr = targetStr.substring(0,strLength);
//			   }   
//			   String newString = "";
//			   int cutLength = strLength-targetStr.getBytes().length;
//			   for(int i=0;i<cutLength;i++)
////			    newString +="\b";
//			   newString +=" ";
//			   return targetStr+newString;  
//		}
		

//			public static String FormatString(String targetStr,int strLength){
//			   int curLength = targetStr.getBytes().length;
//			   if(targetStr!=null && curLength>strLength){
//			     targetStr = targetStr.substring(0,strLength);
//			   }   
//			   String newString = "";
//			   int cutLength = strLength-targetStr.getBytes().length;
//			   for(int i=0;i<cutLength;i++)
//			    newString +="A";
//			   return targetStr+newString;  
//			}

			 public static String truncateString(String str, int byteLength,
					   boolean isFillNeeded) {
					  try {
					   if (str.getBytes().length < byteLength) {
					    if (isFillNeeded) {
					     int spaceNeeded = byteLength - str.getBytes().length;
					     StringBuffer sb = new StringBuffer(byteLength);
					     sb.append(str);
					     for (int i = 0; i < spaceNeeded; i++) {
					      sb.append(" ");
					     }
					     return sb.toString();
					    } else {
					     return str;
					    }
					   } else {
					    while (str.getBytes().length > byteLength) {
					     str = str.substring(0, str.length() - 1);
					    }
					    StringBuffer sb = new StringBuffer(byteLength);
					    sb.append(str);
					    return sb.toString();
					   }
					  } catch (Exception e) {
					   e.printStackTrace();
					   return "";
					  }
					 }		
		
		
		public static String substring(String s,int num){
			int k=0;
			String temp="";
			for (int i = 0; i <s.length(); i++)
			{	
				byte[] b=(s.charAt(i)+"").getBytes();
				k=k+b.length;
				if(k>num)
				{
					break;
				}
				temp=temp+s.charAt(i);			
			}	
			return temp;
		}
		
		
		public static String omitString(String string,int length){
			return omitString(string, length,null);
		}
		
		public static String omitString(String string,int length,String replace){
			StringBuffer sb = new StringBuffer();
			
			if(byteLength(string)>length){
				int count = 0;
				for(int i=0;i<string.length();i++){
					char temp = string.charAt(i);
					if(Integer.toHexString(temp).length()==4){
						count += 2;
					}else{
						count++;
					}
					if(count<length-3){
						sb.append(temp);
					}
					if(count==length-3){
						sb.append(temp);
						break;
					}
					if(count>length-3){
						sb.append(" ");
						break;
					}
				}
//				sb.append("...");
			}else{
				sb.append(string);
			}
			
			
			String newString = "";
			String targetStr = sb.toString();
			
			if(replace != null){
				int cutLength = length-targetStr.getBytes().length;
				 
				for(int i=0;i<cutLength;i++)
					 newString += replace;
			}

			 return targetStr+newString;  
		}
		
		
		
		
		
		

		
		  //获取匹配区域
	    public static String getMatchContent(String sourceContent,String beginStr,String endStr)
	 {
	    	String matchContent="";
	        String regex=beginStr+".*?"+endStr;
	        //System.out.println(regex);
	        Pattern pt=Pattern.compile(regex);
	        Matcher mt=pt.matcher(sourceContent);
	        if(mt.find())
	        {
	            return matchContent = mt.group();
	        }
	        else return null;
	        
	  }
	    
	    public static String getMatchContent2(String sourceContent,String beginStr,String endStr)
		 {
		    	String matchContent=getMatchContent(sourceContent,beginStr,endStr);
		    	return  matchContent.substring(beginStr.length(),matchContent.length()-endStr.length());
		  }
	    
	    
	    public static void main(String[] args) {
            DecimalFormat df = new DecimalFormat();
            double data = 1234.56789;
            System.out.println("格式化之前的数字: " + data);
            String style = "0.0";//定义要显示的数字的格式
            df.applyPattern(style);// 将格式应用于格式化器
            System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
            style = "00000.000 kg";//在格式后添加诸如单位等字符
            df.applyPattern(style);
            System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
            // 模式中的"#"表示如果该位存在字符，则显示字符，如果不存在，则不显示。
            style = "##000.000 kg";
            df.applyPattern(style);
            System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
            // 模式中的"-"表示输出为负数，要放在最前面
            style = "-000.000";
            df.applyPattern(style);
            System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
            // 模式中的","在数字中添加逗号，方便读数字
            style = "-0,000.0#";
            df.applyPattern(style);
            System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
            // 模式中的"E"表示输出为指数，"E"之前的字符串是底数的格式，
            // "E"之后的是字符串是指数的格式
            style = "0.00E000";
            df.applyPattern(style);
            System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
            // 模式中的"%"表示乘以100并显示为百分数，要放在最后。
            style = "0.00%";
            df.applyPattern(style);
            System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
            // 模式中的"\u2030"表示乘以1000并显示为千分数，要放在最后。
            style = "0.00\u2030";
            //在构造函数中设置数字格式
            DecimalFormat df1 = new DecimalFormat(style);
            //df.applyPattern(style);
            System.out.println("采用style: " + style + "格式化之后: " + df1.format(data));
    }

	    /*这是一个静态函数，不用声明对象就可以用的，如你的类名为Test,在任何情况下都可以调用Test.isHave函数*/
	    public static boolean isHave(String[] strs,String s){
	     /*此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
	      * */
	     for(int i=0;i<strs.length;i++){
	      if(strs[i].indexOf(s)!=-1){//循环查找字符串数组中的每个字符串中是否包含所有查找的内容
	       return true;//查找到了就返回真，不在继续查询
	      }
	     }
	     return false;//没找到返回false
	    }
	    
	    //1 包含  2 不包含 3、追加  4 其它排除空的
		public static String selectStr(String a, String keynum,int model) {
			String[] aStrings = a.split(",");
			List ls = new ArrayList();
//			StringBuffer sBuffer = new StringBuffer();
			
			if (aStrings.length > 0) {
				for (int i = 0; i < aStrings.length; i++) {
                    
					if(model == 1 && a.indexOf(keynum) != -1 ){
						if (aStrings[i].equals(keynum) && !"".equals(aStrings[i])) {
							ls.add(aStrings[i]);
						}
					}else if(model == 2 && a.indexOf(keynum) != -1 ){
						if (!aStrings[i].equals(keynum)  && !"".equals(aStrings[i])) {
							ls.add(aStrings[i]);
						}
					}else if(model == 3){
						if (!"".equals(aStrings[i]) && !aStrings[i].equals(keynum)) {
							ls.add(aStrings[i]);
						}
					}else{
						if (!"".equals(aStrings[i])) {
							ls.add(aStrings[i]);
						}
					}

				}
			}
			
			 if(model == 3 && !ls.contains(keynum)) ls.add(keynum);
		
			 a = org.apache.commons.lang.StringUtils.join(ls.toArray(),",");
//			 System.out.println("selectStr>>>>>>>>>>>>>>>>>>>>>>>>>>>>a>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + a );
			return a;
		}
		
		
		public static boolean checkSpec(String source, String tag) {
			String[] aStrings = source.split(",");
			List ls = new ArrayList();
			for (int i = 0; i < aStrings.length; i++) {
				if (!"".equals(aStrings[i])) {
					ls.add(aStrings[i]);
				}
			}
			return false;
		}
		
		
		 /**
	     * 全角空格为12288，半角空格为32
	     * 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
	     * 
	     * 将字符串中的全角字符转为半角
	     * @param src 要转换的包含全角的任意字符串
	     * @return  转换之后的字符串
	     */
//	    public static String toSemiangle(String src) {
//	        char[] c = src.toCharArray();
//	        for (int index = 0; index < c.length; index++) {
//	            if (c[index] == 12288) {// 全角空格
//	                c[index] = (char) 32;
//	            } else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符
//	                c[index] = (char) (c[index] - 65248);
//	            }
//	        }
//	        return String.valueOf(c);
//	    }
		

//		 全角转半角
		 public static final String SBCchange(String QJstr)
		  {
		      String outStr="";
		      String Tstr="";
		      byte[] b=null;

		      for(int i=0;i<QJstr.length();i++)
		      {     
		       try
		       {
		        Tstr=QJstr.substring(i,i+1);
		        b=Tstr.getBytes("unicode");
		       }
		       catch(java.io.UnsupportedEncodingException e)
		       {
		        e.printStackTrace();
		       }     
		    
		       if (b[3]==-1)
		       {
		        b[2]=(byte)(b[2]+32);
		        b[3]=0;      
		         
		        try
		        {       
		         outStr=outStr+new String(b,"unicode");
		        }
		        catch(java.io.UnsupportedEncodingException e)
		        {
		         e.printStackTrace();
		        }      
		       }else outStr=outStr+Tstr;
		      }
		     
		      return outStr; 
		   }	
//		 半角转全角
		 public static final String BQchange(String QJstr) {
			 String outStr = "";
			 String Tstr = "";
			 byte[] b = null;
	
			 for (int i = 0; i< QJstr.length(); i++) {
			 try {
			 Tstr = QJstr.substring(i, i + 1);
			 b = Tstr.getBytes("unicode");
			 } catch (java.io.UnsupportedEncodingException e) {
			 e.printStackTrace();
			 }
			 if (b[3] != -1) {
			 b[2] = (byte) (b[2] - 32);
			 b[3] = -1;
			 try {
			 outStr = outStr + new String(b, "unicode");
			 } catch (java.io.UnsupportedEncodingException e) {
			 e.printStackTrace();
			 }
			 } else
			 outStr = outStr + Tstr;
			 }
			 return outStr;
		 }	
		 
		 public   static   final String StringFilter(String    str)   throws    PatternSyntaxException    {     
	            // 只允许字母和数字       
	            // String    regEx   =   "[^a-zA-Z0-9]";                     
	           // 清除掉所有特殊字符  
			 String rep ="\n\r\t"; 
			 str = StringUtil.String2kenizer(str,rep);	
			 
	           String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？×《 》Ⅲ]";  
	           Pattern    p    =    Pattern.compile(regEx);     
	           Matcher    m    =    p.matcher(str);     
	          return    m.replaceAll("").trim();     
	 }
		 
		 
	public static String encodeStringXML(String strData){
		        if (strData == null){return ""; }
		        strData = replace(strData, "&", "&amp;");
		        strData = replace(strData, "<", "&lt;");
		        strData = replace(strData, ">", "&gt;");
		        strData = replace(strData, "'", "&apos;");
		        strData = replace(strData, "\"", "&quot;");
		        return strData;
	}


	
		     /**

		     * 还原字符串中特殊字符

		     */

		    public static String decodeStringXML(String strData){
		        strData = replace(strData, "&lt;", "<");
		        strData = replace(strData, "&gt;", ">");
		        strData = replace(strData, "&apos;", "'");
		        strData = replace(strData, "&quot;", "\"");
		        strData = replace(strData, "&amp;", "&");
		        return strData;
		    }
}
