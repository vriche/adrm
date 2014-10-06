
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CustomerTypeDao;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.model.CustomerType;
import com.vriche.adrm.service.CustomerTypeManager;
import com.vriche.adrm.service.impl.BaseManager;

public class CustomerTypeManagerImpl extends BaseManager implements CustomerTypeManager {
    private CustomerTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCustomerTypeDao(CustomerTypeDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.crm.service.CustomerTypeManager#getCustomerTypesByIdList(final Map idList)
     */
    public List getCustomerTypesByIdList(final Map idList) {
        return dao.getCustomerTypesByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.crm.service.CustomerTypeManager#getCustomerTypes(com.vriche.adrm.crm.model.CustomerType)
     */
    public List getCustomerTypes(final CustomerType customerType) {
        return dao.getCustomerTypes(customerType);
    }
    
	public Map getCustomerTypeSelectLimit(CustomerType customerType) {
		Map reply = new LinkedHashMap();
	    List it = getCustomerTypes(customerType);
	   for(Iterator ls = it.iterator();ls.hasNext();){
		   CustomerType customerT  = (CustomerType) ls.next();

//	    	reply.put("0","");
	    	reply.put(customerT.getId(),customerT.getName());
	    }
		return reply;
	}

    /**
     * @see com.vriche.adrm.crm.service.CustomerTypeManager#getCustomerType(String id)
     */
    public CustomerType getCustomerType(final String id) {
        return dao.getCustomerType(new Long(id));
    }

    /**
     * @see com.vriche.adrm.crm.service.CustomerTypeManager#saveCustomerType(CustomerType customerType)
     */
    public void saveCustomerType(CustomerType customerType) {
        dao.saveCustomerType(customerType);
    }

    /**
     * @see com.vriche.adrm.crm.service.CustomerTypeManager#removeCustomerType(String id)
     */
    public void removeCustomerType(final String id) {
        dao.removeCustomerType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.crm.service.CustomerTypeManager#removeCustomerTypes(String Map)
     */
    public void removeCustomerTypes(final Map idList) {
        dao.removeCustomerTypes(idList);
    }    
}
