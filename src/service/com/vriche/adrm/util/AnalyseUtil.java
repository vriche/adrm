package com.vriche.adrm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.AnalyzeClass;

public class AnalyseUtil {
	public static  String makeOrderCategoryXML(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  

		Map mapOrderCategory = (Map)map.get("mapOrderCategory");
		
		double res[] = new  double[3];
		double sum = ((Double)map.get("relPaySum")).doubleValue();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapOrderCategory") && !key.equals("relPaySum")){
				AnalyzeClass analyzeClass = (AnalyzeClass)mapOrderCategory.get(key);
				Double relIncome = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
				Double sysPrice = analyzeClass.getRelPay()== null?new Double(0):analyzeClass.getRelPay();
				Double times = analyzeClass.getTimeUsed();
				
				res[0] += relIncome.doubleValue();
				res[1] += sysPrice.doubleValue();
				res[2] += times.doubleValue();				
				double youHuiPrice= analyzeClass.getRelPay().doubleValue()- analyzeClass.getRelIncome().doubleValue();
				List cutList = (List)map.get(key);
				//订单类别  客户名称 刊例总价 投放金额 优惠金额 投放时长 折扣 刊例比例
				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ key +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelPay())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(youHuiPrice))  +"]]></cell>");
				
				String s = DateUtil.formatLongToTimeStr(new Long(Float.valueOf(analyzeClass.getTimeUsed().toString()).longValue()*1000));
				sb.append("<cell><![CDATA["+ s +"]]></cell>");
//				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(analyzeClass.getTimeUsed())  +"]]></cell>");
				
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(analyzeClass.getRelIncome().doubleValue(),analyzeClass.getRelPay().doubleValue()) +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(analyzeClass.getRelPay().doubleValue(),sum) +"]]></cell>");
				makeChiled(cutList,key,sb,analyzeClass.getRelPay().doubleValue());
				sb.append("</row>");
			}
		}
		if(map.keySet().size() >0){
			sb.append("<row  id=\""+ "total"   +"\">");
			sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[1]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[1]-res[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[2]))  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");
		return sb.toString();
	}
	private static void makeChiled(List oneOrderCategory,String key,StringBuffer sb,double relPay){
		int i=1;
		for(Iterator it = oneOrderCategory.iterator();it.hasNext();){
			AnalyzeClass analyzeClass =(AnalyzeClass) it.next();
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ analyzeClass.getResourceName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelPay())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(analyzeClass.getRelPay().doubleValue()-analyzeClass.getRelIncome().doubleValue())) +"]]></cell>");
			
			
			String s = DateUtil.formatLongToTimeStr(new Long(Float.valueOf(analyzeClass.getTimeUsed().toString()).longValue()*1000));
			sb.append("<cell><![CDATA["+ s +"]]></cell>");
//			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(analyzeClass.getTimeUsed())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(analyzeClass.getRelIncome().doubleValue(),analyzeClass.getRelPay().doubleValue()) +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(analyzeClass.getRelPay().doubleValue(),relPay) +"]]></cell>");
			sb.append("</row>");
		 }	
	}

	 public static synchronized void makeTreeGridXML(StringBuffer sb,List all){
	 	sb.delete(0,sb.length());
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		int i=0;
		for(Iterator it = all.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass)it.next();
			Double relPay = analyzeClass.getRelPay() == null?new Double(0):analyzeClass.getRelPay();
			Double realIncom = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
			Double sumTimes = analyzeClass.getSumTimes();
			Double youHuiPrice = analyzeClass.getTimeUsed();
			
			sb.append("<row  id=\""+ i++  +"\">");
			sb.append("<cell><![CDATA["+ analyzeClass.getMatterName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(relPay)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(realIncom)  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(youHuiPrice)  +"]]></cell>");
			
			String s = DateUtil.formatLongToTimeStr(new Long(Float.valueOf(sumTimes.toString()).longValue()*1000));
			sb.append("<cell><![CDATA["+ s  +"]]></cell>");		 	
//			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(sumTimes)  +"]]></cell>");		
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(realIncom.doubleValue(),relPay.doubleValue())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ analyzeClass.getSumUsed() +"]]></cell>");
			sb.append("</row>");
		 }
		sb.append("</rows>");
	  }
	 
	public static  String makeCarrierBasalGridXML(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		Map mapCarrierBasal = (Map)map.get("mapCarrierBasal");
		double res[] = new  double[2];
		double sum = ((Double)map.get("relIncomeSum")).doubleValue();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapCarrierBasal") && !key.equals("relIncomeSum")){
				AnalyzeClass analyzeClass = (AnalyzeClass)mapCarrierBasal.get(key);
				System.out.println("key<<<<<<<<<<<<<<<<<<<<<<"+key);
				
				
				String carrierName = analyzeClass.getResourceName();
				
				System.out.println("carrierName<<<<<<<<<<<<<<<<<<<<<<"+carrierName);
				
				Double relIncome = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
				Double times = analyzeClass.getSumTimes();
				
				res[0] += relIncome.doubleValue();
				res[1] += times.doubleValue();				
				List cutList = (List)map.get(key);
				//频道名称  段位名称 投放金额 时间 投放比例
				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ carrierName +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(analyzeClass.getRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(analyzeClass.getSumTimes())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(analyzeClass.getRelIncome().doubleValue(),sum) +"]]></cell>");
				makeChiled1(cutList,key,sb,analyzeClass.getRelIncome().doubleValue());
				sb.append("</row>");
			}
		}
		
		if(map.keySet().size() >0){
			sb.append("<row  id=\""+ "total"   +"\">");
			sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[1]))  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");
		return sb.toString();
	}
		
	private static void makeChiled1(List oneOrderCategory,String key,StringBuffer sb,double relIncome){
		int i=1;
		for(Iterator it = oneOrderCategory.iterator();it.hasNext();){
			AnalyzeClass analyzeClass =(AnalyzeClass) it.next();
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ analyzeClass.getCarrierName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(analyzeClass.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(analyzeClass.getSumTimes())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(analyzeClass.getRelIncome().doubleValue(),relIncome) +"]]></cell>");
			sb.append("</row>");
		 }	
	}
	
	public static  String makeAreaCustomerXML(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  

		Map mapAreaCustomer = (Map)map.get("mapAreaCustomer");
		double res[] = new  double[2];
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
//			System.out.println("it333333333333333<<<<<<<<<<<<<<<<<<<<<<"+ it.next());
			String key = (String)it.next();
			
			if(!key.equals("mapAreaCustomer")){
				AnalyzeClass analyzeClass = (AnalyzeClass)mapAreaCustomer.get(key);
				System.out.println("it333333333333333<<<<<<<<<<<<<<<<<<<<<<"+ analyzeClass.getRelIncome());
				Double relIncome = analyzeClass.getRelIncome() == null?new Double(0):analyzeClass.getRelIncome();
				Double sysPrice = analyzeClass.getRelPay()== null?new Double(0):analyzeClass.getRelPay();
				
				res[0] += relIncome.doubleValue();
				res[1] += sysPrice.doubleValue();		
				List cutList = (List)map.get(key);
				//区域名称  客户名称  投放金额 到款金额

				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ key +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelPay())  +"]]></cell>");
				makeChiledArea(cutList,key,sb);
				sb.append("</row>");
			}
		}
		
		
		if(map.keySet().size() >0){
			
			sb.append("<row  id=\""+ "total"   +"\">");
			sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[1]))  +"]]></cell>");
			sb.append("</row>");
		
		}
		sb.append("</rows>");
		
		return sb.toString();
	}	

	private static void makeChiledArea(List oneAeraCutomer,String key,StringBuffer sb){
		int i=1;
		for(Iterator it = oneAeraCutomer.iterator();it.hasNext();){
			AnalyzeClass analyzeClass =(AnalyzeClass) it.next();
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ analyzeClass.getResourceName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(analyzeClass.getRelPay())  +"]]></cell>");
			sb.append("</row>");
		 }	
	}
}
