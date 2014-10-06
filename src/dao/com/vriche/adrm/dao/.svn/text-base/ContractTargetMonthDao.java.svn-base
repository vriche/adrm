
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ContractTargetMonth;

public interface ContractTargetMonthDao extends Dao {

    /**
     * Retrieves all of the contractTargetMonths
     */
    public List getContractTargetMonths(ContractTargetMonth contractTargetMonth);
    /**
     * Retrieves all of the getContractTargetMonthsCount
     */
    public Integer getContractTargetMonthsCount(ContractTargetMonth contractTargetMonth);   
    /**
     * Retrieves all of the getContractTargetMonthsPage
     */        
    public PaginatedList getContractTargetMonthsPage(ContractTargetMonth contractTargetMonth,int pageIndex,int pageSize);
    /**
     * Retrieves all of the contractTargetMonthsByIdList
     */
    public List getContractTargetMonthsByIdList(final Map idList);

    /**
     * Gets contractTargetMonth's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the contractTargetMonth's id
     * @return contractTargetMonth populated contractTargetMonth object
     */
    public ContractTargetMonth getContractTargetMonth(final Long id);

    /**
     * Saves a contractTargetMonth's information
     * @param contractTargetMonth the object to be saved
     */    
    public Long saveContractTargetMonth(ContractTargetMonth contractTargetMonth);

    /**
     * Removes a contractTargetMonth from the database by id
     * @param id the contractTargetMonth's id
     */
    public void removeContractTargetMonth(final Long id);
	/**
     * Removes contractTargetMonths from the database by ids
     * @param ids the contractTargetMonth's id eg:"'1','2','3'"
     */
    public void removeContractTargetMonths(final Map idList);
}

