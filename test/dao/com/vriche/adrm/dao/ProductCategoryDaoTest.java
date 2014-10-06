package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ProductCategory;
import com.vriche.adrm.dao.ProductCategoryDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProductCategoryDaoTest extends BaseDaoTestCase {
    private Long productCategoryId = new Long("1");
    private ProductCategoryDao dao = null;

    public void setProductCategoryDao(ProductCategoryDao dao) {
        this.dao = dao;
    }

    public void testAddProductCategory() throws Exception {
        ProductCategory productCategory = new ProductCategory();

        // set required fields

        dao.saveProductCategory(productCategory);

        // verify a primary key was assigned
        assertNotNull(productCategory.getId());

        // verify set fields are same after save
    }

    public void testGetProductCategory() throws Exception {
        ProductCategory productCategory = dao.getProductCategory(productCategoryId);
        assertNotNull(productCategory);
    }

    public void testGetProductCategorys() throws Exception {
        ProductCategory productCategory = new ProductCategory();

        List results = dao.getProductCategorys(productCategory);
        assertTrue(results.size() > 0);
    }

    public void testSaveProductCategory() throws Exception {
        ProductCategory productCategory = dao.getProductCategory(productCategoryId);

        // update required fields

        dao.saveProductCategory(productCategory);

    }

    public void testRemoveProductCategory() throws Exception {
        Long removeId = new Long("3");
        dao.removeProductCategory(removeId);
        try {
            dao.getProductCategory(removeId);
            fail("productCategory found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveProductCategorys(final Map idList) throws Exception {
        try {
        	dao.removeProductCategorys(idList);
            fail("productCategory found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
