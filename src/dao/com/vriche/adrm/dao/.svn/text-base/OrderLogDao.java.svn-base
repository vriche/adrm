
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OrderLog;

public interface OrderLogDao extends Dao {

    /**
     * Retrieves all of the orderLogs
     */
    public List getOrderLogs(OrderLog orderLog);

    
    public List getOrderLogLists(Map map);
    
    /**
     * Retrieves all of the orderLogsByIdList
     */
    public List getOrderLogsByIdList(final Map idList);

    /**
     * Gets orderLog's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the orderLog's id
     * @return orderLog populated orderLog object
     */
    public OrderLog getOrderLog(final Long id);

    /**
     * Saves a orderLog's information
     * @param orderLog the object to be saved
     */    
    public void saveOrderLog(OrderLog orderLog);

    /**
     * Removes a orderLog from the database by id
     * @param id the orderLog's id
     */
    public void removeOrderLog(final Long id);
    
    public void removeOrderLogList(final Map map);
	/**
     * Removes orderLogs from the database by ids
     * @param ids the orderLog's id eg:"'1','2','3'"
     */
    public void removeOrderLogs(final Map idList);
    
    public Map getOrderLogLastModifyDate(final String orderId);
}

