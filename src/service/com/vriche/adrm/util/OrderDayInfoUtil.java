package com.vriche.adrm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.model.CustomerAnalyzeColl;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.SysParam;


public class OrderDayInfoUtil {
	
	
	public static synchronized void remoceOrderDays(List idList) {
		OrderDayInfoDao orderDayInfoDao = ServiceLocator.getOrderDayInfoDao();
		Map mp = new HashMap();
		mp.put("OrderDayInfoIdList",idList);
	    orderDayInfoDao.removeOrderDayInfos(mp);
	}
	
	public static synchronized void removeOrderDayInfoByOrderDetailId(Long orderDetailId) {
		OrderDayInfoDao orderDayInfoDao = ServiceLocator.getOrderDayInfoDao();
	    orderDayInfoDao.removeOrderDayInfoByOrderDetailId(orderDetailId);
	}
	
	public static  void getDayInfoFromListByDate(List sourList,List tarList,OrderDetail orderDetail) {
		 Integer startDate_targ = orderDetail.getPublishStartDate();
		 Integer endDate_targ = orderDetail.getPublishEndDate();	
		 Iterator it = sourList.iterator();
		 while(it.hasNext()){
			 OrderDayInfo orderDayInfoSour = (OrderDayInfo)it.next();
			 Integer  publishDate = orderDayInfoSour.getPublishDate();
			 if(publishDate.intValue() >=startDate_targ.intValue() && publishDate.intValue()<=endDate_targ.intValue()){
				 tarList.add(orderDayInfoSour);
				 it.remove();
				 sourList.remove(orderDayInfoSour);
			 }
		 }
	}	
	
	
	
	public static  void getDayInfoFromListByDate_2(Map resMap1,List sourList,List tarList1,Long resourceInfo_id,String spec_orderDay,String specValue) {

		 Iterator it = sourList.iterator();
//		  resourceInfo_id = obj.getResourceInfoId();
//		  spec_orderDay = StringUtil.getNullValue(obj.getSpecific().getPosition(),"");
		 
//		 System.out.println("getDayInfoFromListByDate_2 hhhhhhhhhhhhhhhhhhhhhh resourceInfo_id>>>>"+resourceInfo_id);
//		 System.out.println("getDayInfoFromListByDate_2 hhhhhhhhhhhhhhhhhhhhhh spec_orderDayhhhhhhhhhhhhhh>>>>"+spec_orderDay);
		 
			
		 while(it.hasNext()){

			 OrderDayInfo dinfo = (OrderDayInfo)it.next();

				String key = resourceInfo_id.toString() +","+dinfo.getPublishDate().toString();
				DayInfo day_info = (DayInfo)resMap1.get(key);	
				day_info.setChangedValue(new Double(0));
				String spec_res = day_info.getSpecific();
				
				 System.out.println("getDayInfoFromListByDate_2 specValue  hhhhhhhhhhhhhhhh>>>>>>>>>>>>>>>>>"+specValue);
				
//				1 包含  2 不包含 3、追加  4 、其它排除空的
				if(!"".equals(specValue) && !"0".equals(specValue)){
					 if((!"".equals(spec_orderDay) && !specValue.equals(spec_orderDay))){
						 if(spec_res.indexOf(specValue) == -1){
//							 spec_res = StringUtil.selectStr(spec_res,specValue,3);
//							 day_info.setSpecific(spec_res);
							 tarList1.add(dinfo);
						 }
						 
					 }else{
						 if("".equals(spec_orderDay) && spec_res.indexOf(specValue) == -1){
//							 spec_res = StringUtil.selectStr(spec_res,specValue,3);
//							 day_info.setSpecific(spec_res);
							 tarList1.add(dinfo);
						 }
					 }
				}else{
					if(!"".equals(spec_orderDay)){
//						spec_res = StringUtil.selectStr(spec_res,spec_orderDay,2);
//						 day_info.setSpecific(spec_res);
						 tarList1.add(dinfo);
					}
				}		
				
				
				
				
				
				
				
			 
//			 	realPlay_sum += dinfo.getDayRelIncome().doubleValue();
//				moneyIn_sum += dinfo.getDayRelPuton().doubleValue();
//				times_sum += dinfo.getAdDayTimes().intValue();
//				start_day = new Integer(Math.min(start_day.intValue(), dinfo.getPublishDate().intValue()));
//				end_day = new Integer(Math.max(start_day.intValue(), dinfo.getPublishDate().intValue()));
			 
			 
//			 if(publishDate.intValue() >=startDate_targ.intValue() && publishDate.intValue()<=endDate_targ.intValue()){
//				 tarList.add(orderDayInfoSour);
//				 it.remove();
//				 sourList.remove(orderDayInfoSour);
//			 }
		 }
	}
	
	public static  void getNewOrderDetailByDayInfos(OrderDetail obj,List ls2,double changeResInfo,Map resMap1,Map newDayInfosMap) {
	
//        DayInfo dayInfo = new DayInfo();
//		 dayInfo.setResourceId(obj.getResourceInfoId());
//		 dayInfo.setStartDate(obj.getPublishStartDate());
//		 dayInfo.setEndDate(obj.getPublishEndDate());
//		 Map resMap1  = ResourceUtil.getDayInfosMap(dayInfo);	
		 
		double realPlay_sum_temp = 0;
		double exec_price = obj.getExecPrice().doubleValue();

		double realPlay_sum = 0;
		double moneyIn_sum = 0;
		int times_sum = 0;
		Integer start_day = new Integer(99999999);
		Integer end_day = new Integer(0);
		Long resourceInfo_id = obj.getResourceInfoId();
		
		 
		boolean changDayInfo = changeResInfo >0||changeResInfo<0;
		 
//		System.out.println("day_info>>>>>>>>>>>>>>>start_day>>>>>66666666666666666>>>ls2.size()>>>>>>>>" + ls2.size());
		
		List lsDinfoIDS = new ArrayList();
		for (Iterator it2 = ls2.iterator(); it2.hasNext();) {
			OrderDayInfo dinfo = (OrderDayInfo) it2.next();
			realPlay_sum += dinfo.getDayRelIncome().doubleValue();
			moneyIn_sum += dinfo.getDayRelPuton().doubleValue();
			times_sum += dinfo.getAdDayTimes().intValue();
			start_day = new Integer(Math.min(start_day.intValue(), dinfo.getPublishDate().intValue()));
			end_day = new Integer(Math.max(start_day.intValue(), dinfo.getPublishDate().intValue()));
			lsDinfoIDS.add(dinfo.getId());
//			System.out.println("day_info>>>>>>>>>>>>>>>getPublishDate>>>>>66666666666666666>>>1>>>>>>>>" + dinfo.getPublishDate());
//			System.out.println("day_info>>>>>>>>>>>>>>>start_day>>>>>66666666666666666>>>2>>>>>>>>" + start_day);
//			System.out.println("day_info>>>>>>>>>>>>>>>end_day>>>>>66666666666666666>>>3>>>>>>>" + end_day);
//			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>>>"+ changDayInfo +">>>>>>>>>>>" + changeResInfo);
			if(changDayInfo){
				String key = resourceInfo_id.toString() +","+dinfo.getPublishDate().toString();
				DayInfo day_info = (DayInfo)resMap1.get(key);	
//				System.out.println("day_info>>>>>>>>>>>>>>>>>>>>66666666666666666>>>1>>>>>>>>" + day_info);
				 if(newDayInfosMap.containsKey(key)){
					 DayInfo day_info_map = (DayInfo)newDayInfosMap.get(key);
					 changeResInfo =  changeResInfo +Double.parseDouble(StringUtil.getNullValue(day_info_map.getChangedValue(),"0"));
					 day_info_map.setChangedValue(new Double(changeResInfo));
				 }else{
//					 System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>>>1>>>>>>>>" + changeResInfo);
					 if(day_info != null){
						 day_info.setChangedValue(new Double(changeResInfo));
						 newDayInfosMap.put(key,day_info);	 
					 }
				 }

			}

			
		}
		obj.setMoneyBalance(new Double(0));
		if (exec_price > 0) {
			realPlay_sum_temp = realPlay_sum - exec_price * times_sum;
			if (realPlay_sum_temp > 0)
				obj.setMoneyBalance(new Double(realPlay_sum_temp));
		}
		obj.setPublishStartDate(start_day);
		obj.setPublishEndDate(end_day);
		obj.setMoneyRealpay(new Double(realPlay_sum));
		obj.setMoneyIn(new Double(moneyIn_sum));
		obj.setSumTimes(new Integer(times_sum));
	}
	
	
	
	public static  void getNewOrderDetailByDayInfos_for_spec(OrderDetail obj,List ls2,double changeResInfo,String specValue,Map resMap1,Map newDayInfosMap) {
		

		double realPlay_sum_temp = 0;
		double exec_price = obj.getExecPrice().doubleValue();

		double realPlay_sum = 0;
		double moneyIn_sum = 0;
		int times_sum = 0;
		Integer start_day = new Integer(99999999);
		Integer end_day = new Integer(0);
		Long resourceInfo_id = obj.getResourceInfoId();
		String spec_orderDay = StringUtil.getNullValue(obj.getSpecific().getPosition(),"");
		
		 
		boolean changDayInfo = changeResInfo >0||changeResInfo<0;
		 
//		System.out.println("day_info>>>>>>>>>>>>>>>start_day>>>>>66666666666666666>>>ls2.size()>>>>>>>>" + ls2.size());
		
		List lsDinfoIDS = new ArrayList();
		for (Iterator it2 = ls2.iterator(); it2.hasNext();) {
			OrderDayInfo dinfo = (OrderDayInfo) it2.next();
			realPlay_sum += dinfo.getDayRelIncome().doubleValue();
			moneyIn_sum += dinfo.getDayRelPuton().doubleValue();
			times_sum += dinfo.getAdDayTimes().intValue();
			start_day = new Integer(Math.min(start_day.intValue(), dinfo.getPublishDate().intValue()));
			end_day = new Integer(Math.max(start_day.intValue(), dinfo.getPublishDate().intValue()));
			lsDinfoIDS.add(dinfo.getId());
//			System.out.println("day_info>>>>>>>>>>>>>>>getPublishDate>>>>>66666666666666666>>>1>>>>>>>>" + dinfo.getPublishDate());
//			System.out.println("day_info>>>>>>>>>>>>>>>start_day>>>>>66666666666666666>>>2>>>>>>>>" + start_day);
//			System.out.println("day_info>>>>>>>>>>>>>>>end_day>>>>>66666666666666666>>>3>>>>>>>" + end_day);
//			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>>>"+ changDayInfo +">>>>>>>>>>>" + changeResInfo);

			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>>changDayInfo >>>>>>>>>>" + changeResInfo);
			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>> spec_orderDay>>>>>>>>>>" + spec_orderDay);
			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666> specValue >>>>>>>>>>" + specValue);
			
			
			
			
			if(changDayInfo){
				String key = resourceInfo_id.toString() +","+dinfo.getPublishDate().toString();
				DayInfo day_info = (DayInfo)resMap1.get(key);	
	
				 day_info.setChangedValue(new Double(0));
				
				String spec_res = day_info.getSpecific();
				System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>> spec_res >>>>>>>>>>" + spec_res);
				
				//1 包含  2 不包含 3、追加  4 、其它排除空的
				if(!"".equals(specValue) && !"0".equals(specValue)){
					 if((!"".equals(spec_orderDay) && !specValue.equals(spec_orderDay))){
						 
//						 if(spec_res.indexOf(spec_orderDay) > -1){
//							 spec_res = StringUtil.selectStr(spec_res,spec_orderDay,2);
//						 }
//						 if(spec_res.indexOf(specValue) > -1){
//							 
//						 }else{
//							 
//						 }
						 
						 if(spec_res.indexOf(specValue) == -1){
							 spec_res = StringUtil.selectStr(spec_res,spec_orderDay,2);
							 spec_res = StringUtil.selectStr(spec_res,specValue,3);
							 day_info.setSpecific(spec_res);
							 newDayInfosMap.put(day_info.getId(),day_info);
						 }
						 
					 }else{
						 if("".equals(spec_orderDay) && spec_res.indexOf(specValue) == -1){
							 spec_res = StringUtil.selectStr(spec_res,spec_orderDay,2);
							 spec_res = StringUtil.selectStr(spec_res,specValue,3);
							 day_info.setSpecific(spec_res);
							 newDayInfosMap.put(day_info.getId(),day_info);
						 }
					 }
				}else{
					if(!"".equals(spec_orderDay)){
						spec_res = StringUtil.selectStr(spec_res,spec_orderDay,2);
//						 spec_res = StringUtil.selectStr(spec_res,spec_orderDay,3);
						 day_info.setSpecific(spec_res);
						 newDayInfosMap.put(day_info.getId(),day_info);
					}
				}

			}

			
		}
		obj.setMoneyBalance(new Double(0));
		if (exec_price > 0) {
			realPlay_sum_temp = realPlay_sum - exec_price * times_sum;
			if (realPlay_sum_temp > 0)
				obj.setMoneyBalance(new Double(realPlay_sum_temp));
		}
		obj.setPublishStartDate(start_day);
		obj.setPublishEndDate(end_day);
		obj.setMoneyRealpay(new Double(realPlay_sum));
		obj.setMoneyIn(new Double(moneyIn_sum));
		obj.setSumTimes(new Integer(times_sum));
	}
	
	
	
public static  void getNewOrderDetailByDayInfos_for_spec2(OrderDetail obj,List ls2,double changeResInfo,String specValue,Map resMap1,Map newDayInfosMap,Map newDayInfosMap2) {
		

		double realPlay_sum_temp = 0;
		double exec_price = obj.getExecPrice().doubleValue();

		double realPlay_sum = 0;
		double moneyIn_sum = 0;
		int times_sum = 0;
		Integer start_day = new Integer(99999999);
		Integer end_day = new Integer(0);
		Long resourceInfo_id = obj.getResourceInfoId();
		String spec_orderDay = StringUtil.getNullValue(obj.getSpecific().getPosition(),"");

		
		List lsDinfoIDS = new ArrayList();
		for (Iterator it2 = ls2.iterator(); it2.hasNext();) {
			OrderDayInfo dinfo = (OrderDayInfo) it2.next();
			realPlay_sum += dinfo.getDayRelIncome().doubleValue();
			moneyIn_sum += dinfo.getDayRelPuton().doubleValue();
			times_sum += dinfo.getAdDayTimes().intValue();
			start_day = new Integer(Math.min(start_day.intValue(), dinfo.getPublishDate().intValue()));
			end_day = new Integer(Math.max(start_day.intValue(), dinfo.getPublishDate().intValue()));
			lsDinfoIDS.add(dinfo.getId());

			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>>changDayInfo >>>>>>>>>>" + changeResInfo);
			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>> spec_orderDay>>>>>>>>>>" + spec_orderDay);
			System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666> specValue >>>>>>>>>>" + specValue);
			
			
			
			
	
				String key = resourceInfo_id.toString() +","+dinfo.getPublishDate().toString();
				DayInfo day_info = (DayInfo)resMap1.get(key);	
	
				 day_info.setChangedValue(new Double(0));
				
				String spec_res = day_info.getSpecific();
				System.out.println("changeResInfo>>>>>>>>>>>>>>>>>>>>66666666666666666>> spec_res >>>>>>>>>>" + spec_res);
				
				//1 包含  2 不包含 3、追加  4 、其它排除空的
				if(!"".equals(specValue)){
					 if((!"".equals(spec_orderDay) && !specValue.equals(spec_orderDay))){

						 if(spec_res.indexOf(specValue) == -1){
							 spec_res = StringUtil.selectStr(spec_res,specValue,3);
							 day_info.setSpecific(spec_res);
							 newDayInfosMap.put(day_info.getId(),day_info);
						 }else{
							 newDayInfosMap2.put(day_info.getId(),day_info);
						 }
						 
					 }else{
						 if("".equals(spec_orderDay) && spec_res.indexOf(specValue) == -1){
							 spec_res = StringUtil.selectStr(spec_res,specValue,3);
							 day_info.setSpecific(spec_res);
							 newDayInfosMap.put(day_info.getId(),day_info);
						 }
					 }
				}else{
					if(!"".equals(spec_orderDay)){
						 spec_res = StringUtil.selectStr(spec_res,spec_orderDay,2);
						 day_info.setSpecific(spec_res);
						 newDayInfosMap.put(day_info.getId(),day_info);
					}
				}

			}


	}
	
	
	public static synchronized void addOrderDayInfos(OrderDetail orderDetail,OrderDayInfo[] orderDayInfos) {
		OrderDayInfoDao orderDayInfoDao = ServiceLocator.getOrderDayInfoDao();
        Long orderDetailId = orderDetail.getId();
        for(int j = 0;j < orderDayInfos.length;j++){
	 		orderDayInfos[j].setOrderDetailId(orderDetailId);
//	 		System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDayInfos[j].toString() );
	 	} 
	    orderDayInfoDao.saveOrderDayInfosNew(orderDayInfos);
	}
	
	
	
	 public static synchronized void makeTreeGridXML(StringBuffer sb,List all){
		 	sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			

	        
			sb.append("<rows>");  
			
			
			
//			sb.append("<head>");   
//			sb.append("<afterInit>");
//			sb.append("<call command=\"attachHeader\">");
////			sb.append("<param>合计,Title,Author,#rspan,#rspan,#rspan</param>"); 
//			sb.append("<param>合计,Title,Author,#rspan,#rspan,#rspan"); 
//			sb.append("<param>[]</param>"); 
//			sb.append("<param>_aFoot</param>"); 
//	        sb.append("</call>");   
//	        sb.append("</afterInit>");
//	        sb.append("</head>");	
			SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
			boolean isDisplayStandPrice = sysParam.getIsDisplayStandPrice() == null||(sysParam.getIsDisplayStandPrice().equals("0"))?false:true;
			int i=0;
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
				Double standPrice = customerColl.getDayStandardPrice() == null?new Double(0):new Double(customerColl.getDayStandardPrice());
				Double realIncom = customerColl.getDayRelIncome() == null?new Double(0):new Double(customerColl.getDayRelIncome());
				Double RelPuton = customerColl.getDayRelPuton() == null?new Double(0):new Double(customerColl.getDayRelPuton());
				long adSumTimes = Math.round(Double.parseDouble(customerColl.getAdSumTimes()));
				sb.append("<row  id=\""+ i++  +"\">");
				
				String aa = "";
				sb.append("<cell  tooltip=\"" + aa +"\"  ><![CDATA["+ customerColl.getCustomerName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(customerColl.getCustomerIncome()))  +"]]></cell>");
				if(isDisplayStandPrice) sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(standPrice)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(realIncom)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(RelPuton)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(customerColl.getDayPayMoney()))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ TimeUtil.format2HourMiSe(adSumTimes*1000)  +"]]></cell>");
				
				
				
//				sb.append("<userdata name=\"income\"><![CDATA["+ StringUtil.doubleFormat3(customerColl.getCustomerIncome())  +"]]></userdata>");
//				sb.append("<userdata name=\"standPrice\"><![CDATA["+ StringUtil.doubleFormat3(standPrice)  +"]]></userdata>");
//				sb.append("<userdata name=\"realIncom\"><![CDATA["+ StringUtil.doubleFormat3(realIncom)  +"]]></userdata>");
//				sb.append("<userdata name=\"relPuton\"><![CDATA["+ StringUtil.doubleFormat3(RelPuton)  +"]]></userdata>");
//				sb.append("<userdata name=\"useTimeSum\"><![CDATA["+ adSumTimes  +"]]></userdata>");
//				sb.append("<userdata name=\"qiankuan\"><![CDATA["+ StringUtil.doubleFormat3(customerColl.getDayPayMoney())  +"]]></userdata>");

				
				sb.append("</row>");
			 }
			
			
			
			
//			sb.append("<footer>");   
//			sb.append("<afterInit>");
//			sb.append("<call command=\"attachFooter\">");
//			sb.append("<param>合计,Title,Author,#rspan,#rspan,#rspan</param>");   
//	        sb.append("</call>");   
//	        sb.append("</afterInit>");
//	        sb.append("</footer>");		

			sb.append("</rows>");
			
	
			
	  }
	 
	 public static synchronized void makeTreeGridXML3(StringBuffer sb,List all){
		 	sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			

	        
			sb.append("<rows>");  
			

			SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
		
			int i=0;
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
				
				Double realIncom = customerColl.getDayRelIncome() == null?new Double(0):new Double(customerColl.getDayRelIncome());
				Double RelPuton = customerColl.getDayRelPuton() == null?new Double(0):new Double(customerColl.getDayRelPuton());
				sb.append("<row  id=\""+ i++  +"\">");
				sb.append("<cell><![CDATA["+ customerColl.getCustomerName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(customerColl.getCustomerIncome()))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(realIncom)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(RelPuton)  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(customerColl.getDayPayMoney()))  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(customerColl.getAdSumTimes())  +"]]></cell>");
				String s = DateUtil.formatLongToTimeStr2(new Long(Float.valueOf(customerColl.getAdSumTimes()).longValue()*1000));
				sb.append("<cell><![CDATA["+ s  +"]]></cell>");

				sb.append("</row>");
			 }


			sb.append("</rows>");
			
	
			
	  }
	 
	 public static synchronized void makeTreeGridXML2(StringBuffer sb,List all){
		 	sb.delete(0,sb.length());
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");  

			int i=0;
			for(Iterator it = all.iterator();it.hasNext();){
				CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
				
				sb.append("<row  id=\""+ i++  +"\">");
				sb.append("<cell><![CDATA["+ customerColl.getCustomerName()  +"]]></cell>");
				for(int j = 1 ;j<14;j++){
//					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(StringUtilsv.toDouble(customerColl.getMonth().get(j)))  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(StringUtil.toDouble(customerColl.getMonth().get(j)))  +"]]></cell>");
				}
				sb.append("</row>");
			 }
			
			sb.append("</rows>");

	  }
	 public static  String makeTreeGridXML3(List all){
			StringBuffer sb  = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");  
			
			int i=0;
			for(Iterator it = all.iterator();it.hasNext();){
				OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
//		 		resultOderDayInfo.setCarrier(carrier);
//		 		resultOderDayInfo.setDayRelIncome(new Double(resultTotal[1]));
//		 		resultOderDayInfo.setDayRelPuton(new Double(resultTotal[0]));
//		 		resultOderDayInfo.setAdSumTimes(new Double(resultTotal[2]));
				sb.append("<row  id=\""+ i++  +"\">");
//				sb.append("<cell><![CDATA["+ orderDayInfo.getCarrier().getCarrierName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDayInfo.getToaccountTotal()+ orderDayInfo.getCarrier().getCarrierName()+"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelPuton())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getAdSumTimes()) +"]]></cell>");
				
				sb.append("</row>");
			 }
			
			sb.append("</rows>");
			
			return sb.toString();
		}
	 
	 
	 public static  String makeTreeGridXML4(Map map){
			StringBuffer sb  = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");  
			
			Map mapResourceCustomer = (Map)map.get("mapResourceCustomer");
			
			double res[] = new  double[3];
			for (Iterator it = map.keySet().iterator(); it.hasNext();) {
				String key = (String)it.next();
				if(!key.equals("mapResourceCustomer")){
					OrderDayInfo orderDayInfo = (OrderDayInfo)mapResourceCustomer.get(key);
					
					Double relIncome = orderDayInfo.getDayRelIncome();
					Double putOn = orderDayInfo.getDayRelPuton();
					Double times = orderDayInfo.getAdSumTimes();
					res[0] += relIncome.doubleValue();
					res[1] += putOn.doubleValue();
					res[2] += times.doubleValue();				
					
					List cutList = (List)map.get(key);

//					sb.append("<row  id=\""+ key   +"\" open=\"1\">");
					sb.append("<row  id=\""+ key   +"\">");
					sb.append("<cell><![CDATA["+ orderDayInfo.getToaccountTotal()  +"]]></cell>");
					sb.append("<cell image=\"folder.gif\">"+ orderDayInfo.getResourceSpecific() +"</cell>");
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelIncome())  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelPuton())  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getAdSumTimes())  +"]]></cell>");
					
					makeChiled(cutList,key,sb);
					sb.append("</row>");
				}
			}
			
			
			if(map.keySet().size() >0){
				sb.append("<row  id=\""+ "total"   +"\">");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[0]))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[1]))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(res[2]))  +"]]></cell>");
				sb.append("</row>");
			
			}
			
			
			
			sb.append("</rows>");
			
			return sb.toString();
		}
		private static void makeChiled(List customerS,String key,StringBuffer sb){
			int i=1;
			for(Iterator it = customerS.iterator();it.hasNext();){
				OrderDayInfo orderDayInfo =(OrderDayInfo) it.next();
				sb.append("<row  id=\""+ key+"_" + i++  +"\">");
//				sb.append("<cell>"+ key +"</cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDayInfo.getCustomer().getCustomerName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelPuton())  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ customerProduct.getOrderCode() +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getAdSumTimes())  +"]]></cell>");
			
				sb.append("</row>");
			 }	
		}


	 public static  String makeTreeGridXML5(List all){
			StringBuffer sb  = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");  
			
			int i=0;
			for(Iterator it = all.iterator();it.hasNext();){
				OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
				sb.append("<row  id=\""+ i++  +"\">");
				sb.append("<cell><![CDATA["+ orderDayInfo.getToaccountTotal()+ orderDayInfo.getCarrier().getCarrierName()+"]]></cell>");
				sb.append("<cell><![CDATA["+ orderDayInfo.getResourceSpecific() +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelIncome())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayRelPuton())  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getAdSumTimes()) +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(orderDayInfo.getDayStandardPrice()) +"]]></cell>");
				
				sb.append("</row>");
			 }
			
			sb.append("</rows>");
			
			return sb.toString();
		}
	 
	 public static String forDisplay(double x){
			double x1=Math.round(x * 100);
			long aa = (long) x1;
			String bb = aa+"";

			String y = bb.substring(bb.length()-2,bb.length());
			String t = bb.substring(0,bb.length()-2);
			
			String display=t+"."+y;
			return display ;
	 }
	 
	 
	 
	 public static synchronized  void removeOrderDayInfos(OrderDetail orderDetai){
		    Map orderDayInfoMap =new HashMap();
		    Map resChangedMap =new HashMap();
		    Map timLimitMap =new HashMap();
		    Map specMap =new HashMap();
		    Map newResMap =new HashMap();
		    getOrderDayInfoMap(orderDetai,orderDetai.getOrderDayInfos(),orderDayInfoMap);
		    getResourceInfo(2,orderDetai,orderDayInfoMap, newResMap,resChangedMap,timLimitMap,specMap);
		    ResourceUtil.updateDayInfos(newResMap);
		    removeOrderDayInfoByOrderDetailId(orderDetai.getId());
	 }

		 
	 
	 //处理新添状态
	 public static synchronized  void getResourceInfo(int model,OrderDetail orderDetail,Map orderDayInfoMap,Map newResMap,Map resChangedMap,Map timLimitMap,Map specMap){

        DayInfo dayInfo = new DayInfo();

		Map resMap1 = new HashMap();

		Long rsId = orderDetail.getResourceInfoId();
		 Resource resource = ResourceUtil.getResourceById(rsId);
		 boolean isOutstripTimeLimit = resource.getIsClosed().booleanValue();
		dayInfo.setResourceId(rsId);
		dayInfo.setStartDate(orderDetail.getPublishStartDate());
		dayInfo.setEndDate(orderDetail.getPublishEndDate());
		resMap1 = ResourceUtil.getDayInfosMap(dayInfo);
			 
//		 System.out.println("getResourceInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>isLimit>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + isOutstripTimeLimit );
//		 System.out.println("unAbleSaveWarn>>>>>>>>>>>>>>>>>>>>>>>>>>>>getPublishStartDate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetail.getPublishStartDate() );
//		 System.out.println("unAbleSaveWarn>>>>>>>>>>>>>>>>>>>>>>>>>>>>getPublishEndDate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetail.getPublishEndDate() );
//		 System.out.println("unAbleSaveWarn>>>>>>>>>>>>>>>>>>>>>>>>>>>>resMap1.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + resMap1.size() );
	 
			 
		String key2 = "";
		Iterator it2 = resMap1.keySet().iterator();
		double changeV = 0;	 
			 while(it2.hasNext()){
					 key2 =  (String)it2.next();
//					 System.out.println("unAbleSaveWarn>>>>>>>>>>>>>>>>>>>>>>>>>>>>key2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + key2 );
					 DayInfo day = (DayInfo)resMap1.get(key2);
//					 System.out.println("unAbleSaveWarn>>>>>>>>>>>>>>>>>>>>>>>>>>>key2>"+ key2+">>>>>>>>>>>>" + day.toString() );
//					 long modifyTime = DateUtil.getlongValueFromDateStr(StringUtil.getNullValue(day.getModifyTime(),"0"));
					 
					 double resUsed = Double.valueOf(StringUtil.getNullValue(day.getUsed(),"0")).doubleValue();
//					 System.out.println("saveResourceInfo kkkkkkkkkkkkkkkkkkkk"+ day.getUsed() +"kkkkkkkkkkkkkkkkkkkkkkkkk>>>>>>>>>>>>>>>>>>>>>>"+resUsed);
					 
					 String rsSpec = StringUtil.getNullValue(day.getSpecific(),"");
					 
					 
				
					 Object obj = orderDayInfoMap.get(key2);
					 if(obj != null){
						 OrderDayInfo orderDayInfo = (OrderDayInfo)obj;
						 int adDayTimes = Integer.parseInt(StringUtil.getNullValue(orderDayInfo.getAdDayTimes(),"0"));
						 
						 if(adDayTimes > 0){

							 double total = Double.parseDouble(StringUtil.getNullValue(day.getTotal(),"0"));
							 
							 double adLen = Double.parseDouble(StringUtil.getNullValue(orderDayInfo.getAdlength(),"0"));
							 double adUsed = adDayTimes * adLen;
//							 int rsUsed_backup = Integer.parseInt(StringUtil.getNullValue(orderDayInfo.getRsUsed(),"0"));
							 
							 
	//						 DayInfo dayBak = orderDayInfoBak.getDayInfo();

							 
							
	
							 String adSpec = StringUtil.getNullValue(orderDayInfo.getResourceSpecific(),"");
							 
			
	
							 if(model == 1){
								 changeV = adUsed;
								 //1 包含  2 不包含 3、追加  4 其它排除空的
								 if(!"".equals(adSpec)){
									 if(rsSpec.indexOf(adSpec)>-1){
//										 System.out.println("getResourceInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>key2>>adSpec>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + adSpec );
										 specMap.put(key2,day);
									 }else{
										 rsSpec = StringUtil.selectStr(rsSpec,adSpec,3);
									 }
								 }
								 
								 
								
								 
								 boolean isOutstripTime = changeV> 0 && (total - (resUsed+changeV)) < 0;

								 if(isOutstripTimeLimit && isOutstripTime) timLimitMap.put(key2,day);
//								 long modifyTimeBak = DateUtil.getlongValueFromDateStr(StringUtil.getNullValue(orderDayInfo.getRsModifyTime(),"0"));
//								 if(isOutstripTimeLimit  && isOutstripTime &&  modifyTimeBak != modifyTime)  resChangedMap.put(key2,day);

//								 System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>modifyTime>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + modifyTime );
//								 System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>modifyTimeBak>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + modifyTimeBak );
								 
							 }else{
								 changeV = -adUsed;
								 //1 包含  2 不包含 3、追加  4 其它排除空的
								 if(!"".equals(adSpec) && rsSpec.indexOf(adSpec)>-1)  rsSpec = StringUtil.selectStr(rsSpec,adSpec,2);
							 }
							 
//							 System.out.println("getResourceInfo>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>>>>resUsed>>>>>>>>>>>" + resUsed );
//							 System.out.println("getResourceInfo>>>>TTTTTTT>>>>>>>>>>>>>>>>>>>>>>>changeV>>>>>>>>>>>" + changeV );
//							 System.out.println("getResourceInfo>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>>>>resUsed>>>>>>>>>>>" + (resUsed+changeV) );
							 day.setChangedValue(new Double(changeV));
//							 day.setUsed(String.valueOf((resUsed+changeV)*1));
							 day.setSpecific(rsSpec);
						 }
						 
					 }else{
						 it2.remove();
						 resMap1.remove(key2);
					 }
			 }
		
			 newResMap.putAll(resMap1);
		 
	 }
	 
	 //处理修改
	 public static synchronized  void getResourceInfoMoid(OrderDetail orderDetail,Map OrderDayInfoMapBak,Map OrderDayInfoMapCur,Map newResMap,Map resChangedMap,Map timLimitMap,Map specMap){

//		     OrderDetail orderDetailBak = orderDetail.getOrderDetailBak();
		     
		     //先获得备份的资源信息
//		     getResourceInfo(orderDetailBak,OrderDayInfoMapBak, newResMap,resChangedMap,timLimitMap,specMap);

		     
//		     通过获得备份资源信息newResMap后，再结合当前资源使用，最后得到最终要处理的资源信息
		     Long rsId = orderDetail.getResourceInfoId();
			 Resource resource = ResourceUtil.getResourceById(rsId);
			 boolean isOutstripTimeLimit = resource.getIsClosed().booleanValue();
			 
             DayInfo dayInfo = new DayInfo();
			 dayInfo.setResourceId(rsId);
			 dayInfo.setStartDate(orderDetail.getPublishStartDate());
			 dayInfo.setEndDate(orderDetail.getPublishEndDate());
			 Map resMap2  = ResourceUtil.getDayInfosMap(dayInfo);
			 
//			 System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>>>resMap2.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + resMap2.size() );

			 String key ="";
			 Iterator it = resMap2.keySet().iterator();
			 DayInfo day = new  DayInfo();
		
			 
			 while(it.hasNext()){

				key = String.valueOf(it.next());
				
//				System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + key );
	

				if(newResMap.containsKey(key)){
					 day = (DayInfo)newResMap.get(key);
					 it.remove();       //这行代码是关键。
					 resMap2.remove(key);
				}else{
					 day = (DayInfo)resMap2.get(key);
				}
				

//				 long modifyTime = DateUtil.getlongValueFromDateStr(StringUtil.getNullValue(day.getModifyTime(),"0"));
				 double total = Double.parseDouble(StringUtil.getNullValue(day.getTotal(),"0"));
				 double resUsed = Double.parseDouble(StringUtil.getNullValue(day.getUsed(),"0"));
				 String rsSpec = StringUtil.getNullValue(day.getSpecific(),"");
				 
				 Object obj = OrderDayInfoMapCur.get(key);
				 if(obj != null){
					 OrderDayInfo orderDayInfoCur = (OrderDayInfo)obj;
//					 DayInfo dayCur = orderDayInfoCur.getDayInfo();


					 

					 
					 int adDayTimesCur = Integer.parseInt(StringUtil.getNullValue(orderDayInfoCur.getAdDayTimes(),"0"));
					 double adLenCur = Double.parseDouble(StringUtil.getNullValue(orderDayInfoCur.getAdlength(),"0"));
					 
					 
					 double adUsedCur = adDayTimesCur * adLenCur;
					 
//					 System.out.println("getResourceInfoMoid>>>>TTTTTTT>>>>>>>>>>>>>>>>>>>>>>>adDayTimesCur>>>>>>>>>>>" + adDayTimesCur );
//					 System.out.println("getResourceInfoMoid>>>>TTTTTTT>>>>>>>>>>>>>>>>>>>>>>>adLenCur>>>>>>>>>>>" + adLenCur );
					 
					 String adSpecCur = StringUtil.getNullValue(orderDayInfoCur.getResourceSpecific(),"");
					 
					 double changeV = Double.parseDouble(StringUtil.getNullValue(day.getChangedValue(),"0")) + adUsedCur;
					 
//					 if(total - (resUsed+changeV) < 0) timLimitMap.put(key,day);
					 
			 
					 
					 
					 
					    
			
					//1 包含  2 不包含 3、追加  4 其它排除空的
					 if(!"".equals(adSpecCur)){
						 if(rsSpec.indexOf(adSpecCur)>-1){
							 specMap.put(key,day);
						 }else{
							 rsSpec = StringUtil.selectStr(rsSpec,adSpecCur,3);
						 }
					 }		 

					
					 OrderDayInfo orderDayInfo;
					 if(newResMap.containsKey(key)){
//						 System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>key1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + key );
						  orderDayInfo = (OrderDayInfo)OrderDayInfoMapBak.get(key);
					 }else{
//						 System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>key2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + key );
						  orderDayInfo = (OrderDayInfo)OrderDayInfoMapCur.get(key);
					 }

//					 System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>>>orderDayInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDayInfo );
					 String  rsSpecBackup =  StringUtil.getNullValue(orderDayInfo.getRsSpecific(),"");
					 
					 boolean isChangeSpec = !Arrays.equals(rsSpecBackup.split(","),rsSpec.split(","));
					 

					 
					 if(changeV != 0 || isChangeSpec){
						 
						 boolean isOutstripTime =  changeV> 0 && (total - (resUsed+changeV)) < 0;
						 if(isOutstripTimeLimit && isOutstripTime) timLimitMap.put(key,day);
//						 long modifyTimeCur = DateUtil.getlongValueFromDateStr(StringUtil.getNullValue(orderDayInfoCur.getRsModifyTime(),"0"));	
//						 if(isOutstripTimeLimit  &&  modifyTimeCur != modifyTime) resChangedMap.put(key,day);	
//						 System.out.println("getResourceInfoMoid>>>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>>>changeV>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + changeV );
//						 System.out.println("getResourceInfoMoid>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>>>>resUsed>>>>>>>>>>>" + (resUsed+changeV) );
//						 System.out.println("getResourceInfoMoid>>>>>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>isChangeSpec>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + isChangeSpec );
//						 System.out.println("getResourceInfoMoid>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>>>>resUsed>>>>>>>>>>>" + resUsed );
//						 System.out.println("getResourceInfoMoid>>>>TTTTTTT>>>>>>>>>>>>>>>>>>>>>>>changeV>>>>>>>>>>>" + changeV );
//						 System.out.println("getResourceInfoMoid>>>>TTTTTTTT>>>>>>>>>>>>>>>>>>>>>>>resUsed>>>>>>>>>>>" + (resUsed+changeV) );
						 
						 day.setChangedValue(new Double(changeV));
//						 day.setUsed(String.valueOf((resUsed+changeV)*1));
//						 day.setUsed(String.valueOf((resUsed+changeV)*1));
						 day.setSpecific(rsSpec);	
					 }else{
						 if(newResMap.containsKey(key)){
							 newResMap.remove(key);
						 }else{
							 it.remove();       //这行代码是关键。
							 resMap2.remove(key);
						 }

					 }

					 
				 }
			 }

			 newResMap.putAll(resMap2); 
			 
//			 System.out.println("getResourceInfoMoid>>>>>>>>>>>>>>>>>>>>>>>>>>>>newResMap.size()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + newResMap.size() );
		 
	 }
	 
	 
	
	 public static  void getOrderDayInfoMap(OrderDetail orderDetail,OrderDayInfo[] orderDayInfos,Map mp){
		 if(orderDetail != null){
				String key ="";
//				Integer value =new Integer(0);
				Long resourceId = orderDetail.getResourceInfoId();
				if(orderDayInfos != null){
				 	for(int j = 0;j < orderDayInfos.length;j++){
				 		
				 		orderDayInfos[j].setOrderDetailId(orderDetail.getId());
				 		              
				 		int adTimes = Integer.parseInt(StringUtil.getNullValue(orderDayInfos[j].getAdDayTimes(),"0"));
				 		if(adTimes > 0){
					   		OrderDayInfo orderDayInfo = orderDayInfos[j];
					   		if(orderDayInfo != null){
					   			key = resourceId.toString() +","+orderDayInfo.getPublishDate().toString();
//					   			System.out.println("getOrderDayInfoMap>>>>>>>>>>>>>>>>>>>>>>>>orderDayInfo>>>>>>>>>>>>>>>>>>>>>>>>" + orderDayInfo.toString() );
//					   			value = Integer.valueOf(StringUtil.getNullValue(dayInfo.getUsed(),"0"));
					   			mp.put(key,orderDayInfo);
					   		}
				 		}
				 	} 	
				}

		 }

	 }

	 public static int getModiyState(OrderDetail orderDetail,Map orderDayInfoMapBak,Map orderDayInfoMapCur){
		 
//		 1、是新添加
//		 2、修改广告长度，需要处理排期
//		 3、修改指定，需要处理排期
//		 4、修改播出次数，需要处理排期
//		 5、修改播出次数，需要处理排期
//		 6、不修改排期的情况，广告长度不变
		 
//		 返回的状态标志 0、不修改  1、是新添  2、修改订单日信息及资源信息  3、修改资源信息（只修改指定）
		 OrderDetail orderDetailBak = orderDetail.getOrderDetailBak();
		 
	
		 boolean isPackeg =  Boolean.valueOf(StringUtil.getNullValue(orderDetail.getIsCompages(),"false")).booleanValue();
		 boolean isNew =orderDetailBak.getOrderDayInfos() == null|| orderDetailBak.getOrderDayInfos().length == 0||isPackeg;	
		 
//		 System.out.println("getModiyState>>>>>>>>>>>>>>>>orderDetailBak.getOrderDayInfos()>>>>>>>>>bbbbbbbbbbbbbbbbbbbbbbbbbbbb>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetailBak.getOrderDayInfos() );
//		 System.out.println("getModiyState>>>>>>>>>>>>>>>>orderDetailBak.getOrderDayInfos().length>>>>>>>>>bbbbbbbbbbbbbbbbbbbbbbbbbbbb>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderDetailBak.getOrderDayInfos().length );
//		 System.out.println("getModiyState>>>>>>>>>>>>>>>>isNew>>>>>>>>>bbbbbbbbbbbbbbbbbbbbbbbbbbbb>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + isNew);
			
		 getOrderDayInfoMap(orderDetailBak,orderDetailBak.getOrderDayInfos(),orderDayInfoMapBak);
		 getOrderDayInfoMap(orderDetail,orderDetail.getOrderDayInfos(),orderDayInfoMapCur);

	 
		 //新订单需要处理
		 if(isNew){
			 return 1;
		 }else{
			 
			 //判断是否需修改广告长度，长度变要处理
//			 boolean isResChanged = !orderDetailBak.getResourceInfoId().equals(orderDetail.getResourceInfoId());
//			 if(isResChanged) return 2;
			
			 //判断是否需修改广告长度，长度变要处理
			 boolean isAdLengthChanged = !orderDetailBak.getMatterLength().equals(orderDetail.getMatterLength());
			 if(isAdLengthChanged) return 2;
			 
			 //判断是否需要修改排期
			 boolean isArrangChanged = checkPublishArrangChanged(orderDayInfoMapBak,orderDayInfoMapCur);
			 if(isArrangChanged) return 2;	
			 
			 boolean isSpeciChanged = !orderDetailBak.getResourceSpecificId().equals(orderDetail.getResourceSpecificId());

			 if(isSpeciChanged) return 3;
			 


		 }

		 return 0;

	 }
	 
	 
 public static boolean checkPublishArrangChanged(Map orderDayInfoMapBak,Map orderDayInfoMapCur){

		 String key ="";
		 Iterator it = orderDayInfoMapBak.keySet().iterator();
//		 boolean isSameKey = orderDayInfoMapBak.keySet().containsAll(orderDayInfoMapCur.keySet());
		 boolean isSameKey = CollectionUtils.isEqualCollection(orderDayInfoMapBak.keySet(),orderDayInfoMapCur.keySet());


		 if(isSameKey){
			 while(it.hasNext()){
				 key = String.valueOf(it.next());
				 Object obj = orderDayInfoMapCur.get(key);
				 if(obj != null){
					 OrderDayInfo orderDayInfoBak =  (OrderDayInfo)orderDayInfoMapBak.get(key);
					 OrderDayInfo orderDayInfoCur = (OrderDayInfo)obj;
					 int dayTimesBak = Integer.parseInt(StringUtil.getNullValue(orderDayInfoBak.getAdDayTimes(),"0"));
					 int dayTimesCur = Integer.parseInt(StringUtil.getNullValue(orderDayInfoCur.getAdDayTimes(),"0"));
					 if(dayTimesBak != dayTimesCur)  return true; 
				 }else{
					 return true; 
				 }
			 } 
			 return false; 
		 }else{
			 return true;
		 }

	 }
	 

   	 
	 public static synchronized String unAbleSaveWarn(int model,OrderDetail orderDetail,Map orderDayInfoMapBak,Map orderDayInfoMapCur,Map newResMap){
		 
	 

		 Map resChangedMap  = new HashMap();
		 Map timLimitMap  = new HashMap();
		 Map specMap  = new HashMap();

		 if(model == 0) return "";

//		  返回的状态标志 0、不修改  1、是新添  2、修改订单日信息及资源信息  3、修改资源信息（只修改指定）
		 if(model == 1){
			 getResourceInfo(model,orderDetail,orderDayInfoMapCur, newResMap,resChangedMap,timLimitMap,specMap);
		 }else{
			 getResourceInfo(model,orderDetail.getOrderDetailBak(),orderDayInfoMapBak, newResMap,resChangedMap,timLimitMap,specMap);
			 getResourceInfoMoid(orderDetail,orderDayInfoMapBak,orderDayInfoMapCur, newResMap,resChangedMap,timLimitMap,specMap);
		 }		 

		 StringBuffer sb = new StringBuffer();
		 Map mp = new HashMap();
		 int i = 0;

		 if(specMap.size() > 0){
			 mp = specMap; i = 1;sb.append("<b>已被指定</b>"+"\n\r<br/>");
		 }		 
		 if(timLimitMap.size() > 0){
			 mp = timLimitMap; i = 2;sb.append("<b>广告超时超时</b>"+"\n\r<br/>");
		
		 }
//		 if(resChangedMap.size() > 0){
//			 
//			 mp = resChangedMap; i = 3;sb.append("广告资源已被占用造成超时"+"\n\r");
//		 }	 
		 
		
		 Iterator it = mp.values().iterator();		 
		  while (it.hasNext()) {
			DayInfo dayInfo = (DayInfo) it.next();
			
			String publishDate = DateUtil.SetDateFormat(dayInfo.getPublishDate().toString(),"yyyy/MM/dd");
			
			sb.append(publishDate);
			if(i == 1){
				sb.append("指定时间【"+publishDate+"】\n\r<br/>");
			}
			if(i == 2){
				sb.append(" 剩余长度【"+ String.valueOf(Double.parseDouble(dayInfo.getTotal())-Double.parseDouble(dayInfo.getUsed())-dayInfo.getChangedValue().doubleValue()) +"】秒\n\r<br/>");
			}
//			if(i == 3){
//				sb.append("超时长度2【" + String.valueOf(Integer.parseInt(dayInfo.getUsed())-Integer.parseInt(dayInfo.getTotal())) +"】\n\r");
//			}
		} 
		  

		

//		 System.out.println("unAbleSaveWarn>>>>>>>>>>>>>>>>>>>>>>>>>>>>isEmpty>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + org.apache.commons.lang.StringUtils.isEmpty(s) );	
		 
	

		 return  sb.toString();
	 }
	 
	 
	 
	 
	 public static synchronized String saveOrderDayInfos_bak(OrderDetail orderDetail){
	
		 OrderDetail orderDetailBak =  orderDetail.getOrderDetailBak();
//		 System.out.println("removeOrderDayInfoByOrderDetailId orderDetailBak     getPublishStartDate>>"+orderDetailBak.getPublishStartDate());
//		 System.out.println("removeOrderDayInfoByOrderDetailId  orderDetailBak    getPublishEndDate>>"+orderDetailBak.getPublishEndDate());
//		 
//		 System.out.println("removeOrderDayInfoByOrderDetailId  orderDetail      getPublishStartDate  >>"+orderDetail.getPublishStartDate());
//		 System.out.println("removeOrderDayInfoByOrderDetailId  orderDetai       getPublishEndDate  l>>"+orderDetail.getPublishEndDate());
//		 
//		 System.out.println("removeOrderDayInfoByOrderDetailId  DetailBak>>"+orderDetail.getOrderDetailBak().getResourceInfoId()); 
//		 System.out.println("removeOrderDayInfoByOrderDetailId  Detailid>>"+orderDetail.getResourceInfoId());

		 return null;
	 }
	 
	 
	 
	 
	 
	 
	 
	 public static synchronized String saveOrderDayInfos(int model,OrderDetail orderDetail,Map newResMap,Map orderDayInfoMapBak, Map orderDayInfoMapCur){

	     OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
	     OrderDayInfo[] orderDayInfosBak = orderDetail.getOrderDetailBak().getOrderDayInfos();

//		 返回的状态标志 0、不修改  1、是新添  2、修改订单日信息及资源信息  3、修改资源信息（只修改指定）

		 //保存时间资源前，先判断是否
	  if(model != 0 && newResMap.size()>0){
	    	 ResourceUtil.updateDayInfos(newResMap);
	     }
		 

		 if(model != 0){
			 //先删除 2、修改订单日信息及资源信息  3、修改资源信息（只修改指定）
			 if(model == 2 && orderDayInfosBak.length >0) {
				 removeOrderDayInfoByOrderDetailId(orderDetail.getOrderDetailBak().getId());
//				 System.out.println("removeOrderDayInfoByOrderDetailId  Detailid 2>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDetail.getOrderDetailBak().getId());
			 }
			 
//			 System.out.println("saveOrderDayInfos>>>>>>>>>>>>>>>>>>>>>orderDayInfos.length 6666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDayInfos.length);
			 //再新添加 1、是新添  2、修改订单日信息及资源信息
			 if(model != 3  && orderDayInfos.length> 0 ){
//				System.out.println("saveOrderDayInfos  curList>>"+orderDayInfos);
//				 System.out.println("addOrderDayInfos   3>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDayInfos.length);
				addOrderDayInfos(orderDetail,orderDayInfos);
//				 System.out.println("addOrderDayInfos   4>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDayInfos.length);
			 }		
		 }
		 
//		 else{
//			 OrderDetail orderDetailBak = orderDetail.getOrderDetailBak();
////			 boolean isOrderCateChange = !orderDetailBak.getOrderCategoryId().equals(orderDetail.getOrderCategoryId());
//			 OrderDayInfoDao orderDayInfoDao = ServiceLocator.getOrderDayInfoDao();
//		     if("0".equals(orderDetail.getOrderCategoryMain())){
//				 Map mp = new HashMap();
//				 mp.put("orderDetailId",orderDetail.getId());
////				 mp.put("cal",orderDetail.getOrderCategoryMain());
//				 orderDayInfoDao.saveOrderDayInfosCal(mp); 
//		     }
//
//			 
//			 System.out.println("isOrderCateChange   hhhhhhhhhhhhhhhhhhhh00000000000000000000000000000000000000000000000000000000000000000000000000hhhhhhhhhhhhhhhhh>>>>>>>>>>>"+ orderDetail.getOrderCategoryMain() +">>>>>>>>>>>>>>"+orderDetailBak.getOrderCategoryMain());
//
//		 }
		 return null;
		 
	 }
	 
	 
	 
	 public static synchronized String saveOrderDayInfos2(int model,OrderDetail orderDetail,Map newResMap,Map orderDayInfoMapBak, Map orderDayInfoMapCur){

	     OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
	     OrderDayInfo[] orderDayInfosBak = orderDetail.getOrderDetailBak().getOrderDayInfos();

//		 返回的状态标志 0、不修改  1、是新添  2、修改订单日信息及资源信息  3、修改资源信息（只修改指定）

		 //保存时间资源前，先判断是否
	     if(model != 0 && newResMap.size()>0){
	    	 ResourceUtil.updateDayInfos(newResMap);
	     }
		 
	     
//	     System.out.println("removeOrderDayInfoByOrderDetailId  model 1>>>>>>2  >>>>>>>>3  **********8     9>>>>>>>>>>>"+ model);
//	     System.out.println("orderDayInfosBak.length >>>>>>>>>>>>>>> orderDayInfosBak.length>>>>>>>>>"+ orderDayInfosBak.length);

		 if(model != 0){
			 //先删除 2、修改订单日信息及资源信息  3、修改资源信息（只修改指定）
			 if(model == 2 && orderDayInfosBak.length >0) {
//				 System.out.println("removeOrderDayInfoByOrderDetailId  Detailid 1>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDetail.getOrderDetailBak().getId());
				 
				  String resourceId_bak = orderDetail.getOrderDetailBak().getResourceInfoId().toString();
				  String resourceId_cur = orderDetail.getResourceInfoId().toString();
				  
//					 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> resourceId_bak>>>>>>>>>"+resourceId_bak);
//					 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> resourceId_cur>>>>>>>>>"+resourceId_cur);
				 
					List ls_mod = new ArrayList();
					List ls_remove = new ArrayList();
					List ls_add = new ArrayList();
					
					List mod_orderDayInos = new ArrayList();
						
					
					
					
				 for(int i = 0;i<orderDayInfosBak.length;i++){
					  String key = resourceId_bak +","+orderDayInfosBak[i].getPublishDate();
					  double puton_bak = orderDayInfosBak[i].getDayRelPuton().doubleValue();
					  
//					  System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> bak key>>>>>>>>>"+key);
//					  System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> puton_bak>>>>>>>>>"+puton_bak);
					  
					  if(orderDayInfoMapCur.containsKey(key)){
						  	OrderDayInfo orderDayInfo =  new OrderDayInfo(); 
						  	 ConvertUtil.copyBeanProperties2(orderDayInfo,(OrderDayInfo)orderDayInfoMapCur.get(key));
							  orderDayInfo.setId(orderDayInfosBak[i].getId());
							  if(puton_bak > 0)  orderDayInfo.setDayRelPuton(new Double(puton_bak));
							  ls_mod.add(orderDayInfo);
					  }else{
						  OrderDayInfo orderDayInfo =  new OrderDayInfo();
							 ConvertUtil.copyBeanProperties2(orderDayInfo,orderDayInfosBak[i]);
							 
						  if(puton_bak >0){
							  orderDayInfo.setAdDayTimes(new Integer(0));
//							  orderDayInfo.setDayRelPuton(new Double(puton_bak));
//							  System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> puton_bak>>>>>>>>>"+orderDayInfo.getDayRelPuton());
							  ls_mod.add(orderDayInfo);
						  }else{
							  ls_remove.add(orderDayInfosBak[i].getId());
						  	}
						 
						  
					  }
					  
//					  OrderDayInfo orderDayInfo =  (OrderDayInfo)orderDayInfoMapBak.get(key); 
//					 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> Id>>>>>>>>>"+orderDayInfo.getId());
//					 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> Id>>>>>>>>>"+orderDayInfo.getResourceSpecific());
//					 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> Id>>>>>>>>>"+orderDayInfo.getPublishDate());
//					 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> Adlength>>>>>>>>>"+orderDayInfo.getAdDayTimes());
				 }
				 
				 for(int i = 0;i<orderDayInfos.length;i++){
					 String key = resourceId_cur +","+orderDayInfos[i].getPublishDate();
//					 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> new key>>>>>>>>>"+key);
					 if(!orderDayInfoMapBak.containsKey(key)){
						 ls_add.add(orderDayInfos[i]);
					  }
				 }	 
				 
				 
//				 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> ls_mod>>>>>>>>>"+ls_mod.size());
//				 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> ls_remove>>>>>>>>>"+ls_remove.size());
//				 System.out.println("saveOrderDayInfos orderDayInfosBak model =2 >>>>>>>>>>>>>>> ls_add>>>>>>>>>"+ls_add.size());

				 OrderDayInfo[] orderDayInfos2 = new OrderDayInfo[ls_mod.size()+ls_add.size()];
				 
				 if(ls_mod.size()>0){
					 CollectionUtils.addAll(mod_orderDayInos,ls_mod.iterator());
				 }
				 if(ls_add.size()>0){
					 CollectionUtils.addAll(mod_orderDayInos,ls_add.iterator());
				 } 
				 
				 for(int i = 0;i<mod_orderDayInos.size();i++){
					 orderDayInfos2[i] = (OrderDayInfo)mod_orderDayInos.get(i);
				 }
			
				 if(orderDayInfos2.length >0){
						addOrderDayInfos(orderDetail,orderDayInfos2);
				 }


				 if(ls_remove.size()>0){
					 remoceOrderDays(ls_remove);
				 }

//				 removeOrderDayInfoByOrderDetailId(orderDetail.getOrderDetailBak().getId());
//				 System.out.println("removeOrderDayInfoByOrderDetailId  Detailid 2>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDetail.getOrderDetailBak().getId());
			 }
			 
//			 System.out.println("saveOrderDayInfos>>>>>>>>>>>>>>>>>>>>>orderDayInfos.length 6666666666>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDayInfos.length);
			 //再新添加 1、是新添  2、修改订单日信息及资源信息
			 if(model != 3 && model != 2 && orderDayInfos.length> 0 ){
//				System.out.println("saveOrderDayInfos  curList>>"+orderDayInfos);
//				 System.out.println("addOrderDayInfos   3>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDayInfos.length);
				addOrderDayInfos(orderDetail,orderDayInfos);
//				 System.out.println("addOrderDayInfos   4>>>>>>>>>>>>>>>>>>>>>>>>>"+orderDayInfos.length);
			 }		
		 }
		 
//		 else{
//			 OrderDetail orderDetailBak = orderDetail.getOrderDetailBak();
////			 boolean isOrderCateChange = !orderDetailBak.getOrderCategoryId().equals(orderDetail.getOrderCategoryId());
//			 OrderDayInfoDao orderDayInfoDao = ServiceLocator.getOrderDayInfoDao();
//		     if("0".equals(orderDetail.getOrderCategoryMain())){
//				 Map mp = new HashMap();
//				 mp.put("orderDetailId",orderDetail.getId());
////				 mp.put("cal",orderDetail.getOrderCategoryMain());
//				 orderDayInfoDao.saveOrderDayInfosCal(mp); 
//		     }
//
//			 
//			 System.out.println("isOrderCateChange   hhhhhhhhhhhhhhhhhhhh00000000000000000000000000000000000000000000000000000000000000000000000000hhhhhhhhhhhhhhhhh>>>>>>>>>>>"+ orderDetail.getOrderCategoryMain() +">>>>>>>>>>>>>>"+orderDetailBak.getOrderCategoryMain());
//
//		 }
		 return null;
		 
	 }
}