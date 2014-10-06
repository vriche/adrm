
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaInfo;

public interface OaInfoDao extends Dao {

    /**
     * Retrieves all of the oaInfos
     */
    public List getOaInfos(OaInfo oaInfo);
    /**
     * Retrieves all of the getOaInfosCount
     */
    public Integer getOaInfosCount(OaInfo oaInfo);   
    /**
     * Retrieves all of the getOaInfosPage
     */        
    public PaginatedList getOaInfosPage(OaInfo oaInfo,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaInfosByIdList
     */
    public List getOaInfosByIdList(final Map idList);

    /**
     * Gets oaInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaInfo's id
     * @return oaInfo populated oaInfo object
     */
    public OaInfo getOaInfo(final Long id);

    /**
     * Saves a oaInfo's information
     * @param oaInfo the object to be saved
     */    
    public Long saveOaInfo(OaInfo oaInfo);

    /**
     * Removes a oaInfo from the database by id
     * @param id the oaInfo's id
     */
    public void removeOaInfo(final Long id);
	/**
     * Removes oaInfos from the database by ids
     * @param ids the oaInfo's id eg:"'1','2','3'"
     */
    public void removeOaInfos(final Map idList);
}

