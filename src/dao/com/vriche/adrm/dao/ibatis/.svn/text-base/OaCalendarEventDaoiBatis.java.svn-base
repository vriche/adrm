
package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaCalendarEvent;
import com.vriche.adrm.dao.OaCalendarEventDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaCalendarEventDaoiBatis extends BaseDaoiBATIS implements OaCalendarEventDao {

    /**
     * @see com.vriche.adrm.dao.OaCalendarEventDao#getOaCalendarEvents(com.vriche.adrm.model.OaCalendarEvent)
     */
    public List getOaCalendarEvents(final OaCalendarEvent oaCalendarEvent) {
//    	System.out.println("oaCalendarEvent=====" + oaCalendarEvent);
          return getSqlMapClientTemplate().queryForList("getOaCalendarEvents", oaCalendarEvent);
    }
     /**
     * @see com.vriche.adrm.dao.OaCalendarEventDao#getOaCalendarEventsCount(com.vriche.adrm.model.OaCalendarEvent)
     */
    public Integer getOaCalendarEventsCount(final OaCalendarEvent oaCalendarEvent) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaCalendarEventsCount", oaCalendarEvent);
    }
     /**
     * @see com.vriche.adrm.dao.OaCalendarEventDao#getOaCalendarEventsPage(com.vriche.adrm.model.OaCalendarEvent)
     */   
  	public PaginatedList getOaCalendarEventsPage(final OaCalendarEvent oaCalendarEvent,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaCalendarEvents",oaCalendarEvent,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaCalendarEventDao#getOaCalendarEventsByIdList(com.vriche.adrm.model.OaCalendarEvent)
     */
    public List getOaCalendarEventsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaCalendarEventsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaCalendarEventDao#getOaCalendarEvent(Long id)
     */
    public OaCalendarEvent getOaCalendarEvent(Long id) {
        OaCalendarEvent oaCalendarEvent = (OaCalendarEvent) getSqlMapClientTemplate().queryForObject("getOaCalendarEvent", id);

        if (oaCalendarEvent == null) {
            throw new ObjectRetrievalFailureException(OaCalendarEvent.class, id);
        }

        return oaCalendarEvent;
    }

    /**
     * @see com.vriche.adrm.dao.OaCalendarEventDao#saveOaCalendarEvent(OaCalendarEvent oaCalendarEvent)
     */    
    public Long saveOaCalendarEvent(final OaCalendarEvent oaCalendarEvent) {
        Long id = oaCalendarEvent.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaCalendarEvent", oaCalendarEvent);
        } else {
            getSqlMapClientTemplate().update("updateOaCalendarEvent", oaCalendarEvent);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaCalendarEvent.class, id);
        }
        
//        System.out.println("id = " + id);
        
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaCalendarEventDao#removeOaCalendarEvent(Long id)
     */
    public void removeOaCalendarEvent(Long id) {
        getSqlMapClientTemplate().update("deleteOaCalendarEvent", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaCalendarEventDAO#removeOaCalendarEvents(String ids)
     */
    public void removeOaCalendarEvents(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaCalendarEvents", idList);
    }
    public List getOaCalendarEventsByWeek(Integer beginDate, Integer lastDate,Integer type,Integer createBy){
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("beginDate",beginDate);
		map.put("lastDate",lastDate);
		map.put("type",type);
		map.put("createBy",createBy);
//		System.out.println("beginDate==========" + beginDate);
//		System.out.println("lastDate==========" + lastDate);
//		System.out.println("type==" + type);
//		System.out.println("createBy==" + createBy);
		return getSqlMapClientTemplate().queryForList("getOaCalendarEventsByWeek", map);
	}
	public List getOaCalendarEventsByBeginAndEndDate(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaCalendarEventsByDate", mp);
	}    
}
