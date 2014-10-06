
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ResourceSort;

public interface ResourceSortDao extends Dao {

    /**
     * Retrieves all of the resourceSorts
     */
    public List getResourceSorts(ResourceSort resourceSort);
    /**
     * Retrieves all of the getResourceSortsCount
     */
    public Integer getResourceSortsCount(ResourceSort resourceSort);   
    /**
     * Retrieves all of the getResourceSortsPage
     */        
    public PaginatedList getResourceSortsPage(ResourceSort resourceSort,int pageIndex,int pageSize);
    /**
     * Retrieves all of the resourceSortsByIdList
     */
    public List getResourceSortsByIdList(final Map idList);

    /**
     * Gets resourceSort's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the resourceSort's id
     * @return resourceSort populated resourceSort object
     */
    public ResourceSort getResourceSort(final Long id);

    /**
     * Saves a resourceSort's information
     * @param resourceSort the object to be saved
     */    
    public Long saveResourceSort(ResourceSort resourceSort);

    /**
     * Removes a resourceSort from the database by id
     * @param id the resourceSort's id
     */
    public void removeResourceSort(final Long id);
	/**
     * Removes resourceSorts from the database by ids
     * @param ids the resourceSort's id eg:"'1','2','3'"
     */
    public void removeResourceSorts(final Map idList);
}

