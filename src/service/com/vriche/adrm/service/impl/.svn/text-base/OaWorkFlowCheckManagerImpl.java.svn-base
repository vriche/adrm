
package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaWorkFlowCheckDao;
import com.vriche.adrm.model.OaWorkFlowCheck;
import com.vriche.adrm.service.ContractManager;
import com.vriche.adrm.service.OaWorkFlowCheckManager;
import com.vriche.adrm.service.OaWorkFlowManager;
import com.vriche.adrm.service.OrderManager;

public class OaWorkFlowCheckManagerImpl extends BaseManager implements OaWorkFlowCheckManager {
    private OaWorkFlowCheckDao dao;
	private OaWorkFlowManager oaWorkFlowManager;
	private ContractManager contractManager; 
	private OrderManager orderManager; 
	

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaWorkFlowCheckDao(OaWorkFlowCheckDao dao) {
        this.dao = dao;
    }

	public void setOaWorkFlowManager(OaWorkFlowManager oaWorkFlowManager) {
		this.oaWorkFlowManager = oaWorkFlowManager;
	}   

	public void setContractManager(ContractManager contractManager) {
		this.contractManager = contractManager;
	}	
	/** 
	 * @param orderManager The orderManager to set.
	 */
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	   	
	
	
   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#getOaWorkFlowChecks(com.vriche.adrm.model.OaWorkFlowCheck)
     */
    public List getOaWorkFlowChecks(final OaWorkFlowCheck oaWorkFlowCheck) {
        return dao.getOaWorkFlowChecks(oaWorkFlowCheck);
    }
   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#getOaWorkFlowChecksCount(com.vriche.adrm.model.OaWorkFlowCheck)
     */
    public String getOaWorkFlowChecksCount(final OaWorkFlowCheck oaWorkFlowCheck) {
        return dao.getOaWorkFlowChecksCount(oaWorkFlowCheck).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#getOaWorkFlowChecksCount(com.vriche.adrm.model.OaWorkFlowCheck)
     */    
	public PaginatedList getOaWorkFlowChecksPage(final OaWorkFlowCheck oaWorkFlowCheck,String pageIndex, String pageSize) {
		return dao.getOaWorkFlowChecksPage(oaWorkFlowCheck,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#getOaWorkFlowCheck(String id)
     */
    public OaWorkFlowCheck getOaWorkFlowCheck(final String id) {
        return dao.getOaWorkFlowCheck(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#getOaWorkFlowChecksByIdList(final Map idList)
     */
    public List getOaWorkFlowChecksByIdList(final Map idList) {
        return dao.getOaWorkFlowChecksByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#saveOaWorkFlowCheck(OaWorkFlowCheck oaWorkFlowCheck)
     */
    public String saveOaWorkFlowCheck(OaWorkFlowCheck oaWorkFlowCheck) {
    	boolean isFirstPoint = false;  //入口点
    	boolean isEndPoint = false;    //终止点
    	String checkId = null;
    	String workFlowId = oaWorkFlowCheck.getWorkFlowId().toString();
    	int state = oaWorkFlowCheck.getCheckStateId().intValue();  //审批结果 1 未审  2审核中 3 通过  4 退回 
    	
    	oaWorkFlowCheck.setCreateDate(new Date());
   
    	
    	try {
        	Object workFlow  = oaWorkFlowManager.getOaWorkFlow(workFlowId);
        	isFirstPoint = (String)BeanUtils.getProperty(workFlow,"isFirstPoint") == "true";
        	isEndPoint = (String)BeanUtils.getProperty(workFlow,"isEndPoint")== "true";
		} catch (Exception e) {
			// TODO: handle exception
		}
        //修改数据源的状态
		updateSourceState(oaWorkFlowCheck,isFirstPoint,isEndPoint);


    	if(state == 4 || state == 3) updateCheckResult(oaWorkFlowCheck);
		//保存审批结果    	
		checkId = dao.saveOaWorkFlowCheck(oaWorkFlowCheck).toString();
		saveOaWorkFlowCheck(oaWorkFlowCheck,checkId);
		
    	if((state == 4 && isFirstPoint) ||(state == 3 && isEndPoint)) updateCheckResult(oaWorkFlowCheck);
    	//把原来审核结果表中状态 为 0 改 成1 标志审核过
        return checkId;
    }

    /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#removeOaWorkFlowCheck(String id)
     */
    public void removeOaWorkFlowCheck(final String id) {
        dao.removeOaWorkFlowCheck(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaWorkFlowCheckManager#removeOaWorkFlowChecks(String Map)
     */
    public void removeOaWorkFlowChecks(final Map idList) {
        dao.removeOaWorkFlowChecks(idList);
    }   
    
    private void updateCheckResult(OaWorkFlowCheck workFlowCheck){
    	int type = workFlowCheck.getWorkFlowTypeId().intValue();
    	Set eventIds =  getIdsByWorkFlowCheck(workFlowCheck); 
	    String paraName = "";
	    
		if(type == 1 ) paraName = "ContractIdList";
		if(type == 2 ) paraName = "OrderIdList";
		if(type == 3 ) paraName = "OaApplyInfoIdList";

    	if(eventIds.size()>0){
        	List  idList = new ArrayList();
        	CollectionUtils.addAll(idList,eventIds.iterator());
        	Map mp = new HashMap();
    		mp.put("checked",String.valueOf("1"));	
    		mp.put(paraName,idList);       
    		if(type == 1) dao.updateContractChecked(mp);	  
    		if(type == 2) dao.updateOrderChecked(mp);	
    		if(type == 3) dao.updateApplyChecked(mp);	
    	}
    }

   private void saveOaWorkFlowCheck(OaWorkFlowCheck workFlowCheck,String checkId){
	   int type = workFlowCheck.getWorkFlowTypeId().intValue();
	   Set eventIds = getIdsByWorkFlowCheck(workFlowCheck); 
	   String paraName = "";
	   
	   if(type == 1 ) paraName = "contractId";
	   if(type == 2 ) paraName = "orderId";
	   if(type == 3 ) paraName = "applyId";
	   
	   Object[] ids = eventIds.toArray();

	   for(int i = 0;i<ids.length;i++){
		   	Map mp = new HashMap();
			mp.put("checkId",checkId);
			mp.put(paraName,ids[i].toString());
			
			if(type == 1) dao.saveOaWorkFlowCheckContracts(mp);	
			if(type == 2) dao.saveOaWorkFlowCheckOrders(mp);	
			if(type == 3) dao.saveOaWorkFlowCheckApplys(mp);	
	   }

   }
   
   
   private void updateSourceState(OaWorkFlowCheck workFlowCheck,boolean isFirstPoint,boolean isEndPoint){
	   //合同审批结果 只传递 3 通过  4 退回 
	    int type =  workFlowCheck.getWorkFlowTypeId().intValue();
	    int state = workFlowCheck.getCheckStateId().intValue();  //审批结果 1 未审  2审核中 3 通过  4 退回 
	    int sourceState = getUpdateSourceState(state,isFirstPoint,isEndPoint);  
	    boolean  needUpdate =  checkIsNeedUpdate(state,isFirstPoint,isEndPoint);
	    
	    Set eventIds = getIdsByWorkFlowCheck(workFlowCheck);
		//如果是入口点，需要修改数据源的状态
        //同意且是终点，数据源状态改审核中
	    
//	    log.info("sourceState>>hhhh>>>>" +sourceState);
	    if(type ==1 && needUpdate) contractManager.updateContractStates(eventIds,sourceState); 
	    if(type ==2 && needUpdate) orderManager.updateOrderStates(eventIds,sourceState); 
	    if(type ==3 && needUpdate) contractManager.updateContractStates(eventIds,sourceState); 

   }
   
   
   private int getUpdateSourceState(int state,boolean isFirstPoint,boolean isEndPoint){
	   int sourceState = state;
	   
	   	if(isFirstPoint || isEndPoint){
			if((state == 3 && !isEndPoint) || (state == 4 && isEndPoint && !isFirstPoint)){
				sourceState = 2; 
			}
		}	   
	   
	   	return sourceState;  
   }
   
 private boolean checkIsNeedUpdate(int state,boolean isFirstPoint,boolean isEndPoint){
	 boolean need = false;
	 
 	if(isFirstPoint || isEndPoint){
		if(state == 3 || state == 4){need = true;}
	}	 
	return need;
 }
   
   
   
   private Set getIdsByWorkFlowCheck(OaWorkFlowCheck workFlowCheck){
	   int type =  workFlowCheck.getWorkFlowTypeId().intValue();
	   Set eventIds = new HashSet();
	   switch (type) {
		case 1:
			eventIds = workFlowCheck.getContracts();
			break;
		case 2:
			eventIds = workFlowCheck.getOrders();
			break;	
		default:
			eventIds = workFlowCheck.getApplys();
			break;
	   }  
	   
	   return eventIds;
   }

public List getOaWorkFlowChecksByContractId(String id) {
//	System.out.println("id==========++++++========" + id);
	return dao.getOaWorkFlowChecks(new Long(id));
}

public List getOaWorkFlowChecksByOrderId(String id) {
//	System.out.println("id==========++++++========" + id);
	return dao.getOaWorkFlowChecksByOrderId(new Long(id));
}

public long getOrderCheckLastTime(String id) {
	Date d = (Date)dao.getOrderCheckLastTime(new Long(id));
	System.out.println("getOrderCheckLastTime========7777777777777777777777  bbbbbbbbb   999==++++++========" + d.getTime());
	
	return d.getTime();
}

   
//   private void deleteAllCheckResult(Set ids){
//	   Map mp = new HashMap();
//	   mp.put("OaWorkFlowCheckIdList",ids); 
//	   dao.removeOaWorkFlowChecks(mp);
//   }

}
