
package com.vriche.adrm.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.model.OrderDetail;

public interface OrderDetailDao extends Dao {
	
	public void saveOrderDetailPublicInfo(Map mp);
	
	public void saveOrderDetailPublicInfoMoneyIn(Map mp);


    /**
     * Retrieves all of the orderDetails
     */
    public List getOrderDetails(OrderDetail orderDetail);
    
    public List getOrderDetailIdsByParentId(OrderDetail orderDetail);
    
    public List getOrderDetailsForChangeRate(OrderDetail orderDetail);

    /**
     * Retrieves all of the orderDetailsByIdList
     */
    public List getOrderDetailsByIdList(final Map idList);

    public List getOrderDetailByMap(Map mp) ;
    
  
    
    
    public Integer getOrderDetailByResourceType(Map mp) ;
    
    /**
     * Gets orderDetail's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the orderDetail's id
     * @return orderDetail populated orderDetail object
     */
    public OrderDetail getOrderDetail(final Long id);
    
    public List getOrderDetailByOrderId(final Long id);
    
    public List getOrderDetailByOrderIdCopy(final Map mp);
    
    
//    public List getOrderDetailByOrderIdCopy2(final Map mp);
    
    public PaginatedList getOrderDetailByOrderIdPage(final Long id,int pageIndex,int pageSize);
    
    public List getOrderDetailsPage(OrderDetail orderDetail,int pageIndex,int pageSize);
    
    
    public Integer getOrderDetailByOrderIdCount(final String id);
    
    public Integer getOrderDetailsCount(OrderDetail orderDetail);
    
    
    public String getOrderDetailForXML(Long id);

    /**
     * Saves a orderDetail's information
     * @param orderDetail the object to be saved
     */    
    public Long saveOrderDetail(OrderDetail orderDetail);

    /**
     * Removes a orderDetail from the database by id
     * @param id the orderDetail's id
     */
    public void removeOrderDetail(final Long id);
	/**
     * Removes orderDetails from the database by ids
     * @param ids the orderDetail's id eg:"'1','2','3'"
     */
    public void removeOrderDetails(final Map idList);
    
    public Integer getSumTimes(final Long orderId);
    
    public List getCustomerProductByBeginAndEndDate(final Map idList);
    
    public List getIndustryTypeProductByBeginAndEndDate(final Map idList);
    
    public List getIndustryTypeProductChannelByBeginAndEndDate(Map idList);
    
    public List getAdvTypeProductByBeginAndEndDate(final Map idList);
    
    
    public Integer getCustomerProductCount(final Map map);
    public Integer getIndustryTypeProductCount(final Map map);
    public Integer getAdvTypeProductCount(final Map map);
    
    public List getOrderDetailIdByPublishMemo(Map map);
    
    public List getResTypeByOrderDetail(Map map);
    
    
    public void removeOrderByImport(String publishMemo);
    
    
    public List getOrderDetailsAnalyze(OrderDetail orderDetail);
    
    public Long saveOrderDetail2(final OrderDetail orderDetail);
    
    public void saveOrderDetailRate(List ls);
    
    public Long saveOrderDetailCopy(final OrderDetail orderDetail);
    
    public List getMonthDetailByIncomeId(Map mp,int posStart,int count) ;   
    
    public OrderDetail getMonthDetailByIncomeIdSumNew(Map mp);
    
    public List getMonthDetailByIncomeInfo(Map mp);
    
    public void saveOrderDetailCheckState(Map mp);
    
    public List getCollectionsBroReport(Map mp) ;
    
    public List getCollectionsBroReport2(Map mp) ;
    
    public List getOrderDetailsForBroProve(Map mp);
    
    public List getOrderDetailsPage2(OrderDetail orderDetail);
    
}

