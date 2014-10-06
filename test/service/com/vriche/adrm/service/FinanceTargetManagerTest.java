
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.FinanceTargetDao;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.service.impl.FinanceTargetManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class FinanceTargetManagerTest extends BaseManagerTestCase {
    private final String financeTargetId = "1";
    private FinanceTargetManagerImpl financeTargetManager = new FinanceTargetManagerImpl();
    private Mock financeTargetDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        financeTargetDao = new Mock(FinanceTargetDao.class);
        financeTargetManager.setFinanceTargetDao((FinanceTargetDao) financeTargetDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        financeTargetManager = null;
    }

//    public void testGetFinanceTargets() throws Exception {
//        List results = new ArrayList();
//        FinanceTarget financeTarget = new FinanceTarget();
//        results.add(financeTarget);
//
//        // set expected behavior on dao
//        financeTargetDao.expects(once()).method("getFinanceTargets")
//            .will(returnValue(results));
//
//        List financeTargets = financeTargetManager.getFinanceTargets(null);
//        assertTrue(financeTargets.size() == 1);
//        financeTargetDao.verify();
//    }

    public void testGetFinanceTarget() throws Exception {
        // set expected behavior on dao
        financeTargetDao.expects(once()).method("getFinanceTarget")
            .will(returnValue(new FinanceTarget()));
        FinanceTarget financeTarget = financeTargetManager.getFinanceTarget(financeTargetId);
        assertTrue(financeTarget != null);
        financeTargetDao.verify();
    }

    public void testSaveFinanceTarget() throws Exception {
        FinanceTarget financeTarget = new FinanceTarget();

        // set expected behavior on dao
        financeTargetDao.expects(once()).method("saveFinanceTarget")
            .with(same(financeTarget)).isVoid();

        financeTargetManager.saveFinanceTarget(financeTarget);
        financeTargetDao.verify();
    }

    public void testAddAndRemoveFinanceTarget() throws Exception {
        FinanceTarget financeTarget = new FinanceTarget();

        // set required fields
        financeTarget.setTargetDateYear(new Integer(1518071802));
        financeTarget.setTargetDateMonth(new Integer(927986812));
        financeTarget.setTargetMoney(new Double(1.3609847801750004E308));

        // set expected behavior on dao
        financeTargetDao.expects(once()).method("saveFinanceTarget")
            .with(same(financeTarget)).isVoid();
        financeTargetManager.saveFinanceTarget(financeTarget);
        financeTargetDao.verify();

        // reset expectations
        financeTargetDao.reset();

        financeTargetDao.expects(once()).method("removeFinanceTarget").with(eq(new Long(financeTargetId)));
        financeTargetManager.removeFinanceTarget(financeTargetId);
        financeTargetDao.verify();

        // reset expectations
        financeTargetDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(FinanceTarget.class, financeTarget.getId());
        financeTargetDao.expects(once()).method("removeFinanceTarget").isVoid();
        financeTargetDao.expects(once()).method("getFinanceTarget").will(throwException(ex));
        financeTargetManager.removeFinanceTarget(financeTargetId);
        try {
            financeTargetManager.getFinanceTarget(financeTargetId);
            fail("FinanceTarget with identifier '" + financeTargetId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        financeTargetDao.verify();
    }
}
