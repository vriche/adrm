
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.PriceTypeDao;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.PriceType;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.Manager;

public interface PriceTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPriceTypeDao(PriceTypeDao priceTypeDAO);

    /**
     * Retrieves all of the priceTypes
     */
    public List getPriceTypes(PriceType priceType);
        /**
     * Retrieves all of the priceTypesByIdList
     */
    public List getPriceTypesByIdList(final Map idList);

    /**
     * Gets priceType's information based on id.
     * @param id the priceType's id
     * @return priceType populated priceType object
     */
    public PriceType getPriceType(final String id);

    /**
     * Saves a priceType's information
     * @param priceType the object to be saved
     */
    public void savePriceType(PriceType priceType);

    /**
     * Removes a priceType from the database by id
     * @param id the priceType's id
     */
    public void removePriceType(final String id);
     /**
     * Removes a priceType from the database by id
     * @param idList
     */
    public void removePriceTypes(final Map idList);
    
    public Map getPriceTypeSelect(PriceType priceType);
    
    public Map getPriceTypeSelectFromMap(PriceType priceType);
    
	public List getPriceTypeSelectFromMap2(PriceType priceType);
}

