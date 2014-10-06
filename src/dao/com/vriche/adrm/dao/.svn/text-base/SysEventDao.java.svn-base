
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysEvent;

public interface SysEventDao extends Dao {

    /**
     * Retrieves all of the sysEvents
     */
    public List getSysEvents(SysEvent sysEvent);
    /**
     * Retrieves all of the getSysEventsCount
     */
    public Integer getSysEventsCount(SysEvent sysEvent);   
    /**
     * Retrieves all of the getSysEventsPage
     */        
    public PaginatedList getSysEventsPage(SysEvent sysEvent,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysEventsByIdList
     */
    public List getSysEventsByIdList(final Map idList);

    /**
     * Gets sysEvent's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysEvent's id
     * @return sysEvent populated sysEvent object
     */
    public SysEvent getSysEvent(final Long id);

    /**
     * Saves a sysEvent's information
     * @param sysEvent the object to be saved
     */    
    public Long saveSysEvent(SysEvent sysEvent);

    /**
     * Removes a sysEvent from the database by id
     * @param id the sysEvent's id
     */
    public void removeSysEvent(final Long id);
	/**
     * Removes sysEvents from the database by ids
     * @param ids the sysEvent's id eg:"'1','2','3'"
     */
    public void removeSysEvents(final Map idList);
}

