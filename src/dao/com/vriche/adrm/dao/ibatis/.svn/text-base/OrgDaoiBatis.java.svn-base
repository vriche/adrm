
package com.vriche.adrm.dao.ibatis;


import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.model.Org;

public class OrgDaoiBatis extends BaseDaoiBATIS implements OrgDao {

    /**
     * @see com.vriche.adrm.dao.OrgDao#getOrgs(com.vriche.adrm.model.Org)
     */
    public List getOrgs(final Org org) {
          return getSqlMapClientTemplate().queryForList("getOrgs", org);
    }
    
    public List getUserOrgs(final Map mp) {
        return getSqlMapClientTemplate().queryForList("getUserOrgs", mp);
    }
    
    
    public List getOrgsNew(final Org org) {
        return getSqlMapClientTemplate().queryForList("getOrgsNew", org);
  }
    
    
     /**
     * @see com.vriche.adrm.dao.OrgDao#getOrgsCount(com.vriche.adrm.model.Org)
     */
    public Integer getOrgsCount(final Org org) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOrgsCount", org);
    }
     /**
     * @see com.vriche.adrm.dao.OrgDao#getOrgsPage(com.vriche.adrm.model.Org)
     */   
  	public PaginatedList getOrgsPage(final Org org,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOrgs2",org,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
  	
  	
    /**
     * @see com.vriche.adrm.dao.OrgDao#getOrgsByIdList(com.vriche.adrm.model.Org)
     */
    public List getOrgsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOrgsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OrgDao#getOrg(Long id)
     */
    public Org getOrg(Long id) {
        Org org = (Org) getSqlMapClientTemplate().queryForObject("getOrg", id);

        if (org == null) {
            throw new ObjectRetrievalFailureException(Org.class, id);
        }

        return org;
    }

    /**
     * @see com.vriche.adrm.dao.OrgDao#saveOrg(Org org)
     */    
    public Long saveOrg(final Org org) {
        Long id = org.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOrg", org);
        } else {
            getSqlMapClientTemplate().update("updateOrg", org);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Org.class, id);
        }
        return  id;
    }
    
    
    public Long saveOrgLogo(final Org org) {
    	Long id = org.getId();
    // check for new record
    if (id == null || id.toString().equals("0")) {
//        id = (Long) getSqlMapClientTemplate().insert("addOrg", org);
    } else {
        getSqlMapClientTemplate().update("updateOrgLogo", org);
    }
    if( id == null ) {
        throw new ObjectRetrievalFailureException(Org.class, id);
    }
    return  id;
  }
    


    /**
     * @see com.vriche.adrm.dao.OrgDao#removeOrg(Long id)
     */
    public void removeOrg(Long id) {
    	Map branchIdMap = getSqlMapClientTemplate().queryForMap("getBranchIdsByOrgid",id,"BranchIdList");
    	getSqlMapClientTemplate().update("deleteBranchUsers", branchIdMap);
    	getSqlMapClientTemplate().update("deleteBranchs", branchIdMap);
        getSqlMapClientTemplate().update("deleteOrg", id);
    }
    
    
    /**
     * @see com.vriche.adrm.dao.OrgDAO#removeOrgs(String ids)
     */
    public void removeOrgs(final Map idList) {
       for ( int i = 0;i < idList.size();i++) {
           Long id = (Long) idList.get("OrgIdList");
           this.removeOrg(id);
       }
//        getSqlMapClientTemplate().update("deleteOrgs", idList);
    }

	public List getUserOrgs_new(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getUserOrgs_new", mp);
	}
 
}
