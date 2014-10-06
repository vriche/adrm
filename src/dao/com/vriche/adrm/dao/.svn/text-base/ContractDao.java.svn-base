
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.model.Contract;

public interface ContractDao extends Dao {

    /**
     * Retrieves all of the contracts
     */
    public List getContracts(Contract contract);
    
    public List getContractsByUsers(final Map mp);
    
    public List getContractsByWorkFlowId(final Map mp);
    public List getContractIdsByWorkFlowId(final Map mp);
    
    
    public List getContractsPage(Contract contract,int pageIndex,int pageSize);
    
    public Integer getContractsCount(Contract contract);

    public Integer getContractsByIdListCount(final Map idList);
    
//    public PaginatedList getContractsByIdList(final Map idList,int pageIndex,int pageSize);
    
    public List getContractsByIdList(final Map idList,int pageIndex,int pageSize);

    /**
     * Gets contract's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the contract's id
     * @return contract populated contract object
     */
    public Contract getContract(final Long id);

    /**
     * Saves a contract's information
     * @param contract the object to be saved
     */    
    public Long saveContract(Contract contract);

    /**
     * Removes a contract from the database by id
     * @param id the contract's id
     */
    public void removeContract(final Long id);
	/**
     * Removes contracts from the database by ids
     * @param ids the contract's id eg:"'1','2','3'"
     */
    public void removeContracts(final Map idList);
    
    public void updateContractState(final Map idList);
    
    public List getContractAutoComplet(Contract contract);
    
    public List getContractsList(Contract contract);

}

