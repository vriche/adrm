
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.model.OaDocumentCatalog;

public interface OaDocumentCatalogDao extends Dao {

    /**
     * Retrieves all of the oaDocumentCatalogs
     */
    public List getOaDocumentCatalogs(OaDocumentCatalog oaDocumentCatalog);
    /**
     * Retrieves all of the getOaDocumentCatalogsCount
     */
    public Integer getOaDocumentCatalogsCount(OaDocumentCatalog oaDocumentCatalog);   
    /**
     * Retrieves all of the getOaDocumentCatalogsPage
     */        
    public PaginatedList getOaDocumentCatalogsPage(OaDocumentCatalog oaDocumentCatalog,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaDocumentCatalogsByIdList
     */
    public List getOaDocumentCatalogsByIdList(final Map idList);

    /**
     * Gets oaDocumentCatalog's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaDocumentCatalog's id
     * @return oaDocumentCatalog populated oaDocumentCatalog object
     */
    public OaDocumentCatalog getOaDocumentCatalog(final Long id);

    /**
     * Saves a oaDocumentCatalog's information
     * @param oaDocumentCatalog the object to be saved
     */    
    public Long saveOaDocumentCatalog(OaDocumentCatalog oaDocumentCatalog);

    /**
     * Removes a oaDocumentCatalog from the database by id
     * @param id the oaDocumentCatalog's id
     */
    public void removeOaDocumentCatalog(final Long id);
	/**
     * Removes oaDocumentCatalogs from the database by ids
     * @param ids the oaDocumentCatalog's id eg:"'1','2','3'"
     */
    public void removeOaDocumentCatalogs(final Map idList);
    
    
    public List getOaDocumentCatalogPermitUsers(Long id);
    
    public void saveOaDocumentCatalogPermitUsers(final OaDocumentCatalog oaDocumentCatalog, Long id);
    
    public void removeOaDocumentCatalogPermitUsers(final Map idList);
    
    
    
    public List getOaDocumentCatalogPermits(Long id);
    
    public void saveOaDocumentCatalogPermits(final OaDocumentCatalog oaDocumentCatalog, Long id);
    
    public void removeOaDocumentCatalogPermits(final Map idList);
    
    public List getOaDocumentCatalogs(final Map mp);
}

