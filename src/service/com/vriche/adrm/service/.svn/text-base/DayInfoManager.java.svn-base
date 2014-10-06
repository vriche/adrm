
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.service.Manager;

public interface DayInfoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setDayInfoDao(DayInfoDao dayInfoDAO);

    /**
     * Retrieves all of the dayInfos
     */
    public List getDayInfos(DayInfo dayInfo);
        /**
     * Retrieves all of the dayInfosByIdList
     */
    public List getDayInfosByIdList(final Map idList);

    /**
     * Gets dayInfo's information based on id.
     * @param id the dayInfo's id
     * @return dayInfo populated dayInfo object
     */
    public DayInfo getDayInfo(final String id);

    /**
     * Saves a dayInfo's information
     * @param dayInfo the object to be saved
     */
    public void saveDayInfo(DayInfo dayInfo);

    /**
     * Removes a dayInfo from the database by id
     * @param id the dayInfo's id
     */
    public void removeDayInfo(final String id);
     /**
     * Removes a dayInfo from the database by id
     * @param idList
     */
    public void removeDayInfos(final Map idList);
}

