
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysPromptMode;

public interface SysPromptModeDao extends Dao {

    /**
     * Retrieves all of the sysPromptModes
     */
    public List getSysPromptModes(SysPromptMode sysPromptMode);
    /**
     * Retrieves all of the getSysPromptModesCount
     */
    public Integer getSysPromptModesCount(SysPromptMode sysPromptMode);   
    /**
     * Retrieves all of the getSysPromptModesPage
     */        
    public PaginatedList getSysPromptModesPage(SysPromptMode sysPromptMode,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysPromptModesByIdList
     */
    public List getSysPromptModesByIdList(final Map idList);

    /**
     * Gets sysPromptMode's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysPromptMode's id
     * @return sysPromptMode populated sysPromptMode object
     */
    public SysPromptMode getSysPromptMode(final Long id);

    /**
     * Saves a sysPromptMode's information
     * @param sysPromptMode the object to be saved
     */    
    public Long saveSysPromptMode(SysPromptMode sysPromptMode);

    /**
     * Removes a sysPromptMode from the database by id
     * @param id the sysPromptMode's id
     */
    public void removeSysPromptMode(final Long id);
	/**
     * Removes sysPromptModes from the database by ids
     * @param ids the sysPromptMode's id eg:"'1','2','3'"
     */
    public void removeSysPromptModes(final Map idList);
}

