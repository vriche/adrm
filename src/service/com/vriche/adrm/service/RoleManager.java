/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * <p><a href="RoleManager.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.RoleDao;
import com.vriche.adrm.model.Role;

public interface RoleManager {

    public void setRoleDao(RoleDao dao);

    public List getRoles(Role role);
    
    public List getRoless(Role role);

    public Role getRole(String rolename);

    public void saveRole(Role role);

    public void removeRole(String rolename);
    
    public void removeRoleById(String id);
    
    public String getRolesXML(Role role,String IdPrefix);
    
    public void getRoleItems(StringBuffer sb,String IdPrefix);
    
    public String getRolesCount(Role role);
    
//    public PaginatedList saveRoleUserRes(Role role,String pageIndex,String pageSize);

    public void saveRoleUserRes(Role role);
    
    public Map getRolesFromOtherOrg(String orgId,String orgIdNew);
	
}
