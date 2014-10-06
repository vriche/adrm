package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Price;
import com.vriche.adrm.dao.PriceDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PriceDaoTest extends BaseDaoTestCase {
    private Long priceId = new Long("1");
    private PriceDao dao = null;

    public void setPriceDao(PriceDao dao) {
        this.dao = dao;
    }

    public void testAddPrice() throws Exception {
        Price price = new Price();

        // set required fields

        dao.savePrice(price);

        // verify a primary key was assigned
        assertNotNull(price.getId());

        // verify set fields are same after save
    }

    public void testGetPrice() throws Exception {
        Price price = dao.getPrice(priceId);
        assertNotNull(price);
    }

    public void testGetPrices() throws Exception {
        Price price = new Price();

        List results = dao.getPrices(price);
        assertTrue(results.size() > 0);
    }

    public void testSavePrice() throws Exception {
        Price price = dao.getPrice(priceId);

        // update required fields

        dao.savePrice(price);

    }

    public void testRemovePrice() throws Exception {
        Long removeId = new Long("3");
        dao.removePrice(removeId);
        try {
            dao.getPrice(removeId);
            fail("price found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePrices(final Map idList) throws Exception {
        try {
        	dao.removePrices(idList);
            fail("price found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
