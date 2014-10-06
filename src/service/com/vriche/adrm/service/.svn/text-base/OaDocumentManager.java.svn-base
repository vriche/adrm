
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.dao.OaDocumentDao;

public interface OaDocumentManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaDocumentDao(OaDocumentDao oaDocumentDAO);

    /**
     * Retrieves all of the oaDocuments
     */
    public List getOaDocuments(OaDocument oaDocument);
     /**
     * Retrieves all of the oaDocumentsCount
     */
    public String getOaDocumentsCount(OaDocument oaDocument);
     /**
     * Retrieves all of the oaDocumentsCount
     */    
    public PaginatedList getOaDocumentsPage(OaDocument oaDocument,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaDocumentsByIdList
     */
    public List getOaDocumentsByIdList(final Map idList);
    
    public List getDocumentIdsByCatalogId(String catalogId);
    
    public List getFileIdsByDocumentIds(List documentIds);
    /**
     * Gets oaDocument's information based on id.
     * @param id the oaDocument's id
     * @return oaDocument populated oaDocument object
     */
    public OaDocument getOaDocument(final String id);

    /**
     * Saves a oaDocument's information
     * @param oaDocument the object to be saved
     */
    public String saveOaDocument(OaDocument oaDocument);

    /**
     * Removes a oaDocument from the database by id
     * @param id the oaDocument's id
     */
    public void removeOaDocument(final String id);
     /**
     * Removes a oaDocument from the database by id
     * @param idList
     */
    public void removeOaDocuments(final Map idList);
    
    public void removeOaDocumentsByCatalogId(final Map idList);
    
    public String[] getPermitUsersColByCatalogId(String documentCatalogId,String propertyName);
    
    public String[] getCatalogPermitsColByCatalogId(String documentCatalogId,String propertyName);
    
    public void getOaDocumentsItemsByCatalogId(StringBuffer sb,String documentCatalogId, String oaDocumentIdPrefix);
}

