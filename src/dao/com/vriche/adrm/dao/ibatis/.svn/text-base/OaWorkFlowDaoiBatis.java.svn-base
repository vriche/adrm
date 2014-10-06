package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaWorkFlowDao;
import com.vriche.adrm.model.OaWorkFlow;

public class OaWorkFlowDaoiBatis extends BaseDaoiBATIS implements OaWorkFlowDao {

//	List idList = new ArrayList();

	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#getOaWorkFlows(com.vriche.adrm.model.OaWorkFlow)
	 */
	public List getOaWorkFlows(final OaWorkFlow oaWorkFlow) {
		return getSqlMapClientTemplate().queryForList("getOaWorkFlows",
				oaWorkFlow);
	}
	public List getOaWorkFlowsByUser(final Map mp) {
		return getSqlMapClientTemplate().queryForList("getOaWorkFlowsByUser",mp);
	}
	
	

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#getOaWorkFlowsMap(com.vriche.adrm.model.OaWorkFlow)
	 */
	public Map getOaWorkFlowsMap(OaWorkFlow oaWorkFlow) {
		Map mp = getSqlMapClientTemplate().queryForMap("getOaWorkFlows",oaWorkFlow, "id", "name");
		return mp;
	}

	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#getOaWorkFlowsCount(com.vriche.adrm.model.OaWorkFlow)
	 */
	public Integer getOaWorkFlowsCount(final OaWorkFlow oaWorkFlow) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"getOaWorkFlowsCount", oaWorkFlow);
	}

	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#getOaWorkFlowsPage(com.vriche.adrm.model.OaWorkFlow)
	 */
	public PaginatedList getOaWorkFlowsPage(final OaWorkFlow oaWorkFlow,
			int pageIndex, int pageSize) {
		PaginatedList pageList = getSqlMapClientTemplate()
				.queryForPaginatedList("getOaWorkFlows", oaWorkFlow, pageSize);
		pageList.gotoPage(pageIndex - 1);
		return pageList;
	}

	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#getOaWorkFlowsByIdList(com.vriche.adrm.model.OaWorkFlow)
	 */
	public List getOaWorkFlowsByIdList(final Map idList) {
		return getSqlMapClientTemplate().queryForList("getOaWorkFlowsByIdList",idList);
	}

	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#getOaWorkFlow(Long id)
	 */
	public OaWorkFlow getOaWorkFlow(Long id) {
		OaWorkFlow workFlow = new OaWorkFlow();
		workFlow.setId(id);
		OaWorkFlow oaWorkFlow = this.getOaWorkFlow(workFlow);
//		OaWorkFlow oaWorkFlow = (OaWorkFlow) getSqlMapClientTemplate().queryForObject("getOaWorkFlow", id);
		
		if (oaWorkFlow == null) {
			throw new ObjectRetrievalFailureException(OaWorkFlow.class, id);
		}
		return oaWorkFlow;
	}

	public OaWorkFlow getOaWorkFlow(final OaWorkFlow oaWorkFlow) {
		return (OaWorkFlow)getSqlMapClientTemplate().queryForObject("getOaWorkFlow",oaWorkFlow);
	}

	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#saveOaWorkFlow(OaWorkFlow oaWorkFlow)
	 */
	public Long saveOaWorkFlow(final OaWorkFlow oaWorkFlow) {
		Long id = oaWorkFlow.getId();
		// check for new record
		if (id == null || id.toString().equals("0")) {
			id = (Long) getSqlMapClientTemplate().insert("addOaWorkFlow",oaWorkFlow);
		} else {
			getSqlMapClientTemplate().update("updateOaWorkFlow", oaWorkFlow);
		}
		if (id == null) {
			throw new ObjectRetrievalFailureException(OaWorkFlow.class, id);
		}
		return id;
	}

	public void saveCominUsers(final OaWorkFlow oaWorkFlow, Long id) {

		getSqlMapClientTemplate().update("deleteIncomeUsers", id);

		Iterator it = oaWorkFlow.getCominUsers().iterator();
		// System.out.println(oaWorkFlow.getCominUsers().toString());
		while (it.hasNext()) {
			Integer i = new Integer(it.next().toString());
			if (i.intValue() != -1) {
				Map mp = new HashMap();
				mp.put("userId", i);
				mp.put("workFlowId", id);
				getSqlMapClientTemplate().insert("addIncomeUsers", mp);
			}
		}
	}

	public void saveCheckUsers(final OaWorkFlow oaWorkFlow, Long id) {

		getSqlMapClientTemplate().update("deleteCheckUsers", id);

		Iterator it = oaWorkFlow.getCheckUsers().iterator();
		//   	System.out.println(oaWorkFlow.getCheckUsers().toString());
		while (it.hasNext()) {
			Integer i = new Integer(it.next().toString());
			if (i.intValue() != -1) {
				Map mp = new HashMap();
				mp.put("userId", i);
				mp.put("workFlowId", id);
				getSqlMapClientTemplate().insert("addCheckUsers", mp);
			}
		}
	}



	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#removeOaWorkFlow(Long id)
	 */
	public void removeOaWorkFlow(Long id) {
		getSqlMapClientTemplate().update("deleteOaWorkFlow", id);
	}

	/**
	 * @see com.vriche.adrm.dao.OaWorkFlowDAO#removeOaWorkFlows(String ids)
	 */
	public void removeOaWorkFlows(final Map idList) {
		getSqlMapClientTemplate().update("deleteOaWorkFlows", idList);
	}
	
	
	public List getIncomeUsers(Long id) {
		return getSqlMapClientTemplate().queryForList("getIncomeUsers", id);
	}
	
	public List getCheckUsers(Long id) {
		return getSqlMapClientTemplate().queryForList("getCheckUsers", id);
	}
	
	
	public void removeIncomeUsers(final Map idList) {
		getSqlMapClientTemplate().update("deleteIncomeUsersByIds", idList);
	}
	
	public void removeCheckUsers(final Map idList) {
		getSqlMapClientTemplate().update("deleteCheckUsersByIds", idList);
	}

	public List getWorkFlowsOther(OaWorkFlow oaWorkFlow) {
		return getSqlMapClientTemplate().queryForList("getWorkFlowsOther", oaWorkFlow);
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowDao#getWorkFlowsOther(java.lang.String, java.lang.String)
	 */
	public List getWorkFlowsOther(Long agreeWorkFlowId, Long dissentFlowId) {
		OaWorkFlow oaWorkFlow = new OaWorkFlow();
		oaWorkFlow.setAgreeFlowId(agreeWorkFlowId);
		oaWorkFlow.setDissentFlowId(dissentFlowId);
		return this.getWorkFlowsOther(oaWorkFlow);
	}
	

	
	
}
