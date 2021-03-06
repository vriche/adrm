/****************************************************************************     
 * Created on 2007-7-15                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.DayInfoArray;
import com.vriche.adrm.model.ResourceColor;

public class ResDayUtil {
	
	public static Map assemblyByList(String[] ids,List resList,Map usedTimeChangeMap,Map curSpecificMap){
		Map resMap = new HashMap();
		for(int i = 0; i< ids.length; i++){
			Map daysMap = getDaysMap(ids[i],resList,usedTimeChangeMap,curSpecificMap);
//			System.out.println("^^^^^^^^^^^^^" + daysMap.size());
			resMap.put(new Long(ids[i]),daysMap);
		}
		   
//		   Map mp = ConvertUtil.convertListToMap(resList,"publishDate");
		return resMap;
	}
	
	
	private static Map getDaysMap(String key,List resList,Map usedTimeChangeMap,Map curSpecificMap){
		Map daysMap = new HashMap();
		for(Iterator it = resList.iterator(); it.hasNext();){
			DayInfo dayInfo = (DayInfo) it.next();
			
			
			Integer publishDate = dayInfo.getPublishDate();
			Long resourceId = dayInfo.getResourceId();
			Long keyValue = (new Long(key));
			
//			System.out.println("^^^^^^^^^^^^^" + (keyValue == resourceId));
//			System.out.println("^^^^^^^^keyValue^^^^^" + keyValue);
//			System.out.println("^^^^^^^^resourceId^^^^^" + resourceId);
			if(keyValue.equals(resourceId)){
				
				String resUsed = dayInfo.getUsed();
				String resTotal = dayInfo.getTotal();
//				String resSpecific = dayInfo.getSpecific();
				
				String used = getResUsed(publishDate,resTotal,resUsed,usedTimeChangeMap);
//				String specific = getResSpecific(publishDate,resSpecific,curSpecificMap);
				dayInfo.setUsed(used);
//				dayInfo.setSpecific(specific);
				
				daysMap.put(publishDate,dayInfo);
			}
		}
	
		return daysMap;
	}
	
	private static String getResUsed(Integer publishDate, String resTotal,String resUsed,Map usedTimeChangeMap){
		int used = StringUtils.isNotEmpty(resUsed) && resUsed != null && resUsed != "" ? Integer.parseInt(resUsed):0;
		int total = StringUtils.isNotEmpty(resTotal) && resTotal != null  && resTotal != "" ? Integer.parseInt(resTotal):0;
		Object obj = usedTimeChangeMap.get(publishDate);
		int change = obj != null?((Double)obj).intValue():0;
//		System.out.println("bbbbbbbbbbb"+"\n" + total +"\n" +publishDate +"\n" +used +"\n" + change);
		if(total > 0){			
			used = used + change;
		}else{
			used = used - change;
		}
		
		return String.valueOf(used);
	}	
	
	
	private static String getResSpecific(Integer publishDate, String resSpecific,Map curSpecificMap){
		
		return null;
	}
	
	
	public static String getDayColor(DayInfo resDayInfo, String curSpecific,DayInfoArray dayInfoArray,boolean isCompages,boolean displayOverDate){
//        log.info("resDayInfo" + resDayInfo);

//        String t = resDayInfo.getTotal(); if(t == null || t == "" || StringUtils.isEmpty(t)) t = "0";
//        boolean isCompages = dayInfoArray.getIsCompages() != null? dayInfoArray.getIsCompages().booleanValue():false;
        String t = StringUtils.isEmpty(resDayInfo.getTotal())? "0":resDayInfo.getTotal();
        String u = StringUtils.isEmpty(resDayInfo.getUsed())? "0":resDayInfo.getUsed();
		double total = Double.parseDouble(t);
//		int releave = total - Integer.parseInt(resDayInfo.getUsed());
		double releave = total > 0 ? total - Double.parseDouble(u):total + Double.parseDouble(u);
       
//	      播出单已出，锁定
	   Boolean isLocked = resDayInfo.getIsLocked();
	   isLocked = isLocked == null?new Boolean(false):isLocked;
	   boolean isOutLimitBroarrangParam = SysParamUtil.getOutLimitBroarrangParam();
		 
		 
		 
		 
		 
//		int releave = total - Integer.parseInt(u);
		int d = resDayInfo.getPublishDate().intValue();
		int today = Integer.parseInt(DateUtil.getDateTime("yyyyMMdd",new Date()));
		int curYear = DateUtil.getYear();
		int resYear = Integer.parseInt(String.valueOf(d).substring(0,4));
		
//		displayOverDate = resYear >= curYear ;
		
		
//		String rsSpecific  = resDayInfo.getSpecific();
//		System.out.println(">>>>>>>>>>>curYear>>>>>>>>>>d>>>>>>>>>>>>>>" +curYear);
//		System.out.println(">>>>>>>>>>>resYear>>>>>>>>>>d>>>>>>>>>>>>>>" +resYear);
		
//		String rsSpecific = StringUtils.isEmpty(resDayInfo.getSpecific())? "":resDayInfo.getSpecific();
		String spec_res = StringUtil.getNullValue(resDayInfo.getSpecific(),"");
		String[] spec_res_array = spec_res.split(","); 
		
//		if(d == 20120226 ||d == 20120227 ){
//		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>d>>>>>>>>>>>>>>" +d);
//		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>curSpecific>>>>>>>>>>>>>>" +curSpecific);
//		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>rsSpecific>>>>>>>>>>>>>>" +rsSpecific);
//		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>StringUtils.contains(rsSpecific.toLowerCase(),curSpecific.toLowerCase())>>>>>>>>>>>>>>" +StringUtils.contains(rsSpecific.toLowerCase(),curSpecific.toLowerCase()));
//	    }
		 
//		if (StringUtils.isEmpty(ObjectUtils.toString(rsSpecific))) rsSpecific = "";
		
		//默认为白色
		String displayClor = ResourceColor.NORMAL;
		
		if(DateUtil.isWeek(d-1)) displayClor = ResourceColor.IS_WEEKEND;
		
//		System.out.println("displayOverDateXXXXXXXXXXXXXXXXXXXXXX    XXXXXXXXXXXXXXXXXXXX >>>>>>" + displayOverDate);
		
//		if(!isCompages && (d >= today ||displayOverDate)){
//		if(displayOverDate){
			//超时
			if(releave == 0) displayClor = ResourceColor.FULL_TIME;	
			//超时
			if(releave < 0) displayClor = ResourceColor.OVER_TIME;	
			//有指定
	        if (StringUtils.isNotEmpty(ObjectUtils.toString(curSpecific))){
//       		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>curSpecific>>>>>>>>>>>>>>" +curSpecific);
//    		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>rsSpecific>>>>>>>>>>>>>>" +rsSpecific);
	        	 boolean inStr =  StringUtilsv.ByForLoop(spec_res_array,curSpecific.toLowerCase());
	        	if(inStr) { 
//	            if(StringUtils.contains(rsSpecific.toLowerCase(),curSpecific.toLowerCase())) {
//	            	 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>d>>>>>>>>>>>>>>" +d);
//	        		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>curSpecific>>>>>>>>>>>>>>" +curSpecific);
//	        		 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>rsSpecific>>>>>>>>>>>>>>" +rsSpecific);
//	            	 System.out.println(">>>>>>>>>>>1122>>>>>>>>>>StringUtils.contains(rsSpecific.toLowerCase(),curSpecific.toLowerCase())>>>>>>>>>>>>>>" +StringUtils.contains(rsSpecific.toLowerCase(),curSpecific.toLowerCase()));

	            	displayClor = ResourceColor.SPECIFIC_TIME;
//	            	dayInfoArray.setDisabled(Boolean.valueOf(true));
	            	dayInfoArray.setIsResSpecificed(Boolean.valueOf(true));
	            }else{
	            	dayInfoArray.setIsResSpecificed(Boolean.valueOf(false));
	            }
	            dayInfoArray.setCurSpecificed(Boolean.valueOf(true));
	           
	        }
//		}
		
		//没有广告时间
		if(total == 0) displayClor = ResourceColor.NO_TIME;
		
		 //过期
//		if(!displayOverDate){
//			if(d < today) displayClor = ResourceColor.FORE_TIME;
//		}
		
//		if(displayOverDate){
//			if(displayOverDate && d < today) displayClor = ResourceColor.FORE_TIME;
//		}		
		 
//	      播出单已出，锁定
//	   if(isOutLimitBroarrangParam){
		   if(isLocked){
			   displayClor = ResourceColor.FORE_TIME;
		   }
//	   }else{
//		   //过期
//			if(displayOverDate){
//				if(displayOverDate && d < today) displayClor = ResourceColor.FORE_TIME;
//			}	
//	   }
	        
	        
		
		
		//无效日期
		if(DateUtil.isNotDate(d)){
			displayClor = ResourceColor.IS_NOT_DATE;
			dayInfoArray.setDisabled(Boolean.valueOf(true));
		}
		
		
    
		return displayClor;
    }	
	
	
	
	
//	public static Map assemblyByList(List resList){
//		
//	}
}
