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
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Matter;
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
public class ArrangeUtil3 {
	
	 
	  						
	  
	  
	  
 	private static  boolean getFztvSpecialParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
	    return (sysParam.getFztvSpecialParam().equals("0"))?false:true;
	}
 	
 	private static  boolean getQztvSpecialParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getQztvSpecialParam())) sysParam.setQztvSpecialParam("0");
	    return (sysParam.getQztvSpecialParam().equals("0"))?false:true;
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
		  
           //第二级按序号
			if(parentName.startsWith("carrierId")){
				Collections.sort(resList,new PublishArrangeComparator());
			}else{
				Collections.sort(resList,new PublishArrangeEntryComparator());
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

//				  System.out.println("name >>>>>>>>>>>>>broStartTime>>>>>>>>>>>>>>>>>>>>>"+broStartTime);
//				  System.out.println("name >>>>>>>>>>>>>broEndTime>>>>>>>>>>>>>>>>>>>>>"+ broEndTime);

				  
				  if(!"00:00:00".equals(broStartTime)){

//					  电台
					  if("2".equals(orgType)){
						  broStartTime = broStartTime +"-"+broEndTime;
					  }
					 
					  
					  if(resourceDisplayParam){

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
			  getAdverList(publishArrange,details,adverList,resourceId,publishDate,state,isRoll);
			  

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
	  
	  public static void getAdverList(PublishArrange publishArrange ,List details,List adverList,Long resourceId,Integer publishDate,int state,boolean isRoll){
		  
		      boolean arrangeWithBrandParam = SysParamUtil.getArrangeWithBrandParamParam();

			  for(Iterator it = adverList.iterator();it.hasNext();){
				  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
				  Long resId = publishArrangeDetail.getResourceId();
				  if(resId == null) resId = publishArrangeDetail.getId();            
				  Integer pubDate = publishArrangeDetail.getPublishDate();

				  if(resId.longValue()== resourceId.longValue() && pubDate.intValue()== publishDate.intValue()){
					  
					  if(arrangeWithBrandParam){
						  String matterName =  publishArrangeDetail.getMatterName();
						  String brandName =  publishArrangeDetail.getBrandName();
						  if(!"...".equals(brandName) && brandName != null){
							  matterName = brandName+" "+matterName;
						  }
						  publishArrangeDetail.setMatterName(matterName);					  
					  }

					  details.add(publishArrangeDetail);
//					  System.out.println(">>>>>>getBrandId>>>>>>>>>"+publishArrangeDetail.getBrandId());
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
				  List middleAdver1 = new ArrayList();
				  List middleAdver = new ArrayList();
				  List spaceAdvers = new ArrayList();
				  List specBefoNoPlay = new ArrayList();
				  List specAfterNoPlay = new ArrayList();
				  
				  Object[] objs = details.toArray();

//                  
//				  //拆分多次的广告
//				  decomposeAdverByTimes(objs,beforeSpecific,afterSpecific,middleAdver1,spaceAdvers);
				  //如果有多次，需要串开的广告 把它与没指定的广告进行串开
//				  middleAdver = resetMiddleAdverByspaceAdvers(middleAdver1, spaceAdvers);

				  decomposeAdverByTimes2(publishArrange,objs,beforeSpecific,afterSpecific,middleAdver,spaceAdvers);

				  
//				  //修改有指定的序号
				 
				  int  befSize = beforeSpecific.size();
				  int  midSize = middleAdver.size();
				  int  afterSize =afterSpecific.size();
				  int  total =befSize + midSize +afterSize;
//				  int startRows = befSize +midSize;
				  
				  Collections.sort(beforeSpecific, new SpecificComparator());
				  List specBefoIndexs = getIndexBySepcValue(befSize,midSize,afterSize,beforeSpecific, new ArrayList(),specBefoNoPlay,0);
				  
//				  System.out.println(">>>>>>specBefoNoPlay.size()>>>>>>>>>"+specBefoNoPlay.size());
//				  System.out.println(">>>>>> specBefoIndexs>>>>>>>>>"+specBefoIndexs);
				  
				  List specBefoNoPlayIndexs = getIndexBySepcValue2(befSize,midSize,specBefoIndexs,specBefoNoPlay);
				  
				  List specBefoAllIndexs = new ArrayList();
				  specBefoAllIndexs.addAll(specBefoIndexs);
				  specBefoAllIndexs.addAll(specBefoNoPlayIndexs);
//				  System.out.println(">>>>>>specBefoAllIndexs>>>>>>>>>"+specBefoAllIndexs);
				
				  List specAfterIndexs = getIndexBySepcValue(befSize,midSize,afterSize,afterSpecific,specBefoAllIndexs,specAfterNoPlay,specBefoIndexs.size());
				 
//				  System.out.println("55555555555 >>>>>> specAfterNoPlay.size()>>>>>>>>>"+specAfterNoPlay.size());
				  
				  List specAfterNoPlayIndexs = getIndexBySepcValue3(befSize,midSize,specBefoIndexs.size(),specAfterIndexs,specAfterNoPlay);
				  
//				  Collections.sort(specAfterNoPlay, new SpecificComparator());
				  
				  List specIndexs = new ArrayList();
				  specIndexs.addAll(specBefoIndexs);
//				  System.out.println(">>>>>> specBefoIndexs>>>>>>>>>"+specBefoIndexs);
				  specIndexs.addAll(specBefoNoPlayIndexs);
//				  System.out.println(">>>>>> specBefoNoPlayIndexs>>>>>>>>>"+specBefoNoPlayIndexs);
				  specIndexs.addAll(specAfterIndexs);
//				  System.out.println(">>>>>> specAfterIndexs>>>>>>>>>"+specAfterIndexs);
				  specIndexs.addAll(specAfterNoPlayIndexs);
//				  System.out.println(">>>>>> specAfterNoPlayIndexs>>>>>>>>>"+specAfterNoPlayIndexs);

				  System.out.println(">>>>>>specIndexs>>>>>>>>>"+specIndexs);

				  if(specBefoNoPlay.size() > 0){
					  beforeSpecific.removeAll(specBefoNoPlay);
				  }
				  
				  if(specAfterNoPlay.size() > 0){
					  afterSpecific.removeAll(specAfterNoPlay);
				  }
				  
				  
				 
//				  if(isRoll) setMiddleAdveRoll(middleAdver,publishDate);
				  changeMiddleAdverSort(specIndexs,middleAdver);
				  
				  
				  
//				  System.out.println(">>>>>>beforeSpecific.size()>>>>>>>>>"+beforeSpecific.size());
//				  System.out.println(">>>>>>middleAdver.size()>>>>>>>>>"+middleAdver.size());
//				  System.out.println(">>>>>>afterSpecific.size()>>>>>>>>>"+afterSpecific.size());

				  oneResourceAdvers.addAll(beforeSpecific);
				  oneResourceAdvers.addAll(specBefoNoPlay);
				  oneResourceAdvers.addAll(middleAdver);
				  oneResourceAdvers.addAll(specAfterNoPlay);
				  oneResourceAdvers.addAll(afterSpecific);
				  
				  
//				  List specAfterAll = new ArrayList();
//				  specAfterAll.addAll(specAfterNoPlay);
//				  specAfterAll.addAll(afterSpecific);
//				  Collections.sort(specAfterAll, new SpecificComparator());
//				  oneResourceAdvers.addAll(specAfterAll);

				  //同品牌串开
				  
				  Collections.sort(oneResourceAdvers, new ArrayBrandComparator());
//				  Arrays.sort(oneResourceAdvers,new ArrayBrandComparator());
				  changeMiddleAdverSort2(specIndexs,oneResourceAdvers);

				  details.clear();
				  details.addAll(oneResourceAdvers);
				  Collections.sort(details);        
			  } 
		  }
		  
  
	  }
	  
	  public static List resetMiddleAdverByspaceAdvers(List middleAdver,List spaceAdvers){
		  Map mp = new HashMap();
		  int key = 0;
		  for(Iterator it = spaceAdvers.iterator();it.hasNext();){
			  mp.put(key++, (PublishArrangeDetail)it.next());
		  }
		  
		  
		  List ls = new ArrayList();
//		  if(middleAdver.size() >spaceAdvers.size()){
			  int index = 0;
			  for(Iterator it = middleAdver.iterator();it.hasNext();){
				  PublishArrangeDetail sour = (PublishArrangeDetail)it.next();
				  PublishArrangeDetail targ = (PublishArrangeDetail)mp.get(index);
				  
				
				  ls.add(sour);
				  
				  if(targ != null) {
					  if(sour.getMatterId().longValue() != targ.getMatterId().longValue()){
						  ls.add(targ);
						  mp.remove(index);
				      }
				  }

				  index++;

			  }		  
//		  }
			  if(mp.size()>0){
				  ls.addAll(mp.values());
			  }
			  
			  
//			  for(Iterator it = ls.iterator();it.hasNext();){
//				  PublishArrangeDetail sour = (PublishArrangeDetail)it.next();
//				  System.out.println(">>>>>>resetMiddleAdverByspaceAdvers>>>>>>>>>"+sour.getMatterName());
//			  }
			  
			  
			  
			  return ls;

	  }
	  
	  public static void reGetspecSorts(Map oneResourceAdversMap,List specSorts){
		  specSorts.clear();
		  Iterator it = oneResourceAdversMap.keySet().iterator();
		  while(it.hasNext()){
			  PublishArrangeDetail firstObject = (PublishArrangeDetail)oneResourceAdversMap.get(it.next());
		      String specificValue_first = firstObject.getSpecificValue();
	          specificValue_first = specificValue_first == null|| "".equals(specificValue_first)?"0":specificValue_first;
	          if(!"0".equals(specificValue_first)){
//	        	  specSorts.add(firstObject.getPublishSort());
	        	  specSorts.add(specificValue_first);
	          }
	        
		  }
		  
	  }
	  
	  public static int reGetMap(Map oneResourceAdversMap,List oneResourceAdvers,int i,int model,List specIndexs){
		  int lastSpecIndex = 0;
		  if(i ==0){
			  oneResourceAdversMap.clear();
			 
			  for(Iterator it = oneResourceAdvers.iterator();it.hasNext();){
				  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
				  
//				  String specificValue_first = publishArrangeDetail.getSpecificValue();
//		          specificValue_first = specificValue_first == null|| "".equals(specificValue_first)?"0":specificValue_first;
//		          if(!"0".equals(specificValue_first)){
////		        	  specSorts.add(publishArrangeDetail.getPublishSort());
//		        	  specSorts.add(specificValue_first);
//		          }
		          
				  Integer key = publishArrangeDetail.getPublishSort();
				  oneResourceAdversMap.put(key,publishArrangeDetail);
//				  System.out.println(key+">>>>>>key >>>>>>>>>"+ publishArrangeDetail.getMatterName());
			  } 
		  }
		  
		  if(i>0){
			  int lastNum = oneResourceAdvers.size();
			  
//			  System.out.println(">>>>>> model  >>>>>>>>>"+ model);
			  
			  if(model ==1){
				  //取走 放第一位  往上漂移
				  PublishArrangeDetail tarObject =  (PublishArrangeDetail) oneResourceAdversMap.get(i);
				 
				  for(int j = i;j<lastNum;j++){
					  
					  System.out.println(">>>>>> j+1  >>>>>>>>>"+ (j+1));
					  
					  PublishArrangeDetail nextObject = (PublishArrangeDetail) oneResourceAdversMap.get(j+1);
					  	  Integer sort = nextObject.getPublishSort();
					  	  if(ArrayUtils.contains(specIndexs.toArray(), sort)){
					  		 lastSpecIndex =j; 
					  	  }else{
					  		  nextObject.setPublishSort(j);
							  oneResourceAdversMap.put(j,nextObject);  
					  	  }
				  }

				  tarObject.setPublishSort(0);
				  oneResourceAdversMap.put(0, tarObject); 
//				  System.out.println(">>>>>>oneResourceAdversMap.remove >>>>>>>>>"+ lastNum);
				  oneResourceAdversMap.remove(lastNum);
				 
			  }
			  
			  if(model == 2){
				  //插入 往下漂移
				  PublishArrangeDetail tarObject =  (PublishArrangeDetail) oneResourceAdversMap.get(0);
				  for(int j = i;j<lastNum;j++){
					  PublishArrangeDetail nextObject = (PublishArrangeDetail) oneResourceAdversMap.get(j);
					  Integer sort = nextObject.getPublishSort();
					  if(ArrayUtils.contains(specIndexs.toArray(), sort)){
						  
					  }else{
						  Integer key = new Integer(j+1);
						  nextObject.setPublishSort(key);  
					  }
				  }
				  tarObject.setPublishSort(i);
				  oneResourceAdversMap.put(i,tarObject);
				  
				  for(int k=i;k<lastNum;k++){
					   PublishArrangeDetail nextObject = (PublishArrangeDetail)oneResourceAdversMap.get(k);
					   oneResourceAdversMap.put(k,nextObject);  
				   }				  
				  
				  
			  }
			  if(model == 3){
				  //取走  往上漂移
				  for(int k=i;k<lastNum;k++){
					   PublishArrangeDetail nextObject = (PublishArrangeDetail)oneResourceAdversMap.get(k+1);
					   Integer key = new Integer(k);
					   nextObject.setPublishSort(key);  
//					   oneResourceAdversMap.put(key,nextObject);  
				   }
				  for(int k=i;k<lastNum;k++){
					   PublishArrangeDetail nextObject = (PublishArrangeDetail)oneResourceAdversMap.get(k);
					   nextObject.setPublishSort(k);  
//					   oneResourceAdversMap.put(key,nextObject);  
				   }			  
				  

			  }
			  
			
			  
//			  if(model == 4){
//				  //插入 往下漂移
//				  for(int k = i;k< lastNum;k++){
//				  	  PublishArrangeDetail nextObject = (PublishArrangeDetail)oneResourceAdversMap.get(k);
//					  Integer key = new Integer(k+1);
//					  nextObject.setPublishSort(key);
//					  oneResourceAdversMap.put(key,nextObject);  
//				  }
//				  PublishArrangeDetail tarObject =  (PublishArrangeDetail) oneResourceAdversMap.get(0);
//				  tarObject.setPublishSort(i);  
//				  oneResourceAdversMap.put(i,tarObject); 
//				  oneResourceAdversMap.remove(0);
//			  }		  
			  
			  
			  

			  
		  }
		  
		  return lastSpecIndex;
	  }
	  
	  public static void changeSortByBrand(List oneResourceAdvers,List specIndexs){
		  //扫描需要串开的同品牌广告

		  Map oneResourceAdversMap = new HashMap();
		  List specSort  =  new ArrayList();
		  List targetList = new ArrayList();
		  int totalSize = oneResourceAdvers.size();
		  
		  reGetMap(oneResourceAdversMap, oneResourceAdvers,0,0,specIndexs);
		  reGetspecSorts(oneResourceAdversMap, specSort);
		  Object[] specSorts = specSort.toArray();
		  
		  
		  //判断需要同品牌串开的广告
		  
		  for(int i = 1;i< totalSize;i++){
			
//			  System.out.println(">>>>>>i >>>>>>>>>"+ i);
			  
			  //总数要大于2条才可以换位置
			  if(totalSize > 2){
				  
				  //从第二条开始，因为比较时是以当前条与上一条进行比对
				  if(i > 1){
					  
					  PublishArrangeDetail obj = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(i));
					  String specificValue1 = obj.getSpecificValue();

					  //当前条不能是指定
			          if(!ArrayUtils.contains(specSorts, specificValue1)){	 
			        	  
			        	      System.out.println(specificValue1+ ">>>>>>i >>>>>>>>>"+ i);
			        	      
							  PublishArrangeDetail preObject = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(i-1));
							  PublishArrangeDetail curObject = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(i));

							   Long pre_brand_id = preObject.getBrandId();  
							   Long cur_brand_id = curObject.getBrandId();

							   int targ_publishSort_bak = 0;
							   
							   if(pre_brand_id.longValue() == cur_brand_id.longValue()){

								   PublishArrangeDetail tarObject = (PublishArrangeDetail) oneResourceAdversMap.get(i);
								   Long targ_brand_id = tarObject.getBrandId();
								   targ_publishSort_bak = i;
								   //把当前条移到第一条且编号改为0，把被移走的位置下方所有的位置都提升一个位置，并相应修改map
//								   tarObject.setPublishSort(0);
								   //修改序号及map
//								   reGetMap(oneResourceAdversMap, oneResourceAdvers,0,1);

								   //把目标放到第一条
								   int lastSpecIndex = reGetMap(oneResourceAdversMap, oneResourceAdvers,i,1,specIndexs);

								   boolean changeed = false;
								   
								   for(int j = 1;j< totalSize;j++){

									   PublishArrangeDetail obj2 = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(j));
									   
									   String specificValue2 = obj2.getSpecificValue();
									   
									   if(!ArrayUtils.contains(specSorts, specificValue2)) { 
										   if(j > 1){
//											   System.out.println("    "+j+ "  >>>>>specSorts>>>>>>>>>");
												  PublishArrangeDetail preObject2 = (PublishArrangeDetail) oneResourceAdversMap.get(j-1);
												  PublishArrangeDetail curObject2 = (PublishArrangeDetail) oneResourceAdversMap.get(j);
												  Long pre_brand_id2 = preObject2.getBrandId();
												  Long cur_brand_id2 = curObject2.getBrandId();
												  if(targ_brand_id.longValue() != pre_brand_id2.longValue() &&  targ_brand_id.longValue() != cur_brand_id2.longValue()){
													  reGetMap(oneResourceAdversMap, oneResourceAdvers,j,2,specIndexs);	
													  changeed = true;
												  } // end  if(targ_brand_id.longValue()
										   } // end if(j > 1)

									   } // end if(!ArrayUtils.contains(specSorts.toArray(), j))
									   
									   
									   
									   if(changeed) break;
//									   reGetMap(oneResourceAdversMap, oneResourceAdvers,0);
//									   oneResourceAdvers.add(tarObject);

								   } //end for
								   
//								   if(!changeed){
////									   System.out.println("    "+changeed+ "  >>>>>changeed>>>>>>>>>");
////									   System.out.println("    "+targ_publishSort_bak+ "  >>>>>changeed>>>>>>>>>");
//									   tarObject.setPublishSort(targ_publishSort_bak);
//									   for(int pp = targ_publishSort_bak;pp<totalSize;pp++){
//										   PublishArrangeDetail object = (PublishArrangeDetail)oneResourceAdversMap.get(pp);
//										   tarObject.setPublishSort(pp+1); 
//									   }
//								   }
								   
								   
							   } // end if(pre_brand_id.longValue() == cur_brand_id.longValue()){

			          } //for(int i = 1;i< totalSize;i++)
			       
				  }


			  }
			  
			 
			  
		  }
		  
		  
		
		  
		  
//		  int leaveRowCount = brandsMap.size() -targetList.size();
//		  
//		  System.out.println(">>>>>>targetList>>>>>>>>>"+targetList);
//		  Iterator it2 = targetList.iterator();
//		  while(it2.hasNext()){
//			  Integer tar_sec =(Integer) it2.next();
////			  PublishArrangeDetail targObject = (PublishArrangeDetail)oneResourceAdversMap.get(tar_sec);
//			  Long targ_brand_id = (Long)brandsMap.get(tar_sec);
//			  
//			  System.out.println(">>>>>>tar_sec>>>>>>>>>"+tar_sec);
//			  System.out.println(">>>>>>targ_brand_id>>>>>>>>>"+targ_brand_id);
//			  System.out.println(">>>>>>specSorts>>>>>>>>>"+specSorts);
//			
//			  for(int j = 1;j<brandsMap.size()+1;j++){
//				  
//				  if(!ArrayUtils.contains(specSorts.toArray(), j)) {
//					  
//					  Long source_frist_brand_id = (Long)brandsMap.get(new Integer(j));
//
//					  int next = j+1;
//
//						  
//					  if(j == 1){
//
//							  if(leaveRowCount > 1){
//								  Long source_second_brand_id = (Long)brandsMap.get(new Integer(next));
//								  System.out.println(j + ">>>>>>source_frist_brand_id>>>>>>>>>"+source_frist_brand_id);
//								  System.out.println(next + ">>>>>>source_second_brand_id>>>>>>>>>"+source_second_brand_id);
//								  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//
//								  if( targ_brand_id != source_frist_brand_id && targ_brand_id != source_second_brand_id){
//									  PublishArrangeDetail targObject = (PublishArrangeDetail) oneResourceAdversMap.get(tar_sec);
//									  PublishArrangeDetail sourObject = (PublishArrangeDetail) oneResourceAdversMap.get(j);
//									  targObject.setPublishSort(j);
//									  sourObject.setPublishSort(tar_sec);
//								  }
//							  }
//							
//					  }else{
//							  int kk = j-1;
//							  Long pre_second_brand_id = (Long)brandsMap.get(new Integer(kk));
//							  
//							  System.out.println(kk + ">>>>>>pre_second_brand_id>>>>>>>>>"+pre_second_brand_id);
//							  System.out.println(j + ">>>>>>source_frist_brand_id>>>>>>>>>"+source_frist_brand_id);
//							  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//							  
//							  if(  targ_brand_id != pre_second_brand_id &&  targ_brand_id != source_frist_brand_id ){
//								  PublishArrangeDetail targObject = (PublishArrangeDetail) oneResourceAdversMap.get(tar_sec);
//								  PublishArrangeDetail sourObject = (PublishArrangeDetail) oneResourceAdversMap.get(j);
//								  targObject.setPublishSort(j);
//								  sourObject.setPublishSort(tar_sec);
//							  }
//							  
//						  }
//				  }
//				 
//				  
//				
//
//			  }
//		  }
//		  
		  
		  
	  }
	  
	  public static List reGetList(Map oneResourceAdversMap,int model,int startRow){
		  List ls = new ArrayList();
		  int totalSize = oneResourceAdversMap.size();
		  for(int i = startRow;i< totalSize;i++){
			  PublishArrangeDetail obj = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(i));
			  ls.add(obj);
		  }
		  return ls;
	  }
	  
	  public static void changeSortByBrand2(List oneResourceAdvers,List specIndexs){
		  //扫描需要串开的同品牌广告

		  Map oneResourceAdversMap = new HashMap();
		  List specSort  =  new ArrayList();
		  List targetList = new ArrayList();
		  int totalSize = oneResourceAdvers.size();
		  
		  reGetMap(oneResourceAdversMap, oneResourceAdvers,0,0,specIndexs);
		  reGetspecSorts(oneResourceAdversMap, specSort);
//		  Object[] specSorts = specSort.toArray();
		  Object[] specSorts = specIndexs.toArray();
		  
		  
		  //判断需要同品牌串开的广告
		  
		  for(int i = 1;i< totalSize;i++){
			
//			  System.out.println(">>>>>>i >>>>>>>>>"+ i);
			  
			  //总数要大于2条才可以换位置
			  if(totalSize > 2){
				  
				  //从第二条开始，因为比较时是以当前条与上一条进行比对
				  if(i > 1){
					  
					  PublishArrangeDetail obj = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(i));
					  Integer num1 = obj.getPublishSort();

					  //当前条不能是指定
			          if(!ArrayUtils.contains(specSorts, num1)){	 
			        	  
			        	      System.out.println( ">>>>>>i >>>>>>>>>"+ i);
			        	      
							  PublishArrangeDetail preObject = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(i-1));
							  PublishArrangeDetail curObject = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(i));

							   Long pre_brand_id = preObject.getBrandId();  
							   Long cur_brand_id = curObject.getBrandId();

							   int targ_publishSort_bak = 0;
							   
							   if(pre_brand_id.longValue() == cur_brand_id.longValue()){

								   PublishArrangeDetail tarObject = (PublishArrangeDetail) oneResourceAdversMap.get(i);
								   Long targ_brand_id = tarObject.getBrandId();
								   targ_publishSort_bak = i;
								   //把当前条移到第一条且编号改为0，把被移走的位置下方所有的位置都提升一个位置，并相应修改map
//								   tarObject.setPublishSort(0);
								   //修改序号及map
//								   reGetMap(oneResourceAdversMap, oneResourceAdvers,0,1);

								   //把目标放到第一条
//								   int lastSpecIndex = reGetMap(oneResourceAdversMap, oneResourceAdvers,i,1,specIndexs);
								   
								   List newList = reGetList(oneResourceAdversMap,0,i+1);
								   Iterator it= newList.iterator();
								   while(it.hasNext()){
									   PublishArrangeDetail object = (PublishArrangeDetail)it.next();
									   Integer num2 = obj.getPublishSort();
									   if(!ArrayUtils.contains(specSorts, num2)){	
										   Long brand_id2 = object.getBrandId();
										   if(targ_brand_id.longValue() != brand_id2.longValue()){
											
										   }
										   
									   }
								   }
								   
								   
								   

								   boolean changeed = false;
								   
								   for(int j = 1;j< totalSize;j++){

									   PublishArrangeDetail obj2 = (PublishArrangeDetail) oneResourceAdversMap.get(new Integer(j));
									   
									   String specificValue2 = obj2.getSpecificValue();
									   
									   if(!ArrayUtils.contains(specSorts, specificValue2)) { 
										   if(j > 1){
//											   System.out.println("    "+j+ "  >>>>>specSorts>>>>>>>>>");
												  PublishArrangeDetail preObject2 = (PublishArrangeDetail) oneResourceAdversMap.get(j-1);
												  PublishArrangeDetail curObject2 = (PublishArrangeDetail) oneResourceAdversMap.get(j);
												  Long pre_brand_id2 = preObject2.getBrandId();
												  Long cur_brand_id2 = curObject2.getBrandId();
												  if(targ_brand_id.longValue() != pre_brand_id2.longValue() &&  targ_brand_id.longValue() != cur_brand_id2.longValue()){
													  reGetMap(oneResourceAdversMap, oneResourceAdvers,j,2,specIndexs);	
													  changeed = true;
												  } // end  if(targ_brand_id.longValue()
										   } // end if(j > 1)

									   } // end if(!ArrayUtils.contains(specSorts.toArray(), j))
									   
									   
									   
									   if(changeed) break;
//									   reGetMap(oneResourceAdversMap, oneResourceAdvers,0);
//									   oneResourceAdvers.add(tarObject);

								   } //end for

							   } // end if(pre_brand_id.longValue() == cur_brand_id.longValue()){

			          } //for(int i = 1;i< totalSize;i++)
			       
				  }


			  }
			  
			 
			  
		  }
	  }
	  
	  
	  public static  void changeMiddleAdverSort(List specIndexs,List oneResourceAdvers){
		  int i = 0;
		  Object[] objs2 = specIndexs.toArray();
		  
		  System.out.println(">>>>>>specIndexs>>>>>>>>>"+ specIndexs);
		  
		  for(Iterator it = oneResourceAdvers.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  i++;
			  while(ArrayUtils.contains(objs2,i)){ i++; }
//			  System.out.println(">>>>>getNext>>>>>>>>>"+ i);
			  publishArrangeDetail.setPublishSort(new Integer(i));	

		  }
	  }
	  
	  public static  void changeMiddleAdverSort2(List specIndexs,List oneResourceAdvers){
		  int i = 1;
		  Object[] objs2 = specIndexs.toArray();
		  for(Iterator it = oneResourceAdvers.iterator();it.hasNext();){
			  PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
			  int k = publishArrangeDetail.getPublishSort().intValue();  
//			  System.out.println(i+ ">>>>>getNext>>>>>>>>>"+ k );
			  if(!ArrayUtils.contains(objs2,k)){
				  if(!ArrayUtils.contains(objs2,i)){
					  publishArrangeDetail.setPublishSort(new Integer(i));	
					  i++;
				  }else{
					  while(ArrayUtils.contains(objs2,i)){ i++;}
					  publishArrangeDetail.setPublishSort(new Integer(i++));	
				  }
				  
				  
			  }
		  }
	  }
	  

	  
	   public static  void decomposeAdverByTimes(Object[] objs,List beforeSpecific,List afterSpecific,List middleAdver,List spaceAdvers){
	    	 int index =1;
	         String destBefo="123456789"; 
             String destAfter="ABCDEFGHI"; 

	    	 
	    	 for (int i = 0; i< objs.length; i++){
	    		 
	    		 PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)objs[i];
	    		 String specificValue = publishArrangeDetail.getSpecificValue();
	    		 boolean isSpaceAdver = publishArrangeDetail.getSpaceAdver().booleanValue();
	    		 specificValue = specificValue == null|| "".equals(specificValue)?"0":specificValue;
	             int j = destBefo.indexOf(specificValue);
	             int k = destAfter.indexOf(specificValue);

		    	 int times = publishArrangeDetail.getAdverTimes().intValue();
		
		    	 if(times > 1){
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

//		    			 detail.setPublishSort(index);
		    			 detail.setAdverTimes(new Integer(1));
		    			 index++;
		    			
		    			 if(isSpaceAdver) {
		    				 spaceAdvers.add(detail);
		    			 }else{
		    				 middleAdver.add(detail);
		    			 }
		    		 }	 
		    	 }else{
//		    		 publishArrangeDetail.setPublishSort(index);
		    		 if(j >- 1 ||k > -1){
		    			 if(j >- 1){
		    				 beforeSpecific.add(publishArrangeDetail);
		    			 }else{
		    				 afterSpecific.add(publishArrangeDetail);
		    			 }
		    		 }else{
		    			 middleAdver.add(publishArrangeDetail);
		    		 }
		    		 
		    		 index++;
		    	 }
	    	 
	    	 }
	 
	     } 
	   
	   public static  void decomposeAdverByTimes2(PublishArrange publishArrange,Object[] objs,List beforeSpecific,List afterSpecific,List middleAdver,List spaceAdvers){
	    	 int index =1;
	         String destBefo="123456789"; 
           String destAfter="ABCDEFGHI"; 
           
           System.out.println("decomposeAdverByTimes2 >>>>>>>>>>>>>>>>>>>>>>>>>> objs.length>>>>>>>>>   "+  objs.length);

	    	 double resourceUsedTimes = 0;
	    	 for (int i = 0; i< objs.length; i++){
	    		 
	    		 PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)objs[i];
	    		 String specificValue = publishArrangeDetail.getSpecificValue();
	    		 boolean isSpaceAdver = publishArrangeDetail.getSpaceAdver().booleanValue();
	    		 specificValue = specificValue == null|| "".equals(specificValue)?"0":specificValue;
	             int j = destBefo.indexOf(specificValue);
	             int k = destAfter.indexOf(specificValue);

		    	 int times = publishArrangeDetail.getAdverTimes().intValue();
		    	 double length = Double.parseDouble( publishArrangeDetail.getMatterLength());
		    	 resourceUsedTimes +=  times*length;
		    	 
		    	 
		    	 if(times > 1){
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

//		    			 detail.setPublishSort(index);
		    			 detail.setAdverTimes(new Integer(1));
		    			 index++;
		    			 middleAdver.add(detail);
		    		 }	 
		    	 }else{
//		    		 publishArrangeDetail.setPublishSort(index);
		    		 if(j >- 1 ||k > -1){
		    			 if(j >- 1){
		    				 beforeSpecific.add(publishArrangeDetail);
		    			 }else{
		    				 afterSpecific.add(publishArrangeDetail);
		    			 }
		    		 }else{
		    			 middleAdver.add(publishArrangeDetail);
		    		 }
		    		 
		    		 index++;
		    	 }
	    	 
	    	 }
	    	
	    	 long aa = Math.round(resourceUsedTimes);
	
	    	 //自动填冲公益广告
	    	 publishArrange.setResourceUsedTimes(Integer.valueOf(aa+""));
	    	 getPublicSerAdver(publishArrange,middleAdver);
	 
	     } 
	   
	   
	
	   //公益广告自动填
	   public static void getPublicSerAdver(PublishArrange publishArrange,List<PublishArrangeDetail> middleAdver){
			SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
			String[] matterTypeList = sysParam.getDianpianParam().split(","); //垫片广告类型
			Map mp = new HashMap();
//			mp.put("matterType","3");
			mp.put("matterTypeList",matterTypeList);

			List<Matter> ls = ServiceLocator.getMatterDao().getMattersByIdList(mp);
			setPublicSerAdveRoll(ls,publishArrange.getPublishDate());
//			System.out.println("getPublicSerAdver >>>>>>>>>>>>>>>>>>>>>>>>>> ls.size()>>>>>>>>>   "+ls.size());
			
//			getOneResUsedTimes(publishArrange);
//			System.out.println("getPublicSerAdver >>>>>>>>>>>>>>>>>>>>>>>>>>getResourceUsedTimes>>>>>>>>>   "+ StringUtil.getNullValue(publishArrange.getResourceUsedTimes(),"0"));
		    double resourceLeave = Double.parseDouble(StringUtil.getNullValue(publishArrange.getResourceTotalTimes(),"0"))- Double.parseDouble(StringUtil.getNullValue(publishArrange.getResourceUsedTimes(),"0"));
			   

			double pushTimes = 0;
			PublishArrangeDetail detail = new PublishArrangeDetail();
			if(ls.size() >0){
				Matter mat = (Matter)ls.get(0);
				 Object obj = mat.getEnable();
				 Long matterId = mat.getId();
				 boolean isEnable = obj==null?false:mat.getEnable().booleanValue();
			     String tapeCode =  StringUtil.encodeStringXML(StringUtil.getResourceName(mat.getTapeCode()));
				 String matterName =  StringUtil.encodeStringXML(StringUtil.getResourceName(mat.getName()));
				 String matterEdit =  StringUtil.encodeStringXML( StringUtil.getResourceName(mat.getEdit()));
				 String matterLength = mat.getLength();
				 Long brandId = mat.getBrandId();
				 Long brandId2 = mat.getBrandId2();
				 pushTimes = Double.parseDouble(matterLength);
	
				 detail.setPublishSort(new Integer(0));
				 detail.setResourceId(new Long(0));
				 detail.setTapeCode(tapeCode);
				 detail.setMatterName(matterName);
				 detail.setMatterId(matterId);
				 detail.setMatterEdit(matterEdit);
				 detail.setMatterLength(matterLength);
				 detail.setAdverTimes(new Integer(1));
				 detail.setSpecificName("");
				 detail.setSpecificValue("");
				 detail.setOrderDayId(new Long(0));
				 detail.setOrderDetailId(new Long(0));
				 detail.setOrderId(new Long(0));
				 detail.setBrandId(brandId);
			}
			
			
		
			
			 while(resourceLeave >= pushTimes){
				 
//					System.out.println("getPublicSerAdver >>>>>>>>>>>>>>>>>>>>>>>>>>resourceLeave>>>>>>>>>   "+ resourceLeave);
					
				 PublishArrangeDetail det = new PublishArrangeDetail();
				 try {
	    				org.apache.commons.beanutils.BeanUtils.copyProperties(det,detail);
	    			 } catch (IllegalAccessException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			 } catch (InvocationTargetException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			 }
				 middleAdver.add(det);
				 resourceLeave = resourceLeave - pushTimes;
			 }
			
				
			
//		  
	   }
	   
	   //设置滚动播出
		  public static void setPublicSerAdveRoll(List adverList,Integer publishDate){
			  List positiveList = new ArrayList();
			  List negativeList = new ArrayList();
			  int size = adverList.size();
			  int days = DateUtil.getDaysOfYear(publishDate.intValue());
			  int num = days/size;
			  int max = days - num*size;
			  
			  int i = 0;
			  int k = 0;

			  for(Iterator it = adverList.iterator();it.hasNext();){
				  Matter matter = (Matter)it.next();
				  matter.setSort(new Integer(i++));
			  }
			  

			  //把序号-当前天数
			  for(Iterator it = adverList.iterator();it.hasNext();){
				  Matter matter = (Matter)it.next();
				  int no = matter.getSort().intValue();
				  int newNo = no - days;
				  if(k < max){
					  matter.setSort(new Integer(newNo));
					  k++;
				  }
			  }		

			  for(Iterator it = adverList.iterator();it.hasNext();){
				  Matter matter = (Matter)it.next();
				  int no = matter.getSort().intValue();
				  if(no >= 0){
					  positiveList.add(matter);
				  }else{
					  negativeList.add(matter);
				  }
			  }			  

			  
			  //排序
			  Collections.sort(positiveList);
			  Collections.sort(negativeList);
			  
			  adverList.clear();
			  if(positiveList.size()>0) adverList.addAll(positiveList);
			  if(negativeList.size()>0) adverList.addAll(negativeList);
		  }	  
	   	   
	   public static int getMax(Object[] intArray){
		   int max = 0; //最大的数
		   if( intArray.length >0){
			   for(int i = 0 ; i < intArray.length ; i++){ // 循环比较
				   if(intArray[i] == null) break;
				   int p = Integer.parseInt(intArray[i].toString());
			       if( p > max){max = p;}
			   }
			
		   }
		   return max; 
		  }
	   public static int getMin(Object[] intArray){
		   int min = 99999; //最大的数
		   if( intArray.length >0){
			   for(int i = 0 ; i < intArray.length ; i++){ // 循环比较
				   if(intArray[i] == null) break;
				   int p = Integer.parseInt(intArray[i].toString());
			       if( p < min){min = p;}
			   }
			
		   }
		   return min; 
		  }	   
	   
	   public static List getIndexBySepcValue(int befSize,int midSize,int afterSize,List specificList,List specBefoIndexs,List specNoPlay,int sepBeforPayNum){
		   int totalSize = befSize +midSize+afterSize;
	       String destBefo="123456789"; 
           String destAfter="ABCDEFGHI"; 
           List specIndex = new ArrayList();
           
           List specIndexTemp = new ArrayList();
           
           int index = 0;
          
           int specBefoMaxNum = getMax(specBefoIndexs.toArray());
           
           int befosepcMidRows = befSize +midSize;
           
           for(Iterator it = specificList.iterator();it.hasNext();){
	      	   PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
	           String specificValue = publishArrangeDetail.getSpecificValue();
			   specificValue = specificValue == null|| "".equals(specificValue)?"0":specificValue;
			   int j = destBefo.indexOf(specificValue);
			   int k = destAfter.indexOf(specificValue);
			   int publishSort = 0;
			   int specAfnum = 0;
			   if(j>-1){
				   publishSort = Integer.parseInt(specificValue);
//				   System.out.println(">>>>>>publishSort>>>>>>>>>"+publishSort+"__"+ (publishSort< midSize+specIndexTemp.size()));  
				   if(publishSort > midSize+specIndexTemp.size()+1 && publishSort !=1 ){
					   specNoPlay.add(publishArrangeDetail);
				   }else{
					   specIndexTemp.add(publishArrangeDetail);
				   }
				 
//				   if(publishSort > befosepcMidRows){
//					   publishSort = publishSort -befosepcMidRows;
//				   }
			   }else if(k > -1){

				  if("A".equals(specificValue)){
					  publishSort = totalSize;
				  }else if("B".equals(specificValue)){
					  publishSort = totalSize-1;
					  specAfnum =1;
				  }else if("C".equals(specificValue)){
					  publishSort = totalSize-2;
					  specAfnum =2;
				  }else if("D".equals(specificValue)){
					  publishSort = totalSize-3;
					  specAfnum =3;
				  }else if("E".equals(specificValue)){
					  publishSort = totalSize-4;
					  specAfnum =4;
				  }else if("F".equals(specificValue)){
					  publishSort = totalSize-5;
					  specAfnum =5;
				  }else if("G".equals(specificValue)){
					  publishSort = totalSize-6;
					  specAfnum =6;
				  }else if("H".equals(specificValue)){
					  publishSort = totalSize-7;
					  specAfnum =7;
				  }else if("I".equals(specificValue)){
					  publishSort = totalSize-8;
					  specAfnum =8;
				  }
				  
//				  System.out.println(">>>>>>specBefoMaxNum>>>>>>>>>"+specBefoMaxNum);
//				  System.out.println(">>>>>>midSize>>>>>>>>>"+midSize);
//				  System.out.println(">>>>>>publishSort>>>>>>>>>"+publishSort);
				  if( (publishSort <0||specAfnum> midSize-(specBefoMaxNum -sepBeforPayNum)) && publishSort!=totalSize){
					  System.out.println("777777777777777777 >>>>>>specificValue>>>>>>>>>"+specificValue);
					  specNoPlay.add(publishArrangeDetail);
//					  oneResourceAdvers.remove(publishArrangeDetail);
				  }
			   }else{
				   publishSort = 0;
			   }
			   
			   
			   
			   publishArrangeDetail.setPublishSort(publishSort);
			   
			   if(publishSort >0){
				   
//				   System.out.println("1111>>>>>>specBefoMaxNum>>>>>>>>>"+specBefoMaxNum);
//				   System.out.println("2222>>>>>>sepBeforNoPayNum>>>>>>>>>"+sepBeforNoPayNum);
				   
				   if(j>-1){
					   if(publishSort<= midSize+specIndexTemp.size()+1){
						   specIndex.add(publishSort);
					   }
					  
				   }if(k>-1 && specAfnum<= midSize-(specBefoMaxNum -sepBeforPayNum)){
					   
//					   System.out.println("1111>>>>>>specificValue>>>>>>>>>"+specificValue);
					   specIndex.add(publishSort);
				   }
				  
			   }
			  

           }
           
           return specIndex;
		   
	   }
	   
	   
	   
//	   public static int getMidadvUseForBefoSpecRowCount(){
//		   
//	   }
	   
	   public static List getIndexBySepcValue2(int befSize, int midSize,List specBefoIndexs,List specBefoNoPlay){
		   int specBefoMaxNum = getMax(specBefoIndexs.toArray());
		   Collections.sort(specBefoNoPlay);   
           List specIndex = new ArrayList();
           int specBefoNoPlaySize = specBefoNoPlay.size();
           if(specBefoNoPlaySize >0){
               int publishSort = befSize == specBefoNoPlaySize?1:specBefoMaxNum+1;
               for(Iterator it = specBefoNoPlay.iterator();it.hasNext();){
    	      	   PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
    	      	   publishArrangeDetail.setPublishSort(publishSort);
    	      	   specIndex.add(publishSort);
    	      	   publishSort++;
    			}      	   
           }


           return specIndex;
		   
	   }
	   
	   public static List getIndexBySepcValue3(int befSize, int midSize,int specBefoPlayNum,List specAfterIndexs,List specAfterNoPlay){
		   Collections.sort(specAfterNoPlay);   
           List specIndex = new ArrayList();
          
           int specAfterNoPlaySize = specAfterNoPlay.size();
           int specAfterMinNum = getMin(specAfterIndexs.toArray());
//           int ii = specBefoMaxNum+specAfterNoPlay.size()+(midSize-(befSize-specAfterNoPlay.size()));
           System.out.println("111111111111>>>>>>specAfterNoPlaySize>>>>>>>>>"+specAfterNoPlaySize);
           int publishSort = 0;
           if(specAfterIndexs.size() >0){
        	   publishSort = specAfterMinNum - specAfterNoPlay.size();
           }else{
        	   publishSort = befSize +midSize+1;
           }
           
           
           if(specAfterNoPlaySize >0){
               for(Iterator it = specAfterNoPlay.iterator();it.hasNext();){
    	      	   PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail)it.next();
    	      	   publishArrangeDetail.setPublishSort(publishSort);
    	      	   specIndex.add(publishSort);
    	      	   publishSort++;
    			}   
           }


           return specIndex;
		   
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
         List keyList = new ArrayList();//需要串开的广告
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
    	
    	 System.out.println(">>>>>>decomposeAdvers.size()>>>>>>>>>"+ decomposeAdvers.size());
    	 System.out.println(">>>>>>middleAdver.size()>>>>>>>>>"+ middleAdver.size());
    	 
    	 for(int startIndex = 0;startIndex < size; startIndex++ ){
    		 Integer key = new Integer(startIndex);
        	 Object obj = allList.get(key);
        	 if(obj instanceof PublishArrangeDetail){
    			 PublishArrangeDetail sour = (PublishArrangeDetail)obj;
//    			 if(sour.getOrderDetailId().longValue() == targ.getOrderDetailId().longValue()){
    			 
    			 System.out.println(">>>>>>sour.getMatterId().longValue()>>>>>>>>>"+ sour.getTapeCode()+"____"+targ.getTapeCode());
    			 
    			 if(sour.getMatterId().longValue() != targ.getMatterId().longValue()){
    	    		 if(decomposeStep >0) {
    		    		 middleAdver.add(sour);
    		    		 allList.remove(key); 
    	    			 decomposeStep--;
    	    			 System.out.println(">>>>>>key>>>>>>>>>"+ key.intValue());
    	    			 boolean isSpaceAdver = sour.getSpaceAdver().booleanValue();
    	    			 if(isSpaceAdver){
    	    				 Object o = decomposeAdvers.get(key);
    	    				 if(o instanceof PublishArrangeDetail) decomposeAdvers.remove(key);
    	    			 }
    	    			 if(decomposeStep == 0) break;
    	    			
    	    		 } 
    			 }else{
//    				 System.out.println(">>>>>>sour.getMatterId().longValue()>>>>>>>>>"+ sour.getMatterId().longValue()+"____"+targ.getMatterId().longValue());
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
    	 
    	 System.out.println(">>>>>>isSpaceAdver>>>>>>>>>"+ isSpaceAdver);
    	 
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
	    
	    
	   
	    
		public static boolean getResourcesLablePara(){
		    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		    if(StringUtils.isEmpty(sysParam.getResourceDisplayParam())) sysParam.setResourceDisplayParam("0");
		    return (sysParam.getResourceDisplayParam().equals("0"))?false:true;
		}
		
	  
	    
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
