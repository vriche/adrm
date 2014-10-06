
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaWorkFlowType;

public interface OaWorkFlowTypeDao extends Dao {

    /**
     * Retrieves all of the oaWorkFlowTypes
     */
    public List getOaWorkFlowTypes(OaWorkFlowType oaWorkFlowType);
    
    /**
     * Retrieves all of the getOaWorkFlowTypesXml
     */
    /**
     * Retrieves all of the getOaWorkFlowTypesCount
     */
    public Integer getOaWorkFlowTypesCount(OaWorkFlowType oaWorkFlowType);   
    /**
     * Retrieves all of the getOaWorkFlowTypesPage
     */        
    public PaginatedList getOaWorkFlowTypesPage(OaWorkFlowType oaWorkFlowType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaWorkFlowTypesByIdList
     */
    public List getOaWorkFlowTypesByIdList(final Map idList);

    /**
     * Gets oaWorkFlowType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaWorkFlowType's id
     * @return oaWorkFlowType populated oaWorkFlowType object
     */
    public OaWorkFlowType getOaWorkFlowType(final Long id);

    /**
     * Saves a oaWorkFlowType's information
     * @param oaWorkFlowType the object to be saved
     */    
    public Long saveOaWorkFlowType(OaWorkFlowType oaWorkFlowType);

    /**
     * Removes a oaWorkFlowType from the database by id
     * @param id the oaWorkFlowType's id
     */
    public void removeOaWorkFlowType(final Long id);
	/**
     * Removes oaWorkFlowTypes from the database by ids
     * @param ids the oaWorkFlowType's id eg:"'1','2','3'"
     */
    public void removeOaWorkFlowTypes(final Map idList);
}

