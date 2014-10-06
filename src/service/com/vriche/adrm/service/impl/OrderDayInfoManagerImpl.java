
package com.vriche.adrm.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CustomerAnalyzeColl;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.IncomeUsedManager;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.CustomerAnalyzeCollComparator2;
import com.vriche.adrm.util.CustomerProductComparator;
import com.vriche.adrm.util.CustomerProductUtil;
import com.vriche.adrm.util.CustomerUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.OrderDayInfoUtil;
import com.vriche.adrm.util.RequestUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class OrderDayInfoManagerImpl extends BaseManager implements OrderDayInfoManager {
    private OrderDayInfoDao dao;
    private UserManager userManager;
    private CarrierManager carrierManager;
    private ResourceManager resourceManager;
    private IncomeManager incomeManager;
    private IncomeUsedManager incomeUsedManager;
  
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOrderDayInfoDao(OrderDayInfoDao dao) {
        this.dao = dao;
    }

	public void setDao(OrderDayInfoDao dao) {
		this.dao = dao;
	}

	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

    public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setIncomeManager(IncomeManager incomeManager) {
		this.incomeManager = incomeManager;
	}    
    
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}
   
    
    
    
	/**
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#getOrderDayInfosByIdList(final Map idList)
     */
    public List getOrderDayInfosByIdList(final Map idList) {
        return dao.getOrderDayInfosByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#getOrderDayInfos(com.vriche.adrm.order.model.OrderDayInfo)
     */
    public List getOrderDayInfos(final OrderDayInfo orderDayInfo) {
        return dao.getOrderDayInfos(orderDayInfo);
    }
    
    
    public OrderDayInfo[] getOrderDayInfosArray(final OrderDayInfo orderDayInfo) {
    	List ls = dao.getOrderDayInfos(orderDayInfo);
    	

    	OrderDayInfo s[] = new OrderDayInfo[ls.size()];
        int i = 0;
    	for(Iterator it = ls.iterator();it.hasNext();){
    		OrderDayInfo od = (OrderDayInfo)it.next();
    		s[i++] = od;
//    		i= i+1;
    	}
    	
    	if(log.isDebugEnabled()){

    		System.out.println("getOrderDayInfosArray ls.size         "+ls.size());
    	}
        return s;
    }
    

    /**
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#getOrderDayInfo(String id)
     */
    public OrderDayInfo getOrderDayInfo(final String id) {
        return dao.getOrderDayInfo(new Long(id));
    }
    public List getOrderDayInfoId(final String orderDetailid){
    	return dao.getOrderDayInfoId(new Long(orderDetailid));
    }
    /**
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#saveOrderDayInfo(OrderDayInfo orderDayInfo)
     */
    public void saveOrderDayInfo(OrderDayInfo orderDayInfo) {
        dao.saveOrderDayInfo(orderDayInfo);
    }

    /**
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#removeOrderDayInfo(String id)
     */
    public void removeOrderDayInfo(final String id) {
        dao.removeOrderDayInfo(new Long(id));
    }

     /**
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#removeOrderDayInfos(String Map)
     */
    public void removeOrderDayInfos(final Map idList) {
        dao.removeOrderDayInfos(idList);
    }    
    
    
    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#getOrderDayInfos(com.vriche.adrm.order.model.OrderDetail)
     */
    public List getDayInfos(OrderDetail orderDetail) {
//        return dao.getDayInfos(orderDetail);
        return null;
    }
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#getOrderDayInfosMonth(com.vriche.adrm.order.model.OrderDetail)
     */
    public List getMonthInfos(OrderDetail orderDetail) {
//        return dao.getMonthInfos(orderDetail);
        return null;
    }
    
    
    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.OrderDayInfoManager#getMonthInfos(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public List getMonthInfosByParameter(String orderDetailId, String startDate,
            String endDate, String resourceId,String specific) {
//        return dao.getMonthInfos(orderDetailId,startDate,endDate,resourceId,specific);
    	return null;
    }


    
	public void saveOrderDayInfos(OrderDayInfo orderDayInfos[]) {
//		long start = System.currentTimeMillis();
		dao.saveOrderDayInfos(orderDayInfos);
//		long end = System.currentTimeMillis();
	}

//	private  boolean getFztvSpecialParam(){
//	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//	    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
//	    return (sysParam.getFztvSpecialParam().equals("1"))?true:false;
//	}  
	public List getOrderDayInfosPage(String orgId,String resourceTypeId,String startDate, String endDate,String sorCol,String sorType,String putYear,String userId,String carrierName,String customerId,int channelModelParam,String theUser,String incomPurs,String returnValue,String weekStr) {
		Map mp =new HashMap();
		Map mp2 =new HashMap();
		List userIdList = new ArrayList();
//		List carrierIdList = new ArrayList();
//		List carrierIdList2 = new ArrayList();
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		List incomePurposeIdList = new ArrayList();
		boolean isNotReturnValue = returnValue.equals("1")?true:false;
		String  tvName  = SysParamUtil.getTvNameParam();
		boolean fztv = SysParamUtil.isFZTVParam(tvName);
		boolean xmtv = SysParamUtil.isXMTVParam(tvName);
		boolean hntv = SysParamUtil.isHNTVParam(tvName);
		boolean isResourceSort = SysParamUtil.getWithResourceSort();
		boolean arrearagemode = SysParamUtil.getArrearageMode();
		
	  	Map incMap =  new HashMap();
    	Map inputonMap  =  new HashMap();
    	Map returnValueMap = new HashMap();
		List resourceIdList = new ArrayList();
		
		CollectionUtils.addAll(incomePurposeIdList,incomPurs.split(","));
		String sorStr = sorCol+","+sorType;
		
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("putYear",putYear);	
		
		if(financialAuditSwitch && incomePurposeIdList.size() == 0)incomePurposeIdList.add("-1");
		
		if(financialAuditSwitch){
			String version = startDate.substring(0,4);
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(version);
			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
			mp.put("OrderCategoryIdList",OrderCategoryIdList);
		}

		mp.put("incomePurposeIdList",incomePurposeIdList);
		
//		 System.out.println("日期 2：" + weekStr);
		
		if(!"".equals(weekStr)){
			List inWeekDates = new ArrayList();
			DateUtil.getWeekDates(startDate,endDate,weekStr,inWeekDates);
//			System.out.println("日期>>" + inWeekDates);
			mp.put("inWeekDates",inWeekDates);
		}
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
     	}
       
     	 System.out.println("carrierName33333333333333333333333333333333333333333333333333333333333333333333>>>>>>>>"+carrierName);
//     	System.out.println("theUser33333333333333333333333333333333333333333333333333333333333333333333>>>>>>>>"+theUser);
     	 
//		List carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
//		mp.put("carrierIdList",carrierIdList2);
		
		
		
		List carrierIdList2 = new ArrayList();
		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
		 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
			 carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
			 		mp.put("carrierIdList",carrierIdList2);	
		 }
	

//		Map mpp = org.apache.commons.collections.MapUtils.getMap(mp);

	
		if(!customerId.equals("")&&customerId!=null&&!customerId.equals("0")&&!customerId.equals("null")){
			 List  customerls = new ArrayList();
			 CollectionUtils.addAll(customerls, customerId.split(","));
			 mp.put("customerIdList",customerls);
		}else{
			List  customerls =   CustomerUtil.getCustomerIdsByOrg(theUser,orgId);
			if(customerls.size() == 0)customerls.add("-1");
    		mp.put("customerIdList",customerls);
		}

		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		CollectionUtils.addAll(userls, userId.split(","));
    		mp.put("UserIdList",userls);
    	}else{
    		userIdList = UserUtil.getCurUserRels(theUser,orgId);
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}
		
		
//		if(log.isDebugEnabled()){
//			System.out.println("carrierIdList>>>>>>>>>>>>>>"+carrierIdList.size()) ;
//			System.out.println("yearIdList>>>>>>>>>>>>>>"+yearIdList.size()) ;
//			 System.out.println("customerls>>>>>>>>>>>>>>"+customerls.size()) ;		
//		}

		if(isResourceSort){
			if(!"".equals(resourceTypeId) && !"0".equals(resourceTypeId))
				resourceIdList =  resourceManager.getResourceIdsBySortId(carrierIdList2,startDate,endDate,resourceTypeId);
			
			if(resourceIdList.size()>0) 
				mp.put("resourceIdList",resourceIdList);
		}
		
//		System.out.println("resourceTypeId>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+resourceTypeId) ;	
//		System.out.println("carrierIdList>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+carrierIdList2) ;	
//		System.out.println("resourceTypeId>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+resourceTypeId) ;	
//		System.out.println("resourceIdList>>>>yyyyyyyyyyyyyyyyyyyyyyyy>>>>>>>>>>"+resourceIdList) ;	
		
		
		inputonMap = incomeUsedManager.getPuton(mp);
		
		if(isNotReturnValue){
			returnValueMap = incomeUsedManager.getReturnValue(mp);
		}	
		

		List resu = new ArrayList();
		List resultList= dao.getCustomerRelIncome(mp);

//		List carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
//		mp.put("carrierIdList",carrierIdList);
		
		List carrierIdList = new ArrayList();
//		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
		 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
			 carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
			 		mp.put("carrierIdList",carrierIdList);	
		 }
		 
		 

		
		
		//判断是否业务员平帐
        if(getIsSignUserBalance()){
        	mp.put("version",new Integer(1));
        }else{
        	mp.put("version",new Integer(0));
        }
		

    	if(isResourceSort){
    		List resourceSortIdList = new ArrayList();
    
    		Map mpp = new HashMap();
    		
				mpp.putAll(mp);
				mpp.remove("carrierIdList");
				
				if(!"".equals(resourceTypeId)){
					 String[] types= resourceTypeId.split(",");
				     for (int i =0;i<types.length;i++){
				        	resourceSortIdList.add(types[i]);
				      }
				}

				if(resourceSortIdList.size()>0) mpp.put("resourceSortIdList",resourceSortIdList);

				incMap = incomeManager.getIncome3(mpp);     

//				StringUtilsv.printMap(mpp);

    	}else{
    		Map mpp = new HashMap();
    		mpp.putAll(mp);
    		if("0".equals(carrierName)){
    			mpp.remove("carrierIdList");
    		}
			
    		
            incMap = incomeManager.getIncome3(mpp);

    	}
        
//    	StringUtilsv.printMap(mp);
    	
    

		
//		Map putonMap = incomeUsedManager.getPuton(mp);
		
//		System.out.println("startDate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+startDate);  
//		System.out.println("endDate>>>>>>>>>>>>>>>>>>>>>"+endDate) ;
//		System.out.println("putYear>>>>>>>>>>>>>>>>>>>>>"+putYear) ;
//		System.out.println("carrierIdList>>>>>>>>>>>>>>>>>>>>>"+carrierIdList2) ;
//		System.out.println("userIdList>>>>>>>>>>>>>>>>>>>>>"+userIdList) ;
//		System.out.println("customerId>>>>>>>>>>>>>>>>>>>>>"+customerId) ;
//		System.out.println("incomePurposeIdList>>>>>>>>>>>>>>>>>>>>>"+incomePurposeIdList) ;
		System.out.println("incMap>>>>>>>>>>>>>>>>>>>>>"+incMap.size()) ;
//		System.out.println("incMap>>>>>>>>>>>>>>>>>>>>>"+returnValueMap.size()) ;
//		System.out.println("inputonMap>>>>>>>>>>>>>>>>>>>>>"+inputonMap.size()) ;
		
		double result[]=new double[6];
       
	
		for(Iterator it=resultList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			CustomerAnalyzeColl customerColl = new CustomerAnalyzeColl();
			
			String cutName = orderDayInfo.getCustomer().getCustomerName();
//			System.out.println("incMap>>>cutName>>>>>>>>>>>>>>>>>>"+cutName) ;
			
			Object obj = incMap.get(cutName);
			Object objputon = inputonMap.get(cutName);
			Object objreturnValue = null;
			incMap.remove(cutName);
			inputonMap.remove(cutName);
//			returnValueMap.remove(cutName);
			
			if(isNotReturnValue){
				objreturnValue = returnValueMap.get(cutName);
				returnValueMap.remove(cutName);
			}
			
			Double incMoney =(obj == null)?new Double(0):(Double)obj;
			Double realIncom = orderDayInfo.getDayRelIncome() == null?new Double(0):orderDayInfo.getDayRelIncome();
			Double standardPrice = orderDayInfo.getDayStandardPrice() == null?new Double(0):orderDayInfo.getDayStandardPrice();
			
			
			Double relPuton =(objputon == null)?new Double(0):(Double)objputon;
			Double returnValue1 =(objreturnValue == null)?new Double(0):(Double)objreturnValue;
			if(isNotReturnValue && returnValue1.doubleValue()>0){
				realIncom = new Double(realIncom.doubleValue()-returnValue1.doubleValue()); 
				relPuton = new Double(relPuton.doubleValue()-returnValue1.doubleValue()); 
			}
//			Double relPuton = orderDayInfo.getDayRelPuton() == null?new Double(0):orderDayInfo.getDayRelPuton();	
//            double payMoney = realIncom.doubleValue()-relPuton.doubleValue();
			double payMoney =0; 
//			boolean arrearagemode = getArrearageMode();
			if(arrearagemode){
				payMoney = realIncom.doubleValue()-incMoney.doubleValue();
				
//				if((incMoney.doubleValue()==0 && relPuton.doubleValue()>0) ||(relPuton.doubleValue()>incMoney.doubleValue())){
//					payMoney = realIncom.doubleValue()-relPuton.doubleValue();
//				}
			}else{
				payMoney = realIncom.doubleValue()-relPuton.doubleValue();
			}		
			
//			if(payMoney<0) payMoney = 0;
			
			
			

			customerColl.setSortStr(sorStr);
			customerColl.setCustomerName(cutName);
			customerColl.setCustomerIncome(incMoney.toString());//到帐
			customerColl.setDayStandardPrice(standardPrice.toString());
			customerColl.setDayRelIncome(realIncom.toString());//投放
			customerColl.setDayRelPuton(relPuton.toString());//分配
			customerColl.setDayPayMoney(String.valueOf(payMoney));//欠款
			customerColl.setAdSumTimes(orderDayInfo.getAdSumTimes().toString());

//			result[0]+=orderDayInfo.getDayRelPuton().doubleValue();
			result[0]+= relPuton.doubleValue();
			result[1]+= realIncom.doubleValue();
			result[2]+= orderDayInfo.getAdSumTimes().doubleValue();
			result[3]+= incMoney.doubleValue();
			result[4]+= payMoney;
			result[5]+= standardPrice.doubleValue();
			resu.add(customerColl);
		}
		
		
		
		
		double payMoney =0; 

		
		System.out.println("incMoney>>>>>>>>>>>KKKKKKKKKKKKKKKKKKKKKKKK YYYYYYYYYYYYYYYYYYYYYYY>>>>>>>>>>"+incMap.size());
		
		for(Iterator it = incMap.keySet().iterator();it.hasNext();){
			CustomerAnalyzeColl customerColl = new CustomerAnalyzeColl();
			String cutName = (String) it.next();
			customerColl.setCustomerName(cutName);
			Object obj = incMap.get(cutName);
			Object objputon = inputonMap.get(cutName);
			Double incMoney =(obj == null)?new Double(0):(Double)obj;
			Double relPuton =(objputon == null)?new Double(0):(Double)objputon;
			result[3]+=incMoney.doubleValue();
			result[0]+=relPuton.doubleValue();
			
			System.out.println("incMoney>>>>>>>>>>>KKKKKKKKKKKKKKKKKKKKKKKK YYYYYYYYYYYYYYYYYYYYYYY>>>>>>>>>>"+incMoney.doubleValue()) ;	
			
		
			if(!arrearagemode){
				payMoney = -incMoney.doubleValue();
			}else{
				payMoney = 0;
			}	
			
//			System.out.println("incMoney>>>>>>>>>>>KKKKKKKKKKKKKKKKKKKKKKKK YYYYYYYYYYYYYYYYYYYYYYY>>>>>>>>>>"+payMoney) ;	
			
			customerColl.setSortStr(sorStr);
			customerColl.setCustomerIncome(incMoney.toString());
			customerColl.setDayRelPuton(relPuton.toString());
//			customerColl.setDayRelPuton("0");
			customerColl.setDayStandardPrice("0");
			customerColl.setDayRelIncome("0");
			customerColl.setAdSumTimes("0");
			customerColl.setDayPayMoney(String.valueOf(payMoney));
			resu.add(customerColl);
		}
		
		
		
		
		
//		 Collections.sort(resu,new CustomerAnalyzeCollComparator());
		
		
		
		 if(resu.size() >0){
				CustomerAnalyzeColl totalAnalyzeColl =new CustomerAnalyzeColl();
				totalAnalyzeColl.setSortStr("0,ASC");
				totalAnalyzeColl.setCustomerName("合计:");
				totalAnalyzeColl.setDayRelPuton(new Double(result[0]).toString());
				totalAnalyzeColl.setDayRelIncome(new Double(result[1]).toString());
				totalAnalyzeColl.setAdSumTimes(new Double(result[2]).toString());
				totalAnalyzeColl.setCustomerIncome(new Double(result[3]).toString());
				totalAnalyzeColl.setDayPayMoney(new Double(result[4]).toString());
				totalAnalyzeColl.setDayStandardPrice(new Double(result[5]).toString());
				resu.add(totalAnalyzeColl); 
		 }

		return resu;	
	}
	
	public Collection getOrderDayInfosReport(String orgId,String resourceTypeId,String startDate, String endDate,String sorCol,String sorType,String putYear,String userId,String carrierName,String curUserName,String customerId,String channelModeId,String theUser,String incomPurs,String returnValue) {
		Collection coll = new ArrayList();
//		if(customerId == null||customerId.equals("")) customerId="0";
		String weekStr="";
		
//		 System.out.println("日期 2：" + weekStr);
		 
		List ls = this.getOrderDayInfosPage(orgId,resourceTypeId,startDate,endDate,sorCol,sorType,putYear,StringUtil.null2String(userId),carrierName,customerId,Integer.parseInt(channelModeId),curUserName,incomPurs,returnValue,weekStr);
		
	
		CollectionUtils.addAll(coll,ls.iterator());
		return coll;
	}
	public Collection getCollections(Map searchMap,String type){
		Collection coll = new ArrayList();
//		Map mp = new HashMap();
	   
		String startDate = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("startDate")));
		String endDate=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("endDate")));
		String userIdCus = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("userIdForm")));
		String carrierName=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("carrierName")));
	
		String userName=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("userName")));
		String customerId = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("customerId")));
		String channelModeId=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("channelModeId")));
		String theUser = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("nowUser")));
		String[] sorStr=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("sortStr"))).split(",");
		String putYear = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("putYear")));
		String incomPurs = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("incomPurs")));
		String returnValue = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("returnValue")));
		String resourceTypeId = StringUtil.getURLDecoderStr(StringUtil.getNullValue(searchMap.get("resourceTypeId"),""));
		String orgId = StringUtil.getURLDecoderStr(StringUtil.getNullValue(searchMap.get("orgId"),"1"));
		
		String weekStr = StringUtil.getURLDecoderStr(StringUtil.getNullValue(searchMap.get("weekStr"),""));
		
//		 System.out.println("日期 2：" + weekStr);
		
		List ls = this.getOrderDayInfosPage(orgId,resourceTypeId,startDate,endDate,sorStr[0],sorStr[1],putYear,userIdCus,carrierName,customerId,Integer.parseInt(channelModeId),theUser,incomPurs,returnValue,weekStr);
		
		List valuecoll = new ArrayList();
		
		
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		boolean isDisplayStandPrice = sysParam.getIsDisplayStandPrice() == null||(sysParam.getIsDisplayStandPrice().equals("0"))?false:true;
		if(isDisplayStandPrice){
			int cols = 7;

			for(Iterator it = ls.iterator();it.hasNext();){

				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
				Double standPrice = customerColl.getDayStandardPrice() == null?new Double(0):new Double(customerColl.getDayStandardPrice());
				Double realIncom = customerColl.getDayRelIncome() == null?new Double(0):new Double(customerColl.getDayRelIncome());
				Double RelPuton = customerColl.getDayRelPuton() == null?new Double(0):new Double(customerColl.getDayRelPuton());

				
				FusionChartObject fObject = new FusionChartObject();
				if(type.equals("report")){
					for(int i=0;i<cols+1;i++){
						switch(i){
							case 1:
								fObject.setLable(customerColl.getCustomerName());break;
							case 2:
								fObject.setValue1(StringUtil.doubleFormat3(customerColl.getCustomerIncome()) );break;
							case 3:
								fObject.setValue2(StringUtil.doubleFormat2(standPrice));break;
							case 4:
								fObject.setValue3(StringUtil.doubleFormat2(realIncom));break;
							case 5:
								fObject.setValue4(StringUtil.doubleFormat2(RelPuton));break;
							case 6:
								fObject.setValue5(StringUtil.doubleFormat2(new Double(customerColl.getDayPayMoney())));break;
							case 7:
								fObject.setValue6(StringUtil.doubleFormat3(customerColl.getAdSumTimes()));break;
							default :
						}
					}
				}
				valuecoll.add(fObject);
			}
		}else{
			int cols = 6;

			for(Iterator it = ls.iterator();it.hasNext();){

				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
//				Double standPrice = customerColl.getDayStandardPrice() == null?new Double(0):new Double(customerColl.getDayStandardPrice());
				Double realIncom = customerColl.getDayRelIncome() == null?new Double(0):new Double(customerColl.getDayRelIncome());
				Double RelPuton = customerColl.getDayRelPuton() == null?new Double(0):new Double(customerColl.getDayRelPuton());

				
				FusionChartObject fObject = new FusionChartObject();
				if(type.equals("report")){
					for(int i=0;i<cols+1;i++){
						switch(i){
							case 1:
								fObject.setLable(customerColl.getCustomerName());break;
							case 2:
								fObject.setValue1(StringUtil.doubleFormat3(customerColl.getCustomerIncome()) );break;
							case 3:
								fObject.setValue2(StringUtil.doubleFormat2(realIncom));break;
							case 4:
								fObject.setValue3(StringUtil.doubleFormat2(RelPuton));break;
							case 5:
								fObject.setValue4(StringUtil.doubleFormat2(new Double(customerColl.getDayPayMoney())));break;
							case 6:
								fObject.setValue5(StringUtil.doubleFormat3(customerColl.getAdSumTimes()));break;
								
							default :
						}
					}
				}
				valuecoll.add(fObject);
			}
		}

		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;
	}
	
	public Collection getBusinessInfosForReport(String orgId,String startDate, String endDate,String type,String sorStr,String userId,String carrierName,String curUserName,boolean isPutOnORIncome,String channelModel,String isPutYear,String returnValue,String incomPurs) {
		Collection coll = new ArrayList();
		List ls = getBusinessInfos(orgId,startDate, endDate, type, sorStr,curUserName,userId,carrierName,isPutOnORIncome,Integer.parseInt(channelModel),isPutYear,returnValue,incomPurs);
		CollectionUtils.addAll(coll,ls.iterator());
		return coll;
	}
	
	public String getOrderDayInfoCount(String startDate ,String endDate) {
		Map mp =new HashMap();
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		
		Integer rows =  dao.getOrderDayInfoCount(mp);
		rows = (rows == null) ? new Integer(0):rows;
		return rows.toString();
	}
	
	
	public String getBusinessCount(String startDate, String endDate,String userId,String carrierName,int channelModelParam) {
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		Map mp = new HashMap();
		Map businessMap = new HashMap();
		mp.put("startDate", startDate);
		mp.put("endDate", endDate);
//		mp.put("parentId",carrierName);
		

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;

		if(channelModelParam==1) channelPull = true;
			
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,null);
		if(carrierIdList.size() == 0)carrierIdList.add("-1");
		mp.put("carrierIdList",carrierIdList);

		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
    		List ls = userManager.getOwnerUsersList(userRelsMap);
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}
		List list = dao.getBusinessPage(mp);

		for (Iterator it = list.iterator(); it.hasNext();) {
			Map map = null;
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			String businessName = (orderDayInfo.getBusinessFirstName().trim() + orderDayInfo.getBusinessLastName().trim());
			int month = Integer.parseInt(orderDayInfo.getPublishDate().toString().substring(4, 6));

			if (businessMap.containsKey(businessName)) {
				Map map1 = (Map) businessMap.get(businessName);
				map1.put(new Integer(month), orderDayInfo);
				for (int i = 1; i < 13; i++) {
					if (map1.get(new Integer(i)) == null) {
						map1.put(new Integer(i), null);
					}
				}

				businessMap.put(businessName, map1);
			} else {
				map = new HashMap();
				map.put(new Integer(month), orderDayInfo);
				for (int i = 1; i < 13; i++) {

					if (map.get(new Integer(i)) == null) {
						map.put(new Integer(i), null);
					}
				}
				businessMap.put(businessName, map);
			}
		}
		return (new Integer(businessMap.size() + 1)).toString();
	}
	public List getCustomerByYearPage(String orgId,String resourceTypeId,String type,String sortStr,String putYear,String year, String[] customerIds,String userId,String carrierName,int channelModelParam,String theUser,String incomPurs,String returnValue) {
		
		List userIdList = new ArrayList();
//		List carrierIdList = new ArrayList();
		Map mp = new HashMap();
//		Map mp2 = new HashMap();
		Map map = new HashMap();
		List monthList = new ArrayList();
		List customerIdList = new ArrayList();
		List incomePurposeIdList = new ArrayList();
		List resourceIdList = new ArrayList();
		
		
		Map returnValueMap = new HashMap();
		Map incMap = new HashMap();
		Map inputonMap =new HashMap();
		
		boolean isResourceSort = SysParamUtil.getWithResourceSort();
		
		boolean arrearagemode = SysParamUtil.getArrearageMode();

		//判断是否返点
		boolean isNotReturnValue = returnValue.equals("1")?true:false;
		
		resourceTypeId = StringUtil.getNullValue(resourceTypeId,"");
		
//		System.out.println(">>>>>  1  "+userId+"   "+carrierName) ;
//		CollectionUtils.addAll(customerIdList, customerIds);
		CollectionUtils.addAll(incomePurposeIdList,incomPurs.split(","));
		
		map.put("year", year);
//		map.put("CustomerIdList", customerIdList);
		map.put("putYear",putYear);
		
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		
		if(financialAuditSwitch && incomePurposeIdList.size() == 0)incomePurposeIdList.add("-1");             
		
		if(financialAuditSwitch){
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(year);
			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
			mp.put("OrderCategoryIdList",OrderCategoryIdList);
		}

		mp.put("incomePurposeIdList",incomePurposeIdList);		

//		map.put("incomePurposeIdList",incomePurposeIdList);
		
		
		if(customerIds.length > 0){
			 List  customerls = new ArrayList();
			 CollectionUtils.addAll(customerIdList, customerIds);
			 map.put("customerIdList",customerls);
		}else{
			List  customerls =   CustomerUtil.getCustomerIdsByOrg(theUser,orgId);
			if(customerls.size() == 0)customerls.add("-1");
			map.put("customerIdList",customerls);
		}

     	if(UserUtil.isUserOrderYearRel()) {
     		map.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
     	}

		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		CollectionUtils.addAll(userls, userId.split(","));
    		map.put("UserIdList",userls);
    	}else{
    		userIdList = UserUtil.getCurUserRels(theUser,orgId);
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
//    		System.out.println("UserUtil.getCurUserRels>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userIdList);    		
    		
    		
    	}	

		
		
//		List carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
//		map.put("carrierIdList",carrierIdList2);
		
		
		List carrierIdList2 = new ArrayList();
		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
		 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
			 carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
			 		mp.put("carrierIdList",carrierIdList2);	
		 }
		
		
//		List carrierIdList2 = new ArrayList();
//		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
//	 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
//		 		 carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
//		 		map.put("carrierIdList",carrierIdList2);	
//	  }
		

		if(isResourceSort){
			if(!"".equals(resourceTypeId) && !"0".equals(resourceTypeId))
				resourceIdList =  resourceManager.getResourceIdsBySortId(carrierIdList2,Integer.parseInt(year),Integer.parseInt(year),resourceTypeId);
			
			if(resourceIdList.size()>0) 
				map.put("resourceIdList",resourceIdList);
		}		
		
		
		
//		StringUtilsv.printMap(map);
		
		List ls = dao.getCustomerByYearPage(map);
		
//		System.out.println("orderDayInfo.getCustomerByYearPage() size <<<<<<<<<<<<<<<<<<"+ls.size());		
		
		
		inputonMap = incomeUsedManager.getPutonYear(map);
		 
		if(isNotReturnValue){
			returnValueMap = incomeUsedManager.getReturnValue2(map);
		}		
		
		


//		List carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
//		map.put("carrierIdList",carrierIdList);
		
		List carrierIdList = new ArrayList();
//		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
	 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
		 carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
		 		map.put("carrierIdList",carrierIdList);	
	  }		
		
		
//		Map incMap = incomeManager.getIncome12Month(map);
		
		
		
		//判断是否业务员平帐
        if(getIsSignUserBalance()){
        	map.put("version",new Integer(1));
        }else{
        	map.put("version",new Integer(0));
        }		
        
//        if("0".equals(putYear)){
//        	mp.put("groupBy"," substring(inc.income_date,5,2)");
//        }else{
//        	mp.put("groupBy"," substring(inc.income_pull_date,5,2)");
//        }
    	
        
        
		
    	if(isResourceSort){
    		List resourceSortIdList = new ArrayList();
    
    		Map mpp = new HashMap();
    		
				mpp.putAll(map);
				mpp.remove("carrierIdList");
				
				if(!"".equals(resourceTypeId)){
					 String[] types= resourceTypeId.split(",");
				     for (int i =0;i<types.length;i++){
				        	resourceSortIdList.add(types[i]);
				      }
				}

				if(resourceSortIdList.size()>0) mpp.put("resourceSortIdList",resourceSortIdList);
//				StringUtilsv.printMap(mpp);
				incMap = incomeManager.getIncome12Month(mpp);

//				StringUtilsv.printMap(mpp);

    	}else{
            incMap = incomeManager.getIncome12Month(map);

    	}		
		

    
		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
//			System.out.println("orderDayInfo.getPublishDate()11111111111111111111<<<<<<<<<<<<<<<<<<"+orderDayInfo.getPublishDate());
			mp.put(orderDayInfo.getPublishDate(), orderDayInfo);
		}
	
		double result[]=new double[4];
	
		
		
		for (int i = 1; i < 13; i++) {
			
			Object obj = mp.get(new Integer(i));
			
			Double incMoney =  (Double)incMap.get(new Integer(i));
			
			Double incPuton =  (Double)inputonMap.get(new Integer(i));
			String month= StringUtil.converNum2cnMonth(String.valueOf(i));
//			double returnValue1 =  ((Double)returnValueMap.get(new Integer(i))).doubleValue();
			
			if(isNotReturnValue){
				double returnValue1 =  ((Double)returnValueMap.get(new Integer(i))).doubleValue();
				if(returnValue1 > 0){
					incMoney = new Double(incMoney.doubleValue()-returnValue1);
//					incPuton = new Double(incPuton.doubleValue()-returnValue1);
				}
			}
			result[3]+= incMoney.doubleValue();

			if (obj == null ) {
				CustomerAnalyzeColl customerColl = new CustomerAnalyzeColl();
				
				double payMoney = 0-incMoney.doubleValue();
				customerColl.setId(String.valueOf(i));
				customerColl.setSortStr(sortStr);
				customerColl.setCustomerName(month);
				customerColl.setCustomerIncome(incMoney.toString());
//				customerColl.setDayRelPuton(incPuton.toString());
				customerColl.setDayRelPuton("0");
				customerColl.setDayRelIncome("0");
				customerColl.setAdSumTimes("0");
				customerColl.setDayPayMoney(String.valueOf(payMoney));
				
				monthList.add(customerColl);
			} else {
				OrderDayInfo orderDayInfo = (OrderDayInfo)obj;
				CustomerAnalyzeColl customerColl = new CustomerAnalyzeColl();
			
//				Double incMoney = (obj==null)?new Double(0):(Double)obj;
				Double realIncom = orderDayInfo.getDayRelIncome() == null?new Double(0):orderDayInfo.getDayRelIncome();
				
//				System.out.println(i+">>>>>>>>>realIncom >>>>>>>>>>>>>>>>  "+realIncom) ;
				
//				Double relPuton = orderDayInfo.getDayRelPuton() == null?new Double(0):orderDayInfo.getDayRelPuton();	
				//double payMoney = realIncom.doubleValue()-relPuton.doubleValue();
				if(isNotReturnValue){
//					Double returnValue1 =  (Double)returnValueMap.get(new Integer(i));
					double returnValue1 =  ((Double)returnValueMap.get(new Integer(i))).doubleValue();
					realIncom = new Double(realIncom.doubleValue()-returnValue1);
					incPuton = new Double(incPuton.doubleValue()-returnValue1);
				}
				double payMoney =0;

				if(arrearagemode){
					payMoney = realIncom.doubleValue()-incMoney.doubleValue();
				}else{
					payMoney = realIncom.doubleValue()-incPuton.doubleValue();
				}
				            
				
//				System.out.println(i+">>>>>>>>>>>>>>>realIncom 2 >>>>>>>>>>>>>>>>  "+realIncom) ;
				
				customerColl.setId(String.valueOf(i));
				customerColl.setSortStr(sortStr);
				customerColl.setCustomerName(month);
				customerColl.setCustomerIncome(incMoney.toString());
				customerColl.setDayRelIncome(realIncom.toString());
				customerColl.setDayRelPuton(incPuton.toString());
				customerColl.setAdSumTimes(orderDayInfo.getAdSumTimes().toString());
				
				customerColl.setDayPayMoney(String.valueOf(payMoney));

//				result[0]+=orderDayInfo.getDayRelPuton().doubleValue();
				result[0]+= incPuton.doubleValue();
				result[1]+= realIncom.doubleValue();
				result[2]+= orderDayInfo.getAdSumTimes().doubleValue();
//				result[3]+= incMoney.doubleValue();
//				result[4]+= payMoney;
				monthList.add(customerColl);  				
			}
			
		}
		
		if(type.equals("2")){
			Map mpQuerter = new HashMap();
			for(Iterator it=monthList.iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl = (CustomerAnalyzeColl)it.next();
				int i = Integer.parseInt(customerColl.getId());
				if(i==1||i==2||i==3){
					customerColl.setId("1");
					customerColl.setCustomerName("一季度");
					getNewCustomerAnalyze(mpQuerter,customerColl);
				}else if(i==4||i==5||i==6){
					customerColl.setId("2");
					customerColl.setCustomerName("二季度");
					getNewCustomerAnalyze(mpQuerter,customerColl);
				}else if(i==7||i==8||i==9){
					customerColl.setId("3");
					customerColl.setCustomerName("三季度");
					getNewCustomerAnalyze(mpQuerter,customerColl);
				}else{
					customerColl.setId("4");
					customerColl.setCustomerName("四季度");
					getNewCustomerAnalyze(mpQuerter,customerColl);
					
				
				}
    		}
			
			monthList = new ArrayList();
			for(Iterator it=mpQuerter.values().iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl = (CustomerAnalyzeColl)it.next();
				monthList.add(customerColl);
    		}			

		}
		
		
		
//		Collections.sort(monthList,new CustomerAnalyzeCollComparator());

		 if(monthList.size() >0){
				CustomerAnalyzeColl totalAnalyzeColl =new CustomerAnalyzeColl();
				totalAnalyzeColl.setSortStr("0,ASC");
				totalAnalyzeColl.setCustomerName("合计:");
				totalAnalyzeColl.setDayRelPuton(new Double(result[0]).toString());
				totalAnalyzeColl.setDayRelIncome(new Double(result[1]).toString());
				totalAnalyzeColl.setAdSumTimes(new Double(result[2]).toString());
				totalAnalyzeColl.setCustomerIncome(new Double(result[3]).toString());
				totalAnalyzeColl.setDayPayMoney(new Double(result[1]-result[3]).toString());
				monthList.add(totalAnalyzeColl); 
		 }

		
		return monthList;
	}
	
	
	public  void getNewCustomerAnalyze(Map mpQuerter,CustomerAnalyzeColl o){
	    String id = o.getId();
	    Object obj = mpQuerter.get(id);
	    CustomerAnalyzeColl cust = new CustomerAnalyzeColl();
	    CustomerAnalyzeColl customerColl = new CustomerAnalyzeColl();
		double customerIncome = Double.parseDouble(o.getCustomerIncome());;
		double relIncome = Double.parseDouble(o.getDayRelIncome());
		double relPuton = Double.parseDouble(o.getDayRelPuton());
		double payMoney = Double.parseDouble(o.getDayPayMoney());
		double adSumTimes = Double.parseDouble(o.getAdSumTimes());
	    
	    if(obj != null){
	    	cust = (CustomerAnalyzeColl)obj;
			customerIncome = Double.parseDouble(cust.getCustomerIncome())+Double.parseDouble(o.getCustomerIncome());;
			relIncome = Double.parseDouble(cust.getDayRelIncome())+Double.parseDouble(o.getDayRelIncome());
			relPuton = Double.parseDouble(cust.getDayRelPuton())+Double.parseDouble(o.getDayRelPuton());
			payMoney = Double.parseDouble(cust.getDayPayMoney())+Double.parseDouble(o.getDayPayMoney());
			adSumTimes = Double.parseDouble(cust.getAdSumTimes())+Double.parseDouble(o.getAdSumTimes());
	    }

		customerColl.setSortStr(o.getSortStr());
		customerColl.setCustomerName(o.getCustomerName());	
		customerColl.setCustomerIncome(String.valueOf(customerIncome));
		customerColl.setDayRelIncome(String.valueOf(relIncome));
		customerColl.setDayRelPuton(String.valueOf(relPuton));
		customerColl.setDayPayMoney(String.valueOf(payMoney));
		customerColl.setAdSumTimes(String.valueOf(adSumTimes));
		mpQuerter.put(id,customerColl);
		
	}
	
	private List getCustomerByYearPageForReport(String year, String[] customerIds,String userId,String carrierName,String curUserName,String channelModel) {
		List userIdList = new ArrayList();
		Map mp = new HashMap();
		Map mp2 = new HashMap();
		Map map = new HashMap();
		List monthList = new ArrayList();
		List carrierIdList = new ArrayList();
		List customerIdList = new ArrayList();
//		System.out.println(">>>>>  1  "+userId+"   "+carrierName) ;
		CollectionUtils.addAll(customerIdList, customerIds);
		map.put("year", year);
		map.put("CustomerIdList", customerIdList);
//		map.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		int channelMod = Integer.parseInt(channelModel);
		if(channelMod==1){
			 channelPull = true;
			}
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		if(carrierIdList.size() == 0)carrierIdList.add("-1");
		map.put("carrierIdList",carrierIdList);
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		map.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}

		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
    		List ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		List daoList = dao.getCustomerByYearPage(map);
		List ls = (List) daoList.get(0);
//		System.out.println(">>>>>  2  "+ls.size()) ;
		
		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			int month = Integer.parseInt(orderDayInfo.getPublishDate()
					.toString().substring(4, 6));
			mp.put(new Integer(month), orderDayInfo);
		}
	
		double temp[]=new double[4];
		for (int i = 1; i < 13; i++) {
			Object obj = mp.get(new Integer(i));
			
			if (obj == null ) {
				OrderDayInfo orderDayInfo = new OrderDayInfo();
				orderDayInfo.setPublishDate(new Integer(i));
				monthList.add(orderDayInfo);
			} else {
				OrderDayInfo orderDayInfo1 = new OrderDayInfo();
				
					orderDayInfo1 = (OrderDayInfo)obj;
					temp[0]+=orderDayInfo1.getDayRelPuton().doubleValue();
					temp[1]+=orderDayInfo1.getDayRelIncome().doubleValue();
					temp[2]+=orderDayInfo1.getAdSumTimes().doubleValue();
					
				orderDayInfo1.setPublishDate(new Integer(i));
				monthList.add(orderDayInfo1);
			}
		}
		OrderDayInfo coltotal=new OrderDayInfo();
		coltotal.setPublishDate(new Integer(13));
		coltotal.setDayRelIncome(new Double(temp[1]));
		coltotal.setAdSumTimes(new Double(temp[2]));
		coltotal.setDayRelPuton(new Double(temp[0]));
		monthList.add(coltotal);
		
		return monthList;
	}
	
	private List getCustomerByQuarterPageForReport(String year, String[] customerIds,String userId,String carrierName,String curUserName,String channelModel) {
	    List userIdList = new ArrayList();
		Map mp = new HashMap();
//		Map mp2 = new HashMap();
		Map map = new HashMap();
		List quarterList = new ArrayList();
		List customerIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		

		CollectionUtils.addAll(customerIdList, customerIds);
		map.put("year", year);
		map.put("CustomerIdList", customerIdList);
//		map.put("parentId",carrierName);
		
     	if(UserUtil.isUserOrderYearRel()) {
     		map.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		int channelMod = Integer.parseInt(channelModel);
		if(channelMod==1){
			 channelPull = true;
			}
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		if(carrierIdList.size() == 0)carrierIdList.add("-1");
		map.put("carrierIdList",carrierIdList);


		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
    		List ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		List daoList = dao.getCustomerByYearPage(map);
		
		List ls = (List) daoList.get(0);
		
		

		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			int month = Integer.parseInt(orderDayInfo.getPublishDate()
					.toString().substring(4, 6));
			mp.put(new Integer(month), orderDayInfo);
		}
		int k=1;
		double temp[]=new double[4];
		double temp1[]=new double[4];
		for(int j=1;j<5;j++){
			OrderDayInfo orderDayQuarter = new OrderDayInfo();
			int kk=k;
			for (int i = kk; i < kk+3; i++) {
				Object obj = mp.get(new Integer(i));
				if (obj != null ) {
					OrderDayInfo orderDayInfo1 = new OrderDayInfo();
					orderDayInfo1 = (OrderDayInfo)obj;
					temp[0]+=orderDayInfo1.getDayRelPuton().doubleValue();
					temp[1]+=orderDayInfo1.getDayRelIncome().doubleValue();
					temp[2]+=orderDayInfo1.getAdSumTimes().doubleValue();
				}
				k++;
			}
			orderDayQuarter.setPublishDate(new Integer(j));
			orderDayQuarter.setDayRelIncome(new Double(temp[1]));
			orderDayQuarter.setAdSumTimes(new Double(temp[2]));
			orderDayQuarter.setDayRelPuton(new Double(temp[0]));
			quarterList.add(orderDayQuarter);
			for(int i=0;i<temp1.length;i++){
				temp1[i] += temp[i];
				temp[i] = 0;
			}
		}
		
		OrderDayInfo coltotal=new OrderDayInfo();
		coltotal.setPublishDate(new Integer(5));
		coltotal.setDayRelIncome(new Double(temp1[1]));
		coltotal.setAdSumTimes(new Double(temp1[2]));
		coltotal.setDayRelPuton(new Double(temp1[0]));
		quarterList.add(coltotal);
		
		return quarterList;
	}
	public Collection getCustomerByYearForReport(String orgId ,String resourceTypeId,String type,String sortStr,String isPutYear,String year, String[] customerIds,String userId,String carrierName,String curUserName,String channelModel,String incomPurs,String returnValue){
		Collection coll = new ArrayList();
		List ls = this.getCustomerByYearPage(orgId,resourceTypeId,type,sortStr,isPutYear,year,customerIds,userId,carrierName,Integer.parseInt(channelModel),curUserName,incomPurs,returnValue);
//		System.out.println("all<!11111111111111111111fffffffffffffffffffffffffffffffffffffffff<<<<<<<<<<<<<<<<<<"+ls.size());
		CollectionUtils.addAll(coll,ls.iterator());
		return coll;		
	}
	
	
	public Collection getCustomerByQuarterForReport(String year, String[] customerIds,String userId,String carrierName,String curUserName,String channelModel){
		List ls = this.getCustomerByQuarterPageForReport(year,customerIds,userId,carrierName,curUserName,channelModel);
		Collection coll = new ArrayList();
		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			double arraers=0;
			double relIncome = orderDayInfo.getDayRelIncome()==null?0:orderDayInfo.getDayRelIncome().doubleValue();
			double putOn = orderDayInfo.getDayRelPuton()==null?0:orderDayInfo.getDayRelPuton().doubleValue();
			arraers = relIncome - putOn;
			
//			System.out.println(">>>>>>>>>>>  "+orderDayInfo.getPublishDate().intValue()) ;
			
			switch(orderDayInfo.getPublishDate().intValue()){
				case 1:
				orderDayInfo.setResourceSpecific("一季度");
				break;
				case 2:
				orderDayInfo.setResourceSpecific("二季度");
				break;
				case 3:
				orderDayInfo.setResourceSpecific("三季度");
				break;
				case 4:
				orderDayInfo.setResourceSpecific("四季度");
				break;
				case 5:
				orderDayInfo.setResourceSpecific("合计");
				break;
			}
			orderDayInfo.setAdlength((new Double(arraers)).toString());
			coll.add(orderDayInfo);
		}
		return coll;
	}
	
public List getCustomerByQuarterPage(String year, String[] customerIds,String userId,String carrierName,int channelModelParam) {
	    List userIdList = new ArrayList();
		Map mp = new HashMap();
//		Map mp2 = new HashMap();
		Map map = new HashMap();
		List quarterList = new ArrayList();
		List customerIdList = new ArrayList();
		List carrierIdList = new ArrayList();

		CollectionUtils.addAll(customerIdList, customerIds);
		map.put("year", year);
		map.put("CustomerIdList", customerIdList);
		//map.put("parentId",carrierName);
		
		
//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		
		if(channelModelParam==1){
			 channelPull = true;
			}
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,null);
		if(carrierIdList.size() == 0)carrierIdList.add("-1");
		map.put("carrierIdList",carrierIdList);
		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
    		List ls = userManager.getOwnerUsersList(userRelsMap);
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		List daoList = dao.getCustomerByYearPage(map);
		
		List ls = (List) daoList.get(0);
		
		

		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			int month = Integer.parseInt(orderDayInfo.getPublishDate()
					.toString().substring(4, 6));
			mp.put(new Integer(month), orderDayInfo);
		}
		int k=1;
		double temp[]=new double[4];
		double temp1[]=new double[4];
		for(int j=1;j<5;j++){
			OrderDayInfo orderDayQuarter = new OrderDayInfo();
			int kk=k;
			for (int i = kk; i < kk+3; i++) {
				Object obj = mp.get(new Integer(i));
				if (obj != null ) {
					OrderDayInfo orderDayInfo1 = new OrderDayInfo();
					orderDayInfo1 = (OrderDayInfo)obj;
					temp[0]+=orderDayInfo1.getDayRelPuton().doubleValue();
					temp[1]+=orderDayInfo1.getDayRelIncome().doubleValue();
					temp[2]+=orderDayInfo1.getAdSumTimes().doubleValue();
				}
				k++;
			}
			orderDayQuarter.setPublishDate(new Integer(j));
			orderDayQuarter.setDayRelIncome(new Double(temp[1]));
			orderDayQuarter.setAdSumTimes(new Double(temp[2]));
			orderDayQuarter.setDayRelPuton(new Double(temp[0]));
			quarterList.add(orderDayQuarter);
			for(int i=0;i<temp1.length;i++){
				temp1[i] += temp[i];
				temp[i] = 0;
			}
		}
		
		OrderDayInfo coltotal=new OrderDayInfo();
		coltotal.setPublishDate(new Integer(5));
		coltotal.setDayRelIncome(new Double(temp1[1]));
		coltotal.setAdSumTimes(new Double(temp1[2]));
		coltotal.setDayRelPuton(new Double(temp1[0]));
		quarterList.add(coltotal);
		
		return quarterList;
	}
	
private static  boolean getIsSignUserBalance(){
    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
    if(StringUtils.isEmpty(sysParam.getIsSignUserBalance())) sysParam.setIsSignUserBalance("0");
    return (sysParam.getIsSignUserBalance().equals("0"))?false:true;
}
	public List getBusinessInfos(String orgId,String startDate, String endDate,String type, String sortStr, String theUser,String userId,String carrierName,boolean isPutOnORIncome,int channelModelParam,String isPutYear,String returnValue,String incomPurs) {
	    List userIdList = new ArrayList();
	    List carrierIdList = new ArrayList();
	    List incomePurposeIdList = new ArrayList();
		Map mp = new HashMap();
		Map businessMap = new HashMap();
		
		mp.put("startDate", startDate);
		mp.put("endDate", endDate);
		
		CollectionUtils.addAll(incomePurposeIdList,incomPurs.split(","));
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		if(financialAuditSwitch && incomePurposeIdList.size() == 0)incomePurposeIdList.add("-1");
		
		if(financialAuditSwitch){
			String version = startDate.substring(0,4);
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(version);
			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
			mp.put("OrderCategoryIdList",OrderCategoryIdList);
		}

		mp.put("incomePurposeIdList",incomePurposeIdList);
		
//		mp.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分

     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
     	}
     	
     	
//     	System.out.println("UserUtil.getCurUserRels userId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userId);
//     	System.out.println("UserUtil.getCurUserRels theUser>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+theUser);
//     	System.out.println("UserUtil.getCurUserRels orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orgId);

		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		CollectionUtils.addAll(userls, userId.split(","));
    		mp.put("UserIdList",userls);
    	}else{
    		userIdList = UserUtil.getCurUserRels(theUser,orgId);
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    		System.out.println("UserUtil.getCurUserRels>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userIdList);
    	}
		

		
		List list = new ArrayList();
		

//		List carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
//		mp.put("carrierIdList",carrierIdList2);
		
		
		List carrierIdList2 = new ArrayList();
		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
		 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
			 carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
			 		mp.put("carrierIdList",carrierIdList2);	
		 }
		
		
//		List carrierIdList2 = new ArrayList();
//		boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
//	 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
//		 		 carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
//		 		mp.put("carrierIdList",carrierIdList2);	
//	  }	
		
		
		
		
		if(type.equals("1")){
			list = dao.getBusinessPage(mp);
		}else{
			if(type.equals("2")){
				mp.put("putYear",isPutYear);
			}
//			List carrierIdList2 = carrierManager.getOwnerCarrierIds(carrierName,channelPull,theUser);
//			carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
//			mp.put("carrierIdList",carrierIdList);
			
			

//			boolean moreChannelNoPullParam = SysParamUtil.getMoreChannelNoPullParam();
		 if(!"0".equals(carrierName) ||!moreChannelNoPullParam){
			 carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
			 		mp.put("carrierIdList",carrierIdList);	
		  }		
			
			
			
			
			//判断是否业务员平帐
            if(getIsSignUserBalance()){
            	mp.put("version",new Integer(1));
            }else{
            	mp.put("version",new Integer(0));
            }
            
			list = incomeManager.getBussin(mp);
		}
//		System.out.println("111111111111i returnValue>>>>>>>>>>>>>>>>>>"+returnValue);
		
//		List temList = new ArrayList();
//		List ls_temp2 = (List)mp.get("UserIdList");
//		CollectionUtils.addAll(temList,ls_temp2.iterator());
//		List retUserList = ConvertUtil.convertListToStrList(list,"linkUserId");
//		temList.removeAll(retUserList);
		
//		System.out.println("key22222222222222222222>>temList.size()>>>>>>>>>>>>>>>>"+temList.size());
		
		
		//判断返点
		boolean isNotReturnValue = returnValue.equals("1")?true:false;
		Map returnValueMap = new HashMap();
		if(isNotReturnValue){
//			List carrierIdList2 = carrierManager.getOwnerCarrierIds(carrierName,channelPull,theUser);
			mp.put("carrierIdList",carrierIdList);
			returnValueMap = incomeUsedManager.getReturnValue3(mp);
		}
		
		
		
	
//		System.out.println(">>>>>  2  "+list.size()) ;
		double total_money = 0.0d;
		for (Iterator it = list.iterator(); it.hasNext();) {

			Map map = null;
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			String businessName = (orderDayInfo.getBusinessFirstName().trim() + orderDayInfo.getBusinessLastName().trim());
			int month = Integer.parseInt(orderDayInfo.getPublishDate().toString().substring(4, 6));

			if (businessMap.containsKey(businessName)) {
				Map map1 = (Map) businessMap.get(businessName);
				map1.put(new Integer(month), orderDayInfo);
				for (int i = 1; i < 13; i++) {
					if (map1.get(new Integer(i)) == null) {
						map1.put(new Integer(i), null);
					}
				}
				businessMap.put(businessName, map1);
			} else {

				map = new HashMap();
				map.put(new Integer(month), orderDayInfo);

				for (int i = 1; i < 13; i++) {

					if (map.get(new Integer(i)) == null) {
						map.put(new Integer(i), new OrderDayInfo());
					}

				}

				businessMap.put(businessName, map);
			}
		}
		
//		System.out.println("key22222222222222222222>>temList.size()>>>>>>>>>>>>>>>>"+temList.size());
		
//		if(temList.size() > 0){
//			List lsss = UserUtil.getUsersByIdList(temList);
//			Map map = null;
//			for (Iterator it_temp = lsss.iterator(); it_temp.hasNext();) {
//				map = new HashMap();
//				for (int i = 1; i < 13; i++) {
//					map.put(new Integer(i), new OrderDayInfo());
//				}
//				User u = (User)it_temp.next();
//				String uderName = u.getFullName();
//				businessMap.put(uderName, map);
//			}
//		}
		
		
		List result = new ArrayList();
		double colcount[] = new double[14];
		//强制解除科学计数法
		DecimalFormat df = new DecimalFormat("###########.##");
		String col[] = new String[14];
		for (Iterator it = businessMap.keySet().iterator(); it.hasNext();) {
			String businessName = (String) it.next();

//			OrderDayInfo temp = new OrderDayInfo();
//			temp.setBusinessFullName(businessName);
			CustomerAnalyzeColl analyzeColl = new CustomerAnalyzeColl();
			analyzeColl.setCustomerName(businessName);

			Map orderDays = (Map) businessMap.get(businessName);

			String ss[] = new String[14];
			double rowcount = 0.0d;

			for (int i = 1; i < 13; i++) {

				if (orderDays.get(new Integer(i)) == null) {
					ss[i] = "0";

				} else {
					OrderDayInfo orderdayinfos = (OrderDayInfo) orderDays.get(new Integer(i));
//					if(isPutOnORIncome){//判断是显示应收还是显示到款
					ss[i] = StringUtil.getNullValue(orderdayinfos.getDayRelIncome(),"0");
					
//						if (orderdayinfos.getDayRelIncome() == null) {
//							ss[i] = "0";
//						} else {
//							ss[i] = orderdayinfos.getDayRelIncome().toString();
//						}
//					}else{
//						if (orderdayinfos.getDayRelPuton() == null) {
//							ss[i] = "0";
//						} else {
//							ss[i] = orderdayinfos.getDayRelPuton().toString();
//						}
//					}
				}
//				System.out.println("type>>>>>>>>>>>>>>>>>>"+type);
				
				
				if(type.equals("1")&& isNotReturnValue){
					String key = businessName + String.valueOf(i);
					
					Object obj = returnValueMap.get(key);
					if(obj != null){
						double returnV = ((Double)obj).doubleValue();
						if(returnV > 0) ss[i] = String.valueOf(Double.parseDouble(ss[i]) - returnV);
//						System.out.println("key22222222222222222222>>>>>>>>>>>>>>>>>>"+ss[i]);
						
					}
		
				}
				
				
				ss[i] = df.format(new Double(ss[i]));
//				System.out.print("ss[i] 1 "+ss[i]);//df.format(new Double(ss[i]).doubleValue()));
				colcount[i] += Double.parseDouble(ss[i]);
				rowcount += Double.parseDouble(ss[i]);
			}
			
			total_money += rowcount;
			ss[13] = String.valueOf(df.format(rowcount));

			double total_money1 = 0.0d;
			for (int cov = 1; cov < 13; cov++) {
				total_money1 += colcount[cov];
				
				col[cov] = String.valueOf(df.format(colcount[cov]));
//				System.out.print("cov 2 "+col[cov]);
			}
			
//			System.out.println("1sortStr >>>>>>>>>>>>>>>>>>   "+sortStr) ;
			col[13] = String.valueOf(df.format(total_money));
			
//			if (total_money1 == total_money) {
//				col[13] = String.valueOf(df.format(total_money));
//			} else {
//				System.out.println("total_money1 >>>>>>>>>>>>>>>>>>   "+StringUtil.doubleFormat4(total_money1)) ;
//				System.out.println("total_money >>>>>>>>>>>>>>>>>>   "+StringUtil.doubleFormat4(total_money)) ;
//				col[13] = "<script language='javaScript'>alert('数据处理有误,请刷新页面')</script>";
//			}
            
	        
			analyzeColl.setSortStr(sortStr);
			List ls1 = new ArrayList();
			CollectionUtils.addAll(ls1,ss);
			analyzeColl.setMonth(ls1);
			result.add(analyzeColl);
//			temp.setMonth(ss);
//			result.add(temp);
		}
//		System.out.println("1sortStr >>>>>>>>>>>>>>>>>>   "+sortStr) ;
//		System.out.println("2>>>>>>>>>>>>>>>>>>>>>>>>>>   "+result.size()) ;
		Collections.sort(result,new CustomerAnalyzeCollComparator2());
//		System.out.println("3>>>>>>>>>>>>>>>>>>>>>>>>>>   "+result.size()) ;
		
		if(result.size() >0){
			CustomerAnalyzeColl analyzeColl = new CustomerAnalyzeColl();
			analyzeColl.setCustomerName("合计:");
			List ls1 = new ArrayList();
			CollectionUtils.addAll(ls1,col);
			analyzeColl.setMonth(ls1);
			result.add(analyzeColl);	
		}

//		OrderDayInfo colsum = new OrderDayInfo();// 列统计
//		colsum.setBusinessFullName("总合计");
//		colsum.setMonth(col);
//		result.add(colsum);
		
		return result;
	}
	
	
	
	public Collection getBusinessInfosColl(List ls){
		Collection coll = new ArrayList();
		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDayInfo colsum = (OrderDayInfo)it.next();
			OrderDetailColl odColl = new OrderDetailColl();
			odColl.setAdvName(colsum.getBusinessFullName());
				odColl.setDay1(colsum.getMonth()[1]);
				odColl.setDay2(colsum.getMonth()[2]);
				odColl.setDay3(colsum.getMonth()[3]);
				odColl.setDay4(colsum.getMonth()[4]);
				odColl.setDay5(colsum.getMonth()[5]);
				odColl.setDay6(colsum.getMonth()[6]);
				odColl.setDay7(colsum.getMonth()[7]);
				odColl.setDay8(colsum.getMonth()[8]);
				odColl.setDay9(colsum.getMonth()[9]);
				odColl.setDay10(colsum.getMonth()[10]);
				odColl.setDay11(colsum.getMonth()[11]);
				odColl.setDay12(colsum.getMonth()[12]);
				odColl.setDay12(colsum.getMonth()[13]);
//				odColl.setDay13(StringUtil.getNullValue(colsum.getMonth()[13],"0"));
				
//				System.out.println("3>>>>>>>>>>>>>>>>>>>>>>>>>>   "+result.size()) ;
				
				coll.add(odColl);
		}
		return coll;
	}
	
	public Collection getCarrierByDateColl(List ls) {
		Collection coll = new ArrayList();
		for(Iterator it =ls.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();
			orderDayInfo.setAdlength(orderDayInfo.getCarrier().getCarrierName());
			coll.add(orderDayInfo);
		}
		
		return coll;
	}
	
	public List getCarrierByDate(String startDate, String endDate,String[] carrierIds,String userId,String curUserName,String isPrint,String orderSubCategorys) {

		Map map =new HashMap();
		
		
		List carrierIdList =new ArrayList();
		List orderSubCatesIdList =new ArrayList();
		List userIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		List ls = new ArrayList();
		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("carrierIdList",carrierIdList);
//		map.put("parentId",carrierName);
		
		String orderSubCategory = StringUtil.getNullValue(orderSubCategorys,"");
		if(!"".equals(orderSubCategory)){
			String orderSubCates[] = orderSubCategory.split(",");
			CollectionUtils.addAll(orderSubCatesIdList, orderSubCates);
			map.put("orderSubCatesIdList",orderSubCatesIdList);
		}	
		
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		
		if(financialAuditSwitch){
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(startDate.substring(0,4));
		
			if(OrderCategoryIdList.size() > 0){
//				交集的补集
				Collection   intersectionList  =  CollectionUtils.intersection(orderSubCatesIdList, OrderCategoryIdList);
				System.out.println("getCarrierByDate ********************************************* >>>>>>>>>>>>>>>>>>   "+intersectionList) ;
				  
				map.put("orderSubCatesIdList",intersectionList);
			}
		}		
		
//     	List incomePurposeIdList = new ArrayList();
//		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
//		
//		if(financialAuditSwitch){
//			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(version);
//			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
//			mp.put("OrderCategoryIdList",OrderCategoryIdList);
//		}
//
//		mp.put("incomePurposeIdList",incomePurposeIdList);    		
		
		
		
		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
//    			ls = userManager.getOwnerUsersList(userRelsMap);
    			ls =(List)userRelsMap.get(curUserName);
    		}else{//打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		
     	if(UserUtil.isUserOrderYearRel()) {
     		map.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
     	
     	
     	
     	
     	
     	
     	
     	
		
		List result =dao.getCarrierByDate(map);
		
		Map inputonMap = incomeUsedManager.getScopeCarriersPutonMoney(map);
		double resultTotal[]=new double[3];
		Map carrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
 		for(Iterator it =result.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();

			Long carrId = orderDayInfo.getCarrier().getId();
			
			Object obj = inputonMap.get(carrId);
			
			
			if(obj==null) {
				
				orderDayInfo.setDayRelPuton(new Double(0));
			}else{
				orderDayInfo.setDayRelPuton((Double)obj);
			}
		
			


			resultTotal[0]+=orderDayInfo.getDayRelPuton().doubleValue();
			resultTotal[1]+=orderDayInfo.getDayRelIncome().doubleValue();
			resultTotal[2]+=orderDayInfo.getAdSumTimes().doubleValue();
//			result.add(carrierColl);
////			System.out.println("LLLLLLLLLLL  "+orderDayInfo.getDayRelIncome());
////			System.out.println("SSSSSSSSSSS  "+orderDayInfo.getDayRelPuton());
			Long parentId = orderDayInfo.getParentId();
//			Map carrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
			List list = (List) carrierRelsMap.get(parentId);
			String channel = "";
			for(Iterator iter = list.iterator();iter.hasNext();){
				Carrier carrier = (Carrier)iter.next();
				channel = carrier.getCarrierName()+"/"+channel;
			}
			orderDayInfo.setToaccountTotal(channel);
			
			
		}
 		
 		OrderDayInfo resultOderDayInfo =new OrderDayInfo();
 		Carrier  carrier=new Carrier();
 		
 		carrier.setCarrierName("合计");
 		
 		resultOderDayInfo.setCarrier(carrier);
 		resultOderDayInfo.setToaccountTotal("");
 		resultOderDayInfo.setDayRelIncome(new Double(resultTotal[1]));
 		resultOderDayInfo.setDayRelPuton(new Double(resultTotal[0]));
 		resultOderDayInfo.setAdSumTimes(new Double(resultTotal[2]));
 		
        result.add(resultOderDayInfo);
        
		return result;
	}
	public int getCarrierCount(String startDate, String endDate,String[] carrierIds) {

		Map map =new HashMap();
		List carrierIdList =new ArrayList();
		
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("carrierIdList",carrierIdList);
		
		List result =dao.getCarrierByDate(map);
		
		double resultTotal[]=new double[3];
		
 		for(Iterator it =result.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();
			resultTotal[1]+=orderDayInfo.getDayRelIncome().doubleValue();
			resultTotal[2]+=orderDayInfo.getAdSumTimes().doubleValue();
		}
 		
 		OrderDayInfo resultOderDayInfo =new OrderDayInfo();
 		Carrier  carrier=new Carrier();
 		
 		carrier.setCarrierName("合计");
 		
 		resultOderDayInfo.setCarrier(carrier);
 		resultOderDayInfo.setDayRelIncome(new Double(resultTotal[1]));
 		resultOderDayInfo.setAdSumTimes(new Double(resultTotal[2]));
 		
        result.add(resultOderDayInfo);
        
		return result.size()-1;
	}
	
	public Collection getCarrierAllYearColl(List ls){
		Collection coll = new ArrayList();
		for (Iterator it = ls.iterator(); it.hasNext();) {
			OrderDayInfo colsum = (OrderDayInfo)it.next();
			OrderDetailColl odColl = new OrderDetailColl();
			odColl.setAdvName(colsum.getCarrier().getCarrierName());
				odColl.setDay1(colsum.getMonth()[1]);
				odColl.setDay2(colsum.getMonth()[2]);
				odColl.setDay3(colsum.getMonth()[3]);
				odColl.setDay4(colsum.getMonth()[4]);
				odColl.setDay5(colsum.getMonth()[5]);
				odColl.setDay6(colsum.getMonth()[6]);
				odColl.setDay7(colsum.getMonth()[7]);
				odColl.setDay8(colsum.getMonth()[8]);
				odColl.setDay9(colsum.getMonth()[9]);
				odColl.setDay10(colsum.getMonth()[10]);
				odColl.setDay11(colsum.getMonth()[11]);
				odColl.setDay12(colsum.getMonth()[12]);
				odColl.setDay13(colsum.getMonth()[13]);
				coll.add(odColl);
		}
		return coll;
	}
	
	public List getAllYearCarrier(String year, String[] carrierIds,String userId,String curUserName,String isPrint) {

		List result=new ArrayList();
		Map mp=new HashMap();
		List carrierIdList=new ArrayList();
		List userIdList = new ArrayList();
		List ls = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
			Map carrierMap = new HashMap();
			
		
		mp.put("year",year);
		mp.put("carrierIdList",carrierIdList);
//		mp.put("parentId",carrierParentId);
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			ls = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
     	
     	
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();

		
		if(financialAuditSwitch){
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(year);
			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
			mp.put("OrderCategoryIdList",OrderCategoryIdList);
		}  	
		
		
		List daoList=dao.getCarrierAllYear(mp);
		
		Map resultmap=new HashMap();
		
		double total_money = 0.0d;

		for(Iterator it =daoList.iterator();it.hasNext();){
			Map map=null;
			OrderDayInfo orderDayInfo=(OrderDayInfo)it.next();
			Long carrierNameId = orderDayInfo.getCarrier().getId();
			String carrierName = orderDayInfo.getCarrier().getCarrierName();
			
			Long parentId = orderDayInfo.getParentId();
			
			Map carrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
			List list = (List) carrierRelsMap.get(parentId);
			String channel = "";
			for(Iterator iter = list.iterator();iter.hasNext();){
				Carrier carrier = (Carrier)iter.next();
				channel = carrier.getCarrierName()+"/"+carrierName;
			}
//			orderDayInfo.setToaccountTotal(channel);
			carrierMap.put(carrierNameId,channel);
			
//			System.out.println("temp.getToaccountTotal()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ orderDayInfo.getToaccountTotal()) ;
			int month=Integer.parseInt(orderDayInfo.getPublishDate().toString().substring(4,6));
			
			if (resultmap.containsKey(carrierNameId)) {
				Map map1 = (Map) resultmap.get(carrierNameId);
				
				map1.put(new Integer(month), orderDayInfo);
				for (int i = 1; i < 13; i++) {
					if (map1.get(new Integer(i)) == null) {
						map1.put(new Integer(i), null);
					}
				}
				resultmap.put(carrierNameId, map1);
				
			} else {
				map = new HashMap();
				map.put(new Integer(month), orderDayInfo);

				for (int i = 1; i < 13; i++) {
					if (map.get(new Integer(i)) == null) {
						map.put(new Integer(i), new OrderDayInfo());
					}

				}
				resultmap.put(carrierNameId, map);
			}	
		}
		
		double colcount[] = new double[14];
		String col[] = new String[14];
		
		for (Iterator it = resultmap.keySet().iterator(); it.hasNext();) {
			Long carrierNameId = (Long) it.next();
			
			 
			
			OrderDayInfo temp = new OrderDayInfo();
//			System.out.println("temp.getToaccountTotal()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ temp.getToaccountTotal()) ;
			Carrier carrier=new Carrier();
			carrier.setId(carrierNameId);
			carrier.setCarrierName((String)carrierMap.get(carrierNameId));
//			String carrierName=temp.getCarrier().getCarrierName();
//			System.out.println("carrierName >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+carrierName) ;
			temp.setCarrier(carrier);	

			Map orderDays = (Map) resultmap.get(carrierNameId);
			
			String ss[] = new String[14];
			double rowcount = 0.0d;
			
			for (int i = 1; i < 13; i++) {

				if (orderDays.get(new Integer(i)) == null) {
					ss[i] = "0";

				} else {
					
					OrderDayInfo orderdayinfos = (OrderDayInfo) orderDays.get(new Integer(i));

					if (orderdayinfos.getDayRelIncome() == null) {
						ss[i] = "0";
					} else {
						ss[i] = orderdayinfos.getDayRelIncome().toString();
					}
				}
				
				colcount[i] += Double.parseDouble(ss[i]);
				rowcount += Double.parseDouble(ss[i]);

			}
			total_money += rowcount;

			ss[13] = String.valueOf(rowcount);

//			double total_money1 = 0.0d;
			double total_money1 = 0;
			for (int cov = 1; cov < 13; cov++) {

				total_money1 += colcount[cov];
				col[cov] = String.valueOf(colcount[cov]);
			}
	
			
			total_money1 = StringUtil.round1(total_money1,0);
			total_money= StringUtil.round1(total_money,0);
			
//			System.out.println("total_money1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+total_money1) ;
//			System.out.println("total_money >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+total_money) ;
			col[13] = String.valueOf(total_money);
//			if (total_money1 == total_money) {
//				col[13] = String.valueOf(total_money);
//
//			} else {
//				col[13] = "<script language='javaScript'>alert('数据处理有误,请刷新页面')</script>";
//			}

			temp.setMonth(ss);
			result.add(temp);
		}
		OrderDayInfo  totalrow =new OrderDayInfo();
		Carrier carrier =new Carrier();
		

//		carrier.setCarrierName("合计");
//		totalrow.setCarrier(carrier);
//		totalrow.setToaccountTotal("");	
		carrier.setCarrierName("合计");
		totalrow.setCarrier(carrier);
		totalrow.setMonth(col);
		result.add(totalrow);
		return result;
	}
	
	public int getAllYearCarrierCount(String year, String[] carrierIds,String userId,String curUserName,String isPrint) {

		Map mp=new HashMap();
		List carrierIdList=new ArrayList();
		List userIdList = new ArrayList();
		List ls = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("year",year);
		mp.put("carrierIdList",carrierIdList);
//		mp.put("parentId",carrierParentId);
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			ls = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}
		List daoList=dao.getCarrierAllYear(mp);
				
		Map resultmap=new HashMap();
		
				
		for(Iterator it =daoList.iterator();it.hasNext();){
			Map map = null;
			
			OrderDayInfo orderDayInfo=(OrderDayInfo)it.next();
			
			String carrierName=orderDayInfo.getCarrier().getCarrierName();
			
			
			int month=Integer.parseInt(orderDayInfo.getPublishDate().toString().substring(4,6));
			
						
			if (resultmap.containsKey(carrierName)) {
				
				Map map1 = (Map) resultmap.get(carrierName);
				
				map1.put(new Integer(month), orderDayInfo);
				
				for (int i = 1; i < 13; i++) {
					if (map1.get(new Integer(i)) == null) {
						map1.put(new Integer(i), null);
					}
				}
				
				resultmap.put(carrierName, map1);
			} else {
				
				map = new HashMap();
				map.put(new Integer(month), orderDayInfo);

				for (int i = 1; i < 13; i++) {
					if (map.get(new Integer(i)) == null) {
						map.put(new Integer(i), new OrderDayInfo());
					}

				}
				resultmap.put(carrierName, map);
			}	
		}
	
		return resultmap.size();
}

	public PaginatedList getOrderDayInfosAllPage(OrderDayInfo orderDayInfo, String pageIndex, String pageSize) {
		return dao.getOrderDayInfosAllPage(orderDayInfo,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	
	
	public List getResourceChartByDate(String beginDate, String endDate, String[] resourceIds) {
		
		List resList = new ArrayList();
		List resourceIdList = new ArrayList();
		CollectionUtils.addAll(resourceIdList,resourceIds);

		Map resMap = new HashMap();
		resMap.put("beginDate",beginDate);
		resMap.put("endDate",endDate);
		resMap.put("resourceIdList",resourceIdList);
		
		resList = dao.getResourceByDate(resMap);

		return  resList;
	}
	public List getResourceLimitsBy61(String beginDate,String endDate,String startTime,String endTime,String carrierId,String customerId,String mode,String orderBy) {
		List resultList = new ArrayList();
		List resList = new ArrayList();
		List resourceIdList = new ArrayList();
		String carrierIds=carrierId.equals("0")?null:carrierId;
		Map resMap = new HashMap();
		resMap.put("beginDate",beginDate);
		resMap.put("endDate",endDate);
		resMap.put("carrierId",carrierIds);
		resMap.put("startTime",startTime);
		resMap.put("endTime",endTime);
		resMap.put("orderBy",orderBy);

		resList = dao.getUsedTimeByCustomerAndTime(resMap);
		for(Iterator it = resList.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();

			String standTime = customerProduct.getUsed();
			standTime = standTime == null||standTime.equals("")?"0":standTime;
			Integer broadcastStartTime = customerProduct.getBroadcastStartTime();
			double broadcastEndTime=broadcastStartTime.intValue()+Double.parseDouble(standTime);
			
			if(broadcastStartTime.intValue()>=Integer.parseInt(startTime)&&broadcastEndTime<Integer.parseInt(endTime)){
				resourceIdList.add(customerProduct);
			}else if(broadcastStartTime.intValue()<Integer.parseInt(startTime)&&broadcastEndTime>=Integer.parseInt(startTime)){
				double used=broadcastEndTime-Integer.parseInt(startTime);
				if(used<0) used=0;
				customerProduct.setUsed(new Double(used).toString());
				resourceIdList.add(customerProduct);
			}else if(broadcastStartTime.intValue()<Integer.parseInt(endTime)&&broadcastEndTime>=Integer.parseInt(endTime)){
				double used=broadcastEndTime-Integer.parseInt(endTime);
				if(used<0){
					customerProduct.setUsed(standTime);		 	
				}else{
					customerProduct.setUsed(new Double(Double.parseDouble(standTime)-used).toString());
				}		
				resourceIdList.add(customerProduct);
			}	
		}

		List newList = getNewListByIdList(resourceIdList,orderBy);
		
//		Collections.sort(newList,new CustomerProductComparator());
//	   统计求合用
		Double[] oneDaySum = new Double[31];
		Double[] oneDayTotal = new Double[31];
		double totalSum = 0;
		double totalSumTime = 0;
		for(Iterator it = newList.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			Long resId = customerProduct.getResourceId();
			String month = customerProduct.getMonth();
			String resName = customerProduct.getResourceName();
			String resMemo = customerProduct.getResourceMeno();
			Integer displayNo = customerProduct.getDisplayNo();
			Integer broadcastStartTime = customerProduct.getBroadcastStartTime();

//			String standardTime = customerProduct.getTotal();
			
			
//			System.out.println("resId = " + resId);
//			System.out.println("month = " + month);
//			System.out.println("resName = " + resName);
			
			double totalTime = getTotalByIdListMonthAndResId(resourceIdList,resId,month);
			double sumTime = getSumUsedByIdListMonthAndResId(resourceIdList,resId,month);
			
			totalSum += totalTime;
			totalSumTime += sumTime;
			String total = totalTime + "";
			String sumUsed = sumTime + "";
			
//			System.out.println("yyyyy>>>"+totalSumTime);		
			CustomerProduct custPro = new CustomerProduct();
			
//			custPro.set
			custPro.setResourceName(resName);
			custPro.setResourceMeno(resMemo);
			custPro.setDisplayNo(displayNo);
			custPro.setStandardTime(customerProduct.getStandardTime());
			custPro.setBroadcastStartTime(broadcastStartTime);
			custPro.setBroadcastEndTime(new Integer(broadcastStartTime.intValue()+customerProduct.getStandardTime().intValue()));
			custPro.setMonth(month);
//			custPro.setStandardTime(new Double(standardTime));
			custPro.setTotal(total);
			if(mode.equals("2")){
				sumUsed = String.valueOf(Double.valueOf(total).doubleValue()- Double.valueOf(sumUsed).doubleValue());
			}
			custPro.setSumUsed(sumUsed);
//			custPro.setTimeUsed(timeUsed);
//			custPro.setDayTimes(dayTimes);
			getDayTimesByIdListMonthAndResId(custPro,resourceIdList,resId,month,oneDaySum,oneDayTotal,mode);
			
			
			resultList.add(custPro);
		}
		//Collections.sort(resultList);
		DecimalFormat df = new DecimalFormat("#.##");
		CustomerProduct custProSum = new CustomerProduct();
		
//		System.out.println(totalSum+"  ddd "+totalSumTime);
		custProSum.setResourceName("合计");
		custProSum.setResourceMeno("合计");
		custProSum.setMonth("          ");
		custProSum.setTotal(df.format(totalSum));
		if(mode.equals("2")){
			  totalSumTime = totalSum - totalSumTime;  
    	 }
		custProSum.setSumUsed(df.format(totalSumTime));
//		custPro.setTimeUsed(timeUsed);
		custProSum.setDayTimes(oneDaySum);
		custProSum.setDayStandards(oneDayTotal);
		resultList.add(custProSum);
		
		return resultList;
	}
	public List getResourceByDate2(String beginDate, String endDate, String[] resourceIds,String customerId,String mode,String orderBy) {
		
		
//		System.out.println("1111111111111111111111111111111 ");
		
		List resultList = new ArrayList();
		List resList = new ArrayList();
		List resourceIdList = new ArrayList();
		CollectionUtils.addAll(resourceIdList,resourceIds);
		if(StringUtils.isEmpty(customerId)|| customerId=="0") customerId = null;

		Map resMap = new HashMap();
		resMap.put("beginDate",beginDate);
		resMap.put("endDate",endDate);
		resMap.put("resourceIdList",resourceIdList);
		resMap.put("customerId",customerId);
		resMap.put("orderBy",orderBy);
				
		if(customerId != null){
			resList = dao.getUsedTimeByCustomer(resMap);

		}else{

			resList = dao.getResourceByDate(resMap);

		}
		
//		List resList = dao.getResourceByDate(resMap);

		List newList = getNewListByIdList(resList,orderBy);
		
//		Collections.sort(newList,new CustomerProductComparator());

//   统计求合用
		Double[] oneDaySum = new Double[31];
		Double[] oneDayTotal = new Double[31];
		
		double totalSum = 0;
		double totalSumTime = 0;
		for(Iterator it = newList.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			Long resId = customerProduct.getResourceId();
			String month = customerProduct.getMonth();
			String resName = customerProduct.getResourceName();
			String resMemo = customerProduct.getResourceMeno();
			Integer displayNo = customerProduct.getDisplayNo();

			
//			System.out.println("resId = " + resId);
//			System.out.println("month = " + month);
//			System.out.println("resName = " + resName);
			
			double totalTime = getTotalByIdListMonthAndResId(resList,resId,month);
			double sumTime = getSumUsedByIdListMonthAndResId(resList,resId,month);
			
			totalSum += totalTime;
			totalSumTime += sumTime;
			String total = totalTime + "";
			String sumUsed = sumTime + "";
//			getDayTimesByIdListMonthAndResId(resList,resId,month,oneDaySum,mode);
//			System.out.println("yyyyy>>>"+totalSumTime);		
			CustomerProduct custPro = new CustomerProduct();
			
//			custPro.set
			custPro.setResourceName(resName);
			custPro.setResourceMeno(resMemo);
			custPro.setDisplayNo(displayNo);
			
			custPro.setMonth(month);
			custPro.setStandardTime(customerProduct.getStandardTime());
			custPro.setTotal(total);
			if(mode.equals("2")){
				sumUsed = String.valueOf(Double.valueOf(total).doubleValue()- Double.valueOf(sumUsed).doubleValue());
			}
			custPro.setSumUsed(sumUsed);
//			custPro.setTimeUsed(timeUsed);
//			custPro.setDayTimes(dayTimes);
			getDayTimesByIdListMonthAndResId(custPro,resList,resId,month,oneDaySum,oneDayTotal,mode);
			
			
			resultList.add(custPro);
		}
		Collections.sort(resultList);
		DecimalFormat df = new DecimalFormat("#.##");
		CustomerProduct custProSum = new CustomerProduct();
		
//		System.out.println(totalSum+"  ddd "+totalSumTime);
		custProSum.setResourceName("合计");
		custProSum.setResourceMeno("合计");
		custProSum.setMonth("          ");
		
		custProSum.setTotal(df.format(totalSum));
		if(mode.equals("2")){
			  totalSumTime = totalSum - totalSumTime;  
		}
		custProSum.setSumUsed(df.format(totalSumTime));
//		custPro.setTimeUsed(timeUsed);
		custProSum.setDayTimes(oneDaySum);
		custProSum.setDayStandards(oneDayTotal);
		resultList.add(custProSum);
		
		return resultList;
	}
	
private List getResourceBy_Date(String beginDate, String endDate, String[] resourceIds,String customerName,String mode,String orderBy) {
		
		
//		System.out.println("1111111111111111111111111111111 ");
		
		List resultList = new ArrayList();
		List resourceIdList = new ArrayList();
		CollectionUtils.addAll(resourceIdList,resourceIds);
//		if(StringUtils.isEmpty(customerId)|| customerId=="0") customerId = null;
		if(StringUtils.isEmpty(customerName)|| customerName=="0") customerName = null;
		Map resMap = new HashMap();
		resMap.put("beginDate",beginDate);
		resMap.put("endDate",endDate);
		resMap.put("resourceIdList",resourceIdList);
//		resMap.put("customerId",customerId);
		resMap.put("customerName",customerName); 
		resMap.put("orderBy",orderBy);
		
		
		List resList = new ArrayList();
//		List resUsedList = new ArrayList();
//		List newList = new ArrayList();
		
//		resList = dao.getUsedTimeByCustomer(resMap);
		
		
		
		
		if(customerName != null){
			resList = dao.getUsedTimeByCustomer(resMap);
//			System.out.println("resUsedList size>>>>>>>>>>>>>>>" + resUsedList.size());
//			newList = getNewListByIdList(resUsedList);
//			System.out.println("resUsedList size>>>>>>>>>>>>>>>" + resList.size());
//			CollectionUtils.addAll(newList,resUsedList.iterator());
		}else{
//			CollectionUtils.addAll(resUsedList,resList.iterator());
//			newList = getNewListByIdList(resList);
//			CollectionUtils.addAll(newList,resList.iterator());
			resList = dao.getResourceByDate(resMap);
//			System.out.println("resList size>>>>>>>>>>>>>>>" + resList.size());
		}
		
		
		
	
		
		List newList = getNewListByIdList(resList,orderBy);
		
//		Collections.sort(newList,new CustomerProductComparator());
		

//   统计求合用
		Double[] oneDaySum = new Double[31];
		Double[] oneDayTotal = new Double[31];
		double totalSum = 0;
		double totalSumTime = 0;
		for(Iterator it = newList.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			Long resId = customerProduct.getResourceId();
			String month = customerProduct.getMonth();
			String resName = customerProduct.getResourceName();
			String resMemo = customerProduct.getResourceMeno();
			Integer displayNo = customerProduct.getDisplayNo();
			Integer broadcastStartTime = customerProduct.getBroadcastStartTime();

//			String standardTime = customerProduct.getTotal();
			
			
//			System.out.println("resId = " + resId);
//			System.out.println("month = " + month);
//			System.out.println("resName = " + resName);
			
			double totalTime = getTotalByIdListMonthAndResId(resList,resId,month);
			double sumTime = getSumUsedByIdListMonthAndResId(resList,resId,month);
			
			totalSum += totalTime;
			totalSumTime += sumTime;
			String total = totalTime + "";
			String sumUsed = sumTime + "";
			
//			System.out.println("yyyyy>>>"+totalSumTime);		
			CustomerProduct custPro = new CustomerProduct();
			
//			custPro.set
			custPro.setResourceName(resName);
			custPro.setResourceMeno(resMemo);
			custPro.setDisplayNo(displayNo);
			custPro.setStandardTime(customerProduct.getStandardTime());
			custPro.setBroadcastStartTime(broadcastStartTime);
			custPro.setBroadcastEndTime(new Integer(broadcastStartTime.intValue()+customerProduct.getStandardTime().intValue()));
			custPro.setMonth(month);
			custPro.setResourceId(customerProduct.getResourceId());
//			custPro.setStandardTime(new Double(standardTime));
			custPro.setTotal(total);
			if(mode.equals("2")){
				sumUsed = String.valueOf(Double.valueOf(total).doubleValue()- Double.valueOf(sumUsed).doubleValue());
			}
			custPro.setSumUsed(sumUsed);
//			custPro.setTimeUsed(timeUsed);
//			custPro.setDayTimes(dayTimes);
			getDayTimesByIdListMonthAndResId(custPro,resList,resId,month,oneDaySum,oneDayTotal,mode);
			
			custPro.setOrderBy(customerProduct.getOrderBy());
			
			resultList.add(custPro);
		}
//		Collections.sort(resultList);
		
		Collections.sort(resultList,new CustomerProductComparator());
		
		DecimalFormat df = new DecimalFormat("#.##");
		CustomerProduct custProSum = new CustomerProduct();
		
//		System.out.println(totalSum+"  ddd "+totalSumTime);
		custProSum.setResourceName("合计");
		custProSum.setResourceMeno("合计");
		custProSum.setMonth("          ");
		custProSum.setTotal(df.format(totalSum));
		if(mode.equals("2")){
			  totalSumTime = totalSum - totalSumTime;  
    	 }
		custProSum.setSumUsed(df.format(totalSumTime));
//		custPro.setTimeUsed(timeUsed);
		custProSum.setDayTimes(oneDaySum);
		custProSum.setDayStandards(oneDayTotal);
		resultList.add(custProSum);
		
		return resultList;
	}
	

private Map  getStandTime(List ls){
	Map standTimeMap = new HashMap();
	for (Iterator it = ls.iterator();it.hasNext();){
		CustomerProduct customerProduct = (CustomerProduct) it.next();
		String standTime = customerProduct.getTotal();
		standTime = standTime == null||standTime.equals("")?"0":standTime;
		String month = customerProduct.getPublishDate().toString().substring(0,6);
		Long resId = customerProduct.getResourceId();
		String key = resId.toString().concat(month);
		boolean fined =false;
		if(Double.parseDouble(standTime) > 0){
			standTimeMap.put(key,standTime);
		}else{
			standTimeMap.put(key,"0");
		}
		
	}
	
	return standTimeMap;
}
	private List getNewListByIdList(List ls,String orderBy){
		List list = new ArrayList();
		Map resourceMap = new HashMap();
		Map standTimeMap = 	getStandTime(ls);
		
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			Long resId = customerProduct.getResourceId();
			String month = customerProduct.getPublishDate().toString().substring(0,6);

			String resName = customerProduct.getResourceName();
			String resMemo = customerProduct.getResourceMeno();
			Integer displayNo = customerProduct.getDisplayNo();
//			String standTime = customerProduct.getTotal();
//			standTime = standTime == null||standTime.equals("")?"0":standTime;
			Integer broadcastStartTime = customerProduct.getBroadcastStartTime();

			String key = resId.toString().concat(month);

			if(! resourceMap.containsKey(key)){
				    String standTime =(String)standTimeMap.get(key);
					resourceMap.put(key,month);
					CustomerProduct cusProduct = new CustomerProduct();
					cusProduct.setResourceId(resId);
					cusProduct.setMonth(month);
					cusProduct.setResourceName(resName);
					cusProduct.setResourceMeno(resMemo);
					cusProduct.setDisplayNo(displayNo);
					cusProduct.setStandardTime(Double.valueOf(standTime));
					cusProduct.setBroadcastStartTime(broadcastStartTime);
					cusProduct.setOrderBy(orderBy);
					
					list.add(cusProduct);
		
			}
		}
		return list;
	}
	
	private double getTotalByIdListMonthAndResId(List ls,Long resId,String month){
		double total = 0;
		for(Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct cusPro = (CustomerProduct) it.next();
			
			Long resourceId = cusPro.getResourceId();
			String resMonth = cusPro.getPublishDate().toString().substring(0,6);
			
			if(resourceId.longValue() == resId.longValue() && resMonth.equals(month)){
				
				String singalTotal = cusPro.getTotal() == "" ? "0" : cusPro.getTotal();

				total += Double.parseDouble(singalTotal);
			}
		}
		
		return total;
	}
	
	private double getSumUsedByIdListMonthAndResId(List ls,Long resId,String month){
		
		double sumUsed = 0;
		
		for(Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct cusPro = (CustomerProduct) it.next();

			Long resourceId = cusPro.getResourceId();
			String resMonth = cusPro.getPublishDate().toString().substring(0,6);

			if(resourceId.longValue() == resId.longValue() && resMonth.equals(month)){
//				System.out.println("xxxx>>>"+cusPro.getUsed());
		//		String used = cusPro.getUsed();
//				System.out.println(used.equals(""));
//				System.out.println(used== null);
			
				String used = cusPro.getUsed().equals("") ? "0" : cusPro.getUsed();
				sumUsed += Double.parseDouble(used);						
			}
		}
		
		return sumUsed;
	}
	
	private void getDayTimesByIdListMonthAndResId(CustomerProduct custPro,List ls,Long resId,String month,Double[] oneDaySum,Double[] oneDayTotal,String mode){
		Double[] dayTimes = new Double[31];
		Double[] dayStandards = new Double[31];
//		boolean fined = false;
		for(Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct cusPro = (CustomerProduct) it.next();

			Long resourceId = cusPro.getResourceId();
			String resMonth = cusPro.getPublishDate().toString().substring(0,6);
			
			int day = Integer.parseInt(cusPro.getPublishDate().toString().substring(6,8));
		
			if(resourceId.longValue() == resId.longValue() && resMonth.equals(month)){
				String stand = cusPro.getTotal();
				stand = stand.equals("")||stand == null?"0":stand;
//				if(Integer.parseInt(stand)>0 && !fined){
//					fined = true;
//					custPro.setStandardTime(new Double(Integer.parseInt(stand)));
//				}else{
//					custPro.setStandardTime(new Double("0"));
//				}
				
				for(int i = 0;i<dayTimes.length;i++){
					if(day == i+1){
						
						
						
						String used = cusPro.getUsed().equals("") ? "0" : cusPro.getUsed();
						String totalStr = cusPro.getTotal();
						totalStr = totalStr == null||"".equals(totalStr)?"0":totalStr;
						dayStandards[i] =new Double(Double.parseDouble(totalStr));
					
						dayTimes[i] = new Double(Double.parseDouble(used)); 
						
						  if(mode.equals("2")){
							  dayTimes[i] = new Double(dayStandards[i].doubleValue() - dayTimes[i].doubleValue());  
				    	   }
						oneDaySum[i] = oneDaySum[i]==null?new Double(0):oneDaySum[i];
						oneDaySum[i] = new Double(oneDaySum[i].doubleValue() + dayTimes[i].doubleValue());
						
						oneDayTotal[i] = oneDayTotal[i]==null?new Double(0):oneDayTotal[i];
						oneDayTotal[i] = new Double(oneDayTotal[i].doubleValue() + dayStandards[i].doubleValue());
						//oneDayTotal[i] = dayStandards[i];
					
						
//			    		   kk = customerProduct.getDayStandards()[i];
//			    		   if(kk == null) kk = new Double("0.0");
//			    		   kk = new Double(kk.doubleValue() - ff.doubleValue());
						
					
						
						
//						oneDaySum[i] = oneDaySum[i].doubleValue() + dayTimes[i].doubleValue();
						//System.out.println(">>>>>>>>>>>>>>>day"+day);
//						System.out.println(i+ ">>>>>>>>>>>>>"+dayTimes[i]);
						
					}
					
					
				}
			}
		}
		
		custPro.setDayTimes(dayTimes);
		custPro.setDayStandards(dayStandards);
		
		
//		return dayTimes;
	}
	public String getCarrierScopeCount(String startDate, String endDate,String[] carrierIds, String userId,String curUserName, String isPrint) {
		Map map =new HashMap();
		List carrierIdList =new ArrayList();
		List userIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		List ls = new ArrayList();
		List parentIdList = new ArrayList();
		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("carrierIdList",carrierIdList);
//		map.put("parentId",carrierName);

		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			ls = userManager.getOwnerUsersList(userRelsMap);
    		}else{//打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		
		return new Integer(dao.getCarrierByDate(map).size()).toString();
	}

	public String getTreeGrid(String orgId,String weekIds,String beginDate,String endDate,String[] resourceIds,String customerName,String mode,String orderBy){
		StringBuffer sb = new StringBuffer();
		List all = this.getResourceBy_Date(beginDate,endDate,resourceIds,customerName,mode,orderBy);
//		Collections.sort(all,new PublishArrangeComparator());
		String orgType = SysParamUtil.getOrgTypeById(orgId);
//		Collections.sort(all,new CustomerProductComparator());
		CustomerProductUtil.makeTreeGridXML(sb,all,mode,orgType,weekIds); 
//		System.out.println("44444444>>>>>>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>>  " +sb.toString());
		return sb.toString();
	}
	

	
	
	public String getResourceLimit61(String beginDate,String endDate,String startTime,String endTime,String carrierId,String customerId,String mode,String orderBy){
		
		StringBuffer sb = new StringBuffer();
		List all = this.getResourceLimitsBy61(beginDate,endDate,startTime,endTime,carrierId,customerId,mode,orderBy);
		CustomerProductUtil.makeTreeGridXML_61(sb,all,mode,"1","");
		return sb.toString();
		
	}

	public String getOrderDayInfosPageXML(OrderDayInfo orderDayInfo, String userId, String carrierName, String customerId, int channelModelParam,String theUser) {
		String startDate = orderDayInfo.getStartDate();
		String endDate = orderDayInfo.getEndDate();
		String[] sorStr = orderDayInfo.getResourceSpecific().split(",");
		String putYear = orderDayInfo.getBusinessFirstName();
		String returnValue = orderDayInfo.getBusinessLastName();
		String incomPurs = orderDayInfo.getToaccountTotal();
		String resourceTypeId = StringUtil.getNullValue(orderDayInfo.getResourceType(),"");
		String orgId = StringUtil.getNullValue(orderDayInfo.getOrgId(),"1");
		String weekStr= StringUtil.getNullValue(orderDayInfo.getWeekStr(),"");
	    
		 
		List all = this.getOrderDayInfosPage(orgId,resourceTypeId,startDate,endDate,sorStr[0],sorStr[1],putYear,userId,carrierName,customerId,channelModelParam,theUser,incomPurs,returnValue,weekStr);
		StringBuffer sb = new StringBuffer();
		OrderDayInfoUtil.makeTreeGridXML(sb,all);
		return sb.toString();
	}

	public List getResourceListAudiByDate(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint,String orderSubCategorys) {

		Map map =new HashMap();
		List resourceIdList =new ArrayList();
		List userIdList = new ArrayList(); 
		List orderSubCatesIdList = new ArrayList(); 
		CollectionUtils.addAll(resourceIdList, resourceIds);
		List ls = new ArrayList();
		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("resourceIdList",resourceIdList);
//		map.put("parentId",carrierName);
		
		String orderSubCategory = StringUtil.getNullValue(orderSubCategorys,"");
		if(!"".equals(orderSubCategory)){
			String orderSubCates[] = orderSubCategory.split(",");
			CollectionUtils.addAll(orderSubCatesIdList, orderSubCates);
			map.put("orderSubCatesIdList",orderSubCatesIdList);
		}	
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
//    			ls = userManager.getOwnerUsersList(userRelsMap);
    			ls =(List)userRelsMap.get(curUserName);
    		}else{//打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		List result =dao.getResourceListByDate(map);

//		Map inputonMap = incomeUsedManager.getScopeResourcesPutonMoney(map);
		Map inputonMap = incomeUsedManager.getScopeResourcesPutonMoney(map);
//		
		double resultTotal[]=new double[3];
		
 		for(Iterator it =result.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();
			
			Long carrId = orderDayInfo.getCarrier().getId();

			Object obj = inputonMap.get(carrId);
			
			if(obj==null) {
				
				orderDayInfo.setDayRelPuton(new Double(0));
			}else{
				orderDayInfo.setDayRelPuton((Double)obj);
			}

			resultTotal[0]+=orderDayInfo.getDayRelPuton().doubleValue();
			resultTotal[1]+=orderDayInfo.getDayRelIncome().doubleValue();
			resultTotal[2]+=orderDayInfo.getAdSumTimes().doubleValue();
			
			Long parentId = orderDayInfo.getParentId();
			Map carrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
			List list = (List) carrierRelsMap.get(parentId);
			String channel = "";
			for(Iterator iter = list.iterator();iter.hasNext();){
				Carrier carrier = (Carrier)iter.next();
				channel = carrier.getCarrierName()+"/"+channel;
			}
			orderDayInfo.setToaccountTotal(channel);
			
		}
 		
 		OrderDayInfo resultOderDayInfo =new OrderDayInfo();
 		Carrier  carrier=new Carrier();

		carrier.setCarrierName("合计");
 		resultOderDayInfo.setCarrier(carrier);
 		resultOderDayInfo.setToaccountTotal("");
 		resultOderDayInfo.setResourceSpecific("");
 		resultOderDayInfo.setDayRelIncome(new Double(resultTotal[1]));
 		resultOderDayInfo.setDayRelPuton(new Double(resultTotal[0]));
 		resultOderDayInfo.setAdSumTimes(new Double(resultTotal[2]));
 		
        result.add(resultOderDayInfo);
        
		return result;
	}
	

	public List getResourceListByDate(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint,String orderSubCategorys) {

		Map map =new HashMap();
		
		Map mapChild =new HashMap();
		Map mapResourceCustomer = new HashMap();
		List allList = new ArrayList();
		List orderSubCatesIdList = new ArrayList();
		List resourceIdList =new ArrayList();
		List userIdList = new ArrayList();
		CollectionUtils.addAll(resourceIdList, resourceIds);
		List ls = new ArrayList();
		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("resourceIdList",resourceIdList);
//		map.put("parentId",carrierName);
		
		String orderSubCategory = StringUtil.getNullValue(orderSubCategorys,"");
		if(!"".equals(orderSubCategory)){
			String orderSubCates[] = orderSubCategory.split(",");
			CollectionUtils.addAll(orderSubCatesIdList, orderSubCates);
//			map.put("orderSubCatesIdList",orderSubCatesIdList);
		}	
		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
//    			ls = userManager.getOwnerUsersList(userRelsMap);
    			ls =(List)userRelsMap.get(curUserName);
    		}else{//打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		
//		System.out.println("fffffvvvvvbbbb>>>>>  userIdList  "+userIdList) ;
//		System.out.println("fffffvvvvvbbbb>>>>>  orderSubCatesIdList  "+orderSubCatesIdList) ;
//		System.out.println("fffffvvvvvbbbb>>>>>  orderSubCategory  "+orderSubCategory) ;
		
		
		List result =dao.getScopeResourcesCustomer(map);
		
		
		System.out.println("fffffvvvvvbbbb>>>>>  userIdList  "+result.size()) ;

//		Map inputonMap = incomeUsedManager.getScopeResourcesPutonMoney(map);
		Map inputonMap = incomeUsedManager.getScopeIdPutonMoney(map);
//		
//		double resultTotal[]=new double[3];
		
 		for(Iterator it =result.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();
			
			Long carrId = orderDayInfo.getCarrier().getId();
			String key1 = carrId.toString()+ orderDayInfo.getCustomerId();
			Object obj = inputonMap.get(key1);
			
			if(obj==null) {
				
				orderDayInfo.setDayRelPuton(new Double(0));
			}else{
				orderDayInfo.setDayRelPuton((Double)obj);
			}

//			resultTotal[0]+=orderDayInfo.getDayRelPuton().doubleValue();
//			resultTotal[1]+=orderDayInfo.getDayRelIncome().doubleValue();
//			resultTotal[2]+=orderDayInfo.getAdSumTimes().doubleValue();
			
			Long parentId = orderDayInfo.getParentId();
			Map carrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
			List list = (List) carrierRelsMap.get(parentId);
			String channel = "";
			for(Iterator iter = list.iterator();iter.hasNext();){
				Carrier carrier = (Carrier)iter.next();
				channel = carrier.getCarrierName()+"/"+orderDayInfo.getCarrier().getCarrierName();
			}
			orderDayInfo.setToaccountTotal(channel);
			
			

//			求每个资源下的合计
			getResourceCustomerSum(orderDayInfo,mapResourceCustomer);
			
			orderDayInfo.setResourceSpecific("");
			orderDayInfo.setToaccountTotal("");
			orderDayInfo.getCarrier().setCarrierName("");
			String key = carrId.toString();
			if(mapChild.containsKey(key)){
				List ls2 = (List)mapChild.get(key);
				ls2.add(orderDayInfo);
				mapChild.put(key,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(orderDayInfo);
				mapChild.put(key,ls2);
			}
		}
 		

		for (Iterator it = mapChild.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			List cutList = (List)mapChild.get(key);
//			System.out.println("cutList<<<<<<<<<<<<<<11111<<<<<<<<<<<"+cutList.size());
			OrderDayInfo orderDInfo = (OrderDayInfo)cutList.get(0);
			
			OrderDayInfo orderDayI = (OrderDayInfo)mapResourceCustomer.get(key);
			orderDInfo.setResourceSpecific(orderDayI.getResourceSpecific());
			orderDInfo.setToaccountTotal(orderDayI.getToaccountTotal());
			
			
			for(Iterator itl = cutList.iterator();itl.hasNext();){
				OrderDayInfo ODayInfo =  (OrderDayInfo)itl.next();
//				System.out.println("ODayInfo.getCustomer().getCustomerName()<<<<<<<<<<<222222222222<<<<<<<<<<"+ODayInfo.getCustomer().getCustomerName());
				ODayInfo.setBusinessFullName(ODayInfo.getCustomer().getCustomerName());
				
			}
			orderDayI.setResourceSpecific("");
			orderDayI.getCarrier().setCarrierName("");
			orderDayI.setToaccountTotal("");
			cutList.add(orderDayI);
			CollectionUtils.addAll(allList,cutList.iterator());
		}
		return allList;
	}
	
	public String getResourceListByDateXML(String startDate, String endDate, String[] resourceIds, String userId, String curUserName, String isPrint,String orderSubCategorys,String weekStr) {

		Map mp = getResourceMapByDate(startDate,endDate,resourceIds,userId,curUserName,isPrint,orderSubCategorys,weekStr);
		
		return OrderDayInfoUtil.makeTreeGridXML4(mp);
	}
	
	public Map getResourceMapByDate(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint,String orderSubCategorys,String weekStr) {

		Map map =new HashMap();
		List resourceIdList =new ArrayList();
		List userIdList = new ArrayList();
		List orderSubCatesIdList = new ArrayList();
		CollectionUtils.addAll(resourceIdList, resourceIds);
		List ls = new ArrayList();
		
		
		if(!"".equals(weekStr) && weekStr != null){
			List inWeekDates = new ArrayList();
			DateUtil.getWeekDates(startDate,endDate,weekStr,inWeekDates);
//			System.out.println("日期>>" + inWeekDates);
			map.put("inWeekDates",inWeekDates);
		}
		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("resourceIdList",resourceIdList);
//		map.put("parentId",carrierName);
		
		String orderSubCategory = StringUtil.getNullValue(orderSubCategorys,"");
		
		if(!"".equals(orderSubCategory)){
			String orderSubCates[] = orderSubCategory.split(",");
			CollectionUtils.addAll(orderSubCatesIdList, orderSubCates);
			map.put("orderSubCatesIdList",orderSubCatesIdList);
		}
		
		
		
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		
		if(financialAuditSwitch){
			
		
			
			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(startDate.substring(0,4));
			
//			System.out.println("getCarrierByDate **************OrderCategoryIdList ******************************* >>>>>>>>>>>>>>>>>>   "+OrderCategoryIdList) ;
		
			if(OrderCategoryIdList.size() > 0){
//				交集的补集
//				System.out.println("getCarrierByDate ********************************************* >>>>>>>>>>>>>>>>>>   "+orderSubCatesIdList) ;
//				System.out.println("getCarrierByDate ********************************************* >>>>>>>>>>>>>>>>>>   "+OrderCategoryIdList) ;
			    
//				交集
				Collection   intersectionList  =  CollectionUtils.intersection(orderSubCatesIdList, OrderCategoryIdList);
				
//				System.out.println("getCarrierByDate ********************************************* >>>>>>>>>>>>>>>>>>   "+intersectionList) ;
				  
				map.put("orderSubCatesIdList",intersectionList);
			}
		}	
		
		
		
		
//		System.out.println("orderSubCatesIdList>33333333333333333333333333333333333333333333333>>>>"+orderSubCatesIdList) ;
		
		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
//    			ls = userManager.getOwnerUsersList(userRelsMap);
    			ls =(List)userRelsMap.get(curUserName);
    		}else{//打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		map.put("UserIdList",userIdList);
    	}
		
     	if(UserUtil.isUserOrderYearRel()) {
     		map.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
		List result =dao.getScopeResourcesCustomer(map);

//		Map inputonMap = incomeUsedManager.getScopeResourcesPutonMoney(map);
		Map inputonMap = incomeUsedManager.getScopeIdPutonMoney(map);
		return getResourceMapDetail(result,inputonMap);
	}
	
	
	
	
	private Map getResourceMapDetail(List result,Map inputonMap){
		Map map = new HashMap();
		Map mapResourceCustomer = new HashMap();
		
 		for(Iterator it =result.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();
			
			Long carrId = orderDayInfo.getCarrier().getId();
			String key1 = carrId.toString()+ orderDayInfo.getCustomerId();
			Object obj = inputonMap.get(key1);
			
			if(obj==null) {
				
				orderDayInfo.setDayRelPuton(new Double(0));
			}else{
				orderDayInfo.setDayRelPuton((Double)obj);
			}
			
			Long parentId = orderDayInfo.getParentId();
			Map carrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
			List list = (List) carrierRelsMap.get(parentId);
			String channel = "";
			for(Iterator iter = list.iterator();iter.hasNext();){
				Carrier carrier = (Carrier)iter.next();
				channel = carrier.getCarrierName()+"/"+orderDayInfo.getCarrier().getCarrierName();
			}
			orderDayInfo.setToaccountTotal(channel);

//			求每个资源下的合计
			getResourceCustomerSum(orderDayInfo,mapResourceCustomer);
			
			orderDayInfo.setResourceSpecific("");
			orderDayInfo.setToaccountTotal("");
			String key = carrId.toString();
			if(map.containsKey(key)){
				List ls2 = (List)map.get(key);
				ls2.add(orderDayInfo);
				map.put(key,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(orderDayInfo);
				map.put(key,ls2);
			}
		}
 		map.put("mapResourceCustomer",mapResourceCustomer);
		return map;
	}
	public List getCarrierByDatePandect(String startDate, String endDate, String[] resourceIds, String userId, String curUserName, String isPrint){
		List list = new ArrayList();
		Map map = getResourceMapByDate(startDate,endDate,resourceIds,userId,curUserName,isPrint,null,null);
		Map mapResourceCustomer = (Map)map.get("mapResourceCustomer");
		double res[] = new  double[3];
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapResourceCustomer")){
				OrderDayInfo obj = (OrderDayInfo)mapResourceCustomer.get(key);
				String ToaccountTotal = obj.getToaccountTotal();
				String ToaccountTotal1 = ToaccountTotal+"1111" ;
				Double relIncome = obj.getDayRelIncome();
				Double putOn = obj.getDayRelPuton();
				Double times = obj.getAdSumTimes();
				res[0] += relIncome.doubleValue();
				res[1] += putOn.doubleValue();
				res[2] += times.doubleValue();			
				
//				String relComeScale = StringUtil.persentFormat(relIncome.doubleValue(),sum);
//				obj.setResourceName(key);
				obj.setToaccountTotal(ToaccountTotal1);
				obj.getCustomer().setCustomerName("");
//				obj.setSumUsed(relComeScale);
				list.add(obj);
			}
		}
		if(map.size()>0){
			OrderDayInfo orderDInfo = new OrderDayInfo();
			orderDInfo.setToaccountTotal("                                  ");
			orderDInfo.setResourceSpecific("合计:");
			orderDInfo.getCustomer().setCustomerName("");
			orderDInfo.setDayRelIncome(new Double(res[0]));
			orderDInfo.setDayRelPuton(new Double(res[1]));
			orderDInfo.setAdSumTimes(new Double(res[2]));
			list.add(orderDInfo);
		}
		return list ;
	}
	private void getResourceCustomerSum(OrderDayInfo orderDayInfo,Map mapResourceCustomer){
		String key = orderDayInfo.getCarrier().getId().toString();
		Object obj  = mapResourceCustomer.get(key);
//		List cutList = (List)mapIndustryType.get(key);
		if(obj == null) {
			OrderDayInfo orderDInfo =  new OrderDayInfo();
			orderDInfo.setToaccountTotal(orderDayInfo.getToaccountTotal());
			orderDInfo.setResourceSpecific(orderDayInfo.getResourceSpecific());
			orderDInfo.getCustomer().setCustomerName("小计");
			orderDInfo.setDayRelIncome(orderDayInfo.getDayRelIncome());
			orderDInfo.setDayRelPuton(orderDayInfo.getDayRelPuton());
			orderDInfo.setAdSumTimes(orderDayInfo.getAdSumTimes());
			mapResourceCustomer.put(key,orderDInfo);
		}else{
			OrderDayInfo  orderDInfo = (OrderDayInfo)obj;
			double relIncome = orderDInfo.getDayRelIncome().doubleValue();
			double putOn = orderDInfo.getDayRelPuton().doubleValue();;
			double times = orderDInfo.getAdSumTimes().doubleValue();	
			orderDInfo.setDayRelIncome(new Double(relIncome+orderDayInfo.getDayRelIncome().doubleValue()));
			orderDInfo.setDayRelPuton(new Double(putOn+orderDayInfo.getDayRelPuton().doubleValue()));
			orderDInfo.setAdSumTimes(new Double(times+orderDayInfo.getAdSumTimes().doubleValue()));
//			makeChiled(cutList,key,relIncome);
			mapResourceCustomer.put(key,orderDInfo);
		}
	}

	public List getResourceByDate(String beginDate, String endDate, String[] resourceIds) {
		return null;
	}
	
	
	public String getAllYearCarrierXML(String year, String[] carrierIds, String userId, String curUserName,String type, String isPrint) {
		List ls = new ArrayList();
		if(type.equals("1")){
			ls = this.getAllYearCarrier(year, carrierIds, userId, curUserName,isPrint);
			Map mp = getAllYearCarrierMap(ls);
			return makeCarrAllYearGridXML(mp);
		}else{
			ls = getAllYearCarrierRelPuton(year, carrierIds, userId, curUserName,isPrint);
//			List ls = this.getAllYearCarrier(year, carrierIds, userId, curUserName,isPrint);
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");
	        int k = 0;
			for (Iterator it = ls.iterator(); it.hasNext();) {
				OrderDayInfo obj = (OrderDayInfo) it.next();
				sb.append("<row  id=\"" + k++ + "\"" + ">");
				sb.append("<cell BgColor='red'><![CDATA[" + obj.getCarrier().getCarrierName() + "]]></cell>");
				String[] month = obj.getMonth();
				for (int i = 1; i < 14; i++) {
					String s = StringUtil.doubleFormat3(new Double(month[i]));
					sb.append("<cell><![CDATA[" + s + "]]></cell>");
				}
	
				sb.append("</row>");
			}
			sb.append("</rows>");
			return sb.toString();
		}
	}
	public Map getAllYearCarrierMap(List ls){
		Map map = new HashMap();
		Map mapCarrierName = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();
			String carrierName = orderDayInfo.getCarrier().getCarrierName() ;
			String carr[] = carrierName.split("/");
			String chanName = carr[0];

			//求每个频道的合计
			if(chanName.equals("合计")){
				map.put("heji",orderDayInfo);
			}else{
				getAllYearCarrierSum(orderDayInfo,mapCarrierName,chanName);
				if(map.containsKey(chanName)){
					List ls2 = (List)map.get(chanName);
					ls2.add(orderDayInfo);
					map.put(chanName,ls2);
				}else{
					List ls2 = new ArrayList();
					ls2.add(orderDayInfo);
					map.put(chanName,ls2);
				}
			}
		}
		map.put("mapCarrierName",mapCarrierName);
		return map;
	}
	private void getAllYearCarrierSum(OrderDayInfo orderDayInfo,Map mapCarrierName,String key){
		Object obj  = mapCarrierName.get(key);
		String ss[] = new String[14];
		if(obj == null) {
			OrderDayInfo ordInfo =  new OrderDayInfo();
			ordInfo.getCarrier().setCarrierName(key);
			ordInfo.setMonth(orderDayInfo.getMonth()) ;
			mapCarrierName.put(key,ordInfo);
		}else{
			OrderDayInfo ordInfo = (OrderDayInfo)obj;
			String[] month = ordInfo.getMonth();
			String[] month1 = orderDayInfo.getMonth();
			for (int i = 1; i < 14; i++) {
				double a = new Double(month[i]).doubleValue();
				double b = new Double(month1[i]).doubleValue();
				ss[i] = new Double(a + b).toString();
			}
			ordInfo.setMonth(ss);
			mapCarrierName.put(key,ordInfo);
		}
	}
	
	public List getAllYearCarrierPandect(String year, String[] carrierIds, String userId, String curUserName,String isPrint){
		List list = new ArrayList();
		List ls = this.getAllYearCarrier(year, carrierIds, userId, curUserName,isPrint);
		Map map = getAllYearCarrierMap(ls);
		Map mapCarrierName = (Map)map.get("mapCarrierName");
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapCarrierName")&&!key.equals("heji")){
				OrderDayInfo obj = (OrderDayInfo)mapCarrierName.get(key);	
				list.add(obj);
			}
		}
		OrderDayInfo orderDayInfo = (OrderDayInfo)map.get("heji");	
		list.add(orderDayInfo);
		return list ;
	}
	
	public static  String makeCarrAllYearGridXML(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		Map mapCarrierName = (Map)map.get("mapCarrierName");
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapCarrierName")&&!key.equals("heji")){
				OrderDayInfo obj = (OrderDayInfo)mapCarrierName.get(key);	
				List resultList = (List)map.get(key);
				sb.append("<row  id=\""+ key +"\">");
				sb.append("<cell image=\"folder.gif\">"+ key +"</cell>");
				String[] month = obj.getMonth();
				for (int i = 1; i < 14; i++) {
					String s = StringUtil.doubleFormat3(new Double(month[i]));
					sb.append("<cell><![CDATA[" + s + "]]></cell>");
				}
				makeChiled(resultList,sb,key);
				sb.append("</row>");
			}
		}
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(key.equals("heji")){
				OrderDayInfo orderDayInfo = (OrderDayInfo)map.get(key);	
				sb.append("<row  id=\""+ key +"\">");
				sb.append("<cell>"+ orderDayInfo.getCarrier().getCarrierName() +"</cell>");
				String[] month = orderDayInfo.getMonth();
				for (int i = 1; i < 14; i++) {
					String s = StringUtil.doubleFormat3(new Double(month[i]));
					sb.append("<cell><![CDATA[" + s + "]]></cell>");
				}
				sb.append("</row>");
			}
		}
		sb.append("</rows>");
		return sb.toString();
	}
	private static void makeChiled(List oneCarrList,StringBuffer sb,String key){
		int i=1;
		for (Iterator it = oneCarrList.iterator(); it.hasNext();) {
			OrderDayInfo orderDayInfo = (OrderDayInfo)it.next();

			String carrierName = orderDayInfo.getCarrier().getCarrierName() ;
			if(!carrierName.equals("合计")){
				String carr[] = carrierName.split("/");
				String chanName = carr[0];
				String carrName = carr[1]==null?"":carr[1];

				if(chanName.equals(key)){
					sb.append("<row  id=\""+ key+"_" + i++  +"\">");
					sb.append("<cell image=\"folder.gif\">"+ carrName +"</cell>");
					String[] month = orderDayInfo.getMonth();
					for (int k = 1; k < 14; k++) {
						String s = StringUtil.doubleFormat3(new Double(month[k]));
						sb.append("<cell><![CDATA[" + s + "]]></cell>");
					}
					sb.append("</row>");
				}
			}
		 }	
	}
	public List getAllYearCarrierRelPuton(String year, String[] carrierIds,String userId,String curUserName,String isPrint) {
		List result=new ArrayList();
		Map mp=new HashMap();
		List carrierIdList=new ArrayList();
		List userIdList = new ArrayList();
		List ls = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		Map carrierMap = new HashMap();
		mp.put("year",year);
		mp.put("carrierIdList",carrierIdList);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			ls = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
		
		//判断是否业务员平帐
        if(getIsSignUserBalance()){
        	mp.put("version",new Integer(1));
        }else{
        	mp.put("version",new Integer(0));
        }
		
        
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();

		if(financialAuditSwitch){
			List incomePurposeIdList  = SysParamUtil.getFitterIncomePours(year);
			if(incomePurposeIdList.size()== 0) incomePurposeIdList.add("-1");
			mp.put("incomePurposeIdList",incomePurposeIdList);		
		}

		
		List daoList=dao.getAllYearCarrierRelPuton(mp);
		
		
		Map resultmap=new HashMap();
		
		double total_money = 0.0d;
		Map maap = new HashMap();
		Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
    	for(Iterator it = carrierMp.values().iterator();it.hasNext();){
    		Carrier carr = (Carrier) it.next();
    		maap.put(carr.getId().toString(),carr.getCarrierName());
    	}
		for(Iterator it =daoList.iterator();it.hasNext();){
			Map map=null;
			OrderDayInfo orderDayInfo=(OrderDayInfo)it.next();
			Long carrierId = orderDayInfo.getCarrier().getId();
	    	String carrierName = (String)maap.get(carrierId.toString());
	    	carrierName = carrierName==null?"":carrierName ;
			carrierMap.put(carrierId,carrierName);
			
			int month=Integer.parseInt(orderDayInfo.getPublishDate().toString().substring(4,6));
			
			if (resultmap.containsKey(carrierId)) {
				Map map1 = (Map) resultmap.get(carrierId);
				
				map1.put(new Integer(month), orderDayInfo);
				for (int i = 1; i < 13; i++) {
					if (map1.get(new Integer(i)) == null) {
						map1.put(new Integer(i), null);
					}
				}
				resultmap.put(carrierId, map1);
				
			} else {
				map = new HashMap();
				map.put(new Integer(month), orderDayInfo);

				for (int i = 1; i < 13; i++) {
					if (map.get(new Integer(i)) == null) {
						map.put(new Integer(i), new OrderDayInfo());
					}

				}
				resultmap.put(carrierId, map);
			}	
		}
		
		double colcount[] = new double[14];
		String col[] = new String[14];
		
		for (Iterator it = resultmap.keySet().iterator(); it.hasNext();) {
			Long carrierId = (Long) it.next();
			
			OrderDayInfo temp = new OrderDayInfo();
			Carrier carrier=new Carrier();
			carrier.setId(carrierId);
			carrier.setCarrierName((String)carrierMap.get(carrierId));
			temp.setCarrier(carrier);	

			Map orderDays = (Map) resultmap.get(carrierId);
			
			String ss[] = new String[14];
			double rowcount = 0.0d;
			
			for (int i = 1; i < 13; i++) {

				if (orderDays.get(new Integer(i)) == null) {
					ss[i] = "0";

				} else {
					
					OrderDayInfo orderdayinfos = (OrderDayInfo) orderDays.get(new Integer(i));

					if (orderdayinfos.getDayRelPuton() == null) {
						ss[i] = "0";
					} else {
						ss[i] = orderdayinfos.getDayRelPuton().toString();
					}
				}
				
				colcount[i] += Double.parseDouble(ss[i]);
				rowcount += Double.parseDouble(ss[i]);

			}
			total_money += rowcount;

			ss[13] = String.valueOf(rowcount);

			double total_money1 = 0.0d;
			for (int cov = 1; cov < 13; cov++) {

				total_money1 += colcount[cov];
				col[cov] = String.valueOf(colcount[cov]);
			}
			if (total_money1 == total_money) {
				col[13] = String.valueOf(total_money);

			} else {
				col[13] = "<script language='javaScript'>alert('数据处理有误,请刷新页面')</script>";
			}

			temp.setMonth(ss);
			result.add(temp);
		}
		OrderDayInfo  totalrow =new OrderDayInfo();
		Carrier carrier =new Carrier();

		carrier.setCarrierName("合计");
		totalrow.setCarrier(carrier);
		totalrow.setMonth(col);
		result.add(totalrow);
		return result;
	}
	
	//客户全年统计
	public String getCustomerByYearPageXML(OrderDayInfo orderDayInfo,String year, String[] customerIds, String userId, String carrierName, int channelModelParam,String theUser) {
		String type = orderDayInfo.getId().toString();
		String sortStr = orderDayInfo.getResourceSpecific();
		String isPutYear = orderDayInfo.getBusinessFirstName();
		String returnValue = orderDayInfo.getBusinessLastName();
		String incomPurs = orderDayInfo.getBusinessFullName();
		String resourceTypeId = StringUtil.getNullValue(orderDayInfo.getResourceType(),"");
		String orgId = orderDayInfo.getOrgId().toString();
		
		
		System.out.println("getCustomerByYearPageXML>>>>yyyyyyyyyy 客户全年统计 yyyyyyyyyyyyyy>>>>>customerIds>>>>>"+customerIds) ;	
		
		
		
		List all = this.getCustomerByYearPage(orgId,resourceTypeId,type,sortStr,isPutYear,year,customerIds,userId,carrierName,channelModelParam,theUser,incomPurs,returnValue);
		StringBuffer sb = new StringBuffer();
		OrderDayInfoUtil.makeTreeGridXML3(sb,all);
		return sb.toString();
	}

//业务员统计
	public String getBusinessAnalyzePagesXML(OrderDayInfo orderDayInfo, String userId, String carrierName, boolean isPutOnORIncome, int channelModelParam) {
		String type = orderDayInfo.getId().toString();
		String sortStr = orderDayInfo.getResourceSpecific();
		String startDate = orderDayInfo.getStartDate();
		String endDate = orderDayInfo.getEndDate();
		String theUser	= orderDayInfo.getAdlength();
		String isPutYear = orderDayInfo.getBusinessFirstName();
		String returnValue = orderDayInfo.getBusinessLastName();
		String incomPurs = orderDayInfo.getBusinessFullName();
		String orgId = orderDayInfo.getOrgId().toString();
		
		
		List all = this.getBusinessInfos(orgId,startDate,endDate,type,sortStr,theUser,userId,carrierName,isPutOnORIncome,channelModelParam,isPutYear,returnValue,incomPurs);
		StringBuffer sb = new StringBuffer();
		OrderDayInfoUtil.makeTreeGridXML2(sb,all);
		return sb.toString();
	}

	 public String getCarrierByDateXML(String startDate, String endDate,String[] carrierIds,String userId,String curUserName,String isPrint,String orderCategoryId){
		 List ls = getCarrierByDate(startDate,endDate,carrierIds,userId,curUserName,isPrint,orderCategoryId);
		 return OrderDayInfoUtil.makeTreeGridXML3(ls);
	 }
	
	//时段收视统计
	public String getAudienceListByDateXML(String startDate, String endDate, String[] resourceIds, String userId, String curUserName, String isPrint) {
		List all = getAudienceMap(startDate,endDate,resourceIds,userId,curUserName,isPrint) ;
		return OrderDayInfoUtil.makeTreeGridXML5(all);
	}
	
	public List getAudienceMap(String startDate, String endDate, String[] resourceIds, String userId, String curUserName, String isPrint,String orderSubCategorys){
		List ls = getResourceListAudiByDate(startDate,endDate,resourceIds,userId,curUserName,isPrint,orderSubCategorys);
		//求得资源段的收视resultMap
		Map map =new HashMap();
		Map mp =new HashMap();
		Map resultMap = new HashMap();
		List resourceIdList =new ArrayList();
		List carrierIdList =new ArrayList();
		List orderSubCatesIdList =new ArrayList();
		
		
		CollectionUtils.addAll(resourceIdList, resourceIds);
		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("resourceIdList",resourceIdList);
		mp.put("ResourceIdList",resourceIdList);
		List resourceList = resourceManager.getResourcesIdByIdList(mp);
		for(Iterator it = resourceList.iterator();it.hasNext();){
			Resource obj= (Resource)it.next();
			String resourcesId = obj.getId().toString();
			carrierIdList.add(resourcesId);
		}
		if(carrierIdList.size()==0){
			map.put("carrierIdList","-1");
		}else{
			map.put("carrierIdList",carrierIdList);
		}
		
		
		
		String orderSubCategory = StringUtil.getNullValue(orderSubCategorys,"");
		if(!"".equals(orderSubCategory)){
			String orderSubCates[] = orderSubCategory.split(",");
			CollectionUtils.addAll(orderSubCatesIdList, orderSubCates);
			map.put("orderSubCatesIdList",orderSubCatesIdList);
		}	
		

		List result =dao.getAudienceListByDate(map);
		
		for (Iterator it = result.iterator(); it.hasNext();) {
			OrderDayInfo obj = (OrderDayInfo)it.next();
			String resourceId = obj.getLinkUserId().toString() ;
			
//			int startTime = obj.getIncomeDate().intValue();
//			String total = obj.getAdlength();
//			total = total==null?"0":total;
//			int audienceTime = obj.getAdDayTimes().intValue();
			Double audienceRat = new Double(obj.getBusinessLastName());
			
//			int endTime = startTime + (new Integer(total).intValue())*1000 ;
//			if(audienceTime>=startTime && audienceTime<=endTime){
//				if(!resultMap.containsKey(resourceId)){
					resultMap.put(resourceId,audienceRat);
//				}else{
//					Double audienceRat1 = (Double) resultMap.get(resourceId);
//					Double audienceRats = new Double(audienceRat1.doubleValue()+audienceRat.doubleValue());
//					resultMap.put(resourceId, audienceRats);
//				}
//			}
		}
		//把资源段的收视加入需返回的ls中
		double sum =0;

		for(Iterator it = ls.iterator();it.hasNext();){
			OrderDayInfo obj = (OrderDayInfo) it.next();
			String carrierName = obj.getToaccountTotal()+ obj.getCarrier().getCarrierName() ;
			Long resourceId = obj.getCarrier().getId();
			String resourId = resourceId==null?"":resourceId.toString() ;
			
			Double audienceRat = (Double)resultMap.get(resourId) ;
			audienceRat = audienceRat==null?new Double(0):audienceRat ; 
			sum +=audienceRat.doubleValue();
			obj.setDayStandardPrice(audienceRat) ;
			if(carrierName=="合计" || carrierName.equals("合计")){
				obj.setDayStandardPrice(new Double(sum)) ;	
				break; 
			}
		}
		return ls ;	
	}
	public void setIncomeUsedManager(IncomeUsedManager incomeUsedManager) {
		this.incomeUsedManager = incomeUsedManager;
	}
	
	public Map  getCarrierIncomeByYear(Map mp){
         Map retMp = new HashMap();
		
		List ls = dao.getIncomeMoneyAllCarrier(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			FinanceTarget obj = (FinanceTarget) it.next();
			Double inc = obj.getRelPut();
			
			if(inc == null) inc = new Double(0);
			String key = obj.getCarrierId()+obj.getTargetMonth();
			retMp.put(key,inc);
		}
		return retMp;
		
	}



	public List getAudienceMap(String startDate, String endDate, String[] resourceIds, String userId, String curUserName, String isPrint) {
		// TODO Auto-generated method stub
		return null;
	}

private Map getParamMap(String strQueryString){
	String year = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"year"));
	String orgId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"orgId"));
	String resIds = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"resIds"));
	String type = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"type"));
//	List resourceIdList =new ArrayList();
//
//	CollectionUtils.addAll(resourceIdList, resIds.split(","));
	
	
	
	
	Map resMap = new HashMap();
	resMap.put("type",type);
	resMap.put("year",year);
	resMap.put("orgId",orgId);
//	resMap.put("resourceIdList",resourceIdList);
	return resMap;
}
	public Collection getTreeGridSumCollection(String strQueryString){
		Map resMap =getParamMap(strQueryString);
		String type = (String)resMap.get("type");
		List all  	 = dao.getResourceSumByOrgDate(resMap); 
		System.out.println("type>>>>>>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>>  " +type);
		
		if("report".equals(type)){
			List ls = new ArrayList();
			CustomerProductUtil.makeTreeGridXML_getTreeGridSumReport(all,ls);
			return ls;
		}else{
			return all;
		}

	}
	public String getTreeGridSum(String strQueryString){
		StringBuffer sb = new StringBuffer();
//		Map resMap =getParamMap(strQueryString);
		List all  	 = (List)getTreeGridSumCollection(strQueryString); 
//		Collections.sort(all,new PublishArrangeComparator());
//		String orgType = SysParamUtil.getOrgTypeById(orgId);
//		Collections.sort(all,new CustomerProductComparator());
		CustomerProductUtil.makeTreeGridXML_getTreeGridSum(sb,all,"1"); 
//		System.out.println("44444444>>>>>>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>>  " +sb.toString());
		return sb.toString();

		
	}
	
	
	
	
	 public String getAdversByWorkSpanId(String workSpanId,String  publishDate,String  orgId) {
//    	System.out.println(">>>>>>> adver 11111111111111111111111111111111111111111 mp>>>>>>>" +mp); 
    	List checkedList =new ArrayList();
    	 Map mp = new HashMap();
		 String ctxpath =RequestUtil.getReqInfo().getCtxPath();
		 checkedList.add(workSpanId);
		 mp.put("workSpanIdList",checkedList);
		 mp.put("beginDate",publishDate);
		 mp.put("endDate",publishDate);

    	List ls = dao.getOrderDayInfosAdversByWorkSpanId(mp);
    	StringBuffer sb=new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");
		int i=1; 
		int sum=0;
		String checkState ="";
		boolean isDetailCheck = true;
		
    	for(Iterator it=ls.iterator();it.hasNext();){
    		PublishArrangeDetail publishArrangeDetail=(PublishArrangeDetail)it.next();
    		  String adLen = StringUtil.getNullValue(publishArrangeDetail.getMatterLength(),"0");
    		  String adverTimes = StringUtil.getNullValue(publishArrangeDetail.getAdverTimes(),"0");
    		  sum+= Integer.parseInt(adLen)*Integer.parseInt(adverTimes);

    		  sb.append("<row id=\""+i+"\">");   
	          sb.append("<cell image='leaf.gif'>"+ (i++) +"</cell>");
	          

	  		  sb.append("<cell><![CDATA["+  StringUtil.encodeStringXML(publishArrangeDetail.getMatterName()) +"]]></cell>");
	  		  sb.append("<cell><![CDATA["+   StringUtil.encodeStringXML(publishArrangeDetail.getMatterEdit()) +"]]></cell>");
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(adLen+"*"+adverTimes)+"]]></cell>");
	  		  
//	  		System.out.println(">>>>>>> adver 11111111111111111111111111111111111111111 publishArrangeDetail.getOwnerUserName()>>>>>>>" +publishArrangeDetail.getOwnerUserName()); 
//	  		System.out.println(">>>>>>> adver 11111111111111111111111111111111111111111 publishArrangeDetail.getOwnerUserName()>>>>>>>" +publishArrangeDetail.getFirstName()+publishArrangeDetail.getLastName()); 
	  		
	  		sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getOwnerUserName())+"]]></cell>");
	  		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getCustomerName())+"]]></cell>");
//	  		  sb.append("<cell><![CDATA[" +  StringUtil.null2String(publishArrangeDetail.getOrderCode()) + "]]></cell>");
	  		  
	  		  
	  		  sb.append("<cell><![CDATA[ <a target=_blank href="+ ctxpath +"/editOrder.html?id="+ publishArrangeDetail.getOrderId().toString()+"&orgId="+ orgId+">" +publishArrangeDetail.getOrderCode() +"</a>]]></cell>");
	  		  
	  		  if(isDetailCheck){
	  			checkState = StringUtil.null2String(publishArrangeDetail.getSpecificName());
	  		  }else{
	  			checkState = StringUtil.null2String(publishArrangeDetail.getPublishMemo());
	  		  }
	  		 
	  		  sb.append("<cell><![CDATA["+ checkState +"]]></cell>");
	  		  
	  		  sb.append("</row>");
    	}					
		  sb.append("<row id=\""+i+"\">");   
	      sb.append("<cell image='leaf.gif'>"+ "合计：" +"</cell>");
		  sb.append("<cell><![CDATA["+ "" +"]]></cell>");
		  sb.append("<cell><![CDATA["+ ""+"]]></cell>");
		  sb.append("<cell><![CDATA["+ sum +"]]></cell>");
		  sb.append("<cell>"+ ""+"</cell>");
  		  sb.append("</row>"); 
  		  sb.append("</rows>");
    	              
    	return sb.toString();
    }   



}
