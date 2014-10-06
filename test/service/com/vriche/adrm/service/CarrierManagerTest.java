
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.CarrierManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CarrierManagerTest extends BaseManagerTestCase {
    private final String carrierId = "1";
    private CarrierManagerImpl carrierManager = new CarrierManagerImpl();
    private Mock carrierDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        carrierDao = new Mock(CarrierDao.class);
        carrierManager.setCarrierDao((CarrierDao) carrierDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        carrierManager = null;
    }

    public void testGetCarriers() throws Exception {
        List results = new ArrayList();
        Carrier carrier = new Carrier();
        results.add(carrier);

        // set expected behavior on dao
        carrierDao.expects(once()).method("getCarriers")
            .will(returnValue(results));

        List carriers = carrierManager.getCarriers(null);
        assertTrue(carriers.size() == 1);
        carrierDao.verify();
    }
    
    public void testGetCarriersXml() throws Exception {
    	String results = "";
        carrierDao.expects(once()).method("getCarriersXml")
        .will(returnValue(results));
        
        String rs = carrierManager.getCarriersXml("0");
        assertTrue(rs.length()>0);
        carrierDao.verify();
    }   

    public void testGetCarrier() throws Exception {
        // set expected behavior on dao
        carrierDao.expects(once()).method("getCarrier")
            .will(returnValue(new Carrier()));
        Carrier carrier = carrierManager.getCarrier(carrierId);
        assertTrue(carrier != null);
        carrierDao.verify();
    }

    public void testSaveCarrier() throws Exception {
        Carrier carrier = new Carrier();

        // set expected behavior on dao
        carrierDao.expects(once()).method("saveCarrier")
            .with(same(carrier)).isVoid();

        carrierManager.saveCarrier(carrier);
        carrierDao.verify();
    }

    public void testAddAndRemoveCarrier() throws Exception {
        Carrier carrier = new Carrier();

        // set required fields
        carrier.setCarrierName("FcVzYiUgXgGjTqXtLzJaXrPcKbFcHcUzUqXhVeBsLiVgWhJlXqExEwYlUnNsVcTiZwLsFjAaZpZcDjWwNrSpAaKyTlAoTrIfHmDyAtCzNpNoSwKsPcRvFaGtFrEnGvVw");

        // set expected behavior on dao
        carrierDao.expects(once()).method("saveCarrier")
            .with(same(carrier)).isVoid();
        carrierManager.saveCarrier(carrier);
        carrierDao.verify();

        // reset expectations
        carrierDao.reset();

        carrierDao.expects(once()).method("removeCarrier").with(eq(new Long(carrierId)));
        carrierManager.removeCarrier(carrierId);
        carrierDao.verify();

        // reset expectations
        carrierDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Carrier.class, carrier.getId());
        carrierDao.expects(once()).method("removeCarrier").isVoid();
        carrierDao.expects(once()).method("getCarrier").will(throwException(ex));
        carrierManager.removeCarrier(carrierId);
        try {
            carrierManager.getCarrier(carrierId);
            fail("Carrier with identifier '" + carrierId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        carrierDao.verify();
    }
}
