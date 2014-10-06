
package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.model.Price;
import com.vriche.adrm.model.PriceDetail;

public class PriceDaoiBatis extends BaseDaoiBATIS implements PriceDao {

    /**
     * @see com.vriche.adrm.adres.dao.PriceDao#getPrices(com.vriche.adrm.adres.model.Price)
     */
    public List getPrices(final Price price) {
          return getSqlMapClientTemplate().queryForList("getPrices", price);
    }
    
    public List getPricesByResourceId(Long id) {
        return getSqlMapClientTemplate().queryForList("getPricesByResourceId", id);
  }   


	public List getPriceDetailByPriceId(Long id) {
		return getSqlMapClientTemplate().queryForList("getPriceDetailByPriceId", id);
	}

	/**
     * @see com.vriche.adrm.adres.dao.PriceDao#getPricesByIdList(com.vriche.adrm.adres.model.Price)
     */
    public List getPricesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPricesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceDao#getPrice(Long id)
     */
    public Price getPrice(Long id) {
        Price price = (Price) getSqlMapClientTemplate().queryForObject("getPrice", id);

        if (price == null) {
            throw new ObjectRetrievalFailureException(Price.class, id);
        }

        return price;
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceDao#savePrice(Price price)
     */    
    public Long savePrice(final Price price) {
        Long id = price.getId();
       
        // check for new record
        if (id == null || id.intValue() ==-1 ||id.intValue() == 0 || id.toString() =="") {
            id = (Long) getSqlMapClientTemplate().insert("addPrice", price);
//            System.out.println("id=" + id);
//            System.out.println("price=" + price);
            Long resourceId = price.getResource().getId();
            
//            System.out.println("resId=" + resourceId);
            //从资源维护中增加价格
            if(resourceId != null && resourceId.intValue() != -1 && resourceId.intValue() != 0){
            	 Map mp = new HashMap();
            	 mp.put("resourceId",resourceId);
            	 mp.put("priceId",id);
            	 getSqlMapClientTemplate().insert("addPriceResourceRel", mp);
            }
        } else {
            getSqlMapClientTemplate().update("updatePrice", price);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Price.class, id);
        }
        return id;
        
    }
    
    public Long savePriceByCompage(final Price price) {
    	
    	
//    	System.out.println("price=====" + price);
        Long id = price.getId();
        // check for new record
        if (id == null || id.intValue() ==-1 ||id.intValue() == 0 || id.toString() =="") {
            id = (Long) getSqlMapClientTemplate().insert("addPrice", price);
            
//            System.out.println("id=" + id);
//            System.out.println("name=" + price.getName());
            
            Long compagesId = price.getCompages().getId();
            
//            System.out.println("compagesId=" + compagesId);
            //从资源维护中增加价格
            if(compagesId != null && compagesId.intValue() != -1 && compagesId.intValue() != 0){
//            	System.out.println("iiiiiiiiiiiiiiiiiiii");
            	 Map mp = new HashMap();
            	 mp.put("compagesId",compagesId);
            	 mp.put("priceId",id);
            	 getSqlMapClientTemplate().insert("addPriceCompagesRel", mp);
            }
        } else {
            getSqlMapClientTemplate().update("updatePrice", price);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Price.class, id);
        }
        return id;
        
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceDao#removePrice(Long id)
     */
    public void removePrice(Long id) {
    	//删除价格与明细关系
    	List list = getSqlMapClientTemplate().queryForList("getPriceDetailIdByPriceId", id);
    	List PriceDetailsIdList = getPriceDetailIdList(list);
        getSqlMapClientTemplate().update("deletePriceRelByPriceId", id);
        
        if(PriceDetailsIdList.size()>0){
    	   	Map mp = new HashMap();
    		mp.put("PriceDetailIdList",PriceDetailsIdList);
    		getSqlMapClientTemplate().update("deletePriceDetails", mp);       	
        }

        getSqlMapClientTemplate().update("deletePriceResourceRelByPriceId", id);
        getSqlMapClientTemplate().update("deletePrice", id);
    }
    
    public void removePriceAndPriceDetailRel(Long id){
    	//删除价格与明细关系
    	List list = getSqlMapClientTemplate().queryForList("getPriceDetailIdByPriceId", id);
    	List PriceDetailsIdList = getPriceDetailIdList(list);
        getSqlMapClientTemplate().update("deletePriceRelByPriceId", id);
        
        if(PriceDetailsIdList.size()>0){
    	   	Map mp = new HashMap();
    		mp.put("PriceDetailIdList",PriceDetailsIdList);
    		getSqlMapClientTemplate().update("deletePriceDetails", mp);       	
        }

        getSqlMapClientTemplate().update("deletePriceResourceRelByPriceId", id);	
    }
    
    public void removeCompagesPrice(Long id){
    	List list = getSqlMapClientTemplate().queryForList("getPriceDetailIdByPriceId", id);
    	List PriceDetailsIdList = getPriceDetailIdList(list);
    	getSqlMapClientTemplate().update("deletePriceRelByPriceId", id);
    	
        if(PriceDetailsIdList.size()>0){
    	   	Map mp = new HashMap();
    		mp.put("PriceDetailIdList",PriceDetailsIdList);
    		getSqlMapClientTemplate().update("deletePriceDetails", mp);       	
        } 
        
        getSqlMapClientTemplate().update("deletePriceResourceRelByPriceId", id);
        getSqlMapClientTemplate().update("deleteCompagesPriceRelByPriceId", id);
        getSqlMapClientTemplate().update("deletePrice", id);
    }
    
    
    /**
     * @see com.vriche.adrm.order.dao.PriceDAO#removePrices(String ids)
     */
    public void removePrices(final Map idList) {
    	//删除价格与明细关系
    	 List list = getSqlMapClientTemplate().queryForList("getPriceDetailIdByPriceIdList", idList);  
    	 List PriceDetailsIdList = getPriceDetailIdList(list);
         if(PriceDetailsIdList.size()>0){
    	   	 Map mp = new HashMap();
    		 mp.put("PriceDetailIdList",PriceDetailsIdList);
    		 getSqlMapClientTemplate().update("deletePriceDetails", mp);         	 
         }
  	
    	getSqlMapClientTemplate().update("deletePriceResourceRelByPriceIdList", idList);
    	
        getSqlMapClientTemplate().update("deletePrices", idList);
    }   
    
    
    private List getPriceDetailIdList(List ls){ 
    	List rs = new ArrayList();
    	Iterator it  = ls.iterator();
    	while(it.hasNext()){
    		PriceDetail priceDetail = (PriceDetail)it.next();
    		rs.add(priceDetail.getId());
    	}
    	
    	return rs;
    }
    
	public List getPricesByResourceInfoAndLength(Long id, String adLength) {
	   	 Map mPara = new HashMap();
	   	 mPara.put("resourceInfoId",id);
	   	 mPara.put("length",adLength);
	   	 return getSqlMapClientTemplate().queryForList("getPriceByResourceLength", mPara);
	}

	public List getPricesCompagesByResSysPrice(Map map) {
		
		return getSqlMapClientTemplate().queryForList("getPricesCompagesByResSysPrice", map);
	}

	public List getPriceByCompages(Long id, String adLength,Long priceTypeId) {
		
//		System.out.println("id-" + id);
//		System.out.println("adLength-" + adLength);
		 Map mPara = new HashMap();
	   	 mPara.put("id",id);
	   	 mPara.put("length",adLength);
	   	mPara.put("priceTypeId",priceTypeId);
//	   	System.out.println("mPara-" + mPara.size());
	   	 return getSqlMapClientTemplate().queryForList("getPriceByCompages", mPara);
	}
	
	
	public Double getPriceByCompages2(Long id, String adLength,String priceTypeId) {

		 Map mPara = new HashMap();
	   	 mPara.put("id",id);
	   	 mPara.put("length",adLength);
	     mPara.put("priceTypeId",priceTypeId);
	   	 return (Double)getSqlMapClientTemplate().queryForObject("getPriceByCompages", mPara);
	}

	public List getPricesByCompagesId(Long compagesId) {
		return getSqlMapClientTemplate().queryForList("getPricesByCompagesId", compagesId);
	}   
	
	public List getPricesForImport(Price price) {
		return getSqlMapClientTemplate().queryForList("getPricesForImport", price);
	}   
	
	
    
    
//    public Double getSysPriceByResId(Map mp) {
//        return (Double)getSqlMapClientTemplate().queryForObject("getSysPriceByResourceId", mp);
//  }

	public Double getPriceByResourceIdAndLength(Long id, String adLength,Long resourcePriceId) {
//		System.out.println("id-========" + id);
//		System.out.println("adLength-=========" + adLength);
		 Map mPara = new HashMap();
	   	 mPara.put("resourceInfoId",id);
	   	 mPara.put("length",adLength);
	   	mPara.put("resourcePriceId",resourcePriceId);

	   	Object obj = getSqlMapClientTemplate().queryForObject("getPriceByResourceIdAndLength", mPara);

	   	if(obj == null){
//	   		System.out.println("getPriceByResourceIdAndLength 1------------------------------------" + obj);
	   		return new Double(0);
	   	}else{
//	   		System.out.println("getPriceByResourceIdAndLength 2------------------------------------" + obj);
	   		return (Double)obj;
	   	}
	   	
	
	   
	}

	public void removePriceByPriceId(Long id) {
		// TODO Auto-generated method stubdeletePriceByPriceId
		getSqlMapClientTemplate().update("deletePriceByPriceId", id);
	}

	public Long getPriceDetailIdByCompagesIdAndLength(Long compagesId, String adLength) {
		
//		System.out.println("compagesId="+compagesId);
//		System.out.println("adLength="+adLength);
		
	   	 Map mPara = new HashMap();
	   	 mPara.put("compagesId",compagesId);
	   	 mPara.put("length",adLength);
	   	 
	   	 Object obj = getSqlMapClientTemplate().queryForObject("getPriceDetailIdByCompagesIdAndLength", mPara);
	   	 
	   	 Long priceDetailId = obj == null?new Long(0):(Long)obj;
	   
	   	 return priceDetailId;
	}

	public PaginatedList getPricePageByResoruceId(Long resId, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getPricesByResourceId",resId,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}

	public Integer getPriceCountByResoruceId(String id) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getPriceCountByResourceId", id);
	}
	
	public void saveResourcePriceRel(String resourceId,String priceId){
		 Map mp = new HashMap();
		 mp.put("resourceId",resourceId);
		 mp.put("priceId",priceId);
		 getSqlMapClientTemplate().insert("addPriceResourceRel", mp);
	}
	
	

	 
	public void savePriceDeatilRel(String priceId,String priceDetailId){
		 Map mp = new HashMap();
		 mp.put("priceId",priceId);      
		 mp.put("priceDetailId",priceDetailId);
		 getSqlMapClientTemplate().insert("addPriceDeatilRel", mp);
	}
	
	
    public void removeResourcePriceRel(Long priceId,Long resourceId) {
		 Map mp = new HashMap();
		 mp.put("resourceId",resourceId);
		 mp.put("priceId",priceId);
    	
         getSqlMapClientTemplate().update("deletePriceResourceRelByPriceIdAndResourceId", mp);
    }

	public void removePricesResRel(Map mp) {
//		getSqlMapClientTemplate().update("deletePriceResourceRelByResourceIdList2", mp);  
		getSqlMapClientTemplate().delete("deletePriceResourceRelByResourceIdList2", mp);
	}

	public Map getPriceResRelMap(String sourYear) {
		return getSqlMapClientTemplate().queryForMap("getPrice_resource_rels",sourYear,"id","memo");
		
	}   
	
	public Map getPriceResRelMapForCopyRes(String sourYear) {
		return getSqlMapClientTemplate().queryForMap("getPrice_resource_rels_for_copyRes",sourYear,"id","memo");
		
	}  
}
