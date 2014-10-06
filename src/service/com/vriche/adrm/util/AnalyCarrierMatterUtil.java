package com.vriche.adrm.util;

import java.util.Iterator;
import java.util.List;

import com.vriche.adrm.model.AnalyzeClass;

public class AnalyCarrierMatterUtil{
	
	 public static synchronized void makeTreeGridXML(StringBuffer sb,List all){
			sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");    
			int i=-1;
			for(Iterator it = all.iterator();it.hasNext();){
			    int j=i++;	
				AnalyzeClass anlyClass = (AnalyzeClass)it.next();
//				
//				String rowCss =  "CURSOR: pointer;";
//				
//		         if(i%2 == 0){
//		        	 rowCss = "BACKGROUND-COLOR: #ECEFF4;CURSOR: pointer;";
//		            }else{
//		             rowCss = "BACKGROUND-COLOR: #f5f5f5;CURSOR: pointer;";
//		  	     }
//		         sb.append("<row  id=\""+ j  +"\"" +"  style=\""+ rowCss +"\">");
				 sb.append("<row  id=\""+ j  +"\">");
				 sb.append("<cell><![CDATA["+ anlyClass.getMatterName() +"]]></cell>");
				 sb.append("<cell><![CDATA["+ anlyClass.getSumTimes()+"]]></cell>");
				 sb.append("<cell><![CDATA["+ anlyClass.getRelIncome()  +"]]></cell>");
				 sb.append("</row>");

			 }
			
			sb.append("</rows>");
	 }
	 
}