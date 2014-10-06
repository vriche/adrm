
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.PriceTypeDao;
import com.vriche.adrm.model.PriceType;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.PriceTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceTypeManagerTest extends BaseManagerTestCase {
    private final String priceTypeId = "1";
    private PriceTypeManagerImpl priceTypeManager = new PriceTypeManagerImpl();
    private Mock priceTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        priceTypeDao = new Mock(PriceTypeDao.class);
        priceTypeManager.setPriceTypeDao((PriceTypeDao) priceTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        priceTypeManager = null;
    }

    public void testGetPriceTypes() throws Exception {
        List results = new ArrayList();
        PriceType priceType = new PriceType();
        results.add(priceType);

        // set expected behavior on dao
        priceTypeDao.expects(once()).method("getPriceTypes")
            .will(returnValue(results));

        List priceTypes = priceTypeManager.getPriceTypes(null);
        assertTrue(priceTypes.size() == 1);
        priceTypeDao.verify();
    }

    public void testGetPriceType() throws Exception {
        // set expected behavior on dao
        priceTypeDao.expects(once()).method("getPriceType")
            .will(returnValue(new PriceType()));
        PriceType priceType = priceTypeManager.getPriceType(priceTypeId);
        assertTrue(priceType != null);
        priceTypeDao.verify();
    }

    public void testSavePriceType() throws Exception {
        PriceType priceType = new PriceType();

        // set expected behavior on dao
        priceTypeDao.expects(once()).method("savePriceType")
            .with(same(priceType)).isVoid();

        priceTypeManager.savePriceType(priceType);
        priceTypeDao.verify();
    }

    public void testAddAndRemovePriceType() throws Exception {
        PriceType priceType = new PriceType();

        // set required fields

        // set expected behavior on dao
        priceTypeDao.expects(once()).method("savePriceType")
            .with(same(priceType)).isVoid();
        priceTypeManager.savePriceType(priceType);
        priceTypeDao.verify();

        // reset expectations
        priceTypeDao.reset();

        priceTypeDao.expects(once()).method("removePriceType").with(eq(new Long(priceTypeId)));
        priceTypeManager.removePriceType(priceTypeId);
        priceTypeDao.verify();

        // reset expectations
        priceTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(PriceType.class, priceType.getId());
        priceTypeDao.expects(once()).method("removePriceType").isVoid();
        priceTypeDao.expects(once()).method("getPriceType").will(throwException(ex));
        priceTypeManager.removePriceType(priceTypeId);
        try {
            priceTypeManager.getPriceType(priceTypeId);
            fail("PriceType with identifier '" + priceTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        priceTypeDao.verify();
    }
}
