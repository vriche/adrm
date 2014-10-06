
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaDocumentCatalogPermitType;
import com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao;

public interface OaDocumentCatalogPermitTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaDocumentCatalogPermitTypeDao(OaDocumentCatalogPermitTypeDao oaDocumentCatalogPermitTypeDAO);

    /**
     * Retrieves all of the oaDocumentCatalogPermitTypes
     */
    public List getOaDocumentCatalogPermitTypes(OaDocumentCatalogPermitType oaDocumentCatalogPermitType);
     /**
     * Retrieves all of the oaDocumentCatalogPermitTypesCount
     */
    public String getOaDocumentCatalogPermitTypesCount(OaDocumentCatalogPermitType oaDocumentCatalogPermitType);
     /**
     * Retrieves all of the oaDocumentCatalogPermitTypesCount
     */    
    public PaginatedList getOaDocumentCatalogPermitTypesPage(OaDocumentCatalogPermitType oaDocumentCatalogPermitType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaDocumentCatalogPermitTypesByIdList
     */
    public List getOaDocumentCatalogPermitTypesByIdList(final Map idList);

    /**
     * Gets oaDocumentCatalogPermitType's information based on id.
     * @param id the oaDocumentCatalogPermitType's id
     * @return oaDocumentCatalogPermitType populated oaDocumentCatalogPermitType object
     */
    public OaDocumentCatalogPermitType getOaDocumentCatalogPermitType(final String id);

    /**
     * Saves a oaDocumentCatalogPermitType's information
     * @param oaDocumentCatalogPermitType the object to be saved
     */
    public String saveOaDocumentCatalogPermitType(OaDocumentCatalogPermitType oaDocumentCatalogPermitType);

    /**
     * Removes a oaDocumentCatalogPermitType from the database by id
     * @param id the oaDocumentCatalogPermitType's id
     */
    public void removeOaDocumentCatalogPermitType(final String id);
     /**
     * Removes a oaDocumentCatalogPermitType from the database by id
     * @param idList
     */
    public void removeOaDocumentCatalogPermitTypes(final Map idList);
}

