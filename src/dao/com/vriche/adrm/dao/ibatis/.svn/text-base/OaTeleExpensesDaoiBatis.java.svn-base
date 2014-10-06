
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaTeleExpenses;
import com.vriche.adrm.dao.OaTeleExpensesDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaTeleExpensesDaoiBatis extends BaseDaoiBATIS implements OaTeleExpensesDao {

    /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDao#getOaTeleExpensess(com.vriche.adrm.model.OaTeleExpenses)
     */
    public List getOaTeleExpensess(final OaTeleExpenses oaTeleExpenses) {
          return getSqlMapClientTemplate().queryForList("getOaTeleExpensess", oaTeleExpenses);
    }
     /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDao#getOaTeleExpensessCount(com.vriche.adrm.model.OaTeleExpenses)
     */
    public Integer getOaTeleExpensessCount(final OaTeleExpenses oaTeleExpenses) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaTeleExpensessCount", oaTeleExpenses);
    }
     /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDao#getOaTeleExpensessPage(com.vriche.adrm.model.OaTeleExpenses)
     */   
  	public PaginatedList getOaTeleExpensessPage(final OaTeleExpenses oaTeleExpenses,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaTeleExpensess",oaTeleExpenses,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDao#getOaTeleExpensessByIdList(com.vriche.adrm.model.OaTeleExpenses)
     */
    public List getOaTeleExpensessByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaTeleExpensessByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDao#getOaTeleExpenses(Long id)
     */
    public OaTeleExpenses getOaTeleExpenses(Long id) {
        OaTeleExpenses oaTeleExpenses = (OaTeleExpenses) getSqlMapClientTemplate().queryForObject("getOaTeleExpenses", id);

        if (oaTeleExpenses == null) {
            throw new ObjectRetrievalFailureException(OaTeleExpenses.class, id);
        }

        return oaTeleExpenses;
    }

    /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDao#saveOaTeleExpenses(OaTeleExpenses oaTeleExpenses)
     */    
    public Long saveOaTeleExpenses(final OaTeleExpenses oaTeleExpenses) {
        Long id = oaTeleExpenses.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaTeleExpenses", oaTeleExpenses);
        } else {
            getSqlMapClientTemplate().update("updateOaTeleExpenses", oaTeleExpenses);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaTeleExpenses.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDao#removeOaTeleExpenses(Long id)
     */
    public void removeOaTeleExpenses(Long id) {
        getSqlMapClientTemplate().update("deleteOaTeleExpenses", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaTeleExpensesDAO#removeOaTeleExpensess(String ids)
     */
    public void removeOaTeleExpensess(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaTeleExpensess", idList);
    }
    public PaginatedList getOaTeleExpensesByBeginAndEndDate(final Map idList,int pageIndex,int pageSize){
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaTeleExpensesByBeginAndEndDate",idList,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getOaTeleExpensessCountByBeginAndEndDate(Map idList) {
		// TODO Auto-generated method stub 
		return (Integer)getSqlMapClientTemplate().queryForObject("getOaTeleExpensessCountByBeginAndEndDate", idList);
	}
	public List getOaTeleExpensesByDate(Map idList) {
		return getSqlMapClientTemplate().queryForList("getOaTeleExpensesByBeginAndEndDate", idList);
	}    
}
