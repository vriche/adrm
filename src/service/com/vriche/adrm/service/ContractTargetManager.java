
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ContractTarget;
import com.vriche.adrm.dao.ContractTargetDao;

public interface ContractTargetManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setContractTargetDao(ContractTargetDao contractTargetDAO);

    /**
     * Retrieves all of the contractTargets
     */
    public List getContractTargets(ContractTarget contractTarget);
     /**
     * Retrieves all of the contractTargetsCount
     */
    public String getContractTargetsCount(ContractTarget contractTarget);
     /**
     * Retrieves all of the contractTargetsCount
     */    
    public PaginatedList getContractTargetsPage(ContractTarget contractTarget,String pageIndex,String pageSize);
     /**
     * Retrieves all of the contractTargetsByIdList
     */
    public List getContractTargetsByIdList(final Map idList);

    /**
     * Gets contractTarget's information based on id.
     * @param id the contractTarget's id
     * @return contractTarget populated contractTarget object
     */
    public ContractTarget getContractTarget(final String id);

    /**
     * Saves a contractTarget's information
     * @param contractTarget the object to be saved
     */
    public String saveContractTarget(ContractTarget contractTarget);

    /**
     * Removes a contractTarget from the database by id
     * @param id the contractTarget's id
     */
    public void removeContractTarget(final String id);
     /**
     * Removes a contractTarget from the database by id
     * @param idList
     */
    public void removeContractTargets(final Map idList);
}

