
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.CustomerTypeDao;
import com.vriche.adrm.model.CustomerType;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.CustomerTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerTypeManagerTest extends BaseManagerTestCase {
    private final String customerTypeId = "1";
    private CustomerTypeManagerImpl customerTypeManager = new CustomerTypeManagerImpl();
    private Mock customerTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        customerTypeDao = new Mock(CustomerTypeDao.class);
        customerTypeManager.setCustomerTypeDao((CustomerTypeDao) customerTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        customerTypeManager = null;
    }

    public void testGetCustomerTypes() throws Exception {
        List results = new ArrayList();
        CustomerType customerType = new CustomerType();
        results.add(customerType);

        // set expected behavior on dao
        customerTypeDao.expects(once()).method("getCustomerTypes")
            .will(returnValue(results));

        List customerTypes = customerTypeManager.getCustomerTypes(null);
        assertTrue(customerTypes.size() == 1);
        customerTypeDao.verify();
    }

    public void testGetCustomerType() throws Exception {
        // set expected behavior on dao
        customerTypeDao.expects(once()).method("getCustomerType")
            .will(returnValue(new CustomerType()));
        CustomerType customerType = customerTypeManager.getCustomerType(customerTypeId);
        assertTrue(customerType != null);
        customerTypeDao.verify();
    }

    public void testSaveCustomerType() throws Exception {
        CustomerType customerType = new CustomerType();

        // set expected behavior on dao
        customerTypeDao.expects(once()).method("saveCustomerType")
            .with(same(customerType)).isVoid();

        customerTypeManager.saveCustomerType(customerType);
        customerTypeDao.verify();
    }

    public void testAddAndRemoveCustomerType() throws Exception {
        CustomerType customerType = new CustomerType();

        // set required fields
        customerType.setName("ZnFoFsBmGjAeZfDuNzRjPcVyLaTgHjDnBaGbKpDxVfSyNmObRjBiAhZaWvLgYtKkTzTmDtYhMlRxWoMzSsSaKsWxPaLdRcOoKcQlKwJjDeKsKnXcDiRvOiWnOuPgAmGq");

        // set expected behavior on dao
        customerTypeDao.expects(once()).method("saveCustomerType")
            .with(same(customerType)).isVoid();
        customerTypeManager.saveCustomerType(customerType);
        customerTypeDao.verify();

        // reset expectations
        customerTypeDao.reset();

        customerTypeDao.expects(once()).method("removeCustomerType").with(eq(new Long(customerTypeId)));
        customerTypeManager.removeCustomerType(customerTypeId);
        customerTypeDao.verify();

        // reset expectations
        customerTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(CustomerType.class, customerType.getId());
        customerTypeDao.expects(once()).method("removeCustomerType").isVoid();
        customerTypeDao.expects(once()).method("getCustomerType").will(throwException(ex));
        customerTypeManager.removeCustomerType(customerTypeId);
        try {
            customerTypeManager.getCustomerType(customerTypeId);
            fail("CustomerType with identifier '" + customerTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        customerTypeDao.verify();
    }
}
