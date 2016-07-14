/****************************************************************************     
 * Created on 2007-7-16                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.util.DateUtils;

import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.OrderPublic;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.model.User;

public class OrderDetailUtil {

	
	public static void copyBeanProperties(OrderDetail dest,OrderDetail source){
		dest.setId(source.getId());
		dest.setAgeRate(source.getAgeRate());
		dest.setAppRate(source.getAppRate());
		dest.setCarrier(source.getCarrier());
		dest.setCarrierId(source.getCarrierId());
//		dest.setCompages(source.getCompages());
		dest.setCompagesId(source.getCompagesId());
		dest.setContractId(source.getContractId());
		dest.setCreateBy(source.getCreateBy());
		dest.setCreateDate(source.getCreateDate());
		dest.setExecPrice(source.getExecPrice());
		dest.setFavourRate(source.getFavourRate());
		dest.setIndustryTypeId(source.getIndustryTypeId());
		dest.setIsCkecked(source.getIsCkecked());
		dest.setIsNotInSeries(source.getIsNotInSeries());
//		dest.setMatter(source.getMatter());
		dest.setMatterId(source.getMatterId());
		dest.setMatterLength(source.getMatterLength());
//		dest.setMatters(source.getMatters());
		dest.setMatteType(source.getMatteType());
		dest.setModifyBy(source.getModifyBy());
		dest.setModifyDate(source.getModifyDate());
		dest.setMoneyBalance(source.getMoneyBalance());
		dest.setMoneyBase(source.getMoneyBase());
		dest.setMoneyIn(source.getMoneyIn());
		dest.setMoneyRealpay(source.getMoneyRealpay());
//		dest.setMonthInfoMap(source.getMonthInfoMap());
		dest.setOrderCategoryId(source.getOrderCategoryId());
		dest.setOrderCategoryMain(source.getOrderCategoryMain());
//		dest.setOrderDayInfos(source.getOrderDayInfos());
		dest.setOrderId(source.getOrderId());
//		dest.setOrderPublic(source.getOrderPublic());
		dest.setParentId(source.getParentId());
		dest.setPaymentId(source.getPaymentId());
		dest.setPublishEndDate(source.getPublishEndDate());
		dest.setPublishMemo(source.getPublishMemo());
		dest.setPublishStartDate(source.getPublishStartDate());
//		dest.setResource(source.getResource());
		dest.setResourceInfoId(source.getResourceInfoId());
		dest.setResourcePriceType(source.getResourcePriceType());
		dest.setResourceSortId(source.getResourceSortId());
		dest.setResourceSpecificId(source.getResourceSpecificId());
		dest.setResourceType(source.getResourceType());
		dest.setSpecific(source.getSpecific());
		dest.setSumTimes(source.getSumTimes());
		dest.setSysPrice(source.getSysPrice());
		dest.setVersion(source.getVersion());
	}
	

	public static void setOrderDetailColl(OrderDetailColl orderDetailColl,Object[] dayTimes){

		orderDetailColl.setDay1((String)dayTimes[0]);
		orderDetailColl.setDay2((String)dayTimes[1]);
		orderDetailColl.setDay3((String)dayTimes[2]);
		orderDetailColl.setDay4((String)dayTimes[3]);	
		orderDetailColl.setDay5((String)dayTimes[4]);
		orderDetailColl.setDay6((String)dayTimes[5]);
		orderDetailColl.setDay7((String)dayTimes[6]);
		orderDetailColl.setDay8((String)dayTimes[7]);	
		orderDetailColl.setDay9((String)dayTimes[8]);
		orderDetailColl.setDay10((String)dayTimes[9]);
		orderDetailColl.setDay11((String)dayTimes[10]);
		orderDetailColl.setDay12((String)dayTimes[11]);			
		orderDetailColl.setDay13((String)dayTimes[12]);
		orderDetailColl.setDay14((String)dayTimes[13]);
		orderDetailColl.setDay15((String)dayTimes[14]);
		orderDetailColl.setDay16((String)dayTimes[15]);	
		orderDetailColl.setDay17((String)dayTimes[16]);
		orderDetailColl.setDay18((String)dayTimes[17]);
		orderDetailColl.setDay19((String)dayTimes[18]);
		orderDetailColl.setDay20((String)dayTimes[19]);	
		orderDetailColl.setDay21((String)dayTimes[20]);
		orderDetailColl.setDay22((String)dayTimes[21]);
		orderDetailColl.setDay23((String)dayTimes[22]);
		orderDetailColl.setDay24((String)dayTimes[23]);			
		orderDetailColl.setDay25((String)dayTimes[24]);
		orderDetailColl.setDay26((String)dayTimes[25]);	
		orderDetailColl.setDay27((String)dayTimes[26]);
		orderDetailColl.setDay28((String)dayTimes[27]);
		orderDetailColl.setDay29((String)dayTimes[28]);
		orderDetailColl.setDay30((String)dayTimes[29]);	
		orderDetailColl.setDay31((String)dayTimes[30]);
	}
	
	public static void setOrderDetailColl(OrderDetailColl orderDetailColl,OrderDetail orderDetail,int startMonth, int curMonth,Object[] dayTimes,Object[]  monthMonths,String carrierName,String resourceName,String broStartEndTime,String specificName,int mode){
		
		 String tvName = SysParamUtil.getTvNameParam();
//		 boolean xmtv = SysParamUtil.isXMTVParam(tvName);
//		 boolean fztv = SysParamUtil.isFZTVParam(tvName);
		 boolean catv = SysParamUtil.isCATVParam(tvName);
		 boolean sjz = SysParamUtil.isSJZTVParam(tvName);
//		 boolean qztv = SysParamUtil.isQZTVParam(tvName);
//		 boolean hntv = SysParamUtil.isHNTVParam(tvName);
		 
		orderDetailColl.setMonth(String.valueOf(curMonth));
		orderDetailColl.setMonthSysPrice( String.valueOf(monthMonths[0]));
		orderDetailColl.setMonthRelPrice( String.valueOf(monthMonths[1]));
		orderDetailColl.setMonthStart( String.valueOf(monthMonths[2]));
		orderDetailColl.setMonthEnd(String.valueOf(monthMonths[3]));
		
//		System.out.println("ccccccccccc    "+(String)monthMonths[1]);
		//设置广告资源信息

		
		
		setMonthTimes(orderDetailColl,dayTimes);
		
		orderDetailColl.setCheckState(orderDetail.getIsCkecked().toString());
		
		if(startMonth == curMonth){
			Matter matter = orderDetail.getMatter();
			orderDetailColl.setAdvName(StringUtil.encodeStringXML(matter.getName()));
			orderDetailColl.setAdvVer(StringUtil.encodeStringXML(matter.getEdit()));
			
			orderDetailColl.setTapCode( StringUtil.getNullValue(matter.getTapeCode(),""));
			orderDetailColl.setOrderSubCate(StringUtil.getNullValue(orderDetail.getOrderCategory().getName(),""));

			orderDetailColl.setCarrier(carrierName);
			orderDetailColl.setResource(resourceName);
			orderDetailColl.setBroStartEndTime(broStartEndTime);
//			System.out.println("moreChannel 0<<<<<<<<<<<<<<<<<<   "+resourceName);

//			System.out.println(">>>>   "+resName);
//			orderDetailColl.setResource( StringUtil.null2String(resourceName));
			
			orderDetailColl.setSpecific( StringUtil.null2String(specificName));
//			orderDetailColl.setLength("");
//			orderDetailColl.setCarrier(orderDetail.getResource().getCarrierId().toString());
//			orderDetailColl.setResource(orderDetail.getResource().getResourceName());
//			orderDetailColl.setSpecific( StringUtil.null2String(orderDetail.getSpecific().getName()));
			orderDetailColl.setLength(orderDetail.getMatter().getLength());
		
			
			
			
		
		}else{
//			if(mode ==2 && (qztv || xmtv)){
//				orderDetailColl.setAdvName( StringUtil.getNullValue(orderDetail.getMatter().getName(),""));
//			}else{
//				orderDetailColl.setAdvName("");	
//			}
			
			if(catv||sjz||mode ==1||mode ==2){
				orderDetailColl.setAdvName("");	
			}else{
				orderDetailColl.setAdvName( StringUtil.getNullValue(orderDetail.getMatter().getName(),""));
//				orderDetailColl.setAdvName("");	
			}
			

			orderDetailColl.setAdvVer("");
			orderDetailColl.setTapCode("");
			orderDetailColl.setCarrier("");
			orderDetailColl.setResource("");
			orderDetailColl.setBroStartEndTime("");
			orderDetailColl.setSpecific("");
			orderDetailColl.setLength("");
			orderDetailColl.setMeno("");
			orderDetailColl.setOrderSubCate("");

		}


	}
	
	public static void setMonthTimes(OrderDetailColl orderDetailColl,Object[] dayTimes){
		int monthTimes = 0;
		for(int i =0;i<dayTimes.length;i++){
			String time = (String)dayTimes[i];
			if(time !=""){
				monthTimes += Integer.parseInt(time);
			}
		}
		
		String rt = monthTimes == 0?"":String.valueOf(monthTimes);
		orderDetailColl.setMonthTimes(rt);
	}
	
	public static void setResourceInfo(OrderDetailColl orderDetailColl,OrderDetail orderDetail){
		Long resourceId=orderDetail.getResourceInfoId();
		
		String carrierName ="";
		String resourceName ="";
		
		orderDetailColl.setCarrier(carrierName);
		orderDetailColl.setResource(resourceName);
		
	}
 
	public static synchronized void makeTreeGridXML(StringBuffer sb,List all,String orgId){
		 String tvName = SysParamUtil.getTvNameParam();
//		 boolean xmtv = SysParamUtil.isXMTVParam(tvName);
		 boolean fztv = SysParamUtil.isFZTVParam(tvName);
		 boolean catv = SysParamUtil.isCATVParam(tvName);
		 boolean sjz = SysParamUtil.isSJZTVParam(tvName);
		 boolean hntv = SysParamUtil.isHNTVParam(tvName);
		 Map tempMap = new HashMap();
	   	sb.delete(0,sb.length());
//	   	String orderDetailRowCss =  "font-size:12px;";
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");    
	    int i = 1;
	    int k = 1;
	    String index ="";
	    String checkState ="";
		for(Iterator it = all.iterator();it.hasNext();){
		
			OrderDetailColl orderDetailColl = (OrderDetailColl)it.next();
			String id = orderDetailColl.getOrderDetailId();
			String month = orderDetailColl.getMonth();
			
			String publishMemo = StringUtil.getNullValue(orderDetailColl.getPublishMemo(),"");
//			System.out.println(">>>1111>>>" + id);
			int isStartRow = 0;
			if(!tempMap.containsKey(id)){
				tempMap.put(id,id);
				index = String.valueOf(i++);
				checkState = "3".equals(orderDetailColl.getCheckState())?"是":" ";
				 isStartRow = 1;
			}else{
				index ="";
				checkState = "";
			}
			
//			System.out.println("makeTreeGridXML>>^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^>1111>>>" +checkState);
//			System.out.println("makeTreeGridXML>>^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^>1111>>>" + orderDetailColl.getCheckState());
//			System.out.println("makeTreeGridXML>>^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^>1111>>>" +index);
			
			
//			sb.append("<row  id=\""+ index  +"\"" +"  style=\""+ orderDetailRowCss +"\">");
			sb.append("<row  id=\""+ k++  +"\">");
			sb.append("<userdata name=\"orderDetailId\">"+ id +"</userdata>");
			sb.append("<userdata name=\"isStartRow\">"+ isStartRow +"</userdata>");
			sb.append("<userdata name=\"checkState\">"+ orderDetailColl.getCheckState() +"</userdata>");
			
			
			System.out.println(">>>checkState>>>");
			
			if(!hntv && !sjz ){
				
				if("hbtv".equals(tvName)){
					sb.append("<cell><![CDATA["+ checkState +"]]></cell>");
				}else{
					sb.append("<cell><![CDATA["+ index +"]]></cell>");
				}

				sb.append("<cell><![CDATA["+ orderDetailColl.getCarrier() +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getResource()+"]]></cell>"); 
				sb.append("<cell><![CDATA["+ orderDetailColl.getTapCode()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getAdvName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getAdvVer()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getLength()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getOrderSubCate()  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(orderDetailColl.getMonthRelPrice())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getSpecific()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ publishMemo  +"]]></cell>");
				
				
			}else{
				sb.append("<cell><![CDATA["+ index +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.getNullValue(orderDetailColl.getAdvName(),"")  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.getNullValue(orderDetailColl.getAdvVer(),"")  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ orderDetailColl.getAdvName()+ "/"+orderDetailColl.getAdvVer()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getTapCode()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getCarrier()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getResource()  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ orderDetailColl.getMeno()  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ orderDetailColl.getOrderSubCate()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getSpecific()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDetailColl.getLength()  +"]]></cell>");
			}

			
			if(month.equals("10")||month.equals("11")||month.equals("12")){
				sb.append("<cell><![CDATA["+ month +"]]></cell>");
			}else{
				sb.append("<cell><![CDATA["+ "0"+ month +"]]></cell>");
			}
			
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay1()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay2()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay3()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay4()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay5()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay6()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay7() +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay8()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay9()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay10()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay11()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay12()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay13()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay14()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay15() +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay16()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay17()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay18()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay19()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay20()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay21()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay22()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay23()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay24()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay25()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay26()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay27()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay28()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay29()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay30()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetailColl.getDay31()  +"]]></cell>");

			sb.append("<cell><![CDATA["+ orderDetailColl.getMonthTimes() +"]]></cell>");
			
			if(!hntv && !sjz){
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(orderDetailColl.getMonthRelPrice())  +"]]></cell>");
			}

			sb.append("<userdata name=\"times\">"+ orderDetailColl.getMonthTimes()+"</userdata>");
			sb.append("<userdata name=\"price\">"+ StringUtil.doubleFormat(orderDetailColl.getMonthRelPrice())+"</userdata>");
			sb.append("</row>");

		 }
		
		sb.append("</rows>");
  }
	
	
	private  static String getOrderDetailRowCss(int rowIdx,OrderDetail orderDetail,Map orderDetailChangedTimeMap,String orderId ){
		
		 Object orderCheckTimeObj = ServiceLocator.getOaWorkFlowCheckDao().getOrderCheckLastTime(new Long(orderId));
		 
		 String orderDetailRowCss = "";
		 String changColor = "";
		 if(rowIdx%2 == 0){
			 orderDetailRowCss = "uneven";
		 }else{
			 orderDetailRowCss = "even";
		 }		 
		 
		 if(orderCheckTimeObj != null){
			 
			 boolean isChange= false;
			 
			 Long id = orderDetail.getId();
			 
			 Date orderCheckTime  =(Date)orderCheckTimeObj;
			 Date logDate  =(Date)orderDetailChangedTimeMap.get(id);
			 Date detailCreateDate = orderDetail.getCreateDate();
			 detailCreateDate = detailCreateDate == null? new Date():detailCreateDate;

			 Date detailModDate = orderDetail.getModifyDate();
			 detailModDate = detailModDate == null? detailCreateDate:detailModDate;
			
			 if(detailModDate.getTime() > orderCheckTime.getTime() ){
				 
				 
//				 if(logDate != null ){
//					  isChange = logDate.getTime() >= detailModDate.getTime();
//					  changColor = "uneven_red";
//				 }else{
//					  isChange = detailCreateDate.getTime() == detailModDate.getTime();
//					  changColor = "uneven_greed";
//				 }
				 
				 
				 if(logDate != null ){
					 
//					 System.out.println("getOrderDetailRowCss logDate "+ logDate.getTime());
//					 System.out.println("getOrderDetailRowCss detailCreateDate "+ detailCreateDate.getTime());
//					 System.out.println("getOrderDetailRowCss detailModDate "+ detailModDate.getTime());
					 
					 if(detailModDate.getTime()>detailCreateDate.getTime()){
						 changColor = "uneven_red";	isChange = true;
					 }
					 
					 if(detailModDate.getTime()==detailCreateDate.getTime()){
						 changColor = "uneven_greed";	isChange = true;
					 }
					 
//					 isChange = detailCreateDate.getTime() == detailModDate.getTime();
//					 if(isChange)    changColor = "uneven_greed";
//					 
//					 boolean isChange2 = logDate.getTime() >= detailModDate.getTime() && detailModDate.getTime()>detailCreateDate.getTime();
//					 if(isChange2)  changColor = "uneven_red";					 
				 }

				
				 
			 }

//			 boolean isChecked = !"3".equals(orderDetail.getIsCkecked().toString());
//			 boolean isChangeColor = isChecked && isChange;
			 
//			 System.out.println("getOrderDetailRowCss orderCheckTime"+ orderCheckTime.getTime());
			
			
//			 
//			 System.out.println("getOrderDetailRowCss getIsCkecked"+ orderDetail.getIsCkecked());
			 
			 

			 
			 if(isChange) orderDetailRowCss = orderDetailRowCss.concat(" ").concat(changColor); 
		 }
		

		return orderDetailRowCss;
	}
	
	
	private  static String getOrderDetailRowCss2(int rowIdx,OrderDetail orderDetail){

		 String orderDetailRowCss = "";
		 String changColor = "";
		 if(rowIdx%2 == 0){
			 orderDetailRowCss = "uneven";
		 }else{
			 orderDetailRowCss = "even";
		 }		 
		 
			 changColor = orderDetail.getIsCkecked().intValue() != 3?"uneven_red":"";
			 orderDetailRowCss = orderDetailRowCss.concat(" ").concat(changColor); 

		return orderDetailRowCss;
	}
	
	private  static String getOrderDetailRowCss3(int rowIdx,OrderDetail orderDetail){

		 String orderDetailRowCss = "";
		 String changColor = "";
		 if(rowIdx%2 == 0){
			 orderDetailRowCss = "uneven";
		 }else{
			 orderDetailRowCss = "even";
		 }		 
		 
		 
//		 System.out.println("vvvvvvvvvvvvvvvvvv orderDetail.getMemo() >>>>>>>>>>>>>>>" + orderDetail.getMemo());
		 
			 changColor = !"[]".equals(orderDetail.getMemo()) && orderDetail.getMemo() !=null?"uneven_red":"";
			 orderDetailRowCss = orderDetailRowCss.concat(" ").concat(changColor); 

		return orderDetailRowCss;
	}
 	
	public static synchronized void makeTreeGridXML2(StringBuffer sb,List all, String pageIndex, String pageSize,String loginUser,String orgId,String tableModel,String orderId){
//		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
////		多频道或单频道
//		boolean isChann = (sysParam.getChannelModelParam().equals("0")|| sysParam.getChannelModelParam() == null)?false:true;
		//广告资源显示备注或名称

		 String tvName = SysParamUtil.getTvNameParam();
//		 boolean xmtv = SysParamUtil.isXMTVParam(tvName);
		 boolean fztv = SysParamUtil.isFZTVParam(tvName);
		 boolean hbtv = SysParamUtil.isHBTVParam(tvName);
//		 boolean isMeno = SysParamUtil.getResourceDisplay();
		 boolean rightSave = UserUtil.isGrandedRes(loginUser,"tag_orderDetail_save");
		 
		 
		
		 
		 Map orderDetailChangedTimeMap = ServiceLocator.getOrderLogDao().getOrderLogLastModifyDate(orderId);

			
		System.out.println("tableModel>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ tableModel);
		
		int skip =Integer.parseInt(pageIndex)  * Integer.parseInt(pageSize) ;
		
//	   	sb.delete(0,sb.length());
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");    
	    int i = skip+1;
	    int kk = 0;
	    
//	    Matter matter = new Matter();
		for(Iterator it = all.iterator();it.hasNext();){
//			long start1 = System.currentTimeMillis();
			
			OrderDetail orderDetail = (OrderDetail)it.next();
//			String id = orderDetail.getId().toString();
			
			String orderCheckState = orderDetail.getOrder().getIsCkecked().toString();
			boolean removeEnable = !"1".equals(orderCheckState) && !"2".equals(orderCheckState) && !"3".equals(orderCheckState);
			
			Matter matter = orderDetail.getMatter();
			Resource resource = orderDetail.getResource();
			OrderPublic orderPublic = orderDetail.getOrderPublic();
			
			String startDate = StringUtil.null2String(orderPublic.getPublishStartDate());
			String endDate = StringUtil.null2String(orderPublic.getPublishEndDate());
			
			if("4".equals(tableModel) || "5".equals(tableModel)){
				startDate = startDate =="0"?"":startDate.substring(0,4)+"/"+startDate.substring(4,6)+"/"+startDate.substring(6,8);
				endDate = endDate =="0"?"":endDate.substring(0,4)+"/"+endDate.substring(4,6)+"/"+endDate.substring(6,8);;
			}else{
				startDate = startDate =="0"?"":startDate.substring(4,6)+"/"+startDate.substring(6,8);
				endDate = endDate =="0"?"":endDate.substring(4,6)+"/"+endDate.substring(6,8);;
			}
			



			String specificName =  StringUtil.null2String(orderDetail.getSpecific().getName());
			
			
			String times = orderPublic.getTimes().toString();
			String useTime = orderPublic.getUseTime();
			
			
			Long compagesId  = orderDetail.getCompagesId();
//			long resourceSortId  = orderDetail.getResourceSortId().longValue();
			compagesId = compagesId ==null  ? new Long("0") :compagesId;
			String pos = "";
			String id = orderDetail.getId().toString();
			
		    //套装 
//			if(resourceSortId == 2){
//				pos = "<a href=\"javascript:void 0\" onClick= getCompagesDetailPage("+compagesId.longValue()+ ","+ id.longValue() +")>" +orderDetail.getCompages().getName()+ "</a>";
//			}else{
			    pos = ResourceUtil.getResourceName2(orderDetail.getResource(),3,orgId);
//				pos = isMeno?resource.getMemo() +"  ["+ resource.getResourceName()+"]":resource.getResourceName() +" [" + resource.getMemo()+"]";
//			}
//			if(resourceSortId ==2) pos = orderDetail.getCompages().getName();

//			String orderDetailRowCss =  "CURSOR: pointer;";
			
//	         if(i%2 == 0){
//	        	 orderDetailRowCss = "BACKGROUND-COLOR: #ECEFF4;CURSOR: pointer;";
//	            }else{
//	             orderDetailRowCss = "BACKGROUND-COLOR: #f5f5f5;CURSOR: pointer;";
//	  	     }
			
//			Long id = orderDetail.getId();
//			sb.append("<row  id=\""+ id  +"\"" +"  style=\""+ orderDetailRowCss +"\">");
	    String orderDetailRowCss ="";
	          //3是播出证明
		   if("3".equals(tableModel)){
			   orderDetailRowCss = getOrderDetailRowCss3(i,orderDetail);
		   }else{
			   if(hbtv){
						 orderDetailRowCss = getOrderDetailRowCss2(i,orderDetail);
			   }else{
						  orderDetailRowCss = getOrderDetailRowCss(i,orderDetail,orderDetailChangedTimeMap,orderId);
			   }
		   	}

	
			    	
//			sb.append("<row  id=\""+ id  +"\"  style=\""+ orderDetailRowCss +"\">");
		   
		   if("5".equals(tableModel)){
			   kk++;
//			   sb.append("<row  id=\""+ new Date().getTime() +kk +"\"  class=\""+ orderDetailRowCss +"\">");
			   sb.append("<row  id=\""+ new Random().nextInt() +"\"  class=\""+ orderDetailRowCss +"\">");
			   
			   
		   }else{
			   sb.append("<row  id=\""+ id  +"\"  class=\""+ orderDetailRowCss +"\">");
		   }
			
			
			if("3".equals(tableModel)){
				sb.append("<userdata name=\"no_input_time_dates\">"+ orderDetail.getMemo()+"</userdata>");
			}
			
			if("1".equals(tableModel)){
				sb.append("<cell></cell>");
			}
//			if("3".equals(tableModel)){
//				sb.append("<cell><![CDATA[ sdff sfd ]]></cell>");
//			}		

			
			if("4".equals(tableModel)){
				sb.append("<cell></cell>");
			}
			
			
			if(!"4".equals(tableModel) && !"5".equals(tableModel)){
				sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
			}
			
			
			
			
			sb.append("<cell><![CDATA["+ pos  +"]]></cell>");
//			if(fztv || xmtv){
			if(!"4".equals(tableModel)&& !"5".equals(tableModel)){
				sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(matter.getName())  +"]]></cell>");
			}
				
//			}
			//sb.append("<cell><![CDATA["+ orderDetail.getMatter().getName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(matter.getEdit())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetail.getMatterLength()  +"]]></cell>");
			
//			if("3".equals(tableModel)){
////				sb.append("<cell xmlcontent=\"1\" editable=\"0\"><option value=\"1\">one</option> <option value=\"2\">two</option> <option value=\"3\">three</option></cell>");
//				sb.append("<cell>1</cell>");
//			}else{
//				sb.append("<cell><![CDATA["+ specificName  +"]]></cell>");
//			}
			sb.append("<cell><![CDATA["+ specificName  +"]]></cell>");

			sb.append("<cell><![CDATA["+ startDate +"]]></cell>");
			sb.append("<cell><![CDATA["+ endDate +"]]></cell>");
			
			if("4".equals(tableModel) || "5".equals(tableModel)){
				sb.append("<cell><![CDATA["+ orderDetail.getOrderCategoryId() +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDetail.getSysPrice()) +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDetail.getExecPrice()) +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(new Double(orderDetail.getFavourRate().doubleValue()*100)) +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat(new Double(orderDetail.getAppRate().doubleValue()*100)) +"]]></cell>");
//				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderPublic.getMoneyBalance()) +"]]></cell>");
				if("4".equals(tableModel)){
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDetail.getMoneyBalance()) +"]]></cell>");
				}else{
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderPublic.getMoneyBalance()) +"]]></cell>");
				}
				
//				sb.append("<cell><![CDATA["+ orderDetail.getMoneyBalance() +"]]></cell>");
				
//				 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx          vvvvvvvvvvvvvvvvvv orderDetail.getMoneyBalance() >>>>>>>>>>>>>>>" + orderDetail.getMoneyBalance());
			}
			
			sb.append("<cell><![CDATA["+ orderPublic.getTimes() +"]]></cell>");
			
			if("4".equals(tableModel) || "5".equals(tableModel)){
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderPublic.getMoneyRealpay()) +"]]></cell>");
				
				 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx          vvvvvvvvvvvvvvvvvv orderPublic.getMoneyRealpay() >>>>>>>>>>>>>>>" + orderPublic.getMoneyRealpay());
				 
//				sb.append("<cell><![CDATA["+ StringUtil.getNullValue(orderDetail.getIsMonMoney(),"0")+"]]></cell>");
//				System.out.println("makeTreeGridXML2 ["+i+"] >>>>>>>>> >>>   "+  orderDetail.getIsMonMoney() +" (ss) ");
			}
//			sb.append("<cell src=image/button_delete.gif><![CDATA["+"^javascript:deleteOrderDetail(this)^;<image src=image/button_delete.gif onclick=\"javascript:deleteOrderDetail(this)\"/>" +"]]></cell>");
//			sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif onclick=\"javascript:deleteOrderDetail("+ id +");\" >"+"]]></cell>");
//			sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif onclick=\"javascript:deleteOrderDetail("+ id.longValue() +");\" >"+"]]></cell>");
			
			if(!"4".equals(tableModel) && !"5".equals(tableModel)){
				if(rightSave && removeEnable){
					sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif \" >"+"]]></cell>");
				}else{
					sb.append("<cell></cell>");
				}
			}

			
			
//			sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif onclick=\"javascript:mygrid.deleteSelectedItem();\" >"+"]]></cell>");
			
//			System.out.println("makeTreeGridXML2 ["+i+"] >>>>>startDate >>>   "+  orderPublic.getPublishStartDate() +" (ss) ");
			
			

			
			if("4".equals(tableModel) || "5".equals(tableModel)){
				String pos2 = ResourceUtil.getResourceName2(orderDetail.getResource(),5,orgId);
				sb.append("<userdata name=\"matterId\">"+ orderDetail.getMatterId()+"</userdata>");
				sb.append("<userdata name=\"resourceId\">"+  orderDetail.getResourceInfoId()+"</userdata>");
				sb.append("<userdata name=\"pos\">"+ pos2+"</userdata>");
				sb.append("<userdata name=\"id\">"+ id +"</userdata>");
				sb.append("<userdata name=\"length\">"+ orderDetail.getMatterLength()+"</userdata>");
				
				if( "5".equals(tableModel)){
					sb.append("<userdata name=\"year_month\">"+ StringUtil.null2String(orderPublic.getPublishStartDate()).substring(0,6) +"</userdata>");
				}

			}else{
				sb.append("<userdata name=\"startDate\">"+ orderPublic.getPublishStartDate()+"</userdata>");
				sb.append("<userdata name=\"endDate\">"+ orderPublic.getPublishEndDate()+"</userdata>");
				sb.append("<userdata name=\"matterId\">"+ orderDetail.getMatterId()+"</userdata>");
				sb.append("<userdata name=\"edit\"><![CDATA["+ matter.getEdit()+"]]></userdata>");
				sb.append("<userdata name=\"length\">"+ orderDetail.getMatterLength()+"</userdata>");
				
				sb.append("<userdata name=\"customerId\">"+ matter.getCustomerId()+"</userdata>");
				sb.append("<userdata name=\"matterType\">"+ matter.getMatterType()+"</userdata>");
				sb.append("<userdata name=\"helpCodeName\">"+ matter.getHelpCodeName()+"</userdata>");
				sb.append("<userdata name=\"helpCodeEdit\">"+ matter.getHelpCodeEdit()+"</userdata>");
				
				sb.append("<userdata name=\"brandId\">"+ orderDetail.getIndustryTypeId()+"</userdata>");
				sb.append("<userdata name=\"resourceInfoId\">"+ orderDetail.getResourceInfoId()+"</userdata>");
				
				sb.append("<userdata name=\"times\">"+ times+"</userdata>");
				sb.append("<userdata name=\"useTime\">"+ useTime+"</userdata>");
				
				int lockedLasterDate = Integer.valueOf(StringUtil.null2String(orderDetail.getLockedLasterDate()));
				String d = DateUtil.convertDateToString("yyyyMMdd", new Date());
				if(lockedLasterDate>0){
					 d = DateUtil.convertDateToString("yyyyMMdd",String.valueOf(lockedLasterDate),1);
				}
				
				sb.append("<userdata name=\"lockedLasterDate\">"+ d+"</userdata>");
				System.out.println("makeTreeGridXML2########################################### lockedLasterDate>>>>>>>>   "+ d +"  ");
			}
  	    
			
			sb.append("</row>");
			
//			long end1 = System.currentTimeMillis();
//			System.out.println("makeTreeGridXML2################################################################ ["+i+"] >>>>>>>>   "+ useTime +" (ss) ");

		 }
		

		
		sb.append("</rows>");
  }
	
	public static  void makeTreeGridXML3(StringBuffer sb,List all, String pageIndex, String pageSize){
//		SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
////		多频道或单频道
//		boolean isChann = (sysParam.getChannelModelParam().equals("0")|| sysParam.getChannelModelParam() == null)?false:true;
		//广告资源显示备注或名称
		 String tvName = SysParamUtil.getTvNameParam();
//		 boolean xmtv = SysParamUtil.isXMTVParam(tvName);
//		 boolean fztv = SysParamUtil.isFZTVParam(tvName);
		 boolean isMeno = SysParamUtil.getResourceDisplay();
		 
		int skip =Integer.parseInt(pageIndex)  * Integer.parseInt(pageSize) ;
		
//	   	sb.delete(0,sb.length());
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");    
	    int i = skip+1;
	    
//	    Matter matter = new Matter();
		for(Iterator it = all.iterator();it.hasNext();){
			long start1 = System.currentTimeMillis();
			
			OrderDetail orderDetail = (OrderDetail)it.next();
			Matter matter = orderDetail.getMatter();
			Resource resource = orderDetail.getResource();
			OrderPublic orderPublic = orderDetail.getOrderPublic();
			
			String startDate = StringUtil.null2String(orderPublic.getPublishStartDate());
			String endDate = StringUtil.null2String(orderPublic.getPublishEndDate());
			startDate = startDate =="0"?"":startDate.substring(4,6)+"/"+startDate.substring(6,8);
			endDate = endDate =="0"?"":endDate.substring(4,6)+"/"+endDate.substring(6,8);;

			String specificName =  StringUtil.null2String(orderDetail.getSpecific().getName());
			
			
			Long compagesId  = orderDetail.getCompagesId();
			long resourceSortId  = orderDetail.getResourceSortId().longValue();
			compagesId = compagesId ==null  ? new Long("0") :compagesId;
			String pos = "";
			Long id = orderDetail.getId();
			
			if(resourceSortId ==1) pos = isMeno?resource.getMemo() +"  ["+ resource.getResourceName()+"]":resource.getResourceName() +" [" + resource.getMemo()+"]";
			if(resourceSortId ==2) pos = "<a href=\"javascript:void 0\" onClick= getCompagesDetailPage("+compagesId.longValue()+ ","+ id.longValue() +")>" +orderDetail.getCompages().getName()+ "</a>";
//			if(resourceSortId ==2) pos = orderDetail.getCompages().getName();

//			String orderDetailRowCss =  "CURSOR: pointer;";
			
//	         if(i%2 == 0){
//	        	 orderDetailRowCss = "BACKGROUND-COLOR: #ECEFF4;CURSOR: pointer;";
//	            }else{
//	             orderDetailRowCss = "BACKGROUND-COLOR: #f5f5f5;CURSOR: pointer;";
//	  	     }
			
//			Long id = orderDetail.getId();
//			sb.append("<row  id=\""+ id  +"\"" +"  style=\""+ orderDetailRowCss +"\">");
			sb.append("<row  id=\""+ id  +"\">");
			
			sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
			sb.append("<cell><![CDATA["+ pos  +"]]></cell>");
//			if(fztv || xmtv){
				sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(matter.getName())  +"]]></cell>");
//			}
	
			//sb.append("<cell><![CDATA["+ orderDetail.getMatter().getName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(matter.getEdit())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderDetail.getMatterLength()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ specificName  +"]]></cell>");

			sb.append("<cell><![CDATA["+ startDate +"]]></cell>");
			sb.append("<cell><![CDATA["+ endDate +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderPublic.getTimes() +"]]></cell>");
//			sb.append("<cell src=image/button_delete.gif><![CDATA["+"^javascript:deleteOrderDetail(this)^;<image src=image/button_delete.gif onclick=\"javascript:deleteOrderDetail(this)\"/>" +"]]></cell>");
//			sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif onclick=\"javascript:deleteOrderDetail("+ id +");\" >"+"]]></cell>");
//			sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif onclick=\"javascript:deleteOrderDetail("+ id.longValue() +");\" >"+"]]></cell>");
			sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif \" >"+"]]></cell>");
//			sb.append("<cell><![CDATA["+"<img src=image/button_delete.gif onclick=\"javascript:mygrid.deleteSelectedItem();\" >"+"]]></cell>");
			 
			sb.append("</row>");
			
			long end1 = System.currentTimeMillis();
//			System.out.println("makeTreeGridXML2["+i+"]>>>>>>>>   "+ (end1 -start1) +" (ss) ");

		 }
		

		
		sb.append("</rows>");
  }

	
	public static  String makeTreeGridXML3(List all){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		int i=0;
		for(Iterator it = all.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();
			sb.append("<row  id=\""+ i++  +"\">");
			sb.append("<cell image=\"folder.gif\"><![CDATA["+ customerProduct.getIndustryType()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ customerProduct.getMatterName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getPutOn())  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ customerProduct.getOrderCode() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getTimeUsed())  +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	

	public static  String makeTreeGridXML30(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		Map mapIndustryType = (Map)map.get("mapIndustryType");
		
		double res[] = new  double[3];
		double sum = sumIndustryType(mapIndustryType);
		double sumTime = sumIndustryTypeTimes(mapIndustryType);
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				
				Double relIncome = customerProduct.getRelIncome();
				Double putOn = customerProduct.getPutOn();
				Double times = customerProduct.getTimeUsed();
				res[0] += relIncome.doubleValue();
				res[1] += putOn.doubleValue();
				res[2] += times.doubleValue();				
				
				List cutList = (List)map.get(key);

//				sb.append("<row  id=\""+ key   +"\" open=\"1\">");
				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ key +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(customerProduct.getRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(customerProduct.getPutOn())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(customerProduct.getTimeUsed())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),sum)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getTimeUsed().doubleValue(),sumTime)  +"]]></cell>");
//				makeChiled(cutList,key,sb,customerProduct.getRelIncome().doubleValue());
				makeChiled30(cutList,key,sb,customerProduct.getRelIncome().doubleValue(),times);
				sb.append("</row>");
			}
		}
		
		
		if(map.keySet().size() >0){
			sb.append("<row  id=\""+ "total"   +"\">");
			sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[1]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(res[2]))  +"]]></cell>");
			sb.append("</row>");
		
		}
		
		
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	
	private static double sumIndustryType(Map mapIndustryType){
		double res[] = new  double[1];
		for (Iterator it = mapIndustryType.values().iterator(); it.hasNext();) {
			CustomerProduct customerProduct = (CustomerProduct)it.next();
			Double relIncome = customerProduct.getRelIncome();
			res[0] += relIncome.doubleValue();
			}
		if(mapIndustryType.size()==0) res[0]=0;
		return res[0];
	}
	private static double sumIndustryTypeTimes(Map mapIndustryType){
		double res[] = new  double[1];
		for (Iterator it = mapIndustryType.values().iterator(); it.hasNext();) {
			CustomerProduct customerProduct = (CustomerProduct)it.next();
			Double relIncome = new Double(StringUtil.getNullValue(customerProduct.getTimeUsed(),"0"));
			res[0] += relIncome.doubleValue();
			}
		if(mapIndustryType.size()==0) res[0]=0;
		return res[0];
	}	
	private static void makeChiled(List oneIndusty,String key,StringBuffer sb,double relIncome){
		int i=1;
		for(Iterator it = oneIndusty.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");
//			sb.append("<cell>"+ key +"</cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ customerProduct.getMatterName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getPutOn())  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ customerProduct.getOrderCode() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getTimeUsed())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),relIncome) +"]]></cell>");
			sb.append("</row>");
		 }	
	}
	private static void makeChiled30(List oneIndusty,String key,StringBuffer sb,double relIncome,double times){
		int i=1;
		for(Iterator it = oneIndusty.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");
//			sb.append("<cell>"+ key +"</cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ customerProduct.getMatterName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getPutOn())  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ customerProduct.getOrderCode() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getTimeUsed())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),relIncome) +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getTimeUsed().doubleValue(),times) +"]]></cell>");
			sb.append("</row>");
		 }	
	}	
	
	public static  String makeTreeGridXML4(List all){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		int i=0;
		for(Iterator it = all.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();
			sb.append("<row  id=\""+ i++  +"\">");
			sb.append("<cell><![CDATA["+ customerProduct.getIndustryType()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ customerProduct.getUsed() +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	public static  String makeTreeGridXML5(List all){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		int i=0;
		for(Iterator it = all.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();

			
			sb.append("<row  id=\""+ i++  +"\">");
			sb.append("<cell><![CDATA["+ customerProduct.getCustomerName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ customerProduct.getMatterName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+  StringUtil.doubleFormat2(customerProduct.getRelIncome()) +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	public static  String makeTreeGridXML50(Map map){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		Map mapIndustryType = (Map)map.get("mapIndustryType");
		
		double res[] = new  double[3];
		double sum = sumIndustryType(mapIndustryType);
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				
				Double relIncome = customerProduct.getRelIncome();
				Double putOn = customerProduct.getPutOn();
				Double times = customerProduct.getTimeUsed();
				res[0] += relIncome.doubleValue();
				res[1] += putOn.doubleValue();
				res[2] += times.doubleValue();				
				
				List cutList = (List)map.get(key);

//				sb.append("<row  id=\""+ key   +"\" open=\"1\">");
				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ key +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getPutOn())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getTimeUsed())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),sum)  +"]]></cell>");
				makeChiled(cutList,key,sb,customerProduct.getRelIncome().doubleValue());
				sb.append("</row>");
			}
		}
		
		
		if(map.keySet().size() >0){
			sb.append("<row  id=\""+ "total"   +"\">");
			sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[1]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[2]))  +"]]></cell>");
			sb.append("</row>");
		
		}
		
		
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	private static void makeChiledCustomerName(List oneCustomer,String key,StringBuffer sb){
		int i=1;
		for(Iterator it = oneCustomer.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");
//			sb.append("<cell>"+ key +"</cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ customerProduct.getCustomerName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
			sb.append("</row>");
		 }	
	}
	
	public static  String makeTreeGridXML(Map map,Map mapChannel,List channels){
		
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		Map mapIndustryType = (Map)map.get("mapIndustryType");
		
		Map sumRelIncomeMp = new HashMap();
		double res[] = new  double[3];
		double sum = sumIndustryType(mapIndustryType);

		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				
				Double relIncome = customerProduct.getRelIncome();
				Double putOn = customerProduct.getPutOn();
				Double times = customerProduct.getTimeUsed();
				
				Map channelMp = new HashMap();
				for (Iterator its = mapChannel.keySet().iterator(); its.hasNext();) {
					String keys = (String)its.next();
					if(keys.indexOf(key)!=-1){
						int length = keys.length();
						String channelKey= keys.substring(length-2,length);  
						
						Double o = (Double)channelMp.get(channelKey);
						Double s = (Double)mapChannel.get(keys);
						if(o == null){
							channelMp.put(channelKey,s);    
						}else{
							channelMp.put(channelKey,new Double(o.doubleValue()+s.doubleValue()));
						}
					}
				}
				
				res[0] += relIncome.doubleValue();
				res[1] += putOn.doubleValue();
				res[2] += times.doubleValue();				
				
				List cutList = (List)map.get(key);

//				sb.append("<row  id=\""+ key   +"\" open=\"1\">");  
				sb.append("<row  id=\""+ key   +"\">");
				sb.append("<cell image=\"folder.gif\">"+ key +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
				for(Iterator its=channels.iterator();its.hasNext();){         
					ResourceChannel rc = (ResourceChannel)its.next();
					sumRelIncomeMp.put(rc.getName(),new Double(Double.parseDouble(StringUtil.doubleFormat2((Double)channelMp.get(rc.getName())))+Double.parseDouble(StringUtil.doubleFormat2((Double)sumRelIncomeMp.get(rc.getName())))));
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2((Double)channelMp.get(rc.getName()))  +"]]></cell>");
				}
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getPutOn())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getTimeUsed())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),sum)  +"]]></cell>");
				makeChiledChannel(cutList,key,sb,customerProduct.getRelIncome().doubleValue(),mapChannel,channels);
				sb.append("</row>");
			}
		}
		
		if(map.keySet().size() >0){
			sb.append("<row  id=\""+ "total"   +"\">");
			sb.append("<cell><![CDATA["+ "总计"  +"]]></cell>");
			sb.append("<cell></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[0]))  +"]]></cell>");
			for(Iterator its=channels.iterator();its.hasNext();){        
				ResourceChannel rc = (ResourceChannel)its.next();
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2((Double)sumRelIncomeMp.get(rc.getName()))  +"]]></cell>");
			}
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[1]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[2]))  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");
		return sb.toString();
	}
	
	private static void makeChiledChannel(List oneIndusty,String key,StringBuffer sb,double relIncome,Map mapChannel,List channels){
		int i=1;
		Map channelMp = new HashMap();
		for(Iterator it = oneIndusty.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();
			channelMp.clear();
			for (Iterator its = mapChannel.keySet().iterator(); its.hasNext();) {
				String keys = (String)its.next();
				if(keys.indexOf(key+customerProduct.getMatterName())!=-1){
					int length = keys.length();
					String channelKey= keys.substring(length-2,length);
					channelMp.put(channelKey,mapChannel.get(keys));
				}
			}
			sb.append("<row  id=\""+ key+"_" + i++  +"\">");  
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("<cell><![CDATA["+ customerProduct.getMatterName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getRelIncome())  +"]]></cell>");
			for(Iterator its=channels.iterator();its.hasNext();){
				ResourceChannel rc = (ResourceChannel)its.next();  
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2((Double)channelMp.get(rc.getName()))  +"]]></cell>");
			}
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getPutOn())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(customerProduct.getTimeUsed())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),relIncome) +"]]></cell>");
			sb.append("</row>");
		 }
	}

	public static  Collection makePrintList(Map map,Map mapChannel,List channels,String isDetail,String type){
		List result = new ArrayList();
		Collection coll = new ArrayList();        
		Map mapIndustryType = (Map)map.get("mapIndustryType");
		
		Map sumRelIncomeMp = new HashMap();
		double res[] = new  double[3];
		double sum = sumIndustryType(mapIndustryType);

		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapIndustryType")){
				CustomerProduct customerProduct = (CustomerProduct)mapIndustryType.get(key);
				
				Double relIncome = customerProduct.getRelIncome();
				Double putOn = customerProduct.getPutOn();
				Double times = customerProduct.getTimeUsed();
				
				Map channelMp = new HashMap();
				for (Iterator its = mapChannel.keySet().iterator(); its.hasNext();) {
					String keys = (String)its.next();
					if(keys.indexOf(key)!=-1){
						int length = keys.length();
						String channelKey= keys.substring(length-2,length);  
						
						Double o = (Double)channelMp.get(channelKey);
						Double s = (Double)mapChannel.get(keys);
						if(o == null){
							channelMp.put(channelKey,s);    
						}else{
							channelMp.put(channelKey,new Double(o.doubleValue()+s.doubleValue()));
						}
					}
				}
				
				res[0] += relIncome.doubleValue();
				res[1] += putOn.doubleValue();
				res[2] += times.doubleValue();				
				
				List cutList = (List)map.get(key);

				for(Iterator its=channels.iterator();its.hasNext();){
					ResourceChannel rc = (ResourceChannel)its.next();
					sumRelIncomeMp.put(rc.getName(),new Double(Double.parseDouble(StringUtil.doubleFormat2((Double)channelMp.get(rc.getName())))+Double.parseDouble(StringUtil.doubleFormat2((Double)sumRelIncomeMp.get(rc.getName())))));
				}
				
				FusionChartObject fObject = new FusionChartObject();
				Method[] methods = fObject.getClass().getMethods();
				  
				fObject.setValue1(key);
				fObject.setValue2("");
				fObject.setValue3(StringUtil.doubleFormat2(relIncome));
				int i = 4;
				for(Iterator its=channels.iterator();its.hasNext();){
					ResourceChannel rc = (ResourceChannel)its.next();
					for(int j=0;j<methods.length;j++){
						if(methods[j].getName().equals("setValue"+i)){
							String[] param = new String[1];
							param[0] = StringUtil.doubleFormat2((Double)channelMp.get(rc.getName()));
							try {
								methods[j].invoke(fObject,param);        
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {  
								e.printStackTrace();
							}
						}
					}
					i++;
				}
				int increment=0;
				for(int k = i;k<i+4;k++){
					for(int j=0;j<methods.length;j++){
							if(methods[j].getName().equals("setValue"+k)){
								String[] param = new String[1];
								if(increment==0){
									param[0] = StringUtil.doubleFormat2(customerProduct.getPutOn());
								}else if(increment==1){
									param[0] = StringUtil.doubleFormat2(customerProduct.getTimeUsed());
								}else if(increment==2){
									param[0] = StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),sum);
								}else{
									param[0] = "";
								}
								try {
									methods[j].invoke(fObject,param);     
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							}
					}
					increment++;
				}
				result.add(fObject);
				     
				if(type.equals("chart")||isDetail.equals("1")){
					makeChiledChannelForPrint(cutList,key,customerProduct.getRelIncome(),mapChannel,channels,result,type);
				}
			}
		}
		CollectionUtils.addAll(coll,result.iterator());
		
		return coll;
	}
	private static void makeChiledChannelForPrint(List oneIndusty,String key,Double relIncome,Map mapChannel,List channels,List result,String type){

		Map channelMp = new HashMap();
		for(Iterator it = oneIndusty.iterator();it.hasNext();){
			CustomerProduct customerProduct =(CustomerProduct) it.next();
			channelMp.clear();
			for (Iterator its = mapChannel.keySet().iterator(); its.hasNext();) {
				String keys = (String)its.next();
				if(keys.indexOf(key+customerProduct.getMatterName())!=-1){
					int length = keys.length();
					String channelKey= keys.substring(length-2,length);
					channelMp.put(channelKey,mapChannel.get(keys));
				}
			}
			
			FusionChartObject fObject = new FusionChartObject();
			Method[] methods = fObject.getClass().getMethods();
			
			fObject.setValue1("");
			fObject.setValue2(customerProduct.getMatterName());         
			fObject.setValue3(StringUtil.doubleFormat2(customerProduct.getRelIncome()));
			
			int i = 4;
			for(Iterator its=channels.iterator();its.hasNext();){
				ResourceChannel rc = (ResourceChannel)its.next();
				for(int j=0;j<methods.length;j++){
					if(methods[j].getName().equals("setValue"+i)){
						String[] param = new String[1];
						param[0] = StringUtil.doubleFormat2((Double)channelMp.get(rc.getName()));
						try {
							methods[j].invoke(fObject,param);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
				i++;
			}
			int increment=0;
			for(int k = i;k<i+4;k++){
				for(int j=0;j<methods.length;j++){
						if(methods[j].getName().equals("setValue"+k)){
							String[] param = new String[1];
							if(increment==0){
								param[0] = StringUtil.doubleFormat2(customerProduct.getPutOn());
							}else if(increment==1){
								param[0] = StringUtil.doubleFormat2(customerProduct.getTimeUsed());
							}else if(increment==2){
								param[0] = StringUtil.persentFormat(customerProduct.getRelIncome().doubleValue(),relIncome.doubleValue());
							}else{
								param[0] = "";     
							}
							try {
								methods[j].invoke(fObject,param);     
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
				}
				increment++;
			}
		result.add(fObject);
	 }
	}
	
	
	public static void  resetResList(List ls1,List ls2,List ls3,boolean isResourceUseCustomerCatelog,double rate){
		Map dayTimeMap = new HashMap();
		Map dayTimeMap2 = new HashMap();
		Map dayPosMap = new HashMap();
		
		for(Iterator it = ls2.iterator();it.hasNext();){
			DayInfo dayInfo = (DayInfo)it.next();
			Integer publishDate = dayInfo.getPublishDate();
			String spec = StringUtil.getNullValue(dayInfo.getSpecific(),"");
			double used =  Double.valueOf(StringUtil.getNullValue(dayInfo.getUsed(),"0")).doubleValue();
			if(dayTimeMap.containsKey(publishDate)){
				double u =  ((Double)dayTimeMap.get(publishDate)).doubleValue();
				dayTimeMap.put(publishDate,new Double(used+u));
				String s =  (String)dayPosMap.get(publishDate);
//				System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + s );
				dayPosMap.put(publishDate,StringUtil.selectStr(s,spec,3));
			}else{
				dayTimeMap.put(publishDate,new Double(used));
				dayPosMap.put(publishDate,spec);
			}
		}
		
		if(isResourceUseCustomerCatelog){
			for(Iterator it = ls3.iterator();it.hasNext();){
				DayInfo dayInfo = (DayInfo)it.next();
				Integer publishDate = dayInfo.getPublishDate();
				double used =  Double.valueOf(StringUtil.getNullValue(dayInfo.getUsed(),"0")).doubleValue();
				if(dayTimeMap2.containsKey(publishDate)){
					double u =  ((Double)dayTimeMap2.get(publishDate)).doubleValue();
					dayTimeMap2.put(publishDate,new Double(used+u));
				}else{
					dayTimeMap2.put(publishDate,new Double(used));
				}
			}
		}
		
		
		
		for(Iterator it = ls1.iterator();it.hasNext();){
			DayInfo dayInfo = (DayInfo)it.next();
			Integer publishDate = dayInfo.getPublishDate();
			
			if(dayTimeMap.containsKey(publishDate)){
				dayInfo.setUsed(((Double)dayTimeMap.get(publishDate)).toString());
				String spec = StringUtil.getNullValue(dayPosMap.get(publishDate),"");
				if(!"".equals(spec)) dayInfo.setSpecific(spec);
			}else{
				dayInfo.setUsed("0");
				dayInfo.setSpecific("");
			}
			
			
			if(isResourceUseCustomerCatelog && rate >0){
				double total1 = Double.valueOf(dayInfo.getTotal());
				double total2 = total1*rate;
				
//				System.out.println("getResourceInfoMoid>>>>>QQQQQQQQQQQQQQQQQQQQ>>>>>>>>>>>>>>>>>" +total1 +">>" +total2);
				
				dayInfo.setTotal2(String.valueOf(StringUtil.round1(total2,0)));
				
				if(dayTimeMap2.containsKey(publishDate)){
					dayInfo.setUsed2(((Double)dayTimeMap2.get(publishDate)).toString());
				}else{
					dayInfo.setUsed2("0");
				}
				
				
			}else{
				dayInfo.setTotal2(dayInfo.getTotal());
				dayInfo.setUsed2(dayInfo.getUsed());
			}
			
		}

	}
	
	
	
	
	public static  void makeTreeGridMonthXML(StringBuffer sb,List all,String orgId){

		 String tvName = SysParamUtil.getTvNameParam();
		 boolean xmtv = SysParamUtil.isXMTVParam(tvName);
		 boolean fztv = SysParamUtil.isFZTVParam(tvName);
		 boolean isMeno = SysParamUtil.getResourceDisplay();
		 int k = 1;
	
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");   
		 
		 
		for(Iterator it = all.iterator();it.hasNext();){
			
			OrderDetail orderDetail = (OrderDetail)it.next();
			Order order = orderDetail.getOrder();
			ContractPayment payment = order.getContractPayment();
			
			Matter matter = orderDetail.getMatter();
			Resource resource = orderDetail.getResource();
			ResourceSort resourceSort = resource.getResSort();
			Carrier carrier = resource.getCarrier();
			OrderPublic orderPublic = orderDetail.getOrderPublic();
			Customer customer = order.getCustomer();
			User user = order.getUser();
			

			
//			<result property="order.orderCode" column="order_code"  nullValue=""/>
//			<result property="orderPublic.publishStartDate" column="publish_date"/>
//			<result property="order.customer.customerName" column="customer_name" nullValue=""/>
//			<result property="order.user.firstName" column="first_name"  nullValue=""/>
//			<result property="order.user.lastName" column="last_name"  nullValue=""/>
//			<result property="orderPublic.channelName" column="channel_name" nullValue=""/>
//			<result property="resource.resourceName" column="resource_name"  nullValue=""/>
//			<result property="resource.memo" column="resource_meno"  nullValue=""/>
//			<result property="matter.name" column="matter_name"  nullValue=""/>
//			<result property="matter.edit" column="matter_edit"  nullValue=""/>
//			<result property="matter.length" column="matter_len" nullValue=""/>
//			<result property="orderPublic.moneyRealpay" column="money_realpay" nullValue="0"/>
//			<result property="orderPublic.moneyIn" column="money_in" nullValue="0"/>
//		
//			<result property="order.id" column="order_id"  nullValue="0"/>
//			<result property="order.customer.id" column="customer_id" nullValue="0"/>
//			<result property="resource.carrier.resourceChannel.id" column="resource_mediaorg_id"  nullValue="0"/>
//			<result property="resource.carrier.id" column="ad_resource_carrier_id"  nullValue="0"/>
//			<result property="matter.id" column="adver_matter_id"  nullValue="0"/>	
//			<result property="order.user.id" column="order_user_id"  nullValue="0"/>
			
			sb.append("<row  id=\""+ k++  +"\">");
			sb.append("<cell><![CDATA["+ "1"  +"]]></cell>");
			sb.append("<cell><![CDATA["+ order.getOrderCode()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat2(StringUtil.null2String(orderPublic.getPublishStartDate()),"yyyy/MM")  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ customer.getCustomerName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ user.getFullName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderPublic.getChannelName()  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ resource.getResourceName()+resource.getMemo()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ resourceSort.getName()  +"]]></cell>");
			
			
			
			
			sb.append("<cell><![CDATA["+StringUtil.encodeStringXML(matter.getName())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.encodeStringXML(matter.getEdit())  +"]]></cell>");
			
			sb.append("<cell><![CDATA["+ matter.getLength()  +"]]></cell>");
			double cuikuan = orderPublic.getMoneyRealpay().doubleValue() - orderPublic.getMoneyIn().doubleValue();
			sb.append("<cell><![CDATA["+ String.valueOf(StringUtil.doubleFormat3(new Double(cuikuan))) +"]]></cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			
//			System.out.println("makeTreeGridX>>>>>>>>   "+orderPublic.getMoneyRealpay().doubleValue() +" (ss)+" + orderPublic.getMoneyIn().doubleValue()+"+ >cuikuan>" +cuikuan);
			
			sb.append("<userdata name=\"order_id\">"+order.getId()+"</userdata>");
			sb.append("<userdata name=\"customer_id\">"+customer.getId()+"</userdata>");
			sb.append("<userdata name=\"ad_resource_carrier_id\">"+carrier.getId()+"</userdata>");
			sb.append("<userdata name=\"resource_mediaorg_id\">"+carrier.getResourceChannel().getId()+"</userdata>");
			sb.append("<userdata name=\"order_user_id\">"+user.getId()+"</userdata>");
			sb.append("<userdata name=\"adver_matter_id\">"+matter.getId()+"</userdata>");	
			sb.append("<userdata name=\"publish_month\">"+ orderPublic.getPublishStartDate() +"</userdata>");
			sb.append("<userdata name=\"cuikuan\">"+ cuikuan +"</userdata>");	
			sb.append("<userdata name=\"resort_id\">"+resourceSort.getId()+"</userdata>");
			sb.append("<userdata name=\"ban_value\">0</userdata>");
			
			
//			sb.append("<userdata name=\"income_id\">"+ payment.getIncomeId() +"</userdata>");	
//			sb.append("<userdata name=\"pull_id\">"+ payment.getIncomePullId() +"</userdata>");
			sb.append("<userdata name=\"payment_id\">"+ payment.getId() +"</userdata>");
			sb.append("<userdata name=\"resourceInfo_id\">"+ orderDetail.getResourceInfoId() +"</userdata>");
		
			
			
			 
			sb.append("</row>");

		 }
		

		
		sb.append("</rows>");
  }

	
	
	
}
