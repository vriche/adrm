
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.IncomeDao;
import com.vriche.adrm.model.Account;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.IncomePull;

public class IncomeDaoiBatis extends BaseDaoiBATIS implements IncomeDao {

    /**
     * @see com.vriche.adrm.finance.dao.IncomeDao#getIncomes(com.vriche.adrm.finance.model.Income)
     */
    public List getIncomes(final Income income) {
          return getSqlMapClientTemplate().queryForList("getIncomes", income);
    }
    
    
    
    public Integer getIncomeCount(Income income) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("getIncomeCount", income);
	}



	public PaginatedList getIncomesPage(Income income,int pageIndex,int pageSize) {
		 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getIncomes",income,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	
	public List getIncomesListPage(Income income) {
		 return getSqlMapClientTemplate().queryForList("getIncomes",income);
	}

	public List getIncomesPage2(Income income,int pageIndex,int pageSize) {
		 int skip = pageIndex * pageSize;
		 int max =  pageSize;
		 return getSqlMapClientTemplate().queryForList("getIncomes",income,skip,max);
	}



    /**
     * @see com.vriche.adrm.finance.dao.IncomeDao#getIncome(Long id)
     */
    public Income getIncome(Long id) {
        Income income = (Income) getSqlMapClientTemplate().queryForObject("getIncome", id);

        if (income == null) {
            throw new ObjectRetrievalFailureException(Income.class, id);
        }

        return income;
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeDao#saveIncome(Income income)
     */    
    public String saveIncome(final Income income) {
        Long id = income.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addIncome", income);
        } else {
            getSqlMapClientTemplate().update("updateIncome", income);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Income.class, id);
        }
//        System.out.println("id    "+id);
        return id.toString();
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeDao#removeIncome(Long id)
     */
    public void removeIncome(Long id) {
        getSqlMapClientTemplate().update("deleteIncome", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.IncomeDAO#removeIncomes(String ids)
     */
    public void removeIncomes(final Map idList) {
        getSqlMapClientTemplate().update("deleteIncomes", idList);
    }



	public List getIncomesPage(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getIncomesByIdList",mp);
	}

	public Integer getIncomesPageCount(Map idList) {
//		System.out.println("idList++++++++++++++" + idList.size());
	   	 List pageList = getSqlMapClientTemplate().queryForList("getIncomesByIdList",idList);
	     
		 return new Integer(pageList.size());
	}

	public Integer getIncomeCountByIdList(Map idList) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getIncomesCountByIdList", idList);
	}  
	
	public List getPutOnInfos(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getPutOnInfos", mp);
	}
	public List getPullIncomeMoneyList(Map mp){
		boolean isResourceSort = ((Boolean) mp.get("isResourceSort")).booleanValue();
		if(!isResourceSort){
			return getSqlMapClientTemplate().queryForList("getPullIncomeMoney_1", mp);
		}else{
			return getSqlMapClientTemplate().queryForList("getPullIncomeMoney_2", mp);
		}
		
	}



	public Income getIncomesPageSum(Income income) {
		// TODO Auto-generated method stub
		return (Income) getSqlMapClientTemplate().queryForObject("getIncomesPageSum",income);
	}
	public List getIncomesPageSum2(Income income) {
		// TODO Auto-generated method stub
//		return (List) getSqlMapClientTemplate().queryForList("getIncomesPageSum2",income);
		return null;
	}



	public Income getIncome2(String incomeCode) {
		// TODO Auto-generated method stub
		Income income = (Income) getSqlMapClientTemplate().queryForObject("getIncome2", incomeCode);

        if (income == null) {
            throw new ObjectRetrievalFailureException(Income.class, incomeCode);
        }

        return income;
	}



	public List getIncomeMoneyAllCustomer(Map mp) {
		return getSqlMapClientTemplate().queryForList("getIncomeMoneyAllCustomer", mp);
	}
	
	public List getIncomeMoneyAllCarrier(Map mp) {
		return getSqlMapClientTemplate().queryForList("getIncomeMoneyAllCarrier", mp);
	}
	
	public List getAreaIncomeMoney(Map mp) {
		return getSqlMapClientTemplate().queryForList("getAreaIncomeMoney", mp);
	}

	public List getIncomeMoneyGroupMonth(Map mp) {

		return getSqlMapClientTemplate().queryForList("getIncomeMoneyGroupMonth", mp);
	}
	
	public List getAccount(Account account){
		return getSqlMapClientTemplate().queryForList("getAccount", account);
	}



	public Income getIncomeByCodeAuto(Map mp) {
		return (Income) getSqlMapClientTemplate().queryForObject("getIncomeByCodeAuto",mp);
	}
	
	public List getIncomeCodeStoreList(Map mp) {
		return  getSqlMapClientTemplate().queryForList("getIncomeCodeStoreList",mp);
	}



	public Income getIncomesSumNew(Map mp) {
		return  (Income)getSqlMapClientTemplate().queryForObject("getIncomesSum_new",mp);
	}



	public List getIncomesListNew(Map mp, int skip, int pageSize) {
		 if(pageSize == -1){
			 return getSqlMapClientTemplate().queryForList("getIncomes_new",mp);
		 }else{
			 return getSqlMapClientTemplate().queryForList("getIncomes_new",mp,skip,pageSize);
		 }		 
		 
		 

	}
	
	public List getCollectionsBalanceParaSort(Map mp) {
			 return getSqlMapClientTemplate().queryForList("getCollectionsBalanceParaSort",mp); 
	}
	
	public List getCollectionsBalanceParaSort2(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getCollectionsBalanceParaSort2",mp); 
	}
	
	public IncomePull getBalanceParaSortIncome(Map mp) {
		return  (IncomePull)getSqlMapClientTemplate().queryForObject("getBalanceParaSortIncome",mp);
	}
	
	
	
}











