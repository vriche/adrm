
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaWorkFlowCheckResult;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.dao.OaWorkFlowCheckResultDao;

public interface OaWorkFlowCheckResultManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaWorkFlowCheckResultDao(OaWorkFlowCheckResultDao oaWorkFlowCheckResultDAO);

    /**
     * Retrieves all of the oaWorkFlowCheckResults
     */
    public List getOaWorkFlowCheckResults(OaWorkFlowCheckResult oaWorkFlowCheckResult);
     /**
     * Retrieves all of the oaWorkFlowCheckResultsCount
     */
    public String getOaWorkFlowCheckResultsCount(OaWorkFlowCheckResult oaWorkFlowCheckResult);
     /**
     * Retrieves all of the oaWorkFlowCheckResultsCount
     */    
    public PaginatedList getOaWorkFlowCheckResultsPage(OaWorkFlowCheckResult oaWorkFlowCheckResult,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaWorkFlowCheckResultsByIdList
     */
    public List getOaWorkFlowCheckResultsByIdList(final Map idList);

    /**
     * Gets oaWorkFlowCheckResult's information based on id.
     * @param id the oaWorkFlowCheckResult's id
     * @return oaWorkFlowCheckResult populated oaWorkFlowCheckResult object
     */
    public OaWorkFlowCheckResult getOaWorkFlowCheckResult(final String id);

    /**
     * Saves a oaWorkFlowCheckResult's information
     * @param oaWorkFlowCheckResult the object to be saved
     */
    public String saveOaWorkFlowCheckResult(OaWorkFlowCheckResult oaWorkFlowCheckResult);

    /**
     * Removes a oaWorkFlowCheckResult from the database by id
     * @param id the oaWorkFlowCheckResult's id
     */
    public void removeOaWorkFlowCheckResult(final String id);
     /**
     * Removes a oaWorkFlowCheckResult from the database by id
     * @param idList
     */
    public void removeOaWorkFlowCheckResults(final Map idList);
    
    public Map getWorkFlowCheckResultsSelect(OaWorkFlowCheckResult oaWorkFlowCheckResult);
}

