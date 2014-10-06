
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaTeleExpensesDao;
import com.vriche.adrm.model.OaTeleExpenses;
import com.vriche.adrm.service.impl.OaTeleExpensesManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaTeleExpensesManagerTest extends BaseManagerTestCase {
    private final String oaTeleExpensesId = "1";
    private OaTeleExpensesManagerImpl oaTeleExpensesManager = new OaTeleExpensesManagerImpl();
    private Mock oaTeleExpensesDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaTeleExpensesDao = new Mock(OaTeleExpensesDao.class);
        oaTeleExpensesManager.setOaTeleExpensesDao((OaTeleExpensesDao) oaTeleExpensesDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaTeleExpensesManager = null;
    }

    public void testGetOaTeleExpensess() throws Exception {
        List results = new ArrayList();
        OaTeleExpenses oaTeleExpenses = new OaTeleExpenses();
        results.add(oaTeleExpenses);

        // set expected behavior on dao
        oaTeleExpensesDao.expects(once()).method("getOaTeleExpensess")
            .will(returnValue(results));

        List oaTeleExpensess = oaTeleExpensesManager.getOaTeleExpensess(null);
        assertTrue(oaTeleExpensess.size() == 1);
        oaTeleExpensesDao.verify();
    }

    public void testGetOaTeleExpenses() throws Exception {
        // set expected behavior on dao
        oaTeleExpensesDao.expects(once()).method("getOaTeleExpenses")
            .will(returnValue(new OaTeleExpenses()));
        OaTeleExpenses oaTeleExpenses = oaTeleExpensesManager.getOaTeleExpenses(oaTeleExpensesId);
        assertTrue(oaTeleExpenses != null);
        oaTeleExpensesDao.verify();
    }

    public void testSaveOaTeleExpenses() throws Exception {
        OaTeleExpenses oaTeleExpenses = new OaTeleExpenses();

        // set expected behavior on dao
        oaTeleExpensesDao.expects(once()).method("saveOaTeleExpenses")
            .with(same(oaTeleExpenses)).isVoid();

        oaTeleExpensesManager.saveOaTeleExpenses(oaTeleExpenses);
        oaTeleExpensesDao.verify();
    }

    public void testAddAndRemoveOaTeleExpenses() throws Exception {
        OaTeleExpenses oaTeleExpenses = new OaTeleExpenses();

        // set required fields
        oaTeleExpenses.setExpenses(new Double(9.140568158819655E307));
        oaTeleExpenses.setRegisterDate(new Integer(1341968832));
        oaTeleExpenses.setBranchId(new Long(1795347116));

        // set expected behavior on dao
        oaTeleExpensesDao.expects(once()).method("saveOaTeleExpenses")
            .with(same(oaTeleExpenses)).isVoid();
        oaTeleExpensesManager.saveOaTeleExpenses(oaTeleExpenses);
        oaTeleExpensesDao.verify();

        // reset expectations
        oaTeleExpensesDao.reset();

        oaTeleExpensesDao.expects(once()).method("removeOaTeleExpenses").with(eq(new Long(oaTeleExpensesId)));
        oaTeleExpensesManager.removeOaTeleExpenses(oaTeleExpensesId);
        oaTeleExpensesDao.verify();

        // reset expectations
        oaTeleExpensesDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaTeleExpenses.class, oaTeleExpenses.getId());
        oaTeleExpensesDao.expects(once()).method("removeOaTeleExpenses").isVoid();
        oaTeleExpensesDao.expects(once()).method("getOaTeleExpenses").will(throwException(ex));
        oaTeleExpensesManager.removeOaTeleExpenses(oaTeleExpensesId);
        try {
            oaTeleExpensesManager.getOaTeleExpenses(oaTeleExpensesId);
            fail("OaTeleExpenses with identifier '" + oaTeleExpensesId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaTeleExpensesDao.verify();
    }
}
