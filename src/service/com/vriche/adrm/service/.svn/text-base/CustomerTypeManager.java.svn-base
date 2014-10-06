
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CustomerTypeDao;
import com.vriche.adrm.model.CustomerType;
import com.vriche.adrm.service.Manager;

public interface CustomerTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setCustomerTypeDao(CustomerTypeDao customerTypeDAO);

    /**
     * Retrieves all of the customerTypes
     */
    public List getCustomerTypes(CustomerType customerType);
    
    public Map getCustomerTypeSelectLimit(CustomerType customerType);
        /**
     * Retrieves all of the customerTypesByIdList
     */
    public List getCustomerTypesByIdList(final Map idList);

    /**
     * Gets customerType's information based on id.
     * @param id the customerType's id
     * @return customerType populated customerType object
     */
    public CustomerType getCustomerType(final String id);

    /**
     * Saves a customerType's information
     * @param customerType the object to be saved
     */
    public void saveCustomerType(CustomerType customerType);

    /**
     * Removes a customerType from the database by id
     * @param id the customerType's id
     */
    public void removeCustomerType(final String id);
     /**
     * Removes a customerType from the database by id
     * @param idList
     */
    public void removeCustomerTypes(final Map idList);
}

