package com.vriche.adrm.util;

import junit.framework.TestCase;


import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;


import com.vriche.adrm.service.AdrmWebService;


public class HelloWorldClientTest extends TestCase {

	public static void main(String[] args)  throws  MalformedURLException,Exception {

//		String url="http://121.28.83.134:8081/adrm/services/webService?wsdl";
//		
//		
//		 Client client = new Client(new URL(url));
//		 Object[] results = client.invoke("getArrangedPublish", new Object[] { "1","20120101" });
//		 System.out.println(results[0]);
// 
//	
//		        try
//		        {            
//		            
////		        	AdrmWebService hs=(AdrmWebService) xf.create(s,url);
////		            String st=hs.getArrangedPublish("1","20130101");
////		            System.out.print(st);
//		        }
//		        catch(Exception e)
//		        {
//		            e.printStackTrace();
//		        }
		    }
	 public void testAdd() {
		        
		         
		 System.out.println(1111111);
		 		String url="http://121.28.83.134:8081/adrm/services/webService";
				
				
				 Client client = null;
				 
				try {
					client = new Client(new URL(url));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

		 
			
				        try
				        {            
							 Object[] results = client.invoke("getArrangedPublish", new Object[] { "1","20120101" });
							 System.out.println(results[0]);
							 System.out.println(2222);
				        }
				        catch(Exception e)
				        {
				            e.printStackTrace();
				        }
		 }
}
