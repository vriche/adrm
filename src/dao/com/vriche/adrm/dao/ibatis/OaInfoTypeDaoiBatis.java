
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaInfoType;
import com.vriche.adrm.dao.OaInfoTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaInfoTypeDaoiBatis extends BaseDaoiBATIS implements OaInfoTypeDao {

    /**
     * @see com.vriche.adrm.dao.OaInfoTypeDao#getOaInfoTypes(com.vriche.adrm.model.OaInfoType)
     */
    public List getOaInfoTypes(final OaInfoType oaInfoType) {
          return getSqlMapClientTemplate().queryForList("getOaInfoTypes", oaInfoType);
    }
     /**
     * @see com.vriche.adrm.dao.OaInfoTypeDao#getOaInfoTypesCount(com.vriche.adrm.model.OaInfoType)
     */
    public Integer getOaInfoTypesCount(final OaInfoType oaInfoType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaInfoTypesCount", oaInfoType);
    }
     /**
     * @see com.vriche.adrm.dao.OaInfoTypeDao#getOaInfoTypesPage(com.vriche.adrm.model.OaInfoType)
     */   
  	public PaginatedList getOaInfoTypesPage(final OaInfoType oaInfoType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaInfoTypes",oaInfoType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaInfoTypeDao#getOaInfoTypesByIdList(com.vriche.adrm.model.OaInfoType)
     */
    public List getOaInfoTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaInfoTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaInfoTypeDao#getOaInfoType(Long id)
     */
    public OaInfoType getOaInfoType(Long id) {
        OaInfoType oaInfoType = (OaInfoType) getSqlMapClientTemplate().queryForObject("getOaInfoType", id);

        if (oaInfoType == null) {
            throw new ObjectRetrievalFailureException(OaInfoType.class, id);
        }

        return oaInfoType;
    }

    /**
     * @see com.vriche.adrm.dao.OaInfoTypeDao#saveOaInfoType(OaInfoType oaInfoType)
     */    
    public Long saveOaInfoType(final OaInfoType oaInfoType) {
        Long id = oaInfoType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaInfoType", oaInfoType);
        } else {
            getSqlMapClientTemplate().update("updateOaInfoType", oaInfoType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaInfoType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaInfoTypeDao#removeOaInfoType(Long id)
     */
    public void removeOaInfoType(Long id) {
        getSqlMapClientTemplate().update("deleteOaInfoType", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaInfoTypeDAO#removeOaInfoTypes(String ids)
     */
    public void removeOaInfoTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaInfoTypes", idList);
    }    
}
