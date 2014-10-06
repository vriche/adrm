
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ResourceLimit;
import com.vriche.adrm.dao.ResourceLimitDao;

public interface ResourceLimitManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setResourceLimitDao(ResourceLimitDao resourceLimitDAO);

    /**
     * Retrieves all of the resourceLimits
     */
    public List getResourceLimits(ResourceLimit resourceLimit);
     /**
     * Retrieves all of the resourceLimitsCount
     */
    public String getResourceLimitsCount(ResourceLimit resourceLimit);
     /**
     * Retrieves all of the resourceLimitsCount
     */    
    public List getResourceLimitsPage(ResourceLimit resourceLimit,String pageIndex,String pageSize);
     /**
     * Retrieves all of the resourceLimitsPageXML
     */   
    public String getResourceLimitsPageXML(ResourceLimit resourceLimit,String pageIndex,String pageSize);
    
    public String getResourceLimitsXML(ResourceLimit resourceLimit) ;
     /**
     * Retrieves all of the resourceLimitsByMap
     */
    public List getResourceLimitsByMap(final Map mp);

    /**
     * Gets resourceLimit's information based on id.
     * @param id the resourceLimit's id
     * @return resourceLimit populated resourceLimit object
     */
    public ResourceLimit getResourceLimit(final String id);

    /**
     * Saves a resourceLimit's information
     * @param resourceLimit the object to be saved
     */
    public String saveResourceLimit(ResourceLimit resourceLimit);

    /**
     * Removes a resourceLimit from the database by id
     * @param id the resourceLimit's id
     */
    public void removeResourceLimit(final String id);
     /**
     * Removes a resourceLimit from the database by id
     * @param idList
     */
    public void removeResourceLimits(final Map mp);
    
    public Collection getResourceLimitsColl(ResourceLimit resourceLimit);
}

