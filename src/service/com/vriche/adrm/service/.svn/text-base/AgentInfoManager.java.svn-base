
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.AgentInfoDao;
import com.vriche.adrm.model.AgentInfo;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.service.Manager;

public interface AgentInfoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setAgentInfoDao(AgentInfoDao agentInfoDAO);
    
    public PaginatedList getAgentInfosPage(AgentInfo agentInfo, String pageIndex, String pageSize);
    
    public String getAgentInfosCount(AgentInfo agentInfo);
    
    public String getAgentInfosCountByContractId(AgentInfo agentInfo);
    /**
     * Retrieves all of the agentInfos
     */
    public List getAgentInfos(AgentInfo agentInfo);
        /**
     * Retrieves all of the agentInfosByIdList
     */
    public List getAgentInfosByIdList(final Map idList);

    /**
     * Gets agentInfo's information based on id.
     * @param id the agentInfo's id
     * @return agentInfo populated agentInfo object
     */
    public AgentInfo getAgentInfo(final String id);

    public AgentInfo getAgentInfoByCustIndus(final String customerId,final String IndustryId);
    
    /**
     * Saves a agentInfo's information
     * @param agentInfo the object to be saved
     */
    public void saveAgentInfo(AgentInfo agentInfo);

    /**
     * Removes a agentInfo from the database by id
     * @param id the agentInfo's id
     */
    public void removeAgentInfo(final String id);
     /**
     * Removes a agentInfo from the database by id
     * @param idList
     */
    public void removeAgentInfos(final Map idList);
    
    public AgentInfo getAgentInfoByObj(AgentInfo agentInfo);
}

