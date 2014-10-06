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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Address;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.DateUtil2;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class OrderPrintServlet extends HttpServlet
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
		  
//			String model =  (String)request.getParameter("model");
//			String orderId =  (String)request.getParameter("orderId");
//			String copys =  (String)request.getParameter("copys");
			
		   String tvName = SysParamUtil.getTvNameParam();
		   
		   int orderPublishTempleParam = SysParamUtil.getOrderPublishTempleParam();
		
		   HttpSession session = request.getSession();
		   String        model=  (String)session.getAttribute("model");
		   String        orderId=  (String)session.getAttribute("orderId");
		   String orgId =  (String)session.getAttribute("orgId");
		   
//		   System.out.println(">>>>>org>>>>8888888888888888888888888888888888>>" +orgId);
		   
			ServletContext context = this.getServletConfig().getServletContext();
//			Org org = (Org) context.getAttribute(Constants.AVAILABLE_ORG);
			
            Map  orgMap = (Map) Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
            Org org = (Org)  orgMap.get(orgId);
            
			String fileSep = Constants.FILE_SEP;
			String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;
			
			System.out.println(">>>>>orderPublishTempleParam>>>>8888888888888888888888888888888888>>" +orderPublishTempleParam);
			
			if(orderPublishTempleParam == 1){
				reportsTemplePath = reportsTemplePath+"order_report1.jasper";
			}else if(orderPublishTempleParam == 2){
				reportsTemplePath = reportsTemplePath+"order_report2.jasper";
			}else if(orderPublishTempleParam == 3){
				reportsTemplePath = reportsTemplePath+"order_report3.jasper";
			}else{
				reportsTemplePath = reportsTemplePath+"order_report.jasper";
			}
			
			
			File reportFile = new File(context.getRealPath(reportsTemplePath)) ;
						
			
			if (!reportFile.exists())
				throw new JRRuntimeException("File order_report.jasper not found. The report design must be compiled first.");
			
			
			Map parameters = new HashMap();
			//设置标题
			parameters.put("ReportTitle",  org.getReportTitle()+"广告发布合同");
			
			
			parameters.put("ReportSignature", StringUtil.null2String(org.getReportSignature()));
			
			//设置路径
			parameters.put("BaseDir", reportFile.getParentFile());
			
			
			parameters.put("orgId",orgId);
			
			String LogImgPath = "../../images/"+ orgId +"/logo.jpg";
			parameters.put("ParameterLogImgPath", LogImgPath);
			parameters.put("ParameterPrintTime", DateUtil2.GetTimeFormat("yyyy-MM-dd HH:mm"));
			
			

			//设置订单信息
			Order order = getOrderInfo(parameters,orderId);
			//设置合同乙方信息
			setCustomerInfo(parameters,order);
			//设置合同甲方信息
			setOrgInfo(parameters,org,orderId);
			//设置订单明细
		    Collection coll = getOrderDetails(orderId);		
//		    System.out.println(">>>>>coll>>>>>>" +coll.size());
		    
		    if(orderPublishTempleParam == 0||orderPublishTempleParam == 1){
		    	getNullSpaceFor3(coll);
			}
		    if(orderPublishTempleParam == 2||orderPublishTempleParam == 3){
		    	
		    	getNullSpace(coll);
			}	    
		    


//		    System.out.println(">>>>>coll>>>>>>" +collNull.size());
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



    
 // 22 33 
    private void getNullSpace(Collection coll){
    	int collSize = coll.size();
    	int lastPage = 0;
    	   if(collSize<22){
    		   while(collSize<22){
//    			   System.out.println(">>>>>collnull>>>>>>" +collSize);
    			   coll.add(new OrderDetailColl());
//    			   System.out.println(">>>>>colladd>>>>>>" +coll.size());
    			   collSize++;
    		   }
		    }else{	    	
		    	
		    	lastPage = (collSize-22)%33;
		    	 System.out.println(">>>>>lastPage>>>>>>" +lastPage);
		    	if(lastPage<29 ){
		    		 while(lastPage<29){
		    			   coll.add(new OrderDetailColl());
		    			   lastPage++;
		    		   }
		    	}
		    	
//		    	if(lastPage == 1){
//		    		 while(lastPage<33){
//		    			   coll.add(new OrderDetailColl());
//		    			   lastPage++;
//		    		   }
//		    	}
		    }
  
    }
    
    private void getNullSpaceFor3(Collection coll){
    	int collSize = coll.size();
    	int lastPage = 0;
    	int firstLeave  = 0;
    	int i = 0;
    	
    	   if(collSize<18){
    		   while(collSize<18){
//    			   System.out.println(">>>>>collnull>>>>>>" +collSize);
    			   coll.add(new OrderDetailColl());
//    			   System.out.println(">>>>>colladd>>>>>>" +coll.size());
    			   collSize++;
    		   }
		    }else if(collSize>18 && collSize<22){	    	
		    	lastPage = (collSize-18)%29;
		    	firstLeave =lastPage;
//		    	System.out.println(">>>>>lastPage>>>>>>" +lastPage); 
		    	
		    	while(i<(30+firstLeave)){
		    		 coll.add(new OrderDetailColl());
		    		i++;
		    	}
		    
		    }else{	    	
		    	
		    	lastPage = (collSize-18)%29;
		    	System.out.println(">>>>>lastPage>>>>>>" +lastPage); 
		 
		    	while(lastPage<30 && lastPage >0){
		    		 coll.add(new OrderDetailColl());
		    		lastPage++;
		    	}
		    
		    }
  
    } 
    
    


    
    //设置合同信息
    public Order getOrderInfo(Map parameters,String orderId){
    	OrderManager mgr = (OrderManager) getBean("orderManager");
    	Order order = mgr.getOrder(orderId);
//		客户名称
//		parameters.put("CustomerName", order.getCustomer().getCustomerName());    	
//		总播出次数
//		parameters.put("OrderSumTimes", order.getOrderPublic().getTimes().toString()); 
		parameters.put("OrderSumTimes",  order.getOrderPublic().getTimes().toString()); 
//		合同类别
		parameters.put("OrderType",  StringUtil.null2String(mgr.getOrderCategoryNameFromMap(order.getCategoryId().toString()))); 
//		电话
		parameters.put("OrderCode",  StringUtil.null2String(order.getOrderCode())); 
//		关联编号
		parameters.put("RelationCode",  StringUtil.null2String(order.getRelationCode())); 
		
//		电话
		parameters.put("OrderSumBase",  StringUtil.doubleFormat(order.getOrderPublic().getMoneyBase().toString())); 		
//		电话
		parameters.put("OrderSumSpeci", ""); 	
//		电话
		parameters.put("OrderSumFavour", StringUtil.null2String("")); 	
//		电话
		parameters.put("OrderOtherFavour", StringUtil.null2String("")); 	
//		电话
		parameters.put("OrderFavourRate",  StringUtil.null2String("")); 	
//		电话
		parameters.put("OrderSumRealpay",  StringUtil.doubleFormat(order.getOrderPublic().getMoneyRealpay().toString())); 	
//      订单备注
		parameters.put("OrderMeno",  StringUtil.null2String(order.getOrderMeno())); 
//		联系人
		parameters.put("OrderUserName",  StringUtil.null2String(order.getUser().getFullName()));
//		创建日期
//		System.out.println("VVVVV   "+order.getUser().getFullName());
//		System.out.println(">>>>>   "+order.getCreateDate());
		parameters.put("OrderCreateDate", DateUtil.getDate(order.getCreateDate()) ); 
		
//		System.out.println(DateUtil.getDate(order.getCreateDate()));
		
		//获得订单的付款信息 
		String payments = getOrderPayment(order);
		parameters.put("OrderPayments",  payments);
		
//		parameters.put("OrderPayments",  ""); 
	
		
		return order;
    }   
    
    //获得付款方式
    public String getOrderPayment(Order order){
    	
    	ContractPaymentManager mgr = (ContractPaymentManager) getBean("contractPaymentManager");
    	ContractPayment contractPayment = new ContractPayment();

    	Long contractId = order.getContractId();
    	Long orderId = order.getId();

		//如果合同编号为0，此订单属于正常类型的订单，可以根据订单号
    	//在付款信息表中找到相关的信息，否则只能通过合同号去查找付款
    	if(contractId.longValue() == 0){
    		contractPayment.setOrderId(orderId);
    	}else{
    		contractPayment.setContractId(contractId);
    	}
    	List payList = mgr.getContractPayments(contractPayment);
    	return mgr.getPaymentsStringList(payList);
    }
    
    

    
    public Collection  getOrderDetails(String orderId){
    	boolean nouse=true;
    	OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
    	return  mgr.getOrderDetailss(orderId,"0","0",null,null,nouse,1);
    }
	
    //设置合同乙方信息
    public void setOrgInfo(Map parameters,Org org,String orderId){
    	Address address = org.getAddress();
    	OrderManager mgr = (OrderManager) getBean("orderManager");
    	Order order = mgr.getOrder(orderId);
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
		parameters.put("OrgBankCode",  StringUtil.null2String(org.getBankCode()));
		//邮编			
//		parameters.put("OrgPostCode",  address.getPostalCode());    
		parameters.put("OrgPostCode",  StringUtil.null2String(address.getPostalCode()));  
		//法人	
//		parameters.put("OrgOwnerAgent",   StringUtil.null2String(order.getUser().getFullName())); 
		parameters.put("OrgOwnerAgent",   StringUtil.null2String(order.getUser().getFullName())); 
	
    }
    
    //设置合同甲方信息
    public void setCustomerInfo(Map parameters,Order order){
  
//    	 System.out.println(">>>>>customerId>>>>>>" + customerId.toString());
    	
    	CustomerManager mgr = (CustomerManager) getBean("customerManager");
    	Customer customer = mgr.getCustomerForOrderPrint(order.getCustomerId().toString());
    	
    	parameters.put("CustomerName",   StringUtil.null2String(customer.getCustomerName()));   
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
		parameters.put("CustomerOwnerAgent",   StringUtil.null2String(customer.getOwnerAgent())); 
//		邮编
//		System.out.println(customer.getPostCode());
		parameters.put("CustomerPostCode",   StringUtil.null2String(customer.getPostCode())); 
    }
	
    public Object getBean(String name) {
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }	

}
