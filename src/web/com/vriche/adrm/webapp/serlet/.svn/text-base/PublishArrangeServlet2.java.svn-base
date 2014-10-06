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
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.model.PublishedInfo;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.PublishArrangeManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
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
public class PublishArrangeServlet2  extends HttpServlet{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -5635477054559783925L;
//	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	public int getPiblishModelParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getPiblishModelParam())) sysParam.setPiblishModelParam("0");
	    return Integer.parseInt(sysParam.getPiblishModelParam());
	}
	/**
	 *
	 */
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		
		 PublishArrangeManager mgr = (PublishArrangeManager) getBean("publishArrangeManager");
		   HttpSession session = request.getSession();
		   
		   
	

		   Map parameters = new HashMap();
		   String carrierName =  (String)session.getAttribute("carrierName");
		   String parentName =  (String)session.getAttribute("parentName");
		   String resourceIds =  (String)session.getAttribute("resourceIds");
		   String publishDate =  (String)session.getAttribute("publishDate");
		   String model = (String)session.getAttribute("model");
		   String bianpainame =  (String)session.getAttribute("bianpainame");
		   String carrierId =  (String)session.getAttribute("carrierId");
		   String orgId =  (String)session.getAttribute("orgId");

		   System.out.println(">>>>>>>>orgId>>>>>>>"+orgId);
		   
//		   int week = DateUtil.getDaysOfWeek(new Integer(publishDate).intValue());
		 
     	   boolean isGBK =  StringUtil.isGBK(carrierName);
 		  if(!isGBK){
 			 carrierName = StringUtil.toGBK(carrierName);
 			bianpainame = StringUtil.toGBK(bianpainame);
 		  }

		    boolean rebuild = false;
		    boolean isRoll = true;
		    boolean onlyHistory = true;
		    boolean isArranged = true;
		    
            String ids[] = resourceIds.split(",");

            PublishArrange publishArrange = new PublishArrange();
            for(int i = 0 ;i<ids.length;i++ ){
            	publishArrange.getResourceIds().add(ids[i]);
            }
            publishArrange.setCarrierName(parentName);
            publishArrange.setPublishDate(new Integer(publishDate));
            publishArrange.setIsArranged(new Boolean(isArranged));
            List ls = (List)mgr.getArrangedPublish(publishArrange,rebuild,isRoll,onlyHistory);
            
            ServletContext context = this.getServletConfig().getServletContext();
//            Org org = (Org) context.getAttribute(Constants.AVAILABLE_ORG);
            
            Map  orgMap = (Map) Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
            Org org = (Org)  orgMap.get(orgId);
            
            
			//设置标题
        	SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
            String moreChannel = StringUtil.null2String(sysParam.getMoreChannelParam());
    		boolean isMut = (moreChannel.equals("0")|| moreChannel.equals(""))?false:true;

    		String channName = null;

    		if(isMut){
    			Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
    			List carrierlist = (List)carrierMap.get(new Long(carrierId));		
    			for(Iterator is = carrierlist.iterator();is.hasNext();){
    				Carrier car = (Carrier)is.next();
    				if(car.getNodeLevel().intValue()==1){
    					channName = car.getCarrierName();
    				}
    			}
    			parameters.put("ReportTitle", org.getReportTitle()+channName+"广告编播单");
//    			parameters.put("ReportTitle", channName+"广告编播单");
    		}else{
    			parameters.put("ReportTitle", org.getReportTitle()+"广告编播单");
    		}
	

      
	
	Collection coll = getPrintInfo(ls);
	String fileSep = Constants.FILE_SEP;
	String reportsTemplePath = fileSep + "reports" + fileSep +"template" +fileSep;

	File reportFile = new File(context.getRealPath(reportsTemplePath +"forPrint_report.jasper"));
	
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
			
//		    System.out.println(p);
//		    System.out.println(num+">>>>>>>>num>>>>>>>");
			
			pub.setResourceName(p);
		    pub.setResourceUsedTimes(t);
		    pub.setResourceMeno(num);
		    coll.add(pub);
		}
		
		return coll;
	}
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
        return ctx.getBean(name);
    }
	
}
