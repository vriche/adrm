package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderCategoryDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OrderCategory;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderCategoryDaoTest extends BaseDaoTestCase {
    private Long orderCategoryId = new Long("1");
    private OrderCategoryDao dao = null;

    public void setOrderCategoryDao(OrderCategoryDao dao) {
        this.dao = dao;
    }

    public void testAddOrderCategory() throws Exception {
        OrderCategory orderCategory = new OrderCategory();

        // set required fields

        dao.saveOrderCategory(orderCategory);

        // verify a primary key was assigned
        assertNotNull(orderCategory.getId());

        // verify set fields are same after save
    }

    public void testGetOrderCategory() throws Exception {
        OrderCategory orderCategory = dao.getOrderCategory(orderCategoryId);
        assertNotNull(orderCategory);
    }

    public void testGetOrderCategorys() throws Exception {
        OrderCategory orderCategory = new OrderCategory();

        List results = dao.getOrderCategorys(orderCategory);
        assertTrue(results.size() > 0);
    }

    public void testSaveOrderCategory() throws Exception {
        OrderCategory orderCategory = dao.getOrderCategory(orderCategoryId);

        // update required fields

        dao.saveOrderCategory(orderCategory);

    }

    public void testRemoveOrderCategory() throws Exception {
        Long removeId = new Long("3");
        dao.removeOrderCategory(removeId);
        try {
            dao.getOrderCategory(removeId);
            fail("orderCategory found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOrderCategorys(final Map idList) throws Exception {
        try {
        	dao.removeOrderCategorys(idList);
            fail("orderCategory found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
