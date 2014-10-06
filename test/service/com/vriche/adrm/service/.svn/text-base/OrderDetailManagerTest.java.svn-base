
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.OrderDetailManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderDetailManagerTest extends BaseManagerTestCase {
    private final String orderDetailId = "1";
    private OrderDetailManagerImpl orderDetailManager = new OrderDetailManagerImpl();
    private Mock orderDetailDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        orderDetailDao = new Mock(OrderDetailDao.class);
        orderDetailManager.setOrderDetailDao((OrderDetailDao) orderDetailDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        orderDetailManager = null;
    }

    public void testGetOrderDetails() throws Exception {
        List results = new ArrayList();
        OrderDetail orderDetail = new OrderDetail();
        results.add(orderDetail);

        // set expected behavior on dao
        orderDetailDao.expects(once()).method("getOrderDetails")
            .will(returnValue(results));

//        List orderDetails = orderDetailManager.getOrderDetails(null);
//        assertTrue(orderDetails.size() == 1);
        orderDetailDao.verify();
    }

    public void testGetOrderDetail() throws Exception {
        // set expected behavior on dao
        orderDetailDao.expects(once()).method("getOrderDetail")
            .will(returnValue(new OrderDetail()));
        OrderDetail orderDetail = orderDetailManager.getOrderDetail(orderDetailId);
        assertTrue(orderDetail != null);
        orderDetailDao.verify();
    }

    public void testSaveOrderDetail() throws Exception {
        OrderDetail orderDetail = new OrderDetail();

        // set expected behavior on dao
        orderDetailDao.expects(once()).method("saveOrderDetail")
            .with(same(orderDetail)).isVoid();

        orderDetailManager.saveOrderDetail(orderDetail);
        orderDetailDao.verify();
    }

    public void testAddAndRemoveOrderDetail() throws Exception {
        OrderDetail orderDetail = new OrderDetail();

        // set required fields

        // set expected behavior on dao
        orderDetailDao.expects(once()).method("saveOrderDetail")
            .with(same(orderDetail)).isVoid();
        orderDetailManager.saveOrderDetail(orderDetail);
        orderDetailDao.verify();

        // reset expectations
        orderDetailDao.reset();

        orderDetailDao.expects(once()).method("removeOrderDetail").with(eq(new Long(orderDetailId)));
//        orderDetailManager.removeOrderDetail(orderDetailId);
        orderDetailDao.verify();

        // reset expectations
        orderDetailDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OrderDetail.class, orderDetail.getId());
        orderDetailDao.expects(once()).method("removeOrderDetail").isVoid();
        orderDetailDao.expects(once()).method("getOrderDetail").will(throwException(ex));
//        orderDetailManager.removeOrderDetail(orderDetailId);
        try {
            orderDetailManager.getOrderDetail(orderDetailId);
            fail("OrderDetail with identifier '" + orderDetailId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        orderDetailDao.verify();
    }
}
