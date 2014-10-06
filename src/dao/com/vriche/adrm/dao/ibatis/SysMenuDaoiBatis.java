
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysMenu;
import com.vriche.adrm.dao.SysMenuDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysMenuDaoiBatis extends BaseDaoiBATIS implements SysMenuDao {

    /**
     * @see com.vriche.adrm.dao.SysMenuDao#getSysMenus(com.vriche.adrm.model.SysMenu)
     */
    public List getSysMenus(final SysMenu sysMenu) {
          return getSqlMapClientTemplate().queryForList("getSysMenus", sysMenu);
    }
     /**
     * @see com.vriche.adrm.dao.SysMenuDao#getSysMenusCount(com.vriche.adrm.model.SysMenu)
     */
    public Integer getSysMenusCount(final SysMenu sysMenu) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysMenusCount", sysMenu);
    }
     /**
     * @see com.vriche.adrm.dao.SysMenuDao#getSysMenusPage(com.vriche.adrm.model.SysMenu)
     */   
  	public PaginatedList getSysMenusPage(final SysMenu sysMenu,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysMenus",sysMenu,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysMenuDao#getSysMenusByIdList(com.vriche.adrm.model.SysMenu)
     */
    public List getSysMenusByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysMenusByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysMenuDao#getSysMenu(Long id)
     */
    public SysMenu getSysMenu(Long id) {
        SysMenu sysMenu = (SysMenu) getSqlMapClientTemplate().queryForObject("getSysMenu", id);

        if (sysMenu == null) {
            throw new ObjectRetrievalFailureException(SysMenu.class, id);
        }

        return sysMenu;
    }

    /**
     * @see com.vriche.adrm.dao.SysMenuDao#saveSysMenu(SysMenu sysMenu)
     */    
    public Long saveSysMenu(final SysMenu sysMenu) {
        Long id = sysMenu.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysMenu", sysMenu);
        } else {
            getSqlMapClientTemplate().update("updateSysMenu", sysMenu);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysMenu.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysMenuDao#removeSysMenu(Long id)
     */
    public void removeSysMenu(Long id) {
        getSqlMapClientTemplate().update("deleteSysMenu", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysMenuDAO#removeSysMenus(String ids)
     */
    public void removeSysMenus(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysMenus", idList);
    }
    


    
}
