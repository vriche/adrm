
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.FeedbackInfoDao;
import com.vriche.adrm.model.FeedbackInfo;
import com.vriche.adrm.service.Manager;

public interface FeedbackInfoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setFeedbackInfoDao(FeedbackInfoDao feedbackInfoDAO);

    /**
     * Retrieves all of the feedbackInfos
     */
    public List getFeedbackInfos(FeedbackInfo feedbackInfo);
    
    public PaginatedList getFeedbackInfosPage(FeedbackInfo feedbackInfo,String pageIndex,String pageSize);
    
    public String getFeedbackInfosCount(FeedbackInfo feedbackInfo);

        /**
     * Retrieves all of the feedbackInfosByIdList
     */
    public List getFeedbackInfosByIdList(final Map idList);

    /**
     * Gets feedbackInfo's information based on id.
     * @param id the feedbackInfo's id
     * @return feedbackInfo populated feedbackInfo object
     */
    public FeedbackInfo getFeedbackInfo(final String id);

    /**
     * Saves a feedbackInfo's information
     * @param feedbackInfo the object to be saved
     */
    public void saveFeedbackInfo(FeedbackInfo feedbackInfo);

    /**
     * Removes a feedbackInfo from the database by id
     * @param id the feedbackInfo's id
     */
    public void removeFeedbackInfo(final String id);
     /**
     * Removes a feedbackInfo from the database by id
     * @param idList
     */
    public void removeFeedbackInfos(final Map idList);
    
    public String getFeedbackInfosListXML(FeedbackInfo feedbackInfo);
}

