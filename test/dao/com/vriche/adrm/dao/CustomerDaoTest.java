package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.dao.CustomerDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CustomerDaoTest extends BaseDaoTestCase {
    private Long customerId = new Long("1");
    private CustomerDao dao = null;

    public void setCustomerDao(CustomerDao dao) {
        this.dao = dao;
    }

    public void testAddCustomer() throws Exception {
        Customer customer = new Customer();

        // set required fields

        java.lang.String customerName = "AuKhEtHzAnYjZsDkMiDuHzKmNlQtPwXkEtIqSvGrFuPyFkAgBqOtMbBnCbZmWjQvPzSlHrZpBbIsCjFeOpOjYxCvRxBuPuSzAxRaFxEbYdNzTmJqViRbYiHdIfYsKsMg";
        customer.setCustomerName(customerName);        

        java.lang.String helpCode = "OfAwCcTxQbWgDmQs";
        customer.setHelpCode(helpCode);        

        java.lang.String parentId = "LzBwVfDqMeGkJmBwAiQkHxZhApMaAyLxWiDcUpToVnMaDlAxYjNxKkBkUyHuYqUyXqPoHfImDpKtCoBjHyRsCoDaRcRiVhNdKaPrEaDpRnXgYzErFpKoDdHqSyFbKhCb";
        customer.setParentId(parentId);        

        dao.saveCustomer(customer);

        // verify a primary key was assigned
        assertNotNull(customer.getId());

        // verify set fields are same after save
        assertEquals(customerName, customer.getCustomerName());
        assertEquals(helpCode, customer.getHelpCode());
        assertEquals(parentId, customer.getParentId());
    }

    public void testGetCustomer() throws Exception {
        Customer customer = dao.getCustomer(customerId);
        assertNotNull(customer);
    }

    public void testGetCustomers() throws Exception {
        Customer customer = new Customer();

        List results = dao.getCustomers(customer);
        assertTrue(results.size() > 0);
    }

    public void testSaveCustomer() throws Exception {
        Customer customer = dao.getCustomer(customerId);

        // update required fields
        java.lang.String customerName = "CqCcVfWfOpYdNdTbDhCeXpVgBzCuGxLaViTnSlYpMgVxSyHtYbUlUoBmNbDtXoDhYrOrWgJcTpRdTiAuQgIhCjWmYqRwEqTfBaHrApPkPcFpSyDtCpTjArCoNwJaXbRu";
        customer.setCustomerName(customerName);        
        java.lang.String helpCode = "WaWkWyVdNrTdKeSc";
        customer.setHelpCode(helpCode);        
        java.lang.String parentId = "CySkFuSyGkGbUsSnIzYpHmLrBpMfFjUfStMkDuJnZdEoNqQfCdApGiTiVkWjLkPmRlSsYdMdKhLeFoGjJoLsSkVlTbMgYgZrJiEjQlBcNtSaZcFsLqBxTkAcMoZjQfLp";
        customer.setParentId(parentId);        

        dao.saveCustomer(customer);

        assertEquals(customerName, customer.getCustomerName());
        assertEquals(helpCode, customer.getHelpCode());
        assertEquals(parentId, customer.getParentId());
    }

    public void testRemoveCustomer() throws Exception {
        Long removeId = new Long("3");
        dao.removeCustomer(removeId);
        try {
            dao.getCustomer(removeId);
            fail("customer found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveCustomers(final Map idList) throws Exception {
        try {
        	dao.removeCustomers(idList);
            fail("customer found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
