
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysEventState;

public interface SysEventStateDao extends Dao {

    /**
     * Retrieves all of the sysEventStates
     */
    public List getSysEventStates(SysEventState sysEventState);
    /**
     * Retrieves all of the getSysEventStatesCount
     */
    public Integer getSysEventStatesCount(SysEventState sysEventState);   
    /**
     * Retrieves all of the getSysEventStatesPage
     */        
    public PaginatedList getSysEventStatesPage(SysEventState sysEventState,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysEventStatesByIdList
     */
    public List getSysEventStatesByIdList(final Map idList);

    /**
     * Gets sysEventState's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysEventState's id
     * @return sysEventState populated sysEventState object
     */
    public SysEventState getSysEventState(final Long id);

    /**
     * Saves a sysEventState's information
     * @param sysEventState the object to be saved
     */    
    public Long saveSysEventState(SysEventState sysEventState);

    /**
     * Removes a sysEventState from the database by id
     * @param id the sysEventState's id
     */
    public void removeSysEventState(final Long id);
	/**
     * Removes sysEventStates from the database by ids
     * @param ids the sysEventState's id eg:"'1','2','3'"
     */
    public void removeSysEventStates(final Map idList);
}

