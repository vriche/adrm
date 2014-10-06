
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysResource;
import com.vriche.adrm.dao.SysResourceDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysResourceDaoiBatis extends BaseDaoiBATIS implements SysResourceDao {

    /**
     * @see com.vriche.adrm.dao.SysResourceDao#getSysResources(com.vriche.adrm.model.SysResource)
     */
    public List getSysResources(final SysResource sysResource) {
          return getSqlMapClientTemplate().queryForList("getSysResources", sysResource);
    }
    
    
     /* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SysResourceDao#getSysResourceByRole(com.vriche.adrm.model.SysResource)
	 */
	public List getSysResourceByRole(Long id) {
		  return getSqlMapClientTemplate().queryForList("getSysResourceByRole", id);
	}


	/**
     * @see com.vriche.adrm.dao.SysResourceDao#getSysResourcesCount(com.vriche.adrm.model.SysResource)
     */
    public Integer getSysResourcesCount(final SysResource sysResource) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysResourcesCount", sysResource);
    }
     /**
     * @see com.vriche.adrm.dao.SysResourceDao#getSysResourcesPage(com.vriche.adrm.model.SysResource)
     */   
  	public PaginatedList getSysResourcesPage(final SysResource sysResource,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysResources",sysResource,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysResourceDao#getSysResourcesByIdList(com.vriche.adrm.model.SysResource)
     */
    public List getSysResourcesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysResourcesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysResourceDao#getSysResource(Long id)
     */
    public SysResource getSysResource(Long id) {
        SysResource sysResource = (SysResource) getSqlMapClientTemplate().queryForObject("getSysResource", id);

        if (sysResource == null) {
            throw new ObjectRetrievalFailureException(SysResource.class, id);
        }

        return sysResource;
    }

    /**
     * @see com.vriche.adrm.dao.SysResourceDao#saveSysResource(SysResource sysResource)
     */    
    public Long saveSysResource(final SysResource sysResource) {
        Long id = sysResource.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysResource", sysResource);
        } else {
            getSqlMapClientTemplate().update("updateSysResource", sysResource);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysResource.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysResourceDao#removeSysResource(Long id)
     */
    public void removeSysResource(Long id) {
        getSqlMapClientTemplate().update("deleteSysResource", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysResourceDAO#removeSysResources(String ids)
     */
    public void removeSysResources(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysResources", idList);
    }

    
    

	public List getSysResourceByRoleId(Long roleId) {
		 return getSqlMapClientTemplate().queryForList("getSysResourceByRoleId", roleId);
	}


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SysResourceDao#addRoleSysResources(java.util.Map)
	 */
	public void addRoleSysResources(Map mp) {
		 getSqlMapClientTemplate().update("addRoleSysResources", mp);
	}


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SysResourceDao#deleteRoleBySysResource(java.lang.Long)
	 */
	public void deleteRoleBySysResource(Long id) {
		getSqlMapClientTemplate().update("deleteRoleBySysResource", id);
		
	}


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SysResourceDao#deleteRoleBySysResourceIds(java.util.Map)
	 */
	public void deleteRoleBySysResourceIds(Map idList) {
		 getSqlMapClientTemplate().update("deleteRoleBySysResourceIds", idList);
		
	}   
    
    
}
