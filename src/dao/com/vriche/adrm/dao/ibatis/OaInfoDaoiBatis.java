
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaInfo;
import com.vriche.adrm.dao.OaInfoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaInfoDaoiBatis extends BaseDaoiBATIS implements OaInfoDao {

    /**
     * @see com.vriche.adrm.dao.OaInfoDao#getOaInfos(com.vriche.adrm.model.OaInfo)
     */
    public List getOaInfos(final OaInfo oaInfo) {
          return getSqlMapClientTemplate().queryForList("getOaInfos", oaInfo);
    }
     /**
     * @see com.vriche.adrm.dao.OaInfoDao#getOaInfosCount(com.vriche.adrm.model.OaInfo)
     */
    public Integer getOaInfosCount(final OaInfo oaInfo) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaInfosCount", oaInfo);
    }
     /**
     * @see com.vriche.adrm.dao.OaInfoDao#getOaInfosPage(com.vriche.adrm.model.OaInfo)
     */   
  	public PaginatedList getOaInfosPage(final OaInfo oaInfo,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaInfos",oaInfo,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaInfoDao#getOaInfosByIdList(com.vriche.adrm.model.OaInfo)
     */
    public List getOaInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaInfosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaInfoDao#getOaInfo(Long id)
     */
    public OaInfo getOaInfo(Long id) {
        OaInfo oaInfo = (OaInfo) getSqlMapClientTemplate().queryForObject("getOaInfo", id);

        if (oaInfo == null) {
            throw new ObjectRetrievalFailureException(OaInfo.class, id);
        }

        return oaInfo;
    }

    /**
     * @see com.vriche.adrm.dao.OaInfoDao#saveOaInfo(OaInfo oaInfo)
     */    
    public Long saveOaInfo(final OaInfo oaInfo) {
        Long id = oaInfo.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaInfo", oaInfo);
        } else {
            getSqlMapClientTemplate().update("updateOaInfo", oaInfo);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaInfo.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaInfoDao#removeOaInfo(Long id)
     */
    public void removeOaInfo(Long id) {
        getSqlMapClientTemplate().update("deleteOaInfo", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaInfoDAO#removeOaInfos(String ids)
     */
    public void removeOaInfos(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaInfos", idList);
    }    
}
