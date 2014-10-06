
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OrderLog;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderLogDaoiBatis extends BaseDaoiBATIS implements OrderLogDao {

    /**
     * @see com.vriche.adrm.order.dao.OrderLogDao#getOrderLogs(com.vriche.adrm.order.model.OrderLog)
     */
    public List getOrderLogs(final OrderLog orderLog) {
          return getSqlMapClientTemplate().queryForList("getOrderLogs", orderLog);
    }
    
    public List getOrderLogLists(final Map map) {
    	
        return getSqlMapClientTemplate().queryForList("getOrderLogLists", map);
  }
    /**
     * @see com.vriche.adrm.order.dao.OrderLogDao#getOrderLogsByIdList(com.vriche.adrm.order.model.OrderLog)
     */
    public List getOrderLogsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOrderLogsByIdList", idList);
    }
    
    public Map getOrderLogLastModifyDate(final String orderId) {
        return getSqlMapClientTemplate().queryForMap("getOrderLogLastModifyDate", orderId,"orderDetailId","log.modifyDate");
   }


    /**
     * @see com.vriche.adrm.order.dao.OrderLogDao#getOrderLog(Long id)
     */
    public OrderLog getOrderLog(Long id) {
        OrderLog orderLog = (OrderLog) getSqlMapClientTemplate().queryForObject("getOrderLog", id);

        if (orderLog == null) {
            throw new ObjectRetrievalFailureException(OrderLog.class, id);
        }

        return orderLog;
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderLogDao#saveOrderLog(OrderLog orderLog)
     */    
    public void saveOrderLog(final OrderLog orderLog) {
        Long id = orderLog.getId();
        // check for new record
            id = (Long) getSqlMapClientTemplate().insert("addOrderLog", orderLog);

        if( id == null ) {
            throw new ObjectRetrievalFailureException(OrderLog.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.order.dao.OrderLogDao#removeOrderLog(Long id)
     */
    public void removeOrderLog(Long id) {
        getSqlMapClientTemplate().update("deleteOrderLog", id);
    }
    
    public void removeOrderLogList(Map mp) {
        getSqlMapClientTemplate().update("deleteOrderLogList", mp);
    }
    /**
     * @see com.vriche.adrm.order.dao.OrderLogDAO#removeOrderLogs(String ids)
     */
    public void removeOrderLogs(final Map idList) {
        getSqlMapClientTemplate().update("deleteOrderLogs", idList);
    }    
}
