
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.CustomerManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerManagerTest extends BaseManagerTestCase {
    private final String customerId = "1";
    private CustomerManagerImpl customerManager = new CustomerManagerImpl();
    private Mock customerDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        customerDao = new Mock(CustomerDao.class);
        customerManager.setCustomerDao((CustomerDao) customerDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        customerManager = null;
    }

    public void testGetCustomers() throws Exception {
        List results = new ArrayList();
        Customer customer = new Customer();
        results.add(customer);

        // set expected behavior on dao
        customerDao.expects(once()).method("getCustomers")
            .will(returnValue(results));

//        List customers = customerManager.getCustomers(null);
//        assertTrue(customers.size() == 1);
        customerDao.verify();
    }

    public void testGetCustomer() throws Exception {
        // set expected behavior on dao
        customerDao.expects(once()).method("getCustomer")
            .will(returnValue(new Customer()));
        Customer customer = customerManager.getCustomer(customerId);
        assertTrue(customer != null);
        customerDao.verify();
    }

    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();

        // set expected behavior on dao
        customerDao.expects(once()).method("saveCustomer")
            .with(same(customer)).isVoid();

//        customerManager.saveCustomer(customer);
        customerDao.verify();
    }

    public void testAddAndRemoveCustomer() throws Exception {
        Customer customer = new Customer();

        // set required fields
        customer.setCustomerName("VnVvHqDuCtAnXmZxHqRlDsBzEmMaTzVzWhDwTcNqQmFhDeVoPuDwXeCjMbTeYdZqWmStIjJjOlQhIkJkVgOnLnMlViHbZaZtMnVsAyMhJqVpEcEbVqOwQjByUqDpHqCp");
        customer.setHelpCode("PaBmQeQgLdYuJwRl");
        customer.setParentId("CnFlHlNxXgFiDvSlToWhRsZiRaUcVmIcJmUsWbJvRoUnVzRoQsWaVdFcXiSqYnZfAeZpLpQvRyFmHoUtWkZpJmKgAoIvGdQiDvLtYrGkFnXfSdSwCfGtEqJaQdUfLfFy");

        // set expected behavior on dao
        customerDao.expects(once()).method("saveCustomer")
            .with(same(customer)).isVoid();
//        customerManager.saveCustomer(customer);
        customerDao.verify();

        // reset expectations
        customerDao.reset();

        customerDao.expects(once()).method("removeCustomer").with(eq(new Long(customerId)));
        customerManager.removeCustomer(customerId);
        customerDao.verify();

        // reset expectations
        customerDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Customer.class, customer.getId());
        customerDao.expects(once()).method("removeCustomer").isVoid();
        customerDao.expects(once()).method("getCustomer").will(throwException(ex));
        customerManager.removeCustomer(customerId);
        try {
            customerManager.getCustomer(customerId);
            fail("Customer with identifier '" + customerId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        customerDao.verify();
    }
}
