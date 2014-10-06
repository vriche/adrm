
package com.vriche.adrm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;
import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.RoleDao;
import com.vriche.adrm.dao.SysResourceDao;
import com.vriche.adrm.model.SysMenu;
import com.vriche.adrm.model.SysResource;
import com.vriche.adrm.service.SysResourceManager;
import com.vriche.adrm.service.security.acegi.AuthenticationHelper;
import com.vriche.adrm.service.security.acegi.cache.AcegiCacheManager;
import com.vriche.adrm.service.security.acegi.resource.ResourceDetails;

public class SysResourceManagerImpl extends BaseManager implements SysResourceManager {
    private SysResourceDao dao;
    private RoleDao roleDao;
    
	private AcegiCacheManager acegiCacheManager;
	
	public void setAcegiCacheManager(AcegiCacheManager acegiCacheManager) {
		this.acegiCacheManager = acegiCacheManager;
	}

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysResourceDao(SysResourceDao dao) {
        this.dao = dao;
    }
    
    public void setRoleDao(RoleDao dao) {
        this.roleDao = dao;
    }
    
    
    
    
    
    
   /**
     * @see com.vriche.adrm.service.SysResourceManager#getSysResources(com.vriche.adrm.model.SysResource)
     */
    public List getSysResources(final SysResource sysResource) {
        return dao.getSysResources(sysResource);
    }
    
    
	public List getSysResourceByRole(final String id) {
		
		 return dao.getSysResourceByRole(new Long(id));
	}
/**
     * @see com.vriche.adrm.service.SysResourceManager#getSysResourcesCount(com.vriche.adrm.model.SysResource)
     */
    public String getSysResourcesCount(final SysResource sysResource) {
        return dao.getSysResourcesCount(sysResource).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysResourceManager#getSysResourcesCount(com.vriche.adrm.model.SysResource)
     */    
	public PaginatedList getSysResourcesPage(final SysResource sysResource,String pageIndex, String pageSize) {
		return dao.getSysResourcesPage(sysResource,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysResourceManager#getSysResource(String id)
     */
    public SysResource getSysResource(final String id) {
        return dao.getSysResource(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.SysResourceManager#getSysResourcesByIdList(final Map idList)
     */
    public List getSysResourcesByIdList(final Map idList) {
        return dao.getSysResourcesByIdList(idList);
    }    

    
    
    
    
    /* (non-Javadoc)
	 * @see com.vriche.adrm.service.SysResourceManager#getSysResourceByRoleId(java.lang.String)
	 */
	public List getSysResourceByRoleId(String id) {
		return dao.getSysResourceByRoleId(new Long(id));
	}
	
	public String[] getSysResourceColByRoleId(String roleId,String propertyName) {
		List ls = dao.getSysResourceByRoleId(new Long(roleId));
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
     * @see com.vriche.adrm.service.SysResourceManager#saveSysResource(SysResource sysResource)
     */
    public String saveSysResource(SysResource sysResource) {
    	
    	boolean isNew = (sysResource.getId() == null); 
    	


    	String orginString="";
		if (!isNew) {
			SysResource orginResc = this.getSysResource(sysResource.getId().toString());
			orginString = orginResc.getResString();
		}   
		
		String newResString = sysResource.getResString();
		
		Long id  =  dao.saveSysResource(sysResource);
//	    	this.saveSysResourcesRoles(sysResource);
		if (!isNew) {
//			System.out.println(">>>>>>>>>>>>>>> ok newResString>>>"+newResString);
//			System.out.println(">>>>>>>>>>>>>>> ok orginString>>>"+orginString);
				if (!StringUtils.equals(newResString, orginString)) {
					removeRescInCache(orginString);
				}
		}
			
		sysResource.setId(id);
		saveRescInCache(sysResource);			
	

		
    	return id.toString();
    }

    /**
     * @see com.vriche.adrm.service.SysResourceManager#removeSysResource(String id)
     */
    public void removeSysResource(final String id) {
    	
    	SysResource sysResource = this.getSysResource(id);
    	
    	dao.deleteRoleBySysResource(new Long(id));
        dao.removeSysResource(new Long(id));
        
		removeRescInCache(sysResource.getResString());
	
    }

     /**
     * @see com.vriche.adrm.service.SysResourceManager#removeSysResources(String Map)
     */
    public void removeSysResources(final Map idList) {
    	dao.deleteRoleBySysResourceIds(idList);
        dao.removeSysResources(idList);
        removeRescsInCache(idList);
    }


	public void saveSysResourcesRoles(SysResource sysResource) {
		
        String  id = sysResource.getId().toString();
        dao.deleteRoleBySysResource(new Long(id));
        removeRolesInCache(sysResource.getRoles());
        
//        roleDao.re
		for  (Iterator it = sysResource.getRoles().iterator(); it.hasNext();) {
			Integer i = new Integer(it.next().toString());
			if (i.intValue() != -1) {
				Map mp = new HashMap();
				mp.put("roleId", i);
				mp.put("sysResId", id);
				dao.addRoleSysResources(mp);
			}
		}	
		
		
		SysResource resc = this.getSysResource(sysResource.toString());
		
		saveRoleInCache(resc);
		
	}
	
	private void saveRescInCache(SysResource resc){
		getRolesBySysResourceId(resc);
		GrantedAuthority[] authorities = AuthenticationHelper.convertToGrantedAuthority(resc.getRoles(), "name");
		ResourceDetails rd = new com.vriche.adrm.service.security.acegi.resource.Resource(resc.getResString(),resc.getResType(),authorities);
		acegiCacheManager.addResource(rd);
	} 
	
	public void removeRescInCache(String resString){
		acegiCacheManager.removeResource(resString);
	}
	
	public void removeRescsInCache(Map idList){
		List resIds = (List)idList.get("SysResourceIdList");
		for(Iterator it = resIds.iterator();it.hasNext();){
			SysResource resc =(SysResource)it.next();
			String resString = resc.getResString();
			acegiCacheManager.removeResource(resString);
		}
	}
	private void saveRoleInCache(SysResource resc){
		getRolesBySysResourceId(resc);
		GrantedAuthority[] authorities = AuthenticationHelper.convertToGrantedAuthority(resc.getRoles(), "name");	
		ResourceDetails rd = acegiCacheManager.getResourceFromCache(resc.getResString());
		rd.setAuthorities(authorities);
	}
	
	
	private void removeRolesInCache(Set roleIds){
		for (Iterator it = roleIds.iterator(); it.hasNext();) {
			 String roleName = roleDao.getRoleById((Long)it.next()).getName() ;
			 removeAuthoritiesInCache(roleName);
		}
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
		List roleList = roleDao.getSysResourceRoles(resc.getId().toString());
		Set roles = new HashSet();
		CollectionUtils.addAll(roles,roleList.iterator());
		resc.setRoles(roles);
	}
    
	

	
	public int saveSysPermitDefault(SysResource sysMenu) {
		
		DataSource dataSource= dao.getDefaultDataSource();
		
		String filePath = Constants.FILE_PATH_SQL_SCRIPT_PERMIT;
		
		try {
			Connection conn = dataSource.getConnection();
	
			try {
//				ScriptRunner runner = new ScriptRunner(conn, false, false);
//				runner.setErrorLogWriter(null);
//				runner.setLogWriter(null);
//				runner.runScript(Resources.getResourceAsReader(filePath));

				File file =   Resources.getResourceAsFile(filePath);
//				System.out.println(">>>>>>>>>>>>>>>"+file.getAbsolutePath());
				InputStream sqlFileIn = new FileInputStream(file);
				InputStreamReader reader= new InputStreamReader(sqlFileIn, "UTF-8");  
				ScriptRunner runner = new ScriptRunner(conn, false, false);
				runner.setLogWriter(null);
				runner.setErrorLogWriter(null);
				runner.runScript(reader);
				conn.commit();
				reader.close();  
//				System.out.println(">>>>>>>>>>>>>>> ok");
			} finally {
				conn.close();
			}  
		}catch (Exception e) {  
			       throw new RuntimeException("Description.  Cause: " + e, e);  

		}  
		return 1;
	}

	
}
