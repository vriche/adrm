package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.model.Role;
import com.vriche.adrm.model.User;

/**
 * This class interacts with iBatis's SQL Maps to save and retrieve User
 * related objects.
 *
 * <p><a href="UserDaoiBatis.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserDaoiBatis extends BaseDaoiBATIS implements UserDao {


	public Integer getUsersCount(User user) {
        return (Integer)getSqlMapClientTemplate().queryForObject("getUsersCount",user);
	}


	public PaginatedList getUsersPage(User user, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getUsers",user,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}

	/**
     * Get user by id.
     *
     * @param userId the user's id
     * @return a populated user object
     */
    public User getUser(Long userId) {
        User user = (User) getSqlMapClientTemplate().queryForObject("getUser", userId);

        if (user == null) {
            logger.warn("uh oh, user not found...");
            throw new ObjectRetrievalFailureException(User.class, userId);
        } else {
            List roles = getSqlMapClientTemplate().queryForList("getUserRoles", user);
            user.setRoles(new HashSet(roles));
            
            List branchs = getSqlMapClientTemplate().queryForList("getUserBranchsByUserId", user);
            user.setBranchs(new HashSet(branchs));           

        }

        return user;
    }
    
    


    /**
     * @see com.vriche.adrm.order.dao.UserDao#getUsers(com.vriche.adrm.order.model.User)
     */
    public List getUsers(User user) {
        List users = getSqlMapClientTemplate().queryForList("getUsers", null);

        // get the roles for each user
        for (int i = 0; i < users.size(); i++) {
            user = (User) users.get(i);

            List roles =  getSqlMapClientTemplate().queryForList("getUserRoles", user);
            user.setRoles(new HashSet(roles));

            List branchs = getSqlMapClientTemplate().queryForList("getUserBranchsByUserId", user);
            user.setBranchs(new HashSet(branchs)); 
        
            users.set(i, user);
        }

        return users;
    }
    
    
    public User getUserByOrg(Map mp) {
    	
        User user = (User) getSqlMapClientTemplate().queryForObject("getUserByOrg", mp);
      
        

        if (user == null) {
            logger.warn("uh oh, user not found...");
            throw new ObjectRetrievalFailureException(User.class, mp);
        } else {
            List roles = getSqlMapClientTemplate().queryForList("getUserRoles", user);
            user.setRoles(new HashSet(roles));
            
            List branchs = getSqlMapClientTemplate().queryForList("getUserBranchsByUserId", user);
            user.setBranchs(new HashSet(branchs));           

        }

        return user;

    }
    
    
    
    
    
    
    
    public List getUserAutoComplet(User user) {
        return getSqlMapClientTemplate().queryForList("getUsers", null);
    }


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.UserDao#getSysUserByRoleId(java.lang.Long)
	 */
	public List getSysUserByRoleId(Long roleId) {
		return getSqlMapClientTemplate().queryForList("getSysUserByRoleId", roleId);
	}
	
	public List getSysUserByRoleIdOrgId(Map mp) {
		return getSqlMapClientTemplate().queryForList("getSysUserByRoleIdOrgId", mp);
	}
	
	

	/**
     * Convenience method to delete roles
     * @param user
     */
    public void deleteUserRoles(final Long userId) {
        getSqlMapClientTemplate().update("deleteUserRoles", userId);
    }
    
	public List getUserRolesByOrgUser(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getUserRolesByOrgUser", mp);
	}
    
    public void removeUserRoles(final Long userId){
    	getSqlMapClientTemplate().update("deleteUserRoles", userId);
    }
    
    public void deleteBranchUserByUserId(final Long userId) {
        getSqlMapClientTemplate().update("deleteBranchUserByUserId", userId);
    }  
    
    
    
    /* (non-Javadoc)
	 * @see com.vriche.adrm.dao.UserDao#removeUserBranch(java.lang.Long)
	 */
	public void removeUserBranch(Long userId) {
		getSqlMapClientTemplate().update("deleteBranchUserByUserId", userId);
		
	}

	public List getUsersByBranchId(User user){
    	 return getSqlMapClientTemplate().queryForList("getUsersByBranchId", user);
    }
    
 
	public Integer getUsersByBranchIdCount(User user) {
		  return (Integer)getSqlMapClientTemplate().queryForObject("getUsersByBranchIdCount",user);
	}

	public PaginatedList getUsersByBranchIdPage(User user, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getUsersByBranchId",user,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
    }   
    
    
    

    public void addUserRoles(final User user) {
        if (user.getRoles() != null) {
            for (Iterator it = user.getRoles().iterator(); it.hasNext();) {
                Role role = (Role) it.next();
                Map newRole = new HashMap();
                newRole.put("userId", user.getId());
                newRole.put("roleId", role.getId());
                List userRoles = getSqlMapClientTemplate().queryForList("getUserRoles", user.getUsername());

                if (userRoles.isEmpty()) {
                    getSqlMapClientTemplate().update("addUserRole", newRole);
                }
            }
        }
    }
    
    public void addUserBranchs(final User user) {
        if (user.getBranchs() != null) {
            for (Iterator it = user.getBranchs().iterator(); it.hasNext();) {
                Branch branch = (Branch) it.next();
                Map newBranch = new HashMap();
                newBranch.put("userId", user.getId());
                newBranch.put("branchId", branch.getId());

               getSqlMapClientTemplate().update("addBranchUser", newBranch);

            }
        }
    }
    
    
    
    

    /* (non-Javadoc)
	 * @see com.vriche.adrm.dao.UserDao#addUserBranch(java.util.Map)
	 */
	public void addUserBranch(Map mp) {
		 getSqlMapClientTemplate().update("addBranchUser", mp);
	}

	/**
     * @see com.vriche.adrm.order.dao.UserDao#saveUser(com.vriche.adrm.order.model.User)
     */
    public Long saveUser(final User user) {
        prepareObjectForSaveOrUpdate(user);
        Long id = user.getId();
        
        if (user.getId() == null) {
             id = (Long) getSqlMapClientTemplate().insert("addUser", user);
//            addUserRoles(user);
//            addUserBranchs(user);
        } else {
            getSqlMapClientTemplate().update("updateUser", user);
//            deleteUserRoles(user.getId());
//            addUserRoles(user);
//            deleteBranchUserByUserId(user.getId());
//            addUserBranchs(user);
            
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.order.dao.UserDao#removeUser(java.lang.Long)
     */
    public void removeUser(Long userId) {
    	deleteBranchUserByUserId(userId);
        deleteUserRoles(userId);
        getSqlMapClientTemplate().update("deleteUser", userId);
    }
    
    /** 
     * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    public User loadUserByUsername(String username) {
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = (User) getSqlMapClientTemplate().queryForObject("getUserByUsername", username);

         if (user == null) {
             logger.warn("uh oh, user not found...");
             throw new UsernameNotFoundException("user '" + username + "' not found...");
         } else {
             List roles = getSqlMapClientTemplate().queryForList("getUserRoles", user);
             user.setRoles(new HashSet(roles));
             
             List branchs = getSqlMapClientTemplate().queryForList("getUserBranchsByUserId", user);
             user.setBranchs(new HashSet(branchs)); 
         }

         return user;
     }

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.UserDao#getUserIdsByRoleId(java.lang.Long)
	 */
	public List getUserIdsByRole(Long roleId) {
		return getSqlMapClientTemplate().queryForList("getUserIdsByRoleId", roleId);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.UserDao#addUserRole(java.util.Map)
	 */
	public void addUserRole(Map mp) {
		 getSqlMapClientTemplate().update("addUserRole", mp);
		
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.UserDao#deleteRoleByUserIds(java.util.Map)
	 */
	public void deleteRoleByUserIds(Map mp) {
		getSqlMapClientTemplate().update("deleteRoleByUserIds", mp);
		
	}

	public void deleteUserRel(Long userId) {
		getSqlMapClientTemplate().update("deleteUserRel", userId);
	}


	public void saveUserRel(Map mp) {
		getSqlMapClientTemplate().update("saveUserRel", mp);
		
	}


	public void deleteUserRelByParent(Map mp) {
		getSqlMapClientTemplate().update("deleteUserRelByParent", mp);
	}


	public List getUserRel(Map mp) {
		return getSqlMapClientTemplate().queryForList("getUserRel", mp);
	}
	
	public List getUsersByOrgLimit(Map mp) {
		return getSqlMapClientTemplate().queryForList("getUsersByOrgLimit", mp);
	}
	
	
	

	public void deleteCustomerUserRel(Long userId) {
		getSqlMapClientTemplate().update("deleteCustomerUserRel", userId);
	}
	

	
	public void deleteUserCarrierRel(Long userId) {
		getSqlMapClientTemplate().update("deleteUserCarrierRel", userId);
	}
	public void deleteUserCheck(Long userId) {
		getSqlMapClientTemplate().update("deleteUserCheck", userId);
	}
	public void deleteUserComin(Long userId) {
		getSqlMapClientTemplate().update("deleteUserComin", userId);
	}


	public void deleteUserId(Map mp) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("deleteUserCarrierRelByParent", mp);
	}


	public void saveUserCarrierRel(Map mp) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("saveUserCarrierRel", mp);
	}


	public List getUserCarrierRel(Long userId) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getUserCarrierRel",userId);
	}


	public List getUserListByBranchIds(Map mp, int pageIndex, int pageSize) {
		 int skip = (pageIndex-1) * pageSize;
		 return getSqlMapClientTemplate().queryForList("getUsersByBranchIdList",mp,skip,pageSize);
		 
		// TODO Auto-generated method stub
//		 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getUsersByBranchIdList",mp,pageSize);
//	     pageList.gotoPage(pageIndex-1);
//		 return pageList;
	}


	public List getUsersByBranchIdCountByMap(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getUsersByBranchIdList", mp);
	}
	
	public Map getUserBranchsCount(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForMap("getUserBranchsCount", mp,"id");
	}
	


	public List getUserByCarrier(Map mp) {
		return getSqlMapClientTemplate().queryForList("getUsersByCarrier", mp);
	}
	
      public List getUsersAnalyze(Map mp){
		 
    	  return getSqlMapClientTemplate().queryForList("getUsersAnalyze", mp);
	 }
      
   
      public List getUserByIdList(Map mp){
 		 
    	  return getSqlMapClientTemplate().queryForList("getUserByIdList", mp);
	 } 

      


	public List getUserByRole(String role) {
		return getSqlMapClientTemplate().queryForList("getUserByRole", role);
	}


	public void updateUserPassword(Map mp) {
		 getSqlMapClientTemplate().update("updateUserPassword", mp);
	}


	public Integer getUserByNamePwd(Map mp) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getUserByNamePwd", mp);
		
	}


	public List getComeInUserByUserId(Long userId) {
		   return  getSqlMapClientTemplate().queryForList("getComeInUserByUserId", userId);
	}
	
	public List getUserNameByCustomerId(Long customerId) {
		   return  getSqlMapClientTemplate().queryForList("getUserNameByCustomerId", customerId);
	}


	public List getUsersOwnerByBranchId(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getUsersOwnerByBranchId", mp);
	}
	public List getUserCarrierSortList() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getUserCarrierSortList", null);
	}
	
	
	public void removeUserRolesByIdList(Map mp) {
		// TODO Auto-generated method stub
		 getSqlMapClientTemplate().update("deleteUserRolesByIdList", mp);
	}


	public void removeUserInBranch(User user) {
		// TODO Auto-generated method stub
		 getSqlMapClientTemplate().update("removeUserInBranch", user);
		
	}


	public List getUserRelNoOrg(Long parentId) {
		return getSqlMapClientTemplate().queryForList("getUserRelNoOrg", parentId);
	}
	
	
    public List getUsersFromOrder(Map mp){
 		 
  	  return getSqlMapClientTemplate().queryForList("getUsersFromOrder", mp);
	 }  
    
    public List getUsersByIdList(Map mp){
		 
    	  return getSqlMapClientTemplate().queryForList("getUsersByIdList", mp);
  	 }


	public List getUserOrgs(String uid) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getUser_Orgs", uid);
	}


	public List getUserIdsByOrg(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getUserIdsByOrg", mp);
	}  
    
    


}
