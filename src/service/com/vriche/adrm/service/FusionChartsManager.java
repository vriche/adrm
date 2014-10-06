package com.vriche.adrm.service;

import java.util.Collection;

import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.OrderDayInfo;

public interface FusionChartsManager  {
  
	public FusionChartObject[] getCustomerChartObjs(String orgId,String resourceTypeId,String startDate ,String endDate,String sorCol,String sorType,String putYear,String userId,String carrierName,String customerId,int channelModelParam,String theUser,String incomPurs,String returnValue,String weekStr);
	
	public FusionChartObject[] getYearChartObjs(String orgId,String resourceTypeId,String yser,String type,String sortStr,String putYear,String userId,String carrierName,String[] customerId,int channelModelParam,String theUser,String incomPurs,String returnValue);

	public FusionChartObject[] getBusinessChartObjs(String orgId,String startDate, String endDate,String type, String sortStr, String theUser,String userId,String carrierName,boolean isPutOnORIncome,int channelModelParam,String isPutYear,String returnValue,String incomPurs);
	
	public FusionChartObject[] getChannIncomeChartObjs(String orgId,String start,String end,String customerId,String carrierId,int channelModelParam,String userName,String isPutYear,String returnValue,String incomPurs,String userId);
	
	public FusionChartObject[] getCarrierScopeChartObjs(String startDate, String endDate,String[] carrierIds,String userId,String curUserName,String isPrint,String orderCategoryId);
	
	public FusionChartObject[] getCarrierAllChartObjs(String year, String[] carrierIds,String userId,String curUserName,String isPrint,String isType);
	
	public FusionChartObject[] getResourceScopeChartObjs(String startDate, String endDate,String[] resourceIds,String userId,String curUserName,String isPrint,String orderCategoryId);
	
	public FusionChartObject[] getCarrierBasalChartObjs(int channelModel, String beginDate, String endDate, String userId, String carrierName, String curUserName, String isPrint);
	
	public FusionChartObject[] getOrderCarrierChartObjs(String sortStr,String year,String startDate,String endDate, String[] customerIds,String userId,String carrierName,int channelModelParam,String theUser);
	
	public FusionChartObject[] getOrderCustomerChartObjs(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint);
	
	public FusionChartObject[] getAreaCustomerChartObjs(String[] carrierIds, int channelModelParam, String beginDate, String endDate, String userId, String curUserName, String isPrint);
	
	public FusionChartObject[] getCustomerProductChartObjs(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint);
	
	public FusionChartObject[] getIndustryTypeChartObjs(int channelModel,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
	
	public FusionChartObject[] getFinanceTargetChartObjs(String year,String curUserName,String carrierId,int channelModelParam);
	
	public FusionChartObject[] getCarrierTargetChartObjs(String orgId,String userId,int channelModelParam,String year,String startDate,String endDate,String isPutYear,String isNotReturnValue,String carrierId,String userName,String purpose,String customerId);
	
	public FusionChartObject[] getYearTargetChartObjs(int channelModelParam,int size,String type,String isPutYear,String isNotReturnValue,String carrierId,String userName,String purpose);
	
	public FusionChartObject[] getResourceChartObjs(String[] resourceIds,String searchDate);
	
	public Collection getIndustryProductChannelChartObjs(final String queryString,String type);
	
	public FusionChartObject[] getChartObjs(String queryString, String type);
}

