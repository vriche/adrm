
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.service.BranchManager;
import com.vriche.adrm.service.OrgManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class OrgManagerImpl extends BaseManager implements OrgManager {
    private OrgDao dao;
    
    private BranchManager branchManager;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOrgDao(OrgDao dao) {
        this.dao = dao;
    }
    
	public void setBranchManager(BranchManager branchManager) {
		this.branchManager = branchManager;
	}    
	
   /**
     * @see com.vriche.adrm.service.OrgManager#getOrgs(com.vriche.adrm.model.Org)
     */
    public List getOrgs(final Org org) {
    	
    	
    	
        return dao.getOrgs(org);
    }
   /**
     * @see com.vriche.adrm.service.OrgManager#getOrgsCount(com.vriche.adrm.model.Org)
     */
    public String getOrgsCount(final Org org) {
        return dao.getOrgsCount(org).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OrgManager#getOrgsCount(com.vriche.adrm.model.Org)
     */    
	public List getOrgsPage(Org org,String pageIndex, String pageSize) {
		// 判断是否是组织管理员

		
//		System.out.println("UserUtil.isSuperUser()>>>>>>>>>>>>>>>>>22);"+UserUtil.isSuperUser());
		
		
		Org org2 = new Org();
		 List ls = new ArrayList();
		if(SysParamUtil.useMoreCarrierSortParam()){
			if(!UserUtil.isSuperUser()){
				String orgAdminId = UserUtil.getCurrentPrincipalUserId();
				org2.setCreateBy(new Long(orgAdminId));
				 ls = dao.getOrgsNew(org2);
				 
				 System.out.println("ls>>>>>>>>>>>>>>>>>22);"+ls.size());
				 
			}else{
				 ls = this.getOrgs(org2);
			}
			   
		}else{
			    ls = this.getOrgs(org2);
		}
	
		return ls;
	}    

    /**
     * @see com.vriche.adrm.service.OrgManager#getOrg(String id)
     */
    public Org getOrg(final String id) {
        return dao.getOrg(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OrgManager#getOrgsByIdList(final Map idList)
     */
    public List getOrgsByIdList(final Map idList) {
        return dao.getOrgsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OrgManager#saveOrg(Org org)
     */
    public String saveOrg(Org org) {
        return dao.saveOrg(org).toString();
    }
    
	public String saveOrgLogo(Org org) {
		return dao.saveOrgLogo(org).toString();
	}
    /**
     * @see com.vriche.adrm.service.OrgManager#removeOrg(String id)
     */
    public void removeOrg(final String id) {
        dao.removeOrg(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OrgManager#removeOrgs(String Map)
     */
    public void removeOrgs(final Map idList) {
        dao.removeOrgs(idList);
    }
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OrgManager#getOrgsXml(java.lang.String)
	 */
//	public String getOrgsXml(String orgId,String OrgIdPrefix,String BranchIdPrefix,String UserIdPrefix) {
//		Org org = this.getOrg(orgId);
//		StringBuffer sb = new StringBuffer("");
//		sb.append("<?xml version=\"1.0\"?>");
//		sb.append("<tree id=\"0\">");
//		sb.append("<item text=\"" + org.getName() + "\" id=\"" + OrgIdPrefix + "-1\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
//		sb.append("<userdata name=\"type\">1</userdata>");
////		sb.append("<userdata name=\"id\">"+ orgId +"</userdata>");
////		sb.append("<userdata name=\"IdPrefix\">" + OrgIdPrefix +"</userdata>");
//		branchManager.getBranchsItemsByParentId(sb,"0",BranchIdPrefix,UserIdPrefix);
//		sb.append("</item>");
//		sb.append("</tree>");
//		return new String(sb.toString());
//	}
	
	
	public String getOrgsXml(String org_Id,String OrgIdPrefix,String BranchIdPrefix,String UserIdPrefix) {
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");

		int orgId = new Integer(StringUtil.null2String(org_Id)).intValue();
		
		System.out.println("orgId>>>>>>>>>>>>>>>>>>>>ttttttttttvvvvv>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orgId);
     
		Org org2 = new Org();
		org2.setParentId("0");

		if(SysParamUtil.useMoreCarrierSortParam()){
			if(!UserUtil.isSuperUser() || orgId>0){
				if(orgId > 0){
					org2.setId(new Long(orgId));
				}else{
					String orgAdminId = UserUtil.getCurrentPrincipalUserId();
					org2.setCreateBy(new Long(orgAdminId));	
				}

			}
		}
		
		
		List ls = dao.getOrgs(org2);
		
		System.out.println("ls.size>>>>>>>>>>>>>>>>>>>>ttttttttttvvvvv>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ls.size());
		
		for (Iterator it = ls.iterator();it.hasNext();){
			 	Org org = (Org)it.next();
				sb.append("<item text=\""+ org.getName() + "\" id=\"" +OrgIdPrefix+ org.getId().toString() + "\" open=\"1\" im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" call=\"1\" select=\"1\">");
				sb.append("<userdata name=\"type\">1</userdata>");
//				sb.append("<userdata name=\"id\">"+  org.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"orgid\">"+ org.getId().toString() +"</userdata>");
				sb.append("<userdata name=\"parentOrgId\">"+org.getId().toString() +"</userdata>");
				getOrgsByParentIdItem(sb, org,OrgIdPrefix,BranchIdPrefix,UserIdPrefix);
				branchManager.getBranchsItemsByParentId3(sb,org,"0",BranchIdPrefix,UserIdPrefix);
				sb.append("</item>");
		}
		sb.append("</tree>");
		return new String(sb.toString());
	}  
	

	
	private int getOrgsByParentIdItem(StringBuffer sb,Org og,String OrgIdPrefix,String BranchIdPrefix,String UserIdPrefix){

		Org org2 = new Org();
		org2.setParentId(og.getId().toString());
		String parentOrgId = og.getId().toString();
		List ls = this.getOrgs(org2);

		for(Iterator it = ls.iterator();it.hasNext();){
			Org org = (Org)it.next();
			sb.append("<item text=\""+ org.getName() + "\" id=\"" +OrgIdPrefix+ org.getId().toString() + "\"  im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\" >");
			sb.append("<userdata name=\"type\">1</userdata>");
//			sb.append("<userdata name=\"id\">"+  org.getId().toString() +"</userdata>");
			sb.append("<userdata name=\"orgid\">"+ org.getId().toString() +"</userdata>");
			sb.append("<userdata name=\"parentOrgId\">"+parentOrgId +"</userdata>");
//			getOrgsByParentIdItem(sb,org,OrgIdPrefix,BranchIdPrefix,UserIdPrefix);
			branchManager.getBranchsItemsByParentId3(sb,org,"0",BranchIdPrefix,UserIdPrefix);
			sb.append("</item>");		
			
		}
		return ls.size();
	}
	
	public String getOrgsXml2(Org og,String OrgIdPrefix,String BranchIdPrefix,String UserIdPrefix,String loginUser) {
		
		
		Org org = this.getOrg(og.getId().toString());
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"" + org.getName() + "\" id=\"" + OrgIdPrefix + "-1\" open=\"1\" im0=\"magazines_close.gif\" im1=\"magazines_open.gif\" im2=\"magazines_close.gif\"  call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"type\">1</userdata>");
//		sb.append("<userdata name=\"id\">"+ orgId +"</userdata>");
//		sb.append("<userdata name=\"IdPrefix\">" + OrgIdPrefix +"</userdata>");
		getOrgsByParentIdItem(sb, org,OrgIdPrefix,BranchIdPrefix,UserIdPrefix);
		branchManager.getBranchsItemsByParentId2(sb,"0",BranchIdPrefix,UserIdPrefix,loginUser);
		sb.append("</item>");
		sb.append("</tree>");
		return new String(sb.toString());
	}
	

	public Map getOrgSelect(Org org) {
		
			Org org2 = new Org();
			 List ls = new ArrayList();
			if(SysParamUtil.useMoreCarrierSortParam()){
				if(!UserUtil.isSuperUser()){
					String orgAdminId = UserUtil.getCurrentPrincipalUserId();
					org2.setCreateBy(new Long(orgAdminId));
					 ls = dao.getOrgsNew(org2);
				}else{
					 ls = this.getOrgs(org2);
				}
				   
			}else{
				    ls = this.getOrgs(org2);
			}
		
		 
		
	
//			List ls = this.getOrgs(org);
			
		    Map reply = new LinkedHashMap();
		    Iterator it = ls.iterator();
		    
		    while(it.hasNext()){
		    	Org orgs = new Org();
		    	orgs = (Org) it.next();
		    	
//		    	if(UserUtil.isSuperUser()) reply.put("0","");
		    	reply.put(orgs.getId(),orgs.getName());
		    }
			return reply;
	
	}






    
    
    
    
    
}
