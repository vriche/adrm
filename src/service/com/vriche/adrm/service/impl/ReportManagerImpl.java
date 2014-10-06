package com.vriche.adrm.service.impl;

import java.util.Collection;
import java.util.Map;

import com.vriche.adrm.service.AnalyseSumManager;
import com.vriche.adrm.service.ContractManager;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.FinanceTargetManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.IncomePullManager;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.ReportManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;

public class ReportManagerImpl implements ReportManager {
	private ContractPaymentManager contractPaymentManager;
	private OrderManager orderManager;
	private OrderDayInfoManager orderDayInfoManager;
	private IncomePullManager incomePullManager;
	private FinanceTargetManager financeTargetManager;
	private ContractManager contractManager;
	private OrderDetailManager orderDetailManager;
	private AnalyseSumManager analyseSumManager;
	private ResourceManager resourceManager;
	
	
	
	
public void setOrderDetailManager(OrderDetailManager orderDetailManager) {
		this.orderDetailManager = orderDetailManager;
	}

	//	private FusionChartsManager fusionChartsManager;
	public void setIncomePullManager(IncomePullManager incomePullManager) {
		this.incomePullManager = incomePullManager;
	}

	public void setFinanceTargetManager(FinanceTargetManager financeTargetManager) {
		this.financeTargetManager = financeTargetManager;
	}
	
	public void setContractPaymentManager(ContractPaymentManager contractPaymentManager) {
		this.contractPaymentManager = contractPaymentManager;
	}
	/**
	 * @param orderManager The orderManager to set.
	 */
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	/**
	 * @param orderDayInfoManager The orderDayInfoManager to set.
	 */
	public void setOrderDayInfoManager(OrderDayInfoManager orderDayInfoManager) {
		this.orderDayInfoManager = orderDayInfoManager;
	}
//	public void setFusionChartsManager(FusionChartsManager fusionChartsManager) {
//		this.fusionChartsManager = fusionChartsManager;
//	}
	public void setContractManager(ContractManager contractManager) {
		this.contractManager = contractManager;
	}
	
	public void setAnalyseSumManager(AnalyseSumManager analyseSumManager) {
		this.analyseSumManager = analyseSumManager;
	}
	
	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
	
	

	public Collection getCollectionByType(String queryString,Map searchMap, Map parameters)throws Exception{
		
		Collection coll = null;

		String type = (String)searchMap.get("reportType");

        if(type.endsWith("cuikuan_report")){
    		coll = contractPaymentManager.getCollections(searchMap);
        }
        
        
        if(type.endsWith("destop_income_report")){
    		coll = incomePullManager.getIncomesPullsCollections(searchMap);
        }
             
        
        
        
        if(type.endsWith("specificQuery_report")){
        	
    		coll = orderManager.getCollections(searchMap,"report");
        }
        
        if(type.endsWith("customerAnalyze")){
        	
    		coll = orderDayInfoManager.getCollections(searchMap,"report");
        }
        
        
        if(type.endsWith("orderList")){
        	
    		coll = orderManager.getCollectionsOrderList(queryString,"report");
        }
        
        
        
        if(type.endsWith("queryAdres2")){
        	
    		coll = resourceManager.getCollectionsForQuery(queryString,"report",parameters);
        }
        
        if(type.endsWith("arrearsList")){
        	
    		coll = financeTargetManager.getArrearsColl(queryString,"report");
        }
        
        
        if(type.endsWith("contractListTable")){
        	
    		coll = contractManager.getCollectionsList(queryString,"report");
        }
        
//   if(type.endsWith("orderDetail_report")){
//        	
//    		coll = orderDetailManager.getCollectionsBroReport(queryString,"report");
//        }    
        
    if(type.endsWith("branch_sum_report")){
        	
    		coll = analyseSumManager.getCollections(queryString,"report");
        }      
              
   if(type.endsWith("income_new_report1")){
	     IncomeManager  incomeManager = ServiceLocator.getIncomeManager();
     	 Map map = incomeManager.buildsearchMap(queryString);
     	 coll = incomeManager.getCollections(map,"report",0,-1);
        }       
   
   if(type.endsWith("income_new_report2")){
	     IncomeManager  incomeManager = ServiceLocator.getIncomeManager();
	     Map map = incomeManager.buildsearchMap(queryString);
	     coll = incomeManager.getCollectionsBalanceParaSort(queryString);
      }       
   
   
  if(type.endsWith("resource_report")){
	  
		ResourceManager mgr =ServiceLocator.getResourceManager();
		coll = mgr.getCollections(queryString,"report");

		
   }
   
	  if(type.endsWith("adresourceSum")){

			coll = orderDayInfoManager.getTreeGridSumCollection(queryString);
	
	 }      
	  
	  if(type.endsWith("adIncomeRelpayQiank_report")){ 

			coll = financeTargetManager.getIncomeRelpayQiank(queryString);
	
	 }  	  
	  
	 if(type.endsWith("bro_report_hbtv")){ 

		 coll = orderDetailManager.getCollectionsBroReport(queryString,"report");
	
	  }  	
		return coll;
	}



	





}
