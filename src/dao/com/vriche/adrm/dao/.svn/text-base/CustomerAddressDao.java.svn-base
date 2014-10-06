
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.CustomerAddress;

public interface CustomerAddressDao extends Dao {

    /**
     * Retrieves all of the customerAddresss
     */
    public List getCustomerAddresss(CustomerAddress customerAddress);

    /**
     * Retrieves all of the customerAddresssByIdList
     */
    public List getCustomerAddresssByIdList(final Map idList);

    /**
     * Gets customerAddress's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the customerAddress's id
     * @return customerAddress populated customerAddress object
     */
    public CustomerAddress getCustomerAddress(final Long id);

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
    public void removeCustomerAddress(final Long id);
	/**
     * Removes customerAddresss from the database by ids
     * @param ids the customerAddress's id eg:"'1','2','3'"
     */
    public void removeCustomerAddresss(final Map idList);
    
    public PaginatedList getCustomerAddressPage(CustomerAddress customerAddress, int pageIndex, int pageSize);
    
    public Integer getCustomerAddressCount(CustomerAddress customerAddress);
    
}

