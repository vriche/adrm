
package com.vriche.adrm.service.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.CtrData;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.ParamObj;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.ResourcePrint;
import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.FusionChartObjectComparator;
import com.vriche.adrm.util.ResourceBrostartTimeComparator;
import com.vriche.adrm.util.ResourceComparator;
import com.vriche.adrm.util.ResourceMemoComparator;
import com.vriche.adrm.util.ResourcePrintCarrierNameComparator;
import com.vriche.adrm.util.ResourcePrintDisplayNoComparator;
import com.vriche.adrm.util.ResourceUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class ResourceManagerImpl extends BaseManager implements ResourceManager {
    private ResourceDao dao;

    private CarrierDao carrierDao;
    
    
//    private boolean isMeno = SysParamUtil.getResourceDisplay();
    
    
   
    
//    private boolean displayCarrierType = SysParamUtil.getCarrierTypeDisplay();
//    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//    boolean isMeno = (sysParam.getResourceDisplayParam().equals("0")|| sysParam.getResourceDisplayParam() == null)?false:true;
//    
    /**
	 * @param carrierDao The carrierDao to set.
	 */
	public void setCarrierDao(CarrierDao carrierDao) {
		this.carrierDao = carrierDao;
	}

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setResourceDao(ResourceDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceManager#getResourcesByIdList(final Map idList)
     */
    public List getResourcesByIdList(final Map idList) {
        return dao.getResourcesByIdList(idList);
    }
    
    public List getResourcesIdByIdList(final Map idList) {
        return dao.getResourcesIdByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.ResourceManager#getResources(com.vriche.adrm.adres.model.Resource)
     */
    public List getResources(final Resource resource) {
        return dao.getResources(resource);
    }

    
    public List getResourcesOrderbyBroStartTime(final Resource resource) {
        return dao.getResourcesOrderbyBroStartTime(resource);
    }
    
    
    /**
     * @see com.vriche.adrm.adres.service.ResourceManager#getResource(String id)
     */
    public Resource getResource(final String id) {
        return dao.getResource(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.ResourceManager#saveResource(Resource resource)
     */
    public String saveResource(Resource resource) {
    	String name = resource.getResourceName();
    	String meno = resource.getMemo();
    	resource.setResourceName(StringUtil.getResourceName(name));
    	resource.setMemo(StringUtil.getResourceName(meno));
    	
//    	System.out.println("saveResource getVersion >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>gggggggggggg>>>>>>>>>>>>"+resource.getVersion());
        return dao.saveResource(resource).toString();
    }
    /**
     * @see com.vriche.adrm.adres.service.ResourceManager#updateDisplayNo(String[] resourceIds)
     */
    public void updateDisplayNo(String[] resourceIds) {
    	Map mp=new HashMap();
    	for(int i=0;i<resourceIds.length;i++){
        	mp.put("resourceId",""+resourceIds[i]);     
    		mp.put("displayNo",""+(i+1));
    		dao.updateDisplayNo(mp);
    	}  
    }
    /**
     * @see com.vriche.adrm.adres.service.ResourceManager#updateEnable(String[] resourceIds)
     */
    public void updateEnable(String resourceId,boolean enable) {
    		Map mp=new HashMap();
    		mp.put("resourceId",resourceId);
    		if(enable){
    			mp.put("enable","1");
    		}else{
    			mp.put("enable","0");
    		}       	  
    		dao.updateEnable(mp);
    }
    
    /**
     * @see com.vriche.adrm.adres.service.ResourceManager#removeResource(String id)
     */
    public void removeResource(final String id) {
        dao.removeResource(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.ResourceManager#removeResources(String Map)
     */
    public void removeResources(final Map idList) {
        dao.removeResources(idList);
    }

	public Map getResourceSelect(Resource resource) {
		List ls = this.getResources(resource);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	Resource resources = new Resource();
	    	resources = (Resource) it.next();
	    	
	    	reply.put("0","");
	    	reply.put(resources.getId(),resources.getResourceName());
	    }
		return reply;
	}

	public void getResourceItemsByCarrierId(StringBuffer sb, String carrierId, String resourceIdPrefix) {
//		System.out.println("==============2==========");
		boolean isMeno = SysParamUtil.getResourceDisplay();
		Resource res = new Resource();
		res.setCarrierId(new Long(carrierId));
		List ls = dao.getResources(res);
		
		
//		 System.out.println(">>>>>>>>>>>>>>>isMeno = " + isMeno);
		
//		System.out.println("carrierId = " + carrierId);
//		
//		System.out.println("resSize = " + ls.size());
		
		for(Iterator it = ls.iterator();it.hasNext();){
						
			Resource resource = (Resource)it.next();
			
//			Long carId = resource.getCarrierId();
//			Carrier carrier = carrierDao.getCarrier(carId);
			String lable = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
			
//			String title = resource.getMemo().toString();
			
			sb.append("<item id='" + resourceIdPrefix
							+ resource.getId().toString()
							+ "' im0=\"\" im1=\"\" im2=\"\" text=\""
							+ lable + "\">");
			sb.append("<userdata name=\"type\">3</userdata>");
//			sb.append("<userdata name=\"name\">" + carrier.getCarrierName()+"["+carrier.getAliasName()+"]"
//					+ "</userdata>");
			
			sb.append("</item>");
		
		} 
	}

	private List oneCarrResListByCarrierId(Long carrId) {
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
		Object obj = mp.get(carrId);
		List ls  = new ArrayList();
		if(obj != null) ls = (List)obj;
		return ls;
	}	
	
	public List getResListByCarrierId(Long carrierId,String publishDate) {
			List arrangeList = new ArrayList();
			Resource res = new Resource();
			Boolean isSeralized = new Boolean(true);
			res.setCarrierId(carrierId);
			//是否建立出串联单
			res.setIsSeralized(isSeralized)	;	
			res.setInPublishDate(new Integer(publishDate));
			List ls = dao.getResourcesForArrange(res);
			int week = DateUtil.getDaysOfWeek(new Integer(publishDate).intValue());
//			System.out.println("ls >>>>>>>>>>>>>>>>>>>>>>>>>>>>>.. " + ls.size());
			for(Iterator it = ls.iterator();it.hasNext();){
				Resource resource = (Resource)it.next();
				getWeekConvert(week,resource,arrangeList);
			}

		return arrangeList;
	}	
	
	
	public List getResListByCarrierIdAndIsAccountRes(Long carrierId,boolean isAccountRes) {
		List arrangeList = new ArrayList();
//		Resource res = new Resource();
//		res.setCarrierId(carrierId);
		//是否进入资源统计
		List ls = oneCarrResListByCarrierId(carrierId);
	
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource resource = (Resource)it.next();
			boolean is =resource.getIsOverweight().booleanValue();
			if(isAccountRes == is)arrangeList.add(resource);
		}

	return arrangeList;
}		
	
	
	public void getResourceItemsByCarrierIdFromMapByYear(StringBuffer sb, String carrierId, String resourceIdPrefix,String paramYear) {
		boolean isMeno = SysParamUtil.getResourceDisplay();
		List ls = oneCarrResListByCarrierId(new Long(carrierId));
//		Calendar   cal   =   Calendar.getInstance(); 
		for(Iterator it = ls.iterator();it.hasNext();){		
			Resource resource = (Resource)it.next();
//		  	cal.setTime(resource.getCreateDate());  
//	    	int   resYear   =   cal.get(Calendar.YEAR);
			int   resYear   = resource.getVersion().intValue();
//			Long carId = resource.getCarrierId();
//			Carrier carrier = carrierDao.getCarrier(carId);
//			String title = resource.getMemo().toString();
	    	if(Integer.parseInt(paramYear) == resYear){
				String lable = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
				
				sb.append("<item id='" + resourceIdPrefix
								+ resource.getId().toString()
								+ "' im0=\"\" im1=\"\" im2=\"\" text=\""
								+ lable + "\">");
				sb.append("<userdata name=\"type\">3</userdata>");
//				sb.append("<userdata name=\"name\">" + carrier.getCarrierName()+"["+carrier.getAliasName()+"]"
//						+ "</userdata>");
				
				sb.append("</item>");
	    	}

	    	
		
		} 
	}
	
	
	public void getResourceItemsByCarrierIdFromMapByYear2(StringBuffer sb, String carrierId, String resourceIdPrefix,String paramYear,boolean isAccountRes) {
		boolean isMeno = SysParamUtil.getResourceDisplay();
		List ls = oneCarrResListByCarrierId(new Long(carrierId));
//		Calendar   cal   =   Calendar.getInstance(); 
		for(Iterator it = ls.iterator();it.hasNext();){		
			Resource resource = (Resource)it.next();
//		  	cal.setTime(resource.getCreateDate());  
//	    	int   resYear   =   cal.get(Calendar.YEAR);
			int   resYear   = resource.getVersion().intValue();
			boolean isAcc = resource.getIsOverweight().booleanValue();
//			Long carId = resource.getCarrierId();
//			Carrier carrier = carrierDao.getCarrier(carId);
//			String title = resource.getMemo().toString();
	    	if(Integer.parseInt(paramYear) == resYear && isAcc == isAccountRes){
	    		
				String lable = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
				
				sb.append("<item id='" + resourceIdPrefix
								+ resource.getId().toString()
								+ "' im0=\"\" im1=\"\" im2=\"\"  tooltip=\"\"  text=\""
								+ lable + "\">");
				sb.append("<userdata name=\"type\">3</userdata>");
//				sb.append("<userdata name=\"name\">" + carrier.getCarrierName()+"["+carrier.getAliasName()+"]"
//						+ "</userdata>");
				
				sb.append("</item>");
	    	}

	    	
		
		} 
	}

	public void getResourceItemsByCarrierIdFromMap(StringBuffer sb, String carrierId, String resourceIdPrefix,String publishDate,String resourceTypeId) {
		boolean isMeno = SysParamUtil.getResourceDisplay();
		    String tvName = SysParamUtil.getTvNameParam();
		    boolean isFztv = SysParamUtil.isFZTVParam(tvName);
		    
//		    启用播出入点功能
		    boolean withBroPoint = SysParamUtil.getwithBroPoint();
//		    按播出入点排序
		    boolean arrangeOrderOrEntry = SysParamUtil.getArrangeOrderOrEntry() && withBroPoint;
		    
		    
 		
//			List arrangeList = new ArrayList();
			Resource res = new Resource();
			Boolean isSeralized = new Boolean(true);
			res.setCarrierId(new Long(carrierId));
			//是否建立出串联单
			res.setIsSeralized(isSeralized)	;	
			res.setInPublishDate(new Integer(publishDate));
//			long start1 = System.currentTimeMillis();
			List ls =new ArrayList();
			if(isFztv)res.setResourceType(new Integer(resourceTypeId));
			
			if(isFztv && resourceTypeId.equals("3")){       
				res.setEnable(new Boolean(true));
				res.setCarrierId(new Long(carrierId));           
//				res.setResourceType(new Integer(resourceTypeId));
				ls = dao.getResourcesNameByIdList(res);       
			}else{
//				if(arrangeOrderOrEntry){
//					ls = dao.getResourcesForArrangeOrderByBroTime(res);
//				}else{
					ls = dao.getResourcesForArrange(res);
//				}

			}
//			List ls = dao.getResourcesForArrange(res);
//			 long end1 = System.currentTimeMillis();
			int week = DateUtil.getDaysOfWeek(new Integer(publishDate).intValue());
//			System.out.println("carrierId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>.. " + carrierId.toString());
//			System.out.println("ls >>>>>>>>>>>>>>>>>>>>>>>>>>>>>.. " + ls.size());
//	        System.out.println("resultSize2>>>>>>>>   "+ (end1 -start1) +"秒");
//	        System.out.println("resultSize2>>>>>>>>   "+ (end1 -start1)/1000 +"秒");
			
//			for(Iterator it = ls.iterator();it.hasNext();){
//				Resource resource = (Resource)it.next();
//				getWeekConvert(week,resource,arrangeList);
//			}

			
			for(Iterator it = ls.iterator();it.hasNext();){
							
				Resource resource = (Resource)it.next();
				
				if(getWeekConvert(week,resource)){
					
					String lable = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
                    
					sb.append("<item id='" + resourceIdPrefix
							+ resource.getId().toString()
							+ "' im0=\"\" im1=\"\" im2=\"\" text=\""
							+ lable + "\">");
					sb.append("<userdata name=\"type\">3</userdata>");
					sb.append("</item>");  

				}
			} 
	}	
	public void getResourceItemsByCarrierIdForArrange(StringBuffer sb, String carrierId, String resourceIdPrefix,String publishDate) {

//	    boolean isMeno = getResourcesLablePara();
//	    		
//		List arrangeList = new ArrayList();
//		Resource res = new Resource();
//		Boolean isSeralized = new Boolean(true);
//		res.setCarrierId(new Long(carrierId));
//		//是否建立出串联单
//		res.setIsSeralized(isSeralized)	;	
//		res.setInPublishDate(new Integer(publishDate));
//		List ls = dao.getResourcesForArrange(res);
//		int week = DateUtil.getDaysOfWeek(new Integer(publishDate).intValue());
////		System.out.println("ls = " + ls.size());
//		for(Iterator it = ls.iterator();it.hasNext();){
//			Resource resource = (Resource)it.next();
//			getWeekConvert(week,resource,arrangeList);
//		}
//
//		
//		for(Iterator it = arrangeList.iterator();it.hasNext();){
//						
//			Resource resource = (Resource)it.next();
//
//			String lable = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
//			
//			sb.append("<item id='" + resourceIdPrefix
//							+ resource.getId().toString()
//							+ "' im0=\"\" im1=\"\" im2=\"\" text=\""
//							+ lable + "\">");
//			sb.append("<userdata name=\"type\">3</userdata>");
//
//			
//			sb.append("</item>");
//		
//		} 
	}
	
	public  String getWeekConvert(int week,Resource resource,List arrangeList){
    	String weekStr = null;
		   switch(week){
				    case 1:
				    	if(resource.getWorkspan()!=null&&!resource.getWorkspan().getSunLength().equals("0")&&!resource.getWorkspan().getSunLength().equals(""))
				    		arrangeList.add(resource);
		 				weekStr = "星期日";
		 				break;
		   			case 2:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getMonLength().equals("0")&&!resource.getWorkspan().getMonLength().equals(""))
				    		arrangeList.add(resource);
		   				weekStr = "星期一";
		   				break;
		   			case 3:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getTueLength().equals("0")&&!resource.getWorkspan().getTueLength().equals(""))
				    		arrangeList.add(resource);
		   				weekStr = "星期二";
		   				break;
		   			case 4:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getWenLength().equals("0")&&!resource.getWorkspan().getWenLength().equals(""))
				    		arrangeList.add(resource);
		   				weekStr = "星期三";
		   				break;
		   			case 5:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getThiLength().equals("0")&&!resource.getWorkspan().getThiLength().equals(""))
				    		arrangeList.add(resource);
		   				weekStr = "星期四";
		   				break;
		   			case 6:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getFriLength().equals("0")&&!resource.getWorkspan().getFriLength().equals(""))
				    		arrangeList.add(resource);
		   				weekStr = "星期五";
//		   				System.out.println("week lengeth = " + resource.getWorkspan().getFriLength()==null?"null":"aa");
		   				break;
		   			case 7:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getSatLength().equals("0")&&!resource.getWorkspan().getSatLength().equals(""))
				    		arrangeList.add(resource);
		   				weekStr = "星期六";
		   				break;
		   			}
		   return weekStr;
    }
	
	public  boolean getWeekConvert(int week,Resource resource){
    	boolean isEnable = false;
		   switch(week){
				    case 1:
				    	if(resource.getWorkspan()!=null&&!resource.getWorkspan().getSunLength().equals("0")&&!resource.getWorkspan().getSunLength().equals(""))
				    		isEnable = true;
		 				break;
		   			case 2:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getMonLength().equals("0")&&!resource.getWorkspan().getMonLength().equals(""))
		   					isEnable = true;
		   				break;
		   			case 3:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getTueLength().equals("0")&&!resource.getWorkspan().getTueLength().equals(""))
		   			 		isEnable = true;
		 				break;
		   			case 4:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getWenLength().equals("0")&&!resource.getWorkspan().getWenLength().equals(""))
		   			 		isEnable = true;
		 				break;
		   			case 5:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getThiLength().equals("0")&&!resource.getWorkspan().getThiLength().equals(""))
		   			 		isEnable = true;
		 				break;
		   			case 6:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getFriLength().equals("0")&&!resource.getWorkspan().getFriLength().equals(""))
		   			 		isEnable = true;
		 				break;
		   			case 7:
		   				if(resource.getWorkspan()!=null&&!resource.getWorkspan().getSatLength().equals("0")&&!resource.getWorkspan().getSatLength().equals(""))
		   			 		isEnable = true;
		 				break;
		   			}
		   return isEnable;
    }
	
	public String[] getResourcesByCompagesId(String compagesId,String propertyName) {
		List ls = dao.getResourcesByCompagesId(new Long(compagesId));
		
		int size = ls.size();
		String[] s = new String[size];
		int j = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				s[j++] = (String) BeanUtils.getProperty(it.next(),propertyName) ;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return s;
	}
private String getWeeks(ResourcePrint ws){
	StringBuffer sb = new StringBuffer();
	if(ws.getMonLength()!=null&&!ws.getMonLength().equals("0")&&!ws.getMonLength().equals("")){
		sb.append("1");
	}
	if(ws.getTueLength()!=null&&!ws.getTueLength().equals("0")&&!ws.getTueLength().equals("")){
		sb.append("2");
	}
	if(ws.getWenLength()!=null&&!ws.getWenLength().equals("0")&&!ws.getWenLength().equals("")){
		sb.append("3");
	}
	if(ws.getThiLength()!=null&&!ws.getThiLength().equals("0")&&!ws.getThiLength().equals("")){
		sb.append("4");
	}
	if(ws.getFriLength()!=null&&!ws.getFriLength().equals("0")&&!ws.getFriLength().equals("")){
		sb.append("5");
	}
	if(ws.getSatLength()!=null&&!ws.getSatLength().equals("0")&&!ws.getSatLength().equals("")){
		sb.append("6");
	}
	if(ws.getSunLength()!=null&&!ws.getSunLength().equals("0")&&!ws.getSunLength().equals("")){
		sb.append("7");
	}
	return sb.toString();
}
private void convertNullToEmtpy(String[] priceLengths,FusionChartObject fObject){
	switch(priceLengths.length){
	case 1:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		break;
	case 2:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		if(fObject.getValue5()==null) fObject.setValue5("0");
		break;
	case 3:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		if(fObject.getValue5()==null) fObject.setValue5("0");
		if(fObject.getValue6()==null) fObject.setValue6("0");
		break;
	case 4:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		if(fObject.getValue5()==null) fObject.setValue5("0");
		if(fObject.getValue6()==null) fObject.setValue6("0");
		if(fObject.getValue7()==null) fObject.setValue7("0");
		break;
	case 5:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		if(fObject.getValue5()==null) fObject.setValue5("0");
		if(fObject.getValue6()==null) fObject.setValue6("0");
		if(fObject.getValue7()==null) fObject.setValue7("0");
		if(fObject.getValue8()==null) fObject.setValue8("0");
		break;
	case 6:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		if(fObject.getValue5()==null) fObject.setValue5("0");
		if(fObject.getValue6()==null) fObject.setValue6("0");
		if(fObject.getValue7()==null) fObject.setValue7("0");
		if(fObject.getValue8()==null) fObject.setValue8("0");
		if(fObject.getValue9()==null) fObject.setValue9("0");
		break;
	case 7:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		if(fObject.getValue5()==null) fObject.setValue5("0");
		if(fObject.getValue6()==null) fObject.setValue6("0");
		if(fObject.getValue7()==null) fObject.setValue7("0");
		if(fObject.getValue8()==null) fObject.setValue8("0");
		if(fObject.getValue9()==null) fObject.setValue9("0");
		if(fObject.getValue10()==null) fObject.setValue10("0");
		break;
	case 8:
		if(fObject.getValue4()==null) fObject.setValue4("0");
		if(fObject.getValue5()==null) fObject.setValue5("0");
		if(fObject.getValue6()==null) fObject.setValue6("0");
		if(fObject.getValue7()==null) fObject.setValue7("0");
		if(fObject.getValue8()==null) fObject.setValue8("0");
		if(fObject.getValue9()==null) fObject.setValue9("0");
		if(fObject.getValue10()==null) fObject.setValue10("0");
		if(fObject.getValue11()==null) fObject.setValue11("0");
		break;
}
}
public List getPriceLength(String[] carrierIds){
	Map mp=new HashMap();
	List ls=new ArrayList();
	for(int i=0;i<carrierIds.length;i++){
		ls.add(carrierIds[i]);
	}
	mp.put("carrierIdList",ls);
	return  dao.getPriceLength(mp);
}
public Collection getCollections(final String queryString,String type) {
	
	String carrierName = StringUtil.getParamFromUrl(queryString,"carrierName");
	String carrierId = StringUtil.getParamFromUrl(queryString,"carrierIds");
	String[] carrierIds = carrierId.split(",");
	String priceLength = StringUtil.getParamFromUrl(queryString,"priceLengths");
//	if(priceLength.equals("undefined")){
//		priceLength = "";
//	}
	String[] priceLengths=new String[priceLength.length()];

	if(priceLength.length()!=0){
		priceLengths = priceLength.split(",");
	}

	Map childMap = new HashMap();
	List carrierIdls = new ArrayList();
	for(int i=0;i<carrierIds.length;i++){
		carrierIdls.add(carrierIds[i]);
	}
	childMap.put("carrierIds",carrierIdls);	
	List ls = dao.getResourcePrint(childMap);

	String resourceOldId="";
	String weeks="";
	FusionChartObject fObject=null;
	List valuecoll = new ArrayList();
	
	for(Iterator it = ls.iterator();it.hasNext();){
		ResourcePrint ws=(ResourcePrint)it.next();
		String length=ws.getLength();
		String price=ws.getPrice();
//		if(length!=null){
//			length = length.equals("")?"0":ws.getLength();
//		}
		
		if(!resourceOldId.equals(ws.getResourceId())){
			if(resourceOldId!=""){
				convertNullToEmtpy(priceLengths,fObject);
				valuecoll.add(fObject);
			}
			fObject = new FusionChartObject();
			weeks=getWeeks(ws);
			if(carrierIds.length==1){
				fObject.setValue1(carrierName);
			}else{
				fObject.setValue1(carrierName+"/"+ws.getCarrierName());
			}
			fObject.setValue2(ws.getResourceName());
			fObject.setValue3(ws.getMemo());
			resourceOldId=ws.getResourceId();
		}
		switch(priceLengths.length){
			case 0:
				fObject.setValue4(weeks);
			break;
			case 1:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}
				fObject.setValue5(weeks);
				break;
			case 2:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}else if((priceLengths[1]).equals(length)){
					fObject.setValue5(price);
				}
				fObject.setValue6(weeks);
				break;
			case 3:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}else if((priceLengths[1]).equals(length)){
					fObject.setValue5(price);
				}else if((priceLengths[2]).equals(length)){
					fObject.setValue6(price);
				}
				fObject.setValue7(weeks);
				break;
			case 4:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}else if((priceLengths[1]).equals(length)){
					fObject.setValue5(price);
				}else if((priceLengths[2]).equals(length)){
					fObject.setValue6(price);
				}else if((priceLengths[3]).equals(length)){
					fObject.setValue7(price);
				}
				fObject.setValue8(weeks);
				break;
			case 5:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}else if((priceLengths[1]).equals(length)){
					fObject.setValue5(price);
				}else if((priceLengths[2]).equals(length)){
					fObject.setValue6(price);
				}else if((priceLengths[3]).equals(length)){
					fObject.setValue7(price);
				}else if((priceLengths[4]).equals(length)){
					fObject.setValue8(price);
				}
				fObject.setValue9(weeks);
				break;
			case 6:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}else if((priceLengths[1]).equals(length)){
					fObject.setValue5(price);
				}else if((priceLengths[2]).equals(length)){
					fObject.setValue6(price);
				}else if((priceLengths[3]).equals(length)){
					fObject.setValue7(price);
				}else if((priceLengths[4]).equals(length)){
					fObject.setValue8(price);
				}else if((priceLengths[5]).equals(length)){
					fObject.setValue9(price);
				}
				fObject.setValue10(weeks);
				break;
			case 7:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}else if((priceLengths[1]).equals(length)){
					fObject.setValue5(price);
				}else if((priceLengths[2]).equals(length)){
					fObject.setValue6(price);
				}else if((priceLengths[3]).equals(length)){
					fObject.setValue7(price);
				}else if((priceLengths[4]).equals(length)){
					fObject.setValue8(price);
				}else if((priceLengths[5]).equals(length)){
					fObject.setValue9(price);
				}else if((priceLengths[6]).equals(length)){
					fObject.setValue10(price);
				}
				fObject.setValue11(weeks);
				break;
			case 8:
				if((priceLengths[0]).equals(length)){
					fObject.setValue4(price);
				}else if((priceLengths[1]).equals(length)){
					fObject.setValue5(price);
				}else if((priceLengths[2]).equals(length)){
					fObject.setValue6(price);
				}else if((priceLengths[3]).equals(length)){
					fObject.setValue7(price);
				}else if((priceLengths[4]).equals(length)){
					fObject.setValue8(price);
				}else if((priceLengths[5]).equals(length)){
					fObject.setValue9(price);
				}else if((priceLengths[6]).equals(length)){
					fObject.setValue10(price);
				}else if((priceLengths[7]).equals(length)){
					fObject.setValue11(price);
				}
				fObject.setValue12(weeks);
				break;
		}
		if(!it.hasNext()){
			convertNullToEmtpy(priceLengths,fObject);
			valuecoll.add(fObject);
		}
	}
		Collection coll = new ArrayList();
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
	}    

public Collection getResourcesPrint(String carrierId,Map carrierMap){
	
//	   System.out.println(">>>1111111111111111111111>>>>   ");
		
		
		Map carrierMapChild = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
		
		List childCarriers = (List)carrierMapChild.get(new Long(carrierId));
		List carrierIds = new ArrayList();
		for(Iterator it = childCarriers.iterator();it.hasNext();){
			Carrier c = (Carrier)it.next();
			carrierIds.add(c.getId());
		}
		Map childMap = new HashMap();
		childMap.put("carrierIds",carrierIds);
	
//		 System.out.println(">>>2222222222222222222222>>>>   ");		
		
		
		List comparTo = new ArrayList();
//		List newComparTo = new ArrayList();
		List ls = dao.getResourcePrint(childMap);
		
//		System.out.println(">>>333333333333333333>>>>   ");	
		
		Map mp = new HashMap();
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ResourcePrint resourcePrint = (ResourcePrint)it.next();
			String resourceId = resourcePrint.getResourceId();
			
		    this.getSameResourceIdList(ls,mp,resourceId);		
			
//			List sameCarrierList  = (List)mp.get(carrierId);
		}
//		
		
		
//		 System.out.println(">>>444444444>>>>   ");	
		 
		 
			for(Iterator sameResourceIt = mp.values().iterator();sameResourceIt.hasNext();){ 
				List sameResourceList = (List)sameResourceIt.next();
//				System.out.println(">>>sameResourceList>>>>   "+sameResourceList.size());
				ResourcePrint rp = getOneResourcePrintByLength(sameResourceList,carrierMap,carrierId);
				comparTo.add(rp);
			}
			List cIds =new ArrayList();
//			int i=0;
			for(Iterator it = comparTo.iterator();it.hasNext();){
				ResourcePrint resourcePrint = (ResourcePrint)it.next();
				if(!cIds.contains(resourcePrint.getCarrierId())){
					cIds.add(resourcePrint.getCarrierId());
				}
			}
			
			
//			 System.out.println(">>>5555555555555555>>>>   ");	
			
		return getComparatorList(comparTo,cIds);
	}
	
	private Collection getComparatorList(List ls,List cIds){
		Collection coll = new ArrayList();
		for(Iterator itn = cIds.iterator();itn.hasNext();){
			String cId = (String)itn.next();
			List c = new ArrayList();
			for(Iterator it = ls.iterator();it.hasNext();){
				ResourcePrint resourcePrint = (ResourcePrint)it.next();
				
				if(resourcePrint.getCarrierId().equals(cId)){
					c.add(resourcePrint);
				}
			}
//			System.out.println(">>>c>>>>   "+c.size());
			Collections.sort((List)c,new ResourcePrintCarrierNameComparator());
			Collections.sort((List)c,new ResourcePrintDisplayNoComparator());
			for(Iterator it = c.iterator();it.hasNext();){
				coll.add(it.next());
			}
			
		}
//		System.out.println(">>>coll>>>>   "+coll.size());
		return coll;
	}
	
	private void getSameResourceIdList(List ls,Map mp,String resourceId){
		List newls = new ArrayList();
//		System.out.println(">>>resourceId>>>>   "+resourceId);
//		System.out.println(mp.containsKey(resourceId));
		if(!mp.containsKey(resourceId)){
		for(Iterator it = ls.iterator();it.hasNext();){
			ResourcePrint resourcePrint = (ResourcePrint)it.next();
			if(resourcePrint.getResourceId().equals(resourceId)){
				newls.add(resourcePrint);
			
			}
		}
		mp.put(resourceId,newls);
		}
	}
	
	private ResourcePrint getOneResourcePrintByLength(List sameResourceList,Map carrierMap,String carrierParentId){

		boolean isMeno = SysParamUtil.getResourceDisplay();
		
		StringBuffer sb = new StringBuffer();
		ResourcePrint newResourePrint = new ResourcePrint();
				
		for(Iterator it = sameResourceList.iterator();it.hasNext();){
			ResourcePrint resourcePrint = (ResourcePrint)it.next();
			if(newResourePrint.getCarrierId()==null){
				newResourePrint.setCarrierId(resourcePrint.getCarrierId());
				
				String name = resourcePrint.getResourceName();
				String memo = resourcePrint.getMemo();
				String lable = isMeno?memo:name;
				lable = isMeno?"["+lable+"]" +name:"["+lable+"]" + memo;
				newResourePrint.setResourceName(lable);
//				newResourePrint.setResourceName(resourcePrint.getResourceName());
				newResourePrint.setMemo(resourcePrint.getMemo());
				newResourePrint.setCarrierName(resourcePrint.getCarrierName());
				newResourePrint.setParentId(resourcePrint.getParentId());
				newResourePrint.setDisplayNo(resourcePrint.getDisplayNo());
//				System.out.println(resourcePrint.getMonLength()==null);
				if(resourcePrint.getMonLength()!=null&&!resourcePrint.getMonLength().equals("0")&&!resourcePrint.getMonLength().equals("")){
					sb.append("一");
				}
				if(resourcePrint.getTueLength()!=null&&!resourcePrint.getTueLength().equals("0")&&!resourcePrint.getTueLength().equals("")){
					sb.append(" 二");
				}
				if(resourcePrint.getWenLength()!=null&&!resourcePrint.getWenLength().equals("0")&&!resourcePrint.getWenLength().equals("")){
					sb.append(" 三");
				}
				if(resourcePrint.getThiLength()!=null&&!resourcePrint.getThiLength().equals("0")&&!resourcePrint.getThiLength().equals("")){
					sb.append(" 四");
				}
				if(resourcePrint.getFriLength()!=null&&!!resourcePrint.getFriLength().equals("0")&&!resourcePrint.getFriLength().equals("")){
					sb.append(" 五");
				}
				if(resourcePrint.getSatLength()!=null&&!!resourcePrint.getSatLength().equals("0")&&!resourcePrint.getSatLength().equals("")){
					sb.append(" 六");
				}
				if(resourcePrint.getSunLength()!=null&&!!resourcePrint.getSunLength().equals("0")&&!resourcePrint.getSunLength().equals("")){
					sb.append(" 日");
				}
			}
			Integer length = resourcePrint.getLength()==null?new Integer(0):new Integer(resourcePrint.getLength());
			switch(length.intValue()){
			case 5:
				newResourePrint.setFivePrice(resourcePrint.getPrice());
				break;
			case 10:
				newResourePrint.setTenPrice(resourcePrint.getPrice());
				break;
			case 15:
				newResourePrint.setFifteenPrice(resourcePrint.getPrice());
				break;
			case 30:
				newResourePrint.setThirtyPrice(resourcePrint.getPrice());
				break;
			case 60:
				newResourePrint.setSixtyPrice(resourcePrint.getPrice());
				break;
		}
//			System.out.println(resourcePrint.getTueLength().equals("") );
//			System.out.println(resourcePrint.getMonLength().equals("0") );
		
	}
		newResourePrint.setWeekDay(sb.toString());
		
		StringBuffer sb1 =new StringBuffer();
		List carrierParent = (List)carrierMap.get(new Long(newResourePrint.getCarrierId()));	
		List orderByIdCarrier = new ArrayList();
		for(int i=carrierParent.size()-1;i>=0;i--){
			orderByIdCarrier.add(carrierParent.get(i));
		}
		for(Iterator carrierIt = orderByIdCarrier.iterator();carrierIt.hasNext();){
			Carrier c = (Carrier)carrierIt.next();
				if(carrierIt.hasNext()){
					sb1.append(c.getCarrierName()+"/");
				}else{
					sb1.append(c.getCarrierName());
				}
//			}
		}
		newResourePrint.setCarrierName(sb1.toString());
//		System.out.println(">>>>getWeekDay  "+sb);
//		System.out.println(">>>>CarrierName  "+newResourePrint.getCarrierName());
		return newResourePrint;
	}
	

	
	public Map getResourceSelectFromMap(Resource res) {
		
		 boolean isMeno = SysParamUtil.getResourceDisplay();
		
//		 启用播出入点功能
		 boolean withBroPoint = SysParamUtil.getwithBroPoint();
//		  按播出入点排序
		 boolean arrangeOrderOrEntry = SysParamUtil.getArrangeOrderOrEntry() && withBroPoint;

		    
		 boolean orderCarrierLevelOne = SysParamUtil.getOrderCarrierLevelOne();
		 
		 int  paramYear = res.getResourceYear().intValue();		
//		 Calendar   cal   =   Calendar.getInstance(); 
//		 String tvName = SysParamUtil.getTvNameParam();
//		 boolean fztv = SysParamUtil.isSJZTVParam(tvName);
//		 boolean xmtv = SysParamUtil.isXMTVParam(tvName);
//		 String orgId = StringUtil.getNullValue(res.getOrgId(),"1") ;
//		 String resourceSort = StringUtil.getNullValue(res.getResourceSort(),"1") ;
//		 如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
		

		Map reply = new LinkedHashMap();
		Map replyTemp = new LinkedHashMap();

		List resourceList = new ArrayList();

//		System.out.println("resourceList.size>>>>>>>>>>>>>>>>" + resourceList.size());
		
		
		
//		System.out.println("withBroPoint %%%%%%%%%%%%%%%%ttttttttttttttttttttttt%%%%%%%%%"+withBroPoint);

		
		//如果只有一级，就按播出入点出
		
		if(orderCarrierLevelOne){
			resourceList = dao.getResourcesLevelOne(res);
		}else{
			resourceList = dao.getResourcesOrderbyBroStartTimeLevelOne(res);
		}


			Collections.sort(resourceList,new ResourceComparator());
		
	    Iterator it = resourceList.iterator();
    	reply.put("0","");


	    while(it.hasNext()){
	    	Resource resource =(Resource) it.next();
	    	int   resYear = resource.getVersion().intValue();
	    	if(paramYear == resYear){ 
	    		String lable = ResourceUtil.getResourceName(resource,1);
	    		
	    		 
	    		String key = resource.getId().toString();
	    		int startDate1 = resource.getWorkspan().getBeginDate().intValue();
	    		if(replyTemp.containsKey(key)){
	    			int startDate2 = ((Integer)replyTemp.get(key)).intValue();
	    			if(startDate1 > startDate2 ) reply.put(resource.getId(),lable);  
	    		}else{
	    			reply.put(resource.getId(),lable);  
	    			replyTemp.put(key,resource.getWorkspan().getBeginDate());
	    		}
		    	
	    	}

	    }
		return reply;
	
	}
	
	
	
	
	public List getResourceSelectFromMap3(Resource res) {
		
		 boolean isMeno = SysParamUtil.getResourceDisplay();
		
//		 启用播出入点功能
		 boolean withBroPoint = SysParamUtil.getwithBroPoint();
//		  按播出入点排序
		 boolean arrangeOrderOrEntry = SysParamUtil.getArrangeOrderOrEntry() && withBroPoint;

		    
		 boolean orderCarrierLevelOne = SysParamUtil.getOrderCarrierLevelOne();
		 
		 int  paramYear = res.getResourceYear().intValue();		
//		 Calendar   cal   =   Calendar.getInstance(); 
//		 String tvName = SysParamUtil.getTvNameParam();
//		 boolean fztv = SysParamUtil.isSJZTVParam(tvName);
//		 boolean xmtv = SysParamUtil.isXMTVParam(tvName);
//		 String orgId = StringUtil.getNullValue(res.getOrgId(),"1") ;
//		 String resourceSort = StringUtil.getNullValue(res.getResourceSort(),"1") ;
//		 如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
		

		Map reply = new LinkedHashMap();
		Map replyTemp = new LinkedHashMap();

		List resourceList = new ArrayList();
		List resourceList2 = new ArrayList();

//		System.out.println("resourceList.size>>>>>>>>>>>>>>>>" + resourceList.size());
		
		
		
//		System.out.println("withBroPoint %%%%%%%%%%%%%%%%ttttttttttttttttttttttt%%%%%%%%%"+withBroPoint);

		
		//如果只有一级，就按播出入点出
		
		if(orderCarrierLevelOne){
			resourceList = dao.getResourcesLevelOne(res);
		}else{
			resourceList = dao.getResourcesOrderbyBroStartTimeLevelOne(res);
		}


			Collections.sort(resourceList,new ResourceComparator());
		
	    Iterator it = resourceList.iterator();
	    
			Resource resource1 =new Resource();
			resource1.setResourceName("");
   	reply.put("0",resource1);


	    while(it.hasNext()){
	    	Resource resource =(Resource) it.next();
	    	int   resYear = resource.getVersion().intValue();
	    	if(paramYear == resYear){ 
	    		String lable = ResourceUtil.getResourceName(resource,1);
	    		
	    		resource.setResourceName(lable);
	    		 
	    		String key = resource.getId().toString();
	    		int startDate1 = resource.getWorkspan().getBeginDate().intValue();
	    		if(replyTemp.containsKey(key)){
	    			int startDate2 = ((Integer)replyTemp.get(key)).intValue();
	    			if(startDate1 > startDate2 ) reply.put(resource.getId(),resource);  
	    		}else{
	    			reply.put(resource.getId(),resource);  
	    			replyTemp.put(key,resource.getWorkspan().getBeginDate());
	    		}
		    	
	    	}

	    }
	    CollectionUtils.addAll(resourceList2,reply.values().iterator());
		return resourceList2;
	
	}

	public Resource getResourceByIdFromMap(Resource res) {
	
		
		Map resourceMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
		List resourceList = (List)resourceMap.get(res.getCarrierId());
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
	
	public List getResourceIdsForPutOn(String carrierId){
		 boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();

		Map resourceMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
//		List carrierIds = getCarrierParnetPutOn(carrierId);
//		System.out.println("  carrierId11111111111   "+carrierId);
		Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
		List carrierIds = new ArrayList();
        
        if(carrierAlisname){
//        	System.out.println("  carrierId 2222222222  "+ carrierId.indexOf(","));
        	
        	 if(carrierId.indexOf(",")>-1){
        		 String[] ids = carrierId.split(",");
        		 for(int i=0;i<ids.length;i++){
        			 List lss = 	 (List)carrierMap.get(new Long(ids[i]));
        			 CollectionUtils.addAll(carrierIds,lss.iterator());
     			 }
        	 }else{
        		 carrierIds = (List)carrierMap.get(new Long(carrierId));
        	 }
        	 
        }else{
        	 carrierIds = (List)carrierMap.get(new Long(carrierId));
        }
        
		
		
		
//		System.out.println("  PPPP1   "+carrierIds.size());
		List resourceIds = new ArrayList();
		for(Iterator it = carrierIds.iterator();it.hasNext();){
			Carrier carrier = (Carrier)it.next();
			List resourceList = (List)resourceMap.get(carrier.getId());
			if(resourceList.size()>0){
				for(Iterator resit = resourceList.iterator();resit.hasNext();){
					Resource resourceObj = (Resource)resit.next();
					resourceIds.add(resourceObj.getId());
//					System.out.println("  resourceObj.getId>>>>>>>>>>>   "+ resourceObj.getId());
				}
			}
			
		}
	
		return resourceIds;
	}
	

	
	public Map getResourceYearTypeMap(String year,String resourceType){
		Map mp = new HashMap();
		List resourceIds = new ArrayList();
		List resources = new ArrayList();
		Map mpYear = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCENAME_YEAR_TYPE_MAP);
		String key = year +"_"+ resourceType;
		Map  resMap = (Map)mpYear.get(key);
		if(resMap != null){
			for(Iterator it = resMap.keySet().iterator();it.hasNext();){
	            String resKey = (String)it.next();
	            resourceIds.add(resKey);
	            resources.add((Resource)resMap.get(resKey));
			}
		}

		
//	    if(resourceIds.size()>0){
	    	mp.put("resourceIds",resourceIds);
	    	mp.put("resources",resources);
//	    }
	    
		return mp;
	}
	private List getCarrierParnetPutOn(String carrierId){
		
		Map carrierMap = new HashMap();
		List carrierNodeLevel = new ArrayList();
		List carrierIds = new ArrayList();
		
		Carrier carrier = new Carrier();
		carrier.setParentId(carrierId);
		List carriers = carrierDao.getCarriers(carrier);
		for(Iterator it = carriers.iterator();it.hasNext();){
			Carrier carrierIt = (Carrier)it.next();
			carrierNodeLevel.add(carrierIt);
			getCarrierParnet(carrierIt.getId().toString(),carrierNodeLevel);
		}
		
		for(Iterator im = carrierNodeLevel.iterator();im.hasNext();){
			Carrier carrierIs = (Carrier)im.next();
			carrierIds.add(carrierIs.getId());
//			System.out.println("  xxxx   "+carrierIs.getId());
		}
		

		return carrierIds;
	}
	
	
	private void getCarrierParnet(String carrierId,List carrierNodeLevel){
		Carrier carrier = new Carrier();
		carrier.setParentId(carrierId);
		List carriers = carrierDao.getCarriers(carrier);

		for(Iterator it = carriers.iterator();it.hasNext();){
			Carrier carrierParnet = (Carrier)it.next();
			Integer level = carrierParnet.getNodeLevel();
			Long id = carrierParnet.getId();
			carrierNodeLevel.add(carrierParnet);
			if(level.intValue() >1){
				getCarrierParnet(id.toString(),carrierNodeLevel);
			}
		}
		
		
		
	}

	public void getResourcesResourceAnalyze(StringBuffer sb, String carrierId, String resourceIdPrefix, String resourceTypeId) {
	
		boolean isMeno = SysParamUtil.getResourceDisplay();
		 
		Resource res = new Resource();
		res.setCarrierId(new Long(carrierId));
		String typeId = resourceTypeId==null?"0":resourceTypeId;
		if(!typeId.equals("0")){
			res.setResourceType(new Integer(typeId));
		}
		List ls = dao.getResources(res);

		
		for(Iterator it = ls.iterator();it.hasNext();){
						
			Resource resource = (Resource)it.next();
			String lable = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
			
			sb.append("<item id='" + resourceIdPrefix
							+ resource.getId().toString()
							+ "' im0=\"\" im1=\"\" im2=\"\" text=\""
							+ lable + "\">");
			sb.append("<userdata name=\"type\">3</userdata>");
//			sb.append("<userdata name=\"name\">" + carrier.getCarrierName()+"["+carrier.getAliasName()+"]"
//					+ "</userdata>");
			sb.append("</item>");
		
		} 
		
	}
	
	
	

	public void getResourceItemsByCarrierIdByYear(StringBuffer sb, String carrierId, String resourceIdPrefix, String year,boolean orderCarrierLevelOne,Integer resType,String orgType) {
		
//		System.out.println(">>>>>>>>>>>>>>>isMeno = " + SysParamUtil.getResourceDisplay());
		boolean isMeno = SysParamUtil.getResourceDisplay();
		String tvName = SysParamUtil.getTvNameParam();
////	    启用播出入点功能
//	    boolean withBroPoint = SysParamUtil.getwithBroPoint();
////	    按播出入点排序
//	    boolean arrangeOrderOrEntry = SysParamUtil.getArrangeOrderOrEntry() && withBroPoint;
//		boolean orderCarrierLevelOne = SysParamUtil.getOrderCarrierLevelOne();
		
		Resource res = new Resource();
		res.setCarrierId(new Long(carrierId));
		res.setVersion(new Integer(year));
		
		if(resType != null){
			if(resType.intValue() !=999 ) res.setResourceType(resType);
		}
		
		List resourceList = new ArrayList();

//		if(isArrangeOrderOrEntry){
//			resourceList = dao.getResourcesOrderbyBroStartTime(res);
//		}else{
//			resourceList = dao.getResources(res);
//		}

//		System.out.println(">>>>>>>>>>>>>>>orderCarrierLevelOne = " + orderCarrierLevelOne);
		
//		if(arrangeOrderOrEntry){
//			if(orderCarrierLevelOne){
//				resourceList = dao.getResourcesOrderbyBroStartTimeLevelOne(res);
//			}else{
//				resourceList = dao.getResourcesOrderbyBroStartTime(res);
//			}
//
//		}else{
			if(orderCarrierLevelOne){
				resourceList = dao.getResourcesLevelOne(res);
			}else{
				resourceList = dao.getResources(res);
			}
//			List ls = StringUtilsv.singleElement(resourceList);
//		}	s
		
		
//			System.out.println(">>>>>>>>yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy>>>>>>tooltip = " + tvName);
		
		for(Iterator it = resourceList.iterator();it.hasNext();){
			Resource resource = (Resource)it.next();
//			String tooltip =ResourceUtil.getResourceName(resource,7);
			
			String lable =  ResourceUtil.getResourceName(resource,8);
   					
   			String tooltip =lable;
//			System.out.println(">>>>>>>>11111111111111 2222222222222222 >>>>>>>tooltip = " + tvName);
			
//			String broTime = resource.getWorkspan().getBroadcastTimeFormat();  		
			
//			String lable =  ResourceUtil.getResourceName(resource,8);
//			String lable = isMeno?resource.getResourceName().toString():resource.getMemo().toString();
//			String lable =  tooltip;
		
   			
   			Workspan workspan = resource.getWorkspan();
   			String broTime = workspan.getBroadcastTimeFormat();
   			
//   			System.out.println(">>>>>>>>yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy>>>>>>tooltip = " + broTime);
   			
			sb.append("<item id='" + resourceIdPrefix
							+ resource.getId().toString()
							+ "' im0=\"\" im1=\"\" im2=\"\" tooltip=\""+ tooltip +"\" text=\""
							+ lable +"\">");
			sb.append("<userdata name=\"type\">3</userdata>");
			sb.append("<userdata name=\"resourceTypeId\">"+ resource.getResourceType()+"</userdata>");
			sb.append("<userdata name=\"broTime\">"+ broTime +"</userdata>");
			sb.append("<userdata name=\"resourceName\">"+ resource.getResourceName() +"</userdata>");
			sb.append("<userdata name=\"resourceMemo\">"+ resource.getMemo() +"</userdata>");
			
			sb.append("</item>");

		} 
		
	}
	
	public void getResourceItemsByChannelIdByYear(StringBuffer sb, String carrierId, String resourceIdPrefix, String year,Integer resourceType,Integer orderBy) {
		boolean isMeno = SysParamUtil.getResourceDisplay();
		Resource res = new Resource();
		res.setCarrierId(new Long(carrierId));
		res.setVersion(new Integer(year));
		if(resourceType==null||resourceType.intValue()==4){ 
			res.setEnable(new Boolean(true));
		}else{
			res.setResourceType(resourceType);
		}  
		List ls = dao.getResourcesNameByIdList(res);
		if(orderBy!=null){
			Collections.sort(ls,new ResourceMemoComparator());
		}
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource resource = (Resource)it.next();	
			String lable = isMeno?resource.getMemo()+"("+resource.getResourceName()+")":resource.getResourceName()+"("+resource.getCarrier().getCarrierName()+")";
			sb.append("<item id='" + resourceIdPrefix
							+ resource.getId().toString()
							+ "' im0=\"\" im1=\"\" im2=\"\" text=\""
							+ lable +"\">");
			sb.append("<userdata name=\"type\">3</userdata>");
			sb.append("<userdata name=\"resourceTypeId\">"+ resource.getResourceType()+"</userdata>");
			sb.append("</item>");
		} 
		
	}
	
	public void getResourceItemsByChannelIdByYear2(StringBuffer sb, String carrierId, String resourceIdPrefix, String year,Integer resourceType,Integer orderBy,boolean enable,boolean isFineRes) {
//		boolean isMeno = SysParamUtil.getResourceDisplay();
		String tvName = SysParamUtil.getTvNameParam();
		Resource res = new Resource();
		res.setCarrierId(new Long(carrierId));
		res.setVersion(new Integer(year));
		if(enable) 	res.setEnable(new Boolean(true));
		boolean isMeno = SysParamUtil.getResourceDisplay();
//		String dd = year + DateUtil.getDate().substring(4,6)+ DateUtil.getDate().substring(6,8);
//		res.setInPublishDate(new Integer(dd));
		if(resourceType !=null){ 
			if(resourceType.intValue() > 0) res.setResourceType(resourceType);
		}  
		List ls2 = dao.getResourcesOrderbyBroStartTime(res);
		
		List ls = StringUtilsv.singleElement(ls2);
		
		if(orderBy !=null){
			Collections.sort(ls,new ResourceMemoComparator());
		}
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource resource = (Resource)it.next();
			
   			Workspan workspan = resource.getWorkspan();
   			String broTime = workspan.getBroadcastTimeFormatStart();
			
			boolean isAcc = resource.getIsOverweight().booleanValue();
			boolean pass = isFineRes ?  isAcc:true;
            if(pass){
            	
    			String tooltip = ResourceUtil.getResourceName(resource,4);
//    			String lable  = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
    			String lable  = tooltip;
//    			if("catv".equals(tvName)){
//    				lable = lable + " " +tooltip;
//    			}
    				
    		
//    			String broTime = resource.getWorkspan().getBroadcastTimeFormat();  
//    			String lable = isMeno?resource.getMemo().toString():resource.getResourceName().toString();
    			sb.append("<item id='" + resourceIdPrefix
    							+ resource.getId().toString()
    							+ "' im0=\"\" im1=\"\" im2=\"\" tooltip=\""+ tooltip +"\" text=\""
    							+ lable +"\">");
    			sb.append("<userdata name=\"type\">3</userdata>");
    			sb.append("<userdata name=\"resourceTypeId\">"+ resource.getResourceType()+"</userdata>");
    			
    			sb.append("<userdata name=\"broTime\">"+ broTime +"</userdata>");
    			sb.append("<userdata name=\"resourceName\">"+ resource.getResourceName() +"</userdata>");
    			sb.append("<userdata name=\"resourceMemo\">"+ resource.getMemo() +"</userdata>");
    			
    			System.out.println(">>>>>>>>yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy>>>>>>tooltip = " + broTime);
    			System.out.println(">>>>>>>>yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy>>>>>>tooltip = " + resource.getResourceName());
    			System.out.println(">>>>>>>>yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy>>>>>>tooltip = " + resource.getMemo());
    			
    			sb.append("</item>");	
            }

		} 
		
	}
	
	public Map getResourcesAllFromChannelId(Resource res) {
		Map reply = new LinkedHashMap();
		reply.put("0","");           
//		boolean isMeno = getResourcesLablePara();
		List ls = dao.getResourcesNameByIdList(res);
		Collections.sort(ls,new ResourceMemoComparator());  
		for(Iterator it=ls.iterator();it.hasNext();){
			Resource resource=(Resource)it.next();      
			String lable = resource.getMemo()+"("+resource.getResourceName()+")";
			reply.put(resource.getId()+"",lable);
		}
		return reply;
	}
	
	
	public String[] getResourceIds(Resource res) {
		List ls = dao.getResources(res);
//		System.out.println(">>>>>>>>>>>>>>>ls = " + ls.size());
		
		int size = ls.size();
		String[] s = new String[size];
		int j = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				s[j++] = (String) BeanUtils.getProperty(it.next(),"id") ;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//		System.out.println(">>>>>>>>>>>>>>>ls = ");
		
		return s;
	}
	
	public void saveResCarrTypeRel(String resourceType,String[] resIds) {
		Map mp = new HashMap();
		mp.put("resourceType",resourceType);
		mp.put("resourceIdList",resIds);
        dao.saveResCarrTypeRel(mp);
	}
	
	public  List getResourceIdsBySortId(List carrier2IdList,String startDate, String endDate,String resType) {
        List resList = new ArrayList();
	    int sYear = Integer.parseInt(startDate.substring(0,4));
	    int eYear = Integer.parseInt(endDate.substring(0,4));
	    resList = 	getResourceIdsBySortId(carrier2IdList,sYear,eYear, resType);	
	    return resList;
}	
	
	
	public  List getResourceIdsBySortId(List carrier2IdList,int sYear,int eYear,String resType) {
		 List  resList = new ArrayList();
        List resSortList = new ArrayList();
        List  yearList = new ArrayList();
        Map mp = new HashMap();
        String[] types= resType.split(",");
        for (int i =sYear;i<eYear;i++){
        	yearList.add(String.valueOf(sYear));
        }
        for (int i =0;i<types.length;i++){
        	resSortList.add(types[i]);
        }
        
        if(yearList.size()>0) mp.put("yearList",yearList);
        if(resSortList.size()>0) mp.put("resSortList",resSortList);
        
        List ls  = dao.getResourceIdsBySortId(mp);
        

    	for (Iterator it = ls.iterator(); it.hasNext();) {
    		Resource obj = (Resource) it.next();
    		String carrierId = obj.getCarrierId().toString();
//    		 System.out.println("carrierId>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+carrierId) ;		
    		 
    		if(carrier2IdList != null){
    			if(carrier2IdList.contains(carrierId)){
    				resList.add(obj.getId().toString());
    			}
    		}else{
    			resList.add(obj.getId().toString());
    		}

    	}
    	
    	if(resList.size() == 0 )resList.add("-1");
    	
//    	System.out.println("getResourceIdsBySortId>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+resList.size()) ;		

	return resList;
}	
	
	public  List getStoreResourceByOrderId(Resource res) {
        Map mp = new HashMap();
        mp.put("orderId",res.getCarrierId());
        List ls = 	dao.getStoreResourceByOrderId(mp);	
        List resList = StringUtilsv.singleElement(ls);
    	for (Iterator it = resList.iterator(); it.hasNext();) {
    		Resource obj = (Resource) it.next();
    		String lable = ResourceUtil.getResourceName(obj,1);
    		obj.setResourceName(lable);
    	}       
	    return resList;
}	
	
	
	public void getCarrierTypeByParent(CarrierType cType,String version,String orgId,List trees){
		
		CarrierType cTy = new CarrierType();
//		cTy.setOrgId(new Long(orgId));
		cTy.setParentId(cType.getId());
		List ls3 = ServiceLocator.getCarrierTypeDao().getCarrierTypes(cTy);		
		
		Iterator it = ls3.iterator();
		while (it.hasNext()) {
			Map map = new HashMap();
			
			CarrierType ct = (CarrierType) it.next();
			Carrier carrier = new Carrier();
			carrier.setCarrierTypeId(ct.getId());
			carrier.setParentId("0"); 
//			carrier.setEnable(new Boolean(true));
//			carrier.setEnable(new Boolean(true));
			List ls2 = carrierDao.getCarriers(carrier);
			
//			System.out.println("lls2>>>>zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz>>>>>>>>>>"+ls2.size()) ;

			boolean isLeaf = (ls2.size() == 0 && ls3.size() == 0);

			map.put("id", "carrierType_"+ ct.getId());
			map.put("text", ct.getName());
			map.put("leaf", new Boolean(isLeaf));
			map.put("type", "1");
			map.put("realId", ct.getId());
			map.put("version", version);
			map.put("orgId", orgId);
			
			map.put("expanded",  new Boolean(true));

			trees.add(map);			
			
			getCarrierTypeByParent(ct,version,orgId,trees);
		}

	}
	
	
	
	public List getTree(Map searchMap){
		List trees = new ArrayList();
	    String tvName = SysParamUtil.getTvNameParam();
//		boolean industryLevel2Param = SysParamUtil.getIndustryLevel2Param();
//		boolean xmtv = SysParamUtil.isXMTVParam(null);
		String nodeId = StringUtilsv.getNullValue(searchMap.get("realId"),"0");
		String orgId = StringUtilsv.getNullValue(searchMap.get("orgId"),"1");
		String nodeType = StringUtilsv.getNullValue(searchMap.get("nodeType"),"0");
		String nodelevel = StringUtilsv.getNullValue(searchMap.get("nodelevel"),"0");
		String version = StringUtilsv.getNullValue(searchMap.get("version"),"0");
//		String enable = StringUtilsv.getNullValue(searchMap.get("enable"),"0");
		
//		StringUtilsv.printMap(searchMap);
//		System.out.println("version>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+version) ;
		System.out.println("getTree nodeType>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+nodeType) ;
		System.out.println("getTree nodeId>>>>zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz>>>>>>>>>>"+nodeId) ;
	
		if("0".equals(nodeType)&& "0".equals(nodeId)){
			System.out.println("getTree orgId>>>>zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz>>>>>>>>>>"+orgId) ;
			CarrierType cType = new CarrierType();
//			cType.setOrgId(new Long(org.getId().toString()));
			cType.setOrgId(new Long(orgId));
			cType.setParentId(new Long("0"));
			List ls3 = ServiceLocator.getCarrierTypeDao().getCarrierTypes(cType);
//			System.out.println("ls3>>>>zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz>>>>>>>>>>"+ls3.size()) ;
		
			Iterator it = ls3.iterator();
			while (it.hasNext()) {
				Map map = new HashMap();
				
				CarrierType ct = (CarrierType) it.next();
//				Carrier carrier = new Carrier();
//				carrier.setCarrierTypeId(ct.getId());
//				carrier.setParentId("0"); 
//				List ls2 = carrierDao.getCarriers(carrier);
				
//				System.out.println("lls2>>>>zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz>>>>>>>>>>"+ls2.size()) ;

//				boolean isLeaf = (ls2.size() == 0);

//				if (!isLeaf){
//					Map searchMap2 = new HashMap();
//					searchMap2.put("nodeId","0");
//					searchMap2.put("type","2");
////					map.put("children", getTree2(searchMap2,ls2));
////					map.put("childNodesSum", new Integer(ls2.size()));
//				}else{
//					isLeaf = true;
//				}
		
                if(!"hntv".equals(tvName)){
    				map.put("id", "carrierType_"+ ct.getId());
    				map.put("text", ct.getName());
    				map.put("leaf", new Boolean(false));
    				map.put("type", "1");
    				map.put("realId", ct.getId());
    				map.put("version", version);
    				map.put("orgId", orgId);
    				map.put("expanded",  new Boolean(true));
//    				if (!isLeaf) map.put("expanded",  new Boolean(true));
    				trees.add(map);
                }

				
				getCarrierTypeByParent(ct,version,orgId,trees);
				
			}	
			

			
			
			
		}
		
		
		
		
		
		
//		System.out.println("nodeType>>>>yyyyyyyyyyyyyy"+ nodeType +"yyyyyyyyyy>>>>>>>>>>"+"1".equals(nodeType)) ;
//		System.out.println("nodeId>>>>yyyyyyyyyyyyyyyyyy"+ nodeId +"yyyyyy>>>>>>>>>>"+!"0".equals(nodeId)) ;
//		System.out.println("nodelevel>>>>yyyyyyyyyyyyyyyyyyyy"+ nodelevel +"yyyy>>>>>>>>>>"+nodelevel) ;
		
		if(("1".equals(nodeType)||"2".equals(nodeType))&&!"0".equals(nodeId) && "0".equals(nodelevel)){	
			getTree2(trees,nodeType,nodeId,version,orgId);
		}
		
		if("1".equals(nodelevel)&&!"0".equals(nodeId)){	
			getTree3(trees,nodeType,nodeId,orgId);
		}
		
		
		return trees;
	}
	
	
	public List getTree2(List trees,String nodeType,String nodeId,String version,String orgId){
//		List trees = new ArrayList();
		Carrier carrier = new Carrier();
		
		if("1".equals(nodeType)){
			carrier.setCarrierTypeId(new Long(nodeId));
			carrier.setParentId("0"); 
//			carrier.setEnable(new Boolean(true));
//			carrier.setVersion(new Integer(version));
			
		}else{
//			carrier.setCarrierTypeId(new Long(nodeId));
			carrier.setParentId(nodeId); 
			carrier.setVersion(new Integer(version));
		}

		List ls2 = carrierDao.getCarriers(carrier);
		
//		System.out.println("ls2>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+ls2.size()) ;
		
		Iterator it2 = ls2.iterator();
		while (it2.hasNext()) {
			Map map = new HashMap();
			
			Carrier carrier2 = (Carrier) it2.next();
			Carrier carrierPar = new Carrier();
			carrierPar.setParentId(carrier2.getId().toString()); 
//			carrierPar.setEnable(new Boolean(true));
			if("1".equals(nodeType)){
				carrierPar.setVersion(new Integer(version));
			}
			
			
			List ls4 = carrierDao.getCarriers(carrierPar);		

			boolean isLeaf1 = (ls4.size() == 0);
			
			Resource resourcePar= new Resource();
			resourcePar.setCarrierId(carrier2.getId());
//			resourcePar.setEnable(new Boolean(true));
			List ls5 = dao.getResources(resourcePar);
			boolean isLeaf2 = (ls5.size() == 0);
            
			boolean isLeaf = isLeaf1 && isLeaf2;
			
			map.put("id", "carrier_"+carrier2.getId());
			map.put("text", carrier2.getCarrierName());
			map.put("leaf", new Boolean(isLeaf));
			map.put("type", "2");
			map.put("realId", carrier2.getId());
			map.put("version", version);
			map.put("orgId", orgId);
			if(isLeaf1 && !isLeaf2){
				map.put("level", "1");
			}
		
			
	 
//			if (!isLeaf) map.put("expanded",  new Boolean(true));

			trees.add(map);
		}				
		
		
		return trees;
		
	}
	
	

	public List getTree3(List trees,String nodeType,String nodeId,String orgId){

		Resource resourcePar= new Resource();
		resourcePar.setCarrierId(new Long(nodeId));
//		resourcePar.setEnable(new Boolean(true));
//		List ls2 = dao.getResources(resourcePar);
		
		List ls = dao.getResourcesOrderbyBroStartTime(resourcePar);
		List ls2 = StringUtilsv.singleElement(ls);

		
//		System.out.println("ls2>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+ls2.size()) ;
		
		Iterator it2 = ls2.iterator();
		while (it2.hasNext()) {
			Map map = new HashMap();
			Resource resource = (Resource) it2.next();
			
	   		String lable = ResourceUtil.getResourceName(resource,1);
	   		resource.setResourceName(lable);
	
			boolean isLeaf = true;
			map.put("id", resource.getId());
			map.put("text", resource.getResourceName());
			map.put("leaf", new Boolean(isLeaf));
			map.put("type", "3");
			map.put("realId", resource.getId());
			map.put("orgId", orgId);
	 
//			if (!isLeaf) map.put("expanded",  new Boolean(true));

			trees.add(map);
		}				
		
		
		return trees;
		
	}	
	
	
	
	
	public List getResourcesBySort(Resource res){

		
		 Long carrierId = res.getCarrierId() == null?new Long("-1"):res.getCarrierId() ;
		 res.setCarrierId(carrierId);
//		 res.setVersion(res.getVersion());
		 
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  carrierId>>>>>>>>>>"+res.getCarrierId()) ;
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  version >>>>>>>>>>"+res.getVersion()) ;
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  orgId >>>>>>>>>>"+res.getOrgId()) ;
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  getResourceSort >>>>>>>>>>"+res.getResourceSort()) ;
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  getResourceSortId >>>>>>>>>>"+res.toString()) ;
			
		 List ls2 = dao.getResourcesLevelOne(res);
		 
		 System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  size>>>>>>>>>>"+ls2.size()) ;
		 
		 List ls = StringUtilsv.singleElement(ls2);
		 
		 System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  size>>>>>>>>>>"+ls.size()) ;
		 
		 Collections.sort(ls,new ResourceBrostartTimeComparator());
		 
			
			
			for(Iterator it = ls.iterator();it.hasNext();){
				Resource resource = (Resource)it.next();
				
//				String lable =  ResourceUtil.getResourceName(resource,1);
				
				resource.getWorkspan().setBroadStartTimeS(resource.getWorkspan().getBroadcastTimeFormatStart());
				
//				System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  start>>>>>>>>>>"+resource.getWorkspan().getBroadcastStartT()) ;
				
				
				resource.getWorkspan().setBroadEndTimeS(resource.getWorkspan().getBroadcastTimeFormatEnd());
				
				resource.getWorkspan().setBroadcastT(resource.getWorkspan().getBroadcastTimeFormat());
				
				
//				resource.setResourceName(lable);
			}
			return ls;
		
	}
	
	
	
	public List getResourcesBySort2(Resource res){

		
		 Long carrierId = res.getCarrierId() == null?new Long("-1"):res.getCarrierId() ;
		 res.setCarrierId(carrierId);
		 Integer  publishDate = res.getInPublishDate();
//		 res.setVersion(res.getVersion());
		 
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  carrierId>>>>>>>>>>"+res.getCarrierId()) ;
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  version >>>>>>>>>>"+res.getVersion()) ;
//			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  orgId >>>>>>>>>>"+res.getOrgId()) ;
			
//		 List ls2 = dao.getResourcesLevelOne(res);
			
		 List carrierIdList = CarrierUtil.getCarrierIds(carrierId.toString(),"2",res.getLoginUser());
		 
			Resource resParam = new Resource();
			Boolean isSeralized = new Boolean(true);
//			resParam.setCarrierId(carrierId);
			resParam.setIsSeralized(isSeralized)	;	//是否建立出串联单
			resParam.setInPublishDate(publishDate);
			resParam.setEnable(isSeralized); 
			resParam.setCarrierIdList(carrierIdList);
			resParam.setOrderBy(res.getOrderBy());

			
			
			
//			getResourcesLevelOne
		
//			List carrierIdList = CarrierUtil.getCarrierIds(carrierIds,"2",loginUser);
			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  carrierIdList.size()>>>>>>>>>>"+carrierIdList.toString()) ;
			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  carrierId>>>>>>>>>>"+resParam.getCarrierId()) ;
			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  Seralized >>>>>>>>>>"+resParam.getIsSeralized()) ;
			System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  InPublishDate >>>>>>>>>>"+resParam.getInPublishDate()) ;
			List ls = new ArrayList();
		 if(carrierId != null ){
			 if(carrierId.longValue() != -1)
				 ls = dao.getResourcesLevelOne(resParam); 
		 }
		 
		 
		 
		 System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  ls2 size>>>>>>>>>>"+ls.size()) ;
		 
//		 List ls = new ArrayList();
//		 
//			int week = DateUtil.getDaysOfWeek(res.getInPublishDate().intValue());
////			System.out.println("ls >>>>>>>>>>>>>>>>>>>>>>>>>>>>>.. " + ls.size());
//			for(Iterator it = ls2.iterator();it.hasNext();){
//				
//				Resource resource = (Resource)it.next();
//				
//				
////				System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getWorkspan >>>>>>>>>>"+resource.getWorkspan().getBroadcastStartTime()) ;
//				
//				
////				<result property="workspan.beginDate" column="begin_date" nullValue="0"/>
////				<result property="workspan.broadcastStartTime" column="broadcast_start_time" nullValue="0"/>
////				<result property="workspan.broadcastEndTime" column="broadcast_end_time" nullValue="0"/>
////				getWeekConvert(week,resource,ls);
//			}

//		 List ls = StringUtilsv.singleElement(arrangeList);
		 
		 System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy getResourcesBySort  ls size>>>>>>>>>>"+ls.size()) ;
		 
//		 Collections.sort(ls,new ResourceBrostartTimeComparator());
	
//		 getWeekConvert(week,resource,arrangeList);
		 List arrangeList =  new ArrayList();
	
		 int week = DateUtil.getDaysOfWeek(publishDate.intValue());
			
			for(Iterator it = ls.iterator();it.hasNext();){

				Resource resource = (Resource)it.next();
				
				if(getWeekConvert(week,resource)) {

//					String lable =  ResourceUtil.getResourceName(resource,1);
					
					resource.getWorkspan().setBroadStartTimeS(resource.getWorkspan().getBroadcastTimeFormatStart());
					
//					System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy setBroadStartTimeS  start>>>>>>>>>>"+resource.getWorkspan().getBroadStartTimeS()) ;
					
					
					resource.getWorkspan().setBroadEndTimeS(resource.getWorkspan().getBroadcastTimeFormatEnd());
					
					resource.getWorkspan().setBroadcastT(resource.getWorkspan().getBroadcastTimeFormat());
					
					arrangeList.add(resource);
			   
				}
					
					

				
				
//				resource.setResourceName(lable);
			}
			return arrangeList;
		
	}
	
	
	
	
	
	
	public void saveResourceFromOtherYear(String sourceYear,String tagYear){

		DayInfoDao dayInfoDao = ServiceLocator.getDayInfoDao();
		WorkspanDao workspanDao = ServiceLocator.getWorkspanDao();
		CarrierDao carrierDao = ServiceLocator.getCarrierDao();
		PriceDao priceDao = ServiceLocator.getPriceDao();
		

		Map mp = new HashMap();
		Map mpPrice = new HashMap();
		mp.put("version",tagYear);
		
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  start>>>>>>>>>>") ;
		
		//清除旧数据
		dayInfoDao.removeDayInfos(mp);
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  start>>>>>>>>>>1") ;
		workspanDao.removeWorkspans(mp);
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  start>>>>>>>>>>2") ;
		
		
		mpPrice = priceDao.getPriceResRelMap(sourceYear);
//		StringUtilsv.printMap(mpPrice);
		
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  mpPrice>>>>>>>>>>3"+mpPrice.size()) ;
		
		priceDao.removePricesResRel(mp);
		
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  start>>>>>>>>>>3") ;
		dao.removeResources2(mp);
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  start>>>>>>>>>>4") ;
		carrierDao.removeCarriers2(mp);
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  end>>>>>>>>>>");
		
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  sourceYear>>>>>>>>>>" + sourceYear);
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy 清除旧数据  tagYear>>>>>>>>>>"+ tagYear);
		
		//插入新数据
		Carrier carParm = new Carrier();
		carParm.setVersion(new Integer(sourceYear));
		
		List carList = carrierDao.getCarriers(carParm);
		Iterator it1 = carList.iterator();
		
		Map mp_temp = new HashMap();
		List ls_temp = new ArrayList();
		while (it1.hasNext()) {
			Carrier car =(Carrier)it1.next();
			String carParent = car.getParentId();
			Long carId_old = car.getId();
			int onde_level = car.getNodeLevel();
			
//			if(onde_level ==3)
			
			
			
			if(!"0".equals(carParent)){
				
				car.setVersion(new Integer(tagYear));
				car.setCreateDate(new Date());
				car.setId(null);
				Long carId = carrierDao.saveCarrier(car);
				
				mp_temp.put(carId_old,carId);
				if(onde_level ==3) ls_temp.add(car);
					
				
				System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy save carr "+ carId_old +">>>>>>>>>>" +carId) ;
				
				Resource resParam = new Resource();
//				resParam.setEnable(null);
//				resParam.setIsClosed(null);
//				resParam.setIsManual(null);
//				resParam.setIsOverweight(null);
//				resParam.setIsSeralized(null);
//				resParam.setIsValidate(null);

				resParam.setCarrierId(carId_old);
				List lsRes = dao.getResources(resParam);
				
				System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy lsRes.size  >>>>>>>>>>" +lsRes.size()) ;
				
				Iterator it2 = lsRes.iterator();
				
				while (it2.hasNext()) {
					Resource res =(Resource)it2.next();
					Long resId_old = res.getId();
					
					res.setCarrierId(carId);
					res.setVersion(new Integer(tagYear));
					res.setCreateDate(new Date());
					res.setId(null);
					
					Long resId = dao.saveResource(res);
					System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy save Resource "+ resId_old +">>>>>>>>>>" +resId) ;
					
					Object obj = mpPrice.get(resId_old);
					if(obj != null){
						String price_id = (String)obj;
						priceDao.saveResourcePriceRel(resId.toString(),price_id);	
					}

					
					
					Workspan workspan = new Workspan();
					workspan.setResourceId(resId_old);
					List lsWorkSpan = workspanDao.getWorkspans(workspan);
					
					System.out.println("yyyyyyyyyyyy"+ lsWorkSpan.size() +"yyyyyyyyyyyy save res "+ resId_old +">>>>>>>>>>" +resId) ;
					
					Iterator it3 = lsWorkSpan.iterator();
					while (it3.hasNext()) {
						Workspan wspan =(Workspan)it3.next();
						Long wspId_old = wspan.getId();
						wspan.setCarrierId(carId.toString());
						wspan.setResourceId(resId);
						wspan.setVersion(new Integer(tagYear));
						wspan.setCreateDate(new Date());
						wspan.setBeginDate(new Integer(tagYear+"0101"));
						wspan.setEndDate(new Integer(tagYear+"1231"));
						wspan.setId(null);
						
						Long wspId = workspanDao.saveWorkspan(wspan);
						
						
						DayInfo dayInfo = new DayInfo();
						dayInfo.setWorkspanId(wspId_old);
						List listDays = dayInfoDao.getDayInfos2(dayInfo);
						Iterator it4 = listDays.iterator();
//						
//						System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy save work >>>>>>>>>>" +listDays.size()) ;
//						
						DayInfo[] dayInfs = new DayInfo[listDays.size()];
						int i = 0;
						while (it4.hasNext()) {
							DayInfo dayInf =(DayInfo)it4.next();
							
							dayInf.setCarrierId(carId.toString());
							dayInf.setWorkspanId(wspId);
							dayInf.setResourceId(resId);
							dayInf.setVersion(new Integer(tagYear));
							dayInf.setUsed("");
							dayInf.setSpecific("");
							
							
							String publishDate = dayInf.getPublishDate().toString();
							publishDate = publishDate.replaceAll(sourceYear,tagYear);
//							System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy save DayInfo publishDate>>>>>>>>>>"+publishDate) ;
							
							dayInf.setPublishDate(new Integer(publishDate));
							dayInf.setId(null);
							
							dayInfs[i++] = dayInf;
//							dayInfoDao.saveDayInfo(dayInf);
							
							
							
							
						} // end while  it4
						
						dayInfoDao.saveDayInfo2(dayInfs);
						
						
					} // end while it3
					
					
				}// end while it2
			}	// end if		
				
				
				
			}// end while
		
		if(ls_temp.size() >0){
			Iterator it=ls_temp.iterator();
			while(it.hasNext()){
				Carrier car =(Carrier)it.next();
				String parentId = car.getParentId();
				Long parid = (Long)mp_temp.get(new Long(parentId));
				car.setParentId(parid.toString());
				carrierDao.saveCarrier(car);
			}
			
		}

	}
	
	
	
	
	
	 public ParamObj buildParamBy(String strQueryString){
	    	
		    ParamObj paramObj = new ParamObj();
		    
		    String model = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"model"),null));
	        String whereModel = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"whereModel"),null));
	        String orgId =StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"orgId"),null));
	        String loginUser =StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"loginUser"),null));
	        String displayModel =StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"displayModel"),null));


	        String startDate = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value1"),null));
	        String endDate = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value2"),null));
	        String resourceStr = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value3"),null));
	        String userStr = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value4"),null));
	        String customerStr = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value5"),null));
	        String inWeekDates = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value6"),null));
	        String orderCategoryIds = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value7"),null));
	        String seach_type = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value8"),null));
	        
	        String _gobal_colSumUsed = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value9"),null));
	        String _gobal_colSumTotal = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value10"),null));
	        String _gobal_colSumRate = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value11"),null));
	        
	        paramObj.setModel(model);
	        paramObj.setOrgId(orgId);
	        paramObj.setLoginUser(loginUser);
	        paramObj.setWhereModel(whereModel);
	        paramObj.setDisplayModel(displayModel);

	        paramObj.setValue1(startDate);
	        paramObj.setValue2(endDate);
	        paramObj.setValue3(resourceStr);
	        paramObj.setValue4(userStr);
	        paramObj.setValue5(customerStr);
	        paramObj.setValue6(inWeekDates);
	        paramObj.setValue7(orderCategoryIds);
	        paramObj.setValue8(seach_type);
	        
	        paramObj.setValue9(_gobal_colSumUsed);
	        paramObj.setValue10(_gobal_colSumTotal);
	        paramObj.setValue11(_gobal_colSumRate);
	        
	        return paramObj;
	        
	 }
	 
	 private Map getParamMap(ParamObj paramObj){
			
			Map mp = new HashMap();
		
//		System.out.println("paramObj<<<<<<<<<!111111111<<<<<<<<<<"+paramObj);

			  String orgId = paramObj.getOrgId();
			  String loginUser = paramObj.getLoginUser();
			  String whereModel = paramObj.getWhereModel();
			  String displayModel= paramObj.getDisplayModel();
			  
			  String startDate = paramObj.getValue1();
			  String endDate = paramObj.getValue2();
			  String resourceStr = paramObj.getValue3();
			  String userStr = paramObj.getValue4();
			  String customerStr = paramObj.getValue5();
			  String inWeekDates = paramObj.getValue6();
			  String orderCategoryIds = paramObj.getValue7();
			  String seach_type = paramObj.getValue8();
					mp.put("orgId",orgId);
					mp.put("whereModel",whereModel);
//					mp.put("displayModel",displayModel);
					
					mp.put("seachType",seach_type);

					mp.put("startDate",startDate);
					mp.put("endDate",endDate);		
		
		
//				 System.out.println("loginUser<<<<<<<<<!111111111<<<<<<<<<<"+loginUser);
//				 System.out.println("orgId<<<<<<<<<!111111111<<<<<<<<<<"+orgId);
//				 System.out.println("whereModel<<<<<<<<<!111111111<<<<<<<<<<"+whereModel);
//				 System.out.println("displayModel<<<<<<<<<!111111111<<<<<<<<<<"+displayModel);
//				 System.out.println("startDate<<<<<<<<<!111111111<<<<<<<<<<"+startDate);
//				 System.out.println("endDate<<<<<<<<<!111111111<<<<<<<<<<"+endDate);
//				 System.out.println("resourceStr<<<<<<<<<!111111111<<<<<<<<<<"+resourceStr);
//				 System.out.println("userStr<<<<<<<<<!111111111<<<<<<<<<<"+userStr);
//				 System.out.println("customerStr<<<<<<<<<!111111111<<<<<<<<<<"+customerStr);
//				 System.out.println("inWeekDates<<<<<<<<<!111111111<<<<<<<<<<"+inWeekDates);
//				 System.out.println("orderCategoryIds<<<<<<<<<!111111111<<<<<<<<<<"+orderCategoryIds);
				 
		    	if(UserUtil.isUserOrderYearRel()) {
		     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
		     	} 		
		

		
				if(!"".equals(resourceStr) && resourceStr!=null){
					List resourceIdList = new ArrayList();
					CollectionUtils.addAll(resourceIdList,resourceStr.split(","));
					mp.put("resourceIdList",resourceIdList);
					 System.out.println("resourceIdList<<<<<<<<<!222222222<<<<<<<<<<"+resourceIdList);
				}  		
				
				if(!"".equals(userStr)  && userStr!=null){
					List userIdList = new ArrayList();
					CollectionUtils.addAll(userIdList,userStr.split(","));
					mp.put("userIdList",userIdList);
					 System.out.println("userIdList<<<<<<<<<!222222222<<<<<<<<<<"+userIdList);
				} else{
					 System.out.println("userIdList<<<<<< userStr <<<!222222222<<<<<<<<<<"+userStr);
					 System.out.println("userIdList<<<<<<< loginUser <<!222222222<<<<<<<<<<"+loginUser);
					List userIdList =  UserUtil.getOwnerUsersList(loginUser,2);
					System.out.println("userIdList<<<<<< size <<<!222222222<<<<<<<<<<"+userIdList.size());
					mp.put("userIdList",userIdList);
				}
				
				if(!"".equals(customerStr)  && customerStr!=null){
					List customerIdList = new ArrayList();
					CollectionUtils.addAll(customerIdList,customerStr.split(","));
					mp.put("customerIdList",customerIdList);
					 System.out.println("customerIdList<<<<<<<<<!222222222<<<<<<<<<<"+customerIdList);
				}  	
			
				if(!"".equals(inWeekDates) && inWeekDates!=null){
					List inWeekDatesList = new ArrayList();
					DateUtil.getWeekDates(startDate,endDate,inWeekDates,inWeekDatesList);
					mp.put("inWeekDates",inWeekDatesList);
					 System.out.println("inWeekDatesList<<<<<<<<<!222222222<<<<<<<<<<"+inWeekDatesList);
				}  		

				if(!"".equals(orderCategoryIds) && orderCategoryIds!=null){
					List orderCategoryIdList = new ArrayList();
					CollectionUtils.addAll(orderCategoryIdList,orderCategoryIds.split(","));
					mp.put("orderCategoryIdList",orderCategoryIdList);
					 System.out.println("orderCategoryList<<<<<<<<<!222222222<<<<<<<<<<"+orderCategoryIdList);
				}  

		return mp;
	}
	 
	 
	 
	private String getTimeDisplayModel(Integer s,int displayModel){
		
		if(displayModel ==1){
			return DateUtil.converTime(s,1);
		}else{
			return DateUtil.converTime(s,1);
		}
	}
	 
	public Collection getCollectionsForQuery(String queryString, String type,Map printParamMap) throws  Exception{
		
		ParamObj paramObj =  this.buildParamBy(queryString);
		int displayModel = Integer.parseInt(StringUtil.getNullValue(paramObj.getDisplayModel(),"0"));
		int seachType = Integer.parseInt(StringUtil.getNullValue(paramObj.getValue8(),"0"));
		
		String[] _gobal_colSumUsed = paramObj.getValue9().split(",");
		String[] _gobal_colSumTotal = paramObj.getValue10().split(",");
		String[] _gobal_colSumRate = paramObj.getValue11().split(",");
		
		 

		List valuecoll = new ArrayList();
//		Map<String,FusionChartObject> tempMap  = new HashMap<String,FusionChartObject>();
		Map tempMap  = new HashMap();
		Map sumTotalMap = new HashMap();
		Map sumUsedMap = new HashMap();
		Map rateMap = new HashMap();
		
//		DateUtil.converTime
		try {
		
			Map mp = getParamMap(paramObj);

			//key ad_resource_workspan_id value3
			Map resMap  = dao.getResourcesForQuery1(mp);
			ResourceUtil.getADlengthFormWeek(resMap);
			
			List workspanIdList = new ArrayList();
			CollectionUtils.addAll(workspanIdList,resMap.keySet().iterator());
			if(workspanIdList.size()>0) mp.put("workspanIdList",workspanIdList);
			Collection ls  = dao.getResourcesForQuery2(mp);
			
//			 System.out.println("getResourcesForQuery2<<<<<<<<<!222222222<<ls<<<<<<<< 11111111111111111111111111111111111111111111");
			
			ResourceUtil.getSumTotalUsedRateMap(ls,sumTotalMap,sumUsedMap,rateMap,displayModel,seachType);
		
//			 System.out.println("inWeekDatesList<<<<<<<<<!sumTotalMap<<<<<<<<<<"+sumTotalMap.size());
//			 System.out.println("inWeekDatesList<<<<<<<<<!sumUsedMap<<<<<<<<<<"+sumTotalMap.size());
//			 System.out.println("inWeekDatesList<<<<<<<<<!rateMap<<<<<<<<<<"+sumTotalMap.size());
			 
			Iterator it = ls.iterator();
			
			String startDate = paramObj.getValue1();String endDate = paramObj.getValue2();
			
			long days = DateUtil.dateDiff(startDate,endDate,"yyyyMMdd")+1;
			int size = Integer.parseInt(days+"");
			Integer ddays[] = new Integer[size];
			
			Date d = DateUtil.convertStringToDate("yyyyMMdd",startDate);
			
			for(int i = 0;i<size;i++){
				ddays[i] = new Integer(DateUtil.convertDateToString("yyyyMMdd",d));
				d.setDate(d.getDate()+1);
			}
			
			
			
//			System.out.println("inWeekDatesList<<<<<<<<<!days<<<<<<<<<<"+days);
//			System.out.println("inWeekDatesList<<<<<<<<<!ddays<<<<<<<<<<"+ddays.length);
			
			
			while(it.hasNext()){

				FusionChartObject objectDay = (FusionChartObject)it.next();
				
				String key_workSpanId = objectDay.getValue2();
	
				if(!tempMap.containsKey(key_workSpanId)){
					FusionChartObject object = new FusionChartObject();
					List lss = new ArrayList();
					FusionChartObject objectRes = (FusionChartObject)resMap.get(key_workSpanId);
					String brotime = objectRes.getValue4();
					String bro_time =  DateUtil.formatTime(Math.round(Double.parseDouble(brotime)*1000),"h:m");
					
					
					
					
					String bro_pos = objectRes.getValue1()+objectRes.getValue2();
					String total = objectRes.getValue36();
					object.setId(key_workSpanId);
					object.setLable(bro_time);//时间
					object.setValue1(bro_pos);//位置
					object.setSequence(brotime);
					if(displayModel == 1){
						object.setValue2(DateUtil.formatTime(Long.parseLong(total)*1000,"m's\"")); //标准 
					}else{
						object.setValue2(total); //标准 
					}

					object.getColls().add(objectDay);
//					String used = objectDay.getValue5();
//					ResourceUtil.setDayValue(key_workSpanId,i,days,object,used,sumTotalMap,sumUsedMap,rateMap);
					
					tempMap.put(key_workSpanId,object);
				}else{
					FusionChartObject object =  (FusionChartObject)tempMap.get(key_workSpanId);
					object.getColls().add(objectDay);
//					String used = objectDay.getValue5();
//					ResourceUtil.setDayValue(key_workSpanId,i,days,object,used,sumTotalMap,sumUsedMap,rateMap);
			
					tempMap.put(key_workSpanId,object);
				}
				
			}
			
//			 System.out.println("getResourcesForQuery2<<<<<<<<<!222222222<<ls<<<<<<<<22222222222222222222222222222222");
			
			Iterator it2 = tempMap.keySet().iterator();
			while(it2.hasNext()){
				String key_workSpanId = (String)it2.next();
				FusionChartObject object =  (FusionChartObject)tempMap.get(key_workSpanId);
				 List colls = (List)object.getColls();
//				Iterator it3 = colls.iterator();
				
				 Map mpp = ConvertUtil.convertListToMap(colls,"value3");
					
					int i = 3;
					long k = days-1;
					
					for(int j = 0;j<days;j++){
						String key = ddays[j].toString();
						Object obj = mpp.get(key);
						FusionChartObject objectDay  = (obj == null)?new FusionChartObject():(FusionChartObject)obj;
						
						String publishDate = StringUtil.getNullValue(objectDay.getValue3(),"0");
						String dayTotal = StringUtil.getNullValue(objectDay.getValue4(),"0");
						String used = StringUtil.getNullValue(objectDay.getValue5(),"0");
						String used2 = StringUtil.getNullValue(objectDay.getValue5(),"0");
						
						
						 double leave = Double.parseDouble(dayTotal) -  Double.parseDouble(used2);
		
						 
						
						 if(seachType == 2){
							 used = String.valueOf(leave);
							 
//							 System.out.println("seachType<<<<<<<<<!seachType leave<<<<<<<<<<"+used);
						 }
						 
						object.setPublishDate(key); 
						object.setDayTotal(dayTotal);
						
						if(displayModel == 1 && !"report".equals(type)){
							if(leave <0 && seachType == 2){
								used = DateUtil.formatTime(Math.round(Double.valueOf(-leave)*1000),"m's\"");
								used = '-'+used;
							}else{
								used = DateUtil.formatTime(Math.round(Double.parseDouble(used)*1000),"m's\"");
							}
							if("00'00\"".equals(used)) used = "";
						}else{
								if("0.0".equals(used)||"0".equals(used)) used = "";
						}
						
//						System.out.println("seachType<<<<<<<<<!seachType<<<<<<<<<<"+seachType);
						
						
						 
						if("1".equals(type)){
							 used = used +"_"+publishDate+"_"+dayTotal+"_"+used2+"_"+leave; 
						}
//						else if("report".equals(type)){
//							printParamMap.put(object.getLable()+"_"+key,String.valueOf(leave));
//						}
						
						ResourceUtil.setDayValue(key_workSpanId,i++,k--,object,used,sumTotalMap,sumUsedMap,rateMap);
					}

					
					
//					 System.out.println("getResourcesForQuery2<<<<<<<<<!222222222<<ls<<<<<<<<33333333333333333333333333333");


			}
			

//			求合计 打印
			if("report".equals(type)){
				
				FusionChartObject objectDay1 =  new FusionChartObject();
				FusionChartObject objectDay2 =  new FusionChartObject();
				FusionChartObject objectDay3 =  new FusionChartObject();
				
				objectDay1.setSequence("9999990");
				objectDay2.setSequence("9999991");
				objectDay3.setSequence("9999992");
				
				for(int i = 0; i<_gobal_colSumUsed.length;i++){
//					System.out.println("_gobal_colSumUsed<<<<<<<<<33333333333333333333333333333"+_gobal_colSumUsed[i]);
					ResourceUtil.setDayValue2(objectDay1,i,_gobal_colSumUsed[i]);
					ResourceUtil.setDayValue2(objectDay2,i,_gobal_colSumTotal[i]);
					ResourceUtil.setDayValue2(objectDay3,i,_gobal_colSumRate[i]);
				}

				tempMap.put("_gobal_colSumUsed",objectDay1);
				tempMap.put("_gobal_colSumTotal",objectDay2);
				tempMap.put("_gobal_colSumRate",objectDay3);	

			}
		

			List ls11 = new  ArrayList();
			Iterator it3 = tempMap.values().iterator();
			while(it3.hasNext()){
				FusionChartObject objectDay5 = (FusionChartObject)it3.next();
				ls11.add(objectDay5);
			}		
			Collections.sort(ls11,new FusionChartObjectComparator());
			valuecoll.addAll(ls11);

//			valuecoll.addAll(tempMap.values());
//			Collections.sort(valuecoll,new FusionChartObjectComparator());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valuecoll;
	}
	
	

	
	public String getResourcesForQueryXml(String queryString, String type) throws Exception {
		
		   List list = new ArrayList();
		   
//			System.out.println("<<objectDay<<<<<<<<<!queryString<<<<<<<<<<"+queryString);
		       
		   try{
			   list =(List)this.getCollectionsForQuery(queryString,type,null);
					
			 }catch(Exception ex){
		        	throw new Exception("failure:true,msg:"+ ex.getMessage() +"");
		        }
			 
			 
			 String startDate = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(queryString,"value1"),null));
			 String endDate = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(queryString,"value2"),null));
				
			 long days = DateUtil.dateDiff(startDate,endDate,"yyyyMMdd")+2;
			 
			 
//			 System.out.println("<<objectDay<<<<<<<<<!days<<<<<<<<<<"+days);
//			 System.out.println("<<objectDay<<<<<<<<<!list<<<<<<<<<<"+list.size());
			 
//			 System.out.println("<<objectDay<<<<<<<<<!makeXmlForResourcesForQuery<<<<<<<<<<"+ ResourceUtil.makeXmlForResourcesForQuery(list,days));

			 return ResourceUtil.makeXmlForResourcesForQuery(list,days);
	}
	
	
	
	
	public List getResourceCtrData(Resource res) throws Exception {
		String carrierName = res.getResourceName();
		String date  = res.getMemo();
		System.out.println("====== getResourceCtrData date     ======="+res.getMemo());
//		String date ="20130101";

		List data =  new ArrayList();
		String sql ="select id,carrider_name,bro_date,bro_start_time,adv_contents,bro_adv_length from tb_ctr_data where carrider_name='"+carrierName+"' and bro_date="+date;
		ResultSet rs = ServiceLocator.getDao().getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
		
		while (rs.next()){
			CtrData ctrData = new CtrData();
			ctrData.setId(Long.valueOf(rs.getString("id")));
//			sumTotal =  DateUtil.formatTime(Math.round(Double.parseDouble(rs.getString("bro_start_time"))*1000),"h:m:s");
			ctrData.setBroTimeStr(DateUtil.formatTime(Math.round(Double.parseDouble(rs.getString("bro_start_time"))*1000),"h:m:s"));
			ctrData.setBroTime(Integer.valueOf(rs.getString("bro_start_time")));
			ctrData.setAdvContents(rs.getString("adv_contents"));
			ctrData.setBroLength(Integer.valueOf(rs.getString("bro_adv_length")));
			data.add(ctrData);
		}
		rs.close();

//		int total = data.size(); 
//		listRange.setData(data);
//		listRange.setTotalSize(total);
		return data;
	}

	public List getResourcesByIds(String strQueryString){
			
//			String ids,String version,String priceTypeId,String length) 
        String resourceIds = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"resourceIds"),null));
        String version = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"version"),null));
        String priceTypeId = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"priceTypeId"),null));
        String adLength = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"adLength"),null));
		
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		Map mp = new HashMap();
		CollectionUtils.addAll(ls,resourceIds.split(","));

		mp.put("version",version);
		mp.put("resourceIdList",ls);
		mp.put("priceTypeId",priceTypeId);
		mp.put("length",adLength);
		
		return dao.getResourcesByIds(mp);
	}

	public String getResourceXMLforDhtmlTree(String strQueryString) {
		
			Map mp = new HashMap();	
			
			String year =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"year"),"");
			String loginUser =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"loginUser"),"");
			String signUserId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"signUserId"),"");
			String resourceName =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"resourceName"),"");
			String customerName =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"customerName"),""));
			String resourceTypeId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"resourceTypeId"),"");
			String orgId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"orgId"),"1");

			
			String startDate =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"startDate"),"0");
			String endDate =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"endDate"),"0");
			String contractSortId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"contractSortId"),"0");
			String defaultALL =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"defaultALL"),"0");			
			String id =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"id"),"");  
			
			
		

			
			
			String IdPrefix ="carrierType";
			String carrierIdPrefix ="carrier";
			String resourceIdPrefix ="resource";
			boolean fitterCarrier = SysParamUtil.getChannelModelPara();
	
			
			StringBuffer sb = new StringBuffer("");
			if("0".equals(id)){
				OrgDao  orgDao = ServiceLocator.getOrgDao();
				CarrierTypeDao carrierTypeDao = ServiceLocator.getCarrierTypeDao();
				Org org2 = new Org();
				org2.setId(new Long(orgId));
				List ls = orgDao.getOrgs(org2);
				
				System.out.println("ls.size orgDao >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ls.size());

				sb.append("<?xml version=\"1.0\" encoding='UTF-8'?>");
				sb.append("<tree id='"+ id +"'>");
				
				for (Iterator it = ls.iterator();it.hasNext();){
					
					Org org = (Org)it.next();	
					sb.append("<item child='1' text=\""+org.getName()+"\" id=\"root_"+org.getId().toString()+"\" open=\"root_"+org.getId().toString()+"\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\"  >");
					sb.append("<userdata name=\"id\"> "+ org.getId().toString() +"</userdata>");
					sb.append("<userdata name=\"type\">0</userdata>");
					
						CarrierType cType = new CarrierType();
						cType.setOrgId(new Long(org.getId().toString()));
						cType.setParentId(new Long("0"));
						List ls2 = carrierTypeDao.getCarrierTypes(cType);
						Iterator it2 = ls2.iterator();
//						System.out.println("ls2.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ls2.size());
						while (it2.hasNext()) {
							
							CarrierType ct = (CarrierType) it2.next();
							String catypeId =IdPrefix+ ct.getId().toString();
							
		
							
							
//							Carrier carrier = (Carrier)ls3.get(0);	
//                            String openId = "carrierIdPrefix" + carrier.getId().toString();
                            
							sb.append("<item   id='" +catypeId + "' open='" + catypeId + "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""+ ct.getName().toString() + "\">");
							sb.append("<userdata name=\"id\">" + ct.getId().toString()+ "</userdata>");
							sb.append("<userdata name=\"type\">1</userdata>");
							sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
                            
							Carrier car = new Carrier();
							car.setCarrierTypeId(new Long(catypeId));
							car.setParentId("0");
							Map userCarrierRelsIdsMap = new HashMap();
//							List carIds = new ArrayList();
//							if(fitterCarrier){
//								userCarrierRelsIdsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS_ID);
//								carIds = (List)userCarrierRelsIdsMap.get(loginUser);
//							}						
							List ls3 = carrierDao.getCarriers(car);
//							
//							Collections.sort(ls3,new CarrierComparator());		
////							
//							for(Iterator it3 = ls3.iterator();it3.hasNext();){
//									
//								Carrier carrier = (Carrier)it3.next();
//								boolean carEnable = carrier.getEnable().booleanValue();
//								String car_id = carrier.getId().toString();
//								if(fitterCarrier && !carIds.contains(car_id))  carEnable = false;
//
//								 System.out.println(" carrier.getCarrierName().toString()>>>>>>>>>>>>>>>>222222222>>>>>>>>>>>>:"+ carrier.getCarrierName().toString());
//								if(carEnable){
//									sb.append("<item child='1' id='" +carrierIdPrefix + carrier.getId().toString()+ "' im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" text=\"" + carrier.getCarrierName().toString() + "\">");
//									sb.append("<userdata name=\"type\">2</userdata>");
//									sb.append("</item>");  
//								}
//							}
							
							sb.append("</item>");
						}

					sb.append("</item>");
				}			
				
				sb.append("</tree>");
				   return sb.toString();   
			}else{
				Date nowDate = new  Date();
				mp.put("customerName",customerName);
				mp.put("startDate",startDate);
				mp.put("endDate",endDate);
				mp.put("year",year);
				mp.put("orgId",orgId);
				 int childCount = 1;
				 return "<?xml version=\"1.0\"  encoding='UTF-8'?><tree id='2'><item child='1' id='0_0' type='0_0' text='Item 0-0'><userdata name='ud_block'>ud_data</userdata></item><item child='1' id='0_1' type='0_1' text='Item 0-1'><userdata name='ud_block'>ud_data</userdata></item><item child='1' id='0_2' type='0_2' text='Item 0-2'><userdata name='ud_block'>ud_data</userdata></item><item child='1' id='0_3'  type='0_3'  text='Item 0-3'><userdata name='ud_block'>ud_data</userdata></item></tree> ";
					
//				 List pageList = dao.getResourceIdsBySortId(mp);

//				 return this.createDHTMLXML(id,pageList,childCount);
			}
			
			
			
			

			
		
//		   System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>222222222>>>>>>>>>>>>> isFinance:"+isFinance);
		   
//		  
		   
//		   System.out.println("getContractPaymentFormPage>>>>>>>>>>>>>>pageList.size>>>>>>>>>>>>>>> :"+pageList.size());
		    
		   
		  
		   
//		   return "<?xml version=\"1.0\"  encoding='UTF-8'?><tree id='0'><item child='1' id='0_0' type='0_0' text='Item 0-0'><userdata name='ud_block'>ud_data</userdata></item><item child='1' id='0_1' type='0_1' text='Item 0-1'><userdata name='ud_block'>ud_data</userdata></item><item child='1' id='0_2' type='0_2' text='Item 0-2'><userdata name='ud_block'>ud_data</userdata></item><item child='1' id='0_3'  type='0_3'  text='Item 0-3'><userdata name='ud_block'>ud_data</userdata></item></tree> ";
		
		   
//		   return this.createDHTMLXML(id,pageList,childCount);
	}
	
	
	 /**  
     * 生成dhtmlTree的xml文件  
     * @param rootList  
     * @return  
     */  
    private String createDHTMLXML(String id,List rootList,int childCount){   
        StringBuffer buffer = new StringBuffer();   
        buffer.append("<?xml version='1.0' encoding='utf-8'?>\n<tree id=\""+id+"\">\n");   
//        for(int i=0;i<rootList.size();i++){   
//        	TreeNode bean = (TreeNode)rootList.get(i);   
//            //添加主目录   
//            buffer.append("\t<item text=\""+bean.getName()+"\" id=\""+bean.getId()+"\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" ");   
//                //判断是否有子节点,有的话,虚拟一个,强制页面显示有子节点样式   
//            if(!bean.getCount().equals("0")){   
//                buffer.append(" child=\"1\"");   
//            }   
//            buffer.append(">\n");   
//            buffer.append("\t</item>\n");   
////          buffer.append("<item text="+id+"_"+i+" id="+id+"_"+i+"  im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\"></item>");   
//        }   
        buffer.append("</tree> ");   
        return buffer.toString();   
    }  
	
	

}
