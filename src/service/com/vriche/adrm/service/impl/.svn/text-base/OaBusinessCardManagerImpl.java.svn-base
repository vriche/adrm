
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaBusinessCard;
import com.vriche.adrm.dao.OaBusinessCardDao;
import com.vriche.adrm.service.OaBusinessCardManager;

public class OaBusinessCardManagerImpl extends BaseManager implements OaBusinessCardManager {
    private OaBusinessCardDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaBusinessCardDao(OaBusinessCardDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#getOaBusinessCards(com.vriche.adrm.model.OaBusinessCard)
     */
    public List getOaBusinessCards(final OaBusinessCard oaBusinessCard) {
        return dao.getOaBusinessCards(oaBusinessCard);
    }
   /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#getOaBusinessCardsCount(com.vriche.adrm.model.OaBusinessCard)
     */
    public String getOaBusinessCardsCount(final OaBusinessCard oaBusinessCard) {
        return dao.getOaBusinessCardsCount(oaBusinessCard).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#getOaBusinessCardsCount(com.vriche.adrm.model.OaBusinessCard)
     */    
	public PaginatedList getOaBusinessCardsPage(final OaBusinessCard oaBusinessCard,String pageIndex, String pageSize) {
		return dao.getOaBusinessCardsPage(oaBusinessCard,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#getOaBusinessCard(String id)
     */
    public OaBusinessCard getOaBusinessCard(final String id) {
        return dao.getOaBusinessCard(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#getOaBusinessCardsByIdList(final Map idList)
     */
    public List getOaBusinessCardsByIdList(final Map idList) {
        return dao.getOaBusinessCardsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#saveOaBusinessCard(OaBusinessCard oaBusinessCard)
     */
    public String saveOaBusinessCard(OaBusinessCard oaBusinessCard) {
        return dao.saveOaBusinessCard(oaBusinessCard).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#removeOaBusinessCard(String id)
     */
    public void removeOaBusinessCard(final String id) {
        dao.removeOaBusinessCard(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaBusinessCardManager#removeOaBusinessCards(String Map)
     */
    public void removeOaBusinessCards(final Map idList) {
        dao.removeOaBusinessCards(idList);
    }    
}
