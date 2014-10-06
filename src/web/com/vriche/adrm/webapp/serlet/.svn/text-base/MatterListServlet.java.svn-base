package com.vriche.adrm.webapp.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

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

import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.util.ServiceLocator;


public class MatterListServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{

		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>AAAAAAAAAAAAAAA>>>>>>:");
		
		MatterManager mgr = ServiceLocator.getMatterManager();
		
		String strQueryString = request.getQueryString();

		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>BBBBBBBBBBBBB>>>>>>:"+strQueryString);
		
        String xmlStr =  mgr.getMattersNewsPageXML(strQueryString);
        
//        System.out.println("PaymentListServlet>>>>>>>> xmlStr>>>>>>>>>>>>>>:"+xmlStr);

 	    response.setContentType("text/xml; charset=UTF-8"); 

	    PrintWriter out = response.getWriter();

        Document xmldoc = new DocumentImpl();
        StringReader sr = new StringReader(xmlStr);  
        InputSource is = new InputSource(sr);  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
 
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			try {
				xmldoc = builder.parse(is);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          
        
        OutputFormat format = new OutputFormat(xmldoc);
	    format.setIndenting(true); 
	    XMLSerializer serializer = new XMLSerializer(out,format);

        try {
			serializer.asDOMSerializer();
			serializer.serialize(xmldoc);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return;
	}
	
	
}

