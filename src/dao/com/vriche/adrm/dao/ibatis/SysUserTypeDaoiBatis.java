
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysUserType;
import com.vriche.adrm.dao.SysUserTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysUserTypeDaoiBatis extends BaseDaoiBATIS implements SysUserTypeDao {

    /**
     * @see com.vriche.adrm.dao.SysUserTypeDao#getSysUserTypes(com.vriche.adrm.model.SysUserType)
     */
    public List getSysUserTypes(final SysUserType sysUserType) {
          return getSqlMapClientTemplate().queryForList("getSysUserTypes", sysUserType);
    }
     /**
     * @see com.vriche.adrm.dao.SysUserTypeDao#getSysUserTypesCount(com.vriche.adrm.model.SysUserType)
     */
    public Integer getSysUserTypesCount(final SysUserType sysUserType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysUserTypesCount", sysUserType);
    }
     /**
     * @see com.vriche.adrm.dao.SysUserTypeDao#getSysUserTypesPage(com.vriche.adrm.model.SysUserType)
     */   
  	public PaginatedList getSysUserTypesPage(final SysUserType sysUserType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysUserTypes",sysUserType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysUserTypeDao#getSysUserTypesByIdList(com.vriche.adrm.model.SysUserType)
     */
    public List getSysUserTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysUserTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysUserTypeDao#getSysUserType(Long id)
     */
    public SysUserType getSysUserType(Long id) {
        SysUserType sysUserType = (SysUserType) getSqlMapClientTemplate().queryForObject("getSysUserType", id);

        if (sysUserType == null) {
            throw new ObjectRetrievalFailureException(SysUserType.class, id);
        }

        return sysUserType;
    }

    /**
     * @see com.vriche.adrm.dao.SysUserTypeDao#saveSysUserType(SysUserType sysUserType)
     */    
    public Long saveSysUserType(final SysUserType sysUserType) {
        Long id = sysUserType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysUserType", sysUserType);
        } else {
            getSqlMapClientTemplate().update("updateSysUserType", sysUserType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysUserType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysUserTypeDao#removeSysUserType(Long id)
     */
    public void removeSysUserType(Long id) {
        getSqlMapClientTemplate().update("deleteSysUserType", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysUserTypeDAO#removeSysUserTypes(String ids)
     */
    public void removeSysUserTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysUserTypes", idList);
    }    
}
