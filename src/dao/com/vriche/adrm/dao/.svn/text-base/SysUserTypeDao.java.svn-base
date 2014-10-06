
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysUserType;

public interface SysUserTypeDao extends Dao {

    /**
     * Retrieves all of the sysUserTypes
     */
    public List getSysUserTypes(SysUserType sysUserType);
    /**
     * Retrieves all of the getSysUserTypesCount
     */
    public Integer getSysUserTypesCount(SysUserType sysUserType);   
    /**
     * Retrieves all of the getSysUserTypesPage
     */        
    public PaginatedList getSysUserTypesPage(SysUserType sysUserType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysUserTypesByIdList
     */
    public List getSysUserTypesByIdList(final Map idList);

    /**
     * Gets sysUserType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysUserType's id
     * @return sysUserType populated sysUserType object
     */
    public SysUserType getSysUserType(final Long id);

    /**
     * Saves a sysUserType's information
     * @param sysUserType the object to be saved
     */    
    public Long saveSysUserType(SysUserType sysUserType);

    /**
     * Removes a sysUserType from the database by id
     * @param id the sysUserType's id
     */
    public void removeSysUserType(final Long id);
	/**
     * Removes sysUserTypes from the database by ids
     * @param ids the sysUserType's id eg:"'1','2','3'"
     */
    public void removeSysUserTypes(final Map idList);
}

