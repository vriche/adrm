
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaDocumentFile;
import com.vriche.adrm.dao.OaDocumentFileDao;
import com.vriche.adrm.service.OaDocumentFileManager;

public class OaDocumentFileManagerImpl extends BaseManager implements OaDocumentFileManager {
    private OaDocumentFileDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaDocumentFileDao(OaDocumentFileDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaDocumentFileManager#getOaDocumentFiles(com.vriche.adrm.model.OaDocumentFile)
     */
    public List getOaDocumentFiles(final OaDocumentFile oaDocumentFile) {
        return dao.getOaDocumentFiles(oaDocumentFile);
    }
   /**
     * @see com.vriche.adrm.service.OaDocumentFileManager#getOaDocumentFilesCount(com.vriche.adrm.model.OaDocumentFile)
     */
    public String getOaDocumentFilesCount(final OaDocumentFile oaDocumentFile) {
        return dao.getOaDocumentFilesCount(oaDocumentFile).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaDocumentFileManager#getOaDocumentFilesCount(com.vriche.adrm.model.OaDocumentFile)
     */    
	public PaginatedList getOaDocumentFilesPage(final OaDocumentFile oaDocumentFile,String pageIndex, String pageSize) {
		return dao.getOaDocumentFilesPage(oaDocumentFile,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaDocumentFileManager#getOaDocumentFile(String id)
     */
    public OaDocumentFile getOaDocumentFile(final String id) {
        return dao.getOaDocumentFile(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaDocumentFileManager#getOaDocumentFilesByIdList(final Map idList)
     */
    public List getOaDocumentFilesByIdList(final Map idList) {
        return dao.getOaDocumentFilesByIdList(idList);
    }   
    

    /* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentFileManager#getFileIdsByDocumentId(java.lang.String, java.util.List)
	 */
	public void getFileIdsByDocumentId(String documentId, List idList) {
		OaDocumentFile documentFile = new OaDocumentFile();
		documentFile.setDocumentId(new Long(documentId));
		Iterator it = this.getOaDocumentFiles(documentFile).iterator();
		while (it.hasNext()) {
			OaDocumentFile file = (OaDocumentFile) it.next();
			idList.add(file.getId());
		}
//		return idList;
	}
	/**
     * @see com.vriche.adrm.service.OaDocumentFileManager#saveOaDocumentFile(OaDocumentFile oaDocumentFile)
     */
    public String saveOaDocumentFile(OaDocumentFile oaDocumentFile) {
        return dao.saveOaDocumentFile(oaDocumentFile).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaDocumentFileManager#removeOaDocumentFile(String id)
     */
    public void removeOaDocumentFile(final String id) {
    	
        dao.removeOaDocumentFile(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaDocumentFileManager#removeOaDocumentFiles(String Map)
     */
    public void removeOaDocumentFiles(final Map idList) {
        dao.removeOaDocumentFiles(idList);
    }
	public void removeOaDocumentFilesByDocumentId(Map idList) {
		dao.removeOaDocumentFilesByDocumentId(idList);
	}    
}
