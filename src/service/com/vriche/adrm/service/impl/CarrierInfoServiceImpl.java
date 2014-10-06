package com.vriche.adrm.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.CarrierInfoService;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;



public class CarrierInfoServiceImpl implements CarrierInfoService {
	


	public String getCarrierInfo(String orgId) {
		
		Map mp = new HashMap();
		StringBuffer sb = new StringBuffer();
		
		String newline = "\r\n";

		mp.put("orgId",orgId);
		mp.put("nodeLevel","1");

		List ls = ServiceLocator.getCarrierDao().getCarrierInfo(mp);


		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append(newline);
		sb.append("<Import>");
		sb.append(newline);
		for(Iterator it = ls.iterator();it.hasNext();){
			Carrier carr = (Carrier) it.next();
			sb.append("<Carrier id=\""+ carr.getId()+"\" name=\""+ carr.getCarrierName()+"\"  aliasName=\""+ carr.getAliasName()+"\"/>");
			sb.append(newline);
		}
		sb.append("</Import>");
		
		return sb.toString();
	}
	
	
	public String getResourceInfo(String year) {
		
		Map mp = new HashMap();
		StringBuffer sb = new StringBuffer();
		
		String newline = "\r\n";

//		mp.put("orgId",orgId);
//		mp.put("carrierId",carrierId);
		mp.put("year",year);

		List ls = ServiceLocator.getResourceDao().getResourceInfoForWebService(mp);
//		<Import>		
//		<Resource id="2407" memo="XW9"  name="新闻航班"  carrierId="48"/>
//		<Resource id="2408" memo="XW10"  name="一路阳光一路歌"  carrierId="48"/>
//		</Import>


		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append(newline);
		sb.append("<Import>");
		sb.append(newline);
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource resource = (Resource) it.next();
			String resourceId = StringUtil.getNullValue(resource.getId(),"");
			String resourceName = StringUtil.getNullValue(resource.getResourceName(),"");
			String resourceMemo = StringUtil.getNullValue(resource.getMemo(),"");
			String carrierId = StringUtil.getNullValue(resource.getCarrierId(),"");
			String carrierNameMain = StringUtil.getNullValue(resource.getCarrier().getCarrierName(),"");
			String carrierNameMainAliasName = StringUtil.getNullValue(resource.getCarrier().getAliasName(),"");

//			sb.append("<Resource id=\""+ resourceId+"\" memo=\""+ resourceMemo+"\"  resourceNam=\""+ resourceName +"\"  carrierId=\""+ carrierId+"\"  carrierNameMain=\""+ carrierNameMain +"\"  carrierNameMainAliasName=\""+ carrierNameMainAliasName+"\"/>");
			sb.append("<Resource id=\""+ resourceId+"\" memo=\""+ resourceMemo+"\"  name=\""+ resourceName +"\"  carrierId=\""+ carrierId+"\"/>");
			
			sb.append(newline);
		}
		sb.append("</Import>");
		
		return sb.toString();
	}


}
