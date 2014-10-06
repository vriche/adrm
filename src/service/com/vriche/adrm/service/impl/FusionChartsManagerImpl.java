package com.vriche.adrm.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.AnalyzeClass;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CustomerAnalyzeColl;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.AnalyseManager;
import com.vriche.adrm.service.FinanceTargetManager;
import com.vriche.adrm.service.FusionChartsManager;
import com.vriche.adrm.service.IncomeUsedManager;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;

public class FusionChartsManagerImpl implements FusionChartsManager {
	
	 private OrderDayInfoManager orderDayInfoManager;
	 private IncomeUsedManager incomeUsedManager;
	 private AnalyseManager analyseManager;
	 private OrderDetailManager orderDetailManager;
	 private FinanceTargetManager financeTargetManager;
	 
	/**
	* @param orderDayInfoManager The orderDayInfoManager to set.
	*/
	public void setOrderDayInfoManager(OrderDayInfoManager orderDayInfoManager) {
			this.orderDayInfoManager = orderDayInfoManager;
	}

	public void setIncomeUsedManager(IncomeUsedManager incomeUsedManager) {
		this.incomeUsedManager = incomeUsedManager;
	}
	
	public void setAnalyseManager(AnalyseManager analyseManager) {
		this.analyseManager = analyseManager;
	}

	public void setOrderDetailManager(OrderDetailManager orderDetailManager) {
		this.orderDetailManager = orderDetailManager;
	}

	public void setFinanceTargetManager(FinanceTargetManager financeTargetManager) {
		this.financeTargetManager = financeTargetManager;
	}
	
	
	public FusionChartObject[] getChartObjs(String queryString, String type) {
	    int i = 0;

		try {
//			System.out.println("getChartObjs queryString<!11111111111111111111<<<<<<<<<<<<<<<<<<"+ queryString);
			
			String chartType =  StringUtil.getParamFromUrl(queryString,"chartType");
			List all = new ArrayList();
			
			if("queryAdres2".equals(chartType)){
				all = (List)ServiceLocator.getResourceManager().getCollectionsForQuery(queryString,type,null);
			}

		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
		    
		    if("queryAdres2".equals(chartType)){
				for(Iterator it = all.iterator();it.hasNext();){
					FusionChartObject fusionChartObject =(FusionChartObject) it.next();
					if(i == all.size()-1) break;
					fusionChartObjects[i++] = fusionChartObject;
				}
		    }

		
			return fusionChartObjects;
		
		} catch (Exception e) {
			e.printStackTrace();
			FusionChartObject fusionChartObjects[] =  new FusionChartObject[0];
			return fusionChartObjects;
		}
	     
		
}
	
	
	
	//	客户区间统计
	public FusionChartObject[] getCustomerChartObjs(String orgId,String resourceTypeId,String startDate ,String endDate,String sorCol,String sorType,String putYear,String userId,String carrierName,String customerId,int channelModelParam,String theUser,String incomPurs,String returnValue,String weekStr) {
		    int i = 0;
		    List all = orderDayInfoManager.getOrderDayInfosPage(orgId,resourceTypeId,startDate,endDate,sorCol,sorType,putYear,userId,carrierName,customerId,channelModelParam,theUser,incomPurs,returnValue,weekStr);
			
		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
		    
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				fusionChartObjects[i++] = setObj(customerColl,fusionChartObject);
			}
		return fusionChartObjects;
	}
	
	public FusionChartObject setObj(CustomerAnalyzeColl customerColl,FusionChartObject fusionChartObject){
		Double realIncom = customerColl.getDayRelIncome() == null?new Double(0):new Double(customerColl.getDayRelIncome());
		Double RelPuton = customerColl.getDayRelPuton() == null?new Double(0):new Double(customerColl.getDayRelPuton());
		fusionChartObject.setLable(customerColl.getCustomerName());
		fusionChartObject.setValue1(StringUtil.doubleFormat3(customerColl.getCustomerIncome()));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(realIncom));
		fusionChartObject.setValue3(StringUtil.doubleFormat2(RelPuton));
		fusionChartObject.setValue4(StringUtil.doubleFormat2(new Double(customerColl.getDayPayMoney())));
		fusionChartObject.setValue5(StringUtil.doubleFormat3(customerColl.getAdSumTimes()));
		return fusionChartObject;
	}

	//客户全年统计
	public FusionChartObject[] getYearChartObjs(String orgId,String resourceTypeId,String year,String type,String sortStr,String putYear,String userId,String carrierName,String[] customerId,int channelModelParam, String theUser, String incomPurs, String returnValue) {
		 int i = 0;
		
		    List all = orderDayInfoManager.getCustomerByYearPage(orgId,resourceTypeId,type,sortStr,putYear,year,customerId,userId,carrierName,channelModelParam,theUser,incomPurs,returnValue);
//			System.out.println("all<!11111111111111111111<<<<<<<<<<<<<<<<<<"+all.size());
		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
//				System.out.println("customerColl<!11111111111111111111<<<<<<<<<<<<<<<<<<"+customerColl.getId());
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				fusionChartObjects[i++] = setYearObj(customerColl,fusionChartObject,type);
			}
		return fusionChartObjects;
	}
	public FusionChartObject setYearObj(CustomerAnalyzeColl customerColl,FusionChartObject fusionChartObject,String type){
		Double realIncom = customerColl.getDayRelIncome() == null?new Double(0):new Double(customerColl.getDayRelIncome());
		Double RelPuton = customerColl.getDayRelPuton() == null?new Double(0):new Double(customerColl.getDayRelPuton());
		String month = "";
		if(type.equals("1")){
			month= StringUtil.converNum2cnMonth(String.valueOf(customerColl.getId()));
		}else{
			month=  customerColl.getCustomerName();
		}
		fusionChartObject.setLable(month);
		fusionChartObject.setValue1(StringUtil.doubleFormat3(customerColl.getCustomerIncome()));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(realIncom));
		fusionChartObject.setValue3(StringUtil.doubleFormat2(RelPuton));
		fusionChartObject.setValue4(StringUtil.doubleFormat2(new Double(customerColl.getDayPayMoney())));
		fusionChartObject.setValue5(StringUtil.doubleFormat3(customerColl.getAdSumTimes()));
		return fusionChartObject;
	}

	//业务员统计
	public FusionChartObject[] getBusinessChartObjs(String orgId,String startDate, String endDate, String type, String sortStr, String theUser, String userId, String carrierName, boolean isPutOnORIncome, int channelModelParam, String isPutYear, String returnValue, String incomPurs) {
		 int i = 0;
		    List all = orderDayInfoManager.getBusinessInfos(orgId,startDate,endDate,type,sortStr,theUser,userId,carrierName,isPutOnORIncome,channelModelParam,isPutYear,returnValue,incomPurs);
//			System.out.println("all<!11111111111111111111<<<<<<<<<<<<<<<<<<"+all.size());
		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				fusionChartObjects[i++] = setBusinessObj(customerColl,fusionChartObject);
			}
		return fusionChartObjects;
	}
	public FusionChartObject setBusinessObj(CustomerAnalyzeColl customerColl,FusionChartObject fusionChartObject){

		fusionChartObject.setLable(customerColl.getCustomerName());
		fusionChartObject.setValue1(StringUtil.doubleFormat3((String)customerColl.getMonth().get(1)));
		fusionChartObject.setValue2(StringUtil.doubleFormat3((String)customerColl.getMonth().get(2)));
		fusionChartObject.setValue3(StringUtil.doubleFormat3((String)customerColl.getMonth().get(3)));
		fusionChartObject.setValue4(StringUtil.doubleFormat3((String)customerColl.getMonth().get(4)));
		fusionChartObject.setValue5(StringUtil.doubleFormat3((String)customerColl.getMonth().get(5)));
		fusionChartObject.setValue6(StringUtil.doubleFormat3((String)customerColl.getMonth().get(6)));
		fusionChartObject.setValue7(StringUtil.doubleFormat3((String)customerColl.getMonth().get(7)));
		fusionChartObject.setValue8(StringUtil.doubleFormat3((String)customerColl.getMonth().get(8)));
		fusionChartObject.setValue9(StringUtil.doubleFormat3((String)customerColl.getMonth().get(9)));
		fusionChartObject.setValue10(StringUtil.doubleFormat3((String)customerColl.getMonth().get(10)));
		fusionChartObject.setValue11(StringUtil.doubleFormat3((String)customerColl.getMonth().get(11)));
		fusionChartObject.setValue12(StringUtil.doubleFormat3((String)customerColl.getMonth().get(12)));
		
		return fusionChartObject;
	}

	//频道进款统计
	public FusionChartObject[] getChannIncomeChartObjs(String orgId,String start, String end, String customerId, String carrierId, int channelModelParam, String userName, String isPutYear, String returnValue, String incomPurs, String userId) {
		 int i = 0;
		    List all = incomeUsedManager.getChannelIncomeList(orgId,start,end,customerId,carrierId,channelModelParam,userName,isPutYear,returnValue,incomPurs,userId);

		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
			for(Iterator it = all.iterator();it.hasNext();){
				IncomeUsed incomeUsed = (IncomeUsed)it.next();
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				fusionChartObjects[i++] = setChannIncomeObj(incomeUsed,fusionChartObject);
			}
		return fusionChartObjects;
	}
	public FusionChartObject setChannIncomeObj(IncomeUsed incomeUsed,FusionChartObject fusionChartObject){
		Double realIncom = incomeUsed.getIncomePublic().getIncomeMoney()== null?new Double(0):new Double(incomeUsed.getIncomePublic().getIncomeMoney());
		
		fusionChartObject.setLable(incomeUsed.getIncomePublic().getCarrierName());
		fusionChartObject.setValue1(StringUtil.doubleFormat2(realIncom));
		return fusionChartObject;
	}

	//载体区间统计
	public FusionChartObject[] getCarrierScopeChartObjs(String startDate, String endDate, String[] carrierIds, String userId, String curUserName, String isPrint,String orderCategoryId) {
		 int i = 0;
//			System.out.println("all<!11111111111111111111<<<zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz<<<<yyyyyyyyyyyyyyyyyyyy<<<<<<<<<<<");
		    List all = orderDayInfoManager.getCarrierByDate(startDate,endDate,carrierIds,userId,curUserName,isPrint,orderCategoryId);
//			System.out.println("all<!11111111111111111111<<<<<<<yyyyyyyyyyyyyyyyyyyy<<<<<<<<<<<"+all.size());
		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
			for(Iterator it = all.iterator();it.hasNext();){
				OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				fusionChartObjects[i++] = setCarrierScopeObj(orderDayInfo,fusionChartObject);
			}
		return fusionChartObjects;
	}
	public FusionChartObject setCarrierScopeObj(OrderDayInfo orderDayInfo,FusionChartObject fusionChartObject){
		
		fusionChartObject.setLable(orderDayInfo.getToaccountTotal()+ orderDayInfo.getCarrier().getCarrierName());
		fusionChartObject.setValue1(StringUtil.doubleFormat2(orderDayInfo.getDayRelIncome()));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(orderDayInfo.getDayRelPuton()));
		fusionChartObject.setValue3(StringUtil.doubleFormat2(orderDayInfo.getAdSumTimes()));
		
		return fusionChartObject;
	}

	//载体全年统计
	public FusionChartObject[] getCarrierAllChartObjs(String year, String[] carrierIds, String userId, String curUserName, String isPrint,String isType) {
		int i = 0;
		if(isType.equals("2")){
			 List all = orderDayInfoManager.getAllYearCarrierRelPuton(year, carrierIds, userId, curUserName,isPrint);
		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
			for(Iterator it = all.iterator();it.hasNext();){
				OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				fusionChartObjects[i++] = setCarrierAllObj(orderDayInfo,fusionChartObject);
			}
			return fusionChartObjects;
		}else{
			List all = orderDayInfoManager.getAllYearCarrier(year, carrierIds, userId, curUserName,isPrint);
			Map allMap = orderDayInfoManager.getAllYearCarrierMap(all);
			Map mapCarrierName = (Map)allMap.get("mapCarrierName");
			FusionChartObject fusionChartObjects[] =  new FusionChartObject[mapCarrierName.size()];
			for(Iterator it = allMap.keySet().iterator();it.hasNext();){
				String key = (String)it.next();
				if(!key.equals("mapCarrierName") && !key.equals("heji")){
					OrderDayInfo orderDayInfo = (OrderDayInfo)mapCarrierName.get(key);
					FusionChartObject fusionChartObject = new FusionChartObject();
					if(i == all.size()-1) break;
					List chileds = (List)allMap.get(key);
					int index =i++;
					fusionChartObjects[index] = setCarrierAllObj1(orderDayInfo,chileds,fusionChartObject,index);
				}
			}
			return fusionChartObjects;
		}
	}
	public FusionChartObject setCarrierAllObj1(OrderDayInfo orderDayInfo,List chileds,FusionChartObject fusionChartObject,int index){
		fusionChartObject.setId(String.valueOf(index));  
		fusionChartObject.setLable(orderDayInfo.getCarrier().getCarrierName());
		fusionChartObject.setValue1(StringUtil.doubleFormat3(orderDayInfo.getMonth()[1]));
		fusionChartObject.setValue2(StringUtil.doubleFormat3(orderDayInfo.getMonth()[2]));
		fusionChartObject.setValue3(StringUtil.doubleFormat3(orderDayInfo.getMonth()[3]));
		fusionChartObject.setValue4(StringUtil.doubleFormat3(orderDayInfo.getMonth()[4]));
		fusionChartObject.setValue5(StringUtil.doubleFormat3(orderDayInfo.getMonth()[5]));
		fusionChartObject.setValue6(StringUtil.doubleFormat3(orderDayInfo.getMonth()[6]));
		fusionChartObject.setValue7(StringUtil.doubleFormat3(orderDayInfo.getMonth()[7]));
		fusionChartObject.setValue8(StringUtil.doubleFormat3(orderDayInfo.getMonth()[8]));
		fusionChartObject.setValue9(StringUtil.doubleFormat3(orderDayInfo.getMonth()[9]));
		fusionChartObject.setValue10(StringUtil.doubleFormat3(orderDayInfo.getMonth()[10]));
		fusionChartObject.setValue11(StringUtil.doubleFormat3(orderDayInfo.getMonth()[11]));
		fusionChartObject.setValue12(StringUtil.doubleFormat3(orderDayInfo.getMonth()[12]));
		
		 if(chileds.size()>0){
				FusionChartObject fusionChartObjects[] =  new FusionChartObject[chileds.size()];
				int i = 0;
				for(Iterator it = chileds.iterator();it.hasNext();){
					OrderDayInfo ordInfo = (OrderDayInfo)it.next();
					FusionChartObject fcObject = new FusionChartObject();
					fusionChartObjects[i++] =  setCarrierAllObj1(ordInfo,new ArrayList(),fcObject,index);
//					fcObject.setLable(orderDayInfo.getCarrierName());
				}
				fusionChartObject.setObjs(fusionChartObjects);
			}
		
		return fusionChartObject;
	}
	public FusionChartObject setCarrierAllObj(OrderDayInfo orderDayInfo,FusionChartObject fusionChartObject){
		fusionChartObject.setLable(orderDayInfo.getCarrier().getCarrierName());
		fusionChartObject.setValue1(StringUtil.doubleFormat3(orderDayInfo.getMonth()[1]));
		fusionChartObject.setValue2(StringUtil.doubleFormat3(orderDayInfo.getMonth()[2]));
		fusionChartObject.setValue3(StringUtil.doubleFormat3(orderDayInfo.getMonth()[3]));
		fusionChartObject.setValue4(StringUtil.doubleFormat3(orderDayInfo.getMonth()[4]));
		fusionChartObject.setValue5(StringUtil.doubleFormat3(orderDayInfo.getMonth()[5]));
		fusionChartObject.setValue6(StringUtil.doubleFormat3(orderDayInfo.getMonth()[6]));
		fusionChartObject.setValue7(StringUtil.doubleFormat3(orderDayInfo.getMonth()[7]));
		fusionChartObject.setValue8(StringUtil.doubleFormat3(orderDayInfo.getMonth()[8]));
		fusionChartObject.setValue9(StringUtil.doubleFormat3(orderDayInfo.getMonth()[9]));
		fusionChartObject.setValue10(StringUtil.doubleFormat3(orderDayInfo.getMonth()[10]));
		fusionChartObject.setValue11(StringUtil.doubleFormat3(orderDayInfo.getMonth()[11]));
		fusionChartObject.setValue12(StringUtil.doubleFormat3(orderDayInfo.getMonth()[12]));
		
		return fusionChartObject;
	}
	//载体时段统计
	public FusionChartObject[] getResourceScopeChartObjs(String startDate, String endDate, String[] resourceIds, String userId, String curUserName, String isPrint,String orderCategoryId) {
		 int i = 0;
		    List all = orderDayInfoManager.getResourceListByDate(startDate,endDate,resourceIds,userId,curUserName,isPrint,orderCategoryId);
//			System.out.println("all<!11111111111111111111<<<<<<<<<<<<<<<<<<"+all.size());
		    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
			for(Iterator it = all.iterator();it.hasNext();){
				OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				fusionChartObjects[i++] = setResourceScopeObj(orderDayInfo,fusionChartObject);
			}
		return fusionChartObjects;
	}
	public FusionChartObject setResourceScopeObj(OrderDayInfo orderDayInfo,FusionChartObject fusionChartObject){
		
		fusionChartObject.setLable(orderDayInfo.getToaccountTotal()+ orderDayInfo.getResourceSpecific());
		fusionChartObject.setValue1(StringUtil.doubleFormat2(orderDayInfo.getDayRelIncome()));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(orderDayInfo.getDayRelPuton()));
		fusionChartObject.setValue3(StringUtil.doubleFormat2(orderDayInfo.getAdSumTimes()));
		
		return fusionChartObject;
	}

	//载体构成分析
	public FusionChartObject[] getCarrierBasalChartObjs(int channelModel, String beginDate, String endDate, String userId, String carrierName, String curUserName, String isPrint) {
		int i = 0;
		
		Map all = analyseManager.getCarrierBasalByBeginAndEndDate(channelModel,beginDate,endDate,userId,carrierName,curUserName,isPrint);
		Map mapCarrierBasal = (Map)all.get("mapCarrierBasal");
	    FusionChartObject fusionChartObjects[] =  new FusionChartObject[mapCarrierBasal.size()];
		for(Iterator it = all.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			if(!key.equals("mapCarrierBasal")&& !key.equals("relIncomeSum")){
				AnalyzeClass analyzeClass = (AnalyzeClass)mapCarrierBasal.get(key);
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				List chileds = (List)all.get(key);
				int index =i++;
				fusionChartObjects[index] = setCarrierBasalObj(analyzeClass,chileds,fusionChartObject,key,index);
			}
		}
			return fusionChartObjects;
	}
	public FusionChartObject setCarrierBasalObj(AnalyzeClass analyzeClass,List chileds,FusionChartObject fusionChartObject,String key,int index){
		Double relIncome = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
		
		fusionChartObject.setId(String.valueOf(index));  
		fusionChartObject.setLable(analyzeClass.getResourceName());
		fusionChartObject.setValue1(StringUtil.doubleFormat2(relIncome));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(analyzeClass.getSumTimes()));
		
		 if(chileds.size()>0){
				FusionChartObject fusionChartObjects[] =  new FusionChartObject[chileds.size()];
				int i = 0;
				for(Iterator it = chileds.iterator();it.hasNext();){
					AnalyzeClass aClass = (AnalyzeClass)it.next();
					FusionChartObject fcObject = new FusionChartObject();
					fusionChartObjects[i++] =  setCarrierBasalObj(aClass,new ArrayList(),fcObject,key,index);
					fcObject.setLable(aClass.getCarrierName());
				}
				fusionChartObject.setObjs(fusionChartObjects);
			}
		
		return fusionChartObject;
	}

	//客户订单类别
	public FusionChartObject[] getOrderCarrierChartObjs(String sortStr, String year, String startDate, String endDate, String[] customerIds, String userId, String carrierName, int channelModelParam, String theUser) {
		int i = 0;
	    List all = analyseManager.getOrderCategoryByCustomer(sortStr,year,startDate,endDate,customerIds,userId,carrierName,channelModelParam,theUser);
//		System.out.println("all<!11111111111111111111<<<<<<<<<<<<<<<<<<"+all.size());
	    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()-1];
		for(Iterator it = all.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass) it.next();
			FusionChartObject fusionChartObject = new FusionChartObject();
			if(i == all.size()-1) break;
			fusionChartObjects[i++] = setOrderCarrierObj(analyzeClass,fusionChartObject);
		}
	return fusionChartObjects;
	}
	public FusionChartObject setOrderCarrierObj(AnalyzeClass analyzeClass,FusionChartObject fusionChartObject){
		Double relPay = analyzeClass.getRelPay() == null?new Double(0):analyzeClass.getRelPay();
		Double realIncom = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
		Double sumTimes = analyzeClass.getSumTimes();
		Double youHuiPrice = analyzeClass.getTimeUsed();
	
		fusionChartObject.setLable(analyzeClass.getMatterName());
		fusionChartObject.setValue1(StringUtil.doubleFormat2(relPay));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(realIncom));
		fusionChartObject.setValue3(StringUtil.doubleFormat2(youHuiPrice));
		fusionChartObject.setValue4(StringUtil.doubleFormat2(sumTimes));
		
		return fusionChartObject;
	}

	//订单类别客户统计
	public FusionChartObject[] getOrderCustomerChartObjs(String[] carrierIds, int channelModelParam, String beginDate, String endDate, String userId, String curUserName, String isPrint) {
	int i = 0;
	Map all = analyseManager.getOrderCategoryByCarrierType(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
	Map mapOrderCategory = (Map)all.get("mapOrderCategory");
    FusionChartObject fusionChartObjects[] =  new FusionChartObject[mapOrderCategory.size()];
	for(Iterator it = all.keySet().iterator();it.hasNext();){
		String key = (String)it.next();
		if(!key.equals("mapOrderCategory") && !key.equals("relPaySum")){
			AnalyzeClass analyzeClass = (AnalyzeClass)mapOrderCategory.get(key);
			FusionChartObject fusionChartObject = new FusionChartObject();
			if(i == all.size()-1) break;
			List chileds = (List)all.get(key);
			int index =i++;
			fusionChartObjects[index] = setOrderCustomerObj(analyzeClass,chileds,fusionChartObject,key,index);
		}
	}
		return fusionChartObjects;
	}
	public FusionChartObject setOrderCustomerObj(AnalyzeClass analyzeClass,List chileds,FusionChartObject fusionChartObject,String key,int index){
		Double relIncome = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
		Double sysPrice = analyzeClass.getRelPay()== null?new Double(0):analyzeClass.getRelPay();
		double youHuiPrice= sysPrice.doubleValue() - relIncome.doubleValue();

		 fusionChartObject.setId(String.valueOf(index));  
		 fusionChartObject.setLable(key);
		 fusionChartObject.setValue1(StringUtil.doubleFormat2(sysPrice));
		 fusionChartObject.setValue2(StringUtil.doubleFormat2(relIncome));
		 fusionChartObject.setValue3(StringUtil.doubleFormat2(new Double(youHuiPrice)));
		 fusionChartObject.setValue4( StringUtil.doubleFormat2(analyzeClass.getTimeUsed()));
		 
		 if(chileds.size()>0){
				FusionChartObject fusionChartObjects[] =  new FusionChartObject[chileds.size()];
				int i = 0;
				for(Iterator it = chileds.iterator();it.hasNext();){
					AnalyzeClass aClass = (AnalyzeClass)it.next();
					FusionChartObject fcObject = new FusionChartObject();
					fusionChartObjects[i++] =  setOrderCustomerObj(aClass,new ArrayList(),fcObject,key,index);
					fcObject.setLable(aClass.getResourceName());
				}
				fusionChartObject.setObjs(fusionChartObjects);
			}
	
	return fusionChartObject;
	}

	//客户品牌投放量
	public FusionChartObject[] getCustomerProductChartObjs(String[] carrierIds, int channelModelParam, String beginDate, String endDate, String userId, String curUserName, String isPrint) {
		int i = 0;
		Map all = orderDetailManager.getOaTeleExpensesByBeginAndEndDate2(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		Map mapIndustryType = (Map)all.get("mapIndustryType");
	    FusionChartObject fusionChartObjects[] =  new FusionChartObject[mapIndustryType.size()];
		for(Iterator it = all.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				
				List chileds = (List)all.get(key);
				int index =i++;
				fusionChartObjects[index] = setCustomerProductObj(customerProduct,chileds,fusionChartObject,key,index);
			}
		}
			return fusionChartObjects;
	}
	public FusionChartObject setCustomerProductObj(CustomerProduct customerProduct,List chileds,FusionChartObject fusionChartObject,String key,int index){
		Double relIncome = customerProduct.getRelIncome();
		Double putOn = customerProduct.getPutOn();
		Double times = customerProduct.getTimeUsed();

		fusionChartObject.setId(String.valueOf(index));  
		fusionChartObject.setLable(key);
		fusionChartObject.setValue1(StringUtil.doubleFormat2(relIncome));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(putOn));
		fusionChartObject.setValue3( StringUtil.doubleFormat2(times));
	
	if(chileds.size()>0){
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[chileds.size()];
		int i = 0;
		for(Iterator it = chileds.iterator();it.hasNext();){
			CustomerProduct customerP = (CustomerProduct)it.next();
			FusionChartObject fcObject = new FusionChartObject();
			fusionChartObjects[i++] =  setCustomerProductObj(customerP,new ArrayList(),fcObject,key,index);
			fcObject.setLable(customerP.getMatterName());
		}
		fusionChartObject.setObjs(fusionChartObjects);
	}
	
	return fusionChartObject;
	}

	//行业品牌投放量
	public FusionChartObject[] getIndustryTypeChartObjs(int channelModel, String beginDate, String endDate, String userId, String carrierName, String curUserName, String isPrint) {
		int i = 0;
		Map all = orderDetailManager.getIndustryTypeProductByBeginAndEndDate2(channelModel,beginDate,endDate,userId,carrierName,curUserName,isPrint);
		Map mapIndustryType = (Map)all.get("mapIndustryType");
	    FusionChartObject fusionChartObjects[] =  new FusionChartObject[mapIndustryType.size()];
	    double res[] = new  double[1];
	    for(Iterator it = all.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				res[0]+=customerProduct.getRelIncome().doubleValue();
			}
	    }
		for(Iterator it = all.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				
				List chileds = (List)all.get(key);
				int index =i++;
				
					fusionChartObjects[index] = setIndustryTypeObj(customerProduct,chileds,fusionChartObject,key,index,res);
					
			}
		}
			return fusionChartObjects;
	}

	public FusionChartObject setIndustryTypeObj(CustomerProduct customerProduct,List chileds,FusionChartObject fusionChartObject,String key,int index,double res[]){
		Double relIncome = customerProduct.getRelIncome();
		Double putOn = customerProduct.getPutOn();
		Double times = customerProduct.getTimeUsed();
		
		
		fusionChartObject.setId(String.valueOf(index));
		fusionChartObject.setLable(key);
		fusionChartObject.setValue1(StringUtil.doubleFormat2(relIncome));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(putOn));
		fusionChartObject.setValue3(StringUtil.doubleFormat2(times));
		fusionChartObject.setValue4(StringUtil.persentFormat(relIncome.doubleValue(),res[0]));
		
		if(chileds.size()>0){
			FusionChartObject fusionChartObjects[] =  new FusionChartObject[chileds.size()];
			int i = 0;
			for(Iterator it = chileds.iterator();it.hasNext();){
				CustomerProduct customerP = (CustomerProduct)it.next();
				FusionChartObject fcObject = new FusionChartObject();
				fusionChartObjects[i++] =  setIndustryTypeObj(customerP,new ArrayList(),fcObject,key,index,res);
				fcObject.setLable(customerP.getMatterName());
			}
			fusionChartObject.setObjs(fusionChartObjects);
		}

		return fusionChartObject;
	}
	//品牌投播情况表
	public Collection getIndustryProductChannelChartObjs(final String queryString,String type) {
		int i = 0;
		List industryls =new ArrayList();
		List matterls =new ArrayList();
		FusionChartObject fusionChartObject=null;
		
		List all = (List)orderDetailManager.getIndustryTypeProductChannelCollections(queryString,type);
		
		for(Iterator it=all.iterator();it.hasNext();){
			FusionChartObject fcObject=(FusionChartObject)it.next();

			Method[] methods = fcObject.getClass().getMethods();
			
			if(!fcObject.getValue1().equals("")){

				if(fusionChartObject!=null){
					fusionChartObject.setObjs(matterls.toArray());
					industryls.add(fusionChartObject);
					matterls.clear();
				}               
				fusionChartObject = new FusionChartObject();      
				fusionChartObject.setId(String.valueOf(++i));  
				fusionChartObject.setLable(fcObject.getValue1());
				String[] value = new String[10];  
				
				for(int k=0;k<10;k++){
					for(int j=0;j<methods.length;j++){
						if(methods[j].getName().equals("getValue"+(k+3))){
							try {
								value[k] = (String)methods[j].invoke(fcObject,null);//不调用参数，所以随便放；
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}   
				for(int k=0;k<10;k++){
					for(int j=0;j<methods.length;j++){
						if(methods[j].getName().equals("setValue"+(k+1))){
							String[] param = new String[1];
							param[0] = value[k];
							try {   
								methods[j].invoke(fusionChartObject,param);
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}else{
				FusionChartObject fObject = new FusionChartObject();
				fObject.setId(String.valueOf(i));
				fObject.setLable(fcObject.getValue2());
				String[] value = new String[10];
				
				for(int k=0;k<10;k++){
					for(int j=0;j<methods.length;j++){
						if(methods[j].getName().equals("getValue"+(k+3))){
							try {
								value[k] = (String)methods[j].invoke(fcObject,null);//不调用参数，所以随便放；
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}   
				for(int k=0;k<10;k++){
					for(int j=0;j<methods.length;j++){
						if(methods[j].getName().equals("setValue"+(k+1))){
							String[] param = new String[1];
							param[0] = value[k];
							try {   
								methods[j].invoke(fObject,param);  
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
				matterls.add(fObject);
			}
			if(!it.hasNext()){
				if(fusionChartObject!=null){
					fusionChartObject.setObjs(matterls.toArray());
					industryls.add(fusionChartObject);
				}         
			}
		}

		return industryls;
	}
	
//	区域客户统计
	public FusionChartObject[] getAreaCustomerChartObjs(String[] carrierIds, int channelModelParam, String beginDate, String endDate, String userId, String curUserName, String isPrint) {
	int i = 0;
	Map all = analyseManager.getAreaCustomerByCarrierType(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
	Map mapAreaCustomer = (Map)all.get("mapAreaCustomer");
    FusionChartObject fusionChartObjects[] =  new FusionChartObject[mapAreaCustomer.size()];
	for(Iterator it = all.keySet().iterator();it.hasNext();){
		String key = (String)it.next();
		key=key==null||key.equals(null)?"其它":key;
		if(!key.equals("mapAreaCustomer")){
			AnalyzeClass analyzeClass = (AnalyzeClass)mapAreaCustomer.get(key);
			FusionChartObject fusionChartObject = new FusionChartObject();
			if(i == all.size()-1) break;
			List chileds = (List)all.get(key);
			int index =i++;
			fusionChartObjects[index] = setAreaCustomerObj(analyzeClass,chileds,fusionChartObject,key,index);
		}
	}
		return fusionChartObjects;
	}
	public FusionChartObject setAreaCustomerObj(AnalyzeClass analyzeClass,List chileds,FusionChartObject fusionChartObject,String key,int index){
		Double relIncome = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
		Double daokuan = analyzeClass.getRelPay()== null?new Double(0):analyzeClass.getRelPay();

		 fusionChartObject.setId(analyzeClass.getCarrierName()==null?"CN":analyzeClass.getCarrierName());
		 fusionChartObject.setLable(key);
		 fusionChartObject.setValue1(StringUtil.doubleFormat2(relIncome));
		 fusionChartObject.setValue2(StringUtil.doubleFormat2(daokuan));
		 
		 if(chileds.size()>0){
				FusionChartObject fusionChartObjects[] =  new FusionChartObject[chileds.size()];
				int i = 0;
				for(Iterator it = chileds.iterator();it.hasNext();){
					AnalyzeClass aClass = (AnalyzeClass)it.next();
					FusionChartObject fcObject = new FusionChartObject();
					fusionChartObjects[i++] =  setOrderCustomerObj(aClass,new ArrayList(),fcObject,key,index);
					fcObject.setLable(aClass.getResourceName());
//					fusionChartObject.setId(String.valueOf(index));
				}
				fusionChartObject.setObjs(fusionChartObjects);
			}
	
	return fusionChartObject;
	}
	//年度指标统计 
	public FusionChartObject[] getFinanceTargetChartObjs(String year,String userName,String carrierId,int channelModelParam) {
		int i = 0;
	    List all = financeTargetManager.getFinanceTargets(year,userName,carrierId,channelModelParam);
//	    System.out.println("all.size()<<<<<<<<<<<<<<1111<<<<<<<<<<<<<<<<<<"+all.size());
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()];
		for(Iterator it = all.iterator();it.hasNext();){
			FinanceTarget fTarget =(FinanceTarget) it.next();
			FusionChartObject fusionChartObject = new FusionChartObject();
//			if(i == all.size()-1) break;
			fusionChartObjects[i++] = setFinanceTargetObj(fTarget,fusionChartObject);
		}
	return fusionChartObjects;
	}
	public FusionChartObject setFinanceTargetObj(FinanceTarget financeTarget,FusionChartObject fusionChartObject){
		
		Map map = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
		Carrier carrier = (Carrier)map.get(financeTarget.getCarrierId().toString());
		String carrierName = carrier.getCarrierName();
		
		fusionChartObject.setLable(carrierName);
		fusionChartObject.setValue1(StringUtil.doubleFormat3(financeTarget.getTarMonths()[0]));
		fusionChartObject.setValue2(StringUtil.doubleFormat3(financeTarget.getTarMonths()[1]));
		fusionChartObject.setValue3(StringUtil.doubleFormat3(financeTarget.getTarMonths()[2]));
		fusionChartObject.setValue4(StringUtil.doubleFormat3(financeTarget.getTarMonths()[3]));
		fusionChartObject.setValue5(StringUtil.doubleFormat3(financeTarget.getTarMonths()[4]));
		fusionChartObject.setValue6(StringUtil.doubleFormat3(financeTarget.getTarMonths()[5]));
		fusionChartObject.setValue7(StringUtil.doubleFormat3(financeTarget.getTarMonths()[6]));
		fusionChartObject.setValue8(StringUtil.doubleFormat3(financeTarget.getTarMonths()[7]));
		fusionChartObject.setValue9(StringUtil.doubleFormat3(financeTarget.getTarMonths()[8]));
		fusionChartObject.setValue10(StringUtil.doubleFormat3(financeTarget.getTarMonths()[9]));
		fusionChartObject.setValue11(StringUtil.doubleFormat3(financeTarget.getTarMonths()[10]));
		fusionChartObject.setValue12(StringUtil.doubleFormat3(financeTarget.getTarMonths()[11]));
		
		return fusionChartObject;
	}
    //载体年度统计
	public FusionChartObject[] getCarrierTargetChartObjs(String orgId,String userId,int channelModelParam,String year,String startDate,String endDate,String isPutYear, String isNotReturnValue, String carrierId, String userName, String purpose,String customerId) {
		int i = 0;
		
		
		Map all = financeTargetManager.getCarrierTargetByYear(orgId,userId,year,startDate,endDate,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId);
		Map mapCarrierBasal = (Map)all.get("mapCarrierBasal");
	    FusionChartObject fusionChartObjects[] =  new FusionChartObject[mapCarrierBasal.size()];
		for(Iterator it = all.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			if(!key.equals("mapCarrierBasal")){
				FinanceTarget financeTarget = (FinanceTarget)mapCarrierBasal.get(key);
				String carrierName = financeTarget.getCarrierName();
				FusionChartObject fusionChartObject = new FusionChartObject();
				if(i == all.size()-1) break;
				List chileds = (List)all.get(key);
				int index =i++;
				fusionChartObjects[index] = setCarrierTargetObj(financeTarget,chileds,fusionChartObject,carrierName,index);
			}
		}
			return fusionChartObjects;
	}
	public FusionChartObject setCarrierTargetObj(FinanceTarget financeTarget,List chileds,FusionChartObject fusionChartObject,String carrierName,int index){
		Double relIncome = financeTarget.getRelIncome() == null?new Double(0):financeTarget.getRelIncome();
		Double putOn = financeTarget.getRelPut()== null?new Double(0):financeTarget.getRelPut();
		Double targetMoney = financeTarget.getTargetMoney()== null?new Double(0):financeTarget.getTargetMoney();
//		String used = financeTarget.getUsed();
		
        
		fusionChartObject.setId(String.valueOf(index));
		fusionChartObject.setLable(carrierName);
		fusionChartObject.setValue1(StringUtil.doubleFormat2(putOn));
		fusionChartObject.setValue2(StringUtil.doubleFormat2(relIncome));
		fusionChartObject.setValue3(StringUtil.doubleFormat2(targetMoney));
		fusionChartObject.setValue4(StringUtil.persentFormat(putOn.doubleValue(),targetMoney.doubleValue()));
		fusionChartObject.setValue4(StringUtil.persentFormat(relIncome.doubleValue(),targetMoney.doubleValue()));

		 if(chileds.size()>0){
				FusionChartObject fusionChartObjects[] =  new FusionChartObject[chileds.size()];
				int i = 0;
				for(Iterator it = chileds.iterator();it.hasNext();){
					FinanceTarget fTarget = (FinanceTarget)it.next();
					FusionChartObject fcObject = new FusionChartObject();
					fusionChartObjects[i++] =  setCarrierTargetObj(fTarget,new ArrayList(),fcObject,carrierName,index);
					fcObject.setLable(StringUtil.converNum2cnMonth(fTarget.getTargetMonth()));
//					fusionChartObject.setId(String.valueOf(index));
				}
				fusionChartObject.setObjs(fusionChartObjects);
			}
	
	return fusionChartObject;
	}
	
    //年度对比统计	
	public FusionChartObject[] getYearTargetChartObjs(int channelModelParam,int size,String type,String isPutYear,String isNotReturnValue,String carrierId,String userName,String purpose) {
		int i = 0;
		
		List all = financeTargetManager.getYearTargetAnalyze(size,type,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose);
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()];
		for(Iterator it = all.iterator();it.hasNext();){
			FinanceTarget fTarget =(FinanceTarget) it.next();
			FusionChartObject fusionChartObject = new FusionChartObject();
//			if(i == all.size()-1) break;
			fusionChartObjects[i++] = setYearTargetObj(fTarget,fusionChartObject,size);
		}
	return fusionChartObjects;
	}
	public FusionChartObject setYearTargetObj(FinanceTarget financeTarget,FusionChartObject fusionChartObject,int size){
		
//		Map map = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
//		Carrier carrier = (Carrier)map.get(financeTarget.getCarrierId().toString());
		String carrierName = financeTarget.getCarrierName();
		fusionChartObject.setLable(carrierName);
		for(int i=1;i<=size;i++){
			switch(i){
			case 1:
				fusionChartObject.setValue1(StringUtil.doubleFormat3(financeTarget.getTarMonths()[0]));break;
			case 2:
				fusionChartObject.setValue2(StringUtil.doubleFormat3(financeTarget.getTarMonths()[1]));break;
			case 3:
				fusionChartObject.setValue3(StringUtil.doubleFormat3(financeTarget.getTarMonths()[2]));break;
			case 4:
				fusionChartObject.setValue4(StringUtil.doubleFormat3(financeTarget.getTarMonths()[3]));break;
			case 5:
				fusionChartObject.setValue5(StringUtil.doubleFormat3(financeTarget.getTarMonths()[4]));break;
			case 6:
				fusionChartObject.setValue6(StringUtil.doubleFormat3(financeTarget.getTarMonths()[5]));break;
			case 7:
				fusionChartObject.setValue7(StringUtil.doubleFormat3(financeTarget.getTarMonths()[6]));break;
			case 8:
				fusionChartObject.setValue8(StringUtil.doubleFormat3(financeTarget.getTarMonths()[7]));break;
			case 9:
				fusionChartObject.setValue9(StringUtil.doubleFormat3(financeTarget.getTarMonths()[8]));break;
			case 10:
				fusionChartObject.setValue10(StringUtil.doubleFormat3(financeTarget.getTarMonths()[9]));break;
			case 11:
				fusionChartObject.setValue11(StringUtil.doubleFormat3(financeTarget.getTarMonths()[10]));break;
			case 12:
				fusionChartObject.setValue12(StringUtil.doubleFormat3(financeTarget.getTarMonths()[11]));break;
			
			default :
		    }
		
		}
		return fusionChartObject;
    }

    //客户年度对比统计	
	public FusionChartObject[] getCustomerYearChartObjs(int channelModelParam,int size,String type,String isPutYear,String isNotReturnValue,String customerId,String userName,String purpose) {
		int i = 0;
		
		List all = financeTargetManager.getCustomerYearAnalyze(size,type,customerId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose);
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()];
		for(Iterator it = all.iterator();it.hasNext();){
			FinanceTarget fTarget =(FinanceTarget) it.next();
			FusionChartObject fusionChartObject = new FusionChartObject();

			fusionChartObjects[i++] = setCustomerYearObj(fTarget,fusionChartObject,size);
		}
	return fusionChartObjects;
	}
	public FusionChartObject setCustomerYearObj(FinanceTarget financeTarget,FusionChartObject fusionChartObject,int size){
		
		String customerName = financeTarget.getCarrierName();
		fusionChartObject.setLable(customerName);
		for(int i=1;i<=size;i++){
			switch(i){
			case 1:
				fusionChartObject.setValue1(StringUtil.doubleFormat3(financeTarget.getTarMonths()[0]));break;
			case 2:
				fusionChartObject.setValue2(StringUtil.doubleFormat3(financeTarget.getTarMonths()[1]));break;
			case 3:
				fusionChartObject.setValue3(StringUtil.doubleFormat3(financeTarget.getTarMonths()[2]));break;
			case 4:
				fusionChartObject.setValue4(StringUtil.doubleFormat3(financeTarget.getTarMonths()[3]));break;
			case 5:
				fusionChartObject.setValue5(StringUtil.doubleFormat3(financeTarget.getTarMonths()[4]));break;
			case 6:
				fusionChartObject.setValue6(StringUtil.doubleFormat3(financeTarget.getTarMonths()[5]));break;
			case 7:
				fusionChartObject.setValue7(StringUtil.doubleFormat3(financeTarget.getTarMonths()[6]));break;
			case 8:
				fusionChartObject.setValue8(StringUtil.doubleFormat3(financeTarget.getTarMonths()[7]));break;
			case 9:
				fusionChartObject.setValue9(StringUtil.doubleFormat3(financeTarget.getTarMonths()[8]));break;
			case 10:
				fusionChartObject.setValue10(StringUtil.doubleFormat3(financeTarget.getTarMonths()[9]));break;
			case 11:
				fusionChartObject.setValue11(StringUtil.doubleFormat3(financeTarget.getTarMonths()[10]));break;
			case 12:
				fusionChartObject.setValue12(StringUtil.doubleFormat3(financeTarget.getTarMonths()[11]));break;
			default :
		    }
		
		}
		return fusionChartObject;
    }

	public FusionChartObject[] getResourceChartObjs(String[] resourceIds, String searchDate) {
		int i = 0;
		String beginDate = searchDate;
		String endDate = searchDate;
//		String mode = "1";
	    List all = orderDayInfoManager.getResourceChartByDate(beginDate,endDate,resourceIds);
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()];
//		System.out.println("all.size()<<<<<<<<<<<<000000000<<<<<<<<<<<"+all.size());
		for(Iterator it = all.iterator();it.hasNext();){
			CustomerProduct customerColl =(CustomerProduct) it.next();
			FusionChartObject fusionChartObject = new FusionChartObject();
//			if(i == all.size()-1) break;
			fusionChartObjects[i++] = setResourceObj(customerColl,fusionChartObject);
		}
	return fusionChartObjects;
}
	public FusionChartObject setResourceObj(CustomerProduct cProduct,FusionChartObject fusionChartObject){
		boolean isMeno = getResourcesLablePara();
		String resName = isMeno?cProduct.getResourceMeno():cProduct.getResourceName();

		String resTotol = cProduct.getTotal();
			resTotol = resTotol ==null||resTotol ==""?"0":resTotol;
		String resUse = cProduct.getUsed();
			resUse = resUse ==null||resUse ==""?"0":resUse;
//			System.out.println("resTotol<<<<<<<<<<1111111111111<<<<<<<<<<<"+resTotol);
//			System.out.println("resUse<<<<<<<<<<222222222222<<<<<<<<<<<"+resUse);
		double shengYu = new Double(resTotol).doubleValue() - new Double(resUse).doubleValue();
			

		fusionChartObject.setLable(resName);
		if(shengYu>0){
			fusionChartObject.setValue1(resUse);
			fusionChartObject.setValue2(StringUtil.doubleFormat2(new Double(shengYu)));
		}else{
			
			fusionChartObject.setValue1(resTotol);
//			fusionChartObject.setValue2(StringUtil.doubleFormat2(new Double(shengYu)));
			fusionChartObject.setValue3(StringUtil.doubleFormat2(new Double(new Double(resUse).doubleValue() - new Double(resTotol).doubleValue())));
		}
		
		return fusionChartObject;
	}
	
	public boolean getResourcesLablePara(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getResourceDisplayParam())) sysParam.setResourceDisplayParam("0");
	    return (sysParam.getResourceDisplayParam().equals("0"))?false:true;
	}



}