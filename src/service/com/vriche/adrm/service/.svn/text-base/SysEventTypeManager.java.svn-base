
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysEventType;
import com.vriche.adrm.dao.SysEventTypeDao;

public interface SysEventTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysEventTypeDao(SysEventTypeDao sysEventTypeDAO);

    /**
     * Retrieves all of the sysEventTypes
     */
    public List getSysEventTypes(SysEventType sysEventType);
     /**
     * Retrieves all of the sysEventTypesCount
     */
    public String getSysEventTypesCount(SysEventType sysEventType);
     /**
     * Retrieves all of the sysEventTypesCount
     */    
    public PaginatedList getSysEventTypesPage(SysEventType sysEventType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysEventTypesByIdList
     */
    public List getSysEventTypesByIdList(final Map idList);

    /**
     * Gets sysEventType's information based on id.
     * @param id the sysEventType's id
     * @return sysEventType populated sysEventType object
     */
    public SysEventType getSysEventType(final String id);

    /**
     * Saves a sysEventType's information
     * @param sysEventType the object to be saved
     */
    public String saveSysEventType(SysEventType sysEventType);

    /**
     * Removes a sysEventType from the database by id
     * @param id the sysEventType's id
     */
    public void removeSysEventType(final String id);
     /**
     * Removes a sysEventType from the database by id
     * @param idList
     */
    public void removeSysEventTypes(final Map idList);
}

