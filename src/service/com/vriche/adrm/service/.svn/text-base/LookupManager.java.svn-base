package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.vriche.adrm.dao.LookupDao;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.SysParam;

/**
 * Business Service Interface to talk to persistence layer and
 * retrieve values for drop-down choice lists.
 *
 * <p>
 * <a href="LookupManager.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupManager extends Manager {
    //~ Methods ================================================================

	
    public void setLookupDao(LookupDao dao);
    
    /**
     * Retrieves all possible roles from persistence layer
     * @return List
     */
    public List getAllRoles();
    
    public Object[] getBranchs();
    
    public List getUserCustomerTypeRels();
    
    public Org getOrg();
    
    public List getOrgs();
    
    public void saveOrgLogoToFile(String filePath,byte[] fileData);
    
    public SysParam getSysParams();
    
    public void saveSysParams(String target,String value,List ls);
    
    public Map getUserRels(boolean isObjs);
    
    public Map getBranchMapById();
    
    public Map getResourceMap();
    
    public Map getOrderCatelogMap();
    
    public List getInduStryList();
    
    public Map getInduStryMap();
    
    public List getResourceSortList();
    
    public Map getResourceNameMap();
    
    public Map getResourceYearTypeMap();
    
    public List getOrderCatelogParentList();
    
    public List getSpecificList();
    
    public Map getSpecificMap();
    
    public List getPriceTypeList();
    
    public List getSysUserList();
    
    public Map getSysUserMap(int i);
    
//    public Map getSysUserRigthsMap(ServletContext context);
    
    public List getPriceLengthDetail();
    
    public List getCarriersAll();
    
    public Map getCarriersAllMap();
    
    public Map getCarrierMap();
    
    public Map getCarrierMap2();
    
    public Map getCarrierMapNoMyslfe();
    
    public Map getSameMatterName();
    
    public Map getOrderListCatagory();
    
    public Map getOrderListCatagoryName();
    
    public List getOaWorkFlowCheckStateList();
    
    public void excuteSql();
    
    public List getPriceDetailMatterLengthList();
    
    public List getCarrierTypeList();
    
    public Map getCarrierTypeMap() ;
    
    public Map getCarrierTypeListByParentId();
    
    public Map getCarriersByType();
    
    public Map getUserCarrierRels(boolean isTrue);
    
    public List getIncomeMode();
    
    public List getIncomePourse();
    
    public List getCustomerCategory();
    
    public Map getCheckUserRel();
    
    public Map getCustomerRel();
    
    public Map getUserYearRel();
    
    public Map getOtherSameAlisnameId();
    
    public Map getUserCarrierSortMap();
    
    public  Map getUserOrgs();
    
    public  String getGlobalParamsJson(List ls);
    
    public  Map getGlobalParamsMap(List ls);
    
    public Map getCustomerCategoryMap() ;
    
    public List finaciaAuditFitter();
    
    
    
//    public  void initQuartzMysqlDB();
    	

    
//    public  Map getOrgByCarrier();
    

    
}
