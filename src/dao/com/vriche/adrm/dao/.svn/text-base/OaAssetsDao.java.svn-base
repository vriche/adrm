
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaAssets;

public interface OaAssetsDao extends Dao {

    /**
     * Retrieves all of the oaAssetss
     */
    public List getOaAssetss(OaAssets oaAssets);
    /**
     * Retrieves all of the getOaAssetssCount
     */
    public Integer getOaAssetssCount(OaAssets oaAssets);   
    /**
     * Retrieves all of the getOaAssetssPage
     */        
    public PaginatedList getOaAssetssPage(OaAssets oaAssets,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaAssetssByIdList
     */
    public List getOaAssetssByIdList(final Map idList);

    /**
     * Gets oaAssets's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaAssets's id
     * @return oaAssets populated oaAssets object
     */
    public OaAssets getOaAssets(final Long id);

    /**
     * Saves a oaAssets's information
     * @param oaAssets the object to be saved
     */    
    public Long saveOaAssets(OaAssets oaAssets);

    /**
     * Removes a oaAssets from the database by id
     * @param id the oaAssets's id
     */
    public void removeOaAssets(final Long id);
	/**
     * Removes oaAssetss from the database by ids
     * @param ids the oaAssets's id eg:"'1','2','3'"
     */
    public void removeOaAssetss(final Map idList);
}

