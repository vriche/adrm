
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysPromptMode;
import com.vriche.adrm.dao.SysPromptModeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysPromptModeDaoiBatis extends BaseDaoiBATIS implements SysPromptModeDao {

    /**
     * @see com.vriche.adrm.dao.SysPromptModeDao#getSysPromptModes(com.vriche.adrm.model.SysPromptMode)
     */
    public List getSysPromptModes(final SysPromptMode sysPromptMode) {
          return getSqlMapClientTemplate().queryForList("getSysPromptModes", sysPromptMode);
    }
     /**
     * @see com.vriche.adrm.dao.SysPromptModeDao#getSysPromptModesCount(com.vriche.adrm.model.SysPromptMode)
     */
    public Integer getSysPromptModesCount(final SysPromptMode sysPromptMode) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysPromptModesCount", sysPromptMode);
    }
     /**
     * @see com.vriche.adrm.dao.SysPromptModeDao#getSysPromptModesPage(com.vriche.adrm.model.SysPromptMode)
     */   
  	public PaginatedList getSysPromptModesPage(final SysPromptMode sysPromptMode,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysPromptModes",sysPromptMode,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysPromptModeDao#getSysPromptModesByIdList(com.vriche.adrm.model.SysPromptMode)
     */
    public List getSysPromptModesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysPromptModesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysPromptModeDao#getSysPromptMode(Long id)
     */
    public SysPromptMode getSysPromptMode(Long id) {
        SysPromptMode sysPromptMode = (SysPromptMode) getSqlMapClientTemplate().queryForObject("getSysPromptMode", id);

        if (sysPromptMode == null) {
            throw new ObjectRetrievalFailureException(SysPromptMode.class, id);
        }

        return sysPromptMode;
    }

    /**
     * @see com.vriche.adrm.dao.SysPromptModeDao#saveSysPromptMode(SysPromptMode sysPromptMode)
     */    
    public Long saveSysPromptMode(final SysPromptMode sysPromptMode) {
        Long id = sysPromptMode.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysPromptMode", sysPromptMode);
        } else {
            getSqlMapClientTemplate().update("updateSysPromptMode", sysPromptMode);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysPromptMode.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysPromptModeDao#removeSysPromptMode(Long id)
     */
    public void removeSysPromptMode(Long id) {
        getSqlMapClientTemplate().update("deleteSysPromptMode", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysPromptModeDAO#removeSysPromptModes(String ids)
     */
    public void removeSysPromptModes(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysPromptModes", idList);
    }    
}
