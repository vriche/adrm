
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysEvent;
import com.vriche.adrm.dao.SysEventDao;

public interface SysEventManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysEventDao(SysEventDao sysEventDAO);

    /**
     * Retrieves all of the sysEvents
     */
    public List getSysEvents(SysEvent sysEvent);
     /**
     * Retrieves all of the sysEventsCount
     */
    public String getSysEventsCount(SysEvent sysEvent);
     /**
     * Retrieves all of the sysEventsCount
     */    
    public PaginatedList getSysEventsPage(SysEvent sysEvent,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysEventsByIdList
     */
    public List getSysEventsByIdList(final Map idList);

    /**
     * Gets sysEvent's information based on id.
     * @param id the sysEvent's id
     * @return sysEvent populated sysEvent object
     */
    public SysEvent getSysEvent(final String id);

    /**
     * Saves a sysEvent's information
     * @param sysEvent the object to be saved
     */
    public String saveSysEvent(SysEvent sysEvent);

    /**
     * Removes a sysEvent from the database by id
     * @param id the sysEvent's id
     */
    public void removeSysEvent(final String id);
     /**
     * Removes a sysEvent from the database by id
     * @param idList
     */
    public void removeSysEvents(final Map idList);
}

