package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.Role;

/**
 * Role Data Access Object (DAO) interface.
 *
 * <p><a href="RoleDao.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RoleDao extends Dao {
    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return role populated role object
     */
    public Role getRoleByName(String rolename);
    
    public Role getRoleByNameOrgId(String orgId,String name);
    
    public Role getRoleById(Long id);

    /**
     * Gets a list of roles based on parameters passed in.
     *
     * @return List populated list of roles
     */
    public List getRoles(Role role);
    
    public List getRoless(Role role);
    
    public List getSysResourceRoles(String sysResourceId);
    
    public List getUserRoles(String userId);
    public List getUserRolesByOrg(Map mp);

    /**
     * Saves a role's information
     * @param role the object to be saved
     */
    public void saveRole(Role role);
    
    public Long saveRole2(Role role);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    public void removeRole(String rolename);
    public void removeRoleById(Long id);
    

    
    public void deleteSysResourcesByRole(Long id);
    
    public void deleteUserByRole(Long id);
    
    
}
