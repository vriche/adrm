
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Specific;

public interface SpecificDao extends Dao {

    /**
     * Retrieves all of the specifics
     */
    public List getSpecifics(Specific specific);

    /**
     * Retrieves all of the specificsByIdList
     */
    public List getSpecificsByIdList(final Map idList);

    /**
     * Gets specific's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the specific's id
     * @return specific populated specific object
     */
    public Specific getSpecific(final Long id);

    /**
     * Saves a specific's information
     * @param specific the object to be saved
     */    
    public void saveSpecific(Specific specific);

    /**
     * Removes a specific from the database by id
     * @param id the specific's id
     */
    public void removeSpecific(final Long id);
	/**
     * Removes specifics from the database by ids
     * @param ids the specific's id eg:"'1','2','3'"
     */
    public void removeSpecifics(final Map idList);
}

