/****************************************************************************     
 * Created on 2007-4-28                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.service.security.acegi.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.providers.dao.UserCache;
import org.acegisecurity.providers.dao.cache.EhCacheBasedUserCache;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vriche.adrm.service.security.acegi.resource.Resource;
import com.vriche.adrm.service.security.acegi.resource.ResourceDetails;

/**
 * AcegiCacheManager是对缓存进行统一管理，以屏蔽其它类对缓存的直接操作
 * 对缓存中的用户和资源进行初始化、增、删、改、清空等操作
 * @author cac
 *
 */
public class AcegiCacheManager {

	private final Log logger = LogFactory.getLog(getClass());
	
	private UserCache userCache;
	
	private ResourceCache resourceCache;
	
	//rescTypeMapp 映射资源类型对应的资源的一对多关系，以便快速查找。
	//如method类型对应哪些资源实例，url资源类型对应哪些资源实例
	private Map rescTypeMapping;

	//-----constructor using fields
	public AcegiCacheManager(UserCache userCache, ResourceCache resourceCache) {
		this.userCache = userCache;
		this.resourceCache = resourceCache;
		
		// 获取所有的资源,以初始化 rescTypeMapping
		rescTypeMapping = new HashMap();
		
		List resclist = resourceCache.getAllResources();

		List typelist = new ArrayList();

		for (Iterator iter = resclist.iterator(); iter.hasNext();) {
			String resString = (String) iter.next();
			ResourceDetails resc = resourceCache.getResourceFromCache(resString);
			Object obj = rescTypeMapping.get(resc.getResType());
			if(obj != null){
                  typelist = (List)obj;
			}else{
				  typelist = new ArrayList();
				  rescTypeMapping.put(resc.getResType(), typelist);
			}
			typelist.add(resString);
		}

	}

	
	//-----get from cache methods
	public UserDetails getUser(String username) {
		return userCache.getUserFromCache(username);
	}
	
	public ResourceDetails getResourceFromCache(String resString) {
		return resourceCache.getResourceFromCache(resString);
	}
	
	//-----remove from cache methods
	public void removeUser(String username){
		userCache.removeUserFromCache(username);
	}
	
	public void removeResource(String resString){
//		List typelist = new ArrayList();
		ResourceDetails rd = resourceCache.getResourceFromCache(resString);
		Object obj = rescTypeMapping.get(rd.getResType());
		if(obj != null){
			List typelist = (List)obj;
    		typelist.remove(resString);
    		obj = (Object)typelist;
    		resourceCache.removeResourceFromCache(resString);
		}		

	}
	
	//------add to cache methods
	public void addUser(String username, String password, boolean enabled, boolean accountNonExpired,
		    boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities){
		User user = new User(username, password, enabled, accountNonExpired,
			    credentialsNonExpired, accountNonLocked, authorities);
		addUser(user);
	}
	
	public void addUser(UserDetails user){
		userCache.putUserInCache(user);
	}
	
	public void addResource(String resString, String resType, GrantedAuthority[] authorities){
		Resource rd = new Resource(resString, resType, authorities);
		addResource(rd);
	}
	
	public void addResource(ResourceDetails rd){
		List typelist = new ArrayList();
		Object obj = rescTypeMapping.get(rd.getResType());
		if(obj != null){
            typelist = (List)obj;
		}else{
			  typelist = new ArrayList();
			  rescTypeMapping.put(rd.getResType(), typelist);
		}		

		typelist.add(rd.getResString());
		resourceCache.putResourceInCache(rd);
	}
	
	//	------renovate cache methods
	public void renovateUser(String orgUsername, String username, String password, boolean enabled, boolean accountNonExpired,
	        boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities){
		removeUser(orgUsername);
		addUser(username, password, enabled, accountNonExpired,
			    credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public void renovateUser(String orgUsername, UserDetails user){
		removeUser(orgUsername);
		addUser(user);
	}
	
	public void renovateResource(String orgResString,String resString, String resType, GrantedAuthority[] authorities ){
		removeResource(orgResString);
		addResource(resString, resType, authorities);
	}
	
	public void renovateResource(String orgResString,ResourceDetails rd){
		removeResource(orgResString);
		addResource(rd);
	}
	
	//-------getters and setters-------------------
	public void clearResources() {
		rescTypeMapping = new HashMap();
		resourceCache.removeAllResources();
	}

	public void setResourceCache(ResourceCache resourceCache) {
		this.resourceCache = resourceCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}
	

	/**
	 * 根据资源类型,在rescTypeMapping职工获取所有该类型资源的对应的resource string
	 * @param resType
	 * @return List
	 */
	public List getResourcesByType(String resType) {	
		List ls =  new ArrayList();
		Object oo = rescTypeMapping.get(resType);
		if( oo != null) ls = (List)oo;
		return ls;
	}
	
	/**
	 * 获取所有资源的对应的resource string
	 * @return
	 */
	public List getAllResources(){
		return resourceCache.getAllResources();
	}
	
	/**
	 * 获取所有用户实例对应的user name
	 * @return
	 */
	public List getAllUsers(){
//		List userList = new ArrayList();
//		EhCacheBasedUserCache ehUserCache = (EhCacheBasedUserCache)userCache;
//		List ls = ehUserCache.getCache().getKeys();
//		for(Iterator it = ls.iterator();it.hasNext();){
//			userList.add((String)it.next());
//		}
//		
//		return userList;
		

		EhCacheBasedUserCache ehUserCache = (EhCacheBasedUserCache)userCache;

		return ehUserCache.getCache().getKeys();
	}
	
}
