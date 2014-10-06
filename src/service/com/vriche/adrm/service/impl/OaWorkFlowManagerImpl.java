package com.vriche.adrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.dao.OaWorkFlowDao;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.model.Contract;
import com.vriche.adrm.model.OaWorkFlow;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.OaWorkFlowManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.ConvertUtil;

public class OaWorkFlowManagerImpl extends BaseManager implements OaWorkFlowManager {
	private OaWorkFlowDao dao;
	private ContractDao contractDao;
	private OrderDao orderDao;
	private CarrierManager carrierManager;

	public void setOaWorkFlowDao(OaWorkFlowDao dao) {
		this.dao = dao;
	}
	public void setContractDao(ContractDao contractDao) {
		this.contractDao = contractDao;
	}	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	/**
	 * @param carrierManager The carrierManager to set.
	 */
	public void setCarrierManager(CarrierManager carrierManager) {
		this.carrierManager = carrierManager;
	}

	

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlows(com.vriche.adrm.model.OaWorkFlow)
	 */
	public List getOaWorkFlows(final OaWorkFlow oaWorkFlow) {
		
		return dao.getOaWorkFlows(oaWorkFlow);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlowsMap(com.vriche.adrm.model.OaWorkFlow)
	 */
	public Map getOaWorkFlowsMap(OaWorkFlow oaWorkFlow) {
		Map mp = dao.getOaWorkFlowsMap(oaWorkFlow);
		mp.put("0", "");
		return mp;
	}

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlowsCount(com.vriche.adrm.model.OaWorkFlow)
	 */
	public String getOaWorkFlowsCount(final OaWorkFlow oaWorkFlow) {
		return dao.getOaWorkFlowsCount(oaWorkFlow).toString();
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlowsView(com.vriche.adrm.model.OaWorkFlow)
	 */
	public String getOaWorkFlowsView(OaWorkFlow oaWorkFlow) {
		StringBuffer sb = new StringBuffer("");

		List ls = this.getOaWorkFlows(oaWorkFlow);
		Iterator it = ls.iterator();

		sb.append("<table width=\"100%\" cellSpacing=0 cellPadding=0 ><tr>");

		while (it.hasNext()) {
			sb.append("<td valign=\"top\">");
			OaWorkFlow workFlow = (OaWorkFlow) it.next();
			this.getOaWorkFlowsByParent(workFlow, sb);
			sb.append("</td>");
		}

		sb.append("</tr></table>");

		return sb.toString();
	}

	public void getOaWorkFlowsByParent(OaWorkFlow workFlow, StringBuffer sb) {

		sb.append("<table width=\"100%\" border=\"1\" cellSpacing=0 cellPadding=0 >");

		//first row 
		sb.append("<tr>");
		if (workFlow.getIsFirstPoint().booleanValue()) {
			sb.append(" <td>入口</td>");
		} else {
			sb.append(" <td>非入口</td>");
		}
		sb.append("<td>");
		sb.append("<a href='javascript:void 0' onclick='getWorkFlow("
				+ workFlow.getId() + ")'>" + workFlow.getName() + "</a>");
		sb.append("</td>");

		if (workFlow.getIsFirstPoint().booleanValue()) {
			sb.append("<td>&nbsp</td>");
		} else {
			sb.append("<td><a href='javascript:void 0' onclick='addIncomeWorkFlow("
							+ workFlow.getParentId() + ")'>增加同级</a></td>");
		}

		sb.append("</tr>");

		//second row 
		sb.append("<tr>");

		if (workFlow.getDissentFlowId().intValue() != 0) {
			sb.append(" <td>不同意" + workFlow.getDissentFlowId().toString()
					+ "</td>");
		} else {
			sb.append(" <td>&nbsp;</td>");
		}
		sb.append(" <td>&nbsp;</td>");
		sb.append("<td><a href='javascript:void 0' onclick='addIncomeWorkFlow("
				+ workFlow.getId() + ")'>增加子级</a></td>");
		sb.append("</tr>");

		//////////////////////////////////////////////////////
		OaWorkFlow workFlowP = new OaWorkFlow();
		workFlowP.setParentId(workFlow.getId().toString());
		List ls = this.getOaWorkFlows(workFlowP);
		int size = ls.size();
		if (size > 0) {
			//third row 
			sb.append("<tr>");
			sb.append("<td colspan=\"3\" align=\"center\" bgcolor='#FFFFFF'>↓<br>同意</td>");
			sb.append("</tr>");

			sb.append("<tr>");
			sb.append("<td colspan=\"3\" align=\"center\" valign=\"top\"> ");
			sb.append("<table width=\"100%\" cellSpacing=0 cellPadding=0 ><tr>");
		} else {
			//third row 
			sb.append("<tr>");
			sb.append("<td colspan=\"3\" align=\"center\" bgcolor='#FFFFFF'>↓<br>终止 </td>");
			sb.append("</tr>");

		}
		Iterator it = ls.iterator();

		while (it.hasNext()) {
			sb.append("<td valign=\"top\">");
			OaWorkFlow workFlowD = (OaWorkFlow) it.next();
			this.getOaWorkFlowsByParent(workFlowD, sb);
			sb.append("</td>");
		}

		if (size > 0) {
			sb.append("</tr></table>");
			sb.append("</td>");
			sb.append("</tr>");
		}
		///////////////////////////////////////////////////////

		sb.append("</table>");

	}

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlowsCount(com.vriche.adrm.model.OaWorkFlow)
	 */
	public PaginatedList getOaWorkFlowsPage(final OaWorkFlow oaWorkFlow,
			String pageIndex, String pageSize) {
		return dao.getOaWorkFlowsPage(oaWorkFlow, Integer.parseInt(pageIndex),
				Integer.parseInt(pageSize));
	}

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlow(String id)
	 */
	public OaWorkFlow getOaWorkFlow(final String id) {

		OaWorkFlow oaWorkFlow = dao.getOaWorkFlow(new Long(id));
		//被审用户
		List lsIn = dao.getIncomeUsers(new Long(id));
		//审核人
		List lsCh = dao.getCheckUsers(new Long(id));

		Set cominUsers = ConvertUtil.convertIdsFromListToArray(lsIn);
		Set checkUsers = ConvertUtil.convertIdsFromListToArray(lsCh);

		oaWorkFlow.setCominUsers(cominUsers);
		oaWorkFlow.setCheckUsers(checkUsers);

		return oaWorkFlow;
	}

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlowsByIdList(final Map idList)
	 */
	public List getOaWorkFlowsByIdList(final Map idList) {
		return dao.getOaWorkFlowsByIdList(idList);
	}

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#saveOaWorkFlow(OaWorkFlow oaWorkFlow)
	 */
	public String saveOaWorkFlow(OaWorkFlow oaWorkFlow) {

		String id = dao.saveOaWorkFlow(oaWorkFlow).toString();

		//保存入口用户
		this.saveCominUsers(oaWorkFlow, id);
		//保存审核人员
		this.saveCheckUsers(oaWorkFlow, id);

		return id;
	}

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#removeOaWorkFlow(String id)
	 */
	public void removeOaWorkFlow(final String id) {
		Map ids = getOaWorkFlowIds(id);
		if (ids.size() > 0) {
			this.removeIncomeUsers(ids);
			this.removeCheckUsers(ids);
			this.removeOaWorkFlows(ids);
		}
		//        dao.removeOaWorkFlow(new Long(id));
	}

	/**
	 * @see com.vriche.adrm.service.OaWorkFlowManager#removeOaWorkFlows(String Map)
	 */
	public void removeOaWorkFlows(final Map idList) {
		dao.removeOaWorkFlows(idList);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getOaWorkFlowIds(java.lang.Long, java.util.List)
	 */
	public Map getOaWorkFlowIds(String id) {
		List idList = new ArrayList();
		Map mp = new HashMap();
		idList.add(id);
		getOaWorkFlowsIdsByParent(id, idList);
		if (idList.size() > 0) {
			mp.put("OaWorkFlowIdList", idList);
		}
		return mp;
	}

	private void getOaWorkFlowsIdsByParent(String id, List idList) {
		OaWorkFlow oaWorkFlow = new OaWorkFlow();
		oaWorkFlow.setParentId(id.toString());
		Iterator it = this.getOaWorkFlows(oaWorkFlow).iterator();
		while (it.hasNext()) {
			OaWorkFlow wflow = (OaWorkFlow) it.next();
			idList.add(wflow.getId());
			getOaWorkFlowsIdsByParent(wflow.getId().toString(), idList);
		}
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#removeCheckUsers(java.util.Map)
	 */
	public void removeCheckUsers(Map idList) {
		dao.removeCheckUsers(idList);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#removeIncomeUsers(java.util.Map)
	 */
	public void removeIncomeUsers(Map idList) {
		dao.removeIncomeUsers(idList);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#saveCheckUsers(com.vriche.adrm.model.OaWorkFlow, java.lang.Long)
	 */
	public void saveCheckUsers(OaWorkFlow oaWorkFlow, String id) {
		dao.saveCheckUsers(oaWorkFlow, new Long(id));
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#saveCominUsers(com.vriche.adrm.model.OaWorkFlow, java.lang.Long)
	 */
	public void saveCominUsers(OaWorkFlow oaWorkFlow, String id) {
		dao.saveCominUsers(oaWorkFlow, new Long(id));
	}

	
	
	/**
	 * @param workFlowTypeId 流程类别
	 * @param userId		 用户编号
	 * @return               与自己有关的所有流程
	 */
	public List getWorkFlowOwner(String workFlowTypeId, String userId){
//		log.info("workFlowTypeId>>>>>>>>>>>>>>"+ workFlowTypeId);
//		log.info("userId>>>>>>>>>>"+ userId);
		Map mp = new HashMap();
		mp.put("workFlowTypeId",workFlowTypeId);
		mp.put("userId",userId);	

		return dao.getOaWorkFlowsByUser(mp);
	}
	
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getWorkFlowOther(java.util.List)
	 */
	public List getWorkFlowOther(List ownerList){
		List flowsList = new ArrayList();
		for(Iterator it = ownerList.iterator();it.hasNext();){
			OaWorkFlow workFlow = (OaWorkFlow)it.next();
			Long workFlowId = workFlow.getId();

//			System.out.println("                 workFlowId    "+workFlowId);
			OaWorkFlow oaWorkFlow = new OaWorkFlow();
			oaWorkFlow.setAgreeFlowId(workFlowId);
			oaWorkFlow.setDissentFlowId(workFlowId);
			List ls = dao.getWorkFlowsOther(oaWorkFlow);
//			log.info("ls >>>>>AAA>>>>>"+ ls.size());
			CollectionUtils.addAll(flowsList,ls.iterator());
//			log.info("fs >>>>>AAA>>>>>"+ flowsList.size());
	
		}
		return flowsList;
	}
	
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getEventsByWorkFlows(java.lang.String, java.util.List, java.util.List, int, int)
	 */
public void getEventsByWorkFlows(String ownerWorkFlowId,List eventIdsList,List workFlowList,int state,int type,Long userId,String orderCode,String year,String carrierId,String customerName){
        
		OaWorkFlow ownerWorkFlow = dao.getOaWorkFlow(new Long(ownerWorkFlowId));
		
		long ownerAgreeFlowId = ownerWorkFlow.getAgreeFlowId().longValue();
		long ownerDissentFlowId = ownerWorkFlow.getDissentFlowId().longValue();
		boolean ownerIsFirstPoint = ownerWorkFlow.getIsFirstPoint().booleanValue();
		boolean ownerIsEndPoint = ownerWorkFlow.getIsEndPoint().booleanValue();

//	    SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
//	    String fzMode = sysParam.getFzwsWithoutSubmit();
		//通过   
		if(state == 3){   
			if(!ownerIsFirstPoint){
				OaWorkFlow wf = new OaWorkFlow();
				wf.setWorkFlowTypeId(ownerWorkFlow.getWorkFlowTypeId());
				wf.setIsFirstPoint(Boolean.valueOf(true));
				OaWorkFlow firstPointWorkFlow = dao.getOaWorkFlow(wf);	
				getCheckEvensFromSource(eventIdsList,firstPointWorkFlow,String.valueOf(3),userId,orderCode,year,carrierId,customerName);	 
			}else{
				getCheckEvensFromSource(eventIdsList,ownerWorkFlow,String.valueOf(3),userId,orderCode,year,carrierId,customerName);	
			}
//			printLit(eventIdsList,"before 3>>>>>>>>>>>");
		}		
		
		
		//未审
		if(state == 1){
			if (ownerIsFirstPoint){
//				log.info("UUUUUUUUUUUUUUU STEP4>>>");
				getCheckEvensFromSource(eventIdsList,ownerWorkFlow,String.valueOf(state),userId,orderCode,year,carrierId,customerName);
//				log.info("UUUUUUUUUUUUUUU STEP5>>>" + eventIdsList.size());
//				printLit(eventIdsList,"before 1>>>>>>");
//				log.info("UUUUUUUUUUUUUUU STEP6>>>");
				//排除被自己已经同意
				obviateCheckEvens(eventIdsList,ownerWorkFlow,3,0);
				obviateCheckEvens(eventIdsList,ownerWorkFlow,4,0);
//				log.info("UUUUUUUUUUUUUUU STEP7>>>");
			}				
		}
	
//		System.out.println("eventIdsList,.size==========="+eventIdsList.size()); 
		for(Iterator it = workFlowList.iterator();it.hasNext();){
			
			OaWorkFlow workFlow = (OaWorkFlow)it.next();
			
			boolean isFirstPoint = workFlow.getIsFirstPoint().booleanValue();
			boolean isEndPoint = workFlow.getIsEndPoint().booleanValue();
			int workFlowType = workFlow.getWorkFlowTypeId().intValue();
			long workFlowId = workFlow.getId().longValue();
			long agreeFlowId = workFlow.getAgreeFlowId().longValue();
			long dissentFlowId = workFlow.getDissentFlowId().longValue();

			//是入口需要从数据来源查找，否则从结果中查找
			// 1 未审批 2 审核中 3 通过 4 被退回
			if(state == 1){
//				log.info("UUUUUUUUUUUUUUU STEP8>>>");
				//是入口点 查找数据源 审批状态为 = 1 
				if (ownerIsFirstPoint && dissentFlowId == new Long(ownerWorkFlowId).longValue()){
					
//					log.info("UUUUUUUUUUUUUUU STEP9>>>");
						//排除被别人退回
						obviateCheckEvens(eventIdsList,workFlow,4,0);
//						printLit(eventIdsList,"after 11>>>>>>>>>>");
				}else{
//					log.info("workFlowId++++++++++" + workFlowId);
//					log.info("ownerWorkFlowId++++++++++" + ownerWorkFlowId);
//					log.info("dissentFlowId++++++++++" + agreeFlowId);
//                  log.info("++++++++++" + (agreeFlowId ==  new Long(ownerWorkFlowId).longValue()));
					
//					log.info("UUUUUUUUUUUUUUU STEP10>>>");
					
					if(!ownerIsFirstPoint && (agreeFlowId ==  new Long(ownerWorkFlowId).longValue() || dissentFlowId == new Long(ownerWorkFlowId).longValue())){
//						log.info("UUUUUUUUUUUUUUU STEP11>>>");
						//获得别人同意或同意过
						getCheckEvensFromtResult(eventIdsList,workFlow,3,0);
//						printLit(eventIdsList,"before 111>>>>>>");
						//排除被自己已经同意
						obviateCheckEvens(eventIdsList,ownerWorkFlow,3,0);
						//排除被别人自己退回
						obviateCheckEvens(eventIdsList,workFlow,4,0);
//						printLit(eventIdsList,"after 111>>>>>>>>>>");
						
//						log.info("UUUUUUUUUUUUUUU STEP12>>>");
					}
				}
				
			}
			
			if(state == 3){
				if(dissentFlowId == new Long(ownerWorkFlowId).longValue()){
					//自己同意流转编号 等于 别人流程编号   或 自己是终止点
//					System.out.println("ownerIsEndPoint" + ownerIsEndPoint);
					//排除被别人退回
					obviateCheckEvens(eventIdsList,workFlow,4,0);					
				}
			}			
			
			if(state == 4){
				//别人不同意 
				if(dissentFlowId == new Long(ownerWorkFlowId).longValue() ){
						getCheckEvensFromtResult(eventIdsList,workFlow,4,0);
//						printLit(eventIdsList,"before >>>>>>>>>>>");
						//排除别人已经同意
						obviateCheckEvens(eventIdsList,workFlow,3,0);
						//排除被自己已经同意
						obviateCheckEvens(eventIdsList,ownerWorkFlow,3,0);
						obviateCheckEvens(eventIdsList,ownerWorkFlow,4,0);
//						printLit(eventIdsList,"after >>>>>>>>>>");
				}

			}				
			

		}
		
	}
	
//	private void obviateCheckEvenState(List eventIdsList,OaWorkFlow workFlow, int obviateState,int condition){
//		List checkedIds = new ArrayList();
//		getCheckEvensFromtResultState(checkedIds,workFlow,obviateState,condition);
//		System.out.println("checkedIdState >>>>>>  "+checkedIds.size());
//		for(Iterator it = checkedIds.iterator();it.hasNext();){
//			int i = eventIdsList.indexOf(it.next());
//			if( i > -1) eventIdsList.remove(i);
//			
//		}		
//	}
//	private void getCheckEvensFromtResultState (List eventIdsList,OaWorkFlow oaWorkFlow,int state,int checked){
//		int type = oaWorkFlow.getWorkFlowTypeId().intValue();
//		Long workFlowId = oaWorkFlow.getId();
//		System.out.println(">>>ccccc>>   "+state+"  x2x  "+workFlowId);
//		CollectionUtils.addAll(eventIdsList,getContractsByWorkFlowIdState(type,workFlowId,state,checked));
//
//	}
//	
//	private Object[]  getContractsByWorkFlowIdState(int type,Long workFlowId,int state,int checked){
//		Map mp = new HashMap();
//		Object[] obj = null;
//
//		mp.put("workFlowId",workFlowId);
//		mp.put("state",String.valueOf(state));
//		mp.put("checked",String.valueOf(checked));
////		mp.put("UserIdList",userIdList);
////		System.out.println(">>>>>>>   "+workFlowId+"  DDD  "+state+"  CCC  "+checked);
//		if(type == 1){
//			obj = ConvertUtil.getColFromList(contractDao.getContractIdsByWorkFlowId(mp),"id");			
//		}
//		if(type == 2){
//			obj = ConvertUtil.getColFromList(orderDao.getOrderIdsByState4(mp),"id");			
//		}
//		if(type == 3){
//			obj = ConvertUtil.getColFromList(contractDao.getContractIdsByWorkFlowId(mp),"id");			
//		}
//		
////		System.out.println("obj.length>>>>>><<<<<<<" + obj.length);
////        for (int i = 0;i<obj.length;i++){
////        	log.info("Object>>>rtttttttt>>>" + (String)obj[i]);
////        }
//		
//		return obj;
//	}
//	
	private void obviateCheckEvens(List eventIdsList,OaWorkFlow workFlow, int obviateState,int condition){
		List checkedIds = new ArrayList();
		getCheckEvensFromtResult(checkedIds,workFlow,obviateState,condition);
//		System.out.println("checkedIds  >>>>>>  "+checkedIds.size());
		for(Iterator it = checkedIds.iterator();it.hasNext();){
			int i = eventIdsList.indexOf(it.next());
			if( i > -1) eventIdsList.remove(i);
			
		}		
	}
	
	private void getCheckEvensFromSource(List eventIdsList,OaWorkFlow oaWorkFlow,String state,Long userId,String orderCode,String year,String carrierId,String customerName){
		int type = oaWorkFlow.getWorkFlowTypeId().intValue();

		Map mp = new HashMap();
		List resIdList = new ArrayList();

		Long workFlowId = oaWorkFlow.getId();
		List userIdList = dao.getIncomeUsers(workFlowId);
//		for(Iterator it = userIdList.iterator();it.hasNext();){
//			Integer i = (Integer)it.next();
//			System.out.println("userIdList   "+i);
//		}
        
		if(userIdList.size() == 0) state ="";
		
//		if(carrierId !=null){
//			if(!carrierId.equals("") && !carrierId.equals("null"))
//			resIdList = carrierManager.getOneCarrResourceiDListByCarrierId(new Long(carrierId),false,year);
//			if(resIdList.size() == 0) resIdList.add(new String("-1"));
//		}
		
		
		mp.put("UserIdList",userIdList);
		mp.put("stateId",state);	
		mp.put("userId",userId);	
		mp.put("orderCode",orderCode);	
		mp.put("version",year);
		mp.put("customerName",customerName);
		
//		if(carrierId != null){
//			mp.put("resourceIdList",resIdList);
//		}
//		if(carrierId != null && !"null".equals(carrierId)){
			carrierId = (carrierId ==null) || "".equals(carrierId) || "null".equals(carrierId)?"0":carrierId;
			List carrierIdList = CarrierUtil.getCarrierIds(carrierId,"2",null);
			mp.put("carrierIdList",carrierIdList);
//		}
		
		

//		System.out.println("orList,.size==========="+userIdList.size()+"!>>>"+resIdList.size()+"==="+userId);
		          
//		System.out.println("stateId   "+state);
//		Object[] obj = ConvertUtil.getColFromList(getSourceByUsers(type,mp),"id");
//		
//        for (int i = 0;i<obj.length;i++){
//        	log.info("Object>>>rtttttttt>>>" + (String)obj[0]);
//        }
		
		List ls = getSourceByUsers(type,mp);

		CollectionUtils.addAll(eventIdsList,ls.iterator());
		
//		printLit(eventIdsList,"before tttttttttt>>>>>>");
	}
	
	private List getSourceByUsers(int type,Map mp){
		List ls = new ArrayList();
		if(type == 1) ls = contractDao.getContractsByUsers(mp);
		if(type == 2) ls = orderDao.getOrdersByUsers(mp);
//		System.out.println("orderList,.size==========="+ls.size());
//		if(type == 3) ls = contractDao.getContractsByUsers(mp);
		
//		log.info("getOrdersByUsers>>>rtttttttt>>>" + ls.size());
		return ls;
	}
	
	private void getCheckEvensFromtResult (List eventIdsList,OaWorkFlow oaWorkFlow,int state,int checked){
		int type = oaWorkFlow.getWorkFlowTypeId().intValue();
		Long workFlowId = oaWorkFlow.getId();
//		System.out.println(">>>OBJ>>   "+type+"  2  "+workFlowId);
		CollectionUtils.addAll(eventIdsList,getContractsByWorkFlowId(type,workFlowId,state,checked).iterator());

	}
	
//	private void getCheckEvensFromtResult (List eventIdsList,List oaWorkFlows,int state,int checked){
//		for(Iterator it = oaWorkFlows.iterator();it.hasNext();){
//			OaWorkFlow ownerWorkFlow = (OaWorkFlow)it.next();
//			this.getCheckEvensFromtResult(eventIdsList,ownerWorkFlow,state,checked);
//		}
//	}
	
	private List  getContractsByWorkFlowId(int type,Long workFlowId,int state,int checked){
		Map mp = new HashMap();
//		Object[] obj = null;
		List ls = new ArrayList();

		mp.put("workFlowId",workFlowId);
		mp.put("state",String.valueOf(state));
		mp.put("checked",String.valueOf(checked));
//		mp.put("UserIdList",userIdList);
//		System.out.println(">>>>>>>   "+workFlowId+"  DDD  "+state+"  CCC  "+checked);
		if(type == 1){
//			obj = ConvertUtil.getColFromList(contractDao.getContractIdsByWorkFlowId(mp),"id");	
			ls = contractDao.getContractIdsByWorkFlowId(mp);	
		}
		if(type == 2){
//			obj = ConvertUtil.getColFromList(orderDao.getOrderIdsByWorkFlowId(mp),"id");	
			ls = orderDao.getOrderIdsByWorkFlowId(mp);		
		}
//		if(type == 3){
//			obj = ConvertUtil.getColFromList(contractDao.getContractIdsByWorkFlowId(mp),"id");			
//		}
		
//		System.out.println("obj.length>>>>>><<<<<<<" + obj.length);
//        for (int i = 0;i<obj.length;i++){
//        	log.info("Object>>>rtttttttt>>>" + (String)obj[i]);
//        }
		
		return ls;
	}

	private boolean isFirstPoint(OaWorkFlow  workFlow){
		 if(workFlow.getIsFirstPoint().booleanValue()) {
			 return true;
		 }else{
			 return false;
		 }
	 }
	
	public Map getWorkFlowSelectByUser(String workFlowTypeId,String userId){

//		String userId = userManager.getCurrentUser().getId().toString();
		List ls = this.getWorkFlowOwner(workFlowTypeId,userId);
		
	       Map reply = new LinkedHashMap();
	       Iterator it = ls.iterator();

	       while (it.hasNext()){
	    	   OaWorkFlow  workFlow = new OaWorkFlow();
	    	   workFlow = (OaWorkFlow)it.next();
	    	   if(userId == null) reply.put("0","");
	           reply.put(workFlow.getId(),workFlow.getName());
	       }
	       return reply;
	}

	public List getWorkFlows(String agreeFlowId, String dissentFlowId) {
		OaWorkFlow workFlow = new OaWorkFlow();
		workFlow.setAgreeFlowId(new Long(agreeFlowId));
		workFlow.setDissentFlowId(new Long(dissentFlowId));
		return dao.getOaWorkFlows(workFlow);
	}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.OaWorkFlowManager#getWorkFlowOther(java.lang.String, java.lang.String)
	 */
	public List getWorkFlowOther(String agreeFlowId, String dissentFlowId) {
		return dao.getWorkFlowsOther(new Long(agreeFlowId),new Long(dissentFlowId));
	}
	
	private void printLit(List ls,String name){
		for(Iterator it = ls.iterator();it.hasNext();){
//			System.out.println("<<<<<<<<" + name +">>>>>>" + (String)it.next());
		}
		
	}
	
	
	
	public Map getWorkFlowSelects(OaWorkFlow  workFlow){

//		String userId = userManager.getCurrentUser().getId().toString();
		List ls = this.getOaWorkFlows(workFlow);
		
	   Map reply = new LinkedHashMap();
	   Iterator it = ls.iterator();
	   reply.put("0","");
	   while (it.hasNext()){
	    	   workFlow = (OaWorkFlow)it.next();
	           reply.put(workFlow.getId(),workFlow.getName());
	   }
	   return reply;
	}

	
}
