
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.model.User;
import com.vriche.adrm.dao.OaWorkFlowCheckStateDao;

public interface OaWorkFlowCheckStateManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaWorkFlowCheckStateDao(OaWorkFlowCheckStateDao oaWorkFlowCheckStateDAO);

    /**
     * Retrieves all of the oaWorkFlowCheckStates
     */
    public List getOaWorkFlowCheckStates(OaWorkFlowCheckState oaWorkFlowCheckState);
     /**
     * Retrieves all of the oaWorkFlowCheckStatesCount
     */
    public String getOaWorkFlowCheckStatesCount(OaWorkFlowCheckState oaWorkFlowCheckState);
     /**
     * Retrieves all of the oaWorkFlowCheckStatesCount
     */    
    public PaginatedList getOaWorkFlowCheckStatesPage(OaWorkFlowCheckState oaWorkFlowCheckState,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaWorkFlowCheckStatesByIdList
     */
    public List getOaWorkFlowCheckStatesByIdList(final Map idList);

    /**
     * Gets oaWorkFlowCheckState's information based on id.
     * @param id the oaWorkFlowCheckState's id
     * @return oaWorkFlowCheckState populated oaWorkFlowCheckState object
     */
    public OaWorkFlowCheckState getOaWorkFlowCheckState(final String id);

    /**
     * Saves a oaWorkFlowCheckState's information
     * @param oaWorkFlowCheckState the object to be saved
     */
    public String saveOaWorkFlowCheckState(OaWorkFlowCheckState oaWorkFlowCheckState);

    /**
     * Removes a oaWorkFlowCheckState from the database by id
     * @param id the oaWorkFlowCheckState's id
     */
    public void removeOaWorkFlowCheckState(final String id);
     /**
     * Removes a oaWorkFlowCheckState from the database by id
     * @param idList
     */
    public void removeOaWorkFlowCheckStates(final Map idList);
    
    public Map getOaWorkFlowCheckStateSelect(OaWorkFlowCheckState oaWorkFlowCheckState);
    
    public Map getOaWorkFlowCheckStateSelectFromMap();
}

