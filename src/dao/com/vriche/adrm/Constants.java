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
    
    //ϵͳSQL�ű����·��
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
		quartzStatus.put("ACQUIRED", "������");
		quartzStatus.put("PAUSED", "��ͣ��");
		quartzStatus.put("WAITING", "�ȴ���");		
	}
	
	
	
	
	
  
    /*
     * ϵͳ����
    */
    /** The name of the configuration hashmap stored in application scope. */
    public static final String CONFIG = "appConfig";
    
    public static final String CSS_THEME = "theme";
    
    public static final String GLOBAL_CUSRUSER_ORGS = "globalUserLogs";
    
    public static final String GLOBAL_CUSRUSER_ORGS_OBJ = "globalUserLogsObj";
    
    public static final String GLOBAL_SYS_PARAM = "globalSysParam";
    //��ͬ����
    public static final String CONTRACT_SORT_PARAM = "contractSortParam";
    //���������ʽ
    public static final  String ORDER_VIEW_MODEL_PARAM = "orderViewModelParam";
    //��Ƶ������
    public static final  String CHANNEL_MODEL_PARAM = "channelModelParam";
    //�����ŷ�ʽ
    public static final  String PUBLISH_MODEL_PARAM = "piblishModelParam";   
    //����ӿ�����
    public static final  String PUBLISH_EXPORT_MODEL_PARAM = "piblishExportModelParam";    
    //��������ɷ�ʽ
    public static final  String ADVER_CODE_MODEL_PARAM = "adverCodeModelParam";  
    //��ͬ�����ɷ�ʽ  
    public static final  String ORDER_CODE_MODEL_PARAM = "orderCodeModelParam";
    
    //���������ɷ�ʽ  
    public static final  String INCOME_CODE_MODEL_PARAM = "incomeCodeModelParam";
    //����λ��ʾ���ؿ���
    public static final  String ORDER_CARRIER_TYPE_DISPLAY_PARAM = "orderCarrierTypeDisplayParam"; 
    
    //�������������ʾ����
    public static final  String RESOURCE_DISPLAY_PARAM = "resourceDisplayParam"; 
    
    //  Ƶ������
    public static final  String  CHANNEL_PULL_PARAM = "channelPullParam"; 
    
    //�ͻ�������ʽ
    public static final  String CUSTOMER_OWNER_PARAM = "customerOwnerParam"; 
    //�ͻ����������ʽ
//    public static final  String CUSTOMER_CARRIER_PARAM = "customerCarrierParam"; 
    //����ЭԼ
    public static final  String ORDER_CONTRACT_PARAM = "orderContractParam"; 
    //���弶��
    public static final  String CARRIER_NODELEVEL_PARAM = "carrierNodeLevelParam";
    //��Ƭ����
    public static final  String DIAN_PIAN_PARAM = "dianpianParam";
    //������ʱ�Ƿ�������λ����
    public static final  String STRIDE_POSITION_PARAM = "stridePositionParam";
    //�ڶ�������ӿͻ�
    public static final  String ADD_CUSTOMER_IN_ORDER_PARAM = "addCustomerInOrderParam";
    
    //��ָ��Ҳ�������
    public static final  String SPEC_AROWMOVE_PARAM = "specArowMoveParam";
    
    //����ʱ�Ƿ���ʾû�й��Ķ�λ
    public static final  String IS_DISPLAYNOADRES_PARAM = "isDisplayNoadResParam";
    
    //��Ƶ��������
    public static final  String MORE_CHANNEL_NOPULL_PARAM = "moreChannelNoPullParam";
    
    //�Ƿ��Ƶ��
    public static final String MORE_CHANNEL_PARAM = "moreChannelParam";
    
    //13���ʱ���޶�
    public static final String RESOURCE_RELIMIT_PARAM = "resourceReLimitParam";
    
    //��󶩵��������޸Ĺ���زģ��������޸ĳ���
    public static final String PERMIT_MOD_ADVER_PARAM = "permitModAdverParam";
    
    //  ������ʱ����������Ĭ��ֵ
    public static final String ORDER_MOD_CATEGORY_PARAM = "orderModCategoryParam";
    
    // �Ƿ���������־
    public static final String IS_OPEN_ORDER_ORG_PARAM = "isOpenOrderOrgParam";
    
    //  �Ƿ���ʾͼ��ť
    public static final String IS_DISPLAY_CHART_PARAM = "isDisplayChartParam";
    
    //  �Ƿ���ʾ�û��ͻ�������ϵ
    public static final String IS_USER_CUSTOMER_REL_PARAM = "isUserCustomerRelParam";
    
    //  �����ʾǷ��ͳ�Ʒ�ʽ
    public static final String ARREARAGE_MODE = "arrearageMode";
    
    //	��α��Ŵ�����(����ʾ˳��(0),���ǲ������(1)����)
    public static final String IS_ARRANGE_ORDER_OR_ENTRY= "isArrangeOrderOrEntry";
    
//	���ݵ���̨���⹦�ܲ���(���Ǹ���̨������Ϊ1,��������Ϊ0);��Ϊϵͳ����Ĭ����0;
    public static final String FZTV_SPECIAL_PARAM= "fztvSpecialParam";
    
//  Ȫ�ݵ���̨���⹦�ܲ���(����Ȫ��̨������Ϊ1,��������Ϊ0);��Ϊϵͳ����Ĭ����0;
    public static final String QZTV_SPECIAL_PARAM= "qztvSpecialParam";
    
    //�Ƿ�������װ����(����1,������0)ϵͳ����Ĭ����0;
    public static final String SIGN_COMPAGES_PARAM= "signCompages";
    
    //�Ƿ����ò������(����1,������0)ϵͳ����Ĭ����0
    public static final String WITH_BROPROINT_PARAM= "withBroPoint";
    
    
    //�Ƿ����ù����Դ����(����1,������0)ϵͳ����Ĭ����0
    public static final String WITH_RESOURCE_SORT_PARAM= "withResourceSort";
    
    
    //����̨���⹦�ܲ���(����ָ���ض�����̨������Ϊcatv,sjztv,hntv,fztv,qztv,xmtv,��������Ϊ0);ϵͳ����Ĭ����0;
    public static final String TV_NAME_PARAM= "tvNameParam";   
    
    
    //���������ύ���������(��Ҫ�ύ(0),���ύ(1))
    public static final String WITHOUT_SUBMIT= "withoutSubmit";

    
    
//  ������ʾ����ص�ҵ��Ա(�������¼��һ�ʵ�����޸�һ�𵽿����ʾ��ص�ҵ��Ա) ��ʽ��1,192.168.1.100,5222,domain.com,longin,PWD��
    public static final String INCOME_MESSAGE_ALERT_PARAM= "incomeMessageAlertParam";
 //�Ƿ���ҵ��Աƽ��(0-�� 1-��)   
    public static final String IS_SIGN_USER_BALANCE= "isSignUserBalance";

    //�����Ƿ�������ݹ���(0-�� 1-��)   
    public static final String IS_USER_ORDER_YEAR_REL= "isUserOrderYearRel";
    
    
    //�Ƿ�����Ƶ������(0-�� 1-��) �� ����Ƶ��������Ƶ���ķ��෽��  
    public static final String IS_USE_CARRIER_PROTY = "isUseCarrierProty";
    
    //����������ǰ����Ҫ��ʾ�Ķ���״̬��Ĭ��1(1δ������2����С�3ͨ����4���˻ء�5δͨ��)
    public static final String PUBLISH_ORDER_ALERT_STATES = "publishOrderAlertStates";
     
    
    //ͳ�����Ƿ���ʾ���������
    public static final String IS_DISPLAY_STANDPRICE = "isDisplayStandPrice";  
    
    
    //���������弶��(Ĭ��0��ά��ʱĬ�ϵļ�������1Ϊ��ʾֻȡһ��)
    public static final String ORDER_CARRIER_LEVEL_PARAM = "orderCarrierLevelParam";  
    
    
    //�����ж�����ϸ��ʾ��ҳ�򲻷�ҳ(Ĭ��0Ĭ�Ϸ�ҳ��1Ϊ��ʾ����)
    public static final String ORDER_DETAIL_DISPLAY_PARAM = "orderDetailDisplayParam";  
    

    //ͳ�Ʒ������Ƿ�����Ƶ������
    public static final String USE_CARRIER_ALINAME_PARAM = "useCarrierAliname";  
    
    //�ж��Ƿ����ö������͵����壬����ӡ��㲥�ȵȣ�Ĭ��0
    public static final String USE_MORE_CARRIER_SORT_PARAM = "useMoreCarrierSortParam";  
    
    
    //�Ƿ����ÿͻ�������
    public static final String CUSTOMER_CATE_FITER_PARAM = "customerCateFiter";      
    
    
    
    //ȫ��ϵͳ����
    public static final String GLOBAL_SYS_PARAMS = "_globalSysParams";    
    
    //��ƹ��˿���
    public static final String FINANCIAL_AUDIT_SWITCH= "financialAuditSwitch";        
    //���˶������
    public static final String FITTER_ORDER_SUBCATES= "fitterOrderSubCates";   
    
    public static final String FITTER_ORDER_SUBCATES_WITHOUT= "fitterOrderSubCatesWithout";  
    //���˵�����;
    public static final String FITTER_INCOME_POURS= "fitterIncomePours";  
    
    public static final String FITTER_INCOME_POURS_WITHOUT= "fitterIncomePoursWithout";  
    
    
 // ��ǩ�����������Ĭ���·�,Ĭ�ϵ�ǰ�·�+2
    public static final String  ORDER_ARRANG_DEFAULT_MONTHS= "orderArrangDefaultMonths";   
    

    // ���������������ڵ��޸�
    public static final String  OUT_LIMIT_BROARRANG= "outLimitBroarrang";   
    
    // ʹ�ÿͻ����Ͷ�ŵ�ʱ�����
    public static final String  RESOURCE_USE_CUSTOMER_CATELOG= "resourceUseCustomerCatelog";   
    
    
    // ʱ��ʹ�ñ��ʱ�
    public static final String  RESOURCE_USE_RATE_TABLE= "resourceUseRateTable";   
    
    
    /*
     * ��Ź��� �������Ʋ�����һ���
    */   
    //��ͬ���
    public static final String SEQUENCE_TB_CONTRACT = "sequence_tb_contract";
    //�������
    public static final String SEQUENCE_TB_ORDER = "sequence_tb_order";
    //�ɹ��������
    public static final String SEQUENCE_TB_PRO_ORDER_C = "sequence_tb_pro_order_c";
    //���۶������
    public static final String SEQUENCE_TB_PRO_ORDER_X = "sequence_tb_pro_order_x";
    //�Ŵ����
    public static final String SEQUENCE_TB_ADVER_MATTER = "sequence_tb_adver_matter";
    //������
    public static final String SEQUENCE_TB_INCOME = "sequence_tb_income";
    //�������
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
   
//  �Ƿ������Զ���ϵ��
    public static final String AUTO_RELATION_CODE_PARAM = "autoRelationCodeParam";
    
//  Ĭ�ϼ۸����
    public static final String AUTO_PRICE_TYPE_PARAM = "autoPriceTypeParam";  
	 
	 //�Ƿ����ʹ����Ŀ
	 public static final String USE_LANMU_SINGLE = "useLanmuSingleParam";  
	 
	 
	 
	 //��˺�Ķ����Ƿ�����༭
	 public static final String ALLOW_MODIY_PASSED_ORDER = "allowModiyPassedOrderParam";  
	 
	 
	 //��淢����ͬģ������ Ĭ�� 0 ���ÿҳ����1 ֻ�����һҳ�����
	 public static final String ORDER_PUBLISH_TEMPLE_PARAM = "orderPublishTempleParam";  
	 
	 //�Ƿ���ʾ������ţ�0����ʾ��1��ʾ��Ĭ��0
	 public static final String ORDER_DISPLAY_RELATIONCEODE_PARAM = "orderDisplayRelcodeParam";  
	 
	 //�Ƿ������������ˣ�true|56,22|88
	 public static final String FINANCIA_AUDIT_PARAM = "financialAuditParam";  
	
	 
	 //�Ƿ���ʾƽ����Ϣ��0����ʾ��1��ʾ��Ĭ��0
	 public static final String ORDER_DISPLAY_INCOME_PARAM = "orderDisplayIncomeParam";  
	 
	 
	 //һ�������¶����֧�������������Դ����0����ʾ��1��ʾ��Ĭ��0
	 public static final String ONE_ORG_MORE_SUBORGS_PARAM = "oneOrgMoreSuborgsParam";  
	 
	 //����ƽ�ʷ�ʽ��0����ʾ��1��ʾ��Ĭ��0
	 public static final String FINANCE_BALANCE_MODEL_PARAM = "financeBalanceModelParam";   

	 //�����µ���0��1��
	 public static final String FAST_SIGN_ORDER_PARAM = "fastSignOrderParam";    
	 
	 //����Ӧ�ռ���ģʽ��0 Ӧ��=�ۺ�۸�*����*�ۿ�*��1+�����ʣ�+���� 1 Ӧ��=���ۼ۸�*����*�ۿ�*��1+�����ʣ�+����
	 public static final String ORDER_CALCULATE_MODEL_PARAM = "orderCalculateModel";    
	 
	 
	 //�Ƿ����ô���ı���ϵͳ�Խ� 0 ��  1 ��
	 public static final String DAYANG_BEIBO_ENADBLE_PARAM = "dayangBeiboEnableParam";    
	 
	 //����ı���ϵͳ  webservice ImportMaterialService url  "http://10.77.82.91:8892/ADPINF/services/ImportMaterialService";
	 public static final String DAYANG_WEBSERVER_URL_MATTER = "dayangWebServiceUrlMatterParam";   
	 
	 //	����ı���ϵͳ  webservice ImportProgramListService url  "http://10.77.82.91:8892/ADPINF/services/ImportProgramListService";
	 public static final String DAYANG_WEBSERVER_URL_PROGRAM_LIST = "dayangWebServiceUrlProLitstParam";   
	 
	 //ϵͳ���õ����
//	 public static final String ADRM_SYS_YEAR_PROGRAM_LIST = "2006,2007,2008,2009,2010,2011,2012,2013,2014";  
	 public static final String ADRM_SYS_YEAR_PROGRAM_LIST = "adrmSysYearProgramList";
	 
	 //���������۸��Ƿ�����޸�
	 public static final String ORDER_BASE_PRICE_ENABLE_MODY_PARAM = "orderBasePriceEnableModyParam";
	 
	 
	 //�������Ƿ���ʾƷ��
	 public static final String ARRANGE_WITH_BRAND_PARAM = "arrangeWithBrandParam"; 
	 
	 
	 //�����Դ������
	 public static final String AVAILABLE_CARRIER_RESOURCE_TREE = "available_carrier_resource_tree"; 
	 
	 //�������Զ����
	 public static final String PUBLIC_AD_AUTO_FILL = "public_ad_auto_fill"; 
	 
	 //ftp������ "ip:172.16.1.249,port:21,user:new,pass:123456"
	 public static final String FTP_SERVVICE_CONFIG = "ftp_service_config"; 
	 
	 //ʱ��ά������ʱ������
	 public static final String RESCONFIG_ORDER_BY_TIME = "resconfigOrderbyTime"; 
	 
	 
	 //������Ƶ��
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
//  ����
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
//  �ͻ���ϵ
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
//    �����Դ
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
//             ����ز�
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
 //             ����
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























