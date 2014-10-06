
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OrderDayInfo;

public interface OrderDayInfoDao extends Dao {
    /**
     * Retrieves all of the orderDayInfos
     */ 
    public List getOrderDayInfos(OrderDayInfo orderDayInfo);
    
    public List getOrderDayInfosByDetailIdList(Map mp);
   
    /**
     * Retrieves all of the orderDayInfosByIdList
     */
    public List getOrderDayInfosByIdList(final Map idList);
    
    public List getOrderDayInfos(final Map mp);
    
    public List getOrderDayInfosCopy(final Long orderDetailId);
    
    public List getOrderDayInfosCopy2(Map mp);
    
    
    public List getOrderDayInfosByStartEndDay(Integer startDate,Integer endDate);
    public List getOrderDayInfosForPutOn(Map mp) ;
    public List getOrderDayInfosForPutOn2(Map mp) ;

    /**
     * Gets orderDayInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the orderDayInfo's id
     * @return orderDayInfo populated orderDayInfo object
     */
    public OrderDayInfo getOrderDayInfo(final Long id);

    /**
     * Saves a orderDayInfo's information
     * @param orderDayInfo the object to be saved
     */    
    public void saveOrderDayInfo(OrderDayInfo orderDayInfo);
    

    
    public void saveOrderDayInfos(OrderDayInfo orderDayInfos[]);
    
    public void saveOrderDayInfosRealPlay(Map mp);
    public void saveOrderDayInfosRealPlay2(Map mp);
    
    public void saveOrderDayInfosRelPutOn(Map mp);
    /**
     * Removes a orderDayInfo from the database by id
     * @param id the orderDayInfo's id
     */
    public void removeOrderDayInfo(final Long id);
    
    
    public void  removeOrderDayInfoByOrderDetailId(final Long orderDetailId);
	/**
     * Removes orderDayInfos from the database by ids
     * @param ids the orderDayInfo's id eg:"'1','2','3'"
     */
    public void removeOrderDayInfos(final Map idList);
    
    
    /**
     * Retrieves all of the orderDayInfos
     */
//    public List getDayInfos(OrderDetail orderDetail);
    
    /**
     * Retrieves all of the orderDayInfos
     */
//    public List getMonthInfos(OrderDetail orderDetail);
    
//    public List getMonthInfos(String orderDetailId,String startDate,String endDate,String resourceId,String specific);
    
    public List getCustomerRelIncome(final Map mp); 
    
    public List getCarrierIncome(final Map mp);
    
   // public PaginatedList getOrderDayInfoTotalItem(Map mp,int pageIndex,int pageSize);
   // public List getOrderDayInfoTotalItem(final Map mp);
    
    public Integer getOrderDayInfoCount(Map mp);
    
    
    public List getCustomerByYearPage(Map mp); 
    
 
    
    public List getBusinessPage(Map mp);
    

    
    public List getCarrierByDate(Map mp);
    public List getCarrierAllYear(Map mp);
    public List getAllYearCarrierRelPuton(Map mp);
    
    public PaginatedList getOrderDayInfosAllPage(OrderDayInfo orderDayInfo, int pageIndex, int pageSize) ;
    
    public List getResourceByDate(Map map);
    
    public List getResourceSumByOrgDate(Map map);
    
    public List getUsedTimeByCustomer(Map map);
    
    public List getIdsByPayMentAndIncome(Map mp);
    
    public void saveDayPutOnById(Map mp);
    
    public List getResourceListByDate(Map mp);
    
    public List getScopeResourcesCustomer(Map mp);
    
    public List getAudienceListByDate(Map mp);
    
    public List getResourceByresourceLimit(Map mp);
    
    public void saveResourceDayInfo(OrderDayInfo[] orderDayInfos);
    
    public List getIncomeMoneyAllCarrier(Map mp);
    
    public List getOrderDayInfoId(final Long id);
    
    public List getUsedTimeByCustomerAndTime(Map map);
    
    public List getRelIncomeByStartEndDate(Map mp);
    
    public void saveDetailIdWithMaterChange(Map mp);
    
    public void saveOrderDayInfosCal(Map mp);
    
    
    public void saveOrderDayInfosNew(OrderDayInfo[] orderDayInfos);
    
    public void saveOrderDayInfosRealPlay3(Map mp1,Map mp2);
    
    public List getOrderDayInfosAdversByWorkSpanId(Map mp);
    
    
   

}

