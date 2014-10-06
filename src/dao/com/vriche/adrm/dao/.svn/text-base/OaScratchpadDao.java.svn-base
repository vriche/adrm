
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaScratchpad;

public interface OaScratchpadDao extends Dao {

    /**
     * Retrieves all of the oaScratchpads
     */
    public List getOaScratchpads(OaScratchpad oaScratchpad);
    /**
     * Retrieves all of the getOaScratchpadsCount
     */
    public Integer getOaScratchpadsCount(OaScratchpad oaScratchpad);   
    /**
     * Retrieves all of the getOaScratchpadsPage
     */        
    public PaginatedList getOaScratchpadsPage(OaScratchpad oaScratchpad,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaScratchpadsByIdList
     */
    public List getOaScratchpadsByIdList(final Map idList);

    /**
     * Gets oaScratchpad's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaScratchpad's id
     * @return oaScratchpad populated oaScratchpad object
     */
    public OaScratchpad getOaScratchpad(final Long id);

    /**
     * Saves a oaScratchpad's information
     * @param oaScratchpad the object to be saved
     */    
    public Long saveOaScratchpad(OaScratchpad oaScratchpad);

    /**
     * Removes a oaScratchpad from the database by id
     * @param id the oaScratchpad's id
     */
    public void removeOaScratchpad(final Long id);
	/**
     * Removes oaScratchpads from the database by ids
     * @param ids the oaScratchpad's id eg:"'1','2','3'"
     */
    public void removeOaScratchpads(final Map idList);
}

