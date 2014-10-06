package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysEventState;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventStateDaoTest extends BaseDaoTestCase {
    private Long sysEventStateId = new Long("1");
    private SysEventStateDao dao = null;

    public void setSysEventStateDao(SysEventStateDao dao) {
        this.dao = dao;
    }

    public void testAddSysEventState() throws Exception {
        SysEventState sysEventState = new SysEventState();

        // set required fields

        dao.saveSysEventState(sysEventState);

        // verify a primary key was assigned
        assertNotNull(sysEventState.getId());

        // verify set fields are same after save
    }

    public void testGetSysEventState() throws Exception {
        SysEventState sysEventState = dao.getSysEventState(sysEventStateId);
        assertNotNull(sysEventState);
    }

    public void testGetSysEventStates() throws Exception {
        SysEventState sysEventState = new SysEventState();

        List results = dao.getSysEventStates(sysEventState);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysEventState() throws Exception {
        SysEventState sysEventState = dao.getSysEventState(sysEventStateId);

        // update required fields

        dao.saveSysEventState(sysEventState);

    }

    public void testRemoveSysEventState() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysEventState(removeId);
        try {
            dao.getSysEventState(removeId);
            fail("sysEventState found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysEventStates(final Map idList) throws Exception {
        try {
        	dao.removeSysEventStates(idList);
            fail("sysEventState found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
