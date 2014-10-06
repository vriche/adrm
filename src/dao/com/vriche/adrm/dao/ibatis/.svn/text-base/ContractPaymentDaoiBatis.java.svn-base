
package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.IncomeUsed;


public class ContractPaymentDaoiBatis extends BaseDaoiBATIS implements ContractPaymentDao {

    /**
     * @see com.vriche.adrm.order.dao.ContractPaymentDao#getContractPayments(com.vriche.adrm.order.model.ContractPayment)
     */
    public List getContractPayments(final ContractPayment contractPayment) {
          return getSqlMapClientTemplate().queryForList("getContractPayments", contractPayment);
    }
    
    
    public List getContractPaymentAutoComplet(final ContractPayment contractPayment) {
        return getSqlMapClientTemplate().queryForList("getContractPaymentAutoComplet", contractPayment);
  }
     
    

    
    public Integer getContractPaymentsCount(ContractPayment contractPayment) {
//    	System.out.println("contractPayment=="+contractPayment);
    	return (Integer)getSqlMapClientTemplate().queryForObject("getContractPaymentsCount", contractPayment);
	}



	public PaginatedList getContractPaymentsPage(ContractPayment contractPayment, int pageIndex, int pageSize) {
		PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getContractPayments",contractPayment,pageSize);
	    pageList.gotoPage(pageIndex-1);
		return pageList;
	}
	
	public List getContractPaymentsListPage(ContractPayment contractPayment) {
		return getSqlMapClientTemplate().queryForList("getContractPayments",contractPayment);
	}


	public Integer getContractPaymentsCount_nopay(ContractPayment contractPayment) {
		 return (Integer)getSqlMapClientTemplate().queryForObject("getContractPaymentsCount_nopay", contractPayment);
	}



	public PaginatedList getContractPaymentsPage_nopay(ContractPayment contractPayment, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getContractPayments_nopay",contractPayment,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}



	/**
     * @see com.vriche.adrm.order.dao.ContractPaymentDao#getContractPaymentsByIdList(com.vriche.adrm.order.model.ContractPayment)
     */
    public List getContractPaymentsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getContractPaymentsByIdList", idList);
    }
    
    public List getContractPaymentsByCarrierIdMap(Map mp, int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 int max =  pageSize;
        return getSqlMapClientTemplate().queryForList("getContractPaymentsByCarrierIdMap", mp,skip,max);
  }
    
    public List getContractPaymentsCountByCarrierId(Map mp) {
//    	System.out.println("contractPayment=="+contractPayment);
    	return (List)getSqlMapClientTemplate().queryForList("getContractPaymentsByCarrierIdCount", mp);
	}
	
	public List getContractPaymentForm(Map mp) {
//    	System.out.println("contractPayment=="+contractPayment);
    	return (List)getSqlMapClientTemplate().queryForList("getContractPaymentForm", mp);
	}
	
	public List getContractPaymentFormPage(Map mp,int skip,int max) {
//    	System.out.println("contractPayment=="+contractPayment);
    	return (List)getSqlMapClientTemplate().queryForList("getContractPaymentForm", mp,skip,max);
	}
	
	public ContractPayment getContractPaymentFormCount(Map mp) {
//    	System.out.println("contractPayment=="+contractPayment);
    	return (ContractPayment)getSqlMapClientTemplate().queryForObject("getContractPaymentFormCount", mp);
	}
		
	
	
	
	
	public List getUserIdByUserName(String mp) {
//    	System.out.println("contractPayment=="+contractPayment);
    	return (List)getSqlMapClientTemplate().queryForList("getUserIdByUserName", mp);
	}
	
    /**
     * @see com.vriche.adrm.order.dao.ContractPaymentDao#getContractPayment(Long id)
     */
    public ContractPayment getContractPayment(Long id) {
        ContractPayment contractPayment = (ContractPayment) getSqlMapClientTemplate().queryForObject("getContractPayment", id);

        if (contractPayment == null) {
            throw new ObjectRetrievalFailureException(ContractPayment.class, id);
        }

        return contractPayment;
    }
    
    
	public List getContractPayment(Map mp) {
		return (List)getSqlMapClientTemplate().queryForList("getContractPaymentByMap", mp);
	}
    
    
    public Long getPaymentIdMaxByOidOrCid(ContractPayment contractPayment) {
    	return (Long)getSqlMapClientTemplate().queryForObject("getPaymentIdMaxByOidOrCid", contractPayment);
    }

    /**
     * @see com.vriche.adrm.order.dao.ContractPaymentDao#saveContractPayment(ContractPayment contractPayment)
     */    
    public Long saveContractPayment( ContractPayment contractPayment) {

    	 
        Long id = contractPayment.getId();
        
        Map mp = new HashMap();
        
        Long resType = contractPayment.getResourceTypeId();
        if(resType == null){
        	resType = new Long(0);
        	contractPayment.setResourceTypeId(resType);
        }
        
        // check for new record

        System.out.println("saveContractPayment id>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>11111111111111111111111111111111111111111"+id); 
        if (id == null) {
        	id = (Long) getSqlMapClientTemplate().insert("addContractPayment", contractPayment);
        } else {
            getSqlMapClientTemplate().update("updateContractPayment", contractPayment);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ContractPayment.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.order.dao.ContractPaymentDao#removeContractPayment(Long id)
     */
    public void removeContractPayment(Long id) {
        getSqlMapClientTemplate().update("deleteContractPayment", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.ContractPaymentDAO#removeContractPayments(String ids)
     */
    public void removeContractPayments(final Map idList) {
        getSqlMapClientTemplate().update("deleteContractPayments", idList);
    }


	public void updateContractPaymentMoneyIn(List moneyInList,List moneyUsedList) {

//		try {
//			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
//			for(Iterator it = moneyInList.iterator();it.hasNext();){
//				Map mp = (Map) it.next(); 
//
//				getSqlMapClientTemplate().update("updateContractPaymentMoneyIn",mp);
//			}	
			for(Iterator it = moneyUsedList.iterator();it.hasNext();){
				Map map = (Map) it.next();
				IncomeUsed incomeUsed = new IncomeUsed();
//				Long incomeId = (Long)map.get("incomeId");
				Long paymentId = (Long)map.get("payMentId");
				Double moneyUsed = (Double)map.get("moneyUsed");
				
//				incomeUsed.setIncomeId(incomeId);
				incomeUsed.setPaymentId(paymentId);
				incomeUsed.setMoneyIn(moneyUsed);
				incomeUsed.setPublishDate(new Integer(0));
				incomeUsed.setIncomePullId(new Long(0));
//				incomeUsed.setContractId(new Long(0));
//				incomeUsed.setOrderId(new Long(0));
//				incomeUsed.setOrderDetailId(new Long(0));
				incomeUsed.setOrderDayInfoId(new Long(0));
//				incomeUsed.setVersion()
				
				getSqlMapClientTemplate().update("addIncomeUsed",incomeUsed);
			}	
//			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public Integer updateMoneyIn(final Map idList) {
		return (Integer)getSqlMapClientTemplate().queryForObject("updateMoneyIn",idList);
	}
	
	public void updatePayMoney(final Map idList) {
		 getSqlMapClientTemplate().update("updatePayMoney",idList);
	}


	public PaginatedList getContractPaymentsPageByIdList(Map idList, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getContractPaymentsByIdList",idList,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}


	public Integer getContractPaymentCountByIdList(Map idList) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getContractPaymentsCountByIdList", idList);
	}


	public Long getMoneyPayByOrderId(Long orderId) {
//		 System.out.println("order(d =" +orderId);
		 return (Long)getSqlMapClientTemplate().queryForObject("getMoneyPayByOrderId", orderId);
	}


	
	public Double getMoneyPayByOrderIdDouble(Long orderId) {
//		 System.out.println("order(d =" +orderId);
		 return (Double)getSqlMapClientTemplate().queryForObject("getMoneyPayByOrderIdDouble", orderId);
	}

	
	public List getContractPaymentsPageByMap(Map mp, int pageIndex, int pageSize) {
		int skip = pageIndex * pageSize;
		int max =  pageSize;
		return getSqlMapClientTemplate().queryForList("getContractPaymentsByMap",mp,skip,max);
	}    
	
	public List getContractPaymentsCountByMap(Map mp) {
		// TODO Auto-generated method stub

		return getSqlMapClientTemplate().queryForList("getContractPaymentsByMap",mp);
	}


	public List getContractPaymentList(Map mp) {
		// TODO Auto-generated method stub
		List ls = (List)getSqlMapClientTemplate().queryForList("getContractPaymentList",mp);
//		System.out.println(">>>>>   "+ls.size());
		return ls;
	}


	public List getContractPaymentListPage(Map mp, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		
		int skip = pageIndex * pageSize;
		 int max =  pageSize;
		 return getSqlMapClientTemplate().queryForList("getContractPaymentList",mp,skip,max);
	}


	public List getContractPaymentsForBalance(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getContractPaymentsForBalance",contractPayment);
	}
	public List getContractPaymentsForBalance2(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getContractPaymentsForBalance2",contractPayment);
	}
	//·ÖÒ³
	public List getContractPaymentsPageForBalance(ContractPayment contractPayment,int pageIndex, int pageSize) {
		int skip = pageIndex * pageSize;
		return getSqlMapClientTemplate().queryForList("getContractPaymentsForBalance",contractPayment,skip,pageSize);
	}


	public List getContractPaymentsByResource(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getContractPaymentsByResource",contractPayment);
	}
	
	public List getContractPaymentsOfContractByResource(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getContractPaymentsOfContractByResource",contractPayment);
	}


	public void saveContractPaymentVersion(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("updateContractPaymentVersion",contractPayment);
	}


	public List getContractPaymentsTable(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getPaymentSysPrice",contractPayment);
	}
	
	public List getOrderSysPrice(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOrderSysPrice",contractPayment);
	}
	
	public List getOrderSysPriceInContract(ContractPayment contractPayment) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getOrderSysPriceInContract",contractPayment);
	}
	
    public void updateNamberPayment(Map mp){
			getSqlMapClientTemplate().update("updateNamberPayment",mp);
		}	
    
    public List getPaymentTable(String id){
    	return getSqlMapClientTemplate().queryForList("getPaymentTable",id);
    }
    
    public List getIncomePullsByOrderDetail(ContractPayment contractPayment){
    	return getSqlMapClientTemplate().queryForList("getIncomePullsByOrderDetail",contractPayment);
    }


	public List getContractPaymentsForBalance3(ContractPayment contractPayment) {
		return getSqlMapClientTemplate().queryForList("getContractPaymentsForBalance3",contractPayment);
	}

	public List getContractPaymentsForBalance4(ContractPayment contractPayment) {
		return getSqlMapClientTemplate().queryForList("getContractPaymentsForBalance4",contractPayment);
	}

    
	public List getContractPaymentsCopy(Long orderId) {
		return getSqlMapClientTemplate().queryForList("getContractPaymentsCopy",orderId);
	}


	public List getContractPaymentsDesc(ContractPayment contractPayment) {
		 return getSqlMapClientTemplate().queryForList("getContractPaymentsDesc", contractPayment);
	}	
	
	
	
	
	
	
	
}
