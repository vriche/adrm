
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.ProProgram;
  
public interface ContractPaymentDao extends Dao {

    /**
     * Retrieves all of the contractPayments
     */
    public List getContractPayments(ContractPayment contractPayment);
    
    public List getContractPaymentsDesc(ContractPayment contractPayment);
    
    public List getContractPaymentsTable(ContractPayment contractPayment);
    
    public List getOrderSysPrice(ContractPayment contractPayment);
    
    
    
    public List getOrderSysPriceInContract(ContractPayment contractPayment);
    
    public List getContractPaymentAutoComplet(final ContractPayment contractPayment);
    

    public PaginatedList getContractPaymentsPage(ContractPayment contractPayment,int pageIndex,int pageSize);
    
    public List getContractPaymentsPageByMap(Map mp,int pageIndex,int pageSize);
    
    public List getContractPaymentsCountByMap(Map mp);
    
    public Integer getContractPaymentsCount(ContractPayment contractPayment);
    
    public PaginatedList getContractPaymentsPage_nopay(ContractPayment contractPayment,int pageIndex,int pageSize);
    
    
    public Integer getContractPaymentsCount_nopay(ContractPayment contractPayment);
    
    public void updateContractPaymentMoneyIn(List moneyInList,List moneyUsedList);

    public Integer updateMoneyIn(final Map idList);
    
    public void updatePayMoney(final Map idList);
    
    public void saveContractPaymentVersion(ContractPayment contractPayment);
    
    /**
     * Retrieves all of the contractPaymentsByIdList
     */
    public List getContractPaymentsByIdList(final Map idList);
    
    public List getContractPaymentsByCarrierIdMap(Map mp, int pageIndex, int pageSize);
    public List getContractPaymentsCountByCarrierId(Map mp);
    
    public List getContractPaymentForm(Map mp);
    public List getUserIdByUserName(String userName);
    /**
     * Gets contractPayment's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the contractPayment's id
     * @return contractPayment populated contractPayment object
     */
    public ContractPayment getContractPayment(final Long id);
    
    public List getContractPayment(Map mp);
    

    public Long getPaymentIdMaxByOidOrCid(ContractPayment contractPayment);
    /**
     * Saves a contractPayment's information
     * @param contractPayment the object to be saved
     */    
    public Long saveContractPayment(ContractPayment contractPayment);

    /**
     * Removes a contractPayment from the database by id
     * @param id the contractPayment's id
     */
    public void removeContractPayment(final Long id);
	/**
     * Removes contractPayments from the database by ids
     * @param ids the contractPayment's id eg:"'1','2','3'"
     */
    public void removeContractPayments(final Map idList);
    
    public PaginatedList getContractPaymentsPageByIdList(Map idList,int pageIndex,int pageSize);
    
    public Integer getContractPaymentCountByIdList(Map idList);
    
    public Long getMoneyPayByOrderId(final Long orderId);
    
    public Double getMoneyPayByOrderIdDouble(final Long orderId);
    
    public List getContractPaymentList(Map mp);
    
    
    public List getContractPaymentListPage(Map mp,int pageIndex,int pageSize);
    
    
    public List getContractPaymentsForBalance(ContractPayment contractPayment);
    
    public List getContractPaymentsForBalance2(ContractPayment contractPayment);
    
    public List getContractPaymentsForBalance3(ContractPayment contractPayment);
    public List getContractPaymentsForBalance4(ContractPayment contractPayment);
    
    public List getContractPaymentsPageForBalance(ContractPayment contractPayment,int pageIndex, int pageSize);
    
    public List getContractPaymentsByResource(ContractPayment contractPayment);
    
    public List getContractPaymentsOfContractByResource(ContractPayment contractPayment);
    
    public List getContractPaymentsListPage(ContractPayment contractPayment);
    
    public void updateNamberPayment(Map idList);
    
    public List getPaymentTable(String id);
    
    public List getIncomePullsByOrderDetail(ContractPayment contractPayment);
    
    public List getContractPaymentFormPage(Map mp,int skip,int max);
    
    public ContractPayment getContractPaymentFormCount(Map mp);
    
    public List getContractPaymentsCopy(Long orderId);

}

