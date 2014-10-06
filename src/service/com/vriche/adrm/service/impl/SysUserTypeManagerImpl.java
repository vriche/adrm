
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.SysUserType;
import com.vriche.adrm.dao.SysUserTypeDao;
import com.vriche.adrm.service.SysUserTypeManager;

public class SysUserTypeManagerImpl extends BaseManager implements SysUserTypeManager {
    private SysUserTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysUserTypeDao(SysUserTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysUserTypeManager#getSysUserTypes(com.vriche.adrm.model.SysUserType)
     */
    public List getSysUserTypes(final SysUserType sysUserType) {
        return dao.getSysUserTypes(sysUserType);
    }
   /**
     * @see com.vriche.adrm.service.SysUserTypeManager#getSysUserTypesCount(com.vriche.adrm.model.SysUserType)
     */
    public String getSysUserTypesCount(final SysUserType sysUserType) {
        return dao.getSysUserTypesCount(sysUserType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysUserTypeManager#getSysUserTypesCount(com.vriche.adrm.model.SysUserType)
     */    
	public PaginatedList getSysUserTypesPage(final SysUserType sysUserType,String pageIndex, String pageSize) {
		return dao.getSysUserTypesPage(sysUserType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysUserTypeManager#getSysUserType(String id)
     */
    public SysUserType getSysUserType(final String id) {
        return dao.getSysUserType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysUserTypeManager#getSysUserTypesByIdList(final Map idList)
     */
    public List getSysUserTypesByIdList(final Map idList) {
        return dao.getSysUserTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysUserTypeManager#saveSysUserType(SysUserType sysUserType)
     */
    public String saveSysUserType(SysUserType sysUserType) {
        return dao.saveSysUserType(sysUserType).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysUserTypeManager#removeSysUserType(String id)
     */
    public void removeSysUserType(final String id) {
        dao.removeSysUserType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.SysUserTypeManager#removeSysUserTypes(String Map)
     */
    public void removeSysUserTypes(final Map idList) {
        dao.removeSysUserTypes(idList);
    }    
}
