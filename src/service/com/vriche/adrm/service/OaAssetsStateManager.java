
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaAssetsState;
import com.vriche.adrm.dao.OaAssetsStateDao;

public interface OaAssetsStateManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaAssetsStateDao(OaAssetsStateDao oaAssetsStateDAO);

    /**
     * Retrieves all of the oaAssetsStates
     */
    public List getOaAssetsStates(OaAssetsState oaAssetsState);
     /**
     * Retrieves all of the oaAssetsStatesCount
     */
    public String getOaAssetsStatesCount(OaAssetsState oaAssetsState);
     /**
     * Retrieves all of the oaAssetsStatesCount
     */    
    public PaginatedList getOaAssetsStatesPage(OaAssetsState oaAssetsState,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaAssetsStatesByIdList
     */
    public List getOaAssetsStatesByIdList(final Map idList);

    /**
     * Gets oaAssetsState's information based on id.
     * @param id the oaAssetsState's id
     * @return oaAssetsState populated oaAssetsState object
     */
    public OaAssetsState getOaAssetsState(final String id);

    /**
     * Saves a oaAssetsState's information
     * @param oaAssetsState the object to be saved
     */
    public String saveOaAssetsState(OaAssetsState oaAssetsState);

    /**
     * Removes a oaAssetsState from the database by id
     * @param id the oaAssetsState's id
     */
    public void removeOaAssetsState(final String id);
     /**
     * Removes a oaAssetsState from the database by id
     * @param idList
     */
    public void removeOaAssetsStates(final Map idList);
}

