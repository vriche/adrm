
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.CustomerCarrierRel;


public interface CustomerDao extends Dao {

    /**
     * Retrieves all of the customers
     */
    public List getCustomers(Customer customer);
    
    
    public List getCustomersAnalyze(final Customer customer);
    
    
    public List getCustomersByRes(Map mp);
    
    
    public List getCustomers(final Map mp);

    /**
     * Retrieves all of the customersByIdList
     */
    public List getCustomersByIdList(final Map idList);
    
    public List getCustomersPage(Customer customer,int pageIndex,int pageSize);
    
    public Integer getCustomersCount(Customer customer);
    

    /**
     * Gets customer's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the customer's id
     * @return customer populated customer object
     */
    public Customer getCustomer(final Long id);
    public Customer getCustomerForOrderPrint(final Long id);
    
    
    public Customer getCustomer(Customer customer);

    /**
     * Saves a customer's information
     * @param customer the object to be saved
     */    
    public Long saveCustomer(Customer customer);

    /**
     * Removes a customer from the database by id
     * @param id the customer's id
     */
    public void removeCustomer(final Long id);
	/**
     * Removes customers from the database by ids
     * @param ids the customer's id eg:"'1','2','3'"
     */
    public void removeCustomers(final Map idList);
    
    public List getCustomerUserRel(Long customerId);
    
    public List getCustomerIdsByUserId(Long userId);
    
    public void deleteCustomerUserRelByParent(Long customerId);
    
    public void saveCustomerUserRel(final Map mp);
    
    public void saveCustomerUnify(Map mp);
    
    public Long saveCustomerCarrierRel(CustomerCarrierRel customerCarrierRel);
    
    public void removeCustomerCarrierRel(Long id);
    
    public List getCustomerCarrierRelPage(CustomerCarrierRel customerCarrierRel,int pageIndex, int pageSize);
    
    public List getCarrierPageXMLs(CustomerCarrierRel customerCarrierRel,int pageIndex, int pageSize);
    
    public List getCustomerCarrierRelCount(CustomerCarrierRel customerCarrierRel);
    
    public List getCustomerCarrierRels(CustomerCarrierRel customerCarrierRel);
    
    public List getCustomerCarrierRel(CustomerCarrierRel customerCarrierRel);
    
    public Integer getCustomerCarrierRelCountAll(CustomerCarrierRel customerCarrierRel);
    
    public List getCarrierPageXML(CustomerCarrierRel customerCarrierRel);
    
    public List getOrderDetails(CustomerCarrierRel customerCarrierRel);
    
    public Double getIncomeUsedByOrderId(String id);
    
    public List getCustomersFromOrder(Map mp);
    
    public List getCustomersAllForCommand(Map mp) ;
    
    public List getCustFromOrder(Map mp);
    
    public List getCustidsByOrg(Map mp);
    
    public List getCustomerRemote(Map mp);
    
}

