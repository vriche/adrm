
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.User;

public interface BranchDao extends Dao {

    /**
     * Retrieves all of the branchs
     */
    public List getBranchs(Branch branch);
    /**
     * Retrieves all of the getBranchsCount
     */
    public Integer getBranchsCount(Branch branch);   
    /**
     * Retrieves all of the getBranchsPage
     */        
    public PaginatedList getBranchsPage(Branch branch,int pageIndex,int pageSize);
    /**
     * Retrieves all of the branchsByIdList
     */
    public List getBranchsByIdList(final Map idList);
    
    public void saveUserOrg(final Map mp); 

    /**
     * Gets branch's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the branch's id
     * @return branch populated branch object
     */
    public Branch getBranch(final Long id);
    
    public Branch getUserBranchsByUserId(final Long userId);
    
 
    public Branch getBranchByName(final String name);

    /**
     * Saves a branch's information
     * @param branch the object to be saved
     */    
    public Long saveBranch(Branch branch);

    public void saveBranchUser(Map mp);
    /**
     * Removes a branch from the database by id
     * @param id the branch's id
     */
    public void removeBranch(final List idList);
    
    public void removeBranchUserByBanchId(List idList);

    public void removeBranchUserByUserId(Long id);
    

//    public void removeBranchUserByBanchId(Long id);
//
//    public void removeBranch(final Long id);
	/**
     * Removes branchs from the database by ids
     * @param ids the branch's id eg:"'1','2','3'"
     */
    public void removeBranchs(final Map idList);
    public List getBranchIdList(Long id);
    public Integer getBranchIdForOrgUser(Map mp);
    public void removeBranchUserByBanchId(Map mp) ;
    
    public List getBranchsByUser(User user);
    public List getBranchsByParentUser(User user);
    
}

