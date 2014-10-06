
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;

public interface OrderDayInfoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOrderDayInfoDao(OrderDayInfoDao orderDayInfoDAO);

    /**
     * Retrieves all of the orderDayInfos
     */
    public List getOrderDayInfos(OrderDayInfo orderDayInfo);
    
    /**
     * Retrieves all of the orderDayInfoId
     */
    public List getOrderDayInfoId(final String id);
    
    
    /**
     * Retrieves all of the orderDayInfos
     */
    public List getDayInfos(OrderDetail orderDetail);
    
    /**
     * Retrieves all of the orderDayInfos
     */
    public List getMonthInfos(OrderDetail orderDetail);
    
    
    public List getMonthInfosByParameter(String orderDetailId,String startDate,String endDate,String resourceId,String specific);
    

    
        /**
     * Retrieves all of the orderDayInfosByIdList
     */
    public List getOrderDayInfosByIdList(final Map idList);

    /**
     * Gets orderDayInfo's information based on id.
     * @param id the orderDayInfo's id
     * @return orderDayInfo populated orderDayInfo object
     */
    public OrderDayInfo getOrderDayInfo(final String id);

    /**
     * Saves a orderDayInfo's information
     * @param orderDayInfo the object to be saved
     */
    public void saveOrderDayInfo(OrderDayInfo orderDayInfo);
    
    public void saveOrderDayInfos(OrderDayInfo orderDayInfos[]);

    /**
     * Removes a orderDayInfo from the database by id
     * @param id the orderDayInfo's id
     */
    public void removeOrderDayInfo(final String id);
     /**
     * Removes a orderDayInfo from the database by id
     * @param idList
     */
    public Collection getBusinessInfosForReport(String orgId ,String startDate, String endDate,String type,String sorStr,String userId,String carrierName,String curUserName,boolean isPutOnORIncome,String channelModel,String isPutYear,String returnValue,String incomPurs);
    
    public void removeOrderDayInfos(final Map idList);

    public Collection getOrderDayInfosReport(String orgId ,String resourceTypeId,String startDate, String endDate,String sorCol,String sorType,String putYear,String userId,String carrierName,String curUserName,String customerId,String channelModeId,String theUser,String incomPurs,String returnValue);
    
    public String getOrderDayInfoCount(String startDate ,String endDate);
    
    public List getCustomerByYearPage(String orgId ,String resourceTypeId,String model,String sortStr,String isPutYear,String year,String[] customerIds,String userId,String carrierName,int channelModelParam,String theUser,String incomPurs,String returnValue);
    
    public String getCustomerByYearPageXML(OrderDayInfo orderDayInfo,String year,String[] customerIds,String userId,String carrierName,int channelModelParam,String theUser);
    
    public List getCustomerByQuarterPage(String year,String[] customerIds,String userId,String carrierName,int channelModelParam);
    
    public String getBusinessCount(String startDate ,String endDate,String userId,String carrierName,int channelModelParam);
    
    public String getCarrierScopeCount(String startDate ,String endDate,String[] carrierIds,String userId,String curUserName,String isPrint);
    
    public int getAllYearCarrierCount(String year,String[] carrierIds,String userId,String curUserName,String isPrint);
    
    public List getBusinessInfos(String orgId ,String startDate ,String type,String endDate,String sortStr,String theUser,String userId,String carrierName,boolean isPutOnORIncome,int channelModelParam,String isPutYear,String returnValue,String incomPurs);
    public String getBusinessAnalyzePagesXML(OrderDayInfo orderDayInfo,String userId,String carrierName,boolean isPutOnORIncome,int channelModelParam);
    
    public Collection getBusinessInfosColl(List ls);
//    public List getPutOnInfos(String startDate, String endDate,boolean isPutOnORIncome);
    
    
    public Collection getCustomerByYearForReport(String orgId ,String resourceTypeId,String type,String sortStr,String isPutYear,String year, String[] customerIds,String userId,String carrierName,String curUserName,String channelModel,String incomPurs,String returnValue);
    public Collection getCustomerByQuarterForReport(String year, String[] customerIds,String userId,String carrierName,String curUserName,String channelModel);
    
    
   // public PaginatedList getOrderDayInfosPage(String startDate ,String endDate,String pageIndex,String pageSize);
    public List getOrderDayInfosPage(String orgId ,String resourceTypeId,String startDate ,String endDate,String sorCol,String sorType,String putYear,String userId,String carrierName,String customerId,int channelModelParam,String theUser,String incomPurs,String returnValue,String weekStr);
    
    public Collection getCarrierByDateColl(List ls);
    
    public List getCarrierByDate(String startDate, String endDate,String[] carrierIds,String userId,String curUserName,String isPrint,String orderCategoryId);
    
    public String getCarrierByDateXML(String startDate, String endDate,String[] carrierIds,String userId,String curUserName,String isPrint,String orderCategoryId);
    
    public List getAllYearCarrier(String year,String[] carrierIds,String userId,String curUserName,String isPrint);
    
    public List getAllYearCarrierRelPuton(String year, String[] carrierIds,String userId,String curUserName,String isPrint);
    
	public List getAllYearCarrierPandect(String year, String[] carrierIds, String userId, String curUserName,String isPrint);
	
    public Collection getCarrierAllYearColl(List ls);
    
    public int getCarrierCount(String startDate, String endDate,String[] carrierIds); 
    
    public PaginatedList getOrderDayInfosAllPage(OrderDayInfo orderDayInfo, String pageIndex, String pageSize);

    public List getResourceByDate(String beginDate,String endDate,String[] resourceIds);
    
    public List getResourceByDate2(String beginDate,String endDate,String[] resourceIds,String customerId,String mode,String orderBy);
   //图表资源查询beginDate,endDate,resourceIds,customerId
    public List getResourceChartByDate(String beginDate,String endDate,String[] resourceIds);
//    public List getResourceByDate(String beginDate,String endDate,String[] resourceIds,String customerId);
    
    public String getTreeGrid(String type,String weekIds,String beginDate,String endDate,String[] resourceIds,String customerId,String mode,String orderBy);

    
    public String getOrderDayInfosPageXML(OrderDayInfo orderDayInfo,String userId,String carrierName,String customerId,int channelModelParam,String theUser);

    public List getResourceListByDate(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint,String orderCategoryId);
    
    public List getAudienceMap(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint,String orderCategoryId);
    
    public String getResourceListByDateXML(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint,String orderSubCategorys,String weekStr);

	public List getCarrierByDatePandect(String startDate, String endDate, String[] resourceIds, String userId, String curUserName, String isPrint);
	
    public String getAudienceListByDateXML(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint);
    
    public String getAllYearCarrierXML(String year,String[] carrierIds,String userId,String curUserName,String type,String isPrint);
    
    public Map getAllYearCarrierMap(List ls);
    
	public Map  getCarrierIncomeByYear(Map mp);
	
	public String getResourceLimit61(String beginDate,String endDate,String startTime,String endTime,String carrierId,String customerId,String mode,String orderBy);

	public List getResourceLimitsBy61(String beginDate,String endDate,String startTime,String endTime,String carrierId,String customerId,String mode,String orderBy);
	public Collection getCollections(Map searchMap,String type);
	
	 public OrderDayInfo[] getOrderDayInfosArray(final OrderDayInfo orderDayInfo);
	 
	 public Collection getTreeGridSumCollection(String strQueryString);
	 public String getTreeGridSum(String strQueryString);
	 
	 public String getAdversByWorkSpanId(String workSpanId,String  publishDate,String  orgId);
	 
	 
}

