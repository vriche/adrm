
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaAssets;
import com.vriche.adrm.dao.OaAssetsDao;
import com.vriche.adrm.service.OaAssetsManager;

public class OaAssetsManagerImpl extends BaseManager implements OaAssetsManager {
    private OaAssetsDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaAssetsDao(OaAssetsDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaAssetsManager#getOaAssetss(com.vriche.adrm.model.OaAssets)
     */
    public List getOaAssetss(final OaAssets oaAssets) {
        return dao.getOaAssetss(oaAssets);
    }
   /**
     * @see com.vriche.adrm.service.OaAssetsManager#getOaAssetssCount(com.vriche.adrm.model.OaAssets)
     */
    public String getOaAssetssCount(final OaAssets oaAssets) {
        return dao.getOaAssetssCount(oaAssets).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaAssetsManager#getOaAssetssCount(com.vriche.adrm.model.OaAssets)
     */    
	public PaginatedList getOaAssetssPage(final OaAssets oaAssets,String pageIndex, String pageSize) {
		return dao.getOaAssetssPage(oaAssets,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaAssetsManager#getOaAssets(String id)
     */
    public OaAssets getOaAssets(final String id) {
        return dao.getOaAssets(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaAssetsManager#getOaAssetssByIdList(final Map idList)
     */
    public List getOaAssetssByIdList(final Map idList) {
        return dao.getOaAssetssByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaAssetsManager#saveOaAssets(OaAssets oaAssets)
     */
    public String saveOaAssets(OaAssets oaAssets) {
        return dao.saveOaAssets(oaAssets).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaAssetsManager#removeOaAssets(String id)
     */
    public void removeOaAssets(final String id) {
        dao.removeOaAssets(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaAssetsManager#removeOaAssetss(String Map)
     */
    public void removeOaAssetss(final Map idList) {
        dao.removeOaAssetss(idList);
    }    
}
