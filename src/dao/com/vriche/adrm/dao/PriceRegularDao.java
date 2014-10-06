
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.PriceRegular;

public interface PriceRegularDao extends Dao {

    /**
     * Retrieves all of the priceRegulars
     */
    public List getPriceRegulars(PriceRegular priceRegular);

    /**
     * Retrieves all of the priceRegularsByIdList
     */
    public List getPriceRegularsByIdList(final Map idList);

    /**
     * Gets priceRegular's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the priceRegular's id
     * @return priceRegular populated priceRegular object
     */
    public PriceRegular getPriceRegular(final Long id);
    
    
    public PriceRegular getPriceRegular(final PriceRegular priceRegular);

    /**
     * Saves a priceRegular's information
     * @param priceRegular the object to be saved
     */    
    public void savePriceRegular(PriceRegular priceRegular);

    /**
     * Removes a priceRegular from the database by id
     * @param id the priceRegular's id
     */
    public void removePriceRegular(final Long id);
	/**
     * Removes priceRegulars from the database by ids
     * @param ids the priceRegular's id eg:"'1','2','3'"
     */
    public void removePriceRegulars(final Map idList);
}

