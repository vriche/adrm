/****************************************************************************     
 * Created on 2007-10-18                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.webapp.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.model.SysMenu;
import com.vriche.adrm.service.SysMenuManager;
import com.vriche.adrm.service.security.acegi.cache.AcegiCacheManager;
import com.vriche.adrm.service.security.acegi.resource.ResourceDetails;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.UserUtil;
/**
 * MenuTag class
 * 
 * This class is used to 
 * 
 * <p><a href="MenuTag.java.html"><i>View Source</i></a></p>
 * 
 * 
 *  @jsp.tag name="mymenu" bodycontent="empty"
 * 
 */
public class MenuTag extends TagSupport {

/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6598922021009410645L;
    private String name;
    private String scope;	
    private String contextName;
    private final String split = "_cmSplit";

    

    
    /**
     * @param name The name to set.
     *
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Property used to simply stuff the list of countries into a
     * specified scope.
     *
     * @param scope
     *
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setToScope(String scope) {
        this.scope = scope;
    }
    
    public int doStartTag() throws JspException {
    	 
//        String menuContent = (String)pageContext.getServletContext().getAttribute(Constants.MENU_CONTENT_APPLICATION);
//    	String userName = UserUtil.getCurrentPrincipalUser();
//    	System.out.println("userName>>>>>>>>>>>>>>>>>>>>>>>>>"+ userName);
    	
//        String menuContent = (String)pageContext.getSession().getAttribute(Constants.MENU_CONTENT_APPLICATION);
//       
//        
//        System.out.println("menuContent>>>>>>>>>>>>>>>>>>>>>>>>>"+ (menuContent == null));
        
					String curUser = UserUtil.getCurrentPrincipalUser();
					System.out.println("curUser>>>>>>>>>>>>>>>>>>>>>>>>>"+ curUser);
		
        String menuContent = "";
        
        if (scope != null && !"anonymous".equals(curUser)) {
            if (scope.equals("page")) {
            	menuContent = StringUtil.getNullValue(pageContext.getAttribute(name),"");
            } else if (scope.equals("request")) {
            	menuContent = StringUtil.getNullValue(pageContext.getRequest().getAttribute(name),"");
            } else if (scope.equals("session")) {
            	menuContent = StringUtil.getNullValue(pageContext.getSession().getAttribute(name),"");
            } else if (scope.equals("application")) {
            	menuContent =StringUtil.getNullValue(pageContext.getServletContext().getAttribute(name),"");
            } else {
                throw new JspException("Attribute 'scope' must be: page, request, session or application");
            }
        }

        if (scope != null) {
        	
        			if(menuContent == "" && !"anonymous".equals(curUser)){
        					menuContent = this.buildMenus(curUser);
        	 					}
        			
            if (scope.equals("page")) {
                pageContext.setAttribute(name, menuContent);
            } else if (scope.equals("request")) {
                pageContext.getRequest().setAttribute(name, menuContent);
            } else if (scope.equals("session")) {
                pageContext.getSession().setAttribute(name, menuContent);
            } else if (scope.equals("application")) {
                pageContext.getServletContext().setAttribute(name, menuContent);
            } else {
                throw new JspException("Attribute 'scope' must be: page, request, session or application");
            					}
            
        }else{
        	 menuContent = this.buildMenus(curUser);
        }
        
   try {
			pageContext.getOut().write(menuContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
        
        
        
        
        
//        
//        
//    	   try {
//    		   
//    		   if(menuContent == null){
//    			   
//    		    	StringBuffer sb = new StringBuffer();
//    		        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//    		        contextName = request.getContextPath();
//    				AcegiCacheManager acegiCacheManager = (AcegiCacheManager) getBean("acegiCacheManager");
//    				final Collection granted = getPrincipalAuthorities();
////    				final Collection granted = Arrays.asList(UserUtil.getGrantedAuthorityByName(name));
//    				
//    				
//    				
//	                   //menubackgr
//	       	        sb.append("<table width=\"100%\" class=\"\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n");
//	       	        sb.append("<tr>\n");
//	       	        sb.append("<td class=\"\">\n");
//	       	        sb.append("<div id=\"myMenuID\"></div>\n");
//	       	        
//	       	        sb.append("<script language=\"JavaScript\" type=\"text/javascript\">\n");
//	       	        
//	       	        getSysMenuArray(sb,acegiCacheManager,granted); 
//	       	        
//	       	        sb.append("cmDraw ('myMenuID', myMenu, 'hbr', cmThemeOffice, 'ThemeOffice');\n");     
//	       	        sb.append("</script>\n");      
//	       	        
//	       	        sb.append("</td>\n");  
//	       	        sb.append("<td class=\"\" align=\"right\">&nbsp;</td>\n");  
//	       	        sb.append("<td class=\"\" align=\"right\">\n");          
//	       	        sb.append("</td>\n");       
//	       	        sb.append("</tr>\n");        
//	       	        sb.append("</table>\n");   
//	       	        menuContent = sb.toString();
////	       	        pageContext.getServletContext().setAttribute(Constants.MENU_CONTENT_APPLICATION, sb); 
//	       	        pageContext.getServletContext().setAttribute(Constants.MENU_CONTENT_APPLICATION, menuContent); 
////	       	        pageContext.getSession().setAttribute(Constants.MENU_CONTENT_APPLICATION, menuContent); 
//
//    		   }
//    		   
////    		   System.out.println(menuContent);
//    		   
//               pageContext.getOut().write(menuContent);
////               sb.delete(0,sb.length());
//           } catch (IOException io) {
//               throw new JspException(io);
//           }
           
           return super.doStartTag();
    }
    
    
    protected String buildMenus(String curUser) {
         String menuContent = "";
         
	    	StringBuffer sb = new StringBuffer();
	        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	        contextName = request.getContextPath();
			AcegiCacheManager acegiCacheManager = (AcegiCacheManager) getBean("acegiCacheManager");
			final Collection granted = getPrincipalAuthorities();
//			final Collection granted = Arrays.asList(UserUtil.getGrantedAuthorityByName(name));

               //menubackgr
   	        sb.append("<table width=\"100%\" class=\"\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n");
   	        sb.append("<tr>\n");
   	        sb.append("<td class=\"\">\n");
   	        sb.append("<div id=\"myMenuID\"></div>\n");
   	        
   	        sb.append("<script language=\"JavaScript\" type=\"text/javascript\">\n");
   	        
   	        getSysMenuArray(sb,acegiCacheManager,granted,curUser); 
   	        
   	        sb.append("cmDraw ('myMenuID', myMenu, 'hbr', cmThemeOffice, 'ThemeOffice');\n");     
   	        sb.append("</script>\n");      
   	        
   	        sb.append("</td>\n");  
   	        sb.append("<td class=\"\" align=\"right\">&nbsp;</td>\n");  
   	        sb.append("<td class=\"\" align=\"right\">\n");          
   	        sb.append("</td>\n");       
   	        sb.append("</tr>\n");        
   	        sb.append("</table>\n");   
   	        menuContent = sb.toString();
//   	        pageContext.getServletContext().setAttribute(Constants.MENU_CONTENT_APPLICATION, sb); 
//   	        pageContext.getServletContext().setAttribute(Constants.MENU_CONTENT_APPLICATION, menuContent); 
//   	        pageContext.getSession().setAttribute(Constants.MENU_CONTENT_APPLICATION, menuContent); 
   	        
   	        return menuContent;
    }
    
    /**
     * Release aquired resources to enable tag reusage.
     *
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    public void release() {
        super.release();
    }
    

    
    /**
     * Convenience method to get Spring-initialized beans
     *
     * @param name
     * @return Object bean from ApplicationContext
     */
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());
        return ctx.getBean(name);
    }   
    
//    public String getMenuCtx()
    
    
    
    
public void getSysMenuArray(StringBuffer sb,AcegiCacheManager acegiCacheManager,Collection granted,String curUser) {
	  SysMenuManager mgr = (SysMenuManager) getBean("sysMenuManager");
	  int i = 0;
		
		SysMenu sysMenu = new SysMenu();	
        sb.append("var myMenu =\n");     
        sb.append("[\n"); 
        sb.append("_cmSplit,\n"); 
        
		sysMenu.setParentId(new Long(0));
		
		List ls = mgr.getSysMenus(sysMenu);
		
//		String curUser = UserUtil.getCurrentPrincipalUser();
//		System.out.println("curUser>>>>>>>>>>>>>>>>>>>>>>>>>"+ curUser);
		
		List rolsList = new ArrayList();
		rolsList.add("ROLE_ADMIN");rolsList.add("ROLE_ADMIN2");
		 Collection grantedCopy = copy(granted);
		 grantedCopy.retainAll(rolsList);
		boolean isAdmin = !grantedCopy.isEmpty()||"admin".equals(curUser); 
		
		List rolsList2 = new ArrayList();
		rolsList2.add("ROLE_FINANCE");rolsList2.add("ROLE_FINANCE2");
		 Collection grantedCopy2 = copy(granted);
		 grantedCopy2.retainAll(rolsList2);
		boolean isFinance = !grantedCopy2.isEmpty()||"admin".equals(curUser); 		
		
		
		List rolsList3 = new ArrayList();
		rolsList3.add("ROLE_PERMIT");rolsList3.add("ROLE_PERMIT2");
		 Collection grantedCopy3 = copy(granted);
		 grantedCopy3.retainAll(rolsList3);
		boolean isSysAdmin = !grantedCopy3.isEmpty()||"admin".equals(curUser); 		
		
		
		List rolsList4 = new ArrayList();
		rolsList4.add("ROLE_ARRANGE");rolsList4.add("ROLE_ARRANGE2");
		 Collection grantedCopy4 = copy(granted);
		 grantedCopy4.retainAll(rolsList4);
		boolean isArrange = !grantedCopy4.isEmpty()||"admin".equals(curUser); 			
		
		
		
		System.out.println("isAdminMenus>>>>>>>>>>>>>>>>>>>>>>>>>"+isAdmin);
		System.out.println("isFinance>>>>>>>>>>>>>>>>>>>>>>>>>"+isFinance);
		System.out.println("isSysAdmin>>>>>>>>>>>>>>>>>>>>>>>>>"+isSysAdmin);
		System.out.println("isArrange>>>>>>>>>>>>>>>>>>>>>>>>>"+isArrange);
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			SysMenu menu = (SysMenu) it.next();
			boolean isDisplayAdminMenus = isAdminMenus(curUser,menu.getName(), isAdmin,isFinance,isSysAdmin,isArrange);
			
//			boolean isAdminMenus = isAuthoritied(menu.getName(),"tag_sys_admin_menus", acegiCacheManager, granted);

			fillNode(menu,sb,mgr,acegiCacheManager,granted,isDisplayAdminMenus);

            if(i < ls.size()-1 && menu.getIsDisplay().booleanValue() && isDisplayAdminMenus){
                sb.append(split + ",\n");
            }
            i++;
		}
		sb.substring(0,sb.length());
		sb.append("];\n");
	}


  private boolean isAdminMenus(String curUser,String menuName,boolean isAdminMenus,boolean isFinance,boolean isSysAdmin,boolean isArrange){
	  
	  if("admin".equals(curUser)) return true;
	  
	  if("系统管理".equals(menuName)){
		  return isAdminMenus||isSysAdmin;
	  }else	 if("财务管理".equals(menuName)){
		  return isAdminMenus||isFinance;
	  }else	 if("编播管理".equals(menuName)){
		  return isAdminMenus||isArrange;
	  	 }{
		  return true;
	  }
  }
  
  private boolean isFinanceMenus(String menuName,boolean isFinance){
	  if("财务管理".equals(menuName)){
		  return isFinance;
	  }else{
		  return true;
	  }
  }
  private boolean isAuthoritied(String menuName,String rd,AcegiCacheManager acegiCacheManager,Collection granted){
	   boolean isRight = false;
	   
//	   if("admin".equals(curUser)) return true;
	   
		if ((null != rd) && !"".equals(rd)) {
			    Collection grantedCopy = copy(granted);
			    String tag = rd.toLowerCase() ;
			    Collection required = Collections.EMPTY_LIST;
			    ResourceDetails resourceDetails = acegiCacheManager.getResourceFromCache(tag);
			    if(resourceDetails == null){
			    	
			    	resourceDetails = acegiCacheManager.getResourceFromCache(tag);
			    	 if(resourceDetails != null){
			    		 required = Arrays.asList(resourceDetails.getAuthorities()); 
			    		 grantedCopy.retainAll(required);
				    	 isRight = !grantedCopy.isEmpty(); 
			    	 }else{
			    		 isRight = true;
			    	 }
			    }else{
			    	required = Arrays.asList(resourceDetails.getAuthorities());
			    	 grantedCopy.retainAll(required);
			    	 isRight = !grantedCopy.isEmpty(); 
			    }
			    
//			grantedCopy.retainAll(required);
			
			//有
//			    return (!grantedCopy.isEmpty());
			return isRight;
		}else{
			return true;
		}
 }	
  private boolean isAuthoritied(String rd,AcegiCacheManager acegiCacheManager,Collection granted){
	   boolean isRight = false;
		if ((null != rd) && !"".equals(rd)) {
			    Collection grantedCopy = copy(granted);
			    String tag = "/"+ rd.toLowerCase() ;
			    Collection required = Collections.EMPTY_LIST;
			    ResourceDetails resourceDetails = acegiCacheManager.getResourceFromCache(tag);
			    if(resourceDetails == null){
			    	tag = tag + "*";
			    	resourceDetails = acegiCacheManager.getResourceFromCache(tag);
			    	 if(resourceDetails != null){
			    		 required = Arrays.asList(resourceDetails.getAuthorities()); 
			    		 grantedCopy.retainAll(required);
				    	 isRight = !grantedCopy.isEmpty(); 
			    	 }else{
			    		 isRight = true;
			    	 }
			    }else{
			    	required = Arrays.asList(resourceDetails.getAuthorities());
			    	 grantedCopy.retainAll(required);
			    	 isRight = !grantedCopy.isEmpty(); 
			    }
			    
//			grantedCopy.retainAll(required);
			
			//有
//			    return (!grantedCopy.isEmpty());
			return isRight;
		}else{
			return true;
		}
  }
	
	private void fillNode(SysMenu menu,StringBuffer sb,SysMenuManager mgr,AcegiCacheManager acegiCacheManager,Collection granted,boolean isDisplayAdminMenus ){

		boolean isDisplay = menu.getIsDisplay().booleanValue() && isDisplayAdminMenus;
		
//		acegiCacheManager.getUser("").getAuthorities().
		
		if(isDisplay){
//			SysMenuManager mgr = (SysMenuManager) getBean("sysMenuManager");
//			String tag =  menu.getAction();
//				if (isAuthoritied(tag,acegiCacheManager,granted)) {

					  String imgPath =  menu.getImage();
//					  imgPath = StringUtilsv.trimLeft(imgPath);
//					  imgPath = StringUtilsv.trimRight(imgPath);
				        sb.append("[");
				        
			
				        if(imgPath !="" && !imgPath.equals(null) && !"".equals(imgPath)){
				                sb.append("\'<img src=");
						        sb.append("\"" + contextName + imgPath + "\"");
						        sb.append(" />',");
				        }else{
				            sb.append("\'<span/>',");
//					        sb.append(" />',");
				        }
				        
				        sb.append("'" + menu.getName()  + "',");
				        sb.append("'" + menu.getAction() + "',");
				        sb.append("'" + menu.getTarget() + "',");
				        
				        int i = getSysMenuByParentId(menu.getId(), mgr);

				        
				        if(i > 0){
				            sb.append("'" + menu.getName()   + "'," );
				            sb.append("\n");
				            
				        	getSysMenuByParentId(menu.getId(),sb, mgr,acegiCacheManager,granted,isDisplayAdminMenus);
				        }else{
				        	sb.append("'" + menu.getName()   + "'" );
				        }
				        sb.append("],\n");  	
					
//				}
		
			
          		
		}
	}
	
	
	private void getSysMenuByParentId(Long parentId,StringBuffer sb,SysMenuManager mgr,AcegiCacheManager acegiCacheManager,Collection granted,boolean isAdminMenus){

		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentId(parentId);

		List ls = mgr.getSysMenus(sysMenu);
		
		for(Iterator it = ls.iterator();it.hasNext();){
			SysMenu menu = (SysMenu) it.next();
			fillNode(menu,sb,mgr,acegiCacheManager,granted ,isAdminMenus);
		}

	}
	
	private int getSysMenuByParentId(Long parentId,SysMenuManager mgr){
		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentId(parentId);
		List ls = mgr.getSysMenus(sysMenu);
		return  ls.size();
	}
	/**
	 * 获取当前用户授权
	 * @return
	 */
	private Collection getPrincipalAuthorities() {
		Authentication currentUser = SecurityContextHolder.getContext()
				.getAuthentication();
		if (null == currentUser) {
			return Collections.EMPTY_LIST;
		}
		if ((null == currentUser.getAuthorities())
				|| (currentUser.getAuthorities().length < 1)) {
			return Collections.EMPTY_LIST;
		}
		GrantedAuthority[] aa = currentUser.getAuthorities();
		for(int i =0;i<aa.length;i++) System.out.println("GrantedAuthority>>>>>>>>>>>>>>>>>>>>>>>>>" +aa[i]);
		 
		return Arrays.asList(currentUser.getAuthorities());
	}
	
	private Set copy(Collection c) {
		Set target = new HashSet();
		for (Iterator iterator = c.iterator(); iterator.hasNext();) {
			target.add(iterator.next());
		}
		return target;
	}
}
