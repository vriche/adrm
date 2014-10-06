package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ForetArrearage;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ForetArrearageDaoTest extends BaseDaoTestCase {
    private Long foretArrearageId = new Long("1");
    private ForetArrearageDao dao = null;

    public void setForetArrearageDao(ForetArrearageDao dao) {
        this.dao = dao;
    }

    public void testAddForetArrearage() throws Exception {
        ForetArrearage foretArrearage = new ForetArrearage();

        // set required fields

        java.lang.String customerName = "QcMrNwRqWhQgZiNsNmQsYnLoGcEbQkXy";
        foretArrearage.setCustomerName(customerName);        

        java.lang.String incomeCode = "WoDbMpMmOuDyUbYmFcUqIcCwHeHgBdMc";
        foretArrearage.setIncomeCode(incomeCode);        

        java.lang.Integer incomeDate = new Integer(1070963604);
        foretArrearage.setIncomeDate(incomeDate);        

        java.lang.String incomeMode = "VbCqFvNpVvUbLjLpAvYzHiHdQsKfUqAk";
        foretArrearage.setIncomeMode(incomeMode);        

        java.lang.Double incomeMoney = new Double(7.999254414314645E306);
        foretArrearage.setIncomeMoney(incomeMoney);        

        java.lang.String incomePurpose = "PiEbJcIaNlLmFpOtDyJrBiAfGpZgYpCd";
        foretArrearage.setIncomePurpose(incomePurpose);        

        java.lang.Integer payDate = new Integer(1071844552);
        foretArrearage.setPayDate(payDate);        

        java.lang.Double payMoney = new Double(4.578816117569032E307);
        foretArrearage.setPayMoney(payMoney);        

        java.lang.String userName = "CeVrRwQiCfStKoYuJrDoBlQrBlKtFiSd";
        foretArrearage.setUserName(userName);        

        dao.saveForetArrearage(foretArrearage);

        // verify a primary key was assigned
        assertNotNull(foretArrearage.getId());

        // verify set fields are same after save
        assertEquals(customerName, foretArrearage.getCustomerName());
        assertEquals(incomeCode, foretArrearage.getIncomeCode());
        assertEquals(incomeDate, foretArrearage.getIncomeDate());
        assertEquals(incomeMode, foretArrearage.getIncomeMode());
        assertEquals(incomeMoney, foretArrearage.getIncomeMoney());
        assertEquals(incomePurpose, foretArrearage.getIncomePurpose());
        assertEquals(payDate, foretArrearage.getPayDate());
        assertEquals(payMoney, foretArrearage.getPayMoney());
        assertEquals(userName, foretArrearage.getUserName());
    }

    public void testGetForetArrearage() throws Exception {
        ForetArrearage foretArrearage = dao.getForetArrearage(foretArrearageId);
        assertNotNull(foretArrearage);
    }

    public void testGetForetArrearages() throws Exception {
        ForetArrearage foretArrearage = new ForetArrearage();

        List results = dao.getForetArrearages(foretArrearage);
        assertTrue(results.size() > 0);
    }

    public void testSaveForetArrearage() throws Exception {
        ForetArrearage foretArrearage = dao.getForetArrearage(foretArrearageId);

        // update required fields
        java.lang.String customerName = "GyKiVoAvXsUhBtZsMuDvLsGxRrCxMrRe";
        foretArrearage.setCustomerName(customerName);        
        java.lang.String incomeCode = "OuDhOwVqAdTgTqGvCwQpQxLcVeJmRzQp";
        foretArrearage.setIncomeCode(incomeCode);        
        java.lang.Integer incomeDate = new Integer(1384855416);
        foretArrearage.setIncomeDate(incomeDate);        
        java.lang.String incomeMode = "DyCjIwKtYrPmFzAiUqMyHoSwIyCbWlNj";
        foretArrearage.setIncomeMode(incomeMode);        
        java.lang.Double incomeMoney = new Double(1.4660643245800406E308);
        foretArrearage.setIncomeMoney(incomeMoney);        
        java.lang.String incomePurpose = "PrOqZpOqOsFtBeOiIdHkYkAsLjAaJmDl";
        foretArrearage.setIncomePurpose(incomePurpose);        
        java.lang.Integer payDate = new Integer(305094211);
        foretArrearage.setPayDate(payDate);        
        java.lang.Double payMoney = new Double(1.5467208427523883E308);
        foretArrearage.setPayMoney(payMoney);        
        java.lang.String userName = "QhYpKkGfWxMnXlYiFlKxKmJrVaKpTfKe";
        foretArrearage.setUserName(userName);        

        dao.saveForetArrearage(foretArrearage);

        assertEquals(customerName, foretArrearage.getCustomerName());
        assertEquals(incomeCode, foretArrearage.getIncomeCode());
        assertEquals(incomeDate, foretArrearage.getIncomeDate());
        assertEquals(incomeMode, foretArrearage.getIncomeMode());
        assertEquals(incomeMoney, foretArrearage.getIncomeMoney());
        assertEquals(incomePurpose, foretArrearage.getIncomePurpose());
        assertEquals(payDate, foretArrearage.getPayDate());
        assertEquals(payMoney, foretArrearage.getPayMoney());
        assertEquals(userName, foretArrearage.getUserName());
    }

    public void testRemoveForetArrearage() throws Exception {
        Long removeId = new Long("3");
        dao.removeForetArrearage(removeId);
        try {
            dao.getForetArrearage(removeId);
            fail("foretArrearage found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveForetArrearages(final Map idList) throws Exception {
        try {
        	dao.removeForetArrearages(idList);
            fail("foretArrearage found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
