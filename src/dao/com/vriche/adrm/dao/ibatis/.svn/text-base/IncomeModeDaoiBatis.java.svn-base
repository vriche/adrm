
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomeModeDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.IncomeMode;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomeModeDaoiBatis extends BaseDaoiBATIS implements IncomeModeDao {

    /**
     * @see com.vriche.adrm.finance.dao.IncomeModeDao#getIncomeModes(com.vriche.adrm.finance.model.IncomeMode)
     */
    public List getIncomeModes(final IncomeMode incomeMode) {
          return getSqlMapClientTemplate().queryForList("getIncomeModes", incomeMode);
    }
    /**
     * @see com.vriche.adrm.finance.dao.IncomeModeDao#getIncomeModesByIdList(com.vriche.adrm.finance.model.IncomeMode)
     */
    public List getIncomeModesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getIncomeModesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeModeDao#getIncomeMode(Long id)
     */
    public IncomeMode getIncomeMode(Long id) {
        IncomeMode incomeMode = (IncomeMode) getSqlMapClientTemplate().queryForObject("getIncomeMode", id);

        if (incomeMode == null) {
            throw new ObjectRetrievalFailureException(IncomeMode.class, id);
        }

        return incomeMode;
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeModeDao#saveIncomeMode(IncomeMode incomeMode)
     */    
    public void saveIncomeMode(final IncomeMode incomeMode) {
        Long id = incomeMode.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addIncomeMode", incomeMode);
        } else {
            getSqlMapClientTemplate().update("updateIncomeMode", incomeMode);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(IncomeMode.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomeModeDao#removeIncomeMode(Long id)
     */
    public void removeIncomeMode(Long id) {
        getSqlMapClientTemplate().update("deleteIncomeMode", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.IncomeModeDAO#removeIncomeModes(String ids)
     */
    public void removeIncomeModes(final Map idList) {
        getSqlMapClientTemplate().update("deleteIncomeModes", idList);
    }    
}
