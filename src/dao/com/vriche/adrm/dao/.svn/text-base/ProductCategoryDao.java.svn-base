
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ProductCategory;

public interface ProductCategoryDao extends Dao {

    /**
     * Retrieves all of the productCategorys
     */
    public List getProductCategorys(ProductCategory productCategory);

    /**
     * Retrieves all of the productCategorysByIdList
     */
    public List getProductCategorysByIdList(final Map idList);

    /**
     * Gets productCategory's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the productCategory's id
     * @return productCategory populated productCategory object
     */
    public ProductCategory getProductCategory(final Long id);

    /**
     * Saves a productCategory's information
     * @param productCategory the object to be saved
     */    
    public void saveProductCategory(ProductCategory productCategory);

    /**
     * Removes a productCategory from the database by id
     * @param id the productCategory's id
     */
    public void removeProductCategory(final Long id);
	/**
     * Removes productCategorys from the database by ids
     * @param ids the productCategory's id eg:"'1','2','3'"
     */
    public void removeProductCategorys(final Map idList);
}

