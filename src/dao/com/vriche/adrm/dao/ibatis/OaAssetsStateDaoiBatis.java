
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaAssetsState;
import com.vriche.adrm.dao.OaAssetsStateDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsStateDaoiBatis extends BaseDaoiBATIS implements OaAssetsStateDao {

    /**
     * @see com.vriche.adrm.dao.OaAssetsStateDao#getOaAssetsStates(com.vriche.adrm.model.OaAssetsState)
     */
    public List getOaAssetsStates(final OaAssetsState oaAssetsState) {
          return getSqlMapClientTemplate().queryForList("getOaAssetsStates", oaAssetsState);
    }
     /**
     * @see com.vriche.adrm.dao.OaAssetsStateDao#getOaAssetsStatesCount(com.vriche.adrm.model.OaAssetsState)
     */
    public Integer getOaAssetsStatesCount(final OaAssetsState oaAssetsState) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaAssetsStatesCount", oaAssetsState);
    }
     /**
     * @see com.vriche.adrm.dao.OaAssetsStateDao#getOaAssetsStatesPage(com.vriche.adrm.model.OaAssetsState)
     */   
  	public PaginatedList getOaAssetsStatesPage(final OaAssetsState oaAssetsState,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaAssetsStates",oaAssetsState,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaAssetsStateDao#getOaAssetsStatesByIdList(com.vriche.adrm.model.OaAssetsState)
     */
    public List getOaAssetsStatesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaAssetsStatesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsStateDao#getOaAssetsState(Long id)
     */
    public OaAssetsState getOaAssetsState(Long id) {
        OaAssetsState oaAssetsState = (OaAssetsState) getSqlMapClientTemplate().queryForObject("getOaAssetsState", id);

        if (oaAssetsState == null) {
            throw new ObjectRetrievalFailureException(OaAssetsState.class, id);
        }

        return oaAssetsState;
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsStateDao#saveOaAssetsState(OaAssetsState oaAssetsState)
     */    
    public Long saveOaAssetsState(final OaAssetsState oaAssetsState) {
        Long id = oaAssetsState.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaAssetsState", oaAssetsState);
        } else {
            getSqlMapClientTemplate().update("updateOaAssetsState", oaAssetsState);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaAssetsState.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsStateDao#removeOaAssetsState(Long id)
     */
    public void removeOaAssetsState(Long id) {
        getSqlMapClientTemplate().update("deleteOaAssetsState", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaAssetsStateDAO#removeOaAssetsStates(String ids)
     */
    public void removeOaAssetsStates(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaAssetsStates", idList);
    }    
}
