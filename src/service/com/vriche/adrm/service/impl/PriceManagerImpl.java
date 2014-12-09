
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.model.Price;
import com.vriche.adrm.service.PriceExistsException;
import com.vriche.adrm.service.PriceManager;

public class PriceManagerImpl extends BaseManager implements PriceManager {
    private PriceDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setPriceDao(PriceDao dao) {
        this.dao = dao;
    }
 
    /**
     * @see com.vriche.adrm.adres.service.PriceManager#getPricesByIdList(final Map idList)
     */
    public List getPricesByIdList(final Map idList) {
        return dao.getPricesByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.PriceManager#getPrices(com.vriche.adrm.adres.model.Price)
     */
    public List getPrices(final Price price) {
        return dao.getPrices(price);
    }

    
    public List getPricesByResourceId(String id) {
    	 return dao.getPricesByResourceId(new Long(id));
    }
    
    

	public List getPriceDetailByPriceId(String id) {
//		System.out.println("PriceId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);  
		return dao.getPriceDetailByPriceId(new Long(id));
	}

	/**
     * @see com.vriche.adrm.adres.service.PriceManager#getPrice(String id)
     */
    public Price getPrice(final String id) {
        return dao.getPrice(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceManager#savePrice(Price price)
     */
    public String savePrice(Price price) {
//    	System.out.println("price 1111111 222222222 33333333333  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+price.toString());  
        return dao.savePrice(price).toString();
    }

	public void saveResourcePriceRel(String resourceId,String priceId){
			dao.saveResourcePriceRel(resourceId,priceId);
	}
	
    /**
     * @see com.vriche.adrm.adres.service.PriceManager#removeResourcePriceRel(String id,String resourceId)
     */
    public void removeResourcePriceRel(final String id,final String resourceId) {
        dao.removeResourcePriceRel(new Long(id),new Long(resourceId));
    }
	
    /**
     * @see com.vriche.adrm.adres.service.PriceManager#removePrice(String id)
     */
    public void removePrice(final String id) {
        dao.removePrice(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.PriceManager#removePrices(String Map)
     */
    public void removePrices(final Map idList) {
        dao.removePrices(idList);
    }    
    
    public Map getPricesByResourceInfoAndLength(Long id, String adLength){
 	   List ls = dao.getPricesByResourceInfoAndLength(id,adLength);
       Map reply = new LinkedHashMap();
       Iterator it = ls.iterator();
//       reply.put( "0","");
       while (it.hasNext()){
    	   Price price = new Price();
    	   price = (Price)it.next();
           reply.put( price.getResourcePriceType(),price.getPriceDetail().getPrice());
       }
//       System.out.println("reply ==>>" + reply);
       
       return reply;
    }

	public Map makeSelectItemAnalyze(Price pric){
	    Map reply = new LinkedHashMap();
	    List ls = getPrices(pric);
	    Iterator it = ls.iterator();
	    reply.put("0","");
	    while(it.hasNext()){
	    	Price price = (Price) it.next();
	    	reply.put(price.getId(),price.getName());
	    }
		return reply;
	}
	
	
	public Map getPricesForImport(Price pric){
	    Map reply = new LinkedHashMap();
	    List ls = dao.getPricesForImport(pric);
	    Iterator it = ls.iterator();
	    reply.put("0","");
	    while(it.hasNext()){
	    	Price price = (Price) it.next();
	    	reply.put(price.getId(),price.getName());
	    }
	    
		if(log.isDebugEnabled()){
			log.info("getVersion>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+pric.getVersion());
			
			log.info("getOrgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+pric.getOrgId());

			log.info("reply.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+reply.size());

		}
		
		return reply;
	}
	
	
	public String savePriceByCompage(Price price) {
		// TODO Auto-generated method stub
		return dao.savePriceByCompage(price).toString();
	}

	public Double getSysPriceByResId(Long id, String adLength,Long resourcePriceId) throws PriceExistsException,DataAccessException  {
		Double sysPrice =new Double(0);
//		if(log.isDebugEnabled()){
			log.info("id>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);
			log.info("adLength>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+adLength);
			log.info("resourcePriceId>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+resourcePriceId);
//		}
		  try {
			  
			   sysPrice =  dao.getPriceByResourceIdAndLength(id,adLength,resourcePriceId);
				
		  }catch (Exception e) {
	            throw new PriceExistsException("读取价格出错，可能此段位的价格类别不唯一!");
	       }
		  
		  log.info("sysPrice>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sysPrice);
		  
		  return sysPrice;
	
	}

	public void removeCompagesPrice(String id) {
		// TODO Auto-generated method stub
		dao.removeCompagesPrice(new Long(id));
	}

	public PaginatedList getPricePageByResoruceId(String resId, String pageIndex, String pageSize) {
		
		return dao.getPricePageByResoruceId(new Long(resId),Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getPriceCountByResoruceId(String id) {
		
		return dao.getPriceCountByResoruceId(id).toString();
	}
}
