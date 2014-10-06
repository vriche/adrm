
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.IncomeModeDao;
import com.vriche.adrm.model.IncomeMode;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.IncomeModeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomeModeManagerTest extends BaseManagerTestCase {
    private final String incomeModeId = "1";
    private IncomeModeManagerImpl incomeModeManager = new IncomeModeManagerImpl();
    private Mock incomeModeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        incomeModeDao = new Mock(IncomeModeDao.class);
        incomeModeManager.setIncomeModeDao((IncomeModeDao) incomeModeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        incomeModeManager = null;
    }

    public void testGetIncomeModes() throws Exception {
        List results = new ArrayList();
        IncomeMode incomeMode = new IncomeMode();
        results.add(incomeMode);

        // set expected behavior on dao
        incomeModeDao.expects(once()).method("getIncomeModes")
            .will(returnValue(results));

        List incomeModes = incomeModeManager.getIncomeModes(null);
        assertTrue(incomeModes.size() == 1);
        incomeModeDao.verify();
    }

    public void testGetIncomeMode() throws Exception {
        // set expected behavior on dao
        incomeModeDao.expects(once()).method("getIncomeMode")
            .will(returnValue(new IncomeMode()));
        IncomeMode incomeMode = incomeModeManager.getIncomeMode(incomeModeId);
        assertTrue(incomeMode != null);
        incomeModeDao.verify();
    }

    public void testSaveIncomeMode() throws Exception {
        IncomeMode incomeMode = new IncomeMode();

        // set expected behavior on dao
        incomeModeDao.expects(once()).method("saveIncomeMode")
            .with(same(incomeMode)).isVoid();

        incomeModeManager.saveIncomeMode(incomeMode);
        incomeModeDao.verify();
    }

    public void testAddAndRemoveIncomeMode() throws Exception {
        IncomeMode incomeMode = new IncomeMode();

        // set required fields

        // set expected behavior on dao
        incomeModeDao.expects(once()).method("saveIncomeMode")
            .with(same(incomeMode)).isVoid();
        incomeModeManager.saveIncomeMode(incomeMode);
        incomeModeDao.verify();

        // reset expectations
        incomeModeDao.reset();

        incomeModeDao.expects(once()).method("removeIncomeMode").with(eq(new Long(incomeModeId)));
        incomeModeManager.removeIncomeMode(incomeModeId);
        incomeModeDao.verify();

        // reset expectations
        incomeModeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(IncomeMode.class, incomeMode.getId());
        incomeModeDao.expects(once()).method("removeIncomeMode").isVoid();
        incomeModeDao.expects(once()).method("getIncomeMode").will(throwException(ex));
        incomeModeManager.removeIncomeMode(incomeModeId);
        try {
            incomeModeManager.getIncomeMode(incomeModeId);
            fail("IncomeMode with identifier '" + incomeModeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        incomeModeDao.verify();
    }
}
