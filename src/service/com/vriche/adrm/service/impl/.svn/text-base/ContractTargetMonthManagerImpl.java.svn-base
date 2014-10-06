
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.ContractTargetMonth;
import com.vriche.adrm.dao.ContractTargetMonthDao;
import com.vriche.adrm.service.ContractTargetMonthManager;

public class ContractTargetMonthManagerImpl extends BaseManager implements ContractTargetMonthManager {
    private ContractTargetMonthDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setContractTargetMonthDao(ContractTargetMonthDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#getContractTargetMonths(com.vriche.adrm.model.ContractTargetMonth)
     */
    public List getContractTargetMonths(final ContractTargetMonth contractTargetMonth) {
        return dao.getContractTargetMonths(contractTargetMonth);
    }
   /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#getContractTargetMonthsCount(com.vriche.adrm.model.ContractTargetMonth)
     */
    public String getContractTargetMonthsCount(final ContractTargetMonth contractTargetMonth) {
        return dao.getContractTargetMonthsCount(contractTargetMonth).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#getContractTargetMonthsCount(com.vriche.adrm.model.ContractTargetMonth)
     */    
	public PaginatedList getContractTargetMonthsPage(final ContractTargetMonth contractTargetMonth,String pageIndex, String pageSize) {
//		System.out.println("contractTargetMonth===Manager===="+ contractTargetMonth);
		return dao.getContractTargetMonthsPage(contractTargetMonth,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#getContractTargetMonth(String id)
     */
    public ContractTargetMonth getContractTargetMonth(final String id) {
        return dao.getContractTargetMonth(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#getContractTargetMonthsByIdList(final Map idList)
     */
    public List getContractTargetMonthsByIdList(final Map idList) {
        return dao.getContractTargetMonthsByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#saveContractTargetMonth(ContractTargetMonth contractTargetMonth)
     */
    public String saveContractTargetMonth(ContractTargetMonth contractTargetMonth) {
        return dao.saveContractTargetMonth(contractTargetMonth).toString();
    }

    /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#removeContractTargetMonth(String id)
     */
    public void removeContractTargetMonth(final String id) {
        dao.removeContractTargetMonth(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ContractTargetMonthManager#removeContractTargetMonths(String Map)
     */
    public void removeContractTargetMonths(final Map idList) {
        dao.removeContractTargetMonths(idList);
    }    
}
