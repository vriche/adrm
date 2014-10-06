
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaAssetsType;
import com.vriche.adrm.dao.OaAssetsTypeDao;

public interface OaAssetsTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaAssetsTypeDao(OaAssetsTypeDao oaAssetsTypeDAO);

    /**
     * Retrieves all of the oaAssetsTypes
     */
    public List getOaAssetsTypes(OaAssetsType oaAssetsType);
     /**
     * Retrieves all of the oaAssetsTypesCount
     */
    public String getOaAssetsTypesCount(OaAssetsType oaAssetsType);
     /**
     * Retrieves all of the oaAssetsTypesCount
     */    
    public PaginatedList getOaAssetsTypesPage(OaAssetsType oaAssetsType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaAssetsTypesByIdList
     */
    public List getOaAssetsTypesByIdList(final Map idList);

    /**
     * Gets oaAssetsType's information based on id.
     * @param id the oaAssetsType's id
     * @return oaAssetsType populated oaAssetsType object
     */
    public OaAssetsType getOaAssetsType(final String id);

    /**
     * Saves a oaAssetsType's information
     * @param oaAssetsType the object to be saved
     */
    public String saveOaAssetsType(OaAssetsType oaAssetsType);

    /**
     * Removes a oaAssetsType from the database by id
     * @param id the oaAssetsType's id
     */
    public void removeOaAssetsType(final String id);
     /**
     * Removes a oaAssetsType from the database by id
     * @param idList
     */
    public void removeOaAssetsTypes(final Map idList);
}

