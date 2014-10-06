package com.vriche.adrm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.model.Org;

public class OrderCateUtil {
	
	public static  Object[] getOrderCateMain(){
		
		Map orderCategoryMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDER_CATELOG_MAP);
		String parentId = "0";
		boolean isOneOrgMoreSuborgsParam = SysParamUtil.getOneOrgMoreSuborgsParam();
		
		
//		System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>>>>>>1111111111111>>>>>"+isOneOrgMoreSuborgsParam ); 
		
		
		OrgDao orgDao = ServiceLocator.getOrgDao();
		List orgList1 = orgDao.getOrgs(null);
		 
		List orgList = new ArrayList();
		if(isOneOrgMoreSuborgsParam){
			 if(orgList1.size()>1){
				 orgList.add(orgList1.get(0));
			 }else{
				 orgList = orgList1;
			 }

		}else{
			 Org orgParam = new Org();
			 orgParam.setParentId("0");
			 orgList = orgDao.getOrgs(orgParam);
		}

		Iterator it = orgList.iterator();
		
//		System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>>>>>>22222222222222>>>>>"+orgList.size() ); 
		
		 Object[] objs = new Object[orgList.size()];
		 int i = 0;
		while(it.hasNext()){
			String orgId = ((Org)it.next()).getId().toString();
			List orderCategoryList = (List)orderCategoryMap.get(orgId+","+parentId);
//			System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>"+ orgId +">>>>>333333333>>>>>"+orderCategoryList.size() ); 
			objs[i++] = orderCategoryList;
//			objs[Integer.valueOf(orgId).intValue()] = orderCategoryList;
//			OrderCategory orderCategory = (OrderCategory)orderCategoryList.get(0);
//			System.out.println("orderCategory>>>>>>>>>>>>>bbb>>>>>"+orderCategory.toString() ); 
//			mp.put(orgId,orderCategoryList);
		}
		return objs;
	}
	
public static  Map getOrderCateMain_Map(){
		
		Map orderCategoryMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDER_CATELOG_MAP);
		String parentId = "0";
		boolean isOneOrgMoreSuborgsParam = SysParamUtil.getOneOrgMoreSuborgsParam();
		
		
//		System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>>>>>>1111111111111>>>>>"+isOneOrgMoreSuborgsParam ); 
		
		
		OrgDao orgDao = ServiceLocator.getOrgDao();
		List orgList1 = orgDao.getOrgs(null);
		 
		List orgList = new ArrayList();
		if(isOneOrgMoreSuborgsParam){
			 if(orgList1.size()>1){
				 orgList.add(orgList1.get(0));
			 }else{
				 orgList = orgList1;
			 }

		}else if(orgList1.size()>1){
		
				 orgList = orgList1;
			
		}else{
		
			 Org orgParam = new Org();
			 orgParam.setParentId("0");
			 orgList = orgDao.getOrgs(orgParam);
		}

		Iterator it = orgList.iterator();
		
//		System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>>>>>>22222222222222>>>>>"+orgList.size() ); 
		
		 Object[] objs = new Object[orgList.size()];
		 int i = 0;
			Map mpp = new HashMap();
		while(it.hasNext()){
			Org org =  ((Org)it.next());
//			parentId = org.getParentId();
			String orgId = org.getId().toString();
//			System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>>>>>>22222222222222 orgId>>>>>"+orgId ); 
//			System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>>>>>>22222222222222 parentId>>>>>"+parentId ); 
			List orderCategoryList = (List)orderCategoryMap.get(orgId+","+parentId);
//			System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>"+ orgId +">>>>>333333333>>>>>"+orderCategoryList.size() ); 
//			objs[i++] = orderCategoryList;
			if(orderCategoryList != null){
				mpp.put("orgId_"+orgId,orderCategoryList);
			}
			
//			objs[Integer.valueOf(orgId).intValue()] = orderCategoryList;
//			OrderCategory orderCategory = (OrderCategory)orderCategoryList.get(0);
			System.out.println("orderCategory>>>>>>>>>>>>>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb key >>>>>"+"orgId_"+orgId ); 
			if(orderCategoryList != null) System.out.println("isOneOrgMoreSuborgsParam>>>>>>>>"+ orgId +">>>>>333333333>>>>> size"+orderCategoryList.size() ); 
			
//			System.out.println("orderCategory>>>>>>>>>>>>>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb>>>>>"+orderCategoryList.size() ); 
//			mp.put(orgId,orderCategoryList);
		}
		
		System.out.println("orderCategory>>>>>>>>>         654321         >>>>"+mpp.size() ); 
		
		return mpp;
	}
}
