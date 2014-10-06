
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysParam;

public interface SysParamDao extends Dao {

    /**
     * Retrieves all of the sysParams
     */
    public List getSysParams(SysParam sysParam);
    /**
     * Retrieves all of the getSysParamsCount
     */
    public Integer getSysParamsCount(SysParam sysParam);   
    /**
     * Retrieves all of the getSysParamsPage
     */        
    public PaginatedList getSysParamsPage(SysParam sysParam,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysParamsByIdList
     */
    public List getSysParamsByIdList(final Map idList);

    /**
     * Gets sysParam's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysParam's id
     * @return sysParam populated sysParam object
     */
    public SysParam getSysParam(final Long id);
    
    
    public SysParam getSysParam(SysParam sysParam);

    /**
     * Saves a sysParam's information
     * @param sysParam the object to be saved
     */    
    public Long saveSysParam(SysParam sysParam);
    
    
    public void saveSysParamByTarger(SysParam sysParam);

    /**
     * Removes a sysParam from the database by id
     * @param id the sysParam's id
     */
    public void removeSysParam(final Long id);
	/**
     * Removes sysParams from the database by ids
     * @param ids the sysParam's id eg:"'1','2','3'"
     */
    public void removeSysParams(final Map idList);
}

