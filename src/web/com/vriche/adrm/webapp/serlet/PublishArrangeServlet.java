/****************************************************************************     
 * Created on 2007-11-12                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.webapp.serlet;

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
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.model.PublishedInfo;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.PublishArrangeManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
/**
 * PublishArrangeServlet class
 * 
 * This class is used to 
 * 
 * <p><a href="PublishArrangeServlet.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="PublishArrangeServlet"
 * 
 */
public class PublishArrangeServlet  extends HttpServlet{
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
		
    	String tvName = SysParamUtil.getTvNameParam();
    	boolean fztv = SysParamUtil.isFZTVParam(tvName);
    	boolean xmtv = SysParamUtil.isXMTVParam(tvName);
    	boolean moreChannel = SysParamUtil.getMoreChannelPara();

		
		 PublishArrangeManager mgr = (PublishArrangeManager) getBean("publishArrangeManager");
		   
//		   System.out.println(">>>>>mgr>>>>>>" +mgr);
		   
		   HttpSession session = request.getSession();

		   Map parameters = new HashMap();
		   String carrierName =  (String)session.getAttribute("carrierName");
		   String parentName =  (String)session.getAttribute("parentName");
		   String resourceIds =  (String)session.getAttribute("resourceIds");
		   String publishDate =  (String)session.getAttribute("publishDate");
		   String model = (String)session.getAttribute("model");
		   String bianpainame =  (String)session.getAttribute("bianpainame");
		   String carrierId =  (String)session.getAttribute("carrierId");
		   String importType =  (String)session.getAttribute("importType");
		   String startTime =  (String)session.getAttribute("startTime");
		   String endTime =  (String)session.getAttribute("endTime");
		   
		   String orgId =  (String)session.getAttribute("orgId");
		   
//		   String name = user.getFullName();
//		   System.out.println(">>>>>>parentName>>>>>" +parentName);
		   int week = DateUtil.getDaysOfWeek(new Integer(publishDate).intValue());
		   String weekStr = DateUtil.getWeekConvert(week);
		   
//	        String resourceIds = "1,2,";
//	        String publishDate = "20061220";
//		   String carrierName =  (String) request.getAttribute("carrierName");
		   
//		    String carrierName =  request.getParameter("carrierName");
//	        String resourceIds =  request.getParameter("resourceIds");
//	        String publishDate =  request.getParameter("publishDate");

//            byte target_byte[] = carrierName.getBytes("ISO8859_1");
//            String carrierName2 = new String(target_byte, "GBK");
//            byte target_byte1[] = bianpainame.getBytes("ISO8859_1");
//            String name2 = new String(target_byte1, "GBK");

     	   boolean isGBK =  StringUtil.isGBK(carrierName);
 		  if(!isGBK){
 			 carrierName = StringUtil.toGBK(carrierName);
 			  bianpainame = StringUtil.toGBK(bianpainame);
 		  }
            
//	        System.out.println(">>>>>carrierName>>>>>>" +carrierName);
//	        System.out.println(">>>>>carrierName2>>>>>>" +carrierName2);
//	        System.out.println(">>>>>resourceIds>>>>>>" +resourceIds);
//	        System.out.println(">>>>>>publishDate>>>>>" +publishDate);
		    boolean rebuild = false;
		    boolean isRoll = true;
		    boolean onlyHistory = true;
		    boolean isArranged = true;
		    
            String ids[] = resourceIds.split(",");
//            Set idSet = new HashSet();
//            CollectionUtils.addAll(idSet,ids);
            PublishArrange publishArrange = new PublishArrange();
            for(int i = 0 ;i<ids.length;i++ ){
            	publishArrange.getResourceIds().add(ids[i]);
            }
            
            publishArrange.setCarrierName(parentName);
            publishArrange.setPublishDate(new Integer(publishDate));
            publishArrange.setIsArranged(new Boolean(isArranged));
            if(fztv && importType.equals("2")){    
                publishArrange.setResourceMeno(startTime);
                publishArrange.setResourceName(endTime);
            }
            publishArrange.setIsEnable(new Boolean(false));  
            List ls = (List)mgr.getReportColl(publishArrange,rebuild,isRoll,onlyHistory);
          
            String totalUsed = ls.get(ls.size()-1).toString();
//            System.out.println(">>>>>>totalUsed>>>>>" +totalUsed);
            
            Integer total = new Integer(totalUsed)==null?new Integer(0):new Integer(totalUsed);

    		 
    		 String rest = StringUtil.second2HMS(total.intValue());
            
            ls.remove(ls.size()-1);
//	        Collection coll = mgr.getReportColl(publishArrange,rebuild,isRoll,onlyHistory);
            Collection coll = new ArrayList();
            
    	    
    	    
    	    if(fztv && importType.equals("1")){ 
                for(Iterator it = ls.iterator();it.hasNext();){
                	
                	PublishedInfo publishInfo=(PublishedInfo)it.next();
                	if(publishInfo.getTapeCode()==null||publishInfo.getPublishMemo().equals("+")){
                		coll.add(publishInfo);       
                	} 
                }
    	    }else{
                for(Iterator it = ls.iterator();it.hasNext();){
                		coll.add((PublishedInfo)it.next());
                }
    	    }

//	        System.out.println(">>>>>>coll>>>>>" +coll.size());
	        
		ServletContext context = this.getServletConfig().getServletContext();
		
//		Org org = (Org) context.getAttribute(Constants.AVAILABLE_ORG);
		
		System.out.println(">>>>>org>>>>>>" +orgId);
		
        Map  orgMap = (Map) Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
        Org org = (Org)  orgMap.get(orgId);
//		System.out.println(">>>>>org>>>>>>" +org.getName());
		  
		String fileSep = Constants.FILE_SEP;
		String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;
        String fileName ="arrange_report.jasper";
        
//        System.out.println(">>>>>>name>>>>>" );
        int i = SysParamUtil.getPiblishModelParam();
        // i = 5   qztv hntv 
        // i = 1 sjz 
        // i = 6 catv 
//        i = 3 xmtv 
//        System.out.println(">>>>>>getPiblishModelParam>>>>>" + i);
        if(i == 2) fileName = "arrange_report2.jasper";
        if(i == 3) fileName = "arrange_report3.jasper";
        if(i == 4) fileName = "arrange_report4.jasper";
        if(i == 5) fileName = "arrange_report5.jasper";
        if(i == 6) fileName = "arrange_report6.jasper";
        if(i == 7) fileName = "arrange_report7.jasper";
         
//         fileName ="arrange_report7.jasper";
        
		File reportFile = new File(context.getRealPath(reportsTemplePath + fileName));
				
		System.out.println("reportFile>>>>>"+reportsTemplePath + fileName);
		
		if (!reportFile.exists())
			throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");

		

		String channName = null;
//		System.out.println("carrierId>>>>>"+carrierId);
//		System.out.println("isMut>>>>>"+isMut);
		if(moreChannel){
			Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
			List carrierlist = (List)carrierMap.get(new Long(carrierId));		
			for(Iterator is = carrierlist.iterator();is.hasNext();){
				Carrier car = (Carrier)is.next();  
				if(fztv){
					if(carrierlist.size()==2){
						if(car.getNodeLevel().intValue()==2){                    
							channName = car.getCarrierName(); 
						}
					}else{
						if(car.getNodeLevel().intValue()==1){
							channName = car.getCarrierName(); 
						}
					}
				}else{
					if(car.getNodeLevel().intValue()==1){
						channName = car.getCarrierName(); 
					}
				}
			}
			parameters.put("ReportTitle", org.getReportTitle()+ channName+"广告编播单");
//			parameters.put("ReportTitle", channName+"广告编播单");
		}else{
			parameters.put("ReportTitle", org.getReportTitle()+ "广告编播单");
		}
		String pubDateStr = publishDate.toString();
		String year = pubDateStr.substring(0,4);
		String month = pubDateStr.substring(4,6);
		String day = pubDateStr.substring(6,8);
//		parameters.put("ReportTitle", org.getReportTitle()+ carrierName2 +"广告编播单");
		
		parameters.put("BaseDir", reportFile.getParentFile());
		
		parameters.put("adContent",rest);
		
		parameters.put("PublishDate",year+"-"+month+"-"+day);
		parameters.put("week",weekStr);
		parameters.put("name",bianpainame);
		parameters.put("advCount",new Integer(coll.size()));
		parameters.put("orgId",orgId);
		
//		System.out.println("advCount>11111111111111111111111111>>>>"+coll.size());
		
			JasperPrint jasperPrint = null;

			try
			{
//				System.out.println("reportFile>11111111111111111111111111>>>>");
				JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
//				System.out.println("reportFile22222222222222222222222222222>>>>>");					
				jasperPrint = 
					JasperFillManager.fillReport(
						jasperReport,
						parameters, 
						new JRBeanCollectionDataSource(coll)
						);
				
//				System.out.println("reportFile3333333333333333>>>>>");		
				
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
		
	
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
	
}
