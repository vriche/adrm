
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.OrderDayInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderDayInfoManagerTest extends BaseManagerTestCase {
    private final String orderDayInfoId = "1";
    private OrderDayInfoManagerImpl orderDayInfoManager = new OrderDayInfoManagerImpl();
    private Mock orderDayInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        orderDayInfoDao = new Mock(OrderDayInfoDao.class);
        orderDayInfoManager.setOrderDayInfoDao((OrderDayInfoDao) orderDayInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        orderDayInfoManager = null;
    }

    public void testGetOrderDayInfos() throws Exception {
        List results = new ArrayList();
        OrderDayInfo orderDayInfo = new OrderDayInfo();
        results.add(orderDayInfo);

        // set expected behavior on dao
        orderDayInfoDao.expects(once()).method("getOrderDayInfos")
            .will(returnValue(results));

        List orderDayInfos = orderDayInfoManager.getOrderDayInfos(null);
        assertTrue(orderDayInfos.size() == 1);
        orderDayInfoDao.verify();
    }

    public void testGetOrderDayInfo() throws Exception {
        // set expected behavior on dao
        orderDayInfoDao.expects(once()).method("getOrderDayInfo")
            .will(returnValue(new OrderDayInfo()));
        OrderDayInfo orderDayInfo = orderDayInfoManager.getOrderDayInfo(orderDayInfoId);
        assertTrue(orderDayInfo != null);
        orderDayInfoDao.verify();
    }

    public void testSaveOrderDayInfo() throws Exception {
        OrderDayInfo orderDayInfo = new OrderDayInfo();

        // set expected behavior on dao
        orderDayInfoDao.expects(once()).method("saveOrderDayInfo")
            .with(same(orderDayInfo)).isVoid();

        orderDayInfoManager.saveOrderDayInfo(orderDayInfo);
        orderDayInfoDao.verify();
    }

    public void testAddAndRemoveOrderDayInfo() throws Exception {
        OrderDayInfo orderDayInfo = new OrderDayInfo();

        // set required fields

        // set expected behavior on dao
        orderDayInfoDao.expects(once()).method("saveOrderDayInfo")
            .with(same(orderDayInfo)).isVoid();
        orderDayInfoManager.saveOrderDayInfo(orderDayInfo);
        orderDayInfoDao.verify();

        // reset expectations
        orderDayInfoDao.reset();

        orderDayInfoDao.expects(once()).method("removeOrderDayInfo").with(eq(new Long(orderDayInfoId)));
        orderDayInfoManager.removeOrderDayInfo(orderDayInfoId);
        orderDayInfoDao.verify();

        // reset expectations
        orderDayInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OrderDayInfo.class, orderDayInfo.getId());
        orderDayInfoDao.expects(once()).method("removeOrderDayInfo").isVoid();
        orderDayInfoDao.expects(once()).method("getOrderDayInfo").will(throwException(ex));
        orderDayInfoManager.removeOrderDayInfo(orderDayInfoId);
        try {
            orderDayInfoManager.getOrderDayInfo(orderDayInfoId);
            fail("OrderDayInfo with identifier '" + orderDayInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        orderDayInfoDao.verify();
    }
}
