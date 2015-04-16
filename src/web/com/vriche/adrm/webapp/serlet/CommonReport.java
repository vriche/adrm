/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2006 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 303 Second Street, Suite 450 North
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */
package com.vriche.adrm.webapp.serlet;

//import java.io.DataInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.AnalyzeClass;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.ResourceLimit;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.AnalyseManager;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.FinanceTargetManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.ResourceLimitManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class CommonReport extends HttpServlet
{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -5635477054559783925L;

	/**
	 *
	 */
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
			
		ServletContext context = this.getServletConfig().getServletContext();
//		Org org = (Org) context.getAttribute(Constants.AVAILABLE_ORG);
//		 SecurityContext ctx = SecurityContextHolder.getContext();
//		 System.out.println("++++    "+ctx.getAuthentication());
		String fileSep = Constants.FILE_SEP;
		String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;
		File reportFile = null;
		   String orderCode =null ;
		   String contractCode = null;
		   String relationCode =null ;
		   String orderStates=null;
		   String userId=null;
		   String customerId=null;
		   String yearForm;
		   String isType;
		   String isDetail;
		   String customerIdsForm ;
		   String yearOrQuarterForm;
		   String totalOrdetail;
		   String startDate;
	       String endDate ;
	       String userIdCus ;
		   String carrierName ;
		   String userName;
		   String isPrint;
	       String isPutOnORIncome;
	       String channelModeId;
	       String theUser;
	       String channelModel;
	      
	       String putYear;
	       String incomPurs;
	       String returnValue;
	      
	       Collection coll = new ArrayList();
		   HttpSession session = request.getSession();
		   String        model=  (String)session.getAttribute("model");
		   String 		 reportType = (String)session.getAttribute("reportType");
		   String isArrears;
		   String moneyRPay;
		   String category;
		   String matterName;
		   String matterEdit;
		   String matterType;
		   String carrierId;
		   String orgId;
		   Map parameters = new HashMap();
		   if(reportType.equals("orderList")){
			   orderCode=  (String)session.getAttribute("orderCode");
			   contractCode = (String)session.getAttribute("contractCode");
//			   System.out.println("contractCode<<<<<<<3333333333<<<<<<<<<<<"+contractCode);
			   relationCode=  (String)session.getAttribute("relationCode");
			   orderStates=  (String)session.getAttribute("orderStates");
			   userId=  (String)session.getAttribute("userId");
			   String customerName=  (String)session.getAttribute("customerName");
//			   String cgName = "";
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   isArrears = (String)session.getAttribute("isArrears");
			   moneyRPay = (String)session.getAttribute("moneyRPay");
			   userName = (String)session.getAttribute("userName");
			   category = (String)session.getAttribute("category");
			   matterName = (String)session.getAttribute("matterName");
			   carrierId = (String)session.getAttribute("carrierId");
			   channelModel = (String)session.getAttribute("channelModel");
			   String selectImportOrder = (String)session.getAttribute("selectImportOrderForm");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"order_list.jasper")) ;
			   
			   boolean isGBK =  StringUtil.isGBK(category);
				  if(!isGBK){
					  category = StringUtil.toGBK(category);
				  }
			   
//			   byte categoryByte[] = category.getBytes("ISO8859-1");
//			   String cgName = new String(categoryByte,"GBK");
			   
//			   System.out.println(cgName+" 1  "+endDate+" 2 "+isArrears+" 3 "+userName+" 4 "+customerId+" 5 "+orderStates);

				//设置标题
				parameters.put("ReportTitle",  "订单明细");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
//(String orderCode,String orderStates,String userId,String customerId,String isArrears,String startDate,String endDate)
				coll = getOrderList(channelModel,relationCode,orderCode,contractCode,orderStates,userId,customerName,isArrears,moneyRPay,startDate,endDate,userName,category,matterName,carrierId,selectImportOrder);
				
		   }
		   
		   if(reportType.equals("financeTargetAnalyze_report")){
			   yearForm=  (String)session.getAttribute("yearForm");
			   userName=  (String)session.getAttribute("userName");
			   carrierId = (String)session.getAttribute("carrierIds");
			   channelModeId=  (String)session.getAttribute("channelModelForm");
//			   theUser=  (String)session.getAttribute("theUser");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"financeTargetAnalyze_report.jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "年度指标统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getfinanceTargetAnalyzeColl(yearForm,userName,carrierId,channelModeId);
				
		   }
		   
		   if(reportType.equals("customerAnalyze")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   userIdCus =(String)session.getAttribute("userIdForm");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   customerId = (String)session.getAttribute("customerId");
			   channelModeId = (String)session.getAttribute("channelModeId");
			   theUser = (String)session.getAttribute("nowUser");
			   
			   String[] sorStr = ((String)session.getAttribute("sortStr")).split(",");
			   putYear  = (String)session.getAttribute("putYear");
			   incomPurs  = (String)session.getAttribute("incomPurs");
			   returnValue = (String)session.getAttribute("returnValue");
			   String resourceTypeId = (String)session.getAttribute("resourceTypeId");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"customerAnalyze_report.jasper")) ;
			   
			   orgId = (String)session.getAttribute("orgId");


				//设置标题
				parameters.put("ReportTitle",  "客户区间统计");
				parameters.put("Colum0",  "客户名称");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getCustomerAnalyzeColl(orgId,resourceTypeId,startDate,endDate,sorStr[0],sorStr[1],putYear,userIdCus,carrierName,userName,customerId,channelModeId,theUser,incomPurs,returnValue);
				
		   }
		   
		   if(reportType.equals("areaCustomerAnalyze_report")){
			   yearForm=  (String)session.getAttribute("yearForm");
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierIds");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   channelModel = (String)session.getAttribute("channelModel");
			   isDetail = (String)session.getAttribute("isDetail");
			   

			   
			   String[] carrierIds = carrierName.split(",");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"areaCustomerAnalyze_report.jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "区域客户统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getareaCustomerAnalyzeColl(carrierIds,channelModel,startDate,endDate,userId,userName,isPrint,isDetail);
				
		   }
		   
		   if(reportType.equals("orderCategoryCustomer_report")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierIds");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   channelModel = (String)session.getAttribute("channelModel");
			   isDetail = (String)session.getAttribute("isDetail");
			   
			   String[] carrierIds = carrierName.split(",");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"orderCategoryCustomer_report.jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "订单类别客户统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getorderCategoryCustomerAnalyzeColl(carrierIds,channelModel,startDate,endDate,userIdCus,userName,isPrint,isDetail);
				
		   }
		   
		   if(reportType.equals("matter_report")){
			 	matterName=  (String)session.getAttribute("name");
			 	customerId = (String)session.getAttribute("customerId");
			 	matterEdit =(String)session.getAttribute("edit");
			 	matterType =(String)session.getAttribute("matterType");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"matter_report.jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "广告素材统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				MatterManager mgr = (MatterManager) getBean("matterManager");
				Matter matter = new Matter();
				if(!"".equals(customerId)){
					matter.setCustomerId(new Long(customerId));
				}
				if(!"".equals(matterType)){
					matter.setMatterType(new Integer(matterType));
				}
				matter.setName(matterName);
				matter.setEdit(matterEdit);
				coll = mgr.getMatterReport(matter);
				
		   }
		   
		   if(reportType.equals("customerProduct")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierIds");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   channelModel = (String)session.getAttribute("channelModel");
			   isDetail = (String)session.getAttribute("isDetail");
			   

				
			   orgId = (String)session.getAttribute("orgId");

			   
			   
			   String[] carrierIds = carrierName.split(",");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"customerProduct_report.jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "客户品牌投放量");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getCustomerProductColl(carrierIds,channelModel,startDate,endDate,userIdCus,userName,isPrint,isDetail,orgId);
				
		   }		
		   
		   if(reportType.equals("orderCategoryCarrier_report")){
			   customerIdsForm =  (String)session.getAttribute("customerIdsForm");
			   yearForm =  (String)session.getAttribute("yearForm");
//			   yearOrQuarterForm =  (String)session.getAttribute("yearOrQuarterForm");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   channelModel = (String)session.getAttribute("channelModel");
			   String sorStr = ((String)session.getAttribute("sortStr"));
//			   String putYear  = (String)session.getAttribute("putYear");
//			   String incomPurs  = (String)session.getAttribute("incomPurs");
//			   String returnValue  = (String)session.getAttribute("returnValue");
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   
			   
			   String[] ids = customerIdsForm.split(",");
			   parameters.put("ReportTitle",  "客户订单类别统计");
				coll = getorderCategoryCarrierByCustomer(sorStr,ids,yearForm,userIdCus,carrierName,userName,channelModel,startDate,endDate);	
				reportFile = new File(context.getRealPath(reportsTemplePath +"orderCategoryCarrier_report.jasper")) ;
				
		   }
		   
		   if(reportType.equals("yearAnalyze_report")){
			   String type  = (String)session.getAttribute("type");
			   customerIdsForm =  (String)session.getAttribute("customerIdsForm");
			   yearForm =  (String)session.getAttribute("yearForm");
//			   yearOrQuarterForm =  (String)session.getAttribute("yearOrQuarterForm");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   channelModel = (String)session.getAttribute("channelModel");
			   String sorStr = ((String)session.getAttribute("sortStr"));
			   putYear  = (String)session.getAttribute("putYear");
			   incomPurs  = (String)session.getAttribute("incomPurs");
			   returnValue  = (String)session.getAttribute("returnValue");
			   String resourceTypeId = (String)session.getAttribute("resourceSortId");
			   orgId  = (String)session.getAttribute("orgId");
//			   System.out.println("resourceTypeId<!1111111111vvvvvvvvvvvvvvvvvvvvvvvvvvv1111111111<<<<<<<<<<<<<<<<<<"+resourceTypeId);
			   
			   String[] ids = customerIdsForm.split(",");
				if(type.equals("1")){
//					coll = getCustomerByYearForReport(type,sorStr,putYear,ids,yearForm,userIdCus,carrierName,userName,channelModel);	
					parameters.put("ReportTitle",  "客户全年统计");
					parameters.put("Colum0",  "月份");
//				    reportFile = new File(context.getRealPath(reportsTemplePath +"yearAnalyze_report.jasper")) ;
					 
					 
				}else{
//					coll = getCustomerByQuarterForReport(ids,yearForm,userIdCus,carrierName,userName,channelModel);	
					parameters.put("ReportTitle",  "客户季度统计");
					parameters.put("Colum0",  "季度");
//					 reportFile = new File(context.getRealPath(reportsTemplePath +"quarterAnalyze_report.jasper")) ;
				}
				coll = getCustomerByYearForReport(orgId,resourceTypeId,type,sorStr,putYear,ids,yearForm,userIdCus,carrierName,userName,channelModel,incomPurs,returnValue);	
				reportFile = new File(context.getRealPath(reportsTemplePath +"customerAnalyze_report.jasper")) ;
				
		   }
		    
		   if(reportType.equals("businessAnalyze_report")){
			   String type  = (String)session.getAttribute("type");
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   isPutOnORIncome =  (String)session.getAttribute("isPutOnORIncome");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   channelModel = (String)session.getAttribute("channelModelParam");
			   String sorStr = ((String)session.getAttribute("sortStr"));
			   putYear  = (String)session.getAttribute("putYear");
			   incomPurs  = (String)session.getAttribute("incomPurs");
			   returnValue  = (String)session.getAttribute("returnValue");
			   orgId  = (String)session.getAttribute("orgId");
			   
			   
//			   System.out.println("22222222222222isNotReturnValue>>>>>>>>>>>>>>>>>>"+returnValue);
			   
				if(type.equals("1")){
//					coll = getBusinessInfosColl(startDate,endDate,userIdCus,carrierName,userName,channelModel);	
					parameters.put("ReportTitle",  "业务员应收统计");
//					 reportFile = new File(context.getRealPath(reportsTemplePath +"businessAnalyze_report.jasper")) ;
				}else{
//					coll = getPutOnInfosColl(startDate,endDate,userIdCus,carrierName,userName,channelModel);	
					parameters.put("ReportTitle",  "业务员到款统计");
//					 reportFile = new File(context.getRealPath(reportsTemplePath +"businessAnalyze_report.jasper")) ;
				}
				coll = getBusinessInfosColl(orgId,startDate,endDate,type,sorStr,userIdCus,carrierName,userName,channelModel,putYear,returnValue,incomPurs);	
				 reportFile = new File(context.getRealPath(reportsTemplePath +"businessAnalyze_report.jasper")) ;
				
		   }
		   if(reportType.equals("industryTypeProduct")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   totalOrdetail =  (String)session.getAttribute("totalOrdetail");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   channelModel = (String)session.getAttribute("channelModel");
			   isDetail = (String)session.getAttribute("isDetail");
				if(isDetail.equals("1")){
					coll = (Collection)getIndustryTypeProductColl(channelModel,startDate,endDate,userIdCus,carrierName,userName,isPrint);	
					parameters.put("ReportTitle",  "行业明细报表");
					 reportFile = new File(context.getRealPath(reportsTemplePath +"industryTypeProduct_report.jasper")) ;
				}else{
					coll = (Collection)getIndustryTypeTotalColl(channelModel,startDate,endDate,userIdCus,carrierName,userName,isPrint);	
					parameters.put("ReportTitle",  "行业总览报表");
					 reportFile = new File(context.getRealPath(reportsTemplePath +"industryTypeDetial_report.jasper")) ;
				}
		   }
		   if(reportType.equals("carrierBasalAnalyze")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   totalOrdetail =  (String)session.getAttribute("totalOrdetail");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   channelModel = (String)session.getAttribute("channelModel");
			   isDetail = (String)session.getAttribute("isDetail");
			   
			   coll = (Collection)getCarrierBasalAnalyzeColl(channelModel,startDate,endDate,userIdCus,carrierName,userName,isPrint,isDetail);	
			   parameters.put("ReportTitle",  "载体构成统计");
			   reportFile = new File(context.getRealPath(reportsTemplePath +"carrierBasalAnalyze_report.jasper")) ;
		   }
		   if(reportType.equals("carrierScopeAnalyze_report")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   userIdCus =(String)session.getAttribute("userId");
			  // carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   //省去声明carrierIds对象
			   customerIdsForm = (String)session.getAttribute("carrierIds");
			   String orderCategoryId = (String)session.getAttribute("orderCategoryId");
			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"carrierScopeAnalyze_report.jasper")) ;
			   
			   String[] carrierIds = customerIdsForm.split(",");
				//设置标题
				parameters.put("ReportTitle",  "载体区间统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getCarrierScopeAnalyzeColl(startDate,endDate,carrierIds,userIdCus,userName,isPrint,orderCategoryId);
				
		   }
		   if(reportType.equals("resourceAudienceAnalyze_report")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   userIdCus =(String)session.getAttribute("userId");
			  // carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   isPrint = (String)session.getAttribute("isPrint");
			   //省去声明carrierIds对象
			   customerIdsForm = (String)session.getAttribute("carrierIds");
			   String orderCategoryIdForm = (String)session.getAttribute("orderCategoryIdForm");
			   reportFile = new File(context.getRealPath(reportsTemplePath +"resourceAudienceAnalyze_report.jasper")) ;
			   
			   String[] carrierIds = customerIdsForm.split(",");
				//设置标题
				parameters.put("ReportTitle",  "载体收视统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getResouceAudienceAnalyzeColl(startDate,endDate,carrierIds,userIdCus,userName,isPrint,orderCategoryIdForm);
				
		   }
		   if(reportType.equals("carrierAllYearAnalyze_report")){
			   yearForm=  (String)session.getAttribute("yearForm");
			   customerIdsForm=  (String)session.getAttribute("carrierIds");
			   userIdCus =(String)session.getAttribute("userId");
			  // carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   isPrint = (String)session.getAttribute("isPrint");
			   isType = (String)session.getAttribute("isType");
			   isDetail = (String)session.getAttribute("isDetail");
			   //省去声明carrierIds对象
			   reportFile = new File(context.getRealPath(reportsTemplePath +"carrierAllYearAnalyze_report.jasper")) ;
			   
			   String[] carrierIds = customerIdsForm.split(",");
				//设置标题
				parameters.put("ReportTitle",  "载体全年统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				
				coll = getCarrierAllYearColl(yearForm,carrierIds,userIdCus,userName,isPrint,isType,isDetail);
				
		   }
		   if(reportType.equals("advTypeProductRelIncome_report")){
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   userIdCus =(String)session.getAttribute("userId");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   isPrint = "true";
			   channelModel = (String)session.getAttribute("channelModelParam");
			   
			   //省去声明carrierIds对象
			   reportFile = new File(context.getRealPath(reportsTemplePath +"advTypeProductRelIncome_report.jasper")) ;
			   
			  
				//设置标题
				parameters.put("ReportTitle",  "广告类型品牌投放量");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				Double d=new Double(0);new String(d.toString());
				coll = getadvTypeProductRelIncomeColl(channelModel,startDate,endDate,userIdCus,carrierName,userName,isPrint);
				
		   }
		   if(reportType.equals("income_report")){
			   customerId=  (String)session.getAttribute("customerId");
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   String  startDatePull=  (String)session.getAttribute("startDatePull");
			   String  endDatePull=  (String)session.getAttribute("endDatePull");
			   String  customerName=  (String)session.getAttribute("customerName");
			   String  resourceCarrierId=  (String)session.getAttribute("resourceCarrierId");
			   String  currentUser=  (String)session.getAttribute("currentUser");
			   String  incomePullDate=  (String)session.getAttribute("incomePullDate");
			   String  incomeCode=  StringUtil.getNullValue(session.getAttribute("incomeCode"),null);
			   orgId=  (String)session.getAttribute("orgId");
			   

			   
			   reportFile = new File(context.getRealPath(reportsTemplePath +"income_report.jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "客户到款统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				parameters.put("orgId", orgId);
				
				
				if("".equals(incomeCode) || "null".equals(incomeCode))incomeCode = null;
				if("".equals(customerId) || "null".equals(customerId))customerId = null;
				if("".equals(customerName) || "null".equals(customerName))customerName = null;
				
//				  System.out.println(">>>>>incomeCode>>>>8888888888888888888888888888888888>>" +incomeCode);
//				   System.out.println(">>>>>customerId>>>>8888888888888888888888888888888888>>" +customerId);
//				   System.out.println(">>>>>customerName>>>>8888888888888888888888888888888888>>" +customerName);
//				   
//				   System.out.println(">>>>>startDate>>>>8888888888888888888888888888888888>>" +startDate);
//				   System.out.println(">>>>>endDate>>>>8888888888888888888888888888888888>>" +endDate);
//				   
//				   System.out.println(">>>>>startDatePull>>>>8888888888888888888888888888888888>>" +startDatePull);
//				   System.out.println(">>>>>endDatePull>>>>8888888888888888888888888888888888>>" +endDatePull);
//				   
//				   System.out.println(">>>>>resourceCarrierId>>>>8888888888888888888888888888888888>>" +resourceCarrierId);
//				   System.out.println(">>>>>currentUser>>>>8888888888888888888888888888888888>>" +currentUser);
//				   
//				   System.out.println(">>>>>incomePullDate>>>>8888888888888888888888888888888888>>" +incomePullDate);
//				   System.out.println(">>>>>incomeCode>>>>8888888888888888888888888888888888>>" +incomeCode);
//				   System.out.println(">>>>>orgId>>>>8888888888888888888888888888888888>>" +orgId);
//				   

				   
				
				coll = getIncomeColl(customerId,startDate,endDate,startDatePull,endDatePull,customerName,resourceCarrierId,currentUser,incomePullDate,incomeCode);
				
		   }
		   

		   if(reportType.equals("carrierTarget")){
			   yearForm=  (String)session.getAttribute("yearForm");
			   startDate=  (String)session.getAttribute("startDate");
			   endDate=  (String)session.getAttribute("endDate");
			   customerId=  (String)session.getAttribute("customerId");
			   userIdCus =(String)session.getAttribute("userIdForm");
			   carrierName =(String)session.getAttribute("carrierName");
			   userName = (String)session.getAttribute("userName");
			   channelModel = (String)session.getAttribute("channelModeId");
			   putYear =(String)session.getAttribute("putYear");
			   incomPurs = (String)session.getAttribute("incomPurs");
			   returnValue = (String)session.getAttribute("returnValue");
			   isDetail = (String)session.getAttribute("isDetail");
			   orgId = (String)session.getAttribute("orgId");
			   orgId = (String)session.getAttribute("orgId");
			   customerId = (String)session.getAttribute("customerId");
			   
			   
			   //省去声明carrierIds对象
			   reportFile = new File(context.getRealPath(reportsTemplePath +"carrierFinanceTarget_report.jasper")) ;
			   
			  
				//设置标题
				parameters.put("ReportTitle",  "频道指标对比统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
	
				coll = getcarrierFinanceTargetColl(orgId,userIdCus,channelModel,yearForm,startDate,endDate,carrierName,userName,putYear,incomPurs,returnValue,isDetail,customerId);
				
		   }
		   
		   if(reportType.equals("resourceLimit_report")){
			
			   String start=  (String)session.getAttribute("startDate");
			   String end=  (String)session.getAttribute("endDate");
			   String  year=  (String)session.getAttribute("year");
			   String  resourceCarrierId=  (String)session.getAttribute("carrierId");
			   String  type=  (String)session.getAttribute("type");

			   reportFile = new File(context.getRealPath(reportsTemplePath +"resourceLimit_report.jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "广 告 资 源 预 警");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());
				ResourceLimit resourceLimit  = new ResourceLimit();
				
				resourceLimit.setCarrierId(new Long(resourceCarrierId));
				resourceLimit.setVersion(new Integer(year));
				resourceLimit.setStartTime(new Integer(start));
				resourceLimit.setEndTime(new Integer(end));
				resourceLimit.setPreT(type);
				
				ResourceLimitManager resourceLimitManager = (ResourceLimitManager) getBean("resourceLimitManager");
//				System.out.println("resourceLimit class>>>>>>>>>>"+resourceLimit.toString());
				
				coll = resourceLimitManager.getResourceLimitsColl(resourceLimit);
		   }	   
		   
		   
		   if(reportType.equals("brandAnalyze_report")){

			   String start =  (String)session.getAttribute("startDate");
			   String end =  (String)session.getAttribute("endDate");
			   userId =  (String)session.getAttribute("userId");
			   carrierId =  (String)session.getAttribute("carrierIds");
			   customerId =  (String)session.getAttribute("customerIds");
			   matterName =  (String)session.getAttribute("matterNames");
			   userName =  (String)session.getAttribute("userName");
			   String version =  (String)session.getAttribute("version");
			   
//			   System.out.println("start>>>>>>>>>>"+ start);
//			   System.out.println("end>>>>>>>>>>"+ end);
//			   System.out.println("userId>>>>>>>>>>"+ userId);
//			   System.out.println("carrierId>>>>>>>>>>"+ carrierId);
//			   System.out.println("customerId>>>>>>>>>>"+ customerId);
//			   System.out.println("matterName>>>>>>>>>>"+ matterName);
//			   System.out.println("userName>>>>>>>>>>"+ userName);
//			   System.out.println("version>>>>>>>>>>"+ version);
			   
			   


			   reportFile = new File(context.getRealPath(reportsTemplePath + reportType +".jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "品牌统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());

				
				String[] resourceIds = carrierId.split(",");
				String[] customerIds = customerId.split(",");
				String[] matterNames = matterName.split(",");
				String[] userIds = new String[1]; 
				if(Integer.parseInt(userId)>0){
					userIds[0] = userId;
				}else{
					userIds = new String[0]; 
				}
				
				AnalyzeClass analyze = new AnalyzeClass();
				analyze.setStartDate(start);
				analyze.setEndDate(end);
				analyze.setCurUserName(userName);
				analyze.setVersion(new Integer(version));
				
				analyze.getOrderDetail().getMatter().setResourceIds(resourceIds);
				analyze.getOrderDetail().getMatter().setCustomerIds(customerIds);
				analyze.getOrderDetail().getMatter().setMatterNames(matterNames);
				analyze.getOrderDetail().getMatter().setUserIds(userIds);

				AnalyseManager analyseManager = (AnalyseManager) getBean("analyseManager");
				coll = analyseManager.getBrandReport(analyze);

		   }
		   
		   
		   
		   if(reportType.equals("resourceAdverAnalyze_report")){

			   String start =  (String)session.getAttribute("startDate");
			   String end =  (String)session.getAttribute("endDate");
			   userId =  (String)session.getAttribute("userId");
			   carrierId =  (String)session.getAttribute("carrierIds");
			   String customerName =  (String)session.getAttribute("customerName");
			   userName =  (String)session.getAttribute("userName");
			   String version =  (String)session.getAttribute("version");
			   String weekStr =  (String)session.getAttribute("weekStr");
//			   System.out.println("start>>>>>>>>>>"+ start);
//			   System.out.println("end>>>>>>>>>>"+ end);
//			   System.out.println("userId>>>>>>>>>>"+ userId);
//			   System.out.println("carrierId>>>>>>>>>>"+ carrierId);
//			   System.out.println("customerName>>>>>>>>>>"+ customerName);
//			   System.out.println("userName>>>>>>>>>>"+ userName);
//			   System.out.println("version>>>>>>>>>>"+ version);
			   
			   
			   reportType = reportType+"3";

			   reportFile = new File(context.getRealPath(reportsTemplePath + reportType +".jasper")) ;
			   

				//设置标题
				parameters.put("ReportTitle",  "段位广告统计");
				//设置路径
				parameters.put("BaseDir", reportFile.getParentFile());

				String[] resourceIds = carrierId.split(",");
	
				AnalyzeClass analyze = new AnalyzeClass();
				analyze.setStartDate(start);
				analyze.setEndDate(end);
				analyze.setCurUserName(userName);
				analyze.setVersion(new Integer(version));
				analyze.getCustomer().setCustomerName(customerName);
				analyze.setResourceIds(resourceIds);
				analyze.getOrder().setUserId(new Long(userId));
				analyze.setWeekStr(weekStr);

				AnalyseManager analyseManager = (AnalyseManager) getBean("analyseManager");
				coll = analyseManager.getResourceAdverReport(analyze);

		   }	  
		   
		   
			if (!reportFile.exists())
				throw new JRRuntimeException("File order_report.jasper not found. The report design must be compiled first.");
			
			JasperPrint jasperPrint = null;
	
			try
			{				
				  JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
								
				jasperPrint = 
					JasperFillManager.fillReport(
						jasperReport,
						parameters, 
						new JRBeanCollectionDataSource(coll)
						);
				
			}
			catch (JRException e)
			{
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>JasperReports - Web Application Sample</title>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
				out.println("</head>");
				
				out.println("<body bgcolor=\"white\">");
	
				out.println("<span class=\"bnew\">JasperReports encountered this error :</span>");
				out.println("<pre>");
	
				e.printStackTrace(out);
	
				out.println("</pre>");
	
				out.println("</body>");
				out.println("</html>");
	
				return;
		}
		
		
			if(model.equals("print") || model.equals( "view")){
				response.setContentType("application/octet-stream");
				ServletOutputStream ouputStream = response.getOutputStream();
				
				ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
				oos.writeObject(jasperPrint);
				oos.flush();
				oos.close();

				ouputStream.flush();
				ouputStream.close();
			}

			
			if(model.equals("export")){
	             ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	             JRXlsExporter exporter = new JRXlsExporter();
//	             PrintWriter out = response.getWriter();

	             exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
	             exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,oStream);
	             exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE); 
	             exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
	             exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
	             exporter.setParameter(JRExporterParameter.OUTPUT_FILE, "export.xls");

	             try {
	            	 exporter.exportReport();
	             }catch (JRException ex) {
//	            	 out.println("Jasper Output Error:" + ex.getMessage());
	             }
	             

	             byte[] bytes = oStream.toByteArray();

	             if (bytes != null && bytes.length > 0) {
	                     response.reset();
	                     response.setContentType("application/vnd.ms-excel;filename=export.xls");
	                     response.setContentLength(bytes.length);
	                     ServletOutputStream ouputStream = response.getOutputStream();
	                     ouputStream.write(bytes, 0, bytes.length);
	                     ouputStream.flush();
	                     ouputStream.close();
	             } else {
//	                     out.println("bytes were null!");  
	             }					
			}
				
	}

	public Collection  getOrderList(String channelModel,String relationCode,String orderCode,String contractCode,String orderStates,String userId,
    		String customerName,String isArrears,String moneyRPay,String startDate,
    		String endDate,String userName,String category,String matterName,String carrierId,String selectImportOrder){
    	OrderManager mgr = (OrderManager) getBean("orderManager");
    	UserManager mgrUser = (UserManager) getBean("userManager");
    	CarrierManager carrierManager =(CarrierManager)getBean("carrierManager");
//		Order order = new Order();
		List categoryIds = new ArrayList();
		List userIdList = new ArrayList();
		Map mp = new HashMap();
		if((!"0".equals(userId) && !"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);

    		List ls = mgrUser.getOwnerUsersListForReport(userRelsMap,userName);

    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
    	if(!"".equals(customerName)){
    		mp.put("customerName",customerName);
    	}   	
    	
		List ls = getOrderStates(orderStates);
    	if(ls.size()>0){
    		mp.put("OrderStates",ls);
    	}else{
    		mp.put("OrderStates",null);
    	}
//    	  	
    	if(!"".equals(orderCode)){
    		mp.put("orderCode",orderCode);
    	} 
    	if(!"".equals(contractCode)){
    		mp.put("contractCode",contractCode);
    	} 
    	
    	if(!"".equals(relationCode)){
    		mp.put("relationCode",relationCode);
    	} 
    	
    	if(!"".equals(category)){
    	 	String cidstr = category.substring(1,category.length()-1);
        	String[] cIds = cidstr.split(",");
        	
        	CollectionUtils.addAll(categoryIds,cIds);
    		
    		mp.put("orderCategoryIds",categoryIds);
    	} 
    	
    	if(startDate!=null||startDate!=""){
    		mp.put("startDate",startDate);
    	}  
    	if(endDate!=null||endDate!=""){
    		mp.put("endDate",endDate);                       
    	} 
    	Integer isArrearsInt = isArrears.equals("")?new Integer(0):new Integer(isArrears);
    	
    	Double moneyRPayDouble = moneyRPay.equals("")?new Double(0):new Double(moneyRPay);
    	
//    	int channelModelParam = Integer.parseInt(channelModel);

//		判断是否分频道，值为1分，否则不分
//		boolean channelPull = false;
//		List carrierIdList = new ArrayList();
//		if(channelModelParam==1){ channelPull = true;}
//		carrierIdList = carrierManager.getCarrierIdLists(carrierId,channelPull,userName);
//		mp.put("carrierIdList",carrierIdList);
    	List carrierIdList = CarrierUtil.getCarrierIds(carrierId,"2",userName);
    	mp.put("carrierIdList",carrierIdList);
		
    	
    	if(!matterName.equals("")){
    	
    		mp.put("matterName",matterName);
    	}
    	
    	if(isArrearsInt.intValue() == 1){
    		mp.put("arrears",isArrears);
    	} 
    	if(isArrearsInt.intValue() == 2){
    		mp.put("noArrears",isArrears);
    	} 
    	
    	if(moneyRPayDouble.intValue() == 1){
    		mp.put("zero",moneyRPay);
    	} 
    	if(moneyRPayDouble.intValue() == 2){
    		mp.put("nozero",moneyRPay);
    	} 

    	if(selectImportOrder!=null){
    		mp.put("publishMemo",selectImportOrder);
    	}
    	return  mgr.getOrdersFromColl(mp);
    }
    
    private List getOrderStates(String states){
		List ls = new ArrayList();
		
		if((!"".equals(states) && states != null)){
			String[] stateArray = states.split(",");
//			StringUtil.printArray(stateArray);
			CollectionUtils.addAll(ls,stateArray);
		}
		return ls;
	}
    
    public Collection  getCustomerAnalyzeColl(String orgId,String resourceTypeId,String startDate,String endDate,String sorCol,String sorType,String putYear,String userId,String carrierName,String curUserName,String customerId,String channelModeId,String theUser,String incomPurs,String returnValue){
    	OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
    	return  mgr.getOrderDayInfosReport(orgId,resourceTypeId,startDate,endDate,sorCol,sorType,putYear,userId,carrierName,curUserName,customerId,channelModeId,theUser,incomPurs,returnValue);
    }
    
    public Collection  getfinanceTargetAnalyzeColl(String yearForm,String userName,String carrierId,String channelModeId){
    	int channelModelParam = Integer.parseInt(channelModeId);
    	FinanceTargetManager mgr = (FinanceTargetManager) getBean("financeTargetManager");
    	return  mgr.getFinanceTargetCarrierColl(mgr.getFinanceTargets(yearForm,userName,carrierId,channelModelParam));
    }
    
    public Collection  getCustomerProductColl(String[] carrierIds,String channelModel,String startDate,String endDate,String userId,String curUserName,String isPrint,String isDetail,String orgId){
    	OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
    	if(isDetail.equals("1")){
        	return  mgr.getCustomerProductByBeginAndEndDateColl(carrierIds,channelModel,startDate,endDate,userId,curUserName,isPrint,orgId);
    	}else{
    		int channelModelParam = new Integer(channelModel).intValue();
        	return  mgr.getOrderCategoryByCarrierTypePandect(carrierIds, channelModelParam, startDate, endDate, userId, curUserName, isPrint,orgId);
    	}
    }
   
    
    public Collection  getCustomerByYearForReport(String orgId ,String resourceTypeId,String type,String sortStr,String isPutYear,String[] ids,String yearForm,String userId,String carrierName,String curUserName,String channelModel,String incomPurs,String returnValue){
    	OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
    	return  mgr.getCustomerByYearForReport(orgId,resourceTypeId,type,sortStr,isPutYear,yearForm,ids,userId,carrierName,curUserName,channelModel,incomPurs,returnValue);
    }
    public Collection getCustomerByQuarterForReport(String[] customerIds,String year,String userId,String carrierName,String curUserName,String channelModel){
    	OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
    	return  mgr.getCustomerByQuarterForReport(year,customerIds,userId,carrierName,curUserName,channelModel);
    }
    
    public Collection getBusinessInfosColl(String orgId ,String start,String end ,String type,String sorStr,String userId,String carrierName,String userName,String channelModel,String isPutYear,String returnValue1,String incomPurs){
//    	boolean b=true;
    	OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
    	return  mgr.getBusinessInfosForReport(orgId ,start,end,type,sorStr,userId,carrierName,userName,false,channelModel,isPutYear,returnValue1,incomPurs);
    }
    
    public Collection getPutOnInfosColl(String start,String end ,String userId,String carrierName,String curUserName,String channelModel){
    	IncomeManager mgr = (IncomeManager) getBean("incomeManager");
    	return  mgr.getPutOnInfosColl(mgr.getPutOnInfosForReport(start,end,userId,carrierName,curUserName,channelModel));
    }
    
    public Collection getIndustryTypeProductColl(String channelModel,String start,String end,String userId,String carrierName,String curUserName,String isPrint ){
    	OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
    	int channelModelParam = Integer.parseInt(channelModel);
    	return  mgr.getIndustryTypeProductByBeginAndEndDate(channelModelParam,start,end,userId,carrierName,curUserName,isPrint);
    }
    
    public Collection getIndustryTypeTotalColl(String channelModel,String start,String end,String userId,String carrierName,String curUserName,String isPrint){
    	OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
    	int channelModelParam = Integer.parseInt(channelModel);
    	return  mgr.getIndustryTypeProductTotalBrowser(channelModelParam,start,end,userId,carrierName,curUserName,isPrint);
    }
    
    public Collection getCarrierBasalAnalyzeColl(String channelModel,String beginDate,String endDate,String userId,String carrierName,String curUserName,String isPrint,String isDetail){
    	AnalyseManager mgr = (AnalyseManager) getBean("analyseManager");
    	int channelModelParam = Integer.parseInt(channelModel);
    	if(isDetail.equals("1")){
        	return  mgr.getCarrierBasalReportByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,curUserName,isPrint);
    	}else{
        	return  mgr.getCarrierBasalReportByBeginAndEndDatePandect(channelModelParam,beginDate,endDate,userId,carrierName,curUserName,isPrint);
    	}
    }
    //客户订单类别统计（以客户为条件）
    private Collection getorderCategoryCarrierByCustomer(String sortStr, String[] customerIds, String year, String userId, String carrierName, String theUser, String channelModel, String startDate, String endDate) {
    	AnalyseManager mgr = (AnalyseManager) getBean("analyseManager");
    	int channelModelParam = Integer.parseInt(channelModel);
		return mgr.getOrderCategoryByCustomer(sortStr,year,startDate,endDate,customerIds,userId,carrierName,channelModelParam,theUser);
	}
    //订单类别客户统计（在类别中包括客户）
    private Collection getorderCategoryCustomerAnalyzeColl(String[] carrierIds, String channelModel, String beginDate, String endDate, String userId, String curUserName, String isPrint,String isDetail) {
    	AnalyseManager mgr = (AnalyseManager) getBean("analyseManager");
    	int channelModelParam = Integer.parseInt(channelModel);
    	if(isDetail.equals("1")){
    		return mgr.getOrderCategoryByCarrierType1(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
    	}else{
    		return mgr.getOrderCategoryByCarrierTypePandect(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
    	}
		
	}
    //区域客户统计
    private Collection getareaCustomerAnalyzeColl(String[] carrierIds, String channelModel, String beginDate, String endDate, String userId, String curUserName, String isPrint,String isDetail) {
    	AnalyseManager mgr = (AnalyseManager) getBean("analyseManager");
    	int channelModelParam = Integer.parseInt(channelModel);
    	

    	if(isDetail.equals("1")){
    		return mgr.getAreaCustomerByCarrier(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
    	}else{
    		return mgr.getAreaCustomerByCarrierPandect(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
    	}

	}
    
    public Collection getadvTypeProductRelIncomeColl(String channelModel,String start,String end,String userId,String carrierName,String curUserName,String isPrint){
    	OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
    	int channelModelParam = Integer.parseInt(channelModel);
    	return mgr.getAdvTypeProductByBeginAndEndDate(channelModelParam,start,end,userId,carrierName,curUserName,isPrint);
    	
    }
    
    public Collection getcarrierFinanceTargetColl(String orgId,String userIdCus,String channelModel,String yearForm,String startDate,String endDate,String carrierName,String userName,String putYear,String incomPurs,String returnValue,String isDetail,String customerId){
    	FinanceTargetManager ftm = (FinanceTargetManager) getBean("financeTargetManager");
    	int channelModelParam = Integer.parseInt(channelModel);
    	if(isDetail.equals("1")){
        	return ftm.getCarrierTargetByList(userIdCus,yearForm,startDate,endDate,carrierName,channelModelParam,userName,putYear,returnValue,incomPurs);
    	}else{
    		
        	return ftm.getCarrierTargetPandect(orgId,userIdCus,yearForm,startDate,endDate,carrierName,channelModelParam,userName,putYear,returnValue,incomPurs,customerId);
    	}
    }
    
    public Collection getCarrierScopeAnalyzeColl(String start,String end,String[] carrierIds,String userId,String curUserName,String isPrint,String orderCategoryId){
    	OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
    	return  mgr.getCarrierByDateColl(mgr.getCarrierByDate(start,end,carrierIds,userId,curUserName,isPrint,orderCategoryId));    	 
    }
    public Collection getResouceAudienceAnalyzeColl(String start,String end,String[] carrierIds,String userId,String curUserName,String isPrint,String orderCategoryId  ){
    	OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
    	return  mgr.getCarrierByDateColl(mgr.getAudienceMap(start,end,carrierIds,userId,curUserName,isPrint,orderCategoryId));    	 
    }
    public Collection getCarrierAllYearColl(String year,String[] carrierIds,String userId,String curUserName,String isPrint,String isType,String isDetail){
    	OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
    	if(isType.equals("1")){
    		if(isDetail.equals("1")){
        		return  mgr.getCarrierAllYearColl(mgr.getAllYearCarrier(year,carrierIds,userId,curUserName,isPrint));
    		}else{
        		return  mgr.getCarrierAllYearColl(mgr.getAllYearCarrierPandect(year,carrierIds,userId,curUserName,isPrint));
    		}
    	}else{
    		return  mgr.getCarrierAllYearColl(mgr.getAllYearCarrierRelPuton(year,carrierIds,userId,curUserName,isPrint));
    	}
    }
    
	public  boolean getChannelModelPara(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getChannelModelParam())) sysParam.setChannelModelParam("0");
	    return (sysParam.getChannelModelParam().equals("0"))?false:true;
	} 
	
    public Collection getIncomeColl(String customerId,String start,String end,String startPull,String endPull,String customerName,String resourceCarrierId,String currentUser,String incomePullDate,String incomeCode){
    	Income income = new Income();
    	
        String tvname = SysParamUtil.getTvNameParam();
        boolean xmtv = SysParamUtil.isXMTVParam(tvname);
        
        if(xmtv){
        	income.setCarrierIdList(null);
        	income.setResourceCarrierId(null);
        }else{
            List carrierIdList = CarrierUtil.getCarrierIds(resourceCarrierId,"1",currentUser);
        	income.setCarrierIdList(carrierIdList);
        	income.setResourceCarrierId(null);
        }
    	
//    	if(!customerId.equals("")&&customerId!=null)
    		
//    	if(customerName!=null){
//    		if(customerName.equals("")||customerName.equals("null")) customerName = null;
//    	}
    	if(incomePullDate!=null&&incomePullDate.length()==6){
        	income.setIncomePullDate(new Integer(incomePullDate));
    	}
//    	if(resourceCarrierId!=null){
//    		if(resourceCarrierId.equals("")||resourceCarrierId.equals("null")){
//    			income.setResourceCarrierId(new Long("0"));
//    		}else{
//    			income.setResourceCarrierId(new Long(resourceCarrierId));
//    		}
//    	}else{
//    		income.setResourceCarrierId(new Long("0"));
//    	}
    	
//    	String carrierId = String.valueOf(income.getResourceCarrierId());
//    	income.setResourceCarrierId(new Long(carrierId));
//    	
////    	System.out.println(">>>>>>>>>>>>carrierId2>>>>>>>>" + carrierId);
//    	if(carrierId.equals("0")){
//        	
//    		boolean channelPull = getChannelModelPara();
////    		System.out.println(">>>>>>>>>>>>carrierId2-1>>>>>>>>" + channelPull);
//    		CarrierManager carrierManager = (CarrierManager) getBean("carrierManager");
////    		String currentUser = UserUtil.getCurrentPrincipalUser();
////    		System.out.println(">>>>>>>>>>>>carrierId2-2>>>>>>>>" + currentUser);
//    		
//    		List carrierIdList = carrierManager.getCarrierIdListsNotChilden(carrierId,channelPull,currentUser);
////    		System.out.println(">>>>>>>>>>>>carrierId3>>>>>>>>" + carrierIdList.size());
//    		income.setCarrierIdList(carrierIdList);  	
//    		income.setResourceCarrierId(null);
//    	}else{
//    		income.setResourceCarrierId(new Long(carrierId));
//    	}
//    	
//    	List carrierIdList = CarrierUtil.getCarrierIds(carrierId,"1",currentUser);
//		income.setCarrierIdList(carrierIdList);  	
//		income.setResourceCarrierId(null);
		

//    	income.setCustomerId(new Long(customerId));
    	income.setStartDate(start);
    	income.setEndDate(end);
    	income.setIncomeModeName(startPull);
    	income.setIncomePurposeName(endPull);
    	income.setCustomerName(customerName);
    	income.setIncomeCode(incomeCode);
    	
    	IncomeManager mgr = (IncomeManager) getBean("incomeManager");
    	return  mgr.getIncomesColl(mgr.getIncomes(income));
    }
    public Object getBean(String name) {
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }	

}
