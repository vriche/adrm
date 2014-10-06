
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProFinance;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.dao.ProFinanceDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProFinanceDaoiBatis extends BaseDaoiBATIS implements ProFinanceDao {

    /**
     * @see com.vriche.adrm.dao.ProFinanceDao#getProFinances(com.vriche.adrm.model.ProFinance)
     */
    public List getProFinance(final ProFinance proFinance) {
          return getSqlMapClientTemplate().queryForList("getProFinance", proFinance);
    }
    
    /**
     * @see com.vriche.adrm.dao.ProFinanceDao#getProFinancesByIdList(com.vriche.adrm.model.ProFinance)
     */
    public List getProFinancesByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProFinancesByMap", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProFinanceDao#getProFinances(com.vriche.adrm.model.ProFinance)
     */
    public Integer getProFinanceCount(final Long id) {
        return (Integer)getSqlMapClientTemplate().queryForObject("getProFinanceCount",id);
  }
    
    /**
     * @see com.vriche.adrm.dao.ProFinanceDao#saveProFinance(ProFinance proFinance)
     */    
    public Long saveProFinance(final ProFinance proFinance) {
        Long id = proFinance.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProFinance", proFinance);
        } else {
            getSqlMapClientTemplate().update("updateProFinance", proFinance);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProFinance.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ProFinanceDao#removeProFinance(Long id)
     */
    public void removeProFinance(final Long id) {
        getSqlMapClientTemplate().update("deleteProFinance", id);
    }
    
    /**
     * @see com.vriche.adrm.dao.ProFinanceDao#removeProFinanceByOrderId(Long id)
     */
    public void removeProFinanceByOrderId(Long id) {
        getSqlMapClientTemplate().update("deleteProFinanceByOrderId", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProFinanceDAO#removeProFinances(String ids)
     */
    public void removeProFinances(final Map idList) {
        getSqlMapClientTemplate().update("deleteProFinances", idList);
    }
}
