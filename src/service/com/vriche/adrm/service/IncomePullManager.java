
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.model.IncomePull;
import com.vriche.adrm.service.Manager;

public interface IncomePullManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setIncomePullDao(IncomePullDao incomePullDAO);

    /**
     * Retrieves all of the incomePulls
     */
    public List getIncomePulls(IncomePull incomePull);
        /**
     * Retrieves all of the incomePullsByIdList
     */
    public List getIncomePullsByIdList(final Map idList);

    /**
     * Gets incomePull's information based on id.
     * @param id the incomePull's id
     * @return incomePull populated incomePull object
     */
    public IncomePull getIncomePull(final String id);

    /**
     * Saves a incomePull's information
     * @param incomePull the object to be saved
     */
    public void saveIncomePull(IncomePull incomePull);

    /**
     * Removes a incomePull from the database by id
     * @param id the incomePull's id
     */
    public void removeIncomePull(final String id);
     /**
     * Removes a incomePull from the database by id
     * @param idList
     */
    public void removeIncomePulls(final Map idList);
     
    public void removeIncomePullByIncomeId(Long incomeId);
    public List getCustomerIncomeMoneyList(String orgId,String putYear,String userName,int channelModelParam,String customerId,String carrierName,String userId,String start,String end,String[] purpose,String arrears);
    public String getCustomerIncomeMoneyListGrid(String orgId,String putYear,String userName,int channelModelParam,String customerId,String carrierName,String userId,String start,String end,String[] purpose,String arrears);
        
    
    public List checkRemoveIncomePullByIncomeUsed(final String incomeUsedId);
    
    
    
    public List getIncomesPulls(IncomePull incomePull);
    
    public String getIncomesPullsXML(IncomePull incomePull);
    
    
    public void saveIncomePullVersion(IncomePull incomePull);
    
    public List getOrdersByIncomeId(final String id);
    
    public String getIncomesPullsXML2(IncomePull incomePull);
    
    public String getIncomesPullsXM3(IncomePull incomePull);
    
    public Collection getIncomesPullsCollections(Map mp);
}

