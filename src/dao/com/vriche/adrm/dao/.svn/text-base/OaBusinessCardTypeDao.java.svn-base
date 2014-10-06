
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaBusinessCardType;

public interface OaBusinessCardTypeDao extends Dao {

    /**
     * Retrieves all of the oaBusinessCardTypes
     */
    public List getOaBusinessCardTypes(OaBusinessCardType oaBusinessCardType);
    /**
     * Retrieves all of the getOaBusinessCardTypesCount
     */
    public Integer getOaBusinessCardTypesCount(OaBusinessCardType oaBusinessCardType);   
    /**
     * Retrieves all of the getOaBusinessCardTypesPage
     */        
    public PaginatedList getOaBusinessCardTypesPage(OaBusinessCardType oaBusinessCardType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaBusinessCardTypesByIdList
     */
    public List getOaBusinessCardTypesByIdList(final Map idList);

    /**
     * Gets oaBusinessCardType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaBusinessCardType's id
     * @return oaBusinessCardType populated oaBusinessCardType object
     */
    public OaBusinessCardType getOaBusinessCardType(final Long id);

    /**
     * Saves a oaBusinessCardType's information
     * @param oaBusinessCardType the object to be saved
     */    
    public Long saveOaBusinessCardType(OaBusinessCardType oaBusinessCardType);

    /**
     * Removes a oaBusinessCardType from the database by id
     * @param id the oaBusinessCardType's id
     */
    public void removeOaBusinessCardType(final Long id);
	/**
     * Removes oaBusinessCardTypes from the database by ids
     * @param ids the oaBusinessCardType's id eg:"'1','2','3'"
     */
    public void removeOaBusinessCardTypes(final Map idList);
}

