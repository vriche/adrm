
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CategoryDao;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.service.Manager;

public interface CategoryManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setCategoryDao(CategoryDao categoryDAO);

    /**
     * Retrieves all of the categorys
     */
    public List getCategorys(Category category);
    
    public Map getCategorySelectLimit(Category category);
        /**
     * Retrieves all of the categorysByIdList
     */
    public List getCategorysByIdList(final Map idList);

    /**
     * Gets category's information based on id.
     * @param id the category's id
     * @return category populated category object
     */
    public Category getCategory(final String id);

    /**
     * Saves a category's information
     * @param category the object to be saved
     */
    public void saveCategory(Category category);

    /**
     * Removes a category from the database by id
     * @param id the category's id
     */
    public void removeCategory(final String id);
     /**
     * Removes a category from the database by id
     * @param idList
     */
    public void removeCategorys(final Map idList);
    
    public String getCategoryTreeXML(Category category, String categoryIdPrefix,String customerIdPrefix);
    
    public List getCategorySelectLimitList(Category category);
    
    public Map getCategorySelectLimit2(Category category);
}

