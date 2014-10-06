
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.CategoryDao;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.CategoryManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CategoryManagerTest extends BaseManagerTestCase {
    private final String categoryId = "1";
    private CategoryManagerImpl categoryManager = new CategoryManagerImpl();
    private Mock categoryDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        categoryDao = new Mock(CategoryDao.class);
        categoryManager.setCategoryDao((CategoryDao) categoryDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        categoryManager = null;
    }

    public void testGetCategorys() throws Exception {
        List results = new ArrayList();
        Category category = new Category();
        results.add(category);

        // set expected behavior on dao
        categoryDao.expects(once()).method("getCategorys")
            .will(returnValue(results));

        List categorys = categoryManager.getCategorys(null);
        assertTrue(categorys.size() == 1);
        categoryDao.verify();
    }

    public void testGetCategory() throws Exception {
        // set expected behavior on dao
        categoryDao.expects(once()).method("getCategory")
            .will(returnValue(new Category()));
        Category category = categoryManager.getCategory(categoryId);
        assertTrue(category != null);
        categoryDao.verify();
    }

    public void testSaveCategory() throws Exception {
        Category category = new Category();

        // set expected behavior on dao
        categoryDao.expects(once()).method("saveCategory")
            .with(same(category)).isVoid();

        categoryManager.saveCategory(category);
        categoryDao.verify();
    }

    public void testAddAndRemoveCategory() throws Exception {
        Category category = new Category();

        // set required fields
        category.setCategoryCode("QuKfDoQa");
        category.setCategoryName("LcQpDrEpAoYtGzZaInIoMmBmNuRpHxNvIdYuBuItXaGjKgVnSkRyTvXxFpReXkOvNwRwDjGdFhVyJwHqYgAhJjAzXsDxFuYzPdGdUsJxHvCnElWlLmXgEmOlEbSnMwFu");
        category.setDisplayNo(new Integer(2029694806));

        // set expected behavior on dao
        categoryDao.expects(once()).method("saveCategory")
            .with(same(category)).isVoid();
        categoryManager.saveCategory(category);
        categoryDao.verify();

        // reset expectations
        categoryDao.reset();

        categoryDao.expects(once()).method("removeCategory").with(eq(new Long(categoryId)));
        categoryManager.removeCategory(categoryId);
        categoryDao.verify();

        // reset expectations
        categoryDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Category.class, category.getId());
        categoryDao.expects(once()).method("removeCategory").isVoid();
        categoryDao.expects(once()).method("getCategory").will(throwException(ex));
        categoryManager.removeCategory(categoryId);
        try {
            categoryManager.getCategory(categoryId);
            fail("Category with identifier '" + categoryId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        categoryDao.verify();
    }
}
