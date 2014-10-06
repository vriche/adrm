
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProOrderType;
import com.vriche.adrm.dao.ProOrderTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProOrderTypeDaoiBatis extends BaseDaoiBATIS implements ProOrderTypeDao {

    /**
     * @see com.vriche.adrm.dao.ProOrderTypeDao#getProOrderTypes(com.vriche.adrm.model.ProOrderType)
     */
    public List getProOrderTypes(final ProOrderType proOrderType) {
          return getSqlMapClientTemplate().queryForList("getProOrderTypes", proOrderType);
    }
     /**
     * @see com.vriche.adrm.dao.ProOrderTypeDao#getProOrderTypesCount(com.vriche.adrm.model.ProOrderType)
     */
    public Integer getProOrderTypesCount(final ProOrderType proOrderType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProOrderTypesCount", proOrderType);
    }
     /**
     * @see com.vriche.adrm.dao.ProOrderTypeDao#getProOrderTypesPage(com.vriche.adrm.model.ProOrderType)
     */   
  	public List getProOrderTypesPage(final ProOrderType proOrderType,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProOrderTypes",proOrderType,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProOrderTypeDao#getProOrderTypesByIdList(com.vriche.adrm.model.ProOrderType)
     */
    public List getProOrderTypesByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProOrderTypesByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProOrderTypeDao#getProOrderType(Long id)
     */
    public ProOrderType getProOrderType(Long id) {
        ProOrderType proOrderType = (ProOrderType) getSqlMapClientTemplate().queryForObject("getProOrderType", id);

        if (proOrderType == null) {
            throw new ObjectRetrievalFailureException(ProOrderType.class, id);
        }

        return proOrderType;
    }

    /**
     * @see com.vriche.adrm.dao.ProOrderTypeDao#saveProOrderType(ProOrderType proOrderType)
     */    
    public Long saveProOrderType(final ProOrderType proOrderType) {
        Long id = proOrderType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProOrderType", proOrderType);
        } else {
            getSqlMapClientTemplate().update("updateProOrderType", proOrderType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProOrderType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ProOrderTypeDao#removeProOrderType(Long id)
     */
    public void removeProOrderType(Long id) {
        getSqlMapClientTemplate().update("deleteProOrderType", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProOrderTypeDAO#removeProOrderTypes(String ids)
     */
    public void removeProOrderTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteProOrderTypes", idList);
    }    
}
