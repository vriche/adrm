
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ResourceLimit;

public interface ResourceLimitDao extends Dao {

    /**
     * Retrieves all of the resourceLimits
     */
    public List getResourceLimits(ResourceLimit resourceLimit);
    /**
     * Retrieves all of the getResourceLimitsCount
     */
    public Integer getResourceLimitsCount(ResourceLimit resourceLimit);   
    /**
     * Retrieves all of the getResourceLimitsPage
     */        
    public List getResourceLimitsPage(ResourceLimit resourceLimit,int pageIndex,int pageSize);
    
    public List getResourceLimitsByCarrier(ResourceLimit resourceLimit);   
    
    /**
     * Retrieves all of the resourceLimitsByIdList
     */
    public List getResourceLimitsByMap(final Map mp);

    /**
     * Gets resourceLimit's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the resourceLimit's id
     * @return resourceLimit populated resourceLimit object
     */
    public ResourceLimit getResourceLimit(final Long id);

    /**
     * Saves a resourceLimit's information
     * @param resourceLimit the object to be saved
     */    
    public Long saveResourceLimit(ResourceLimit resourceLimit);

    /**
     * Removes a resourceLimit from the database by id
     * @param id the resourceLimit's id
     */
    public void removeResourceLimit(final Long id);
	/**
     * Removes resourceLimits from the database by ids
     * @param ids the resourceLimit's id eg:"'1','2','3'"
     */
    public void removeResourceLimits(final Map idList);
}

