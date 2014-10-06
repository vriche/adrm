package com.vriche.adrm.webapp.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationTrustResolver;
import org.acegisecurity.AuthenticationTrustResolverImpl;
import org.acegisecurity.context.HttpSessionContextIntegrationFilter;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vriche.adrm.model.User;
import com.vriche.adrm.util.UserUtil;


/**
 * UserCounterListener class used to count the current number
 * of active users for the applications.  Does this by counting
 * how many user objects are stuffed into the session.  It Also grabs
 * these users and exposes them in the servlet context.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserCounterListener implements ServletContextListener, HttpSessionAttributeListener {
	
//public class UserCounterListener {	
    public static final String COUNT_KEY = "userCounter";
    public static final String USERS_KEY = "userNames";
    public static final String CUR_USER_ID_KEY = "curUserIdKey";
    public static final String EVENT_KEY = HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY;
    private final transient Log log = LogFactory.getLog(UserCounterListener.class);
    private transient ServletContext servletContext;
    private int counter;
    private Set users;
//    Constants.AVAILABLE_USERS
    
    public synchronized void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.setAttribute((COUNT_KEY), Integer.toString(counter));
    }

    public synchronized void contextDestroyed(ServletContextEvent event) {
        servletContext = null;
        users = null;
        counter = 0;
    }

    synchronized void incrementUserCounter() {
        counter =
            Integer.parseInt((String) servletContext.getAttribute(COUNT_KEY));
        counter++;
        servletContext.setAttribute(COUNT_KEY, Integer.toString(counter));

        if (log.isDebugEnabled()) {
            log.debug("User Count: " + counter);
        }
    }

    synchronized void decrementUserCounter() {
        int counter =
            Integer.parseInt((String) servletContext.getAttribute(COUNT_KEY));
        counter--;

        if (counter < 0) {
            counter = 0;
        }

        servletContext.setAttribute(COUNT_KEY, Integer.toString(counter));

        if (log.isDebugEnabled()) {
            log.debug("User Count: " + counter);
        }
    }

    synchronized void addUsername(User user) {
        users = (Set) servletContext.getAttribute(USERS_KEY);

        if (users == null) {
            users = new HashSet();
        }

        if (log.isDebugEnabled()) {
            if (users.contains(user)) {
                log.debug("User already logged in, adding anyway...");
            }
        }

        users.add(user);
        servletContext.setAttribute(USERS_KEY, users);
        
        incrementUserCounter();
    }
    
    public void setCurUserId(String userLongName) { 
    	  String uid = UserUtil.getCurUserId(userLongName);
//    	  log.info("event.name:>>>>>>>>>>>>>>>>>>>> 111111111" +uid);
    	  String key = CUR_USER_ID_KEY+"_" + userLongName;
    	  servletContext.setAttribute(key, uid);
    }
    
    

    synchronized void removeUsername(User user) {
        users = (Set) servletContext.getAttribute(USERS_KEY);

        if (users != null) {
            users.remove(user);
        }

        servletContext.setAttribute(USERS_KEY, users);
        decrementUserCounter();
    }

    /**
     * This method is designed to catch when user's login and record their name
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event) {

    	if (event.getName().equals(EVENT_KEY) && !isAnonymous()) {
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		UserDetails user = (UserDetails) auth.getPrincipal();
    		
    		User u = UserUtil.getCurUser(user.getUsername());
    		
//    		  log.info("event.name:>>>>>>>>>>>>>>>>>>>> 111111111");
    		addUsername(u);
//    		addUsername(user);
    	}
    }

    private boolean isAnonymous() {
        AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx != null) {
            Authentication auth = ctx.getAuthentication();
            return resolver.isAnonymous(auth);
        }
        return true;
    }

    /**
     * When user's logout, remove their name from the hashMap
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event) {
    	
    	 if (event.getName().equals(EVENT_KEY) && !isAnonymous()) {
    		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		 
	         if (auth != null && (auth.getPrincipal() instanceof UserDetails)) {
	        	 UserDetails user = (UserDetails) auth.getPrincipal();
	        	 User u = UserUtil.getCurUser(user.getUsername());
//	        	 log.info("event.name:>>>>>>>>>>>>>>>>>>>> 222222222222222222222");
		         removeUsername(u);
	         }   		 
    	 }  
        
    }

    /**
     * Needed for Acegi Security 1.0, as it adds an anonymous user to the session and
     * then replaces it after authentication. http://forum.springframework.org/showthread.php?p=63593
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event) {
        	if (event.getName().equals(EVENT_KEY) && !isAnonymous()) {
        	   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
               if (auth != null) {
            	   UserDetails user = (UserDetails) auth.getPrincipal();
            	   User u = UserUtil.getCurUser(user.getUsername());
//            	   log.info("event.name:>>>>>>>>>>>>>>>>>>>> 33333333333333333");
	               addUsername(u);
//	               addUsername(user);
//	               setCurUserId(user.getUsername());
               }
        	}
    }

}
