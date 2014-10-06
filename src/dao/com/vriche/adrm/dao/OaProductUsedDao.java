
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaProductUsed;

public interface OaProductUsedDao extends Dao {

    /**
     * Retrieves all of the oaProductUseds
     */
    public List getOaProductUseds(OaProductUsed oaProductUsed);
    /**
     * Retrieves all of the getOaProductUsedsCount
     */
    public Integer getOaProductUsedsCount(OaProductUsed oaProductUsed);   
    /**
     * Retrieves all of the getOaProductUsedsPage
     */        
    public PaginatedList getOaProductUsedsPage(OaProductUsed oaProductUsed,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaProductUsedsByIdList
     */
    public List getOaProductUsedsByIdList(final Map idList);

    /**
     * Gets oaProductUsed's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaProductUsed's id
     * @return oaProductUsed populated oaProductUsed object
     */
    public OaProductUsed getOaProductUsed(final Long id);

    /**
     * Saves a oaProductUsed's information
     * @param oaProductUsed the object to be saved
     */    
    public Long saveOaProductUsed(OaProductUsed oaProductUsed);

    /**
     * Removes a oaProductUsed from the database by id
     * @param id the oaProductUsed's id
     */
    public void removeOaProductUsed(final Long id);
	/**
     * Removes oaProductUseds from the database by ids
     * @param ids the oaProductUsed's id eg:"'1','2','3'"
     */
    public void removeOaProductUseds(final Map idList);
}

