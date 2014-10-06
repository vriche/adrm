
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.BrandDao;
import com.vriche.adrm.model.Brand;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.BrandManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class BrandManagerTest extends BaseManagerTestCase {
    private final String brandId = "1";
    private BrandManagerImpl brandManager = new BrandManagerImpl();
    private Mock brandDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        brandDao = new Mock(BrandDao.class);
        brandManager.setBrandDao((BrandDao) brandDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        brandManager = null;
    }

    public void testGetBrands() throws Exception {
        List results = new ArrayList();
        Brand brand = new Brand();
        results.add(brand);

        // set expected behavior on dao
        brandDao.expects(once()).method("getBrands")
            .will(returnValue(results));

        List brands = brandManager.getBrands(null);
        assertTrue(brands.size() == 1);
        brandDao.verify();
    }

    public void testGetBrand() throws Exception {
        // set expected behavior on dao
        brandDao.expects(once()).method("getBrand")
            .will(returnValue(new Brand()));
        Brand brand = brandManager.getBrand(brandId);
        assertTrue(brand != null);
        brandDao.verify();
    }

    public void testSaveBrand() throws Exception {
        Brand brand = new Brand();

        // set expected behavior on dao
        brandDao.expects(once()).method("saveBrand")
            .with(same(brand)).isVoid();

        brandManager.saveBrand(brand);
        brandDao.verify();
    }

    public void testAddAndRemoveBrand() throws Exception {
        Brand brand = new Brand();

        // set required fields

        // set expected behavior on dao
        brandDao.expects(once()).method("saveBrand")
            .with(same(brand)).isVoid();
        brandManager.saveBrand(brand);
        brandDao.verify();

        // reset expectations
        brandDao.reset();

        brandDao.expects(once()).method("removeBrand").with(eq(new Long(brandId)));
        brandManager.removeBrand(brandId);
        brandDao.verify();

        // reset expectations
        brandDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Brand.class, brand.getId());
        brandDao.expects(once()).method("removeBrand").isVoid();
        brandDao.expects(once()).method("getBrand").will(throwException(ex));
        brandManager.removeBrand(brandId);
        try {
            brandManager.getBrand(brandId);
            fail("Brand with identifier '" + brandId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        brandDao.verify();
    }
}
