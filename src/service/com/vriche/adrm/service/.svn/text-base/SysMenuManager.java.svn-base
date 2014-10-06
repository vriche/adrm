
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.SysMenu;
import com.vriche.adrm.dao.SysMenuDao;

public interface SysMenuManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setSysMenuDao(SysMenuDao sysMenuDAO);

    /**
     * Retrieves all of the sysMenus
     */
    public List getSysMenus(SysMenu sysMenu);
     /**
     * Retrieves all of the sysMenusCount
     */
    public String getSysMenusCount(SysMenu sysMenu);
     /**
     * Retrieves all of the sysMenusCount
     */    
    public PaginatedList getSysMenusPage(SysMenu sysMenu,String pageIndex,String pageSize);
     /**
     * Retrieves all of the sysMenusByIdList
     */
    public List getSysMenusByIdList(final Map idList);

    /**
     * Gets sysMenu's information based on id.
     * @param id the sysMenu's id
     * @return sysMenu populated sysMenu object
     */
    public SysMenu getSysMenu(final String id);

    /**
     * Saves a sysMenu's information
     * @param sysMenu the object to be saved
     */
    public String saveSysMenu(SysMenu sysMenu);
    
    
    public int saveSysMenuDefault(SysMenu sysMenu);

    /**
     * Removes a sysMenu from the database by id
     * @param id the sysMenu's id
     */
    public void removeSysMenu(final String id);
     /**
     * Removes a sysMenu from the database by id
     * @param idList
     */
    public void removeSysMenus(final Map idList);
    
//    public void saveDropSysMenu(String sysMenuId,String parentId);
    
    public String getSysMenuXML(SysMenu sysMenu, String IdPrefix);
    
    public String getSysMenuArray();
    
}

