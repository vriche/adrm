package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ContractPayment;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractPaymentDaoTest extends BaseDaoTestCase {
    private Long contractPaymentId = new Long("1");
    private ContractPaymentDao dao = null;

    public void setContractPaymentDao(ContractPaymentDao dao) {
        this.dao = dao;
    }

    public void testAddContractPayment() throws Exception {
        ContractPayment contractPayment = new ContractPayment();

        // set required fields

        dao.saveContractPayment(contractPayment);

        // verify a primary key was assigned
        assertNotNull(contractPayment.getId());

        // verify set fields are same after save
    }

    public void testGetContractPayment() throws Exception {
        ContractPayment contractPayment = dao.getContractPayment(contractPaymentId);
        assertNotNull(contractPayment);
    }

    public void testGetContractPayments() throws Exception {
        ContractPayment contractPayment = new ContractPayment();

        List results = dao.getContractPayments(contractPayment);
        assertTrue(results.size() > 0);
    }

    public void testSaveContractPayment() throws Exception {
        ContractPayment contractPayment = dao.getContractPayment(contractPaymentId);

        // update required fields

        dao.saveContractPayment(contractPayment);

    }

    public void testRemoveContractPayment() throws Exception {
        Long removeId = new Long("3");
        dao.removeContractPayment(removeId);
        try {
            dao.getContractPayment(removeId);
            fail("contractPayment found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveContractPayments(final Map idList) throws Exception {
        try {
        	dao.removeContractPayments(idList);
            fail("contractPayment found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
