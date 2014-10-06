
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaTeleExpenses;
import com.vriche.adrm.dao.OaTeleExpensesDao;

public interface OaTeleExpensesManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaTeleExpensesDao(OaTeleExpensesDao oaTeleExpensesDAO);

    /**
     * Retrieves all of the oaTeleExpensess
     */
    public List getOaTeleExpensess(OaTeleExpenses oaTeleExpenses);
     /**
     * Retrieves all of the oaTeleExpensessCount
     */
    public String getOaTeleExpensessCount(OaTeleExpenses oaTeleExpenses);
     /**
     * Retrieves all of the oaTeleExpensessCount
     */    
    public PaginatedList getOaTeleExpensessPage(OaTeleExpenses oaTeleExpenses,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaTeleExpensessByIdList
     */
    public List getOaTeleExpensessByIdList(final Map idList);

    /**
     * Gets oaTeleExpenses's information based on id.
     * @param id the oaTeleExpenses's id
     * @return oaTeleExpenses populated oaTeleExpenses object
     */
    public OaTeleExpenses getOaTeleExpenses(final String id);

    /**
     * Saves a oaTeleExpenses's information
     * @param oaTeleExpenses the object to be saved
     */
    public String saveOaTeleExpenses(OaTeleExpenses oaTeleExpenses);

    /**
     * Removes a oaTeleExpenses from the database by id
     * @param id the oaTeleExpenses's id
     */
    public void removeOaTeleExpenses(final String id);
     /**
     * Removes a oaTeleExpenses from the database by id
     * @param idList
     */
    public void removeOaTeleExpensess(final Map idList);
    
    public PaginatedList getOaTeleExpensesByBeginAndEndDate(String beginDate,String endDate,String pageIndex,String pageSize);
    
    public String getOaTeleExpensessCountByBeginAndEndDate(String beginDate,String endDate);
}





