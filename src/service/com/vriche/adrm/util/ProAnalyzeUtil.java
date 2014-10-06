package com.vriche.adrm.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.ParamClass;

public class ProAnalyzeUtil {
	public static  String makeProCostAnalyzeGridXML(List all){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = all.iterator();it.hasNext();){
			ParamClass obj = (ParamClass)it.next();
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getProgramName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getPayMoney())  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public static  String makeProAudiemceAnalyzeGridXML(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		Map mapProgramName = (Map)map.get("mapProgramName");
		Map mp = (Map)map.get("mapCarrier");
		String type = (String)map.get("type");
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapProgramName") && !key.equals("mapCarrier") && !key.equals("type")){
				ParamClass obj = (ParamClass)mapProgramName.get(key);	
				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ key +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(obj.getAudienceRat())) +"]]></cell>");
				makeCarrChiled(mp,sb,key,type);
				sb.append("</row>");
			}
		}
		sb.append("</rows>");
		return sb.toString();
	}
	private static void makeCarrChiled(Map mp,StringBuffer sb,String proName,String type){
		int i=1;
		Map carrName = (Map)getCarrierNameMap();
		Map mapCarrierName = (Map)mp.get("mapCarrierName");
		for(Iterator it = mp.keySet().iterator(); it.hasNext();){
			String key1 =(String)it.next();
			if(!key1.equals("mapCarrierName")){
				String carr[] = key1.split("%%");
				String programName = carr[0];
				String carrierId = carr[1];
				String carrierName = (String)carrName.get(carrierId);
				carrierName = carrierName==null?"":carrierName ;
				if(programName.equals(proName)){
					ParamClass obj = (ParamClass)mapCarrierName.get(key1);
					List audienceRatList = (List)mp.get(key1);
					sb.append("<row  id=\""+ proName+"_" + i++  +"\">");
					sb.append("<cell image=\"folder.gif\">"+ "" +"</cell>");
					sb.append("<cell><![CDATA["+ carrierName  +"]]></cell>");
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(obj.getAudienceRat())) +"]]></cell>");
					makeChiled(audienceRatList,key1,sb,type);
					sb.append("</row>");
				}
			}
		}	
	}
	private static void makeChiled(List oneAudiRat,String key,StringBuffer sb,String type){
		Map carrName = (Map)getCarrierNameMap();
		int i=1;
		for(Iterator it = oneAudiRat.iterator();it.hasNext();){
			ParamClass paramClass = (ParamClass)it.next();
			String carrierName = (String)carrName.get(paramClass.getCarrierId());
			carrierName = carrierName==null?"":carrierName ;
			sb.append("<row  id=\""+ key+"__" + i++  +"\">");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+  "" +"]]></cell>");
			if(type.equals("1")){
				sb.append("<cell><![CDATA["+  paramClass.getStartDate()+"]]></cell>");
			}else{
				sb.append("<cell><![CDATA["+  DateUtil.SetDateFormat(paramClass.getStartDate(),"yyyy/MM/dd") +"]]></cell>");
			}

			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(paramClass.getAudienceRat())) +"]]></cell>");
			sb.append("</row>");
//			DateUtil.SetDateFormat(paramClass.getStartDate(),"yyyy/MM/dd")
		 }	
	}
    public static Map getCarrierNameMap() {
    	Map mp = new HashMap();
    	Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
    	for(Iterator it = carrierMp.values().iterator();it.hasNext();){
    		Carrier carr = (Carrier) it.next();
    		mp.put(carr.getId().toString(),carr.getCarrierName());
    	}
    	return mp;
    }
	
	public static  String makeProgramIncomeAnalyzeGridXML(List all){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		int i = 1;
		for(Iterator it = all.iterator();it.hasNext();){
			ParamClass obj = (ParamClass)it.next();
			String programName = obj.getProgramName() ;
			Double secMoney = obj.getPayMoney() ;
			Double firMoney = obj.getDayRelIncome()==null?new Double(0):obj.getDayRelIncome() ;
			Double totalMoney =obj.getTotalIncome();
			sb.append("<row  id=\""+ i++  +"\"" +">");
			sb.append("<cell><![CDATA["+ programName  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(firMoney)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(secMoney)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(totalMoney)  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public static  String makeCostIncomeAudienceAnalyzeGridXML(List all){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		int i = 1;
		for(Iterator it = all.iterator();it.hasNext();){
			ParamClass obj = (ParamClass)it.next();
			String programName = obj.getProgramName() ;
			Double costMoney = obj.getPayMoney()==null?new Double(0):obj.getPayMoney();
			Double totalMoney = obj.getTotalIncome()==null?new Double(0):obj.getTotalIncome();
			Double audienceRat = obj.getAudienceRat()==null?new Double(0):new Double(obj.getAudienceRat());
			sb.append("<row  id=\""+ i++  +"\"" +">");
			sb.append("<cell><![CDATA["+ programName  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(costMoney)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(totalMoney)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(audienceRat)  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	public static  String makeProgramCostIncomeAudienceAnalyzeGridXML(List all){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		int i = 1;
		for(Iterator it = all.iterator();it.hasNext();){
			ParamClass obj = (ParamClass)it.next();
			String programName = obj.getProgramName();
			String introMoney=obj.getTotal()==null?"":obj.getTotal();
			Double costMoney = obj.getPayMoney()==null?new Double(0):obj.getPayMoney();
			Double adverMoney = obj.getDayRelIncome()==null?new Double(0):obj.getDayRelIncome();
			Double sellMoney = obj.getRelIncome()==null?new Double(0):obj.getRelIncome();
			Double audienceRat = obj.getAudienceRat()==null?new Double(0):new Double(obj.getAudienceRat());
			sb.append("<row  id=\""+ i++  +"\"" +">");
			sb.append("<cell><![CDATA["+ programName  +"]]></cell>");
			sb.append("<cell><![CDATA["+ introMoney  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(costMoney)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(sellMoney)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(adverMoney)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(audienceRat)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
}

