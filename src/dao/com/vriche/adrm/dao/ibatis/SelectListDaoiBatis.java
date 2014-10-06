/****************************************************************************     
 * Created on 2006-10-31                                                    *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.vriche.adrm.dao.SelectListDao;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.Price;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.User;

/**
 * SelectListDaoiBatis class
 * 
 * This class is used to 
 * 
 * <p><a href="SelectListDaoiBatis.java.html"><i>View Source</i></a></p>
 */
public class SelectListDaoiBatis extends SqlMapClientDaoSupport implements SelectListDao {

    /* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.SelectListDao#getOrderCategory(java.lang.String)
     */
    public List getOrderCategory(String level) {
        // TODO Auto-generated method stub

        return  getSqlMapClientTemplate().queryForList("getOrderCategoryLevelFirst", null);
    }
    
    public List getOrderCategoryLevelSecond(String parentId) {
        // TODO Auto-generated method stub

        return  getSqlMapClientTemplate().queryForList("getOrderCategoryLevelSecond", parentId);
    }

    /* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.SelectListDao#getUser(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getUser(String level, User user) {
        // TODO Auto-generated method stub
        return getSqlMapClientTemplate().queryForList("getUsers", user);
    }
    
    

    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.SelectListDao#getIndustry(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getIndustry(String level, User user) {
        // TODO Auto-generated method stub
        return getSqlMapClientTemplate().queryForList("getIndustrys", null);
    }

    /* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.SelectListDao#getCarrier(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getCarrier(String level, User user) {
        // TODO Auto-generated method stub
        return getSqlMapClientTemplate().queryForList("getCarriersByLevel", level);
    }


    public List getResourceType(String level, User user) {
		// TODO Auto-generated method stub
    	 return getSqlMapClientTemplate().queryForList("getResourceTypes", level);
	}

	public List getCarrierTypes(String level, User user) {
    	return getSqlMapClientTemplate().queryForList("getCarrierTypesByLevel", level);
	}
    
    public List getMediaOrgs(String level, User user) {
    	return getSqlMapClientTemplate().queryForList("getMediaOrgs", level);
	}
        


	public List getResourceChannels(String level, User user) {
		return getSqlMapClientTemplate().queryForList("getResourceChannels", level);
	}

	/* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.SelectListDao#getResourceInfo(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getResourceInfo(String carrierId, User user) {
        // TODO Auto-generated method stub
        return getSqlMapClientTemplate().queryForList("getResourcesByCarrierId", carrierId);
    }
    
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.SelectListDao#getResourceSpecific(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getResourceSpecific(String level, User user) {
        // TODO Auto-generated method stub
        return getSqlMapClientTemplate().queryForList("getSpecifics", null);
    }
    /* (non-Javadoc)
     * @see com.vriche.adrm.order.dao.SelectListDao#getResourcePriceType(java.lang.String, com.vriche.adrm.order.model.User)
     */
    public List getResourcePriceType(String level, User user) {
        // TODO Auto-generated method stub
        return getSqlMapClientTemplate().queryForList("getPriceTypes", null);
    }
    
    
    public List getPrices(Long resourceInfoId, String length) {
	   	 Map mPara = new HashMap();
	   	 mPara.put("resourceInfoId",resourceInfoId);
	   	 mPara.put("length",length);
	   	 return getSqlMapClientTemplate().queryForList("getPriceByResourceLength", mPara);
	}

    
    
    public Map getPricesMap(Long resourceInfoId, String length,User user){
    	   List ls = this.getPrices(resourceInfoId,length);
           Map reply = new LinkedHashMap();
           Iterator it = ls.iterator();
//           reply.put( "0","");
           while (it.hasNext()){
        	   Price price = new Price();
        	   price = (Price)it.next();
               reply.put( price.getResourcePriceType(),price.getPriceDetail().getPrice());
           }
//           System.out.println("reply ==>>" + reply);
           return reply;
           
    }

    

	public Map getOrderCategoryLevelSecondMap(String parentId) {
        
        List ls = this.getOrderCategoryLevelSecond(parentId);
        
        Map reply = new LinkedHashMap();
        Iterator it = ls.iterator();
        
//        reply.put( "0","");
        while (it.hasNext()){
            OrderCategory orderCategory = new OrderCategory();
            orderCategory = (OrderCategory)it.next();
            reply.put( orderCategory.getId(),orderCategory.getName()+" || "+orderCategory.getValue());
        }
        
        return reply;
    }
    
    public Map getResourceInfoMap(String carrierId, User user) {
        
        List ls = this.getResourceInfo(carrierId,user);
        
        Map reply = new LinkedHashMap();
        
        Iterator it = ls.iterator();
        
        reply.put( "0","");
        
        while (it.hasNext()){
            Resource resource = new Resource();
            resource = (Resource)it.next();
            reply.put( resource.getId(),resource.getResourceName());
        }
        
        return reply;
    }

	public List getCustomerNames(String level, User user) {
	      return getSqlMapClientTemplate().queryForList("getCustomers", null);
	}

	public List getCustomerType(String level, User user) {
		 return getSqlMapClientTemplate().queryForList("getCustomerTypes", null);
	}

	public List getCustomerCategory(String level, User user) {
		 return getSqlMapClientTemplate().queryForList("getCustomerCategorys", level);
	}

	public List getIncomeMode(String level, User user) {
		return getSqlMapClientTemplate().queryForList("getIncomeModes", level);
	}

	public List getIncomePurpose(String level, User user) {
		return getSqlMapClientTemplate().queryForList("getIncomePurposes", level);
	}
	
	

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaAreaCity()
	 */
	public List getOaAreaCity(String level, User user) {
		return getSqlMapClientTemplate().queryForList("getOaAreaCitys",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaAreaPc()
	 */
	public List getOaAreaPc(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaAreaPcs",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaAssetsState()
	 */
	public List getOaAssetsState(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaAssetsStates",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaAssetsType()
	 */
	public List getOaAssetsType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaAssetsTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaDocPermitType()
	 */
	public List getOaDocPermitType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaDocumentCatalogPermitTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaInfoType()
	 */
	public List getOaInfoType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaInfoTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaProductType()
	 */
	public List getOaProductType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaProductTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaWorkFlowResult()
	 */
	public List getOaWorkFlowResult(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaWorkFlowCheckResults",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getOaWorkFlowType()
	 */
	public List getOaWorkFlowType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaWorkFlowTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getSysBranch()
	 */
	public List getSysBranch(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getBranchs",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getSysEventState()
	 */
	public List getSysEventState(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getSysEventStates",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getSysEventType()
	 */
	public List getSysEventType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getSysEventTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getSysPromptMode()
	 */
	public List getSysPromptMode(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getSysPromptModes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getSysUserType()
	 */
	public List getSysUserType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getSysUserTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getSysOrg(java.lang.String, com.vriche.adrm.model.User)
	 */
	public List getSysOrg(String level, User user,Org org2) {

		return getSqlMapClientTemplate().queryForList("getOrgs2",org2);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getWorkFlowMoveTypes(java.lang.String, com.vriche.adrm.model.User)
	 */
	public List getWorkFlowMoveTypes(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaWorkFlowMoveTypes",null);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.SelectListDao#getWorkFlowCheckState(java.lang.String, com.vriche.adrm.model.User)
	 */
	public List getWorkFlowCheckState(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOaWorkFlowCheckStates",null);
	}

	public List getResourceSort(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getResourceSorts",null);
	}

	public List getMatterType(String level, User user) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getMatterTypes",null);
	}

	public List getUserByOrg(String orgId) {
		 Map mp = new HashMap();
		 mp.put("orgId",orgId);
		 return getSqlMapClientTemplate().queryForList("getUsersByBranchIdList", mp);
	}   
	


}
