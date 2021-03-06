package com.vriche.adrm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.dao.IncomeUsedDao;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.model.CContractPayment;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.IncomePull;
import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.util.ContractPayMentComparator;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class ContractPaymentManagerImpl extends BaseManager implements ContractPaymentManager {
    private ContractPaymentDao dao;
    
    private IncomeUsedDao incomeUsedDao;
    
    private IncomePullDao incomePullDao;
    
    private OrderDayInfoDao orderDayInfoDao;
    
    private ResourceManager resourceManager;
    
    private OrderDetailDao orderDetailDao;
    
    private CustomerDao customerDao;
    
    public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setOrderDayInfoDao(OrderDayInfoDao orderDayInfoDao) { 
		this.orderDayInfoDao = orderDayInfoDao;
	}

	/**
	 * @param incomeUsedDao The incomeUsedDao to set.
	 */
	public void setIncomeUsedDao(IncomeUsedDao incomeUsedDao) {
		this.incomeUsedDao = incomeUsedDao;
	}

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setContractPaymentDao(ContractPaymentDao dao) {
        this.dao = dao;
    }

	public void setIncomePullDao(IncomePullDao incomePullDao) {
		this.incomePullDao = incomePullDao;
	}

	/**
	 * @param orderDetailDao The orderDetailDao to set.
	 */
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}
    
	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
    
    
    
    
    
    
    
    
    
    

    public String getContractPaymentsCount(ContractPayment contractPayment) {
		return dao.getContractPaymentsCount(contractPayment).toString();
	}

	public PaginatedList getContractPaymentsPage(ContractPayment contractPayment, String pageIndex, String pageSize) {
		return dao.getContractPaymentsPage(contractPayment,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public List getContractPaymentsPageByMap(ContractPayment contractPayment,String carrierId, String pageIndex, String pageSize) {
		Map mp = new HashMap();
		mp.put("customerId",contractPayment.getCustomerId());
		
		if(carrierId!=null && carrierId !="0"){
//			System.out.println("carrierId1111111111>>>>>>>>>>>>>>....  "+carrierId);
			List resourceIds =  resourceManager.getResourceIdsForPutOn(carrierId);
			mp.put("resourceIdList",resourceIds);
		}else{
			mp.put("resourceIdList",null);
		}
		List ls = dao.getContractPaymentsPageByMap(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		
		return replaceOrderCode(ls);
	}
	
	private List replaceOrderCode(List ls){
		for(Iterator it = ls.iterator();it.hasNext();){
			ContractPayment contractPayment = (ContractPayment)it.next();
			System.out.println(contractPayment.getOrderId().longValue()==0);
			
			if(contractPayment.getOrderId().longValue()==0){
				contractPayment.setOrderCode("");
			}
		}
			return ls;
	}
	
	public String getContractPaymentsCount_nopay(ContractPayment contractPayment) {
		return dao.getContractPaymentsCount_nopay(contractPayment).toString();
	}

	public PaginatedList getContractPaymentsPage_nopay(ContractPayment contractPayment, String pageIndex, String pageSize) {
//		System.out.println("contractPayment="+contractPayment);
//		Long paymentId = contractPayment.getId();
		
//		System.out.println("paymentId="+paymentId);
//		
//		Double moneyIn = incomeUsedDao.getMoneyInByPaymentId(paymentId);
//		
//		System.out.println("moneyIn="+moneyIn);
//		
//		contractPayment.setMoneyIn(moneyIn);
		
		return dao.getContractPaymentsPage_nopay(contractPayment,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	/**
     * @see com.vriche.adrm.order.service.ContractPaymentManager#getContractPaymentsByIdList(final Map idList)
     */
    public List getContractPaymentsByIdList(final Map idList) {
        return dao.getContractPaymentsByIdList(idList);
    }  
   /**
     * @see com.vriche.adrm.order.service.ContractPaymentManager#getContractPayments(com.vriche.adrm.order.model.ContractPayment)
     */
    public List getContractPayments(final ContractPayment contractPayment) {
    	List lss = dao.getContractPayments(contractPayment);
    	
        return lss;
    }
    
    public String getContractPaymentsTable(final ContractPayment contractPayment) {
    	
       List ls = dao.getOrderSysPriceInContract(contractPayment);
       
       String str = "";
       double sysPrice = 0;
       int sumTimes = 0;
       double sumMoneyPay = 0;
       double statandSysPrice = 0;
       
  

       for(Iterator it = ls.iterator();it.hasNext();){
			ContractPayment pmts = (ContractPayment)it.next();
			boolean isParent = (pmts.getVersion().intValue() == 0);
			Double moneyPay = pmts.getMoneyPay() == null?new Double(0):pmts.getMoneyPay();
			Double sys_price = pmts.getMoneyIn() == null?new Double(0):pmts.getMoneyIn();
			Integer sum_times = pmts.getPayNumber() == null?new Integer(0):pmts.getPayNumber();
			sysPrice = sys_price.doubleValue();
			sumTimes = sum_times.intValue();
			
			if(isParent) {
				sumMoneyPay = sumMoneyPay + moneyPay.doubleValue();
			}
			
			statandSysPrice = statandSysPrice + sysPrice*sumTimes;
		}
       String persent = StringUtil.persentFormat(sumMoneyPay,statandSysPrice);
       str = "备注：［应付金额：" + sumMoneyPay + "］［刊例金额：" + statandSysPrice + "］［折扣：" + persent +"］" ;

       return str;
   }
    
//    public PaginatedList getContractPayments(final ContractPayment contractPayment, String pageIndex, String pageSize) {
//        return dao.getContractPaymentsPage(contractPayment,new Integer(pageIndex).intValue(),new Integer(pageSize).intValue());
//    }

	public List getOwnerUsersList(Map map) {
		//获取当前用户
	     String currentUser = UserUtil.getCurrentPrincipalUser();
		 List ls = (List)map.get(currentUser);
		 return ls;
	}

    
	    /* (non-Javadoc)
	 * @see com.vriche.adrm.service.ContractPaymentManager#getContractPaymentAutoComplet(com.vriche.adrm.model.ContractPayment)
	 */
	public List getContractPaymentAutoComplet(ContractPayment contractPayment) {
		List payList = new ArrayList();
	   	boolean channelModelParam = SysParamUtil.getChannelModelPara();
	   	boolean hntv = SysParamUtil.isHNTVParam(null);
    	List carrierIdList = new ArrayList();
		if(channelModelParam && hntv){
			Map userCarrierRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_CARRIER_RELS);
			List objs = getOwnerUsersList(userCarrierRelsMap);
			org.apache.commons.collections.CollectionUtils.addAll(carrierIdList,ConvertUtil.getColFromList(objs,"id"));
			contractPayment.setCarrierIdList(carrierIdList);
		}
		
		String contractSorts = StringUtil.getNullValue(contractPayment.getContractSorts(),"");
		
		System.out.println(">>>>>>>>>contractSorts>>>>>>>" +contractSorts);
		
		if(!"".equals(contractSorts)){
			List contractSortIdList = new ArrayList(); 
			org.apache.commons.collections.CollectionUtils.addAll(contractSortIdList,contractSorts.split(","));
			contractPayment.setContractSortIdList(contractSortIdList);
		}


		List ls =  dao.getContractPaymentAutoComplet(contractPayment);
//		
		System.out.println(">>>>>>>>>contractSorts>>>>>>>" +ls.size());
		
		
		
		
		for(Iterator it = ls.iterator();it.hasNext();){
			ContractPayment pmt = (ContractPayment)it.next();
			double moneyIn = pmt.getMoneyIn().doubleValue();
			if(moneyIn == 0) payList.add(pmt);
		}
		return payList;
	}

	/**
     * @see com.vriche.adrm.order.service.ContractPaymentManager#getContractPayment(String id)
     */
    public ContractPayment getContractPayment(final String id) {
        return dao.getContractPayment(new Long(id));
    }

    /**
     * @see com.vriche.adrm.order.service.ContractPaymentManager#saveContractPayment(ContractPayment contractPayment)
     */
    public String saveContractPayment(ContractPayment contractPayment) {
//    	System.out.println(">>>>>>>>>contractPayment>          qqqqqqqqqqqqqqq      >>>>>>" +contractPayment);
        return dao.saveContractPayment(contractPayment).toString();
    }

    /**
     * @see com.vriche.adrm.order.service.ContractPaymentManager#removeContractPayment(String id)
     */
    public void removeContractPayment(final String id) {
        dao.removeContractPayment(new Long(id));
    }

     /**
     * @see com.vriche.adrm.order.service.ContractPaymentManager#removeContractPayments(String Map)
     */
    public void removeContractPayments(final Map idList) {
        dao.removeContractPayments(idList);
    }

    
	public void updateContractPaymentMoneyIn(ContractPayment[] contractPayments, double incomeMoney) {
		List moneyInList = new ArrayList();	
		List moneyUsedList = new ArrayList();
		Map moneyIn = (Map)this.getMoneyIn(contractPayments,incomeMoney)[0];
		Map moneyUsed = (Map)this.getMoneyIn(contractPayments,incomeMoney)[1];
		
		for(int i=0;i<contractPayments.length;i++){
			Map moneyInMap = new HashMap();
			Map moneyUsedMap = new HashMap();
			
			Long payMentId = contractPayments[i].getId();
			moneyInMap.put("id",payMentId);
			moneyInMap.put("moneyIn",moneyIn.get(payMentId));
			moneyInList.add(moneyInMap);
			
			Long incomeId = contractPayments[i].getIncomeId();
			moneyUsedMap.put("incomeId",incomeId);
			moneyUsedMap.put("payMentId",payMentId);
			moneyUsedMap.put("moneyUsed",moneyUsed.get(payMentId));
			moneyUsedList.add(moneyUsedMap);
		}
		dao.updateContractPaymentMoneyIn(moneyInList,moneyUsedList);
	} 
	
	private Object[] getMoneyIn(ContractPayment[] contractPayments,double incomeMoney){
		Map payment = new HashMap();
		Map moneyUsed = new HashMap();
		Object obj[] = new Object[2];
		
		for(int i=0;i<contractPayments.length;i++){
			// 应付
			double moneyPay = contractPayments[i].getMoneyPay().doubleValue();
			/// 已付
			double moneyInOld = contractPayments[i].getMoneyIn().doubleValue();
			// 欠款
			double arrears = moneyPay - moneyInOld;
			//根据到款的剩余金额  判断实际可分配的金额
			double moneyInNew = 0;
			//付款编号
			Long paymentId = contractPayments[i].getId();
			
			//可分配的金额 大于或等于 欠款
			if(incomeMoney >= arrears){
				moneyInNew = moneyPay;
				//获得分配后的 到款余额
				incomeMoney = incomeMoney - arrears;
			}else if(incomeMoney > 0 && incomeMoney < arrears){
				moneyInNew = incomeMoney + moneyInOld;
				incomeMoney = 0;
			}
			payment.put(paymentId,new Double(moneyInNew));

			moneyUsed.put(paymentId,new Double(moneyInNew-moneyInOld));
		}
		obj[0] = payment;
		obj[1] = moneyUsed;
		return obj;
	}

	public List getPaymentsByIncomeUsedAndCarrierIdList(final String pullId,String carrierId, String pageIndex, String pageSize) {
//		System.out.println("incomeId   "+incomeId+"   carrierId   "+carrierId);
		IncomeUsed incomeUsed = new IncomeUsed();
//		incomeUsed.setIncomeId(new Long(incomeId));
		incomeUsed.setIncomePullId(new Long(pullId));

//		List incomeUseds = new ArrayList();
		
		List idList= incomeUsedDao.getIncomeUsedPaymentIds(incomeUsed);
		
		
		Map paymentIds = new HashMap();	
//		List idList = new ArrayList();
		
//		for(Iterator it = incomeUseds.iterator();it.hasNext();){
//			IncomeUsed incomeU = (IncomeUsed)it.next();
//			Long key = incomeU.getPaymentId();
//			if(!paymentIds.containsKey(key)){
//				paymentIds.put(incomeU.getPaymentId(),incomeU);
//				idList.add(key);
//			}
//		}
		if(carrierId!=null && carrierId !="0"){
			List resourceIds =  resourceManager.getResourceIdsForPutOn(carrierId);
//			
			paymentIds.put("resourceIdList",resourceIds);
		}else{
			paymentIds.put("resourceIdList",null);
		}
		for(Iterator it = idList.iterator();it.hasNext();){
			System.out.println("idList   "+it.next());
		}
		paymentIds.put("ContractPaymentIdList", idList);
		List ls = dao.getContractPaymentsByCarrierIdMap(paymentIds,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
//		System.out.println("ls=====   "+ls.size());
		return replaceOrderCode(ls);
	}

	 public String getContractPaymentBackCountByCarrierId(String pullId,String carrierId){
		 IncomeUsed incomeUsed = new IncomeUsed();
//			incomeUsed.setIncomeId(new Long(incomeId));
			incomeUsed.setIncomePullId(new Long(pullId));

//			List incomeUseds = new ArrayList();
			
			List idList = incomeUsedDao.getIncomeUsedPaymentIds(incomeUsed);
			
			
			Map paymentIds = new HashMap();	
//			List idList = new ArrayList();
			
//			for(Iterator it = incomeUseds.iterator();it.hasNext();){
//				IncomeUsed incomeU = (IncomeUsed)it.next();
//				Long key = incomeU.getPaymentId();
//				if(!paymentIds.containsKey(key)){
//					paymentIds.put(incomeU.getPaymentId(),incomeU);
//					idList.add(key);
//				}
//			}
			if(carrierId!=null && carrierId !="0"){
				List resourceIds =  resourceManager.getResourceIdsForPutOn(carrierId);
				paymentIds.put("resourceIdList",resourceIds);
			}else{
				paymentIds.put("resourceIdList",null);
			}
			paymentIds.put("ContractPaymentIdList", idList);
			int size = dao.getContractPaymentsCountByCarrierId(paymentIds).size();
		 return new Integer(size).toString();
	 }
	
	public void returnContractPaymentMoneyIn(String[] paymentIds, String incomeId) {
//		System.out.println("paymentIds===="+paymentIds.length);
		Map idList = new HashMap();
		for(int i=0;i<paymentIds.length;i++){

			String paymentId = paymentIds[i];
			
			idList.put("paymentId",paymentId);
			idList.put("incomeId",incomeId);	
//			System.out.println("idList===="+idList.size());
			incomeUsedDao.deleteIncomeUsedsByPaymentIdAndIncomeId(idList);		
		}
		
	}

	public PaginatedList getContractPaymentsPageByIdList(ContractPayment contractPayment, String pageIndex, String pageSize) {
//		System.out.println("pageIndex==+==" +pageIndex);
//		System.out.println("pageSize==+==" + pageSize);
		
		
		List ls = dao.getContractPayments(contractPayment);
//		System.out.println("ls==+==" + ls.size());

		Map mp = ConvertUtil.convertListToMap(ls,"id");
		
//		System.out.println("mp==+==" + mp.size());
		
		List idList = getPaymentIdList(mp);
		
		Map map = new HashMap();
		
		map.put("ContractPaymentIdList",idList);
		
		return dao.getContractPaymentsPageByIdList(map,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}


	public String getContractPaymentCountByMap(ContractPayment contractPayment,String carrierId) {
	
		Map m = new HashMap();
//		Map map = new HashMap();
		m.put("customerId",contractPayment.getCustomerId());
		
//		System.out.println(">>>>>>carrierId>>>>>>>>>>>" +carrierId);
//		System.out.println(">>>>>>carrierId>>>>>>>>>>>" +(carrierId!="0"));
		
		if(carrierId!=null && carrierId!="0"){
			List resourceIds =  resourceManager.getResourceIdsForPutOn(carrierId);
			m.put("resourceIdList",resourceIds);
		}else{
			m.put("resourceIdList",null);
		}
		List ls = dao.getContractPaymentsCountByMap(m);
		
		Map mp = ConvertUtil.convertListToMap(ls,"id");
		
//		System.out.println("mp==+==" + mp.size());
		
		List idList = getPaymentIdList(mp);
		
		Map map = new HashMap();
		
		map.put("ContractPaymentIdList",idList);
		
		return dao.getContractPaymentCountByIdList(map).toString();
	}
	
	public String getContractPaymentCountByIdList(ContractPayment contractPayment) {
		List ls = dao.getContractPayments(contractPayment);
		
		Map mp = ConvertUtil.convertListToMap(ls,"id");
		
//		System.out.println("mp==+==" + mp.size());
		
		List idList = getPaymentIdList(mp);
		
		Map map = new HashMap();
		
		map.put("ContractPaymentIdList",idList);
		
		return dao.getContractPaymentCountByIdList(map).toString();
	}
	
	private List getPaymentIdList(Map mp){
		List idList = new ArrayList();
			
		if(mp.size() == 0){
			idList.add(null);
		}else{	
			for(Iterator it = mp.keySet().iterator();it.hasNext();){
				ContractPayment contractPayment = (ContractPayment)mp.get(it.next());
				Double moneyInOld = contractPayment.getMoneyIn();
				
				if(moneyInOld == null) moneyInOld = new Double(0);
				idList.add(contractPayment.getId());
//				double moneyIn = moneyInOld.doubleValue();
			}		
		}
		return idList;
	}

	public Long getMoneyPayByOrderId(String orderId) {
		Long moneyPaySum = dao.getMoneyPayByOrderId(new Long(orderId));
		
//		System.out.println("moneyPaySum = " + moneyPaySum);
		
		if(moneyPaySum == null){
			return new Long(0);
		}else{
			return moneyPaySum;
		}
	}

	
	public String getPaymentsStringList(List ls) {
		int size = ls.size();
		int i = 1;int j=1;
		StringBuffer sb = new StringBuffer();
		for(Iterator it = ls.iterator();it.hasNext();j++){
			ContractPayment contractPayment =(ContractPayment)it.next();
			sb.append(getOnePaymentsStr(contractPayment,ls));
			if(j == i*3){
				sb.append("\n"+" ");
				i++;
			}
		}

		return sb.toString();
	}

	//得到总的字符串
	private String getOnePaymentsStr(ContractPayment contractPayment,List ls){
		String obj = "";
		String payNumber=number(contractPayment);
		String moneyPay=money(contractPayment,ls);;
//		double moneyPay = contractPayment.getMoneyPay().doubleValue();
		
	     if(!"0.0".equals(moneyPay)){
	 		String payDate = DateUtil.SetDateFormat(contractPayment.getPayDate().toString(),"yyyy/MM/dd") ;
	 		
	 		moneyPay = String.valueOf(Math.floor(Double.parseDouble(moneyPay)));
			obj +="["+"第"+payNumber+"次"+" ";
			obj +="付款日期:"+payDate+" ";
			obj +="应付金额:"+moneyPay+"]"+" ";	
	     }

		return obj;
	}
	//使number值长度相同
	private String number(ContractPayment contractPayment){
		String number = new String();
		if(contractPayment.getPayNumber().toString().length() == 1)
		{
//			System.out.println("0"+contractPayment.getPayNumber().toString());
			number="0"+contractPayment.getPayNumber().toString();
//			System.out.println(number);
//			contractPayment.setPayNumber(number);
			return number;
		}
		else
			return contractPayment.getPayNumber().toString();
		
	}
	//使money值统一
	private String money(ContractPayment contractPayment,List ls){
//		System.out.println(">>>>>>>>List<<<<<<<<   "+ls.size());
	 	int length=length(ls);
	 	String money= new String();
	 	money=contractPayment.getMoneyPay()==null?"0":contractPayment.getMoneyPay().toString();
	 				if(money.length()<length){
					    String nbsp = new String();
						for(int i=0;i<length-(money.length());i++)
						{
							nbsp+=" ";
						}
						money=nbsp+money;
					}
								
		
		return money;
				
	}
	//找到最长值
	private int length(List ls){
		int length_before = 0;  //前一个钱数的长
		int length_after = 0;   //后一个钱数的长
		int length=0;			//以最长的钱数为标准
		String money;
		Iterator itl=ls.iterator();
			while(itl.hasNext())
			{
//				System.out.println(">>>>>>>>List<<<<<<<<   ");
				ContractPayment	contractPayment=(ContractPayment)itl.next();
//				System.out.println(">>>>>>>>getMoneyPay<<<<<<<<   "+contractPayment.getMoneyPay());
				money=contractPayment.getMoneyPay()==null?"0":contractPayment.getMoneyPay().toString();
		
				if(contractPayment.getPayNumber().intValue()==1)
					length_before=money.length();
				else
					length_after=money.length();
		
				if(length_before<length_after){
					length=length_after;
					length_before=length_after;
				}
				else
					length=length_before;
				
			}
			
			return length;
	}
	
//	正常订单 是根据日应收产生催款    协约订单与协约合同是倒
	
	public void saveCuiKuanByNortomOrder(int modle,boolean isMid,String paymentId,String orderId,String customerId,String year,boolean clear){
		
		Map mp = new HashMap();
		Map chMp = new HashMap();
//		long paymentId = Long.parseLong(StringUtil.getNullValue(paymId,"0"));
		Long oId =Long.valueOf(StringUtil.getNullValue(orderId,"0"));
//		Long cId =Long.valueOf(StringUtil.getNullValue(contractId,"0"));
		Long cusId =Long.valueOf(StringUtil.getNullValue(customerId,"0"));
		
		Long pId =Long.valueOf(StringUtil.getNullValue(paymentId,"0"));
		
		Integer date = new Integer(DateUtil.getDate());
		int index = 1;
		//modle == 9 如果不是正常类型也需要自动分类
		//取消分类
		
		if(clear){
			ContractPayment payment1 = new ContractPayment();
			if(modle == 9){
				payment1.setId(pId);
			}else{
				payment1.setOrderId(oId);
			}
				
		   	List paymentList = getContractPayments(payment1);  	
		   	
		   		for(Iterator iter1 = paymentList.iterator();iter1.hasNext();){
	  		   			ContractPayment payment2 =(ContractPayment)iter1.next();
	  		   			payment2.setResourceTypeId(new Long(0));
	  		   			saveContractPayment(payment2);
	  		   	}	
		}else{

			//********************************start****************************		
			
			  if(modle == 1|| modle == 8|| modle == 0){
					
					if(modle == 9){
						mp.put("paymentId",pId);   
					}else{
						mp.put("orderId",oId);   
					}

					if(isMid){
						ContractPayment payment1 = new ContractPayment();
						if(modle == 9){
							payment1.setId(pId);
						}else{
							payment1.setOrderId(oId);
						}
		  				
		  		   		List paymentList = getContractPayments(payment1);  	
		  
		  	  		   		for(Iterator iter1 = paymentList.iterator();iter1.hasNext();){
		  	  		   			ContractPayment payment2 =(ContractPayment)iter1.next();
		  	  		   			String key = StringUtil.getNullValue(payment2.getResourceTypeId(),"0");
		  	  		   			if(chMp.containsKey(key)){
		  	  		   				delContractPayMent(payment2.getContractId(),oId);
		  	  		   			}else{
		  	  		   				chMp.put(key,payment2);
		  	  		   			}
		  	  		   		}		
					}
				
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^pId^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  "+pId);
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^oId^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  "+oId);
					List lsResKeysDetal = orderDetailDao.getResTypeByOrderDetail(mp);
					
					
					if(chMp.keySet().contains(String.valueOf("0")) && chMp.size() ==1){
//						System.out.println("^^^^^^^^^^^^^^^^^^^^^^oId^^^^^^^^^^^^^^^^^^^^^^^^^^^^^1^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  "+oId);
						delContractPayMent(new Long("0"),oId);
//						System.out.println("^^^^^^^^^^^^^^^^^^^^^^oId^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  "+oId);
					}


			  		for(Iterator it = lsResKeysDetal.iterator();it.hasNext();){
			  			
			  			OrderDetail orderDetail = (OrderDetail)it.next();
			  		
			  			Long resourceTypeId = orderDetail.getId();
			  			Integer publishStartDate = orderDetail.getPublishStartDate();
			  			Double payMoney = orderDetail.getMoneyRealpay();
			  			if(publishStartDate.intValue()>0) date =publishStartDate;

			  		 	ContractPayment payment = new ContractPayment();
			  		 	
			  		 	System.out.println("^^^^^^^^^^^^^^^^^^^^^^resourceTypeId^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  "+resourceTypeId);
			  		 	
		  		 		Object obj = chMp.get(resourceTypeId.toString());  
			  		 	if(isMid && obj != null){
				  		 		payment = (ContractPayment)obj;
				  		 		
				  		 		if(modle == 1 && resourceTypeId.longValue() == 0){
//				  		 			System.out.println("^^^^^^^^^^^^^^^^^^^^^^wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  "+resourceTypeId);
				  		 			delContractPayMent(payment.getContractId(),oId);
				  		 		}else{
					  		 		payment.setMoneyPay(payMoney);
					  		 		saveContractPayment(payment);
				  		 		}
				  		 		
				  		 		
//				  		 		if(payment.getMoneyPay().doubleValue() != payMoney.doubleValue()){
			
//				  		 		}
			  		 	}else{
					 		payment.setOrderId(oId);
					   		payment.setContractId(new Long(0));
					   		payment.setMoneyPay(payMoney);
					   		payment.setPayNumber(new Integer(index++));
					   		payment.setIncomePurposeId(new Long(1));
					   		payment.setPayDate(date);
					   		payment.setCustomerId(cusId);
					   		payment.setVersion(new Integer(year));
					   		payment.setMemo("");
					   		payment.setResourceTypeId(resourceTypeId);
					   		saveContractPayment(payment);
			  		 	}
			  		}
					
				}			
			
			//********************************end****************************			

		}
		


	}
	
	
	
	
	
//	自动付款时调用	
	
	public String saveContractPaymentByOrder(int modle,String contractId, String orderId, String customerId,double payMoney,boolean isNew,String resourceType,String year) {
		// TODO Auto-generated method stub
	 	ContractPayment payment = new ContractPayment();
	 	Integer date = new Integer(DateUtil.getDate());
	 	Map chMp = new HashMap();
	 	boolean isWithResourceSort = SysParamUtil.getWithResourceSort();
	 	
	 	Long cId = new Long(contractId==null||contractId.equals("0")?"0":contractId);
//	 	System.out.println("^^^^^^^^^^^^^^^^  "+cId);
	 	Long oId = new Long(orderId==null||orderId.equals("0")?"0":orderId);
	 	Long cusId = new Long(customerId==null||customerId.equals("0")?"0":customerId);
	 	if(isNew){
	 		payment.setOrderId(oId);
	   		payment.setContractId(cId);
	   		payment.setMoneyPay(new Double(payMoney));
	   		payment.setPayNumber(new Integer(1));
	   		payment.setIncomePurposeId(new Long(1));
	   		payment.setPayDate(date);
	   		payment.setCustomerId(cusId);
	   		payment.setVersion(new Integer(year));
	   		payment.setMemo(resourceType);
	   		payment.setResourceTypeId(new Long(resourceType));
	   		System.out.println("11111111111111111111>>>>>>>>>>  "+resourceType);
	   		saveContractPayment(payment);
	 	}else{
	 		//如果是资源分类，碰到model=0
	 		if(isWithResourceSort){
	 			System.out.println("11111111111111111111   saveContractPaymentByOrder         2222222222222222222222        payMoney       333333333333333333333333 44444444444444 >>>>>>>>>>  "+payMoney);
	 			System.out.println("11111111111111111111   saveContractPaymentByOrder         2222222222222222222222        contractId       333333333333333333333333 44444444444444 >>>>>>>>>>  "+contractId);

	 			payment.setOrderId(oId);
		   		payment.setContractId(cId);		
		   		List paymentList = getContractPayments(payment);   
		  		for(Iterator it = paymentList.iterator();it.hasNext();){
		  			ContractPayment pay = (ContractPayment)it.next();
		  			String paymentId = pay.getId().toString();
		  			long resTypeId = Long.parseLong(StringUtil.getNullValue(pay.getResourceTypeId(),"0"));
		  			if(resTypeId > 0){
		  				saveCuiKuanByNortomOrder(modle, true,"0",orderId, customerId, year,false);
		  				return "success";
		  			}
		  		}
            	
	 		}
	 		
	 		//得到以orderId分组的payment的钱数总和
 			Double payMentOldSum = dao.getMoneyPayByOrderIdDouble(oId);
 			
 			payMentOldSum = payMentOldSum==null?new Double(0):payMentOldSum;
 			double payMoney_sum;
 			//相同orderId的金额总和与传进来的钱比较
 			payMoney_sum = payMoney - payMentOldSum.doubleValue();
 			
// 			System.out.println("1111111111111payMoney1111111>>>>>>>>>>  "+payMoney);
// 			System.out.println("11111111111111payMentOldSum111111>>>>>>>>>>  "+payMentOldSum);
// 			System.out.println("11111111111111payMoney_sum111111>>>>>>>>>>  "+payMoney_sum);
			if(payMoney_sum>=0){
				payment.setOrderId(oId);
		   		payment.setContractId(cId);		
		   		List paymentList = getContractPayments(payment);  
//		   		System.out.println("BBBBBBBBBB paymentList  MMMMMMMM "+paymentList.size());
		   		if(paymentList.size()!=0){
					Collections.sort(paymentList, new ContractPayMentComparator());
					ContractPayment pay = (ContractPayment)paymentList.get(paymentList.size()-1);
					chMp.put("paymentId",pay.getId());
					double moneyPay = pay.getMoneyPay()==null?0:pay.getMoneyPay().doubleValue();
		   			chMp.put("moneychange",new Double(moneyPay+payMoney_sum));
		   			chMp.put("customerId",cusId);
//		   			System.out.println("222222222222222222>>>>>>>>>>  "+cId);
		   			dao.updatePayMoney(chMp);
		   		}else{
		   			if(payMoney > 0){
				   		payment.setMoneyPay(new Double(payMoney));
				   		payment.setPayNumber(new Integer(1));
				   		payment.setIncomePurposeId(new Long(1));
				   		payment.setPayDate(date);
				   		payment.setCustomerId(cusId);
				   		payment.setVersion(new Integer(year));
				   		saveContractPayment(payment);
//				   		System.out.println("BBBBBBBBBB customerId  MMMMMMMM "+cusId);
//				   		System.out.println("333333333333333333333>>>>>>>>>>  "+cId);
				   		saveContractPayment(payment);
		   			}

		   		}
			}else if(payMoney_sum<0){
				double maxPayNumMoney;
//				因为相同orderId的金额总和大于传进来的钱，所以变为  相同orderId的金额总和 - 传进来的钱
				double sum_payMoney = payMentOldSum.doubleValue() - payMoney;
				payment.setOrderId(oId);
		   		payment.setContractId(cId);
		   		//求出所有的orderId或contractId相同的记录条数
		   		List payMentList = getContractPayments(payment);
		   		List payMentList2 = payMentList;
		   		for(Iterator it = payMentList.iterator();it.hasNext();){
			   		Collections.sort(payMentList2, new ContractPayMentComparator());
					ContractPayment maxPaymentByPayNum = (ContractPayment)payMentList2.get(payMentList2.size()-1);
					maxPayNumMoney = maxPaymentByPayNum.getMoneyPay().doubleValue();
			   		
			   		if(maxPayNumMoney>sum_payMoney){
			   			chMp.put("paymentId",maxPaymentByPayNum.getId());
			   			chMp.put("moneychange",new Double(maxPayNumMoney-sum_payMoney));
			   			chMp.put("customerId",cusId);
//			   			System.out.println("444444444444444444444>>>>>>>>>>  "+cId);
			   			dao.updatePayMoney(chMp);
			   			sum_payMoney = 0;
			   			break;
			   		}else{
			   			sum_payMoney -=maxPayNumMoney;
			   			removeContractPayment(maxPaymentByPayNum.getId().toString());
			   			payMentList2.remove(payMentList2.size()-1);
			   			if(sum_payMoney==0)
			   				break;
			   		}
		   		}
			}else if(payMoney==0){
				delContractPayMent(cId,oId);
			}
	 	}
		return "success";
	}
	
	private void delContractPayMent(Long contractId, Long orderId){
		ContractPayment payment = new ContractPayment();
	 	Map delMp = new HashMap();
		List ls = new ArrayList();
		
		payment.setOrderId(orderId);
   		payment.setContractId(contractId);
   		List payList = getContractPayments(payment);
//   		System.out.println("444444444444444444444>>>payList>>>>>orderId>>  "+orderId);
//   		System.out.println("444444444444444444444>>>payList>>>>>contractId>>  "+contractId);
//   		System.out.println("444444444444444444444>>>payList>>>>>>>  "+payment.toString());
   		for(Iterator it = payList.iterator();it.hasNext();){
   			ContractPayment pay = (ContractPayment)it.next();
   			ls.add(pay.getId());
   		}
   		
//   		System.out.println("444444444444444444444>>>ContractPaymentIdList>>>>>>>  "+ls);
   		if(ls.size() >0){
   	   		delMp.put("ContractPaymentIdList",ls);
   	   		removeContractPayments(delMp);
   		}

	}
	

	private Long getPaymentIdMaxByOidOrCid(ContractPayment contractPayment){
		Long maxId = dao.getPaymentIdMaxByOidOrCid(contractPayment);
		return maxId;
	}
	
	private int getPutOnType(ContractPayment contractPayment){
		int type=0;
		Long contractId = contractPayment.getContractId();
		Long orderId = contractPayment.getOrderId();
		contractId = contractId==null?new Long(0):contractId;
		orderId = orderId==null?new Long(0):orderId;
		if(contractId.longValue()!=0&&orderId.longValue()==0){
			type = 1;
		}else if(contractId.longValue()==0&&orderId.longValue()!=0){
			type = 2;
		}else if(contractId.longValue()!=0&&orderId.longValue()!=0){
			type = 2;
		}
		return type;
	}
	
	
	
	
	public String savePutonMoney(String[] ids,double incomeMoney,String incomeId){

		List dayInfoList = new ArrayList();
		
		for(int i = 0;i < ids.length;i++){
			
			ContractPayment pay = dao.getContractPayment(new Long(ids[i]));
			//应付
			double moneyPaly = pay.getMoneyPay() == null?0:pay.getMoneyPay().doubleValue();
			//已付
			double moneyIn = (pay.getMoneyIn() == null)?0:pay.getMoneyIn().doubleValue();
			// 欠款
			double arrears = moneyPaly - moneyIn;	
			
			if(arrears > 0) {
//				每笔实际发生额
				double paymentPuton= 0;
				
				if(incomeMoney >= arrears){
					paymentPuton = arrears;
					incomeMoney = incomeMoney - arrears;
				}else if(incomeMoney >0 && incomeMoney < arrears){
					paymentPuton = incomeMoney;
					incomeMoney = 0;
				}

				OrderDayInfo dayInfo = new OrderDayInfo();
				int type = getPutOnType(pay);
				
//				dayInfo.setPaymentId(new Long(ids[i]));
				
				//合同平帐 
				if(type == 1){
					dayInfo.setContractId(pay.getContractId());
				}
				//订单平帐 
				if(type == 2){
					dayInfo.setOrderId(pay.getOrderId());
				}
				
				dayInfoList = orderDayInfoDao.getOrderDayInfos(dayInfo);

				setDayRelMoney(dayInfoList,paymentPuton,incomeId,ids[i]);
				
				if(incomeMoney == 0) break;

			}
		}

			return "success";

	}
	
//	public void savePutonMoneyByObj(ContractPayment objs[]){
//		String tvName = SysParamUtil.getTvNameParam();
//		
//		if(SysParamUtil.isQZTVParam(tvName)){
//			savePutonMoneyFZTV(objs);
//		}else if(SysParamUtil.isXMTVParam(tvName)){
//			savePutonMoneyNew(objs);
//		}else{
//			
//			for(int i = 0;i< objs.length;i++){
//				ContractPayment payment = objs[i];
//				String[] paymentIds = payment.getPaymentIds();           
////				System.out.println(">>>>>>>>>>>paymentIds>>   "+ paymentIds);
////				System.out.println(" >>>>>>>>>>>>>>payment.getMoneyPay()>>   "+  payment.getMoneyPay());
////				System.out.println(" >>>>>>>>>>>>>>payment.getIncomePullId()>>   "+  payment.getIncomePullId());
////				System.out.println(" >>>>>>>>>>>>>>payment.getCarrierId()>>   "+  payment.getCarrierId());
//				double incomeMoney = payment.getMoneyPay().doubleValue();
//				String incomeId = "0";
//				String pullId = payment.getIncomePullId().toString();
////				String carrierId = payment.getCarrierId().toString();
//				String carrierId = payment.getCarrIds();
//				savePutonMoneyByInIdAndPullId(paymentIds,incomeMoney,incomeId,pullId,carrierId);	
//			}
//		}
//		
//		
//	}
	public void savePutonMoneyByObj(ContractPayment objs[]){
		String tvName = SysParamUtil.getTvNameParam();
		
		if(SysParamUtil.isFZTVParam(tvName)){
			savePutonMoneyFZTV(objs);
		}
//		else if(SysParamUtil.isXMTVParam(tvName)){
//			savePutonMoneyNew(objs);
//		}
		
		else{
			savePutonMoneyNew(objs);
		}
		
		
	}
	public void savePutonMoneyNew(ContractPayment objs[]){
		
		String tvName = SysParamUtil.getTvNameParam();
		boolean isResSort = SysParamUtil.getWithResourceSort();
		int balanceModel = 0;
		
		Map mp = new HashMap();
		Map mpResource = new HashMap();
		List resourceIds = new ArrayList();

		double incomeMoney = 0;
		double incomeMoneySum = 0;
		double incomeMoneySumLeave = 0;
		double paymentPutonSum = 0;
		
		if(objs.length > 0){
			ContractPayment payment = objs[0];
			balanceModel =  payment.getState().intValue();
			if(balanceModel == 1) incomeMoneySum = payment.getContractMoneySum().doubleValue();
		}
		
		System.out.println(">>>>>>>>>>>balanceModel>>   "+ balanceModel);
		

		
		for (int i = 0; i < objs.length; i++) {
			ContractPayment payment = objs[i];
			
			// balanceModel 2 多笔款平一个订单  1 一笔款平多个订单
		  
		    	
			String year = payment.getVersion().toString();
//			String resourceType = payment.getMemo();
			String resourceType = payment.getResourceTypeId().toString();
//			String carrierId = payment.getCarrierId().toString();
//			String carrierId = payment.getCarrIds();
			String userId = payment.getUserId().toString();
//			String incomeId = payment.getIncomeId().toString();
//			String pullId = payment.getIncomePullId().toString();
			String incomeId = "0";
			String pullId = "0";
			String carrierId ="0";
			
			String cntractId = payment.getContractId().toString();
			String orderId = payment.getOrderId().toString();
			String paymentId = payment.getId().toString();
			
			
//			System.out.println(">>>>>>>>>>>year>>   "+ year);
//			System.out.println(">>>>>>>>>>>resourceType>>   "+ resourceType);
//			System.out.println(">>>>>>>>>>>userId>>   "+ userId);
//			System.out.println(">>>>>>>>>>>incomeId>>   "+ incomeId);
//			System.out.println(">>>>>>>>>>>pullId>>   "+ pullId);
//			System.out.println(">>>>>>>>>>>cntractId>>   "+ cntractId);
//			System.out.println(">>>>>>>>>>>orderId>>   "+ orderId);
//			System.out.println(">>>>>>>>>>>paymentId>>   "+ paymentId);
			
			
			
			
			IncomePull[] pulls = payment.getIncomePulls();
		
			double moneyPaly =  payment.getMoneyPay() == null?0:payment.getMoneyPay().doubleValue();//			应付
			double moneyIn = (payment.getMoneyIn() == null)?0:payment.getMoneyIn().doubleValue();//			已付
			double arrearsSum = moneyPaly - moneyIn;//			 欠款
			double arrears = 0;

			
	        if(balanceModel == 2){
	        	paymentPutonSum = 0;
	        	incomeMoneySum = 0;
				for (int k = 0; k < pulls.length; k++) {
					IncomePull incomePull = pulls[k];
					double pullMoney = incomePull.getMoneyPull() == null?0:incomePull.getMoneyPull().doubleValue();
					incomeMoneySum = incomeMoneySum+pullMoney;
				}		        	
	        }
				
			

	        if(log.isDebugEnabled()){
	    		System.out.println(">>>>>>>>>>>moneyPaly>>   "+ moneyPaly);
				System.out.println(">>>>>>>>>>>moneyIn>>   "+ moneyIn);
				System.out.println(">>>>>>>>>>>arrearsSum>>   "+ arrearsSum);
	        }
	
	
			for (int k = 0; k < pulls.length; k++) {
				
						IncomePull incomePull = pulls[k];
						
			//			合同平帐 1  订单平帐 2
						int type = getPutOnType(payment);
						
			//			每笔实际发生额			
						double paymentPuton = 0;
						
			//			平帐金额
//						double pullMoney = payment.getContractMoneySum() == null?0:payment.getContractMoneySum().doubleValue();
//						double pullMoney = incomePull.getMoneyPull() == null?0:incomePull.getMoneyPull().doubleValue();
						double pullMoney = 0;
						 if(balanceModel == 1){
							 pullMoney = incomePull.getMoneyPull() == null?0:incomePull.getMoneyPull().doubleValue();
							 pullMoney = pullMoney - paymentPutonSum;
							 arrears =  moneyPaly - moneyIn;//			 欠款
//							 System.out.println(">>>>>>>>>tatata>>>>>>>>>>>>>pullMoney>>paymentPutonSum>>>   "+ pullMoney +"____________"+paymentPutonSum);
						 }else{
							 pullMoney = incomePull.getMoneyPull() == null?0:incomePull.getMoneyPull().doubleValue();
							 arrears = arrearsSum - paymentPutonSum;	
						 }
						 					
						
						
						incomeMoney = pullMoney;
//						arrears = arrearsSum - paymentPutonSum;	
						incomeId = incomePull.getIncomeId().toString();
						pullId = incomePull.getId().toString();
						carrierId = incomePull.getMemo();
						
//						System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>incomeId>>   "+ incomeId);
//						System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>pullId>>   "+ pullId);
//						System.out.println(k+ " <<<<<<<<<<<<<<<>>>>>>>>>>>arrears>>   "+ arrears);
//						System.out.println(">>>>>>>>>>>carrierId>>   "+ carrierId);
//						System.out.println(">>>>>>>>>>>type>>   "+ type);
//						System.out.println(">>>>>>>>>>>pullMoney>>   "+ pullMoney);
//						System.out.println(">>>>>>>>>>>arrears>>   "+ arrears);
						
						
						
						
						//目前只有厦门台启用资源分类
						int resourceTypeInt = Integer.parseInt(resourceType);
						if(isResSort && resourceTypeInt>0){
							mp = resourceManager.getResourceYearTypeMap( year, resourceType);
							if(mp.size() == 0){
								resourceIds = null;
							}else{
								String key = year+"_"+resourceType;
								if(mpResource.containsKey(key)){
									resourceIds = (List)mpResource.get("resourceIds");
								}else{
									resourceIds = (List)mp.get("resourceIds");
									mpResource.put(key,resourceIds);
								}
							}							
						}else{
							if(carrierId == null||carrierId == "0" || "0".equals(carrierId)){
								resourceIds = null;
							}else{
								resourceIds =  resourceManager.getResourceIdsForPutOn(carrierId);
							}
						}
						

						
//						System.out.println(">>>>>>>>>>>resourceIds size>>   "+ resourceIds.size());
					
			//			System.out.println(">>>>>>>>>>>resourceIds>>   "+ resourceIds.toArray().toString());
			//			System.out.println(">>>>>>>>>>>resourceIds>>   "+ resourceIds);
						
						if(arrears > 0) {
//							System.out.println(">>>>>>>>>>>incomeMoney>>   "+ incomeMoney);
							if(incomeMoney >= arrears){
								paymentPuton = arrears;
								incomeMoney = incomeMoney - arrears;
							}else if(incomeMoney >0 && incomeMoney < arrears){
								paymentPuton = incomeMoney;
								incomeMoney = 0;
							}else{
								break;
							}
							

							//合同平帐 
							if(type == 1){
								mp.put("contractId",cntractId);
								mp.put("orderId",null);
								mp.put("resourceIdList",resourceIds);
			//					System.out.println("contractId>>   "+ pay.getContractId());
			//					dayInfo.setContractId(pay.getContractId());
							}
							//订单平帐 
							if(type == 2){
								mp.put("orderId",orderId);
								mp.put("contractId",null);
								mp.put("resourceIdList",resourceIds);
			//					System.out.println("orderId>>   "+  pay.getOrderId());
			//					dayInfo.setOrderId(pay.getOrderId());
							}
							
							List dayInfoList = orderDayInfoDao.getOrderDayInfosForPutOn(mp);
			                
							if(log.isDebugEnabled()){
								System.out.println("paymentPuton>>>>>   "+ paymentPuton);
								System.out.println("incomeId>>>>>   "+ incomeId);
								System.out.println("pullId>>>>>   "+ pullId);
								System.out.println("paymentId>>>>>   "+ paymentId);
								System.out.println(">>>>>>>>>>>dayInfoList.size>>   "+ dayInfoList.size());
							}


							double relputonSum = setDayRelMoneyPullId(dayInfoList,paymentPuton,incomeId,pullId,paymentId);
							
							paymentPutonSum = paymentPutonSum + relputonSum;
						
							incomeMoneySumLeave = incomeMoneySum - paymentPutonSum;
							
							if(log.isDebugEnabled()){
								System.out.println(">>>>>>>>>>>relputonSum>>   "+ relputonSum);
								System.out.println(">>>>>>>>>>>paymentPutonSum>>   "+ paymentPutonSum);
								System.out.println(">>>>>>>>>>>incomeMoneySumLeave>>   "+ incomeMoneySumLeave);	
							}

							
							if(incomeMoneySumLeave == 0) break;		
						
						}
						
			
					}
			
		}
		
	}
	public void savePutonMoneyFZTV(ContractPayment objs[]){
		
		for (int i = 0; i < objs.length; i++) {
			ContractPayment payment = objs[i];
			String[] paymentIds = payment.getPaymentIds();
			// System.out.println(">>>>>>>>>>>paymentIds>> "+ paymentIds);
			// System.out.println(" >>>>>>>>>>>>>>payment.getMoneyPay()>> "+
			// payment.getMoneyPay());
			// System.out.println(" >>>>>>>>>>>>>>payment.getIncomePullId()>> "+
			// payment.getIncomePullId());
			// System.out.println(" >>>>>>>>>>>>>>payment.getCarrierId()>> "+
			// payment.getCarrierId());
			double incomeMoney = payment.getMoneyPay().doubleValue();
			String incomeId = "0";
			String pullId = payment.getIncomePullId().toString();
//			String carrierId = payment.getCarrierId().toString();
			String carrierId = payment.getCarrIds();

			Map mp = new HashMap();
			String[] paymentList = new String[paymentIds.length];
			List orderList = new ArrayList();
			for (int k = 0; k < paymentIds.length; k++) {
				int index = paymentIds[k].indexOf("_");
				paymentList[k] = paymentIds[k].substring(0, index);
				orderList.add(paymentIds[k].substring(index + 1));
				System.out.println(paymentIds[k].substring(index + 1)
						+ "kkkkk===" + paymentList[k]);
			}
			payment.setPaymentIdList(orderList);
			incomeId = payment.getIncomeId().toString();

			if (Integer.parseInt(carrierId) == 0) {
				// double sum =0;
				// Map mp=new HashMap();
				// Long channelId =new Long(0);
				// List incomePullList =new ArrayList();
				List ls2 = dao.getIncomePullsByOrderDetail(payment);

				Map mapTemp = new HashMap();
				for (Iterator it = ls2.iterator(); it.hasNext();) {
					ContractPayment cPayment = (ContractPayment) it.next();
					Long userId = cPayment.getUserId();
					if (!mapTemp.containsKey(userId)) {
						List myList = new ArrayList();
						myList.add(cPayment);
						mapTemp.put(userId, myList);
					} else {
						List myList = (List) mapTemp.get(userId);
						myList.add(cPayment);
						mapTemp.put(userId, myList);
					}
				}

				for (Iterator iter = mapTemp.keySet().iterator(); iter
						.hasNext();) {

					Long userId = (Long) iter.next();
					List ls = (List) mapTemp.get(userId);

					// for(Iterator it=ls.iterator();it.hasNext();){
					// ContractPayment cPayment = (ContractPayment)it.next();
					// sum+= cPayment.getMoneyPay().doubleValue();
					// }

					IncomePull incomePl = new IncomePull();
					incomePl.setIncomeId(new Long(incomeId));
					// incomePl.setCreateBy(payment.getUserId());
					incomePl.setCreateBy(userId);

					List incomePulls = incomePullDao.getIncomePulls(incomePl);

					for (Iterator it = incomePulls.iterator(); it.hasNext();) {
						IncomePull incomePull = (IncomePull) it.next();
						if (incomePull.getResourceCarrierId() != null
								&& incomePull.getResourceCarrierId().intValue() != 0) {
							String key = incomePull.getResourceCarrierId()
									.toString()
									+ "_" + userId.toString();
							mp.put(key, incomePull);
							// mp.put(incomePull.getResourceCarrierId(),incomePull);
							System.out.println(incomePull
									.getResourceCarrierId()
									+ "===" + incomePull.getMoneyPull());
						}
					}
					System.out.println("size===" + ls.size());
					for (Iterator it = ls.iterator(); it.hasNext();) {
						ContractPayment cPayment = (ContractPayment) it.next();
						double moneyPay = cPayment.getMoneyPay().doubleValue();
						System.out.println("moneyPayFF===" + moneyPay);
						if (moneyPay > incomeMoney) {
							moneyPay = incomeMoney;
							incomeMoney = 0;
						} else {
							incomeMoney = incomeMoney - moneyPay;
						}
	


						Long carrId = cPayment.getCarrierId();
						String key = carrId.toString() + "_" + userId.toString();
						Object obj = mp.get(key);
						if (obj == null && moneyPay > 0) {
							// if(mp.get(carrierId)==null&&moneyPay>0){
							IncomePull incomePull = new IncomePull();
							incomePull.setVersion(payment.getVersion());
							incomePull.setIncomeId(new Long(incomeId));
							incomePull.setResourceCarrierId(carrId);
							incomePull.setMoneyPull(new Double(moneyPay));
							incomePull.setMoneyIn(new Double(0));
							// incomePull.setCreateBy(payment.getUserId());
							incomePull.setCreateBy(userId);
							incomePullDao.saveIncomePull(incomePull);
						} else {
							IncomePull incomePull = (IncomePull) obj;
							incomePull.setMoneyPull(new Double(incomePull
									.getMoneyPull().doubleValue()
									+ moneyPay));
							// incomePull.setResourceCarrierId(carrId);
							// incomePull.setCreateBy()
							incomePullDao.updateIncomePullMoney(incomePull);
						}

						if (incomeMoney == 0)
							break;
						// mp.put(id,cPayment.getMoneyPay());
						// System.out.println("3333333==="+id);
					}
					if (incomeMoney > 0) {
						IncomePull income = new IncomePull();
						income.setId(new Long(pullId));
						income.setMoneyPull(new Double(incomeMoney));
						incomePullDao.updateIncomePullMoney(income);
					} else {
						incomePullDao.removeIncomePull(new Long(pullId));
					}

					IncomePull income = new IncomePull();
					income.setIncomeId(new Long(incomeId));
					// income.setCreateBy(payment.getUserId());
					income.setCreateBy(userId);

					List incomePullss = incomePullDao.getIncomePulls(income);

					for (Iterator it = incomePullss.iterator(); it.hasNext();) {
						IncomePull incomePll = (IncomePull) it.next();
						System.out.println("3333333==="
								+ incomePll.getResourceCarrierId() + ">>>"
								+ incomePll.getMoneyPull());
						if (incomePll.getResourceCarrierId() != null
								&& incomePll.getResourceCarrierId().intValue() != 0) {
							double moneyIn = incomePll.getMoneyIn() == null ? 0
									: incomePll.getMoneyIn().doubleValue();
							savePutonMoneyByInIdAndPullId(paymentList,
									incomePll.getMoneyPull().doubleValue()
											- moneyIn, incomeId, ""
											+ incomePll.getId(), ""
											+ incomePll.getResourceCarrierId());
						}

					}

				}
			}
		}
			
	}
	
	

	public String savePutonMoneyByInIdAndPullId(String[] paymentIds,double incomeMoney,String incomeId,String pullId,String carrierId){

// List dayInfoList = new ArrayList();
		Map mp = new HashMap();
		List resourceIds =new ArrayList();
		
		if(carrierId == null||carrierId == "0"||carrierId.endsWith("0")){
			 resourceIds = null;
		}else{
			resourceIds =  resourceManager.getResourceIdsForPutOn(carrierId);
		}
        

		
//		if(SysParamUtil.isXMTVParam(null)){
//			resourceIds =  resourceManager.getResourceIdsForPutOn(carrierId);
//		}
		
		
			
		for(int i = 0;i < paymentIds.length;i++){
			
			ContractPayment pay = dao.getContractPayment(new Long(paymentIds[i]));
			//应付
			double moneyPaly = pay.getMoneyPay() == null?0:pay.getMoneyPay().doubleValue();
			//已付
			double moneyIn = (pay.getMoneyIn() == null)?0:pay.getMoneyIn().doubleValue();
			// 欠款
			double arrears = moneyPaly - moneyIn;	
			
			if(arrears > 0) {
//				每笔实际发生额
				double paymentPuton= 0;
				
				if(incomeMoney >= arrears){
					paymentPuton = arrears;
					incomeMoney = incomeMoney - arrears;
				}else if(incomeMoney >0 && incomeMoney < arrears){
					paymentPuton = incomeMoney;
					incomeMoney = 0;
				}

//				OrderDayInfo dayInfo = new OrderDayInfo();
				int type = getPutOnType(pay);
				
//				dayInfo.setPaymentId(new Long(ids[i]));
				
				//合同平帐 
				if(type == 1){
					mp.put("contractId",pay.getContractId());
					mp.put("orderId",null);
					mp.put("resourceIdList",resourceIds);
//					System.out.println("contractId>>   "+ pay.getContractId());
//					dayInfo.setContractId(pay.getContractId());
				}
				//订单平帐 
				if(type == 2){
					mp.put("orderId",pay.getOrderId());
					mp.put("contractId",null);
					mp.put("resourceIdList",resourceIds);
//					System.out.println("orderId>>   "+  pay.getOrderId());
//					dayInfo.setOrderId(pay.getOrderId());
				}
				
				List dayInfoList = orderDayInfoDao.getOrderDayInfosForPutOn(mp);

//				System.out.println("payMentId>>>>>   "+ pay.toString());
				
				
				setDayRelMoneyPullId(dayInfoList,paymentPuton,incomeId,pullId,paymentIds[i]);
				
				if(incomeMoney == 0) break;

			}
		}

			return "success";

	}
	
//	private void setOrderDetailMoneyBalance(List ls){
//		
//	}
	
	private double setDayRelMoneyPullId(List ls,double incomeMoney,String incomeId,String pullId,String paymentId){
		Map orderDetailMap = new HashMap();
		Map relPayMent = new HashMap();
		List moneyUsed = new ArrayList();
		double relputonSum = 0;
		
//		System.out.println("1 ls xxx   "+ls.size());
		for(Iterator it = ls.iterator();it.hasNext();){
			
			OrderDayInfo ordDayInfo = (OrderDayInfo)it.next();
			//日应收
			double relIncome = ordDayInfo.getDayRelIncome().doubleValue();
			//已分配
			double usedMoney = ordDayInfo.getDayRelPuton().doubleValue();
			//欠款
//			System.out.println("0  ====="+relIncome+"   "+usedMoney); 
			double arrears = relIncome - usedMoney;
//			System.out.println("1  ======"+arrears);           
			//日总分配金额
			double daySumPuton= 0;
			//当前日分配金额
			double dayPuton= 0;
			if(arrears > 0){
//				System.out.println("3  "+arrears);
				if(incomeMoney >= arrears){
					daySumPuton = relIncome;
					incomeMoney = incomeMoney - arrears;
				}else if(incomeMoney >0 && incomeMoney < arrears){
					daySumPuton = usedMoney + incomeMoney;
					incomeMoney = 0;
				}
				//当前日分配金额  = 日总分配金额 - 已分配
				dayPuton = daySumPuton - usedMoney;
				IncomeUsed incomeUsed = new IncomeUsed();
				incomeUsed.setMoneyIn(new Double(dayPuton));
				incomeUsed.setOrderDayInfoId(ordDayInfo.getId());  
				incomeUsed.setPaymentId(new Long(paymentId));
//				incomeUsed.setIncomeId(new Long(incomeId));
				incomeUsed.setIncomePullId(new Long(pullId));
				Integer publishDate = ordDayInfo.getPublishDate();
//				incomeUsed.setPublishDate(publishDate);
				incomeUsed.setVersion(new Integer(publishDate.toString().substring(0,4)));
				
				relPayMent.put(ordDayInfo.getId(),new Double(daySumPuton));
				moneyUsed.add(incomeUsed);
				
				Long orderDetailId = ordDayInfo.getOrderDetailId();
				if(orderDetailMap.containsKey(orderDetailId)){
					double moneyIn = ((Double)orderDetailMap.get(orderDetailId)).doubleValue();
					moneyIn += dayPuton;
					orderDetailMap.put(orderDetailId,new Double(moneyIn));
//					System.out.println("orderDetailMap orderDetailId  ======"+orderDetailId +"_"+moneyIn);    
				}else{
					orderDetailMap.put(orderDetailId,new Double(dayPuton));
				}
				
				
				
				relputonSum  += dayPuton;
				
				if(incomeMoney == 0) break;
			}
			
		}

		//插入分配明细
		
		incomeUsedDao.saveIncomeUsedMoneyIn(moneyUsed); 
//		System.out.println("4  ");
		
        //修改日播信息
		orderDayInfoDao.saveOrderDayInfosRelPutOn(relPayMent);
		
//		System.out.println("orderDetailMap.size  ======"+orderDetailMap.size());     
		orderDetailDao.saveOrderDetailPublicInfoMoneyIn(orderDetailMap);
		
		return relputonSum;
		
	
	}
	
	private void setDayRelMoney(List ls,double incomeMoney,String incomeId,String paymentId){
		Map relPayMent = new HashMap();
		List moneyUsed = new ArrayList();
//		System.out.print("LLLLLLLeeeeeeeeeeeeeeeeeL"+incomeMoney);
		for(Iterator it = ls.iterator();it.hasNext();){
			
			OrderDayInfo ordDayInfo = (OrderDayInfo)it.next();
			//日应收
			double relIncome = ordDayInfo.getDayRelIncome().doubleValue();
			//已分配
			double usedMoney = ordDayInfo.getDayRelPuton().doubleValue();
			//欠款
			double arrears = relIncome - usedMoney;
			//日总分配金额
			double daySumPuton= 0;
			//当前日分配金额
			double dayPuton= 0;
			if(arrears > 0){
				if(incomeMoney >= arrears){
					daySumPuton = relIncome;
					incomeMoney = incomeMoney - arrears;
				}else if(incomeMoney >0 && incomeMoney < arrears){
					daySumPuton = usedMoney + incomeMoney;
					incomeMoney = 0;
				}
				//当前日分配金额  = 日总分配金额 - 已分配
				dayPuton = daySumPuton - usedMoney;
				IncomeUsed incomeUsed = new IncomeUsed();
				incomeUsed.setMoneyIn(new Double(dayPuton));
				incomeUsed.setOrderDayInfoId(ordDayInfo.getId());
				incomeUsed.setPaymentId(new Long(paymentId));
				incomeUsed.setIncomeId(new Long(incomeId));
				
				Integer publishDate = ordDayInfo.getPublishDate();
				incomeUsed.setPublishDate(publishDate);
				incomeUsed.setVersion(new Integer(publishDate.toString().substring(0,4)));
				
				relPayMent.put(ordDayInfo.getId(),new Double(daySumPuton));
				moneyUsed.add(incomeUsed);
				
				
				if(incomeMoney == 0) break;
			}
			
		}
        //修改日播信息
		orderDayInfoDao.saveOrderDayInfosRelPutOn(relPayMent);
		//插入分配明细
		incomeUsedDao.saveIncomeUsedMoneyIn(moneyUsed);
		
		
	}

	public String saveBackPaymentMoneyIn(String[] ids, String incomeId) {
		// TODO Auto-generated method stub
		Map mpOrderDay = new HashMap();
		Map mpUsed = new HashMap();
		List payMentIdList = new ArrayList();
		
		org.apache.commons.collections.CollectionUtils.addAll(payMentIdList,ids);
		
		mpOrderDay.put("PayMentIdList",payMentIdList);
		
		mpOrderDay.put("incomeId",incomeId);
		
		List orderDayIdList = orderDayInfoDao.getIdsByPayMentAndIncome(mpOrderDay);
//		System.out.println("<<<<<<<<<orderDayIdList 1>>>>>>"+orderDayIdList.size());
		
		List newOrderDayIdList = getorderDayIdsList(orderDayIdList);
		
//		System.out.println("<<<<<<<<<newOrderDayIdList 1>>>>>>"+newOrderDayIdList.size());
		
		mpUsed.put("PayMentIdList",payMentIdList);
		mpUsed.put("OrderDayInfoIdList",newOrderDayIdList);
		mpUsed.put("incomeId",incomeId);
		
		List usedList = incomeUsedDao.getOrderDayReturnMoney(mpUsed);
//		System.out.println("<<<<<<<<<usedList 1>>>>>>"+usedList.size());
		
		Map mpReturnUsed = getUsedMoneyMapFromList(usedList,"orderDayInfoId","moneyIn");
		
//		System.out.println("<<<<<<<<<saveDayPutOnById before>>>>>>");
		orderDayInfoDao.saveDayPutOnById(mpReturnUsed);
		
//		System.out.println("<<<<<<<<<newOrderDayIdList affert>>>>>>");
		
		incomeUsedDao.deleteByPaymentIdAndIncomeIdAndDayId(mpUsed);
		
//		System.out.println("<<<<<<<<<deleteByPaymentIdAndIncomeIdAndDayId affert>>>>>>");
		return "success";
	}
	
	public void saveBackPaymentMoneyByObj(ContractPayment objs[]){
		for(int i = 0;i< objs.length;i++){
			ContractPayment payment = objs[i];
			String[] paymentIds = payment.getPaymentIds();
//			System.out.println(">>>>>>>>>>>paymentIds>>   "+ paymentIds);
//			System.out.println(" >>>>>>>>>>>>>>payment.getMoneyPay()>>   "+  payment.getMoneyPay());
//			System.out.println(" >>>>>>>>>>>>>>payment.getIncomePullId()>>   "+  payment.getIncomePullId());
//			System.out.println(" >>>>>>>>>>>>>>payment.getCarrierId()>>   "+  payment.getCarrierId());
			String incomeId = "0";
			String pullId = payment.getIncomePullId().toString();
			pullId = pullId.equals("0")?null:pullId;
			saveBackPaymentMoneyInByInIdAndPullId(paymentIds,incomeId,pullId);
		}
		
	}
	
	public String saveBackPaymentMoneyInByInIdAndPullId(String[] ids, String incomeId,String pullId) {
		// TODO Auto-generated method stub
		Map mpOrderDay = new HashMap();
		Map mpUsed = new HashMap();
		List payMentIdList = new ArrayList();
		
		org.apache.commons.collections.CollectionUtils.addAll(payMentIdList,ids);
		
		mpOrderDay.put("PayMentIdList",payMentIdList);
//		mpOrderDay.put("incomeId",incomeId);
		mpOrderDay.put("incomePullId",pullId);
		
//		System.out.println("<<<<<<<<<incomePullId 1>>>>>>"+pullId);
//		System.out.println("<<<<<<<<<ids 1>>>>>>"+ids.length);
//		System.out.println("<<<<<<<<<payMentId 2>>>>>>"+ids[0]);
//		List orderDayIdList = orderDayInfoDao.getIdsByPayMentAndIncome(mpOrderDay);
//		System.out.println("<<<<<<<<<orderDayIdList 1>>>>>>"+orderDayIdList.size());
		
//		List newOrderDayIdList = getorderDayIdsList(orderDayIdList);
		
//		System.out.println("<<<<<<<<<newOrderDayIdList 1>>>>>>"+newOrderDayIdList.size());
		
		mpUsed.put("PayMentIdList",payMentIdList);
//		mpUsed.put("OrderDayInfoIdList",newOrderDayIdList);
		mpUsed.put("OrderDayInfoIdList",null);
//		mpUsed.put("incomeId",incomeId);
		mpUsed.put("incomePullId",pullId);
		
		List usedList = incomeUsedDao.getOrderDayReturnMoney(mpUsed);
//		System.out.println("<<<<<<<<<usedList 1>>>>>>"+usedList.size());
		

		
		
		Map mpReturnUsed = getUsedMoneyMapFromList(usedList,"orderDayInfoId","moneyIn");
		
//		System.out.println("<<<<<<<<<saveDayPutOnById before>>>>>>");
		orderDayInfoDao.saveDayPutOnById(mpReturnUsed);
		
		
		//修改订单明细中的分配金额
		List orderDetailMoneyIn = incomeUsedDao.getOrderDetailMoneyinByIncomeuse(mpUsed);
		Map orderDetailMap = new HashMap();
		for(Iterator it = orderDetailMoneyIn.iterator();it.hasNext();){
			IncomeUsed incomeUsed = (IncomeUsed)it.next();
			double moneyIn = -incomeUsed.getMoneyIn().doubleValue();
			orderDetailMap.put(incomeUsed.getOrderDetailId(),new Double(moneyIn));
		}
		orderDetailDao.saveOrderDetailPublicInfoMoneyIn(orderDetailMap);		
		
		
//		System.out.println("<<<<<<<<<newOrderDayIdList affert>>>>>>");
		
		incomeUsedDao.deleteByPaymentIdAndIncomeIdAndDayId(mpUsed);
		
		
		
		
		
		
//		System.out.println("<<<<<<<<<deleteByPaymentIdAndIncomeIdAndDayId affert>>>>>>");
		return "success";
	}
	
	private List getorderDayIdsList(List ls){
		List orderDayIdList = new ArrayList();
		for (Iterator it = ls.iterator();it.hasNext();){
			Long orderDayId = (Long)it.next();
			if(!orderDayIdList.contains(orderDayId)){
				orderDayIdList.add(orderDayId);
			}
			
		}
		return orderDayIdList;
	}
	
	private Map getUsedMoneyMapFromList(List ls,String keyName,String valueName){
		Map mp = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			try {
				Object obj = (Object)it.next();
				String key = (String) BeanUtils.getProperty(obj,keyName) ;
				String value = (String) BeanUtils.getProperty(obj,valueName) ;
				mp.put(new Long(key),new Double(value));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return mp;
	}



	public List getContractPaymentList(String customerName,String startDate,String endDate) {
		// TODO Auto-generated method stub 
		String dates = DateUtil.getDate();
		if(endDate.equals("nowDate")){
			endDate = dates;
		}
		Map mp = new HashMap();	
		mp.put("dates",dates);
		mp.put("customerName",customerName);
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		
		List ls = dao.getContractPaymentList(mp);
		return ls;
	}

	public List getContractPaymentListPage(boolean isLastSumPage,String customerName,String startDate,String endDate, String pageIndex, String pageSize) {
		// TODO Auto-generated method stub
		String dates = DateUtil.getDate();
		if(endDate.equals("nowDate")){
			endDate = dates;
		}
		Map mp = new HashMap();	
		mp.put("dates",dates);
		mp.put("customerName",customerName);
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		
		List ls = dao.getContractPaymentListPage(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		
		
		double sumMoneyPay = 0;
		double sumMoneyIn = 0;
		List list = dao.getContractPaymentList(mp);
		for(Iterator it=list.iterator();it.hasNext();){
			ContractPayment con = (ContractPayment)it.next();
			sumMoneyPay+=con.getMoneyPay().doubleValue();
			sumMoneyIn+=con.getMoneyIn().doubleValue();
		}
//		System.out.println(">>>>>>>> ls "+ls.size());
//		System.out.println(">>>>>>>> list  "+list.size());
		if(isLastSumPage && ls.size()>0){
			ContractPayment contractPayment = new ContractPayment();
			contractPayment.setMoneyPay(new Double(sumMoneyPay));
			contractPayment.setMoneyIn(new Double(sumMoneyIn));
			contractPayment.setOrderCode("");
			contractPayment.setCustomerName("合计");
			ls.add(contractPayment);
		}
		return ls;
		
	}

	public String getContractPaymentListCount(String customerName,String startDate,String endDate){
		// TODO Auto-generated method stub
		String dates = DateUtil.getDate();
		if(endDate.equals("nowDate")){
			endDate = dates;
		}
		
		Map mp = new HashMap();	
		mp.put("dates",dates);
		mp.put("customerName",customerName);
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		List ls = dao.getContractPaymentList(mp);
		return (new Integer(ls.size())).toString();
	}

	
	//分页getContractPaymentPageList(contractPayment,pageIndex,pageSize);
	public List getContractPaymentPageList(ContractPayment contractPayment,String pageIndex,String pageSize) {
		
		
//		System.out.println("getContractPaymentPageList 5555555555555   6666666666   77777777777777777>>>>>>>> pageIndex "+pageIndex);
		
		boolean isResSort = SysParamUtil.getWithResourceSort();
		
		String carrierIds[] = contractPayment.getCarrierIds();
		String incPullIds[] = contractPayment.getIncPullIds();
		String userIds[] = contractPayment.getUserIds();

		List carrierIdList = new ArrayList();
		List resTypedList = new ArrayList(); 
		
//		
//		for(int i = 0;i<carrierIds.length;i++){
//			if(!carrierIds[i].equals("0")){
//				carrierIdList.add(carrierIds[i]);
//			}
//		}
//		
		
		if(isResSort){
			for(int i = 0;i<carrierIds.length;i++){
				if(!carrierIds[i].equals("0")){
					resTypedList.add(carrierIds[i]);
				}
			}
		}else{
			for(int i = 0;i<carrierIds.length;i++){
				if(!carrierIds[i].equals("0")){
					carrierIdList.add(carrierIds[i]);
				}
			}
		}	
		
		

		List incPullIdList = new ArrayList();
		for(int i = 0;i<incPullIds.length;i++){
			incPullIdList.add(incPullIds[i]);
		}	
		
		List uIdList = new ArrayList();
		for(int i = 0;i<userIds.length;i++){
			uIdList.add(userIds[i]);
		}	

		contractPayment.setIncPullIdList(incPullIdList);

		if(isResSort){
			contractPayment.setResourceTypeIdList(resTypedList);
		}else{
			contractPayment.setCarrierIdList(carrierIdList); 
		}

		if(carrierIds.length > 0){
			List ls1 = dao.getContractPaymentsByResource(contractPayment);
			List ls11 = dao.getContractPaymentsOfContractByResource(contractPayment);
			ls1.addAll(ls11);
			if(ls1.size() == 0) ls1.add(new Long(0));
			contractPayment.setPaymentIdList(ls1);
		
		}
		List ls2 = dao.getContractPaymentsPageForBalance(contractPayment,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));	
		List ls22 = dao.getContractPaymentsForBalance2(contractPayment);
		ls2.addAll(ls22);
		return ls2;
	}
	
	
	
	public List getContractPaymentList(ContractPayment contractPayment) {
		  long start1 = System.currentTimeMillis();

		String tvName = SysParamUtil.getTvNameParam();
		
		boolean isResSort = SysParamUtil.getWithResourceSort();
		
		if(!"sjz".equals(tvName)){
			contractPayment.setHaveContract(new Integer(1));
		}
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
		String carrierIds[] = contractPayment.getCarrierIds();
		String incPullIds[] = contractPayment.getIncPullIds();
		String userIds[] = contractPayment.getUserIds();
		
		 String orgId = contractPayment.getOrgId().toString();
		  List userls2 = UserUtil.getUserIdList(orgId);
		  if(userls2.size()>0) contractPayment.setUserIdList2(userls2);	
//		System.out.println("getContractPaymentList>>>>>>>>>>>>>>>>>333333333333333 4444444444444 555555555555>>>>>>>>>userls2.size() >> "+userls2);
//		System.out.println(">>>>>>>> carrierIds.length "+carrierIds.length);
//		System.out.println(">>>>>>>> getCustomerId "+contractPayment.getCustomerId());
		 
		//List resourceIdList = new ArrayList();
		List carrierIdList = new ArrayList(); 
		
		List resTypedList = new ArrayList(); 
		
		if(isResSort){
			for(int i = 0;i<carrierIds.length;i++){
				if(!carrierIds[i].equals("0")){
					resTypedList.add(carrierIds[i]);
					//CollectionUtils.addAll(resourceIdList, resourceManager.getResourceIdsForPutOn(carrierIds[i]).toArray());
//					resourceIdList.add(resourceManager.getResourceIdsForPutOn(carrierIds[i]).toArray());
				}
			}
		}else{
			for(int i = 0;i<carrierIds.length;i++){
				if(!carrierIds[i].equals("0")){
					carrierIdList.add(carrierIds[i]);
					
				}
			}
		}

		
//		for (Iterator it = resourceIdList.iterator();it.hasNext();){
//		    Long  l = (Long)it.next();
//		    System.out.println(">>>>>>>> resourceIdList:"+l.longValue());
//		}
		
		List incPullIdList = new ArrayList();
		for(int i = 0;i<incPullIds.length;i++){
			incPullIdList.add(incPullIds[i]);
		}	
		
//		List uIdList = new ArrayList();
//        if(SysParamUtil.isFZTVParam(tvName))	{
//   		   Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//            List userList = new ArrayList();
//            List ls=(List)userRelsMap.get(userIds[0]);
//            CollectionUtils.addAll(userList,ConvertUtil.getColFromList(ls,"id"));	
//            contractPayment.setUserIdList(userList); 
//        }else{
        	  List userList = new ArrayList();
        	  CollectionUtils.addAll(userList,userIds);	
        	  contractPayment.setUserIdList(userList); 
        	  
//              System.out.println(">>>>>>>> userList: "+userList);
//        }
        
  
        
        
//		for(int i = 0;i<userIds.length;i++){
//			uIdList.add(userIds[i]);
//		}
        
        
        
        /***************************************************
         * 客户父子关系   start
         * ****************************************/
		List cusIdList = new ArrayList();
		String cutId = ""+contractPayment.getCustomerId();
		if(!cutId.equals("0")&&!cutId.equals("-1")){
			cusIdList.add(contractPayment.getCustomerId()); 
			Customer customer = new Customer();
			customer.setParentId(""+contractPayment.getCustomerId());    
			List  cus = customerDao.getCustomers(customer);
			for(Iterator it = cus.iterator();it.hasNext();){
				Customer cust =(Customer)it.next();
				cusIdList.add(cust.getId());
			}
		}else if(cutId.equals("0")){
			cusIdList.add("0");
		}

		contractPayment.setCustomerIdList(cusIdList);
		
		System.out.println(">>>>>>>> getCustomerId : "+contractPayment.getCustomerId());
		System.out.println(">>>>>>>> cusIdList size: "+cusIdList);
		
	       /***************************************************
         * 客户父子关系   end
         * ****************************************/	
		
		
		
		
//		System.out.println(">>>>>>>> resourceIdList size: "+resourceIdList.size());
//		System.out.println(">>>>>>>> incPullIdList size:"+incPullIdList.size());
//		System.out.println(">>>>>>>> uIdList size:"+uIdList.size());
		//contractPayment.setResourceIdList(resourceIdList);
		
		System.out.println(">>>>>>>> incPullIdList size: "+incPullIdList);
		
		contractPayment.setIncPullIdList(incPullIdList);
		if(isResSort){
			contractPayment.setResourceTypeIdList(resTypedList);
		}else{
			contractPayment.setCarrierIdList(carrierIdList); 
		}
		
		System.out.println(">>>>>>>> carrierIdList size: "+carrierIdList);
//		System.out.println(">>>>>>>> resTypedList size: "+resTypedList);
//		System.out.println(">>>>>>>> resourceTypeId : "+contractPayment.getResourceTypeId());
//		System.out.println(">>>>>>>> orderCode : "+contractPayment.getOrderCode());
//		System.out.println(">>>>>>>> contractCode : "+contractPayment.getContractCode());
//		System.out.println(">>>>>>>> version : "+contractPayment.getVersion());
//		System.out.println(">>>>>>>> incPullIdList : "+contractPayment.getIncPullIdList());
		System.out.println(">>>>>>>> userIdList : "+contractPayment.getUserIdList());
//		System.out.println(">>>>>>>> resourceTypeIdList : "+contractPayment.getResourceTypeIdList());

//		if(carrierIds.length > 0 ||userIds.length >0){

		if(carrierIds.length > 0){
			 long end1 = System.currentTimeMillis();

			List ls1 = dao.getContractPaymentsByResource(contractPayment);
			 long end2 = System.currentTimeMillis();
			 System.out.println("getContractPaymentsByResource>>>>>>>> ls1.size() >>>>>>>>>>>>>>>>>>>>>>>   "+ ls1.size()+"");
			List ls11 = dao.getContractPaymentsOfContractByResource(contractPayment);
			
			 long end3 = System.currentTimeMillis();
			 System.out.println("getContractPaymentsOfContractByResource>>>>>> ls11.size()>>>>>>>>>>>>>>>>>>>>>>>>>   "+ ls11.size() +"");
			 
			ls1.addAll(ls11);
			
			 System.out.println("getContractPaymentsOfContractByResource>>>> ls1.addAll(ls11) >> ls1.size()>>>>>>>>>>>>>>>>>>>>>>>>>   "+ ls1.size() +"");
			 
			if(ls1.size() == 0) ls1.add(new Long(0));
			contractPayment.setPaymentIdList(ls1);
			
//			for (Iterator it = ls1.iterator();it.hasNext();){
//			    Long  l = (Long)it.next();
//			    System.out.println(">>>>>>>> PaymentId:"+l.longValue());
//			}
//			System.out.println(">>>>>>>> PaymentIdList size:"+ls1.size());
		}
		
		 long end4 = System.currentTimeMillis();
		 System.out.println("getContractPaymentsForBalance>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   start");
		 
			System.out.println(">>>>>>>> paymentIdList : "+contractPayment.getPaymentIdList());
			System.out.println(">>>>>>>> getVersion 1: "+contractPayment.getVersion());
			System.out.println(">>>>>>>> getState 1: "+contractPayment.getState());
			
			
//			ContractPaymentDao dao2 =ServiceLocator.getContractPaymentDao();
//			List ls2 = dao2.getContractPaymentsForBalance(contractPayment); 
			
			
			
		List ls2 = dao.getContractPaymentsForBalance(contractPayment); 
		
		
		System.out.println(">>>>>>>> ls2 : "+ls2.size());
		
//		List ls22 = dao.getContractPaymentsForBalance2(contractPayment);
//		ls2.addAll(ls22);

//		System.out.println(">>>>>>>> ls2 size:"+ls2.size());

		  
		 long end5 = System.currentTimeMillis();
		 System.out.println("getContractPaymentsForBalance>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+ (end5 -end4) +"秒");

		// TODO Auto-generated method stub
		return ls2;
	}
	
	
	//实现目标用一个sql解决
	public List getContractPaymentList_test(ContractPayment contractPayment) {
		  long start1 = System.currentTimeMillis();

		String tvName = SysParamUtil.getTvNameParam();
		boolean isResSort = SysParamUtil.getWithResourceSort();
		String carrierIds[] = contractPayment.getCarrierIds();
		String incPullIds[] = contractPayment.getIncPullIds();
		String userIds[] = contractPayment.getUserIds();
		
		System.out.println(">>>>>>>> getCarrierIds "+contractPayment.getCarrierIds());
		System.out.println(">>>>>>>> carrierIds.length "+carrierIds.length);
		System.out.println(">>>>>>>> getCustomerId "+contractPayment.getCustomerId());
		 
		List carrierIdList = new ArrayList(); 
		List resTypedList = new ArrayList(); 
		
		if(isResSort){
			for(int i = 0;i<carrierIds.length;i++){
				if(!carrierIds[i].equals("0")){
					resTypedList.add(carrierIds[i]);
				}
			}
		}else{
			for(int i = 0;i<carrierIds.length;i++){
				if(!carrierIds[i].equals("0")){
					carrierIdList.add(carrierIds[i]);
					
				}
			}
		}

		
//		for (Iterator it = resourceIdList.iterator();it.hasNext();){
//		    Long  l = (Long)it.next();
//		    System.out.println(">>>>>>>> resourceIdList:"+l.longValue());
//		}
		
		List incPullIdList = new ArrayList();
		for(int i = 0;i<incPullIds.length;i++){
			incPullIdList.add(incPullIds[i]);
		}	
		
		List uIdList = new ArrayList();
		
//      if(SysParamUtil.isFZTVParam(tvName))	{
// 		 Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//          List userList = new ArrayList();
//          List ls=(List)userRelsMap.get(userIds[0]);
//          CollectionUtils.addAll(userList,ConvertUtil.getColFromList(ls,"id"));	
//          contractPayment.setUserIdList(userList); 
//      }

		List cusIdList = new ArrayList();
		String cutId = ""+contractPayment.getCustomerId();
		if(!cutId.equals("0")&&!cutId.equals("-1")){
			cusIdList.add(contractPayment.getCustomerId()); 
			Customer customer = new Customer();
			customer.setParentId(""+contractPayment.getCustomerId());    
			List  cus = customerDao.getCustomers(customer);
			for(Iterator it = cus.iterator();it.hasNext();){
				Customer cust =(Customer)it.next();
				cusIdList.add(cust.getId());
			}
		}else if(cutId.equals("0")){
			cusIdList.add("0");
		}

		contractPayment.setCustomerIdList(cusIdList);
		
		
		
//		System.out.println(">>>>>>>> getCustomerId : "+contractPayment.getCustomerId());
//		System.out.println(">>>>>>>> cusIdList size: "+cusIdList.size());
//		System.out.println(">>>>>>>> resourceIdList size: "+resourceIdList.size());
//		System.out.println(">>>>>>>> incPullIdList size:"+incPullIdList.size());
//		System.out.println(">>>>>>>> uIdList size:"+uIdList.size());
		//contractPayment.setResourceIdList(resourceIdList);
		contractPayment.setIncPullIdList(incPullIdList);
		
		if(isResSort){
			contractPayment.setResourceTypeIdList(resTypedList);
		}else{
			contractPayment.setCarrierIdList(carrierIdList); 
		}

		List ls2 = dao.getContractPaymentsForBalance3(contractPayment);
		List ls22 = dao.getContractPaymentsForBalance4(contractPayment);
		ls2.addAll(ls22);
		
//		System.out.println(">>>>>>>> ls2 size:"+ls2.size());
		
		  
		 long end1 = System.currentTimeMillis();
		 System.out.println("getContractPaymentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+ (end1 -start1) +"秒");

		// TODO Auto-generated method stub
		return ls2;
	}
	
	public String getContractPaymentXML(ContractPayment contractPayment) {
		List ls = this.getContractPaymentList(contractPayment);
//		List ls = this.getContractPaymentList_test(contractPayment);
		
		return this.makeGridXML(ls,contractPayment);
	}
	//分页计算
	public String getContractPaymentPageXML(ContractPayment contractPayment,String pageIndex, String pageSize) {
		List ls = this.getContractPaymentPageList(contractPayment,pageIndex,pageSize);
		return this.makeGridXML(ls,contractPayment);
	}
	// 计算订单的总的纪录数
	  public String getContractPaymentCountXML(ContractPayment contractPayment){
	    	List ls = getContractPaymentList(contractPayment);
	    	return new Integer(ls.size()).toString();
	    }
	
	  
   public Map buildParamBy(String strQueryString){
		Map mp = new HashMap();	
		
		String year =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"year"),"");
		String loginUser =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"loginUser"),"");
		String signUserId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"signUserId"),"");
		String resourceName =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"resourceName"),"");
		String customerName =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"customerName"),""));
		String resourceTypeId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"resourceTypeId"),"");
		String orgId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"orgId"),"1");

		
		String startDate =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"startDate"),"0");
		String endDate =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"endDate"),"0");
		String contractSortId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"contractSortId"),"0");
		String defaultALL =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"defaultALL"),"0");
		
		List userIdList = new ArrayList();
//		List userIdList = new ArrayList();
//		List userList = dao.getUserIdByUserName(userName);
		System.out.println(">>>>>>>> year:"+year);
		System.out.println(">>>>>>>> loginUser:"+loginUser);
		System.out.println(">>>>>>>> signUserId:"+signUserId);
		System.out.println(">>>>>>>> resourceName:"+resourceName);
		System.out.println(">>>>>>>> customerName:"+customerName);
		System.out.println(">>>>>>>> resourceTypeId:"+resourceTypeId);
		System.out.println(">>>>>>>> startDate:"+startDate);
		System.out.println(">>>>>>>> endDate:"+endDate);
		System.out.println(">>>>>>>> contractSortId:"+contractSortId);
		System.out.println(">>>>>>>> defaultALL:"+defaultALL);
		
		signUserId = "0".equals(signUserId)?null:signUserId;
		customerName ="0".equals(customerName)?null:customerName;
		
		if(signUserId == null || "0".equals(signUserId) ||"null".equals(signUserId)||"".equals(signUserId)){
			userIdList = UserUtil.getCurUserRels(loginUser,orgId);
			System.out.println(">>>>>>>> userIdList size:"+userIdList.size());
			if(userIdList.size() == 0){
				userIdList.add("-1");
			}
		}else{
			mp.put("userId",signUserId);
		}

    	List lsCutCates = UserUtil.getCustomerCateByUser(loginUser, null);
    	if(lsCutCates.size()>0)mp.put("customerCates",lsCutCates);        
		
		mp.put("userIdList",userIdList);
//		String dates = DateUtil.getDate();
		Date nowDate = new  Date();
//		Integer date = new Integer(DateUtil.convertDateToString("yyyyMMdd",nowDate));
//		mp.put("date",date);
		mp.put("customerName",customerName);
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("contractSortId",contractSortId);
		mp.put("year",year);
		mp.put("orgId",orgId);
		mp.put("defaultALL",defaultALL);
		if(resourceTypeId !="") {
			List resourceTypeIdList = new ArrayList();
			
//			System.out.println(">>>3333333333333333333333333333333333333333333333333333333333333333333>>>>> resourceTypeId:"+resourceTypeId);
//			System.out.println(">>>3333333333333333333333333333333333333333333333333333333333333333333>>>>> resourceTypeId:"+resourceTypeId.split("_"));
			CollectionUtils.addAll(resourceTypeIdList,resourceTypeId.split("_"));
//			mp.put("resourceTypeId",resourceTypeId);
			mp.put("resourceTypeIdList",resourceTypeIdList);
		}

     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
     	}
     	
     	return mp;
   }
   
//   public List getContractPaymentCount(Map mp) {	
//	   return dao.getContractPaymentsCountByMap(mp);
//   }
   
   public String getContractPaymentsPageXML(String strQueryString) {	
	    Map mp =  this.buildParamBy(strQueryString);
		int posStart =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"posStart"),"0"));
        int count =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"30"));	
	    int total_count = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"total_count"),"0")) ;
		String loginUser = StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"loginUser"),"");
		String resourceName =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"resourceName"),"");  
//		String defaultALL =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"defaultALL"),"");
		
		System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> posStart:"+posStart);
		System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> count:"+count);
		System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> total_count:"+total_count);
//		System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> loginUser:"+loginUser);
//		System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>>>>>>>>>>>>>> resourceName:"+resourceName); 
		

     
        
//	   boolean isFinance = UserUtil.isGrandedRes(loginUser,resourceName);
	   boolean isFinance = true;
	   
//	   System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>>>>222222222>>>>>>>>>>>>> isFinance:"+isFinance);
	   
	   List pageList = dao.getContractPaymentFormPage(mp,posStart,count);
	   
	  
	   
		String[] sum = new String[3];
        if(posStart == 0){
	    	ContractPayment contractPayment= dao.getContractPaymentFormCount(mp);
        	total_count = Integer.parseInt(StringUtil.getNullValue(contractPayment.getPayNumber(),"0"));
//        	StringUtil.getNullValue(contractPayment.getMoneyPay(),"0")
        	sum[0] =  StringUtil.doubleFormat2(contractPayment.getMoneyPay());
        	sum[1] =  StringUtil.doubleFormat2(contractPayment.getMoneyIn());
        	double pay =  Double.valueOf(StringUtil.doubleFormat2(contractPayment.getMoneyPay())).doubleValue();
        	double in =  Double.valueOf(StringUtil.doubleFormat2(contractPayment.getMoneyIn())).doubleValue();
        	sum[2] =  StringUtil.doubleFormat2(new Double(pay - in));
  
//        	   System.out.println("getContractPaymentsPageXML>>>>>>>>>>>>>11111111111111111>>>>>>>>>>>>>>>> isFinance:" +total_count);
        }
	   
	   System.out.println("getContractPaymentFormPage>>>>>>>>>>>>>>pageList.size>>>>>>>>>>>>>>> :"+pageList.size());
	    
	   return this.makeGridFormXML2(pageList,isFinance, posStart,total_count,sum);

   }
   
   public  String makeGridFormXML2(List pageList,boolean isFinance,int posStart,int total_count,String[] sum  ){
	   
	   
	

		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows" +" total_count=\""+ total_count +"\"  pos=\""+ posStart +"\""+ " scrollTop=\"0\"" +">");  
		 
//		double pullMoneySum = 0; 
//		double incUsedMoneySum = 0; 
//		double relMoneySum = 0; 
		
		if(posStart == 0 && pageList.size()>0){
			
			sb.append("<head>"); 
			sb.append("<afterInit>"); 
			sb.append("<call command=\"attachHeader\">");
//			sb.append("<param> ,合计,"+ total_count +" ,,,,,"+ sum[0] +","+ sum[1] +"  ,,,,,,, ,</param>");
			
			String sss ="合计";

			sb.append("<param>,,,,,,,"+ sss +","+ sum[0] +","+ sum[1] +","+ sum[2] +"</param>");
			sb.append("<param>color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;</param>");
			sb.append("<param>_aFoot</param>");
			sb.append("</call>");
			sb.append("</afterInit>");
			sb.append("</head>"); 

		}
				

		
		for(Iterator it = pageList.iterator();it.hasNext();){
			
			ContractPayment payment = (ContractPayment)it.next();
			
			String orderId =  StringUtil.null2String(payment.getOrderId());
			String contractId =  StringUtil.null2String(payment.getContractId());


			
//			String orderCode =  Integer.parseInt(orderId) > 0?StringUtil.null2String(payment.getOrderCode()):"";
//			String contractCode =  Integer.parseInt(orderId) > 0?StringUtil.null2String(payment.getContractCode()):"";

			double pullMoney = payment.getMoneyPay().doubleValue();
//			System.out.println(" payment.getMoneyIn()<<<<<<<<11111111111<<<<<<<<<<"+ payment.getMoneyIn());
			Double moneyIn = payment.getMoneyIn()==null?new Double(0):payment.getMoneyIn();
			double incUsed = moneyIn.doubleValue();
			double relMoney = pullMoney - incUsed;
			String orgId = StringUtil.getNullValue( payment.getOrgId(),"1");
			String contractSort = StringUtil.getNullValue( payment.getContractSort(),"");
			

//			订单编号,客户名称,应付日期,应付金额,已付金额,欠款金额"
			if(relMoney>0){

//				sb.append("<row  id=\""+ payment.getId()  +">");
				
				sb.append("<row  id=\""+ payment.getId()  +"\"" +">");
				
				sb.append("<userdata name=\"paymentId\">"+ payment.getId() +"</userdata>");
				sb.append("<userdata name=\"paymentId2\">"+ payment.getId() +"_"+payment.getOrderId() +"</userdata>");
				sb.append("<userdata name=\"customerId\">"+ payment.getCustomerId()+"</userdata>");
				sb.append("<userdata name=\"orderUserName\">"+ payment.getOrderUser().getUsername() +"</userdata>");
				
				if(Integer.parseInt(orderId) > 0){
					sb.append("<userdata name=\"orderId\">"+orderId+"</userdata>");
					
					
//					sb.append("<row  id=\""+ orderId  +"\"" +">");
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//					if(isFinance) sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//					sb.append("<cell><![CDATA["+ payment.getOrderCode() + "^../editOrder.html?id=" + orderId +"]]></cell>"); orgId
					sb.append("<cell><![CDATA[ <a target=_blank href=../editOrder.html?id="+ orderId+"&orgId=" + orgId +">" + payment.getOrderCode() +"</a>]]></cell>");	
					sb.append("<userdata name=\"orderCode\">"+payment.getOrderCode()+"</userdata>");
				}else{
					sb.append("<userdata name=\"contractId\">"+contractId+"</userdata>");
//					sb.append("<row  id=\""+ contractId  +"\"" +">"); orgId
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//					if(isFinance) sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					
					sb.append("<cell><![CDATA["+ payment.getContractCode() + "^../editContract.html?id=" + contractId +"&orgId=" + orgId +"&contractSort="+ contractSort+"]]></cell>");
					sb.append("<userdata name=\"contractCode\">"+payment.getContractCode()+"</userdata>");
					
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				}
				
				sb.append("<cell><![CDATA["+ payment.getCustomerName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.getNullValue(payment.getMatter().getName(),"")  +"]]></cell>");
				sb.append("<cell><![CDATA["+ payment.getOrderUser().getFullName()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ payment.getResourceType().getName()  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ payment.getPayDate()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(payment.getPayDate().toString(),"yyyy/MM/dd")  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(pullMoney))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(incUsed))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(relMoney))  +"]]></cell>");

				sb.append("</row>");
				
//				pullMoneySum = pullMoneySum+pullMoney; 
//				incUsedMoneySum = incUsedMoneySum+incUsedMoneySum; 
//				relMoneySum = relMoneySum+relMoney; 
				
			}
			
		 }
	
//		sb.append("<row  id=\""+ all.size()  +"\"" +">");
//		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(pullMoneySum))  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(incUsedMoneySum))  +"]]></cell>");
//		sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(relMoneySum))  +"]]></cell>");
//		sb.append("</row>");	
		
		sb.append("</rows>");
		
		
//		 System.out.println("getContractPaymentFormPage>>>>>>>>>>sb.toString()>>>>>>>>>>>>>>>>>>>:"+sb.toString());
		
		return sb.toString();
 }	
	 
   
   
   
   
   
   
   
   
   
   
	  
	public String getContractPaymentFormXml(String year,String loginUser,String userName,String resourceName,String customerName) {	
		Map mp = new HashMap();	
		List userIdList = new ArrayList();
//		List userIdList = new ArrayList();
//		List userList = dao.getUserIdByUserName(userName);
		System.out.println(">>>>>>>> year:"+year);
		System.out.println(">>>>>>>> loginUser:"+loginUser);
		System.out.println(">>>>>>>> userName:"+userName);
		System.out.println(">>>>>>>> resourceName:"+resourceName);
		System.out.println(">>>>>>>> customerName:"+customerName);
		
		userName = userName.equals("0")?null:userName;
		customerName = customerName.equals("0")?null:customerName;
		
		if(userName == null){
			userIdList = UserUtil.getCurUserRels(loginUser);
			System.out.println(">>>>>>>> userIdList size:"+userIdList.size());
			if(userIdList.size() == 0){
				userIdList.add("-1");
			}
		}


		
		mp.put("userIdList",userIdList);
//		String dates = DateUtil.getDate();
		Date nowDate = new  Date();
//		Integer date = new Integer(DateUtil.convertDateToString("yyyyMMdd",nowDate));
//		mp.put("date",date);
		mp.put("customerName",customerName);
		mp.put("userId",userName);
		mp.put("year",year);
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
     	}
     	
		List ls = dao.getContractPaymentForm(mp);
		
		
		

		
		boolean isFinance = UserUtil.isGrandedRes(loginUser,resourceName);
		
//		System.out.println(">>>>>11111111111111111111111111111111111111>>> userIdList size:"+loginUser);
//		System.out.println(">>>>22222222222222222222222222222222222222>>>> userIdList size:"+resourceName);
//		System.out.println(">>>>333333333333333333333333333333333333>>>> isFinance:"+isFinance);
		
		return this.makeGridFormXML(ls,isFinance);
	}
	
	
	
	
	
	
	public Collection getCollections(Map searchMap){
		Map mp = new HashMap();	
		List userIdList = new ArrayList();
		
		System.out.println("loginUser>>>>>>>>"+searchMap.get("loginUser"));
		System.out.println("signUserId>>>>>>>>"+searchMap.get("signUserId"));
		System.out.println("resourceName>>>>>>>>"+searchMap.get("resourceName"));
		System.out.println("customerName>>>>>>>>"+searchMap.get("customerName"));
		
		String loginUser = StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("loginUser")));
		String signUserId=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("signUserId")));
		String resourceName=    StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("resourceName")));
		String customerName=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("customerName")));
		String resourceTypeId=   StringUtil.getURLDecoderStr(StringUtil.getNullValue(searchMap.get("resourceTypeId"),""));
		String orgId=   StringUtil.getURLDecoderStr(StringUtil.getNullValue(searchMap.get("orgId"),"1"));
		String year=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("year")));
		String startDate=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("startDate")));
		String endDate=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("endDate")));
		String contractSortId=   StringUtil.getURLDecoderStr(StringUtil.null2String(searchMap.get("contractSortId")));
		
		
//		boolean isFinance = UserUtil.isGrandedRes(loginUser,resourceName);
		
		
		System.out.println("loginUser>>>>>>>>"+loginUser);
		System.out.println("signUserId>>>>>>>>"+signUserId);
		System.out.println("resourceName>>>>>>>>"+resourceName);
		System.out.println("customerName>>>>>>>>"+customerName);
		
		if("".equals(signUserId) ||"0".equals(signUserId)||signUserId == null){
			userIdList = UserUtil.getCurUserRels(loginUser,orgId);
			System.out.println(">>>>>>>> userIdList size:"+userIdList.size());
			if(userIdList.size() == 0){
				userIdList.add("-1");
			}
		}else{
			mp.put("userId",signUserId);
		}
		mp.put("startDate",startDate);
		mp.put("endDate",endDate);
		mp.put("contractSortId",contractSortId);
		
		mp.put("orgId",orgId);
		mp.put("year",year);	
		mp.put("userIdList",userIdList);
//		Integer date = new Integer(DateUtil.convertDateToString("yyyyMMdd",new  Date()));
//		mp.put("date",date);
		mp.put("customerName",customerName);

		if(!"".equals(resourceTypeId)){
			List resourceTypeIdList = new ArrayList();
			CollectionUtils.addAll(resourceTypeIdList,resourceTypeId.split("_"));
			mp.put("resourceTypeIdList",resourceTypeIdList);
		}
		
    	List lsCutCates = UserUtil.getCustomerCateByUser(loginUser, null);
    	if(lsCutCates.size()>0)mp.put("customerCates",lsCutCates);        
		
     	if(UserUtil.isUserOrderYearRel()) {
     		mp.put("yearIdList",UserUtil.getUserYearRelByLoginUser(loginUser));
     	}
		
		List ls = dao.getContractPaymentForm(mp);
		
		
		FusionChartObject fObject=null;
		List valuecoll = new ArrayList();
		
		for(Iterator it = ls.iterator();it.hasNext();){
			ContractPayment payment = (ContractPayment)it.next();
			String orderId =  StringUtil.null2String(payment.getOrderId());
			String contractId =  StringUtil.null2String(payment.getContractId());
			double pullMoney = payment.getMoneyPay().doubleValue();
//			System.out.println(" payment.getMoneyIn()<<<<<<<<11111111111<<<<<<<<<<"+ payment.getMoneyIn());
			Double moneyIn = payment.getMoneyIn()==null?new Double(0):payment.getMoneyIn();
			double incUsed = moneyIn.doubleValue();
			double relMoney = pullMoney - incUsed;
			
			fObject = new FusionChartObject();
			
			
			if(Integer.parseInt(orderId) > 0){
				fObject.setId(orderId);
				fObject.setLable("");
				fObject.setValue1(payment.getOrderCode());	
			}else{
				fObject.setId(contractId);
//				fObject.setId(contractId);
				fObject.setLable(payment.getContractCode());
				fObject.setValue1("");	
			}
			
			

			
//			fObject.setLable(StringUtil.null2String(payment.getCustomerName()));
//			fObject.setValue1(StringUtil.null2String(payment .getContractCode()));
//			fObject.setValue2(StringUtil.null2String(payment.getOrderCode()));
			fObject.setValue2(StringUtil.null2String(payment.getCustomerName()));
			
//			System.out.println(" fObject getCustomerName<<<<<<<<11111111111<<yyyyy<<<<<<<<"+ payment.getCustomerName());
			
			fObject.setValue3(StringUtil.null2String(payment.getMatter().getName()));
			fObject.setValue4(StringUtil.null2String(payment.getOrderUser().getFullName()));
			fObject.setValue5(StringUtil.null2String(payment.getResourceType().getName()));
			fObject.setValue6(DateUtil.SetDateFormat(payment.getPayDate().toString(),"yyyy/MM/dd"));
			fObject.setValue7(StringUtil.doubleFormat2(new Double(pullMoney)));
			fObject.setValue8(StringUtil.doubleFormat2(new Double(incUsed)));
			fObject.setValue9(StringUtil.doubleFormat2(new Double(relMoney)));
			
			valuecoll.add(fObject);
			
		}
		Collection coll = new ArrayList();
		CollectionUtils.addAll(coll,valuecoll.iterator());
		return coll;	
	}
	
	
	public  String makeGridFormXML(List all,boolean isFinance){
//		int i = 0;
		
//		boolean isFztv = getFztvSpecialParam();
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		double pullMoneySum = 0; 
		double incUsedMoneySum = 0; 
		double relMoneySum = 0; 
		
		for(Iterator it = all.iterator();it.hasNext();){
			
			ContractPayment payment = (ContractPayment)it.next();
			
			String orderId =  StringUtil.null2String(payment.getOrderId());
			String contractId =  StringUtil.null2String(payment.getContractId());
			String contractSort =  StringUtil.getNullValue(payment.getContractSort(),"");
			String orgId =  StringUtil.getNullValue(payment.getOrgId(),"1");
	
			
//			String orderCode =  Integer.parseInt(orderId) > 0?StringUtil.null2String(payment.getOrderCode()):"";
//			String contractCode =  Integer.parseInt(orderId) > 0?StringUtil.null2String(payment.getContractCode()):"";

			double pullMoney = payment.getMoneyPay().doubleValue();
//			System.out.println(" payment.getMoneyIn()<<<<<<<<11111111111<<<<<<<<<<"+ payment.getMoneyIn());
			Double moneyIn = payment.getMoneyIn()==null?new Double(0):payment.getMoneyIn();
			double incUsed = moneyIn.doubleValue();
			double relMoney = pullMoney - incUsed;
			
		

//			订单编号,客户名称,应付日期,应付金额,已付金额,欠款金额"
			if(relMoney>0){


				
//				sb.append("<row  id=\""+ payment.getId()  +"\"" +" total_count=\"100\" pos=\"0\"" +">");
				
				sb.append("<row  id=\""+ payment.getId()  +"\"" +">");
				
				sb.append("<userdata name=\"paymentId\">"+payment.getId()+"</userdata>");
				sb.append("<userdata name=\"paymentId2\">"+payment.getId()+"_"+payment.getOrderId()+"</userdata>");
				sb.append("<userdata name=\"customerId\">"+payment.getCustomerId()+"</userdata>");
				sb.append("<userdata name=\"orderUserName\">"+payment.getOrderUser().getUsername()+"</userdata>");
				
				
				
				
				if(Integer.parseInt(orderId) > 0){
					sb.append("<userdata name=\"orderId\">"+orderId+"</userdata>");
					
					
//					sb.append("<row  id=\""+ orderId  +"\"" +">");
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//					if(isFinance) sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//					sb.append("<cell><![CDATA["+ payment.getOrderCode() + "^../editOrder.html?id=" + orderId +"]]></cell>");
					sb.append("<cell><![CDATA[ <a target=_blank href=../editOrder.html?id="+ orderId+">" + payment.getOrderCode() +"&orgId="+ orgId +"</a>]]></cell>");	
					sb.append("<userdata name=\"orderCode\">"+payment.getOrderCode()+"</userdata>");
				}else{
					sb.append("<userdata name=\"contractId\">"+contractId+"</userdata>");
//					sb.append("<row  id=\""+ contractId  +"\"" +">");
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
//					if(isFinance) sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
					
					sb.append("<cell><![CDATA["+ payment.getContractCode() + "^../editContract.html?id=" + contractId +"&contractSort="+ contractSort+"&orgId="+ orgId +"]]></cell>");
					sb.append("<userdata name=\"contractCode\">"+payment.getContractCode()+"</userdata>");
					
					sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
				}
				
				String matterName = StringUtil.getNullValue(payment.getMatter().getName(),"");
				matterName = "null".equals(matterName)?"":matterName;
				
//				System.out.println(" matterName kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ matterName);
				
				sb.append("<cell><![CDATA["+ StringUtil.getNullValue(payment.getCustomerName(),"")  +"]]></cell>");
				sb.append("<cell><![CDATA["+ matterName   +"]]></cell>");
				sb.append("<cell><![CDATA["+ payment.getOrderUser().getFullName()  +"]]></cell>");
//				sb.append("<cell><![CDATA["+ payment.getPayDate()  +"]]></cell>");
				sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(payment.getPayDate().toString(),"yyyy/MM/dd")  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(pullMoney))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(incUsed))  +"]]></cell>");
				sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(relMoney))  +"]]></cell>");

				sb.append("</row>");
				
				pullMoneySum = pullMoneySum+pullMoney; 
				incUsedMoneySum = incUsedMoneySum+incUsedMoneySum; 
				relMoneySum = relMoneySum+relMoney; 
				
			}
			
		 }
	
		sb.append("<row  id=\""+ all.size()  +"\"" +">");
		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		sb.append("<cell><![CDATA["+ ""  +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(pullMoneySum))  +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(incUsedMoneySum))  +"]]></cell>");
		sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(new Double(relMoneySum))  +"]]></cell>");
		sb.append("</row>");	
		
		sb.append("</rows>");
		
		return sb.toString();
  }
	
	public  String makeGridXML(List all,ContractPayment contractPayment){
		String tvName = SysParamUtil.getTvNameParam();
//		int i = 0;
		StringBuffer sb = new StringBuffer();
		
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");    
	
		long state = contractPayment.getState();
		for(Iterator it = all.iterator();it.hasNext();){
			
			CContractPayment payment = (CContractPayment)it.next();
			
			
	
//			System.out.println(" moneyPay<<<<<<<<<<<<<<<<<<"+ payment.getMoneyPay());
//			System.out.println(" moneyIn<<<<<<<<<<<<<<<<<<"+ payment.getMoneyIn());
			
			
			String paymentId = StringUtil.null2String(payment.getId());
			String payNumber = StringUtil.null2String(payment.getPayNumber());
			String payDate = DateUtil.SetDateFormat(payment.getPayDate().toString(),"MM/dd");
			String moneyPay = StringUtil.doubleFormat2(payment.getMoneyPay());
			String moneyIn = StringUtil.doubleFormat2(payment.getMoneyIn());
			String arrears = StringUtil.doubleFormat2(new Double(payment.getMoneyPay().doubleValue() - payment.getMoneyIn().doubleValue()));
			
			
			double arrears_temp = Double.parseDouble(arrears);
			double moneyIn_temp = Double.parseDouble(moneyIn);
			
//			System.out.println(" state<<<<<<<<<<<<<<<<<22222222222222222222       3333<<<"+ state);
//			System.out.println(" arrears_temp<<<<<<<<<<<<<<<<<22222222222222222222       3333<<<"+ arrears_temp);
//			System.out.println(" moneyIn_temp<<<<<<<<<<<<<<<<<22222222222222222222       3333<<<"+ moneyIn_temp);
			
			
			if((state ==1 && arrears_temp>0)||(state ==2 && moneyIn_temp>0)){
				
		
			
			
			
			String orderId = StringUtil.null2String(payment.getOrderId());
			String orderCode =  Integer.parseInt(orderId) > 0?StringUtil.null2String(payment.getOrderCode()):"";
			String contractId =  StringUtil.null2String(payment.getContractId());
			String contractCode =  StringUtil.null2String(payment.getContractCode());
			String customerId =  StringUtil.null2String(payment.getCustomerId());
			String memo =  StringUtil.null2String(payment.getMemo());
			String resourceTypeId = StringUtil.null2String(payment.getResourceTypeId());
			
			String resourceTypeName =  StringUtil.null2String(payment.getResourceType().getName());
			String orgId =  StringUtil.null2String(payment.getResourceType().getOrgId());
			
//			System.out.println(" orgId<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ orgId);
//			System.out.println(" resourceTypeName<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ resourceTypeName);
			
			
			String orderCodeLink =orderCode +  "^editOrder.html?id=" + orderId +"&orgId="+orgId;
//			String incomeCodeLink = "<a href=\"javascript:void 0\" onClick= getIncomeById("+ incomeId +")>" +incomeCode+ "</a>";	
			String matterName = StringUtil.String2kenizer(StringUtil.null2String(payment.getMatterName()),"\n\r\t").replaceAll(" ","_");
			matterName = StringUtil.getNullValue(matterName,"");
			
			String rowId = "0";
//			if(SysParamUtil.isFZTVParam(tvName)){
//				rowId = paymentId +"_"+ orderId ;
//			}else{
				rowId = paymentId;
//			}
			
			
//			double pullMoney = payment.getMoneyPay().doubleValue();
//			double incUsed = payment.getMoneyIn().doubleValue();
//			double relMoney = pullMoney - incUsed;
//			sb.append("<row  id=\""+ incomePull.getId()  +"\"" +"  style=\""+ getStyleCSS(i++) +"\">");
//			sb.append("<cell><![CDATA["+ payment.getIncomePurpose().getName()  +"]]></cell>");
//			DecimalFormat df = new DecimalFormat("00,000.00");
	
			sb.append("<row  id=\""+ rowId  +"\"" +">");
			sb.append("<cell><![CDATA["+ " "  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderCodeLink  +"]]></cell>");
			sb.append("<cell><![CDATA["+ contractCode  +"]]></cell>");
			sb.append("<cell><![CDATA["+  matterName  +"]]></cell>");
			sb.append("<cell><![CDATA["+ payNumber  +"]]></cell>");
			sb.append("<cell><![CDATA["+ payDate  +"]]></cell>");
			sb.append("<cell><![CDATA["+ moneyPay  +"]]></cell>");
			sb.append("<cell><![CDATA["+ moneyIn  +"]]></cell>");
			sb.append("<cell><![CDATA["+ arrears  +"]]></cell>");
			if(SysParamUtil.getWithResourceSort()) {
				sb.append("<cell><![CDATA["+ resourceTypeName  +"]]></cell>");
			}
			sb.append("<userdata name=\"type\">2</userdata>");
			sb.append("<userdata name=\"customerId\">"+ customerId +"</userdata>");
			sb.append("<userdata name=\"paymentId\">"+ paymentId +"</userdata>");
			sb.append("<userdata name=\"contractId\">"+ contractId+"</userdata>");
			sb.append("<userdata name=\"orderId\">"+ orderId +"</userdata>");
			sb.append("<userdata name=\"payDate\">"+ payment.getPayDate() +"</userdata>");
			sb.append("<userdata name=\"moneyPay\">"+ moneyPay +"</userdata>");
			sb.append("<userdata name=\"arrears\">"+  arrears +"</userdata>");
			sb.append("<userdata name=\"moneyIn\">"+ moneyIn +"</userdata>");
			sb.append("<userdata name=\"resourceTypeId\">"+ resourceTypeId +"</userdata>");
			sb.append("<userdata name=\"memo\">"+ memo +"</userdata>");
			
			
//			System.out.println(" customerId<<<<<<<<<<<<<<<<<<"+ customerId);
//			System.out.println(" paymentId<<<<<<<<<<<<<<<<<<"+ paymentId);
//			System.out.println(" contractId<<<<<<<<<<<<<<<<<<"+ contractId);
//			System.out.println(" orderId<<<<<<<<<<<<<<<<<<"+ orderId);
//			System.out.println(" payDate<<<<<<<<<<<<<<<<<<"+ customerId);
//			System.out.println(" payDate<<<<<<<<<<<<<<<<<<"+ payment.getPayDate());
//			System.out.println(" moneyPay<<<<<<<<<<<<<<<<<<"+ moneyPay);
//			System.out.println(" arrears<<<<<<<<<<<<<<<<<<"+ arrears);
//			System.out.println(" moneyIn<<<<<<<<<<<<<<<<<<"+ moneyIn);
//			System.out.println(" memo<<<<<<<<<<<<<<<<<<"+ memo);
//			
			
			
			
			sb.append("</row>");
			
			}
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
  }
// 	private static  boolean getFztvSpecialParam(){
//	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//	    if(StringUtils.isEmpty(sysParam.getFztvSpecialParam())) sysParam.setFztvSpecialParam("0");
//	    return (sysParam.getFztvSpecialParam().equals("0"))?false:true;
//	}
	public void saveContractPaymentVersion(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		dao.saveContractPaymentVersion(contractPayment);
	}

	public String getPaymentListXML(ContractPayment contractPayment) {
        
     	if(UserUtil.isUserOrderYearRel()) {
     		String loginUser = UserUtil.getCurrentPrincipalUser();
     		contractPayment.setYearIdList(UserUtil.getUserYearRelByLoginUser(loginUser));
     	}
		
		
		List all = dao.getContractPaymentsListPage(contractPayment);
//		System.out.println("all<<<<<<<1111111111111<<<<<<<<<<"+all.size());
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		for(Iterator it = all.iterator();it.hasNext();){
			ContractPayment LMan = (ContractPayment) it.next();
			String contractCode = LMan.getContractCode()==null?"":LMan.getContractCode();
			String orderCode = LMan.getOrderCode()==null?"":LMan.getOrderCode();
			
			sb.append("<row  id=\""+ LMan.getId()  +"\">");
			
			sb.append("<cell><![CDATA["+ LMan.getPayNumber() +"]]></cell>");
			sb.append("<cell><![CDATA["+ DateUtil.SetDateFormat(LMan.getPayDate().toString(),"yyyy/MM/dd") +"]]></cell>");
			sb.append("<cell><![CDATA["+ contractCode  + "^/adrm/editContract.html?id="+LMan.getContractId()  +"]]></cell>");
			
			sb.append("<cell><![CDATA["+ orderCode  + "^/adrm/editOrder.html?id="+LMan.getOrderId()+"&orgId="+LMan.getOrgId()  +"]]></cell>");
			
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(LMan.getMoneyPay())  +"]]></cell>");
			sb.append("<cell><![CDATA["+ StringUtil.doubleFormat2(LMan.getMoneyIn())  +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	
	public void updateNamberPayment(String id) {
		Map chMp = new HashMap();
		List all = dao.getPaymentTable(id);
		int i = 1;
//		System.out.println("all.size()<<<<<<<!1111111111111<<<<<<<<<<<<"+all.toString());
		for(Iterator it = all.iterator();it.hasNext();){
			ContractPayment contractPay = (ContractPayment)it.next();
			Long payMentId = contractPay.getId();
			Long number = new Long(i++);
			chMp.put("number",number);
			chMp.put("payMentId",payMentId);
			
			dao.updateNamberPayment(chMp);
		}
		
	}
	
	
	public void testXMTV(){
		String orderId="";
		
		Double balance  = new Double(0);
		String incomeId ="";
		String pullId="";
		String paymentId="";
		

	
		ResultSet rs;
		try {
			dao.getDefaultDataSource().getConnection().createStatement().execute("truncate table tb_income_used");
			dao.getDefaultDataSource().getConnection().createStatement().execute("update  tb_order_detail set money_in = 0");
			dao.getDefaultDataSource().getConnection().createStatement().execute("update  tb_order_day_info set day_rel_puton = 0");
			
			rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select incomeid,paymentid,balance,orderid from tb_temp_account_balance");
			while (rs.next()){
				orderId = (String)rs.getString("orderid");
				incomeId = (String)rs.getString("incomeid");
				paymentId = (String)rs.getString("paymentid");
				balance = Double.valueOf(rs.getString("balance"));
				pullId = incomeId;
				
				
//				System.out.println("orderId>>>>>>>>>>>>>>>>>   "+ orderId);
//				System.out.println("incomeId>>>>>>>>>>>>>>>>>   "+ incomeId);
//				System.out.println("balance>>>>>>>>>>>>>>>>>   "+ balance);
				
				//订单平帐 
				Map mp = new HashMap();
				mp.put("orderId",orderId);
				mp.put("contractId",null);
				List dayInfoList = orderDayInfoDao.getOrderDayInfosForPutOn(mp);
//				System.out.println("dayInfoList>>>>>>>>>>>>   "+ dayInfoList.size());
				setDayRelMoneyPullId(dayInfoList,balance.doubleValue(),incomeId,pullId,paymentId);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List getContractPaymentsCopy(Long orderId) {
		// TODO Auto-generated method stub
		return dao.getContractPaymentsCopy(orderId);
	}
	
	public void savePutonMonths(String[] querStrs) {
		// TODO Auto-generated method stub
		
		for(int i = 0;i<querStrs.length;i++){
			
			Map mp =  StringUtil.convertQueryStringtoMap(querStrs[i]);
			
//			StringUtilsv.printMap(mp);
			
			double balance = Double.parseDouble((String)mp.get("ban_value"));
			
			List dayInfoList = orderDayInfoDao.getOrderDayInfosForPutOn2(mp);
			
			String incomeId = (String)mp.get("incomeId");
			String pullId = (String)mp.get("pullId");
			String paymentId = (String)mp.get("paymentId");
			String resourceInfoId = (String)mp.get("resourceInfoId");

//			System.out.println("dayInfoList>>>>>>>>>>>>   "+ dayInfoList.size());
			System.out.println("balance>>>>>>>>>>>> *******************  "+ balance);
			System.out.println("incomeId>>>>>>>>>>>>  ******************* "+ incomeId);
			System.out.println("pullId>>>>>>>>>>>>  ******************* "+ pullId);
			System.out.println("paymentId>>>>>>>>>>>>  ******************* "+ paymentId);
			System.out.println("resourceInfoId>>>>>>>>>>>> *******************  "+ resourceInfoId);
			System.out.println("dayInfoList>>>>>>>>>>>>  ******************* "+ dayInfoList.size());
			setDayRelMoneyPullId(dayInfoList,balance,incomeId,pullId,paymentId);		
			
		}

		
//		return dao.savePutonMonths(querStrs);
		
//		return null;
	}
	public String saveBackPutonMonths(String[] querStrs) {
		
		for(int i = 0;i<querStrs.length;i++){
			Map mp =  StringUtil.convertQueryStringtoMap(querStrs[i]);
//			String incomeId = (String)mp.get("incomeId");
			String pullId = (String)mp.get("pullId");
//			String paymentId = (String)mp.get("paymentId");

			String orderId = (String)mp.get("orderId");
			String incomeMonthDay = (String)mp.get("incomeMonthDay");
			String customerId = (String)mp.get("customerId");			
			String channelId = (String)mp.get("channelId");			
			String resourceInfoId = (String)mp.get("resourceInfoId");			
			String matterId = StringUtil.getNullValue(mp.get("matterId"),null);
			
//			o.order_id,substring(odi.publish_date,1,6),cut.customer_id,chanl.resource_mediaorg_id, rs.ad_resource_info_id,mt.adver_matter_id		
			
			Map mpUsed = new HashMap();
			Map mpUsed2 = new HashMap();
			List payMentIdList = new ArrayList();
//			payMentIdList.add(paymentId);
//			org.apache.commons.collections.CollectionUtils.addAll(payMentIdList,ids);

//			System.out.println("<<<<<<<<<incomePullId 1>>>>>>"+pullId);
//			System.out.println("<<<<<<<<<ids 1>>>>>>"+ids.length);
//			System.out.println("<<<<<<<<<payMentId 2>>>>>>"+ids[0]);
//			List orderDayIdList = orderDayInfoDao.getIdsByPayMentAndIncome(mpOrderDay);
//			System.out.println("<<<<<<<<<orderDayIdList 1>>>>>>"+orderDayIdList.size());
			
//			List newOrderDayIdList = getorderDayIdsList(orderDayIdList);
			
//			System.out.println("<<<<<<<<<newOrderDayIdList 1>>>>>>"+newOrderDayIdList.size());
			
//			mpUsed.put("PayMentIdList",payMentIdList);
//			mpUsed.put("OrderDayInfoIdList",newOrderDayIdList);
			mpUsed.put("OrderDayInfoIdList",null);
			mpUsed.put("channelId",null);

//			mpUsed.put("customerId",customerId);
			mpUsed.put("incomePullId",pullId);
			mpUsed.put("orderId",orderId);			
			mpUsed.put("incomeMonthDay",incomeMonthDay);
			mpUsed.put("resourceInfoId",resourceInfoId);
			mpUsed.put("matterId",matterId);

			
			List usedList2 = incomeUsedDao.getOrderDayReturnMoney_IncomeUsedId(mpUsed);
			
//			System.out.println("<<<<<<<<<usedList 1>>>>>>"+usedList2.size());
			
			if(usedList2.size()> 0){
				
//				mpUsed.put("IncomeUsedIdList",usedList2);
				mpUsed2.put("IncomeUsedIdList",usedList2);
				
				List usedList = incomeUsedDao.getOrderDayReturnMoney(mpUsed2);
				
//				System.out.println("<<<<<<<<<usedList 2>>>>>>"+usedList.size());

				
				Map mpReturnUsed = getUsedMoneyMapFromList(usedList,"orderDayInfoId","moneyIn");
				
//				System.out.println("<<<<<<<<<mpReturnUsed 3>>>>>>"+mpReturnUsed.size());
				
	//			System.out.println("<<<<<<<<<saveDayPutOnById before>>>>>>");
				orderDayInfoDao.saveDayPutOnById(mpReturnUsed);
				
				
				//修改订单明细中的分配金额
				List orderDetailMoneyIn = incomeUsedDao.getOrderDetailMoneyinByIncomeuse(mpUsed2);
				
				System.out.println("<<<<<<<<< ************************************ orderDetailMoneyIn 4>>>>>>"+orderDetailMoneyIn.size());
				
				
				Map orderDetailMap = new HashMap();
				for(Iterator it = orderDetailMoneyIn.iterator();it.hasNext();){
					IncomeUsed incomeUsed = (IncomeUsed)it.next();
					double moneyIn = -incomeUsed.getMoneyIn().doubleValue();
					
//					System.out.println("<<<<<<***************************************<<<incomeUsed.getOrderDetailId() 5>>>>>>"+incomeUsed.getOrderDetailId());
					
					orderDetailMap.put(incomeUsed.getOrderDetailId(),new Double(moneyIn));
				}
				orderDetailDao.saveOrderDetailPublicInfoMoneyIn(orderDetailMap);		
	//			System.out.println("<<<<<<<<<newOrderDayIdList affert>>>>>>");

				incomeUsedDao.deleteByPaymentIdAndIncomeIdAndDayId(mpUsed2);
			}

			
		}
		
		
		
		
		
		
//		System.out.println("<<<<<<<<<deleteByPaymentIdAndIncomeIdAndDayId affert>>>>>>");
		return "success";
	}

	public List getContractPaymentsDesc(ContractPayment contractPayment) {
		List lss = dao.getContractPaymentsDesc(contractPayment);
        return lss;
	}	

}

