
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaAreaPc;
import com.vriche.adrm.dao.OaAreaPcDao;
import com.vriche.adrm.service.OaAreaPcManager;

public class OaAreaPcManagerImpl extends BaseManager implements OaAreaPcManager {
    private OaAreaPcDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaAreaPcDao(OaAreaPcDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaAreaPcManager#getOaAreaPcs(com.vriche.adrm.model.OaAreaPc)
     */
    public List getOaAreaPcs(final OaAreaPc oaAreaPc) {
        return dao.getOaAreaPcs(oaAreaPc);
    }
   /**
     * @see com.vriche.adrm.service.OaAreaPcManager#getOaAreaPcsCount(com.vriche.adrm.model.OaAreaPc)
     */
    public String getOaAreaPcsCount(final OaAreaPc oaAreaPc) {
        return dao.getOaAreaPcsCount(oaAreaPc).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaAreaPcManager#getOaAreaPcsCount(com.vriche.adrm.model.OaAreaPc)
     */    
	public PaginatedList getOaAreaPcsPage(final OaAreaPc oaAreaPc,String pageIndex, String pageSize) {
		return dao.getOaAreaPcsPage(oaAreaPc,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaAreaPcManager#getOaAreaPc(String id)
     */
    public OaAreaPc getOaAreaPc(final String id) {
        return dao.getOaAreaPc(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaAreaPcManager#getOaAreaPcsByIdList(final Map idList)
     */
    public List getOaAreaPcsByIdList(final Map idList) {
        return dao.getOaAreaPcsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaAreaPcManager#saveOaAreaPc(OaAreaPc oaAreaPc)
     */
    public String saveOaAreaPc(OaAreaPc oaAreaPc) {
        return dao.saveOaAreaPc(oaAreaPc).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaAreaPcManager#removeOaAreaPc(String id)
     */
    public void removeOaAreaPc(final String id) {
        dao.removeOaAreaPc(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaAreaPcManager#removeOaAreaPcs(String Map)
     */
    public void removeOaAreaPcs(final Map idList) {
        dao.removeOaAreaPcs(idList);
    }    
}
