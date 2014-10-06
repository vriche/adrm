
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.SysPromptMode;
import com.vriche.adrm.dao.SysPromptModeDao;
import com.vriche.adrm.service.SysPromptModeManager;

public class SysPromptModeManagerImpl extends BaseManager implements SysPromptModeManager {
    private SysPromptModeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysPromptModeDao(SysPromptModeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysPromptModeManager#getSysPromptModes(com.vriche.adrm.model.SysPromptMode)
     */
    public List getSysPromptModes(final SysPromptMode sysPromptMode) {
        return dao.getSysPromptModes(sysPromptMode);
    }
   /**
     * @see com.vriche.adrm.service.SysPromptModeManager#getSysPromptModesCount(com.vriche.adrm.model.SysPromptMode)
     */
    public String getSysPromptModesCount(final SysPromptMode sysPromptMode) {
        return dao.getSysPromptModesCount(sysPromptMode).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysPromptModeManager#getSysPromptModesCount(com.vriche.adrm.model.SysPromptMode)
     */    
	public PaginatedList getSysPromptModesPage(final SysPromptMode sysPromptMode,String pageIndex, String pageSize) {
		return dao.getSysPromptModesPage(sysPromptMode,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysPromptModeManager#getSysPromptMode(String id)
     */
    public SysPromptMode getSysPromptMode(final String id) {
        return dao.getSysPromptMode(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysPromptModeManager#getSysPromptModesByIdList(final Map idList)
     */
    public List getSysPromptModesByIdList(final Map idList) {
        return dao.getSysPromptModesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysPromptModeManager#saveSysPromptMode(SysPromptMode sysPromptMode)
     */
    public String saveSysPromptMode(SysPromptMode sysPromptMode) {
        return dao.saveSysPromptMode(sysPromptMode).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysPromptModeManager#removeSysPromptMode(String id)
     */
    public void removeSysPromptMode(final String id) {
        dao.removeSysPromptMode(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.SysPromptModeManager#removeSysPromptModes(String Map)
     */
    public void removeSysPromptModes(final Map idList) {
        dao.removeSysPromptModes(idList);
    }    
}
