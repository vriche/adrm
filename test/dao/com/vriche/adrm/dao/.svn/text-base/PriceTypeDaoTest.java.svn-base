package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.PriceType;
import com.vriche.adrm.dao.PriceTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceTypeDaoTest extends BaseDaoTestCase {
    private Long priceTypeId = new Long("1");
    private PriceTypeDao dao = null;

    public void setPriceTypeDao(PriceTypeDao dao) {
        this.dao = dao;
    }

    public void testAddPriceType() throws Exception {
        PriceType priceType = new PriceType();

        // set required fields

        dao.savePriceType(priceType);

        // verify a primary key was assigned
        assertNotNull(priceType.getId());

        // verify set fields are same after save
    }

    public void testGetPriceType() throws Exception {
        PriceType priceType = dao.getPriceType(priceTypeId);
        assertNotNull(priceType);
    }

    public void testGetPriceTypes() throws Exception {
        PriceType priceType = new PriceType();

        List results = dao.getPriceTypes(priceType);
        assertTrue(results.size() > 0);
    }

    public void testSavePriceType() throws Exception {
        PriceType priceType = dao.getPriceType(priceTypeId);

        // update required fields

        dao.savePriceType(priceType);

    }

    public void testRemovePriceType() throws Exception {
        Long removeId = new Long("3");
        dao.removePriceType(removeId);
        try {
            dao.getPriceType(removeId);
            fail("priceType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePriceTypes(final Map idList) throws Exception {
        try {
        	dao.removePriceTypes(idList);
            fail("priceType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
