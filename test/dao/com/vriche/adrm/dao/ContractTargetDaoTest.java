package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ContractTarget;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractTargetDaoTest extends BaseDaoTestCase {
    private Long contractTargetId = new Long("1");
    private ContractTargetDao dao = null;

    public void setContractTargetDao(ContractTargetDao dao) {
        this.dao = dao;
    }

    public void testAddContractTarget() throws Exception {
        ContractTarget contractTarget = new ContractTarget();

        // set required fields

        dao.saveContractTarget(contractTarget);

        // verify a primary key was assigned
        assertNotNull(contractTarget.getId());

        // verify set fields are same after save
    }

    public void testGetContractTarget() throws Exception {
        ContractTarget contractTarget = dao.getContractTarget(contractTargetId);
        assertNotNull(contractTarget);
    }

    public void testGetContractTargets() throws Exception {
        ContractTarget contractTarget = new ContractTarget();

        List results = dao.getContractTargets(contractTarget);
        assertTrue(results.size() > 0);
    }

    public void testSaveContractTarget() throws Exception {
        ContractTarget contractTarget = dao.getContractTarget(contractTargetId);

        // update required fields

        dao.saveContractTarget(contractTarget);

    }

    public void testRemoveContractTarget() throws Exception {
        Long removeId = new Long("3");
        dao.removeContractTarget(removeId);
        try {
            dao.getContractTarget(removeId);
            fail("contractTarget found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveContractTargets(final Map idList) throws Exception {
        try {
        	dao.removeContractTargets(idList);
            fail("contractTarget found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
