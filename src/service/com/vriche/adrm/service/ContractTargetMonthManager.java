
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.ContractTargetMonth;
import com.vriche.adrm.dao.ContractTargetMonthDao;

public interface ContractTargetMonthManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setContractTargetMonthDao(ContractTargetMonthDao contractTargetMonthDAO);

    /**
     * Retrieves all of the contractTargetMonths
     */
    public List getContractTargetMonths(ContractTargetMonth contractTargetMonth);
     /**
     * Retrieves all of the contractTargetMonthsCount
     */
    public String getContractTargetMonthsCount(ContractTargetMonth contractTargetMonth);
     /**
     * Retrieves all of the contractTargetMonthsCount
     */    
    public PaginatedList getContractTargetMonthsPage(ContractTargetMonth contractTargetMonth,String pageIndex,String pageSize);
     /**
     * Retrieves all of the contractTargetMonthsByIdList
     */
    public List getContractTargetMonthsByIdList(final Map idList);

    /**
     * Gets contractTargetMonth's information based on id.
     * @param id the contractTargetMonth's id
     * @return contractTargetMonth populated contractTargetMonth object
     */
    public ContractTargetMonth getContractTargetMonth(final String id);

    /**
     * Saves a contractTargetMonth's information
     * @param contractTargetMonth the object to be saved
     */
    public String saveContractTargetMonth(ContractTargetMonth contractTargetMonth);

    /**
     * Removes a contractTargetMonth from the database by id
     * @param id the contractTargetMonth's id
     */
    public void removeContractTargetMonth(final String id);
     /**
     * Removes a contractTargetMonth from the database by id
     * @param idList
     */
    public void removeContractTargetMonths(final Map idList);
}

