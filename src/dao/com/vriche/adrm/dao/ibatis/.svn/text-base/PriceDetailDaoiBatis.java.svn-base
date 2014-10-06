
package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.PriceDetail;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceDetailDaoiBatis extends BaseDaoiBATIS implements PriceDetailDao {

    /**
     * @see com.vriche.adrm.adres.dao.PriceDetailDao#getPriceDetails(com.vriche.adrm.adres.model.PriceDetail)
     */
    public List getPriceDetails(final PriceDetail priceDetail) {
          return getSqlMapClientTemplate().queryForList("getPriceDetails", priceDetail);
    }
    /**
     * @see com.vriche.adrm.adres.dao.PriceDetailDao#getPriceDetailsByIdList(com.vriche.adrm.adres.model.PriceDetail)
     */
    public List getPriceDetailsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getPriceDetailsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceDetailDao#getPriceDetail(Long id)
     */
    public PriceDetail getPriceDetail(Long id) {
        PriceDetail priceDetail = (PriceDetail) getSqlMapClientTemplate().queryForObject("getPriceDetail", id);

        if (priceDetail == null) {
            throw new ObjectRetrievalFailureException(PriceDetail.class, id);
        }

        return priceDetail;
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceDetailDao#savePriceDetail(PriceDetail priceDetail)
     */    
    public Long savePriceDetail(final PriceDetail priceDetail) {
        Long id = priceDetail.getId();
        
        
        // check for new record
        if (id == null||id.intValue() ==-1 ||id.intValue() == 0) {
        	Long priceId = priceDetail.getPriceId();
        	
//        	System.out.println("priceId---" + priceId);
        	
        	id = (Long) getSqlMapClientTemplate().insert("addPriceDetail", priceDetail);
//        	System.out.println("id--" + id);
        	if (priceId != null||priceId.intValue() !=-1 ||priceId.intValue() != 0){
	           	 Map mp = new HashMap();
	        	 mp.put("priceId",priceId);      
	        	 mp.put("priceDetailId",id);
        		 getSqlMapClientTemplate().insert("addPriceDeatilRel", mp);
        	}
        	
        	
        } else {
            getSqlMapClientTemplate().update("updatePriceDetail", priceDetail);
        }
        
        if( id == null ) {
            throw new ObjectRetrievalFailureException(PriceDetail.class, id);
        }
//        System.out.println("id--" + id);
        return id;
    }

    /**
     * @see com.vriche.adrm.adres.dao.PriceDetailDao#removePriceDetail(Long id)
     */
    public void removePriceDetail(Long id) {
    	
        getSqlMapClientTemplate().update("deletePriceRelByPriceDetailId", id);
        
        getSqlMapClientTemplate().update("deletePriceDetail", id);
    }
    

    
    
    /**
     * @see com.vriche.adrm.order.dao.PriceDetailDAO#removePriceDetails(String ids)
     */
    public void removePriceDetails(final Map idList) {
    	
    	getSqlMapClientTemplate().update("deletePriceRelByPriceDetailIdList", idList);
    	
        getSqlMapClientTemplate().update("deletePriceDetails", idList);
    }
    
  public void removePriceDetailRelByPrice(final Map mp) {
    	
        getSqlMapClientTemplate().delete("deletePriceDetailRelByPrice", mp);

    }
    
    
    
	public PaginatedList getPriceDetailsPage(PriceDetail priceDetail, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getPriceDetails",priceDetail,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getPriceDetailsCount(PriceDetail priceDetail) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getPriceDetailsCount", priceDetail);
	}
	public PaginatedList getPriceDetailsPageByIdList(Map idList, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getPriceDetailsByIdList",idList,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getPriceDetailCountByIdList(Map idList) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getPriceDetailsCountByIdList", idList);
	}
	public List getPriceLengthDetail() {
		// TODO Auto-generated method stub
		List ls = getSqlMapClientTemplate().queryForList("getPriceLengthDetail",null);
//		System.out.println("+++++++++++++++++++++++++++++++"+ls.size());
		return ls;
	}
	
	public List getPriceDetailIdByPriceIdList(final Map idList) {
		// TODO Auto-generated method stub
		List ls = getSqlMapClientTemplate().queryForList("getPriceDetailIdByPriceIdList",idList);
//		System.out.println("+++++++++++++++++++++++++++++++"+ls.size());
		return ls;
	}
	
	public List getPriceDetailIdByPriceIdList2(final Map idList) {
		// TODO Auto-generated method stub
		List ls = getSqlMapClientTemplate().queryForList("getPriceDetailIdByPriceIdList2",idList);
//		System.out.println("+++++++++++++++++++++++++++++++"+ls.size());
		return ls;
	}
	public Map getPriceDetailRelMapForCopyRes(String sourYear) {
		return getSqlMapClientTemplate().queryForMap("getPrice_detail_rels_for_copyRes",sourYear,"id","priceId");
		
	}  
}
