
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.CarrierTypeManager;
import com.vriche.adrm.service.ResourceTypeManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class CarrierTypeManagerImpl extends BaseManager implements CarrierTypeManager {
    private CarrierTypeDao dao;
    private OrgDao orgDao;
    
 
    private CarrierManager carrierManager;
    
    private ResourceTypeManager resourceTypeManager;
    
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}
	
    /**
	 * @param carrierManager The carrierManager to set.
	 */
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}


	public void setResourceTypeManager(ResourceTypeManager resourceTypeManager) {
		this.resourceTypeManager = resourceTypeManager;
	}	
	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCarrierTypeDao(CarrierTypeDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.CarrierTypeManager#getCarrierTypesByIdList(final Map idList)
     */
    public List getCarrierTypesByIdList(final Map idList) {
        return dao.getCarrierTypesByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.CarrierTypeManager#getCarrierTypes(com.vriche.adrm.adres.model.CarrierType)
     */
    public List getCarrierTypes(final CarrierType carrierType) {
    	
    	
        return dao.getCarrierTypes(carrierType);
    }

    /**
     * @see com.vriche.adrm.adres.service.CarrierTypeManager#getCarrierType(String id)
     */
    public CarrierType getCarrierType(final String id) {
        return dao.getCarrierType(new String(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.CarrierTypeManager#saveCarrierType(CarrierType carrierType)
     */
    public String saveCarrierType(CarrierType carrierType) {

        return dao.saveCarrierType(carrierType).toString();
    }

    /**
     * @see com.vriche.adrm.adres.service.CarrierTypeManager#removeCarrierType(String id)
     */
    public void removeCarrierType(final String id) {
        dao.removeCarrierType(new String(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.CarrierTypeManager#removeCarrierTypes(String Map)
     */
    public void removeCarrierTypes(final Map idList) {
        dao.removeCarrierTypes(idList);
    }

	public String getCarrierTypeXMLFromMapByYear(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year) {
		
//		
//		CarrierType cType = new CarrierType();
//		if(SysParamUtil.useMoreCarrierSortParam()){
//			if(!UserUtil.isSuperUser()){
//				String orgAdminId = UserUtil.getCurrentPrincipalUserId();
//				cType.setCreateBy(new Long(orgAdminId));
//			}
//		}
		
		
		
//		System.out.println(carrierIdPrefix+" 1 "+resourceIdPrefix+" 2 "+IdPrefix);
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告资源\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
				
		getCarrierTypesIdsByParentFromMapByYear(carrierType.getParentId().toString(),sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,year);
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
	}  
	
	
	
	

	
	public String getCarrierTypeXMLFromMapByYear2(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year,boolean isAccountRes) {
//		System.out.println(carrierIdPrefix+" 1 "+resourceIdPrefix+" 2 "+IdPrefix);
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告资源\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
				
		getCarrierTypesIdsByParentFromMapByYear2(carrierType,sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,year,isAccountRes);
		
		
		
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
	}  	
	
	
	private void getCarrierTypesIdsByParentFromMapByYear2(CarrierType carrType, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year,boolean isAccountRes){
		
		CarrierType carrierType = new CarrierType();
		String isin = carrType.getNodePath();
//		判断是否来自嵌套循环
		if("isin".equals(isin)){
			carrierType.setParentId(carrType.getId());
//			carrType.setNodePath(null);
		}else{
			carrierType.setParentId(carrType.getParentId());
		}
//		System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+carrType.getOrgId()); 
		carrierType.setOrgId(carrType.getOrgId());
		List ls =   this.getCarrierTypes(carrierType);
		
 
		
//		List ls =  getAllCarrierTypesFromMap(id);

		for(Iterator it = ls.iterator();it.hasNext();) {
						
			CarrierType ct = (CarrierType) it.next();

			sb.append("<item id='" +IdPrefix
							+ ct.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ ct.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + ct.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
			

			ct.setNodePath("isin");
			getCarrierTypesIdsByParentFromMapByYear2(ct, sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,year,isAccountRes);		
		 
			 
			carrierManager.getCarriersItemsByCarrierTypeIdFromMapByYear2(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,year,isAccountRes);
			

			
			sb.append("</item>");
		}	

} 
	
	
	

    
	public String getCarrierTypeXML(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix) {
//		System.out.println(carrierIdPrefix+" 1 "+resourceIdPrefix+" 2 "+IdPrefix);
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告资源\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
				
		getCarrierTypesIdsByParent(carrierType.getParentId().toString(),sb,IdPrefix,carrierIdPrefix,resourceIdPrefix);
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
	}    
	
//	public String getCarrierTypeXMLForArrange(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String publishDate) {
//		StringBuffer sb = new StringBuffer("");
//		
////		System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"); 
//		
//		
//		sb.append("<?xml version=\"1.0\"?>");
//		sb.append("<tree id=\"0\">");
//		sb.append("<item text=\"广告资源\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
//		sb.append("<userdata name=\"id\">0</userdata>");
//		sb.append("<userdata name=\"type\">0</userdata>");
//		getCarrierTypesIdsByParentForArrange(carrierType.getParentId().toString(),sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,publishDate);
//		sb.append("</item>");
//		sb.append("</tree>");
//
//		return sb.toString();
//	}
	
	private void getCarrierTypesIdsByParent(String id, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix){
				
		CarrierType carrierType = new CarrierType();
		carrierType.setParentId(new Long(id));
		Iterator it = this.getCarrierTypes(carrierType).iterator();
		while (it.hasNext()) {
						
			CarrierType ct = (CarrierType) it.next();

			sb.append("<item id='" +IdPrefix
							+ ct.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ ct.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + ct.getId().toString()+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
						
			getCarrierTypesIdsByParent(ct.getId().toString(), sb,IdPrefix,carrierIdPrefix,resourceIdPrefix);
			
			carrierManager.getCarriersItemsByCarrierTypeId(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix);
			sb.append("</item>");
		}	
	}
	
	
	private List  getAllCarrierTypesFromMap(String id) {

		Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIERTYPE);
		List ls = new ArrayList();
		Object obj = mp.get(id);
		if(obj != null){
			ls = (List)mp.get(id);
		}

		return ls;
	}		
	
	
	private void getCarrierTypesIdsByParentFromMapByYear(String id, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year){
		CarrierType carrierType = new CarrierType();
		carrierType.setParentId(new Long(id));
		List ls =   this.getCarrierTypes(carrierType);
	
//			List ls =  getAllCarrierTypesFromMap(id);

			for(Iterator it = ls.iterator();it.hasNext();) {
							
				CarrierType ct = (CarrierType) it.next();
	
				sb.append("<item id='" +IdPrefix
								+ ct.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ ct.getName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + ct.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">1</userdata>");
				sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
				getCarrierTypesIdsByParentFromMapByYear(ct.getId().toString(), sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,year);
				carrierManager.getCarriersItemsByCarrierTypeIdFromMapByYear(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,year);
				sb.append("</item>");
			}	
	
	}
	

	

	
	public String getCarrierTypeXMLForArrange(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String publishDate) {
		StringBuffer sb = new StringBuffer("");
		
//		System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"); 
		
		
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告资源\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		carrierType.setId(new Long(0));
		getCarrierTypesIdsByParentForArrange(carrierType,sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,publishDate);
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
	}
	
	private void getCarrierTypesIdsByParentForArrange(CarrierType carrType, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String publishDate){
		String tvName = SysParamUtil.getTvNameParam();
//		List ls =  getAllCarrierTypesFromMap(id);
		
		CarrierType carrierType = new CarrierType();
		carrierType.setParentId(carrType.getId());
		carrierType.setOrgId(carrType.getOrgId());
		List ls =   this.getCarrierTypes(carrierType);

		for(Iterator it = ls.iterator();it.hasNext();) {
						
			CarrierType ct = (CarrierType) it.next();

			sb.append("<item id='" +IdPrefix
							+ ct.getId().toString()+ "' "
							+" open='" + ct.getId().toString() 
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ ct.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + ct.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
           
//			System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			
//			if(SysParamUtil.isFZTVParam(tvName)){
//				getResourceTypesIdsByParentByYear(ct.getId().toString(), sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,publishDate);
//			}else{
			
//			System.out.println("carrierIdPrefixvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+carrierIdPrefix);
			
				getCarrierTypesIdsByParentForArrange(ct, sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,publishDate);
				carrierManager.getCarriersItemsByCarrierTypeIdFromMap(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,publishDate,"");
//			}
			
			sb.append("</item>");            
		}	

}
	  

 	

 	
	private void getResourceTypesIdsByParentByYear(String id, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String publishDate){

		Iterator it = resourceTypeManager.getResourceTypes(new ResourceType()).iterator();
		while (it.hasNext()) {
						
			ResourceType rt = (ResourceType) it.next();

			sb.append("<item id='resourceTypeId"
							+ rt.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ rt.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + rt.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");   
			
			
			carrierManager.getCarriersItemsByCarrierTypeIdFromMap(sb,id,carrierIdPrefix,resourceIdPrefix,publishDate,rt.getId().toString());
			
			sb.append("</item>");
		}	
	}
	
	
//	private void getCarrierTypesIdsByParentForArrange(String id, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String publishDate){
//		
//		CarrierType carrierType = new CarrierType();
//		carrierType.setParentId(new Long(id));
//		Iterator it = this.getCarrierTypes(carrierType).iterator();
//		while (it.hasNext()) {
//						
//			CarrierType ct = (CarrierType) it.next();
//
//			sb.append("<item id='" +IdPrefix
//							+ ct.getId().toString()
//							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
//							+ ct.getName().toString() + "\">");
//			sb.append("<userdata name=\"id\">" + ct.getId().toString()
//					+ "</userdata>");
//			sb.append("<userdata name=\"type\">1</userdata>");
//						
//			getCarrierTypesIdsByParentForArrange(ct.getId().toString(), sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,publishDate);
//			
//			carrierManager.getCarriersItemsByCarrierTypeIdForArrange(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,publishDate);
//			sb.append("</item>");
//		}	
//	}

	
	public Map getCarrierTypeSelectItem(CarrierType carrierType) {
		// TODO Auto-generated method stub
		List carrierTypes = this.getCarrierTypes(carrierType);
//		System.out.println(carrierTypes.size());
    	Iterator ite=carrierTypes.iterator();
		Map reply = new LinkedHashMap();
		reply.put("0","= 载体分类 =");
		while(ite.hasNext()){
			
			CarrierType cType=(CarrierType)ite.next();

//			List carriers=dao.getCarriersByCarrier_TypeId(carrierType.getId());
//			Carrier carr =new Carrier();
//			carr.setCarrierTypeId(carrierType.getId());
//			carr.setNodeLevel(nodeLevel);
//			List carriers= dao.getCarriers(carr);
			reply.put(cType.getId(),cType.getName());
         
//			this.getCarriers(carriers,reply,carrierType.getName(),level);
		}
		return reply;
	}

	public String getTreeXMLResourceAnalyze(CarrierType carrierType, String IdPrefix, String carrierIdPrefix, String resourceIdPrefix, String carrierId, String resourceTypeId) {
		
//		System.out.println(carrierIdPrefix+"    x1x    "+carrierId+"    x2x    "+resourceTypeId);
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		
		CarrierType carrType = new CarrierType();

		
		Iterator it = this.getCarrierTypes(carrType).iterator();
		
		while (it.hasNext()) {
			
			CarrierType ct = (CarrierType) it.next();
			sb.append("<item text=\""+ ct.getOrg().getName()+"\" id=\"root"+ct.getId()+"\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
			sb.append("<userdata name=\"id\">0</userdata>");
			sb.append("<userdata name=\"type\">0</userdata>");	
			getCarrierTypesIdById(ct.getId().toString(),sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,carrierId,resourceTypeId);
			sb.append("</item>");
		}
		
		sb.append("</tree>");

		return sb.toString();
	}
	private void getCarrierTypesIdById(String id, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix, String carrierId, String resourceTypeId){
		
		CarrierType carrierType = new CarrierType();
		carrierType.setId(new Long(id));
		Iterator it = this.getCarrierTypes(carrierType).iterator();
		while (it.hasNext()) {
						
			CarrierType ct = (CarrierType) it.next();

			sb.append("<item id='" +IdPrefix
							+ ct.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ ct.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + ct.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
						
//			getCarrierTypesIdsByParent(ct.getId().toString(), sb,IdPrefix,carrierIdPrefix,resourceIdPrefix);
			
			carrierManager.getCarriersResourceAnalyze(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,carrierId,resourceTypeId);
			sb.append("</item>");
		}	
	}
	
	
	
	
	

	public String getUserCarrirXML(CarrierType carrierType, String IdPrefix, String carrierIdPrefix) {
		// TODO Auto-generated method stub
		
//		System.out.println("getOrgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +carrierType.getOrgId());
	
		
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		
		int orgId = new Integer(StringUtil.null2String(carrierType.getOrgId())).intValue();
		
		Org org2 = new Org();
		List ls = new ArrayList();
		
		if(orgId > 0){
			org2.setId(new Long(orgId));
			 ls = orgDao.getOrgs(org2);
		}else{
			if(!UserUtil.isSuperUser()){
				String orgAdminId = UserUtil.getCurrentPrincipalUserId();
				org2.setCreateBy(new Long(orgAdminId));
				 ls = orgDao.getOrgsNew(org2);
			}else{
				 ls = orgDao.getOrgs(org2);
			}

		}
		

		
//		System.out.println("ls.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ls.size());
		
		for (Iterator it = ls.iterator();it.hasNext();){

			
			Org org = (Org)it.next();	
			
			sb.append("<item text=\""+org.getName()+"(广告资源)\" id=\"root"+org.getId().toString()+"\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
			sb.append("<userdata name=\"id\"> "+ org.getId().toString() +"</userdata>");
			sb.append("<userdata name=\"type\">0</userdata>");
			
				CarrierType cType = new CarrierType();
				cType.setOrgId(new Long(org.getId().toString()));
				cType.setParentId(new Long("0"));
				List ls2 = this.getCarrierTypes(cType);
				Iterator it2 = ls2.iterator();
//				System.out.println("ls2.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ls2.size());
				while (it2.hasNext()) {
					
					CarrierType ct = (CarrierType) it2.next();
					
					sb.append("<item id='" +IdPrefix+ ct.getId().toString()+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""+ ct.getName().toString() + "\">");
					sb.append("<userdata name=\"id\">" + ct.getId().toString()+ "</userdata>");
					sb.append("<userdata name=\"type\">1</userdata>");
					sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
					getUserCarrirTypesIdsByParent(ct.getId().toString(),carrierType.getMemo(),sb,IdPrefix,carrierIdPrefix);
					carrierManager.getUserCarriersItemsByCarrierTypeId(sb,ct.getId().toString(),carrierType.getMemo(),carrierIdPrefix);
					sb.append("</item>");
				}

			sb.append("</item>");
			
		}
		
		
		sb.append("</tree>");

		return sb.toString();	
		
		
		
		
		
//		
//		StringBuffer sb = new StringBuffer("");
//		sb.append("<?xml version=\"1.0\"?>");
//		sb.append("<tree id=\"0\">");
//		sb.append("<item text=\"频道\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
//		sb.append("<userdata name=\"id\">0</userdata>");
//		sb.append("<userdata name=\"type\">0</userdata>");
//		
//		String alisnameType = ""+carrierType.getVersion();
////		System.out.println("alisnameType>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +alisnameType);
//		
//		getUserCarrirTypesIdsByParent(carrierType.getParentId().toString(),carrierType.getMemo(),sb,IdPrefix,carrierIdPrefix);
//		sb.append("</item>");
//		sb.append("</tree>");
//
//		return sb.toString();
	}
	private void getUserCarrirTypesIdsByParent(String id, String theUser,StringBuffer sb,String IdPrefix,String carrierIdPrefix){
		
		CarrierType carrierType = new CarrierType();
		carrierType.setParentId(new Long(id));
		Iterator it = this.getCarrierTypes(carrierType).iterator();
		while (it.hasNext()) {
						
			CarrierType ct = (CarrierType) it.next();

			sb.append("<item id='" +IdPrefix
							+ ct.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ ct.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + ct.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
			
			getUserCarrirTypesIdsByParent(ct.getId().toString(),theUser,sb,IdPrefix,carrierIdPrefix);
			
			carrierManager.getUserCarriersItemsByCarrierTypeId(sb,ct.getId().toString(),theUser,carrierIdPrefix);
			sb.append("</item>");
		}	
	}
	
	
	

	public String getTreeXMLForChannel(CarrierType carrierType, String IdPrefix, String carrierIdPrefix, String resourceIdPrefix, int channelModelParam) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告资源\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
			
			getCarrierTypesIdsByParentForChannel(carrierType.getParentId().toString(),sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,channelModelParam);
		
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
	}
	private void getCarrierTypesIdsByParentForChannel(String id, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,int channelModelParam){
		
		CarrierType carrierType = new CarrierType();
		carrierType.setParentId(new Long(id));
		
		Iterator it = this.getCarrierTypes(carrierType).iterator();
		
		while (it.hasNext()) {
			
			CarrierType ct = (CarrierType) it.next();

			sb.append("<item id='" +IdPrefix
							+ ct.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ ct.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + ct.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
				
			    getCarrierTypesIdsByParentForChannel(ct.getId().toString(), sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,channelModelParam);
				carrierManager.getCarriersResourceAnalyzeForChannel(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,channelModelParam);
				
			sb.append("</item>");
		}	
	}

	public String getCarrierTypeXMLByYear(CarrierType carrierType, String IdPrefix, String carrierIdPrefix, String resourceIdPrefix, String year) {
		
		String curUser = UserUtil.getCurrentPrincipalUser();
		String key = curUser+year;
		

			StringBuffer sb = new StringBuffer("");
			sb.append("<?xml version=\"1.0\"?>");
			sb.append("<tree id=\"0\">");
			
			int orgId = new Integer(StringUtil.null2String(carrierType.getOrgId())).intValue();
			Integer enableStr = carrierType.getEnable();
			 Integer fitterCarrierStr = carrierType.getFitterCarrier();
			String loginUser = carrierType.getLoginUser();
			
			boolean isFineRes = "1".equals(StringUtil.getNullValue(carrierType.getIsFineRes(),"0"))?true:false;
			boolean enable = "1".equals(StringUtil.getNullValue(enableStr,"0"))?true:false;
//			boolean fitterCarrier = "1".equals(StringUtil.getNullValue(fitterCarrierStr,"0"))?true:false;
			boolean fitterCarrier = SysParamUtil.getChannelModelPara();
			Org org2 = new Org();
			if(orgId > 0){org2.setId(new Long(orgId));}
			List ls = orgDao.getOrgs(org2);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				
				Org org = (Org)it.next();	
				sb.append("<item text=\""+org.getName()+"\" id=\"root"+org.getId().toString()+"\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\"  >");
				sb.append("<userdata name=\"id\"> "+ org.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"type\">0</userdata>");
				
					CarrierType cType = new CarrierType();
					cType.setOrgId(new Long(org.getId().toString()));
					cType.setParentId(new Long("0"));
					List ls2 = this.getCarrierTypes(cType);
					Iterator it2 = ls2.iterator();
//					System.out.println("ls2.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ls2.size());
					while (it2.hasNext()) {
						
						CarrierType ct = (CarrierType) it2.next();
						String catypeId =IdPrefix+ ct.getId().toString();

						sb.append("<item  id='" + catypeId + "' open='" + catypeId + "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""+ ct.getName().toString() + "\">");
						sb.append("<userdata name=\"id\">" + ct.getId().toString()+ "</userdata>");
						sb.append("<userdata name=\"type\">1</userdata>");
						sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
						
						getCarrierTypesIdsByParentByYear(ct.getId().toString(),sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,year,carrierType.getNodeLevel(),carrierType.getDisplayNo(),carrierType.getMemo(),enable,fitterCarrier,loginUser,isFineRes);
//						System.out.println("getCarrierTypeXMLByYear  ct.getName()>>>>>>>>>>>>>>abc>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +  ct.getName());
						carrierManager.getCarriersItemsByCarrierTypeIdByYear2(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,year,carrierType.getNodeLevel(),carrierType.getDisplayNo(),carrierType.getMemo(),enable,fitterCarrier,loginUser,isFineRes);

//						carrierManager.getCarriersItemsByCarrierTypeIdByYear(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,year,carrierType.getNodeLevel(),carrierType.getDisplayNo());
						sb.append("</item>");
					}

				sb.append("</item>");
			}
			
			sb.append("</tree>");
			
			String rs = sb.toString();
			
			Map mp2 = new HashMap();
			mp2.put(key, rs);
			Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_RESOURCE_TREE, mp2);
		
			return rs;
	

	}
	
	
	public String getCarrierTypeXMLByYear2(CarrierType carrierType, String IdPrefix, String carrierIdPrefix, String resourceIdPrefix, String year) {
		Map mp = new HashMap();
		String curUser = UserUtil.getCurrentPrincipalUser();
		String key = curUser+year;
		

		Object obj1 = Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_RESOURCE_TREE);
		if(obj1 != null){
			 mp =(Map)obj1;
		}else{
			mp.put(Constants.AVAILABLE_CARRIER_RESOURCE_TREE, new HashMap());
		}
		
		
		Object obj = mp.get(key);
		if(obj != null){
			return (String)obj;
		}else{
			StringBuffer sb = new StringBuffer("");
			sb.append("<?xml version=\"1.0\"?>");
			sb.append("<tree id=\"0\">");
			
			int orgId = new Integer(StringUtil.null2String(carrierType.getOrgId())).intValue();
			Integer enableStr = carrierType.getEnable();
			 Integer fitterCarrierStr = carrierType.getFitterCarrier();
			String loginUser = carrierType.getLoginUser();
			
			boolean isFineRes = "1".equals(StringUtil.getNullValue(carrierType.getIsFineRes(),"0"))?true:false;
			boolean enable = "1".equals(StringUtil.getNullValue(enableStr,"0"))?true:false;
//			boolean fitterCarrier = "1".equals(StringUtil.getNullValue(fitterCarrierStr,"0"))?true:false;
			boolean fitterCarrier = SysParamUtil.getChannelModelPara();
			Org org2 = new Org();
			if(orgId > 0){org2.setId(new Long(orgId));}
			List ls = orgDao.getOrgs(org2);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				
				Org org = (Org)it.next();	
				sb.append("<item text=\""+org.getName()+"\" id=\"root"+org.getId().toString()+"\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\"  >");
				sb.append("<userdata name=\"id\"> "+ org.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"type\">0</userdata>");
				
					CarrierType cType = new CarrierType();
					cType.setOrgId(new Long(org.getId().toString()));
					cType.setParentId(new Long("0"));
					List ls2 = this.getCarrierTypes(cType);
					Iterator it2 = ls2.iterator();
//					System.out.println("ls2.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +ls2.size());
					while (it2.hasNext()) {
						
						CarrierType ct = (CarrierType) it2.next();
						String catypeId =IdPrefix+ ct.getId().toString();
						
						
						sb.append("<item  id='" + catypeId + "' open='" + catypeId + "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""+ ct.getName().toString() + "\">");
						sb.append("<userdata name=\"id\">" + ct.getId().toString()+ "</userdata>");
						sb.append("<userdata name=\"type\">1</userdata>");
						sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
						
						getCarrierTypesIdsByParentByYear(ct.getId().toString(),sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,year,carrierType.getNodeLevel(),carrierType.getDisplayNo(),carrierType.getMemo(),enable,fitterCarrier,loginUser,isFineRes);
//						System.out.println("getCarrierTypeXMLByYear  ct.getName()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +  ct.getName());
						carrierManager.getCarriersItemsByCarrierTypeIdByYear2(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,year,carrierType.getNodeLevel(),carrierType.getDisplayNo(),carrierType.getMemo(),enable,fitterCarrier,loginUser,isFineRes);

//						carrierManager.getCarriersItemsByCarrierTypeIdByYear(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,year,carrierType.getNodeLevel(),carrierType.getDisplayNo());
						sb.append("</item>");
					}

				sb.append("</item>");
			}
			
			sb.append("</tree>");
			
			String rs = sb.toString();
			
			Map mp2 = new HashMap();
			mp2.put(key, rs);
			Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_RESOURCE_TREE, mp2);
		
			return rs;
		}

	}
	
	private void getCarrierTypesIdsByParentByYear(String parentId, StringBuffer sb,String IdPrefix,String carrierIdPrefix,String resourceIdPrefix, String year,Integer resourceType,Integer orderBy,String displayCarModerier,boolean enable,boolean fitterCarrier,String loginUser,boolean isFineRes ){
		
		CarrierType carrierType = new CarrierType();
		carrierType.setParentId(new Long(parentId));
		Iterator it = this.getCarrierTypes(carrierType).iterator();
		while (it.hasNext()) {
						
			CarrierType ct = (CarrierType) it.next();

			sb.append("<item id='" +IdPrefix
							+ ct.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ ct.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + ct.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"parentId\">"+ ct.getParentId()+"</userdata>");
						
			getCarrierTypesIdsByParentByYear(ct.getId().toString(), sb,IdPrefix,carrierIdPrefix,resourceIdPrefix,year,resourceType,orderBy,displayCarModerier,enable,fitterCarrier,loginUser, isFineRes );
            
//			System.out.println("getCarrierTypeXMLByYear  ct.getName()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +  ct.getName());
			
			carrierManager.getCarriersItemsByCarrierTypeIdByYear2(sb,ct.getId().toString(),carrierIdPrefix,resourceIdPrefix,year,resourceType,orderBy,displayCarModerier,enable,fitterCarrier,loginUser,isFineRes);
			
			sb.append("</item>");
		}	
	}

	

	
	
	
	public Map getCarrierTypeByLoginUser(String loginUser,int all){
		Map reply = new LinkedHashMap();
		Map mp1 = new HashMap();
		List ls = new ArrayList();
		
		Map mp =(Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_SORT_MAP);
			
		Object  obj1    = mp.get(loginUser);
		if(obj1 != null)mp1 = (Map)obj1;

	    Object[]   key1   =     mp1.keySet().toArray();  
	    Arrays.sort(key1);  

				
		 for   (int   i   =   0;   i   <   key1.length;   i++)   {  

					String key= (String)key1[i];
					String[] keys = key.split("_");
					String id = keys[0];String name = keys[1];
					Object obj = mp1.get(key);
					if(obj !=null) ls = (List)obj;
					if(ls.size() > 0 ) id = id+"_"+ StringUtils.join(ls.toArray(),",");
//					System.out.println("id>>>>>>>>" +StringUtils.join(ls.toArray(),","));
					System.out.println("id>>>>>>>>" +id);
					System.out.println("name>>>>>>>>" +name);
					reply.put(id,name);		    	  
 
	       }   
	         
				



		return reply;
	}
	
	

	public Map getCarrierTypeByLoginUser_bak(String loginUser,int all){
		Map reply = new LinkedHashMap();
		
		
		int orgId =0;
//		int orgId = new Integer(StringUtil.null2String(loginUser)).intValue();
		
		Org org2 = new Org();
		List ls = new ArrayList();
		
		if(SysParamUtil.useMoreCarrierSortParam()){
			if(!UserUtil.isSuperUser()){
				if(orgId > 0){
					org2.setId(new Long(orgId));
					 ls = orgDao.getOrgs(org2);
				}else{
					String orgAdminId = UserUtil.getCurrentPrincipalUserId();
					org2.setCreateBy(new Long(orgAdminId));
					 ls = orgDao.getOrgsNew(org2);
				}

			}else{
				 ls = orgDao.getOrgs(org2);
			}
			   
		}else{
			    ls = orgDao.getOrgs(org2);
		}
		
		
		
		for (Iterator it = ls.iterator();it.hasNext();){
			Org org = (Org)it.next();	
			Long id = org.getId();
			String name = org.getName();
			System.out.println("id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +id);
			System.out.println("name>>>>>>>>>>>>>>>>>>" +name);
			
			reply.put(id,name);
		}

		return reply;
	}


	
	public List getTreeForJosin(TreeNode node,CarrierType carrierType){
		List trees = new ArrayList();

		
		 Long orgId = carrierType.getOrgId();
		String parentNodeId = node.getNodeId();
		
		if(log.isDebugEnabled()){
			log.info("getTreeForJosin getCustomerCateByUserObj parentId>>>>>>>>>>>>>>>"+node.getNodeId());
			log.info("getTreeForJosin getCustomerCateByUserObj getNodeType>>>>>>>>>>>>>>>"+node.getNodeType());
			log.info("getTreeForJosin getCustomerCateByUserObj getNodelevel>>>>>>>>>>>>>>>"+node.getNodelevel());
			log.info("getTreeForJosin getCustomerCateByUserObj getOrgId>>>>>>>>>>>>>>>"+ carrierType.getOrgId());
	
		}
		
		
		if("0".equals(node.getNodelevel())){
				List ls2 = this.getCarrierTypes(carrierType);
				Iterator it2 = ls2.iterator();
				while (it2.hasNext()) {
					CarrierType ct = (CarrierType) it2.next();
				    Map map = new HashMap();
					map.put("id",ct.getId().toString());
					map.put("text", ct.getName());
					map.put("type",node.getNodeType());
					map.put("level","1");
					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
					map.put("iconCls","x-tree-node-icon");
					map.put("leaf", Boolean.valueOf(false));	
					trees.add(map);
				 }
			   	
		}else{
			
			Carrier carrier = new Carrier();
			carrier.setCarrierTypeId(new Long(parentNodeId));
			carrier.setParentId("0");
			List ls2 = carrierManager.getCarriers(carrier);
			Iterator it2 = ls2.iterator();
			while (it2.hasNext()) {
				Carrier car =  (Carrier) it2.next();
			    Map map = new HashMap();
				map.put("id",car.getId().toString());
				map.put("text", car.getCarrierName());
				map.put("type",node.getNodeType());
				map.put("level","1");
				map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
				map.put("iconCls","x-tree-node-icon");
				map.put("leaf", Boolean.valueOf(true));	
				trees.add(map);
			  
		   }
			

			
		}
		
		
		return trees;
	}	
	
	
}


