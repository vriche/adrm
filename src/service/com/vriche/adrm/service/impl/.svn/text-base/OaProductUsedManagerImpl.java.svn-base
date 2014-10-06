
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaProductUsed;
import com.vriche.adrm.dao.OaProductUsedDao;
import com.vriche.adrm.service.OaProductUsedManager;

public class OaProductUsedManagerImpl extends BaseManager implements OaProductUsedManager {
    private OaProductUsedDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaProductUsedDao(OaProductUsedDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaProductUsedManager#getOaProductUseds(com.vriche.adrm.model.OaProductUsed)
     */
    public List getOaProductUseds(final OaProductUsed oaProductUsed) {
        return dao.getOaProductUseds(oaProductUsed);
    }
   /**
     * @see com.vriche.adrm.service.OaProductUsedManager#getOaProductUsedsCount(com.vriche.adrm.model.OaProductUsed)
     */
    public String getOaProductUsedsCount(final OaProductUsed oaProductUsed) {
        return dao.getOaProductUsedsCount(oaProductUsed).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaProductUsedManager#getOaProductUsedsCount(com.vriche.adrm.model.OaProductUsed)
     */    
	public PaginatedList getOaProductUsedsPage(final OaProductUsed oaProductUsed,String pageIndex, String pageSize) {
		return dao.getOaProductUsedsPage(oaProductUsed,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaProductUsedManager#getOaProductUsed(String id)
     */
    public OaProductUsed getOaProductUsed(final String id) {
        return dao.getOaProductUsed(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaProductUsedManager#getOaProductUsedsByIdList(final Map idList)
     */
    public List getOaProductUsedsByIdList(final Map idList) {
        return dao.getOaProductUsedsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaProductUsedManager#saveOaProductUsed(OaProductUsed oaProductUsed)
     */
    public String saveOaProductUsed(OaProductUsed oaProductUsed) {
        return dao.saveOaProductUsed(oaProductUsed).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaProductUsedManager#removeOaProductUsed(String id)
     */
    public void removeOaProductUsed(final String id) {
        dao.removeOaProductUsed(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaProductUsedManager#removeOaProductUseds(String Map)
     */
    public void removeOaProductUseds(final Map idList) {
        dao.removeOaProductUseds(idList);
    }    
}
