///****************************************************************************     
// * Created on 2007-6-25                                      *    
// *                                                               			*
// * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
// *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
// *                                                                          *
// * @version  Vision:1.0														*
// * 																			*
// ***************************************************************************/
//package com.vriche.adrm.util;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import com.vriche.adrm.model.OrderDayInfo;
//
//public class OrderDayUtil {
//	
//	
//	
//// 获得日分配金额
//	public static synchronized void getOrdersDaysMony(List dayInfos,Double sumMoney,int model){
////		BigDecimal  bg = new BigDecimal("0");
//		long sumRealPlay = sumMoney.longValue();
//		
//		if(model == 0){
//			getDayAllotMony(dayInfos,sumRealPlay);
//		}else{
//			Map ordersMap = new HashMap();
//			Map ordersValueMap  = new HashMap();
//			Map orderDetailsValueMap  = new HashMap();
//			Map orderDaysValueMap  = new HashMap();
//			
//			long baseMoney = getBaseMoney(dayInfos,ordersMap,ordersValueMap,orderDetailsValueMap,orderDaysValueMap);
//			
//			//把总应收分配到订单 
//			allotOrderMony(ordersValueMap,baseMoney,sumRealPlay);
//			//把订单应收分配到订单明细
//			allotOrderDetailMony(orderDetailsValueMap,ordersValueMap);
//			//把明细应收分配到天
//			allotOrderDayMony(orderDaysValueMap,orderDetailsValueMap);
//			//把MAP的应收放到日对象
//			getDayAllotMony(dayInfos,orderDaysValueMap);
//			
//			//分配尾数到 比率最大的日信息表中
////			resetDayInfosByDaysMap(dayInfos,orderDaysMap);			
//		}
//
//	}
//	
//	//总刊例价
//	public static long getBaseMoney(List dayInfos,Map orders,Map ordersValueMap,Map orderDetailsValueMap,Map orderDaysValueMap){
//		long baseMoney = 0;
//		Map orderDetails = new HashMap();
//		Map orderDays = new HashMap();
//		
//		for (Iterator it = dayInfos.iterator(); it.hasNext();) {
//			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
//			Long orderId = orderDayInfo.getOrderId();
//			Long orderDetailId = orderDayInfo.getOrderDetailId();
//			Long orderDayId = orderDayInfo.getId();
//			
//			long dayBase = orderDayInfo.getDayStandardPrice().intValue() * orderDayInfo.getAdDayTimes().intValue();
//			baseMoney += dayBase;
//
//			if(orders.containsKey(orderId)){
//				
//				Long old_order_Value = (Long)ordersValueMap.get(orderId);
//				Long new_order_Value = new Long(dayBase + old_order_Value.longValue());
//				ordersValueMap.remove(orderId);
//				ordersValueMap.put(orderId,new_order_Value);
//				
//				if(orderDetails.containsKey(orderDetailId)){
//					if(!orderDays.containsKey(orderDayId)) orderDays.put(orderDayId,orderDayInfo);
//					orderDetails.remove(orderDetailId);
//					orderDetails.put(orderDetailId,getOrderDays(orderDays,orderDetailId));
//					
//					Long old_detail_Value = (Long)orderDetailsValueMap.get(orderDetailId);
//					Long new_detail_Value = new Long(dayBase + old_detail_Value.longValue());
//					orderDetailsValueMap.remove(orderDetailId);
//					orderDetailsValueMap.put(orderDetailId,new_detail_Value);
//					
//				}else{
//					
//					orderDetails.put(orderDetailId,getOrderDays(orderDays,orderDetailId));
//					orderDetailsValueMap.put(orderDetailId,new Long(dayBase));
//				}
//				
//				orders.remove(orderId);
//				orders.put(orderId,getOrderDetails(orderDetails,orderId));
//				
//			}else{
//				orders.put(orderId,getOrderDetails(orderDetails,orderId));
//				ordersValueMap.put(orderId,new Long(dayBase));
//			}
//			
//		}
//		
//		return baseMoney;
//	}
//	public static Map getOrderDays(Map orderDays,Long orderDetailId){
//		Map orderDaysMap = new HashMap();
//		for (Iterator it = orderDays.values().iterator(); it.hasNext();) {
//            	OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
//            	Long id = orderDayInfo.getOrderDetailId();
//            	if(id.equals(orderDetailId)){
//            		orderDaysMap.put(id,orderDayInfo);
//            	}
//
//		}
//		return orderDaysMap;
//	}	
//	
//	public static Map getOrderDetails(Map orderDetails,Long orderId){
//		Map orderDetailsMap = new HashMap();
//		for (Iterator it = orderDetails.keySet().iterator(); it.hasNext();) {
//			    Long orderDetailId = (Long)it.next();
//			    Map orderDays  = (Map)orderDetails.get(orderDetailId);
//			    for (Iterator it1 = orderDays.values().iterator(); it1.hasNext();) {
//			    	OrderDayInfo orderDayInfo = (OrderDayInfo) it1.next();
//			    	Long orId = orderDayInfo.getOrderDetailId();
//			    	if(orderId.equals(orId)){
//	                   if(!orderDetailsMap.containsKey(orderDetailId)){
//	                	   orderDetailsMap.put(orderDetailId,orderDays);
//	                   }
//			    	}
//			    }
//		}
//        return orderDetailsMap;
//	}	
//	
//	
//	
//	
////	把总应收分配到订单 
//	public static void allotOrderMony(Map ordersValueMap,long baseMoney,long sumRealPlay){
//
//	}	
//	
//	//把订单应收分配到订单明细
//	public static void allotOrderDetailMony(Map orderDetailsValueMap,Map ordersValueMap){
//
//	}		
//	
//	//把明细应收分配到天
//	public static void allotOrderDayMony(Map orderDaysValueMap,Map orderDetailsValueMap){
//		
//	}
//	
//	//把MAP的应收放到日对象
//	public static void getDayAllotMony(List dayInfos,Map orderDaysValueMap){
//		
//	}
//	
//	//把MAP的应收放到日对象
//	public static void getDayAllotMony(List dayInfos,long sumRealPlay){
//		
//	}	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	//获得比率最大订单
//	public static Map getMarstBaseMoneyOrder(Map ordersMap,Map ordersValueMap, Map orderDetailsValueMap){
//		return null;
//	}
//
//	
//	//日分配比率
//	public static void getDayAllotMony(List dayInfos,long BaseMoney,long sumRealPlay){
//	
//	}	
//	
//	
//	
//	public static Double getDayAllotRate(long BasePrice,int dayTimes,long BaseMoney){
//		Double rate = new Double(Math.round((BasePrice*dayTimes/BaseMoney) / .01)*.01);
//		return rate;
//	}
//	
//
//	
//	//日分配后，剩余的尾数
//	public static long getSumAfterAllot(List dayInfos){
//		
//		return  0;
//	}	
//	
//	//日分配后，剩余的尾数
//	public static long getMantissa(long sumMoney,long sumAfterAllot){
//		
//		return  sumMoney - sumAfterAllot;
//	}	
//	
//	public static void resetDayInfosByDaysMap(List dayInfos,Map orderDaysMap){
//		
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////	//判断字符串是否全是整数
////	NumberUtils.isDigits("1.2");
////	//从数组中选出最大值		
////	NumberUtils.max(new int[] { 1, 2, 3, 4 });
////	//字符串转为数字
////	NumberUtils.stringToInt("ba", 33);
////	Range normalScoreRange = new DoubleRange(90, 120);
//
////Math.round( ) 方法进行四舍五入计算：
////
////trace(Math.round(204.499)); // 显示: 204
////
////trace(Math.round(401.5)); // 显示: 402
////
////Math.floor( ) 方法去掉小数部分，Math.ceil( ) 方法去掉小数部分后自动加1：
////
////trace(Math.floor(204.99)); // 显示: 204
////
////trace(Math.ceil(401.01)); // 显示: 402
////
////如果我想要把90.337 四舍五入到 90.34,可以这么写：
////
////trace (Math.round(90.337 / .01) * .01); //显示: 9.34
////
////trace (Math.round(92.5 / 5) * 5); // 显示: 95
////
////trace (Math.round(92.5 / 10) * 10); // 显示: 90
////
////更好的办法是用自定义函数NumberUtilities.round( ) ，它需要两个参数：
////
////number ：要舍入的数字
////
////roundToInterval ：间隔值
////
////NumberUtilities 类在 ascb.util 包中。
////
////imported ascb.util.NumberUtilities导入
////
////trace(NumberUtilities.round(Math.PI)); // Displays: 3
////
////trace(NumberUtilities.round(Math.PI, .01)); // Displays: 3.14
////
////trace(NumberUtilities.round(Math.PI, .0001)); // Displays: 3.1416
////
////trace(NumberUtilities.round(123.456, 1)); // Displays: 123
////
////trace(NumberUtilities.round(123.456, 6)); // Displays: 126
////
////trace(NumberUtilities.round(123.456, .01)); // Displays: 123.46
