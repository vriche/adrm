
package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Role;
import com.vriche.adrm.model.User;
import com.vriche.adrm.dao.BranchDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class BranchDaoiBatis extends BaseDaoiBATIS implements BranchDao {

    /**
     * @see com.vriche.adrm.dao.BranchDao#getBranchs(com.vriche.adrm.model.Branch)
     */
    public List getBranchs(final Branch branch) {
          return getSqlMapClientTemplate().queryForList("getBranchs", branch);
    }
     /**
     * @see com.vriche.adrm.dao.BranchDao#getBranchsCount(com.vriche.adrm.model.Branch)
     */
    public Integer getBranchsCount(final Branch branch) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getBranchsCount", branch);
    }
     /**
     * @see com.vriche.adrm.dao.BranchDao#getBranchsPage(com.vriche.adrm.model.Branch)
     */   
  	public PaginatedList getBranchsPage(final Branch branch,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getBranchs",branch,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.BranchDao#getBranchsByIdList(com.vriche.adrm.model.Branch)
     */
    public List getBranchsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getBranchsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.BranchDao#getBranch(Long id)
     */
    public Branch getBranch(Long id) {
        return  (Branch)getSqlMapClientTemplate().queryForObject("getBranch", id);
    }
    
    /**
     * @see com.vriche.adrm.dao.BranchDao#getBranch(Long id)
     */
    public Branch getBranchByName(String name) {
        
        return (Branch) getSqlMapClientTemplate().queryForObject("getBranchByName", name);
    }

    /**
     * @see com.vriche.adrm.dao.BranchDao#saveBranch(Branch branch)
     */    
    public Long saveBranch(final Branch branch) {
        Long id = branch.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addBranch", branch);
            
        } else {
            getSqlMapClientTemplate().update("updateBranch", branch);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Branch.class, id);
        }
        return  id;
    }
    
    
    public void saveBranchUser(Map mp) {
    	 getSqlMapClientTemplate().insert("addBranchUser", mp);
    }

    public void removeBranchUserByBanchId(Map mp ) {
    	getSqlMapClientTemplate().delete("deleteBranchUserByBanchAndUserId", mp);
    }
    public void removeBranchUserByBanchId(List idList) {
    	Map mp = new HashMap();
    	mp.put("BranchIdList",idList);
    	getSqlMapClientTemplate().update("deleteBranchUserByBanchId", mp);
    }
    
    public void removeBranchUserByUserId(Long id) {
    	getSqlMapClientTemplate().update("deleteBranchUserByUserId", id);
    }
    
    
//    public void removeBranchUserByBranchId(Long id) {
//    	getSqlMapClientTemplate().update("deleteBranchUserByBranchId", id);
//    }
    
    
    

    /**
     * @see com.vriche.adrm.dao.BranchDao#removeBranch(Long id)
     */
    public void removeBranch(List idList) {
    	Map mp = new HashMap();
    	mp.put("BranchIdList",idList);
        getSqlMapClientTemplate().update("deleteBranch", mp);
    }
    
// public void removeBranch(Long id) {
//    	
//        getSqlMapClientTemplate().update("deleteBranch", id);
//    }
    /**
     * @see com.vriche.adrm.dao.BranchDAO#removeBranchs(String ids)
     */
    public void removeBranchs(final Map idList) {
        getSqlMapClientTemplate().update("deleteBranchs", idList);
    }
    
	public Branch getUserBranchsByUserId(Long userId) {
		  return (Branch) getSqlMapClientTemplate().queryForObject("getUserBranchsByUserId", userId);
	}
	public List getBranchIdList(Long id) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getBranchIdList",id);
	} 
	
	public Integer getBranchIdForOrgUser(Map mp) {
		  return (Integer) getSqlMapClientTemplate().queryForObject("getBranchIdForOrgUser", mp);
	}

	public List getBranchsByUser(User user) {
		return getSqlMapClientTemplate().queryForList("getBranchsByUser", user);
	}
	
	public List getBranchsByParentUser(User user) {
		return getSqlMapClientTemplate().queryForList("getBranchsByParentUser", user);
	}
	public void saveUserOrg(Map mp) {
	         getSqlMapClientTemplate().update("save_User_Org", mp);
	}
	
}
