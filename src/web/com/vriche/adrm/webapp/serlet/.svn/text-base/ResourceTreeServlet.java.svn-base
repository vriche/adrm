package com.vriche.adrm.webapp.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.util.ServiceLocator;

public class ResourceTreeServlet extends HttpServlet {

	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		
		ResourceManager  resourceManager = ServiceLocator.getResourceManager();
	
		
		String strQueryString = request.getQueryString();

//		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>>>>>>>:"+strQueryString);
		
		String id = request.getParameter("id");
		
//		String type = request.getParameter("type");
		
		System.out.println("PaymentListServlet>>>>>>>> request.getParameter id>>>>>>>>>>>>>>:"+id);
		
		
        String xmlStr =  resourceManager.getResourceXMLforDhtmlTree(strQueryString);
        
//    	System.out.println("PaymentListServlet>>>>>>>> xmlStr>>>>>>>>>>>>>:"+xmlStr);
        
        
        response.setContentType("text/xml;charset=UTF-8");   
        response.setHeader("Cache-Control","no-cache");  
        
        try {   
            System.out.println(xmlStr);   
            response.getWriter().print(xmlStr);   
        } catch (IOException e) {   
            e.printStackTrace();   
        } 
        
//        System.out.println("PaymentListServlet>>>>>>>> xmlStr>>>>>>>>>>>>>>:"+xmlStr);
//
// 	    response.setContentType("text/xml; charset=UTF-8"); 
//        response.setHeader("Cache-Control","no-cache");  
//
//	    PrintWriter out = response.getWriter();
//
//        Document xmldoc = new DocumentImpl();
//        StringReader sr = new StringReader(xmlStr);  
//        InputSource is = new InputSource(sr);  
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
// 
//		try {
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			try {
//				xmldoc = builder.parse(is);
//			} catch (SAXException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//          
//        
//        OutputFormat format = new OutputFormat(xmldoc);
//	    format.setIndenting(true); 
//	    XMLSerializer serializer = new XMLSerializer(out,format);
//
//        try {
//			serializer.asDOMSerializer();
//			serializer.serialize(xmldoc);
//		} catch (IOException ex) {
//			// TODO Auto-generated catch block
//			ex.printStackTrace();
//		}
		return;
	}
	
	

	
}
