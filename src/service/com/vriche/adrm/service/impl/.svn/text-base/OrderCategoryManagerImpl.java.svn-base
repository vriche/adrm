
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.OrderCategoryDao;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.OrderCategoryManager;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.SysParamUtil;

public class OrderCategoryManagerImpl extends BaseManager implements OrderCategoryManager {
    private OrderCategoryDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOrderCategoryDao(OrderCategoryDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.order.service.OrderCategoryManager#getOrderCategorysByIdList(final Map idList)
     */
    public List getOrderCategorysByIdList(final Map idList) {
        return dao.getOrderCategorysByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.order.service.OrderCategoryManager#getOrderCategorys(com.vriche.adrm.order.model.OrderCategory)
     */
    public List getOrderCategorys(final OrderCategory orderCategory) {
        return dao.getOrderCategorys(orderCategory);
    }

    /**
     * @see com.vriche.adrm.order.service.OrderCategoryManager#getOrderCategory(String id)
     */
    public OrderCategory getOrderCategory(final String id) {
        return dao.getOrderCategory(new Long(id));
    }

    /**
     * @see com.vriche.adrm.order.service.OrderCategoryManager#saveOrderCategory(OrderCategory orderCategory)
     */
    public String saveOrderCategory(OrderCategory orderCategory) {
        return dao.saveOrderCategory(orderCategory).toString();
    }

    /**
     * @see com.vriche.adrm.order.service.OrderCategoryManager#removeOrderCategory(String id)
     */
    public void removeOrderCategory(final String id) {
        dao.removeOrderCategory(new Long(id));
    }

     /**
     * @see com.vriche.adrm.order.service.OrderCategoryManager#removeOrderCategorys(String Map)
     */
    public void removeOrderCategorys(final Map idList) {
        dao.removeOrderCategorys(idList);
    }

	public Map getOrderCategorySelect(OrderCategory orderCategory) {
		List ls = this.getOrderCategorys(orderCategory);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	OrderCategory category = new OrderCategory();
	    	category = (OrderCategory) it.next();
	    	
	    	reply.put("0","");
	    	reply.put(category.getId(),category.getName() + "||" + category.getCalculateAuto());
	    }
		return reply;
	}

//	private List getOrderCategorysOrderList(OrderCategory category) {
//		
//        return dao.getOrderCategorysOrderList(category);
//    }
	
	public Map getOrderCategorySelectOrderList(String orgId,String version) {
//		List ls = this.getOrderCategorysOrderList();
//		Map sameNameIds = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDERLIST_CATELOG_MAP);
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		List fitterOrderSubCatesList  = SysParamUtil.getFitterOrderSubCates(version);
		
		 Map temp = new LinkedHashMap();
		 Map temp2 = new LinkedHashMap();
	    Map reply = new LinkedHashMap();
	    reply.put("0","==订单类别==");	
	    
	    OrderCategory orderCategoryParam = new OrderCategory();
	    
	    System.out.println("orgId;  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>999999999999999>>>>>>>>>>>>>>  "+fitterOrderSubCatesList);   
	    
	    orderCategoryParam.setOrgId(new Long(orgId));
	    orderCategoryParam.setVersion(Integer.valueOf(version));
	    List catList = dao.getOrderCategorysFromOrder(orderCategoryParam);
	    
//	    System.out.println("catList.size;  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>999999999999999>>>>>>>>>>>>>>  "+catList.size());   

	    for(Iterator it = catList.iterator();it.hasNext();){
	    	 OrderCategory orderCategory = (OrderCategory)it.next();
	    	 String lable = orderCategory.getName();
//	    	 String id = orderCategory.getId().toString();
	    	 
//	    	 boolean passFitter = financialAuditSwitch? !fitterOrderSubCatesList.contains(id):true;
	    	 
	    	 if(!temp.containsKey(lable) ){
	    		 System.out.println("lable;  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>999999999999999>>>>>>>>>>>>>>  "+lable);  
	    		 temp2.put("orgId",orgId);
	    		 temp2.put("value",lable);
	    		 temp2.put("version",version);
	    		 if(financialAuditSwitch){
	    			 temp2.put("fitterOrderSubCatesList",fitterOrderSubCatesList);
	    			 
	    		 }
		    	 String sameNames = ConvertUtil.convertFromListToArray3(dao.getSameNameIdListByOrg(temp2),",");
		    	 reply.put(sameNames,lable );
		    	 temp.put(lable,lable);
	    	 }

	    }
	    
 
//	    for(Iterator it = sameNameIds.keySet().iterator();it.hasNext();){
//	    	String cateName = (String)it.next();
//	    	
////	    	System.out.println("ls.iterator();    "+sameNameIds.get(cateName));    	
//	    	
////	    	System.out.println("cateName;    "+cateName);   
//	    	reply.put(sameNameIds.get(cateName).toString(),cateName );
//	    }
		return reply;
	}
	
	
	
	
	
	
	public Map getOrderCategoryFromOrder(OrderCategory category) {
		Integer version = category.getVersion();
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		List fitterOrderSubCatesList  = SysParamUtil.getFitterOrderSubCates(version.toString());
//		Map temp = new LinkedHashMap();
		Map temp2 = new LinkedHashMap();
	    Map reply = new LinkedHashMap();

	    OrderCategory orderCategoryParam = new OrderCategory();
	    orderCategoryParam.setOrgId(category.getOrgId());
	    orderCategoryParam.setVersion(category.getVersion());
	    if(financialAuditSwitch){
	    	 orderCategoryParam.setFitterOrderSubCatesList(fitterOrderSubCatesList);
//	    	 System.out.println("lable;  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>999999999999999>>>6666666666 777777777>>>>>>>>>>>  "+fitterOrderSubCatesList);  
	    }
	    List catList = dao.getOrderCategorysFromOrder(orderCategoryParam);
	    

	    for(Iterator it = catList.iterator();it.hasNext();){
	    	 OrderCategory orderCategory = (OrderCategory)it.next();
	    	 String lable = orderCategory.getName();
//	    	 boolean passFitter = financialAuditSwitch? !fitterOrderSubCatesList.contains(id):true;
//	    	 if(passFitter){
//	    		 System.out.println("lable;  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>999999999999999>>>>>>>>>>>>>>  "+lable);  
	    		 temp2.put("orgId",category.getOrgId());
	    		 temp2.put("value",lable);
	    		 temp2.put("version",category.getVersion());
	    		 if(financialAuditSwitch){
	    			 temp2.put("fitterOrderSubCatesList",fitterOrderSubCatesList);
	    		 }
	    		
		    	 String sameNames = ConvertUtil.convertFromListToArray3(dao.getSameNameIdListByOrg(temp2),",");
		    	 reply.put(sameNames,lable );
//		    	 temp.put(lable,lable);
//	    	 }

	    }
	    

		return reply;
	}
	
	
	
	public String getOrderCategoryXML(OrderCategory orderCategory, String IdPrefix) {
		Integer version = orderCategory.getVersion();

		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"订单类别\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
//		getOrderCategoryIdsByParent(orderCategory,sb,IdPrefix);
		Iterator it = this.getOrderCategorys(orderCategory).iterator();
		while (it.hasNext()) {
			OrderCategory oc = (OrderCategory) it.next();
			sb.append("<item id='" +IdPrefix+ oc.getId().toString()+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""+ oc.getName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + oc.getId().toString()+ "</userdata>");
			sb.append("<userdata name=\"type\">1</userdata>");
			
			getOrderCategoryIdsByParent(version,oc,sb,IdPrefix);
			
			sb.append("</item>");
		}

		sb.append("</item>");
		sb.append("</tree>");
		return sb.toString();
	}  
	
	private void getOrderCategoryIdsByParent(Integer year,OrderCategory orderCategory, StringBuffer sb,String IdPrefix) {
		OrderCategory category = new OrderCategory();
		category.setOrgId(orderCategory.getOrgId());
		category.setParentId(orderCategory.getId().toString());
	
//		if(version != null){
////			System.out.println(" category.getVersion().intValue()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ category.getVersion().intValue());  
//			if(version.intValue() ==  category.getVersion().intValue()||category.getVersion().intValue() == 0) {
//				ls.add(category);
//				 System.out.println("getStore parent_id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+category.getName());  
//			}
//		}	
		
		
		
		Iterator it = this.getOrderCategorys(category).iterator();
		while (it.hasNext()) {
			OrderCategory oc = (OrderCategory) it.next();
			
			if(year != null){
				System.out.println("getStore >>>>>>>>>version>>>>>>>>>yy>>>>>>>>>>>>>>>>"+year);  
				 System.out.println("getStore getName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+oc.getName());  
				if(year.intValue() ==  oc.getVersion().intValue()||oc.getVersion().intValue() == 0) {
					sb.append("<item id='" +IdPrefix+ oc.getId().toString()+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""+ oc.getName().toString() + "\">");
					sb.append("<userdata name=\"id\">" + oc.getId().toString()+ "</userdata>");
					sb.append("<userdata name=\"type\">2</userdata>");
					getOrderCategoryIdsByParent(year,oc, sb,IdPrefix);
					sb.append("</item>");	
				}
			}else{
				sb.append("<item id='" +IdPrefix+ oc.getId().toString()+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""+ oc.getName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + oc.getId().toString()+ "</userdata>");
				sb.append("<userdata name=\"type\">2</userdata>");
				getOrderCategoryIdsByParent(year,oc, sb,IdPrefix);
				sb.append("</item>");
			}

		}
	}

	public String getOrderCategorysCount(OrderCategory orderCategory) {
		return dao.getOrderCategorysCount(orderCategory).toString();
	}

	public PaginatedList getOrderCategorysPage(OrderCategory orderCategory, String pageIndex, String pageSize) {
		return  dao.getOrderCategorysPage(orderCategory,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}
	
	public List getOrderCategorysPage2(OrderCategory orderCategory, String pageIndex, String pageSize) {
		Integer version = orderCategory.getVersion();
		
		
		 
		List ls = new ArrayList();
		
		List orderCategoryList = dao.getOrderCategorysPage2(orderCategory,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		 
		Iterator it = orderCategoryList.iterator();
		
		    while(it.hasNext()){
		    	
		      	OrderCategory category =(OrderCategory) it.next();
		      	
		    	if(version != null){
		    		System.out.println("getOrderCategorysPage2 version1  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+category.getVersion());
		    		if(version.intValue() ==  category.getVersion().intValue()||category.getVersion().intValue() == 0) {
		    			ls.add(category);
		    		}
		    		
		    	}
		    }
		    
//		    System.out.println("getOrderCategorysPage2 version2  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());  
		    
		return ls;
	}

	public Map getOrderCategorySelectFromMap(OrderCategory orderCategory) {
//		String parentId = orderCategory.getParentId();
		long orgId = orderCategory.getOrgId().longValue();
		Map orderCategoryMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDER_CATELOG_MAP);
		List orderCategoryList = (List)orderCategoryMap.get(orgId+","+orderCategory.getParentId());
		
	    Map reply = new LinkedHashMap();
	    Iterator it = orderCategoryList.iterator();
//    	reply.put("0","");
	    while(it.hasNext()){
	    	OrderCategory category =(OrderCategory) it.next();
//	    	if(orgId == category.getOrgId().longValue()){
		    	reply.put(category.getId(),category.getName()+"||"+category.getCalculateAuto());
//	    	}

	    }
		return reply;

	}
	
	

	
	public List getStore(OrderCategory orderCategory) {

		Integer version = orderCategory.getVersion();
		String parent_id = orderCategory.getParentId();

		List orderCategoryList = this.getOrderCategorys(orderCategory);
		
	    List ls = new ArrayList();
	    Iterator it = orderCategoryList.iterator();
//    	reply.put("0","");
//	    System.out.println("getStore parent_id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+parent_id);  
//	    System.out.println("getStore version1  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+version);  
	    while(it.hasNext()){
	    	OrderCategory category =(OrderCategory) it.next();
	    		if(version != null){
//	    			System.out.println(" category.getVersion().intValue()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ category.getVersion().intValue());  
	    			if(version.intValue() ==  category.getVersion().intValue()||category.getVersion().intValue() == 0) {
	    				ls.add(category);
//	    				 System.out.println("getStore parent_id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+category.getName());  
	    			}
	    		}else{
	    			ls.add(category);
	    		}

	    }
	    
//	    System.out.println("ls.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());  
	    
		return ls;

	}
	public Map getOrderCategorySelectParentFromMap(OrderCategory orderCategory) {
		// TODO Auto-generated method stub
		List orderCategoryParentList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDER_CATELOGPARENT_MAP);
		Iterator it = orderCategoryParentList.iterator();
		Map reply = new LinkedHashMap();
//		reply.put("0","");
		String parentId = orderCategory.getParentId();
		while(it.hasNext()){
	    	OrderCategory categoryParent =(OrderCategory) it.next();
	    	if(parentId.equals(categoryParent.getParentId())){
		    	reply.put(categoryParent.getId(),categoryParent.getName()+"||"+categoryParent.getCalculateAuto());
	    	}

	    }
		return reply;
	}
	
	
	
	
	public List getTreeForJosin(TreeNode node,OrderCategory orderCategory){
		List trees = new ArrayList();
		
		Integer version = orderCategory.getVersion();
		OrderCategory oCategoryParam = new OrderCategory();
		oCategoryParam.setParentId("0");
		List ls = dao.getOrderCategorys(oCategoryParam);
		
		Long orgId = orderCategory.getOrgId();
		String parentNodeId = node.getNodeId();
		
		if(log.isDebugEnabled()){
			log.info("getTreeForJosin getCustomerCateByUserObj ls>>>>>>>>>>>>>>>"+ls.size());
			log.info("getTreeForJosin getCustomerCateByUserObj parentId>>>>>>>>>>>>>>>"+node.getNodeId());
			log.info("getTreeForJosin getCustomerCateByUserObj getOrgId>>>>>>>>>>>>>>>"+orderCategory.getOrgId());
			log.info("getTreeForJosin getCustomerCateByUserObj getCustomerTypeId>>>>>>>>>>>>>>>"+orderCategory.getVersion());
		}
				
		
		   for(Iterator it = ls.iterator();it.hasNext();){
			   OrderCategory cat  = (OrderCategory) it.next();
			   Map map = new HashMap();
//			   if(cat.getId().longValue()>1){
					map.put("id",cat.getId().toString());
					map.put("text", cat.getName());
					map.put("type","1");
//					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
					
//					if(log.isDebugEnabled()){
//						log.info("getTreeForJosin getCustomerCateByUserObj text>>>>>>>>>>>>>>>"+cat.getName());
//					}			
					
					OrderCategory oCategoryParam2 = new OrderCategory();
	
					oCategoryParam2.setParentId(cat.getId().toString());
					List ls2 = dao.getOrderCategorys(oCategoryParam2);
					Iterator it2 = ls2.iterator();
					
					List ls3 = new ArrayList();
					
				    while(it2.hasNext()){
				    	OrderCategory category =(OrderCategory) it2.next();
				    		if(version != null){
				    			if(version.intValue() ==  category.getVersion().intValue()||category.getVersion().intValue() == 0) {
				    				ls3.add(category); 
				    			}
				    		}else{
				    			ls3.add(category);
				    		}

				    }					
					

					boolean isLeaf = (ls3.size() == 0);
					map.put("leaf", Boolean.valueOf(isLeaf));	
					if (!isLeaf) map.put("expanded", new Boolean(true));
					
					if(!isLeaf){
						List trees2 = new ArrayList();
						for(Iterator it3= ls3.iterator();it3.hasNext();){
							Map map2 = new HashMap();
							OrderCategory obj = (OrderCategory)it3.next();
							map2.put("id",obj.getId().toString());
							map2.put("text", obj.getName());
							map2.put("leaf", Boolean.valueOf(true));
							map2.put("type","2");
//							map2.put("uiProvider","Ext.tree.TreeCheckNodeUI");
							trees2.add(map2);
						}
						map.put("children",trees2);	
//						map.put("childNodesSum", new Integer(ls3.size()));
					}
					
					
					
					trees.add(map);
//			   }
			   
			 
			   
		   }	

		return trees;
	}

	
	public List getOrderCategorySelectFromMap5(OrderCategory orderCategory) {
//		String parentId = orderCategory.getParentId();
//		List ls = new ArrayList();
		long orgId = orderCategory.getOrgId().longValue();
		Map orderCategoryMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDER_CATELOG_MAP);
		List orderCategoryList = (List)orderCategoryMap.get(orgId+","+orderCategory.getParentId());
//		Iterator it = orderCategoryList.iterator();
//
//	    while(it.hasNext()){
//	    	OrderCategory category =(OrderCategory) it.next();
//	    	if(orgId == category.getOrgId().longValue()){
////	    		ls.add(category);
//	    		 System.out.println("getOrderCategorySelectFromMap5>>>>>>>>>>>>>>>>>"+ category.getId() +">>>>>>>>>>>>>>>>>>"+category.getName());  
//	    	}
//
//	    }
//	    

		return orderCategoryList;

	}
}
