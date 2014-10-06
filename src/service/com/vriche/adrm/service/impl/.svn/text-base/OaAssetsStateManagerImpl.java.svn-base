
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaAssetsState;
import com.vriche.adrm.dao.OaAssetsStateDao;
import com.vriche.adrm.service.OaAssetsStateManager;

public class OaAssetsStateManagerImpl extends BaseManager implements OaAssetsStateManager {
    private OaAssetsStateDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaAssetsStateDao(OaAssetsStateDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#getOaAssetsStates(com.vriche.adrm.model.OaAssetsState)
     */
    public List getOaAssetsStates(final OaAssetsState oaAssetsState) {
        return dao.getOaAssetsStates(oaAssetsState);
    }
   /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#getOaAssetsStatesCount(com.vriche.adrm.model.OaAssetsState)
     */
    public String getOaAssetsStatesCount(final OaAssetsState oaAssetsState) {
        return dao.getOaAssetsStatesCount(oaAssetsState).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#getOaAssetsStatesCount(com.vriche.adrm.model.OaAssetsState)
     */    
	public PaginatedList getOaAssetsStatesPage(final OaAssetsState oaAssetsState,String pageIndex, String pageSize) {
		return dao.getOaAssetsStatesPage(oaAssetsState,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#getOaAssetsState(String id)
     */
    public OaAssetsState getOaAssetsState(final String id) {
        return dao.getOaAssetsState(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#getOaAssetsStatesByIdList(final Map idList)
     */
    public List getOaAssetsStatesByIdList(final Map idList) {
        return dao.getOaAssetsStatesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#saveOaAssetsState(OaAssetsState oaAssetsState)
     */
    public String saveOaAssetsState(OaAssetsState oaAssetsState) {
        return dao.saveOaAssetsState(oaAssetsState).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#removeOaAssetsState(String id)
     */
    public void removeOaAssetsState(final String id) {
        dao.removeOaAssetsState(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaAssetsStateManager#removeOaAssetsStates(String Map)
     */
    public void removeOaAssetsStates(final Map idList) {
        dao.removeOaAssetsStates(idList);
    }    
}
