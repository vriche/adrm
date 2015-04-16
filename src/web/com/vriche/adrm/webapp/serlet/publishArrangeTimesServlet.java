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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.service.PublishArrangeManager;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class publishArrangeTimesServlet extends HttpServlet{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -5635477054559783925L;
	
	/**
	 *
	 */
	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
//		 System.out.println(">>>>dayOrNeit>>>>>");
		 HttpSession session = request.getSession();
		   String        model=  (String)session.getAttribute("model");
		   String        publishDate=  (String)session.getAttribute("publishDate");
		   String        carrierId=  (String)session.getAttribute("carrierId");
//		   String        dayOrNeit1=  (String)session.getAttribute("dayOrNeit");
		   String        dayOrNeit=  (String)session.getAttribute("dayOrNeit");
		   String orgId =  StringUtil.getNullValue(session.getAttribute("orgId"),"1");
		   
		   String month = publishDate.substring(4,6);
		   String day = publishDate.substring(6,publishDate.length());
//		   System.out.println(".....");
		   boolean isGBK =  StringUtil.isGBK(dayOrNeit);
		  if(!isGBK){
			  dayOrNeit = StringUtil.toGBK(dayOrNeit);
		  }
//		   System.out.println(">>>>publishDate>>>>>"+publishDate);
//		   System.out.println(">>>>carrierId>>>>>"+carrierId);
//		   System.out.println(">>>>dayOrNeit>>>>>"+dayOrNeit);
		   
		   
			ServletContext context = this.getServletConfig().getServletContext();
			
//			Org org = (Org) context.getAttribute(Constants.AVAILABLE_ORG);
			
            Map  orgMap = (Map) Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
            Org org = (Org)  orgMap.get(orgId);
			
			
			
			String fileSep = Constants.FILE_SEP;
			String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;
			File reportFile = new File(context.getRealPath(reportsTemplePath +"form_report.jasper"));
						
			
			if (!reportFile.exists())
				throw new JRRuntimeException("File form_report.jasper not found. The report design must be compiled first.");
			
			
			Map parameters = new HashMap();
			//设置标题
			 if(dayOrNeit!=null&&!dayOrNeit.equals("")){
				 parameters.put("ReportTitle",  org.getReportTitle()+month+"月"+day+"日"+dayOrNeit+"广告串联单");
			 }else{
				 parameters.put("ReportTitle",  org.getReportTitle()+month+"月"+day+"日"+"广告播出串联单");
			 }
			//设置路径
			parameters.put("BaseDir", reportFile.getParentFile());
			parameters.put("ReportSignature", StringUtil.null2String(org.getReportSignature()));
			String LogImgPath = "../../images/"+ orgId +"/logo.jpg";
			parameters.put("ParameterLogImgPath", LogImgPath);
			//设置日期
//			parameters.put("PublishDate",);
			//设置总计
//			parameters.put();
			
			Collection coll = getPulishArrangeFormColl(publishDate,carrierId,dayOrNeit);

		
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
			
			

			
			
		///////////
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

	   public Object getBean(String name) {
	       ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
	       return ctx.getBean(name);
	   }	

	   public Collection  getPulishArrangeFormColl(String publishDate , String carrierId, String dayOrNeit)
	 	{	
//		    String tvname = SysParamUtil.getTvNameParam();
//		    boolean isCatv = "catv".equals(tvname);
		    Collection colle = new ArrayList();
			Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
			Long pId = new Long("0");
			List parantList = (List)carrierMap.get(new Long(carrierId));
//			System.out.println("==== "+dayOrNeit);
//			System.out.println("==== "+parantList.size());
			
			for(Iterator it = parantList.iterator();it.hasNext();){
				Carrier carrier = (Carrier)it.next();
//		    	System.out.println("*****  "+carrier.getNodeLevel());
		    	if(carrier.getNodeLevel().intValue() ==1){
		    	 pId = carrier.getId();
//		    	 System.out.println(">>>>  "+ pId);
		    	 }
		    }
			
			
		    PublishArrangeManager pam = (PublishArrangeManager) getBean("publishArrangeManager");
		    PublishArrange publishArrange = new PublishArrange();
		    publishArrange.setPublishDate(new Integer(publishDate));
		    publishArrange.setCarrierId(pId);
//		    publishArrange.setCarrierId(new Long(carrierId));
		    
//		    System.out.println("1????? " + dayOrNeit.length());
		    
		    if(dayOrNeit.length()==0){
		    	
		    	return pam.getPulishArrangeFormColl(publishArrange);
		    	
		    }else{
		    	
//		    	System.out.println("====3 "+pam.getPulishArrangeFormColl(publishArrange).size());
		    	
			    for(Iterator it = pam.getPulishArrangeFormColl(publishArrange).iterator();it.hasNext();){
			    	PublishArrange publish = (PublishArrange)it.next();
//			    	System.out.println("1????? "+publish.getResourceName());
//			    	System.out.println("2????? "+publish.getResourceMeno());
//			    	if(isCatv){
//			    		publish.setResourceMeno()
//			    	}
//			    	System.out.println("????? "+publish.getCarrierName().indexOf(dayOrNeit));
//			    	System.out.println("????? "+publish.getCarrierName());
			    	if(publish.getCarrierName().indexOf(dayOrNeit)>-1){
			    		colle.add(publish);
			    	}
			    }
//			    System.out.println("colle "+colle.size());
		    	return colle;
		    }
	 	}
   
}
