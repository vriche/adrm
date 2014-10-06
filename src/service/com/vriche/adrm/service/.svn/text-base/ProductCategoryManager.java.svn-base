
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ProductCategoryDao;
import com.vriche.adrm.model.ProductCategory;
import com.vriche.adrm.service.Manager;

public interface ProductCategoryManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProductCategoryDao(ProductCategoryDao productCategoryDAO);

    /**
     * Retrieves all of the productCategorys
     */
    public List getProductCategorys(ProductCategory productCategory);
        /**
     * Retrieves all of the productCategorysByIdList
     */
    public List getProductCategorysByIdList(final Map idList);

    /**
     * Gets productCategory's information based on id.
     * @param id the productCategory's id
     * @return productCategory populated productCategory object
     */
    public ProductCategory getProductCategory(final String id);

    /**
     * Saves a productCategory's information
     * @param productCategory the object to be saved
     */
    public void saveProductCategory(ProductCategory productCategory);

    /**
     * Removes a productCategory from the database by id
     * @param id the productCategory's id
     */
    public void removeProductCategory(final String id);
     /**
     * Removes a productCategory from the database by id
     * @param idList
     */
    public void removeProductCategorys(final Map idList);
}

