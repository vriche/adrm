
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.PriceType;


public interface PriceTypeDao extends Dao {

	
    /**
     * Retrieves all of the priceTypes
     */
    public List getPriceTypes(PriceType priceType);

    /**
     * Retrieves all of the priceTypesByIdList
     */
    public List getPriceTypesByIdList(final Map idList);

    /**
     * Gets priceType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the priceType's id
     * @return priceType populated priceType object
     */
    public PriceType getPriceType(final Long id);

    /**
     * Saves a priceType's information
     * @param priceType the object to be saved
     */    
    public void savePriceType(PriceType priceType);

    /**
     * Removes a priceType from the database by id
     * @param id the priceType's id
     */
    public void removePriceType(final Long id);
	/**
     * Removes priceTypes from the database by ids
     * @param ids the priceType's id eg:"'1','2','3'"
     */
    public void removePriceTypes(final Map idList);
}

