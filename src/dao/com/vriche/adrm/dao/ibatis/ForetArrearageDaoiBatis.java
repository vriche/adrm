
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ForetArrearage;
import com.vriche.adrm.dao.ForetArrearageDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ForetArrearageDaoiBatis extends BaseDaoiBATIS implements ForetArrearageDao {

    /**
     * @see com.vriche.adrm.dao.ForetArrearageDao#getForetArrearages(com.vriche.adrm.model.ForetArrearage)
     */
    public List getForetArrearages(final ForetArrearage foretArrearage) {
          return getSqlMapClientTemplate().queryForList("getForetArrearages", foretArrearage);
    }
     /**
     * @see com.vriche.adrm.dao.ForetArrearageDao#getForetArrearagesCount(com.vriche.adrm.model.ForetArrearage)
     */
    public Integer getForetArrearagesCount(final ForetArrearage foretArrearage) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getForetArrearagesCount", foretArrearage);
    }
     /**
     * @see com.vriche.adrm.dao.ForetArrearageDao#getForetArrearagesPage(com.vriche.adrm.model.ForetArrearage)
     */   
  	public List getForetArrearagesPage(final ForetArrearage foretArrearage,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getForetArrearages",foretArrearage,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ForetArrearageDao#getForetArrearagesByIdList(com.vriche.adrm.model.ForetArrearage)
     */
    public List getForetArrearagesByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getForetArrearagesByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ForetArrearageDao#getForetArrearage(Long id)
     */
    public ForetArrearage getForetArrearage(Long id) {
        ForetArrearage foretArrearage = (ForetArrearage) getSqlMapClientTemplate().queryForObject("getForetArrearage", id);

        if (foretArrearage == null) {
            throw new ObjectRetrievalFailureException(ForetArrearage.class, id);
        }

        return foretArrearage;
    }

    /**
     * @see com.vriche.adrm.dao.ForetArrearageDao#saveForetArrearage(ForetArrearage foretArrearage)
     */    
    public Long saveForetArrearage(final ForetArrearage foretArrearage) {
        Long id = foretArrearage.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addForetArrearage", foretArrearage);
        } else {
            getSqlMapClientTemplate().update("updateForetArrearage", foretArrearage);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ForetArrearage.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ForetArrearageDao#removeForetArrearage(Long id)
     */
    public void removeForetArrearage(Long id) {
        getSqlMapClientTemplate().update("deleteForetArrearage", id);
    }
    /**
     * @see com.vriche.adrm.dao.ForetArrearageDAO#removeForetArrearages(String ids)
     */
    public void removeForetArrearages(final Map idList) {
        getSqlMapClientTemplate().update("deleteForetArrearages", idList);
    }
	public List getForetArrearagesList(ForetArrearage foretArrearage) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getForetArrearages",foretArrearage);
	}    
}
