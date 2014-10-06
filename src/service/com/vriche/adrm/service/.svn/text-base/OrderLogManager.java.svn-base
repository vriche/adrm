
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.model.OrderLog;
import com.vriche.adrm.service.Manager;

public interface OrderLogManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOrderLogDao(OrderLogDao orderLogDAO);

    /**
     * Retrieves all of the orderLogs
     */
    public List getOrderLogs(OrderLog orderLog);
    public List getOrderLogLists(OrderLog orderLog,Integer startDate,Integer endDate);
        /**
     * Retrieves all of the orderLogsByIdList
     */
    public List getOrderLogsByIdList(final Map idList);

    /**
     * Gets orderLog's information based on id.
     * @param id the orderLog's id
     * @return orderLog populated orderLog object
     */
    public OrderLog getOrderLog(final String id);

    /**
     * Saves a orderLog's information
     * @param orderLog the object to be saved
     */
    public void saveOrderLog(OrderLog orderLog);

    /**
     * Removes a orderLog from the database by id
     * @param id the orderLog's id
     */
    public void removeOrderLog(final String id);
    
    public void removeOrderLogList(final Integer startDate,Integer endDate);
     /**
     * Removes a orderLog from the database by id
     * @param idList
     */
    public void removeOrderLogs(final Map idList);
    
    public String getOrderLogXML(OrderLog orderLog);
    
}

