/****************************************************************************     
 * Created on 2007-11-4                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import net.sf.ehcache.CacheException;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.security.acegi.cache.AcegiCacheManager;
import com.vriche.adrm.service.security.acegi.resource.ResourceDetails;

/**
 * UserUtil class
 * 
 * This class is used to 
 * 
 * <p><a href="UserUtil.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="UserUtil"
 *  
 */
// class StaticMapClass {
//	public List getUserRelMap(String loginUser,int i){
//		List ls = new ArrayList();
//		Map userRelsMap = new HashMap();
//		if(i == 1){
//			 userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//		}else{
//			 userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
//		}
//		ls = (List)userRelsMap.get(loginUser);
//		return ls;
//	}
//}
public class UserUtil {
	
	private static final Log log = LogFactory.getLog(UserUtil.class);

	public static String getCurUserId(String userLongName){
		User user = getCurUser(userLongName);
		
		if(user != null){
			return user.getId().toString();
		}else{
			return "0";
		}
		
		
	}
	
	
	public static List getAllUsers(){
//		WebContext ctx = WebContextFactory.get();
//		ServletContext sc = ctx.getServletContext();
//		WebApplicationContext webAppCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		
		UserDao dao = ServiceLocator.getUserDao();
//		UserDao dao = (UserDao) webAppCtx.getBean("userDao");
		return dao.getUsers(null);
	}
	
	
	public static List getUsersByIdList(List userIds){
		UserDao dao = ServiceLocator.getUserDao();
		Map mp = new HashMap(); 
		mp.put("UserIdList",userIds);
		return dao.getUserByIdList(mp);
	}
	
	
	
	public static List getAllUserCustomerCates(String loginUser,String customerType){

		List ls  = new ArrayList();
		boolean customerCateFiter = SysParamUtil.getCustomerCateFiter();
		
		if(customerCateFiter){
			if(loginUser == null ||"".equals(loginUser)){
				loginUser = getCurrentPrincipalUser();
			}
			

			if(customerType == null || "".equals(customerType) ||"0".equals(customerType)||"1".equals(customerType)){
				Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_ID);
				ls = (List)mp.get(loginUser);
			}else{
				ls.add(customerType);
			}
		}

		return ls;
	}
	
	
	public static List getMsgAlertUser(String type){
		List us = getAllUsers();
		List ls = new ArrayList();
//		List ls2 = new ArrayList();

		for(Iterator it = us.iterator();it.hasNext();){
			User user = (User) it.next();
			String userName = user.getUsername();
			String s = user.getAddress().getProvince();
			if(!s.equals("") && s != null){
				if(s.indexOf(type)>-1){
					ls.add(userName);
				}
			}
			
		}

		return ls;
	}
	
	
	
	public static List getCustomerCateByUser(String loginUser,String customerType){
		boolean 	catFiter = SysParamUtil.getCustomerCateFiter();
		
		loginUser = loginUser == null||"".equals(loginUser)? getCurrentPrincipalUser():loginUser;
		List resList = new ArrayList();
		  
		if(customerType == null || "".equals(customerType) ||"0".equals(customerType)||"1".equals(customerType)){
			if(catFiter){
				Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_ID);
				return (List)mp.get(loginUser);
			}else{
				  List ls = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CUSTOMER_TYPE);
				   for(Iterator it = ls.iterator();it.hasNext();){
					   Category cat  = (Category) it.next();
					   resList.add(cat.getId());
				   }
				   return resList;
			}
		}else{
			resList.add(customerType);
			return resList;
		}		
		
	}	
	
	
	public static List getCustomerCateByUserObj(String loginUser){
		boolean 	catFiter = SysParamUtil.getCustomerCateFiter();
		loginUser = loginUser == null||"".equals(loginUser)? getCurrentPrincipalUser():loginUser;
		 List resList = new ArrayList();
			if(catFiter){
				Map mp  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CUT_TYPE_RELS_OBJ);
				return (List)mp.get(loginUser);
			}else{
				resList  = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CUSTOMER_TYPE);
//				   for(Iterator it = ls.iterator();it.hasNext();){
//					   Category cat  = (Category) it.next();
//					   resList.add(cat);
//				   }
				   return resList;
			}
	}		
	
	
	
	
	
	public static Map getUserMaps(int i){
		if(i == 1)
			return (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USERS_MAP);
		else
			return (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USERS_MAP_USERNAME);
	}
	
	

	
	public static List getOwnerUsersList(String loginUser,int i){ 
		loginUser = loginUser == null||"".equals(loginUser)? getCurrentPrincipalUser():loginUser;
		String loginUserId = UserUtil.getCurUserId(loginUser);
		List ls = new ArrayList();
		Map userRelsMap = new HashMap();
		if(i == 1){
			 userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
		}else{
			 userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
		}
		ls = (List)userRelsMap.get(loginUser);
		return ls;
	}
	
//	public static List getOwnerUsersList(String loginUser,int i,String orgId){ 
//		loginUser = loginUser == null||"".equals(loginUser)? getCurrentPrincipalUser():loginUser;
//		List ls = new ArrayList();
//		Map userRelsMap = new HashMap();
//		if(i == 1){
//			 userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//		}else{
//			 userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
//		}
//		ls = (List)userRelsMap.get(loginUser);
//		return ls;
//	}
	
	

	
	
//	public static List getUserRelIds(String parentId){
//		WebContext ctx = WebContextFactory.get();
//		ServletContext sc = ctx.getServletContext();
//		WebApplicationContext webAppCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
//		UserDao dao = (UserDao) webAppCtx.getBean("userDao");
//		Map mp = new HashMap();
//		mp.put("parentId",parentId);
//		List ls =dao.getUserRel(mp);
//		return ls;
//	}
	
	
	
	
	
	public static String getUserFullNameById(Map mp,String id){
		User user = (User)mp.get(id);
		if(user != null){
			return user.getFullName();
		}else{
			return "";
		}
	
	}
	
	public static String getUserNameById(Map mp,String id){
		User user = (User)mp.get(id);
		if(user != null){
			return user.getUsername();
		}else{
			return "";
		}
	
	}
	
	public static String getLoginUserById(String id){
		Map mp = getUserMaps(1);
		User user = (User)mp.get(id);
		return user.getUsername();
	}
	
	public static User getUserById(String id){
		Map mp = getUserMaps(1);
		return (User)mp.get(id);
	}
	
	public static User getUserByUserName(String userName){
		Map mp = getUserMaps(2);
		return (User)mp.get(userName);
	}
	

	
	public static String getUserNameById(String id){
		Map mp = getUserMaps(1);
		return getUserNameById(mp,id);
	}
	
	public static String getUserFullNameById(String id){
		Map mp = getUserMaps(1);
		return getUserFullNameById(mp,id);
	}
	
	
	
	public static User getCurUser(String userLongName){
		Map map  = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USERS_MAP_USERNAME);
		if(userLongName == null || "".equals(userLongName)) userLongName = getCurrentPrincipalUser();
		User user = (User) map.get(userLongName);
		return user;
	}
	
	
	public static List getCurUserRels(String userLongName){
		  Map mp1 = new HashMap();
		  String parentUserId = getCurUser(userLongName).getId().toString();
		  mp1.put("parentId",parentUserId);
		  List ls = ServiceLocator.getUserDao().getUserRel(mp1);
		 
		  return  ls;

	
	}
	
//	private List getCurUserRelsIds(String userLongName){
//		 Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS_ID);
//		 List ls = (List)userRelsMap.get(userLongName);
//		 return ls;
//	}
	
	
	public static List getCurUserRels(Long parentId,String orgId){
		Map mp = new HashMap();
		mp.put("parentId",parentId);
//		mp.put("orgId",orgId);
		
		
		List orgIdList = new ArrayList();
		boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
		if(isOneOrgMoreSuborgs){
			 if("1".equals(orgId)) {
				 orgIdList = SysParamUtil.getOrgChileds(orgId);
			 }else{
				 orgIdList.add(orgId);
			 }
			 mp.put("orgIdList",orgIdList); 
		 }else{
			 mp.put("orgId",orgId);
		 }
		
		List ls = ServiceLocator.getUserDao().getUserRel(mp);
		
		return ls;
	}	
	
	public static List getCurUserRels(String loginUser,String orgId){
		Map mp = new HashMap();


		Long parentId = getCurUser(loginUser).getId();
		
		List orgIdList = new ArrayList();
		boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
		if(isOneOrgMoreSuborgs){
			 if("1".equals(orgId)) {
				 orgIdList = SysParamUtil.getOrgChileds(orgId);
			 }else{
				 orgIdList.add(orgId);
			 }
			 mp.put("orgIdList",orgIdList); 
		 }else{
			 mp.put("orgId",orgId);
		 }

		mp.put("parentId",parentId);
		
//		mp.put("orgId",orgId);
		List ls = ServiceLocator.getUserDao().getUserRel(mp);
//		 System.out.println("parentUserId>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888>>>>>>>>>>>>>>>>"+ls.size()) ;
		return ls;
	}		
	
	
	
	public static String getUserFullName(String userLongName){
		User currentUser = getCurUser(userLongName);
		return currentUser.getFullName();
	}
	
	public static GrantedAuthority[] getGrantedAuthorityByName(String userLongName){
		User currentUser = getCurUser(userLongName);
		return currentUser.getAuthorities();
	}
	
	public static User getCurUser(){
		String currentUser = getCurrentPrincipalUser();
//		System.out.println(">>>>>>8888 <<<<  fggg"+currentUser);
		return getCurUser(currentUser);
	}
	public static String getLoginUser(String loginUser){
		loginUser = (loginUser == null||"".equals(loginUser))?getCurrentPrincipalUser():loginUser;
		return loginUser;
	}
	
	public static boolean isSuperUser(){
		String currentUser = getCurrentPrincipalUser();
		return "admin".equals(currentUser)?true:false;
	}
	
	
	public static String getCurUserId(){
		String currentUser = getCurrentPrincipalUser();
		return getCurUserId(currentUser);
	}
	
	public static String getCurrentPrincipalUser() {
	 SecurityContext ctx = SecurityContextHolder.getContext();
     String currentUser = "";

	 if (ctx.getAuthentication() != null) {
		  Authentication auth = ctx.getAuthentication();
          if (auth.getPrincipal() instanceof UserDetails) {
              currentUser = ((UserDetails) auth.getPrincipal()).getUsername();
          } else {
              currentUser = String.valueOf(auth.getPrincipal());
          }
	 }
	return  currentUser;
  }
	
	public static String getCurrentPrincipalUserId(){
		String currentUser = getCurrentPrincipalUser();
		String userId = getCurUserId(currentUser);
		userId = userId== null|| "".endsWith(userId)?"0":userId;
		return userId;
	}
	
	
	public static List getUserIdList(String orgId){
		
		boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
		
		if(isOneOrgMoreSuborgs){
			   List orgIdList = new ArrayList();
			 	 Map mp = new HashMap();
			 	 orgIdList = SysParamUtil.getOrgChileds(String.valueOf(orgId));
			 	 if(orgIdList.size()== 0){
			       		orgIdList.add(""+orgId);
			       	}
			 	 
			 	 mp.put("orgIdList",orgIdList); 
			 	UserDao  userDao = ServiceLocator.getUserDao();
			 	
			 	return userDao.getUserIdsByOrg(mp);	
		}else{
		  	return new ArrayList();
		}


	}
	
	
	public static boolean isGrandedRes(String userName,String tag){

		AcegiCacheManager acegiCacheManager = ServiceLocator.getAcegiCacheManager();
		final Collection granted = Arrays.asList(acegiCacheManager.getUser(userName).getAuthorities());
		Collection grantedCopy = copy(granted);

//		找出相应的资源?
		ResourceDetails rd = acegiCacheManager.getResourceFromCache(tag);

//		if(rd == null) return false;
		System.out.println("acegiCacheManager.getResourceFromCache(tag);>>>>>>tag no defined>>>>>>>>>>>>>  ");
		
		if(rd != null){
			Collection required = Arrays.asList(rd.getAuthorities());
	
//			判断权限
			if ((null != tag) && !"".equals(tag)) {
				grantedCopy.retainAll(required);
				if (grantedCopy.isEmpty()) {
					return false;
				}
			}
		}else{
			System.out.println("acegiCacheManager.getResourceFromCache(tag);>>>>>>tag no defined>>>>>>>>>>>>>  ");
			return false;
		}

		
		return true;
	}
	
	
	
	
	public static void  isGrandedRes(String userName,Map paramMap){
		
		AcegiCacheManager  acegiCacheManager = ServiceLocator.getAcegiCacheManager();
		
//		WebContext ctx = WebContextFactory.get();
//		ServletContext sc = ctx.getServletContext();
//		WebApplicationContext webAppCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
//		AcegiCacheManager acegiCacheManager = (AcegiCacheManager) webAppCtx.getBean("acegiCacheManager");
		
		final Collection granted = Arrays.asList(acegiCacheManager.getUser(userName).getAuthorities());

//		List ls = acegiCacheManager.getResourcesByType("TAG");
		List ls = acegiCacheManager.getAllResources();
		Iterator it = ls.iterator();

		while(it.hasNext()){
			
			Collection grantedCopy = copy(granted);		
//			StringUtil.printArray(grantedCopy.toArray());
			String tag = (String)it.next();
			boolean isPermit = true;
//			找出相应的资源?
			ResourceDetails rd =  acegiCacheManager.getResourceFromCache(tag);
			Collection required = Arrays.asList(rd.getAuthorities());
//			判断权限
			if ((null != tag) && !"".equals(tag)) {
				grantedCopy.retainAll(required);
				if (grantedCopy.isEmpty()) {
					isPermit =  false;
				}
			}	
		
			
			int pos = tag.indexOf("htm");
			int pos1 = tag.indexOf("jsp");
			if(pos > -1 ){
				tag = tag.substring(1,pos+4);
			}
			if(pos1 > -1){
				tag = tag.substring(1,pos1+3);
			}		
			
			int pos2 = tag.indexOf("com.vriche");
			if(pos2 > -1){
	            String[] s = tag.split("\\.");
	            tag = s[s.length-2] +"."+s[s.length-1];
			}			
			
//			log.info(">>>>>>tag >>>>>>>>>>"+ tag +">>>>>>>>>>>"+isPermit);
			
			paramMap.put(tag,Boolean.valueOf(isPermit));
		}


	}
	


	
	
//	/**
//	 * 获取当前用户授权
//	 * @return
//	 */
//	private static Collection getPrincipalAuthorities() {
//		Authentication currentUser = SecurityContextHolder.getContext()
//				.getAuthentication();
//		if (null == currentUser) {
//			return Collections.EMPTY_LIST;
//		}
//		if ((null == currentUser.getAuthorities())
//				|| (currentUser.getAuthorities().length < 1)) {
//			return Collections.EMPTY_LIST;
//		}
//		return Arrays.asList(currentUser.getAuthorities());
//	}
	
	private static Set copy(Collection c) {
		Set target = new HashSet();
		for (Iterator iterator = c.iterator(); iterator.hasNext();) {
			target.add(iterator.next());
		}
		return target;
	}
	
	
	public static boolean isUserOrderYearRel(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		String isUserOrderYearRel = sysParam.getIsUserOrderYearRel();
		isUserOrderYearRel = isUserOrderYearRel==null?"0":isUserOrderYearRel;
		return isUserOrderYearRel.equals("1");
	}
	
	public static List getUserYearRelByLoginUser(String loginUser){
		boolean 	isUserOrderYearRel = SysParamUtil.isUserOrderYearRel();
		List ls = new ArrayList();
		
		if(isUserOrderYearRel){
			
			loginUser = (loginUser == null||"".equals(loginUser))?UserUtil.getCurrentPrincipalUser():loginUser;
			
			Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_ORDER_YEAR_REL);
			
			Object obj = mp.get(loginUser);

			if(obj != null)ls = (List)mp.get(loginUser);
			if(ls.size() == 0) ls.add("-1");
		}

		
//		System.out.println("years list>>>>>>   "+ls.size());
		return ls;
	}
	

	public static  boolean isSignUserBalance(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getIsSignUserBalance())) sysParam.setIsSignUserBalance("0");
	    return (sysParam.getIsSignUserBalance().equals("0"))?false:true;
	}
	
	public static  List getUserOrgsObj(String loginUser){
		
		loginUser = (loginUser == null||"".equals(loginUser))?UserUtil.getCurrentPrincipalUser():loginUser;
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.GLOBAL_CUSRUSER_ORGS_OBJ);
		Object obj = mp.get(loginUser);
		
//		log.info(">>>>>>>>>>>>>getUserOrgsObj>>>>>>>>>777777777777777777777777777>>>>>>>" +loginUser);
		
		if(obj != null){
			List ls = (List)mp.get(loginUser);
//			log.info(">>>>>>>>>>>>>getUserOrgsObj>>>>>>>>>777777777777777777777777777>>>>>>>" +ls.size());
//			log.info(">>>>>>>>>>>>>getUserOrgsObj>>>>>>>>>777777777777777777777777777>>>>>>>" +((Org)ls.get(0)).toString());
			
			return (List)mp.get(loginUser);
		}else{
			return new ArrayList();
		}
		
	}
	
	public static String getUserOrgs(String loginUser){
		List ls = getUserOrgsObj(loginUser);
	    String s1 ="";
	    String s ="";
	    Iterator it = ls.iterator();
	    int i = 0;
		while(it.hasNext()){
				Org org = (Org)it.next();
				s1 =org.getId().toString();
				if(i <ls.size()-1) s1 =s1 +",";
//				if(!it.hasNext())s1 =s1 +",";
				s =s+ s1 ;
				i++;
		}
		return s;
	}
	public static String getUserOrgs2(String loginUser){
		List ls = getUserOrgsObj(loginUser);
	    String s1 ="";
	    String s ="";
	    Iterator it = ls.iterator();
	    int i = 0;
		while(it.hasNext()){
				Org org = (Org)it.next();
				s1 =org.getId().toString();
				if(i <ls.size()-1) s1 =s1 +",";
//				if(!it.hasNext())s1 =s1 +",";
				s =s+ s1 ;
				i++;
		}
		String[] orgs = s.split(",");

		return orgs[0];
	}
}
