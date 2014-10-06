
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.SysEventState;
import com.vriche.adrm.dao.SysEventStateDao;
import com.vriche.adrm.service.SysEventStateManager;

public class SysEventStateManagerImpl extends BaseManager implements SysEventStateManager {
    private SysEventStateDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysEventStateDao(SysEventStateDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysEventStateManager#getSysEventStates(com.vriche.adrm.model.SysEventState)
     */
    public List getSysEventStates(final SysEventState sysEventState) {
        return dao.getSysEventStates(sysEventState);
    }
   /**
     * @see com.vriche.adrm.service.SysEventStateManager#getSysEventStatesCount(com.vriche.adrm.model.SysEventState)
     */
    public String getSysEventStatesCount(final SysEventState sysEventState) {
        return dao.getSysEventStatesCount(sysEventState).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysEventStateManager#getSysEventStatesCount(com.vriche.adrm.model.SysEventState)
     */    
	public PaginatedList getSysEventStatesPage(final SysEventState sysEventState,String pageIndex, String pageSize) {
		return dao.getSysEventStatesPage(sysEventState,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysEventStateManager#getSysEventState(String id)
     */
    public SysEventState getSysEventState(final String id) {
        return dao.getSysEventState(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysEventStateManager#getSysEventStatesByIdList(final Map idList)
     */
    public List getSysEventStatesByIdList(final Map idList) {
        return dao.getSysEventStatesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysEventStateManager#saveSysEventState(SysEventState sysEventState)
     */
    public String saveSysEventState(SysEventState sysEventState) {
        return dao.saveSysEventState(sysEventState).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysEventStateManager#removeSysEventState(String id)
     */
    public void removeSysEventState(final String id) {
        dao.removeSysEventState(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.SysEventStateManager#removeSysEventStates(String Map)
     */
    public void removeSysEventStates(final Map idList) {
        dao.removeSysEventStates(idList);
    }    
}
