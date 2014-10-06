
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.IncomePull;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomePullDaoiBatis extends BaseDaoiBATIS implements IncomePullDao {


    /**
     * @see com.vriche.adrm.finance.dao.IncomePullDao#getIncomePulls(com.vriche.adrm.model.IncomePull)
     */
    public List getIncomePulls(final IncomePull incomePull) {
          return getSqlMapClientTemplate().queryForList("getIncomePulls", incomePull);
    }
    /**
     * @see com.vriche.adrm.finance.dao.IncomePullDao#getIncomePullsByIdList(com.vriche.adrm.model.IncomePull)
     */
    public List getIncomePullsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getIncomePullsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomePullDao#getIncomePull(Long id)
     */
    public IncomePull getIncomePull(Long id) {
        IncomePull incomePull = (IncomePull) getSqlMapClientTemplate().queryForObject("getIncomePull", id);

        if (incomePull == null) {
            throw new ObjectRetrievalFailureException(IncomePull.class, id);
        }

        return incomePull;
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomePullDao#saveIncomePull(IncomePull incomePull)
     */    
    public Long saveIncomePull(final IncomePull incomePull) {
        Long id = incomePull.getId();
        // check for new record
//        System.out.println(">>>>  0"+incomePull.getMoneyPull());
        if (id == null) {
        	
            id = (Long) getSqlMapClientTemplate().insert("addIncomePull", incomePull);
        } else {
//        	System.out.println(">>>>  1"+id+"?????   "+incomePull.getMoneyPull());
            getSqlMapClientTemplate().update("updateIncomePull", incomePull);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(IncomePull.class, id);
        }

        return id;
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomePullDao#removeIncomePull(Long id)
     */
    public void removeIncomePull(Long id) {
       int s=  getSqlMapClientTemplate().update("deleteIncomePull", id);
        System.out.println("xxxx==="+s);
    }
    /**
     * @see com.vriche.adrm.order.dao.IncomePullDAO#removeIncomePulls(String ids)
     */
    public void removeIncomePulls(final Map idList) {
        getSqlMapClientTemplate().update("deleteIncomePulls", idList);
    }
	public List checkRemoveIncomePullByIncomeUsed(Long incomeUsedId) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("checkIncomePullByIncomeUsed", incomeUsedId);
	}    
	
	public void removeIncomePullByIncomeId(Long incomeId) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("removeIncomePullByIncomeId", incomeId);
	} 

	public List getCustomerIncomeMoneyPull(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getCustomerIncomeAnalyze", mp);
	}
	
	public List getCustomerIncomePullResult(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("customerIncomePullResult", mp);
	}
	
	public List getIncomesPulls(IncomePull incomePull) {
		return getSqlMapClientTemplate().queryForList("getIncomePullsByCustomerId", incomePull);
	}
	public void saveIncomePullVersion(IncomePull incomePull) {
		// TODO Auto-generated method stub
		 getSqlMapClientTemplate().update("updateIncomePullVersion", incomePull);
	}
	
	
    /**
     * @see com.vriche.adrm.finance.dao.IncomePullDao#getOrdersByIncomeId(Long id)
     */
    public List getOrdersByIncomeId(Long id) {
        return getSqlMapClientTemplate().queryForList("getOrdersByIncomeId", id);
    }
	
	public void updateIncomePullMoney(IncomePull incomePull) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("updateIncomePullMoney", incomePull);
	}
	public List getIncomePullsByCustomerId2(IncomePull incomePull) {
		return getSqlMapClientTemplate().queryForList("getIncomePullsByCustomerId2", incomePull);
	} 
	public List getIncomePullsByCustomerId3(Map mp) {
		return getSqlMapClientTemplate().queryForList("getIncomePullsByCustomerId3", mp);
	} 
	
	
	public List getCustomerFromIncomeNoInORrder(){
		return getSqlMapClientTemplate().queryForList("getCustomerFromIncomeNoInORrder", null);
	}
	public IncomePull getIncomePullByIncomeId(Long incomeId) {
		
		        IncomePull incomePull = (IncomePull) getSqlMapClientTemplate().queryForObject("getIncomePullByIncomeId", incomeId);

		        if (incomePull == null) {
		            throw new ObjectRetrievalFailureException(IncomePull.class, incomeId);
		        }

		        return incomePull;
		  
	}
}
