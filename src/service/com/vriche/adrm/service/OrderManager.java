
package com.vriche.adrm.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderPublic;

public interface OrderManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOrderDao(OrderDao orderDAO);

    /**
     * Retrieves all of the orders
     */
    public List getOrders(Order order);
    
    public List getOrdersPageByUsers(Order order, String pageIndex,String pageSize);

    public String getOrdersPageByUsersCount(Order order);
    
    public List getOrdersPageByUsersCount2(Order order,int pageIndex,int pageSize);
   
    public PaginatedList getOrdersPage(Order order,String pageIndex,String pageSize);
    
    public List getOrdersByIdList(final Map idList,String pageIndex, String pageSize);
    
    public String getOrdersByWorkFlowCount(String workFlowId, Order order);
    
    public String getOrdersByWFSearchCount(String workFlowId, int state,String orderCode,String userId);
    
    public List getOrdersByWorkFlowPage(String workFlowId,Order order,String pageIndex, String pageSize);
    
    public List getOrdersByWorkFlowPageSearch(String workFlowId, int state,String orderCode,String userId, String pageIndex, String pageSize);
    
    public String getOrdersCount(Order order);
    
    public List getOrdersAutoWF(String workFlowId,int stateId);
        /**
     * Retrieves all of the ordersByIdList
     */
    public List getOrdersByIdList(final Map idList);

    /**
     * Gets order's information based on id.
     * @param id the order's id
     * @return order populated order object
     */
    public Order getOrder(final String id);
    
    public Order getOrderForEdit(final String id);
    
    public OrderPublic getOrderPublic(final String  orderId);

    /**
     * Saves a order's information
     * @param order the object to be saved
     */
    public String saveOrder(Order order);
    
    public Order saveOrderReturnObj(Order order);

//    public Order saveOrderReturnObj(Order order,int orderDetailStates);
    /**
     * Removes a order from the database by id
     * @param id the order's id
     */
    public void removeOrder(final String id);
     /**
     * Removes a order from the database by id
     * @param idList
     */
    public void removeOrders(final Map idList);
    
    public void updateOrderStates(Set ids, int state);
    
    public void updateOrderStates(String[] ids, int state);
    
    public List getOrdersReport(Order order);
    
    public List getOrdersReportPage(Order order,String pageIndex, String pageSize);
    
    public String getOrderCategoryNameFromMap(String orderId) ;
    
    public String getOrdersReportCount(Order order);
    
//    public Collection getOrdersFromColl(Order order);
    public Collection getOrdersFromColl(Map mp);
    
    public String getOrdersByCheckState(String checkState);
    public String getOrdersByCheckState2(String checkState,String userLongName,String year);
    
    public List getOrderCodeByCheckState1(String checkState,String publishDate,String[] resourceId);
    
    public String getSpecificInfo(String beginDate,String endDate,String[] resourceId, String specificId);
    
    public Collection getCollections(final String queryString,String type);
    
    public List getOrdersPageByUserSum(boolean isLastSumPage,Order order, String pageIndex,String pageSize);

    public String getOrderListXML(Order order);
    
    public Collection getCollections(Map searchMap,String type);
    
    public Collection getOrdersPageByDayScroll(boolean isAllPage,Order order, int skip,int pageSize);
    
    public Order buildParamBy(String strQueryString);
    
    public Order getCountSum(Order order);
    
    public Collection getCollectionsOrderList(final String queryString,String type);
    
    public  String getOrderEditRedirect(String url,String redirectUrl2)throws ServletException, IOException ;
    
    public void updateOrderStates2(String[] ids, int state,String checkUserId,String checkStateIdOld,String defMsg);

    public String  saveOrderClone(String orderId,int model,String loginUserId);

    public String getSpecificInfo2(String queryStr);
    
    
    public String saveOrderStopBro(Order order, String[] orderDetailIds,int startDate,int endDate);
    
    public String saveOrderStopBro2(Order order);
    
    public String saveOrderSpec(Order order, String[] orderDetailIds,int startDate,int endDate,String specValue,Long specId,String specTXT);
    
    public String saveOrderPrice(Order order, String[] orderDetailIds,int startDate,int endDate,double execPrice,double favourRate,double appRate);
    
    public Order saveOrderMoreDetails(Order order,Order orderBackUp) throws OrderDetailUnableSaveException;
    
    public void removeOrderDetailByDetailId(Order orderBackUp,String orderDetailId,String year_month) throws OrderDetailUnableSaveException;
    
    public void saveOrderMemo(Order order);
    
    
}

