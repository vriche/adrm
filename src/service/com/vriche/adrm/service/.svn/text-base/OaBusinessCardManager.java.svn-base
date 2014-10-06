
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaBusinessCard;
import com.vriche.adrm.dao.OaBusinessCardDao;

public interface OaBusinessCardManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaBusinessCardDao(OaBusinessCardDao oaBusinessCardDAO);

    /**
     * Retrieves all of the oaBusinessCards
     */
    public List getOaBusinessCards(OaBusinessCard oaBusinessCard);
     /**
     * Retrieves all of the oaBusinessCardsCount
     */
    public String getOaBusinessCardsCount(OaBusinessCard oaBusinessCard);
     /**
     * Retrieves all of the oaBusinessCardsCount
     */    
    public PaginatedList getOaBusinessCardsPage(OaBusinessCard oaBusinessCard,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaBusinessCardsByIdList
     */
    public List getOaBusinessCardsByIdList(final Map idList);

    /**
     * Gets oaBusinessCard's information based on id.
     * @param id the oaBusinessCard's id
     * @return oaBusinessCard populated oaBusinessCard object
     */
    public OaBusinessCard getOaBusinessCard(final String id);

    /**
     * Saves a oaBusinessCard's information
     * @param oaBusinessCard the object to be saved
     */
    public String saveOaBusinessCard(OaBusinessCard oaBusinessCard);

    /**
     * Removes a oaBusinessCard from the database by id
     * @param id the oaBusinessCard's id
     */
    public void removeOaBusinessCard(final String id);
     /**
     * Removes a oaBusinessCard from the database by id
     * @param idList
     */
    public void removeOaBusinessCards(final Map idList);
}

