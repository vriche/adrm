
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProCustomerType;
import com.vriche.adrm.dao.ProCustomerTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProCustomerTypeDaoiBatis extends BaseDaoiBATIS implements ProCustomerTypeDao {

    /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDao#getProCustomerTypes(com.vriche.adrm.model.ProCustomerType)
     */
    public List getProCustomerTypes(final ProCustomerType proCustomerType) {
          return getSqlMapClientTemplate().queryForList("getProCustomerTypes", proCustomerType);
    }
     /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDao#getProCustomerTypesCount(com.vriche.adrm.model.ProCustomerType)
     */
    public Integer getProCustomerTypesCount(final ProCustomerType proCustomerType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProCustomerTypesCount", proCustomerType);
    }
     /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDao#getProCustomerTypesPage(com.vriche.adrm.model.ProCustomerType)
     */   
  	public List getProCustomerTypesPage(final ProCustomerType proCustomerType,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProCustomerTypes",proCustomerType,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDao#getProCustomerTypesByIdList(com.vriche.adrm.model.ProCustomerType)
     */
    public List getProCustomerTypesByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProCustomerTypesByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDao#getProCustomerType(Long id)
     */
    public ProCustomerType getProCustomerType(Long id) {
        ProCustomerType proCustomerType = (ProCustomerType) getSqlMapClientTemplate().queryForObject("getProCustomerType", id);

        if (proCustomerType == null) {
            throw new ObjectRetrievalFailureException(ProCustomerType.class, id);
        }

        return proCustomerType;
    }

    /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDao#saveProCustomerType(ProCustomerType proCustomerType)
     */    
    public Long saveProCustomerType(final ProCustomerType proCustomerType) {
        Long id = proCustomerType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProCustomerType", proCustomerType);
        } else {
        	
            getSqlMapClientTemplate().update("updateProCustomerType", proCustomerType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProCustomerType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDao#removeProCustomerType(Long id)
     */
    public void removeProCustomerType(Long id) {
        getSqlMapClientTemplate().update("deleteProCustomerType", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProCustomerTypeDAO#removeProCustomerTypes(String ids)
     */
    public void removeProCustomerTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteProCustomerTypes", idList);
    }    
}
