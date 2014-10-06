
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaApplyInfo;
import com.vriche.adrm.dao.OaApplyInfoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaApplyInfoDaoiBatis extends BaseDaoiBATIS implements OaApplyInfoDao {

    /**
     * @see com.vriche.adrm.dao.OaApplyInfoDao#getOaApplyInfos(com.vriche.adrm.model.OaApplyInfo)
     */
    public List getOaApplyInfos(final OaApplyInfo oaApplyInfo) {
          return getSqlMapClientTemplate().queryForList("getOaApplyInfos", oaApplyInfo);
    }
     /**
     * @see com.vriche.adrm.dao.OaApplyInfoDao#getOaApplyInfosCount(com.vriche.adrm.model.OaApplyInfo)
     */
    public Integer getOaApplyInfosCount(final OaApplyInfo oaApplyInfo) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaApplyInfosCount", oaApplyInfo);
    }
     /**
     * @see com.vriche.adrm.dao.OaApplyInfoDao#getOaApplyInfosPage(com.vriche.adrm.model.OaApplyInfo)
     */   
  	public PaginatedList getOaApplyInfosPage(final OaApplyInfo oaApplyInfo,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaApplyInfos",oaApplyInfo,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaApplyInfoDao#getOaApplyInfosByIdList(com.vriche.adrm.model.OaApplyInfo)
     */
    public List getOaApplyInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaApplyInfosByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaApplyInfoDao#getOaApplyInfo(Long id)
     */
    public OaApplyInfo getOaApplyInfo(Long id) {
        OaApplyInfo oaApplyInfo = (OaApplyInfo) getSqlMapClientTemplate().queryForObject("getOaApplyInfo", id);

        if (oaApplyInfo == null) {
            throw new ObjectRetrievalFailureException(OaApplyInfo.class, id);
        }

        return oaApplyInfo;
    }

    /**
     * @see com.vriche.adrm.dao.OaApplyInfoDao#saveOaApplyInfo(OaApplyInfo oaApplyInfo)
     */    
    public Long saveOaApplyInfo(final OaApplyInfo oaApplyInfo) {
//    	System.out.println("oaApplyInfo==========" + oaApplyInfo.toString());
        Long id = oaApplyInfo.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaApplyInfo", oaApplyInfo);
        } else {
            getSqlMapClientTemplate().update("updateOaApplyInfo", oaApplyInfo);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaApplyInfo.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaApplyInfoDao#removeOaApplyInfo(Long id)
     */
    public void removeOaApplyInfo(Long id) {
        getSqlMapClientTemplate().update("deleteOaApplyInfo", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaApplyInfoDAO#removeOaApplyInfos(String ids)
     */
    public void removeOaApplyInfos(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaApplyInfos", idList);
    }    
}
