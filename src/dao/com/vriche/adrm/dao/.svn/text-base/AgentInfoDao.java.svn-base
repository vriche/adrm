
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.AgentInfo;
import com.vriche.adrm.model.ContractPayment;

public interface AgentInfoDao extends Dao {

    /**
     * Retrieves all of the agentInfos
     */
    public List getAgentInfos(AgentInfo agentInfo);

    public PaginatedList getAgentInfosPage(AgentInfo agentInfo,int pageIndex,int pageSize);
    
    
    public Integer getAgentInfosCount(AgentInfo agentInfo);
    
    public Integer getAgentInfosCountByContractId(AgentInfo agentInfo);
    
    /**
     * Retrieves all of the agentInfosByIdList
     */
    public List getAgentInfosByIdList(final Map idList);

    /**
     * Gets agentInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the agentInfo's id
     * @return agentInfo populated agentInfo object
     */
    public AgentInfo getAgentInfo(final Long id);
    
    public AgentInfo getAgentInfo(final Long customerId,final Long IndustryId);

    /**
     * Saves a agentInfo's information
     * @param agentInfo the object to be saved
     */    
    public void saveAgentInfo(AgentInfo agentInfo);

    /**
     * Removes a agentInfo from the database by id
     * @param id the agentInfo's id
     */
    public void removeAgentInfo(final Long id);
	/**
     * Removes agentInfos from the database by ids
     * @param ids the agentInfo's id eg:"'1','2','3'"
     */
    public void removeAgentInfos(final Map idList);
    
    public AgentInfo getAgentInfoByObj(AgentInfo agentInfo);
}

