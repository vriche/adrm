
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaWorkFlowMoveType;
import com.vriche.adrm.dao.OaWorkFlowMoveTypeDao;

public interface OaWorkFlowMoveTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaWorkFlowMoveTypeDao(OaWorkFlowMoveTypeDao oaWorkFlowMoveTypeDAO);

    /**
     * Retrieves all of the oaWorkFlowMoveTypes
     */
    public List getOaWorkFlowMoveTypes(OaWorkFlowMoveType oaWorkFlowMoveType);
     /**
     * Retrieves all of the oaWorkFlowMoveTypesCount
     */
    public String getOaWorkFlowMoveTypesCount(OaWorkFlowMoveType oaWorkFlowMoveType);
     /**
     * Retrieves all of the oaWorkFlowMoveTypesCount
     */    
    public PaginatedList getOaWorkFlowMoveTypesPage(OaWorkFlowMoveType oaWorkFlowMoveType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaWorkFlowMoveTypesByIdList
     */
    public List getOaWorkFlowMoveTypesByIdList(final Map idList);

    /**
     * Gets oaWorkFlowMoveType's information based on id.
     * @param id the oaWorkFlowMoveType's id
     * @return oaWorkFlowMoveType populated oaWorkFlowMoveType object
     */
    public OaWorkFlowMoveType getOaWorkFlowMoveType(final String id);

    /**
     * Saves a oaWorkFlowMoveType's information
     * @param oaWorkFlowMoveType the object to be saved
     */
    public String saveOaWorkFlowMoveType(OaWorkFlowMoveType oaWorkFlowMoveType);

    /**
     * Removes a oaWorkFlowMoveType from the database by id
     * @param id the oaWorkFlowMoveType's id
     */
    public void removeOaWorkFlowMoveType(final String id);
     /**
     * Removes a oaWorkFlowMoveType from the database by id
     * @param idList
     */
    public void removeOaWorkFlowMoveTypes(final Map idList);
}

