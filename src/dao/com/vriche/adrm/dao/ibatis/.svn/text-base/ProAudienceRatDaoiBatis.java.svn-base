
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.ProAudienceRat;
import com.vriche.adrm.dao.ProAudienceRatDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProAudienceRatDaoiBatis extends BaseDaoiBATIS implements ProAudienceRatDao {

    /**
     * @see com.vriche.adrm.dao.ProAudienceRatDao#getProAudienceRats(com.vriche.adrm.model.ProAudienceRat)
     */
    public List getProAudienceRats(final ProAudienceRat proAudienceRat) {
          return getSqlMapClientTemplate().queryForList("getProAudienceRats", proAudienceRat);
    }
     /**
     * @see com.vriche.adrm.dao.ProAudienceRatDao#getProAudienceRatsCount(com.vriche.adrm.model.ProAudienceRat)
     */
    public Integer getProAudienceRatsCount(final ProAudienceRat proAudienceRat) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProAudienceRatsCount", proAudienceRat);
    }
     /**
     * @see com.vriche.adrm.dao.ProAudienceRatDao#getProAudienceRatsPage(com.vriche.adrm.model.ProAudienceRat)
     */   
  	public List getProAudienceRatsPage(final ProAudienceRat proAudienceRat,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProAudienceRats",proAudienceRat,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProAudienceRatDao#getProAudienceRatsByIdList(com.vriche.adrm.model.ProAudienceRat)
     */
    public List getProAudienceRatsByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProAudienceRatsByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProAudienceRatDao#getProAudienceRat(Long id)
     */
    public ProAudienceRat getProAudienceRat(Long id) {
        ProAudienceRat proAudienceRat = (ProAudienceRat) getSqlMapClientTemplate().queryForObject("getProAudienceRat", id);

        if (proAudienceRat == null) {
            throw new ObjectRetrievalFailureException(ProAudienceRat.class, id);
        }

        return proAudienceRat;
    }

    /**
     * @see com.vriche.adrm.dao.ProAudienceRatDao#saveProAudienceRat(ProAudienceRat proAudienceRat)
     */    
    public Long saveProAudienceRat(final ProAudienceRat proAudienceRat) {
        Long id = proAudienceRat.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProAudienceRat", proAudienceRat);
        } else {
            getSqlMapClientTemplate().update("updateProAudienceRat", proAudienceRat);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProAudienceRat.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ProAudienceRatDao#removeProAudienceRat(Long id)
     */
    public void removeProAudienceRat(Long id) {
        getSqlMapClientTemplate().update("deleteProAudienceRat", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProAudienceRatDAO#removeProAudienceRats(String ids)
     */
    public void removeProAudienceRats(final Map idList) {
        getSqlMapClientTemplate().update("deleteProAudienceRats", idList);
    }
    
	public void saveProAudienceRats(final List ls) {
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for(Iterator it =ls.iterator();it.hasNext();){
				ProAudienceRat proAudienceRat = (ProAudienceRat)it.next();
				getSqlMapClientTemplate().getSqlMapClient().insert("addProAudienceRat", proAudienceRat);
			}
			
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}    
}
