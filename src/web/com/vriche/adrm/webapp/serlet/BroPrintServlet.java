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
import java.util.Collection;
import java.util.HashMap;
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

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Address;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class BroPrintServlet extends HttpServlet
{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -5635477054559783925L;
	private String execl = "" ;
	/**
	 *
	 */
	
	public  boolean getQztvSpecificParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getQztvSpecialParam())) sysParam.setQztvSpecialParam("0");
	    return (sysParam.getQztvSpecialParam().equals("0"))?false:true;
	} 
	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		  
//			String model =  (String)request.getParameter("model");
//			String orderId =  (String)request.getParameter("orderId");
//			String copys =  (String)request.getParameter("copys");
		   String tvname = SysParamUtil.getTvNameParam();
		   boolean qztv= SysParamUtil.isQZTVParam(tvname);
		   boolean xmtv= SysParamUtil.isXMTVParam(tvname);
		   boolean sjz= SysParamUtil.isSJZTVParam(tvname);
		   boolean hntv= SysParamUtil.isHNTVParam(tvname);
		   boolean catv= SysParamUtil.isCATVParam(tvname);
		   boolean fztv= SysParamUtil.isFZTVParam(tvname);

		
		   HttpSession session = request.getSession();
		   String        model=  (String)session.getAttribute("model");
		   String        orderId=  (String)session.getAttribute("orderId");
		   String        beginDate=  (String)session.getAttribute("beginDate");
		   String        endDate=  (String)session.getAttribute("endDate");
		   String        matterName =  (String)session.getAttribute("matterNameForm");
		   String        carrierId=  (String)session.getAttribute("carrierId");
		   String        orgId=  (String)session.getAttribute("orgId");
		   boolean        isCustomer=  "true".equals((String)session.getAttribute("isCustomer"));
		   
		   System.out.println(">>>>hhhhhhhhv  endDate>>>>>                    "+ endDate);
		  
		   
		   boolean        isRelPrice=  "true".equals((String)session.getAttribute("isRelPrice"));
//		   System.out.println(">>>>hhhhhhhhv>>>>>                    "+  (String)session.getAttribute("isRelPrice"));
//		   System.out.println(">>>>999999999>>>>>                    "+  isRelPrice);
//			 System.out.println(">>>>>model>>>>>>" +model);
//			 System.out.println(">>>>>orderId>>>>>>" +orderId);
			

			ServletContext context = this.getServletConfig().getServletContext();
			
			if("".equals(orgId) || orgId == null) orgId ="1";

			Org org = SysParamUtil.getOrgFromMap(orgId);	
			
//			 System.out.println(">>>>hhhhhhhhv>>>>>                    "+ orgId);
			
			String fileSep = Constants.FILE_SEP;
			String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;

		    String fileName = "";
			if(qztv){
//				fileName = isRelPrice?"bro_report_qztv.jasper":"bro_report2_qztv.jasper";
				fileName = "bro_report2_qztv.jasper";
			}else if(xmtv){
				fileName = "bro_report2_xmtv.jasper";
			}else if(catv||sjz){
				fileName = isRelPrice?"bro_report_catv.jasper":"bro_report2_catv.jasper";
			}else if(fztv){
				fileName = "bro_report2.jasper";
			}else{
				fileName = "bro_report2_xmtv.jasper";   
			}
			
//			fileName = "bro_report2_xmtv.jasper";
//			fileName = isRelPrice?"bro_report_qztv.jasper":"bro_report2_qztv.jasper";
//			fileName = "bro_report2_qztv.jasper";

			
			
//			String fileName = isRelPrice?"bro_report.jasper":"bro_report2.jasper";    
//			 System.out.println(">>>>>isRelPrice>>>>>>" +session.getAttribuvte("isRelPrice"));
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>fileName>>>>>>" +fileName);
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>orgId>>>>>>" +orgId);
			 
			File reportFile = new File(context.getRealPath(reportsTemplePath + fileName)) ;
						
			
			if (!reportFile.exists())
				throw new JRRuntimeException("File order_report.jasper not found. The report design must be compiled first.");
			
			
			Map parameters = new HashMap();
			
			String LogImgPath = "../../images/"+ orgId +"/logo.jpg";
			parameters.put("ParameterLogImgPath", LogImgPath);
			parameters.put("OrgName", org.getReportTitle());
			parameters.put("ReportTitle", org.getReportTitle()+"广告播出证明");
			parameters.put("ReportSignature", StringUtil.null2String(org.getReportSignature()));
			parameters.put("BaseDir", reportFile.getParentFile());
			parameters.put("OrderStartDate",  StringUtil.null2String(beginDate)); 
			parameters.put("OrderEndDate",  StringUtil.null2String(endDate)); 
			parameters.put("isRelPrice",  Boolean.valueOf(isRelPrice)); 
//			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>eeeeeeeeee>>>>>>>>>>>>>>>>>>>>>vvvvvvvvvvvvvvvvvvvvvv>>>>>>>>>>>>>>>isRelPrice>>>>>>" +isRelPrice);

			if(model.equals("print") || model.equals( "view")){
				execl = "";
//				System.out.println("execl  2  "+execl);
				
			}
			if(model.equals("export")){
	             execl = "'";
//		     	 System.out.println("execl  1  "+execl);
			}

			//设置订单信息
			Order order = getOrderInfo(parameters,orderId);
			//设置合同乙方信息
			setCustomerInfo(parameters,order,isCustomer);
			//设置合同甲方信息
			setOrgInfo(parameters,org);
			//设置订单明细
			

		    Collection coll = getOrderDetails(orderId,beginDate,endDate,carrierId,matterName,true);		

		    
		    
			if(qztv){
			    boolean isDisplaySumBand = getDisplaySumBand(coll);
			    parameters.put("ParameterDisplaySumBand",  Boolean.valueOf(isDisplaySumBand));
//			    System.out.println(">>>>999999999999999999999999999999999999999999999999999999999>>>>>"+isDisplaySumBand);
			}else if(xmtv){
			    boolean isDisplaySumBand = getDisplaySumBand(coll);
			    parameters.put("ParameterDisplaySumBand",  Boolean.valueOf(isDisplaySumBand));
			}else{
			    boolean isDisplaySumBand = getDisplaySumBand(coll);
			    parameters.put("ParameterDisplaySumBand",  Boolean.valueOf(isDisplaySumBand));
			}	    
		    

		    
		  
		 
		   
			
			JasperPrint jasperPrint = null;
	
			try
			{				
				  JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
//				  System.out.println(">>>>1010101010>>>>>");
				jasperPrint = 
					JasperFillManager.fillReport(
						jasperReport,
						parameters, 
						new JRBeanCollectionDataSource(coll)
						);
				
//				System.out.println(">>>>11 11  11  11>>>>>");
				
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
	             // 是否移除行与行之间的空行
	             exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE); 
//	             每一页是否用一个Sheet
	             exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE); 
	             exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
//	           自动修正Excel每个栏位的大小
	             exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED,Boolean.TRUE);
	             
//	             exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
	             /*//忽略边框
	             exporter.setParameter(
	             JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER,
	             Boolean.TRUE);*/

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
    
    
    
    
    //设置合同信息
    public Order getOrderInfo(Map parameters,String orderId){
    	OrderManager mgr = (OrderManager) getBean("orderManager");
    	Order order = mgr.getOrder(orderId);
//		//客户名称
//		parameters.put("CustomerName", order.getCustomer().getCustomerName());    	
//		//总播出次数
//		parameters.put("OrderSumTimes", order.getOrderPublic().getTimes().toString()); 
		parameters.put("OrderSumTimes",  order.getOrderPublic().getTimes().toString()); 
//		//合同类别
		parameters.put("OrderType",  StringUtil.null2String(order.getCategoryId())); 
//		//电话
		parameters.put("OrderCode",  StringUtil.null2String(order.getOrderCode())); 

//		//电话
//		parameters.put("OrderSumBase",  order.getOrderPublic().getMoneyBase().toString()); 		
////		//电话
//		parameters.put("OrderSumSpeci", ""); 	
////		//电话
//		parameters.put("OrderSumFavour", StringUtil.null2String("")); 	
////		//电话
//		parameters.put("OrderOtherFavour", StringUtil.null2String("")); 	
////		//电话
//		parameters.put("OrderFavourRate",  StringUtil.null2String("")); 	
////		//电话
		parameters.put("OrderSumRealpay",  order.getOrderPublic().getMoneyRealpay().toString()); 	
//		
//		parameters.put("OrderPayments",  ""); 	
		parameters.put("OrderMeno",  StringUtil.null2String(order.getPublishMemo())); 
		
		return order;
    }   
    
    
    
    public Collection  getOrderDetails(String orderId,String beginDate,String endDate,String carrierId,String matterName,boolean isRelPrice){
    	OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
//    	 System.out.println(">>>>>matterName>>>>>>" +matterName);
//    	 System.out.println(matterName==null);
    	return  mgr.getOrderDetailss(orderId,beginDate,endDate,carrierId,matterName,isRelPrice,4);
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
		
//		System.out.println("sss    "+org.getBankCode());
//		String bankcode = df.format(new Double(org.getBankCode()));
//		System.out.println("execl    "+execl);
		parameters.put("OrgBankCode",  execl+StringUtil.null2String( org.getBankCode()  ));
		execl = "";
		//邮编			
//		parameters.put("OrgPostCode",  address.getPostalCode());    
		parameters.put("OrgPostCode",  StringUtil.null2String(address.getPostalCode()));   
    }
    
    //设置合同乙方信息
    public void setCustomerInfo(Map parameters,Order order,boolean isCustomer){
  
//    	 System.out.println(">>>>>customerId>>>>>>" + customerId.toString());
    	
    	CustomerManager mgr = (CustomerManager) getBean("customerManager");
    	Customer customer = mgr.getCustomer(order.getCustomerId().toString());
//    	System.out.println("isCustomer   >>>  "+isCustomer);
		//名称			
    	if(isCustomer){
    		parameters.put("CustomerName",   StringUtil.null2String(customer.getCustomerName()));   
    	}else{
    		parameters.put("CustomerName",   "");   
    	}
		//电话			
		parameters.put("CustomerTel",   StringUtil.null2String(customer.getTelephone()));   
		//传真			
		parameters.put("CustomerFax",   StringUtil.null2String(customer.getFax()));   
		//法人			
		parameters.put("CustomerLinkMan",   StringUtil.null2String(customer.getOwnerAgent()));  
		//地址		
		parameters.put("CustomerAddress",   StringUtil.null2String(customer.getAccountAddress()));   
		//开户帐号		
		parameters.put("CustomerBankCode",   StringUtil.null2String(customer.getAccountNumber()));   
		//户名			
		parameters.put("CustomerBankName",   StringUtil.null2String(customer.getAccountName()));   
		//法人			
//		parameters.put("CustomerPostCode",   StringUtil.null2String(customer.get));    
    }
	
    public Object getBean(String name) {
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }	

}
