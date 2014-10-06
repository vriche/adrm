
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.PriceDetail;

public interface PriceDetailDao extends Dao {

    /**
     * Retrieves all of the priceDetails
     */
    public List getPriceDetails(PriceDetail priceDetail);

    /**
     * Retrieves all of the priceDetailsByIdList
     */
    public List getPriceDetailsByIdList(final Map idList);

    /**
     * Gets priceDetail's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the priceDetail's id
     * @return priceDetail populated priceDetail object
     */
    public PriceDetail getPriceDetail(final Long id);

    /**
     * Saves a priceDetail's information
     * @param priceDetail the object to be saved
     */    
    public Long savePriceDetail(PriceDetail priceDetail);

    /**
     * Removes a priceDetail from the database by id
     * @param id the priceDetail's id
     */
    public void removePriceDetail(final Long id);
	/**
     * Removes priceDetails from the database by ids
     * @param ids the priceDetail's id eg:"'1','2','3'"
     */
    public void removePriceDetails(final Map idList);
    
    public PaginatedList getPriceDetailsPage(PriceDetail priceDetail,int pageIndex,int pageSize);
    
    public Integer getPriceDetailsCount(PriceDetail priceDetail);
    
    public PaginatedList getPriceDetailsPageByIdList(Map idList,int pageIndex,int pageSize);
    
    public Integer getPriceDetailCountByIdList(Map idList);
    
    public List getPriceLengthDetail();
    
    public List getPriceDetailIdByPriceIdList(final Map idList) ;
    
    public List getPriceDetailIdByPriceIdList2(final Map idList) ;
    
    public Map getPriceDetailRelMapForCopyRes(String sourYear);
    
    public void removePriceDetailRelByPrice(final Map mp) ;
}

