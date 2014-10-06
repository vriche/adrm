
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ContractTarget;

public interface ContractTargetDao extends Dao {

    /**
     * Retrieves all of the contractTargets
     */
    public List getContractTargets(ContractTarget contractTarget);
    /**
     * Retrieves all of the getContractTargetsCount
     */
    public Integer getContractTargetsCount(ContractTarget contractTarget);   
    /**
     * Retrieves all of the getContractTargetsPage
     */        
    public PaginatedList getContractTargetsPage(ContractTarget contractTarget,int pageIndex,int pageSize);
    /**
     * Retrieves all of the contractTargetsByIdList
     */
    public List getContractTargetsByIdList(final Map idList);

    /**
     * Gets contractTarget's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the contractTarget's id
     * @return contractTarget populated contractTarget object
     */
    public ContractTarget getContractTarget(final Long id);

    /**
     * Saves a contractTarget's information
     * @param contractTarget the object to be saved
     */    
    public Long saveContractTarget(ContractTarget contractTarget);

    /**
     * Removes a contractTarget from the database by id
     * @param id the contractTarget's id
     */
    public void removeContractTarget(final Long id);
	/**
     * Removes contractTargets from the database by ids
     * @param ids the contractTarget's id eg:"'1','2','3'"
     */
    public void removeContractTargets(final Map idList);
}

