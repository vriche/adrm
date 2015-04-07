package com.vriche.adrm.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.FusionChartObject;

public class FinanceTargetUtil {
	
	public static  String makeFinanceTargetsGridXML(List all){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		int j=1;
		for(Iterator it = all.iterator();it.hasNext();){
			FinanceTarget obj = (FinanceTarget)it.next();
			sb.append("<row  id=\""+ j++  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getCarrierId()  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ obj.getTargetDateYear()  +"]]></cell>");
			for(int i=0;i<13;i++){
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(obj.getTarMonths()[i])  +"]]></cell>");
//				System.out.println("obj.getTarMonths()["+ i +"]>>>>>>>>>>>>>>>>>>>>21<<<<<<<<<<<<<<"+obj.getTarMonths()[i]);
			}
//			sb.append("<cell><![CDATA["+ j++  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public static  String makeFinanceTargetRatiosGridXML(Collection all){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		int j=1;
		for(Iterator it = all.iterator();it.hasNext();){
			FusionChartObject obj = (FusionChartObject)it.next();
			sb.append("<row  id=\""+ j++  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getLable()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getValue1() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat33(obj.getValue2())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getValue3() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat33(obj.getValue4())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat33(obj.getValue5())  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public static  String makeYearTargetGridXML(List all,int size){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		int j=1;
		for(Iterator it = all.iterator();it.hasNext();){
			FinanceTarget obj = (FinanceTarget)it.next();
			sb.append("<row  id=\""+ j++  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getCarrierName()  +"]]></cell>");

			for(int i=0;i<size;i++){
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(obj.getTarMonths()[i])  +"]]></cell>");
				sb.append("<userdata name=\"value\">"+ StringUtil.doubleFormat3(obj.getTarMonths()[i]) +"</userdata>");	
//				System.out.println("obj.getTarMonths()["+ i +"]>>>>>>>>>>>>>>>>>>>>1111111111<<<<<<<<<<<<<<"+obj.getTarMonths()[i]);
			}

			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	
	public static  String makeCarrierBasalGridXML(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
//		StringUtilsv.printMap(map); 4095 8666
		

		Map mapCarrierBasal = (Map)map.get("mapCarrierBasal");
		
		double res[] = new  double[3];

		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
//			System.out.println("getCarrierTargetByListDetails FTarget>>>>>>6666666666 77777777 88888888>>>>>>>>>>>>>"+key); 
			
			if(!key.equals("mapCarrierBasal")){
				
				FinanceTarget financeTarget = (FinanceTarget)mapCarrierBasal.get(key);
				String carrierName = financeTarget.getCarrierName();
				
//				System.out.println("getCarrierTargetByListDetails FTarget>>>>>>6666666666 77777777 88888888>>>>>>>>>>>>>"+carrierName); 
				
				Double relIncome = financeTarget.getRelIncome();
//				Double times = financeTarget.getSumTimes();
				Double TargetMoney = financeTarget.getTargetMoney();
				Double relPut = financeTarget.getRelPut();
//				System.out.println("util ---relput"+relPut);
				res[0] += TargetMoney.doubleValue();
				res[1] += relIncome.doubleValue();
				res[2] += relPut.doubleValue();
				List cutList = (List)map.get(key);
				
				//频道名称  段位名称 投放金额 时间 投放比例
//				sb.append("<row  id=\""+ key   +"\" open=\"1\">");
				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ carrierName +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(relPut)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(relIncome)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(TargetMoney) +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(financeTarget.getRelPut().doubleValue(),financeTarget.getTargetMoney().doubleValue()) +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(financeTarget.getRelIncome().doubleValue(),financeTarget.getTargetMoney().doubleValue()) +"]]></cell>");
				makeChiled1(cutList,key,sb);
				sb.append("</row>");
			}
		}
		
		
		if(map.keySet().size() >0){
			sb.append("<row  id=\""+ "total"   +"\">");
			sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[2]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[1]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(res[2],res[0])   +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(res[1],res[0])  +"]]></cell>");
			sb.append("</row>");
		
		}
		sb.append("</rows>");
		
		return sb.toString();
	}	
	private static void makeChiled1(List oneOrderCategory,String key,StringBuffer sb){
		int i=1;
		for(Iterator it = oneOrderCategory.iterator();it.hasNext();){
			FinanceTarget financeTarget =(FinanceTarget) it.next();
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");
//			sb.append("<cell>"+ key +"</cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.converNum2cnMonth(financeTarget.getTargetMonth().toString())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(financeTarget.getRelPut())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(financeTarget.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(financeTarget.getTargetMoney())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(financeTarget.getRelPut().doubleValue(),financeTarget.getTargetMoney().doubleValue())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(financeTarget.getRelIncome().doubleValue(),financeTarget.getTargetMoney().doubleValue())  +"]]></cell>");
			sb.append("</row>");
		 }	
	}

}
