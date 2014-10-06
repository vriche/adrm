
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaProductInfo;
import com.vriche.adrm.dao.OaProductInfoDao;
import com.vriche.adrm.service.OaProductInfoManager;

public class OaProductInfoManagerImpl extends BaseManager implements OaProductInfoManager {
    private OaProductInfoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaProductInfoDao(OaProductInfoDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaProductInfoManager#getOaProductInfos(com.vriche.adrm.model.OaProductInfo)
     */
    public List getOaProductInfos(final OaProductInfo oaProductInfo) {
        return dao.getOaProductInfos(oaProductInfo);
    }
   /**
     * @see com.vriche.adrm.service.OaProductInfoManager#getOaProductInfosCount(com.vriche.adrm.model.OaProductInfo)
     */
    public String getOaProductInfosCount(final OaProductInfo oaProductInfo) {
        return dao.getOaProductInfosCount(oaProductInfo).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaProductInfoManager#getOaProductInfosCount(com.vriche.adrm.model.OaProductInfo)
     */    
	public PaginatedList getOaProductInfosPage(final OaProductInfo oaProductInfo,String pageIndex, String pageSize) {
		return dao.getOaProductInfosPage(oaProductInfo,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaProductInfoManager#getOaProductInfo(String id)
     */
    public OaProductInfo getOaProductInfo(final String id) {
        return dao.getOaProductInfo(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaProductInfoManager#getOaProductInfosByIdList(final Map idList)
     */
    public List getOaProductInfosByIdList(final Map idList) {
        return dao.getOaProductInfosByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaProductInfoManager#saveOaProductInfo(OaProductInfo oaProductInfo)
     */
    public String saveOaProductInfo(OaProductInfo oaProductInfo) {
        return dao.saveOaProductInfo(oaProductInfo).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaProductInfoManager#removeOaProductInfo(String id)
     */
    public void removeOaProductInfo(final String id) {
        dao.removeOaProductInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaProductInfoManager#removeOaProductInfos(String Map)
     */
    public void removeOaProductInfos(final Map idList) {
        dao.removeOaProductInfos(idList);
    }    
}
