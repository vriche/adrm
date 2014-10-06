
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Org;

public interface OrgDao extends Dao {

    /**
     * Retrieves all of the orgs
     */
    public List getOrgs(Org org);
    
    public List getOrgsNew(final Org org);
    /**
     * Retrieves all of the getOrgsCount
     */
    public Integer getOrgsCount(Org org);   
    /**
     * Retrieves all of the getOrgsPage
     */        
    public PaginatedList getOrgsPage(Org org,int pageIndex,int pageSize);
    /**
     * Retrieves all of the orgsByIdList
     */
    public List getOrgsByIdList(final Map idList);

    /**
     * Gets org's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the org's id
     * @return org populated org object
     */
    public Org getOrg(final Long id);

    /**
     * Saves a org's information
     * @param org the object to be saved
     */    
    public Long saveOrg(Org org);
    
    
    
    public Long saveOrgLogo(Org org); 
    

    /**
     * Removes a org from the database by id
     * @param id the org's id
     */
    public void removeOrg(final Long id);
	/**
     * Removes orgs from the database by ids
     * @param ids the org's id eg:"'1','2','3'"
     */
    public void removeOrgs(final Map idList);
    
    public List getUserOrgs(final Map mp);
    
    public List getUserOrgs_new(final Map mp);
}

