
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomePurposeDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.IncomePurpose;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomePurposeDaoiBatis extends BaseDaoiBATIS implements IncomePurposeDao {

    /**
     * @see com.vriche.adrm.finance.dao.IncomePurposeDao#getIncomePurposes(com.vriche.adrm.finance.model.IncomePurpose)
     */
    public List getIncomePurposes(final IncomePurpose incomePurpose) {
          return getSqlMapClientTemplate().queryForList("getIncomePurposes", incomePurpose);
    }
    /**
     * @see com.vriche.adrm.finance.dao.IncomePurposeDao#getIncomePurposesByIdList(com.vriche.adrm.finance.model.IncomePurpose)
     */
    public List getIncomePurposesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getIncomePurposesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomePurposeDao#getIncomePurpose(Long id)
     */
    public IncomePurpose getIncomePurpose(Long id) {
//    	System.out.println("id========="+id);
        IncomePurpose incomePurpose = (IncomePurpose) getSqlMapClientTemplate().queryForObject("getIncomePurpose", id);
//        System.out.println("incomePurpose========="+incomePurpose);
        if (incomePurpose == null) {
            throw new ObjectRetrievalFailureException(IncomePurpose.class, id);
        }

        return incomePurpose;
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomePurposeDao#saveIncomePurpose(IncomePurpose incomePurpose)
     */    
    public void saveIncomePurpose(final IncomePurpose incomePurpose) {
        Long id = incomePurpose.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addIncomePurpose", incomePurpose);
        } else {
            getSqlMapClientTemplate().update("updateIncomePurpose", incomePurpose);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(IncomePurpose.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.finance.dao.IncomePurposeDao#removeIncomePurpose(Long id)
     */
    public void removeIncomePurpose(Long id) {
        getSqlMapClientTemplate().update("deleteIncomePurpose", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.IncomePurposeDAO#removeIncomePurposes(String ids)
     */
    public void removeIncomePurposes(final Map idList) {
        getSqlMapClientTemplate().update("deleteIncomePurposes", idList);
    }    
}
