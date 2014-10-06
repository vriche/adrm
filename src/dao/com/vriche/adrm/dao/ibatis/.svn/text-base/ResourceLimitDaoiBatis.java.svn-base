
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ResourceLimit;
import com.vriche.adrm.dao.ResourceLimitDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceLimitDaoiBatis extends BaseDaoiBATIS implements ResourceLimitDao {

    /**
     * @see com.vriche.adrm.dao.ResourceLimitDao#getResourceLimits(com.vriche.adrm.model.ResourceLimit)
     */
    public List getResourceLimits(final ResourceLimit resourceLimit) {
          return getSqlMapClientTemplate().queryForList("getResourceLimits", resourceLimit);
    }
     /**
     * @see com.vriche.adrm.dao.ResourceLimitDao#getResourceLimitsCount(com.vriche.adrm.model.ResourceLimit)
     */
    public Integer getResourceLimitsCount(final ResourceLimit resourceLimit) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getResourceLimitsCount", resourceLimit);
    }
     /**
     * @see com.vriche.adrm.dao.ResourceLimitDao#getResourceLimitsPage(com.vriche.adrm.model.ResourceLimit)
     */   
  	public List getResourceLimitsPage(final ResourceLimit resourceLimit,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getResourceLimits",resourceLimit,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ResourceLimitDao#getResourceLimitsByIdList(com.vriche.adrm.model.ResourceLimit)
     */
    public List getResourceLimitsByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getResourceLimitsByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ResourceLimitDao#getResourceLimit(Long id)
     */
    public ResourceLimit getResourceLimit(Long id) {
        ResourceLimit resourceLimit = (ResourceLimit) getSqlMapClientTemplate().queryForObject("getResourceLimit", id);

        if (resourceLimit == null) {
            throw new ObjectRetrievalFailureException(ResourceLimit.class, id);
        }

        return resourceLimit;
    }

    /**
     * @see com.vriche.adrm.dao.ResourceLimitDao#saveResourceLimit(ResourceLimit resourceLimit)
     */    
    public Long saveResourceLimit(final ResourceLimit resourceLimit) {
        Long id = resourceLimit.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addResourceLimit", resourceLimit);
        } else {
            getSqlMapClientTemplate().update("updateResourceLimit", resourceLimit);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ResourceLimit.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ResourceLimitDao#removeResourceLimit(Long id)
     */
    public void removeResourceLimit(Long id) {
        getSqlMapClientTemplate().update("deleteResourceLimit", id);
    }
    /**
     * @see com.vriche.adrm.dao.ResourceLimitDAO#removeResourceLimits(String ids)
     */
    public void removeResourceLimits(final Map idList) {
        getSqlMapClientTemplate().update("deleteResourceLimits", idList);
    }
	public List getResourceLimitsByCarrier(ResourceLimit resourceLimit) {
		 return getSqlMapClientTemplate().queryForList("getResourceLimitsByCarrier", resourceLimit);
	}    
}
