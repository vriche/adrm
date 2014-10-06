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

import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.AnalyzeClass;
import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.service.AnalyCarrierMatterManager;
import com.vriche.adrm.service.IncomePullManager;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class AnalyCarrierMatterServlet extends HttpServlet
{
	  /**
	 * 
	 */
	
//	private static final String CONTENT_TYPE = "text/html; charset=GBK";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		      HttpSession session = request.getSession();
		
		     
			  String startDate=  (String)session.getAttribute("startDate");
			  String endDate=  (String)session.getAttribute("endDate");
			  String resourceIds = (String)session.getAttribute("resourceIds");
			  String        model=  (String)session.getAttribute("model");
			  String[] pIds = resourceIds.split(",");
				Map parameters = new HashMap();				
				//设置标题
				parameters.put("ReportTitle",  "载体品牌统计");
				
				
	     Collection coll = getAnalyCarrierMatterPrint(startDate,endDate,pIds);
	        
		ServletContext context = this.getServletConfig().getServletContext();
		
		String fileSep = Constants.FILE_SEP;
		String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;

		File reportFile = new File(context.getRealPath(reportsTemplePath +"analyCarrierMatter_report.jasper"));
				
		if (!reportFile.exists())
			throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
		
		

			
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
		             exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED,Boolean.TRUE);
		             
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
		
	public Collection getAnalyCarrierMatterPrint(String startDate,String endDate,String[] pIds){
		
		AnalyCarrierMatterManager mgr = (AnalyCarrierMatterManager) getBean("analyCarrierMatterManager");
		Collection coll = new ArrayList();
		List ls = mgr.getAnalyCarrierMatterList(startDate,endDate,pIds);
		for(Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass anlyClass = (AnalyzeClass)it.next();
			AnalyzeClass newAnlyClass = new AnalyzeClass();
			
			newAnlyClass.setMatterName(anlyClass.getMatterName());
			newAnlyClass.setSumTimes(anlyClass.getSumTimes());
			newAnlyClass.setRelIncome(anlyClass.getRelIncome());
			
			coll.add(newAnlyClass);
		}
	    	return coll;

}
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
	
	
	
	

}
