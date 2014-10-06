
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.CustomerAddressDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.CustomerAddress;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerAddressDaoiBatis extends BaseDaoiBATIS implements CustomerAddressDao {

    /**
     * @see com.vriche.adrm.crm.dao.CustomerAddressDao#getCustomerAddresss(com.vriche.adrm.crm.model.CustomerAddress)
     */
    public List getCustomerAddresss(final CustomerAddress customerAddress) {
          return getSqlMapClientTemplate().queryForList("getCustomerAddresss", customerAddress);
    }
    /**
     * @see com.vriche.adrm.crm.dao.CustomerAddressDao#getCustomerAddresssByIdList(com.vriche.adrm.crm.model.CustomerAddress)
     */
    public List getCustomerAddresssByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getCustomerAddresssByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.CustomerAddressDao#getCustomerAddress(Long id)
     */
    public CustomerAddress getCustomerAddress(Long id) {
        CustomerAddress customerAddress = (CustomerAddress) getSqlMapClientTemplate().queryForObject("getCustomerAddress", id);

        if (customerAddress == null) {
            throw new ObjectRetrievalFailureException(CustomerAddress.class, id);
        }

        return customerAddress;
    }

    /**
     * @see com.vriche.adrm.crm.dao.CustomerAddressDao#saveCustomerAddress(CustomerAddress customerAddress)
     */    
    public void saveCustomerAddress(final CustomerAddress customerAddress) {
        Long id = customerAddress.getId();
        // check for new record
        
        if (id == null|| id.intValue() == -1 || id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addCustomerAddress", customerAddress);
        } else {
            getSqlMapClientTemplate().update("updateCustomerAddress", customerAddress);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(CustomerAddress.class, id);
        }
    }
    
    public Long saveCustomerAddressList(CustomerAddress customerAddress){
        Long id = customerAddress.getId();
//        System.out.println("id<<<<<<<<11111111111<<<<<<<<<<"+id);
        // check for new record
        
        if (id == null|| id.intValue() == -1 || id.intValue() == 0) {
            id = (Long) getSqlMapClientTemplate().insert("addCustomerAddress", customerAddress);
            System.out.println("id<<<<<<<<11111111111<<<<<<<<<<"+id);
        } else {
            getSqlMapClientTemplate().update("updateCustomerAddress", customerAddress);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(CustomerAddress.class, id);
        }
        return id;
    }

    /**
     * @see com.vriche.adrm.crm.dao.CustomerAddressDao#removeCustomerAddress(Long id)
     */
    public void removeCustomerAddress(Long id) {
        getSqlMapClientTemplate().update("deleteCustomerAddress", id);
    }
    /**
     * @see com.vriche.adrm.crm.dao.CustomerAddressDAO#removeCustomerAddresss(String ids)
     */
    public void removeCustomerAddresss(final Map idList) {
        getSqlMapClientTemplate().update("deleteCustomerAddresss", idList);
    }
	public PaginatedList getCustomerAddressPage(CustomerAddress customerAddress, int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getCustomerAddresss",customerAddress,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}
	public Integer getCustomerAddressCount(CustomerAddress customerAddress) {
		return (Integer) getSqlMapClientTemplate().queryForObject("getCustomerAddressCount", customerAddress);
	}    
}
