
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Category;

public interface CategoryDao extends Dao {

    /**
     * Retrieves all of the categorys
     */
    public List getCategorys(Category category);

    /**
     * Retrieves all of the categorysByIdList
     */
    public List getCategorysByIdList(final Map idList);

    /**
     * Gets category's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the category's id
     * @return category populated category object
     */
    public Category getCategory(final Long id);

    /**
     * Saves a category's information
     * @param category the object to be saved
     */    
    public void saveCategory(Category category);

    /**
     * Removes a category from the database by id
     * @param id the category's id
     */
    public void removeCategory(final Long id);
	/**
     * Removes categorys from the database by ids
     * @param ids the category's id eg:"'1','2','3'"
     */
    public void removeCategorys(final Map idList);
}

