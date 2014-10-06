
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaProductInfo;
import com.vriche.adrm.dao.OaProductInfoDao;

public interface OaProductInfoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaProductInfoDao(OaProductInfoDao oaProductInfoDAO);

    /**
     * Retrieves all of the oaProductInfos
     */
    public List getOaProductInfos(OaProductInfo oaProductInfo);
     /**
     * Retrieves all of the oaProductInfosCount
     */
    public String getOaProductInfosCount(OaProductInfo oaProductInfo);
     /**
     * Retrieves all of the oaProductInfosCount
     */    
    public PaginatedList getOaProductInfosPage(OaProductInfo oaProductInfo,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaProductInfosByIdList
     */
    public List getOaProductInfosByIdList(final Map idList);

    /**
     * Gets oaProductInfo's information based on id.
     * @param id the oaProductInfo's id
     * @return oaProductInfo populated oaProductInfo object
     */
    public OaProductInfo getOaProductInfo(final String id);

    /**
     * Saves a oaProductInfo's information
     * @param oaProductInfo the object to be saved
     */
    public String saveOaProductInfo(OaProductInfo oaProductInfo);

    /**
     * Removes a oaProductInfo from the database by id
     * @param id the oaProductInfo's id
     */
    public void removeOaProductInfo(final String id);
     /**
     * Removes a oaProductInfo from the database by id
     * @param idList
     */
    public void removeOaProductInfos(final Map idList);
}

