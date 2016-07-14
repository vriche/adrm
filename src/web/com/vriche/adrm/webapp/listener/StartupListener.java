package com.vriche.adrm.webapp.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.ProviderManager;
import org.acegisecurity.providers.encoding.Md5PasswordEncoder;
import org.acegisecurity.providers.rememberme.RememberMeAuthenticationProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.LookupManager;
import com.vriche.adrm.util.HandlePropertiesUtil;
import com.vriche.adrm.util.JsonUtil2;
import com.vriche.adrm.util.StringUtil;

/**
 * <p>StartupListener class used to initialize and database settings
 * and populate any application-wide drop-downs.
 * 
 * <p>Keep in mind that this listener is executed outside of OpenSessionInViewFilter,
 * so if you're using Hibernate you'll have to explicitly initialize all loaded data at the 
 * Dao or service level to avoid LazyInitializationException. Hibernate.initialize() works
 * well for doing this.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *
 * @web.listener
 */
//####################################################
//#
//#          博瑞广告经营管理系统 2.0
//#        
//#     版权：2006-2011 北京博瑞弘熹科技有限公司
//#
//#################################################### 



public class StartupListener extends ContextLoaderListener
    implements ServletContextListener {
    
    private static final Log log = LogFactory.getLog(StartupListener.class);
    
//    public void quartzScheduler(){
//   	 SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//   	 try {
//   		Scheduler scheduler = schedulerFactory.getScheduler();
//   		scheduler.shutdown();
//   	} catch (SchedulerException e) {
//   		// TODO Auto-generated catch block
//   		e.printStackTrace();
//   	}
//   }

    public void contextInitialized(ServletContextEvent event) {
    	
  
	    	String  copyRight = "##############################################################################"+"\n\r";
	     copyRight = copyRight+ "#"+"\n\r";
	     copyRight = copyRight+ "#                         ADRM 2.0"+"\n\r";;
	     copyRight = copyRight+ "#"+"\n\r";
	     copyRight = copyRight+ "#                   VRICHE【DEP 2006】"+"\n\r";
	     copyRight = copyRight+ "#"+"\n\r";
	     copyRight = copyRight+ "##############################################################################"+"\n\r";;
	     System.out.println(copyRight);
	     
	     
	     
//	        Constants.APPLACTION_MAP.remove(Constants.FILE_PATH_APP_ROOT);
//	        Constants.APPLACTION_MAP.put(Constants.FILE_PATH_APP_ROOT, WebContextFactory.get().getServletContext());
//	        System.out.println("setupContext rootRealPath>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + WebContextFactory.get().getServletContext());
//	     System.out.print(java.net.URLDecoder.decode(this.getClass().getResource("").getPath().toString()));
//	     Properties prop = new Properties();  
//	     String classPathName = Resource.class.getResource("/").getPath(); 
	     
	     System.out.print(getClass().getResource("/").toString());
	     
	     String servletContexRoot = getClass().getResource("/").toString();
	     String TOKEN ="webapps";
	     int pos = servletContexRoot.indexOf(TOKEN);
	     servletContexRoot = servletContexRoot.substring(0,pos+TOKEN.length());
	     
//	     System.out.println( "##############################################################################servletContexRoot"+"\n\r"+servletContexRoot);

	     
	     Constants.APPLACTION_MAP.remove(Constants.FILE_PATH_SERVELT_CONTEXT_ROOT);
	     Constants.APPLACTION_MAP.put(Constants.FILE_PATH_SERVELT_CONTEXT_ROOT,servletContexRoot);
	     
	     
//	     System.out.println("update db start ..........servletContexRoot............" + servletContexRoot);
//       Constants.APPLACTION_MAP.put(Constants.SELET_CONPTCH,servletContexRoot);
	    
	     
    	
        if (log.isDebugEnabled()) {
            log.debug("initializing context...");
        }
         
        // call Spring's context ContextLoaderListener to initialize
        // all the context files specified in web.xml
        super.contextInitialized(event);
        
      
        
        ServletContext context = event.getServletContext();
        

        

        
        
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Map config = (HashMap) context.getAttribute(Constants.CONFIG);    
        if (config == null) {
            config = new HashMap();
        }
        

 
        // Orion starts Servlets before Listeners, so check if the config
        // object already exists
//        if (context.getInitParameter(Constants.CSS_THEME) != null) {
//            config.put(Constants.CSS_THEME, context.getInitParameter(Constants.CSS_THEME));
//        }
        
        
//        if (context.getInitParameter(Constants.CONTRACT_SORT) != null) {
//            config.put(Constants.CONTRACT_SORT, context.getInitParameter(Constants.CONTRACT_SORT));
//        }



        boolean encryptPassword = false;
        try {
            ProviderManager provider = (ProviderManager) ctx.getBean("authenticationManager");
            for (Iterator it = provider.getProviders().iterator(); it.hasNext();) {
                AuthenticationProvider p = (AuthenticationProvider) it.next();
                if (p instanceof RememberMeAuthenticationProvider) {
                    config.put("rememberMeEnabled", Boolean.TRUE);
                }
            }

            if (ctx.containsBean("passwordEncoder")) {
                encryptPassword = true;
                config.put(Constants.ENCRYPT_PASSWORD, Boolean.TRUE);
                String algorithm = "SHA";
                if (ctx.getBean("passwordEncoder") instanceof Md5PasswordEncoder) {
                    algorithm = "MD5";
                }
                config.put(Constants.ENC_ALGORITHM, algorithm);
            }
        } catch (NoSuchBeanDefinitionException n) {
            // ignore, should only happen when testing
        }

        context.setAttribute(Constants.CONFIG, config);

        // output the retrieved values for the Init and Context Parameters
        if (log.isDebugEnabled()) {
            log.debug("Remember Me Enabled? " + config.get("rememberMeEnabled"));
            log.debug("Encrypt Passwords? " + encryptPassword);
            if (encryptPassword) {
                log.debug("Encryption Algorithm: " + config.get(Constants.ENC_ALGORITHM));
            }
            log.debug("Populating drop-downs...");
        }

 
        
        setupContext(context);
        

    }

    public static void setupContext(ServletContext context) {
    	
    	int kkk = 0;
    	
    	
    	Map config = (HashMap) context.getAttribute(Constants.CONFIG);   
    	
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(context);

        LookupManager mgr = (LookupManager) ctx.getBean("lookupManager");
        
        SysParam sysParam = mgr.getSysParams();
        putSysParam2Config(config,sysParam,mgr);
        
        System.out.println("update db start ......................");
        mgr.excuteSql();
        System.out.println("update db end ......................");
        

        
      
        

       
        
   
     
        
        

        // get list of possible sysParam
        context.setAttribute(Constants.GLOBAL_SYS_PARAM, sysParam);

 
        System.out.println("getAllRoles ......................");
        
        // get list of possible roles
        context.setAttribute(Constants.AVAILABLE_ROLES, mgr.getAllRoles());
        
        
 
    	
        System.out.println("getBranchs ......................");
        // get list of possible roles
        Object[] objs = mgr.getBranchs();
        context.setAttribute(Constants.AVAILABLE_BRANCHS, objs[0]);
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_BRANCHS);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_BRANCHS,objs[1]);
        

        
        
        // get list of possible roles
//        Org org = mgr.getOrg();
        System.out.println("getOrgs ......................");
        List orgLs = mgr.getOrgs();
        System.out.println("getOrgs .....orgLs.size()................."+orgLs.size());
        Map orgMap = new HashMap();
        String pressText ="";
    	for(Iterator it = orgLs.iterator();it.hasNext();){
    		Org org2 = (Org)it.next();
    		
//    		System.out.println("getOrgs  ............6666666666666666666666666666666 Org.........."+ org2);
    		
    		String tarFile = Constants.FILE_SEP+"images"+ Constants.FILE_SEP +org2.getId()+ Constants.FILE_SEP + "logo.jpg" ;
    		String tarFileRel = context.getRealPath("/")+tarFile;
    		org2.setLogFile(tarFile);
    		org2.setLogFileRel(tarFileRel);
    		
    		mgr.saveOrgLogoToFile(tarFileRel,org2.getLogo());
    		orgMap.put(org2.getId().toString(),org2);
    		
//    		if(org.getId().longValue() == 1) pressText = org.getName()+"广告经营管理系统 V"+org.getVersion();
//    		if(org.getId().longValue() == 1) pressText = org.getName()+"广告经营管理系统";
    		if(org2.getId().longValue() == 1){
    			pressText = org2.getName();
    			config.put("LOGO_ORG_NAME", pressText);
    			config.put("SOFT_VERSION", org2.getVersion());
    			
    			 Constants.APPLACTION_MAP.put(Constants.LOGO_ORG_NAME,pressText);
    			 Constants.APPLACTION_MAP.put(Constants.SOFT_VERSION,org2.getVersion());
    		}
        
     	}
    	
    	
    	//处理水印文件
    	
//    	String targetImg =context.getRealPath("/")+"images"+ Constants.FILE_SEP  +"login"+ Constants.FILE_SEP  +"index_logo.jpg" ;
////    	String targetImg =context.getRealPath("/")+"images"+ Constants.FILE_SEP  +"login"+ Constants.FILE_SEP  +"index_main_bg.jpg" ;
//
//    	String fontName="";
//    	ImageUtils.pressText( pressText,  targetImg,  fontName,  1, 888888, 24,380,5,0.8f);
//    	 System.out.println("targetImg ......................"+targetImg);
    	
    	
    	
        context.setAttribute(Constants.AVAILABLE_ORG, orgMap);
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_ORG);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_ORG,orgMap);


    
        // get list of possible roles
        context.setAttribute(Constants.MENU_CONTENT_APPLICATION, null); 
        
        // get list of possible roles
//        context.setAttribute(Constants.AVAILABLE_USER_RELS,mgr.getUserRels(false)); 
        
//        context.setAttribute(Constants.AVAILABLE_USER_CARRIER_RELS,mgr.getUserCarrierRels(false)); 


        
        //把系统参数放到静态变量中
        Constants.APPLACTION_MAP.remove(Constants.GLOBAL_SYS_PARAM);
        Constants.APPLACTION_MAP.put(Constants.GLOBAL_SYS_PARAM,sysParam);
        
        System.out.println("getUserRels ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_RELS);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_RELS,mgr.getUserRels(true));
        
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_RELS_ID);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_RELS_ID,mgr.getUserRels(false));
        

        System.out.println("getUserCarrierRels ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_CARRIER_RELS);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_CARRIER_RELS,mgr.getUserCarrierRels(true));
        

        
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_CARRIER_RELS_ID); 
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_CARRIER_RELS_ID,mgr.getUserCarrierRels(false));
        
    

        //用户和客户类型关系
        List ls = mgr.getUserCustomerTypeRels();
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_CUT_TYPE_RELS_ID); 
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_CUT_TYPE_RELS_ID, ls.get(0));  
         

        
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_CUT_TYPE_RELS_OBJ); 
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_CUT_TYPE_RELS_OBJ, ls.get(1));  
        
        

        System.out.println("getResourceMap ......................");
        //把获得的一个以载体编号为KEY，VALUE为 LIST 的MAP 放到MAP中
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_RESOURCE_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_RESOURCE_MAP,mgr.getResourceMap());


        System.out.println("getUserCarrierSortMap ......................");
        //return Map<username,map<carrierTypeId,carrierId> >
        //return Map<username,map<电视ID,弟一级载体ID> >
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_CARRIER_SORT_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_CARRIER_SORT_MAP,mgr.getUserCarrierSortMap());


        System.out.println("getCarriersAll ......................");
        //获得所有载体对象List
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_ALL);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_ALL,mgr.getCarriersAll());  
        

       
        System.out.println("getCarriersAllMap ......................");
        //获得所有载体对象Map
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_ALL_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_ALL_MAP,mgr.getCarriersAllMap());     
        
        System.out.println("getCarrierMap ......................");

        //获得每一个carrier的所有父亲的Map,key为carrierId 
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER,mgr.getCarrierMap());
        

        System.out.println("getCarrierMap2 ......................");
        //获得所有孩子的carrierId
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_CHILD);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_CHILD,mgr.getCarrierMap2());
       

        System.out.println("getCarrierMapNoMyslfe ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_CHILD_NOMYSALFE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_CHILD_NOMYSALFE,mgr.getCarrierMapNoMyslfe());
//        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_MATTER_SAME_NAME);
        
        System.out.println("getOrderCatelogMap ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_ORDER_CATELOG_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_ORDER_CATELOG_MAP,mgr.getOrderCatelogMap());
        
        System.out.println("getOrderCatelogParentList ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_ORDER_CATELOGPARENT_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_ORDER_CATELOGPARENT_MAP,mgr.getOrderCatelogParentList());
        
        
        System.out.println("getInduStryList ......................");
        //行业类别
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_INDUSTRY);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_INDUSTRY,mgr.getInduStryList());

        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_INDUSTRY_Map);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_INDUSTRY_Map,mgr.getInduStryMap());

        System.out.println("getResourceSortList ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_RESOURCESORT);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_RESOURCESORT,mgr.getResourceSortList());

        System.out.println("getResourceNameMap ......................");
        //有resource 表中的字段获得资源名和相应的载体名 MAP
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_RESOURCENAME_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_RESOURCENAME_MAP,mgr.getResourceNameMap());
        
        System.out.println("getResourceYearTypeMap ......................");
        //有resource 表中的字段获得资源名和相应的载体名 MAP
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_RESOURCENAME_YEAR_TYPE_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_RESOURCENAME_YEAR_TYPE_MAP,mgr.getResourceYearTypeMap());
        
      

        //缓存指定位置的Map
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_SOECUFUC);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_SOECUFUC,mgr.getSpecificList());

        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_SOECUFUC_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_SOECUFUC_MAP,mgr.getSpecificMap());

        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_PRICETYPE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_PRICETYPE,mgr.getPriceTypeList());

        

//      缓存中制定业务员的Map
//        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USERS);
//        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USERS,mgr.getSysUserList());
        System.out.println("getSysUserMap ......................");
        //key - user_id
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USERS_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USERS_MAP,mgr.getSysUserMap(1));
        
        //key - user_name
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USERS_MAP_USERNAME);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USERS_MAP_USERNAME,mgr.getSysUserMap(2));
        
        
//        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USERS_MAP_RIGTHS);
//        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USERS_MAP_RIGTHS,mgr.getSysUserRigthsMap(context));
        
        System.out.println("getBranchMapById ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_BRANCHMAP_BYID);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_BRANCHMAP_BYID,mgr.getBranchMapById());

//      缓存中客户归属业务员的Map  key:userName  value: List customerIds
//        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CUSTOMER_USER_RELS);
//        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CUSTOMER_USER_RELS,mgr.getSysUserList());
        System.out.println("getOrderListCatagory ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_ORDERLIST_CATELOG_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_ORDERLIST_CATELOG_MAP,mgr.getOrderListCatagory());

        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_ORDER_CATELOGNAME_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_ORDER_CATELOGNAME_MAP,mgr.getOrderListCatagoryName());

        System.out.println("getOaWorkFlowCheckStateList ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CHECK_STATE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CHECK_STATE,mgr.getOaWorkFlowCheckStateList());

        System.out.println("getPriceLengthDetail start ......................");
//        取广告的长度
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_PRICE_LENGTH_DETAIL);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_PRICE_LENGTH_DETAIL,mgr.getPriceLengthDetail());
        
        System.out.println("getPriceLengthDetail end ......................");   
        
        
        
        //广告上传路径
        Constants.APPLACTION_MAP.remove(Constants.FILE_ADVERS_DIR);
        
        
    
        
        System.out.println("getPriceLengthDetail FILE_ADVERS_DIR ......................1");   
        
        Constants.APPLACTION_MAP.put(Constants.FILE_ADVERS_DIR,context.getRealPath("download") +Constants.FILE_SEP + Constants.FILE_ADVERS_DIR);
        System.out.println("getPriceLengthDetail FILE_ADVERS_DIR ......................2");      
         
        //数据备份路径
        System.out.println("getPriceLengthDetail FILE_DBBACKUP_DIR ......................");   
        Constants.APPLACTION_MAP.remove(Constants.FILE_DBBACKUP_DIR);
        Constants.APPLACTION_MAP.put(Constants.FILE_DBBACKUP_DIR,context.getRealPath("download") +Constants.FILE_SEP + Constants.FILE_DBBACKUP_DIR);

        System.out.println("getCarrierTypeList ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_TYPES);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_TYPES,mgr.getCarrierTypeList());
        
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_TYPES_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_TYPES_MAP,mgr.getCarrierTypeMap());       
        

        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIERS_BY_CARRIER_TYPE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIERS_BY_CARRIER_TYPE,mgr.getCarriersByType());
    
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIERTYPE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIERTYPE,mgr.getCarrierTypeListByParentId());
 
        System.out.println("getIncomeMode ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_INCOME_MODE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_INCOME_MODE,mgr.getIncomeMode());
      
        System.out.println("getIncomePourse ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_INCOME_PURPOSE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_INCOME_PURPOSE,mgr.getIncomePourse());
   
        //客户类别
        System.out.println("getCustomerCategory ......................");
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CUSTOMER_TYPE);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CUSTOMER_TYPE,mgr.getCustomerCategory());   
        
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CUSTOMER_TYPE_MAP);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CUSTOMER_TYPE_MAP,mgr.getCustomerCategoryMap());   
        
      
        
        System.out.println("getCheckUserRel ......................");
        //审核人与被审核人关系
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CHECK_USER_REL);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CHECK_USER_REL,mgr.getCheckUserRel());  
      
        System.out.println("getCustomerRel ......................");
        //客户隶属关系
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CUSTOMER_WITH_CUT_REL);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CUSTOMER_WITH_CUT_REL,mgr.getCustomerRel());  

        System.out.println("getUserYearRel ......................");
        //订单年份归属
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_USER_ORDER_YEAR_REL);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_USER_ORDER_YEAR_REL,mgr.getUserYearRel());  
        
        
        System.out.println("getOtherSameAlisnameId ......................");
        //根据频道ID获得别名相同其它的频道编号  
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_ALISNAME_REL);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_ALISNAME_REL,mgr.getOtherSameAlisnameId());  
           
       
        
        
        //添加cas service 属性map
        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CAS_PROPERTIES);
        Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CAS_PROPERTIES,getCasProperties(context));
      
        
        String rootRealPath = context.getRealPath("/");
  
        
        
        String fileSep = Constants.FILE_SEP;
//        Constants.APPLACTION_MAP.remove(Constants.APP_SYS_LOGO_FILE);
//        String appSystemLogoFile = rootRealPath  + "images" +fileSep+"logo.jpg";
//        Constants.APPLACTION_MAP.put(Constants.APP_SYS_LOGO_FILE,appSystemLogoFile);
        Constants.APPLACTION_MAP.remove(Constants.REPORTS_TEMPLE_PATH);
        String reportsTemplePath = rootRealPath  +  "reports" + fileSep +"template" +fileSep;
        Constants.APPLACTION_MAP.put(Constants.REPORTS_TEMPLE_PATH,reportsTemplePath);
        
        
        Constants.APPLACTION_MAP.remove(Constants.REPORTS_TEMPLE_PATH2);
        String reportsTemplePath2 = rootRealPath  +  Constants.FILE_GRID_REPORT_DIR + fileSep +"grf" +fileSep; 
        Constants.APPLACTION_MAP.put(Constants.REPORTS_TEMPLE_PATH2,reportsTemplePath2);
        
        System.out.println("REPORTS_TEMPLE_PATH2 ......................"+reportsTemplePath2);
        
//        List lsOrgs = mgr.getUserOrgs();
//        Constants.APPLACTION_MAP.remove(Constants.GLOBAL_CUSRUSER_ORGS);
//    	Constants.APPLACTION_MAP.put(Constants.GLOBAL_CUSRUSER_ORGS,lsOrgs.get(0));
        System.out.println("getUserOrgs ......................");
        Constants.APPLACTION_MAP.remove(Constants.GLOBAL_CUSRUSER_ORGS_OBJ);
    	Constants.APPLACTION_MAP.put(Constants.GLOBAL_CUSRUSER_ORGS_OBJ, mgr.getUserOrgs());
    	
    	
    	
//        System.out.println("getresourceUseRateTable ......................");
//        Constants.APPLACTION_MAP.remove(Constants.RESOURCE_USE_RATE_TABLE);
//    	Constants.APPLACTION_MAP.put(Constants.RESOURCE_USE_RATE_TABLE, mgr.getUserOrgs());
    	
    

    	
        System.out.println("getFitterOrderSubCate ......................start ");
        List lsFitter = mgr.finaciaAuditFitter();
        
        Constants.APPLACTION_MAP.remove(Constants.FINANCIAL_AUDIT_SWITCH);
        Constants.APPLACTION_MAP.put(Constants.FINANCIAL_AUDIT_SWITCH,lsFitter.get(0));
        
//        System.out.println("Constants.FINANCIAL_AUDIT_SWITCH .......666666666666666666666666666666666..............."+lsFitter.get(0));
        
        Constants.APPLACTION_MAP.remove(Constants.FITTER_ORDER_SUBCATES_WITHOUT);
    	Constants.APPLACTION_MAP.put(Constants.FITTER_ORDER_SUBCATES_WITHOUT, lsFitter.get(1));
      
        Constants.APPLACTION_MAP.remove(Constants.FITTER_INCOME_POURS_WITHOUT);
    	Constants.APPLACTION_MAP.put(Constants.FITTER_INCOME_POURS_WITHOUT,lsFitter.get(2));   	
    	
        Constants.APPLACTION_MAP.remove(Constants.FITTER_ORDER_SUBCATES);
    	Constants.APPLACTION_MAP.put(Constants.FITTER_ORDER_SUBCATES, lsFitter.get(3));
      
        Constants.APPLACTION_MAP.remove(Constants.FITTER_INCOME_POURS);
    	Constants.APPLACTION_MAP.put(Constants.FITTER_INCOME_POURS,lsFitter.get(4));    	
    	
    	
    	 Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_RESOURCE_TREE);
    	 
    	 
    	 
    	 
         
//         Constants.APPLACTION_MAP.remove(Constants.FTP_SERVVICE_CONFIG);
//         Constants.APPLACTION_MAP.put(Constants.FTP_SERVVICE_CONFIG,"");
    	 
    	
        	

    	
    	 System.out.println("getFitterOrderSubCate ......................end ");
    	
    	   	
//        Constants.APPLACTION_MAP.remove(Constants.AVAILABLE_CARRIER_ORG_MAP);
//    	Constants.APPLACTION_MAP.put(Constants.AVAILABLE_CARRIER_ORG_MAP,mgr.getOrgByCarrier());
    	
    	
        
        if (log.isDebugEnabled()) {
            log.debug("Drop-down initialization complete [OK]");
        }
    }
    
    
    private static Map getCasProperties(ServletContext context){
    	

        
         Map mp = new HashMap();
//         Properties prop = new Properties();
         try {
//        	 String  path = context.getRealPath("WEB-INF/cas.properties");
        	 
        	 Properties ps = HandlePropertiesUtil.loadFromClass("cas.properties");
//        	 System.out.println("properties 1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+context.getRealPath("WEB-INF/cas.properties"));
//        	 System.out.println("properties 2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+path);
//        	 FileInputStream in = new  FileInputStream(path); 
//             prop.load(in);
//             Set keyValue = prop.keySet();
             Set keyValue = ps.keySet();
             for (Iterator it = keyValue.iterator(); it.hasNext();) {
                 String key = (String) it.next();
//                 mp.put(key,(String) prop.get(key));
                 mp.put(key,(String) ps.get(key));
             }
         } catch (Exception e) {
             log.error("IO读取出错，找不到cas.properties!");
         }
         
         if (log.isDebugEnabled()) {
             log.debug("getCasProperties [OK]");
         }
         
    	return mp;
    }
    
    

    
    
    
    private static void putSysParam2Config(Map config, SysParam sysParam,LookupManager mgr){
    	
   	     List ls = new ArrayList();
    	
    	 String orderViewModelParam = sysParam.getOrderViewModelParam();
    	 mgr.saveSysParams(Constants.ORDER_VIEW_MODEL_PARAM,orderViewModelParam,ls);
    	 config.put(Constants.ORDER_VIEW_MODEL_PARAM, orderViewModelParam);
    	 
    	 String contractSortParam = sysParam.getContractSortParam();
    	 mgr.saveSysParams(Constants.CONTRACT_SORT_PARAM,contractSortParam,ls);
    	 config.put(Constants.CONTRACT_SORT_PARAM, contractSortParam);
    	 
    	 String channelModelParam = sysParam.getChannelModelParam();
    	 mgr.saveSysParams(Constants.CHANNEL_MODEL_PARAM,channelModelParam,ls);
    	 config.put(Constants.CHANNEL_MODEL_PARAM, channelModelParam);
    	 
    	 String piblishModelParam = sysParam.getPiblishModelParam();
    	 mgr.saveSysParams(Constants.PUBLISH_MODEL_PARAM,piblishModelParam,ls);
    	 config.put(Constants.PUBLISH_MODEL_PARAM, piblishModelParam);
    	 
    	 String piblishExportModelParam = sysParam.getPiblishExportModelParam();
    	 mgr.saveSysParams(Constants.PUBLISH_EXPORT_MODEL_PARAM,piblishExportModelParam,ls);
    	 config.put(Constants.PUBLISH_EXPORT_MODEL_PARAM, piblishExportModelParam);
    	 
    	 String adverCodeModelParam = sysParam.getAdverCodeModelParam();
    	 mgr.saveSysParams(Constants.ADVER_CODE_MODEL_PARAM,adverCodeModelParam,ls);
    	 config.put(Constants.ADVER_CODE_MODEL_PARAM, adverCodeModelParam);
    	 
    	 String orderCodeModelParam = sysParam.getOrderCodeModelParam();
    	 mgr.saveSysParams(Constants.ORDER_CODE_MODEL_PARAM,orderCodeModelParam,ls);
    	 config.put(Constants.ORDER_CODE_MODEL_PARAM, orderCodeModelParam);
    	 
    	 String theme = sysParam.getTheme();
    	 mgr.saveSysParams(Constants.CSS_THEME,theme,ls);
    	 config.put(Constants.CSS_THEME, theme);
    	 
    	 String orderCarrierTypeDisplayParam = sysParam.getOrderCarrierTypeDisplayParam();
    	 mgr.saveSysParams(Constants.ORDER_CARRIER_TYPE_DISPLAY_PARAM,orderCarrierTypeDisplayParam,ls);
    	 config.put(Constants.ORDER_CARRIER_TYPE_DISPLAY_PARAM,  orderCarrierTypeDisplayParam);
    	 
    	 String resourceDisplayParam = sysParam.getResourceDisplayParam();
    	 mgr.saveSysParams(Constants.RESOURCE_DISPLAY_PARAM,resourceDisplayParam,ls);
    	 config.put(Constants.RESOURCE_DISPLAY_PARAM,  resourceDisplayParam);
    	 
    	 String customerOwnerParam = sysParam.getCustomerOwnerParam();
    	 mgr.saveSysParams(Constants.CUSTOMER_OWNER_PARAM,customerOwnerParam,ls);
    	 config.put(Constants.CUSTOMER_OWNER_PARAM,  customerOwnerParam);
    	 
//    	 String customerCarrierParam = sysParam.getCustomerCarrierParam();
//    	 mgr.saveSysParams(Constants.CUSTOMER_CARRIER_PARAM,customerCarrierParam,ls);
//    	 config.put(Constants.CUSTOMER_CARRIER_PARAM,  customerCarrierParam);
    	 
    	 String orderContractParam = sysParam.getOrderContractParam();
    	 mgr.saveSysParams(Constants.ORDER_CONTRACT_PARAM,orderContractParam,ls);
    	 config.put(Constants.ORDER_CONTRACT_PARAM, orderContractParam);
    	 
    	 String carrierNodeLevelParam = sysParam.getCarrierNodeLevelParam();
    	 mgr.saveSysParams(Constants.CARRIER_NODELEVEL_PARAM,carrierNodeLevelParam,ls);
    	 config.put(Constants.CARRIER_NODELEVEL_PARAM,carrierNodeLevelParam);
    	 
    	 String dianpianParam = sysParam.getDianpianParam();
    	 mgr.saveSysParams(Constants.DIAN_PIAN_PARAM,dianpianParam,ls);
    	 config.put(Constants.DIAN_PIAN_PARAM,dianpianParam);
    	 
    	 String stridePositionParam = sysParam.getStridePositionParam();
    	 mgr.saveSysParams(Constants.STRIDE_POSITION_PARAM,stridePositionParam,ls);
    	 config.put(Constants.STRIDE_POSITION_PARAM,stridePositionParam);
    	 
    	 String addCustomerInOrderParam = sysParam.getAddCustomerInOrderParam();
    	 mgr.saveSysParams(Constants.ADD_CUSTOMER_IN_ORDER_PARAM,addCustomerInOrderParam,ls);
    	 config.put(Constants.ADD_CUSTOMER_IN_ORDER_PARAM,addCustomerInOrderParam);
    	 
    	 String specArowMoveParam = sysParam.getSpecArowMoveParam();
    	 mgr.saveSysParams(Constants.SPEC_AROWMOVE_PARAM,specArowMoveParam,ls);
    	 config.put(Constants.SPEC_AROWMOVE_PARAM,specArowMoveParam);
    	 
    	 String channelPullParam = sysParam.getChannelPullParam();
    	 mgr.saveSysParams(Constants.CHANNEL_PULL_PARAM,channelPullParam,ls);
    	 config.put(Constants.CHANNEL_PULL_PARAM,channelPullParam);
    	 
    	 String isDisplayNoadResParam = sysParam.getIsDisplayNoadResParam();
    	 mgr.saveSysParams(Constants.IS_DISPLAYNOADRES_PARAM,isDisplayNoadResParam,ls);
    	 config.put(Constants.IS_DISPLAYNOADRES_PARAM,isDisplayNoadResParam);
    	 
    	 String moreChannelParam = sysParam.getMoreChannelParam();
    	 mgr.saveSysParams(Constants.MORE_CHANNEL_PARAM,moreChannelParam,ls);
    	 config.put(Constants.MORE_CHANNEL_PARAM,moreChannelParam);
    	 
    	 String moreChannelNoPullParam = sysParam.getMoreChannelNoPullParam();
    	 mgr.saveSysParams(Constants.MORE_CHANNEL_NOPULL_PARAM,moreChannelNoPullParam,ls);
    	 config.put(Constants.MORE_CHANNEL_NOPULL_PARAM,moreChannelNoPullParam);
    	 
    	 
    	 String resourceReLimitParam = sysParam.getResourceReLimitParam();
    	 mgr.saveSysParams(Constants.RESOURCE_RELIMIT_PARAM,resourceReLimitParam,ls);
    	 config.put(Constants.RESOURCE_RELIMIT_PARAM,resourceReLimitParam);
    	 
    	 String permitModAdverParam = sysParam.getPermitModAdverParam();
    	 mgr.saveSysParams(Constants.PERMIT_MOD_ADVER_PARAM,permitModAdverParam,ls);
    	 config.put(Constants.PERMIT_MOD_ADVER_PARAM,permitModAdverParam);
    	 
    	 String orderModCategoryParam = sysParam.getOrderModCategoryParam();
    	 mgr.saveSysParams(Constants.ORDER_MOD_CATEGORY_PARAM,orderModCategoryParam,ls);
    	 config.put(Constants.ORDER_MOD_CATEGORY_PARAM,orderModCategoryParam);
    	 
    	 String isOpenOrderOrgParam = sysParam.getIsOpenOrderOrgParam();
    	 mgr.saveSysParams(Constants.IS_OPEN_ORDER_ORG_PARAM,isOpenOrderOrgParam,ls);
    	 config.put(Constants.IS_OPEN_ORDER_ORG_PARAM,isOpenOrderOrgParam);
    	 
    	 String isDisplayChartParam = sysParam.getIsDisplayChartParam();
    	 mgr.saveSysParams(Constants.IS_DISPLAY_CHART_PARAM,isDisplayChartParam,ls);
    	 config.put(Constants.IS_DISPLAY_CHART_PARAM,isDisplayChartParam);
    	 
    	 String isUserCustomerRelParam = sysParam.getIsUserCustomerRelParam();
    	 mgr.saveSysParams(Constants.IS_USER_CUSTOMER_REL_PARAM,isUserCustomerRelParam,ls);
    	 config.put(Constants.IS_USER_CUSTOMER_REL_PARAM,isUserCustomerRelParam);
    	 
    	 String arrearageMode = sysParam.getArrearageMode();
    	 mgr.saveSysParams(Constants.ARREARAGE_MODE,arrearageMode,ls);
    	 config.put(Constants.ARREARAGE_MODE,arrearageMode);
    	 
    	 String isArrangeOrderOrEntry = sysParam.getIsArrangeOrderOrEntry();
    	 mgr.saveSysParams(Constants.IS_ARRANGE_ORDER_OR_ENTRY,isArrangeOrderOrEntry,ls);
    	 config.put(Constants.IS_ARRANGE_ORDER_OR_ENTRY,isArrangeOrderOrEntry);
    	 
    	 String fztvSpecialParam = sysParam.getFztvSpecialParam();
    	 mgr.saveSysParams(Constants.FZTV_SPECIAL_PARAM,fztvSpecialParam,ls);
    	 config.put(Constants.FZTV_SPECIAL_PARAM,fztvSpecialParam);
    	 
    	 String qztvSpecialParam = sysParam.getQztvSpecialParam();
    	 mgr.saveSysParams(Constants.QZTV_SPECIAL_PARAM,qztvSpecialParam,ls);
    	 config.put(Constants.QZTV_SPECIAL_PARAM,qztvSpecialParam);
    	 
    	 
    	 String signCompages = sysParam.getSignCompages();
    	 mgr.saveSysParams(Constants.SIGN_COMPAGES_PARAM,signCompages,ls);
    	 config.put(Constants.SIGN_COMPAGES_PARAM,signCompages);
    	 
    	 String withBroPoint = sysParam.getWithBroPoint();
    	 mgr.saveSysParams(Constants.WITH_BROPROINT_PARAM,withBroPoint,ls);
    	 config.put(Constants.WITH_BROPROINT_PARAM,withBroPoint);
    	 
    	 String tvNameParam = sysParam.getTvNameParam();
    	 mgr.saveSysParams(Constants.TV_NAME_PARAM,tvNameParam,ls);
    	 config.put(Constants.TV_NAME_PARAM,tvNameParam);
    	 
    	 
    	 String withoutSubmit = sysParam.getWithoutSubmit();
    	 mgr.saveSysParams(Constants.WITHOUT_SUBMIT,withoutSubmit,ls);
    	 config.put(Constants.WITHOUT_SUBMIT,withoutSubmit);
    	 
    	 String withResourceSort = sysParam.getWithResourceSort();
    	 mgr.saveSysParams(Constants.WITH_RESOURCE_SORT_PARAM,withResourceSort,ls);
    	 config.put(Constants.WITH_RESOURCE_SORT_PARAM,withResourceSort);
    	 
    	 
    	 String incomeMessageAlertParam = sysParam.getIncomeMessageAlertParam();
    	 mgr.saveSysParams(Constants.INCOME_MESSAGE_ALERT_PARAM,incomeMessageAlertParam,ls);
    	 String value = "0";
    	 if(incomeMessageAlertParam.length()>1){
    		 value = incomeMessageAlertParam.split(",")[0];
    	 }else{
    		 value = incomeMessageAlertParam;
    	 }
    	 config.put(Constants.INCOME_MESSAGE_ALERT_PARAM,value);
    	 
    	 
    	 String sequenceIncomeAutoParam = sysParam.getSequenceIncomeAutoParam();
    	 mgr.saveSysParams(Constants.INCOME_CODE_MODEL_PARAM,sequenceIncomeAutoParam,ls);
    	 config.put(Constants.INCOME_CODE_MODEL_PARAM,sequenceIncomeAutoParam);
    	 
    	 String isSignUserBalance = sysParam.getIsSignUserBalance();
    	 mgr.saveSysParams(Constants.IS_SIGN_USER_BALANCE,isSignUserBalance,ls);
    	 config.put(Constants.IS_SIGN_USER_BALANCE,isSignUserBalance);
    	 
    	 
    	 String isUserOrderYearRel = sysParam.getIsUserOrderYearRel();
    	 mgr.saveSysParams(Constants.IS_USER_ORDER_YEAR_REL,isUserOrderYearRel,ls);
    	 config.put(Constants.IS_USER_ORDER_YEAR_REL,isUserOrderYearRel);
    	 
    	 
    	 String isUseCarrierProty = sysParam.getIsUseCarrierProty();
    	 mgr.saveSysParams(Constants.IS_USE_CARRIER_PROTY,isUseCarrierProty,ls);
    	 config.put(Constants.IS_USE_CARRIER_PROTY,isUseCarrierProty);
    	 
    	 String publishOrderAlertStates = sysParam.getPublishOrderAlertStates();
    	 mgr.saveSysParams(Constants.PUBLISH_ORDER_ALERT_STATES,publishOrderAlertStates,ls);
    	 config.put(Constants.PUBLISH_ORDER_ALERT_STATES,publishOrderAlertStates);
    	 
    	 String isDisplayStandPrice = sysParam.getIsDisplayStandPrice();
    	 mgr.saveSysParams(Constants.IS_DISPLAY_STANDPRICE,isDisplayStandPrice,ls);
    	 config.put(Constants.IS_DISPLAY_STANDPRICE,isDisplayStandPrice);
    	 
    	 
    	 String orderCarrierLevelParam = sysParam.getOrderCarrierLevelParam();
    	 mgr.saveSysParams(Constants.ORDER_CARRIER_LEVEL_PARAM,orderCarrierLevelParam,ls);
    	 config.put(Constants.ORDER_CARRIER_LEVEL_PARAM,orderCarrierLevelParam);
    	 
    	 String orderDetailDisplayParam = sysParam.getOrderDetailDisplayParam();
    	 mgr.saveSysParams(Constants.ORDER_DETAIL_DISPLAY_PARAM,orderDetailDisplayParam,ls);
    	 config.put(Constants.ORDER_DETAIL_DISPLAY_PARAM,orderDetailDisplayParam);

    	 
    	 String useCarrierAliname = sysParam.getUseCarrierAliname();
    	 mgr.saveSysParams(Constants.USE_CARRIER_ALINAME_PARAM,useCarrierAliname,ls);
    	 config.put(Constants.USE_CARRIER_ALINAME_PARAM,useCarrierAliname);
    	 
    	 
    	 
    	 
    	 //判断是否启用多种类型的载体，如电视、广播等等，默认0
    	 String useMoreCarrierSortParam = sysParam.getUseMoreCarrierSortParam();
    	 mgr.saveSysParams(Constants.USE_MORE_CARRIER_SORT_PARAM,useMoreCarrierSortParam,ls);
    	 config.put(Constants.USE_MORE_CARRIER_SORT_PARAM,useMoreCarrierSortParam);
    	 
    	 
    	 //是否启用客户类别过滤,默认0
    	 String customerCateFiter = sysParam.getCustomerCateFiter();
    	 mgr.saveSysParams(Constants.CUSTOMER_CATE_FITER_PARAM,customerCateFiter,ls);
    	 config.put(Constants.CUSTOMER_CATE_FITER_PARAM,customerCateFiter);  	 
    	 
    	 //行业级别 
    	 String industryLevelParam = sysParam.getIndustryLevelParam();
    	 mgr.saveSysParams(Constants.INDUSTRY_LEVEL_PARAM,industryLevelParam,ls);
    	 config.put(Constants.INDUSTRY_LEVEL_PARAM,industryLevelParam); 
    	 
    	 //是否启用自动联系号
    	 String autoRelationCodeParam = sysParam.getIndustryLevelParam();
    	 mgr.saveSysParams(Constants.AUTO_RELATION_CODE_PARAM,autoRelationCodeParam,ls);
    	 config.put(Constants.AUTO_RELATION_CODE_PARAM,autoRelationCodeParam); 
    	 
    	 //默认价格类别
    	 String autoPriceTypeParam = sysParam.getAutoPriceTypeParam();
    	 mgr.saveSysParams(Constants.AUTO_PRICE_TYPE_PARAM,autoPriceTypeParam,ls);
    	 config.put(Constants.AUTO_PRICE_TYPE_PARAM,autoPriceTypeParam); 
    	 
    	 //是否栏目独立
    	 String useLanmuSingleParam = sysParam.getUseLanmuSingleParam();
    	 mgr.saveSysParams(Constants.USE_LANMU_SINGLE,useLanmuSingleParam,ls);
    	 config.put(Constants.USE_LANMU_SINGLE,useLanmuSingleParam);  
    	 
    	 //审核后的订单是否允许编辑
    	 String allowModiyPassedOrderParam = sysParam.getAllowModiyPassedOrderParam();
    	 mgr.saveSysParams(Constants.ALLOW_MODIY_PASSED_ORDER,allowModiyPassedOrderParam,ls);
    	 config.put(Constants.ALLOW_MODIY_PASSED_ORDER,allowModiyPassedOrderParam);  
    	 
       	 //广告发布合同模板类型 默认 0 最后每页有落款，1 只有最后一页有落款
    	 String orderPublishTempleParam = sysParam.getOrderPublishTempleParam();
    	 mgr.saveSysParams(Constants.ORDER_PUBLISH_TEMPLE_PARAM,orderPublishTempleParam,ls);
    	 config.put(Constants.ORDER_PUBLISH_TEMPLE_PARAM,orderPublishTempleParam);  
    	 
    	 //是否显示关联编号，0不显示，1显示，默认0
    	 String orderDisplayRelcodeParam = sysParam.getOrderDisplayRelcodeParam();
    	 mgr.saveSysParams(Constants.ORDER_DISPLAY_RELATIONCEODE_PARAM,orderDisplayRelcodeParam,ls);
    	 config.put(Constants.ORDER_DISPLAY_RELATIONCEODE_PARAM,orderDisplayRelcodeParam);     	 
 
    	 //是否开启订单类别过滤 
    	 String financialAuditParam = sysParam.getFinancialAuditParam();
    	 System.out.println("financialAuditParam>>>>>>>>>>>>>>>>>>>>>>>>>>是否开启订单类别过滤>8888888888888 v >>>>>>>>>>>>>>>>"+ financialAuditParam) ;
    	 mgr.saveSysParams(Constants.FINANCIA_AUDIT_PARAM,financialAuditParam,ls);
    	 config.put(Constants.FINANCIA_AUDIT_PARAM,financialAuditParam);   
    	  
    	 //是否显示分配金额，0不显示，1显示，默认0
    	 String orderDisplayIncomeParam = sysParam.getOrderDisplayIncomeParam();
    	 mgr.saveSysParams(Constants.ORDER_DISPLAY_INCOME_PARAM,orderDisplayIncomeParam,ls);
    	 config.put(Constants.ORDER_DISPLAY_INCOME_PARAM,orderDisplayIncomeParam); 
    	 
    	 //一个集团下多个分支机构，但广告资源共享，0不显示，1显示，默认0
    	 String oneOrgMoreSuborgsParam = sysParam.getOneOrgMoreSuborgsParam();
    	 mgr.saveSysParams(Constants.ONE_ORG_MORE_SUBORGS_PARAM,oneOrgMoreSuborgsParam,ls);
    	 config.put(Constants.ONE_ORG_MORE_SUBORGS_PARAM,oneOrgMoreSuborgsParam);    	 
    	 
    	 //财务平帐方式，0不显示，1显示，默认0
    	 String financeBalanceModelParam = sysParam.getFinanceBalanceModelParam();
    	 mgr.saveSysParams(Constants.FINANCE_BALANCE_MODEL_PARAM,financeBalanceModelParam,ls);
    	 config.put(Constants.FINANCE_BALANCE_MODEL_PARAM,financeBalanceModelParam);    	 
    	 
    	 //是否启用快速下订单
    	 String fastSignOrderParam = sysParam.getFastSignOrderParam();
    	 mgr.saveSysParams(Constants.FAST_SIGN_ORDER_PARAM,fastSignOrderParam,ls);
    	 config.put(Constants.FAST_SIGN_ORDER_PARAM,fastSignOrderParam);  
    	 
    	 //是否启用快速下订单
    	 String orderCalculateModel = sysParam.getOrderCalculateModel();
    	 mgr.saveSysParams(Constants.ORDER_CALCULATE_MODEL_PARAM,orderCalculateModel,ls);
    	 config.put(Constants.ORDER_CALCULATE_MODEL_PARAM,orderCalculateModel);  
    	 

    	 
    	 //是否启用大洋的备播系统对接 0 否  1 是
    	 String dayangBeiboEnableParam = sysParam.getDayangBeiboEnableParam();
    	 mgr.saveSysParams(Constants.DAYANG_BEIBO_ENADBLE_PARAM,dayangBeiboEnableParam,ls);
    	 config.put(Constants.DAYANG_BEIBO_ENADBLE_PARAM,dayangBeiboEnableParam);  	 
    	 
    	 String dayangWebServiceUrlMatterParam = sysParam.getDayangWebServiceUrlMatterParam();
    	 mgr.saveSysParams(Constants.DAYANG_WEBSERVER_URL_MATTER,dayangWebServiceUrlMatterParam,ls);
    	 config.put(Constants.DAYANG_WEBSERVER_URL_MATTER,dayangWebServiceUrlMatterParam);  	 	 
    	 
    	 String dayangWebServiceUrlProLitstParam = sysParam.getDayangWebServiceUrlProLitstParam();
    	 mgr.saveSysParams(Constants.DAYANG_WEBSERVER_URL_PROGRAM_LIST,dayangWebServiceUrlProLitstParam,ls);
    	 config.put(Constants.DAYANG_WEBSERVER_URL_PROGRAM_LIST,dayangWebServiceUrlProLitstParam);  
    
    	 // 系统启用的年份 
    	 String adrmSysYearProgramList = sysParam.getAdrmSysYearProgramList();
//    	 adrmSysYearProgramList = adrmSysYearProgramList ==null|| "".equals(adrmSysYearProgramList)|| "0".equals(adrmSysYearProgramList)?"2006,2007,2008,2009,2010,2011,2012,2013,2014":adrmSysYearProgramList;
//    	 System.out.println("adrmSysYearProgramList  ****************8 999999999999  777777777777      >>>>>>>>>>>>>>>>>>" +adrmSysYearProgramList);
    	 mgr.saveSysParams(Constants.ADRM_SYS_YEAR_PROGRAM_LIST,adrmSysYearProgramList,ls);
    	 config.put(Constants.ADRM_SYS_YEAR_PROGRAM_LIST,adrmSysYearProgramList);  
    	 
    
    	 // 订单刊例价格是否可以修改 
    	 String orderBasePriceEnableModyParam = sysParam.getOrderBasePriceEnableModyParam();
    	 mgr.saveSysParams(Constants.ORDER_BASE_PRICE_ENABLE_MODY_PARAM,orderBasePriceEnableModyParam,ls);
    	 config.put(Constants.ORDER_BASE_PRICE_ENABLE_MODY_PARAM,orderBasePriceEnableModyParam);  
    	 
    	 
    	 // 广告编排是否显示品牌
    	 String arrangeWithBrandParam = sysParam.getArrangeWithBrandParam();
    	 mgr.saveSysParams(Constants.ARRANGE_WITH_BRAND_PARAM,arrangeWithBrandParam,ls);
    	 config.put(Constants.ARRANGE_WITH_BRAND_PARAM,arrangeWithBrandParam);  
    	 
    	 
    	 
    	 // 新签订单广告排期默认月份,默认当前月份+2
    	 String orderArrangDefaultMonths = sysParam.getOrderArrangDefaultMonths();
    	 mgr.saveSysParams(Constants.ORDER_ARRANG_DEFAULT_MONTHS,orderArrangDefaultMonths,ls);
    	 config.put(Constants.ORDER_ARRANG_DEFAULT_MONTHS,orderArrangDefaultMonths);  
    	 
    	 
     	
 	    // 出串联单限制排期的修改
    	 String outLimitBroarrang = sysParam.getOutLimitBroarrang();
      	 mgr.saveSysParams(Constants.OUT_LIMIT_BROARRANG,outLimitBroarrang,ls);
         Constants.APPLACTION_MAP.put(Constants.OUT_LIMIT_BROARRANG,outLimitBroarrang);
         
     	
         // 使用客户广告投放的时间比率
         String resourceUseCustomerCatelog = sysParam.getResourceUseCustomerCatelog();
    	 mgr.saveSysParams(Constants.RESOURCE_USE_CUSTOMER_CATELOG,resourceUseCustomerCatelog,ls);
         Constants.APPLACTION_MAP.put(Constants.RESOURCE_USE_CUSTOMER_CATELOG,resourceUseCustomerCatelog);
         
         
         //公益广告自动添加
         String publicAdAutoFill = sysParam.getPublicAdAutoFill();
    	 mgr.saveSysParams(Constants.PUBLIC_AD_AUTO_FILL,publicAdAutoFill,ls);
         Constants.APPLACTION_MAP.put(Constants.PUBLIC_AD_AUTO_FILL,publicAdAutoFill);
         
         // ftp服务器 把字符串组成map  "ip:172.16.1.249,port:21,user:new,pass:123456"
         String ftpConfig = sysParam.getFtpConfig();
    	 mgr.saveSysParams(Constants.FTP_SERVVICE_CONFIG,ftpConfig,ls);
         Constants.APPLACTION_MAP.put(Constants.FTP_SERVVICE_CONFIG,StringUtil.string2Map(ftpConfig));
         
         
         
         //时段维护根据时间排序
         String resconfigOrderbyTime = sysParam.getResconfigOrderbyTime();
    	 mgr.saveSysParams(Constants.RESCONFIG_ORDER_BY_TIME,resconfigOrderbyTime,ls);
         Constants.APPLACTION_MAP.put(Constants.RESCONFIG_ORDER_BY_TIME,resconfigOrderbyTime);
         
         
         //时段维护根据时间排序
         String orderMoreCarrier = sysParam.getOrderMoreCarrier();
    	 mgr.saveSysParams(Constants.ORDER_MORE_CARRIER,orderMoreCarrier,ls);
         Constants.APPLACTION_MAP.put(Constants.ORDER_MORE_CARRIER,orderMoreCarrier);

  
//    	 log.info("orderDisplayIncomeParam>>>>>>>>>>>>>>>>>>"+orderCalculateModel);
    
         Constants.APPLACTION_MAP.remove(Constants.GLOBAL_SYS_PARAMS);
     	 Constants.APPLACTION_MAP.put(Constants.GLOBAL_SYS_PARAMS,mgr.getGlobalParamsMap(ls));
     	 
   
     	config.put(Constants.FILE_GRID_REPORT_DIR,Constants.FILE_GRID_REPORT_DIR);  
     	
     	
     	
     	
     	
   
     	
    	 
    	 
//     	String[] args=new String[{"-database.0","file:mydb","-dbname.0","xdb"}];  
//     	HSQLServer.start(args);  
    	 
//    	 log.info("publishOrderAlertStates>>>>>>>>>>>>>>>>>>"+publishOrderAlertStates);
   
    }
    
    
    
}
