
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.CustomerAddressDao;
import com.vriche.adrm.model.CustomerAddress;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.CustomerAddressManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerAddressManagerTest extends BaseManagerTestCase {
    private final String customerAddressId = "1";
    private CustomerAddressManagerImpl customerAddressManager = new CustomerAddressManagerImpl();
    private Mock customerAddressDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        customerAddressDao = new Mock(CustomerAddressDao.class);
        customerAddressManager.setCustomerAddressDao((CustomerAddressDao) customerAddressDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        customerAddressManager = null;
    }

    public void testGetCustomerAddresss() throws Exception {
        List results = new ArrayList();
        CustomerAddress customerAddress = new CustomerAddress();
        results.add(customerAddress);

        // set expected behavior on dao
        customerAddressDao.expects(once()).method("getCustomerAddresss")
            .will(returnValue(results));

        List customerAddresss = customerAddressManager.getCustomerAddresss(null);
        assertTrue(customerAddresss.size() == 1);
        customerAddressDao.verify();
    }

    public void testGetCustomerAddress() throws Exception {
        // set expected behavior on dao
        customerAddressDao.expects(once()).method("getCustomerAddress")
            .will(returnValue(new CustomerAddress()));
        CustomerAddress customerAddress = customerAddressManager.getCustomerAddress(customerAddressId);
        assertTrue(customerAddress != null);
        customerAddressDao.verify();
    }

    public void testSaveCustomerAddress() throws Exception {
        CustomerAddress customerAddress = new CustomerAddress();

        // set expected behavior on dao
        customerAddressDao.expects(once()).method("saveCustomerAddress")
            .with(same(customerAddress)).isVoid();

        customerAddressManager.saveCustomerAddress(customerAddress);
        customerAddressDao.verify();
    }

    public void testAddAndRemoveCustomerAddress() throws Exception {
        CustomerAddress customerAddress = new CustomerAddress();

        // set required fields

        // set expected behavior on dao
        customerAddressDao.expects(once()).method("saveCustomerAddress")
            .with(same(customerAddress)).isVoid();
        customerAddressManager.saveCustomerAddress(customerAddress);
        customerAddressDao.verify();

        // reset expectations
        customerAddressDao.reset();

        customerAddressDao.expects(once()).method("removeCustomerAddress").with(eq(new Long(customerAddressId)));
        customerAddressManager.removeCustomerAddress(customerAddressId);
        customerAddressDao.verify();

        // reset expectations
        customerAddressDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(CustomerAddress.class, customerAddress.getId());
        customerAddressDao.expects(once()).method("removeCustomerAddress").isVoid();
        customerAddressDao.expects(once()).method("getCustomerAddress").will(throwException(ex));
        customerAddressManager.removeCustomerAddress(customerAddressId);
        try {
            customerAddressManager.getCustomerAddress(customerAddressId);
            fail("CustomerAddress with identifier '" + customerAddressId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        customerAddressDao.verify();
    }
}
