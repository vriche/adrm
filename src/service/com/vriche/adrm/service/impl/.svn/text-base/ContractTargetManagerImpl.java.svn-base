
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.ContractTarget;
import com.vriche.adrm.dao.ContractTargetDao;
import com.vriche.adrm.service.ContractTargetManager;

public class ContractTargetManagerImpl extends BaseManager implements ContractTargetManager {
    private ContractTargetDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setContractTargetDao(ContractTargetDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ContractTargetManager#getContractTargets(com.vriche.adrm.model.ContractTarget)
     */
    public List getContractTargets(final ContractTarget contractTarget) {
        return dao.getContractTargets(contractTarget);
    }
   /**
     * @see com.vriche.adrm.service.ContractTargetManager#getContractTargetsCount(com.vriche.adrm.model.ContractTarget)
     */
    public String getContractTargetsCount(final ContractTarget contractTarget) {
        return dao.getContractTargetsCount(contractTarget).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ContractTargetManager#getContractTargetsCount(com.vriche.adrm.model.ContractTarget)
     */    
	public PaginatedList getContractTargetsPage(final ContractTarget contractTarget,String pageIndex, String pageSize) {
		return dao.getContractTargetsPage(contractTarget,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.ContractTargetManager#getContractTarget(String id)
     */
    public ContractTarget getContractTarget(final String id) {
        return dao.getContractTarget(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ContractTargetManager#getContractTargetsByIdList(final Map idList)
     */
    public List getContractTargetsByIdList(final Map idList) {
        return dao.getContractTargetsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.ContractTargetManager#saveContractTarget(ContractTarget contractTarget)
     */
    public String saveContractTarget(ContractTarget contractTarget) {
        return dao.saveContractTarget(contractTarget).toString();
    }

    /**
     * @see com.vriche.adrm.service.ContractTargetManager#removeContractTarget(String id)
     */
    public void removeContractTarget(final String id) {
        dao.removeContractTarget(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ContractTargetManager#removeContractTargets(String Map)
     */
    public void removeContractTargets(final Map idList) {
        dao.removeContractTargets(idList);
    }    
}
