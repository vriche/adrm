
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaWorkFlow;
import com.vriche.adrm.dao.OaWorkFlowDao;

public interface OaWorkFlowManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaWorkFlowDao(OaWorkFlowDao oaWorkFlowDAO);

    /**
     * Retrieves all of the oaWorkFlows
     */
    public List getOaWorkFlows(OaWorkFlow oaWorkFlow);
    
    
    public Map getOaWorkFlowsMap(OaWorkFlow oaWorkFlow);
     /**
     * Retrieves all of the oaWorkFlowsCount
     */
    public String getOaWorkFlowsCount(OaWorkFlow oaWorkFlow);
    
    
    public String getOaWorkFlowsView(OaWorkFlow oaWorkFlow);
    
     /**
     * Retrieves all of the oaWorkFlowsCount
     */    
    public PaginatedList getOaWorkFlowsPage(OaWorkFlow oaWorkFlow,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaWorkFlowsByIdList
     */
    public List getOaWorkFlowsByIdList(final Map idList);

    /**
     * Gets oaWorkFlow's information based on id.
     * @param id the oaWorkFlow's id
     * @return oaWorkFlow populated oaWorkFlow object
     */
    public OaWorkFlow getOaWorkFlow(final String id);

    /**
     * Saves a oaWorkFlow's information
     * @param oaWorkFlow the object to be saved
     */
    public String saveOaWorkFlow(OaWorkFlow oaWorkFlow);

    /**
     * Removes a oaWorkFlow from the database by id
     * @param id the oaWorkFlow's id
     */
    public void removeOaWorkFlow(final String id);
     /**
     * Removes a oaWorkFlow from the database by id
     * @param idList
     */
    public void removeOaWorkFlows(final Map idList);
    
    
    public Map getOaWorkFlowIds(String id);
    
    public void saveCominUsers(final OaWorkFlow oaWorkFlow, String id);
    
    public void saveCheckUsers(final OaWorkFlow oaWorkFlow, String id);
    
    public void removeIncomeUsers(final Map idList);
    
    public void removeCheckUsers(final Map idList);
    
    
//    public List getCheckEventsByType(String workFlowTypeId,String state);
    
//    public List getWorkFlowOwner(String workFlowTypeId, String userId);
    
    public List getWorkFlowOther(List ownerList);
    
    public List getWorkFlowOther(String agreeFlowId, String dissentFlowId);
    
    public void getEventsByWorkFlows(String ownerWorkFlowId,List eventsList,List workFlowList,int state,int type,Long userId,String orderCode,String year,String carrierId,String customerName);
 
    public Map getWorkFlowSelectByUser(String workFlowTypeId,String userId);
    
    public List getWorkFlows(String agreeFlowId,String dissentFlowId);
    
    
    
    public Map getWorkFlowSelects(OaWorkFlow  workFlow);
}

