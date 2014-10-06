/****************************************************************************     
 * Created on 2007-12-9                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.service;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.AnalyDao;
import com.vriche.adrm.model.AnalyzeClass;
import com.vriche.adrm.model.OrderDayInfo;

public interface AnalyseManager extends Manager {
	
    public void setAnalyDao(AnalyDao analyDao);
    
    public int getResourceAdverPageCount(AnalyzeClass aAnalyzeClass);
	public List getResourceAdver(AnalyzeClass aAnalyzeClass,String pageIndex,String pageSize);
	public String getResourceAdverXML(AnalyzeClass aAnalyzeClass,String pageIndex,String pageSize);
	
//	public List getBrand(AnalyzeClass aAnalyzeClass,String pageIndex,String pageSize);
	public int getBrandPageCount(AnalyzeClass analyzeClass);
	public List getBrand(AnalyzeClass analyzeClass, String pageIndex, String pageSize, String pageCount);
	public String getBrandXML(AnalyzeClass analyzeClass, String pageIndex, String pageSize, String pageCount);
	  //订单类别统计
    public String getOrderCategoryByCarrierTypeXML(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint);
    public String getOrderCategoryByCustomerXML(AnalyzeClass analyzeClass,String year,String[] customerIds,String userId,String carrierName,int channelModelParam,String theUser);
	
	public Collection getBrandReport(AnalyzeClass analyzeClass);
	public Collection getResourceAdverReport(AnalyzeClass analyzeClass);
	
	public List getCarrierBasalReportByBeginAndEndDatePandect(int channelModelParam, String beginDate, String endDate, String userId, String carrierName, String curUserName, String isPrint);
	
	public 	Map getCarrierBasalByBeginAndEndDate(int channelModelParam,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);
	public String getCarrierBasalByBeginAndEndDateXML(int channelModelParam,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint);

	public List getCarrierBasalReportByBeginAndEndDate(int channelModel,String beginDate, String endDate,String userId,String carrierName,String curUserName,String isPrint);

	public List getOrderCategoryByCustomer(String sortStr,String year,String startDate,String endDate, String[] customerIds,String userId,String carrierName,int channelModelParam,String theUser);
	
	public Map getOrderCategoryByCarrierType(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint);
	
	public List getOrderCategoryByCarrierTypePandect(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint);
	
	public Map getAreaCustomerByCarrierType(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint);
	
	public List getAreaCustomerByCarrierPandect(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint);
	
	public List getAreaCustomerByCarrier(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint);
	
	public List getOrderCategoryByCarrierType1(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint);
}
