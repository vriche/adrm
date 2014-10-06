
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProProgramType;
import com.vriche.adrm.dao.ProProgramTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProProgramTypeDaoiBatis extends BaseDaoiBATIS implements ProProgramTypeDao {

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramTypes(com.vriche.adrm.model.ProProgramType)
     */
    public List getProProgramTypes(final ProProgramType proProgramType) {
          return getSqlMapClientTemplate().queryForList("getProProgramTypes", proProgramType);
    }
    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramTypes(com.vriche.adrm.model.ProProgramType)
     */
    public List getProProgramStatus(final ProProgramType proProgramType) {
          return getSqlMapClientTemplate().queryForList("getProProgramStatus", proProgramType);
    }
     /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramTypesCount(com.vriche.adrm.model.ProProgramType)
     */
    public Integer getProProgramTypesCount(final ProProgramType proProgramType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProProgramTypesCount", proProgramType);
    }
     /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramTypesPage(com.vriche.adrm.model.ProProgramType)
     */   
  	public List getProProgramTypesPage(final ProProgramType proProgramType,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProProgramTypes",proProgramType,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramTypesByIdList(com.vriche.adrm.model.ProProgramType)
     */
    public List getProProgramTypesByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProProgramTypesByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#getProProgramType(Long id)
     */
    public ProProgramType getProProgramType(Long id) {
        ProProgramType proProgramType = (ProProgramType) getSqlMapClientTemplate().queryForObject("getProProgramType", id);

        if (proProgramType == null) {
            throw new ObjectRetrievalFailureException(ProProgramType.class, id);
        }

        return proProgramType;
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#saveProProgramType(ProProgramType proProgramType)
     */    
    public Long saveProProgramType(final ProProgramType proProgramType) {
        Long id = proProgramType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProProgramType", proProgramType);
        } else {
            getSqlMapClientTemplate().update("updateProProgramType", proProgramType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProProgramType.class, id);
        }
        return  id;
    }
    
    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#saveProProgramType(ProProgramType proProgramType)
     */    
    public Long saveProProgramStatus(final ProProgramType proProgramType) {
        Long id = proProgramType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProProgramStatus", proProgramType);
        } else {
            getSqlMapClientTemplate().update("updateProProgramStatus", proProgramType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProProgramType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#removeProProgramType(Long id)
     */
    public void removeProProgramStatus(Long id) {
        getSqlMapClientTemplate().update("deleteProProgramStatus", id);
    }
    
    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDao#removeProProgramType(Long id)
     */
    public void removeProProgramType(Long id) {
        getSqlMapClientTemplate().update("deleteProProgramType", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProProgramTypeDAO#removeProProgramTypes(String ids)
     */
    public void removeProProgramTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteProProgramTypes", idList);
    }    
}
