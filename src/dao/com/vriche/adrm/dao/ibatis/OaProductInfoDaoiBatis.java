
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaProductInfo;
import com.vriche.adrm.dao.OaProductInfoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductInfoDaoiBatis extends BaseDaoiBATIS implements OaProductInfoDao {

    /**
     * @see com.vriche.adrm.dao.OaProductInfoDao#getOaProductInfos(com.vriche.adrm.model.OaProductInfo)
     */
    public List getOaProductInfos(final OaProductInfo oaProductInfo) {
          return getSqlMapClientTemplate().queryForList("getOaProductInfos", oaProductInfo);
    }
     /**
     * @see com.vriche.adrm.dao.OaProductInfoDao#getOaProductInfosCount(com.vriche.adrm.model.OaProductInfo)
     */
    public Integer getOaProductInfosCount(final OaProductInfo oaProductInfo) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaProductInfosCount", oaProductInfo);
    }
     /**
     * @see com.vriche.adrm.dao.OaProductInfoDao#getOaProductInfosPage(com.vriche.adrm.model.OaProductInfo)
     */   
  	public PaginatedList getOaProductInfosPage(final OaProductInfo oaProductInfo,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaProductInfos",oaProductInfo,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaProductInfoDao#getOaProductInfosByIdList(com.vriche.adrm.model.OaProductInfo)
     */
    public List getOaProductInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaProductInfosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaProductInfoDao#getOaProductInfo(Long id)
     */
    public OaProductInfo getOaProductInfo(Long id) {
        OaProductInfo oaProductInfo = (OaProductInfo) getSqlMapClientTemplate().queryForObject("getOaProductInfo", id);

        if (oaProductInfo == null) {
            throw new ObjectRetrievalFailureException(OaProductInfo.class, id);
        }

        return oaProductInfo;
    }

    /**
     * @see com.vriche.adrm.dao.OaProductInfoDao#saveOaProductInfo(OaProductInfo oaProductInfo)
     */    
    public Long saveOaProductInfo(final OaProductInfo oaProductInfo) {
        Long id = oaProductInfo.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaProductInfo", oaProductInfo);
        } else {
            getSqlMapClientTemplate().update("updateOaProductInfo", oaProductInfo);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaProductInfo.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaProductInfoDao#removeOaProductInfo(Long id)
     */
    public void removeOaProductInfo(Long id) {
        getSqlMapClientTemplate().update("deleteOaProductInfo", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaProductInfoDAO#removeOaProductInfos(String ids)
     */
    public void removeOaProductInfos(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaProductInfos", idList);
    }    
}
