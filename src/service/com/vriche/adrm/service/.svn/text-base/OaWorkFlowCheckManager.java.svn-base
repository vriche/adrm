
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaWorkFlowCheck;
import com.vriche.adrm.dao.OaWorkFlowCheckDao;

public interface OaWorkFlowCheckManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaWorkFlowCheckDao(OaWorkFlowCheckDao oaWorkFlowCheckDAO);

    /**
     * Retrieves all of the oaWorkFlowChecks
     */
    public List getOaWorkFlowChecks(OaWorkFlowCheck oaWorkFlowCheck);
     /**
     * Retrieves all of the oaWorkFlowChecksCount
     */
    public String getOaWorkFlowChecksCount(OaWorkFlowCheck oaWorkFlowCheck);
     /**
     * Retrieves all of the oaWorkFlowChecksCount
     */    
    public PaginatedList getOaWorkFlowChecksPage(OaWorkFlowCheck oaWorkFlowCheck,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaWorkFlowChecksByIdList
     */
    public List getOaWorkFlowChecksByIdList(final Map idList);

    /**
     * Gets oaWorkFlowCheck's information based on id.
     * @param id the oaWorkFlowCheck's id
     * @return oaWorkFlowCheck populated oaWorkFlowCheck object
     */
    public OaWorkFlowCheck getOaWorkFlowCheck(final String id);

    /**
     * Saves a oaWorkFlowCheck's information
     * @param oaWorkFlowCheck the object to be saved
     */
    public String saveOaWorkFlowCheck(OaWorkFlowCheck oaWorkFlowCheck);

    /**
     * Removes a oaWorkFlowCheck from the database by id
     * @param id the oaWorkFlowCheck's id
     */
    public void removeOaWorkFlowCheck(final String id);
     /**
     * Removes a oaWorkFlowCheck from the database by id
     * @param idList
     */
    public void removeOaWorkFlowChecks(final Map idList);
    
    public List getOaWorkFlowChecksByContractId(final String id);
    public List getOaWorkFlowChecksByOrderId(final String id);
}

