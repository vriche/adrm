package com.vriche.adrm.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.BranchManager;
import com.vriche.adrm.service.CarrierTypeManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.IncomeModeManager;
import com.vriche.adrm.service.IncomePurposeManager;
import com.vriche.adrm.service.OrgManager;
import com.vriche.adrm.service.SearchManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.StringUtil;

public class SearchManagerImpl extends BaseManager  implements SearchManager {
	private CustomerManager customerManager;
	private CarrierTypeManager carrierTypeManager;
	private UserManager userManager;
	private IncomePurposeManager incomePurposeManager;
	private IncomeModeManager incomeModeManager;	
	private BranchManager branchManager;
	private OrgManager orgManager;
	
	


	

	public void setCarrierTypeManager(CarrierTypeManager carrierTypeManager) {
		this.carrierTypeManager = carrierTypeManager;
	}

	public void setBranchManager(BranchManager branchManager) {
		this.branchManager = branchManager;
	}

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	public void setIncomeModeManager(IncomeModeManager incomeModeManager) {
		this.incomeModeManager = incomeModeManager;
	}

	public void setIncomePurposeManager(IncomePurposeManager incomePurposeManager) {
		this.incomePurposeManager = incomePurposeManager;
	}

	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setDao(Dao dao) {
		// TODO Auto-generated method stub

	}

	public List getObjects(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveObject(Object o) {
		// TODO Auto-generated method stub

	}

	public void removeObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub

	}
	
	
	public List getTreeForJosin(TreeNode node,Map mp){
		List trees = new ArrayList();
		String parentNodeId = node.getNodeId();
		String nodeType = node.getNodeType();
		String orgId = StringUtil.null2String((String)mp.get("orgId")); 
		String loginUser = StringUtil.null2String((String)mp.get("loginUser")); 
		String loginUserId = StringUtil.null2String((String)mp.get("loginUserId")); 
		String[] searchTargs = node.getSearchTarg();
		List lsTemp = new ArrayList();
		
		org.apache.commons.collections.CollectionUtils.addAll(lsTemp,searchTargs);
		
		if(log.isDebugEnabled()){
			log.info("getTreeForJosin getCustomerCateByUserObj orgId>>>>>>>>>>>>>>>"+(String)mp.get("orgId"));
			log.info("getTreeForJosin getCustomerCateByUserObj parentId>>>>>>>>>>>>>>>"+node.getNodeId());
			log.info("getTreeForJosin getCustomerCateByUserObj nodeType>>>>>>>>>>>>>>>"+node.getNodeType());
			log.info("getTreeForJosin getCustomerCateByUserObj loginUserId>>>>>>>>>>>>>>>"+loginUserId);
			log.info("getTreeForJosin getCustomerCateByUserObj searchTarg>>>>>>>>>>>>>>>"+searchTargs.toString());
			
		}
		
		if("0".equals(parentNodeId)){
		        
			 if(lsTemp.contains("A")){
					Map map = new HashMap();
					map.put("id","A");
					map.put("text", "客户信息");
					map.put("leaf", Boolean.valueOf(false));
					map.put("type","1");
					map.put("level","0");
					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
					trees.add(map);
			 }
			 if(lsTemp.contains("B")){
					Map map = new HashMap();
					map.put("id","B");
					map.put("text", "频道信息");
					map.put("leaf", Boolean.valueOf(false));
					map.put("type","2");
					map.put("level","0");
					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
					trees.add(map);
			 }
			 
			 if(lsTemp.contains("C")){
					Map map = new HashMap();
					map.put("id","C");
					map.put("text", "用户部门");
					map.put("leaf", Boolean.valueOf(false));
					map.put("type","3");
					map.put("level","0");
					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
					trees.add(map);
			 }
			 
			 if(lsTemp.contains("D")){
					Map map = new HashMap();
					map.put("id","D");
					map.put("text", "到款用途");
					map.put("leaf", Boolean.valueOf(false));
					map.put("type","4");
					map.put("level","0");
					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
					trees.add(map);
			 }
			 
			 if(lsTemp.contains("E")){
					Map map = new HashMap();
					map.put("id","E");
					map.put("text", "时间范围");
					map.put("leaf", Boolean.valueOf(false));
					map.put("type","5");
					map.put("level","0");
					trees.add(map);
			 }
				
		}
		
		
		
		if("1".equals(nodeType)){
			Customer customer = new Customer();
			customer.setOrgId(new Long(orgId));
			trees =  customerManager.getTreeForJosin(node,customer);
		}
		
		if("2".equals(nodeType)){
			
			CarrierType cType = new CarrierType();
			cType.setOrgId(new Long(orgId));
			cType.setParentId(new Long("0"));
			trees =  carrierTypeManager.getTreeForJosin(node,cType);
//			ls =  customerManager.getTreeForJosin(node,(Customer)obj);
		}	
		
		
		if("3".equals(nodeType)){
			
			User user = new User();
			user.setOrgId(new Long(orgId));
			user.setId(new Long(loginUserId));
			trees =  branchManager.getTreeForJosin(node,user);
//			ls =  customerManager.getTreeForJosin(node,(Customer)obj);
		}		
		
		return trees;
	}


}
