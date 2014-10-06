package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Order;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderDaoTest extends BaseDaoTestCase {
    private Long orderId = new Long("1");
    private OrderDao dao = null;

    public void setOrderDao(OrderDao dao) {
        this.dao = dao;
    }

    public void testAddOrder() throws Exception {
        Order order = new Order();

        // set required fields

        dao.saveOrder(order);

        // verify a primary key was assigned
        assertNotNull(order.getId());

        // verify set fields are same after save
    }

    public void testGetOrder() throws Exception {
        Order order = dao.getOrder(orderId);
        assertNotNull(order);
    }

    public void testGetOrders() throws Exception {
        Order order = new Order();

        List results = dao.getOrders(order);
        assertTrue(results.size() > 0);
    }

    public void testSaveOrder() throws Exception {
        Order order = dao.getOrder(orderId);

        // update required fields

        dao.saveOrder(order);

    }

    public void testRemoveOrder() throws Exception {
        Long removeId = new Long("3");
        dao.removeOrder(removeId);
        try {
            dao.getOrder(removeId);
            fail("order found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOrders(final Map idList) throws Exception {
        try {
        	dao.removeOrders(idList);
            fail("order found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
