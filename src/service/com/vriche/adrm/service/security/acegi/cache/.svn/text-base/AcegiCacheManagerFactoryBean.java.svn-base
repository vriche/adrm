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

import java.util.Iterator;
import java.util.List;

import org.acegisecurity.providers.dao.UserCache;
import org.acegisecurity.userdetails.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.vriche.adrm.service.security.acegi.service.AuthenticationService;
import com.vriche.adrm.service.security.acegi.resource.Resource;

/**
 * AcegiCacheManagerFactoryBean 负责初始化缓存后生成AcegiCacheManager
 * 调用 authenticationService 来获取资源和用户实例，并加入UserCache 和 ResourceCache 中
 * @author cac
 *
 */
public class AcegiCacheManagerFactoryBean implements FactoryBean,InitializingBean {
	
protected final Log logger = LogFactory.getLog(getClass());
	
	private AcegiCacheManager acegiCacheManager;
	
	private AuthenticationService authenticationService;
	
	//-------resource caches---------------------
	private UserCache userCache;
	
	private ResourceCache resourceCache;
	
	public Object getObject() throws Exception {
		return this.acegiCacheManager;
	}

	public Class getObjectType() {
		return (this.acegiCacheManager != null ? this.acegiCacheManager.getClass() : AcegiCacheManager.class);
	}

	public boolean isSingleton() {
		return true;
	}

	public void afterPropertiesSet() throws Exception {
		logger.info("Initializing AcegiCacheManager");
		Assert.notNull(userCache,"userCache should not be null");
		Assert.notNull(resourceCache,"resourceCache should not be null");
		Assert.notNull(authenticationService,"Authentication Service should not be null");
 
		//初始化缓存
		List users =authenticationService.getUsers();
		
		
		for (Iterator iter = users.iterator(); iter.hasNext();) {
			User user = (User) iter.next();
			userCache.putUserInCache(user);
		}
		
		List  rescs =authenticationService.getResources();
		for (Iterator iter = rescs.iterator(); iter.hasNext();) {
			Resource resc = (Resource) iter.next();
			resourceCache.putResourceInCache(resc);
		}
		//生成 acegiCacheManager
		this.acegiCacheManager = new AcegiCacheManager(userCache,resourceCache);
	}

	//-------------setters-----------
	
	public void setAcegiCacheManager(AcegiCacheManager acegiCacheManager) {
		this.acegiCacheManager = acegiCacheManager;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	public void setResourceCache(ResourceCache resourceCache) {
		this.resourceCache = resourceCache;
	}
	
}
