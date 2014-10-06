
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ContractTarget;
import com.vriche.adrm.dao.ContractTargetDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractTargetDaoiBatis extends BaseDaoiBATIS implements ContractTargetDao {

    /**
     * @see com.vriche.adrm.dao.ContractTargetDao#getContractTargets(com.vriche.adrm.model.ContractTarget)
     */
    public List getContractTargets(final ContractTarget contractTarget) {
          return getSqlMapClientTemplate().queryForList("getContractTargets", contractTarget);
    }
     /**
     * @see com.vriche.adrm.dao.ContractTargetDao#getContractTargetsCount(com.vriche.adrm.model.ContractTarget)
     */
    public Integer getContractTargetsCount(final ContractTarget contractTarget) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getContractTargetsCount", contractTarget);
    }
     /**
     * @see com.vriche.adrm.dao.ContractTargetDao#getContractTargetsPage(com.vriche.adrm.model.ContractTarget)
     */   
  	public PaginatedList getContractTargetsPage(final ContractTarget contractTarget,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getContractTargets",contractTarget,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.ContractTargetDao#getContractTargetsByIdList(com.vriche.adrm.model.ContractTarget)
     */
    public List getContractTargetsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getContractTargetsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.ContractTargetDao#getContractTarget(Long id)
     */
    public ContractTarget getContractTarget(Long id) {
        ContractTarget contractTarget = (ContractTarget) getSqlMapClientTemplate().queryForObject("getContractTarget", id);

        if (contractTarget == null) {
            throw new ObjectRetrievalFailureException(ContractTarget.class, id);
        }

        return contractTarget;
    }

    /**
     * @see com.vriche.adrm.dao.ContractTargetDao#saveContractTarget(ContractTarget contractTarget)
     */    
    public Long saveContractTarget(final ContractTarget contractTarget) {
        Long id = contractTarget.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addContractTarget", contractTarget);
        } else {
            getSqlMapClientTemplate().update("updateContractTarget", contractTarget);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ContractTarget.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ContractTargetDao#removeContractTarget(Long id)
     */
    public void removeContractTarget(Long id) {
        getSqlMapClientTemplate().update("deleteContractTarget", id);
    }
    /**
     * @see com.vriche.adrm.dao.ContractTargetDAO#removeContractTargets(String ids)
     */
    public void removeContractTargets(final Map idList) {
        getSqlMapClientTemplate().update("deleteContractTargets", idList);
    }    
}
