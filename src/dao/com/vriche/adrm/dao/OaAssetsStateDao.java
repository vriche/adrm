
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaAssetsState;

public interface OaAssetsStateDao extends Dao {

    /**
     * Retrieves all of the oaAssetsStates
     */
    public List getOaAssetsStates(OaAssetsState oaAssetsState);
    /**
     * Retrieves all of the getOaAssetsStatesCount
     */
    public Integer getOaAssetsStatesCount(OaAssetsState oaAssetsState);   
    /**
     * Retrieves all of the getOaAssetsStatesPage
     */        
    public PaginatedList getOaAssetsStatesPage(OaAssetsState oaAssetsState,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaAssetsStatesByIdList
     */
    public List getOaAssetsStatesByIdList(final Map idList);

    /**
     * Gets oaAssetsState's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaAssetsState's id
     * @return oaAssetsState populated oaAssetsState object
     */
    public OaAssetsState getOaAssetsState(final Long id);

    /**
     * Saves a oaAssetsState's information
     * @param oaAssetsState the object to be saved
     */    
    public Long saveOaAssetsState(OaAssetsState oaAssetsState);

    /**
     * Removes a oaAssetsState from the database by id
     * @param id the oaAssetsState's id
     */
    public void removeOaAssetsState(final Long id);
	/**
     * Removes oaAssetsStates from the database by ids
     * @param ids the oaAssetsState's id eg:"'1','2','3'"
     */
    public void removeOaAssetsStates(final Map idList);
}

