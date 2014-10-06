
package com.vriche.adrm.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.PublishedInfoDao;
import com.vriche.adrm.model.PublishedInfo;
import com.vriche.adrm.service.PublishedInfoManager;

public class PublishedInfoManagerImpl extends BaseManager implements PublishedInfoManager {
    private PublishedInfoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setPublishedInfoDao(PublishedInfoDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishedInfoManager#getPublishedInfosByIdList(final Map idList)
     */
    public List getPublishedInfosByIdList(final Map idList) {
        return dao.getPublishedInfosByIdList(idList);
    }
    
    
   public List getPublishedInfosByHistory(String resourceIds, String publishDate) {
	   return dao.getPublishedInfosByHistory(resourceIds,publishDate);
	}


   public Collection getPublishedInfosByHistoryColl(String resourceIds, String publishDate) {
	   return dao.getPublishedInfosByHistoryColl(resourceIds,publishDate);
   }

   public String getPublishedInfosByResourceIdsXML(String ResourceIds, String publishDate,int model) {
	   return dao.getPublishedInfosByResourceIdsXML(ResourceIds,publishDate,model);
	}

	public String getInfosByResourceIdsXML(String ResourceIds, String publishDate, int model) {
		// TODO Auto-generated method stub
		return dao.getInfosByResourceIdsXML(ResourceIds,publishDate,model);
	}   
   
/**
     * @see com.vriche.adrm.adver.service.PublishedInfoManager#getPublishedInfos(com.vriche.adrm.adver.model.PublishedInfo)
     */
    public List getPublishedInfos(final PublishedInfo publishedInfo) {
        return dao.getPublishedInfos(publishedInfo);
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishedInfoManager#getPublishedInfo(String id)
     */
    public PublishedInfo getPublishedInfo(final String id) {
        return dao.getPublishedInfo(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishedInfoManager#savePublishedInfo(PublishedInfo publishedInfo)
     */
    public void savePublishedInfo(PublishedInfo publishedInfo) {
        dao.savePublishedInfo(publishedInfo);
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishedInfoManager#removePublishedInfo(String id)
     */
    public void removePublishedInfo(final String id) {
        dao.removePublishedInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adver.service.PublishedInfoManager#removePublishedInfos(String Map)
     */
    public void removePublishedInfos(final Map idList) {
        dao.removePublishedInfos(idList);
    }

	public void removePublishedInfosByResDate(String resourceIds, String publishDate) {
		 dao.removePublishedInfosByResDate(resourceIds,publishDate);
		
	}

	public Integer getPublishedCount(String resourceIds, String publishDate) {
		return dao.getPublishedCount(resourceIds,publishDate);
	}

	public Collection getInfosByHistoryColl(String resourceIds, String publishDate) {
		return dao.getInfosByHistoryColl(resourceIds,publishDate);
	}

    
}
