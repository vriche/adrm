
package com.vriche.adrm.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.FinanceTargetRatioDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.OrderPublic;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.FinanceTargetRatioManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.DateUtil2;
import com.vriche.adrm.util.FinanceTargetComparator;
import com.vriche.adrm.util.FinanceTargetUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class FinanceTargetRatioManagerImpl extends BaseManager implements FinanceTargetRatioManager {
    private FinanceTargetRatioDao dao; 
    private CarrierManager carrierManager;
    private UserManager userManager;
    private  IncomeManager incomeManager;
    private OrderDayInfoManager orderDayInfoManager;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setFinanceTargetRatioDao(FinanceTargetRatioDao dao) {
        this.dao = dao;
    }
    
    public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}    
    
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public void setIncomeManager(IncomeManager incomeManager) {
		this.incomeManager = incomeManager;
	}

	public void setOrderDayInfoManager(OrderDayInfoManager orderDayInfoManager) {
		this.orderDayInfoManager = orderDayInfoManager;
	}
   /**
     * @see com.vriche.adrm.service.FinanceTargetManager#getFinanceTargets(com.vriche.adrm.model.FinanceTarget)
     */
//    public List getFinanceTargets(final FinanceTarget financeTarget) {
//    	
//        return null;
//    }
   /**
     * @see com.vriche.adrm.service.FinanceTargetManager#getFinanceTargetsCount(com.vriche.adrm.model.FinanceTarget)
     */
    public String getFinanceTargetsCount(final FinanceTarget financeTarget) {
        return dao.getFinanceTargetsCount(financeTarget).toString();
    }    

   /**
     * @see com.vriche.adrm.service.FinanceTargetManager#getFinanceTargetsCount(com.vriche.adrm.model.FinanceTarget)
     */    
	public List getFinanceTargetsPage(final FinanceTarget financeTarget,String pageIndex, String pageSize) {
		return dao.getFinanceTargetsPage(financeTarget,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.FinanceTargetManager#getFinanceTargetsCount(com.vriche.adrm.model.FinanceTarget)
     */    
	public String getFinanceTargetsPageXML(String targetYear,String carrierId,int channelModelParam,String userName) {
	    List ls = getFinanceTargets(targetYear,userName,carrierId,channelModelParam);
		return FinanceTargetUtil.makeFinanceTargetsGridXML(ls);
	}    

	
	public String getFinanceTargetRatioCarrierXML(String paramQueryString) {
		Collection coll =  getFinanceTargetRaioCarriers(paramQueryString);
		return FinanceTargetUtil.makeFinanceTargetRatiosGridXML(coll);
	}   
    /**
     * @see com.vriche.adrm.service.FinanceTargetManager#getFinanceTarget(String id)
     */
    public FinanceTarget getFinanceTarget(final String id) {
        return dao.getFinanceTarget(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.FinanceTargetManager#getFinanceTargetsByIdList(final Map idList)
     */
    public List getFinanceTargetsByMap(final Map mp) {
        return dao.getFinanceTargetsByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.FinanceTargetManager#saveFinanceTarget(FinanceTarget financeTarget)
     */
    public String saveFinanceTarget(FinanceTarget financeTarget) {
        return dao.saveFinanceTarget(financeTarget).toString();
    }
    
	public void saveFinanceTargets(FinanceTarget financeTargets[],int channelModelParam,String userName) {
//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModelParam==1) channelPull = true; 
		List carrierIdList = carrierManager.getOwnerCarrierIds("0",channelPull,userName);
//		System.out.println("carrierIdList.size()<<<<<<<<<<<<<<"+carrierIdList.size());
		dao.saveFinanceTargetInfos(financeTargets,carrierIdList);
	}

    /**
     * @see com.vriche.adrm.service.FinanceTargetManager#removeFinanceTarget(String id)
     */
    public void removeFinanceTarget(final String id) {
        dao.removeFinanceTarget(new Long(id));
    }
    
    public void removeFTarget(FinanceTarget financeTarget) {
    	 
        dao.removeFinanceTarget(financeTarget);
    }

     /**
     * @see com.vriche.adrm.service.FinanceTargetManager#removeFinanceTargets(String Map)
     */
    public void removeFinanceTargets(final Map mp) {
        dao.removeFinanceTargets(mp);
    }
	public Collection getFinanceTargetCarrierColl(List ls) {
		Collection coll = new ArrayList();
		for (Iterator it = ls.iterator(); it.hasNext();) {
			FinanceTarget fTarget = (FinanceTarget)it.next();
			
			Map map = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
			Carrier carrier = (Carrier)map.get(fTarget.getCarrierId().toString());
			String carrierName = carrier.getCarrierName();
			
			OrderDetailColl odColl = new OrderDetailColl();
			odColl.setAdvName(carrierName);
				odColl.setDay1(fTarget.getTarMonths()[0]);
				odColl.setDay2(fTarget.getTarMonths()[1]);
				odColl.setDay3(fTarget.getTarMonths()[2]);
				odColl.setDay4(fTarget.getTarMonths()[3]);
				odColl.setDay5(fTarget.getTarMonths()[4]);
				odColl.setDay6(fTarget.getTarMonths()[5]);
				odColl.setDay7(fTarget.getTarMonths()[6]);
				odColl.setDay8(fTarget.getTarMonths()[7]);
				odColl.setDay9(fTarget.getTarMonths()[8]);
				odColl.setDay10(fTarget.getTarMonths()[9]);
				odColl.setDay11(fTarget.getTarMonths()[10]);
				odColl.setDay12(fTarget.getTarMonths()[11]);
				odColl.setDay13(fTarget.getTarMonths()[12]);
				coll.add(odColl);
		}
		return coll;
	}
	
	public Collection getFinanceTargetRaioCarriers(String paramQueryString) {
//		List valuecoll = new ArrayList();
		String year = StringUtil.getNullValue(StringUtil.getParamFromUrl(paramQueryString,"year"),"");
		String months = StringUtil.getNullValue(StringUtil.getParamFromUrl(paramQueryString,"months"),"");
		String channelIds = StringUtil.getNullValue(StringUtil.getParamFromUrl(paramQueryString,"channelIds"),"");
		String customerIds = StringUtil.getNullValue(StringUtil.getParamFromUrl(paramQueryString,"customerIds"),"");
		String incomePurposeIds = StringUtil.getNullValue(StringUtil.getParamFromUrl(paramQueryString,"incomePurposeIds"),"");
	

		List allMonth = new ArrayList();
		Map mp =new HashMap();
		
		List customerIdList = new ArrayList();
        List incomePurposesList = new ArrayList();
        List monthIdList = new ArrayList();
        List channelIdList = new ArrayList();
        
        if(!StringUtils.isEmpty(months)){
     	   String[] ms = months.split(",");
     	   if(ms.length >0) CollectionUtils.addAll(monthIdList, ms);
        }  
        if(!StringUtils.isEmpty(channelIds)){
        	   String[] cs = channelIds.split(",");
         	   if(cs.length >0) CollectionUtils.addAll(channelIdList, cs);
        } 
       if(!StringUtils.isEmpty(customerIds)){
    	   String[] cs = customerIds.split(",");
     	   if(cs.length >0) CollectionUtils.addAll(customerIdList, cs);
       }
       if(!StringUtils.isEmpty(incomePurposeIds)){
    	   String[] ips = incomePurposeIds.split(",");
     	   if(ips.length >0) CollectionUtils.addAll(incomePurposesList, ips);
       }
    	Map keyMap = new HashMap();
    	mp.put("year",year);
    	mp.put("monthIdList",monthIdList);
    	mp.put("channelIdList",channelIdList);
    	mp.put("customerIdList",customerIdList);
    	mp.put("incomePurposeIdList",incomePurposesList);
    	
        List ls = dao.getFinanceTargetRaioCarriersByMap(mp);
        
        for(Iterator it = ls.iterator();it.hasNext();){
        	FusionChartObject fTarget = (FusionChartObject)it.next();
        	String chanId = fTarget.getId();
        	String chanName = fTarget.getLable();
        	String chanAlias = fTarget.getValue1();
        	String tDateYear = fTarget.getValue2();
        	String tDateMonth =fTarget.getValue3();
        	double rate = new Double(StringUtil.getNullValue(fTarget.getValue4(),"1"));
        	double income = new Double(StringUtil.toDouble(fTarget.getValue5()));
        	double upValue =  new Double(StringUtil.toDouble(income*rate));
        	double leavleValue = income - upValue;
        	
        	String key = chanId + tDateYear.toString() +tDateMonth.toString();
        	String name = chanName +"("+ chanAlias +")";

            FusionChartObject fObject = new FusionChartObject();
            fObject.setLable(name);
            fObject.setValue1(tDateMonth+"");
            fObject.setValue2(income+"");
            fObject.setValue3(rate+"");
            fObject.setValue4(upValue+"");
            fObject.setValue5(leavleValue+"");
			allMonth.add(fObject);
        }
    	

        return allMonth;
	}
	
	public List getFinanceTargets(String targetYear,String userName,String carrierId,int channelModelParam) {
		List allMonth = new ArrayList();
		Map mp =new HashMap();
		
		mp.put("targetDateYear",targetYear);

		//判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModelParam==1) channelPull = true; 
		List carrierIdList = carrierManager.getOwnerCarrierIds(carrierId,channelPull,userName);
		mp.put("carrierIdList",carrierIdList);

    	Map keyMap = new HashMap();
        List ls = dao.getFinanceTargetsByMap(mp);
        
        for(Iterator it = ls.iterator();it.hasNext();){
        	FinanceTarget fTarget = (FinanceTarget)it.next();
        	Long cId = fTarget.getCarrierId();				  //required
            Integer tDateYear = fTarget.getTargetDateYear(); 
           
            String key = cId.toString() + tDateYear.toString();
            Long chanId = fTarget.getCarrier().getChannelId() ;
            
            int i =fTarget.getTargetDateMonth().intValue()-1;
         
            if(!keyMap.containsKey(key)){
            	String[] tarMonths = new String[13]; 
            	
            	for(int j = 0;j < 12;j++){
            			if(j==i){
            				tarMonths[j] = fTarget.getTargetMoney().toString();
            			}else{
            				tarMonths[j] ="0";
            			}
            	}
            	
            	tarMonths[12]= fTarget.getTargetMoney().toString();
            	FinanceTarget financeT = new FinanceTarget();
            	financeT.setCarrierId(cId);
            	financeT.getCarrier().setChannelId(chanId) ;
            	financeT.setTargetDateYear(tDateYear);
            	financeT.setTarMonths(tarMonths);
            	keyMap.put(key,financeT);
            }else{
            		FinanceTarget financeT =(FinanceTarget)keyMap.get(key);
           	
           			String[] tarMonths = financeT.getTarMonths();
            		
            		tarMonths[i]  = fTarget.getTargetMoney().toString();
            		tarMonths[12] = String.valueOf((new Double(tarMonths[i]).doubleValue())+(new Double(tarMonths[12]).doubleValue()));
            		
            		financeT.setTarMonths(tarMonths);
            		keyMap.put(key,financeT);
            }
        }
    	
        CollectionUtils.addAll(allMonth,keyMap.values().iterator());
        Collections.sort(allMonth,new FinanceTargetComparator());
        return allMonth;
	}

	public FinanceTarget getFinanceTargetYear(FinanceTarget financeTarget) {
		List ls = dao.getFinanceTargetYear(financeTarget);
		FinanceTarget financeT = new FinanceTarget();
		int length = ls.size();
		int i=0;
		String[] tarMonths = new String[length];
		 for(Iterator it = ls.iterator();it.hasNext();){
	        	FinanceTarget fTarget = (FinanceTarget)it.next();
	        	
	            	tarMonths[i++] = fTarget.getTargetDateYear().toString();  
		 }
		 financeT.setTarMonths(tarMonths);
		 return financeT;
	}
	
	public FinanceTarget getCustomerYear(FinanceTarget financeTarget) {
		List ls = dao.getCustomerYear(financeTarget);
		FinanceTarget financeT = new FinanceTarget();
		int length = ls.size();
		int i=0;
		String[] tarMonths = new String[length];
		 for(Iterator it = ls.iterator();it.hasNext();){
	        	FinanceTarget fTarget = (FinanceTarget)it.next();
	        	
	            	tarMonths[i++] = fTarget.getTargetDateYear().toString();  
		 }
		 financeT.setTarMonths(tarMonths);
		 return financeT;
	}
	
	public List getCustomerYears(FinanceTarget financeTarget) {
		List ls = dao.getCustomerYear(financeTarget);
		
		List allYears = new ArrayList();
		
		 for(Iterator it = ls.iterator();it.hasNext();){
	        	FinanceTarget fTarget = (FinanceTarget)it.next();
	        	String year = fTarget.getTargetDateYear().toString();
	    
	        	allYears.add(year);
		 }
		 return allYears;
	}
	
	public List getFinanceTargetYears(FinanceTarget financeTarget) {
		List ls = dao.getFinanceTargetYear(financeTarget);
		
		List allYears = new ArrayList();
		
		 for(Iterator it = ls.iterator();it.hasNext();){
	        	FinanceTarget fTarget = (FinanceTarget)it.next();
	        	String year = fTarget.getTargetDateYear().toString();
	    
	        	allYears.add(year);
		 }
		 return allYears;
	}
//	客户年度对比统计
	public String getCustomerYearAnalyzeXml(int size,String type,String customerId,int channelModelParam,String theUser,String isPutYear,String isNotReturnValue,String purpose) {
		 List ls = getCustomerYearAnalyze(size,type,customerId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose);
		return FinanceTargetUtil.makeYearTargetGridXML(ls,size);
	}
	
	public List getCustomerYearAnalyze(int size,String type,String customerId,int channelModelParam,String userName,String putYear,String isNotReturnValue,String purpose){
		List allYear = new ArrayList();
		List ls = new ArrayList();
		Map mp =new HashMap();
		Map keyMap = new HashMap();
//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		if(channelModelParam==1) channelPull = true; 

		FinanceTarget fTarget = new FinanceTarget();
		 int minYear = getCustomerMinYear(fTarget,size);

		 mp.put("putYear",putYear);
		 List allYears = getCustomerYears(fTarget);
		 mp.put("allYears",allYears);
			
		 if(!customerId.equals("")&&customerId!=null)
	     mp.put("customerId",customerId);
		 
		 
	     	if(UserUtil.isUserOrderYearRel()) {
	     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(userName));
	     	}
		 
		 
		
		if(type.equals("1")){
			
			ls = dao.getCustomerYearRelPutAnalyze(mp);
		}
		if(type.equals("3")){
			ls = dao.getCustomerYearRelTimeAnalyze(mp);
		}

		
		if(type.equals("2")){

			List incomePurposeIdList = new ArrayList();
			CollectionUtils.addAll(incomePurposeIdList,purpose.split(","));
			
			mp.put("incomePurposeIdList",incomePurposeIdList);

			ls = dao.getCustomerYearRelIcomeAnalyze(mp);
		}
		
        
        for(Iterator it = ls.iterator();it.hasNext();){
        	FinanceTarget financeTarget = (FinanceTarget)it.next();
    		String customerName = financeTarget.getCarrierName();
    		
    		int i =financeTarget.getTargetDateYear().intValue()-minYear;
    		
    		if(!keyMap.containsKey(customerName)){
    			FinanceTarget financeT = new FinanceTarget();
    			String[] tarMoney = new String[size]; 
        		tarMoney[i] = financeTarget.getTargetMoney().toString();
        		financeT.setCarrierName(customerName);
        		financeT.setTarMonths(tarMoney);
        		keyMap.put(customerName,financeT);
    		}else{
    			FinanceTarget financeT =(FinanceTarget)keyMap.get(customerName);
       			String[] tarMoney = financeT.getTarMonths();
       			
       			tarMoney[i] = financeTarget.getTargetMoney().toString();
       					
    			financeT.setTarMonths(tarMoney);
    			keyMap.put(customerName,financeT);
    		}
        }
        CollectionUtils.addAll(allYear,keyMap.values().iterator());
		return allYear;
	}
	
	public int getCustomerMinYear(FinanceTarget financeTarget,int size){
		
		FinanceTarget fTarget = getCustomerYear(financeTarget);
		int min = new Integer(fTarget.getTarMonths()[0]).intValue();
		if(size>1){
			for(int i = 1;i<size;i++){
				int c = new Integer(fTarget.getTarMonths()[i]).intValue();
				min = min<c?min:c;;
			}
		}
		
		return min;
	}
	
	public String getYearTargetAnalyzeXml(int size,String type,String carrierId,int channelModelParam,String theUser,String isPutYear,String isNotReturnValue,String purpose) {
		 List ls = getYearTargetAnalyze(size,type,carrierId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose);
		
		 return FinanceTargetUtil.makeYearTargetGridXML(ls,size);
	}
	public List getYearTargetAnalyze(int size,String type,String carrierName,int channelModelParam,String theUser,String putYear,String isNotReturnValue,String purpose){
		List allYear = new ArrayList();
		List ls = new ArrayList();
		Map mp =new HashMap();
		Map keyMap = new HashMap();
		List lsValyes = new ArrayList();
		
		
//		判断是否分频道，值为1分，否则不分
//		boolean channelPull = false;
//		if(channelModelParam==1) channelPull = true; 

		FinanceTarget fTarget = new FinanceTarget();
		 int minYear = getMinYear(fTarget,size);

		 mp.put("putYear",putYear);
		 List allYears = getFinanceTargetYears(fTarget);
			mp.put("allYears",allYears);

			
			System.out.println("mp.get(allYears)<<<<<7777777777 333333333333333<<<<<<<<"+mp.get("allYears"));
			
	
		List carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
	 	mp.put("carrierIdList",carrierIdList2);		
			
		System.out.println("mp.get(allYears)<<<<<7777777777 333333333333333<<<<<<<<"+mp.get("carrierIdList"));

			
		
		if(type.equals("1")){
			ls = dao.getYearRelPutAnalyze(mp);
		}
		if(type.equals("4")){
			ls = dao.getYearRelTimeAnalyze(mp);
		}
		
//		List carrierIdList2 = carrierManager.getOwnerCarrierIds(carrierId,channelPull,userName);

		List carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
		mp.put("carrierIdList",carrierIdList);
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
     	}
//     	if(SysParamUtil.getUseCarrierAliname()){
//     		mp.put("useCarrierAliname","1");
//     	}
		
		
		if(type.equals("2")){
		
//			List carrierIdList2 = carrierManager.getOwnerCarrierIds(carrierId,channelPull,userName);
//			mp.put("carrierIdList",carrierIdList);
			List incomePurposeIdList = new ArrayList();
			CollectionUtils.addAll(incomePurposeIdList,purpose.split(","));
			
			mp.put("incomePurposeIdList",incomePurposeIdList);
//			System.out.println("mp.get(carrierIdList)<<<<<333333333333333<<<<<<<<"+mp.get("carrierIdList"));
			ls = dao.getYearRelIcomeAnalyze(mp);
		}
		if(type.equals("3")){
			
			ls = dao.getYearTargetsAnalyze(mp);
		}
		
		
		Map map = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
		
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();

        for(Iterator it = ls.iterator();it.hasNext();){
        	FinanceTarget financeTarget = (FinanceTarget)it.next();
        	String carrierkey = financeTarget.getCarrierId().toString();
        	Carrier carrier = (Carrier)map.get(carrierkey);
        	String carName = "";
        	if(carrierAlisname){
        		carName = carrier.getAliasName();
        	}else{
        		carName = carrier.getCarrierName();
        				}
        	
        	
        	String carrierkey2  = carName;
    		
        	if("".equals(carName)){
        		System.out.println("AliasName is empty <<<<<6666666666 333333333333333<<<<<<<<"+ carrierkey);
        				}
    		
        	
        	
        	
    		int i =financeTarget.getTargetDateYear().intValue()-minYear;
    		
    		if(!keyMap.containsKey(carrierkey2)){
    			FinanceTarget financeT = new FinanceTarget();
    			String[] tarMoney = new String[size]; 
        			tarMoney[i] = financeTarget.getTargetMoney().toString();
        		financeT.setCarrierName(carName);
        		financeT.setTarMonths(tarMoney);
        		financeT.setCarrierId(financeTarget.getCarrierId());
        		keyMap.put(carrierkey2,financeT);
//        		allYear.add(financeT);
    		}else{
    			FinanceTarget financeT =(FinanceTarget)keyMap.get(carrierkey2);
//    			allYear.remove(financeT);
       			String[] tarMoney = financeT.getTarMonths();
//       				for(int j = 1;j < size;j++){		
       					tarMoney[i] = financeTarget.getTargetMoney().toString();
//       				}
    			financeT.setTarMonths(tarMoney);
    			financeT.setCarrierId(financeTarget.getCarrierId());
    			
    			keyMap.put(carrierkey2,financeT);
//    			allYear.add(financeT);
    		}
        }
        CollectionUtils.addAll(allYear,keyMap.values().iterator());
//        CollectionUtils.addAll(allYear,lsValyes.iterator());
		return allYear;
	}
	   
	public int getMinYear(FinanceTarget financeTarget,int size){
		
		FinanceTarget fTarget = getFinanceTargetYear(financeTarget);
		int min = new Integer(fTarget.getTarMonths()[0]).intValue();
		if(size>1){
			for(int i = 1;i<size;i++){
				int c = new Integer(fTarget.getTarMonths()[i]).intValue();
				min = min<c?min:c;;
			}
		}
		
		return min;
	}
	
//	载体指标统计
	public String getCarrierTargetXML(String orgId,String userId,String year,String start,String end,String carrierId,int channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose,String customerId) {
//		List ls = getIndustryTypeProductByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,curUserName,isPrint);
		Map mp = getCarrierTargetByYear(orgId,userId,year,start,end,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId);
//		Map copy = new LinkedHashMap(mp);
		return FinanceTargetUtil.makeCarrierBasalGridXML(mp);
	}
	
	public Map getCarrierTargetByYear(String orgId,String userId,String targetDateYear,String startDate,String endDate,String carrierName,int channelModelParam,String theUser,String isPutYear,String isNotReturnValue,String purpose,String customerId) {
		
		Map targetMp =new HashMap();
		Map mp = new HashMap();
		List userIdList = new ArrayList();
//		List carrierList=new ArrayList();
		List targetDateMonthList = new ArrayList();
		
		List incomePurposeIdList = new ArrayList();
		boolean isNotReturnV = isNotReturnValue.equals("1")?true:false;
		CollectionUtils.addAll(incomePurposeIdList,purpose.split(","));
		mp.put("orgId",orgId);
		mp.put("isPutYear",isPutYear);
//		mp.put("startDate",startDate);
//		mp.put("endDate",endDate);
		mp.put("incomePurposeIdList",incomePurposeIdList);
		
		mp.put("targetDateYear",targetDateYear);
		
		
		mp.put("customerId",customerId);


		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
    		List ls = userManager.getOwnerUsersList(userRelsMap,theUser);
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}
		
//		List carrierIdList = carrierManager.getOwnerCarrierIds(carrierName,channelPull,theUser);
		List carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
		
		System.out.println("targetMp key>>>>>>>>>>>>>>>>>>>>>>>>22222222222  44444444  5555555>>>>>>>>>>>>>>>carrierIdList "+carrierIdList);
		
		mp.put("carrierIdList",carrierIdList);
		
		int start = Integer.parseInt(startDate.substring(4,6));
		int end = Integer.parseInt(endDate.substring(4,6));
		for(int i=start;i<end+1;i++){
			String month = new Integer(i).toString();
			targetDateMonthList.add(month);
		}
		
		mp.put("targetDateMonthList",targetDateMonthList);
		
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
     	}
     	
		//判断是否业务员平帐
        if(UserUtil.isSignUserBalance()){
        	mp.put("version",new Integer(1));
        }else{
        	mp.put("version",new Integer(0));
        }
		
        boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
        
        if(carrierAlisname){
        	mp.put("carrierAlisname","1");
        }else{
        	mp.put("carrierAlisname","0");
        }
        
        List ls = dao.getCarrierTargetsByMap(mp);
        
        for (Iterator it = ls.iterator(); it.hasNext();) {
			FinanceTarget obj = (FinanceTarget) it.next();
			Double targetMoney = obj.getTargetMoney();
			if(targetMoney == null) targetMoney = new Double(0);
//			String key = obj.getCarrierId()+obj.getTargetMonth();
			String key = obj.getCarrier().getCarrierName() +obj.getTargetMonth();
			
//			System.out.println("targetMp key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+key +">>>>>>>>>>>targetMoney "+targetMoney);
			
			targetMp.put(key,targetMoney);
		}

		Map incMap = incomeManager.getTargetIncome(mp);
		
//		List carrierIdList2 = carrierManager.getCarrierIdLists(carrierName,channelPull,theUser);
		List carrierIdList2 = CarrierUtil.getCarrierIds(carrierName,"2",theUser);
		
		System.out.println("targetMp key>>>>>>>>>>>>>>>>>>>>>>>>22222222222  44444444  5555555>>>>>>>>>>>>>>>targetMoney "+carrierIdList2);
		
		mp.put("carrierIdList",carrierIdList2);
		Map incomeMap = orderDayInfoManager.getCarrierIncomeByYear(mp);
		
		return getCarrierTargetByListDetails(carrierIdList,targetDateMonthList,targetMp,incomeMap,incMap,targetDateYear);
	}


	
	private Map getCarrierTargetByListDetails(List carrierList,List targetDateMonthList,Map targetMp,Map incomeMap,Map incMap,String targetDateYear){
		Map map = new LinkedHashMap();
		Map mapCarNames = new HashMap();
		Map mapCarrierBasal = new HashMap();
		Map mapTemp = new HashMap();
		
//		Map mapCarNames = carrierManager.getCarrierNameMap();
		
//		Map mapCarNames = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
		
		
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
		if(carrierAlisname){
			 mapCarNames =  carrierManager.getCarrierAlisNameMap();
		}else{
			 mapCarNames = carrierManager.getCarrierNameMap();
		}
		
		
//		System.out.println("getCarrierTargetByListDetails id>>>>>>>>>>>>>>>>>>>>56789  9999>>>>>>>>>>>>>>>> "+carrierList);
		
		for (Iterator it = carrierList.iterator();it.hasNext();){
//			Carrier carriers=(String) it.next();
			String parentId= (String) it.next();
			
//			System.out.println("carrierList id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+parentId);
			
			for (Iterator its = targetDateMonthList.iterator();its.hasNext();){
				 String month = (String) its.next();
				 String carrierName = (String)mapCarNames.get(parentId);
				 
			
				FinanceTarget financeTarget = new FinanceTarget();
				financeTarget.setCarrierId(new Long(parentId));
				financeTarget.setTargetMonth(month);
				
				
				Object target=targetMp.get(carrierName+month);
				
//				System.out.println("getCarrierTargetByListDetails FTarget>>>>>>6666666666 77777777 88888888>>>>>>>>>>>>>"+carrierName+month); 
				
				if(month.length()==1)month="0"+month;
//				System.out.println("parentId+month"+parentId+month);
				Object income = incomeMap.get(parentId+month);	
				Object objInc = incMap.get(parentId+month);
				Object objreturnValue = null;
				
				Double relTarget =(target == null)?new Double(0):(Double)target;
				Double relPut =(income == null)?new Double(0):(Double)income;
				Double relIncome =(objInc == null)?new Double(0):(Double)objInc;
				
				financeTarget.setTargetMoney(relTarget);
				financeTarget.setRelPut(relPut);
				financeTarget.setRelIncome(relIncome);
				financeTarget.setCarrierName(carrierName);
				
//				System.out.println("bbbbbbbbb relTarget>>>>>>>>>>>>>>>>>>>"+relTarget); 
				
				//求每个频道的合计
				
				getCarrierSum(financeTarget,mapCarrierBasal,carrierName,carrierAlisname,mapTemp);
				
				
//				System.out.println("ccccccccc FTarget>>>>>>>>>>>>>>>>>>>"+financeTarget.getTargetMoney()); 
				
	 
				financeTarget.setCarrierId(new Long(-1));
				

				if(map.containsKey(carrierName)){
					List ls2 = (List)map.get(carrierName);
					if(carrierAlisname){
//						System.out.println("==============carrierName+month========="+carrierName+Integer.parseInt(month)); 
						
						if(mapTemp.containsKey(carrierName+Integer.parseInt(month))){
							FinanceTarget FTarget =(FinanceTarget)mapTemp.get(carrierName+Integer.parseInt(month));
							FTarget.setRelPut(new Double(FTarget.getRelPut().doubleValue()+financeTarget.getRelPut().doubleValue()));
//							FTarget.setTargetMoney(FTarget.getTargetMoney().doubleValue()+financeTarget.getTargetMoney().doubleValue());
							FTarget.setRelIncome(new Double(FTarget.getRelIncome().doubleValue()+financeTarget.getRelIncome().doubleValue()));
//							System.out.println(">>>>>>>>>>>>>>>>>>>"+financeTarget.getCarrierId()); 
//							System.out.println("333333333 FTarget>>>>>>>>>>>>>>>>>>>"+FTarget.getTargetMoney().doubleValue()); 
						}else{
//							System.out.println("222222222 financeTarget >>>>>>>>>>>>>>>>>>>"+financeTarget.getTargetMoney()); 
							mapTemp.put(carrierName+Integer.parseInt(month),financeTarget);
							ls2.add(financeTarget);
							
						}
						
//						CollectionUtils.addAll(ls2,mapTemp.values().toArray());
						
//						FinanceTarget FTarget =(FinanceTarget)ls2.get(Integer.parseInt(month));
//						FTarget.setRelPut(FTarget.getRelPut().doubleValue()+financeTarget.getRelPut().doubleValue());
////						FTarget.setTargetMoney(FTarget.getTargetMoney().doubleValue()+financeTarget.getTargetMoney().doubleValue());
//						FTarget.setRelIncome(FTarget.getRelIncome().doubleValue()+financeTarget.getRelIncome().doubleValue());
					}else{
						ls2.add(financeTarget);
					}
					map.put(carrierName,ls2);
				}else{
					List ls2 = new ArrayList();
//					System.out.println("11111>>>>>>>>>>>>>>>>>>>"+financeTarget.getTargetMoney().doubleValue()); 
					
					ls2.add(financeTarget);
					mapTemp.put(carrierName+Integer.parseInt(month),financeTarget);
					map.put(carrierName,ls2);
				}
				
//				System.out.println("getCarrierTargetByListDetails FTarget>>>>>>6666666666 77777777 88888888>>>>>>>>>>>>>"+carrierName); 

				
			}
		}
	    
		map.put("mapCarrierBasal",mapCarrierBasal);

		return map;
	}
	public List getCarrierTargetPandect(String orgId,String userId,String year,String start,String end,String carrierId,int channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose,String customerId){
		List list = new ArrayList();
		Map map = getCarrierTargetByYear(orgId,userId,year,start,end,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId);
		Map mapCarrierBasal = (Map)map.get("mapCarrierBasal");

		double resultTotal[]= new double[3];
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			if(!key.equals("mapCarrierBasal")){
				FinanceTarget obj = (FinanceTarget)mapCarrierBasal.get(key);	
				
				double relIncome = obj.getRelIncome().doubleValue();
				double targetMoney = obj.getTargetMoney().doubleValue();
				double relPut = obj.getRelPut().doubleValue();
				
				resultTotal[0] += relPut;
				resultTotal[1] += relIncome;
				resultTotal[2] += targetMoney;
				
				String relPutScale =StringUtil.persentFormat(relPut,targetMoney);
				String relIncomeScale = StringUtil.persentFormat(relIncome,targetMoney);
				obj.setTargetMonth("");
				obj.setUsed(relPutScale);
				obj.setSumUsed(relIncomeScale);
				list.add(obj);
			}
		}
		if(map.size()>0){
			FinanceTarget FT = new FinanceTarget();
			FT.setCarrierName("合计:");
			FT.setTargetMonth("");
			FT.setRelPut(new Double(resultTotal[0]));
			FT.setRelIncome(new Double(resultTotal[1]));
			FT.setTargetMoney(new Double(resultTotal[2]));
			FT.setUsed(StringUtil.persentFormat(resultTotal[0],resultTotal[2]));
			FT.setSumUsed(StringUtil.persentFormat(resultTotal[1],resultTotal[2]));
//			iu.getIncomePublic().setUsedMoney(StringUtil.doubleFormat4(String.valueOf(resultTotal[1])));
			list.add(FT);
		}
		return list ;
	}
	private void getCarrierSum(FinanceTarget fTarget,Map mapCarrierBasal,String carrierName,boolean carrierAlisname,Map mapTemp){
//		String key = fTarget.getCarrierId().toString();
		String key = fTarget.getCarrierName();
		Object obj  = mapCarrierBasal.get(key);
		
		if(obj == null) {
			FinanceTarget financeTarget =  new FinanceTarget();
			
			financeTarget.setCarrierName(carrierName);
			financeTarget.setRelIncome(fTarget.getRelIncome());
			financeTarget.setRelPut(fTarget.getRelPut());
			financeTarget.setTargetMoney(fTarget.getTargetMoney());
			mapCarrierBasal.put(key,financeTarget);
//			System.out.println("111111111111111111111>>>>>>>>>>>>>>>>>>>"+financeTarget.getTargetMoney()); 
			
		}else{
			
			FinanceTarget financeTarget =(FinanceTarget)obj;
			double targetDate = financeTarget.getTargetMoney().doubleValue();
			double relIncome = financeTarget.getRelIncome().doubleValue();
			double relput = financeTarget.getRelPut().doubleValue();
			
//			financeTarget.setTargetMoney(new Double(targetDate+fTarget.getTargetMoney().doubleValue()));
			
			if(!carrierAlisname){
//				System.out.println("22222222222222222>>>>>>>>>>>>>>>>>>>"+financeTarget.getTargetMoney()); 
				financeTarget.setTargetMoney(new Double(targetDate+fTarget.getTargetMoney().doubleValue()));
			}else{
				if(!mapTemp.containsKey(carrierName+Integer.parseInt(fTarget.getTargetMonth()))){
//					System.out.println("33333333333333333333333>>>>>>>>>>>>>>>>>>>"+financeTarget.getTargetMoney()); 
//					System.out.println("==============carrierName+financeTarget.getTargetMonth()========="+carrierName+fTarget.getTargetMonth()); 
					financeTarget.setTargetMoney(new Double(targetDate + fTarget.getTargetMoney().doubleValue()));
				}
			}
			
			financeTarget.setRelIncome(new Double(relIncome+fTarget.getRelIncome().doubleValue()));
			
			financeTarget.setRelPut(new Double(relput+fTarget.getRelPut().doubleValue()));
			
			mapCarrierBasal.put(key,financeTarget);
			
//			System.out.println("444444444444444444>>>>>>>>>>>>>>>>>>>"+financeTarget.getTargetMoney()); 
			
		}
	}

//	报表打印
	public List getCarrierTargetByList(String userId,String targetDateYear,String startDate,String endDate,String carrierId,int channelModelParam,String curUserName,String isPutYear,String isNotReturnValue,String purpose) {
	
		
		Map targetMp =new HashMap();
		Map mp = new HashMap();
		List userIdList = new ArrayList();
		List carrierList=new ArrayList();
		List targetDateMonthList = new ArrayList();
		
		List incomePurposeIdList = new ArrayList();
		boolean isNotReturnV = isNotReturnValue.equals("1")?true:false;
		CollectionUtils.addAll(incomePurposeIdList,purpose.split(","));

		mp.put("isPutYear",isPutYear);
//		mp.put("startDate",startDate);
//		mp.put("endDate",endDate);
		mp.put("incomePurposeIdList",incomePurposeIdList);
		
		mp.put("targetDateYear",targetDateYear);

		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
    		List ls = userManager.getOwnerUsersList(userRelsMap,curUserName);
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
    	}
		
//		List carrierIdList = carrierManager.getOwnerCarrierIds(carrierId,channelPull,curUserName);
		List carrierIdList = CarrierUtil.getCarrierIds(carrierId,"1",curUserName);
		mp.put("carrierIdList",carrierIdList);
		
		int start = Integer.parseInt(startDate.substring(4,6));
		int end = Integer.parseInt(endDate.substring(4,6));
		for(int i=start;i<end+1;i++){
			String month = new Integer(i).toString();
			targetDateMonthList.add(month);
		}
		
		mp.put("targetDateMonthList",targetDateMonthList);
		
        List ls = dao.getCarrierTargetsByMap(mp);
        for (Iterator it = ls.iterator(); it.hasNext();) {
			FinanceTarget obj = (FinanceTarget) it.next();
			Double targetMoney = obj.getTargetMoney();
			
			if(targetMoney == null) targetMoney = new Double(0);
			String key = obj.getCarrierId()+obj.getTargetMonth();
			targetMp.put(key,targetMoney);
		}

		Map incMap = incomeManager.getTargetIncome(mp);
		
		
//		List carrierIdList2 = carrierManager.getCarrierIdLists(carrierId,channelPull,curUserName);
		List carrierIdList2 = CarrierUtil.getCarrierIds(carrierId,"1",curUserName);
		mp.put("carrierIdList",carrierIdList2);
		Map incomeMap = orderDayInfoManager.getCarrierIncomeByYear(mp);
		
		return getCarrierTargetByListDetail(carrierList,targetDateMonthList,targetMp,incomeMap,incMap);
	}


	
	private List getCarrierTargetByListDetail(List carrierList,List targetDateMonthList,Map targetMp,Map incomeMap,Map incMap){
		Map map = new HashMap();
		Map mapCarNames = new HashMap();
		Map mapCarrierBasal = new HashMap();
		Map mapTemp = new HashMap();
		List allList=new ArrayList();
//		Map mapCarNames = carrierManager.getCarrierNameMap();
		
//		Map mapCarNames = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL_MAP);
		
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
		if(carrierAlisname){
			 mapCarNames =  carrierManager.getCarrierAlisNameMap();
		}else{
			 mapCarNames = carrierManager.getCarrierNameMap();
		}
		
		

		for (Iterator it = carrierList.iterator();it.hasNext();){
			Carrier carriers=(Carrier) it.next();
			String parentId=carriers.getId().toString();
			for (Iterator its = targetDateMonthList.iterator();its.hasNext();){
				 String month=(String) its.next();
			
				FinanceTarget financeTarget = new FinanceTarget();
				financeTarget.setCarrierId(new Long(parentId));
				financeTarget.setTargetMonth(month);
				Object target=targetMp.get(parentId+month);
				if(month.length()==1)month="0"+month;
	//			System.out.println("parentId+month"+parentId+month);
				String carrierName = (String)mapCarNames.get(parentId);
				
	
				
				
				
				Object income = incomeMap.get(parentId+month);	
				Object objInc = incMap.get(parentId+month);
				Object objreturnValue = null;
				
				Double relTarget =(target == null)?new Double(0):(Double)target;
				Double relPut =(income == null)?new Double(0):(Double)income;
				Double relIncome =(objInc == null)?new Double(0):(Double)objInc;
				
				financeTarget.setTargetMoney(relTarget);
				financeTarget.setRelPut(relPut);
				financeTarget.setRelIncome(relIncome);
				financeTarget.setCarrierName(carrierName);
				
				//求每个频道的合计
				getCarrierSum(financeTarget,mapCarrierBasal,carrierName,carrierAlisname,mapTemp);
	
				financeTarget.setCarrierId(new Long(-1));
				
				if(map.containsKey(carrierName)){
					List ls2 = (List)map.get(carrierName);
					ls2.add(financeTarget);
					map.put(carrierName,ls2);
				}else{
					List ls2 = new ArrayList();
					ls2.add(financeTarget);
					map.put(carrierName,ls2);
				}
			}
		}
		

		double resultTotal[]= new double[3];
//		CollectionUtils.addAll(allList,map.values().iterator());
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String)it.next();
			List cutList = (List)map.get(key);
			
//			Carrier carrier = (Carrier)mapCarNames.get(key);
//			String carrierName = carrier.getCarrierName();
//			cutP.setCarrierId(new Long(key));
			FinanceTarget financeTarget = (FinanceTarget)mapCarrierBasal.get(key);
			financeTarget.setCarrierName("");
			financeTarget.setTargetMonth("小计");
			
				for(Iterator itl = cutList.iterator();itl.hasNext();){
					FinanceTarget cProduct =  (FinanceTarget)itl.next();
					double relIncome = cProduct.getRelIncome().doubleValue();
					double relRut = cProduct.getRelPut().doubleValue();
					double targetMoney = cProduct.getTargetMoney().doubleValue();
					cProduct.setCarrierName("");
					cProduct.setTargetMonth(StringUtil.converNum2cnMonth(cProduct.getTargetMonth()));
					cProduct.setUsed(StringUtil.persentFormat(relRut,targetMoney));
					cProduct.setSumUsed(StringUtil.persentFormat(relIncome,targetMoney));
					
					resultTotal[0] += relRut;
					resultTotal[1] += relIncome;
					resultTotal[2] += targetMoney;
				}
				FinanceTarget cutP =  (FinanceTarget)cutList.get(0);
				
//				Carrier carrier = (Carrier)mapCarNames.get(key);
				
//				String carrierName = carrier.getCarrierName();
				String carrierName = (String)mapCarNames.get(key);
				
				cutP.setCarrierName(carrierName);
				financeTarget.setUsed(StringUtil.persentFormat(financeTarget.getRelPut().doubleValue(),financeTarget.getTargetMoney().doubleValue()));
				financeTarget.setSumUsed(StringUtil.persentFormat(financeTarget.getRelIncome().doubleValue(),financeTarget.getTargetMoney().doubleValue()));
			cutList.add(financeTarget);
			CollectionUtils.addAll(allList,cutList.iterator());
		}
//		计算合计：
		if(map.size()>0){
			FinanceTarget FT = new FinanceTarget();
			FT.setCarrierName("合计:");
			FT.setTargetMonth("");
			FT.setRelPut(new Double(resultTotal[0]));
			FT.setRelIncome(new Double(resultTotal[1]));
			FT.setTargetMoney(new Double(resultTotal[2]));
			FT.setUsed(StringUtil.persentFormat(resultTotal[0],resultTotal[2]));
			FT.setSumUsed(StringUtil.persentFormat(resultTotal[1],resultTotal[2]));
//			iu.getIncomePublic().setUsedMoney(StringUtil.doubleFormat4(String.valueOf(resultTotal[1])));
			allList.add(FT);
		}

		return allList;
	}
	
	
	public Collection  getArrearsColl(String querString,String type){
		System.out.println("getArrearsColl>>>>>>querString>>>>>>>>>>>>>"+querString); 
		Map mp = StringUtil.convertQueryStringtoMap(querString);
//		System.out.println("getArrearsColl>>>>>>>>>>>>>>>>>>>"+mp.get("year")); 
		String orgId = String.valueOf(mp.get("orgId"));
		String carrierIds = String.valueOf(mp.get("carrierIds"));
		String loginUser = String.valueOf(mp.get("loginUser"));
		String cutCates = String.valueOf(mp.get("cutCates"));
		
		List carrierIdList = CarrierUtil.getCarrierIds(carrierIds,"2",loginUser);
		if(carrierIdList.size()>0)mp.put("carrierIdList",carrierIdList);

    	List lsCutCates = UserUtil.getCustomerCateByUser(loginUser, cutCates);
    	if(lsCutCates.size()>0)mp.put("customerCates",lsCutCates);
    	
    	
	  	List userls2 = UserUtil.getUserIdList(orgId);
	  	
	  	System.out.println("getArrearsColl>>>>>>userls2.size>>>>>>666666666666666666 55555555555555555 44444444444444>>>>>>>"+userls2.size()); 
	  	
	  	if(userls2.size()>0)  	mp.put("userIdList2",userls2);
    	
	 
		
		List ls = dao.getArrearsList(mp);
		List ls2 = new ArrayList();
		
		int cols = 4;
		
		for(Iterator itl = ls.iterator();itl.hasNext();){
			OrderPublic orderPublic = (OrderPublic)itl.next();
			FusionChartObject fObject = new FusionChartObject();
			for(int i=1;i<cols+1;i++){
				switch(i){
				
					case 1:
						fObject.setLable(orderPublic.getCustomerName());break;
					case 2:
						fObject.setValue1(StringUtil.doubleFormat2(orderPublic.getMoneyRealpay()));break;
					case 3:
						fObject.setValue2(StringUtil.doubleFormat2(orderPublic.getMoneyIn()));break;
					case 4:
						double v1 = Double.parseDouble(StringUtil.getNullValue(orderPublic.getMoneyRealpay(),"0"));
						double v2 = Double.parseDouble(StringUtil.getNullValue(orderPublic.getMoneyIn(),"0"));
						fObject.setValue3(StringUtil.doubleFormat2(new Double(v1-v2)));break;		
					default :
				}
			}
			ls2.add(fObject);
		}		
		Collection coll  = ls2;
		
		return coll;
	}
	
	
	
	public String  getArrearsXML(String querString){
		

//		System.out.println("getArrearsXML>>>>>>querString>>>>>>>>>>>>>"+querString); 
		
		List ls = (List)this.getArrearsColl(querString,"date");
		
	    String[] sum = new String[3];
	    double[] sumDb = new double[3];

		for(Iterator itl = ls.iterator();itl.hasNext();){
			FusionChartObject fObject = (FusionChartObject)itl.next();
			
			sumDb[0] =  sumDb[0] + (new Double(fObject.getValue1())).doubleValue();
			sumDb[1] =  sumDb[1] + (new Double(fObject.getValue2())).doubleValue();
			sumDb[2] =  sumDb[2] + (new Double(fObject.getValue3())).doubleValue();
	    	
		}
		sum[0] =  StringUtil.doubleFormat2(new Double(sumDb[0]));
		sum[1] =  StringUtil.doubleFormat2(new Double(sumDb[1]));              
		sum[2] =  StringUtil.doubleFormat2(new Double(sumDb[2]));
		

		return makeGridFormXML2(ls,sum);
	}
	
	
	
	 public  String makeGridFormXML2(List pageList , String[] sum){
		   


			StringBuffer sb = new StringBuffer();

			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<rows>");  
			
//				sb.append("<head>"); 
//				sb.append("<afterInit>"); 
//				sb.append("<call command=\"attachHeader\">");
////				sb.append("<param> ,合计,"+ total_count +" ,,,,,"+ sum[0] +","+ sum[1] +"  ,,,,,,, ,</param>");
//				
//				String sss ="合计";
//
//				sb.append("<param>"+ sss +","+ sum[0] +","+ sum[1] +","+ sum[2] +"</param>");
//				sb.append("<param>color:black;,color:black;,color:black;,color:black;,color:black;</param>");
//				sb.append("<param>_aFoot</param>");
//				sb.append("</call>");
//				sb.append("</afterInit>");
//				sb.append("</head>"); 


					
            int i = 0;
			
			for(Iterator it = pageList.iterator();it.hasNext();){
				
				FusionChartObject fObject = (FusionChartObject)it.next();

//                String name = fObject.getLable();
//				double moneyPay = (new Double(fObject.getValue1())).doubleValue();
//				double moneyIn = (new Double(fObject.getValue2())).doubleValue();
//				double relMoney = moneyPay - moneyIn;


//				订单编号,客户名称,应付日期,应付金额,已付金额,欠款金额"
//				if(relMoney>0){
					sb.append("<row  id=\""+ (i++)  +"\"" +">");
					sb.append("<cell><![CDATA["+  fObject.getLable()  +"]]></cell>");
					sb.append("<cell><![CDATA["+ fObject.getValue1()  +"]]></cell>");
					sb.append("<cell><![CDATA["+ fObject.getValue2()   +"]]></cell>");
					sb.append("<cell><![CDATA["+ fObject.getValue3()   +"]]></cell>");
					sb.append("</row>");
//				}
				
			 }
			
			
			
			sb.append("<row  id=\""+ (i++)  +"\"" +">");
			sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(sum[0]))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(sum[1] ))  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(sum[2] ))  +"]]></cell>");
			sb.append("</row>");
		

			
			sb.append("</rows>");
			
			
//			 System.out.println("getContractPaymentFormPage>>>>>>>>>>sb.toString()>>>>>>>>>>>>>>>>>>>:"+sb.toString());
			
			return sb.toString();
	 }
	 
	 
	 

	public Collection getIncomeRelpayQiank(String querString) {
		// TODO Auto-generated method stub
		
		Collection col = new ArrayList();

		Map mp = StringUtil.convertQueryStringtoMap(querString);
		
		String orgId = String.valueOf(mp.get("orgId"));
		String year = String.valueOf(mp.get("year"));
		String month = String.valueOf(mp.get("month"));
//		int cols = Integer.parseInt(String.valueOf(mp.get("channelCout")));
		
		String startDate = year+month+"01";
		String endDate ="";
		try {
			endDate =  DateUtil2.getYearMonthEndDay2(Integer.parseInt(year),Integer.parseInt(month));
			System.out.println(">>>>>>>>>lastDay>>>>>>>>>>>>>>>>>>:"+endDate);
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String startDateSum = year+"0101";
		String endDateSum = endDate;
		
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("startDateSum",startDateSum);
		mp.put("endDateSum",endDateSum);
		
		//收入任务
//		Map channelTargetMap = dao.getChannelTarget(mp); //本期

		String lables[] ={"","收入任务数","实际到款额","实到款任务完成率","载播量","载播量任务完成率","载播量到款额","载播量实际到款率","载播量超欠款率","合同应收额","合同实收额","合同欠款率","收入任务数","实际到款额","实到款任务完成率","载播量","载播量任务完成率","载播量到款额","载播量实际到款率","载播量超欠款率"};
	  	
	   
		for(int b = 1;b<20;b++){
			
			FusionChartObject fObject = new FusionChartObject();
			
			String empty = "";
			fObject.setValue1(empty);
			fObject.setValue2(empty);
			fObject.setValue3(empty);
			fObject.setValue4(empty);
			fObject.setValue5(empty);
			fObject.setValue6(empty);
			fObject.setValue7(empty);
			fObject.setValue8(empty);
			fObject.setValue9(empty);
			fObject.setValue10(empty);
			fObject.setValue11(empty);
			fObject.setValue12(empty);
			fObject.setValue13(empty);
			fObject.setSum1(empty);
			
			if(b ==1 || b==2 || b==4 || b==6 || b==9|| b==10 || b==12  || b==13 || b==15 || b==17 ){
				
				Map channelTargetMap = new HashMap();
				Iterator itChannleTarSum;
				if(b == 1){
					Map mp1 = new HashMap();
					mp1.put("year",year);
					mp1.put("monthEnd",month);
					channelTargetMap = dao.getChannelTarget(mp1); //累计		
					fObject.setLable(lables[b]);
				}
				
				if(b == 2){
					Map mp1 = new HashMap();
					mp1.put("startDate",startDateSum);
					mp1.put("endDate",endDateSum);
					channelTargetMap = dao.getChannelIncome(mp1); //累计		
					fObject.setLable(lables[b]);
				}
				
				if(b == 4){
					Map mp1 = new HashMap();
					mp1.put("year",year);
					mp1.put("startDate",startDateSum);
					mp1.put("endDate",endDateSum);
					channelTargetMap = dao.getChannelRealPay(mp1); //累计		
					fObject.setLable(lables[b]);
				}
				
				if(b == 6){
					Map mp1 = new HashMap();
					mp1.put("year",year);
					mp1.put("startDate",startDateSum);
					mp1.put("endDate",endDateSum);				
//					System.out.println(">>>>>>>>>startDateSum>>>>>>>>>>>>>>>>>>:"+startDateSum);
//					System.out.println(">>>>>>>>>endDateSum>>>>>>>>>>>>>>>>>>:"+endDateSum);
					
					channelTargetMap = dao.getChannelRealPuton(mp1); //累计		
					fObject.setLable(lables[b]);
				}
	
				if(b == 9){
					Map mp1 = new HashMap();
					mp1.put("year",year);
					mp1.put("startDate",startDateSum);
					mp1.put("endDate",endDateSum);
					channelTargetMap = dao.getChannelOrderRealPay(mp1); //累计		
					fObject.setLable(lables[b]);
				}
				
				if(b == 10){
					Map mp1 = new HashMap();
					mp1.put("year",year);
					mp1.put("startDate",startDateSum);
					mp1.put("endDate",endDateSum);
					channelTargetMap = dao.getChannelOrderRealPuton(mp1); //累计		
					fObject.setLable(lables[b]);
				}
		
				
				if(b == 12){
					channelTargetMap = dao.getChannelTarget(mp); //本期
					fObject.setLable(lables[b]);
				}
				
				if(b == 13){
					channelTargetMap = dao.getChannelIncome(mp); //本期
					fObject.setLable(lables[b]);
				}
				
				if(b == 15){
					channelTargetMap = dao.getChannelRealPay(mp); //本期
					fObject.setLable(lables[b]);
				}
				
				if(b == 17){
					channelTargetMap = dao.getChannelRealPuton(mp); //本期
					fObject.setLable(lables[b]);
				}
				
				
				itChannleTarSum = channelTargetMap.keySet().iterator();
				
//				System.out.println("channelTargetSumMap>>>>>>>>>>sb.toString()>>>>>>>>>>>>>>>>>>>:"+channelTargetSumMap.size());
				
				double channleTarSum = 0;
				
//				FusionChartObject fObject = new FusionChartObject();
			
				
				while(itChannleTarSum.hasNext()){
					
					Long keyStr = (Long)itChannleTarSum.next();
					
					int key = Integer.parseInt(keyStr.toString());
					
					FinanceTarget financeTarget = (FinanceTarget)channelTargetMap.get(keyStr);
					
					double targMoneyDouble =  new Double(StringUtil.getNullValue(financeTarget.getTargetMoney(),"0")).doubleValue()/10000;
					
					channleTarSum += targMoneyDouble;

//					System.out.println("key>>>>>>>>>>sb.toString()>>>>>>>>>>>>>>>>>>>:"+key);
					
					
					String targMoney = StringUtil.doubleFormat4(targMoneyDouble);
					

					
					switch(key){
						
							case 1:
								fObject.setValue1(targMoney);break;
							case 2:
								fObject.setValue2(targMoney);break;
							case 3:
								fObject.setValue3(targMoney);break;
							case 4:
								fObject.setValue4(targMoney);break;
							case 5:
								fObject.setValue5(targMoney);break;
							case 6:
								fObject.setValue6(targMoney);break;
							case 7:
								fObject.setValue7(targMoney);break;
							case 8:
								fObject.setValue8(targMoney);break;											
							case 9:
								fObject.setValue9(targMoney);break;
							case 10:
								fObject.setValue10(targMoney);break;
							case 11:
								fObject.setValue11(targMoney);break;
							case 12:
								fObject.setValue12(targMoney);break;
							case 13:
								fObject.setValue13(targMoney);break;
											
							default :
						}

				}
			
				
//				channleTarSum = channleTarSum;
				
				fObject.setSum1(StringUtil.doubleFormat4(channleTarSum));				
			}
			
			if(b == 3){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[0];
				FusionChartObject fObjectB =  (FusionChartObject)objs[1];
				getRate(fObject,fObjectA,fObjectB,1);
			}
			
			if(b == 5){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[0];
				FusionChartObject fObjectB =  (FusionChartObject)objs[3];
				getRate(fObject,fObjectA,fObjectB,1);
			}
			
			if(b == 7){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[3];
				FusionChartObject fObjectB =  (FusionChartObject)objs[5];
				getRate(fObject,fObjectA,fObjectB,1);
			}
			
			if(b == 8){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[3];
				FusionChartObject fObjectB =  (FusionChartObject)objs[5];
				getRate(fObject,fObjectA,fObjectB,2);
			}
			
			if(b == 11){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[8];
				FusionChartObject fObjectB =  (FusionChartObject)objs[9];
				getRate(fObject,fObjectA,fObjectB,2);
			}
			
			if(b == 14){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[11];
				FusionChartObject fObjectB =  (FusionChartObject)objs[12];
				getRate(fObject,fObjectA,fObjectB,1);
			}
			
			if(b == 16){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[11];
				FusionChartObject fObjectB =  (FusionChartObject)objs[14];
				getRate(fObject,fObjectA,fObjectB,1);
			}
		
			if(b == 18){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[14];
				FusionChartObject fObjectB =  (FusionChartObject)objs[16];
				getRate(fObject,fObjectA,fObjectB,1);
			}
		
			if(b == 19){
				fObject.setLable(lables[b]);
				Object[] objs = col.toArray(new FusionChartObject[col.size()]);
				FusionChartObject fObjectA = (FusionChartObject)objs[14];
				FusionChartObject fObjectB =  (FusionChartObject)objs[16];
				getRate(fObject,fObjectA,fObjectB,2);
			}			
			col.add(fObject);
		}
		

		return col;
	}
	
	private  FusionChartObject getRate(FusionChartObject tar,FusionChartObject a,FusionChartObject b,int model){
		
		
		for (int i =1;i<9;i++){
			
		if(i ==1){
			
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue1(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue1(),"0"));
			am = am == 0?1:am;String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue1(rate);		
		}
		if(i ==2){
	
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue2(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue2(),"0"));
			am = am == 0?1:am;String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue2(rate);		
		}
			
		if(i ==3){
			
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue3(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue3(),"0"));
			am = am == 0?1:am;String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue3(rate);		
		}
		
		if(i ==4){
		
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue4(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue4(),"0"));
			am = am == 0?1:am;String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue4(rate);		
		}
		
		if(i ==5){
		
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue5(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue5(),"0"));
			am = am == 0?1:am;String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue5(rate);		
		}
		
		if(i ==6){
		
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue6(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue6(),"0"));
			String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0 && am>0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue6(rate);		
		}
		
		if(i ==7){
		
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue7(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue7(),"0"));
			String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0 && am>0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue7(rate);		
		}
		
		if(i ==8){
	
			double am = Double.parseDouble(StringUtil.getNullValue(a.getValue8(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getValue8(),"0"));
			am = am == 0?1:am;String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setValue8(rate);		
		}
		

		
		}
		
	
			double am = Double.parseDouble(StringUtil.getNullValue(a.getSum1(),"0") );
			double bm = Double.parseDouble(StringUtil.getNullValue(b.getSum1(),"0"));
			am = am == 0?1:am;bm = am == 0?100:bm;String rate = "";
			if(model ==2) bm = am -bm;
			if(bm >0) rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
//			rate = StringUtil.doubleFormat3(new Double(bm/am*100))+"%";
			tar.setSum1(rate);		
		
		
		
		
		return tar;
	}
	
	

	public Object[] getIncomeRelpayQiankArray(String querString) {
		// TODO Auto-generated method stub
		Collection col = getIncomeRelpayQiank(querString);
		FusionChartObject[] a =new FusionChartObject[col.size()];
		return col.toArray(a);
	}




	
}
