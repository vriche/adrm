
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysEventState;
import com.vriche.adrm.dao.SysEventStateDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventStateDaoiBatis extends BaseDaoiBATIS implements SysEventStateDao {

    /**
     * @see com.vriche.adrm.dao.SysEventStateDao#getSysEventStates(com.vriche.adrm.model.SysEventState)
     */
    public List getSysEventStates(final SysEventState sysEventState) {
          return getSqlMapClientTemplate().queryForList("getSysEventStates", sysEventState);
    }
     /**
     * @see com.vriche.adrm.dao.SysEventStateDao#getSysEventStatesCount(com.vriche.adrm.model.SysEventState)
     */
    public Integer getSysEventStatesCount(final SysEventState sysEventState) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysEventStatesCount", sysEventState);
    }
     /**
     * @see com.vriche.adrm.dao.SysEventStateDao#getSysEventStatesPage(com.vriche.adrm.model.SysEventState)
     */   
  	public PaginatedList getSysEventStatesPage(final SysEventState sysEventState,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysEventStates",sysEventState,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysEventStateDao#getSysEventStatesByIdList(com.vriche.adrm.model.SysEventState)
     */
    public List getSysEventStatesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysEventStatesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysEventStateDao#getSysEventState(Long id)
     */
    public SysEventState getSysEventState(Long id) {
        SysEventState sysEventState = (SysEventState) getSqlMapClientTemplate().queryForObject("getSysEventState", id);

        if (sysEventState == null) {
            throw new ObjectRetrievalFailureException(SysEventState.class, id);
        }

        return sysEventState;
    }

    /**
     * @see com.vriche.adrm.dao.SysEventStateDao#saveSysEventState(SysEventState sysEventState)
     */    
    public Long saveSysEventState(final SysEventState sysEventState) {
        Long id = sysEventState.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysEventState", sysEventState);
        } else {
            getSqlMapClientTemplate().update("updateSysEventState", sysEventState);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysEventState.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysEventStateDao#removeSysEventState(Long id)
     */
    public void removeSysEventState(Long id) {
        getSqlMapClientTemplate().update("deleteSysEventState", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysEventStateDAO#removeSysEventStates(String ids)
     */
    public void removeSysEventStates(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysEventStates", idList);
    }    
}
