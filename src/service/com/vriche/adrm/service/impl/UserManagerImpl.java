package com.vriche.adrm.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.jivesoftware.smack.XMPPConnection;
import org.springframework.dao.DataIntegrityViolationException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.BranchDao;
import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.dao.RoleDao;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.model.Role;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.LookupManager;
import com.vriche.adrm.service.UserExistsException;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.service.security.acegi.AuthenticationHelper;
import com.vriche.adrm.service.security.acegi.cache.AcegiCacheManager;
import com.vriche.adrm.util.AuthHelper;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.SmackUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;


/**
 * Implementation of UserManager interface.</p>
 * 
 * <p>
 * <a href="UserManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserManagerImpl extends BaseManager implements UserManager {
	private AcegiCacheManager acegiCacheManager;
    private UserDao dao;
    private RoleDao roleDao;
    private BranchDao branchDao;
    
    
	

	
	public void setAcegiCacheManager(AcegiCacheManager acegiCacheManager) {
		this.acegiCacheManager = acegiCacheManager;
	}

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setUserDao(UserDao dao) {
        this.dao = dao;
    }
    public void setRoleDao(RoleDao dao) {
        this.roleDao = dao;
    }

	public void setBranchDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}   
    
    
    /* (non-Javadoc)
	 * @see com.vriche.adrm.service.UserManager#getUserRoles(java.lang.String)
	 */
	public String[] getUserRolesCol(String userId,String propertyName) {
		List ls = roleDao.getUserRoles(userId);
		int size = ls.size();
		String[] s = new String[size];
		
		int j = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				s[j++] = (String) BeanUtils.getProperty(it.next(),propertyName) ;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return s;

	}
	
	
	

	/**
     * @see com.vriche.adrm.order.service.UserManager#getUser(java.lang.String)
     */
    public User getUser(String userId) {
//    	List roles = roleDao.getRoless(null);
		User user = dao.getUser(new Long(userId));
		
		String branchId = "0";
		try {
			branchId = (String) BeanUtils.getProperty(branchDao.getUserBranchsByUserId(new Long(userId)),"id");
		} catch (Exception e) {
		}

		user.setBranchId(new Long(branchId));
//		getRolesByUserId(user);
//		AuthHelper.judgeAuthorized(roles, user.getRoles());
        return user;
    }
    
    
	/**
     * @see com.vriche.adrm.order.service.UserManager#getUser(java.lang.String)
     */
    public User getUserByOrg(User user) {
    	Map mp = new HashMap();
    	mp.put("orgId",user.getOrgId());
    	mp.put("userId",user.getId());
    	mp.put("branchId",user.getBranchId());
    	
        if (log.isDebugEnabled()) {
        	 log.info("*@@@@@@@ getOrgId @@@@@@@@@@" +user.getOrgId() );
        	 log.info("*@@@@@@@ getId @@@@@@@@@@" +user.getId() );
        	 log.info("*@@@@@@@ getBranchId @@@@@@@@@@" +user.getBranchId() );
         
      }
    	

		  
		User u = dao.getUserByOrg(mp);
		
//		getRolesByUserId(u);
		
        return u;
    }
    

    /**
     * @see com.vriche.adrm.order.service.UserManager#getUsers(com.vriche.adrm.order.model.User)
     */
    public List getUsers(User user) {
        return dao.getUsers(user);
    }
    public List getUserAutoComplet(User user) {
        return dao.getUserAutoComplet(user);
    }
    
	public String getUsersByBranchIdCount(User user) {
//		 return dao.getUsersByBranchIdCount(user).toString();
		List ls = new ArrayList();
    	List lst = new ArrayList();
    	Long parentId = user.getBranchId();
    	List list = getAllChild(parentId,lst);
    	list.add(parentId);
    	if(parentId==null) list=null;
    	Map mp = new HashMap();
        mp.put("branchIdList",list);
        mp.put("orgId",user.getVersion());

        ls = dao.getUsersByBranchIdCountByMap(mp);
        return new Integer(ls.size()).toString();
	}
	 public PaginatedList getUsersByBranchIdPage(User user,String pageIndex,String pageSize) {
		 
	        return dao.getUsersByBranchIdPage(user,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	    }
    
    public List getUserListByBranchIds(User user,String pageIndex,String pageSize) {
    	List ls = new ArrayList();
    	List lst = new ArrayList();
    	Long parentId = user.getBranchId();
    	List list = getAllChild(parentId,lst);
    	list.add(parentId);
    	if(parentId == null) list=null;
    	Map mp = new HashMap();
        mp.put("branchIdList",list);
        mp.put("orgId",user.getVersion());
        
//    	System.out.println(">>>>>>>>fffffff        vvvvvvvv              ccccccccc  >>>>>>orgId"+user.getVersion());
    	

        
        ls = dao.getUserListByBranchIds(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        
        Map BranchCountMap = dao.getUserBranchsCount(mp);
        
		 for(Iterator it = ls.iterator();it.hasNext();){
			    User user_t = (User)it.next();
			    
				System.out.println(">>>>>>>>fffffff        vvvvvvvv              ccccccccc  >>>>>>orgId"+user.getVersion());
				
//				System.out.println(">>>>>>>>fffffff        vvvvvvvv              ccccccccc  >>>>>>orgId"+user.getp);
				
//			    System.out.println(">>>>>>>>>>>>>>orgId"+((User)BranchCountMap.get(user_t.getId())).getBranchsCount());
				
			    user_t.setBranchsCount(((User)BranchCountMap.get(user_t.getId())).getBranchsCount());
		 }       

    	return  ls;
	}
    //父亲找孩子（部门）
     public List getAllChild(Long id,List ls){
    	 List list = branchDao.getBranchIdList(id);
    	 
    	 if(list.size()>0){
    		 for(Iterator it = list.iterator();it.hasNext();){
    				    Long branchId = (Long)it.next();
  	    			 	ls.add(branchId);
  	    			    getAllChild(branchId,ls);
	    	 }
    	 }
    	 return ls;
   }

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.UserManager#getSysUserByRoleId(java.lang.String)
	 */
	public List getSysUserByRoleId(String roleId) {
		return dao.getSysUserByRoleId(new Long(roleId));
	}
	
	public String[] getSysUserColByRoleId(String roleId,String propertyName) {
//		System.out.println(">>>>>>>>>>>>>>roleId"+roleId);
		List ls = dao.getSysUserByRoleId(new Long(roleId));
		
//		System.out.println(">>>>>>>>>>>>>>size"+ls.size());
		
		int size = ls.size();
		String[] s = new String[size];
		
		int j = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				s[j++] = (String) BeanUtils.getProperty(it.next(),propertyName) ;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return s;
	}	
	
	public String[] getSysUserColByRoleIdOrgId(String roleId,String orgId,String propertyName) {
//		System.out.println(">>>>>>>>>>>>>>roleId"+roleId);
		Map mp = new HashMap();
		mp.put("roleId", roleId);
		mp.put("orgId", orgId);
		List ls = dao.getSysUserByRoleIdOrgId(mp);
		
//		System.out.println(">>>>>>>>>>>>>>size"+ls.size());
		
		int size = ls.size();
		String[] s = new String[size];
		
		int j = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				s[j++] = (String) BeanUtils.getProperty(it.next(),propertyName) ;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return s;
	}		
	
	

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.UserManager#getUsersCount(com.vriche.adrm.model.User)
	 */
	public String getUsersCount(User user) {
		 return dao.getUsersCount(user).toString();
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.UserManager#getUsersPage(com.vriche.adrm.model.User, int, int)
	 */
	public PaginatedList getUsersPage(User user, String pageIndex, String pageSize) {

		return dao.getUsersPage(user,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

    public String saveUserObj(User user)  {
		  user.setUsername(user.getUsername().toLowerCase());
		   this.encryptPass(user);
		   String id = String.valueOf(dao.saveUser(user));
		   log.info("saveUser isNew  >>>>>>>>>>>>>>>>"+id);
		   log.info("saveUser user.getBranchId()  >>>>>>>>>>>>>>>>"+user.getBranchId());
		   Map branchMp = new HashMap();
		   
			branchMp.put("userId", id);
			branchMp.put("branchId", user.getBranchId());
		   branchDao.saveBranchUser(branchMp);
          return id;
    }

	/**
     * @see com.vriche.adrm.order.service.UserManager#saveUser(com.vriche.adrm.order.model.User)
     */
    public String saveUser(User user) throws UserExistsException {
       
    	boolean isNew =(user.getId() == null);
    	Long userId = null;
    	String orgId = user.getOrgId().toString();
    	
    	if(log.isDebugEnabled()){
    		log.info("saveUser isNew>>>>>>>>>>>>>>>>"+isNew);
    	}
    	
    	
    	
    	if (isNew) {
            user.setUsername(user.getUsername().toLowerCase());
    	}
    	
        try {
//        	if (user.getRoles() != null){
                Object[] userRoles = user.getRoles().toArray();
                Set newSet = new HashSet();
                Set newSett = new HashSet();
                user.setRoles(newSet);
                for (int i = 0; userRoles != null &&  i < userRoles.length; i++) {
                	if(userRoles[i] != null){
                        String roleName = userRoles[i].toString();
                        log.info("saveUser isNew>>>>>>>>>>>>>>>>"+roleName);
                        Role role = roleDao.getRoleByNameOrgId(orgId,roleName);
                        
                        user.addRole(role);    
                        newSett.add(role);
                	}

                }       		
//        	}

            if(user.isEncryptPass())  this.encryptPass(user);
            
            
        	if(log.isDebugEnabled()){

        		log.info("dao.saveUser>>>>>>>>>>>>>>>>>>>" );
        	} 
        	
            userId = dao.saveUser(user);
            
        	if(log.isDebugEnabled()){
        		log.info("addUserRole>>>>>>>>start>>>>>>>>>>>" );
        	}          
            

            
            this.addUserRole(user,newSett);

            
        	if(log.isDebugEnabled()){

        		log.info("addUserRole>>>>>>>>>>end>>>>>>>>>" );
        	}         
            
            user.setId(userId);
            
            	if (isNew && user.getBranchId()!= null){
            	addUserBranchs(user);
            	
            	
            	
            				}
            
            
        	if(log.isDebugEnabled()){
        		log.info("addUserBranchs>>>>>>>>>>end>>>>>>>>>" +user.toString());
        	}  
        	
        	

        } catch (DataIntegrityViolationException e) {
            throw new UserExistsException("用户 '" + user.getUsername() + "' 已经存在!");
        }
        
    	removeUserInCache(user.getUsername());
    	saveUserInCache(user); 
    	
    	if(!isNew) resetUserMap(user,"update");
    	

		return userId.toString();
    }
    

    
    
	 public void addUserRole(User user,Set newSett){
		 
		  Map mp = new HashMap();
		  mp.put("orgId",user.getOrgId());
		  mp.put("userId",user.getId());
//		  List roles = roleDao.getUserRoles(user.getId().toString());
		  List roles = roleDao.getUserRolesByOrg(mp);
		  
		  
		  for (Iterator it = roles.iterator(); it.hasNext();) {
			  try {
				  Role role = (Role) it.next();
				 
				  authRoleForUser(user,role,true);
			} catch (Exception e) {
				// TODO: handle exception
			}
		  }
		  
	
		  Map mp2 = new HashMap();
		  
		  List ls = dao.getUserRolesByOrgUser(mp);
		  
		  if (log.isDebugEnabled()) {
			  log.info("getOrgId @@@@@@@@@@" +user.getOrgId());
			  log.info("userid @@@@@@@@@@" +user.getId());
			  log.info("*@@@@@@@ uid @@@@@@@@@@" +ls.size());
		  }
		  
		
		  if(ls.size()>0){
			  mp2.put("roleIdList",ls);
			  mp2.put("userId",user.getId());
			  dao.removeUserRolesByIdList(mp2);  
		  }

		  
//		  System.out.println("removeUserRolesByIdList @@@@@@@@@@" +ls.size());
		  
//		  dao.removeUserRoles(user.getId());

		 
	            for (Iterator it = newSett.iterator(); it.hasNext();) {
	            	try {
	            		Role role = (Role) it.next();
	            		Map newRole = new HashMap();
	            		newRole.put("userId", user.getId());
	            		newRole.put("roleId", role.getId());
//	            		System.out.println("*@@@@@@@ uid @@@@@@@@@@" +user.getId() );
//	            		System.out.println("*@@@@@@@ roleid @@@@@@@@@@" +role.getId() );
	            		dao.addUserRole(newRole);
	            		authRoleForUser(user,role,false);
					} catch (Exception e) {
						// TODO: handle exception
					}

	            }
	    
	 }
	 
	 
	 public void addUserBranchs(final User user) {
		 Map newBranch = new HashMap();
		 newBranch.put("userId", user.getId());
		 newBranch.put("branchId", user.getBranchId());
		 dao.addUserBranch(newBranch);
		 resetMap();
	 }
	 
	 
	 private void resetMap(){
		 	LookupManager lookupManager = ServiceLocator.getLookupManager();
		 	Constants.APPLACTION_MAP.remove(Constants.GLOBAL_CUSRUSER_ORGS_OBJ);
			Constants.APPLACTION_MAP.put(Constants.GLOBAL_CUSRUSER_ORGS_OBJ, lookupManager.getUserOrgs());
	 }

	 

    /**
     * @see com.vriche.adrm.order.service.UserManager#removeUser(java.lang.String)
     */
    public void removeUser(String userId) {
        if (log.isDebugEnabled()) {
            log.debug("removing user: " + userId);
        }
        User user = dao.getUser(new Long(userId));
        dao.deleteUserRoles(new Long(userId));
        dao.removeUserBranch(new Long(userId));
        dao.deleteUserRel(new Long(userId));
        dao.deleteCustomerUserRel(new Long(userId));
        
        dao.deleteUserCarrierRel(new Long(userId));
        dao.deleteUserCheck(new Long(userId));
        dao.deleteUserComin(new Long(userId));

        
        
        dao.removeUser(new Long(userId));
        removeUserInCache(user.getUsername());
        resetUserMap(user,"remove");
        
    }
    
    



    /* (non-Javadoc)
	 * @see com.vriche.adrm.dao.UserDao#getUsersXML(com.vriche.adrm.model.User)
	 */
	public String getUsersXML(User u,String IdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"用户列表\" id=\"" + IdPrefix + "-1\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"type\">2</userdata>");
		getUsersItems(sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");

		return new String(sb.toString());
	}  
	
	
	
	public void getUsersItems(StringBuffer sb,String IdPrefix){
		    User u = new User();
			List ls = this.getUsers(u);
			for (Iterator it = ls.iterator();it.hasNext();){
				User user = (User) it.next();
				sb.append("<item id='"+IdPrefix
								+ user.getId().toString()
								+ "' im0=\"support.png\" im1=\"support.png\" im2=\"support.png\" text=\""
								+ user.getFullName().toString() + "\">");
				sb.append("<userdata name=\"workFlowTypeId\">"+ user.getId().toString() +"</userdata>");
				sb.append("</item>");
			}
	}
	
	public void getUsersItemsByBranch(StringBuffer sb,String branchId,String IdPrefix){
		User u = new User();
		u.setBranchId(new Long(branchId));
		
//		System.out.println("branchId>>>>>>>>>>>>>>>>>" +branchId);
		
		List ls =dao.getUsersByBranchId(u);
		
		
//		System.out.println("ls>>>>>>>>>>>>>>>>>" +ls.size());
		
		
		for (Iterator it = ls.iterator();it.hasNext();){
			User user = (User) it.next();
			sb.append("<item id='"+IdPrefix
							+ user.getId().toString()
							+ "' im0=\"support.png\" im1=\"support.png\" im2=\"support.png\" text=\""
							+ user.getFullName().toString() + "\">");
			sb.append("<userdata name=\"type\">3</userdata>");
//			sb.append("<userdata name=\"id\">"+ user.getId().toString() +"</userdata>");
//			sb.append("<userdata name=\"IdPrefix\">" + IdPrefix +"</userdata>");
			sb.append("</item>");
		}
}

	
	
	
	public void getUsersItemsByBranchNew(StringBuffer sb,String orgId,String branchId,String IdPrefix){
		User u = new User();
		u.setBranchId(new Long(branchId));
		List ls =dao.getUsersByBranchId(u);
		for (Iterator it = ls.iterator();it.hasNext();){
			User user = (User) it.next();
			sb.append("<item id='"+orgId+"_"+ branchId +"_"+IdPrefix + user.getId().toString()
							+ "' im0=\"support.png\" im1=\"support.png\" im2=\"support.png\" text=\""
							+ user.getFullName().toString() + "\">");
			sb.append("<userdata name=\"type\">3</userdata>");
			sb.append("<userdata name=\"id\">"+ user.getId().toString() +"</userdata>");
			sb.append("<userdata name=\"branchId\">"+ branchId +"</userdata>");
			sb.append("<userdata name=\"orgid\">"+orgId +"</userdata>");
			sb.append("</item>");
		}
}
	
	
	
	

	public void getUsersItemsByBranch2(StringBuffer sb,String branchId,String IdPrefix,String loginUser){
		User u = new User();
		u.setBranchId(new Long(branchId));
		
		Map mp = new HashMap();
		mp.put("branchId",branchId);
		mp.put("userName",loginUser);
//		System.out.println("branchId>>>>>>>>>>>>>>>>>" +branchId);
//		System.out.println("userName>>>>>>>>>>>>>>>>>" +loginUser);
		
		List ls = dao.getUsersOwnerByBranchId(mp);
		
		for (Iterator it = ls.iterator();it.hasNext();){
			User user = (User) it.next();
			sb.append("<item id='"+IdPrefix
							+ user.getId().toString()
							+ "' im0=\"support.png\" im1=\"support.png\" im2=\"support.png\" text=\""
							+ user.getFullName().toString() + "\">");
			sb.append("<userdata name=\"type\">3</userdata>");
//			sb.append("<userdata name=\"id\">"+ user.getId().toString() +"</userdata>");
//			sb.append("<userdata name=\"IdPrefix\">" + IdPrefix +"</userdata>");
			sb.append("</item>");
		}
}
	
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return (User) dao.loadUserByUsername(username);
    }



	/**
	 * 注意参数中的User需要已经与hibernate session关联，否则无法lazyload得到roles
	 * @param user
	 */
	private void saveUserInCache(User user){
		getRolesByUserId(user);
		GrantedAuthority[] authorities = AuthenticationHelper.convertToGrantedAuthority(user.getRoles(), "name");
		acegiCacheManager.addUser(user.getUsername(), user.getPassword(), user.getEnabled().booleanValue(), true, true, true, authorities);
	}
	
	public void removeUserInCache(String username){
		acegiCacheManager.removeUser(username);
	}
    
	/**
	 * 在用户授权表中动态更新用户权限
	 */
	public void authRoleForUser(User user, Role role, boolean authorized) throws Exception {
		AuthHelper.saveAuth(user.getRoles(), role, authorized);
		saveUserInCache(user);
	}  
	
	
	
	private void getRolesByUserId(User user){
		List roleList = roleDao.getUserRoles(user.getId().toString());
		Set roles = new HashSet();
		CollectionUtils.addAll(roles,roleList.iterator());
		user.setRoles(roles);
	}


	private void encryptPass(User user) {
		  String  algorithm = "SHA";
		  user.setPassword(StringUtil.encodePassword(user.getPassword(), algorithm));
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.UserManager#getCurrentUser()
	 */
//	public User getCurrentUser() {
//		User user = new User();
//		 SecurityContext ctx = SecurityContextHolder.getContext();
//	     String currentUser = "";
//		 if (ctx.getAuthentication() != null) {
//			  Authentication auth = ctx.getAuthentication();
//	          if (auth.getPrincipal() instanceof UserDetails) {
//	              currentUser = ((UserDetails) auth.getPrincipal()).getUsername();
//	          } else {
//	              currentUser = String.valueOf(auth.getPrincipal());
//	          }
//		 }
//
//		try {
//			user = dao.loadUserByUsername(currentUser);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return  user;
//	}
	
	public User getCurrentUser() {
//		System.out.println("??????????");
		return UserUtil.getCurUser();
	}
	
	public String getCurrentUserId() {
		return UserUtil.getCurUserId();
	}
	 public String getCurrentUserIdForEdit(String loginName){
		 return UserUtil.getCurUserId(loginName);
	 }
	 
	 public User getCurrentUser(String loginName){
		 return UserUtil.getCurUser(loginName);
	 }
	 
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.UserManager#getCurrentUserSelect()
	 */
	public Map getCurrentUserSelect() {
		User user = getCurrentUser();
		Map reply = new LinkedHashMap();
	    reply.put(user.getId(),user.getFullName());
	    return reply;
	}

	public Map getUserSelect(User user) {
		List ls = this.getUsers(user);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	User users = new User();
	    	users = (User) it.next();
	    	
	    	reply.put("0","==业务员==");
	    	reply.put(users.getId(),users.getFullName());
	    }
		return reply;
	}

	
	public Map getUserSelectLimit() {
		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
		List ls = getOwnerUsersList(userRelsMap);
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    while(it.hasNext()){
	    	User users = new User();
	    	users = (User) it.next();
	    	
	    	reply.put("0","==业务员==");
	    	reply.put(users.getId(),users.getFullName());
	    }
		return reply;
	}
	
	public List getOwnerUsersList(Map map) {
//		 SecurityContext ctx = SecurityContextHolder.getContext();
	     String currentUser = UserUtil.getCurrentPrincipalUser();
		 List ls = (List)map.get(currentUser);
//		 System.out.println("map.size()"+currentUser) ;
//		 System.out.println(map.size()) ;
		return ls;
	}
	
	public List getOwnerUsersList(Map map,String currentUser) {
		currentUser = (currentUser == null||"".equals(currentUser))?UserUtil.getCurrentPrincipalUser():currentUser;
		 List ls = (List)map.get(currentUser);
		return ls;
	}
	
	public List getOwnerUsersListForReport(Map map,String curUserName) {
		 List ls = (List)map.get(curUserName);
		return ls;
	}
	
	public void saveUserRel(String orgId,String parentUserId, String[] userId) {
		Map mp = new HashMap();
		mp.put("orgId",orgId);
		mp.put("parentUserId",parentUserId);

//		 System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orgId) ;
//		 System.out.println("customerId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+parentUserId) ;

		dao.deleteUserRelByParent(mp);
		
		for(int i=0; i< userId.length;i++){
			mp.put("userId",new Long(userId[i]));
			dao.saveUserRel(mp);		
		}
		
//		System.out.println("parentUserId>>>>>>>>>>>>>>>>>>>>>>>>>>>77777777777777888888888888888888888888888877777777777777777777>>>>>>>>>>>>>>>>"+parentUserId) ;
		 String userName =UserUtil.getUserNameById(parentUserId);

		 List idsList = new ArrayList();
//		 idsList =  UserUtil.getUserRelIds(parentUserId);
		  Map mp1 = new HashMap();
		  mp1.put("parentId",parentUserId);
		 idsList =  dao.getUserRel(mp1);                              
		 Map mpUserRelId = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
		 mpUserRelId.put(userName,idsList);

		 Map mpUserRel = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS); 
		 Map mp2 = new HashMap();
		 mp2.put("userIdList",idsList);
		 mpUserRel.put(userName,dao.getUsersByIdList(mp2));

	}
	
//	parentUserId,allCheckedBranches,IdPrefix
	public void saveUserRel2(String parentUserId,String idStr, String IdPrefix) {
		
//		System.out.println("parentUserId>>>>>>>>>>>>>>>>>>>>>>>>>>>77777777777777888888888888888888888888888877777777777777777777 parentUserId>>>>>>>>>>>>>>>>"+parentUserId) ;
//		System.out.println("idStr>>>>>>>>>>>>>>>>>>>>>>>>>>>77777777777777888888888888888888888888888877777777777777777777 idStr >>>>>>>>>>>>>>>>"+idStr) ;
//		System.out.println("idStr>>>>>>>>>>>>>>>>>>>>>>>>>>>77777777777777888888888888888888888888888877777777777777777777 idStr >>>>>>>>>>>>>>>>"+"".equals(idStr)) ;
		
		
		String[] orgs = getUserOrgs(parentUserId);
		
		
		for(int i = 0;i<orgs.length;i++){
			Map mp22 = new HashMap();
			mp22.put("orgId",orgs[i]);
			mp22.put("parentUserId",parentUserId);
			dao.deleteUserRelByParent(mp22);
		}

		
		if(!"".equals(idStr)){
			if(idStr.substring(idStr.length()-1,idStr.length()) == ","){
				idStr = idStr.substring(0,idStr.length()-1);
			}
		}

		

		
		String[] branchedIds = idStr.split(",");
		
		Map mp0 = new HashMap();
		
		for(int i = 0 ;i< branchedIds.length-1;i++){
			String oneStr = branchedIds[i];
			if(oneStr.indexOf("_")>-1){
				String[] oneIds = oneStr.split("_");
				String orgId = oneIds[0];
				String uId = oneIds[oneIds.length-1];
				int fixLen = IdPrefix.length();
				int end  = uId.length();
				int index = uId.indexOf(IdPrefix);			
				uId = uId.substring(index+fixLen,end);

				if(mp0.containsKey(orgId)){
					List userIdList = (List)mp0.get(orgId);
					if(!userIdList.contains(uId)){
						userIdList.add(uId);
						mp0.put(orgId,userIdList);
					}
					
				}else{
					List userIdList = new ArrayList(); 
					userIdList.add(uId);
					mp0.put(orgId,userIdList);
				}
			}
		}
		
		
		Iterator orgIt = mp0.keySet().iterator();
		while(orgIt.hasNext()){
			String orgId = (String)orgIt.next();
			List uidList =(List) mp0.get(orgId);
			
			Map mp = new HashMap();
			mp.put("orgId",orgId);
			mp.put("parentUserId",parentUserId);
			dao.deleteUserRelByParent(mp);
			
			System.out.println("orgId>>>>>>>>>>>>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orgId) ;
			
			for(int i=0; i< uidList.size();i++){
				String uid = (String)uidList.get(i);
				mp.put("userId",new Long(uid));
				
				
				System.out.println("uid>>>>>>>>>>>>>>>>VVVVVVVV>>>>>>>>>>>>>>>>>>>>>>>>>>>"+uid) ;
				dao.saveUserRel(mp);		
			}
			
		}
		
		
		
		
		
//		Map mp = new HashMap();
//		mp.put("orgId",orgId);
//		mp.put("parentUserId",parentUserId);
//
////		 System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orgId) ;
////		 System.out.println("customerId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+parentUserId) ;
//
//		dao.deleteUserRelByParent(mp);
//		
//		for(int i=0; i< userId.length;i++){
//			mp.put("userId",new Long(userId[i]));
//			dao.saveUserRel(mp);		
//		}
		
//		System.out.println("parentUserId>>>>>>>>>>>>>>>>>>>>>>>>>>>77777777777777888888888888888888888888888877777777777777777777>>>>>>>>>>>>>>>>"+parentUserId) ;
		 String userName =UserUtil.getUserNameById(parentUserId);

		 List idsList = new ArrayList();
//		 idsList =  UserUtil.getUserRelIds(parentUserId);
		  Map mp1 = new HashMap();
		  mp1.put("parentId",parentUserId);
		 idsList =  dao.getUserRel(mp1);                              
		 Map mpUserRelId = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
		 mpUserRelId.put(userName,idsList);

		 Map mpUserRel = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS); 
		 Map mp2 = new HashMap();
		 mp2.put("userIdList",idsList);
		 mpUserRel.put(userName,dao.getUsersByIdList(mp2));

	}
	public void saveUserRelByParent(String orgId, String[] parentUserIds,String userId) {
		Map mp = new HashMap();
		mp.put("orgId",orgId);
		mp.put("userId",userId);

		
		for(int i=0; i< parentUserIds.length;i++){
			String parentUserId = parentUserIds[i];
			mp.put("parentUserId",parentUserId);
	
			dao.saveUserRel(mp);	

			 String userName =UserUtil.getUserNameById(parentUserId);

			 List idsList = new ArrayList();

			  Map mp1 = new HashMap();
			  mp1.put("parentId",parentUserId);
			 idsList =  dao.getUserRel(mp1);                              
			 Map mpUserRelId = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
			 mpUserRelId.put(userName,idsList);

			 Map mpUserRel = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS); 
			 Map mp2 = new HashMap();
			 mp2.put("userIdList",idsList);
			 mpUserRel.put(userName,dao.getUsersByIdList(mp2));
			
		}
		
//		System.out.println("parentUserId>>>>>>>>>>>>>>>>>>>>>>>>>>>77777777777777888888888888888888888888888877777777777777777777>>>>>>>>>>>>>>>>"+parentUserId) ;


	}
	

	public Object[] getUserRel(String orgId,String parentUserId) {
        Map mp = new HashMap();
        mp.put("orgId",orgId);
        mp.put("parentId",parentUserId);
					List list = dao.getUserRel(mp);
					Object[] ids = ConvertUtil.convertFromListToArray(list);
		
		// TODO Auto-generated method stub
		return ids;
	}
	
	


	public Set getOwnerUsers(Map map) {
		 Set users = new HashSet();
         CollectionUtils.addAll(users,this.getOwnerUsersList(map).iterator());
		return users;
	}

	public Map getUserSelectFromMap(User user) {
		// TODO Auto-generated method stub
		
		List us = dao.getUsers(null);
		
		Map reply = new LinkedHashMap();
		
	    Iterator it = us.iterator();
    	reply.put("0","==业务员==");
	    while(it.hasNext()){
	    	
	    	User users = (User) it.next();
	    	
	    	reply.put(users.getId(),users.getFullName());
	    }
		return reply;
		
	}

	public String getUserFullName(String userLongName) {
		// TODO Auto-generated method stub
		return UserUtil.getUserFullName(userLongName);
	}

	public void saveUserCarrierRel(String orgId, String userId, String[] carrierIds) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		
		Map mp2 = new HashMap();
		mp2.put("orgId",orgId);
		mp2.put("userId",userId);
		
		 System.out.println("saveUserCarrierRel orgId>>>>>>>>>>>>>>>>>"+orgId) ;
		 System.out.println("saveUserCarrierRel userId>>>>>>>>>>>>>>>>>"+userId) ;
		
		dao.deleteUserId(mp2);
		
		if(carrierIds!=null){
			for(int i=0; i< carrierIds.length;i++){
				mp.put("userId",userId);
				mp.put("carrierId",new Long(carrierIds[i])); 
				dao.saveUserCarrierRel(mp);		
		
			}	
		}
		
		 String userName =UserUtil.getUserNameById(userId);
		 Map mpUserCarr = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS_ID);
		 Map mpUserCarrObj = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
		 
		 
		 List idsList = new ArrayList();
	
		 List list = dao.getUserCarrierRel(new Long(userId));
		 String[] sss = new String[list.size()];
		 int size = list.size();
		 for(int i=0; i< size;i++){
			 sss[i] = String.valueOf((Long)list.get(i));
		 }

//		 String[] sss = (String[]) list.toArray(new String[list.size()]);
		 CollectionUtils.addAll(idsList,sss);
		 mpUserCarr.put(userName,idsList);
		 
		 Map mp1 = new HashMap();
		 mp1.put("CarrierIdList",idsList);
		 List lsObj = CarrierUtil.getAllCarriersLevelOneByIdList(mp1);
		 mpUserCarrObj.put(userName,lsObj);		 
	}

	public Object[] getUserCarrierRel(String userId) {
		// TODO Auto-generated method stub
		List list = dao.getUserCarrierRel(new Long(userId));
		Object[] ids = ConvertUtil.convertFromListToArray(list);
		return ids;
	}

	public Map getUserByCarrier(String carrierId,String customerId) {
		Map mp = new HashMap();
		List carrierIdList = CarrierUtil.getCarrierIds(carrierId,"1","");
		
		

		mp.put("carrierId",carrierId);
		mp.put("customerId",customerId);
		mp.put("carrierIdList",carrierIdList);
		
		List list = dao.getUserByCarrier(mp);
//		 System.out.println("carrierId>>>>>>>>>>>>>>>>>"+carrierId) ;
//		 System.out.println("customerId>>>>>>>>>>>>>>>>>"+customerId) ;
		Map reply = new LinkedHashMap();
		
		for(Iterator it = list.iterator();it.hasNext();){
			User user = (User) it.next();
			reply.put(user.getId(),user.getFullName());
//			 System.out.println(">>>>>>>>>>>>>>>>>"+user.getFullName()) ;
		}
		return reply;
	}
	
	public Map getUserByRole(String role){
		Map reply = new LinkedHashMap();
		List list = dao.getUserByRole(role);
//		 System.out.println(">>>>>>>>>>>>>>>>>"+list.size()) ;
		reply.put("0","==业务员==");
		for(Iterator it = list.iterator();it.hasNext();){
			User user = (User) it.next();
			reply.put(user.getId(),user.getFullName());
		}
		return reply;
	}

	public void updateUserPassword(String username,String newPassword) {
		Map mp = new HashMap();
		newPassword =StringUtil.encodePassword(newPassword, "SHA");
		mp.put("password",newPassword);
		mp.put("username",username);
		dao.updateUserPassword(mp);
		
    	removeUserInCache(username);
    	User user = this.getUserByUsername(username);
    	saveUserInCache(user);  
    	
	}

	public boolean getUserByNamePwd(String username, String password) {
		Map mp = new HashMap();
		password =StringUtil.encodePassword(password, "SHA");
		mp.put("password",password);
		mp.put("username",username);
		Integer id = dao.getUserByNamePwd(mp);
//		 System.out.println("id>>>>>>>>>>>>>>>>>"+id) ;
		return id != null;
	}
	
	public List getUserNameByCustomerId(String customerId) {
			return dao.getUserNameByCustomerId(new Long(customerId));
	}
	
	
	public Map getOwnerUsersMapByCurrentUser(User u) {
		String currentUser = u.getUsername();
		Integer type = u.getVersion();
		
		Map reply = new LinkedHashMap();
		
		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
		List list = (List)userRelsMap.get(currentUser);
		
		 if(type != null){
			 if(type.toString().equals("1")) reply.put("0","==所有==");
		 }
	
		 
		for (Iterator it = list.iterator(); it.hasNext();) {
			User user = (User) it.next();
			reply.put(user.getId(), user.getFullName());
		}
		return reply;
	}
	
	
	
	
	 public static String toISO(String string) {
		if (string == null)return "";
		try {
			return new String(string.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "";
		}

	}

	public boolean createOpenFireUser() {
		boolean able = SmackUtil.isUseOpenFire();
		
		Map openFireUsers = new HashMap();
		
		Map branchsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_BRANCHS);
		
		String resourceName ="spark";
		
//		System.out.println("create user start>>>>>>>>>>>>>>>>>"+branchsMap.size()) ;
		
//		System.out.println("create user start>>>>>>>>>>>>>>>>>") ;
		
		XMPPConnection con = SmackUtil.getXMPPConnection();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			System.out.println("login fail !") ;
//		} 
		
		if(able && con.isConnected()){
			List ls = UserUtil.getAllUsers();
			String pwd ="123";
			for(Iterator it = ls.iterator();it.hasNext();){
				User user = (User) it.next();
				String userName = user.getUsername();
				if(!userName.equals("admin")){
					SmackUtil.createUser(con,userName,pwd);
					System.out.println("create user name>>"+userName) ;
					openFireUsers.put(userName,pwd);
				}
			}		
			SmackUtil.createUser(con,"helperInc", "helperInc123");
			SmackUtil.createUser(con,"helperCuik", "helperCuik123");
		}
		
		con.close();
		
		System.out.println("create user end>>>>>>>>>>>>>>>>>") ;
		

		
		
		
		//添加花名册
//		List ls = UserUtil.getAllUsers();
//		for(Iterator it1 = openFireUsers.keySet().iterator();it1.hasNext();){
//			
//			if(!con.isConnected()){
//				con = SmackUtil.getXMPPConnection();
//			}
//			String username =  (String)it1.next();
//			String pwd =  "123";
//
//
//			try {
//				
//				String user = toISO(username);
//				System.out.println("username>>>>>>>>>>>>>>>>>"+username) ;
//				System.out.println("user>>>>>>>>>>>>>>>>>"+user) ;
//				con.login(user,pwd,resourceName);
//				
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					System.out.println("login fail !") ;
//				} 
//				
//				SmackUtil.creatGroup(con,branchsMap);
////				Roster roster  = con.getRoster();
////				roster.setSubscriptionMode(Roster.SUBSCRIPTION_ACCEPT_ALL);
//				
////				System.out.println("roster>>>>>>>>>>>>>>>>>"+roster) ;
//				
//			} catch (XMPPException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
////			XMPPConnection con = SmackUtil.getXMPPConnection(username,pwd,"");
//			
////			 System.out.println("username>>>>>>>>>>>>>>>>>"+username) ;
//			 System.out.println("con.isAuthenticated>>>>>>>>>>>>>>>>>"+con.isAuthenticated()) ;
//			 System.out.println("con.getUser>>>>>>>>>>>>>>>>>"+con.getUser()) ;
//			 
//			 
//		
////
////			
//		
////			
//////			Roster roster = con.getRoster();
////			for (Iterator i=roster.getEntries(); i.hasNext(); ) {
////			    System.out.println("roster obj>>>>>>>>>>>>>>>>>"+i.next());
////			}
//
//			
//			Roster roster = con.getRoster();
//			if (roster != null) {
//				roster.setSubscriptionMode(Roster.SUBSCRIPTION_MANUAL);
////				roster.setDefaultSubscriptionMode(Roster.SUBSCRIPTION_MANUAL);
//				for(Iterator it = ls.iterator();it.hasNext();){
//					User user = (User) it.next();
//					String userN = user.getUsername();
//					String nickname = user.getFullName();
//					String branchId = user.getBranchId().toString();
//					String group = (String)branchsMap.get(branchId);
//					if(!userN.equals("admin") && !userN.equals(username)){
//						userN = userN+"@"+SmackUtil.serviceName+"/"+resourceName;
//						SmackUtil.addUserToRoster(roster,userN,nickname,new String[]{group});
//					}
//				}		
//			}
//			
//			con.close();
//			
//			
//		}
//		
//		con.close();
		

//		loginAccount(connHelperInc, "helperInc", "helperInc123", "Spark");
//		loginAccount(connHelperCuik, "helperCuik", "helperCuik123", "Spark");
		
		
		return true;
	}
	
	 public void removeUserInBranch(User user) throws UserExistsException {
		 
		 
	      try {
	    	  
		       List ls = branchDao.getBranchsByUser(user);
		       
		       if(ls.size() == 1){
		    	   throw new UserExistsException( "【" + user.getUsername()+"】是此用户最后一个归属部门，系统不允许用户无部门归属");
		       }else{
			    	dao.removeUserInBranch(user);   
			    	resetMap();
			    	
//			    	LookupManager lookupManager = ServiceLocator.getLookupManager();
//			    	Constants.APPLACTION_MAP.remove(Constants.GLOBAL_CUSRUSER_ORGS_OBJ);
//			    	Constants.APPLACTION_MAP.put(Constants.GLOBAL_CUSRUSER_ORGS_OBJ, lookupManager.getUserOrgs());
			    	
		       }

	    	  if (log.isDebugEnabled()){
	    		  log.info("getBranchsByUser ls.size>>>>>>>>>>>>>>>>>"+ls.size());
	    		  log.info("removeUserInBranch getBranchId>>>>>>>>>>>>>>>>>"+user.getBranchId());
	    	  }
	   
	    	  
	        } catch (DataIntegrityViolationException e) {
	            throw new UserExistsException("用户 '" + user.getUsername() + "' 已经存在!");
	        }		 
	  }
	 
	 
	 public List getUsersAnalyze(User user){
		 Map mp = new HashMap();
		 
		 Long orgId = user.getOrgId();
		 String carrierId = user.getPasswordHint();
		 String customerId = user.getUsername();
		 String fullName = user.getFullName();
		 String customerIds = user.getCustomerIds();
			List customerIdList = new ArrayList();
		 
		 System.out.println("fullName>>>>>>>>>>>>>>>>>"+fullName) ;
	     if("ALL".equals(fullName)) fullName = "";
		 
		 carrierId = "".equals(carrierId)||"0".equals(carrierId)||"null".equals(carrierId)||"undefined".equals(carrierId)?null:carrierId;
		 customerId = "".equals(customerId)||"0".equals(customerId)||"null".equals(customerId)||"undefined".equals(customerId)?null:customerId;
		 fullName = "".equals(fullName)||"0".equals(fullName)||"null".equals(fullName)||"undefined".equals(fullName)?null:fullName;
		 
//		 customerIds = "".equals(customerIds)||"null".equals(customerIds)||"undefined".equals(customerIds)?null:customerIds;
		 
		 
		 
		 
		  System.out.println("orgId>>>>>>>>>>>>>>>>>"+orgId) ;
		  System.out.println("carrierId>>>>>>>>>>>>>>>>>"+carrierId) ;
		  System.out.println("customerId>>>>>>>>>>>>>>>>>"+customerId) ;
		  System.out.println("fullName>>>>>>>>>>>>>>>>>"+fullName) ;
//		  System.out.println("fullName>>>>>>>>22222222222222222222>>>>>>>>>"+fullName) ;
		  System.out.println("customerIds>>>>>>>>22222222222222222222>>>>>>>>>"+customerIds) ;
		  
			 List carrierIdList  = new ArrayList();
			 boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
			 
			 if(carrierId != null){
				  if(carrierAlisname){
				    	String ids = CarrierUtil.getOtherSameAlisnameIds(carrierId);
				    	
				    	System.out.println("orgId>>>>>>>>>>>>>>>>>"+orgId) ;
				    	
				    	if( ids.indexOf(",") >-1){
							String[] s2 = ids.split(",");
							
							for (int j = 0; j < s2.length; j++) {
								 carrierIdList.add(s2[j]);
							}
				    	}else{
				    		 carrierIdList.add(carrierId);
				    	}

				    }else{
				    	carrierIdList.add(carrierId);
				    }				 
			 }
			  		  
		  
		  
		 mp.put("orgId",orgId);
//		 mp.put("carrierId",carrierId);
		 mp.put("carrierIdList",carrierIdList);
		 
		 if(fullName == null || "".equals(fullName)){
			 mp.put("customerId",customerId);
		 }

		 mp.put("fullName",fullName);
		 
		 
			if(!"".equals(customerIds) && customerIds != null){
				String[] custids = customerIds.split(",");
				org.apache.commons.collections.CollectionUtils.addAll(customerIdList,custids);
				mp.put("customerIdList",customerIdList);
			}  
			
		 
		 List ls = dao.getUsersAnalyze(mp);
		 
//		 if(ls.size() == 0){
//			 ContractDao contractDao  = ServiceLocator.getContractDao();
//		 }
//		 System.out.println("ls>>>>>>>>>>>>>>>>>"+ls.size()) ;
		 
		 return ls;
	 }
	
		public String getBranchsByUser(User user) {
			// TODO Auto-generated method stub
			return null;
		}
		
	 public List getUserRelList(String orgId,String parentUserId) {
	        Map mp = new HashMap();
	        mp.put("orgId",orgId);
	        mp.put("parentId",parentUserId);
			return  dao.getUserRel(mp);
	 }

	 public List getUsersFromOrder(User user,String type){
		 Map mp = new HashMap();
		 
		 Long orgId = user.getOrgId();
		 String version = StringUtil.getNullValue(user.getVersion(),null);
		 String fullName = user.getFullName();
		 String loginUser = user.getLoginUser();
		 String customerId = user.getCustomerIds();
		 

//		 carrierId = "".equals(carrierId)||"0".equals(carrierId)||"null".equals(carrierId)||"undefined".equals(carrierId)?null:carrierId;
		 fullName = "".equals(fullName)||"0".equals(fullName)||"null".equals(fullName)||"undefined".equals(fullName)?null:fullName;
		 type = "".equals(type)||"0".equals(type)||"null".equals(type)||"undefined".equals(type)||type == null?"1":type;
		 


		  System.out.println("orgId>>>>>>>>>>>>>>>>>"+orgId) ;
		  System.out.println("type>>>>>>>>>>>>>>>>>"+type) ;
		  System.out.println("loginUser>>>>>>>>>>>>>>>>>"+loginUser) ;
		  System.out.println("fullName>>>>>>>>>>>>>>>>>"+fullName) ;
		  System.out.println("version>>>>>>>>>>>>>>>>>"+version) ;
		  System.out.println("customerId>>>>>>>>>>>>>>>>>"+customerId) ;
		  
		 mp.put("year",version); 
		 mp.put("orgId",orgId);
		 mp.put("type",type);
//		 mp.put("loginUser",loginUser);
		 mp.put("fullName",fullName);
		 
		 if(!"".equals(customerId) && !"0".equals(customerId)  && customerId != null){
			 mp.put("customerId",customerId);
		 }
		 
		 if("1".equals(type)){
			 List ls = UserUtil.getCurUserRels(loginUser);
			 mp.put("userIdList",ls); 
//			 System.out.println("getCurUserRels>>>>>>>>>>>>>>>>>"+ls) ;
		 }

		 
		 
		 
		 List ls = dao.getUsersFromOrder(mp);
		 
		 System.out.println("ls>>>>>>>>1111111111111111>>>>>>>>>"+ls.size()) ;

		 return ls;
	 }
	
	 
	 
	 public List getUsersByOrgLimit(User user){
		 Map mp = new HashMap();
		 boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
		 List orgIdList = new ArrayList();
		 String orgId = StringUtil.getNullValue(user.getOrgId(),"1");
		 String fullName = user.getFullName();
		 String loginUser = user.getLoginUser();
		 fullName = "".equals(fullName)||"0".equals(fullName)||"null".equals(fullName)||"undefined".equals(fullName)?null:fullName;
		 List ls = UserUtil.getCurUserRels(loginUser,orgId);

//		 System.out.println("getUsersByOrgLimit>>>>orgId>>>>11111111111111111111111111111111111111111111111111>>>>>>>>>"+orgId) ;
//		 System.out.println("getUsersByOrgLimit>>>>>fullName>>>11111111111111111111111111111111111111111111111111>>>>>>>>>"+fullName) ;
//		 System.out.println("getUsersByOrgLimit>>>>>ls>>>11111111111111111111111111111111111111111111111111>>>>>>>>>"+ls.size()) ;
		 
		 
//		 getOrgChileds
		 
		 if(isOneOrgMoreSuborgs){
			 if("1".equals(orgId)) {
				 orgIdList = SysParamUtil.getOrgChileds(orgId);
			 }else{
				 orgIdList.add(orgId);
			 }
			 mp.put("orgIdList",orgIdList); 
		 }else{
			 mp.put("orgId",orgId);
		 }


		 mp.put("fullName",fullName);
		 mp.put("userIdList",ls); 
		 
		return  dao.getUsersByOrgLimit(mp);
	 }
	 
	 
	 
	 private  List getUserOrderYear(User user){	 

		String yearsStr = user.getAddress().getCountry();
		if(yearsStr == null) yearsStr ="";
		List ls = new ArrayList();
		
		if(yearsStr.length()>0){
			if(yearsStr.indexOf(",")>-1){
				CollectionUtils.addAll(ls,yearsStr.split(","));
			}else{
				ls.add(yearsStr);
			}
		}
		return ls;
	 }
	 private  List  getUserCustomerType(User user){	 
		 
		    Map cut_cat_map = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CUSTOMER_TYPE_MAP);
		 
		    List resList = new ArrayList();
		 
		    String cutType = user.getAddress().getCity();
	    	if(cutType == null || "".equals(cutType)) cutType = "0";
	    	
	    	if( "Denver".equals(cutType)) cutType = "2,3,4";
	    	
	    	 List list = new ArrayList();
	    	 List list2 = new ArrayList();
	    	 
			  list.add("1");
			  list2.add((Category)cut_cat_map.get("1"));
	    	 
	    	if(cutType.indexOf(",")>-1){
	    		 String[] s = cutType.split(",");
	    		 for(int j = 0;j<s.length;j++){
	    			  list.add(s[j]);
	    			  list2.add((Category)cut_cat_map.get(s[j]));
	    		 }   
	    	}else{
	    		list.add(cutType);
	    		
	    		if(!"0".equals(cutType)){
	    			list2.add((Category)cut_cat_map.get(cutType));
	    		}
	    		
	    		
	    	}
	        resList.add(0,list);
	        resList.add(1,list2);
	        
	        return resList;
		 }
	 
	 private  void resetUserMap(User user,String method){
		 
		 String id = user.getId().toString();
		 String userName = user.getUsername();

		 Map user_id_map = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USERS_MAP);
		 Map user_name_map = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USERS_MAP_USERNAME);
		 Map mpUserOrderYear = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_ORDER_YEAR_REL);
		 Map mpCustomerType1 = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_ID);
		 Map mpCustomerType2 = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_OBJ);
		 
//	        System.out.println("getUserOrgs ......................");
//	        Constants.APPLACTION_MAP.remove(Constants.GLOBAL_CUSRUSER_ORGS_OBJ);
//	    	Constants.APPLACTION_MAP.put(Constants.GLOBAL_CUSRUSER_ORGS_OBJ, mgr.getUserOrgs());
		 
		 if("update".equals(method)){
			 
			 User old_user = (User)user_id_map.get(id);
			 
			 String yearsStr_old = user.getAddress().getCountry();
			 String yearsStr ="";
			 if(old_user != null){
				  yearsStr = old_user.getAddress().getCountry();
			 }

			 
			 String cutType_old = user.getAddress().getCity();
			 String cutType ="";
			 if(old_user != null){
				  cutType = old_user.getAddress().getCity();
			 }
			 if(!yearsStr_old.equals(yearsStr)){
				 mpUserOrderYear.put(userName,getUserOrderYear(user)); 
			 }

			 if(!cutType_old.equals(cutType)){
				 List resList = new ArrayList();
				 resList = getUserCustomerType(user);
				 mpCustomerType1.put(userName,resList.get(0));
				 mpCustomerType2.put(userName,resList.get(1));
			 }

			 
			 user_id_map.put(id,user);
			 user_name_map.put(userName,user);
			 
		 }else{
			 user_id_map.remove(id);
			 user_name_map.remove(userName);
			 mpUserOrderYear.remove(userName);
			 mpCustomerType1.remove(userName);
			 mpCustomerType2.remove(userName);

			 Map mpUserRel = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
			 mpUserRel.remove(userName);
			 Map mpUserRelId = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
			 mpUserRelId.remove(userName);

			 
			 Map mpUserCarrier = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS_ID);
			 mpUserCarrier.remove(userName);
			 Map mpUserCheckRel = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CHECK_USER_REL);
			 mpUserCheckRel.remove(userName);
			 
			 

			
		 }

	  }

	 public List getTree(Map searchMap){
			List trees = new ArrayList();
			
//			boolean industryLevel2Param = SysParamUtil.getIndustryLevel2Param();
//			boolean xmtv = SysParamUtil.isXMTVParam(null);
			String nodeId = StringUtilsv.getNullValue(searchMap.get("realId"),"0");
			String orgId = StringUtilsv.getNullValue(searchMap.get("orgId"),"");
			String nodeType = StringUtilsv.getNullValue(searchMap.get("nodeType"),"0");
			String nodelevel = StringUtilsv.getNullValue(searchMap.get("nodelevel"),"0");
			
			StringUtilsv.printMap(searchMap);
			System.out.println("nodeType>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+nodeType) ;
			System.out.println("nodeId>>>>77777777777777777777      yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+searchMap.get("orgId")) ;
			System.out.println("orgId>>>>888888888888888888888888       yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+orgId) ;
			
			if("0".equals(nodeType)&&"0".equals(nodeId)){
				   Branch b = new Branch();
				   b.setParentId(nodeId);
				   if(!" ".equals(orgId)){
					   b.setOrgId(new Long(orgId));
				   }
				  
				   b.setTreeLevel(new Integer(1));
				   
				   List ls = branchDao.getBranchs(b);
					
					for (Iterator it = ls.iterator();it.hasNext();){
						Map map = new HashMap();
						Branch branch = (Branch) it.next();
						
						Branch branchPar = new Branch();
						branchPar.setParentId(branch.getId().toString());
						List ls4 = branchDao.getBranchs(branchPar);
						boolean isLeaf4 = (ls4.size() == 0);
						
						User userPar = new User();
						userPar.setBranchId(branch.getId());
						int userCount = dao.getUsersByBranchIdCount(userPar).intValue();
						boolean isLeaf5 = (userCount == 0);
						
						boolean isLeaf = isLeaf4 && isLeaf5;

						map.put("id", "branch_"+branch.getId());
//						map.put("id", branch.getId());
						map.put("text", branch.getName());
						map.put("leaf", new Boolean(isLeaf));
						map.put("type", "1");
						map.put("realId", branch.getId());
						
						
						if(!isLeaf5){
							map.put("level", "1");
						}
						trees.add(map);
					}
			}
			
			if("1".equals(nodeType)&&!"0".equals(nodeId)){
				getBranchsItems(trees,orgId,nodeId);
			}
			

			System.out.println("ls2>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+"1".equals(nodeType)) ;
			System.out.println("ls2>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+!"0".equals(nodeId)) ;
			System.out.println("nodelevel>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+nodelevel) ;
			
			if(("1".equals(nodeType))&&!"0".equals(nodeId) && "1".equals(nodelevel)){	
				getUsersItems(trees,nodeType,nodeId);
			}
	
			
			return trees;
		}
	 
	 
		private void getBranchsItems(List trees,String orgId,String parentId) {
			   Branch b = new Branch();
			   b.setParentId(parentId);
			   b.setTreeLevel(new Integer(1));
//			   b.setOrgId(new Long(orgId));
			   
			   List ls = branchDao.getBranchs(b);
				
				for (Iterator it = ls.iterator();it.hasNext();){
					Map map = new HashMap();
					Branch branch = (Branch) it.next();
					
					Branch branchPar = new Branch();
					branchPar.setParentId(branch.getId().toString());
					branchPar.setTreeLevel(new Integer(1));
					List ls4 = branchDao.getBranchs(branchPar);
					boolean isLeaf4 = (ls4.size() == 0);
					
					
					User userPar = new User();
					userPar.setBranchId(branch.getId());
					int userCount = dao.getUsersByBranchIdCount(userPar).intValue();
					boolean isLeaf5 = (userCount == 0);
					
					boolean isLeaf = isLeaf4 && isLeaf5;
					
//					if(!isLeaf){
//						getBranchsItems(trees,orgId,branch.getId().toString());
//					}
					
					map.put("id", "branch_"+branch.getId());
					map.put("text", branch.getName());
					map.put("leaf", new Boolean(isLeaf));
					map.put("type", "1");
					map.put("realId", branch.getId());
					
					if(isLeaf){
						map.put("level", "1");
					}
					trees.add(map);
				}
	
		}
		
		
		public List getUsersItems(List trees,String nodeType,String branchId){

			User u = new User();
			u.setBranchId(new Long(branchId));
			
//			System.out.println("branchId>>>>>>>>>>>>>>>>>" +branchId);
			
			List ls =dao.getUsersByBranchId(u);
			
			
//			System.out.println("ls>>>>>>>>>>>>>>>>>" +ls.size());
			
			
			for (Iterator it = ls.iterator();it.hasNext();){
				Map map = new HashMap();
				User user = (User) it.next();
				map.put("id", user.getId());
				map.put("text", user.getFullName());
				map.put("leaf", new Boolean(true));
				map.put("type", "2");
				map.put("realId", user.getId());
				trees.add(map);

			}			
			
			return trees;
			
		}

		public void saveUserRelOrg(User user) {
//			Map map = new HashMap();
//			User userP = new User();
//			userP.setBranchId(user.getBranchId());
//			List userIds =  dao.getUsers(userP);
//			map.put("orgId", user.getOrgId());
//			map.put("branchId", user.getBranchId());
		}
		
		
		
		
		public String[] getUserOrgs(String uid){
			
//			System.out.println("getUserOrgs>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+uid) ;
			
			List ls = dao.getUserOrgs(uid);
			
			String[] ids = new String[ls.size()];
//			CollectionUtils.ad
//			org.apache.commons.lang.StringUtils.
			Iterator it = ls.iterator();
			int i = 0;
			while(it.hasNext()){
				ids[i++] = (String)it.next();
			}
//			System.out.println("ids>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+ids) ;
			return ids;
		}
		public String[] getUserOrgs2(String userName){
			User u = UserUtil.getCurUser(userName);
			return this.getUserOrgs(u.getId().toString());
		}
	
	
}
