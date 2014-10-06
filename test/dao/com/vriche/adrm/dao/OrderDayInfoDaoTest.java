package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OrderDayInfo;

import org.springframework.orm.ObjectRetrievalFailureException;


public class OrderDayInfoDaoTest extends BaseDaoTestCase {
    private Long orderDayInfoId = new Long("1");
    private OrderDayInfoDao dao = null;

    public void setOrderDayInfoDao(OrderDayInfoDao dao) {
        this.dao = dao;
    }

    
    public void testAddOrderDayInfo() throws Exception {
        OrderDayInfo orderDayInfo = new OrderDayInfo();

        // set required fields

        dao.saveOrderDayInfo(orderDayInfo);

        // verify a primary key was assigned
        assertNotNull(orderDayInfo.getId());

        // verify set fields are same after save
    }

    
    public void testGetOrderDayInfo() throws Exception {
        OrderDayInfo orderDayInfo = dao.getOrderDayInfo(orderDayInfoId);
        assertNotNull(orderDayInfo);
    }

    public void testGetOrderDayInfos() throws Exception {
        OrderDayInfo orderDayInfo = new OrderDayInfo();

        List results = dao.getOrderDayInfos(orderDayInfo);
        assertTrue(results.size() > 0);
    }

    public void testSaveOrderDayInfo() throws Exception {
        OrderDayInfo orderDayInfo = dao.getOrderDayInfo(orderDayInfoId);

        // update required fields

        dao.saveOrderDayInfo(orderDayInfo);

    }
    
    public void testGetDayInfos(){
    	
//        List ls = dao.getMonthInfos("26","20060101","20061006","1","2");
//        assertTrue(ls.size() > 0);
//        String orderDetailId,String startDate,String endDate,String resourceId
    }

    public void testRemoveOrderDayInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removeOrderDayInfo(removeId);
        try {
            dao.getOrderDayInfo(removeId);
            fail("orderDayInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOrderDayInfos(final Map idList) throws Exception {
        try {
        	dao.removeOrderDayInfos(idList);
            fail("orderDayInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
