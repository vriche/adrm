
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaTeleExpenses;

public interface OaTeleExpensesDao extends Dao {

    /**
     * Retrieves all of the oaTeleExpensess
     */
    public List getOaTeleExpensess(OaTeleExpenses oaTeleExpenses);
    /**
     * Retrieves all of the getOaTeleExpensessCount
     */
    public Integer getOaTeleExpensessCount(OaTeleExpenses oaTeleExpenses);   
    /**
     * Retrieves all of the getOaTeleExpensessPage
     */        
    public PaginatedList getOaTeleExpensessPage(OaTeleExpenses oaTeleExpenses,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaTeleExpensessByIdList
     */
    public List getOaTeleExpensessByIdList(final Map idList);

    /**
     * Gets oaTeleExpenses's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaTeleExpenses's id
     * @return oaTeleExpenses populated oaTeleExpenses object
     */
    public OaTeleExpenses getOaTeleExpenses(final Long id);

    /**
     * Saves a oaTeleExpenses's information
     * @param oaTeleExpenses the object to be saved
     */    
    public Long saveOaTeleExpenses(OaTeleExpenses oaTeleExpenses);

    /**
     * Removes a oaTeleExpenses from the database by id
     * @param id the oaTeleExpenses's id
     */
    public void removeOaTeleExpenses(final Long id);
	/**
     * Removes oaTeleExpensess from the database by ids
     * @param ids the oaTeleExpenses's id eg:"'1','2','3'"
     */
    public void removeOaTeleExpensess(final Map idList);
    
    public PaginatedList getOaTeleExpensesByBeginAndEndDate(final Map idList,int pageIndex,int pageSize);
    
    public Integer getOaTeleExpensessCountByBeginAndEndDate(final Map idList); 
    
    public List getOaTeleExpensesByDate(final Map idList);
}

