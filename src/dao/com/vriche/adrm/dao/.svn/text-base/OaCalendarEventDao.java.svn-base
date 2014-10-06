
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaCalendarEvent;

public interface OaCalendarEventDao extends Dao {

    /**
     * Retrieves all of the oaCalendarEvents
     */
    public List getOaCalendarEvents(OaCalendarEvent oaCalendarEvent);
    
    public List getOaCalendarEventsByWeek(Integer beginDate, Integer lastDate,Integer type,Integer createBy);
    /**
     * Retrieves all of the getOaCalendarEventsCount
     */
    public Integer getOaCalendarEventsCount(OaCalendarEvent oaCalendarEvent);   
    /**
     * Retrieves all of the getOaCalendarEventsPage
     */        
    public PaginatedList getOaCalendarEventsPage(OaCalendarEvent oaCalendarEvent,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaCalendarEventsByIdList
     */
    public List getOaCalendarEventsByIdList(final Map idList);

    /**
     * Gets oaCalendarEvent's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaCalendarEvent's id
     * @return oaCalendarEvent populated oaCalendarEvent object
     */
    public OaCalendarEvent getOaCalendarEvent(final Long id);

    /**
     * Saves a oaCalendarEvent's information
     * @param oaCalendarEvent the object to be saved
     */    
    public Long saveOaCalendarEvent(OaCalendarEvent oaCalendarEvent);

    /**
     * Removes a oaCalendarEvent from the database by id
     * @param id the oaCalendarEvent's id
     */
    public void removeOaCalendarEvent(final Long id);
	/**
     * Removes oaCalendarEvents from the database by ids
     * @param ids the oaCalendarEvent's id eg:"'1','2','3'"
     */
    public void removeOaCalendarEvents(final Map idList);
    
    public List getOaCalendarEventsByBeginAndEndDate(final Map idList);
}

