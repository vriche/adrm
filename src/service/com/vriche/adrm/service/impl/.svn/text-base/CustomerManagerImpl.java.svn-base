package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.acegisecurity.AccessDeniedException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.CustomerCarrierRel;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.MatterManager;

import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.GetFirstLetter;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class CustomerManagerImpl extends BaseManager implements CustomerManager {
    private CustomerDao dao;
    private UserDao userDao;
    private MatterManager matterManager;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCustomerDao(CustomerDao dao) {
        this.dao = dao;
    }
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setMatterManager(MatterManager matterManager) {
		this.matterManager = matterManager;
	}
    
    public String getCustomersCount(Customer customer) {
    	getCustomerCateFiter(customer);
//    	customer = new Customer();
		return dao.getCustomersCount(customer).toString();
	}
    
 
    


	public List getCustomersPage(Customer customer,String pageIndex, String pageSize) {
		
		getCustomerCateFiter(customer);

//	    String linman =  customer.getLinkMan() ==null?null:customer.getLinkMan().getLinkmanName();
//		customer = new Customer();
		return dao.getCustomersPage(customer,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}


	/**
     * @see com.vriche.adrm.crm.service.CustomerManager#getCustomersByIdList(final Map idList)
     */
    public List getCustomersByIdList(final Map idList) {
    	
        return dao.getCustomersByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.CustomerManager#getCustomers(com.vriche.adrm.crm.model.Customer)
     */
    public List getCustomers(final Customer customer) {
    	
    	getCustomerCateFiter(customer);

        return dao.getCustomers(customer);
    }
    
    private void getCustomerCateFiter(Customer customer) {
    	
    	boolean 	catFiter = SysParamUtil.getCustomerCateFiter();

    	if(catFiter){
        	List ls = UserUtil.getCustomerCateByUser(customer.getLoginUser(),"");
        	
        	if(log.isDebugEnabled()){
        		log.info("getCustomerCateFiter>>>>>>>>>getCustomerCateByUser>>>>>>>>>>>>>>>>"+ls.toArray());
        	}
        	customer.setCustomerCateList(ls);

    	}
    }
    
//    public List getCustomersAnalyze(final Customer customer) {
//    	 System.out.println("customer>>>>>>>>>>>>>>>>>>>>>>>>"+ customer.toString());
//    String customerName = customer.getCustomerName();
//    Object obj = customer.getOrgId();
//    
//   
//
//	 System.out.println("customerName>>>>>>>>>>>>>>>>>>>>>>>>"+ customerName);
//	 System.out.println("setOrgId>>>>>>>>>>>>>>>>>>>>>>>>"+ obj);
//    
////    String linman =  customer.getLinkMan() ==null?null:customer.getLinkMan().getLinkmanName();
//    if(!StringUtils.isEmpty(customerName) && customerName != null && customerName !=""){
//    	  if(customerName.equals("local"))customer.setCustomerName(null);
//    	  if(obj == null){
//    		  customer.setOrgId(null);
//    	  }else{
//    		  customer.setOrgId((Long)obj);
//    	  }
//    	  return dao.getCustomersAnalyze(customer);
//    }else{
//    	return new ArrayList();
//    }
//	 
//      
//    }
    
    public List getCustomersAnalyze(final Customer customer) {
    	String customerName = customer.getCustomerName();
    	String orgId = StringUtil.null2String(customer.getOrgId());
//    	 System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>"+ orgId);
//    	 System.out.println("customerName111111111111111>>>>>>>>>>>>>>>>>>>>>>>>"+ customerName);
    	if(!StringUtils.isEmpty(customerName) && customerName != null && customerName !=""){
    		 if(customerName.equals("local")) customer.setCustomerName(null);
    		 getCustomerCateFiter(customer);
    		 return dao.getCustomersAnalyze(customer);
    	}else{
//    		 System.out.println("customerName22222222222>>>>>>>>>>>>>>>>>>>>>>>>"+ customerName);
//    		 System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>"+ orgId);
    		return new ArrayList();
    	}
    }
    
    
    
    public List getCustomersByRes(final Customer customer) {
    	Map mp = new HashMap();
    	List resourceIdList = new ArrayList();
    	List userIdList = new ArrayList();
    	Integer version = customer.getVersion();
    	
    	CollectionUtils.addAll(resourceIdList,customer.getResourceIds());
    	CollectionUtils.addAll(userIdList,customer.getUserIds());
    	
    	mp.put("resourceIdList",resourceIdList);
    	mp.put("userIdList",userIdList);
    	mp.put("version",version);
    	
    	
    	getCustomerCateFiter(customer);
    	mp.put("customerCateList",customer.getCustomerCateList());
    	
    	
    	
    	
        return dao.getCustomersByRes(mp);
    }
    
    public List getCustomersByUser(final String curUserId,String type,String customerName) {
    	Map mp = getSearchWhere(curUserId,type,customerName);
        return dao.getCustomers(mp);
    }
    
    public List getCustomersAllForCommand(Customer customer) {
    	 String curUserId = customer.getAccountName();
    	 String type  = customer.getAccountBank();
    	 String customerName = StringUtil.String2kenizer(customer.getCustomerName());
    	 String orgId = StringUtil.null2String(customer.getOrgId()) ;
    	 
    	
    	 if(log.isDebugEnabled()){
    		 System.out.println("getCustomersAllForCommand orgId>>>>>>>>>>>>>>>>>>"+ orgId);
        	 System.out.println("getCustomersAllForCommand curUserId>>>>>>>>>>>>>>>>>>>>>>>>"+ curUserId);
        	 System.out.println("getCustomersAllForCommand type>>>>>>>>>>>>>>>>>>>>>>>>"+ type);
        	 System.out.println("getCustomersAllForCommand customerName>>>>>>>>>>>>>>>>>>>>>>>>"+ customerName);
    	 }

    	 
    	
    	Map mp = getSearchWhere(curUserId,type,customerName);
    	
 

    	getCustomerCateFiter(customer);
    	 
    	boolean 	catFiter = SysParamUtil.getCustomerCateFiter();
    	if(catFiter) {
    		mp.put("customerCateList",customer.getCustomerCateList());
    	}
    		
//       	if (!"0".equals(orgId)){
    		mp.put("orgId",orgId);
//    	}
       	
    	List ls = new ArrayList();
    	
    	if(customerName != null && !customerName.equals("")){
    		ls = dao.getCustomersAllForCommand(mp);
    	}else{
    		ls.add(new Customer());
    	}
        return ls;
    }
    

    /**
     * @see com.vriche.adrm.crm.service.CustomerManager#getCustomer(String id)
     */
    public Customer getCustomer(final String id) {
//    	 System.out.println(">>>>>>>>>>>111111111>>>>>>>>>>>>>");
        return dao.getCustomer(new Long(id));
    }
    public Customer getCustomerForOrderPrint(final String id){
    	 return dao.getCustomerForOrderPrint(new Long(id));
    }
    public Customer getCustomerByObject(Customer customer) {
	   	 getCustomerCateFiter(customer);

        return dao.getCustomer(customer);
    }
    
    /**
     * @see com.vriche.adrm.crm.service.CustomerManager#saveCustomer(Customer customer)
     */
    public String saveCustomerForm(Customer customer) {
    	
    	boolean useMoreCarrierSortParam = SysParamUtil.useMoreCarrierSortParam();
    	 System.out.println(">>>>>>>>>>>customer.getHelpCode()>>>>>>>>>>>>>"+ customer.getHelpCode());
    	 
    	 
    	customer.setHelpCode(buildHelpCode(customer));
    	
    	if(!useMoreCarrierSortParam) customer.setOrgId(new Long(1));
    	String customerId = dao.saveCustomer(customer).toString();
//    	String userId = UserUtil.getCurrentPrincipalUserId();
//    	saveCustomerUserRelByNewCustomer(customerId,userId);
    	customer.setId(new Long(customerId));
        return customerId;
    }
    
    public Customer saveCustomerFormReturnObj(Customer customer) { 
    	  saveCustomerForm(customer);
    	  return customer;
    }
    
    
    private String getCustomerHelpCode(String helpCode){
    	Customer customer = new Customer();
    	customer.setHelpCode(helpCode);
    	List ls = dao.getCustomers(customer);
    	if(ls.size()>0){
    		helpCode +=ls.size();
    	}
    	return helpCode;
    }
    public String saveCustomer(Long customerId,String customerName,String customerCategoryId,String ownerUserId) {
    	customerId = customerId == null? new Long(0):customerId;
		boolean isNew =  customerId.longValue() == 0?true:false;
//		boolean isNew = false;
		boolean isCutOwnerRel = SysParamUtil.getCustomerOwnerRelPara();
		

		
		String newCurstomerId = null;
		if(isNew){
			Customer ct = new Customer();
			ct.setCustomerName(customerName);
			Customer cust = dao.getCustomer(ct);
			if(cust == null){
				newCurstomerId = saveNewCustomer(customerName,customerCategoryId,ownerUserId);
			}else{
				newCurstomerId = String.valueOf(cust.getId());
			}
			
//			dao.deleteCustomerUserRelByParent(new Long(newCurstomerId));
			if(isCutOwnerRel) saveCustomerUserRelByNewCustomer(newCurstomerId,ownerUserId);
		}else{
			Customer cust = dao.getCustomer(customerId);
			String oldName = cust.getCustomerName();

			if(customerName != oldName){
				Customer ct = new Customer();
				ct.setCustomerName(customerName);
				
				Customer ctt = dao.getCustomer(ct);
				
				if(ctt != null){
					newCurstomerId = ctt.getId().toString();
//					List cutIds = dao.getCustomerIdsByUserId(new Long(ownerUserId));
//					dao.deleteCustomerUserRelByParent(new Long(newCurstomerId));
//					saveCustomerUserRelByNewCustomer(newCurstomerId,ownerUserId);
				
				}else{
					newCurstomerId = saveNewCustomer(customerName,customerCategoryId,ownerUserId);
//					dao.deleteCustomerUserRelByParent(new Long(newCurstomerId));
					if(isCutOwnerRel) saveCustomerUserRelByNewCustomer(newCurstomerId,ownerUserId);
				}
			}
			
		}

        return newCurstomerId;
    }
    
    
    private String saveNewCustomer(String customerName,String customerCategoryId,String ownerUserId){
    	
    	boolean useMoreCarrierSortParam = SysParamUtil.useMoreCarrierSortParam();
    	
    	Customer customer = new Customer();
    	
		String rep ="\n\r\t";
		customerName = StringUtil.String2kenizer(customerName,rep);
		customer.setId(null);
    	customer.setCustomerName(customerName);
		customer.setCustomerLevel(new Integer(0));
		customer.setCustomerCategoryId("2");
		customer.setParentId("0");
		customer.setCustomerTypeId(new Long(0));
		customer.setPaymentExpireDays(new Integer(0));
		customer.setDelayDateUnit(new Integer(0));
		customer.setDelayDays(new Integer(0));
		customer.setVersion(new Integer(0));
		
		customer.setHelpCode(buildHelpCode(customer));
		
    	if(!useMoreCarrierSortParam) customer.setOrgId(new Long(1));

		 return dao.saveCustomer(customer).toString();
		
    }
    
    
    private String  buildHelpCode(Customer customer){
    	
    	String customerName =  customer.getCustomerName();
    	String helpCode = "";
    	if(customer.getId() == null || "".equals(StringUtil.null2String(customer.getId()))){
    		String code = GetFirstLetter.getPinYinHeadChar(customerName);
    		helpCode = getCustomerHelpCode(code);
    	}else{
    		
    		helpCode = customer.getHelpCode();
    		if(helpCode == null || "".equals(StringUtil.null2String(helpCode))){
    			String code = GetFirstLetter.getPinYinHeadChar(customerName);
    			helpCode = getCustomerHelpCode(code);
    		}
    		
    	}
    	
//    	customer.setHelpCode(helpCode);
    	return helpCode;
    }
    /**
     * @see com.vriche.adrm.crm.service.CustomerManager#removeCustomer(String id)
     */
    public void removeCustomer(final String id) {
    	dao.deleteCustomerUserRelByParent(new Long(id));
        dao.removeCustomer(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.CustomerManager#removeCustomers(String Map)
     */
    public void removeCustomers(final Map idList) {
        dao.removeCustomers(idList);
    }
	
	public Map getCustomerSelect(Customer customer) {
		int display = 1;
		List ls = new ArrayList();
		
		

		
		if(display == 0){
			ls = this.getCustomers(customer);
		}else{
		    String curUserId = UserUtil.getCurUserId();
			Map mp = getSearchWhere(curUserId,null,null);
			ls = dao.getCustomers(mp);
		}

	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	Customer customers = new Customer();
	    	customers = (Customer) it.next();
	    	
	    	reply.put("0","");
	    	reply.put(customers.getId(),customers.getCustomerName());
	    }
		return reply;
	}
	
	
	 private Map getSearchWhere(String curUserId,String categoryId,String customerName){
		 
		 Map mp = new HashMap();
	   
	    boolean isCustomerOwner = SysParamUtil.getCustomerOwnerRelPara();
//	    System.out.println(">>>>>>>>>>>111111111>>>>>>>>>>>>>");
	   
	    if(isCustomerOwner){
	         List customerIds = dao.getCustomerIdsByUserId(new Long(curUserId));
	         
			 if(customerIds.size() == 0) customerIds.add(new Long(0));
			 mp.put("CustomerIdList",customerIds);
	    }
	    if(!"0".equals(categoryId) && categoryId != null && !categoryId.equals("")) mp.put("CustomerCategoryId",categoryId);
	    if(!"".equals(customerName) && customerName != null) mp.put("customerName",customerName);
//	    System.out.println(">>>>>>>>>>>222222222>>>>>>>>>>>>>");
		 return mp;
	 }
	 



	 public Object[] getCustomerUserRel(String customerId) {

			List list = dao.getCustomerUserRel(new Long(customerId));
			Object[] ids = ConvertUtil.convertFromListToArray(list);
			
			// TODO Auto-generated method stub
			return ids;
		}


	public void saveCustomerUserRel(String customerId, String[] userId) {
			// TODO Auto-generated method stub
			Map mp = new HashMap();
			
			dao.deleteCustomerUserRelByParent(new Long(customerId));
			
			for(int i=0; i< userId.length;i++){
				mp.put("customerId",customerId);
				mp.put("userId",new Long(userId[i]));
				dao.saveCustomerUserRel(mp);		
			}
		}
	public void saveUserCustomerRel(String userId, String[] customerId) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		
		userDao.deleteCustomerUserRel(new Long(userId));
		
		for(int i=0; i< customerId.length;i++){
			mp.put("userId",userId);
			mp.put("customerId",new Long(customerId[i]));
			dao.saveCustomerUserRel(mp);		
		}
	}
	 
	public void saveCustomerUserRelByNewCustomer(String customerId, String userId) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		
//		dao.deleteCustomerUserRelByParent(new Long(customerId));
		
//		for(int i=0; i< userId.length;i++){
			mp.put("customerId",customerId);
			mp.put("userId",new Long(userId));
			dao.saveCustomerUserRel(mp);		
//		}
	}
	 
	public String getCustomersXML(Customer customer, String IdPrefix) {
		
//		System.out.println("customer=="+customer);
		
		StringBuffer sb = new StringBuffer("");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<tree id=\"0\">");
		sb.append("<item text=\"客户信息\" id=\"root\" open=\"1\" im0=\"books_close.gif\" im1=\"tombs.gif\" im2=\"tombs.gif\" call=\"1\" select=\"1\">");
		sb.append("<userdata name=\"id\">0</userdata>");
		sb.append("<userdata name=\"type\">0</userdata>");
//		getCustomersIdsByParent(customer.getParentId(),customer.getCustomerCategoryId(),sb,IdPrefix);
		getCustomers(customer,sb,IdPrefix);
		sb.append("</item>");
		sb.append("</tree>");
//		System.out.println("getCustomersXML:>>>>>>>>>>" + sb.toString());
		return sb.toString();
	} 
	
	

	private void getCustomers(Customer customer, StringBuffer sb,String IdPrefix) {
		boolean isRes = false;
		if(customer.getResourceIds() != null){
			isRes = customer.getResourceIds().length>0;
		}
		
		
		
		
		   List ls = new ArrayList();
		   
		   if(isRes){
			   ls = this.getCustomersByRes(customer);
		   }else{
			   ls = this.getCustomers(customer);
		   }
			
		Iterator it = ls.iterator();
		
		while (it.hasNext()) {
			Customer cus = (Customer) it.next();

			sb.append("<item id='" +IdPrefix
							+ cus.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ cus.getCustomerName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + cus.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			sb.append("</item>");

		}
	}
	
	public void getCustomersIdsByCategory(String categoryId, StringBuffer sb,String IdPrefix) {
		Customer customers = new Customer();
		customers.setCustomerCategoryId(categoryId);
		Iterator it = this.getCustomers(customers).iterator();
		while (it.hasNext()) {
			Customer cus = (Customer) it.next();

			sb.append("<item id='" +IdPrefix
							+ cus.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ cus.getCustomerName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + cus.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			sb.append("</item>");

		}
	}

	public void getCustomersIdsByCategory(String orgId,String categoryId, StringBuffer sb,String IdPrefix) {
		Customer customers = new Customer();
		customers.setCustomerCategoryId(categoryId);
		customers.setOrgId(new Long(orgId));
		Iterator it = this.getCustomers(customers).iterator();
		while (it.hasNext()) {
			Customer cus = (Customer) it.next();

			sb.append("<item id='" +IdPrefix
							+ cus.getId().toString()
							+ "' im0=\"book.gif\" im1=\"books_open.gif\" im2=\"book.gif\" text=\""
							+ cus.getCustomerName().toString() + "\">");
			sb.append("<userdata name=\"id\">" + cus.getId().toString()
					+ "</userdata>");
			sb.append("<userdata name=\"type\">2</userdata>");
			sb.append("</item>");

		}
	}
	public void saveCustomerUnify(Customer custome) {
		String sourceId = custome.getId().toString();
		String[] targIds = custome.getHelpCode().split(",");
		List ls = new ArrayList();
		CollectionUtils.addAll(ls,targIds);
		if(ls.size()>0){
			Map mp = new HashMap();
			mp.put("source",sourceId);
			mp.put("targ",ls);
			dao.saveCustomerUnify(mp);
		}
	}
	public String getParentCustomersXML(Customer custome) {
			
		 StringBuffer sb = new StringBuffer();
		    List ls = dao.getCustomers(custome);
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<complete>");   
			
			for(Iterator it = ls.iterator();it.hasNext();){
				Customer obj = (Customer)it.next();
				sb.append("<option  value=\""+ obj.getId()  +"\"" +">");
				sb.append("<![CDATA["+ obj.getCustomerName() +"]]>");
				sb.append("</option>");
			}
			sb.append("</complete>");
			return sb.toString();
	}
	public String saveCustomerCarrierRel(CustomerCarrierRel carrierRel){
		 return dao.saveCustomerCarrierRel(carrierRel).toString();		
  }
   public void removeCustomerCarrierRel(Long id){
		 dao.removeCustomerCarrierRel(id);		
  }
   public List getCustomerCarrierRels(final CustomerCarrierRel carrierRel) {
   	return dao.getCustomerCarrierRels(carrierRel);
   }
   /**
    * @see com.vriche.adrm.service.CustomerManager#getCarrierXML(com.vriche.adrm.model.CustomerCarrierRel)
    */
   public List getCarrierXML(final CustomerCarrierRel carrierRel) {
   	List carrierls=new ArrayList();
   	List carrs = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
   	List ls=dao.getCustomerCarrierRel(carrierRel);
   	String carrierId="";
		for(Iterator it=ls.iterator();it.hasNext();){
			CustomerCarrierRel obj=(CustomerCarrierRel)it.next();
			
			if(!carrierId.equals(obj.getCarrierId().toString())){
				carrierId=obj.getCarrierId().toString();
			
				for(Iterator its=carrs.iterator();its.hasNext();){
					Carrier carrier=(Carrier)its.next();
					if(carrier.getId().equals(obj.getCustomerId())){
						obj.setCarrierName(carrier.getCarrierName()+" || "+obj.getCarrierName());
						carrierls.add(obj);
					}
			}
			}
		}
       return carrierls;
   }
	public String getCustomerCarrierRelPageXML(CustomerCarrierRel carrierRel,String pageIndex, String pageSize) {
			int i=1;
		    StringBuffer sb = new StringBuffer();
			List ls=dao.getCustomerCarrierRelPage(carrierRel,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
			for(Iterator it = ls.iterator();it.hasNext();){
				CustomerCarrierRel obj = (CustomerCarrierRel)it.next();
				
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell>"+ i++ +"</cell>");
				sb.append("<cell>"+obj.getCarrierId()+"</cell>");
				sb.append("<cell>"+obj.getResourceId()+"</cell>");
				sb.append("<cell><![CDATA["+ obj.getLength()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(obj.getStartDate().toString(),"yyyy/MM/dd") +"]]></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(obj.getEndDate().toString(),"yyyy/MM/dd")  +"]]></cell>");
				sb.append("</row>");
			}
			sb.append("</rows>");	
			return sb.toString();
	}

	public String getCustomerCarrierRelCountAll(final CustomerCarrierRel carrierRel){
		
		return dao.getCustomerCarrierRelCountAll(carrierRel).toString();	
	}
	
	public String getOrderDetailCountAll(final CustomerCarrierRel carrierRel){
		
		List ls=dao.getCarrierPageXML(carrierRel);
		return new Integer(ls.size()).toString();
	}
	
	public List getCustomerCarrierRelCount(final CustomerCarrierRel carrierRel){	
		return dao.getCustomerCarrierRelCount(carrierRel);
	}
	
	public Map getCustomerSelectFromMap(Customer customer) {
		log.info("getCustomerSelectFromMap>>>>>>>>>getOrgId>>>>>>>>>>>>>>>>"+customer.getOrgId());
		return buildMapByList(this.getCustomers(customer));
	}
	
	

	
	 public String getCustomerCarrierRelXML(final CustomerCarrierRel carrierRel){
		 StringBuffer sb = new StringBuffer();
		 //Map matterId=new HashMap();
		 Map resourceId = new HashMap();
		 List matterIdLs = new ArrayList();
		 List carrierIdLs = new ArrayList();
		 Matter matter = new Matter();

		 List orderDetails=dao.getOrderDetails(carrierRel);
		 for(Iterator it=orderDetails.iterator();it.hasNext();){
			 CustomerCarrierRel obj=(CustomerCarrierRel)it.next();
			// matterId.put(obj.getId(),obj.getMemo());
			 resourceId.put(obj.getId().toString()+obj.getResourceId().toString(),obj.getMemo());
			 matterIdLs.add(obj.getId());
			 carrierIdLs.add(obj.getCarrierId());
		 }
		 List resourse = dao.getCustomerCarrierRels(carrierRel);
		 
		 matter.setCustomerId(carrierRel.getCustomerId());
		 List ls = matterManager.getMatters(matter);
		 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		 sb.append("<rows>");
		 for(Iterator it = ls.iterator();it.hasNext();){
			 Matter obj = (Matter)it.next();
			 	if(!matterIdLs.contains(obj.getId())||!carrierIdLs.contains(carrierRel.getCarrierId())) continue;
			 	
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell>"+obj.getName()+"</cell>");
				sb.append("<cell>"+obj.getEdit()+"</cell>");
				sb.append("<cell><![CDATA["+ obj.getLength()  +"]]></cell>");
				for(Iterator its=resourse.iterator();its.hasNext();){
					 CustomerCarrierRel objs=(CustomerCarrierRel)its.next();
					 if(resourceId.containsKey(obj.getId().toString()+objs.getResourceId().toString())){
						 sb.append("<cell><![CDATA["+ resourceId.get(obj.getId().toString()+objs.getResourceId().toString()) +"]]></cell>");
					 }else{
						 sb.append("<cell><![CDATA["+ "" +"]]></cell>");
					 }
				}				 
				sb.append("<cell><![CDATA["+ "" +"]]></cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("</row>");
		 }
		 sb.append("</rows>");
		 return sb.toString();
	 }
	 
	 
	 
	 public String getCarrierPageXML(final CustomerCarrierRel carrierRel,String pageIndex, String pageSize){
		 StringBuffer sb = new StringBuffer();
		 List ls=dao.getCarrierPageXMLs(carrierRel,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		 int i=0;
		 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		 sb.append("<rows>");   
		 for(Iterator it = ls.iterator();it.hasNext();){
			 CustomerCarrierRel obj = (CustomerCarrierRel)it.next();
			 Double incomeMoney=dao.getIncomeUsedByOrderId(obj.getId().toString());
			 	String checkState=obj.getMemo()==null?"":obj.getMemo();
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell>"+ (Integer.parseInt(pageSize)*Integer.parseInt(pageIndex)+(++i))+ "</cell>");
				sb.append("<cell>"+DateUtil.SetDateFormat(obj.getStartDate().toString(),"yyyy/MM/dd")+"</cell>");
				sb.append("<cell>"+StringUtil.doubleFormat2(obj.getPayMoney())+"</cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(incomeMoney)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(obj.getLength()) +"]]></cell>");
				sb.append("<cell><![CDATA["+ checkState  +"]]></cell>");
				sb.append("</row>");
		 }
		 sb.append("</rows>");
		 return sb.toString();
	 }
	 
	 
	 public String  getCustomerForReg(Customer customer){
		 StringBuffer sb = new StringBuffer();
		 System.out.println(">>>>>>>> customer:"+customer);
//		 List ls = dao.getCustomersAnalyze(customer);
		 List ls = dao.getCustomers(customer);
 
		 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		 sb.append("<rows>");   
		 for(Iterator it = ls.iterator();it.hasNext();){

			 	Customer obj = (Customer)it.next();
			 	
				sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
				sb.append("<cell><![CDATA["+ obj.getCustomerName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ obj.getCategory().getCategoryName()  +"]]></cell>");
				sb.append("<userdata name=\"customerCategoryId\">"+ obj.getCustomerCategoryId() +"</userdata>");
				sb.append("<userdata name=\"customerName\">"+ obj.getCustomerName() +"</userdata>");
				sb.append("</row>");
		 }
		 sb.append("</rows>");
		 return sb.toString();
	 }
	 
	 
	 public List getDetailsByOrderId(final CustomerCarrierRel carrierRel){
		 
		 return dao.getCarrierPageXML(carrierRel);
	 }
	 public List getCustomerIdByUserId(final String curUserId){
		 
		 return dao.getCustomerIdsByUserId(new Long(curUserId));
	 }
	 
	private Map buildMapByList(List customerList){
		    Map reply = new LinkedHashMap();
		    Iterator it = customerList.iterator();
	    	reply.put("0","");
	    	
		    while(it.hasNext()){
		    	Customer cus =(Customer)it.next();
		    	
		    	reply.put(cus.getId(),cus.getCustomerName());
		    }
			return reply;
		}
	public List getCustomersFromOrder(Customer customer) {
		String loginUser = customer.getAccountName();
		String userId =customer.getAccountBank();
		String customerName =customer.getCustomerName();
		
		Map mp = new HashMap();
		List userIdList = new ArrayList();
		userIdList = UserUtil.getCurUserRels(loginUser);
//		System.out.println(">>>>>>>> userIdList size:"+userIdList.size());
//		System.out.println(">>>>>>>> loginUser:"+loginUser);
//		System.out.println(">>>>>>>> userId:"+userId);
//		System.out.println(">>>>>>>> customerName:"+customerName);
		
		if(customerName != null){
			String code = GetFirstLetter.getPinYinHeadChar(customerName);
//			System.out.println(">>>>>>>> code:"+code);
			
			if(code.toLowerCase().equals(customerName.toLowerCase())){
				mp.put("helpCode",customerName);
			}
		}

		
		if(userIdList.size() == 0){
			userIdList.add("-1");
		}
		mp.put("userIdList",userIdList);
		
		userId = StringUtil.null2String(userId);
		
		if(!userId.equals("")&& !userId.equals("0")){
			mp.put("userId",userId);
		}
		
		if(customerName != null){
			if(!customerName.equals("")) mp.put("customerName",customerName);
		}
		
		//订单中归属自己的客户
		return dao.getCustomersFromOrder(mp);
	}
	
	public Map getCustomersMapFromOrder(Customer customer) {
		return buildMapByList(this.getCustomersFromOrder(customer));
	}
	
	
	
	

	
	
	public List getTreeForJosin(TreeNode node,Customer cust){
		List trees = new ArrayList();

		
		Long orgId = cust.getOrgId();
		String parentNodeId = node.getRealId();
		
		if(log.isDebugEnabled()){
			log.info("getTreeForJosin getCustomerCateByUserObj parentId>>>>>>>>>>>>>>>"+node.getNodeId());
			log.info("getTreeForJosin getCustomerCateByUserObj getNodeType>>>>>>>>>>>>>>>"+node.getNodeType());
			log.info("getTreeForJosin getCustomerCateByUserObj getNodelevel>>>>>>>>>>>>>>>"+node.getNodelevel());
			log.info("getTreeForJosin getCustomerCateByUserObj getOrgId>>>>>>>>>>>>>>>"+cust.getOrgId());
			log.info("getTreeForJosin getCustomerCateByUserObj getCustomerTypeId>>>>>>>>>>>>>>>"+cust.getCustomerTypeId());
		}
		
		
		if("0".equals(node.getNodelevel())){
			  List ls = UserUtil.getCustomerCateByUserObj(null);
			   for(Iterator it = ls.iterator();it.hasNext();){
				   Category cat  = (Category) it.next();
				   if(cat.getId().longValue()>1){
					    Map map = new HashMap();
						map.put("id","category_"+cat.getId().toString());
						map.put("realId",cat.getId().toString());
						map.put("text", cat.getCategoryName());
//						map.put("type",node.getNodeType());
						map.put("type","1");
						map.put("level","1");
//						map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
//						map.put("iconCls","x-tree-node-icon");

						Customer customer = new Customer();
						customer.setCustomerCategoryId(cat.getId().toString());
						customer.setOrgId(orgId);
						List ls2 = dao.getCustomers(customer);
						boolean isLeaf = (ls2.size() == 0);
						map.put("leaf", Boolean.valueOf(isLeaf));	
//						map.put("checked", Boolean.valueOf(false));	
						 
						trees.add(map);
				   }
			   }	
		}else{
			
			Customer customer = new Customer();
			customer.setCustomerCategoryId(parentNodeId);
			customer.setOrgId(orgId);
			customer.setCustomerTypeId(cust.getCustomerTypeId());
			List ls2 = dao.getCustomers(customer);
			

			
			for(Iterator it2 = ls2.iterator();it2.hasNext();){
					Map map = new HashMap();
					Customer obj = (Customer)it2.next();
					map.put("id",obj.getId().toString());
					map.put("text", obj.getCustomerName());
					map.put("leaf", Boolean.valueOf(true));
//					map.put("type",node.getNodeType());
					map.put("type","2");
					map.put("level","2");
//					map.put("uiProvider","Ext.tree.TreeCheckNodeUI");
//					map.put("checked", Boolean.valueOf(false));	
					trees.add(map);
			}
			
		}
		
		
		return trees;
	}
	
	
	
	
	public List getTreeForJosin2(TreeNode node,Customer cust){
		
		List trees = new ArrayList();
		List ls = UserUtil.getCustomerCateByUserObj(null);
		
		Long orgId = cust.getOrgId();
		String parentNodeId = node.getRealId();
		
		if(log.isDebugEnabled()){
			log.info("getTreeForJosin getCustomerCateByUserObj ls>>>>>>>>>>>>>>>"+ls.size());
			log.info("getTreeForJosin getCustomerCateByUserObj parentId>>>>>>>>>>>>>>>"+node.getNodeId());
			log.info("getTreeForJosin getCustomerCateByUserObj getOrgId>>>>>>>>>>>>>>>"+cust.getOrgId());
			log.info("getTreeForJosin getCustomerCateByUserObj getCustomerTypeId>>>>>>>>>>>>>>>"+cust.getCustomerTypeId());
		}
				
		
		   for(Iterator it = ls.iterator();it.hasNext();){
			   Category cat  = (Category) it.next();
			   Map map = new HashMap();
			   if(cat.getId().longValue()>1){
					map.put("id","category_"+cat.getId().toString());
					map.put("realId",cat.getId().toString());
					map.put("text", cat.getCategoryName());
					map.put("type","1");
					
					if(log.isDebugEnabled()){
						log.info("getTreeForJosin getCustomerCateByUserObj text>>>>>>>>>>>>>>>"+cat.getCategoryName());
					}			
					
					Customer customer = new Customer();
					customer.setCustomerCategoryId(cat.getId().toString());
					customer.setOrgId(orgId);
					customer.setCustomerTypeId(cust.getCustomerTypeId());
					
					List ls2 = dao.getCustomers(customer);
					
					boolean isLeaf = (ls2.size() == 0);
					
					if(!isLeaf){
						List trees2 = new ArrayList();
						for(Iterator it2 = ls2.iterator();it2.hasNext();){
							Map map2 = new HashMap();
							Customer obj = (Customer)it2.next();
							map2.put("id",obj.getId().toString());
							map2.put("text", obj.getCustomerName());
							map2.put("leaf", Boolean.valueOf(true));
							map2.put("type","2");
							trees2.add(map2);
						}
						map.put("children",trees2);	
					}
					
					map.put("leaf", Boolean.valueOf(isLeaf));	
					
					trees.add(map);
			   }
			   
			 
			   
		   }	

		return trees;
	}
	
	
	 public List getCustFromOrder(Map mp) {
		 boolean 	catFiter = SysParamUtil.getCustomerCateFiter();
		  String loginUser = StringUtil.getNullValue(mp.get("loginUser"),"");
		  String userId = StringUtil.getNullValue(mp.get("userId"),"");
		  String customerId = StringUtil.getNullValue(mp.get("customerId"),"");
		  String customerName = StringUtil.getNullValue(mp.get("customerName"),"");
		  String version = StringUtil.getNullValue(mp.get("version"),"");
		  String orgId = StringUtil.getNullValue(mp.get("orgId"),"");

		  
		  
		  
			if(log.isDebugEnabled()){
				log.info("getCustFromOrder>>>>>>>>>orgId>>>>>>"+orgId);
				log.info("getCustFromOrder>>>>>>>>>version>>>>>>"+version);
				log.info("getCustFromOrder>>>>>>>>>loginUser>>>>>>"+loginUser);
				log.info("getCustFromOrder>>>>>>>>>userId>>>>>>"+userId);
				log.info("getCustFromOrder>>>>>>>>>>customerId>>>>>"+customerId);
				log.info("getCustFromOrder>>>>>>>>>>>customerName>>>>"+customerName);
			}		  
		  
		  
		  if(!"userId".equals(customerId) && !"0".equals(customerId) && !"null".equals(customerId)){
			  List customerIdList = new ArrayList(); 
			  if(userId.indexOf(",")>-1) {
				  CollectionUtils.addAll(customerIdList,userId.split(","));
			  }else{
				  customerIdList.add(userId);
			  }
		  }
		  
		  
		  
		  if(catFiter){
			  Customer customer = new Customer();
			  customer.setLoginUser(loginUser);
			  this.getCustomerCateFiter(customer);
			  List cutCateList = customer.getCustomerCateList();
			  
//				log.info("getCustFromOrder>>>>666666666666666666666666666666666666666666666666>>>>>>>cutCateList>>>>"+cutCateList);
			  
			  if(cutCateList == null) cutCateList.add("-1");
			  mp.put("customerCateList",cutCateList);
		  }

		  
		  List userIdList = new ArrayList(); 
		  if(!"userId".equals(userId) && !"0".equals(userId) && !"null".equals(userId)){
			  if(userId.indexOf(",")>-1) {
				  CollectionUtils.addAll(userIdList,userId.split(","));
			  }else{
				  userIdList.add(userId);
			  }
		  }else{
			  userIdList = UserUtil.getCurUserRels(loginUser);
			  if(userIdList.isEmpty()) userIdList.add("-1");
		  }
		
	     	if(UserUtil.isUserOrderYearRel()) {
	     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
	     	}
	     	
	     	mp.put("version",version);	
	     	
		  
		 return dao.getCustFromOrder(mp);
	 }
	 
	 
//		model 1- tb_order  2 tb_income 3 tb_contract_payment 4 tb_contract
	 public List getCustomerRemote(Customer customer){
		 Map map = new HashMap();
		 String loginUser = customer.getLoginUser();

			
		 List catCates = UserUtil.getCustomerCateByUser(loginUser,null);
		 
			if(log.isDebugEnabled()){
				log.info("getCustFromOrder>>>>>>>>>loginUser>>>>>>"+loginUser);
				 log.info("getCustFromOrder>>>>>>>>>catCates>>>>>>"+catCates);
				 log.info("getCustFromOrder>>>>>>>>>getVersion>>>>>>"+customer.getVersion());
				 log.info("getCustFromOrder>>>>>>>>>getCustomerName>>>>>>"+customer.getCustomerName());
				 log.info("getCustFromOrder>>>>>>>>>getOrgId>>>>>>"+customer.getOrgId());
			}	
		 
	

		 map.put("model",customer.getModel());
		 map.put("version",customer.getVersion());
		 map.put("orgId",customer.getOrgId());
		 map.put("customerCates",catCates);
		 map.put("customerName",customer.getCustomerName());
	
		 return  dao.getCustomerRemote(map);
	 }
	
}