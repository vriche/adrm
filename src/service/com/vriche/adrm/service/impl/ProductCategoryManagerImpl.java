
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ProductCategoryDao;
import com.vriche.adrm.model.ProductCategory;
import com.vriche.adrm.service.ProductCategoryManager;
import com.vriche.adrm.service.impl.BaseManager;

public class ProductCategoryManagerImpl extends BaseManager implements ProductCategoryManager {
    private ProductCategoryDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setProductCategoryDao(ProductCategoryDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adver.service.ProductCategoryManager#getProductCategorysByIdList(final Map idList)
     */
    public List getProductCategorysByIdList(final Map idList) {
        return dao.getProductCategorysByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adver.service.ProductCategoryManager#getProductCategorys(com.vriche.adrm.adver.model.ProductCategory)
     */
    public List getProductCategorys(final ProductCategory productCategory) {
        return dao.getProductCategorys(productCategory);
    }

    /**
     * @see com.vriche.adrm.adver.service.ProductCategoryManager#getProductCategory(String id)
     */
    public ProductCategory getProductCategory(final String id) {
        return dao.getProductCategory(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adver.service.ProductCategoryManager#saveProductCategory(ProductCategory productCategory)
     */
    public void saveProductCategory(ProductCategory productCategory) {
        dao.saveProductCategory(productCategory);
    }

    /**
     * @see com.vriche.adrm.adver.service.ProductCategoryManager#removeProductCategory(String id)
     */
    public void removeProductCategory(final String id) {
        dao.removeProductCategory(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adver.service.ProductCategoryManager#removeProductCategorys(String Map)
     */
    public void removeProductCategorys(final Map idList) {
        dao.removeProductCategorys(idList);
    }    
}
