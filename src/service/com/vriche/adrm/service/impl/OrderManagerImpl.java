
package com.vriche.adrm.service.impl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.OrderColl;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.OrderLog;
import com.vriche.adrm.model.OrderPublic;
import com.vriche.adrm.model.RequestObject;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.OaWorkFlowManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderDetailUnableSaveException;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.SysSequenceManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.OrderDayInfoUtil;
import com.vriche.adrm.util.OrderDayUtil;
import com.vriche.adrm.util.OrderLogUtil;
import com.vriche.adrm.util.RequestUtil;
import com.vriche.adrm.util.ResourceUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class OrderManagerImpl extends BaseManager implements OrderManager {
    private OrderDao dao;
    
    private OaWorkFlowManager oaWorkFlowManager;
//    private CustomerDao customerDao;
    private CustomerManager customerManager;
    private ContractPaymentDao contractPaymentDao;
    private SysSequenceManager sysSequenceManager;
    private ContractPaymentManager contractPaymentManager;
    private CarrierManager carrierManager;
    private UserManager userManager;
    private OrderDetailDao orderDetailDao;
    private OrderDayInfoDao orderDayInfoDao;

	public void setContractPaymentDao(ContractPaymentDao contractPaymentDao) {
		this.contractPaymentDao = contractPaymentDao;
	}
//	public void setCustomerDao(CustomerDao customerDao) {
//		this.customerDao = customerDao;
//	}
	
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOrderDao(OrderDao dao) {
        this.dao = dao;
    }
    
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}
	public void setOrderDayInfoDao(OrderDayInfoDao orderDayInfoDao) {
		this.orderDayInfoDao = orderDayInfoDao;
	}

	public void setOaWorkFlowManager(OaWorkFlowManager oaWorkFlowManager) {
		this.oaWorkFlowManager = oaWorkFlowManager;
	}   
	
	public void setSysSequenceManager(SysSequenceManager sysSequenceManager) {
		this.sysSequenceManager = sysSequenceManager;
	}
	
	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
		
	
	public void setContractPaymentManager(
			ContractPaymentManager contractPaymentManager) {
		this.contractPaymentManager = contractPaymentManager;
	}	
	
	/**
	 * @param userManager The userManager to set.
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
		
	
	
	
    public List getOrdersByIdList(final Map idList,String pageIndex, String pageSize){
    	 return dao.getOrdersByIdList(idList,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
    }
    /**
     * @see com.vriche.adrm.order.service.OrderManager#getOrdersByIdList(final Map idList)
     */
    public List getOrdersByIdList(final Map idList) {
        return dao.getOrdersByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.order.service.OrderManager#getOrders(com.vriche.adrm.order.model.Order)
     */
    public List getOrders(final Order order) {

        return dao.getOrders(order);
    }
    
	public String getOrdersPageByUsersCount(Order order) {
    	Map mp = new HashMap();
    	getSearchWhere(mp,order);
    	
//		StringUtilsv.printMap(mp);
		
//    	List ls = dao.getOrdersPageByUsersCount(mp);
    	return dao.getOrdersPageByUsersCount(mp).toString();
//		return dao.getOrdersPageByUsersCount(mp).toString();
	}
	
	public List getOrdersPageByUsersCount2(Order order,int pageIndex,int pageSize) {
    	Map mp = new HashMap();
    	getSearchWhere(mp,order);
 
    	StringUtilsv.printMap(mp);
    	
    	List ls = dao.getOrdersPageByUsersCount2(mp);
    	int resultSize = ls.size();

	    int lastPage = resultSize/pageSize+1;
	    boolean isLastSumPage = (lastPage == pageIndex+1);   	

//	    System.out.println("String.valueOf(resultSize/pageSize)>>>>>>>>>>>>>>>>>>>>> "+String.valueOf(resultSize/pageSize));
//	    System.out.println("StringUtil.isDouble(String.valueOf(size))>>>>>>>>>>>>>>>>>>>>> "+StringUtil.isDouble(String.valueOf(resultSize/pageSize)));
//	    System.out.println("StringUtil.isInteger(String.valueOf(size))>>>>>>>>>>>>>>>>>>>>> "+StringUtil.isInteger(String.valueOf(resultSize/pageSize)));
//    	System.out.println("resultSize>>>>>>>>>>>>>>>>>>>>> "+resultSize);
//    	System.out.println("pageIndex>>>>>>>>>>>>>>>>>>>>>> "+pageIndex);
//    	System.out.println("pageSize>>>>>>>>>>>>>>>>>>>>>> "+pageSize);
//    	System.out.println("lastPage>>>>>>>>>>>>>>>>>>>>>> "+lastPage);
//    	System.out.println("isLastSumPage>>>>>>>>>>>>>>>>>>>>>> "+isLastSumPage);
	    
    	
    	if(resultSize>0 && isLastSumPage){
    		
	    	double moneyRealpay = 0;
	    	double moneyIn = 0;
//	    	int size = 0;
	    	for(Iterator it = ls.iterator();it.hasNext();){
	    		Order odr = (Order)it.next();
//	    		size = odr.getId().intValue();
	    		moneyRealpay+=StringUtilsv.getDoubleValue(""+odr.getOrderPublic().getMoneyRealpay());
	    		moneyIn+=StringUtilsv.getDoubleValue(""+odr.getOrderPublic().getMoneyIn());
	    		
	    	}
//    	System.out.println("moneyRealpay>>>>>>>>>>>>>>>>>>>>> "+moneyRealpay);
//    	System.out.println("moneyIn>>>>>>>>>>>>>>>>>>>>>> "+moneyIn);
//    	System.out.println("size>>>>>>>>>>>>>>>>>>>>>> "+size);

        	Order o = new Order();
        	o.getOrderPublic().setMoneyRealpay(new Double(moneyRealpay));
        	o.getOrderPublic().setMoneyIn(new Double(moneyIn));
        	o.getOrderPublic().setMatterName("合计:"+ resultSize +"条");
        	o.setOrderCode("");
        	o.getUser().setFullName("");
        	ls.add(o);
    	}

    	
    	return ls;
//		return dao.getOrdersPageByUsersCount(mp).toString();
	}
	
	
	
	
    public List getOrdersPageByUsers(Order order, String pageIndex,String pageSize) {
    	
    	Map mp = new HashMap();

    	getSearchWhere(mp,order);
    	

    	int skip = Integer.parseInt(pageIndex) * Integer.parseInt(pageSize);
    	List ls = dao.getOrdersPageByUsers(mp,skip,Integer.parseInt(pageSize));
    	
    	return ls;
    }
    public List getOrdersPageByUserSum(boolean isLastSumPage,Order order, String pageIndex,String pageSize){
    	
    	Map mp = new HashMap();
    
    	getSearchWhere(mp,order);
    	
//    	StringUtilsv.printMap(mp);
    	
//    	Integer.parseInt(pageSize);

    	int skip = Integer.parseInt(pageIndex) * Integer.parseInt(pageSize);
    	List ls = dao.getOrdersPageByUsers(mp,skip,Integer.parseInt(pageSize));
    	
//    	System.out.println("skip*************************** "+skip);
//    	System.out.println("pageSize*************************** "+pageSize);
    	
    	
//    	System.out.println("contractCode>>>>>>>>>>222222222222>>>>>>>  " + mp.get("contractCode"));
    	
    	if(isLastSumPage){
    		List list = dao.getOrdersPageByUserSum(mp);
//        	System.out.println("list.size>>>>>>>>>>>>>>>>>>>  "+list.size());
        	double moneyRealpay = 0;
        	double moneyIn = 0;
  
        	for(Iterator it = list.iterator();it.hasNext();){
        		Order odr = (Order)it.next();
        		moneyRealpay += odr.getOrderPublic().getMoneyRealpay().doubleValue();
        		moneyIn+=odr.getOrderPublic().getMoneyIn().doubleValue();
        		
        	}
//        	System.out.println("moneyRealpay>>>>>>>>>>>>>>>>>>>>> "+moneyRealpay);
//        	System.out.println("moneyIn>>>>>>>>>>>>>>>>>>>>>> "+moneyIn);
//        	System.out.println("size>>>>>>>>>>>>>>>>>>>>>> "+size);
        	Order o = new Order();
        	o.getOrderPublic().setMoneyRealpay(new Double(moneyRealpay));
        	o.getOrderPublic().setMoneyIn(new Double(moneyIn));
        	o.getOrderPublic().setMatterName("合计:"+ list.size() +"条");
        	o.setOrderCode("");
        	o.getUser().setFullName("");
        	ls.add(o);
    	}
    	 
    	return ls;
    }
    
    
    public Collection getOrdersPageByDayScroll(boolean isAllPage,Order order, int skip,int pageSize){
    	
  

    	Map mp = new HashMap();
    
    	getSearchWhere(mp,order);
    	
    	 List ls = dao.getOrdersPageByUsers(mp,skip,pageSize);
    	
//    	StringUtilsv.printMap(mp);
    	boolean isDayRealPlay = Boolean.valueOf(order.getIsDayRealPlay()).booleanValue();
    	
//    	System.out.println("isDayRealPlay>>>>>>>>>>>>>>>>1111>>>>>> "+isDayRealPlay);
    	
        if(isDayRealPlay){
        	 List orderIdList = new ArrayList();
        	 CollectionUtils.addAll(orderIdList,ConvertUtil.getColFromList(ls,"id"));
       
        	 
        	 if(orderIdList.size()>0){
        		 mp.put("OrderIdList",orderIdList);
        		 
//        		 System.out.println("isDayRealPlay>>>>>>>>222222222>>>>>>>>>>>>>> ");
        		 
        		 Map mp2 = dao.getOrdersPageByUsersForRelPayInDate(mp);
        		 
        	
        		 
//        			System.out.println("mp2>>>>>>>>>>>3333333333>>>>>>>>>>> "+mp2.size());
        		 
        		 for(Iterator it = ls.iterator();it.hasNext();){
        			 Order odr = (Order)it.next();
        			 
        			 Long id = odr.getId();
        			 if(mp2.containsKey(id)){
//        				 System.out.println("odr.getId>>>>>>>>>>>>>>>>>>>>>> "+odr.getId());
        				 Order odr2 = (Order)mp2.get(id);
        				 Double moneyRealpay =odr2.getOrderPublic().getMoneyRealpay();
        				 odr.getOrderPublic().setPublishStartDate(odr2.getOrderPublic().getPublishStartDate());
        				 odr.getOrderPublic().setPublishEndDate(odr2.getOrderPublic().getPublishEndDate());
        				 odr.getOrderPublic().setMoneyRealpay(moneyRealpay);
        			 }
        		 }
        	 }

        }
        
        return ls;
    }
    
    
    
    public Order buildParamBy(String strQueryString){
    	
    	    Order order = new Order();
		  
//		    System.out.println("buildParamBy>>>>>>>>>>>>strQueryString>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + strQueryString);

//		    Map mp = StringUtil.getQueryString2Map(request.getQueryString());
		    
//		    String kk = StringUtil.getParamFromUrl(strQueryString,"customerName");
//		    System.out.println("buildParamBy>>>>>>>>>>>>getEncoding>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + kk);

		    
	        String customerName =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"customerName"),null));
	        String matterName =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"matterName"),null));
	        String orderCode = StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"orderCode"),null);
	        String contractCode =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"contractCode"),null);
	        String relationCode = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"relationCode"),null));
	        
	        
	        String start_date = StringUtil.getParamFromUrl(strQueryString,"publishStartDate");
	        String end_date =  StringUtil.getParamFromUrl(strQueryString,"publishEndDate");
	        
//	        System.out.println("customerName<<<<<<<<!2222ttttttttttttttttttt2222222<<<<<<<<<<<<"+customerName);
	        
//	        String start_date = order.getOrderPublic().getPublishStartDate();
//	        String end_date = order.getOrderPublic().getPublishEndDate();
	 
	       
	      

	        DateUtil dateUtil = new DateUtil();
	        String y =  dateUtil.getServiceDate().substring(0,4);
	        start_date = start_date == null|| "".equals(start_date)?y+"0101":start_date;
	        end_date = end_date == null||"".equals(end_date)?y+"1231":end_date;
	        
//	        start_date = start_date.equals("")?"0":start_date;
//	        end_date = end_date.equals("")?"0":end_date;
	        
	        Integer startDate = new Integer(start_date);
	        Integer endDate = new Integer(end_date);
	        
	        

	        

	        
	        String category =    StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"categoryId"));
	        String matterId =  StringUtil.getParamFromUrl(strQueryString,"matterId");
	        String carrIds =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"carrIds"));
//	        System.out.println("carrIds<<<<<<<kkkk ttt  bbb  2222<<<<<<<<<<<<"+StringUtil.getURLDecoderStr(carrIds));  
	        String orderStates =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"orderStates"));
	        String userId =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"userId"));
	        String createBy = StringUtil.getParamFromUrl(strQueryString,"createBy");
	        String cutCates =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"cutCates"));
	        String carrierType =  StringUtil.getParamFromUrl(strQueryString,"carrierType");
	        String orgId =  StringUtil.getParamFromUrl(strQueryString,"orgId");
	        String loginUser =    StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"loginUser"));
	        String orderMeno =   StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"orderMeno")); 
	        String version = StringUtil.getNullValue(StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"version")),"0");
	        String isDayRealPlay =  StringUtil.getParamFromUrl(strQueryString,"isDayRealPlay");
	        String orderRelPay =  StringUtil.getParamFromUrl(strQueryString,"orderRelPay");
	        
	
	        String orderRate1 =  StringUtil.getParamFromUrl(strQueryString,"orderRate1");
	        String orderRate2 =  StringUtil.getParamFromUrl(strQueryString,"orderRate2");
	        String customerId =  StringUtil.getParamFromUrl(strQueryString,"customerId");
	        
	        
	        
	        
	        
	        if("true".equals(isDayRealPlay))order.setIsDayRealPlay(isDayRealPlay);
	        
	        if(!"".equals(orderRelPay))order.setOrderRelPay(orderRelPay);
	        
//	        System.out.println(">kkkkkkkkkkkkkkkkkkkkkk   vvvvvvvvvv    ccccccccc  >>>>>>>>>>>orderRelPay>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderRelPay);
	        
	        
	        
	        if("7".equals(orderStates)){
	        	startDate = new Integer(0);
	        	endDate = new Integer(0);
	        }
	        
//	        if("0".equals(orderStates) ){orderStates = null;} 
	        
	     
	
//	        System.out.println(">kkkkkkkkkkkkkkkkkkkkkk   >>>>>>>>>>>buildParamBy>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"version")));
	        

	    	if(!"0".equals(version)) order.setVersion(new Integer(version));
	        
	        
	    	if(orgId == null || "".equals(orgId)){
	       	    String sOrgs = UserUtil.getUserOrgs(loginUser);
	       	    orgId = sOrgs.split(",")[0];
	        	if("".equals(orgId)) orgId = "1";
	       }
	       

//	        System.out.println("carrIds<<<<<<<<!22222222222<<<<<<<<<<<<"+carrIds);
	        
	       
	        String selectImportOrder =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"publishMemo"));//福州台的导入数据查询使用
	        order.setPublishMemo(selectImportOrder);
	        
	        if(createBy != null && !"".equals(createBy)) order.setCreateBy(new Long(createBy));
	       
	        if(userId != null && !"".equals(userId) &&  !"0".equals(userId)) order.setUserId(new Long(userId));

	        String moneyS = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"moneyState"));
	        moneyS = moneyS == null||"".equals(moneyS)?"0":moneyS;
	        Integer moneyState = new Integer(moneyS);
	       
	        String moneyR =  StringUtil.getParamFromUrl(strQueryString,"moneyRealpay");
	        
	        moneyR = moneyR == null||"".equals(moneyR)?"0":moneyR;
	        Double moneyRealpay = new Double(moneyR);
	        
//	        int posStart =  Integer.parseInt(StringUtil.getParamFromUrl(strQueryString,"posStart"));
//
////	        int count =  Integer.parseInt(StringUtil.getParamFromUrl(strQueryString,"count"));
//	        int count =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"30"));	   
//
//	        System.out.println(">>>>>>>>>>>>posStart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + posStart);             
//	        System.out.println(">>>>>>>>>>>>count>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + count);   
	        

	        if(customerName != null) order.getCustomer().setCustomerName(customerName);
	        if(matterName != null) order.getOrderPublic().setMatterName(matterName);
	        if(orderCode != null)  order.setOrderCode(orderCode);
	        if(contractCode != null) order.getContract().setCode(contractCode);
	        if(relationCode != null) order.setRelationCode(relationCode);
	        
	        order.getOrderPublic().setPublishStartDate(startDate);
	        order.getOrderPublic().setPublishEndDate(endDate);
	        

	        
	        if(carrIds!=null &&!"".equals(carrIds)){
	        	order.setCarrIds(carrIds);
	        }else{
	        	order.setCarrIds("0");
	        }

	        
//	        order.setMatterId(matterId);
	        order.getOrderPublic().setMoneyState(moneyState);
	        order.getOrderPublic().setMoneyRealpay(moneyRealpay);
	        order.setOrderCategorys(category);
	        order.setOrderStates(orderStates);
	        

	        
	        if(SysParamUtil.useLanmuSingleParam()){
//	    		   if(carrierType ==null || "".equals(carrierType)) carrierType ="P";
//	        	   System.out.println(">>>>>>>>>>>>carrierType>>666666666666666666666666666666666666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + carrierType);
//		        System.out.println(">>>>>>>>>>>>useLanmuSingleParam>>666666666666666666666666666666666666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + SysParamUtil.useLanmuSingleParam());
	    		   order.setCarrierType(carrierType);
	    	}
	    	
	    	 order.setCutCates(cutCates);
	    	
//	    	if(SysParamUtil.useMoreCarrierSortParam()){
////	    		order.setCarrSort(carrSort);
//	    		order.setOrgId(new Long(orgId));
//	    	}
	    	 
	    	    System.out.println(">>>>>>>>>>>>orgId>>>>>>>>>>>dddddddddddddddddddddddddddddddddddddddddd>>>>>>>>>>>>>>>>>>>>>>>>>" + orgId);
	    	order.setOrgId(new Long(orgId));
	    	
	    
	    	if(!"".equals(orderMeno) && !"null".equals(orderMeno)&& !"undefined".equals(orderMeno)){
	    		 order.setOrderMeno(orderMeno);
	    	}    	
	    	
	    	
	    	
	    	if(!"".equals(customerId) && !"null".equals(customerId)&& !"undefined".equals(customerId)){
	    		 order.setCustomerId(new Long(customerId));
	    	}    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	   if(!"".equals(orderRate1) && !"null".equals(orderRate1)&& !"undefined".equals(orderRate1)){
	    		 order.setOrderRate1(orderRate1);
	    	}    	
	    	
	   if(!"".equals(orderRate2) && !"null".equals(orderRate2)&& !"undefined".equals(orderRate2)){
	    		 order.setOrderRate2(orderRate2);
	   	} else{
		   	if(!"".equals(orderRate1) && !"null".equals(orderRate1)&& !"undefined".equals(orderRate1)){
		   			order.setOrderRate2("100");
		   			}
	    	}
	    	
	   System.out.println(">>>>>>>>>>>>orderRelPay>>>>>>>>>>>>>>orderRelPay>>>>>>>>>>>>>>>>>>>>>>" + orderRelPay);  
	   
	   
	    	  System.out.println(">>>>>>>>>>>>orderRate1>>>>>>>>>>>>>>orderRate1>>>>>>>>>>>>>>>>>>>>>>" + orderRate1);      
	    	  
	      	  System.out.println(">>>>>>>>>>>>orderRate2>>>>>>>>>>>>>>>>orderRate2>>>>>>>>>>>>>>>>>>>>" + orderRate2);    
	    		
	    		
//	        System.out.println(">>>>>>>>>>>>customerName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + customerName);
//	        System.out.println(">>>>>>>>>>>>orderCode>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderCode);
//	        System.out.println(">>>>>>>>>>>>contractCode>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + contractCode);
//	        System.out.println(">>>>>>>>>>>>start_date>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + start_date);
//	        System.out.println(">>>>>>>>>>>>end_date>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + end_date);      
//	      
//	        System.out.println(">>>>>>>>>>>>matterName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + matterName);
//	        System.out.println(">>>>>>>>>>>>category>>>>>>>>>>>>>>>3333333333333333333333333333333333333>>>>>>>>>>>>>>>>>>>>>" + category);
//	        System.out.println(">>>>>>>>>>>>matterId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + matterId);
//	        System.out.println(">>>>>>>>>>>>carrIds>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + carrIds);
//	        System.out.println(">>>>>>>>>>>>relationCode>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + relationCode);    
//	        
	        System.out.println(">>>>>>>>>>>>orderStates>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderStates);    
//	        System.out.println(">>>>>>>>>>>>userId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + userId);    
//	        System.out.println(">>>>>>>>>>>>createBy>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + createBy);    
//	        System.out.println(">>>>>>>>>>>>cutCates>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + cutCates);   
//	        System.out.println(">>>>>>>>>>>>carrierType>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + carrierType);   
//	        System.out.println(">>>>>>>>>>>>orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + carrSort);   	        
//	        System.out.println(">>>>>>>>>>>>selectImportOrder>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + selectImportOrder);   
//	        System.out.println(">>>>>>>>>>>>moneyState>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + moneyState);   
//	        System.out.println(">>>>>>>>>>>>moneyRealpay>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + moneyRealpay);      	 
//	        System.out.println(">>>>>>>>>>>>loginUser>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + loginUser);       
	        
	        
	        
//	        order.setOrderStates(category);
	   
	        
	       
//	        long start1 = System.currentTimeMillis();
	        

//	        Map userRelsMap = (Map)request.getSession().getServletContext().getAttribute(Constants.AVAILABLE_USER_RELS);
//	        order.setUsers(mgrUser.getOwnerUsersList(userRelsMap));
	        
//	    	System.out.println(">>>>>>>>>>>>>>>>>>>>loginUser1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+loginUser);
	    	
	        order.setLoginUser(loginUser);   	
	        
	        return order;
    }
    
    
    
    
    
    public Order getCountSum(Order order){
    	
    	Map mp = new HashMap();
    	Order o = new Order();
    	
    	getSearchWhere(mp,order);
    	
//    	System.out.println("getCountSum list.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
		List list = dao.getOrdersPageByUserSum(mp);
		
//     	System.out.println("getCountSum list.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+list.size());
     	
    	double moneyRealpay = 0;
    	double moneyIn = 0;
    	double useTime = 0;
    	int startDate = 0;
    	int endDate = 100000000;
    	int start = 0;
    	int end  = 0;
    	
    	boolean isDayRealPlay = Boolean.valueOf(order.getIsDayRealPlay()).booleanValue();

    	   if(isDayRealPlay){
    		   
          	 List orderIdList = new ArrayList();
          	 CollectionUtils.addAll(orderIdList,ConvertUtil.getColFromList(list,"id"));
         
//          	 System.out.println("getCountSum>>>>>>>>           fffffffffffffff         hhhhhhhhhhhhhhhhh  >>>>>>>>>>>>>> " + orderIdList);
//          	 System.out.println("getCountSum                3333333333333333              ffffffffff        >>>>>>>>222222222 orderIdList.size()>>>>>>>>>>>>>> " +orderIdList.size());
          	 
          	 if(orderIdList.size()>0){
          		 mp.put("OrderIdList",orderIdList);
          		 
//          		 System.out.println("isDayRealPlay>>>>>>>>222222222>>>>>>>>>>>>>> ");
//          		 StringUtilsv.printMap(mp);
          		 Map mp2 = dao.getOrdersPageByUsersForRelPayInDate(mp);
          		 
//          		 StringUtilsv.printMap(mp);
          		 
//          		System.out.println("mp2>>>>>>>>>>>3333333333>>>>>>>>>>> "+mp2.size());
          		 
          		 for(Iterator it = list.iterator();it.hasNext();){
	          			 Order odr = (Order)it.next();
	          			 
	          			 Long id = odr.getId();
	          			 if(mp2.containsKey(id)){
	//          				 System.out.println("odr.getId>>>>>>>>>>>>>>>>>>>>>> "+odr.getId());
	          				 Order odr2 = (Order)mp2.get(id);
	     	        		moneyRealpay += odr2.getOrderPublic().getMoneyRealpay().doubleValue();
	    	        		moneyIn += odr2.getOrderPublic().getMoneyIn().doubleValue();
	    	        		useTime += (new Double(StringUtil.getNullValue(odr2.getOrderPublic().getUseTime(),"0"))).doubleValue();
	    	        		
	    	        		
	          			                 }
          		 					}
          	 				}
          	 
          	 endDate= ((Integer)mp.get("startDate")).intValue();
          	startDate = ((Integer)mp.get("endDate")).intValue(); 

          }else{
	          	for(Iterator it = list.iterator();it.hasNext();){
	        		Order odr = (Order)it.next();
	        		OrderPublic orderPublic = odr.getOrderPublic();
	        		moneyRealpay += orderPublic.getMoneyRealpay().doubleValue();
	        		moneyIn+=orderPublic.getMoneyIn().doubleValue();
	        		
//	        	 	System.out.println("getCountSum useTime>>>>>>>>>>>>>>>>>>>8888888888888888 9999999999999999 66666666666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+orderPublic.getUseTime());
	            	
	        	 	
	        		useTime += (new Double(StringUtil.getNullValue(orderPublic.getUseTime(),"0"))).doubleValue();
	        		
//	        	 	System.out.println("getCountSum useTime>>>>>>>>>>>>>>>>>>>8888888888888888 9999999999999999 66666666666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+useTime);
	            	
	        		
	        		 start = orderPublic.getPublishEndDate().intValue();
	        		 end = orderPublic.getPublishEndDate().intValue();
	        		if(start >startDate) startDate = start;
	        		if(end != 0 && end <endDate) endDate = end;
	        	}
          }
   

	   o.setId(new Long(list.size()));
    	o.getOrderPublic().setPublishStartDate(new Integer(endDate));
    	o.getOrderPublic().setPublishEndDate(new Integer( startDate));
    	o.getOrderPublic().setMoneyRealpay(new Double(moneyRealpay));
    	o.getOrderPublic().setMoneyIn(new Double(moneyIn));
    	
    	
    	o.getOrderPublic().setUseTime(String.valueOf(useTime));
    	
//    	System.out.println("getCountSum useTime>>>>>>>>>>>>>>>>>>>8888888888888888 9999999999999999 66666666666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+useTime);
//    	
//
//		 
//		 System.out.println("getCountSum useTime>>>>>>>>>>>>>>>>>>>8888888888888888 9999999999999999 66666666666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+used);
	    	
		 
//    	o.getOrderPublic().setUseTime(used);

    	return o;
    }
    
    
    
   
    private void getSearchWhere(Map mp,Order order){
    	
    	String loginUser = order.getLoginUser();
//    	boolean channelPull =  SysParamUtil.getChannelModelPara();
    	
    	List ls = getOrderStates(order.getOrderStates());
    	if(ls.size()>0){
    		mp.put("OrderStates",ls);
    	}else{
    		mp.put("OrderStates",null);
    	}
    	
    	
    	
    	int version = Integer.parseInt(StringUtil.getNullValue(order.getVersion(),"0"));
    	if(version > 0 ) mp.put("version",order.getVersion());
    	
    	
    	int orgId = Integer.parseInt(StringUtil.getNullValue(order.getOrgId(),"0"));
//    	int orgId2 = Integer.parseInt(StringUtil.getNullValue(order.getCarrSort(),"0"));
//    	if(orgId == 0) orgId = orgId2;
//    	if(orgId2 == 0) orgId =1;
    


    	String  selectOrder = order.getPublishMemo();
    	if(selectOrder!=null && selectOrder!=""){
    		mp.put("publishMemo",selectOrder);
    	}
    	
    	Long orderId = order.getId();
    	String oId = (orderId == null)?"":orderId.toString();
    	
    	Long userId = order.getUserId();
    	String uId = (userId == null)?"":userId.toString();
    	
    	Long customerId = order.getCustomerId();
    	String cId = (customerId == null)?"":customerId.toString();
    	if(cId!=null && cId!=""){
    		mp.put("customerId",cId);
    	   }
    	
    	
      	String customerIds =	StringUtil.getNullValue(order.getCustomerIds(),"");
      	if(!"".equals(customerIds)){
          	List  customerls = new ArrayList();
          	String[] custIds = customerIds.split(",");
//          	System.out.println(">>>>>>>>custIds>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+custIds[0]);
//          	System.out.println(">>>>>>>>length>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+custIds.length);
	    		CollectionUtils.addAll(customerls,custIds);
	    		mp.put("customerIdList",customerls);

      						}

	
		String customerName =  null;
    	if(order.getCustomer() != null){
        	customerName = order.getCustomer().getCustomerName();
            customerName = (customerName == null)?"":customerName;
    	}

        
    	String orderCode = order.getOrderCode();
    	orderCode = (orderCode == null)?"":orderCode;
    	
    	String contractCode = "";
    	if(order.getContract()!=null){
    		contractCode = order.getContract().getCode();
    		contractCode = (contractCode == null)?"":contractCode;
    	}

    	String relationCode = order.getRelationCode();
    	relationCode = (relationCode == null)?"":relationCode;
    	
 	
    	
    	String matterName = order.getOrderPublic().getMatterName();
    	matterName = (matterName == null)?"":matterName;
    	
    	
    	Integer startDate = order.getOrderPublic().getPublishStartDate();
    	startDate = (startDate == null)?new Integer(0):startDate;
    	
    	Integer endDate =order.getOrderPublic().getPublishEndDate();
    	endDate = (endDate == null)?new Integer(0):endDate;
    	
    	
    	if("7".equals(order.getOrderStates())){
    		startDate = new Integer(0);
    		endDate = new Integer(0);
    	}
    	
    	
    	Integer moneyState = order.getOrderPublic().getMoneyState();
    	moneyState = (moneyState == null)?new Integer(0):moneyState;
    	
    	Double moneyRealpay = order.getOrderPublic().getMoneyRealpay();
    	moneyRealpay = (moneyRealpay == null)?new Double(0):moneyRealpay;
    	

    	
    	
//    	String categoryId = order.getCategoryId();
    	
    	String categoryId = order.getOrderCategorys();
    	
    	List categoryIds = new ArrayList();
    	categoryId = (categoryId == null)?"":categoryId;
    	
//    	String matterId = order.getMatterId();
//    	System.out.println(matterId!=null);
//    	if(matterId!=null&&!matterId.equals("")){
//    		Map matterMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_MATTER_SAME_NAME);
//			List matterIds = (List)matterMap.get(new Long(matterId));
//			mp.put("MatterIdList",matterIds);
//			System.out.println("matterIds>>    "+matterIds);
//    	mp.put("MatterIdList",null);
			
//    	}
//    	String channelModel = order.getChannelModel();
//        String userName = order.getTheUserName();
//       String carrierId = order.getCarrierId().toString();
//        
//   
//        System.out.println(">>>>>>>>>"+userName+">>>>>>"+channelModel);
////        int channelModelParam = Integer.parseInt(channelModel);

//    	 Long carrier_Id = order.getCarrierId();
//     	 String carrierId = (carrier_Id == null)?"0":carrier_Id.toString();
     	 
        

     	
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
     	}
     	
     	
     	
     	
     	
//     	 System.out.println("carrierIdList.size >>>>>>>>>>>>>>>>>>>>>>>  "+UserUtil.getUserYearRelByLoginUser(loginUser));

     	
     	String carrierId = String.valueOf(order.getCarrierId());
     	String carrierIds = order.getCarrIds();
     	carrierIds = (carrierIds ==null) && !"0".equals(carrierIds) ?carrierId:carrierIds;
     	

    	
//     	long start2 = System.currentTimeMillis();
//     	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+carrierId+">>>>>>"+carrierId);
//     	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>>>>>>>>>>"+carrierIds+">>>>>>"+carrierIds);
     	List carrierIdList = CarrierUtil.getCarrierIds(carrierIds,"2",loginUser);
     	
//     	 System.out.println("carrierIdList.size >>>>>>>>>>>>yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>>  "+carrierIdList);
     	 
//     	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+carrierIdList+">>>>>>"+carrierIdList.size());
//        long end2 = System.currentTimeMillis();
//        System.out.println("get carrierIdList orders>>>>>>>>   "+ (end2 -start2) +"秒");	
      
////		判断是否分频道，值为1分，否则不分k
//     	List carrierIdList = new ArrayList();
//     	if(carrierIds == null){
//     		 boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
//     		if(carrierAlisname && !"0".equals(carrierId)){
//	    		String ids = CarrierUtil.getOtherSameAlisnameIds(carrierId);
//	    		if(ids.indexOf(",")>-1){
//	    			String[] s = ids.split(",");
//	    			for(int i = 0;i<s.length;i++){
//	    				carrierIdList.add(s[i]);
//	    			}
//	    		}else{
//	    			carrierIdList.add(carrierId);
//	    		}
//	    		
//	    	}else{
//	    		carrierIdList = carrierManager.getCarrierIdLists(carrierId,channelPull,currentUser);
//	    	}
//			
//     	}else{
//     		
//     		
//     		
//     	}

     	
   
			
		if(startDate.intValue() >0 && endDate.intValue() >0){
			mp.put("carrierIdList",carrierIdList);
			
			
		}		
		
		

//     	  long start2 = System.currentTimeMillis();
     	  
//     	   
//     	   System.out.println(">>>>>>>>>"+carrierIds+">>>>>>"+carrierIds);


			
			
//	        long end2 = System.currentTimeMillis();
//	        System.out.println("get carrierIdList orders>>>>>>>>   "+ (end2 -start2) +"秒");	


         List userLs =order.getUsers();
//         System.out.println("userLs.size >>>>>>>>>>>>>>>>>>>>>>>  "+userLs);
         if(userLs == null) userLs = new ArrayList();
         if(userLs.size() == 0)	{
//    		 Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
             List userList = new ArrayList();
//             CollectionUtils.addAll(userList,ConvertUtil.getColFromList(userManager.getOwnerUsersList(userRelsMap,loginUser),"id"));	
             userList = UserUtil.getOwnerUsersList(loginUser,2);
    		 order.setUsers(userList); 
         }
         
     	
         
    boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
    
//    if(isOneOrgMoreSuborgs){
    	
              List orgIdList = new ArrayList();
              
              orgIdList = SysParamUtil.getOrgChileds(String.valueOf(orgId));
              
              System.out.println("getOrgChileds >>>>>>>>>>5 6 7 8>>>>>>>>>>>>>  "+orgIdList);
              
             if(orgIdList.size()== 0){
             		orgIdList.add(""+orgId);
             						}
             mp.put("orgIdList",orgIdList);   
             
             
             UserDao  userDao = ServiceLocator.getUserDao();
             List userls2 = userDao.getUserIdsByOrg(mp);
             mp.put("UserIdList2",userls2);
//          }
         

        
        
        
        
        
        
        
//     	mp.put("orgId",""+orgId);   	
        

    	        
    	if((!"".equals(uId) &&  !"0".equals(uId))){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
//    		List uuls = order.getUsers();
    		mp.put("UserIdList",order.getUsers());
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	if((!"".equals(cId) &&  !"0".equals(cId))){
    		mp.put("customerId",cId);
    	}
    	
    	
    	
    	if((!"".equals(oId) &&  !"0".equals(oId))){
//    		mp.put("orderId",oId);
    		mp.put("orderId",null);
    	}
    	
//    	 System.out.println("getSearchWhere>>>>>>>>>>>>customerName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + customerName);
    	if(!"".equals(customerName)){
    		mp.put("customerName",customerName);
    	}   	
    	
    	
    	if(!"".equals(orderCode)){
    		mp.put("orderCode",orderCode);
    	}   
    	
    	if(!"".equals(contractCode)){
    		mp.put("contractCode",contractCode);
    	}
    	
    	if(!"".equals(relationCode)){
    		mp.put("relationCode",relationCode);
    	}   
    	
    	if(!"".equals(matterName)){
    		mp.put("matterName",matterName);
    	}  
    	
    	Long createBy = order.getCreateBy();
    	String createById = createBy == null?"0":createBy.toString();
    	if(!"0".equals(createById)||"".equals(createById)){
    		mp.put("createBy",createById);
    	}  
    	
     
    	
    	mp.put("orderCategoryIds",null);
    	
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		
		if(financialAuditSwitch){
			
//			System.out.println("orderCategoryIds >>>>>>>>>>>>>>>>>>fitterOrderSubCatesList>>>>getVersion>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+order.getVersion());
			
			List fitterOrderSubCatesList  = SysParamUtil.getFitterOrderSubCates(String.valueOf(version));
			
			System.out.println("orderCategoryIds >>>>>>>>>>>>>>>>>>fitterOrderSubCatesList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+fitterOrderSubCatesList);
			
			if(fitterOrderSubCatesList.size() >0) 	mp.put("orderCategoryIds",fitterOrderSubCatesList);
			
		}
		  	
    	
	
		
    	
//    	System.out.println(!"".equals(matterName));
    	if(!"".equals(categoryId)&& !"0".equals(categoryId)){
//    		String cidstr = categoryId.substring(1,categoryId.length()-1);
    		
    		
//	    	System.out.println("cidstr >>>>>>>>>>>>>>>>>>1111111111111111111111111111111111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+categoryId);
//    		System.out.println("cidstr>>>>>>>>>>>>>>>>>>>>>>>>>>22222222222222222222222222222222>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+cidstr);
	    	String[] cIds = categoryId.split(",");
    	
	    	CollectionUtils.addAll(categoryIds,cIds);
    		mp.put("orderCategoryIds",categoryIds);
    	} 
    	
    	System.out.println("orderSubCategoryIds.size >>>>>>>>>>>>>>>>>>>>>>>  "+categoryIds);
    	

    	
//    	if(startDate.intValue() >0){
    		mp.put("startDate",startDate);
//    	}   
//    	if(endDate.intValue() >0){
    		mp.put("endDate",endDate);
//    	}  
    	if(moneyState.intValue() == 1){
    		mp.put("arrears",moneyState);
    	} 
    	if(moneyState.intValue() == 2){
    		mp.put("noArrears",moneyState);
    	} 
    	
    
    	if(moneyRealpay.intValue() == 1){
    		mp.put("zero",new Integer(moneyRealpay.intValue()));
    	} 
    	if(moneyRealpay.intValue() == 2){
    		mp.put("nozero",new Integer(moneyRealpay.intValue()));
    	}
  	
    	
    	List lsCutCates = UserUtil.getCustomerCateByUser(loginUser, order.getCutCates());
    	if(lsCutCates.size()>0)mp.put("customerCates",lsCutCates);
    	
    	
    	if(SysParamUtil.useLanmuSingleParam()){
        	mp.put("carrierType",order.getCarrierType());
    	}
    	
	
    	
    	
    	
    	
//    	System.out.println("getCarrierType >>>>>>>>>>>5555555555555555555555555555555555>>>>>>>>>>>>  "+order.getCarrierType());       	
    	
    	
//    	if(SysParamUtil.useMoreCarrierSortParam()){


        	
//        	if(log.isErrorEnabled()){
//            	System.out.println("lsCutCates.size >>>>>>>>>>>>>>>>>>>>>>>  "+lsCutCates);
//            	System.out.println("getCarrierType >>>>>>>>>>>>>>>>>>>>>>>  "+order.getCarrierType());       		
//        	}

    		
    		


//        	String orgId = order.getCarrSort();
//        	mp.put("orgId",orgId);
        	
//    	}
    	
    	String orderMeno = order.getOrderMeno();
    	if(!"".equals(orderMeno) && !"null".equals(orderMeno)&& !"undefined".equals(orderMeno)){
    		mp.put("orderMeno",order.getOrderMeno());
    	}
    	
    	String orderRelPay = order.getOrderRelPay();
    	if(!"".equals(orderRelPay)){
    		mp.put("orderRelPay",orderRelPay);
    	}  	
    	
    	
    	
    	String orderRate1 = order.getOrderRate1();
    	if(!"".equals(orderRate1)){
    		mp.put("orderRate1",orderRate1);
    	}  	
    	
    	
    	String orderRate2 = order.getOrderRate2();
    	if(!"".equals(orderRate2)){
    		mp.put("orderRate2",orderRate2);
    	}  	
    	
//    	boolean catFiter = SysParamUtil.getCustomerCateFiter();
//    	if(catFiter){
//    		List lsCutCates = UserUtil.getCustomerCateByUser(null, order.getCutCates());
//    		if(lsCutCates.size()>0)mp.put("customerCates",lsCutCates);
//    		
//        	if(log.isErrorEnabled()){
//	        	System.out.println("lsCutCates.size >>>>>>>>>>>>>>>>>>>>>>>  "+lsCutCates);
//	        	System.out.println("getCarrierType >>>>>>>>>>>>>>>>>>>>>>>  "+order.getCarrierType());       		
//        	}
//    	}
    


    }
    
//	public  boolean getChannelModelPara(){
//	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//	    if(StringUtils.isEmpty(sysParam.getChannelModelParam())) sysParam.setChannelModelParam("0");
//	    return (sysParam.getChannelModelParam().equals("0"))?false:true;
//	} 

	
	private List getOrderStates(String states){
		List ls = new ArrayList();
		
		if((!"".equals(states) && states != null)){
			if(states.equals("5")){
				states = states.equals("5")?"0,1,2,4":states;
			}else if (states.equals("6")){
				states = states.equals("6")?"0,4":states;
			}else{
				states = states.equals("7")?"0":states;
			}
			
			
			
			
			
			
			
		}

		if((!"".equals(states) && states != null)){
			String[] stateArray = states.split(",");
//			StringUtil.printArray(stateArray);
			CollectionUtils.addAll(ls,stateArray);
		}
		return ls;
	}
	
	
	
	
	
	
    
    public PaginatedList getOrdersPage(Order order, String pageIndex,String pageSize) {

    	return dao.getOrdersPage(order,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
    }

    
	public String getOrdersCount(Order order) {
		return dao.getOrdersCount(order).toString();
	}

	/**
     * @see com.vriche.adrm.order.service.OrderManager#getOrder(String id)
     */
    public Order getOrder(final String id) {
        return dao.getOrder(new Long(id));
    }
    
    public Order getOrderForEdit(final String id){
    	 Order order =  dao.getOrderForEdit(new Long(id));
    	 
    	 String orderCheckState = StringUtil.getNullValue(order.getOrderState().getName(),"");
    	 if("".equals(orderCheckState)){
    		 orderCheckState = SysParamUtil.getWithoutSubmitParam() ?"未审核":"未提交";
    		 order.getOrderState().setName(orderCheckState);
    	 }

    	 return order;
    }
    
    

    /**
     * @see com.vriche.adrm.order.service.OrderManager#saveOrder(Order order)
     */
   public String saveOrder(Order order) {
    	
    	boolean isNew = (order.getId() == null) || StringUtils.isEmpty(order.getId().toString());
    	
//    	List payments = (List)order.getContractPayments();
//    	
//    	ContractPayment payment = new ContractPayment();
//    	for(Iterator it = payments)
    	
	    if(isNew){
	    	String year = order.getVersion().toString();
	    	String orderCode  = sysSequenceManager.getSysSequenceByObject(Constants.SEQUENCE_TB_ORDER,year);
	    	order.setOrderCode(orderCode);
    	}
//    	Long paymentId = saveOrderPayment(order,isNew);
//    	  
//    	order.setPaymentId(paymentId);
    	//保存客户信息
//	    checkIsNewCustomer(order);
    	
    	String orderId = dao.saveOrder(order).toString();
    	//保存付款信息
//	    saveContractPayment(order,isNew);
    	
        return orderId;
    }
   
   
   private void setOrderCode(Order order){
	 	String year = order.getVersion().toString();
		String orderCode  = sysSequenceManager.getSysSequenceByObject(order.getOrgId().toString(),Constants.SEQUENCE_TB_ORDER,year);
		order.setOrderCode(orderCode);    
   }
   
   private void setRelationCode(Order order){
//	   temStr  0 组织编号 1 时段类型（1时段 3栏目）2、客户类型
//		boolean autoRelationCodeParam = SysParamUtil.getAutoRelationCodeParam();
		String year = order.getVersion().toString();
//		if(autoRelationCodeParam){
			String relCode  = sysSequenceManager.getSysSequenceRelationCode(order.getTempStr(),Constants.SEQUENCE_TB_ORDER_RELATION,year);
			order.setRelationCode(relCode);
//		}
  }
   
   public Order saveOrderReturnObj(Order order) {
//	    boolean xmtv = SysParamUtil.isXMTVParam(null);
//	    boolean qztv = SysParamUtil.isQZTVParam(null);
	   	boolean isNew = (order.getId() == null) || StringUtils.isEmpty(order.getId().toString());
	   	boolean autoRelationCodeParam = SysParamUtil.getAutoRelationCodeParam();
	   	
//	   	String year = order.getVersion().toString();
	   	
		if(isNew){
			setOrderCode(order);
			if(autoRelationCodeParam) setRelationCode(order);
			order.setCreateDate(new Date());
			order.setModifyDate(new Date());
			
	   	}else{
	   		order.setModifyDate(new Date());
	   	}

	   	//保存客户信息
//		checkIsNewCustomer(order);
//	   	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+order.getCustomerId()); 
	   	
//	   	String orderId = dao.saveOrder(order).toString();
	   	dao.saveOrder(order).toString();
	   	
	   	//保存付款信息
//		 saveContractPayment(order,isNew);
	   	
	       return order;
	   }
   
   
//   public Order saveOrderReturnObj(Order order) {
//	   	
//	   	boolean isNew = (order.getId() == null) || StringUtils.isEmpty(order.getId().toString());
//
//		if(isNew){
//			String orderCode  = sysSequenceManager.getSysSequenceByObject(Constants.SEQUENCE_TB_ORDER);
//			order.setOrderCode(orderCode);
//	   	}
//
//	   	//保存客户信息
//		checkIsNewCustomer(order);
////	   	System.out.println("MMMMMMMMMMMMM  "+order.getOrderPublic().getMoneyRealpay()); 
//	   	
//	   	String orderId = dao.saveOrder(order).toString();
//	   	
//	   	//保存付款信息
//		 saveContractPayment(order,isNew);
//	   	
//	       return order;
//	   }  
	    
//   private String saveContractPayment(Order order,boolean isNew){
//	    
//	   	Long contractId = order.getContractId();
//	   	Long orderId= order.getId();
//	   	Long  paymentId = order.getPaymentId();
//	   	Long customerId = order.getCustomerId();
//	   	String  categoryId = order.getCategoryId();
//	   	
//	   	double payMoney = 6200;
//	   	
//	   		contractPaymentManager.saveContractPaymentByOrder(contractId.toString(),orderId.toString(),payMoney,isNew,categoryId);
//	   	return null;
//   }
    /**
     * @see com.vriche.adrm.order.service.OrderManager#removeOrder(String id)
     */
    public void removeOrder(final String id) {
        dao.removeOrder(new Long(id));
    }

     /**
     * @see com.vriche.adrm.order.service.OrderManager#removeOrders(String Map)
     */
    public void removeOrders(final Map idList) {
        dao.removeOrders(idList);
    }
    
    

	
	public String getOrdersByWFSearchCount(String workFlowId, int state,String orderCode,String userId) {
//		Map mp = getEventIds(workFlowId,state);
//		mp.put("orderCode",orderCode);
//		mp.put("userId",userId);
//		return dao.getOrdersByIdListCount(mp).toString();
		return null;
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OrderManager#getOrdersByWorkFlowCount(java.lang.String, int)
	 */
	public String getOrdersByWorkFlowCount(String workFlowId, Order order) {
//		System.out.println(">>>>>>>>>>>>>>>>0"); 
		int state = order.getIsCkecked().intValue();
		Long userId = order.getUserId();
		String orderCode = order.getOrderCode();
		String customerName = order.getCustomer().getCustomerName();
		String year = order.getVersion().toString();
		Long carrier = order.getCarrierId();
		String carrierId = null;
		if(carrier != null) carrierId = carrier.toString();
		System.out.println(">>>>>>>>>>>>>>>>"+workFlowId+"<<"+state+">>"+userId+">>"+orderCode+">>"+carrierId+">>"+customerName); 
		Map mp = getEventIds(workFlowId,state,userId,orderCode,year,carrierId,customerName);
		

		
//		System.out.println(">>>>>>>>>>>>>>>>2"); 
		List ls = (List)mp.get("OrderIdList");
		
		
//		System.out.println(">>>>>>>>>>>>>>>>3"); 

//		if(userId!=null){
//			mp.put("userId",userId);
//		}
		
		String notFined = (String)mp.get("isNotFinded");
		if(notFined != null) ls.remove(0);
		
		
		return String.valueOf(ls.size());
	}	
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OrderManager#getOrdersByWorkFlowPage(java.lang.String, int, java.lang.String, java.lang.String)
	 */
	public List getOrdersByWorkFlowPage(String workFlowId, Order order, String pageIndex, String pageSize) {
		List ls = new ArrayList();
		int state = order.getIsCkecked().intValue();
		Long userId = order.getUserId();
		String orderCode = order.getOrderCode();
		String year = order.getVersion().toString();
		String customerName = order.getCustomer().getCustomerName();
		Long carrier = order.getCarrierId();
		String carrierId = null;
		if(carrier != null) carrierId = carrier.toString();
		Map mp = getEventIds(workFlowId,state,userId,orderCode,year,carrierId,customerName);
		String notFined = (String)mp.get("isNotFinded");
		if(notFined == null){
			List orderls1=(List)mp.get("OrderIdList");
			List orderls2=new ArrayList();

			int index=Integer.parseInt(pageIndex);
			int size=Integer.parseInt(pageSize);
			if(orderls1.size()-index*size>=size){
				orderls2=orderls1.subList(index*size,(index+1)*size);					
			}else if(orderls1.size()-index*size<size){
				orderls2=orderls1.subList(index*size,orderls1.size());		
			}else if(orderls1.size()<size){
				orderls2.addAll(orderls1);
			}
			mp.put("OrderIdList",orderls2);
			ls = this.getOrdersByIdList(mp);
			//ls = this.getOrdersByIdList(mp,pageIndex,pageSize);
		}
		
		return ls;
			
//		System.out.println("userId  "+userId);  
//		if(userId!=null){
//			mp.put("userId",userId);
//		}
//		return this.getOrdersByIdList(mp,pageIndex,pageSize);
	}
	
	public List getOrdersByWorkFlowPageSearch(String workFlowId, int state,String orderCode,String userId, String pageIndex, String pageSize) {
//		Map mp = getEventIds(workFlowId,state);
////		log.info("UUUUUUUUUUUUUUU STEP14>>>");
//		mp.put("orderCode",orderCode);
//		mp.put("userId",userId);
////		System.out.println("Orderid    "+mp.get(new String("OrderIdList")));
//		return this.getOrdersByIdList(mp,pageIndex,pageSize);
		return null;
	}
	
	
	
	public Map getEventIds(String workFlowId,int stateId,Long userId,String orderCode,String year,String carrierId,String customerName){
		List eventIdsList = new ArrayList();
		Map mp = new HashMap();
		
		//获得属于自己的流程
		List ownerList  = new ArrayList();
		ownerList.add(oaWorkFlowManager.getOaWorkFlow(workFlowId));

		if(ownerList.size() == 0) stateId = -1;
		
		if(ownerList.size() > 0){
			//通过自己的流程ID，获得 同意或不同意流转过来的流程
			List otherList  = oaWorkFlowManager.getWorkFlowOther(ownerList);
//			log.info("UUUUUUUUUUUUUUU STEP1111>>>" +ownerList.size());
			CollectionUtils.addAll(otherList,ownerList.iterator());
//			log.info("UUUUUUUUUUUUUUU STEP1>>>" +otherList.size());
//			for(Iterator its = otherList.iterator();its.hasNext();){
//				log.info("otherList >>>>>>BB>>>>"+ its.next());
//			}
			oaWorkFlowManager.getEventsByWorkFlows(workFlowId,eventIdsList,otherList,stateId,1,userId,orderCode,year,carrierId,customerName);	
//			log.info("UUUUUUUUUUUUUUU STEP13>>>" +eventIdsList.size());
		}
		
		if(eventIdsList.size()== 0) {
			eventIdsList.add("");
			mp.put("isNotFinded","1");	
		}
		mp.put("OrderIdList",eventIdsList);	

		return mp;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.ContractManager#updateContractChecked(java.lang.String[], java.lang.String)
	 */
	public void updateOrderStates(Set ids, int state) {
    	List idList = new ArrayList();
        CollectionUtils.addAll(idList,ids.iterator());
        
        if(idList.size() >0){
        	Map mp = new HashMap();
    				mp.put("stateId",String.valueOf(state));	
    				mp.put("OrderIdList",idList);
    				
    				if(idList.size()>0){
    		        	dao.updateOrderStates(mp); 	
    		        	
    		        	orderDetailDao.saveOrderDetailCheckState(mp); 	
    					}


        	
        }     
		
	}
	
	public void updateOrderStates2(String[] ids, int state,String checkUserId,String checkStateIdOld,String defMsg) {
    	List idList = new ArrayList();
        CollectionUtils.addAll(idList,ids);
        
        if(idList.size() >0){
        	Map mp = new HashMap();
		    		mp.put("stateId",String.valueOf(state));	
		    		mp.put("OrderIdList",idList);
    		
//    		System.out.println(">>>>>  aaaaaaaaaaaaaaaaaaaaaaa  "+state) ;
//    		System.out.println(">>>>>  ssssssssssssssssssssss  "+idList) ;
    				if(idList.size()>0){
    					
    		        	dao.updateOrderStates(mp); 	
    		        	
    		        	orderDetailDao.saveOrderDetailCheckState(mp); 	
    					}
        	

    		OrderLogUtil.saveCheckRest(idList,new Long(checkUserId),new Long(checkStateIdOld),new Long(state), defMsg);
        	
        }     
		
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.ContractManager#updateContractStates(java.lang.Object[], int)
	 */
	public void updateOrderStates(String[] ids, int state) {
		Set idSet = new HashSet();
		for (int i = 0; i< ids.length; i++){
			  CollectionUtils.addAll(idSet,ids);
		}
		if (idSet.size() >0 ) this.updateOrderStates(idSet,state);
	}

	public OrderPublic getOrderPublic(String orderId) {
		// TODO Auto-generated method stub
		return dao.getOrderPublic(new Long(orderId));
	}
//	private void checkIsNewCustomer(Order order){
//		Long customerId = order.getCustomerId();
//		String customerName = order.getCustomer().getCustomerName();
//		String customerCategoryId = order.getCustomer().getCustomerCategoryId();
//		String ownerUserId = order.getUserId().toString();
//		String id = customerManager.saveCustomer(customerId,customerName,customerCategoryId,ownerUserId);
//		order.setCustomerId(new Long(id));
//	}
	
	public List getOrdersReport(Order order) {
//		Long customerId = order.getCustomerId();
		int startDate = order.getOrderPublic().getPublishStartDate().intValue();
		int endDate = order.getOrderPublic().getPublishEndDate().intValue();
//		System.out.println(""+startDate);
//		System.out.println(""+endDate);
		List ls = this.getOrders(order);
		return this.getOrdersByDate(ls,startDate,endDate);
		
	}	
	
	private List getOrderForReport(Order order){
		
//		Map mp = new HashMap();
		if(order.getCreateBy().intValue()!=0){
			Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
			
			List carrierIds = (List)carrierMap.get(order.getCreateBy());
			
			List cids = new ArrayList();
			for(Iterator s = carrierIds.iterator();s.hasNext();){
				Carrier c = (Carrier)s.next();
				cids.add(c.getId());
	//			System.out.println(">>>>><<<<<<    "+c.getId());
			}
	//		System.out.println("carrierIds   "+carrierIds.size());
			order.setCarrierIds(cids);
		}
		order.setCreateBy(null);
		
		List ls = dao.getOrderForReport(order);
		
		return ls;
	}
	
//	public List getOrdersReportPage(Order order,String pageIndex, String pageSize) {
//		int startDate = order.getOrderPublic().getPublishStartDate().intValue();
//		int endDate = order.getOrderPublic().getPublishEndDate().intValue();
////		List ls = this.getOrders(order);
//		List ls = getOrderForReport(order);
//		List ls2 = this.getOrdersByDate(ls,startDate,endDate);
//		List ls3 = this.getPageList(ls2,pageIndex,pageSize);
//		return ls3;
//	}	
	public void putIntoMap(Map mp,Order order){
		Integer startDate = order.getOrderPublic().getPublishStartDate();
		Integer endDate = order.getOrderPublic().getPublishEndDate();
		startDate = (startDate == null)?new Integer(0):startDate;
		endDate = (endDate == null)?new Integer(0):endDate;
		String matterName =order.getMatterId()==null?"":order.getMatterId();
		String cId=order.getCustomerId().toString().equals("0")?"":order.getCustomerId().toString();
		
		if((!"".equals(cId) &&  !"0".equals(cId))){
    		mp.put("customerId",cId);
    	}
		if(startDate.intValue() >0){
    		mp.put("startDate",startDate);
    	}   
    	if(endDate.intValue() >0){
    		mp.put("endDate",endDate);
    	}  
    	if(!"".equals(matterName)){
    		mp.put("matterName",matterName);
    	}  

		 Long carrier_Id = order.getCreateBy();
     	 String carrierId = (carrier_Id == null)?"0":carrier_Id.toString();
     	String currentUser = UserUtil.getCurrentPrincipalUser();
      
////		判断是否分频道，值为1分，否则不分k
		boolean channelPull = SysParamUtil.getChannelModelPara();
		List carrierIdList = new ArrayList();
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierId,channelPull,currentUser);

		mp.put("carrierIdList",carrierIdList);
	}
	public List getOrdersReportPage(Order order,String pageIndex, String pageSize) {

		Map mp = new HashMap();
		getSearchWhere(mp,order);
//		putIntoMap(mp,order);
		
//		List ls = dao.getOrdersPageByUsers(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));		
		
		int skip = Integer.parseInt(pageIndex) * Integer.parseInt(pageSize);
		return dao.getOrdersPageByUsers(mp,skip,Integer.parseInt(pageSize));
	}	
	public String getOrdersReportCount(Order order){
		Map mp = new HashMap();
//		putIntoMap(mp,order);
		getSearchWhere(mp,order);
		

		
		return dao.getOrdersPageByUsersCount(mp).toString();
//		return dao.getOrdersPageByUsersCount(mp).toString();
	}
//	public String getOrdersReportCount(Order order){
////		List ls = this.getOrders(order);
//		List ls = getOrderForReport(order);
//		int startDate = order.getOrderPublic().getPublishStartDate().intValue();
//		int endDate = order.getOrderPublic().getPublishEndDate().intValue();	
//		List ls2 = this.getOrdersByDate(ls,startDate,endDate);
//		return String.valueOf(ls2.size());		
//	}
	
	
	private List getOrdersByDate(List orders,int startDate,int endDate){
		List ls = new ArrayList();
		for(Iterator it = orders.iterator();it.hasNext();){
			Order order=(Order)it.next();
//			System.out.println("AAAAAAAAAAAAAAAA   "+order.toString());
//			System.out.println("BBBBBBBBBBBBBBBB   "+order.getOrderPublic().toString());
			Integer st = order.getOrderPublic().getPublishStartDate();
			Integer en = order.getOrderPublic().getPublishEndDate();
//			System.out.println("AAAAAAAAAAAAAAAA  st   "+st);
//			System.out.println("AAAAAAAAAAAAAAAA  en   "+en);
			int start = st==null?0:st.intValue();
			int end = en==null?0:en.intValue();
			if(start>=startDate&&end<=endDate){
				ls.add(order);
			}
		}
			
		return ls;
		
	}
	
	
	private List getPageList(List ls,String pageIndex, String pageSize){
		List list = new ArrayList();
		int size = Integer.parseInt(pageSize);
		int index =  Integer.parseInt(pageIndex);
		int start = (index-1)*size+1;
		int end = start + size;
		int i = 1;
        for(Iterator it = ls.iterator();it.hasNext();){
        	if(i>=start && i<end){
        		Order order=(Order)it.next();
        		list.add(order);
        	}else{
        		it.next();
        	}
        	i++;
        }
		
		return list;
	}

	
//	public Collection getOrdersFromColl(Order order){
	public Collection getOrdersFromColl(Map mp){
//		 System.out.println(">>>>>order   >>>>>>   " +order);
	    Collection adverColl = new ArrayList();
	    List orderList = dao.getOrdersForReport(mp);
	    CollectionUtils.addAll(adverColl,orderList.iterator());
//	    System.out.println(">>>>>orderList   >>>>>>   " +orderList.size());
//	    ArrangeUtil.getPulishArrangeFormColl(adverColl,all);
	    return adverColl;
//	    return getOrderForList(orderList,adverColl);
	}
	
	private Collection getOrderForList(List orderList,Collection adverColl){
		
		 for(Iterator it = orderList.iterator();it.hasNext();){
			 OrderColl orderColl = new OrderColl();
			 Order order = (Order)it.next();
			 
			 Double moneyRelpay = order.getOrderPublic().getMoneyRealpay()==null?new Double(0):order.getOrderPublic().getMoneyRealpay();
			 Double moneyIn = order.getOrderPublic().getMoneyIn()==null?new Double(0):order.getOrderPublic().getMoneyIn();
//			 System.out.println("lllllllllllll   "+order.getOrderPublic().getMoneyIn()) ;
			 String end = order.getOrderPublic().getPublishEndDate()==null?"": order.getOrderPublic().getPublishEndDate().toString();
			 String start = order.getOrderPublic().getPublishStartDate()==null?"": order.getOrderPublic().getPublishStartDate().toString();
			 String matterName = order.getOrderPublic().getMatterName()==null?"":order.getOrderPublic().getMatterName();
			 
			 orderColl.setOrderCode(order.getOrderCode());
			 
			 orderColl.setContractId(order.getContract().getCode());
			 
			 orderColl.setCustomerName(order.getCustomer().getCustomerName());
			 
			 orderColl.setMoneyRealpay(moneyRelpay.toString());
			 
			 orderColl.setEndDate(end);
			 
			 orderColl.setStartDate(start);
			 
			 orderColl.setIsCkecked(order.getOrderState().getName());
			 
			 orderColl.setMatterName(matterName);
			 
			 
			 
			 orderColl.setMoneyIn(moneyIn.toString());
			 
			 orderColl.setUser(order.getUser().getFullName());
			 
			 adverColl.add(orderColl);
			 
		 }
		
		return adverColl;
	}
//	private Long saveOrderPayment(ContractPayment contractPayment,boolean isNewOrder){
////		Long orderId = order.getId();
////		Long contractId = order.getContractId();
//////		Long contractPaymentId = order.getPaymentId();
////		
////		orderId = orderId == null ? new Long(0) : orderId;
////		contractId = contractId == null ? new Long(0) : contractId;
////		
////		System.out.println("orderId---"+orderId);
////		System.out.println("contractId---"+contractId);
//////		List payments = (List) order.getContractPayments();
////		
////		ContractPayment contractPayment = new ContractPayment();
////		
////		contractPayment.setOrderId(orderId);
////		contractPayment.setContractId(contractId);
////		
////		List ls = contractPaymentDao.getContractPayments(contractPayment);
////		
////		System.out.println("ls---"+ls.size());
////		
////		Long paymentId = new Long("0");
////		Long newId = new Long("0");
////		
////		if(ls.size() == 0){
////			ls.add(null);
////		}else{
////			for(Iterator it = ls.iterator();it.hasNext();){
////				ContractPayment payment = (ContractPayment) it.next();
////
////				if(payment != null) paymentId = payment.getId();
////				
////				String contractCode = payment.getContractCode();
////				System.out.println("contractCode=="+contractCode);
////				if(contractCode == ""){
//////					payment.setId(paymentId);
////					if(paymentId.longValue() == 0){
////						newId = contractPaymentDao.saveContractPayment(payment);
////						
////					}
////				}else{
////					return null;
////				}
////			}
////		}
////		System.out.println("newId---"+newId);
//		
//		Long orderId = contractPayment.getOrderId();
//		Long contractId = contractPayment.getContractId();
//		
//		orderId = orderId == null ? new Long(0) : orderId;
//		contractId = contractId == null ? new Long(0) : contractId;
//		
//		ContractPayment paymentPar = new ContractPayment();
//		paymentPar.setContractId(contractId);
//		
//		List ls = contractPaymentDao.getContractPayments(contractPayment);
//		
//		ContractPayment pmt = new ContractPayment();
//		
//		if(ls.size() == 0){
//			
//		}else{
//			for(Iterator it = ls.iterator();it.hasNext();){
//				pmt = (ContractPayment) it.next();
//				
//				
//			}
//		}
//		return null;
//	}
	
	public String getOrderCategoryNameFromMap(String categoryId) {
		// TODO Auto-generated method stub
//		Order order = new Order();
		String categoryName = null;
		List orderCategoryParentList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDER_CATELOGPARENT_MAP);
		Iterator it = orderCategoryParentList.iterator();
		while(it.hasNext()){
			OrderCategory category =(OrderCategory) it.next();
			if(category.getId().toString().equals(categoryId)){
				categoryName = category.getName();
				break;
			}
		}
		
		return categoryName;
	}
	public List getOrdersAutoWF(String workFlowId,int stateId) {
		List eventIdsList = new ArrayList();
		Map mp = new HashMap();
		
		//获得属于自己的流程
		List ownerList  = new ArrayList();
		ownerList.add(oaWorkFlowManager.getOaWorkFlow(workFlowId));
		
		if(ownerList.size() == 0) stateId = 0;
		
		if(ownerList.size() > 0){
			//通过自己的流程ID，获得 同意或不同意流转过来的流程
			List otherList  = oaWorkFlowManager.getWorkFlowOther(ownerList);
//			System.out.println("otherList    "+otherList);
	//		log.info("UUUUUUUUUUUUUUU STEP1>>>" +otherList.size());
			CollectionUtils.addAll(otherList,ownerList.iterator());
//			log.info("UUUUUUUUUUUUUUU STEP2>>>" +otherList);
			Long userId = new Long("0");
			String orderCode ="";
			String year ="";
			String carrierId ="";
			String customerName ="";
			
			oaWorkFlowManager.getEventsByWorkFlows(workFlowId,eventIdsList,otherList,stateId,1,userId,orderCode,year,carrierId,customerName);	
	//		log.info("UUUUUUUUUUUUUUU STEP13>>>" +eventIdsList.size());
		}
		
		if(eventIdsList.size()== 0) eventIdsList.add("");
		mp.put("OrderIdList",eventIdsList);	
//		System.out.println("eventIdsList     "+eventIdsList.size());
			return this.getOrdersByIdList(mp);
		}
	
	
	public String getOrdersByCheckState(String checkState){
//		System.out.println(">>>    "+dao.getOrdersByCheckState(checkState).toString());
		return dao.getOrdersByCheckState(checkState).toString();
	}
	
	public String getOrdersByCheckState2(String checkState,String userLongName,String year){

		Map checkUserRelMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CHECK_USER_REL);
		List userIdList = (List)checkUserRelMap.get(userLongName);
	
		Map mp = new HashMap();
		mp.put("checkState",checkState);
		mp.put("userIdList",userIdList);
		mp.put("year",year);
		return dao.getOrdersByCheckState2(mp).toString();
	}
	public List getOrderCodeByCheckState1(String checkState,String publishDate,String[] resourceId){
		Map mp = new HashMap();
		List resourceIdList =new ArrayList();
		CollectionUtils.addAll(resourceIdList, resourceId);
		List stateList = new ArrayList();
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		
		System.out.println("sysParam.getPublishOrderAlertStates()>>>>>>>>>>    "+sysParam.getPublishOrderAlertStates());
		
		String s[] = sysParam.getPublishOrderAlertStates().split(",");
		CollectionUtils.addAll(stateList,s);
		mp.put("checkState",stateList);
		mp.put("resourceIdList",resourceIdList);
		mp.put("publishDate",publishDate);
		
		System.out.println("publishDate.substring(0,4)>>>>>>>>>>    "+publishDate.substring(0,4));
		System.out.println("publishDate.substring(1,4)>>>>>>>>>>    "+publishDate.substring(1,4));
		
		mp.put("year",publishDate.substring(0,4));
		return dao.getOrderCodeByCheckState1(mp);
	}
	public String getSpecificInfo(String beginDate,String endDate,String[] resourceId, String specificId){
		Map mp = new HashMap();
		List resourceIdList =new ArrayList();
		CollectionUtils.addAll(resourceIdList, resourceId);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		mp.put("resourceIdList",resourceIdList);
		mp.put("specificId",specificId);
		List ls = dao.getSpecificInfo(mp);
		return makeTreeGridXML(ls);
	}
	
	
	public Collection getCollections(final String queryString,String type){
		
		Map mp = new HashMap();
		List resourceIdList =new ArrayList();
		String beginDate = StringUtil.getParamFromUrl(queryString,"beginDate");
		String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
		String[] resourceId = StringUtil.getParamFromUrl(queryString,"resourceId").split(",");
		String specificId = StringUtil.getParamFromUrl(queryString,"specificId");
		
		CollectionUtils.addAll(resourceIdList, resourceId);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		mp.put("resourceIdList",resourceIdList);
		mp.put("specificId",specificId);
		
		List ls = dao.getSpecificInfo(mp);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 7;
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			OrderDetail orderDetail = (OrderDetail)it.next();
			Integer publishStartDate = orderDetail.getOrderPublic().getPublishStartDate();
			String publishDate = publishStartDate.intValue()==0?"":publishStartDate.toString();
			String specific = orderDetail.getSpecific().getName();
			specific = specific ==null?"":specific;
			
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(DateUtil.SetDateFormat(publishDate,"yyyy/MM/dd"));break;
						case 2:
							fObject.setValue2(orderDetail.getOrder().getOrderCode());break;
						case 3:
							fObject.setValue3(orderDetail.getResource().getMemo());break;
						case 4:
							fObject.setValue4(specific);break;
						case 5:
							fObject.setValue5(orderDetail.getMatter().getName());break;
						case 6:
							fObject.setValue6(orderDetail.getMatter().getEdit());break;
						case 7:
							fObject.setValue7(orderDetail.getMatter().getLength());break;
						default :
					}
				}
			}
			valuecoll.add(fObject);
		}
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;
	}
	


	public CarrierManager getCarrierManager() {
		return carrierManager;
	}
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}
	
	public String getOrderListXML(Order order) {
		Map mp = new HashMap();
		getSearchWhere(mp,order);

		List all = dao.getOrderListPage(mp);
//		System.out.println("all<<<<<<<1111111111111<<<<<<<<<<"+all.size());
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		int i = 1;
		for(Iterator it = all.iterator();it.hasNext();){
			Order LMan = (Order) it.next();
			String orderCode = LMan.getOrderCode()==null?"":LMan.getOrderCode();
			String code = LMan.getContract().getCode()==null?"":LMan.getContract().getCode();
//			Double moneyRealpay = LMan.getOrderPublic().getMoneyRealpay();
//				moneyRealpay = moneyRealpay==null? new Double(0):moneyRealpay;
			Integer publishStartDate = LMan.getOrderPublic().getPublishStartDate();
			Integer publishEndDate = LMan.getOrderPublic().getPublishEndDate();
//				moneyIn = moneyIn==null? new Double(0):moneyIn;
			String StateName = LMan.getOrderState().getName()==null?"":LMan.getOrderState().getName();
			
			sb.append("<row  id=\""+ LMan.getId()  +"\">");
			sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderCode + "^/adrm/editOrder.html?id="+LMan.getId()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ code +"]]></cell>");
			if(!publishStartDate.equals(new Integer(0))){
				sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getOrderPublic().getPublishStartDate().toString(),"yyyy/MM/dd") +"]]></cell>");
			}else{
				sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			}
			
			if(!publishEndDate.equals(new Integer(0))){
				sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getOrderPublic().getPublishEndDate().toString(),"yyyy/MM/dd") +"]]></cell>");
			}else{
				sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			}
//			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getOrderPublic().getPublishEndDate().toString(),"yyyy/MM/dd") +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(LMan.getOrderPublic().getMoneyRealpay())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(LMan.getOrderPublic().getMoneyIn())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StateName +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	public Collection getCollectionsOrderList(String queryString, String type) {
		
		boolean isOrderDisplayRelcode = SysParamUtil.getOrderDisplayRelcodeParam();
		boolean isOrderDisplayIncome = SysParamUtil.getOrderDisplayIncomeParam();
		String tvName = SysParamUtil.getTvNameParam();
		
		Order orderParam =  this.buildParamBy(queryString);
		Collection ls =  this.getOrdersPageByDayScroll(true,orderParam,0,-1);
		

		
//		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 12;
		
//		if(!isOrderDisplayRelcode) cols =11;
		
		if(!isOrderDisplayRelcode){
			 cols--;
			if(!isOrderDisplayIncome){
				 cols--;
			}			
		}else{
			if(!isOrderDisplayIncome){
				 cols--;
			}	
		}
		
		
		
		
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			Order order =  (Order)it.next();
			String orderCode = StringUtil.null2String(order.getOrderCode());
			String relationCode = StringUtil.null2String(order.getRelationCode());
			String contractCode = StringUtil.null2String(order.getContract().getCode());
			String customerName = StringUtil.null2String(order.getCustomer().getCustomerName());
			String matterName = StringUtil.null2String(order.getOrderPublic().getMatterName());
			String orderMeno = StringUtil.null2String(order.getOrderMeno());
			String startDate = DateUtil.SetDateFormat(order.getOrderPublic().getPublishStartDate().toString(),"MM/dd");
			String endDate = DateUtil.SetDateFormat(order.getOrderPublic().getPublishEndDate().toString(),"MM/dd");
			String moneyRealpay = StringUtil.doubleFormat2(order.getOrderPublic().getMoneyRealpay());
			String moneyIn = StringUtil.doubleFormat2(order.getOrderPublic().getMoneyIn());		
			String fullName = StringUtil.null2String(order.getUser().getFullName());
			String orderState = StringUtil.null2String(order.getOrderState().getName());
			
			if(orderMeno.length()>6) orderMeno = orderMeno.substring(0,6);
			
			

			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				if(isOrderDisplayRelcode){
					if(isOrderDisplayIncome){
						for(int i=0;i<cols+1;i++){
							switch(i){
						
								case 1:
									fObject.setLable(orderCode);break;
								case 2:
									fObject.setValue1(relationCode);break;
								case 3:
									fObject.setValue2(contractCode);break;
								case 4:
									fObject.setValue3(customerName);break;
								case 5:
									fObject.setValue4(matterName);break;
								case 6:
									fObject.setValue5(orderMeno);break;
								case 7:
									fObject.setValue6(startDate);break;
								case 8:	
									fObject.setValue7(endDate);break;
								case 9:
									fObject.setValue8(moneyRealpay);break;
								case 10:
									fObject.setValue9(moneyIn);break;
								case 11:
									fObject.setValue10(fullName);break;
								case 12:	
									fObject.setValue11(orderState);break;							
								default :
							}
						}						
					}else{
						for(int i=0;i<cols+1;i++){
							switch(i){
						
								case 1:
									fObject.setLable(orderCode);break;
								case 2:
									fObject.setValue1(relationCode);break;
								case 3:
									fObject.setValue2(contractCode);break;
								case 4:
									fObject.setValue3(customerName);break;
								case 5:
									fObject.setValue4(matterName);break;
								case 6:
									fObject.setValue5(orderMeno);break;
								case 7:
									fObject.setValue6(startDate);break;
								case 8:	
									fObject.setValue7(endDate);break;
								case 9:
									fObject.setValue8(moneyRealpay);break;
								case 10:
									fObject.setValue9(fullName);break;
								case 11:
									fObject.setValue10(orderState);break;					
								default :
							}
						}
					}

					
				}else{
					
					if(isOrderDisplayIncome){
						for(int i=0;i<cols+1;i++){
							switch(i){
						
								case 1:
									fObject.setLable(orderCode);break;
								case 2:
									fObject.setValue1(contractCode);break;
								case 3:
									fObject.setValue2(customerName);break;
								case 4:
									fObject.setValue3(matterName);break;
								case 5:
									fObject.setValue4(orderMeno);break;
								case 6:
									fObject.setValue5(startDate);break;
								case 7:	
									fObject.setValue6(endDate);break;
								case 8:
									fObject.setValue7(moneyRealpay);break;
								case 9:
									fObject.setValue8(moneyIn);break;
								case 10:
									fObject.setValue9(fullName);break;
								case 11:	
									fObject.setValue10(orderState);break;							
								default :
							}
						}
					}else{
						for(int i=0;i<cols+1;i++){
							switch(i){
						
								case 1:
									fObject.setLable(orderCode);break;
								case 2:
									fObject.setValue1(contractCode);break;
								case 3:
									fObject.setValue2(customerName);break;
								case 4:
									fObject.setValue3(matterName);break;
								case 5:
									fObject.setValue4(orderMeno);break;
								case 6:
									fObject.setValue5(startDate);break;
								case 7:	
									fObject.setValue6(endDate);break;
								case 8:
									fObject.setValue7(moneyRealpay);break;
								case 9:
									fObject.setValue8(fullName);break;
								case 10:
									fObject.setValue9(orderState);break;
						
								default :
							}
						}
					}					
					
					

				}
			
			}
			valuecoll.add(fObject);
		}
//		CollectionUtils.addAll(coll,valuecoll.iterator());		
		
		return valuecoll;
	}
	
	
	 public  String getOrderEditRedirect(String redirectUrl,String redirectUrl2) throws ServletException, IOException {

	    	
	    	System.out.println("getRedirectEdit1>>>>>>>>>>>>>>>>>>>"+ redirectUrl);
//	    	System.out.println("getRedirectEdit2>>>>>>>>>>>>>>>>>>>"+ redirectUrl2);
	    	
	    	 WebContext ctx = WebContextFactory.get();
	    	 HttpServletRequest request = ctx.getHttpServletRequest();
	    	 HttpServletResponse response = ctx.getHttpServletResponse();
	    	response.setContentType("text/html; charset=gb2312");
	    	
	    	ServletContext sc = ctx.getServletContext();
	    	RequestDispatcher rd = null;
	    	rd = sc.getRequestDispatcher("/index.jsp"); //定向的页面
	    	rd.forward(request, response);
	    	
	    	
//	    	 WebContext ctx = WebContextFactory.get();
//	         HttpServletRequest request = ctx.getHttpServletRequest();
//	         HttpServletResponse response = ctx.getHttpServletResponse();
	         
//	         response.setContentType("text/xml; charset=UTF-8"); 
//	         response.sendRedirect("http://www.sina.com");
	         
	         return "";
//	     	return ctx.forwardToString("/login.jsp");
	        
//	         try {
//				return ctx.forwardToString("/simpletext/forward.html");
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			return "";

	         
//	         RequestDispatcher dispatcher=request.getRequestDispatcher(redirectUrl);
//	    	 try {
//				dispatcher.forward(request, response);
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	         
//	         try {
//	        	response.setContentType("text/html; charset=gbk");
////	        	 response.sendRedirect("/login.jsp");
//	        	 response.sendRedirect("http://www.sina.com");
//	       
//
//				return ;
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}
			
//			return "1";
//	         HttpSession session = req.getSession();
//	    	 String value = (String) session.getAttribute(loginName);
	    	 
	  }
	 
//	  private static final String ADD_ORDER_SQL = "INSERT INTO tb_order(version,create_by,create_date,modify_by,modify_date,order_code,relation_code,contract_id,order_category_id,user_id,order_meno,is_ckecked,publish_memo,contract_payment_id,customer_id)"
//		         + " SELECT version,create_by,create_date,modify_by,modify_date,order_code,relation_code,contract_id,order_category_id,user_id,order_meno,is_ckecked,publish_memo,contract_payment_id,customer_id FROM tb_order WHERE order_id =?";
//
////	  						SELECT version,create_by,create_date,modify_by,modify_date,order_code,relation_code,contract_id,order_category_id,user_id,order_meno,is_ckecked,publish_memo,contract_payment_id,customer_id FROM tb_order WHERE order_id =?";
//	  
//		public void getOrderClone(String orderId) {
//			
//	        Connection con = null;
//	        PreparedStatement psmt = null;
//	        try {
//	            con = dao.getDefaultDataSource().getConnection();
//	            psmt = con.prepareStatement(ADD_ORDER_SQL); 
//	            psmt.setString(1,  orderId);
//	            System.out.println("orderId>>>>>>>"+ orderId);
//	            psmt.execute();
//	            
//	        } catch (SQLException e) {
//	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//	        } finally {
//	            closeStatement(psmt);
//	            closeConnection(con);
//	        }
//		}
	 
	 
	 

		
	 public String  saveOrderClone(String orderId,String loginUserId) {
		 System.out.println("saveOrderClone      orderId>>>>>>>"+ orderId);
		 boolean autoRelationCodeParam = SysParamUtil.getAutoRelationCodeParam();
		 //save order
		 Order orderClass = dao.getOrderCopy(new Long(orderId));
		 
		 String orderCategoryName = orderClass.getOrderCategory().getName();
//		 int orderCategoryCalculate = orderClass.getOrderCategory().getCalculateAuto().intValue();
		 
//		 System.out.println("saveOrderClone      orderClass  getCustomerId>>>>>>>"+ orderClass.getCustomerId());
		 
		 orderClass.setId(null);
//		 temStr  0 组织编号 1 时段类型（1时段 3栏目）2、客户类型
		 setOrderCode(orderClass); 
		 
		 if(autoRelationCodeParam){
			 String orgId =orderClass.getOrgId().toString();
			 String resSort ="1";
			 String customerCategoryId = orderClass.getCustomer().getCustomerCategoryId();
			 if(orderClass.getRelationCode().indexOf("L")>-1) resSort ="2";
			 orderClass.setTempStr(orgId+","+resSort+","+customerCategoryId);
			 setRelationCode(orderClass); 
		 }

		 orderClass.setCreateDate(new Date());
		 orderClass.setModifyDate(new Date());
		 orderClass.setModifyBy(new Long(loginUserId));
		 orderClass.setCreateBy(new Long(loginUserId));
		 orderClass.setIsCkecked(new Long(0));
			
		 Long order_id = dao.saveOrderCopy(orderClass);

//		 System.out.println("saveOrderClone    orderId>>>>>>>"+ order_id);
		 
		 //save orderDetail
		 
		 
			Map mpcopy = new HashMap();
			mpcopy.put("orderId",orderId);
//			mpcopy.put("orderDetailIdList",idsList);
//			List ls = dao.getOrderDetailByOrderIdCopy(mpcopy);
		 List detailList = orderDetailDao.getOrderDetailByOrderIdCopy(mpcopy);
		 
		 Iterator it1= detailList.iterator();
		 while(it1.hasNext()){
			 OrderDetail orderDetail =  (OrderDetail)it1.next();
			 Long orderDetailId = orderDetail.getId();
			 orderDetail.setId(null);
			 orderDetail.setCreateDate(new Date());
			 orderDetail.setModifyDate(new Date());
			 orderDetail.setOrderId(order_id);
			 orderDetail.setMoneyBalance(new Double(0));
			 orderDetail.setMoneyIn(new Double(0));
			 orderDetail.setResourceSpecificId(new Long(0));
			 
			 
			 Long orderDetail_id = orderDetailDao.saveOrderDetailCopy(orderDetail);
			 Long resourceInfo_id = orderDetail.getResourceInfoId();
			 String ad_length = StringUtil.getNullValue(orderDetail.getMatterLength(),"0");
//			 ad_length = "0.0".equals(ad_length)?"0":ad_length;
			 
			 
			 orderDetail.setId(orderDetail_id);
	
//			 System.out.println("saveOrderClone   old  orderDetailId>>>>>>>"+ orderDetailId);
//			 System.out.println("saveOrderClone   new  orderDetail_id>>>>>>>"+ orderDetail_id);
			 
			 
             DayInfo dayInfo = new DayInfo();
			 dayInfo.setResourceId(resourceInfo_id);
			 dayInfo.setStartDate(orderDetail.getPublishStartDate());
			 dayInfo.setEndDate(orderDetail.getPublishEndDate());
			 Map resMap1  = ResourceUtil.getDayInfosMap(dayInfo);			 

			 List orderDayList = orderDayInfoDao.getOrderDayInfosCopy(orderDetailId);
			 
//			 System.out.println("saveOrderClone   orderDayList.size()>>>>>>>"+ orderDayList.size());
			 
			 Iterator it2 = orderDayList.iterator();
//			 OrderDayInfo[] orderDayInfos = new OrderDayInfo[orderDayList.size()];
			 Map  newDayInfosMap = new HashMap();
//			 int i = 0;
			 while(it2.hasNext()){
				 OrderDayInfo orderDayInfo =  (OrderDayInfo)it2.next();
//				 System.out.println("saveOrderClone        orderDayInfo>>>>>>>"+ orderDayInfo.getId());
				 orderDayInfo.setId(null);
				 orderDayInfo.setOrderDetailId(orderDetail_id);
//				 orderDayInfos[i++] = orderDayInfo;
				 orderDayInfoDao.saveOrderDayInfo(orderDayInfo);
				 String key = resourceInfo_id.toString() +","+orderDayInfo.getPublishDate().toString();
				 int adTimes = Integer.parseInt(StringUtil.getNullValue(orderDayInfo.getAdDayTimes(),"0"));
				 double used_ad = adTimes* Double.parseDouble(ad_length);
				 DayInfo day_info = (DayInfo)resMap1.get(key);
//				 double used_rs = Double.parseDouble(StringUtil.getNullValue(day_info.getUsed(),"0"));
//				 String usedSum = String.valueOf(used_rs + used_ad);
//				 usedSum = "0.0".equals(usedSum)?"0":usedSum;
				
				 if(newDayInfosMap.containsKey(key)){
					 DayInfo day_info_map = (DayInfo)newDayInfosMap.get(key);
					 used_ad =  used_ad +Double.parseDouble(StringUtil.getNullValue(day_info_map.getChangedValue(),"0"));
					 day_info_map.setChangedValue(new Double(used_ad));
				 }else{
					 day_info.setChangedValue(new Double(used_ad));
					 newDayInfosMap.put(key,day_info); 
				 }

			 }
			 
			 ResourceUtil.updateDayInfos(newDayInfosMap);
			 
//			 Map resMap2  = new HashMap();
//			 OrderDayInfoUtil.getOrderDayInfoMap(orderDetail,orderDayInfos,resMap2);
			 
			 
			 
			           
		 }
		 
		//保存付款信息 

		 
		 if("正常订单".equals(orderCategoryName)||"协约订单".equals(orderCategoryName)){
			 List ls = contractPaymentManager.getContractPaymentsCopy(new Long(orderId));
//			 System.out.println("saveOrderClone   contractPayment orderId>>>>>>>"+ orderId);
//			 System.out.println("saveOrderClone   contractPayment List.size()>>>>>>>"+ ls.size());
			 Iterator it2 = ls.iterator();
			 while(it2.hasNext()){
				 ContractPayment payment =  (ContractPayment)it2.next();
				 payment.setId(null);
				 payment.setOrderId(order_id);
				 contractPaymentManager.saveContractPayment(payment);
			 }
		 }
		 
		 
		 return order_id.toString();
		 
	 }
		
		
		
		
	    /**
	     * Cleanup helper method that closes the given <code>Statement</code>
	     * while ignoring any errors.
	     */
	    protected void closeStatement(Statement statement) {
	        if (null != statement) {
	            try {
	                statement.close();
	            } catch (SQLException ignore) {
	            }
	        }
	    }


	    protected void closeConnection(Connection con) {
	        if (null != con) {
	            try {
	                con.close();
	            } catch (SQLException ignore) {
	            }
	        }
	    }	
		private void excuteSql(String sql){
			try {
				dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
			} catch (SQLException e) {
				 System.out.println(sql+"/n;系统数据库升级到失败");
//				e.printStackTrace();
			}
		}
		
		
		 
		
		private Collection getCollectionsForeSpec(Map searchMap){
			
			String beginDate = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("beginDate")));
			String endDate=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("endDate")));
			String[] resourceId =    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("resourceId"))).split(",");
			String specificId=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("specificId")));	
			String[] userIds =    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("userIds"))).split(",");
			String customerName=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("customerName")));	
			String publishMemo=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("publishMemo")));
			
//			System.out.println("userIds>>>>>>>>"+userIds.length);
//			System.out.println("userIds>>>>>>>>"+userIds[0]);
//			System.out.println(">111111111>>>"+(" ".equals(userIds[0])));
//			System.out.println(">22222222222>>>"+("".equals(userIds[0])));
			
	
			Map mp = new HashMap();
			List resourceIdList =new ArrayList();
			List userIdList =new ArrayList();

			CollectionUtils.addAll(resourceIdList,resourceId);
			
			if(userIds.length > 0 && !"".equals(userIds[0])){
				CollectionUtils.addAll(userIdList,userIds);
			}
			
			
			mp.put("beginDate",beginDate);
			mp.put("endDate",endDate);
			mp.put("resourceIdList",resourceIdList);
			mp.put("specificId",specificId);
			
			mp.put("UserIdList",userIdList);
			mp.put("customerName",customerName);
			mp.put("publishMemo",publishMemo);
			
			return  dao.getSpecificInfo(mp);
		}
		
		public String getSpecificInfo2(String queryStr) {
		
			Map searchMap = StringUtil.convertQueryStringtoMap(queryStr);
			
//			System.out.println("beginDate>>>>>>>>"+searchMap.get("beginDate"));
//			System.out.println("endDate>>>>>>>>"+searchMap.get("endDate"));
//			System.out.println("resourceId>>>>>>>>"+searchMap.get("resourceId"));
//			System.out.println("specificId>>>>>>>>"+searchMap.get("specificId"));
//			System.out.println("customerName>>>>>>>>"+searchMap.get("customerName"));
//			System.out.println("publishMemo>>>>>>>>"+searchMap.get("publishMemo"));
//			System.out.println(" userIds>>>>>>>>"+searchMap.get("userIds"));
			
			List ls = (List)getCollectionsForeSpec(searchMap);
			
			return makeTreeGridXML(ls);
		}
		
		
		public Collection getCollections(Map searchMap,String type){
				
			
				List ls = (List)getCollectionsForeSpec(searchMap);
				
				Collection coll = new ArrayList();
				List valuecoll = new ArrayList();
				
				int cols = 9;
				
				
				for(Iterator it = ls.iterator();it.hasNext();){
					
					OrderDetail orderDetail = (OrderDetail)it.next();
					Integer publishStartDate = orderDetail.getOrderPublic().getPublishStartDate();
					String publishDate = publishStartDate.intValue()==0?"":publishStartDate.toString();
					String specific = orderDetail.getSpecific().getName();
					specific = specific ==null?"":specific;
					
					FusionChartObject fObject = new FusionChartObject();
					
					if(type.equals("report")){
						for(int i=0;i<cols+1;i++){
							switch(i){
								case 1:
									fObject.setLable(DateUtil.SetDateFormat(publishDate,"yyyy/MM/dd"));break;
								case 2:
									fObject.setValue1(orderDetail.getOrder().getOrderCode());break;
								case 3:
									fObject.setValue2(orderDetail.getOrder().getCustomer().getCustomerName());break;
								case 4:
									fObject.setValue3(orderDetail.getResource().getMemo());break;
								case 5:
									fObject.setValue4(specific);break;
								case 6:
									fObject.setValue5(orderDetail.getPublishMemo());break;
								case 7:
									fObject.setValue6(orderDetail.getMatter().getName());break;
								case 8:
									fObject.setValue7(orderDetail.getMatter().getEdit());break;
								case 9:
									fObject.setValue8(orderDetail.getMatter().getLength());break;
								default :
							}
						}
					}
					valuecoll.add(fObject);
				}
				CollectionUtils.addAll(coll,valuecoll.iterator());
				
				return coll;
			}		
		
		private static  String makeTreeGridXML(List all){
			StringBuffer sb  = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");  
			
			int i=0;
			int heji=0;
			for(Iterator it = all.iterator();it.hasNext();){
				OrderDetail orderDetail = (OrderDetail) it.next();
				String specific = orderDetail.getSpecific().getName();
				specific = specific ==null?"":specific;
				String length = orderDetail.getMatter().getLength();
				heji += length==null?0:(int)Double.parseDouble(length);
				Integer publishStartDate = orderDetail.getOrderPublic().getPublishStartDate();
				String publishDate = publishStartDate.intValue()==0?"":publishStartDate.toString();
				String orderCode = orderDetail.getOrder().getOrderCode();
				String orgId = orderDetail.getOrder().getOrgId().toString();
				sb.append("<row  id=\""+ i++  +"\">");
				sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(publishDate,"yyyy/MM/dd")+"]]></cell>");
				
//				sb.append("<cell><![CDATA["+ orderDetail.getOrder().getOrderCode()+"]]></cell>");
				
				sb.append("<cell><![CDATA["+ orderCode + "^/adrm/editOrder.html?id="+orderDetail.getOrder().getId().toString()  +"&orgId=" + orgId +"]]></cell>");
				
				sb.append("<cell><![CDATA["+ orderDetail.getOrder().getCustomer().getCustomerName()+"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetail.getResource().getMemo()+"["+orderDetail.getResource().getResourceName()+"]]]></cell>");
				sb.append("<cell><![CDATA["+ specific+"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetail.getPublishMemo()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetail.getMatter().getName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetail.getMatter().getEdit()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ length +"]]></cell>");			
				sb.append("</row>");
			 }
			sb.append("<row  id=\""+ i++  +"\">");
			sb.append("<cell><![CDATA["+"合计:"+"]]></cell>");
			sb.append("<cell><![CDATA["+""+"]]></cell>");
			sb.append("<cell><![CDATA["+""+"]]></cell>");
			sb.append("<cell><![CDATA["+ ""+"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ ""+"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ heji +"]]></cell>");
			sb.append("</row>");
			
			sb.append("</rows>");
			
			return sb.toString();
		}
		

		
//		广告批量停播出
		public String saveOrderStopBro(Order order, String[] orderDetailIds,int startDate,int endDate){
			
			//查找需要停播的广告日播出，删除没有平帐的日播出 ,如果已经平过帐，则修改播出次数为0，日应收为0。
			Map mp = new HashMap();
			String retMsg = "";
			String orderCategoryMain  = order.getOrderCategory().getValue();
			Long paymentId = order.getPaymentId();
//			Double moneyRealpay = 	order.getOrderPublic().getMoneyRealpay();
			
			Double moneyRealpay = 	order.getOrderPublic().getMoneyRealpay();
			

			
			String loginUser = order.getLoginUser();
			Long modifyBy = order.getModifyBy();
			Long orderId = order.getId();
			Long isCkecked = order.getIsCkecked();
			String orderState = order.getOrderState().getName();

//			 System.out.println("saveOrderDetailStopBro >>>>>66666666666666         7777777777777777           8888888888888  order.getOrderPublic().getMoneyRealpay() vvvvvvvvvvvvvvv  " +moneyRealpay) ;
//			 System.out.println("saveOrderDetailStopBro >>>>>66666666666666     11    7777777777777777           8888888888888  orderDetail start_Date  " +startDate) ;
//			 System.out.println("saveOrderDetailStopBro >>>>>66666666666666     11    7777777777777777           8888888888888  orderDetail end_Date  " +endDate) ;
			 
			
			List orderDetailIdList = new ArrayList();
			CollectionUtils.addAll(orderDetailIdList,orderDetailIds);
			OrderDetail orderDetailParam = new OrderDetail();
			orderDetailParam.setDetailIdsIdList(orderDetailIdList);
			List orderDetails = orderDetailDao.getOrderDetails(orderDetailParam);
			
			Iterator it = orderDetails.iterator();
			
			
//			 System.out.println("saveOrderDetailStopBro orderDetails.size()>>>>>  vvvvvvvvvvv  " +orderDetails.size()) ;


			while(it.hasNext()){
				
				   OrderDetail orderDetail = (OrderDetail)it.next();
			
				   orderDetail.setOrderCategoryMain(orderCategoryMain);
				   orderDetail.setParentId(new Long(0));
				   orderDetail.setPaymentId(paymentId);
				   orderDetail.setIsCompages(new Boolean(false));
				   orderDetail.setIsSaveOrderDayInfo(new Boolean(true));
				   
//				   Integer start_Date = orderDetail.getOrderPublic().getPublishStartDate();
//				   Integer end_Date = orderDetail.getOrderPublic().getPublishEndDate();
				   
						if("1".equals(orderCategoryMain)){
							orderDetail.setMoneyRealpay(orderDetail.getOrderPublic().getMoneyRealpay());
							moneyRealpay = orderDetail.getOrderPublic().getMoneyRealpay();
						}else{
							orderDetail.setMoneyRealpay(moneyRealpay);
						}
				   
				   
				   
//				   Double moneyRealpayDetail =  orderDetail.getOrderPublic().getMoneyRealpay();
				   
//				   System.out.println("saveOrderDetailStopBro >>>>>66666666666666         7777777777777777           8888888888888  orderDetail.getOrderPublic().getMoneyRealpay() vvvvvvvvvvvvvvv  " +orderDetail.getOrderPublic().getMoneyRealpay()) ;
					

//				   System.out.println("saveOrderDetailStopBro orderDetail.getId >>>>>  vvvvvvvv  " +orderDetail.getId().toString()) ;

				   
				   Map newDayInfosMap = new HashMap();	  

				 		Long orderDetailId = orderDetail.getId();
				 		Long resourceInfo_id = orderDetail.getResourceInfoId();
				 		String matterLength = orderDetail.getMatter().getLength();
						String spec_orderDay = StringUtil.getNullValue(orderDetail.getSpecific().getPosition(),"");
				 		
				 		double changeResInfo = -Double.parseDouble(StringUtil.getNullValue(matterLength,"0"));

				 		DayInfo dayInfo = new DayInfo();
					 dayInfo.setResourceId(resourceInfo_id);
					 dayInfo.setStartDate(new Integer(startDate));
					 dayInfo.setEndDate(new Integer(endDate));
					 Map resMap1  = ResourceUtil.getDayInfosMap(dayInfo);	 
	 
					 mp.put("orderDetailId",orderDetailId);
					 mp.put("startDate",new Integer(startDate));
					 mp.put("endDate",new Integer(endDate));
					 List ls3 = orderDayInfoDao.getRelIncomeByStartEndDate(mp);

					 double  moneyIn = 0;
					 double relIncome = 0;
					 int dayTimes = 0;
					 int sumTimes1 = orderDetail.getOrderPublic().getTimes().intValue();
					 int sumTimes = orderDetail.getOrderPublic().getTimes().intValue();
					 
//						System.out.println("saveOrderDetailStopBro sumTimes>>>>>  ccccccc     bbbbbbbbbbbbbbb         vvvvvvvv  " +sumTimes) ;
											
					 
					 
					 List removeIdList =  new ArrayList();
					 List updateDayinfoList =  new ArrayList();
					
//					 int begin_date = 99999999;
//					 int end_date = 0;
					 
					 for(Iterator it2 = ls3.iterator();it2.hasNext();){
						 		OrderDayInfo dinfo = (OrderDayInfo)it2.next();
								String key = resourceInfo_id.toString() +","+dinfo.getPublishDate().toString();
//								Integer publishDate = dinfo.getPublishDate();
//								if(publishDate.intValue()<begin_date){
//									begin_date = publishDate.intValue();
//								}
//								
//								if(publishDate.intValue()>end_date){
//									end_date = publishDate.intValue();
//								}
								
								DayInfo day_info = (DayInfo)resMap1.get(key);	
								day_info.setChangedValue(new Double(changeResInfo*dinfo.getAdDayTimes().intValue()));
								String spec_res = day_info.getSpecific();
								//1 包含  2 不包含 3、追加  4 其它排除空的
								 if(!"".equals(spec_orderDay)){
									 if(spec_res.indexOf(spec_orderDay)>-1){
										 spec_res = StringUtil.selectStr(spec_res,spec_orderDay,2);
										 day_info.setSpecific(spec_res);
									 	}		 
								 }
								
								
								newDayInfosMap.put(day_info.getId(),day_info);

								relIncome = dinfo.getDayRelIncome().doubleValue();
								moneyIn = dinfo.getDayRelPuton().doubleValue();
								dayTimes = dinfo.getAdDayTimes().intValue();
								
//								System.out.println("saveOrderDetailStopBro dinfo.getPublishDate() >>>>>  ccccccc     bbbbbbbbbbbbbbb         vvvvvvvv  " +dinfo.getPublishDate()) ;
								
								if(moneyIn >0){
									dinfo.setAdDayTimes(new Integer(0));
									dinfo.setDayRelIncome(new Double(0));
									dinfo.setIsPublished(new Integer(0));
									updateDayinfoList.add(dinfo);
								}else{
//									 System.out.println("saveOrderDetailStopBro dinfo.getPublishDate() >>>>>  ccccccc     bbbbbbbbbbbbbbb         vvvvvvvv  " +dinfo.getPublishDate()) ;
									removeIdList.add(dinfo.getId());
								}
								
								if("1".equals(orderCategoryMain)){
									
									moneyRealpay = new Double(moneyRealpay.doubleValue() -relIncome);
									
//									moneyRealpayDetail = new Double(moneyRealpayDetail.doubleValue() -relIncome);
								}

								
								sumTimes = sumTimes - dayTimes;
								

						 }
					 
					 
//						System.out.println("saveOrderDetailStopBro sumTimes1>>>>>  ccccccc     bbbbbbbbbbbbbbb         vvvvvvvv  " +sumTimes1) ;
//						System.out.println("saveOrderDetailStopBro moneyRealpay>>>>>  ccccccc     bbbbbbbbbbbbbbb         vvvvvvvv  " +moneyRealpay) ;

					 
					 
					 OrderDetail orderDetailCur = new OrderDetail();
					 ConvertUtil.copyBeanProperties2(orderDetailCur,orderDetail);
					 
					 orderDetail.setMoidType("1");
					 orderDetail.setOrder(order);
					 
					 
					 OrderDayInfo[] orderDayInfos3 = (OrderDayInfo[])ls3.toArray(new OrderDayInfo[ls3.size()]);
					 orderDetail.setOrderDayInfos(orderDayInfos3);
//					 orderDetail.setMoneyRealpay(moneyRealpay);
//					 orderDetail.getOrderPublic().setTimes(new Integer(sumTimes1));
					 

					 orderDetailCur.setMoidType("1");
					 orderDetailCur.setOrder(order);
//					 orderDetailCur.setMoneyRealpay(moneyRealpay);
//					 orderDetailCur.setModifyBy(modifyBy);
//					 orderDetailCur.setModifyDate(new Date());
//					 orderDetailCur.setCreateDate(new Date());
//					 orderDetailCur.getOrderPublic().setTimes(new Integer(sumTimes));
//					 orderDetailCur.getOrderPublic().setPublishStartDate(new Integer(begin_date));
//					 orderDetailCur.getOrderPublic().setPublishEndDate(new Integer(end_date));
//					 orderDetailCur.getOrderPublic().setMoneyRealpay(moneyRealpay);
					 orderDetailCur.getOrder().setLoginUser(loginUser);

					 
					 
//					 System.out.println("saveOrderDetailStopBro remoceOrderDays >>>>>  vvvvvvvv  ") ;
					 
					 if(removeIdList.size()>0) {
//						 System.out.println("saveOrderDetailStopBro removeIdList.size() >>>>>  vvvvvvvv  "+removeIdList.size()) ;
						 OrderDayInfoUtil.remoceOrderDays(removeIdList);
						 
					 }			
					 
					 
//					 System.out.println("saveOrderDetailStopBro updateDayinfoList.size() >>>>>  vvvvvvvv  " + updateDayinfoList.size()) ;
					 
					 if(updateDayinfoList.size()>0) { 
//						 Long[] l = (Long[]) list.toArray();
						 
						 OrderDayInfo[] orderDayInfos = (OrderDayInfo[])updateDayinfoList.toArray(new OrderDayInfo[updateDayinfoList.size()]);
						 
//						 System.out.println("saveOrderDetailStopBro updateDayinfoList.size() >>>>>  vvvvvvvv  " + updateDayinfoList.size()) ;
						 
						 OrderDayInfoUtil.addOrderDayInfos(orderDetail,orderDayInfos);
						 }			
					 
//					 System.out.println("saveOrderDetailStopBro addOrderDayInfos >>>>>  vvvvvvvv  ") ;
					 
					 
//					 System.out.println("saveOrderDetailStopBro newDayInfosMap.size() >>>>>  vvvvvvvv  "+newDayInfosMap.size()) ;
					 
					 //修改资源信息
					 if(newDayInfosMap.size()>0) { 
//						 System.out.println("saveOrderDetailStopBro newDayInfosMap.size() >>>>>  vvvvvvvv  "+newDayInfosMap.size()) ;
						 ResourceUtil.updateDayInfos(newDayInfosMap);
						 }				
					 
//					 System.out.println("saveOrderDetailStopBro updateOrderDayRealpay >>>>>  vvvvvvvv  ") ;
					 
					 OrderDetailManager orderDetailManager = ServiceLocator.getOrderDetailManager();
						//写订单日志
//					 orderDetail.getOrderPublic().setPublishStartDate(start_Date);
//					 orderDetail.getOrderPublic().setPublishEndDate(end_Date);
					 
//					 System.out.println("saveOrderDetailStopBro >>>>>66666666666666         7777777777777777           8888888888888  orderDetail start_Date  " +start_Date) ;
//					 System.out.println("saveOrderDetailStopBro >>>>>66666666666666         7777777777777777           8888888888888  orderDetail end_Date  " +end_Date) ;
					 

					 orderDetail.getOrderPublic().setTimes(new Integer(sumTimes1));
					 orderDetailCur.getOrderPublic().setTimes(new Integer(sumTimes));
//					 System.out.println("saveOrderDetailStopBro >>>>>66666666666666         7777777777777777           8888888888888  orderDetailCur orderDetail getTimes " +orderDetail.getOrderPublic().getTimes()) ;
//					 System.out.println("saveOrderDetailStopBro >>>>>66666666666666         7777777777777777           8888888888888  orderDetailCur orderDetailCur  getTimes" +orderDetailCur.getOrderPublic().getTimes()) ;
					 String msg = orderDetailManager.saveOrderLog(orderDetail,orderDetailCur);
					 
					 
//					 System.out.println("updateOrderDayRealpay orderDetail.getMoneyRealpay() >>>>>  1111111111111111111111111111            vvvvvvvv  "+orderDetail.getMoneyRealpay()) ;
					 
					 orderDetailManager.updateOrderDayRealpay(orderDetail,false);
					 
//					 	System.out.println("saveOrderDetailStopBro saveOrderDetailPublicInfo >>>>>  vvvvvvvv  ") ;
					 	orderDetailManager.saveOrderDetailPublicInfo(orderDetail,1);  

//					System.out.println("saveOrderDetailStopBro saveOrderLog >>>>>  vvvvvvvv  ") ;
					 
//					  Order or = orderDetail.getOrder();
//					  or.setLoginUser(loginUser);
//					  or.setId(orderId);
//					  or.setIsCkecked(isCkecked);
//					  or.setOrderState();

				   
				  
				   
				   if(!it.hasNext()){
					   retMsg = msg;
				   		}
				   
//				   System.out.println("saveOrderDetailStopBro retMsg end >>>>>  vvvvvvvv  " + retMsg) ;
					 
						 
		}
			
			
//			//修改催款信息
//			ContractPaymentManager contractPaymentManager = ServiceLocator.getContractPaymentManager();
//			int mode = Integer.parseInt(orderCategoryMain);
//			String contractId = StringUtil.getNullValue(order.getContractId(),"0");
////			String orderId= order.getId().toString();
//			String customerId = order.getCustomerId().toString();
//			String year = order.getVersion().toString();
//			contractPaymentManager.saveContractPaymentByOrder(mode,contractId,orderId.toString(),customerId,moneyRealpay.doubleValue(),false,"0",year);
//			

			

			return retMsg;
		
		}
		public String saveOrderStopBro2(Order order) {
			
			System.out.println("saveOrderStopBro2  end >>>>>   99999999999999999999       88888888888888888888888          6666666666666666666 vvvvvvvv  " + order.toString()) ;
			// TODO Auto-generated method stub
			return null;
		}
		
		public String saveOrderSpec(Order order, String[] orderDetailIds,int startDate,int endDate,String specValue,Long specId,String specTXT){
			Map mp = new HashMap();
			String loginUser = order.getLoginUser();
			List orderDetailIdList = new ArrayList();
			CollectionUtils.addAll(orderDetailIdList,orderDetailIds);
			OrderDetail orderDetailParam = new OrderDetail();
			orderDetailParam.setDetailIdsIdList(orderDetailIdList);
			List orderDetails = orderDetailDao.getOrderDetails(orderDetailParam);
			Iterator it = orderDetails.iterator();
			String retMsg = "";
			Date now_date = new Date();
			 Map newDayInfosMap = new HashMap();
			
			while(it.hasNext()){
				 OrderDetail orderDetail = (OrderDetail)it.next();
				 OrderDetail orderDetailOld = new OrderDetail();
				 
				 Long specId_old = orderDetail.getResourceSpecificId();
				 
				 Integer startDate_sour = orderDetail.getOrderPublic().getPublishStartDate();
				 Integer endDate_sour = orderDetail.getOrderPublic().getPublishEndDate();
				 
				 if(startDate_sour != null){


					 orderDetail.setPublishStartDate(orderDetail.getOrderPublic().getPublishStartDate());
					 orderDetail.setPublishEndDate(orderDetail.getOrderPublic().getPublishEndDate());
					 ConvertUtil.copyBeanProperties2(orderDetailOld,orderDetail);
					 orderDetailOld.setMemo(orderDetail.getSpecific().getName());
					 
//					 System.out.println("saveOrderSpec  end >>>>>   99996666666 vvvvvvvv  " + orderDetail.getSpecific().getPosition()) ;
//					 System.out.println("saveOrderSpec  end >>>>>   99996666666 vvvvvvvv  " + orderDetail.getOrderPublic().getPublishStartDate()) ;
//					 System.out.println("saveOrderSpec  end >>>>>   99996666666 vvvvvvvv  " + orderDetail.getOrderPublic().getPublishEndDate()) ;
					 
					 		Long resourceInfo_id = orderDetail.getResourceInfoId();
					 		Long orderDetail_id = orderDetail.getId();
					 		String spec_orderDay = StringUtil.getNullValue(orderDetail.getSpecific().getPosition(),"");
					 		
	 
						 
						 mp.put("orderDetailId",orderDetail_id);
						 mp.put("startDate",startDate_sour);
						 mp.put("endDate",endDate_sour);
						 List ls_source = orderDayInfoDao.getRelIncomeByStartEndDate(mp);
						 int size_source_bak = ls_source.size();
						 List ls_targ = new ArrayList();
						 
//							先把冲突的过滤出来
							 List tarList1 = new ArrayList();  //不冲突
							 List tarList2 = new ArrayList();  //冲突
						 
						 OrderDetail orderDetail_temp = new OrderDetail();
						 orderDetail_temp.setPublishStartDate(new Integer(startDate));
						 orderDetail_temp.setPublishEndDate(new Integer(endDate));
						 OrderDayInfoUtil.getDayInfoFromListByDate(ls_source,ls_targ,orderDetail_temp);
						 
						 
						 
				 		 DayInfo dayInfo = new DayInfo();
						 dayInfo.setResourceId(resourceInfo_id);
						 dayInfo.setStartDate(new Integer(startDate));
						 dayInfo.setEndDate(new Integer(endDate));
						 Map resMap1  = ResourceUtil.getDayInfosMap(dayInfo);	
						 
//						不在规定的时间区间，原来的版本不变，
						 if(ls_source.size() >0 ){
							 orderDetail.setModifyDate(now_date);
							 OrderDayInfoUtil.getNewOrderDetailByDayInfos_for_spec(orderDetail,ls_source,0,specValue,resMap1,newDayInfosMap);
							 Long detailId = orderDetailDao.saveOrderDetail2(orderDetail);
						 }
						 
						 if(ls_targ.size() > 0 && ls_targ.size() == size_source_bak ){
//					
//							  resourceInfo_id = obj.getResourceInfoId();
							
							 OrderDayInfoUtil.getDayInfoFromListByDate_2( resMap1, ls_targ, tarList1, resourceInfo_id,spec_orderDay, specValue);
							 										
//							 System.out.println("getDayInfoFromListByDate_2 order detail id  hhhhhhhhhhhhhhhh>>>>>>>>>>>>>>>>>"+orderDetail.getId());
//							 System.out.println("getDayInfoFromListByDate_2 ls_targ size  hhhhhhhhhhhhhhhh>>>>>>>>>>>>>>>>>"+ls_targ.size());
//							 System.out.println("getDayInfoFromListByDate_2 tarList1 size  hhhhhhhhhhhhhhhh>>>>>>>>>>>>>>>>>"+tarList1.size());
							 
							 if(ls_targ.size() == tarList1.size()){
//								 System.out.println("getDayInfoFromListByDate_2 tarList1 size  hhhhhhhhhhhhhhhh bbbbbbbbbb         cccccccccccccccc        >>>>>>>>>>>>>>>>>"+tarList1.size());
								 
								 OrderDayInfoUtil.getNewOrderDetailByDayInfos_for_spec(orderDetail,ls_targ,1,specValue,resMap1,newDayInfosMap);
//								 if(!"".equals(specValue) && !"0".equals(specValue)){ orderDetail.setResourceSpecificId(specId);}
								 
								 orderDetail.setResourceSpecificId(specId);
								 orderDetail.setModifyDate(now_date);
								 Long detailId = orderDetailDao.saveOrderDetail2(orderDetail);
							 }


						 }
						 
						 
						 if(ls_targ.size() >0 && ls_targ.size() < size_source_bak ){
							 
							 OrderDayInfoUtil.getNewOrderDetailByDayInfos_for_spec(orderDetail,ls_targ,1,specValue,resMap1,newDayInfosMap);
							 
//							 System.out.println("newDayInfosMap.size() hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh>>>>>>>>>>>>>>>>>>>>>>"+newDayInfosMap.size());
							 
							 Long detailId = new Long(0);
							 orderDetail.setId(null);
							 
//							 orderDetail.setResourceSpecificId(specId);
//							 if(!"".equals(specValue) && !"0".equals(specValue)){ orderDetail.setResourceSpecificId(specId);}
							 orderDetail.setResourceSpecificId(specId);
							 orderDetail.setCreateDate(now_date);
							 orderDetail.setModifyDate(now_date);
							 detailId = orderDetailDao.saveOrderDetail2(orderDetail);
							 
							 
							 List lss = new ArrayList();
							 CollectionUtils.addAll(lss,ConvertUtil.getColFromList(ls_targ,"id"));
							 Map mp2 = new HashMap();
							 mp2.put("orderDetailId",detailId);
							 mp2.put("orderDayInfoIDS",lss);

							 orderDayInfoDao.saveDetailIdWithMaterChange(mp2);
							 
						 }
						 
	 
						 if(ls_targ.size() > tarList1.size()){
							 StringBuffer sb = new StringBuffer();
							 sb.append("0");
							 String position = orderDetail.getResource().getMemo() +" "+orderDetail.getResource().getResourceName();
							 String orderId = orderDetail.getOrderId().toString();
							 String orderCode = orderDetail.getOrder().getOrderCode();
							 
							 sb.append("已指定[" +specTXT+"]");
							 sb.append("\n\r <br/>");
							 sb.append("订单号[" +orderCode+"]");
							 sb.append("\n\r <br/>");
							 sb.append("时段名：");
							 sb.append(position);
							 sb.append("\n\r <br/>");
							 CollectionUtils.addAll(tarList2,ls_targ.iterator());
							 tarList2.removeAll(tarList1);
							 Iterator it3 = tarList2.iterator();
							 while(it3.hasNext()){
								 OrderDayInfo dinfo = (OrderDayInfo)it3.next();
								 String key =  DateUtil.SetDateFormat(dinfo.getPublishDate().toString(),"yyyy-MM-dd");
								 sb.append(key);
								 sb.append("\n\r <br/>");
							 }
							 
							 retMsg = "\n\r <br/>" + sb.toString();
							 
//							 System.out.println("retMsg>>>>>>>>>>>>>>"+ retMsg);
//							 System.out.println("tarList2.size() hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh>>>>>>>>>>>>>>>>>>>>>>"+tarList2.size());
//							 continue;
						 }
						 
						 
						 //修改资源信息
						 if(newDayInfosMap.size()>0) { 
//							 System.out.println("saveOrderDetailStopBro newDayInfosMap.size() >>>>>  vvvvvvvv  "+newDayInfosMap.size()) ;
							 ResourceUtil.updateDayInfos(newDayInfosMap);
							
		//					 Long specId = new Long(0);
		//					 if(!"".equals(specValue)){
		//						 orderDetail.setResourceSpecificId(specId);
		//					  }
		//					 orderDetail.setResourceSpecificId()
		//					 OrderDetailDao orderDetailDao = ServiceLocator.getOrderDetailDao();
							 OrderDetailManager orderDetailManager = ServiceLocator.getOrderDetailManager();
		//					 orderDetailDao.saveOrderDetail(orderDetail);
							 orderDetailOld.setMoidType("2");
							 orderDetailOld.setOrder(order);
			
		
							 
							 orderDetail.setOrder(order);
							 orderDetail.setMoidType("2");
							 orderDetail.getOrder().setLoginUser(loginUser);
							 orderDetail.setPublishStartDate(new Integer(startDate));
							 orderDetail.setPublishEndDate(new Integer(endDate));
							 orderDetail.setMemo(specTXT);
							 String msg = orderDetailManager.saveOrderLog(orderDetailOld,orderDetail);
							 
//							 if(!it.hasNext()){ retMsg = msg;}
						 
						 }	
					 
					 
				 }
				
						 
					 
					 
					 
					 
			}
			 
				  
			return retMsg;
		}

		



public String saveOrderPrice(Order order, String[] orderDetailIds,int startDate,int endDate,double execPrice,double favourRate,double appRate){
	Map mp = new HashMap();
	String loginUser = order.getLoginUser();
	List orderDetailIdList = new ArrayList();
	CollectionUtils.addAll(orderDetailIdList,orderDetailIds);
	OrderDetail orderDetailParam = new OrderDetail();
	orderDetailParam.setDetailIdsIdList(orderDetailIdList);
	List orderDetails = orderDetailDao.getOrderDetails(orderDetailParam);
	Iterator it = orderDetails.iterator();
	String retMsg = "";
	Date now_date = new Date();
	Long orderId = order.getId();

	Map mppp = new HashMap();


	double base_price = 0;
	double sumRealPay = 0;
	double moneyIn = 0;
	double sumBalance = 0;
	double moneyRealpay = 0;
	double execPriceNew = 0;
	
	Long detailId = new Long(0);
	
	
	int sumTimes = 0;
	

//	 System.out.println("execPrice111111111111111111111111111111>>>>>>>>>>>>>>"+ execPrice);
//	 System.out.println("favourRate11111111111111111111111111111>>>>>>>>>>>>>>"+ favourRate);
//	 System.out.println("appRate11111111111111111111111111111111>>>>>>>>>>>>>>"+ appRate);
	
	 while(it.hasNext()){
		 OrderDetail orderDetail = (OrderDetail)it.next();
		 detailId = orderDetail.getId();
		 OrderDetail orderDetailOld = new OrderDetail();
		 ConvertUtil.copyBeanProperties2(orderDetailOld,orderDetail);
		 
		 base_price = orderDetail.getSysPrice().doubleValue();
		 base_price = base_price==0?1:base_price;
		 
		 System.out.println("sumTimes11111111111111111111111111111111>>>>>>>>>>>>>>"+ orderDetail.getSumTimes());
		 
		 sumTimes = orderDetail.getOrderPublic().getTimes().intValue();
		 sumBalance = orderDetail.getMoneyBalance().doubleValue();
		 
		 if(execPrice > 0){
			 orderDetailOld.setMemo("1");
			 execPriceNew  = execPrice;
			 
			 double rate = execPrice/base_price;
			 if(rate<1){
				 orderDetail.setFavourRate(new Double(rate));
				 orderDetail.setAppRate(new Double(0));
			 }else if(rate == 1){
				 orderDetail.setFavourRate(new Double(0));
				 orderDetail.setAppRate(new Double(0));
			 }else{
				 orderDetail.setAppRate(new Double(rate-1));
				 orderDetail.setFavourRate(new Double(0));
			 }
			
		 }else{
			 orderDetailOld.setMemo("2");
			 
			 execPriceNew = base_price*favourRate *(1+appRate);
			 System.out.println("favourRate    11111111111111111111111111111>>>>>>>>>>>>>>"+ favourRate);
			 orderDetail.setFavourRate(new Double(favourRate));
			 orderDetail.setAppRate(new Double(appRate));
		 }
		
		 
		 moneyRealpay = execPriceNew*sumTimes+sumBalance;
		 sumRealPay +=moneyRealpay;
		 
		 orderDetail.setExecPrice(new Double(execPriceNew));
		 orderDetail.setMoneyRealpay(new Double(moneyRealpay));
		 
		
//		 orderDetail.setModifyBy(loginUser);
		 
//		 orderDetailDao.getOrderDetailByOrderIdCopy()
//		 Long detailId = orderDetailDao.saveOrderDetail2(orderDetail);
		 
		 

		 
		 OrderDayInfo orderDayInfo = new OrderDayInfo();
//		 orderDayInfo.setOrderId(order.getId());	
		 orderDayInfo.setOrderDetailId(detailId);
		 List adList = orderDayInfoDao.getOrderDayInfos(orderDayInfo);	
		 List ls1 =  new ArrayList();  //
		 Map mpZero =  new HashMap();	
		 Map mpAll =  new HashMap();	     
		 if(adList.size() >0){
			 OrderDayUtil.getOrderDaysPraentIdZero2(adList,ls1,mpZero,true,null);
		 }
		
		 
	     if(ls1.size()>0){    
	    	    OrderDayUtil orderDayUtil = new OrderDayUtil();
				Map dayRealPlay = orderDayUtil.getOrdersDaysMony(ls1,moneyRealpay,1,execPriceNew);
				mpAll.putAll(dayRealPlay);
	     }
	     if(mpZero.size()>0){    
				mpAll.putAll(mpZero);
	     }     

	 	if(mpAll.size() > 0){
	 		orderDayInfoDao.saveOrderDayInfosRealPlay2(mpAll);		
	 	}	
		 
	 	 mppp.put(orderDetail.getId(),orderDetail);
	 	 
	 	 
	 	 
		 
		 	OrderDetailManager orderDetailManager = ServiceLocator.getOrderDetailManager();
		 	orderDetailOld.setMoidType("3");
			orderDetailOld.setOrder(order);
			orderDetail.setOrder(order);
			orderDetail.setMoidType("3");
			orderDetail.getOrder().setLoginUser(loginUser);
			orderDetail.setPublishStartDate(new Integer(startDate));
			orderDetail.setPublishEndDate(new Integer(endDate));
			String msg = orderDetailManager.saveOrderLog(orderDetailOld,orderDetail);
		 
		 
		 
		 
			 
	}
	
	Map mpcopy = new HashMap();
	mpcopy.put("orderId",orderId);
//	mpcopy.put("orderDetailIdList",idsList);
//	List ls = dao.getOrderDetailByOrderIdCopy(mpcopy);
	List lsss = orderDetailDao.getOrderDetailByOrderIdCopy(mpcopy);
	Iterator it3 = lsss.iterator();
	 while(it3.hasNext()){
		 OrderDetail obj =  (OrderDetail)it3.next();
		 Long key = obj.getId();
		
		 if(mppp.containsKey(key)){
			 OrderDetail obj2 = (OrderDetail)mppp.get(key);
			 
			 System.out.println("key 22222222222222222222222222     "+ obj2.getFavourRate() +"   >>>>>>>>>>>>>>"+ key);
			 
			 obj.setFavourRate(obj2.getFavourRate());
			 obj.setAppRate(obj2.getAppRate());
			 obj.setExecPrice(obj2.getExecPrice());
			 obj.setMoneyRealpay(obj2.getMoneyRealpay());
			 obj.setModifyDate(now_date);
			 Long detail_id = orderDetailDao.saveOrderDetail2(obj);
		 }
		
	 }
	
	
	
	 List ls = contractPaymentManager.getContractPaymentsCopy(orderId);
	 Iterator it2 = ls.iterator();

	 if(ls.size() ==1){
		 ContractPayment payment =  (ContractPayment)it2.next();
		 payment.setMoneyPay(new Double(sumRealPay));
		 contractPaymentManager.saveContractPayment(payment);
	 }
	 
//	 while(it2.hasNext()){
//		 ContractPayment payment =  (ContractPayment)it2.next();
////		 payment.setId(null);
//		 payment.setOrderId(orderId);
//		 contractPaymentManager.saveContractPayment(payment);
//	 }
	 
	 
	 
	 
	 
	 

		  
	return retMsg;
}


public Map getOrderDayInfosMapByDetailId(Order order){
	Map mp = new HashMap();
	OrderDetail[] orderDetails = order.getOrderDetailsObj();
	if(orderDetails != null){
		 for(int k =0;k< orderDetails.length;k++){ 
				OrderDetail orderDetail = orderDetails[k];
				Long detailId = orderDetail.getId();
				mp.put(detailId,orderDetail.getOrderDayInfos());
		  }	
	}

	 return mp;
}
public Map getOrderDetailMap(Order order){
	Map mp = new HashMap();
	OrderDetail[] orderDetails = order.getOrderDetailsObj();
	if(orderDetails != null){
		 for(int k =0;k< orderDetails.length;k++){ 
				OrderDetail orderDetail = orderDetails[k];
				mp.put(orderDetail.getId(),orderDetail);
		  }		
	}

	 return mp;
}
public Map getOrderDetailMap2(Order order){
	Map mp = new HashMap();
//	Map temp_map_key = new HashMap();
	OrderDetail[] orderDetails = order.getOrderDetailsObj();

	
	if(orderDetails != null){
		 for(int k =0;k< orderDetails.length;k++){ 
				OrderDetail orderDetail = orderDetails[k];
				Long id = orderDetail.getId();
				if(!mp.containsKey(id)){
					List ls = new ArrayList();
					ls.add(orderDetail);
					mp.put(id,ls);
				}else{
					List ls = (List)mp.get(id);
					ls.add(orderDetail);
					mp.put(id,ls); 
				}
//				mp.put(id,orderDetail);
		  }		
	}
	
	Iterator it = mp.keySet().iterator();
	while(it.hasNext()){
		Long key =(Long) it.next();
		List ls = (List)mp.get(key);
		Iterator it2 =ls.iterator();
		int start = 99999999;
		int end = 0;
		int sumTime = 0; 
		double sumRealPay =.00;
		double sumBalance =.00;
		while(it2.hasNext()){
			OrderDetail orderDetail = (OrderDetail)it2.next();
			
//			OrderDayInfo[] orderDayInfos = order_Detail.getOrderDayInfos();
		
			int start1 = orderDetail.getPublishStartDate().intValue();
			int end2 = orderDetail.getPublishEndDate().intValue();
			
			start = Math.min(start,start1);
			end = Math.max(end,end2);
			sumTime += orderDetail.getSumTimes().intValue();
			sumRealPay += orderDetail.getMoneyRealpay().doubleValue();
			sumBalance += orderDetail.getMoneyBalance().doubleValue();
			
			OrderDetail tagObj = new OrderDetail();
			ConvertUtil.copyBeanProperties2(tagObj,orderDetail);
			
			 tagObj.setPublishStartDate(new Integer(start));
			 tagObj.setPublishEndDate(new Integer(end));
			 tagObj.setSumTimes(new Integer(sumTime));
			 tagObj.setMoneyRealpay(new Double(sumRealPay));
			 tagObj.setMoneyBalance(new Double(sumBalance));
			 
//			 System.out.println("order 5 getOrderDetailMap2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +tagObj.toString()); 
			 
			mp.put(key,tagObj);
		}
		
		
	}
	

	 return mp;
}

public Map getResMap(OrderDetail orderDetail){
	if(orderDetail != null){
		DayInfo dayInfoPar = new DayInfo();
		dayInfoPar.setResourceId(orderDetail.getResourceInfoId());
		dayInfoPar.setStartDate(orderDetail.getPublishStartDate());
		dayInfoPar.setEndDate(orderDetail.getPublishEndDate());
		return ResourceUtil.getDayInfosMap(dayInfoPar);	
	}else{
		return new HashMap();
	}

}


public Map getResMap(Long resourceId,Integer startDate,Integer endDate){
	if(resourceId.longValue() >0 && startDate.intValue() >0 ){
		DayInfo dayInfoPar = new DayInfo();
		dayInfoPar.setResourceId(resourceId);
		dayInfoPar.setStartDate(startDate);
		dayInfoPar.setEndDate(endDate);
		return ResourceUtil.getDayInfosMap(dayInfoPar);	
	}else{
		return new HashMap();
	}

}




		


public void getOrderDayInfosByOrderDetailId(Order orderCur,Order orderBackUp,Long detailId,Map newDayInfosMap,List lsUpdate,int opt,boolean isDisplayMonDetail){
//	List lsCur = new ArrayList();
//	List lsBak = new ArrayList();
	List lsRemoveIds = new ArrayList();
	
	
	Map orderDetailMap =  getOrderDetailMap(orderBackUp);
	Map mpRes = getResMap((OrderDetail)orderDetailMap.get(detailId));
	
	
//	System.out.println("orderBackUp orderDetailMap.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderBackUp.getOrderDetailsObj().length); 
	
	
	if(mpRes.size() >0){

		Map orderDetailDaysMap =  getOrderDayInfosMapByDetailId(orderBackUp);

		OrderDetail orderDetail =(OrderDetail) orderDetailMap.get(detailId);
		String adLen = orderDetail.getMatterLength();
		String resourceInfoId = orderDetail.getResourceInfoId().toString();
		String specificValue = StringUtil.getNullValue(orderDetail.getSpecificValue(),"");
		
		
		//opt == 0 删除  opt == 1 修改
//		if(opt == 0 && isDisplayMonDetail){
		String year_month = orderBackUp.getTempStr();
//		}		
		
		
//		System.out.println("year_month >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ year_month); 
		
		
		
		//清除原来所有的时间资源
		Object obj = orderDetailDaysMap.get(detailId);
		if(obj != null){
			OrderDayInfo[] orderDayInfos_bak = (OrderDayInfo[])obj;
	
			
			for(int p = 0;p < orderDayInfos_bak.length;p++){
				OrderDayInfo orderDayInfo = orderDayInfos_bak[p];
				long idd = Long.parseLong(StringUtil.getNullValue(orderDayInfo.getId(), "0"));
				double money_in = orderDayInfo.getDayRelPuton().doubleValue();
				String key = resourceInfoId +","+orderDayInfo.getPublishDate().toString();
				DayInfo day_info = (DayInfo)mpRes.get(key);	
				Long day_inf_id = day_info.getId();
				double changeValue = 0;
				if(newDayInfosMap.containsKey(day_inf_id)){
					day_info =  (DayInfo)newDayInfosMap.get(day_inf_id);
					changeValue = day_info.getChangedValue().doubleValue()-Double.parseDouble(adLen)*orderDayInfo.getAdDayTimes().intValue();
				}else{
					changeValue = -Double.parseDouble(adLen)*orderDayInfo.getAdDayTimes().intValue();
				}

				day_info.setChangedValue(new Double(changeValue));
				
				String spec_res = StringUtils.isEmpty(day_info.getSpecific())? "":day_info.getSpecific();
				
//				System.out.println("spec_res>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ spec_res); 
//				System.out.println("specificValue>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ specificValue); 
				
//				1 包含  2 不包含 3、追加  4 、其它排除空的
				if(!"".equals(specificValue) && !"0".equals(specificValue)){
					 if(spec_res.indexOf(specificValue) >-1){
						 spec_res = StringUtil.selectStr(spec_res,specificValue,2);
						 day_info.setSpecific(spec_res);
					 }

				}
//						System.out.println("spec_res>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ spec_res); 
				newDayInfosMap.put(day_info.getId(),day_info);	
				System.out.println("money_in>>>>>>>>>>>>>>333333333333333333>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ money_in); 
//				if(!lsCur.contains(new Long(idd))){
					if(money_in >0){
						orderDayInfo.setAdDayTimes(new Integer(0));
						orderDayInfo.setDayRelIncome(new Double(0));
						lsUpdate.add(orderDayInfo);
					}else{
//						lsBak.add(orderDayInfo);
						lsRemoveIds.add(new Long(idd));
					}
//				}

			}
		}

	   if(lsRemoveIds.size()>0){
		   Map mapRemove = new HashMap(); 
		   mapRemove.put("OrderDayInfoIdList",lsRemoveIds);
//		   System.out.println("lsRemoveIds>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ lsRemoveIds); 
		   orderDayInfoDao.removeOrderDayInfos(mapRemove);
	   }		
		
		
	}
	
	
	
	if(opt != 0){

//		Map orderDetailMapCur =  getOrderDetailMap(orderCur);
////		Map orderDetailDaysMapCur =  getOrderDayInfosMapByDetailId(orderCur);
//		OrderDetail orderDetail = (OrderDetail)orderDetailMapCur.get(detailId);
//		Long resourceId = orderDetail.getResourceInfoId();
//		Integer startDate = orderDetail.getPublishStartDate();
//		Integer endDate = orderDetail.getPublishEndDate();
//		String adlen = StringUtil.getNullValue(orderDetail.getMatterLength(),"0");
//		adlen = "".equals(adlen)?"0":adlen;
//		String specificValue = StringUtil.getNullValue(orderDetail.getSpecificValue(),"");
//		 OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
//	    //新的时间资源
//		 Map resMap2 = getResMap(resourceId,startDate,endDate);
//		 
//		 System.out.println(" orderDayInfos.length >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderDayInfos.length); 
//		 System.out.println("resMap2.size() >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ resMap2.size()); 
//		 
//		if(resMap2.size() >0){
////			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderDayInfos.length); 
//				for(int j =0;j < orderDayInfos.length;j++){
//					OrderDayInfo orderDayInfo = orderDayInfos[j];
//					orderDayInfo.setId(null);
//		  			orderDayInfo.setOrderDetailId(detailId);
//					String key = resourceId.toString() +","+orderDayInfo.getPublishDate().toString();
//					DayInfo day_info = (DayInfo)resMap2.get(key);
//					Long day_inf_id = day_info.getId();
//					double changeValue = 0;
//					if(newDayInfosMap.containsKey(day_inf_id)){
//						day_info =  (DayInfo)newDayInfosMap.get(day_inf_id);
//						changeValue = day_info.getChangedValue().doubleValue()+Double.parseDouble(adlen)*orderDayInfo.getAdDayTimes().intValue();
//					}else{
//						changeValue = Double.parseDouble(adlen)*orderDayInfo.getAdDayTimes().intValue();
//					}
//
//					day_info.setChangedValue(new Double(changeValue));
//					
//					if(!"".equals(specificValue) && !"0".equals(specificValue)){
//						String spec_res = StringUtils.isEmpty(day_info.getSpecific())? "":day_info.getSpecific();
////							1 包含  2 不包含 3、追加  4 、其它排除空的
//						 if(spec_res.indexOf(specificValue) == -1){
//							 spec_res = StringUtil.selectStr(spec_res,specificValue,3);
//							 day_info.setSpecific(spec_res);
//						 }
//					}
////							System.out.println("spec_res>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ spec_res); 
//					System.out.println("orderDetailMapCur key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ key); 
//					newDayInfosMap.put(day_inf_id,day_info);	
////					}
//				}	
		
  

	}
	
	
	
	
	
	
	
	
	
	

}

public void removeOrderDetailByDetailId(Order orderBackUp,String orderDetailId,String year_month) throws OrderDetailUnableSaveException{ 
//	Map orderDetailDaysMap =  getOrderDayInfosMapByDetailId(orderBackUp);
//	Map orderDetailMap =  getOrderDetailMap(orderBackUp); 
//	Long id = new Long(orderDetailId);
//	Map mpRes = getResMap((OrderDetail)orderDetailMap.get(id));

	List lsUpdate = new ArrayList();
	Map newDayInfosMap = new HashMap(); 
	boolean isDisplayMonDetail = (orderBackUp.getIsDisplayMonDetail().intValue() == 5);   //拆分月份
	int model = Integer.parseInt(StringUtil.getNullValue(orderBackUp.getOrderCategoryMain(),"0"));
	Long id = new Long(orderDetailId);
	orderBackUp.setTempStr(year_month);
	getOrderDayInfosByOrderDetailId(null,orderBackUp,id,newDayInfosMap,lsUpdate,0,isDisplayMonDetail);
	
//	System.out.println("lsUpdate.size()>>>>>>>>>>>>>>333333333333333333>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ lsUpdate.size()); 
	
	Map orderDetailMap =  getOrderDetailMap(orderBackUp);
	double sumMoney = orderBackUp.getOrderPublic().getMoneyRealpay().doubleValue();
	if(model == 1){
		OrderDetail orderDetail =(OrderDetail) orderDetailMap.get(new Long(orderDetailId));
		sumMoney = sumMoney - orderDetail.getMoneyRealpay().doubleValue();
	}
	
//	if(mpRes.size() > 0){
//		getOrderDayInfosByOrderDetailId(orderDetailDaysMap,orderDetailMap,mpRes,id,newDayInfosMap,lsUpdate);
//		getOrderDayInfosByOrderDetailId(orderBackUp,id,newDayInfosMap,lsUpdate);
//	}

	 //修改资源信息
	 if(newDayInfosMap.size()>0) {
//		 log.info("newDayInfosMap.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + newDayInfosMap.size());
		 ResourceUtil.updateDayInfos(newDayInfosMap);
	 }	
	 
	 
	   OrderDayInfo[]  orderDayInfos = new  OrderDayInfo[lsUpdate.size()];
		for(int bb = 0;bb<lsUpdate.size();bb++){ 
   			OrderDayInfo orderDayInfo = (OrderDayInfo)lsUpdate.get(bb);
   			orderDayInfos[bb] = orderDayInfo;
   		}
   	

		if(orderDayInfos.length >0){
			orderDayInfoDao.saveOrderDayInfosNew(orderDayInfos); 
		}else{
			orderDayInfoDao.removeOrderDayInfoByOrderDetailId(id);
			orderDetailDao.removeOrderDetail(id);
		}
		
   
   		
   		System.out.println("removeOrderDetailByDetailId model >>>>>>>>>>>>>>>>>>>>>>>  "+model);
   		System.out.println("removeOrderDetailByDetailId sumMoney >>>>>>>>>>>>>>>>>>>>>>>  "+sumMoney);
   		
   		if(model == 1){
   	   		saveContractPayment(orderBackUp,sumMoney); 
   		}

	 
	if(lsUpdate.size() > 0){
		 throw new OrderDetailUnableSaveException("财务已经平过帐,无法删除!");
	}
	
//	try {
//			getOrderDayInfosByOrderDetailId(orderDetailDaysMap,orderDetailMap,mpRes,id,newDayInfosMap,lsUpdate);
//	}catch (Exception e) {
//		  throw new OrderDetailUnableSaveException("财务已经平过帐,无法删除!");
//	}				

	
}


public Order saveOrderMoreDetails(Order order,Order orderBackUp) throws OrderDetailUnableSaveException{

   	boolean isNewOrder = (order.getId() == null) || StringUtils.isEmpty(order.getId().toString());
   	boolean autoRelationCodeParam = SysParamUtil.getAutoRelationCodeParam();
   	int model = Integer.parseInt(StringUtil.getNullValue(order.getOrderCategoryMain(),"0"));
   	boolean isDisplayMonDetail = (order.getIsDisplayMonDetail().intValue() == 5);
//	Map orderDetailDaysMap =  getOrderDayInfosMapByDetailId(orderBackUp);
//	Map orderDetailMap =  getOrderDetailMap(orderBackUp);


   	String msg ="";
	Date now_date = new Date();	
	Map newDayInfosMap = new HashMap(); 
	
	
	 Map mp = new HashMap();
	 Map mpAll = new HashMap();
	 Map mpAll2 = new HashMap();
	 OrderDayUtil orderDayUtil = new OrderDayUtil();
	 

		
		
		
	 
	if(isNewOrder){
			setOrderCode(order);
			if(autoRelationCodeParam) setRelationCode(order);
			order.setCreateDate(now_date);
			order.setModifyDate(now_date);
			
	}else{
	   		order.setModifyDate(now_date);
	   		//保存修改日志
//	   		saveOrderLog(orderBackUp,order);
	}
		
	 double sumMoney = 0;
		 
//	   try {
		   
//		    System.out.println("order 1 order>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+order.getOrderDetailsObj().length); 
//		    System.out.println("order 2 orderBackUp >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+orderBackUp.getOrderDetailsObj().length); 

		   	Long orderId = dao.saveOrder(order);

		    OrderDetail[] orderDetails = order.getOrderDetailsObj();
		    
		    //合并
		    Map tem_mp = new HashMap();

	   		for(int i =0;i< orderDetails.length;i++){ 
	   			OrderDetail orderDetail = orderDetails[i];
	   			
//	   		 System.out.println("order orderDetail.getId() >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetail.getId()); 
	   		 
	   		 	boolean isNewDetail = (orderDetail.getId() == null) || StringUtils.isEmpty(orderDetail.getId().toString());
//	   			Long resourceId = orderDetail.getResourceInfoId();
	   			Long orderDetailId = orderDetail.getId();
	   			if(isNewDetail){
		   			orderDetail.setId(null);
		   			orderDetail.setOrderId(orderId);
					orderDetail.setCreateDate(now_date);
					orderDetail.setModifyDate(now_date);
					orderDetail.setNeedPublish(new Integer(1)); 
					orderDetailId = orderDetailDao.saveOrderDetail2(orderDetail);   
	   			}else{
	   				orderDetail.setModifyDate(now_date);
//	   				Long idd = orderDetail.getId();
		   			if(!tem_mp.containsKey(orderDetailId)){
		   				Map orderDetailMapCur =  getOrderDetailMap2(order);
		   				OrderDetail order_Detail = (OrderDetail)orderDetailMapCur.get(orderDetailId);
		   				order_Detail.setModifyDate(now_date);
		   				order_Detail.setCreateDate(now_date);
//		   				System.out.println("order 6 orderDetailId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetail.toString()); 
//		   			 	orderDetailId = orderDetailDao.saveOrderDetail2(orderDetail);   

//		   				System.out.println("order 6 A>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetailId); 
		   			   orderDetailId = orderDetailDao.saveOrderDetail2(order_Detail);   
		  
//		   			   System.out.println("order 5 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetailId); 
		   			  
		   			}	   				
	   				
	   				
	   			}

	   		

							
//				System.out.println("order 6 orderDetailId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetailId); 

		   		
		   		
		   		List lsUpdate = new ArrayList();
		
		   		if(!isNewDetail && !tem_mp.containsKey(orderDetailId)){
//		   			System.out.println("order 1111111111111111 getOrderDayInfosByOrderDetailId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetailId); 
		   			getOrderDayInfosByOrderDetailId(order,orderBackUp,orderDetailId,newDayInfosMap,lsUpdate,1,isDisplayMonDetail);
		   		    tem_mp.put(orderDetailId,orderDetailId);
		   		}
		   		
         
		   		//确保只存一回
//		   		if(!tem_mp.containsKey(orderDetailId)){

		   			
//		   			Map orderDetailMapCur =  getOrderDetailMap(order);
//					Map orderDetailDaysMapCur =  getOrderDayInfosMapByDetailId(orderCur);
		   			
//		   			System.out.println("order 5 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +orderDetailId); 
		   			
//					OrderDetail order_Detail = (OrderDetail)orderDetailMapCur.get(orderDetailId);
					
//					System.out.println("order 7 order_Detail>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " +order_Detail); 
					
					Long resourceId = orderDetail.getResourceInfoId();
					Integer startDate = orderDetail.getPublishStartDate();
					Integer endDate = orderDetail.getPublishEndDate();
					String adlen = StringUtil.getNullValue(orderDetail.getMatterLength(),"0");
					adlen = "".equals(adlen)?"0":adlen;
					String specificValue = StringUtil.getNullValue(orderDetail.getSpecificValue(),"");
					 OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
				    //新的时间资源
//					 System.out.println("resourceId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ resourceId); 
//					 System.out.println("startDate >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ startDate); 
//					 System.out.println("endDate >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ endDate); 
					 Map resMap2 = getResMap(resourceId,startDate,endDate);
					 
//					 System.out.println(" orderDayInfos.length >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderDayInfos.length); 
//					 System.out.println("resMap2.size() >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ resMap2.size()); 
					 
					if(resMap2.size() >0){
//						System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderDayInfos.length); 
							for(int j =0;j < orderDayInfos.length;j++){
								OrderDayInfo orderDayInfo = orderDayInfos[j];
								orderDayInfo.setId(null);
					  			orderDayInfo.setOrderDetailId(orderDetailId);
								String key = resourceId.toString() +","+orderDayInfo.getPublishDate().toString();
								DayInfo day_info = (DayInfo)resMap2.get(key);
								Long day_inf_id = day_info.getId();
								double changeValue = 0;
								if(newDayInfosMap.containsKey(day_inf_id)){
									day_info =  (DayInfo)newDayInfosMap.get(day_inf_id);
									changeValue = day_info.getChangedValue().doubleValue()+Double.parseDouble(adlen)*orderDayInfo.getAdDayTimes().intValue();
								}else{
									changeValue = Double.parseDouble(adlen)*orderDayInfo.getAdDayTimes().intValue();
								}

								day_info.setChangedValue(new Double(changeValue));
								
								if(!"".equals(specificValue) && !"0".equals(specificValue)){
									String spec_res = StringUtils.isEmpty(day_info.getSpecific())? "":day_info.getSpecific();
//										1 包含  2 不包含 3、追加  4 、其它排除空的
									 if(spec_res.indexOf(specificValue) == -1){
										 spec_res = StringUtil.selectStr(spec_res,specificValue,3);
										 day_info.setSpecific(spec_res);
									 }
								}
//										System.out.println("spec_res>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ spec_res); 
//								System.out.println("orderDetailMapCur key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ key); 
								newDayInfosMap.put(day_inf_id,day_info);	
//								}
							}	
							
//					}
		   		
		   		
		   		
		   		
		   		
		   		
	//		   		System.out.println("orderDayInfos.length>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderDayInfos.length); 
//			   		System.out.println("lsUpdate.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ lsUpdate.size()); 
//			   		OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
			   		for(int bb = 0;bb<lsUpdate.size();bb++){
			   			OrderDayInfo orderDayInfo = (OrderDayInfo)lsUpdate.get(bb);
			   			orderDayInfos[orderDayInfos.length] = orderDayInfo;
			   		}
			   		
//			   		System.out.println("orderDayInfos.length>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderDayInfos.length); 
			   		
			   		
			   		orderDayInfoDao.saveOrderDayInfosNew(orderDayInfos);
		   		
		   		}
		   		
//		   	  System.out.println("saveOrderDayInfos model>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " +model); 
		   	  
		   		if(model == 1){
//		   			Integer startDate = orderDetail.getPublishStartDate();
//		   			Integer endDate = orderDetail.getPublishEndDate();
					OrderDayInfo orderDayInfo = new OrderDayInfo();	
					orderDayInfo.setOrderDetailId(orderDetailId);	
		   			orderDayInfo.setStartDate(String.valueOf( orderDetail.getPublishStartDate()));
		   			orderDayInfo.setEndDate(String.valueOf(orderDetail.getPublishEndDate()));

					 List adList = orderDayInfoDao.getOrderDayInfos(orderDayInfo);	

//					 System.out.println("saveOrderDayInfos adList.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+adList.size()); 
				 
					 if(adList.size() >0){
						    double sum_money = Double.parseDouble(StringUtil.getNullValue(orderDetail.getMoneyRealpay(),"0"));
						    double sum_balance =  Double.parseDouble(StringUtil.getNullValue(orderDetail.getMoneyBalance(),"0"));
						    sumMoney +=sum_money;
						    int sumTimes = Integer.parseInt(StringUtil.getNullValue(orderDetail.getSumTimes(),"1"));
						    sumTimes = sumTimes == 0?1:sumTimes;

							 List ls1 =  new ArrayList();  //
							 List ls2 =  new ArrayList();  //
							 Map mpZero =  new HashMap();	   
							 Map mpZero2 =  new HashMap();	   
							 if(adList.size() >0){ OrderDayUtil.getOrderDaysPraentIdZero2(adList,ls1,mpZero,true,new Integer(0));}
							 if(adList.size() >0){ OrderDayUtil.getOrderDaysPraentIdZero2(adList,ls2,mpZero2,true,new Integer(0));}
							 
						     if(ls1.size()>0){    
						        List real_balance_list = orderDayUtil.getOrdersDaysMony2(adList,sum_money,model,sum_money/sumTimes,sum_balance,sum_balance/sumTimes);
						    	Map dayRealPlay = (Map)real_balance_list.get(0);
						    	Map dayBalance = (Map)real_balance_list.get(1);
								mpAll.putAll(dayRealPlay);
								mpAll2.putAll(dayBalance);
						     }
						     if(mpZero.size()>0){ mpAll.putAll(mpZero);	 }  
						     if(mpZero2.size()>0){ mpAll2.putAll(mpZero2);	 }  
						     
							 if(mpAll.size() > 0){
							 		orderDayInfoDao.saveOrderDayInfosRealPlay3(mpAll,mpAll2);		
							 }		
							 
						   
													 
							 
	
				     }
				
		   		}

		   		
//		   		System.out.println("spec_res>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ orderDayInfos.length); 

	   		}
	   		
	   		
			 //修改资源信息
			 if(newDayInfosMap.size()>0) {
//				 log.info("newDayInfosMap.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + newDayInfosMap.size());
				 ResourceUtil.updateDayInfos(newDayInfosMap);
			 }	
		    

			 
			 
			if(model == 0){
		
				sumMoney = Double.parseDouble(StringUtil.getNullValue(order.getOrderPublic().getMoneyRealpay(),"0"));
				OrderDayInfo orderDayInfo = new OrderDayInfo();
				orderDayInfo.setOrderId(orderId);			
	
				 List adList = orderDayInfoDao.getOrderDayInfos(orderDayInfo);	
			 
				 
				 List ls1 =  new ArrayList();  //
				 Map mpZero =  new HashMap();	     
				 if(adList.size() >0){
					 OrderDayUtil.getOrderDaysPraentIdZero2(adList,ls1,mpZero,true,new Integer(0));
				 }
				 
			     if(ls1.size()>0){     
						Map dayRealPlay = orderDayUtil.getOrdersDaysMony(ls1,sumMoney,model,0);
						mpAll.putAll(dayRealPlay);
			     }
			     if(mpZero.size()>0){    
						mpAll.putAll(mpZero);	 
			     }  
			     
			     
			     
				 if(mpAll.size() > 0){
				 		orderDayInfoDao.saveOrderDayInfosRealPlay2(mpAll);		
				 }
				 
			     
		        mp.put("model",model+"");
		        mp.put("orderId",orderId);
		        orderDetailDao.saveOrderDetailPublicInfo(mp);
	
		   }	
		
			
//		System.out.println("sumMoney>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ sumMoney); 
			
		
		

		
			 
			 
		    
//		    Iterator it = order.getOrderDetails().iterator();
//		    while(it.hasNext()){
//		    	OrderDetail orderDetail = (OrderDetail)it.next();
//		    	System.out.println("orderDetail >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+orderDetail.toString()); 	
//		    }

		   
//	   }catch (Exception e) {
//            throw new OrderDetailUnableSaveException(msg);
//        }

   	//保存客户信息

   	
   	//保存付款信息
	 saveContractPayment(order,sumMoney);
   	
		
//		保存修改日志
		 if(!isNewOrder){
			 saveOrderLog(orderBackUp,order);
		 }
		 
     return order;

}

private void saveContractPayment(Order order,double sumMoney){
	Date now_date = new Date();	
	Long orderId = order.getId();
	if(sumMoney > 0){
		
		ContractPayment payment = new ContractPayment();
		payment.setId(null);
		payment.setCarrierId(new Long(0));
		payment.setContractId(new Long(0));

		payment.setResourceTypeId(new Long(0));
		
		payment.setIncomePurposeId(new Long(1));
		payment.setPayNumber(new Integer(1));
		payment.setMoneyIn(new Double(0)); 
		payment.setCreateBy(order.getCreateBy());
		payment.setCreateDate(now_date);
		payment.setModifyDate(now_date);
		payment.setMemo("fast");
		
		payment.setPayDate(new Integer(DateUtil.convertDateToString("yyyyMMdd",now_date)));
		payment.setMoneyPay(new Double(sumMoney));
		payment.setOrderId(orderId);
		
		payment.setVersion(order.getVersion());
		payment.setCustomerId(order.getCustomerId());
//		payment.setUrgencyAlert(new Boolean(true));
		ContractPayment payment2 = new ContractPayment();
		payment2.setOrderId(orderId);
		List ls = contractPaymentManager.getContractPaymentsDesc(payment2);
		Iterator it = ls.iterator();
		Iterator it2 = ls.iterator();
		int size  = ls.size();
		
		
		if(size == 0){
			contractPaymentManager.saveContractPayment(payment); 
		}else if(size == 1){
			ContractPayment pay = (ContractPayment)ls.get(0);
			pay.setMoneyPay(new Double(sumMoney));
			pay.setModifyDate(now_date);
			pay.setModifyBy(order.getCreateBy());
			contractPaymentManager.saveContractPayment(pay); 
		}else{
			Map mp_temp = new HashMap();
			Map mp_temp_remove = new HashMap();
			double sum_pay_old = 0.0;
			long maxValue = 0; 
			Long maxId = new Long(0);
			while(it.hasNext()){
				ContractPayment pay = (ContractPayment)it.next();
				sum_pay_old +=pay.getMoneyPay().doubleValue();
				long id = pay.getId().longValue();
				long maxNum = Math.max(maxValue,id);
				if(maxValue < maxNum) maxId = new Long(id);
				mp_temp.put(new Long(id),pay);
//				contractPaymentManager.removeContractPayment(pay.getId().toString());
			}
			 double diffnum = sumMoney - sum_pay_old;
			 if(diffnum > 0){
				 ContractPayment pay = (ContractPayment) mp_temp.get(maxId);
				 double p = pay.getMoneyPay().doubleValue() +diffnum;
				 pay.setMoneyPay(new Double(p));
				 pay.setModifyDate(now_date);
				 pay.setModifyBy(order.getCreateBy());
				 contractPaymentManager.saveContractPayment(pay); 
			 }else if(diffnum < 0){
				 
				 if(sumMoney > 0){
					 
					while(it2.hasNext()){
						
							ContractPayment pay = (ContractPayment)it2.next();
							double p1 = pay.getMoneyPay().doubleValue();
							double p2 = -diffnum - p1;
							if(p2 >= 0){
								diffnum = diffnum + p1;
								 pay.setMoneyPay(new Double(0));
								 mp_temp_remove.put(pay.getId().toString(),pay);
								 contractPaymentManager.saveContractPayment(pay); 
							}else{
								if(diffnum != 0){
									 pay.setMoneyPay(new Double(p1+diffnum));
									 diffnum = 0;
									 contractPaymentManager.saveContractPayment(pay); 	
								}

							}
						}
					}else if(sumMoney == 0){
						while(it2.hasNext()){
							ContractPayment pay = (ContractPayment)it2.next();
							pay.setMoneyPay(new Double(0));
							contractPaymentManager.saveContractPayment(pay); 
							mp_temp_remove.put(pay.getId().toString(),pay);
						}
					}
				
					
					Iterator it3 = mp_temp_remove.keySet().iterator();
					
					
//					System.out.println("key11111111111111111111111     222222222222222222222 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ mp_temp_remove.keySet().size()); 
					
					while(it3.hasNext()){
						String key = it3.next().toString();
//						System.out.println("key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ key); 
						try {
							contractPaymentManager.removeContractPayment(key);
						}catch (Exception e) {
//						  throw new OrderDetailUnableSaveException("财务已经平过帐,无法删除!");
						}	
						
						
					}

				 
			 }
			
		}


	}
}

public String saveOrderLog(Order orderBackUp, Order order) {
	String tvName = SysParamUtil.getTvNameParam();
	String loginUser = orderBackUp.getLoginUser(); 
	RequestObject requestObject = RequestUtil.getReqInfo();
	String clientIp =requestObject!= null? requestObject.getRemoteAddr():"未查明";
	StringBuffer sb = new StringBuffer();
	OrderLogDao orderLogDao = ServiceLocator.getOrderLogDao();
	OrderLogUtil.comparaOrderValue( sb, clientIp, orderBackUp,  order, orderLogDao);
	return null;
	
}
public void saveOrderMemo(Order order)
{
	Map mp = new HashMap();
	mp.put("orderMemo",order.getOrderMeno());
	mp.put("publishMemo",order.getPublishMemo());
	mp.put("id",order.getId());
	dao.saveOrderMemo(mp);
}

//public void getOrderDayInfosByOrderDetailId(Map mpDetalBak,Map mp1, Map resMap2,Long detailId,Map newDayInfosMap,List lsUpdate){
//List lsCur = new ArrayList();
//List lsBak = new ArrayList();
//List lsRemoveIds = new ArrayList();
//
////Map mpRes = getResMap((OrderDetail)orderDetailMap.get(orderDetailId));
//
//OrderDetail orderDetail =(OrderDetail) mp1.get(detailId);
//String adLen = orderDetail.getMatterLength();
//String resourceInfoId = orderDetail.getResourceInfoId().toString();
//String specificValue = StringUtil.getNullValue(orderDetail.getSpecificValue(),"");
//
//
////清除原来所有的时间资源
//Object obj = mpDetalBak.get(detailId);
//if(obj != null){
//	OrderDayInfo[] orderDayInfos_bak = (OrderDayInfo[])obj;
//	for(int p = 0;p < orderDayInfos_bak.length;p++){
//		OrderDayInfo orderDayInfo = orderDayInfos_bak[p];
//		long idd = Long.parseLong(StringUtil.getNullValue(orderDayInfo.getId(), "0"));
//		double money_in = orderDayInfo.getDayRelPuton().doubleValue();
//		String key = resourceInfoId +","+orderDayInfo.getPublishDate().toString();
//		DayInfo day_info = (DayInfo)resMap2.get(key);	
//		Long day_inf_id = day_info.getId();
//		double changeValue = 0;
//		if(newDayInfosMap.containsKey(day_inf_id)){
//			day_info =  (DayInfo)newDayInfosMap.get(day_inf_id);
//			changeValue = day_info.getChangedValue().doubleValue()-Double.parseDouble(adLen)*orderDayInfo.getAdDayTimes().intValue();
//		}else{
//			changeValue = -Double.parseDouble(adLen)*orderDayInfo.getAdDayTimes().intValue();
//		}
//
//		day_info.setChangedValue(new Double(changeValue));
//		
//		String spec_res = StringUtils.isEmpty(day_info.getSpecific())? "":day_info.getSpecific();
//		
//		System.out.println("spec_res>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ spec_res); 
//		System.out.println("specificValue>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ specificValue); 
//		
////		1 包含  2 不包含 3、追加  4 、其它排除空的
//		if(!"".equals(specificValue) && !"0".equals(specificValue)){
//			 if(spec_res.indexOf(specificValue) >-1){
//				 spec_res = StringUtil.selectStr(spec_res,specificValue,2);
//				 day_info.setSpecific(spec_res);
//			 }
//
//		}
////				System.out.println("spec_res>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ spec_res); 
//		newDayInfosMap.put(day_info.getId(),day_info);	
//		
////		if(!lsCur.contains(new Long(idd))){
//			if(money_in >0){
//				orderDayInfo.setAdDayTimes(new Integer(0));
//				orderDayInfo.setDayRelIncome(new Double(0));
//				lsUpdate.add(orderDayInfo);
//			}else{
////				lsBak.add(orderDayInfo);
//				lsRemoveIds.add(new Long(idd));
//			}
////		}
//
//	}
//}
//
//if(lsRemoveIds.size()>0){
//   Map mapRemove = new HashMap(); 
//   mapRemove.put("OrderDayInfoIdList",lsRemoveIds);
//   System.out.println("lsRemoveIds>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ lsRemoveIds); 
//   orderDayInfoDao.removeOrderDayInfos(mapRemove);
//}
//
//
//}





}

