/****************************************************************************     
 * Created on 2007-6-25                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.model.OrderDayInfo;

public class OrderDayUtil {
	
	
	long baseMoney = 0;
	long sumTimes = 0;

// 获得日分配金额
	public  synchronized Map getOrdersDaysMony(List dayInfos,double sumRealPlay,int model,double execPrice){
		
//		System.out.println(" sumRealPlay>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + sumRealPlay);
//		System.out.println(" model>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + model);
//		System.out.println(" dayInfos>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + dayInfos.size());


		Map orders = new HashMap();
		Map ordersValueMap  = new HashMap();
		Map orderDetailsValueMap  = new HashMap();
		Map orderDaysValueMap  = new HashMap();
		
		Map ordersValue  = new HashMap();
		Map orderDetailsValue  = new HashMap();
		Map orderDaysValue  = new HashMap();
		Map orderDaysValueBalance = new HashMap();
		int orderCalculateModelParam = SysParamUtil.getOrderCalculateModelParam();
		
		System.out.println(" sumRealPlay>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&   111111111111111111111 2222222222222222   33333333333333333333       4444444444444444   **********************" + sumRealPlay);
		
		
			if(model == 1){
				
				System.out.println(" sumTimes>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + this.sumTimes);
				
				//获得总总刊例价  日刊例价   return orderDaysValueMap;
				getValues(dayInfos,baseMoney,orders,ordersValueMap,orderDetailsValueMap,orderDaysValueMap,model,this);
				
				//把明细应收分配到天
				if(orderCalculateModelParam == 0){
					allotOrderDayMony(orderDaysValueMap,orderDaysValue,baseMoney,sumRealPlay,execPrice);
				}else{
					allotOrderDayMony_1(orderDaysValueMap,orderDaysValue,orderDaysValueBalance,baseMoney,sumRealPlay,execPrice,0,0);
				}
				
			}else{
				
				//获得总总刊例价  订单刊例价 明细刊例价 日刊例价
				getValues(dayInfos,baseMoney,orders,ordersValueMap,orderDetailsValueMap,orderDaysValueMap,model,this);
				
				if(baseMoney == 0){
					//把总应收分配到订单 
					allotOrderDayMony(dayInfos,sumRealPlay,this,orderDaysValue);

				}else{
					//把总应收分配到订单 
					allotOrderMony(orders,ordersValueMap,ordersValue,baseMoney,sumRealPlay);
					
					//把订单应收分配到订单明细
					allotOrderDetailMony(orders,orderDetailsValueMap,orderDetailsValue,ordersValueMap,ordersValue);
					
					//把明细应收分配到天
					allotOrderDayMony(orders,orderDaysValueMap,orderDaysValue,orderDetailsValueMap,orderDetailsValue);	
				}

				
			}
			//修改日对象中应收

		return orderDaysValue;
	}
	
public  synchronized List getOrdersDaysMony2(List dayInfos,double sumRealPlay,int model,double execPrice,double sumBalance,double oneDayBalane ){
		
//		System.out.println(" sumRealPlay>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + sumRealPlay);
//		System.out.println(" model>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + model);
//		System.out.println(" dayInfos>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + dayInfos.size());
	    
	    List real_balance_list = new ArrayList();
        
		Map orders = new HashMap();
		Map ordersValueMap  = new HashMap();
		Map orderDetailsValueMap  = new HashMap();
		Map orderDaysValueMap  = new HashMap();
		
		Map ordersValue  = new HashMap();
		Map orderDetailsValue  = new HashMap();
		Map orderDaysValue  = new HashMap();
		Map orderDaysValueBalance = new HashMap();
		
		int orderCalculateModelParam = SysParamUtil.getOrderCalculateModelParam();
		

		
		
			if(model == 1){
				
				
				//获得总总刊例价  日刊例价   return orderDaysValueMap;
				getValues(dayInfos,baseMoney,orders,ordersValueMap,orderDetailsValueMap,orderDaysValueMap,model,this);
				
				//把明细应收分配到天
				if(orderCalculateModelParam == 0){
					allotOrderDayMony(orderDaysValueMap,orderDaysValue,baseMoney,sumRealPlay,execPrice);
				}else{
					allotOrderDayMony_1(orderDaysValueMap,orderDaysValue,orderDaysValueBalance,baseMoney,sumRealPlay,execPrice,sumBalance,oneDayBalane);
				}
				
			}else{
				
				//获得总总刊例价  订单刊例价 明细刊例价 日刊例价
				getValues(dayInfos,baseMoney,orders,ordersValueMap,orderDetailsValueMap,orderDaysValueMap,model,this);
				
				if(baseMoney == 0){
					//把总应收分配到订单 
					allotOrderDayMony(dayInfos,sumRealPlay,this,orderDaysValue);

				}else{
					//把总应收分配到订单 
					allotOrderMony(orders,ordersValueMap,ordersValue,baseMoney,sumRealPlay);
					
					//把订单应收分配到订单明细
					allotOrderDetailMony(orders,orderDetailsValueMap,orderDetailsValue,ordersValueMap,ordersValue);
					
					//把明细应收分配到天
					allotOrderDayMony(orders,orderDaysValueMap,orderDaysValue,orderDetailsValueMap,orderDetailsValue);	
				}

				
			}
			//修改日对象中应收
			real_balance_list.add(0,orderDaysValue);
			real_balance_list.add(1,orderDaysValueBalance);
	
			
		return real_balance_list;
	}

	
	//获得关系和数值
	public  void getValues(List dayInfos,long baseMoney,Map orders,Map ordersValueMap,Map orderDetailsValueMap,Map orderDaysValueMap,int model,OrderDayUtil handle){
		Map orderDetails = new HashMap();
		Map orderDays = new HashMap();
		handle.baseMoney = 0;
		handle.sumTimes = 0;
		
		 
		Collections.sort(dayInfos,new OrderDayUtilComparator());
		
		for (Iterator it = dayInfos.iterator(); it.hasNext();) {
			
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			Long orderId = orderDayInfo.getOrderId();
			Long orderDetailId = orderDayInfo.getOrderDetailId();
			Long orderDayId = orderDayInfo.getId();
			
			long times =  orderDayInfo.getAdDayTimes().intValue();
			long dayBase = orderDayInfo.getDayStandardPrice().longValue() * times;
			long dayExecPrice = orderDayInfo.getDayExecPrice().longValue() * times;
			if(dayBase == 0 && dayExecPrice>0)  dayBase = dayExecPrice;
			
			handle.baseMoney += dayBase;
			handle.sumTimes += times;
			
		

			
			
			if(!orderDays.containsKey(orderDayId)){
				orderDays.put(orderDayId,orderDayInfo);
//				没有刊例价格，但有手动价格
				if(model == 1 ){
					orderDaysValueMap.put(orderDayId,new Long(times));
				}else{
					orderDaysValueMap.put(orderDayId,new Long(dayBase));
				}
				
				
				
			}
			
			
			if(model == 0 || model == 2){
				
				
				if(orderDetails.containsKey(orderDetailId)){
					orderDetails.remove(orderDetailId);
					orderDetails.put(orderDetailId,getOrderDays(orderDays,orderDetailId));
					
					Long old_detail_Value = (Long)orderDetailsValueMap.get(orderDetailId);
					Long new_detail_Value = new Long(dayBase + old_detail_Value.longValue());
					
					orderDetailsValueMap.remove(orderDetailId);
					orderDetailsValueMap.put(orderDetailId,new_detail_Value);
				}else{
					orderDetails.put(orderDetailId,getOrderDays(orderDays,orderDetailId));
					orderDetailsValueMap.put(orderDetailId,new Long(dayBase));
				}				
				

				if(orders.containsKey(orderId)){
					//保存关系
					orders.remove(orderId);
					orders.put(orderId,getOrderDetails(orderDetails,orderId));
					//保存数值
					Long old_order_Value = (Long)ordersValueMap.get(orderId);
					Long new_order_Value = new Long(dayBase + old_order_Value.longValue());
					ordersValueMap.remove(orderId);
					ordersValueMap.put(orderId,new_order_Value);
//					getorderDetailsValueMap(orderDays,orderDetails,orderDetailId,dayBase,orderDetailsValueMap);

				}else{
					orders.put(orderId,getOrderDetails(orderDetails,orderId));
					
					ordersValueMap.put(orderId,new Long(dayBase));
//					getorderDetailsValueMap(orderDays,orderDetails,orderDetailId,dayBase,orderDetailsValueMap);
				}				
			}
		}

	}
	

	
	public  Map getOrderDays(Map orderDays,Long orderDetailId){
		Map orderDaysMap = new HashMap();
		
		for (Iterator it = orderDays.values().iterator(); it.hasNext();) {
            	OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
            	
            	if(orderDetailId.equals(orderDayInfo.getOrderDetailId())){
            		orderDaysMap.put(orderDayInfo.getId(),orderDayInfo);
            	}

		}
		return orderDaysMap;
	}	
	
	public static Map getOrderDetails(Map orderDetails,Long orderId){
		Map orderDetailsMap = new HashMap();
		for (Iterator it = orderDetails.keySet().iterator(); it.hasNext();) {
			    Long key_detail = (Long)it.next();
			    Map orderDays  = (Map)orderDetails.get(key_detail);
			    for (Iterator it1 = orderDays.values().iterator(); it1.hasNext();) {
			    	OrderDayInfo orderDayInfo = (OrderDayInfo) it1.next();
			    	
			    	if(orderId.equals(orderDayInfo.getOrderId())){
	                   if(orderDetailsMap.containsKey(key_detail)){
	                	   orderDetailsMap.remove(key_detail);
	                	   orderDetailsMap.put(key_detail,orderDays);
	                   }else{
	                	   orderDetailsMap.put(key_detail,orderDays);
	                   }
			    	}
			    }
		}
		
//		System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvv"+ orderDetailsMap.size());
        return orderDetailsMap;
	}	

	
//	把总应收分配到订单 
	public  void allotOrderMony(Map orders,Map ordersValueMap,Map ordersValue,long baseMoney,double sumRealPlay){
		double bgRealPlay = 0;
		long maxValue = 0; 
		Long maxId = new Long(0);
		

		for (Iterator it = ordersValueMap.keySet().iterator(); it.hasNext();) {
			Long key = (Long)it.next();
			Long value = (Long)ordersValueMap.get(key);
			
			//获得基本播出最多的那条订单
			long maxNum = Math.max(maxValue,value.longValue());
			if(maxValue < maxNum) maxId = key;
			
			
			double rate = getRate(baseMoney,value);
			
			
//			System.out.println(" rate>>>>>>>>>> &&&&&&&&&&&&&&&&&&&&&&&&    **********************" + rate);

			
			
			 if(sumRealPlay*rate<1 && rate !=0){
				 if(bgRealPlay+1 <= sumRealPlay){
					 ordersValue.put(key,new Double(1));
				 }else{
					 ordersValue.put(key,new Double(0));
				 }
			 }else if(rate ==1){
				 		ordersValue.put(key,new Double(sumRealPlay));
				 		bgRealPlay += sumRealPlay;	
				 		break;
			 }else{
						Long realPlay = getRealPlay(sumRealPlay,rate);
						long real = realPlay.longValue();
						if(bgRealPlay+real>sumRealPlay){
							double temp= (new Double(sumRealPlay)).longValue()-bgRealPlay;
							ordersValue.put(key,new Double(temp));
							bgRealPlay += temp;	
						}else{
							ordersValue.put(key,new Double(realPlay.doubleValue()));
							//获得分配后总应收
							bgRealPlay += real;	
						}

			 }

		}
		
		//获得分配后的尾数
		double  releave = sumRealPlay - bgRealPlay;
		if(releave != 0){
			Double oldValue = (Double)ordersValue.get(maxId);
			if (oldValue == null) oldValue = new Double(0); 
			ordersValue.remove(maxId);
			ordersValue.put(maxId,new Double(oldValue.doubleValue() + releave));			
		}

	}	
	
	//把订单应收分配到订单明细
	public  void allotOrderDetailMony(Map orders,Map orderDetailsValueMap,Map orderDetailsValue,Map ordersValueMap,Map ordersValue){

		
		for (Iterator it = orders.keySet().iterator(); it.hasNext();) {
			Long key_order = (Long)it.next();
			Long baseMoney_order = (Long)ordersValueMap.get(key_order);
			Double sum_order_realPlay = (Double)ordersValue.get(key_order);
			double baseMoney = baseMoney_order.doubleValue();
			double sumRealPlay  = sum_order_realPlay.doubleValue();
			
			
			double bgRealPlay = 0;
			long maxValue = 0; 
			Long maxId = new Long(0);

			//根据订单与明细关系
			Map orderDetails = (Map)orders.get(key_order);
			
//			TreeMap orderDetails = new TreeMap();
//			
//			orderDetails.putAll(orderDetails1);
			
			
			for (Iterator iter = orderDetails.keySet().iterator(); iter.hasNext();) {
				
				Long key_detail = (Long)iter.next();
				Long value = (Long)orderDetailsValueMap.get(key_detail);

				
//				System.out.println(" allotOrder key_detail>>>>>ttttttt>>>>>" + key_detail);
//				System.out.println(" allotOrder value>>>>>ttttttttt>>>>>" + value);
//				System.out.println(" allotOrder baseMoney_order>>>>>ttttttttt>>>>>" + baseMoney_order);
				
				//获得基本播出最多的那条订单
				long maxNum = Math.max(maxValue,value.longValue());
				if(maxValue < maxNum) maxId = key_detail;
				
				
				
				double rate = getRateDouble(baseMoney,value.doubleValue());
				
				 if(sumRealPlay*rate<1 && rate !=0){
					 
//					 if(bgRealPlay == sumRealPlay || bgRealPlay+1 > sumRealPlay)  orderDetailsValue.put(key_detail,new Long(0));
					 if(bgRealPlay+1 <= sumRealPlay){
						 orderDetailsValue.put(key_detail,new Double(1));
						 bgRealPlay += 1;
					 }else{
						 orderDetailsValue.put(key_detail,new Double(0));
					 }
				 }else if(rate ==1){
					 orderDetailsValue.put(key_detail,new Double(sumRealPlay));
				 		bgRealPlay += sumRealPlay;	
				 		break;
			 }else{
						Long realPlay = getRealPlay(sumRealPlay,rate);
						//获得分配后总应收
						long real = realPlay.longValue();
						
						if(bgRealPlay+real>sumRealPlay){
							double temp= sumRealPlay-bgRealPlay;
							orderDetailsValue.put(key_detail,new Double(temp));
							bgRealPlay += temp;	
						}else{
							orderDetailsValue.put(key_detail,new Double(realPlay.longValue()));	
							bgRealPlay += real;
						}
						
				 }


			}
			
			
			
			//获得分配后的尾数
			double  releave = sum_order_realPlay.doubleValue() - bgRealPlay;
			
//			System.out.println(" allotOrderDetail releave>>>>>>>>>>" + releave);
//			System.out.println(" allotOrderDetail maxId>>>>>>>>>>" + maxId.longValue());
			
			if(releave != 0){
				Double oldValue = (Double)orderDetailsValue.get(maxId);
				
				if (oldValue == null) oldValue = new Double(0);
				orderDetailsValue.remove(maxId);
				orderDetailsValue.put(maxId,new Double(oldValue.doubleValue() + releave));		
			}
		
		}
		

	}		
	
	//把明细应收分配到天
	public  void allotOrderDayMony(Map orders,Map orderDaysValueMap,Map orderDaysValue,Map orderDetailsValueMap,Map orderDetailsValue){

		
		
		for (Iterator iter0 = orders.keySet().iterator(); iter0.hasNext();) {
			
			Long key_order = (Long)iter0.next();
			Map orderDetails = (Map)orders.get(key_order);
			
//		    TreeMap orderDetails = new TreeMap();
//
//			orderDetails.putAll(orderDetails1);
			
//			System.out.println(" allotOrderDayMony orderDetails.size*********************" + orderDetails.size());
			
			for (Iterator iter1 = orderDetails.keySet().iterator(); iter1.hasNext();) {
				
				Long key_detail = (Long)iter1.next(); 
				Map orderDays = (Map)orderDetails.get(key_detail);

				Double sum_detal_realPlay = (Double)orderDetailsValue.get(key_detail);
				Long baseMoney_detail = (Long)orderDetailsValueMap.get(key_detail);
//				System.out.println(" allotOrderDayMony sum_detal_realPlay *********************" + sum_detal_realPlay);
				double sumRealPlay  = sum_detal_realPlay == null?0:sum_detal_realPlay.doubleValue();
				double baseMoney = baseMoney_detail == null?0:baseMoney_detail.doubleValue();
				
//				if(sumRealPlay == 0) break;
				
//				System.out.println(" allotOrderDayMony orderDays.size *********************" + orderDays.size());
//				System.out.println(" allotOrderDayMony sumRealPlay *********************" + sumRealPlay);
//				System.out.println(" allotOrderDayMony baseMoney *********************" + baseMoney);
				
				
				double bgRealPlay = 0;
				long maxValue = 0; 
				Long maxId = new Long(0);
				
				for (Iterator iter2 = orderDays.keySet().iterator(); iter2.hasNext();) {
					Long key_day = (Long)iter2.next();
					Long value = (Long)orderDaysValueMap.get(key_day);

					//获得基本播出最多的那条订单
					long maxNum = Math.max(maxValue,value.longValue());
					if(maxValue < maxNum) maxId = key_day;

					double rate = getRateDouble(baseMoney,value.doubleValue());
					
					
					 if(sumRealPlay*rate<1 && rate !=0){
						 if(bgRealPlay+1 <= sumRealPlay){
							 orderDaysValue.put(key_day,new Double(1));
							 bgRealPlay += 1;
						 }else{
							 orderDaysValue.put(key_day,new Double(0));
						 }
					 }else if(rate ==1){
						 orderDaysValue.put(key_day,new Double(sumRealPlay));
					 		bgRealPlay += sumRealPlay;	
					 		break;
				 }else{
						   
							Long realPlay = getRealPlay(sumRealPlay,rate);
							//获得分配后总应收
							long real = realPlay.longValue();
							
							if(bgRealPlay+real>sumRealPlay){
//								orderDaysValue.put(key_day,new Long(0));
								double temp= sumRealPlay-bgRealPlay;
								orderDaysValue.put(key_day,new Double(temp));
								bgRealPlay += temp;									
							}else{
								bgRealPlay += real;	
								orderDaysValue.put(key_day,new Double(realPlay.longValue()));	
							}
	
					 }

				}
				
				//获得分配后的尾数
				double  releave = sumRealPlay - bgRealPlay;
				
//				System.out.println(" allotOrderDayMony releave >>>>>>>>" + releave);
				if(releave != 0){
					Double oldValue = (Double)orderDaysValue.get(maxId);
					if (oldValue == null) oldValue = new Double(0);
					orderDaysValue.remove(maxId);
					orderDaysValue.put(maxId,new Double(oldValue.doubleValue() + releave));					
				}
				
			}
		}
		
	}
	
	
	//把明细应收分配到天
	public  void allotOrderDayMony(List dayInfos,double sumRealPlay,OrderDayUtil handle,Map orderDaysValue){
		long sumTime = handle.sumTimes;
		double bgRealPlay = 0;
		long maxValue = 0; 
		
		Long maxId = new Long(0);
		
//		System.out.println(" sumTime >>>>>>>>" + sumTime);
		
		for (Iterator it = dayInfos.iterator(); it.hasNext();) {
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			Long key = orderDayInfo.getId();
//			long time = orderDayInfo.getAdDayTimes().longValue();
//			double rate = getRate(sumTime,new Long(orderDayInfo.getAdDayTimes().longValue()));
//			double rate = Math.round((orderDayInfo.getAdDayTimes().intValue()/sumTime) * 1000000000)/1000000000.000000000;
//			double rate = Math.round((time/sumTime) * 1000000000)/1000000000.000000000;
			
			double rate = getRate(sumTime,new Long(orderDayInfo.getAdDayTimes().longValue()));
			
			if(sumRealPlay*rate<1 && rate !=0){
				
										 if(bgRealPlay+1 <= sumRealPlay){
											 orderDaysValue.put(key,new Double(1));
											 bgRealPlay += 1;
										 }else{
											 orderDaysValue.put(key,new Double(0));
										 }
			}else if(rate ==1){
				 orderDaysValue.put(key,new Double(sumRealPlay));
			 		bgRealPlay += sumRealPlay;	
			 		break;
		 }else{
					Long realPlay = getRealPlay(sumRealPlay,rate);
    			
    			//获得基本播出最多的那条订单
    			long maxNum = Math.max(maxValue,realPlay.longValue());
    			if(maxValue < maxNum) maxId = key;

//    			orderDaysValue.put(key,realPlay);
    			
    			//获得分配后总应收
    			long real = realPlay.longValue();
    			if(bgRealPlay+real>sumRealPlay){
//    				 orderDaysValue.put(key,new Long(0));
    				double temp= new Double(sumRealPlay).longValue()-bgRealPlay;
						orderDaysValue.put(key,new Double(temp));
						bgRealPlay += temp;	
    			}else{
    				orderDaysValue.put(key, new Double(realPlay.longValue()));
    				bgRealPlay += real;
    			}
    			
    			
            }
            	
			
			
		}
		
		//获得分配后的尾数
//		long  releave = sumRealPlay - bgRealPlay.longValue();
		double  releave = sumRealPlay - bgRealPlay;
		if(releave != 0){
			Double oldValue = (Double)orderDaysValue.get(maxId);
			if (oldValue == null) oldValue = new Double(0);
			orderDaysValue.remove(maxId);
			orderDaysValue.put(maxId,new Double(oldValue.doubleValue() + releave));			
		}

	}
		
	
//	把明细应收分配到天
	public  void allotOrderDayMony_1(Map orderDaysValueMap,Map orderDaysValue,Map orderDaysValueBalance,long baseMoney,double sumRealPlay,double execPrice,double sumBalance,double oneDayBalane){
		double bgRealPlay =  .00;
		double bgBalance =  .00;
		double real =  .00;
		double balance =  .00;
		long maxValue = 0; 
		Long maxId = new Long(0);
		DecimalFormat df = new DecimalFormat("###########.00");
//		sumRealPlay = Double.parseDouble(df.format(sumRealPlay));
//		execPrice = Double.parseDouble(df.format(execPrice));

		for (Iterator it = orderDaysValueMap.keySet().iterator(); it.hasNext();) {
			Long key = (Long)it.next();
			Long value = (Long)orderDaysValueMap.get(key);

			//获得基本播出最多的那条订单
			long maxNum = Math.max(maxValue,value.longValue());
			if(maxValue < maxNum) maxId = key;
               
				Double realPlay2 = new Double(execPrice*value.longValue());
	
				Double realPlay = new Double(df.format(realPlay2));
				real = realPlay.doubleValue();
				balance = new Double(df.format(oneDayBalane)).doubleValue();
//				return new Long(Math.round(value));
				orderDaysValue.put(key,realPlay);
				orderDaysValueBalance.put(key, new Double(balance));
				
//				System.out.println(" sumRealPlay>>>>>>>>>>" + sumRealPlay);
//				System.out.println(" execPrice>>>>>>>>>>" + execPrice);
//				System.out.println(" value.longValue()>>>>>>>>>>" + value.longValue());
//				System.out.println(" execPrice*value.longValue()>>>>>>>>>>" + execPrice*value.longValue());
//				System.out.println(" realPlay>>>>>>>>>>" + realPlay.doubleValue());
//				System.out.println(" real>>>>>>>>>>" + real);
//				System.out.println(" balance>>>>>>>>>>" + balance);
				
				//获得分配后总应收
//				bgRealPlay += real;
//		 }        
				
				
//				System.out.println(" bgRealPlay>>>>>>>>>>" + bgRealPlay);
//				System.out.println(" sumRealPlay>>>>>>>>>>" + sumRealPlay);
//				System.out.println(" bgRealPlay+real>>>>>>>>>>" + (bgRealPlay+real));
	
				if(bgRealPlay+real>sumRealPlay){
//					 orderDaysValue.put(key,new Long(0));
					double temp= new Double(sumRealPlay).longValue()-bgRealPlay;
					    Double temp2 = new Double(df.format(temp));
						orderDaysValue.put(key,temp2);
						bgRealPlay += temp2.doubleValue();	
				
				}else{
					 Double real2 = new Double(df.format(real));
					orderDaysValue.put(key, real2);
					bgRealPlay += real2.doubleValue();
				}
				
				
				if(bgBalance+balance>sumBalance){
//					 orderDaysValue.put(key,new Long(0));
					double temp= new Double(sumBalance).longValue()-bgBalance;
					    Double temp2 = new Double(df.format(temp));
					    orderDaysValueBalance.put(key,temp2);
					    bgBalance += temp2.doubleValue();	
				
				}else{
					 Double balance2 = new Double(df.format(balance));
					 orderDaysValueBalance.put(key, balance2);
					 bgBalance += balance2.doubleValue();
				}				
				
				
				

			
		}
		
		//获得分配后的尾数
		double  releave = sumRealPlay - bgRealPlay;
		releave = Double.parseDouble(df.format(releave));
//		System.out.println(" releave releave>>>>>>>>>>" + releave);
		
		if(releave != 0){
			Double oldValue = (Double)orderDaysValue.get(maxId);
			if (oldValue == null) oldValue = new Double(0);
			orderDaysValue.remove(maxId);
			orderDaysValue.put(maxId,new Double(oldValue.doubleValue() + releave));			
		}
		
		
		double  balanceValue = sumBalance - bgBalance;
		balanceValue = Double.parseDouble(df.format(balanceValue));
//		System.out.println(" releave releave>>>>>>>>>>" + balanceValue);
		
		if(balanceValue != 0){
			Double oldValue = (Double)orderDaysValueBalance.get(maxId);
			if (oldValue == null) oldValue = new Double(0);
			orderDaysValueBalance.remove(maxId);
			orderDaysValueBalance.put(maxId,new Double(oldValue.doubleValue() + balanceValue));			
		}		
	
		


	}	
//	public  void allotOrderDayMony_1(Map orderDaysValueMap,Map orderDaysValue,long baseMoney,double sumRealPlay,double execPrice){
//		double bgRealPlay = 0;
//		long maxValue = 0; 
//		Long maxId = new Long(0);
//
//		for (Iterator it = orderDaysValueMap.keySet().iterator(); it.hasNext();) {
//			Long key = (Long)it.next();
//			Long value = (Long)orderDaysValueMap.get(key);
//
//			//获得基本播出最多的那条订单
//			long maxNum = Math.max(maxValue,value.longValue());
//			if(maxValue < maxNum) maxId = key;
//
//			double rate = getRate(baseMoney,new Long(value.longValue()));
//			
//			if(rate ==1){
//				 orderDaysValue.put(key,new Double(sumRealPlay));
//			 		bgRealPlay += sumRealPlay;	
//			 		break;
//		 }else{
//				Long realPlay = getRealPlay(sumRealPlay,rate);
//				orderDaysValue.put(key,new Double(realPlay.longValue()));
//				
//				//获得分配后总应收
//				long real = realPlay.longValue();
//				bgRealPlay += real;
//		 }
//			
//	
//
//
//			
//		}
//		
//		//获得分配后的尾数
//		double  releave = sumRealPlay - bgRealPlay;
//		if(releave != 0){
//			Double oldValue = (Double)orderDaysValue.get(maxId);
//			if (oldValue == null) oldValue = new Double(0);
//			orderDaysValue.remove(maxId);
//			orderDaysValue.put(maxId,new Double(oldValue.doubleValue() + releave));			
//		}
//
//	}	
	public  void allotOrderDayMony(Map orderDaysValueMap,Map orderDaysValue,long baseMoney,double sumRealPlay,double execPrice){
		double bgRealPlay = 0;
		long sumTimes = 0;
		long maxValue = 0; 
		Long maxId = new Long(0);
		double temDayPay = 0;
		int orderCalculateModelParam = SysParamUtil.getOrderCalculateModelParam();
		DecimalFormat df = new DecimalFormat("###########.00");
		for (Iterator it = orderDaysValueMap.keySet().iterator(); it.hasNext();) {
			Long key = (Long)it.next();
			Long value = (Long)orderDaysValueMap.get(key);
			double dayRel = execPrice*value.longValue();
			sumTimes += value.longValue();
//			orderDaysValue.put(key,new Double(execPrice*value.longValue()));
//			bgRealPlay += sumRealPlay;	
		}
		
		if(sumTimes >0) temDayPay =  new Double(df.format(sumRealPlay/sumTimes)).doubleValue();
		
	
//		System.out.println("temDayPay  yyyyyyyyyyyyyyyyyyyyyyyyy  > 0 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ temDayPay);
		
		
		for (Iterator it = orderDaysValueMap.keySet().iterator(); it.hasNext();) {
			Long key = (Long)it.next();
			Long value = (Long)orderDaysValueMap.get(key);
			double real = temDayPay*value.longValue();
			real =  new Double(df.format(real)).doubleValue();
			System.out.println("real  yyyyyyyyyyyyyyyyyyyyyyyyy  > 0 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ real);
			System.out.println("bgRealPlay+real  yyyyyyyyyyyyyyyyyyyyyyyyy  > 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ (bgRealPlay+real));
			if(bgRealPlay+real>sumRealPlay || sumRealPlay-(bgRealPlay+real)<real){
//				 orderDaysValue.put(key,new Long(0));
				double temp= new Double(sumRealPlay).doubleValue()-bgRealPlay;
				 System.out.println("temDayPay  yyyyyyyyyyyyyyyyyyyyyyyyy  > 2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ temp);
				    Double temp2 = new Double(df.format(temp));
				    System.out.println("temDayPay  yyyyyyyyyyyyyyyyyyyyyyyyy  > 3 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ temp2);
					orderDaysValue.put(key,temp2);
					bgRealPlay += 	new Double(df.format(temp2));
			
			}else{
				System.out.println("temDayPay  yyyyyyyyyyyyyyyyyyyyyyyyy  > 4 >>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ real);
				 Double real2 = new Double(df.format(real));
				 
				orderDaysValue.put(key, real2);
				bgRealPlay += new Double(df.format(real2));
			}
//			orderDaysValue.put(key,new Double(real));
		}	
		
		
			
	}	
	

	public static double getRate(long sumBase,Long oneBase){
		double rate = .00;
		if(sumBase > 0){
			rate = Math.round((oneBase.doubleValue()/sumBase) * 1000000000)/1000000000.000000000;
//			System.out.println(" oneBase>>>>>>>>>>" + oneBase.longValue());
//			System.out.println(" sumBase>>>>>>>>>>" + sumBase);
//			System.out.println(" rate>>>>>>>>>>" + rate);
		}
		return rate;
	}	
	
	public static double getRateDouble(double sumBase,double oneBase){
		double rate = .00;
		if(sumBase > 0){
			rate = Math.round((oneBase/sumBase) * 1000000000)/1000000000.000000000;
		}
		return rate;
	}	
	
	public static Long getRealPlay(double sumRealPlay,double rate){
		double value = sumRealPlay*rate;
		return new Long(Math.round(value));
	}	
	
	
	public static List getOrderDaysPraentIdZero(List adList,boolean isZero){
		List ls = new ArrayList();
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			if(isZero){
				if(orderDayInfo.getParentId().longValue() == 0) ls.add(orderDayInfo);
			}else{
				if(orderDayInfo.getParentId().longValue() > 0) ls.add(orderDayInfo);
			}
			
		}
		return ls;
	}
	
	public static void getOrderDaysPraentIdZero(List adList,List ls1,List ls2,boolean isZero){
//		List ls = new ArrayList();
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			
			if(orderDayInfo.getNeedCal().intValue()==1 && orderDayInfo.getParentId().longValue() == 0){
				ls1.add(orderDayInfo);
			}else{
				ls2.add(orderDayInfo);
			}	
		}
//		return ls;
	}
	
	public static void getOrderDaysPraentIdZero2(List adList,List ls1,Map mp,boolean isZero,Integer resourceType){
		boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
//		List ls = new ArrayList(); 
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			
			
			
//			if(isWithResourceSort && resourceType.intValue()>0 ){
//				 int rest = Integer.parseInt(StringUtil.getNullValue(orderDayInfo.getResourceType(),"0"));
//				
//				  System.out.println("resourceType tttttttttttttttttttttttttttttttttt KKKKKKKKKKKKKKKKKK  rest>>" + rest);
//				  System.out.println("resourceType yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy  KKKKKKKKKKKKKKKKKK>>" + resourceType.intValue());
//				  
//				if(orderDayInfo.getNeedCal().intValue()==1 && orderDayInfo.getParentId().longValue() == 0 && rest == resourceType.intValue()){
//					ls1.add(orderDayInfo);
//				}else{
////					ls2.add(orderDayInfo);
//					mp.put(orderDayInfo.getId(),new Long(0));
//				}
//			}else{
				if(orderDayInfo.getNeedCal().intValue()==1 && orderDayInfo.getParentId().longValue() == 0){
					ls1.add(orderDayInfo);
				}else{
//					ls2.add(orderDayInfo);
					mp.put(orderDayInfo.getId(),new Double(0));
				}
//			}
	
		}
//		return ls;
	}	
	
	
	public static List getOrderDaysByDetailId(List adList,Long orderDetailId,boolean isEqual){
		List ls = new ArrayList();
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			if(isEqual){
				if(orderDayInfo.getOrderDetailId().equals(orderDetailId)) ls.add(orderDayInfo);
			}else{
				if(!orderDayInfo.getOrderDetailId().equals(orderDetailId)) ls.add(orderDayInfo);
			}
			
		}
		return ls;
	}
	
	public static List getOrderDaysByDetailId(List adList,Long orderDetailId,int month){
		List ls = new ArrayList();
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
		
			int publishDate = Integer.parseInt(orderDayInfo.getPublishDate().toString().substring(4,6));
			boolean isSameMonth = (month == publishDate);
				
			if(orderDayInfo.getOrderDetailId().equals(orderDetailId) && isSameMonth){
				ls.add(orderDayInfo);
			}
		}
		return ls;
	}
	
	public static void getOrderMonthDays(List adList,Object[] dayTimes){

		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
		
			Integer publishDate = orderDayInfo.getPublishDate();
			int day = Integer.parseInt(publishDate.toString().substring(6,8));

			Integer t =  orderDayInfo.getAdDayTimes();
			dayTimes[day - 1] = (t == null)? new String("0"):t.toString();
		}
		
		for(int i =0;i<dayTimes.length;i++){
			if(dayTimes[i] == null ||dayTimes[i].equals(null)||"0".equals(dayTimes[i])) dayTimes[i] ="";
		}
	}	
	

	
	
	
	public static void getOrderMonthSysPrice(List adList,Double sysPrice,Object[] objs,boolean isRelPrice){
        
//		Object[] objs = new Object[2];
		double sumSys = 0;
		double sumRel = 0;
		int minDate =90000000;
		int maxDate =0;
		
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			

			
		
			Integer adDayTimes = orderDayInfo.getAdDayTimes();
			int times = (adDayTimes.equals(null))?0:adDayTimes.intValue();
			
			int d = orderDayInfo.getPublishDate().intValue();
//			System.out.println(">>>>88888888888888888888888888888888888888888888888888888888" + d);
			if(minDate > d && times >0) minDate = d;
			if(maxDate < d  && times >0) maxDate = d;			
			
			
			sumSys += sysPrice.doubleValue()*times;
			
			sumRel += orderDayInfo.getDayRelIncome().doubleValue();
            
		}
		sumRel = isRelPrice==true?sumRel:0;
		objs[0] = (sumSys == 0)?"0.0":String.valueOf(sumSys);
		objs[1] = (sumRel == 0)?"0.0":String.valueOf(sumRel); 
		objs[2] = (minDate == 90000000)?"19000101":String.valueOf(minDate); 
		objs[3] = (maxDate == 0)?"19000101":String.valueOf(maxDate); 

	}		
	
	public static void  getOrderDayListByStartEnd(List orderDayList,List newOrderDayList,String beginDate,String endDate){
		 for (Iterator it = orderDayList.iterator(); it.hasNext();) {
			 OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			 int publishDate = orderDayInfo.getPublishDate().intValue();
			 if(publishDate >= Integer.parseInt(beginDate) &&  publishDate <= Integer.parseInt(endDate)){
				 newOrderDayList.add(orderDayInfo);
			 }
		 } 
	}

	
	
	
	public static List getOrderDaysCompagesByParentId(List adList,Integer dt,Long parentId){
		List ls = new ArrayList();
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			Integer dat = orderDayInfo.getPublishDate();
			Long pId = orderDayInfo.getParentId();

			if(dat.equals(dt) && pId.equals(parentId)){
				ls.add(orderDayInfo);
			}
		}
		return ls;
	}
	
	
	
	
	
	public static List getOrderDaysCompagesParentSumMony(List adList,Map mp){
		List ls = new ArrayList();
//		Map parentValue = new HashMap();
//		Map dayValue = new HashMap();
		for(Iterator it = adList.iterator();it.hasNext();){
			OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
			Long orderDayId = orderDayInfo.getId();
			if(orderDayInfo.getCompagesId().longValue() > 0){
//				Long orderDetailId = orderDayInfo.getOrderDetailId();
				
				Long realPlay = (Long)mp.get(orderDayId);
				orderDayInfo.setDayRelIncome(new Double(realPlay.longValue()));
//				parentValue.put(orderDetailId,realPlay);
				ls.add(orderDayInfo);
			}
		}
		return ls;
	}	
	
	
	public static Map getResourceChangeMap(OrderDayInfo[] orderDayInfos){
		Map mpUse = new HashMap();

	   	for(int j = 0;j < orderDayInfos.length;j++){
	   		Integer publishDate = orderDayInfos[j].getPublishDate();
	   		int changeTimes =  orderDayInfos[j].getAdDayTimes().intValue();
	   		double adLength =  Double.parseDouble(orderDayInfos[j].getAdlength());
//	   		Integer changeValue = new Integer(-changeTimes * adLength);
	   		Double changeValue = new Double(changeTimes * adLength);
	   		mpUse.put(publishDate,changeValue);

		}
		return mpUse;
	}	
	
	public static Object[] getResourceChangeMap(OrderDayInfo[] orderDayInfos,List orderDaysList){
		Map mpUse = new HashMap();
		Map mpSpe = new HashMap();
		Object[] objs = new Object[2];
		Map adTimesMap = getAdTimesMap(orderDaysList);
//		Map adSpecificMap = getAdSpecificMap(orderDaysList);
	   	for(int j = 0;j < orderDayInfos.length;j++){
	   		Integer publishDate = orderDayInfos[j].getPublishDate();
	   		 
	   		int adTimes =   adTimesMap.get(publishDate) != null ?((Integer)adTimesMap.get(publishDate)).intValue():0;
	   		int curTimes =  orderDayInfos[j].getAdDayTimes().intValue();
	   		double adLength =  Double.parseDouble(orderDayInfos[j].getAdlength());
	   		
	   		int changeTimes = -(adTimes - curTimes);
//	   		boolean isUsedAdd = (changeTimes < 0);
//	   		changeTimes = -changeTimes;

	   		Double changeValue = new Double(changeTimes * adLength);
	   		String  chageSpecific = "";
//	   		String  chageSpecific = getChangeSpecific(changeTimes,adSpecific,curSpecific);

	   		
	   		mpUse.put(publishDate,changeValue);
	   		mpSpe.put(publishDate,chageSpecific);
		}
	   	objs[0] = mpUse;
	   	objs[1] = mpSpe;
		return objs;
	}
	
	
	private static String getChangeSpecific(int changeTimes,String adSpecific,String curSpecific){
   		String chageSpecific ="";
   		if(StringUtils.isEmpty(adSpecific)) adSpecific ="";
   		if(adSpecific !="" && adSpecific.matches(curSpecific)) ;
		return null;
	}
	
	//原来广告中播出 次数
	public static Map getAdTimesMap(List orderDaysList){
		Map mp = new HashMap();
		for(Iterator it = orderDaysList.iterator(); it.hasNext();){
			OrderDayInfo orderDayInfo =(OrderDayInfo) it.next();
			Integer publishDate = orderDayInfo.getPublishDate();
            Integer adTimes = orderDayInfo.getAdDayTimes();
			mp.put(publishDate,adTimes);
		}
		return mp;
	}	
	
//	原来广告中播出 次数
	public static Map getAdSpecificMap(List orderDaysList){
		Map mp = new HashMap();
		for(Iterator it = orderDaysList.iterator(); it.hasNext();){
			OrderDayInfo orderDayInfo =(OrderDayInfo) it.next();
			Integer publishDate = orderDayInfo.getPublishDate();
            String adSpecific = orderDayInfo.getResourceSpecific();
			mp.put(publishDate,adSpecific);
		}
		return mp;
	}		
	

	public static Map  getPublishDate(List orderDaysList){
		Map mp = new HashMap();
    	int startDate = 100000000;
    	int endDate =  0;
    	
		for(Iterator it = orderDaysList.iterator(); it.hasNext();){
			OrderDayInfo orderDayInfo =(OrderDayInfo) it.next();
			int publishDate = orderDayInfo.getPublishDate().intValue();
			startDate = Math.min(startDate,publishDate);
			endDate = Math.max(endDate,publishDate);
		}
		
		if(orderDaysList.size() == 0){
	    	startDate = new Integer(DateUtil.getDate()).intValue();
	    	endDate =  new Integer(DateUtil.getDate()).intValue();
		}
		
		mp.put("startDate",new Integer(startDate));
		mp.put("endDate",new Integer(endDate));
		
		return mp;
	}
	
	


}


//
////保留小数点后两位小数
//public static double Number2(double pDouble)
//{
//  BigDecimal  bd=new  BigDecimal(pDouble);
//  BigDecimal  bd1=bd.setScale(2,bd.ROUND_HALF_UP);
//  pDouble=bd1.doubleValue();
//  long  ll = Double.doubleToLongBits(pDouble);
// 
//  return pDouble;
//}


//
//	//判断字符串是否全是整数
//	NumberUtils.isDigits("1.2");
//	//从数组中选出最大值		
//	NumberUtils.max(new int[] { 1, 2, 3, 4 });
//	//字符串转为数字
//	NumberUtils.stringToInt("ba", 33);
//	Range normalScoreRange = new DoubleRange(90, 120);

//Math.round( ) 方法进行四舍五入计算：
//
//trace(Math.round(204.499)); // 显示: 204
//
//trace(Math.round(401.5)); // 显示: 402
//
//Math.floor( ) 方法去掉小数部分，Math.ceil( ) 方法去掉小数部分后自动加1：
//
//trace(Math.floor(204.99)); // 显示: 204
//
//trace(Math.ceil(401.01)); // 显示: 402
//
//如果我想要把90.337 四舍五入到 90.34,可以这么写：
//
//trace (Math.round(90.337 / .01) * .01); //显示: 9.34
//
//trace (Math.round(92.5 / 5) * 5); // 显示: 95
//
//trace (Math.round(92.5 / 10) * 10); // 显示: 90
//
//更好的办法是用自定义函数NumberUtilities.round( ) ，它需要两个参数：
//
//number ：要舍入的数字
//
//roundToInterval ：间隔值
//
//NumberUtilities 类在 ascb.util 包中。
//
//imported ascb.util.NumberUtilities导入
//
//trace(NumberUtilities.round(Math.PI)); // Displays: 3
//
//trace(NumberUtilities.round(Math.PI, .01)); // Displays: 3.14
//
//trace(NumberUtilities.round(Math.PI, .0001)); // Displays: 3.1416
//
//trace(NumberUtilities.round(123.456, 1)); // Displays: 123
//
//trace(NumberUtilities.round(123.456, 6)); // Displays: 126
//
//trace(NumberUtilities.round(123.456, .01)); // Displays: 123.46
