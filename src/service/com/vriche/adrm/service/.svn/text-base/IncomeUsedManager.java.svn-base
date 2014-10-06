
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomeUsedDao;
import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.service.Manager;

public interface IncomeUsedManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setIncomeUsedDao(IncomeUsedDao incomeUsedDAO);

    /**
     * Retrieves all of the incomeUseds
     */
    public List getIncomeUseds(IncomeUsed incomeUsed);
        /**
     * Retrieves all of the incomeUsedsByIdList
     */
    public List getIncomeUsedsByIdList(final Map idList);

    /**
     * Gets incomeUsed's information based on id.
     * @param id the incomeUsed's id
     * @return incomeUsed populated incomeUsed object
     */
    public IncomeUsed getIncomeUsed(final String id);

    /**
     * Saves a incomeUsed's information
     * @param incomeUsed the object to be saved
     */
    public void saveIncomeUsed(IncomeUsed incomeUsed);

    /**
     * Removes a incomeUsed from the database by id
     * @param id the incomeUsed's id
     */
    public void removeIncomeUsed(final String id);
     /**
     * Removes a incomeUsed from the database by id
     * @param idList
     */
    public void removeIncomeUseds(final Map idList);
    
    public List getIncomeDetail(String customerId,String version);
    
    public String getIncomeDetailXML(String customerId,String version);
    
    public List getChannelIncomeList(String orgId,String start,String end,String customerId,String carrierId,int channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose,String userId);
   
    public String getIncomeChannelXML(String orgId,String start,String end,String customerId,String carrierId,int channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose,String userId);

    public Map getPuton(Map mp);
    
    public Map getReturnValue(Map mp);
    public Map getReturnValue2(Map mp);
    public Map getReturnValue3(Map mp);
    
    
    public Map getPutonYear(Map mp);
    
    public Map getScopeCarriersPutonMoney(Map mp);
    public Map getScopeResourcesPutonMoney(Map mp);
    
    public Map getScopeIdPutonMoney(Map mp);
    
    public Map getIndustryPutonMoney(Map mp);
    
    public Map getCustomerPutonMoney(Map mp);
    
    
//    public Map getContractPaymentPutonMoney(Map mp);
//    
    
}

