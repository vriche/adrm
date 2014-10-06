package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysEvent;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventDaoTest extends BaseDaoTestCase {
    private Long sysEventId = new Long("1");
    private SysEventDao dao = null;

    public void setSysEventDao(SysEventDao dao) {
        this.dao = dao;
    }

    public void testAddSysEvent() throws Exception {
        SysEvent sysEvent = new SysEvent();

        // set required fields

        dao.saveSysEvent(sysEvent);

        // verify a primary key was assigned
        assertNotNull(sysEvent.getId());

        // verify set fields are same after save
    }

    public void testGetSysEvent() throws Exception {
        SysEvent sysEvent = dao.getSysEvent(sysEventId);
        assertNotNull(sysEvent);
    }

    public void testGetSysEvents() throws Exception {
        SysEvent sysEvent = new SysEvent();

        List results = dao.getSysEvents(sysEvent);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysEvent() throws Exception {
        SysEvent sysEvent = dao.getSysEvent(sysEventId);

        // update required fields

        dao.saveSysEvent(sysEvent);

    }

    public void testRemoveSysEvent() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysEvent(removeId);
        try {
            dao.getSysEvent(removeId);
            fail("sysEvent found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysEvents(final Map idList) throws Exception {
        try {
        	dao.removeSysEvents(idList);
            fail("sysEvent found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
