
package com.vriche.adrm.dao.ibatis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.dao.SysParamDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysParamDaoiBatis extends BaseDaoiBATIS implements SysParamDao {

    /**
     * @see com.vriche.adrm.dao.SysParamDao#getSysParams(com.vriche.adrm.model.SysParam)
     */
    public List getSysParams(final SysParam sysParam) {
          return getSqlMapClientTemplate().queryForList("getSysParams", sysParam);
    }
     /**
     * @see com.vriche.adrm.dao.SysParamDao#getSysParamsCount(com.vriche.adrm.model.SysParam)
     */
    public Integer getSysParamsCount(final SysParam sysParam) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getSysParamsCount", sysParam);
    }
     /**
     * @see com.vriche.adrm.dao.SysParamDao#getSysParamsPage(com.vriche.adrm.model.SysParam)
     */   
  	public PaginatedList getSysParamsPage(final SysParam sysParam,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getSysParams",sysParam,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.SysParamDao#getSysParamsByIdList(com.vriche.adrm.model.SysParam)
     */
    public List getSysParamsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getSysParamsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.SysParamDao#getSysParam(Long id)
     */
    public SysParam getSysParam(Long id) {
        SysParam sysParam = (SysParam) getSqlMapClientTemplate().queryForObject("getSysParam", id);

        if (sysParam == null) {
            throw new ObjectRetrievalFailureException(SysParam.class, id);
        }

        return sysParam;
    }
    
    
    public SysParam getSysParam(final SysParam param) {
        List ls  = this.getSysParams(param);
        SysParam sysParam = new SysParam();

        if(ls.size()>0) sysParam = (SysParam)ls.get(0);

        return sysParam;
    }
    

    /**
     * @see com.vriche.adrm.dao.SysParamDao#saveSysParam(SysParam sysParam)
     */    
    public Long saveSysParam(final SysParam sysParam) {
        Long id = sysParam.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addSysParam", sysParam);
        } else {
            getSqlMapClientTemplate().update("updateSysParam", sysParam);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(SysParam.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.SysParamDao#removeSysParam(Long id)
     */
    public void removeSysParam(Long id) {
        getSqlMapClientTemplate().update("deleteSysParam", id);
    }
    /**
     * @see com.vriche.adrm.dao.SysParamDAO#removeSysParams(String ids)
     */
    public void removeSysParams(final Map idList) {
        getSqlMapClientTemplate().update("deleteSysParams", idList);
    }
    
	public void saveSysParamByTarger(SysParam sysParam) {
		getSqlMapClientTemplate().insert("addSysParamByTarger", sysParam);
	}    
}
