
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.CustomerCarrierRel;


public class CustomerDaoiBatis extends BaseDaoiBATIS implements CustomerDao {

    /**
     * @see com.vriche.adrm.crm.dao.CustomerDao#getCustomers(com.vriche.adrm.crm.model.Customer)
     */
    public List getCustomers(final Customer customer) {
          return getSqlMapClientTemplate().queryForList("getCustomers", customer);
    }
    
    
    
    public Integer getCustomersCount(Customer customer) {
    	 return (Integer)getSqlMapClientTemplate().queryForObject("getCustomersCount", customer);
	}



	public List getCustomersPage(Customer customer,int pageIndex, int pageSize) {
//	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getCustomers",customer,pageSize);
//	     pageList.gotoPage(pageIndex-1);
//		 return pageList;
		
		 int skip = (pageIndex-1) * pageSize;
		 return getSqlMapClientTemplate().queryForList("getCustomers",customer,skip,pageSize);
	}



	/**
     * @see com.vriche.adrm.crm.dao.CustomerDao#getCustomersByIdList(com.vriche.adrm.crm.model.Customer)
     */
    public List getCustomersByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getCustomersByIdList", idList);
    }

    
    /**
     * @see com.vriche.adrm.crm.dao.CustomerDao#getCustomer(Long id)
     */
    public Customer getCustomer(Long id) {
    	Customer customer =  new Customer();
    	customer.setId(id);
    	return this.getCustomer(customer);
   }
    public Customer getCustomerForOrderPrint(final Long id){
    	Customer customer =  new Customer();
    	customer.setId(id);
    	return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerForOrderPrint", customer);
    }
	public Customer getCustomer(Customer cut) {
		
        Customer customer = (Customer) getSqlMapClientTemplate().queryForObject("getCustomer", cut);
        
//        if (customer == null) {
//            throw new ObjectRetrievalFailureException(Customer.class, customer.getId());
//        }

        return customer;
	}

    /**
     * @see com.vriche.adrm.crm.dao.CustomerDao#saveCustomer(Customer customer)
     */    
    public Long saveCustomer(final Customer customer) {
    	
//    	System.out.println("customer = " + customer);
    	
        Long id = customer.getId();
        
//        System.out.println("id = " + id);
        // check for new record
        if (id == null || id.intValue() == -1 || id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addCustomer", customer);
        } else {
            getSqlMapClientTemplate().update("updateCustomer", customer);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Customer.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.crm.dao.CustomerDao#removeCustomer(Long id)
     */
    public void removeCustomer(Long id) {
    	//删除代理信息
    	getSqlMapClientTemplate().update("deleteAgentInfoByCustomerId", id);
    	
    	//删除地址信息
    	getSqlMapClientTemplate().update("deleteAddressByCustomerId", id);   
    	
    	//删除联系人信息
    	getSqlMapClientTemplate().update("updateLinkManByCustomerId", id);  
    	
    	//删除联系记录
    	getSqlMapClientTemplate().update("deleteLinkHisotryByCustomerId", id);     	
    	
    	
    	//删除客户
        getSqlMapClientTemplate().update("deleteCustomer", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.CustomerDAO#removeCustomers(String ids)
     */
    public void removeCustomers(final Map idList) {
        getSqlMapClientTemplate().update("deleteCustomers", idList);
    }



	public List getCustomers(Map mp) {
		  return getSqlMapClientTemplate().queryForList("getCustomersByIdList", mp);
	}

	public List getCustomersAllForCommand(Map mp) {
		  return getSqlMapClientTemplate().queryForList("getCustomersAllForCommand", mp);
	}
	

	
	public List getCustomerUserRel(Long customerId) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getCustomerUserRel", customerId);
	}



	public void deleteCustomerUserRelByParent(Long customerId) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("deleteCustomerUserRelByParent", customerId);
	}



	public void saveCustomerUserRel(Map mp) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("saveCustomerUserRel", mp);
	}




	public List getCustomerIdsByUserId(Long userId) {
		return getSqlMapClientTemplate().queryForList("getCustomerIdsByUserId", userId);
	}
	
	
	public void saveCustomerUnify(Map mp) {
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			  
			getSqlMapClientTemplate().update("updateCustomerId_matter", mp);
			getSqlMapClientTemplate().update("updateCustomerId_payment", mp);
			getSqlMapClientTemplate().update("updateCustomerId_order", mp);
			getSqlMapClientTemplate().update("updateCustomerId_contract", mp);
			getSqlMapClientTemplate().update("updateCustomerId_address", mp);
			getSqlMapClientTemplate().update("updateCustomerId_agentInfo", mp);
			getSqlMapClientTemplate().update("updateCustomerId_feedback", mp);
			getSqlMapClientTemplate().update("updateCustomerId_linkHisotry", mp);
			getSqlMapClientTemplate().update("updateCustomerId_linkMan", mp);
			getSqlMapClientTemplate().update("updateCustomerId_income", mp);
			getSqlMapClientTemplate().update("deleteCustomer_for_userRel", mp);
			getSqlMapClientTemplate().update("deleteCustomer_for_unify", mp);
			
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public List getCustomersByRes(Map mp) {
		return getSqlMapClientTemplate().queryForList("getCustomersByRes", mp);
	}
	
	public List getCustomerCarrierRels(CustomerCarrierRel customerCarrierRel) {
		return getSqlMapClientTemplate().queryForList("getCustomerCarrierRels", customerCarrierRel);
	}
	
	public List getCustomerCarrierRel(CustomerCarrierRel customerCarrierRel) {
		return getSqlMapClientTemplate().queryForList("getCustomerCarrierRel", customerCarrierRel);
	}

	public Long saveCustomerCarrierRel(CustomerCarrierRel customerCarrierRel) {
		Long id = customerCarrierRel.getId();
		Long count=(Long) getSqlMapClientTemplate().queryForObject("getCustomerCarrierRelCount", id);
		
      if (count.equals(new Long(0))) {
          id = (Long) getSqlMapClientTemplate().insert("addCustomerCarrierRel", customerCarrierRel);
      } else {
          getSqlMapClientTemplate().update("updateCustomerCarrierRel", customerCarrierRel);
      }
      if( id == null ) {
          throw new ObjectRetrievalFailureException(CustomerCarrierRel.class, id);
      }
      return id;
	}
	public void removeCustomerCarrierRel(Long id) {
		getSqlMapClientTemplate().update("deleteCustomerCarrierRel", id);
	}
	
	public List getCustomerCarrierRelPage(CustomerCarrierRel customerCarrierRel,int pageIndex, int pageSize) {
		 int skip = pageIndex* pageSize;
		 return getSqlMapClientTemplate().queryForList("getCustomerCarrierRels",customerCarrierRel,skip,pageSize);
	}
	
	public List getCarrierPageXMLs(CustomerCarrierRel customerCarrierRel,int pageIndex, int pageSize) {
		 int skip = pageIndex* pageSize;
		 return getSqlMapClientTemplate().queryForList("getCarrierPageXML",customerCarrierRel,skip,pageSize);
	}
	
	public List getCustomerCarrierRelCount(CustomerCarrierRel customerCarrierRel) {
		
		return getSqlMapClientTemplate().queryForList("getCustomerCarrierRelsCount", customerCarrierRel);
	}
	public Integer getCustomerCarrierRelCountAll(CustomerCarrierRel customerCarrierRel) {
		
		return (Integer) getSqlMapClientTemplate().queryForObject("getCustomerCarrierRelCountAll", customerCarrierRel);
	}
	
	public List getCarrierPageXML(CustomerCarrierRel customerCarrierRel) {		
		return getSqlMapClientTemplate().queryForList("getCarrierPageXML", customerCarrierRel);
	}
	
	public List getOrderDetails(CustomerCarrierRel customerCarrierRel) {		
		return getSqlMapClientTemplate().queryForList("getLongOrderDetails", customerCarrierRel);
	}
	
	public Double getIncomeUsedByOrderId(String id) {		
		return (Double)getSqlMapClientTemplate().queryForObject("getIncomeUsedByOrderId", id);
	}



	public List getCustomersFromOrder(Map mp) {

		List ls =  getSqlMapClientTemplate().queryForList("getCustomersByLoginUserReturnObjects", mp);
//		没订单的客户
		List ls2 =  getSqlMapClientTemplate().queryForList("getCustomerFromIncomeNoInORrderReturnObjects", mp);
		if(ls2.size()>0) ls.addAll(ls2);
		return ls;
	}



	public List  getCustomersAnalyze(Customer customer) {
		return getSqlMapClientTemplate().queryForList("getCustomersAnalyze",customer);
		// TODO Auto-generated method stub
	}
	
	public List getCustFromOrder(Map mp){
		return getSqlMapClientTemplate().queryForList("getCustFromOrder",mp);
	}



	public List getCustidsByOrg(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getCustidsByOrg",mp);
	}



	public List getCustomerRemote(Map mp) {
		  return getSqlMapClientTemplate().queryForList("getCustomerRemote", mp);
	}
 
}
