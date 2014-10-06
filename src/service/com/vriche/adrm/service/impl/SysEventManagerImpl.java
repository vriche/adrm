
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.SysEvent;
import com.vriche.adrm.dao.SysEventDao;
import com.vriche.adrm.service.SysEventManager;

public class SysEventManagerImpl extends BaseManager implements SysEventManager {
    private SysEventDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysEventDao(SysEventDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysEventManager#getSysEvents(com.vriche.adrm.model.SysEvent)
     */
    public List getSysEvents(final SysEvent sysEvent) {
        return dao.getSysEvents(sysEvent);
    }
   /**
     * @see com.vriche.adrm.service.SysEventManager#getSysEventsCount(com.vriche.adrm.model.SysEvent)
     */
    public String getSysEventsCount(final SysEvent sysEvent) {
        return dao.getSysEventsCount(sysEvent).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysEventManager#getSysEventsCount(com.vriche.adrm.model.SysEvent)
     */    
	public PaginatedList getSysEventsPage(final SysEvent sysEvent,String pageIndex, String pageSize) {
		return dao.getSysEventsPage(sysEvent,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysEventManager#getSysEvent(String id)
     */
    public SysEvent getSysEvent(final String id) {
        return dao.getSysEvent(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysEventManager#getSysEventsByIdList(final Map idList)
     */
    public List getSysEventsByIdList(final Map idList) {
        return dao.getSysEventsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysEventManager#saveSysEvent(SysEvent sysEvent)
     */
    public String saveSysEvent(SysEvent sysEvent) {
        return dao.saveSysEvent(sysEvent).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysEventManager#removeSysEvent(String id)
     */
    public void removeSysEvent(final String id) {
        dao.removeSysEvent(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.SysEventManager#removeSysEvents(String Map)
     */
    public void removeSysEvents(final Map idList) {
        dao.removeSysEvents(idList);
    }    
}
