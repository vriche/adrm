
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.PriceRegularDao;
import com.vriche.adrm.model.PriceRegular;
import com.vriche.adrm.service.Manager;

public interface PriceRegularManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPriceRegularDao(PriceRegularDao priceRegularDAO);

    /**
     * Retrieves all of the priceRegulars
     */
    public List getPriceRegulars(PriceRegular priceRegular);
        /**
     * Retrieves all of the priceRegularsByIdList
     */
    public List getPriceRegularsByIdList(final Map idList);

    /**
     * Gets priceRegular's information based on id.
     * @param id the priceRegular's id
     * @return priceRegular populated priceRegular object
     */
    public PriceRegular getPriceRegular(final String id);
    
    
    public String getPriceRegularByName(final String resourceId, String priceTypeId,String priceRegularName) throws PriceExistsException;

    /**
     * Saves a priceRegular's information
     * @param priceRegular the object to be saved
     */
    public void savePriceRegular(PriceRegular priceRegular);

    /**
     * Removes a priceRegular from the database by id
     * @param id the priceRegular's id
     */
    public void removePriceRegular(final String id);
     /**
     * Removes a priceRegular from the database by id
     * @param idList
     */
    public void removePriceRegulars(final Map idList);
}

