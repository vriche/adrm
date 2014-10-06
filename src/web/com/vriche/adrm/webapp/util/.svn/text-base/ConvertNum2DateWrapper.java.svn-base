package com.vriche.adrm.webapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;




public class ConvertNum2DateWrapper implements DisplaytagColumnDecorator {

	public final  Object decorate(Object arg0,PageContext arg1,MediaTypeEnum arg2) throws DecoratorException {
		Date date = new Date();
		try {
			
			if(arg0 != null){
				date = convertStringToDate("yyyyMMdd",arg0.toString());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String d ="";
		if(arg0 != null){
			d = getDate(date);
		}
		return d;

	}
	
	
	 public static final Date convertStringToDate(String aMask, String strDate)
	    throws ParseException {
	      SimpleDateFormat df = null;
	      Date date = null;
	      df = new SimpleDateFormat(aMask);

	      try {
	    	  if(strDate.equals("0")) strDate ="19000101";
	          date = df.parse(strDate);
	      } catch (ParseException pe) {
	          //log.error("ParseException: " + pe);
	          throw new ParseException(pe.getMessage(), pe.getErrorOffset());
	      }

	      return (date);
	  }	
	 
	    public static final String getDate(Date aDate) {
	        SimpleDateFormat df = null;
	        String returnValue = "";

	        if (aDate != null) {
	            df = new SimpleDateFormat("yyyy-MM-dd");
	            returnValue = df.format(aDate);
	        }
            if(returnValue.equals("1900-01-01")) returnValue ="";
	        return (returnValue);
	    }	 

}


