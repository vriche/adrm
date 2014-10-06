
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.service.PriceDetailManager;

public class PriceDetailManagerImpl extends BaseManager implements PriceDetailManager {
    private PriceDetailDao dao;

    private PriceDao priceDao;
    
    
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
    public void setPriceDetailDao(PriceDetailDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceDetailManager#getPriceDetailsByIdList(final Map idList)
     */
    public List getPriceDetailsByIdList(final Map idList) {
        return dao.getPriceDetailsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.PriceDetailManager#getPriceDetails(com.vriche.adrm.adres.model.PriceDetail)
     */
    public List getPriceDetails(final PriceDetail priceDetail) {
        return dao.getPriceDetails(priceDetail);
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceDetailManager#getPriceDetail(String id)
     */
    public PriceDetail getPriceDetail(final String id) {
        return dao.getPriceDetail(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceDetailManager#savePriceDetail(PriceDetail priceDetail)
     */
    public String savePriceDetail(PriceDetail priceDetail) {
        return dao.savePriceDetail(priceDetail).toString();
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceDetailManager#removePriceDetail(String id)
     */
    public void removePriceDetail(final String id) {
        dao.removePriceDetail(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.PriceDetailManager#removePriceDetails(String Map)
     */
    public void removePriceDetails(final Map idList) {
        dao.removePriceDetails(idList);
    }

	public PaginatedList getPriceDetailsPage(PriceDetail priceDetail, String pageIndex, String pageSize) {
		return dao.getPriceDetailsPage(priceDetail,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public Integer getPriceDetailsCount(PriceDetail priceDetail) {
		return dao.getPriceDetailsCount(priceDetail);
	}

	public List getPriceDetailsByCompagesId(String compagesId,String pageIndex,String pageSize) {
		List idList = this.getPriceDetailIdList(compagesId);

		Map mp = new HashMap();
		
		mp.put("PriceDetailIdList",idList);

		return dao.getPriceDetailsPageByIdList(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getPriceDetailCountByIdList(String compagesId) {
		List idList = this.getPriceDetailIdList(compagesId);

		Map mp = new HashMap();
		
		mp.put("PriceDetailIdList",idList);
		
		return dao.getPriceDetailCountByIdList(mp).toString();
	}    
	
	private List getPriceDetailIdList(String compagesId){
//		System.out.println("00000000000000000000");
		List ls = priceDao.getPricesByCompagesId(new Long(compagesId));
//		System.out.println("ls-"+ ls.size());
		List idList = new ArrayList();
		
		if(ls.size() == 0){
			idList.add(null);
			
		}else{
			for(Iterator it = ls.iterator();it.hasNext();){
				
				PriceDetail priceDetail = (PriceDetail)it.next();
				
				Long priceDetailId = priceDetail.getId();
				
				idList.add(priceDetailId);
			}
		}
		
		return idList;
	}

	public Map getPriceLengthDetailSelectFromMap() {
		// TODO Auto-generated method stub
		List priceLengthList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_PRICE_LENGTH_DETAIL);
		Iterator it = priceLengthList.iterator();
		Map reply = new LinkedHashMap();
		reply.put("0","");
		while(it.hasNext()){
			Double prilength = (Double) it.next();
			reply.put(prilength,prilength);
		}
		return reply;
	}
	
	public List getPriceLengthDetailFromMap() {
		// TODO Auto-generated method stub
		List priceLengthList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_PRICE_LENGTH_DETAIL);
		
		
		return priceLengthList;
	}
	
	
}
