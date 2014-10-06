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

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PublishePrintServlet.java,v 1.1 2007/04/05 01:39:47 cvsuser Exp $
 */
public class QueryAdresServlet extends HttpServlet
{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -5635477054559783925L;
//	private static final String CONTENT_TYPE = "text/html; charset=GBK";

	/**
	 *
	 */
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		      HttpSession session = request.getSession();
		
		      String startTime="";
		      String endTime="";
		      String carrierId="";
			  String startDate=  (String)session.getAttribute("startDate");
			  String endDate=  (String)session.getAttribute("endDate");
			  String resourceIds = (String)session.getAttribute("resourceIds");
			  String model=  (String)session.getAttribute("model");
			  String customerName=  (String)session.getAttribute("customerName");
			  String type = (String)session.getAttribute("type");
			  String mode = (String)session.getAttribute("mode");
			  String weekdays = (String)session.getAttribute("weekdays");
			  String orderBy = (String)session.getAttribute("orderBy");
			  
			  
//			   System.out.println(userIdCus+" 3 "+userName+"  000");
			  	String[] reIds = resourceIds.split(",");
				Map parameters = new HashMap();
//				parameters.put("ReportTitle", org.getReportTitle()+ carrierName2 +"广告编播单");
//				parameters.put("BaseDir", reportFile.getParentFile());
//				parameters.put("PublishDate",publishDate);
				
				//设置标题
				String title ="查询";
				if(type.equals("0")){
						if(mode.equals("1")){
							title ="广告资源占用"+ title;
						}else{
							title ="广告资源剩余"+ title;
						}
				}else if(type.equals("1")){
					  startTime=  (String)session.getAttribute("startTime");
					  endTime=  (String)session.getAttribute("endTime");
					  carrierId = (String)session.getAttribute("carrierId");
					  if(mode.equals("1")){
						  title="61号令占用"+title;
					  }else{
						  title="61号令剩余"+title;
					  }
				}
				parameters.put("ReportTitle",title);
				//设置路径
			//	parameters.put("BaseDir", reportFile.getParentFile());
				
//				coll = getCustomerAnalyzeColl(startDate,endDate,userIdCus,carrierName,userName);
				
//		   }

//            byte target_byte[] = carrierName.getBytes("ISO8859_1");
//            String carrierName2 = new String(target_byte, "GBK");
        

//	        System.out.println(">>>>>startDate>>>>>>" +startDate);
//	        System.out.println(">>>>>endDate>>>>>>" +endDate);
//	        System.out.println(">>>>>resourceIds>>>>>>" +resourceIds);
//	        System.out.println(">>>>>>publishDate>>>>>" +publishDate);
	       
	        
	    Collection coll = getResourceByDateForPrint(startDate,endDate,startTime,endTime,carrierId,reIds,customerName,mode,type,weekdays,orderBy);
	        
		ServletContext context = this.getServletConfig().getServletContext();
		
//		Org org = (Org) context.getAttribute(Constants.AVAILABLE_ORG);
//		System.out.println(">>>>>org>>>>>>" +org.getName());
		  
		String fileSep = Constants.FILE_SEP;
		String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;
		File reportFile=null;
		if(type.equals("0")){
			reportFile = new File(context.getRealPath(reportsTemplePath +"queryAdre_report.jasper"));
		}else if(type.equals("1")){
			reportFile = new File(context.getRealPath(reportsTemplePath +"resourceLimit61_report.jasper"));
		}
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
	public static boolean getResourcesLablePara(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getResourceDisplayParam())) sysParam.setResourceDisplayParam("0");
	    return (sysParam.getResourceDisplayParam().equals("0"))?false:true;
	}
	public Collection getResourceByDateForPrint(String beginDate, String endDate, String startTime,String endTime,String carrierId,String[] resourceIds,String customerName,String mode,String type,String weekdays,String orderBy){
		OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
		List ls=new ArrayList();
		if(type.equals("0")){
			ls = mgr.getResourceByDate2(beginDate,endDate,resourceIds,customerName,mode,orderBy);
		}else if(type.equals("1")){
			ls = mgr.getResourceLimitsBy61(beginDate,endDate,startTime,endTime,carrierId,customerName,mode,orderBy);
		}
		 
//		 System.out.println("111111111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
		 
		 String selectDays = "";
		 Collection coll = new ArrayList();
		 boolean isMeno = getResourcesLablePara();

		 for(Iterator it = ls.iterator();it.hasNext();){
			 CustomerProduct cp = (CustomerProduct)it.next();
			 String resourceName = cp.getResourceName();
				String resourceMeno = cp.getResourceMeno();
				String lable = isMeno?resourceMeno:resourceName;
				
			 OrderDetailColl cpColl = new OrderDetailColl();
			 if(!resourceName.equals("合计")){
				 lable = isMeno?"["+lable+"]" +resourceName:"["+lable+"]" +resourceMeno;
			 	 cpColl.setAdvName(lable);
			 } else{
				 cpColl.setAdvName(resourceName);
			 }
			 cpColl.setMonth(cp.getMonth());
			 if(type.equals("1")) {
				 String startTimes=cp.getBroadcastStartTime()==null?"":DateUtil.formatTime(cp.getBroadcastStartTime().longValue()*1000,"h:m:s");
				 String endTimes=cp.getBroadcastEndTime()==null?"":DateUtil.formatTime(cp.getBroadcastEndTime().longValue()*1000,"h:m:s");
				 cpColl.setMeno(startTimes);
				 cpColl.setLength(endTimes);
			 }
//			 cpColl.setMonth(cp.getMonth().substring(4,6));
			 

//			 System.out.println("22222222>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
//			 String[] ss = setValue(cp,mode);
//			 System.out.println("333333333333>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
			 String[] ss = setValue(cp.getDayTimes());
			 String[] dayStandards = setValue(cp.getDayStandards());
//			 System.out.println("1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
			 int i = 0;
			 
	     if(type.equals("0")&&!weekdays.equals("")){
			 for(int j=0;j<31;j++){
				  String sumUsed = cp.getSumUsed();
				  String total = cp.getTotal();
	    		  if(selectDays.length()<31){
			    	  String day = j<9?"0"+(j+1):""+(j+1);
			    	  int week = DateUtil.getDaysOfWeek(Integer.parseInt(cp.getMonth()+day));
		    		  if(weekdays.indexOf(""+week)==-1){
		    			  selectDays+="0";
		    			  ss[j] = ss[j]==""?"0":ss[j];
		    			  dayStandards[j] = dayStandards[j]==""?"0":dayStandards[j];
		    			  cp.setSumUsed(new Double(Double.parseDouble(sumUsed)-Double.parseDouble(ss[j])).toString());
		    			  cp.setTotal(new Double(Double.parseDouble(total)-Double.parseDouble(dayStandards[j])).toString());
		    			  ss[j]="";
		    		  }else{
		    			  selectDays+="1";
		    		  }
	    		  }else if(selectDays.charAt(j)=='0'){
	    			  ss[j] = ss[j]==""?"0":ss[j];
	    			  dayStandards[j] = dayStandards[j]==""?"0":dayStandards[j];
	    			  cp.setSumUsed(new Double(Double.parseDouble(sumUsed)-Double.parseDouble(ss[j])).toString());
	    			  cp.setTotal(new Double(Double.parseDouble(total)-Double.parseDouble(dayStandards[j])).toString());
	    			  ss[j]="";
	    		  }
	    	
			 }
			}
			 cpColl.setDay1(ss[i++]);
			 cpColl.setDay2(ss[i++]);
			 cpColl.setDay3(ss[i++]);
			 cpColl.setDay4(ss[i++]);
			 cpColl.setDay5(ss[i++]);
			 cpColl.setDay6(ss[i++]);
			 cpColl.setDay7(ss[i++]);
			 cpColl.setDay8(ss[i++]);
			 cpColl.setDay9(ss[i++]);
			 cpColl.setDay10(ss[i++]);
			 cpColl.setDay11(ss[i++]);
			 cpColl.setDay12(ss[i++]);
			 cpColl.setDay13(ss[i++]);
			 cpColl.setDay14(ss[i++]);
			 cpColl.setDay15(ss[i++]);
			 cpColl.setDay16(ss[i++]);
			 cpColl.setDay17(ss[i++]);
			 cpColl.setDay18(ss[i++]);
			 cpColl.setDay19(ss[i++]);
			 cpColl.setDay20(ss[i++]);
			 cpColl.setDay21(ss[i++]);
			 cpColl.setDay22(ss[i++]);
			 cpColl.setDay23(ss[i++]);
			 cpColl.setDay24(ss[i++]);
			 cpColl.setDay25(ss[i++]);
			 cpColl.setDay26(ss[i++]);
			 cpColl.setDay27(ss[i++]);
			 cpColl.setDay28(ss[i++]);
			 cpColl.setDay29(ss[i++]);
			 cpColl.setDay30(ss[i++]);
			 cpColl.setDay31(ss[i++]);
			
//			 System.out.println("2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
				 
				 //总规定时间
//		     	 if(cp.getTotal().equals("0"))cp.setTotal("");
			     //规定
				Double standTime = cp.getStandardTime();
				String stand = standTime == null?"":String.valueOf( StringUtil.doubleFormat(standTime));
			 	cpColl.setAdvVer(stand);
			 	 //总规定
		
					
				 cpColl.setSpecific(StringUtil.doubleFormat(cp.getTotal()));
				 String sumUsed = cp.getSumUsed();
//					if(mode.equals("2")){
//						sumUsed = String.valueOf(Double.parseDouble(cp.getTotal()) - Double.parseDouble(sumUsed));  
//					}
				 //总使用时间
				 cpColl.setTapCode(StringUtil.doubleFormat(sumUsed));
				 double xx =new Double(sumUsed).doubleValue()/new Double(cp.getTotal()).doubleValue();
//				 System.out.println("3>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
//				 System.out.println(xx);
				 cpColl.setCarrier(new Double(Math.round(xx*100*Math.pow(10,2))/Math.pow(10,2)).toString()+"%");
//				 System.out.println("4>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
				 coll.add(cpColl);
		 }
	    	return coll;
	    }
	    
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
    
    
    private String[] setValue(CustomerProduct cp,String type){
    	String[] ss = new String[31];
    	Double[] dayUseds = new Double[31];
    	Double[] dayStans = new Double[31];
    	dayUseds = cp.getDayTimes();
    	dayStans = cp.getDayStandards();
    	if(type.equals("2")){
    		for(int i = 0; i< 31;i++){
//    			if(dayStans[i] == null) dayStans[i] = new Double("0.0");
//    			if(dayUseds[i] == null) dayUseds[i] = new Double("0.0");
    			dayUseds[i] = new Double(dayStans[i].doubleValue() - dayUseds[i].doubleValue());
    			
    			ss[i] = StringUtil.doubleFormat(dayUseds[i]);
    			if(ss[i].equals("0")) ss[i] = "";
    			
//    			 System.out.println("444444444444>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ls.size());
//    			StringUtil.doubleFormat();
    		}
    	}else{
    		for(int i = 0; i< 31;i++){
    			ss[i] = StringUtil.doubleFormat(dayUseds[i]);
    			if(ss[i].equals("0")) ss[i] = "";
    		}
    	}
    	
    	 return ss;
    }
    
    
    private String[] setValue(Double[] dayUseds){
    	String[] ss = new String[31];
    		for(int i = 0; i< 31;i++){
    			ss[i] = StringUtil.doubleFormat(dayUseds[i]);
    			if(ss[i].equals("0")) ss[i] = "";
    		}
      return ss;
    }
    
	
	
	

}
