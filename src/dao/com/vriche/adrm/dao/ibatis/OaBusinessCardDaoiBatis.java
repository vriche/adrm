
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaBusinessCard;
import com.vriche.adrm.dao.OaBusinessCardDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaBusinessCardDaoiBatis extends BaseDaoiBATIS implements OaBusinessCardDao {

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardDao#getOaBusinessCards(com.vriche.adrm.model.OaBusinessCard)
     */
    public List getOaBusinessCards(final OaBusinessCard oaBusinessCard) {
          return getSqlMapClientTemplate().queryForList("getOaBusinessCards", oaBusinessCard);
    }
     /**
     * @see com.vriche.adrm.dao.OaBusinessCardDao#getOaBusinessCardsCount(com.vriche.adrm.model.OaBusinessCard)
     */
    public Integer getOaBusinessCardsCount(final OaBusinessCard oaBusinessCard) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaBusinessCardsCount", oaBusinessCard);
    }
     /**
     * @see com.vriche.adrm.dao.OaBusinessCardDao#getOaBusinessCardsPage(com.vriche.adrm.model.OaBusinessCard)
     */   
  	public PaginatedList getOaBusinessCardsPage(final OaBusinessCard oaBusinessCard,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaBusinessCards",oaBusinessCard,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaBusinessCardDao#getOaBusinessCardsByIdList(com.vriche.adrm.model.OaBusinessCard)
     */
    public List getOaBusinessCardsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaBusinessCardsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardDao#getOaBusinessCard(Long id)
     */
    public OaBusinessCard getOaBusinessCard(Long id) {
        OaBusinessCard oaBusinessCard = (OaBusinessCard) getSqlMapClientTemplate().queryForObject("getOaBusinessCard", id);

        if (oaBusinessCard == null) {
            throw new ObjectRetrievalFailureException(OaBusinessCard.class, id);
        }

        return oaBusinessCard;
    }

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardDao#saveOaBusinessCard(OaBusinessCard oaBusinessCard)
     */    
    public Long saveOaBusinessCard(final OaBusinessCard oaBusinessCard) {
        Long id = oaBusinessCard.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaBusinessCard", oaBusinessCard);
        } else {
            getSqlMapClientTemplate().update("updateOaBusinessCard", oaBusinessCard);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaBusinessCard.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaBusinessCardDao#removeOaBusinessCard(Long id)
     */
    public void removeOaBusinessCard(Long id) {
        getSqlMapClientTemplate().update("deleteOaBusinessCard", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaBusinessCardDAO#removeOaBusinessCards(String ids)
     */
    public void removeOaBusinessCards(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaBusinessCards", idList);
    }    
}
