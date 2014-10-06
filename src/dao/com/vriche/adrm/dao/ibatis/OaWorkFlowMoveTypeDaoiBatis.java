
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaWorkFlowMoveType;
import com.vriche.adrm.dao.OaWorkFlowMoveTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowMoveTypeDaoiBatis extends BaseDaoiBATIS implements OaWorkFlowMoveTypeDao {

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDao#getOaWorkFlowMoveTypes(com.vriche.adrm.model.OaWorkFlowMoveType)
     */
    public List getOaWorkFlowMoveTypes(final OaWorkFlowMoveType oaWorkFlowMoveType) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowMoveTypes", oaWorkFlowMoveType);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDao#getOaWorkFlowMoveTypesCount(com.vriche.adrm.model.OaWorkFlowMoveType)
     */
    public Integer getOaWorkFlowMoveTypesCount(final OaWorkFlowMoveType oaWorkFlowMoveType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaWorkFlowMoveTypesCount", oaWorkFlowMoveType);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDao#getOaWorkFlowMoveTypesPage(com.vriche.adrm.model.OaWorkFlowMoveType)
     */   
  	public PaginatedList getOaWorkFlowMoveTypesPage(final OaWorkFlowMoveType oaWorkFlowMoveType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaWorkFlowMoveTypes",oaWorkFlowMoveType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDao#getOaWorkFlowMoveTypesByIdList(com.vriche.adrm.model.OaWorkFlowMoveType)
     */
    public List getOaWorkFlowMoveTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowMoveTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDao#getOaWorkFlowMoveType(Long id)
     */
    public OaWorkFlowMoveType getOaWorkFlowMoveType(Long id) {
        OaWorkFlowMoveType oaWorkFlowMoveType = (OaWorkFlowMoveType) getSqlMapClientTemplate().queryForObject("getOaWorkFlowMoveType", id);

        if (oaWorkFlowMoveType == null) {
            throw new ObjectRetrievalFailureException(OaWorkFlowMoveType.class, id);
        }

        return oaWorkFlowMoveType;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDao#saveOaWorkFlowMoveType(OaWorkFlowMoveType oaWorkFlowMoveType)
     */    
    public Long saveOaWorkFlowMoveType(final OaWorkFlowMoveType oaWorkFlowMoveType) {
        Long id = oaWorkFlowMoveType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaWorkFlowMoveType", oaWorkFlowMoveType);
        } else {
            getSqlMapClientTemplate().update("updateOaWorkFlowMoveType", oaWorkFlowMoveType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaWorkFlowMoveType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDao#removeOaWorkFlowMoveType(Long id)
     */
    public void removeOaWorkFlowMoveType(Long id) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowMoveType", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowMoveTypeDAO#removeOaWorkFlowMoveTypes(String ids)
     */
    public void removeOaWorkFlowMoveTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowMoveTypes", idList);
    }    
}
