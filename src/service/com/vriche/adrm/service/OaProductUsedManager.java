
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaProductUsed;
import com.vriche.adrm.dao.OaProductUsedDao;

public interface OaProductUsedManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaProductUsedDao(OaProductUsedDao oaProductUsedDAO);

    /**
     * Retrieves all of the oaProductUseds
     */
    public List getOaProductUseds(OaProductUsed oaProductUsed);
     /**
     * Retrieves all of the oaProductUsedsCount
     */
    public String getOaProductUsedsCount(OaProductUsed oaProductUsed);
     /**
     * Retrieves all of the oaProductUsedsCount
     */    
    public PaginatedList getOaProductUsedsPage(OaProductUsed oaProductUsed,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaProductUsedsByIdList
     */
    public List getOaProductUsedsByIdList(final Map idList);

    /**
     * Gets oaProductUsed's information based on id.
     * @param id the oaProductUsed's id
     * @return oaProductUsed populated oaProductUsed object
     */
    public OaProductUsed getOaProductUsed(final String id);

    /**
     * Saves a oaProductUsed's information
     * @param oaProductUsed the object to be saved
     */
    public String saveOaProductUsed(OaProductUsed oaProductUsed);

    /**
     * Removes a oaProductUsed from the database by id
     * @param id the oaProductUsed's id
     */
    public void removeOaProductUsed(final String id);
     /**
     * Removes a oaProductUsed from the database by id
     * @param idList
     */
    public void removeOaProductUseds(final Map idList);
}

