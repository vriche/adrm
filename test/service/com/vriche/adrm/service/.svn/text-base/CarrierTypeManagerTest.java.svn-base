
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.CarrierTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CarrierTypeManagerTest extends BaseManagerTestCase {
    private final String carrierTypeId = "1";
    private CarrierTypeManagerImpl carrierTypeManager = new CarrierTypeManagerImpl();
    private Mock carrierTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        carrierTypeDao = new Mock(CarrierTypeDao.class);
        carrierTypeManager.setCarrierTypeDao((CarrierTypeDao) carrierTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        carrierTypeManager = null;
    }

    public void testGetCarrierTypes() throws Exception {
        List results = new ArrayList();
        CarrierType carrierType = new CarrierType();
        results.add(carrierType);

        // set expected behavior on dao
        carrierTypeDao.expects(once()).method("getCarrierTypes")
            .will(returnValue(results));

        List carrierTypes = carrierTypeManager.getCarrierTypes(null);
        assertTrue(carrierTypes.size() == 1);
        carrierTypeDao.verify();
    }

    public void testGetCarrierType() throws Exception {
        // set expected behavior on dao
        carrierTypeDao.expects(once()).method("getCarrierType")
            .will(returnValue(new CarrierType()));
        CarrierType carrierType = carrierTypeManager.getCarrierType(carrierTypeId);
        assertTrue(carrierType != null);
        carrierTypeDao.verify();
    }

    public void testSaveCarrierType() throws Exception {
        CarrierType carrierType = new CarrierType();

        // set expected behavior on dao
        carrierTypeDao.expects(once()).method("saveCarrierType")
            .with(same(carrierType)).isVoid();

        carrierTypeManager.saveCarrierType(carrierType);
        carrierTypeDao.verify();
    }

    public void testAddAndRemoveCarrierType() throws Exception {
        CarrierType carrierType = new CarrierType();

        // set required fields
        carrierType.setName("GoSrRfPoCmFrFzVePgXfSnZiRoZjLrYzGqKyZtOrLfIqBsKfTpZiAhCnPvUxVgYqQzKrMvCdMnZrAkArEzGbMaBwYqDhPcNqTpIaNlFvDrFhTsYoSgGlAlWjGlLlZxSe");

        // set expected behavior on dao
        carrierTypeDao.expects(once()).method("saveCarrierType")
            .with(same(carrierType)).isVoid();
        carrierTypeManager.saveCarrierType(carrierType);
        carrierTypeDao.verify();

        // reset expectations
        carrierTypeDao.reset();

        carrierTypeDao.expects(once()).method("removeCarrierType").with(eq(new String(carrierTypeId)));
        carrierTypeManager.removeCarrierType(carrierTypeId);
        carrierTypeDao.verify();

        // reset expectations
        carrierTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(CarrierType.class, carrierType.getId());
        carrierTypeDao.expects(once()).method("removeCarrierType").isVoid();
        carrierTypeDao.expects(once()).method("getCarrierType").will(throwException(ex));
        carrierTypeManager.removeCarrierType(carrierTypeId);
        try {
            carrierTypeManager.getCarrierType(carrierTypeId);
            fail("CarrierType with identifier '" + carrierTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        carrierTypeDao.verify();
    }
}
