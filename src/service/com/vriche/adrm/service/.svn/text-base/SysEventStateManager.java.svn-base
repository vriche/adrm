
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysEventState;
import com.vriche.adrm.dao.SysEventStateDao;

public interface SysEventStateManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysEventStateDao(SysEventStateDao sysEventStateDAO);

    /**
     * Retrieves all of the sysEventStates
     */
    public List getSysEventStates(SysEventState sysEventState);
     /**
     * Retrieves all of the sysEventStatesCount
     */
    public String getSysEventStatesCount(SysEventState sysEventState);
     /**
     * Retrieves all of the sysEventStatesCount
     */    
    public PaginatedList getSysEventStatesPage(SysEventState sysEventState,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysEventStatesByIdList
     */
    public List getSysEventStatesByIdList(final Map idList);

    /**
     * Gets sysEventState's information based on id.
     * @param id the sysEventState's id
     * @return sysEventState populated sysEventState object
     */
    public SysEventState getSysEventState(final String id);

    /**
     * Saves a sysEventState's information
     * @param sysEventState the object to be saved
     */
    public String saveSysEventState(SysEventState sysEventState);

    /**
     * Removes a sysEventState from the database by id
     * @param id the sysEventState's id
     */
    public void removeSysEventState(final String id);
     /**
     * Removes a sysEventState from the database by id
     * @param idList
     */
    public void removeSysEventStates(final Map idList);
}

