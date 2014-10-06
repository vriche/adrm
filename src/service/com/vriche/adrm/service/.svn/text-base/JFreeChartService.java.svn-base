package com.vriche.adrm.service;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import com.vriche.adrm.service.Manager;

public interface JFreeChartService extends Manager {
	
	public ArrayList getDataByBeginAndEndDate(String sysUser,String channelModelParam,String startDate, String endDate,String userId,String carrierName,String customerId);
	public String customerAnalyzeChart(String sysUser,String channelModelParam,String startDate,String endDate,String userId,String carrierName,String customerId, HttpSession session, PrintWriter pw);
	public String customerAnalyzeChartTime(String sysUser,String channelModelParam,String startDate,String endDate,String userId,String carrierName,String customerId, HttpSession session, PrintWriter pw);

	public ArrayList getDateByYearAndCustomerIds(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName);
	public ArrayList getTotalCountByYearAndCustomerIds(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName);
	public String yearAnalyzeChartIncome(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName,HttpSession session, PrintWriter pw);
	public String yearAnalyzeChartTime(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName,HttpSession session, PrintWriter pw);
	public String yearAnalyzeChartMoneyIn(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName,HttpSession session, PrintWriter pw);

	public ArrayList getDateByYearAndCustomerIdsQuarter(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName);
	public ArrayList getTotalCountByYearAndCustomerIdsQuarter(String year, String[] customerIds,String userId,String carrierName);
	public String yearAnalyzeChartIncomeQuarter(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName,HttpSession session, PrintWriter pw);
	public String yearAnalyzeChartTimeQuarter(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName,HttpSession session, PrintWriter pw);
	public String yearAnalyzeChartMoneyInQuarter(String sysUser,String channel,String year,String[] customerIds,String userId,String carrierName,HttpSession session, PrintWriter pw);

	
	public String businessAnalyzeChart(String sysUser,String channelModelParam,String hitMonth,String startDate, String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw);
	public String businessAnalyzeChartPuton(String sysUser,String channelModelParam,String hitMonth,String startDate, String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw);
	public ArrayList getDataByHitMonthPutOn(String sysUser,String channelModelParam,String hitMonth,String startDate,String endDate,String userId,String carrierName);
	public ArrayList getMonthByStartAndEndDate(String startDate,String endDate);
	public ArrayList getDataByHitMonth(String hitMonth,String startDate,String endDate);
	
	public ArrayList getDataByCarrierAndDate(String sysUser,String startDate, String endDate,String[] carrierIds,String userId);
	public String carrierScopeAnalyzeInCount(String sysUser,String startDate, String endDate,String[] carrierIds, String userId, HttpSession session, PrintWriter pw);
	public String carrierScopeAnalyzeTimeSum(String sysUser,String startDate, String endDate,String[] carrierIds, String userId, HttpSession session, PrintWriter pw);
	
//	public ArrayList getDataByCarrierAndYear(String year,String[] carrierIds);
	public String carrierAllYearAnalyzeChartIncome(String sysUser,String hitMonth,String year,String[] carrierIds,String userId, HttpSession session, PrintWriter pw);
	public ArrayList getMonthByStartEndDateAndCarrier();
	public ArrayList getDataByMonth(String hitMonth,String year, String[] carrierIds);
	
	public ArrayList getDataByCustomerName(String sysUser,String channelModel,String customerName,String startDate, String endDate,String userId,String[] carrierIds);
	public String customerProductRelChart(String sysUser,String channelModel,String customerName,String startDate,String endDate,String userId,String[] carrierIds, HttpSession session, PrintWriter pw);
	public ArrayList getCustomerName(String sysUser,String channelModel,String startDate, String endDate,String userId,String[] carrierIds);
		
	
	public ArrayList getIndustryName(String userName,String channelModel,String startDate, String endDate,String userId,String carrierName);
	public ArrayList getDataIndustryNameTotal(String userName,String channelModel,String startDate, String endDate,String userId,String carrierName);
	public ArrayList getIndustryNameTotal(String startDate, String endDate,String userId,String carrierName);
	
	public ArrayList getDataByIndustryType(String userName,String channelModel,String industryType,String startDate, String endDate,String userId,String carrierName);
	public String industryProductRelChart(String userName,String channelModel,String industryType,String startDate,String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw);
	public String industryProductRelChartTotal(String userName,String channelModel,String industryType,String startDate,String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw);
	
	public ArrayList getAdvTypeName(String userName,String channelModel,String startDate, String endDate,String userId,String carrierName);
	public ArrayList getDataByAdvTypeName(String channelModel,String carrierName,String startDate, String endDate,String userId,String carrierName1,String curUserName);
	public String advTypeProductRelChart(String channelModel,String carrierName,String startDate, String endDate,String userId,String carrierName1,String curUserName, HttpSession session, PrintWriter pw);

	
	
	public ArrayList getAnalyCarrierMatterDate(String startDate, String endDate,String[] resourceIds);
	public String analyCarrierMatterAnalyzeInCount(String startDate, String endDate,String[] resourceIds, HttpSession session, PrintWriter pw);
	public String analyCarrierMatterTimeSum(String startDate, String endDate,String[] resourceIds,  HttpSession session, PrintWriter pw);
	
	/** 
	 * ª∞∑—≤È—Ø.
	 */
	public ArrayList getTeleExpensesByDate(String startDate,String endDate);
	public String teleExpensesChart(String startDate,String endDate,HttpSession session,PrintWriter pw);
	
}
