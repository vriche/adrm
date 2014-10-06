
package com.vriche.adrm.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaCalendarEventDao;
import com.vriche.adrm.model.OaCalendarEvent;
import com.vriche.adrm.service.OaCalendarEventManager;

public class OaCalendarEventManagerImpl extends BaseManager implements OaCalendarEventManager {
    private OaCalendarEventDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaCalendarEventDao(OaCalendarEventDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#getOaCalendarEvents(com.vriche.adrm.model.OaCalendarEvent)
     */
    public List getOaCalendarEvents(final OaCalendarEvent oaCalendarEvent) {
        return dao.getOaCalendarEvents(oaCalendarEvent);
    }
   /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#getOaCalendarEventsCount(com.vriche.adrm.model.OaCalendarEvent)
     */
    public String getOaCalendarEventsCount(final OaCalendarEvent oaCalendarEvent) {
        return dao.getOaCalendarEventsCount(oaCalendarEvent).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#getOaCalendarEventsCount(com.vriche.adrm.model.OaCalendarEvent)
     */    
	public PaginatedList getOaCalendarEventsPage(final OaCalendarEvent oaCalendarEvent,String pageIndex, String pageSize) {
		return dao.getOaCalendarEventsPage(oaCalendarEvent,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#getOaCalendarEvent(String id)
     */
    public OaCalendarEvent getOaCalendarEvent(final String id) {
        return dao.getOaCalendarEvent(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#getOaCalendarEventsByIdList(final Map idList)
     */
    public List getOaCalendarEventsByIdList(final Map idList) {
        return dao.getOaCalendarEventsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#saveOaCalendarEvent(OaCalendarEvent oaCalendarEvent)
     */
    public String saveOaCalendarEvent(OaCalendarEvent oaCalendarEvent) {
        return dao.saveOaCalendarEvent(oaCalendarEvent).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#removeOaCalendarEvent(String id)
     */
    public void removeOaCalendarEvent(final String id) {
        dao.removeOaCalendarEvent(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaCalendarEventManager#removeOaCalendarEvents(String Map)
     */
    public void removeOaCalendarEvents(final Map idList) {
        dao.removeOaCalendarEvents(idList);
    }
	public List getOaCalendarEventsByWeek(Integer beginDate, Integer lastDate,Integer type,Integer createBy){
		
		return dao.getOaCalendarEventsByWeek(beginDate,lastDate,type,createBy);
	}
	public List getOaCalendarEventsByBeginAndEndDate(String beginDate, String endDate) {
		Map mp = new HashMap();
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		return dao.getOaCalendarEventsByBeginAndEndDate(mp);
	}    
}
