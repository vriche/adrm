
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.FeedbackInfoDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.FeedbackInfo;

import org.springframework.orm.ObjectRetrievalFailureException;

public class FeedbackInfoDaoiBatis extends BaseDaoiBATIS implements FeedbackInfoDao {

    /**
     * @see com.vriche.adrm.crm.dao.FeedbackInfoDao#getFeedbackInfos(com.vriche.adrm.crm.model.FeedbackInfo)
     */
    public List getFeedbackInfos(final FeedbackInfo feedbackInfo) {
          return getSqlMapClientTemplate().queryForList("getFeedbackInfos", feedbackInfo);
    }
    
    
    
    public Integer getFeedbackInfosCount(FeedbackInfo feedbackInfo) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("getFeedbackInfosCount", feedbackInfo);
	}



	public PaginatedList getFeedbackInfosPage(FeedbackInfo feedbackInfo, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getFeedbackInfos",feedbackInfo,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}

	public List getFeedbackInfosListPage(FeedbackInfo feedbackInfo) {
		 return getSqlMapClientTemplate().queryForList("getFeedbackInfos",feedbackInfo);
	}

	/**
     * @see com.vriche.adrm.crm.dao.FeedbackInfoDao#getFeedbackInfosByIdList(com.vriche.adrm.crm.model.FeedbackInfo)
     */
    public List getFeedbackInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getFeedbackInfosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.FeedbackInfoDao#getFeedbackInfo(Long id)
     */
    public FeedbackInfo getFeedbackInfo(Long id) {
        FeedbackInfo feedbackInfo = (FeedbackInfo) getSqlMapClientTemplate().queryForObject("getFeedbackInfo", id);

        if (feedbackInfo == null) {
            throw new ObjectRetrievalFailureException(FeedbackInfo.class, id);
        }

        return feedbackInfo;
    }

    /**
     * @see com.vriche.adrm.crm.dao.FeedbackInfoDao#saveFeedbackInfo(FeedbackInfo feedbackInfo)
     */    
    public void saveFeedbackInfo(final FeedbackInfo feedbackInfo) {
        Long id = feedbackInfo.getId();
        // check for new record
        if (id == null || id.intValue() == -1) {
            id = (Long) getSqlMapClientTemplate().insert("addFeedbackInfo", feedbackInfo);
        } else {
            getSqlMapClientTemplate().update("updateFeedbackInfo", feedbackInfo);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(FeedbackInfo.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.crm.dao.FeedbackInfoDao#removeFeedbackInfo(Long id)
     */
    public void removeFeedbackInfo(Long id) {
        getSqlMapClientTemplate().update("deleteFeedbackInfo", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.FeedbackInfoDAO#removeFeedbackInfos(String ids)
     */
    public void removeFeedbackInfos(final Map idList) {
        getSqlMapClientTemplate().update("deleteFeedbackInfos", idList);
    }    
}
