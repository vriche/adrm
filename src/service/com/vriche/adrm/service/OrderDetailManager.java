
package com.vriche.adrm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDetail;

public interface OrderDetailManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOrderDetailDao(OrderDetailDao orderDetailDAO);

    /**
     * Retrieves all of the orderDetails
     */
    public List getOrderDetails(OrderDetail orderDetail);
    
    public PaginatedList getOrderDetailByOrderIdPage(final String id,String pageIndex,String pageSize);
    
    public List getOrderDetailsPage(OrderDetail orderDetail,String pageIndex,String pageSize);
    
    public String getOrderDetailsPageXML(OrderDetail orderDetail, String pageIndex, String pageSize);
    
    public String getOrderDetailByOrderIdCount(final String id);
    
    public String getOrderDetailsCount(OrderDetail orderDetail);
    
        /**
     * Retrieves all of the orderDetailsByIdList
     */
    public List getOrderDetailsByIdList(final Map idList);

    /**
     * Gets orderDetail's information based on id.
     * @param id the orderDetail's id
     * @return orderDetail populated orderDetail object
     */
    public OrderDetail getOrderDetail(final String id);
    
    public List getOrderDetailByOrderId(final String id);
    
    
    public String getOrderDetailForXML(final String id);

    /**
     * Saves a orderDetail's information
     * @param orderDetail the object to be saved
     */
    public String saveOrderDetail(OrderDetail orderDetail)  throws OrderDetailUnableSaveException;
    
    public OrderDetail saveOrderDetailReturnObj(OrderDetail orderDetail);
    
    public String saveOrderDetailMMM(boolean isRes,OrderDetail orderDetail,OrderDetail[] orderDetails);

    /**
     * Removes a orderDetail from the database by id
     * @param id the orderDetail's id
     */
    public void removeOrderDetail(OrderDetail orderDetail)throws OrderDetailUnableSaveException;
     /**
     * Removes a orderDetail from the database by id
     * @param idList
     */
    public void removeOrderDetails(final Map idList);
    
    public String getSumTimes(Long orderId);
    
    public List getMonthInfos(OrderDetail orderDetail);
    
    public List getMonthInfosForFree(OrderDetail orderDetail);
    
    public Collection getCustomerProductByBeginAndEndDateColl(String[] carrierIds,String channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint,String orgId);
    
    public List getOaTeleExpensesByBeginAndEndDate(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint);
    
    public Map getOaTeleExpensesByBeginAndEndDate2(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint);
    
    public String getOaTeleExpensesByBeginAndEndDateXML(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint);	
    //行业明细
    public Map getIndustryTypeProductByBeginAndEndDate2(int channelModel,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
    public List getIndustryTypeProductByBeginAndEndDate(int channelModelParam,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
    public String getIndustryTypeProductByBeginAndEndDateXML(int channelModelParam,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
    public List getAdvTypeProductByBeginAndEndDate(int channelModel,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
    //行业总览
    public List getIndustryTypeProductTotalBrowser(int channelModel,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint);
//    public String getIndustryTypeProductTotalBrowserXML(int channelModel,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint);
    
    public String getCustomerProductCount(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint);
    public String getIndustryTypeProductCount(int channelModelParam,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
    public String getAdvTypeProductCount(int channelModelParam,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
    
    public String getOrderDetailXml(String orgId,String orderId);
    
    public String getOrderDetailMonthXml(String qstr);
    
    
    public Collection getOrderDetailss(String orderId,String beginDate,String endDate,String carrierId,String matterName,boolean isRelPrice,int mode);
	public List getOrderCategoryByCarrierTypePandect(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint,String orgId);
  
    public void saveContractPayMent(int model,long sumMoney,long contractId,long orderId,long paymentId,int resourceType);
    
//  保存修改日志
    public String saveOrderLog(OrderDetail oldOrderDetail,OrderDetail curOrderDetail);
    
    public void removeImportOrderByPublishMemo(String publishMemo)throws OrderDetailUnableSaveException;
    
    public Collection getIndustryTypeProductChannelCollections(final String queryString,String type);
    
    public void saveImportOrderDetails(Long orderId,Long customerId,List orderDetailList);
    
    public String  saveOrderDetails(OrderDetail orderDetail);
    
    public String getOrderDetailsAnalyze(OrderDetail orderDetail);
    
    public Collection getCollectionsBroReport(final String queryString,String type);
    

    
    public Map buildsearchMap(String strQueryString);

    public OrderDetail getCountSum(Map searchMap);
    
    public Collection getMonthDetailByIncomeId(Map searchMap,String type,int posStart,int count);
    
    public String getOaTeleExpensesByBeginAndEndDateXML2(String strQueryString);
    
    public void saveOrderDetailCheckState(String orderDetailIds,String state);
    
			public void updateOrderDayRealpay(OrderDetail orderDetail,boolean isCompages);
			
		    //保存冗余数据，
			public void saveOrderDetailPublicInfo(OrderDetail orderDetail,int opt);
    
    

 


    
}

