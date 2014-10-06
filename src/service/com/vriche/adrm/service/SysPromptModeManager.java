
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysPromptMode;
import com.vriche.adrm.dao.SysPromptModeDao;

public interface SysPromptModeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysPromptModeDao(SysPromptModeDao sysPromptModeDAO);

    /**
     * Retrieves all of the sysPromptModes
     */
    public List getSysPromptModes(SysPromptMode sysPromptMode);
     /**
     * Retrieves all of the sysPromptModesCount
     */
    public String getSysPromptModesCount(SysPromptMode sysPromptMode);
     /**
     * Retrieves all of the sysPromptModesCount
     */    
    public PaginatedList getSysPromptModesPage(SysPromptMode sysPromptMode,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysPromptModesByIdList
     */
    public List getSysPromptModesByIdList(final Map idList);

    /**
     * Gets sysPromptMode's information based on id.
     * @param id the sysPromptMode's id
     * @return sysPromptMode populated sysPromptMode object
     */
    public SysPromptMode getSysPromptMode(final String id);

    /**
     * Saves a sysPromptMode's information
     * @param sysPromptMode the object to be saved
     */
    public String saveSysPromptMode(SysPromptMode sysPromptMode);

    /**
     * Removes a sysPromptMode from the database by id
     * @param id the sysPromptMode's id
     */
    public void removeSysPromptMode(final String id);
     /**
     * Removes a sysPromptMode from the database by id
     * @param idList
     */
    public void removeSysPromptModes(final Map idList);
}

