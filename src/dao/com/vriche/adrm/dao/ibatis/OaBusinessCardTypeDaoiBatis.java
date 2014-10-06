
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaBusinessCardType;
import com.vriche.adrm.dao.OaBusinessCardTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaBusinessCardTypeDaoiBatis extends BaseDaoiBATIS implements OaBusinessCardTypeDao {

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDao#getOaBusinessCardTypes(com.vriche.adrm.model.OaBusinessCardType)
     */
    public List getOaBusinessCardTypes(final OaBusinessCardType oaBusinessCardType) {
          return getSqlMapClientTemplate().queryForList("getOaBusinessCardTypes", oaBusinessCardType);
    }
     /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDao#getOaBusinessCardTypesCount(com.vriche.adrm.model.OaBusinessCardType)
     */
    public Integer getOaBusinessCardTypesCount(final OaBusinessCardType oaBusinessCardType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaBusinessCardTypesCount", oaBusinessCardType);
    }
     /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDao#getOaBusinessCardTypesPage(com.vriche.adrm.model.OaBusinessCardType)
     */   
  	public PaginatedList getOaBusinessCardTypesPage(final OaBusinessCardType oaBusinessCardType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaBusinessCardTypes",oaBusinessCardType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDao#getOaBusinessCardTypesByIdList(com.vriche.adrm.model.OaBusinessCardType)
     */
    public List getOaBusinessCardTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaBusinessCardTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDao#getOaBusinessCardType(Long id)
     */
    public OaBusinessCardType getOaBusinessCardType(Long id) {
        OaBusinessCardType oaBusinessCardType = (OaBusinessCardType) getSqlMapClientTemplate().queryForObject("getOaBusinessCardType", id);

        if (oaBusinessCardType == null) {
            throw new ObjectRetrievalFailureException(OaBusinessCardType.class, id);
        }

        return oaBusinessCardType;
    }

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDao#saveOaBusinessCardType(OaBusinessCardType oaBusinessCardType)
     */    
    public Long saveOaBusinessCardType(final OaBusinessCardType oaBusinessCardType) {
        Long id = oaBusinessCardType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaBusinessCardType", oaBusinessCardType);
        } else {
            getSqlMapClientTemplate().update("updateOaBusinessCardType", oaBusinessCardType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaBusinessCardType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDao#removeOaBusinessCardType(Long id)
     */
    public void removeOaBusinessCardType(Long id) {
        getSqlMapClientTemplate().update("deleteOaBusinessCardType", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaBusinessCardTypeDAO#removeOaBusinessCardTypes(String ids)
     */
    public void removeOaBusinessCardTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaBusinessCardTypes", idList);
    }    
}
