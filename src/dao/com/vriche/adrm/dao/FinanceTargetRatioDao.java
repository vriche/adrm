
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.FinanceTarget;

public interface FinanceTargetRatioDao extends Dao {
 
    /**
     * Retrieves all of the financeTargets
     */
    public List getFinanceTargets(FinanceTarget financeTarget);
    /**
     * Retrieves all of the getFinanceTargetsCount
     */
    public Integer getFinanceTargetsCount(FinanceTarget financeTarget);   
    /**
     * Retrieves all of the getFinanceTargetsPage
     */        
    public List getFinanceTargetsPage(FinanceTarget financeTarget,int pageIndex,int pageSize);
    /**
     * Retrieves all of the financeTargetsByIdList
     */
    public List getFinanceTargetsByMap(final Map mp);
    
    public List getFinanceTargetRaioCarriersByMap(final Map mp);
    
    
    public List getCarrierTargetsByMap(final Map mp);
    
    public List getYearTargetsAnalyze(final Map mp);
    public List getYearRelPutAnalyze(final Map mp);
    public List getYearRelTimeAnalyze(final Map mp);
    public List getYearRelIcomeAnalyze(final Map mp);
    
    public List getCustomerYearRelPutAnalyze(final Map mp);
    public List getCustomerYearRelTimeAnalyze(final Map mp);
    public List getCustomerYearRelIcomeAnalyze(final Map mp);
    
    /**
     * Gets financeTarget's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the financeTarget's id
     * @return financeTarget populated financeTarget object
     */
    public FinanceTarget getFinanceTarget(final Long id);

    /**
     * Saves a financeTarget's information
     * @param financeTarget the object to be saved
     */    
    public Long saveFinanceTarget(FinanceTarget financeTarget);

    /**
     * Removes a financeTarget from the database by id
     * @param id the financeTarget's id
     */
    public void removeFinanceTarget(final Long id);
    
    public void removeFinanceTarget(FinanceTarget financeTarget);
	/**
     * Removes financeTargets from the database by ids
     * @param ids the financeTarget's id eg:"'1','2','3'"
     */
    public void removeFinanceTargets(final Map idList);
    
    public void saveFinanceTargetInfos(FinanceTarget[] financeTargets,List carrierIdList);

    public List getFinanceTargetYear(FinanceTarget financeTarget);
    
    public List getCustomerYear(FinanceTarget financeTarget);
    
    public List getCarrierTargetList(final Map idList);
    
    public List  getArrearsList(Map mp);
    
    public Map  getChannelTarget(Map mp);
    
    public Map  getChannelIncome(Map mp);
    public Map  getChannelRealPuton(Map mp);
    
    
    public Map  getChannelRealPay(Map mp);
    
    public Map  getChannelOrderRealPay(Map mp);
    
    public Map  getChannelOrderRealPuton(Map mp);
}

