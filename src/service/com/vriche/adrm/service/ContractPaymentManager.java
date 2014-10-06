
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.model.ContractPayment;

public interface ContractPaymentManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setContractPaymentDao(ContractPaymentDao contractPaymentDAO);
 
    /**
     * Retrieves all of the contractPayments
     */
    public List getContractPayments(ContractPayment contractPayment);
    
    public List getContractPaymentsDesc(ContractPayment contractPayment);
    
    public String getContractPaymentsTable(ContractPayment contractPayment);
    
    
    public List getContractPaymentAutoComplet(ContractPayment contractPayment);
    
    

    public PaginatedList getContractPaymentsPage(ContractPayment contractPayment,String pageIndex,String pageSize);
    
    
    public String getContractPaymentsCount(ContractPayment contractPayment);
    
    public List getContractPaymentsPageByMap(ContractPayment contractPayment,String carrierId, String pageIndex, String pageSize);
    
    public String getContractPaymentCountByMap(ContractPayment contractPayment,String carrierId);
    
    public PaginatedList getContractPaymentsPage_nopay(ContractPayment contractPayment,String pageIndex,String pageSize);
    
    
    public String getContractPaymentsCount_nopay(ContractPayment contractPayment);
        /**
     * Retrieves all of the contractPaymentsByIdList
     */
    public List getContractPaymentsByIdList(final Map idList);

    /**
     * Gets contractPayment's information based on id.
     * @param id the contractPayment's id
     * @return contractPayment populated contractPayment object
     */
    public ContractPayment getContractPayment(final String id);
    
    public void updateContractPaymentMoneyIn(ContractPayment[] contractPayments,double incomeMoney);

    /**
     * Saves a contractPayment's information
     * @param contractPayment the object to be saved
     */
    public String saveContractPayment(ContractPayment contractPayment);

    public String saveContractPaymentByOrder(int mode,String contractId,String orderId,String customerId,double payMoney,boolean isNew,String categroyName,String year);
    
//    public String saveContractPaymentByOrder(String contractId,String orderId,double payMoney,int orderDetailStates,boolean isNew);
    
    /**
     * Removes a contractPayment from the database by id
     * @param id the contractPayment's id
     */
    public void removeContractPayment(final String id);
     /**
     * Removes a contractPayment from the database by id
     * @param idList
     */
    public void removeContractPayments(final Map idList);
    
//    public List getPaymentsByIncomeUsedList(final String incomeId);
    
    
    
    
    public List getPaymentsByIncomeUsedAndCarrierIdList(final String incomeId,String carrierId, String pageIndex, String pageSize);
    public String getContractPaymentBackCountByCarrierId(String incomeId,String carrierId);
    
    
    
    
    public void returnContractPaymentMoneyIn(String[] paymentIds,String incomeId);
    
    public PaginatedList getContractPaymentsPageByIdList(ContractPayment contractPayment,String pageIndex,String pageSize);
    
    public String getContractPaymentCountByIdList(ContractPayment contractPayment);
    
    public Long getMoneyPayByOrderId(final String orderId);
    
    public String getPaymentsStringList(final List ls);
    
    public String savePutonMoney(String[] ids,double incomeMoney,String incomeId);
    
    public String savePutonMoneyByInIdAndPullId(String[] ids,double incomeMoney,String incomeId,String pullId,String carrierId);
    
    public String saveBackPaymentMoneyIn(String[] ids,String incomeId);
    
    public String saveBackPaymentMoneyInByInIdAndPullId(String[] ids,String incomeId,String pullId);
    
    public List getContractPaymentList(String customerName,String startDate,String endDate);
    
   
    public List getContractPaymentListPage(boolean isLastSumPage,String customerName,String startDate,String endDate,String pageIndex,String pageSize);
    
    
    public String getContractPaymentListCount(String customerName,String startDate,String endDate);
    
    public String getContractPaymentXML(ContractPayment contractPayment);
    
    public String getContractPaymentPageXML(ContractPayment contractPayment,String pageIndex, String pageSize);
    
    public String getContractPaymentCountXML(ContractPayment contractPayment);
    
    public String getContractPaymentFormXml(String year,String loginUser,String userName,String resourceName,String customerName);
    
    public void savePutonMoneyByObj(ContractPayment objs[]);
    
    public void saveBackPaymentMoneyByObj(ContractPayment objs[]);
    
    public void saveContractPaymentVersion(ContractPayment contractPayment);
    
    public String getPaymentListXML(ContractPayment contractPayment);
    
    public void updateNamberPayment( String id);
    
    public Collection getCollections(Map searchMap);
    
    public void savePutonMoneyNew(ContractPayment objs[]);
    
    
    public void testXMTV();
    
    public Map buildParamBy(String strQueryString);
    
//    public List getContractPaymentCount(Map mp);
    
    public String getContractPaymentsPageXML(String strQueryString);
    
    public void saveCuiKuanByNortomOrder(int modle,boolean isMid,String paymentId,String orderId,String customerId,String year,boolean clear);
    
    public List getContractPaymentsCopy(Long orderId);
    
    public String saveBackPutonMonths(String[] querStrs);
    
}

