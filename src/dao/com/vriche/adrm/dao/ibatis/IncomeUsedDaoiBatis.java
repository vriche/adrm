
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.IncomeUsedDao;
import com.vriche.adrm.model.IncomeUsed;

public class IncomeUsedDaoiBatis extends BaseDaoiBATIS implements IncomeUsedDao {

    /**
     * @see com.vriche.adrm.finance.dao.IncomeUsedDao#getIncomeUseds(com.vriche.adrm.finance.model.IncomeUsed)
     */
    public List getIncomeUseds(final IncomeUsed incomeUsed) {
          return getSqlMapClientTemplate().queryForList("getIncomeUseds", incomeUsed);
    }
    /**
     * @see com.vriche.adrm.finance.dao.IncomeUsedDao#getIncomeUsedsByIdList(com.vriche.adrm.finance.model.IncomeUsed)
     */
    public List getIncomeUsedsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getIncomeUsedsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeUsedDao#getIncomeUsed(Long id)
     */
    public IncomeUsed getIncomeUsed(Long id) {
        IncomeUsed incomeUsed = (IncomeUsed) getSqlMapClientTemplate().queryForObject("getIncomeUsed", id);

        if (incomeUsed == null) {
            throw new ObjectRetrievalFailureException(IncomeUsed.class, id);
        }

        return incomeUsed;
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeUsedDao#saveIncomeUsed(IncomeUsed incomeUsed)
     */    
    public void saveIncomeUsed(final IncomeUsed incomeUsed) {
        Long id = incomeUsed.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addIncomeUsed", incomeUsed);
        } else {
            getSqlMapClientTemplate().update("updateIncomeUsed", incomeUsed);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(IncomeUsed.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeUsedDao#removeIncomeUsed(Long id)
     */
    public void removeIncomeUsed(Long id) {
        getSqlMapClientTemplate().update("deleteIncomeUsed", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.IncomeUsedDAO#removeIncomeUseds(String ids)
     */
    public void removeIncomeUseds(final Map idList) {
        getSqlMapClientTemplate().update("deleteIncomeUseds", idList);
    }
    
    public void deleteIncomeUsedsByPaymentIdAndIncomeId(final Map idList) {
        getSqlMapClientTemplate().update("deleteIncomeUsedsByPaymentIdAndIncomeId", idList);
    }
//	public Double getMoneyInByPaymentId(Long paymentId) {
//		// TODO Auto-generated method stub
//		return (Double) getSqlMapClientTemplate().queryForObject("getIncomeUsedByPaymentId", paymentId);
//	}
    
public void saveIncomeUsedMoneyIn(List ls) {
		
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for (Iterator it = ls.iterator(); it.hasNext();) {
				IncomeUsed incomeUsed = (IncomeUsed)it.next();
				getSqlMapClientTemplate().getSqlMapClient().update("addIncomeUsed", incomeUsed);		
			}
            
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
public List getOrderDayReturnMoney(Map mp) {
	// TODO Auto-generated method stub
	
	return getSqlMapClientTemplate().queryForList("getOrderDayReturnMoney", mp);
}
public List getOrderDayReturnMoney_IncomeUsedId(Map mp) {
	// TODO Auto-generated method stub
	
	return getSqlMapClientTemplate().queryForList("getOrderDayReturnMoney_IncomeUsedId", mp);
}
public void deleteByPaymentIdAndIncomeIdAndDayId(final Map mp) {
    getSqlMapClientTemplate().update("deleteByPaymentIdAndIncomeIdAndDayId", mp);
}
public List getIncomeDetail(Map mp) {
	// TODO Auto-generated method stub
	 return getSqlMapClientTemplate().queryForList("getIncomeDetail", mp);
	
	
}


public List getIncomeUsedForChannel(Map mp) {
	// TODO Auto-generated method stub
	 return getSqlMapClientTemplate().queryForList("getUsedMoney", mp);
	
	
}
public List getIncomeUsedPaymentIds(IncomeUsed incomeUsed) {
	 return getSqlMapClientTemplate().queryForList("getIncomeUsedPaymentIds", incomeUsed);
}
public List getOrderDetailMoneyinByIncomeuse(Map mp) {
	return getSqlMapClientTemplate().queryForList("getOrderDetailMoneyinByIncomeuse", mp);
}
public List getPutonMoneyAllCustomer(Map mp) {

		return getSqlMapClientTemplate().queryForList("getPutonMoneyAllCustomer", mp);
}

public List getReturnValueAllCustomer(Map mp) {

	return getSqlMapClientTemplate().queryForList("getReturnValueAllCustomer", mp);
}


public List getPutonMoneyAllYear(Map mp) {

	return getSqlMapClientTemplate().queryForList("getPutonMoneyAllYear", mp);
}

public List getReturnValueAllYear(Map mp) {

	return getSqlMapClientTemplate().queryForList("getReturnValueAllYear", mp);
}

public List getReturnValueBussiness(Map mp) {

	return getSqlMapClientTemplate().queryForList("getReturnValueBussiness", mp);
}

public List getScopeCarriersPutonMoney(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("getScopeCarriersPutonMoney", mp);
}
public List getScopeResourcesPutonMoney(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("getScopeResourcesPutonMoney", mp);
	
}

public List getScopeIdPutonMoney(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("getScopeIdPutonMoney", mp);
	
}

public List getIndustryPutonMoney(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("getIndustryPutonMoney", mp);
}

public List getCustomerPutonMoney(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("getCustomerPutonMoney", mp);
}
//public List getContractPaymentPutonMoney(Map mp) {
//	// TODO Auto-generated method stub
//	return getSqlMapClientTemplate().queryForList("getContractPaymentPutonMoney", mp);
//}

}
