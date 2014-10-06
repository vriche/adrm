
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.OrderManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderManagerTest extends BaseManagerTestCase {
    private final String orderId = "1";
    private OrderManagerImpl orderManager = new OrderManagerImpl();
    private Mock orderDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        orderDao = new Mock(OrderDao.class);
        orderManager.setOrderDao((OrderDao) orderDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        orderManager = null;
    }

    public void testGetOrders() throws Exception {
        List results = new ArrayList();
        Order order = new Order();
        results.add(order);

        // set expected behavior on dao
        orderDao.expects(once()).method("getOrders")
            .will(returnValue(results));

        List orders = orderManager.getOrders(null);
        assertTrue(orders.size() == 1);
        orderDao.verify();
    }

    public void testGetOrder() throws Exception {
        // set expected behavior on dao
        orderDao.expects(once()).method("getOrder")
            .will(returnValue(new Order()));
        Order order = orderManager.getOrder(orderId);
        assertTrue(order != null);
        orderDao.verify();
    }

    public void testSaveOrder() throws Exception {
        Order order = new Order();

        // set expected behavior on dao
        orderDao.expects(once()).method("saveOrder")
            .with(same(order)).isVoid();

        orderManager.saveOrder(order);
        orderDao.verify();
    }

    public void testAddAndRemoveOrder() throws Exception {
        Order order = new Order();

        // set required fields

        // set expected behavior on dao
        orderDao.expects(once()).method("saveOrder")
            .with(same(order)).isVoid();
        orderManager.saveOrder(order);
        orderDao.verify();

        // reset expectations
        orderDao.reset();

        orderDao.expects(once()).method("removeOrder").with(eq(new Long(orderId)));
        orderManager.removeOrder(orderId);
        orderDao.verify();

        // reset expectations
        orderDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Order.class, order.getId());
        orderDao.expects(once()).method("removeOrder").isVoid();
        orderDao.expects(once()).method("getOrder").will(throwException(ex));
        orderManager.removeOrder(orderId);
        try {
            orderManager.getOrder(orderId);
            fail("Order with identifier '" + orderId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        orderDao.verify();
    }
}
