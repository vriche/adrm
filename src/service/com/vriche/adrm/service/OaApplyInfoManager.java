
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaApplyInfo;
import com.vriche.adrm.dao.OaApplyInfoDao;

public interface OaApplyInfoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaApplyInfoDao(OaApplyInfoDao oaApplyInfoDAO);

    /**
     * Retrieves all of the oaApplyInfos
     */
    public List getOaApplyInfos(OaApplyInfo oaApplyInfo);
     /**
     * Retrieves all of the oaApplyInfosCount
     */
    public String getOaApplyInfosCount(OaApplyInfo oaApplyInfo);
     /**
     * Retrieves all of the oaApplyInfosCount
     */    
    public PaginatedList getOaApplyInfosPage(OaApplyInfo oaApplyInfo,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaApplyInfosByIdList
     */
    public List getOaApplyInfosByIdList(final Map idList);

    /**
     * Gets oaApplyInfo's information based on id.
     * @param id the oaApplyInfo's id
     * @return oaApplyInfo populated oaApplyInfo object
     */
    public OaApplyInfo getOaApplyInfo(final String id);

    /**
     * Saves a oaApplyInfo's information
     * @param oaApplyInfo the object to be saved
     */
    public String saveOaApplyInfo(OaApplyInfo oaApplyInfo);

    /**
     * Removes a oaApplyInfo from the database by id
     * @param id the oaApplyInfo's id
     */
    public void removeOaApplyInfo(final String id);
     /**
     * Removes a oaApplyInfo from the database by id
     * @param idList
     */
    public void removeOaApplyInfos(final Map idList);
}

