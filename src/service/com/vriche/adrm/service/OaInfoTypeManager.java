
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaInfoType;
import com.vriche.adrm.dao.OaInfoTypeDao;

public interface OaInfoTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaInfoTypeDao(OaInfoTypeDao oaInfoTypeDAO);

    /**
     * Retrieves all of the oaInfoTypes
     */
    public List getOaInfoTypes(OaInfoType oaInfoType);
     /**
     * Retrieves all of the oaInfoTypesCount
     */
    public String getOaInfoTypesCount(OaInfoType oaInfoType);
     /**
     * Retrieves all of the oaInfoTypesCount
     */    
    public PaginatedList getOaInfoTypesPage(OaInfoType oaInfoType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaInfoTypesByIdList
     */
    public List getOaInfoTypesByIdList(final Map idList);

    /**
     * Gets oaInfoType's information based on id.
     * @param id the oaInfoType's id
     * @return oaInfoType populated oaInfoType object
     */
    public OaInfoType getOaInfoType(final String id);

    /**
     * Saves a oaInfoType's information
     * @param oaInfoType the object to be saved
     */
    public String saveOaInfoType(OaInfoType oaInfoType);

    /**
     * Removes a oaInfoType from the database by id
     * @param id the oaInfoType's id
     */
    public void removeOaInfoType(final String id);
     /**
     * Removes a oaInfoType from the database by id
     * @param idList
     */
    public void removeOaInfoTypes(final Map idList);
}

