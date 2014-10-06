
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaWorkFlowCheckState;

public interface OaWorkFlowCheckStateDao extends Dao {

    /**
     * Retrieves all of the oaWorkFlowCheckStates
     */
    public List getOaWorkFlowCheckStates(OaWorkFlowCheckState oaWorkFlowCheckState);
    /**
     * Retrieves all of the getOaWorkFlowCheckStatesCount
     */
    public Integer getOaWorkFlowCheckStatesCount(OaWorkFlowCheckState oaWorkFlowCheckState);   
    /**
     * Retrieves all of the getOaWorkFlowCheckStatesPage
     */        
    public PaginatedList getOaWorkFlowCheckStatesPage(OaWorkFlowCheckState oaWorkFlowCheckState,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaWorkFlowCheckStatesByIdList
     */
    public List getOaWorkFlowCheckStatesByIdList(final Map idList);

    /**
     * Gets oaWorkFlowCheckState's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaWorkFlowCheckState's id
     * @return oaWorkFlowCheckState populated oaWorkFlowCheckState object
     */
    public OaWorkFlowCheckState getOaWorkFlowCheckState(final Long id);

    /**
     * Saves a oaWorkFlowCheckState's information
     * @param oaWorkFlowCheckState the object to be saved
     */    
    public Long saveOaWorkFlowCheckState(OaWorkFlowCheckState oaWorkFlowCheckState);

    /**
     * Removes a oaWorkFlowCheckState from the database by id
     * @param id the oaWorkFlowCheckState's id
     */
    public void removeOaWorkFlowCheckState(final Long id);
	/**
     * Removes oaWorkFlowCheckStates from the database by ids
     * @param ids the oaWorkFlowCheckState's id eg:"'1','2','3'"
     */
    public void removeOaWorkFlowCheckStates(final Map idList);
}

