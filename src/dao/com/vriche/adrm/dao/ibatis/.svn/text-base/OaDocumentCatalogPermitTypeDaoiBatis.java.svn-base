
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaDocumentCatalogPermitType;
import com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentCatalogPermitTypeDaoiBatis extends BaseDaoiBATIS implements OaDocumentCatalogPermitTypeDao {

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao#getOaDocumentCatalogPermitTypes(com.vriche.adrm.model.OaDocumentCatalogPermitType)
     */
    public List getOaDocumentCatalogPermitTypes(final OaDocumentCatalogPermitType oaDocumentCatalogPermitType) {
          return getSqlMapClientTemplate().queryForList("getOaDocumentCatalogPermitTypes", oaDocumentCatalogPermitType);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao#getOaDocumentCatalogPermitTypesCount(com.vriche.adrm.model.OaDocumentCatalogPermitType)
     */
    public Integer getOaDocumentCatalogPermitTypesCount(final OaDocumentCatalogPermitType oaDocumentCatalogPermitType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaDocumentCatalogPermitTypesCount", oaDocumentCatalogPermitType);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao#getOaDocumentCatalogPermitTypesPage(com.vriche.adrm.model.OaDocumentCatalogPermitType)
     */   
  	public PaginatedList getOaDocumentCatalogPermitTypesPage(final OaDocumentCatalogPermitType oaDocumentCatalogPermitType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaDocumentCatalogPermitTypes",oaDocumentCatalogPermitType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao#getOaDocumentCatalogPermitTypesByIdList(com.vriche.adrm.model.OaDocumentCatalogPermitType)
     */
    public List getOaDocumentCatalogPermitTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaDocumentCatalogPermitTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao#getOaDocumentCatalogPermitType(Long id)
     */
    public OaDocumentCatalogPermitType getOaDocumentCatalogPermitType(Long id) {
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = (OaDocumentCatalogPermitType) getSqlMapClientTemplate().queryForObject("getOaDocumentCatalogPermitType", id);

        if (oaDocumentCatalogPermitType == null) {
            throw new ObjectRetrievalFailureException(OaDocumentCatalogPermitType.class, id);
        }

        return oaDocumentCatalogPermitType;
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao#saveOaDocumentCatalogPermitType(OaDocumentCatalogPermitType oaDocumentCatalogPermitType)
     */    
    public Long saveOaDocumentCatalogPermitType(final OaDocumentCatalogPermitType oaDocumentCatalogPermitType) {
        Long id = oaDocumentCatalogPermitType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaDocumentCatalogPermitType", oaDocumentCatalogPermitType);
        } else {
            getSqlMapClientTemplate().update("updateOaDocumentCatalogPermitType", oaDocumentCatalogPermitType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaDocumentCatalogPermitType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao#removeOaDocumentCatalogPermitType(Long id)
     */
    public void removeOaDocumentCatalogPermitType(Long id) {
        getSqlMapClientTemplate().update("deleteOaDocumentCatalogPermitType", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDAO#removeOaDocumentCatalogPermitTypes(String ids)
     */
    public void removeOaDocumentCatalogPermitTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaDocumentCatalogPermitTypes", idList);
    }    
}
