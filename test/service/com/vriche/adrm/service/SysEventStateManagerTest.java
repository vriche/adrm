
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysEventStateDao;
import com.vriche.adrm.model.SysEventState;
import com.vriche.adrm.service.impl.SysEventStateManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventStateManagerTest extends BaseManagerTestCase {
    private final String sysEventStateId = "1";
    private SysEventStateManagerImpl sysEventStateManager = new SysEventStateManagerImpl();
    private Mock sysEventStateDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysEventStateDao = new Mock(SysEventStateDao.class);
        sysEventStateManager.setSysEventStateDao((SysEventStateDao) sysEventStateDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysEventStateManager = null;
    }

    public void testGetSysEventStates() throws Exception {
        List results = new ArrayList();
        SysEventState sysEventState = new SysEventState();
        results.add(sysEventState);

        // set expected behavior on dao
        sysEventStateDao.expects(once()).method("getSysEventStates")
            .will(returnValue(results));

        List sysEventStates = sysEventStateManager.getSysEventStates(null);
        assertTrue(sysEventStates.size() == 1);
        sysEventStateDao.verify();
    }

    public void testGetSysEventState() throws Exception {
        // set expected behavior on dao
        sysEventStateDao.expects(once()).method("getSysEventState")
            .will(returnValue(new SysEventState()));
        SysEventState sysEventState = sysEventStateManager.getSysEventState(sysEventStateId);
        assertTrue(sysEventState != null);
        sysEventStateDao.verify();
    }

    public void testSaveSysEventState() throws Exception {
        SysEventState sysEventState = new SysEventState();

        // set expected behavior on dao
        sysEventStateDao.expects(once()).method("saveSysEventState")
            .with(same(sysEventState)).isVoid();

        sysEventStateManager.saveSysEventState(sysEventState);
        sysEventStateDao.verify();
    }

    public void testAddAndRemoveSysEventState() throws Exception {
        SysEventState sysEventState = new SysEventState();

        // set required fields

        // set expected behavior on dao
        sysEventStateDao.expects(once()).method("saveSysEventState")
            .with(same(sysEventState)).isVoid();
        sysEventStateManager.saveSysEventState(sysEventState);
        sysEventStateDao.verify();

        // reset expectations
        sysEventStateDao.reset();

        sysEventStateDao.expects(once()).method("removeSysEventState").with(eq(new Long(sysEventStateId)));
        sysEventStateManager.removeSysEventState(sysEventStateId);
        sysEventStateDao.verify();

        // reset expectations
        sysEventStateDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysEventState.class, sysEventState.getId());
        sysEventStateDao.expects(once()).method("removeSysEventState").isVoid();
        sysEventStateDao.expects(once()).method("getSysEventState").will(throwException(ex));
        sysEventStateManager.removeSysEventState(sysEventStateId);
        try {
            sysEventStateManager.getSysEventState(sysEventStateId);
            fail("SysEventState with identifier '" + sysEventStateId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysEventStateDao.verify();
    }
}
