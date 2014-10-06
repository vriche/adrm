package com.vriche.adrm.service.security.acegi.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.concurrent.CPrincipal;
import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.ui.logout.LogoutHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.vriche.adrm.Constants;

/**
 * Logs a principal out.
 * <p>
 * Polls a series of {@link LogoutHandler}s. The handlers should be specified in the order they are required.
 * Generally you will want to call logout handlers <code>TokenBasedRememberMeServices</code> and
 * <code>SecurityContextLogoutHandler</code> (in that order).
 * </p>
 * <p>
 * After logout, the URL specified by {@link #logoutSuccessUrl} will be shown.
 * </p>
 * <p>
 * <b>Do not use this class directly.</b> Instead configure <code>web.xml</code> to use the
 * {@link org.acegisecurity.util.FilterToBeanProxy}.
 * </p>
 *
 * @author Ben Alex
 * @version $Id: LogoutFilter.java 1967 2007-08-28 11:37:05Z luke_t $
 */
public class LogoutFilter implements Filter {
    //~ Static fields/initializers =====================================================================================

    private static final Log logger = LogFactory.getLog(LogoutFilter.class);
    
   
    
    private static Properties sysProperty = null ;
    

    //~ Instance fields ================================================================================================

    private String filterProcessesUrl = "/j_acegi_logout";
    private String logoutSuccessUrl;
    private LogoutHandler[] handlers;

    //~ Constructors ===================================================================================================

    public LogoutFilter(String logoutSuccessUrl, LogoutHandler[] handlers) {
        Assert.hasText(logoutSuccessUrl, "LogoutSuccessUrl required");
        Assert.notEmpty(handlers, "LogoutHandlers are required");
        this.logoutSuccessUrl = logoutSuccessUrl;
        this.handlers = handlers;
    }

    //~ Methods ========================================================================================================

    /**
     * Not used. Use IoC container lifecycle methods instead.
     */
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        if (!(request instanceof HttpServletRequest)) {
            throw new ServletException("Can only process HttpServletRequest");
        }

        if (!(response instanceof HttpServletResponse)) {
            throw new ServletException("Can only process HttpServletResponse");
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
//        System.out.println("LogoutFilter isCasAuth2 ticket>>>>>>>>>>>>>>>>>"+httpRequest.getParameterMap().containsKey("ticket"));

        if (requiresLogout(httpRequest, httpResponse)) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if(auth==null){
            	CPrincipal cp= new CPrincipal();
            	cp.setName("anonymous");
            	auth = new UsernamePasswordAuthenticationToken(cp,"");
            }
            if (logger.isDebugEnabled()) {
                logger.debug("Logging out user '" + auth + "' and redirecting to logout page");
            }

            for (int i = 0; i < handlers.length; i++) {
                handlers[i].logout(httpRequest, httpResponse, auth);
            }

            sendRedirect(httpRequest, httpResponse, logoutSuccessUrl);

            return;
        }

        chain.doFilter(request, response);
    }

    /**
     * Not used. Use IoC container lifecycle methods instead.
     *
     * @param arg0 ignored
     *
     * @throws ServletException ignored
     */
    public void init(FilterConfig arg0) throws ServletException {
	}

    /**
     * Allow subclasses to modify when a logout should take place.
     *
     * @param request the request
     * @param response the response
     *
     * @return <code>true</code> if logout should occur, <code>false</code> otherwise
     */
    protected boolean requiresLogout(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        int pathParamIndex = uri.indexOf(';');

        if (pathParamIndex > 0) {
            // strip everything from the first semi-colon
            uri = uri.substring(0, pathParamIndex);
        }

        int queryParamIndex = uri.indexOf('?');

        if (queryParamIndex > 0) {
            // strip everything from the first question mark
            uri = uri.substring(0, queryParamIndex);
        }

        if ("".equals(request.getContextPath())) {
            return uri.endsWith(filterProcessesUrl);
        }

        return uri.endsWith(request.getContextPath() + filterProcessesUrl);
    }

    /**
     * Allow subclasses to modify the redirection message.
     *
     * @param request  the request
     * @param response the response
     * @param url      the URL to redirect to
     *
     * @throws IOException in the event of any failure
     */
    protected void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url)
            throws IOException {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = request.getContextPath() + url;
        }
        
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CAS_PROPERTIES);
    	Object o = mp.get(Constants.CAS_AUTH_ENABLED);
    	Object b = (o== null)?"false":o;
		
    	boolean isCasAuth = Boolean.valueOf((String)b).booleanValue();
//    	System.out.println("LogoutFilter isCasAuth1>>>>>>>>>>>>>>>>>"+isCasAuth);
        
//    	System.out.println("LogoutFilter isCasAuth2 ticket>>>>>>>>>>>>>>>>>"+request.getParameterMap().containsKey("ticket"));
    	
        if(isCasAuth){
        	Object obj = mp.get(Constants.CAS_LOGOUT_URL);
        	url = (obj== null)?url:(String)obj;
        }
        
//        System.out.println("LogoutFilter url>>>>>>>>>>>>>>>>>"+url);

        response.sendRedirect(response.encodeRedirectURL(url));
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        Assert.hasText(filterProcessesUrl, "FilterProcessesUrl required");
        this.filterProcessesUrl = filterProcessesUrl;
    }

    protected String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }
}
