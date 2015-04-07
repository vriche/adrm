package com.vriche.adrm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;

import com.ibatis.common.resources.Resources;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.BranchDao;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.dao.CategoryDao;
import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.dao.IncomeModeDao;
import com.vriche.adrm.dao.IncomePurposeDao;
import com.vriche.adrm.dao.IndustryDao;
import com.vriche.adrm.dao.LookupDao;
import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.dao.OaWorkFlowCheckStateDao;
import com.vriche.adrm.dao.OrderCategoryDao;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.dao.PriceTypeDao;
import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.dao.ResourceSortDao;
import com.vriche.adrm.dao.SpecificDao;
import com.vriche.adrm.dao.SysParamDao;
import com.vriche.adrm.dao.UpdateSystemDao;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.IncomeMode;
import com.vriche.adrm.model.IncomePurpose;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.LabelValue;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.model.PriceType;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.model.Role;
import com.vriche.adrm.model.Specific;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.LookupManager;
import com.vriche.adrm.service.RoleManager;
import com.vriche.adrm.util.ConvertUtil;
import com.vriche.adrm.util.GetFirstLetter;
import com.vriche.adrm.util.OrderCateFitterUtil;
import com.vriche.adrm.util.ScriptRunner;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;




/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 *
 * <p><a href="LookupManagerImpl.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class LookupManagerImpl extends BaseManager implements LookupManager {
    //~ Instance fields ========================================================

	
    private LookupDao dao;
    
    private OrgDao orgDao;
    
    private SysParamDao sysParamDao;
    
    private UserDao userDao;
    
    private CarrierDao carrierDao;
    
    private ResourceDao resourceDao;
    
    private OrderCategoryDao orderCategoryDao;

    private IndustryDao industryDao;

    private ResourceSortDao resourceSortDao;
    
    private SpecificDao specificDao;
    
    private PriceTypeDao priceTypeDao;
    
    private MatterDao matterDao;
    
    private PriceDetailDao priceDetailDao;
    
    private BranchDao branchDao;
    
    private  OaWorkFlowCheckStateDao oaWorkFlowCheckStateDao ;
    
	private UpdateSystemDao updateSystemDao;
    //~ Methods ================================================================
	private CarrierTypeDao carrierTypeDao;
	
	
	
	
	
    private IncomeModeDao incomeModeDao;
    
    private IncomePurposeDao incomePurposeDao;
    
    private CategoryDao categoryDao;
    
    private CustomerDao customerDao;
    
    
    
    
    
    
    public void setIndustryDao(IndustryDao industryDao) {
		this.industryDao = industryDao;
	}

	public void setCarrierDao(CarrierDao carrierDao) {
		this.carrierDao = carrierDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	public void setSpecificDao(SpecificDao specificDao) {
		this.specificDao = specificDao;
	}


	public void setBranchDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}

	public void setLookupDao(LookupDao dao) {
        super.dao = dao;
        this.dao = dao;
    }
    
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}
	public void setSysParamDao(SysParamDao sysParamDao) {
		this.sysParamDao = sysParamDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setMatterDao(MatterDao matterDao) {
		this.matterDao = matterDao;
	}
    /**
     * @see com.vriche.adrm.order.service.LookupManager#getAllRoles()
     */
	
	public void setOrderCategoryDao(OrderCategoryDao orderCategoryDao) {
		this.orderCategoryDao = orderCategoryDao;
	}
	
	public void setResourceSortDao(ResourceSortDao resourceSortDao) {
		this.resourceSortDao = resourceSortDao;
	}

	public void setPriceTypeDao(PriceTypeDao priceTypeDao) {
		this.priceTypeDao = priceTypeDao;
	}


	public void setPriceDetailDao(PriceDetailDao priceDetailDao) {
		this.priceDetailDao = priceDetailDao;
	}
	
	public void setOaWorkFlowCheckStateDao(OaWorkFlowCheckStateDao oaWorkFlowCheckStateDao) {
		this.oaWorkFlowCheckStateDao = oaWorkFlowCheckStateDao;
	}

	public void setUpdateSystemDao(UpdateSystemDao updateSystemDao) {
		this.updateSystemDao = updateSystemDao;
	}


	public void setCarrierTypeDao(CarrierTypeDao carrierTypeDao) {
		this.carrierTypeDao = carrierTypeDao;
	}


	public void setIncomeModeDao(IncomeModeDao incomeModeDao) {
		this.incomeModeDao = incomeModeDao;
	}

	public void setIncomePurposeDao(IncomePurposeDao incomePurposeDao) {
		this.incomePurposeDao = incomePurposeDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	

	
	
    public List getAllRoles() {
        List roles = dao.getRoles();
        List list = new ArrayList();
        Role role = null;

        for (int i = 0; i < roles.size(); i++) {
            role = (Role) roles.get(i);
            list.add(new LabelValue(role.getLable(), role.getName()));
        }

        return list;
    }
    
    public Map getBranchMapById() {
        List branchs = dao.getBranchs();
        
        Iterator it = branchs.iterator();
        Map mp = new HashMap();
        while(it.hasNext()){
        	List Idlist = new ArrayList();
        	Branch branch = (Branch)it.next();
        	Idlist.add(branch.getId());
        	getBranchByParnetId(branch.getId(),Idlist);
        	mp.put(branch.getId(),Idlist);
        }
//        System.out.println(">>>   "+mp.size());
        return mp;
	}
    
		

private void getBranchByParnetId(Long branchId,List BranchParentList){
	Branch branch = new Branch();
	branch.setParentId(branchId.toString());
		List ls = branchDao.getBranchs(branch);
		Iterator it = ls.iterator();
		while(it.hasNext()){
			Branch BranchRes = (Branch)it.next();
			BranchParentList.add(BranchRes.getId());
			getBranchByParnetId(BranchRes.getId(),BranchParentList);
		}
		
}
	/* (non-Javadoc)
	 * @see com.vriche.adrm.order.service.LookupManager#getBranchs()
	 */
	public Object[] getBranchs() {
		Object[] objs= new Object[2];
        List branchs = dao.getBranchs();
        List list = new ArrayList();
        Map mp  = new HashMap();
        Branch branch = null;

        for (int i = 0; i < branchs.size(); i++) {
        	branch = (Branch) branchs.get(i);
        	mp.put(branch.getId().toString(),branch.getName());
            list.add(new LabelValue(branch.getName(), branch.getName()));
        }
        objs[0] = list;
        objs[1] = mp;
        return objs;
	}
	public Org getOrg() {
		Org org = orgDao.getOrg(new Long(1));
        return org;
	}
	
	
	
	public Map getCustomerRel() {
		Map mp = new HashMap();
		List  ls = customerDao.getCustomers(new Customer());
		for(Iterator it = ls.iterator();it.hasNext();){
			Customer cut =(Customer)it.next();
			mp.put(cut.getId().toString(),cut.getParentId());
		}
		return mp;
	}

	
	

	public SysParam getSysParams() {

		SysParam param = new SysParam();
		
		List ls = sysParamDao.getSysParams(new SysParam());
		
//		System.out.println(">>>>>>>>>>>>>>>>>>" +ls.size());
		
		for(Iterator it = ls.iterator();it.hasNext();){
			SysParam sysParam =(SysParam)it.next();
			
			if(sysParam.getName().equals(Constants.ORDER_VIEW_MODEL_PARAM)){
				param.setOrderViewModelParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.CONTRACT_SORT_PARAM)){
				param.setContractSortParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.CHANNEL_MODEL_PARAM)){
				param.setChannelModelParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.PUBLISH_MODEL_PARAM)){
				param.setPiblishModelParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.PUBLISH_EXPORT_MODEL_PARAM)){
				param.setPiblishExportModelParam(sysParam.getValue());
			}			
			if(sysParam.getName().equals(Constants.ADVER_CODE_MODEL_PARAM)){
				param.setAdverCodeModelParam(sysParam.getValue());
			}	
			if(sysParam.getName().equals(Constants.ORDER_CODE_MODEL_PARAM)){
				param.setOrderCodeModelParam(sysParam.getValue());
			}	
			if(sysParam.getName().equals(Constants.CSS_THEME)){
				param.setTheme(sysParam.getValue());
			}	
			if(sysParam.getName().equals(Constants.ORDER_CARRIER_TYPE_DISPLAY_PARAM)){
				param.setOrderCarrierTypeDisplayParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.CUSTOMER_OWNER_PARAM)){
				param.setCustomerOwnerParam(sysParam.getValue());
			}
//			if(sysParam.getName().equals(Constants.CUSTOMER_CARRIER_PARAM)){
//				param.setCustomerCarrierParam(sysParam.getValue());
//			}
			if(sysParam.getName().equals(Constants.ORDER_CONTRACT_PARAM)){
				param.setOrderContractParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.CARRIER_NODELEVEL_PARAM)){
				param.setCarrierNodeLevelParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.RESOURCE_DISPLAY_PARAM)){
				param.setResourceDisplayParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.DIAN_PIAN_PARAM)){
				param.setDianpianParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.STRIDE_POSITION_PARAM)){
				param.setStridePositionParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.ADD_CUSTOMER_IN_ORDER_PARAM)){
				param.setAddCustomerInOrderParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.SPEC_AROWMOVE_PARAM)){
				param.setSpecArowMoveParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.CHANNEL_PULL_PARAM)){
				param.setChannelPullParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.IS_DISPLAYNOADRES_PARAM)){
				param.setIsDisplayNoadResParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.MORE_CHANNEL_PARAM)){
				param.setMoreChannelParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.MORE_CHANNEL_NOPULL_PARAM)){
				param.setMoreChannelNoPullParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.RESOURCE_RELIMIT_PARAM)){
				param.setResourceReLimitParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.PERMIT_MOD_ADVER_PARAM)){
				param.setPermitModAdverParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.ORDER_MOD_CATEGORY_PARAM)){
				param.setOrderModCategoryParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_OPEN_ORDER_ORG_PARAM)){
				param.setIsOpenOrderOrgParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_DISPLAY_CHART_PARAM)){
				param.setIsDisplayChartParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_USER_CUSTOMER_REL_PARAM)){
				param.setIsUserCustomerRelParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.ARREARAGE_MODE)){
				param.setArrearageMode(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_ARRANGE_ORDER_OR_ENTRY)){
				param.setIsArrangeOrderOrEntry(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.FZTV_SPECIAL_PARAM)){
				param.setFztvSpecialParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.QZTV_SPECIAL_PARAM)){
				param.setQztvSpecialParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.INCOME_MESSAGE_ALERT_PARAM)){
				param.setIncomeMessageAlertParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.INCOME_CODE_MODEL_PARAM)){
				param.setSequenceIncomeAutoParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_SIGN_USER_BALANCE)){
				param.setIsSignUserBalance(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_USER_ORDER_YEAR_REL)){
				param.setIsUserOrderYearRel(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_USE_CARRIER_PROTY)){
				param.setIsUseCarrierProty(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.PUBLISH_ORDER_ALERT_STATES)){
				param.setPublishOrderAlertStates(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.IS_DISPLAY_STANDPRICE)){
				param.setIsDisplayStandPrice(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.SIGN_COMPAGES_PARAM)){
				param.setSignCompages(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.WITHOUT_SUBMIT)){
				param.setWithoutSubmit(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.TV_NAME_PARAM)){
				param.setTvNameParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.WITH_BROPROINT_PARAM)){
				param.setWithBroPoint(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.WITH_RESOURCE_SORT_PARAM)){
				param.setWithResourceSort(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.ORDER_CARRIER_LEVEL_PARAM)){
				param.setOrderCarrierLevelParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.ORDER_DETAIL_DISPLAY_PARAM)){
				param.setOrderDetailDisplayParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.USE_CARRIER_ALINAME_PARAM)){
				param.setUseCarrierAliname(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.USE_MORE_CARRIER_SORT_PARAM)){
				param.setUseMoreCarrierSortParam(sysParam.getValue());
			}
			
			if(sysParam.getName().equals(Constants.CUSTOMER_CATE_FITER_PARAM)){
				param.setCustomerCateFiter(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.INDUSTRY_LEVEL_PARAM)){
				param.setIndustryLevelParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.AUTO_RELATION_CODE_PARAM)){
				param.setAutoRelationCodeParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.AUTO_PRICE_TYPE_PARAM)){
				param.setAutoPriceTypeParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.USE_LANMU_SINGLE)){
				param.setUseLanmuSingleParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.ALLOW_MODIY_PASSED_ORDER)){
				param.setAllowModiyPassedOrderParam(sysParam.getValue());
			}
			if(sysParam.getName().equals(Constants.ORDER_PUBLISH_TEMPLE_PARAM)){
				param.setOrderPublishTempleParam(sysParam.getValue()); 
			}
			if(sysParam.getName().equals(Constants.ORDER_DISPLAY_RELATIONCEODE_PARAM)){
				param.setOrderDisplayRelcodeParam(sysParam.getValue()); 
			}
			
			if(sysParam.getName().equals(Constants.FINANCIA_AUDIT_PARAM)){
				param.setFinancialAuditParam(sysParam.getValue()); 
			}
			 
			if(sysParam.getName().equals(Constants.ORDER_DISPLAY_INCOME_PARAM)){
				param.setOrderDisplayIncomeParam(sysParam.getValue()); 
			}			
			
			
			if(sysParam.getName().equals(Constants.ONE_ORG_MORE_SUBORGS_PARAM)){
				param.setOneOrgMoreSuborgsParam(sysParam.getValue()); 
			}		
			
			
			if(sysParam.getName().equals(Constants.FINANCE_BALANCE_MODEL_PARAM)){
				param.setFinanceBalanceModelParam(sysParam.getValue()); 
			}		
			
			
			if(sysParam.getName().equals(Constants.FAST_SIGN_ORDER_PARAM)){
				param.setFastSignOrderParam(sysParam.getValue()); 
			}	
			
			if(sysParam.getName().equals(Constants.ORDER_CALCULATE_MODEL_PARAM)){
				param.setOrderCalculateModel(sysParam.getValue()); 
			}
			
			if(sysParam.getName().equals(Constants.DAYANG_BEIBO_ENADBLE_PARAM)){
				param.setDayangBeiboEnableParam(sysParam.getValue()); 
			}	
			
			if(sysParam.getName().equals(Constants.DAYANG_WEBSERVER_URL_MATTER)){
				param.setDayangWebServiceUrlMatterParam(sysParam.getValue()); 
			}	
			
			if(sysParam.getName().equals(Constants.DAYANG_WEBSERVER_URL_PROGRAM_LIST)){
				param.setDayangWebServiceUrlProLitstParam(sysParam.getValue()); 
			}	
			
			if(sysParam.getName().equals(Constants.DAYANG_WEBSERVER_URL_PROGRAM_LIST)){
				param.setDayangWebServiceUrlProLitstParam(sysParam.getValue()); 
			}
			
			if(sysParam.getName().equals(Constants.ADRM_SYS_YEAR_PROGRAM_LIST)){
				String v = sysParam.getValue();
//				param.setDayangWebServiceUrlProLitstParam(sysParam.getValue()); 
//				System.out.println("lookup 111111111        111         1111111111111111b     ****************8 999999999999  777777777777      >>>>>>>>>>>>>>>>>>" +v);
				v = v ==null|| "".equals(v)|| "0".equals(v)?"2006,2007,2008,2009,2010,2011,2012,2013,2014":v;
//				 System.out.println("lookup  ****************8 999999999999  777777777777      >>>>>>>>>>>>>>>>>>" +v);
				param.setAdrmSysYearProgramList(v); 
			}	
			
			if(sysParam.getName().equals(Constants.ORDER_BASE_PRICE_ENABLE_MODY_PARAM)){
				String v = sysParam.getValue();
//				 System.out.println("lookup  ****************8 999999999999  777777777777      >>>>>>>>>>>>>>>>>>" +v);
				v = v ==null|| "".equals(v)?"0":v;
				param.setOrderBasePriceEnableModyParam(v); 
			}	
			
			if(sysParam.getName().equals(Constants.ARRANGE_WITH_BRAND_PARAM)){
				String v = sysParam.getValue();
				v = v ==null|| "".equals(v)?"0":v;
				param.setArrangeWithBrandParam(v); 
			}	
			
		}
		return param;
		
	}

	public Map getUserRels(boolean isObjs) {
		Map mp = new HashMap();
		List ls = userDao.getUsers(null);
		Map userMap = getUsersMap(ls);

		for(Iterator it = ls.iterator();it.hasNext();){
			User user = (User)it.next();
			Long parentId = user.getId();
			String userName = user.getUsername();
		
			List list = userDao.getUserRelNoOrg(parentId);
			list.add(parentId);	
			
			if(isObjs){
				List lsObjs = getUserObjectList(userMap,list);
				mp.put(userName,lsObjs);
			}else{
				mp.put(userName,list);
			}
		}
		
		return mp;
	}
	
	
   private List getUserObjectList(Map usersMp,List ids){

	   List ls = new ArrayList();
		for(Iterator it = ids.iterator();it.hasNext();){
			Long userId = (Long)it.next();
			User user = (User)usersMp.get(userId);
			ls.add(user);
		}
	   return ls;
   }
   
   private Map getUsersMap(List allUser){
	   Map mp = new HashMap();
		for(Iterator it = allUser.iterator();it.hasNext();){
			User user = (User)it.next();
			mp.put(user.getId(),user);
		}
	   return mp;
   }

public Map getResourceMap() {
	// TODO Auto-generated method stub
	Carrier carrier = new Carrier();
	Map mp = new HashMap();
	
	List ls = carrierDao.getCarriers(carrier);

	Iterator it = ls.iterator();
	while(it.hasNext()){
		Carrier carrierRes = (Carrier)it.next();
		Resource resource = new Resource();
		resource.setCarrierId(carrierRes.getId());
		
		
		mp.put(carrierRes.getId(),resourceDao.getResources(resource));
	}
	return mp;
}

//查找所有频道List
public List getCarriersAll() {
	Carrier carrier = new Carrier();
	return  carrierDao.getCarriers(carrier);
}
//查找所有频道Map
public Map getCarriersAllMap() {
	Carrier carrier = new Carrier();
	List ls = carrierDao.getCarriers(carrier);
	
//	System.out.println(" 15 getCarriersAllMap >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ls.size());
	
	return ConvertUtil.convertListToMap(ls,"id");
}

//孩子找父亲
public Map getCarrierMap() {
	// TODO Auto-generated method stub
	Carrier carrier = new Carrier();
	Map mp = new HashMap();
	
	List ls = carrierDao.getCarriers(carrier);
	
	
//	System.out.println(" 15 getCarrierMap >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ls.size());
	
	Iterator it = ls.iterator();
	while(it.hasNext()){
		List carrierParentList = new ArrayList();
		Carrier carrierRes = (Carrier)it.next();
		String parentId = carrierRes.getParentId();
		if(!carrierRes.getId().toString().equals(parentId)){
			carrierParentList.add(carrierRes);
			getCarrierParnet(carrierRes.getParentId(),carrierParentList);
			mp.put(carrierRes.getId(),carrierParentList);			
		}

	}
	return mp;
}

private void getCarrierParnet(String parentId,List carrierParentList){
	
//	System.out.println(" 15 getCarrierParnet 8888888888888888       99999999999999     parentId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +parentId);
	
//	if(!parentId.equals("0")){
	if(!"0".equals(parentId) && parentId !=null && !"".equals(parentId)){
		Carrier carrier = carrierDao.getCarrier(new Long(parentId));
		
//		System.out.println(" 15 carrier >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +carrier);
		if(carrier!=null){
			Integer level = carrier.getNodeLevel();
			
//			System.out.println(" 15 level >>>>>>>>>>>>>>>>>>>>>>>>>"+ carrier.getCarrierName()+">>>>>>>>>>>>>>>>>>>>>>" +level);
			carrierParentList.add(carrier);
			if(level.intValue() >1 && !carrier.getId().toString().equals(carrier.getParentId())){
				getCarrierParnet(carrier.getParentId(),carrierParentList);
			}
		}
	}	
}

public Map getCarrierMapNoMyslfe() {
	// TODO Auto-generated method stub
	Carrier carrier = new Carrier();
	Map mp = new HashMap();
	
	List ls = carrierDao.getCarriers(carrier);
	
	Iterator it = ls.iterator();
	while(it.hasNext()){
		List carrierParentList = new ArrayList();
		Carrier carrierRes = (Carrier)it.next();
//		carrierParentList.add(carrierRes);
		getCarrierByParnetId(carrierRes.getId(),carrierParentList);
		mp.put(carrierRes.getId(),carrierParentList);
	}

	return mp;
}

public Map getCarrierMap2() {
	// TODO Auto-generated method stub
	Carrier carrier = new Carrier();
	Map mp = new HashMap();
	
	List ls = carrierDao.getCarriers(carrier);
	
	Iterator it = ls.iterator();
	while(it.hasNext()){
		List carrierParentList = new ArrayList();
		Carrier carrierRes = (Carrier)it.next();
		if(!carrierRes.getId().toString().equals(carrierRes.getParentId())) {
			carrierParentList.add(carrierRes);
			getCarrierByParnetId(carrierRes.getId(),carrierParentList);
			mp.put(carrierRes.getId(),carrierParentList);		
		}

	}

	return mp;
}

private void getCarrierByParnetId(Long carrierId,List carrierParentList){
	Carrier carrier = new Carrier();
	carrier.setParentId(carrierId.toString());
		List ls = carrierDao.getCarriers(carrier);
		Iterator it = ls.iterator();
		while(it.hasNext()){
			Carrier carrierRes = (Carrier)it.next();
			if(!carrierRes.getId().toString().equals(carrierRes.getParentId())) {
				carrierParentList.add(carrierRes);
				getCarrierByParnetId(carrierRes.getId(),carrierParentList);				
			}

		}
		
}

public Map getOrderCatelogMap() {
	// TODO Auto-generated method stub
	Map mp = new HashMap();
	Map mp1 = new HashMap();
	
	OrderCategory orderCategory = new OrderCategory();
	orderCategory.setParentId("0");

	
	List ls = orderCategoryDao.getOrderCategorys(orderCategory);

	
	Iterator it = ls.iterator();
	while(it.hasNext()){
		OrderCategory orderCate = (OrderCategory)it.next();
		String orgId = orderCate.getOrgId().toString();
		if(!mp1.containsKey(orgId)){
			List ls11 = new ArrayList();
			ls11.add(orderCate);
			mp1.put(orgId,ls11);
		}else{
			List ls11 = (List)mp1.get(orgId);
			ls11.add(orderCate);
		}
	}
	
//	System.out.println("setupContext>>>>>>>>>>>>>aaa>>>>>" ); 
	Iterator itKey = mp1.keySet().iterator();
	while(itKey.hasNext()){
		String orgId = (String)itKey.next();
		mp.put(orgId+",0",(List)mp1.get(orgId));
	}

//	System.out.println("setupContext>>>>>>>>>>>>>bbb>>>>>" ); 
	
	Iterator it3 = ls.iterator();
	while(it3.hasNext()){
		OrderCategory orderCate = (OrderCategory)it3.next();
		OrderCategory category = new OrderCategory();
		category.setParentId(orderCate.getId().toString());
		mp.put(orderCate.getOrgId().toString()+","+orderCate.getId().toString(),orderCategoryDao.getOrderCategorys(category));
	}
	
//	System.out.println("setupContext>>>>>>>>>>>>>ccccccc>>>>>" ); 

	return mp;
}

public List getInduStryList() {
	// TODO Auto-generated method stub
//	List list = new ArrayList();
	Industry induStry = new Industry();

	return industryDao.getIndustrys(induStry);
}

public Map getInduStryMap() {
	Map map = new HashMap();
	List induStry = this.getInduStryList();

	for(Iterator it = induStry.iterator();it.hasNext();){
		Industry induS = (Industry) it.next();
		map.put(induS.getId().toString(),induS);
	}
	return map;
}

public List getResourceSortList() {
	// TODO Auto-generated method stub
	
//	List list = new ArrayList();
	ResourceSort resourceSort = new ResourceSort();

	return resourceSortDao.getResourceSorts(resourceSort);
}

public List getOrderCatelogParentList() {
	// TODO Auto-generated method stub
	
	OrderCategory orderCategory = new OrderCategory();
	orderCategory.setParentId("0");
	return orderCategoryDao.getOrderCategorys(orderCategory);
}

public List getSpecificList(){
//	List list=new ArrayList();
	Specific specific=new Specific();
	return specificDao.getSpecifics(specific);
	
}
public Map getSpecificMap(){
	Map mp = new HashMap();
	List us = this.getSpecificList();

	for(Iterator it = us.iterator();it.hasNext();){
		Specific specific = (Specific) it.next();
		mp.put(specific.getId().toString(),specific);
	}
	return mp;
}

public List getResourceNameList(){
//	List list=new ArrayList();
	Resource resource = new Resource();
	return resourceDao.getResourcesNameByIdList(resource);
	
}
public Map getResourceNameMap(){
	Map mp = new HashMap();
	List us = this.getResourceNameList();

	for(Iterator it = us.iterator();it.hasNext();){
		Resource resource = (Resource) it.next();
		mp.put(resource.getId().toString(),resource);
	}
	return mp;
}

public List getPriceTypeList() {
	// TODO Auto-generated method stub
	PriceType priceType = new PriceType();
	return priceTypeDao.getPriceTypes(priceType);
}

public List getSysUserList() {
	
	// TODO Auto-generated method stub
	User user=new User();
	return userDao.getUsers(user);
	
}

public Map getSysUserMap(int i) {
	Map mp = new HashMap();
	List us = this.getSysUserList();

	for(Iterator it = us.iterator();it.hasNext();){
		User user = (User) it.next();
		String key = (i == 1)?user.getId().toString():user.getUsername();
		mp.put(key,user);
	}
	return mp;
}






public List getPriceLengthDetail() {
	// TODO Auto-generated method stub
	List ls = priceDetailDao.getPriceLengthDetail();
	List priceLengthList = new ArrayList();
	for(Iterator it = ls.iterator();it.hasNext();){
		PriceDetail priceDetail = new PriceDetail();
		priceDetail.setLength((String)it.next());
		priceLengthList.add(priceDetail);
	}
	
	return priceLengthList;
}

public Map getSameMatterName() {
	// TODO Auto-generated method stub
	Map mp = new HashMap();
	Matter matter = new Matter();
	List ls = matterDao.getMatters(matter);
	Iterator it = ls.iterator();
	while(it.hasNext()){
		Matter m = (Matter)it.next();
		//newMatters   广告名字相同的所有matterId
		List newMatters = new ArrayList();
//		newMatters.add(m.getId());
		getNewMatterList(m,ls,newMatters);
		mp.put(m.getId(),newMatters);
	}
	return mp;
}



private List getNewMatterList(Matter matter,List matterList,List newMatterList) {
	String matterName = matter.getName();
	Iterator it = matterList.iterator();
	while(it.hasNext()){
		Matter m = (Matter)it.next();
		if(matterName.equals(m.getName())){
			newMatterList.add(m.getId());
		}
	}
	return newMatterList;
}

public Map getOrderListCatagory() {
	Map mp = new HashMap();
	List ls = orderCategoryDao.getOrderCategorysOrderList(new OrderCategory());
//	System.out.println(ls.size());
	for(Iterator it = ls.iterator();it.hasNext();){
		OrderCategory category = (OrderCategory)it.next();
//		System.out.println(category.getName());
		List sameNameIds = orderCategoryDao.getSameNameIdList(category.getName());
//		System.out.println("sameNameIds   "+sameNameIds.size());
		mp.put(category.getName(),sameNameIds);
	}
	return mp;
}

public Map getOrderListCatagoryName() {
	Map map = new HashMap();
	List ls = orderCategoryDao.getOrderCategorysNameList(new OrderCategory());

	for(Iterator it = ls.iterator();it.hasNext();){
		OrderCategory orderC = (OrderCategory) it.next();
		map.put(orderC.getId().toString(),orderC);
	}
	return map;
}

public List getOaWorkFlowCheckStateList(){
	OaWorkFlowCheckState oaWorkFlowCheckState = new OaWorkFlowCheckState();
	return oaWorkFlowCheckStateDao.getOaWorkFlowCheckStates(oaWorkFlowCheckState);
	}

public void saveOrgLogoToFile(String tarFile,byte[] fileData) {
	
	try {
		OutputStream bos = new FileOutputStream(tarFile);
         try {
			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void excuteSql() {
	// TODO Auto-generated method stub
       
	String orgName = "";
	Integer version = new Integer(0);
	String  tvName = "";
	
	try {
		ResultSet rsOrg =dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select version,name from tb_sys_org where sys_org_id=1");
		if (rsOrg.next()){
			version = Integer.valueOf(rsOrg.getString("version"));
			orgName = String.valueOf(rsOrg.getString("name"));
			
//			修改tvName 
			mody_sysParam1();
		}
		rsOrg.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
	try {
		ResultSet rsOrg =dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select value from tb_sys_param where name='tvNameParam'");
		if (rsOrg.next()){tvName = String.valueOf(rsOrg.getString("value"));}
		rsOrg.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		//数据库升级

	
		int curVersion = version.intValue();
		
		if(curVersion < 1){
			updateSystemDao.excuteUpdate1();
			updateSystemDao.excuteUpdate2();
			updateSystemDao.excuteUpdate3();
			
			    System.out.println("系统数据库升级到版本为："+ 1);
				updateSystemDao.excuteUpdate4();
		}
		if(curVersion < 2 ){
			    System.out.println("系统数据库升级到版本为："+ 2);
				updateSystemDao.excuteUpdate5();
		}		
			
		if(curVersion < 3 ){
		    System.out.println("系统数据库升级到版本为："+ 3);
			updateSystemDao.excuteUpdate6();
		}
		
		if(curVersion < 4 ){
		    System.out.println("系统数据库升级到版本为："+ 4);
			updateSystemDao.excuteUpdate7();
		}
		
		if(curVersion < 5 ){
		    System.out.println("系统数据库升级到版本为："+ 5);
			updateSystemDao.excuteUpdate8();
		}
		
		if(curVersion < 6 ){
		    System.out.println("系统数据库升级到版本为："+ 6);
			updateSystemDao.excuteUpdate9();
		}
		
		if(curVersion < 7 ){
		    System.out.println("系统数据库升级到版本为："+ 7);
			updateSystemDao.excuteUpdate10();
		}
		
		if(curVersion < 8 ){
		    System.out.println("系统数据库升级到版本为："+ 8);
		    try {
		    	
//		    	dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_sys_role drop column sys_org_id");
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_sys_role add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");
				dao.getDefaultDataSource().getConnection().createStatement().execute("update tb_sys_role set sys_org_id = 1");
//				dao.getDefaultDataSource().getConnection().createStatement().execute("update tb_sys_role set sys_org_id = 0 where name='ROLE_ADMIN'");
//				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_ad_resource_carrier_type drop column sys_org_id");
				
				dao.getDefaultDataSource().getConnection().createStatement().execute("update tb_sys_branch set sys_org_id = 1");
				
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_ad_resource_carrier_type add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_ad_resource_type add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_ad_resource_channel add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_ad_resource_mediaorg add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_order_category add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_customer_info add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");
				dao.getDefaultDataSource().getConnection().createStatement().execute("alter table tb_sys_menu add column sys_org_id  bigint(20) NOT NULL DEFAULT 1");

				dao.getDefaultDataSource().getConnection().createStatement().execute("update tb_sys_org set version = 8");
		    } catch (SQLException e) {
				 System.out.println("系统数据库升级到8失败");
//				e.printStackTrace();
			}
		}
		
		
		if(curVersion < 9 ){
			    
			    int curVer = 9;
		        System.out.println("系统正在数据库升级到版本为："+ curVer);
		        
		        
		        String isMoreChannel = "0";
		        ResultSet rs;
				try {
					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select value from tb_sys_param where name='moreChannelParam'");
					if (rs.next()){isMoreChannel = (String)rs.getString("value");}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			
		        
         
		        excuteSql("drop procedure if exists pro_check_tape_code",curVer);
		        excuteSql("drop procedure if exists pro_check_tape_code_update",curVer);
		        excuteSql("drop procedure if exists pro_check_tape_code2",curVer);
		        excuteSql("drop procedure if exists pro_check_tape_code2_update",curVer);
		        excuteSql("drop procedure if exists pro_check_tape_code_test",curVer);
		        excuteSql("drop procedure if exists pro_check_tape_code_update_test",curVer);		        
		        excuteSql("drop procedure if exists pro_check_tb_contract_payment",curVer);
		        excuteSql("drop procedure if exists pro_check_tb_contract_payment_update",curVer);
		        excuteSql("drop procedure if exists pro_check_tb_income_code",curVer);
		        excuteSql("drop procedure if exists pro_check_tb_income_code_update",curVer);
		        
		        

		        
		        
		        //校验数据
		        String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-20110701.xml";
				executeUpdateScript(filePath,"|",false);
				
                if("1".equals(isMoreChannel)){
                	   excuteSql("call pro_check_tape_code",curVer);
                }else{
                	 excuteSql("call pro_check_tape_code_test",curVer);
                }

		        excuteSql("call pro_check_tape_code2",curVer);
		        excuteSql("delete from tb_adver_matter where adver_matter_id not in (select adver_matter_id from tb_order_detail)",curVer);
		        excuteSql("delete from  tb_contract_payment where money_pay =0",curVer);		        
		        excuteSql("call pro_check_tb_contract_payment",curVer);
		        excuteSql("call pro_check_tb_income_code",curVer);	


		       
				excuteSql("SET FOREIGN_KEY_CHECKS = 0",curVer);
				
				excuteSql("alter table tb_customer_info drop index customer_name",curVer);
				excuteSql("alter table tb_customer_info drop index help_code",curVer);
		
				
				excuteSql("alter table tb_customer_info modify column customer_category_id  bigint(20) NOT NULL DEFAULT 1",curVer);
				excuteSql("ALTER TABLE tb_customer_info ADD CONSTRAINT fk_tb_customer_info_customer_category_id FOREIGN KEY (customer_category_id)  REFERENCES tb_customer_category(customer_category_id)",curVer);

				excuteSql("ALTER TABLE tb_customer_info ADD UNIQUE tb_customer_info_index_unique_name_helpocde_org (customer_name,help_code,sys_org_id)",curVer);


				
				excuteSql("ALTER TABLE tb_customer_info ADD CONSTRAINT fk_tb_customer_info_org_id FOREIGN KEY (sys_org_id)  REFERENCES tb_sys_org(sys_org_id)",curVer);

				
				
				
//				excuteSql("ALTER TABLE tb_adver_matter ADD CONSTRAINT fk_tb_adver_matter_customer_id FOREIGN KEY (customer_id)  REFERENCES tb_customer_info(customer_id)",curVer);
				excuteSql("ALTER TABLE tb_order ADD INDEX tb_order_index_contract_paymentid (contract_payment_id)",curVer);
				
				/*****************需要考虑*********************************/
				excuteSql("ALTER TABLE tb_adver_matter ADD UNIQUE tb_adver_matter_index_unique_name_edit_length (name,edit,length)",curVer);
				excuteSql("ALTER TABLE tb_adver_matter ADD UNIQUE tb_adver_matter_index_unique_tapecode (tape_code)",curVer);
				excuteSql("ALTER TABLE tb_income ADD UNIQUE tb_income_index_unique_incomeCode (income_code,version)",curVer);
				excuteSql("ALTER TABLE tb_contract_payment ADD UNIQUE tb_contract_payment_index_unique_contrac_order_num (contract_id,order_id,pay_number)",curVer);
				/**************************************************/
				
				excuteSql("INSERT INTO tb_oa_work_flow_check_state (check_state_id, version, name, value, create_by, create_date, modify_by, modify_date) VALUES (0, 1, '', 0, 1, '2007-4-20 00:00:00', 1, '2007-4-20 00:00:00')",curVer);
				excuteSql("update tb_oa_work_flow_check_state set  check_state_id=0 where value=''",curVer);
				excuteSql("ALTER TABLE tb_order ADD CONSTRAINT fk_tb_order_check_state FOREIGN KEY (is_ckecked)  REFERENCES tb_oa_work_flow_check_state(check_state_id)",curVer);

				excuteSql("INSERT INTO tb_ad_resource_type VALUES (0, 0, '', '1', NULL, NULL, NULL, NULL, 1, NULL, 1)",curVer);
				excuteSql("update tb_ad_resource_type set  ad_ad_resource_type_id=0 where name=''",curVer);
				excuteSql("alter table tb_income_pull add column ad_ad_resource_type_id  bigint(20) NOT NULL DEFAULT 0",curVer);
				excuteSql("ALTER TABLE tb_income_pull ADD CONSTRAINT fk_tb_income_pull_res_type FOREIGN KEY (ad_ad_resource_type_id)  REFERENCES tb_ad_resource_type(ad_ad_resource_type_id)",curVer);

				excuteSql("alter table tb_contract_payment add column ad_ad_resource_type_id  bigint(20) NOT NULL DEFAULT 0",curVer);
				excuteSql("ALTER TABLE tb_contract_payment ADD CONSTRAINT fk_tb_contract_payment_res_type FOREIGN KEY (ad_ad_resource_type_id)  REFERENCES tb_ad_resource_type(ad_ad_resource_type_id)",curVer);

				excuteSql("SET FOREIGN_KEY_CHECKS = 1",curVer);
				
				excuteSql("update tb_sys_org set version = "+curVer,curVer);

		}
		
		if(curVersion < 10 ){
			int curVer = 10;
			
			excuteSql("SET FOREIGN_KEY_CHECKS = 0",curVer);
			
			if(!"catv".equals(tvName) && !"sjz".equals(tvName)&& !"hntv".equals(tvName)){
				excuteSql("ALTER TABLE tb_adver_matter DROP FOREIGN KEY fk_tb_adver_matter_customer_id",curVer);
			}

			excuteSql("update tb_sys_menu set is_display=0 where action = 'branchs.html'",curVer);
			excuteSql("update tb_sys_menu set is_display=0 where action = 'roles.html'",curVer);
			
		    //修改版本9中的不足 ，没考虑好多组织
//			excuteSql("ALTER TABLE tb_adver_matter ADD UNIQUE tb_adver_matter_index_unique_name_edit_length (name,edit,length)",curVer);
//			excuteSql("ALTER TABLE tb_adver_matter ADD UNIQUE tb_adver_matter_index_unique_tapecode (tape_code)",curVer);
//			excuteSql("ALTER TABLE tb_income ADD UNIQUE tb_income_index_unique_incomeCode (income_code)",curVer);
//			excuteSql("ALTER TABLE tb_contract_payment ADD UNIQUE tb_contract_payment_index_unique_contrac_order_num (contract_id,order_id,pay_number)",curVer);
			excuteSql("alter table tb_adver_matter add column sys_org_id  bigint(20) NOT NULL DEFAULT 1",curVer);
			excuteSql("alter table tb_adver_matter drop index tb_adver_matter_index_unique_tapecode",curVer);
			excuteSql("alter table tb_adver_matter drop index tb_adver_matter_index_unique_name_edit_length",curVer);
			excuteSql("ALTER TABLE tb_adver_matter add UNIQUE tb_adver_matter_index_unique_name_edit_length (sys_org_id,tape_code,name,edit,length)",curVer);
			
			excuteSql("alter table tb_income add column sys_org_id  bigint(20) NOT NULL DEFAULT 1",curVer);
			excuteSql("alter table tb_income drop index tb_income_index_unique_incomeCode",curVer);
			excuteSql("alter table tb_income add UNIQUE tb_income_index_unique_incomeCode (sys_org_id,version,income_code)",curVer);
			excuteSql("alter table tb_contract_payment drop index tb_contract_payment_index_unique_contrac_order_num",curVer);
			
		
			
			//行业分类需要多级
			excuteSql("alter table tb_customer_industry_type add column parent_id  bigint(20) NOT NULL DEFAULT 0",curVer);
			
			
			excuteSql("alter table tb_customer_industry_type drop index name",curVer);
			//版本用于区分多组织
			excuteSql("update tb_sys_sequence set version=1",curVer);
			
			excuteSql("SET FOREIGN_KEY_CHECKS = 1",curVer);
			
			excuteSql("update tb_sys_org set version = "+curVer,curVer);
			

		}

		
		if(curVersion < 11 ){
			
			int curVer = 11;
			
			excuteSql("update tb_ad_resource_price set is_default=1",curVer);
			excuteSql("alter table tb_ad_resource_compages add column sys_org_id  bigint(20) NOT NULL DEFAULT 1",curVer);
			excuteSql("alter table tb_sys_user_rel add column sys_org_id  bigint(20) NOT NULL DEFAULT 1",curVer);
			excuteSql("ALTER TABLE tb_sys_user_rel ADD CONSTRAINT fk_tb_sys_user_rel_org FOREIGN KEY (sys_org_id)  REFERENCES tb_sys_org(sys_org_id)",curVer);
			
			excuteSql("ALTER   TABLE   tb_sys_user_rel   DROP   PRIMARY   KEY",curVer);
			excuteSql("ALTER  TABLE   tb_sys_user_rel   ADD   PRIMARY   KEY   (sys_org_id,parent_user_id,user_id)",curVer);
			
			excuteSql("update tb_adver_matter AS A set A.adver_product_brand_id = (select customer_industry_type_id from tb_order_detail  B where B.adver_matter_id = A.adver_matter_id GROUP BY B.adver_matter_id)",curVer);
			excuteSql("ALTER TABLE tb_adver_matter ADD CONSTRAINT fk_tb_adver_matter_industry FOREIGN KEY (adver_product_brand_id)  REFERENCES tb_customer_industry_type(customer_industry_type_id)",curVer);
//			excuteSql("ALTER TABLE tb_adver_matter ADD CONSTRAINT fk_tb_adver_matter_sys_org_id FOREIGN KEY (sys_org_id)  REFERENCES tb_sys_org(sys_org_id)",curVer);
			
			
			excuteSql("ALTER TABLE tb_customer_link_man ADD CONSTRAINT fk_tb_customer_link_man_customer FOREIGN KEY (customer_id)  REFERENCES tb_customer_info(customer_id)",curVer);		
			
			excuteSql("ALTER TABLE tb_customer_feedback ADD CONSTRAINT fk_tb_customer_feedback_customer FOREIGN KEY (customer_id)  REFERENCES tb_customer_info(customer_id)",curVer);		

			excuteSql("alter table tb_customer_link_man modify column customer_id     bigint(20) NOT NULL ",curVer);
			excuteSql("alter table tb_customer_feedback modify column customer_id     bigint(20) NOT NULL ",curVer);
			
//			alter table tb_sys_menu modify column action  varchar(100) DEFAULT NULL
			
			excuteSql("update  tb_adver_matter A, tb_order_detail B   set  A.adver_product_brand_id = B.customer_industry_type_id   where A.adver_matter_id  = B.adver_matter_id",curVer);
			
//			excuteSql("ALTER TABLE tb_adver_matter ADD CONSTRAINT fk_tb_advermatter_industrytype FOREIGN KEY (adver_product_brand_id)  REFERENCES tb_customer_industry_type(customer_industry_type_id)",curVer);
			
			
			excuteSql("update tb_sys_org set version = "+curVer,curVer);
		
		}
		
		if(curVersion < 12 ){
			int curVer = 12;
			
		
			excuteSql("ALTER TABLE tb_order add INDEX tb_order_index_version (version)",curVer);
			excuteSql("ALTER TABLE tb_order_detail add INDEX tb_order_detail_index_version (version)",curVer);
//			excuteSql("ALTER TABLE tb_order_day_info add INDEX tb_order_day_info_index_versionpublishdate (version,publish_date)",curVer);
			
			
			excuteSql("alter table tb_contract drop index unique_key_contract_code",curVer);
			excuteSql("alter table tb_contract add INDEX tb_contract_index_orgid_code (version,code)",curVer);
			excuteSql("update tb_sys_org set version = "+curVer,curVer);
		
		}		
	
		if(curVersion < 13 ){
			int curVer = 13;
			excuteSql("alter table tb_published_arrang add column before_hand  int(5) NOT NULL DEFAULT 0",curVer);
			excuteSql("update tb_sys_org set version = "+curVer,curVer);
		}		
		
		if(curVersion < 14 ){
			int curVer = 14;
			excuteSql("alter table tb_ad_resource_info add column before_hand  int(5) NOT NULL DEFAULT 0",curVer);
			excuteSql("update tb_ad_resource_workspan set broadcast_end_time = 0",curVer);
			excuteSql("alter table tb_ad_resource_workspan modify column broadcast_end_time  int(11) NOT NULL DEFAULT 0",curVer);
			excuteSql("INSERT INTO `tb_sys_resource` (`version`,name,res_type,res_string,memo) VALUES ('0', '付款信息折扣可见', 'TAG', 'tag_order_paymentbtn', '')",curVer);
			
			
//			System.out.println("系统数 .........................mody_broEndTimes.....start...............");
			mody_broEndTimes();
//			 System.out.println("系统数 .........................mody_broEndTimes........end............"); 
//			 mody_sysParam1();
			 
			excuteSql("update tb_sys_org set version = "+curVer,curVer);

		}	
		
		if(curVersion < 15 ){
			int curVer = 15; 
			excuteSql("INSERT INTO `tb_sys_resource` (`version`,name,res_type,res_string,memo) VALUES ('0', '订单提交', 'TAG', 'tag_order_submitbtn', '')",curVer);
			
			if("catv".equals(tvName)){
				excuteSql("INSERT INTO `tb_oa_work_flow_check_state` VALUES ('5', '1', '未通过', '6', '1', '2007-04-20 00:00:00', '1', '2007-04-20 00:00:00')",curVer);	
			}
			excuteSql("INSERT INTO `tb_oa_work_flow_check_state` VALUES ('6', '1', '待提交', '6', '1', '2007-04-20 00:00:00', '1', '2007-04-20 00:00:00')",curVer);
			
			excuteSql("alter table tb_sys_org add column report_signature  varchar(128)  DEFAULT NULL",curVer);
			excuteSql("update tb_sys_org set report_signature = report_title",curVer); 
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
		}		
		
		if(curVersion < 16 ){
			int curVer = 16; 
			excuteSql("alter table tb_ad_resource_day_info add column modify_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP",curVer);
			excuteSql("INSERT INTO `tb_oa_work_flow_check_state` VALUES ('7', '1', '废订单', '7', '1', '2007-04-20 00:00:00', '1', '2007-04-20 00:00:00')",curVer);
			
			excuteSql("alter table tb_sys_menu modify column action  varchar(100) DEFAULT NULL",curVer);  
			excuteSql("delete from tb_ad_resource_sort where name='套装'",curVer);  
			excuteSql("alter table tb_ad_resource_compages add column ad_resource_mediaorg_id  bigint(20) NOT NULL DEFAULT 1",curVer);
			excuteSql("ALTER TABLE tb_ad_resource_compages ADD CONSTRAINT fk_tb_compages_resource_mediaorg FOREIGN KEY (ad_resource_mediaorg_id)  REFERENCES tb_ad_resource_mediaorg(ad_resource_mediaorg_id)",curVer);		
			
			if("qztv".equals(tvName)){
				excuteSql("INSERT INTO tb_sys_menu VALUES ('194', '0', '类别统计', '100', '0', '0', 'customerCateAnalyze.html', null, '', '', '', '/image/menu/menus.png', '', '', '', '', '', '', '', '类别统计', '', '', '0', null, '0', null, '1')",curVer);  
//				excuteSql("INSERT INTO `tb_ad_resource_price_type` VALUES ('8', '0', '月价格', 'A', null, null, null, null, '1', null)",curVer);  
				excuteSql("update tb_ad_resource_price AS  P  set P.ad_resource_price_type= 4 where exists(SELECT *   from  tb_ad_resource_compages_price_rel CP, tb_ad_resource_compages C   WHERE  CP.ad_resource_price_id = P.ad_resource_price_id  AND C.ad_resource_compages_id = CP.ad_resource_compages_id)",curVer);  
			
			}
			if("sjz".equals(tvName)){
				excuteSql("update tb_ad_resource_mediaorg  set name ='时段' where ad_resource_mediaorg_Id=1",curVer);  
			}
			
			if("hntv".equals(tvName)){
				excuteSql("update tb_ad_resource_mediaorg  set name ='时段' where ad_resource_mediaorg_Id=1",curVer);  
				excuteSql("update tb_ad_resource_mediaorg  set name ='栏目' where ad_resource_mediaorg_Id=2",curVer);  
				excuteSql("update tb_ad_resource_carrier set ad_resource_mediaorg_Id=1",curVer);  
			}
			
//			if("xmtv".equals(tvName)){
//				excuteSql("INSERT INTO `tb_ad_resource_price_type` VALUES ('7', '0', '月价格', 'A', null, null, null, null, '1', null)",curVer);  
//				excuteSql("update tb_ad_resource_price AS  P  set P.ad_resource_price_type= 7 where exists(SELECT *   from  tb_ad_resource_compages_price_rel CP, tb_ad_resource_compages C   WHERE  CP.ad_resource_price_id = P.ad_resource_price_id  AND C.ad_resource_compages_id = CP.ad_resource_compages_id)",curVer);  
//			}
//			
//			if("catv".equals(tvName)||"sjz".equals(tvName)||"hntv".equals(tvName)){
//				excuteSql("update tb_ad_resource_price_type set value='A' where ad_resource_price_type_id=3",curVer);  
//				excuteSql("update tb_ad_resource_price AS  P  set P.ad_resource_price_type= 3 where exists(SELECT *   from  tb_ad_resource_compages_price_rel CP, tb_ad_resource_compages C   WHERE  CP.ad_resource_price_id = P.ad_resource_price_id  AND C.ad_resource_compages_id = CP.ad_resource_compages_id)",curVer);  
//			}
	
			
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
			
		}	
		
		
		if(curVersion < 17 ){
			int curVer = 17; 
			
			try {
				if("qztv".equals(tvName)){
					excuteSql("update tb_ad_resource_type set version =2012",curVer);  
					
					ResultSet rsOrg =dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select sys_org_id,name from tb_ad_resource_type where name <>'' order by sys_org_id,name ");
					while(rsOrg.next()){
						String orgId =  String.valueOf(Long.valueOf(rsOrg.getString("sys_org_id")));
						String name = String.valueOf(rsOrg.getString("name"));
						for(int i =2013;i<2014;i++){
							String sql = "INSERT INTO `tb_ad_resource_type` (version,name,sys_org_id,value,enable) VALUES ("+ i +", '"+ name +"', "+ orgId +", '1', 1)";
							System.out.println("系统数 .................start..............." + sql);
							excuteSql(sql,curVer);
						}
					}					
				}
				
				
				if("xmtv".equals(tvName)){
					
					excuteSql("update tb_ad_resource_type set version =2010",curVer);  
					
					ResultSet rsOrg =dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select sys_org_id,name from tb_ad_resource_type where name <>'' order by sys_org_id,name ");
					while(rsOrg.next()){
						String orgId =  String.valueOf(Long.valueOf(rsOrg.getString("sys_org_id")));
						String name = String.valueOf(rsOrg.getString("name"));
						for(int i =2011;i<2014;i++){
							String sql = "INSERT INTO `tb_ad_resource_type` (version,name,sys_org_id,value,enable) VALUES ("+ i +", '"+ name +"', "+ orgId +", '1', 1)";
							System.out.println("系统数 .................start..............." + sql);
							excuteSql(sql,curVer);
						}
					}
					
					
//					ResultSet rs =dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select ad_resource_info_id,ad_resource_type from tb_ad_resource_info where ad_resource_type >0 ");
//					while(rs.next()){
//						String ad_resource_info_id =  String.valueOf(Long.valueOf(rs.getString("ad_resource_info_id")));
//						String ad_resource_type_id =  String.valueOf(Long.valueOf(rs.getString("ad_resource_type")));
//							String sql = "INSERT INTO tb_ad_resource_type_rel (ad_resource_type_id,ad_resource_info_id) VALUES ("+ ad_resource_type_id +", "+ ad_resource_info_id +")";
//							System.out.println("系统数 .................start..............." + sql);
//							excuteSql(sql,curVer);
//					}					
					
				}

				
				excuteSql("INSERT INTO `tb_sys_resource` (`version`,name,res_type,res_string,memo) VALUES ('0', '订单领导批注', 'TAG', 'tag_order_leadmemo', '')",curVer);
				
				excuteSql("INSERT INTO `tb_sys_resource` (`version`,name,res_type,res_string,memo) VALUES ('0', '订单不需要退回可直接修改', 'TAG', 'tag_order_force_modify', '')",curVer);
				
	
				excuteSql("alter table tb_order_log modify column change_content  varchar(10000) NOT NULL DEFAULT ''",curVer);
				
				excuteSql("update tb_order_detail set create_date = modify_date  where create_date is null",curVer);  
			
				
				excuteSql("update tb_sys_org set version = "+curVer,curVer);  

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		if(curVersion < 18 ){
			int curVer = 18; 
			
			    excuteSql("INSERT INTO `tb_sys_resource` (`version`,name,res_type,res_string,memo) VALUES ('0', '订单类别过滤', 'TAG', 'tag_order_cate_fitter', '')",curVer);
						

				excuteSql("DROP TABLE IF EXISTS `tb_fitter_ordercate`",curVer);  
				StringBuffer sb = new StringBuffer();
				sb.append("CREATE TABLE `tb_fitter_ordercate` (");
				sb.append("`version` int(8) NOT NULL DEFAULT '0',");
				sb.append("`order_cate_id` bigint(20) NOT NULL DEFAULT '0',");
				sb.append(" PRIMARY KEY (`version`,`order_cate_id`),");
				sb.append(" KEY `FK_tb_fitter_ordercate` (`order_cate_id`),");
				sb.append(" CONSTRAINT `FK_tb_fitter_ordercate` FOREIGN KEY (`order_cate_id`) REFERENCES `tb_order_category` (`order_category_id`) ");  
				sb.append(") ENGINE=InnoDB DEFAULT CHARSET=gbk");    
				excuteSql(sb.toString(),curVer);  
		

				excuteSql("DROP TABLE IF EXISTS `tb_fitter_incomepurpose`",curVer);  
				StringBuffer sb2 = new StringBuffer();
				sb2.append("CREATE TABLE `tb_fitter_incomepurpose` (");
				sb2.append(" `version` int(8) NOT NULL DEFAULT '0',");
				sb2.append("`income_purpose_id` bigint(20) NOT NULL DEFAULT '0',");
				sb2.append(" PRIMARY KEY (`version`,`income_purpose_id`),");
				sb2.append(" KEY `FK_tb_fitter_income_purpose` (`income_purpose_id`),");
				sb2.append("CONSTRAINT `FK_tb_fitter_income_purpose` FOREIGN KEY (`income_purpose_id`) REFERENCES `tb_income_purpose` (`income_purpose_id`)");
				sb2.append(") ENGINE=InnoDB DEFAULT CHARSET=gbk");
				excuteSql(sb2.toString(),curVer);  
				
				

				excuteSql("update tb_sys_org set version = "+curVer,curVer);  

		}	
		
		
		if(curVersion < 19 ){
			int curVer = 19; 
			excuteSql("update tb_ad_resource_workspan AS A set ad_resource_type = 1, memo = (select  resource_name from tb_ad_resource_info where ad_resource_info_id = A.ad_resource_info_id )",curVer);	
			
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
		}		
		
		if(curVersion < 20 ){
			int curVer = 20; 
			
			excuteSql("alter table tb_adver_matter add column help_code_name  varchar(40)  DEFAULT NULL",curVer);
			excuteSql("alter table tb_adver_matter add column help_code_edit  varchar(60)  DEFAULT NULL",curVer);
			
			mody_matter_helpcode(curVer);
			
			excuteSql("ALTER TABLE tb_adver_matter ADD INDEX tb_adver_matter_index_helpcode_name (help_code_name)",curVer);
			excuteSql("ALTER TABLE tb_adver_matter ADD INDEX tb_adver_matter_index_helpcode_edit (help_code_edit)",curVer);
	
			
//			excuteSql("update tb_ad_resource_workspan AS A set ad_resource_type = 1, memo = (select  resource_name from tb_ad_resource_info where ad_resource_info_id = A.ad_resource_info_id )",curVer);	
			
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
		}			
		


		if(curVersion < 21 ){
			int curVer = 21; 
//			publish_memo
			excuteSql("alter table tb_order_detail modify column publish_memo  varchar(125) DEFAULT NULL",curVer);
			
			if(!"hbtv".equals(tvName)){
				excuteSql("update tb_sys_branch set tree_level = 1",curVer);  
			}
	

			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
		}	
		
		
		if(curVersion < 22 ){
			int curVer = 22; 
//			publish_memo
			excuteSql("alter table tb_sys_org add column org_type  varchar(2) DEFAULT 1",curVer);
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
		}		
		
		if(curVersion < 23 ){
			int curVer = 23; 
//			publish_memo
			excuteSql("alter table tb_sys_org add column parent_id  varchar(32) NOT NULL DEFAULT 0",curVer);
			excuteSql("alter table tb_sys_org add column display_no   int(11) NOT NULL DEFAULT 0",curVer);
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
		}		
		
		if(curVersion < 24 ){
			int curVer = 24; 
//			publish_memo ad_resource_sort_id
			excuteSql("alter table tb_ad_resource_info add column ad_resource_sort_id   bigint(20) NOT NULL DEFAULT 1",curVer);
			excuteSql("alter table tb_ad_resource_info ADD CONSTRAINT fk_tb_resource_info_tb_ad_resource_sort FOREIGN KEY (ad_resource_sort_id)  REFERENCES tb_ad_resource_sort(ad_resource_sort_id)",curVer);
			
			if("hbtv".equals(tvName)){
				excuteSql("update tb_ad_resource_info  A  set A.ad_resource_sort_id =   (SELECT B.ad_resource_type  FROM  tb_ad_resource_workspan  B WHERE A.ad_resource_info_id = B.ad_resource_info_id)",curVer);  
			}
			
			 
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
			
		}			
		
		
		if(curVersion < 25 ){
			int curVer = 25; 
			excuteSql("alter table tb_published_arrang_detail add column ctr_bro_time   int(11) DEFAULT NULL",curVer);
			excuteSql("alter table tb_published_arrang_detail add column ctr_bro_sort   int(11) NOT NULL DEFAULT 0",curVer);
			excuteSql("update tb_published_arrang_detail set ctr_bro_sort = publish_sort",curVer);
			
			
			excuteSql("DROP TABLE IF EXISTS `tb_ctr_data`",curVer);  
			StringBuffer sb2 = new StringBuffer();
			sb2.append("CREATE TABLE `tb_ctr_data` (");
			sb2.append(" `id` bigint(20) NOT NULL AUTO_INCREMENT,");
			sb2.append("`carrider_name` varchar(50) DEFAULT NULL,");
			sb2.append(" `bro_date` int(11) DEFAULT NULL,");
			sb2.append(" `bro_start_time` int(11) DEFAULT NULL,");
			sb2.append(" `adv_contents` varchar(255) DEFAULT NULL,");
			sb2.append(" `bro_adv_length` int(11) DEFAULT NULL,");
			sb2.append("  PRIMARY KEY (`id`)");
			sb2.append(") ENGINE=InnoDB DEFAULT CHARSET=gbk");
			excuteSql(sb2.toString(),curVer);  		
			
			excuteSql("update tb_sys_org set version = "+curVer,curVer);  
		}		

		if(curVersion < 26 ){
			int curVer = 26; 
			excuteSql("alter table tb_order_day_info add column day_rel_balance   double NOT NULL DEFAULT 0",curVer);
//			excuteSql("alter table tb_order_detail add column exec_price2   double NOT NULL DEFAULT 0",curVer);
			excuteSql("update tb_sys_org set version = "+ curVer,curVer);  
		}		

		if(curVersion < 27 && !"hntv".equals(tvName) ){
			int curVer = 27; 
			excuteSql("alter table tb_published_arrang_detail modify column matter_name  varchar(100) DEFAULT NULL",curVer);
			excuteSql("update tb_sys_org set version = "+ curVer,curVer);  
		}	
		
		if(curVersion < 28 ){
			int curVer = 28; 
			excuteSql("alter table tb_adver_matter add column in_dayang_matter int(1) DEFAULT 0",curVer);
			excuteSql("update tb_sys_org set version = "+ curVer,curVer);  
		}	
		
		
		if(curVersion < 29 ){
			int curVer = 29; 
			excuteSql("alter table tb_published_arrang_detail modify column matter_edit varchar(100) DEFAULT NULL",curVer);
			excuteSql("update tb_sys_org set version = "+ curVer,curVer);  
		}	
		
		if(curVersion < 30 ){
			int curVer = 30; 
			
			if("sjz".equals(tvName)){
				
				excuteSql("update tb_sys_role set sys_org_id =2 where sys_org_id =1",curVer);
				
				StringBuffer sb = new StringBuffer();
					
				sb.append("select   U.id user_id,UROL.role_id role_id FROM  tb_sys_user U ");
				sb.append(" left outer join  tb_sys_user_role UROL  on    U.id  = UROL.user_id ");
				sb.append(" left outer join   tb_sys_role SROL   on  UROL.role_id =  SROL.id ");
				sb.append(" left outer join   tb_sys_user_branch UB   on   U.id  = UB.user_id  ");
				sb.append(" left outer join   tb_sys_branch  BRAN   on   UB.branch_id  = BRAN.sys_branch_id");
				sb.append(" where BRAN.sys_org_id =3");
                String sql = sb.toString();
                RoleManager  roleManager  = ServiceLocator.getRoleManager();
                Map mp = roleManager.getRolesFromOtherOrg("2","3");
				try {
					ResultSet rsOrg =dao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
					while (rsOrg.next()){	
						Long user_id = rsOrg.getLong("user_id");
						Long role_id_old = rsOrg.getLong("role_id");
						Long role_id_new =(Long) mp.get(role_id_old);
	
						String sql2 ="insert into  tb_sys_user_role (user_id,role_id)values("+user_id.longValue() +"," + role_id_new.longValue()+")";
						System.out.println("mody_matter_helpcode>>>>>>"+sql2);
						excuteSql(sql2, curVer);
					}
					rsOrg.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			excuteSql("update tb_sys_org set version = "+ curVer,curVer);  
		}		
		
		
		if(curVersion < 31 ){
			int curVer = 31; 
			excuteSql("DROP TABLE IF EXISTS `tb_ad_resource_channel_conf`",curVer);  
			StringBuffer sb2 = new StringBuffer();
			sb2.append("CREATE TABLE `tb_ad_resource_channel_conf` (");
			sb2.append(" `id` bigint(20) NOT NULL AUTO_INCREMENT,");
			sb2.append("`channel_id` bigint(20) DEFAULT NULL,");
			sb2.append(" `send_address` varchar(255) DEFAULT NULL,");
			sb2.append(" `send_type` varchar(100) DEFAULT NULL,");
			sb2.append(" `resource_sort` varchar(100) NOT NULL DEFAULT '0',");
			sb2.append(" `send_zeo` int(2) unsigned zerofill NOT NULL DEFAULT '0',");
			sb2.append(" `enable` int(2) NOT NULL DEFAULT '0',");
			sb2.append(" `pre_1` varchar(20) DEFAULT NULL,");
			sb2.append(" `pre_2` varchar(20) DEFAULT NULL,");
			sb2.append("  PRIMARY KEY (`id`),");
			sb2.append("  KEY `tb_ad_resource_channel_conf_chid` (`channel_id`),");
			sb2.append("  CONSTRAINT `tb_ad_resource_channel_conf_chid` FOREIGN KEY (`channel_id`) REFERENCES `tb_ad_resource_channel` (`resource_mediaorg_id`)");
			
			sb2.append(") ENGINE=InnoDB DEFAULT CHARSET=gbk");
			excuteSql(sb2.toString(),curVer);  	
			
			
			excuteSql("update tb_sys_org set version = "+curVer,curVer); 
		}
		
		//广告
		if(curVersion < 32 ){
			int curVer = 32; 
			excuteSql("insert into tb_adver_product_brand (name,enable) values ('...',1);",curVer);
			excuteSql("update tb_adver_product_brand set adver_product_brand_id=0 where name='...';",curVer);
			excuteSql("alter table tb_adver_matter add column brand_id bigint(20) NOT NULL DEFAULT '0'",curVer);
			excuteSql("alter table tb_adver_product_brand add column help_code varchar(50) DEFAULT NULL",curVer);
			excuteSql("alter table tb_adver_product_brand add column parent_id bigint(20) DEFAULT 0",curVer);
			excuteSql("ALTER TABLE tb_adver_matter DROP FOREIGN KEY fk_tb_adver_matter_industry",curVer);
			excuteSql("alter table tb_adver_matter ADD CONSTRAINT fk_tb_adver_matter_brand FOREIGN KEY (brand_id)  REFERENCES tb_adver_product_brand(adver_product_brand_id)",curVer);
			excuteSql("update tb_sys_org set version = "+curVer,curVer); 
		}
		
		if(curVersion < 33 ){
			int curVer = 33; 
			excuteSql("DROP TABLE IF EXISTS `tb_finance_target_ratio`",curVer);  
			StringBuffer sb2 = new StringBuffer();
			sb2.append("CREATE TABLE `tb_finance_target_ratio` (");
			sb2.append(" `finance_target_id` bigint(20) NOT NULL AUTO_INCREMENT,");
			sb2.append(" `ad_resource_carrier_id` bigint(20) NOT NULL DEFAULT '0',");
			sb2.append(" `year` int(4) NOT NULL DEFAULT '0',");
			sb2.append(" `month` int(4) NOT NULL DEFAULT '0',");
			sb2.append(" `money` double NOT NULL DEFAULT '0',");
			sb2.append(" `create_by` bigint(20) DEFAULT NULL,");
			sb2.append(" `create_date` datetime DEFAULT NULL,");
			sb2.append(" `modify_by` bigint(20) DEFAULT NULL,");
			sb2.append(" `modify_date` datetime DEFAULT NULL,");
			sb2.append(" `version` int(11) NOT NULL DEFAULT '0',");
			sb2.append("  PRIMARY KEY (`finance_target_id`),");
			sb2.append("  KEY `fk_tb_finance_target_ratio_carrierid` (`ad_resource_carrier_id`),");
			sb2.append("  CONSTRAINT `fk_tb_finance_target_ratio_carrierid` FOREIGN KEY (`ad_resource_carrier_id`) REFERENCES `tb_ad_resource_carrier` (`ad_resource_carrier_id`)");
			
			sb2.append(") ENGINE=InnoDB DEFAULT CHARSET=gbk");
			excuteSql(sb2.toString(),curVer);  	

			excuteSql("update tb_sys_org set version = "+curVer,curVer); 
		}		
		

		//临时注释   
//		mody_matter_helpcode(20);	

		
		
		//临时注释  
//		if("xmtv".equals(tvName)){
//			mody_matter_helpcode(20);
//		}

}

//public void mody_brand_helpcode(int curVer){
//	String name = "";
//	String helpCodeName = "";
//	long id = 0;
//	
////	String rep ="\n\r\t";
//
//	try {
//		ResultSet rsOrg = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select adver_product_brand_id,name from tb_adver_product_brand where adver_product_brand_id>0");
//
//		while (rsOrg.next()){	
//			id = rsOrg.getLong("adver_product_brand_id");
//			name = StringUtil.getNullValue(rsOrg.getString("name"),"");
//			helpCodeName = GetFirstLetter.getPinYinHeadChar(name);
//		
//			String sql ="update tb_adver_product_brand set help_code ='"+ helpCodeName +"'  where adver_product_brand_id=" + id +"";
//			System.out.println("mody_brand_helpcode>>>"+ helpCodeName +">>>"+sql);
//			excuteSql(sql, curVer);
//		}
//		rsOrg.close();
//	} catch (SQLException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//}

public void mody_matter_helpcode(int curVer){
	String name = "";
	String edit = "";
	String helpCodeName = "";
	String helpCodeEdit = "";
	long id = 0;
	
//	String rep ="\n\r\t";

	try {
		ResultSet rsOrg =dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select adver_matter_id,name,edit from tb_adver_matter");

		while (rsOrg.next()){	
			id = rsOrg.getLong("adver_matter_id");
			name = StringUtil.getNullValue(rsOrg.getString("name"),"");
			edit = StringUtil.getNullValue(rsOrg.getString("edit"),"");
//			edit = StringUtil.String2kenizer(edit,rep);	
			helpCodeName = GetFirstLetter.getPinYinHeadChar(name);
			helpCodeEdit = GetFirstLetter.getPinYinHeadChar(edit);
			String sql ="update tb_adver_matter set help_code_name ='"+ helpCodeName +"', help_code_edit ='"+ helpCodeEdit +"' where adver_matter_id=" + id +"";
			System.out.println("mody_matter_helpcode>>>"+ edit +">>>"+sql);
			excuteSql(sql, curVer);
		}
		rsOrg.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}





public void mody_sysParam1(){
	String orgName = "";
	Integer version = new Integer(0);
	try {
		ResultSet rsOrg =dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select version,name from tb_sys_org where sys_org_id=1");
		if (rsOrg.next()){
			version = Integer.valueOf(rsOrg.getString("version"));
			orgName = String.valueOf(rsOrg.getString("name"));
			if("石家庄电视台广告部".equals(orgName)) {
				excuteSql("update tb_sys_param set value ='sjz' where name='tvNameParam'", version.intValue());
				excuteSql("update tb_sys_param set value ='1' where name='useCarrierAliname'", version.intValue());
			}
			if("陕西西影电影频道经营有限责任公司".equals(orgName)) {
				excuteSql("update tb_sys_param set value ='catv' where name='tvNameParam'", version.intValue());
			}	
			excuteSql("update tb_sys_param set value ='1' where name='signCompages'", version.intValue());

			
		}
		rsOrg.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}

private void mody_broEndTimes(){
	String sql ="select 1";
	String value = "";
	ResultSet rs;
	ResultSet rs2;
	
	try {
		rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select value from tb_sys_param where name='withBroPoint'");

		
		  if (rs.next()){
			  value = (String)rs.getString("value");
		  }
		  
//			 System.out.println("系统数 .........................mody_broEndTimes.........value..........."+value);

			rs2 = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select ad_resource_workspan_id,memo,broadcast_start_time,sun_length,mon_length,tue_length,thi_length,wen_length,fri_length,sat_length from tb_ad_resource_workspan");
		
			int startTime = 0;
			int curVer = 14;
			String memo = "0";
			while (rs2.next()){
				
				if("1".equals(value)){
					startTime = rs2.getInt("broadcast_start_time");
				}else{
					
					memo = rs2.getString("memo");
					
					
					
//					System.out.println("系统数 .........................mody_broEndTimes.........memo..........."+memo);
					
					if(memo.indexOf("-") >-1) memo = memo.substring(0,memo.indexOf("-"));
					if("".equals(memo))	memo = "00：00";
//					System.out.println("系统数 .........................mody_broEndTimes.........memo......"+ memo +"....."+"：".equals(memo));
//					System.out.println("系统数 .........................mody_broEndTimes........memo......"+ memo +"....."+ (memo.indexOf(":")>-1));
	
					if(memo.indexOf("：")>-1){
						String[] times = memo.split("：");
						int h = Integer.valueOf(times[0]).intValue();
						int m = Integer.valueOf(times[1]).intValue();
						startTime  =h*3600+m*60;
					}
					
					if(memo.indexOf(":")>-1){
						String[] times = memo.split(":");
						int h = Integer.valueOf(times[0]).intValue();
						int m = Integer.valueOf(times[1]).intValue();
						startTime  =h*3600+m*60;
					}
					
//					 System.out.println("系统数 .........................mody_broEndTimes.........startTime..........."+startTime);
				}


				long id = rs2.getLong("ad_resource_workspan_id");
				int adTotalTimes = Integer.parseInt(StringUtil.getNullValue(rs2.getString("sun_length"),"0"));
		    	
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(rs2.getString("mon_length"),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(rs2.getString("tue_length"),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(rs2.getString("thi_length"),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(rs2.getString("wen_length"),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(rs2.getString("fri_length"),"0"));
		    	}
		    	if(adTotalTimes  == 0){
		    		adTotalTimes = Integer.parseInt(StringUtil.getNullValue(rs2.getString("sat_length"),"0"));
		    	}
		
				
				if(startTime >0){
					int endTime = startTime + adTotalTimes;
//		        	 System.out.println(">>>>>>??????????startTime!!!!!!!!!!!!!!!!!!!!!!>>>>>>>>>"+startTime);
//		        	 System.out.println(">>>>>>??????????adTotalTimes!!!!!!!!!!!!!!!!!!!!!!>>>>>>>>>"+adTotalTimes);
//		        	 System.out.println(">>>>>>??????????endTime!!!!!!!!!!!!!!!!!!!!!!>>>>>>>>>"+endTime);
		        	 
		        	 if("1".equals(value)){
		       		    sql = "update tb_ad_resource_workspan set broadcast_end_time = "+ endTime +" where ad_resource_workspan_id=" + id;
		        	 }else{
		        		sql = "update tb_ad_resource_workspan set broadcast_start_time = "+ startTime +",broadcast_end_time = "+ endTime +" where ad_resource_workspan_id=" + id;
		  		        	
		        	 }
		        	 
		        	 System.out.println(">>>>>>sql!!!!!!!!!!!!!!!!!!!!!!>>>>>>>>>"+sql);
		        	 
					excuteSql(sql,curVer);
				}
				
			}
			
			rs2.close();
	
		rs.close();
		
		if(!"1".equals(value)){
			sql =  "update  tb_sys_param set value =1 where name='withBroPoint'";
			excuteSql(sql,curVer);
		}
		
		
	} catch (SQLException e) {

		e.printStackTrace();
	}
}



private void excuteSql(String sql,int version){
	try {
		dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
	} catch (SQLException e) {
		 System.out.println(sql+"/n;系统数据库升级到"+ version +"失败");
//		e.printStackTrace();
	}
}

public List getPriceDetailMatterLengthList() {
	// TODO Auto-generated method stub
	
	return null;
}

public List getCarrierTypeList() {
	// TODO Auto-generated method stub
	return carrierTypeDao.getCarrierTypes(new CarrierType());
}

public Map getCarrierTypeMap() {
	Map mp = new HashMap();
	List  ls = carrierTypeDao.getCarrierTypes(new CarrierType());
	Iterator it = ls.iterator();
	while(it.hasNext()){
		CarrierType carrierType= (CarrierType)it.next();
		mp.put(carrierType.getId().toString(),carrierType);
	}
	return  mp;
}



public Map getCarrierTypeListByParentId(){
	Map mp = new HashMap();
	List  ls = carrierTypeDao.getCarrierTypes(new CarrierType());
	mp.put(new String("0"),ls);
	return mp;
}

public Map getCarriersByType() {
	// TODO Auto-generated method stub
	List ls = carrierDao.getCarriers(new Carrier());
	List noSameTypeID = new ArrayList();
	Map mp = new HashMap();
	Iterator it = ls.iterator();
	while(it.hasNext()){
		Carrier carrierRes = (Carrier)it.next();
		if(!noSameTypeID.contains(carrierRes.getCarrierTypeId())){
			noSameTypeID.add(carrierRes.getCarrierTypeId());
		}
		
	}
	Iterator itn = noSameTypeID.iterator();
	while(itn.hasNext()){
		Long typeId = (Long)itn.next();
		List carriersBytype = getSameCarriersByType(ls,typeId);
//		System.out.println(",<<<,"+typeId+"<<<<<<<<<<<<<<<<<<<<<<<<<<"+carriersBytype);
		mp.put(typeId,carriersBytype);
	}
//System.out.println(",<<<,,"+mp.size());
	return mp;
}

private List getSameCarriersByType(List carriers,Long typeId){
	List ls = new ArrayList();
	Iterator it = carriers.iterator();
	while(it.hasNext()){
		Carrier carrier = (Carrier)it.next();
		if(carrier.getCarrierTypeId().equals(typeId)&&carrier.getParentId().equals("0")){
			ls.add(carrier);
		}
		
	}
	return ls;
}

public Map getUserCarrierRels(boolean isTrue) {
	// TODO Auto-generated method stub
	//	取的所有的频道
	Map mp = new HashMap();
	Carrier carrier = new Carrier();
	carrier.setNodeLevel(new Integer(1));
	
	List ls = carrierDao.getCarrierForChannel(carrier);

	Map carrierMap= getCarriersMap(ls);

	//取得所有用户
	List userList = userDao.getUsers(null);
	


	
	for(Iterator it = userList.iterator();it.hasNext();){
		User user = (User)it.next();
		Long userId = user.getId();
		String userName = user.getUsername();
		//所有用户获得其相对应的频道
		List carrierList = userDao.getUserCarrierRel(userId);


		
		List lsObjs = getCarrierObjectList(carrierMap,carrierList);

//		Collections.sort(lsObjs,new CarrierComparator());

		
		if(isTrue){
//			lsObjs = getCarrierObjectList(carrierMap,carrierList);
			mp.put(userName,lsObjs);
		}else{
			Object[] objs = ConvertUtil.getColFromList(lsObjs,"id");
			List lsCarr = new ArrayList();
			CollectionUtils.addAll(lsCarr,objs);
			mp.put(userName,lsCarr);
		}
	}
	
    if (log.isDebugEnabled()) {
        log.debug("getUserCarrierRels [OK]");
    }

	return mp;
}




private Map getCarriersMap(List allUser){
	   Map mp = new HashMap();
		for(Iterator it = allUser.iterator();it.hasNext();){
			Carrier carrier = (Carrier)it.next();
			mp.put(carrier.getId(),carrier);
		}
	   return mp;
}	

private List getCarrierObjectList(Map carrierMap,List ids){

	   List ls = new ArrayList();
		for(Iterator it = ids.iterator();it.hasNext();){
			Long carrierId = (Long)it.next();
			Carrier carrier = (Carrier)carrierMap.get(carrierId);
			ls.add(carrier);
			
		}
	   return ls;
}

public List getIncomeMode() {
	// TODO Auto-generated method stub
	IncomeMode incomeMode = new IncomeMode();
	return incomeModeDao.getIncomeModes(incomeMode);
}

public List getIncomePourse() {
	// TODO Auto-generated method stub
	IncomePurpose incomePurpos = new IncomePurpose();
	return incomePurposeDao.getIncomePurposes(incomePurpos);
}

public List getCustomerCategory() {
	// TODO Auto-generated method stub
	Category category = new Category();
	return categoryDao.getCategorys(category);
}

public Map getCustomerCategoryMap() {
	// TODO Auto-generated method stub
	Category category = new Category();
	Map mp = new HashMap();
	List cateList =  categoryDao.getCategorys(category);

	for(Iterator it = cateList.iterator();it.hasNext();){
		Category cat = (Category)it.next();
		mp.put(cat.getId().toString(),cat);
	}	
	
	return mp;
	
}

public void saveSysParams(String target,String value,List ls) {
	if(value == null){
		SysParam sysParam = new SysParam();
//		sysParam.setVersion(new Integer(0));
		sysParam.setName(target);
		if(target.equals(Constants.PUBLISH_ORDER_ALERT_STATES)){
			sysParam.setValue("1,");
		}else{
			sysParam.setValue("0");
		}
		
		if(target.equals(Constants.ADRM_SYS_YEAR_PROGRAM_LIST)){
			sysParam.setValue("2006,2007,2008,2009,2010,2011,2012,2013,2014,2015");
		}

		sysParam.setMemo(sysParam.getMenoByName(target));
		
		sysParamDao.saveSysParamByTarger(sysParam);

		ls.add(sysParam);
//		System.out.println(",<<<,saveSysParams+<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+sysParam);
	}else{
		SysParam sysParam = new SysParam();
		sysParam.setName(target);
		sysParam.setValue(value);
		ls.add(sysParam);
//		System.out.println(",<<<,saveSysParams+<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+target);
//		System.out.println(",<<<,saveSysParams+<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+value);
//		System.out.println(",<<<,saveSysParams+<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+sysParam.getName());
	}
	// TODO Auto-generated method stub
	

	
}

public Map getCheckUserRel() {
	Map mp = new HashMap();
	List userList = userDao.getUsers(null);

	for(Iterator it = userList.iterator();it.hasNext();){
		User user = (User)it.next();
		String userName = user.getUsername();
		Long id = user.getId();
		mp.put(userName,userDao.getComeInUserByUserId(id));
	}

	return mp;
}

public Map getUserYearRel() {
	Map mp = new HashMap();
	List userList = userDao.getUsers(null);

	for(Iterator it = userList.iterator();it.hasNext();){
		User user = (User)it.next();
		String userName = user.getUsername();
		String yearsStr = user.getAddress().getCountry();
		if(yearsStr == null) yearsStr ="";
		List ls = new ArrayList();
		
		if(yearsStr.length()>0){
			if(yearsStr.indexOf(",")>-1){
				CollectionUtils.addAll(ls,yearsStr.split(","));
			}else{
				ls.add(yearsStr);
			}
		}
		mp.put(userName,ls);
	}

	return mp;
}

public Map getResourceYearTypeMap() {
	Map mpYear = new HashMap();
	List us = this.getResourceNameList();

	for(Iterator it = us.iterator();it.hasNext();){
		Resource resource = (Resource) it.next();
		String key = resource.getVersion()+"_"+resource.getResourceType();
		
		if(mpYear.containsKey(key)){
			Map  resMap = (Map)mpYear.get(key);
			resMap.put(""+resource.getId(),resource);
			mpYear.put(key,resMap);
		}else{
			Map resMap = new HashMap();
			resMap.put(""+resource.getId(),resource);
			mpYear.put(key,resMap);
		}
		
	}
	return mpYear;
}

public Map getOtherSameAlisnameId() {
	Map mp = new HashMap();
	Map mptemp = new HashMap();
	Carrier carrier = new Carrier();
	carrier.setNodeLevel(new Integer(1));
	
	List ls = carrierDao.getCarrierForChannel(carrier);
	
	for(Iterator it = ls.iterator();it.hasNext();){
		Carrier car = (Carrier)it.next();
		String alisname = car.getAliasName();
		alisname = ("".equals(alisname) || alisname == null)?car.getCarrierName():alisname;
		if(mptemp.containsKey(alisname)){
			String idStr = (String)mptemp.get(alisname);
			idStr = idStr+","+car.getId().toString();
			mptemp.put(alisname,idStr);
		}else{
//			Map mp2 = new HashMap();
			mptemp.put(alisname,car.getId().toString());
		}
	}
	
	
	
	for(Iterator it = ls.iterator();it.hasNext();){
		Carrier car = (Carrier)it.next();
		String id = car.getId().toString();
		String alisname = car.getAliasName();
		alisname = ("".equals(alisname) || alisname == null)?car.getCarrierName():alisname;
		String ids = (String)mptemp.get(alisname);
		mp.put(id,ids); 

	}
	
	// TODO Auto-generated method stub
	return mp;
}

public List getUserCustomerTypeRels() {
	
//	System.out.println(">>>>>cutTypes>>>222222222222222222222222222222222222222222>>>" );
	
	List resList = new ArrayList();
	Map mpAll = new HashMap();
	
	
    List users = userDao.getUsers(new User());
    
    List all = categoryDao.getCategorys(null);
    String cutTypes = "";
	for(Iterator it = all.iterator();it.hasNext();){
		Category category = (Category)it.next();
		mpAll.put(category.getId().toString(),category);
		long id = category.getId().longValue();
		if(id>1){
			cutTypes = cutTypes + id+",";
		}
	}
	
	 String[] s2 = cutTypes.split(",");
	 Category category1 = (Category)mpAll.get("1");
	 

	 
    
	System.out.println(">>>>>cutTypes>>>>>>" +cutTypes);
   
    Map mp  = new HashMap();
    Map mp2  = new HashMap();
    User user = null;

    for (int i = 0; i < users.size(); i++) {
    	user = (User) users.get(i);
    	String cutType = user.getAddress().getCity();
    	
    	if(cutType == null || "".equals(cutType)) cutType = "0";
    	
    	if( "Denver".equals(cutType)) cutType = cutTypes;
    	
    	 List list = new ArrayList();
    	 List list2 = new ArrayList();
    	 
		list.add("1");
		list2.add(category1);
//		list2.add(categoryDao.getCategory(new Long("1")));
		
	
    	 
    	if(cutType.indexOf(",")>-1){
    		 String[] s = cutType.split(",");
    		 for(int j = 0;j<s.length;j++){
    			  if(StringUtil.isHave(s2,s[j])){
        			  list.add(s[j]);
//        			  list2.add(categoryDao.getCategory(new Long(s[j])));  
        			  list2.add( (Category)mpAll.get(s[j]));  
    			  }
    		 }
    	}else{
    		if(StringUtil.isHave(s2,cutType)){
    	
    	    		if(!"0".equals(cutType)){
    	    			list.add(cutType);
//    	    			list2.add(categoryDao.getCategory(new Long(cutType)));
    	    			list2.add( (Category)mpAll.get(cutType));  
    	    		}
    		}
    	}
    	

//		if("邹振东".equals(user.getFullName())){
//			System.out.println(">>>>>cutTypes>>>22222222222222222222222222"+ user.getUsername()+"222222222"+ list +"2222<"+ list2.size() +">222>>>"+cutType );

		
    	
    	mp.put(user.getUsername(),list);
    	mp2.put(user.getUsername(),list2);
    }
    
    resList.add(0,mp);
    resList.add(1,mp2);

    return resList;
}

public Map getUserCarrierSortMap() {
	

    List users = userDao.getUserCarrierSortList();

    Map mp  = new HashMap();
    
    User user = null;

    for (int i = 0; i < users.size(); i++) {
    	

    	
    	user = (User) users.get(i);
    	String username  = user.getUsername();
//    	String carrierType= user.getEmail()+"_"+user.getFirstName();
    	String carrierType= user.getOrgId()+"_"+user.getBranchName();
    	String carrierId = user.getWebsite();
    

    	
    	if(mp.containsKey(username)){
			Object obj1 = mp.get(username);
			Map mp1 = new HashMap();
			if(obj1 != null) {  
				mp1 = (Map)obj1;
			}
    		

			
    		if(mp1.containsKey(carrierType)){
    			Object obj = mp1.get(carrierType);
    			if(obj != null) {
    				List ls = (List)obj;
    				if(!"".equals(carrierId)) ls.add(carrierId);
    			}
    			
    			
    		}else{
    			List ls = new ArrayList();
    			ls.add(carrierId);
    			mp1.put(carrierType,ls);
    		}
    		mp.put(username,mp1);
    	}else{
    		List ls = new ArrayList();
    		ls.add(carrierId);
    		Map mp1  = new HashMap();
    		mp1.put(carrierType,ls);
    		mp.put(username,mp1);
    	}
    }
    
    
    return mp;
}



public int executeUpdateScript(String filePath,String delimiter,boolean fullLineDelimiter){
	
	DataSource dataSource= dao.getDefaultDataSource();
	try {
		Connection conn = dataSource.getConnection();

		try {
			File file =   Resources.getResourceAsFile(filePath);
			InputStream sqlFileIn = new FileInputStream(file);
			InputStreamReader reader= new InputStreamReader(sqlFileIn, "UTF-8");  
			ScriptRunner runner = new ScriptRunner(conn, false, false);
			runner.setDelimiter(delimiter,fullLineDelimiter);
			runner.setLogWriter(null);
			runner.setErrorLogWriter(null);
			runner.runScript(reader);
			conn.commit();
			reader.close();  

		} finally {
			conn.close();
		}  
	}catch (Exception e) {  
		       throw new RuntimeException("Description.  Cause: " + e, e);  

	}  
	return 1;
}


public  Map getUserOrgs(){
	Map mpObj = new HashMap();
	
//    List users = userDao.getUserCarrierSortList();
	
    List users = userDao.getUsers(null);
    
    for (int i = 0; i < users.size(); i++) {
    	    User user = (User) users.get(i);
            String loginUser = user.getUsername();
            String loginUserId = user.getId().toString();
            Map mp2 = new HashMap();
            List ls = new ArrayList();
            if("admin".equals(loginUser)){
            	ls = orgDao.getOrgs(null);
            }else{
//            	 mp2.put("loginUser",loginUser);	
            	 
//            	 ls = orgDao.getUserOrgs(mp2);
            	 
            	 List lsOrgIds = userDao.getUserOrgs(loginUserId);
            	 if(lsOrgIds.size()>1) lsOrgIds.add("1");

//            	 log.info(">>>>>>>>>>>>>getUserOrgs>>>>>>>ffffff>"+ loginUser +">>>>>"+ loginUserId +"777777777777777777777777777777777777777777>>>>>>>" +lsOrgIds);

            	 mp2.put("orgIdList",lsOrgIds);	
            	 
            	 ls = orgDao.getUserOrgs_new(mp2);
            	 
            }
//            log.info(">>>>>>>>>>>>>getGlobalParams>>>lsOrgs>>>>>"+ loginUser +">>>>>>>>>>>>>>>>>777777777777777777777777777777777777777777>>>>>>>" +((Org)ls.get(0)).getName());

             
            Iterator it = ls.iterator();
		    List orgList = new ArrayList();
			while(it.hasNext()){
				Org org = (Org)it.next();
				orgList.add(org);
			}
			mpObj.put(loginUser,orgList);
    }

	return mpObj;
}
/**
 * @param incomeModeDao The incomeModeDao to set.
 */

public List getOrgs() {
	// TODO Auto-generated method stub
	return orgDao.getOrgs(null);
}

public  Map getOrgByCarrier(){
	
	
	return null;
}



public  String getGlobalParamsJson(List ls){

	   StringBuffer sb = new StringBuffer();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       String serviceDate = sdf.format(new Date());
	   
	   Iterator it = ls.iterator();
	   sb.append("{");
		while (it.hasNext()){
			 SysParam sysParam = (SysParam)it.next();
//			 log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ sysParam.getName() +">>>>" +sysParam.getValue());
			 sb.append(sysParam.getName()+":\""+sysParam.getValue()+"\",");
		}

		sb.append("serviceDate:\""+ serviceDate +"\"");
		sb.append("loginName:\""+"adrm_logined_user\"");
		sb.append("userId:\""+"adrm_userId\"");
		sb.append("fullName:\""+"adrm_fullName\"");
		sb.append("usrOrgIds:\""+"adrm_usrOrgIds\"");
		sb.append("isFirstLogin:\""+"adrm_isFirstLogin\"");
		sb.append("incomeMessageAlert:\""+"adrm_incomeMessageAlert\"");	
		sb.append("cuikMessageAlert:\""+"adrm_cuikMessageAlert\"");

		sb.append("}");
		
	   return sb.toString();
}


public  Map getGlobalParamsMap(List ls){
//	   String s = this.getGlobalParamsJson(ls);
//	   log.info("getGlobalParamsMap1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +s);
//	   s = JsonUtil.encodeString(s);
//	   log.info("getGlobalParamsMap2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +s);

	   Map map = new HashMap();  
	   
	   map.put("version",Constants.SYSTEM_ADRM_VERSION);

	   Iterator it = ls.iterator();
		while (it.hasNext()){
			 SysParam sysParam = (SysParam)it.next();
//			 log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ sysParam.getName() +">>>>" +sysParam.getValue());
			 String value = sysParam.getValue();
			 value = value == null|| "".equals(value)?"0":value;
			 map.put(sysParam.getName(),value);
		}

       return map;
	   
}
//
//private void initQuartzMysqlDB() {
//
//	String realpath = SysUtil.getAddress();
//	String resourceFile = realpath+  "/applicationContext-resources.xml";
//    String _username = "root";
//    String _passwd = "root";
//    try {
//		Map mp = ReadConfig.read(resourceFile);
//		_username = StringUtil.getNullValue(mp.get("username"),"root");
//		_passwd =  StringUtil.getNullValue(mp.get("password"),"");
//		
//		
//	} catch (NullPointerException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	try {
//		Class.forName("com.mysql.jdbc.Driver"); 
//
//	    Connection conQuartz=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quartz",_username,_passwd); 
//	    conQuartz.close();
//
//	    log.info("initQuartzMysqlDB>>>>>>>>>>>>>conQuartz isExit>>>>>>>>>9999999999999999999999999999999999>>>>>>");
//	    
//	   } catch (SQLException e) {
//	    // TODO Auto-generated catch block
//		   try {
//			    String url = "mysql://localhost/quartz";
//			    String _databaseName = "quartz";
//			    String _scriptFile = Constants.FILE_PATH_SQL_SCRIPT +"/quartz_mysql.sql";
//			    String _fileName = Constants.FILE_PATH_SQL_SCRIPT +"/quartz_mysql.sql";
//			    String sqlFile = Resources.getResourceAsFile(_fileName).getAbsolutePath();
//
//			    log.info("initQuartzMysqlDB>>>>>>>>>>>>conQuartz not exit>>>>>>>>>>>>9999999999999999999999999999999999>>>>>>"+ sqlFile);
//				new  DBLoader("mysql",_databaseName,_scriptFile,_fileName,_username,_passwd);
//				
//				
//
//				
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		   
//		   
//		   e.printStackTrace();
//
//	   }catch (ClassNotFoundException e) { 
//		   e.printStackTrace(); 
//	   } 
//
//
//}

public List finaciaAuditFitter() {
	
	List ls = new ArrayList();
	String swit = "false";
	SysParam param = new SysParam();
//	param.setName(Constants.FINANCIA_AUDIT_PARAM);
	param.setName(Constants.FINANCIAL_AUDIT_SWITCH);
	
	SysParam sysParam = sysParamDao.getSysParam(param);	
	String value =  StringUtil.getNullValue(sysParam.getValue(),"");	
	
//	 System.out.println("Constants.FINANCIAL_AUDIT_SWITCH .......666666666666666666666666666666666..............."+value);
	 
	//过滤开关
	if("".equals(value) || "0".equals(value)|| "false".equals(value)) {
		swit= "false";
	}else{
		swit= "true";
	}
	
//	 System.out.println("Constants.FINANCIAL_AUDIT_SWITCH .......swit 666666666666666666666666666666666..............."+swit);
	 
	//过滤订单类别
	Map mp1 = OrderCateFitterUtil.getFitterIds3(1);
    //过滤到款用途
	Map mp2 = OrderCateFitterUtil.getFitterIds3(2);
	
	
	//过滤订单类别
	Map mp3 = OrderCateFitterUtil.getFitterIds3(3);
    //过滤到款用途
	Map mp4 = OrderCateFitterUtil.getFitterIds3(4);

	ls.add(swit);ls.add(mp1);ls.add(mp2);ls.add(mp3);ls.add(mp4);
	
	return ls;
	
	
	
	
	
}

}
