package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.Workspan;

public class CarrierDaoiBatis extends BaseDaoiBATIS implements CarrierDao {
	StringBuffer sbCarrierType = new StringBuffer("");

	StringBuffer sbCarrierItem = new StringBuffer("");

	StringBuffer sbResourceItem = new StringBuffer("");

	StringBuffer sbResourceDetail = new StringBuffer("");

	//	StringBuffer sbCarrierIds = new StringBuffer("");
	//	Map carrierIdsMap = new HashMap();
	//	Map resourceIdsMap = new HashMap();

	List carrierIdList = new ArrayList();

	List resourceIdList = new ArrayList();
	
	List workSpanceIdList = new ArrayList();

	/**
	 * @see com.vriche.adrm.adres.dao.CarrierDao#getCarriers(com.vriche.adrm.adres.model.Carrier)
	 */
	public List getCarriers(Carrier carrier) {
			
		return getSqlMapClientTemplate().queryForList("getCarriers", carrier);
	}

	public String getCarriersTypeXml(String parentId) {
		StringBuffer sb = new StringBuffer("");
		sbCarrierType.delete(0, sbCarrierType.length());

		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告资源\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"type\">0</userdata>");
		sb.append(getCarriersTypeByParentId(parentId));
		sb.append("</item>");
		sb.append("</tree>");
		
		return new String(sb.toString());
	}

	//获得资源信息
	private String getCarriersTypeByParentId(String parentId) {

		List ls = getSqlMapClientTemplate().queryForList("getCarrierTypesByParentId", parentId);
		
		Iterator it = ls.iterator();
		
		while (it.hasNext()) {
			CarrierType carrierType = (CarrierType) it.next();
			sbCarrierType
					.append("<item id='ct"
							+ carrierType.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carrierType.getName().toString() + "\">");
			sbCarrierType.append("<userdata name=\"type\">1</userdata>");
			sbCarrierType.append("<userdata name=\"carrierTypeId\">"
					+ carrierType.getId() + "</userdata>");
			
			getCarriersTypeByParentId(carrierType.getId().toString());

			sbCarrierItem.delete(0, sbCarrierItem.length());
			String Carriers = getCarriersByCarrierTypeId(carrierType.getId()
					.toString());
			sbCarrierType.append(Carriers);
			sbCarrierType.append("</item>");
		}

		return sbCarrierType.toString();

	}
	public List getCarriersByCarrier_TypeId(Long CarrierTypeId){
		return getSqlMapClientTemplate().queryForList(
				"getCarriersByCarrierTypeId", CarrierTypeId.toString());	
	}

	public String getCarriersXml(String parentId) {
		StringBuffer sb = new StringBuffer("");
		sbCarrierItem.delete(0, sbCarrierItem.length());

		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"广告资源\" id=\"books\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"type\">2</userdata>");
		sb.append(getCarrierByParentId(parentId));
		sb.append("</item>");
		sb.append("</tree>");
		
		return new String(sb.toString());
	}

	//通过载体分类查找 载体
	public String getCarriersByCarrierTypeId(String CarrierTypeId) {
		List ls = getSqlMapClientTemplate().queryForList(
				"getCarriersByCarrierTypeId", CarrierTypeId);
		Iterator it = ls.iterator();

		while (it.hasNext()) {
			Carrier carr = (Carrier) it.next();
			sbCarrierItem
					.append("<item id='ca"
							+ carr.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carr.getCarrierName().toString() + "\">");
			sbCarrierItem.append(getUserdataCarrier(carr));
			//载体不要多级别
			getCarrierByParentId(carr.getId().toString());
			//载体下的广告资源信息
			sbResourceItem.delete(0, sbResourceItem.length());
			String resInfo = getResourceByCarrierId(carr.getId().toString());
			sbCarrierItem.append(resInfo);
			sbCarrierItem.append("</item>");
		}
		return sbCarrierItem.toString();
	}

	//通过父亲找孩子
	//userdata type 0是根    1、载体分类 2、是载体  3、是资源分类 4、是资源
	private String getCarrierByParentId(String parentId) {

		List ls = getSqlMapClientTemplate().queryForList(
				"getCarriersByParentId", parentId);
		Iterator it = ls.iterator();

		while (it.hasNext()) {
			Carrier carr = (Carrier) it.next();
			sbCarrierItem
					.append("<item id='ca"
							+ carr.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ carr.getCarrierName().toString() + "\">");
			//设置载体信息
			sbCarrierItem.append(getUserdataCarrier(carr));
			getCarrierByParentId(carr.getId().toString());
			//载体下的广告资源信息
			sbResourceItem.delete(0, sbResourceItem.length());
			String resInfo = getResourceByCarrierId(carr.getId().toString());
			sbCarrierItem.append(resInfo);
			sbCarrierItem.append("</item>");
		}
		return sbCarrierItem.toString();
	}

	private String getUserdataCarrier(Carrier carr) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<userdata name=\"type\">2</userdata>");
		sb.append("<userdata name=\"carrierId\">" + carr.getId()
				+ "</userdata>");
		sb.append("<userdata name=\"carrierName\">" + carr.getCarrierName()
				+ "</userdata>");
		sb.append("<userdata name=\"aliasName\">" + carr.getAliasName()
				+ "</userdata>");
		sb.append("<userdata name=\"enable\">" + carr.getEnable()
				+ "</userdata>");
		sb.append("<userdata name=\"carrierTypeId\">" + carr.getCarrierTypeId()
				+ "</userdata>");
		sb.append("<userdata name=\"channelId\">" + carr.getChannelId()
				+ "</userdata>");
		sb.append("<userdata name=\"mediaOrgId\">" + carr.getMediaOrgId()
				+ "</userdata>");
		sb.append("<userdata name=\"parentId\">" + carr.getParentId()
				+ "</userdata>");

		return sb.toString();
	}

	//获得资源信息
	private String getResourceByCarrierId(String carrierId) {

		List ls = getSqlMapClientTemplate().queryForList("getResourcesByCarrierIdParent0", carrierId);
		Iterator it = ls.iterator();

		while (it.hasNext()) {
			Resource resource = (Resource) it.next();
			sbResourceItem.append("<item id='re" + resource.getId().toString()
					+ "' text=\"" + resource.getResourceName().toString()
					+ "\">");
			sbResourceItem.append("<userdata name=\"type\">4</userdata>");
			sbResourceItem.append("<userdata name=\"resourceId\">"
					+ resource.getId() + "</userdata>");
			sbResourceItem.append("<userdata name=\"carrierId\">"
					+ resource.getCarrierId() + "</userdata>");
			sbResourceDetail.delete(0, sbResourceDetail.length());
			sbResourceItem.append(getResourceByParentId(carrierId, resource
					.getId().toString()));
			sbResourceItem.append("</item>");
		}
		return sbResourceItem.toString();

	}

	private String getResourceByParentId(String carrierId, String parentId) {
		Map mp = new HashMap();
		mp.put("carrierId", carrierId);
		mp.put("parentId", parentId);

		List ls = getSqlMapClientTemplate().queryForList(
				"getResourceByParentId", mp);
		Iterator it = ls.iterator();

		while (it.hasNext()) {
			Resource resource = (Resource) it.next();
			sbResourceDetail.append("<item id='re"
					+ resource.getId().toString() + "' text=\""
					+ resource.getResourceName().toString() + "\">");
			sbResourceDetail.append("<userdata name=\"type\">4</userdata>");
			sbResourceDetail.append("<userdata name=\"resourceId\">"
					+ resource.getId() + "</userdata>");
			sbResourceDetail.append("<userdata name=\"carrierId\">"
					+ resource.getCarrierId() + "</userdata>");
			getResourceByParentId(carrierId, resource.getId().toString());
			sbResourceDetail.append("</item>");
		}
		return sbResourceDetail.toString();

	}

	/**
	 * @see com.vriche.adrm.adres.dao.CarrierDao#getCarriersByIdList(com.vriche.adrm.adres.model.Carrier)
	 */
	public List getCarriersByIdList(final Map idList) {
		return getSqlMapClientTemplate().queryForList("getCarriersByIdList",idList);
	}

	/**
	 * @see com.vriche.adrm.adres.dao.CarrierDao#getCarrier(Long id)
	 */
	public Carrier getCarrier(Long id) {
		Carrier carrier = (Carrier) getSqlMapClientTemplate().queryForObject(
				"getCarrier", id);

		if (carrier == null) {
			throw new ObjectRetrievalFailureException(Carrier.class, id);
		}

		return carrier;
	}

	/**
	 * @see com.vriche.adrm.adres.dao.CarrierDao#saveCarrier(Carrier carrier)
	 */
	public Long saveCarrier(final Carrier carrier) {
		Long id = carrier.getId();
		// check for new record
		if (id == null || id.intValue() == 0 || id.intValue() == -1) {
			id = (Long) getSqlMapClientTemplate().insert("addCarrier", carrier);
		} else {
			getSqlMapClientTemplate().update("updateCarrier", carrier);
		}
		//        if( id == null ) {
		//            throw new ObjectRetrievalFailureException(Carrier.class, id);
		//        }
		return id;
	}

	/**
	 * @see com.vriche.adrm.adres.dao.CarrierDao#removeCarrier(Long id)
	 */
	public void removeCarrier(Long id) {
		
		List ls = getCarrierIds(id);
		
		if (ls.size() > 1){
			Map mp = new HashMap();
			mp.put("CarrierIdList", ls);
		    this.removeCarriers(mp);
		}

		getSqlMapClientTemplate().update("deleteCarrier", id);
	}

	private List getCarrierIds(Long id) {
		carrierIdList.clear();
		carrierIdList.add(id);
		getCarrierIdsByParnetId(id);
		removeResourceByCarrierId(carrierIdList);
		return carrierIdList;
	}

	private void getCarrierIdsByParnetId(Long parentId) {
		List ls = getSqlMapClientTemplate().queryForList(
				"getCarriersByParentId", parentId);
		Iterator it = ls.iterator();
		while (it.hasNext()) {
			Carrier carrier = (Carrier) it.next();
			carrierIdList.add(carrier.getId());
			getCarrierIdsByParnetId(carrier.getId());
		}
	}

	private void removeResourceByCarrierId(List ls) {
		Iterator it = ls.iterator();
		
		resourceIdList.clear();

		while (it.hasNext()) {
			Long carrierId = (Long) it.next();
			getResourceIdByCarrierId(carrierId);
		}
		//删除资源
		if(resourceIdList.size()>0){
			Map mp = new HashMap();
			Map mpWks = new HashMap();
			mp.put("ResourceIdList", resourceIdList);
			
			//删除有效信息
			workSpanceIdList.clear();
			getWorkSpanceIdByResourceIds(resourceIdList);
	    	if (workSpanceIdList.size()>0){
	        	mpWks.put("WorkspanIdList",workSpanceIdList);
	        	getSqlMapClientTemplate().update("deleteDayInfoByworkspanIdList", mpWks);
	        	getSqlMapClientTemplate().update("deleteWorkspans", mpWks);
	    	}
			
//	    	删除资源价格关系
	    	getSqlMapClientTemplate().update("deletePriceResourceRelByResourceIdList", mp);
//	    	删除资源	    	
			getSqlMapClientTemplate().update("deleteResources", mp);
		}

	}
	

	private void getResourceIdByCarrierId(Long carrierId) {
		List ls = getSqlMapClientTemplate().queryForList(
				"getResourcesByCarrierId", carrierId);
		
		Iterator it = ls.iterator();
		
		while (it.hasNext()) {
			Resource resource = (Resource) it.next();
			resourceIdList.add(resource.getId());
			getResourceIdsByParent(resource.getId());
		}
	}

	private void getResourceIdsByParent(Long parentId) {
		List ls = getSqlMapClientTemplate().queryForList(
				"getResourceByParentId", parentId);
		Iterator it = ls.iterator();
		while (it.hasNext()) {
			Resource resource = (Resource) it.next();
			resourceIdList.add(resource.getId());
			getResourceIdsByParent(resource.getId());
		}

	}
	
	   private void getWorkSpanceIdByResourceIds(List rsList){
	    	Iterator it  = rsList.iterator();
	    	while(it.hasNext()){
	    		List ws =  getSqlMapClientTemplate().queryForList("getWorkspanByResourceId", (Long)it.next());
	    		setWorkSpanceIdList(ws);
	    	}
	    	
	    }
	    
	    private void setWorkSpanceIdList(List wsList){ 
	    	Iterator it  = wsList.iterator();
	    	while(it.hasNext()){
	    		Workspan workspan = (Workspan)it.next();
	    		workSpanceIdList.add(workspan.getId());
	    	}
	    	
	    }
	    

	/**
	 * @see com.vriche.adrm.order.dao.CarrierDAO#removeCarriers(String ids)
	 */
	public void removeCarriers(final Map idList) {
		getSqlMapClientTemplate().update("deleteCarriers", idList);
	}
	
	public void removeCarriers2(final Map idList) {
		getSqlMapClientTemplate().update("deleteCarriers2", idList);
	}

	public List getCarrierForChannel(Carrier carrier) {
		// TODO Auto-generated method stub 
//		Carrier carrier1 = (Carrier) getSqlMapClientTemplate().queryForObject("getCarrierForChannel", carrier);
		List ls=getSqlMapClientTemplate().queryForList("getCarrierForChannel", carrier.getNodeLevel());
		return ls;
	}

	public List getCarrierInfo(Map mp) {

		return getSqlMapClientTemplate().queryForList("getCarrierInfo", mp);
	}

	public List getCarrierWithChannel(Carrier carrier) {
		// TODO Auto-generated method stub 
//		Carrier carrier1 = (Carrier) getSqlMapClientTemplate().queryForObject("getCarrierForChannel", carrier);
		List ls = getSqlMapClientTemplate().queryForList("getCarrierWithChannel", carrier);
		return ls;
	}	
	
	public Map getCarrierWithChannelMap(Carrier carrier) {
		Map mp = getSqlMapClientTemplate().queryForMap("getCarrierWithChannel", carrier,"id");
		return mp;
	}	

}
