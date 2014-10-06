
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CustomerTypeDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.CustomerType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerTypeDaoiBatis extends BaseDaoiBATIS implements CustomerTypeDao {

    /**
     * @see com.vriche.adrm.crm.dao.CustomerTypeDao#getCustomerTypes(com.vriche.adrm.crm.model.CustomerType)
     */
    public List getCustomerTypes(final CustomerType customerType) {
          return getSqlMapClientTemplate().queryForList("getCustomerTypes", customerType);
    }
    /**
     * @see com.vriche.adrm.crm.dao.CustomerTypeDao#getCustomerTypesByIdList(com.vriche.adrm.crm.model.CustomerType)
     */
    public List getCustomerTypesByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getCustomerTypesByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.crm.dao.CustomerTypeDao#getCustomerType(Long id)
     */
    public CustomerType getCustomerType(Long id) {
        CustomerType customerType = (CustomerType) getSqlMapClientTemplate().queryForObject("getCustomerType", id);

        if (customerType == null) {
            throw new ObjectRetrievalFailureException(CustomerType.class, id);
        }

        return customerType;
    }

    /**
     * @see com.vriche.adrm.crm.dao.CustomerTypeDao#saveCustomerType(CustomerType customerType)
     */    
    public void saveCustomerType(final CustomerType customerType) {
        Long id = customerType.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addCustomerType", customerType);
        } else {
            getSqlMapClientTemplate().update("updateCustomerType", customerType);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(CustomerType.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.crm.dao.CustomerTypeDao#removeCustomerType(Long id)
     */
    public void removeCustomerType(Long id) {
        getSqlMapClientTemplate().update("deleteCustomerType", id);
    }
    /**
     * @see com.vriche.adrm.crm.dao.CustomerTypeDAO#removeCustomerTypes(String ids)
     */
    public void removeCustomerTypes(final Map idList) {
        getSqlMapClientTemplate().update("deleteCustomerTypes", idList);
    }    
}
