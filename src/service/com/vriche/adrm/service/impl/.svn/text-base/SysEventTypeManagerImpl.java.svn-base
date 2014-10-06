
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.SysEventType;
import com.vriche.adrm.dao.SysEventTypeDao;
import com.vriche.adrm.service.SysEventTypeManager;

public class SysEventTypeManagerImpl extends BaseManager implements SysEventTypeManager {
    private SysEventTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysEventTypeDao(SysEventTypeDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysEventTypeManager#getSysEventTypes(com.vriche.adrm.model.SysEventType)
     */
    public List getSysEventTypes(final SysEventType sysEventType) {
        return dao.getSysEventTypes(sysEventType);
    }
   /**
     * @see com.vriche.adrm.service.SysEventTypeManager#getSysEventTypesCount(com.vriche.adrm.model.SysEventType)
     */
    public String getSysEventTypesCount(final SysEventType sysEventType) {
        return dao.getSysEventTypesCount(sysEventType).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysEventTypeManager#getSysEventTypesCount(com.vriche.adrm.model.SysEventType)
     */    
	public PaginatedList getSysEventTypesPage(final SysEventType sysEventType,String pageIndex, String pageSize) {
		return dao.getSysEventTypesPage(sysEventType,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysEventTypeManager#getSysEventType(String id)
     */
    public SysEventType getSysEventType(final String id) {
        return dao.getSysEventType(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysEventTypeManager#getSysEventTypesByIdList(final Map idList)
     */
    public List getSysEventTypesByIdList(final Map idList) {
        return dao.getSysEventTypesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysEventTypeManager#saveSysEventType(SysEventType sysEventType)
     */
    public String saveSysEventType(SysEventType sysEventType) {
        return dao.saveSysEventType(sysEventType).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysEventTypeManager#removeSysEventType(String id)
     */
    public void removeSysEventType(final String id) {
        dao.removeSysEventType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.SysEventTypeManager#removeSysEventTypes(String Map)
     */
    public void removeSysEventTypes(final Map idList) {
        dao.removeSysEventTypes(idList);
    }    
}
