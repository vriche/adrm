
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.SysMenu;
import com.vriche.adrm.model.SysResource;
import com.vriche.adrm.dao.SysResourceDao;

public interface SysResourceManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysResourceDao(SysResourceDao sysResourceDAO);

    /**
     * Retrieves all of the sysResources
     */
    public List getSysResources(SysResource sysResource);
    
    public List getSysResourceByRole(final String id);
     /**
     * Retrieves all of the sysResourcesCount
     */
    public String getSysResourcesCount(SysResource sysResource);
     /**
     * Retrieves all of the sysResourcesCount
     */    
    public PaginatedList getSysResourcesPage(SysResource sysResource,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysResourcesByIdList
     */
    public List getSysResourcesByIdList(final Map idList);
    
    public List getSysResourceByRoleId(final String id);
    
    public String[] getSysResourceColByRoleId(final String roleId,String propertyName);
    
    

    /**
     * Gets sysResource's information based on id.
     * @param id the sysResource's id
     * @return sysResource populated sysResource object
     */
    public SysResource getSysResource(final String id);

    /**
     * Saves a sysResource's information
     * @param sysResource the object to be saved
     */
    public String saveSysResource(SysResource sysResource);

    /**
     * Removes a sysResource from the database by id
     * @param id the sysResource's id
     */
    public void removeSysResource(final String id);
     /**
     * Removes a sysResource from the database by id
     * @param idList
     */
    public void removeSysResources(final Map idList);
    
    public int saveSysPermitDefault(SysResource sysResource);
//    public void saveSysResourcesRoles(SysResource sysResource);
    
    
    
    
}

