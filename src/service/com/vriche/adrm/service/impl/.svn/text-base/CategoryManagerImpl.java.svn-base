
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CategoryDao;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.service.CategoryManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class CategoryManagerImpl extends BaseManager implements CategoryManager {
    private CategoryDao dao;
    private CustomerManager customerManager;
    public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCategoryDao(CategoryDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.crm.service.CategoryManager#getCategorysByIdList(final Map idList)
     */
    public List getCategorysByIdList(final Map idList) {
        return dao.getCategorysByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.CategoryManager#getCategorys(com.vriche.adrm.crm.model.Category)
     */
    public List getCategorys(final Category category) {
        return dao.getCategorys(category);
    }
    
	public Map getCategorySelectLimit(Category category) {
		boolean 	catFiter = SysParamUtil.getCustomerCateFiter();
		Map reply = new LinkedHashMap();
		
		if(log.isDebugEnabled()){
			log.info("getCategorySelectLimit>>>catFiter>>>>>>>>>>>>>>>>>>>>>>>>>"+catFiter);
		}
		
		if(catFiter){
			String loginUser = category.getLoginUser();
			loginUser = loginUser == null||"".equals(loginUser)? UserUtil.getCurrentPrincipalUser():loginUser;
			
			Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_OBJ);
			Object obj = mp.get(loginUser);
			List ls = new ArrayList();
			if(obj != null){
				 ls = (List)mp.get(loginUser);
			}
			
			
//			Collections.sort(ls);
//	         Object[]   key   =     map.keySet().toArray();  
//	         Arrays.sort(key);   
	         
			for(Iterator it = ls.iterator();it.hasNext();){
				Category cat = (Category)it.next();
				reply.put(cat.getId(),cat.getCategoryName());
			}
			
		}else{
			   List it = getCategorys(category);
			   for(Iterator ls = it.iterator();ls.hasNext();){
				   Category cat  = (Category) ls.next();
			    	reply.put(cat.getId(),cat.getCategoryName());
			    }
		}



		return reply;
	}
	
	
	public Map getCategorySelectLimit2(Category category) {
		boolean 	catFiter = SysParamUtil.getCustomerCateFiter();
		Map reply = new LinkedHashMap();
		
		if(log.isDebugEnabled()){
			log.info("getCategorySelectLimit>>>catFiter>>>>>>>>>>>>>>>>>>>>>>>>>"+catFiter);
		}
		
		if(catFiter){
			String loginUser = category.getLoginUser();
			loginUser = loginUser == null||"".equals(loginUser)? UserUtil.getCurrentPrincipalUser():loginUser;
			
			Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_OBJ);
			List ls = (List)mp.get(loginUser);
//			Collections.sort(ls);
//	         Object[]   key   =     map.keySet().toArray();  
//	         Arrays.sort(key);   
	         
			for(Iterator it = ls.iterator();it.hasNext();){
				Category cat = (Category)it.next();
				reply.put(cat.getId(),cat.getCategoryName());
			}
		}else{
			   List it = getCategorys(category);
			   for(Iterator ls = it.iterator();ls.hasNext();){
				   Category cat  = (Category) ls.next();
				   log.info("getCategorySelectLimit2>>>catFiter>>>>>>>>>>>>>>>>>>>>>>>>>"+cat.getId());
				   if(!"1".equals(cat.getId().toString())){
				    	reply.put(cat.getId(),cat.getCategoryName());
				   }

			    }
		}



		return reply;
	}
	
	public List getCategorySelectLimitList(Category category) {
		boolean 	catFiter = SysParamUtil.getCustomerCateFiter();
		List lsNew = new ArrayList();
		
		if(log.isDebugEnabled()){
			log.info("getCategorySelectLimit>>>catFiter>>>>>>>>>>>>>>>>>>>>>>>>>"+catFiter);
		}
		
		if(catFiter){
			String loginUser = category.getLoginUser();
			loginUser = loginUser == null||"".equals(loginUser)? UserUtil.getCurrentPrincipalUser():loginUser;
			
			Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_OBJ);
			List ls = (List)mp.get(loginUser);
//			Collections.sort(ls);
//	         Object[]   key   =     map.keySet().toArray();  
//	         Arrays.sort(key);   
	         
			for(Iterator it = ls.iterator();it.hasNext();){
				Category cat = (Category)it.next();
				lsNew.add(cat);
			}
		}else{
			   List it = getCategorys(category);
			   for(Iterator ls = it.iterator();ls.hasNext();){
				   Category cat  = (Category) ls.next();
				   lsNew.add(cat);
			    }
		}



		return lsNew;
	}	
//	public Map getCategorySelectByUserLimit(Category category) {
//		Map reply = new LinkedHashMap();
//	    List it = getCategorys(category);
//	   for(Iterator ls = it.iterator();ls.hasNext();){
//		   Category cat  = (Category) ls.next();
//	    	if(!cat.getId().equals(new Long(1))){
//	    		reply.put(cat.getId(),cat.getCategoryName());
//	    	}
//	    }
//		return reply;
//	}	

    /**
     * @see com.vriche.adrm.crm.service.CategoryManager#getCategory(String id)
     */
    public Category getCategory(final String id) {
        return dao.getCategory(new Long(id));
    }

    /**
     * @see com.vriche.adrm.crm.service.CategoryManager#saveCategory(Category category)
     */
    public void saveCategory(Category category) {
        dao.saveCategory(category);
    }

    /**
     * @see com.vriche.adrm.crm.service.CategoryManager#removeCategory(String id)
     */
    public void removeCategory(final String id) {
        dao.removeCategory(new Long(id));
    }
    
    public String getCategoryTreeXML(Category category, String categoryIdPrefix,String customerIdPrefix) {
    	StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"客户信息\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
		getCategoryForTree(category.getOrgId(),sb,categoryIdPrefix,customerIdPrefix);
		sb.append("</item>");
		sb.append("</tree>");

		return sb.toString();
    	
    }
    

    
    private void getCategoryForTree(String orgId,StringBuffer sb,String categoryIdPrefix,String customerIdPrefix){
    	List categorysList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CUSTOMER_TYPE);
		for(Iterator it = categorysList.iterator();it.hasNext();) {		
			Category category = (Category) it.next();
			int categoryId = category.getId().intValue();
			
			if(categoryId != 1){
				sb.append("<item id='" +categoryIdPrefix
						+ categoryId
						+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
						+ category.getCategoryName().toString() + "\">");
				sb.append("<userdata name=\"id\">" + categoryId
						+ "</userdata>");
				sb.append("<userdata name=\"type\">1</userdata>");			
//				customerManager.getCustomersIdsByCategory(new Integer(categoryId).toString(),sb,customerIdPrefix);
				customerManager.getCustomersIdsByCategory(orgId,new Integer(categoryId).toString(),sb,customerIdPrefix);
				sb.append("</item>");
			}

		}	
}

     /**
     * @see com.vriche.adrm.crm.service.CategoryManager#removeCategorys(String Map)
     */
    public void removeCategorys(final Map idList) {
        dao.removeCategorys(idList);
    }    
}
