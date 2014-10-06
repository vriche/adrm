
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaProductInfo;

public interface OaProductInfoDao extends Dao {

    /**
     * Retrieves all of the oaProductInfos
     */
    public List getOaProductInfos(OaProductInfo oaProductInfo);
    /**
     * Retrieves all of the getOaProductInfosCount
     */
    public Integer getOaProductInfosCount(OaProductInfo oaProductInfo);   
    /**
     * Retrieves all of the getOaProductInfosPage
     */        
    public PaginatedList getOaProductInfosPage(OaProductInfo oaProductInfo,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaProductInfosByIdList
     */
    public List getOaProductInfosByIdList(final Map idList);

    /**
     * Gets oaProductInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaProductInfo's id
     * @return oaProductInfo populated oaProductInfo object
     */
    public OaProductInfo getOaProductInfo(final Long id);

    /**
     * Saves a oaProductInfo's information
     * @param oaProductInfo the object to be saved
     */    
    public Long saveOaProductInfo(OaProductInfo oaProductInfo);

    /**
     * Removes a oaProductInfo from the database by id
     * @param id the oaProductInfo's id
     */
    public void removeOaProductInfo(final Long id);
	/**
     * Removes oaProductInfos from the database by ids
     * @param ids the oaProductInfo's id eg:"'1','2','3'"
     */
    public void removeOaProductInfos(final Map idList);
}

