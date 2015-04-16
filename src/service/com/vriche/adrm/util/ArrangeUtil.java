/****************************************************************************     
 * Created on 2007-10-29                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.model.PublishedInfo;
import com.vriche.adrm.model.SysParam;

/**
 * ArrangeUtil class
 * 
 * This class is used to 
 * 
 * <p><a href="ArrangeUtil.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="ArrangeUtil"
 * 
 */
public class ArrangeUtil {
	
	  public static synchronized void makeTreeGridXML(StringBuffer sb,List all,String resIdPrefix,String adverIdPrefix,boolean rebuild,String orgId) {
		   	sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");    
		    int lineNums=0;
		    int usedTimes=0;
		    int totalTimes=0;
		    
		    
		    System.out.println("makeTreeGridXML orgId<<<<<<<<<<<<<<<<<<<<<<"+orgId);
		    
		    String orgType = SysParamUtil.getOrgTypeById(orgId); 
		    
		    System.out.println(" makeTreeGridXML orgType<<<<<<<<<<<<<<<<<<<<<<"+orgType);
		    
			for(Iterator it = all.iterator();it.hasNext();){
			
				PublishArrange publishArrange = (PublishArrange)it.next();
				String resId = resIdPrefix+ "" +publishArrange.getResourceId().toString();
				makeOneResouce(sb,publishArrange,resId,adverIdPrefix,rebuild,orgType);
				
				lineNums+=publishArrange.getPublishArrangeDetails().size();
//				totalTimes = publishArrange.getResourceTotalTimes()==null?0:publishArrange.getResourceTotalTimes().intValue();	
				usedTimes+=publishArrange.getResourceUsedTimes()==null?0: publishArrange.getResourceUsedTimes().intValue();
			 }
//			if(getFztvSpecialParam()){
//				getSumXML(sb,lineNums,usedTimes,totalTimes);
//			}
			sb.append("</rows>");
	  }
	  						
	  private static String getSumXML(StringBuffer sb,int lineNums,int usedTimes,int totalTimes){
		    int leftTime=totalTimes-usedTimes;
//		  	String usedStr =  StringUtil.second2HMS(usedTimes);
//		  	String leftStr =  StringUtil.second2HMS(leftTime);
			sb.append("<row  id=\""+ -1 +"\"" +"  style=\""+ "" +"\">");      
			sb.append("<cell id=\"1\" image='folder.gif'></cell>");
		    sb.append("<cell id=\"2\" image='folder.gif'></cell>");
		    sb.append("<cell id=\"3\"><![CDATA[" + "合计" + "]]></cell>");
		    sb.append("<cell><![CDATA[" + lineNums+ "]]></cell>");
		    sb.append("<cell>"+usedTimes +"</cell>"); 
		    sb.append("<cell>"+ "" +"</cell>");  
		    sb.append("<cell>"+ ""+"</cell>");  
		    sb.append("<cell></cell>");	
		    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");	
		    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");	
		    sb.append("<cell><![CDATA["+""+"]]></cell>");
		    sb.append("<cell><![CDATA["+""+"]]></cell>");
		    sb.append("<cell><![CDATA["+ -1 +"]]></cell>");	
		    sb.append("<cell><![CDATA["+ true  +"]]></cell>");
		    sb.append("</row>");
		    
		    return sb.toString();
	  }
	  public static void makeOneResouce(StringBuffer sb,PublishArrange publishArrange,String resId,String adverIdPrefix,boolean rebuild,String orgType){
		    
		   getOneResUsedTimes(publishArrange);

		   double resourceLeave = Double.parseDouble(StringUtil.getNullValue(publishArrange.getResourceTotalTimes(),"0"))- Double.parseDouble(StringUtil.getNullValue(publishArrange.getResourceUsedTimes(),"0"));
		   String resourceRowCss = getResourceRowCss(publishArrange,resourceLeave);
		   
//		   boolean isFztv = getFztvSpecialParam();
		   int ogt = Integer.parseInt(orgType);
//		   if(isFztv){
//			   makeOneAdver(sb,publishArrange,resId,adverIdPrefix,rebuild);
//		   }
			sb.append("<row  id=\""+ resId +"\"" +"  style=\""+ resourceRowCss +"\">");
			sb.append("<cell id=\"1\" image='folder.gif'></cell>");
//			if(isFztv){
//			    sb.append("<cell id=\"2\" image='folder.gif'></cell>");
//			    sb.append("<cell id=\"3\"><![CDATA[" + StringUtil.null2String(publishArrange.getResourceName())+ "]]></cell>");
//			    sb.append("<cell><![CDATA[" + publishArrange.getResourceMeno()+ "]]></cell>");
//			    sb.append("<cell>"+ publishArrange.getResourceUsedTimes() +"</cell>");
//			    sb.append("<cell>"+ resourceLeave +"</cell>");
//			    sb.append("<cell>"+ publishArrange.getResourceTotalTimes()+"</cell>");  
//			}else{
			    sb.append("<cell id=\"2\" image='folder.gif'><![CDATA[" + publishArrange.getResourceName()+ "]]></cell>");
			    sb.append("<cell id=\"3\"><![CDATA[" + StringUtil.null2String(publishArrange.getResourceMeno())+ "]]></cell>");
			    sb.append("<cell>"+ publishArrange.getResourceTotalTimes()+"</cell>");
			    sb.append("<cell>"+ publishArrange.getResourceUsedTimes() +"</cell>");
			    sb.append("<cell>"+ resourceLeave +"</cell>");
			    sb.append("<cell></cell>");  
//			}
		    sb.append("<cell></cell>");	
		    

		    sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrange.getMemo())  +"]]></cell>");	

		   
		    
		    sb.append("<cell><![CDATA["+ publishArrange.getResourceId()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrange.getFilePath())  +"]]></cell>");	
		    sb.append("<cell><![CDATA["+ publishArrange.getCreateBy()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ publishArrange.getCreateDate()  +"]]></cell>");
		    sb.append("<cell><![CDATA["+ publishArrange.getId() +"]]></cell>");	
		    sb.append("<cell><![CDATA["+ publishArrange.getIsLocked()  +"]]></cell>");
		    sb.append("<cell></cell>");
		    
		    int beforehand =  publishArrange.getBeforehand().intValue();
		    String beforehandStr = beforehand > 0? String.valueOf(beforehand):"";
		    sb.append("<cell><![CDATA["+ beforehandStr  +"]]></cell>");
		    sb.append("</row>");
//			if(!isFztv){
				   makeOneAdver(sb,publishArrange,resId,adverIdPrefix,rebuild);
//			}  
			
			
			
			
//		    makeOneAdver(sb,publishArrange,resId,adverIdPrefix,rebuild);
//		    if(!displayTree)  makeOneAdver(sb,publishArrange,resId,adverIdPrefix);
	  }
	  
// 	private static  boolean getFztvSpecialParam(){
//	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//	    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
//	    return (sysParam.getFztvSpecialParam().equals("0"))?false:true;
//	}
 	
 	private static  boolean getQztvSpecialParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getQztvSpecialParam())) sysParam.setQztvSpecialParam("0");
	    return (sysParam.getQztvSpecialParam().equals("0"))?false:true;
	}
 	
	  public static String getResourceRowCss(PublishArrange publishArrange,double resourceLeave){
		  String resourceRowCss = "font-weight:bold;";

		  if(resourceLeave == 0) resourceRowCss = "font-weight:bold;" +" background-color: #CCCCCC;";
		  if(resourceLeave > 0) resourceRowCss = "font-weight:bold;" +" background-color: #99FF66;";
		  if(resourceLeave < 0) resourceRowCss = "font-weight:bold;" +" background-color: #FFFF00;";
		  
//		  if(getFztvSpecialParam()){
//			  if(resourceLeave >= 0) resourceRowCss = "font-weight:bold;" +" background-color: #99FF66;";
//			  if(resourceLeave < 0) resourceRowCss = "font-weight:bold;" +" background-color: #FF0000;";
//		  }
		  return resourceRowCss;  
		  
	  }
	  
	  public static void makeOneAdver(StringBuffer sb,PublishArrange publishArrange,String resId,String adverIdPrefix,boolean rebuild){
		  int advRowId = 1;
//		  System.out.println(">>>>>> publishArrange.getIsArranged().booleanValue()>>>>>>>>>"+ publishArrange.getIsArranged());
//		  System.out.println(">>>>>> publishArrange.getIsArranged().booleanValue()>>>>>>>>>"+ publishArrange.getIsLocked());
		  
		  boolean isArranged = publishArrange.getIsArranged().booleanValue();
		  boolean isLocked = publishArrange.getIsLocked().booleanValue();
		  List publishArrangeDetails = publishArrange.getPublishArrangeDetails();
		  
//		  System.out.println(">>>>>> |||| publishArrangeDetails.size >>>>>>>>>"+ publishArrangeDetails.size());
		  
		  for(Iterator it = publishArrangeDetails.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  
			  makeOneRowAdver(publishArrange,sb,publishArrangeDetail,resId,advRowId++,adverIdPrefix,isArranged,rebuild,isLocked);
			  
			  
//			  int  r = publishArrangeDetail.getAdverTimes().intValue();
//			  if((isArranged || isLocked) && !rebuild) {
//				     makeOneRowAdver(publishArrange,sb,publishArrangeDetail,resId,advRowId++,adverIdPrefix,isArranged,rebuild,isLocked);
//			  }else{
//				  for(int i = 1 ;i<(r+1);i++){
//					  makeOneRowAdver(publishArrange,sb,publishArrangeDetail,resId,advRowId++,adverIdPrefix,isArranged,rebuild,isLocked);
//				  }				  
//			  }
		  } 
	  }
	  
	  public static void makeOneRowAdver(PublishArrange publishArrange,StringBuffer sb,PublishArrangeDetail publishArrangeDetail,String resId,int i,String adverIdPrefix,boolean isArranged,boolean rebuild,boolean isLocked){
		 
//		  String advId = resId + "_"+ adverIdPrefix +"_"+i;
		  
		  String advId = resId + "_"+ adverIdPrefix +"_"+ publishArrangeDetail.getPublishSort();
		  String style = "";
//		  String style = " style=\"cursor: pointer;\"";
		 String orgId = StringUtil.getNullValue(publishArrangeDetail.getOrgId(),"1");

//		  if(getFztvSpecialParam()&&publishArrangeDetail.getSpaceAdver().booleanValue()) style = " style=\"color: #F00;\"";
		  if(isLocked) style = " style=\"background-color: #CCCCCC;\"";  
		  
		  
		  sb.append("<row id=\""+ advId +"\"" + style +">");

		   
//		  System.out.println("makeOneRowAdver>>>>>> |||| publishArrangeDetail.getPublishSort() >>>>>>>>>"+publishArrangeDetail.getPublishSort());
		  
//		  if(isArranged && !rebuild){
        	  sb.append("<cell image='leaf.gif'>"+ publishArrangeDetail.getPublishSort() +"</cell>");	
//          }else{
//        	  sb.append("<cell image='leaf.gif'>"+ i +"</cell>");	
//          }
          
       
		  
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getTapeCode())+"]]></cell>");
		  
		  
			 String adName =  StringUtil.encodeStringXML(StringUtil.getResourceName(publishArrangeDetail.getMatterName()));
			 String edit =  StringUtil.encodeStringXML( StringUtil.getResourceName(publishArrangeDetail.getMatterEdit()));
			 
		  sb.append("<cell><![CDATA["+ adName +"]]></cell>");
		  sb.append("<cell><![CDATA["+ edit +"]]></cell>");
		  
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterLength())+"]]></cell>");
		  sb.append("<cell>"+ StringUtil.null2String(publishArrangeDetail.getSpecificName())+"</cell>");
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getPublishMemo())+"]]></cell>");
		  
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getSpecificValue())  +"]]></cell>");
		  sb.append("<cell><![CDATA["+ publishArrangeDetail.getOrderDayId()  +"]]></cell>");
		  sb.append("<cell><![CDATA["+ publishArrange.getResourceId()  +"]]></cell>");
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getCustomerName())  +"]]></cell>");
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getOwnerUserName())  +"]]></cell>");
		  sb.append("<cell><![CDATA["+ publishArrangeDetail.getId()   +"]]></cell>");	
		  sb.append("<cell><![CDATA["+ convertBoolean(publishArrange.getIsArranged().booleanValue())   +"]]></cell>");	
		  sb.append("<cell><![CDATA["+ publishArrange.getIsLocked()  +"]]></cell>");
//		  sb.append("<cell><![CDATA["+ publishArrangeDetail.getOwnerUserId()  +"]]></cell>");
		  String orderId = StringUtil.null2String(publishArrangeDetail.getOrderId());
		  sb.append("<cell><![CDATA[" +  StringUtil.null2String(publishArrangeDetail.getOrderCode()) +"^editOrder.html?id=" + orderId + "&orgId="+ orgId +"]]></cell>");
		  sb.append("</row>");	
		  
		  
//		  System.out.println(">>>>>> |||| publishArrangeDetail >>>>>>>>>"+ publishArrangeDetail.toString());
	  }
	  
	  
     public static int convertBoolean(boolean b){
    	 return (b == true)?1:0;
     }
     
 
	  public static void resetList(List newList ,List resList,List adverList,boolean rebuild,boolean isRoll,String parentName,String orgId){
		  
		  boolean withBroPoint = SysParamUtil.getwithBroPoint();
		  boolean resourceDisplayParam = SysParamUtil.getResourceDisplay();
		  boolean isArrangeOrderOrEntry = SysParamUtil.getIsArrangeOrderOrEntry() && withBroPoint;
		  String tvname = SysParamUtil.getTvNameParam();
		  String orgType = SysParamUtil.getOrgTypeById(orgId);
		  
		  
		  
//		  System.out.println("isArrangeOrderOrEntry >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ isArrangeOrderOrEntry);
		  
		  
//		  System.out.println("resetList parentName >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ parentName);
		  
//		if(parentName.startsWith("carrierId")){
//			if(isArrangeOrderOrEntry){
//				Collections.sort(resList,new PublishArrangeEntryComparator());
//			}else{
//				Collections.sort(resList,new PublishArrangeComparator());
//			}
//		}else{
////			    //按播出入点
//			    if(isArrangeOrderOrEntry){
//					 Collections.sort(resList,new PublishArrangeEntryComparator());
//				}else{
//				//按序号
//					 Collections.sort(resList,new PublishArrangeComparator());
//				}
//		}
		
           //第二级按序号
		 
		  
		  
			if(parentName.startsWith("carrierId")){
//				 System.out.println("resetList parentName 第二级按序号>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>>>>>>>>>>>>>>>>>"+ parentName);
//				if(isArrangeOrderOrEntry){
//					Collections.sort(resList,new PublishArrangeEntryComparator());
//				}else{
					Collections.sort(resList,new PublishArrangeComparator());
//				}
				
			}else{
//				 System.out.println("resetList parentName 频道一级按时间顺序>>>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>>>>>>>>>>>>>>>>>"+ parentName);
			//频道一级按时间顺序
//				if(isArrangeOrderOrEntry){
					Collections.sort(resList,new PublishArrangeEntryComparator());
//				}else{
//					Collections.sort(resList,new PublishArrangeComparator());
//				}
				
			}
				


		
		
		

		  for(Iterator it = resList.iterator();it.hasNext();){    
			  PublishArrange publishArrange = (PublishArrange)it.next();
			  Long resourceId = publishArrange.getResourceId();
			  Integer publishDate = publishArrange.getPublishDate();

			  
			  
			  
//			  System.out.println("name >>>>>>>>>>>>>getResourceName>>>>>>>>>>>>>>>>>>>>>"+ publishArrange.getResourceName());
//			  System.out.println("name >>>>>>>>>>>>>getResourceMeno>>>>>>>>>>>>>>>>>>>>>"+ publishArrange.getResourceMeno());
			  
			  
			  if(withBroPoint ){
				  String broPoint = "";
				  String broStartTime = StringUtil.second2HMS3(publishArrange.getBroadcastStartTime().longValue()*1000,true);
				  String broEndTime = StringUtil.second2HMS3(publishArrange.getBroadcastEndTime().longValue()*1000,true);
//				  String name = publishArrange.getResourceName();
				  String name = StringUtil.getNullValue(publishArrange.getPostionMeno(),"");
				  if("".equals(name)){
					  name = publishArrange.getResourceName();
				  }
				  String memo = publishArrange.getResourceMeno();
				  
			
				  
//				  
//				  System.out.println("name >>>>>>>>>>>>>broStartTime>>>>>>>>>>>>>>>>>>>>>"+broStartTime);
//				  System.out.println("name >>>>>>>>>>>>>broEndTime>>>>>>>>>>>>>>>>>>>>>"+ broEndTime);
				  
//				  if(!"00:00:00".equals(broStartTime)){
//					  broStartTime = broStartTime +"-"+broEndTime;
//					  if("catv".equals(tvname)){
//						  broPoint = broStartTime +" "+ name;
//					  }else if("hntv".equals(tvname)){
//						  broPoint = broStartTime +" "+ name;
//					  }else if("sjz".equals(tvname)){
//						  broPoint = broStartTime +" "+ name;
//					  }else if("qztv".equals(tvname)){
//						  broPoint = broStartTime +" "+ name;
//					  }else if("xmtv".equals(tvname)){
//						  broPoint = broStartTime +" "+ name;
//					  }else{
//						  broPoint = broStartTime +" "+ name;
//					  }
//				  }
				  
//				  publishArrange.setResourceName(broPoint);
				  
				  if(!"00:00:00".equals(broStartTime)){

//					  电台
					  if("2".equals(orgType)){
						  broStartTime = broStartTime +"-"+broEndTime;
					  }
					 
					  
					  if(resourceDisplayParam){
//						  String name = publishArrange.getResourceName();
//						  String memo = publishArrange.getResourceMeno();
//						  if("qztv".equals(tvname)){
//							  name = memo +" " +name;
//						  }else{
//							  name = name +" " +memo;
//						  }
						  
						  if(name.indexOf(':')==-1 && name.indexOf("：")==-1){
							   broPoint = broStartTime +" "+ name ;
						  }else{
							  broPoint = name;
						  }	  					  
	

						  publishArrange.setResourceName(broPoint);
//						  System.out.println("name >>>>>>>>>>>>>>>>>>>"+name.indexOf("：")+">>>>>>>>>>>>>>>>>>>>>>"+ name);
//						  broPoint = StringUtil.second2HMS2(publishArrange.getArrangeType()*1000,true)+ " "+publishArrange.getResourceName();
//						  publishArrange.setResourceName(StringUtil.second2HMS(publishArrange.getArrangeType())+publishArrange.getResourceName());
					  }else{

						  if("catv".equals(tvname)||"sjz".equals(tvname)){
							  if(name.indexOf(':')==-1 && name.indexOf("：")==-1) {
								  broPoint = broStartTime;
							  }else{
								  broPoint = name;
							  } 
							  
							  publishArrange.setResourceName(name);
							  publishArrange.setResourceMeno(broPoint);
							  
						  }else{
							  if(memo.indexOf(':')==-1 && memo.indexOf("：")==-1) {
								  broPoint = broStartTime +" "+ memo;
							  }else{
								  broPoint = memo;
							  }
							  publishArrange.setResourceName(broPoint);
						  }
						  
						
//						  System.out.println("memo >>>>>>>>>>>>>>>>>>>"+memo.indexOf("：")+">>>>>>>>>>>>>>>>>>>>>>>"+ memo);
//						  broPoint =StringUtil.second2HMS2(publishArrange.getArrangeType()*1000,true)+" "+publishArrange.getResourceMeno();
//						  publishArrange.setResourceName(StringUtil.second2HMS(publishArrange.getArrangeType())+publishArrange.getResourceMeno());
					  }
					  
					  
					  
//					  publishArrange.setResourceName(broPoint);
					  
//					  System.out.println("broPoint >>>>>>>>>>>>>getResourceName>>>>>>>>>>>>>>>>>>>>>"+ broPoint);
				  }

				
			  }
			  
//			  System.out.println("name >>>>>>>>>>>>>publishArrange.getResourceName()>>>>>>>>>>>>>>>>>>>>>"+publishArrange.getResourceName());
			  
			  int state = 1;
			  state = getState(publishArrange,rebuild);
			  
//			  System.out.println("<<<<<<<getState   <<<<<<<" +state);
			  
			  List details = new ArrayList();
			  getAdverList(details,adverList,resourceId,publishDate,state,isRoll);
			  

			  publishArrange.setPublishArrangeDetails(details);
			  newList.add(publishArrange);
		  }	
	  }
	  
	  public static int getState(PublishArrange publishArrange,boolean rebuild){
		  int state =1;
		  boolean isLocked = publishArrange.getIsLocked().booleanValue();
		  boolean isArranged = publishArrange.getIsArranged().booleanValue();
		  if(isLocked) state = 0;
//		  if(getFztvSpecialParam()){
//			  if(!rebuild) state = 0;  
//		  }
		  if(isArranged && !rebuild) state = 0;
          		  
		  return state;
		  
	  }
	  
	  //给段位广告设置序号
	  private static int setAdverOrder2(List adverList,int i){
		  Collections.sort(adverList,new PublishSortComparator());  
		  for(Iterator it = adverList.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  if(publishArrangeDetail.getPublishSort()==null){
				  publishArrangeDetail.setSpaceAdver(new Boolean(true));
			  }else{
				  publishArrangeDetail.setSpaceAdver(new Boolean(false));  
			  } 
			  publishArrangeDetail.setPublishSort(new Integer(i++));
		  }
		  return i++;
	  }
	  
	  public static void getAdverList(List details,List adverList,Long resourceId,Integer publishDate,int state,boolean isRoll){
		  
//		  for(Iterator it = adverList.iterator();it.hasNext();){
//			  
//			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
//
//			  Long resId = publishArrangeDetail.getResourceId();
//			  if(resId == null) resId = publishArrangeDetail.getId();            
//			  Integer pubDate = publishArrangeDetail.getPublishDate();
//
//			  if(resId.longValue()== resourceId.longValue() && pubDate.intValue()== publishDate.intValue()){
//				  details.add(publishArrangeDetail);
////				  System.out.println(">>>>>>state>>>>>>>>>"+state);
//			  }
//		  }
		  
//		  System.out.println(">>>>>>state>>>>>>>>>"+state);
		  
//			System.out.println(">>>>>>getAdverList resourceId>>>>>>>>>"+resourceId);
//			System.out.println(">>>>>>getAdverList details.size>>>>>>>>>"+details.size());
		  if(getQztvSpecialParam()&&state==1){
			  Map mp=new HashMap();
			  List details_bak=new ArrayList();
			  for(Iterator it = adverList.iterator();it.hasNext();){
				  
				  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();

				  Long resId = publishArrangeDetail.getResourceId();
				  if(resId == null) resId = publishArrangeDetail.getId();            

				  if(resId.longValue()== resourceId.longValue()){
					  details_bak.add(publishArrangeDetail);
					  mp.put(publishArrangeDetail.getMatterId(),publishArrangeDetail);
				  }
			  }
//			  System.out.println("<<<<<<<details_bak.size<<<<<<<" +details_bak.size());
			  Collections.sort(details_bak,new PublishDateComparator());           
			  for(Iterator it = mp.keySet().iterator();it.hasNext();){
				  Long matterId = (Long)it.next();
				  PublishArrangeDetail detail=(PublishArrangeDetail)mp.get(matterId);
				  for(Iterator its = details_bak.iterator();its.hasNext();){
					  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)its.next();
					  if(matterId.equals(publishArrangeDetail.getMatterId())){
						  int week = DateUtil.getDaysOfWeek(publishArrangeDetail.getPublishDate().intValue());
						  detail.setPublishMemo(detail.getPublishMemo()+DateUtil.getWeekConvert2(week));       
					  }
				  }
//				  System.out.println("<<<<<<<detail.getPublishMemo<<<<<<<" +detail.getPublishMemo());    
			  }
			  details.addAll(mp.values());
		  }else{
			  for(Iterator it = adverList.iterator();it.hasNext();){
				  
				  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();

				  Long resId = publishArrangeDetail.getResourceId();
				  if(resId == null) resId = publishArrangeDetail.getId();            
				  Integer pubDate = publishArrangeDetail.getPublishDate();

				  if(resId.longValue()== resourceId.longValue() && pubDate.intValue()== publishDate.intValue()){
					  details.add(publishArrangeDetail);
//					  System.out.println(">>>>>>state>>>>>>>>>"+state);
				  }
			  }
		  }
		  if(details.size() > 0){
			  //编排过或锁定
			  if(state == 0){
//				  if(getFztvSpecialParam()){
//					  int i=1;
//					  List advers= new ArrayList();
//					  decomposeAdverByTimes(advers,details);
//					  details.clear();
//					  details.addAll(advers);
//					  i = setAdverOrder2(details,i);   
//				  }
				  Collections.sort(details);        
			  }else{
				  List oneResourceAdvers = new ArrayList();
				  List beforeSpecific = new ArrayList();
				  List afterSpecific = new ArrayList();
				  List middleAdver = new ArrayList();
				  Object[] objs = details.toArray();
				  
				  getSortAdvers(objs,beforeSpecific,afterSpecific,middleAdver);

				  int i = 1;
				  //指定正位置  如 正一、正二...
				  if(beforeSpecific.size()>0){
					  Collections.sort(beforeSpecific, new SpecificComparator());
					  i = setAdverOrder(beforeSpecific,i);
					  oneResourceAdvers.addAll(beforeSpecific);
				  }
				  
				  //没指定的广告
				  if(middleAdver.size()>0){
					  //是否需要滚动
					  if(isRoll) setMiddleAdveRoll(middleAdver,publishDate);
					  i = setAdverOrder(middleAdver,i);
					  oneResourceAdvers.addAll(middleAdver);
				  }
				  
				  //指定倒位置 如 倒一、倒二....
				  if(afterSpecific.size()>0) {
					  Collections.sort(afterSpecific, new SpecificComparator());
					  i = setAdverOrder(afterSpecific,i);
					  oneResourceAdvers.addAll(afterSpecific);
				  }

				  
				  details.clear();
				  details.addAll(oneResourceAdvers);
			  } 
		  }
		  
  
	  }
	  
	  //设置滚动播出
	  public static void setMiddleAdveRoll(List adverList,Integer publishDate){
		  List positiveList = new ArrayList();
		  List negativeList = new ArrayList();
		  int size = adverList.size();
		  int days = DateUtil.getDaysOfYear(publishDate.intValue());
		  int num = days/size;
		  int max = days - num*size;
		  
		  int i = 0;
		  int k = 0;

		  for(Iterator it = adverList.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  publishArrangeDetail.setPublishSort(new Integer(i++));
		  }
		  

		  //把序号-当前天数
		  for(Iterator it = adverList.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  int no = publishArrangeDetail.getPublishSort().intValue();
			  int newNo = no - days;
			  if(k < max){
				  publishArrangeDetail.setPublishSort(new Integer(newNo));
				  k++;
			  }
		  }		

		  for(Iterator it = adverList.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  int no = publishArrangeDetail.getPublishSort().intValue();
			  if(no >= 0){
				  positiveList.add(publishArrangeDetail);
			  }else{
				  negativeList.add(publishArrangeDetail);
			  }
		  }			  

		  
		  //排序
		  Collections.sort(positiveList);
		  Collections.sort(negativeList);
		  

		  adverList.clear();
		  if(positiveList.size()>0) adverList.addAll(positiveList);
		  if(negativeList.size()>0) adverList.addAll(negativeList);
	  }	  
	  
	  
	  
	  
	  //给段位广告设置序号
	  public static int setAdverOrder(List adverList,int i){
		  for(Iterator it = adverList.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
//			  System.out.println("publishArrangeDetail.sort1=="+publishArrangeDetail.getPublishSort());
			  publishArrangeDetail.setPublishSort(new Integer(i++));
//			  System.out.println("publishArrangeDetail.sort2=="+publishArrangeDetail.getPublishSort());         
		  }
		  return i++;
	  }
	  
	  
	  
	  //把一个段位下广告分成三部分
     public static void getSortAdvers(Object[] objs,List beforeSpecific,List afterSpecific,List middleAdver){
    	 Map decomposeAdvers =  new HashMap();
    	 Map otherList =  new HashMap();
    	 int index = 0;
    	 
    	 for (int i = 0; i< objs.length; i++){
    		 PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)objs[i];
    		 String specificValue = publishArrangeDetail.getSpecificValue();
    		 specificValue = specificValue == null|| "".equals(specificValue)?"0":specificValue;
    		 int times = publishArrangeDetail.getAdverTimes().intValue();
    		 boolean isSpaceAdver = publishArrangeDetail.getSpaceAdver().booleanValue();
//    		 List spaceAdverList = new ArrayList();
             
             String destBefo="123456789"; 
             String destAfter="ABCDEFGHI"; 
             int j = destBefo.indexOf(specificValue);
             int k = destAfter.indexOf(specificValue);
             
    		 if(j >- 1) beforeSpecific.add(publishArrangeDetail);
   
    		 if(j ==- 1 && k == -1) {
    			 //取得所有中间的广告，需要串开的多次广告已分解，不需要串开的多次广告只有一条，
    			 //最后才去分解联播的多次广告
//    			 decomposeAdverByTimes(isSpaceAdver,index,allMiddleAdver,publishArrangeDetail);
    			 //把需要串开的广告放入新的List,为后边排序提供参数
    			 if(isSpaceAdver && times >1){
    				 index = decomposeAdverByTimes(isSpaceAdver,index,decomposeAdvers,publishArrangeDetail);
    			 }else{
    				 otherList.put(new Integer(index),publishArrangeDetail);
    				 index++;
    			 }
    		 } 
    		 
    		 if(k > -1) afterSpecific.add(publishArrangeDetail);
    	 }
    	 
    	 //间隔的步长
		 int decomposeStep = 1;
		 otherList.putAll(decomposeAdvers);
		 decomposeAdver(decomposeAdvers,otherList,middleAdver,decomposeStep);

//    	 Collections.sort(middleAdver, new MiddleSpaceComparator());
    	 
     }
     


     
     //把需要串开的广告从MAP中取出，从所有广告中依次取出间隔放进， 所有=需要串开的广告+其它
     //同时把放过的广告移去,之后判断被移去是否是需要串开的广告，如果是则找到decomposeAdvers把它的次数设置成减1
     //把剩余的广告排除需要串开，再把最后的剩余追加到新LIST最后
     //把多次且需要固定的广告分解成多条
  
     public static  void decomposeAdver(Map decomposeAdvers,Map allList,List middleAdver,int decomposeStep){
         int fixDecomposeStep = decomposeStep;
         List keyList = new ArrayList();
         List newList = new ArrayList();
		 CollectionUtils.addAll(keyList,decomposeAdvers.keySet().iterator());
		 int  size = allList.size();
         for(Iterator it = keyList.iterator();it.hasNext();){
        	 Integer key = (Integer)it.next();
//        	 System.out.println(">>>>>>decomposeAdvers.key>>>>>>>>>"+key);
        	 Object obj = decomposeAdvers.get(key);
        	 if(obj instanceof PublishArrangeDetail){
                 PublishArrangeDetail targ = (PublishArrangeDetail)obj;
                 newList.add(targ);
                 decomposeAdvers.remove(key);
                 Object objSource = allList.get(key);
                 if(objSource instanceof PublishArrangeDetail) allList.remove(key);
//                 System.out.println(">>>>>>decomposeAdvers.remove>>>>>>>>>"+key);
                 
                 moveSourceAdver(decomposeAdvers, newList,allList, targ, decomposeStep,fixDecomposeStep,size);
                 
        	 }
         }
         
         //删除SOUR中所有需要串开的广告
         for(Iterator it = keyList.iterator();it.hasNext();){
        	 Integer key = (Integer)it.next(); 
        	 allList.remove(key);
         }
         
         //把处理后SOUR，的追加到处理好的TAR
         for(Iterator it = allList.values().iterator();it.hasNext();){
        	 PublishArrangeDetail sour = (PublishArrangeDetail)it.next(); 
        	 newList.add(sour);
         }      
         
         //把连播的广告分成多条
         decomposeAdverByTimes(middleAdver,newList);    

     }    
     public static void moveSourceAdver(Map decomposeAdvers,List middleAdver,Map allList,PublishArrangeDetail targ,int decomposeStep,int fixDecomposeStep,int size){
    	 for(int startIndex = 0;startIndex < size; startIndex++ ){
    		 Integer key = new Integer(startIndex);
        	 Object obj = allList.get(key);
        	 if(obj instanceof PublishArrangeDetail){
    			 PublishArrangeDetail sour = (PublishArrangeDetail)obj;
//    			 if(sour.getOrderDetailId().longValue() == targ.getOrderDetailId().longValue()){
    			 if(sour.getMatterId().longValue() != targ.getMatterId().longValue()){
    	    		 if(decomposeStep >0) {
    		    		 middleAdver.add(sour);
    		    		 allList.remove(key); 
    	    			 decomposeStep--;
//    	    			 System.out.println(">>>>>>key>>>>>>>>>"+ key.intValue());
    	    			 boolean isSpaceAdver = sour.getSpaceAdver().booleanValue();
    	    			 if(isSpaceAdver){
    	    				 Object o = decomposeAdvers.get(key);
    	    				 if(o instanceof PublishArrangeDetail) decomposeAdvers.remove(key);
    	    			 }
    	    			 if(decomposeStep == 0) break;
    	    			
    	    		 } 
    			 } 
        	 }
    	 }
    	
    	
     }
   
     
     //把一条明细的多次广告分解成多条相同的广告
     public static  void decomposeAdverByTimes(List allMiddleAdver,List newList){
    	 for(Iterator it = newList.iterator();it.hasNext();){
    		 PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
    		 int times = publishArrangeDetail.getAdverTimes().intValue();
        	 if(times > 1 ){
            	 for(int z = 0; z< times;z++){
        			 PublishArrangeDetail detail = new PublishArrangeDetail();
        			 try {
        				org.apache.commons.beanutils.BeanUtils.copyProperties(detail,publishArrangeDetail);
        			 } catch (IllegalAccessException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			 } catch (InvocationTargetException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			 }
        			 detail.setAdverTimes(new Integer(1));
        			 allMiddleAdver.add(detail);   
        			
        		 }	 
        	 }else{
        		 allMiddleAdver.add(publishArrangeDetail);  
        	 }
    	 }
     } 
     
     public static  int decomposeAdverByTimes(boolean isSpaceAdver,int index,Map allMiddleAdver,PublishArrangeDetail publishArrangeDetail){
    	 int times = publishArrangeDetail.getAdverTimes().intValue();
    	 
    	 System.out.println("888888888888       99999999999999           >>>>>>isSpaceAdver>>>>>>>>>"+ isSpaceAdver);
    	 
    	 if(times > 1 && isSpaceAdver){
        	 for(int z = 0; z< times;z++){
    			 PublishArrangeDetail detail = new PublishArrangeDetail();
    			 try {
    				org.apache.commons.beanutils.BeanUtils.copyProperties(detail,publishArrangeDetail);
    			 } catch (IllegalAccessException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			 } catch (InvocationTargetException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			 }
    			 detail.setAdverTimes(new Integer(1));
    			 allMiddleAdver.put(new Integer(index),detail);   
    			 index++;
    		 }	 
    	 }else{
    		 allMiddleAdver.put(new Integer(index),publishArrangeDetail);  
    		 index++;
    	 }
    	 
    	 return index;
 
     } 

     
     
     
     
     
    // 把剩余的广告排除需要串开，再把最后的剩余追加到新LIST最后
     public static  void removeDecomposeFromReleave(List tarListAll,List releaveList,List newListAll){
//    	 List newReleaveList = new ArrayList();
    	 for(Iterator it = tarListAll.iterator();it.hasNext();){
    		 PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
    		 long tagerOrderDetailId = publishArrangeDetail.getOrderDetailId().longValue();
    		 if(releaveList.size() > 0){
//    			 releaveList.remove(publishArrangeDetail);
    			 for(Iterator itLeave = releaveList.iterator();itLeave.hasNext();){
    				 PublishArrangeDetail detail = (PublishArrangeDetail)itLeave.next();
    				 int ii = releaveList.indexOf(detail);
    				 if(detail.getOrderDetailId().longValue() == tagerOrderDetailId) releaveList.remove(ii);
    			 }
    		 }else{
    			 break;
    		 }
    	 }
//    	 if(releaveList.size()>0) newListAll.add(releaveList);
    	 if(releaveList.size()>0) CollectionUtils.addAll(newListAll,releaveList.iterator());
    	 
     }
     
	  
	  public static void getOneResUsedTimes(PublishArrange publishArrange){
		  List publishArrangeDetails = publishArrange.getPublishArrangeDetails();
		  double sum = 0;
		  for(Iterator it = publishArrangeDetails.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  
//			  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>length>>>>>>>>>"+publishArrangeDetail.getMatterLength());
			  String len = StringUtil.getNullValue(publishArrangeDetail.getMatterLength(),"0");
			  double length = Double.parseDouble(len==""?"0":len);
			  int time =Integer.parseInt(StringUtil.getNullValue(publishArrangeDetail.getAdverTimes(),"0"));
//			  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>length>>>>>>>>>"+length);
			  double usedTimes = length * time;
//			  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>length * time>>>>>>>>>"+usedTimes);
			  sum += usedTimes;
		  }
//		  Integer ii = new Integer("1.12");
//		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>ii>>>>>>>>>"+ii);
//		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>ii parseDouble>>>>>>>>>"+Double.parseDouble(ii.toString()));
//		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>ii intValue>>>>>>>>>"+ii.intValue());
//		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>usedTimes>>>>>>>>>"+sum);
//		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>usedTimes>>>>>>>>>"+new Integer(sum));
		  
		 
		  
		  publishArrange.setResourceUsedTimes(new Integer((new Double(sum)).intValue()));
		  
	  }
	  
	  
		public static void getResourceIdsByState(List resLocked,List resArranged,List restNoArranged,List resourceHistory,Object[] objs){
			List restHistory = new ArrayList();
			getResourceFromHistory(resourceHistory,resLocked,resArranged,restHistory);
			Object[] objs2 = restHistory.toArray();
			
			
			for (int i = 0 ;i< objs.length;i++){
				String resourceId =(String)objs[i];
//				System.out.println(">>>>>>resourceId>>>>>>>>>"+resourceId);
				if(!ArrayUtils.contains(objs2,resourceId)){
					restNoArranged.add(resourceId);
				}
			}

			
//			System.out.println(">>>>>>resListLocked>>>>>>>>>"+resLocked.size());
//			System.out.println(">>>>>>resArranged>>>>>>>>>"+resArranged.size());
//			System.out.println(">>>>>>restNoArranged>>>>>>>>>"+restNoArranged.size());
		}
		
		
		public static void getResourceFromHistory(List resourceHistory,List resLocked,List resArranged,List restHistory){
			for(Iterator it = resourceHistory.iterator();it.hasNext();){
				PublishArrange publishArrange = (PublishArrange) it.next();
				boolean isLocked = publishArrange.getIsLocked().booleanValue();
				if(isLocked){
					resLocked.add(publishArrange.getResourceId().toString());
				}else{
					//排除锁定
					resArranged.add(publishArrange.getResourceId().toString());
				}
				restHistory.add(publishArrange.getResourceId().toString());
			
			}
			
		}
		
		
	    public static void changeArrangeId(List listResource,List listResourceHistory){
	    	Map mp = new HashMap();
			for(Iterator it = listResourceHistory.iterator();it.hasNext();){
				PublishArrange publishArrange = (PublishArrange) it.next();
				mp.put(publishArrange.getResourceId(),publishArrange);
			}
			
			for(Iterator it = listResource.iterator();it.hasNext();){
				Long curUserId = new Long(UserUtil.getCurrentPrincipalUserId());
				
				PublishArrange publishArrange = (PublishArrange) it.next();
				PublishArrange history =  (PublishArrange)mp.get(publishArrange.getResourceId());
				publishArrange.setId(history.getId());
				publishArrange.setCreateBy(curUserId);
				publishArrange.setCreateDate(history.getCreateDate());
				publishArrange.setModifyBy(curUserId);
				publishArrange.setModifyDate(new Date());
				publishArrange.setFilePath(history.getFilePath());
				publishArrange.setIsArranged(Boolean.valueOf(true));
				
			}			
			
	    }
	    
	    
	    public static void getReportColl(Collection adverColl,List resArranged,PublishArrange publish){  
	    	int totalUsedTimes = 0;
	    	String totalUsedStr;
	    	
//		    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//		    if(StringUtils.isEmpty(sysParam.getIsDisplayNoadResParam())) sysParam.setIsDisplayNoadResParam("0");
//		    boolean displayNoadRes =  (sysParam.getIsDisplayNoadResParam().equals("0"))?false:true;
		    
			for(Iterator it = resArranged.iterator();it.hasNext();){
				PublishArrange publishArrange = (PublishArrange) it.next();   
				int beforehand = Integer.parseInt(StringUtil.getNullValue(publishArrange.getBeforehand(),"0"));
				
				
				
				
				
				if(publish.getResourceMeno()!=null&&publish.getResourceName()!=null&&publishArrange.getArrangeType()!=null){
					int broadcastStartTime = publishArrange.getBroadcastStartTime().intValue();
//					int broadcastEndTime = publishArrange.getBroadcastEndTime().intValue();
					int startTime = Integer.parseInt(publish.getResourceMeno());
					int endTime = Integer.parseInt(publish.getResourceName());
					if(broadcastStartTime<startTime||broadcastStartTime>endTime){       
						publishArrange.setPublishArrangeDetails(new ArrayList());
					}
				}
				PublishedInfo publishedInfo = new PublishedInfo();
				totalUsedStr = getReportCollPostion(publishArrange, publishedInfo);
				totalUsedTimes += new Integer(totalUsedStr).intValue();
				List details = publishArrange.getPublishArrangeDetails();
				for(Iterator iter = details.iterator();iter.hasNext();){
					 PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)iter.next();
					 PublishedInfo adver = new PublishedInfo();
					 getReportCollAdvers(adverColl, publishedInfo,adver,publishArrangeDetail);
				}
				if(details.size() == 0 && getDisplayNoadResParam() && beforehand == 0 ){
					 PublishArrangeDetail publishArrangeDetail = new PublishArrangeDetail();
					 PublishedInfo adver = new PublishedInfo();
					 getReportCollAdvers(adverColl, publishedInfo,adver,publishArrangeDetail);
				}
				
				for(int i = 0 ;i<beforehand;i++){
//					 System.out.println("beforehand>>>>>>wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww>>>>>>" +i);
					 PublishedInfo adver = new PublishedInfo();
					 adver.setPosition(publishedInfo.getPosition());
				    	adver.setPublishOrder(String.valueOf(details.size()+1+i));
				    	adver.setTapeCode(" ");
				    	adver.setMatterName("");
				    	adver.setMatterEdit("");
				    	adver.setMatterLength(" ");    
				    	adver.setAppPosition(" ");
				    	adver.setPublishMemo(" ");
				    	adver.setCustomerName(" ");
				    	adver.setLinkUser(" ");
				    	
					 adverColl.add(adver);
				}
				
				
				
				
			}
//			
			adverColl.add(new Integer(totalUsedTimes));
	    }
	    
		public static boolean getResourcesLablePara(){
		    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		    if(StringUtils.isEmpty(sysParam.getResourceDisplayParam())) sysParam.setResourceDisplayParam("0");
		    return (sysParam.getResourceDisplayParam().equals("0"))?false:true;
		}
		
	    public static String getReportCollPostion(PublishArrange publishArrange,PublishedInfo publishedInfo){ 
	    	boolean isMeno = getResourcesLablePara();
	    	String resName = publishArrange.getResourceName();
	    	String resMeno = publishArrange.getResourceMeno();
	    	String resource = isMeno?resMeno+" "+resName:resName+" "+resMeno;
	    	
//	    	boolean catv = SysParamUtil.isCATVParam(null);
	    	
//	    	if(catv) resource = resName;
	    	
	    	
//	    	String resource = publishArrange.getResourceName() + publishArrange.getResourceMeno();
//	    	lable = isMeno?"["+lable+"]" +name:"["+lable+"]" + memo;
	    	
	    	String totalTimes = publishArrange.getResourceTotalTimes()==null?"0":publishArrange.getResourceTotalTimes().toString();	    	
	    	String usedTimes =publishArrange.getResourceUsedTimes()==null?"0": publishArrange.getResourceUsedTimes().toString();
	    	
	    	String totalStr =  StringUtil.second2HMS(Integer.parseInt(totalTimes));
//	    	(totalTimes);
//	    	String usedStr = getStandardTime(usedTimes);
	    	String usedStr =  StringUtil.second2HMS(Integer.parseInt(usedTimes));
	    	
	    	int leave = Integer.parseInt(totalTimes) - Integer.parseInt(usedTimes);
	    	String leaveStr = StringUtil.second2HMS(Integer.parseInt(totalTimes) - Integer.parseInt(usedTimes));
	    	String overStr = StringUtil.second2HMS(-leave);
	    	String postion ="";
	    	postion = resource + "   规定:" + totalStr +" 使用:" + usedStr;
	     	if(leave < 0){
	     		postion += " 超时:" + overStr; 
	     	}else{
	     		postion += " 剩余:" + leaveStr;
	     	}
	    	publishedInfo.setPosition(postion);
//	    	publishedInfo.setAdContent(new Integer(usedTimes).toString());
	    	return usedTimes;
	    }
	    
//	    private static String getStandardTime(String totalUsed){
//	    	Integer total = new Integer(totalUsed)==null?new Integer(0):new Integer(totalUsed);
//	    	int hour = total.intValue()/3600;
//	    	int min = total.intValue()%3600/60;
//	    	int sec = total.intValue()%3600%60%60;
//	    	return " "+hour+"时"+min+"分"+sec+"秒";
//	    }
	    
	    public static void getReportCollAdvers(Collection adverColl,PublishedInfo publishedInfo,PublishedInfo adver,PublishArrangeDetail publishArrangeDetail){ 
	    	adver.setPosition(publishedInfo.getPosition());
//	    	adver.setAdContent(publishedInfo.getAdContent());
	    	if(publishArrangeDetail.getTapeCode() != null){
		    	adver.setPublishOrder(publishArrangeDetail.getPublishSort().toString());
		    	adver.setTapeCode(publishArrangeDetail.getTapeCode());
		    	adver.setMatterName(publishArrangeDetail.getMatterName());
		    	adver.setMatterEdit(publishArrangeDetail.getMatterEdit());
		    	adver.setMatterLength(publishArrangeDetail.getMatterLength());    
		    	adver.setAppPosition(publishArrangeDetail.getSpecificName());
		    	adver.setPublishMemo(publishArrangeDetail.getPublishMemo());
		    	adver.setCustomerName(publishArrangeDetail.getCustomerName());
		    	adver.setLinkUser(publishArrangeDetail.getFirstName()+publishArrangeDetail.getLastName());
	    	}
	    	adverColl.add(adver);
	    }
	    
	    
	    
	    
	    
	    public static void getPulishArrangeFormColl(Collection adverColl,List resArranged){  
//		    String tvname = SysParamUtil.getTvNameParam();
//		    boolean isCatv = "catv".equals(tvname);
	    	for(Iterator it = resArranged.iterator();it.hasNext();){
				PublishArrange publishArrange = (PublishArrange) it.next();
//				System.out.println(">>>>>getPulishArrangeFormColl>>>kkkkkkkkkkkkkkkkkkkkkk>>>" +publishArrange.getResourceName()); 
//				System.out.println(">>>>>getPulishArrangeFormColl>>>kkkkkkkkkkkkkkkkkkkkkk>>>" +publishArrange.getResourceMeno()); 
				
				String resourceMeno= publishArrange.getResourceMeno();
				String resourceName= publishArrange.getResourceName();

				if(resourceMeno.indexOf(":")>-1||resourceMeno.indexOf("：")>-1){
						publishArrange.setResourceName(resourceMeno);
						publishArrange.setResourceMeno(resourceName);
				}	

				adverColl.add(publishArrange);
			}
	    }
//	    
		public static boolean getDisplayNoadResParam(){
		    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		    if(StringUtils.isEmpty(sysParam.getIsDisplayNoadResParam())) sysParam.setIsDisplayNoadResParam("0");
		    return (sysParam.getIsDisplayNoadResParam().equals("0"))?false:true;
		}
	    public static void getReportCollForFztv(Collection coll,List resArranged){  
	    	
	    	for(Iterator it=resArranged.iterator();it.hasNext();){
	    		PublishArrange publish = (PublishArrange)it.next();
	    		
	    		Collection adverColl = new ArrayList();
	    		FusionChartObject fObject = new FusionChartObject();
		    	double totalUsedTimes = 0;                     
		    	  
	    		List details = publish.getPublishArrangeDetails();
				for(Iterator iter = details.iterator();iter.hasNext();){
					 PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)iter.next();
					 totalUsedTimes+=Double.parseDouble(publishArrangeDetail.getMatterLength());  
		    		 FusionChartObject adver = new FusionChartObject();  
		    		 for(int i=1;i<=7;i++){
		    				switch(i){
		    					case 1:
		    						adver.setValue1("");break;
		    					case 2:
		    						adver.setValue2(publishArrangeDetail.getMatterName());break;
		    					case 3:
		    						adver.setValue3(publishArrangeDetail.getMatterEdit());break;
		    					case 4:
		    						adver.setValue4(publishArrangeDetail.getMatterLength());break;
		    					case 5:
		    						adver.setValue5(publishArrangeDetail.getOwnerUserName());break;    
		    					default :
		    				}  
		    		 }
		    		 adverColl.add(adver); 
				}
     
	    		for(int i=1;i<=7;i++){
	    				switch(i){
	    					case 1:
	    						fObject.setValue1(publish.getResourceMeno());break; 
	    					case 2:
	    						fObject.setValue2("");break;
	    					case 3:
	    						fObject.setValue3("");break;
	    					case 4:
	    						fObject.setValue4((int)totalUsedTimes+"");break;  
	    					case 5:
	    						fObject.setValue5("");break;
	    					default :
	    				}   
	    		}
	    		coll.add(fObject);                      
	    		coll.addAll(adverColl);    
	    	}
	    }   
		
}
