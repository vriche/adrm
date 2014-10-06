
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.CarrierType;

public interface CarrierTypeDao extends Dao {

    /**
     * Retrieves all of the carrierTypes
     */
    public List getCarrierTypes(CarrierType carrierType);

    /**
     * Retrieves all of the carrierTypesByIdList
     */
    public List getCarrierTypesByIdList(final Map idList);

    /**
     * Gets carrierType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the carrierType's id
     * @return carrierType populated carrierType object
     */
    public CarrierType getCarrierType(final String id);

    /**
     * Saves a carrierType's information
     * @param carrierType the object to be saved
     */    
    public Long saveCarrierType(CarrierType carrierType);

    /**
     * Removes a carrierType from the database by id
     * @param id the carrierType's id
     */
    public void removeCarrierType(final String id);
	/**
     * Removes carrierTypes from the database by ids
     * @param ids the carrierType's id eg:"'1','2','3'"
     */
    public void removeCarrierTypes(final Map idList);
}

