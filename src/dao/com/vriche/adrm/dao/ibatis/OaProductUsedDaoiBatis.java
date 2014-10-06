
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaProductUsed;
import com.vriche.adrm.dao.OaProductUsedDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductUsedDaoiBatis extends BaseDaoiBATIS implements OaProductUsedDao {

    /**
     * @see com.vriche.adrm.dao.OaProductUsedDao#getOaProductUseds(com.vriche.adrm.model.OaProductUsed)
     */
    public List getOaProductUseds(final OaProductUsed oaProductUsed) {
          return getSqlMapClientTemplate().queryForList("getOaProductUseds", oaProductUsed);
    }
     /**
     * @see com.vriche.adrm.dao.OaProductUsedDao#getOaProductUsedsCount(com.vriche.adrm.model.OaProductUsed)
     */
    public Integer getOaProductUsedsCount(final OaProductUsed oaProductUsed) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaProductUsedsCount", oaProductUsed);
    }
     /**
     * @see com.vriche.adrm.dao.OaProductUsedDao#getOaProductUsedsPage(com.vriche.adrm.model.OaProductUsed)
     */   
  	public PaginatedList getOaProductUsedsPage(final OaProductUsed oaProductUsed,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaProductUseds",oaProductUsed,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaProductUsedDao#getOaProductUsedsByIdList(com.vriche.adrm.model.OaProductUsed)
     */
    public List getOaProductUsedsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaProductUsedsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaProductUsedDao#getOaProductUsed(Long id)
     */
    public OaProductUsed getOaProductUsed(Long id) {
        OaProductUsed oaProductUsed = (OaProductUsed) getSqlMapClientTemplate().queryForObject("getOaProductUsed", id);

        if (oaProductUsed == null) {
            throw new ObjectRetrievalFailureException(OaProductUsed.class, id);
        }

        return oaProductUsed;
    }

    /**
     * @see com.vriche.adrm.dao.OaProductUsedDao#saveOaProductUsed(OaProductUsed oaProductUsed)
     */    
    public Long saveOaProductUsed(final OaProductUsed oaProductUsed) {
        Long id = oaProductUsed.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaProductUsed", oaProductUsed);
        } else {
            getSqlMapClientTemplate().update("updateOaProductUsed", oaProductUsed);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaProductUsed.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaProductUsedDao#removeOaProductUsed(Long id)
     */
    public void removeOaProductUsed(Long id) {
        getSqlMapClientTemplate().update("deleteOaProductUsed", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaProductUsedDAO#removeOaProductUseds(String ids)
     */
    public void removeOaProductUseds(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaProductUseds", idList);
    }    
}
