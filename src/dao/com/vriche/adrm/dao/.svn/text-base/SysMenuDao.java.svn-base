
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.model.SysMenu;

public interface SysMenuDao extends Dao {

    /**
     * Retrieves all of the sysMenus
     */
    public List getSysMenus(SysMenu sysMenu);
    /**
     * Retrieves all of the getSysMenusCount
     */
    public Integer getSysMenusCount(SysMenu sysMenu);   
    /**
     * Retrieves all of the getSysMenusPage
     */        
    public PaginatedList getSysMenusPage(SysMenu sysMenu,int pageIndex,int pageSize);
    /**
     * Retrieves all of the sysMenusByIdList
     */
    public List getSysMenusByIdList(final Map idList);

    /**
     * Gets sysMenu's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the sysMenu's id
     * @return sysMenu populated sysMenu object
     */
    public SysMenu getSysMenu(final Long id);

    /**
     * Saves a sysMenu's information
     * @param sysMenu the object to be saved
     */    
    public Long saveSysMenu(SysMenu sysMenu);

    /**
     * Removes a sysMenu from the database by id
     * @param id the sysMenu's id
     */
    public void removeSysMenu(final Long id);
	/**
     * Removes sysMenus from the database by ids
     * @param ids the sysMenu's id eg:"'1','2','3'"
     */
    public void removeSysMenus(final Map idList);
    
    

    
//    public int saveSysMenuDefault(String);
}

