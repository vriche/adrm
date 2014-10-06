
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.dao.ProCustomerDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProCustomerDaoiBatis extends BaseDaoiBATIS implements ProCustomerDao {

    /**
     * @see com.vriche.adrm.dao.ProCustomerDao#getProCustomers(com.vriche.adrm.model.ProCustomer)
     */
    public List getProCustomers(final ProCustomer proCustomer) {
          return getSqlMapClientTemplate().queryForList("getProCustomers", proCustomer);
    }
     /**
     * @see com.vriche.adrm.dao.ProCustomerDao#getProCustomersCount(com.vriche.adrm.model.ProCustomer)
     */
    public Integer getProCustomersCount(final ProCustomer proCustomer) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProCustomersCount", proCustomer);
    }
     /**
     * @see com.vriche.adrm.dao.ProCustomerDao#getProCustomersPage(com.vriche.adrm.model.ProCustomer)
     */   
  	public List getProCustomersPage(final ProCustomer proCustomer,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProCustomersByIdList",proCustomer,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProCustomerDao#getProCustomersByIdList(com.vriche.adrm.model.ProCustomer)
     */
    public List getProCustomersByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProCustomersByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProCustomerDao#getProCustomer(Long id)
     */
    public ProCustomer getProCustomer(Long id) {
        ProCustomer proCustomer = (ProCustomer) getSqlMapClientTemplate().queryForObject("getProCustomer", id);

        if (proCustomer == null) {
            throw new ObjectRetrievalFailureException(ProCustomer.class, id);
        }

        return proCustomer;
    }

    /**
     * @see com.vriche.adrm.dao.ProCustomerDao#saveProCustomer(ProCustomer proCustomer)
     */    
    public Long saveProCustomer(final ProCustomer proCustomer) {
        Long id = proCustomer.getId();
        
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProCustomer", proCustomer);
        } else {
        	
            getSqlMapClientTemplate().update("updateProCustomer", proCustomer);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProCustomer.class, id);
        }
        return  id;
    }
    /**
     * @see com.vriche.adrm.dao.ProCustomerDao#removeProCustomer(Long id)
     */
    public void removeProCustomer(Long id) {
        getSqlMapClientTemplate().update("deleteProCustomer", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProCustomerDAO#removeProCustomers(String ids)
     */
    public void removeProCustomers(final Map idList) {
        getSqlMapClientTemplate().update("deleteProCustomers", idList);
    }    
}
