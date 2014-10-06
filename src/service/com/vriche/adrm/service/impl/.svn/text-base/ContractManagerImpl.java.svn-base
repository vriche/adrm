
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.model.Contract;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.LinkHisotry;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.ContractManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.OaWorkFlowManager;
import com.vriche.adrm.service.SysSequenceManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

public class ContractManagerImpl extends BaseManager implements ContractManager {
    private ContractDao dao;
    private OaWorkFlowManager oaWorkFlowManager;
    private CustomerDao customerDao;
    private SysSequenceManager sysSequenceManager;
    private CustomerManager customerManager;
    private CarrierManager carrierManager;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setContractDao(ContractDao dao) {
        this.dao = dao;
    }
 
	public void setOaWorkFlowManager(OaWorkFlowManager oaWorkFlowManager) {
		this.oaWorkFlowManager = oaWorkFlowManager;
	}   
	
	public void setSysSequenceManager(SysSequenceManager sysSequenceManager) {
		this.sysSequenceManager = sysSequenceManager;
	}
	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
	
	/**
	 * @param carrierManager The carrierManager to set.
	 */
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}	
	
	
	
	
	
	
	
    /**
     * @see com.vriche.adrm.order.service.ContractManager#getContractsByIdList(final Map idList)
     */
//    public PaginatedList getContractsByIdList(final Map idList,String pageIndex, String pageSize) {
//    
//        return dao.getContractsByIdList(idList,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
//    }
    /**
     * @see com.vriche.adrm.order.service.ContractManager#getContractsByIdList(final Map idList)
     */
    private List getContractsByIdList(final Map idList,String pageIndex, String pageSize) {   
        return dao.getContractsByIdList(idList,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
    }
   /**
     * @see com.vriche.adrm.order.service.ContractManager#getContracts(com.vriche.adrm.order.model.Contract)
     */
    public List getContracts(final Contract contract) {
        return dao.getContracts(contract);
    }
    
  
	public  boolean getChannelModelPara(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getChannelModelParam())) sysParam.setChannelModelParam("0");
	    return (sysParam.getChannelModelParam().equals("0"))?false:true;
	} 
	
	
	
	
	private void getQueryWhere(Contract contract){
			String carrierId = String.valueOf(contract.getCarrierId());
    	
		if(carrierId != null && !"".equals(carrierId)){
			
			boolean channelPull = SysParamUtil.getChannelModelPara();
			boolean channelNoPull = SysParamUtil.getMoreChannelNoPullParam();
			String tvName = SysParamUtil.getTvNameParam();

			carrierId = (carrierId == null || "".equals(carrierId) || "null".equals(carrierId))?"0":carrierId;
			

			 
			 
			boolean carrierAlisname = SysParamUtil.getUseCarrierAliname();
	        
	    	if(carrierAlisname && !"0".equals(carrierId)){
	    		String ids = CarrierUtil.getOtherSameAlisnameIds(carrierId);
	    		if(ids.indexOf(",")>-1){
	    			String[] s = ids.split(",");
	    			for(int i = 0;i<s.length;i++){
	    				contract.getCarrierIdList().add(s[i]);
	    			}
	    		}else{
	    			contract.getCarrierIdList().add(carrierId);
	    		}
	    		contract.setCarrierId(null);
	    	}else{
	    		
	    		
				if(carrierId.equals("0")){
					
					
					if(channelPull){
						

						if("hntv".equals(tvName)){
							String currentUser = UserUtil.getCurrentPrincipalUser();
//							List carrierIdList = carrierManager.getCarrierIdListsNotChilden(carrierId,channelPull,currentUser);
							List carrierIdList = CarrierUtil.getCarrierIds(carrierId,"1",currentUser);

							if(carrierIdList.size() == 0){
								carrierIdList.add("-1");
							}
							contract.setCarrierIdList(carrierIdList);
						}
					
						
					}
					contract.setCarrierId(null);
				}else{
					
					contract.setCarrierId(new Long(carrierId));
					
		    	}
	    	} 	
		}
	}
    public List getContractsPage(Contract contract,String pageIndex, String pageSize) {
    	
    	
//    	
//		boolean channelPull =  SysParamUtil.getChannelModelPara();
//		List carrierIdList2 = new ArrayList();
//		Map carrierMp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
//		//判断是否分频道，值为1分，否则不分
//		if((!"".equals(carrierIds) &&  carrierIds!=null && !"0".equals(carrierIds))){
//			String[] carrierNames = carrierIds.split(",");
//			for(int i=0;i<carrierNames.length;i++){
//				List lss = (List)carrierMp.get(new Long(carrierNames[i]));
//				CollectionUtils.addAll(carrierIdList2,ConvertUtil.getColFromList(lss,"id"));
//			}
//		}else{
//			carrierIdList2 = carrierManager.getCarrierIdLists(carrierIds,channelPull,currentUser);
//			if(carrierIdList2.size() == 0)carrierIdList2.add("-1");
//			
//		}			
		

    	
    	
//    	String carrierId = String.valueOf(contract.getCarrierId());
//    	
//    	if(carrierId != null){
//    		if(carrierId.equals("0")){
//        		boolean channelPull = getChannelModelPara();
//        		String currentUser =  String.valueOf(contract.getSignUser()); 
//        		List carrierIdList = carrierManager.getCarrierIdListsNotChilden(carrierId,channelPull,currentUser);
//        		contract.setCarrierIdList(carrierIdList);
//        		contract.setCarrierId(null);
//    		}else{
//    			contract.setCarrierId(new Long(carrierId));
//    		}
//
//    	}
    	log.info("pageIndex >>>>>>>>>>>>" + pageIndex);
    	log.info("pageSize >>>>>>>>>>>>" + pageSize);
//    	List ls = dao.getContractsPage(contract,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
//    	log.info("ls.size() >>>>>>>>>>>>" + ls.size());
//    	return ls;
    	
    	this.getQueryWhere(contract);
    	
        return dao.getContractsPage(contract,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
    }
    
    

	public String getContractsCount(Contract contract) {
		this.getQueryWhere(contract);
		return dao.getContractsCount(contract).toString();
	}
	

	/**
     * @see com.vriche.adrm.order.service.ContractManager#getContract(String id)
     */
    public Contract getContract(final String id) {
        return dao.getContract(new Long(id));
    }

    /**
     * @see com.vriche.adrm.order.service.ContractManager#saveContract(Contract contract)
     */
    public String saveContract(Contract contract) {
//    	checkIsNewCustomer(contract);
    	String contractCode ="";
    	if(contract.getId()==null){
    		contractCode = sysSequenceManager.getSysSequenceByObject(contract.getOrgId().toString(),Constants.SEQUENCE_TB_CONTRACT);
	    	contract.setCode(contractCode);
    	}
    	if(contractCode.endsWith("")||contractCode ==""|| contractCode == null){
    		log.info("获得合同号失败！");
    		return "0";
    	}else{
    		 return dao.saveContract(contract).toString();
    	}
       
    }
    
    
    
	public  boolean getOrderCodeModelParam(){
	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
	    if(StringUtils.isEmpty(sysParam.getOrderCodeModelParam())) sysParam.setOrderCodeModelParam("0");
	    return (sysParam.getOrderCodeModelParam().equals("0"))?false:true;
	} 
	
    public Contract saveContractReturnObj(Contract contract) {
//    	checkIsNewCustomer(contract);
    	String contractCode = contract.getCode();
    	boolean orderCodeModelParam = getOrderCodeModelParam();
//    	log.info("contract.getId()1111>>>>>>>>"+contract.getId());
    	if(contract.getId()==null){
//    		log.info("contract.getId()222222>>>>>>>>"+contract.getId());
    		String year = contract.getVersion().toString();
    		if(orderCodeModelParam){
    			
    	
    			contractCode = sysSequenceManager.getSysSequenceByObject(contract.getOrgId().toString(),Constants.SEQUENCE_TB_CONTRACT,year);
    		}else{
    			contractCode = contract.getCode();
    		}
    		
//    		log.info("contract.getId()33333333>>>>>>>>"+contractCode);
	    	contract.setCode(contractCode);
    	}
    	
    	if(contractCode.equals("")||contractCode ==""|| contractCode == null){
    		log.info("获得合同号失败！");
    		contract.setId(new Long(0));
    		contract.setCode("0");
    		return contract;
    	}else{
    		contract.setId(new Long(dao.saveContract(contract).toString()));
    		contract.setCode(contractCode);
    		return contract;
    	}  
    }

    /**
     * @see com.vriche.adrm.order.service.ContractManager#removeContract(String id)
     */
    public void removeContract(final String id) {
        dao.removeContract(new Long(id));
    }

     /**
     * @see com.vriche.adrm.order.service.ContractManager#removeContracts(String Map)
     */
    public void removeContracts(final Map idList) {
        dao.removeContracts(idList);
    }




	public String getContractsByWorkFlowCount(String workFlowId, int state) {
		Map mp = getEventIds(workFlowId,state);
		return dao.getContractsByIdListCount(mp).toString();
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getCheckEvenByTypeUser(java.lang.String, java.lang.String)
	 * 	0 未审  1通过  2 退回 3、终止
	 */
//	public PaginatedList getContractsByWorkFlowPage(String workFlowId, int state,String pageIndex, String pageSize) {
//		Map mp = getEventIds(workFlowId,state);
//		return this.getContractsByIdList(mp,pageIndex,pageSize);	
//	}
	public List getContractsByWorkFlowPage(String workFlowId, int state,String pageIndex, String pageSize) {
		Map mp = getEventIds(workFlowId,state);
		return this.getContractsByIdList(mp,pageIndex,pageSize);	
	}	
	
	public Map getEventIds(String workFlowId,int stateId){
		List eventIdsList = new ArrayList();
		List ContractIdList = new ArrayList();
		Map mp = new HashMap();

		//获得属于自己的流程
		List ownerList  = new ArrayList();
		ownerList.add(oaWorkFlowManager.getOaWorkFlow(workFlowId));
		
		if(ownerList.size() == 0) stateId = 0;

		if(ownerList.size() > 0){
//			log.info("eventIdsList.size() >>>>>>>>>>>>" + eventIdsList.size());
			//通过自己的流程ID，获得 同意或不同意流转过来的流程
			List otherList  = oaWorkFlowManager.getWorkFlowOther(ownerList);
			CollectionUtils.addAll(otherList,ownerList.iterator());
			Long userId = new Long("0");
			String orderCode ="";
			String year ="";
			String carrierId ="";
			String customerName="";
			
			
			oaWorkFlowManager.getEventsByWorkFlows(workFlowId,eventIdsList,otherList,stateId,1,userId,orderCode,year,carrierId,customerName);	
		}
//		log.info("eventIdsList.size() >>>>>>>>>>>>" + eventIdsList.size());
//		for(Iterator its=eventIdsList.iterator();its.hasNext();){
//			Contract cat=(Contract) its.next();
//			ContractIdList.add(cat.getId());
//		}
		//if(eventIdsList.size()== 0) eventIdsList.add("");
		//mp.put("ContractIdList",eventIdsList);
//		if(eventIdsList.size()== 0) ContractIdList.add("");
//		mp.put("ContractIdList",ContractIdList);
		if(eventIdsList.size()== 0) eventIdsList.add("");
		mp.put("ContractIdList",eventIdsList);
//		mp.put("stateId",String.valueOf(stateId));	
		return mp;
	}


	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.ContractManager#updateContractChecked(java.lang.String[], java.lang.String)
	 */
	public void updateContractStates(Set ids, int state) {
    	List contractIdList = new ArrayList();
        CollectionUtils.addAll(contractIdList,ids.iterator());
        
        if(contractIdList.size() >0){
        	Map mp = new HashMap();
    		mp.put("stateId",String.valueOf(state));	
    		mp.put("ContractIdList",contractIdList);
        	dao.updateContractState(mp);       	
        }     
		
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.ContractManager#updateContractStates(java.lang.Object[], int)
	 */
	public void updateContractStates(String[] ids, int state) {
		Set conidSet = new HashSet();
		for (int i = 0; i< ids.length; i++){
			  CollectionUtils.addAll(conidSet,ids);
		}
		if (conidSet.size() >0 ) this.updateContractStates(conidSet,state);
	}

//	private void checkIsNewCustomer(Contract contract){
//		Long customerId = contract.getCustomer().getId();
//		String customerName = contract.getCustomer().getCustomerName();
//		String customerCategoryId = contract.getCustomer().getCustomerCategoryId();
//		String ownerUserId = contract.getOwner().toString();
//		String id = customerManager.saveCustomer(customerId,customerName,customerCategoryId,ownerUserId);
//		contract.setCustomerId(new Long(id));
//	}
	
	public List getContractPaymentAutoComplet(Contract contract) {
		// TODO Auto-generated method stub
		return dao.getContractAutoComplet(contract);
	}

	
	private List getContractsPages(Contract contract) {
		return dao.getContractsList(contract);
	}
	public String getcontractXML(Contract contract) {
//		LinkMan linkMan = new LinkMan();
//		customerAddress.setCustomerId(new Long(customerId));
		List all = getContractsPages(contract);
		
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		for(Iterator it = all.iterator();it.hasNext();){
			Contract LMan = (Contract) it.next();
			
			String moneyIn = LMan.getMoneyIn()== null?"":LMan.getMoneyIn().toString();
			//合同编号code   	合同总金额moneySum   	已投放金额 moneyIn  	平帐金额 moneyIn  	开始日期startDate   	结束日期 endDate  状态state
			sb.append("<row  id=\""+ LMan.getId()  +"\">");
//			sb.append("<cell><![CDATA["+ orderDayInfo.getCarrier().getCarrierName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getCode() + "^/adrm/editContract.html?id="+LMan.getId() +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getMoneySum()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ "]]></cell>");
			sb.append("<cell><![CDATA["+ moneyIn  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getStartDate()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getEndDate()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ LMan.getState()  +"]]></cell>");
			
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}

	public Collection getCollectionsList(String strQueryString, String type) {
		

		
        String version =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"version"),"0"));
        String orgId =  StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"orgId"),"1"));
        String carrierId = StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"carrierId"),null);
        String customerId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"customerId"),null);
        String contractSort =StringUtil.getURLDecoderStr(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"contractSort"),null));
        String customerCategoryId =  StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"customerCategoryId"),null);
        
        
//        log.info("customerCategoryId >>>>>>>77777777777777777777777777777>>>>>" + customerCategoryId);
        Contract contractParam = new Contract();
        
        contractParam.setCustomerCategoryId(customerCategoryId);

        
        contractParam.setVersion(new Integer(version));
        contractParam.setOrgId(new Long(orgId));
        if(carrierId != null) contractParam.setCarrierId(new Long(carrierId));
        if(customerId != null) contractParam.setCustomerId(new Long(customerId));
        if(contractSort != null && !"".equals(contractSort)){
            contractParam.setContractSort(new Integer(contractSort));
        }

     
		List ls = getContractsPage(contractParam,"0", "2000");
		
		
		List valuecoll = new ArrayList();
		
		int cols = 8;

		
		for(Iterator it = ls.iterator();it.hasNext();){
			
			Contract contract =  (Contract)it.next();
		
			
			String code = StringUtil.null2String(contract.getCode());
			String customerName = StringUtil.null2String(contract.getCustomer().getCustomerName());

			String sort = contract.getContractSort().toString();
			if("0".equals(sort)) sort ="协约";
			if("1".equals(sort)) sort ="协议";
			if("2".equals(sort)) sort ="部门订单";
			
			String moneySum =StringUtil.doubleFormat2(contract.getMoneySum());
			String moneyIn =StringUtil.doubleFormat2(contract.getMoneyIn());
			String csignDate = DateUtil.SetDateFormat(contract.getCsignDate().toString(),"yyyy/MM/dd");
			String ownerUser = StringUtil.getNullValue(contract.getOwnerUser().getFullName(),"");
			String startDate = DateUtil.SetDateFormat(contract.getStartDate().toString(),"yyyy/MM/dd");
			String endDate = DateUtil.SetDateFormat(contract.getEndDate().toString(),"yyyy/MM/dd");
			String checkStateName = StringUtil.null2String(contract.getCheckState().getName());
			

//			合同编号,客户名称,合同性质,签订日期,合同总金额,签订人,开始日期,结束日期
			

			FusionChartObject fObject = new FusionChartObject();
			
			if(type.equals("report")){
				for(int i=0;i<cols+1;i++){
					switch(i){
				
						case 1:
							fObject.setLable(code);break;
						case 2:
							fObject.setValue1(customerName);break;
						case 3:
							fObject.setValue2(sort);break;
						case 4:
							fObject.setValue3(csignDate);break;
						case 5:
							fObject.setValue4(moneySum);break;
						case 6:
							fObject.setValue5(ownerUser);break;
						case 7:
							fObject.setValue6(startDate);break;
						case 8:	
							fObject.setValue7(endDate);break;
//						case 9:	
//							fObject.setValue8(checkStateName);break;

						default :
					}
				}
			}
			valuecoll.add(fObject);
		}

		
		return valuecoll;		
		
	
	}  
 
}
