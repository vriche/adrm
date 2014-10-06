
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.ContractPaymentManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractPaymentManagerTest extends BaseManagerTestCase {
    private final String contractPaymentId = "1";
    private ContractPaymentManagerImpl contractPaymentManager = new ContractPaymentManagerImpl();
    private Mock contractPaymentDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        contractPaymentDao = new Mock(ContractPaymentDao.class);
        contractPaymentManager.setContractPaymentDao((ContractPaymentDao) contractPaymentDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        contractPaymentManager = null;
    }

    public void testGetContractPayments() throws Exception {
        List results = new ArrayList();
        ContractPayment contractPayment = new ContractPayment();
        results.add(contractPayment);

        // set expected behavior on dao
        contractPaymentDao.expects(once()).method("getContractPayments")
            .will(returnValue(results));

        List contractPayments = contractPaymentManager.getContractPayments(null);
        assertTrue(contractPayments.size() == 1);
        contractPaymentDao.verify();
    }

    public void testGetContractPayment() throws Exception {
        // set expected behavior on dao
        contractPaymentDao.expects(once()).method("getContractPayment")
            .will(returnValue(new ContractPayment()));
        ContractPayment contractPayment = contractPaymentManager.getContractPayment(contractPaymentId);
        assertTrue(contractPayment != null);
        contractPaymentDao.verify();
    }

    public void testSaveContractPayment() throws Exception {
        ContractPayment contractPayment = new ContractPayment();

        // set expected behavior on dao
        contractPaymentDao.expects(once()).method("saveContractPayment")
            .with(same(contractPayment)).isVoid();

        contractPaymentManager.saveContractPayment(contractPayment);
        contractPaymentDao.verify();
    }

    public void testAddAndRemoveContractPayment() throws Exception {
        ContractPayment contractPayment = new ContractPayment();

        // set required fields

        // set expected behavior on dao
        contractPaymentDao.expects(once()).method("saveContractPayment")
            .with(same(contractPayment)).isVoid();
        contractPaymentManager.saveContractPayment(contractPayment);
        contractPaymentDao.verify();

        // reset expectations
        contractPaymentDao.reset();

        contractPaymentDao.expects(once()).method("removeContractPayment").with(eq(new Long(contractPaymentId)));
        contractPaymentManager.removeContractPayment(contractPaymentId);
        contractPaymentDao.verify();

        // reset expectations
        contractPaymentDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ContractPayment.class, contractPayment.getId());
        contractPaymentDao.expects(once()).method("removeContractPayment").isVoid();
        contractPaymentDao.expects(once()).method("getContractPayment").will(throwException(ex));
        contractPaymentManager.removeContractPayment(contractPaymentId);
        try {
            contractPaymentManager.getContractPayment(contractPaymentId);
            fail("ContractPayment with identifier '" + contractPaymentId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        contractPaymentDao.verify();
    }
}
