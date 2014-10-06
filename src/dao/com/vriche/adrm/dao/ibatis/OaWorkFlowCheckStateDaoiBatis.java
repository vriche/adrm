
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.dao.OaWorkFlowCheckStateDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckStateDaoiBatis extends BaseDaoiBATIS implements OaWorkFlowCheckStateDao {

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDao#getOaWorkFlowCheckStates(com.vriche.adrm.model.OaWorkFlowCheckState)
     */
    public List getOaWorkFlowCheckStates(final OaWorkFlowCheckState oaWorkFlowCheckState) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowCheckStates", oaWorkFlowCheckState);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDao#getOaWorkFlowCheckStatesCount(com.vriche.adrm.model.OaWorkFlowCheckState)
     */
    public Integer getOaWorkFlowCheckStatesCount(final OaWorkFlowCheckState oaWorkFlowCheckState) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaWorkFlowCheckStatesCount", oaWorkFlowCheckState);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDao#getOaWorkFlowCheckStatesPage(com.vriche.adrm.model.OaWorkFlowCheckState)
     */   
  	public PaginatedList getOaWorkFlowCheckStatesPage(final OaWorkFlowCheckState oaWorkFlowCheckState,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaWorkFlowCheckStates",oaWorkFlowCheckState,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDao#getOaWorkFlowCheckStatesByIdList(com.vriche.adrm.model.OaWorkFlowCheckState)
     */
    public List getOaWorkFlowCheckStatesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowCheckStatesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDao#getOaWorkFlowCheckState(Long id)
     */
    public OaWorkFlowCheckState getOaWorkFlowCheckState(Long id) {
        OaWorkFlowCheckState oaWorkFlowCheckState = (OaWorkFlowCheckState) getSqlMapClientTemplate().queryForObject("getOaWorkFlowCheckState", id);

        if (oaWorkFlowCheckState == null) {
            throw new ObjectRetrievalFailureException(OaWorkFlowCheckState.class, id);
        }

        return oaWorkFlowCheckState;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDao#saveOaWorkFlowCheckState(OaWorkFlowCheckState oaWorkFlowCheckState)
     */    
    public Long saveOaWorkFlowCheckState(final OaWorkFlowCheckState oaWorkFlowCheckState) {
        Long id = oaWorkFlowCheckState.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaWorkFlowCheckState", oaWorkFlowCheckState);
        } else {
            getSqlMapClientTemplate().update("updateOaWorkFlowCheckState", oaWorkFlowCheckState);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaWorkFlowCheckState.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDao#removeOaWorkFlowCheckState(Long id)
     */
    public void removeOaWorkFlowCheckState(Long id) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowCheckState", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckStateDAO#removeOaWorkFlowCheckStates(String ids)
     */
    public void removeOaWorkFlowCheckStates(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowCheckStates", idList);
    }    
}
