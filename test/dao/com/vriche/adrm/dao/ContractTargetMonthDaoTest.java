package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ContractTargetMonth;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractTargetMonthDaoTest extends BaseDaoTestCase {
    private Long contractTargetMonthId = new Long("1");
    private ContractTargetMonthDao dao = null;

    public void setContractTargetMonthDao(ContractTargetMonthDao dao) {
        this.dao = dao;
    }

    public void testAddContractTargetMonth() throws Exception {
        ContractTargetMonth contractTargetMonth = new ContractTargetMonth();

        // set required fields

        java.lang.Integer monthDate = new Integer(195076612);
        contractTargetMonth.setMonthDate(monthDate);        

        java.lang.Double monthTarg = new Double(1.1371319567365498E308);
        contractTargetMonth.setMonthTarg(monthTarg);        

        java.lang.Double monthReal = new Double(1.1864778764302845E308);
        contractTargetMonth.setMonthReal(monthReal);        

        dao.saveContractTargetMonth(contractTargetMonth);

        // verify a primary key was assigned
        assertNotNull(contractTargetMonth.getId());

        // verify set fields are same after save
        assertEquals(monthDate, contractTargetMonth.getMonthDate());
        assertEquals(monthTarg, contractTargetMonth.getMonthTarg());
        assertEquals(monthReal, contractTargetMonth.getMonthReal());
    }

    public void testGetContractTargetMonth() throws Exception {
        ContractTargetMonth contractTargetMonth = dao.getContractTargetMonth(contractTargetMonthId);
        assertNotNull(contractTargetMonth);
    }

    public void testGetContractTargetMonths() throws Exception {
        ContractTargetMonth contractTargetMonth = new ContractTargetMonth();

        List results = dao.getContractTargetMonths(contractTargetMonth);
        assertTrue(results.size() > 0);
    }

    public void testSaveContractTargetMonth() throws Exception {
        ContractTargetMonth contractTargetMonth = dao.getContractTargetMonth(contractTargetMonthId);

        // update required fields
        java.lang.Integer monthDate = new Integer(1871208183);
        contractTargetMonth.setMonthDate(monthDate);        
        java.lang.Double monthTarg = new Double(1.6151365573846028E308);
        contractTargetMonth.setMonthTarg(monthTarg);        
        java.lang.Double monthReal = new Double(5.277369427836959E307);
        contractTargetMonth.setMonthReal(monthReal);        

        dao.saveContractTargetMonth(contractTargetMonth);

        assertEquals(monthDate, contractTargetMonth.getMonthDate());
        assertEquals(monthTarg, contractTargetMonth.getMonthTarg());
        assertEquals(monthReal, contractTargetMonth.getMonthReal());
    }

    public void testRemoveContractTargetMonth() throws Exception {
        Long removeId = new Long("3");
        dao.removeContractTargetMonth(removeId);
        try {
            dao.getContractTargetMonth(removeId);
            fail("contractTargetMonth found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveContractTargetMonths(final Map idList) throws Exception {
        try {
        	dao.removeContractTargetMonths(idList);
            fail("contractTargetMonth found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
