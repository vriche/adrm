
package com.vriche.adrm.dao.ibatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.OaWorkFlowCheckDao;
import com.vriche.adrm.model.OaWorkFlowCheck;

public class OaWorkFlowCheckDaoiBatis extends BaseDaoiBATIS implements OaWorkFlowCheckDao {

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#getOaWorkFlowChecks(com.vriche.adrm.model.OaWorkFlowCheck)
     */
    public List getOaWorkFlowChecks(final OaWorkFlowCheck oaWorkFlowCheck) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowChecks", oaWorkFlowCheck);
    }
    
    

	/**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#getOaWorkFlowChecksCount(com.vriche.adrm.model.OaWorkFlowCheck)
     */
    public Integer getOaWorkFlowChecksCount(final OaWorkFlowCheck oaWorkFlowCheck) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaWorkFlowChecksCount", oaWorkFlowCheck);
    }
     /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#getOaWorkFlowChecksPage(com.vriche.adrm.model.OaWorkFlowCheck)
     */   
  	public PaginatedList getOaWorkFlowChecksPage(final OaWorkFlowCheck oaWorkFlowCheck,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaWorkFlowChecks",oaWorkFlowCheck,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#getOaWorkFlowChecksByIdList(com.vriche.adrm.model.OaWorkFlowCheck)
     */
    public List getOaWorkFlowChecksByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaWorkFlowChecksByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#getOaWorkFlowCheck(Long id)
     */
    public OaWorkFlowCheck getOaWorkFlowCheck(Long id) {
        OaWorkFlowCheck oaWorkFlowCheck = (OaWorkFlowCheck) getSqlMapClientTemplate().queryForObject("getOaWorkFlowCheck", id);

        if (oaWorkFlowCheck == null) {
            throw new ObjectRetrievalFailureException(OaWorkFlowCheck.class, id);
        }

        return oaWorkFlowCheck;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#saveOaWorkFlowCheck(OaWorkFlowCheck oaWorkFlowCheck)
     */    
    public Long saveOaWorkFlowCheck(final OaWorkFlowCheck oaWorkFlowCheck) {
        Long id = oaWorkFlowCheck.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaWorkFlowCheck", oaWorkFlowCheck);
        } else {
            getSqlMapClientTemplate().update("updateOaWorkFlowCheck", oaWorkFlowCheck);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaWorkFlowCheck.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#removeOaWorkFlowCheck(Long id)
     */
    public void removeOaWorkFlowCheck(Long id) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowCheck", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaWorkFlowCheckDAO#removeOaWorkFlowChecks(String ids)
     */
    public void removeOaWorkFlowChecks(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaWorkFlowChecks", idList);
    }



	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#saveOaWorkFlowCheckContracts(java.util.Map)
	 */
	public void saveOaWorkFlowCheckContracts(Map mp) {
		getSqlMapClientTemplate().update("saveOaWorkFlowCheckContracts", mp);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#saveOaWorkFlowCheckOrders(java.util.Map)
	 */
	public void saveOaWorkFlowCheckOrders(Map mp) {
		getSqlMapClientTemplate().update("saveOaWorkFlowCheckOrders", mp);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#saveOaWorkFlowCheckApplys(java.util.Map)
	 */
	public void saveOaWorkFlowCheckApplys(Map mp) {
		getSqlMapClientTemplate().update("saveOaWorkFlowCheckApplys", mp);
	}



	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#updateOaWorkFlowCheckState(java.util.Map)
	 */
	public void updateWorkFlowCheckStates(Map mp) {
		getSqlMapClientTemplate().update("updateWorkFlowCheckStates", mp);
	}



	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#updateWorkFlowChecked(java.util.Map)
	 */
	public void updateContractChecked(Map mp) {
		getSqlMapClientTemplate().update("updateContractChecked", mp);
		
	}


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#updateOrderChecked(java.util.Map)
	 */
	public void updateOrderChecked(Map mp) {
		getSqlMapClientTemplate().update("updateOrderChecked", mp);
		
	}    
    

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.OaWorkFlowCheckDao#updateOaEventsChecked(java.util.Map)
	 */
	public void updateApplyChecked(Map mp) {
		getSqlMapClientTemplate().update("updateApplyChecked", mp);
		
	}



	public List getOaWorkFlowChecks(Long id) {
//		System.out.println("id11111111111111111:>>>>>>>>>>" + id);
		List ls =  getSqlMapClientTemplate().queryForList("getWorkFlowCheckByContractId",id);
//		System.out.println("ls.size11111111111111111:>>>>>>>>>>" + ls.size());
		return ls;
	}



	public List getOaWorkFlowChecksByOrderId(Long id) {
//		System.out.println("id11111111111111111:>>>>>>>>>>" + id);
		List ls =  getSqlMapClientTemplate().queryForList("getWorkFlowCheckByOrderId",id);
//		System.out.println("ls.size11111111111111111:>>>>>>>>>>" + ls.size());
		return ls;
	}	
  
	
	public Object getOrderCheckLastTime(Long id) {
//		System.out.println("id11111111111111111:>>>>>>>>>>" + id);
		return getSqlMapClientTemplate().queryForObject("getOrderCheckLastTime",id);
//		System.out.println("ls.size11111111111111111:>>>>>>>>>>" + ls.size());

	}
	
}
