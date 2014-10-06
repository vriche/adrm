
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.MatterType;
import com.vriche.adrm.model.OaInfo;
import com.vriche.adrm.dao.OaInfoDao;
import com.vriche.adrm.service.OaInfoManager;

public class OaInfoManagerImpl extends BaseManager implements OaInfoManager {
    private OaInfoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaInfoDao(OaInfoDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaInfoManager#getOaInfos(com.vriche.adrm.model.OaInfo)
     */
    public List getOaInfos(final OaInfo oaInfo) {
        return dao.getOaInfos(oaInfo);
    }
   /**
     * @see com.vriche.adrm.service.OaInfoManager#getOaInfosCount(com.vriche.adrm.model.OaInfo)
     */
    public String getOaInfosCount(final OaInfo oaInfo) {
        return dao.getOaInfosCount(oaInfo).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaInfoManager#getOaInfosCount(com.vriche.adrm.model.OaInfo)
     */    
	public PaginatedList getOaInfosPage(final OaInfo oaInfo,String pageIndex, String pageSize) {
		return dao.getOaInfosPage(oaInfo,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaInfoManager#getOaInfo(String id)
     */
    public OaInfo getOaInfo(final String id) {
        return dao.getOaInfo(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaInfoManager#getOaInfosByIdList(final Map idList)
     */
    public List getOaInfosByIdList(final Map idList) {
        return dao.getOaInfosByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaInfoManager#saveOaInfo(OaInfo oaInfo)
     */
    public String saveOaInfo(OaInfo oaInfo) {
        return dao.saveOaInfo(oaInfo).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaInfoManager#removeOaInfo(String id)
     */
    public void removeOaInfo(final String id) {
        dao.removeOaInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaInfoManager#removeOaInfos(String Map)
     */
    public void removeOaInfos(final Map idList) {
        dao.removeOaInfos(idList);
    }
	public Map getOaInfoSelect(OaInfo oaInfo) {
		// TODO Auto-generated method stub
		List ls = this.getOaInfos(oaInfo);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	
	    	OaInfo oaInfos  =(OaInfo)it.next();
	    	
	    	
	    	reply.put(oaInfos.getId(),oaInfos.getTitle());
	    }
	   
		return reply;
	}    
}
