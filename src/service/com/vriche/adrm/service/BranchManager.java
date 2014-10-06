
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.BranchDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.model.User;
//import com.vriche.adrm.model.User;

public interface BranchManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setBranchDao(BranchDao branchDAO);

    /**
     * Retrieves all of the branchs
     */
    public List getBranchs(Branch branch);
    


     /**
     * Retrieves all of the branchsCount
     */
    public String getBranchsCount(Branch branch);
     /**
     * Retrieves all of the branchsCount
     */    
    public PaginatedList getBranchsPage(Branch branch,String pageIndex,String pageSize);
     /**
     * Retrieves all of the branchsByIdList
     */
    public List getBranchsByIdList(final Map idList);

    /**
     * Gets branch's information based on id.
     * @param id the branch's id
     * @return branch populated branch object
     */
    public Branch getBranch(final String id);
    
    
    public Branch getBranchByName(final String name);

    /**
     * Saves a branch's information
     * @param branch the object to be saved
     */
    public String saveBranch(Branch branch);
    
    public void saveBranchUser(String orgId,String userId,String branchId);

    
    public void removeBranchUser(String userId,String branchId);
    /**
     * Removes a branch from the database by id
     * @param id the branch's id
     */
    public void removeBranch(final String id);
     /**
     * Removes a branch from the database by id
     * @param idList
     */
    public void removeBranchs(final Map idList);
    
    
    public String getBranchsXML(Branch branch,String IdPrefix);
    
//    public void getBranchsItems(String parentId,StringBuffer sb,String IdPrefix);
    
//    public void getBranchsItemsByOrg(StringBuffer sb,String orgId,String BranchIdPrefix,String UserIdPrefix);
    
    public void getBranchsItemsByParentId(StringBuffer sb,Org org,String branchIdPrefix,String userIdPrefix);
    public void getBranchsItemsByParentId2(StringBuffer sb,String parentId,String branchIdPrefix,String userIdPrefix,String loginUser);

    public Map getBranchSelect(Branch branch);
    
    public void getBranchsItemsByParentId3(StringBuffer sb,Org org,String parentId,String branchIdPrefix,String userIdPrefix);
    
    public List getTreeForJosin(TreeNode node,User user);
    
}

