
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysSequenceDao;
import com.vriche.adrm.model.SysSequence;
import com.vriche.adrm.service.impl.SysSequenceManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysSequenceManagerTest extends BaseManagerTestCase {
    private final String sysSequenceId = "1";
    private SysSequenceManagerImpl sysSequenceManager = new SysSequenceManagerImpl();
    private Mock sysSequenceDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysSequenceDao = new Mock(SysSequenceDao.class);
        sysSequenceManager.setSysSequenceDao((SysSequenceDao) sysSequenceDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysSequenceManager = null;
    }

    public void testGetSysSequences() throws Exception {
        List results = new ArrayList();
        SysSequence sysSequence = new SysSequence();
        results.add(sysSequence);

        // set expected behavior on dao
        sysSequenceDao.expects(once()).method("getSysSequences")
            .will(returnValue(results));

        List sysSequences = sysSequenceManager.getSysSequences(null);
        assertTrue(sysSequences.size() == 1);
        sysSequenceDao.verify();
    }

    public void testGetSysSequence() throws Exception {
        // set expected behavior on dao
        sysSequenceDao.expects(once()).method("getSysSequence")
            .will(returnValue(new SysSequence()));
        SysSequence sysSequence = sysSequenceManager.getSysSequence(sysSequenceId);
        assertTrue(sysSequence != null);
        sysSequenceDao.verify();
    }

    public void testSaveSysSequence() throws Exception {
        SysSequence sysSequence = new SysSequence();

        // set expected behavior on dao
        sysSequenceDao.expects(once()).method("saveSysSequence")
            .with(same(sysSequence)).isVoid();

        sysSequenceManager.saveSysSequence(sysSequence);
        sysSequenceDao.verify();
    }

    public void testAddAndRemoveSysSequence() throws Exception {
        SysSequence sysSequence = new SysSequence();

        // set required fields

        // set expected behavior on dao
        sysSequenceDao.expects(once()).method("saveSysSequence")
            .with(same(sysSequence)).isVoid();
        sysSequenceManager.saveSysSequence(sysSequence);
        sysSequenceDao.verify();

        // reset expectations
        sysSequenceDao.reset();

        sysSequenceDao.expects(once()).method("removeSysSequence").with(eq(new String(sysSequenceId)));
        sysSequenceManager.removeSysSequence(sysSequenceId);
        sysSequenceDao.verify();

        // reset expectations
        sysSequenceDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysSequence.class, sysSequence.getId());
        sysSequenceDao.expects(once()).method("removeSysSequence").isVoid();
        sysSequenceDao.expects(once()).method("getSysSequence").will(throwException(ex));
        sysSequenceManager.removeSysSequence(sysSequenceId);
        try {
            sysSequenceManager.getSysSequence(sysSequenceId);
            fail("SysSequence with identifier '" + sysSequenceId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysSequenceDao.verify();
    }
}
