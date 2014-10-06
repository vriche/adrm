package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.model.SysUserType;
import com.vriche.adrm.model.User;

/**
 * User Data Access Object (Dao) interface.
 *
 * <p>
 * <a href="UserDao.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface UserDao extends Dao {
	
    /**
     * Gets users information based on user id.
     * @param userId the user's id
     * @return user populated user object
     */
    public User getUser(Long userId);

    
    public User getUserByOrg(Map mp);
    /**
     * Gets users information based on login name.
     * @param username the user's username
     * @return userDetails populated userDetails object
     */
    public User loadUserByUsername(String username) throws UsernameNotFoundException;
    
    
    
    public List getUsersByOrgLimit(Map mp);
    /**
     * Gets a list of users based on parameters passed in.
     *
     * @return List populated list of users
     */
    public List getUsers(User user);
    
    public List getSysUserByRoleId(Long roleId);
    
    public List getUsersByBranchId(User user);
    
    public List getUsersOwnerByBranchId(Map mp);

    
    
    
    public Integer getUsersByBranchIdCount(User user);
    
    public PaginatedList getUsersByBranchIdPage(User user,int pageIndex,int pageSize);
    
    public List getUserAutoComplet(User user) ;
    
    public Integer getUsersCount(User user);   
    /**
     * Retrieves all of the getUsersPage
     */        
    public PaginatedList getUsersPage(User user,int pageIndex,int pageSize);    
    
//    public String getUsersXML(User user);

    /**
     * Saves a user's information
     * @param user the object to be saved
     */
    public Long saveUser(User user);

    /**
     * Removes a user from the database by id
     * @param userId the user's id
     */
    public void removeUser(Long userId);
    
    public void removeUserRoles(final Long userId);
    
    public List getUserRolesByOrgUser(final  Map mp);
    
    public void removeUserBranch(final Long userId);
    

    public void deleteUserRoles(Long userId);
    
    public void deleteUserRel(Long userId);
    
    public void deleteUserRelByParent(Map mp);
    
    public void saveUserRel(final Map mp);
    
    public List getUserRel(Map mp);
    
    public List getUserRelNoOrg(Long parentId);

    public List getUserIdsByRole(Long roleId);
    
    public void addUserRole(final Map mp);
    
    public void addUserBranch(final Map mp);
    
    public void deleteRoleByUserIds(final Map mp);
    
    public void deleteCustomerUserRel(Long userId);
    
    public void deleteUserId(Map mp);
    
    public void saveUserCarrierRel(final Map mp);
    
    public List getUserCarrierRel(Long userId);
//	public void getUserRoles(Long userId);
    
    
    public List getUserListByBranchIds(Map mp,int pageIndex,int pageSize);
    
    public List getUsersByBranchIdCountByMap(Map mp);
    
    public List getUserByCarrier(Map mp);
    
    public List getUserByRole(String role);
    
    public void updateUserPassword(Map mp);
    
    public Integer getUserByNamePwd(Map mp);
    
    public List getComeInUserByUserId(Long userId);
    
    public List getUserNameByCustomerId(Long customerId);
    
    public List getUserCarrierSortList() ;
    
    public void removeUserRolesByIdList(Map mp) ;
    
    public void removeUserInBranch(User user) ;
    
    public List getUsersAnalyze(Map mp);
    
	public void deleteUserCarrierRel(Long userId);
	public void deleteUserCheck(Long userId);
	public void deleteUserComin(Long userId);
	public List getUsersFromOrder(Map mp);
	
	public List getUsersByIdList(Map mp);
	
	public Map getUserBranchsCount(Map mp);
	
	public List getUserOrgs(String uid);
	
    public List getUserIdsByOrg(Map mp);
    
    public List getUserByIdList(Map mp);
	
    

}
