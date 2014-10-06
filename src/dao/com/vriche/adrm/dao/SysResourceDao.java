
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.SysResource;

public interface SysResourceDao extends Dao {

    /**
     * Retrieves all of the sysResources
     */
    public List getSysResources(SysResource sysResource);
    
    /**
     * Retrieves all of the getSysResourcesCount
     */
    public Integer getSysResourcesCount(SysResource sysResource);   
    /**
     * Retrieves all of the getSysResourcesPage
     */        
    public PaginatedList getSysResourcesPage(SysResource sysResource,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysResourcesByIdList
     */
    public List getSysResourcesByIdList(final Map idList);

    /**
     * Gets sysResource's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysResource's id
     * @return sysResource populated sysResource object
     */
    public SysResource getSysResource(final Long id);
    
    public List getSysResourceByRoleId(final Long roleId);
    
    

    /**
     * Saves a sysResource's information
     * @param sysResource the object to be saved
     */    
    public Long saveSysResource(SysResource sysResource);

    /**
     * Removes a sysResource from the database by id
     * @param id the sysResource's id
     */
    public void removeSysResource(final Long id);
	/**
     * Removes sysResources from the database by ids
     * @param ids the sysResource's id eg:"'1','2','3'"
     */
    public void removeSysResources(final Map idList);
    
    
    public void addRoleSysResources(final Map mp);
    
    public List getSysResourceByRole(Long id);
    
    public void deleteRoleBySysResource(final Long id);
    
    public void deleteRoleBySysResourceIds(final Map idList);
    
    
    
    
    
    
}

