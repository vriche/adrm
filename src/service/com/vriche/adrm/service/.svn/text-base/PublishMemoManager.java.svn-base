
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PublishMemoDao;
import com.vriche.adrm.model.Brand;
import com.vriche.adrm.model.PublishMemo;
import com.vriche.adrm.service.Manager;

public interface PublishMemoManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPublishMemoDao(PublishMemoDao publishMemoDAO);

    /**
     * Retrieves all of the publishMemos
     */
    public List getPublishMemos(PublishMemo publishMemo);
        /**
     * Retrieves all of the publishMemosByIdList
     */
    public List getPublishMemosByIdList(final Map idList);

    /**
     * Gets publishMemo's information based on id.
     * @param id the publishMemo's id
     * @return publishMemo populated publishMemo object
     */
    public PublishMemo getPublishMemo(final String id);

    /**
     * Saves a publishMemo's information
     * @param publishMemo the object to be saved
     */
    public void savePublishMemo(PublishMemo publishMemo);

    /**
     * Removes a publishMemo from the database by id
     * @param id the publishMemo's id
     */
    public void removePublishMemo(final String id);
     /**
     * Removes a publishMemo from the database by id
     * @param idList
     */
    public void removePublishMemos(final Map idList);
    
    public PaginatedList getPublishMemosPage(PublishMemo publishMemo,String pageIndex,String pageSize);
    
    public String getPublishMemosCount(PublishMemo publishMemo);
}

