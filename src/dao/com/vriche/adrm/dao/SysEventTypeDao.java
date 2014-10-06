
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysEventType;

public interface SysEventTypeDao extends Dao {

    /**
     * Retrieves all of the sysEventTypes
     */
    public List getSysEventTypes(SysEventType sysEventType);
    /**
     * Retrieves all of the getSysEventTypesCount
     */
    public Integer getSysEventTypesCount(SysEventType sysEventType);   
    /**
     * Retrieves all of the getSysEventTypesPage
     */        
    public PaginatedList getSysEventTypesPage(SysEventType sysEventType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysEventTypesByIdList
     */
    public List getSysEventTypesByIdList(final Map idList);

    /**
     * Gets sysEventType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysEventType's id
     * @return sysEventType populated sysEventType object
     */
    public SysEventType getSysEventType(final Long id);

    /**
     * Saves a sysEventType's information
     * @param sysEventType the object to be saved
     */    
    public Long saveSysEventType(SysEventType sysEventType);

    /**
     * Removes a sysEventType from the database by id
     * @param id the sysEventType's id
     */
    public void removeSysEventType(final Long id);
	/**
     * Removes sysEventTypes from the database by ids
     * @param ids the sysEventType's id eg:"'1','2','3'"
     */
    public void removeSysEventTypes(final Map idList);
}

