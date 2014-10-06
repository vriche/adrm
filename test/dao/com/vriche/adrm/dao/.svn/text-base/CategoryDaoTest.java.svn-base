package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.dao.CategoryDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CategoryDaoTest extends BaseDaoTestCase {
    private Long categoryId = new Long("1");
    private CategoryDao dao = null;

    public void setCategoryDao(CategoryDao dao) {
        this.dao = dao;
    }

    public void testAddCategory() throws Exception {
        Category category = new Category();

        // set required fields

        java.lang.String categoryCode = "FmNgSlFt";
        category.setCategoryCode(categoryCode);        

        java.lang.String categoryName = "VpApRtNqCjOvAlBnLqLpXpViIxZxBrOiYwAbPwKzFzLkKiIpYtUsNiIqGjTmDdImUlXfGaBsGhBdQqAaOiEtIyQpIaRbKqKbIiIaQoKbXoPcTxYsQtSpVwHsBsOaQiCm";
        category.setCategoryName(categoryName);        

        java.lang.Integer displayNo = new Integer(1425514079);
        category.setDisplayNo(displayNo);        

        dao.saveCategory(category);

        // verify a primary key was assigned
        assertNotNull(category.getId());

        // verify set fields are same after save
        assertEquals(categoryCode, category.getCategoryCode());
        assertEquals(categoryName, category.getCategoryName());
        assertEquals(displayNo, category.getDisplayNo());
    }

    public void testGetCategory() throws Exception {
        Category category = dao.getCategory(categoryId);
        assertNotNull(category);
    }

    public void testGetCategorys() throws Exception {
        Category category = new Category();

        List results = dao.getCategorys(category);
        assertTrue(results.size() > 0);
    }

    public void testSaveCategory() throws Exception {
        Category category = dao.getCategory(categoryId);

        // update required fields
        java.lang.String categoryCode = "ZhAhPwCo";
        category.setCategoryCode(categoryCode);        
        java.lang.String categoryName = "YyXgAwNdHaQaNjOxSeUaByMrHyHcPdEvRbDaBxOwLjHcIrJjIjZxPwMaPsTwBcIbKuUnFjYfUoYoFkIpYqJoMpSlBlWwQzXsYeJgIuBuUsEkAaTtMvNdWgCzGcErFyOg";
        category.setCategoryName(categoryName);        
        java.lang.Integer displayNo = new Integer(2103630398);
        category.setDisplayNo(displayNo);        

        dao.saveCategory(category);

        assertEquals(categoryCode, category.getCategoryCode());
        assertEquals(categoryName, category.getCategoryName());
        assertEquals(displayNo, category.getDisplayNo());
    }

    public void testRemoveCategory() throws Exception {
        Long removeId = new Long("3");
        dao.removeCategory(removeId);
        try {
            dao.getCategory(removeId);
            fail("category found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveCategorys(final Map idList) throws Exception {
        try {
        	dao.removeCategorys(idList);
            fail("category found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
