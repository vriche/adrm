
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.model.OrderLog;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.OrderLogManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderLogManagerTest extends BaseManagerTestCase {
    private final String orderLogId = "1";
    private OrderLogManagerImpl orderLogManager = new OrderLogManagerImpl();
    private Mock orderLogDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        orderLogDao = new Mock(OrderLogDao.class);
        orderLogManager.setOrderLogDao((OrderLogDao) orderLogDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        orderLogManager = null;
    }

    public void testGetOrderLogs() throws Exception {
        List results = new ArrayList();
        OrderLog orderLog = new OrderLog();
        results.add(orderLog);

        // set expected behavior on dao
        orderLogDao.expects(once()).method("getOrderLogs")
            .will(returnValue(results));

        List orderLogs = orderLogManager.getOrderLogs(null);
        assertTrue(orderLogs.size() == 1);
        orderLogDao.verify();
    }

    public void testGetOrderLog() throws Exception {
        // set expected behavior on dao
        orderLogDao.expects(once()).method("getOrderLog")
            .will(returnValue(new OrderLog()));
        OrderLog orderLog = orderLogManager.getOrderLog(orderLogId);
        assertTrue(orderLog != null);
        orderLogDao.verify();
    }

    public void testSaveOrderLog() throws Exception {
        OrderLog orderLog = new OrderLog();

        // set expected behavior on dao
        orderLogDao.expects(once()).method("saveOrderLog")
            .with(same(orderLog)).isVoid();

        orderLogManager.saveOrderLog(orderLog);
        orderLogDao.verify();
    }

    public void testAddAndRemoveOrderLog() throws Exception {
        OrderLog orderLog = new OrderLog();

        // set required fields

        // set expected behavior on dao
        orderLogDao.expects(once()).method("saveOrderLog")
            .with(same(orderLog)).isVoid();
        orderLogManager.saveOrderLog(orderLog);
        orderLogDao.verify();

        // reset expectations
        orderLogDao.reset();

        orderLogDao.expects(once()).method("removeOrderLog").with(eq(new Long(orderLogId)));
        orderLogManager.removeOrderLog(orderLogId);
        orderLogDao.verify();

        // reset expectations
        orderLogDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OrderLog.class, orderLog.getId());
        orderLogDao.expects(once()).method("removeOrderLog").isVoid();
        orderLogDao.expects(once()).method("getOrderLog").will(throwException(ex));
        orderLogManager.removeOrderLog(orderLogId);
        try {
            orderLogManager.getOrderLog(orderLogId);
            fail("OrderLog with identifier '" + orderLogId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        orderLogDao.verify();
    }
}
