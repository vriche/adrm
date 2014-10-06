
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaDocumentFile;

public interface OaDocumentFileDao extends Dao {

    /**
     * Retrieves all of the oaDocumentFiles
     */
    public List getOaDocumentFiles(OaDocumentFile oaDocumentFile);
    /**
     * Retrieves all of the getOaDocumentFilesCount
     */
    public Integer getOaDocumentFilesCount(OaDocumentFile oaDocumentFile);   
    /**
     * Retrieves all of the getOaDocumentFilesPage
     */        
    public PaginatedList getOaDocumentFilesPage(OaDocumentFile oaDocumentFile,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaDocumentFilesByIdList
     */
    public List getOaDocumentFilesByIdList(final Map idList);

    /**
     * Gets oaDocumentFile's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaDocumentFile's id
     * @return oaDocumentFile populated oaDocumentFile object
     */
    public OaDocumentFile getOaDocumentFile(final Long id);

    /**
     * Saves a oaDocumentFile's information
     * @param oaDocumentFile the object to be saved
     */    
    public Long saveOaDocumentFile(OaDocumentFile oaDocumentFile);

    /**
     * Removes a oaDocumentFile from the database by id
     * @param id the oaDocumentFile's id
     */
    public void removeOaDocumentFile(final Long id);
	/**
     * Removes oaDocumentFiles from the database by ids
     * @param ids the oaDocumentFile's id eg:"'1','2','3'"
     */
    public void removeOaDocumentFiles(final Map idList);
    
    public void removeOaDocumentFilesByDocumentId(final Map idList);
}

