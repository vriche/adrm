package com.vriche.adrm.webapp.serlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Address;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.OrderCategoryManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.ReportManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.JasperReportUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;





public class ReportServlet  extends HttpServlet{
	 public static final String PRINT_TYPE = "print";
	 public static final String VIEW_TYPE = "view";
	 public static final String PDF_TYPE = "pdf";
	 public static final String EXCEL_TYPE = "excel";
	 public static final String WORD_TYPE = "word";
	 public static final String HTML_TYPE = "html";

	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{ 
		
		
		 System.out.println("************************************");
		String queryString =  request.getQueryString();
		Map searchMap = StringUtil.convertQueryStringtoMap(queryString);

		String model = (String)searchMap.get("model"); 
		String title = (String)StringUtil.getURLDecoderStr((String)searchMap.get("title"));
		String reportFileName =  (String)StringUtil.getURLDecoderStr((String)searchMap.get("reportFile"));
		String reportType = (String)searchMap.get("reportType");
		String header =  (String)StringUtil.getURLDecoderStr((String)searchMap.get("headers"));
		String displaySumColum =  (String)StringUtil.getURLDecoderStr((String)searchMap.get("displaySumColum"));
		boolean isSum = Boolean.valueOf((String)searchMap.get("isSum")).booleanValue();
		boolean isVertical = Boolean.valueOf((String)searchMap.get("isVertical")).booleanValue();
		String orgId = (String)StringUtil.getURLDecoderStr((String)searchMap.get("orgId"));
		if("".equals(orgId)) orgId ="1";
		
		String tvname = SysParamUtil.getTvNameParam();
		boolean qztv = SysParamUtil.isQZTVParam(tvname);
		boolean xmtv = SysParamUtil.isXMTVParam(tvname);
		boolean sjz = SysParamUtil.isSJZTVParam(tvname);
		boolean hntv = SysParamUtil.isHNTVParam(tvname);		


		Org org = SysParamUtil.getOrgFromMap(orgId);	
		
		boolean isDynamicTemple =reportFileName.equals("")?true:false;
		String reportsTempleRealPath = (String)Constants.APPLACTION_MAP.get(Constants.REPORTS_TEMPLE_PATH);
		
		
		String logoFileRealPath = org.getLogFileRel();


	
		 System.out.println("************************************");
//		 System.out.println("queryString>>>>>>>>"+request.getQueryString());
		 System.out.println("model>>>>>>>>"+model);
		 System.out.println("title>>>>>>>>"+ title);
		 System.out.println("reportType>>>>>>>>"+reportType);
		 System.out.println("baseDir>>>>>>>>"+logoFileRealPath);
		 System.out.println("reportFileName>>>>>>>>"+reportFileName);
		 System.out.println("header>>>>>>>>"+ header);
		 System.out.println("displaySumColum>>>>>>>>"+displaySumColum);
		 System.out.println("isSum>>>>>>>>"+isSum);
		 System.out.println("isVertical>>>>>>>>"+isVertical);
		 System.out.println("orgId>>>>>>>>"+orgId);
		 
		 
		 String storeData =  StringUtil.getURLDecoderStr((String)searchMap.get("storeData"));
		 System.out.println("storeData>>>>>>>>"+storeData);

		 System.out.println("************************************");
		 

		Map parameters = new HashMap();	
		
//		//不起作用
//		if(EXCEL_TYPE.equals(model)) parameters.put("IS_IGNORE_PAGINATION", Boolean.valueOf(true)); 

		ReportManager mgr = (ReportManager) getBean("reportManager");
		
//		 System.out.println("mgr************************************"+mgr);
		 


		JasperPrint jasperPrint = null;
		Collection coll = null;
		
		try
		{
			JasperReport jasperReport = null;
			if(isDynamicTemple){
//				String[] headers = header.split(",");
//				String[] alias = JasperReportUtil.preaseAliasColumnHeaders(headers); 
//				String[] displaySumColums = displaySumColum.split(","); 
				

				try {
					coll = mgr.getCollectionByType(queryString,searchMap,parameters);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				jasperReport = JasperReportUtil.getJasperReport(searchMap,parameters);
				
				jasperPrint =JasperFillManager.fillReport(
						jasperReport,
						parameters, 
						new JRBeanCollectionDataSource(coll));

				
				starSiglejasperPrint(request,response,jasperPrint,model);	
//				jasperReport = JasperReportUtil.getJasperReport(title,headers,alias,displaySumColums,isSum,isVertical,orgId);
			}else{
				
				ServletContext context = this.getServletConfig().getServletContext();
				String fileSep = Constants.FILE_SEP;
				String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;

				if(reportType.equals("orderDetail_report")) {

						parameters.put("ReportTitle", org.getReportTitle()+"广告发布合同");
						
						try {
							coll = mgr.getCollectionByType(queryString,searchMap,parameters);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
						coll = getNullSpace(coll);
				
						Order order = getOrderInfo(parameters,(String)searchMap.get("orderId"));
						
						setCustomerInfo(parameters,order);
						
						setOrgInfo(parameters,org,(String)searchMap.get("orderId"));	
						
						jasperPrint = JasperFillManager.fillReport(
								jasperReport,
								parameters, 
								new JRBeanCollectionDataSource(coll));

						
						starSiglejasperPrint(request,response,jasperPrint,model);						
						
				}
				
				
				if(reportType.equals("bro_report_hbtv")) {
					File reportFile = new File(context.getRealPath(reportsTemplePath +reportFileName));
					if (reportFile.exists()){
						jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
					}else{
						throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
					}
					parameters.put("BaseDir", reportFile.getParentFile());
					parameters.put("ReportTitle", org.getReportTitle()+"广告播出证明");
					parameters.put("orgId", orgId);
					
					 System.out.println("BaseDir************************************"+reportFile.getParentFile());
					 System.out.println("ReportTitle************************************"+title);
					 System.out.println("orgId************************************"+orgId);
					
					

//					parameters.put("ReportTitle", org.getReportTitle());
					
					try {
						coll = mgr.getCollectionByType(queryString,searchMap,parameters);
						System.out.println("coll size************************************"+coll.size());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				
			
					
					jasperPrint =JasperFillManager.fillReport(
							jasperReport,
							parameters, 
							new JRBeanCollectionDataSource(coll));

					
					starSiglejasperPrint(request,response,jasperPrint,model);						
					
			}			
				
				

				if(reportType.equals("adIncomeRelpayQiank_report")) {
					File reportFile = new File(context.getRealPath(reportsTemplePath +reportFileName));
					if (reportFile.exists()){
						jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
					}else{
						throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
					}
					parameters.put("BaseDir", reportFile.getParentFile());
					parameters.put("ReportTitle", title);
					parameters.put("orgId", orgId);
					
			
					 System.out.println("BaseDir************************************"+reportFile.getParentFile());
						
						try {
							coll = mgr.getCollectionByType(queryString,searchMap,parameters);
							System.out.println("coll size************************************"+coll.size());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
//						coll = getNullSpace(coll);
			
						jasperPrint =JasperFillManager.fillReport(
								jasperReport,
								parameters, 
								new JRBeanCollectionDataSource(coll));

						
						starSiglejasperPrint(request,response,jasperPrint,model);						
						
				}
				
				
				if(reportType.equals("bro_report")) {
					boolean isRelPrice = Boolean.valueOf((String)searchMap.get("isRelPrice")).booleanValue();
					boolean isCustomer = Boolean.valueOf((String)searchMap.get("isCustomer")).booleanValue();
					boolean isMatter = Boolean.valueOf((String)searchMap.get("isMatter")).booleanValue();
					String beginDate = (String)searchMap.get("beginDate");
					String endDate = (String)searchMap.get("endDate");
					String order_ids = (String)searchMap.get("orderIds");
					String[] orderIds = order_ids.split(",");
					
					String LogImgPath = "../../images/"+ orgId +"/logo.jpg";
					parameters.put("ParameterLogImgPath", LogImgPath);
					parameters.put("OrgName", org.getReportTitle());
					parameters.put("ReportTitle", org.getReportTitle()+"广告播出证明");

					if(qztv){
						reportFileName = isRelPrice?"bro_report_qztv.jasper":"bro_report2_qztv.jasper";
					}else if(xmtv){
						reportFileName = isRelPrice?"bro_report_xmtv.jasper":"bro_report2_xmtv.jasper";
					}else{
						reportFileName = isRelPrice?"bro_report.jasper":"bro_report2.jasper";   
					}
					
					
					File reportFile = new File(reportsTempleRealPath+Constants.FILE_SEP +reportFileName) ;	
					if (reportFile.exists()){
						parameters.put("BaseDir", reportFile.getParentFile());		
						jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
				    }else{
						throw new JRRuntimeException("File report.jasper not found. The report design must be compiled first.");
					}	

					
					for(int i = 0;i<orderIds.length;i++){
						
						try {
							coll = mgr.getCollectionByType(queryString,searchMap,parameters);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						

						List  ls = new ArrayList();
						if(isMatter){
							
						}else{
							
						}
						
						
						//设置合同甲方信息
						setOrgInfo(parameters,org);

						for(int j = 0;j<ls.size()-1;j++){
							//设置订单信息
							Order order = getOrderInfo(parameters,orderIds[i]);
							//设置合同乙方信息
							setCustomerInfo(parameters,order);

							if(!isCustomer) parameters.put("CustomerName","");   
							
//							if("0".equals(beginDate)) beginDate = getStartDateByColl();
//							if("0".equals(endDate))endDate = getEndDateByColl();
							
							parameters.put("OrderStartDate",  StringUtil.null2String(beginDate)); 
							parameters.put("OrderEndDate",  StringUtil.null2String(endDate)); 

							//设置订单明细
		
							
	//					    coll = getOrderDetails(orderIds[i],beginDate,endDate,carrierId,matterName,isRelPrice);		
		
						    
							if(qztv){
							    boolean isDisplaySumBand = getDisplaySumBand(coll);
							    parameters.put("ParameterDisplaySumBand",  Boolean.valueOf(isDisplaySumBand));
		//					    System.out.println(">>>>999999999999999999999999999999999999999999999999999999999>>>>>"+isDisplaySumBand);
							}else if(xmtv){
							    boolean isDisplaySumBand = getDisplaySumBand(coll);
							    parameters.put("ParameterDisplaySumBand",  Boolean.valueOf(isDisplaySumBand));
							}else{
							    boolean isDisplaySumBand = getDisplaySumBand(coll);
							    parameters.put("ParameterDisplaySumBand",  Boolean.valueOf(isDisplaySumBand));
							}
							
							
							jasperPrint =JasperFillManager.fillReport(
									jasperReport,
									parameters, 
									new JRBeanCollectionDataSource(coll));
	
							
							starSiglejasperPrint(request,response,jasperPrint,model);
						
						}
					
					}

				}			
				
		
	
			
			}


			
			
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

				
		
	}
	
	
    private void starSiglejasperPrint(HttpServletRequest request,	HttpServletResponse response,JasperPrint jasperPrint,String model) throws ServletException,IOException{
    	
    	if (jasperPrint != null)
		{
			   if (EXCEL_TYPE.equals(model)) {
				   exportExcel(jasperPrint, request, response);
			   }else if (PDF_TYPE.equals(model)) {
				   exportPdf(jasperPrint, request, response);
			   }else if (HTML_TYPE.equals(model)) {
				   exportHtml(jasperPrint, request, response);
			   }else if (WORD_TYPE.equals(model)) {
				   exportWord(jasperPrint, request, response);
			   }else if (PRINT_TYPE.equals(model)) {
				   print(jasperPrint, request, response);
			   }else if (VIEW_TYPE.equals(model)) {
				   view(jasperPrint, request, response);
			   }else{
				   exportExcel(jasperPrint, request, response);
			   }

		}else{
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
	
	private static void view( JasperPrint jasperPrint, HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("application/octet-stream");
		ServletOutputStream ouputStream = response.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
		oos.writeObject(jasperPrint);
		oos.flush();
		oos.close();
		ouputStream.flush();
		ouputStream.close();
	}
	private static void print(final JasperPrint jasperPrint,HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{

		if (jasperPrint != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                    	System.out.println("print start>>>>>>>>>>>");
                        JasperPrintManager.printReport(jasperPrint, false);
                        System.out.println("print end>>>>>>>>>>>");
                    } catch (Exception e) {
                        StringWriter swriter = new StringWriter();
                        PrintWriter pwriter = new PrintWriter(swriter);
                        e.printStackTrace(pwriter);
                        JOptionPane.showMessageDialog(null, swriter.toString());
                    }
                }
            });

            thread.start();
        } else {
            JOptionPane.showMessageDialog(null, "Empty report.");
        }
		
	}
	private static void exportExcel(JasperPrint jasperPrint, HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
         ByteArrayOutputStream oStream = new ByteArrayOutputStream();
         JRXlsExporter exporter = new JRXlsExporter();
  
         exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
         exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,oStream);
         exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE); 
//         exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_PAGINATION,Boolean.TRUE); 
         exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
         exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
//         exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,Boolean.TRUE); 
   
 		//不起作用
// 		if(EXCEL_TYPE.equals(model)) parameters.put("IS_IGNORE_PAGINATION", Boolean.valueOf(true)); 
         
//     	System.out.println("print start>>> JASPER_PRINT>>>>>>>>" + JRExporterParameter.JASPER_PRINT);

         
         try {
        	 exporter.exportReport();
         }catch (JRException ex) {
//        	 out.println("Jasper Output Error:" + ex.getMessage());
         }
         
         byte[] bytes = oStream.toByteArray();
         
         if (bytes != null && bytes.length > 0) {
                 response.reset();
                 response.setHeader("Content-Disposition","attachment;filename=export.xls");   
                 response.setContentType("application/vnd.ms-excel");
                 response.setContentLength(bytes.length);
                 ServletOutputStream ouputStream = response.getOutputStream();
                 ouputStream.write(bytes, 0, bytes.length);
                 ouputStream.flush();
                 ouputStream.close();

         } else {
//                 out.println("bytes were null!");  
         }		
         
        
	}
	
	
	private static void exportPdf( JasperPrint jasperPrint, HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, oStream);
       	try {
			exporter.exportReport();
		} catch (JRException e) {
			e.printStackTrace();
		}
 
        
        byte[] bytes = oStream.toByteArray();

        if (bytes != null && bytes.length > 0) {
                response.reset();
                response.setHeader("Content-Disposition","attachment;filename=export.pdf");   
                response.setContentType("application/pdf"); 
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();
        } else {
//                out.println("bytes were null!");  
        }		
	}
	
	
	private static void exportHtml(JasperPrint jasperPrint, HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		       response.setHeader("Content-disposition", "attachment; filename=export.html");
		       response.setContentType("text/html;charset=UTF-8");
			   ServletOutputStream ouputStream = response.getOutputStream();
			   JRHtmlExporter exporter = new JRHtmlExporter();
			   exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);
			   exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
			   exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,"UTF-8");
			   exporter.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM,ouputStream);
			   
//			   Map imagesMap = new HashMap();
//			   request.getSession().setAttribute("IMAGES_MAP", imagesMap);
//			   exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
			   
//	         exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath()+"/ctx/auth/dashboardimage?image=");
//	         exporter.setParameter(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
//			   exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath()+"/resources/images/default/logo.jpg");
//			   String logoFileRealPath = (String)Constants.APPLACTION_MAP.get(Constants.APP_SYS_LOGO_FILE);

//			   exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, logoFileRealPath);

			   	try {
					exporter.exportReport();
				} catch (JRException e) {
					e.printStackTrace();
				}
			   ouputStream.flush();
			   ouputStream.close();
			 }
	
	private static void exportWord(JasperPrint jasperPrint,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			  response.setHeader("Content-disposition", "attachment; filename=export.doc");
			  response.setContentType("application/msword;charset=utf-8");
			  JRExporter exporter = new JRRtfExporter();
			  exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			  exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
			  try {
				exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
	
    public Collection getNullSpace(Collection coll){
    	int collSize = coll.size();
    	int lastPage = 0;
    	   if(collSize<19){
    		   while(collSize<19){
//    			   System.out.println(">>>>>collnull>>>>>>" +collSize);
    			   coll.add(new OrderDetailColl());
//    			   System.out.println(">>>>>colladd>>>>>>" +coll.size());
    			   collSize++;
    		   }
		    }else{
		    	lastPage = (collSize-19)%31;
		    	if(lastPage==0)
		    		return coll;
		    	if(lastPage<=30){
		    		 while(lastPage<=30){
		    			   coll.add(new OrderDetailColl());
		    			   lastPage++;
		    		   }
		    	}
		    }
    	return coll;
    }
    //璁剧疆鍚堝悓淇℃伅
    public Order getOrderInfo(Map parameters,String orderId){
    	OrderManager mgr = (OrderManager) getBean("orderManager");
    	OrderCategoryManager categoryMgr = (OrderCategoryManager) getBean("orderCategoryManager");
    	Order order = mgr.getOrder(orderId);
//		瀹㈡埛鍚嶇О
//		parameters.put("CustomerName", order.getCustomer().getCustomerName());    	
//		鎬绘挱鍑烘鏁?
//		parameters.put("OrderSumTimes", order.getOrderPublic().getTimes().toString()); 
		parameters.put("OrderSumTimes",  order.getOrderPublic().getTimes().toString()); 
//		鍚堝悓绫诲埆
		parameters.put("OrderType",  categoryMgr.getOrderCategory(order.getCategoryId().toString()).getName()); 
//		鐢佃瘽
		parameters.put("OrderCode",  StringUtil.null2String(order.getOrderCode())); 
//		鍏宠仈缂栧彿
		parameters.put("RelationCode",  StringUtil.null2String(order.getRelationCode())); 
		
//		鐢佃瘽
		parameters.put("OrderSumBase",  order.getOrderPublic().getMoneyBase().toString()); 		
//		鐢佃瘽
		parameters.put("OrderSumSpeci", ""); 	
//		鐢佃瘽
		parameters.put("OrderSumFavour", StringUtil.null2String("")); 	
//		鐢佃瘽
		parameters.put("OrderOtherFavour", StringUtil.null2String("")); 	
//		鐢佃瘽
		parameters.put("OrderFavourRate",  StringUtil.null2String("")); 	
//		鐢佃瘽
		parameters.put("OrderSumRealpay",  order.getOrderPublic().getMoneyRealpay().toString()); 	
//      璁㈠崟澶囨敞
		parameters.put("OrderMeno",  StringUtil.null2String(order.getOrderMeno())); 
//		鑱旂郴浜?
		parameters.put("OrderUserName",  StringUtil.null2String(order.getUser().getFullName()));
//		鍒涘缓鏃ユ湡
//		System.out.println("VVVVV   "+order.getUser().getFullName());
//		System.out.println(">>>>>   "+order.getCreateDate());
		parameters.put("OrderCreateDate", DateUtil.getDate(order.getCreateDate()) ); 
		
//		System.out.println(DateUtil.getDate(order.getCreateDate()));
		
		//鑾峰緱璁㈠崟鐨勪粯娆句俊鎭? 
		String payments = getOrderPayment(order);
		parameters.put("OrderPayments",  payments);
		
		

		
//		parameters.put("OrderPayments",  ""); 
	
		
		return order;
    }   
    
    //鑾峰緱浠樻鏂瑰紡
    public String getOrderPayment(Order order){
    	
    	ContractPaymentManager mgr = (ContractPaymentManager) getBean("contractPaymentManager");
    	ContractPayment contractPayment = new ContractPayment();

    	Long contractId = order.getContractId();
    	Long orderId = order.getId();

		//濡傛灉鍚堝悓缂栧彿涓?0锛屾璁㈠崟灞炰簬姝ｅ父绫诲瀷鐨勮鍗曪紝鍙互鏍规嵁璁㈠崟鍙?
    	//鍦ㄤ粯娆句俊鎭〃涓壘鍒扮浉鍏崇殑淇℃伅锛屽惁鍒欏彧鑳介?氳繃鍚堝悓鍙峰幓鏌ユ壘浠樻
    	if(contractId.longValue() == 0){
    		contractPayment.setOrderId(orderId);
    	}else{
    		contractPayment.setContractId(contractId);
    	}
    	List payList = mgr.getContractPayments(contractPayment);
    	return mgr.getPaymentsStringList(payList);
    }
    
    
    //设置合同甲方信息
    public void setOrgInfo(Map parameters,Org org){
    	Address address = org.getAddress();
//    	DecimalFormat df = new DecimalFormat("#.00");
		//电话
//		parameters.put("OrgTel",  org.getTel()); 
		parameters.put("OrgTel",  StringUtil.null2String(org.getTel())); 
		//传真
//		parameters.put("OrgFax", org.getFax());
		parameters.put("OrgFax", StringUtil.null2String(org.getFax()));
		//法人			
//		parameters.put("OrgLinkMan", org.getLinkMan());
		parameters.put("OrgLinkMan", StringUtil.null2String(org.getLinkMan()));
		//地址			
//		parameters.put("OrgAddress",  address.getAddress());
		parameters.put("OrgAddress",  StringUtil.null2String(address.getAddress()));
		//开户银行			
//		parameters.put("OrgBankName",  org.getBankName());
		parameters.put("OrgBankName",  StringUtil.null2String(org.getBankName()));
		//开户帐号			
//		parameters.put("OrgBankCode",  org.getBankCode());

		parameters.put("OrgBankCode",  StringUtil.null2String( org.getBankCode()));

		//邮编			
//		parameters.put("OrgPostCode",  address.getPostalCode());    
		parameters.put("OrgPostCode",  StringUtil.null2String(address.getPostalCode()));   
		
		parameters.put("ReportSignature", StringUtil.null2String(org.getReportSignature()));
    }   
    
    
    
    //璁剧疆鍚堝悓涔欐柟淇℃伅
    public void setOrgInfo(Map parameters,Org org,String orderId){
    	Address address = org.getAddress();
    	OrderManager mgr = (OrderManager) getBean("orderManager");
    	Order order = mgr.getOrder(orderId);
		//鐢佃瘽
//		parameters.put("OrgTel",  org.getTel()); 
		parameters.put("OrgTel",  StringUtil.null2String(org.getTel())); 
		//浼犵湡
//		parameters.put("OrgFax", org.getFax());
		parameters.put("OrgFax", StringUtil.null2String(org.getFax()));
		//娉曚汉			
//		parameters.put("OrgLinkMan", org.getLinkMan());
		parameters.put("OrgLinkMan", StringUtil.null2String(org.getLinkMan()));
		//鍦板潃			
//		parameters.put("OrgAddress",  address.getAddress());
		parameters.put("OrgAddress",  StringUtil.null2String(address.getAddress()));
		//寮?鎴烽摱琛?			
//		parameters.put("OrgBankName",  org.getBankName());
		parameters.put("OrgBankName",  StringUtil.null2String(org.getBankName()));
		//寮?鎴峰笎鍙?			
//		parameters.put("OrgBankCode",  org.getBankCode());
		parameters.put("OrgBankCode",  StringUtil.null2String(org.getBankCode()));
		//閭紪			
//		parameters.put("OrgPostCode",  address.getPostalCode());    
		parameters.put("OrgPostCode",  StringUtil.null2String(address.getPostalCode()));  
		//娉曚汉	
		parameters.put("OrgOwnerAgent",   StringUtil.null2String(order.getUser().getFullName())); 
	
    }
    
    
	   private boolean getDisplaySumBand(Collection coll){
	    	int collSize = coll.size();
	    	boolean rs = false;

	    	   if(collSize<24){
	    		   rs =  true;
			    }else{	    	
			    	int lastPage = (collSize-24)%31;
	                if(lastPage > 0)  rs =  true;
			    }
	       return rs;
	    } 
    
    //璁剧疆鍚堝悓鐢叉柟淇℃伅
    public void setCustomerInfo(Map parameters,Order order){
  
//    	 System.out.println(">>>>>customerId>>>>>>" + customerId.toString());
    	
    	CustomerManager mgr = (CustomerManager) getBean("customerManager");
    	Customer customer = mgr.getCustomerForOrderPrint(order.getCustomerId().toString());
    	
    	parameters.put("CustomerName",   StringUtil.null2String(customer.getCustomerName()));   
		//鐢佃瘽			
		parameters.put("CustomerTel",   StringUtil.null2String(customer.getTelephone()));   
		//浼犵湡			
		parameters.put("CustomerFax",   StringUtil.null2String(customer.getFax()));   
		//娉曚汉			
		parameters.put("CustomerLinkMan",   StringUtil.null2String(customer.getOwnerAgent()));  
		//鍦板潃		
		parameters.put("CustomerAddress",   StringUtil.null2String(customer.getAccountAddress()));   
		//寮?鎴峰笎鍙?		
		parameters.put("CustomerBankCode",   StringUtil.null2String(customer.getAccountNumber()));   
		//鎴峰悕			
		parameters.put("CustomerBankName",   StringUtil.null2String(customer.getAccountName())); 
		//娉曚汉			
		parameters.put("CustomerOwnerAgent",   StringUtil.null2String(customer.getOwnerAgent())); 
//		閭紪
//		System.out.println(customer.getPostCode());
		parameters.put("CustomerPostCode",   StringUtil.null2String(customer.getPostCode())); 
    }
	public Collection getPrintInfo(List ls){
		Collection coll = new ArrayList();
		
		for(Iterator it=ls.iterator();it.hasNext();){
			PublishArrange  publish = (PublishArrange)it.next();
			PublishArrange  pub = new PublishArrange();
			String num="0";
		   
		    List publishArrangeDetails = publish.getPublishArrangeDetails();
		    for(Iterator iter = publishArrangeDetails.iterator();iter.hasNext();){
				  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)iter.next();
				  Integer x = publishArrangeDetail.getPublishSort();
				  num = StringUtil.null2String(x);
		    }
		
			String p = StringUtil.null2String(publish.getResourceName());
			Integer t = (publish.getResourceUsedTimes()==null)?(new Integer(0)):(publish.getResourceUsedTimes());
			
			pub.setResourceName(p);
		    pub.setResourceUsedTimes(t);
		    pub.setResourceMeno(num);
		    coll.add(pub);
		}
		
		return coll;
	}
	
	
	public Object getBean(String name) {
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
	
}
