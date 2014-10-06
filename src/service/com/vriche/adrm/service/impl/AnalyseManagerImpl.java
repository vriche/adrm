package com.vriche.adrm.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.AnalyDao;
import com.vriche.adrm.model.AnalyzeClass;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.AnalyseManager;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.OrderDetailUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;
import com.vriche.adrm.util.AnalyseUtil;

public class AnalyseManagerImpl extends BaseManager implements AnalyseManager {
	
	private AnalyDao dao;
    private UserManager userManager;
    private CarrierManager carrierManager;
    private IncomeManager incomeManager;
	
	public void setAnalyDao(AnalyDao analyDao) {
		this.dao = analyDao;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}
	public void setIncomeManager(IncomeManager incomeManager) {
		this.incomeManager = incomeManager;
	}
    
	
	
	
	public Map getBrandWhere(AnalyzeClass analyzeClass){
		Map mp = new HashMap();
		List customerIdList = new ArrayList();
		List resourceIdList = new ArrayList();
		List userIdList = new ArrayList();
		List namesList = new ArrayList();
		String startDate = analyzeClass.getStartDate();
		String endDate = analyzeClass.getEndDate();
		Integer version = analyzeClass.getVersion();
		
		String userLongName = analyzeClass.getCurUserName();
		String[] resIds = analyzeClass.getOrderDetail().getMatter().getResourceIds();
		String[] customerIds = analyzeClass.getOrderDetail().getMatter().getCustomerIds();
		String[] userIds = analyzeClass.getOrderDetail().getMatter().getUserIds();
		String[] matterNames = analyzeClass.getOrderDetail().getMatter().getMatterNames();
		
		if(customerIds.length >0){
			CollectionUtils.addAll(customerIdList,customerIds);
		}
//		else{
//			customerIdList.add("-1");
//		}
		
		if(resIds.length >0){
			CollectionUtils.addAll(resourceIdList,resIds);
		}
//		else{
//			resourceIdList.add("-1");
//		}
		
		if(matterNames.length >0){
			CollectionUtils.addAll(namesList,matterNames);
		}
//		else{
//			namesList.add("-1");
//		}

		if(userIds.length == 0){
			List ls = UserUtil.getCurUserRels(userLongName);
			if(ls.size() == 0) ls.add("-1");
			CollectionUtils.addAll(userIdList,ls.iterator());
		}else{
			CollectionUtils.addAll(userIdList,userIds);
		}
		

		   System.out.println("start>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   System.out.println("start>>>>>>>>>>"+ startDate);
		   System.out.println("end>>>>>>>>>>"+ endDate);
		   System.out.println("version>>>>>>>>>>"+ version);
		   System.out.println("carrierId>>>>>>>>>>"+ resourceIdList.size());
		   System.out.println("userIdList>>>>>>>>>>"+ userIdList.size());
		   System.out.println("matterName>>>>>>>>>>"+ namesList.size());

		   
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("version",version);
		mp.put("customerIdList",customerIdList);
		mp.put("resourceIdList",resourceIdList);
		mp.put("userIdList",userIdList);
		mp.put("namesList",namesList);
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(userLongName));
     	}
		
		
		return mp;
	}
	

	public List getBrand(AnalyzeClass analyzeClass, String pageIndex, String pageSize, String pageCount) {
		Map mp = this.getBrandWhere(analyzeClass);
		pageIndex = pageIndex == null?"0":pageIndex;
		pageSize = pageSize == null?"0":pageSize;
		
//		List ls = dao.getBrand(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		
		List ls = dao.getBrand(mp,1,2000);
		
		System.out.println("ls.size()>>>>>>>>>>"+ ls.size());
		
//		if(Integer.parseInt(pageCount) == Integer.parseInt(pageIndex)){
			List ls2 = dao.getBrand(mp,Integer.parseInt(pageIndex),0);
			AnalyzeClass analyze = getBrandSum(ls2);
			ls.add(analyze);
//			CollectionUtils.addAll(ls,ls2.iterator());
//		}
		
		return ls;
	}
	
	
	public Collection getBrandReport(AnalyzeClass analyzeClass) {
		Collection coll= new ArrayList();
		Map mp = this.getBrandWhere(analyzeClass);
		List ls = dao.getBrand(mp,0,0);
		
//		System.out.println("ls.size()>>>>>>>>>>"+ ls.size());
		if(ls.size() > 0){
			AnalyzeClass analyze = getBrandSum(ls);
			ls.add(analyze);
			CollectionUtils.addAll(coll,ls.iterator());
		}
		 
		return coll;
	}
	
 
	private AnalyzeClass getBrandSum(List ls){
		AnalyzeClass analyze = new AnalyzeClass();
		double timeUsedSum = 0;
		double relPlaySum = 0;
		double relIncomeSum = 0;
		int i = 1;
		for(Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass obj = (AnalyzeClass)it.next();
			Double timeUsed = obj.getTimeUsed();
			Double relPay = obj.getRelPay();
			Double relIncome = obj.getRelIncome();
			obj.setDisplayNo(new Integer(i++));
			if(timeUsed == null) timeUsed = new Double(0);
			if(relPay == null) relPay = new Double(0);
			if(relIncome == null) relIncome = new Double(0);
			timeUsedSum += timeUsed.doubleValue();
			relPlaySum += relPay.doubleValue();
			relIncomeSum += relIncome.doubleValue();
			
		}
		
		

		
		
		analyze.setMatterName("合计:");
		DecimalFormat formatter = new DecimalFormat("###.00");
		analyze.setTimeUsed(new Double(formatter.format(timeUsedSum)));
		analyze.setRelPay(new Double(formatter.format(relPlaySum)));
		analyze.setRelIncome(new Double(formatter.format(relIncomeSum)));
		
		
		return analyze;
	}

	public int getBrandPageCount(AnalyzeClass analyzeClass) {
		Map mp = this.getBrandWhere(analyzeClass);
		return dao.getBrandPageCount(mp);
	}
	
	public String getBrandXML(AnalyzeClass analyzeClass, String pageIndex, String pageSize, String pageCount) {
//		CurrencyConverter currencyConverter = new CurrencyConverter();
		int i = (Integer.parseInt(pageIndex)-1)*Integer.parseInt(pageSize);
		int k = 0;
	
		List ls = this.getBrand(analyzeClass,pageIndex,pageSize,pageCount);
		int size = ls.size();
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass obj = (AnalyzeClass)it.next();
			if(obj.getRelPay() == null) obj.setRelPay(new Double(0));
			if(obj.getRelIncome() == null) obj.setRelIncome(new Double(0));
			i++;k++;
			sb.append("<row  id=\""+ i +"\"" +">");
//			if(size == k && Integer.parseInt(pageIndex) == Integer.parseInt(pageCount)){
//				sb.append("<cell><![CDATA["+ ""+"]]></cell>");
//			}else{
//				sb.append("<cell><![CDATA["+ i +"]]></cell>");
//			}
			
			sb.append("<cell><![CDATA["+ obj.getMatterName() +"]]></cell>");
			
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(obj.getRelPay()) +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(obj.getRelIncome()) +"]]></cell>");
			Double  v = new Double(obj.getRelPay().doubleValue() - obj.getRelIncome().doubleValue());
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(v) +"]]></cell>");
			String s = DateUtil.formatLongToTimeStr(new Long(Float.valueOf(obj.getTimeUsed().toString()).longValue()*1000));
			sb.append("<cell><![CDATA["+ s +"]]></cell>");
//			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(obj.getTimeUsed()) +"]]></cell>");
			sb.append("</row>");
		}
		
		sb.append("</rows>");	
		return sb.toString();
	}


	

	
	
	
	public Collection getResourceAdverReport(AnalyzeClass analyzeClass) {
		Collection coll= new ArrayList();
		Map mp = this.getResourceAdverWhere(analyzeClass);
		List ls = dao.getResourceAdver(mp,0,0);
		System.out.println("getResourceAdverReport>>>>33333333 555    7777777777  9999>>>>>>"+ ls.size());
		
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass obj = (AnalyzeClass)it.next();
			
			
			String resourceName = StringUtil.null2String(obj.getOrderDetail().getResource().getResourceName());
			String resourceMemo = StringUtil.null2String(obj.getOrderDetail().getResource().getMemo());
			String resourceLable = resourceName +" "+ resourceMemo;
			
			obj.getObj().add(0,obj.getOrder().getOrderCode());
//			obj.getObj().add(1,obj.getOrder().getContract().getCode());
			obj.getObj().add(1,resourceLable);
			obj.getObj().add(2,obj.getOrder().getRelationCode());
			obj.getObj().add(3,obj.getOrderDetail().getOrderCategoryMain());
			obj.getObj().add(4,obj.getOrder().getCustomer().getCustomerName());
			obj.getObj().add(5,obj.getOrderDetail().getMatter().getName());
			obj.getObj().add(6,obj.getOrderDetail().getMatter().getEdit());
			obj.getObj().add(7,obj.getOrderDetail().getMatter().getLength());
			obj.getObj().add(8,obj.getOrderDetail().getMatter().getTapeCode());
			
			String startDate = StringUtil.null2String(obj.getOrderDetail().getPublishStartDate());
			String endDate = StringUtil.null2String(obj.getOrderDetail().getPublishEndDate());
			startDate = startDate =="0"?"":startDate.substring(4,6)+"/"+startDate.substring(6,8);
			endDate = endDate =="0"?"":endDate.substring(4,6)+"/"+endDate.substring(6,8);;
			
			obj.getObj().add(9,startDate);
			obj.getObj().add(10,endDate);
			obj.getObj().add(11,obj.getOrderDetail().getSumTimes().toString());
			obj.getObj().add(12,obj.getOrder().getUser().getFullName());
			obj.getObj().add(13,obj.getOrder().getOrderState().getName());
			
			coll.add(obj);
		}

		return coll;
	}	
	
	
	
	public Map getResourceAdverWhere(AnalyzeClass analyzeClass){
		Map mp = new HashMap();
		List resourceIdList = new ArrayList();
		List userIdList = new ArrayList();
		String startDate = analyzeClass.getStartDate();
		String endDate = analyzeClass.getEndDate();
		Long userId = analyzeClass.getOrder().getUserId();
		String userLongName = analyzeClass.getCurUserName();
		String weekStr = analyzeClass.getWeekStr();
		String customerName = analyzeClass.getCustomer().getCustomerName();
		String[] resIds = analyzeClass.getResourceIds();
		
		if(!"".equals(weekStr) && weekStr != null){
			List inWeekDates = new ArrayList();
			DateUtil.getWeekDates(startDate,endDate,weekStr,inWeekDates);
//			System.out.println("日期>>" + inWeekDates);
			mp.put("inWeekDates",inWeekDates);
		}	
		
		if(resIds.length >0){
			CollectionUtils.addAll(resourceIdList,analyzeClass.getResourceIds());
		}else{
			resourceIdList.add("-1");
		}

		if(userId.longValue() == 0){
			List ls = UserUtil.getCurUserRels(userLongName);
			if(ls.size() == 0) ls.add("-1");
			CollectionUtils.addAll(userIdList,ls.iterator());
		}else{
			userIdList.add(userId);
		}
		

		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("customerName",customerName);
		mp.put("resourceIdList",resourceIdList);
		mp.put("userIdList",userIdList);
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(userLongName));
     	}
     	
//		   System.out.println("start>>>>>>>>>>"+ startDate);
//		   System.out.println("end>>>>>>>>>>"+ endDate);
//		   System.out.println("userId>>>>>>>>>>"+ userId);
//		   System.out.println("resourceIdList>>>>>>>>>>"+ resourceIdList);
//		   System.out.println("customerName>>>>>>>>>>"+ customerName);
//		   System.out.println("userIdList>>>>>>>>>>"+ userIdList);
//		   System.out.println("yearIdList>>>>>>>>>>"+ UserUtil.getUserYearRelByLoginUser(userLongName));
     	
     	
		return mp;
	}
	
	
	public List getResourceAdver(AnalyzeClass analyzeClass, String pageIndex,String pageSize) {
		Map mp = this.getResourceAdverWhere(analyzeClass);
		

		
		pageIndex = pageIndex == null?"0":pageIndex;
		pageSize = pageSize == null?"0":pageSize;
		return dao.getResourceAdver(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}
	
	public int getResourceAdverPageCount(AnalyzeClass analyzeClass) {
		Map mp = this.getResourceAdverWhere(analyzeClass);
		return dao.getResourceAdverPageCount(mp);
	}
	
	
	public String getResourceAdverXML(AnalyzeClass analyzeClass, String pageIndex, String pageSize) {
		List ls = this.getResourceAdver(analyzeClass,pageIndex,pageSize);
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");

		for(Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass obj = (AnalyzeClass)it.next();
			
			String startDate = StringUtil.null2String(obj.getOrderDetail().getPublishStartDate());
			String endDate = StringUtil.null2String(obj.getOrderDetail().getPublishEndDate());
			startDate = startDate =="0"?"":startDate.substring(4,6)+"/"+startDate.substring(6,8);
			endDate = endDate =="0"?"":endDate.substring(4,6)+"/"+endDate.substring(6,8);;
			
			String resourceName = StringUtil.null2String(obj.getOrderDetail().getResource().getResourceName());
			String resourceMemo = StringUtil.null2String(obj.getOrderDetail().getResource().getMemo());
			String resourceLable = resourceName +" "+ resourceMemo;
			
//			订单编号,段位,联系号,类别,客户名称,广告名称,广告版本,长度,磁带号,开始日期,结束日期,次数,应付,签定人,状态
			sb.append("<row  id=\""+ obj.getOrderDetail().getId() +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getOrder().getOrderCode()  +"]]></cell>");
//			sb.append("<cell><![CDATA["+ obj.getOrder().getContract().getCode()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ resourceLable  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrder().getRelationCode()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrderDetail().getOrderCategoryMain()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrder().getCustomer().getCustomerName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrderDetail().getMatter().getName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrderDetail().getMatter().getEdit() +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrderDetail().getMatter().getLength() +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrderDetail().getMatter().getTapeCode() +"]]></cell>");
			sb.append("<cell><![CDATA["+ startDate +"]]></cell>");
			sb.append("<cell><![CDATA["+ endDate +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrderDetail().getSumTimes()+"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrderDetail().getMoneyRealpay()+"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrder().getUser().getFullName()+"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getOrder().getOrderState().getName()+"]]></cell>");
			sb.append("</row>");
		}
		
			int i=getResourceAdverPageCount(analyzeClass);
		
			if((Integer.parseInt(pageIndex)-1)*Integer.parseInt(pageSize)+ls.size()==i){
					Map mp = this.getResourceAdverWhere(analyzeClass);	
        	double SumMoney=dao.getResourceAdverSumMoney(mp);
        	sb.append("<row  id=\""+ "total"   +"\">");
				sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
				sb.append("<cell></cell><cell></cell><cell></cell><cell></cell><cell></cell>");
				sb.append("<cell></cell><cell></cell><cell></cell><cell></cell><cell></cell><cell></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(SumMoney))  +"]]></cell>");
				sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}
	//订单类别客户统计
	public String getOrderCategoryByCarrierTypeXML(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint){
//		List ls = getOaTeleExpensesByBeginAndEndDate(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		Map mp = getOrderCategoryByCarrierType(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		return AnalyseUtil.makeOrderCategoryXML(mp);
	}
	
//	得到订单类别统计的mp 
	public Map getOrderCategoryByCarrierType(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint) {
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("carrierIdList",carrierIdList);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
		
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
     	
		List ls = dao.getOrderCategoryByCarrierType(mp);
		
		
		return getOrderCategoryByCarrierType(ls);
	}
	private Map getOrderCategoryByCarrierType(List ls){
		Map map = new HashMap();
		Map mapOrderCategory = new HashMap();
		double sum =ConvertUtil.getSumFromList(ls,"relPay");
//		double sum =getSumRelPay(ls);
//		System.out.println("sum>11111>>>>>>>>>>>>>>"+sum);
		map.put("relPaySum",new Double(sum));
		for (Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass) it.next();
//			String id = analyzeClass.getId().toString();
			String orderCategory = analyzeClass.getMatterName();
			
//			求每个类别的合计
			getOrderCategroySum(analyzeClass,mapOrderCategory);
			map.put("mapOrderCategory",mapOrderCategory);
			analyzeClass.setMatterName("");
			if(map.containsKey(orderCategory)){
				List ls2 = (List)map.get(orderCategory);
				ls2.add(analyzeClass);
				map.put(orderCategory,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(analyzeClass);
				map.put(orderCategory,ls2);
			}
		}
		
		return map;
	}
	public List getOrderCategoryByCarrierTypePandect(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint){
		List list = new ArrayList();
		Map map = getOrderCategoryByCarrierType(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		Map mapOrderCategory = (Map)map.get("mapOrderCategory");
		double sum = ((Double)map.get("relPaySum")).doubleValue();
		double res[] = new  double[3];
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapOrderCategory") && !key.equals("relPaySum")){
				AnalyzeClass obj = (AnalyzeClass)mapOrderCategory.get(key);	
				
				Double relIncome = obj.getRelIncome() == null?new Double(0):obj.getRelIncome();
				Double sysPrice = obj.getRelPay()== null?new Double(0):obj.getRelPay();
				Double times = obj.getTimeUsed();
				
				res[0] += relIncome.doubleValue();
				res[1] += sysPrice.doubleValue();
				res[2] += times.doubleValue();	
//				double youHuiPrice= sysPrice.doubleValue()- relIncome.doubleValue();
				obj.setMatterName(key);
				obj.setResourceName("");
				obj.setSumUsed(StringUtil.persentFormat(obj.getRelPay().doubleValue(),sum));
				list.add(obj);
			}
		}
		if(map.size()>0){
			AnalyzeClass aClass = new AnalyzeClass();
			aClass.setMatterName("合计:");
			aClass.setResourceName("");
			aClass.setRelIncome(new Double(res[0]));
			aClass.setRelPay(new Double(res[1]));
			aClass.setTimeUsed(new Double(res[2]));
			aClass.setSumUsed("");
			list.add(aClass);
		}
		return list ;
	}
	//在报表中计算总计的方法？
	private double getSumRelPay(List ls){
		double res[] = new  double[1];
		for (Iterator it = ls.iterator(); it.hasNext();) {
			AnalyzeClass analyzeClass = (AnalyzeClass)it.next();
			Double relPay = analyzeClass.getRelPay();
			res[0] += relPay.doubleValue();
			}
		if(ls.size()==0) res[0]=0;
		return res[0];
	}
	private void getOrderCategroySum(AnalyzeClass cutP,Map mapOrderCategory){
		String key = cutP.getMatterName();
		Object obj  = mapOrderCategory.get(key);
		if(obj == null) {
			AnalyzeClass cutProduct =  new AnalyzeClass();
			cutProduct.setMatterName("");
			cutProduct.setResourceName("小计");
			cutProduct.setRelPay(cutP.getRelPay());
			cutProduct.setRelIncome(cutP.getRelIncome());

			cutProduct.setTimeUsed(cutP.getTimeUsed());
			mapOrderCategory.put(key,cutProduct);
		}else{
			AnalyzeClass  cutProduct = (AnalyzeClass)obj;
			double relIncome = cutProduct.getRelIncome().doubleValue();
			double sysPrice = cutProduct.getRelPay().doubleValue();
			double times = cutProduct.getTimeUsed().doubleValue();	
			cutProduct.setRelIncome(new Double(relIncome+cutP.getRelIncome().doubleValue()));
			cutProduct.setRelPay(new Double(sysPrice+cutP.getRelPay().doubleValue()));
			cutProduct.setTimeUsed(new Double(times+cutP.getTimeUsed().doubleValue()));
			mapOrderCategory.put(key,cutProduct);
		}
	}
	
	//在页面中计算总计
	private static double SumRelPay(Map mapOrderCategory){
		double res[] = new  double[1];
		for (Iterator it = mapOrderCategory.values().iterator(); it.hasNext();) {
			AnalyzeClass analyzeClass = (AnalyzeClass)it.next();
			Double relPay = analyzeClass.getRelPay();
			res[0] += relPay.doubleValue();
			}
		if(mapOrderCategory.size()==0) res[0]=0;
		return res[0];
	}

  //用于报表统计中
	public List getOrderCategoryByCarrierType1(String[] carrierIds,int channelModelParam,String beginDate, String endDate,String userId,String curUserName,String isPrint) {
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("carrierIdList",carrierIdList);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		List ls = dao.getOrderCategoryByCarrierType(mp);
		
		
		return getOrderCategoryByCarrierType1(ls);
	}
	private List getOrderCategoryByCarrierType1(List ls){
		Map map = new HashMap();
		Map mapOrderCategory = new HashMap();
		List lsAll  = new ArrayList();
//		double sum =getSumRelPay(ls);
		double sum =ConvertUtil.getSumFromList(ls,"relPay");
		for (Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass) it.next();
//			String id = analyzeClass.getId().toString();
			String orderCategory = analyzeClass.getMatterName();
			
//			求每个类别的合计
			getOrderCategroySum(analyzeClass,mapOrderCategory);
			
			analyzeClass.setMatterName("");
			if(map.containsKey(orderCategory)){
				List ls2 = (List)map.get(orderCategory);
				ls2.add(analyzeClass);
				map.put(orderCategory,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(analyzeClass);
				map.put(orderCategory,ls2);
			}
		}
		
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			List cutList = (List)map.get(key);
			AnalyzeClass cutP =  (AnalyzeClass)cutList.get(0);
			cutP.setMatterName(key);
			AnalyzeClass analyzeClass = (AnalyzeClass)mapOrderCategory.get(key);
				for(Iterator itl = cutList.iterator();itl.hasNext();){
					AnalyzeClass cProduct =  (AnalyzeClass)itl.next();
					cProduct.setResourceMeno(StringUtil.persentFormat(cProduct.getRelIncome().doubleValue(),cProduct.getRelPay().doubleValue()));
					cProduct.setSumUsed(StringUtil.persentFormat(cProduct.getRelPay().doubleValue(),analyzeClass.getRelPay().doubleValue()));
				}
//			  用这个setSumUsed存放比例		
//			  用这个setResourceMeno存放比例	
//			cutList.add(cutList.size()+1,cutList.get(0));
//			cutList.add(0,customerProduct);
			analyzeClass.setSumUsed(StringUtil.persentFormat(analyzeClass.getRelPay().doubleValue(),sum));
			analyzeClass.setResourceMeno(StringUtil.persentFormat(analyzeClass.getRelIncome().doubleValue(),analyzeClass.getRelPay().doubleValue()));
			cutList.add(analyzeClass);
			CollectionUtils.addAll(lsAll,cutList.iterator());
		}
		return lsAll;
	}
	
//	客户订单类别统计	
	public String getOrderCategoryByCustomerXML(AnalyzeClass analyzeClass, String year, String[] customerIds, String userId, String carrierName, int channelModelParam, String theUser) {
			String sortStr = analyzeClass.getResourceMeno();
			String startDate = analyzeClass.getStartDate();
			String endDate = analyzeClass.getEndDate();
			
			List all = this.getOrderCategoryByCustomer(sortStr,year,startDate,endDate,customerIds,userId,carrierName,channelModelParam,theUser);
			StringBuffer sb = new StringBuffer();
			AnalyseUtil.makeTreeGridXML(sb,all);
			return sb.toString();
	}

	public List getOrderCategoryByCustomer(String sortStr,String year,String startDate,String endDate, String[] customerIds,String userId,String carrierName,int channelModelParam,String theUser) {
	
	List userIdList = new ArrayList();
	List carrierIdList = new ArrayList();
	Map map = new HashMap();
	List customerIdList = new ArrayList();
	CollectionUtils.addAll(customerIdList, customerIds);
	map.put("startDate", startDate);
	map.put("endDate", endDate);
	map.put("year", year);
	map.put("CustomerIdList", customerIdList);
	
	
//	判断是否分频道，值为1分，否则不分
	boolean channelPull = false;
	if(channelModelParam == 1)channelPull = true;
	
	carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,theUser);
	if(carrierIdList.size() == 0)carrierIdList.add("-1");
	map.put("carrierIdList",carrierIdList);
	
	if((!"".equals(userId) &&  userId!=null)){
		List userls = new ArrayList();
		userls.add(userId);
		map.put("UserIdList",userls);
	}else{
		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
		
		List ls = userManager.getOwnerUsersList(userRelsMap,theUser);
		for(Iterator it=ls.iterator();it.hasNext();){
			User user = (User)it.next();
			userIdList.add(user.getId());
		}
		if(userIdList.size() == 0)userIdList.add("-1");
		map.put("UserIdList",userIdList);
	}
	
	
	
 	if(UserUtil.isUserOrderYearRel()) {
 		map.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
 	}

	List ls = dao.getOrderCategoryByCustomer(map);
	List resutList = new ArrayList();
	double sum =ConvertUtil.getSumFromList(ls,"relPay");
	double resultTotal[]=new double[3];
	
		for(Iterator it =ls.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass)it.next();
		resultTotal[0]+=analyzeClass.getRelPay().doubleValue();
		resultTotal[1]+=analyzeClass.getRelIncome().doubleValue();
		resultTotal[2]+=analyzeClass.getSumTimes().doubleValue();
		analyzeClass.setTimeUsed(new Double(analyzeClass.getRelPay().doubleValue()-analyzeClass.getRelIncome().doubleValue()));
		analyzeClass.setResourceMeno(StringUtil.persentFormat(analyzeClass.getRelIncome().doubleValue(),analyzeClass.getRelPay().doubleValue()));
		analyzeClass.setSumUsed(StringUtil.persentFormat(analyzeClass.getRelPay().doubleValue(),sum));
		resutList.add(analyzeClass);
	}
		
		AnalyzeClass resultAnalyzeClass =new AnalyzeClass();
		resultAnalyzeClass.setMatterName("合计");
		resultAnalyzeClass.setRelPay(new Double(resultTotal[0]));
		resultAnalyzeClass.setRelIncome(new Double(resultTotal[1]));
		resultAnalyzeClass.setTimeUsed(new Double(resultTotal[0]-resultTotal[1]));
		resultAnalyzeClass.setSumTimes(new Double(resultTotal[2]));
		resultAnalyzeClass.setResourceMeno("");
		resultAnalyzeClass.setSumUsed("");
		
		
		resutList.add(resultAnalyzeClass);
    
	return resutList;
}
	
	//载体构成分析统计
	public String getCarrierBasalByBeginAndEndDateXML(int channelModelParam, String beginDate, String endDate, String userId, String carrierName, String curUserName, String isPrint) {
//		List ls = getIndustryTypeProductByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,curUserName,isPrint);
		Map mp = getCarrierBasalByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,curUserName,isPrint);
		return AnalyseUtil.makeCarrierBasalGridXML(mp);
	}		

	public Map getCarrierBasalByBeginAndEndDate(int channelModelParam,String beginDate,String endDate,String userId,String carrierName,String theUser,String isPrint) {
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		
//		List carrierIdList = new ArrayList();
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		
		


//		判断是否分频道，值为1分，否则不分
//		boolean channelPull = false;
//		if(channelModel==1){
//			 channelPull = true;
//		}
//		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
//		mp.put("carrierIdList",carrierIdList);
		
		
//		List carrierIdList = new ArrayList();
//		List carrierIdList2 = new ArrayList();
//		Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
//		//判断是否分频道，值为1分，否则不分
//		if((!"".equals(carrierName) &&  carrierName!=null && !"0".equals(carrierName))){
//			String[] carrierNames = carrierName.split(",");
//			for(int i=0;i<carrierNames.length;i++){
//				carrierIdList.add(carrierNames[i]);
//				List ls = (List)carrierMp.get(new Long(carrierNames[i]));
//				CollectionUtils.addAll(carrierIdList2,ConvertUtil.getColFromList(ls,"id"));
//			}
//		}else{
//			boolean channelPull = false;
//			if(channelModelParam==1) channelPull = true;
//			carrierIdList = carrierManager.getOwnerCarrierIds(carrierName,channelPull,theUser);
//			carrierIdList2 = carrierManager.getCarrierIdLists(carrierName,channelPull,theUser);
//			if(carrierIdList2.size() == 0)carrierIdList2.add("-1");
//			
//		}
		List carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
 		mp.put("carrierIdList",carrierIdList2);	
		
		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,theUser);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
     	}
		
		List ls = dao.getCarrierBasalByBeginAndEndDate(mp);
//		System.out.println("ls中是否取出数据<11111111111111111111111<<<<<<<<<<<<<<<<<"+ls.size());
		return getCarrierBasalByListDetails(ls);
	}
	
	private Map getCarrierBasalByListDetails(List ls){
		
		
		Map map = new HashMap();
		Map mapCarNames = new HashMap();
		Map mapCarrierBasal = new HashMap();
//		Map mapCarNames = carrierManager.getCarrierNameMap();
//		Map mapCarNames =  carrierManager.getCarrierAlisNameMap();
		
		
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
		if(carrierAlisname){
			 mapCarNames =  carrierManager.getCarrierAlisNameMap();
		}else{
			 mapCarNames = carrierManager.getCarrierNameMap();
		}
		
		
		
		double sum =ConvertUtil.getSumFromList(ls,"relIncome");

		map.put("relIncomeSum",new Double(sum));
		for (Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass) it.next();
			

			String parentId = analyzeClass.getResourceName();
	
			String carrierName = (String)mapCarNames.get(parentId);
			
			analyzeClass.setResourceName(carrierName);
			
			
//			System.out.println("parentId>>>>>>>>>>>>>>>>>>>>"+parentId);
//			System.out.println("carrierName>>>>>>>>>>>>>>>>>>>>"+carrierName);
			
			
			
//			analyzeClass.setCurUserName(carrierName);
			

			//求每个频道的合计
			getCarrierSum(analyzeClass,mapCarrierBasal,carrierName);

			analyzeClass.setResourceName("");
			
			if(map.containsKey(carrierName)){
				List ls2 = (List)map.get(carrierName);
				ls2.add(analyzeClass);
				map.put(carrierName,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(analyzeClass);
				map.put(carrierName,ls2);
			}
		}
	
		map.put("mapCarrierBasal",mapCarrierBasal);
		
		return map;
	}
	private void getCarrierSum(AnalyzeClass aClass,Map mapCarrierBasal,String carrierName){
		String key = aClass.getResourceName();
		Object obj  = mapCarrierBasal.get(key);
		if(obj == null) {
			AnalyzeClass analyzeClass =  new AnalyzeClass();
			analyzeClass.setResourceName(carrierName);
			analyzeClass.setCarrierName("小计");
			analyzeClass.setRelIncome(aClass.getRelIncome());
			analyzeClass.setSumTimes(aClass.getSumTimes());
			mapCarrierBasal.put(key,analyzeClass);
		}else{
			AnalyzeClass analyzeClass =(AnalyzeClass)obj;
			double relIncome = analyzeClass.getRelIncome().doubleValue();
			double times = analyzeClass.getSumTimes().doubleValue();
			analyzeClass.setRelIncome(new Double(relIncome+aClass.getRelIncome().doubleValue()));
			analyzeClass.setSumTimes(new Double(times+aClass.getSumTimes().doubleValue()));
			mapCarrierBasal.put(key,analyzeClass);
		}
		
	}
	public List getCarrierBasalReportByBeginAndEndDatePandect(int channelModelParam, String beginDate, String endDate, String userId, String carrierName, String curUserName, String isPrint){
		List list = new ArrayList();
		Map map = getCarrierBasalByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,curUserName,isPrint);
		Map mapCarrierBasal = (Map)map.get("mapCarrierBasal");
		double res[] = new  double[2];
		double sum = ((Double)map.get("relIncomeSum")).doubleValue();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapCarrierBasal") && !key.equals("relIncomeSum")){
				AnalyzeClass obj = (AnalyzeClass)mapCarrierBasal.get(key);	
				
				Double relIncome = obj.getRelIncome() == null?new Double(0):obj.getRelIncome();
				Double times = obj.getSumTimes();
				
				res[0] += relIncome.doubleValue();
				res[1] += times.doubleValue();			
				
				String relComeScale = StringUtil.persentFormat(relIncome.doubleValue(),sum);
//				obj.setResourceName(key);
				obj.setCarrierName("");
				obj.setSumUsed(relComeScale);
				list.add(obj);
			}
		}
		if(map.size()>0){
			AnalyzeClass aClass = new AnalyzeClass();
			aClass.setResourceName("合计:");
			aClass.setCarrierName("");
			aClass.setRelIncome(new Double(res[0]));
			aClass.setSumTimes(new Double(res[1]));
			list.add(aClass);
		}
		return list ;
	}
	public List getCarrierBasalReportByBeginAndEndDate(int channelModel, String beginDate, String endDate, String userId, String carrierName, String curUserName, String isPrint) {
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModel==1){
			 channelPull = true;
		}
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,curUserName);
		mp.put("carrierIdList",carrierIdList);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
		List ls = dao.getCarrierBasalByBeginAndEndDate(mp);
//		System.out.println("ls中是否取出数据<11111111111111111111111<<<<<<<<<<<<<<<<<"+ls.size());
		return getCarrierBasalByListDetails2(ls);
	}
	private List getCarrierBasalByListDetails2(List ls){
		Map map = new HashMap();
		Map mapCarrierBasal = new HashMap();
		Map mapCarNames = carrierManager.getCarrierNameMap();

		List lsAll = new ArrayList();
		
		double sum =ConvertUtil.getSumFromList(ls,"relIncome");
		
		for (Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass) it.next();

			String parentId = analyzeClass.getResourceName();
//			String carrierName = (String)mapCarNames.get(parentId);
//			analyzeClass.setCurUserName(carrierName);

			//求每个频道的合计
			getCarrierSum(analyzeClass,mapCarrierBasal,"");

			analyzeClass.setResourceName("");
			
			if(map.containsKey(parentId)){
				List ls2 = (List)map.get(parentId);
				ls2.add(analyzeClass);
				map.put(parentId,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(analyzeClass);
				map.put(parentId,ls2);
			}
		}
	
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			List cutList = (List)map.get(key);
			AnalyzeClass analyzeC =  (AnalyzeClass)cutList.get(0);
			String carrierName = (String)mapCarNames.get(key);
			analyzeC.setResourceName(carrierName);
			AnalyzeClass analyzeClass = (AnalyzeClass)mapCarrierBasal.get(key);
				for(Iterator itl = cutList.iterator();itl.hasNext();){
					AnalyzeClass aClass =  (AnalyzeClass)itl.next();
					aClass.setSumUsed(StringUtil.persentFormat(aClass.getRelIncome().doubleValue(),analyzeClass.getRelIncome().doubleValue()));
				}

			
//			//用这个setSumUsed存放比例
				analyzeClass.setSumUsed(StringUtil.persentFormat(analyzeClass.getRelIncome().doubleValue(),sum));
			cutList.add(analyzeClass);
			CollectionUtils.addAll(lsAll,cutList.iterator());
		}
		return lsAll;
	}
	
//	区域客户统计
	public String getAreaCustomerByCarrierTypeXML(String[] carrierIds,int model,String beginDate,String endDate,String userId,String curUserName,String isPrint){
		Map mp = getAreaCustomerByCarrierType(carrierIds,model,beginDate,endDate,userId,curUserName,isPrint);
		return AnalyseUtil.makeAreaCustomerXML(mp);
	}
	
//	得到区域客户统计的mp 
	public Map getAreaCustomerByCarrierType(String[] carrierIds,int model,String beginDate, String endDate,String userId,String curUserName,String isPrint) {
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("carrierIdList",carrierIdList);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
//		mp.put("model",new Integer(model));
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(curUserName));
     	}
     	
		List ls = dao.getAreaCustomerByCarrierType(mp);

		Map incMap = incomeManager.getAreaIncome(mp);
		return getAreaCustomerByCarrierType(ls,incMap, model);
	}
	private Map getAreaCustomerByCarrierType(List ls,Map incMap,int model){
		Map map = new HashMap();
		
		   
//		System.out.println("all<<<<<<<111111111xxxxxxxxxxxxxxxxxxccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccxxxxxxxxxxxxxxx1111<<<<<<<<<<"+model);
//		System.out.println("all<<<<<<<111111111xxxxxxxxxxxxxxxxxxccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccxxxxxxxxxxxxxxx1111<<<<<<<<<<"+model);
//		
		Map mapAreaCustomer = new HashMap();

			for (Iterator it = ls.iterator();it.hasNext();){
				AnalyzeClass analyzeClass = (AnalyzeClass) it.next();

				String cutName = analyzeClass.getResourceName();
				Object obj = incMap.get(cutName);
				incMap.remove(cutName);
				Double incMoney =(obj == null)?new Double(0):(Double)obj;		
				analyzeClass.setRelPay(incMoney);
				
				String areaCity = (model == 0)?analyzeClass.getResourceMeno():analyzeClass.getCustomer().getCategory().getCategoryName();
				
				
//				System.out.println("all<<<<<<<111111111xxxxxxxxxxxxxxxxxxcccccc  ccareaCity  ccccccccccccccccccccccccccccxxxxxxxxxxxxxxx1111<<<<<<<<<<"+areaCity);
				
				areaCity=areaCity==null||areaCity.equals(null)?"其它":areaCity;
				analyzeClass.setResourceMeno(areaCity);
//				System.out.println("areaCity111111111111111<<<<<<<<<<<<<<<<<<<<<<<<"+ areaCity);
//				求每个城市的合计
				getAreaCustomerSum(analyzeClass,mapAreaCustomer);
				
				analyzeClass.setResourceMeno("");
				if(map.containsKey(areaCity)){
					List ls2 = (List)map.get(areaCity);
					ls2.add(analyzeClass);
					map.put(areaCity,ls2);
				}else{
					List ls2 = new ArrayList();
					ls2.add(analyzeClass);
					map.put(areaCity,ls2);
				}
			}
			map.put("mapAreaCustomer",mapAreaCustomer);


		
		return map;
	}
	public List getAreaCustomerByCarrierPandect(String[] carrierIds,int channelModelParam,String beginDate,String endDate,String userId,String curUserName,String isPrint){
		List list = new ArrayList();
		
		
//		System.out.println("all<<<<<<<111111111xxxxxxxxxxxxxxxxxxccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccxxxxxxxxxxxxxxx1111<<<<<<<<<<"+channelModelParam);
//		System.out.println("all<<<<<<<111111111xxxxxxxxxxxxxxxxxxccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccxxxxxxxxxxxxxxx1111<<<<<<<<<<"+channelModelParam);
//		
		Map map = getAreaCustomerByCarrierType(carrierIds,channelModelParam,beginDate,endDate,userId,curUserName,isPrint);
		Map mapAreaCustomer = (Map)map.get("mapAreaCustomer");
		double res[] = new  double[2];
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapAreaCustomer")){
				key=key==null||key.equals(null)?"其它":key;
				AnalyzeClass obj = (AnalyzeClass)mapAreaCustomer.get(key);	
				
				Double relIncome = obj.getRelIncome() == null?new Double(0):obj.getRelIncome();
				Double sysPrice = obj.getRelPay()== null?new Double(0):obj.getRelPay();
				
				res[0] += relIncome.doubleValue();
				res[1] += sysPrice.doubleValue();	
				
				obj.setResourceMeno(key);
				obj.setResourceName("");
				list.add(obj);
			}
		}
		if(map.size()>0){
			AnalyzeClass aClass = new AnalyzeClass();
			aClass.setResourceMeno("合计:");
			aClass.setResourceName("");
			aClass.setRelIncome(new Double(res[0]));
			aClass.setRelPay(new Double(res[1]));
			list.add(aClass);
		}
		return list ;
	}
	private void getAreaCustomerSum(AnalyzeClass cutP,Map mapAreaCustomer){
		String key = cutP.getResourceMeno();
		key=key==null||key.equals(null)?"其它":key;
		Object obj  = mapAreaCustomer.get(key);
		if(obj == null) {
			AnalyzeClass cutProduct =  new AnalyzeClass();
			cutProduct.setResourceMeno("");
			cutProduct.setResourceName("小计");
			cutProduct.setRelPay(cutP.getRelPay());
			cutProduct.setRelIncome(cutP.getRelIncome());
			cutProduct.setCarrierName(cutP.getCarrierName());
			mapAreaCustomer.put(key,cutProduct);
		}else{
			AnalyzeClass  cutProduct = (AnalyzeClass)obj;
			double relIncome = cutProduct.getRelIncome().doubleValue();
			double sysPrice = cutProduct.getRelPay().doubleValue();
			cutProduct.setRelIncome(new Double(relIncome+cutP.getRelIncome().doubleValue()));
			cutProduct.setRelPay(new Double(sysPrice+cutP.getRelPay().doubleValue()));
			mapAreaCustomer.put(key,cutProduct);
		}
	}
	//区域报表统计
	public List getAreaCustomerByCarrier(String[] carrierIds,int model,String beginDate, String endDate,String userId,String curUserName,String isPrint) {
		Map mp = new HashMap();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		CollectionUtils.addAll(carrierIdList, carrierIds);
		
		mp.put("carrierIdList",carrierIdList);
		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		if(isPrint.equals("false")){//页面显示
    			list = userManager.getOwnerUsersList(userRelsMap);
    		}else{                      //打印显示
    			list = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
    		}
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		List ls = dao.getAreaCustomerByCarrierType(mp);

		Map incMap = incomeManager.getAreaIncome(mp);
		return getAreaCustomerByCarrierType2(ls,incMap,model);
	}
	private List getAreaCustomerByCarrierType2(List ls,Map incMap,int model){
		Map map = new HashMap();
		Map mapAreaCustomer = new HashMap();
		List listAll = new ArrayList();

		for (Iterator it = ls.iterator();it.hasNext();){
			AnalyzeClass analyzeClass = (AnalyzeClass) it.next();

			String cutName = analyzeClass.getResourceName();
			Object obj = incMap.get(cutName);
			incMap.remove(cutName);
			Double incMoney =(obj == null)?new Double(0):(Double)obj;		
			analyzeClass.setRelPay(incMoney);
			
			String areaCity = (model == 0)?analyzeClass.getResourceMeno():analyzeClass.getCustomer().getCategory().getCategoryName();
			areaCity=areaCity==null||areaCity.equals(null)?"其它":areaCity;
			analyzeClass.setResourceMeno(areaCity);
//			System.out.println("areaCity111111111111111<<<<<<<<<<<<<<<<<<<<<<<<"+ areaCity);
//			求每个城市的合计
			getAreaCustomerSum(analyzeClass,mapAreaCustomer);
			
			analyzeClass.setResourceMeno("");
			if(map.containsKey(areaCity)){
				List ls2 = (List)map.get(areaCity);
				ls2.add(analyzeClass);
				map.put(areaCity,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(analyzeClass);
				map.put(areaCity,ls2);
			}
		}
		
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			List cutList = (List)map.get(key);
			AnalyzeClass analyzeC =  (AnalyzeClass)cutList.get(0);
			analyzeC.setResourceMeno(key);
			AnalyzeClass analyzeClass = (AnalyzeClass)mapAreaCustomer.get(key);
			
			
			cutList.add(analyzeClass);
			CollectionUtils.addAll(listAll,cutList.iterator());
		}
		return listAll;
	}

}
