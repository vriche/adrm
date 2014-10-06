package com.vriche.adrm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.model.OrderDayInfo;

public class IncomeUtil {
	//income代表分配金额
//	public Map IncomePuton(List detailList,List usedList,double income){
//		Iterator detailit = detailList.iterator();
//		Iterator useit = detailList.iterator();
//		
////		List orderList = new ArrayList();
//		
////		Map orderDayInfosMap = new HashMap();
////		Map incomeUsedsMap = new HashMap();
////		Map payin = new HashMap();
//		Map incomeUsedsMap = getUseMap(usedList);
//		Map orderDayInfosMap = getOrderDayInfosMap(detailList);
//		Map orderDayInfosNewMap = new HashMap();
//		Map usesNewMap = new HashMap();
//		
//		
//		
//		Map realpayMap = new HashMap();//实际要付的钱的Map
//		Map orderReaPayMap = new HashMap();//实际得到的钱数
//		
//		Double orderDayInfoDouble;
//		Double incomeUsedDouble;
//		
//		List orderList ;
//		List useList ;
//		double orderDetSum;
//		double useDetSum;
//		double realpay;
//		while(detailit.hasNext()){
//			OrderDayInfo orderDayInfo = (OrderDayInfo)detailit.next();
//			IncomeUsed incomeUsed = (IncomeUsed)useit.next();
//			long orderDateId = orderDayInfo.getOrderDetailId().longValue();
//			long useDateId = incomeUsed.getOrderDetailId().longValue();
//			if(!orderDayInfosMap.containsKey(new Long(orderDateId))){
//				
//				orderDetSum = getOrderDayInfoSum(orderDateId,orderDayInfosMap);
//				
//				useDetSum = getIncomeUseSum(useDateId,usesNewMap);//得到已经付款的记录
//				realpay = orderDetSum - useDetSum;
//				realpayMap.put(new Long(orderDateId),new Double(realpay));
//				
//				Double realpayDouble = (Double)realpayMap.get(new Long(orderDateId));//每个detailId相同的记录一共需要多少钱
//				if(income>=realpayDouble.doubleValue()){
//					income = income - realpayDouble.doubleValue();
//					orderReaPayMap.put(new Long(orderDateId),realpayDouble);
//				}else{
//					realpayMap.remove(new Long(orderDateId));
//					realpayMap.put(new Long(orderDateId),new Double((realpayDouble.doubleValue()-income)));//将原来的实际应付减去income
//					orderReaPayMap.put(new Long(orderDateId),new Double(income));
//				}
//			}
//		}
//		return orderReaPayMap;
//	}
//public double getOrderDayInfoSum(long orderDetailId,Map orderDayInfosNewMap){
//	List ls = (List)orderDayInfosNewMap.get(new Long(orderDetailId));
//	Iterator it = ls.iterator();
//	
//	double orderSum=0;
//	
//	while(it.hasNext()){
//		OrderDayInfo orderInfos = (OrderDayInfo)it.next();
//		
//		orderSum=orderSum+orderInfos.getDayRelIncome().doubleValue();
//		}
//	return orderSum;
//}
//
//public double getIncomeUseSum(long orderDetailId,Map incomeUsedsMap){
//	List ls = (List)incomeUsedsMap.get(new Long(orderDetailId));
//	Iterator it = ls.iterator();
//	
//	double useSum=0;
//	
//	while(it.hasNext()){
//		IncomeUsed incomeUsed = (IncomeUsed)it.next();
//		
//		useSum=useSum+incomeUsed.getMoneyIn().doubleValue();
//		}
//	return useSum;
//}
//
////构造一个以detailId为Key，value为以detailId字段相同的记录
//public Map getOrderDayInfosMap(List detailList){
//	Map orderDayInfosMap = new HashMap();
//	List orderList = new ArrayList();
//	Iterator detailit = detailList.iterator();
//	
//	while(detailit.hasNext()){
//		OrderDayInfo orderDayInfo = (OrderDayInfo)detailit.next();
//		if(!orderDayInfosMap.containsKey(orderDayInfo.getOrderDetailId())){
//			
//			orderList = getOrderDaysInfoSumList(orderDayInfo.getOrderDetailId().longValue(),detailList);
//			
//			orderDayInfosMap.put(orderDayInfo.getOrderDetailId(),orderList);
//		}
//	}
//	return orderDayInfosMap;
//}
//
//public Map getUseMap(List usedList){
//	Iterator useit = usedList.iterator();
//	Map incomeUsedsMap = new HashMap();
////		long orderDetailId = ;
//	while(useit.hasNext()){
//		IncomeUsed incomeUsed = (IncomeUsed)useit.next();
//		if(!incomeUsedsMap.containsKey(incomeUsed.getOrderDetailId())){
//			incomeUsedsMap.put(incomeUsed.getOrderDetailId(),incomeUsed.getMoneyIn());
//		}
//	}
//	return incomeUsedsMap;
//}







}