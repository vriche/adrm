package com.vriche.adrm.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.SysParam;


public class CustomerProductUtil {
	
	 public static synchronized void makeTreeGridXML(StringBuffer sb,List all,String mode,String orgType,String weekIds){
		 
		    boolean isMeno = getResourcesLablePara();
		    String tvName = SysParamUtil.getTvNameParam();
		    
		    
		
		    
		    int k = 0;
		    String selectDays = "";

		   	sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");    
//			sb.append("<head>");  
//			sb.append("<afterInit>");    
//			sb.append("<call command=\"splitAt\"><param>2</param></call>");  
//			sb.append("</afterInit>");    
//			sb.append("</head>");  

            
		  
			for(Iterator it = all.iterator();it.hasNext();){
			
				CustomerProduct customerProduct = (CustomerProduct)it.next();

				String resourceName = customerProduct.getResourceName();
				String resourceMeno = customerProduct.getResourceMeno();
				Double[] mons = customerProduct.getDayTimes();
				Double[] dayStandards = customerProduct.getDayStandards();
				String dateStr = customerProduct.getMonth();
				String startTime0=customerProduct.getBroadcastStartTime()==null?"":DateUtil.formatTime(customerProduct.getBroadcastStartTime().longValue()*1000,"h:m:s");
//				String resourceRowCss =  "font-size:10px;font-family:Tahoma;font-weight:bold;";
//				String resourceRowCss =  "font-size:10px;COLOR: #000000; TEXT-DECORATION: none; font-weight: bold;font-family:Verdana,arial, sans-serif, 宋体";
//				String resourceRowCss =  "font-size:9px;COLOR: #000000;FONT-FAMILY: Arial, Helvetica, sans-serif, \"宋体\"; TEXT-DECORATION: none; font-weight: bold;";
				String resourceRowCss =  "font-size:10px;";
				
				if(Integer.parseInt(orgType)==1){
					String lable = isMeno?resourceMeno:resourceName;
					if(!resourceName.equals("合计")){
//					System.out.println(">>>>>>>>>>>>>>>>>>>>>"+lable);
						lable = isMeno?"["+lable+"]" +resourceName:"["+lable+"]" +resourceMeno;
					}
						sb.append("<row  id=\""+ k++ +"\"" +"  style=\""+ resourceRowCss +"\">");
					if(!resourceName.equals("合计")){
						sb.append("<cell><![CDATA["+ startTime0+" "+lable  +"]]></cell>");
					}else{
						sb.append("<cell><![CDATA["+ resourceName  +"]]></cell>");
					}
				}
				
				if(Integer.parseInt(orgType)==2){

					String startTime=customerProduct.getBroadcastStartTime()==null?"":DateUtil.formatTime(customerProduct.getBroadcastStartTime().longValue()*1000,"h:m:s");
					String endTime=customerProduct.getBroadcastEndTime()==null?"":DateUtil.formatTime(customerProduct.getBroadcastEndTime().longValue()*1000,"h:m:s");;
					String lable ="";
						if(!resourceName.equals("合计")){
							lable = startTime  +"-"+endTime;
						}
						
						sb.append("<row  id=\""+ k++ +"\"" +"  style=\""+ resourceRowCss +"\">");
							
						if(!resourceName.equals("合计")){
							sb.append("<cell><![CDATA["+ lable  +"]]></cell>");
						}else{
//							sb.append("<cell><![CDATA["+ resourceName  +"]]></cell>");
							sb.append("<cell><![CDATA["+""+"]]></cell>");
						}					
				}
				
				sb.append("<cell><![CDATA["+dateStr.substring(4,6)  +"]]></cell>");
				
			
			
				    for(int i=0;i<=30;i++){
//	   	  		System.out.println(mons[i].equals(new Double(0.0)));
				    
//				    	   String  tt = "";
				    	   Double kk = new Double(0);
					       String day = i<9?"0"+(i+1):""+(i+1);
//					      if(type.equals("0")&&!weekIds.equals("")){
				    	  if(!weekIds.equals("")){
							  String sumUsed = customerProduct.getSumUsed();
							  String total = customerProduct.getTotal();
							  if(mons[i]==null) mons[i]=new Double(0.0);
							  if(dayStandards[i] == null) dayStandards[i] = new Double(0.0);
				    		  if(selectDays.length()<31){
						    	  int week = DateUtil.getDaysOfWeek(Integer.parseInt(dateStr+day));
					    		  if(weekIds.indexOf(""+week)==-1){
					    			  selectDays+="0";
					    			  customerProduct.setSumUsed(new Double(Double.parseDouble(sumUsed)-mons[i].doubleValue()).toString());
					    			  customerProduct.setTotal(new Double(Double.parseDouble(total)-dayStandards[i].doubleValue()).toString());
					    			  mons[i]=null;
					    		  }else{
					    			  selectDays+="1";
					    		  }
				    		  }else if(selectDays.charAt(i)=='0'){
				    			  customerProduct.setSumUsed(new Double(Double.parseDouble(sumUsed)-mons[i].doubleValue()).toString());
				    			  customerProduct.setTotal(new Double(Double.parseDouble(total)-dayStandards[i].doubleValue()).toString());
				    			  mons[i]=null;
				    		  }
				    	  }
//				    	   if(mode.equals("1")){
//				    		   System.out.println("11>>>>>>xx>>  "+mode);
				    		   kk = mons[i];
				    		   if(kk == null) kk = new Double("0.0");
				    		   
//				    	   }else{
////				    		   System.out.println("22>>>>>>xx>>  "+mode);
//				    		   Double ff = mons[i];
//				    		   if(ff == null) ff = new Double("0.0");
//				    		   
//				    		   kk = customerProduct.getDayStandards()[i];
//				    		   if(kk == null) kk = new Double("0.0");
//				    		   kk = new Double(kk.doubleValue() - ff.doubleValue());
//				    	   }
				    	   
				    	   if(kk.toString().equals("0.0")){
			    		    	 sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			    		     }else{
			    		    	 String u = StringUtil.doubleFormat(kk);
//			    		    	 if(tvName.equals("fztv")){
//			    		    		 sb.append("<cell><![CDATA[<a  href='javascript:void 0' onclick='getAdvers("+ customerProduct.getResourceId()+","+dateStr+day + ")'>" + u + "</a>]]></cell>");
//			    		    	 }else{                       
			    		    		 sb.append("<cell><![CDATA["+ u +"]]></cell>");
			
//			    		    	 }          
			    			}
				    	   
				    	   dayStandards[i] = dayStandards[i] == null?new Double(0):dayStandards[i];
				    	   sb.append("<userdata name=\"dayStandard" + i +"\"><![CDATA["+ dayStandards[i] +"]]></userdata>");
				    	   sb.append("<userdata name=\"resourceId" +"\"><![CDATA["+ customerProduct.getResourceId()+"]]></userdata>");
				    	   sb.append("<userdata name=\"month"  +"\"><![CDATA["+ dateStr +"]]></userdata>");
//				    	    sb.append("</cell>");
//				    	
//				    		if(mons[i] == null){
//				    			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
//				    		}else{
////				    		     System.out.println(mons[i].toString().equals("0.0"));
//				    			
//				    		     if(mons[i].toString().equals("0.0")){
//				    		    	 sb.append("<cell><![CDATA["+ "" +"]]></cell>");
//				    		     }else{
//				    		    	 String u = StringUtil.doubleFormat(mons[i]);
//				    		    	 sb.append("<cell><![CDATA["+ u +"]]></cell>");
//				    			}
//				    		}
				    }
				    
				
				    
				 String standardTime =    customerProduct.getStandardTime() == null?"":String.valueOf(customerProduct.getStandardTime());
//				 System.out.println(">>>>>>xx>>  "+standardTime);
//				 System.out.println(">>>>>>xx>>  "+standardTime.equals(""));
//				 System.out.println(">>>>>>xx>>  "+(standardTime == ""));
				 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(standardTime) +"]]></cell>");
				 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(customerProduct.getTotal()) +"]]></cell>");
				 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(customerProduct.getSumUsed()) +"]]></cell>");
				   
				    Double xx = new Double(customerProduct.getSumUsed());
				    Double yy = new Double(customerProduct.getTotal());
//			        System.out.println(">>>>>>xx>>  "+xx.doubleValue());
//			        System.out.println(">>>>>>///>>  "+xx.doubleValue()/yy.doubleValue());
				    
				 sb.append("<cell><![CDATA["+ Math.round(xx.doubleValue()/yy.doubleValue()*100*Math.pow(10,2))/Math.pow(10,2) +"%" +"]]></cell>");
				
				
				 
				 
				 sb.append("</row>");

			 }
			
			sb.append("</rows>");
	  }
	 
	 
	 
	 public static synchronized void makeTreeGridXML_61(StringBuffer sb,List all,String mode,String orgType,String weekIds){
		 
		    boolean isMeno = getResourcesLablePara();
		    String tvName = SysParamUtil.getTvNameParam();
		    
		    
		
		    
		    int k = 0;
		    String selectDays = "";

		   	sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");    
//			sb.append("<head>");  
//			sb.append("<afterInit>");    
//			sb.append("<call command=\"splitAt\"><param>2</param></call>");  
//			sb.append("</afterInit>");    
//			sb.append("</head>");  

         
		  
			for(Iterator it = all.iterator();it.hasNext();){
			
				CustomerProduct customerProduct = (CustomerProduct)it.next();
				String resourceName = customerProduct.getResourceName();
				String resourceMeno = customerProduct.getResourceMeno();
				Double[] mons = customerProduct.getDayTimes();
				Double[] dayStandards = customerProduct.getDayStandards();
				String dateStr = customerProduct.getMonth();
				
				String resourceRowCss =  "font-size:10px;font-family:Tahoma;font-weight:bold;";

				
				String startTime=customerProduct.getBroadcastStartTime()==null?"":DateUtil.formatTime(customerProduct.getBroadcastStartTime().longValue()*1000,"h:m:s");
				String endTime=customerProduct.getBroadcastEndTime()==null?"":DateUtil.formatTime(customerProduct.getBroadcastEndTime().longValue()*1000,"h:m:s");;
			
				

					String lable = isMeno?resourceMeno:resourceName;
					if(!resourceName.equals("合计")){
						lable = isMeno?"["+lable+"]" +resourceName:"["+lable+"]" +resourceMeno;
					}
						sb.append("<row  id=\""+ k++ +"\"" +"  style=\""+ resourceRowCss +"\">");
					if(!resourceName.equals("合计")){
						sb.append("<cell><![CDATA["+ lable  +"]]></cell>");
					}else{
						sb.append("<cell><![CDATA["+ resourceName  +"]]></cell>");
					}
			
					sb.append("<cell><![CDATA["+ startTime  +"]]></cell>");
					sb.append("<cell><![CDATA["+ endTime  +"]]></cell>");

				
				sb.append("<cell><![CDATA["+dateStr.substring(4,6)  +"]]></cell>");
				
			
			
				    for(int i=0;i<=30;i++){
//	   	  		System.out.println(mons[i].equals(new Double(0.0)));
				    
//				    	   String  tt = "";
				    	   Double kk = new Double(0);
					       String day = i<9?"0"+(i+1):""+(i+1);
//					      if(type.equals("0")&&!weekIds.equals("")){
				    	  if(!weekIds.equals("")){
							  String sumUsed = customerProduct.getSumUsed();
							  String total = customerProduct.getTotal();
							  if(mons[i]==null) mons[i]=new Double(0.0);
							  if(dayStandards[i] == null) dayStandards[i] = new Double(0.0);
				    		  if(selectDays.length()<31){
						    	  int week = DateUtil.getDaysOfWeek(Integer.parseInt(dateStr+day));
					    		  if(weekIds.indexOf(""+week)==-1){
					    			  selectDays+="0";
					    			  customerProduct.setSumUsed(new Double(Double.parseDouble(sumUsed)-mons[i].doubleValue()).toString());
					    			  customerProduct.setTotal(new Double(Double.parseDouble(total)-dayStandards[i].doubleValue()).toString());
					    			  mons[i]=null;
					    		  }else{
					    			  selectDays+="1";
					    		  }
				    		  }else if(selectDays.charAt(i)=='0'){
				    			  customerProduct.setSumUsed(new Double(Double.parseDouble(sumUsed)-mons[i].doubleValue()).toString());
				    			  customerProduct.setTotal(new Double(Double.parseDouble(total)-dayStandards[i].doubleValue()).toString());
				    			  mons[i]=null;
				    		  }
				    	  }
//				    	   if(mode.equals("1")){
//				    		   System.out.println("11>>>>>>xx>>  "+mode);
				    		   kk = mons[i];
				    		   if(kk == null) kk = new Double("0.0");
				    		   
//				    	   }else{
////				    		   System.out.println("22>>>>>>xx>>  "+mode);
//				    		   Double ff = mons[i];
//				    		   if(ff == null) ff = new Double("0.0");
//				    		   
//				    		   kk = customerProduct.getDayStandards()[i];
//				    		   if(kk == null) kk = new Double("0.0");
//				    		   kk = new Double(kk.doubleValue() - ff.doubleValue());
//				    	   }
				    	   
				    	   if(kk.toString().equals("0.0")){
			    		    	 sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			    		     }else{
			    		    	 String u = StringUtil.doubleFormat(kk);
//			    		    	 if(tvName.equals("fztv")){
//			    		    		 sb.append("<cell><![CDATA[<a  href='javascript:void 0' onclick='getAdvers("+ customerProduct.getResourceId()+","+dateStr+day + ")'>" + u + "</a>]]></cell>");
//			    		    	 }else{                       
			    		    		 sb.append("<cell><![CDATA["+ u +"]]></cell>");
			
//			    		    	 }          
			    			}
				    	   
				    	   dayStandards[i] = dayStandards[i] == null?new Double(0):dayStandards[i];
				    	   sb.append("<userdata name=\"dayStandard" + i +"\"><![CDATA["+ dayStandards[i] +"]]></userdata>");
				    	   sb.append("<userdata name=\"resourceId" +"\"><![CDATA["+ customerProduct.getResourceId()+"]]></userdata>");
				    	   sb.append("<userdata name=\"month"  +"\"><![CDATA["+ dateStr +"]]></userdata>");
//				    	    sb.append("</cell>");
//				    	
//				    		if(mons[i] == null){
//				    			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
//				    		}else{
////				    		     System.out.println(mons[i].toString().equals("0.0"));
//				    			
//				    		     if(mons[i].toString().equals("0.0")){
//				    		    	 sb.append("<cell><![CDATA["+ "" +"]]></cell>");
//				    		     }else{
//				    		    	 String u = StringUtil.doubleFormat(mons[i]);
//				    		    	 sb.append("<cell><![CDATA["+ u +"]]></cell>");
//				    			}
//				    		}
				    }
				    
				
				    
				 String standardTime =    customerProduct.getStandardTime() == null?"":String.valueOf(customerProduct.getStandardTime());
//				 System.out.println(">>>>>>xx>>  "+standardTime);
//				 System.out.println(">>>>>>xx>>  "+standardTime.equals(""));
//				 System.out.println(">>>>>>xx>>  "+(standardTime == ""));
				 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(standardTime) +"]]></cell>");
				 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(customerProduct.getTotal()) +"]]></cell>");
				 sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(customerProduct.getSumUsed()) +"]]></cell>");
				   
				    Double xx = new Double(customerProduct.getSumUsed());
				    Double yy = new Double(customerProduct.getTotal());
//			        System.out.println(">>>>>>xx>>  "+xx.doubleValue());
//			        System.out.println(">>>>>>///>>  "+xx.doubleValue()/yy.doubleValue());
				    
				 sb.append("<cell><![CDATA["+ Math.round(xx.doubleValue()/yy.doubleValue()*100*Math.pow(10,2))/Math.pow(10,2) +"%" +"]]></cell>");
				
				
				 
				 
				 sb.append("</row>");

			 }
			
			sb.append("</rows>");
	  }
	 
	 
		public static  void makeTreeGridXML_getTreeGridSum(StringBuffer sb,List all,String type){

			String ctxPath = RequestUtil.getReqInfo().getCtxPath();
			
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");  
			
			
			
			
			Map keyMap = new HashMap();
			Map totalMap = new HashMap();
			Map totalMap2 = new HashMap();
			
			double totalSum = 0.d;
			double usedSum = 0.d;
			double leaveSum = 0.d;
			
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerProduct customerProduct = (CustomerProduct)it.next();
				String total = StringUtil.getNullValue(customerProduct.getTotal(),"0");
				String used = StringUtil.getNullValue(customerProduct.getUsed(),"0");
				String key = ""+customerProduct.getDisplayNo();
				
				if(keyMap.containsKey(key)){
					String s = (String)keyMap.get(key);
					String[] ss = s.split(",");
					double s1 = new Double(ss[0]).doubleValue();
					double s2 = new Double(ss[1]).doubleValue();
					s = (s1 + new Double(total).doubleValue())+","+(s2 + new Double(used).doubleValue());
					keyMap.put(key,s);
				}else{
					String s = (new Double(total).doubleValue())+","+( new Double(used).doubleValue());
					keyMap.put(key,s);
				}
				
				totalSum += Double.valueOf(total).doubleValue();
				usedSum += Double.valueOf(used).doubleValue();
			}
			
			leaveSum = totalSum -usedSum;
			int k =0;

			for(Iterator it = all.iterator();it.hasNext();){
				
				CustomerProduct customerProduct = (CustomerProduct)it.next();
				String channelName = customerProduct.getResourceName();
				String month = customerProduct.getResourceMeno();
				String total = customerProduct.getTotal();
				String used = customerProduct.getUsed();
				double leave = Double.valueOf(total).doubleValue() - Double.valueOf(used).doubleValue();
				
				int channelId = customerProduct.getDisplayNo().intValue();
				String key = ""+channelId;
				String key2 = ""+channelId + "_"+month;

				if(!totalMap.containsKey(key)){
					
					
					
					
					String s = (String)keyMap.get(key);
					String[] ss = s.split(",");
					double s1 = new Double(ss[0]).doubleValue();
					double s2 = new Double(ss[1]).doubleValue();
					sb.append("<row  id=\""+ key   +"\">"); 
					sb.append("<cell image=\"folder.gif\">"+ channelName +"</cell>");
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double(s1*1000))+""))  +"]]></cell>");
					sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double(s2*1000))+""))  +"]]></cell>");
					sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double((s1-s2)*1000))+"")) +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.persentFormat(s2,s1)  +"]]></cell>");
					k =1;
					totalMap.put(key,key);
				}else{
					k++;
				}

				
				
				
				
			
				
					sb.append("<row  id=\""+ key2   +"\">");
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.converNum2cnMonth(month)  +"]]></cell>");
					sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr(new Long(StringUtil.doubleFormat2(new Double(Double.parseDouble(total)*1000))+""))  +"]]></cell>");
					sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr(new Long(StringUtil.doubleFormat2(new Double(Double.parseDouble(used)*1000))+""))  +"]]></cell>");
					sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr(new Long(StringUtil.doubleFormat2(new Double(leave*1000))+""))  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.persentFormat(Double.valueOf(used).doubleValue(),Double.valueOf(total).doubleValue())  +"]]></cell>");
					sb.append("</row>");	


					if(k == 12){sb.append("</row>");}
					
					

					
			}
			
			
			if(all.size() >0){
				sb.append("<row  id=\""+ "total"   +"\">");
				sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
				sb.append("<cell></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double(totalSum*1000))+""))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double(usedSum*1000))+""))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double(leaveSum*1000))+""))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(usedSum,totalSum)   +"]]></cell>");
				sb.append("</row>");
			}
			
			
			sb.append("</rows>");	

}
		public static  void makeTreeGridXML_getTreeGridSumReport(List all,List ls){

			Map keyMap = new HashMap();
			Map totalMap = new HashMap();
			Map totalMap2 = new HashMap();
			
			double totalSum = 0.d;
			double usedSum = 0.d;
			double leaveSum = 0.d;
			
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerProduct customerProduct = (CustomerProduct)it.next();
				String total = StringUtil.getNullValue(customerProduct.getTotal(),"0");
				String used = StringUtil.getNullValue(customerProduct.getUsed(),"0");
				String key = ""+customerProduct.getDisplayNo();
				
				if(keyMap.containsKey(key)){
					String s = (String)keyMap.get(key);
					String[] ss = s.split(",");
					double s1 = new Double(ss[0]).doubleValue();
					double s2 = new Double(ss[1]).doubleValue();
					s = (s1 + new Double(total).doubleValue())+","+(s2 + new Double(used).doubleValue());
					keyMap.put(key,s);
				}else{
					String s = (new Double(total).doubleValue())+","+( new Double(used).doubleValue());
					keyMap.put(key,s);
				}
				
				totalSum += Double.valueOf(total).doubleValue();
				usedSum += Double.valueOf(used).doubleValue();
			}
			
			leaveSum = totalSum -usedSum;
			int k =0;

			for(Iterator it = all.iterator();it.hasNext();){
				
				CustomerProduct customerProduct = (CustomerProduct)it.next();
				String channelName = customerProduct.getResourceName();
				String month = customerProduct.getResourceMeno();
				String total = customerProduct.getTotal();
				String used = customerProduct.getUsed();
				double leave = Double.valueOf(total).doubleValue() - Double.valueOf(used).doubleValue();
				
				int channelId = customerProduct.getDisplayNo().intValue();
				String key = ""+channelId;
				String key2 = ""+channelId + "_"+month;

				if(!totalMap.containsKey(key)){
					FusionChartObject fObject = new FusionChartObject();
					String s = (String)keyMap.get(key);
					String[] ss = s.split(",");
					double s1 = new Double(ss[0]).doubleValue();
					double s2 = new Double(ss[1]).doubleValue();
					
					fObject.setLable(channelName);
					fObject.setValue1("");
					fObject.setValue2(DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double(s1*1000)))));
					fObject.setValue3(DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double(s2*1000)))));
					fObject.setValue4(DateUtil.formatLongToTimeStr2(new Long(StringUtil.doubleFormat2(new Double((s1-s2)*1000)))));
					fObject.setValue5( StringUtil.persentFormat(s2,s1));
					
					ls.add(fObject);	
			
					k =1;
					totalMap.put(key,key);
				}else{
					k++;
				}

				FusionChartObject fObject = new FusionChartObject();
				
				fObject.setLable("");
				fObject.setValue1(StringUtil.converNum2cnMonth(month));
				fObject.setValue2(DateUtil.formatLongToTimeStr(new Long(StringUtil.doubleFormat2(new Double(Double.parseDouble(total)*1000)))));
				fObject.setValue3(DateUtil.formatLongToTimeStr(new Long(StringUtil.doubleFormat2(new Double(Double.parseDouble(used)*1000))+"")));
				fObject.setValue4(DateUtil.formatLongToTimeStr(new Long(StringUtil.doubleFormat2(new Double(leave*1000)))));
				fObject.setValue5( StringUtil.persentFormat(Double.valueOf(used).doubleValue(),Double.valueOf(total).doubleValue()));				
				ls.add(fObject);	
			}


}		
			
	 
		public static boolean getResourcesLablePara(){
		    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		    if(StringUtils.isEmpty(sysParam.getResourceDisplayParam())) sysParam.setResourceDisplayParam("0");
		    return (sysParam.getResourceDisplayParam().equals("0"))?false:true;
		}
		private static boolean getFztvSpecialParam(){ 
		    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
		    return (sysParam.getFztvSpecialParam().equals("0"))?false:true;
		}
}