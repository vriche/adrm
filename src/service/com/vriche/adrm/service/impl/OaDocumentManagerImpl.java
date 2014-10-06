
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaDocumentDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.service.OaDocumentCatalogManager;
import com.vriche.adrm.service.OaDocumentFileManager;
import com.vriche.adrm.service.OaDocumentManager;
import com.vriche.adrm.util.ConvertUtil;

public class OaDocumentManagerImpl extends BaseManager implements OaDocumentManager {
    private OaDocumentDao dao;
    private OaDocumentFileManager oaDocumentFileManager;
    private OaDocumentCatalogManager oaDocumentCatalogManager;
    /** 
	 * @param documentFileManager The documentFileManager to set.
	 */
	public void setOaDocumentFileManager(OaDocumentFileManager documentFileManager) {
		this.oaDocumentFileManager = documentFileManager;
	}
	/**
	 * @param oaDocumentCatalogManager The oaDocumentCatalogManager to set.
	 */
	public void setOaDocumentCatalogManager(OaDocumentCatalogManager oaDocumentCatalogManager) {
		this.oaDocumentCatalogManager = oaDocumentCatalogManager;
	}
	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaDocumentDao(OaDocumentDao dao) {
        this.dao = dao;
    }
    
    
    
   /**
     * @see com.vriche.adrm.service.OaDocumentManager#getOaDocuments(com.vriche.adrm.model.OaDocument)
     */
    public List getOaDocuments(final OaDocument oaDocument) {
        return dao.getOaDocuments(oaDocument);
    }
    
    
    
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentManager#getDocumentIdsByCatalogId(java.lang.String)
	 */
	public List getDocumentIdsByCatalogId(String catalogId) {
		List idList = new ArrayList();
		OaDocument document = new OaDocument();
		document.setDocumentCatalogId(new Long(catalogId));
		Iterator it = this.getOaDocuments(document).iterator();
		while (it.hasNext()) {
			OaDocument doc = (OaDocument) it.next();
			idList.add(doc.getId());
		}
		return idList;
	}
	
	
/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaDocumentManager#getFileIdsByDocumentIds(java.util.List)
	 */
	public List getFileIdsByDocumentIds(List documentIds) {
		List idList = new ArrayList();
		Iterator it = documentIds.iterator();
		
		while (it.hasNext()) {
			OaDocument document = (OaDocument) it.next();
			oaDocumentFileManager.getFileIdsByDocumentId(document.getId().toString(),idList);
		}
		return idList;
	}
/**
     * @see com.vriche.adrm.service.OaDocumentManager#getOaDocumentsCount(com.vriche.adrm.model.OaDocument)
     */
    public String getOaDocumentsCount(final OaDocument oaDocument) {
        return dao.getOaDocumentsCount(oaDocument).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaDocumentManager#getOaDocumentsCount(com.vriche.adrm.model.OaDocument)
     */    
	public PaginatedList getOaDocumentsPage(final OaDocument oaDocument,String pageIndex, String pageSize) {
		return dao.getOaDocumentsPage(oaDocument,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaDocumentManager#getOaDocument(String id)
     */
    public OaDocument getOaDocument(final String id) {
        return dao.getOaDocument(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaDocumentManager#getOaDocumentsByIdList(final Map idList)
     */
    public List getOaDocumentsByIdList(final Map idList) {
        return dao.getOaDocumentsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaDocumentManager#saveOaDocument(OaDocument oaDocument)
     */
    public String saveOaDocument(OaDocument oaDocument) {
        return dao.saveOaDocument(oaDocument).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaDocumentManager#removeOaDocument(String id)
     */
    public void removeOaDocument(final String id) {
    	List fileIdList = new ArrayList();
    	oaDocumentFileManager.getFileIdsByDocumentId(id,fileIdList);
    	Map  fileIds = ConvertUtil.convertListToMap("OaDocumentFileIdList", fileIdList);   
    	
//    	删除文件
    	oaDocumentFileManager.removeOaDocumentFiles(fileIds);
    	
        dao.removeOaDocument(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaDocumentManager#removeOaDocuments(String Map)
     */
    public void removeOaDocuments(final Map idList) {
    	List  documentIdList = ConvertUtil.convertMapToList("OaDocumentIdList",idList);
    	List fileIdList = this.getFileIdsByDocumentIds(documentIdList);
    	Map  fileIds = ConvertUtil.convertListToMap("OaDocumentFileIdList", fileIdList);    	
    	
    	//删除文件
    	oaDocumentFileManager.removeOaDocumentFiles(fileIds);
    	
        dao.removeOaDocuments(idList);
    }
	public String[] getPermitUsersColByCatalogId(String documentCatalogId, String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCatalogPermitsColByCatalogId(String documentCatalogId, String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void getOaDocumentsItemsByCatalogId(StringBuffer sb,String documentCatalogId, String oaDocumentIdPrefix) {
		OaDocument doc = new OaDocument();
		
		doc.setDocumentCatalogId(new Long(documentCatalogId));
		
		List ls = dao.getOaDocuments(doc);
		for(Iterator it = ls.iterator();it.hasNext();){
			OaDocument document = (OaDocument)it.next();
			sb.append("<item id='" + oaDocumentIdPrefix
							+ document.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ document.getTitle().toString() + "\">");
			sb.append("<userdata name=\"type\">2</userdata>");
			sb.append("</item>");
			
		}
		
	}
	public void removeOaDocumentsByCatalogId(Map idList) {
		dao.removeOaDocumentsByCatalogId(idList);
	}

}
