
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaWorkFlowCheckResult;

public interface OaWorkFlowCheckResultDao extends Dao {

    /**
     * Retrieves all of the oaWorkFlowCheckResults
     */
    public List getOaWorkFlowCheckResults(OaWorkFlowCheckResult oaWorkFlowCheckResult);
    /**
     * Retrieves all of the getOaWorkFlowCheckResultsCount
     */
    public Integer getOaWorkFlowCheckResultsCount(OaWorkFlowCheckResult oaWorkFlowCheckResult);   
    /**
     * Retrieves all of the getOaWorkFlowCheckResultsPage
     */        
    public PaginatedList getOaWorkFlowCheckResultsPage(OaWorkFlowCheckResult oaWorkFlowCheckResult,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaWorkFlowCheckResultsByIdList
     */
    public List getOaWorkFlowCheckResultsByIdList(final Map idList);

    /**
     * Gets oaWorkFlowCheckResult's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaWorkFlowCheckResult's id
     * @return oaWorkFlowCheckResult populated oaWorkFlowCheckResult object
     */
    public OaWorkFlowCheckResult getOaWorkFlowCheckResult(final Long id);

    /**
     * Saves a oaWorkFlowCheckResult's information
     * @param oaWorkFlowCheckResult the object to be saved
     */    
    public Long saveOaWorkFlowCheckResult(OaWorkFlowCheckResult oaWorkFlowCheckResult);

    /**
     * Removes a oaWorkFlowCheckResult from the database by id
     * @param id the oaWorkFlowCheckResult's id
     */
    public void removeOaWorkFlowCheckResult(final Long id);
	/**
     * Removes oaWorkFlowCheckResults from the database by ids
     * @param ids the oaWorkFlowCheckResult's id eg:"'1','2','3'"
     */
    public void removeOaWorkFlowCheckResults(final Map idList);
}

