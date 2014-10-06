
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;

import com.vriche.adrm.dao.ProductCategoryDao;
import com.vriche.adrm.model.ProductCategory;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.ProductCategoryManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ProductCategoryManagerTest extends BaseManagerTestCase {
    private final String productCategoryId = "1";
    private ProductCategoryManagerImpl productCategoryManager = new ProductCategoryManagerImpl();
    private Mock productCategoryDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        productCategoryDao = new Mock(ProductCategoryDao.class);
        productCategoryManager.setProductCategoryDao((ProductCategoryDao) productCategoryDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        productCategoryManager = null;
    }

    public void testGetProductCategorys() throws Exception {
        List results = new ArrayList();
        ProductCategory productCategory = new ProductCategory();
        results.add(productCategory);

        // set expected behavior on dao
        productCategoryDao.expects(once()).method("getProductCategorys")
            .will(returnValue(results));

        List productCategorys = productCategoryManager.getProductCategorys(null);
        assertTrue(productCategorys.size() == 1);
        productCategoryDao.verify();
    }

    public void testGetProductCategory() throws Exception {
        // set expected behavior on dao
        productCategoryDao.expects(once()).method("getProductCategory")
            .will(returnValue(new ProductCategory()));
        ProductCategory productCategory = productCategoryManager.getProductCategory(productCategoryId);
        assertTrue(productCategory != null);
        productCategoryDao.verify();
    }

    public void testSaveProductCategory() throws Exception {
        ProductCategory productCategory = new ProductCategory();

        // set expected behavior on dao
        productCategoryDao.expects(once()).method("saveProductCategory")
            .with(same(productCategory)).isVoid();

        productCategoryManager.saveProductCategory(productCategory);
        productCategoryDao.verify();
    }

    public void testAddAndRemoveProductCategory() throws Exception {
        ProductCategory productCategory = new ProductCategory();

        // set required fields

        // set expected behavior on dao
        productCategoryDao.expects(once()).method("saveProductCategory")
            .with(same(productCategory)).isVoid();
        productCategoryManager.saveProductCategory(productCategory);
        productCategoryDao.verify();

        // reset expectations
        productCategoryDao.reset();

        productCategoryDao.expects(once()).method("removeProductCategory").with(eq(new Long(productCategoryId)));
        productCategoryManager.removeProductCategory(productCategoryId);
        productCategoryDao.verify();

        // reset expectations
        productCategoryDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ProductCategory.class, productCategory.getId());
        productCategoryDao.expects(once()).method("removeProductCategory").isVoid();
        productCategoryDao.expects(once()).method("getProductCategory").will(throwException(ex));
        productCategoryManager.removeProductCategory(productCategoryId);
        try {
            productCategoryManager.getProductCategory(productCategoryId);
            fail("ProductCategory with identifier '" + productCategoryId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        productCategoryDao.verify();
    }
}
