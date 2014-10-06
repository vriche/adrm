
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.FeedbackInfo;

public interface FeedbackInfoDao extends Dao {

    /**
     * Retrieves all of the feedbackInfos
     */
    public List getFeedbackInfos(FeedbackInfo feedbackInfo);
    
    public PaginatedList getFeedbackInfosPage(FeedbackInfo feedbackInfo,int pageIndex,int pageSize);
    
    public Integer getFeedbackInfosCount(FeedbackInfo feedbackInfo);

    /**
     * Retrieves all of the feedbackInfosByIdList
     */
    public List getFeedbackInfosByIdList(final Map idList);

    /**
     * Gets feedbackInfo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the feedbackInfo's id
     * @return feedbackInfo populated feedbackInfo object
     */
    public FeedbackInfo getFeedbackInfo(final Long id);

    /**
     * Saves a feedbackInfo's information
     * @param feedbackInfo the object to be saved
     */    
    public void saveFeedbackInfo(FeedbackInfo feedbackInfo);

    /**
     * Removes a feedbackInfo from the database by id
     * @param id the feedbackInfo's id
     */
    public void removeFeedbackInfo(final Long id);
	/**
     * Removes feedbackInfos from the database by ids
     * @param ids the feedbackInfo's id eg:"'1','2','3'"
     */
    public void removeFeedbackInfos(final Map idList);
    
    public List getFeedbackInfosListPage(FeedbackInfo feedbackInfo);
}

