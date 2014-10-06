package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Brand;
import com.vriche.adrm.dao.BrandDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class BrandDaoTest extends BaseDaoTestCase {
    private Long brandId = new Long("1");
    private BrandDao dao = null;

    public void setBrandDao(BrandDao dao) {
        this.dao = dao;
    }

    public void testAddBrand() throws Exception {
        Brand brand = new Brand();

        // set required fields

        dao.saveBrand(brand);

        // verify a primary key was assigned
        assertNotNull(brand.getId());

        // verify set fields are same after save
    }

    public void testGetBrand() throws Exception {
        Brand brand = dao.getBrand(brandId);
        assertNotNull(brand);
    }

    public void testGetBrands() throws Exception {
        Brand brand = new Brand();

        List results = dao.getBrands(brand);
        assertTrue(results.size() > 0);
    }

    public void testSaveBrand() throws Exception {
        Brand brand = dao.getBrand(brandId);

        // update required fields

        dao.saveBrand(brand);

    }

    public void testRemoveBrand() throws Exception {
        Long removeId = new Long("3");
        dao.removeBrand(removeId);
        try {
            dao.getBrand(removeId);
            fail("brand found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveBrands(final Map idList) throws Exception {
        try {
        	dao.removeBrands(idList);
            fail("brand found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
