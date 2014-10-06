
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.ContractTargetDao;
import com.vriche.adrm.model.ContractTarget;
import com.vriche.adrm.service.impl.ContractTargetManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractTargetManagerTest extends BaseManagerTestCase {
    private final String contractTargetId = "1";
    private ContractTargetManagerImpl contractTargetManager = new ContractTargetManagerImpl();
    private Mock contractTargetDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        contractTargetDao = new Mock(ContractTargetDao.class);
        contractTargetManager.setContractTargetDao((ContractTargetDao) contractTargetDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        contractTargetManager = null;
    }

    public void testGetContractTargets() throws Exception {
        List results = new ArrayList();
        ContractTarget contractTarget = new ContractTarget();
        results.add(contractTarget);

        // set expected behavior on dao
        contractTargetDao.expects(once()).method("getContractTargets")
            .will(returnValue(results));

        List contractTargets = contractTargetManager.getContractTargets(null);
        assertTrue(contractTargets.size() == 1);
        contractTargetDao.verify();
    }

    public void testGetContractTarget() throws Exception {
        // set expected behavior on dao
        contractTargetDao.expects(once()).method("getContractTarget")
            .will(returnValue(new ContractTarget()));
        ContractTarget contractTarget = contractTargetManager.getContractTarget(contractTargetId);
        assertTrue(contractTarget != null);
        contractTargetDao.verify();
    }

    public void testSaveContractTarget() throws Exception {
        ContractTarget contractTarget = new ContractTarget();

        // set expected behavior on dao
        contractTargetDao.expects(once()).method("saveContractTarget")
            .with(same(contractTarget)).isVoid();

        contractTargetManager.saveContractTarget(contractTarget);
        contractTargetDao.verify();
    }

    public void testAddAndRemoveContractTarget() throws Exception {
        ContractTarget contractTarget = new ContractTarget();

        // set required fields

        // set expected behavior on dao
        contractTargetDao.expects(once()).method("saveContractTarget")
            .with(same(contractTarget)).isVoid();
        contractTargetManager.saveContractTarget(contractTarget);
        contractTargetDao.verify();

        // reset expectations
        contractTargetDao.reset();

        contractTargetDao.expects(once()).method("removeContractTarget").with(eq(new Long(contractTargetId)));
        contractTargetManager.removeContractTarget(contractTargetId);
        contractTargetDao.verify();

        // reset expectations
        contractTargetDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ContractTarget.class, contractTarget.getId());
        contractTargetDao.expects(once()).method("removeContractTarget").isVoid();
        contractTargetDao.expects(once()).method("getContractTarget").will(throwException(ex));
        contractTargetManager.removeContractTarget(contractTargetId);
        try {
            contractTargetManager.getContractTarget(contractTargetId);
            fail("ContractTarget with identifier '" + contractTargetId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        contractTargetDao.verify();
    }
}
