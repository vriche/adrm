
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaApplyInfo;
import com.vriche.adrm.dao.OaApplyInfoDao;
import com.vriche.adrm.service.OaApplyInfoManager;

public class OaApplyInfoManagerImpl extends BaseManager implements OaApplyInfoManager {
    private OaApplyInfoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaApplyInfoDao(OaApplyInfoDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#getOaApplyInfos(com.vriche.adrm.model.OaApplyInfo)
     */
    public List getOaApplyInfos(final OaApplyInfo oaApplyInfo) {
        return dao.getOaApplyInfos(oaApplyInfo);
    }
   /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#getOaApplyInfosCount(com.vriche.adrm.model.OaApplyInfo)
     */
    public String getOaApplyInfosCount(final OaApplyInfo oaApplyInfo) {
        return dao.getOaApplyInfosCount(oaApplyInfo).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#getOaApplyInfosCount(com.vriche.adrm.model.OaApplyInfo)
     */    
	public PaginatedList getOaApplyInfosPage(final OaApplyInfo oaApplyInfo,String pageIndex, String pageSize) {
		return dao.getOaApplyInfosPage(oaApplyInfo,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#getOaApplyInfo(String id)
     */
    public OaApplyInfo getOaApplyInfo(final String id) {
        return dao.getOaApplyInfo(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#getOaApplyInfosByIdList(final Map idList)
     */
    public List getOaApplyInfosByIdList(final Map idList) {
        return dao.getOaApplyInfosByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#saveOaApplyInfo(OaApplyInfo oaApplyInfo)
     */
    public String saveOaApplyInfo(OaApplyInfo oaApplyInfo) {
        return dao.saveOaApplyInfo(oaApplyInfo).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#removeOaApplyInfo(String id)
     */
    public void removeOaApplyInfo(final String id) {
        dao.removeOaApplyInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaApplyInfoManager#removeOaApplyInfos(String Map)
     */
    public void removeOaApplyInfos(final Map idList) {
        dao.removeOaApplyInfos(idList);
    }    
}
