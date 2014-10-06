
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.dao.PublishArrangeDetailDao;
import com.vriche.adrm.service.PublishArrangeDetailManager;

public class PublishArrangeDetailManagerImpl extends BaseManager implements PublishArrangeDetailManager {
    private PublishArrangeDetailDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setPublishArrangeDetailDao(PublishArrangeDetailDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#getPublishArrangeDetails(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public List getPublishArrangeDetails(final PublishArrangeDetail publishArrangeDetail) {
        return dao.getPublishArrangeDetails(publishArrangeDetail);
    }
   /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#getPublishArrangeDetailsCount(com.vriche.adrm.model.PublishArrangeDetail)
     */
    public String getPublishArrangeDetailsCount(final PublishArrangeDetail publishArrangeDetail) {
        return dao.getPublishArrangeDetailsCount(publishArrangeDetail).toString();
    }    

   /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#getPublishArrangeDetailsCount(com.vriche.adrm.model.PublishArrangeDetail)
     */    
	public PaginatedList getPublishArrangeDetailsPage(final PublishArrangeDetail publishArrangeDetail,String pageIndex, String pageSize) {
		return dao.getPublishArrangeDetailsPage(publishArrangeDetail,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#getPublishArrangeDetail(String id)
     */
    public PublishArrangeDetail getPublishArrangeDetail(final String id) {
        return dao.getPublishArrangeDetail(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#getPublishArrangeDetailsByIdList(final Map idList)
     */
    public List getPublishArrangeDetailsByIdList(final Map idList) {
        return dao.getPublishArrangeDetailsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#savePublishArrangeDetail(PublishArrangeDetail publishArrangeDetail)
     */
    public String savePublishArrangeDetail(PublishArrangeDetail publishArrangeDetail) {
        return dao.savePublishArrangeDetail(publishArrangeDetail).toString();
    }

    /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#removePublishArrangeDetail(String id)
     */
    public void removePublishArrangeDetail(final String id) {
        dao.removePublishArrangeDetail(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.PublishArrangeDetailManager#removePublishArrangeDetails(String Map)
     */
    public void removePublishArrangeDetails(final Map idList) {
        dao.removePublishArrangeDetails(idList);
    }    
}
