
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaDocumentFile;
import com.vriche.adrm.dao.OaDocumentFileDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentFileDaoiBatis extends BaseDaoiBATIS implements OaDocumentFileDao {

    /**
     * @see com.vriche.adrm.dao.OaDocumentFileDao#getOaDocumentFiles(com.vriche.adrm.model.OaDocumentFile)
     */
    public List getOaDocumentFiles(final OaDocumentFile oaDocumentFile) {
          return getSqlMapClientTemplate().queryForList("getOaDocumentFiles", oaDocumentFile);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentFileDao#getOaDocumentFilesCount(com.vriche.adrm.model.OaDocumentFile)
     */
    public Integer getOaDocumentFilesCount(final OaDocumentFile oaDocumentFile) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaDocumentFilesCount", oaDocumentFile);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentFileDao#getOaDocumentFilesPage(com.vriche.adrm.model.OaDocumentFile)
     */   
  	public PaginatedList getOaDocumentFilesPage(final OaDocumentFile oaDocumentFile,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaDocumentFiles",oaDocumentFile,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaDocumentFileDao#getOaDocumentFilesByIdList(com.vriche.adrm.model.OaDocumentFile)
     */
    public List getOaDocumentFilesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaDocumentFilesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentFileDao#getOaDocumentFile(Long id)
     */
    public OaDocumentFile getOaDocumentFile(Long id) {
        OaDocumentFile oaDocumentFile = (OaDocumentFile) getSqlMapClientTemplate().queryForObject("getOaDocumentFile", id);
//        System.out.println("oaDocumentFile========="+oaDocumentFile.toString());
        if (oaDocumentFile == null) {
            throw new ObjectRetrievalFailureException(OaDocumentFile.class, id);
        }

        return oaDocumentFile;
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentFileDao#saveOaDocumentFile(OaDocumentFile oaDocumentFile)
     */    
    public Long saveOaDocumentFile(final OaDocumentFile oaDocumentFile) {
        Long id = oaDocumentFile.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaDocumentFile", oaDocumentFile);
        } else {
            getSqlMapClientTemplate().update("updateOaDocumentFile", oaDocumentFile);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaDocumentFile.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentFileDao#removeOaDocumentFile(Long id)
     */
    public void removeOaDocumentFile(Long id) {
        getSqlMapClientTemplate().update("deleteOaDocumentFile", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaDocumentFileDAO#removeOaDocumentFiles(String ids)
     */
    public void removeOaDocumentFiles(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaDocumentFiles", idList);
    }
	public void removeOaDocumentFilesByDocumentId(final Map idList) {
		getSqlMapClientTemplate().update("deleteOaDocumentFilesByDocumentId", idList);
	}    
}
