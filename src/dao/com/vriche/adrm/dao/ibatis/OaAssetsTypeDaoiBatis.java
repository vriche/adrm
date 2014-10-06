
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaAssetsType;
import com.vriche.adrm.dao.OaAssetsTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsTypeDaoiBatis extends BaseDaoiBATIS implements OaAssetsTypeDao {

    /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDao#getOaAssetsTypes(com.vriche.adrm.model.OaAssetsType)
     */
    public List getOaAssetsTypes(final OaAssetsType oaAssetsType) {
          return getSqlMapClientTemplate().queryForList("getOaAssetsTypes", oaAssetsType);
    }
     /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDao#getOaAssetsTypesCount(com.vriche.adrm.model.OaAssetsType)
     */
    public Integer getOaAssetsTypesCount(final OaAssetsType oaAssetsType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaAssetsTypesCount", oaAssetsType);
    }
     /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDao#getOaAssetsTypesPage(com.vriche.adrm.model.OaAssetsType)
     */   
  	public PaginatedList getOaAssetsTypesPage(final OaAssetsType oaAssetsType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaAssetsTypes",oaAssetsType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDao#getOaAssetsTypesByIdList(com.vriche.adrm.model.OaAssetsType)
     */
    public List getOaAssetsTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaAssetsTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDao#getOaAssetsType(Long id)
     */
    public OaAssetsType getOaAssetsType(Long id) {
        OaAssetsType oaAssetsType = (OaAssetsType) getSqlMapClientTemplate().queryForObject("getOaAssetsType", id);

        if (oaAssetsType == null) {
            throw new ObjectRetrievalFailureException(OaAssetsType.class, id);
        }

        return oaAssetsType;
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDao#saveOaAssetsType(OaAssetsType oaAssetsType)
     */    
    public Long saveOaAssetsType(final OaAssetsType oaAssetsType) {
        Long id = oaAssetsType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaAssetsType", oaAssetsType);
        } else {
            getSqlMapClientTemplate().update("updateOaAssetsType", oaAssetsType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaAssetsType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDao#removeOaAssetsType(Long id)
     */
    public void removeOaAssetsType(Long id) {
        getSqlMapClientTemplate().update("deleteOaAssetsType", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaAssetsTypeDAO#removeOaAssetsTypes(String ids)
     */
    public void removeOaAssetsTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaAssetsTypes", idList);
    }    
}
