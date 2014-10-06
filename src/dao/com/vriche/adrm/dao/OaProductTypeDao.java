
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaProductType;

public interface OaProductTypeDao extends Dao {

    /**
     * Retrieves all of the oaProductTypes
     */
    public List getOaProductTypes(OaProductType oaProductType);
    /**
     * Retrieves all of the getOaProductTypesCount
     */
    public Integer getOaProductTypesCount(OaProductType oaProductType);   
    /**
     * Retrieves all of the getOaProductTypesPage
     */        
    public PaginatedList getOaProductTypesPage(OaProductType oaProductType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaProductTypesByIdList
     */
    public List getOaProductTypesByIdList(final Map idList);

    /**
     * Gets oaProductType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaProductType's id
     * @return oaProductType populated oaProductType object
     */
    public OaProductType getOaProductType(final Long id);

    /**
     * Saves a oaProductType's information
     * @param oaProductType the object to be saved
     */    
    public Long saveOaProductType(OaProductType oaProductType);

    /**
     * Removes a oaProductType from the database by id
     * @param id the oaProductType's id
     */
    public void removeOaProductType(final Long id);
	/**
     * Removes oaProductTypes from the database by ids
     * @param ids the oaProductType's id eg:"'1','2','3'"
     */
    public void removeOaProductTypes(final Map idList);
}

