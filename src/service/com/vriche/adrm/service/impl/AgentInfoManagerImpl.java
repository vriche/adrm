
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.AgentInfoDao;
import com.vriche.adrm.model.AgentInfo;
import com.vriche.adrm.service.AgentInfoManager;
import com.vriche.adrm.service.impl.BaseManager;

public class AgentInfoManagerImpl extends BaseManager implements AgentInfoManager {
	
    private AgentInfoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setAgentInfoDao(AgentInfoDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.crm.service.AgentInfoManager#getAgentInfosByIdList(final Map idList)
     */
    public List getAgentInfosByIdList(final Map idList) {
        return dao.getAgentInfosByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.AgentInfoManager#getAgentInfos(com.vriche.adrm.crm.model.AgentInfo)
     */
    public List getAgentInfos(final AgentInfo agentInfo) {
        return dao.getAgentInfos(agentInfo);
    }

    /**
     * @see com.vriche.adrm.crm.service.AgentInfoManager#getAgentInfo(String id)
     */
    public AgentInfo getAgentInfo(final String id) {
        return dao.getAgentInfo(new Long(id));
    }

    
    
    
    public AgentInfo getAgentInfoByCustIndus(String customerId, String IndustryId) {
    	return dao.getAgentInfo(new Long(customerId),new Long(IndustryId));
	}
    
    


	/**
     * @see com.vriche.adrm.crm.service.AgentInfoManager#saveAgentInfo(AgentInfo agentInfo)
     */
    public void saveAgentInfo(AgentInfo agentInfo) {
//    	System.out.println("agentInfo--" + agentInfo.toString());
        dao.saveAgentInfo(agentInfo);
    }

    /**
     * @see com.vriche.adrm.crm.service.AgentInfoManager#removeAgentInfo(String id)
     */
    public void removeAgentInfo(final String id) {
        dao.removeAgentInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.AgentInfoManager#removeAgentInfos(String Map)
     */
    public void removeAgentInfos(final Map idList) {
        dao.removeAgentInfos(idList);
    }

	public PaginatedList getAgentInfosPage(AgentInfo agentInfo, String pageIndex, String pageSize) {
		return dao.getAgentInfosPage(agentInfo,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getAgentInfosCount(AgentInfo agentInfo) {
		return dao.getAgentInfosCount(agentInfo).toString();
	}

	public String getAgentInfosCountByContractId(AgentInfo agentInfo) {
		return dao.getAgentInfosCountByContractId(agentInfo).toString();
	}

	public AgentInfo getAgentInfoByObj(AgentInfo agentInfo) {
		Long contractId = agentInfo.getContractId();
		Long carrierId = agentInfo.getCarrierId();
		Long resourceSortId = agentInfo.getResourceSortId();
		Long customerCategoryId = agentInfo.getCustomerCategoryId();
		
//		System.out.println("contractId=" + contractId);
//		System.out.println("carrierId=" + carrierId);
//		System.out.println("resourceSortId=" + resourceSortId);
//		System.out.println("customerCategoryId=" + customerCategoryId);
		
	
		
		return dao.getAgentInfoByObj(agentInfo);
	}    
}
