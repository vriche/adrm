
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderPublic;

public interface OrderDao extends Dao {

	
    /**
     * Retrieves all of the orders
     */
    public List getOrders(Order order);
    
    public List getOrderForReport(final Order order);
    
    public List getOrdersByUsers(final Map mp);
    
    public Map getOrdersPageByUsersForRelPayInDate(final Map mp);
    
    public List getOrdersByWorkFlowId(final Map mp);
    
    public List getOrderIdsByWorkFlowId(final Map mp);
    
    public List getOrderIdsByState4(final Map mp);
    
    public Integer getOrdersByIdListCount(final Map idList);
    
    public List getOrdersByIdList(final Map idList,int pageIndex,int pageSize);
    
    public PaginatedList getOrdersPage(Order order,int pageIndex,int pageSize);
    
    public List getOrdersPageByUsers(final Map mp,int pageIndex,int pageSize);
    
    public List getOrderListPage(final Map mp);
 
    public List getOrdersForReport(Map mp);
    
    public Integer getOrdersCount(Order order);
    public List getOrdersPageByUsersCount2(Map mp);
    
    public Integer getOrdersPageByUsersCount(Map mp);

    /**
     * Retrieves all of the ordersByIdList
     */
    public List getOrdersByIdList(final Map idList);

    /**
     * Gets order's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the order's id
     * @return order populated order object
     */
    public Order getOrder(final Long id);
    
    public Order getOrderCopy(final Long id);
    
    public OrderPublic getOrderPublic(Long orderId);
    
    
    public List getSpecificInfo(final Map mp);
    

    /**
     * Saves a order's information
     * @param order the object to be saved
     */    
    public Long saveOrder(Order order);

    /**
     * Removes a order from the database by id
     * @param id the order's id
     */
    public void removeOrder(final Long id);
	/**
     * Removes orders from the database by ids
     * @param ids the order's id eg:"'1','2','3'"
     */
    public void removeOrders(final Map idList);
    
    public void updateOrderStates(final Map idList);
    
    public Integer getOrdersByCheckState(String checkState);
    
    public Integer getOrdersByCheckState2(Map mp);
    
    public List getOrderCodeByCheckState1(Map mp);
    
    public List getOrdersPageByUserSum(Map mp);
    
    public List getOrderSignUsersForOpenFire(Map mp);
    
    public List getCustomersByLoginUser(Map mp);
    
    public List getCustomerFromIncomeNoInORrder();
    
    public Order getOrderForEdit(Long id);
    
    public Long saveOrderCopy(final Order order);
    
    public void saveOrderMemo(Map mp);
    
}

