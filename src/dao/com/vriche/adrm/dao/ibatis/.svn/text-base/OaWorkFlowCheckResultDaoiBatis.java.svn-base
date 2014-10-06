
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaWorkFlowCheckResult;
import com.vriche.adrm.dao.OaWorkFlowCheckResultDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckResultDaoiBatis extends BaseDaoiBATIS implements OaWorkFlowCheckResultDao {

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDao#getOaWorkFlowCheckResults(com.vriche.adrm.model.OaWorkFlowCheckResult)
     */
    public List getOaWorkFlowCheckResults(final OaWorkFlowCheckResult oaWorkFlowCheckResult) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowCheckResults", oaWorkFlowCheckResult);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDao#getOaWorkFlowCheckResultsCount(com.vriche.adrm.model.OaWorkFlowCheckResult)
     */
    public Integer getOaWorkFlowCheckResultsCount(final OaWorkFlowCheckResult oaWorkFlowCheckResult) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaWorkFlowCheckResultsCount", oaWorkFlowCheckResult);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDao#getOaWorkFlowCheckResultsPage(com.vriche.adrm.model.OaWorkFlowCheckResult)
     */   
  	public PaginatedList getOaWorkFlowCheckResultsPage(final OaWorkFlowCheckResult oaWorkFlowCheckResult,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaWorkFlowCheckResults",oaWorkFlowCheckResult,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDao#getOaWorkFlowCheckResultsByIdList(com.vriche.adrm.model.OaWorkFlowCheckResult)
     */
    public List getOaWorkFlowCheckResultsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowCheckResultsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDao#getOaWorkFlowCheckResult(Long id)
     */
    public OaWorkFlowCheckResult getOaWorkFlowCheckResult(Long id) {
        OaWorkFlowCheckResult oaWorkFlowCheckResult = (OaWorkFlowCheckResult) getSqlMapClientTemplate().queryForObject("getOaWorkFlowCheckResult", id);

        if (oaWorkFlowCheckResult == null) {
            throw new ObjectRetrievalFailureException(OaWorkFlowCheckResult.class, id);
        }

        return oaWorkFlowCheckResult;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDao#saveOaWorkFlowCheckResult(OaWorkFlowCheckResult oaWorkFlowCheckResult)
     */    
    public Long saveOaWorkFlowCheckResult(final OaWorkFlowCheckResult oaWorkFlowCheckResult) {
        Long id = oaWorkFlowCheckResult.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaWorkFlowCheckResult", oaWorkFlowCheckResult);
        } else {
            getSqlMapClientTemplate().update("updateOaWorkFlowCheckResult", oaWorkFlowCheckResult);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaWorkFlowCheckResult.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDao#removeOaWorkFlowCheckResult(Long id)
     */
    public void removeOaWorkFlowCheckResult(Long id) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowCheckResult", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckResultDAO#removeOaWorkFlowCheckResults(String ids)
     */
    public void removeOaWorkFlowCheckResults(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowCheckResults", idList);
    }    
}
