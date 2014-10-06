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


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.model.PublishArrangeDetail;

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
public class ArrangeUtil2 {
	
	  public static synchronized void makeTreeGridXML(StringBuffer sb,List all,String resIdPrefix,String adverIdPrefix) {
		   	sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");    
		  
			for(Iterator it = all.iterator();it.hasNext();){
				PublishArrange publishArrange = (PublishArrange)it.next();
				makeOneResouce(sb,publishArrange,resIdPrefix,adverIdPrefix);
			 }
			
			sb.append("</rows>");
	  }
	  
	  
	  public static void makeOneResouce(StringBuffer sb,PublishArrange publishArrange,String resIdPrefix,String adverIdPrefix){
		    String resId = resIdPrefix+ "_" +publishArrange.getResourceId().toString();
		    sb.append("<row id=\""+ resId +"\">");
		    sb.append("<cell image='folder.gif'><![CDATA[" + publishArrange.getResourceName()+"[" +publishArrange.getResourceMeno()+"]"+ "]]></cell>");
		    sb.append("<cell></cell>");
		    sb.append("<cell></cell>");
		    sb.append("<cell>"+publishArrange.getResourceTotalTimes()+"</cell>");
		    sb.append("<cell></cell>");
		    sb.append("<cell></cell>");
		    sb.append("<cell></cell>");
//		    sb.append("<cell></cell>");	
		    sb.append("<cell></cell>");
		    
		    List publishArrangeDetails = publishArrange.getPublishArrangeDetails();
		    boolean isArranged = publishArrange.getIsArranged().booleanValue();
		    makeOneAdver(sb,publishArrangeDetails,isArranged,resId,adverIdPrefix);
		    
		    sb.append("</row>");
	  }
	  
	  
	  public static void makeOneAdver(StringBuffer sb,List publishArrangeDetails,boolean isArranged,String resId,String adverIdPrefix){
		  int advRowId = 0;
		  for(Iterator it = publishArrangeDetails.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  int  r = publishArrangeDetail.getAdverTimes().intValue();
			  if(isArranged) {
				     
				     makeOneRowAdver(sb,publishArrangeDetail,resId,advRowId++,adverIdPrefix);
			  }else{
				  for(int i = 1 ;i<(r+1);i++){
					  makeOneRowAdver(sb,publishArrangeDetail,resId,advRowId++,adverIdPrefix);
				  }				  
			  }
		  } 
	  }
	  
	  public static void makeOneRowAdver(StringBuffer sb,PublishArrangeDetail publishArrangeDetail,String resId,int i,String adverIdPrefix){
		  String advId = resId + "_"+ adverIdPrefix +"_"+i;
		  
		  sb.append("<row id=\""+ advId +"\">");
		  sb.append("<cell image='leaf.gif'></cell>");	
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getTapeCode())+"]]></cell>");
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterName())+"]]></cell>");
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterEdit())+"]]></cell>");
		  sb.append("<cell><![CDATA["+ StringUtil.null2String(publishArrangeDetail.getMatterLength())+"]]></cell>");
		  sb.append("<cell><![CDATA["+ publishArrangeDetail.getAdverTimes()+"]]></cell>");
//		  sb.append("<cell>=c4*c5</cell>");	
		  sb.append("<cell>"+ StringUtil.null2String(publishArrangeDetail.getSpecificName())+"</cell>");
		  sb.append("</row>");	
	  }
	  
	  

	  public static void resetList(List newList ,List resList,List adverList){
		  
		  for(Iterator it = resList.iterator();it.hasNext();){
			  PublishArrange publishArrange = (PublishArrange)it.next();
			  Long resourceId = publishArrange.getResourceId();
			  Integer publishDate = publishArrange.getPublishDate();
			  List details = new ArrayList();
			  getAdverList(details,adverList,resourceId,publishDate);
			  publishArrange.setPublishArrangeDetails(details);
			  newList.add(publishArrange);
		  }	
	  }
	  
	  
	  
	  public static void getAdverList(List details,List adverList,Long resourceId,Integer publishDate){
		  
		  for(Iterator it = adverList.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();

			  Long resId = publishArrangeDetail.getResourceId();
			  Integer pubDate = publishArrangeDetail.getPublishDate();

			  if(resId.longValue()== resourceId.longValue() && pubDate.intValue()== publishDate.intValue()){
//				  System.out.println(">>>>>>>>publishArrangeDetail>>>>>>" +publishArrangeDetail.toString());
				  details.add(publishArrangeDetail);
			  }
		  }

		  
	  }
	  

}
