
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaAreaPc;
import com.vriche.adrm.dao.OaAreaPcDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAreaPcDaoiBatis extends BaseDaoiBATIS implements OaAreaPcDao {

    /**
     * @see com.vriche.adrm.dao.OaAreaPcDao#getOaAreaPcs(com.vriche.adrm.model.OaAreaPc)
     */
    public List getOaAreaPcs(final OaAreaPc oaAreaPc) {
          return getSqlMapClientTemplate().queryForList("getOaAreaPcs", oaAreaPc);
    }
     /**
     * @see com.vriche.adrm.dao.OaAreaPcDao#getOaAreaPcsCount(com.vriche.adrm.model.OaAreaPc)
     */
    public Integer getOaAreaPcsCount(final OaAreaPc oaAreaPc) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaAreaPcsCount", oaAreaPc);
    }
     /**
     * @see com.vriche.adrm.dao.OaAreaPcDao#getOaAreaPcsPage(com.vriche.adrm.model.OaAreaPc)
     */   
  	public PaginatedList getOaAreaPcsPage(final OaAreaPc oaAreaPc,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaAreaPcs",oaAreaPc,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaAreaPcDao#getOaAreaPcsByIdList(com.vriche.adrm.model.OaAreaPc)
     */
    public List getOaAreaPcsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaAreaPcsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaAreaPcDao#getOaAreaPc(Long id)
     */
    public OaAreaPc getOaAreaPc(Long id) {
        OaAreaPc oaAreaPc = (OaAreaPc) getSqlMapClientTemplate().queryForObject("getOaAreaPc", id);

        if (oaAreaPc == null) {
            throw new ObjectRetrievalFailureException(OaAreaPc.class, id);
        }

        return oaAreaPc;
    }

    /**
     * @see com.vriche.adrm.dao.OaAreaPcDao#saveOaAreaPc(OaAreaPc oaAreaPc)
     */    
    public Long saveOaAreaPc(final OaAreaPc oaAreaPc) {
        Long id = oaAreaPc.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaAreaPc", oaAreaPc);
        } else {
            getSqlMapClientTemplate().update("updateOaAreaPc", oaAreaPc);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaAreaPc.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaAreaPcDao#removeOaAreaPc(Long id)
     */
    public void removeOaAreaPc(Long id) {
        getSqlMapClientTemplate().update("deleteOaAreaPc", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaAreaPcDAO#removeOaAreaPcs(String ids)
     */
    public void removeOaAreaPcs(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaAreaPcs", idList);
    }    
}
