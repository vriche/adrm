
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.model.OaWorkFlow;

public interface OaDocumentDao extends Dao {

    /**
     * Retrieves all of the oaDocuments
     */
    public List getOaDocuments(OaDocument oaDocument);
    /**
     * Retrieves all of the getOaDocumentsCount
     */
    public Integer getOaDocumentsCount(OaDocument oaDocument);   
    /**
     * Retrieves all of the getOaDocumentsPage
     */        
    public PaginatedList getOaDocumentsPage(OaDocument oaDocument,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaDocumentsByIdList
     */
    public List getOaDocumentsByIdList(final Map idList);
    

    /**
     * Gets oaDocument's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaDocument's id
     * @return oaDocument populated oaDocument object
     */
    public OaDocument getOaDocument(final Long id);

    /**
     * Saves a oaDocument's information
     * @param oaDocument the object to be saved
     */    
    public Long saveOaDocument(OaDocument oaDocument);

    /**
     * Removes a oaDocument from the database by id
     * @param id the oaDocument's id
     */
    public void removeOaDocument(final Long id);
	/**
     * Removes oaDocuments from the database by ids
     * @param ids the oaDocument's id eg:"'1','2','3'"
     */
    public void removeOaDocuments(final Map idList);
    
    public void removeOaDocumentsByCatalogId(final Map idList);

}

