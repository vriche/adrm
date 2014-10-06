
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.dao.SysParamDao;

public interface SysParamManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysParamDao(SysParamDao sysParamDAO);

    /**
     * Retrieves all of the sysParams
     */
    public List getSysParams(SysParam sysParam);
     /**
     * Retrieves all of the sysParamsCount
     */
    public String getSysParamsCount(SysParam sysParam);
     /**
     * Retrieves all of the sysParamsCount
     */    
    public PaginatedList getSysParamsPage(SysParam sysParam,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysParamsByIdList
     */
    public List getSysParamsByIdList(final Map idList);

    /**
     * Gets sysParam's information based on id.
     * @param id the sysParam's id
     * @return sysParam populated sysParam object
     */
    public SysParam getSysParam(final String id);

    /**
     * Saves a sysParam's information
     * @param sysParam the object to be saved
     */
    public String saveSysParam(SysParam sysParam);

    /**
     * Removes a sysParam from the database by id
     * @param id the sysParam's id
     */
    public void removeSysParam(final String id);
     /**
     * Removes a sysParam from the database by id
     * @param idList
     */
    public void removeSysParams(final Map idList);
    

}

