package com.vriche.adrm.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Price;
import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.Workspan;

public class ResourceUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List  getAllCarrierTypesFromMap() {
		return (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIERTYPE);
	}		
	
	
	
	public static Map  getCarriersByTypeFromMap() {
		return (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIERS_BY_CARRIER_TYPE);
	}	
	
	
	public static List  getCarriersByTypeByCarrierTypeId(Long carrierTypeId) {
		Map mp = getCarriersByTypeFromMap();
		return (List)mp.get(carrierTypeId);
	}	
	
	public static Map  getAllResMap() {
		return (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
	}	
	
	public static Map  putAllToMap(List ls) {
		Map mp = new HashMap();
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource res = (Resource)it.next();
			mp.put(res.getId(),res);
		}
		return mp;
	}	

	public static List oneCarrResListByCarrierId(Long carrId) {
		Map resourceMap = getAllResMap();
		List oneCarrResList = (List)resourceMap.get(carrId);
		return oneCarrResList;
	}	
	
	public static List oneCarrResListByMapCarrierId(Map mp,Long carrId) {
		List oneCarrResList = (List)mp.get(carrId);
		return oneCarrResList;
	}	
	
	public static List getAllResourceFromMap() {
		Map resourceMap = getAllResMap();
		List allList= new ArrayList();
		while(resourceMap.values().iterator().hasNext()){
			List oneCarrResList = (List)resourceMap.values().iterator().next();
			CollectionUtils.addAll(allList,oneCarrResList.iterator());
		}
		return allList;
	}	
	
	public static List getResourceFromMapByIds(String[] resourceIds) {
		List ls = new ArrayList();
		Map mp=  putAllToMap(getAllResourceFromMap());
		for(int i = 0;i<resourceIds.length;i++){
			ls.add(mp.get(resourceIds[i]));
		}
		return ls;
	}	
	

	public static Resource getResourceByIdFromMap(Resource res) {
		List resourceList = getAllResourceFromMap();
//		System.out.println(">>>>>>>>>>>>>>>>" + resourceList.size());
	    Long id = res.getId();
	    Iterator it = resourceList.iterator();
	    Resource resourceObj = new Resource();
	    while(it.hasNext()){
	    	Resource resource =(Resource) it.next();
	    	if(resource.getId().equals(id)){
	    		resourceObj = resource;
	    		break;
	    	}

	    }
		return resourceObj;
	
	}
	
	
	public static Carrier getCarrierByIdFromMap(Long id) {
		List carrs = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
		Carrier carrier = new Carrier();
		for(Iterator it = carrs.iterator();it.hasNext();){
			Carrier carr = (Carrier)it.next();
			if(carr.getId().longValue() == id.longValue()){
				carrier = carr;
				break;
			}
		}
			
		return carrier;
	}
	

	
	public static  String getResourceName(final Resource resource,int type){
		String lable = "";
		
		boolean withBroPoint = SysParamUtil.getwithBroPoint();
    	boolean withResourceSort= SysParamUtil.getWithResourceSort();
		boolean isMeno = SysParamUtil.getResourceDisplay();
		 
		int orgId = Integer.parseInt(StringUtil.getNullValue(resource.getOrgId(),"1"));
		
		
		int orgType = Integer.parseInt(SysParamUtil.getOrgTypeById(String.valueOf(orgId)));
//		System.out.println("orgType>>>>>>>>222222      666666666666666   777777777777>>>>>>>>" + orgType);
//		System.out.println("orgType>>>>>>>>222222      666666666666666   777777777777>>>>>>>>" + resource);
//		System.out.println("type>>>>>>>>222222      666666666666666   777777777777>>>>>>>>" + type);
    	if(resource !=null){
    		
    		String tvName = SysParamUtil.getTvNameParam();

    		String resourceType = StringUtil.getNullValue(resource.getResourceType(),"");
    		String resourceName = resource.getResourceName();
    		String memo = resource.getMemo();
    		
    		String broTime ="";
    		String broTimeStar = "";
    		String broTimeEnd = "";
    		if(withBroPoint){
        		Workspan workspan = resource.getWorkspan();
        		 broTime = workspan.getBroadcastTimeFormat();
        		 broTimeStar = workspan.getBroadcastTimeFormatStart();
        		 broTimeEnd = workspan.getBroadcastTimeFormatEnd();
    		}

//    		org.apache.commons.lang.StringUtils. 	
    		//订单时段
    		if(type == 1){
	        	if("hntv".equals(tvName)){
	        		 lable = memo +" "+ resourceName+ " ["  + broTime +"]";
//	      			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
//	      			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("sjz".equals(tvName)){
//	   	   			 lable = broTime+" ["+ resourceName+"]";
	   	   		     lable =  resourceName+ "["+ broTime+"]";
	   	   		}else if("xmtv".equals(tvName)){
	   	   			 if(orgType == 1){
	   	   				  lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
	   	   			 }else if(orgType == 2){
	   	   				 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   			 }else{
	   	   				 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   			 }
	   	   		
	   	   		}else if("catv".equals(tvName)){
//	   	   		     broTime = org.apache.commons.lang.StringUtils.upperCase(broTime);
//	   	   		     broTime = StringUtil.truncateString(broTime,18,true);
	   	   			 lable = broTime+"  "+ resourceName;
	   	   		}else if("hbtv".equals(tvName)){
	   	   			 lable = broTimeStar+" ["+ memo +" "+  resourceName+"]";
	   	   		}else{
//	   	   			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
	   	   			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   		}
	       		
	       		if(withResourceSort && !"".equals(resourceType)) lable = lable+ "||" +resourceType;
    		}
    		
    		if(type == 2){
	        	if("hntv".equals(tvName)){
	      			 lable =  memo+"["+ resourceName+"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  memo+"["+ resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
//	   	   			 lable =memo+" ["+ resourceName+"]";
	   	   			 lable =resourceName;
	   	   		}else if("xmtv".equals(tvName)){
	   	   			 if(orgType == 1){
	   	   				 lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
	   	   			 }
	   	   			 if(orgType == 2){
	   	   				 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   			 }
	   	   			
	   	   		}else if("hbtv".equals(tvName)){
	   	   			 lable = broTimeStar+" ["+ memo +" "+  resourceName+"]";
	   	   		}else if("catv".equals(tvName)){
	   	   			 lable = memo+" "+ resourceName+"";
	   	   		}else{
	   	   			lable = broTime+" ["+ resourceName+" "+  memo+"]";
	   	   		}
	       		
	       		if(withResourceSort && !"".equals(resourceType)) lable = lable+ "||" +resourceType;
    		}   		
    		
    		if(type == 3){
	        	if("hntv".equals(tvName)){
//	      			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
//	      			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	      			lable = memo +" "+ resourceName+ " ["  + broTime +"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("sjz".equals(tvName)){
	   	   			 lable = broTime+" ["+ resourceName+"]";
	   	   		}else if("xmtv".equals(tvName)){
	   	   		   if(orgType == 1){
	   	   			   lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
	   	   			} 
	   	   		   if(orgType == 2){
	   	   				lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   			}
	   	   			 
	   	   		}else if("hbtv".equals(tvName)){
	   	   			 lable = broTimeStar+" ["+ memo +" "+  resourceName+"]";
	   	   		}else if("catv".equals(tvName)){
	   	   			 lable = broTime+"  "+ resourceName;
	   	   		}else{
	   	   			lable = broTime+" ["+ resourceName+" "+  memo+"]";
	   	   		}
    		}  	
    		
    		
    		
    		
//    		统计分析
    		if(type == 4){
//    			 System.out.println("orgType>>>>>>>>33333      666666666666666            7777777777777777>>>>>>>>" + type);
    			
	        	if("hntv".equals(tvName)){
	      			 lable = " ["+ memo+" "+ resourceName+"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  "["+ memo+" "+ resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			 lable = " ["+ memo+" "+ resourceName+"]";
	   	   		}else if("sjz".equals(tvName)){
	   	   			 lable = " ["+ memo+" "+ resourceName+"]";
	   	   		}else if("xmtv".equals(tvName)){
		   	   		 if(orgType == 1){
		   	   			 lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
							   	   		 }
							   	   		 if(orgType == 2){
							   	   			 lable = broTime + " ["+ memo+" "+ resourceName+"]";
							   	   		 }		   	   		 

	   	   		}else if("catv".equals(tvName)){
	   	   			 lable = resourceName + " "+ broTime+"";
	   	   		 
	   	   		}else if("hbtv".equals(tvName)){
	   	   			 lable = broTimeStar+" ["+ memo +" "+  resourceName+"]";
	   	   		}else{
	   	   			lable = broTime+" ["+ resourceName+" "+  memo+"]";
	   	   		}
    		}  
    		

       		if(type == 5){
//       		  System.out.println("orgType>>>>>>>>33333      666666666666666            7777777777777777>>>>>>>>" + broTime);
       		    
	        	if("hntv".equals(tvName)){
	        		 lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
//	      			 lable = broTime+" ["+ lable +"]";
	      			 lable = lable+" ["+ broTime +"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
	   	   			lable = broTime+" ["+ lable +"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
	   	   			lable = broTime+" ["+ lable +"]";
	   	   		}else if("sjz".equals(tvName)){
	   	   			lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
	   	   			lable = broTime+" ["+ lable +"]";
	   	   		}else if("xmtv".equals(tvName)){
	   	   			lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
	   	   			
	   	   			if(orgType == 1){
	   	   				lable = broTimeStar  +" ["+ lable +"]";
	   	   			}
	   	   			if(orgType == 2){
	   	   				lable = broTime+" ["+ lable +"]";
	   	   			}   	   		
	   	   			
	   	   			
	   	   		}else if("catv".equals(tvName)){
	   	   			lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
	   	   			lable = broTime+" ["+ lable +"]";
	   	   		}else if("hbtv".equals(tvName)){
	   	   			lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
	   	   			lable = broTimeStar+" ["+ lable +"]";
	   	   		}else{
	   	   		     lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
	   	   			lable = broTime+" ["+ lable +"]";
	   	   		}        	
	        	
    		}  		
 
       		if(type == 6){
       			if("xmtv".equals(tvName)){
       				if(orgType == 1){
       					lable = broTimeStar+" ["+ resource.getResourceName().toString() +"]";
       				}
       				if(orgType == 2){
       					lable = broTime+" ["+ resource.getResourceName().toString() +"]";
       				}
       			}if("hbtv".equals(tvName)){
       				lable = broTime+" ["+ resource.getMemo().toString() +"]";
       			}else{
       			
       				lable = broTime+" ["+ resource.getResourceName().toString() +"]";
       			}
//	   	   		    lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
//	   	   			lable = broTime+" ["+ resource.getResourceName().toString() +"]";
    		}  	      		
       		if(type == 7){
       			if(orgType == 1){
       				lable = broTime;
       			}
       			if(orgType == 2){
       				lable =  memo+" "+ resourceName;
       			}
       		
    		}    
       		
       		
       			     //时段维护
       		if(type == 8){
       		
       				if("xmtv".equals(tvName)){
           				lable =  !isMeno?resource.getResourceName().toString():resource.getMemo().toString();
           				lable +=  isMeno?"["+resource.getResourceName().toString()+"]":"["+resource.getMemo().toString()+"]";
       				}else if("hntv".equals(tvName)||"hbtv".equals(tvName)){
       					lable = resource.getMemo().toString();
       				}else if("catv".equals(tvName)||"sjz".equals(tvName)){
       					lable = resource.getResourceName().toString();
       				}else{
           				lable =  isMeno?resource.getResourceName().toString():resource.getMemo().toString();
//           				lable +=  !isMeno?"["+resource.getResourceName().toString()+"]":"["+resource.getMemo().toString()+"]";
       				}

       
       		
    		}     		
       		

    	}
		return lable;
		
	}
	
	public static  String getResourceName2(final Resource resource,int type,String orgId){
		String lable = "";
		
		boolean withBroPoint = SysParamUtil.getwithBroPoint();
    	boolean withResourceSort= SysParamUtil.getWithResourceSort();
    	
    	
		int orgType = Integer.parseInt(SysParamUtil.getOrgTypeById(String.valueOf(orgId)));
		
    	if(resource !=null){
    		
    		String tvName = SysParamUtil.getTvNameParam();

    		String resourceType = StringUtil.getNullValue(resource.getResourceType(),"");
    		String resourceName = resource.getResourceName();
    		String memo = resource.getMemo();
    		
    		String broTime ="";
    		String broTimeStar = "";
    		String broTimeEnd = "";
    		if(withBroPoint){
        		Workspan workspan = resource.getWorkspan();
        		 broTime = workspan.getBroadcastTimeFormat();
        		 broTimeStar = workspan.getBroadcastTimeFormatStart();
        		 broTimeEnd = workspan.getBroadcastTimeFormatEnd();
    		}

//    		org.apache.commons.lang.StringUtils. 		
    		if(type == 1){
	        	if("hntv".equals(tvName)){
//	      			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
//	      			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	        		lable = broTimeStar+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			 lable = broTimeStar+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("sjz".equals(tvName)){
	   	   			 lable = broTimeStar+" ["+ resourceName+"]";
	   	   		}else if("hbtv".equals(tvName)){
	   	   			lable = broTimeStar+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("xmtv".equals(tvName)){
	   	   			if(orgType == 1){
	   	   				lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
		   	   		 }
	   	   			if(orgType == 2){
		   	   			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
		   	   		 }
	   	   			
	   	   		}else if("catv".equals(tvName)){
//	   	   		     broTime = org.apache.commons.lang.StringUtils.upperCase(broTime);
//	   	   		     broTime = StringUtil.truncateString(broTime,18,true);
	   	   			 lable = broTime+"  "+ resourceName;
	   	   		}else{
	   	   			 if(orgType == 1){
	   	   				 lable = broTimeStar +" ["+ resourceName+" "+  memo+"]";
	   	   			 } else if(orgType == 2){
	   	   				 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   			 }else{
	   	   				 lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
	   	   			 }
	   	   		
	   	   		}
	       		
	       		if(withResourceSort && !"".equals(resourceType)) lable = lable+ "||" +resourceType;
    		}
    		
    		if(type == 2){
	        	if("hntv".equals(tvName)){
	      			 lable =  memo+"["+ resourceName+"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  memo+"["+ resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
//	   	   			 lable =memo+" ["+ resourceName+"]";
	   	   			 lable =resourceName;
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  memo+"["+ resourceName+"]";
	   	   		}else if("hbtv".equals(tvName)){
	   	   			if(orgType == 1){
	   	   				lable = broTimeStar+" ["+ memo+" "+  resourceName+"]";
	   	   			 }
	   	   			if(orgType == 2){
	   	   				 lable =  broTime +" ["+ memo +" " +resourceName+"]";
	   	   			 }
	   	   			
	   	   		}else if("catv".equals(tvName)){
	   	   			 lable = memo+" "+ resourceName+"";
	   	   		}else{
	   	   			 lable =  memo+"["+ resourceName+"]";
	   	   		}
	       		
	       		if(withResourceSort && !"".equals(resourceType)) lable = lable+ "||" +resourceType;
    		}   		
    		
    		if(type == 3){
	        	if("hntv".equals(tvName)){
//	      			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
	      			 lable = memo +" "+ resourceName+ " ["  + broTime +"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			 lable =  memo+"["+ broTime+" "+ resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("hbtv".equals(tvName)){
	   	   			 lable = broTimeStar+" ["+ memo+" "+ resourceName+"]";
	   	   		}else if("sjz".equals(tvName)){
	   	   			 lable = broTime+" ["+ resourceName+"]";
	   	   		}else if("xmtv".equals(tvName)){
	   	   			 if(orgType == 1){
	   	   				 lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
	   	   			 }
	   	   			 if(orgType == 2){
	   	   				 lable = broTime+" ["+ memo+" "+ resourceName+"]";
	   	   			 }
	   	   			
	   	   		}else if("catv".equals(tvName)){
	   	   			 lable = broTime+"  "+ resourceName;
	   	   		}else{
	   	   			lable = broTimeStar+" ["+ resourceName+" "+  memo+"]";
	   	   		}

    		}  
    		
    		if(type == 4){
	        	if("hntv".equals(tvName)){
	        		lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("sjz".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("xmtv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("catv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else{
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}

    		}     
    		if(type == 5){
	        	if("hntv".equals(tvName)){
	        		lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("fztv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("qztv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("sjz".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("xmtv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("catv".equals(tvName)){
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}else if("hbtv".equals(tvName)){
	   	   			lable = memo;
	   	   		}else{
	   	   			lable =  memo+" ["+  resourceName+"]";
	   	   		}

    		}    
    	}
		return lable;
		
	}
	public static Resource getResourceByObj(Resource res) {
		ResourceDao resourceDao = ServiceLocator.getResourceDao();
		List resourceList = resourceDao.getResources(res);
		Resource resourceObj = new Resource();

	    Long id = res.getId();
	    Iterator it = resourceList.iterator();
	    while(it.hasNext()){
	    	Resource resource =(Resource) it.next();
	    	if(resource.getId().equals(id)){
	    		resourceObj = resource;
	    		break;
	    	}
	    }
		return resourceObj;
	
	}
	
	
	public static Resource getResourceById(Long id) {
		ResourceDao resourceDao = ServiceLocator.getResourceDao();
		return  resourceDao.getResource(id);
	}
	public static List getDayInfos(DayInfo dayInfo) {
		DayInfoDao dayInfoDao = ServiceLocator.getDayInfoDao();
		return  dayInfoDao.getDayInfos(dayInfo);
	}
	
	public static void updateDayInfos(Map newResMap) {
		
//		DayInfo[] dayInfos = new DayInfo[newResMap.size()];
//		Iterator it = newResMap.values().iterator();
//		int  i = 0;
//		while(it.hasNext()){
//			 DayInfo day = (DayInfo)it.next();
////			 long used = Long.parseLong(day.getUsed())+day.getChangedValue().longValue();
////			 day.setUsed(String.valueOf(used));
//			 dayInfos[i++] = day;
//			 System.out.println("saveResourceInfo getResourceId>>>>>>>>>>>>>>>>>>>>>>"+day.getResourceId());
//			 System.out.println("saveResourceInfo getPublishDate>>>>>>>>>>>>>>>>>>>>>>"+day.getPublishDate());
//			 System.out.println("saveResourceInfo getUsed>>>>>>>>>>>>>>>>>>>>>>"+day.getUsed());
//			 System.out.println("saveResourceInfo getChangedValue>>>>>>>>>>>>>>>>>>>>>>"+day.getChangedValue());
//			 System.out.println("saveResourceInfo xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>>>>>>>>>>>>>>>>>>>>>>");
//		 }		
//		
		DayInfoDao dayInfoDao = ServiceLocator.getDayInfoDao();
		dayInfoDao.saveDayInfo2(newResMap);
	}
	

	public static Map getDayInfosMap(DayInfo dayInfo) {
		Map mp = new HashMap();
		List ls = getDayInfos(dayInfo);
		Iterator it = ls.iterator();
		String key ="";

		while(it.hasNext()){
			DayInfo day = (DayInfo)it.next();
			String changeValue = StringUtil.getNullValue(day.getChangedValue(),"0");
			changeValue = "0.0".equals(changeValue)?"0":changeValue;
//			System.out.println("saveResourceInfo xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>>>>>>>>>>>>>>>>>>>>>>"+changeValue);
//			if(!"0".equals(changeValue) && !"0.0".equals(changeValue)){
				day.setChangedValue(new Double(changeValue));
	   			key = day.getResourceId().toString() +","+day.getPublishDate().toString();
//	   		   System.out.println("saveResourceInfo hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh>>>>>>>>>>>>>>>>>>>>>>"+changeValue);
	   			mp.put(key,day);
//			}

		}
		return  mp;
	}	
	

	
	public static void getADlengthFormWeek(Map resMap){
		Iterator it2 = resMap.keySet().iterator();
		while(it2.hasNext()){
			String key_workSpanId = (String)it2.next();
			FusionChartObject objectRes = (FusionChartObject)resMap.get(key_workSpanId);

		    int adTotalTimes = Integer.parseInt(StringUtil.getNullValue(objectRes.getValue6(),"0"));
		    	
		    if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(objectRes.getValue7(),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(objectRes.getValue8(),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(objectRes.getValue9(),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(objectRes.getValue10(),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(objectRes.getValue11(),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(objectRes.getValue5(),"0"));
		    	}

		    	objectRes.setValue36(String.valueOf(adTotalTimes));
		}	
    }

	
	public static  void getSumTotalUsedRateMap(Collection ls,Map sumTotalMap,Map sumUsedMap,Map rateMap,int displayModel,int seachType){

		Iterator it = ls.iterator();
		
		while(it.hasNext()){ 
			
			FusionChartObject objectDay = (FusionChartObject)it.next();
			String key_workSpanId = objectDay.getValue2();
			String total = StringUtil.getNullValue(objectDay.getValue4(),"0");
			String used = StringUtil.getNullValue(objectDay.getValue5(),"0");
			String leave =  String.valueOf(Double.valueOf(total).doubleValue() - Double.valueOf(used).doubleValue());
			if(seachType == 2) used = leave;
			
			if(!sumTotalMap.containsKey(key_workSpanId)){
				sumTotalMap.put(key_workSpanId,total);
			}else{
				String totalSum =(String)sumTotalMap.get(key_workSpanId);
				totalSum = String.valueOf(Double.valueOf(totalSum).doubleValue() + Double.valueOf(total).doubleValue());
				sumTotalMap.put(key_workSpanId,totalSum);
			}
			
			
			if(!sumUsedMap.containsKey(key_workSpanId)){
				sumUsedMap.put(key_workSpanId,used);
			}else{
				String usedSum =(String)sumUsedMap.get(key_workSpanId);
				usedSum = String.valueOf(Double.valueOf(usedSum).doubleValue() + Double.valueOf(used).doubleValue());
				sumUsedMap.put(key_workSpanId,usedSum);
			}		
		}
		

		
		
		Iterator it2 = sumTotalMap.keySet().iterator();
		while(it2.hasNext()){
			String key_workSpanId = (String)it2.next();
			String totalSum =(String)sumTotalMap.get(key_workSpanId);
			String usedSum =(String)sumUsedMap.get(key_workSpanId);
			if(Double.parseDouble(totalSum) == 0) totalSum ="1";
			String rate = String.valueOf((Double.valueOf(usedSum).doubleValue()/Double.valueOf(totalSum).doubleValue())*100);
			rate = StringUtil.doubleFormat2(new Double(rate));
			rateMap.put(key_workSpanId,rate+"%");
		}
		
		

			Iterator it3 = sumTotalMap.keySet().iterator();
			while(it3.hasNext()){
				String key = (String)it3.next();
				String sumTotal ="0";
				String sumUsed ="0";
	
				 sumTotal = (String)sumTotalMap.get(key);
				 sumUsed = (String)sumUsedMap.get(key);
					
				 
				 
				if(displayModel == 1){
					sumTotal =  DateUtil.formatTime(Math.round(Double.parseDouble(sumTotal)*1000),"h:m:s");
					sumUsed =  DateUtil.formatTime(Math.round(Double.parseDouble(sumUsed)*1000),"h:m:s");
					if(" 00:00:00".equals(sumTotal)) sumTotal = "";
					if(" 00:00:00".equals(sumUsed)){
						sumUsed = "";rateMap.put(key,"");
					}
				}	else{
						if("0.0".equals(sumTotal)||"0".equals(sumTotal)) sumTotal = "";
						if("0.0".equals(sumUsed)||"0".equals(sumUsed)){
							sumUsed = "";rateMap.put(key,"");
						}
				}
	
//				System.out.println("inWeekDatesList<<<<<<<<<!sumUsed+++++++++++++++++++<<<<<<<<<<"+sumUsed);
				
				sumTotalMap.put(key,sumTotal);
				sumUsedMap.put(key,sumUsed);
			}
	
		

	}

	
	public static  void setDayValue(String key,int i,long days,FusionChartObject objectDay,String used,Map sumTotalMap,Map sumUsedMap,Map rateMap){
		
//		System.out.println("inWeekDatesList<<<<<<<<<!days+++++++++++++++++++<<<<<<<<<<"+days);
		

		
		switch(i){
			case 3:
				objectDay.setValue3(used);
				if(days==0){
					objectDay.setValue4((String)sumUsedMap.get(key));
					objectDay.setValue5((String)rateMap.get(key));
				}

				break;
			case 4:
				objectDay.setValue4(used);
				if(days==0){
					objectDay.setValue5((String)sumUsedMap.get(key));
					objectDay.setValue6((String)rateMap.get(key));
				}

				break;
			case 5:
				objectDay.setValue5(used);
				if(days==0) {
					objectDay.setValue6((String)sumUsedMap.get(key));
					objectDay.setValue7((String)rateMap.get(key));
				}
	
				break;
			case 6:
				objectDay.setValue6(used);
				if(days==0){
					objectDay.setValue7((String)sumUsedMap.get(key));
					objectDay.setValue8((String)rateMap.get(key));
				}
		
				break;
			case 7:
				objectDay.setValue7(used);

				if(days==0){
					objectDay.setValue8((String)sumUsedMap.get(key));
					objectDay.setValue9((String)rateMap.get(key));
				}

				break;
			case 8:
				objectDay.setValue8(used);
				if(days==0){
					objectDay.setValue9((String)sumUsedMap.get(key));
					objectDay.setValue10((String)rateMap.get(key));
				}

				break;
				
			case 9:
				objectDay.setValue9(used);
				if(days==0){
					objectDay.setValue10((String)sumUsedMap.get(key));
					objectDay.setValue11((String)rateMap.get(key));
				}

				break;
				
			case 10:
				objectDay.setValue10(used);
				if(days==0){
					objectDay.setValue11((String)sumUsedMap.get(key));
					objectDay.setValue12((String)rateMap.get(key));
				}
				break;
				
			case 11:
				objectDay.setValue11(used);
				if(days==0){
					objectDay.setValue12((String)sumUsedMap.get(key));
					objectDay.setValue13((String)rateMap.get(key));
				}
				break;
			case 12:
				objectDay.setValue12(used);
				if(days==0){
					objectDay.setValue13((String)sumUsedMap.get(key));
					objectDay.setValue14((String)rateMap.get(key));
				}
				break;
				
			case 13:
				objectDay.setValue13(used);
				if(days==0){
					objectDay.setValue14((String)sumUsedMap.get(key));
					objectDay.setValue15((String)rateMap.get(key));
				}
				break;
			case 14:
				objectDay.setValue14(used);
				if(days==0){
					objectDay.setValue15((String)sumUsedMap.get(key));
					objectDay.setValue16((String)rateMap.get(key));
				}
				break;
			case 15:
				objectDay.setValue15(used);
				if(days==0){
					objectDay.setValue16((String)sumUsedMap.get(key));
					objectDay.setValue17((String)rateMap.get(key));
				}
				break;				
				
			case 16:
				objectDay.setValue16(used);
				if(days==0){
					objectDay.setValue17((String)sumUsedMap.get(key));
					objectDay.setValue18((String)rateMap.get(key));
				}
				break;							
			case 17:
				objectDay.setValue17(used);
				if(days==0){
					objectDay.setValue18((String)sumUsedMap.get(key));
					objectDay.setValue19((String)rateMap.get(key));
				}
				break;
			case 18:
				objectDay.setValue18(used);
				if(days==0){
					objectDay.setValue19((String)sumUsedMap.get(key));
					objectDay.setValue20((String)rateMap.get(key));
				}
				break;
				
			case 19:
				objectDay.setValue19(used);
				if(days==0){
					objectDay.setValue20((String)sumUsedMap.get(key));
					objectDay.setValue21((String)rateMap.get(key));
				}
				break;
			case 20:
				objectDay.setValue20(used);
				if(days==0){
					objectDay.setValue21((String)sumUsedMap.get(key));
					objectDay.setValue22((String)rateMap.get(key));
				}
				break;
				
			case 21:
				objectDay.setValue21(used);
				if(days==0){
					objectDay.setValue22((String)sumUsedMap.get(key));
					objectDay.setValue23((String)rateMap.get(key));
				}
				break;
			case 22:
				objectDay.setValue22(used);
				if(days==0){
					objectDay.setValue23((String)sumUsedMap.get(key));
					objectDay.setValue24((String)rateMap.get(key));
				}
				break;
				
			case 23:
				objectDay.setValue23(used);
				if(days==0){
					objectDay.setValue24((String)sumUsedMap.get(key));
					objectDay.setValue25((String)rateMap.get(key));
				}
				break;				
				
			case 24:
				objectDay.setValue24(used);
				if(days==0){
					objectDay.setValue25((String)sumUsedMap.get(key));
					objectDay.setValue26((String)rateMap.get(key));
				}
				break;		
			case 25:
				objectDay.setValue25(used);
				if(days==0){
					objectDay.setValue26((String)sumUsedMap.get(key));
					objectDay.setValue27((String)rateMap.get(key));
				}
				break;						
				
			case 26:
				objectDay.setValue26(used);
				if(days==0){
					objectDay.setValue27((String)sumUsedMap.get(key));
					objectDay.setValue28((String)rateMap.get(key));
				}
				break;					
			case 27:
				objectDay.setValue27(used);
				if(days==0){
					objectDay.setValue28((String)sumUsedMap.get(key));
					objectDay.setValue29((String)rateMap.get(key));
				}
				break;	
			case 28:
				objectDay.setValue28(used);
				if(days==0){
					objectDay.setValue29((String)sumUsedMap.get(key));
					objectDay.setValue30((String)rateMap.get(key));
				}
				break;					
			case 29:
				objectDay.setValue29(used);
				if(days==0){
					objectDay.setValue30((String)sumUsedMap.get(key));
					objectDay.setValue31((String)rateMap.get(key));
				}
				break;	
								
			case 30:
				objectDay.setValue30(used);
				if(days==0){
					objectDay.setValue31((String)sumUsedMap.get(key));
					objectDay.setValue32((String)rateMap.get(key));
				}
				break;					
			case 31:
				objectDay.setValue31(used);
				if(days==0){
					objectDay.setValue32((String)sumUsedMap.get(key));
					objectDay.setValue33((String)rateMap.get(key));
				}
				break;	
			case 32:
				objectDay.setValue32(used);
				if(days==0){
					objectDay.setValue33((String)sumUsedMap.get(key));
					objectDay.setValue34((String)rateMap.get(key));
				}
				break;					
			case 33:
				objectDay.setValue33(used);
				if(days==0){
					objectDay.setValue34((String)sumUsedMap.get(key));
					objectDay.setValue35((String)rateMap.get(key));
				}
				break;	
			case 34:
				objectDay.setValue34(used);
				if(days==0){
					objectDay.setValue35((String)sumUsedMap.get(key));
					objectDay.setValue36((String)rateMap.get(key));
				}
				break;	
			case 35:
				objectDay.setValue35(used);
				if(days==0){
					objectDay.setValue36((String)sumUsedMap.get(key));
					objectDay.setValue37((String)rateMap.get(key));
				}
				break;					
			case 36:
				objectDay.setValue36(used);
				if(days==0){
					objectDay.setValue37((String)sumUsedMap.get(key));
					objectDay.setValue38((String)rateMap.get(key));
				}
				break;											
				
		}
		
		
	}
	
	public static  void setDayValue2(FusionChartObject objectDay,int i,String used){
		
//		System.out.println("inWeekDatesList<<<<<<<<<!days+++++++++++++++++++<<<<<<<<<<"+days);
		

		
		switch(i){
			case 0:
				objectDay.setLable(used);
				break;
			case 1:
				objectDay.setValue1(used);
				break;
			case 2:
				objectDay.setValue2(used);
				break;
			case 3:
				objectDay.setValue3(used);
				break;
			case 4:
				objectDay.setValue4(used);

				break;
			case 5:
				objectDay.setValue5(used);
				break;
			case 6:
				objectDay.setValue6(used);
				break;
			case 7:
				objectDay.setValue7(used);
				break;
			case 8:
				objectDay.setValue8(used);
				break;
				
			case 9:
				objectDay.setValue9(used);
				break;	
			case 10:
				objectDay.setValue10(used);
				break;
				
			case 11:
				objectDay.setValue11(used);
				break;
			case 12:
				objectDay.setValue12(used);
				break;
			case 13:
				objectDay.setValue13(used);
				break;
			case 14:
				objectDay.setValue14(used);
				break;
			case 15:
				objectDay.setValue15(used);
				break;				
				
			case 16:
				objectDay.setValue16(used);
				break;							
			case 17:
				objectDay.setValue17(used);
				break;
			case 18:
				objectDay.setValue18(used);
				break;
				
			case 19:
				objectDay.setValue19(used);
				break;
			case 20:
				objectDay.setValue20(used);
				break;
			case 21:
				objectDay.setValue21(used);
				break;
			case 22:
				objectDay.setValue22(used);
				break;
				
			case 23:
				objectDay.setValue23(used);
				break;				
				
			case 24:
				objectDay.setValue24(used);
				break;		
			case 25:
				objectDay.setValue25(used);
				break;						
				
			case 26:
				objectDay.setValue26(used);
				break;					
			case 27:
				objectDay.setValue27(used);
				break;	
			case 28:
				objectDay.setValue28(used);
				break;					
			case 29:
				objectDay.setValue29(used);
				break;	
								
			case 30:
				objectDay.setValue30(used);
				break;					
			case 31:
				objectDay.setValue31(used);
				break;	
			case 32:
				objectDay.setValue32(used);
				break;					
			case 33:
				objectDay.setValue33(used);
				break;	
			case 34:
				objectDay.setValue34(used);
				break;	
			case 35:
				objectDay.setValue35(used);
				break;					
			case 36:
				objectDay.setValue36(used);
				break;											
				
		}
		
		
	}
	private static void  setUserData(StringBuffer sb,FusionChartObject obj,String[] values){
//		System.out.println(" makeXmlForResourcesForQuery<<<<<<<values.length+++++++++++++++++++<<<<<<<<<<"+values.length);
		
		if( values.length >2){
			String name = obj.getId() +"_"+ values[1];
			String name2 =name+"_used";
			String name3 =name+"_leave";
//			System.out.println(" makeXmlForResourcesForQuery<<<<<<<name+++++++++++++++++++<<<<<<<<<<"+name);
			sb.append("<userdata name=\""+ name +"\">"+  values[2] +"</userdata>");
			sb.append("<userdata name=\""+ name2 +"\">"+  values[3] +"</userdata>");
			sb.append("<userdata name=\""+ name3 +"\">"+  values[4] +"</userdata>");
		}

	}
	
	public static  String makeXmlForResourcesForQuery(List all,long days){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		
		for(Iterator it = all.iterator();it.hasNext();){
			
			FusionChartObject obj = (FusionChartObject)it.next();
			//key_workSpanId == obj.getId()
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");

//			System.out.println(" makeXmlForResourcesForQuery<<<<<<<<! obj.getId()+++++++++++++++++++<<<<<<<<<<"+ obj.getId());
			String tooltip = "22222222222222222222222222";
			String lbale = obj.getLable();
			if(lbale != null) sb.append("<cell title=\""+ tooltip +"\"><![CDATA["+ lbale  +"]]></cell>");
			
			String value1 = obj.getValue1();
			if(value1 != null) sb.append("<cell  title=\""+ tooltip +"\"><![CDATA["+ value1  +"]]></cell>");

			String value2 = obj.getValue2();
			if(value2 != null) sb.append("<cell  tooltip=\""+ tooltip +"\"><![CDATA["+ value2  +"]]></cell>");
			
			String value3 = obj.getValue3();
			if(value3 != null){
				String[] values = value3.split("_");
				setUserData(sb, obj,values);
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");
			}
		
			
			String value4 = obj.getValue4();
			if(value4 != null){
				String[] values = value4.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			
			String value5 = obj.getValue5();
			if(value5 != null){
				String[] values = value5.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			
			String value6 = obj.getValue6();
			if(value6 != null){
				String[] values = value6.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			
			String value7 = obj.getValue7();
			if(value7 != null){
				String[] values = value7.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
				
			
			
			String value8 = obj.getValue8();
			if(value8 != null){
				String[] values = value8.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value9 = obj.getValue9();
			if(value9 != null){
				String[] values = value9.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value10 = obj.getValue10();
			if(value10 != null){
				String[] values = value10.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value11 = obj.getValue11();
			if(value11 != null){	String[] values = value11.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value12 = obj.getValue12();
			if(value12 != null){	String[] values = value12.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value13 = obj.getValue13();
			if(value13 != null){ 	String[] values = value13.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}

			String value14 = obj.getValue14();
			if(value14 != null) {	String[] values = value14.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value15 = obj.getValue15();
			if(value15 != null) {	String[] values = value15.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value16 = obj.getValue16();
			if(value16 != null){	String[] values = value16.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value17 = obj.getValue17();
			if(value17 != null) {	String[] values = value17.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value18 = obj.getValue18();
			if(value18 != null){	String[] values = value18.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value19 = obj.getValue19();
			if(value19 != null){	String[] values = value19.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value20 = obj.getValue20();
			if(value20 != null){	String[] values = value20.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value21 = obj.getValue21();
			if(value21 != null){	String[] values = value21.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value22 = obj.getValue22();
			if(value22 != null){	String[] values = value22.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value23 = obj.getValue23();
			if(value23 != null){	String[] values = value23.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value24 = obj.getValue24();
			if(value24 != null){	String[] values = value24.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}

			String value25 = obj.getValue25();
			if(value25 != null){	String[] values = value25.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value26 = obj.getValue26();
			if(value26 != null){	String[] values = value26.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value27 = obj.getValue27();
			if(value27 != null){	String[] values = value27.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value28 = obj.getValue28();
			if(value28 != null){	String[] values = value28.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);
			}
			
			String value29 = obj.getValue29();
			if(value29 != null){	String[] values = value29.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);		
			}
			
			String value30 = obj.getValue30();
			if(value30 != null){	String[] values = value30.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");setUserData(sb, obj,values);		
			}
			
			String value31 = obj.getValue31();
			if(value31 != null){	String[] values = value31.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");	setUserData(sb, obj,values);	
			}
			 
			String value32 = obj.getValue32();
			if(value32 != null){	String[] values = value32.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");	setUserData(sb, obj,values);			
			}
			
			String value33 = obj.getValue33();
			if(value33 != null){	String[] values = value33.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");		setUserData(sb, obj,values);	
			}
			
			String value34 = obj.getValue34();
			if(value34 != null){	String[] values = value34.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");	setUserData(sb, obj,values);	
			}
			
			String value35 = obj.getValue35();
			if(value35 != null){	String[] values = value35.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");		setUserData(sb, obj,values);			
			}
			
			String value36 = obj.getValue36();
			if(value36 != null){	String[] values = value36.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");		setUserData(sb, obj,values);
			}

			String value37 = obj.getValue37();
			if(value37 != null){	String[] values = value37.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");	setUserData(sb, obj,values);	
			}
			
			String value38 = obj.getValue38();
			if(value38 != null){	String[] values = value38.split("_");
				sb.append("<cell><![CDATA["+ values[0]  +"]]></cell>");	setUserData(sb, obj,values);		
			}

			
			sb.append("</row>");
		}
		sb.append("</rows>");	
		
		return sb.toString();
	}
	
	public static Map getResourceWithWorkspan(Resource resource){
		ResourceDao dao = ServiceLocator.getResourceDao();
		List ls =  dao.getResourcesLevelOne(resource);
		Iterator it = ls.iterator();
		Map mp = new HashMap();
		while(it.hasNext()){
			Resource res = (Resource)it.next();
			mp.put(res.getId().toString(),res);
		}
		return mp;

	}
	
	
	public static String getStandTimeByWeek(Workspan workspan,String publishDate){
		int week = DateUtil.getDaysOfWeek(new Integer(publishDate).intValue());
		String weekStr ="0";
		 switch(week){
		    case 1: //"星期日"
		    	String sunLength = workspan.getSunLength();
		    	if(workspan!=null&&!sunLength.equals("0")&&!sunLength.equals(""))
				weekStr = sunLength;
				break;
			case 2: //"星期一";
				String monLength = workspan.getMonLength();
				if(workspan!=null&&!monLength.equals("0")&&!monLength.equals(""))
				weekStr = monLength;
				break;
			case 3://"星期二";
				String tureLength = workspan.getTueLength();
				if(workspan!=null&&!tureLength.equals("0")&&!tureLength.equals(""))
				weekStr = tureLength;
				break;
			case 4:// "星期三";
				String wenLength = workspan.getWenLength();
				if(workspan!=null&&!wenLength.equals("0")&&!wenLength.equals(""))
				weekStr = wenLength;
				break;
			case 5://"星期四";
				String thiLength = workspan.getThiLength();
				if(workspan!=null&&!thiLength.equals("0")&&!thiLength.equals(""))
				weekStr = thiLength;
				break;
			case 6:// "星期五";
				String friLength = workspan.getFriLength();
				if(workspan!=null&&!workspan.getFriLength().equals("0")&&!workspan.getFriLength().equals(""))
				weekStr = friLength;
				break;
			case 7://"星期六";
				String staLength = workspan.getSatLength();
				if(workspan!=null&&!staLength.equals("0")&&!staLength.equals(""))
				weekStr = staLength;
				break;
			}
		return weekStr;
	}
	
	
	
	
	
	
	
	
	

}
