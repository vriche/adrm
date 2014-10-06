
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.AgentInfo;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.dao.ResourceSortDao;

public interface ResourceSortManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setResourceSortDao(ResourceSortDao resourceSortDAO);

    /**
     * Retrieves all of the resourceSorts
     */
    public List getResourceSorts(ResourceSort resourceSort);
     /**
     * Retrieves all of the resourceSortsCount
     */
    public String getResourceSortsCount(ResourceSort resourceSort);
     /**
     * Retrieves all of the resourceSortsCount
     */    
    public PaginatedList getResourceSortsPage(ResourceSort resourceSort,String pageIndex,String pageSize);
     /**
     * Retrieves all of the resourceSortsByIdList
     */
    public List getResourceSortsByIdList(final Map idList);

    /**
     * Gets resourceSort's information based on id.
     * @param id the resourceSort's id
     * @return resourceSort populated resourceSort object
     */
    public ResourceSort getResourceSort(final String id);

    /**
     * Saves a resourceSort's information
     * @param resourceSort the object to be saved
     */
    public String saveResourceSort(ResourceSort resourceSort);

    /**
     * Removes a resourceSort from the database by id
     * @param id the resourceSort's id
     */
    public void removeResourceSort(final String id);
     /**
     * Removes a resourceSort from the database by id
     * @param idList
     */
    public void removeResourceSorts(final Map idList);
    
    public Map getResourceSortSelect();
    
    public Map getResourceSortSelectFromMap();
    
    public Map getResourceSortSelectFromMap2();
    
    public List getResourceSortSelect2();
}

