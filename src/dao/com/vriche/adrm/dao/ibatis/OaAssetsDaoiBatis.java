
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaAssets;
import com.vriche.adrm.dao.OaAssetsDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsDaoiBatis extends BaseDaoiBATIS implements OaAssetsDao {

    /**
     * @see com.vriche.adrm.dao.OaAssetsDao#getOaAssetss(com.vriche.adrm.model.OaAssets)
     */
    public List getOaAssetss(final OaAssets oaAssets) {
          return getSqlMapClientTemplate().queryForList("getOaAssetss", oaAssets);
    }
     /**
     * @see com.vriche.adrm.dao.OaAssetsDao#getOaAssetssCount(com.vriche.adrm.model.OaAssets)
     */
    public Integer getOaAssetssCount(final OaAssets oaAssets) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaAssetssCount", oaAssets);
    }
     /**
     * @see com.vriche.adrm.dao.OaAssetsDao#getOaAssetssPage(com.vriche.adrm.model.OaAssets)
     */   
  	public PaginatedList getOaAssetssPage(final OaAssets oaAssets,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaAssetss",oaAssets,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaAssetsDao#getOaAssetssByIdList(com.vriche.adrm.model.OaAssets)
     */
    public List getOaAssetssByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaAssetssByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsDao#getOaAssets(Long id)
     */
    public OaAssets getOaAssets(Long id) {
        OaAssets oaAssets = (OaAssets) getSqlMapClientTemplate().queryForObject("getOaAssets", id);

        if (oaAssets == null) {
            throw new ObjectRetrievalFailureException(OaAssets.class, id);
        }

        return oaAssets;
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsDao#saveOaAssets(OaAssets oaAssets)
     */    
    public Long saveOaAssets(final OaAssets oaAssets) {
        Long id = oaAssets.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaAssets", oaAssets);
        } else {
            getSqlMapClientTemplate().update("updateOaAssets", oaAssets);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaAssets.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaAssetsDao#removeOaAssets(Long id)
     */
    public void removeOaAssets(Long id) {
        getSqlMapClientTemplate().update("deleteOaAssets", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaAssetsDAO#removeOaAssetss(String ids)
     */
    public void removeOaAssetss(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaAssetss", idList);
    }    
}
