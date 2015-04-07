
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.FinanceTargetRatioDao;
import com.vriche.adrm.model.FinanceTarget;

public interface FinanceTargetRatioManager extends Manager {

    /** 
     * Setter for DAO, convenient for unit testing
     */
    public void setFinanceTargetRatioDao(FinanceTargetRatioDao financeTargetRatioDAO);

    /**
     * Retrieves all of the financeTargets
     */
//    public List getFinanceTargets(FinanceTarget financeTarget);
    
    public List getFinanceTargets(String year,String curUserName,String carrierId,int channelModelParam);
     /**
     * Retrieves all of the financeTargetsCount
     */
    public String getFinanceTargetsCount(FinanceTarget financeTarget);
     /**
     * Retrieves all of the financeTargetsCount
     */    
    public List getFinanceTargetsPage(FinanceTarget financeTarget,String pageIndex,String pageSize);
     /**
     * Retrieves all of the financeTargetsPageXML
     */   
    public String getFinanceTargetsPageXML(String targetYear,String carrierId,int channelModelParam,String userName);
    
    public String getFinanceTargetRatioCarrierXML(String paramQueryString);
    
    public Collection getFinanceTargetRaioCarriers(String paramQueryString);
    
    
     /**
     * Retrieves all of the financeTargetsByMap
     */
    public List getFinanceTargetsByMap(final Map mp);

    /**
     * Gets financeTarget's information based on id.
     * @param id the financeTarget's id
     * @return financeTarget populated financeTarget object
     */
    public FinanceTarget getFinanceTarget(final String id);

    /**
     * Saves a financeTarget's information
     * @param financeTarget the object to be saved
     */
    public String saveFinanceTarget(FinanceTarget financeTarget);
    
    public void saveFinanceTargets(FinanceTarget financeTargets[],int channelModelParam,String userName);

    /**
     * Removes a financeTarget from the database by id
     * @param id the financeTarget's id
     */
    public void removeFinanceTarget(final String id);
    
    public void removeFTarget(FinanceTarget financeTarget);
     /**
     * Removes a financeTarget from the database by id
     * @param idList
     */
    public void removeFinanceTargets(final Map mp);
    
    public Collection getFinanceTargetCarrierColl(List ls);
    
    public FinanceTarget getFinanceTargetYear(FinanceTarget financeTarget);
    
    public String getYearTargetAnalyzeXml(int size,String type,String carrierId,int channelModelParam,String theUser,String isPutYear,String isNotReturnValue,String purpose);
    
    public String getCustomerYearAnalyzeXml(int size,String type,String customerId,int channelModelParam,String theUser,String isPutYear,String isNotReturnValue,String purpose);
    
    public List getYearTargetAnalyze(int size,String type,String carrierId,int channelModelParam,String theUser,String isPutYear,String isNotReturnValue,String purpose);
    
    public List getCustomerYearAnalyze(int size,String type,String customerId,int channelModelParam,String theUser,String isPutYear,String isNotReturnValue,String purpose);
    
    public List getCarrierTargetByList(String userId,String targetYear,String start,String end,String carrierId,int channelModelParam,String curUserName,String isPutYear,String isNotReturnValue,String purpose);
    
    public String getCarrierTargetXML(String orgId,String userId,String year,String start,String end,String carrierId,int channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose,String customerId);
    
			public List getCarrierTargetPandect(String orgId,String userId,String year,String start,String end,String carrierId,int channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose,String customerId);
	
    public Map getCarrierTargetByYear(String orgId,String userId,String targetDateYear,String startDate,String endDate,String carrierId,int channelModelParam,String curUserName,String isPutYear,String isNotReturnValue,String purpose,String customerId);

    public String  getArrearsXML(String querString);
    
    public Collection  getArrearsColl(String querString,String type);
    
    public Collection  getIncomeRelpayQiank(String querString);
  
    public Object[]  getIncomeRelpayQiankArray(String querString);
    
    
    
}

