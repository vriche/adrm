package com.vriche.adrm.service.security.acegi.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.ui.AbstractProcessingFilter;
import org.acegisecurity.ui.savedrequest.SavedRequest;

import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;

public class CustomProcessingFilter  extends AbstractProcessingFilter {
	
	
	
	//~ Static fields/initializers =====================================================================================
    public static final String ACEGI_SECURITY_FORM_USERNAME_KEY = "j_username";
    public static final String ACEGI_SECURITY_FORM_PASSWORD_KEY = "j_password";
    public static final String ACEGI_SECURITY_LAST_USERNAME_KEY = "ACEGI_SECURITY_LAST_USERNAME";
    //~ Methods ========================================================================================================
	 //~ Static fields/initializers =====================================================================================
	 /** Used to identify a CAS request for a stateful user agent, such as a web browser. */
    public static final String CAS_STATEFUL_IDENTIFIER = "_cas_stateful_";

    /**
     * Used to identify a CAS request for a stateless user agent, such as a remoting protocol client (eg
     * Hessian, Burlap, SOAP etc). Results in a more aggressive caching strategy being used, as the absence of a
     * <code>HttpSession</code> will result in a new authentication attempt on every request.
     */
    public static final String CAS_STATELESS_IDENTIFIER = "_cas_stateless_";

    //~ Methods ========================================================================================================

    
    
    protected UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(HttpServletRequest request,int i){

//		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CAS_PROPERTIES);
//    	Object o = mp.get(Constants.CAS_AUTH_ENABLED);
//    	Object b = (o== null)?"false":o;
//		
//    	boolean isCasAuth = Boolean.valueOf((String)b).booleanValue();  	
    	System.out.println("isCasAuth >>>>>>>>>>>>>>>33333333333333  555555555555555      777777777" );

//    	request.getParameterMap().containsKey("ticket")
    	if(request.getParameterMap().containsKey("ticket")){
    		
   		 	String username = CAS_STATEFUL_IDENTIFIER;
	        String password = request.getParameter("ticket");

	        if (password == null) {
	            password = "";
	        }
	        
	        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

//	        authRequest.setDetails(authenticationDetailsSource.buildDetails((HttpServletRequest) request));
	        
	        setDetails(request, authRequest);

	        return authRequest;    		
    		

    	}else{
		 	String username = obtainUsername(request);
	        String password = obtainPassword(request);

	        if (username == null) {
	            username = "";
	        }

	        if (password == null) {
	            password = "";
	        }

	        username = username.trim();
	        System.out.println(username+"+=============+"+password);    
	        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
	        // Place the last username attempted into HttpSession for views
	        request.getSession().setAttribute(ACEGI_SECURITY_LAST_USERNAME_KEY, username);

	        // Allow subclasses to set the "details" property
	        setDetails(request, authRequest);
	        
	        return authRequest;
    	}
    	
    }
    
    
//    protected String determineUrlToUseForThisRequest(HttpServletRequest arg0, HttpServletResponse arg1,AuthenticationException arg2) {
//    	
//    	   logger.info("determineUrlToUseForThisRequest:" + url);
//    	   // 如果输入上下文,自动跳转到登录页面
//    	   if (!arg0.getServletPath().equals("/")
//    	     && !arg0.getRequestURI().equals(arg0.getContextPath())) {
//    	    url = url + "?" + getNotContexRquestTipParam();
//    	    logger.info("request url!=/ forward to:" + url);
//    	   }
//    	   return url;
//    	}
    

    public static final String ACEGI_PIC_RAM_NUM_AUTHENTICATION = "ramNum";  
    public static final String ACEGI_DEFAULT_TARGET_PARAMETER = "spring-security-redirect"; 
    
    private  String determineTargetUrl(HttpServletRequest request){
    	
    	  
    	     String targetUrl = request.getParameter(ACEGI_DEFAULT_TARGET_PARAMETER);
    	     
    	     System.out.println(request.getMethod()+"+=111111111111111111111============+"+targetUrl);   
//    	     
//    	     if (!StringUtils.hasLength(targetUrl)) {
//    	    	              targetUrl = request.getHeader("Referer");
//    	    	} 
    	    
//    	     if(haveParams) queryString ="";


	    	 if (targetUrl != null) {  
	    		 System.out.println(request.getMethod()+"+=22222222222222222222============+"+targetUrl);   
	             try {  
	                 return URLDecoder.decode(targetUrl, "UTF-8");  
	             } catch (UnsupportedEncodingException e) {  
	                 throw new IllegalStateException("UTF-8 not supported. Shouldn't be possible");  
	             }  
	         }  
	    	 
	    	 SavedRequest savedRequest = (SavedRequest) request.getSession().getAttribute(ACEGI_SAVED_REQUEST_KEY); 
	    	 
    	   if (savedRequest != null) {  
               if (!isAlwaysUseDefaultTargetUrl() || "GET".equals(savedRequest.getMethod())) {  
                   targetUrl = savedRequest.getFullRequestUrl();  
               }  
           }  
     	 
//    	   System.out.println(request.getMethod()+"+=111111111111111111111============+"+request.getMethod());   
//    	   System.out.println(request.getMethod()+"+=111111111111111111111============+"+savedRequest);   
    	
    	   if (targetUrl == null) {  targetUrl = getDefaultTargetUrl();  }  
    	       
    	   if("/".equals(targetUrl)){targetUrl = "mainMenu.html"; }
    	   
    	   
    	   if (targetUrl == null)  targetUrl ="";
    	   
    	   if (!targetUrl.startsWith("http://") && !targetUrl.startsWith("https://")) {   
    		   targetUrl = request.getContextPath() +"/"+ targetUrl;   
    	   } 
    	   
    	   

    	   return targetUrl;  	

//       
//    	 String queryString = request.getQueryString();  
//    	 if(queryString == null) queryString ="";
////    	 boolean haveParams = request.getParameterNames().hasMoreElements();
//        
//        String targetUrl ="";
//        
////        System.out.println(request.getMethod()+"+=111111111111111111111============+"+request.getMethod());    
//        
//        
//        
//        String url = super.obtainFullRequestUrl(request);
//        
////        System.out.println(request.getMethod()+"+=111111111111111111111111111111 obtainFullRequestUrl============+"+url);    
//        
////        url = super.getFilterProcessesUrl();
////      
////
////        System.out.println(request.getMethod()+"+=111111111111111111111111111111=== getFilterProcessesUrl =========+"+url);    
//        
////        url = super.ACEGI_SAVED_REQUEST_KEY
//        
//        SavedRequest saved = (SavedRequest) request.getSession().getAttribute(ACEGI_SAVED_REQUEST_KEY); 
//        
////        System.out.println("+=111111111111111111111111111111= saved ===========+"+saved);  
//        
////        System.out.println("+=111111111111111111111111111111= SavedRequest getFullRequestUrl===========+"+saved.getFullRequestUrl());    
//        
////        System.out.println(request.getMethod()+"+=111111111111111111111111111111============+"+url);    
//        
//        
////        System.out.println(haveParams+"+=11111111111111  haveParams  1111111============+"+haveParams);    
//        
//    	if("GET".equals(request.getMethod())){
//    		StringBuffer url_buffer = request.getRequestURL();  
//    		targetUrl = url_buffer.toString() + queryString;  
//    		targetUrl = request.getRequestURI() + request.getQueryString();
//    	}else{
//    		targetUrl = request.getRequestURI() + queryString;    
//    	}
//    	
//    		
//    	
//   	 try {
//         return URLDecoder.decode(targetUrl, "UTF-8");
//     } catch (UnsupportedEncodingException e) {
//         throw new IllegalStateException("UTF-8 not supported. Shouldn't be possible");
//     } 	
    	

    }
    
    
//    protected String determineTargetUrl2(HttpServletRequest request) {  
//        // Don't attempt to obtain the url from the saved request if alwaysUsedefaultTargetUrl is set  
//     String targetUrl = alwaysUseDefaultTargetUrl ? null :targetUrlResolver.determineTargetUrl(getSavedRequest(request), request, SecurityContextHolder.getContext().getAuthentication());  
//   
//        if (targetUrl == null) {  
//            targetUrl = getDefaultTargetUrl();  
//        }  
//   
//        return targetUrl;  
//    }
    
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult ) throws IOException {

        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper( response );
        Writer out = responseWrapper.getWriter();

        // FIXME This is too JSON-y. Use an object.
        String targetUrl = determineTargetUrl(request );
        
//        System.out.println("+authResult.getName 111111111111111111111111=============+"+authResult.getName());    
        
//        String _app_params =SysParamUtil.getGlobalParams_base(request,authResult.getName());
//        sendRedirect(request, response, targetUrl);   
//        String _app_params ="";
        System.out.println("+_app_params 333333333333=============+"+targetUrl);  
//        System.out.println("+_app_params 22222222222222222=============+"+targetUrl);  
        
//        out.write( "{success:true,_app_params: " + _app_params + ", targetUrl : \'" + targetUrl + "\'}" );
        out.write( "{success:true, targetUrl : \'" + targetUrl + "\'}" );
        out.close();
    }
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.ui.AbstractProcessingFilter#onUnsuccessfulAuthentication(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, org.springframework.security.AuthenticationException)
     */

    protected void onUnsuccessfulAuthentication( HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed ) throws IOException {

        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper( response );
        Writer out = responseWrapper.getWriter();

        // FIXME This is too JSON-y. Use an object.
        out.write( "{ failure: true, errors: 2}" );
        out.close();

    }
    
    
    protected void onPreAuthentication(HttpServletRequest request,HttpServletResponse response) throws AuthenticationException,IOException {
    	   // 验证码验证

//    	   boolean enableRandCode = SysParamUtil.checkIsInnerIP(request);
    	   
//    	   System.out.println("+enableRandCode 22222222222222222=============+" + enableRandCode);   
    	   
//    	   enableRandCode = true;
    	   
    	   String randomCode1 = StringUtil.getNullValue( request.getSession().getAttribute("j_randcode"),"");
    	   String randomCode2 = StringUtil.getNullValue(request.getParameter("j_randcode"),"");
    	   
    	   boolean enableRandCode = !"".equals(randomCode1);
    	   
//    	   System.out.println("+onPreAuthentication 22222222222222222 randomCode1=============+" +randomCode1);   
//    	   System.out.println("+onPreAuthentication 22222222222222222=============+ randomCode2 " +randomCode2);   
    	   
    	   if (enableRandCode) {
    		   if (randomCode2.equals(randomCode1)){
    			   super.onPreAuthentication(request, response);
    		   }else{
//	    		   System.out.println("+onPreAuthentication 22222222222222222=============+");    
		    	    try {
		    	           HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper( response );
		    	           Writer out = responseWrapper.getWriter();
		    	           // FIXME This is too JSON-y. Use an object.
		    	           out.write( "{ failure: true, errors: 1}" );
		    	           out.close();   
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		   }
    	   }else{
    		   super.onPreAuthentication(request, response);
    	   }

    }
   
    
    
    
	public Authentication attemptAuthentication(HttpServletRequest arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		return this.getAuthenticationManager().authenticate(getUsernamePasswordAuthenticationToken(arg0,1));
	}

	public String getDefaultFilterProcessesUrl() {
		return "/j_acegi_security_check";
//		return null;
	}
	public void init(FilterConfig filterConfig) throws ServletException {}
	
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(ACEGI_SECURITY_FORM_USERNAME_KEY);
    }
    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(ACEGI_SECURITY_FORM_PASSWORD_KEY);
    }  
    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}
