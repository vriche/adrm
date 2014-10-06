
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.service.DayInfoManager;
import com.vriche.adrm.service.impl.BaseManager;

public class DayInfoManagerImpl extends BaseManager implements DayInfoManager {
    private DayInfoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setDayInfoDao(DayInfoDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.DayInfoManager#getDayInfosByIdList(final Map idList)
     */
    public List getDayInfosByIdList(final Map idList) {
        return dao.getDayInfosByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.DayInfoManager#getDayInfos(com.vriche.adrm.adres.model.DayInfo)
     */
    public List getDayInfos(final DayInfo dayInfo) {
        return dao.getDayInfos(dayInfo);
    }

    /**
     * @see com.vriche.adrm.adres.service.DayInfoManager#getDayInfo(String id)
     */
    public DayInfo getDayInfo(final String id) {
        return dao.getDayInfo(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.DayInfoManager#saveDayInfo(DayInfo dayInfo)
     */
    public void saveDayInfo(DayInfo dayInfo) {
        dao.saveDayInfo(dayInfo);
    }

    /**
     * @see com.vriche.adrm.adres.service.DayInfoManager#removeDayInfo(String id)
     */
    public void removeDayInfo(final String id) {
        dao.removeDayInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.DayInfoManager#removeDayInfos(String Map)
     */
    public void removeDayInfos(final Map idList) {
        dao.removeDayInfos(idList);
    }    
}
