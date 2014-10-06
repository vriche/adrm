
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CategoryDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.Category;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CategoryDaoiBatis extends BaseDaoiBATIS implements CategoryDao {

    /**
     * @see com.vriche.adrm.crm.dao.CategoryDao#getCategorys(com.vriche.adrm.crm.model.Category)
     */
    public List getCategorys(final Category category) {
          return getSqlMapClientTemplate().queryForList("getCategorys", category);
    }
    /**
     * @see com.vriche.adrm.crm.dao.CategoryDao#getCategorysByIdList(com.vriche.adrm.crm.model.Category)
     */
    public List getCategorysByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getCategorysByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.CategoryDao#getCategory(Long id)
     */
    public Category getCategory(Long id) {
        Category category = (Category) getSqlMapClientTemplate().queryForObject("getCategory", id);

        if (category == null) {
            throw new ObjectRetrievalFailureException(Category.class, id);
        }

        return category;
    }

    /**
     * @see com.vriche.adrm.crm.dao.CategoryDao#saveCategory(Category category)
     */    
    public void saveCategory(final Category category) {
        Long id = category.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addCategory", category);
        } else {
            getSqlMapClientTemplate().update("updateCategory", category);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Category.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.crm.dao.CategoryDao#removeCategory(Long id)
     */
    public void removeCategory(Long id) {
        getSqlMapClientTemplate().update("deleteCategory", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.CategoryDAO#removeCategorys(String ids)
     */
    public void removeCategorys(final Map idList) {
        getSqlMapClientTemplate().update("deleteCategorys", idList);
    }    
}
