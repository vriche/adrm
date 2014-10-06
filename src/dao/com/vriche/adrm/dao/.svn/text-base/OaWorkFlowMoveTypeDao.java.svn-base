
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaWorkFlowMoveType;

public interface OaWorkFlowMoveTypeDao extends Dao {

    /**
     * Retrieves all of the oaWorkFlowMoveTypes
     */
    public List getOaWorkFlowMoveTypes(OaWorkFlowMoveType oaWorkFlowMoveType);
    /**
     * Retrieves all of the getOaWorkFlowMoveTypesCount
     */
    public Integer getOaWorkFlowMoveTypesCount(OaWorkFlowMoveType oaWorkFlowMoveType);   
    /**
     * Retrieves all of the getOaWorkFlowMoveTypesPage
     */        
    public PaginatedList getOaWorkFlowMoveTypesPage(OaWorkFlowMoveType oaWorkFlowMoveType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaWorkFlowMoveTypesByIdList
     */
    public List getOaWorkFlowMoveTypesByIdList(final Map idList);

    /**
     * Gets oaWorkFlowMoveType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaWorkFlowMoveType's id
     * @return oaWorkFlowMoveType populated oaWorkFlowMoveType object
     */
    public OaWorkFlowMoveType getOaWorkFlowMoveType(final Long id);

    /**
     * Saves a oaWorkFlowMoveType's information
     * @param oaWorkFlowMoveType the object to be saved
     */    
    public Long saveOaWorkFlowMoveType(OaWorkFlowMoveType oaWorkFlowMoveType);

    /**
     * Removes a oaWorkFlowMoveType from the database by id
     * @param id the oaWorkFlowMoveType's id
     */
    public void removeOaWorkFlowMoveType(final Long id);
	/**
     * Removes oaWorkFlowMoveTypes from the database by ids
     * @param ids the oaWorkFlowMoveType's id eg:"'1','2','3'"
     */
    public void removeOaWorkFlowMoveTypes(final Map idList);
}

