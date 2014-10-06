
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.SysParamDao;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.SysParamManager;

public class SysParamManagerImpl extends BaseManager implements SysParamManager {
    private SysParamDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysParamDao(SysParamDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysParamManager#getSysParams(com.vriche.adrm.model.SysParam)
     */
    public List getSysParams(final SysParam sysParam) {
        return dao.getSysParams(sysParam);
    }
   /**
     * @see com.vriche.adrm.service.SysParamManager#getSysParamsCount(com.vriche.adrm.model.SysParam)
     */
    public String getSysParamsCount(final SysParam sysParam) {
        return dao.getSysParamsCount(sysParam).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysParamManager#getSysParamsCount(com.vriche.adrm.model.SysParam)
     */    
	public PaginatedList getSysParamsPage(final SysParam sysParam,String pageIndex, String pageSize) {
		return dao.getSysParamsPage(sysParam,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysParamManager#getSysParam(String id)
     */
    public SysParam getSysParam(final String id) {
        return dao.getSysParam(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysParamManager#getSysParamsByIdList(final Map idList)
     */
    public List getSysParamsByIdList(final Map idList) {
        return dao.getSysParamsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysParamManager#saveSysParam(SysParam sysParam)
     */
    public String saveSysParam(SysParam sysParam) {
        return dao.saveSysParam(sysParam).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysParamManager#removeSysParam(String id)
     */
    public void removeSysParam(final String id) {
        dao.removeSysParam(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.SysParamManager#removeSysParams(String Map)
     */
    public void removeSysParams(final Map idList) {
        dao.removeSysParams(idList);
    }

	
}
