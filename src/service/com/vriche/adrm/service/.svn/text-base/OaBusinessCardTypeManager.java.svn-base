
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaBusinessCardType;
import com.vriche.adrm.dao.OaBusinessCardTypeDao;

public interface OaBusinessCardTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaBusinessCardTypeDao(OaBusinessCardTypeDao oaBusinessCardTypeDAO);

    /**
     * Retrieves all of the oaBusinessCardTypes
     */
    public List getOaBusinessCardTypes(OaBusinessCardType oaBusinessCardType);
     /**
     * Retrieves all of the oaBusinessCardTypesCount
     */
    public String getOaBusinessCardTypesCount(OaBusinessCardType oaBusinessCardType);
     /**
     * Retrieves all of the oaBusinessCardTypesCount
     */    
    public PaginatedList getOaBusinessCardTypesPage(OaBusinessCardType oaBusinessCardType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaBusinessCardTypesByIdList
     */
    public List getOaBusinessCardTypesByIdList(final Map idList);

    /**
     * Gets oaBusinessCardType's information based on id.
     * @param id the oaBusinessCardType's id
     * @return oaBusinessCardType populated oaBusinessCardType object
     */
    public OaBusinessCardType getOaBusinessCardType(final String id);

    /**
     * Saves a oaBusinessCardType's information
     * @param oaBusinessCardType the object to be saved
     */
    public String saveOaBusinessCardType(OaBusinessCardType oaBusinessCardType);

    /**
     * Removes a oaBusinessCardType from the database by id
     * @param id the oaBusinessCardType's id
     */
    public void removeOaBusinessCardType(final String id);
     /**
     * Removes a oaBusinessCardType from the database by id
     * @param idList
     */
    public void removeOaBusinessCardTypes(final Map idList);
}

