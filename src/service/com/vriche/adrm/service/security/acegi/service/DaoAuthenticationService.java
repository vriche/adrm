/****************************************************************************     
 * Created on 2007-4-28                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.service.security.acegi.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.vriche.adrm.service.security.acegi.AuthenticationHelper;
import com.vriche.adrm.service.security.acegi.resource.Resource;
/**
 * 通过数据库方式获取User 和 Resource 实例
 * @author cac
 *
 */
public class DaoAuthenticationService extends JdbcDaoSupport implements AuthenticationService{

//	获取用户名，密码，状态(name,passwd,status)
	private String loadUsersQuery;
	
	//获取相应用户名下的所有权限(role.name)
	private String authoritiesByUsernameQuery;
	
	//获取所有资源的资源串和资源类型(res_string, res_type)
	private String loadResourcesQuery;
	
	//获取相应资源下的所有权限(role.name)
	private String authoritiesByResourceQuery;
	
	private String rolePrefix = "";


	/* 
	 * 获取所有资源实例
	 * (non-Javadoc)
	 * @see org.springside.components.acegi.service.AuthenticationService#getResources()
	 */
	public List getResources() {
		List resources = new LoadResourcesMapping(getDataSource()).execute();
		List authResources = new ArrayList();
		for (Iterator iter = resources.iterator(); iter.hasNext();) {
			Resource resc = (Resource) iter.next();
			List ls = new AuthoritiesByResourcMapping(getDataSource()).execute(resc.getResString());
			List auths = new ArrayList();
			for (Iterator it = ls.iterator(); it.hasNext();){
				auths.add((GrantedAuthorityImpl)it.next());
			}
			GrantedAuthority[] arrayAuths = AuthenticationHelper.convertToGrantedAuthority(auths);
			authResources.add(new Resource(resc.getResString(), resc.getResType(), arrayAuths));
		}
		return authResources;
	}

	/* 
	 * 获取所有用户实例
	 * (non-Javadoc)
	 * @see org.springside.components.acegi.service.AuthenticationService#getUsers()
	 */
	public List getUsers() {
		List users = new LoadUsersMapping(getDataSource()).execute();
		List authUsers = new ArrayList();
		for (Iterator iter = users.iterator(); iter.hasNext();) {
			UserDetails user = (UserDetails) iter.next();
			List ls = new AuthoritiesByUsernameMapping(getDataSource()).execute(user.getUsername());
			
			List auths = new ArrayList();
			for (Iterator it = ls.iterator(); it.hasNext();){
				auths.add((GrantedAuthorityImpl)it.next());
			}		
			GrantedAuthority[] arrayAuths = AuthenticationHelper.convertToGrantedAuthority(auths);
			authUsers.add(new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, arrayAuths));
		}
		return authUsers;
	}
	
	/**
     * Query to look up users.
     */
    protected class LoadUsersMapping extends MappingSqlQuery {
        protected LoadUsersMapping(DataSource ds) {
            super(ds, loadUsersQuery);
            compile();
        }

        protected Object mapRow(ResultSet rs, int rownum)
            throws SQLException {
            String username = rs.getString(1);
            String password = rs.getString(2);
            boolean enabled = rs.getBoolean(3);
            boolean accountExpired = true;
            boolean accountLocked = true;
            boolean credentialsExpired = true;
            
            UserDetails user = new User(username, password, enabled, accountExpired, accountLocked, credentialsExpired,
                    new GrantedAuthority[] {new GrantedAuthorityImpl("HOLDER")});

            return user;
        }
    }
    
    /**
     * Query object to look up a user's authorities.
     */
    protected class AuthoritiesByUsernameMapping extends MappingSqlQuery {
        protected AuthoritiesByUsernameMapping(DataSource ds) {
            super(ds, authoritiesByUsernameQuery);
            declareParameter(new SqlParameter(Types.VARCHAR));
            compile();
        }

        protected Object mapRow(ResultSet rs, int rownum)
            throws SQLException {
            String roleName = rolePrefix + rs.getString(1);
            GrantedAuthorityImpl authority = new GrantedAuthorityImpl(roleName);
            return authority;
        }
    }
	
    /**
     * Query to look up resources.
     */
    protected class LoadResourcesMapping extends MappingSqlQuery {
        protected LoadResourcesMapping(DataSource ds) {
            super(ds, loadResourcesQuery);
            compile();
        }

        protected Object mapRow(ResultSet rs, int rownum)
            throws SQLException {
            String resString = rs.getString(1);
            String resType = rs.getString(2);
            Resource resource = new Resource(resString, resType, new GrantedAuthority[] {new GrantedAuthorityImpl("HOLDER")});
            return resource;
        }
    }
    
    /**
     * Query object to look up a resource's authorities.
     */
    protected class AuthoritiesByResourcMapping extends MappingSqlQuery {
        protected AuthoritiesByResourcMapping(DataSource ds) {
            super(ds, authoritiesByResourceQuery);
            declareParameter(new SqlParameter(Types.VARCHAR));
            compile();
        }

        protected Object mapRow(ResultSet rs, int rownum)
            throws SQLException {
            String roleName = rolePrefix + rs.getString(1);
            GrantedAuthorityImpl authority = new GrantedAuthorityImpl(roleName);
            return authority;
        }
    }

	public void setLoadUsersQuery(String loadUsersQuery) {
		this.loadUsersQuery = loadUsersQuery;
	}

	public void setAuthoritiesByUsernameQuery(String authoritiesByUsernameQuery) {
		this.authoritiesByUsernameQuery = authoritiesByUsernameQuery;
	}
	
	public void setAuthoritiesByResourceQuery(String authoritiesByResourceQuery) {
		this.authoritiesByResourceQuery = authoritiesByResourceQuery;
	}

	public void setLoadResourcesQuery(String loadResourcesQuery) {
		this.loadResourcesQuery = loadResourcesQuery;
	}

	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}

}
