
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaDocumentCatalog;
import com.vriche.adrm.dao.OaDocumentCatalogDao;

public interface OaDocumentCatalogManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaDocumentCatalogDao(OaDocumentCatalogDao oaDocumentCatalogDAO);

    /**
     * Retrieves all of the oaDocumentCatalogs
     */
    public List getOaDocumentCatalogs(OaDocumentCatalog oaDocumentCatalog);
     /**
     * Retrieves all of the oaDocumentCatalogsCount
     */
    public String getOaDocumentCatalogsCount(OaDocumentCatalog oaDocumentCatalog);
    
    
    public String getOaDocumentCatalogsXML(OaDocumentCatalog oaDocumentCatalog, String IdPrefix);
     /**
     * Retrieves all of the oaDocumentCatalogsCount
     */    
    public PaginatedList getOaDocumentCatalogsPage(OaDocumentCatalog oaDocumentCatalog,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaDocumentCatalogsByIdList
     */
    public List getOaDocumentCatalogsByIdList(final Map idList);

    /**
     * Gets oaDocumentCatalog's information based on id.
     * @param id the oaDocumentCatalog's id
     * @return oaDocumentCatalog populated oaDocumentCatalog object
     */
    public OaDocumentCatalog getOaDocumentCatalog(final String id);

    /**
     * Saves a oaDocumentCatalog's information
     * @param oaDocumentCatalog the object to be saved
     */
    public String saveOaDocumentCatalog(OaDocumentCatalog oaDocumentCatalog);

    /**
     * Removes a oaDocumentCatalog from the database by id
     * @param id the oaDocumentCatalog's id
     */
    public void removeOaDocumentCatalog(final String id);
     /**
     * Removes a oaDocumentCatalog from the database by id
     * @param idList
     */
    public void removeOaDocumentCatalogs(final Map idList);
    
    
    public List getOaDocumentCatalogPermitUsers(String id);
    
    public void saveOaDocumentCatalogPermitUsers(final OaDocumentCatalog oaDocumentCatalog, String id);
    
    public void removeOaDocumentCatalogPermitUsers(final Map idList);
    
    
    
    public List getOaDocumentCatalogPermits(String id);
    
    public void saveOaDocumentCatalogPermits(final OaDocumentCatalog oaDocumentCatalog, String id);
    
    public void removeOaDocumentCatalogPermits(final Map idList);
    
    public String getOaDocumentCatalogDocumentXml(final OaDocumentCatalog oaDocumentCatalog,String OaDocumentCatalogIdPrefix,String OaDocumentIdPrefix,String userId);
      
}

