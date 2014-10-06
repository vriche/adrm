
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.SpecificDao;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.Specific;
import com.vriche.adrm.service.Manager;

public interface SpecificManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSpecificDao(SpecificDao specificDAO);

    /**
     * Retrieves all of the specifics
     */
    public List getSpecifics(Specific specific);
        /**
     * Retrieves all of the specificsByIdList
     */
    public List getSpecificsByIdList(final Map idList);

    /**
     * Gets specific's information based on id.
     * @param id the specific's id
     * @return specific populated specific object
     */
    public Specific getSpecific(final String id);

    /**
     * Saves a specific's information
     * @param specific the object to be saved
     */
    public void saveSpecific(Specific specific);

    /**
     * Removes a specific from the database by id
     * @param id the specific's id
     */
    public void removeSpecific(final String id);
     /**
     * Removes a specific from the database by id
     * @param idList
     */
    public void removeSpecifics(final Map idList);
    
    public Map getSpecificSelect(Specific specific);
    
    public Map getSpecificSelectFromMap(Specific specific);
    
    public List getSpecificSelectFromMap3(Specific specific);
    
    public Map getSpecificSelectFromMap2(Specific specific);
    
    public String getSpecificsXML(Specific specific);
    
    
  }

