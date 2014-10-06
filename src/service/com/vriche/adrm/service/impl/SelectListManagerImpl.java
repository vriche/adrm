/****************************************************************************     
 * Created on 2006-10-31                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.service.impl;

//import java.util.Iterator;
//import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import com.vriche.adrm.adres.model.Resource;
//import com.vriche.adrm.order.model.OrderCategory;
import com.vriche.adrm.dao.SelectListDao;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.Price;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.SelectListManager;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;

/**
 * SelectListManagerImpl class
 * 
 * This class is used to 
 * 
 * <p><a href="SelectListManagerImpl.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * @hibernate.class table="SelectListManagerImpl"
 * 
 */
public class SelectListManagerImpl extends BaseManager  implements SelectListManager {
    
    private SelectListDao dao;
    
    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSelectListDao(SelectListDao dao) {
        this.dao = dao;
    }

    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getOrderCategory(java.lang.String)
     */
    public List getOrderCategory(String level) {
        // TODO Auto-generated method stub
        return dao.getOrderCategory(level);
    }
    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getIndustry(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getIndustry(String level, User user) {
        // TODO Auto-generated method stub
        return dao.getIndustry(level,user);
    }
    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getOrderCategoryLevelSecond(java.lang.String)
     */
    public List getOrderCategoryLevelSecond(String parentId) {
        // TODO Auto-generated method stub
        return dao.getOrderCategoryLevelSecond(parentId);
    }
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getOrderCategoryLevelSecondMap(java.lang.String)
     */
    public Map getOrderCategoryLevelSecondMap(String parentId) {
        
        return dao.getOrderCategoryLevelSecondMap(parentId);
    }
    




	public Map getPricesMap(String resourceInfoId, String length, User user) {
		// TODO Auto-generated method stub
		return dao.getPricesMap(new Long(resourceInfoId),length,user);
	}
    

	/* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getUser(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getUser(String level, User user) {
        // TODO Auto-generated method stub
        return dao.getUser(level,user);
    }
    
    

    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getCarrier(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getCarrier(String level, User user) {
        // TODO Auto-generated method stub
        return dao.getCarrier(level,user);
    }
  
    
    

    public List getResourceType(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getResourceType(level,user);
	}

	public List getCarrierTypes(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getCarrierTypes(level,user);
	}
    
    
    public List getMediaOrgs(String level, User user) {
   	 return dao.getMediaOrgs(level,user);
	}
    
    

	public List getResourceChannels(String level, User user) {
		 return dao.getResourceChannels(level,user);
	}

	/* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getResourceInfo(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getResourceInfo(String level, User user) {
        // TODO Auto-generated method stub
        return dao.getResourceInfo(level,user);
    }
    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getResourceInfoMap(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public Map getResourceInfoMap(String carrierId, User user) {
 
        return dao.getResourceInfoMap(carrierId,user);
    }   
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getResourceSpecific(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getResourceSpecific(String level, User user) {
        // TODO Auto-generated method stub
        return dao.getResourceSpecific(level,user);
    }
    
    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.service.SelectListManager#getResourcePriceType(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getResourcePriceType(String level, User user) {
        // TODO Auto-generated method stub
        return dao.getResourcePriceType(level,user);
    }

	public List getCustomerNames(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getCustomerNames(level,user);
	}

	public List getCustomerType(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getCustomerType(level,user);
	}

	public List getCustomerCategory(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getCustomerCategory(level,user);
	}

	public List getIncomeMode(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getIncomeMode(level,user);
	}

	public List getIncomePurpose(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getIncomePurpose(level,user);
	}
	

	
	
	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaAreaCity()
	 */
	public List getOaAreaCity(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaAreaCity(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaAreaPc()
	 */
	public List getOaAreaPc(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaAreaPc(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaAssetsState()
	 */
	public List getOaAssetsState(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaAssetsState(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaAssetsType()
	 */
	public List getOaAssetsType(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaAssetsType(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaDocPermitType()
	 */
	public List getOaDocPermitType(String level,User user) {
		// TODO Auto-generated method stub
		return dao. getOaDocPermitType(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaInfoType()
	 */
	public List getOaInfoType(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaInfoType(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaProductType()
	 */
	public List getOaProductType(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaProductType(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaWorkFlowResult()
	 */
	public List getOaWorkFlowResult(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaWorkFlowResult(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getOaWorkFlowType()
	 */
	public List getOaWorkFlowType(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getOaWorkFlowType(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getSysBranch()
	 */
	public List getSysBranch(String level,User user) {
		// TODO Auto-generated method stub
		return dao. getSysBranch(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getSysEventState()
	 */
	public List getSysEventState(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getSysEventState(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getSysEventType()
	 */
	public List getSysEventType(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getSysEventType(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getSysPromptMode()
	 */
	public List getSysPromptMode(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getSysPromptMode(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getSysUserType()
	 */
	public List getSysUserType(String level,User user) {
		// TODO Auto-generated method stub
		return dao.getSysUserType(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getSysOrg(java.lang.String, com.vriche.adrm.model.User)
	 */
	public List getSysOrg(String level, User user) {
		// TODO Auto-generated method stub
		
		Org org2 = new Org();
//		if(SysParamUtil.useMoreCarrierSortParam()){
//			if(!UserUtil.isSuperUser()){
//				String orgAdminId = UserUtil.getCurrentPrincipalUserId();
//				org2.setCreateBy(new Long(orgAdminId));
//				
//				System.out.println("getMediaOrgs orgAdminId>>>>>>>>" +orgAdminId);
//			}
//		}
//		
		return dao.getSysOrg(level,user,org2);
	}
	
	public List getParentSysOrg() {
		// TODO Auto-generated method stub
		
		Org org2 = new Org();
		org2.setParentId("0");
//		if(SysParamUtil.useMoreCarrierSortParam()){
//			if(!UserUtil.isSuperUser()){
//				String orgAdminId = UserUtil.getCurrentPrincipalUserId();
//				org2.setCreateBy(new Long(orgAdminId));
//				
//				System.out.println("getMediaOrgs orgAdminId>>>>>>>>" +orgAdminId);
//			}
//		}
//		
		return dao.getSysOrg(null,null,org2);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getWorkFlowMoveTypes(java.lang.String, com.vriche.adrm.model.User)
	 */
	public List getWorkFlowMoveTypes(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getWorkFlowMoveTypes(level,user);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.service.SelectListManager#getWorkFlowCheckState(java.lang.String, com.vriche.adrm.model.User)
	 */
	public List getWorkFlowCheckState(String level, User user) {
		return dao.getWorkFlowCheckState(level,user);
	}

	public List getResourceSort(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getResourceSort(level,user);
	}

	public List getMatterType(String level, User user) {
		// TODO Auto-generated method stub
		return dao.getMatterType(level,user);
	}

	public List getUserByOrg(String orgId) {
		// TODO Auto-generated method stub
		 return dao.getUserByOrg(orgId);
	}




}
