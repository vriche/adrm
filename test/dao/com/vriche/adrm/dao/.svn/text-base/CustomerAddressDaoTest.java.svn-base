package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.CustomerAddress;
import com.vriche.adrm.dao.CustomerAddressDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerAddressDaoTest extends BaseDaoTestCase {
    private Long customerAddressId = new Long("1");
    private CustomerAddressDao dao = null;

    public void setCustomerAddressDao(CustomerAddressDao dao) {
        this.dao = dao;
    }

    public void testAddCustomerAddress() throws Exception {
        CustomerAddress customerAddress = new CustomerAddress();

        // set required fields

        dao.saveCustomerAddress(customerAddress);

        // verify a primary key was assigned
        assertNotNull(customerAddress.getId());

        // verify set fields are same after save
    }

    public void testGetCustomerAddress() throws Exception {
        CustomerAddress customerAddress = dao.getCustomerAddress(customerAddressId);
        assertNotNull(customerAddress);
    }

    public void testGetCustomerAddresss() throws Exception {
        CustomerAddress customerAddress = new CustomerAddress();

        List results = dao.getCustomerAddresss(customerAddress);
        assertTrue(results.size() > 0);
    }

    public void testSaveCustomerAddress() throws Exception {
        CustomerAddress customerAddress = dao.getCustomerAddress(customerAddressId);

        // update required fields

        dao.saveCustomerAddress(customerAddress);

    }

    public void testRemoveCustomerAddress() throws Exception {
        Long removeId = new Long("3");
        dao.removeCustomerAddress(removeId);
        try {
            dao.getCustomerAddress(removeId);
            fail("customerAddress found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveCustomerAddresss(final Map idList) throws Exception {
        try {
        	dao.removeCustomerAddresss(idList);
            fail("customerAddress found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
