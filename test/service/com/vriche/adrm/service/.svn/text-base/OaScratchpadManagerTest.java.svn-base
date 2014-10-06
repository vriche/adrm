
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaScratchpadDao;
import com.vriche.adrm.model.OaScratchpad;
import com.vriche.adrm.service.impl.OaScratchpadManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaScratchpadManagerTest extends BaseManagerTestCase {
    private final String oaScratchpadId = "1";
    private OaScratchpadManagerImpl oaScratchpadManager = new OaScratchpadManagerImpl();
    private Mock oaScratchpadDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaScratchpadDao = new Mock(OaScratchpadDao.class);
        oaScratchpadManager.setOaScratchpadDao((OaScratchpadDao) oaScratchpadDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaScratchpadManager = null;
    }

    public void testGetOaScratchpads() throws Exception {
        List results = new ArrayList();
        OaScratchpad oaScratchpad = new OaScratchpad();
        results.add(oaScratchpad);

        // set expected behavior on dao
        oaScratchpadDao.expects(once()).method("getOaScratchpads")
            .will(returnValue(results));

        List oaScratchpads = oaScratchpadManager.getOaScratchpads(null);
        assertTrue(oaScratchpads.size() == 1);
        oaScratchpadDao.verify();
    }

    public void testGetOaScratchpad() throws Exception {
        // set expected behavior on dao
        oaScratchpadDao.expects(once()).method("getOaScratchpad")
            .will(returnValue(new OaScratchpad()));
        OaScratchpad oaScratchpad = oaScratchpadManager.getOaScratchpad(oaScratchpadId);
        assertTrue(oaScratchpad != null);
        oaScratchpadDao.verify();
    }

    public void testSaveOaScratchpad() throws Exception {
        OaScratchpad oaScratchpad = new OaScratchpad();

        // set expected behavior on dao
        oaScratchpadDao.expects(once()).method("saveOaScratchpad")
            .with(same(oaScratchpad)).isVoid();

        oaScratchpadManager.saveOaScratchpad(oaScratchpad);
        oaScratchpadDao.verify();
    }

    public void testAddAndRemoveOaScratchpad() throws Exception {
        OaScratchpad oaScratchpad = new OaScratchpad();

        // set required fields

        // set expected behavior on dao
        oaScratchpadDao.expects(once()).method("saveOaScratchpad")
            .with(same(oaScratchpad)).isVoid();
        oaScratchpadManager.saveOaScratchpad(oaScratchpad);
        oaScratchpadDao.verify();

        // reset expectations
        oaScratchpadDao.reset();

        oaScratchpadDao.expects(once()).method("removeOaScratchpad").with(eq(new Long(oaScratchpadId)));
        oaScratchpadManager.removeOaScratchpad(oaScratchpadId);
        oaScratchpadDao.verify();

        // reset expectations
        oaScratchpadDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaScratchpad.class, oaScratchpad.getId());
        oaScratchpadDao.expects(once()).method("removeOaScratchpad").isVoid();
        oaScratchpadDao.expects(once()).method("getOaScratchpad").will(throwException(ex));
        oaScratchpadManager.removeOaScratchpad(oaScratchpadId);
        try {
            oaScratchpadManager.getOaScratchpad(oaScratchpadId);
            fail("OaScratchpad with identifier '" + oaScratchpadId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaScratchpadDao.verify();
    }
}
