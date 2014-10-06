
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.dao.ProAudienceRatDao;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ParamClass;
import com.vriche.adrm.model.ProAudienceRat;
import com.vriche.adrm.service.ProAudienceRatManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;

public class ProAudienceRatManagerImpl extends BaseManager implements ProAudienceRatManager {
    private ProAudienceRatDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProAudienceRatDao(ProAudienceRatDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#getProAudienceRats(com.vriche.adrm.model.ProAudienceRat)
     */
    public List getProAudienceRats(final ProAudienceRat proAudienceRat) {
        return dao.getProAudienceRats(proAudienceRat);
    }
   /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#getProAudienceRatsCount(com.vriche.adrm.model.ProAudienceRat)
     */
    public String getProAudienceRatsCount(final ProAudienceRat proAudienceRat) {
        return dao.getProAudienceRatsCount(proAudienceRat).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#getProAudienceRatsCount(com.vriche.adrm.model.ProAudienceRat)
     */    
	public List getProAudienceRatsPage(final ProAudienceRat proAudienceRat,String pageIndex, String pageSize) {
		return dao.getProAudienceRatsPage(proAudienceRat,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#getProAudienceRatsCount(com.vriche.adrm.model.ProAudienceRat)
     */    
	public String getProAudienceRatsPageXML(final ProAudienceRat proAudienceRat,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    
//	    System.out.println(">>>>>>>>>"+proAudienceRat.getParamClass().toString());
	    
	    List ls = dao.getProAudienceRatsPage(proAudienceRat,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ProAudienceRat obj = (ProAudienceRat)it.next();
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getCarrier().getCarrierName()  +"]]></cell>");
			
//			DateUtil.convertStringToDate("yyyy/MM/dd",obj.getAudienceDate().toString()).toString();
//			sb.append("<cell><![CDATA["+ obj.getAudienceDate()  +"]]></cell>");
			

			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(obj.getAudienceDate().toString(),"yyyy/MM/dd")  +"]]></cell>");
			
			sb.append("<cell><![CDATA["+ DateUtil.formatTime(obj.getAudienceTime().longValue(),"h:m")  +"]]></cell>");
			
//			DateUtil2.FormatDateTime(obj.getAudienceTime().toString(),DateUtil.getDateTimePattern());
			sb.append("<cell><![CDATA["+ obj.getAudienceRat()  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}    

    /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#getProAudienceRat(String id)
     */
    public ProAudienceRat getProAudienceRat(final String id) {
        return dao.getProAudienceRat(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#getProAudienceRatsByIdList(final Map idList)
     */
    public List getProAudienceRatsByMap(final Map mp) {
        return dao.getProAudienceRatsByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#saveProAudienceRat(ProAudienceRat proAudienceRat)
     */
    public String saveProAudienceRat(ProAudienceRat proAudienceRat) {
        return dao.saveProAudienceRat(proAudienceRat).toString();
    }

    /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#removeProAudienceRat(String id)
     */
    public void removeProAudienceRat(final String id) {
        dao.removeProAudienceRat(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ProAudienceRatManager#removeProAudienceRats(String Map)
     */
    public void removeProAudienceRats(final Map mp) {
        dao.removeProAudienceRats(mp);
    }
	public void saveProAudienceRats(final List ls, Map parmap) {
		this.removeProAudienceRats(parmap);
		dao.saveProAudienceRats(ls);
		
	}
	public Collection getCollections(final String queryString,String type) {
		
		ProAudienceRat proAudienceRat = new ProAudienceRat();
		
		String carrierId = StringUtil.getParamFromUrl(queryString,"carrierId");
		String startDate = StringUtil.getParamFromUrl(queryString,"startDate");
		String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
		String startTime = StringUtil.getParamFromUrl(queryString,"startTime");
		String endTime = StringUtil.getParamFromUrl(queryString,"endTime");    
//		String lables = StringUtil.getParamFromUrl(queryString,"header");  
		
//		if(carrierId.equals("0")) carrierId = null;
		
		 System.out.println("carrierId>>>>>>>>"+carrierId);
		 System.out.println("startDate>>>>>>>>"+startDate);		 
		 System.out.println("endDate>>>>>>>>"+endDate);
		 System.out.println("startTime>>>>>>>>"+startTime);
		 System.out.println("endTime>>>>>>>>"+endTime);
		 
		
		ParamClass paramClass = new ParamClass();
		paramClass.setCarrierId(carrierId);
		paramClass.setStartDate(startDate);
		paramClass.setEndDate(endDate);
		paramClass.setStartTime(startTime);
		paramClass.setEndTime(endTime);
		

		proAudienceRat.setParamClass(paramClass);
		
		List ls = getProAudienceRats(proAudienceRat);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 4;
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ProAudienceRat obj = (ProAudienceRat)it.next();
			
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(obj.getCarrier().getCarrierName());break;
						case 2:
							fObject.setValue2(DateUtil.SetDateFormat(obj.getAudienceDate().toString(),"yyyy/MM/dd"));break;
						case 3:
							fObject.setValue3(DateUtil.formatTime(obj.getAudienceTime().longValue(),"h:m"));break;
						case 4:
							fObject.setValue4(obj.getAudienceRat().toString());break;
	
						default :
					}
				}
			}else{
				fObject.setLable(obj.getCarrier().getCarrierName());
				fObject.setValue1(obj.getAudienceRat().toString());
			}

			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	}    
	
	
	public FusionChartObject[] getProAudienceRatChartObjs(String queryString) {
		List ls = (List)this.getCollections(queryString,"chart");
		int size = ls.size();
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
		for(int i = 0 ; i<size;i++ ){
			fusionChartObjects[i] =(FusionChartObject)ls.get(i);
		}
		return fusionChartObjects;
	}
	
	
}
