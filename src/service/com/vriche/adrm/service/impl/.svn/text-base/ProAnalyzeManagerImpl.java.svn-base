/**
 * 
 */
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.dao.ProAnalyzeDao;
import com.vriche.adrm.dao.ProExpenseProgramDao;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ParamClass;
import com.vriche.adrm.model.ProExpenseProgram;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.service.ProAnalyzeManager;
import com.vriche.adrm.service.ProProgramManager;
import com.vriche.adrm.service.ProPublishPlanManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.ProAnalyzeUtil;
import com.vriche.adrm.util.StringUtil;

public class ProAnalyzeManagerImpl extends BaseManager implements ProAnalyzeManager {
	private ProAnalyzeDao dao;
	private ProExpenseProgramDao proExpenseProgramDao;
	private ProProgramManager proProgramManager;
	private ProPublishPlanManager proPublishPlanManager;
	public void setProAnalyzeDao(ProAnalyzeDao dao) {
        this.dao = dao;
    }

	public void setProExpenseProgramDao(ProExpenseProgramDao proExpenseProgramDao) {
		this.proExpenseProgramDao = proExpenseProgramDao;
	}

	public void setProProgramManager(ProProgramManager proProgramManager) {
		this.proProgramManager = proProgramManager;
	}

	public void setProPublishPlanManager(ProPublishPlanManager proPublishPlanManager) {
		this.proPublishPlanManager = proPublishPlanManager;
	}
	
	public String getMoneyByProgramId(String programId){
		
		//通过节目id求得宣传费用，并把结果放到以节目id为键的Map(expenseMap)中，以便后面插入到List中。
		Map expenseMap=new HashMap();	
		ProExpenseProgram proExp=new ProExpenseProgram();
		proExp.setProgramId(new Long(programId));		
		List expenseList=proExpenseProgramDao.getProExpenseMoney(proExp);
		for(Iterator it = expenseList.iterator();it.hasNext();){
			ProExpenseProgram obj= (ProExpenseProgram)it.next();
			Double expenseMoney = obj.getExpenseMoney();
			expenseMap.put(programId,expenseMoney);
		}
//		通过节目id求得采购费用，并把结果放到以节目id为键的Map(costMap)中，以便后面插入到List中。
		Map costMap = new HashMap();
		ParamClass paramClass = new ParamClass();
		paramClass.setId(programId);
		paramClass.setOrderTypeId(new Long(1));		
		List costList = dao.getProCostAnalyzes(paramClass);
		for(Iterator cost = costList.iterator();cost.hasNext();){
			ParamClass objCost= (ParamClass)cost.next();
			Double costMoney = objCost.getPayMoney();
			costMap.put(programId,costMoney);
		}
//		通过节目id求得销售费用，并把结果放到以节目id为键的Map(sellMap)中，以便后面插入到List中。
		Map sellMap = new HashMap();
		paramClass.setOrderTypeId(new Long(2));		
		List sellList = dao.getProCostAnalyzes(paramClass);
		for(Iterator sell = sellList.iterator();sell.hasNext();){
			ParamClass objsell= (ParamClass)sell.next();
			Double sellMoney = objsell.getPayMoney();
			sellMap.put(programId,sellMoney);
		}
//		通过节目id求得广告费用，并把结果放到以节目id为键的Map()中，以便后面插入到List中。		
		double adverMoney=dao.getCarrierMoneyByProgramId(paramClass);
//		通过节目id求得广告费用，并把结果放到以节目id为键的Map(audienceMap)中，以便后面插入到List中。	
		Map audienceMap = new HashMap();
		paramClass.setOrderCode("2") ;
		List audienceList = dao.getProAudienceAnalyzes(paramClass);
		for(Iterator aud = audienceList.iterator();aud.hasNext();){
			ParamClass objAudience= (ParamClass)aud.next();
			String audienceRat = objAudience.getAudienceRat();
			audienceMap.put(programId,audienceRat);
		}
		ProProgram program=proProgramManager.getProProgram(programId);
		String programName=program.getProName();
		String audience=(String)(audienceMap.get(programId)==null?"":audienceMap.get(programId));
		Double expenseMoney=expenseMap.get(programId)==null?new Double(0):(Double)expenseMap.get(programId);
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		int i = 1;
			sb.append("<row  id=\""+ i++  +"\"" +">");
			sb.append("<cell><![CDATA["+ programName  +"]]></cell>");
			sb.append("<cell><![CDATA["+ expenseMoney  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2((Double)costMap.get(programId))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2((Double)sellMap.get(programId))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ adverMoney  +"]]></cell>");
			sb.append("<cell><![CDATA["+ audience  +"]]></cell>");
			sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
			sb.append("</row>");		
		sb.append("</rows>");
		return sb.toString();
	}
	//节目成本分析
	public String getCostByProgramName(ParamClass paramClass,String pageIndex, String pageSize) {
		paramClass.setOrderTypeId(new Long(1)) ;

		List ls = dao.getProCostAnalyzeList(paramClass,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		return ProAnalyzeUtil.makeProCostAnalyzeGridXML(ls);
	}
	public String getProCostAnalyzeCount(ParamClass paramClass) {
		paramClass.setOrderTypeId(new Long(1)) ;
		return dao.getProCostAnalyzeCount(paramClass).toString() ;
	}
	public List getProCostAnalyzes(ParamClass paramClass) {
		paramClass.setOrderTypeId(new Long(1)) ;
		return dao.getProCostAnalyzes(paramClass);
	}
	//节目收视分析
	public String getProAudienceAnalyzeList(ParamClass paramClass) {
		String type = paramClass.getOrderCode();
		List ls = dao.getProAudienceAnalyzes(paramClass);
		List all = getAudienceAnalyzeList(paramClass,ls);
		Map mp = getAudienceAnalyzeMap(all);
		Map map = getCarrAudienceRatSum1(all);
		mp.put("mapCarrier",map);
		mp.put("type",type);
		return ProAnalyzeUtil.makeProAudiemceAnalyzeGridXML(mp);
	}
	public List getAudienceAnalyzeList(ParamClass paramClass,List ls){
		String type = paramClass.getOrderCode();
		String month = null;
		for(Iterator it = ls.iterator();it.hasNext();){
			ParamClass obj = (ParamClass)it.next();
			String audienceDate = obj.getAudienceDate().toString() ;
			month = getMonth(obj,audienceDate);

			if(type.equals("1")){
				obj.setStartDate(month+"月") ;
			}else{
				obj.setStartDate(audienceDate);
			}
		}
		return  ls;
	}
	private Map getCarrAudienceRatSum1(List ls){
		Map map = new HashMap();
		Map mapCarrierName = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			ParamClass paramClass = (ParamClass)it.next();
			String programName = paramClass.getProgramName() ;
			String carrId = paramClass.getCarrierId() ;
			String key =programName+"%%"+carrId;
			
			//求每个频道的合计
			getCarrAudienceRatSum(paramClass,mapCarrierName,key);
			
			if(map.containsKey(key)){
				List ls2 = (List)map.get(key);
				ls2.add(paramClass);
				map.put(key,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(paramClass);
				map.put(key,ls2);
			}
		}
		map.put("mapCarrierName",mapCarrierName);
		return map;
	}
	private Map getAudienceAnalyzeMap(List ls){
		Map map = new HashMap();
		Map mapProgramName = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			ParamClass paramClass = (ParamClass)it.next();
			String programName = paramClass.getProgramName() ;
			
			//求每个节目的合计
			getProAudienceRatSum(paramClass,mapProgramName);
			
			if(map.containsKey(programName)){
				List ls2 = (List)map.get(programName);
				ls2.add(paramClass);
				map.put(programName,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(paramClass);
				map.put(programName,ls2);
			}
		}
		map.put("mapProgramName",mapProgramName);
		return map;
	}
	private void getCarrAudienceRatSum(ParamClass paramClass,Map mapCarrierName,String key){
		Object obj  = mapCarrierName.get(key);
		if(obj == null) {
			ParamClass paraClass =  new ParamClass();
			paraClass.setAudienceRat(paramClass.getAudienceRat()) ;
			mapCarrierName.put(key,paraClass);
		}else{
			ParamClass paraClass = (ParamClass)obj;
			double audienceRat = new Double(paraClass.getAudienceRat()).doubleValue();
			double audienceRatNew = new Double(paramClass.getAudienceRat()).doubleValue();
			paraClass.setAudienceRat(new Double(audienceRat+audienceRatNew).toString()); ;
			mapCarrierName.put(key,paraClass);
		}
	}
	private void getProAudienceRatSum(ParamClass paramClass,Map mapProgramName){
		String key = paramClass.getProgramName();
		Object obj  = mapProgramName.get(key);
		if(obj == null) {
			ParamClass paraClass =  new ParamClass();
			paraClass.setAudienceRat(paramClass.getAudienceRat()) ;
			mapProgramName.put(key,paraClass);
		}else{
			ParamClass paraClass = (ParamClass)obj;
			double audienceRat = new Double(paraClass.getAudienceRat()).doubleValue();
			double audienceRatNew = new Double(paramClass.getAudienceRat()).doubleValue();
			paraClass.setAudienceRat(new Double(audienceRat+audienceRatNew).toString()); ;
			mapProgramName.put(key,paraClass);
		}
	}
	private String getMonth(ParamClass paramClass,String audienceDate){
		String month = null;
		if(audienceDate.charAt(4)=='0'){
			month = audienceDate.substring(5,6);
		}else{
			month = audienceDate.substring(4,6);
		}
		return month ;
	}
	public List getProAudienceAnalyzes(ParamClass paramClass) {
		List ls = dao.getProAudienceAnalyzes(paramClass);
		return getAudienceAnalyzeList(paramClass,ls);
	}
	
//	节目收入分析
	public String getProIncomeAnalyzeList1(ParamClass paramClass, String pageIndex, String pageSize) {
		List all =getTotalMoneyList1(paramClass,pageIndex,pageSize);
		return ProAnalyzeUtil.makeProgramIncomeAnalyzeGridXML(all);
	}
	public List getTotalMoneyList1(ParamClass paramClass,String pageIndex, String pageSize){
		List all = new ArrayList();
		Map firstMoneyMap = new HashMap();
		Map secondMoneyMap = new HashMap();
		paramClass.setOrderTypeId(new Long(2));
		
			List secondMoneyList = dao.getProCostAnalyzes(paramClass) ;
			
			firstMoneyMap = getCarrierMemo(paramClass);
			String year = paramClass.getStartDate().substring(0,4);
			paramClass.setMemo(year);
			List proNameList = dao.getProProgramNameList(paramClass,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
			if(proNameList.size()!=0){
				for(Iterator two = secondMoneyList.iterator();two.hasNext();){
					ParamClass obj= (ParamClass)two.next();
					String programName = obj.getProgramName() ;
					Double secMoney = obj.getPayMoney() ;
					secondMoneyMap.put(programName,secMoney);
				}
			}
			
			for(Iterator two = proNameList.iterator();two.hasNext();){
				ParamClass obj= (ParamClass)two.next();
				String programName = obj.getProgramName() ;
				Double firstMoney = (Double)firstMoneyMap.get(programName);
				firstMoney = firstMoney == null?new Double(0):firstMoney;
				
				Double secondMoney = (Double)secondMoneyMap.get(programName);
				secondMoney = secondMoney == null?new Double(0):secondMoney;
				
				double totalMoney = firstMoney.doubleValue() + secondMoney.doubleValue() ;
				ParamClass paraClass = new ParamClass();
				paraClass.setProgramName(programName);
				paraClass.setPayMoney(secondMoney);
				paraClass.setDayRelIncome(firstMoney);
				paraClass.setTotalIncome(new Double(totalMoney));
				all.add(paraClass) ;
			}
		return all;
	}
	public String getProIncomeAnalyzeCount(ParamClass paramClass) {
		return dao.getProProgramNameCount(paramClass).toString() ;
	}
	
	public String getProIncomeAnalyzeList(ParamClass paramClass) {
		List all =getTotalMoneyList(paramClass);
		return ProAnalyzeUtil.makeProgramIncomeAnalyzeGridXML(all);
	}
	
	public List getTotalMoneyList(ParamClass paramClass){
		List all = new ArrayList();
		Map firstMoneyMap = new HashMap();
		Map secondMoneyMap = new HashMap();
		paramClass.setOrderTypeId(new Long(2));
		
			List secondMoneyList = dao.getProCostAnalyzes(paramClass) ;
			
			firstMoneyMap = getCarrierMemo(paramClass);
			
			String year = paramClass.getStartDate()==""?null:paramClass.getStartDate().substring(0,4);

			paramClass.setMemo(year);
			List proNameList = dao.getProProgramNameList(paramClass);
			if(proNameList.size()!=0){
				for(Iterator two = secondMoneyList.iterator();two.hasNext();){
					ParamClass obj= (ParamClass)two.next();
					String programName = obj.getProgramName() ;
					Double secMoney = obj.getPayMoney() ;
					secondMoneyMap.put(programName,secMoney);
				}
			}
			
				for(Iterator two = proNameList.iterator();two.hasNext();){
					ParamClass obj= (ParamClass)two.next();
					String programName = obj.getProgramName() ;
					Double firstMoney = (Double)firstMoneyMap.get(programName);
					firstMoney = firstMoney == null?new Double(0):firstMoney;
					
					Double secondMoney = (Double)secondMoneyMap.get(programName);
					secondMoney = secondMoney == null?new Double(0):secondMoney;
					
					double totalMoney = firstMoney.doubleValue() + secondMoney.doubleValue() ;
					System.out.println("firstMoney<<<<<<<<0000000<<<<<<<<<<"+firstMoney);
					ParamClass paraClass = new ParamClass();
					paraClass.setProgramName(programName);
					paraClass.setPayMoney(secondMoney);
					paraClass.setDayRelIncome(firstMoney);
					paraClass.setTotalIncome(new Double(totalMoney));
					all.add(paraClass) ;
				}
		return all;
	}
//	得到频道和其孩子的字符串
	public String getCarrierChild(ParamClass paramClass){
		StringBuffer sb = new StringBuffer();
		
		List IdList = getCarrierResourcesId(paramClass);
		int i = 0;
		int sum = IdList.size();
			for(Iterator it = IdList.iterator();it.hasNext();){
				ParamClass obj= (ParamClass)it.next();
				String parentId = obj.getTypeId();
				String resourcesId = obj.getId();
				i++;
				if(i==sum){
					sb.append("(ppp.carrier_id = " +parentId+ " and arc.ad_resource_carrier_id =" +resourcesId+")" );
				}else{
					sb.append("(ppp.carrier_id = " +parentId+ " and arc.ad_resource_carrier_id =" +resourcesId+") or " );
				}
				
				
			}
		return sb.toString();
	}
	
	//得到频道下面的 孩子Id
	public List getCarrierResourcesId(ParamClass paramClass){
		Map map = new HashMap();
		List childId = new ArrayList();
		List lsParentId = new ArrayList();
		List ParentIdList = new ArrayList();
		String year=null;
		if(paramClass.getStartDate()!=""){
			year = paramClass.getStartDate().substring(0,4);
		}
		String carrierId = paramClass.getCarrierId();

		if(carrierId==null){
			ParentIdList = dao.getCarrierParentIdList(paramClass);
			for(Iterator it = ParentIdList.iterator();it.hasNext();){
				ParamClass obj= (ParamClass)it.next();
				String parentId = obj.getCarrierId();
				lsParentId.add(parentId);
			}
		}else{
			lsParentId.add(carrierId);
		}
		map.put("year",year);

			if(ParentIdList.size()!=0){
				map.put("lsParentId",lsParentId);
			}else{
				lsParentId.add("-1");
				map.put("lsParentId",lsParentId);
			}
			childId = dao.getResourcesIdByIdList(map);
		return childId;
	}
	//求得了符合条件的一次收入的钱
	public Map getCarrierMemo(ParamClass paramClass){
		Map secondMap = new HashMap();
		Map map = new HashMap();
		Map moneyMap = new HashMap();
		List carrierList = new ArrayList();
		
		String carrierId = paramClass.getCarrierId();
		String startDate = paramClass.getStartDate();
		String endDate = paramClass.getEndDate();
		String proName = paramClass.getProgramName();
		ParamClass paraClass = new ParamClass();
		paraClass.setStartDate(startDate);
		paraClass.setEndDate(endDate);
		paraClass.setProgramName(proName);
		paraClass.setCarrierId(carrierId);
		
		map.put("startDate",startDate);
		map.put("proName",proName);
		map.put("endDate",endDate);
		List carrierIdList = getCarrierResourcesId(paraClass);
		for(Iterator it = carrierIdList.iterator();it.hasNext();){
			ParamClass obj= (ParamClass)it.next();
			String resourcesId = obj.getId();
			carrierList.add(resourcesId);
		}
		if(carrierIdList.size()!=0){
				
				map.put("carrierList",carrierList);
				moneyMap = getCarrierMoney(map);
		}else{
				map.put("carrierList",carrierList);
		}
			//System.out.println("carrierList<<<<<<<<111111111<<<<<<<<<<"+carrierList);
			List ls  = dao.getCarrierMemo(map);
			for(Iterator it = ls.iterator();it.hasNext();){
				ParamClass obj = (ParamClass)it.next() ;
				String key1 = obj.getId()+ obj.getPlanDate();
				String programName = obj.getProgramName();
				String total = obj.getTotal()==null?"0":obj.getTotal() ;
				int startTime = new Integer(obj.getStartTime()).intValue()/1000;
				int endTime = new Integer(obj.getEndTime()).intValue()/1000;
				String memo = obj.getMemo() ;
				int sTime = (new Integer(memo).intValue()) ;

				
				int eTime = sTime + (new Integer(total).intValue()) ;
				if(startTime>eTime || endTime<sTime){
					continue ;
				}else{
					if(startTime>sTime){
						obj.setStartTime(new Integer(startTime).toString()) ;
					}else{
						obj.setStartTime(new Integer(sTime).toString()) ;
					}
					if(endTime<eTime){
						obj.setEndTime(new Integer(endTime).toString()) ;
					}else{
						obj.setEndTime(new Integer(eTime).toString()) ;
					}
				}
				int starTime = new Integer(obj.getStartTime()).intValue();
				int enTime = new Integer(obj.getEndTime()).intValue();
				int second = enTime - starTime ;
				Double sumMoney = null;
				String value = (String)moneyMap.get(key1);
				if(value!=null){
					String[] values = value.split(",");
					Double money = null;
					Double sumTime = null;
					sumTime = new Double(values[0]);
					money = new Double(values[1]);
					if(sumTime.doubleValue()<second){
						 sumMoney = new Double(sumTime.doubleValue() * money.doubleValue());
					}else{

						 sumMoney = new Double(second * money.doubleValue());
					}
				}
				
				sumMoney = sumMoney == null?new Double(0):sumMoney;
				if (secondMap.containsKey(programName)) {
					Double money1 = (Double) secondMap.get(programName);
					money1 = money1 == null?new Double(0):money1;
					Double moneys = new Double(money1.doubleValue()+sumMoney.doubleValue());
					secondMap.put(programName, moneys);
				} else {
					secondMap.put(programName,sumMoney);
				}

			}

		return secondMap ;
	}
	
	//求的是 每个资源段 在每天中 每秒的投放。
	public Map getCarrierMoney(Map map){
		Map moneyMap = new HashMap();
		
		List ls  = dao.getCarrierMoney(map) ;
		
		for(Iterator it = ls.iterator();it.hasNext();){
			ParamClass obj = (ParamClass)it.next() ;
			Double money = obj.getPayMoney()==null?new Double(0):obj.getPayMoney();
			String sumTime = obj.getSumTime()==null?"0":obj.getSumTime();
			String value = sumTime+","+money.toString();
			String key = obj.getId() + obj.getPlanDate();
				moneyMap.put(key,value);
			}
		return moneyMap ;
	}

//	节目成本收入收视分析
	public String getCostIncomeAudienceAnalyzeList(ParamClass paramClass){
		List all= getCostIncomeAudienceList(paramClass);
		return ProAnalyzeUtil.makeCostIncomeAudienceAnalyzeGridXML(all);
	}
	
	private List getCostIncomeAudienceList(ParamClass paramClass){
		List all = new ArrayList();

		Map costMap = new HashMap();
		paramClass.setOrderTypeId(new Long(1)) ;
		List costList = dao.getProCostAnalyzes(paramClass);
		for(Iterator cost = costList.iterator();cost.hasNext();){
			ParamClass objCost= (ParamClass)cost.next();
			String programName = objCost.getProgramName();
			Double costMoney = objCost.getPayMoney();
			costMap.put(programName,costMoney);
		}
	
		Map audienceMap = new HashMap();
		paramClass.setOrderCode("2") ;
		List audienceList = dao.getProAudienceAnalyzes(paramClass);
		for(Iterator aud = audienceList.iterator();aud.hasNext();){
			ParamClass objAudience= (ParamClass)aud.next();
			String programName = objAudience.getProgramName();
			String audienceRat = objAudience.getAudienceRat();
			audienceMap.put(programName,audienceRat);
		}
		
		  List totalMoneyList =getTotalMoneyList(paramClass);
		for(Iterator one = totalMoneyList.iterator();one.hasNext();){
			ParamClass obj= (ParamClass)one.next();
			ParamClass paraClass = new ParamClass();
			String proName = obj.getProgramName();
			Double totalMoney = obj.getTotalIncome();
			Double costMoneyMap = (Double)costMap.get(proName);
			paraClass.setProgramName(proName) ;
			paraClass.setPayMoney(costMoneyMap); //节目的成本
			paraClass.setDayRelIncome(obj.getDayRelIncome());//广告收入
			paraClass.setRelIncome(obj.getPayMoney());  //销售收入
			paraClass.setTotalIncome(totalMoney); //节目总收入
			String audienceRatMap = (String)audienceMap.get(proName);
			paraClass.setAudienceRat(audienceRatMap);
			all.add(paraClass);
		}
		return all;
		}
	public Collection getCollectionsByCostAnalyze(final String queryString,String type) {
		
		String programName = StringUtil.getParamFromUrl(queryString,"programName");
		
		ParamClass paramClass = new ParamClass();
		
		paramClass.setProgramName(programName);
		paramClass.setOrderTypeId(new Long(1)) ;
		
		List ls = dao.getProCostAnalyzes(paramClass);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 2;
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ParamClass obj = (ParamClass)it.next();
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(obj.getProgramName());break;
						case 2:
							fObject.setValue2(StringUtil.doubleFormat2(obj.getPayMoney()));break;
						default :
					}
				}
			}else{
				fObject.setLable(obj.getProgramName());
				fObject.setValue1(StringUtil.doubleFormat2(obj.getPayMoney()));
			}

			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	} 

	public FusionChartObject[] getProgramChartObjsByCostAnalyze(String queryString) {
		String query=StringUtil.getURLDecoderStr(queryString);
		String queryStrings=StringUtil.getURLDecoderStr(query);
		List ls = (List)this.getCollectionsByCostAnalyze(queryStrings,"chart");
		int size = ls.size();
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
		for(int i = 0 ; i<size;i++ ){
			fusionChartObjects[i] =(FusionChartObject)ls.get(i);
		}
		return fusionChartObjects;
	}
	
public Collection getCollectionsByProgramAudienceRate(final String queryString,String type) {

        String programName = StringUtil.getParamFromUrl(queryString,"programName");
        String orderCode=StringUtil.getParamFromUrl(queryString,"typeId");
		String startDate = StringUtil.getParamFromUrl(queryString,"startDate");
		String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
		String startTime = StringUtil.getParamFromUrl(queryString,"startTime");
		String endTime = StringUtil.getParamFromUrl(queryString,"endTime");    
		
		ParamClass paramClass = new ParamClass();
		paramClass.setProgramName(programName);
		paramClass.setOrderCode(orderCode);
		paramClass.setStartDate(startDate);
		paramClass.setEndDate(endDate);
		paramClass.setStartTime(startTime);
		paramClass.setEndTime(endTime);
		
		List ls = getProAudienceAnalyzes(paramClass);
		Map carrName = (Map)ProAnalyzeUtil.getCarrierNameMap();
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 4;
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ParamClass obj = (ParamClass)it.next();
			String carrierName = (String)carrName.get(obj.getCarrierId());
			String date;
			if(orderCode.equals("1")){
				date=obj.getStartDate();
			}else{
				date=DateUtil.SetDateFormat(obj.getStartDate(),"yyyy/MM/dd");
			}
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(obj.getProgramName());break;
						case 2:
							fObject.setValue2(carrierName);break;
						case 3:
							fObject.setValue3(date);break;
						case 4:
							fObject.setValue4(StringUtil.doubleFormat2(new Double(obj.getAudienceRat())));break;
						default :
					}
				}
			}else{
				fObject.setLable(obj.getProgramName()+"-"+carrierName+"-"+date);
				fObject.setValue1(StringUtil.doubleFormat2(new Double(obj.getAudienceRat())));
			}

			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	} 

	public FusionChartObject[] getProgramChartObjsByProgramAudienceRate(String queryString) {
		String query=StringUtil.getURLDecoderStr(queryString);
		String queryStrings=StringUtil.getURLDecoderStr(query);
		List ls = (List)this.getCollectionsByProgramAudienceRate(queryStrings,"chart");
		int size = ls.size();
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
		for(int i = 0 ; i<size;i++ ){
			fusionChartObjects[i] =(FusionChartObject)ls.get(i);
		}
		return fusionChartObjects;
	}

	public Collection getCollectionsByIncome(final String queryString,String type) {

        String programName = StringUtil.getParamFromUrl(queryString,"programName"); 
        String startDate = StringUtil.getParamFromUrl(queryString,"startDate");
        String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
        
		ParamClass paramClass = new ParamClass();
		paramClass.setProgramName(programName);
		paramClass.setStartDate(startDate);
		paramClass.setEndDate(endDate);
		
		List ls = getTotalMoneyList(paramClass);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 4;
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ParamClass obj = (ParamClass)it.next();

			Double secMoney = obj.getPayMoney()==null?new Double(0):obj.getPayMoney();
			Double firMoney = obj.getDayRelIncome()==null?new Double(0):obj.getDayRelIncome();
			Double totalMoney =obj.getTotalIncome()==null?new Double(0):obj.getTotalIncome();;
			
			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(obj.getProgramName());break;
						case 2:
							fObject.setValue2(StringUtil.doubleFormat2(firMoney));break;
						case 3:
							fObject.setValue3(StringUtil.doubleFormat2(secMoney));break;
						case 4:
							fObject.setValue4(StringUtil.doubleFormat2(totalMoney));break;
						default :
					}
				}
			}else{
				fObject.setLable(obj.getProgramName());
				fObject.setValue1(StringUtil.doubleFormat2(firMoney));
				fObject.setValue2(StringUtil.doubleFormat2(secMoney));
				fObject.setValue3(StringUtil.doubleFormat2(totalMoney));
			}

			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	} 

	public FusionChartObject[] getProgramChartObjsByIncome(String queryString) {
		String query=StringUtil.getURLDecoderStr(queryString);
		String queryStrings=StringUtil.getURLDecoderStr(query);
		List ls = (List)this.getCollectionsByIncome(queryStrings,"chart");
		int size = ls.size();
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
		for(int i = 0 ; i<size;i++ ){
			fusionChartObjects[i] =(FusionChartObject)ls.get(i);
		}
		return fusionChartObjects;
	}
	
	public Collection getCollectionsByCostIncomeAudience(final String queryString,String type) {

        String programName = StringUtil.getParamFromUrl(queryString,"programName");
        String startDate = StringUtil.getParamFromUrl(queryString,"startDate");
        String endDate = StringUtil.getParamFromUrl(queryString,"endDate");
        
		ParamClass paramClass = new ParamClass();
		
		paramClass.setProgramName(programName);
		paramClass.setStartDate(startDate);
		paramClass.setEndDate(endDate);
		
		List ls = getCostIncomeAudienceList(paramClass);
		
		Collection coll = new ArrayList();
		List valuecoll = new ArrayList();
		
		int cols = 4;
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			ParamClass obj = (ParamClass)it.next();

			Double costMoney = obj.getPayMoney()==null?new Double(0):obj.getPayMoney();
			Double totalMoney = obj.getTotalIncome()==null?new Double(0):obj.getTotalIncome();
			String audienceRat = obj.getAudienceRat()==null?"0":obj.getAudienceRat();
			
			FusionChartObject fObject = new FusionChartObject();

			if(type.equals("report")){
				for(int i=1;i<cols+1;i++){
					switch(i){
						case 1:
							fObject.setValue1(obj.getProgramName());break;
						case 2:
							fObject.setValue2(StringUtil.doubleFormat2(costMoney));break;
						case 3:
							fObject.setValue3(StringUtil.doubleFormat2(totalMoney));break;
						case 4:
							fObject.setValue4(audienceRat);break;
						default :
					}
				}
			}else{
				fObject.setLable(obj.getProgramName());
				fObject.setValue1(StringUtil.doubleFormat2(costMoney));
				fObject.setValue2(StringUtil.doubleFormat2(totalMoney));
				fObject.setValue3(audienceRat);
			}

			valuecoll.add(fObject);
		}
		
		
		
		CollectionUtils.addAll(coll,valuecoll.iterator());
		
		return coll;	
		
	} 

	public FusionChartObject[] getProgramChartObjsByCostIncomeAudience(String queryString) {
		String query=StringUtil.getURLDecoderStr(queryString);
		String queryStrings=StringUtil.getURLDecoderStr(query);
		List ls = (List)this.getCollectionsByCostIncomeAudience(queryStrings,"chart");
		int size = ls.size();
		FusionChartObject fusionChartObjects[] =  new FusionChartObject[size];
		for(int i = 0 ; i<size;i++ ){
			fusionChartObjects[i] =(FusionChartObject)ls.get(i);
		}
		return fusionChartObjects;
	}



}
