
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.IncomeUsedDao;
import com.vriche.adrm.model.IncomeUsed;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.IncomeUsedManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomeUsedManagerTest extends BaseManagerTestCase {
    private final String incomeUsedId = "1";
    private IncomeUsedManagerImpl incomeUsedManager = new IncomeUsedManagerImpl();
    private Mock incomeUsedDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        incomeUsedDao = new Mock(IncomeUsedDao.class);
        incomeUsedManager.setIncomeUsedDao((IncomeUsedDao) incomeUsedDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        incomeUsedManager = null;
    }

    public void testGetIncomeUseds() throws Exception {
        List results = new ArrayList();
        IncomeUsed incomeUsed = new IncomeUsed();
        results.add(incomeUsed);

        // set expected behavior on dao
        incomeUsedDao.expects(once()).method("getIncomeUseds")
            .will(returnValue(results));

        List incomeUseds = incomeUsedManager.getIncomeUseds(null);
        assertTrue(incomeUseds.size() == 1);
        incomeUsedDao.verify();
    }

    public void testGetIncomeUsed() throws Exception {
        // set expected behavior on dao
        incomeUsedDao.expects(once()).method("getIncomeUsed")
            .will(returnValue(new IncomeUsed()));
        IncomeUsed incomeUsed = incomeUsedManager.getIncomeUsed(incomeUsedId);
        assertTrue(incomeUsed != null);
        incomeUsedDao.verify();
    }

    public void testSaveIncomeUsed() throws Exception {
        IncomeUsed incomeUsed = new IncomeUsed();

        // set expected behavior on dao
        incomeUsedDao.expects(once()).method("saveIncomeUsed")
            .with(same(incomeUsed)).isVoid();

        incomeUsedManager.saveIncomeUsed(incomeUsed);
        incomeUsedDao.verify();
    }

    public void testAddAndRemoveIncomeUsed() throws Exception {
        IncomeUsed incomeUsed = new IncomeUsed();

        // set required fields

        // set expected behavior on dao
        incomeUsedDao.expects(once()).method("saveIncomeUsed")
            .with(same(incomeUsed)).isVoid();
        incomeUsedManager.saveIncomeUsed(incomeUsed);
        incomeUsedDao.verify();

        // reset expectations
        incomeUsedDao.reset();

        incomeUsedDao.expects(once()).method("removeIncomeUsed").with(eq(new Long(incomeUsedId)));
        incomeUsedManager.removeIncomeUsed(incomeUsedId);
        incomeUsedDao.verify();

        // reset expectations
        incomeUsedDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(IncomeUsed.class, incomeUsed.getId());
        incomeUsedDao.expects(once()).method("removeIncomeUsed").isVoid();
        incomeUsedDao.expects(once()).method("getIncomeUsed").will(throwException(ex));
        incomeUsedManager.removeIncomeUsed(incomeUsedId);
        try {
            incomeUsedManager.getIncomeUsed(incomeUsedId);
            fail("IncomeUsed with identifier '" + incomeUsedId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        incomeUsedDao.verify();
    }
}
