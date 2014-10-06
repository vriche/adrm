
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaScratchpad;
import com.vriche.adrm.dao.OaScratchpadDao;

public interface OaScratchpadManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaScratchpadDao(OaScratchpadDao oaScratchpadDAO);

    /**
     * Retrieves all of the oaScratchpads
     */
    public List getOaScratchpads(OaScratchpad oaScratchpad);
     /**
     * Retrieves all of the oaScratchpadsCount
     */
    public String getOaScratchpadsCount(OaScratchpad oaScratchpad);
     /**
     * Retrieves all of the oaScratchpadsCount
     */    
    public PaginatedList getOaScratchpadsPage(OaScratchpad oaScratchpad,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaScratchpadsByIdList
     */
    public List getOaScratchpadsByIdList(final Map idList);

    /**
     * Gets oaScratchpad's information based on id.
     * @param id the oaScratchpad's id
     * @return oaScratchpad populated oaScratchpad object
     */
    public OaScratchpad getOaScratchpad(final String id);

    /**
     * Saves a oaScratchpad's information
     * @param oaScratchpad the object to be saved
     */
    public String saveOaScratchpad(OaScratchpad oaScratchpad);

    /**
     * Removes a oaScratchpad from the database by id
     * @param id the oaScratchpad's id
     */
    public void removeOaScratchpad(final String id);
     /**
     * Removes a oaScratchpad from the database by id
     * @param idList
     */
    public void removeOaScratchpads(final Map idList);
}

