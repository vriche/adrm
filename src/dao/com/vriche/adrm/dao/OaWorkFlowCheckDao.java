
package com.vriche.adrm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaWorkFlowCheck;

public interface OaWorkFlowCheckDao extends Dao {

    /**
     * Retrieves all of the oaWorkFlowChecks
     */
    public List getOaWorkFlowChecks(OaWorkFlowCheck oaWorkFlowCheck);
    /**
     * Retrieves all of the getOaWorkFlowChecksCount
     */
    public Integer getOaWorkFlowChecksCount(OaWorkFlowCheck oaWorkFlowCheck);   
    /**
     * Retrieves all of the getOaWorkFlowChecksPage
     */        
    public PaginatedList getOaWorkFlowChecksPage(OaWorkFlowCheck oaWorkFlowCheck,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaWorkFlowChecksByIdList
     */
    public List getOaWorkFlowChecksByIdList(final Map idList);

    /**
     * Gets oaWorkFlowCheck's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaWorkFlowCheck's id
     * @return oaWorkFlowCheck populated oaWorkFlowCheck object
     */
    public OaWorkFlowCheck getOaWorkFlowCheck(final Long id);

    /**
     * Saves a oaWorkFlowCheck's information
     * @param oaWorkFlowCheck the object to be saved
     */    
    public Long saveOaWorkFlowCheck(OaWorkFlowCheck oaWorkFlowCheck);

    /**
     * Removes a oaWorkFlowCheck from the database by id
     * @param id the oaWorkFlowCheck's id
     */
    public void removeOaWorkFlowCheck(final Long id);
	/**
     * Removes oaWorkFlowChecks from the database by ids
     * @param ids the oaWorkFlowCheck's id eg:"'1','2','3'"
     */
    public void removeOaWorkFlowChecks(final Map idList);
    
    public void saveOaWorkFlowCheckContracts(final Map mp);
    
    public void saveOaWorkFlowCheckOrders(final Map mp);
    
    public void saveOaWorkFlowCheckApplys(final Map mp);
    
    public void updateWorkFlowCheckStates(final Map mp);
    
    public void updateContractChecked(final Map mp);
    
    public void updateOrderChecked(final Map mp);
    
    public void updateApplyChecked(final Map mp);
    
    public List getOaWorkFlowChecks(final Long id);
    public List getOaWorkFlowChecksByOrderId(final Long id);
    
    public Object getOrderCheckLastTime(Long id) ;
}

