package com.vriche.adrm.service.impl;

//import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.dao.RoleDao;
import com.vriche.adrm.dao.SysResourceDao;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.Role;
import com.vriche.adrm.model.SysResource;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.RoleManager;
import com.vriche.adrm.service.security.acegi.AuthenticationHelper;
import com.vriche.adrm.service.security.acegi.cache.AcegiCacheManager;
import com.vriche.adrm.service.security.acegi.resource.ResourceDetails;
import com.vriche.adrm.util.AuthHelper;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

/**
 * Implementation of RoleManager interface.</p>
 * 
 * <p><a href="RoleManagerImpl.java.html"><i>View Source</i></a></p>
 * 
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
public class RoleManagerImpl extends BaseManager implements RoleManager {
	private AcegiCacheManager acegiCacheManager;
    private RoleDao dao;
    private UserDao userDao;
    private SysResourceDao sysResourceDao;
    private OrgDao orgDao;
    
    
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}	

	
	public void setAcegiCacheManager(AcegiCacheManager acegiCacheManager) {
		this.acegiCacheManager = acegiCacheManager;
	}

	/** 
	 * @param dao The dao to set.
	 */
	public void setDao(RoleDao dao) {
		this.dao = dao;
	}

    public void setRoleDao(RoleDao dao) {
        this.dao = dao;
    }
    

	public void setSysResourceDao(SysResourceDao sysResourceDao) {
		this.sysResourceDao = sysResourceDao;
	}	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}	
	


    public List getRoles(Role role) {
        return dao.getRoles(role);
    }
    
    public List getRoless(Role role) {
    	
    	int orgId = new Integer(StringUtil.null2String(role.getOrgId())).intValue();
    	
    	if(SysParamUtil.useMoreCarrierSortParam()){
			if(!UserUtil.isSuperUser()){
				if(orgId >0){
					role.setOrgId(new Long(orgId));
				}else{
					String orgAdminId = UserUtil.getCurrentPrincipalUserId();
					role.setOrgAdminId(new Long(orgAdminId));
				}

			}else{
				
				if(role.getOrgId() != null){
					if("0".equals(role.getOrgId().toString())){
						role.setOrgId(null);
						role.setOrgAdminId(null);
						role.setName("ROLE_ADMIN");
					}
				}

			}
		}

        return dao.getRoless(role);
    }

    public Role getRole(String rolename) {
        return dao.getRoleByName(rolename);
    }
    
    public Role getRoleById(String id) {
    	Role role = dao.getRoleById(new Long(id));
    	
//		List lsRes = sysResourceDao.getSysResourceByRole(new Long(id));
//		Set res = ConvertUtil.convertIdsFromListToArray(lsRes);
//		role.setRescs(res);
				
//		List lsUsers = userDao.getUserIdsByRole(new Long(id));
//		Set users = ConvertUtil.convertIdsFromListToArray(lsUsers);
//		role.setUsers(users);
		
        return role;
    }
    

    public void saveRole(Role role) {

        if (role.getId() == null) {
        	int next =  StringUtil.randoms();
        	role.setName("ROLE_"+next);
        }  	

        dao.saveRole(role);
    }
    
    
    public String saveRole2(Role role) {

        return dao.saveRole2(role).toString();
    }

    public void removeRole(String rolename) {
        dao.removeRole(rolename);
		//删除授权
        removeAuthoritiesInCache(rolename);
    }
    
    public void removeRoleID(String id,String rolename) {
    	dao.removeRoleById(new Long(id));
		//删除授权
        removeAuthoritiesInCache(rolename);
    }
    
    
    //系统管理员不能删除
    public void removeRoleById(String id) {
    	Role role = this.getRoleById(id);
    	
    	if(!"ROLE_ADMIN".equals(role.getName()) && !"ROLE_ADMIN2".equals(role.getName())){
        	dao.deleteUserByRole(new Long(id));
        	dao.deleteSysResourcesByRole(new Long(id));
        	this.removeRoleID(id,role.getName());    		
    	}

    }
    
    
    

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.RoleManager#getRolesXML(com.vriche.adrm.model.Role)
	 */
	public String getRolesXML(Role role,String IdPrefix) {
		
		String orgId = StringUtil.getNullValue(role.getOrgId(),"0");
		
//		Org org2 = new Org();
//		List ls = new ArrayList();
//		if(SysParamUtil.useMoreCarrierSortParam()){
//			if(!UserUtil.isSuperUser()){
//				String orgAdminId = UserUtil.getCurrentPrincipalUserId();
//				org2.setCreateBy(new Long(orgAdminId));
//				 ls = orgDao.getOrgsNew(org2);
//			}else{
//				 ls = orgDao.getOrgs(org2);
//			}
//			   
//		}else{
//			    ls = orgDao.getOrgs(org2);
//		}
		 Org org2 = new Org();
		 if(!"0".equals(orgId)) org2.setId(new Long(orgId));
		 List ls =  orgDao.getOrgs(org2);
		
		
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		
		for (Iterator it = ls.iterator();it.hasNext();){
			Org org = (Org)it.next();
			sb.append("<item text=\" "+ org.getName() +"(职位)\" id=\"" + "orgId" + org.getId().toString() +"\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
			
			sb.append("<userdata name=\"type\">1</userdata>");
			sb.append("<userdata name=\"orgId\">"+ org.getId().toString() +"</userdata>");
			
			getRoleItems2(sb, org.getId().toString(),IdPrefix);
			sb.append("</item>");
		}



		sb.append("</tree>");
		return new String(sb.toString());		
		
	}
	
	
	private void getRoleItems2(StringBuffer sb,String orgId,String IdPrefix){
	    Role r = new Role();
	    r.setOrgId(new Long(orgId));
		List ls = this.getRoless(r);
		for (Iterator it = ls.iterator();it.hasNext();){
			Role role = (Role) it.next();
			sb.append("<item id='"+IdPrefix
							+ role.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ role.getLable().toString() + "\">");
			sb.append("<userdata name=\"type\">2</userdata>");
			sb.append("<userdata name=\"orgId\">"+ orgId +"</userdata>");
			sb.append("<userdata name=\"id\">"+ role.getId().toString() +"</userdata>");
			sb.append("</item>");
		}
	}
	
    
	public void getRoleItems(StringBuffer sb,String IdPrefix){
	    Role r = new Role();
		List ls = this.getRoless(r);
		for (Iterator it = ls.iterator();it.hasNext();){
			Role role = (Role) it.next();
			sb.append("<item id='"+IdPrefix
							+ role.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ role.getLable().toString() + "\">");
			sb.append("<userdata name=\"id\">"+ role.getId().toString() +"</userdata>");
			sb.append("</item>");
		}
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.RoleManager#getRolesCount(com.vriche.adrm.model.Role)
	 */
	public String getRolesCount(Role role) {
		// TODO Auto-generated method stub
		return "0";
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.RoleManager#getRolesPage(com.vriche.adrm.model.Role, java.lang.String, java.lang.String)
	 */
	public PaginatedList getRolesPage(Role role, String pageIndex, String pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.RoleManager#saveRoleUserRes(com.vriche.adrm.model.Role, java.lang.String, java.lang.String)
	 */
//	public PaginatedList saveRoleUserRes(Role role, String pageIndex, String pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.RoleManager#saveRoleUserRes(com.vriche.adrm.model.Role)
	 */
	public void saveRoleUserRes(Role role) {
		
		Set rescSet =  role.getRescs();
		Set userSet =  role.getUsers();
		
		Long roleId = role.getId();
		Object resc[] = rescSet.toArray();
		Object user[] = userSet.toArray();

		int sizeResc = resc.length;
		int sizeUser = user.length;
		
//		System.out.println("sizeResc >>>>>>>>>>>>>>>>>>>>>>"+ sizeResc);
//		System.out.println("getRescsNo >>>>>>>>>>>>>>>>>>>>>>"+ role.getRescsNo().toArray().length);
        if(role.getRescsNo().toArray().length >0){
    		deleteRoleBySysResourceIds(roleId,role.getRescsNo());  
        }
        
		if(sizeResc >0) {
    		for(int i = 0; i < sizeResc; i++){
    			
       			try {
       				//授权资源给角色
       				authRescForRole(resc[i].toString(),roleId.toString(),false);
       				
        			Map rescMap = new HashMap();
        			rescMap.put("sysResId",resc[i].toString());
        			rescMap.put("roleId",roleId);
        			sysResourceDao.addRoleSysResources(rescMap);

        			
 
				} catch (Exception e) {
					// TODO: handle exception
				}

    		}  
    		
			
//			授权角色给用户
			List usersList = userDao.getUserByRole(role.getName());
			for(Iterator it = usersList.iterator();it.hasNext();){
				try {
					User u =(User) it.next();
					authRoleForUser(u.getId().toString(),roleId.toString(),false);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
        }

		
//		System.out.println("sizeUser >>>>>>>>>>>>>>>>>>>>>>"+ sizeUser);
//		System.out.println("getUsersNo >>>>>>>>>>>>>>>>>>>>>>"+ role.getUsersNo().toArray().length);
		
		if(role.getUsersNo().toArray().length > 0){
			deleteRoleByUserIds(roleId,role.getUsersNo());	
		}

//    		deleteRoleByUserIds(roleId,role.getUsers());
    	if(sizeUser >0) {
    		for(int i = 0; i < sizeUser; i++){
    			
////    			授权角色给用户
//    			List usersList = userDao.getUserByRole(role.getName());
//    			for(Iterator it = usersList.iterator();it.hasNext();){
//    				try {
//    					User u =(User) it.next();
//    					authRoleForUser(u.getId().toString(),roleId.toString(),false);
//    				} catch (Exception e) {
//    					// TODO: handle exception
//    				}
//    			}   			
    			
    			
    			
    			try {
    				//授权角色给用户
        			authRoleForUser(user[i].toString(),roleId.toString(),false);
        			
        			Map userMap = new HashMap();
        			userMap.put("userId",user[i].toString());
        			userMap.put("roleId",roleId);
        			userDao.addUserRole(userMap);

				} catch (Exception e) {
					// TODO: handle exception
				}   			
    		}  
    		
    		
    		

        }


	}
	
	private void deleteRoleBySysResourceIds(Long roleId,Set s){
		Map mp = new HashMap();
		
		Object resc[] = s.toArray();
		List ls = new ArrayList();
		for(int i = 0; i < resc.length; i++){
			ls.add(resc[i]);
			try {
				authRescForRole(resc[i].toString(),roleId.toString(),true);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

			mp.put("roleId",roleId);
			mp.put("SysResourceIdList",ls);
			sysResourceDao.deleteRoleBySysResourceIds(mp);	
			
	
//		dao.deleteSysResourcesByRole(roleId);
	}
	
	private void deleteRoleByUserIds(Long roleId,Set s){
		Map mp = new HashMap();
		Object user[] = s.toArray();
		List ls = new ArrayList();
		
		for(int i = 0; i < user.length; i++){
			ls.add(user[i]);
			try {
				authRoleForUser(user[i].toString(),roleId.toString(),true);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
			mp.put("roleId",roleId);
			mp.put("UserIdList",ls);
			userDao.deleteRoleByUserIds(mp);

			//删除授权
//			removeAuthoritiesInCache(roleId);			
			
//		dao.deleteUserByRole(roleId);
	}	
	
	public void removeUserInCache(String userId){
		String username = userDao.getUser(new Long(userId)).getUsername();
		acegiCacheManager.removeUser(username);
	}
	
	public void removeRescInCache(String resString){
		acegiCacheManager.removeResource(resString);
	}
	
	public void authRoleForUser(String userId, String roleId, boolean authorized) throws Exception {
		User user = userDao.getUser(new Long(userId));
		getRolesByUserId(user);
		AuthHelper.saveAuth(user.getRoles(), dao.getRoleById(new Long(roleId)), authorized);
//		if(authorized){
//			removeUserInCache(user.getId().toString());
//		}else{
			saveUserInCache(user);
//		}
		
	}  
	
	public void authRescForRole( String rescId,String roleId, boolean isAuthorized) throws Exception {
		Role role = dao.getRoleById(new Long(roleId));
		SysResource resc = sysResourceDao.getSysResource(new Long(rescId));
		getRolesBySysResourceId(resc);
		AuthHelper.saveAuth(resc.getRoles(), role, isAuthorized);
		saveRoleInCache(resc);
	}	
	
	
	
	private void saveUserInCache(User user){
		GrantedAuthority[] authorities = AuthenticationHelper.convertToGrantedAuthority(user.getRoles(), "name");
		acegiCacheManager.addUser(user.getUsername(), user.getPassword(), user.getEnabled().booleanValue(), true, true, true, authorities);
	}	
	
	private void saveRoleInCache(SysResource resc){
		GrantedAuthority[] authorities = AuthenticationHelper.convertToGrantedAuthority(resc.getRoles(), "name");	
		ResourceDetails rd = acegiCacheManager.getResourceFromCache(resc.getResString());
		rd.setAuthorities(authorities);
	}	


	
	
	
	private void removeAuthoritiesInCache(Long roleId){
		String authority = dao.getRoleById(roleId).getName();
		removeAuthoritiesInCache(authority);
	}
	
	private void removeAuthoritiesInCache(String authority){
		GrantedAuthorityImpl auth = new GrantedAuthorityImpl(authority);
		List rescs = acegiCacheManager.getAllResources();

		for (Iterator iter = rescs.iterator(); iter.hasNext();) {
			String str = (String) iter.next();
			ResourceDetails resc = acegiCacheManager.getResourceFromCache(str);
			GrantedAuthority[] auths = resc.getAuthorities();
			int idx = ArrayUtils.indexOf(auths, auth);
			if(idx>=0){
				auths = (GrantedAuthority[])ArrayUtils.remove(auths, idx);
				resc.setAuthorities(auths);
			}
		}
		
		List users = acegiCacheManager.getAllUsers();
		for (Iterator iter = users.iterator(); iter.hasNext();) {
			String username = (String) iter.next();
			UserDetails user = acegiCacheManager.getUser(username);
			GrantedAuthority[] auths = user.getAuthorities();
			int idx = ArrayUtils.indexOf(auths, auth);
			if(idx>=0){
				auths = (GrantedAuthority[])ArrayUtils.remove(auths, idx);
				user = new org.acegisecurity.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true,
						auths);
				acegiCacheManager.addUser(user);
			}
		}
	}
	

	
	private void getRolesBySysResourceId(SysResource resc){
		List roleList = dao.getSysResourceRoles(resc.getId().toString());
		Set roles = new HashSet();
		CollectionUtils.addAll(roles,roleList.iterator());
		resc.setRoles(roles);
	}
	
	private void getRolesByUserId(User user){
		List roleList = dao.getUserRoles(user.getId().toString());
		Set roles = new HashSet();
		CollectionUtils.addAll(roles,roleList.iterator());
		user.setRoles(roles);
	}
	
	private String[] getRescsByRoleId(Long roleId){
		List rescList = sysResourceDao.getSysResourceByRole(roleId);
		String resc[] = new String[rescList.size()];
		int j = 0;
		for(Iterator it = rescList.iterator();it.hasNext();){
			try {
				resc[j++] =(String) BeanUtils.getProperty(it.next(),"id") ;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
       return resc; 
	}
	
	
	public Map getRolesFromOtherOrg(String orgId,String orgIdNew){
		Role roleParam = new Role();
		Map retMap = new HashMap();
		roleParam.setOrgId(new Long(orgId));
		List roleList = dao.getRoless(roleParam);
		for(Iterator it = roleList.iterator();it.hasNext();){
			Role role = (Role) it.next();
			Long id = role.getId();
			String name = role.getName();
//			String lable = role.getLable();
//			String description = role.getDescription();
			
			role.setId(null);
			role.setName(name+"2");
			role.setOrgId(new Long(orgIdNew));
			Long newRoleId = dao.saveRole2(role);
			
			System.out.println("getRolesFromOtherOrg newRoleId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+newRoleId);
			System.out.println("getRolesFromOtherOrg id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);
			
			retMap.put(id,newRoleId);
//			dao.deleteSysResourcesByRole(id)
			List sysResList = sysResourceDao.getSysResourceByRoleId(id);
			
			System.out.println("getRolesFromOtherOrg sysResList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sysResList.size());
			
			Map mp = new HashMap();
			for(Iterator it2 = sysResList.iterator();it2.hasNext();){
				
				SysResource sysResource = (SysResource) it2.next();
				Long resId = sysResource.getId();
				mp.put("sysResId",resId);mp.put("roleId",newRoleId);
				System.out.println("getRolesFromOtherOrg resId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+resId);
				sysResourceDao.addRoleSysResources(mp);
				System.out.println("getRolesFromOtherOrg roleId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+newRoleId);
			}
			
		}
		return retMap;
	}


}
