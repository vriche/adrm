
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProCustomer;

public interface ProCustomerDao extends Dao {

    /**
     * Retrieves all of the proCustomers
     */
    public List getProCustomers(ProCustomer proCustomer);
    /**
     * Retrieves all of the getProCustomersCount
     */
    public Integer getProCustomersCount(ProCustomer proCustomer);   
    /**
     * Retrieves all of the getProCustomersPage
     */        
    public List getProCustomersPage(ProCustomer proCustomer,int pageIndex,int pageSize);
    /**
     * Retrieves all of the proCustomersByIdList
     */
    public List getProCustomersByMap(final Map mp);

    /**
     * Gets proCustomer's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the proCustomer's id
     * @return proCustomer populated proCustomer object
     */
    public ProCustomer getProCustomer(final Long id);

    /**
     * Saves a proCustomer's information
     * @param proCustomer the object to be saved
     */    
    public Long saveProCustomer(ProCustomer proCustomer);

    /**
     * Removes a proCustomer from the database by id
     * @param id the proCustomer's id
     */
    public void removeProCustomer(final Long id);
	/**
     * Removes proCustomers from the database by ids
     * @param ids the proCustomer's id eg:"'1','2','3'"
     */
    public void removeProCustomers(final Map idList);
}

