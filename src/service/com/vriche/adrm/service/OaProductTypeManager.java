
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaProductType;
import com.vriche.adrm.dao.OaProductTypeDao;

public interface OaProductTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaProductTypeDao(OaProductTypeDao oaProductTypeDAO);

    /**
     * Retrieves all of the oaProductTypes
     */
    public List getOaProductTypes(OaProductType oaProductType);
     /**
     * Retrieves all of the oaProductTypesCount
     */
    public String getOaProductTypesCount(OaProductType oaProductType);
     /**
     * Retrieves all of the oaProductTypesCount
     */    
    public PaginatedList getOaProductTypesPage(OaProductType oaProductType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaProductTypesByIdList
     */
    public List getOaProductTypesByIdList(final Map idList);

    /**
     * Gets oaProductType's information based on id.
     * @param id the oaProductType's id
     * @return oaProductType populated oaProductType object
     */
    public OaProductType getOaProductType(final String id);

    /**
     * Saves a oaProductType's information
     * @param oaProductType the object to be saved
     */
    public String saveOaProductType(OaProductType oaProductType);

    /**
     * Removes a oaProductType from the database by id
     * @param id the oaProductType's id
     */
    public void removeOaProductType(final String id);
     /**
     * Removes a oaProductType from the database by id
     * @param idList
     */
    public void removeOaProductTypes(final Map idList);
}

