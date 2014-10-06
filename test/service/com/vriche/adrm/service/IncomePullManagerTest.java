
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.model.IncomePull;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.IncomePullManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomePullManagerTest extends BaseManagerTestCase {
    private final String incomePullId = "1";
    private IncomePullManagerImpl incomePullManager = new IncomePullManagerImpl();
    private Mock incomePullDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        incomePullDao = new Mock(IncomePullDao.class);
        incomePullManager.setIncomePullDao((IncomePullDao) incomePullDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        incomePullManager = null;
    }

    public void testGetIncomePulls() throws Exception {
        List results = new ArrayList();
        IncomePull incomePull = new IncomePull();
        results.add(incomePull);

        // set expected behavior on dao
        incomePullDao.expects(once()).method("getIncomePulls")
            .will(returnValue(results));

        List incomePulls = incomePullManager.getIncomePulls(null);
        assertTrue(incomePulls.size() == 1);
        incomePullDao.verify();
    }

    public void testGetIncomePull() throws Exception {
        // set expected behavior on dao
        incomePullDao.expects(once()).method("getIncomePull")
            .will(returnValue(new IncomePull()));
        IncomePull incomePull = incomePullManager.getIncomePull(incomePullId);
        assertTrue(incomePull != null);
        incomePullDao.verify();
    }

    public void testSaveIncomePull() throws Exception {
        IncomePull incomePull = new IncomePull();

        // set expected behavior on dao
        incomePullDao.expects(once()).method("saveIncomePull")
            .with(same(incomePull)).isVoid();

        incomePullManager.saveIncomePull(incomePull);
        incomePullDao.verify();
    }

    public void testAddAndRemoveIncomePull() throws Exception {
        IncomePull incomePull = new IncomePull();

        // set required fields

        // set expected behavior on dao
        incomePullDao.expects(once()).method("saveIncomePull")
            .with(same(incomePull)).isVoid();
        incomePullManager.saveIncomePull(incomePull);
        incomePullDao.verify();

        // reset expectations
        incomePullDao.reset();

        incomePullDao.expects(once()).method("removeIncomePull").with(eq(new Long(incomePullId)));
        incomePullManager.removeIncomePull(incomePullId);
        incomePullDao.verify();

        // reset expectations
        incomePullDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(IncomePull.class, incomePull.getId());
        incomePullDao.expects(once()).method("removeIncomePull").isVoid();
        incomePullDao.expects(once()).method("getIncomePull").will(throwException(ex));
        incomePullManager.removeIncomePull(incomePullId);
        try {
            incomePullManager.getIncomePull(incomePullId);
            fail("IncomePull with identifier '" + incomePullId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        incomePullDao.verify();
    }
}
