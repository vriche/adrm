
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.IncomeUsed;

public interface IncomeUsedDao extends Dao {

    /**
     * Retrieves all of the incomeUseds
     */
    public List getIncomeUseds(IncomeUsed incomeUsed);
    
    
    public List getIncomeUsedPaymentIds(IncomeUsed incomeUsed);
    

    /**
     * Retrieves all of the incomeUsedsByIdList
     */
    public List getIncomeUsedsByIdList(final Map idList);

    /**
     * Gets incomeUsed's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the incomeUsed's id
     * @return incomeUsed populated incomeUsed object
     */
    public IncomeUsed getIncomeUsed(final Long id);

    /**
     * Saves a incomeUsed's information
     * @param incomeUsed the object to be saved
     */    
    public void saveIncomeUsed(IncomeUsed incomeUsed);

    /**
     * Removes a incomeUsed from the database by id
     * @param id the incomeUsed's id
     */
    public void removeIncomeUsed(final Long id);
	/**
     * Removes incomeUseds from the database by ids
     * @param ids the incomeUsed's id eg:"'1','2','3'"
     */
    public void removeIncomeUseds(final Map idList);
    
    public void deleteIncomeUsedsByPaymentIdAndIncomeId(final Map idList);
    
    public void saveIncomeUsedMoneyIn(List ls);
//    public Double getMoneyInByPaymentId(Long paymentId);
    public List getOrderDayReturnMoney(Map mp);
    
    public List getOrderDetailMoneyinByIncomeuse(Map mp);
    
    
    public void deleteByPaymentIdAndIncomeIdAndDayId(final Map mp) ;
   
    public List getIncomeDetail(Map mp) ;
    
    public List getIncomeUsedForChannel(Map mp);
   
    public List getPutonMoneyAllCustomer(Map mp);
    
    public List getReturnValueAllCustomer(Map mp);

    public List getPutonMoneyAllYear(Map mp);    
    public List getReturnValueAllYear(Map mp);  
    
    public List getReturnValueBussiness(Map mp); 
    
    
    public List getScopeCarriersPutonMoney(Map mp); 
    public List getScopeResourcesPutonMoney(Map mp); 
    
    public List getScopeIdPutonMoney(Map mp);
    
    public List getIndustryPutonMoney(Map mp);
    
    public List getCustomerPutonMoney(Map mp);
    
    public List getOrderDayReturnMoney_IncomeUsedId(Map mp);
//    public List getContractPaymentPutonMoney(Map mp);
    
}

