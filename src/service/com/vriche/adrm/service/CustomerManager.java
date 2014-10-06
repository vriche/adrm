
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import org.acegisecurity.AccessDeniedException;

import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.CustomerCarrierRel;
import com.vriche.adrm.model.TreeNode;

public interface CustomerManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setCustomerDao(CustomerDao customerDAO);

    /**
     * Retrieves all of the customers
     */
    public List getCustomers(Customer customer);
    
    public List getCustomersAnalyze(final Customer customer);
    
    public List getCustomersByUser(String userId,String type,String customerName);
    
    
    public List getCustomersPage(Customer customer,String pageIndex,String pageSize);
    
    public String getCustomersCount(Customer customer);
        /**
     * Retrieves all of the customersByIdList
     */
    public List getCustomersByIdList(final Map idList);

    /**
     * Gets customer's information based on id.
     * @param id the customer's id
     * @return customer populated customer object
     */
    public Customer getCustomer(final String id);
    public Customer getCustomerForOrderPrint(final String id);
    
    public Customer getCustomerByObject(Customer customer);
    /**
     * Saves a customer's information
     * @param customer the object to be saved
     * @throws AccessDeniedException 
     * @throws Exception 
     */
    public String saveCustomerForm(Customer customer);
    
    
    
    public String saveCustomer(Long customerId,String customerName,String customerCategoryId,String ownerUserId);

    /**
     * Removes a customer from the database by id
     * @param id the customer's id
     */
    public void removeCustomer(final String id);
     /**
     * Removes a customer from the database by id
     * @param idList
     */
    public void removeCustomers(final Map idList);
    
    public Map getCustomerSelect(Customer customer);
    
    public String getCustomersXML(Customer customer, String IdPrefix);
    public Object[] getCustomerUserRel(String customerId);
    public void saveCustomerUserRel(String customerId, String[] userId);
    
    public void saveUserCustomerRel(String userId, String[] customerId);
    
    public void getCustomersIdsByCategory(String categoryId, StringBuffer sb,String IdPrefix);
    public void getCustomersIdsByCategory(String orgId,String categoryId, StringBuffer sb,String IdPrefix);
    
    public void saveCustomerUnify(Customer customer);
    
    public String getParentCustomersXML(Customer custome);
    
    public String saveCustomerCarrierRel(CustomerCarrierRel carrierRel);
    
    public void removeCustomerCarrierRel(Long id);
    
    public List getCustomerCarrierRels(final CustomerCarrierRel carrierRel);
    
    public String getCustomerCarrierRelPageXML(CustomerCarrierRel carrierRel,String pageIndex, String pageSize);  
    
    public String getCustomerCarrierRelXML(final CustomerCarrierRel carrierRel);
    
    public String getCustomerCarrierRelCountAll(final CustomerCarrierRel carrierRel);

    public String getOrderDetailCountAll(final CustomerCarrierRel carrierRel);
    
    public List getCustomerCarrierRelCount(final CustomerCarrierRel carrierRel);
    
    public String getCarrierPageXML(final CustomerCarrierRel carrierRel,String pageIndex, String pageSize);
    
    public Map getCustomerSelectFromMap(Customer customer);
    
    public List getDetailsByOrderId(final CustomerCarrierRel carrierRel);
    
    public List getCustomerIdByUserId(final String curUserId);
    
    public List getCustomersFromOrder(Customer customer);
    
    public List getTreeForJosin(TreeNode node,Customer customer);
    
    public List getCustomersAllForCommand(Customer customer) ;
    
    public String  getCustomerForReg(Customer customer);
    
    public Customer saveCustomerFormReturnObj(Customer customer);
    
    public List getCustFromOrder(Map mp);
    
    public List getCustomerRemote(Customer customer);
}

