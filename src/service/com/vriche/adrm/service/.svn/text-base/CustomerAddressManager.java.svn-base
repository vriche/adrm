
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.CustomerAddressDao;
import com.vriche.adrm.model.CustomerAddress;
import com.vriche.adrm.service.Manager;

public interface CustomerAddressManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setCustomerAddressDao(CustomerAddressDao customerAddressDAO);

    /**
     * Retrieves all of the customerAddresss
     */
    public List getCustomerAddresss(CustomerAddress customerAddress);
        /**
     * Retrieves all of the customerAddresssByIdList
     */
    public List getCustomerAddresssByIdList(final Map idList);

    /**
     * Gets customerAddress's information based on id.
     * @param id the customerAddress's id
     * @return customerAddress populated customerAddress object
     */
    public CustomerAddress getCustomerAddress(final String id);

    /**
     * Saves a customerAddress's information
     * @param customerAddress the object to be saved
     */
    public void saveCustomerAddress(CustomerAddress customerAddress);
    
    public Long saveCustomerAddressList(CustomerAddress customerAddress);

    /**
     * Removes a customerAddress from the database by id
     * @param id the customerAddress's id
     */
    public void removeCustomerAddress(final String id);
     /**
     * Removes a customerAddress from the database by id
     * @param idList
     */
    public void removeCustomerAddresss(final Map idList);
    
    public PaginatedList getCustomerAddressPage(CustomerAddress customerAddress, String pageIndex, String pageSize);
    
    public String getCustomerAddressCount(CustomerAddress customerAddress);
    
    public String getCustomerAddresssXML(String customerId);
}

