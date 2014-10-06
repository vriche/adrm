
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ResourceTypeDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ResourceType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceTypeDaoiBatis extends BaseDaoiBATIS implements ResourceTypeDao {

    /**
     * @see com.vriche.adrm.adres.dao.ResourceTypeDao#getResourceTypes(com.vriche.adrm.adres.model.ResourceType)
     */
    public List getResourceTypes(final ResourceType resourceType) {
          return getSqlMapClientTemplate().queryForList("getResourceTypes", resourceType);
    }
    /**
     * @see com.vriche.adrm.adres.dao.ResourceTypeDao#getResourceTypesByIdList(com.vriche.adrm.adres.model.ResourceType)
     */
    public List getResourceTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getResourceTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.ResourceTypeDao#getResourceType(Long id)
     */
    public ResourceType getResourceType(Long id) {
        ResourceType resourceType = (ResourceType) getSqlMapClientTemplate().queryForObject("getResourceType", id);

        if (resourceType == null) {
            throw new ObjectRetrievalFailureException(ResourceType.class, id);
        }

        return resourceType;
    }

    /**
     * @see com.vriche.adrm.adres.dao.ResourceTypeDao#saveResourceType(ResourceType resourceType)
     */    
    public void saveResourceType(final ResourceType resourceType) {
        Long id = resourceType.getId();
        // check for new record
        if (id == null|| id.intValue() == -1|| id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addResourceType", resourceType);
        } else {
            getSqlMapClientTemplate().update("updateResourceType", resourceType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ResourceType.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adres.dao.ResourceTypeDao#removeResourceType(Long id)
     */
    public void removeResourceType(Long id) {
        getSqlMapClientTemplate().update("deleteResourceType", id);
    }
    /**
     * @see com.vriche.adrm.adres.dao.ResourceTypeDAO#removeResourceTypes(String ids)
     */
    public void removeResourceTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteResourceTypes", idList);
    }    
}
