
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaApplyInfo;

public interface OaApplyInfoDao extends Dao {

    /**
     * Retrieves all of the oaApplyInfos
     */
    public List getOaApplyInfos(OaApplyInfo oaApplyInfo);
    /**
     * Retrieves all of the getOaApplyInfosCount
     */
    public Integer getOaApplyInfosCount(OaApplyInfo oaApplyInfo);   
    /**
     * Retrieves all of the getOaApplyInfosPage
     */        
    public PaginatedList getOaApplyInfosPage(OaApplyInfo oaApplyInfo,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaApplyInfosByIdList
     */
    public List getOaApplyInfosByIdList(final Map idList);

    /**
     * Gets oaApplyInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaApplyInfo's id
     * @return oaApplyInfo populated oaApplyInfo object
     */
    public OaApplyInfo getOaApplyInfo(final Long id);

    /**
     * Saves a oaApplyInfo's information
     * @param oaApplyInfo the object to be saved
     */    
    public Long saveOaApplyInfo(OaApplyInfo oaApplyInfo);

    /**
     * Removes a oaApplyInfo from the database by id
     * @param id the oaApplyInfo's id
     */
    public void removeOaApplyInfo(final Long id);
	/**
     * Removes oaApplyInfos from the database by ids
     * @param ids the oaApplyInfo's id eg:"'1','2','3'"
     */
    public void removeOaApplyInfos(final Map idList);
}

