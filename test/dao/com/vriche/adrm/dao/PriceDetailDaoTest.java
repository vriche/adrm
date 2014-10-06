package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.dao.PriceDetailDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceDetailDaoTest extends BaseDaoTestCase {
    private Long priceDetailId = new Long("1");
    private PriceDetailDao dao = null;

    public void setPriceDetailDao(PriceDetailDao dao) {
        this.dao = dao;
    }

    public void testAddPriceDetail() throws Exception {
        PriceDetail priceDetail = new PriceDetail();

        // set required fields

        dao.savePriceDetail(priceDetail);

        // verify a primary key was assigned
        assertNotNull(priceDetail.getId());

        // verify set fields are same after save
    }

    public void testGetPriceDetail() throws Exception {
        PriceDetail priceDetail = dao.getPriceDetail(priceDetailId);
        assertNotNull(priceDetail);
    }

    public void testGetPriceDetails() throws Exception {
        PriceDetail priceDetail = new PriceDetail();

        List results = dao.getPriceDetails(priceDetail);
        assertTrue(results.size() > 0);
    }

    public void testSavePriceDetail() throws Exception {
        PriceDetail priceDetail = dao.getPriceDetail(priceDetailId);

        // update required fields

        dao.savePriceDetail(priceDetail);

    }

    public void testRemovePriceDetail() throws Exception {
        Long removeId = new Long("3");
        dao.removePriceDetail(removeId);
        try {
            dao.getPriceDetail(removeId);
            fail("priceDetail found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePriceDetails(final Map idList) throws Exception {
        try {
        	dao.removePriceDetails(idList);
            fail("priceDetail found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
