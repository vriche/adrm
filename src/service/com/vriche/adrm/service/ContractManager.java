
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.model.Contract;
import com.vriche.adrm.service.Manager;

public interface ContractManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setContractDao(ContractDao contractDAO);

    /**
     * Retrieves all of the contracts
     */
    public List getContracts(Contract contract);
    
    
    public List getContractsPage(Contract contract,String pageIndex, String pageSize);
    
    
    public String getContractsCount(Contract contract);
    
        /**
     * Retrieves all of the contractsByIdList
     */

//    public PaginatedList getContractsByIdList(final Map idList,String pageIndex, String pageSize);
    

    /**
     * Gets contract's information based on id.
     * @param id the contract's id
     * @return contract populated contract object
     */
    public Contract getContract(final String id);

    /**
     * Saves a contract's information
     * @param contract the object to be saved
     */
    public String saveContract(Contract contract);
    
    
    public Contract saveContractReturnObj(Contract contract);

    /**
     * Removes a contract from the database by id
     * @param id the contract's id
     */
    public void removeContract(final String id);
     /**
     * Removes a contract from the database by id
     * @param idList
     */
    public void removeContracts(final Map idList);
    
    
    /**
     * @param ContractIds 合同编号数组
     * @param state       合同状态
     */
    
    public String getContractsByWorkFlowCount(String workFlowId, int state);
    
//    public PaginatedList getContractsByWorkFlowPage(String workFlowId,int state,String pageIndex, String pageSize);
    
    public List getContractsByWorkFlowPage(String workFlowId,int state,String pageIndex, String pageSize);
    
//    public void updateContractStates(String[] ContractIds,String state);
    public void updateContractStates(Set ids, int state);
    
    public void updateContractStates(String[] ids, int state);
    
    public List getContractPaymentAutoComplet(Contract contract);
    
    public Collection  getCollectionsList(String querString,String type);
    
}

