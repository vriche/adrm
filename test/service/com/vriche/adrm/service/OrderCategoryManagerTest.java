
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.OrderCategoryDao;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.OrderCategoryManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderCategoryManagerTest extends BaseManagerTestCase {
    private final String orderCategoryId = "1";
    private OrderCategoryManagerImpl orderCategoryManager = new OrderCategoryManagerImpl();
    private Mock orderCategoryDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        orderCategoryDao = new Mock(OrderCategoryDao.class);
        orderCategoryManager.setOrderCategoryDao((OrderCategoryDao) orderCategoryDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        orderCategoryManager = null;
    }

    public void testGetOrderCategorys() throws Exception {
        List results = new ArrayList();
        OrderCategory orderCategory = new OrderCategory();
        results.add(orderCategory);

        // set expected behavior on dao
        orderCategoryDao.expects(once()).method("getOrderCategorys")
            .will(returnValue(results));

        List orderCategorys = orderCategoryManager.getOrderCategorys(null);
        assertTrue(orderCategorys.size() == 1);
        orderCategoryDao.verify();
    }

    public void testGetOrderCategory() throws Exception {
        // set expected behavior on dao
        orderCategoryDao.expects(once()).method("getOrderCategory")
            .will(returnValue(new OrderCategory()));
        OrderCategory orderCategory = orderCategoryManager.getOrderCategory(orderCategoryId);
        assertTrue(orderCategory != null);
        orderCategoryDao.verify();
    }

    public void testSaveOrderCategory() throws Exception {
        OrderCategory orderCategory = new OrderCategory();

        // set expected behavior on dao
        orderCategoryDao.expects(once()).method("saveOrderCategory")
            .with(same(orderCategory)).isVoid();

        orderCategoryManager.saveOrderCategory(orderCategory);
        orderCategoryDao.verify();
    }

    public void testAddAndRemoveOrderCategory() throws Exception {
        OrderCategory orderCategory = new OrderCategory();

        // set required fields

        // set expected behavior on dao
        orderCategoryDao.expects(once()).method("saveOrderCategory")
            .with(same(orderCategory)).isVoid();
        orderCategoryManager.saveOrderCategory(orderCategory);
        orderCategoryDao.verify();

        // reset expectations
        orderCategoryDao.reset();

        orderCategoryDao.expects(once()).method("removeOrderCategory").with(eq(new Long(orderCategoryId)));
        orderCategoryManager.removeOrderCategory(orderCategoryId);
        orderCategoryDao.verify();

        // reset expectations
        orderCategoryDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OrderCategory.class, orderCategory.getId());
        orderCategoryDao.expects(once()).method("removeOrderCategory").isVoid();
        orderCategoryDao.expects(once()).method("getOrderCategory").will(throwException(ex));
        orderCategoryManager.removeOrderCategory(orderCategoryId);
        try {
            orderCategoryManager.getOrderCategory(orderCategoryId);
            fail("OrderCategory with identifier '" + orderCategoryId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        orderCategoryDao.verify();
    }
}
