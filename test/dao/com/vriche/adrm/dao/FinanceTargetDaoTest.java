package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.FinanceTarget;

import org.springframework.orm.ObjectRetrievalFailureException;

public class FinanceTargetDaoTest extends BaseDaoTestCase {
    private Long financeTargetId = new Long("1");
    private FinanceTargetDao dao = null;

    public void setFinanceTargetDao(FinanceTargetDao dao) {
        this.dao = dao;
    }

    public void testAddFinanceTarget() throws Exception {
        FinanceTarget financeTarget = new FinanceTarget();

        // set required fields

        java.lang.Integer targetDateYear = new Integer(1426004665);
        financeTarget.setTargetDateYear(targetDateYear);        

        java.lang.Integer targetDateMonth = new Integer(351052407);
        financeTarget.setTargetDateMonth(targetDateMonth);        

        java.lang.Double targetMoney = new Double(1.155201779466784E308);
        financeTarget.setTargetMoney(targetMoney);        

        dao.saveFinanceTarget(financeTarget);

        // verify a primary key was assigned
        assertNotNull(financeTarget.getId());

        // verify set fields are same after save
        assertEquals(targetDateYear, financeTarget.getTargetDateYear());
        assertEquals(targetDateMonth, financeTarget.getTargetDateMonth());
        assertEquals(targetMoney, financeTarget.getTargetMoney());
    }

    public void testGetFinanceTarget() throws Exception {
        FinanceTarget financeTarget = dao.getFinanceTarget(financeTargetId);
        assertNotNull(financeTarget);
    }

    public void testGetFinanceTargets() throws Exception {
        FinanceTarget financeTarget = new FinanceTarget();

        List results = dao.getFinanceTargets(financeTarget);
        assertTrue(results.size() > 0);
    }

    public void testSaveFinanceTarget() throws Exception {
        FinanceTarget financeTarget = dao.getFinanceTarget(financeTargetId);

        // update required fields
        java.lang.Integer targetDateYear = new Integer(729208905);
        financeTarget.setTargetDateYear(targetDateYear);        
        java.lang.Integer targetDateMonth = new Integer(2011367713);
        financeTarget.setTargetDateMonth(targetDateMonth);        
        java.lang.Double targetMoney = new Double(1.3618516151759861E308);
        financeTarget.setTargetMoney(targetMoney);        

        dao.saveFinanceTarget(financeTarget);

        assertEquals(targetDateYear, financeTarget.getTargetDateYear());
        assertEquals(targetDateMonth, financeTarget.getTargetDateMonth());
        assertEquals(targetMoney, financeTarget.getTargetMoney());
    }

    public void testRemoveFinanceTarget() throws Exception {
        Long removeId = new Long("3");
        dao.removeFinanceTarget(removeId);
        try {
            dao.getFinanceTarget(removeId);
            fail("financeTarget found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveFinanceTargets(final Map idList) throws Exception {
        try {
        	dao.removeFinanceTargets(idList);
            fail("financeTarget found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
