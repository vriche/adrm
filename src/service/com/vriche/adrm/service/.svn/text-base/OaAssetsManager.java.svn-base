
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaAssets;
import com.vriche.adrm.dao.OaAssetsDao;

public interface OaAssetsManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaAssetsDao(OaAssetsDao oaAssetsDAO);

    /**
     * Retrieves all of the oaAssetss
     */
    public List getOaAssetss(OaAssets oaAssets);
     /**
     * Retrieves all of the oaAssetssCount
     */
    public String getOaAssetssCount(OaAssets oaAssets);
     /**
     * Retrieves all of the oaAssetssCount
     */    
    public PaginatedList getOaAssetssPage(OaAssets oaAssets,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaAssetssByIdList
     */
    public List getOaAssetssByIdList(final Map idList);

    /**
     * Gets oaAssets's information based on id.
     * @param id the oaAssets's id
     * @return oaAssets populated oaAssets object
     */
    public OaAssets getOaAssets(final String id);

    /**
     * Saves a oaAssets's information
     * @param oaAssets the object to be saved
     */
    public String saveOaAssets(OaAssets oaAssets);

    /**
     * Removes a oaAssets from the database by id
     * @param id the oaAssets's id
     */
    public void removeOaAssets(final String id);
     /**
     * Removes a oaAssets from the database by id
     * @param idList
     */
    public void removeOaAssetss(final Map idList);
}

