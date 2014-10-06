
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ResourceTypeDao;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.service.Manager;

public interface ResourceTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setResourceTypeDao(ResourceTypeDao resourceTypeDAO);

    /**
     * Retrieves all of the resourceTypes
     */
    public List getResourceTypes(ResourceType resourceType);
        /**
     * Retrieves all of the resourceTypesByIdList
     */
    public List getResourceTypesByIdList(final Map idList);

    /**
     * Gets resourceType's information based on id.
     * @param id the resourceType's id
     * @return resourceType populated resourceType object
     */
    public ResourceType getResourceType(final String id);

    /**
     * Saves a resourceType's information
     * @param resourceType the object to be saved
     */
    public void saveResourceType(ResourceType resourceType);

    /**
     * Removes a resourceType from the database by id
     * @param id the resourceType's id
     */
    public void removeResourceType(final String id);
     /**
     * Removes a resourceType from the database by id
     * @param idList
     */
    public void removeResourceTypes(final Map idList);
    
    public Map getResourceTypeSelectItem(ResourceType resourceType);
    
    public List getTree(Map searchMap);
}

