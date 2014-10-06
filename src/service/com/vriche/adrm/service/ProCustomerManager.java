
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.dao.ProCustomerDao;

public interface ProCustomerManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProCustomerDao(ProCustomerDao proCustomerDAO);

    /**
     * Retrieves all of the proCustomers
     */
    public List getProCustomers(ProCustomer proCustomer);
    
    /**
     * Retrieves all of the getProCustomersId
     */
    public ProCustomer getProCustomersId(final ProCustomer proCustomer);
     /**
     * Retrieves all of the proCustomersCount
     */
    public String getProCustomersCount(ProCustomer proCustomer);
     /**
     * Retrieves all of the proCustomersCount
     */    
    public List getProCustomersPage(ProCustomer proCustomer,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proCustomersPageXML
     */   
    public String getProCustomersPageXML(ProCustomer proCustomer,String pageIndex,String pageSize);
    /**
     * Retrieves all of the proCustomersPageXML
     */   
    public String getProCustomersXML(ProCustomer proCustomer);
    
    public String getProCustomerListXML(ProCustomer proCustomer);
    public List getProCustomerList(String customerName, String helpCode, Long typeId, String telephone, String linkmanName, String accountAddress);
     /**
     * Retrieves all of the proCustomersByMap
     */
    public List getProCustomersByMap(final Map mp);
    public Map getCustomerName(Map mp);

    /**
     * Gets proCustomer's information based on id.
     * @param id the proCustomer's id
     * @return proCustomer populated proCustomer object
     */
    public ProCustomer getProCustomer(final String id);

    /**
     * Saves a proCustomer's information
     * @param proCustomer the object to be saved
     */
    public String saveProCustomer(ProCustomer proCustomer);

    /**
     * Removes a proCustomer from the database by id
     * @param id the proCustomer's id
     */
    public void removeProCustomer(final String id);
     /**
     * Removes a proCustomer from the database by id
     * @param idList
     */
    public void removeProCustomers(final Map mp);
    
    public Collection getCollections(final String queryString,String type);
}

