package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.CustomerType;
import com.vriche.adrm.dao.CustomerTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerTypeDaoTest extends BaseDaoTestCase {
    private Long customerTypeId = new Long("1");
    private CustomerTypeDao dao = null;

    public void setCustomerTypeDao(CustomerTypeDao dao) {
        this.dao = dao;
    }

    public void testAddCustomerType() throws Exception {
        CustomerType customerType = new CustomerType();

        // set required fields

        java.lang.String name = "XiQkXsHvLcAqAsYyVnYgGgBqWzHpNoFtUeClFfVeYzQlKgZcXcCwXfEnAaQiLhArRrVaDnKySqRhKdQkGnByLgCdDtYiWfIyQqOcTaLhTeImLfFjGkBfDuQlHjYkRsNl";
        customerType.setName(name);        

        dao.saveCustomerType(customerType);

        // verify a primary key was assigned
        assertNotNull(customerType.getId());

        // verify set fields are same after save
        assertEquals(name, customerType.getName());
    }

    public void testGetCustomerType() throws Exception {
        CustomerType customerType = dao.getCustomerType(customerTypeId);
        assertNotNull(customerType);
    }

    public void testGetCustomerTypes() throws Exception {
        CustomerType customerType = new CustomerType();

        List results = dao.getCustomerTypes(customerType);
        assertTrue(results.size() > 0);
    }

    public void testSaveCustomerType() throws Exception {
        CustomerType customerType = dao.getCustomerType(customerTypeId);

        // update required fields
        java.lang.String name = "MzJdAcLzGpNuZyMgKvCuInVaZtDqXjQxRfWuJmUhRdFzDlHdRhTmNhAtFfRpMnMnNwMrNqSnFjGkBqGzNwZkWdWyLkYnPkBrNlEsOnVoRdBdGzXdRtQqZtVkYuWcBdJz";
        customerType.setName(name);        

        dao.saveCustomerType(customerType);

        assertEquals(name, customerType.getName());
    }

    public void testRemoveCustomerType() throws Exception {
        Long removeId = new Long("3");
        dao.removeCustomerType(removeId);
        try {
            dao.getCustomerType(removeId);
            fail("customerType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveCustomerTypes(final Map idList) throws Exception {
        try {
        	dao.removeCustomerTypes(idList);
            fail("customerType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
