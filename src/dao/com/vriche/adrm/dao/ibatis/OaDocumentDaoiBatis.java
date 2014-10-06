
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.dao.OaDocumentDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentDaoiBatis extends BaseDaoiBATIS implements OaDocumentDao {

    /**
     * @see com.vriche.adrm.dao.OaDocumentDao#getOaDocuments(com.vriche.adrm.model.OaDocument)
     */
    public List getOaDocuments(final OaDocument oaDocument) {
          return getSqlMapClientTemplate().queryForList("getOaDocuments", oaDocument);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentDao#getOaDocumentsCount(com.vriche.adrm.model.OaDocument)
     */
    public Integer getOaDocumentsCount(final OaDocument oaDocument) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaDocumentsCount", oaDocument);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentDao#getOaDocumentsPage(com.vriche.adrm.model.OaDocument)
     */   
  	public PaginatedList getOaDocumentsPage(final OaDocument oaDocument,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaDocuments",oaDocument,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaDocumentDao#getOaDocumentsByIdList(com.vriche.adrm.model.OaDocument)
     */
    public List getOaDocumentsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaDocumentsByIdList", idList);
    }
    

	/**
     * @see com.vriche.adrm.dao.OaDocumentDao#getOaDocument(Long id)
     */
    public OaDocument getOaDocument(Long id) {
        OaDocument oaDocument = (OaDocument) getSqlMapClientTemplate().queryForObject("getOaDocument", id);

        if (oaDocument == null) {
            throw new ObjectRetrievalFailureException(OaDocument.class, id);
        }

        return oaDocument;
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentDao#saveOaDocument(OaDocument oaDocument)
     */    
    public Long saveOaDocument(final OaDocument oaDocument) {
        Long id = oaDocument.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaDocument", oaDocument);
//            System.out.println("id====="+id);
        } else {
            getSqlMapClientTemplate().update("updateOaDocument", oaDocument);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaDocument.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentDao#removeOaDocument(Long id)
     */
    public void removeOaDocument(Long id) {
        getSqlMapClientTemplate().update("deleteOaDocument", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaDocumentDAO#removeOaDocuments(String ids)
     */
    public void removeOaDocuments(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaDocuments", idList);
    }
	public void removeOaDocumentsByCatalogId(final Map idList) {
		getSqlMapClientTemplate().update("deleteOaDocumentsByCatalogId",idList);		
	}    
}
