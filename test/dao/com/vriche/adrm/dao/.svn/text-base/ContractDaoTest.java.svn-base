package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.model.Contract;

public class ContractDaoTest extends BaseDaoTestCase {
    private Long contractId = new Long("1");
    private ContractDao dao = null;

    public void setContractDao(ContractDao dao) {
        this.dao = dao;
    }

    public void testAddContract() throws Exception {
        Contract contract = new Contract();

        // set required fields

        dao.saveContract(contract);

        // verify a primary key was assigned
        assertNotNull(contract.getId());

        // verify set fields are same after save
    }

    public void testGetContract() throws Exception {
        Contract contract = dao.getContract(contractId);
        System.out.println(contract.getOrders().size());

        int results = contract.getOrders().size();
        
        assertTrue(results > 0);
        
        assertNotNull(contract);
    }

    public void testGetContracts() throws Exception {
        Contract contract = new Contract();

        List results = dao.getContracts(contract);
        assertTrue(results.size() > 0);
    }

    public void testSaveContract() throws Exception {
        Contract contract = dao.getContract(contractId);

        // update required fields

        dao.saveContract(contract);

    }

    public void testRemoveContract() throws Exception {
        Long removeId = new Long("3");
        dao.removeContract(removeId);
        try {
            dao.getContract(removeId);
            fail("contract found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveContracts(final Map idList) throws Exception {
        try {
        	dao.removeContracts(idList);
            fail("contract found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
