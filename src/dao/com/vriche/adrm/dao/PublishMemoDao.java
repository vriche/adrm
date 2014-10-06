
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.PublishMemo;

public interface PublishMemoDao extends Dao {

    /**
     * Retrieves all of the publishMemos
     */
    public List getPublishMemos(PublishMemo publishMemo);

    /**
     * Retrieves all of the publishMemosByIdList
     */
    public List getPublishMemosByIdList(final Map idList);

    /**
     * Gets publishMemo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the publishMemo's id
     * @return publishMemo populated publishMemo object
     */
    public PublishMemo getPublishMemo(final Long id);

    /**
     * Saves a publishMemo's information
     * @param publishMemo the object to be saved
     */    
    public void savePublishMemo(PublishMemo publishMemo);

    /**
     * Removes a publishMemo from the database by id
     * @param id the publishMemo's id
     */
    public void removePublishMemo(final Long id);
	/**
     * Removes publishMemos from the database by ids
     * @param ids the publishMemo's id eg:"'1','2','3'"
     */
    public void removePublishMemos(final Map idList);

    public PaginatedList getPublishMemosPage(PublishMemo publishMemo,int pageIndex,int pageSize);
    
    public Integer getPublishMemosCount(PublishMemo publishMemo);
}

