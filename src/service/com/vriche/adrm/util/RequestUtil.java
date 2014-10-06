package com.vriche.adrm.util;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.vriche.adrm.model.RequestObject;

public class RequestUtil {
	
	 public static final long a1 = getIpNum("10.0.0.0");
	 public static final long a2 = getIpNum("10.255.255.255");
	 public static final long b1 = getIpNum("172.16.0.0");
	 public static final long b2 = getIpNum("172.31.255.255");
	 public static final long c1 = getIpNum("192.168.0.0");
	 public static final long c2 = getIpNum("192.168.255.255");
	 public static final long d1 = getIpNum("10.44.0.0");
	 public static final long d2 = getIpNum("10.69.0.255");
	 public static final long e1 = getIpNum("168.168.168.0");
	 public static final long e2 = getIpNum("168.168.168.255");	
	 
	 private static long getIpNum(String ipAddress) {   
	     String [] ip = ipAddress.split("\\.");   
	     long a = Integer.parseInt(ip[0]);   
	     long b = Integer.parseInt(ip[1]);   
	     long c = Integer.parseInt(ip[2]);   
	     long d = Integer.parseInt(ip[3]);   
	     return a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;   
	 } 
	 
//	 public static String getIpAddr(HttpServletRequest request) {      
//	       String ip = request.getHeader("x-forwarded-for");      
//	       
//	      
//	       
//	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
//	          ip = request.getHeader("Proxy-Client-IP");      
//	      }      
//	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
//	          ip = request.getHeader("WL-Proxy-Client-IP");      
//	       }      
//	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
//	           ip = request.getRemoteAddr();      
//	      }      
//	     
//	     System.out.println("getReqInfo>>>>>>>>>>>remoteAddr0>>>>>>>>>"+ip);
//	     
//	     return ip;      
//	}
	 
	  public static RequestObject getReqInfo(HttpServletRequest request){
		  String remoteAddr = request.getRemoteAddr().toString();
//		  System.out.println("getReqInfo>>>>>>>>>>>remoteAddr1>>>>>>>>>"+request.getRemoteAddr().toString());
//		  String remoteAddr = getIpAddr(request);
		  System.out.println("getReqInfo>>>>>>>>>>>remoteAddr2>>>>>>>>>"+remoteAddr);
		  
		  RequestObject requestObject = new RequestObject();
		  requestObject.setIsInnerIP(isInnerIP(remoteAddr));
		  return requestObject;
	 }
	  
	  public static boolean isInnerIP(String ip){   
	        long n = getIpNum(ip);
	        return (n >= a1 && n <= a2) || (n >= b1 && n <= b2) || (n >= c1 && n <= c2)|| (n >= e1 && n <= e2) || (n >= d1 && n <= d2||"127.0.0.1".equals(ip));
	 }  
	 
	  public static RequestObject getReqInfo(){  
		  
		         WebContext context = WebContextFactory.get();  
		         HttpServletRequest request = context.getHttpServletRequest();
		         HttpServletResponse response = context.getHttpServletResponse();
		         

		         
		     	 String protocol = request.getRemoteAddr().toString();
		    	 String serverPort = String.valueOf(request.getServerPort());
		    	 String requestURI = request.getRequestURI().toString();
//		    	 String queryString = request.getQueryString().toString();
		    	 String remoteUser = request.getRemoteUser();
		    	 String remotCtxpath = request.getContextPath().toString();
//		    	 if(remoteUser == null){
//			         try {
//			        	 
//			        	 System.out.println(">>>>>>>>>>>remoteUser>>>>>>>>>"+remoteUser);
//			        	 System.out.println(">>>>>>>>>>>remoteUser>>>>>>>>>"+remotCtxpath+"/login.jsp");
//							response.sendRedirect(remotCtxpath+"/login.jsp");
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}	 
//		    	 }
	    	 
		    	 
		    	 
		    	 String remoteHost = request.getRemoteHost().toString();
		    	 String remoteAddr = request.getRemoteAddr().toString();

		    	 HttpSession session = request.getSession();
		         
		    	 
		         
		         RequestObject requestObject = new RequestObject();
		         requestObject.setProtocol(protocol);
		         requestObject.setServerPort(serverPort);
		         requestObject.setRequestURI(requestURI);
//		         requestObject.setQueryString(queryString);
		         requestObject.setRemoteUser(remoteUser);
		         requestObject.setRemoteHost(remoteHost);
		         requestObject.setRemoteAddr(remoteAddr);
		         requestObject.setCtxPath(remotCtxpath);
		         requestObject.setSession(session);
		         
		         
		         System.out.println(">>>>>>>>>>>remoteAddr>>>>>>>>>"+isInnerIP(remoteAddr));
		         
		         requestObject.setIsInnerIP(isInnerIP(remoteAddr));

		         return requestObject;  
	}  
	  
	  
	  

	  

	  
	  
}
