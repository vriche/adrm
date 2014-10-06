
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysEventType;
import com.vriche.adrm.dao.SysEventTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventTypeDaoiBatis extends BaseDaoiBATIS implements SysEventTypeDao {

    /**
     * @see com.vriche.adrm.dao.SysEventTypeDao#getSysEventTypes(com.vriche.adrm.model.SysEventType)
     */
    public List getSysEventTypes(final SysEventType sysEventType) {
          return getSqlMapClientTemplate().queryForList("getSysEventTypes", sysEventType);
    }
     /**
     * @see com.vriche.adrm.dao.SysEventTypeDao#getSysEventTypesCount(com.vriche.adrm.model.SysEventType)
     */
    public Integer getSysEventTypesCount(final SysEventType sysEventType) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysEventTypesCount", sysEventType);
    }
     /**
     * @see com.vriche.adrm.dao.SysEventTypeDao#getSysEventTypesPage(com.vriche.adrm.model.SysEventType)
     */   
  	public PaginatedList getSysEventTypesPage(final SysEventType sysEventType,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysEventTypes",sysEventType,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysEventTypeDao#getSysEventTypesByIdList(com.vriche.adrm.model.SysEventType)
     */
    public List getSysEventTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysEventTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysEventTypeDao#getSysEventType(Long id)
     */
    public SysEventType getSysEventType(Long id) {
        SysEventType sysEventType = (SysEventType) getSqlMapClientTemplate().queryForObject("getSysEventType", id);

        if (sysEventType == null) {
            throw new ObjectRetrievalFailureException(SysEventType.class, id);
        }

        return sysEventType;
    }

    /**
     * @see com.vriche.adrm.dao.SysEventTypeDao#saveSysEventType(SysEventType sysEventType)
     */    
    public Long saveSysEventType(final SysEventType sysEventType) {
        Long id = sysEventType.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysEventType", sysEventType);
        } else {
            getSqlMapClientTemplate().update("updateSysEventType", sysEventType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysEventType.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysEventTypeDao#removeSysEventType(Long id)
     */
    public void removeSysEventType(Long id) {
        getSqlMapClientTemplate().update("deleteSysEventType", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysEventTypeDAO#removeSysEventTypes(String ids)
     */
    public void removeSysEventTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysEventTypes", idList);
    }    
}
