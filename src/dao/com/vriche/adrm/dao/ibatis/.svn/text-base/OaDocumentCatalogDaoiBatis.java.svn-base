
package com.vriche.adrm.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaDocumentCatalog;
import com.vriche.adrm.model.OaWorkFlow;
import com.vriche.adrm.dao.OaDocumentCatalogDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentCatalogDaoiBatis extends BaseDaoiBATIS implements OaDocumentCatalogDao {

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDao#getOaDocumentCatalogs(com.vriche.adrm.model.OaDocumentCatalog)
     */
    public List getOaDocumentCatalogs(final OaDocumentCatalog oaDocumentCatalog) {
          return getSqlMapClientTemplate().queryForList("getOaDocumentCatalogs", oaDocumentCatalog);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDao#getOaDocumentCatalogsCount(com.vriche.adrm.model.OaDocumentCatalog)
     */
    public Integer getOaDocumentCatalogsCount(final OaDocumentCatalog oaDocumentCatalog) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaDocumentCatalogsCount", oaDocumentCatalog);
    }
     /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDao#getOaDocumentCatalogsPage(com.vriche.adrm.model.OaDocumentCatalog)
     */   
  	public PaginatedList getOaDocumentCatalogsPage(final OaDocumentCatalog oaDocumentCatalog,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaDocumentCatalogs",oaDocumentCatalog,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDao#getOaDocumentCatalogsByIdList(com.vriche.adrm.model.OaDocumentCatalog)
     */
    public List getOaDocumentCatalogsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaDocumentCatalogsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDao#getOaDocumentCatalog(Long id)
     */
    public OaDocumentCatalog getOaDocumentCatalog(Long id) {
        OaDocumentCatalog oaDocumentCatalog = (OaDocumentCatalog) getSqlMapClientTemplate().queryForObject("getOaDocumentCatalog", id);

        if (oaDocumentCatalog == null) {
            throw new ObjectRetrievalFailureException(OaDocumentCatalog.class, id);
        }

        return oaDocumentCatalog;
    }

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDao#saveOaDocumentCatalog(OaDocumentCatalog oaDocumentCatalog)
     */    
    public Long saveOaDocumentCatalog(final OaDocumentCatalog oaDocumentCatalog) {
        Long id = oaDocumentCatalog.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaDocumentCatalog", oaDocumentCatalog);
        } else {
            getSqlMapClientTemplate().update("updateOaDocumentCatalog", oaDocumentCatalog);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaDocumentCatalog.class, id);
        }
//        System.out.println("id=========" + id);
        return  id;
    }
    

    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDao#removeOaDocumentCatalog(Long id)
     */
    public void removeOaDocumentCatalog(Long id) {
        getSqlMapClientTemplate().update("deleteOaDocumentCatalog", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaDocumentCatalogDAO#removeOaDocumentCatalogs(String ids)
     */
    public void removeOaDocumentCatalogs(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaDocumentCatalogs", idList);
    }
    
    
    
    
	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaDocumentCatalogDao#getIncomeUsers(java.lang.Long)
	 */
	public List getOaDocumentCatalogPermitUsers(Long id) {
		return getSqlMapClientTemplate().queryForList("getDocumentCatalogUsers", id);
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaDocumentCatalogDao#getOaDocumentCatalogPermits(java.lang.Long)
	 */
	public List getOaDocumentCatalogPermits(Long id) {
		return getSqlMapClientTemplate().queryForList("getDocumentCatalogPermits", id);
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaDocumentCatalogDao#removeIncomeUsers(java.util.Map)
	 */
	public void removeOaDocumentCatalogPermitUsers(Map idList) {
		getSqlMapClientTemplate().update("deleteDocumentCatalogUsersByIds", idList);
		
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaDocumentCatalogDao#removeOaDocumentCatalogPermits(java.util.Map)
	 */
	public void removeOaDocumentCatalogPermits(Map idList) {
		getSqlMapClientTemplate().update("deleteDocumentCatalogPermitsByIds", idList);
		
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaDocumentCatalogDao#saveCominUsers(com.vriche.adrm.model.OaDocumentCatalog, java.lang.Long)
	 */
	public void saveOaDocumentCatalogPermitUsers(OaDocumentCatalog oaDocumentCatalog, Long id) {
		
//		System.out.println("00000000009990000");
		
		getSqlMapClientTemplate().update("deleteDocumentCatalogUsers", id);

		Iterator it = oaDocumentCatalog.getPermitUsers().iterator();
		// System.out.println(oaWorkFlow.getCominUsers().toString());
		while (it.hasNext()) {
			Integer i = new Integer(it.next().toString());
			if (i.intValue() != -1) {
				Map mp = new HashMap();
				mp.put("userId", i);
				mp.put("catalogId", id);
				getSqlMapClientTemplate().insert("addDocumentCatalogUsers", mp);
			}
		}
		
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaDocumentCatalogDao#saveOaDocumentCatalogPermits(com.vriche.adrm.model.OaDocumentCatalog, java.lang.Long)
	 */
	public void saveOaDocumentCatalogPermits(OaDocumentCatalog oaDocumentCatalog, Long id) {
		getSqlMapClientTemplate().update("deleteDocumentCatalogPermits", id);

		Iterator it = oaDocumentCatalog.getPermitTypes().iterator();
		// System.out.println(oaWorkFlow.getCominUsers().toString());
		while (it.hasNext()) {
			Integer i = new Integer(it.next().toString());
			if (i.intValue() != -1) {
				Map mp = new HashMap();
				mp.put("permitTypeId", i);
				mp.put("catalogId", id);
				getSqlMapClientTemplate().insert("addDocumentCatalogPermits", mp);
			}
		}
		
	}
	
	public List getOaDocumentCatalogs(Map mp) {
		List ls =  getSqlMapClientTemplate().queryForList("getDocumentCatalogByUserId",mp);
//		System.out.println("ls.size11111111111111111:>>>>>>>>>>" + ls.size());
		return ls;
	}    
    
    

    
    
    
    
    
}
