
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaCalendarEvent;
import com.vriche.adrm.dao.OaCalendarEventDao;

public interface OaCalendarEventManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaCalendarEventDao(OaCalendarEventDao oaCalendarEventDAO);

    /**
     * Retrieves all of the oaCalendarEvents
     */
    public List getOaCalendarEvents(OaCalendarEvent oaCalendarEvent);
    
    public List getOaCalendarEventsByWeek(Integer beginDate, Integer lastDate,Integer type,Integer createBy);
     /**
     * Retrieves all of the oaCalendarEventsCount
     */
    public String getOaCalendarEventsCount(OaCalendarEvent oaCalendarEvent);
     /**
     * Retrieves all of the oaCalendarEventsCount
     */    
    public PaginatedList getOaCalendarEventsPage(OaCalendarEvent oaCalendarEvent,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaCalendarEventsByIdList
     */
    public List getOaCalendarEventsByIdList(final Map idList);

    /**
     * Gets oaCalendarEvent's information based on id.
     * @param id the oaCalendarEvent's id
     * @return oaCalendarEvent populated oaCalendarEvent object
     */
    public OaCalendarEvent getOaCalendarEvent(final String id);

    /**
     * Saves a oaCalendarEvent's information
     * @param oaCalendarEvent the object to be saved
     */
    public String saveOaCalendarEvent(OaCalendarEvent oaCalendarEvent);

    /**
     * Removes a oaCalendarEvent from the database by id
     * @param id the oaCalendarEvent's id
     */
    public void removeOaCalendarEvent(final String id);
     /**
     * Removes a oaCalendarEvent from the database by id
     * @param idList
     */
    public void removeOaCalendarEvents(final Map idList);
    
    public List getOaCalendarEventsByBeginAndEndDate(String beginDate,String endDate);
}

