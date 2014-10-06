package com.vriche.adrm.dao;


import java.util.Map;

import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.BaseDaoTestCase;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CarrierDaoTest extends BaseDaoTestCase {
    private Long carrierId = new Long("1");
    private CarrierDao dao = null;

    
    public void setCarrierDao(CarrierDao dao) {
        this.dao = dao;
    }

    public void testAddCarrier() throws Exception {
        Carrier carrier = new Carrier();

        
        // set required fields

        java.lang.String carrierName = "QbEeTvEzQnPfFhHgHeXfElZbQhVfUiQnFbSjGmPdDfWdFvJbLdJgJmPbUcEmPhUsVfZcXfWsVeBaJaOvAnFxUnIdVgArGrRvNrVhVtQlHiQvImUbKhPuMjNlRmOoIsAr";
        carrier.setCarrierName(carrierName);        

        dao.saveCarrier(carrier);

        // verify a primary key was assigned
        assertNotNull(carrier.getId());

        // verify set fields are same after save
        assertEquals(carrierName, carrier.getCarrierName());
    }

    public void testGetCarrier() throws Exception {
        Carrier carrier = dao.getCarrier(carrierId);
        assertNotNull(carrier);
    }

//    public void testGetCarriers() throws Exception {
//        Carrier carrier = new Carrier();
//
//        List results = dao.getCarriers(carrier);
//        assertTrue(results.size() > 0);
//    }
    
    public void testGetCarriers() throws Exception {
        String results = dao.getCarriersTypeXml("0");
        assertTrue(results.length() > 0);
    }   
    

    public void testSaveCarrier() throws Exception {
        Carrier carrier = dao.getCarrier(carrierId);

        // update required fields
        java.lang.String carrierName = "KzJwLdGtKhPlNeUyHtJaCgSqFtTgRvTuYjTzQiRnNsZpGiUiNxItKeKaCrMzEaKwMtVbFjUvUwKvTqRfKrVdRsUaPhYiSdZpZvMkQlZgRpEyWwGwWqGjUnAfWbAtZpVw";
        carrier.setCarrierName(carrierName);        

        dao.saveCarrier(carrier);

        assertEquals(carrierName, carrier.getCarrierName());
    }

    public void testRemoveCarrier() throws Exception {
        Long removeId = new Long("3");
        dao.removeCarrier(removeId);
        try {
            dao.getCarrier(removeId);
            fail("carrier found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveCarriers(final Map idList) throws Exception {
        try {
        	dao.removeCarriers(idList);
            fail("carrier found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
