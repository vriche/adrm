
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.PriceDetailManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceDetailManagerTest extends BaseManagerTestCase {
    private final String priceDetailId = "1";
    private PriceDetailManagerImpl priceDetailManager = new PriceDetailManagerImpl();
    private Mock priceDetailDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        priceDetailDao = new Mock(PriceDetailDao.class);
        priceDetailManager.setPriceDetailDao((PriceDetailDao) priceDetailDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        priceDetailManager = null;
    }

    public void testGetPriceDetails() throws Exception {
        List results = new ArrayList();
        PriceDetail priceDetail = new PriceDetail();
        results.add(priceDetail);

        // set expected behavior on dao
        priceDetailDao.expects(once()).method("getPriceDetails")
            .will(returnValue(results));

        List priceDetails = priceDetailManager.getPriceDetails(null);
        assertTrue(priceDetails.size() == 1);
        priceDetailDao.verify();
    }

    public void testGetPriceDetail() throws Exception {
        // set expected behavior on dao
        priceDetailDao.expects(once()).method("getPriceDetail")
            .will(returnValue(new PriceDetail()));
        PriceDetail priceDetail = priceDetailManager.getPriceDetail(priceDetailId);
        assertTrue(priceDetail != null);
        priceDetailDao.verify();
    }

    public void testSavePriceDetail() throws Exception {
        PriceDetail priceDetail = new PriceDetail();

        // set expected behavior on dao
        priceDetailDao.expects(once()).method("savePriceDetail")
            .with(same(priceDetail)).isVoid();

        priceDetailManager.savePriceDetail(priceDetail);
        priceDetailDao.verify();
    }

    public void testAddAndRemovePriceDetail() throws Exception {
        PriceDetail priceDetail = new PriceDetail();

        // set required fields

        // set expected behavior on dao
        priceDetailDao.expects(once()).method("savePriceDetail")
            .with(same(priceDetail)).isVoid();
        priceDetailManager.savePriceDetail(priceDetail);
        priceDetailDao.verify();

        // reset expectations
        priceDetailDao.reset();

        priceDetailDao.expects(once()).method("removePriceDetail").with(eq(new Long(priceDetailId)));
        priceDetailManager.removePriceDetail(priceDetailId);
        priceDetailDao.verify();

        // reset expectations
        priceDetailDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(PriceDetail.class, priceDetail.getId());
        priceDetailDao.expects(once()).method("removePriceDetail").isVoid();
        priceDetailDao.expects(once()).method("getPriceDetail").will(throwException(ex));
        priceDetailManager.removePriceDetail(priceDetailId);
        try {
            priceDetailManager.getPriceDetail(priceDetailId);
            fail("PriceDetail with identifier '" + priceDetailId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        priceDetailDao.verify();
    }
}
