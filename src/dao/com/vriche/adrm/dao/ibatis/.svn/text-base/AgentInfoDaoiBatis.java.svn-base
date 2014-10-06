
package com.vriche.adrm.dao.ibatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.AgentInfoDao;
import com.vriche.adrm.model.AgentInfo;

public class AgentInfoDaoiBatis extends BaseDaoiBATIS implements AgentInfoDao {


	
	/**
     * @see com.vriche.adrm.crm.dao.AgentInfoDao#getAgentInfos(com.vriche.adrm.crm.model.AgentInfo)
     */
    public List getAgentInfos(final AgentInfo agentInfo) {
          return getSqlMapClientTemplate().queryForList("getAgentInfos", agentInfo);
    }
    /**
     * @see com.vriche.adrm.crm.dao.AgentInfoDao#getAgentInfosByIdList(com.vriche.adrm.crm.model.AgentInfo)
     */
    public List getAgentInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getAgentInfosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.AgentInfoDao#getAgentInfo(Long id)
     */
    public AgentInfo getAgentInfo(Long id) {
        AgentInfo agentInfo = (AgentInfo) getSqlMapClientTemplate().queryForObject("getAgentInfo", id);

        if (agentInfo == null) {
            throw new ObjectRetrievalFailureException(AgentInfo.class, id);
        }

        return agentInfo;
    }
    
    public AgentInfo getAgentInfo(Long customerId, Long IndustryId) {
    	
    	Map parameterMap = new HashMap();
    	parameterMap.put("customerId",customerId);
    	parameterMap.put("industryTypeId",IndustryId);
    	
        AgentInfo agentInfo = (AgentInfo) getSqlMapClientTemplate().queryForObject("getAgentInfosByCustomerIndustry", parameterMap);

        if (agentInfo == null) {
        	agentInfo = new AgentInfo();
//            throw new ObjectRetrievalFailureException(AgentInfo.class, customerId);
        }

        return agentInfo;
	}

    /**
     * @see com.vriche.adrm.crm.dao.AgentInfoDao#saveAgentInfo(AgentInfo agentInfo)
     */    
    public void saveAgentInfo(final AgentInfo agentInfo) {
        Long id = agentInfo.getId();
        // check for new record
        
        if (id == null|| id.intValue() == -1) {
//        	agentInfo.setCreateDate(new Date());
//        	System.out.println("agentInfo--" + agentInfo.toString());
            id = (Long) getSqlMapClientTemplate().insert("addAgentInfo", agentInfo);
        } else {
            getSqlMapClientTemplate().update("updateAgentInfo", agentInfo);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(AgentInfo.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.crm.dao.AgentInfoDao#removeAgentInfo(Long id)
     */
    public void removeAgentInfo(Long id) {
        getSqlMapClientTemplate().update("deleteAgentInfo", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.AgentInfoDAO#removeAgentInfos(String ids)
     */
    public void removeAgentInfos(final Map idList) {
        getSqlMapClientTemplate().update("deleteAgentInfos", idList);
    }
	public PaginatedList getAgentInfosPage(AgentInfo agentInfo, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getAgentInfos",agentInfo,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getAgentInfosCount(AgentInfo agentInfo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getAgentInfosCount", agentInfo);
	}
	public Integer getAgentInfosCountByContractId(AgentInfo agentInfo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getAgentInfosCountByContractId", agentInfo);
	}
	public AgentInfo getAgentInfoByObj(AgentInfo agentInfo) {
//		System.out.println("agentInfo---------" + agentInfo);
		return (AgentInfo) getSqlMapClientTemplate().queryForObject("getAgentInfo", agentInfo);
	}    
}
