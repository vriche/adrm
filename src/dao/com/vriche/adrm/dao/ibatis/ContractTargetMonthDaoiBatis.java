
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ContractTargetMonth;
import com.vriche.adrm.dao.ContractTargetMonthDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractTargetMonthDaoiBatis extends BaseDaoiBATIS implements ContractTargetMonthDao {

    /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDao#getContractTargetMonths(com.vriche.adrm.model.ContractTargetMonth)
     */
    public List getContractTargetMonths(final ContractTargetMonth contractTargetMonth) {
          return getSqlMapClientTemplate().queryForList("getContractTargetMonths", contractTargetMonth);
    }
     /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDao#getContractTargetMonthsCount(com.vriche.adrm.model.ContractTargetMonth)
     */
    public Integer getContractTargetMonthsCount(final ContractTargetMonth contractTargetMonth) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getContractTargetMonthsCount", contractTargetMonth);
    }
     /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDao#getContractTargetMonthsPage(com.vriche.adrm.model.ContractTargetMonth)
     */   
  	public PaginatedList getContractTargetMonthsPage(final ContractTargetMonth contractTargetMonth,int pageIndex, int pageSize) {
//  		 System.out.println("contractTargetMonth==="+ contractTargetMonth);
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getContractTargetMonths",contractTargetMonth,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDao#getContractTargetMonthsByIdList(com.vriche.adrm.model.ContractTargetMonth)
     */
    public List getContractTargetMonthsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getContractTargetMonthsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDao#getContractTargetMonth(Long id)
     */
    public ContractTargetMonth getContractTargetMonth(Long id) {
        ContractTargetMonth contractTargetMonth = (ContractTargetMonth) getSqlMapClientTemplate().queryForObject("getContractTargetMonth", id);

        if (contractTargetMonth == null) {
            throw new ObjectRetrievalFailureException(ContractTargetMonth.class, id);
        }

        return contractTargetMonth;
    }

    /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDao#saveContractTargetMonth(ContractTargetMonth contractTargetMonth)
     */    
    public Long saveContractTargetMonth(final ContractTargetMonth contractTargetMonth) {
        Long id = contractTargetMonth.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addContractTargetMonth", contractTargetMonth);
        } else {
            getSqlMapClientTemplate().update("updateContractTargetMonth", contractTargetMonth);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ContractTargetMonth.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDao#removeContractTargetMonth(Long id)
     */
    public void removeContractTargetMonth(Long id) {
        getSqlMapClientTemplate().update("deleteContractTargetMonth", id);
    }
    /**
     * @see com.vriche.adrm.dao.ContractTargetMonthDAO#removeContractTargetMonths(String ids)
     */
    public void removeContractTargetMonths(final Map idList) {
        getSqlMapClientTemplate().update("deleteContractTargetMonths", idList);
    }    
}
