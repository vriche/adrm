package com.vriche.adrm.util;

import java.util.Iterator;
import java.util.List;

import com.vriche.adrm.model.IncomePull;

public class AnalyCustomerIncomeMoneyUtil{
	 public static synchronized void makeTreeGridXML(StringBuffer sb,List all,String arrears){
//		    double sumIncomeMoney = 0;
//		    double sumMoneyPull = 0;
//		    double sumMoneyIn = 0;
//		    double sumArrearMoney = 0;

		    int size = all.size();
		    sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");    
			int i=0;
			for(Iterator it = all.iterator();it.hasNext();){
				IncomePull incomePull = (IncomePull)it.next();
				i++;
//				String incomeMoney =(incomePull.getIncomeMoney()==null||incomePull.getIncomeMoney()==new Double(0))?"0":incomePull.getIncomeMoney().toString();
				String moneyIn = (incomePull.getMoneyIn()==null||incomePull.getMoneyIn()==new Double(0))?"0":incomePull.getMoneyIn().toString();
				String moneyPull =(incomePull.getMoneyPull()==null||incomePull.getMoneyPull()==new Double(0))?"0":incomePull.getMoneyPull().toString();
				
				String arrearMoney =(incomePull.getArrearMoney()==null)?"0":incomePull.getArrearMoney().toString();
//				if(Double.valueOf(arrearMoney).doubleValue() == 0) arrearMoney ="0";
//				if(Double.valueOf(incomeMoney).doubleValue() == 0) incomeMoney ="0";
				
				String incomeDate = DateUtil.SetDateFormat(incomePull.getIncomeDate(),"yyyy/MM/dd");
				double dIn = incomePull.getIncomeMoney().doubleValue();
				double dPull = new Double(moneyPull).doubleValue();
				double dPut = new Double(moneyIn).doubleValue();
				double dArr = dPull - dPut;
				boolean isArr = arrears.equals("1");
				
				moneyPull = String.valueOf(dPull);
				moneyIn = String.valueOf(dPut);
				arrearMoney = String.valueOf(dArr);
				
//				System.out.println("dArr>>>>>>>>>>>    "+dArr);
//				System.out.println("arrears>>>>>>>>>>>    "+arrears);
//				System.out.println("isArr>>>>>>>>>>>    "+isArr);
				
				if(isArr){
					if(dArr>0){
						 sb.append("<row  id=\""+ i +"\">");
						 sb.append("<cell><![CDATA["+ incomeDate +"]]></cell>");
						 sb.append("<cell><![CDATA["+ incomePull.getIncomeCode() +"]]></cell>");
						 
						 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(dIn))+"]]></cell>");
						
						 
						 sb.append("<cell><![CDATA["+ StringUtil.getNullValue(incomePull.getCarrier().getCarrierName(),"") +"]]></cell>");
						 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(moneyPull))+"]]></cell>");
						 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(moneyIn)) +"]]></cell>");
						 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(arrearMoney)) +"]]></cell>");
						 if(i == size){
							 sb.append("<cell><![CDATA["+ "µ½ÕË"+ (size-1) +"±Ê"+"]]></cell>"); 
						 }else{
							 sb.append("<cell><![CDATA["+ incomePull.getCustomerName() +"]]></cell>");
						 }
						
						 sb.append("<cell><![CDATA["+ incomePull.getFullName()+"]]></cell>");
						 sb.append("<cell><![CDATA["+ incomePull.getModeName() +"]]></cell>");
						 sb.append("<cell><![CDATA["+ incomePull.getPurposeName() +"]]></cell>");
						 sb.append("<cell><![CDATA["+ incomePull.getFullName()+"]]></cell>");
						 
						 sb.append("<cell><![CDATA["+ incomePull.getMemo()+"]]></cell>");
						 sb.append("</row>");						
					}

				}else{
					 sb.append("<row  id=\""+ i +"\">");
					 sb.append("<cell><![CDATA["+ incomeDate +"]]></cell>");
					 sb.append("<cell><![CDATA["+ incomePull.getIncomeCode() +"]]></cell>");
					 
					 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(dIn))+"]]></cell>");
					
					 
					 sb.append("<cell><![CDATA["+ StringUtil.getNullValue(incomePull.getCarrier().getCarrierName(),"") +"]]></cell>");
					 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(moneyPull))+"]]></cell>");
					 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(moneyIn)) +"]]></cell>");
					 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(arrearMoney)) +"]]></cell>");
					 if(i == size){
						 sb.append("<cell><![CDATA["+ "µ½ÕË"+ (size-1) +"±Ê"+"]]></cell>"); 
					 }else{
						 sb.append("<cell><![CDATA["+ incomePull.getCustomerName() +"]]></cell>");
					 }
					
					 sb.append("<cell><![CDATA["+ incomePull.getFullName()+"]]></cell>");
					 sb.append("<cell><![CDATA["+ incomePull.getModeName() +"]]></cell>");
					 sb.append("<cell><![CDATA["+ incomePull.getPurposeName() +"]]></cell>");
					 sb.append("<cell><![CDATA["+ incomePull.getFullName()+"]]></cell>");
					 
					 sb.append("<cell><![CDATA["+ incomePull.getMemo()+"]]></cell>");
					 sb.append("</row>");
				}
				
				
				 
				



			 }
			
			
			sb.append("</rows>");
	 }
	 
	
	 
	 
}