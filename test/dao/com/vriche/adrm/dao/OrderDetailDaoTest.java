package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OrderDetail;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderDetailDaoTest extends BaseDaoTestCase {
    private Long orderDetailId = new Long("1");
    private OrderDetailDao dao = null;

    public void setOrderDetailDao(OrderDetailDao dao) {
        this.dao = dao;
    }

    
    public void testAddOrderDetail() throws Exception {
        OrderDetail orderDetail = new OrderDetail();

        // set required fields

        dao.saveOrderDetail(orderDetail);

        // verify a primary key was assigned
        assertNotNull(orderDetail.getId());

        // verify set fields are same after save
    }

    public void testGetOrderDetail() throws Exception {
        OrderDetail orderDetail = dao.getOrderDetail(orderDetailId);
        assertNotNull(orderDetail);
    }

    public void testGetOrderDetails() throws Exception {
        OrderDetail orderDetail = new OrderDetail();

        List results = dao.getOrderDetails(orderDetail);
        assertTrue(results.size() > 0);
    }

    public void testSaveOrderDetail() throws Exception {
        OrderDetail orderDetail = dao.getOrderDetail(orderDetailId);

        // update required fields

        dao.saveOrderDetail(orderDetail);

    }

    public void testRemoveOrderDetail() throws Exception {
        Long removeId = new Long("3");
        dao.removeOrderDetail(removeId);
        try {
            dao.getOrderDetail(removeId);
            fail("orderDetail found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOrderDetails(final Map idList) throws Exception {
        try {
        	dao.removeOrderDetails(idList);
            fail("orderDetail found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
