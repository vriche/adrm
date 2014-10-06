package com.vriche.adrm.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.IncomeDao;
import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Account;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.IncomePull;
import com.vriche.adrm.model.OrderDetailColl;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.IncomeMsgManager;
import com.vriche.adrm.service.IncomePullManager;
import com.vriche.adrm.service.SysSequenceManager;
import com.vriche.adrm.service.UserExistsException;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.ChannelComparator;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.SmackUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.StringUtilsv;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;
public class IncomeManagerImpl extends BaseManager implements IncomeManager {
	private IncomeDao dao;
	private UserManager userManager;
	private CarrierManager carrierManager;
	private CustomerManager customerManager;
	private IncomePullManager incomePullManager;
	private IncomeMsgManager incomeMsgManager;
    private SysSequenceManager sysSequenceManager;
	/**
	 * Set the Dao for communication with the data layer.
	 * @param dao
	 */
	public void setIncomeDao(IncomeDao dao) {
		this.dao = dao;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * @param carrierManager The carrierManager to set.
	 */
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}
	
	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
	
	public void setIncomePullManager(IncomePullManager incomePullManager) {
		this.incomePullManager = incomePullManager;
	}
	
	public void setIncomeMsgManager(IncomeMsgManager incomeMsgManager) {
		this.incomeMsgManager = incomeMsgManager;
	}  
	public void setSysSequenceManager(SysSequenceManager sysSequenceManager) {
		this.sysSequenceManager = sysSequenceManager;
	}
	
	/**
	 * @see com.vriche.adrm.finance.service.IncomeManager#getIncomesByIdList(final Map idList)
	 */
//	public List getIncomesByIdList(final Map idList) {
////		System.out.println("1");
//		return dao.getIncomesByIdList(idList);
//	}

	/**
	 * @see com.vriche.adrm.finance.service.IncomeManager#getIncomes(com.vriche.adrm.finance.model.Income)
	 */
	public List getIncomes(final Income income) {
		return dao.getIncomes(income);
	}

	
	public Collection getIncomesColl(List ls) {
		Collection coll = new ArrayList();
		double sum = 0;
//		强制解除科学计数法
		DecimalFormat df = new DecimalFormat("#.##");
		for(Iterator it=ls.iterator();it.hasNext();){
			Income income = (Income)it.next();
			income.setCustomerName(income.getCustomer().getCustomerName());
			income.setUserName(income.getUser().getFullName());
			income.setIncomeModeName(income.getIncomeMode().getName());
			income.setIncomePurposeName(income.getIncomePurpose().getName());
			sum = sum+income.getIncomeMoney().doubleValue();
			coll.add(income);
		}
		String sumFormat = df.format(sum);
		
		Income sumIncome = new Income();
		sumIncome.setUserName("合计");
		sumIncome.setIncomeMoney(new Double(sumFormat));
		sumIncome.setIncomeDate(null);
		sumIncome.setIncomeCode("");
		sumIncome.setCustomerName("");
		sumIncome.setIncomeModeName("");
		sumIncome.setIncomePurposeName("");
		coll.add(sumIncome);
		return coll;
	}
	
	
	
	private List getUserIdList(String orgId){
		boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
		
		if(isOneOrgMoreSuborgs){
			   List orgIdList = new ArrayList();
			 	 Map mp = new HashMap();
			 	 orgIdList = SysParamUtil.getOrgChileds(String.valueOf(orgId));
			 	 if(orgIdList.size()== 0){
			       		orgIdList.add(""+orgId);
			       	}
			 	 
			 	 mp.put("orgIdList",orgIdList); 
			 	UserDao  userDao = ServiceLocator.getUserDao();
			 	
			 	return userDao.getUserIdsByOrg(mp);	
		}else{
		  	return new ArrayList();
		}


	}
	
	public String getIncomeCount(Income income) {
		
		
//		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
//		
//		if(financialAuditSwitch){
//			String version = income.getStartDate();
//			if(!"".equals(version) && !"0".equals(version) && version != null){
//				version = version.substring(0,4);
//				List fitterOrderSubCatesList  = SysParamUtil.getFitterIncomePours(String.valueOf(version));
//				
////				System.out.println("getIncomeCount 123>>>>>>>>>>>>fitterOrderSubCatesList>>>>>>>>" + fitterOrderSubCatesList);
//				
//				income.setFitterOrderSubCatesList(fitterOrderSubCatesList);
//			}
//
//		}
		
		
//		Long resourceCarrierId =income.getResourceCarrierId();
//		
//		 
//		if(resourceCarrierId != null){
//			String carrierId = String.valueOf(income.getResourceCarrierId());
//			boolean channelPull = SysParamUtil.getChannelModelPara();
////			System.out.println(">>>>>>>>>>>>carrierId1>>>>>>>>" + carrierId);
//			carrierId = (carrierId == null || "".equals(carrierId)||"null".equals(carrierId))?"0":carrierId;
//			 
//	        boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
//	    	if(carrierAlisname && resourceCarrierId.longValue() !=0){
//	    		System.out.println("123>>>>>>>>>>>>carrierId1>>>>>>>>" + carrierId);
//	    		String ids = CarrierUtil.getOtherSameAlisnameIds(carrierId);
//	    		if(ids.indexOf(",")>-1){
//	    			String[] s = ids.split(",");
//	    			for(int i = 0;i<s.length;i++){
//	    				income.getCarrierIdList().add(s[i]);
//	    			}
//	    		}else{
//	    			income.getCarrierIdList().add(carrierId);
//	    		}
//	    		income.setResourceCarrierId(null);
//	    	}else{
//				if(carrierId.equals("0")){
//					if(channelPull){
//						String currentUser = UserUtil.getCurrentPrincipalUser();
//						List carrierIdList = carrierManager.getCarrierIdListsNotChilden(carrierId,channelPull,currentUser);
////						System.out.println(">>>>>>>>>>>>carrierId2>>>>>>>>" + carrierIdList.size());
//						if(carrierIdList.size() == 0){
//							carrierIdList.add("-1");
//						}
//						income.setCarrierIdList(carrierIdList);
//						
//					}
//					income.setResourceCarrierId(null);
//				}else{
//					income.setResourceCarrierId(new Long(carrierId));
//		    	}
//	    	}
//			
//			
//			
//			
//
//		}
//		System.out.println(">>>>>>>>>>>>income>>>>>>>>" + income.toString());
	  	List userls2 = getUserIdList( income.getOrgId().toString());
	  	if(userls2.size()>0) income.setUserIdList2(userls2);
//		 mp.put("UserIdList2",userls2);

//		boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
//		
//	    if(isOneOrgMoreSuborgs){
//	       	Map mp = new HashMap();
//	    		  String orgId = income.getOrgId().toString();
//	        List orgIdList = new ArrayList();
//	        
//	        orgIdList = SysParamUtil.getOrgChileds(String.valueOf(orgId));
//	        
//	        System.out.println("getOrgChileds >>>>>>>>>>5 6 7 8>>>>>>>>>>>>>  "+orgIdList);
//	        
//	       if(orgIdList.size()== 0){
//	       		orgIdList.add(""+orgId);
//	       				}
// 
//	       income.setOrgIdList(orgIdList);
//	       
//	       
//	          mp.put("orgIdList",orgIdList); 
//           UserDao  userDao = ServiceLocator.getUserDao();
//           List userls2 = userDao.getUserIdsByOrg(mp);
//           income.setUserIdList2(userls2);
////           mp.put("UserIdList2",userls2);
//
//	    }		
	    
	    
	    
		
		return dao.getIncomeCount(income).toString();
	}

	public PaginatedList getIncomesPage(Income income, String pageIndex,String pageSize) {
		return dao.getIncomesPage(income,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	


	public List getIncomesPage2(Income income, String pageIndex,String pageSize,boolean isLastSumPage) {
		
	
		
//		boolean isOneOrgMoreSuborgs = SysParamUtil.getOneOrgMoreSuborgsParam();
//		
//	    if(isOneOrgMoreSuborgs){
//	    	Map mp = new HashMap();
//	    		  String orgId = income.getOrgId().toString();
//	        List orgIdList = new ArrayList();
//	        
//	        orgIdList = SysParamUtil.getOrgChileds(String.valueOf(orgId));
//	        
//	        System.out.println("getOrgChileds >>>>>>>>>>5 6 7 8>>>>>>>>>>>>>  "+orgIdList);
//	        
//	       if(orgIdList.size()== 0){
//	       		orgIdList.add(""+orgId);
//	       				}
// 
//	       income.setOrgIdList(orgIdList);
//	       
//	       
//	          mp.put("orgIdList",orgIdList); 
//           UserDao  userDao = ServiceLocator.getUserDao();
//           List userls2 = userDao.getUserIdsByOrg(mp);
//           income.setUserIdList2(userls2);
////           mp.put("UserIdList2",userls2);
//
//	    }		
		
		
	
	  	List userls2 = getUserIdList( income.getOrgId().toString());
	  	if(userls2.size()>0) income.setUserIdList2(userls2);
		
		List idList = dao.getIncomesPage2(income,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		
		List paginatedList = new ArrayList();
//求分配金额总和
		//加序号，用createBy 代替
		long i = 1;
		for (Iterator it = idList.iterator(); it.hasNext();) {

			Income incomeId = (Income) it.next();
			Long ids = new Long(Integer.parseInt(pageIndex)*Integer.parseInt(pageSize) + i++);
			incomeId.setCreateBy(ids);
//			System.out.println("incomeId.getId()<<<<<<<!111111111111<<<<<<<<<<<<<"+incomeId.getId());
//			System.out.println("incomeId.getIncomeCode()<<<<<<<!111111111111<<<<<<<<<<<<<"+incomeId.getIncomeCode());
			paginatedList.add(incomeId);
		}
		
		
		
		if(isLastSumPage){
			Income incom = dao.getIncomesPageSum(income);
//			List incomeMoneyUse = dao.getIncomesPageSum2(income);
			if(incom.getIncomeMoney().doubleValue() > 0){
				Income inc = new Income();
				inc.getUser().setFirstName("合");
				inc.getUser().setLastName("计:");
				inc.setIncomeMoney(incom.getIncomeMoney());
				inc.setIncomeUsed(incom.getIncomeUsed());
			
				paginatedList.add(inc);
			}
		}
		return paginatedList;
	}  
public Double getIncomeUsedSum(List ls){
	double incomeUsed=0;
	for(Iterator it=ls.iterator();it.hasNext();){
		Income income=(Income)it.next();
		incomeUsed+=income.getIncomeUsed().doubleValue();
	}
	return new Double(incomeUsed);
}
	/**
	 * @see com.vriche.adrm.finance.service.IncomeManager#getIncome(String id)
	 */
	public Income getIncome(final String id) {

		return dao.getIncome(new Long(id));
	}
	
	public Income getIncome5(final String id) {
		
		
		
		IncomePullDao incomePullDao = ServiceLocator.getIncomePullDao();
		IncomePull incomePull = incomePullDao.getIncomePullByIncomeId(new Long(id));
		String resourceChannelId = StringUtil.getNullValue(incomePull.getResourceChannelId(),"");
		
		System.out.println("发票号1 getIncomeCode<<<<<<<!111111111111<<<<<<<<<<<<<" + id);
		
		Income income = dao.getIncome(new Long(id));
		
		System.out.println("发票号2 getIncomeCode<<<<<<<!111111111111<<<<<<<<<<<<<" +income.getIncomeCode());
		
		income.setResourceChannelId(resourceChannelId);
		return income; 
	}

	/**
	 * @see com.vriche.adrm.finance.service.IncomeManager#saveIncome(Income income)
	 */
	public String saveIncome(Income income) throws UserExistsException {
//		checkIsNewCustomer(income);
		incomeAlertService(income);
		
		boolean isNew = (income.getId() == null) || StringUtils.isEmpty(income.getId().toString());
		boolean isAutoCode = getSequenceIncomeAuto();
	    if(isNew && isAutoCode){
	    	String incomeCode  = sysSequenceManager.getSysSequenceByObject(income.getOrgId().toString(),Constants.SEQUENCE_TB_INCOME,income.getIncomeDate().toString());
	    	System.out.println("发票号<<<<<<<!111111111111<<<<<<<<<<<<<" +incomeCode);
	    	income.setIncomeCode(incomeCode);
//	    	System.out.println("发票号<<<<<<<!111111111111<<<<<<<<<<<<<" +incomeCode);
    	}
	    
//	    System.out.println("发票号<<<<<<<!111111111111<<<<<<<<<<<<<"+ isNew + income.getIncomeCode());
	    
	    try {
	        return dao.saveIncome(income);
        } catch (DataIntegrityViolationException e) {
        	System.out.println("发票号<<<<<<<!222222222<<<<<<<<<<<<<" +e.getMessage());
            throw new UserExistsException("发票号 '" + income.getIncomeCode() + "' 已经存在!");
        }
  
	}
	
	
	private void incomeAlertService(Income income){
		
		//财务人员控制是否提示
		int  isAlert = income.getState() !=null?  income.getState().intValue():0;
		
		if(SmackUtil.isUseOpenFire() && isAlert ==1){
			
			Long id = income.getId();
			Income incomeBak = new Income();
//			System.out.println("id>>>>>>>>>"+id);
			if (id != null ) {
				incomeBak.setId(id);
				incomeBak = (Income)dao.getIncomes(incomeBak).get(0);
			}
			incomeMsgManager.getMessage(income,incomeBak);
		}
	}

	
//	private void checkIsNewCustomer(Income income){
//		Long customerId = income.getCustomerId();
//		String customerName = income.getCustomer().getCustomerName();
//		String customerCategoryId = income.getCustomer().getCustomerCategoryId();
//		String ownerUserId = income.getUserId().toString();
//		String id = customerManager.saveCustomer(customerId,customerName,customerCategoryId,ownerUserId);
//		income.setCustomerId(new Long(id));
//	}

	/**
	 * @see com.vriche.adrm.finance.service.IncomeManager#removeIncome(String id)
	 */
	public void removeIncome(final String id) {
		dao.removeIncome(new Long(id));
		
//		SysSequence sequence = new SysSequence();
//		sequence.setName(Constants.SEQUENCE_TB_INCOME);
//		SysSequence sysSequence = sysSequenceManager.getSysSequenceByObject(sequence);
//		sysSequence.setCurrentNext(new Long(sysSequence.getCurrentNext().longValue()-1));
//		sysSequenceManager.saveSysSequence(sysSequence);
	}

	/**
	 * @see com.vriche.adrm.finance.service.IncomeManager#removeIncomes(String Map)
	 */
	public void removeIncomes(final Map idList) {
		dao.removeIncomes(idList);
	}

	public List getIncomesPageByIdList(Income income) {
		List ls = dao.getIncomes(income);
		Integer state = income.getState();
		Integer version = income.getVersion();
		Map mp = ConvertUtil.convertListToMap(ls,"id");

		List idList = getIdList(mp,state);
		
		Map map = new HashMap();
		
		map.put("IncomeIdList",idList);
		map.put("state",state);
		map.put("version",version);

		return dao.getIncomesPage(map);
	}

//	public String getIncomeCountByIdList(Income income,Integer state) {
//		List ls = dao.getIncomes(income);
//		Map mp = ConvertUtil.convertListToMap(ls,"id");
//		List idList = getIdList(mp,state);
//		Map map = new HashMap();
//		
//		map.put("IncomeIdList",idList);
//		
//		return dao.getIncomeCountByIdList(map).toString();
//	}
	

	public String getIncomeCountByIdList(Income income,Integer state) {
		List ls = dao.getIncomes(income);
		Map mp = ConvertUtil.convertListToMap(ls,"id");
		List idList = getIdList(mp,state);
		Map map = new HashMap();
		
		map.put("IncomeIdList",idList);
		
		return dao.getIncomesPageCount(map).toString();
	}
	
	public Map getTargetIncome(Map mp) {
		Map retMp = new HashMap();
		
		List ls = dao.getIncomeMoneyAllCarrier(mp);
		
		for (Iterator it = ls.iterator(); it.hasNext();) {
			Income obj = (Income) it.next();
			Double inc = obj.getIncomeMoney();
			
			if(inc == null) inc = new Double(0);
			String key = obj.getResourceCarrierId()+obj.getIncomeCode();
			retMp.put(key,inc);
//			System.out.println("key is ---------"+key);
//			System.out.println("inc is -----------"+inc);
		}
		return retMp;
	}
	
	private List getIdList(Map mp,Integer state){
		
		List idList = new ArrayList();
		if(mp.size() == 0){
//			System.out.println("222222222");
			idList.add(null);
		}else{
			for(Iterator it = mp.keySet().iterator();it.hasNext();){
			
			Income income = (Income)mp.get(it.next());
//			System.out.println("version   "+income.getVersion());
			double incomeMoney = income.getIncomeMoney().doubleValue();
			
			Double incomeUsedOld = income.getIncomeUsed();
			
			if(incomeUsedOld == null) incomeUsedOld = new Double(0);
			
			double incomeUsed = incomeUsedOld.doubleValue();
			
			
			Integer stateOld = state;
			int states = stateOld.intValue();

			if(states == 1){
//				System.out.println("incomeMoney="+incomeMoney);
//				System.out.println("incomeUsed="+incomeUsed);
				if(incomeMoney != incomeUsed){
					idList.add(income.getId());
				}
				if(incomeMoney - incomeUsed == 0){
					idList.add(null);
				}
			}else if(states == 2){				
				if(incomeUsed > 0){
					idList.add(income.getId());
				}
				if(incomeUsed == 0){
					idList.add(null);
				}
			}
		}
	}
		return idList;
	}
	
	

	
	
	 public List getPutOnInfos(String startDate, String endDate,String userId,String carrierName,int channelModelParam) {

		
		Map mp = new HashMap();
		Map businessMap = new HashMap();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
//		System.out.println("<<<<<<  "+carrierName+"   "+userId);
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName);

//		判断是否分频道，值为1分，否则不分
		boolean channelPull = false;
		
		if(channelModelParam==1){
			 channelPull = true;
			}
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,null);
		mp.put("carrierIdList",carrierIdList);

		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
    		List ls = userManager.getOwnerUsersList(userRelsMap);
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		List list = dao.getPutOnInfos(mp);
//		System.out.print("KKKKKKKKKKKKK   "+list.size());
		double total_money = 0.0d;
		for (Iterator it = list.iterator(); it.hasNext();) {

			Map map = null;
			Income income = (Income) it.next();
			String fullName = income.getUser().getFullName();
//			System.out.print("ddddddddddd   "+fullName);
			int month = Integer.parseInt(income.getIncomeDate()
					.toString().substring(4, 6));

			if (businessMap.containsKey(fullName)) {
				Map map1 = (Map) businessMap.get(fullName);
				map1.put(new Integer(month), income);
				for (int i = 1; i < 13; i++) {
					if (map1.get(new Integer(i)) == null) {
						map1.put(new Integer(i), null);
					}
				}
				businessMap.put(fullName, map1);
			} else {

				map = new HashMap();
				map.put(new Integer(month), income);

				for (int i = 1; i < 13; i++) {

					if (map.get(new Integer(i)) == null) {
						map.put(new Integer(i), new Income());
					}

				}

				businessMap.put(fullName, map);
			}
		}
		List result = new ArrayList();
		//强制解除科学计数法
		DecimalFormat df = new DecimalFormat("#.##");
		double colcount[] = new double[14];
		String col[] = new String[14];
		for (Iterator it = businessMap.keySet().iterator(); it.hasNext();) {
			String businessName = (String) it.next();

			Income temp = new Income();
			//用setMemo得到业务员
			temp.setMemo(businessName);
//			System.out.println("JJJJJJJJJJJJJ  "+temp.getUser().getFullName());
			Map incomes = (Map) businessMap.get(businessName);

			String ss[] = new String[14];
			double rowcount = 0.0d;

			for (int i = 1; i < 13; i++) {

				if (incomes.get(new Integer(i)) == null) {
					ss[i] = "0";

				} else {
					Income incomeMoney = (Income) incomes.get(new Integer(i));
					    if (incomeMoney.getIncomeMoney() == null) {
							ss[i] = "0";
						} else {
							ss[i] = incomeMoney.getIncomeMoney().toString();
//							System.out.print("77777777   "+ss[i]);
						}
					}
				ss[i] = df.format(new Double(ss[i]));
				colcount[i] += Double.parseDouble(ss[i]);
				rowcount += Double.parseDouble(ss[i]);
				}
			
			
			total_money += rowcount;
			ss[13] = String.valueOf(df.format(rowcount));

			double total_money1 = 0.0d;
			for (int cov = 1; cov < 13; cov++) {
				total_money1 += colcount[cov];
				col[cov] = String.valueOf(df.format(colcount[cov]));
			}
			if (total_money1 == total_money) {
				col[13] = String.valueOf(df.format(total_money));
			} else {
				col[13] = "<script language='javaScript'>alert('数据处理有误,请刷新页面')</script>";
			}

			temp.setMonth(ss);
			result.add(temp);
		}
		Income colsum = new Income();// 列统计
		colsum.setMemo("总合计");
		colsum.setMonth(col);
		result.add(colsum);
//System.out.println("JJJJJJJJJJJJJ  "+result.size());
		return result;
	}
	 public List getPutOnInfosForReport(String startDate, String endDate,String userId,String carrierName,String curUserName,String channelModel) {

			
			Map mp = new HashMap();
			Map businessMap = new HashMap();
			List userIdList = new ArrayList();
			List carrierIdList = new ArrayList();
//			System.out.println("<<<<<<  "+carrierName+"   "+userId);
			mp.put("startDate",startDate);
			mp.put("endDate",endDate);
//			mp.put("parentId",carrierName);

//			判断是否分频道，值为1分，否则不分
			boolean channelPull = false;
			
			int channelModelParam = Integer.parseInt(channelModel);

			if(channelModelParam==1){
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
	    		
	    		List ls = userManager.getOwnerUsersListForReport(userRelsMap,curUserName);
	    		for(Iterator it=ls.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
			List list = dao.getPutOnInfos(mp);
//			System.out.print("KKKKKKKKKKKKK   "+list.size());
			double total_money = 0.0d;
			for (Iterator it = list.iterator(); it.hasNext();) {

				Map map = null;
				Income income = (Income) it.next();
				String fullName = income.getUser().getFullName();
//				System.out.print("ddddddddddd   "+fullName);
				int month = Integer.parseInt(income.getIncomeDate()
						.toString().substring(4, 6));

				if (businessMap.containsKey(fullName)) {
					Map map1 = (Map) businessMap.get(fullName);
					map1.put(new Integer(month), income);
					for (int i = 1; i < 13; i++) {
						if (map1.get(new Integer(i)) == null) {
							map1.put(new Integer(i), null);
						}
					}
					businessMap.put(fullName, map1);
				} else {

					map = new HashMap();
					map.put(new Integer(month), income);

					for (int i = 1; i < 13; i++) {

						if (map.get(new Integer(i)) == null) {
							map.put(new Integer(i), new Income());
						}

					}

					businessMap.put(fullName, map);
				}
			}
			List result = new ArrayList();
			double colcount[] = new double[14];
			DecimalFormat df = new DecimalFormat("#.##");
			String col[] = new String[14];
			for (Iterator it = businessMap.keySet().iterator(); it.hasNext();) {
				String businessName = (String) it.next();

				Income temp = new Income();
				//用setMemo得到业务员
				temp.setMemo(businessName);
//				System.out.println("JJJJJJJJJJJJJ  "+temp.getUser().getFullName());
				Map incomes = (Map) businessMap.get(businessName);

				String ss[] = new String[14];
				double rowcount = 0.0d;

				for (int i = 1; i < 13; i++) {

					if (incomes.get(new Integer(i)) == null) {
						ss[i] = "0";

					} else {
						Income incomeMoney = (Income) incomes.get(new Integer(i));
						    if (incomeMoney.getIncomeMoney() == null) {
								ss[i] = "0";
							} else {
								ss[i] = incomeMoney.getIncomeMoney().toString();
//								System.out.print("77777777   "+ss[i]);
							}
						}
					ss[i] = df.format(new Double(ss[i]));
					colcount[i] += Double.parseDouble(ss[i]);
					rowcount += Double.parseDouble(ss[i]);
					}
				
				
				total_money += rowcount;
				ss[13] = String.valueOf(df.format(rowcount));

				double total_money1 = 0.0d;
				for (int cov = 1; cov < 13; cov++) {
					total_money1 += colcount[cov];
					col[cov] = String.valueOf(df.format(colcount[cov]));
				}
				if (total_money1 == total_money) {
					col[13] = String.valueOf(df.format(total_money));
				} else {
					col[13] = "<script language='javaScript'>alert('数据处理有误,请刷新页面')</script>";
				}

				temp.setMonth(ss);
				result.add(temp);
			}
			Income colsum = new Income();// 列统计
			colsum.setMemo("总合计");
			colsum.setMonth(col);
			result.add(colsum);
//	System.out.println("JJJJJJJJJJJJJ  "+result.size());
			return result;
		}
	 
public Collection getPutOnInfosColl(List ls){
	Collection coll = new ArrayList();
	for (Iterator it = ls.iterator(); it.hasNext();) {
		Income colsum = (Income) it.next();
		OrderDetailColl odColl = new OrderDetailColl();
		odColl.setAdvName(colsum.getMemo());
			odColl.setDay1(colsum.getMonth()[1]);
			odColl.setDay2(colsum.getMonth()[2]);
			odColl.setDay3(colsum.getMonth()[3]);
			odColl.setDay4(colsum.getMonth()[4]);
			odColl.setDay5(colsum.getMonth()[5]);
			odColl.setDay6(colsum.getMonth()[6]);
			odColl.setDay7(colsum.getMonth()[7]);
			odColl.setDay8(colsum.getMonth()[8]);
			odColl.setDay9(colsum.getMonth()[9]);
			odColl.setDay10(colsum.getMonth()[10]);
			odColl.setDay11(colsum.getMonth()[11]);
			odColl.setDay12(colsum.getMonth()[12]);
			odColl.setDay13(colsum.getMonth()[13]);
			coll.add(odColl);
	}
	return coll;
}

public String getPutOnInfosCount(String startDate, String endDate,String userId,String carrierName,int channelModelParam) {

	
	Map mp = new HashMap();
	Map businessMap = new HashMap();
	List userIdList = new ArrayList();
	List carrierIdList = new ArrayList();
	mp.put("startDate",startDate);
	mp.put("endDate",endDate);
	//mp.put("parentId",carrierName);

//	判断是否分频道，值为1分，否则不分
	boolean channelPull = false;
	
	if(channelModelParam==1){
		 channelPull = true;
		}
	
	carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,null);
	mp.put("carrierIdList",carrierIdList);


	
	if((!"".equals(userId) &&  userId!=null)){
		List userls = new ArrayList();
		userls.add(userId);
		mp.put("UserIdList",userls);
	}else{
		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
		
		List ls = userManager.getOwnerUsersList(userRelsMap);
		for(Iterator it=ls.iterator();it.hasNext();){
			User user = (User)it.next();
			userIdList.add(user.getId());
		}
		mp.put("UserIdList",userIdList);
	}
	List list = dao.getPutOnInfos(mp);
	for (Iterator it = list.iterator(); it.hasNext();) {

		Map map = null;
		Income income = (Income) it.next();
		String fullName = income.getUser().getFullName();
		int month = Integer.parseInt(income.getIncomeDate()
				.toString().substring(4, 6));

		if (businessMap.containsKey(fullName)) {
			Map map1 = (Map) businessMap.get(fullName);
			map1.put(new Integer(month), income);
			for (int i = 1; i < 13; i++) {
				if (map1.get(new Integer(i)) == null) {
					map1.put(new Integer(i), null);
				}
			}
			businessMap.put(fullName, map1);
		} else {

			map = new HashMap();
			map.put(new Integer(month), income);

			for (int i = 1; i < 13; i++) {

				if (map.get(new Integer(i)) == null) {
					map.put(new Integer(i), new Income());
				}

			}

			businessMap.put(fullName, map);
		}
	}
	return (new Integer(businessMap.size() + 1)).toString();
}


public Income getIncome2(String incomeCode) {
	// TODO Auto-generated method stub
	return dao.getIncome2(incomeCode);
}

public Income getIncomeByCodeAuto(String orgId,String year,String incomeCode) {
	Map mp = new HashMap();
	mp.put("orgId",orgId);
	mp.put("year",year);
	mp.put("incomeCode",incomeCode);
	
	return dao.getIncomeByCodeAuto(mp);

}





public Map getIncome3(Map mp) {
	Map retMp = new HashMap();

	List ls = dao.getIncomeMoneyAllCustomer(mp);
	for (Iterator it = ls.iterator(); it.hasNext();) {
		Income obj = (Income) it.next();
		retMp.put(obj.getCustomerName(),obj.getIncomeMoney());
	}
	return retMp;
}


public Map getAreaIncome(Map mp) {
	Map retMp = new HashMap();
	List ls = dao.getAreaIncomeMoney(mp);
	for (Iterator it = ls.iterator(); it.hasNext();) {
		Income obj = (Income) it.next();
		retMp.put(obj.getCustomerName(),obj.getIncomeMoney());
	}
	return retMp;
}

public Map getIncome12Month(Map mp) {
	Map retMp = new HashMap();
	List ls = dao.getIncomeMoneyGroupMonth(mp);
	
	for (Iterator it = ls.iterator(); it.hasNext();) {
		Income obj = (Income) it.next();
		Double inc = obj.getIncomeMoney();
		
		if(inc == null) inc = new Double(0);
		retMp.put(new Integer(Integer.parseInt(obj.getIncomeCode())),inc);
		
	}
	
	for(int i = 1; i < 13;i++){
		Object obj = retMp.get(new Integer(i));
		if(obj == null)retMp.put(new Integer(i),new Double(0));
	}
	return retMp;
}


public List getBussin(Map mp) {
	return dao.getPutOnInfos(mp);
}

public String getIncomesListXML(Income income) {
	
 	if(UserUtil.isUserOrderYearRel()) {
 		String loginUser = UserUtil.getCurrentPrincipalUser();
 		income.setYearIdList(UserUtil.getUserYearRelByLoginUser(loginUser));
 	}
	
	

	List all = dao.getIncomesListPage(income);
//	System.out.println("all<<<<<<<1111111111111<<<<<<<<<<"+all.size());
	StringBuffer sb  = new StringBuffer();
	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<rows>");  
	
	for(Iterator it = all.iterator();it.hasNext();){
		Income LMan = (Income) it.next();
		
		String memo = LMan.getMemo()==null?"":LMan.getMemo();
		////到款日期   	收入编号   	到款金额   	到款类型  	到款用途  	备注
		sb.append("<row  id=\""+ LMan.getId()  +"\">");
		
		sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getIncomeDate().toString(),"yyyy/MM/dd") +"]]></cell>");
		
		sb.append("<cell><![CDATA["+ LMan.getIncomeCode() + "^/adrm/editIncome.html?id="+LMan.getId()+"&orgId="+LMan.getOrgId()+"]]></cell>");
		
		sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(LMan.getIncomeMoney())  +"]]></cell>");
		sb.append("<cell><![CDATA["+ LMan.getIncomeMode().getName()  +"]]></cell>");
		sb.append("<cell><![CDATA["+ LMan.getIncomePurpose().getName() +"]]></cell>");
		sb.append("<cell><![CDATA["+ memo +"]]></cell>");
		
		sb.append("</row>");
	 }
	
	sb.append("</rows>");
	
	return sb.toString();
}
public Collection getCollections(final String queryString){
	String incomeId = StringUtil.getParamFromUrl(queryString,"incomeId");
	Income in=new Income();
	in.setId(new Long(incomeId));
	List ls = getIncomes(in);
	
	Collection coll = new ArrayList();
	
	for(Iterator it=ls.iterator();it.hasNext();){
		Income income = (Income)it.next();
		FusionChartObject fObject = new FusionChartObject();
	
		for(int i=1;i<=10;i++){  
				switch(i){
					case 1:
						fObject.setValue1(DateUtil.SetDateFormat(income.getIncomeDate().toString(),"yyyy/MM/dd"));break;
					case 2:
						fObject.setValue2(income.getIncomeCode());break; 
					case 3:
						fObject.setValue3(income.getCustomer().getCustomerName());break;
					case 4:
						fObject.setValue4("");break;
					case 5:
						fObject.setValue5("");break;
					case 6:
						fObject.setValue6("");break;
					case 7:
						fObject.setValue7(""+income.getIncomeMoney());break;
					case 8:
						fObject.setValue8(income.getIncomeMode().getName());break;
					case 9:
						fObject.setValue9(income.getIncomePurpose().getName());break;
					case 10:
						fObject.setValue10(income.getMemo());break;
					default :
				}
		}
		coll.add(fObject);
	}
	
	
	IncomePull incomePull = new IncomePull();
	incomePull.setIncomeId(new Long(incomeId));
	
	List incomePulls = incomePullManager.getIncomePulls(incomePull);
	List orders = incomePullManager.getOrdersByIncomeId(incomeId);
	for(Iterator it=incomePulls.iterator();it.hasNext();){
		IncomePull inPull = (IncomePull)it.next();
		FusionChartObject fObjects = new FusionChartObject();
		
		for(int i=1;i<=10;i++){
			switch(i){
				case 1:
					fObjects.setValue1("");break;
				case 2:
					fObjects.setValue2("");break;
				case 3:
					fObjects.setValue3("");break;
				case 4:
					fObjects.setValue4(inPull.getCarrier().getCarrierName());break;
				case 5:
					fObjects.setValue5(inPull.getFullName());break;
				case 6:  
					fObjects.setValue6("");break;
				case 7:
					fObjects.setValue7(""+inPull.getMoneyPull());break;
				case 8:
					fObjects.setValue8("");break;
				case 9:
					fObjects.setValue9("");break;
				case 10:  
					fObjects.setValue10("");break;
				default :
			}
		}
		coll.add(fObjects);
		for(Iterator its=orders.iterator();its.hasNext();){
			IncomePull incomePll = (IncomePull)its.next();
			FusionChartObject fObject = new FusionChartObject();
			if(incomePll.getResourceCarrierId().equals(inPull.getResourceCarrierId())){
				for(int i=1;i<=10;i++){
					switch(i){
						case 1:
							fObject.setValue1("");break;
						case 2:
							fObject.setValue2("");break;
						case 3:
							fObject.setValue3("");break;
						case 4:
							fObject.setValue4("");break;
						case 5:
							fObject.setValue5("");break;
						case 6:  
							fObject.setValue6(incomePll.getIncomeCode());break;
						case 7:  
							fObject.setValue7(""+incomePll.getMoneyIn());break; 
						case 8:
							fObject.setValue8("");break;
						case 9:
							fObject.setValue9("");break;
						case 10:
							fObject.setValue10("");break;            
						default :
					}
				}
				coll.add(fObject);
			}
		}
		
	}
	
	return coll;
}

public Map getAccountFromMap(Account account) {
	
	List ls = dao.getAccount(account);
	
	Map reply = new LinkedHashMap();
	reply.put("0","==选择账户==");
    Iterator it = ls.iterator();
    
    while(it.hasNext()){
    	Account acc= (Account) it.next();
    	reply.put(acc.getId(),acc.getNo()+"("+acc.getName()+")");
    }
	return reply;
}

private static  boolean getSequenceIncomeAuto(){
    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
    if(StringUtils.isEmpty(sysParam.getSequenceIncomeAutoParam())) sysParam.setSequenceIncomeAutoParam("0");
    return (sysParam.getSequenceIncomeAutoParam().equals("0"))?false:true;
}






public String getIncomeXML2(Income inc,String pageIndex, String pageSize){
	
//	boolean isSignUserBalance = SysParamUtil.isSignUserBalance();
	
//	System.out.print("inc  >>>>>>>>>>>>>>> "+inc);
	

	
	List all = dao.getIncomesPage2(inc,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));

	

	StringBuffer sb  = new StringBuffer();
	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<rows>");  
	
	int i = 1;
	
	for(Iterator it = all.iterator();it.hasNext();){
		Income income = (Income) it.next();
		
		int index = Integer.parseInt(pageIndex)*Integer.parseInt(pageSize) + i++;
		String incomeCode = income.getIncomeCode();
		String incomeDate =  DateUtil.SetDateFormat(income.getIncomeDate().toString(),"yyyy/MM/dd");
		String pullDate = DateUtil.SetDateFormat(income.getIncomePullDate().toString(),"yyyy/MM");
		String customerName = income.getCustomer().getCustomerName();
		String busness = income.getUser().getFullName();
		String incomeMoney =  StringUtil.doubleFormat2(income.getIncomeMoney());
		String incomeUsed =  StringUtil.doubleFormat2(income.getIncomeUsed());
		String incomeMode =income.getIncomeMode().getName();
		String incomePurpose = income.getIncomePurpose().getName();
		
		
		String memo = income.getMemo()==null?"":income.getMemo();

		sb.append("<row  id=\""+ income.getId()  +"\">");
		
		sb.append("<cell><![CDATA["+ index +"]]></cell>");
		sb.append("<cell><![CDATA["+ incomeCode +"]]></cell>");
		sb.append("<cell><![CDATA["+ incomeDate +"]]></cell>");
		sb.append("<cell><![CDATA["+ pullDate +"]]></cell>");
		sb.append("<cell><![CDATA["+ customerName+"]]></cell>");
		sb.append("<cell><![CDATA["+ busness +"]]></cell>");
		sb.append("<cell><![CDATA["+ incomeMoney +"]]></cell>");
		sb.append("<cell><![CDATA["+ incomeUsed +"]]></cell>");
		sb.append("<cell><![CDATA["+ incomePurpose +"]]></cell>");
		sb.append("<cell><![CDATA["+ memo +"]]></cell>");
		sb.append("</row>");

	 }
	
	
	
	//求合计
	Income incom = dao.getIncomesPageSum(inc);

	if(incom.getIncomeMoney().doubleValue() > 0){
			String incomeMoney =  StringUtil.doubleFormat2(incom.getIncomeMoney());
			String incomeUsed =  StringUtil.doubleFormat2(incom.getIncomeUsed());
			sb.append("<row  id=\""+"sum"  +"\">");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ ""+"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ incomeMoney +"]]></cell>");
			sb.append("<cell><![CDATA["+ incomeUsed +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("<cell><![CDATA["+ "" +"]]></cell>");
			sb.append("</row>");
	}

	
	
	
	
	sb.append("</rows>");
	
	return sb.toString();	
}
  
public List getIncomeCodeStoreList(String queryString) {
//	System.out.println("getStoreList<<<<<<<1111111111111<<<<<<<<<<"+ queryString);
	Map mp = StringUtil.convertQueryStringtoMap(queryString);
//	System.out.println("getStoreList<<<<<<<1111111111111<<<<<<<<<<"+ mp);
	String incomeCode = StringUtil.getNullValue(mp.get("incomeCode"),null);
	if (incomeCode == null || "".equals(incomeCode)){
		return null;
	}else{
		return dao.getIncomeCodeStoreList(mp);
	}
	
}



public String getBalanceParaSortXml(String strQueryString){
	StringBuffer sb=new StringBuffer();
	
//	log.info("getBalanceParaSortXml>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd>>>>>>>>>"+strQueryString );
	List ls = (List)getCollectionsBalanceParaSort(strQueryString);
	IncomePull incp = (IncomePull)ls.get(ls.size()-1);
	ls.remove(ls.size()-1);
	
	String fenpeiInfo2 =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"fenpeiInfo2"),"");	
	String groupModel =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"groupModel"),"");	
//	log.info("getBalanceParaSortXml>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd>>>>>>>>>" +ls.size());
//	log.info("getBalanceParaSortXml>>>>>>>>>>>>>>>>>>>>>>>>>fenpeiInfo2>>>>>>>>>" +fenpeiInfo2);
//	log.info("getBalanceParaSortXml>>>>>>>>>>>>>>>>>>>>>>>>>groupModel>>>>>>>>>" +groupModel);
	double sumMoneyIn=0;
	double sumIncomeMoney=0;
	double sumLeaveMoney=0;
	Map mapKey = new HashMap();
	Map mapMoneyInSub = new HashMap();
	Map mapMoneyInSubRate = new HashMap();
	Map mapLeaveMoneySub = new HashMap();
	Map mapChannelKey = new HashMap();
	
	for (Iterator it = ls.iterator(); it.hasNext();) {
		IncomePull incomePull =(IncomePull)it.next();
		Income income = incomePull.getIncome();
		ResourceChannel resourceChannel = incomePull.getCarrier().getResourceChannel();
		String resourceChannelName = resourceChannel.getName();
		String resourceChannelId = resourceChannel.getId().toString();
		String incomeDate = income.getIncomeDate().toString();
//		String kye1 = resourceChannelName;
		String kye1 = resourceChannelId;
		String value = resourceChannelName;
		
		if("2".equals(fenpeiInfo2)){
			kye1 = resourceChannelId;
			value = resourceChannelName;
		}
		
		if("3".equals(fenpeiInfo2)){
			kye1 = resourceChannelName;
			value = resourceChannelName;
		}
		
		if(!"0".equals(incomeDate)){
			kye1="("+incomeDate+") " +kye1;
			value="("+incomeDate+") " +value;
		}
		
		
		
		if(income.getIncomeUsed().doubleValue()>0){
			
			
			
				if(mapKey.containsKey(kye1)){
					List ls2 = (List)mapKey.get(kye1);
					ls2.add(incomePull);
					mapKey.put(kye1,ls2);
				}else{
					List ls2 = new ArrayList();
					ls2.add(incomePull);
					
//					log.info("kye1>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd>>>>>>>>>"+kye1 );
					mapKey.put(kye1,ls2);
				}
		
				sumMoneyIn+=income.getIncomeUsed().doubleValue();

				
				mapChannelKey.put(kye1,value);
				
		}
		
//		sumIncomeMoney+=income.getIncomeMoney().doubleValue();
//		log.info("income.getIncomeMoney().doubleValue()>>>>>>>>>>>>>>>>>>>>>>>>>income.getIncomeMoney().doubleValue()                  >>>>>>>>>"+income.getIncomeMoney().doubleValue() );
		
	}
	
	sumIncomeMoney = incp.getIncome().getIncomeMoney().doubleValue();
	
	sumLeaveMoney = sumIncomeMoney - sumMoneyIn;
	
//	log.info("sumIncomeMoney>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd                  >>>>>>>>>"+incp.getIncome().getIncomeMoney().doubleValue() );
//	log.info("sumMoneyIn>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd                      >>>>>>>>>"+sumMoneyIn );
//	log.info("sumLeaveMoney>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd                   >>>>>>>>>"+sumLeaveMoney );
	
  List list = new LinkedList(mapKey.keySet());
//  CollectionUtils.addAll(list,mapKey.keySet().iterator());
  Collections.sort(list,new ChannelComparator());


	
	for (Iterator it = list.iterator(); it.hasNext();) {
		String key =(String)it.next();
		
//		log.info("key>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd>>>>>>>>>"+key );
		
		List ls2 = (List)mapKey.get(key);
		double moneyIn = 0;
//		double incomeMoney = 0;
//		double moneyLeave = 0;
		for (Iterator it2 = ls2.iterator(); it2.hasNext();) {
			IncomePull incomePull =(IncomePull)it2.next();
			Income income = incomePull.getIncome();
			moneyIn+=income.getIncomeUsed().doubleValue();
//			incomeMoney+=income.getIncomeMoney().doubleValue();

		}
//		moneyLeave=incomeMoney-moneyIn;
		

		if(sumMoneyIn == 0) sumMoneyIn = 1;
		
//		sumIncomeMoney
		double sss = moneyIn/sumMoneyIn*100;
		
		mapMoneyInSub.put(key,new Double(moneyIn));
		mapLeaveMoneySub.put(key,new Double(sumLeaveMoney*(moneyIn/sumMoneyIn)));
		mapMoneyInSubRate.put(key,new Double(sss));
		
		
		
		
	}

	
	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<rows>");  
	
	int k = 0;
	for (Iterator it = list.iterator(); it.hasNext();) {
		String key =(String)it.next();
		List ls2 = (List)mapKey.get(key);

		double moneyInSub = Double.parseDouble(StringUtil.doubleFormat2((Double)mapMoneyInSub.get(key)));
		double leavemoneySub = Double.parseDouble(StringUtil.doubleFormat2((Double)mapLeaveMoneySub.get(key)));
		
		
		String rate0 =  StringUtil.doubleFormat2(new Double(moneyInSub/sumMoneyIn*100))+"%";

              
		         int ii = 0;
				for (Iterator it2 = ls2.iterator(); it2.hasNext();) {
					IncomePull incomePull =(IncomePull)it2.next();
					Income income = incomePull.getIncome();
					String resourceSortName = income.getIncomePublic().getResourceSortName();
					
					if("4".equals(fenpeiInfo2) && "1".equals(groupModel) ){
						resourceSortName = StringUtil.converNum2cnMonth(""+Integer.parseInt(resourceSortName));
					}
					
					String incomeDate = income.getIncomeDate().toString();
//					if(!"0".equals(incomeDate)) resourceSortName=resourceSortName+incomeDate;
					
					double incomeUsed = Double.parseDouble(StringUtil.doubleFormat2(income.getIncomeUsed()));
					
					String rate =  StringUtil.doubleFormat2(new Double(incomeUsed/moneyInSub*100))+"%";
					
					if(ii >0) key ="";
					ii++;
					sb.append("<row  id=\""+ k++ +"\"" +"  style=\""+ "" +"\">");
					sb.append("<cell><![CDATA["+ StringUtil.getNullValue((String)mapChannelKey.get(key),"")  +"]]></cell>");	
					sb.append("<cell><![CDATA["+ resourceSortName  +"]]></cell>");	
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(income.getIncomeUsed())  +"]]></cell>");	
					sb.append("<cell><![CDATA["+ rate  +"]]></cell>");
					sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(leavemoneySub*(incomeUsed/moneyInSub)))  +"]]></cell>");
					sb.append("</row>");
				}
				
//				if(ls2.size()>1){
					 		sb.append("<row  id=\""+ k*ii +"\"" +"  style=\""+ "" +"\">");
					    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");	
					    sb.append("<cell><![CDATA["+ "  小计"  +"]]></cell>");	
					    sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(moneyInSub))  +"]]></cell>");
					    sb.append("<cell><![CDATA["+ rate0  +"]]></cell>");
					    sb.append("<cell><![CDATA["+   StringUtil.doubleFormat3(new Double(leavemoneySub)) +"]]></cell>");
					    sb.append("</row>");   
//				}
                  
		}
	 
	
	 		sb.append("<row  id=\""+ 9999 +"\"" +"  style=\""+ "" +"\">");
	    sb.append("<cell><![CDATA["+ "合计"  +"]]></cell>");	
	    sb.append("<cell><![CDATA["+ "到款: "+ StringUtil.doubleFormat3(new Double(sumIncomeMoney))  +"]]></cell>");	
	    sb.append("<cell><![CDATA["+   StringUtil.doubleFormat3(new Double(sumMoneyIn)) +"]]></cell>");
	    sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
	    sb.append("<cell><![CDATA["+ StringUtil.doubleFormat3(new Double(sumLeaveMoney))  +"]]></cell>");
	    sb.append("</row>");    
	    
	sb.append("</rows>");	

			
	return sb.toString();
}




public Collection getCollectionsBalanceParaSort(String strQueryString){

	Collection coll = new ArrayList();
	List valuecoll2 = new ArrayList();
	Map searchMap = this.buildsearchMap(strQueryString);
	int posStart = -1;
	
	List valuecoll = dao.getIncomesListNew(searchMap,posStart,-1);
	 Object[] objs =  ConvertUtil.getColFromList(valuecoll,"id");
	List incomePullIdList =new ArrayList();
	org.apache.commons.collections.CollectionUtils.addAll(incomePullIdList,objs);
	
//	Map map = new HashMap();
	searchMap.put("incomePullIdList",incomePullIdList);
	

	
	
//	log.info("getCollectionsBalanceParaSort incomePullIdList>>>>>>>>>>>>>>>>>>>>>>>>>incomePullIdList>>>>>>>>>"+incomePullIdList );
	
	List ls = dao.getCollectionsBalanceParaSort2(searchMap);
	


	
	
	String print2 = StringUtil.getNullValue(searchMap.get("print2"),"");
	String model= StringUtil.getNullValue(searchMap.get("model"),"");
	String fenpeiInfo2= StringUtil.getNullValue(searchMap.get("fenpeiInfo2"),"");
	String groupModel= StringUtil.getNullValue(searchMap.get("groupModel"),"");
	
//	String fenpeiInfo =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"fenpeiInfo"),"");	
	
//	log.info("fenpeiInfo>>>>>>>>>>>>>>>>>>>>>>>>>getCollectionsBalanceParaSort>>>>>>>>>"+fenpeiInfo );
//	log.info("print2>>>>>>>>>>>>>>>>>>>>>>>>>getCollectionsBalanceParaSort>>>>>>>>>"+print2 );
//	log.info("model>>>>>>>>>>>>>>>>>>>>>>>>>getCollectionsBalanceParaSort>>>>>>>>>"+model );
//	log.info("groupModel>>>>>>>>>>>>>>>>>>>>>>>>>getCollectionsBalanceParaSort>>>>>>>>>"+groupModel );
	
//	StringUtilsv.printMap(searchMap);
	
	
	if("".equals(model)){
		IncomePull inc = dao.getBalanceParaSortIncome(searchMap);
		ls.add(ls.size(),inc);
//		log.info(">>>>>>>>>>>>>>>>>>>>>99999 888 666 5>>>>>>>>>"+StringUtil.doubleFormat3(inc.getIncome().getIncomeMoney()) );
	}
	
	if("export".equals(model)||"print".equals(model)){
		IncomePull incc = dao.getBalanceParaSortIncome(searchMap);

		double sumIncomeMoney = incc.getIncome().getIncomeMoney().doubleValue();
		double sumLeaveMoney=0;
		double sumMoneyIn=0;
		Map mapKey = new HashMap();
		Map mapMoneyInSub = new HashMap();
		Map mapLeaveMoneySub = new HashMap();
		Map mapMoneyInSubRate = new HashMap();
		Map mapChannelKey = new HashMap();
		
		
		
		for (Iterator it = ls.iterator(); it.hasNext();) {
			IncomePull incomePull =(IncomePull)it.next();
			Income income = incomePull.getIncome();
			ResourceChannel resourceChannel = incomePull.getCarrier().getResourceChannel();
			String resourceChannelId = resourceChannel.getId().toString();
			String resourceChannelName = resourceChannel.getName();
			String incomeDate = income.getIncomeDate().toString();
			
			String kye1 = resourceChannelId;
			String value = resourceChannelName;
			
			if("2".equals(fenpeiInfo2)){
				kye1 = resourceChannelId;
				value = resourceChannelName;
			}
			
			if("3".equals(fenpeiInfo2)){
				kye1 = resourceChannelName;
				value = resourceChannelName;
			}
			
			if(!"0".equals(incomeDate)){
				kye1="("+incomeDate+") " +kye1;
				value="("+incomeDate+") " +value;
			}		
			
			if(mapKey.containsKey(kye1)){
				List ls2 = (List)mapKey.get(kye1);
				ls2.add(incomePull);
				mapKey.put(kye1,ls2);
			}else{
				List ls2 = new ArrayList();
				ls2.add(incomePull);
				mapKey.put(kye1,ls2);
			}

			sumMoneyIn+=income.getIncomeUsed().doubleValue();
			mapChannelKey.put(kye1,value);
			
		}
		
		sumLeaveMoney = sumIncomeMoney - sumMoneyIn;

	  List list = new LinkedList(mapKey.keySet());
	  Collections.sort(list,new ChannelComparator());


		
		for (Iterator it = list.iterator(); it.hasNext();) {
			String key =(String)it.next();

			List ls2 = (List)mapKey.get(key);
			double moneyIn = 0;
			for (Iterator it2 = ls2.iterator(); it2.hasNext();) {
				IncomePull incomePull =(IncomePull)it2.next();
				Income income = incomePull.getIncome();
				moneyIn+=income.getIncomeUsed().doubleValue();
			}

			if(sumMoneyIn == 0) sumMoneyIn = 1;
			double sss = moneyIn/sumMoneyIn*100;
			
			mapMoneyInSub.put(key,new Double(moneyIn));
			mapLeaveMoneySub.put(key,new Double(sumLeaveMoney*(moneyIn/sumMoneyIn)));
			mapMoneyInSubRate.put(key,new Double(sss));
			
		}


		int k = 0;
		for (Iterator it = list.iterator(); it.hasNext();) {
			
					String key =(String)it.next();
					
					List ls2 = (List)mapKey.get(key);
		
					double moneyInSub = Double.parseDouble(StringUtil.doubleFormat2((Double)mapMoneyInSub.get(key)));
					double leavemoneySub = Double.parseDouble(StringUtil.doubleFormat2((Double)mapLeaveMoneySub.get(key)));
					String rate0 =  StringUtil.doubleFormat2(new Double(moneyInSub/sumMoneyIn*100))+"%";

	              
			   int ii = 0;
					for (Iterator it2 = ls2.iterator(); it2.hasNext();) {
						IncomePull incomePull =(IncomePull)it2.next();
						Income income = incomePull.getIncome();
						String resourceSortName = income.getIncomePublic().getResourceSortName();
						
						if("4".equals(fenpeiInfo2) && "1".equals(groupModel) ){
							resourceSortName = StringUtil.converNum2cnMonth(""+Integer.parseInt(resourceSortName));
						}
						
						double incomeUsed = Double.parseDouble(StringUtil.doubleFormat2(income.getIncomeUsed()));
						String rate =  StringUtil.doubleFormat2(new Double(incomeUsed/moneyInSub*100))+"%";
						
						if(ii >0) key ="";
						ii++;
						FusionChartObject fObject = new FusionChartObject();
//						StringUtil.getNullValue((String)mapChannelKey.get(key),"")
						fObject.setLable(StringUtil.getNullValue((String)mapChannelKey.get(key),""));
						fObject.setValue1(resourceSortName);
						fObject.setValue2(StringUtil.doubleFormat3(income.getIncomeUsed()));
						fObject.setValue3(rate);
						fObject.setValue4(StringUtil.doubleFormat3(new Double(leavemoneySub*(incomeUsed/moneyInSub))));

						valuecoll2.add(fObject);		

					}
//					if(ls2.size()>1){
						FusionChartObject fObject2 = new FusionChartObject();
						fObject2.setLable("");
						fObject2.setValue1("小计:");
						fObject2.setValue2(StringUtil.doubleFormat3(new Double(moneyInSub)));
						fObject2.setValue3(rate0);			
						fObject2.setValue4(StringUtil.doubleFormat3(new Double(leavemoneySub)));			
						valuecoll2.add(fObject2);	
//					}


		

			}
		

		
		
		if(valuecoll.size()>1){
			FusionChartObject fObject3 = new FusionChartObject();
			fObject3.setLable("合计");
			fObject3.setValue1("到款: "+ StringUtil.doubleFormat3(new Double(sumIncomeMoney)));
			fObject3.setValue2(StringUtil.doubleFormat3(new Double(sumMoneyIn)));
			fObject3.setValue3("");
			fObject3.setValue4(StringUtil.doubleFormat3(new Double(sumLeaveMoney)));
			valuecoll2.add(fObject3);			
		}
		
//		log.info("valuecoll size>>>>>>>>>>>>>>>>>>>>>>>>>getCollectionsBalanceParaSort>>>>>>>>>"+valuecoll2.size() );
		CollectionUtils.addAll(coll,valuecoll2.iterator());	
		
	 }else{
		 CollectionUtils.addAll(coll,ls.iterator());	
	 }
	
	return coll;


}


public Map buildsearchMap(String strQueryString){
	Map mp = new HashMap();
	List yearIdList = new ArrayList();
	List customerIdList = new ArrayList();
	List userIdList = new ArrayList();
	List carrierIdList = new ArrayList();
	List channelIdList = new ArrayList();
	
	
//	log.info("carriers>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd>>>>>>>>>" );
	String orgId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"orgId"));
	String customerName = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"customerName"));
	String customerId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"customerId"));
	String customerIds = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"customerIds"));
	String userIds = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"userIds"));
	

	String incomeMonthDay = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"incomeMonthDay"));
	String startDay = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"startDay"));
	String endDay = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"endDay"));
	
	String fenpeiInfo = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"fenpeiInfo"));
	String fenpeiInfo2 = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"fenpeiInfo2"));
	
//	log.info("fenpeiInfo2>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd>>>>>>>>>"+fenpeiInfo2 );
	String print2 = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"print2"));
//	log.info("print2>>>>>>>>>>>>>>>>>>>>>>>>>dddddddddd>>>>>>>>>"+print2 );
	String model = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"model"));

	
	
	String year = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"year"));
	String incomeCode = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"incomeCode"));
	String incomeId = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"incomeId"));
	String carriers = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"carriers"));
	String channels = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"channels"));
	String loginUser = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"loginUser"));	
	
	String groupModel = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"groupModel"));	
	
	log.info("groupModel>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + groupModel);
	log.info("year>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + year);
	log.info("incomeMonthDay>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + incomeMonthDay);
	log.info("loginUser>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + loginUser);
	
//	log.info("customerName>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + customerName);
//	log.info("userIds>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + userIds);
//	log.info("carriers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + carriers);
	
	if(!"".equals(groupModel)){
		mp.put("groupModel",groupModel);
	}
	
	if(!"".equals(orgId)){
		mp.put("orgId",orgId);
	}
	
	
  if(!"".equals(customerId) && !"0".equals(customerId)){
		mp.put("customerId",customerId);
	} 
  

  
  
	if(!"".equals(customerIds)){
		String[] custids = customerIds.split(",");
		org.apache.commons.collections.CollectionUtils.addAll(customerIdList,custids);
		mp.put("customerIdList",customerIdList);
	}  
	
  
	if(!"".equals(startDay)){
		mp.put("startDay",startDay);
	}
	
	if(!"".equals(endDay)){
		mp.put("endDay",endDay);
	}
	
	
	if(!"".equals(incomeCode)){
		mp.put("incomeCode",incomeCode);
	}
	if(!"".equals(incomeId)){
		mp.put("incomeId",incomeId);
	}
	
	if(!"".equals(customerName)){
		mp.put("customerName",customerName);
	}
	
	if(!"".equals(userIds)){
		String[] uids = userIds.split(",");
		org.apache.commons.collections.CollectionUtils.addAll(userIdList,uids);
		mp.put("userIdList",userIdList);
	}  
	
	if(!"".equals(carriers)){
		String[] cars = carriers.split(",");
		org.apache.commons.collections.CollectionUtils.addAll(carrierIdList,cars);
		mp.put("carrierIdList",carrierIdList);
	}  	
	if(!"".equals(channels)){
		String[] chas = channels.split(",");
		org.apache.commons.collections.CollectionUtils.addAll(channelIdList,chas);
		mp.put("channelIdList",channelIdList);
	} 	
	if(!"".equals(incomeMonthDay)){
		mp.put("incomeMonthDay",incomeMonthDay);
	}
	
	if(!"".equals(fenpeiInfo)){
		mp.put("fenpeiInfo",fenpeiInfo);
	}
	if(!"".equals(fenpeiInfo2)){
		mp.put("fenpeiInfo2",fenpeiInfo2);
	}
	
 	if(UserUtil.isUserOrderYearRel()) {
 		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
 	}
 	
// 	log.info("UserUtil.getUserYearRelByLoginUser(loginUser)>>>>>>>>>>888888888888888888888>>>>>>>>>>>>>>>>>>>>>>>>" + UserUtil.getUserYearRelByLoginUser(loginUser));
 	
	if(!"".equals(year) && !"0".equals(year)){
		mp.put("year",year); 
	}  
	
	if(!"".equals(print2) && !"0".equals(print2)){
		mp.put("print2",print2); 
	}  
	
	if(!"".equals(model) && !"0".equals(model)){
		mp.put("model",model); 
	}  	
	
	
//	if(!"".equals(year)){
//		String[] years = year.split(",");
//		org.apache.commons.collections.CollectionUtils.addAll(yearIdList,years);
//		mp.put("yearIdList",yearIdList); 
//	}  
	
//	mp.put("yearIdList",yearIdList);
	mp.put("userIdList",userIdList);
//	mp.put("carrierIdList",carrierIdList);
//	mp.put("customerName",customerName);
	
	return mp;
	
}
public Income getCountSum(Map searchMap) {
	Income incom = dao.getIncomesSumNew(searchMap);
	return incom;
}
public Collection getCollections(Map searchMap, String type, int posStart, int count) {
	
	
	System.out.println(">>>>>>>>>>>>>>>>>>>>type.equals()>>>>>>>>>>>>>>>>>>type>>>>>>>>>>>>>>>>>>>>>>>>>>  "+type);
	
	Collection coll = new ArrayList();
	List valuecoll = new ArrayList();

	if("1".equals(type)){
		
		valuecoll = dao.getIncomesListNew(searchMap,posStart,count);
		
		
	}	else if(type.equals("report")){
		
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>type.equals()>>>>>>>>>>>>>>>>>>>3>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+type.equals("report"));
		
		int cols = 13;
		Collection ls =  dao.getIncomesListNew(searchMap,posStart,count);
		int rowIndex = 1;
		for(Iterator it = ls.iterator();it.hasNext();){
			
			IncomePull incomePull =(IncomePull)it.next();
			Income income = incomePull.getIncome();
			ResourceChannel resourceChannel = incomePull.getCarrier().getResourceChannel();
		

			
			FusionChartObject fObject = new FusionChartObject();
			
					for(int i=0;i<cols+1;i++){
						
						switch(i){
					
							case 1:
								fObject.setLable(""+rowIndex++);break;
							case 2:
								fObject.setValue1(StringUtil.null2String(income.getIncomeCode()));break;
							case 3:
								fObject.setValue2(DateUtil.SetDateFormat(income.getIncomeDate().toString(),"yyyy/MM/dd"));break;
							case 4:
								fObject.setValue3(DateUtil.SetDateFormat(income.getIncomePullDate().toString(),"yyyy"));break;
							case 5:
								fObject.setValue4(StringUtil.null2String(income.getCustomer().getCustomerName()));break;
							case 6:
								fObject.setValue5(StringUtil.null2String(income.getUser().getFullName()));break;
							case 7:
								fObject.setValue6(StringUtil.null2String(resourceChannel.getName()));break;
							case 8:	
								fObject.setValue7(StringUtil.doubleFormat3(income.getIncomeMoney()));break;
							case 9:
								fObject.setValue8(StringUtil.doubleFormat3(income.getIncomeUsed()));break;
							case 10:
								fObject.setValue9(StringUtil.doubleFormat3(new Double(income.getIncomeMoney().doubleValue()-income.getIncomeUsed().doubleValue())));break;
							case 11:
								fObject.setValue10(StringUtil.null2String(income.getIncomePurpose().getName()));break;
							case 12:	
								fObject.setValue11(StringUtil.null2String(income.getIncomeMode().getName()));break;		
							case 13:	
								fObject.setValue12(StringUtil.null2String(income.getMemo()));break;										
								
							default :
						}
					}		
					valuecoll.add(fObject);
		}
		
		
	}else{
		
	}
	
	CollectionUtils.addAll(coll,valuecoll.iterator());
	
	return coll;
}


}






	












