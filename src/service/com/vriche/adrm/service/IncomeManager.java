
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.IncomeDao;
import com.vriche.adrm.model.Account;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Income;

public interface IncomeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setIncomeDao(IncomeDao incomeDAO);

    /**
     * Retrieves all of the incomes
     */
    public List getIncomes(Income income);
    
    public Collection getIncomesColl(List ls) ;
    
    public List getPutOnInfos(String startDate, String endDate,String userId,String carrierName,int channelModelParam);
    
    public List getPutOnInfosForReport(String startDate, String endDate,String userId,String carrierName,String curUserName,String channelModel) ;

    
    public String getPutOnInfosCount(String startDate, String endDate,String userId,String carrierName,int channelModelParam);
    
    public Collection getPutOnInfosColl(List ls);
    
    public String getIncomeCount(Income income);
    
    public PaginatedList getIncomesPage(Income income,String pageIndex,String pageSize); 
    
    public List getIncomesPage2(Income income, String pageIndex,String pageSize,boolean isLastSumPage);
        /**
     * Retrieves all of the incomesByIdList
     */
//    public List getIncomesByIdList(final Map idList);

    /**
     * Gets income's information based on id.
     * @param id the income's id
     * @return income populated income object
     */
    public Income getIncome(final String id);

    /**
     * Saves a income's information
     * @param income the object to be saved
     */
    public String saveIncome(Income income) throws UserExistsException;

    /**
     * Removes a income from the database by id
     * @param id the income's id
     */
    public void removeIncome(final String id);
     /**
     * Removes a income from the database by id
     * @param idList
     */
    public void removeIncomes(final Map idList);
    
    public List getIncomesPageByIdList(Income income);
    
//    public PaginatedList getIncomesPageByIdList(Income income,String pageIndex,String pageSize,Integer state);
    
    public String getIncomeCountByIdList(Income income,Integer state);
    
    public Income getIncome2(final String incomeCode);
    
    public Map getIncome3(Map mp);
    
    public Income getIncome5(final String id);
    
    public Map getTargetIncome(Map mp);
    
    public Map getAreaIncome(Map mp);
    
    public Map getIncome12Month(Map mp);
    public List getBussin(Map mp);
    
    public String getIncomesListXML(Income income);
    
    public Collection getCollections(final String queryString);
    
    public Map getAccountFromMap(Account account);
    
    public String getIncomeXML2(Income inc,String pageIndex, String pageSize);
    
    public List getIncomeCodeStoreList(String queryString);
    
    
    
    public Map buildsearchMap(String strQueryString);
    
    public Income getCountSum(Map searchMap);
    
    public Collection getCollections(Map searchMap,String type,int posStart, int count);
    
    public String getBalanceParaSortXml(String strQueryString);
    
    public Collection getCollectionsBalanceParaSort(String strQueryString);
    
    public void getCompanyIncome(Income income);
    
    
    
    
}

