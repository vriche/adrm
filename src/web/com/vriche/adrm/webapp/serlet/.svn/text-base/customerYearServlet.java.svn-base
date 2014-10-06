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
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.service.FinanceTargetManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.webapp.util.JasperReportUtil;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class customerYearServlet extends HttpServlet
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 839330582353368012L;

	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		      HttpSession session = request.getSession();
		
		 
			  String type=  (String)session.getAttribute("type");
			  String size=  (String)session.getAttribute("size");
			  String customerId = (String)session.getAttribute("customerIdForm");
			  String channelModelParam = (String)session.getAttribute("channelModelParam");
			  String userName = (String)session.getAttribute("userName");
			  String isPutYear = (String)session.getAttribute("isPutYear");
			  String isNotReturnValue = (String)session.getAttribute("returnValue");
			  String purpose = (String)session.getAttribute("purpose");
			  String header = (String)session.getAttribute("headers");
			  
			  
			  String  model=  (String)session.getAttribute("model");
			  
				String[] headers = header.split(",");; 
				String[] alias = JasperReportUtil.preaseAliasColumnHeaders(headers);  
				
				
				String displaySumColum = "0,";
				for(int i = 1;i<headers.length;i++){
					displaySumColum +="1";
					if(i < headers.length-1) displaySumColum +=",";
				}	
				
				Map parameters = new HashMap();				

	        Collection coll = getCustomerYearForPrint(type,size,customerId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose);
	

	        
			
			JasperPrint jasperPrint = null;

			try
			{
				
				
				JasperReport jasperReport = JasperReportUtil.getJasperReport("","客户年度对比统计",headers,alias,displaySumColum.split(","),true,true);
													
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
				}

				
				if(model.equals("export")){
		             ByteArrayOutputStream oStream = new ByteArrayOutputStream();
		             JRXlsExporter exporter = new JRXlsExporter();
//		             PrintWriter out = response.getWriter();

		             exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		             exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,oStream);
		             exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE); 
		             exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
		             exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
		             try {
		            	 exporter.exportReport();
		             }catch (JRException ex) {
//		            	 out.println("Jasper Output Error:" + ex.getMessage());
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
//		                     out.println("bytes were null!");  
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
 
	public Collection getCustomerYearForPrint(String type, String size,String customerId,String channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose){
		
		FinanceTargetManager mgr = (FinanceTargetManager) getBean("financeTargetManager");
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		int channelMode =Integer.parseInt(channelModelParam);
		int size1 =Integer.parseInt(size);
		List ls = mgr.getCustomerYearAnalyze(size1,type,customerId,channelMode,userName,isPutYear,isNotReturnValue,purpose);
		
		
		for(Iterator it=ls.iterator();it.hasNext();){
			FinanceTarget fTarget = (FinanceTarget)it.next();
			FusionChartObject fObject = new FusionChartObject();

			for(int i=1;i<size1+2;i++){
				switch(i){
				case 1:
					fObject.setValue1(fTarget.getCarrierName());break;
				case 2:
					fObject.setValue2(StringUtil.doubleFormat3(fTarget.getTarMonths()[0]));break;
				case 3:
					fObject.setValue3(StringUtil.doubleFormat3(fTarget.getTarMonths()[1]));break;
				case 4:
					fObject.setValue4(StringUtil.doubleFormat3(fTarget.getTarMonths()[2]));break;
				case 5:
					fObject.setValue5(StringUtil.doubleFormat3(fTarget.getTarMonths()[3]));break;
				case 6:
					fObject.setValue6(StringUtil.doubleFormat3(fTarget.getTarMonths()[4]));break;
				case 7:
					fObject.setValue7(StringUtil.doubleFormat3(fTarget.getTarMonths()[5]));break;
				case 8:
					fObject.setValue8(StringUtil.doubleFormat3(fTarget.getTarMonths()[6]));break;
				case 9:
					fObject.setValue9(StringUtil.doubleFormat3(fTarget.getTarMonths()[7]));break;
				case 10:
					fObject.setValue10(StringUtil.doubleFormat3(fTarget.getTarMonths()[8]));break;
				case 11:
					fObject.setValue11(StringUtil.doubleFormat3(fTarget.getTarMonths()[9]));break;
				case 12:
					fObject.setValue12(StringUtil.doubleFormat3(fTarget.getTarMonths()[10]));break;
				default :
			}
			}
			valuecoll.add(fObject);
		}
		CollectionUtils.addAll(coll,valuecoll.iterator());
		return coll;	
	    }
    
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
	

}
