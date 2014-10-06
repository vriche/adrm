
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.dao.OrgDao;

public interface OrgManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOrgDao(OrgDao orgDAO);

    /**
     * Retrieves all of the orgs
     */
    public List getOrgs(Org org);
     /**
     * Retrieves all of the orgsCount
     */
    public String getOrgsCount(Org org);
     /**
     * Retrieves all of the orgsCount
     */    
    public List getOrgsPage(Org org,String pageIndex,String pageSize);
     /**
     * Retrieves all of the orgsByIdList
     */
    public List getOrgsByIdList(final Map idList);

    /**
     * Gets org's information based on id.
     * @param id the org's id
     * @return org populated org object
     */
    public Org getOrg(final String id);

    /**
     * Saves a org's information
     * @param org the object to be saved
     */
    public String saveOrg(Org org);
    
    /**
     * Saves a org's information
     * @param org the object to be saved
     */
    public String saveOrgLogo(Org org);
    


    /**
     * Removes a org from the database by id
     * @param id the org's id
     */
    public void removeOrg(final String id);
     /**
     * Removes a org from the database by id
     * @param idList
     */
    public void removeOrgs(final Map idList);
    
	public String getOrgsXml(String orgId,String OrgIdPrefix,String BranchIdPrefix,String UserIdPrefix);
	
	public String getOrgsXml2(Org og,String OrgIdPrefix,String BranchIdPrefix,String UserIdPrefix,String loginUser);
	
	
	public Map getOrgSelect(Org org);
}

