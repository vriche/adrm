
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysPromptModeDao;
import com.vriche.adrm.model.SysPromptMode;
import com.vriche.adrm.service.impl.SysPromptModeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysPromptModeManagerTest extends BaseManagerTestCase {
    private final String sysPromptModeId = "1";
    private SysPromptModeManagerImpl sysPromptModeManager = new SysPromptModeManagerImpl();
    private Mock sysPromptModeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysPromptModeDao = new Mock(SysPromptModeDao.class);
        sysPromptModeManager.setSysPromptModeDao((SysPromptModeDao) sysPromptModeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysPromptModeManager = null;
    }

    public void testGetSysPromptModes() throws Exception {
        List results = new ArrayList();
        SysPromptMode sysPromptMode = new SysPromptMode();
        results.add(sysPromptMode);

        // set expected behavior on dao
        sysPromptModeDao.expects(once()).method("getSysPromptModes")
            .will(returnValue(results));

        List sysPromptModes = sysPromptModeManager.getSysPromptModes(null);
        assertTrue(sysPromptModes.size() == 1);
        sysPromptModeDao.verify();
    }

    public void testGetSysPromptMode() throws Exception {
        // set expected behavior on dao
        sysPromptModeDao.expects(once()).method("getSysPromptMode")
            .will(returnValue(new SysPromptMode()));
        SysPromptMode sysPromptMode = sysPromptModeManager.getSysPromptMode(sysPromptModeId);
        assertTrue(sysPromptMode != null);
        sysPromptModeDao.verify();
    }

    public void testSaveSysPromptMode() throws Exception {
        SysPromptMode sysPromptMode = new SysPromptMode();

        // set expected behavior on dao
        sysPromptModeDao.expects(once()).method("saveSysPromptMode")
            .with(same(sysPromptMode)).isVoid();

        sysPromptModeManager.saveSysPromptMode(sysPromptMode);
        sysPromptModeDao.verify();
    }

    public void testAddAndRemoveSysPromptMode() throws Exception {
        SysPromptMode sysPromptMode = new SysPromptMode();

        // set required fields

        // set expected behavior on dao
        sysPromptModeDao.expects(once()).method("saveSysPromptMode")
            .with(same(sysPromptMode)).isVoid();
        sysPromptModeManager.saveSysPromptMode(sysPromptMode);
        sysPromptModeDao.verify();

        // reset expectations
        sysPromptModeDao.reset();

        sysPromptModeDao.expects(once()).method("removeSysPromptMode").with(eq(new Long(sysPromptModeId)));
        sysPromptModeManager.removeSysPromptMode(sysPromptModeId);
        sysPromptModeDao.verify();

        // reset expectations
        sysPromptModeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysPromptMode.class, sysPromptMode.getId());
        sysPromptModeDao.expects(once()).method("removeSysPromptMode").isVoid();
        sysPromptModeDao.expects(once()).method("getSysPromptMode").will(throwException(ex));
        sysPromptModeManager.removeSysPromptMode(sysPromptModeId);
        try {
            sysPromptModeManager.getSysPromptMode(sysPromptModeId);
            fail("SysPromptMode with identifier '" + sysPromptModeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysPromptModeDao.verify();
    }
}
