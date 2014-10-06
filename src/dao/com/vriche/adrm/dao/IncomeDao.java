
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.model.Account;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.IncomePull;

public interface IncomeDao extends Dao {

    /**
     * Retrieves all of the incomes
     */
    public List getIncomes(Income income);
    
    public Integer getIncomeCount(Income income);
    
    public Integer getIncomeCountByIdList(final Map idList);
    
    public Integer getIncomesPageCount(Map idList) ;
    
    public PaginatedList getIncomesPage(Income income,int pageIndex,int pageSize);
    
    public List getIncomesPage2(Income income,int pageIndex,int pageSize);
    
    public Income getIncomesPageSum(Income income);
    
    public List getIncomesPageSum2(Income income);
    
    public List getIncomesPage(final Map idList);
    
//    public List getIncomesPage(final Map idList,int pageIndex,int pageSize);


    /**
     * Gets income's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the income's id
     * @return income populated income object
     */
    public Income getIncome(final Long id);

    /**
     * Saves a income's information
     * @param income the object to be saved
     */    
    public String saveIncome(Income income);

    /**
     * Removes a income from the database by id
     * @param id the income's id
     */
    public void removeIncome(final Long id);
	/**
     * Removes incomes from the database by ids
     * @param ids the income's id eg:"'1','2','3'"
     */
    public void removeIncomes(final Map idList);
    
    public List getPutOnInfos(Map mp);
    
    public List getPullIncomeMoneyList(Map mp);
    
    public List getIncomeMoneyAllCarrier(Map mp);
    
    public Income getIncome2(final String incomeCode);
    
    public List getIncomeMoneyAllCustomer(Map mp);
    
    public List getAreaIncomeMoney(Map mp);
    
    public List getIncomeMoneyGroupMonth(Map mp);
    
    public List getIncomesListPage(Income income);
    
    public List getAccount(Account account);
    
    public Income getIncomeByCodeAuto(Map mp);
    
    public List getIncomeCodeStoreList(Map mp);
    
    public Income getIncomesSumNew(Map mp);
    
    public List getIncomesListNew(Map mp,int pageIndex,int pageSize);
    
    public List getCollectionsBalanceParaSort(Map mp);
    
		 public List getCollectionsBalanceParaSort2(Map mp);
		 
		 public IncomePull getBalanceParaSortIncome(Map mp);
    
    
}

