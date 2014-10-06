package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysEventType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysEventTypeDaoTest extends BaseDaoTestCase {
    private Long sysEventTypeId = new Long("1");
    private SysEventTypeDao dao = null;

    public void setSysEventTypeDao(SysEventTypeDao dao) {
        this.dao = dao;
    }

    public void testAddSysEventType() throws Exception {
        SysEventType sysEventType = new SysEventType();

        // set required fields

        dao.saveSysEventType(sysEventType);

        // verify a primary key was assigned
        assertNotNull(sysEventType.getId());

        // verify set fields are same after save
    }

    public void testGetSysEventType() throws Exception {
        SysEventType sysEventType = dao.getSysEventType(sysEventTypeId);
        assertNotNull(sysEventType);
    }

    public void testGetSysEventTypes() throws Exception {
        SysEventType sysEventType = new SysEventType();

        List results = dao.getSysEventTypes(sysEventType);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysEventType() throws Exception {
        SysEventType sysEventType = dao.getSysEventType(sysEventTypeId);

        // update required fields

        dao.saveSysEventType(sysEventType);

    }

    public void testRemoveSysEventType() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysEventType(removeId);
        try {
            dao.getSysEventType(removeId);
            fail("sysEventType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysEventTypes(final Map idList) throws Exception {
        try {
        	dao.removeSysEventTypes(idList);
            fail("sysEventType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
