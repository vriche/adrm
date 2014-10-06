
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.model.Contract;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.ContractManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractManagerTest extends BaseManagerTestCase {
    private final String contractId = "1";
    private ContractManagerImpl contractManager = new ContractManagerImpl();
    private Mock contractDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        contractDao = new Mock(ContractDao.class);
        contractManager.setContractDao((ContractDao) contractDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        contractManager = null;
    }

    public void testGetContracts() throws Exception {
        List results = new ArrayList();
        Contract contract = new Contract();
        results.add(contract);

        // set expected behavior on dao
        contractDao.expects(once()).method("getContracts")
            .will(returnValue(results));

        List contracts = contractManager.getContracts(null);
        assertTrue(contracts.size() == 1);
        contractDao.verify();
    }

    public void testGetContract() throws Exception {
        // set expected behavior on dao
        contractDao.expects(once()).method("getContract")
            .will(returnValue(new Contract()));
        Contract contract = contractManager.getContract(contractId);
        assertTrue(contract != null);
        contractDao.verify();
    }

    public void testSaveContract() throws Exception {
        Contract contract = new Contract();

        // set expected behavior on dao
        contractDao.expects(once()).method("saveContract")
            .with(same(contract)).isVoid();

        contractManager.saveContract(contract);
        contractDao.verify();
    }

    public void testAddAndRemoveContract() throws Exception {
        Contract contract = new Contract();

        // set required fields

        // set expected behavior on dao
        contractDao.expects(once()).method("saveContract")
            .with(same(contract)).isVoid();
        contractManager.saveContract(contract);
        contractDao.verify();

        // reset expectations
        contractDao.reset();

        contractDao.expects(once()).method("removeContract").with(eq(new Long(contractId)));
        contractManager.removeContract(contractId);
        contractDao.verify();

        // reset expectations
        contractDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Contract.class, contract.getId());
        contractDao.expects(once()).method("removeContract").isVoid();
        contractDao.expects(once()).method("getContract").will(throwException(ex));
        contractManager.removeContract(contractId);
        try {
            contractManager.getContract(contractId);
            fail("Contract with identifier '" + contractId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        contractDao.verify();
    }
}
