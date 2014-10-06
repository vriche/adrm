
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.displaytag.util.CollectionUtil;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.IncomeDao;
import com.vriche.adrm.dao.IncomeUsedDao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.IncomeUsedManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.CustomerUtil;
import com.vriche.adrm.util.RequestUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class IncomeUsedManagerImpl extends BaseManager implements IncomeUsedManager {
    private IncomeUsedDao dao;
    private IncomeDao incomedao;
    private ContractPaymentManager contractPaymentManager;
    private CarrierManager carrierManager;
    private CarrierDao carrierDao;
    private UserManager userManager;

    
	/**
	 * @param carrierDao The carrierDao to set.
	 */
	public void setCarrierDao(CarrierDao carrierDao) {
		this.carrierDao = carrierDao;
	}
	public void setContractPaymentManager(ContractPaymentManager contractPaymentManager) {
		this.contractPaymentManager = contractPaymentManager;
	}
    public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setIncomeUsedDao(IncomeUsedDao dao) {
        this.dao = dao;
    }

	public void setIncomedao(IncomeDao incomedao) {
		this.incomedao = incomedao;
	}
    /**
     * @see com.vriche.adrm.finance.service.IncomeUsedManager#getIncomeUsedsByIdList(final Map idList)
     */
    public List getIncomeUsedsByIdList(final Map idList) {
        return dao.getIncomeUsedsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.finance.service.IncomeUsedManager#getIncomeUseds(com.vriche.adrm.finance.model.IncomeUsed)
     */
    public List getIncomeUseds(final IncomeUsed incomeUsed) {
        return dao.getIncomeUseds(incomeUsed);
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomeUsedManager#getIncomeUsed(String id)
     */
    public IncomeUsed getIncomeUsed(final String id) {
        return dao.getIncomeUsed(new Long(id));
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomeUsedManager#saveIncomeUsed(IncomeUsed incomeUsed)
     */
    public void saveIncomeUsed(IncomeUsed incomeUsed) {
        dao.saveIncomeUsed(incomeUsed);
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomeUsedManager#removeIncomeUsed(String id)
     */
    public void removeIncomeUsed(final String id) {
        dao.removeIncomeUsed(new Long(id));
    }

     /**
     * @see com.vriche.adrm.finance.service.IncomeUsedManager#removeIncomeUseds(String Map)
     */
    public void removeIncomeUseds(final Map idList) {
        dao.removeIncomeUseds(idList);
    }
    
	public List getIncomeDetail(String customerId,String version) {
		// TODO Auto-generated method stub

		Map mp = new HashMap();
		Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER);
		
		if(customerId!=null) mp.put("customerId",customerId);
		
		mp.put("version",version);
		
		
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
//		if(carrierAlisname){
//			mp.put("carrierAlisname","1");
//		}else{
//			mp.put("carrierAlisname","0");
//		}
		
		
		
		
     	if(UserUtil.isUserOrderYearRel()) {
     		String loginUser = UserUtil.getCurrentPrincipalUser();
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
     	}
     	
     	
//     	List incomePurposeIdList = new ArrayList();
//		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
//		
//		if(financialAuditSwitch){
//			List OrderCategoryIdList  = SysParamUtil.getFitterOrderSubCates(version);
//			if(OrderCategoryIdList.size()== 0) OrderCategoryIdList.add("-1");
//			mp.put("OrderCategoryIdList",OrderCategoryIdList);
//		}
//
//		mp.put("incomePurposeIdList",incomePurposeIdList);    	
     	
     	
     	
     	
     	
		
//		System.out.println("dao.getIncomeDetail(mp)    "+dao.getIncomeDetail(mp).size()) ;
		List incomeUsedList = dao.getIncomeDetail(mp);
		
		
		List newList = new ArrayList();
		List newsList = new ArrayList();
		List nameList = new ArrayList();
//		List finalList = new ArrayList();
		//incomecodes中没有相同的发票号
		List incomecodes = new ArrayList();
		List cName=new ArrayList();
		List iMoney=new ArrayList();
		List carrierName=new ArrayList();
		 
		 
		 List  ls = fullincomeUsedList(incomeUsedList,carrierMap,carrierAlisname);
		 

		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			if(!incomecodes.contains(incomeUsed.getIncomeCode()))
				incomecodes.add(incomeUsed.getIncomeCode());
//			getSameIncomeCode(incomeUsed.getIncomeCode(),ls,newList);
		}
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			if(!cName.contains(incomeUsed.getCustomerName()))
				cName.add(incomeUsed.getCustomerName());
//			getSameIncomeCode(incomeUsed.getIncomeCode(),ls,newList);
		}
//		System.out.println("incomecodes    "+incomecodes.size()) ;
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			if(!iMoney.contains(incomeUsed.getIncomeMoney()))
				iMoney.add(incomeUsed.getIncomeMoney());
		}
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			if(!carrierName.contains(incomeUsed.getIncomePublic().getCarrierName()))
				carrierName.add(incomeUsed.getIncomePublic().getCarrierName());
			
////			getSameIncomeCode(incomeUsed.getIncomeCode(),ls,newList);
		}
		/////////////////////////////////////////////////////////////
		
		for(Iterator it = incomecodes.iterator();it.hasNext();){
			String incomeCode = (String)it.next();
		    for(Iterator its = carrierName.iterator();its.hasNext();){
			    String carriername = (String)its.next();
			    getSameCarrierName(carriername,incomeCode,ls,newsList);
		    }
		}

		for(Iterator it = incomecodes.iterator();it.hasNext();){
			String incomeCode = (String)it.next();
			getSameIncomeCode(incomeCode,newsList,newList);
		}
		for(Iterator it = cName.iterator();it.hasNext();){
			String cname = (String)it.next();
			getSameCustomerName(cname,newList,nameList);
		}
		
		
		
		double sum=0;
//		double sumMoneyIn=0;
//		double MoneyPull=0;
//		long ContractId=0;
		
		for(Iterator it = nameList.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			String inMoney = incomeUsed.getIncomeMoney().equals("")?"0":incomeUsed.getIncomeMoney();
			incomeUsed.setIncomeMoney( StringUtil.doubleFormat(StringUtil.doubleFormat3(incomeUsed.getIncomeMoney())));
			
			sum += new Double(inMoney).doubleValue();
		}
		
		IncomeUsed used = new IncomeUsed();
		
		used.setCustomerName("");
		used.setIncomeCode("合计");
		used.setIncomeMoney(StringUtil.doubleFormat2(new Double(sum)));
		used.getIncomePublic().setCarrierName("");
//		used.setMoneyIn(new Double(0));
		used.setOrderCode("");
//		used.setMoneyPull(new Double(0));
//		used.setIncomeDate("");
//		used.setContractId(new Long(0));
		used.setFirstName("");
		used.setLastName("");
		used.setContractCode("");
		nameList.add(used);
		

		return nameList;
	}

	private List getSameCustomerName(String customerName,List ls,List newList){
		int i=0;
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			if(incomeUsed.getCustomerName().equals(customerName)){
				if(i>0){
					incomeUsed.setCustomerName("");
				}
				i++;
				newList.add(incomeUsed);
			}
		}
		
		return newList;
	}

	private List getSameIncomeCode(String incomeCode,List ls,List newList){
		int i=0;
//		String  incomeMoney;
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
//			incomeMoney = incomeUsed.getIncomeMoney();
			if(incomeUsed.getIncomeCode().equals(incomeCode)){
				if(i>0){
					incomeUsed.setIncomeCode("");
					incomeUsed.setIncomeMoney("");
				}
				i++;
				newList.add(incomeUsed);
			}
		}
		return newList;
	}
	
	private List getSameCarrierName(String carriername,String incomeCode,List ls,List newList){
		int i=0;
		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			
			if(incomeUsed.getIncomeCode().equals(incomeCode)){
				
			  if(incomeUsed.getIncomePublic().getCarrierName().equals(carriername)){
				
				if(i>0){
					
					incomeUsed.getIncomePublic().setCarrierName("");
					incomeUsed.setMoneyPull(null);
				}
				i++;
				newList.add(incomeUsed);
			  }
			}
		
		}

		return newList;
	}
	
	public List getChannelIncomeList(String orgId,String start,String end,String customerId,String carrierName,int channelModelParam,String theUser,String isPutYear,String returnValue,String incomPurs,String userId) {
		List incomePurposeIdList = new ArrayList();
		List userIdList = new ArrayList();
		Map mp = new HashMap();

		
		boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
		boolean isResourceSort = SysParamUtil.getWithResourceSort();
		
		mp.put("isResourceSort",Boolean.valueOf(isResourceSort));
		
		if(carrierAlisname){
			mp.put("carrierAlisname","1");
		}else{
			mp.put("carrierAlisname","0");
		}
		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		userIdList = UserUtil.getCurUserRels(theUser,orgId);
    		if(userIdList.size() == 0)userIdList.add("-1");
    		mp.put("UserIdList",userIdList);
//    		System.out.println("userIdList>>>>>>>>>>>>>>>>>>>>>>>"+userIdList);
    	}
		

		
		if(!customerId.equals("")&&customerId!=null&&!customerId.equals("0")){
			 List  customerls = new ArrayList();
			 CollectionUtils.addAll(customerls, customerId.split(","));
			 mp.put("customerIdList",customerls);
		}else{
			List  customerls =   CustomerUtil.getCustomerIdsByOrg(theUser,orgId);
			if(customerls.size() == 0)customerls.add("-1");
    		mp.put("customerIdList",customerls);
//    		System.out.println("customerls>>>>>>>>>>>>>>>>>>>>>>>"+customerls);
		}

		
//		System.out.println("carrierName>>>>>>>>>>>>>>>>>>>>>>>"+carrierName);
//		System.out.println("channelPull>>>>>>>>>>>>>>>>>>>>>>>"+channelModelParam);
//		System.out.println("theUser22>>>>>>>>>>>>>>>>>>>>>>>"+theUser);
		
       if(!isResourceSort){
   		List carrierIdList = CarrierUtil.getCarrierIds(carrierName,"1",theUser);
		mp.put("carrierIdList",carrierIdList); 
       }

       if(incomPurs != null && !"".equals(incomPurs)){
    	   String[] incomPursArray = incomPurs.split(",");
    	   CollectionUtils.addAll(incomePurposeIdList,incomPursArray);
       }
		

		
//        mp.put("carrierIdList",carrierIdList);
		if(!start.equals("")&&start!=null) mp.put("startDate",start);
		if(!end.equals("")&&end!=null) mp.put("endDate",end);
		mp.put("putYear",isPutYear);
		mp.put("incomePurposeIdList",incomePurposeIdList);	
		
		
		System.out.println("getChannelIncomeList>>>>>>>777777777777777777>>>>>>>>>>incomePurposeIdList>>>>>>"+incomePurposeIdList);
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(theUser));
     	}
		//判断是否业务员平帐
        if(UserUtil.isSignUserBalance()){
        	mp.put("version",new Integer(1));
        }else{
        	mp.put("version",new Integer(0));
        }
		
//		System.out.println("carrierMap    "+carrierMap.size());
		List incomes = incomedao.getPullIncomeMoneyList(mp);
//		List useds = dao.getIncomeUsedForChannel(mp);
		List incList = new ArrayList();
		double resultTotal[] = new double[2];
		
		for(Iterator itu = incomes.iterator();itu.hasNext();){
			Income income = (Income)itu.next();
			IncomeUsed incomeUsed =  new IncomeUsed();
			incomeUsed.getIncomePublic().setCarrierId(income.getIncomePublic().getCarrierId());
			incomeUsed.getIncomePublic().setCarrierName(income.getIncomePublic().getCarrierName());
			incomeUsed.getIncomePublic().setIncomeMoney(StringUtil.doubleFormat4(income.getIncomePublic().getIncomeMoney()));
			
			if(income.getIncomePublic().getIncomeMoney() == null)income.getIncomePublic().setIncomeMoney("0");
//			if(income.getIncomePublic().getUsedMoney() == null)income.getIncomePublic().setUsedMoney("0");
			resultTotal[0] += new Double(income.getIncomePublic().getIncomeMoney()).doubleValue();
//			resultTotal[1] += new Double(income.getIncomePublic().getUsedMoney()).doubleValue();
			
//			System.out.println("carrierName>>>>>>>>>>>>>>>>>>>>>>>"+income.getIncomePublic().getCarrierName());
			
			incList.add(incomeUsed);
		}
		
		if(incList.size()>0){
			IncomeUsed iu = new IncomeUsed();
			iu.getIncomePublic().setCarrierName("合计:");
			iu.getIncomePublic().setIncomeMoney(StringUtil.doubleFormat4(String.valueOf(resultTotal[0])));
//			iu.getIncomePublic().setUsedMoney(StringUtil.doubleFormat4(String.valueOf(resultTotal[1])));
			incList.add(iu);
		}
		
		
//		
//		List incomeList = fullincomeList(incomes,carrierMap);
//		List incomeUsedList = fullincomeUsedList(useds,carrierMap);

//		System.out.println(">>>>>>    "+finallyincomeUsedList(incomeUsedList,incomeList).size());
		return incList;
//		return finallyincomeUsedList(incomeUsedList,incomeList);
	}

	private List fullincomeList(List incomeList,Map carrierMap){
		List newIncomes = new ArrayList();
		for(Iterator it = incomeList.iterator();it.hasNext();){
			Income income = (Income)it.next();
			
			List carriers = (List)carrierMap.get(new Long(income.getIncomePublic().getCarrierName()));
//			System.out.println("carriers    "+carriers.size());
			for(Iterator ca = carriers.iterator();ca.hasNext();){
				Carrier car = (Carrier)ca.next();
				if(car.getNodeLevel().intValue()==1){
					income.getIncomePublic().setCarrierName(car.getCarrierName());
					income.getIncomePublic().setCarrierId(car.getId().toString());
				}
				newIncomes.add(income);
			}
		}
		
		return newIncomes;
		
	}
	
	private List fullincomeUsedList(List usedList,Map carrierMap,boolean carrierAlisname){
		List newIncomeUseds = new ArrayList();
		for(Iterator itused = usedList.iterator();itused.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)itused.next();
			List carriers2 = (List)carrierMap.get(new Long(incomeUsed.getIncomePublic().getCarrierName()));
			for(Iterator ca2 = carriers2.iterator();ca2.hasNext();){
				Carrier car2 = (Carrier)ca2.next();
				if(car2.getNodeLevel().intValue()==1){
					if(carrierAlisname){
						incomeUsed.getIncomePublic().setCarrierName(car2.getAliasName());
					}else{
						incomeUsed.getIncomePublic().setCarrierName(car2.getCarrierName());
					}
					
				}
			}
			
			newIncomeUseds.add(incomeUsed);
	}
		
		return newIncomeUseds; 
}
	
	private List finallyincomeUsedList(List usedList,List incomeList){
		
		List newIncomeUseds = new ArrayList();
		
		for(Iterator it = incomeList.iterator();it.hasNext();){
			Income income = (Income)it.next();
			for(Iterator itu = usedList.iterator();itu.hasNext();){
				IncomeUsed incomeUsed = (IncomeUsed)itu.next();
				if(incomeUsed.getIncomePublic().getCarrierName().equals(income.getIncomePublic().getCarrierName())){
					income.getIncomePublic().setUsedMoney(incomeUsed.getIncomePublic().getUsedMoney());
				}
			}			
		}
		
		
		double resultTotal[]= new double[2];
		
		for(Iterator iti = incomeList.iterator();iti.hasNext();){
			Income income = (Income)iti.next();
			IncomeUsed iu = new IncomeUsed();
			iu.getIncomePublic().setCarrierName(income.getIncomePublic().getCarrierName());
			iu.getIncomePublic().setIncomeMoney(StringUtil.doubleFormat4(income.getIncomePublic().getIncomeMoney()));
			iu.getIncomePublic().setUsedMoney(StringUtil.doubleFormat4(income.getIncomePublic().getUsedMoney()));
			
			
			
			if(income.getIncomePublic().getIncomeMoney() == null)income.getIncomePublic().setIncomeMoney("0");
			if(income.getIncomePublic().getUsedMoney() == null)income.getIncomePublic().setUsedMoney("0");
			resultTotal[0] += new Double(income.getIncomePublic().getIncomeMoney()).doubleValue();
			resultTotal[1] += new Double(income.getIncomePublic().getUsedMoney()).doubleValue();
			newIncomeUseds.add(iu);
		}
		
		if(incomeList.size()>0){
			IncomeUsed iu = new IncomeUsed();
			iu.getIncomePublic().setCarrierName("合计:");
			iu.getIncomePublic().setIncomeMoney(StringUtil.doubleFormat4(String.valueOf(resultTotal[0])));
			iu.getIncomePublic().setUsedMoney(StringUtil.doubleFormat4(String.valueOf(resultTotal[1])));
			newIncomeUseds.add(iu);
		}
		
		return newIncomeUseds;
		
	}
	/**
	 * @param carrierManager The carrierManager to set.
	 */
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}
	
	public String getIncomeChannelXML(String orgId,String start,String end,String customerId,String carrierId,int channelModelParam,String userName,String isPutYear,String isNotReturnValue,String purpose,String userId) {
		String ctxpath =RequestUtil.getReqInfo().getCtxPath();
		List ls = this.getChannelIncomeList(orgId,start,end,customerId,carrierId,channelModelParam,userName, isPutYear, isNotReturnValue, purpose,userId);

        String startDatePull = (Integer.parseInt(start.substring(0,4))-1) + "0101";
        String endDatePull =  (Integer.parseInt(end.substring(0,4))+1)+"1231";

		if(isPutYear.equals("1")){
	         startDatePull = start;
	         endDatePull = end;
		}

        
        String strURL = "/incomes.html?startDate=" + start +"&endDate=" + end +"&incomeModeName="+startDatePull+"&incomePurposeName="+endDatePull+"&resourceCarrierId=";
		
        
		int i =1;
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed obj = (IncomeUsed)it.next();
			sb.append("<row  id=\""+ i++ +"\"" +">"); 
//			sb.append("<cell><![CDATA["+ obj.getIncomePublic().getCarrierName() +"]]></cell>");
			String rsid = obj.getIncomePublic().getCarrierId();
			
			System.out.println("rsid>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+rsid);
			
			if(rsid !=null && !"null".equals(rsid)){
				sb.append("<cell><![CDATA[ <a target=_blank href="+ ctxpath + strURL + obj.getIncomePublic().getCarrierId()+">" +obj.getIncomePublic().getCarrierName() +"</a>]]></cell>");
			}else{
				sb.append("<cell><![CDATA["+ obj.getIncomePublic().getCarrierName() +"]]></cell>");
			}
			sb.append("<cell><![CDATA["+ obj.getIncomePublic().getIncomeMoney() +"]]></cell>");
//			sb.append("<cell><![CDATA["+ obj.getIncomePublic().getUsedMoney() +"]]></cell>");
//			sb.append("<cell><![CDATA["+ obj.getIncomePublic().getIncomeMoney() +"]]></cell>");
//			sb.append("<cell><![CDATA["+  obj.getIncomePublic().getUsedMoney() +"]]></cell>");
//			sb.append("<cell><![CDATA["+ obj.getIncomePublic().getIncomeMoney() +"]]></cell>");
//			sb.append("<cell><![CDATA["+  obj.getIncomePublic().getUsedMoney() +"]]></cell>");
			if(rsid !=null && !"null".equals(rsid)){
				sb.append("<userdata name=\"tarURL\"><![CDATA["+ctxpath + strURL + obj.getIncomePublic().getCarrierId()+"]]></userdata>");
			}

			sb.append("</row>");
		}
		
		sb.append("</rows>");	
		return sb.toString();	
	}
	public String getIncomeDetailXML(String customerId, String version) {
		
		List ls = this.getIncomeDetail(customerId,version);
		
		int i =1;
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			IncomeUsed obj = (IncomeUsed)it.next();
			String incomeDate = StringUtil.null2String(obj.getIncomeDate());
			String pullMoney=  StringUtil.getNullValue(obj.getMoneyPull(),"0");
			incomeDate = incomeDate ==""?"":incomeDate.substring(0,4)+"/"+incomeDate.substring(4,6)+"/"+incomeDate.substring(6,8);
			sb.append("<row  id=\""+ i++ +"\"" +">");
			sb.append("<cell><![CDATA["+ obj.getCustomerName() +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getIncomeCode() +"]]></cell>");
			sb.append("<cell><![CDATA["+  StringUtil.doubleFormat3(new Double(obj.getIncomeMoney())) +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.getNullValue(obj.getIncomePublic().getCarrierName(),"") +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(pullMoney)) +"]]></cell>");
			
			sb.append("<cell><![CDATA["+ obj.getOrderCode() +"]]></cell>");	
//			sb.append("<cell><![CDATA["+ obj.getMoneyIn() +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(obj.getMoneyIn()) +"]]></cell>");
		
			sb.append("<cell><![CDATA["+ incomeDate +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.null2String(obj.getContractCode()) +"]]></cell>");
			sb.append("<cell><![CDATA["+ obj.getFirstName() + obj.getLastName() +"]]></cell>");
			sb.append("</row>");
		}
		
		sb.append("</rows>");
		return sb.toString();
	}
	
	public Map getPuton(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getPutonMoneyAllCustomer(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
			retMp.put(obj.getCustomerName(),obj.getMoneyIn());
		}
		return retMp;
	}
	
	public Map getPutonYear(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getPutonMoneyAllYear(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
//			retMp.put(obj.getPublishDate(),obj.getMoneyIn());
//			if(obj.getMoneyIn()==null) obj.setMoneyIn(new Double(0));
			Double inp = obj.getMoneyIn();
			if(inp == null) inp = new Double(0);
			retMp.put(obj.getPublishDate(),inp);
		}
		for(int i = 1; i < 13;i++){
			Object obj = retMp.get(new Integer(i));
			if(obj == null)retMp.put(new Integer(i),new Double(0));
		}
		return retMp;
	}
	public Map getReturnValue2(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getReturnValueAllYear(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
//			retMp.put(obj.getPublishDate(),obj.getMoneyIn());
//			if(obj.getMoneyIn()==null) obj.setMoneyIn(new Double(0));
			Double inp = obj.getMoneyIn();
			if(inp == null) inp = new Double(0);
			retMp.put(obj.getPublishDate(),inp);
		}
		for(int i = 1; i < 13;i++){
			Object obj = retMp.get(new Integer(i));
			if(obj == null)retMp.put(new Integer(i),new Double(0));
		}
		return retMp;
	}
	public Map getReturnValue3(Map mp) {
		Map retMp = new HashMap();
		Map userMp = new HashMap();
		List ls = dao.getReturnValueBussiness(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
//			retMp.put(obj.getPublishDate(),obj.getMoneyIn());
//			if(obj.getMoneyIn()==null) obj.setMoneyIn(new Double(0));
			Double inp = obj.getMoneyIn();
			if(inp == null) inp = new Double(0);
//			System.out.println("obj.getFullName + obj.getPublishDate()1111111>>>>>>>>>>>>>>>>>>"+obj.getFullName()+obj.getPublishDate());
			String userName = obj.getFirstName()+ obj.getLastName();
//			System.out.println("userName1111111>>>>>>>>>>>>>>>>>>"+userName+obj.getPublishDate());
			retMp.put(userName + obj.getPublishDate(),inp);
			if(!userMp.containsKey(userName)){
				userMp.put(userName,userName);
			}
		}
		for(Iterator it=userMp.keySet().iterator();it.hasNext();){
			String userName =(String)it.next();
			for(int i = 1; i < 13;i++){
				String key = userName + String.valueOf(i);
				Object obj = retMp.get(key);
				if(obj == null)retMp.put(key,new Double(0));
			}
		}

		return retMp;
	}
	
	public Map getScopeCarriersPutonMoney(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getScopeCarriersPutonMoney(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
			retMp.put(obj.getId(),obj.getMoneyIn());
		}
		return retMp;
	}
	
	public Map getScopeResourcesPutonMoney(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getScopeResourcesPutonMoney(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
//			if(obj.getMoneyIn()==null) obj.setMoneyIn(new Double(0));
			retMp.put(obj.getId(),obj.getMoneyIn());
		}
		return retMp;
	}
	
	public Map getScopeIdPutonMoney(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getScopeIdPutonMoney(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
//			if(obj.getMoneyIn()==null) obj.setMoneyIn(new Double(0));
			String key = obj.getId().toString()+obj.getCustomerName();
			retMp.put(key,obj.getMoneyIn());
		}
		return retMp;
	}
	
	public Map getIndustryPutonMoney(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getIndustryPutonMoney(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
			Double inc = obj.getMoneyIn();
			if(inc == null) inc = new Double(0);
			retMp.put(obj.getId().toString()+obj.getCarrierName(),inc);
		}
		return retMp;
	}
	
	public Map getCustomerPutonMoney(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getCustomerPutonMoney(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
			Double inc = obj.getMoneyIn();
			if(inc == null) inc = new Double(0);
			retMp.put(obj.getId().toString()+obj.getCarrierName(),inc);
		}
		return retMp;
	}
	public Map getReturnValue(Map mp) {
		Map retMp = new HashMap();
		List ls = dao.getReturnValueAllCustomer(mp);
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomeUsed obj = (IncomeUsed) it.next();
			retMp.put(obj.getCustomerName(),obj.getMoneyIn());
		}
		return retMp;
	}
	
	
//	public Map getContractPaymentPutonMoney(Map mp) {
//		Map retMp = new HashMap();
//		List ls = dao.getContractPaymentPutonMoney(mp);
//		for (Iterator it = ls.iterator(); it.hasNext();) {
//			IncomeUsed obj = (IncomeUsed) it.next();
//			Double inc = obj.getMoneyIn();
//			if(inc == null) inc = new Double(0);
//			retMp.put(obj.getPaymentId(),inc);
//		}
//		return retMp;
//	}
}



