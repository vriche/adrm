package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysPromptMode;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysPromptModeDaoTest extends BaseDaoTestCase {
    private Long sysPromptModeId = new Long("1");
    private SysPromptModeDao dao = null;

    public void setSysPromptModeDao(SysPromptModeDao dao) {
        this.dao = dao;
    }

    public void testAddSysPromptMode() throws Exception {
        SysPromptMode sysPromptMode = new SysPromptMode();

        // set required fields

        dao.saveSysPromptMode(sysPromptMode);

        // verify a primary key was assigned
        assertNotNull(sysPromptMode.getId());

        // verify set fields are same after save
    }

    public void testGetSysPromptMode() throws Exception {
        SysPromptMode sysPromptMode = dao.getSysPromptMode(sysPromptModeId);
        assertNotNull(sysPromptMode);
    }

    public void testGetSysPromptModes() throws Exception {
        SysPromptMode sysPromptMode = new SysPromptMode();

        List results = dao.getSysPromptModes(sysPromptMode);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysPromptMode() throws Exception {
        SysPromptMode sysPromptMode = dao.getSysPromptMode(sysPromptModeId);

        // update required fields

        dao.saveSysPromptMode(sysPromptMode);

    }

    public void testRemoveSysPromptMode() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysPromptMode(removeId);
        try {
            dao.getSysPromptMode(removeId);
            fail("sysPromptMode found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysPromptModes(final Map idList) throws Exception {
        try {
        	dao.removeSysPromptModes(idList);
            fail("sysPromptMode found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
