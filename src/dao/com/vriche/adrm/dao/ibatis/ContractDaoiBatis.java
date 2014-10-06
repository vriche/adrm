
package com.vriche.adrm.dao.ibatis;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
//import com.vriche.adrm.order.model.User;
import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.Contract;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractDaoiBatis extends BaseDaoiBATIS implements ContractDao {

    /**
     * @see com.vriche.adrm.order.dao.ContractDao#getContracts(com.vriche.adrm.order.model.Contract)
     */
    public List getContracts(final Contract contract) {
          return getSqlMapClientTemplate().queryForList("getContracts", contract);
    }


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.ContractDao#getContractsByWorkFlowId(java.lang.Long, java.lang.Long)
	 */
	public List getContractsByWorkFlowId(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getContractsByWorkFlowId", mp);
	}

	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.ContractDao#getContractIdsByWorkFlowId(java.util.Map)
	 */
	public List getContractIdsByWorkFlowId(Map mp) {
		 return getSqlMapClientTemplate().queryForList("getContractIdsByWorkFlowId", mp);
	}


	public List getContractsByUsers(final Map mp) {
		   return getSqlMapClientTemplate().queryForList("getContractsByUsers", mp);
	}

	public List getContractsPage(Contract contract,int pageIndex,int pageSize) {
//	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getContracts",contract,pageSize);
//	     pageList.gotoPage(pageIndex-1);
//		 return pageList;
//		 
		 
		 int skip = (pageIndex-1) * pageSize;
		 return getSqlMapClientTemplate().queryForList("getContractsList",contract,skip,pageSize);
	}
	
	public List getContractsList(Contract contract) {
		 return getSqlMapClientTemplate().queryForList("getContractsList",contract);
	}

	public Integer getContractsCount(Contract contract) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getContractsCount", contract);
	}


	public Integer getContractsByIdListCount(final Map idList) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getContractsByIdListCount", idList);
	}


//	/**
//     * @see com.vriche.adrm.order.dao.ContractDao#getContractsByIdList(com.vriche.adrm.order.model.Contract)
//     */
//    public PaginatedList getContractsByIdList(final Map idList,int pageIndex,int pageSize) { 
//
// 	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getContractsByIdList",idList,pageSize);
// 	   	 pageList.gotoPage(pageIndex-1);
//		 return pageList;         
//          
//    }
	/**
	 * @see com.vriche.adrm.order.dao.ContractDao#getContractsByIdList(com.vriche.adrm.order.model.Contract)
	 */
	public List getContractsByIdList(final Map idList,int pageIndex,int pageSize) {
		 int skip = (pageIndex-1)* pageSize;
		 int max =  pageSize;
		 return getSqlMapClientTemplate().queryForList("getContractsByIdList",idList,skip,max);
	}

    /**
     * @see com.vriche.adrm.order.dao.ContractDao#getContract(Long id)
     */
    public Contract getContract(Long id) {
        Contract contract = (Contract) getSqlMapClientTemplate().queryForObject("getContract", id);

        if (contract == null) {
            logger.warn("uh oh, contract not found...");
            throw new ObjectRetrievalFailureException(Contract.class, id);
        }else{
//            List orders = getSqlMapClientTemplate().queryForList("getOrdersByContractId",id);
//            contract.setOrders(new HashSet(orders));
//            
//            List payments = getSqlMapClientTemplate().queryForList("getPaymentsByContractId",id);
//            contract.setContractPayments(new HashSet(payments));
            
        }

        return contract;
    }

    /**
     * @see com.vriche.adrm.order.dao.ContractDao#saveContract(Contract contract)
     */    
    public Long saveContract(final Contract contract) {
    	
//    	System.out.println("contract="+contract);
        Long id = contract.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addContract", contract);
        } else {
            getSqlMapClientTemplate().update("updateContract", contract);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Contract.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.order.dao.ContractDao#removeContract(Long id)
     */
    public void removeContract(Long id) {
        getSqlMapClientTemplate().update("deleteContract", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.ContractDAO#removeContracts(String ids)
     */
    public void removeContracts(final Map idList) {
        getSqlMapClientTemplate().update("deleteContracts", idList);
    }


	/* (non-Javadoc)
	 * @see com.vriche.adrm.dao.ContractDao#updateContractStates(java.lang.String[], java.lang.String)
	 */
	public void updateContractState(final Map mp) {
		 getSqlMapClientTemplate().update("updateContractState", mp);
	}


	public List getContractAutoComplet(Contract contract) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getContractAutoComplet", contract);
	}  
    
    
}
