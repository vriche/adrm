package com.vriche.adrm.service.security.acegi.filter;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.AccessDeniedException;
import org.acegisecurity.AcegiSecurityException;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationTrustResolver;
import org.acegisecurity.AuthenticationTrustResolverImpl;
import org.acegisecurity.InsufficientAuthenticationException;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.ui.AbstractProcessingFilter;
import org.acegisecurity.ui.AccessDeniedHandler;
import org.acegisecurity.ui.AccessDeniedHandlerImpl;
import org.acegisecurity.ui.AuthenticationEntryPoint;
import org.acegisecurity.ui.savedrequest.SavedRequest;
import org.acegisecurity.util.PortResolver;
import org.acegisecurity.util.PortResolverImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.vriche.adrm.Constants;

public class ExceptionTranslationFilter implements Filter, InitializingBean {

    //~ Static fields/initializers =====================================================================================

	private static final Log logger = LogFactory.getLog(ExceptionTranslationFilter.class);

	//~ Instance fields ================================================================================================

    private AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandlerImpl();
	private List authenticationEntryPoint;
	private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
	private PortResolver portResolver = new PortResolverImpl();
	private boolean createSessionAllowed = true;

	//~ Methods ========================================================================================================

	public void afterPropertiesSet() throws Exception {
		checkIfValidList(this.authenticationEntryPoint);
//		Assert.notNull(authenticationEntryPoint, "authenticationEntryPoint must be specified");
		Assert.notNull(portResolver, "portResolver must be specified");
		Assert.notNull(authenticationTrustResolver, "authenticationTrustResolver must be specified");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		if (!(request instanceof HttpServletRequest)) {
			throw new ServletException("HttpServletRequest required");
		}

		if (!(response instanceof HttpServletResponse)) {
			throw new ServletException("HttpServletResponse required");
		}

		try {
			chain.doFilter(request, response);

//			if (logger.isDebugEnabled()) {
//				logger.debug("Chain processed normally");
//			}
		}
		catch (AuthenticationException ex) {
			handleException(request, response, chain, ex);
		}
		catch (AccessDeniedException ex) {
			handleException(request, response, chain, ex);
		}
		catch (ServletException ex) {
			if (ex.getRootCause() instanceof AuthenticationException
					|| ex.getRootCause() instanceof AccessDeniedException) {
				handleException(request, response, chain, (AcegiSecurityException) ex.getRootCause());
			}
			else {
				throw ex;
			}
		}
		catch (IOException ex) {
			throw ex;
		}
	}
	   public List getAuthenticationEntryPoint() {
	        return this.authenticationEntryPoint;
	    }
//	public AuthenticationEntryPoint[] getAuthenticationEntryPoint() {
//		return authenticationEntryPoint;
//	}

	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return authenticationTrustResolver;
	}

	public PortResolver getPortResolver() {
		return portResolver;
	}

	private void handleException(ServletRequest request, ServletResponse response, FilterChain chain,
			AcegiSecurityException exception) throws IOException, ServletException {
		if (exception instanceof AuthenticationException) {
			if (logger.isDebugEnabled()) {
				logger.debug("Authentication exception occurred; redirecting to authentication entry point", exception);
			}

			sendStartAuthentication(request, response, chain, (AuthenticationException) exception);
		}
		else if (exception instanceof AccessDeniedException) {
			if (authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
				if (logger.isDebugEnabled()) {
					logger.debug("Access is denied (user is anonymous); redirecting to authentication entry point",
							exception);
				}

				sendStartAuthentication(request, response, chain, new InsufficientAuthenticationException(
						"Full authentication is required to access this resource"));
			}
			else {
				if (logger.isDebugEnabled()) {
					logger.debug("Access is denied (user is not anonymous); delegating to AccessDeniedHandler",
							exception);
				}

				accessDeniedHandler.handle(request, response, (AccessDeniedException) exception);
			}
		}
	}

	/**
	 * If <code>true</code>, indicates that <code>SecurityEnforcementFilter</code> is permitted to store the target
	 * URL and exception information in the <code>HttpSession</code> (the default).
     * In situations where you do not wish to unnecessarily create <code>HttpSession</code>s - because the user agent
     * will know the failed URL, such as with BASIC or Digest authentication - you may wish to
	 * set this property to <code>false</code>. Remember to also set the
	 * {@link org.acegisecurity.context.HttpSessionContextIntegrationFilter#allowSessionCreation}
	 * to <code>false</code> if you set this property to <code>false</code>.
	 *
	 * @return <code>true</code> if the <code>HttpSession</code> will be
	 * used to store information about the failed request, <code>false</code>
	 * if the <code>HttpSession</code> will not be used
	 */
	public boolean isCreateSessionAllowed() {
		return createSessionAllowed;
	}

	protected void sendStartAuthentication(ServletRequest request, ServletResponse response, FilterChain chain,
			AuthenticationException reason) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		SavedRequest savedRequest = new SavedRequest(httpRequest, portResolver);
        
//		System.out.println("1111111111111111111111>>>>>>>>>>>>>>>>>");
		
		if (logger.isDebugEnabled()) {
			logger.debug("Authentication entry point being called; SavedRequest added to Session: " + savedRequest);
		}

		if (createSessionAllowed) {
			// Store the HTTP request itself. Used by AbstractProcessingFilter
			// for redirection after successful authentication (SEC-29)
			httpRequest.getSession().setAttribute(AbstractProcessingFilter.ACEGI_SAVED_REQUEST_KEY, savedRequest);
		}

		// SEC-112: Clear the SecurityContextHolder's Authentication, as the
		// existing Authentication is no longer considered valid
		SecurityContextHolder.getContext().setAuthentication(null);
		
		AuthenticationEntryPoint authPoint = getNewAuthenticationEntryPoint(request);

		authPoint.commence(httpRequest, (HttpServletResponse) response, reason);
		
	}
	
	private AuthenticationEntryPoint getNewAuthenticationEntryPoint(ServletRequest request) {
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CAS_PROPERTIES);
    	Object o = mp.get(Constants.CAS_AUTH_ENABLED);
    	Object b = (o== null)?"false":o;
		
    	boolean isCasAuth = Boolean.valueOf((String)b).booleanValue();
//    	System.out.println("ExceptionTranslationFilter isCasAuth1>>>>>>>>>>>>>>>>>"+isCasAuth);
    	
//    	 HttpServletRequest httpRequest = (HttpServletRequest) request;
//		boolean isCasAuth2 = httpRequest.getParameterMap().containsKey("ticket");
//		System.out.println("ExceptionTranslationFilter isCasAuth2>>>>>>>>>>>>>>>>>"+isCasAuth2);
    	
    	if(isCasAuth){
//    		Assert.isInstanceOf(AuthenticationEntryPoint.class, currentObject,"Can only provide AuthenticationProvider instances");
    		return (org.acegisecurity.ui.cas.CasProcessingFilterEntryPoint)this.authenticationEntryPoint.get(1);
    	}else{
    		return (org.acegisecurity.ui.webapp.AuthenticationProcessingFilterEntryPoint)this.authenticationEntryPoint.get(0);
    	}
	}
	


	public void setAccessDeniedHandler(AccessDeniedHandler accessDeniedHandler) {
		Assert.notNull(accessDeniedHandler, "AccessDeniedHandler required");
		this.accessDeniedHandler = accessDeniedHandler;
	}

//	public void setAuthenticationEntryPoint(AuthenticationEntryPoint[] authenticationEntryPoint) {
//		this.authenticationEntryPoint = authenticationEntryPoint;
//	}
	
    public void setAuthenticationEntryPoint(List newList) {
        checkIfValidList(newList);

        Iterator iter = newList.iterator();

        while (iter.hasNext()) {
            Object currentObject = iter.next();
            Assert.isInstanceOf(AuthenticationEntryPoint.class, currentObject,
                    "Can only provide AuthenticationProvider instances");
        }

        this.authenticationEntryPoint = newList;
    }
	
    private void checkIfValidList(List listToCheck) {
        if ((listToCheck == null) || (listToCheck.size() == 0)) {
            throw new IllegalArgumentException("A list of AuthenticationManagers is required");
        }
    }

	public void setAuthenticationTrustResolver(AuthenticationTrustResolver authenticationTrustResolver) {
		this.authenticationTrustResolver = authenticationTrustResolver;
	}

	public void setCreateSessionAllowed(boolean createSessionAllowed) {
		this.createSessionAllowed = createSessionAllowed;
	}

	public void setPortResolver(PortResolver portResolver) {
		this.portResolver = portResolver;
	}

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }    
}
