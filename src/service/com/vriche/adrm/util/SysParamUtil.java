package com.vriche.adrm.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.ResourceChannelConfig;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.User;

public class SysParamUtil {
	 
	private static final Log log = LogFactory.getLog(SysParamUtil.class);
	
//	private JsonUtil jsonUtil = new JsonUtil();
	
//	SysParamUtil.isFZTVParam();
	
	
//	SysParamUtil.getCustomerOwnerRelPara()
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//电视台特殊功能参数(若有指定特定电视台则设置为catv,sjztv,hntv,fztv,qztv,xmtv,其他设置为0);系统参数默认是0;//
	public static  String getTvNameParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getTvNameParam())) sysParam.setTvNameParam("0");
	    return sysParam.getTvNameParam();
	}
	
//	public static  boolean isXMTVParam(){
//	    return !(getTvNameParam().equals("xmtv"))?false:true;
//	}
//	public static  boolean isFZTVParam(){
//	    return !(getTvNameParam().equals("fztv"))?false:true;
//	}
//	public static  boolean isFZQZTVParam(){
//	    return !(getTvNameParam().equals("qztv"))?false:true;
//	}
	
	public static  boolean isXMTVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("xmtv")?false:true;
		}else{
			 return !(getTvNameParam().equals("xmtv"))?false:true;
		}
	}
	public static  boolean isFZTVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("fztv")?false:true;
		}else{
			 return !(getTvNameParam().equals("fztv"))?false:true;
		}
	}
	public static  boolean isQZTVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("qztv")?false:true;
		}else{
			 return !(getTvNameParam().equals("qztv"))?false:true;
		}
	}
	public static  boolean isHNTVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("hntv")?false:true;
		}else{
			 return !(getTvNameParam().equals("hntv"))?false:true;
		}
	}
	public static  boolean isHBTVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("hbtv")?false:true;
		}else{
			 return !(getTvNameParam().equals("hbtv"))?false:true;
		}
	}
	public static  boolean isSXTVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("sxtv")?false:true;
		}else{
			 return !(getTvNameParam().equals("sxtv"))?false:true;
		}
	}
	public static  boolean isCATVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("catv")?false:true;
		}else{
			 return !(getTvNameParam().equals("catv"))?false:true;
		}
	}
	public static  boolean isSJZTVParam(String TvNameParam){
		if(TvNameParam != null){
			 return !TvNameParam.equals("sjz")?false:true;
		}else{
			 return !(getTvNameParam().equals("sjz"))?false:true;
		}
	}
	//**********************************************************************************************//
	
	
	//分频道管理
	public  static boolean getChannelModelPara(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getChannelModelParam())) sysParam.setChannelModelParam("0");
	    return (sysParam.getChannelModelParam().equals("0"))?false:true;
	   
	}
	
	//分频道不划账
	public  static boolean getMoreChannelNoPullParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getMoreChannelNoPullParam())) sysParam.setMoreChannelNoPullParam("0");
	    return (sysParam.getMoreChannelNoPullParam().equals("0"))?false:true;
	   
	} 	
	
	//是否多频道
	public  static boolean getMoreChannelPara(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		 if(StringUtils.isEmpty(sysParam.getMoreChannelParam())) sysParam.setMoreChannelParam("0");
	    return (sysParam.getMoreChannelParam().equals("0"))?false:true;
	
	}	
	
	//是否试用频道属性(0-否 1-是) 如 地面频道、卫星频道的分类方法  
	public  static boolean getIsUseCarrierProty(){
    	SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		if(StringUtils.isEmpty(sysParam.getIsUseCarrierProty())) sysParam.setIsUseCarrierProty("0");
		return  ("0".equals(sysParam.getIsUseCarrierProty())|| sysParam.getIsUseCarrierProty() == null)?false:true;
		
	} 	
	
    //广告载体类别的显示控制
	public  static boolean getCarrierTypeDisplay(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		if(StringUtils.isEmpty(sysParam.getOrderCarrierTypeDisplayParam())) sysParam.setOrderCarrierTypeDisplayParam("0");
		return ("0".equals(sysParam.getOrderCarrierTypeDisplayParam())|| sysParam.getOrderCarrierTypeDisplayParam() == null)?false:true;
		
	} 	
	
	 //广告载体类别的显示控制
	public static boolean getResourceDisplay(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getResourceDisplayParam())|| sysParam.getResourceDisplayParam() == null) sysParam.setResourceDisplayParam("0");
	    return (sysParam.getResourceDisplayParam().equals("0"))?false:true;
	}
	
    //客户归属方式
	public static boolean getCustomerOwnerRelPara(){
		   SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		   return ("0".equals(sysParam.getCustomerOwnerParam())|| sysParam.getCustomerOwnerParam() == null)?false:true;
		   
	 }
	
    //客户归属方式
	public static boolean getWithResourceSort(){
		   SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		   return "0".equals(sysParam.getWithResourceSort())|| sysParam.getWithResourceSort() == null?false:true;
		  
	 }
	
    //播出入点
	public static boolean getWithBroPoint(){
		   SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		   return "0".equals(sysParam.getWithBroPoint())|| sysParam.getWithBroPoint() == null?false:true;
		  
	 }
	
	//播出入点
	public static boolean getwithBroPoint(){
		   SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		   return ("0".equals(sysParam.getWithBroPoint())|| sysParam.getWithBroPoint() == null)?false:true;
		   
	 }

//	如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
	public static  boolean getIsArrangeOrderOrEntry(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getIsArrangeOrderOrEntry())) sysParam.setIsArrangeOrderOrEntry("0");
	    return (sysParam.getIsArrangeOrderOrEntry().equals("1"))?true:false;
	}	
	
	
//	如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
	public static  boolean getOrderCarrierLevelOne(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOrderCarrierLevelParam())) sysParam.setOrderCarrierLevelParam("0");
	    return (sysParam.getOrderCarrierLevelParam().equals("1"))?true:false;
	 
	}	
	
	
//	如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
	public static  boolean getOrderDetailDisplayNoPage(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOrderDetailDisplayParam())) sysParam.setOrderDetailDisplayParam("0");
	    return (sysParam.getOrderDetailDisplayParam().equals("1"))?true:false;
	   
	}	
	
//	如何编排串联单(按显示顺序(0),还是播出入点(1)排序)
	public static  boolean getArrangeOrderOrEntry(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getIsArrangeOrderOrEntry())) sysParam.setIsArrangeOrderOrEntry("0");
	    return (sysParam.getIsArrangeOrderOrEntry().equals("1"))?true:false;
	   
	}	
	
	
//	 统计分析中是否启用频道别名
	public static  boolean getUseCarrierAliname(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getUseCarrierAliname())) sysParam.setUseCarrierAliname("0");
	    return (sysParam.getUseCarrierAliname().equals("1"))?true:false;
	}	
	
//	 是否启用客户类别过滤
	public static  boolean getCustomerCateFiter(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getCustomerCateFiter())) sysParam.setCustomerCateFiter("0");
	    return (sysParam.getCustomerCateFiter().equals("1"))?true:false;
	}	
	
	
	public static  boolean getArrearageMode(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getArrearageMode())) sysParam.setArrearageMode("0");
	    return (sysParam.getArrearageMode().equals("1"))?true:false; 
	} 
	
	
	public static boolean isBuildLevel(String nodeLevel){
		boolean isbuild;
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		String carrierNodeLevel = sysParam.getCarrierNodeLevelParam()==null?null:sysParam.getCarrierNodeLevelParam();
		if(carrierNodeLevel.equals(nodeLevel)){
			isbuild = true;
		}else{
			isbuild = false;
		}
		return isbuild;
	}
	

	
	
	public static Org getOrgFromMap(String orgId){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
		return(Org) mp.get(orgId);
	}
	
	public static int getPiblishModelParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getPiblishModelParam())) sysParam.setPiblishModelParam("0");
	    return Integer.parseInt(sysParam.getPiblishModelParam());
	}
	
	
	public static int getFinanceBalanceModelParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getFinanceBalanceModelParam())) sysParam.setFinanceBalanceModelParam("0");
	    return Integer.parseInt(sysParam.getFinanceBalanceModelParam());
	}
	
	
	
	public static int getOrderCalculateModelParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOrderCalculateModel())) sysParam.setOrderCalculateModel("0");
	    return Integer.parseInt(sysParam.getOrderCalculateModel());		
	}		
	
	
	public static int getDayangBeiboEnableParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getDayangBeiboEnableParam())) sysParam.setDayangBeiboEnableParam("0:");
	    if(sysParam.getDayangBeiboEnableParam().indexOf(":") == -1) sysParam.setDayangBeiboEnableParam("0:");
	    String[] s = sysParam.getDayangBeiboEnableParam().split(":");
	    return Integer.parseInt(s[0]);		
	}		
	
	public static  String[]  getDayangBeiboEnableParamResSort(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getDayangBeiboEnableParam())) sysParam.setDayangBeiboEnableParam("0:");
	    if(sysParam.getDayangBeiboEnableParam().indexOf(":") == -1) sysParam.setDayangBeiboEnableParam("0:");
	    String[] s = sysParam.getDayangBeiboEnableParam().split(":");
	    if("".equals(s[1]) || s[1] == null) s[1]= "0";
	    String[] s2 = s[1].split(",");
	    return s2;		
	}		

	public static String getDayangWebServiceUrlMatterParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getDayangWebServiceUrlMatterParam())) sysParam.setDayangWebServiceUrlMatterParam("http://10.77.82.91:8892/ADPINF/services/ImportMaterialService");
	    return sysParam.getDayangWebServiceUrlMatterParam();		
	}
	
	
	
	
	public static Map getWebServiceUrlChannelConfig(String channelId){
		Map mp = new HashMap();
		Map mp2 = new HashMap();
		ServiceLocator serviceLocator = new ServiceLocator();
		List ls = serviceLocator.getResourceChannelManager().getResourceChannelConfigs(channelId);
		for (Iterator it = ls.iterator();it.hasNext();){
			ResourceChannelConfig config  = (ResourceChannelConfig) it.next();
			boolean send_enable = "1".equals(config.getEnable().toString());
			
			if(send_enable){
				String key =  config.getPreOne();
				
				if(mp.containsKey(key)){
					List ls2 = (List)mp.get(key);
					ls2.add(config);
					mp.put(key,ls2);
				}else{
					List ls2 = new ArrayList();
					ls2.add(config);
					mp.put(key,ls2);
				}
			}

			
		}
		
		
		Iterator it2 = mp.keySet().iterator();
		while(it2.hasNext()){
			String keyMast = it2.next().toString();
			Object obj = mp.get(keyMast);
			if(obj == null) obj = new ArrayList();
			List configs  = (List)obj;
			Map mp3 = new HashMap();
			for (Iterator it3 = configs.iterator();it3.hasNext();){
				ResourceChannelConfig config  = (ResourceChannelConfig) it3.next();
				String key =  config.getSendType().toString();
				if("1".equals(key)){
					Object obj2 = mp3.get(key);
					if(obj2 == null) obj2 = "";
					String v = (String)obj2;
					mp3.put(key,config.getSendAddress());
				}
                 if("2".equals(key)){
                	 mp3.put(key,config.getSendAddress()+"|"+config.getResourceSort()+"|"+config.getSendZeo());
				}
			}
			
			mp.put(keyMast,mp3);
		}

	    return mp;		
	}
	
	public static String getDayangWebServiceUrlProLitstParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getDayangWebServiceUrlProLitstParam())) sysParam.setDayangWebServiceUrlProLitstParam("http://10.77.82.91:8892/ADPINF/services/ImportProgramListService");
	    return sysParam.getDayangWebServiceUrlProLitstParam();		
	}
	
	
	public static int getOrderPublishTempleParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOrderPublishTempleParam())) sysParam.setOrderPublishTempleParam("0");
	    return Integer.parseInt(sysParam.getOrderPublishTempleParam());
	}
	
	public static boolean getWithoutSubmitParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getWithoutSubmit())) sysParam.setWithoutSubmit("0");
	    return (sysParam.getWithoutSubmit().equals("1"))?true:false;
	}
	public static boolean getPermitModAdverParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getPermitModAdverParam())) sysParam.setPermitModAdverParam("0");
	    return (sysParam.getPermitModAdverParam().equals("1"))?true:false;
	}
	
	public static boolean getOrderDisplayRelcodeParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOrderDisplayRelcodeParam())) sysParam.setOrderDisplayRelcodeParam("0");
	    return (sysParam.getOrderDisplayRelcodeParam().equals("1"))?true:false;
	}
	
	public static boolean getAllowModiyPassedOrderParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getAllowModiyPassedOrderParam())) sysParam.setAllowModiyPassedOrderParam("0");
	    return (sysParam.getAllowModiyPassedOrderParam().equals("1"))?true:false;
	}
	
	
	public static boolean getOneOrgMoreSuborgsParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOneOrgMoreSuborgsParam())) sysParam.setOneOrgMoreSuborgsParam("0");
	    return (sysParam.getOneOrgMoreSuborgsParam().equals("1"))?true:false;
	}
	
	//判断是否启用多载体
	public static boolean useMoreCarrierSortParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getUseMoreCarrierSortParam())) sysParam.setUseMoreCarrierSortParam("0");
//	    Map mp = getOrgTypeMap();
//	    return (sysParam.getUseMoreCarrierSortParam().equals("1"))||mp.size()>0?true:false;
	    return (sysParam.getUseMoreCarrierSortParam().equals("1"))?true:false;
	}
	
	//判断是否启用多载体
	public static boolean useLanmuSingleParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getUseLanmuSingleParam())) sysParam.setUseLanmuSingleParam("0");
	    return (sysParam.getUseLanmuSingleParam().equals("1"))?true:false;
	}
	
	public static boolean isSignUserBalance(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getIsSignUserBalance())) sysParam.setIsSignUserBalance("0");
	    return ("0".equals(sysParam.getIsSignUserBalance()) || sysParam.getIsSignUserBalance() == null)?false:true;
	}
	public static boolean isAutoTapeCode(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		return ("0".equals(sysParam.getAdverCodeModelParam())|| sysParam.getAdverCodeModelParam() == null)?false:true;
	}
	
	public static boolean isUserOrderYearRel(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		return ("0".equals(sysParam.getIsUserOrderYearRel())|| sysParam.getIsUserOrderYearRel() == null)?false:true;
	}
	
	
	public static boolean getIndustryLevel2Param(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		return ("0".equals(sysParam.getIndustryLevelParam())|| sysParam.getIndustryLevelParam() == null)?false:true;
	}
	
	public static boolean getOrderDisplayIncomeParam(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		return ("0".equals(sysParam.getOrderDisplayIncomeParam())|| sysParam.getOrderDisplayIncomeParam() == null)?false:true;
	}
	
	public static boolean getFastSignOrderParam(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		return ("0".equals(sysParam.getFastSignOrderParam())|| sysParam.getFastSignOrderParam() == null)?false:true;
	}	
	
	
	
	
	public static  boolean getArrangeWithBrandParamParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getArrangeWithBrandParam())) sysParam.setArrangeWithBrandParam("0");
	    return (sysParam.getArrangeWithBrandParam().equals("0"))?false:true;
	}
	
	public static  boolean getPublicAdAutoFillParamParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getPublicAdAutoFill())) sysParam.setPublicAdAutoFill("0");
	    return (sysParam.getPublicAdAutoFill().equals("0"))?false:true;
	}
	
	public static  boolean getResconfigOrderbyTimeParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getResconfigOrderbyTime())) sysParam.setResconfigOrderbyTime("0");
	    return (sysParam.getResconfigOrderbyTime().equals("0"))?false:true;
	}
	

//	开启订单类别过滤
	public static boolean getFinancialAudit(){
		String v = (String) Constants.APPLACTION_MAP.get(Constants.FINANCIA_AUDIT_PARAM);
		System.out.println("getFinancialAudit>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888 v >>>>>>>>>>>>>>>>"+ v) ;
		return ("0".equals(v)|| "false".equals(v)||v == null)?false:true;
	}	
	
	//开启审计功能
	public static boolean getFinancialAuditSwitch(){
		String v = (String) Constants.APPLACTION_MAP.get(Constants.FINANCIAL_AUDIT_SWITCH);
//		System.out.println("getFinancialAuditSwitch>>>>>>>>>>>>>>>>>>>>>>>>>>>8888888888888 v >>>>>>>>>>>>>>>>"+ v) ;
		return ("0".equals(v)|| "false".equals(v)||v == null)?false:true;
	}
	public static List getFitterOrderSubCates(String verion){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_ORDER_SUBCATES);
		Object obj = mp.get(verion);
		List ls = new ArrayList();
		if(obj != null ) ls = (List)obj;
		return ls;
	}
	
	public static List getFitterOrderSubCatesWithout(String verion){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_ORDER_SUBCATES_WITHOUT);
		Object obj = mp.get(verion);
		List ls = new ArrayList();
		if(obj != null ) ls = (List)obj;
		return ls;
	}
	
	
	public static List getFitterIncomePours(String verion){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_INCOME_POURS);
		Object obj = mp.get(verion);
		List ls = new ArrayList();
		if(obj != null ) ls = (List)obj;
		return ls;
	}	
	public static List getFitterIncomePoursWithout(String verion){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_INCOME_POURS_WITHOUT);
		Object obj = mp.get(verion);
		List ls = new ArrayList();
		if(obj != null ) ls = (List)obj;
		return ls;
	}		
	
	public static boolean getAutoRelationCodeParam(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		return ("0".equals(sysParam.getAutoRelationCodeParam())|| sysParam.getAutoRelationCodeParam() == null)?false:true;
	}
	
	 //订单多频道
	public static boolean getorderMoreCarrierParam(){
		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		return ("0".equals(sysParam.getOrderMoreCarrier())|| sysParam.getOrderMoreCarrier() == null)?false:true;
	}
	
	// 新签订单广告排期默认月份,默认当前月份+2
	public static String getOrderArrangDefaultMonthsParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOrderArrangDefaultMonths())) sysParam.setOrderArrangDefaultMonths("2");
	    return sysParam.getOrderArrangDefaultMonths();		
	}
	
	
	public static String getUserOrgs(String loginUser){
		loginUser = (loginUser == null||"".equals(loginUser))?UserUtil.getCurrentPrincipalUser():loginUser;
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.GLOBAL_CUSRUSER_ORGS);
//		StringUtil.null2String(mp.get(loginUser))
		Object obj = mp.get(loginUser);
		if(obj == null){
			return "";
		}else{
			return (String) mp.get(loginUser);
		}
	}
	
	public static String getPriceTypeNameById(String id){
		List list = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_PRICETYPE);
		Map mp = ConvertUtil.convertListToMap(list,"id");
		Object o = mp.get(id);
		return ConvertUtil.convertObjectBykeyPropertyName( o,"priceTypeName");
	}
	
	
	
	public static String getDatabaseBackPath(){
		return (String) Constants.APPLACTION_MAP.get(Constants.FILE_DBBACKUP_DIR);

	}
	
	public static String getOrgTypeById(String orgId){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
		Org org = (Org)mp.get(orgId);
		
//		System.out.println(" getOrgTypeById >>>wwwwwwwwwwwwwwwwwwwww >>>orgId>>>>>>" + orgId);
		
		return org.getOrgType();

	}
	
	public static List getOrgChileds(String orgId){
//		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
//		Org org = (Org)mp.get(orgId);
//		String parentId = org.getParentId();
		Org orgP = new Org();orgP.setParentId(orgId);
		List ls = ServiceLocator.getOrgDao().getOrgs(orgP);
		Object[] objs = ConvertUtil.getColFromList(ls,"id");
		List list = new ArrayList();
		org.apache.commons.collections.CollectionUtils.addAll(list,objs);
		return list;
//		return "0".equals(parentId)?true:false;
	}	
	
	
	
	public static String getOrgTypeByTypeId(String typeId){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_TYPES_MAP);
		
		System.out.println(" getOrgTypeByTypeId >>>>>>>  mp.size() >>>>>>>" + mp.size());
		
		CarrierType carrierType= (CarrierType)mp.get(typeId);
		
		System.out.println(" getOrgTypeByTypeId >>>>>>> carrierType >>>>>>>" + carrierType);
		System.out.println(" getOrgTypeByTypeId >>>>>>> carrierType >>>>>>>" + carrierType.toString());
		
		return getOrgTypeById(carrierType.getOrgId().toString());

	}

	
	
	public static String getAdrmSysYearProgramList(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	   	return sysParam.getAdrmSysYearProgramList();		
	}
	public static boolean getOrderBasePriceEnableModyParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    String v = sysParam.getOrderBasePriceEnableModyParam();	
	    return ("0".equals(v)|| "false".equals(v)||v == null)?false:true;
	}
	
	public static boolean getResourceUseCustomerCatelogParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    String v = sysParam.getResourceUseCustomerCatelog();
	    return ("0".equals(v)|| "false".equals(v)||v == null)?false:true;
	}
	
	public static boolean getOutLimitBroarrangParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    String v = sysParam.getOutLimitBroarrang();
	    return ("0".equals(v)|| "false".equals(v)||v == null)?false:true;
	}
	
	
	 public  String getGlobalParams(String loginName){
	   	 WebContext ctx = WebContextFactory.get();
	     HttpServletRequest request = ctx.getHttpServletRequest();
	     return getGlobalParams_base(request,loginName);
    }
	 

	 
	 public  static String getGlobalParams_base(HttpServletRequest request,String loginName){

			  HttpSession session = request.getSession();
//			  boolean isNewSession = !session.getId().equals((String)session.getAttribute("session_id"));
		     String result ="";
		     Map mp = new HashMap();
		     
//				log.info(">>>>>>>>>>>>>getGlobalParams loginName 1>>>>>>>>>>>>>>>>" +loginName);
//				log.info(">>>>>>>>>>>>>getGlobalParams old session >>>>>>>>>>>>>>>>" +(String)session.getAttribute("session_id"));
//				log.info(">>>>>>>>>>>>>getGlobalParams cur session >>>>>>>>>>>>>>>>" +session.getId());

//		     if(loginName == null || "".equals(loginName)) loginName = UserUtil.getCurrentPrincipalUser();
		     
		     loginName = UserUtil.getCurrentPrincipalUser();
		     
		     if(!"anonymous".equals(loginName)){
		    	 

		    	 String param_key = "_param";
		    	 String user_key = "_uid";
		    	 String loginUser = StringUtil.getNullValue(session.getAttribute(user_key),"");
//		    	 log.info(">>>>>>>>>>>>>getGlobalParams loginUser 1>>>>>>>>>>>>>>>>" +loginUser);
		    	 
		    	 if(session.getAttribute(param_key) == null || !loginUser.equals(loginName) ){
			    	 
			    	  Map paramMap = (Map)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAMS);
			    	  
//			    	  log.info(">>>>>>>>>>>>>getGlobalParams loginName 2>>>>>>>>>>>>>>>>" +loginName);

		              User u = UserUtil.getUserByUserName(loginName);
		              
//		              log.info(">>>>>>>>>>>>>getGlobalParams User>>>>>>>>>>>>>>>>" +u.getFullName());
		              
		              String userOrgIds = UserUtil.getUserOrgs(loginName);
		              
//		              log.info(">>>>>>>>>>>>>getGlobalParams userOrgIds>>>>>>>>>>>>>>>>" +userOrgIds);
		              
		              List lsOrgs = UserUtil.getUserOrgsObj(loginName);
		              List lsOrgsub = UserUtil.getUserOrgsObjSub(loginName);
//		              log.info(">>>>>>>>>>>>>getGlobalParams lsOrgs>>>>>>>>>>>>>>>>" +lsOrgs.size());
		              
		              String user_rights = StringUtil.null2String(u.getAddress().getProvince());
		              
		              long end3 = System.currentTimeMillis();
		              //用户资源授权
		              Map rightsMap = new HashMap();
		              UserUtil.isGrandedRes(loginName,rightsMap); 
		              log.info(">>>>>>>>>>>>>getGlobalParams>>>rightsMap>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +rightsMap.size());

		              String isInc = user_rights.indexOf("1")>-1?"1":"0";
		              String isCuik = user_rights.indexOf("2")>-1?"1":"0"; 
		              rightsMap.put("userOrgs",lsOrgs);
		              rightsMap.put("userOrgsub",lsOrgsub);
		              
		              rightsMap.put("userOrgIds",userOrgIds);
		              rightsMap.put("incomeMessageAlert",isInc);
		              rightsMap.put("cuikMessageAlert",isCuik);
		              long end4 = System.currentTimeMillis();
		              System.out.println("UserUtil.isGrandedRes>>>>>>>>   "+ (end4 -end3) +"秒");
		              mp.put("ctxPath",request.getContextPath()+"/");
		              
		               Constants.APPLACTION_MAP.put(Constants.SELET_CONPTCH,request.getContextPath()+"/");
		               
		              mp.put("serviceDate",DateUtil.getServiceDateMap());
		              mp.put("sysParam",paramMap);
		              mp.put("user",u);
		              mp.put("rights",rightsMap);
		              mp.put("isFirstLogin","1");
		              mp.put("orgTypes",getOrgTypeMap());
		              mp.put("orderCateMain",OrderCateUtil.getOrderCateMain_Map());

		              session.setAttribute(param_key,mp);
		              
			     }else{
			    	 mp = (Map)session.getAttribute(param_key);
			    	 mp.put("isFirstLogin","2");
			    	 
//			    	 log.info(">>>>>>>>>>>>>getGlobalParams> from session >>>>>>>>>>>>>>>" );
			     }
		    	 
		    	 session.setAttribute(user_key,loginName);
//			     session.setAttribute("session_id",session.getId());
	    
		         JsonUtil.setInclueFields(new String[]{"id","name","username","fullName","address","province","calculateAuto","value"});
		         result = JsonUtil.encodeMap(mp);
		     }
		    	 
		    


//        	log.info(">>>>>>>>>>>>>getGlobalParams>>>>>>>>>>>>>>>>" +result);


        	return result; 
    }	 
	 
	 
//	   public static Map getOrgTypeMap(List lsOrgs) {
//
//	       Map serviceDateMap = new HashMap(); 
//		   for(Iterator it = lsOrgs.iterator();it.hasNext();){
//		  		  Org org = (Org)it.next();
//		  		  log.info(">>>>>>>>>>>>>getGlobalParams>>>>>>>>>>>>>>>>" +org);
//		  		  serviceDateMap.put(org.getId().toString(),org.getOrgType());
//		   }
//
//		   return serviceDateMap;
//	    }

	   public static Map getOrgTypeMap() {
		   Map mpp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORG);
	       Map serviceDateMap = new HashMap(); 
		   for(Iterator it = mpp.keySet().iterator();it.hasNext();){
		  		  Org org = (Org)mpp.get(it.next().toString());
//		  		  log.info(">>>>>>>>>>>>>org>>>>>>>>>>>>>rrrrrrrrrrrrr>>>" +org.getOrgType());
		  		  serviceDateMap.put("orgId_"+org.getId().toString(),org.getOrgType());
		   }

		   return serviceDateMap;
	    }
	 
	 
    public  String getGlobalParams_bak(String loginName){
    	
    	 long start1 = System.currentTimeMillis();
    	 
	   	 WebContext ctx = WebContextFactory.get();
	     HttpServletRequest req = ctx.getHttpServletRequest();
	     HttpServletResponse rp = ctx.getHttpServletResponse();
	     HttpSession session = req.getSession();
	     String result ="";
	     Map mp = new HashMap();
	     
	     System.out.println("session.getId() 22222222222222>>>>ttttttttttttttttttttttttt>>>>   "+session.getId());
	     
	     
	        long end1 = System.currentTimeMillis();
//	        System.out.println("start>>>>>>>>   "+ (end1 -start1) +"秒");
	        

         loginName = StringUtil.getNullValue(loginName,"");
         
//         System.out.println("loginName 111111111111111111>>>>ttttttttttttttttttttttttt>>>>   "+loginName);
//        
      if("".equals(loginName) || loginName == null){
        

        String loginUser =StringUtil.getNullValue(session.getAttribute("uid"),"");
        
//        System.out.println("loginName 22222222222222>>>>ttttttttttttttttttttttttt>>>>   "+loginUser);
        
        if("".equals(loginUser)|| loginUser == null||"null".equals(loginUser)||"anonymous".equals(loginUser)){
        	
        	  loginName = UserUtil.getCurrentPrincipalUser();
        	  
//        	  System.out.println("loginName 333333333333333333333>>>>ttttttttttttttttttttttttt>>>>   "+loginName);
//        	  req.getHeader( "referer ");
//        	  System.out.println("loginName 444444444>>>>ttttttttttttttttttttttttt>>>>   "+req.getHeader("referer"));
        
        	  
        	  
        	  
        	  if("anonymous".equals(loginName)) {
        		  
        		  
        	  }
        	 
//            
        	  session.setAttribute("uid",loginName);
        }else{
        	loginName =loginUser;
        }
        
      }
        long end2 = System.currentTimeMillis();
//        System.out.println("UserUtil.getCurrentPrincipalUser>>>>>>>>   "+ (end2 -end1) +"秒");

        
       
        if(!loginName.equals("anonymous")){
        	
//        	 log.info(">>>>>>>>>>>>>getGlobalParams>>>loginName>>>>>>>>>>>>>" +loginName);
        	
        	
            if(session.getAttribute("param") == null){
//            	 log.info(">>>>>>>>>>>>>getGlobalParams>>>isGrandedRes>>>>>>>>>>>>>");
            	 
 
                 
                Map paramMap = (Map)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAMS);

                User u = UserUtil.getUserByUserName(loginName);
                String userOrgIds = UserUtil.getUserOrgs(loginName);
                List lsOrgs = UserUtil.getUserOrgsObj(loginName);
                List lsOrgsub = UserUtil.getUserOrgsObjSub(loginName);
                
               
                System.out.println(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +lsOrgs.size());

                String user_rights = StringUtil.null2String(u.getAddress().getProvince());
                
            
                long end3 = System.currentTimeMillis();
//                System.out.println("UserUtil.getUserByUserName>>>>>>>>   "+ (end3 -end2) +"秒");

                
                //用户资源授权
                Map rightsMap = new HashMap();
                UserUtil.isGrandedRes(loginName,rightsMap); 
           
//                Map rightsMap =  UserUtil.getGrandedResFromMapByUerName(loginName); 
                log.info(">>>>>>>>>>>>>1111111111111111111 2222222222222222        333333333333333333      >>>rightsMap>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +rightsMap.size());
                System.out.println(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +lsOrgs.size());
                System.out.println(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +lsOrgs.size());
                System.out.println(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +lsOrgs.size());
                System.out.println(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +lsOrgs.size());
                System.out.println(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +lsOrgs.size());
                System.out.println(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +lsOrgs.size());

                       
                
                
                String isInc = user_rights.indexOf("1")>-1?"1":"0";
                String isCuik = user_rights.indexOf("2")>-1?"1":"0"; 
                rightsMap.put("userOrgs",lsOrgs);
                rightsMap.put("userOrgsub",lsOrgsub);
                rightsMap.put("userOrgIds",userOrgIds);
                rightsMap.put("incomeMessageAlert",isInc);
                rightsMap.put("cuikMessageAlert",isCuik);
                
                
                
                long end4 = System.currentTimeMillis();
                
                System.out.println("UserUtil.isGrandedRes>>>>>>>>   "+ (end4 -end3) +"秒");
                
                
                mp.put("isFirstLogin","1");
                mp.put("ctxPath",req.getContextPath()+"/");
 
                Constants.APPLACTION_MAP.put(Constants.SELET_CONPTCH,req.getContextPath()+"/");
                
                log.info(">>>>>>>>>>>>>getGlobalParams>>>>req.getContextPath(>>>>>>>>>>>>" +req.getContextPath()+"/");
                
                mp.put("serviceDate",DateUtil.getServiceDateMap());
                
                mp.put("sysParam",paramMap);
                mp.put("user",u);
                
//                JsonUtil.setInclueFields(new String[]{"id","username","fullName","address","province"});
//                log.info(">>>>>>>>>>>>>getGlobalParams>>>>user>>>>>>>>>>>>" +JsonUtil.encodeBasic(u));
                mp.put("rights",rightsMap);
                
            	session.setAttribute("param",mp);
            	
            }else{
            	mp = (Map)session.getAttribute("param");
            	mp.put("isFirstLogin","2");
            }        	
           
 
            
            long end5= System.currentTimeMillis();
            JsonUtil.setInclueFields(new String[]{"id","name","username","fullName","address","province"});
//            JsonUtil.setExcludeFields(new String[]{"class","declaringClass","metaClass"});
            result = JsonUtil.encodeMap(mp);
            
//            JsonUtil.setExcludeFields(new String[]{"class","declaringClass","metaClass"});
//            result =jsonUtil.encodeMap(mp);
            
            long end6 = System.currentTimeMillis();
            System.out.println("jsonUtil.encodeMap>>>>>>>>   "+ (end6 - end5) +"秒");
        }


        
        if(log.isDebugEnabled()){
        	log.info(">>>>>>>>>>>>>getGlobalParams>>>>>>>>>>>>>>>>" +result);
        }


        
    	 return result; 
    }

	 public  static String checkIsInnerIP(){
         WebContext context = WebContextFactory.get();  
         HttpServletRequest request = context.getHttpServletRequest();
    	 String logoOrgName = StringUtil.getNullValue(Constants.APPLACTION_MAP.get(Constants.LOGO_ORG_NAME),"XX电视台");
    	 String softVerison = StringUtil.getNullValue(Constants.APPLACTION_MAP.get(Constants.SOFT_VERSION),"1.0");
    	 boolean enableRandCode = !RequestUtil.getReqInfo(request).getIsInnerIP();
         String jsonStr ="{logoOrgName:\'" + logoOrgName + "\', softVerison : \'" + softVerison + "\', enableRandCode : " + enableRandCode + "}" ;
		 return jsonStr;
	 }
//	 public  static boolean checkIsInnerIP(HttpServletRequest request){
//		 return !RequestUtil.getReqInfo(request).getIsInnerIP();
//	 } 

}
