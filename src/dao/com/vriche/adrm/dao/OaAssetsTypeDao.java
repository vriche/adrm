
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaAssetsType;

public interface OaAssetsTypeDao extends Dao {

    /**
     * Retrieves all of the oaAssetsTypes
     */
    public List getOaAssetsTypes(OaAssetsType oaAssetsType);
    /**
     * Retrieves all of the getOaAssetsTypesCount
     */
    public Integer getOaAssetsTypesCount(OaAssetsType oaAssetsType);   
    /**
     * Retrieves all of the getOaAssetsTypesPage
     */        
    public PaginatedList getOaAssetsTypesPage(OaAssetsType oaAssetsType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaAssetsTypesByIdList
     */
    public List getOaAssetsTypesByIdList(final Map idList);

    /**
     * Gets oaAssetsType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaAssetsType's id
     * @return oaAssetsType populated oaAssetsType object
     */
    public OaAssetsType getOaAssetsType(final Long id);

    /**
     * Saves a oaAssetsType's information
     * @param oaAssetsType the object to be saved
     */    
    public Long saveOaAssetsType(OaAssetsType oaAssetsType);

    /**
     * Removes a oaAssetsType from the database by id
     * @param id the oaAssetsType's id
     */
    public void removeOaAssetsType(final Long id);
	/**
     * Removes oaAssetsTypes from the database by ids
     * @param ids the oaAssetsType's id eg:"'1','2','3'"
     */
    public void removeOaAssetsTypes(final Map idList);
}

