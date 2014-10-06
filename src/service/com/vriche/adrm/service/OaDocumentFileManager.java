
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaDocumentFile;
import com.vriche.adrm.dao.OaDocumentFileDao;

public interface OaDocumentFileManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaDocumentFileDao(OaDocumentFileDao oaDocumentFileDAO);

    /**
     * Retrieves all of the oaDocumentFiles
     */
    public List getOaDocumentFiles(OaDocumentFile oaDocumentFile);
     /**
     * Retrieves all of the oaDocumentFilesCount
     */
    public String getOaDocumentFilesCount(OaDocumentFile oaDocumentFile);
     /**
     * Retrieves all of the oaDocumentFilesCount
     */    
    public PaginatedList getOaDocumentFilesPage(OaDocumentFile oaDocumentFile,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaDocumentFilesByIdList
     */
    public List getOaDocumentFilesByIdList(final Map idList);
    
    public void getFileIdsByDocumentId(String documentId,List idList);

    /**
     * Gets oaDocumentFile's information based on id.
     * @param id the oaDocumentFile's id
     * @return oaDocumentFile populated oaDocumentFile object
     */
    public OaDocumentFile getOaDocumentFile(final String id);

    /**
     * Saves a oaDocumentFile's information
     * @param oaDocumentFile the object to be saved
     */
    public String saveOaDocumentFile(OaDocumentFile oaDocumentFile);

    /**
     * Removes a oaDocumentFile from the database by id
     * @param id the oaDocumentFile's id
     */
    public void removeOaDocumentFile(final String id);
     /**
     * Removes a oaDocumentFile from the database by id
     * @param idList
     */
    public void removeOaDocumentFiles(final Map idList);
    
    public void removeOaDocumentFilesByDocumentId(final Map idList);
}

