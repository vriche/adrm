package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaTeleExpenses;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaTeleExpensesDaoTest extends BaseDaoTestCase {
    private Long oaTeleExpensesId = new Long("1");
    private OaTeleExpensesDao dao = null;

    public void setOaTeleExpensesDao(OaTeleExpensesDao dao) {
        this.dao = dao;
    }

    public void testAddOaTeleExpenses() throws Exception {
        OaTeleExpenses oaTeleExpenses = new OaTeleExpenses();

        // set required fields

        java.lang.Double expenses = new Double(5.814804926101348E307);
        oaTeleExpenses.setExpenses(expenses);        

        java.lang.Integer registerDate = new Integer(1641276893);
        oaTeleExpenses.setRegisterDate(registerDate);        

        java.lang.Long branchId = new Long(1463679628);
        oaTeleExpenses.setBranchId(branchId);        

        dao.saveOaTeleExpenses(oaTeleExpenses);

        // verify a primary key was assigned
        assertNotNull(oaTeleExpenses.getId());

        // verify set fields are same after save
        assertEquals(expenses, oaTeleExpenses.getExpenses());
        assertEquals(registerDate, oaTeleExpenses.getRegisterDate());
        assertEquals(branchId, oaTeleExpenses.getBranchId());
    }

    public void testGetOaTeleExpenses() throws Exception {
        OaTeleExpenses oaTeleExpenses = dao.getOaTeleExpenses(oaTeleExpensesId);
        assertNotNull(oaTeleExpenses);
    }

    public void testGetOaTeleExpensess() throws Exception {
        OaTeleExpenses oaTeleExpenses = new OaTeleExpenses();

        List results = dao.getOaTeleExpensess(oaTeleExpenses);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaTeleExpenses() throws Exception {
        OaTeleExpenses oaTeleExpenses = dao.getOaTeleExpenses(oaTeleExpensesId);

        // update required fields
        java.lang.Double expenses = new Double(3.394707886390674E307);
        oaTeleExpenses.setExpenses(expenses);        
        java.lang.Integer registerDate = new Integer(718815187);
        oaTeleExpenses.setRegisterDate(registerDate);        
        java.lang.Long branchId = new Long(545294370);
        oaTeleExpenses.setBranchId(branchId);        

        dao.saveOaTeleExpenses(oaTeleExpenses);

        assertEquals(expenses, oaTeleExpenses.getExpenses());
        assertEquals(registerDate, oaTeleExpenses.getRegisterDate());
        assertEquals(branchId, oaTeleExpenses.getBranchId());
    }

    public void testRemoveOaTeleExpenses() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaTeleExpenses(removeId);
        try {
            dao.getOaTeleExpenses(removeId);
            fail("oaTeleExpenses found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaTeleExpensess(final Map idList) throws Exception {
        try {
        	dao.removeOaTeleExpensess(idList);
            fail("oaTeleExpenses found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
