
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.oscache.util.StringUtil;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.CompagesDao;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Compages;
import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.CompagesManager;
import com.vriche.adrm.util.ConvertUtil;

public class CompagesManagerImpl extends BaseManager implements CompagesManager {
    private CompagesDao dao;
    
    private ResourceDao resourceDao;

    private PriceDao priceDao;
    
    private PriceDetailDao priceDetailDao;
    
    private CarrierDao carrierDao;
 
    
    private final Log logger = LogFactory.getLog(getClass());
    
	/**
	 * @param priceDetailDao The priceDetailDao to set.
	 */
	public void setPriceDetailDao(PriceDetailDao priceDetailDao) {
		this.priceDetailDao = priceDetailDao;
	}



	/**
	 * @param carrierDao The carrierDao to set.
	 */
	public void setCarrierDao(CarrierDao carrierDao) {
		this.carrierDao = carrierDao;
	}



	/**
	 * @param resourceDao The resourceDao to set.
	 */
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}



	/**
	 * @param priceDao The priceDao to set.
	 */
	public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}



	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCompagesDao(CompagesDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.CompagesManager#getCompagessByIdList(final Map idList)
     */
    public List getCompagessByIdList(final Map idList) {
        return dao.getCompagessByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.CompagesManager#getCompagess(com.vriche.adrm.adres.model.Compages)
     */
    public List getCompagess(final Compages compages) {
    	List ls = dao.getCompagess(compages);
    	List lsNew = getResources(ls);
        return lsNew;
    }

    /**
     * @see com.vriche.adrm.adres.service.CompagesManager#getCompages(String id)
     */
    public Compages getCompages(final String id) {
		Compages compages = dao.getCompages(new Long(id));
		compages.setResources(getResources(id));
        return compages;
    }
    
    public Compages getCompage(final String id) {
    	return dao.getCompages(new Long(id));
    }
    
    private Set getResources(String compagesId){
		Set res = new HashSet();
		List ls = resourceDao.getResourcesByCompagesId(new Long(compagesId));
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource resource = (Resource) it.next();
			res.add(resource);
		}
		return res;
    }
    
    private List getResources(List compagesList){
    	List ls = new ArrayList();
		for(Iterator it = compagesList.iterator();it.hasNext();){ 	
			Compages compages = (Compages)it.next();
			compages.setResources(getResources(compages.getId().toString()));
			ls.add(compages);
		}
		return ls;
    }

    /**
     * @see com.vriche.adrm.adres.service.CompagesManager#saveCompages(Compages compages)
     */
    public void saveCompages(Compages compages) {
        dao.saveCompages(compages);
    }


     /**
     * @see com.vriche.adrm.adres.service.CompagesManager#removeCompagess(String Map)
     */
    public void removeCompagess(final Map idList) {
        dao.removeCompagess(idList);
    }

	public String getCompagessXML(Compages compages, String IdPrefix,String resourceIdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
//		sb.append("<item text=\"套装方案\" id=\"root1\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<item text=\"套装方案\" id=\"root1\"  open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" >");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		sb.append("<userdata name=\"priceId\">0</userdata>");
		getCompagesById(compages,sb,IdPrefix,resourceIdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
//		System.out.println("getCustomersXML:>>>>>>>>>>" + sb.toString());
		return sb.toString();
	}   
	          
	private void getCompagesById(Compages compages,StringBuffer sb,String IdPrefix,String resourceIdPrefix){
		   
		List ls = dao.getCompagess(compages);
		Map mp = new HashMap();
		
		
		for(Iterator it = ls.iterator();it.hasNext();) {

			Compages cp = (Compages) it.next();
			
			Long priceId = new Long(com.vriche.adrm.util.StringUtil.getNullValue(cp.getPriceId(),"0"));
			Long priceTypeId =  new Long(com.vriche.adrm.util.StringUtil.getNullValue(cp.getPriceTypeId(),"0"));
			Long id = new Long(com.vriche.adrm.util.StringUtil.getNullValue(cp.getId(),"0"));
			if(!mp.containsKey(id)){
				mp.put(id,id);
//				System.out.println("id===="+ cp.getId().toString());
//				System.out.println("priceId===="+priceId);
//				System.out.println("priceTypeId===="+priceTypeId);
//				System.out.println("priceId111===="+priceId.toString());
				priceId = priceId == null || priceId.intValue()==0 || priceId.toString().equals("0")?new Long(0):priceId;
//				System.out.println("priceId111===="+priceId.toString());
				sb.append("<item id='" +IdPrefix
								+ cp.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ cp.getName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + cp.getId().toString()
						+ "</userdata>");
				sb.append("<userdata name=\"type\">1</userdata>");
				sb.append("<userdata name=\"priceId\">" + priceId.toString()+ "</userdata>");
				sb.append("<userdata name=\"priceTypeId\">" + priceTypeId.toString()+ "</userdata>");
				getResourceByCompageId(cp.getId().toString(), sb,resourceIdPrefix);
				sb.append("</item>"); 
			}

//			

		}
	}
	
	private void getResourceByCompageId(String id,StringBuffer sb,String resourceIdPrefix){
				
		List ls = resourceDao.getResourcesByCompagesId(new Long(id));


		for(Iterator it = ls.iterator();it.hasNext();) {
			
			Resource res = (Resource) it.next();
			
			Long carrierId = res.getParentId();    
			if(carrierId.intValue()==0) carrierId = res.getCarrierId();   
			Carrier carrier = carrierDao.getCarrier(carrierId);
			
			sb.append("<item id='" +resourceIdPrefix
							+ res.getId().toString()
							+ "' im0=\"\" im1=\"\" im2=\"\" text=\""
							+carrier.getCarrierName()+"["+res.getMemo()+"]" + "\">");  
			sb.append("<userdata name=\"id\">" + res.getId().toString()  
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			sb.append("</item>");  

		}
	}

	public List getPrice(Compages compages, String length,Long priceTypeId ,int model) {
//		System.out.println("compages--" + compages.toString());
		Long compagesId = compages.getId();
		
		List ls = resourceDao.getResourcesByCompagesId(compagesId);
		
		List idList = new ArrayList();
		
		Map mp = new HashMap();
		
		List price = new ArrayList();
		
		if(model == 0){
			for(Iterator it = ls.iterator();it.hasNext();){
				
				Resource res = (Resource) it.next();
				
				Long resId = res.getId();
				
				
				idList.add(resId);
			}
			
			mp.put("ResourceIdList",idList);
			mp.put("length",length);
			mp.put("priceTypeId",priceTypeId);
			
			price = priceDao.getPricesCompagesByResSysPrice(mp);
		}
		
		if(model == 1){

			price = priceDao.getPriceByCompages(compagesId,length,priceTypeId);
		}
		
		return price;
	}
	
	
	public String getPriceByLegth(String compagesId, String length,String priceTypeId) {


		Double	price = priceDao.getPriceByCompages2(new Long(compagesId),length,priceTypeId);
		
		String p = com.vriche.adrm.util.StringUtil.getNullValue(price,"0");
	    
		if("".equals(p)) p = "0";
		
		return p;
	}




	public List getPriceByResIdListAndLength(List idList,String length,Long priceTypeId) {
		Map map = new HashMap();
		
		map.put("ResourceIdList",idList);
		map.put("length",length);
		map.put("priceTypeId",priceTypeId);
		
		return priceDao.getPricesCompagesByResSysPrice(map);
	}



	public void saveCompagesAndResource(Compages compages, String id) {
		dao.saveCompagesAndResource(compages,new Long(id));		
	}



	public String saveCompagesAndResourceRel(Compages compages) {
//		System.out.println("compages---->"+compages);
		
		String compagesId = dao.saveCompages(compages).toString();
		
		Long priceId = compages.getPriceId();
//		System.out.println("priceId===--=="+priceId);
		
		priceId = priceId == null || priceId.intValue()==0 || priceId.toString().equals("0")?new Long(0):priceId;
		
//		String compagesId = compages.getId().toString();
//		System.out.println("compagesId==========="+compagesId);
//		int resourceSize = compages.getResources().size();
//		System.out.println("resourceSize="+resourceSize);
//		if(resourceSize > 0)
		this.saveCompagesAndResource(compages,compagesId);
		
		return compagesId;
	}
	
	
	
//	public List getPricesByCompagesId(String id) {
//
//		List ls = priceDao.getPricesByCompagesId(new Long(id));
//		
//		if(ls.size() == 0){
//			return null;
//		}else{
//			return ls;
//		}
//		List idList = new ArrayList();
//		
//		Map mp = new HashMap();
//		
//		for(Iterator it = list.iterator();it.hasNext();){
//			PriceDetail priceDetail = (PriceDetail)it.next();
//			
//			Long priceDetailId = priceDetail.getId();
//			
//			idList.add(priceDetailId);
//		}
//		
//		mp.put("PriceDetailIdList",idList);
//		
//		return mp;
//	}
	

    /**
     * @see com.vriche.adrm.adres.service.CompagesManager#removeCompages(String id)
     */
    public void removeCompages(final String id,String priceId) {
//    	System.out.println("----------");
    	System.out.println("-----priceId-----" + priceId);
//    	List ls  =  priceDao.getPricesByCompagesId(new Long(id));
//    	
//    	    	
//    	List idList = new ArrayList();
//
//    	Map mp = new HashMap();
//
//    	
//    	for(Iterator it = ls.iterator();it.hasNext();){
//    		System.out.println("----------");
//    		
//    		PriceDetail priceDetail = (PriceDetail) it.next();
//    		
//    		Long priceDetailId = priceDetail.getId();
    		
//    		Long priceId = priceDetail.getPriceId();
//    		System.out.println("priceId--" + priceId);
    		
//    		priceDao.removeCompagesPrice(priceId);
    		
//    		idList.add(priceDetailId);
//    	}
    	
    	priceDao.removePriceAndPriceDetailRel(new Long(priceId));
//    	System.out.println("-----idList-----" + idList);
    	
//    	if(idList.size()==0){
////    		System.out.println("0000000000");
//    		
//        	this.removeCompagesAndResources(id);
//        	
//            dao.removeCompages(new Long(id));
//    	}else{    
    		
        	this.removeCompagesAndPrices(id);
        	
//    		System.out.println("111111111111111111");
//        	mp.put("PriceDetailIdList",idList);
//        	
//        	priceDetailDao.removePriceDetails(mp);
        	
        	this.removePrice(priceId);
        	
        	this.removeCompagesAndResources(id);
        	
            dao.removeCompages(new Long(id));	
//    	}
    }
	
	private void removePrice(String priceId){
		priceDao.removePriceByPriceId(new Long(priceId));
	}
	
	public void removeCompagesAndResources(String id){
		dao.removeCompagesAndResources(new Long(id));
	}
	
	public void removeCompagesAndPrices(String id){
		dao.removeCompagesAndPrices(new Long(id));
	}



	public String getPriceDetailIdByCompagesIdAndLength(Long compagesId, String length) {
		System.out.println("000000000000000000000000000000000000000000000000000"+compagesId);
		System.out.println("000000000000000000000000000000000000000000000000000"+length);
		return priceDao.getPriceDetailIdByCompagesIdAndLength(compagesId,length).toString();
	}

}













