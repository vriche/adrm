/****************************************************************************     
 * Created on 2007-4-28                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.service.security.acegi;


import org.acegisecurity.providers.dao.UserCache;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
/**
 * 登陆时从缓存里获取用户，而不是像@link org.acegisecurity.acl.basic.jdbc.JdbcDaoImpl 那样从数据库中获取用户实例
 * 实现loadUserByUsername(String username) 方法
 * @author cac
 *
 */
public class InCacheDaoImpl  implements UserDetailsService{
	
protected final Log logger = LogFactory.getLog(getClass());

private UserCache userCache;
	
	public UserCache getUserCache() {
		return userCache;
	}
	
	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserDetails ud = getUserCache().getUserFromCache(username);
		return ud;
	}
}
