
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.DayInfo;

public interface DayInfoDao extends Dao {

    /**
     * Retrieves all of the dayInfos
     */
    public List getDayInfos(DayInfo dayInfo);
    
    public List getDayInfos2(DayInfo dayInfo);
    
    public List getDayInfosFromOrder(DayInfo dayInfo);

    
    public List getDayInfosForFree(final DayInfo dayInfo) ;
    
//    public List getDayInfosFree(final DayInfo dayInfo) ;
    
    
    /**
     * Retrieves all of the dayInfosByIdList
     */
    public List getDayInfosByIdList(final Map idList);
    

    /**
     * Gets dayInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the dayInfo's id
     * @return dayInfo populated dayInfo object
     */
    public DayInfo getDayInfo(final Long id);

    /**
     * Saves a dayInfo's information
     * @param dayInfo the object to be saved
     */    
    public void saveDayInfo(DayInfo dayInfo);

    

    /**
     * Removes a dayInfo from the database by id
     * @param id the dayInfo's id
     */
    public void removeDayInfo(final Long id);
	/**
     * Removes dayInfos from the database by ids
     * @param ids the dayInfo's id eg:"'1','2','3'"
     */
    public void removeDayInfos(final Map idList);
    
    public List getGroupLeftTime(final DayInfo dayInfo);
    
    public void saveDayInfo2(final DayInfo[] dayInfos);
    
    public void saveDayInfo2(final Map newResMap);
    
    public void updateDayInfoLock(final Map newResMap);
    
    
  
}

