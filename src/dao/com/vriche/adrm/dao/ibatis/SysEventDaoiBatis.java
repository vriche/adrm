
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysEvent;
import com.vriche.adrm.dao.SysEventDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventDaoiBatis extends BaseDaoiBATIS implements SysEventDao {

    /**
     * @see com.vriche.adrm.dao.SysEventDao#getSysEvents(com.vriche.adrm.model.SysEvent)
     */
    public List getSysEvents(final SysEvent sysEvent) {
          return getSqlMapClientTemplate().queryForList("getSysEvents", sysEvent);
    }
     /**
     * @see com.vriche.adrm.dao.SysEventDao#getSysEventsCount(com.vriche.adrm.model.SysEvent)
     */
    public Integer getSysEventsCount(final SysEvent sysEvent) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysEventsCount", sysEvent);
    }
     /**
     * @see com.vriche.adrm.dao.SysEventDao#getSysEventsPage(com.vriche.adrm.model.SysEvent)
     */   
  	public PaginatedList getSysEventsPage(final SysEvent sysEvent,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysEvents",sysEvent,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysEventDao#getSysEventsByIdList(com.vriche.adrm.model.SysEvent)
     */
    public List getSysEventsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysEventsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysEventDao#getSysEvent(Long id)
     */
    public SysEvent getSysEvent(Long id) {
        SysEvent sysEvent = (SysEvent) getSqlMapClientTemplate().queryForObject("getSysEvent", id);

        if (sysEvent == null) {
            throw new ObjectRetrievalFailureException(SysEvent.class, id);
        }

        return sysEvent;
    }

    /**
     * @see com.vriche.adrm.dao.SysEventDao#saveSysEvent(SysEvent sysEvent)
     */    
    public Long saveSysEvent(final SysEvent sysEvent) {
        Long id = sysEvent.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysEvent", sysEvent);
        } else {
            getSqlMapClientTemplate().update("updateSysEvent", sysEvent);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysEvent.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysEventDao#removeSysEvent(Long id)
     */
    public void removeSysEvent(Long id) {
        getSqlMapClientTemplate().update("deleteSysEvent", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysEventDAO#removeSysEvents(String ids)
     */
    public void removeSysEvents(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysEvents", idList);
    }    
}
