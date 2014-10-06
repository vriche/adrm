
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.service.Manager;

public interface PriceDetailManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPriceDetailDao(PriceDetailDao priceDetailDAO);

    /**
     * Retrieves all of the priceDetails
     */
    public List getPriceDetails(PriceDetail priceDetail);
        /**
     * Retrieves all of the priceDetailsByIdList
     */
    public List getPriceDetailsByIdList(final Map idList);

    /**
     * Gets priceDetail's information based on id.
     * @param id the priceDetail's id
     * @return priceDetail populated priceDetail object
     */
    public PriceDetail getPriceDetail(final String id);

    /**
     * Saves a priceDetail's information
     * @param priceDetail the object to be saved
     */
    public String savePriceDetail(PriceDetail priceDetail);

    /**
     * Removes a priceDetail from the database by id
     * @param id the priceDetail's id
     */
    public void removePriceDetail(final String id);
     /**
     * Removes a priceDetail from the database by id
     * @param idList
     */
    public void removePriceDetails(final Map idList);
    
    public PaginatedList getPriceDetailsPage(PriceDetail priceDetail,String pageIndex,String pageSize);
    
    public Integer getPriceDetailsCount(PriceDetail priceDetail);
    
    public List getPriceDetailsByCompagesId(final String compagesId,String pageIndex,String pageSize);
    
    public String getPriceDetailCountByIdList(final String compagesId);
    
    public Map getPriceLengthDetailSelectFromMap();
    
    public List getPriceLengthDetailFromMap();
}

