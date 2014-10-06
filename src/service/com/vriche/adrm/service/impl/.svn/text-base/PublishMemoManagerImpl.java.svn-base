
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PublishMemoDao;
import com.vriche.adrm.model.PublishMemo;
import com.vriche.adrm.service.PublishMemoManager;
import com.vriche.adrm.service.impl.BaseManager;

public class PublishMemoManagerImpl extends BaseManager implements PublishMemoManager {
    private PublishMemoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setPublishMemoDao(PublishMemoDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishMemoManager#getPublishMemosByIdList(final Map idList)
     */
    public List getPublishMemosByIdList(final Map idList) {
        return dao.getPublishMemosByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adver.service.PublishMemoManager#getPublishMemos(com.vriche.adrm.adver.model.PublishMemo)
     */
    public List getPublishMemos(final PublishMemo publishMemo) {
        return dao.getPublishMemos(publishMemo);
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishMemoManager#getPublishMemo(String id)
     */
    public PublishMemo getPublishMemo(final String id) {
        return dao.getPublishMemo(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishMemoManager#savePublishMemo(PublishMemo publishMemo)
     */
    public void savePublishMemo(PublishMemo publishMemo) {
        dao.savePublishMemo(publishMemo);
    }

    /**
     * @see com.vriche.adrm.adver.service.PublishMemoManager#removePublishMemo(String id)
     */
    public void removePublishMemo(final String id) {
        dao.removePublishMemo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adver.service.PublishMemoManager#removePublishMemos(String Map)
     */
    public void removePublishMemos(final Map idList) {
        dao.removePublishMemos(idList);
    }

	public PaginatedList getPublishMemosPage(PublishMemo publishMemo, String pageIndex, String pageSize) {
		// TODO Auto-generated method stub
		return dao.getPublishMemosPage(publishMemo,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getPublishMemosCount(PublishMemo publishMemo) {
		// TODO Auto-generated method stub
		return dao.getPublishMemosCount(publishMemo).toString();
	}    
}
