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
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.service.PublishedInfoManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.Constants;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class InfoPrintServlet extends HttpServlet
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
		
		   PublishedInfoManager mgr = (PublishedInfoManager) getBean("publishedInfoManager");
		   		   
		   HttpSession session = request.getSession();

		   String carrierName =  (String)session.getAttribute("carrierName");
		   String resourceIds =  (String)session.getAttribute("resourceIds");
		   String publishDate =  (String)session.getAttribute("publishDate");
	
//            byte target_byte[] = carrierName.getBytes("ISO8859_1");
//            String carrierName2 = new String(target_byte, "GBK");
		   boolean isGBK =  StringUtil.isGBK(carrierName);
			  if(!isGBK){
				  carrierName = StringUtil.toGBK(carrierName);
			  }
		    Collection coll = mgr.getInfosByHistoryColl(resourceIds,publishDate);
		    		        
			ServletContext context = this.getServletConfig().getServletContext();
			  
			String fileSep = Constants.FILE_SEP;
			String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;
			
			File reportFile = new File(context.getRealPath(reportsTemplePath +"info_report.jasper")) ;
						
			if (!reportFile.exists())
				throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
			
			
			Map parameters = new HashMap();
			parameters.put("ReportTitle", "河南有线电视网络集团"+ carrierName +"广告串联单");
			parameters.put("BaseDir", reportFile.getParentFile());
			parameters.put("PublishDate",publishDate);
			
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
			response.setContentType("application/octet-stream");
			ServletOutputStream ouputStream = response.getOutputStream();
			
			ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
			oos.writeObject(jasperPrint);
			oos.flush();
			oos.close();

			ouputStream.flush();
			ouputStream.close();
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

	
    public Object getBean(String name) {
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
	
	
	
	

}
