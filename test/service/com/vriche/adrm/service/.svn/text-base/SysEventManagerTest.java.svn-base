
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysEventDao;
import com.vriche.adrm.model.SysEvent;
import com.vriche.adrm.service.impl.SysEventManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventManagerTest extends BaseManagerTestCase {
    private final String sysEventId = "1";
    private SysEventManagerImpl sysEventManager = new SysEventManagerImpl();
    private Mock sysEventDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysEventDao = new Mock(SysEventDao.class);
        sysEventManager.setSysEventDao((SysEventDao) sysEventDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysEventManager = null;
    }

    public void testGetSysEvents() throws Exception {
        List results = new ArrayList();
        SysEvent sysEvent = new SysEvent();
        results.add(sysEvent);

        // set expected behavior on dao
        sysEventDao.expects(once()).method("getSysEvents")
            .will(returnValue(results));

        List sysEvents = sysEventManager.getSysEvents(null);
        assertTrue(sysEvents.size() == 1);
        sysEventDao.verify();
    }

    public void testGetSysEvent() throws Exception {
        // set expected behavior on dao
        sysEventDao.expects(once()).method("getSysEvent")
            .will(returnValue(new SysEvent()));
        SysEvent sysEvent = sysEventManager.getSysEvent(sysEventId);
        assertTrue(sysEvent != null);
        sysEventDao.verify();
    }

    public void testSaveSysEvent() throws Exception {
        SysEvent sysEvent = new SysEvent();

        // set expected behavior on dao
        sysEventDao.expects(once()).method("saveSysEvent")
            .with(same(sysEvent)).isVoid();

        sysEventManager.saveSysEvent(sysEvent);
        sysEventDao.verify();
    }

    public void testAddAndRemoveSysEvent() throws Exception {
        SysEvent sysEvent = new SysEvent();

        // set required fields

        // set expected behavior on dao
        sysEventDao.expects(once()).method("saveSysEvent")
            .with(same(sysEvent)).isVoid();
        sysEventManager.saveSysEvent(sysEvent);
        sysEventDao.verify();

        // reset expectations
        sysEventDao.reset();

        sysEventDao.expects(once()).method("removeSysEvent").with(eq(new Long(sysEventId)));
        sysEventManager.removeSysEvent(sysEventId);
        sysEventDao.verify();

        // reset expectations
        sysEventDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysEvent.class, sysEvent.getId());
        sysEventDao.expects(once()).method("removeSysEvent").isVoid();
        sysEventDao.expects(once()).method("getSysEvent").will(throwException(ex));
        sysEventManager.removeSysEvent(sysEventId);
        try {
            sysEventManager.getSysEvent(sysEventId);
            fail("SysEvent with identifier '" + sysEventId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysEventDao.verify();
    }
}
