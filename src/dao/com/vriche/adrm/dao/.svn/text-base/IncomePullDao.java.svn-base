
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.IncomePull;

public interface IncomePullDao extends Dao {

    /**
     * Retrieves all of the incomePulls
     */
    public List getIncomePulls(IncomePull incomePull);

    /**
     * Retrieves all of the incomePullsByIdList
     */
    public List getIncomePullsByIdList(final Map idList);

    /**
     * Gets incomePull's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the incomePull's id
     * @return incomePull populated incomePull object
     */
    public IncomePull getIncomePull(final Long id);

    /**
     * Saves a incomePull's information   
     * @param incomePull the object to be saved
     */    
    public Long saveIncomePull(IncomePull incomePull);
    
    

    
    public void saveIncomePullVersion(IncomePull incomePull);

    /**
     * Removes a incomePull from the database by id
     * @param id the incomePull's id
     */
    public void removeIncomePull(final Long id);
	/**
     * Removes incomePulls from the database by ids
     * @param ids the incomePull's id eg:"'1','2','3'"
     */
    public void removeIncomePulls(final Map idList);
    
    public void removeIncomePullByIncomeId(Long incomeId) ;
    
    public List checkRemoveIncomePullByIncomeUsed(Long incomeUsedId);
    
    public List getCustomerIncomeMoneyPull(Map mp);
    
    public List getCustomerIncomePullResult(Map mp);
    
    
    
    /**
     * Retrieves all of the incomesByIdList
     */
    public List getIncomesPulls(IncomePull incomePull);
    
    public List getIncomePullsByCustomerId2(IncomePull incomePull);
    
    
    
    
    public List getOrdersByIncomeId(Long id);
    
    
    public void updateIncomePullMoney(IncomePull incomePull);
    
    public List getCustomerFromIncomeNoInORrder();
    
    public List getIncomePullsByCustomerId3(Map mp);
    
    public IncomePull getIncomePullByIncomeId(final Long incomeId);
}

