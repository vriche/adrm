
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaDocumentCatalogPermitType;

public interface OaDocumentCatalogPermitTypeDao extends Dao {

    /**
     * Retrieves all of the oaDocumentCatalogPermitTypes
     */
    public List getOaDocumentCatalogPermitTypes(OaDocumentCatalogPermitType oaDocumentCatalogPermitType);
    /**
     * Retrieves all of the getOaDocumentCatalogPermitTypesCount
     */
    public Integer getOaDocumentCatalogPermitTypesCount(OaDocumentCatalogPermitType oaDocumentCatalogPermitType);   
    /**
     * Retrieves all of the getOaDocumentCatalogPermitTypesPage
     */        
    public PaginatedList getOaDocumentCatalogPermitTypesPage(OaDocumentCatalogPermitType oaDocumentCatalogPermitType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaDocumentCatalogPermitTypesByIdList
     */
    public List getOaDocumentCatalogPermitTypesByIdList(final Map idList);

    /**
     * Gets oaDocumentCatalogPermitType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaDocumentCatalogPermitType's id
     * @return oaDocumentCatalogPermitType populated oaDocumentCatalogPermitType object
     */
    public OaDocumentCatalogPermitType getOaDocumentCatalogPermitType(final Long id);

    /**
     * Saves a oaDocumentCatalogPermitType's information
     * @param oaDocumentCatalogPermitType the object to be saved
     */    
    public Long saveOaDocumentCatalogPermitType(OaDocumentCatalogPermitType oaDocumentCatalogPermitType);

    /**
     * Removes a oaDocumentCatalogPermitType from the database by id
     * @param id the oaDocumentCatalogPermitType's id
     */
    public void removeOaDocumentCatalogPermitType(final Long id);
	/**
     * Removes oaDocumentCatalogPermitTypes from the database by ids
     * @param ids the oaDocumentCatalogPermitType's id eg:"'1','2','3'"
     */
    public void removeOaDocumentCatalogPermitTypes(final Map idList);
}

