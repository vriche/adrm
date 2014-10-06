package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysSequence;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysSequenceDaoTest extends BaseDaoTestCase {
    private String sysSequenceId = new String("1");
    private SysSequenceDao dao = null;

    public void setSysSequenceDao(SysSequenceDao dao) {
        this.dao = dao;
    }

    public void testAddSysSequence() throws Exception {
        SysSequence sysSequence = new SysSequence();

        // set required fields
        java.lang.String sequenceID = "HxPwKvQsTlJhYwAsPdAzPxLiG";
        sysSequence.setId(new Long(1));

        dao.saveSysSequence(sysSequence);

        // verify a primary key was assigned
        assertNotNull(sysSequence.getId());

        // verify set fields are same after save
    }

    public void testGetSysSequence() throws Exception {
        SysSequence sysSequence = dao.getSysSequence(sysSequenceId);
        assertNotNull(sysSequence);
    }

    public void testGetSysSequences() throws Exception {
        SysSequence sysSequence = new SysSequence();
        //set value for primary key
        sysSequence.setId(new Long(1));

        List results = dao.getSysSequences(sysSequence);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysSequence() throws Exception {
        SysSequence sysSequence = dao.getSysSequence(sysSequenceId);

        // update required fields

        dao.saveSysSequence(sysSequence);

    }

    public void testRemoveSysSequence() throws Exception {
        String removeId = new String("3");
        dao.removeSysSequence(removeId);
        try {
            dao.getSysSequence(removeId);
            fail("sysSequence found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysSequences(final Map idList) throws Exception {
        try {
        	dao.removeSysSequences(idList);
            fail("sysSequence found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
