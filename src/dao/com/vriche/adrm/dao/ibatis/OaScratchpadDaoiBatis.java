
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaScratchpad;
import com.vriche.adrm.dao.OaScratchpadDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaScratchpadDaoiBatis extends BaseDaoiBATIS implements OaScratchpadDao {

    /**
     * @see com.vriche.adrm.dao.OaScratchpadDao#getOaScratchpads(com.vriche.adrm.model.OaScratchpad)
     */
    public List getOaScratchpads(final OaScratchpad oaScratchpad) {
          return getSqlMapClientTemplate().queryForList("getOaScratchpads", oaScratchpad);
    }
     /**
     * @see com.vriche.adrm.dao.OaScratchpadDao#getOaScratchpadsCount(com.vriche.adrm.model.OaScratchpad)
     */
    public Integer getOaScratchpadsCount(final OaScratchpad oaScratchpad) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaScratchpadsCount", oaScratchpad);
    }
     /**
     * @see com.vriche.adrm.dao.OaScratchpadDao#getOaScratchpadsPage(com.vriche.adrm.model.OaScratchpad)
     */   
  	public PaginatedList getOaScratchpadsPage(final OaScratchpad oaScratchpad,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaScratchpads",oaScratchpad,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaScratchpadDao#getOaScratchpadsByIdList(com.vriche.adrm.model.OaScratchpad)
     */
    public List getOaScratchpadsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaScratchpadsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaScratchpadDao#getOaScratchpad(Long id)
     */
    public OaScratchpad getOaScratchpad(Long id) {
        OaScratchpad oaScratchpad = (OaScratchpad) getSqlMapClientTemplate().queryForObject("getOaScratchpad", id);

        if (oaScratchpad == null) {
            throw new ObjectRetrievalFailureException(OaScratchpad.class, id);
        }

        return oaScratchpad;
    }

    /**
     * @see com.vriche.adrm.dao.OaScratchpadDao#saveOaScratchpad(OaScratchpad oaScratchpad)
     */    
    public Long saveOaScratchpad(final OaScratchpad oaScratchpad) {
//    	System.out.println("oaScratchpad====" + oaScratchpad.toString());
        Long id = oaScratchpad.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaScratchpad", oaScratchpad);
        } else {
            getSqlMapClientTemplate().update("updateOaScratchpad", oaScratchpad);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaScratchpad.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaScratchpadDao#removeOaScratchpad(Long id)
     */
    public void removeOaScratchpad(Long id) {
        getSqlMapClientTemplate().update("deleteOaScratchpad", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaScratchpadDAO#removeOaScratchpads(String ids)
     */
    public void removeOaScratchpads(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaScratchpads", idList);
    }    
}
