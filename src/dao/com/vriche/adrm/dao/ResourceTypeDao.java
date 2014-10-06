
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ResourceType;

public interface ResourceTypeDao extends Dao {

    /**
     * Retrieves all of the resourceTypes
     */
    public List getResourceTypes(ResourceType resourceType);

    /**
     * Retrieves all of the resourceTypesByIdList
     */
    public List getResourceTypesByIdList(final Map idList);

    /**
     * Gets resourceType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the resourceType's id
     * @return resourceType populated resourceType object
     */
    public ResourceType getResourceType(final Long id);

    /**
     * Saves a resourceType's information
     * @param resourceType the object to be saved
     */    
    public void saveResourceType(ResourceType resourceType);

    /**
     * Removes a resourceType from the database by id
     * @param id the resourceType's id
     */
    public void removeResourceType(final Long id);
	/**
     * Removes resourceTypes from the database by ids
     * @param ids the resourceType's id eg:"'1','2','3'"
     */
    public void removeResourceTypes(final Map idList);
}

