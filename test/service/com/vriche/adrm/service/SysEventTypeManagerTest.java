
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysEventTypeDao;
import com.vriche.adrm.model.SysEventType;
import com.vriche.adrm.service.impl.SysEventTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventTypeManagerTest extends BaseManagerTestCase {
    private final String sysEventTypeId = "1";
    private SysEventTypeManagerImpl sysEventTypeManager = new SysEventTypeManagerImpl();
    private Mock sysEventTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysEventTypeDao = new Mock(SysEventTypeDao.class);
        sysEventTypeManager.setSysEventTypeDao((SysEventTypeDao) sysEventTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysEventTypeManager = null;
    }

    public void testGetSysEventTypes() throws Exception {
        List results = new ArrayList();
        SysEventType sysEventType = new SysEventType();
        results.add(sysEventType);

        // set expected behavior on dao
        sysEventTypeDao.expects(once()).method("getSysEventTypes")
            .will(returnValue(results));

        List sysEventTypes = sysEventTypeManager.getSysEventTypes(null);
        assertTrue(sysEventTypes.size() == 1);
        sysEventTypeDao.verify();
    }

    public void testGetSysEventType() throws Exception {
        // set expected behavior on dao
        sysEventTypeDao.expects(once()).method("getSysEventType")
            .will(returnValue(new SysEventType()));
        SysEventType sysEventType = sysEventTypeManager.getSysEventType(sysEventTypeId);
        assertTrue(sysEventType != null);
        sysEventTypeDao.verify();
    }

    public void testSaveSysEventType() throws Exception {
        SysEventType sysEventType = new SysEventType();

        // set expected behavior on dao
        sysEventTypeDao.expects(once()).method("saveSysEventType")
            .with(same(sysEventType)).isVoid();

        sysEventTypeManager.saveSysEventType(sysEventType);
        sysEventTypeDao.verify();
    }

    public void testAddAndRemoveSysEventType() throws Exception {
        SysEventType sysEventType = new SysEventType();

        // set required fields

        // set expected behavior on dao
        sysEventTypeDao.expects(once()).method("saveSysEventType")
            .with(same(sysEventType)).isVoid();
        sysEventTypeManager.saveSysEventType(sysEventType);
        sysEventTypeDao.verify();

        // reset expectations
        sysEventTypeDao.reset();

        sysEventTypeDao.expects(once()).method("removeSysEventType").with(eq(new Long(sysEventTypeId)));
        sysEventTypeManager.removeSysEventType(sysEventTypeId);
        sysEventTypeDao.verify();

        // reset expectations
        sysEventTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysEventType.class, sysEventType.getId());
        sysEventTypeDao.expects(once()).method("removeSysEventType").isVoid();
        sysEventTypeDao.expects(once()).method("getSysEventType").will(throwException(ex));
        sysEventTypeManager.removeSysEventType(sysEventTypeId);
        try {
            sysEventTypeManager.getSysEventType(sysEventTypeId);
            fail("SysEventType with identifier '" + sysEventTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysEventTypeDao.verify();
    }
}
