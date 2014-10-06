
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaInfo;
import com.vriche.adrm.dao.OaInfoDao;

public interface OaInfoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaInfoDao(OaInfoDao oaInfoDAO);

    /**
     * Retrieves all of the oaInfos
     */
    public List getOaInfos(OaInfo oaInfo);
     /**
     * Retrieves all of the oaInfosCount
     */
    public String getOaInfosCount(OaInfo oaInfo);
     /**
     * Retrieves all of the oaInfosCount
     */    
    public PaginatedList getOaInfosPage(OaInfo oaInfo,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaInfosByIdList
     */
    public List getOaInfosByIdList(final Map idList);

    /**
     * Gets oaInfo's information based on id.
     * @param id the oaInfo's id
     * @return oaInfo populated oaInfo object
     */
    public OaInfo getOaInfo(final String id);

    /**
     * Saves a oaInfo's information
     * @param oaInfo the object to be saved
     */
    public String saveOaInfo(OaInfo oaInfo);

    /**
     * Removes a oaInfo from the database by id
     * @param id the oaInfo's id
     */
    public void removeOaInfo(final String id);
     /**
     * Removes a oaInfo from the database by id
     * @param idList
     */
    public void removeOaInfos(final Map idList);
    
    public Map getOaInfoSelect(OaInfo oaInfo);
}

