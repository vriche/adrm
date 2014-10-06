
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaInfoType;

public interface OaInfoTypeDao extends Dao {

    /**
     * Retrieves all of the oaInfoTypes
     */
    public List getOaInfoTypes(OaInfoType oaInfoType);
    /**
     * Retrieves all of the getOaInfoTypesCount
     */
    public Integer getOaInfoTypesCount(OaInfoType oaInfoType);   
    /**
     * Retrieves all of the getOaInfoTypesPage
     */        
    public PaginatedList getOaInfoTypesPage(OaInfoType oaInfoType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaInfoTypesByIdList
     */
    public List getOaInfoTypesByIdList(final Map idList);

    /**
     * Gets oaInfoType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaInfoType's id
     * @return oaInfoType populated oaInfoType object
     */
    public OaInfoType getOaInfoType(final Long id);

    /**
     * Saves a oaInfoType's information
     * @param oaInfoType the object to be saved
     */    
    public Long saveOaInfoType(OaInfoType oaInfoType);

    /**
     * Removes a oaInfoType from the database by id
     * @param id the oaInfoType's id
     */
    public void removeOaInfoType(final Long id);
	/**
     * Removes oaInfoTypes from the database by ids
     * @param ids the oaInfoType's id eg:"'1','2','3'"
     */
    public void removeOaInfoTypes(final Map idList);
}

