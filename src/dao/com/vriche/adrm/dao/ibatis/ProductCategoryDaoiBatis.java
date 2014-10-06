
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ProductCategoryDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProductCategory;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProductCategoryDaoiBatis extends BaseDaoiBATIS implements ProductCategoryDao {

    /**
     * @see com.vriche.adrm.adver.dao.ProductCategoryDao#getProductCategorys(com.vriche.adrm.adver.model.ProductCategory)
     */
    public List getProductCategorys(final ProductCategory productCategory) {
          return getSqlMapClientTemplate().queryForList("getProductCategorys", productCategory);
    }
    /**
     * @see com.vriche.adrm.adver.dao.ProductCategoryDao#getProductCategorysByIdList(com.vriche.adrm.adver.model.ProductCategory)
     */
    public List getProductCategorysByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getProductCategorysByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adver.dao.ProductCategoryDao#getProductCategory(Long id)
     */
    public ProductCategory getProductCategory(Long id) {
        ProductCategory productCategory = (ProductCategory) getSqlMapClientTemplate().queryForObject("getProductCategory", id);

        if (productCategory == null) {
            throw new ObjectRetrievalFailureException(ProductCategory.class, id);
        }

        return productCategory;
    }

    /**
     * @see com.vriche.adrm.adver.dao.ProductCategoryDao#saveProductCategory(ProductCategory productCategory)
     */    
    public void saveProductCategory(final ProductCategory productCategory) {
        Long id = productCategory.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addProductCategory", productCategory);
        } else {
            getSqlMapClientTemplate().update("updateProductCategory", productCategory);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProductCategory.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adver.dao.ProductCategoryDao#removeProductCategory(Long id)
     */
    public void removeProductCategory(Long id) {
        getSqlMapClientTemplate().update("deleteProductCategory", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.ProductCategoryDAO#removeProductCategorys(String ids)
     */
    public void removeProductCategorys(final Map idList) {
        getSqlMapClientTemplate().update("deleteProductCategorys", idList);
    }    
}
