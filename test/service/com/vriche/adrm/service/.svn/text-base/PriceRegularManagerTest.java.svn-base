
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.PriceRegularDao;
import com.vriche.adrm.model.PriceRegular;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.PriceRegularManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceRegularManagerTest extends BaseManagerTestCase {
    private final String priceRegularId = "1";
    private PriceRegularManagerImpl priceRegularManager = new PriceRegularManagerImpl();
    private Mock priceRegularDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        priceRegularDao = new Mock(PriceRegularDao.class);
        priceRegularManager.setPriceRegularDao((PriceRegularDao) priceRegularDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        priceRegularManager = null;
    }

    public void testGetPriceRegulars() throws Exception {
        List results = new ArrayList();
        PriceRegular priceRegular = new PriceRegular();
        results.add(priceRegular);

        // set expected behavior on dao
        priceRegularDao.expects(once()).method("getPriceRegulars")
            .will(returnValue(results));

        List priceRegulars = priceRegularManager.getPriceRegulars(null);
        assertTrue(priceRegulars.size() == 1);
        priceRegularDao.verify();
    }

    public void testGetPriceRegular() throws Exception {
        // set expected behavior on dao
        priceRegularDao.expects(once()).method("getPriceRegular")
            .will(returnValue(new PriceRegular()));
        PriceRegular priceRegular = priceRegularManager.getPriceRegular(priceRegularId);
        assertTrue(priceRegular != null);
        priceRegularDao.verify();
    }

    public void testSavePriceRegular() throws Exception {
        PriceRegular priceRegular = new PriceRegular();

        // set expected behavior on dao
        priceRegularDao.expects(once()).method("savePriceRegular")
            .with(same(priceRegular)).isVoid();

        priceRegularManager.savePriceRegular(priceRegular);
        priceRegularDao.verify();
    }

    public void testAddAndRemovePriceRegular() throws Exception {
        PriceRegular priceRegular = new PriceRegular();

        // set required fields

        // set expected behavior on dao
        priceRegularDao.expects(once()).method("savePriceRegular")
            .with(same(priceRegular)).isVoid();
        priceRegularManager.savePriceRegular(priceRegular);
        priceRegularDao.verify();

        // reset expectations
        priceRegularDao.reset();

        priceRegularDao.expects(once()).method("removePriceRegular").with(eq(new Long(priceRegularId)));
        priceRegularManager.removePriceRegular(priceRegularId);
        priceRegularDao.verify();

        // reset expectations
        priceRegularDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(PriceRegular.class, priceRegular.getId());
        priceRegularDao.expects(once()).method("removePriceRegular").isVoid();
        priceRegularDao.expects(once()).method("getPriceRegular").will(throwException(ex));
        priceRegularManager.removePriceRegular(priceRegularId);
        try {
            priceRegularManager.getPriceRegular(priceRegularId);
            fail("PriceRegular with identifier '" + priceRegularId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        priceRegularDao.verify();
    }
}
