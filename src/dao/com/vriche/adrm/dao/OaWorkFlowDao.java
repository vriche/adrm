
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaWorkFlow;
import com.vriche.adrm.model.OaWorkFlowType;

public interface OaWorkFlowDao extends Dao {

    /**
     * Retrieves all of the oaWorkFlows
     */
    public List getOaWorkFlows(OaWorkFlow oaWorkFlow);
    
    public List getOaWorkFlowsByUser(final Map mp);
    
    
    public Map getOaWorkFlowsMap(OaWorkFlow oaWorkFlow);
    

    /**
     * Retrieves all of the getOaWorkFlowsCount
     */
    public Integer getOaWorkFlowsCount(OaWorkFlow oaWorkFlow);   
    /**
     * Retrieves all of the getOaWorkFlowsPage
     */        
    public PaginatedList getOaWorkFlowsPage(OaWorkFlow oaWorkFlow,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaWorkFlowsByIdList
     */
    public List getOaWorkFlowsByIdList(final Map idList);

    /**
     * Gets oaWorkFlow's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaWorkFlow's id
     * @return oaWorkFlow populated oaWorkFlow object
     */
    public OaWorkFlow getOaWorkFlow(final Long id);
    
    public OaWorkFlow getOaWorkFlow(final OaWorkFlow oaWorkFlow);

    /**
     * Saves a oaWorkFlow's information
     * @param oaWorkFlow the object to be saved
     */    
    public Long saveOaWorkFlow(OaWorkFlow oaWorkFlow);

    /**
     * Removes a oaWorkFlow from the database by id
     * @param id the oaWorkFlow's id
     */
    public void removeOaWorkFlow(final Long id);
	/**
     * Removes oaWorkFlows from the database by ids
     * @param ids the oaWorkFlow's id eg:"'1','2','3'"
     */
    public void removeOaWorkFlows(final Map idList);
    
    
//    public Map getOaWorkFlowIds(Long id,List idList);
    
    public List getIncomeUsers(Long id);
    
    public void saveCominUsers(final OaWorkFlow oaWorkFlow, Long id);
    
    public void removeIncomeUsers(final Map idList);
    
    public void saveCheckUsers(final OaWorkFlow oaWorkFlow, Long id);
    
    public List getCheckUsers(Long id);
    
    public void removeCheckUsers(final Map idList);
    
    public List getWorkFlowsOther(final OaWorkFlow oaWorkFlow);
    
    public List getWorkFlowsOther(Long agreeWorkFlowId, Long dissentFlowId);
    
}

