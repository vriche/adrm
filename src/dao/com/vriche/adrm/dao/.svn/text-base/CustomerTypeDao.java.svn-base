
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.CustomerType;

public interface CustomerTypeDao extends Dao {

    /**
     * Retrieves all of the customerTypes
     */
    public List getCustomerTypes(CustomerType customerType);

    /**
     * Retrieves all of the customerTypesByIdList
     */
    public List getCustomerTypesByIdList(final Map idList);

    /**
     * Gets customerType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the customerType's id
     * @return customerType populated customerType object
     */
    public CustomerType getCustomerType(final Long id);

    /**
     * Saves a customerType's information
     * @param customerType the object to be saved
     */    
    public void saveCustomerType(CustomerType customerType);

    /**
     * Removes a customerType from the database by id
     * @param id the customerType's id
     */
    public void removeCustomerType(final Long id);
	/**
     * Removes customerTypes from the database by ids
     * @param ids the customerType's id eg:"'1','2','3'"
     */
    public void removeCustomerTypes(final Map idList);
}

