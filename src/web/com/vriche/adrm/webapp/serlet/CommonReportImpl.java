package com.vriche.adrm.webapp.serlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.service.FinanceTargetRatioManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.ProAnalyzeManager;
import com.vriche.adrm.service.ProAudienceRatManager;
import com.vriche.adrm.service.ProCustomerManager;
import com.vriche.adrm.service.ProOrderManager;
import com.vriche.adrm.service.ProProgramManager;
import com.vriche.adrm.service.ProPublishPlanManager;
import com.vriche.adrm.service.PublishArrangeManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.webapp.util.JasperReportUtil;

public class CommonReportImpl  extends HttpServlet{
	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		String queryStrings = StringUtil.getURLDecoderStr(request.getQueryString());
		String queryString = StringUtil.getURLDecoderStr(queryStrings);
		
//		String model = StringUtil.getParamFromUrl(queryString,"model");
//		String reportType =StringUtil.getParamFromUrl(queryString,"reportType");
//		String header =  StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(queryString,"headers"));
//		boolean isSum = Boolean.valueOf(StringUtil.getParamFromUrl(queryString,"isSum")).booleanValue();
		
		
		String model = request.getParameter("model");
		String reportType = request.getParameter("reportType");
		String header =  StringUtil.getURLDecoderStr(request.getParameter("headers"));
		String displaySumColum =  StringUtil.getURLDecoderStr(request.getParameter("displaySumColum"));
		boolean isSum = Boolean.valueOf(request.getParameter("isSum")).booleanValue();
		boolean isVertical = Boolean.valueOf(request.getParameter("isVertical")).booleanValue();
		
		
//		System.out.println("*****************model 3333333333333333333333333333333333333*******************"+model);
		
		
		
		
		 System.out.println("************************************");
		 System.out.println("queryString>>>>>>>>"+queryString);
		 System.out.println("model>>>>>>>>"+model);
		 System.out.println("reportType>>>>>>>>11111111111111111"+reportType);
		 System.out.println("header>>>>>>>>"+ header);
		 System.out.println("displaySumColum>>>>>>>>"+displaySumColum);
		 System.out.println("isSum>>>>>>>>"+isSum);
		 System.out.println("isVertical>>>>>>>>"+isVertical);
		 
		 System.out.println("************************************");
		 
		 
		String[] title = new String[1];
		String[] headers = header.split(",");
		String[] alias = JasperReportUtil.preaseAliasColumnHeaders(headers);  
		String[] displaySumColums = displaySumColum.split(","); 
		
		
		Map parameters = new HashMap();	
		
		Collection coll = getCollectionByType(reportType,queryString, title);
		
		
//		 System.out.println("title>>>>>>>>"+title[0]);
		
		JasperPrint jasperPrint = null;

		try
		{
  
			JasperReport jasperReport = JasperReportUtil.getJasperReport(reportType,title[0],headers,alias,displaySumColums,isSum,isVertical);
												
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
		

		if (jasperPrint != null)
		{
			
			if(model.equals("print") || model.equals( "view")){
				response.setContentType("application/octet-stream");
				ServletOutputStream ouputStream = response.getOutputStream();
				
				ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
				oos.writeObject(jasperPrint);
				oos.flush();
				oos.close();

				ouputStream.flush();
				ouputStream.close();
				
//				String contextPath = request.getContextPath();
//				String redirectPath = contextPath + "/reports/audienceRatList.jsp?"+queryString;
//				response.sendRedirect(redirectPath);
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
//	             exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED,Boolean.TRUE);
	             exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED,Boolean.TRUE);
	             try {
	            	 exporter.exportReport();
	             }catch (JRException ex) {
//	            	 out.println("Jasper Output Error:" + ex.getMessage());
	             }
	             

	             byte[] bytes = oStream.toByteArray();

	             if (bytes != null && bytes.length > 0) {
	                     response.reset();
	                     response.setContentType("application/vnd.ms-excel");
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
		else
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");
			
			out.println("<body bgcolor=\"white\">");
	
			out.println("<span class=\"bold\">Empty response.</span>");
	
			out.println("</body>");
			out.println("</html>");
		}			
		
	}
	
	public Collection getCollectionByType(String type,String queryString,String[] title)
	{
		Collection coll = null;
        
        if(type.endsWith("publishArrange_report")){
        	title[0] = StringUtil.getParamFromUrl(queryString,"carrierName")+StringUtil.getParamFromUrl(queryString,"publishDate"); 
        	PublishArrangeManager mgr = (PublishArrangeManager) getBean("publishArrangeManager");
    		coll = mgr.getCollections(queryString);            
        }
        if(type.endsWith("incomeForm_report")){
        	title[0] = "集团大客户到款一览表";
        	IncomeManager mgr = (IncomeManager) getBean("incomeManager");
    		coll = mgr.getCollections(queryString);
        }
        if(type.endsWith("industryTypeChannelProduct_report")){
        	title[0] = "品牌投播情况表";
        	OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
    		coll = mgr.getIndustryTypeProductChannelCollections(queryString,"report");
        }
        if(type.endsWith("resource_report")){
        	title[0] = StringUtil.getParamFromUrl(queryString,"carrierName");
    		ResourceManager mgr = (ResourceManager) getBean("resourceManager");
    		coll = mgr.getCollections(queryString,"report");
    		
    		System.out.println(">>>>999999999999999999999999999999999999999999999999999999999>>>>>"+coll.size());
    		
        }
        
        if(type.endsWith("specificQuery_report")){
        	title[0] = "指定信息查询";
        	OrderManager mgr = (OrderManager) getBean("orderManager");
    		coll = mgr.getCollections(queryString,"report");
        }
        
        if(type.endsWith("audienceRate_report")){
        	title[0] = "收视率";
    		ProAudienceRatManager mgr = (ProAudienceRatManager) getBean("proAudienceRatManager");
    		coll = mgr.getCollections(queryString,"report");
        }
        
        if(type.endsWith("proOrder_report")){
        	title[0] = "订单一览";
        	ProOrderManager mgr = (ProOrderManager) getBean("proOrderManager");
    		coll = mgr.getCollections(queryString,"report");
        }
        
        if(type.endsWith("program_report")){
        	title[0] = "节目一览";
        	ProProgramManager mgr = (ProProgramManager) getBean("proProgramManager");
    		coll = mgr.getCollections(queryString,"report");
        }
        
        if(type.endsWith("proCustomer_report")){
        	title[0] = "客户一览";
        	ProCustomerManager mgr = (ProCustomerManager) getBean("proCustomerManager");
    		coll = mgr.getCollections(queryString,"report");
        }
        
        if(type.endsWith("incomePulls_report")){
        	title[0] = "到款分配一览";
        	ProOrderManager mgr = (ProOrderManager) getBean("proOrderManager");
    		coll = mgr.getCollectionsByIncomePulls(queryString,"report");
        }
        
        if(type.endsWith("payment_report")){
        	title[0] = "欠款查询";
        	ProOrderManager mgr = (ProOrderManager) getBean("proOrderManager");
    		coll = mgr.getCollectionsByPayment(queryString,"report");
        }
        
        if(type.endsWith("costAnalyze_report")){
        	title[0] = "节目成本分析";
        	ProAnalyzeManager mgr = (ProAnalyzeManager) getBean("proAnalyzeManager");
    		coll = mgr.getCollectionsByCostAnalyze(queryString,"report");
        }
        
        if(type.endsWith("proProgramAudienceRate_report")){
        	title[0] = "节目收视分析";
        	ProAnalyzeManager mgr = (ProAnalyzeManager) getBean("proAnalyzeManager");
    		coll = mgr.getCollectionsByProgramAudienceRate(queryString,"report");
        }
        
        if(type.endsWith("proPublishPlan_report")){
        	title[0] = "播出计划一览";
        	ProPublishPlanManager mgr = (ProPublishPlanManager) getBean("proPublishPlanManager");
    		coll = mgr.getCollections(queryString,"report");
        }
        
        if(type.endsWith("proProgramIncome_report")){
        	title[0] = "节目收入一览";
        	ProAnalyzeManager mgr = (ProAnalyzeManager) getBean("proAnalyzeManager");
    		coll = mgr.getCollectionsByIncome(queryString,"report");
        }
        
        if(type.endsWith("proProgramCostIncomeAudience_report")){
        	title[0] = "成本收入收视一览";
        	ProAnalyzeManager mgr = (ProAnalyzeManager) getBean("proAnalyzeManager");
    		coll = mgr.getCollectionsByCostIncomeAudience(queryString,"report");
        }
        
        
        
        if(type.endsWith("orderList")){
        	title[0] = "订单浏览";
        	OrderManager mgr = (OrderManager) getBean("orderManager");
    		coll = mgr.getCollectionsOrderList(queryString,"report");
        }   
        
       
        
        
//        if(type.endsWith("financeTargetRatioCarrierList")){
//        	
//        	title[0] = "公司上报数"; 
//        	
//        	 System.out.println("financeTargetRatioCarrierList>>>>>>>>>>>>>financeTargetRatioCarrierList   1111111111 66666666666666666666666666 vvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>"+type);
//
//        	FinanceTargetRatioManager mgr = (FinanceTargetRatioManager) getBean("financeTargetRatioManager");
//        	
//        	 System.out.println("financeTargetRatioCarrierList>>>>>>>>>>>>> mgr 2222222222222222  66666666666666666666666666 vvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>"+mgr);
//      		
//        	 
//        	
//    		coll = mgr.getFinanceTargetRaioCarriers(queryString);
//    		
//    		System.out.println("financeTargetRatioCarrierList>>>>>>>>>>>>>financeTargetRatioCarrierList 66666666666666666666666666 vvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>"+coll.size());
//    		
//        }  
        
        
        
   if(type.equals("inecomeNewList")){
	   
//	   System.out.println("inecomeNewList>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvinecomeNewList vvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>"+type);
	   
        	title[0] = "到款信息";
        	IncomeManager mgr = (IncomeManager) getBean("incomeManager");
        	Map searchMap = mgr.buildsearchMap(queryString);
    		coll = mgr.getCollections(searchMap,"report",0,-1);
    		
//    		System.out.println("inecomeNewList>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvinecomeNewList vvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>"+coll.size());
        }        
        
//        if(type.endsWith("arrearsList")){
//        	title[0] = "欠款浏览";
//        	FinanceTargetManager mgr = (FinanceTargetManager) getBean("financeTargetManager");
//    		coll = mgr.getArrearsColl(queryString,"report");
//    		System.out.println("title>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>>>>>"+title[0]);
//        }   
        
		return coll;
	}
	
    public Object getBean(String name) {
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
	
}
