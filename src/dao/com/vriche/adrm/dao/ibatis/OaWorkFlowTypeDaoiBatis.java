
package com.vriche.adrm.dao.ibatis;

//import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaWorkFlowTypeDao;
import com.vriche.adrm.model.OaWorkFlowType;

public class OaWorkFlowTypeDaoiBatis extends BaseDaoiBATIS implements OaWorkFlowTypeDao {
	
//	StringBuffer sbWorkFlowTypeItem = new StringBuffer("");

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#getOaWorkFlowTypes(com.vriche.adrm.model.OaWorkFlowType)
     */
    public List getOaWorkFlowTypes(final OaWorkFlowType oaWorkFlowType) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowTypes", oaWorkFlowType);
    }
	/**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#getOaWorkFlowTypesCount(com.vriche.adrm.model.OaWorkFlowType)
     */
    public Integer getOaWorkFlowTypesCount(final OaWorkFlowType oaWorkFlowType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaWorkFlowTypesCount", oaWorkFlowType);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#getOaWorkFlowTypesPage(com.vriche.adrm.model.OaWorkFlowType)
     */   
  	public PaginatedList getOaWorkFlowTypesPage(final OaWorkFlowType oaWorkFlowType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaWorkFlowTypes",oaWorkFlowType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#getOaWorkFlowTypesByIdList(com.vriche.adrm.model.OaWorkFlowType)
     */
    public List getOaWorkFlowTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#getOaWorkFlowType(Long id)
     */
    public OaWorkFlowType getOaWorkFlowType(Long id) {
        OaWorkFlowType oaWorkFlowType = (OaWorkFlowType) getSqlMapClientTemplate().queryForObject("getOaWorkFlowType", id);

        if (oaWorkFlowType == null) {
            throw new ObjectRetrievalFailureException(OaWorkFlowType.class, id);
        }

        return oaWorkFlowType;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#saveOaWorkFlowType(OaWorkFlowType oaWorkFlowType)
     */    
    public Long saveOaWorkFlowType(final OaWorkFlowType oaWorkFlowType) {
        Long id = oaWorkFlowType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaWorkFlowType", oaWorkFlowType);
        } else {
            getSqlMapClientTemplate().update("updateOaWorkFlowType", oaWorkFlowType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaWorkFlowType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDao#removeOaWorkFlowType(Long id)
     */
    public void removeOaWorkFlowType(Long id) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowType", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowTypeDAO#removeOaWorkFlowTypes(String ids)
     */
    public void removeOaWorkFlowTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowTypes", idList);
    }    
}
