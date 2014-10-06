
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.model.OrderLog;
import com.vriche.adrm.service.OrderLogManager;
import com.vriche.adrm.util.OrderLogUtil;

public class OrderLogManagerImpl extends BaseManager implements OrderLogManager {
    private OrderLogDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOrderLogDao(OrderLogDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.order.service.OrderLogManager#getOrderLogsByIdList(final Map idList)
     */
    public List getOrderLogsByIdList(final Map idList) {
        return dao.getOrderLogsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.order.service.OrderLogManager#getOrderLogs(com.vriche.adrm.order.model.OrderLog)
     */
    public List getOrderLogs(final OrderLog orderLog) {
        return dao.getOrderLogs(orderLog);
    }
    public List getOrderLogLists(final OrderLog orderLog,Integer startDate,Integer endDate) {
    	Map mp = new HashMap();
    	Long modifyBy = orderLog.getLog().getModifyBy();
    	if((!"".equals(modifyBy) &&  modifyBy!=null)){
    		mp.put("modifyBy",modifyBy);
    	}
    	String orderCodeFome = orderLog.getOrder().getOrderCode();
    	if((!"".equals(orderCodeFome) &&  orderCodeFome!=null)){
    		mp.put("orderCodeFome",orderCodeFome);
    	}
		mp.put("startDate", startDate);
		mp.put("endDate", endDate);

    	return dao.getOrderLogLists(mp);
    }

    /**
     * @see com.vriche.adrm.order.service.OrderLogManager#getOrderLog(String id)
     */
    public OrderLog getOrderLog(final String id) {
        return dao.getOrderLog(new Long(id));
    }

    /**
     * @see com.vriche.adrm.order.service.OrderLogManager#saveOrderLog(OrderLog orderLog)
     */
    public void saveOrderLog(OrderLog orderLog) {
        dao.saveOrderLog(orderLog);
    }

    /**
     * @see com.vriche.adrm.order.service.OrderLogManager#removeOrderLog(String id)
     */
    public void removeOrderLog(final String id) {
        dao.removeOrderLog(new Long(id));
    }
    
    public void removeOrderLogList(final Integer startDate,Integer endDate) {
    	Map map = new HashMap();
    	map.put("startDate", startDate);
    	map.put("endDate", endDate);
        dao.removeOrderLogList(map);
    }
     /**
     * @see com.vriche.adrm.order.service.OrderLogManager#removeOrderLogs(String Map)
     */
    public void removeOrderLogs(final Map idList) {
        dao.removeOrderLogs(idList);
    }

	public String getOrderLogXML(OrderLog orderLog) {
		List ls = this.getOrderLogs(orderLog);
		return OrderLogUtil.makeGridXML(ls);
	}
}
