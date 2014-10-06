package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.User;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * <p><a href="UserManager.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a> 
 */
public interface UserManager {  
   
    public void setUserDao(UserDao userDao);
    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param userId
     * @return User
     */
    public User getUser(String userId);
    
    public User getUserByOrg(User use);
    
    public String getUsersCount(User user);   
    /**
     * Retrieves all of the getUsersPage
     */        
    public PaginatedList getUsersPage(User user,String pageIndex,String pageSize);        

    /**
     * Finds a user by their username.
     * @param username
     * @return User a populated user object
     */
    public User getUserByUsername(String username) throws UsernameNotFoundException;
    
//    public List getUsersByBranchId(String branchId);
    
    public String getUsersByBranchIdCount(User user);   
    
    public PaginatedList getUsersByBranchIdPage(User user,String pageIndex,String pageSize);

    public List getUsers(User user);
    
    public List getUserAutoComplet(User user);
    
    public List getSysUserByRoleId(String roleId);
    
    public void getUsersItemsByBranch(StringBuffer sb,String branchId,String IdPrefix);
    
    public String[] getSysUserColByRoleId(String roleId,String propertyName);
    
    public String getUsersXML(User user,String IdPrefix);
    
    public void getUsersItems(StringBuffer sb,String IdPrefix);

    public String saveUser(User user) throws UserExistsException;
    
    public void saveUserRel(String orgId,String parentUserId,String[] userId);
    
    public Object[] getUserRel(String orgId,String parentUserId);

    public void removeUser(String userId);

    public String[] getUserRolesCol(String userId,String propertyName);
    
    public User getCurrentUser();
    
    public String getCurrentUserId();
    
    public String getCurrentUserIdForEdit(String loginName);
    
    public User getCurrentUser(String loginName);
    
    public  String getUserFullName(String userLongName);
    
    public Map getCurrentUserSelect();
 
    public Map getUserSelect(User user);
    
    public Map getUserSelectLimit();
    
    public List getOwnerUsersListForReport(Map map,String curUserName);
    
    public List getOwnerUsersList(Map map);
    
    public List getOwnerUsersList(Map map,String currentUser);
    
    public Map getUserSelectFromMap(User user);
    
    public void saveUserCarrierRel(String orgId,String userId,String[] carrierIds);
    
    public Object[] getUserCarrierRel(String userId);
    
    public List getUserListByBranchIds(User user,String pageIndex,String pageSize);
    
    public Map getUserByCarrier(String carrierId,String customerId);
    
    public Map getUserByRole(String role);
    
    public void updateUserPassword(String username,String newPassword);
    
    public boolean getUserByNamePwd(String username,String password);
    
    public Map getOwnerUsersMapByCurrentUser(User user);
    
    
    public boolean createOpenFireUser();
    
    public void getUsersItemsByBranch2(StringBuffer sb,String branchId,String IdPrefix,String loginUser);
    
    public void getUsersItemsByBranchNew(StringBuffer sb,String orgId,String branchId,String IdPrefix);
    
    public void removeUserInBranch(User user) throws UserExistsException;
    
    public List getUsersAnalyze(User user);
    
    public String getBranchsByUser(User user);
    
    public List getUserRelList(String orgId,String parentUserId);
    
    public List getUsersFromOrder(User user,String type);
    
    public List getUsersByOrgLimit(User user);
    
    public String saveUserObj(User user);
    
    public void saveUserRelByParent(String orgId, String[] parentUserIds,String userId);
    
    public List getTree(Map searchMap);

    public void saveUserRelOrg(User user);
    
    public void saveUserRel2(String parentUserId,String idStr, String IdPrefix);
    
    public String[] getUserOrgs(String uid);
    
    
}

	
