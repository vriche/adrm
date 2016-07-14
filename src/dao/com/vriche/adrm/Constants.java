package com.vriche.adrm;

import java.util.HashMap;
import java.util.Map;



/**
 * Constant values used throughout the application.
 *
 * <p>
 * <a href="Constants.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
 

public class Constants {

    //~ Static fields/initializers =============================================
    public static final String SYSTEM_ADRM_VERSION = "2.0";
    
    /** The name of the ResourceBundle used in this application */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /** The encryption algorithm key to be used for passwords */
    public static final String ENC_ALGORITHM = "algorithm";

    /** A flag to indicate if passwords should be encrypted */
    public static final String ENCRYPT_PASSWORD = "encryptPassword";

    /** File separator from System properties */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /** User home from System properties */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

//    public static final String FILE_ADVERS_DIR ="download"+FILE_SEP +"advers";
    public static final String FILE_ADVERS_DIR ="advers";
    
    public static final String FILE_DBBACKUP_DIR ="dbback";
    
    public static final String SELET_CONPTCH ="selet_contpatch";
    
    public static final String FILE_GRID_REPORT_DIR ="grid_report";
    
    //系统SQL脚本存放路径
    public static final String FILE_PATH_SQL_SCRIPT ="com/vriche/adrm/dao/ibatis/script/";
    
    public static final String FILE_PATH_SQL_SCRIPT_MENUS = FILE_PATH_SQL_SCRIPT + "adrm-muens-default.xml";
    
    public static final String FILE_PATH_SQL_SCRIPT_PERMIT = FILE_PATH_SQL_SCRIPT + "adrm-permit-default.xml";
    
    public static final String DATABASE_BACKUP_PROPERTIES_FILE_NAME =  "databaseBackup.properties";
    public static final String LOG4J_APPENDER_LOGFILE_PROPERTIES_KEY =  "log4j.appender.logfile.File";
    												
    public static final String DAYANG_WEBSERVER_IMPORT_MATTER_URL =   "http://10.77.82.121:88/ADPINF/services/ImportMaterialService";
    public static final String DAYANG_WEBSERVER_IMPORT_MATTER_URL_TEST =   "http://10.77.82.91:8891/ADPINF/services/ImportMaterialService";
    public static final String DAYANG_WEBSERVER_IMPORT_PROLIST_URL =  "http://10.77.82.121:88/ADPINF/services/ImportProgramListService";
    public static final String DAYANG_WEBSERVER_IMPORT_PROLIST_URL_TEST =  "http://10.77.82.91:8892/ADPINF/services/ImportProgramListService";
    
    

    public static final  String[] SPECIF_DEST_BEFO = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
    public static final  String[] SPECIF_DEST_AFTER = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    
    public static final String APP_SYS_LOGO_FILE ="appSystemLogoFile";
    public static final String REPORTS_TEMPLE_PATH ="reportsTemplePath";
    public static final String REPORTS_TEMPLE_PATH2 ="reportsTemplePath2";
    public static final String FILE_PATH_SERVELT_CONTEXT_ROOT ="filePathServletContexRoot";
    public static final String FILE_PATH_APP_CONTEXT_ROOT ="filePathAppContexRoot";
    
    
    
    

	public static final String 	TRIGGERNAME = "triggerName";
	public static final String 	TRIGGERGROUP = "triggerGroup";
	public static final String STARTTIME = "startTime";
	public static final String ENDTIME = "endTime";
	public static final String REPEATCOUNT = "repeatCount";
	public static final String REPEATINTERVEL = "repeatInterval";
	
	
	public static final Map  quartzStatus = new HashMap();
	static{
		quartzStatus.put("ACQUIRED", "运行中");
		quartzStatus.put("PAUSED", "暂停中");
		quartzStatus.put("WAITING", "等待中");		
	}
	
	
	
	
	
  
    /*
     * 系统参数
    */
    /** The name of the configuration hashmap stored in application scope. */
    public static final String CONFIG = "appConfig";
    
    public static final String CSS_THEME = "theme";
    
    public static final String GLOBAL_CUSRUSER_ORGS = "globalUserLogs";
    
    public static final String GLOBAL_CUSRUSER_ORGS_OBJ = "globalUserLogsObj";
    
    public static final String GLOBAL_SYS_PARAM = "globalSysParam";
    //合同参数
    public static final String CONTRACT_SORT_PARAM = "contractSortParam";
    //订单浏览方式
    public static final  String ORDER_VIEW_MODEL_PARAM = "orderViewModelParam";
    //分频道管理
    public static final  String CHANNEL_MODEL_PARAM = "channelModelParam";
    //广告编排方式
    public static final  String PUBLISH_MODEL_PARAM = "piblishModelParam";   
    //串编接口类型
    public static final  String PUBLISH_EXPORT_MODEL_PARAM = "piblishExportModelParam";    
    //串编号生成方式
    public static final  String ADVER_CODE_MODEL_PARAM = "adverCodeModelParam";  
    //合同号生成方式  
    public static final  String ORDER_CODE_MODEL_PARAM = "orderCodeModelParam";
    
    //收入编号生成方式  
    public static final  String INCOME_CODE_MODEL_PARAM = "incomeCodeModelParam";
    //广告段位显示侧重控制
    public static final  String ORDER_CARRIER_TYPE_DISPLAY_PARAM = "orderCarrierTypeDisplayParam"; 
    
    //广告载体类别的显示控制
    public static final  String RESOURCE_DISPLAY_PARAM = "resourceDisplayParam"; 
    
    //  频道划账
    public static final  String  CHANNEL_PULL_PARAM = "channelPullParam"; 
    
    //客户归属方式
    public static final  String CUSTOMER_OWNER_PARAM = "customerOwnerParam"; 
    //客户载体归属方式
//    public static final  String CUSTOMER_CARRIER_PARAM = "customerCarrierParam"; 
    //订单协约
    public static final  String ORDER_CONTRACT_PARAM = "orderContractParam"; 
    //载体级别
    public static final  String CARRIER_NODELEVEL_PARAM = "carrierNodeLevelParam";
    //垫片类型
    public static final  String DIAN_PIAN_PARAM = "dianpianParam";
    //广告编排时是否允许跨段位调整
    public static final  String STRIDE_POSITION_PARAM = "stridePositionParam";
    //在订单中添加客户
    public static final  String ADD_CUSTOMER_IN_ORDER_PARAM = "addCustomerInOrderParam";
    
    //有指定也允许调整
    public static final  String SPEC_AROWMOVE_PARAM = "specArowMoveParam";
    
    //串编时是否显示没有广告的段位
    public static final  String IS_DISPLAYNOADRES_PARAM = "isDisplayNoadResParam";
    
    //多频道不划帐
    public static final  String MORE_CHANNEL_NOPULL_PARAM = "moreChannelNoPullParam";
    
    //是否多频道
    public static final String MORE_CHANNEL_PARAM = "moreChannelParam";
    
    //13令的时间限定
    public static final String RESOURCE_RELIMIT_PARAM = "resourceReLimitParam";
    
    //审后订单，允许修改广告素材，但不能修改长度
    public static final String PERMIT_MOD_ADVER_PARAM = "permitModAdverParam";
    
    //  新添订单时，订单类别的默认值
    public static final String ORDER_MOD_CATEGORY_PARAM = "orderModCategoryParam";
    
    // 是否开启订单日志
    public static final String IS_OPEN_ORDER_ORG_PARAM = "isOpenOrderOrgParam";
    
    //  是否显示图表按钮
    public static final String IS_DISPLAY_CHART_PARAM = "isDisplayChartParam";
    
    //  是否显示用户客户隶属关系
    public static final String IS_USER_CUSTOMER_REL_PARAM = "isUserCustomerRelParam";
    
    //  如何显示欠款统计方式
    public static final String ARREARAGE_MODE = "arrearageMode";
    
    //	如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
    public static final String IS_ARRANGE_ORDER_OR_ENTRY= "isArrangeOrderOrEntry";
    
//	福州电视台特殊功能参数(若是福州台则设置为1,其他设置为0);因为系统参数默认是0;
    public static final String FZTV_SPECIAL_PARAM= "fztvSpecialParam";
    
//  泉州电视台特殊功能参数(若是泉州台则设置为1,其他设置为0);因为系统参数默认是0;
    public static final String QZTV_SPECIAL_PARAM= "qztvSpecialParam";
    
    //是否启用套装参数(启用1,不启用0)系统参数默认是0;
    public static final String SIGN_COMPAGES_PARAM= "signCompages";
    
    //是否启用播出入点(启用1,不启用0)系统参数默认是0
    public static final String WITH_BROPROINT_PARAM= "withBroPoint";
    
    
    //是否启用广告资源分类(启用1,不启用0)系统参数默认是0
    public static final String WITH_RESOURCE_SORT_PARAM= "withResourceSort";
    
    
    //电视台特殊功能参数(若有指定特定电视台则设置为catv,sjztv,hntv,fztv,qztv,xmtv,其他设置为0);系统参数默认是0;
    public static final String TV_NAME_PARAM= "tvNameParam";   
    
    
    //订单不予提交，就能审核(需要提交(0),不提交(1))
    public static final String WITHOUT_SUBMIT= "withoutSubmit";

    
    
//  到款提示，相关的业务员(如果财务录入一笔到款或修改一别到款，则提示相关的业务员) 格式（1,192.168.1.100,5222,domain.com,longin,PWD）
    public static final String INCOME_MESSAGE_ALERT_PARAM= "incomeMessageAlertParam";
 //是否由业务员平帐(0-否 1-是)   
    public static final String IS_SIGN_USER_BALANCE= "isSignUserBalance";

    //订单是否启用年份归属(0-否 1-是)   
    public static final String IS_USER_ORDER_YEAR_REL= "isUserOrderYearRel";
    
    
    //是否试用频道属性(0-否 1-是) 如 地面频道、卫星频道的分类方法  
    public static final String IS_USE_CARRIER_PROTY = "isUseCarrierProty";
    
    //建立串联单前，需要提示的订单状态、默认1(1未审批、2审核中、3通过、4被退回、5未通过)
    public static final String PUBLISH_ORDER_ALERT_STATES = "publishOrderAlertStates";
     
    
    //统计中是否显示刊例金额列
    public static final String IS_DISPLAY_STANDPRICE = "isDisplayStandPrice";  
    
    
    //订单中载体级别(默认0是维护时默认的级别数；1为表示只取一级)
    public static final String ORDER_CARRIER_LEVEL_PARAM = "orderCarrierLevelParam";  
    
    
    //订单中订单明细显示分页或不分页(默认0默认分页；1为表示不分)
    public static final String ORDER_DETAIL_DISPLAY_PARAM = "orderDetailDisplayParam";  
    

    //统计分析中是否启用频道别名
    public static final String USE_CARRIER_ALINAME_PARAM = "useCarrierAliname";  
    
    //判断是否启用多种类型的载体，如电视、广播等等，默认0
    public static final String USE_MORE_CARRIER_SORT_PARAM = "useMoreCarrierSortParam";  
    
    
    //是否启用客户类别过滤
    public static final String CUSTOMER_CATE_FITER_PARAM = "customerCateFiter";      
    
    
    
    //全局系统参数
    public static final String GLOBAL_SYS_PARAMS = "_globalSysParams";    
    
    //审计过滤开关
    public static final String FINANCIAL_AUDIT_SWITCH= "financialAuditSwitch";        
    //过滤订单类别
    public static final String FITTER_ORDER_SUBCATES= "fitterOrderSubCates";   
    
    public static final String FITTER_ORDER_SUBCATES_WITHOUT= "fitterOrderSubCatesWithout";  
    //过滤到款用途
    public static final String FITTER_INCOME_POURS= "fitterIncomePours";  
    
    public static final String FITTER_INCOME_POURS_WITHOUT= "fitterIncomePoursWithout";  
    
    
 // 新签订单广告排期默认月份,默认当前月份+2
    public static final String  ORDER_ARRANG_DEFAULT_MONTHS= "orderArrangDefaultMonths";   
    

    // 出串联单限制排期的修改
    public static final String  OUT_LIMIT_BROARRANG= "outLimitBroarrang";   
    
    // 使用客户广告投放的时间比率
    public static final String  RESOURCE_USE_CUSTOMER_CATELOG= "resourceUseCustomerCatelog";   
    
    
    // 时间使用比率表
    public static final String  RESOURCE_USE_RATE_TABLE= "resourceUseRateTable";   
    
    
    /*
     * 编号规则 根据名称查找下一编号
    */   
    //合同编号
    public static final String SEQUENCE_TB_CONTRACT = "sequence_tb_contract";
    //订单编号
    public static final String SEQUENCE_TB_ORDER = "sequence_tb_order";
    //采购订单编号
    public static final String SEQUENCE_TB_PRO_ORDER_C = "sequence_tb_pro_order_c";
    //销售订单编号
    public static final String SEQUENCE_TB_PRO_ORDER_X = "sequence_tb_pro_order_x";
    //磁带编号
    public static final String SEQUENCE_TB_ADVER_MATTER = "sequence_tb_adver_matter";
    //进款编号
    public static final String SEQUENCE_TB_INCOME = "sequence_tb_income";
    //关联编号
    public static final String SEQUENCE_TB_ORDER_RELATION = "sequence_tb_order_relation";

    /** 
     * Session scope attribute that holds the locale set by the user. By setting this key
     * to the same one that Struts uses, we get synchronization in Struts w/o having
     * to do extra work or have two session-level variables.
     */ 
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts.action.LOCALE";
    
    /**
     * The request scope attribute under which an editable user form is stored
     */
    public static final String USER_KEY = "userForm";

    /**
     * The request scope attribute that holds the user list
     */
    public static final String USER_LIST = "userList";

    /**
     * The request scope attribute for indicating a newly-registered user
     */
    public static final String REGISTERED = "registered";

    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "admin";
 
    /**
     * The name of the User role, as specified in web.xml
     */
    public static final String USER_ROLE = "user";

    /**
     * The name of the user's role list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String USER_ROLES = "userRoles";


    
    
    /**  
     * The name of the available roles list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles";
    
    public static final String AVAILABLE_BRANCHS = "availableBranchs";
    
    public static final String LOGO_ORG_NAME = "LOGO_ORG_NAME";
    public static final String SOFT_VERSION = "SOFT_VERSION";

	
    
    public static final String AVAILABLE_ORG = "availableOrg";
    
    public static final String AVAILABLE_USER_RELS = "availableUserRels";
    public static final String AVAILABLE_USER_RELS_ID = "availableUserRelsId";
    
    public static final String AVAILABLE_CUSTOMER_USER_RELS = "availableCustomerUserRels";
    
    /////////////////////////////////////////////////////
    public static final String AVAILABLE_CARRIER = "availableCarrier";
    public static final String AVAILABLE_CARRIER_ALL = "availableCarrierAll";
    public static final String AVAILABLE_CARRIER_ALL_MAP = "availableCarrierAllMap";
    
    public static final String AVAILABLE_CARRIER_CHILD = "availableCarrierChild";
    public static final String AVAILABLE_CARRIER_CHILD_NOMYSALFE = "availableCarrierChild";
//    public static final String AVAILABLE_MATTER_SAME_NAME = "availableMatterSameName";
    
    public static final String AVAILABLE_CARRIERTYPE = "availableCarrierType";
    public static final String AVAILABLE_INDUSTRY = "availableIndustry";
    public static final String AVAILABLE_INDUSTRY_Map = "availableIndustryMap";
    public static final String AVAILABLE_SOECUFUC = "availableSpecific";
    public static final String AVAILABLE_SOECUFUC_MAP = "availableSpecificMap";
    public static final String AVAILABLE_USERS = "availableUsers";
    public static final String AVAILABLE_USERS_MAP = "availableUsersMap";
    public static final String AVAILABLE_USERS_MAP_USERNAME = "availableUsersMapUserName";
    public static final String AVAILABLE_USERS_MAP_RIGTHS = "availableUsersRigthsMapUserName";
    
    public static final String AVAILABLE_RESOURCE_MAP = "availableResourceMap";
    public static final String AVAILABLE_ORDER_CATELOG_MAP = "availableOrderCatelogMap";
    public static final String AVAILABLE_ORDER_CATELOGPARENT_MAP = "availableOrderCatelogParentMap";
    public static final String AVAILABLE_PRICETYPE = "availablePriceType";
    public static final String AVAILABLE_RESOURCESORT = "availableResourceSort";
    public static final String AVAILABLE_RESOURCENAME_MAP = "availableResourcenameMap";
    public static final String AVAILABLE_RESOURCENAME_YEAR_TYPE_MAP = "availableResourceYearTypeMap";
    
    public static final String AVAILABLE_PRICE_LENGTH_DETAIL = "availablePriceLengthDetail";
    public static final String AVAILABLE_BRANCHMAP_BYID = "availableBanchMapById";
    public static final String AVAILABLE_ORDERLIST_CATELOG_MAP = "availableOrderListCatelogMap";
    public static final String AVAILABLE_ORDER_CATELOGNAME_MAP = "availableOrderCatelogNameMap";
    public static final String AVAILABLE_CHECK_STATE = "availableCheckState";
    public static final String AVAILABLE_MATTER_LENGHT = "availableMatterLength";
    public static final String AVAILABLE_CARRIER_TYPES = "availableCarrierTypes";
    public static final String AVAILABLE_CARRIER_TYPES_MAP = "availableCarrierTypesMap";
    
    
    public static final String AVAILABLE_CARRIERS_BY_CARRIER_TYPE = "availableCarriersByCarrierType";
    public static final String AVAILABLE_USER_CARRIER_RELS = "availableUserCarrierRels";
    public static final String AVAILABLE_USER_CARRIER_RELS_ID = "availableUserCarrierRelsId";
    
//    public static final String AVAILABLE_USER_CUT_TYPE_RELS_OBJ = "availableUserCusterTypeRelsObj";
    public static final String AVAILABLE_USER_CUT_TYPE_RELS_ID = "availableUserCusterTypeRelsId";
    
    public static final String AVAILABLE_USER_CUT_TYPE_RELS_OBJ = "availableUserCusterTypeRelsObj";
    
    
    public static final String AVAILABLE_INCOME_MODE = "availableIncomeMode";
    public static final String AVAILABLE_INCOME_PURPOSE = "availableIncomePurpose";
    public static final String AVAILABLE_CUSTOMER_TYPE = "availableCustomerType";
    public static final String AVAILABLE_CUSTOMER_TYPE_MAP = "availableCustomerTypeMap";
    public static final String AVAILABLE_CHECK_USER_REL = "availableCheckUserRel";
    
    public static final String AVAILABLE_CAS_PROPERTIES = "availableCasproPerties";
    
    
    public static final String AVAILABLE_CUSTOMER_WITH_CUT_REL = "availableCustomerWithCutRel";
    
    public static final String AVAILABLE_USER_ORDER_YEAR_REL = "availableUserOrderYearRel";
    
    public static final String AVAILABLE_CARRIER_ALISNAME_REL = "availableCarrierAlisnameRel";
    
    public static final String AVAILABLE_USER_CARRIER_SORT_MAP = "availableUserCarrSortMap";
    
    public static final String INDUSTRY_LEVEL_PARAM = "industryLevelParam";
   
//  是否启用自动联系号
    public static final String AUTO_RELATION_CODE_PARAM = "autoRelationCodeParam";
    
//  默认价格类别
    public static final String AUTO_PRICE_TYPE_PARAM = "autoPriceTypeParam";  
	 
	 //是否独立使用栏目
	 public static final String USE_LANMU_SINGLE = "useLanmuSingleParam";  
	 
	 
	 
	 //审核后的订单是否允许编辑
	 public static final String ALLOW_MODIY_PASSED_ORDER = "allowModiyPassedOrderParam";  
	 
	 
	 //广告发布合同模板类型 默认 0 最后每页有落款，1 只有最后一页有落款
	 public static final String ORDER_PUBLISH_TEMPLE_PARAM = "orderPublishTempleParam";  
	 
	 //是否显示关联编号，0不显示，1显示，默认0
	 public static final String ORDER_DISPLAY_RELATIONCEODE_PARAM = "orderDisplayRelcodeParam";  
	 
	 //是否开启订单类别过滤，true|56,22|88
	 public static final String FINANCIA_AUDIT_PARAM = "financialAuditParam";  
	
	 
	 //是否显示平帐信息，0不显示，1显示，默认0
	 public static final String ORDER_DISPLAY_INCOME_PARAM = "orderDisplayIncomeParam";  
	 
	 
	 //一个集团下多个分支机构，但广告资源共享，0不显示，1显示，默认0
	 public static final String ONE_ORG_MORE_SUBORGS_PARAM = "oneOrgMoreSuborgsParam";  
	 
	 //财务平帐方式，0不显示，1显示，默认0
	 public static final String FINANCE_BALANCE_MODEL_PARAM = "financeBalanceModelParam";   

	 //快速下单，0否，1是
	 public static final String FAST_SIGN_ORDER_PARAM = "fastSignOrderParam";    
	 
	 //订单应收计算模式，0 应收=折后价格*次数*折扣*（1+加收率）+补差 1 应收=销售价格*次数*折扣*（1+加收率）+补差
	 public static final String ORDER_CALCULATE_MODEL_PARAM = "orderCalculateModel";    
	 
	 
	 //是否启用大洋的备播系统对接 0 否  1 是
	 public static final String DAYANG_BEIBO_ENADBLE_PARAM = "dayangBeiboEnableParam";    
	 
	 //大洋的备播系统  webservice ImportMaterialService url  "http://10.77.82.91:8892/ADPINF/services/ImportMaterialService";
	 public static final String DAYANG_WEBSERVER_URL_MATTER = "dayangWebServiceUrlMatterParam";   
	 
	 //	大洋的备播系统  webservice ImportProgramListService url  "http://10.77.82.91:8892/ADPINF/services/ImportProgramListService";
	 public static final String DAYANG_WEBSERVER_URL_PROGRAM_LIST = "dayangWebServiceUrlProLitstParam";   
	 
	 //系统启用的年份
//	 public static final String ADRM_SYS_YEAR_PROGRAM_LIST = "2006,2007,2008,2009,2010,2011,2012,2013,2014";  
	 public static final String ADRM_SYS_YEAR_PROGRAM_LIST = "adrmSysYearProgramList";
	 
	 //订单刊例价格是否可以修改
	 public static final String ORDER_BASE_PRICE_ENABLE_MODY_PARAM = "orderBasePriceEnableModyParam";
	 
	 
	 //广告编排是否显示品牌
	 public static final String ARRANGE_WITH_BRAND_PARAM = "arrangeWithBrandParam"; 
	 
	 
	 //广告资源树缓存
	 public static final String AVAILABLE_CARRIER_RESOURCE_TREE = "available_carrier_resource_tree"; 
	 
	 //公益广告自动添加
	 public static final String PUBLIC_AD_AUTO_FILL = "public_ad_auto_fill"; 
	 
	 //ftp服务器 "ip:172.16.1.249,port:21,user:new,pass:123456"
	 public static final String FTP_SERVVICE_CONFIG = "ftp_service_config"; 
	 
	 //时段维护根据时间排序
	 public static final String RESCONFIG_ORDER_BY_TIME = "resconfigOrderbyTime"; 
	 
	 
	 //订单多频道
	 public static final String ORDER_MORE_CARRIER = "orderMoreCarrier"; 

//    public static final String AVAILABLE_CARRIER_ORG_MAP = "availableCarrierOrgMap";
   
    
    public static  Map APPLACTION_MAP = new HashMap();

    
    public static final String RESULT_SIZE = "resultSize";
    
    public static final String PAGE_GLOBAL_SIZE = "16";
    
    /**
     * Comment for <code>MENU_CONTENT_SESSION</code>
     */
    public static final String MENU_CONTENT_APPLICATION = "menuContent";
  

//    public static Map orderDetailPageMap = new HashMap();



//  *************************************************
//  订单
//*************************************************  



//ContractPayment-START
    /**
     * The request scope attribute that holds the contractPayment form.
     */
    public static final String CONTRACTPAYMENT_KEY = "contractPaymentForm";

    /**
     * The request scope attribute that holds the contractPayment list
     */
    public static final String CONTRACTPAYMENT_LIST = "contractPaymentList";
//ContractPayment-END

//Order-START
    /**
     * The request scope attribute that holds the order form.
     */
    public static final String ORDER_KEY = "orderForm";

    /**
     * The request scope attribute that holds the order list
     */
    public static final String ORDER_LIST = "orderList";
//Order-END

//OrderCategory-START
    /**
     * The request scope attribute that holds the orderCategory form.
     */
    public static final String ORDERCATEGORY_KEY = "orderCategoryForm";

    /**
     * The request scope attribute that holds the orderCategory list
     */
    public static final String ORDERCATEGORY_LIST = "orderCategoryList";
//OrderCategory-END

//OrderDayInfo-START
    /**
     * The request scope attribute that holds the orderDayInfo form.
     */
    public static final String ORDERDAYINFO_KEY = "orderDayInfoForm";

    /**
     * The request scope attribute that holds the orderDayInfo list
     */
    public static final String ORDERDAYINFO_LIST = "orderDayInfoList";
//OrderDayInfo-END

//OrderDetail-START
    /**
     * The request scope attribute that holds the orderDetail form.
     */
    public static final String ORDERDETAIL_KEY = "orderDetailForm";

    /**
     * The request scope attribute that holds the orderDetail list
     */
    public static final String ORDERDETAIL_LIST = "orderDetailList";
//OrderDetail-END

//OrderLog-START
    /**
     * The request scope attribute that holds the orderLog form.
     */
    public static final String ORDERLOG_KEY = "orderLogForm";

    /**
     * The request scope attribute that holds the orderLog list
     */
    public static final String ORDERLOG_LIST = "orderLogList";
//OrderLog-END

//Contract-START
    /**
     * The request scope attribute that holds the contract form.
     */
    public static final String CONTRACT_KEY = "contractForm";

    /**
     * The request scope attribute that holds the contract list
     */
    public static final String CONTRACT_LIST = "contractList";
//Contract-END
    
    
    
    
    
//  *************************************************
//  客户关系
//*************************************************     

//  Customer-START
      /**
       * The request scope attribute that holds the customer form.
       */
      public static final String CUSTOMER_KEY = "customerForm";

      /**
       * The request scope attribute that holds the customer list
       */
      public static final String CUSTOMER_LIST = "customerList";
//  Customer-END

//  Category-START
      /**
       * The request scope attribute that holds the category form.
       */
      public static final String CATEGORY_KEY = "categoryForm";

      /**
       * The request scope attribute that holds the category list
       */
      public static final String CATEGORY_LIST = "categoryList";
//  Category-END

//  Industry-START
      /**
       * The request scope attribute that holds the industry form.
       */
      public static final String INDUSTRY_KEY = "industryForm";

      /**
       * The request scope attribute that holds the industry list
       */
      public static final String INDUSTRY_LIST = "industryList";
//  Industry-END

//  AgentInfo-START
      /**
       * The request scope attribute that holds the agentInfo form.
       */
      public static final String AGENTINFO_KEY = "agentInfoForm";

      /**
       * The request scope attribute that holds the agentInfo list
       */
      public static final String AGENTINFO_LIST = "agentInfoList";
//  AgentInfo-END

//  LinkMan-START
      /**
       * The request scope attribute that holds the linkMan form.
       */
      public static final String LINKMAN_KEY = "linkManForm";

      /**
       * The request scope attribute that holds the linkMan list
       */
      public static final String LINKMAN_LIST = "linkManList";
//  LinkMan-END

//  LinkHisotry-START
      /**
       * The request scope attribute that holds the linkHisotry form.
       */
      public static final String LINKHISOTRY_KEY = "linkHisotryForm";

      /**
       * The request scope attribute that holds the linkHisotry list
       */
      public static final String LINKHISOTRY_LIST = "linkHisotryList";
//  LinkHisotry-END

//  FeedbackInfo-START
      /**
       * The request scope attribute that holds the feedbackInfo form.
       */
      public static final String FEEDBACKINFO_KEY = "feedbackInfoForm";

      /**
       * The request scope attribute that holds the feedbackInfo list
       */
      public static final String FEEDBACKINFO_LIST = "feedbackInfoList";
//  FeedbackInfo-END
      
//    CustomerType-START
      /**
       * The request scope attribute that holds the customerType form.
       */
      public static final String CUSTOMERTYPE_KEY = "customerTypeForm";

      /**
       * The request scope attribute that holds the customerType list
       */
      public static final String CUSTOMERTYPE_LIST = "customerTypeList";
//  CustomerType-END      
  
//    CustomerAddress-START
      /**
       * The request scope attribute that holds the customerAddress form.
       */
      public static final String CUSTOMERADDRESS_KEY = "customerAddressForm";

      /**
       * The request scope attribute that holds the customerAddress list
       */
      public static final String CUSTOMERADDRESS_LIST = "customerAddressList";
//  CustomerAddress-END     
      
      
      
      
      
      
      
//*************************************************
//    广告资源
//*************************************************  
//    MatterType-START
      /**
       * The request scope attribute that holds the matterType form.
       */
      public static final String MATTERTYPE_KEY = "matterTypeForm";

      /**
       * The request scope attribute that holds the matterType list
       */
      public static final String MATTERTYPE_LIST = "matterTypeList";
//  MatterType-END

//    Carrier-START
        /**
         * The request scope attribute that holds the carrier form.
         */
        public static final String CARRIER_KEY = "carrierForm";

        /**
         * The request scope attribute that holds the carrier list
         */
        public static final String CARRIER_LIST = "carrierList";
//    Carrier-END

//    Compages-START
        /**
         * The request scope attribute that holds the compages form.
         */
        public static final String COMPAGES_KEY = "compagesForm";

        /**
         * The request scope attribute that holds the compages list
         */
        public static final String COMPAGES_LIST = "compagesList";
//    Compages-END

//    Resource-START
        /**
         * The request scope attribute that holds the resource form.
         */
        public static final String RESOURCE_KEY = "resourceForm";

        /**
         * The request scope attribute that holds the resource list
         */
        public static final String RESOURCE_LIST = "resourceList";
//    Resource-END

//    Workspan-START
        /**
         * The request scope attribute that holds the workspan form.
         */
        public static final String WORKSPAN_KEY = "workspanForm";

        /**
         * The request scope attribute that holds the workspan list
         */
        public static final String WORKSPAN_LIST = "workspanList";
//    Workspan-END

//    DayInfo-START
        /**
         * The request scope attribute that holds the dayInfo form.
         */
        public static final String DAYINFO_KEY = "dayInfoForm";

        /**
         * The request scope attribute that holds the dayInfo list
         */
        public static final String DAYINFO_LIST = "dayInfoList";
//    DayInfo-END

//    Price-START
        /**
         * The request scope attribute that holds the price form.
         */
        public static final String PRICE_KEY = "priceForm";

        /**
         * The request scope attribute that holds the price list
         */
        public static final String PRICE_LIST = "priceList";
//    Price-END

//    PriceDetail-START
        /**
         * The request scope attribute that holds the priceDetail form.
         */
        public static final String PRICEDETAIL_KEY = "priceDetailForm";

        /**
         * The request scope attribute that holds the priceDetail list
         */
        public static final String PRICEDETAIL_LIST = "priceDetailList";
//    PriceDetail-END

//    Specific-START
        /**
         * The request scope attribute that holds the specific form.
         */
        public static final String SPECIFIC_KEY = "specificForm";

        /**
         * The request scope attribute that holds the specific list
         */
        public static final String SPECIFIC_LIST = "specificList";
//    Specific-END

//    PriceRegular-START
        /**
         * The request scope attribute that holds the priceRegular form.
         */
        public static final String PRICEREGULAR_KEY = "priceRegularForm";

        /**
         * The request scope attribute that holds the priceRegular list
         */
        public static final String PRICEREGULAR_LIST = "priceRegularList";
//    PriceRegular-END
        
//      PriceType-START
        /**
         * The request scope attribute that holds the priceType form.
         */
        public static final String PRICETYPE_KEY = "priceTypeForm";

        /**
         * The request scope attribute that holds the priceType list
         */
        public static final String PRICETYPE_LIST = "priceTypeList";
//    PriceType-END    
      
//      ResourceChannel-START
        /**
         * The request scope attribute that holds the resourceChannel form.
         */
        public static final String RESOURCECHANNEL_KEY = "resourceChannelForm";

        /**
         * The request scope attribute that holds the resourceChannel list
         */
        public static final String RESOURCECHANNEL_LIST = "resourceChannelList";
//    ResourceChannel-END

//    MediaOrg-START
        /**
         * The request scope attribute that holds the mediaOrg form.
         */
        public static final String MEDIAORG_KEY = "mediaOrgForm";

        /**
         * The request scope attribute that holds the mediaOrg list
         */
        public static final String MEDIAORG_LIST = "mediaOrgList";
//    MediaOrg-END

//    ResourceType-START
        /**
         * The request scope attribute that holds the resourceType form.
         */
        public static final String RESOURCETYPE_KEY = "resourceTypeForm";

        /**
         * The request scope attribute that holds the resourceType list
         */
        public static final String RESOURCETYPE_LIST = "resourceTypeList";
//    ResourceType-END      
      
//      CarrierType-START
        /**
         * The request scope attribute that holds the carrierType form.
         */
        public static final String CARRIERTYPE_KEY = "carrierTypeForm";

        /**
         * The request scope attribute that holds the carrierType list
         */
        public static final String CARRIERTYPE_LIST = "carrierTypeList";
//    CarrierType-END  
        
//      ResourceSort-START
        /**
         * The request scope attribute that holds the resourceSort form.
         */
        public static final String RESOURCESORT_KEY = "resourceSortForm";

        /**
         * The request scope attribute that holds the resourceSort list
         */
        public static final String RESOURCESORT_LIST = "resourceSortList";
//    ResourceSort-END       
        
        
        
        
        
//*************************************************
//             广告素材
//*************************************************          
        
        

//      Brand-START
          /**
           * The request scope attribute that holds the brand form.
           */
          public static final String BRAND_KEY = "brandForm";

          /**
           * The request scope attribute that holds the brand list
           */
          public static final String BRAND_LIST = "brandList";
//      Brand-END

//      Matter-START
          /**
           * The request scope attribute that holds the matter form.
           */
          public static final String MATTER_KEY = "matterForm";

          /**
           * The request scope attribute that holds the matter list
           */
          public static final String MATTER_LIST = "matterList";
//      Matter-END

//      ProductCategory-START
          /**
           * The request scope attribute that holds the productCategory form.
           */
          public static final String PRODUCTCATEGORY_KEY = "productCategoryForm";

          /**
           * The request scope attribute that holds the productCategory list
           */
          public static final String PRODUCTCATEGORY_LIST = "productCategoryList";
//      ProductCategory-END

//      PublishedInfo-START
          /**
           * The request scope attribute that holds the publishedInfo form.
           */
          public static final String PUBLISHEDINFO_KEY = "publishedInfoForm";

          /**
           * The request scope attribute that holds the publishedInfo list
           */
          public static final String PUBLISHEDINFO_LIST = "publishedInfoList";
//      PublishedInfo-END

//      PublishMemo-START
          /**
           * The request scope attribute that holds the publishMemo form.
           */
          public static final String PUBLISHMEMO_KEY = "publishMemoForm";

          /**
           * The request scope attribute that holds the publishMemo list
           */
          public static final String PUBLISHMEMO_LIST = "publishMemoList";
//      PublishMemo-END
          
          
          
          
          
         
          
          
          
          
          
 //*************************************************
 //             财务
 //*************************************************        
          


//        Income-START
            /**
             * The request scope attribute that holds the income form.
             */
            public static final String INCOME_KEY = "incomeForm";

            /**
             * The request scope attribute that holds the income list
             */
            public static final String INCOME_LIST = "incomeList";
//        Income-END

//        IncomeMode-START
            /**
             * The request scope attribute that holds the incomeMode form.
             */
            public static final String INCOMEMODE_KEY = "incomeModeForm";

            /**
             * The request scope attribute that holds the incomeMode list
             */
            public static final String INCOMEMODE_LIST = "incomeModeList";
//        IncomeMode-END

//        IncomePull-START
            /**
             * The request scope attribute that holds the incomePull form.
             */
            public static final String INCOMEPULL_KEY = "incomePullForm";

            /**
             * The request scope attribute that holds the incomePull list
             */
            public static final String INCOMEPULL_LIST = "incomePullList";
//        IncomePull-END

//        IncomePurpose-START
            /**
             * The request scope attribute that holds the incomePurpose form.
             */
            public static final String INCOMEPURPOSE_KEY = "incomePurposeForm";

            /**
             * The request scope attribute that holds the incomePurpose list
             */
            public static final String INCOMEPURPOSE_LIST = "incomePurposeList";
//        IncomePurpose-END

//        IncomeUsed-START
            /**
             * The request scope attribute that holds the incomeUsed form.
             */
            public static final String INCOMEUSED_KEY = "incomeUsedForm";

            /**
             * The request scope attribute that holds the incomeUsed list
             */
            public static final String INCOMEUSED_LIST = "incomeUsedList";
//        IncomeUsed-END


            
            

//Org-START
    /**
     * The request scope attribute that holds the org form.
     */
    public static final String ORG_KEY = "orgForm";

    /**
     * The request scope attribute that holds the org list
     */
    public static final String ORG_LIST = "orgList";
//Org-END





//Branch-START
    /**
     * The request scope attribute that holds the branch form.
     */
    public static final String BRANCH_KEY = "branchForm";

    /**
     * The request scope attribute that holds the branch list
     */
    public static final String BRANCH_LIST = "branchList";
//Branch-END

//ContractTarget-START
    /**
     * The request scope attribute that holds the contractTarget form.
     */
    public static final String CONTRACTTARGET_KEY = "contractTargetForm";

    /**
     * The request scope attribute that holds the contractTarget list
     */
    public static final String CONTRACTTARGET_LIST = "contractTargetList";
//ContractTarget-END

//OaApplyInfo-START
    /**
     * The request scope attribute that holds the oaApplyInfo form.
     */
    public static final String OAAPPLYINFO_KEY = "oaApplyInfoForm";

    /**
     * The request scope attribute that holds the oaApplyInfo list
     */
    public static final String OAAPPLYINFO_LIST = "oaApplyInfoList";
//OaApplyInfo-END

//OaAreaCity-START
    /**
     * The request scope attribute that holds the oaAreaCity form.
     */
    public static final String OAAREACITY_KEY = "oaAreaCityForm";

    /**
     * The request scope attribute that holds the oaAreaCity list
     */
    public static final String OAAREACITY_LIST = "oaAreaCityList";
//OaAreaCity-END

//OaAreaPc-START
    /**
     * The request scope attribute that holds the oaAreaPc form.
     */
    public static final String OAAREAPC_KEY = "oaAreaPcForm";

    /**
     * The request scope attribute that holds the oaAreaPc list
     */
    public static final String OAAREAPC_LIST = "oaAreaPcList";
//OaAreaPc-END

//OaAssets-START
    /**
     * The request scope attribute that holds the oaAssets form.
     */
    public static final String OAASSETS_KEY = "oaAssetsForm";

    /**
     * The request scope attribute that holds the oaAssets list
     */
    public static final String OAASSETS_LIST = "oaAssetsList";
//OaAssets-END

//OaAssetsState-START
    /**
     * The request scope attribute that holds the oaAssetsState form.
     */
    public static final String OAASSETSSTATE_KEY = "oaAssetsStateForm";

    /**
     * The request scope attribute that holds the oaAssetsState list
     */
    public static final String OAASSETSSTATE_LIST = "oaAssetsStateList";
//OaAssetsState-END

//OaAssetsType-START
    /**
     * The request scope attribute that holds the oaAssetsType form.
     */
    public static final String OAASSETSTYPE_KEY = "oaAssetsTypeForm";

    /**
     * The request scope attribute that holds the oaAssetsType list
     */
    public static final String OAASSETSTYPE_LIST = "oaAssetsTypeList";
//OaAssetsType-END

//OaBusinessCard-START
    /**
     * The request scope attribute that holds the oaBusinessCard form.
     */
    public static final String OABUSINESSCARD_KEY = "oaBusinessCardForm";

    /**
     * The request scope attribute that holds the oaBusinessCard list
     */
    public static final String OABUSINESSCARD_LIST = "oaBusinessCardList";
//OaBusinessCard-END

//OaBusinessCardType-START
    /**
     * The request scope attribute that holds the oaBusinessCardType form.
     */
    public static final String OABUSINESSCARDTYPE_KEY = "oaBusinessCardTypeForm";

    /**
     * The request scope attribute that holds the oaBusinessCardType list
     */
    public static final String OABUSINESSCARDTYPE_LIST = "oaBusinessCardTypeList";
//OaBusinessCardType-END

//OaCalendarEvent-START
    /**
     * The request scope attribute that holds the oaCalendarEvent form.
     */
    public static final String OACALENDAREVENT_KEY = "oaCalendarEventForm";

    /**
     * The request scope attribute that holds the oaCalendarEvent list
     */
    public static final String OACALENDAREVENT_LIST = "oaCalendarEventList";
//OaCalendarEvent-END

//OaDocument-START
    /**
     * The request scope attribute that holds the oaDocument form.
     */
    public static final String OADOCUMENT_KEY = "oaDocumentForm";

    /**
     * The request scope attribute that holds the oaDocument list
     */
    public static final String OADOCUMENT_LIST = "oaDocumentList";
//OaDocument-END

//OaDocumentCatalog-START
    /**
     * The request scope attribute that holds the oaDocumentCatalog form.
     */
    public static final String OADOCUMENTCATALOG_KEY = "oaDocumentCatalogForm";

    /**
     * The request scope attribute that holds the oaDocumentCatalog list
     */
    public static final String OADOCUMENTCATALOG_LIST = "oaDocumentCatalogList";
//OaDocumentCatalog-END

//OaDocumentCatalogPermitType-START
    /**
     * The request scope attribute that holds the oaDocumentCatalogPermitType form.
     */
    public static final String OADOCUMENTCATALOGPERMITTYPE_KEY = "oaDocumentCatalogPermitTypeForm";

    /**
     * The request scope attribute that holds the oaDocumentCatalogPermitType list
     */
    public static final String OADOCUMENTCATALOGPERMITTYPE_LIST = "oaDocumentCatalogPermitTypeList";
//OaDocumentCatalogPermitType-END

//OaDocumentFile-START
    /**
     * The request scope attribute that holds the oaDocumentFile form.
     */
    public static final String OADOCUMENTFILE_KEY = "oaDocumentFileForm";

    /**
     * The request scope attribute that holds the oaDocumentFile list
     */
    public static final String OADOCUMENTFILE_LIST = "oaDocumentFileList";
//OaDocumentFile-END

//OaInfo-START
    /**
     * The request scope attribute that holds the oaInfo form.
     */
    public static final String OAINFO_KEY = "oaInfoForm";

    /**
     * The request scope attribute that holds the oaInfo list
     */
    public static final String OAINFO_LIST = "oaInfoList";
//OaInfo-END

//OaInfoType-START
    /**
     * The request scope attribute that holds the oaInfoType form.
     */
    public static final String OAINFOTYPE_KEY = "oaInfoTypeForm";

    /**
     * The request scope attribute that holds the oaInfoType list
     */
    public static final String OAINFOTYPE_LIST = "oaInfoTypeList";
//OaInfoType-END

//OaProductInfo-START
    /**
     * The request scope attribute that holds the oaProductInfo form.
     */
    public static final String OAPRODUCTINFO_KEY = "oaProductInfoForm";

    /**
     * The request scope attribute that holds the oaProductInfo list
     */
    public static final String OAPRODUCTINFO_LIST = "oaProductInfoList";
//OaProductInfo-END

//OaProductType-START
    /**
     * The request scope attribute that holds the oaProductType form.
     */
    public static final String OAPRODUCTTYPE_KEY = "oaProductTypeForm";

    /**
     * The request scope attribute that holds the oaProductType list
     */
    public static final String OAPRODUCTTYPE_LIST = "oaProductTypeList";
//OaProductType-END

//OaProductUsed-START
    /**
     * The request scope attribute that holds the oaProductUsed form.
     */
    public static final String OAPRODUCTUSED_KEY = "oaProductUsedForm";

    /**
     * The request scope attribute that holds the oaProductUsed list
     */
    public static final String OAPRODUCTUSED_LIST = "oaProductUsedList";
//OaProductUsed-END

//OaScratchpad-START
    /**
     * The request scope attribute that holds the oaScratchpad form.
     */
    public static final String OASCRATCHPAD_KEY = "oaScratchpadForm";

    /**
     * The request scope attribute that holds the oaScratchpad list
     */
    public static final String OASCRATCHPAD_LIST = "oaScratchpadList";
//OaScratchpad-END

//OaWorkFlow-START
    /**
     * The request scope attribute that holds the oaWorkFlow form.
     */
    public static final String OAWORKFLOW_KEY = "oaWorkFlowForm";

    /**
     * The request scope attribute that holds the oaWorkFlow list
     */
    public static final String OAWORKFLOW_LIST = "oaWorkFlowList";
//OaWorkFlow-END

//OaWorkFlowCheck-START
    /**
     * The request scope attribute that holds the oaWorkFlowCheck form.
     */
    public static final String OAWORKFLOWCHECK_KEY = "oaWorkFlowCheckForm";

    /**
     * The request scope attribute that holds the oaWorkFlowCheck list
     */
    public static final String OAWORKFLOWCHECK_LIST = "oaWorkFlowCheckList";
//OaWorkFlowCheck-END

//OaWorkFlowCheckResult-START
    /**
     * The request scope attribute that holds the oaWorkFlowCheckResult form.
     */
    public static final String OAWORKFLOWCHECKRESULT_KEY = "oaWorkFlowCheckResultForm";

    /**
     * The request scope attribute that holds the oaWorkFlowCheckResult list
     */
    public static final String OAWORKFLOWCHECKRESULT_LIST = "oaWorkFlowCheckResultList";
//OaWorkFlowCheckResult-END

//OaWorkFlowType-START
    /**
     * The request scope attribute that holds the oaWorkFlowType form.
     */
    public static final String OAWORKFLOWTYPE_KEY = "oaWorkFlowTypeForm";

    /**
     * The request scope attribute that holds the oaWorkFlowType list
     */
    public static final String OAWORKFLOWTYPE_LIST = "oaWorkFlowTypeList";
//OaWorkFlowType-END


//  OaTeleExpenses-START
    /**
     * The request scope attribute that holds the oaTeleExpenses form.
     */
    public static final String OATELEEXPENSES_KEY = "oaTeleExpensesForm";

    /**
     * The request scope attribute that holds the oaTeleExpenses list
     */
    public static final String OATELEEXPENSES_LIST = "oaTeleExpensesList";
//OaTeleExpenses-END
    

//SysEvent-START
    /**
     * The request scope attribute that holds the sysEvent form.
     */
    public static final String SYSEVENT_KEY = "sysEventForm";

    /**
     * The request scope attribute that holds the sysEvent list
     */
    public static final String SYSEVENT_LIST = "sysEventList";
//SysEvent-END

//SysEventState-START
    /**
     * The request scope attribute that holds the sysEventState form.
     */
    public static final String SYSEVENTSTATE_KEY = "sysEventStateForm";

    /**
     * The request scope attribute that holds the sysEventState list
     */
    public static final String SYSEVENTSTATE_LIST = "sysEventStateList";
//SysEventState-END

//SysEventType-START
    /**
     * The request scope attribute that holds the sysEventType form.
     */
    public static final String SYSEVENTTYPE_KEY = "sysEventTypeForm";

    /**
     * The request scope attribute that holds the sysEventType list
     */
    public static final String SYSEVENTTYPE_LIST = "sysEventTypeList";
//SysEventType-END

//SysPromptMode-START
    /**
     * The request scope attribute that holds the sysPromptMode form.
     */
    public static final String SYSPROMPTMODE_KEY = "sysPromptModeForm";

    /**
     * The request scope attribute that holds the sysPromptMode list
     */
    public static final String SYSPROMPTMODE_LIST = "sysPromptModeList";
//SysPromptMode-END

//SysUserType-START
    /**
     * The request scope attribute that holds the sysUserType form.
     */
    public static final String SYSUSERTYPE_KEY = "sysUserTypeForm";

    /**
     * The request scope attribute that holds the sysUserType list
     */
    public static final String SYSUSERTYPE_LIST = "sysUserTypeList";
//SysUserType-END

//OaWorkFlowCheckState-START
    /**
     * The request scope attribute that holds the oaWorkFlowCheckState form.
     */
    public static final String OAWORKFLOWCHECKSTATE_KEY = "oaWorkFlowCheckStateForm";

    /**
     * The request scope attribute that holds the oaWorkFlowCheckState list
     */
    public static final String OAWORKFLOWCHECKSTATE_LIST = "oaWorkFlowCheckStateList";
//OaWorkFlowCheckState-END

//OaWorkFlowMoveType-START
    /**
     * The request scope attribute that holds the oaWorkFlowMoveType form.
     */
    public static final String OAWORKFLOWMOVETYPE_KEY = "oaWorkFlowMoveTypeForm";

    /**
     * The request scope attribute that holds the oaWorkFlowMoveType list
     */
    public static final String OAWORKFLOWMOVETYPE_LIST = "oaWorkFlowMoveTypeList";
//OaWorkFlowMoveType-END

//SysResource-START
    /**
     * The request scope attribute that holds the sysResource form.
     */
    public static final String SYSRESOURCE_KEY = "sysResourceForm";

    /**
     * The request scope attribute that holds the sysResource list
     */
    public static final String SYSRESOURCE_LIST = "sysResourceList";
//SysResource-END



//ContractTargetMonth-START
    /**
     * The request scope attribute that holds the contractTargetMonth form.
     */
    public static final String CONTRACTTARGETMONTH_KEY = "contractTargetMonthForm";

    /**
     * The request scope attribute that holds the contractTargetMonth list
     */
    public static final String CONTRACTTARGETMONTH_LIST = "contractTargetMonthList";
//ContractTargetMonth-END



//SysMenu-START
    /**
     * The request scope attribute that holds the sysMenu form.
     */
    public static final String SYSMENU_KEY = "sysMenuForm";

    /**
     * The request scope attribute that holds the sysMenu list
     */
    public static final String SYSMENU_LIST = "sysMenuList";
//SysMenu-END

//SysParam-START
    /**
     * The request scope attribute that holds the sysParam form.
     */
    public static final String SYSPARAM_KEY = "sysParamForm";

    /**
     * The request scope attribute that holds the sysParam list
     */
    public static final String SYSPARAM_LIST = "sysParamList";
//SysParam-END



//SysSequence-START
    /**
     * The request scope attribute that holds the sysSequence form.
     */
    public static final String SYSSEQUENCE_KEY = "sysSequenceForm";

    /**
     * The request scope attribute that holds the sysSequence list
     */
    public static final String SYSSEQUENCE_LIST = "sysSequenceList";
//SysSequence-END

//PublishArrange-START
    /**
     * The request scope attribute that holds the publishArrange form.
     */
    public static final String PUBLISHARRANGE_KEY = "publishArrangeForm";

    /**
     * The request scope attribute that holds the publishArrange list
     */
    public static final String PUBLISHARRANGE_LIST = "publishArrangeList";
//PublishArrange-END

//PublishArrangeDetail-START
    /**
     * The request scope attribute that holds the publishArrangeDetail form.
     */
    public static final String PUBLISHARRANGEDETAIL_KEY = "publishArrangeDetailForm";

    /**
     * The request scope attribute that holds the publishArrangeDetail list
     */
    public static final String PUBLISHARRANGEDETAIL_LIST = "publishArrangeDetailList";
//PublishArrangeDetail-END

//ForetArrearage-START
    /**
     * The request scope attribute that holds the foretArrearage form.
     */
    public static final String FORETARREARAGE_KEY = "foretArrearageForm";

    /**
     * The request scope attribute that holds the foretArrearage list
     */
    public static final String FORETARREARAGE_LIST = "foretArrearageList";
//ForetArrearage-END

//ResourceLimit-START
    /**
     * The request scope attribute that holds the resourceLimit form.
     */
    public static final String RESOURCELIMIT_KEY = "resourceLimitForm";

    /**
     * The request scope attribute that holds the resourceLimit list
     */
    public static final String RESOURCELIMIT_LIST = "resourceLimitList";
//ResourceLimit-END

//FinanceTarget-START
    /**
     * The request scope attribute that holds the financeTarget form.
     */
    public static final String FINANCETARGET_KEY = "financeTargetForm";

    /**
     * The request scope attribute that holds the financeTarget list
     */
    public static final String FINANCETARGET_LIST = "financeTargetList";
//FinanceTarget-END





//ProCustomerType-START
    /**
     * The request scope attribute that holds the proCustomerType form.
     */
    public static final String PROCUSTOMERTYPE_KEY = "proCustomerTypeForm";

    /**
     * The request scope attribute that holds the proCustomerType list
     */
    public static final String PROCUSTOMERTYPE_LIST = "proCustomerTypeList";
//ProCustomerType-END

//ProCustomer-START
    /**
     * The request scope attribute that holds the proCustomer form.
     */
    public static final String PROCUSTOMER_KEY = "proCustomerForm";

    /**
     * The request scope attribute that holds the proCustomer list
     */
    public static final String PROCUSTOMER_LIST = "proCustomerList";
//ProCustomer-END

//ProOrderType-START
    /**
     * The request scope attribute that holds the proOrderType form.
     */
    public static final String PROORDERTYPE_KEY = "proOrderTypeForm";

    /**
     * The request scope attribute that holds the proOrderType list
     */
    public static final String PROORDERTYPE_LIST = "proOrderTypeList";
//ProOrderType-END

//ProOrder-START
    /**
     * The request scope attribute that holds the proOrder form.
     */
    public static final String PROORDER_KEY = "proOrderForm";

    /**
     * The request scope attribute that holds the proOrder list
     */
    public static final String PROORDER_LIST = "proOrderList";
//ProOrder-END

//ProProgramType-START
    /**
     * The request scope attribute that holds the proProgramType form.
     */
    public static final String PROPROGRAMTYPE_KEY = "proProgramTypeForm";

    /**
     * The request scope attribute that holds the proProgramType list
     */
    public static final String PROPROGRAMTYPE_LIST = "proProgramTypeList";
//ProProgramType-END

//ProProgram-START
    /**
     * The request scope attribute that holds the proProgram form.
     */
    public static final String PROPROGRAM_KEY = "proProgramForm";

    /**
     * The request scope attribute that holds the proProgram list
     */
    public static final String PROPROGRAM_LIST = "proProgramList";
//ProProgram-END

//ProPublishPlan-START
    /**
     * The request scope attribute that holds the proPublishPlan form.
     */
    public static final String PROPUBLISHPLAN_KEY = "proPublishPlanForm";

    /**
     * The request scope attribute that holds the proPublishPlan list
     */
    public static final String PROPUBLISHPLAN_LIST = "proPublishPlanList";
//ProPublishPlan-END

//ProAudienceRat-START
    /**
     * The request scope attribute that holds the proAudienceRat form.
     */
    public static final String PROAUDIENCERAT_KEY = "proAudienceRatForm";

    /**
     * The request scope attribute that holds the proAudienceRat list
     */
    public static final String PROAUDIENCERAT_LIST = "proAudienceRatList";
//ProAudienceRat-END
    
    
    
    
    
    //cas.properties key 
	public static final String CAS_AUTH_ENABLED = "cas.auth.enabled";

	public static final String CAS_IMPORT_FROM_LDAP = "cas.import.from.ldap";

	public static final String CAS_LOGIN_URL = "cas.login.url";

	public static final String CAS_LOGOUT_URL = "cas.logout.url";

	public static final String CAS_SERVER_NAME = "cas.server.name";

	public static final String CAS_SERVICE_URL = "cas.service.url";

	public static final String CAS_VALIDATE_URL = "cas.validate.url";

}























