
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaProductType;
import com.vriche.adrm.dao.OaProductTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductTypeDaoiBatis extends BaseDaoiBATIS implements OaProductTypeDao {

    /**
     * @see com.vriche.adrm.dao.OaProductTypeDao#getOaProductTypes(com.vriche.adrm.model.OaProductType)
     */
    public List getOaProductTypes(final OaProductType oaProductType) {
          return getSqlMapClientTemplate().queryForList("getOaProductTypes", oaProductType);
    }
     /**
     * @see com.vriche.adrm.dao.OaProductTypeDao#getOaProductTypesCount(com.vriche.adrm.model.OaProductType)
     */
    public Integer getOaProductTypesCount(final OaProductType oaProductType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaProductTypesCount", oaProductType);
    }
     /**
     * @see com.vriche.adrm.dao.OaProductTypeDao#getOaProductTypesPage(com.vriche.adrm.model.OaProductType)
     */   
  	public PaginatedList getOaProductTypesPage(final OaProductType oaProductType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaProductTypes",oaProductType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaProductTypeDao#getOaProductTypesByIdList(com.vriche.adrm.model.OaProductType)
     */
    public List getOaProductTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaProductTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaProductTypeDao#getOaProductType(Long id)
     */
    public OaProductType getOaProductType(Long id) {
        OaProductType oaProductType = (OaProductType) getSqlMapClientTemplate().queryForObject("getOaProductType", id);

        if (oaProductType == null) {
            throw new ObjectRetrievalFailureException(OaProductType.class, id);
        }

        return oaProductType;
    }

    /**
     * @see com.vriche.adrm.dao.OaProductTypeDao#saveOaProductType(OaProductType oaProductType)
     */    
    public Long saveOaProductType(final OaProductType oaProductType) {
        Long id = oaProductType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaProductType", oaProductType);
        } else {
            getSqlMapClientTemplate().update("updateOaProductType", oaProductType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaProductType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaProductTypeDao#removeOaProductType(Long id)
     */
    public void removeOaProductType(Long id) {
        getSqlMapClientTemplate().update("deleteOaProductType", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaProductTypeDAO#removeOaProductTypes(String ids)
     */
    public void removeOaProductTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaProductTypes", idList);
    }    
}
