package com.vriche.adrm.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.dao.AnalySumDao;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ListRange;
import com.vriche.adrm.model.ParamObj;
import com.vriche.adrm.service.AnalyseSumManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.TimeUtil;
import com.vriche.adrm.util.UserUtil;
//import com.vriche.adrm.util.ServiceLocator;

public class AnalyseSumManagerImpl extends BaseManager implements AnalyseSumManager {
	
	
	private AnalySumDao dao;
	
//	AnalySumDao analySumDao = ServiceLocator.getAnalySumDao();
	
	public void setAnalySumDao(AnalySumDao dao) {
		this.dao = dao;
	}
	


	 public ParamObj buildParamBy(String strQueryString){
	    	
		    ParamObj paramObj = new ParamObj();
		    
		    String model = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"model"),null));
	        String whereModel = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"whereModel"),null));
	        String orgId =StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"orgId"),null));
	        String loginUser =StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"loginUser"),null));
	        String displayModel =StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"displayModel"),null));


	        String startDate = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value1"),null));
	        String endDate = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value2"),null));
	        String resourceStr = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value3"),null));
	        String userStr = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value4"),null));
	        String customerStr = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value5"),null));
	        String inWeekDates = StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"value6"),null));
	    
	        paramObj.setModel(model);
	        paramObj.setOrgId(orgId);
	        paramObj.setLoginUser(loginUser);
	        paramObj.setWhereModel(whereModel);
	        paramObj.setDisplayModel(displayModel);
	        
	        
	        
	        paramObj.setValue1(startDate);
	        paramObj.setValue2(endDate);
	        paramObj.setValue3(resourceStr);
	        paramObj.setValue4(userStr);
	        paramObj.setValue5(customerStr);
	        paramObj.setValue6(inWeekDates);

	        return paramObj;
	        
	 }
	


	private Map getParamMap(ParamObj paramObj){
		Map mp = new HashMap();
		
//		System.out.println("paramObj<<<<<<<<<!111111111<<<<<<<<<<"+paramObj);

        String orgId = paramObj.getOrgId();
        String loginUser = paramObj.getLoginUser();
        String loginUserId = paramObj.getLoginUserId();
        String whereModel = paramObj.getWhereModel();
        String displayModel= paramObj.getDisplayModel();
        
        String startDate = paramObj.getValue1();
        String endDate = paramObj.getValue2();
        String resourceStr = paramObj.getValue3();
        String userStr = paramObj.getValue4();
        String customerStr = paramObj.getValue5();
        String inWeekDates = paramObj.getValue6();

		mp.put("orgId",orgId);
		mp.put("whereModel",whereModel);
		mp.put("displayModel",displayModel);
		
		
		
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);		
		
		
		 System.out.println("loginUser<<<<<<<<<!111111111<<<<<<<<<<"+loginUser);
		 System.out.println("orgId<<<<<<<<<!111111111<<<<<<<<<<"+orgId);
		 System.out.println("whereModel<<<<<<<<<!111111111<<<<<<<<<<"+whereModel);
		 System.out.println("displayModel<<<<<<<<<!111111111<<<<<<<<<<"+displayModel);
		 
		 System.out.println("startDate<<<<<<<<<!111111111<<<<<<<<<<"+startDate);
		 System.out.println("endDate<<<<<<<<<!111111111<<<<<<<<<<"+endDate);
		 System.out.println("resourceStr<<<<<<<<<!111111111<<<<<<<<<<"+resourceStr);
		 System.out.println("userStr<<<<<<<<<!111111111<<<<<<<<<<"+userStr);
		 System.out.println("customerStr<<<<<<<<<!111111111<<<<<<<<<<"+customerStr);
		 System.out.println("inWeekDates<<<<<<<<<!111111111<<<<<<<<<<"+inWeekDates);
		
    	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
     	} 		
		
    
		
		if(!"".equals(resourceStr) && resourceStr!=null){
			List resourceIdList = new ArrayList();
			CollectionUtils.addAll(resourceIdList,resourceStr.split("_"));
			mp.put("resourceIdList",resourceIdList);
			 System.out.println("resourceIdList<<<<<<<<<!222222222<<<<<<<<<<"+resourceIdList);
		}  		
		
		if(!"".equals(userStr)  && userStr!=null){
			List userIdList = new ArrayList();
			CollectionUtils.addAll(userIdList,userStr.split("_"));
			mp.put("userIdList",userIdList);
			 System.out.println("userIdList<<<<<<<<<!222222222<<<<<<<<<<"+userIdList);
		} else{
			 System.out.println("userIdList<<<<<< userStr <<<!222222222<<<<<<<<<<"+userStr);
			 System.out.println("userIdList<<<<<<< loginUser <<!222222222<<<<<<<<<<"+loginUser);
			List userIdList =  UserUtil.getOwnerUsersList(loginUser,2);
			System.out.println("userIdList<<<<<< size <<<!222222222<<<<<<<<<<"+userIdList.size());
			mp.put("userIdList",userIdList);
		}
		
		if(!"".equals(customerStr)  && customerStr!=null){
			List customerIdList = new ArrayList();
			CollectionUtils.addAll(customerIdList,customerStr.split("_"));
			mp.put("customerIdList",customerIdList);
			 System.out.println("customerIdList<<<<<<<<<!222222222<<<<<<<<<<"+customerIdList);
		}  	
	
		if(!"".equals(inWeekDates) && inWeekDates!=null){
			List inWeekDatesList = new ArrayList();
			DateUtil.getWeekDates(startDate,endDate,inWeekDates,inWeekDatesList);
			mp.put("inWeekDates",inWeekDatesList);
			 System.out.println("inWeekDatesList<<<<<<<<<!222222222<<<<<<<<<<"+inWeekDatesList);
		}  		



		return mp;
	}
	
	
	
//	public ListRange getBranchSumJson(ParamObj paramObj) throws  Exception{
//		ListRange listRange = new ListRange();
//		List data =  (List)getBranchSum(paramObj);
//		int total = data.size();
//		 
//		listRange.setData(data);
//		listRange.setTotalSize(total);
////		listRange.setDataSum("0");
//		return listRange;
//		
//	}
//	public Collection getBranchSum(ParamObj paramObj) throws  Exception{
//	
//		List list = new ArrayList();
//		
//		System.out.println("paramObj<<<<<<<<<!111111111<<<<<<<<<<"+paramObj);
//		String model = paramObj.getModel();
//		boolean isPrint = "print".equals(model) || "excel".equals(model);
//		System.out.println("model<<<<<<<<<!222222222<<<<<<<<<<"+model);
//		
//   	 	Map mp = getParamMap(paramObj);
//
//		        try{
//
////		    		System.out.println("customerAdd.getCustomerId()<<<<<<<<<!111111111<<<<<<<<<<"+customerAdd.getCustomerId());
//		        	
//		        	 list = dao.getBranchSum(mp);
//		        	 
//		     		Iterator it = list.iterator();
//		     		
//		     		 System.out.println("total<<<<<<<<<!33333333<<<<<<<<<<"+list.size());
//		     		 
//		     		double sumValue2 = 0;
//		     		double sumValue3 = 0;
//		     		double sumValue4 = 0;
//		     		 
//		    		while(it.hasNext()){
//		    			FusionChartObject obj = (FusionChartObject)it.next();
//		    			
//		    			String v_2= StringUtil.getNullValue(obj.getValue2(),"0");
//		    			String v_3= StringUtil.getNullValue(obj.getValue3(),"0");
//		    			String v_4= StringUtil.getNullValue(obj.getValue4(),"0");
//
//		    			double v2 = Double.parseDouble(v_2);
//		    			double v3 = Double.parseDouble(v_3);
//		    			double v4 = Double.parseDouble(v_4);
//		    			double v5 = v3 - v4;	
//		    			double v6 = v4/v3;	
//		    			sumValue2 = sumValue2 +v2;
//		    			sumValue3 = sumValue3 +v3;
//		    	
//		    		
//
//		    			obj.setLable(StringUtil.getNullValue(obj.getLable(),""));
//		    			obj.setLable(StringUtil.getNullValue(obj.getValue1(),""));
//		    			
//		    			if(isPrint){
//		    				obj.setValue2(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(obj.getValue2()).longValue()*1000)));
//		    			}
//		    			
//		    			obj.setValue4(""+StringUtil.doubleFormat2(new Double(v4)));
//		    			obj.setValue5(""+v5);
//		    			obj.setValue6(StringUtil.doubleFormat2(new Double(v6)));
//		    		}	
//		    		
//		    		
//		    		if(isPrint  && list.size() >0){
//		    			FusionChartObject obj = new FusionChartObject();
//		    			obj.setLable("");
//		    			obj.setValue1("合计:");
//		    			obj.setValue2(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(""+sumValue2).longValue()*1000)));
//		    			obj.setValue3(""+sumValue3);
//		    			obj.setValue4(""+sumValue4);
//		    			obj.setValue5(""+(sumValue3 - sumValue4));
//		    			obj.setValue6(StringUtil.persentFormat(sumValue4,sumValue3));
//		    			list.add(obj);
//		    		}
//		    		
//
//		        }
//		        catch(Exception ex){
//		        	throw new Exception("failure:true,msg:"+ ex.getMessage() +"");
//		        }
//
//		return list;
//	}
//	
//	private Map getOneChannelRate(Map mp1,Map mp2){
//		Map mp = new HashMap();
//		
//		Iterator it = mp1.keySet().iterator();
//		Double sum3 = (Double) mp2.get("sum3");
//		Double sum5 = (Double) mp2.get("sum5");
//		if(sum3.doubleValue() == 0) sum3 = new Double(1);
//		while(it.hasNext()){
//			String key = (String)it.next();
//			String key2 = key+"_in";
//			Double channelSum3 = (Double)mp1.get(key);
//			Double channelSum5 = (Double)mp1.get(key2);
//			mp.put(key,new Double(channelSum3.doubleValue()/sum3.doubleValue()));	
//			mp.put(key2,new Double(channelSum5.doubleValue()/sum5.doubleValue()));	
//		}
//		return mp;
//	}
//	

//	public Collection getChannelSum(ParamObj paramObj) throws Exception {
//		List list = new ArrayList();
//		String model = paramObj.getModel();
//		
//   	 	Map mp = getParamMap(paramObj);
//
//		        try{
//
////		    		System.out.println("customerAdd.getCustomerId()<<<<<<<<<!111111111<<<<<<<<<<"+customerAdd.getCustomerId());
//		        	
//		        	 list = dao.getChannelSum(mp);
//		        	 
////		        	 Map channelMap1 = getOneChannelReplay(list,1);
//		        	 Map channelMap2 = getOneChannelReplay(list,2);
////		        	 Map channelMap3 = getOneChannelRate(channelMap1,channelMap2);
//		        	 
//		     		Iterator it = list.iterator();
//		     		
//		     		 System.out.println("total<<<<<<<<<!33333333<<<<<<<<<<"+list.size());
//		     		 
//		     		double sumValue1 = 0;
//		     		double sumValue2 = 0;
//		     		double sumValue3 = 0;
//		     		double rateValue4 = 0;
//		     		double rateValue7 = 0;
//		     		 
//		    		while(it.hasNext()){
//		    			FusionChartObject obj = (FusionChartObject)it.next();
//		    			String v_1= StringUtil.getNullValue(obj.getValue1(),"");
//		    			String v_2= StringUtil.getNullValue(obj.getValue2(),"0");
//		    			String v_3= StringUtil.getNullValue(obj.getValue3(),"0");
////		    			String v_4= StringUtil.getNullValue(obj.getValue3(),"0");
//		    			String v_5= StringUtil.getNullValue(obj.getValue5(),"0");
////		    			String v_6= StringUtil.getNullValue(obj.getValue3(),"0");
////		    			String v_7= StringUtil.getNullValue(obj.getValue3(),"0");
//
//		    			Double channelSum = (Double)channelMap2.get(obj.getLable());
//		    			double v2 = Double.parseDouble(v_2);
//		    			double v3 = Double.parseDouble(v_3);
//		    			double v4 = (new Double(v3/channelSum.doubleValue())).doubleValue();
//		    			double v5 = Double.parseDouble(v_5);
//		    			double v6 = v3 - v5;
//		    			double v7 = Double.parseDouble(String.valueOf(v5/v3));
//		    			
//		    			String key = obj.getLable();
//		    			String key2 = key+"_in";
////		    			double v11 = ((Double)channelMap3.get(key)).doubleValue();
////		    			double v12 = ((Double)channelMap3.get(key2)).doubleValue();
//		    			
//		    	
////		    			sumValue1 = sumValue1 +v1;
//		    			sumValue2 = sumValue2 +v2;
//		    	
//		    		
//
//		    			obj.setLable(StringUtil.getNullValue(obj.getLable(),""));
//		    			obj.setValue4(""+v4);
//		    			obj.setValue6(""+v6);
//		    			obj.setValue7(""+v7);
//		    			
////		    			obj.setValue11(""+v11);
////		    			obj.setValue12(""+v12);
////		    			if(!"chart".equals(model)){
////		    				obj.setValue4(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(obj.getValue4()).longValue()*1000)));
////		    				obj.setValue7(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(obj.getValue7()).longValue()*1000)));
////		    			}
//		    			
////		    			obj.setValue3(""+StringUtil.doubleFormat2(new Double(v3)));
////		    			obj.setValue4(""+v4);
////		    			obj.setValue5(StringUtil.doubleFormat2(new Double(v5)));
////		    			if(model != null && !"".equals("chart")   && v5 == 0){
////		    				obj.setValue5("0%");
////		    			}
////		    			obj.setValue5(StringUtil.persentFormat(v3,v2));
//		    			
////		    			System.out.println("v5<<<<<<<<<!111111111<<<<<<<<<<"+obj.getValue2());
//		    		}	
//		    		
//		    		
////		    		if(model != null && !"chart".equals(model)  && list.size() >0){
////		    			FusionChartObject obj = new FusionChartObject();
////		    			obj.setLable("合计:");
//////		    			System.out.println("v5<<<<<<<<<!sumValue1<<<<<<<<<<"+sumValue1);
////		    			obj.setValue1(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(""+sumValue1).longValue()*1000)));
////		    			obj.setValue2(""+sumValue2);
////		    			obj.setValue3(""+sumValue3);
////		    			obj.setValue4(""+(sumValue2 - sumValue3));
////		    			obj.setValue5(StringUtil.persentFormat(sumValue3,sumValue2));
////		    			list.add(obj);
////		    		}
//		    		
//
//		        }
//		        catch(Exception ex){
//		        	throw new Exception("failure:true,msg:55555555");
//		        }
//
//		return list;
//	}
//
//
//
//
//
//	public ListRange getChannelSumJson(ParamObj paramObj) throws Exception {
//		ListRange listRange = new ListRange();
//		List data =  (List)getChannelSum(paramObj);
//		int total = data.size(); 
//		listRange.setData(data);
//		listRange.setTotalSize(total);
//		return listRange;
//	}	
//	
//	
	
	
	
	
	
	
	

	
	private Map getOneChannelReplay(List ls,int i){
	Map mp = new HashMap();
	Iterator it = ls.iterator();
	double sumPay = 0;
	double sumIn = 0;
	
	while(it.hasNext()){
		FusionChartObject obj = (FusionChartObject)it.next();
		String key_channel = StringUtil.getNullValue(obj.getLable(),"");
		String v_3= StringUtil.getNullValue(obj.getValue3(),"0");
		String v_5= StringUtil.getNullValue(obj.getValue4(),"0");
		double v3 = Double.parseDouble(v_3);
		double v5 = Double.parseDouble(v_5);
		
		if(i ==1){
			sumPay = sumPay + v3;
			sumIn = sumIn + v5;
		}else{
	
			if(mp.containsKey(key_channel)){
				double k = ((Double)mp.get(key_channel)).doubleValue();
				double y = ((Double)mp.get(key_channel+"_in")).doubleValue();
				mp.put(key_channel,new Double(k + v3));
				mp.put(key_channel+"_in",new Double(y + v5));
			}else{
				mp.put(key_channel,new Double(v3));
				mp.put(key_channel+"_in",new Double(v5));
			}				
			
		}
	}
	if(i ==1){
		mp.put("sum3",new Double(sumPay));
		mp.put("sum5",new Double(sumIn));
		mp.put("sum6",new Double(sumPay-sumIn));
	}

	return mp;
}
	
	public Collection getStatisticSum0(ParamObj paramObj) throws Exception {
		List list = new ArrayList();
		String model = paramObj.getModel();
		boolean isPrint = "print".equals(model) || "excel".equals(model);
   	 	Map mp = getParamMap(paramObj);

		        try{


		        	 list = dao.getStatisticSum(mp);
		        	 
		        	 Map channelMap1 = getOneChannelReplay(list,1);
//		        	 Map channelMap2 = getOneChannelReplay(list,2);
//		        	 Map channelMap3 = getOneChannelRate(channelMap1,channelMap2);
		        	 
		     		Iterator it = list.iterator();
//		     		 StringUtil.getNullValue(channelMap1.get("sum3"),"0");
		     		Double total_pay_sumPay =Double.valueOf(StringUtil.getNullValue(channelMap1.get("sum3"),"0"));
		     		Double total_in_sumPay =Double.valueOf(StringUtil.getNullValue(channelMap1.get("sum5"),"0"));
		     		System.out.println("total<<<<<<<<<!33333333<<<<<<<<<<"+StringUtil.doubleFormat2(total_pay_sumPay));
		     		 System.out.println("size<<<<<<<<<!33333333<<<<<<<<<<"+list.size());
		     		 
		     	
		     		double sumValue2 = 0;
		     		double sumValue3 = 0;
		     		double sumValue4 = 0;
		     		double sumValue5 = 0;
		     		
		     		double rateValue4 = 0;
		     		double rateValue7 = 0;
		     		 
		    		while(it.hasNext()){
		    			FusionChartObject obj = (FusionChartObject)it.next();

		    			String v_2= StringUtil.getNullValue(obj.getValue2(),"0");
		    			String v_3= StringUtil.getNullValue(obj.getValue3(),"0");
		    			String v_5= StringUtil.getNullValue(obj.getValue4(),"0");


//		    			Double channelPaySum = (Double)channelMap2.get(obj.getLable());
//		    			Double channelInSum = (Double)channelMap2.get(obj.getLable()+"_in");
		    			
//		    			System.out.println("channelSum<<<<<<<<<!33333333<<<<<<<<<<"+StringUtil.doubleFormat2(channelPaySum));
		    			
		    			double v2 = Double.parseDouble(v_2);//时间
		    			double v3 = Double.parseDouble(v_3);//应收
		    			double v4 = (new Double(v3/total_pay_sumPay.doubleValue())).doubleValue();//应收比率
		    			double v5 = Double.parseDouble(v_5);//实收
		    			double v6 = v3 - v5;                //欠款
		    			double v7 = Double.parseDouble(String.valueOf(v5/v3)); //到款率
		    			
//		    			String key = obj.getLable();
//		    			String key2 = key+"_in";
//		    			double v11 = ((Double)channelMap3.get(key)).doubleValue();
//		    			double v12 = ((Double)channelMap3.get(key2)).doubleValue();

		    			
		    			sumValue2 = sumValue2 +v2;
		    			sumValue3 = sumValue3 +v3;
		    			sumValue5 = sumValue5 +v5;

		    			obj.setLable(StringUtil.getNullValue(obj.getLable(),""));
		    			obj.setValue1(StringUtil.getNullValue(obj.getValue1(),""));
		    			obj.setValue6(""+v6); //欠款
		    			if(isPrint){
		    				obj.setValue2(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(obj.getValue2()).longValue()*1000)));
		    				obj.setValue3(""+StringUtil.doubleFormat3(new Double(v3)));
		    				obj.setValue4(StringUtil.persentFormat(v3,total_pay_sumPay.doubleValue()));
		    				obj.setValue5(""+StringUtil.doubleFormat3(new Double(v5)));
		    				obj.setValue6(""+StringUtil.doubleFormat3(new Double(v6)));
			    			obj.setValue7(StringUtil.persentFormat(v5,v3));
			    			
		    			}else{
			    			obj.setValue4(""+v4); //应收比率
			    			obj.setValue7(""+v7);//到款率
		    			}

		    			obj.setValue10(""+v3);//频道收入
		    			obj.setValue11(""+total_pay_sumPay.doubleValue());//频道收入
		    			obj.setValue12(""+v5);//频道收入
		    			obj.setValue13(""+total_in_sumPay.doubleValue());//频道收入
//		    			System.out.println("v5<<<<<<<<<!111111111<<<<<<<<<<"+obj.getValue2());
		    		}	
		    		
		    		
		    		if(isPrint  && list.size() >0){
		    			FusionChartObject obj = new FusionChartObject();
		    			obj.setLable("");
		    			obj.setValue1("合计:");
		    			obj.setValue2(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(""+sumValue2).longValue()*1000)));
//		    			obj.setValue2(TimeUtil.format2HourMiSe((new Long(Float.valueOf(""+sumValue2).longValue()*1000)).longValue()));

		    			obj.setValue3(""+sumValue3);
		    			obj.setValue4(""+sumValue4);
		    			obj.setValue5(""+sumValue5);
		    			obj.setValue6(""+(sumValue3 - sumValue4));
		    			obj.setValue7(StringUtil.persentFormat(sumValue5,sumValue3));
		    			list.add(obj);
		    		}
		    		

		        }
		        catch(Exception ex){
		        	throw new Exception("failure:true,msg:"+ ex.getMessage() +"");
		        }

		return list;
	}

	public Collection getStatisticSum(ParamObj paramObj) throws Exception {
		
		 String displayModel= paramObj.getDisplayModel();
		 boolean isSumCount = "1".equals(displayModel);

//		 if("1".equals(displayModel)){
//			 return(List)getStatisticSum0(paramObj);
//		 }
		
		
		List list = new ArrayList();
		String model = paramObj.getModel();
		boolean isPrint = "print".equals(model) || "excel".equals(model);
		boolean isChart = "chart".equals(model);
   	 	Map mp = getParamMap(paramObj);

		        try{

//		    		System.out.println("customerAdd.getCustomerId()<<<<<<<<<!111111111<<<<<<<<<<"+customerAdd.getCustomerId());
		        	
		        	 list = dao.getStatisticSum(mp);
		        	 
		        	 Map channelMap1 = getOneChannelReplay(list,1);
		        	 Map channelMap2 = getOneChannelReplay(list,2);
//		        	 Map channelMap3 = getOneChannelRate(channelMap1,channelMap2);
		        	 
		     		Iterator it = list.iterator();
//		     		 StringUtil.getNullValue(channelMap1.get("sum3"),"0");
		     		Double total_pay_sumPay =Double.valueOf(StringUtil.getNullValue(channelMap1.get("sum3"),"0"));
		     		Double total_in_sumPay =Double.valueOf(StringUtil.getNullValue(channelMap1.get("sum5"),"0"));
//		     		System.out.println("total<<<<<<<<<!33333333<<<<<<<<<<"+StringUtil.doubleFormat2(total_pay_sumPay));
//		     		 System.out.println("size<<<<<<<<<!33333333<<<<<<<<<<"+list.size());
		     		 
		     	
		     		double sumValue2 = 0;
		     		double sumValue3 = 0;
		     		double sumValue4 = 0;
		     		double sumValue5 = 0;
		     		
		     		double rateValue4 = 0;
		     		double rateValue7 = 0;
		     		 
		    		while(it.hasNext()){
		    			FusionChartObject obj = (FusionChartObject)it.next();

		    			String v_2= StringUtil.getNullValue(obj.getValue2(),"0");
		    			String v_3= StringUtil.getNullValue(obj.getValue3(),"0");
		    			String v_5= StringUtil.getNullValue(obj.getValue4(),"0");


		    			Double channelPaySum = isSumCount? total_pay_sumPay:(Double)channelMap2.get(obj.getLable());
		    			Double channelInSum = isSumCount?total_in_sumPay:(Double)channelMap2.get(obj.getLable()+"_in");
//		    			if(channelInSum == null) channelInSum = new Double(1);
		    			
		    			 System.out.println("size<<<<<<<<<!obj.getLable()<<<<<<<<<<"+obj.getLable());
		    			System.out.println("channelSum<<<<<<<<<!channelPaySum<<<<<<<<<<"+StringUtil.doubleFormat2(channelPaySum));
		    			System.out.println("channelSum<<<<<<<<<!channelInSum<<<<<<<<<<"+StringUtil.doubleFormat2(channelInSum));
		    		
		    			 
		    			double v2 = Double.parseDouble(v_2);//时间
		    			double v3 = Double.parseDouble(v_3);//应收
		    			double v4 = (new Double(v3/channelPaySum.doubleValue())).doubleValue();//应收比率
		    			double v5 = Double.parseDouble(v_5);//实收
		    			double v6 = v3 - v5;                //欠款
		    			double v7 = Double.parseDouble(String.valueOf(v5/v3)); //到款率
//		    			double v7 = (new Double(v5/channelInSum.doubleValue())).doubleValue();//应收比率
		    			
//		    			String key = obj.getLable();
//		    			String key2 = key+"_in"; 
//		    			double v11 = ((Double)channelMap3.get(key)).doubleValue();
//		    			double v12 = ((Double)channelMap3.get(key2)).doubleValue();

		    			
		    			sumValue2 = sumValue2 +v2;
		    			sumValue3 = sumValue3 +v3;
		    			sumValue5 = sumValue5 +v5;
		    			
		    			obj.setLable(StringUtil.getNullValue(obj.getLable(),""));
//                        if(!isSumCount && isChart) obj.setLable(StringUtil.getNullValue(obj.getValue1(),""));
		    			obj.setValue1(StringUtil.getNullValue(obj.getValue1(),""));
		    			
		    			obj.setValue6(""+v6); //欠款
		    			if(isPrint){
		    				obj.setValue2(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(obj.getValue2()).longValue()*1000)));
		    				obj.setValue3(""+StringUtil.doubleFormat2(new Double(v3)));
		    				obj.setValue4(StringUtil.persentFormat(v3,channelPaySum.doubleValue()));
		    				obj.setValue5(""+StringUtil.doubleFormat2(new Double(v5)));
		    				obj.setValue6(""+StringUtil.doubleFormat2(new Double(v6)));
			    			obj.setValue7(StringUtil.persentFormat(v5,v3));
//			    			obj.setValue7(StringUtil.persentFormat(v5,channelInSum.doubleValue()));
			    			
		    			}else{
			    			obj.setValue4(""+v4); //应收比率
//			    			obj.setValue5(""+StringUtil.doubleFormat2(new Double(v5)));  //应收
			    			obj.setValue5(""+v5);  //应收
			    			obj.setValue7(""+v7);//到款率
//			    			System.out.println("v5<<<<<<<<<!111111111<<uuuuu<<<<<<<<"+v5);
		    			}

		    			obj.setValue10(""+channelPaySum.doubleValue());//频道收入
		    			obj.setValue11(""+total_pay_sumPay.doubleValue());//频道收入
		    			obj.setValue12(""+channelInSum.doubleValue());//频道收入
		    			obj.setValue13(""+total_in_sumPay.doubleValue());//频道收入
//		    			System.out.println("v5<<<<<<<<<!111111111<<<<<<<<<<"+obj.getValue2());
		    		}	
		    		
		    		
		    		if(isPrint  && list.size() >0){
		    			FusionChartObject obj = new FusionChartObject();
		    			obj.setLable("");
		    			obj.setValue1("合计:");
		    			obj.setValue2(DateUtil.formatLongToTimeStr(new Long(Float.valueOf(""+sumValue2).longValue()*1000)));
		    			obj.setValue3(""+sumValue3);
		    			obj.setValue4(""+sumValue4);
		    			obj.setValue5(""+sumValue5);
		    			obj.setValue6(""+(sumValue3 - sumValue4));
		    			obj.setValue7(StringUtil.persentFormat(sumValue5,sumValue3));
		    			list.add(obj);
		    		}
		    		

		        }
		        catch(Exception ex){
		        	throw new Exception("failure:true,msg:"+ ex.getMessage() +"");
		        }

		return list;
	}

	
	public ListRange getStatisticSumJson(ParamObj paramObj) throws Exception {
		ListRange listRange = new ListRange();
		List data =  (List)this.getStatisticSum(paramObj);
		int total = data.size(); 
		listRange.setData(data);
		listRange.setTotalSize(total);
		return listRange;
	}
	
	public Collection getCollections(String queryString, String type) throws  Exception{
		ParamObj paramObj =  this.buildParamBy(queryString);
		
		List valuecoll = new ArrayList();
		try {
			Collection ls =  this.getStatisticSum(paramObj);
			valuecoll.addAll(ls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valuecoll;
	}
	public FusionChartObject[] getChartObjs(ParamObj paramObj) {
	    int i = 0;
	    Map mp = getParamMap(paramObj);
	    
	
		 String displayModel= paramObj.getDisplayModel();
		 boolean isSumCount = "1".equals(displayModel);
	    List all = dao.getStatisticSum(mp);
	   
	    FusionChartObject fusionChartObjects[] =  new FusionChartObject[all.size()];
//	    all.toArray(fusionChartObjects);
//	    fusionChartObjects = (FusionChartObject[])all.toArray();
	    
		for(Iterator it = all.iterator();it.hasNext();){
//			CustomerAnalyzeColl customerColl =(CustomerAnalyzeColl) it.next();
			FusionChartObject fusionChartObject = (FusionChartObject)it.next();
			fusionChartObject.setValue3(StringUtil.doubleFormat2(new Double(StringUtil.getNullValue(fusionChartObject.getValue3(),"0"))));
			fusionChartObject.setValue5(StringUtil.doubleFormat2(new Double(StringUtil.getNullValue(fusionChartObject.getValue5(),"0"))));
			fusionChartObject.setValue6(StringUtil.doubleFormat2(new Double(StringUtil.getNullValue(fusionChartObject.getValue6(),"0"))));
			
			
//			System.out.println("v5<<<<<<<<<!fusionChartObject.getValue4<<<<<<<<<<"+fusionChartObject.getValue4());
			
			if(!isSumCount) fusionChartObject.setLable(fusionChartObject.getValue1());
			fusionChartObjects[i++] = fusionChartObject;
//			if(i == all.size()-1) break;
		}
	return fusionChartObjects;
}	
	






	
	

	public void setDao(Dao dao) {
		// TODO Auto-generated method stub

	}

	public List getObjects(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveObject(Object o) {
		// TODO Auto-generated method stub

	}

	public void removeObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub

	}










}
