package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OrderLog;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderLogDaoTest extends BaseDaoTestCase {
    private Long orderLogId = new Long("1");
    private OrderLogDao dao = null;

    public void setOrderLogDao(OrderLogDao dao) {
        this.dao = dao;
    }

    public void testAddOrderLog() throws Exception {
        OrderLog orderLog = new OrderLog();

        // set required fields

        dao.saveOrderLog(orderLog);

        // verify a primary key was assigned
        assertNotNull(orderLog.getId());

        // verify set fields are same after save
    }

    public void testGetOrderLog() throws Exception {
        OrderLog orderLog = dao.getOrderLog(orderLogId);
        assertNotNull(orderLog);
    }

    public void testGetOrderLogs() throws Exception {
        OrderLog orderLog = new OrderLog();

        List results = dao.getOrderLogs(orderLog);
        assertTrue(results.size() > 0);
    }

    public void testSaveOrderLog() throws Exception {
        OrderLog orderLog = dao.getOrderLog(orderLogId);

        // update required fields

        dao.saveOrderLog(orderLog);

    }

    public void testRemoveOrderLog() throws Exception {
        Long removeId = new Long("3");
        dao.removeOrderLog(removeId);
        try {
            dao.getOrderLog(removeId);
            fail("orderLog found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOrderLogs(final Map idList) throws Exception {
        try {
        	dao.removeOrderLogs(idList);
            fail("orderLog found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
