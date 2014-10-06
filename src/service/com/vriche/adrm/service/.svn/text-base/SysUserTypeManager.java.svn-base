
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysUserType;
import com.vriche.adrm.dao.SysUserTypeDao;

public interface SysUserTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysUserTypeDao(SysUserTypeDao sysUserTypeDAO);

    /**
     * Retrieves all of the sysUserTypes
     */
    public List getSysUserTypes(SysUserType sysUserType);
     /**
     * Retrieves all of the sysUserTypesCount
     */
    public String getSysUserTypesCount(SysUserType sysUserType);
     /**
     * Retrieves all of the sysUserTypesCount
     */    
    public PaginatedList getSysUserTypesPage(SysUserType sysUserType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysUserTypesByIdList
     */
    public List getSysUserTypesByIdList(final Map idList);

    /**
     * Gets sysUserType's information based on id.
     * @param id the sysUserType's id
     * @return sysUserType populated sysUserType object
     */
    public SysUserType getSysUserType(final String id);

    /**
     * Saves a sysUserType's information
     * @param sysUserType the object to be saved
     */
    public String saveSysUserType(SysUserType sysUserType);

    /**
     * Removes a sysUserType from the database by id
     * @param id the sysUserType's id
     */
    public void removeSysUserType(final String id);
     /**
     * Removes a sysUserType from the database by id
     * @param idList
     */
    public void removeSysUserTypes(final Map idList);
}

