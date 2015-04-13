//	orderDetail.obj.orderCategoryMain
package com.vriche.adrm.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.CompagesDao;
import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.model.BroReport;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Compages;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.DayInfoArray;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.MonthInfo;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.OrderLog;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.model.RequestObject;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.User;
import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.IncomeUsedManager;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderDetailUnableSaveException;
import com.vriche.adrm.service.ResourceChannelManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.service.WorkspanManager;
import com.vriche.adrm.util.CarrierParentIdComparator;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.DayInfoUtil;
import com.vriche.adrm.util.OrderDayInfoUtil;
import com.vriche.adrm.util.OrderDayUtil;
import com.vriche.adrm.util.OrderDetailAdNameComparator;
import com.vriche.adrm.util.OrderDetailUtil;
import com.vriche.adrm.util.OrderLogUtil;
import com.vriche.adrm.util.RequestUtil;
import com.vriche.adrm.util.ResDayUtil;
import com.vriche.adrm.util.ResourceUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class OrderDetailManagerImpl extends BaseManager implements OrderDetailManager {
	
	private CarrierManager carrierManager;
	private ResourceChannelManager resourceChannelManager;
    private OrderDetailDao dao;
    private OrderDao orderDao;
    private MatterDao matterDao;
    private OrderDayInfoDao orderDayInfoDao;
    private DayInfoDao dayInfoDao;
    private ResourceDao resourceDao;
    private CompagesDao compagesDao;
    private PriceDao priceDao;
    private CarrierDao carrierDao;
    private MatterManager matterManager;
    private UserManager userManager;
    private IncomeUsedManager incomeUsedManager;
    private WorkspanManager workspanManager;
    private OrderLogDao orderLogDao;
    private ContractPaymentDao contractPaymentDao; 

    
//    private IncomeDao incomeDao;
//    private IncomePullDao incomePullDao;
//    private IncomeUsedDao incomedUseDao;
    
    
   
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	/**
	 * @param orderLogDao The orderLogDao to set.
	 */
	public void setOrderLogDao(OrderLogDao orderLogDao) {
		this.orderLogDao = orderLogDao;
	}
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
   
    /**
	 * @param carrierManager The carrierManager to set.
	 */
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}
	
	public void setResourceChannelManager(
			ResourceChannelManager resourceChannelManager) {
		this.resourceChannelManager = resourceChannelManager;
	}

    public void setMatterManager(MatterManager matterManager) {
		this.matterManager = matterManager;
	}
	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOrderDetailDao(OrderDetailDao dao) {
        this.dao = dao;
    }
	/** 
	 * @param matterDao The matterDao to set.
	 */
	public void setMatterDao(MatterDao matterDao) {
		this.matterDao = matterDao;
	}
	
	/** 
	 * @param orderDayInfoDao The orderDayInfoDao to set.
	 */
	public void setOrderDayInfoDao(OrderDayInfoDao orderDayInfoDao) {
		this.orderDayInfoDao = orderDayInfoDao;
	}
	/** 
	 * @param dayInfoDao The dayInfoDao to set.
	 */
	public void setDayInfoDao(DayInfoDao dayInfoDao) {
		this.dayInfoDao = dayInfoDao;
	}	
	/** 
	 * @param resourceDao The resourceDao to set.
	 */
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}			
	
	/** 
	 * @param compagesDao The compagesDao to set.
	 */
	public void setCompagesDao(CompagesDao compagesDao) {
		this.compagesDao = compagesDao;
	}	
	/** 
	 * @param priceDao The priceDao to set.
	 */
	public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}
	public void setCarrierDao(CarrierDao carrierDao) {
		this.carrierDao = carrierDao;
	}
	
//	public void setIncomeDao(IncomeDao incomeDao) {
//		this.incomeDao = incomeDao;
//	}
//	public void setIncomedUseDao(IncomeUsedDao incomedUseDao) {
//		this.incomedUseDao = incomedUseDao;
//	}
//	public void setIncomePullDao(IncomePullDao incomePullDao) {
//		this.incomePullDao = incomePullDao;
//	}
	
	/**
	 * @param workspanManager The workspanManager to set.
	 */
	public void setWorkspanManager(WorkspanManager workspanManager) {
		this.workspanManager = workspanManager;
	}
	
	
	public void setContractPaymentDao(ContractPaymentDao contractPaymentDao) {
		this.contractPaymentDao = contractPaymentDao;
	}


    /**
     * @see com.vriche.adrm.order.service.OrderDetailManager#getOrderDetailsByIdList(final Map idList)
     */
    public List getOrderDetailsByIdList(final Map idList) {
        return dao.getOrderDetailsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.order.service.OrderDetailManager#getOrderDetails(com.vriche.adrm.order.model.OrderDetail)
     */
    public List getOrderDetails(final OrderDetail orderDetail) {
    	List ls = dao.getOrderDetails(orderDetail);
    	Iterator it = ls.iterator();
		while(it.hasNext()){
			OrderDetail od = (OrderDetail)it.next();
	    	String lable = ResourceUtil.getResourceName(od.getResource(),1);
	    	orderDetail.getResource().setResourceName(lable);
		}
        return ls;
    }
    
    
    
    /**
     * @see com.vriche.adrm.order.service.OrderDetailManager#getOrderDetail(String id)
     */
    public OrderDetail getOrderDetail(final String id) {

    	boolean industryLevel2 = SysParamUtil.getIndustryLevel2Param();
    	
    	
    	
//    	System.out.println("getIndustryLevel2Param vvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>" + industryLevel2);	
//    	System.out.println("id vvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>" + id);
    	
    	System.out.println("saveOrderDetail>*****************************************>>>>saveOrderDetail>>>>>go>>>>>saveOrderDetail>>>>>>>  33 44 55 " );	
    	  
    	OrderDetail orderDetail = dao.getOrderDetail(new Long(id));
    	
    	System.out.println("saveOrderDetail>*****************************************>>>>saveOrderDetail>>>>>go>>>>>saveOrderDetail>>>>>>>  33 44 55 66" );	
    	  
    	
//    	System.out.println("getOrderDetail 8888888888888888888888888888>>>>>>>>>>>>>>>" + orderDetail.toString());	
    	
    	String lable = ResourceUtil.getResourceName(orderDetail.getResource(),1);
    	orderDetail.getResource().setResourceName(lable);

    	
    	
    	if(industryLevel2){
    		Industry Industry =  orderDetail.getIndustry();
    		String name = Industry.getName();
    		String parentName = StringUtil.getNullValue(Industry.getParentName(),"");
    		if(!"".equals(parentName)) name =parentName+"/"+name;
    		Industry.setName(name);
    	}
    	
    	
    	String carrierName = getCarrierParentStr(orderDetail);
    	orderDetail.getCarrier().setCarrierName(carrierName);
    	
//    	orderDetail.setPublishStartDate(orderDetail.getOrderPublic().getPublishStartDate());
//    	orderDetail.setPublishEndDate(orderDetail.getOrderPublic().getPublishEndDate());
    	
//    	orderDetail.getCarrier().setId(new Long(orderDetail.getCarrierId()));
//    	System.out.println("vvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>" + carrierName);	
    	
    	
    	
    	if(orderDetail.getCompagesId().longValue() >0){
    		Compages compages = compagesDao.getCompages(orderDetail.getCompagesId());
    		compages.setResources(getResources(orderDetail.getCompagesId()));
    		orderDetail.setCompages(compages);   		
    	}
        return orderDetail;
    }
    
    
    private String getCarrierParentStr(OrderDetail orderDetail){
    	String tvName = SysParamUtil.getTvNameParam();
    	boolean fztv = SysParamUtil.isFZTVParam(tvName);
    	boolean xmtv = SysParamUtil.isXMTVParam(tvName);
    	boolean displayCarrierType = SysParamUtil.getCarrierTypeDisplay();
    	boolean orderCarrierLevelOne = SysParamUtil.getOrderCarrierLevelOne();
    	
    	Long curCarrierId = orderDetail.getCarrier().getId();
//    	SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//    	boolean isDisplayCarrierType = (sysParam.getOrderCarrierTypeDisplayParam().equals("0")|| sysParam.getOrderCarrierTypeDisplayParam() == null)?false:true;
    	
    	
    	String carrierTypeName =  orderDetail.getCarrier().getCarrierType().getName();
    	
    	String name = "";
    	Map carrierParentsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
//    	List carrierTypes = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_TYPES);
    
    	List carrierParentsList = (List)carrierParentsMap.get(curCarrierId);
    	Collections.sort(carrierParentsList,new CarrierParentIdComparator());
   
    	
    	
    	if(orderCarrierLevelOne){
    		if(carrierParentsList.size()>0){
    			Carrier carrier = (Carrier)carrierParentsList.get(0);
    			name = carrier.getCarrierName();
    			if(displayCarrierType) name = carrierTypeName +"::" +name;
    		}else{
    			name = "";
    		}
    		 
//        	for(Iterator it = carrierParentsList.iterator();it.hasNext();){
//        		Carrier carrier = (Carrier)it.next();
//        		name = carrier.getCarrierName();
//        	}
        	
    	}else{
        	for(Iterator it = carrierParentsList.iterator();it.hasNext();){
        		Carrier carrier = (Carrier)it.next();
        		name += carrier.getCarrierName();
        		if(it.hasNext()) name +="||";
        	}
        	
        	if(displayCarrierType) name = carrierTypeName +"::" +name;
    	}

    	
    	
    	
    	
//    	System.out.println("vvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>" + orderDetail.get);	
    	
    	return name;
    }
    
    private Set getResources(Long compagesId){
		Set res = new HashSet();
		List ls = resourceDao.getResourcesByCompagesId(compagesId);
		for(Iterator it = ls.iterator();it.hasNext();){
			Resource resource = (Resource) it.next();
			res.add(resource);
		}
		return res;
    }
    

    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.OrderDetailManager#getOrderDetailByOrderId(java.lang.Long)
     */
    public List getOrderDetailByOrderId(final String  id) {
        return dao.getOrderDetailByOrderId(new Long(id));
    }
  
    
    public String getOrderDetailByOrderIdCount(String id) {
		return dao.getOrderDetailByOrderIdCount(id).toString();
	}

	public String getOrderDetailsCount(OrderDetail orderDetail) {
		return dao.getOrderDetailsCount(orderDetail).toString();
	}    

	public List getOrderDetailsPage(OrderDetail orderDetail, String pageIndex, String pageSize) {
		return dao.getOrderDetailsPage(orderDetail,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}
	
	
	public String getOrderDetailsPageXML(OrderDetail orderDetail, String pageIndex, String pageSize) {
//		 long start1 = System.currentTimeMillis();
		List ls = new ArrayList();
		String tvName = SysParamUtil.getTvNameParam();
		String loginUser =orderDetail.getLoginUser();
		String orgId = orderDetail.getOrgId();
		String tableModel = StringUtil.getNullValue(orderDetail.getTableModel(),"0");
		String orderId = orderDetail.getOrderId().toString();
		String detail_Ids = StringUtil.getNullValue(orderDetail.getDetailIds(),"");
		
		if(!"".equals(detail_Ids)){
			String[] detailIds = detail_Ids.split(",");
		  List detailIdsIdList = new ArrayList();
			CollectionUtils.addAll(detailIdsIdList,detailIds);
			orderDetail.setDetailIdsIdList(detailIdsIdList);
		}
		

		
		
		
		if("5".equals(tableModel)){
			ls = dao.getOrderDetailsPage2(orderDetail);
			
			System.out.println("getOrderDetailsPageXML size mmmmmmmmmmmmmmmmmmmmmmmmmmmmm"+ ls.size() +"  ##################       mmsad;asd  vvvvvvvvvvvvvvvvvv tableModel >>>>>>>>>>>>>>>" + tableModel);	
			
			
		}else if("3".equals(tableModel)){
			
			Map mpp = new HashMap();
	    	
			String publishDateStart = orderDetail.getOrderPublic().getPublishStartDate().toString();
			String publishDateEnd = orderDetail.getOrderPublic().getPublishEndDate().toString();
			String carrierId = orderDetail.getCarrierId();
			List carrierIdList = new ArrayList();
			
			if(!"".equals(carrierId) && carrierId != null){
				  carrierIdList = CarrierUtil.getCarrierIds(carrierId,"2",loginUser);
				 	mpp.put("carrierIdList",carrierIdList);
			}
			
			
			mpp.put("orderId",orderDetail.getOrderId());
			mpp.put("startDate",publishDateStart);
			mpp.put("endDate",publishDateEnd);

			ls = dao.getOrderDetailsForBroProve(mpp);

			
	    	Iterator it = ls.iterator();

			
//			System.out.println("vvvvvvvvvvvvvvvvvv publishDateStart >>>>>>>>>>>>>>>" + publishDateStart);	
//			System.out.println("vvvvvvvvvvvvvvvvvv publishDateEnd >>>>>>>>>>>>>>>" + publishDateEnd);	
	    	
				while(it.hasNext()){
					OrderDetail od = (OrderDetail)it.next();
					OrderDayInfo orderDayInfoParam = new OrderDayInfo();

//					System.out.println("vvvvvvvvvvvvvvvvvv od.getId() >>>>>>>>>>>>>>>" + od.getId());	
//					System.out.println("vvvvvvvvvvvvvvvvvv publishDateStart >>>>>>>>>>>>>>>" + publishDateStart);	
//					System.out.println("vvvvvvvvvvvvvvvvvv publishDateEnd >>>>>>>>>>>>>>>" + publishDateEnd);	
//					orderDayInfoParam.setOrderDetailId(od.getId());
//					orderDayInfoParam.setStartDate(publishDateStart);
//					orderDayInfoParam.setEndDate(publishDateEnd);
//					List lsOrd = orderDayInfoDao.getOrderDayInfos(orderDayInfoParam);
					

					
					Map mp1 = new HashMap();
					mp1.put("orderDetailId",od.getId());
					mp1.put("startDate",publishDateStart);
					mp1.put("endDate",publishDateEnd);
					
					List lsOrd = orderDayInfoDao.getOrderDayInfosCopy2(mp1);
					
					
//					System.out.println("vvvvvvvvvvvvvvvvvv lsOrd.size() >>>>>>>>>>>>>>>" + lsOrd.size());	
					
					if(lsOrd.size()>0){
						Object[] ids = ConvertUtil.getColFromList(lsOrd,"id");
						Object[] publishDates = ConvertUtil.getColFromList2(lsOrd,"publishDate");
						
//						System.out.println("vvvvvvvvvvvvvvvvvv ids >>>>>>>>>>>>>>>" + ids);	
//						System.out.println("vvvvvvvvvvvvvvvvvv publishDates >>>>>>>>>>>>>>>" + publishDates);	
						
						List orderDay_dates = new ArrayList();
						List array_dates = new ArrayList();
						List lsArray =new ArrayList();
						CollectionUtils.addAll(orderDay_dates,publishDates);
						
						Map mp = new HashMap();
						List orderDayIdList = new ArrayList();
						CollectionUtils.addAll(orderDayIdList,ids);
//						System.out.println("vvvvvvvvvvvvvvvvvv orderDayIdList >>>>>>>>>>>>>>>" + orderDayIdList);	
						
						mp.put("orderDayIdList",orderDayIdList);
						mp.put("publishDateStart",publishDateStart);
						mp.put("publishDateEnd",publishDateEnd);
				   List lsArray1 = ServiceLocator.getPublishArrangeDetailDao().getArrangedPublishForWebService(mp);
				   
				   
				
			    	Iterator it1 = lsArray1.iterator();
			    	    
			    	while(it1.hasNext()){
					    	    	PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it1.next();
											Integer publishDate = publishArrangeDetail.getPublishArrange().getPublishDate();	
											Integer ctrBroTime = publishArrangeDetail.getCtrBroTime();
//											System.out.println("vvvvvvvvvvvvvvvvvv publishDate >>>>>>>>>>>>>>" + publishDate);	
//											System.out.println("vvvvvvvvvvvvvvvvvv ctrBroTime >>>>>>>>>>>>>>" + ctrBroTime);	
											if(ctrBroTime == null){
												lsArray.add(publishDate);
											}
											array_dates.add(publishDate);
			    	  }
//			    	System.out.println("vvvvvvvvvvvvvvvvvv lsArray >>>>>>>>>>>>>>>" + lsArray);	
			    	
//			    	System.out.println("vvvvvvvvvvvvvvvvvv array_dates >>>>>>>>>>>>>>>" + array_dates.size());	
//			    	 System.out.println("vvvvvvvvvvvvvvvvvv orderDay_dates >>>>>>>>>>>>>>>" + orderDay_dates);	
//			    	 System.out.println("vvvvvvvvvvvvvvvvvv array_dates >>>>>>>>>>>>>>>" + array_dates);	
		
			    orderDay_dates.removeAll(array_dates);
			    
//			    System.out.println("vvvvvvvvvvvvvvvvvv after removeAll  orderDay_dates >>>>>>>>>>>>>>>" + orderDay_dates.size());	
	
			    CollectionUtils.addAll(lsArray,orderDay_dates.iterator());
			    
//			    System.out.println("vvvvvvvvvvvvvvvvvv after lsArray.add(orderDay_dates) >>>>>>>>>>>>>>>" + lsArray);	
				   
				   
				    StringBuffer json = new StringBuffer();  
				    
				    
				    
				    json.append("[");  
				    
				    if (lsArray != null && lsArray.size() > 0) {  
				    	
				    	    Iterator it2 = lsArray.iterator();
				    	    
				    	    while(it2.hasNext()){
					    	    	String publish_date = it2.next().toString();
					    	    	String  publishDate = DateUtil.SetDateFormat(publish_date,"yyyy年MM月dd日");
					    	    	json.append(publishDate);  
					    	    	json.append(",");  
				    	    			}
				      json.setCharAt(json.length() - 1, ']');  
				    } else {  
				      json.append("]");  
				    		}  			   
				   
				   
				    String noInputTimeDates = json.toString();
				    
				    od.setMemo(noInputTimeDates);
				    
//				    if(lsArray.size() ==0) noInputTimeDates ="";
//				    
////				    System.out.println("vvvvvvvvvvvvvvvvvv noInputTimeDates >>>>>>>>>>>>>>>" + noInputTimeDates);	
//				    
//				    if(!"".equals(noInputTimeDates)){
//				    		od.setMemo(noInputTimeDates);
//				    		}

					}	

				}
				
		}else{
			ls = dao.getOrderDetailsPage(orderDetail,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		}

//    	Iterator it = ls.iterator();
//		while(it.hasNext()){
//			OrderDetail od = (OrderDetail)it.next();
//			System.out.println("getOrderDetailsPageXML>>>>3333333333333333333333>4444444444444444444444444>555555555555555555555>>   "+ od.getResource().getWorkspan() +"条");
//	    	String lable = ResourceUtil.getResourceName(od.getResource(),1);
//	    	od.getResource().setResourceName(lable);
//		}
		
		
			
//		System.out.println("ls>>>>>>>>   "+ ls.size() +"条");
//		if(SysParamUtil.isFZTVParam(tvName) || SysParamUtil.isXMTVParam(tvName)){
//			Collections.sort(ls,new OrderDetailResourceMemoComparator());
//		}
		StringBuffer sb = new StringBuffer();
//		long end1 = System.currentTimeMillis();
//		System.out.println("search orderDetail>>>>>>>>   "+ (end1 -start1) +" (ss) ");
	
		OrderDetailUtil.makeTreeGridXML2(sb,ls,pageIndex,pageSize,loginUser,orgId,tableModel, orderId);
//		long end2 = System.currentTimeMillis();
//		System.out.println("search orderDetail draw table>>>>>>>>   "+ (end2 -end1) +"(SS)");
		
		return sb.toString();
	}
	
	
	
	
	
	
    
	public PaginatedList getOrderDetailByOrderIdPage(String id, String pageIndex, String pageSize) {
		return dao.getOrderDetailByOrderIdPage(new Long(id),Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String  getOrderDetailForXML(final String id) {
        return dao.getOrderDetailForXML(new Long(id));
    }
	
	
 private Double getResourceSysPrice(Long resourceInfoId,String length,Long priceTypeId) throws Exception{
	 try{
	    	Double price = priceDao.getPriceByResourceIdAndLength(resourceInfoId,length,priceTypeId);
	    	price = price == null?new Double(0):price;
	    	return price;
	   }catch (Exception e) {

		   return new Double(0);
        }	 	


    }
    

    
    private Long saveMatter(OrderDetail orderDetail,Long createBy){
        Long customerId = orderDetail.getMatter().getCustomerId();
    	String name = orderDetail.getMatter().getName();
    	String version = orderDetail.getMatter().getEdit();
    	String Length = orderDetail.getMatter().getLength();
        String tapeCode = orderDetail.getMatter().getTapeCode();
        Integer type =orderDetail.getMatter().getMatterType();
        String meno = orderDetail.getMatter().getMemo();
        Long industryType = orderDetail.getMatter().getBrandId();
        Long brandId = orderDetail.getMatter().getBrandId2();
        Matter matter = matterManager.saveMatter(customerId,tapeCode,name,version,Length,createBy,type,meno,true,industryType,brandId);
        orderDetail.getMatter().setId(matter.getId());
        orderDetail.getMatter().setTapeCode(matter.getTapeCode());  
 
    	return matter.getId(); 
    }
    
    
    private OrderDetail saveMatterReturnObj(OrderDetail orderDetail,Long createBy){
        matterManager.saveMatterTest(orderDetail);         
    	return orderDetail;
    }

    
    public OrderDetail saveOrderDetailReturnObj(OrderDetail orderDetail) {
    	
    	   try {
    		   saveOrderDetail(orderDetail);

		   }catch (Exception e) {
			   System.out.println("saveOrderDetailReturnObj>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +e.getMessage() );	
	        }	 	
    	
    	
    	return orderDetail;
    }
    
    
  
    
    
    
    /**
     * @see com.vriche.adrm.order.service.OrderDetailManager#saveOrderDetail(OrderDetail orderDetail)
     */
	public String saveOrderDetail(OrderDetail orderDetail) throws OrderDetailUnableSaveException{ 
		
		
//		 System.out.println("saveOrderDetailReturnObj getMoneyRealpay>>>>>>>>>>>>>>>> 8888888888888888888888888888888888            99999999999999999999999          >>>>>>>>>>>>>>>>>" +orderDetail.getMoneyRealpay() );	
		 
		 
    	boolean isCompages = false;	
    	boolean isNew = (orderDetail.getId() == null) || StringUtils.isEmpty(orderDetail.getId().toString());
    	
    	boolean isPackeg =  Boolean.valueOf(StringUtil.getNullValue(orderDetail.getIsCompages(),"false")).booleanValue();
    	int financeBalanceModelParam = SysParamUtil.getFinanceBalanceModelParam();
    	
		 Map orderDayInfoMapBak  = new HashMap();
		 Map orderDayInfoMapCur  = new HashMap();
		 Map newResMap = new HashMap();
//		 返回的排期状态标志 0、不修改  1、是新添  2、修改订单日信息及资源信息  3、修改资源信息（只修改指定）
		 int model = OrderDayInfoUtil.getModiyState(orderDetail,orderDayInfoMapBak,orderDayInfoMapCur);
		 
//		 System.out.println("saveOrderDetail>>>>>>>>>>>>>>>>>>>>>>>>>>>> getResourceInfoId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetail.getResourceInfoId() );	
		 
//		 System.out.println("saveOrderDetail getModiyState>>>>>>>>>>>>>>>>>>>>>>>>>>>>model>>>>>>>>              ######################          >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + model );	
		
		 String msg = OrderDayInfoUtil.unAbleSaveWarn(model,orderDetail,orderDayInfoMapBak,orderDayInfoMapCur,newResMap);

		 if (!"".equals(msg) && !isPackeg) {
			 
//			   System.out.println("unAbleSaveWarn>>>>>>>>>>>>>>>>>>>>>>>>>>>> msg >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + msg );	
	
			   try {
				   Integer aa  = new Integer("aaa");
				   if(orderDetail.getOrderDetailBak().getId() != null){
		        	   return orderDetail.getOrderDetailBak().getId().toString();
		           }else{
		        	   return "0";
		           }
				   
			   }catch (Exception e) {
		            throw new OrderDetailUnableSaveException(msg);
		        }	

		}else{
			 
			
			System.out.println("saveOrderDetailReturnObj getMoneyRealpay>>>>>>>>>>>>>>>>77777777   8888888888888888888888888888888888            99999999999999999999999          >>>>>>>>>>>>>>>>>" +orderDetail.getMoneyRealpay() );	
			  
			 
	    	orderDetail = saveMatterReturnObj(orderDetail, orderDetail.getCreateBy());
       
	    	if(orderDetail.getCompagesId() != null){ 
	    		if(orderDetail.getCompagesId().longValue() > 0) isCompages = true;
	    	}
//	    	orderDetail.setMatterId(orderDetail.getMatter().getId());           
//			orderDetail.setMatterId(matterId);
//			Double sysPrice = (orderDetail.getSysPrice() == null) ? new Double(0):orderDetail.getSysPrice();
//			Double execPrice = (orderDetail.getExecPrice() == null) ? new Double(0):orderDetail.getExecPrice();
//			orderDetail.setSysPrice(sysPrice);
//			orderDetail.setExecPrice(execPrice);
	    	Date now_date = new Date();
			if(isNew) {
				orderDetail.setCreateDate(now_date);
				orderDetail.setModifyDate(now_date);
			}else{
				orderDetail.setModifyDate(now_date);
			}
			
			if(isCompages && orderDetail.getParentId().intValue()==0){
				orderDetail.setNeedPublish(new Integer(0));
			}else{
				orderDetail.setNeedPublish(new Integer(1));
			}

//			 System.out.println("saveOrderDetail>*****************************************>>>>saveOrderDetail>>>>>go>>>>>saveOrderDetail>>>>>>>" +orderDetail.getId() );	

			
	  		  Long id = orderDetail.getId();
			  if (id == null || id.toString().equals("0")) {
				  String changeContent ="新添这条记录" +" , , "+ "\n\r";
		            OrderLogUtil.saveLog(orderDetail, changeContent);
			  }			
			
			  
//			  System.out.println("saveOrderDetail>*****************************************>>>>saveOrderDetail>>>>>go>>>>>saveOrderDetail>>>>>>>  33 44 55 " );	
  
			 dao.saveOrderDetail(orderDetail);
			 
//			 System.out.println("saveOrderDetail>*****************************************>>>>saveOrderDetail>>>>>go>>>>>saveOrderDetail>>>>>>> 33 44 55 66"  );	


			//判断是否需要保存日信息
//			 System.out.println("saveOrderDetail orderDetail.getIsSaveOrderDayInfo().booleanValue()>>>>> 1111 111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetail.getIsSaveOrderDayInfo().booleanValue() );	
				
			if(orderDetail.getIsSaveOrderDayInfo().booleanValue()){

				 if(model != 0 && newResMap.size()>0){
//					 System.out.println("saveOrderDetail>*****************************************>>>>financeBalanceModelParam>>>>>go>>1>>>>>>>>>>" + financeBalanceModelParam );	
					 if(financeBalanceModelParam == 0){
						  OrderDayInfoUtil.saveOrderDayInfos(model,orderDetail,newResMap,orderDayInfoMapBak,orderDayInfoMapCur);
					 }
					 
					 if(financeBalanceModelParam == 1){
						  OrderDayInfoUtil.saveOrderDayInfos2(model,orderDetail,newResMap,orderDayInfoMapBak,orderDayInfoMapCur);
					 }				 
					 
				   
//				     System.out.println("saveOrderDetail>*****************************************>>>>1234567887654321>>>>>go>>>2>>>>>>>>>" + model );	
				 }

			    if(isCompages && orderDetail.getParentId().longValue() == 0){
//			    	 System.out.println("saveOrderDetail>*****************************************>>>>1234567887654321>>>>>go>>>>3>>>>>>>>" + model );	
			    	saveCompose(orderDetail,isNew,false);
//			    	 System.out.println("saveOrderDetail>*****************************************>>>>1234567887654321>>>>>go>>>>>4>>>>>>>" + model );	
			    }

			
//			    long start5 = System.currentTimeMillis();     
			    if(orderDetail.getIsNotInSeries( )== null){//为了实现导入订单不进行分配，因为太慢了   
//			    	 System.out.println("saveOrderDetail>*****************************************>>>>1234567887654321>>>>>go>>>>>4>>>>>>>" + model );	
//				   	 System.out.println("saveOrderDetail>*********111*****************newResMap***************>>>>1234567887654321>>>>>>>>>>>>>>>" + newResMap.size() );
//					 System.out.println("saveOrderDetail>***********22***********getMoneyRealpay*******************>>>>1234567887654321>>>>>>>>>>>>>>>" + orderDetail.getMoneyRealpay() );  	
//					 System.out.println("updateOrderDayRealpay>*****************************************>>>>updateOrderDayRealpay>>>>>go>>>>>updateOrderDayRealpay>>>>>>>"  );	
			    	updateOrderDayRealpay(orderDetail,isCompages);
			    	
			    	saveOrderDetailPublicInfo(orderDetail,1);  
			    }

			}
			 
			
			System.out.println("saveOrderDetail getModiyState>>>>>>>>>>>>>>>>>>>>>>>>>model>>>>>>>>              ######################          >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + model );	
			
			
	        return orderDetail.getId().toString();
		}
		 

    }
    
    //保存冗余数据，
	public void saveOrderDetailPublicInfo(OrderDetail orderDetail,int opt){
	    Integer model = new Integer(orderDetail.getOrderCategoryMain());
	    boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
	    boolean isNew = (orderDetail.getId() == null) || StringUtils.isEmpty(orderDetail.getId().toString());
        if(((model.intValue()  == 0||model.intValue()  == 2) && opt == 2)||opt == 1){
//    	    Long contractId = orderDetail.getOrder().getContractId();
//    	    Long paymentId = orderDetail.getOrder().getPaymentId();
//    	    Long paymentId = orderDetail.getPaymentId();
    	    Long paymentId = Long.valueOf(StringUtil.getNullValue(orderDetail.getPaymentId(),"0"));   
    	    
    	    Long orderDetailId = orderDetail.getId();
    	    Long orderId = orderDetail.getOrderId();
    	    if(paymentId.longValue() >0){
    	    	 model = new Integer(3);
    	    }
    	    
         	if(isWithResourceSort){
         		if(model.intValue() != 1) orderDetailId = new Long(0);;
         		
         	}
    	    
        	Map mp = new HashMap();
        	mp.put("model",model);
            mp.put("orderDetailId",orderDetailId);       		
        	mp.put("orderId",orderId);
        	mp.put("paymentId",paymentId);
        	
//        	System.out.println("updateOrderDayRealpay used orderId>>" + contractId +"秒");	 
        	System.out.println("updateOrderDayRealpay used orderId>>" + orderId +"秒");	 
        	System.out.println("updateOrderDayRealpay used orderDetailId>>" + orderDetailId +"秒");	 
        	System.out.println("updateOrderDayRealpay used paymentId 1***************************************************************************>>" + orderDetail.getOrder().getPaymentId() +"秒");	
        	System.out.println("updateOrderDayRealpay used paymentId 2***************************************************************************>>" + orderDetail.getPaymentId() +"秒");	
        	System.out.println("updateOrderDayRealpay used model ***************************************************************************>>" + model +"秒");	 
        	
        	dao.saveOrderDetailPublicInfo(mp);
        	
        	//处理订单明细 的加收及折扣  如果实收大于刊例修改加收  反之 优惠处理
        	OrderDetail orderDet= new OrderDetail();
        	Map mpResType = new HashMap();
        	if(model.intValue() == 0 || model.intValue()==3){
        	
        		if(model.intValue() == 0){
        			orderDet.setOrderId(orderId);
        		}else{
        			orderDet.setPaymentId(paymentId);
        		}
        		List ls = dao.getOrderDetailsForChangeRate(orderDet);
        		List ls2 =  new ArrayList();
        		Iterator it = ls.iterator();

        		while(it.hasNext()){
        			OrderDetail od = (OrderDetail)it.next();
        			
        			mpResType.put(od.getResource().getResourceType().toString(),null);
        			
        			double baseMoney = od.getOrderPublic().getMoneyBase().doubleValue();
        			double relMoney = od.getOrderPublic().getMoneyRealpay().doubleValue();
        			double rate = baseMoney >0? relMoney/baseMoney:0;
        			if(rate > 1){
        				od.setAppRate(new Double(rate));
        				od.setFavourRate(new Double(0));
        				ls2.add(od);
        			}
        			if(rate < 1){
        				od.setAppRate(new Double(0));
        				od.setFavourRate(new Double(rate));
        				ls2.add(od);
        			}
        		}
        		
    			if(ls2.size() >0 ) dao.saveOrderDetailRate(ls2);
        		
        		System.out.println("updateOrderDayRealpay 处理订单明细 的加收及折扣  如果实收大于刊例修改加收 ***************************************************************************>>" +ls.size());	 
        		
        	}
        	
//        	else{
//        	
//        		orderDet.setOrderId(orderId);
//            	List ls = dao.getOrderDetailsForChangeRate(orderDet);
////            	if(ls.size() >0 ) dao.saveOrderDetailRate(ls);
//            	
//            	Iterator it = ls.iterator();
//            	while(it.hasNext()){
//            		OrderDetail od = (OrderDetail)it.next();
//            		mpResType.put(od.getResource().getResourceType().toString(),null);
//            	}
//            	
//            	if(mpResType.size() >1){
//            		
//            	}else{
//            		
//            	}
//            	
//            	
//
//        	}
        	
        	//此处是针对资源分类的催款处理
//           	System.out.println("saveOrderDetailPublicInfo mpResType ***************************************************************************>>" + mpResType.size() +"秒");	 
        	
        	
        }

    }


    
    private Map getOrderDetailIdsByParent(Long parentId){
    	Map odMap = new HashMap();
    	OrderDetail od = new OrderDetail();
    	od.setParentId(parentId);
    	List ls = dao.getOrderDetails(od);
		for(Iterator it = ls.iterator(); it.hasNext();){
			OrderDetail orderDetail = (OrderDetail) it.next();
			odMap.put(orderDetail.getResourceInfoId(),orderDetail.getId());
		}
    	return odMap;
    }
    
    
    private void saveCompose(OrderDetail orderDetail,boolean isNew,boolean removeDetail ){
    	Map odMap = new HashMap();
    	Long parentId = orderDetail.getId();
//    	Integer startDate = orderDetail.getPublishStartDate();
//    	Integer endDate = orderDetail.getPublishEndDate();
    	
    	Integer startDate = new Integer(DateUtil.getDate());
    	Integer endDate =  new Integer(DateUtil.getDate());
    	
    	
    	
    	
    	String[] resourceIds = orderDetail.getCompages().getResourceIds();
	    String length = orderDetail.getMatterLength();
	    Long priceTypeId = orderDetail.getResourcePriceType();
	    if(!isNew) odMap = getOrderDetailIdsByParent(orderDetail.getId());
	  
	    Date now_date = new Date();

	    for(int i = 0; i< resourceIds.length;i++){
	    		OrderDetail orderdetailDest = new OrderDetail();
	    		OrderDetailUtil.copyBeanProperties(orderdetailDest,orderDetail);
	    		Long resId = new Long(resourceIds[i]);
	    		Double sysPrice = new Double(0);
				try {
					sysPrice = getResourceSysPrice(resId,length,priceTypeId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				}
	    		sysPrice = (sysPrice == null)? new Double(0):sysPrice;
	    		orderdetailDest.setSysPrice(sysPrice);
	    		orderdetailDest.setExecPrice(new Double(0));
	    		orderdetailDest.setResourceInfoId(resId);
	    		orderdetailDest.setResourceSortId(new Long(1));
	    		orderdetailDest.setParentId(parentId);
	    		orderdetailDest.setNeedPublish(new Integer(1));
	    		
	    		if(isNew) {
	    			orderdetailDest.setId(null);
	    			orderdetailDest.setCreateDate(now_date);
	    			orderdetailDest.setModifyDate(now_date);
	    		}else{
	    			Long orderdetailDestId = (Long)odMap.get(resId);
//	    			log.info("orderdetailDestId>>>>>>>>>>" + orderdetailDestId.longValue());
	    			orderdetailDest.setId((Long)odMap.get(resId));
	    			orderdetailDest.setModifyDate(new Date());
	    		}
	    		
//	    		if(!removeDetail) dao.saveOrderDetail(orderdetailDest);
	    		
	    		  Long idd = orderdetailDest.getId();
	    		  if (idd == null || idd.toString().equals("0")) {
	    			  String changeContent ="新添这条记录" +" , , "+ "\n\r";
	    	            OrderLogUtil.saveLog(orderdetailDest, changeContent);
	    		  }
	    		dao.saveOrderDetail(orderdetailDest);
	    		
    			OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
    			
    			List orderDaysList = new ArrayList();
    			Map  orderDayMap = new HashMap();
				Map usedTimeChangeMap = new HashMap();
				Map specificChangeMap = new HashMap();
    			if(isNew){
	    	    	startDate = orderDetail.getPublishStartDate();
	    	    	endDate = orderDetail.getPublishEndDate();
    				usedTimeChangeMap = OrderDayUtil.getResourceChangeMap(orderDayInfos);
    			}else{
    				orderDaysList =  getOrderDayInfos(orderdetailDest.getId());
    				orderDayMap =  getOrderDayMap(orderDaysList);
    				Object[] objs = OrderDayUtil.getResourceChangeMap(orderDayInfos,orderDaysList);
        			usedTimeChangeMap =  (Map)objs[0];
        			specificChangeMap =  (Map)objs[1];
        			
        			//获得开始与结束日期
        			Map mp = OrderDayUtil.getPublishDate(orderDaysList);
	    	    	startDate = (Integer)mp.get("startDate");
	    	    	endDate = (Integer)mp.get("endDate");
    			}

    			
    			Map dayInfosMap = getDayInfosByResourceIds(resourceIds,startDate,endDate,usedTimeChangeMap,specificChangeMap);
    			Map dayMap = (Map)dayInfosMap.get(resId);
    			
			   	for(int j = 0;j < orderDayInfos.length;j++){
			   		Integer publishDate = orderDayInfos[j].getPublishDate();
			   		DayInfo dayInfo = (DayInfo)dayMap.get(publishDate);
			   		if(dayInfo == null)dayInfo = new DayInfo();
			   		
			   		if(isNew){
			   			orderDayInfos[j].setId(null);
			   		}else{
			   			orderDayInfos[j].setId((Long)orderDayMap.get(publishDate));
//			   			orderDayInfos[j].setId(dayInfo.getId());
			   		}
//		   			if(removeDetail){
//		   				orderDayInfos[j].setAdDayTimes(new Integer(0));
//		   				orderDayInfos[j].setResourceSpecific(String.valueOf(""));
//		   			}
			   		
			   		orderDayInfos[j].setOrderDetailId(orderdetailDest.getId());
			   		orderDayInfos[j].setDayStandardPrice(sysPrice);
//			   	    orderDayInfos[i].setPaymentId(orderdetailDest.getPaymentId());
			   		

			   		orderDayInfos[j].setDayInfo(dayInfo);
				}
			    orderDayInfoDao.saveOrderDayInfos(orderDayInfos);	
			    
//			    if(removeDetail)  dao.removeOrderDetail(orderdetailDest.getId());

	    }

    }
    
//    private void checkCompages(OrderDetail orderDetail){
//    	Long compagesId = orderDetail.getCompagesId();
//    	
//    	compagesId = compagesId == null || compagesId.equals("")? new Long(0):compagesId;
//    	
//    	if(compagesId.longValue() == 0){
//    		Compages compages = new Compages();
//    		
//    		String compagesName = orderDetail.getCompages().getName();
//    		
//    		compages.setName(compagesName);
//    		
//    		compagesDao.saveCompages(compages);
//    		
//    		compagesDao.saveCompagesAndResource(compages,compages.getId());
//    		
//    		orderDetail.setCompagesId(compages.getId());
//    	}
//    }
    
    
    private Map getOrderDayMap(List ls){
    	Map orderDayMap = new HashMap();
		for(Iterator it = ls.iterator(); it.hasNext();){
			OrderDayInfo orderDay = (OrderDayInfo) it.next();
			orderDayMap.put(orderDay.getPublishDate(),orderDay.getId());
		}
    	return orderDayMap;
    }
    
   //
   private Map getDayInfosByResourceIds(String[] ids,Integer startDate,Integer endDate,Map resourceAdChangeMap,Map specificChangeMap){
	   Map map = new HashMap();
	   List resourceIdList = new ArrayList();
	   CollectionUtils.addAll(resourceIdList,ids);
	   
	   map.put("startDate",startDate);
	   map.put("endDate",endDate);
	   map.put("ResourceIdList",resourceIdList);

	   List dayInfoList = dayInfoDao.getDayInfosByIdList(map);

	   Map mp = ResDayUtil.assemblyByList(ids,dayInfoList,resourceAdChangeMap,specificChangeMap);
	   return mp;
   }
   
   private List getOrderDayInfos(Long id){
		OrderDayInfo orderDayInfo = new OrderDayInfo();
		orderDayInfo.setOrderDetailId(id);
	    return  orderDayInfoDao.getOrderDayInfos(orderDayInfo);
   }
   

    /**
     * @see com.vriche.adrm.order.service.OrderDetailManager#removeOrderDetail(String id)
     */
   
   
  
 
   
   
   public void removeOrderDetail(OrderDetail orderDetail) throws OrderDetailUnableSaveException{ 
	   
   	int financeBalanceModelParam = SysParamUtil.getFinanceBalanceModelParam();
//	   orderDetail = orderDetail.getOrderDetailBak();
   	
   	
   	
//   		System.out.println("removeOrderDetail  orderDetail.getPaymentId()>>>>777777>>>>>"+orderDetail.getPaymentId());
//   		System.out.println("removeOrderDetail  orderDetail.getPaymentId()>>>>777777>>>>>"+orderDetail.getIsLastDetail().booleanValue());
   	
	   boolean isCompages = false;
	   
	   try {

							if (orderDetail.getCompagesId() != null) {
								if (orderDetail.getCompagesId().longValue() > 0)
									isCompages = true;
							}
					
							long parentId = orderDetail.getParentId().longValue();
					
							OrderDayInfoUtil.removeOrderDayInfos(orderDetail);
					
					//		log.info("removeOrderDetail>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetail.getId());
						   
					       dao.removeOrderDetail(orderDetail.getId());
					       
					   if(orderDetail.getIsNotInSeries()==null && !orderDetail.getIsLastDetail().booleanValue()){
					           updateOrderDayRealpay(orderDetail,isCompages);
					           //协约订单需要重新保存订单明细
					           saveOrderDetailPublicInfo(orderDetail,2);
					       }    
					   
					   
					
					       
					   	if (isCompages && parentId > 0) {
									String[] resourceIds = orderDetail.getCompages().getResourceIds();
									for (int i = 0; i < resourceIds.length; i++) {
										Long id = new Long(resourceIds[i]);
										dao.removeOrderDetail(id);
									}
								}	   
					   	
					   	
					   	
					 if(orderDetail.getIsLastDetail().booleanValue()){
						 ContractPayment contractPayment = new ContractPayment();
						 contractPayment.setOrderId(orderDetail.getOrderId());
						 List ls = contractPaymentDao.getContractPayments(contractPayment);
						 Object[] ids = ConvertUtil.getColFromList(ls,"id");
						 List lsIds = new ArrayList();
						 CollectionUtils.addAll(lsIds,ids);
						 Map mp = new HashMap();
						 mp.put("ContractPaymentIdList",lsIds);
						 	contractPaymentDao.removeContractPayments(mp);
					   }
					   	
   	
	   }catch (Exception e) {
           throw new OrderDetailUnableSaveException("财务已经平过帐,无法删除!");
       		}	
	   
	   
   }
   
    public void removeOrderDetail_bak(OrderDetail orderDetail) {
    	boolean isCompages = false;
    	if(orderDetail.getCompagesId() != null){
    		if(orderDetail.getCompagesId().longValue() > 0) isCompages = true;
    	}
    	
    	long parentId = orderDetail.getParentId().longValue();

	     OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
	     for(int i = 0;i < orderDayInfos.length;i++){
	    	 orderDayInfos[i].setOrderDetailId(orderDetail.getId());
	     }	    
	     
	     orderDayInfoDao.saveOrderDayInfos(orderDayInfos);	
    	
//    	saveOrderDetail(orderDetail);
    	
    	 
    	 
    	 
    	 
    	
//    	updateOrderDayRealpay(orderDetail,isCompages);


        dao.removeOrderDetail(orderDetail.getId());
        if(orderDetail.getIsNotInSeries()==null){
            updateOrderDayRealpay(orderDetail,isCompages);
            //协约订单需要重新保存订单明细
            saveOrderDetailPublicInfo(orderDetail,2);
        }   

        
    	if(isCompages && parentId > 0){
    		String[] resourceIds = orderDetail.getCompages().getResourceIds();
	   		 for(int i = 0; i< resourceIds.length;i++){
	   			 Long id = new Long(resourceIds[i]);
	   	        dao.removeOrderDetail(id);
	   		 }
    	}
    }

     /**
     * @see com.vriche.adrm.order.service.OrderDetailManager#removeOrderDetails(String Map)
     */
    public void removeOrderDetails(final Map idList) {
        dao.removeOrderDetails(idList);
    }

	public String getSumTimes(Long orderId) {
		return dao.getSumTimes(orderId).toString();
	}


	
	public void updateOrderDayRealpay(OrderDetail orderDetail,boolean isCompages){
		double sumMoney = 0;
		Long paymentId = new Long(0);
		Long detailId = new Long(0);
		Long orderId = new Long(0);
		Long contractId = new Long(0);
		
		boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
		int orderCalculateModelParam = SysParamUtil.getOrderCalculateModelParam();

		

		List orderDetailIds = new ArrayList();
		//订单类型，决定了应收款的分配形式 model=0 协约订单、协约合同   model=1 正常订单   model=2 部门订单
		

		int model = Integer.parseInt(orderDetail.getOrderCategoryMain());
//		Integer resourceType = isWithResourceSort ?orderDetail.getResource().getResourceType():new Integer(0);

		//如果是套播，先需要查找出与主明细相关的子明细编号
		if(isCompages){
			Long parentId =  orderDetail.getParentId();
			if(orderDetail.getParentId().longValue() > 0){
				 parentId = orderDetail.getParentId();
			}else{
				 parentId = orderDetail.getId();
			}
			OrderDetail orderdetail = new OrderDetail();
			orderdetail.setParentId(parentId);
			Object[] ids = ConvertUtil.getColFromList(dao.getOrderDetails(orderdetail),"id");
			CollectionUtils.addAll(orderDetailIds,ids);
		}
//		System.out.println("@@@@@@@@@@@"+orderDetail.getMoneyRealpay());
		
		if(orderDetail.getMoneyRealpay() != null) {
			sumMoney = orderDetail.getMoneyRealpay().doubleValue();
		}
		
//		根据付款，分配应收
		if(orderDetail.getPaymentId() != null) {
			if(model == 0) paymentId = orderDetail.getPaymentId();
		}
		
		if(orderDetail.getOrderId() != null) {
			if(model == 0 ) orderId = orderDetail.getOrderId();
		}
//		正常订单
		if(orderDetail.getId() != null) {
			if(model == 1 ) detailId = orderDetail.getId();
		}	
//		部门订单		
//		if(orderDetail.getOrder().getContractId() != null) {
//			if( model == 2) contractId = orderDetail.getOrder().getContractId();
//		}
		
		
//		System.out.println("model>>>>>>>>>2222222222  11111111111111111111111111111>>>>>>>>>>"+ model);
//		System.out.println("sumMoney>>>>>>2222222222 111111111111111111>>>>>>>>>>>>"+ sumMoney);
//		System.out.println("resourceType>>>>>>2222222222 111111111111111111>>>>>>>>>>>>"+ resourceType);
		
//		if(log.isDebugEnabled()){
//		    System.out.println("model >>>1111111111111>>>>>"+model);
//			System.out.println("orderDetail.getId() >>>>>111111111111111111>>>>>>"+orderDetail.getId());
//			System.out.println("sumMoney >0 >>>>1111111111111111111>>>>>>"+orderDetail.getMoneyRealpay());
//			System.out.println("paymentId >>>1111111111111>>>>>"+paymentId);
//			System.out.println("orderId >>>>111111111111>>>>"+orderId);
//			System.out.println("contractId >>>1111111111111>>>>>"+contractId);
//			System.out.println("resourceType >>>>111111111111>>>>>>>>>>"+resourceType);		
//		}

//		if(model == 2){
		if(model != 1 && isWithResourceSort){	
			boolean isMod =false;
			Map mp = new HashMap();
			if(paymentId.longValue()>0){
//					mp.put("contractId",contractId);
					mp.put("paymentId",paymentId);
					
			}else{
				mp.put("orderId",orderId);   
			}
			

    		
    		
			
			
			List paymentList = contractPaymentDao.getContractPayment(mp);
			int size = paymentList.size();
			Map resTypeMoney = new HashMap();
		
			double paySum = 0;
			double resTypeSum = 0;
			double resTypeZeroSum = 0;
			for(Iterator it = paymentList.iterator();it.hasNext();){
				ContractPayment payment = (ContractPayment)it.next();
				long id = Long.parseLong(StringUtil.getNullValue(payment.getResourceTypeId(),"0"));
				Double money = Double.valueOf(StringUtil.getNullValue(payment.getMoneyPay(),"0"));
				paySum = paySum +money.doubleValue();
				String key = String.valueOf(id);

				if(id >0) {
				
					resTypeSum = resTypeSum +money.doubleValue();
					if(money.doubleValue() > 0) {
						if(resTypeMoney.containsKey(key)){
							double ttt = ((Double)resTypeMoney.get(key)).doubleValue();
							resTypeMoney.put(key,new Double(money.doubleValue()+ttt));
						}else{
							resTypeMoney.put(key,money);
						}
					}
				}else{
					resTypeZeroSum = resTypeZeroSum +money.doubleValue();
				}
				
				
			}
			
//			List lsResKeysDetal = dao.getResTypeByOrderDetail(mp);
//			
//			boolean isMach = resTypeMoney.keySet().containsAll(lsResKeysDetal);
			
			
			
			if(size >0 && resTypeMoney.size() > 0 ) isMod = true;
//			System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>>isMach>>>>>"+ isMach);
//			System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>>size>>>>>"+ size);
//			System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>>paySum>>>>>"+ paySum);
//			System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>resTypeSum>>>>>>"+ resTypeSum);
//			System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>resTypeZeroSum>>>>>>"+ resTypeZeroSum);
			
			
			if (isMod &&  paySum > 0 && paySum == resTypeSum  ){
				Iterator itt = resTypeMoney.keySet().iterator();
				while(itt.hasNext()){
					String key = (String)itt.next();
					double value = ((Double)resTypeMoney.get(key)).doubleValue();
//					System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>>key>>>>>"+ key +"||||||||||||||||value>>>>>>>"+value);
					double excPrice = orderDetail.getExecPrice().doubleValue();
					allotMoneyRealpay(0,value,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(key),excPrice);
				}
			}else{
//				如果存在未指定分类,自动分类
				if(paySum >resTypeSum ||(paySum == 0 && resTypeSum ==0)) paySum = sumMoney;
//				System.out.println("paymentList>>>>>>>>>222222222222222222 9999999999999999999999999999>>>>resTypeSum>>>>>"+ resTypeSum);
//				System.out.println("paymentList>>>>>>>>>222222222222222222 9999999999999999999999999999>>>>paySum>>>>>"+ paySum);
				double excPrice = orderDetail.getExecPrice().doubleValue();
				allotMoneyRealpay(0,paySum,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(0),excPrice);
			}
			
			//如果存在未指定分类
//			if (isMod && resTypeZeroSum >0){
//				System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>>如果存在未指定分类>>>>>");
//				allotMoneyRealpay(0,resTypeZeroSum,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(0));
//			}
			
//			if(!isMod && orderDetail.getId() != null ){
//				System.out.println("paymentList>>>>>>>>>111111111111111111111 9999999999999999999999999999>>>>GGGGGGGGGGGGG>>>>>");
//				allotMoneyRealpay(model,sumMoney,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(0));
//			}
			
			
			
			
			
			
			
//			if(orderDetail.getId() != null && sumMoney >0 && isMod){
//
//
//				if(size >1){
//					double tempsumMoney = 0;
//					Map temSumMoneyMap = new HashMap();
//					String key = "";
//					for(Iterator it = paymentList.iterator();it.hasNext();){
//						ContractPayment payment = (ContractPayment)it.next();
//						String resType = StringUtil.null2String(payment.getResourceTypeId());
////						resType = resType == null || resType ==""?"0":resType;
//						double sumMoneyFromDB = payment.getMoneyPay().doubleValue();
////						resType = (resType == null)?resType="":resType;
//						sumMoney = sumMoneyFromDB;
//						
////						System.out.println("size > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>> resType resourceType >>"+resType+"   ||  "+resourceType);
//						
////						if(resType.equals(resourceType.toString())){
////							temSumMoneyMap.put(resType,""+sumMoneyFromDB);
////							key = resType;			
////						}else{
//							mp.put("resourceType",resType);  
//							int count = dao.getOrderDetailByResourceType(mp).intValue();
//							
////							System.out.println("size yyyyyyyyyyyyyyyyyyyyyyyyy  > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>> count "+count);
////							System.out.println("size yyyyyyyyyyyyyyyyyyyyyyyyy  > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>> count "+count);
//							if(count > 0){
//								temSumMoneyMap.put(resType,""+sumMoneyFromDB);
//								key = resType;		
//							}else{
//								//无法找到排期
//								tempsumMoney =tempsumMoney+sumMoneyFromDB;
//								
//							}
////						}
//						
//
////						allotMoneyRealpay(model,sumMoney,paymentId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(resType));
//					}
//					
////					System.out.println("size > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>> tempsumMoney "+tempsumMoney+"      key>>>> "+key);
//					
//					if(tempsumMoney > 0 && !key.equals("")){
//						double s = new Double((String)temSumMoneyMap.get(key)).doubleValue();
//						s = s + tempsumMoney;
////						System.out.println("size > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>> s >>"+key+"     "+s);
//						temSumMoneyMap.put(key,""+s);
//					}
//					
//					
//					for(Iterator it = temSumMoneyMap.keySet().iterator();it.hasNext();){
//						String resourceType_key1 =(String)it.next();
//						double sumMoney_v = new Double((String)temSumMoneyMap.get(resourceType_key1)).doubleValue();
//						
////						System.out.println("size > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+resourceType_key1 +"   "+sumMoney_v);
//						
//						allotMoneyRealpay(model,sumMoney_v,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(resourceType_key1));
//					}
//					
//					
//
//				}else if(size ==1){
//					
////					System.out.println("orderDetail.getId()>>>>>>>>>>>>>>>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv>>>"+orderDetail.getId());
//					
//					ContractPayment payment = (ContractPayment)paymentList.get(0);
////					String resType = payment.getMemo();
//					String resType = StringUtil.null2String(payment.getResourceTypeId());
//					if(!resType.equals(StringUtil.null2String(resourceType))){
////						System.out.println("contractPaymentDao.saveObject(payment)>>>>>");
////						payment.setMemo(resourceType.toString());
//						payment.setResourceTypeId(new Long(StringUtil.null2String(resourceType)));
////						System.out.println("orderDetail.getId()>>>>>>>>>>>>>>>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv>>>"+orderDetail.getId());
////						if(orderDetail.getId() == null)  	payment.setId(null);
//						contractPaymentDao.saveContractPayment(payment);
//					}
//					
////					else{
////						if(orderDetail.getMoneyRealpay().doubleValue() != payment.getMoneyPay().doubleValue() && !(paymentId.longValue()>0)) {
////							payment.setMoneyPay(orderDetail.getMoneyRealpay());
////							contractPaymentDao.saveContractPayment(payment);
////						}
////					}
//					
////					System.out.println("size == 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+resourceType +"   "+sumMoney);
//					
//					allotMoneyRealpay(model,sumMoney,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),resourceType);
//				}else{
//					if( sumMoney >= 0){
//						
////						System.out.println("size == 0 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+resourceType +"   "+sumMoney);
//						
//						allotMoneyRealpay(model,sumMoney,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),resourceType);
//					}
//				}
//				
////				System.out.println("sumMoneyFromDB @@@@@@@@@@@ sumMoney>>>>>"+sumMoney);
//				
//			}else{
//				allotMoneyRealpay(model,sumMoney,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(0));
//			}
			
//			allotMoneyRealpay(model,sumMoney,paymentId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),resourceType);
			
			
		}else{
			
//			System.out.println("sumMoneyFromDB @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ sumMoney>>>>>"+sumMoney);
			
			if(sumMoney >= 0){
				
				double excPrice = 0;
				
				if(orderCalculateModelParam == 0){
					 excPrice = orderDetail.getExecPrice().doubleValue();
				}else{
					 int sumTimes = Integer.parseInt(StringUtil.getNullValue(orderDetail.getSumTimes(),"0"));
					 sumTimes = sumTimes == 0?1:sumTimes;
					 excPrice =sumMoney/sumTimes;
				}
//				System.out.println("orderDetail.getSumTimes() yyyyyyyyyyyyyyyyyyyyyyyyy  > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+orderDetail.getSumTimes());
				
				allotMoneyRealpay(model,sumMoney,paymentId,contractId,orderId,detailId,orderDetailIds,isCompages, orderDetail.getParentId(),new Integer(0),excPrice);
			}
			
		}
		
		
		
	}
	
	/* ******************************************************
	 * 				处理日应收
	 * 	       
	 *  1、根据合同付款进行分配  先分配到订单、再根据订单分配到明细 、 根据明细分配到天
	 *  2、根据订单明细的总应收 分配应收到每一天  
	 *******************************************************/
	public void allotMoneyRealpay_bak(int model,double sumMoneys,Long paymentId,Long contractId,Long orderId,Long detailId,List orderDetailIds,boolean isCompages,Long parentId,Integer resourceType){
		double sumMoney = sumMoneys;
//		double additionalMoney = sumMoneys-sumMoney;

		OrderDayUtil orderDayUtil = new OrderDayUtil();
		Map mpAll = new HashMap();
//		List adList = new ArrayList();
//		long start1 = System.currentTimeMillis(); 
		//正常、协议 系统参数都为 1
		if(!isCompages && model == 1){
	        Map mp = new HashMap();
		    mp.put("paymentId",paymentId);
		    mp.put("orderId",orderId);              
		    mp.put("detailId",detailId);          
		    mp.put("needCal",new Integer(1)); 
//		    mp.put("parentId",new Long(0));
		    List adList = orderDayInfoDao.getOrderDayInfos(mp);	
		    
		    if(adList.size() >0){
				Map dayRealPlay = orderDayUtil.getOrdersDaysMony(adList,sumMoney,model,0);
//		    	orderDayInfoDao.saveOrderDayInfosRealPlay(dayRealPlay);  
				mpAll.putAll(dayRealPlay);
		    } 
		}      
		
		 
//		 System.out.println("isCompages>>>>>>>>>>>>>>>>>>>>"+isCompages);  
//		 System.out.println("model>>>>>>>>>>>>>>>>>>>>"+model);  
		 
	    //套播 查找日信息表中 需要分配的
	    if(isCompages && model ==1){
	    	
	    	orderDetailIds.add(detailId);

	    	Map mp = new HashMap();
	    	mp.put("needCal",new Integer(1));
	    	mp.put("OrderDetailIdList",orderDetailIds);
	    	List adList = orderDayInfoDao.getOrderDayInfosByDetailIdList(mp);
	    	
	    	List ls1 =  OrderDayUtil.getOrderDaysByDetailId(adList,detailId,true);
	    	
	        if(ls1.size() >0){
	    		Map dayRealPlay = orderDayUtil.getOrdersDaysMony(ls1,sumMoney,model,0);
	    		mpAll.putAll(dayRealPlay);
	        }
	        
	        List ls2 =  OrderDayUtil.getOrderDaysByDetailId(adList,detailId,false);
	        if(ls2.size() >0){
	    		Map dayRealPlay = orderDayUtil.getOrdersDaysMony(ls2,sumMoney,model,0);
	    		mpAll.putAll(dayRealPlay);
	        }	        
	        
	    }
	    
//	    if(model == 1) orderDayInfoDao.saveOrderDayInfosRealPlay(mpAll); 
        
        //协约 系统参数都为 0
		if(model == 0 || model == 2){
			
			
	        Map mp = new HashMap();
	        if(model == 0){
	        	 if(paymentId.longValue() >0 ) orderId = new Long(0);
	        }else{
		        if(model == 2 && paymentId.longValue() >0 && contractId.longValue()> 0) orderId = new Long(0);
		        if(contractId.longValue() >0) paymentId = new Long(0);
		        if(model == 2 && contractId.longValue() == 0 ) paymentId = new Long(0);
	        }
	        
	        
//	        if(SysParamUtil.isXMTVParam(null)){
//		        if(model == 2 && paymentId.longValue() >0 && contractId.longValue()> 0) orderId = new Long(0);
//		        if(contractId.longValue() >0) paymentId = new Long(0);
//		        if(model == 2 && contractId.longValue() == 0 ) paymentId = new Long(0);
//		        
//	        }else{
//	        	 if(paymentId.longValue() >0 ) orderId = new Long(0);
//	        }

	       
		    mp.put("paymentId",paymentId); 
		    mp.put("orderId",orderId);
		    mp.put("detailId",detailId);
		    mp.put("needCal",new Integer(1));  
		    mp.put("contractId",new Long(0));
		    if(model == 2){
		    	mp.put("resourceType",resourceType);  
		    	if(contractId.longValue() >0){
		    		mp.put("contractId",contractId);
		    	}
		    }
		    
//		    System.out.println("model  KKKKKKKKKKKKKKKKKK" + model);
//		    System.out.println("paymentId  KKKKKKKKKKKKKKKKKK" + paymentId);
//		    System.out.println("orderId  KKKKKKKKKKKKKKKKKK" + orderId);
//		    System.out.println("detailId  KKKKKKKKKKKKKKKKKK" + detailId);
//		    System.out.println("needCal  KKKKKKKKKKKKKKKKKK" + new Integer(1));
//		    System.out.println("resourceType  KKKKKKKKKKKKKKKKKK" + resourceType);
		    
//		    mp.put("parentId",new Long(0));
//		    long start4 = System.currentTimeMillis();  
//		    System.out.println("start DDDD KKKKKKKKKKKKKKKKKK");
		    List adList = orderDayInfoDao.getOrderDayInfos(mp);	
		    
		    //如果新添加一条催款，但没广告排期的情况下，需要把这笔钱分配到另外一个部门
		 
		    
//		    long start5 = System.currentTimeMillis();  
//		    System.out.println("start DDDD>>>>>>>>>>>>>>>>>>>>"+(start5-start4));  

//		    System.out.println("adList  KKKKKKKKKKKKKKKKKK" + adList.size());
//		    System.out.println("sumMoney  KKKKKKKKKKKKKKKKKK" + sumMoney);
		    
//			log.info("KKKKKKKKKKKKKKKKKK" +detailId);
//		    System.out.println("adList  KKKKKKKKKKKKKKKKKK" + adList.size());
			
			
			//获得 parentId 为 0 的日分配信息
//			List ls1 = OrderDayUtil.getOrderDaysPraentIdZero(adList,true);
//			List ls2 = OrderDayUtil.getOrderDaysPraentIdZero(adList,false);
		    
			List ls1 =  new ArrayList();  //
			List ls2 =  new ArrayList();
			OrderDayUtil.getOrderDaysPraentIdZero(adList,ls1,ls2,true);
//			 System.out.println("ls1  KKKKKKKKKKKKKKKKKK" + ls1.size());
//			 System.out.println("ls2  KKKKKKKKKKKKKKKKKK" + ls2.size());

		    if(ls1.size() >0){
				Map dayRealPlay = orderDayUtil.getOrdersDaysMony(ls1,sumMoney,model,0);
				mpAll.putAll(dayRealPlay);
				
				List parentList = OrderDayUtil.getOrderDaysCompagesParentSumMony(ls1,dayRealPlay);
//				System.out.println(" parentList KKKKKKKKKKKKKKKKKK" + parentList.size());
				
				for (Iterator it = parentList.iterator(); it.hasNext();) {
					OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
					
					Integer dt = orderDayInfo.getPublishDate();
					Long pId = orderDayInfo.getOrderDetailId();
					Double value = orderDayInfo.getDayRelIncome();
					List ls3 = OrderDayUtil.getOrderDaysCompagesByParentId(ls2,dt,pId);
//					System.out.println(" ls3 KKKKKKKKKKKKKKKK 111111111111111111111111111111111111111111111111111111111111111        KK" + ls3.size());
					
					Map dayRealPlay2 = orderDayUtil.getOrdersDaysMony(ls3,value.doubleValue(),1,0);
					
					if(dayRealPlay2.size() > 0) mpAll.putAll(dayRealPlay2);
				}

		    }
		    


//		    orderDayInfoDao.saveOrderDayInfosRealPlay(mpAll); 
		    
		}
//	    log.info(" mpAll KKKKKKKKKKKKKKKKKK" + mpAll.size());
//		int i = 0;
//		for (Iterator it = mpAll.keySet().iterator(); it.hasNext();) {
//			 Long key = (Long)it.next();
//			 Long money = (Long)mpAll.get(key);
//			 mpAll.put(key,""+money.longValue());
////			 if(i++==0&&additionalMoney>0){  
////				 mpAll.put(key,""+(money.longValue()+additionalMoney));   
////				 System.out.println("》》》》》》》》》》》 additionalMoney"+additionalMoney);
////			 }     
//		}
		
//		 System.out.println("》》》》》》》》》》》 additionalMoney"+mpAll.size());
		 
		if(mpAll.size() > 0)orderDayInfoDao.saveOrderDayInfosRealPlay2(mpAll);
		
//		 System.out.println("》》》》》》》》》》》 additionalMoney"+mpAll.size());
		
//	    long start5 = System.currentTimeMillis(); 
//		 System.out.println("start5>>>>>>>>>>>>>>>>>>>>"+(start5-start1));  

	}
	/* ******************************************************
	 * 				处理日应收
	 * 	       
	 *  1、根据合同付款进行分配  先分配到订单、再根据订单分配到明细 、 根据明细分配到天
	 *  2、根据订单明细的总应收 分配应收到每一天  
	 *******************************************************/
	public void allotMoneyRealpay(int model,double sumMoneys,Long paymentId,Long contractId,Long orderId,Long detailId,List orderDetailIds,boolean isCompages,Long parentId,Integer resourceType,double execPrice){
		double sumMoney = sumMoneys;

//		 System.out.println("allotMoneyRealpay @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ adList>>>>>"+model);
			
		 

		OrderDayUtil orderDayUtil = new OrderDayUtil();
		Map mpAll = new HashMap();
		List adList = new ArrayList();
	    Map mp = new HashMap();
		//正常、协议 系统参数都为 1
		if(model == 1){
		    mp.put("paymentId",paymentId);
		    mp.put("orderId",orderId);              
		    mp.put("detailId",detailId);   
		    
		    contractId = new Long(0);
		    paymentId = new Long(0);
		    orderId = new Long(0);
		    resourceType = new Integer(0);

//		    mp.put("needCal",new Integer(1)); 
		//协约 系统参数都为 0 部门订单 2
		}else{
	        if(model == 0){
//	        	 if(paymentId.longValue() >0 ){
//	        		 orderId = new Long(0);
//	        	 }else{
//	        		 paymentId = new Long(0);
//	        	 }
	        	 
//	        	 if(contractId.longValue() >0 ){
//	        		 orderId = new Long(0);
//	        	 }else{
//	        		 paymentId = new Long(0);
//	        	 }
	        	
//				if(paymentId.longValue()>0){
//					paymentId = new Long(0);
//					orderId = new Long(0);
//				}        	
	        	
	        	 if(paymentId.longValue() >0 ){ 
	        		 orderId = new Long(0);
	        	 }else{
	        		 paymentId = new Long(0);
	        	 }
	        	 
	        	 

	        	 detailId = new Long(0);
	        }else{
		        if(model == 2 && paymentId.longValue() >0 && contractId.longValue()> 0) orderId = new Long(0);
		        if(contractId.longValue() >0) paymentId = new Long(0);
		        if(model == 2 && contractId.longValue() == 0 ) paymentId = new Long(0);
	        }
	        
		    mp.put("paymentId",paymentId); 
		    mp.put("orderId",orderId);
		    mp.put("detailId",detailId);
//		    mp.put("needCal",new Integer(1));  

//		    mp.put("contractId",new Long(0));
		    
//		    if(model == 2){
//		    	mp.put("resourceType",resourceType);  
//		    	if(contractId.longValue() >0){
//		    		mp.put("contractId",contractId);
//		    	}
//		    }	        
	        
	        
		}
//		 	StringUtilsv.printMap(mp);
		 
			OrderDayInfo orderDayInfo = new OrderDayInfo();

			if(paymentId.longValue() >0){
				orderDayInfo.setPaymentId(paymentId);			
			}
			if(orderId.longValue() >0){
				orderDayInfo.setOrderId(orderId);			
			}
			if(detailId.longValue() >0){
				orderDayInfo.setOrderDetailId(detailId);		
			}
			
			if(resourceType.longValue() >0){
				orderDayInfo.setResourceType(resourceType);
			}
			
			if(contractId == null) contractId = new Long(0);
			if(contractId.longValue() >0){
				orderDayInfo.setContractId(contractId);
			}		 
		 
		 
		 
		 
//			System.out.println("contractId  KKKKKKKKKKKKKKKKKK>>" + contractId);
//			System.out.println("sumMoney  KKKKKKKKKKKKKKKKKK>>" + sumMoney);
//		    System.out.println("model  KKKKKKKKKKKKKKKKKK>>" + model);
//		    System.out.println("paymentId  KKKKKKKKKKKKKKKKKK>>" + paymentId);
//		    System.out.println("orderId  KKKKKKKKKKKKKKKKKK>>" + orderId);
//		    System.out.println("detailId  KKKKKKKKKKKKKKKKKK>>" + detailId);
////		    System.out.println("needCal  KKKKKKKKKKKKKKKKKK>>" + new Integer(1));
//		    System.out.println("resourceType  KKKKKKKKKKKKKKKKKK>>" + resourceType);
		 
//	     adList = orderDayInfoDao.getOrderDayInfos(mp);	
	     adList = orderDayInfoDao.getOrderDayInfos(orderDayInfo);	
	     
//	     System.out.println("sumMoneyFromDB @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ adList>>>>>"+adList.size());
			
	     
		 List ls1 =  new ArrayList();  //
		 Map mpZero =  new HashMap();	     
		 if(adList.size() >0){
			 OrderDayUtil.getOrderDaysPraentIdZero2(adList,ls1,mpZero,true,resourceType);
		 }
		
		 
	     if(ls1.size()>0){    
//	    	 double exePrice = 
				Map dayRealPlay = orderDayUtil.getOrdersDaysMony(ls1,sumMoney,model,execPrice);
				mpAll.putAll(dayRealPlay);
//				System.out.println("sumMoneyFromDB @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ls1>>>>>"+mpAll.size());
					
	     }
	     if(mpZero.size()>0){    
				mpAll.putAll(mpZero);
//				 System.out.println("sumMoneyFromDB @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ mpZero>>>>>"+mpZero.size());
					 
	     }     
	     
	     
	     
	     
	
	 	if(mpAll.size() > 0){
	 		orderDayInfoDao.saveOrderDayInfosRealPlay2(mpAll);		
	 	}
		
//	 	 System.out.println("sumMoneyFromDB @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ mpAll>>>>>"+mpAll.size());
			
	 		
		
	
//		 System.out.println("》》》》》》》》》》》 additionalMoney"+mpAll.size());
		
//	    long start5 = System.currentTimeMillis(); 
//		 System.out.println("start5>>>>>>>>>>>>>>>>>>>>"+(start5-start1));  

	}	
	public List getMonthInfosForFree(OrderDetail orderDetail) {
		List monthList = new ArrayList();
		List resList = new ArrayList();
		List dayList = new ArrayList();

		Integer startDate = orderDetail.getPublishStartDate();
		Integer endDate = orderDetail.getPublishEndDate();
		String specific = "";
		long orderDetailId = 0;
		Long resourceId = new Long(0);
		Integer orderYear = orderDetail.getVersion();
		
		
		Object compagesObj = orderDetail.getCompagesId();
		Long compagesId = compagesObj != null ?(Long)compagesObj: new Long(0);
		boolean isCompages =  compagesId.longValue() > 0? true:false;
		
		if(orderDetail.getSpecific().getPosition() != null) specific = orderDetail.getSpecific().getPosition();
		if(orderDetail.getId() != null) orderDetailId = orderDetail.getId().intValue();
		if(orderDetail.getResourceInfoId() != null) resourceId = orderDetail.getResourceInfoId();

		int firstMonth = (new Integer(startDate.toString().substring(4,6))).intValue();
		int lastMonth = (new Integer(endDate.toString().substring(4,6))).intValue();
		int year = (new Integer(startDate.toString().substring(0,4))).intValue();
		int nextMonth = firstMonth;
		boolean displayOverDate = false;
		
		DayInfo resDayInfo = new DayInfo();
		OrderDayInfo orderDayInfo = new OrderDayInfo();
		
		resDayInfo.setResourceId(resourceId);
		resDayInfo.setStartDate(startDate);
		resDayInfo.setEndDate(endDate);
		resDayInfo.setVersion(orderYear);
		
		orderDayInfo.setOrderDetailId(orderDetail.getId());
		orderDayInfo.setVersion(orderYear);                              
		
//		log.info(">>>>>>>>>>>>>>>>orderYear>>>>>>>>>>" + orderYear);
		
//		long start = System.currentTimeMillis();
		
		if(resourceId.longValue() > 0) {
			List res = dayInfoDao.getDayInfos(resDayInfo);
			
			List ls = dayInfoDao.getDayInfosForFree(resDayInfo);
			Map mp=new HashMap();
			for(Iterator its=ls.iterator();its.hasNext();){ 
				DayInfo usedInfo = (DayInfo)its.next();
				mp.put(""+usedInfo.getResourceId()+usedInfo.getPublishDate(),usedInfo.getUsed());
			}
			for(Iterator it=res.iterator();it.hasNext();){
				DayInfo day = (DayInfo)it.next();
				day.setTotal(""+day.getPropertiyTime());
				day.setUsed((String)mp.get(""+day.getResourceId()+day.getPublishDate()));
//				System.out.println("middle===="+day.getTotal()+">>>>>>>"+day.getUsed());    
				resList.add(day);
			}           
		}
		if(orderDetailId > 0){
			dayList= orderDayInfoDao.getOrderDayInfos(orderDayInfo);
			//修改时需要显示时间资源状态
		    displayOverDate = true;
		}
		
//		if(DateUtil.getToday().YEAR)
		
		

//		long end = System.currentTimeMillis();System.out.println("middle===="+(end-start));  
		
		Map resMap = ConvertUtil.convertListToMap(resList,"publishDate");
		Map dayMap = ConvertUtil.convertListToMap(dayList,"publishDate");
		
		 for (;nextMonth <= lastMonth;nextMonth++){
			MonthInfo monthInfo = new MonthInfo();
			DayInfoArray days[] = new DayInfoArray[31];

			setMonthInfoByRes(resMap,days,year,nextMonth,specific,isCompages,displayOverDate,new HashMap());
			
			if(dayMap.size() > 0){
				setMonthInfoByDays(dayMap,monthInfo,days,year,nextMonth);					
			}

			monthInfo.setMonthStr(year +"年" + nextMonth + "月");  
			monthInfo.setMonth(new Integer(nextMonth));
			monthInfo.setDays(days);
			
			monthList.add(monthInfo);            
		}	
		 
//		 long end1 = System.currentTimeMillis();System.out.println("last===="+(end1-start));  

		return monthList;
}
// 	private static  boolean getFztvSpecialParam(){
//	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//	    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
//	    return (sysParam.getFztvSpecialParam().equals("0"))?false:true;
//	}
	
	
	//
	public List getMonthInfos(OrderDetail orderDetail) {
			String tvName = SysParamUtil.getTvNameParam();
			List monthList = new ArrayList();
			List resList = new ArrayList();
			List resList2 = new ArrayList();
			List dayList = new ArrayList();
	
			Integer startDate = orderDetail.getPublishStartDate();
			Integer endDate = orderDetail.getPublishEndDate();
			String specific = "";
			long orderDetailId = 0;
			Long resourceId = new Long(0);
			Integer orderYear = orderDetail.getVersion();
			
			
			int orderDetailStates = orderDetail.getOrderDetailStates();
			
			
			Object compagesObj = orderDetail.getCompagesId();
			Long compagesId = compagesObj != null ?(Long)compagesObj: new Long(0);
			boolean isCompages =  compagesId.longValue() > 0? true:false;
//			log.info(">>>>>>>>>>>>>>>>compagesId>>>>>>>>>>" + compagesId.longValue());
			
			if(orderDetail.getSpecific().getPosition() != null) specific = orderDetail.getSpecific().getPosition();
			if(orderDetail.getId() != null) orderDetailId = orderDetail.getId().longValue();
			if(orderDetail.getResourceInfoId() != null) resourceId = orderDetail.getResourceInfoId();

            int firstMonth = (new Integer(startDate.toString().substring(4,6))).intValue();
            int lastMonth = (new Integer(endDate.toString().substring(4,6))).intValue();
            int fyearMonth = Integer.parseInt(startDate.toString().substring(0,6));
            int eyearMonth = Integer.parseInt(endDate.toString().substring(0,6));
            
            int year = (new Integer(startDate.toString().substring(0,4))).intValue();
		    int nextMonth = firstMonth;

		    boolean displayOverDate = false;
			DayInfo resDayInfo = new DayInfo();
			OrderDayInfo orderDayInfo = new OrderDayInfo();
			
			resDayInfo.setResourceId(resourceId);
			resDayInfo.setStartDate(startDate);
			resDayInfo.setEndDate(endDate);
//			resDayInfo.setVersion(orderYear);
			
			orderDayInfo.setOrderDetailId(orderDetail.getId());
//			orderDayInfo.setVersion(orderYear);                              
			
//			log.info(">>>>>>>>>>>>>>>>orderYear>>>>>>>>>>" + orderYear);
//			System.out.println("getToday====================>>>>>>"+ DateUtil.getYear());    
			
			
			if(resourceId.longValue() > 0) {
//				long start = System.currentTimeMillis();
//				log.info("used1 time resourceId>>" + resourceId +"秒");
//				log.info("used1 time startDate>>" + startDate +"秒");
//				log.info("used1 time endDate>>" + endDate +"秒");
//				log.info("used1 time orderYear>>" + orderYear +"秒");
				
				resList = dayInfoDao.getDayInfos(resDayInfo);	
				//由于时间日信息不准，所以重新订单日信息查询
				resList2 = dayInfoDao.getDayInfosFromOrder(resDayInfo);	
				
				OrderDetailUtil.resetResList(resList,resList2);
				
				
				
//				long end = System.currentTimeMillis();System.out.println("dayInfoDao.getDayInfos >>>>>>>>>>>>>>>>>>>>>>>===="+(end-start));  
			}else{
				DayInfoUtil.getDayInfosFree(resDayInfo,resList);
			}
			
	
			
			
			if(orderDetailId > 0){
				long start = System.currentTimeMillis();
				dayList= orderDayInfoDao.getOrderDayInfos(orderDayInfo);
//				long end = System.currentTimeMillis();System.out.println("orderDayInfoDao.getOrderDayInfos >>>>>>>>>>>>>>>>>>>>>>>===="+(end-start));  
//				log.info("used1 time orderDetailId>>" + dayList.size() +"秒");
				
				//修改时需要显示时间资源状态
			   
			}else{
				 displayOverDate = true;
			}
			
//			log.info("used1 time orderDetailId>>" + displayOverDate +"秒");
		
			Map groupLeftTimeMp = new HashMap();
			
//			long start = System.currentTimeMillis();
			if((SysParamUtil.isFZTVParam(tvName) || SysParamUtil.isXMTVParam(tvName)) && resourceId.longValue() > 0){
				
				Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCENAME_MAP);
				Resource resource = (Resource)mp.get(""+resourceId);
				
//				 System.currentTimeMillis();System.out.println(" resource.getIsClosed() >>>>>>>>>>>>>>>>>>>>>>>===="+ resource);  
				 
				 if(resource.getIsClosed() == null) resource.setIsClosed(new Boolean(false));
				if(resource.getCarrierId()!=null && resource.getIsClosed().booleanValue()){          
					resDayInfo.setCarrierId(""+resource.getCarrierId());
					List groupLeftTime= dayInfoDao.getGroupLeftTime(resDayInfo); 
					for(Iterator it=groupLeftTime.iterator();it.hasNext();){
						DayInfo dayInfo = (DayInfo)it.next();
						groupLeftTimeMp.put(dayInfo.getPublishDate()+"",dayInfo.getUsed());
//						System.out.println(dayInfo.getPublishDate()+"middle===="+dayInfo.getUsed());        
					}   
				}
			}

//			long end = System.currentTimeMillis();System.out.println("getMonthInfos >>>>>>>>>>>>>>>>>>>>>>>===="+(end-start));  
			
			
			
			
			
			

			
//			long start1 = System.currentTimeMillis();
			
			Map resMap = ConvertUtil.convertListToMap(resList,"publishDate");
			Map dayMap = ConvertUtil.convertListToMap(dayList,"publishDate");
//			
			 for (;nextMonth <= lastMonth;nextMonth++){
				MonthInfo monthInfo = new MonthInfo();
				DayInfoArray days[] = new DayInfoArray[31];

				setMonthInfoByRes(resMap,days,year,nextMonth,specific,isCompages,displayOverDate,groupLeftTimeMp);
				
				if(dayMap.size() > 0){
					setMonthInfoByDays(dayMap,monthInfo,days,year,nextMonth);					
				}

				monthInfo.setMonthStr(year +"年" + nextMonth + "月");
				monthInfo.setMonth(new Integer(nextMonth));
				monthInfo.setDays(days);
				monthInfo.setYear(new Integer(year));
				
				monthList.add(monthInfo);            
			}	
			 
//			 int firstMonth_temp = firstMonth;
//	         int lastMonth_temp = lastMonth;
//	         int year_temp = year;
//	         
//	         System.out.println("eyearMonth====================>>>>>>"+ eyearMonth);    
//	         
//			 while(fyearMonth <= eyearMonth){
//
//					 String firstMonth_temp2 = firstMonth_temp<10?"0"+firstMonth_temp:firstMonth_temp+"";
//					 fyearMonth = Integer.parseInt(year_temp+"" +firstMonth_temp2);
//					 
//					 
//					 System.out.println("fyearMonth  222 ===================="+ fyearMonth  +">>>>>>"+ eyearMonth+" "+(fyearMonth <= eyearMonth));    
//					 
//						MonthInfo monthInfo = new MonthInfo();
//						DayInfoArray days[] = new DayInfoArray[31];
//						setMonthInfoByRes(resMap,days,year_temp,firstMonth_temp,specific,isCompages,displayOverDate,groupLeftTimeMp);
//						
//						if(dayMap.size() > 0){
//							setMonthInfoByDays(dayMap,monthInfo,days,year_temp,firstMonth_temp);					
//						}
//
//						monthInfo.setMonthStr(year +"年" + firstMonth_temp + "月");
//						monthInfo.setMonth(new Integer(firstMonth_temp));
//						monthInfo.setDays(days);
//						monthInfo.setYear(new Integer(year_temp));
//						
//						monthList.add(monthInfo);    
//						
//						
//						
//						 if(firstMonth_temp >12) {
//							 firstMonth_temp = 0;
//							 year_temp += 1;
//						 }
//						 
//						 firstMonth_temp +=1;
//				
//
//			 }
			 
			 
			 
//			 long end1 = System.currentTimeMillis();System.out.println("last===="+(end1-start));  
//			 long used1 = (end1 - start1)/1000;
//			 log.info("used1 time>>" + used1 +"秒");	
			return monthList;
	}
	
	
	public void setMonthInfoByRes(Map resMap,DayInfoArray days[],int year,int month,String specific,boolean isCompages,boolean displayOverDate,Map groupLeftTime){
		for (int i = 0; i< days.length;i++){
			String d = DateUtil.setNewDay(year,month,i);
			Object obj = resMap.get(d);

			
			DayInfo resDayInfo = new DayInfo();
			
			if(obj != null){
				resDayInfo = (DayInfo)obj;
			}else{
				resDayInfo.reset(new Integer(d));
			}
			
//			if("20071125".equals(d)) System.out.println("resDayInfo>>>>>>>>>>>>>>" +resDayInfo.toString());
//			if("20071125".equals(d)) System.out.println("specific>>>>>>>>>>>>>>" +specific);
			days[i] = new DayInfoArray();
			days[i].setDayShort((String)groupLeftTime.get(d));
			

			days[i].setCurSpecificed(new Boolean(false));
			days[i].setIsAdSpecificed(new Boolean(false));
			
//			System.out.println(d+"dddd===="+days[i].getDayShort());        
			setDayInfoArrayByResDayInfo(days[i],resDayInfo,specific,isCompages,displayOverDate);
		}
	}        
	
	public void setMonthInfoByDays(Map dayMap,MonthInfo monthInfo,DayInfoArray days[],int year,int month){
		int adTimes = 0;
		double monthPay = 0;
		for (int i = 0; i< days.length;i++){
			String d = DateUtil.setNewDay(year,month,i);
			Object obj = dayMap.get(d);
			OrderDayInfo orderDayInfo = new OrderDayInfo();
			if(obj != null){
			    orderDayInfo = (OrderDayInfo)obj;	
//			    System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<"+orderDayInfo.toString());
			}else{
				orderDayInfo.reset(new Integer(d));
			}
			
			adTimes = adTimes +  orderDayInfo.getAdDayTimes().intValue();
			monthPay = monthPay +  orderDayInfo.getDayRelIncome().doubleValue();
			setDayInfoArrayByOrderDayInfo(days[i],orderDayInfo);
		}
		monthInfo.setMonthTims(new Integer(adTimes));
		monthInfo.setMonthPay(new Double(monthPay));
	}
	
	
	private void setDayInfoArrayByResDayInfo(DayInfoArray dayInfoArray,DayInfo resDayInfo,String specific,boolean isCompages,boolean displayOverDate){
		
		String  rsColor = ResDayUtil.getDayColor(resDayInfo,specific,dayInfoArray,isCompages,displayOverDate); //资源单元格背景色
		
		specific = StringUtils.isEmpty(specific)? "":specific;
		double rsTotalTimes = 0;
		double rsUsedTimes = 0;
		

		dayInfoArray.setDayDate(resDayInfo.getPublishDate());
		dayInfoArray.setResourceId(resDayInfo.getResourceId());
		dayInfoArray.setWeakStr(DateUtil.getWeekByStrDate2(resDayInfo.getPublishDate().toString(),"yyyyMMdd")) ;
		
		
		if(resDayInfo.getModifyTime() !=null){
	        dayInfoArray.setRsModifyTime(resDayInfo.getModifyTime());			
		}
		
		if(resDayInfo.getVersion() !=null){
	        dayInfoArray.setVersion(resDayInfo.getVersion());			
		}

		if(resDayInfo.getId() !=null){
	        dayInfoArray.setResourceDayId(resDayInfo.getId());			
		}
//		if(resDayInfo.getTotal() !=null){
			String t = StringUtils.isEmpty(resDayInfo.getTotal())? "0":resDayInfo.getTotal();
//			String t = resDayInfo.getTotal(); if(t == null || t == "" || StringUtils.isEmpty(t)) t = "0";
	        dayInfoArray.setRsTotalTime(new Double(t));
	        rsTotalTimes = Double.parseDouble(t);
//		}
//		if(resDayInfo.getUsed() !=null){
			String used = StringUtils.isEmpty(resDayInfo.getUsed())? "0":resDayInfo.getUsed();
	        dayInfoArray.setRsUsedTime(new Double(used));	
	        rsUsedTimes = Double.parseDouble(used);
//		}
		if(rsTotalTimes > 0){
			dayInfoArray.setRsReleave(new Double(rsTotalTimes - rsUsedTimes));
		}else{
			dayInfoArray.setRsReleave(new Double(rsTotalTimes + rsUsedTimes));
		}

		
//		if(resDayInfo.getSpecific() !=null){
			String resSpec = StringUtils.isEmpty(resDayInfo.getSpecific())? "":resDayInfo.getSpecific();
			dayInfoArray.setRsSpecific(resSpec);	
			
//			  System.out.println(" specific AAAAAAAAAAAAAAAAA            BBBBBBBBBBB            CCCCCCCCCCCC>>>>>>>>>>>>>><<<<<<<<<<<"+specific);
			

			if(specific !=""){
				dayInfoArray.setCurSpecificed(Boolean.valueOf(true));
			}else{
				dayInfoArray.setCurSpecificed(Boolean.valueOf(false));
			}
			
			if(resSpec !=""){
				if(specific !="") {
					if(resSpec.indexOf(specific)>-1){
						dayInfoArray.setIsResSpecificed(Boolean.valueOf(true));
					}else{
						dayInfoArray.setIsResSpecificed(Boolean.valueOf(false));
					}
				}else{
					dayInfoArray.setIsResSpecificed(Boolean.valueOf(false));
				}
				
			}else{
				dayInfoArray.setIsResSpecificed(Boolean.valueOf(false));
			}

			
//			if(resSpec !=""){
//				if(resSpec.indexOf(specific)>-1) {
//					dayInfoArray.setIsAdSpecificed(Boolean.valueOf(true));
//				}else{
//					dayInfoArray.setIsAdSpecificed(Boolean.valueOf(false));
//				}
//			}else{
//				dayInfoArray.setIsAdSpecificed(Boolean.valueOf(false));
//			}
			
//			dayInfoArray.setIsCompages(Boolean.valueOf(false));
	
//	        dayInfoArray.setRsSpecific(resDayInfo.getSpecific());			
//		}
		if(rsColor !=null) dayInfoArray.setRsColor(rsColor);	
	        			
        dayInfoArray.setRsAlert(""+resDayInfo.getResource().getDisplayNo());
        
        
        
        
//		来源资源信息
//      超时封签
        Boolean isClosed = resDayInfo.getResource().getIsClosed(); 
        isClosed = isClosed == null?new Boolean(false):isClosed;
        dayInfoArray.setIsLimit(isClosed);
//      指定加收
        Boolean isOverweight = resDayInfo.getResource().getIsOverweight();
        isOverweight = isOverweight == null?new Boolean(false):isOverweight;
        dayInfoArray.setResIsOverweight(isOverweight);
//      超时封签
        Boolean isValidate= resDayInfo.getResource().getIsValidate();
        isValidate = isValidate == null?new Boolean(false):isValidate;
        dayInfoArray.setResIsValidate(isValidate);
//      串编
        Boolean isSeralized= resDayInfo.getResource().getIsSeralized();
        isSeralized = isSeralized == null?new Boolean(false):isSeralized;
        dayInfoArray.setResIsSeralized(isSeralized);
//      手动价格
        Boolean isManual= resDayInfo.getResource().getIsManual();
        isManual = isManual == null?new Boolean(false):isManual;
        dayInfoArray.setResIsManual(isManual);
//      启用
        Boolean enable = resDayInfo.getResource().getEnable();
        enable = enable == null?new Boolean(false):enable;
        dayInfoArray.setResEnable(enable);
        
        
    	
	}
	
	private void setDayInfoArrayByOrderDayInfo(DayInfoArray dayInfoArray,OrderDayInfo orderDayInfo){
		int adTimes = 0;
		double adLength = 0;
//		Long compagesId = orderDayInfo.getCompagesId() != null ? orderDayInfo.getCompagesId(): new Long(0);
		
		if(orderDayInfo.getOrderDetailId() !=null){
	        dayInfoArray.setAdOrderDetailId(orderDayInfo.getOrderDetailId());			
		}

		if(orderDayInfo.getId() !=null){
	        dayInfoArray.setAdDayInfoId(orderDayInfo.getId());			
		}
		if(orderDayInfo.getAdlength() !=null){
	        dayInfoArray.setAdLength(new Double(orderDayInfo.getAdlength()));	
	        adLength = (new Double(orderDayInfo.getAdlength())).doubleValue();
		}
		if(orderDayInfo.getAdDayTimes() !=null){
	        dayInfoArray.setAdTimes(orderDayInfo.getAdDayTimes());	
	        adTimes = orderDayInfo.getAdDayTimes().intValue();
		}
		if(orderDayInfo.getAdDayTimes() !=null){
	        dayInfoArray.setAdUsedTime(new  Double(adTimes * adLength));			
		}	
		if(orderDayInfo.getDayStandardPrice() !=null){
	        dayInfoArray.setAdPrice(orderDayInfo.getDayStandardPrice());			
		}		
		if(orderDayInfo.getResourceSpecific() !=null){
	        dayInfoArray.setAdSpecific(orderDayInfo.getResourceSpecific());	
	        dayInfoArray.setIsAdSpecificed(Boolean.valueOf(orderDayInfo.getResourceSpecific() !=""));
		} else{
			dayInfoArray.setIsAdSpecificed(Boolean.valueOf(false));
		}
		

			dayInfoArray.setDayRelIncome(new Double(StringUtil.getNullValue(orderDayInfo.getDayRelIncome(),"0")));
		
		if(orderDayInfo.getDayRelPuton() ==null){
			dayInfoArray.setDayRelPuton(new Double(0));
		}else{
			dayInfoArray.setDayRelPuton(orderDayInfo.getDayRelPuton());
		}
	
		
		
//		if(compagesId.longValue() > 0) dayInfoArray.setIsCompages(Boolean.valueOf(true));
	
	}	

	
	public Collection getCustomerProductByBeginAndEndDateColl(String[] carrierIds,String channel,String beginDate, String endDate,String userId,String curUserName,String isPrint,String orgId) {
//		Collection lsAll = new ArrayList();
		Map mp = new HashMap();
//		Map mapCust = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		mp.put("carrierIdList",carrierIdList);
//		mp.put("parentId",carrierName);
		
		
//		if((!"".equals(userId) &&  userId!=null)){
//    		List userls = new ArrayList();
//
//    		mp.put("UserIdList",userls);
//    	}else{
//    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//    		if(isPrint.equals("false")){//页面显示
//    			list = userManager.getOwnerUsersList(userRelsMap);
//    		}else{                      //打印显示
//    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
//    		}
////    		System.out.println(">>>>>  1  "+ls.size()) ;
//    		for(Iterator it=list.iterator();it.hasNext();){
//    			User user = (User)it.next();
//    			userIdList.add(user.getId());
//    		}
//    		mp.put("UserIdList",userIdList);
//    	}
		
		
		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    	
    		mp.put("UserIdList",userls);
		}else{
	    	userIdList = 	UserUtil.getCurUserRels(curUserName,orgId);
	    	if(userIdList.size() == 0) userIdList.add("-1");
	    	mp.put("UserIdList",userIdList);
    	}
		

		
		
		List ls = dao.getCustomerProductByBeginAndEndDate(mp);
		
		Map inputonMap = incomeUsedManager.getCustomerPutonMoney(mp);
		
		return getCustomerProductByListDetails(ls,inputonMap);
//		Map mapCustomerName = getCustomerByList(ls);
//		
//		for (Iterator it = mapCustomerName.keySet().iterator(); it.hasNext();) {
//			 String key_customerName = (String)it.next();
//			 List newCutList = getNewListByCustomerName(ls,key_customerName);
//			 			 
//			 mapCust.put(key_customerName,newCutList);
//		}
//		for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
//			List cutList = (List)it.next();
//			Double sumReal = getSumRealPlay(cutList);
//			
//			CustomerProduct customerProduct = new CustomerProduct();
//			customerProduct.setMatterName("小计");
//			customerProduct.setRelIncome(sumReal);
//			cutList.add(customerProduct);
//			
//			CollectionUtils.addAll(lsAll,cutList.iterator());
//		}
//
//		return lsAll;
	}
	
	
	public List getOaTeleExpensesByBeginAndEndDate(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint) {
		List lsAll = new ArrayList();
		Map mp = new HashMap();
		Map mapCust = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("carrierIdList",carrierIdList);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		List ls = dao.getCustomerProductByBeginAndEndDate(mp);
		
		Map mapCustomerName = getCustomerByList(ls);
		
		for (Iterator it = mapCustomerName.keySet().iterator(); it.hasNext();) {
			 String key_customerName = (String)it.next();
			 List newCutList = getNewListByCustomerName(ls,key_customerName);
			 			 
			 mapCust.put(key_customerName,newCutList);
		}
		for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
			List cutList = (List)it.next();
			Double sumReal = getSumRealPlay(cutList);
			CustomerProduct customerProduct = new CustomerProduct();
			customerProduct.setCustomerName("");
			customerProduct.setMatterName("小计");
			customerProduct.setRelIncome(sumReal);
			cutList.add(customerProduct);
			
			CollectionUtils.addAll(lsAll,cutList.iterator());
		}

		return lsAll;
	}
	
	private List getCustomerProductByListDetails(List ls,Map inputonMap){
		Map map = new HashMap();
		Map mapCust = new HashMap();
//		Map mapIndustryType = new HashMap();
		List lsAll  = new ArrayList();
		double sum = getSumRelIncome(ls);
		double sum2 = getSumRelIncome2(ls);
		
		System.out.println(">>>>777777>>>111111111  3333333333        5555555   777777777   9999 sum2  >" + sum2);
		
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String id = customerProduct.getResourceId().toString();
			String customerName = customerProduct.getIndustryType();
			String brandName = customerProduct.getMatterName();
			Double putonMoney =(Double) inputonMap.get(id+brandName);
			if(putonMoney == null){
				customerProduct.setPutOn(new Double(0));
			}else{
				customerProduct.setPutOn(putonMoney);
			}
			
			//求每个客户品牌的合计
//			getIndustrySum(customerProduct,mapIndustryType);
			getCustomerSum(customerProduct,mapCust);
			customerProduct.setIndustryType("");
			
			if(map.containsKey(customerName)){
				CustomerProduct cProduct = (CustomerProduct)mapCust.get(customerName);
				customerProduct.setUsed(StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),cProduct.getRelIncome().doubleValue()));
				customerProduct.setSumUsed(StringUtil.persentFormat(customerProduct.getTimeUsed().doubleValue(),cProduct.getTimeUsed().doubleValue()));
				
				List ls2 = (List)map.get(customerName);
				ls2.add(customerProduct);
				map.put(customerName,ls2);
			}else{
				CustomerProduct cProduct = (CustomerProduct)mapCust.get(customerName);
				customerProduct.setUsed(StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),cProduct.getRelIncome().doubleValue()));
				customerProduct.setSumUsed(StringUtil.persentFormat(customerProduct.getTimeUsed().doubleValue(),cProduct.getTimeUsed().doubleValue()));
				
				List ls2 = new ArrayList();
				ls2.add(customerProduct);
				map.put(customerName,ls2);
			}
			
			
		}
		
		
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			List cutList = (List)map.get(key);
			CustomerProduct cutP =  (CustomerProduct)cutList.get(0);
			cutP.setIndustryType(key);
			CustomerProduct customerProduct = (CustomerProduct)mapCust.get(key);
			for(Iterator itc = cutList.iterator();itc.hasNext();){
				CustomerProduct cProduct =  (CustomerProduct)itc.next();
				cProduct.setUsed(StringUtil.persentFormat(cProduct.getRelIncome().doubleValue(),customerProduct.getRelIncome().doubleValue()));
				cProduct.setSumUsed(StringUtil.persentFormat(customerProduct.getTimeUsed().doubleValue(),cProduct.getTimeUsed().doubleValue()));
			}
//			cutList.add(cutList.size()+1,cutList.get(0));
//			cutList.add(0,customerProduct);
			customerProduct.setUsed(StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),sum));
			customerProduct.setSumUsed(StringUtil.persentFormat(customerProduct.getTimeUsed().doubleValue(),sum2));
			cutList.add(customerProduct);
			CollectionUtils.addAll(lsAll,cutList.iterator());
		}
		return lsAll;
	}
	private void getCustomerSum(CustomerProduct cutP,Map mapCust){
		String key = cutP.getIndustryType();
		Object obj  = mapCust.get(key);

		if(obj == null) {
			CustomerProduct cutProduct =  new CustomerProduct();
			cutProduct.setIndustryType("");
			cutProduct.setMatterName("小计");
			cutProduct.setRelIncome(cutP.getRelIncome());
			cutProduct.setPutOn(cutP.getPutOn());
			cutProduct.setTimeUsed(cutP.getTimeUsed());
			mapCust.put(key,cutProduct);
		}else{
			CustomerProduct  cutProduct = (CustomerProduct)obj;
			double relIncome = cutProduct.getRelIncome().doubleValue();
			double putOn = cutProduct.getPutOn().doubleValue();;
			double times = cutProduct.getTimeUsed().doubleValue();	
			cutProduct.setRelIncome(new Double(relIncome+cutP.getRelIncome().doubleValue()));
			cutProduct.setPutOn(new Double(putOn+cutP.getPutOn().doubleValue()));
			cutProduct.setTimeUsed(new Double(times+cutP.getTimeUsed().doubleValue()));
			mapCust.put(key,cutProduct);
		}
	}
	//得到客户品牌投放量的mp 
	public Map getOaTeleExpensesByBeginAndEndDate2(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint) {
//		List lsAll = new ArrayList();
		Map mp = new HashMap();
//		Map mapCust = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("carrierIdList",carrierIdList);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
  if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
		
     	
     	
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();

		
		if(financialAuditSwitch){
			String version = beginDate.substring(0,4);
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(version);
			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
			mp.put("OrderCategoryIdList",OrderCategoryIdList);
		}

		
		List ls = dao.getCustomerProductByBeginAndEndDate(mp);
		
		Map inputonMap = incomeUsedManager.getCustomerPutonMoney(mp);

		
		return getIndustryTypeByListDetails2(ls,inputonMap);
		
//		Map mapCustomerName = getCustomerByList(ls);
//		
//		for (Iterator it = mapCustomerName.keySet().iterator(); it.hasNext();) {
//			 String key_customerName = (String)it.next();
//			 List newCutList = getNewListByCustomerName(ls,key_customerName);
//			 			 
//			 mapCust.put(key_customerName,newCutList);
//		}
//		for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
//			List cutList = (List)it.next();
//			Double sumReal = getSumRealPlay(cutList);
//			CustomerProduct customerProduct = new CustomerProduct();
//			customerProduct.setCustomerName("");
//			customerProduct.setMatterName("小计");
//			customerProduct.setRelIncome(sumReal);
//			cutList.add(customerProduct);
//			
//			CollectionUtils.addAll(lsAll,cutList.iterator());
//		}
//		mapCust.put("key_customerName",mapCustomerName);
//		
//		return mapCust;
	}
	
	private List getNewListByCustomerName(List ls,String custName){
		List lsCustomer = new ArrayList();
		int i = 0 ;
		
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String customerName = customerProduct.getIndustryType();
			
			if(customerName.equals(custName)){
				if(i > 0) customerProduct.setIndustryType("");
				i++;
				lsCustomer.add(customerProduct);
			}
		}
				
		return lsCustomer;
	}
	
	
	private Map getCustomerByList(List ls){
		Map map = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String customerName = customerProduct.getIndustryType();
			map.put(customerName,customerProduct);
		}
		return map;
	}
	

	private Double getSumPutOn(List ls){
		double sumReal = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			Double putOn = customerProduct.getPutOn();
			sumReal += putOn.doubleValue();
		}
		
//		double value = Math.round(sumReal / .01) * .01;
		double value = Math.round(sumReal);
//		System.out.println("  1  "+value);
		return new Double(value);
	}
	
	private Double getSumRealPlay(List ls){
		double sumReal = 0;
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			Double relIncome = customerProduct.getRelIncome();
			sumReal += relIncome.doubleValue();
		}
		
//		double value = Math.round(sumReal / .01) * .01;
		double value = Math.round(sumReal);
		
		return new Double(value);
	}
	
	private double[] getSumRealPlayPutonTimes(List ls,Map mp){
	
		Map inputonMap = incomeUsedManager.getIndustryPutonMoney(mp);

		double res[] = new  double[3];
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String matterName = customerProduct.getMatterName();
			Object obj = inputonMap.get(matterName);
			if(obj==null) {
				customerProduct.setPutOn(new Double(0));
			}else{
				customerProduct.setPutOn((Double)obj);
			}
			Double relIncome = customerProduct.getRelIncome();
			Double putOn = customerProduct.getPutOn();
			Double times = customerProduct.getTimeUsed();
			res[0] += relIncome.doubleValue();
			res[1] += putOn.doubleValue();
			res[2] += times.doubleValue();
		}
		return res;
	}
	
	 public List getIndustryTypeProductByBeginAndEndDate(int channelModel,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint) {
//		List lsAll = new ArrayList();
		
//		PaginatedList paginatedList = new PaginatedList();
		
		Map mp = new HashMap();
//		Map mapCust = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModel==1){
			 channelPull = true;
		}
		
		
		String[] carrierIds = carrierName.split(",");
		for(String cc:carrierIds){
			List carrierIdList22 = carrierManager.getCarrierIdLists(cc,channelPull,curUserName);
			CollectionUtils.addAll(carrierIdList, carrierIdList22.iterator());
		}

//		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		mp.put("carrierIdList",carrierIdList);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
		List ls = dao.getIndustryTypeProductByBeginAndEndDate(mp);
		
		
//		Map inputonMap = incomeUsedManager.getIndustryPutonMoney(mp);
		Map inputonMap = incomeUsedManager.getIndustryPutonMoney(mp);
		

		
		return getIndustryTypeByListDetails(ls,inputonMap);
	}
	 
	 public Map getIndustryTypeProductByBeginAndEndDate2(int channelModel,String beginDate,String endDate,String userId,String carrierNames,String curUserName,String isPrint) {
//			List lsAll = new ArrayList();
			
//			PaginatedList paginatedList = new PaginatedList();
			
			Map mp = new HashMap();
//			Map mapCust = new HashMap();
			List list = new ArrayList();
			List userIdList = new ArrayList();
			List carrierIdList = new ArrayList();
			
			mp.put("beginDate",beginDate);
			mp.put("endDate",endDate);
//			mp.put("parentId",carrierName);

//			判断是否分频道，值为1分，否则不分
			boolean channelPull = false;
			if(channelModel==1){
				 channelPull = true;
			}
			
			String[] carrierIds = carrierNames.split(",");
			
//			System.out.println(">>>>> carrierNames.split>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+carrierIds.length) ;
			
			for(String cc:carrierIds){
//				System.out.println(">>>>> carrierNames.split>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+cc) ;
				
				List carrierIdList22 = carrierManager.getCarrierIdLists(cc,channelPull,curUserName);
				
//				System.out.println(">>>>> carrierNames.split>>>>>>>>carrierIdList22>>>>>>>>>>>>>>>>>>>>>>  "+carrierIdList22.size()) ;
				
				CollectionUtils.addAll(carrierIdList, carrierIdList22.iterator());
			}
			
//			System.out.println(">>>>> carrierNames.split>>>>>>>>>>carrierIdList>>>>>>>>>>>>>>>>>>>>  "+carrierIdList.size()) ;
			
			mp.put("carrierIdList",carrierIdList);
			
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		if(userId.indexOf(",")>-1){
	    			CollectionUtils.addAll(userls, userId.split(","));
	    		}else{
	    			userls.add(userId);
	    			}
	    		mp.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    		if(isPrint.equals("false")){//页面显示
	    			list = userManager.getOwnerUsersList(userRelsMap);
	    		}else{                      //打印显示
	    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
	    		}
//	    		System.out.println(">>>>>  1  "+ls.size()) ;
	    		for(Iterator it=list.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
			
	     	if(UserUtil.isUserOrderYearRel()) {
	     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
	     	}
	     	
			
			List ls = dao.getIndustryTypeProductByBeginAndEndDate(mp);
			
			
//			Map inputonMap = incomeUsedManager.getIndustryPutonMoney(mp);
			Map inputonMap = incomeUsedManager.getIndustryPutonMoney(mp);
			

			
			return getIndustryTypeByListDetails2(ls,inputonMap);
		}


	private Map getIndustryTypeByList(List ls){
		Map map = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String industryType = customerProduct.getIndustryType();
			map.put(industryType,industryType);
		}
		return map;
	}
	
	private List getIndustryTypeByListDetails(List ls,Map inputonMap){
		Map map = new HashMap();
		Map mapIndustryType = new HashMap();
		List lsAll  = new ArrayList();
		double sum =getSumRelIncome(ls);
		
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String id = customerProduct.getResourceId().toString();
			String industryType = customerProduct.getIndustryType();
			String brandName = customerProduct.getMatterName();
			Double putonMoney =(Double) inputonMap.get(id+brandName);
			if(putonMoney == null){
				customerProduct.setPutOn(new Double(0));
			}else{
				customerProduct.setPutOn(putonMoney);
			}
			
			//求每个行业的合计
			getIndustrySum(customerProduct,mapIndustryType);
			
			customerProduct.setIndustryType("");
			
			if(map.containsKey(industryType)){
				List ls2 = (List)map.get(industryType);
				ls2.add(customerProduct);
				map.put(industryType,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(customerProduct);
				map.put(industryType,ls2);
			}
		}
		
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			List cutList = (List)map.get(key);
			CustomerProduct cutP =  (CustomerProduct)cutList.get(0);
			cutP.setIndustryType(key);
			CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				for(Iterator itl = cutList.iterator();itl.hasNext();){
					CustomerProduct cProduct =  (CustomerProduct)itl.next();
					cProduct.setUsed(StringUtil.persentFormat(cProduct.getRelIncome().doubleValue(),customerProduct.getRelIncome().doubleValue()));
				}

			
//			//用这个serUsed存放比例			
//			cutList.add(cutList.size()+1,cutList.get(0));
//			cutList.add(0,customerProduct);
				customerProduct.setUsed(StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),sum));
			cutList.add(customerProduct);
			CollectionUtils.addAll(lsAll,cutList.iterator());
		}
		return lsAll;
	}
	
	
	
	private Map getIndustryTypeByListDetails2(List ls,Map inputonMap){
		Map map = new HashMap();
		Map mapIndustryType = new HashMap();
       		
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String id = customerProduct.getResourceId().toString();
			String industryType = customerProduct.getIndustryType();
			String brandName = customerProduct.getMatterName();
			Double putonMoney =(Double) inputonMap.get(id+brandName);
			if(putonMoney == null){
				customerProduct.setPutOn(new Double(0));
			}else{
				customerProduct.setPutOn(putonMoney);
			}
			
			
			//求每个行业的合计
			getIndustrySum(customerProduct,mapIndustryType);
			
			customerProduct.setIndustryType("");
			
			if(map.containsKey(industryType)){
				List ls2 = (List)map.get(industryType);
				ls2.add(customerProduct);
				map.put(industryType,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(customerProduct);
				map.put(industryType,ls2);
			}
		}
		map.put("mapIndustryType",mapIndustryType);
		return map;
	}
	public List getOrderCategoryByCarrierTypePandect(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint,String orgId){
		List list = new ArrayList();
		Map map = getOaTeleExpensesByBeginAndEndDate2(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		Map mapIndustryType = (Map)map.get("mapIndustryType");
		double res[] = new  double[3];
		double sum = sumIndustryType(mapIndustryType);
		double sum2 = sumIndustryType2(mapIndustryType);
		
		
		
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct obj = (CustomerProduct)mapIndustryType.get(key);	
				Double relIncome = obj.getRelIncome();
				Double putOn = obj.getPutOn();
				Double times = obj.getTimeUsed();
				res[0] += relIncome.doubleValue();
				res[1] += putOn.doubleValue();
				res[2] += times.doubleValue();		
				
				String relIncomeScale = StringUtil.persentFormat(relIncome.doubleValue(),sum);
				String relTimeScale = StringUtil.persentFormat(times.doubleValue(),sum2);
				
				
				obj.setIndustryType(key);
				obj.setMatterName("");
				obj.setUsed(relIncomeScale);
				obj.setSumUsed(relTimeScale);
				list.add(obj);
			}
		}
		if(map.size()>0){
			CustomerProduct cusProduct = new CustomerProduct();
			cusProduct.setIndustryType("合计:");
			cusProduct.setMatterName("");
			cusProduct.setRelIncome(new Double(res[0]));
			cusProduct.setPutOn(new Double(res[1]));
			cusProduct.setTimeUsed(new Double(res[2]));
			cusProduct.setUsed("");
			cusProduct.setSumUsed("");
			list.add(cusProduct);
		}
		return list ;
	}
	private static double sumIndustryType(Map mapIndustryType){
		double res[] = new  double[1];
		for (Iterator it = mapIndustryType.values().iterator(); it.hasNext();) {
			CustomerProduct customerProduct = (CustomerProduct)it.next();
			Double relIncome = customerProduct.getRelIncome();
			res[0] += relIncome.doubleValue();
			}
		if(mapIndustryType.size()==0) res[0]=0;
		return res[0];
	}
	private static double sumIndustryType2(Map mapIndustryType){
		double res[] = new  double[1];
		for (Iterator it = mapIndustryType.values().iterator(); it.hasNext();) {
			CustomerProduct customerProduct = (CustomerProduct)it.next();
			Double relIncome = new Double(StringUtil.getNullValue(customerProduct.getTimeUsed(),"0"));
			res[0] += relIncome.doubleValue();
			}
		if(mapIndustryType.size()==0) res[0]=0;
		return res[0];
	}
	//是否可以作为计算总计的方法？
	private double getSumRelIncome(List ls){
		double res[] = new  double[1];
		for (Iterator it = ls.iterator(); it.hasNext();) {
			CustomerProduct customerProduct = (CustomerProduct)it.next();
			Double relIncome = customerProduct.getRelIncome();
			res[0] += relIncome.doubleValue();
			}
		if(ls.size()==0) res[0]=0;
		return res[0];
	}

	
	private  double getSumRelIncome2(List ls){
		double res[] = new  double[1];
		for (Iterator it = ls.iterator(); it.hasNext();) {
			CustomerProduct customerProduct = (CustomerProduct)it.next();
			Double relIncome = new Double(StringUtil.getNullValue(customerProduct.getTimeUsed(),"0"));
			res[0] += relIncome.doubleValue();
			}
		if(ls.size()==0) res[0]=0;
		return res[0];
	}	
	
	private void getIndustrySum(CustomerProduct cutP,Map mapIndustryType){
		String key = cutP.getIndustryType();
		Object obj  = mapIndustryType.get(key);
//		List cutList = (List)mapIndustryType.get(key);
		if(obj == null) {
			CustomerProduct cutProduct =  new CustomerProduct();
			cutProduct.setIndustryType("");
			cutProduct.setMatterName("小计");
			cutProduct.setRelIncome(cutP.getRelIncome());
			cutProduct.setPutOn(cutP.getPutOn());
			cutProduct.setTimeUsed(cutP.getTimeUsed());
//			cutProduct.setUsed(cutP.getUsed());
			mapIndustryType.put(key,cutProduct);
		}else{
			CustomerProduct  cutProduct = (CustomerProduct)obj;
			double relIncome = cutProduct.getRelIncome().doubleValue();
			double putOn = cutProduct.getPutOn().doubleValue();;
			double times = cutProduct.getTimeUsed().doubleValue();	
			cutProduct.setRelIncome(new Double(relIncome+cutP.getRelIncome().doubleValue()));
			cutProduct.setPutOn(new Double(putOn+cutP.getPutOn().doubleValue()));
			cutProduct.setTimeUsed(new Double(times+cutP.getTimeUsed().doubleValue()));
//			makeChiled(cutList,key,relIncome);
			mapIndustryType.put(key,cutProduct);
		}
	}

//	private List getNewListByIndustryType(List ls,String industryTypeName){
//		List lsIndustry = new ArrayList();
//		int i = 0 ;
//		
//		for (Iterator it = ls.iterator();it.hasNext();){
//			
//			CustomerProduct customerProduct = (CustomerProduct) it.next();
//			
//			String industryType = customerProduct.getIndustryType();
//			
//			if(industryType.equals(industryTypeName)){
//				if(i > 0) customerProduct.setIndustryType("");
//				i++;
//				lsIndustry.add(customerProduct);
//			}
//		}
//				
//		return lsIndustry;
//	}
	public List getAdvTypeProductByBeginAndEndDate(int channelModel,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint) {
		List lsAll = new ArrayList();
		Map mp = new HashMap();
		Map mapCust = new HashMap();
		List list = new ArrayList();
		List carrierIdList = new ArrayList();
		List userIdList = new ArrayList();
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModel==1){
			 channelPull = true;
		}
		
		String[] carrierIds = carrierName.split(",");
		for(String cc:carrierIds){
			List carrierIdList22 = carrierManager.getCarrierIdLists(cc,channelPull,curUserName);
			CollectionUtils.addAll(carrierIdList, carrierIdList22.iterator());
		}
		
//		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		mp.put("carrierIdList",carrierIdList);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
		List ls = dao.getAdvTypeProductByBeginAndEndDate(mp);

		Map advTypeMap = getAdvTypeByIdList(ls);
		
		for (Iterator it = advTypeMap.keySet().iterator(); it.hasNext();) {
			 String key_advType = (String)it.next();
			 
			 List newCutList = getNewListByAdvType(ls,key_advType);
			 			 
			 mapCust.put(key_advType,newCutList);
		}
		
		for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
			List cutList = (List)it.next();
			Double sumReal = getSumRealPlay(cutList);
			
			CustomerProduct customerProduct = new CustomerProduct();
			customerProduct.setMatterName("小计");
			customerProduct.setRelIncome(sumReal);
			Double d = new Double(0);
			customerProduct.setTimeUsed(d);
			cutList.add(customerProduct);
			
			CollectionUtils.addAll(lsAll,cutList.iterator());
		}
//把timeUsed加到used变为String(用于打印)
//-----------------------------------------------------------------

		for (Iterator it = lsAll.iterator(); it.hasNext();) {
					CustomerProduct customerProduct = (CustomerProduct) it.next();
					double a = customerProduct.getTimeUsed().doubleValue()*100;
					String b = String.valueOf(a);
					String c = b.equals("0.0")?"0":b.substring(0,4);
					customerProduct.setUsed(c);
				}
//	-----------------------------------------------------------------
		return lsAll;
	}
	
	private Map getAdvTypeByIdList(List ls){
		Map map = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String carrierName = customerProduct.getCarrierName();
			map.put(carrierName,carrierName);
		}
		return map;
	}
	private List getNewListByAdvType(List ls,String carrierName){
		List lsIndustry = new ArrayList();
		int i = 0 ;
		
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
//			double timeUsed=customerProduct.getTimeUsed();
			String carName = customerProduct.getCarrierName();
			
			if(carName.equals(carrierName)){
				if(i > 0) customerProduct.setCarrierName("");
				i++;
				lsIndustry.add(customerProduct);
			}
		}
				
		return lsIndustry;
	}
	
	public List getIndustryTypeProductTotalBrowser(int channelModeParam,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint) {
		List lsAll = new ArrayList();
		Map mp = new HashMap();
		Map mapCust = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModeParam==1){
			 channelPull = true;
			}
		
		
		String[] carrierIds = carrierName.split(",");

		for(String cc:carrierIds){
			List carrierIdList22 = carrierManager.getCarrierIdLists(cc,channelPull,curUserName);
			CollectionUtils.addAll(carrierIdList, carrierIdList22.iterator());
		}
//		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		mp.put("carrierIdList",carrierIdList);
		
//		System.out.println(">>>>>  1  "+isPrint) ;
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		double sumReal = 0;
		List ls = dao.getIndustryTypeProductByBeginAndEndDate(mp);
		
//		System.out.println("<<<<<<<<<<ls  >>>>>>>>>>   "+ls.size());
		Map advTypeMap = getIndustryTypeByList(ls);
		
		for (Iterator it = advTypeMap.keySet().iterator(); it.hasNext();) {
			 String key_advType = (String)it.next();
			 
			 CustomerProduct newCP = getNewIndustryList(ls,key_advType);
			 			 
			 mapCust.put(key_advType,newCP);
		}
//		
		for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
			CustomerProduct cutPro = (CustomerProduct)it.next();
			sumReal += cutPro.getRelIncome().doubleValue();
			lsAll.add(cutPro);
			
//			CollectionUtils.addAll(lsAll,cutList.iterator());
		}
		
		lsAll.add(new Double(sumReal));
		return getIndustryTotalRateList(lsAll);
	}
	
	private List getIndustryTotalRateList(List ls){
		List productRate = new ArrayList();
		Double sumReal = (Double)ls.get(ls.size()-1);
		
//		System.out.println("<<<<<<<<<<  sumReal  >>>>>>>>>"+sumReal);
		
		ls.remove(ls.size()-1);
		for(Iterator it = ls.iterator(); it.hasNext();) {
			CustomerProduct cutPro = (CustomerProduct)it.next();
			String rates;
			double rate = 0;
			String rateStr = new Double(cutPro.getRelIncome().doubleValue()/sumReal.doubleValue()*100).toString();
//			System.out.println("<<<<<<<<<<  rateStr %%%%%%"+rateStr);
			if(rateStr.length()>5){
				rates = rateStr.substring(0,4);
				rate = new Double(rates).doubleValue();
//				System.out.println("<<<<<<<<<<  rateStr  if %%%%%%"+rates);
			}else{
				rate = new Double(rateStr).doubleValue();
//				System.out.println("<<<<<<<<<<  rate else %%%%%%"+rate);
			}
			 
//			double rate = Math.round(cutPro.getRelIncome().doubleValue()/sumReal.doubleValue()*100);
//			System.out.println("<<<<<<<<<<  rate %%%%%%"+rate);
			//用这个serUsed存放比例			
			cutPro.setUsed(new Double(rate).toString()+"%");
			productRate.add(cutPro);
		}
		CustomerProduct customerProduct = new CustomerProduct();
		customerProduct.setIndustryType("合计");
		customerProduct.setRelIncome(sumReal);
		customerProduct.setUsed("");
		productRate.add(customerProduct);
//		System.out.println("<<<<<<<<<<  productRate  >>>>>>>>>"+productRate.size());
		return productRate;
	}
	
	private CustomerProduct getNewIndustryList(List ls,String carrierName){
//		List lsIndustry = new ArrayList();
		double industryMoney=0;
		CustomerProduct cpMoney = new CustomerProduct();
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String carName = customerProduct.getIndustryType();
			
			if(carName.equals(carrierName)){
				industryMoney+=customerProduct.getRelIncome().doubleValue();
//				lsIndustry.add(customerProduct);
			}
		}
		cpMoney.setIndustryType(carrierName)	;
		cpMoney.setRelIncome(new Double(industryMoney));
//		System.out.println("<<<<<<<<<<  cpMoney  >>>>>>>>>>   "+carrierName+"   "+industryMoney);
		return cpMoney;
	}
	
	public String getCustomerProductCount(String[] carrierIds,int channelModelParam, String beginDate, String endDate,String userId,String curUserName,String isPrint) {
		List lsAll = new ArrayList();
		Map mp = new HashMap();
		Map mapCust = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		mp.put("carrierIdList",carrierIdList);
//		mp.put("parentId",carrierName);

		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		List ls = dao.getCustomerProductByBeginAndEndDate(mp);
		Map mapCustomerName = getCustomerByList(ls);
		
		for (Iterator it = mapCustomerName.keySet().iterator(); it.hasNext();) {
			 String key_customerName = (String)it.next();
			 List newCutList = getNewListByCustomerName(ls,key_customerName);
			 			 
			 mapCust.put(key_customerName,newCutList);
		}
		for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
			List cutList = (List)it.next();
			Double sumReal = getSumRealPlay(cutList);
			
			CustomerProduct customerProduct = new CustomerProduct();
			customerProduct.setMatterName("小计");
			customerProduct.setRelIncome(sumReal);
			cutList.add(customerProduct);
			
			CollectionUtils.addAll(lsAll,cutList.iterator());
		}
		
		return new Integer(mapCust.size()).toString();
	}
	public String getIndustryTypeProductCount(int channelModelParam,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;

		if(channelModelParam==1){
			 channelPull = true;
			}
		
		
		
		String[] carrierIds = carrierName.split(",");
		for(String cc:carrierIds){
			List carrierIdList22 = carrierManager.getCarrierIdLists(cc,channelPull,curUserName);
			CollectionUtils.addAll(carrierIdList, carrierIdList22.iterator());
		}
//		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		mp.put("carrierIdList",carrierIdList);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		return dao.getIndustryTypeProductCount(mp).toString();
	}
	public String getAdvTypeProductCount(int channelModelParam,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModelParam==1){
			 channelPull = true;
		}
		
		
		
		
		String[] carrierIds = carrierName.split(",");
		for(String cc:carrierIds){
			List carrierIdList22 = carrierManager.getCarrierIdLists(cc,channelPull,null);
			CollectionUtils.addAll(carrierIdList, carrierIdList22.iterator());
		}
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,null);
		mp.put("carrierIdList",carrierIdList);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		return dao.getAdvTypeProductCount(mp).toString();
	}
	
	public List getOrderDetailTable(String orderId){
//		System.out.print("orderId   "+orderId);
		return (List)this.getOrderDetailss(orderId,"0","0",null,null,true,2);
	}
	public String getOrderDetailXml(String orgId,String orderId){
		StringBuffer sb = new StringBuffer();
		List all = getOrderDetailTable(orderId);
		OrderDetailUtil.makeTreeGridXML(sb,all,orgId);
		return sb.toString();
	}
	
	
	//如果全部通过就直接改变订单checkState
	public void saveOrderDetailCheckState(String orderDetailIds,String state){
		Map mp = new HashMap();
		List OrderDetailIdList = new ArrayList();
		
		CollectionUtils.addAll(OrderDetailIdList,orderDetailIds.split(","));
		mp.put("stateId",state);
		mp.put("OrderDetailIdList",OrderDetailIdList);
		
		

		if(OrderDetailIdList.size() > 0){
//			System.out.println("state >>>>><<ccccccccccccccccccccccccccccccccccc<<<<    "+state);
//			System.out.println("OrderDetailIdList >>>>><<ccccccccccccccccccccccccccccccccccc<<<<    "+OrderDetailIdList);
			dao.saveOrderDetailCheckState(mp);			
		}
		

		
	}
	
	
	public Collection getOrderDetailss(String orderId,String beginDate,String endDate,String carrierId,String matterName,boolean isRelPrice,int mode) {
//		System.out.println(">>>>>carrierId >>>>   "+carrierId);
		String tvName = SysParamUtil.getTvNameParam();
		
		boolean isMoreCarrier = SysParamUtil.getMoreChannelPara();
		List newOrderDayList = new ArrayList();
		Map mp = new HashMap();
		if(carrierId!=null && !"0".equals(carrierId)){
			Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
			List carrierIds = (List)carrierMap.get(new Long(carrierId));
			
			List cids = new ArrayList();
			for(Iterator s = carrierIds.iterator();s.hasNext();){
				Carrier c = (Carrier)s.next();
				cids.add(c.getId());
	//			System.out.println(">>>>><<<<<<    "+c.getId());
			}
			mp.put("carrierIds",cids);
		}
		if(matterName!=null ){
			mp.put("matterName",matterName);
		}
		mp.put("orderId",orderId);
//		System.out.println(">>>>>orderId >>99999999999999999999999999999999999999999999999>>   "+orderId);
//		 List ls = dao.getOrderDetailByOrderId(new Long(orderId));
		 List ls = dao.getOrderDetailByMap(mp);
		 
		 if(mode == 2||mode == 4){
			 Collections.sort(ls,new OrderDetailAdNameComparator());
		 }
//			System.out.println(">>>>>carrierId >>>>   "+carrierId);
		 boolean isLimit = !"0".equals(beginDate);
//		 List newOrderDayList = new ArrayList();
		 
		 Collection coll = new ArrayList() ;

		 OrderDayInfo orderDayInfo = new OrderDayInfo();
		 orderDayInfo.setOrderId(new Long(orderId));
//		 if(isLimit) {
//			 orderDayInfo.setStartDate(beginDate);
//			 orderDayInfo.setEndDate(endDate);
//		 }
		 
		 
//			System.out.println(">>>>999999999>>orderId>>>"+orderId);
//			System.out.println(">>>>999999999>>beginDate>>>"+beginDate);
//			System.out.println(">>>>999999999>>endDate>>>"+endDate);
//			System.out.println(">>>>999999999>>carrierId>>>"+carrierId);
//			System.out.println(">>>>999999999>>matterName>>>"+matterName);
//			System.out.println(">>>>999999999>>isRelPrice>>>"+isRelPrice);
	
		 List orderDayList = orderDayInfoDao.getOrderDayInfos(orderDayInfo);
		 
//		 System.out.println(">>>>999999999>>orderDayList>>>"+orderDayList);
		 
		 
//		 if(orderDayList.size()==0||orderDayList==null){
//			 coll.add(new OrderDetailColl());
//			 return coll;
//		 }
//
//		 if(isLimit){
//			 OrderDayUtil.getOrderDayListByStartEnd(orderDayList,newOrderDayList,beginDate,endDate);
////			 log.info(">>>>>orderDayList.size>>>>" +orderDayList.size());
////			 log.info(">>>>>newOrderDayList.size>>>>" +newOrderDayList.size());
//		 }else{
////			 System.out.println(">>>>>orderDayList.size>>>>   "+orderDayList.size());
//			 if(orderDayList.size()==0||orderDayList==null){
//				 coll.add(new OrderDetailColl());
//				 return coll;
//			 }
//			 CollectionUtils.addAll(newOrderDayList,orderDayList.iterator());
//		 }
		 
		 
		 if(isLimit){
			 OrderDayUtil.getOrderDayListByStartEnd(orderDayList,newOrderDayList,beginDate,endDate);
//			 log.info(">>>>>orderDayList.size>fffffffffffffffffffffffffffffff>>>" +orderDayList.size());
//			 log.info(">>>>>newOrderDayList.size>>>vvvvvvvvvvvvvvvvvvvvvvvvvvv>" +newOrderDayList.size());
		 }else{
//			 System.out.println(">>>>>orderDayList.size>>>>   "+orderDayList.size());
			 if(orderDayList.size()==0||orderDayList==null){
				 coll.add(new OrderDetailColl());
				 return coll;
			 }
			 CollectionUtils.addAll(newOrderDayList,orderDayList.iterator());
		 }		 
		 

    		 for(Iterator it = ls.iterator();it.hasNext();){
    			 OrderDetail orderDetail = (OrderDetail)it.next();
    			 
//    			 log.info(">>>>888888888888888888888888888888888888888888888888888888888888888888888888>>>>>");
    			 
    			
    			 if(isLimit){
    				 
    				 Integer publishStartDate = orderDetail.getOrderPublic().getPublishStartDate();
    				 Integer publishEndDate = orderDetail.getOrderPublic().getPublishEndDate();
    				 
    				 String startDate = StringUtil.null2String(beginDate);
    				 String pstartDate = StringUtil.null2String(publishStartDate);
    				 
    				 if(Integer.parseInt(pstartDate) <  Integer.parseInt(startDate)){
    					 orderDetail.getOrderPublic().setPublishStartDate(new Integer(beginDate));
    				 }
    				 String edDate = StringUtil.null2String(endDate);
    				 String pendDate = StringUtil.null2String(publishEndDate);
    				
    				 if(Integer.parseInt(pendDate) >  Integer.parseInt(edDate)){
    					 orderDetail.getOrderPublic().setPublishEndDate(new Integer(endDate));
    				 }

    			 }
    			 OrderDetailColl[] orderDetailColls = getOrderDetailColl(orderDetail,newOrderDayList,isRelPrice,tvName,isMoreCarrier,mode);
    			 
    			 for(int i = 0;i< orderDetailColls.length;i++){
//    				 log.info(">>>>>>>>>" +orderDetailColls[i].toString());
    				 coll.add(orderDetailColls[i]);
//    				 log.info(">>>>8888888888>>>>>");
    			 }
    		 }       	 


		 
		 
		return coll;
	}
	
	

	
	private OrderDetailColl[] getOrderDetailColl(OrderDetail orderDetail,List orderDayList,boolean isRelPrice,String tvName,boolean isMoreCarrier,int mode){
		
		Long orderDetailId = orderDetail.getId();
		Resource resource = orderDetail.getResource();
		String orgId = orderDetail.getOrgId();
//		 log.info(">>>>888888888888888888888888888888888888888888888888888888888888888888888888>>>>>"+resource);

		
		String carrierParentName =StringUtil.getNullValue(orderDetail.getCarrierParentName(),"");
		String carrierName =StringUtil.getNullValue(orderDetail.getCarrier().getCarrierName(),"");
		String resourceName =StringUtil.getNullValue(resource.getResourceName(),"");
		String resourceMeno =StringUtil.getNullValue(resource.getMemo(),"");
		Workspan workspan = resource.getWorkspan();
		String broStartEndTime =workspan.getBroadcastTimeFormat();
//		 log.info(">>>>888888888888888888888888888888888888888888888888888888888888888888888888>>>>>"+workspan.getBroadcastTimeFormatStart());

		if(isMoreCarrier) carrierName  = carrierParentName;
       
		resourceName = ResourceUtil.getResourceName2(resource,mode,orgId);

		
		String specificName = orderDetail.getSpecific().getName();
		List orderDetailCollList = new ArrayList();

		String publishStartDate = orderDetail.getOrderPublic().getPublishStartDate()==null?"00000000":orderDetail.getOrderPublic().getPublishStartDate().toString();
		String publishEndDate = orderDetail.getOrderPublic().getPublishEndDate()==null?"00000000":orderDetail.getOrderPublic().getPublishEndDate().toString();
//		log.info(">>>>3333333>>>>>"+publishStartDate+"   1  "+publishEndDate);
		Double sysPrice = orderDetail.getSysPrice();

		int startMonth = Integer.parseInt(publishStartDate.substring(4,6));
		int endMonth = Integer.parseInt(publishEndDate.substring(4,6));
		int k = 0;

		 
		for(int i = startMonth;i<= endMonth;i++){
			
			OrderDetailColl orderDetailColl = new OrderDetailColl();
			orderDetailColl.setOrderDetailId(orderDetailId.toString());
			orderDetailColl.setPublishMemo(orderDetail.getPublishMemo());
			
			Object[] dayTimes = new Object[31];
//			 log.info(">>>>11111111>>>>>");
			List monthDays = OrderDayUtil.getOrderDaysByDetailId(orderDayList,orderDetailId,i);
			if(monthDays.size()>0){
//				log.info(">>>>222222222>>>>>");
				OrderDayUtil.getOrderMonthDays(monthDays,dayTimes);
//				log.info(">>>>3333333>>>>>");
				OrderDetailUtil.setOrderDetailColl(orderDetailColl,dayTimes);
//				log.info(">>>>44444444>>>>>");
				Object[] monthMonths = new Object[4];
				OrderDayUtil.getOrderMonthSysPrice(monthDays,sysPrice,monthMonths,isRelPrice);
//				 log.info(">>>>88888888888888888888888888888888888888888888888888888888"+ monthMonths[0] +"8888888888888888>>>>>"+monthMonths[1]);

//				log.info(">>>>5555555>>>>>");
				OrderDetailUtil.setOrderDetailColl(orderDetailColl,orderDetail,startMonth,i,dayTimes,monthMonths,carrierName, resourceName,broStartEndTime, specificName,mode);
//				log.info(">>>>66666666>>>>>");
				orderDetailCollList.add(orderDetailColl);
			}
//			orderDetailColls[k++] = orderDetailColl;
			
//			log.info(">>>>777777>>>>>");
		}
		
        int size = orderDetailCollList.size();
		OrderDetailColl[] orderDetailColls = new OrderDetailColl[size];
		for(Iterator it = orderDetailCollList.iterator();it.hasNext();){
			orderDetailColls[k++] = (OrderDetailColl)it.next();
		}
//		log.info(">>>>888888888888888888888888888888888888888888888888888888888888888888888888>>>>>"+k);
		return orderDetailColls;
	}

	public void saveContractPayMent(int model,long sumMoney,long contractId,long orderId,long paymentId,int resourceType) {
//		int model = 0;
//		Long orderId = new Long("0");
		Long detailId = new Long("0");
		List orderDetailIds = new ArrayList();
		boolean isCompages = false;
		Long parentId  = new Long("0"); 
		
		boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
		
		
		this.allotMoneyRealpay(model,sumMoney,new Long(paymentId),new Long(contractId),new Long(orderId),detailId,orderDetailIds,isCompages,parentId,new Integer(resourceType),0);
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderCategoryMain("0");
		orderDetail.getOrder().setContractId(new Long("0"));
		orderDetail.getOrder().setPaymentId(new Long(paymentId));
		orderDetail.setPaymentId(new Long(paymentId));
		orderDetail.setId(new Long("0"));
		if(isWithResourceSort && contractId == 0){
			orderDetail.setOrderId(new Long(orderId));
			orderDetail.getOrder().setPaymentId(new Long(0));
			orderDetail.setPaymentId(new Long(0));
		}else{
			orderDetail.setOrderId(new Long("0"));
		}

//		System.out.println(">>>>777777>>>>>");
		
		this.saveOrderDetailPublicInfo(orderDetail,1);
	}
	//行业品牌投放量统计
	public String getIndustryTypeProductByBeginAndEndDateXML(int channelModelParam, String beginDate, String endDate, String userId, String carrierNames, String curUserName, String isPrint) {
//		List ls = getIndustryTypeProductByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,curUserName,isPrint);
		Map mp = getIndustryTypeProductByBeginAndEndDate2(channelModelParam,beginDate,endDate,userId,carrierNames,curUserName,isPrint);
		return OrderDetailUtil.makeTreeGridXML30(mp);
	}
	//品牌投播情况表
	public String getIndustryTypeProductChannelByBeginAndEndDateXML(int channelModelParam, String beginDate, String endDate, String userId, String carrierNames, String curUserName, String isPrint) {
		Map mp = getIndustryTypeProductByBeginAndEndDate2(channelModelParam,beginDate,endDate,userId,carrierNames,curUserName,isPrint);
		Map channelMp = new HashMap();
		List lst = new ArrayList();
		
		String[] carrierIds = carrierNames.split(",");
		for(String cc:carrierIds){
			List ls11  = this.getChannelRelIncome(channelModelParam,beginDate,endDate,userId,cc,curUserName,isPrint);
			CollectionUtils.addAll(lst, ls11.iterator());
		}

		
		ResourceChannel resourceChannel = new ResourceChannel();
		resourceChannel.setEnable(new Integer(1));
		List channels = resourceChannelManager.getResourceChannels(resourceChannel);
		for (Iterator it = lst.iterator(); it.hasNext();) {
			CustomerProduct obj = (CustomerProduct) it.next();
			channelMp.put(obj.getIndustryType()+obj.getMatterName()+obj.getCarrierName(),obj.getRelIncome());
		}
		return OrderDetailUtil.makeTreeGridXML(mp,channelMp,channels);
	}

	private List getChannelRelIncome(int channelModel,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint){
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModel==1){
			 channelPull = true;
		}
		
		
		
		String[] carrierIds = carrierName.split(",");
		for(String cc:carrierIds){
			List carrierIdList22 = carrierManager.getCarrierIdLists(cc,channelPull,curUserName);
			CollectionUtils.addAll(carrierIdList, carrierIdList22.iterator());
		}
		
//		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		mp.put("carrierIdList",carrierIdList);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		return dao.getIndustryTypeProductChannelByBeginAndEndDate(mp);
	}
//	行业总览
//	public String getIndustryTypeProductTotalBrowserXML(int channelModel,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint) {
//		List ls = getIndustryTypeProductTotalBrowser(channelModel,beginDate,endDate,userId,carrierName,curUserName,isPrint);
//		return OrderDetailUtil.makeTreeGridXML4(ls);
//	}
	
	public String getOaTeleExpensesByBeginAndEndDateXML(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint){
//		List ls = getOaTeleExpensesByBeginAndEndDate(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		Map mp = getOaTeleExpensesByBeginAndEndDate2(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		return OrderDetailUtil.makeTreeGridXML30(mp);
	}
	
	public String getOaTeleExpensesByBeginAndEndDateXML2(String strQueryString){
		
		Map mp = new HashMap();
		
	  String carrierIds =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"carrierIds"));
	  String beginDate =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"beginDate"));
	  String endDate =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"endDate"));
	  String userId =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"userId"));
	  String isPrint =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"isPrint"));
	  String loginUser =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"loginUser"));
	  String orgId =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"orgId"));
		

		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		
		
		CollectionUtils.addAll(carrierIdList, carrierIds.split(","));
		

		
		mp.put("carrierIdList",carrierIdList);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		if(UserUtil.isUserOrderYearRel()) {
	     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
		}
		  
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		if(userId.indexOf(",")>-1){
    			CollectionUtils.addAll(userls, userId.split(","));
    		}else{
    			userls.add(userId);
    			}
    	
    		mp.put("UserIdList",userls);
		}else{
	    	userIdList = 	UserUtil.getCurUserRels(loginUser,orgId);
	    	if(userIdList.size() == 0) userIdList.add("-1");
	    	mp.put("UserIdList",userIdList);
    	}
		
		

		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		
		boolean financialAudit = SysParamUtil.getFinancialAudit();
		
		
		System.out.println("financialAudit>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+financialAudit) ;

		System.out.println("financialAuditSwitch>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+financialAuditSwitch) ;
		
		if(financialAudit){
			String version = beginDate.substring(0,4);
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(version);
			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
			mp.put("OrderCategoryIdList",OrderCategoryIdList);
			System.out.println("OrderCategoryIdList>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+OrderCategoryIdList.toString()) ;
		}

		System.out.println("carrierIdList>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+carrierIdList.toString()) ;
		System.out.println("beginDate>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+ beginDate) ;
		System.out.println("endDate>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+ endDate) ;
	   	System.out.println("userIdList>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+userIdList) ;
	   	
		List ls = dao.getCustomerProductByBeginAndEndDate(mp);
		
		Map inputonMap = incomeUsedManager.getCustomerPutonMoney(mp);
		
		System.out.println("ls.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+ls.size()) ;
		
		Map mppp =  getIndustryTypeByListDetails2(ls,inputonMap);	
		
		System.out.println("mppp.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+mppp.size()) ;
		
		return OrderDetailUtil.makeTreeGridXML30(mppp);
		
	}
	
	
	

	public void setIncomeUsedManager(IncomeUsedManager incomeUsedManager) {
		this.incomeUsedManager = incomeUsedManager;
	}

	public String saveOrderLog(OrderDetail oldOrderDetail, OrderDetail curOrderDetail) {
		
//		System.out.println(">>>>>  aaaaaaaaaaaaaaaaaaaaaaa  "+oldOrderDetail.toString()) ;
//		System.out.println(">>>>>  curOrderDetail.getMatter().getEdit aaaaaaaaaaaaaaaaaaaaaaa  "+curOrderDetail.getMatter().getEdit()) ;
		String tvName = SysParamUtil.getTvNameParam();
		String loginUser = curOrderDetail.getOrder().getLoginUser();
		
//		System.out.println("saveOrderLog loginUser >>>>>  aaaaaaaaaaaaaaaaaaaaaaa  "+loginUser) ;

		boolean tag_order_force_modify = UserUtil.isGrandedRes(loginUser,"tag_order_force_modify");
		boolean allowModiyPassedOrderParam = SysParamUtil.getAllowModiyPassedOrderParam();
		
		boolean permitModAdverParam = SysParamUtil.getPermitModAdverParam();
		
//		System.out.println("saveOrderLog permitModAdverParam >>>>>  bbbbbbbbbbbbbbbbbbbb  "+permitModAdverParam) ;
		
		
		    RequestObject requestObject = RequestUtil.getReqInfo();
			String clientIp =requestObject!= null? requestObject.getRemoteAddr():"未查明";
			StringBuffer sb = new StringBuffer();
			
			boolean  updateOrderState = OrderLogUtil.comparaValue(sb,oldOrderDetail,curOrderDetail);

			String changeContent = sb.toString();
			Long   orderId = oldOrderDetail.getOrder().getId();
			
			if(changeContent!=null&&!changeContent.equals("")){

				Long   orderDetailId = oldOrderDetail.getId();
				Long   modifyBy = curOrderDetail.getModifyBy();
				Date   modifyDate = curOrderDetail.getModifyDate();
				if(modifyDate==null){
					 modifyBy = curOrderDetail.getCreateBy();
					 modifyDate = curOrderDetail.getCreateDate();
				}
				
				OrderLog orderLog= new OrderLog();
				orderLog.getLog().setClientIp(clientIp);
				orderLog.getLog().setModifyBy(modifyBy);
				orderLog.getLog().setModifyDate(new Date());
				orderLog.setOrderId(orderId);
				orderLog.setChangeContent(changeContent);
				orderLog.setOrderDetailId(orderDetailId);
				orderLogDao.saveOrderLog(orderLog); 
				
		       //如果修改订单明细 ,则修改订单state 4 退回
				if(curOrderDetail.getId() != null && !"hntv".equals(tvName)){
					this.saveOrderDetailCheckState(curOrderDetail.getId().toString(),"4");
				}


			
				
			}

			
//			System.out.println(">>>>>  aaaaaaaaaaaaaaaaaaaaaaa  changeContent"+changeContent) ;
//			System.out.println(">>>>>  aaaaaaaaaaaaaaaaaaaaaaa  updateOrderState"+updateOrderState) ;
	

				
				if(updateOrderState && !"hntv".equals(tvName)){

				   	List idList = new ArrayList();
				   	idList.add(orderId.toString());

			        if(idList.size() >0){
			    		String rs = "";
			    		String old_order_state = oldOrderDetail.getOrder().getIsCkecked().toString();
			    		
//			    		System.out.println(">>>>>  aaaaaaaaaaaaaaaaaaaaaaa  old_order_state >>>>>"+old_order_state) ;
			    		
			    		if("1".equals(old_order_state)||"2".equals(old_order_state)||"3".equals(old_order_state)){
			    			
			    			rs = oldOrderDetail.getOrder().getOrderState().getName();
			    			boolean isWithoutSubmit = SysParamUtil.getWithoutSubmitParam();
			    			Long checkStateIdnew = isWithoutSubmit?new Long(0):new Long(4);
			    			
				        	Map mp = new HashMap();
				    		mp.put("stateId",checkStateIdnew);	
				    		mp.put("OrderIdList",idList);
				    		orderDao.updateOrderStates(mp); 
				    		
				    		this.saveOrderDetailCheckState(oldOrderDetail.getId().toString(),checkStateIdnew.toString());
				    		
				    		
			    		
				    		Long checkUserId = curOrderDetail.getOrder().getModifyBy();
				    		Long checkStateIdOld =oldOrderDetail.getOrder().getIsCkecked();
				    		String defMsg ="【系统自动】由于修改订单信息,";
				    		
				    		OrderLogUtil.saveCheckRest(idList,checkUserId,checkStateIdOld,checkStateIdnew,defMsg);

				    		
				    		return "订单状态已改变从审核 {"+ rs +"}==>{未通过}";				    			
			    		}
			        } 
				}

			return "";
	}
	
	

	
	


	
	public void removeImportOrderByPublishMemo(String publishMemo)throws OrderDetailUnableSaveException{
		Map mp=new HashMap();
		mp.put("publishMemo",publishMemo);
		List ls= dao.getOrderDetailIdByPublishMemo(mp);

		for(Iterator it=ls.iterator();it.hasNext();){
			OrderDetail orderDetail = (OrderDetail)it.next();  
			
			List orderDayInfoIds = orderDayInfoDao.getOrderDayInfoId(orderDetail.getId());
			OrderDayInfo[] orderDayInfos = new OrderDayInfo[orderDayInfoIds.size()];
			
			int i =0;
			for(Iterator its=orderDayInfoIds.iterator();its.hasNext();){
				Long orderDayInfoId = (Long)its.next();
				OrderDayInfo orderDayInfo = new OrderDayInfo();
				orderDayInfo.setId(orderDayInfoId);
				orderDayInfo.setAdDayTimes(new Integer(0));
				
				//得到dayInfo的相关信息
				List dayInfoList = workspanManager.getResourceDayInfo(new Integer(publishMemo.substring(0,8)),orderDetail.getResourceInfoId());
				
				DayInfo dayInfo  = (DayInfo) dayInfoList.get(0);           

				dayInfo.setUsed(""+(int)(Double.parseDouble(dayInfo.getUsed())-Double.parseDouble(orderDetail.getMatterLength())*orderDetail.getSumTimes().intValue()));
                
				orderDayInfo.setDayInfo(dayInfo);
				orderDayInfos[i]=orderDayInfo;
				i++;
			}
			orderDetail.setOrderDayInfos(orderDayInfos);
			orderDetail.setParentId(new Long(0));
			orderDetail.setOrderCategoryMain("1"); 
			orderDetail.setIsNotInSeries(new Boolean(true));           
			this.removeOrderDetail(orderDetail);
		}
		
		dao.removeOrderByImport(publishMemo);                  
	}
	
	public Collection getIndustryTypeProductChannelCollections(final String queryString,String type) {
		
		String startDate = StringUtil.getParamFromUrl(queryString,"startDate");
		String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
		String isPrint = StringUtil.getParamFromUrl(queryString,"isPrint");
		String userId = StringUtil.getParamFromUrl(queryString,"userId");
		String carrierId = StringUtil.getParamFromUrl(queryString,"carrierId");
		String userName = StringUtil.getParamFromUrl(queryString,"userName");
		String channelModelParam = StringUtil.getParamFromUrl(queryString,"channelModelParam");
		int channelModel = Integer.parseInt(channelModelParam);
		String isDetail = StringUtil.getParamFromUrl(queryString,"isDetail");
		
		Map mp = getIndustryTypeProductByBeginAndEndDate2(channelModel,startDate,endDate,userId,carrierId,userName,isPrint);
		Map channelMp = new HashMap();
		List lst = this.getChannelRelIncome(channelModel,startDate,endDate,userId,carrierId,userName,isPrint);
		List channels = resourceChannelManager.getResourceChannels(new ResourceChannel());
		for (Iterator it = lst.iterator(); it.hasNext();) {
			CustomerProduct obj = (CustomerProduct) it.next();
			channelMp.put(obj.getIndustryType()+obj.getMatterName()+obj.getCarrierName(),obj.getRelIncome());
		}
    	
		return OrderDetailUtil.makePrintList(mp,channelMp,channels,isDetail,type);
	}
	
	public void saveImportOrderDetails(Long orderId,Long customerId,List orderDetailList){
		for(Iterator it=orderDetailList.iterator();it.hasNext();){
			OrderDetail orderDetail =(OrderDetail)it.next();
			orderDetail.setOrderId(orderId); 
			Matter mat = orderDetail.getMatter();
			if(mat.getTapeCode()==null){
				orderDetail.setIsNotInSeries(new Boolean(true));
				mat.setCustomerId(customerId); 
				orderDetail.setMatter(mat); 
			}else{
				orderDetail.setIsNotInSeries(new Boolean(false));
			}
			OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
			for(int i=0;i<orderDayInfos.length;i++){
				orderDayInfos[i].setOrderId(orderId);
			}
			orderDetail.setOrderDayInfos(orderDayInfos);           

			this.saveOrderDetailReturnObj(orderDetail);
		}
	}
	
	public String  saveOrderDetails(OrderDetail orderDetail){
		String returnStr = "";
		String returnStrOutTime = "";
		String returnStrSpec = "";
		String returnStrNoTotalTime = "";
		String returnStrSum = "";
		String id="";
		OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();

						
		String[] resourceIds = orderDetail.getCompages().getResourceIds();
	    String length = orderDetail.getMatterLength();
	    Long priceTypeId = orderDetail.getResourcePriceType();
//	    Long priceTypeIdDefault = orderDetail.getResourcePriceType();
	    String detailSpec = StringUtil.getNullValue(orderDetail.getSpecific().getPosition(),"");
	    String compagesId = StringUtil.getNullValue(orderDetail.getCompagesId(),"0");
	    boolean isAutoPrice = "0".equals(compagesId);
	    
//	    orderDetail.setIsPackeg(new Boolean("1"));
		OrderDetail[]  orderDetails = new OrderDetail[resourceIds.length];
	    
//	    System.out.println("orderDetail.getCompagesId()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +orderDetail.getCompagesId() );
//	    System.out.println("isPackage>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +isAutoPrice );
//	    System.out.println("getResourceSortId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +orderDetail.getResourceSortId() );
//	    System.out.println("getSysPrice>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +orderDetail.getSysPrice() );
//	    System.out.println("getExecPrice>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +orderDetail.getExecPrice() );
//	    System.out.println("get orderId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +orderDetail.getOrderId() );
//	    System.out.println("resourceIds.length>>>>>>>>>>>>>>>WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW >>>>>>>>>>>>>>>>>>" +resourceIds.length );

	    
	    orderDetail = saveMatterReturnObj(orderDetail, orderDetail.getCreateBy());
	                                
	    orderDetail.setCompagesId(new Long(0));        
//		orderDetail.setExecPrice(new Double(0));
//		orderDetail.setResourceSortId(new Long(1));
		orderDetail.setNeedPublish(new Integer(1));

		
		Map pushArrayMap = new HashMap();
		
		
		
		
		for(int j=0;j<orderDayInfos.length;j++){
			OrderDayInfo info = orderDayInfos[j];
//			OrderDayInfo info2 = new OrderDayInfo();
//			ConvertUtil.copyBeanProperties2(info2,info);
//			orderDayInfos2[j] = info2;
			Integer adDayTimes = info.getAdDayTimes();
			pushArrayMap.put(info.getPublishDate(),adDayTimes);
		}
		
		int times_sum=0;
		int timesThink_sum = 0;
		
		for(int i=0;i<resourceIds.length;i++){
    		Long resId = new Long(resourceIds[i]);
    		Resource resource = ResourceUtil.getResourceById(resId);
    		boolean isOutstripTimeLimit = resource.getIsClosed().booleanValue();
    		orderDetail.setId(null);  
    		
	     	Double sysPrice = new Double(0);
			try {
				sysPrice = getResourceSysPrice(resId,length,priceTypeId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		sysPrice = (sysPrice == null)? new Double(0):sysPrice;
    		orderDetail.setSysPrice(sysPrice);
    		
//      if(isAutoPrice){
//		        		orderDetail.setExecPrice(new Double(0)); 
//		        		      //正常订单
//		        		if(orderDetail.getOrderCategoryMain().equals("1") && sysPrice.intValue()>0){
//		        			double appRate=orderDetail.getAppRate().doubleValue();
//		        			double favourRate = orderDetail.getFavourRate().doubleValue();
//		        			favourRate = favourRate==0?1:favourRate;
//		        			orderDetail.setExecPrice(new Double(sysPrice.doubleValue()*(1+appRate)*favourRate));
//		        					}        	
//            	}
 
    		
    		
    		orderDetail.setResourceInfoId(resId);
    		
    		
    		
    		
    		
    		DayInfo resDayInfo = new DayInfo();
    		
    		resDayInfo.setResourceId(resId);          
    		resDayInfo.setStartDate(orderDetail.getPublishStartDate());
    		resDayInfo.setEndDate(orderDetail.getPublishEndDate());
    		resDayInfo.setVersion(orderDetail.getVersion());
    		
    		List resList = dayInfoDao.getDayInfos(resDayInfo);
    		
			Map mp =new HashMap();
			for(Iterator it=resList.iterator();it.hasNext();){
				DayInfo res=(DayInfo)it.next();
				mp.put(res.getPublishDate(),res);            
			}
			int times=0;
			int timesThink = 0;
			
//			ConvertUtil.copyBeanProperties3(orderDayInfos,orderDayInfos2);
			OrderDayInfo[] orderDayInfos2 = new OrderDayInfo[orderDayInfos.length];
    		for(int j=0;j<orderDayInfos.length;j++){
    			OrderDayInfo infoSource = orderDayInfos[j];
    			OrderDayInfo info = new OrderDayInfo();
    			ConvertUtil.copyBeanProperties2(info,infoSource);
    			
//    			DayInfo day = info.getDayInfo();
    			Integer   publishDate2 = info.getPublishDate();
    			
    			int adDayTimes = ((Integer)pushArrayMap.get(publishDate2)).intValue();
    			
//    			System.out.println("total>>>>>>>>>>>>>>>" + resource.getMemo() +">>>>>>>vvvvvv"+ publishDate2 +"vvvvvvvvvvvvvvvvvvv>>>" +info.getAdDayTimes() );	
    			
    			timesThink+=adDayTimes;

    			info.setNeedPublish(new Integer(1));
    			info.setAdDayTimes(new Integer(adDayTimes));
    			
    			if(adDayTimes > 0){
    				
    				DayInfo dayInfo =(DayInfo)mp.get(publishDate2);  
    				
    				if(dayInfo!=null){
    
    					String  publishDate = DateUtil.SetDateFormat(dayInfo.getPublishDate().toString(),"yyyy/MM/dd");
            			double used = Double.parseDouble(StringUtil.getNullValue(dayInfo.getUsed(),"0"))+Double.parseDouble(StringUtil.getNullValue(info.getAdlength(),"0"))*info.getAdDayTimes().intValue();
//            			int total = dayInfo.getResource().getDisplayNo().intValue()+Integer.parseInt(dayInfo.getTotal());
            			double total = Double.parseDouble(StringUtil.getNullValue(dayInfo.getTotal(),"0"));

            			times+=adDayTimes;

//            			 System.out.println("total>>>>>>>>>>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv>>>>>>>>>>>" +total );	
            			 
            			if(total == 0 ){
            				
            				returnStrNoTotalTime+= "【"+dayInfo.getResource().getMemo() + "  "+ publishDate +"  "+ adDayTimes +"次】\n\r<br/>";
            				
//            				 System.out.println("publishDate>>>>>>>>>>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv>>>>>>>>>>>" +returnStrNoTotalTime );	
            				 
            				times-=adDayTimes;
            				info.setAdDayTimes(new Integer(0));
            			}
            			
            			
            			String rsSpec = StringUtil.getNullValue(dayInfo.getSpecific(),"");
            			
            			if(!"".equals(rsSpec) && !"".equals(detailSpec)  && rsSpec.equals(detailSpec)){
//            				 System.out.println("rsSpec>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +rsSpec );	
            				returnStrSpec+="【"+dayInfo.getResource().getMemo() + "  "+ publishDate +"   "+ adDayTimes +"次】\n\r<br/>";
            				times-=adDayTimes;
            				info.setAdDayTimes(new Integer(0));
            			}
            			
            			dayInfo.setUsed(""+used);
//            			System.out.println(dayInfo.getUsed()+"=="+info.getAdlength()+"=="+used+"=="+info.getAdDayTimes().intValue());
            			info.setNeedPublish(new Integer(0));

            			if(used>total && total > 0){
//            				info.setAdDayTimes(new Integer(0));
            			
            				info.setNeedPublish(new Integer(1));
            				dayInfo.setUsed(dayInfo.getUsed());

            				if(isOutstripTimeLimit){
            					returnStrOutTime+="【"+dayInfo.getResource().getMemo()+" "+ publishDate +"  "+ adDayTimes +"次】\n\r<br/>";
            					times-=adDayTimes;
            					info.setAdDayTimes(new Integer(0));
            					
            				}else{
            					returnStr+="【"+dayInfo.getResource().getMemo()+"  "+ publishDate +"  标准时间:"+ total+"  超出:"+(used -total) +"】 \n\r<br/>";
            				}
            			}
            			
            			 info.setDayInfo(dayInfo);
            			 orderDayInfos2[j] = info;
            			 
            			
    				}  //if(dayInfo!=null)
    				
    				
    				
    			} //if(info.getAdDayTimes().intValue()>0){ 
    			
    		}//end for
           
//    		orderDetail.setOrderDayInfos(orderDayInfos2);

    		times_sum+=times;
    		timesThink_sum+=timesThink;
    		

    		
    		
//    		if(times==0) continue;			

    		if(orderDetail.getOrderCategoryMain().equals("1")){
        		orderDetail.setMoneyRealpay(new Double(orderDetail.getExecPrice().doubleValue()*times));
    		}
    		
//    		OrderDayInfo[] orderDayInfos3 = new OrderDayInfo[orderDayInfos.length];
//    		ConvertUtil.copyBeanProperties3(orderDayInfos3,orderDayInfos);

	 		   try {
				orderDetails[i] = (OrderDetail)org.apache.commons.beanutils.BeanUtils.cloneBean(orderDetail) ;
				orderDetails[i].setOrderDayInfos(orderDayInfos2);
				orderDetails[i].setIsCompages(new Boolean("true"));
	 			   
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
		}
		
		if(!"".equals(returnStr)) returnStr="<b>《有超时的段位,但可以保存》</b>\n\r <br/>" + returnStr+"<br/>"; 
		if(!"".equals(returnStrOutTime)) returnStrOutTime="<b>《因时段封签超时，未能保存的时间》</b>\n\r" +returnStrOutTime+"<br/>"; 
		if(!"".equals(returnStrSpec)) returnStrSpec="<b>《因指定冲突，未能保存的时间》</b>\n\r<br/>" +returnStrSpec+"<br/>"; 
		if(!"".equals(returnStrNoTotalTime)) returnStrNoTotalTime="《因没维护广告的总时间，而未能保存的时间》</b>\n\r<br/>" +returnStrNoTotalTime+"<br/>"; 
		
		if(times_sum != timesThink_sum) returnStrSum = "  总预定【" + timesThink_sum + "】次  落实【" + times_sum + "】次 少【" + (timesThink_sum - times_sum) + "】次\n\r<br/>";
		
		
		Double execPrice = new Double(0);
		if(!isAutoPrice){
			times_sum = times_sum == 0?1:times_sum;
		    execPrice = orderDetail.getExecPrice();
		}
	
  		double execPr = execPrice.doubleValue()/times_sum;
  		
//  		 System.out.println("execPr>>>tttttttttttttttttttttttttttttttt>>>>>>>>>>>"+ times_sum +">>>>>>>>>>>>>>>>>>>" +execPr );	

	
			   try {
				   			
						  	for(int j=0;j<orderDetails.length;j++){
						  		
						  		if(!isAutoPrice) {
							  		double sysPr = orderDetails[j].getSysPrice().doubleValue();
						     		if(orderDetail.getOrderCategoryMain().equals("1") && orderDetails[j].getSysPrice().doubleValue()>0){
					        			double favourRate=0;
					        			double appRate=0;
					        			
					        			if(execPr > sysPr){
					        				appRate = (execPr-sysPr)/sysPr;
					        				orderDetails[j].setAppRate(new Double(appRate));
					        				orderDetails[j].setFavourRate(new Double(0));
					        			}else{
					        				favourRate = 1-(sysPr-execPr)/sysPr;
					        				favourRate = sysPr == execPr?0:favourRate;
					        				orderDetails[j].setAppRate(new Double(0));
					        				orderDetails[j].setFavourRate(new Double(favourRate));
					        			}
					        			
//					        			 System.out.println("sysPr>>>tttttttttttttttttttttttttttttttt>>>>>>>>>>>>>>>>>>>>>>>" +sysPr );	
					        			orderDetails[j].setExecPrice(new Double(execPr));
					        		}else{
					        			orderDetails[j].setExecPrice(new Double(execPr));
					        		}
						  		}
					  		  id = this.saveOrderDetail(orderDetails[j]);
//					  		 boolean isPackeg =  Boolean.valueOf(StringUtil.getNullValue(orderDetail.getIsCompages(),"false")).booleanValue();
//					  		 System.out.println("saveOrderDetails>> id >>>>>>isPackeg>>>>>>>>>>>>>>>>>>>>>>>>>" +isPackeg );	
//					  		 System.out.println("saveOrderDetails>> id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +id );	
							}
					   }catch (Exception e) {
						   
						   System.out.println("saveOrderDetails>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +e.getMessage() );	
				        }	
		
		
		if(!"".equals(returnStr)||!"".equals(returnStrOutTime)||!"".equals(returnStrSpec)||!"".equals(returnStrNoTotalTime)||!"".equals(returnStrSum) ){
			id+="_"+returnStr+returnStrOutTime+returnStrSpec+returnStrNoTotalTime+returnStrSum;
		}else{
			id+="_"+" <b>您签订总次数为【"+ times_sum +"】次</b>";
		}

		return id;
	}
	public String getOrderDetailsAnalyze(OrderDetail orderDetail){
		StringBuffer sb=new StringBuffer();
		List ls= dao.getOrderDetailsAnalyze(orderDetail);
		
		double moneyRelPay=0;
		int sumTimes=0;
		int i=1;
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDetail obj = (OrderDetail) it.next();
			moneyRelPay+=Double.parseDouble(obj.getSpecific().getPosition());
			sumTimes+=Double.parseDouble(obj.getCompages().getName());
			
			sb.append("<row  id=\""+ obj.getId() +"\"" +"  style=\""+ "" +"\">");
			sb.append("<cell><![CDATA["+ i++  +"]]></cell>");	
		    sb.append("<cell><![CDATA["+ obj.getMatter().getTapeCode()  +"]]></cell>");	
		    sb.append("<cell><![CDATA["+ obj.getSpecific().getName()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getMatter().getName()+"["+obj.getMatter().getEdit()+"]]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getMatterLength()+"]]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getCarrier().getCarrierName()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getResource().getMemo()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getPublishStartDate()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getPublishEndDate()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getSpecific().getPosition()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ obj.getCompages().getName()  +"]]></cell>");
		    sb.append("</row>");
		}
		sb.append("<row  id=\""+ -1 +"\"" +"  style=\""+ "" +"\">");
	    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");	
	    sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
	    sb.append("<cell><![CDATA["+ ""+"]]]></cell>");
	    sb.append("<cell><![CDATA["+ ""+"]]]></cell>");
	    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
	    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
	    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
	    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
	    sb.append("<cell><![CDATA["+ moneyRelPay  +"]]></cell>");
	    sb.append("<cell><![CDATA["+ sumTimes  +"]]></cell>");
	    sb.append("</row>");            
		sb.append("</rows>");
		return sb.toString();
	}
	

	
	public String saveOrderDetailMMM(boolean isRes,OrderDetail orderDetail,OrderDetail[] orderDetails){
		
		System.out.println(" saveOrderDetailM isRes >>>>>>>>>>55555556666666666666677777777>>>>000000000000>>>>>>>>>>>>>>>>" +isRes);
		
		String orderDetailId = orderDetail.getId().toString();
		
		boolean updateOrderState = false;
		
		
		
//		log.info("orderDetailId>>>>>>>>>>>>>>000000000000>>>>>>>>>>>>>>>>" +orderDetailId);
		 
		 
		System.out.println("orderDetailId   0000000000        11111111111111111111111111111111>>>>>>>>>>>>>>"+orderDetailId);
		
		if("0".equals(orderDetailId)){
			
//			Map mpDayInfos = new HashMap();
			 Map newDayInfosMap = new HashMap();
			 Map orderDetailsBakMap = new HashMap();
			Long orderId = orderDetail.getOrderId();
			Long matterId = orderDetail.getMatterId();
			Long resourceInfoId = orderDetail.getResourceInfoId();
			String matterLength = orderDetail.getMatterLength();
			
			 Date now_date = new Date();
			 
//			Long orderId = orderDetail.getModifyBy()
			 
			 
//				log.info("orderDetails.length>>>>>>>>>>>1111111111111111>>>>>>>>>>>>>>>>>>>" +orderDetails.length);
			 
			 
			 
			 List idsList = new ArrayList();
			 
			if(orderDetails.length >0){

				
             
				for(int i = 0 ;i< orderDetails.length;i++){
					
					orderDetails[i].setCreateDate(now_date);
					orderDetails[i].setModifyDate(now_date);
					 
					idsList.add(orderDetails[i].getId().toString());
					orderDetailsBakMap.put(orderDetails[i].getId().toString(),orderDetails[i].getOrderDetailBak());
					
//					 log.info("ls_source.size>>>>>>>>>>>>>>>>getPublishStartDate>>>>>>>>>>>>>>>>>>" + orderDetails[i].getOrderDetailBak().getPublishStartDate());
//					 log.info("ls_source.size>>>>>>>>>>>>>>>>getPublishEndDate>>>>>>>>>>>>>>>>>>" + orderDetails[i].getOrderDetailBak().getPublishEndDate());
					 
				}
				
				Map mpcopy = new HashMap();
//				mpcopy.put("orderId",orderId);
				mpcopy.put("orderDetailIdList",idsList);

				List ls = dao.getOrderDetailByOrderIdCopy(mpcopy);
				
				 System.out.println("getOrderDetailByOrderIdCopy 11111111111111111111111111111111>>>>>>>>>>>>>>"+ ls.size());
				 
				 
				 
				DayInfo dayInfo = new DayInfo();
				
				
				
				for(Iterator it = ls.iterator();it.hasNext();){
					OrderDetail obj = (OrderDetail)it.next();
					
					obj.setCreateDate(now_date);
					obj.setModifyDate(now_date);
					
					Long orderDetail_id = obj.getId();
					Long resourceInfo_id = obj.getResourceInfoId();
					Long matter_id = obj.getMatterId();
//					Long resource_Info_id = obj.getResourceInfoId();
					String matter_length = obj.getMatterLength();
					Integer startDate_sour = obj.getPublishStartDate();
					Integer endDate_sour = obj.getPublishEndDate();
					Long order_id = obj.getOrderId();
					
					 OrderDetail orderDetailBak2 = new OrderDetail();
					 
					 ConvertUtil.copyBeanProperties2(orderDetailBak2,obj);
//					 log.info("orderDetail_id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetail_id);
					 
				
					if(idsList.contains(orderDetail_id.toString()) && (matter_id.longValue() != matterId.longValue()||resourceInfo_id.longValue() != resourceInfoId.longValue())){
						
						 Map mp = new HashMap();

						 double changeResInfo = Double.parseDouble(StringUtil.getNullValue(matterLength,"0"))-Double.parseDouble(StringUtil.getNullValue(matter_length,"0"));

						 mp.put("orderDetailId",orderDetail_id);
						 mp.put("startDate",startDate_sour);
						 mp.put("endDate",endDate_sour);
						 List ls_source = orderDayInfoDao.getRelIncomeByStartEndDate(mp);
						 int size_source_bak = ls_source.size();
						 List ls_targ = new ArrayList();
//						 log.info("ls_source.size>>>>>>>>>>>>>>>>orderDetail_id>>>>>>>>>>>>>>>>>>" + orderDetail_id);
//						 log.info("ls_source.size>>>>>>>>>>>>>>>>resourceInfo_id>>>>>>>>>>>>>>>>>>" + resourceInfo_id);
//						 log.info("ls_source.size>>>>>>>>>>>>>>>>startDate_sour>>>>>>>>>>>>>>>>>>" + startDate_sour);
//						 log.info("ls_source.size>>>>>>>>>>>>>>>>endDate_sour>>>>>>>>>>>>>>>>>>" + endDate_sour);
						 
//						 log.info("orderDetail>>>>>>>>>>>>>>getPublishStartDate>>>>>kkkk>>>>>>>>>>>>>" + orderDetail.getPublishStartDate());
//						 log.info("orderDetail>>>>>>>>>>>>>>getPublishEndDate>>>>>>>>kkk>>>>>>>>>>" + orderDetail.getPublishEndDate());
						 
						 OrderDayInfoUtil.getDayInfoFromListByDate(ls_source,ls_targ,orderDetail);
						 
			             
						 dayInfo.setResourceId(resourceInfo_id);
						 dayInfo.setStartDate(orderDetail.getPublishStartDate());
						 dayInfo.setEndDate(orderDetail.getPublishEndDate());
						 Map resMap1  = ResourceUtil.getDayInfosMap(dayInfo);
						 
						 Map resMap2  = new HashMap();
						 if(isRes){
							 dayInfo.setResourceId(resourceInfoId);
							 dayInfo.setStartDate(orderDetail.getPublishStartDate());
							 dayInfo.setEndDate(orderDetail.getPublishEndDate());
							 resMap2  = ResourceUtil.getDayInfosMap(dayInfo);	 
						 }

						 
						 

//						 log.info("ls_source.size>>>>>>>>>>>>>>>>2>>>>>>>>>>>>>>>>>>" + ls_source.size());
//						 log.info("ls_targ.size>>>>>>>>>>>>>>>>>>3>>>>>>>>>>>>>>>>" + ls_targ.size());
                         
						 //不在规定的时间区间，原来的版本不变，
						 if(ls_source.size() >0 ){
							 OrderDayInfoUtil.getNewOrderDetailByDayInfos(obj,ls_source,changeResInfo,resMap1,newDayInfosMap);
							 
//							 log.info("ls_source.size>>>>>>>>>obj>>>>>>>getPublishStartDate>>>>>>>>>>>>>>>>>>" + obj.getPublishStartDate());
//							 log.info("ls_source.size>>>>>>>>>>>obj>>>>>getPublishEndDate>>>>>>>>>>>>>>>>>>" + obj.getPublishEndDate());
							 
							 obj.setModifyDate(new Date());
//							 obj.setModifyBy()
							 
							  Long idd = obj.getId();
				    		  if (idd == null || idd.toString().equals("0")) {
				    			  String changeContent ="新添这条记录" +" , , "+ "\n\r";
				    	            OrderLogUtil.saveLog(obj, changeContent);
				    		  }						 
							 
							 Long detailId = dao.saveOrderDetail2(obj);
						
//							 log.info("lss.size>>>>>>>>>>>>>>>111111111111111>>>>>>>>>>>>>>>>>>" + obj.getId());
							 

							 
							 OrderDetail orderDetailBak = (OrderDetail)orderDetailsBakMap.get(detailId.toString());
//							 orderDetailBak.setId(detailId);
							 
							 
							 obj.setMemo(orderDetailBak.getMemo());

							 
//							 log.info("orderDetailBak>>>>>>>>>>>>>>>getPublishStartDate>>>>>>>>>>>>>>>>>>" + orderDetailBak.getPublishStartDate());
//							 log.info("orderDetailBak>>>>>>>>>>>>>>getPublishEndDate>>>>>>>>>>>>>>>>>>" + orderDetailBak.getPublishEndDate());
							 
					
							 
							 
							 updateOrderState = updateOrderState = OrderLogUtil.comparaValueForChangeEdit(updateOrderState,orderDetailBak,obj);
							 
//							 log.info("updateOrderState>>>>>>>>>>>>>>>111111111111111>>>>>>>>>>>>>>>>>>>" + updateOrderState);
						 }
						 
						 
						 
//						在规定的时间区间，需要变换的版本， 且时间范围与原来的时间范围一致
						 if(ls_targ.size() > 0 && ls_targ.size() == size_source_bak ){
							 
							 if(isRes){
								 double changeResInfo2 = -Double.parseDouble(StringUtil.getNullValue(matterLength,"0"));
								 double changeResInfo3 = Double.parseDouble(StringUtil.getNullValue(matter_length,"0"));

								 OrderDayInfoUtil.getNewOrderDetailByDayInfos(obj, ls_targ,changeResInfo2,resMap1,newDayInfosMap);
								 OrderDayInfoUtil.getNewOrderDetailByDayInfos(obj, ls_targ,changeResInfo3,resMap2,newDayInfosMap);
								 
								 obj.setResourceInfoId(resourceInfoId);
							 }else{
								 OrderDayInfoUtil.getNewOrderDetailByDayInfos(obj, ls_targ,changeResInfo,resMap1,newDayInfosMap);
								 obj.setMatterId(matterId);
								 obj.setMatterLength(matterLength); 
							 }
							 obj.setModifyDate(new Date());
//							 log.info("ls_targ.size>>>>>>>>>>>>>>>>>>>>getMatterId>>>>>>>>>>>>>>" + obj.getMatterId());
//							 log.info("ls_targ.size>>>>>>>>>>>>>>>>>>>>getId>>>>>>>>>>>>>>" + obj.getId());
							  Long idd = obj.getId();
				    		  if (idd == null || idd.toString().equals("0")) {
				    			  String changeContent ="新添这条记录" +" , , "+ "\n\r";
				    	            OrderLogUtil.saveLog(obj, changeContent);
				    		  }							 
							 
							 Long detailId = dao.saveOrderDetail2(obj);
							 obj.setMemo(orderDetail.getMemo());
							 
//							 log.info("lss.size>>>>>>>>>>>>>>>22222222222>>>>>>>>>>>>>>>>>>" );

							 
							 OrderDetail orderDetailBak = (OrderDetail)orderDetailsBakMap.get(detailId.toString());
//							 orderDetailBak.setId(detailId);
							 
//							 log.info("ls_source.size>>>>>>>>>>>>>>>>getPublishStartDate>>>>>>>>>>>>>>>>>>" + obj.getPublishStartDate());
//							 log.info("ls_source.size>>>>>>>>>>>>>>>>getPublishEndDate>>>>>>>>>>>>>>>>>>" + obj.getPublishEndDate());

							 updateOrderState = OrderLogUtil.comparaValueForChangeEdit(updateOrderState,orderDetailBak,obj);
							 
//							 log.info("updateOrderState2>>>>>>>>>>>>>>>2222222222>>>>>>>>>>>>>>>>>>>" + updateOrderState);
						 }
						 
						 
						 //在规定的时间区间，需要变换的版本， 时间范围与原来的时间范围不一致，不一致的部分需要新添订单明细
						 if(ls_targ.size() >0 && ls_targ.size() < size_source_bak ){
							 Long detailId = new Long(0);
//							 Date now_date = new Date();
							 if(isRes){
								 double changeResInfo2 = -Double.parseDouble(StringUtil.getNullValue(matterLength,"0"));
								 double changeResInfo3 = Double.parseDouble(StringUtil.getNullValue(matter_length,"0"));

								 OrderDayInfoUtil.getNewOrderDetailByDayInfos(obj, ls_targ,changeResInfo2,resMap1,newDayInfosMap);
								 OrderDayInfoUtil.getNewOrderDetailByDayInfos(obj, ls_targ,changeResInfo3,resMap2,newDayInfosMap);
								 
								 orderDetailBak2 = (OrderDetail)orderDetailsBakMap.get(obj.getId().toString());		 
								 obj.setId(null);
								 obj.setResourceInfoId(resourceInfoId);
//								 obj.setMatterId(matterId);
//								 obj.setMatterLength(matterLength);
								
								 obj.setCreateDate(now_date);
								 obj.setModifyDate(now_date);
								 
								  Long idd = obj.getId();
					    		  if (idd == null || idd.toString().equals("0")) {
					    			  String changeContent ="新添这条记录" +" , , "+ "\n\r";
					    	            OrderLogUtil.saveLog(obj, changeContent);
					    		  }					 
								 
								 detailId = dao.saveOrderDetail2(obj);
								 
								 obj.setId(detailId);
//								 obj.setMemo(orderDetail.getMemo());
								 obj.setPublishStartDate(obj.getPublishStartDate());
								 obj.setPublishEndDate(obj.getPublishEndDate());
								 orderDetailBak2.setId(detailId);	 
							 }else{
								 OrderDayInfoUtil.getNewOrderDetailByDayInfos(obj, ls_targ,changeResInfo,resMap1,newDayInfosMap);					 
								 orderDetailBak2 = (OrderDetail)orderDetailsBakMap.get(obj.getId().toString());		 
								 obj.setId(null);
								 obj.setMatterId(matterId);
								 obj.setMatterLength(matterLength);
								 obj.setCreateDate(now_date);
								 obj.setModifyDate(now_date);
								 
								  Long idd = obj.getId();
					    		  if (idd == null || idd.toString().equals("0")) {
					    			  String changeContent ="新添这条记录" +" , , "+ "\n\r";
					    	            OrderLogUtil.saveLog(obj, changeContent);
					    		  }							 
								 
								 detailId = dao.saveOrderDetail2(obj);
								 
								 obj.setId(detailId);
								 obj.setMemo(orderDetail.getMemo());
								 obj.setPublishStartDate(obj.getPublishStartDate());
								 obj.setPublishEndDate(obj.getPublishEndDate());
								 orderDetailBak2.setId(detailId);	 
							 }


							 
							 
//							 log.info("ls_source.size>>>>>>>>>>>>>>>>getPublishStartDate>>>>>>>>>>>>>>>>>>" + obj.getPublishStartDate());
//							 log.info("ls_source.size>>>>>>>>>>>>>>>>getPublishEndDate>>>>>>>>>>>>>>>>>>" + obj.getPublishEndDate());
						
							 updateOrderState = OrderLogUtil.comparaValueForChangeEdit(updateOrderState,orderDetailBak2,obj);
							 
					
							 
							 List lss = new ArrayList();
							 CollectionUtils.addAll(lss,ConvertUtil.getColFromList(ls_targ,"id"));
							 Map mp2 = new HashMap();
							 mp2.put("orderDetailId",detailId);
							 mp2.put("orderDayInfoIDS",lss);

							 orderDayInfoDao.saveDetailIdWithMaterChange(mp2);
						 }	 
						
					}
				}
				
				
				 //修改资源信息
				 if(newDayInfosMap.size()>0) {
//					 log.info("newDayInfosMap.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + newDayInfosMap.size());
					 ResourceUtil.updateDayInfos(newDayInfosMap);
//					 updateOrderState = true;
				 }		

//				 if(updateOrderState) updateOrderStates(orderDetail.getOrderDetailBak());
			}

		}else{
			
			System.out.println("Obj.getMatterId() aaaaaaaa>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetailId);
			
			if(orderDetails.length == 1){
				OrderDetail sourceObj = dao.getOrderDetail(new Long(orderDetailId));
				OrderDetail Obj = orderDetails[0];
				if(isRes){
					sourceObj.setResourceInfoId(Obj.getResourceInfoId());
				}else{
					
					System.out.println("Obj.getMatterId() 9999999999999999999>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + Obj.getMatterId());
					System.out.println("Obj.getMatterId() 9999999999999999999>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + Obj.getMatterLength());
					
					
					
					sourceObj.setMatterId(Obj.getMatterId());
					sourceObj.setMatterLength(Obj.getMatterLength());					
				}

				
				sourceObj.setModifyDate(new Date());
				
				Long idd = sourceObj.getId();
	    		  if (idd == null || idd.toString().equals("0")) {
	    			  String changeContent ="新添这条记录" +" , , "+ "\n\r";
	    	            OrderLogUtil.saveLog(sourceObj, changeContent);
	    		  }	
				
				dao.saveOrderDetail(sourceObj);
				
				
				System.out.println("Obj.getMatterId() 88888888889>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + Obj.getMatterId());
				
				 orderDetail.setPublishStartDate(sourceObj.getPublishStartDate());
				 orderDetail.setPublishEndDate(sourceObj.getPublishEndDate());
				 updateOrderState = OrderLogUtil.comparaValueForChangeEdit(updateOrderState,orderDetail.getOrderDetailBak(),orderDetail);
				
			}else{
				
				System.out.println("Obj.getMatterId() bbbbbbbbbbbbbbb>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetailId);
				
				saveOrderDetail_M_new(isRes,orderDetail,orderDetails,updateOrderState);
			}	
		}
		
//		 log.info("updateOrderState>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + updateOrderState);
		 
		 String rs = "";
		 
		 
		boolean permitModAdverParam = SysParamUtil.getPermitModAdverParam();
		 
		if(updateOrderState && !permitModAdverParam) rs = updateOrderStates(orderDetail.getOrderDetailBak());
		
		return rs;
		
	}
	
	
	public String  updateOrderStates(OrderDetail oldOrderDetail){
		    String rs = oldOrderDetail.getOrderState().getName();
			boolean isWithoutSubmit = SysParamUtil.getWithoutSubmitParam();
			Long checkStateIdnew = isWithoutSubmit?new Long(0):new Long(4);
			
		   	List idList = new ArrayList();
		   	idList.add(oldOrderDetail.getOrderId().toString());
		   	
			
	    	Map mp = new HashMap();
			mp.put("stateId",checkStateIdnew);	
			mp.put("OrderIdList",idList);
			
			OrderDao orderDao = ServiceLocator.getOrderDao();
			
			orderDao.updateOrderStates(mp); 
			
			this.saveOrderDetailCheckState(oldOrderDetail.getId().toString(),checkStateIdnew.toString());
			

			Long checkUserId = oldOrderDetail.getModifyBy();
			Long checkStateIdOld =oldOrderDetail.getIsCkecked();
			String defMsg ="【系统自动】由于广告换版操作,";
			
//			log.info("updateOrderState>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + checkStateIdnew);
			
			OrderLogUtil.saveCheckRest(idList,checkUserId,checkStateIdOld,checkStateIdnew,defMsg);

			return "订单状态已改变从审核 {"+ rs +"}==>{未通过}";			
	}

	
	private void saveOrderDetail_M_new(boolean isRes,OrderDetail orderDetail,OrderDetail[] orderDetails,boolean updateOrderState){
		String orderDetailId = orderDetail.getId().toString();
		OrderDetail sourceObj = dao.getOrderDetail(new Long(orderDetailId));
		
//		if(orderDetails.length == 1){
//			OrderDetail Obj = orderDetails[0];
//			sourceObj.setMatterId(Obj.getMatterId());
//			dao.saveOrderDetail(sourceObj);
//		}

		sourceObj.setPublishStartDate(sourceObj.getOrderPublic().getPublishStartDate());
		sourceObj.setPublishEndDate(sourceObj.getOrderPublic().getPublishEndDate());
		sourceObj.setMoneyRealpay(sourceObj.getOrderPublic().getMoneyRealpay());
		sourceObj.setSumTimes(sourceObj.getOrderPublic().getTimes());

//		if(log.isDebugEnabled()){   6560 5680  史老师
//			log.info("sourceObj.getNeedPublish()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +sourceObj.getNeedPublish());
//		}
		
//		int total_times = sourceObj.getSumTimes().intValue();
		double exec_price = sourceObj.getExecPrice().doubleValue();
		String matter_length = sourceObj.getMatterLength();
		Long resourceInfo_id = sourceObj.getResourceInfoId();
		
		Long resourceId = orderDetail.getResourceInfoId();
		
//		double balanceMoney = sourceObj.getMoneyBalance().doubleValue();
//		double balance_sum_temp = 0;
		double realPlay_sum_temp = 0;
		Map mp = new HashMap();
		Map newDayInfosMap = new HashMap();
		
		
		Map mpOderDetail = new HashMap();
		Map mpDayInfos = new HashMap();
		
		for(int i = 0 ; i<orderDetails.length;i++){
			 OrderDetail obj = orderDetails[i];
			 Integer startDate = obj.getPublishStartDate();
			 Integer endDate = obj.getPublishEndDate();
			 

			 
			 
             DayInfo dayInfo = new DayInfo();
			 dayInfo.setResourceId(resourceInfo_id);
			 dayInfo.setStartDate(startDate);
			 dayInfo.setEndDate(endDate);
			 Map resMap1  = ResourceUtil.getDayInfosMap(dayInfo);	
			 
			 int times = obj.getSumTimes().intValue();
			 String matterLength = obj.getMatterLength();
			 String new_edit = obj.getMemo();
			 
			 double changeResInfo = 0;
			 if(isRes){
				  changeResInfo = -Double.parseDouble(StringUtil.getNullValue(matterLength,"0"));
			 }else{
				  changeResInfo = Double.parseDouble(StringUtil.getNullValue(matterLength,"0"))-Double.parseDouble(StringUtil.getNullValue(matter_length,"0"));
			 }
			
			 boolean changeDayInfo = changeResInfo >0||changeResInfo<0;
			 
			 OrderDayInfo orderDayInfo = new OrderDayInfo();
			 orderDayInfo.setOrderDetailId(new Long(orderDetailId));

			 mp.put("orderDetailId",orderDetailId);
			 mp.put("startDate",startDate);
			 mp.put("endDate",endDate);
			 
			 double realPlay_sum =  0;
			 double moneyIn_sum =  0 ;
			 int times_sum =  0 ;
			
			 List ls2 = orderDayInfoDao.getRelIncomeByStartEndDate(mp);
			 List lsDinfoIDS = new ArrayList();
			 for(Iterator it = ls2.iterator();it.hasNext();){
				 OrderDayInfo dinfo = (OrderDayInfo)it.next();
				 realPlay_sum += dinfo.getDayRelIncome().doubleValue();
				 moneyIn_sum += dinfo.getDayRelPuton().doubleValue();
				 times_sum += dinfo.getAdDayTimes().intValue();
				 lsDinfoIDS.add(dinfo.getId());
				 if(changeDayInfo){
						String key = resourceInfo_id.toString() +","+dinfo.getPublishDate().toString();
						DayInfo day_info = (DayInfo)resMap1.get(key);	
					
						day_info.setChangedValue(new Double(changeResInfo*dinfo.getAdDayTimes().intValue()));
						newDayInfosMap.put(day_info.getId(),day_info);
				 }
				 
			 }
			 
			 if(isRes){
				 
	             DayInfo dayInfoPar = new DayInfo();
	             dayInfoPar.setResourceId(resourceId);
	             dayInfoPar.setStartDate(startDate);
	             dayInfoPar.setEndDate(endDate);
				 Map resMap2  = ResourceUtil.getDayInfosMap(dayInfoPar);
				 
				 double changeResInfo2 = Double.parseDouble(StringUtil.getNullValue(matter_length,"0"));
				 boolean changeResInfo8 = changeResInfo2 >0||changeResInfo2<0;
				 
				 OrderDayInfo orderDayInfo2 = new OrderDayInfo();
				 orderDayInfo2.setOrderDetailId(new Long(orderDetailId));

				 mp.put("orderDetailId",orderDetailId);
				 mp.put("startDate",startDate);
				 mp.put("endDate",endDate);
				 
			
				 List ls3 = orderDayInfoDao.getRelIncomeByStartEndDate(mp);
				 List lsDinfoIDS2 = new ArrayList();
				 for(Iterator it = ls3.iterator();it.hasNext();){
					 OrderDayInfo dinfo = (OrderDayInfo)it.next();
					 lsDinfoIDS2.add(dinfo.getId());
					 if(changeResInfo8){
							String key = resourceId.toString() +","+dinfo.getPublishDate().toString();
							DayInfo day_info = (DayInfo)resMap2.get(key);	
							day_info.setChangedValue(new Double(changeResInfo*dinfo.getAdDayTimes().intValue()));
							newDayInfosMap.put(day_info.getId(),day_info);
					 }
					 
				 }
				 
			 }
			 
			 
			 
				if(log.isDebugEnabled()){
					log.info("lsDinfoIDS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lsDinfoIDS.size());
				}

//			 double realPlay_sum = Double.valueOf(orderDayInfoDao.getRelIncomeByStartEndDate(mp)).doubleValue();
			 obj.setMoneyBalance(new Double(0));
			 if(exec_price > 0){
				 realPlay_sum_temp = realPlay_sum - exec_price * times;
				 if(realPlay_sum_temp >0) obj.setMoneyBalance(new Double(realPlay_sum_temp));
			 }
			 obj.setMoneyRealpay(new Double(realPlay_sum));
			 obj.setMoneyIn(new Double(moneyIn_sum));
			 obj.setSumTimes(new Integer(times_sum));

			 
				if(log.isDebugEnabled()){
					log.info("realPlay_sum>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+realPlay_sum);
				}
			 

			 /********************************************************************/
			 

			 OrderDetail tagObj = new OrderDetail();

	
			 
				if(log.isDebugEnabled()){
					log.info("copyBeanProperties2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>start"+sourceObj.toString());
				}
			 ConvertUtil.copyBeanProperties2(tagObj,sourceObj);
			 
			 
			 tagObj.setId(obj.getId());
			 tagObj.setMatterId(obj.getMatterId());
			 tagObj.setMatterLength(obj.getMatterLength());
			 tagObj.setPublishStartDate(obj.getPublishStartDate());
			 tagObj.setPublishEndDate(obj.getPublishEndDate());
			 tagObj.setSumTimes(obj.getSumTimes());
			 tagObj.setMoneyBalance(obj.getMoneyBalance());
			 tagObj.setMoneyRealpay(obj.getMoneyRealpay());
			 tagObj.setMoneyIn(obj.getMoneyIn());
			 tagObj.setTempString(new_edit);
			 tagObj.setModifyDate(new Date());
//			 tagObj.setResourceInfoId(resourceId);
			 tagObj.setResourceInfoId(obj.getResourceInfoId());
			 
			 
	          
			 String detail_id =StringUtil.getNullValue(obj.getId(),"0");
			 
             if(Long.parseLong(detail_id)> 0 && mpOderDetail.containsKey(sourceObj.getId().toString())){
            	 
            	 OrderDetail tag_obj = (OrderDetail)mpOderDetail.get(detail_id);
            	 
            	 Integer start_day = new Integer(Math.min(tag_obj.getPublishStartDate().intValue(),obj.getPublishStartDate().intValue()));
            	 Integer end_day = new Integer(Math.max(tag_obj.getPublishEndDate().intValue(),obj.getPublishEndDate().intValue()));
            	 
            	 tag_obj.setPublishStartDate(start_day);
            	 tag_obj.setPublishEndDate(end_day);
            	 tag_obj.setSumTimes(new Integer(tag_obj.getSumTimes().intValue()+obj.getSumTimes().intValue()));
            	 tag_obj.setMoneyBalance(new Double(tag_obj.getMoneyBalance().doubleValue()+obj.getMoneyBalance().doubleValue()));
            	 tag_obj.setMoneyRealpay(new Double(tag_obj.getMoneyRealpay().doubleValue()+obj.getMoneyRealpay().doubleValue()));
            	 tag_obj.setMoneyIn(new Double(tag_obj.getMoneyIn().doubleValue()+obj.getMoneyIn().doubleValue()));
            	 tag_obj.setModifyDate(new Date());
            	 
    			 List ls22 = (List)mpDayInfos.get(detail_id);
    			 ls22.addAll(lsDinfoIDS);
            	 
             }else{
            	 if(Long.parseLong(detail_id)> 0){
            		 mpOderDetail.put(detail_id,tagObj);
                	 mpDayInfos.put(detail_id,lsDinfoIDS);
            	 }else{
            		 String key ="new"+i;
            		 mpOderDetail.put(key,tagObj);
            		 mpDayInfos.put(key,lsDinfoIDS);
            	 }
             }
             

//				if(log.isDebugEnabled()){
//					log.info("copyBeanProperties2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>end"+tagObj.toString());
//				}

		}
		
		Iterator itt = mpOderDetail.keySet().iterator();
		
		while(itt.hasNext()){
			 String key = (String)itt.next();
			 OrderDetail tagObj =  (OrderDetail)mpOderDetail.get(key);
			 
//			 log.info("copyBeanProperties2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>end"+tagObj.toString()); sourceObj
			  Long idd = tagObj.getId();
    		  if (idd == null || idd.toString().equals("0")) {
    			  String changeContent ="新添这条记录" +" , , "+ "\n\r";
    	            OrderLogUtil.saveLog(tagObj, changeContent);
    		  }	
    		  
			 Long detailId = dao.saveOrderDetail2(tagObj);
			 tagObj.setMemo(tagObj.getTempString());
			 tagObj.setId(detailId);
			 orderDetail.getOrderDetailBak().setPublishStartDate(sourceObj.getPublishStartDate());
			 orderDetail.getOrderDetailBak().setPublishEndDate(sourceObj.getPublishEndDate());
			 OrderLogUtil.comparaValueForChangeEdit(updateOrderState,orderDetail.getOrderDetailBak(),tagObj);
			 
//			 if(log.isDebugEnabled()){
//					log.info("detailId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +detailId);
//			 }
			 
			 if(!orderDetailId.equals(detailId)){
				 Map mp2 = new HashMap();
				 List lss = (List)mpDayInfos.get(key);
				 if (lss.size() > 0){
					 mp2.put("orderDetailId",detailId);
					 mp2.put("orderDayInfoIDS",lss);
//					 log.info("lss.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +lss.size());
					 orderDayInfoDao.saveDetailIdWithMaterChange(mp2);
				 }

			 }	
		}
//		 log.info("newDayInfosMap.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + newDayInfosMap.size());
		
		 //修改资源信息
		 if(newDayInfosMap.size()>0) {
//			 log.info("newDayInfosMap.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + newDayInfosMap.size());
			 ResourceUtil.updateDayInfos(newDayInfosMap);
		 }			

	}

	
//    private IncomeDao incomeDao;
//    private IncomePullDao incomePullDao;
//    private IncomeUsedDao incomedUseDao;
    public Map buildsearchMap(String strQueryString){
    	String orgId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"orgId"));
    	String incomeId = StringUtil.getParamFromUrl(strQueryString,"incomeId");
//    	String customerName = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"customerName"));
    	String customerId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"customerId"));
    	
    	String userIds = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"userIds"));
    	
//    	String incomeMonthDay = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"incomeMonthDay"));
    	String startDay = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"startDay"));
    	String endDay = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"endDay"));
    	
    	String carriers = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"carriers"));
    	String channels = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"channels"));
    	
    	

    	String channelId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"channelId"));
    	String userId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"userId"));
    	String loginUser = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"loginUser"));
    	
    	
    	//    	String year = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"version"));

    	

    	
//    	log.info("customerName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + customerName);
//    	log.info("userIds>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + userIds);
 
    	
    	Map mp = new HashMap();
    	List yearIdList = new ArrayList();
    	List userIdList = new ArrayList();
    	List carrierIdList = new ArrayList();
    	List channelIdList = new ArrayList();
    	
		if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
     		
//     		log.info("UserUtil.getUserYearRelByLoginUser(loginUser)>>>>>>>>>>888888888888888888888>>>>>>>>>>>>>>>>>>>>>>>>" + UserUtil.getUserYearRelByLoginUser(loginUser));
	}
		
//		log.info("UserUtil.getUserYearRelByLoginUser(loginUser)>>>>>>>>>>888888888888888888888>>>>>>>>>>>>>>>>>>>>>>>>" + UserUtil.getUserYearRelByLoginUser(loginUser));
    	
    	
    	if(!"".equals(orgId)){
    		mp.put("orgId",orgId);
    	}
    	
    	if(!"".equals(startDay)){
    		mp.put("startDay",startDay);
    	}
    	
    	if(!"".equals(endDay)){
    		mp.put("endDay",endDay);
    	} 	
    	
    	
      	if(!"".equals(customerId) && !"0".equals(customerId)){
    		mp.put("customerId",customerId);
    	} 
      	
      	if(!"".equals(channelId) && !"0".equals(channelId)){
    		mp.put("channelId",channelId);
    	} 
      	
   if(!"".equals(userId) && !"0".equals(userId)){
    		mp.put("userId",userId);
    	} 
 	
    	
    	
    	
//    	if(!"".equals(incomeMonthDay)){
//    		mp.put("incomeMonthDay",incomeMonthDay);
//    	} 	
//    	
//    	if(!"".equals(customerName)){
//    		mp.put("customerName",customerName);
//    	}
    	
    	if(!"".equals(userIds)){
    		String[] uids = userIds.split(",");
//    		log.info("uids>>>>>>>>>>>>>>vvvvvvvvvvv>>>>>>>uids>>>>>>>>>>>>>" + uids);
    		org.apache.commons.collections.CollectionUtils.addAll(userIdList,uids);
//    		log.info("userIdList>>>>>>>>>>>>>>vvvvvvvvvvv>>>>>>>userIdList>>>>>>>>>>>>>" + userIdList);
    		mp.put("userIdList",userIdList);
    	}   	
    	if(!"".equals(carriers)){
    		String[] cars = carriers.split(",");
    		org.apache.commons.collections.CollectionUtils.addAll(carrierIdList,cars);
    		mp.put("carrierIdList",carrierIdList);
    	} 
    	
    	if(!"".equals(channels)){
    		String[] chas = channels.split(",");
    		org.apache.commons.collections.CollectionUtils.addAll(channelIdList,chas);
    		mp.put("channelIdList",channelIdList);
    	}    	
    	
    	
//    	log.info("customerId>>>>>>>>>>>>>>vvvvvvvvvvv>>>>>>>ccccccccccc>>>>>>>>>>>>>" + customerId);
//    	log.info("userId>>>>>>>>>>>>>>vvvvvvvvvvv>>>>>>>>ccccccccccc>>>>>>>>>>>>" + userId);
//    	log.info("channelId>>>>>>>>>>>>>>vvvvvvvvvvv>>>>>>>>ccccccccccc>>>>>>>>>>>>" + channelId);
    	
//    	if(!"".equals(year)){
//    		String[] years = year.split(",");
//    		org.apache.commons.collections.CollectionUtils.addAll(yearIdList,years);
//    		mp.put("yearIdList",yearIdList);
//    	}    	
    	
//    	mp.put("yearIdList",yearIdList);
//    	mp.put("userIdList",userIdList);
//    	mp.put("carrierIdList",carrierIdList);
//    	mp.put("customerName",customerName);
    	
//		Map searchMap = new HashMap(); 
		mp.put("incomeId",incomeId); 
    	
    	return mp;
    	
    }  
    
    public OrderDetail getCountSum(Map searchMap) {
    	OrderDetail orderDetail = dao.getMonthDetailByIncomeIdSumNew(searchMap);
    	return orderDetail;
    }
	public Collection getMonthDetailByIncomeId(Map searchMap,String type,int posStart,int count){
		Collection coll = new ArrayList();
//		searchMap,"1",posStart,count
//		List listPullIds = incomePullDao.getIncomePullIds(incomeId);
//		Map mp = new HashMap(); mp.put("pullIdList",listPullIds);
//		
//		List dayIds = incomedUseDao.getOrderDayInfoId(mp);
		
//		Map searchMap = new HashMap(); 
//		searchMap.put("incomeId",incomeId); 
		
		List list = dao.getMonthDetailByIncomeId(searchMap,posStart,count);
		
		CollectionUtils.addAll(coll,list.iterator());
		
		return coll;
	}
	

	
	public Collection getOrderDetailMonthTable(Map searchMap){
		Collection coll = new ArrayList();
		 long start1 = System.currentTimeMillis();
		List list = dao.getMonthDetailByIncomeInfo(searchMap);
		 long end2 = System.currentTimeMillis();
//		 System.out.println("getContractPaymentsByResource>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+ (end2 -start1) +"秒");
		CollectionUtils.addAll(coll,list.iterator());
		return coll;
	}	
	
	
	public String getOrderDetailMonthXml(String qstr) {
		StringBuffer sb = new StringBuffer();
		Map searchMap = buildsearchMap(qstr);
		List all = (List)getOrderDetailMonthTable(searchMap);
		String orgId = (String)searchMap.get("orgId");
		OrderDetailUtil.makeTreeGridMonthXML(sb,all,orgId);
		return sb.toString();
	}
	
	public Collection getCollectionsBroReport(String queryString, String type) {
		Collection coll = new ArrayList();
		
		
		
		
		Map mp = new HashMap();
		List carrierIdList =new ArrayList();
		List orderDetailIdList =new ArrayList();
		
		 System.out.println("getCollectionsBroReport>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 秒");
		 
		
		String orgId = StringUtil.getParamFromUrl(queryString,"orgId");
		String loginUser = StringUtil.getParamFromUrl(queryString,"loginUser");
		String carrierId = StringUtil.getParamFromUrl(queryString,"carrierId");
		String channelId = StringUtil.getParamFromUrl(queryString,"channelId");
		String startDate = StringUtil.getParamFromUrl(queryString,"startDate");
		String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
		String[] orderDetailIds = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"orderDetailIds")).split(",");
		boolean displayCustomer = Boolean.valueOf(StringUtil.getParamFromUrl(queryString,"displayCustomer")).booleanValue();
		boolean displayMoeny = Boolean.valueOf(StringUtil.getParamFromUrl(queryString,"displayMoeny")).booleanValue();
		boolean displayNoBro = Boolean.valueOf(StringUtil.getParamFromUrl(queryString,"displayNoBro")).booleanValue();
		
		
//		System.out.println("getCollectionsBroReport>>>>>>>>> orderDetailIds 0>>>>>>>>>>>>>>>>>>>>>> 秒"+StringUtil.getParamFromUrl(queryString,"orderDetailIds"));
		
//		System.out.println("getCollectionsBroReport>>>>>>>>> displayCustomer >>>>>>>>>>>>>>>>>>>>>> 秒"+displayCustomer);
//		System.out.println("getCollectionsBroReport>>>>>>>>> displayMoeny >>>>>>>>>>>>>>>>>>>>>> 秒"+displayMoeny);
//		System.out.println("getCollectionsBroReport>>>>>>>>> displayNoBro >>>>>>>>>>>>>>>>>>>>>> 秒"+displayNoBro);
//		System.out.println("getCollectionsBroReport>>>>>>>>> orderDetailIds 1 >>>>>>>>>>>>>>>>>>>>>> 秒"+StringUtil.getParamFromUrl(queryString,"orderDetailIds"));
//		System.out.println("getCollectionsBroReport>>>>>>>>> queryString 2>>>>>>>>>>>>>>>>>>>>>> 秒"+queryString);
//		System.out.println("getCollectionsBroReport>>>>>>>>> startDate >>>>>>>>>>>>>>>>>>>>>> 秒"+startDate);
//		System.out.println("getCollectionsBroReport>>>>>>>>> endDate >>>>>>>>>>>>>>>>>>>>>> 秒"+endDate);
//		System.out.println("getCollectionsBroReport>>>>>>>>> carrierId >>>>>>>>>>>>>>>>>>>>>> 秒"+carrierId);
		
		if("".equals(carrierId)){
			   carrierIdList = CarrierUtil.getCarrierIds(carrierId,"2",loginUser);
		}
		

//		System.out.println("getCollectionsBroReport>>>>>>>>> carrierIdList >>>>>>>>>>>>>>>>>>>>>> 秒"+carrierIdList);
//		System.out.println("getCollectionsBroReport>>>>>>>>> startDate >>>>>>>>>>>>>>>>>>>>>> 秒"+startDate);
//		System.out.println("getCollectionsBroReport>>>>>>>>> endDate >>>>>>>>>>>>>>>>>>>>>> 秒"+endDate);

		CollectionUtils.addAll(orderDetailIdList,orderDetailIds);
		
//		System.out.println("getCollectionsBroReport>>>>>>>>> orderDetailIdList >>>>>>>>>>>>>>>>>>>>>> 秒"+orderDetailIdList);
		
		mp.put("orderDetailIdList",orderDetailIdList);
		mp.put("carrierIdList",carrierIdList);
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		
		
//		GROUP BY  tb_order_detail.ad_resource_info_id,tb_order_detail.adver_matter_id 
		List ls = dao.getCollectionsBroReport(mp);
		
		System.out.println("getCollectionsBroReport>>>>>>>>> getCollectionsBroReport ls.size()>>>>>>>>>>>>>>>>>>>>>> 秒"+ls.size());
		

		for(Iterator it = ls.iterator();it.hasNext();){
				BroReport broReport =(BroReport)it.next();
				Long matterId = broReport.getMatterId();
				Long resourceId = broReport.getResourceId();
				
				mp.put("matterId",matterId);
				mp.put("resourceId",resourceId);
//				System.out.println("getCollectionsBroReport>>>>>>>>> getCollectionsBroReport matterId>>>>>>>>>>>>>>>>>>>>>> 秒"+matterId);
				
				List orderDayInfoIdList = dao.getCollectionsBroReport2(mp); 
				
//				System.out.println("getCollectionsBroReport>>>>>>>>>  orderDayInfoIdList.size()>>>>>>>>>>>>>>>>>>>>>> "+orderDayInfoIdList);
				
				Map mp2 = new HashMap();
				mp2.put("orderDayIdList",orderDayInfoIdList);
				mp2.put("publishDateStart",startDate);
				mp2.put("publishDateEnd",endDate);

		   List lsArray1 = ServiceLocator.getPublishArrangeDetailDao().getArrangedPublishForBroZM(mp2);
		   
		   System.out.println("getCollectionsBroReport>>>>>>>>> getArrangedPublishForWebService lsArray1.size()>>>>>>>>>>>>>>>>>>>> "+lsArray1.size());
		   
	    	Iterator it1 = lsArray1.iterator();
    	    
	    	StringBuffer sb = new StringBuffer();
	    	int i = 1;
	    	int realBroTime =0;
	    	while(it1.hasNext()){
			    	    	PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it1.next();
									Integer publishDate = publishArrangeDetail.getPublishArrange().getPublishDate();	
									Integer ctrBroTime = publishArrangeDetail.getCtrBroTime();
									String ctrBroTimeStr ="               ";
//									if(ctrBroTime == null) ctrBroTime = new Integer(0);
									
//									 System.out.println("getCollectionsBroReport>>>>>>>>> getArrangedPublishForWebService ctrBroTime>>>>>>>>>>>>>>>>>>>> "+ctrBroTime);
									
									 if(ctrBroTime != null){
										 ctrBroTimeStr = DateUtil.formatTime(Math.round(Double.parseDouble(ctrBroTime.intValue()*1000+"")),"h:m:s") + " (1次)";
										 realBroTime++;
									 }
									 
									 
//									 System.out.println("getCollectionsBroReport>>>>>>>>> getArrangedPublishForWebService displayNoBro>>>>>>>>>>>>>>>>>>>> "+displayNoBro);
									 if(displayNoBro && ctrBroTime == null){
									 
//										 System.out.println("getCollectionsBroReport>>>>>>>>> getArrangedPublishForWebService displayNoBro>>>>>>>>>>>>>>>>>>>> "+displayNoBro);
											
									}else{
										String weekStr = DateUtil.getWeekByStrDate(publishDate.toString(),"yyyyMMdd");
										sb.append(DateUtil.SetDateFormat(publishDate.toString(),"yyyy年MM月dd日"));
										sb.append("[");
										sb.append(weekStr);
										sb.append("]");
//										sb.append(" ");
										sb.append(ctrBroTimeStr); 
//										sb.append(" ");
//										sb.append("(1次)"); 
										sb.append("                     ");
										if(i%2 == 0){
											sb.append("\n\r");
										}
										i++;
									}
									

	    	  }	   
//	    	broReport.setRealTimes(lsArray1.size()+"");
	    	broReport.setRealTimes(realBroTime+"");
	    	broReport.setMemo(sb.toString());
	    	broReport.setBroDateStart(DateUtil.SetDateFormat(broReport.getBroDateStart(),"yyyy-MM-dd")+" ");
	    	broReport.setBroDateEnd(" "+DateUtil.SetDateFormat(broReport.getBroDateEnd(),"yyyy-MM-dd"));
	    	
//	    	System.out.println("getCollectionsBroReport>>>>>>>>>>>>>>>>>>>>>>>>>> "+sb.toString());
	    	
	    	if(!displayCustomer) broReport.setCustomerName("");
	    	if(!displayMoeny){
	    		broReport.setSumMoney("");
	    		broReport.setIncomeMoney("");
	    		}else{
	    			broReport.setSumMoney(StringUtil.doubleFormat4(new Double(broReport.getSumMoney())));
	    			broReport.setIncomeMoney(StringUtil.doubleFormat4(new Double(broReport.getIncomeMoney())));
	    		}
	
//	     	System.out.println("getCollectionsBroReport>>>>>>>>broReport.toString>>>>>>>>>>>>>>>>>> "+	broReport.toString());
	    
				
		 }
		
		
		
//		orderDetailIdList carrierIdList  channelId startDate endDate

//		String sql ="select id,carrider_name,bro_date,bro_start_time,adv_contents,bro_adv_length from tb_ctr_data where carrider_name='"+carrierName+"' and bro_date="+date;
//		ResultSet rs = ServiceLocator.getDao().getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
	
//		getSqlMapClientTemplate
		
		String customerName = "";
		String linkMan = "";
		String adName = "";
		String adEdit = "";
		String adLength = "";
		String pos = "";
		String posType = "";

		
		//从orderDayInfo 求合计
		String sumMoney = "";
		String incomeMoney = "";
		String orderTimes = "";
		String broDateStart = "";
		String broDateEnd = "";

		
		//从广告编排表里去查找广告时间
		String realTimes = "";
		String memo = "";
		
		
		CollectionUtils.addAll(coll,ls.iterator());
		
		return coll;
	}

	

	

	
	


}
