
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaBusinessCard;

public interface OaBusinessCardDao extends Dao {

    /**
     * Retrieves all of the oaBusinessCards
     */
    public List getOaBusinessCards(OaBusinessCard oaBusinessCard);
    /**
     * Retrieves all of the getOaBusinessCardsCount
     */
    public Integer getOaBusinessCardsCount(OaBusinessCard oaBusinessCard);   
    /**
     * Retrieves all of the getOaBusinessCardsPage
     */        
    public PaginatedList getOaBusinessCardsPage(OaBusinessCard oaBusinessCard,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaBusinessCardsByIdList
     */
    public List getOaBusinessCardsByIdList(final Map idList);

    /**
     * Gets oaBusinessCard's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaBusinessCard's id
     * @return oaBusinessCard populated oaBusinessCard object
     */
    public OaBusinessCard getOaBusinessCard(final Long id);

    /**
     * Saves a oaBusinessCard's information
     * @param oaBusinessCard the object to be saved
     */    
    public Long saveOaBusinessCard(OaBusinessCard oaBusinessCard);

    /**
     * Removes a oaBusinessCard from the database by id
     * @param id the oaBusinessCard's id
     */
    public void removeOaBusinessCard(final Long id);
	/**
     * Removes oaBusinessCards from the database by ids
     * @param ids the oaBusinessCard's id eg:"'1','2','3'"
     */
    public void removeOaBusinessCards(final Map idList);
}

