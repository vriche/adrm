
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.dao.OaWorkFlowTypeDao;

public interface OaWorkFlowTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaWorkFlowTypeDao(OaWorkFlowTypeDao oaWorkFlowTypeDAO);

    /**
     * Retrieves all of the oaWorkFlowTypes
     */
    public List getOaWorkFlowTypes(OaWorkFlowType oaWorkFlowType);
    
    
    /**
     * Retrieves all of the getOaWorkFlowTypesXml
     */
    public String getOaWorkFlowTypesXml(OaWorkFlowType oaWorkFlowType,String IdPrefix);  
    
    public void getWorkFlowTypesItemsByParentId(String parentId,StringBuffer sb,String IdPrefix);
    
     /**
     * Retrieves all of the oaWorkFlowTypesCount
     */
    public String getOaWorkFlowTypesCount(OaWorkFlowType oaWorkFlowType);
     /**
     * Retrieves all of the oaWorkFlowTypesCount
     */    
    public PaginatedList getOaWorkFlowTypesPage(OaWorkFlowType oaWorkFlowType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaWorkFlowTypesByIdList
     */
    public List getOaWorkFlowTypesByIdList(final Map idList);

    /**
     * Gets oaWorkFlowType's information based on id.
     * @param id the oaWorkFlowType's id
     * @return oaWorkFlowType populated oaWorkFlowType object
     */
    public OaWorkFlowType getOaWorkFlowType(final String id);

    /**
     * Saves a oaWorkFlowType's information
     * @param oaWorkFlowType the object to be saved
     */
    public String saveOaWorkFlowType(OaWorkFlowType oaWorkFlowType);

    /**
     * Removes a oaWorkFlowType from the database by id
     * @param id the oaWorkFlowType's id
     */
    public void removeOaWorkFlowType(final String id);
     /**
     * Removes a oaWorkFlowType from the database by id
     * @param idList
     */
    public void removeOaWorkFlowTypes(final Map idList);
    
    public Map getWorkFlowTypesSelect(OaWorkFlowType oaWorkFlowType);
}

