
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProExpenseProgram;
import com.vriche.adrm.model.ProProgramType;
import com.vriche.adrm.dao.ProExpenseTypeDao;
import com.vriche.adrm.dao.ProProgramTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProExpenseTypeDaoiBatis extends BaseDaoiBATIS implements ProExpenseTypeDao {

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramTypes(com.vriche.adrm.model.ProProgramType)
     */
    public List getProExpenseTypes(final ProProgramType proProgramType) {
          return getSqlMapClientTemplate().queryForList("getProExpenseTypes", proProgramType);
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramType(Long id)
     */
    public ProProgramType getProExpenseType(Long id) {
        ProProgramType proProgramType = (ProProgramType) getSqlMapClientTemplate().queryForObject("getProExpenseType", id);

        if (proProgramType == null) {
            throw new ObjectRetrievalFailureException(ProProgramType.class, id);
        }

        return proProgramType;
    }
    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getExpenseId(com.vriche.adrm.model.ProProgramType)
     */
    public ProProgramType getExpenseId(final ProProgramType proProgramType) {
    	return (ProProgramType) getSqlMapClientTemplate().queryForObject("getProExpenseTypes", proProgramType);
    	 
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#saveProProgramType(ProProgramType proProgramType)
     */    
    public Long saveProExpenseType(final ProProgramType proProgramType) {
        Long id = proProgramType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProExpenseType", proProgramType);
        } else {
            getSqlMapClientTemplate().update("updateProExpenseType", proProgramType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProProgramType.class, id);
        }
        return  id;
    }
    

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#removeProProgramType(Long id)
     */
    public void removeProExpenseType(Long id) {
        getSqlMapClientTemplate().update("deleteProExpenseType", id);
    }

 
}
