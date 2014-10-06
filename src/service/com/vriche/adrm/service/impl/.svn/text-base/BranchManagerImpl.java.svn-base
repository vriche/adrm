
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.BranchDao;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.BranchManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class BranchManagerImpl extends BaseManager implements BranchManager {
    private BranchDao dao;
    private UserManager userManager;
    private OrgDao orgDao;
    

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setBranchDao(BranchDao dao) {
        this.dao = dao;
    }
    
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}
   /**
     * @see com.vriche.adrm.service.BranchManager#getBranchs(com.vriche.adrm.model.Branch)
     */
    public List getBranchs(final Branch branch) {
        return dao.getBranchs(branch);
    }
   /**
     * @see com.vriche.adrm.service.BranchManager#getBranchsCount(com.vriche.adrm.model.Branch)
     */
    public String getBranchsCount(final Branch branch) {
        return dao.getBranchsCount(branch).toString();
    }    

   /**
     * @see com.vriche.adrm.service.BranchManager#getBranchsCount(com.vriche.adrm.model.Branch)
     */    
	public PaginatedList getBranchsPage(final Branch branch,String pageIndex, String pageSize) {
		return dao.getBranchsPage(branch,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.BranchManager#getBranch(String id)
     */
    public Branch getBranch(final String id) {
        return dao.getBranch(new Long(id));
    }
    
    
    public Branch getBranchByName(final String name) {
        return dao.getBranchByName(name);
    }
    
    
    

    
    /**
     * @see com.vriche.adrm.service.BranchManager#getBranchsByIdList(final Map idList)
     */
    public List getBranchsByIdList(final Map idList) {
        return dao.getBranchsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.BranchManager#saveBranch(Branch branch)
     */
    public String saveBranch(Branch branch) {
    	String orgId = branch.getOrgId().toString();
    	Long id = dao.saveBranch(branch);
//    	User userP = new User();
//    	userP.setBranchId(id);
//    	userP.setOrgId(branch.getOrgId());
////    	List userIds =  userManager.getUsers(userP);
//    	userManager.saveUserRelOrg(userP);
    	
    	
    	

        return id.toString();
        
    }
    
    
    public void saveUserOrg(String orgIdOld,String orgId,String branchId){
  
    	boolean isNew = branchId == null || "0".equals(branchId);
    		
    	if(!isNew){
        	Map branchMp = new HashMap();
    		branchMp.put("orgIdOld", orgIdOld);
    		branchMp.put("orgId", orgId);
    		branchMp.put("branchId", branchId);
    		dao.saveUserOrg(branchMp);   		
    	}

    }
    
    
    
  public void saveBranchUser(String orgId,String userId,String branchId) throws DataIntegrityViolationException{
	  
	  System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>"+orgId);
	  
	  System.out.println("userId>>>>>>>>>>>>>>>>>>>>>"+userId);
	  
	  System.out.println("branchId>>>>>>>>>>>>>>>>>>>>>"+branchId);
	  
	  //一个用户在一个组织里只能归属一个部门 
//	  Map mp = new HashMap();
//	  mp.put("orgId", orgId);
//	  mp.put("userId", userId);
//	  Integer bId = dao.getBranchIdForOrgUser(mp);
//		System.out.println("bId>>>>>>>>>>>>>>>>>>>>>"+bId);
//	  if(bId != )
//	  dao.removeBranchUserByUserId(new Long(userId));
//	  List ls = new ArrayList();
	  
//	  mp.put("branchId",bId);
//
//	  if(bId != null) dao.removeBranchUserByBanchId(mp);
	  
	  
	  Map branchMp = new HashMap();
	  branchMp.put("userId", userId);
	  branchMp.put("branchId", branchId);
	  try {
		  dao.saveBranchUser(branchMp);
      } catch (DataIntegrityViolationException e) {
    	  System.out.println("saveBranchUser error>>>>>>>>>>>>>>>>>>>>>"+branchId);
      }
  }       
    
    
    
    

    /**
     * @see com.vriche.adrm.service.BranchManager#removeBranch(String id)
     */
    public void removeBranch(final String id) {
//    	Map branchMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_BRANCHMAP_BYID);
//    	System.out.println("id>1111111111111111111>>>>>>>>>>>>>>>>>>>>"+id.toString());
//    	List branchIdList = (List)branchMap.get(new Long(id));
    	
    	List branchIdList  = new ArrayList();
    	branchIdList.add(new Long(id));
    	getBranchByParnetId(new Long(id),branchIdList);
    	System.out.println("branchIdList>322222222222223333111>>3333>>>>>>>>>>11111>>>>>>>>"+ branchIdList.size());
//		for(Iterator it = branchIdList.iterator();it.hasNext();){
//			System.out.println("branchIdList>333333333333333111>>>>>>>>>>>>>>>>>>>>"+((Long)it.next()).toString());
//		}
//      	dao.removeBranchUserByBanchId(branchIdList);
        dao.removeBranch(branchIdList);
        System.out.println("branchIdList>322222222222223333111 22222>>>>>>>>>>222222>>>>>>>>>>"+ branchIdList.size());
//     	dao.removeBranchUserByBanchId(new Long(id));
//        dao.removeBranch(new Long(id));
    }
    
    

		

private void getBranchByParnetId(Long branchId,List BranchParentList){
	Branch branch = new Branch();
	branch.setParentId(branchId.toString());
		List ls = dao.getBranchs(branch);
//		System.out.println("ls>11111111111111111111111>>>>>>>>>>>>>>>>>>>>"+ ls.size());
		Iterator it = ls.iterator();
		while(it.hasNext()){
			Branch BranchRes = (Branch)it.next();
			BranchParentList.add(BranchRes.getId());
			getBranchByParnetId(BranchRes.getId(),BranchParentList);
		}
//		System.out.println("BranchParentList>22222222222222222222>>>>>>>>>>>>>>>>>>>>"+ BranchParentList.size());
}

     /**
     * @see com.vriche.adrm.service.BranchManager#removeBranchs(String Map)
     */
    public void removeBranchs(final Map idList) {
 
        dao.removeBranchs(idList);
    }

	private int getOrgsByParentIdItem(StringBuffer sb,Org og,String parent,String IdPrefix){

		Org org2 = new Org();
		org2.setParentId(og.getId().toString());
		List ls = orgDao.getOrgs(org2);

		for(Iterator it = ls.iterator();it.hasNext();){
			Org org = (Org)it.next();
			sb.append("<item text=\""+ org.getName() + "\" im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\"  id=\"" + "orgId"+ org.getId().toString() + "\">");
			sb.append("<userdata name=\"type\">1</userdata>");
//			sb.append("<userdata name=\"id\">"+  org.getId().toString() +"</userdata>");
			sb.append("<userdata name=\"orgid\">"+ org.getId().toString() +"</userdata>");
			getOrgsByParentIdItem(sb, org,"0",IdPrefix);
			getBranchsItems(org.getId().toString(),"0",sb,IdPrefix);
			sb.append("</item>");		
			
		}
		return ls.size();
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.BranchManager#getBranchsXML(com.vriche.adrm.model.User, java.lang.String)
	 */
	public String getBranchsXML(Branch branch, String IdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		
//		int orgId = new Integer(StringUtil.null2String(branch.getOrgId())).intValue();
		
		
		String orgId = StringUtil.getNullValue(branch.getOrgId(),"0");
		
		System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>);"+orgId);
		
//		Org org2 = new Org();
//		List ls = new ArrayList();
//		if(SysParamUtil.useMoreCarrierSortParam()){
//			if(!UserUtil.isSuperUser()){
//				if(orgId > 0){
//					 org2.setId(new Long(orgId));
//					 ls = orgDao.getOrgs(org2);
//				}else{
//					String orgAdminId = UserUtil.getCurrentPrincipalUserId();
//					org2.setCreateBy(new Long(orgAdminId));
//					ls = orgDao.getOrgsNew(org2);
//				}
//
//				
//			}else{
//				 ls = orgDao.getOrgs(org2);
//			}
//			   
//		}else{
//			    ls = orgDao.getOrgs(org2);
//		}
		
		 Org org2 = new Org();
		 if(!"0".equals(orgId)) org2.setId(new Long(orgId));
		 List ls =  orgDao.getOrgs(org2);
		
//		System.out.println("BranchParentList>22);"+ls.size());
		
		for (Iterator it = ls.iterator();it.hasNext();){
			 	Org org = (Org)it.next();
				sb.append("<item text=\""+ org.getName() + "\" id=\"" + "orgId"+ org.getId().toString() + "\" open=\"1\" im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" call=\"1\" select=\"1\">");
				sb.append("<userdata name=\"type\">1</userdata>");
				sb.append("<userdata name=\"orgid\">"+ org.getId().toString() +"</userdata>");
				getOrgsByParentIdItem(sb, org,"0",IdPrefix);
				getBranchsItems(org.getId().toString(),"0",sb,IdPrefix);
	
				sb.append("</item>");
		}
		sb.append("</tree>");
		return new String(sb.toString());
	}  
	
	private void getBranchsItems(String orgId,String parentId,StringBuffer sb, String IdPrefix) {
		   Branch b = new Branch();
		   b.setOrgId(new Long(orgId));
		   b.setParentId(parentId);
		   List ls = dao.getBranchs(b);
			
//		   System.out.println("size BranchParentList>22);"+ls.size());
		   
			for (Iterator it = ls.iterator();it.hasNext();){
				Branch branch = (Branch) it.next();
				
//				System.out.println("BranchParentList>22);"+branch.getName());
				
				sb.append("<item id='" +IdPrefix
								+ branch.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ branch.getName().toString() + "\">");
				
				sb.append("<userdata name=\"type\">2</userdata>");
				sb.append("<userdata name=\"id\">"+ branch.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"orgid\">"+ orgId +"</userdata>");
				Long pId = branch.getId();
				getBranchsItems2( orgId,pId.toString(),sb,IdPrefix);
				sb.append("</item>");
			}
	
	}
	
	private void getBranchsItems2(String orgId,String parentId,StringBuffer sb, String IdPrefix) {
		   Branch b = new Branch();
		   b.setParentId(parentId);
		   List ls = this.getBranchs(b);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				Branch branch = (Branch) it.next();
				sb.append("<item id='" +IdPrefix
								+ branch.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ branch.getName().toString() + "\">");
				sb.append("<userdata name=\"type\">2</userdata>");
				sb.append("<userdata name=\"id\">"+ branch.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"orgid\">"+ orgId +"</userdata>");
				Long pId = branch.getId();
				getBranchsItems(orgId,pId.toString(),sb,IdPrefix);
				sb.append("</item>");
			}
	
	}
	
//	public void getBranchsItemsByOrg(StringBuffer sb,String orgId,String branchIdPrefix,String userIdPrefix){
//		   Branch b = new Branch();
//		   b.setOrgId(new Long(orgId));
//		   List ls = this.getBranchs(b);
//			
//			for (Iterator it = ls.iterator();it.hasNext();){
//				Branch branch = (Branch) it.next();
//				sb.append("<item id='" +branchIdPrefix
//								+ branch.getId().toString()
//								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
//								+ branch.getName().toString() + "\">");
//				sb.append("<userdata name=\"id\">"+ branch.getId().toString() +"</userdata>");
//				sb.append("<userdata name=\"type\">2</userdata>");
//				//根据部门找用户
//				userManager.getUsersItemsByBranch(sb,branch.getId().toString(),userIdPrefix);
//
//				String pId = branch.getId().toString();
//				getBranchsItemsByParentId(sb,pId,branchIdPrefix,userIdPrefix);
//				sb.append("</item>");
//			}
//	}
	
	
	
	public void getBranchsItemsByParentId(StringBuffer sb,Org og,String branchIdPrefix,String userIdPrefix){
		   Branch b = new Branch();
		   String orgId = og.getId().toString();
		   b.setOrgId(new Long(orgId));
		   b.setParentId("0");
		   List ls = this.getBranchs(b);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				Branch branch = (Branch) it.next();

				sb.append("<item id='" +branchIdPrefix
								+ branch.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ branch.getName().toString() + "\">");
				sb.append("<userdata name=\"type\">2</userdata>");
				sb.append("<userdata name=\"branchId\">"+ branch.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"orgid\">"+orgId +"</userdata>");
//				sb.append("<userdata name=\"IdPrefix\">" + branchIdPrefix +"</userdata>");
				//根据部门找用户
				userManager.getUsersItemsByBranch(sb,branch.getId().toString(),orgId+"_"+userIdPrefix);				
				String pId = branch.getId().toString();
				getBranchsItemsByParentId3(sb,og,pId,branchIdPrefix,orgId+"_"+userIdPrefix);
				sb.append("</item>");
			}
			
			//获得未分配部门的用户
//			getNoBranchUsers(sb,branchIdPrefix,userIdPrefix);
	}
	
	public void getBranchsItemsByParentId3(StringBuffer sb,Org og,String parentId,String branchIdPrefix,String userIdPrefix){
		   Branch b = new Branch();
		   String orgId = og.getId().toString();
		   String parentOrgId = og.getParentId();
		   b.setOrgId(new Long(orgId));
		   b.setParentId(parentId);
		   List ls = this.getBranchs(b);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				Branch branch = (Branch) it.next();

				sb.append("<item id='" +branchIdPrefix
								+ branch.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ branch.getName().toString() + "\">");
				sb.append("<userdata name=\"type\">2</userdata>");
				sb.append("<userdata name=\"branchId\">"+ branch.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"orgid\">"+orgId +"</userdata>");
				sb.append("<userdata name=\"parentOrgId\">"+parentOrgId +"</userdata>");
				
//				sb.append("<userdata name=\"IdPrefix\">" + branchIdPrefix +"</userdata>");
				//根据部门找用户
				userManager.getUsersItemsByBranchNew(sb,orgId,branch.getId().toString(),userIdPrefix);				
//				String pId = branch.getId().toString();
				getBranchsItemsByParentId3(sb,og,branch.getId().toString(),branchIdPrefix,userIdPrefix);
				sb.append("</item>");
			}
			
			//获得未分配部门的用户
//			getNoBranchUsers(sb,branchIdPrefix,userIdPrefix);
	}
	
	public void getBranchsItemsByParentId2(StringBuffer sb,String parentId,String branchIdPrefix,String userIdPrefix,String loginUser){
		   Branch b = new Branch();
		   b.setParentId(parentId);
		   List ls = this.getBranchs(b);
			
			for (Iterator it = ls.iterator();it.hasNext();){
				Branch branch = (Branch) it.next();
				
//				User uu = new User();
//				uu.setBranchId(branch.getId());
//				List lss = userManager.getUserAutoComplet(uu);
				
				sb.append("<item id='" +branchIdPrefix
								+ branch.getId().toString()
								+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
								+ branch.getName().toString() + "\">");
				sb.append("<userdata name=\"type\">2</userdata>");
//				sb.append("<userdata name=\"id\">"+ branch.getId().toString() +"</userdata>");
//				sb.append("<userdata name=\"IdPrefix\">" + branchIdPrefix +"</userdata>");
				//根据部门找用户
				userManager.getUsersItemsByBranch2(sb,branch.getId().toString(),userIdPrefix,loginUser);				
				String pId = branch.getId().toString();
				getBranchsItemsByParentId2(sb,pId,branchIdPrefix,userIdPrefix,loginUser);
				sb.append("</item>");
			}
			
			//获得未分配部门的用户
//			getNoBranchUsers(sb,branchIdPrefix,userIdPrefix);
	}	
	private void getNoBranchUsers(StringBuffer sb,String branchIdPrefix,String userIdPrefix){
		sb.append("<item id='" +branchIdPrefix
				+ "0"
				+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
				+ "待分配" + "\">");
		sb.append("<userdata name=\"type\">2</userdata>");
//		根据部门找用户
//		userManager.getUsersItemsByBranch(sb,branch.getId().toString(),userIdPrefix);				
		sb.append("</item>");		
		
	}

	public Map getBranchSelect(Branch branch) {
		  Map reply = new LinkedHashMap();
		

		if(SysParamUtil.useMoreCarrierSortParam()){
			if(UserUtil.isSuperUser()){
				branch.setOrgId(null);
			}
		}	
		
		
		List ls = dao.getBranchs(branch);
		
		System.out.println("saveBranchUser error>>>>>>>>>ttttttttttttttttt>>>>>>>>>>>>"+branch.toString());
		
		
	    Iterator it = ls.iterator();
	    while(it.hasNext()){
	    	Branch branchs = (Branch) it.next();
	    	String name = branchs.getName();
	    	if(UserUtil.isSuperUser() && SysParamUtil.useMoreCarrierSortParam()) name =name+ "||" + branchs.getOrgId().toString();
//	    	reply.put("0","");
	    	reply.put(branchs.getId(),name);
	    }
		return reply;
	}



	public void removeBranchUser(String userId, String branchId) {
		  Map branchMp = new HashMap();
		  branchMp.put("userId", userId);
		  branchMp.put("branchId", branchId);
		  
		  try {
			  dao.removeBranchUserByBanchId(branchMp);
	      } catch (DataIntegrityViolationException e) {
	    	  System.out.println("saveBranchUser error>>>>>>>>>>>>>>>>>>>>>"+branchId);
	      }
		
	}


	 public List getTreeForJosin(TreeNode node,User user){
		 List trees = new ArrayList();

			
			Long orgId = user.getOrgId();
			String parentNodeId = node.getNodeId();
			
			if(log.isDebugEnabled()){
				log.info("getTreeForJosin getCustomerCateByUserObj parentId>>>>>>>>>>>>>>>"+node.getNodeId());
				log.info("getTreeForJosin getCustomerCateByUserObj getNodeType>>>>>>>>>>>>>>>"+node.getNodeType());
				log.info("getTreeForJosin getCustomerCateByUserObj getNodelevel>>>>>>>>>>>>>>>"+node.getNodelevel());
				log.info("getTreeForJosin getCustomerCateByUserObj getOrgId>>>>>>>>>>>>>>>"+ user.getOrgId());
			}
			
			
			if("0".equals(node.getNodelevel())){
					List ls2 = dao.getBranchsByParentUser(user);
					Iterator it2 = ls2.iterator();
					while (it2.hasNext()) {
						Branch branch = (Branch) it2.next();
					    Map map = new HashMap();
						map.put("id",branch.getId().toString());
						map.put("text", branch.getName());
						map.put("type",node.getNodeType());
						map.put("level","1");
						map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
						map.put("iconCls","x-tree-node-icon");
						
						
						Branch brn = new Branch();
						brn.setParentId(branch.getId().toString());
						List ls3 = dao.getBranchs(brn);
						
						boolean isLeaf = ls3.size() == 0;
						
						map.put("leaf", Boolean.valueOf(isLeaf));	
						trees.add(map);
					 }
				   	
			}else if("1".equals(node.getNodelevel())){
				Branch brn = new Branch();
				brn.setParentId(parentNodeId);
				List ls2 = dao.getBranchs(brn);
				Iterator it2 = ls2.iterator();
				while (it2.hasNext()) {
					Branch branch = (Branch) it2.next();
				    Map map = new HashMap();
					map.put("id",branch.getId().toString());
					map.put("text", branch.getName());
					map.put("type",node.getNodeType());
					map.put("level","1");
					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
					map.put("iconCls","x-tree-node-icon");
					
					Branch brn2 = new Branch();
					brn.setParentId(branch.getId().toString());
					List ls4 = dao.getBranchs(brn2);
					
					
//					List lsUsers = userManager.getusers(new User()).setBranchId(branch.getId()));
					
					boolean isLeaf = ls4.size() == 0 ;
					map.put("leaf", Boolean.valueOf(isLeaf));		
					
					trees.add(map);
				 }
			}else{
				
//				Carrier carrier = new Carrier();
//				carrier.setCarrierTypeId(new Long(parentNodeId));
//				carrier.setParentId("0");
//				List ls2 = carrierManager.getCarriers(carrier);
//				Iterator it2 = ls2.iterator();
//				while (it2.hasNext()) {
//					Carrier car =  (Carrier) it2.next();
//				    Map map = new HashMap();
//					map.put("id",car.getId().toString());
//					map.put("text", car.getCarrierName());
//					map.put("type",node.getNodeType());
//					map.put("level","1");
//					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
//					map.put("iconCls","x-tree-node-icon");
//					map.put("leaf", Boolean.valueOf(true));	
//					trees.add(map);
//				  
//			   }
				

				
			}
			
			
			return trees;
	 }
    
}
