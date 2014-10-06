package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.PriceRegular;
import com.vriche.adrm.dao.PriceRegularDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceRegularDaoTest extends BaseDaoTestCase {
    private Long priceRegularId = new Long("1");
    private PriceRegularDao dao = null;

    public void setPriceRegularDao(PriceRegularDao dao) {
        this.dao = dao;
    }

    public void testAddPriceRegular() throws Exception {
        PriceRegular priceRegular = new PriceRegular();

        // set required fields

        dao.savePriceRegular(priceRegular);

        // verify a primary key was assigned
        assertNotNull(priceRegular.getId());

        // verify set fields are same after save
    }

    public void testGetPriceRegular() throws Exception {
        PriceRegular priceRegular = dao.getPriceRegular(priceRegularId);
        assertNotNull(priceRegular);
    }

    public void testGetPriceRegulars() throws Exception {
        PriceRegular priceRegular = new PriceRegular();

        List results = dao.getPriceRegulars(priceRegular);
        assertTrue(results.size() > 0);
    }

    public void testSavePriceRegular() throws Exception {
        PriceRegular priceRegular = dao.getPriceRegular(priceRegularId);

        // update required fields

        dao.savePriceRegular(priceRegular);

    }

    public void testRemovePriceRegular() throws Exception {
        Long removeId = new Long("3");
        dao.removePriceRegular(removeId);
        try {
            dao.getPriceRegular(removeId);
            fail("priceRegular found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePriceRegulars(final Map idList) throws Exception {
        try {
        	dao.removePriceRegulars(idList);
            fail("priceRegular found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
